package glm_.vec1.operators

import glm_.*
import glm_.vec1.Vec1b
import glm_.vec1.Vec1b.Companion.div
import glm_.vec1.Vec1b.Companion.minus
import glm_.vec1.Vec1b.Companion.plus
import glm_.vec1.Vec1b.Companion.rem
import glm_.vec1.Vec1b.Companion.times
import kotlin.experimental.and
import kotlin.experimental.inv
import kotlin.experimental.or
import kotlin.experimental.xor

/**
 * Created by GBarbieri on 08.11.2016.
 */
interface opVec1b {

    fun plus(res: Vec1b, a: Vec1b, bX: Byte): Vec1b {
        res.x = (a.x + bX).b
        return res
    }

    fun plus(res: Vec1b, a: Vec1b, bX: Int): Vec1b {
        res.x = (a.x + bX).b
        return res
    }

    fun minus(res: Vec1b, a: Vec1b, bX: Byte): Vec1b {
        res.x = (a.x - bX).b
        return res
    }

    fun minus(res: Vec1b, a: Vec1b, bX: Int): Vec1b {
        res.x = (a.x - bX).b
        return res
    }

    fun minus(res: Vec1b, aX: Byte, b: Vec1b): Vec1b {
        res.x = (aX - b.x).b
        return res
    }

    fun minus(res: Vec1b, aX: Int, b: Vec1b): Vec1b {
        res.x = (aX - b.x).b
        return res
    }

    fun times(res: Vec1b, a: Vec1b, bX: Byte): Vec1b {
        res.x = (a.x * bX).b
        return res
    }

    fun times(res: Vec1b, a: Vec1b, bX: Int): Vec1b {
        res.x = (a.x * bX).b
        return res
    }

    fun div(res: Vec1b, a: Vec1b, bX: Byte): Vec1b {
        res.x = (a.x / bX).b
        return res
    }

    fun div(res: Vec1b, a: Vec1b, bX: Int): Vec1b {
        res.x = (a.x / bX).b
        return res
    }

    fun div(res: Vec1b, aX: Byte, b: Vec1b): Vec1b {
        res.x = (aX / b.x).b
        return res
    }

    fun div(res: Vec1b, aX: Int, b: Vec1b): Vec1b {
        res.x = (aX / b.x).b
        return res
    }

    fun rem(res: Vec1b, a: Vec1b, bX: Byte): Vec1b {
        res.x = (a.x % bX).b
        return res
    }

    fun rem(res: Vec1b, a: Vec1b, bX: Int): Vec1b {
        res.x = (a.x % bX).b
        return res
    }

    fun rem(res: Vec1b, aX: Byte, b: Vec1b): Vec1b {
        res.x = (aX % b.x).b
        return res
    }

    fun rem(res: Vec1b, aX: Int, b: Vec1b): Vec1b {
        res.x = (aX % b.x).b
        return res
    }

    fun and(res: Vec1b, a: Vec1b, bX: Byte): Vec1b {
        res.x = a.x and bX
        return res
    }

    fun and(res: Vec1b, a: Vec1b, bX: Int): Vec1b {
        res.x = a.x and bX
        return res
    }

    fun or(res: Vec1b, a: Vec1b, bX: Byte): Vec1b {
        res.x = a.x or bX
        return res
    }

    fun or(res: Vec1b, a: Vec1b, bX: Int): Vec1b {
        res.x = a.x or bX
        return res
    }

    fun xor(res: Vec1b, a: Vec1b, bX: Byte): Vec1b {
        res.x = a.x xor bX
        return res
    }

    fun xor(res: Vec1b, a: Vec1b, bX: Int): Vec1b {
        res.x = a.x xor bX
        return res
    }

    fun shl(res: Vec1b, a: Vec1b, bX: Byte): Vec1b {
        res.x = a.x shl bX
        return res
    }

    fun shl(res: Vec1b, a: Vec1b, bX: Int): Vec1b {
        res.x = a.x shl bX
        return res
    }

    fun shr(res: Vec1b, a: Vec1b, bX: Byte): Vec1b {
        res.x = a.x shr bX
        return res
    }

    fun shr(res: Vec1b, a: Vec1b, bX: Int): Vec1b {
        res.x = a.x shr bX
        return res
    }

