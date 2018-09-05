package  glm_.mat3x3.operators

import glm_.mat2x3.Mat2x3
import glm_.mat3x3.Mat3
import glm_.mat3x3.Mat3.Companion.div
import glm_.mat3x3.Mat3.Companion.minus
import glm_.mat3x3.Mat3.Companion.plus
import glm_.mat3x3.Mat3.Companion.times
import glm_.mat4x3.Mat4x3
import glm_.vec3.Vec3
import glm_.vec3.Vec3.Companion.div
import glm_.vec3.Vec3.Companion.minus
import glm_.vec3.Vec3.Companion.plus
import glm_.vec3.Vec3.Companion.times

/**
 * Created by GBarbieri on 10.11.2016.
 */

interface mat3x3_operators {


    /** Mat3 = Mat3 + scalar */
    fun plus(res: Mat3, a: Mat3, b: Float): Mat3 {
        plus(res[0], a[0], b, b, b)
        plus(res[1], a[1], b, b, b)
        plus(res[2], a[2], b, b, b)
        return res
    }

    /** Mat3 = Mat3 - scalar */
    fun minus(res: Mat3, a: Mat3, b: Float): Mat3 {
        minus(res[0], a[0], b, b, b)
        minus(res[1], a[1], b, b, b)
        minus(res[2], a[2], b, b, b)
        return res
    }

    /** Mat3 = scalar - Mat3   */
    fun minus(res: Mat3, a: Float, b: Mat3): Mat3 {
        minus(res[0], a, a, a, b[0])
        minus(res[1], a, a, a, b[1])
        minus(res[2], a, a, a, b[2])
        return res
    }

    /** Mat3 = Mat3 * scalar */
    fun times(res: Mat3, a: Mat3, b: Float): Mat3 {
        times(res[0], a[0], b, b, b)
        times(res[1], a[1], b, b, b)
        times(res[2], a[2], b, b, b)
        return res
    }

    /** Mat3 = Mat3 / scalar */
    fun div(res: Mat3, a: Mat3, b: Float): Mat3 {
        div(res[0], a[0], b, b, b)
        div(res[1], a[1], b, b, b)
        div(res[2], a[2], b, b, b)
        return res
    }

    /** Mat3 = scalar / Mat3 */
    fun div(res: Mat3, a: Float, b: Mat3): Mat3 {
        div(res[0], a, a, a, b[0])
        div(res[1], a, a, a, b[1])
        div(res[2], a, a, a, b[2])
        return res
    }


    /** Mat3 = Mat3 + Mat3 */
    fun plus(res: Mat3, a: Mat3, b: Mat3) = plus(res, a,
            b[0, 0], b[0, 1], b[0, 2],
            b[1, 0], b[1, 1], b[1, 2],
            b[2, 0], b[2, 1], b[2, 2])

    /** Mat3 = Mat3 + Mat3 */
    fun plus(res: Mat3, a: Mat3, b0: Vec3, b1: Vec3, b2: Vec3) = plus(res, a,
            b0[0], b0[1], b0[2],
            b1[0], b1[1], b1[2],
            b2[0], b2[1], b2[2])

    /** Mat3 = Mat3 + Mat3 */
    fun plus(res: Mat3, a: Mat3,
                    b00: Float, b01: Float, b02: Float,
                    b10: Float, b11: Float, b12: Float,
                    b20: Float, b21: Float, b22: Float): Mat3 {
        plus(res[0], a[0], b00, b01, b02)
        plus(res[1], a[1], b10, b11, b12)
        plus(res[2], a[2], b20, b21, b22)
        return res
    }

    /** Mat3 = Mat3 - Mat3 */
    fun minus(res: Mat3, a: Mat3, b: Mat3) = minus(res, a,
            b[0, 0], b[0, 1], b[0, 2],
            b[1, 0], b[1, 1], b[1, 2],
            b[2, 0], b[2, 1], b[2, 2])

    /** Mat3 = Mat3 - Mat3 */
    fun minus(res: Mat3, a: Mat3, b0: Vec3, b1: Vec3, b2: Vec3) = minus(res, a,
            b0[0], b0[1], b0[2],
            b1[0], b1[1], b1[2],
            b2[0], b2[1], b2[2])

    /** Mat3 = Mat3 - Mat3 */
    fun minus(res: Mat3, a: Mat3,
                     b00: Float, b01: Float, b02: Float,
                     b10: Float, b11: Float, b12: Float,
                     b20: Float, b21: Float, b22: Float): Mat3 {
        minus(res[0], a[0], b00, b01, b02)
        minus(res[1], a[1], b10, b11, b12)
        minus(res[2], a[2], b20, b21, b22)
        return res
    }

