package  glm_.mat4x4.operators

import glm_.mat2x4.Mat2x4d
import glm_.mat3x4.Mat3x4d
import glm_.mat4x4.Mat4d
import glm_.mat4x4.Mat4d.Companion.div
import glm_.mat4x4.Mat4d.Companion.minus
import glm_.mat4x4.Mat4d.Companion.plus
import glm_.mat4x4.Mat4d.Companion.times
import glm_.vec4.Vec4d
import glm_.vec4.Vec4d.Companion.div
import glm_.vec4.Vec4d.Companion.minus
import glm_.vec4.Vec4d.Companion.plus
import glm_.vec4.Vec4d.Companion.times

/**
 * Created by GBarbieri on 10.11.2016.
 */
open class mat4d_operators {


    /** Mat4d = Mat4d + scalar */
    inline fun plus(res: Mat4d, a: Mat4d, b: Double): Mat4d {
        plus(res[0], a[0], b, b, b, b)
        plus(res[1], a[1], b, b, b, b)
        plus(res[2], a[2], b, b, b, b)
        plus(res[3], a[3], b, b, b, b)
        return res
    }

    /** Mat4d = Mat4d - scalar */
    inline fun minus(res: Mat4d, a: Mat4d, b: Double): Mat4d {
        minus(res[0], a[0], b, b, b, b)
        minus(res[1], a[1], b, b, b, b)
        minus(res[2], a[2], b, b, b, b)
        minus(res[3], a[3], b, b, b, b)
        return res
    }

    /** Mat4d = scalar - Mat4d   */
    inline fun minus(res: Mat4d, a: Double, b: Mat4d): Mat4d {
        minus(res[0], a, a, a, a, b[0])
        minus(res[1], a, a, a, a, b[1])
        minus(res[2], a, a, a, a, b[2])
        minus(res[3], a, a, a, a, b[3])
        return res
    }

    /** Mat4d = Mat4d * scalar */
    inline fun times(res: Mat4d, a: Mat4d, b: Double): Mat4d {
        times(res[0], a[0], b, b, b, b)
        times(res[1], a[1], b, b, b, b)
        times(res[2], a[2], b, b, b, b)
        times(res[3], a[3], b, b, b, b)
        return res
    }

    /** Mat4d = Mat4d / scalar */
    inline fun div(res: Mat4d, a: Mat4d, b: Double): Mat4d {
        div(res[0], a[0], b, b, b, b)
        div(res[1], a[1], b, b, b, b)
        div(res[2], a[2], b, b, b, b)
        div(res[3], a[3], b, b, b, b)
        return res
    }

    /** Mat4d = scalar / Mat4d */
    inline fun div(res: Mat4d, a: Double, b: Mat4d): Mat4d {
        div(res[0], a, a, a, a, b[0])
        div(res[1], a, a, a, a, b[1])
        div(res[2], a, a, a, a, b[2])
        div(res[3], a, a, a, a, b[3])
        return res
    }


    /** Mat4d = Mat4d + Mat4d */
    inline fun plus(res: Mat4d, a: Mat4d, b: Mat4d) = plus(res, a,
            b[0, 0], b[0, 1], b[0, 2], b[0, 3],
            b[1, 0], b[1, 1], b[1, 2], b[1, 3],
            b[2, 0], b[2, 1], b[2, 2], b[2, 3],
            b[3, 0], b[3, 1], b[3, 2], b[3, 3])

    /** Mat4d = Mat4d + Mat4d */
    inline fun plus(res: Mat4d, a: Mat4d, b0: Vec4d, b1: Vec4d, b2: Vec4d, b3: Vec4d) = plus(res, a,
            b0[0], b0[1], b0[2], b0[3],
            b1[0], b1[1], b1[2], b1[3],
            b2[0], b2[1], b2[2], b2[3],
            b3[0], b3[1], b3[2], b3[3])

