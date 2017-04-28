package glm.mat2x2.operators

import glm.mat2x2.Mat2
import glm.mat2x2.Mat2.Companion.plus
import glm.mat2x2.Mat2.Companion.div
import glm.mat2x2.Mat2.Companion.times
import glm.mat2x2.Mat2.Companion.minus
import glm.mat3x2.Mat3x2
import glm.mat4x2.Mat4x2
import glm.vec2.Vec2
import glm.vec2.Vec2.Companion.plus
import glm.vec2.Vec2.Companion.div
import glm.vec2.Vec2.Companion.times
import glm.vec2.Vec2.Companion.minus
import glm.vec2.operators.vec2_operators

/**
 * Created by GBarbieri on 10.11.2016.
 */
interface mat2x2_operators {

    fun plus(res: Mat2, a: Mat2, b: Float): Mat2 {
        plus(res[0], a[0], b, b)
        plus(res[1], a[1], b, b)
        return res
    }

    fun plus(res: Mat2, a: Mat2, b: Mat2): Mat2 {
        plus(res[0], a[0], b[0][0], b[0][1])
        plus(res[1], a[1], b[1][0], b[1][1])
        return res
    }


    fun minus(res: Mat2, a: Mat2, b: Float): Mat2 {
        minus(res[0], a[0], b, b)
        minus(res[1], a[1], b, b)
        return res
    }

    fun minus(res: Mat2, a: Float, b: Mat2): Mat2 {
        minus(res[0], a, a, b[0])
        minus(res[1], a, a, b[1])
        return res
    }

    fun minus(res: Mat2, a: Mat2, b: Mat2): Mat2 {
        minus(res[0], a[0], b[0][0], b[0][1])
        minus(res[1], a[1], b[1][0], b[1][1])
        return res
    }


    fun times(res: Mat2, a: Mat2, b: Float): Mat2 {
        times(res[0], a[0], b, b)
        times(res[1], a[1], b, b)
        return res
    }

    fun times(res: Vec2, a: Mat2, b: Vec2): Vec2 {
        res[0] = a[0][0] * b.x + a[1][0] * b.y
        res[1] = a[0][1] * b.x + a[1][1] * b.y
        return res
    }

    fun times(res: Vec2, a: Vec2, b: Mat2): Vec2 {
        res[0] = a.x * b[0][0] + a.y * b[0][1]
        res[1] = a.x * b[1][0] + a.y * b[1][1]
        return res
    }

    fun times(res: Mat2, a: Mat2, b: Mat2): Mat2 {
        val v00 = a[0][0] * b[0][0] + a[1][0] * b[0][1]
        val v01 = a[0][1] * b[0][0] + a[1][1] * b[0][1]
        val v10 = a[0][0] * b[1][0] + a[1][0] * b[1][1]
        val v11 = a[0][1] * b[1][0] + a[1][1] * b[1][1]
        res[0][0] = v00
        res[0][1] = v01
        res[1][0] = v10
        res[1][1] = v11
        return res
    }

    fun times(res: Mat3x2, a: Mat2, b: Mat3x2): Mat3x2 {
        val v00 = a[0][0] * b[0][0] + a[1][0] * b[0][1]
        val v01 = a[0][1] * b[0][0] + a[1][1] * b[0][1]
        val v10 = a[0][0] * b[1][0] + a[1][0] * b[1][1]
        val v11 = a[0][1] * b[1][0] + a[1][1] * b[1][1]
        val v20 = a[0][0] * b[2][0] + a[1][0] * b[2][1]
        val v21 = a[0][1] * b[2][0] + a[1][1] * b[2][1]
        res[0][0] = v00
        res[0][1] = v01
        res[1][0] = v10
        res[1][1] = v11
        res[2][0] = v20
        res[2][1] = v21
        return res
    }

    fun times(res: Mat4x2, a: Mat2, b: Mat4x2): Mat4x2 {
        val v00 = a[0][0] * b[0][0] + a[1][0] * b[0][1]
        val v01 = a[0][1] * b[0][0] + a[1][1] * b[0][1]
        val v10 = a[0][0] * b[1][0] + a[1][0] * b[1][1]
        val v11 = a[0][1] * b[1][0] + a[1][1] * b[1][1]
        val v20 = a[0][0] * b[2][0] + a[1][0] * b[2][1]
        val v21 = a[0][1] * b[2][0] + a[1][1] * b[2][1]
        val v30 = a[0][0] * b[3][0] + a[1][0] * b[3][1]
        val v31 = a[0][1] * b[3][0] + a[1][1] * b[3][1]
        res[0][0] = v00
        res[0][1] = v01
        res[1][0] = v10
        res[1][1] = v11
        res[2][0] = v20
        res[2][1] = v21
        res[3][0] = v30
        res[3][1] = v31
        return res
    }


    fun div(res: Mat2, a: Mat2, b: Float): Mat2 {
        div(res[0], a[0], b, b)
        div(res[1], a[1], b, b)
        return res
    }

    fun div(res: Mat2, a: Float, b: Mat2): Mat2 {
        div(res[0], a, a, b[0])
        div(res[1], a, a, b[1])
        return res
    }

    fun div(res: Vec2, a: Mat2, b: Vec2): Vec2 {
        val oneOverDeterminant = 1 / a.det()
        val i00 = +a[1][1] * oneOverDeterminant
        val i01 = -a[0][1] * oneOverDeterminant
        val i10 = -a[1][0] * oneOverDeterminant
        val i11 = +a[0][0] * oneOverDeterminant
        res[0] = i00 * b.x + i10 * b.y
        res[1] = i01 * b.x + i11 * b.y
        return res
    }

    fun div(res: Vec2, a: Vec2, b: Mat2): Vec2 {
        val oneOverDeterminant = 1 / b.det()
        val i00 = +b[1][1] * oneOverDeterminant
        val i01 = -b[0][1] * oneOverDeterminant
        val i10 = -b[1][0] * oneOverDeterminant
        val i11 = +b[0][0] * oneOverDeterminant
        res[0] = a.x * i00 + a.y * i01
        res[1] = a.x * i10 + a.y * i11
        return res
    }

    fun div(res: Mat2, a: Mat2, b: Mat2) = b.inverse(res) times_ a
}


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