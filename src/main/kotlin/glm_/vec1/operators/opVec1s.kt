package glm_.vec1.operators

import glm_.*
import glm_.vec1.Vec1s
import glm_.vec1.Vec1s.Companion.div
import glm_.vec1.Vec1s.Companion.minus
import glm_.vec1.Vec1s.Companion.plus
import glm_.vec1.Vec1s.Companion.rem
import glm_.vec1.Vec1s.Companion.times
import kotlin.experimental.and
import kotlin.experimental.inv
import kotlin.experimental.or
import kotlin.experimental.xor

/**
 * Created by GBarbieri on 08.11.2016.
 */
interface opVec1s {

    fun plus(res: Vec1s, a: Vec1s, bX: Short): Vec1s {
        res.x = (a.x + bX).s
        return res
    }

    fun plus(res: Vec1s, a: Vec1s, bX: Int): Vec1s {
        res.x = (a.x + bX).s
        return res
    }

    fun minus(res: Vec1s, a: Vec1s, bX: Short): Vec1s {
        res.x = (a.x - bX).s
        return res
    }

    fun minus(res: Vec1s, a: Vec1s, bX: Int): Vec1s {
        res.x = (a.x - bX).s
        return res
    }

    fun minus(res: Vec1s, aX: Short, b: Vec1s): Vec1s {
        res.x = (aX - b.x).s
        return res
    }

    fun minus(res: Vec1s, aX: Int, b: Vec1s): Vec1s {
        res.x = (aX - b.x).s
        return res
    }

    fun times(res: Vec1s, a: Vec1s, bX: Short): Vec1s {
        res.x = (a.x * bX).s
        return res
    }

    fun times(res: Vec1s, a: Vec1s, bX: Int): Vec1s {
        res.x = (a.x * bX).s
        return res
    }

    fun div(res: Vec1s, a: Vec1s, bX: Short): Vec1s {
        res.x = (a.x / bX).s
        return res
    }

    fun div(res: Vec1s, a: Vec1s, bX: Int): Vec1s {
        res.x = (a.x / bX).s
        return res
    }

    fun div(res: Vec1s, aX: Short, b: Vec1s): Vec1s {
        res.x = (aX / b.x).s
        return res
    }

    fun div(res: Vec1s, aX: Int, b: Vec1s): Vec1s {
        res.x = (aX / b.x).s
        return res
    }

    fun rem(res: Vec1s, a: Vec1s, bX: Short): Vec1s {
        res.x = (a.x % bX).s
        return res
    }

    fun rem(res: Vec1s, a: Vec1s, bX: Int): Vec1s {
        res.x = (a.x % bX).s
        return res
    }

    fun rem(res: Vec1s, aX: Short, b: Vec1s): Vec1s {
        res.x = (aX % b.x).s
        return res
    }

    fun rem(res: Vec1s, aX: Int, b: Vec1s): Vec1s {
        res.x = (aX % b.x).s
        return res
    }

    fun and(res: Vec1s, a: Vec1s, bX: Short): Vec1s {
        res.x = a.x and bX
        return res
    }

    fun and(res: Vec1s, a: Vec1s, bX: Int): Vec1s {
        res.x = a.x and bX
        return res
    }

    fun or(res: Vec1s, a: Vec1s, bX: Short): Vec1s {
        res.x = a.x or bX
        return res
    }

    fun or(res: Vec1s, a: Vec1s, bX: Int): Vec1s {
        res.x = a.x or bX
        return res
    }

    fun xor(res: Vec1s, a: Vec1s, bX: Short): Vec1s {
        res.x = a.x xor bX
        return res
    }

    fun xor(res: Vec1s, a: Vec1s, bX: Int): Vec1s {
        res.x = a.x xor bX
        return res
    }

    fun shl(res: Vec1s, a: Vec1s, bX: Short): Vec1s {
        res.x = a.x shl bX
        return res
    }

    fun shl(res: Vec1s, a: Vec1s, bX: Int): Vec1s {
        res.x = a.x shl bX
        return res
    }

    fun shr(res: Vec1s, a: Vec1s, bX: Short): Vec1s {
        res.x = a.x shr bX
        return res
    }