    /** Mat4d = Mat4d + Mat4d */
    inline fun plus(res: Mat4d, a: Mat4d,
                    b00: Double, b01: Double, b02: Double, b03: Double,
                    b10: Double, b11: Double, b12: Double, b13: Double,
                    b20: Double, b21: Double, b22: Double, b23: Double,
                    b30: Double, b31: Double, b32: Double, b33: Double): Mat4d {
        plus(res[0], a[0], b00, b01, b02, b03)
        plus(res[1], a[1], b10, b11, b12, b13)
        plus(res[2], a[2], b20, b21, b22, b23)
        plus(res[3], a[3], b30, b31, b32, b33)
        return res
    }

    /** Mat4d = Mat4d - Mat4d */
    inline fun minus(res: Mat4d, a: Mat4d, b: Mat4d) = minus(res, a,
            b[0, 0], b[0, 1], b[0, 2], b[0, 3],
            b[1, 0], b[1, 1], b[1, 2], b[1, 3],
            b[2, 0], b[2, 1], b[2, 2], b[2, 3],
            b[3, 0], b[3, 1], b[3, 2], b[3, 3])

    /** Mat4d = Mat4d - Mat4d */
    inline fun minus(res: Mat4d, a: Mat4d, b0: Vec4d, b1: Vec4d, b2: Vec4d, b3: Vec4d) = minus(res, a,
            b0[0], b0[1], b0[2], b0[3],
            b1[0], b1[1], b1[2], b1[3],
            b2[0], b2[1], b2[2], b2[3],
            b3[0], b3[1], b3[2], b3[3])

    /** Mat4d = Mat4d - Mat4d */
    inline fun minus(res: Mat4d, a: Mat4d,
                     b00: Double, b01: Double, b02: Double, b03: Double,
                     b10: Double, b11: Double, b12: Double, b13: Double,
                     b20: Double, b21: Double, b22: Double, b23: Double,
                     b30: Double, b31: Double, b32: Double, b33: Double): Mat4d {
        minus(res[0], a[0], b00, b01, b02, b03)
        minus(res[1], a[1], b10, b11, b12, b13)
        minus(res[2], a[2], b20, b21, b22, b23)
        minus(res[3], a[3], b30, b31, b32, b33)
        return res
    }

    /** Mat4d = Mat4d - Mat4d */
    inline fun minus(res: Mat4d, a0: Vec4d, a1: Vec4d, a2: Vec4d, a3: Vec4d, b: Mat4d) = minus(res,
            a0[0], a0[1], a0[2], a0[3],
            a1[0], a1[1], a1[2], a1[3],
            a2[0], a2[1], a2[2], a2[3],
            a3[0], a3[1], a3[2], a3[3], b)

    /** Mat4d = Mat4d - Mat4d */
    inline fun minus(res: Mat4d,
                     a00: Double, a01: Double, a02: Double, a03: Double,
                     a10: Double, a11: Double, a12: Double, a13: Double,
                     a20: Double, a21: Double, a22: Double, a23: Double,
                     a30: Double, a31: Double, a32: Double, a33: Double, b: Mat4d): Mat4d {
        minus(res[0], a00, a01, a02, a03, b[0])
        minus(res[1], a10, a11, a12, a13, b[1])
        minus(res[2], a20, a21, a22, a23, b[2])
        minus(res[3], a30, a31, a32, a33, b[3])
        return res
    }


    /** Vec4d col = Mat4d * Vec4d row  */
    inline fun times(res: Vec4d, a: Mat4d, b: Vec4d) = times(res, a, b.x, b.y, b.z, b.w)

    /** Vec4d col = Mat4d * Vec4d row */
    inline fun times(res: Vec4d, a: Mat4d, b0: Double, b1: Double, b2: Double, b3: Double): Vec4d {
        res[0] = a[0, 0] * b0 + a[1, 0] * b1 + a[2, 0] * b2 + a[3, 0] * b3
        res[1] = a[0, 1] * b0 + a[1, 1] * b1 + a[2, 1] * b2 + a[3, 1] * b3
        res[2] = a[0, 2] * b0 + a[1, 2] * b1 + a[2, 2] * b2 + a[3, 2] * b3
        res[3] = a[0, 3] * b0 + a[1, 3] * b1 + a[2, 3] * b2 + a[3, 3] * b3
        return res
    }

