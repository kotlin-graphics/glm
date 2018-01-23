package glm_.mat2x2.operators

import glm_.mat2x2.Mat2d
import glm_.mat2x2.Mat2d.Companion.div
import glm_.mat2x2.Mat2d.Companion.minus
import glm_.mat2x2.Mat2d.Companion.plus
import glm_.mat2x2.Mat2d.Companion.times
import glm_.mat3x2.Mat3x2d
import glm_.mat4x2.Mat4x2d
import glm_.vec2.Vec2d
import glm_.vec2.Vec2d.Companion.div
import glm_.vec2.Vec2d.Companion.minus
import glm_.vec2.Vec2d.Companion.plus
import glm_.vec2.Vec2d.Companion.times

/**
 * Created by GBarbieri on 10.11.2016.
 */
open class mat2d_operators {

    /** Mat2d = Mat2d + scalar */
    inline fun plus(res: Mat2d, a: Mat2d, b: Double): Mat2d {
        plus(res[0], a[0], b, b)
        plus(res[1], a[1], b, b)
        return res
    }

    /** Mat2d = Mat2d - scalar */
    inline fun minus(res: Mat2d, a: Mat2d, b: Double): Mat2d {
        minus(res[0], a[0], b, b)
        minus(res[1], a[1], b, b)
        return res
    }

    /** Mat2d = scalar - Mat2d   */
    inline fun minus(res: Mat2d, a: Double, b: Mat2d): Mat2d {
        minus(res[0], a, a, b[0])
        minus(res[1], a, a, b[1])
        return res
    }

    /** Mat2d = Mat2d * scalar */
    inline fun times(res: Mat2d, a: Mat2d, b: Double): Mat2d {
        times(res[0], a[0], b, b)
        times(res[1], a[1], b, b)
        return res
    }

    /** Mat2d = Mat2d / scalar */
    inline fun div(res: Mat2d, a: Mat2d, b: Double): Mat2d {
        div(res[0], a[0], b, b)
        div(res[1], a[1], b, b)
        return res
    }
    /** Mat2d = scalar / Mat2d */
    inline fun div(res: Mat2d, a: Double, b: Mat2d): Mat2d {
        div(res[0], a, a, b[0])
        div(res[1], a, a, b[1])
        return res
    }


    /** Mat2d = Mat2d + Mat2d */
    inline fun plus(res: Mat2d, a: Mat2d, b: Mat2d) = plus(res, a, b[0, 0], b[0, 1], b[1, 0], b[1, 1])

    /** Mat2d = Mat2d + Mat2d */
    inline fun plus(res: Mat2d, a: Mat2d, b0: Vec2d, b1: Vec2d) = plus(res, a, b0[0], b0[1], b1[0], b1[1])

    /** Mat2d = Mat2d + Mat2d */
    inline fun plus(res: Mat2d, a: Mat2d, b00: Double, b01: Double, b10: Double, b11: Double): Mat2d {
        plus(res[0], a[0], b00, b01)
        plus(res[1], a[1], b10, b11)
        return res
    }

    /** Mat2d = Mat2d - Mat2d */
    inline fun minus(res: Mat2d, a: Mat2d, b: Mat2d) = minus(res, a, b[0, 0], b[0, 1], b[1, 0], b[1, 1])

    /** Mat2d = Mat2d - Mat2d */
    inline fun minus(res: Mat2d, a: Mat2d, b0: Vec2d, b1: Vec2d) = minus(res, a, b0[0], b0[1], b1[0], b1[1])

    /** Mat2d = Mat2d - Mat2d */
    inline fun minus(res: Mat2d, a: Mat2d, b00: Double, b01: Double, b10: Double, b11: Double): Mat2d {
        minus(res[0], a[0], b00, b01)
        minus(res[1], a[1], b10, b11)
        return res
    }

    /** Mat2d = Mat2d - Mat2d */
    inline fun minus(res: Mat2d, a0: Vec2d, a1: Vec2d, b: Mat2d) = minus(res, a0[0], a0[1], a1[0], a1[1], b)

    /** Mat2d = Mat2d - Mat2d */
    inline fun minus(res: Mat2d, a00: Double, a01: Double, a10: Double, a11: Double, b: Mat2d): Mat2d {
        minus(res[0], a00, a01, b[0])
        minus(res[1], a10, a11, b[1])
        return res
    }


    /** Vec2d col = Mat2d * Vec2d row  */
    inline fun times(res: Vec2d, a: Mat2d, b: Vec2d) = times(res, a, b.x, b.y)

