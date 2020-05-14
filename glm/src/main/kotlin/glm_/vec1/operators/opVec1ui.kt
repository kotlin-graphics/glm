package glm_.vec1.operators

import glm_.i
import glm_.vec1.Vec1ui
import glm_.vec1.Vec1ui.Companion.div
import glm_.vec1.Vec1ui.Companion.minus
import glm_.vec1.Vec1ui.Companion.plus
import glm_.vec1.Vec1ui.Companion.rem
import glm_.vec1.Vec1ui.Companion.times
import unsigned.Uint
import unsigned.udiv
import unsigned.urem

/**
 * Created by GBarbieri on 08.11.2016.
 */

interface opVec1ui {

    fun plus(res: Vec1ui, a: Vec1ui, bX: Uint): Vec1ui {
        res.x.v = a.x.v + bX.v
        return res
    }

    fun plus(res: Vec1ui, a: Vec1ui, bX: Int): Vec1ui {
        res.x.v = a.x.v + bX
        return res
    }

    fun minus(res: Vec1ui, a: Vec1ui, bX: Uint): Vec1ui {
        res.x.v = a.x.v - bX.v
        return res
    }

    fun minus(res: Vec1ui, a: Vec1ui, bX: Int): Vec1ui {
        res.x.v = a.x.v - bX
        return res
    }

    fun minus(res: Vec1ui, aX: Uint, b: Vec1ui): Vec1ui {
        res.x.v = aX.v - b.x.v
        return res
    }

    fun minus(res: Vec1ui, aX: Int, b: Vec1ui): Vec1ui {
        res.x.v = aX - b.x.v
        return res
    }

    fun times(res: Vec1ui, a: Vec1ui, bX: Uint): Vec1ui {
        res.x.v = a.x.v * bX.v
        return res
    }

    fun times(res: Vec1ui, a: Vec1ui, bX: Int): Vec1ui {
        res.x.v = a.x.v * bX
        return res
    }

    fun div(res: Vec1ui, a: Vec1ui, bX: Uint): Vec1ui {
        res.x.v = a.x.v udiv bX.v
        return res
    }

    fun div(res: Vec1ui, a: Vec1ui, bX: Int): Vec1ui {
        res.x.v = a.x.v udiv bX
        return res
    }

    fun div(res: Vec1ui, aX: Uint, b: Vec1ui): Vec1ui {
        res.x.v = aX.v udiv b.x.v
        return res
    }

    fun div(res: Vec1ui, aX: Int, b: Vec1ui): Vec1ui {
        res.x.v = aX udiv b.x.v
        return res
    }

    fun rem(res: Vec1ui, a: Vec1ui, bX: Uint): Vec1ui {
        res.x.v = a.x.v urem bX.v
        return res
    }

    fun rem(res: Vec1ui, a: Vec1ui, bX: Int): Vec1ui {
        res.x.v = a.x.v urem bX
        return res
    }

    fun rem(res: Vec1ui, aX: Uint, b: Vec1ui): Vec1ui {
        res.x.v = aX.v urem b.x.v
        return res
    }

    fun rem(res: Vec1ui, aX: Int, b: Vec1ui): Vec1ui {
        res.x.v = aX urem b.x.v
        return res
    }

    fun and(res: Vec1ui, a: Vec1ui, bX: Uint): Vec1ui {
        res.x.v = a.x.v and bX.v
        return res
    }

    fun and(res: Vec1ui, a: Vec1ui, bX: Int): Vec1ui {
        res.x.v = a.x.v and bX
        return res
    }

    fun or(res: Vec1ui, a: Vec1ui, bX: Uint): Vec1ui {
        res.x.v = a.x.v or bX.v
        return res
    }

    fun or(res: Vec1ui, a: Vec1ui, bX: Int): Vec1ui {
        res.x.v = a.x.v or bX
        return res
    }

    fun xor(res: Vec1ui, a: Vec1ui, bX: Uint): Vec1ui {
        res.x.v = a.x.v xor bX.v
        return res
    }

    fun xor(res: Vec1ui, a: Vec1ui, bX: Int): Vec1ui {
        res.x.v = a.x.v xor bX
        return res
    }

    fun shl(res: Vec1ui, a: Vec1ui, bX: Uint): Vec1ui {
        res.x.v = a.x.v shl bX.v
        return res
    }

    fun shl(res: Vec1ui, a: Vec1ui, bX: Int): Vec1ui {
        res.x.v = a.x.v shl bX
        return res
    }

    fun shr(res: Vec1ui, a: Vec1ui, bX: Uint): Vec1ui {
        res.x.v = a.x.v ushr bX.v
        return res
    }

