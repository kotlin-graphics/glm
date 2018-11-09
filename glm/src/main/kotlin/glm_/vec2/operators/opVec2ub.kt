package glm_.vec2.operators

import glm_.*
import glm_.vec2.Vec2ub
import glm_.vec2.Vec2ub.Companion.div
import glm_.vec2.Vec2ub.Companion.minus
import glm_.vec2.Vec2ub.Companion.plus
import glm_.vec2.Vec2ub.Companion.rem
import glm_.vec2.Vec2ub.Companion.times
import unsigned.*
import kotlin.experimental.and
import kotlin.experimental.inv
import kotlin.experimental.or
import kotlin.experimental.xor

/**
 * Created by GBarbieri on 08.11.2016.
 */

interface opVec2ub {

    fun plus(res: Vec2ub, a: Vec2ub, bX: Ubyte, bY: Ubyte): Vec2ub {
        res.x.v = (a.x.v + bX.v).b
        res.y.v = (a.y.v + bY.v).b
        return res
    }

    fun plus(res: Vec2ub, a: Vec2ub, bX: Byte, bY: Byte): Vec2ub {
        res.x.v = (a.x.v + bX).b
        res.y.v = (a.y.v + bY).b
        return res
    }

    fun plus(res: Vec2ub, a: Vec2ub, bX: Int, bY: Int): Vec2ub {
        res.x.v = (a.x.v + bX).b
        res.y.v = (a.y.v + bY).b
        return res
    }

    fun minus(res: Vec2ub, a: Vec2ub, bX: Ubyte, bY: Ubyte): Vec2ub {
        res.x.v = (a.x.v - bX.v).b
        res.y.v = (a.y.v - bY.v).b
        return res
    }

    fun minus(res: Vec2ub, a: Vec2ub, bX: Byte, bY: Byte): Vec2ub {
        res.x.v = (a.x.v - bX).b
        res.y.v = (a.y.v - bY).b
        return res
    }

    fun minus(res: Vec2ub, a: Vec2ub, bX: Int, bY: Int): Vec2ub {
        res.x.v = (a.x.v - bX).b
        res.y.v = (a.y.v - bY).b
        return res
    }

    fun minus(res: Vec2ub, aX: Ubyte, aY: Ubyte, b: Vec2ub): Vec2ub {
        res.x.v = (aX.v - b.x.v).b
        res.y.v = (aY.v - b.y.v).b
        return res
    }

    fun minus(res: Vec2ub, aX: Byte, aY: Byte, b: Vec2ub): Vec2ub {
        res.x.v = (aX - b.x.v).b
        res.y.v = (aY - b.y.v).b
        return res
    }

    fun minus(res: Vec2ub, aX: Int, aY: Int, b: Vec2ub): Vec2ub {
        res.x.v = (aX - b.x.v).b
        res.y.v = (aY - b.y.v).b
        return res
    }

    fun times(res: Vec2ub, a: Vec2ub, bX: Ubyte, bY: Ubyte): Vec2ub {
        res.x.v = (a.x.v * bX.v).b
        res.y.v = (a.y.v * bY.v).b
        return res
    }

    fun times(res: Vec2ub, a: Vec2ub, bX: Byte, bY: Byte): Vec2ub {
        res.x.v = (a.x.v * bX).b
        res.y.v = (a.y.v * bY).b
        return res
    }

    fun times(res: Vec2ub, a: Vec2ub, bX: Int, bY: Int): Vec2ub {
        res.x.v = (a.x.v * bX).b
        res.y.v = (a.y.v * bY).b
        return res
    }

    fun div(res: Vec2ub, a: Vec2ub, bX: Ubyte, bY: Ubyte): Vec2ub {
        res.x.v = a.x.v udiv bX.v
        res.y.v = a.y.v udiv bY.v
        return res
    }

    fun div(res: Vec2ub, a: Vec2ub, bX: Byte, bY: Byte): Vec2ub {
        res.x.v = a.x.v udiv bX
        res.y.v = a.y.v udiv bY
        return res
    }