    /** Vec4d row = Vec4d col * Mat4d  */
    inline fun times(res: Vec4d, a: Vec4d, b: Mat4d) = times(res, a.x, a.y, a.z, a.w, b)

    /** Vec4d row = Vec4d col * Mat4d  */
    inline fun times(res: Vec4d, a0: Double, a1: Double, a2: Double, a3: Double, b: Mat4d): Vec4d {
        res[0] = a0 * b[0, 0] + a1 * b[0, 1] + a2 * b[0, 2] + a3 * b[0, 3]
        res[1] = a0 * b[1, 0] + a1 * b[1, 1] + a2 * b[1, 2] + a3 * b[1, 3]
        res[2] = a0 * b[2, 0] + a1 * b[2, 1] + a2 * b[2, 2] + a3 * b[2, 3]
        res[3] = a0 * b[3, 0] + a1 * b[3, 1] + a2 * b[3, 2] + a3 * b[3, 3]
        return res
    }

    /** Mat4d = Mat4d * Mat4d */
    inline fun times(res: Mat4d, a: Mat4d, b: Mat4d) = times(res, a,
            b[0, 0], b[0, 1], b[0, 2], b[0, 3],
            b[1, 0], b[1, 1], b[1, 2], b[1, 3],
            b[2, 0], b[2, 1], b[2, 2], b[2, 3],
            b[3, 0], b[3, 1], b[3, 2], b[3, 3])

    /** Mat4d = Mat4d * Mat4d */
    inline fun times(res: Mat4d, a: Mat4d, b0: Vec4d, b1: Vec4d, b2: Vec4d, b3: Vec4d) = times(res, a,
            b0[0], b0[1], b0[2], b0[3],
            b1[0], b1[1], b1[2], b1[3],
            b2[0], b2[1], b2[2], b2[3],
            b3[0], b3[1], b3[2], b3[3])

    /** Mat4d = Mat4d * Mat4d */
    inline fun times(res: Mat4d, a: Mat4d,
                     b00: Double, b01: Double, b02: Double, b03: Double,
                     b10: Double, b11: Double, b12: Double, b13: Double,
                     b20: Double, b21: Double, b22: Double, b23: Double,
                     b30: Double, b31: Double, b32: Double, b33: Double): Mat4d {
        val v00 = a[0, 0] * b00 + a[1, 0] * b01 + a[2, 0] * b02 + a[3, 0] * b03
        val v01 = a[0, 1] * b00 + a[1, 1] * b01 + a[2, 1] * b02 + a[3, 1] * b03
        val v02 = a[0, 2] * b00 + a[1, 2] * b01 + a[2, 2] * b02 + a[3, 2] * b03
        val v03 = a[0, 3] * b00 + a[1, 3] * b01 + a[2, 3] * b02 + a[3, 3] * b03
        val v10 = a[0, 0] * b10 + a[1, 0] * b11 + a[2, 0] * b12 + a[3, 0] * b13
        val v11 = a[0, 1] * b10 + a[1, 1] * b11 + a[2, 1] * b12 + a[3, 1] * b13
        val v12 = a[0, 2] * b10 + a[1, 2] * b11 + a[2, 2] * b12 + a[3, 2] * b13
        val v13 = a[0, 3] * b10 + a[1, 3] * b11 + a[2, 3] * b12 + a[3, 3] * b13
        val v20 = a[0, 0] * b20 + a[1, 0] * b21 + a[2, 0] * b22 + a[3, 0] * b23
        val v21 = a[0, 1] * b20 + a[1, 1] * b21 + a[2, 1] * b22 + a[3, 1] * b23
        val v22 = a[0, 2] * b20 + a[1, 2] * b21 + a[2, 2] * b22 + a[3, 2] * b23
        val v23 = a[0, 3] * b20 + a[1, 3] * b21 + a[2, 3] * b22 + a[3, 3] * b23
        val v30 = a[0, 0] * b30 + a[1, 0] * b31 + a[2, 0] * b32 + a[3, 0] * b33
        val v31 = a[0, 1] * b30 + a[1, 1] * b31 + a[2, 1] * b32 + a[3, 1] * b33
        val v32 = a[0, 2] * b30 + a[1, 2] * b31 + a[2, 2] * b32 + a[3, 2] * b33
        val v33 = a[0, 3] * b30 + a[1, 3] * b31 + a[2, 3] * b32 + a[3, 3] * b33
        res[0, 0] = v00; res[1, 0] = v10; res[2, 0] = v20; res[3, 0] = v30
        res[0, 1] = v01; res[1, 1] = v11; res[2, 1] = v21; res[3, 1] = v31
        res[0, 2] = v02; res[1, 2] = v12; res[2, 2] = v22; res[3, 2] = v32
        res[0, 3] = v03; res[1, 3] = v13; res[2, 3] = v23; res[3, 3] = v33
        return res
    }


