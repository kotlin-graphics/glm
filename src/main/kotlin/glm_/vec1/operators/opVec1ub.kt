package glm_.vec1.operators

import glm_.*
import glm_.vec1.Vec1ub
import glm_.vec1.Vec1ub.Companion.div
import glm_.vec1.Vec1ub.Companion.minus
import glm_.vec1.Vec1ub.Companion.plus
import glm_.vec1.Vec1ub.Companion.rem
import glm_.vec1.Vec1ub.Companion.times
import unsigned.*
import kotlin.experimental.and
import kotlin.experimental.inv
import kotlin.experimental.or
import kotlin.experimental.xor

/**
 * Created by GBarbieri on 08.11.2016.
 */

interface opVec1ub {

    fun plus(res: Vec1ub, a: Vec1ub, bX: Ubyte): Vec1ub {
        res.x.v = (a.x.v + bX.v).b
        return res
    }

    fun plus(res: Vec1ub, a: Vec1ub, bX: Byte): Vec1ub {
        res.x.v = (a.x.v + bX).b
        return res
    }

    fun plus(res: Vec1ub, a: Vec1ub, bX: Int): Vec1ub {
        res.x.v = (a.x.v + bX).b
        return res
    }

    fun minus(res: Vec1ub, a: Vec1ub, bX: Ubyte): Vec1ub {
        res.x.v = (a.x.v - bX.v).b
        return res
    }

    fun minus(res: Vec1ub, a: Vec1ub, bX: Byte): Vec1ub {
        res.x.v = (a.x.v - bX).b
        return res
    }

    fun minus(res: Vec1ub, a: Vec1ub, bX: Int): Vec1ub {
        res.x.v = (a.x.v - bX).b
        return res
    }

    fun minus(res: Vec1ub, aX: Ubyte, b: Vec1ub): Vec1ub {
        res.x.v = (aX.v - b.x.v).b
        return res
    }

    fun minus(res: Vec1ub, aX: Byte, b: Vec1ub): Vec1ub {
        res.x.v = (aX - b.x.v).b
        return res
    }

    fun minus(res: Vec1ub, aX: Int, b: Vec1ub): Vec1ub {
        res.x.v = (aX - b.x.v).b
        return res
    }

    fun times(res: Vec1ub, a: Vec1ub, bX: Ubyte): Vec1ub {
        res.x.v = (a.x.v * bX.v).b
        return res
    }

    fun times(res: Vec1ub, a: Vec1ub, bX: Byte): Vec1ub {
        res.x.v = (a.x.v * bX).b
        return res
    }

    fun times(res: Vec1ub, a: Vec1ub, bX: Int): Vec1ub {
        res.x.v = (a.x.v * bX).b
        return res
    }

    fun div(res: Vec1ub, a: Vec1ub, bX: Ubyte): Vec1ub {
        res.x.v = a.x.v udiv bX.v
        return res
    }

    fun div(res: Vec1ub, a: Vec1ub, bX: Byte): Vec1ub {
        res.x.v = a.x.v udiv bX
        return res
    }

    fun div(res: Vec1ub, a: Vec1ub, bX: Int): Vec1ub {
        res.x.v = a.x.v udiv bX
        return res
    }

    fun div(res: Vec1ub, aX: Ubyte, b: Vec1ub): Vec1ub {
        res.x.v = aX.v udiv b.x.v
        return res
    }

    fun div(res: Vec1ub, aX: Byte, b: Vec1ub): Vec1ub {
        res.x.v = aX udiv b.x.v
        return res
    }

    fun div(res: Vec1ub, aX: Int, b: Vec1ub): Vec1ub {
        res.x.v = (aX udiv b.x.v).b
        return res
    }

    fun rem(res: Vec1ub, a: Vec1ub, bX: Ubyte): Vec1ub {
        res.x.v = a.x.v urem bX.v
        return res
    }

    fun rem(res: Vec1ub, a: Vec1ub, bX: Byte): Vec1ub {
        res.x.v = a.x.v urem bX
        return res
    }

    fun rem(res: Vec1ub, a: Vec1ub, bX: Int): Vec1ub {
        res.x.v = a.x.v urem bX
        return res
    }

    fun rem(res: Vec1ub, aX: Ubyte, b: Vec1ub): Vec1ub {
        res.x.v = aX.v urem b.x.v
        return res
    }

