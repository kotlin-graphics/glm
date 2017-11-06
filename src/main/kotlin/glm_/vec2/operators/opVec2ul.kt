package glm_.vec2.operators

import glm_.*
import glm_.vec2.Vec2ul
import glm_.vec2.Vec2ul.Companion.div
import glm_.vec2.Vec2ul.Companion.minus
import glm_.vec2.Vec2ul.Companion.plus
import glm_.vec2.Vec2ul.Companion.rem
import glm_.vec2.Vec2ul.Companion.times
import udiv
import unsigned.Ulong
import unsigned.toULong
import urem

/**
 * Created by elect on 09/11/16.
 */
open class opVec2ul {


    inline fun plus(res: Vec2ul, a: Vec2ul, bX: Int, bY: Int): Vec2ul {
        res.x.v = a.x.v + bX
        res.y.v = a.y.v + bY
        return res
    }

    inline fun plus(res: Vec2ul, a: Vec2ul, bX: Ulong, bY: Ulong): Vec2ul {
        res.x.v = a.x.v + bX.v
        res.y.v = a.y.v + bY.v
        return res
    }

    inline fun plus(res: Vec2ul, a: Vec2ul, bX: Long, bY: Long): Vec2ul {
        res.x.v = a.x.v + bX
        res.y.v = a.y.v + bY
        return res
    }


    inline fun minus(res: Vec2ul, a: Vec2ul, bX: Int, bY: Int): Vec2ul {
        res.x.v = a.x.v - bX
        res.y.v = a.y.v - bY
        return res
    }

    inline fun minus(res: Vec2ul, a: Vec2ul, bX: Ulong, bY: Ulong): Vec2ul {
        res.x.v = a.x.v - bX.v
        res.y.v = a.y.v - bY.v
        return res
    }

    inline fun minus(res: Vec2ul, a: Vec2ul, bX: Long, bY: Long): Vec2ul {
        res.x.v = a.x.v - bX
        res.y.v = a.y.v - bY
        return res
    }

    inline fun minus(res: Vec2ul, aX: Int, aY: Int, b: Vec2ul): Vec2ul {
        res.x.v = aX - b.x.v
        res.y.v = aY - b.y.v
        return res
    }

    inline fun minus(res: Vec2ul, aX: Ulong, aY: Ulong, b: Vec2ul): Vec2ul {
        res.x.v = aX.v - b.x.v
        res.y.v = aY.v - b.y.v
        return res
    }

    inline fun minus(res: Vec2ul, aX: Long, aY: Long, b: Vec2ul): Vec2ul {
        res.x.v = aX - b.x.v
        res.y.v = aY - b.y.v
        return res
    }


    inline fun times(res: Vec2ul, a: Vec2ul, bX: Int, bY: Int): Vec2ul {
        res.x.v = a.x.v * bX
        res.y.v = a.y.v * bY
        return res
    }

    inline fun times(res: Vec2ul, a: Vec2ul, bX: Ulong, bY: Ulong): Vec2ul {
        res.x.v = a.x.v * bX.v
        res.y.v = a.y.v * bY.v
        return res
    }

    inline fun times(res: Vec2ul, a: Vec2ul, bX: Long, bY: Long): Vec2ul {
        res.x.v = a.x.v * bX
        res.y.v = a.y.v * bY
        return res
    }


    inline fun div(res: Vec2ul, a: Vec2ul, bX: Int, bY: Int): Vec2ul {
        res.x.v = a.x.v udiv bX
        res.y.v = a.y.v udiv bY
        return res
    }

    inline fun div(res: Vec2ul, a: Vec2ul, bX: Ulong, bY: Ulong): Vec2ul {
        res.x.v = a.x.v udiv bX.v
        res.y.v = a.y.v udiv bY.v
        return res
    }

    inline fun div(res: Vec2ul, a: Vec2ul, bX: Long, bY: Long): Vec2ul {
        res.x.v = a.x.v udiv bX
        res.y.v = a.y.v udiv bY
        return res
    }

    inline fun div(res: Vec2ul, aX: Int, aY: Int, b: Vec2ul): Vec2ul {
        res.x.v = aX.toULong() udiv b.x.v
        res.y.v = aY.toULong() udiv b.y.v
        return res
    }

    inline fun div(res: Vec2ul, aX: Ulong, aY: Ulong, b: Vec2ul): Vec2ul {
        res.x.v = aX.v udiv b.x.v
        res.y.v = aY.v udiv b.y.v
        return res
    }

    inline fun div(res: Vec2ul, aX: Long, aY: Long, b: Vec2ul): Vec2ul {
        res.x.v = aX udiv b.x.v
        res.y.v = aY udiv b.y.v
        return res
    }