    /** Mat24d = Mat4d * Mat24d */
    inline fun times(res: Mat2x4d, a: Mat4d, b: Mat2x4d) = times(res, a, b[0], b[1])

    /** Mat24d = Mat4d * Mat24d */
    inline fun times(res: Mat2x4d, a: Mat4d, b0: Vec4d, b1: Vec4d) = times(res, a, b0.x, b0.y, b0.z, b0.w, b1.x, b1.y, b1.z, b1.w)

    /** Mat24d = Mat4d * Mat24d */
    inline fun times(res: Mat2x4d, a: Mat4d,
                     b00: Double, b01: Double, b02: Double, b03: Double,
                     b10: Double, b11: Double, b12: Double, b13: Double): Mat2x4d {
        val v00 = a[0, 0] * b00 + a[1, 0] * b01 + a[2, 0] * b02 + a[3, 0] * b03
        val v01 = a[0, 1] * b00 + a[1, 1] * b01 + a[2, 1] * b02 + a[3, 1] * b03
        val v02 = a[0, 2] * b00 + a[1, 2] * b01 + a[2, 2] * b02 + a[3, 2] * b03
        val v03 = a[0, 3] * b00 + a[1, 3] * b01 + a[2, 3] * b02 + a[3, 3] * b03
        val v10 = a[0, 0] * b10 + a[1, 0] * b11 + a[2, 0] * b12 + a[3, 0] * b13
        val v11 = a[0, 1] * b10 + a[1, 1] * b11 + a[2, 1] * b12 + a[3, 1] * b13
        val v12 = a[0, 2] * b10 + a[1, 2] * b11 + a[2, 2] * b12 + a[3, 2] * b13
        val v13 = a[0, 3] * b10 + a[1, 3] * b11 + a[2, 3] * b12 + a[3, 3] * b13
        res[0, 0] = v00; res[1, 0] = v10
        res[0, 1] = v01; res[1, 1] = v11
        res[0, 2] = v02; res[1, 2] = v12
        res[0, 3] = v03; res[1, 3] = v13
        return res
    }

    /** Mat34d = Mat4d * Mat34d */
    inline fun times(res: Mat3x4d, a: Mat4d, b: Mat3x4d) = times(res, a, b[0], b[1], b[2], b[3])

    /** Mat34d = Mat4d * Mat34d */
    inline fun times(res: Mat3x4d, a: Mat4d, b0: Vec4d, b1: Vec4d, b2: Vec4d, b3: Vec4d) = times(res, a,
            b0.x, b0.y, b0.z,
            b1.x, b1.y, b1.z,
            b2.x, b2.y, b2.z,
            b3.x, b3.y, b3.z)

