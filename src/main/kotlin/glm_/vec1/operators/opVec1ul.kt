package glm_.vec1.operators

import glm_.*
import glm_.vec1.Vec1ul
import glm_.vec1.Vec1ul.Companion.div
import glm_.vec1.Vec1ul.Companion.minus
import glm_.vec1.Vec1ul.Companion.plus
import glm_.vec1.Vec1ul.Companion.rem
import glm_.vec1.Vec1ul.Companion.times
import unsigned.Ulong
import unsigned.toULong
import unsigned.udiv
import unsigned.urem

/**
 * Created by elect on 09/11/16.
 */
interface opVec1ul {


    fun plus(res: Vec1ul, a: Vec1ul, bX: Int): Vec1ul {
        res.x.v = a.x.v + bX
        return res
    }

    fun plus(res: Vec1ul, a: Vec1ul, bX: Ulong): Vec1ul {
        res.x.v = a.x.v + bX.v
        return res
    }

    fun plus(res: Vec1ul, a: Vec1ul, bX: Long): Vec1ul {
        res.x.v = a.x.v + bX
        return res
    }


    fun minus(res: Vec1ul, a: Vec1ul, bX: Int): Vec1ul {
        res.x.v = a.x.v - bX
        return res
    }

    fun minus(res: Vec1ul, a: Vec1ul, bX: Ulong): Vec1ul {
        res.x.v = a.x.v - bX.v
        return res
    }

    fun minus(res: Vec1ul, a: Vec1ul, bX: Long): Vec1ul {
        res.x.v = a.x.v - bX
        return res
    }

    fun minus(res: Vec1ul, aX: Int, b: Vec1ul): Vec1ul {
        res.x.v = aX - b.x.v
        return res
    }

    fun minus(res: Vec1ul, aX: Ulong, b: Vec1ul): Vec1ul {
        res.x.v = aX.v - b.x.v
        return res
    }

    fun minus(res: Vec1ul, aX: Long, b: Vec1ul): Vec1ul {
        res.x.v = aX - b.x.v
        return res
    }


    fun times(res: Vec1ul, a: Vec1ul, bX: Int): Vec1ul {
        res.x.v = a.x.v * bX
        return res
    }

    fun times(res: Vec1ul, a: Vec1ul, bX: Ulong): Vec1ul {
        res.x.v = a.x.v * bX.v
        return res
    }

    fun times(res: Vec1ul, a: Vec1ul, bX: Long): Vec1ul {
        res.x.v = a.x.v * bX
        return res
    }


    fun div(res: Vec1ul, a: Vec1ul, bX: Int): Vec1ul {
        res.x.v = a.x.v udiv bX
        return res
    }

    fun div(res: Vec1ul, a: Vec1ul, bX: Ulong): Vec1ul {
        res.x.v = a.x.v udiv bX.v
        return res
    }

    fun div(res: Vec1ul, a: Vec1ul, bX: Long): Vec1ul {
        res.x.v = a.x.v udiv bX
        return res
    }

    fun div(res: Vec1ul, aX: Int, b: Vec1ul): Vec1ul {
        res.x.v = aX.toULong() udiv b.x.v
        return res
    }

    fun div(res: Vec1ul, aX: Ulong, b: Vec1ul): Vec1ul {
        res.x.v = aX.v udiv b.x.v
        return res
    }

    fun div(res: Vec1ul, aX: Long, b: Vec1ul): Vec1ul {
        res.x.v = aX udiv b.x.v
        return res
    }


    fun rem(res: Vec1ul, a: Vec1ul, bX: Int): Vec1ul {
        res.x.v = a.x.v urem bX
        return res
    }

    fun rem(res: Vec1ul, a: Vec1ul, bX: Ulong): Vec1ul {
        res.x.v = a.x.v urem bX.v
        return res
    }

    fun rem(res: Vec1ul, a: Vec1ul, bX: Long): Vec1ul {
        res.x.v = a.x.v urem bX
        return res
    }

    fun rem(res: Vec1ul, aX: Int, b: Vec1ul): Vec1ul {
        res.x.v = aX.toULong() urem b.x.v
        return res
    }

    fun rem(res: Vec1ul, aX: Ulong, b: Vec1ul): Vec1ul {
        res.x.v = aX.v urem b.x.v
        return res
    }

    fun rem(res: Vec1ul, aX: Long, b: Vec1ul): Vec1ul {
        res.x.v = aX urem b.x.v
        return res
    }


    fun and(res: Vec1ul, a: Vec1ul, bX: Int): Vec1ul {
        res.x.v = a.x.v and bX
        return res
    }

    fun and(res: Vec1ul, a: Vec1ul, bX: Ulong): Vec1ul {
        res.x.v = a.x.v and bX.v
        return res
    }

    fun and(res: Vec1ul, a: Vec1ul, bX: Long): Vec1ul {
        res.x.v = a.x.v and bX
        return res
    }


    fun or(res: Vec1ul, a: Vec1ul, bX: Int): Vec1ul {
        res.x.v = a.x.v or bX
        return res
    }

    fun or(res: Vec1ul, a: Vec1ul, bX: Ulong): Vec1ul {
        res.x.v = a.x.v or bX.v
        return res
    }

    fun or(res: Vec1ul, a: Vec1ul, bX: Long): Vec1ul {
        res.x.v = a.x.v or bX
        return res
    }


    fun xor(res: Vec1ul, a: Vec1ul, bX: Int): Vec1ul {
        res.x.v = a.x.v xor bX
        return res
    }