    inline fun rem(res: Vec2ul, a: Vec2ul, bX: Int, bY: Int): Vec2ul {
        res.x.v = a.x.v urem bX
        res.y.v = a.y.v urem bY
        return res
    }

    inline fun rem(res: Vec2ul, a: Vec2ul, bX: Ulong, bY: Ulong): Vec2ul {
        res.x.v = a.x.v urem bX.v
        res.y.v = a.y.v urem bY.v
        return res
    }

    inline fun rem(res: Vec2ul, a: Vec2ul, bX: Long, bY: Long): Vec2ul {
        res.x.v = a.x.v urem bX
        res.y.v = a.y.v urem bY
        return res
    }

    inline fun rem(res: Vec2ul, aX: Int, aY: Int, b: Vec2ul): Vec2ul {
        res.x.v = aX.toULong() urem b.x.v
        res.y.v = aY.toULong() urem b.y.v
        return res
    }

    inline fun rem(res: Vec2ul, aX: Ulong, aY: Ulong, b: Vec2ul): Vec2ul {
        res.x.v = aX.v urem b.x.v
        res.y.v = aY.v urem b.y.v
        return res
    }

    inline fun rem(res: Vec2ul, aX: Long, aY: Long, b: Vec2ul): Vec2ul {
        res.x.v = aX urem b.x.v
        res.y.v = aY urem b.y.v
        return res
    }


    inline fun and(res: Vec2ul, a: Vec2ul, bX: Int, bY: Int): Vec2ul {
        res.x.v = a.x.v and bX
        res.y.v = a.y.v and bY
        return res
    }

    inline fun and(res: Vec2ul, a: Vec2ul, bX: Ulong, bY: Ulong): Vec2ul {
        res.x.v = a.x.v and bX.v
        res.y.v = a.y.v and bY.v
        return res
    }

    inline fun and(res: Vec2ul, a: Vec2ul, bX: Long, bY: Long): Vec2ul {
        res.x.v = a.x.v and bX
        res.y.v = a.y.v and bY
        return res
    }


    inline fun or(res: Vec2ul, a: Vec2ul, bX: Int, bY: Int): Vec2ul {
        res.x.v = a.x.v or bX
        res.y.v = a.y.v or bY
        return res
    }

    inline fun or(res: Vec2ul, a: Vec2ul, bX: Ulong, bY: Ulong): Vec2ul {
        res.x.v = a.x.v or bX.v
        res.y.v = a.y.v or bY.v
        return res
    }

    inline fun or(res: Vec2ul, a: Vec2ul, bX: Long, bY: Long): Vec2ul {
        res.x.v = a.x.v or bX
        res.y.v = a.y.v or bY
        return res
    }


    inline fun xor(res: Vec2ul, a: Vec2ul, bX: Int, bY: Int): Vec2ul {
        res.x.v = a.x.v xor bX
        res.y.v = a.y.v xor bY
        return res
    }

    inline fun xor(res: Vec2ul, a: Vec2ul, bX: Ulong, bY: Ulong): Vec2ul {
        res.x.v = a.x.v xor bX.v
        res.y.v = a.y.v xor bY.v
        return res
    }

    inline fun xor(res: Vec2ul, a: Vec2ul, bX: Long, bY: Long): Vec2ul {
        res.x.v = a.x.v xor bX
        res.y.v = a.y.v xor bY
        return res
    }


    inline fun shl(res: Vec2ul, a: Vec2ul, bX: Int, bY: Int): Vec2ul {
        res.x.v = a.x.v shl bX
        res.y.v = a.y.v shl bY
        return res
    }

    inline fun shl(res: Vec2ul, a: Vec2ul, bX: Ulong, bY: Ulong): Vec2ul {
        res.x.v = a.x.v shl bX.v.i
        res.y.v = a.y.v shl bY.v.i
        return res
    }

    inline fun shl(res: Vec2ul, a: Vec2ul, bX: Long, bY: Long): Vec2ul {
        res.x.v = a.x.v shl bX.i
        res.y.v = a.y.v shl bY.i
        return res
    }


    inline fun shr(res: Vec2ul, a: Vec2ul, bX: Int, bY: Int): Vec2ul {
        res.x.v = a.x.v ushr bX
        res.y.v = a.y.v ushr bY
        return res
    }

    inline fun shr(res: Vec2ul, a: Vec2ul, bX: Ulong, bY: Ulong): Vec2ul {
        res.x.v = a.x.v ushr bX.v.i
        res.y.v = a.y.v ushr bY.v.i
        return res
    }

    inline fun shr(res: Vec2ul, a: Vec2ul, bX: Long, bY: Long): Vec2ul {
        res.x.v = a.x.v ushr bX.i
        res.y.v = a.y.v ushr bY.i
        return res
    }


