package mat.operators

import mat.Mat2x2
import mat.Mat2x2.Companion.add
import mat.Mat2x2.Companion.div
import mat.Mat2x2.Companion.mul
import mat.Mat2x2.Companion.sub
import mat.Mat3x2
import mat.Mat4x2
import vec._2.Vec2
import vec._2.Vec2.Companion.add
import vec._2.Vec2.Companion.div
import vec._2.Vec2.Companion.mul
import vec._2.Vec2.Companion.sub

/**
 * Created by GBarbieri on 10.11.2016.
 */
interface mat2x2_operators {

    fun add(res: Mat2x2, a: Mat2x2, b: Float): Mat2x2 {
        add(res[0], a[0], b, b)
        add(res[1], a[1], b, b)
        return res
    }

    fun add(res: Mat2x2, a: Mat2x2, b: Mat2x2): Mat2x2 {
        add(res[0], a[0], b[0][0], b[0][1])
        add(res[1], a[1], b[1][0], b[1][1])
        return res
    }


    fun sub(res: Mat2x2, a: Mat2x2, b: Float): Mat2x2 {
        sub(res[0], a[0], b, b)
        sub(res[1], a[1], b, b)
        return res
    }

    fun sub(res: Mat2x2, a: Float, b: Mat2x2): Mat2x2 {
        sub(res[0], a, a, b[0])
        sub(res[1], a, a, b[1])
        return res
    }

    fun sub(res: Mat2x2, a: Mat2x2, b: Mat2x2): Mat2x2 {
        sub(res[0], a[0], b[0][0], b[0][1])
        sub(res[1], a[1], b[1][0], b[1][1])
        return res
    }


    fun mul(res: Mat2x2, a: Mat2x2, b: Float): Mat2x2 {
        mul(res[0], a[0], b, b)
        mul(res[1], a[1], b, b)
        return res
    }

    fun mul(res: Vec2, a: Mat2x2, b: Vec2): Vec2 {
        res[0] = a[0][0] * b.x + a[1][0] * b.y
        res[1] = a[0][1] * b.x + a[1][1] * b.y
        return res
    }

    fun mul(res: Vec2, a: Vec2, b: Mat2x2): Vec2 {
        res[0] = a.x * b[0][0] + a.y * b[0][1]
        res[1] = a.x * b[1][0] + a.y * b[1][1]
        return res
    }