    fun div(res: Vec2ub, a: Vec2ub, bX: Int, bY: Int): Vec2ub {
        res.x.v = a.x.v udiv bX
        res.y.v = a.y.v udiv bY
        return res
    }

    fun div(res: Vec2ub, aX: Ubyte, aY: Ubyte, b: Vec2ub): Vec2ub {
        res.x.v = aX.v udiv b.x.v
        res.y.v = aY.v udiv b.y.v
        return res
    }

    fun div(res: Vec2ub, aX: Byte, aY: Byte, b: Vec2ub): Vec2ub {
        res.x.v = aX udiv b.x.v
        res.y.v = aY udiv b.y.v
        return res
    }

    fun div(res: Vec2ub, aX: Int, aY: Int, b: Vec2ub): Vec2ub {
        res.x.v = (aX udiv b.x.v).b
        res.y.v = (aY udiv b.y.v).b
        return res
    }

    fun rem(res: Vec2ub, a: Vec2ub, bX: Ubyte, bY: Ubyte): Vec2ub {
        res.x.v = a.x.v urem bX.v
        res.y.v = a.y.v urem bY.v
        return res
    }

    fun rem(res: Vec2ub, a: Vec2ub, bX: Byte, bY: Byte): Vec2ub {
        res.x.v = a.x.v urem bX
        res.y.v = a.y.v urem bY
        return res
    }

    fun rem(res: Vec2ub, a: Vec2ub, bX: Int, bY: Int): Vec2ub {
        res.x.v = a.x.v urem bX
        res.y.v = a.y.v urem bY
        return res
    }

    fun rem(res: Vec2ub, aX: Ubyte, aY: Ubyte, b: Vec2ub): Vec2ub {
        res.x.v = aX.v urem b.x.v
        res.y.v = aY.v urem b.y.v
        return res
    }

    fun rem(res: Vec2ub, aX: Byte, aY: Byte, b: Vec2ub): Vec2ub {
        res.x.v = aX urem b.x.v
        res.y.v = aY urem b.y.v
        return res
    }

    fun rem(res: Vec2ub, aX: Int, aY: Int, b: Vec2ub): Vec2ub {
        res.x.v = (aX urem b.x.v).b
        res.y.v = (aY urem b.y.v).b
        return res
    }

    fun and(res: Vec2ub, a: Vec2ub, bX: Ubyte, bY: Ubyte): Vec2ub {
        res.x.v = a.x.v and bX.v
        res.y.v = a.y.v and bY.v
        return res
    }

    fun and(res: Vec2ub, a: Vec2ub, bX: Byte, bY: Byte): Vec2ub {
        res.x.v = a.x.v and bX
        res.y.v = a.y.v and bY
        return res
    }

    fun and(res: Vec2ub, a: Vec2ub, bX: Int, bY: Int): Vec2ub {
        res.x.v = a.x.v and bX
        res.y.v = a.y.v and bY
        return res
    }

    fun or(res: Vec2ub, a: Vec2ub, bX: Ubyte, bY: Ubyte): Vec2ub {
        res.x.v = a.x.v or bX
        res.y.v = a.y.v or bY
        return res
    }

    fun or(res: Vec2ub, a: Vec2ub, bX: Byte, bY: Byte): Vec2ub {
        res.x.v = a.x.v or bX
        res.y.v = a.y.v or bY
        return res
    }

    fun or(res: Vec2ub, a: Vec2ub, bX: Int, bY: Int): Vec2ub {
        res.x.v = a.x.v or bX
        res.y.v = a.y.v or bY
        return res
    }

    fun xor(res: Vec2ub, a: Vec2ub, bX: Ubyte, bY: Ubyte): Vec2ub {
        res.x.v = a.x.v xor bX
        res.y.v = a.y.v xor bY
        return res
    }