    /** Vec2d col = Mat2d * Vec2d row */
    inline fun times(res: Vec2d, a: Mat2d, b0: Double, b1: Double): Vec2d {
        res[0] = a[0, 0] * b0 + a[1, 0] * b1
        res[1] = a[0, 1] * b0 + a[1, 1] * b1
        return res
    }

    /** Vec2d row = Vec2d col * Mat2d  */
    inline fun times(res: Vec2d, a: Vec2d, b: Mat2d) = times(res, a.x, a.y, b)

    /** Vec2d row = Vec2d col * Mat2d  */
    inline fun times(res: Vec2d, a0: Double, a1: Double, b: Mat2d): Vec2d {
        res[0] = a0 * b[0, 0] + a1 * b[0, 1]
        res[1] = a0 * b[1, 0] + a1 * b[1, 1]
        return res
    }

    /** Mat2d = Mat2d * Mat2d */
    inline fun times(res: Mat2d, a: Mat2d, b: Mat2d) = times(res, a, b[0, 0], b[0, 1], b[1, 0], b[1, 1])

    /** Mat2d = Mat2d * Mat2d */
    inline fun times(res: Mat2d, a: Mat2d, b0: Vec2d, b1: Vec2d) = times(res, a, b0[0], b0[1], b1[0], b1[1])

    /** Mat2d = Mat2d * Mat2d */
    inline fun times(res: Mat2d, a: Mat2d, b00: Double, b01: Double, b10: Double, b11: Double): Mat2d {
        val v00 = a[0, 0] * b00 + a[1, 0] * b01
        val v01 = a[0, 1] * b00 + a[1, 1] * b01
        val v10 = a[0, 0] * b10 + a[1, 0] * b11
        val v11 = a[0, 1] * b10 + a[1, 1] * b11
        res[0, 0] = v00; res[1, 0] = v10
        res[0, 1] = v01; res[1, 1] = v11
        return res
    }

    /** Mat32d = Mat2d * Mat32d */
    inline fun times(res: Mat3x2d, a: Mat2d, b: Mat3x2d) = times(res, a, b[0], b[1], b[2])
    /** Mat32d = Mat2d * Mat32d */
    inline fun times(res: Mat3x2d, a: Mat2d, b0: Vec2d, b1: Vec2d, b2: Vec2d) = times(res, a, b0.x, b0.y, b1.x, b1.y, b2.x, b2.y)
    /** Mat32d = Mat2d * Mat32d */
    inline fun times(res: Mat3x2d, a: Mat2d,
                     b00: Double, b01: Double,
                     b10: Double, b11: Double,
                     b20: Double, b21: Double): Mat3x2d {
        val v00 = a[0, 0] * b00 + a[1, 0] * b01
        val v01 = a[0, 1] * b00 + a[1, 1] * b01
        val v10 = a[0, 0] * b10 + a[1, 0] * b11
        val v11 = a[0, 1] * b10 + a[1, 1] * b11
        val v20 = a[0, 0] * b20 + a[1, 0] * b21
        val v21 = a[0, 1] * b20 + a[1, 1] * b21
        res[0, 0] = v00; res[1, 0] = v10; res[2, 0] = v20
        res[0, 1] = v01; res[1, 1] = v11; res[2, 1] = v21
        return res
    }

    /** Mat42d = Mat2d * Mat42d */
    inline fun times(res: Mat4x2d, a: Mat2d, b: Mat4x2d) = times(res, a, b[0], b[1], b[2], b[3])
    /** Mat42d = Mat2d * Mat42d */
    inline fun times(res: Mat4x2d, a: Mat2d, b0: Vec2d, b1: Vec2d, b2: Vec2d, b3: Vec2d) = times(res, a, b0.x, b0.y, b1.x, b1.y, b2.x, b2.y, b3.x, b3.y)
    /** Mat42d = Mat2d * Mat42d */
    inline fun times(res: Mat4x2d, a: Mat2d,
                     b00: Double, b01: Double,
                     b10: Double, b11: Double,
                     b20: Double, b21: Double,
                     b30: Double, b31: Double): Mat4x2d {
        val v00 = a[0, 0] * b00 + a[1, 0] * b01
        val v01 = a[0, 1] * b00 + a[1, 1] * b01
        val v10 = a[0, 0] * b10 + a[1, 0] * b11
        val v11 = a[0, 1] * b10 + a[1, 1] * b11
        val v20 = a[0, 0] * b20 + a[1, 0] * b21
        val v21 = a[0, 1] * b20 + a[1, 1] * b21
        val v30 = a[0, 0] * b30 + a[1, 0] * b31
        val v31 = a[0, 1] * b30 + a[1, 1] * b31
        res[0, 0] = v00; res[1, 0] = v10; res[2, 0] = v20; res[3, 0] = v30
        res[0, 1] = v01; res[1, 1] = v11; res[2, 1] = v21; res[3, 1] = v31
        return res
    }