    /** Mat34d = Mat4d * Mat34d */
    inline fun times(res: Mat3x4d, a: Mat4d,
                     b00: Double, b01: Double, b02: Double, b03: Double,
                     b10: Double, b11: Double, b12: Double, b13: Double,
                     b20: Double, b21: Double, b22: Double, b23: Double): Mat3x4d {
        val v00 = a[0, 0] * b00 + a[1, 0] * b01 + a[2, 0] * b02 + a[3, 0] * b03
        val v01 = a[0, 1] * b00 + a[1, 1] * b01 + a[2, 1] * b02 + a[3, 1] * b03
        val v02 = a[0, 2] * b00 + a[1, 2] * b01 + a[2, 2] * b02 + a[3, 2] * b03
        val v03 = a[0, 3] * b00 + a[1, 3] * b01 + a[2, 3] * b02 + a[3, 3] * b03
        val v10 = a[0, 0] * b10 + a[1, 0] * b11 + a[2, 0] * b12 + a[3, 0] * b13
        val v11 = a[0, 1] * b10 + a[1, 1] * b11 + a[2, 1] * b12 + a[3, 1] * b13
        val v12 = a[0, 2] * b10 + a[1, 2] * b11 + a[2, 2] * b12 + a[3, 2] * b13
        val v13 = a[0, 3] * b10 + a[1, 3] * b11 + a[2, 3] * b12 + a[3, 3] * b13
        val v20 = a[0, 0] * b20 + a[1, 0] * b21 + a[2, 0] * b22 + a[3, 0] * b23
        val v21 = a[0, 1] * b20 + a[1, 1] * b21 + a[2, 1] * b22 + a[3, 1] * b23
        val v22 = a[0, 2] * b20 + a[1, 2] * b21 + a[2, 2] * b22 + a[3, 2] * b23
        val v23 = a[0, 3] * b20 + a[1, 3] * b21 + a[2, 3] * b22 + a[3, 3] * b23
        res[0, 0] = v00; res[1, 0] = v10; res[2, 0] = v20
        res[0, 1] = v01; res[1, 1] = v11; res[2, 1] = v21
        res[0, 2] = v02; res[1, 2] = v12; res[2, 2] = v22
        res[0, 3] = v03; res[1, 3] = v13; res[2, 3] = v23
        return res
    }


    /** Mat4d = Mat4d / Mat4d = Mat4d * Mat4d^-1 */
    inline fun div(res: Mat4d, a: Mat4d, b: Mat4d) = div(res, a,
            b[0, 0], b[0, 1], b[0, 2], b[0, 3],
            b[1, 0], b[1, 1], b[1, 2], b[1, 3],
            b[2, 0], b[2, 1], b[2, 2], b[2, 3],
            b[3, 0], b[3, 1], b[3, 2], b[3, 3])

    /** Mat4d = Mat4d / Mat4d = Mat4d * Mat4d^-1 */
    inline fun div(res: Mat4d, a: Mat4d, b0: Vec4d, b1: Vec4d, b2: Vec4d, b3: Vec4d) = div(res, a,
            b0[0], b0[1], b0[2], b0[3],
            b1[0], b1[1], b1[2], b1[3],
            b2[0], b2[1], b2[2], b2[3],
            b3[0], b3[1], b3[2], b3[3])

    /** Mat4d = Mat4d / Mat4d = Mat4d * Mat4d^-1 */
    inline fun div(res: Mat4d, a: Mat4d,
                   b00: Double, b01: Double, b02: Double, b03: Double,
                   b10: Double, b11: Double, b12: Double, b13: Double,
                   b20: Double, b21: Double, b22: Double, b23: Double,
                   b30: Double, b31: Double, b32: Double, b33: Double): Mat4d {
        res[0, 0] = b00; res[1, 0] = b10; res[2, 0] = b20; res[3, 0] = b30
        res[0, 1] = b01; res[1, 1] = b11; res[2, 1] = b21; res[3, 1] = b31
        res[0, 2] = b02; res[1, 2] = b12; res[2, 2] = b22; res[3, 2] = b32
        res[0, 3] = b03; res[1, 3] = b13; res[2, 3] = b23; res[3, 3] = b33
        res.inverseAssign()
        a.times(res, res)
        return res
    }


