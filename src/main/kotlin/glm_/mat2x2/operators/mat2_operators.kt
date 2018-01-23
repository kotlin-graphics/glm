package glm_.mat2x2.operators

import glm_.mat2x2.Mat2
import glm_.mat2x2.Mat2.Companion.div
import glm_.mat2x2.Mat2.Companion.minus
import glm_.mat2x2.Mat2.Companion.plus
import glm_.mat2x2.Mat2.Companion.times
import glm_.mat3x2.Mat3x2
import glm_.mat4x2.Mat4x2
import glm_.vec2.Vec2
import glm_.vec2.Vec2.Companion.div
import glm_.vec2.Vec2.Companion.minus
import glm_.vec2.Vec2.Companion.plus
import glm_.vec2.Vec2.Companion.times

/**
 * Created by GBarbieri on 10.11.2016.
 */
open class mat2_operators {

    /** Mat2 = Mat2 + scalar */
    inline fun plus(res: Mat2, a: Mat2, b: Float): Mat2 {
        plus(res[0], a[0], b, b)
        plus(res[1], a[1], b, b)
        return res
    }

    /** Mat2 = Mat2 - scalar */
    inline fun minus(res: Mat2, a: Mat2, b: Float): Mat2 {
        minus(res[0], a[0], b, b)
        minus(res[1], a[1], b, b)
        return res
    }

    /** Mat2 = scalar - Mat2   */
    inline fun minus(res: Mat2, a: Float, b: Mat2): Mat2 {
        minus(res[0], a, a, b[0])
        minus(res[1], a, a, b[1])
        return res
    }

    /** Mat2 = Mat2 * scalar */
    inline fun times(res: Mat2, a: Mat2, b: Float): Mat2 {
        times(res[0], a[0], b, b)
        times(res[1], a[1], b, b)
        return res
    }

    /** Mat2 = Mat2 / scalar */
    inline fun div(res: Mat2, a: Mat2, b: Float): Mat2 {
        div(res[0], a[0], b, b)
        div(res[1], a[1], b, b)
        return res
    }
    /** Mat2 = scalar / Mat2 */
    inline fun div(res: Mat2, a: Float, b: Mat2): Mat2 {
        div(res[0], a, a, b[0])
        div(res[1], a, a, b[1])
        return res
    }


    /** Mat2 = Mat2 + Mat2 */
    inline fun plus(res: Mat2, a: Mat2, b: Mat2) = plus(res, a, b[0, 0], b[0, 1], b[1, 0], b[1, 1])

    /** Mat2 = Mat2 + Mat2 */
    inline fun plus(res: Mat2, a: Mat2, b0: Vec2, b1: Vec2) = plus(res, a, b0[0], b0[1], b1[0], b1[1])

    /** Mat2 = Mat2 + Mat2 */
    inline fun plus(res: Mat2, a: Mat2, b00: Float, b01: Float, b10: Float, b11: Float): Mat2 {
        plus(res[0], a[0], b00, b01)
        plus(res[1], a[1], b10, b11)
        return res
    }

    /** Mat2 = Mat2 - Mat2 */
    inline fun minus(res: Mat2, a: Mat2, b: Mat2) = minus(res, a, b[0, 0], b[0, 1], b[1, 0], b[1, 1])

    /** Mat2 = Mat2 - Mat2 */
    inline fun minus(res: Mat2, a: Mat2, b0: Vec2, b1: Vec2) = minus(res, a, b0[0], b0[1], b1[0], b1[1])

    /** Mat2 = Mat2 - Mat2 */
    inline fun minus(res: Mat2, a: Mat2, b00: Float, b01: Float, b10: Float, b11: Float): Mat2 {
        minus(res[0], a[0], b00, b01)
        minus(res[1], a[1], b10, b11)
        return res
    }

    /** Mat2 = Mat2 - Mat2 */
    inline fun minus(res: Mat2, a0: Vec2, a1: Vec2, b: Mat2) = minus(res, a0[0], a0[1], a1[0], a1[1], b)