    fun rem(res: Vec1ub, aX: Byte, b: Vec1ub): Vec1ub {
        res.x.v = aX urem b.x.v
        return res
    }

    fun rem(res: Vec1ub, aX: Int, b: Vec1ub): Vec1ub {
        res.x.v = (aX urem b.x.v).b
        return res
    }

    fun and(res: Vec1ub, a: Vec1ub, bX: Ubyte): Vec1ub {
        res.x.v = a.x.v and bX.v
        return res
    }

    fun and(res: Vec1ub, a: Vec1ub, bX: Byte): Vec1ub {
        res.x.v = a.x.v and bX
        return res
    }

    fun and(res: Vec1ub, a: Vec1ub, bX: Int): Vec1ub {
        res.x.v = a.x.v and bX
        return res
    }

    fun or(res: Vec1ub, a: Vec1ub, bX: Ubyte): Vec1ub {
        res.x.v = a.x.v or bX
        return res
    }

    fun or(res: Vec1ub, a: Vec1ub, bX: Byte): Vec1ub {
        res.x.v = a.x.v or bX
        return res
    }

    fun or(res: Vec1ub, a: Vec1ub, bX: Int): Vec1ub {
        res.x.v = a.x.v or bX
        return res
    }

    fun xor(res: Vec1ub, a: Vec1ub, bX: Ubyte): Vec1ub {
        res.x.v = a.x.v xor bX
        return res
    }

    fun xor(res: Vec1ub, a: Vec1ub, bX: Byte): Vec1ub {
        res.x.v = a.x.v xor bX
        return res
    }

    fun xor(res: Vec1ub, a: Vec1ub, bX: Int): Vec1ub {
        res.x.v = a.x.v xor bX
        return res
    }

    fun shl(res: Vec1ub, a: Vec1ub, bX: Ubyte): Vec1ub {
        res.x.v = a.x.v shl bX
        return res
    }

    fun shl(res: Vec1ub, a: Vec1ub, bX: Byte): Vec1ub {
        res.x.v = a.x.v shl bX
        return res
    }

    fun shl(res: Vec1ub, a: Vec1ub, bX: Int): Vec1ub {
        res.x.v = a.x.v shl bX
        return res
    }

    fun shr(res: Vec1ub, a: Vec1ub, bX: Ubyte): Vec1ub {
        res.x.v = a.x.v ushr bX
        return res
    }

    fun shr(res: Vec1ub, a: Vec1ub, bX: Byte): Vec1ub {
        res.x.v = a.x.v ushr bX
        return res
    }

    fun shr(res: Vec1ub, a: Vec1ub, bX: Int): Vec1ub {
        res.x.v = a.x.v ushr bX
        return res
    }

    fun inv(res: Vec1ub, a: Vec1ub): Vec1ub {
        res.x.v = a.x.v.inv()
        return res
    }
}


// -- Specific binary arithmetic operators --

infix operator fun Ubyte.plus(b: Vec1ub) = plus(Vec1ub(), b, this)
fun Ubyte.plus(b: Vec1ub, res: Vec1ub) = plus(res, b, this)
infix fun Ubyte.plusAssign(b: Vec1ub) = plus(b, b, this)

infix operator fun Ubyte.minus(b: Vec1ub) = minus(Vec1ub(), this, b)
fun Ubyte.minus(b: Vec1ub, res: Vec1ub) = minus(res, b, this)
infix fun Ubyte.minusAssign(b: Vec1ub) = minus(b, this, b)

infix operator fun Ubyte.times(b: Vec1ub) = times(Vec1ub(), b, this)
fun Ubyte.times(b: Vec1ub, res: Vec1ub) = times(res, b, this)
infix fun Ubyte.timesAssign(b: Vec1ub) = times(b, b, this)

infix operator fun Ubyte.div(b: Vec1ub) = div(Vec1ub(), this, b)
fun Ubyte.div(b: Vec1ub, res: Vec1ub) = div(res, b, this)
infix fun Ubyte.divAssign(b: Vec1ub) = div(b, this, b)

infix operator fun Ubyte.rem(b: Vec1ub) = rem(Vec1ub(), this, b)
fun Ubyte.rem(b: Vec1ub, res: Vec1ub) = rem(res, b, this)
infix fun Ubyte.remAssign(b: Vec1ub) = rem(b, this, b)