    fun mul(res: Mat2x2, a: Mat2x2, b: Mat2x2): Mat2x2 {
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

    fun mul(res: Mat3x2, a: Mat2x2, b: Mat3x2): Mat3x2 {
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

    fun mul(res: Mat4x2, a: Mat2x2, b: Mat4x2): Mat4x2 {
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


    fun div(res: Mat2x2, a: Mat2x2, b: Float): Mat2x2 {
        div(res[0], a[0], b, b)
        div(res[1], a[1], b, b)
        return res
    }

    fun div(res: Mat2x2, a: Float, b: Mat2x2): Mat2x2 {
        div(res[0], a, a, b[0])
        div(res[1], a, a, b[1])
        return res
    }

    fun div(res: Vec2, a: Mat2x2, b: Vec2): Vec2 {
        val oneOverDeterminant = 1 / a.det()
        val i00 = +a[1][1] * oneOverDeterminant
        val i01 = -a[0][1] * oneOverDeterminant
        val i10 = -a[1][0] * oneOverDeterminant
        val i11 = +a[0][0] * oneOverDeterminant
        res[0] = i00 * b.x + i10 * b.y
        res[1] = i01 * b.x + i11 * b.y
        return res
    }

    fun div(res: Vec2, a: Vec2, b: Mat2x2): Vec2 {
        val oneOverDeterminant = 1 / b.det()
        val i00 = +b[1][1] * oneOverDeterminant
        val i01 = -b[0][1] * oneOverDeterminant
        val i10 = -b[1][0] * oneOverDeterminant
        val i11 = +b[0][0] * oneOverDeterminant
        res[0] = a.x * i00 + a.y * i01
        res[1] = a.x * i10 + a.y * i11
        return res
    }

    fun div(res: Mat2x2, a: Mat2x2, b: Mat2x2) = b.inverse(res) mul_ a
}


// -- Unary arithmetic operators --

operator fun Mat2x2.unaryPlus() = this

operator fun Mat2x2.unaryMinus() = Mat2x2(-value[0], -value[1])


// -- Increment main.and decrement operators --

operator fun Mat2x2.inc(res: Mat2x2 = Mat2x2()): Mat2x2 = add(res, this, 1f)
fun Mat2x2.inc_() = add(this, this, 1f)

operator fun Mat2x2.dec(res: Mat2x2 = Mat2x2()): Mat2x2 = sub(res, this, 1f)
fun Mat2x2.dec_() = sub(this, this, 1f)


// -- Specific binary arithmetic operators --

operator fun Mat2x2.plus(b: Float) = add(Mat2x2(), this, b)
operator fun Mat2x2.plus(b: Mat2x2) = add(Mat2x2(), this, b)

fun Mat2x2.add(b: Float, res: Mat2x2 = Mat2x2()) = add(res, this, b)
fun Mat2x2.add(b: Mat2x2, res: Mat2x2 = Mat2x2()) = add(res, this, b)

infix fun Mat2x2.add_(b: Float) = add(this, this, b)
infix fun Mat2x2.add_(b: Mat2x2) = add(this, this, b)


operator fun Mat2x2.minus(b: Float) = sub(Mat2x2(), this, b)
operator fun Mat2x2.minus(b: Mat2x2) = sub(Mat2x2(), this, b)

fun Mat2x2.sub(b: Float, res: Mat2x2 = Mat2x2()) = sub(res, this, b)
fun Mat2x2.sub(b: Mat2x2, res: Mat2x2 = Mat2x2()) = sub(res, this, b)

infix fun Mat2x2.sub_(b: Float) = sub(this, this, b)
infix fun Mat2x2.sub_(b: Mat2x2) = sub(this, this, b)


operator fun Mat2x2.times(b: Float) = mul(Mat2x2(), this, b)
operator fun Mat2x2.times(b: Vec2) = mul(Vec2(), this, b)
operator fun Mat2x2.times(b: Mat2x2) = mul(Mat2x2(), this, b)

fun Mat2x2.mul(b: Float, res: Mat2x2 = Mat2x2()) = mul(res, this, b)
fun Mat2x2.mul(b: Vec2, res: Vec2 = Vec2()) = mul(res, this, b)
fun Mat2x2.mul(b: Mat2x2, res: Mat2x2 = Mat2x2()) = mul(res, this, b)

infix fun Mat2x2.mul_(b: Float) = mul(this, this, b)
infix fun Mat2x2.mul_(b: Vec2) = mul(b, this, b)
infix fun Mat2x2.mul_(b: Mat2x2) = mul(this, this, b)


operator fun Mat2x2.div(b: Float) = div(Mat2x2(), this, b)
operator fun Mat2x2.div(b: Mat2x2) = div(Mat2x2(), this, b)

fun Mat2x2.div(b: Float, res: Mat2x2 = Mat2x2()) = div(res, this, b)
fun Mat2x2.div(b: Mat2x2, res: Mat2x2 = Mat2x2()) = div(res, this, b)

infix fun Mat2x2.div_(b: Float) = div(this, this, b)
infix fun Mat2x2.div_(b: Mat2x2) = div(this, this, b)


// -- Specific binary arithmetic operators --

operator fun Float.plus(b: Mat2x2) = add(Mat2x2(), b, this)
fun Float.add(b: Mat2x2, res: Mat2x2 = Mat2x2()) = add(res, b, this)
infix fun Float.add_(b: Mat2x2) = add(b, b, this)

operator fun Float.minus(b: Mat2x2) = sub(Mat2x2(), this, b)
fun Float.sub(b: Mat2x2, res: Mat2x2 = Mat2x2()) = sub(res, this, b)
infix fun Float.sub_(b: Mat2x2) = sub(b, this, b)

operator fun Float.times(b: Mat2x2) = mul(Mat2x2(), b, this)
fun Float.mul(b: Mat2x2, res: Mat2x2 = Mat2x2()) = mul(res, b, this)
infix fun Float.mul_(b: Mat2x2) = mul(b, b, this)

operator fun Vec2.times(b: Mat2x2) = mul(Vec2(), this, b)
fun Vec2.mul(b: Mat2x2, res: Vec2 = Vec2()) = mul(res, this, b)
infix fun Vec2.mul_(b: Mat2x2) = mul(this, this, b)

operator fun Float.div(b: Mat2x2) = div(Mat2x2(), this, b)
fun Float.div(b: Mat2x2, res: Mat2x2 = Mat2x2()) = div(res, this, b)
infix fun Float.div_(b: Mat2x2) = div(b, this, b)