    /** Vec4d col = Mat4d * Vec4d row  */
    inline fun div(res: Vec4d, a: Mat4d, b: Vec4d) = div(res, a, b.x, b.y, b.z, b.w)

    /** Vec4d col = Mat4d * Vec4d row  */
    inline fun div(res: Vec4d, a: Mat4d, b0: Double, b1: Double, b2: Double, b3: Double): Vec4d {
        // invert a
        val c00 = a[2, 2] * a[3, 3] - a[3, 2] * a[2, 3]
        val c02 = a[1, 2] * a[3, 3] - a[3, 2] * a[1, 3]
        val c03 = a[1, 2] * a[2, 3] - a[2, 2] * a[1, 3]

        val c04 = a[2, 1] * a[3, 3] - a[3, 1] * a[2, 3]
        val c06 = a[1, 1] * a[3, 3] - a[3, 1] * a[1, 3]
        val c07 = a[1, 1] * a[2, 3] - a[2, 1] * a[1, 3]

        val c08 = a[2, 1] * a[3, 2] - a[3, 1] * a[2, 2]
        val c10 = a[1, 1] * a[3, 2] - a[3, 1] * a[1, 2]
        val c11 = a[1, 1] * a[2, 2] - a[2, 1] * a[1, 2]

        val c12 = a[2, 0] * a[3, 3] - a[3, 0] * a[2, 3]
        val c14 = a[1, 0] * a[3, 3] - a[3, 0] * a[1, 3]
        val c15 = a[1, 0] * a[2, 3] - a[2, 0] * a[1, 3]

        val c16 = a[2, 0] * a[3, 2] - a[3, 0] * a[2, 2]
        val c18 = a[1, 0] * a[3, 2] - a[3, 0] * a[1, 2]
        val c19 = a[1, 0] * a[2, 2] - a[2, 0] * a[1, 2]

        val c20 = a[2, 0] * a[3, 1] - a[3, 0] * a[2, 1]
        val c22 = a[1, 0] * a[3, 1] - a[3, 0] * a[1, 1]
        val c23 = a[1, 0] * a[2, 1] - a[2, 0] * a[1, 1]

        var i00 = +(a[1, 1] * c00 - a[1, 2] * c04 + a[1, 3] * c08)
        var i01 = -(a[0, 1] * c00 - a[0, 2] * c04 + a[0, 3] * c08)
        var i02 = +(a[0, 1] * c02 - a[0, 2] * c06 + a[0, 3] * c10)
        var i03 = -(a[0, 1] * c03 - a[0, 2] * c07 + a[0, 3] * c11)

        var i10 = -(a[1, 0] * c00 - a[1, 2] * c12 + a[1, 3] * c16)
        var i11 = +(a[0, 0] * c00 - a[0, 2] * c12 + a[0, 3] * c16)
        var i12 = -(a[0, 0] * c02 - a[0, 2] * c14 + a[0, 3] * c18)
        var i13 = +(a[0, 0] * c03 - a[0, 2] * c15 + a[0, 3] * c19)

        var i20 = +(a[1, 0] * c04 - a[1, 1] * c12 + a[1, 3] * c20)
        var i21 = -(a[0, 0] * c04 - a[0, 1] * c12 + a[0, 3] * c20)
        var i22 = +(a[0, 0] * c06 - a[0, 1] * c14 + a[0, 3] * c22)
        var i23 = -(a[0, 0] * c07 - a[0, 1] * c15 + a[0, 3] * c23)

        var i30 = -(a[1, 0] * c08 - a[1, 1] * c16 + a[1, 2] * c20)
        var i31 = +(a[0, 0] * c08 - a[0, 1] * c16 + a[0, 2] * c20)
        var i32 = -(a[0, 0] * c10 - a[0, 1] * c18 + a[0, 2] * c22)
        var i33 = +(a[0, 0] * c11 - a[0, 1] * c19 + a[0, 2] * c23)

        val oneOverDet = 1 / (a[0, 0] * i00 + a[0, 1] * i10 + a[0, 2] * i20 + a[0, 3] * i30)

        i00 *= oneOverDet
        i01 *= oneOverDet
        i02 *= oneOverDet
        i03 *= oneOverDet

        i10 *= oneOverDet
        i11 *= oneOverDet
        i12 *= oneOverDet
        i13 *= oneOverDet

        i20 *= oneOverDet
        i21 *= oneOverDet
        i22 *= oneOverDet
        i23 *= oneOverDet

        i30 *= oneOverDet
        i31 *= oneOverDet
        i32 *= oneOverDet
        i33 *= oneOverDet

        // a * main.getB
        res[0] = i00 * b0 + i10 * b1 + i20 * b2 + i30 * b3
        res[1] = i01 * b0 + i11 * b1 + i21 * b2 + i31 * b3
        res[2] = i02 * b0 + i12 * b1 + i22 * b2 + i32 * b3
        res[3] = i03 * b0 + i13 * b1 + i23 * b2 + i33 * b3

        return res
    }