infix operator fun Byte.plus(b: Vec1ub) = plus(Vec1ub(), b, this)
fun Byte.plus(b: Vec1ub, res: Vec1ub) = plus(res, b, this)
infix fun Byte.plusAssign(b: Vec1ub) = plus(b, b, this)

infix operator fun Byte.minus(b: Vec1ub) = minus(Vec1ub(), this, b)
fun Byte.minus(b: Vec1ub, res: Vec1ub) = minus(res, b, this)
infix fun Byte.minusAssign(b: Vec1ub) = minus(b, this, b)

infix operator fun Byte.times(b: Vec1ub) = times(Vec1ub(), b, this)
fun Byte.times(b: Vec1ub, res: Vec1ub) = times(res, b, this)
infix fun Byte.timesAssign(b: Vec1ub) = times(b, b, this)

infix operator fun Byte.div(b: Vec1ub) = div(Vec1ub(), this, b)
fun Byte.div(b: Vec1ub, res: Vec1ub) = div(res, b, this)
infix fun Byte.divAssign(b: Vec1ub) = div(b, this, b)

infix operator fun Byte.rem(b: Vec1ub) = rem(Vec1ub(), this, b)
fun Byte.rem(b: Vec1ub, res: Vec1ub) = rem(res, b, this)
infix fun Byte.remAssign(b: Vec1ub) = rem(b, this, b)


infix operator fun Int.plus(b: Vec1ub) = plus(Vec1ub(), b, this)
fun Int.plus(b: Vec1ub, res: Vec1ub) = plus(res, b, this)
infix fun Int.plusAssign(b: Vec1ub) = plus(b, b, this)

infix operator fun Int.minus(b: Vec1ub) = minus(Vec1ub(), this, b)
fun Int.minus(b: Vec1ub, res: Vec1ub) = minus(res, b, this)
infix fun Int.minusAssign(b: Vec1ub) = minus(b, this, b)

infix operator fun Int.times(b: Vec1ub) = times(Vec1ub(), b, this)
fun Int.times(b: Vec1ub, res: Vec1ub) = times(res, b, this)
infix fun Int.timesAssign(b: Vec1ub) = times(b, b, this)

infix operator fun Int.div(b: Vec1ub) = div(Vec1ub(), this, b)
fun Int.div(b: Vec1ub, res: Vec1ub) = div(res, b, this)
infix fun Int.divAssign(b: Vec1ub) = div(b, this, b)

infix operator fun Int.rem(b: Vec1ub) = rem(Vec1ub(), this, b)
fun Int.rem(b: Vec1ub, res: Vec1ub) = rem(res, b, this)
infix fun Int.remAssign(b: Vec1ub) = rem(b, this, b)


// -- Specific binary arithmetic operators --

infix operator fun Number.plus(b: Vec1ub) = plus(Vec1ub(), b, this.i)
fun Number.plus(b: Vec1ub, res: Vec1ub) = plus(res, b, this.i)
infix fun Number.plusAssign(b: Vec1ub) = plus(b, b, this.i)

infix operator fun Number.minus(b: Vec1ub) = minus(Vec1ub(), this.i, b)
fun Number.minus(b: Vec1ub, res: Vec1ub) = minus(res, b, this.i)
infix fun Number.minusAssign(b: Vec1ub) = minus(b, this.i, b)

infix operator fun Number.times(b: Vec1ub) = times(Vec1ub(), b, this.i)
fun Number.times(b: Vec1ub, res: Vec1ub) = times(res, b, this.i)
infix fun Number.timesAssign(b: Vec1ub) = times(b, b, this.i)

infix operator fun Number.div(b: Vec1ub) = div(Vec1ub(), this.i, b)
fun Number.div(b: Vec1ub, res: Vec1ub) = div(res, b, this.i)
infix fun Number.divAssign(b: Vec1ub) = div(b, this.i, b)

infix operator fun Number.rem(b: Vec1ub) = rem(Vec1ub(), this.i, b)
fun Number.rem(b: Vec1ub, res: Vec1ub) = rem(res, b, this.i)
infix fun Number.remAssign(b: Vec1ub) = rem(b, this.i, b)