    inline fun inv(res: Vec2ul, a: Vec2ul): Vec2ul {
        res.x.v = a.x.v.inv()
        res.y.v = a.y.v.inv()
        return res
    }
}


// -- Specific binary arithmetic operators --

infix operator fun Ulong.plus(b: Vec2ul) = plus(Vec2ul(), b, this, this)
fun Ulong.plus(b: Vec2ul, res: Vec2ul) = plus(res, b, this, this)
infix fun Ulong.plusAssign(b: Vec2ul) = plus(b, b, this, this)

infix operator fun Ulong.minus(b: Vec2ul) = minus(Vec2ul(), this, this, b)
fun Ulong.minus(b: Vec2ul, res: Vec2ul) = minus(res, this, this, b)
infix fun Ulong.minusAssign(b: Vec2ul) = minus(b, this, this, b)

infix operator fun Ulong.times(b: Vec2ul) = times(Vec2ul(), b, this, this)
fun Ulong.times(b: Vec2ul, res: Vec2ul) = times(res, b, this, this)
infix fun Ulong.timesAssign(b: Vec2ul) = times(b, b, this, this)

infix operator fun Ulong.div(b: Vec2ul) = div(Vec2ul(), this, this, b)
fun Ulong.div(b: Vec2ul, res: Vec2ul) = div(res, this, this, b)
infix fun Ulong.divAssign(b: Vec2ul) = div(b, this, this, b)

infix operator fun Ulong.rem(b: Vec2ul) = rem(Vec2ul(), this, this, b)
fun Ulong.rem(b: Vec2ul, res: Vec2ul) = rem(res, this, this, b)
infix fun Ulong.remAssign(b: Vec2ul) = rem(b, this, this, b)


infix operator fun Long.plus(b: Vec2ul) = plus(Vec2ul(), b, this, this)
fun Long.plus(b: Vec2ul, res: Vec2ul) = plus(res, b, this, this)
infix fun Long.plusAssign(b: Vec2ul) = plus(b, b, this, this)

infix operator fun Long.minus(b: Vec2ul) = minus(Vec2ul(), this, this, b)
fun Long.minus(b: Vec2ul, res: Vec2ul) = minus(res, this, this, b)
infix fun Long.minusAssign(b: Vec2ul) = minus(b, this, this, b)

infix operator fun Long.times(b: Vec2ul) = times(Vec2ul(), b, this, this)
fun Long.times(b: Vec2ul, res: Vec2ul) = times(res, b, this, this)
infix fun Long.timesAssign(b: Vec2ul) = times(b, b, this, this)

infix operator fun Long.div(b: Vec2ul) = div(Vec2ul(), this, this, b)
fun Long.divAssign(b: Vec2ul, res: Vec2ul) = div(res, this, this, b)
infix fun Long.divAssign(b: Vec2ul) = div(b, this, this, b)

infix operator fun Long.rem(b: Vec2ul) = rem(Vec2ul(), this, this, b)
fun Long.rem(b: Vec2ul, res: Vec2ul) = rem(res, this, this, b)
infix fun Long.remAssign(b: Vec2ul) = rem(b, this, this, b)


// -- Generic binary arithmetic operators --

infix operator fun Number.plus(b: Vec2ul) = plus(Vec2ul(), b, this.L, this.L)
fun Number.plus(b: Vec2ul, res: Vec2ul) = plus(res, b, this.L, this.L)
infix fun Number.plusAssign(b: Vec2ul) = plus(b, b, this.L, this.L)

infix operator fun Number.minus(b: Vec2ul) = minus(Vec2ul(), this.L, this.L, b)
fun Number.minus(b: Vec2ul, res: Vec2ul) = minus(res, this.L, this.L, b)
infix fun Number.minusAssign(b: Vec2ul) = minus(b, this.L, this.L, b)

infix operator fun Number.times(b: Vec2ul) = times(Vec2ul(), b, this.L, this.L)
fun Number.times(b: Vec2ul, res: Vec2ul) = times(res, b, this.L, this.L)
infix fun Number.timesAssign(b: Vec2ul) = times(b, b, this.L, this.L)

infix operator fun Number.div(b: Vec2ul) = div(Vec2ul(), this.L, this.L, b)
fun Number.div(b: Vec2ul, res: Vec2ul) = div(res, this.L, this.L, b)
infix fun Number.divAssign(b: Vec2ul) = div(b, this.L, this.L, b)

infix operator fun Number.rem(b: Vec2ul) = rem(Vec2ul(), this.L, this.L, b)
fun Number.remAssign(b: Vec2ul, res: Vec2ul) = rem(res, this.L, this.L, b)
infix fun Number.remAssign(b: Vec2ul) = rem(b, this.L, this.L, b)