    fun xor(res: Vec2ub, a: Vec2ub, bX: Byte, bY: Byte): Vec2ub {
        res.x.v = a.x.v xor bX
        res.y.v = a.y.v xor bY
        return res
    }

    fun xor(res: Vec2ub, a: Vec2ub, bX: Int, bY: Int): Vec2ub {
        res.x.v = a.x.v xor bX
        res.y.v = a.y.v xor bY
        return res
    }

    fun shl(res: Vec2ub, a: Vec2ub, bX: Ubyte, bY: Ubyte): Vec2ub {
        res.x.v = a.x.v shl bX
        res.y.v = a.y.v shl bY
        return res
    }

    fun shl(res: Vec2ub, a: Vec2ub, bX: Byte, bY: Byte): Vec2ub {
        res.x.v = a.x.v shl bX
        res.y.v = a.y.v shl bY
        return res
    }

    fun shl(res: Vec2ub, a: Vec2ub, bX: Int, bY: Int): Vec2ub {
        res.x.v = a.x.v shl bX
        res.y.v = a.y.v shl bY
        return res
    }

    fun shr(res: Vec2ub, a: Vec2ub, bX: Ubyte, bY: Ubyte): Vec2ub {
        res.x.v = a.x.v ushr bX
        res.y.v = a.y.v ushr bY
        return res
    }

    fun shr(res: Vec2ub, a: Vec2ub, bX: Byte, bY: Byte): Vec2ub {
        res.x.v = a.x.v ushr bX
        res.y.v = a.y.v ushr bY
        return res
    }

    fun shr(res: Vec2ub, a: Vec2ub, bX: Int, bY: Int): Vec2ub {
        res.x.v = a.x.v ushr bX
        res.y.v = a.y.v ushr bY
        return res
    }

    fun inv(res: Vec2ub, a: Vec2ub): Vec2ub {
        res.x.v = a.x.v.inv()
        res.y.v = a.y.v.inv()
        return res
    }
}


// -- Specific binary arithmetic operators --

infix operator fun Ubyte.plus(b: Vec2ub) = plus(Vec2ub(), b, this, this)
fun Ubyte.plus(b: Vec2ub, res: Vec2ub) = plus(res, b, this, this)
infix fun Ubyte.plusAssign(b: Vec2ub) = plus(b, b, this, this)

infix operator fun Ubyte.minus(b: Vec2ub) = minus(Vec2ub(), this, this, b)
fun Ubyte.minus(b: Vec2ub, res: Vec2ub) = minus(res, b, this, this)
infix fun Ubyte.minusAssign(b: Vec2ub) = minus(b, this, this, b)

infix operator fun Ubyte.times(b: Vec2ub) = times(Vec2ub(), b, this, this)
fun Ubyte.times(b: Vec2ub, res: Vec2ub) = times(res, b, this, this)
infix fun Ubyte.timesAssign(b: Vec2ub) = times(b, b, this, this)

infix operator fun Ubyte.div(b: Vec2ub) = div(Vec2ub(), this, this, b)
fun Ubyte.div(b: Vec2ub, res: Vec2ub) = div(res, b, this, this)
infix fun Ubyte.divAssign(b: Vec2ub) = div(b, this, this, b)

infix operator fun Ubyte.rem(b: Vec2ub) = rem(Vec2ub(), this, this, b)
fun Ubyte.rem(b: Vec2ub, res: Vec2ub) = rem(res, b, this, this)
infix fun Ubyte.remAssign(b: Vec2ub) = rem(b, this, this, b)


infix operator fun Byte.plus(b: Vec2ub) = plus(Vec2ub(), b, this, this)
fun Byte.plus(b: Vec2ub, res: Vec2ub) = plus(res, b, this, this)
infix fun Byte.plusAssign(b: Vec2ub) = plus(b, b, this, this)

infix operator fun Byte.minus(b: Vec2ub) = minus(Vec2ub(), this, this, b)
fun Byte.minus(b: Vec2ub, res: Vec2ub) = minus(res, b, this, this)
infix fun Byte.minusAssign(b: Vec2ub) = minus(b, this, this, b)