    /** Mat2 = Mat2 - Mat2 */
    inline fun minus(res: Mat2, a00: Float, a01: Float, a10: Float, a11: Float, b: Mat2): Mat2 {
        minus(res[0], a00, a01, b[0])
        minus(res[1], a10, a11, b[1])
        return res
    }


    /** Vec2 col = Mat2 * Vec2 row  */
    inline fun times(res: Vec2, a: Mat2, b: Vec2) = times(res, a, b.x, b.y)

    /** Vec2 col = Mat2 * Vec2 row */
    inline fun times(res: Vec2, a: Mat2, b0: Float, b1: Float): Vec2 {
        res[0] = a[0, 0] * b0 + a[1, 0] * b1
        res[1] = a[0, 1] * b0 + a[1, 1] * b1
        return res
    }

    /** Vec2 row = Vec2 col * Mat2  */
    inline fun times(res: Vec2, a: Vec2, b: Mat2) = times(res, a.x, a.y, b)

    /** Vec2 row = Vec2 col * Mat2  */
    inline fun times(res: Vec2, a0: Float, a1: Float, b: Mat2): Vec2 {
        res[0] = a0 * b[0, 0] + a1 * b[0, 1]
        res[1] = a0 * b[1, 0] + a1 * b[1, 1]
        return res
    }

    /** Mat2 = Mat2 * Mat2 */
    inline fun times(res: Mat2, a: Mat2, b: Mat2) = times(res, a, b[0, 0], b[0, 1], b[1, 0], b[1, 1])

    /** Mat2 = Mat2 * Mat2 */
    inline fun times(res: Mat2, a: Mat2, b0: Vec2, b1: Vec2) = times(res, a, b0[0], b0[1], b1[0], b1[1])

    /** Mat2 = Mat2 * Mat2 */
    inline fun times(res: Mat2, a: Mat2, b00: Float, b01: Float, b10: Float, b11: Float): Mat2 {
        val v00 = a[0, 0] * b00 + a[1, 0] * b01
        val v01 = a[0, 1] * b00 + a[1, 1] * b01
        val v10 = a[0, 0] * b10 + a[1, 0] * b11
        val v11 = a[0, 1] * b10 + a[1, 1] * b11
        res[0, 0] = v00; res[1, 0] = v10
        res[0, 1] = v01; res[1, 1] = v11
        return res
    }

