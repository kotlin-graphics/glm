package glm_.vec1.operators

import glm_.*
import glm_.vec1.Vec1l
import glm_.vec1.Vec1l.Companion.div
import glm_.vec1.Vec1l.Companion.minus
import glm_.vec1.Vec1l.Companion.plus
import glm_.vec1.Vec1l.Companion.rem
import glm_.vec1.Vec1l.Companion.times


/**
 * Created by GBarbieri on 08.11.2016.
 */
interface opVec1l {

    fun plus(res: Vec1l, a: Vec1l, bX: Int): Vec1l {
        res.x = a.x + bX
        return res
    }

    fun plus(res: Vec1l, a: Vec1l, bX: Long): Vec1l {
        res.x = a.x + bX
        return res
    }

    fun minus(res: Vec1l, a: Vec1l, bX: Int): Vec1l {
        res.x = a.x - bX
        return res
    }

    fun minus(res: Vec1l, a: Vec1l, bX: Long): Vec1l {
        res.x = a.x - bX
        return res
    }

    fun minus(res: Vec1l, aX: Int, b: Vec1l): Vec1l {
        res.x = aX - b.x
        return res
    }

    fun minus(res: Vec1l, aX: Long, b: Vec1l): Vec1l {
        res.x = aX - b.x
        return res
    }

    fun times(res: Vec1l, a: Vec1l, bX: Int): Vec1l {
        res.x = a.x * bX
        return res
    }

    fun times(res: Vec1l, a: Vec1l, bX: Long): Vec1l {
        res.x = a.x * bX
        return res
    }

    fun div(res: Vec1l, a: Vec1l, bX: Int): Vec1l {
        res.x = a.x / bX
        return res
    }

    fun div(res: Vec1l, a: Vec1l, bX: Long): Vec1l {
        res.x = a.x / bX
        return res
    }

    fun div(res: Vec1l, aX: Int, b: Vec1l): Vec1l {
        res.x = aX / b.x
        return res
    }

    fun div(res: Vec1l, aX: Long, b: Vec1l): Vec1l {
        res.x = aX / b.x
        return res
    }

    fun rem(res: Vec1l, a: Vec1l, bX: Int): Vec1l {
        res.x = a.x % bX
        return res
    }

    fun rem(res: Vec1l, a: Vec1l, bX: Long): Vec1l {
        res.x = a.x % bX
        return res
    }

    fun rem(res: Vec1l, aX: Int, b: Vec1l): Vec1l {
        res.x = aX % b.x
        return res
    }

    fun rem(res: Vec1l, aX: Long, b: Vec1l): Vec1l {
        res.x = aX % b.x
        return res
    }

    fun and(res: Vec1l, a: Vec1l, bX: Int): Vec1l {
        res.x = a.x and bX
        return res
    }

    fun and(res: Vec1l, a: Vec1l, bX: Long): Vec1l {
        res.x = a.x and bX
        return res
    }

    fun or(res: Vec1l, a: Vec1l, bX: Int): Vec1l {
        res.x = a.x or bX
        return res
    }

    fun or(res: Vec1l, a: Vec1l, bX: Long): Vec1l {
        res.x = a.x or bX
        return res
    }

    fun xor(res: Vec1l, a: Vec1l, bX: Int): Vec1l {
        res.x = a.x xor bX
        return res
    }

    fun xor(res: Vec1l, a: Vec1l, bX: Long): Vec1l {
        res.x = a.x xor bX
        return res
    }

    fun shl(res: Vec1l, a: Vec1l, bX: Long): Vec1l {
        res.x = a.x shl bX.i
        return res
    }

    fun shl(res: Vec1l, a: Vec1l, bX: Int): Vec1l {
        res.x = a.x shl bX
        return res
    }

    fun shr(res: Vec1l, a: Vec1l, bX: Long): Vec1l {
        res.x = a.x shr bX.i
        return res
    }

    fun shr(res: Vec1l, a: Vec1l, bX: Int): Vec1l {
        res.x = a.x shr bX
        return res
    }