    fun shr(res: Vec1ui, a: Vec1ui, bX: Int): Vec1ui {
        res.x.v = a.x.v ushr bX
        return res
    }

    fun inv(res: Vec1ui, a: Vec1ui): Vec1ui {
        res.x.v = a.x.v.inv()
        return res
    }
}


// -- Specific binary arithmetic operators --

infix operator fun Uint.plus(b: Vec1ui) = plus(Vec1ui(), b, this)
fun Uint.plus(b: Vec1ui, res: Vec1ui) = plus(res, b, this)
infix fun Uint.plusAssign(b: Vec1ui) = plus(b, b, this)

infix operator fun Uint.minus(b: Vec1ui) = minus(Vec1ui(), this, b)
fun Uint.minus(b: Vec1ui, res: Vec1ui) = minus(res, b, this)
infix fun Uint.minusAssign(b: Vec1ui) = minus(b, this, b)

infix operator fun Uint.times(b: Vec1ui) = times(Vec1ui(), b, this)
fun Uint.times(b: Vec1ui, res: Vec1ui) = times(res, b, this)
infix fun Uint.timesAssign(b: Vec1ui) = times(b, b, this)

infix operator fun Uint.div(b: Vec1ui) = div(Vec1ui(), this, b)
fun Uint.div(b: Vec1ui, res: Vec1ui) = div(res, b, this)
infix fun Uint.divAssign(b: Vec1ui) = div(b, this, b)

infix operator fun Uint.rem(b: Vec1ui) = rem(Vec1ui(), this, b)
fun Uint.rem(b: Vec1ui, res: Vec1ui) = rem(res, b, this)
infix fun Uint.remAssign(b: Vec1ui) = rem(b, this, b)


infix operator fun Int.plus(b: Vec1ui) = plus(Vec1ui(), b, this)
fun Int.plus(b: Vec1ui, res: Vec1ui) = plus(res, b, this)
infix fun Int.plusAssign(b: Vec1ui) = plus(b, b, this)

infix operator fun Int.minus(b: Vec1ui) = minus(Vec1ui(), this, b)
fun Int.minus(b: Vec1ui, res: Vec1ui) = minus(res, b, this)
infix fun Int.minusAssign(b: Vec1ui) = minus(b, this, b)

infix operator fun Int.times(b: Vec1ui) = times(Vec1ui(), b, this)
fun Int.times(b: Vec1ui, res: Vec1ui) = times(res, b, this)
infix fun Int.timesAssign(b: Vec1ui) = times(b, b, this)

infix operator fun Int.div(b: Vec1ui) = div(Vec1ui(), this, b)
fun Int.div(b: Vec1ui, res: Vec1ui) = div(res, b, this)
infix fun Int.divAssign(b: Vec1ui) = div(b, this, b)

infix operator fun Int.rem(b: Vec1ui) = rem(Vec1ui(), this, b)
fun Int.rem(b: Vec1ui, res: Vec1ui) = rem(res, b, this)
infix fun Int.remAssign(b: Vec1ui) = rem(b, this, b)


// -- Generic binary arithmetic operators --

infix operator fun Number.plus(b: Vec1ui) = plus(Vec1ui(), b, this.i)
fun Number.plus(b: Vec1ui, res: Vec1ui) = plus(res, b, this.i)
infix fun Number.plusAssign(b: Vec1ui) = plus(b, b, this.i)

infix operator fun Number.minus(b: Vec1ui) = minus(Vec1ui(), this.i, b)
fun Number.minus(b: Vec1ui, res: Vec1ui) = minus(res, b, this.i)
infix fun Number.minusAssign(b: Vec1ui) = minus(b, this.i, b)

infix operator fun Number.times(b: Vec1ui) = times(Vec1ui(), b, this.i)
fun Number.times(b: Vec1ui, res: Vec1ui) = times(res, b, this.i)
infix fun Number.timesAssign(b: Vec1ui) = times(b, b, this.i)

infix operator fun Number.div(b: Vec1ui) = div(Vec1ui(), this.i, b)
fun Number.div(b: Vec1ui, res: Vec1ui) = div(res, b, this.i)
infix fun Number.divAssign(b: Vec1ui) = div(b, this.i, b)

infix operator fun Number.rem(b: Vec1ui) = rem(Vec1ui(), this.i, b)
fun Number.rem(b: Vec1ui, res: Vec1ui) = rem(res, b, this.i)
infix fun Number.remAssign(b: Vec1ui) = rem(b, this.i, b)