    fun shr(res: Vec1s, a: Vec1s, bX: Int): Vec1s {
        res.x = a.x shr bX
        return res
    }

    fun inv(res: Vec1s, a: Vec1s): Vec1s {
        res.x = a.x.inv()
        return res
    }
}


// -- Specific binary arithmetic operators --

infix operator fun Short.plus(b: Vec1s) = plus(Vec1s(), b, this)
fun Short.plus(b: Vec1s, res: Vec1s) = plus(res, b, this)
infix fun Short.plusAssign(b: Vec1s) = plus(b, b, this)

infix operator fun Short.minus(b: Vec1s) = minus(Vec1s(), this, b)
fun Short.minus(b: Vec1s, res: Vec1s) = minus(res, b, this)
infix fun Short.minusAssign(b: Vec1s) = minus(b, this, b)

infix operator fun Short.times(b: Vec1s) = times(Vec1s(), b, this)
fun Short.times(b: Vec1s, res: Vec1s) = times(res, b, this)
infix fun Short.timesAssign(b: Vec1s) = times(b, b, this)

infix operator fun Short.div(b: Vec1s) = div(Vec1s(), this, b)
fun Short.div(b: Vec1s, res: Vec1s) = div(res, b, this)
infix fun Short.divAssign(b: Vec1s) = div(b, this, b)

infix operator fun Short.rem(b: Vec1s) = rem(Vec1s(), this, b)
fun Short.rem(b: Vec1s, res: Vec1s) = rem(res, b, this)
infix fun Short.remAssign(b: Vec1s) = rem(b, this, b)


infix operator fun Int.plus(b: Vec1s) = plus(Vec1s(), b, this)
fun Int.plus(b: Vec1s, res: Vec1s) = plus(res, b, this)
infix fun Int.plusAssign(b: Vec1s) = plus(b, b, this)

infix operator fun Int.minus(b: Vec1s) = minus(Vec1s(), this, b)
fun Int.minus(b: Vec1s, res: Vec1s) = minus(res, b, this)
infix fun Int.minusAssign(b: Vec1s) = minus(b, this, b)

infix operator fun Int.times(b: Vec1s) = times(Vec1s(), b, this)
fun Int.times(b: Vec1s, res: Vec1s) = times(res, b, this)
infix fun Int.timesAssign(b: Vec1s) = times(b, b, this)

infix operator fun Int.div(b: Vec1s) = div(Vec1s(), this, b)
fun Int.div(b: Vec1s, res: Vec1s) = div(res, b, this)
infix fun Int.divAssign(b: Vec1s) = div(b, this, b)

infix operator fun Int.rem(b: Vec1s) = rem(Vec1s(), this, b)
fun Int.rem(b: Vec1s, res: Vec1s) = rem(res, b, this)
infix fun Int.remAssign(b: Vec1s) = rem(b, this, b)


// -- Specific binary arithmetic operators --

infix operator fun Number.plus(b: Vec1s) = plus(Vec1s(), b, this.s)
fun Number.plus(b: Vec1s, res: Vec1s) = plus(res, b, this.s)
infix fun Number.plusAssign(b: Vec1s) = plus(b, b, this.s)

infix operator fun Number.minus(b: Vec1s) = minus(Vec1s(), this.s, b)
fun Number.minus(b: Vec1s, res: Vec1s) = minus(res, b, this.s)
infix fun Number.minusAssign(b: Vec1s) = minus(b, this.s, b)

infix operator fun Number.times(b: Vec1s) = times(Vec1s(), b, this.s)
fun Number.times(b: Vec1s, res: Vec1s) = times(res, b, this.s)
infix fun Number.timesAssign(b: Vec1s) = times(b, b, this.s)

infix operator fun Number.div(b: Vec1s) = div(Vec1s(), this.s, b)
fun Number.div(b: Vec1s, res: Vec1s) = div(res, b, this.s)
infix fun Number.divAssign(b: Vec1s) = div(b, this.s, b)

infix operator fun Number.rem(b: Vec1s) = rem(Vec1s(), this.s, b)
fun Number.rem(b: Vec1s, res: Vec1s) = rem(res, b, this.s)
infix fun Number.remAssign(b: Vec1s) = rem(b, this.s, b)