    fun inv(res: Vec1l, a: Vec1l): Vec1l {
        res.x = a.x.inv()
        return res
    }
}


// -- Specific binary arithmetic operators --

infix operator fun Long.plus(b: Vec1l) = plus(Vec1l(), b, this)
fun Long.plus(b: Vec1l, res: Vec1l) = plus(res, b, this)
infix fun Long.plusAssign(b: Vec1l) = plus(b, b, this)

infix operator fun Long.minus(b: Vec1l) = minus(Vec1l(), this, b)
fun Long.minus(b: Vec1l, res: Vec1l) = minus(res, b, this)
infix fun Long.minusAssign(b: Vec1l) = minus(b, this, b)

infix operator fun Long.times(b: Vec1l) = times(Vec1l(), b, this)
fun Long.times(b: Vec1l, res: Vec1l) = times(res, b, this)
infix fun Long.timesAssign(b: Vec1l) = times(b, b, this)

infix operator fun Long.div(b: Vec1l) = div(Vec1l(), this, b)
fun Long.div(b: Vec1l, res: Vec1l) = div(res, b, this)
infix fun Long.divAssign(b: Vec1l) = div(b, this, b)

infix operator fun Long.rem(b: Vec1l) = rem(Vec1l(), this, b)
fun Long.rem(b: Vec1l, res: Vec1l) = rem(res, b, this)
infix fun Long.remAssign(b: Vec1l) = rem(b, this, b)


infix operator fun Int.plus(b: Vec1l) = plus(Vec1l(), b, this)
fun Int.plus(b: Vec1l, res: Vec1l) = plus(res, b, this)
infix fun Int.plusAssign(b: Vec1l) = plus(b, b, this)

infix operator fun Int.minus(b: Vec1l) = minus(Vec1l(), this, b)
fun Int.minus(b: Vec1l, res: Vec1l) = minus(res, b, this)
infix fun Int.minusAssign(b: Vec1l) = minus(b, this, b)

infix operator fun Int.times(b: Vec1l) = times(Vec1l(), b, this)
fun Int.times(b: Vec1l, res: Vec1l) = times(res, b, this)
infix fun Int.timesAssign(b: Vec1l) = times(b, b, this)

infix operator fun Int.div(b: Vec1l) = div(Vec1l(), this, b)
fun Int.div(b: Vec1l, res: Vec1l) = div(res, b, this)
infix fun Int.divAssign(b: Vec1l) = div(b, this, b)

infix operator fun Int.rem(b: Vec1l) = rem(Vec1l(), this, b)
fun Int.rem(b: Vec1l, res: Vec1l) = rem(res, b, this)
infix fun Int.remAssign(b: Vec1l) = rem(b, this, b)


// -- Generic binary arithmetic operators --

infix operator fun Number.plus(b: Vec1l) = plus(Vec1l(), b, this.L)
fun Number.plus(b: Vec1l, res: Vec1l) = plus(res, b, this.L)
infix fun Number.plusAssign(b: Vec1l) = plus(b, b, this.L)

infix operator fun Number.minus(b: Vec1l) = minus(Vec1l(), this.L, b)
fun Number.minus(b: Vec1l, res: Vec1l) = minus(res, b, this.L)
infix fun Number.minusAssign(b: Vec1l) = minus(b, this.L, b)

infix operator fun Number.times(b: Vec1l) = times(Vec1l(), b, this.L)
fun Number.times(b: Vec1l, res: Vec1l) = times(res, b, this.L)
infix fun Number.timesAssign(b: Vec1l) = times(b, b, this.L)

infix operator fun Number.div(b: Vec1l) = div(Vec1l(), this.L, b)
fun Number.div(b: Vec1l, res: Vec1l) = div(res, b, this.L)
infix fun Number.divAssign(b: Vec1l) = div(b, this.L, b)

infix operator fun Number.rem(b: Vec1l) = rem(Vec1l(), this.L, b)
fun Number.rem(b: Vec1l, res: Vec1l) = rem(res, b, this.L)
infix fun Number.remAssign(b: Vec1l) = rem(b, this.L, b)