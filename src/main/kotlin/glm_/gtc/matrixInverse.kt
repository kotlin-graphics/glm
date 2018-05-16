package glm_.gtc

import glm_.mat2x2.Mat2
import glm_.mat3x3.Mat3
import glm_.mat4x4.Mat4

interface gtcMatrixInverse {

//    fun affineInverse(mat<3, 3, T, P> const & m)
//    {
//        mat < 2, 2, T, P> const Inv(inverse(mat<2, 2, T, P>(m)))
//
//        return mat < 3, 3, T, P>(
//        vec < 3, T, P>(Inv[0], static_cast<T>(0)),
//        vec < 3, T, P>(Inv[1], static_cast<T>(0)),
//        vec < 3, T, P>(-Inv * vec<2, T, P>(m[2]), static_cast<T>(1)))
//    }
//
//    template<typename T, precision P>
//    GLM_FUNC_QUALIFIER mat<4, 4, T, P> affineInverse(mat<4, 4, T, P> const & m)
//    {
//        mat < 3, 3, T, P> const Inv(inverse(mat<3, 3, T, P>(m)))
//
//        return mat < 4, 4, T, P>(
//        vec < 4, T, P>(Inv[0], static_cast<T>(0)),
//        vec < 4, T, P>(Inv[1], static_cast<T>(0)),
//        vec < 4, T, P>(Inv[2], static_cast<T>(0)),
//        vec < 4, T, P>(-Inv * vec<3, T, P>(m[3]), static_cast<T>(1)))
//    }

    fun inverseTranspose(res: Mat2, m: Mat2): Mat2 {

        val determinant = m[0, 0] * m[1, 1] - m[1, 0] * m[0, 1]

        return res(
                +m[1, 1] / determinant,
                -m[0, 1] / determinant,
                -m[1, 0] / determinant,
                +m[0, 0] / determinant)
    }

    fun inverseTranspose(res: Mat3, m: Mat3): Mat3 {

        val determinant =
                +m[0, 0] * (m[1, 1] * m[2, 2] - m[1, 2] * m[2, 1])
        -m[0, 1] * (m[1, 0] * m[2, 2] - m[1, 2] * m[2, 0])
        +m[0, 2] * (m[1, 0] * m[2, 1] - m[1, 1] * m[2, 0])

        res(
                +(m[1, 1] * m[2, 2] - m[2, 1] * m[1, 2]),
                -(m[1, 0] * m[2, 2] - m[2, 0] * m[1, 2]),
                +(m[1, 0] * m[2, 1] - m[2, 0] * m[1, 1]),
                -(m[0, 1] * m[2, 2] - m[2, 1] * m[0, 2]),
                +(m[0, 0] * m[2, 2] - m[2, 0] * m[0, 2]),
                -(m[0, 0] * m[2, 1] - m[2, 0] * m[0, 1]),
                +(m[0, 1] * m[1, 2] - m[1, 1] * m[0, 2]),
                -(m[0, 0] * m[1, 2] - m[1, 0] * m[0, 2]),
                +(m[0, 0] * m[1, 1] - m[1, 0] * m[0, 1]))
        res /= determinant

        return res
    }

    fun inverseTranspose(res: Mat4, m: Mat4): Mat4 {
        val subFactor00 = m[2, 2] * m[3, 3] - m[3, 2] * m[2, 3]
        val subFactor01 = m[2, 1] * m[3, 3] - m[3, 1] * m[2, 3]
        val subFactor02 = m[2, 1] * m[3, 2] - m[3, 1] * m[2, 2]
        val subFactor03 = m[2, 0] * m[3, 3] - m[3, 0] * m[2, 3]
        val subFactor04 = m[2, 0] * m[3, 2] - m[3, 0] * m[2, 2]
        val subFactor05 = m[2, 0] * m[3, 1] - m[3, 0] * m[2, 1]
        val subFactor06 = m[1, 2] * m[3, 3] - m[3, 2] * m[1, 3]
        val subFactor07 = m[1, 1] * m[3, 3] - m[3, 1] * m[1, 3]
        val subFactor08 = m[1, 1] * m[3, 2] - m[3, 1] * m[1, 2]
        val subFactor09 = m[1, 0] * m[3, 3] - m[3, 0] * m[1, 3]
        val subFactor10 = m[1, 0] * m[3, 2] - m[3, 0] * m[1, 2]
        val subFactor11 = m[1, 1] * m[3, 3] - m[3, 1] * m[1, 3]
        val subFactor12 = m[1, 0] * m[3, 1] - m[3, 0] * m[1, 1]
        val subFactor13 = m[1, 2] * m[2, 3] - m[2, 2] * m[1, 3]
        val subFactor14 = m[1, 1] * m[2, 3] - m[2, 1] * m[1, 3]
        val subFactor15 = m[1, 1] * m[2, 2] - m[2, 1] * m[1, 2]
        val subFactor16 = m[1, 0] * m[2, 3] - m[2, 0] * m[1, 3]
        val subFactor17 = m[1, 0] * m[2, 2] - m[2, 0] * m[1, 2]
        val subFactor18 = m[1, 0] * m[2, 1] - m[2, 0] * m[1, 1]

        res.put(
                +(m[1, 1] * subFactor00 - m[1, 2] * subFactor01 + m[1, 3] * subFactor02),
                -(m[1, 0] * subFactor00 - m[1, 2] * subFactor03 + m[1, 3] * subFactor04),
                +(m[1, 0] * subFactor01 - m[1, 1] * subFactor03 + m[1, 3] * subFactor05),
                -(m[1, 0] * subFactor02 - m[1, 1] * subFactor04 + m[1, 2] * subFactor05),

                -(m[0, 1] * subFactor00 - m[0, 2] * subFactor01 + m[0, 3] * subFactor02),
                +(m[0, 0] * subFactor00 - m[0, 2] * subFactor03 + m[0, 3] * subFactor04),
                -(m[0, 0] * subFactor01 - m[0, 1] * subFactor03 + m[0, 3] * subFactor05),
                +(m[0, 0] * subFactor02 - m[0, 1] * subFactor04 + m[0, 2] * subFactor05),

                +(m[0, 1] * subFactor06 - m[0, 2] * subFactor07 + m[0, 3] * subFactor08),
                -(m[0, 0] * subFactor06 - m[0, 2] * subFactor09 + m[0, 3] * subFactor10),
                +(m[0, 0] * subFactor11 - m[0, 1] * subFactor09 + m[0, 3] * subFactor12),
                -(m[0, 0] * subFactor08 - m[0, 1] * subFactor10 + m[0, 2] * subFactor12),

                -(m[0, 1] * subFactor13 - m[0, 2] * subFactor14 + m[0, 3] * subFactor15),
                +(m[0, 0] * subFactor13 - m[0, 2] * subFactor16 + m[0, 3] * subFactor17),
                -(m[0, 0] * subFactor14 - m[0, 1] * subFactor16 + m[0, 3] * subFactor18),
                +(m[0, 0] * subFactor15 - m[0, 1] * subFactor17 + m[0, 2] * subFactor18))

        val determinant =
                +m[0, 0] * res[0, 0]
        +m[0, 1] * res[0, 1]
        +m[0, 2] * res[0, 2]
        +m[0, 3] * res[0, 3]

        res /= determinant

        return res
    }
}