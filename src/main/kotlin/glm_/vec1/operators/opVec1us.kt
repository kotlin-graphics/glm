package glm_.vec1.operators

import glm_.*
import glm_.vec1.Vec1us
import glm_.vec1.Vec1us.Companion.div
import glm_.vec1.Vec1us.Companion.minus
import glm_.vec1.Vec1us.Companion.plus
import glm_.vec1.Vec1us.Companion.rem
import glm_.vec1.Vec1us.Companion.times
import unsigned.*
import kotlin.experimental.and
import kotlin.experimental.inv
import kotlin.experimental.or
import kotlin.experimental.xor

/**
 * Created by elect on 09/11/16.
 */

interface opVec1us {

    fun plus(res: Vec1us, a: Vec1us, bX: Ushort): Vec1us {
        res.x.v = (a.x.v + bX.v).s
        return res
    }

    fun plus(res: Vec1us, a: Vec1us, bX: Short): Vec1us {
        res.x.v = (a.x.v + bX).s
        return res
    }

    fun plus(res: Vec1us, a: Vec1us, bX: Int): Vec1us {
        res.x.v = (a.x.v + bX).s
        return res
    }

    fun minus(res: Vec1us, a: Vec1us, bX: Ushort): Vec1us {
        res.x.v = (a.x.v - bX.v).s
        return res
    }

    fun minus(res: Vec1us, a: Vec1us, bX: Short): Vec1us {
        res.x.v = (a.x.v - bX).s
        return res
    }

    fun minus(res: Vec1us, a: Vec1us, bX: Int): Vec1us {
        res.x.v = (a.x.v - bX).s
        return res
    }

    fun minus(res: Vec1us, aX: Ushort, b: Vec1us): Vec1us {
        res.x.v = (aX.v - b.x.v).s
        return res
    }

    fun minus(res: Vec1us, aX: Short, b: Vec1us): Vec1us {
        res.x.v = (aX - b.x.v).s
        return res
    }

    fun minus(res: Vec1us, aX: Int, b: Vec1us): Vec1us {
        res.x.v = (aX - b.x.v).s
        return res
    }

    fun times(res: Vec1us, a: Vec1us, bX: Ushort): Vec1us {
        res.x.v = (a.x.v * bX.v).s
        return res
    }

    fun times(res: Vec1us, a: Vec1us, bX: Short): Vec1us {
        res.x.v = (a.x.v * bX).s
        return res
    }

    fun times(res: Vec1us, a: Vec1us, bX: Int): Vec1us {
        res.x.v = (a.x.v * bX).s
        return res
    }

    fun div(res: Vec1us, a: Vec1us, bX: Ushort): Vec1us {
        res.x.v = a.x.v udiv bX.v
        return res
    }

    fun div(res: Vec1us, a: Vec1us, bX: Short): Vec1us {
        res.x.v = a.x.v udiv bX
        return res
    }

    fun div(res: Vec1us, a: Vec1us, bX: Int): Vec1us {
        res.x.v = a.x.v udiv bX
        return res
    }

    fun div(res: Vec1us, aX: Ushort, b: Vec1us): Vec1us {
        res.x.v = aX.v udiv b.x.v
        return res
    }

    fun div(res: Vec1us, aX: Short, b: Vec1us): Vec1us {
        res.x.v = aX udiv b.x.v
        return res
    }

    fun div(res: Vec1us, aX: Int, b: Vec1us): Vec1us {
        res.x.v = (aX udiv b.x.v).s
        return res
    }

    fun rem(res: Vec1us, a: Vec1us, bX: Ushort): Vec1us {
        res.x.v = a.x.v urem bX.v
        return res
    }

    fun rem(res: Vec1us, a: Vec1us, bX: Short): Vec1us {
        res.x.v = a.x.v urem bX
        return res
    }

    fun rem(res: Vec1us, a: Vec1us, bX: Int): Vec1us {
        res.x.v = a.x.v urem bX
        return res
    }

    fun rem(res: Vec1us, aX: Ushort, b: Vec1us): Vec1us {
        res.x.v = aX.v urem b.x.v
        return res
    }