    /** Mat3 = Mat3 - Mat3 */
    fun minus(res: Mat3, a0: Vec3, a1: Vec3, a2: Vec3, b: Mat3) = minus(res,
            a0[0], a0[1], a0[2],
            a1[0], a1[1], a1[2],
            a2[0], a2[1], a2[2], b)

    /** Mat3 = Mat3 - Mat3 */
    fun minus(res: Mat3,
                     a00: Float, a01: Float, a02: Float,
                     a10: Float, a11: Float, a12: Float,
                     a20: Float, a21: Float, a22: Float, b: Mat3): Mat3 {
        minus(res[0], a00, a01, a02, b[0])
        minus(res[1], a10, a11, a12, b[1])
        minus(res[2], a20, a21, a22, b[2])
        return res
    }


    /** Vec3 col = Mat3 * Vec3 row  */
    fun times(res: Vec3, a: Mat3, b: Vec3) = times(res, a, b.x, b.y, b.z)

    /** Vec3 col = Mat3 * Vec3 row */
    fun times(res: Vec3, a: Mat3, b0: Float, b1: Float, b2: Float): Vec3 {
        res[0] = a[0, 0] * b0 + a[1, 0] * b1 + a[2, 0] * b2
        res[1] = a[0, 1] * b0 + a[1, 1] * b1 + a[2, 1] * b2
        res[2] = a[0, 2] * b0 + a[1, 2] * b1 + a[2, 2] * b2
        return res
    }

    /** Vec3 row = Vec3 col * Mat3  */
    fun times(res: Vec3, a: Vec3, b: Mat3) = times(res, a.x, a.y, a.z, b)

    /** Vec3 row = Vec3 col * Mat3  */
    fun times(res: Vec3, a0: Float, a1: Float, a2: Float, b: Mat3): Vec3 {
        res[0] = a0 * b[0, 0] + a1 * b[0, 1] + a2 * b[0, 2]
        res[1] = a0 * b[1, 0] + a1 * b[1, 1] + a2 * b[1, 2]
        res[2] = a0 * b[2, 0] + a1 * b[2, 1] + a2 * b[2, 2]
        return res
    }

    /** Mat3 = Mat3 * Mat3 */
    fun times(res: Mat3, a: Mat3, b: Mat3) = times(res, a,
            b[0, 0], b[0, 1], b[0, 2],
            b[1, 0], b[1, 1], b[1, 2],
            b[2, 0], b[2, 1], b[2, 2])

    /** Mat3 = Mat3 * Mat3 */
    fun times(res: Mat3, a: Mat3, b0: Vec3, b1: Vec3, b2: Vec3) = times(res, a,
            b0[0], b0[1], b0[2],
            b1[0], b1[1], b1[2],
            b2[0], b2[1], b2[2])

    /** Mat3 = Mat3 * Mat3 */
    fun times(res: Mat3, a: Mat3,
                     b00: Float, b01: Float, b02: Float,
                     b10: Float, b11: Float, b12: Float,
                     b20: Float, b21: Float, b22: Float): Mat3 {
        val v00 = a[0, 0] * b00 + a[1, 0] * b01 + a[2, 0] * b02
        val v01 = a[0, 1] * b00 + a[1, 1] * b01 + a[2, 1] * b02
        val v02 = a[0, 2] * b00 + a[1, 2] * b01 + a[2, 2] * b02
        val v10 = a[0, 0] * b10 + a[1, 0] * b11 + a[2, 0] * b12
        val v11 = a[0, 1] * b10 + a[1, 1] * b11 + a[2, 1] * b12
        val v12 = a[0, 2] * b10 + a[1, 2] * b11 + a[2, 2] * b12
        val v20 = a[0, 0] * b20 + a[1, 0] * b21 + a[2, 0] * b22
        val v21 = a[0, 1] * b20 + a[1, 1] * b21 + a[2, 1] * b22
        val v22 = a[0, 2] * b20 + a[1, 2] * b21 + a[2, 2] * b22
        res[0, 0] = v00; res[1, 0] = v10; res[2, 0] = v20
        res[0, 1] = v01; res[1, 1] = v11; res[2, 1] = v21
        res[0, 2] = v02; res[1, 2] = v12; res[2, 2] = v22
        return res
    }