infix operator fun Byte.times(b: Vec2ub) = times(Vec2ub(), b, this, this)
fun Byte.times(b: Vec2ub, res: Vec2ub) = times(res, b, this, this)
infix fun Byte.timesAssign(b: Vec2ub) = times(b, b, this, this)

infix operator fun Byte.div(b: Vec2ub) = div(Vec2ub(), this, this, b)
fun Byte.div(b: Vec2ub, res: Vec2ub) = div(res, b, this, this)
infix fun Byte.divAssign(b: Vec2ub) = div(b, this, this, b)

infix operator fun Byte.rem(b: Vec2ub) = rem(Vec2ub(), this, this, b)
fun Byte.rem(b: Vec2ub, res: Vec2ub) = rem(res, b, this, this)
infix fun Byte.remAssign(b: Vec2ub) = rem(b, this, this, b)


infix operator fun Int.plus(b: Vec2ub) = plus(Vec2ub(), b, this, this)
fun Int.plus(b: Vec2ub, res: Vec2ub) = plus(res, b, this, this)
infix fun Int.plusAssign(b: Vec2ub) = plus(b, b, this, this)

infix operator fun Int.minus(b: Vec2ub) = minus(Vec2ub(), this, this, b)
fun Int.minus(b: Vec2ub, res: Vec2ub) = minus(res, b, this, this)
infix fun Int.minusAssign(b: Vec2ub) = minus(b, this, this, b)

infix operator fun Int.times(b: Vec2ub) = times(Vec2ub(), b, this, this)
fun Int.times(b: Vec2ub, res: Vec2ub) = times(res, b, this, this)
infix fun Int.timesAssign(b: Vec2ub) = times(b, b, this, this)

infix operator fun Int.div(b: Vec2ub) = div(Vec2ub(), this, this, b)
fun Int.div(b: Vec2ub, res: Vec2ub) = div(res, b, this, this)
infix fun Int.divAssign(b: Vec2ub) = div(b, this, this, b)

infix operator fun Int.rem(b: Vec2ub) = rem(Vec2ub(), this, this, b)
fun Int.rem(b: Vec2ub, res: Vec2ub) = rem(res, b, this, this)
infix fun Int.remAssign(b: Vec2ub) = rem(b, this, this, b)


// -- Specific binary arithmetic operators --

infix operator fun Number.plus(b: Vec2ub) = plus(Vec2ub(), b, this.i, this.i)
fun Number.plus(b: Vec2ub, res: Vec2ub) = plus(res, b, this.i, this.i)
infix fun Number.plusAssign(b: Vec2ub) = plus(b, b, this.i, this.i)

infix operator fun Number.minus(b: Vec2ub) = minus(Vec2ub(), this.i, this.i, b)
fun Number.minus(b: Vec2ub, res: Vec2ub) = minus(res, b, this.i, this.i)
infix fun Number.minusAssign(b: Vec2ub) = minus(b, this.i, this.i, b)

infix operator fun Number.times(b: Vec2ub) = times(Vec2ub(), b, this.i, this.i)
fun Number.times(b: Vec2ub, res: Vec2ub) = times(res, b, this.i, this.i)
infix fun Number.timesAssign(b: Vec2ub) = times(b, b, this.i, this.i)

infix operator fun Number.div(b: Vec2ub) = div(Vec2ub(), this.i, this.i, b)
fun Number.div(b: Vec2ub, res: Vec2ub) = div(res, b, this.i, this.i)
infix fun Number.divAssign(b: Vec2ub) = div(b, this.i, this.i, b)

infix operator fun Number.rem(b: Vec2ub) = rem(Vec2ub(), this.i, this.i, b)
fun Number.rem(b: Vec2ub, res: Vec2ub) = rem(res, b, this.i, this.i)
infix fun Number.remAssign(b: Vec2ub) = rem(b, this.i, this.i, b)