    fun rem(res: Vec1us, aX: Short, b: Vec1us): Vec1us {
        res.x.v = aX urem b.x.v
        return res
    }

    fun rem(res: Vec1us, aX: Int, b: Vec1us): Vec1us {
        res.x.v = (aX urem b.x.v).s
        return res
    }

    fun and(res: Vec1us, a: Vec1us, bX: Ushort): Vec1us {
        res.x.v = a.x.v and bX.v
        return res
    }

    fun and(res: Vec1us, a: Vec1us, bX: Short): Vec1us {
        res.x.v = a.x.v and bX
        return res
    }

    fun and(res: Vec1us, a: Vec1us, bX: Int): Vec1us {
        res.x.v = a.x.v and bX
        return res
    }

    fun or(res: Vec1us, a: Vec1us, bX: Ushort): Vec1us {
        res.x.v = a.x.v or bX
        return res
    }

    fun or(res: Vec1us, a: Vec1us, bX: Short): Vec1us {
        res.x.v = a.x.v or bX
        return res
    }

    fun or(res: Vec1us, a: Vec1us, bX: Int): Vec1us {
        res.x.v = a.x.v or bX
        return res
    }

    fun xor(res: Vec1us, a: Vec1us, bX: Ushort): Vec1us {
        res.x.v = a.x.v xor bX
        return res
    }

    fun xor(res: Vec1us, a: Vec1us, bX: Short): Vec1us {
        res.x.v = a.x.v xor bX
        return res
    }

    fun xor(res: Vec1us, a: Vec1us, bX: Int): Vec1us {
        res.x.v = a.x.v xor bX
        return res
    }

    fun shl(res: Vec1us, a: Vec1us, bX: Ushort): Vec1us {
        res.x.v = a.x.v shl bX
        return res
    }

    fun shl(res: Vec1us, a: Vec1us, bX: Short): Vec1us {
        res.x.v = a.x.v shl bX
        return res
    }

    fun shl(res: Vec1us, a: Vec1us, bX: Int): Vec1us {
        res.x.v = a.x.v shl bX
        return res
    }

    fun shr(res: Vec1us, a: Vec1us, bX: Ushort): Vec1us {
        res.x.v = a.x.v ushr bX.v
        return res
    }

    fun shr(res: Vec1us, a: Vec1us, bX: Short): Vec1us {
        res.x.v = a.x.v ushr bX
        return res
    }

    fun shr(res: Vec1us, a: Vec1us, bX: Int): Vec1us {
        res.x.v = a.x.v ushr bX
        return res
    }

    fun inv(res: Vec1us, a: Vec1us): Vec1us {
        res.x.v = a.x.v.inv()
        return res
    }
}


// -- Specific binary arithmetic operators --

infix operator fun Ushort.plus(b: Vec1us) = plus(Vec1us(), b, this)
fun Ushort.plus(b: Vec1us, res: Vec1us) = plus(res, b, this)
infix fun Ushort.plusAssign(b: Vec1us) = plus(b, b, this)

infix operator fun Ushort.minus(b: Vec1us) = minus(Vec1us(), this, b)
fun Ushort.minus(b: Vec1us, res: Vec1us) = minus(res, this, b)
infix fun Ushort.minusAssign(b: Vec1us) = minus(b, this, b)

infix operator fun Ushort.times(b: Vec1us) = times(Vec1us(), b, this)
fun Ushort.times(b: Vec1us, res: Vec1us) = times(res, b, this)
infix fun Ushort.timesAssign(b: Vec1us) = times(b, b, this)

infix operator fun Ushort.div(b: Vec1us) = div(Vec1us(), this, b)
fun Ushort.div(b: Vec1us, res: Vec1us) = div(res, this, b)
infix fun Ushort.divAssign(b: Vec1us) = div(b, this, b)

infix operator fun Ushort.rem(b: Vec1us) = rem(Vec1us(), this, b)
fun Ushort.rem(b: Vec1us, res: Vec1us) = rem(res, this, b)
infix fun Ushort.remAssign(b: Vec1us) = rem(b, this, b)