    /** Mat32 = Mat2 * Mat32 */
    inline fun times(res: Mat3x2, a: Mat2, b: Mat3x2) = times(res, a, b[0], b[1], b[2])
    /** Mat32 = Mat2 * Mat32 */
    inline fun times(res: Mat3x2, a: Mat2, b0: Vec2, b1: Vec2, b2: Vec2) = times(res, a, b0.x, b0.y, b1.x, b1.y, b2.x, b2.y)
    /** Mat32 = Mat2 * Mat32 */
    inline fun times(res: Mat3x2, a: Mat2,
                     b00: Float, b01: Float,
                     b10: Float, b11: Float,
                     b20: Float, b21: Float): Mat3x2 {
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

    /** Mat42 = Mat2 * Mat42 */
    inline fun times(res: Mat4x2, a: Mat2, b: Mat4x2) = times(res, a, b[0], b[1], b[2], b[3])
    /** Mat42 = Mat2 * Mat42 */
    inline fun times(res: Mat4x2, a: Mat2, b0: Vec2, b1: Vec2, b2: Vec2, b3: Vec2) = times(res, a, b0.x, b0.y, b1.x, b1.y, b2.x, b2.y, b3.x, b3.y)
    /** Mat42 = Mat2 * Mat42 */
    inline fun times(res: Mat4x2, a: Mat2,
                     b00: Float, b01: Float,
                     b10: Float, b11: Float,
                     b20: Float, b21: Float,
                     b30: Float, b31: Float): Mat4x2 {
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


    /** Mat2 = Mat2 / Mat2 = Mat2 * Mat2^-1 */
    inline fun div(res: Mat2, a: Mat2, b: Mat2) = div(res, a, b[0, 0], b[0, 1], b[1, 0], b[1, 1])
    /** Mat2 = Mat2 / Mat2 = Mat2 * Mat2^-1 */
    inline fun div(res: Mat2, a: Mat2, b0: Vec2, b1: Vec2) = div(res, a, b0[0], b0[1], b1[0], b1[1])
    /** Mat2 = Mat2 / Mat2 = Mat2 * Mat2^-1 */
    inline fun div(res: Mat2, a: Mat2, b00: Float, b01: Float, b10: Float, b11: Float): Mat2 {
        res[0, 0] = b00; res[1, 0] = b10
        res[0, 1] = b01; res[1, 1] = b11
        res.inverseAssign()
        a.times(res, res)
        return res
    }


    /** Vec2 col = Mat2 * Vec2 row  */
    inline fun div(res: Vec2, a: Mat2, b: Vec2) = div(res, a, b.x, b.y)
    /** Vec2 col = Mat2 * Vec2 row  */
    inline fun div(res: Vec2, a: Mat2, b0: Float, b1: Float): Vec2 {
        val oneOverDet = 1 / a.det
        val i00 = +a[1, 1] * oneOverDet
        val i01 = -a[0, 1] * oneOverDet
        val i10 = -a[1, 0] * oneOverDet
        val i11 = +a[0, 0] * oneOverDet
        res[0] = i00 * b0 + i10 * b1
        res[1] = i01 * b0 + i11 * b1
        return res
    }

    /** Vec2 row = Vec2 col * Mat2  */
    inline fun div(res: Vec2, a: Vec2, b: Mat2) = div(res, a.x, a.y, b)
    /** Vec2 row = Vec2 col * Mat2  */
    inline fun div(res: Vec2, a0: Float, a1: Float, b: Mat2): Vec2 {
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

// TODO give a check from here to below

// -- Unary arithmetic operators --

operator fun Mat2.unaryPlus() = this

operator fun Mat2.unaryMinus() = Mat2(-value[0], -value[1])


// -- Increment main.and decrement operators --

operator fun Mat2.inc(res: Mat2 = Mat2()): Mat2 = plus(res, this, 1f)
fun Mat2.inc_() = plus(this, this, 1f)

operator fun Mat2.dec(res: Mat2 = Mat2()): Mat2 = minus(res, this, 1f)
fun Mat2.dec_() = minus(this, this, 1f)


// -- Specific binary arithmetic operators --

operator fun Float.plus(b: Mat2) = plus(Mat2(), b, this)
fun Float.plus(b: Mat2, res: Mat2 = Mat2()) = plus(res, b, this)
infix fun Float.plus_(b: Mat2) = plus(b, b, this)

operator fun Float.minus(b: Mat2) = minus(Mat2(), this, b)
fun Float.minus(b: Mat2, res: Mat2 = Mat2()) = minus(res, this, b)
infix fun Float.minus_(b: Mat2) = minus(b, this, b)

operator fun Float.times(b: Mat2) = times(Mat2(), b, this)
fun Float.times(b: Mat2, res: Mat2 = Mat2()) = times(res, b, this)
infix fun Float.times_(b: Mat2) = times(b, b, this)

operator fun Vec2.times(b: Mat2) = times(Vec2(), this, b)
fun Vec2.times(b: Mat2, res: Vec2 = Vec2()) = times(res, this, b)
infix fun Vec2.times_(b: Mat2) = times(this, this, b)

operator fun Float.div(b: Mat2) = div(Mat2(), this, b)
fun Float.div(b: Mat2, res: Mat2 = Mat2()) = div(res, this, b)
infix fun Float.div_(b: Mat2) = div(b, this, b)