    fun inv(res: Vec1b, a: Vec1b): Vec1b {
        res.x = a.x.inv()
        return res
    }
}


// -- Specific binary arithmetic operators --

infix operator fun Byte.plus(b: Vec1b) = plus(Vec1b(), b, this)
fun Byte.plus(b: Vec1b, res: Vec1b) = plus(res, b, this)
infix fun Byte.plusAssign(b: Vec1b) = plus(b, b, this)

infix operator fun Byte.minus(b: Vec1b) = minus(Vec1b(), this, b)
fun Byte.minus(b: Vec1b, res: Vec1b) = minus(res, b, this)
infix fun Byte.minusAssign(b: Vec1b) = minus(b, this, b)

infix operator fun Byte.times(b: Vec1b) = times(Vec1b(), b, this)
fun Byte.times(b: Vec1b, res: Vec1b) = times(res, b, this)
infix fun Byte.timesAssign(b: Vec1b) = times(b, b, this)

infix operator fun Byte.div(b: Vec1b) = div(Vec1b(), this, b)
fun Byte.div(b: Vec1b, res: Vec1b) = div(res, b, this)
infix fun Byte.divAssign(b: Vec1b) = div(b, this, b)

infix operator fun Byte.rem(b: Vec1b) = rem(Vec1b(), this, b)
fun Byte.rem(b: Vec1b, res: Vec1b) = rem(res, b, this)
infix fun Byte.remAssign(b: Vec1b) = rem(b, this, b)


infix operator fun Int.plus(b: Vec1b) = plus(Vec1b(), b, this)
fun Int.plus(b: Vec1b, res: Vec1b) = plus(res, b, this)
infix fun Int.plusAssign(b: Vec1b) = plus(b, b, this)

infix operator fun Int.minus(b: Vec1b) = minus(Vec1b(), this, b)
fun Int.minus(b: Vec1b, res: Vec1b) = minus(res, b, this)
infix fun Int.minusAssign(b: Vec1b) = minus(b, this, b)

infix operator fun Int.times(b: Vec1b) = times(Vec1b(), b, this)
fun Int.times(b: Vec1b, res: Vec1b) = times(res, b, this)
infix fun Int.timesAssign(b: Vec1b) = times(b, b, this)

infix operator fun Int.div(b: Vec1b) = div(Vec1b(), this, b)
fun Int.div(b: Vec1b, res: Vec1b) = div(res, b, this)
infix fun Int.divAssign(b: Vec1b) = div(b, this, b)

infix operator fun Int.rem(b: Vec1b) = rem(Vec1b(), this, b)
fun Int.rem(b: Vec1b, res: Vec1b) = rem(res, b, this)
infix fun Int.remAssign(b: Vec1b) = rem(b, this, b)


// -- Specific binary arithmetic operators --

infix operator fun Number.plus(b: Vec1b) = plus(Vec1b(), b, this.i)
fun Number.plus(b: Vec1b, res: Vec1b) = plus(res, b, this.i)
infix fun Number.plusAssign(b: Vec1b) = plus(b, b, this.i)

infix operator fun Number.minus(b: Vec1b) = minus(Vec1b(), this.i, b)
fun Number.minus(b: Vec1b, res: Vec1b) = minus(res, b, this.i)
infix fun Number.minusAssign(b: Vec1b) = minus(b, this.i, b)

infix operator fun Number.times(b: Vec1b) = times(Vec1b(), b, this.i)
fun Number.times(b: Vec1b, res: Vec1b) = times(res, b, this.i)
infix fun Number.timesAssign(b: Vec1b) = times(b, b, this.i)

infix operator fun Number.div(b: Vec1b) = div(Vec1b(), this.i, b)
fun Number.div(b: Vec1b, res: Vec1b) = div(res, b, this.i)
infix fun Number.divAssign(b: Vec1b) = div(b, this.i, b)

infix operator fun Number.rem(b: Vec1b) = rem(Vec1b(), this.i, b)
fun Number.rem(b: Vec1b, res: Vec1b) = rem(res, b, this.i)
infix fun Number.remAssign(b: Vec1b) = rem(b, this.i, b)