infix operator fun Short.plus(b: Vec1us) = plus(Vec1us(), b, this)
fun Short.plus(b: Vec1us, res: Vec1us) = plus(res, b, this)
infix fun Short.plusAssign(b: Vec1us) = plus(b, b, this)

infix operator fun Short.minus(b: Vec1us) = minus(Vec1us(), this, b)
fun Short.minus(b: Vec1us, res: Vec1us) = minus(res, this, b)
infix fun Short.minusAssign(b: Vec1us) = minus(b, this, b)

infix operator fun Short.times(b: Vec1us) = times(Vec1us(), b, this)
fun Short.times(b: Vec1us, res: Vec1us) = times(res, b, this)
infix fun Short.timesAssign(b: Vec1us) = times(b, b, this)

infix operator fun Short.div(b: Vec1us) = div(Vec1us(), this, b)
fun Short.div(b: Vec1us, res: Vec1us) = div(res, this, b)
infix fun Short.divAssign(b: Vec1us) = div(b, this, b)

infix operator fun Short.rem(b: Vec1us) = rem(Vec1us(), this, b)
fun Short.rem(b: Vec1us, res: Vec1us) = rem(res, this, b)
infix fun Short.remAssign(b: Vec1us) = rem(b, this, b)


infix operator fun Int.plus(b: Vec1us) = plus(Vec1us(), b, this)
fun Int.plus(b: Vec1us, res: Vec1us) = plus(res, b, this)
infix fun Int.plusAssign(b: Vec1us) = plus(b, b, this)

infix operator fun Int.minus(b: Vec1us) = minus(Vec1us(), this, b)
fun Int.minus(b: Vec1us, res: Vec1us) = minus(res, this, b)
infix fun Int.minusAssign(b: Vec1us) = minus(b, this, b)

infix operator fun Int.times(b: Vec1us) = times(Vec1us(), b, this)
fun Int.times(b: Vec1us, res: Vec1us) = times(res, b, this)
infix fun Int.timesAssign(b: Vec1us) = times(b, b, this)

infix operator fun Int.div(b: Vec1us) = div(Vec1us(), this, b)
fun Int.div(b: Vec1us, res: Vec1us) = div(res, this, b)
infix fun Int.divAssign(b: Vec1us) = div(b, this, b)

infix operator fun Int.rem(b: Vec1us) = rem(Vec1us(), this, b)
fun Int.rem(b: Vec1us, res: Vec1us) = rem(res, this, b)
infix fun Int.remAssign(b: Vec1us) = rem(b, this, b)


// -- Generic binary arithmetic operators --

infix operator fun Number.plus(b: Vec1us) = plus(Vec1us(), b, this.i)
fun Number.plus(b: Vec1us, res: Vec1us) = plus(res, b, this.i)
infix fun Number.plusAssign(b: Vec1us) = plus(b, b, this.i)

infix operator fun Number.minus(b: Vec1us) = minus(Vec1us(), this.i, b)
fun Number.minus(b: Vec1us, res: Vec1us) = minus(res, this.i, b)
infix fun Number.minusAssign(b: Vec1us) = minus(b, this.i, b)

infix operator fun Number.times(b: Vec1us) = times(Vec1us(), b, this.i)
fun Number.times(b: Vec1us, res: Vec1us) = times(res, b, this.i)
infix fun Number.timesAssign(b: Vec1us) = times(b, b, this.i)

infix operator fun Number.div(b: Vec1us) = div(Vec1us(), this.i, b)
fun Number.div(b: Vec1us, res: Vec1us) = div(res, this.i, b)
infix fun Number.divAssign(b: Vec1us) = div(b, this.i, b)

infix operator fun Number.rem(b: Vec1us) = rem(Vec1us(), this.i, b)
fun Number.rem(b: Vec1us, res: Vec1us) = rem(res, this.i, b)
infix fun Number.remAssign(b: Vec1us) = rem(b, this.i, b)