    /** Mat2d = Mat2d / Mat2d = Mat2d * Mat2d^-1 */
    inline fun div(res: Mat2d, a: Mat2d, b: Mat2d) = div(res, a, b[0, 0], b[0, 1], b[1, 0], b[1, 1])
    /** Mat2d = Mat2d / Mat2d = Mat2d * Mat2d^-1 */
    inline fun div(res: Mat2d, a: Mat2d, b0: Vec2d, b1: Vec2d) = div(res, a, b0[0], b0[1], b1[0], b1[1])
    /** Mat2d = Mat2d / Mat2d = Mat2d * Mat2d^-1 */
    inline fun div(res: Mat2d, a: Mat2d, b00: Double, b01: Double, b10: Double, b11: Double): Mat2d {
        res[0, 0] = b00; res[1, 0] = b10
        res[0, 1] = b01; res[1, 1] = b11
        res.inverseAssign()
        a.times(res, res)
        return res
    }


    /** Vec2d col = Mat2d * Vec2d row  */
    inline fun div(res: Vec2d, a: Mat2d, b: Vec2d) = div(res, a, b.x, b.y)
    /** Vec2d col = Mat2d * Vec2d row  */
    inline fun div(res: Vec2d, a: Mat2d, b0: Double, b1: Double): Vec2d {
        val oneOverDet = 1 / a.det
        val i00 = +a[1, 1] * oneOverDet
        val i01 = -a[0, 1] * oneOverDet
        val i10 = -a[1, 0] * oneOverDet
        val i11 = +a[0, 0] * oneOverDet
        res[0] = i00 * b0 + i10 * b1
        res[1] = i01 * b0 + i11 * b1
        return res
    }

    /** Vec2d row = Vec2d col * Mat2d  */
    inline fun div(res: Vec2d, a: Vec2d, b: Mat2d) = div(res, a.x, a.y, b)
    /** Vec2d row = Vec2d col * Mat2d  */
    inline fun div(res: Vec2d, a0: Double, a1: Double, b: Mat2d): Vec2d {
        val oneOverDet = 1 / b.det
        val i00 = +b[1, 1] * oneOverDet
        val i01 = -b[0, 1] * oneOverDet
        val i10 = -b[1, 0] * oneOverDet
        val i11 = +b[0, 0] * oneOverDet
        res[0] = a0 * i00 + a1 * i01
        res[1] = a0 * i10 + a1 * i11
        return res
    }
}


// -- Unary arithmetic operators --

operator fun Mat2d.unaryPlus() = this

operator fun Mat2d.unaryMinus() = Mat2d(-value[0], -value[1])


// -- Increment main.and decrement operators --

operator fun Mat2d.inc(res: Mat2d = Mat2d()): Mat2d = plus(res, this, 1.0)
fun Mat2d.inc_() = plus(this, this, 1.0)

operator fun Mat2d.dec(res: Mat2d = Mat2d()): Mat2d = minus(res, this, 1.0)
fun Mat2d.dec_() = minus(this, this, 1.0)


// -- Specific binary arithmetic operators --

operator fun Double.plus(b: Mat2d) = plus(Mat2d(), b, this)
fun Double.plus(b: Mat2d, res: Mat2d = Mat2d()) = plus(res, b, this)
infix fun Double.plus_(b: Mat2d) = plus(b, b, this)

operator fun Double.minus(b: Mat2d) = minus(Mat2d(), this, b)
fun Double.minus(b: Mat2d, res: Mat2d = Mat2d()) = minus(res, this, b)
infix fun Double.minus_(b: Mat2d) = minus(b, this, b)

operator fun Double.times(b: Mat2d) = times(Mat2d(), b, this)
fun Double.times(b: Mat2d, res: Mat2d = Mat2d()) = times(res, b, this)
infix fun Double.times_(b: Mat2d) = times(b, b, this)

operator fun Vec2d.times(b: Mat2d) = times(Vec2d(), this, b)
fun Vec2d.times(b: Mat2d, res: Vec2d = Vec2d()) = times(res, this, b)
infix fun Vec2d.times_(b: Mat2d) = times(this, this, b)

operator fun Double.div(b: Mat2d) = div(Mat2d(), this, b)
fun Double.div(b: Mat2d, res: Mat2d = Mat2d()) = div(res, this, b)
infix fun Double.div_(b: Mat2d) = div(b, this, b)