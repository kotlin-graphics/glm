package glm_.mat2x2.operators

import glm_.mat2x2.Mat2d
import glm_.mat2x2.Mat2d.Companion.plus
import glm_.mat2x2.Mat2d.Companion.div
import glm_.mat2x2.Mat2d.Companion.times
import glm_.mat2x2.Mat2d.Companion.minus
import glm_.mat3x2.Mat3x2d
import glm_.mat4x2.Mat4x2d
import glm_.vec2.Vec2d
import glm_.vec2.Vec2d.Companion.plus
import glm_.vec2.Vec2d.Companion.div
import glm_.vec2.Vec2d.Companion.times
import glm_.vec2.Vec2d.Companion.minus

/**
 * Created by GBarbieri on 10.11.2016.
 */
interface mat2d_operators {

    fun plus(res: Mat2d, a: Mat2d, b: Double): Mat2d {
        plus(res[0], a[0], b, b)
        plus(res[1], a[1], b, b)
        return res
    }

    fun plus(res: Mat2d, a: Mat2d, b: Mat2d): Mat2d {
        plus(res[0], a[0], b[0][0], b[0][1])
        plus(res[1], a[1], b[1][0], b[1][1])
        return res
    }


    fun minus(res: Mat2d, a: Mat2d, b: Double): Mat2d {
        minus(res[0], a[0], b, b)
        minus(res[1], a[1], b, b)
        return res
    }

    fun minus(res: Mat2d, a: Double, b: Mat2d): Mat2d {
        minus(res[0], a, a, b[0])
        minus(res[1], a, a, b[1])
        return res
    }

    fun minus(res: Mat2d, a: Mat2d, b: Mat2d): Mat2d {
        minus(res[0], a[0], b[0][0], b[0][1])
        minus(res[1], a[1], b[1][0], b[1][1])
        return res
    }


    fun times(res: Mat2d, a: Mat2d, b: Double): Mat2d {
        times(res[0], a[0], b, b)
        times(res[1], a[1], b, b)
        return res
    }

    fun times(res: Vec2d, a: Mat2d, b: Vec2d): Vec2d {
        res[0] = a[0][0] * b.x + a[1][0] * b.y
        res[1] = a[0][1] * b.x + a[1][1] * b.y
        return res
    }

    fun times(res: Vec2d, a: Vec2d, b: Mat2d): Vec2d {
        res[0] = a.x * b[0][0] + a.y * b[0][1]
        res[1] = a.x * b[1][0] + a.y * b[1][1]
        return res
    }

    fun times(res: Mat2d, a: Mat2d, b: Mat2d): Mat2d {
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

    fun times(res: Mat3x2d, a: Mat2d, b: Mat3x2d): Mat3x2d {
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

    fun times(res: Mat4x2d, a: Mat2d, b: Mat4x2d): Mat4x2d {
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


    fun div(res: Mat2d, a: Mat2d, b: Double): Mat2d {
        div(res[0], a[0], b, b)
        div(res[1], a[1], b, b)
        return res
    }

    fun div(res: Mat2d, a: Double, b: Mat2d): Mat2d {
        div(res[0], a, a, b[0])
        div(res[1], a, a, b[1])
        return res
    }

    fun div(res: Vec2d, a: Mat2d, b: Vec2d): Vec2d {
        val oneOverDeterminant = 1 / a.det()
        val i00 = +a[1][1] * oneOverDeterminant
        val i01 = -a[0][1] * oneOverDeterminant
        val i10 = -a[1][0] * oneOverDeterminant
        val i11 = +a[0][0] * oneOverDeterminant
        res[0] = i00 * b.x + i10 * b.y
        res[1] = i01 * b.x + i11 * b.y
        return res
    }

    fun div(res: Vec2d, a: Vec2d, b: Mat2d): Vec2d {
        val oneOverDeterminant = 1 / b.det()
        val i00 = +b[1][1] * oneOverDeterminant
        val i01 = -b[0][1] * oneOverDeterminant
        val i10 = -b[1][0] * oneOverDeterminant
        val i11 = +b[0][0] * oneOverDeterminant
        res[0] = a.x * i00 + a.y * i01
        res[1] = a.x * i10 + a.y * i11
        return res
    }

    fun div(res: Mat2d, a: Mat2d, b: Mat2d) = b.inverse(res) times_ a
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