    /** Vec4d row = Vec4d col * Mat4d  */
    inline fun div(res: Vec4d, a: Vec4d, b: Mat4d) = div(res, a.x, a.y, a.z, a.w, b)

    /** Vec4d row = Vec4d col * Mat4d  */
    inline fun div(res: Vec4d, a0: Double, a1: Double, a2: Double, a3: Double, b: Mat4d): Vec4d {
        // invert main.getB
        val c00 = b[2, 2] * b[3, 3] - b[3, 2] * b[2, 3]
        val c02 = b[1, 2] * b[3, 3] - b[3, 2] * b[1, 3]
        val c03 = b[1, 2] * b[2, 3] - b[2, 2] * b[1, 3]

        val c04 = b[2, 1] * b[3, 3] - b[3, 1] * b[2, 3]
        val c06 = b[1, 1] * b[3, 3] - b[3, 1] * b[1, 3]
        val c07 = b[1, 1] * b[2, 3] - b[2, 1] * b[1, 3]

        val c08 = b[2, 1] * b[3, 2] - b[3, 1] * b[2, 2]
        val c10 = b[1, 1] * b[3, 2] - b[3, 1] * b[1, 2]
        val c11 = b[1, 1] * b[2, 2] - b[2, 1] * b[1, 2]

        val c12 = b[2, 0] * b[3, 3] - b[3, 0] * b[2, 3]
        val c14 = b[1, 0] * b[3, 3] - b[3, 0] * b[1, 3]
        val c15 = b[1, 0] * b[2, 3] - b[2, 0] * b[1, 3]

        val c16 = b[2, 0] * b[3, 2] - b[3, 0] * b[2, 2]
        val c18 = b[1, 0] * b[3, 2] - b[3, 0] * b[1, 2]
        val c19 = b[1, 0] * b[2, 2] - b[2, 0] * b[1, 2]

        val c20 = b[2, 0] * b[3, 1] - b[3, 0] * b[2, 1]
        val c22 = b[1, 0] * b[3, 1] - b[3, 0] * b[1, 1]
        val c23 = b[1, 0] * b[2, 1] - b[2, 0] * b[1, 1]

        var i00 = +(b[1, 1] * c00 - b[1, 2] * c04 + b[1, 3] * c08)
        var i01 = -(b[0, 1] * c00 - b[0, 2] * c04 + b[0, 3] * c08)
        var i02 = +(b[0, 1] * c02 - b[0, 2] * c06 + b[0, 3] * c10)
        var i03 = -(b[0, 1] * c03 - b[0, 2] * c07 + b[0, 3] * c11)

        var i10 = -(b[1, 0] * c00 - b[1, 2] * c12 + b[1, 3] * c16)
        var i11 = +(b[0, 0] * c00 - b[0, 2] * c12 + b[0, 3] * c16)
        var i12 = -(b[0, 0] * c02 - b[0, 2] * c14 + b[0, 3] * c18)
        var i13 = +(b[0, 0] * c03 - b[0, 2] * c15 + b[0, 3] * c19)

        var i20 = +(b[1, 0] * c04 - b[1, 1] * c12 + b[1, 3] * c20)
        var i21 = -(b[0, 0] * c04 - b[0, 1] * c12 + b[0, 3] * c20)
        var i22 = +(b[0, 0] * c06 - b[0, 1] * c14 + b[0, 3] * c22)
        var i23 = -(b[0, 0] * c07 - b[0, 1] * c15 + b[0, 3] * c23)

        var i30 = -(b[1, 0] * c08 - b[1, 1] * c16 + b[1, 2] * c20)
        var i31 = +(b[0, 0] * c08 - b[0, 1] * c16 + b[0, 2] * c20)
        var i32 = -(b[0, 0] * c10 - b[0, 1] * c18 + b[0, 2] * c22)
        var i33 = +(b[0, 0] * c11 - b[0, 1] * c19 + b[0, 2] * c23)

        val oneOverDet = 1 / (b[0, 0] * i00 + b[0, 1] * i10 + b[0, 2] * i20 + b[0, 3] * i30)

        i00 *= oneOverDet
        i01 *= oneOverDet
        i02 *= oneOverDet
        i03 *= oneOverDet

        i10 *= oneOverDet
        i11 *= oneOverDet
        i12 *= oneOverDet
        i13 *= oneOverDet

        i20 *= oneOverDet
        i21 *= oneOverDet
        i22 *= oneOverDet
        i23 *= oneOverDet

        i30 *= oneOverDet
        i31 *= oneOverDet
        i32 *= oneOverDet
        i33 *= oneOverDet

        // a * main.getB
        res[0] = a0 * i00 + a1 * i01 + a2 * i02 + a3 * i03
        res[1] = a0 * i10 + a1 * i11 + a2 * i12 + a3 * i13
        res[2] = a0 * i20 + a1 * i21 + a2 * i22 + a3 * i23
        res[3] = a0 * i30 + a1 * i31 + a2 * i32 + a3 * i33

        return res
    }
}


