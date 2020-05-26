package glm_.gtx

import glm_.mat2x2.Mat2
import glm_.mat3x3.Mat3
import glm_.mat4x4.Mat4
import glm_.vec2.Vec2
import glm_.vec3.Vec3
import glm_.vec4.Vec4

interface gtxMatrixOperation {

    fun diagonal2x2(v: Vec2, res: Mat2 = Mat2()): Mat2 {
        res put 1f
        res[0, 0] = v[0]
        res[1, 1] = v[1]
        return res
    }

    //TODO other intermediate

    fun diagonal3x3(v: Vec3, res: Mat3 = Mat3()): Mat3 {
        res put 1f
        res[0, 0] = v[0]
        res[1, 1] = v[1]
        res[2, 2] = v[2]
        return res
    }

    fun diagonal4x4(v: Vec4, res: Mat4 = Mat4()): Mat4 {
        res put 1f
        res[0, 0] = v[0]
        res[1, 1] = v[1]
        res[2, 2] = v[2]
        res[3, 3] = v[3]
        return res
    }

    fun adjugate(m: Mat2, res: Mat2 = Mat2()): Mat2 =
            res(
                    +m[1, 1], -m[1, 0],
                    -m[0, 1], +m[0, 0])

    fun adjugate(m: Mat3, res: Mat3 = Mat3()): Mat3 {
        val m00 = determinant(m[1, 1], m[2, 1], m[1, 2], m[2, 2])
        val m01 = determinant(m[0, 1], m[2, 1], m[0, 2], m[2, 2])
        val m02 = determinant(m[0, 1], m[1, 1], m[0, 2], m[1, 2])

        val m10 = determinant(m[1, 0], m[2, 0], m[1, 2], m[2, 2])
        val m11 = determinant(m[0, 0], m[2, 0], m[0, 2], m[2, 2])
        val m12 = determinant(m[0, 0], m[1, 0], m[0, 2], m[1, 2])

        val m20 = determinant(m[1, 0], m[2, 0], m[1, 1], m[2, 1])
        val m21 = determinant(m[0, 0], m[2, 0], m[0, 1], m[2, 1])
        val m22 = determinant(m[0, 0], m[1, 0], m[0, 1], m[1, 1])

        return res(
                +m00, -m01, +m02,
                -m10, +m11, -m12,
                +m20, -m21, +m22)
    }

    private fun determinant(a: Float, b: Float, c: Float, d: Float) = a * d - c * b

    fun adjugate(m: Mat4, res: Mat4 = Mat4()): Mat4 {

        val m00 = determinant(m[1, 1], m[1, 2], m[1, 3], m[2, 1], m[2, 2], m[2, 3], m[3, 1], m[3, 2], m[3, 3])
        val m01 = determinant(m[1, 0], m[1, 2], m[1, 3], m[2, 0], m[2, 2], m[2, 3], m[3, 0], m[3, 2], m[3, 3])
        val m02 = determinant(m[1, 0], m[1, 1], m[1, 3], m[2, 0], m[2, 2], m[2, 3], m[3, 0], m[3, 1], m[3, 3])
        val m03 = determinant(m[1, 0], m[1, 1], m[1, 2], m[2, 0], m[2, 1], m[2, 2], m[3, 0], m[3, 1], m[3, 2])

        val m10 = determinant(m[0, 1], m[0, 2], m[0, 3], m[2, 1], m[2, 2], m[2, 3], m[3, 1], m[3, 2], m[3, 3])
        val m11 = determinant(m[0, 0], m[0, 2], m[0, 3], m[2, 0], m[2, 2], m[2, 3], m[3, 0], m[3, 2], m[3, 3])
        val m12 = determinant(m[0, 0], m[0, 1], m[0, 3], m[2, 0], m[2, 1], m[2, 3], m[3, 0], m[3, 1], m[3, 3])
        val m13 = determinant(m[0, 0], m[0, 1], m[0, 2], m[2, 0], m[2, 1], m[2, 2], m[3, 0], m[3, 1], m[3, 2])

        val m20 = determinant(m[0, 1], m[0, 2], m[0, 3], m[1, 1], m[1, 2], m[1, 3], m[3, 1], m[3, 2], m[3, 3])
        val m21 = determinant(m[0, 0], m[0, 2], m[0, 3], m[1, 0], m[1, 2], m[1, 3], m[3, 0], m[3, 2], m[3, 3])
        val m22 = determinant(m[0, 0], m[0, 1], m[0, 3], m[1, 0], m[1, 1], m[1, 3], m[3, 0], m[3, 1], m[3, 3])
        val m23 = determinant(m[0, 0], m[0, 1], m[0, 2], m[1, 0], m[1, 1], m[1, 2], m[3, 0], m[3, 1], m[3, 2])

        val m30 = determinant(m[0, 1], m[0, 2], m[0, 3], m[1, 1], m[1, 2], m[1, 3], m[2, 1], m[2, 2], m[2, 3])
        val m31 = determinant(m[0, 0], m[0, 2], m[0, 3], m[1, 0], m[1, 2], m[1, 3], m[2, 0], m[2, 2], m[2, 3])
        val m32 = determinant(m[0, 0], m[0, 1], m[0, 3], m[1, 0], m[1, 1], m[1, 3], m[2, 0], m[2, 1], m[2, 3])
        val m33 = determinant(m[0, 0], m[0, 1], m[0, 2], m[1, 0], m[1, 1], m[1, 2], m[2, 0], m[2, 1], m[2, 2])

        return res(
                +m00, -m01, +m02, -m03,
                -m10, +m11, -m12, +m13,
                +m20, -m21, +m22, -m23,
                -m30, +m31, -m32, +m33)
    }

    private fun determinant(
            a: Float, b: Float, c: Float,
            d: Float, e: Float, f: Float,
            g: Float, h: Float, i: Float): Float =

            a * (e * i - h * f) -
                    d * (b * i - h * c) +
                    g * (b * f - e * c)
}