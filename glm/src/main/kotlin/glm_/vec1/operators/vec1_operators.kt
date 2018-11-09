package glm_.vec1.operators

import glm_.f
import glm_.vec1.Vec1
import glm_.vec1.Vec1.Companion.div
import glm_.vec1.Vec1.Companion.minus
import glm_.vec1.Vec1.Companion.plus
import glm_.vec1.Vec1.Companion.rem
import glm_.vec1.Vec1.Companion.times

/**
 * Created by GBarbieri on 08.11.2016.
 */
interface vec1_operators {

    fun plus(res: Vec1, a: Vec1, bX: Float): Vec1 {
        res.x = a.x + bX
        return res
    }

    fun minus(res: Vec1, a: Vec1, bX: Float): Vec1 {
        res.x = a.x - bX
        return res
    }

    fun minus(res: Vec1, aX: Float, b: Vec1): Vec1 {
        res.x = aX - b.x
        return res
    }

    fun times(res: Vec1, a: Vec1, bX: Float): Vec1 {
        res.x = a.x * bX
        return res
    }

    fun div(res: Vec1, a: Vec1, bX: Float): Vec1 {
        res.x = a.x / bX
        return res
    }

    fun div(res: Vec1, aX: Float, b: Vec1): Vec1 {
        res.x = aX / b.x
        return res
    }

    fun rem(res: Vec1, a: Vec1, bX: Float): Vec1 {
        res.x = a.x % bX
        return res
    }

    fun rem(res: Vec1, aX: Float, b: Vec1): Vec1 {
        res.x = aX % b.x
        return res
    }
}


// -- Specific binary arithmetic operators --

infix operator fun Float.plus(b: Vec1) = plus(Vec1(), b, this)
fun Float.plus(b: Vec1, res: Vec1) = plus(res, b, this)
infix fun Float.plus_(b: Vec1) = plus(b, b, this)

infix operator fun Float.minus(b: Vec1) = minus(Vec1(), this, b)
fun Float.minus(b: Vec1, res: Vec1) = minus(res, b, this)
infix fun Float.minus_(b: Vec1) = minus(b, this, b)

infix operator fun Float.times(b: Vec1) = times(Vec1(), b, this)
fun Float.times(b: Vec1, res: Vec1) = times(res, b, this)
infix fun Float.times_(b: Vec1) = times(b, b, this)

infix operator fun Float.div(b: Vec1) = div(Vec1(), this, b)
fun Float.div(b: Vec1, res: Vec1) = div(res, b, this)
infix fun Float.div_(b: Vec1) = div(b, this, b)

infix operator fun Float.rem(b: Vec1) = rem(Vec1(), this, b)
fun Float.rem(b: Vec1, res: Vec1) = rem(res, b, this)
infix fun Float.rem_(b: Vec1) = rem(b, this, b)


// -- Generic binary arithmetic operators --

infix operator fun Number.plus(b: Vec1) = plus(Vec1(), b, this.f)
fun Number.plus(b: Vec1, res: Vec1) = plus(res, b, this.f)
infix fun Number.plus_(b: Vec1) = plus(b, b, this.f)

infix operator fun Number.minus(b: Vec1) = minus(Vec1(), this.f, b)
fun Number.minus(b: Vec1, res: Vec1) = minus(res, b, this.f)
infix fun Number.minus_(b: Vec1) = minus(b, this.f, b)

infix operator fun Number.times(b: Vec1) = times(Vec1(), b, this.f)
fun Number.times(b: Vec1, res: Vec1) = times(res, b, this.f)
infix fun Number.times_(b: Vec1) = times(b, b, this.f)

infix operator fun Number.div(b: Vec1) = div(Vec1(), this.f, b)
fun Number.div(b: Vec1, res: Vec1) = div(res, b, this.f)
infix fun Number.div_(b: Vec1) = div(b, this.f, b)

infix operator fun Number.rem(b: Vec1) = rem(Vec1(), this.f, b)
fun Number.rem(b: Vec1, res: Vec1) = rem(res, b, this.f)
infix fun Number.rem_(b: Vec1) = rem(b, this.f, b)