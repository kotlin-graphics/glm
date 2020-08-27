package  glm_.mat3x3.operators

import glm_.mat2x3.Mat2x3d
import glm_.mat3x3.Mat3d
import glm_.mat3x3.Mat3d.Companion.div
import glm_.mat3x3.Mat3d.Companion.minus
import glm_.mat3x3.Mat3d.Companion.plus
import glm_.mat3x3.Mat3d.Companion.times
import glm_.mat4x3.Mat4x3d
import glm_.vec3.Vec3d
import glm_.vec3.Vec3d.Companion.div
import glm_.vec3.Vec3d.Companion.minus
import glm_.vec3.Vec3d.Companion.plus
import glm_.vec3.Vec3d.Companion.times

/**
 * Created by GBarbieri on 10.11.2016.
 */

interface mat3d_operators {


    /** Mat3d = Mat3d + scalar */
    fun plus(res: Mat3d, a: Mat3d, b: Double): Mat3d {
        plus(res[0], a[0], b, b, b)
        plus(res[1], a[1], b, b, b)
        plus(res[2], a[2], b, b, b)
        return res
    }

    /** Mat3d = Mat3d - scalar */
    fun minus(res: Mat3d, a: Mat3d, b: Double): Mat3d {
        minus(res[0], a[0], b, b, b)
        minus(res[1], a[1], b, b, b)
        minus(res[2], a[2], b, b, b)
        return res
    }

    /** Mat3d = scalar - Mat3d   */
    fun minus(res: Mat3d, a: Double, b: Mat3d): Mat3d {
        minus(res[0], a, a, a, b[0])
        minus(res[1], a, a, a, b[1])
        minus(res[2], a, a, a, b[2])
        return res
    }

    /** Mat3d = Mat3d * scalar */
    fun times(res: Mat3d, a: Mat3d, b: Double): Mat3d {
        times(res[0], a[0], b, b, b)
        times(res[1], a[1], b, b, b)
        times(res[2], a[2], b, b, b)
        return res
    }

    /** Mat3d = Mat3d / scalar */
    fun div(res: Mat3d, a: Mat3d, b: Double): Mat3d {
        div(res[0], a[0], b, b, b)
        div(res[1], a[1], b, b, b)
        div(res[2], a[2], b, b, b)
        return res
    }

    /** Mat3d = scalar / Mat3d */
    fun div(res: Mat3d, a: Double, b: Mat3d): Mat3d {
        div(res[0], a, a, a, b[0])
        div(res[1], a, a, a, b[1])
        div(res[2], a, a, a, b[2])
        return res
    }


    /** Mat3d = Mat3d + Mat3d */
    fun plus(res: Mat3d, a: Mat3d, b: Mat3d) = plus(res, a,
            b[0, 0], b[0, 1], b[0, 2],
            b[1, 0], b[1, 1], b[1, 2],
            b[2, 0], b[2, 1], b[2, 2])

    /** Mat3d = Mat3d + Mat3d */
    fun plus(res: Mat3d, a: Mat3d, b0: Vec3d, b1: Vec3d, b2: Vec3d) = plus(res, a,
            b0[0], b0[1], b0[2],
            b1[0], b1[1], b1[2],
            b2[0], b2[1], b2[2])

    /** Mat3d = Mat3d + Mat3d */
    fun plus(res: Mat3d, a: Mat3d,
             b00: Double, b01: Double, b02: Double,
             b10: Double, b11: Double, b12: Double,
             b20: Double, b21: Double, b22: Double): Mat3d {
        plus(res[0], a[0], b00, b01, b02)
        plus(res[1], a[1], b10, b11, b12)
        plus(res[2], a[2], b20, b21, b22)
        return res
    }

    /** Mat3d = Mat3d - Mat3d */
    fun minus(res: Mat3d, a: Mat3d, b: Mat3d) = minus(res, a,
            b[0, 0], b[0, 1], b[0, 2],
            b[1, 0], b[1, 1], b[1, 2],
            b[2, 0], b[2, 1], b[2, 2])

    /** Mat3d = Mat3d - Mat3d */
    fun minus(res: Mat3d, a: Mat3d, b0: Vec3d, b1: Vec3d, b2: Vec3d) = minus(res, a,
            b0[0], b0[1], b0[2],
            b1[0], b1[1], b1[2],
            b2[0], b2[1], b2[2])