    /** Mat23 = Mat3 * Mat23 */
    fun times(res: Mat2x3, a: Mat3, b: Mat2x3) = times(res, a, b[0], b[1], b[2])
    /** Mat23 = Mat3 * Mat23 */
    fun times(res: Mat2x3, a: Mat3, b0: Vec3, b1: Vec3, b2: Vec3) = times(res, a, b0.x, b0.y, b1.x, b1.y, b2.x, b2.y)
    /** Mat23 = Mat3 * Mat23 */
    fun times(res: Mat2x3, a: Mat3,
                     b00: Float, b01: Float, b02: Float,
                     b10: Float, b11: Float, b12: Float): Mat2x3 {
        val v00 = a[0, 0] * b00 + a[1, 0] * b01 + a[2, 0] * b02
        val v01 = a[0, 1] * b00 + a[1, 1] * b01 + a[2, 1] * b02
        val v02 = a[0, 2] * b00 + a[1, 2] * b01 + a[2, 2] * b02
        val v10 = a[0, 0] * b10 + a[1, 0] * b11 + a[2, 0] * b12
        val v11 = a[0, 1] * b10 + a[1, 1] * b11 + a[2, 1] * b12
        val v12 = a[0, 2] * b10 + a[1, 2] * b11 + a[2, 2] * b12
        res[0, 0] = v00; res[1, 0] = v10
        res[0, 1] = v01; res[1, 1] = v11
        res[0, 2] = v02; res[1, 2] = v12
        return res
    }

    /** Mat43 = Mat3 * Mat43 */
    fun times(res: Mat4x3, a: Mat3, b: Mat4x3) = times(res, a, b[0], b[1], b[2], b[3])
    /** Mat43 = Mat3 * Mat43 */
    fun times(res: Mat4x3, a: Mat3, b0: Vec3, b1: Vec3, b2: Vec3, b3: Vec3) = times(res, a,
            b0.x, b0.y, b0.z,
            b1.x, b1.y, b1.z,
            b2.x, b2.y, b2.z,
            b3.x, b3.y, b3.z)
    /** Mat43 = Mat3 * Mat43 */
    fun times(res: Mat4x3, a: Mat3,
                     b00: Float, b01: Float, b02: Float,
                     b10: Float, b11: Float, b12: Float,
                     b20: Float, b21: Float, b22: Float,
                     b30: Float, b31: Float, b32: Float): Mat4x3 {
        val v00 = a[0, 0] * b00 + a[1, 0] * b01 + a[2, 0] * b02
        val v01 = a[0, 1] * b00 + a[1, 1] * b01 + a[2, 1] * b02
        val v02 = a[0, 2] * b00 + a[1, 2] * b01 + a[2, 2] * b02
        val v10 = a[0, 0] * b10 + a[1, 0] * b11 + a[2, 0] * b12
        val v11 = a[0, 1] * b10 + a[1, 1] * b11 + a[2, 1] * b12
        val v12 = a[0, 2] * b10 + a[1, 2] * b11 + a[2, 2] * b12
        val v20 = a[0, 0] * b20 + a[1, 0] * b21 + a[2, 0] * b22
        val v21 = a[0, 1] * b20 + a[1, 1] * b21 + a[2, 1] * b22
        val v22 = a[0, 2] * b20 + a[1, 2] * b21 + a[2, 2] * b22
        val v30 = a[0, 0] * b30 + a[1, 0] * b31 + a[2, 0] * b32
        val v31 = a[0, 1] * b30 + a[1, 1] * b31 + a[2, 1] * b32
        val v32 = a[0, 2] * b30 + a[1, 2] * b31 + a[2, 2] * b32
        res[0, 0] = v00; res[1, 0] = v10; res[2, 0] = v20; res[3, 0] = v30
        res[0, 1] = v01; res[1, 1] = v11; res[2, 1] = v21; res[3, 1] = v31
        res[0, 2] = v02; res[1, 2] = v12; res[2, 2] = v22; res[3, 2] = v32
        return res
    }


    /** Mat3 = Mat3 / Mat3 = Mat3 * Mat3^-1 */
    fun div(res: Mat3, a: Mat3, b: Mat3) = div(res, a,
            b[0, 0], b[0, 1], b[0, 2],
            b[1, 0], b[1, 1], b[1, 2],
            b[2, 0], b[2, 1], b[2, 2])

    /** Mat3 = Mat3 / Mat3 = Mat3 * Mat3^-1 */
    fun div(res: Mat3, a: Mat3, b0: Vec3, b1: Vec3, b2: Vec3) = div(res, a,
            b0[0], b0[1], b0[2],
            b1[0], b1[1], b1[2],
            b2[0], b2[1], b2[2])

    /** Mat3 = Mat3 / Mat3 = Mat3 * Mat3^-1 */
    fun div(res: Mat3, a: Mat3,
                   b00: Float, b01: Float, b02: Float,
                   b10: Float, b11: Float, b12: Float,
                   b20: Float, b21: Float, b22: Float): Mat3 {
        res[0, 0] = b00; res[1, 0] = b10; res[2, 0] = b20
        res[0, 1] = b01; res[1, 1] = b11; res[2, 1] = b21
        res[0, 2] = b02; res[1, 2] = b12; res[2, 2] = b22
        res.inverseAssign()
        a.times(res, res)
        return res
    }