    fun xor(res: Vec1ul, a: Vec1ul, bX: Ulong): Vec1ul {
        res.x.v = a.x.v xor bX.v
        return res
    }

    fun xor(res: Vec1ul, a: Vec1ul, bX: Long): Vec1ul {
        res.x.v = a.x.v xor bX
        return res
    }


    fun shl(res: Vec1ul, a: Vec1ul, bX: Int): Vec1ul {
        res.x.v = a.x.v shl bX
        return res
    }

    fun shl(res: Vec1ul, a: Vec1ul, bX: Ulong): Vec1ul {
        res.x.v = a.x.v shl bX.v.i
        return res
    }

    fun shl(res: Vec1ul, a: Vec1ul, bX: Long): Vec1ul {
        res.x.v = a.x.v shl bX.i
        return res
    }


    fun shr(res: Vec1ul, a: Vec1ul, bX: Int): Vec1ul {
        res.x.v = a.x.v ushr bX
        return res
    }

    fun shr(res: Vec1ul, a: Vec1ul, bX: Ulong): Vec1ul {
        res.x.v = a.x.v ushr bX.v.i
        return res
    }

    fun shr(res: Vec1ul, a: Vec1ul, bX: Long): Vec1ul {
        res.x.v = a.x.v ushr bX.i
        return res
    }


    fun inv(res: Vec1ul, a: Vec1ul): Vec1ul {
        res.x.v = a.x.v.inv()
        return res
    }
}


// -- Specific binary arithmetic operators --

infix operator fun Ulong.plus(b: Vec1ul) = plus(Vec1ul(), b, this)
fun Ulong.plus(b: Vec1ul, res: Vec1ul) = plus(res, b, this)
infix fun Ulong.plusAssign(b: Vec1ul) = plus(b, b, this)

infix operator fun Ulong.minus(b: Vec1ul) = minus(Vec1ul(), this, b)
fun Ulong.minus(b: Vec1ul, res: Vec1ul) = minus(res, this, b)
infix fun Ulong.minusAssign(b: Vec1ul) = minus(b, this, b)

infix operator fun Ulong.times(b: Vec1ul) = times(Vec1ul(), b, this)
fun Ulong.times(b: Vec1ul, res: Vec1ul) = times(res, b, this)
infix fun Ulong.timesAssign(b: Vec1ul) = times(b, b, this)

infix operator fun Ulong.div(b: Vec1ul) = div(Vec1ul(), this, b)
fun Ulong.div(b: Vec1ul, res: Vec1ul) = div(res, this, b)
infix fun Ulong.divAssign(b: Vec1ul) = div(b, this, b)

infix operator fun Ulong.rem(b: Vec1ul) = rem(Vec1ul(), this, b)
fun Ulong.rem(b: Vec1ul, res: Vec1ul) = rem(res, this, b)
infix fun Ulong.remAssign(b: Vec1ul) = rem(b, this, b)


infix operator fun Long.plus(b: Vec1ul) = plus(Vec1ul(), b, this)
fun Long.plus(b: Vec1ul, res: Vec1ul) = plus(res, b, this)
infix fun Long.plusAssign(b: Vec1ul) = plus(b, b, this)

infix operator fun Long.minus(b: Vec1ul) = minus(Vec1ul(), this, b)
fun Long.minus(b: Vec1ul, res: Vec1ul) = minus(res, this, b)
infix fun Long.minusAssign(b: Vec1ul) = minus(b, this, b)

infix operator fun Long.times(b: Vec1ul) = times(Vec1ul(), b, this)
fun Long.times(b: Vec1ul, res: Vec1ul) = times(res, b, this)
infix fun Long.timesAssign(b: Vec1ul) = times(b, b, this)

infix operator fun Long.div(b: Vec1ul) = div(Vec1ul(), this, b)
fun Long.divAssign(b: Vec1ul, res: Vec1ul) = div(res, this, b)
infix fun Long.divAssign(b: Vec1ul) = div(b, this, b)

infix operator fun Long.rem(b: Vec1ul) = rem(Vec1ul(), this, b)
fun Long.rem(b: Vec1ul, res: Vec1ul) = rem(res, this, b)
infix fun Long.remAssign(b: Vec1ul) = rem(b, this, b)


// -- Generic binary arithmetic operators --

infix operator fun Number.plus(b: Vec1ul) = plus(Vec1ul(), b, this.L)
fun Number.plus(b: Vec1ul, res: Vec1ul) = plus(res, b, this.L)
infix fun Number.plusAssign(b: Vec1ul) = plus(b, b, this.L)

infix operator fun Number.minus(b: Vec1ul) = minus(Vec1ul(), this.L, b)
fun Number.minus(b: Vec1ul, res: Vec1ul) = minus(res, this.L, b)
infix fun Number.minusAssign(b: Vec1ul) = minus(b, this.L, b)

infix operator fun Number.times(b: Vec1ul) = times(Vec1ul(), b, this.L)
fun Number.times(b: Vec1ul, res: Vec1ul) = times(res, b, this.L)
infix fun Number.timesAssign(b: Vec1ul) = times(b, b, this.L)

infix operator fun Number.div(b: Vec1ul) = div(Vec1ul(), this.L, b)
fun Number.div(b: Vec1ul, res: Vec1ul) = div(res, this.L, b)
infix fun Number.divAssign(b: Vec1ul) = div(b, this.L, b)

infix operator fun Number.rem(b: Vec1ul) = rem(Vec1ul(), this.L, b)
fun Number.remAssign(b: Vec1ul, res: Vec1ul) = rem(res, this.L, b)
infix fun Number.remAssign(b: Vec1ul) = rem(b, this.L, b)