    /** Mat3d = Mat3d - Mat3d */
    fun minus(res: Mat3d, a: Mat3d,
              b00: Double, b01: Double, b02: Double,
              b10: Double, b11: Double, b12: Double,
              b20: Double, b21: Double, b22: Double): Mat3d {
        minus(res[0], a[0], b00, b01, b02)
        minus(res[1], a[1], b10, b11, b12)
        minus(res[2], a[2], b20, b21, b22)
        return res
    }

    /** Mat3d = Mat3d - Mat3d */
    fun minus(res: Mat3d, a0: Vec3d, a1: Vec3d, a2: Vec3d, b: Mat3d) = minus(res,
            a0[0], a0[1], a0[2],
            a1[0], a1[1], a1[2],
            a2[0], a2[1], a2[2], b)

    /** Mat3d = Mat3d - Mat3d */
    fun minus(res: Mat3d,
              a00: Double, a01: Double, a02: Double,
              a10: Double, a11: Double, a12: Double,
              a20: Double, a21: Double, a22: Double, b: Mat3d): Mat3d {
        minus(res[0], a00, a01, a02, b[0])
        minus(res[1], a10, a11, a12, b[1])
        minus(res[2], a20, a21, a22, b[2])
        return res
    }


    /** Vec3d col = Mat3d * Vec3d row  */
    fun times(res: Vec3d, a: Mat3d, b: Vec3d) = times(res, a, b.x, b.y, b.z)

    /** Vec3d col = Mat3d * Vec3d row */
    fun times(res: Vec3d, a: Mat3d, b0: Double, b1: Double, b2: Double): Vec3d {
        res[0] = a[0, 0] * b0 + a[1, 0] * b1 + a[2, 0] * b2
        res[1] = a[0, 1] * b0 + a[1, 1] * b1 + a[2, 1] * b2
        res[2] = a[0, 2] * b0 + a[1, 2] * b1 + a[2, 2] * b2
        return res
    }

    /** Vec3d row = Vec3d col * Mat3d  */
    fun times(res: Vec3d, a: Vec3d, b: Mat3d) = times(res, a.x, a.y, a.z, b)

    /** Vec3d row = Vec3d col * Mat3d  */
    fun times(res: Vec3d, a0: Double, a1: Double, a2: Double, b: Mat3d): Vec3d {
        res[0] = a0 * b[0, 0] + a1 * b[0, 1] + a2 * b[0, 2]
        res[1] = a0 * b[1, 0] + a1 * b[1, 1] + a2 * b[1, 2]
        res[2] = a0 * b[2, 0] + a1 * b[2, 1] + a2 * b[2, 2]
        return res
    }

    /** Mat3d = Mat3d * Mat3d */
    fun times(res: Mat3d, a: Mat3d, b: Mat3d) = times(res, a,
            b[0, 0], b[0, 1], b[0, 2],
            b[1, 0], b[1, 1], b[1, 2],
            b[2, 0], b[2, 1], b[2, 2])

    /** Mat3d = Mat3d * Mat3d */
    fun times(res: Mat3d, a: Mat3d, b0: Vec3d, b1: Vec3d, b2: Vec3d) = times(res, a,
            b0[0], b0[1], b0[2],
            b1[0], b1[1], b1[2],
            b2[0], b2[1], b2[2])