    /** Vec3 col = Mat3 * Vec3 row  */
    fun div(res: Vec3, a: Mat3, b: Vec3) = div(res, a, b.x, b.y, b.z)

    /** Vec3 col = Mat3 * Vec3 row  */
    fun div(res: Vec3, a: Mat3, b0: Float, b1: Float, b2: Float): Vec3 {
        val oneOverDet = 1 / a.det
        val i00 = +(a[1, 1] * a[2, 2] - a[2, 1] * a[1, 2]) * oneOverDet
        val i10 = -(a[1, 0] * a[2, 2] - a[2, 0] * a[1, 2]) * oneOverDet
        val i20 = +(a[1, 0] * a[2, 1] - a[2, 0] * a[1, 1]) * oneOverDet
        val i01 = -(a[0, 1] * a[2, 2] - a[2, 1] * a[0, 2]) * oneOverDet
        val i11 = +(a[0, 0] * a[2, 2] - a[2, 0] * a[0, 2]) * oneOverDet
        val i21 = -(a[0, 0] * a[2, 1] - a[2, 0] * a[0, 1]) * oneOverDet
        val i02 = +(a[0, 1] * a[1, 2] - a[1, 1] * a[0, 2]) * oneOverDet
        val i12 = -(a[0, 0] * a[1, 2] - a[1, 0] * a[0, 2]) * oneOverDet
        val i22 = +(a[0, 0] * a[1, 1] - a[1, 0] * a[0, 1]) * oneOverDet
        res[0] = i00 * b0 + i10 * b1 + i20 * b2
        res[1] = i01 * b0 + i11 * b1 + i21 * b2
        res[2] = i02 * b0 + i12 * b1 + i22 * b2
        return res
    }

    /** Vec3 row = Vec3 col * Mat3  */
    fun div(res: Vec3, a: Vec3, b: Mat3) = div(res, a.x, a.y, a.z, b)

    /** Vec3 row = Vec3 col * Mat3  */
    fun div(res: Vec3, a0: Float, a1: Float, a2: Float, b: Mat3): Vec3 {
        val oneOverDet = 1 / b.det
        val i00 = +(b[1, 1] * b[2, 2] - b[2, 1] * b[1, 2]) * oneOverDet
        val i10 = -(b[1, 0] * b[2, 2] - b[2, 0] * b[1, 2]) * oneOverDet
        val i20 = +(b[1, 0] * b[2, 1] - b[2, 0] * b[1, 1]) * oneOverDet
        val i01 = -(b[0, 1] * b[2, 2] - b[2, 1] * b[0, 2]) * oneOverDet
        val i11 = +(b[0, 0] * b[2, 2] - b[2, 0] * b[0, 2]) * oneOverDet
        val i21 = -(b[0, 0] * b[2, 1] - b[2, 0] * b[0, 1]) * oneOverDet
        val i02 = +(b[0, 1] * b[1, 2] - b[1, 1] * b[0, 2]) * oneOverDet
        val i12 = -(b[0, 0] * b[1, 2] - b[1, 0] * b[0, 2]) * oneOverDet
        val i22 = +(b[0, 0] * b[1, 1] - b[1, 0] * b[0, 1]) * oneOverDet
        res[0] = a0 * i00 + a1 * i01 + a2 * i02
        res[1] = a0 * i10 + a1 * i11 + a2 * i12
        res[2] = a0 * i20 + a1 * i21 + a2 * i22
        return res
    }
}


// -- Specific binary arithmetic operators --

operator fun Float.plus(b: Mat3) = plus(Mat3(), b, this)
fun Float.plus(b: Mat3, res: Mat3 = Mat3()) = plus(res, b, this)
infix fun Float.plus_(b: Mat3) = plus(b, b, this)

operator fun Float.minus(b: Mat3) = minus(Mat3(), this, b)
fun Float.minus(b: Mat3, res: Mat3 = Mat3()) = minus(res, this, b)
infix fun Float.minus_(b: Mat3) = minus(b, this, b)

operator fun Float.times(b: Mat3) = times(Mat3(), b, this)
fun Float.times(b: Mat3, res: Mat3 = Mat3()) = times(res, b, this)
infix fun Float.times_(b: Mat3) = times(b, b, this)

operator fun Vec3.times(b: Mat3) = times(Vec3(), this, b)
fun Vec3.times(b: Mat3, res: Vec3 = Vec3()) = times(res, this, b)
infix fun Vec3.times_(b: Mat3) = times(this, this, b)

operator fun Float.div(b: Mat3) = div(Mat3(), this, b)
fun Float.div(b: Mat3, res: Mat3 = Mat3()) = div(res, this, b)
infix fun Float.div_(b: Mat3) = div(b, this, b)