// -- Specific binary arithmetic operators --

operator fun Double.plus(b: Mat4d) = plus(Mat4d(), b, this)
fun Double.plus(b: Mat4d, res: Mat4d = Mat4d()) = plus(res, b, this)
infix fun Double.plus_(b: Mat4d) = plus(b, b, this)

operator fun Double.minus(b: Mat4d) = minus(Mat4d(), this, b)
fun Double.minus(b: Mat4d, res: Mat4d = Mat4d()) = minus(res, this, b)
infix fun Double.minus_(b: Mat4d) = minus(b, this, b)

operator fun Double.times(b: Mat4d) = times(Mat4d(), b, this)
fun Double.times(b: Mat4d, res: Mat4d = Mat4d()) = times(res, b, this)
infix fun Double.times_(b: Mat4d) = times(b, b, this)

operator fun Vec4d.times(b: Mat4d) = times(Vec4d(), this, b)
fun Vec4d.times(b: Mat4d, res: Vec4d = Vec4d()) = times(res, this, b)
infix fun Vec4d.times_(b: Mat4d) = times(this, this, b)

operator fun Double.div(b: Mat4d) = div(Mat4d(), this, b)
fun Double.div(b: Mat4d, res: Mat4d = Mat4d()) = div(res, this, b)
infix fun Double.div_(b: Mat4d) = div(b, this, b)