    /** Mat3d = Mat3d * Mat3d */
    fun times(res: Mat3d, a: Mat3d,
              b00: Double, b01: Double, b02: Double,
              b10: Double, b11: Double, b12: Double,
              b20: Double, b21: Double, b22: Double): Mat3d {
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


    /** Mat23d = Mat3d * Mat23d */
    fun times(res: Mat2x3d, a: Mat3d, b: Mat2x3d) = times(res, a, b[0], b[1], b[2])

    /** Mat23d = Mat3d * Mat23d */
    fun times(res: Mat2x3d, a: Mat3d, b0: Vec3d, b1: Vec3d, b2: Vec3d) = times(res, a, b0.x, b0.y, b1.x, b1.y, b2.x, b2.y)

    /** Mat23d = Mat3d * Mat23d */
    fun times(res: Mat2x3d, a: Mat3d,
              b00: Double, b01: Double, b02: Double,
              b10: Double, b11: Double, b12: Double): Mat2x3d {
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

    /** Mat43d = Mat3d * Mat43d */
    fun times(res: Mat4x3d, a: Mat3d, b: Mat4x3d) = times(res, a, b[0], b[1], b[2], b[3])

    /** Mat43d = Mat3d * Mat43d */
    fun times(res: Mat4x3d, a: Mat3d, b0: Vec3d, b1: Vec3d, b2: Vec3d, b3: Vec3d) = times(res, a,
            b0.x, b0.y, b0.z,
            b1.x, b1.y, b1.z,
            b2.x, b2.y, b2.z,
            b3.x, b3.y, b3.z)

    /** Mat43d = Mat3d * Mat43d */
    fun times(res: Mat4x3d, a: Mat3d,
              b00: Double, b01: Double, b02: Double,
              b10: Double, b11: Double, b12: Double,
              b20: Double, b21: Double, b22: Double,
              b30: Double, b31: Double, b32: Double): Mat4x3d {
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


    /** Mat3d = Mat3d / Mat3d = Mat3d * Mat3d^-1 */
    fun div(res: Mat3d, a: Mat3d, b: Mat3d) = div(res, a,
            b[0, 0], b[0, 1], b[0, 2],
            b[1, 0], b[1, 1], b[1, 2],
            b[2, 0], b[2, 1], b[2, 2])

    /** Mat3d = Mat3d / Mat3d = Mat3d * Mat3d^-1 */
    fun div(res: Mat3d, a: Mat3d, b0: Vec3d, b1: Vec3d, b2: Vec3d) = div(res, a,
            b0[0], b0[1], b0[2],
            b1[0], b1[1], b1[2],
            b2[0], b2[1], b2[2])

    /** Mat3d = Mat3d / Mat3d = Mat3d * Mat3d^-1 */
    fun div(res: Mat3d, a: Mat3d,
            b00: Double, b01: Double, b02: Double,
            b10: Double, b11: Double, b12: Double,
            b20: Double, b21: Double, b22: Double): Mat3d {
        res[0, 0] = b00; res[1, 0] = b10; res[2, 0] = b20
        res[0, 1] = b01; res[1, 1] = b11; res[2, 1] = b21
        res[0, 2] = b02; res[1, 2] = b12; res[2, 2] = b22
        res.inverseAssign()
        a.times(res, res)
        return res
    }


    /** Vec3d col = Mat3d * Vec3d row  */
    fun div(res: Vec3d, a: Mat3d, b: Vec3d) = div(res, a, b.x, b.y, b.z)

    /** Vec3d col = Mat3d * Vec3d row  */
    fun div(res: Vec3d, a: Mat3d, b0: Double, b1: Double, b2: Double): Vec3d {
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

    /** Vec3d row = Vec3d col * Mat3d  */
    fun div(res: Vec3d, a: Vec3d, b: Mat3d) = div(res, a.x, a.y, a.z, b)

    /** Vec3d row = Vec3d col * Mat3d  */
    fun div(res: Vec3d, a0: Double, a1: Double, a2: Double, b: Mat3d): Vec3d {
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

operator fun Double.plus(b: Mat3d) = plus(Mat3d(), b, this)
fun Double.plus(b: Mat3d, res: Mat3d = Mat3d()) = plus(res, b, this)
infix fun Double.plus_(b: Mat3d) = plus(b, b, this)

operator fun Double.minus(b: Mat3d) = minus(Mat3d(), this, b)
fun Double.minus(b: Mat3d, res: Mat3d = Mat3d()) = minus(res, this, b)
infix fun Double.minus_(b: Mat3d) = minus(b, this, b)

operator fun Double.times(b: Mat3d) = times(Mat3d(), b, this)
fun Double.times(b: Mat3d, res: Mat3d = Mat3d()) = times(res, b, this)
infix fun Double.times_(b: Mat3d) = times(b, b, this)

operator fun Vec3d.times(b: Mat3d) = times(Vec3d(), this, b)
fun Vec3d.times(b: Mat3d, res: Vec3d = Vec3d()) = times(res, this, b)
infix fun Vec3d.times_(b: Mat3d) = times(this, this, b)

operator fun Double.div(b: Mat3d) = div(Mat3d(), this, b)
fun Double.div(b: Mat3d, res: Mat3d = Mat3d()) = div(res, this, b)
infix fun Double.div_(b: Mat3d) = div(b, this, b)