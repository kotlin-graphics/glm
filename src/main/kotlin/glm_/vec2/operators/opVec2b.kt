package glm_.vec2.operators

import glm_.*
import glm_.vec2.Vec2b
import glm_.vec2.Vec2b.Companion.div
import glm_.vec2.Vec2b.Companion.minus
import glm_.vec2.Vec2b.Companion.plus
import glm_.vec2.Vec2b.Companion.rem
import glm_.vec2.Vec2b.Companion.times
import kotlin.experimental.and
import kotlin.experimental.inv
import kotlin.experimental.or
import kotlin.experimental.xor

/**
 * Created by GBarbieri on 08.11.2016.
 */
interface opVec2b {

    fun plus(res: Vec2b, a: Vec2b, bX: Byte, bY: Byte): Vec2b {
        res.x = (a.x + bX).b
        res.y = (a.y + bY).b
        return res
    }

    fun plus(res: Vec2b, a: Vec2b, bX: Int, bY: Int): Vec2b {
        res.x = (a.x + bX).b
        res.y = (a.y + bY).b
        return res
    }

    fun minus(res: Vec2b, a: Vec2b, bX: Byte, bY: Byte): Vec2b {
        res.x = (a.x - bX).b
        res.y = (a.y - bY).b
        return res
    }

    fun minus(res: Vec2b, a: Vec2b, bX: Int, bY: Int): Vec2b {
        res.x = (a.x - bX).b
        res.y = (a.y - bY).b
        return res
    }

    fun minus(res: Vec2b, aX: Byte, aY: Byte, b: Vec2b): Vec2b {
        res.x = (aX - b.x).b
        res.y = (aY - b.y).b
        return res
    }

    fun minus(res: Vec2b, aX: Int, aY: Int, b: Vec2b): Vec2b {
        res.x = (aX - b.x).b
        res.y = (aY - b.y).b
        return res
    }

    fun times(res: Vec2b, a: Vec2b, bX: Byte, bY: Byte): Vec2b {
        res.x = (a.x * bX).b
        res.y = (a.y * bY).b
        return res
    }

    fun times(res: Vec2b, a: Vec2b, bX: Int, bY: Int): Vec2b {
        res.x = (a.x * bX).b
        res.y = (a.y * bY).b
        return res
    }

    fun div(res: Vec2b, a: Vec2b, bX: Byte, bY: Byte): Vec2b {
        res.x = (a.x / bX).b
        res.y = (a.y / bY).b
        return res
    }

    fun div(res: Vec2b, a: Vec2b, bX: Int, bY: Int): Vec2b {
        res.x = (a.x / bX).b
        res.y = (a.y / bY).b
        return res
    }

    fun div(res: Vec2b, aX: Byte, aY: Byte, b: Vec2b): Vec2b {
        res.x = (aX / b.x).b
        res.y = (aY / b.y).b
        return res
    }

    fun div(res: Vec2b, aX: Int, aY: Int, b: Vec2b): Vec2b {
        res.x = (aX / b.x).b
        res.y = (aY / b.y).b
        return res
    }

    fun rem(res: Vec2b, a: Vec2b, bX: Byte, bY: Byte): Vec2b {
        res.x = (a.x % bX).b
        res.y = (a.y % bY).b
        return res
    }

    fun rem(res: Vec2b, a: Vec2b, bX: Int, bY: Int): Vec2b {
        res.x = (a.x % bX).b
        res.y = (a.y % bY).b
        return res
    }

    fun rem(res: Vec2b, aX: Byte, aY: Byte, b: Vec2b): Vec2b {
        res.x = (aX % b.x).b
        res.y = (aY % b.y).b
        return res
    }

    fun rem(res: Vec2b, aX: Int, aY: Int, b: Vec2b): Vec2b {
        res.x = (aX % b.x).b
        res.y = (aY % b.y).b
        return res
    }

    fun and(res: Vec2b, a: Vec2b, bX: Byte, bY: Byte): Vec2b {
        res.x = a.x and bX
        res.y = a.y and bY
        return res
    }

    fun and(res: Vec2b, a: Vec2b, bX: Int, bY: Int): Vec2b {
        res.x = a.x and bX
        res.y = a.y and bY
        return res
    }

    fun or(res: Vec2b, a: Vec2b, bX: Byte, bY: Byte): Vec2b {
        res.x = a.x or bX
        res.y = a.y or bY
        return res
    }

    fun or(res: Vec2b, a: Vec2b, bX: Int, bY: Int): Vec2b {
        res.x = a.x or bX
        res.y = a.y or bY
        return res
    }

    fun xor(res: Vec2b, a: Vec2b, bX: Byte, bY: Byte): Vec2b {
        res.x = a.x xor bX
        res.y = a.y xor bY
        return res
    }

    fun xor(res: Vec2b, a: Vec2b, bX: Int, bY: Int): Vec2b {
        res.x = a.x xor bX
        res.y = a.y xor bY
        return res
    }

    fun shl(res: Vec2b, a: Vec2b, bX: Byte, bY: Byte): Vec2b {
        res.x = a.x shl bX
        res.y = a.y shl bY
        return res
    }

    fun shl(res: Vec2b, a: Vec2b, bX: Int, bY: Int): Vec2b {
        res.x = a.x shl bX
        res.y = a.y shl bY
        return res
    }

    fun shr(res: Vec2b, a: Vec2b, bX: Byte, bY: Byte): Vec2b {
        res.x = a.x shr bX
        res.y = a.y shr bY
        return res
    }

    fun shr(res: Vec2b, a: Vec2b, bX: Int, bY: Int): Vec2b {
        res.x = a.x shr bX
        res.y = a.y shr bY
        return res
    }

    fun inv(res: Vec2b, a: Vec2b): Vec2b {
        res.x = a.x.inv()
        res.y = a.y.inv()
        return res
    }
}


// -- Specific binary arithmetic operators --

infix operator fun Byte.plus(b: Vec2b) = plus(Vec2b(), b, this, this)
fun Byte.plus(b: Vec2b, res: Vec2b) = plus(res, b, this, this)
infix fun Byte.plusAssign(b: Vec2b) = plus(b, b, this, this)

infix operator fun Byte.minus(b: Vec2b) = minus(Vec2b(), this, this, b)
fun Byte.minus(b: Vec2b, res: Vec2b) = minus(res, b, this, this)
infix fun Byte.minusAssign(b: Vec2b) = minus(b, this, this, b)

infix operator fun Byte.times(b: Vec2b) = times(Vec2b(), b, this, this)
fun Byte.times(b: Vec2b, res: Vec2b) = times(res, b, this, this)
infix fun Byte.timesAssign(b: Vec2b) = times(b, b, this, this)

infix operator fun Byte.div(b: Vec2b) = div(Vec2b(), this, this, b)
fun Byte.div(b: Vec2b, res: Vec2b) = div(res, b, this, this)
infix fun Byte.divAssign(b: Vec2b) = div(b, this, this, b)

infix operator fun Byte.rem(b: Vec2b) = rem(Vec2b(), this, this, b)
fun Byte.rem(b: Vec2b, res: Vec2b) = rem(res, b, this, this)
infix fun Byte.remAssign(b: Vec2b) = rem(b, this, this, b)


infix operator fun Int.plus(b: Vec2b) = plus(Vec2b(), b, this, this)
fun Int.plus(b: Vec2b, res: Vec2b) = plus(res, b, this, this)
infix fun Int.plusAssign(b: Vec2b) = plus(b, b, this, this)

infix operator fun Int.minus(b: Vec2b) = minus(Vec2b(), this, this, b)
fun Int.minus(b: Vec2b, res: Vec2b) = minus(res, b, this, this)
infix fun Int.minusAssign(b: Vec2b) = minus(b, this, this, b)

infix operator fun Int.times(b: Vec2b) = times(Vec2b(), b, this, this)
fun Int.times(b: Vec2b, res: Vec2b) = times(res, b, this, this)
infix fun Int.timesAssign(b: Vec2b) = times(b, b, this, this)

infix operator fun Int.div(b: Vec2b) = div(Vec2b(), this, this, b)
fun Int.div(b: Vec2b, res: Vec2b) = div(res, b, this, this)
infix fun Int.divAssign(b: Vec2b) = div(b, this, this, b)

infix operator fun Int.rem(b: Vec2b) = rem(Vec2b(), this, this, b)
fun Int.rem(b: Vec2b, res: Vec2b) = rem(res, b, this, this)
infix fun Int.remAssign(b: Vec2b) = rem(b, this, this, b)


// -- Specific binary arithmetic operators --

infix operator fun Number.plus(b: Vec2b) = plus(Vec2b(), b, this.i, this.i)
fun Number.plus(b: Vec2b, res: Vec2b) = plus(res, b, this.i, this.i)
infix fun Number.plusAssign(b: Vec2b) = plus(b, b, this.i, this.i)

infix operator fun Number.minus(b: Vec2b) = minus(Vec2b(), this.i, this.i, b)
fun Number.minus(b: Vec2b, res: Vec2b) = minus(res, b, this.i, this.i)
infix fun Number.minusAssign(b: Vec2b) = minus(b, this.i, this.i, b)

infix operator fun Number.times(b: Vec2b) = times(Vec2b(), b, this.i, this.i)
fun Number.times(b: Vec2b, res: Vec2b) = times(res, b, this.i, this.i)
infix fun Number.timesAssign(b: Vec2b) = times(b, b, this.i, this.i)

infix operator fun Number.div(b: Vec2b) = div(Vec2b(), this.i, this.i, b)
fun Number.div(b: Vec2b, res: Vec2b) = div(res, b, this.i, this.i)
infix fun Number.divAssign(b: Vec2b) = div(b, this.i, this.i, b)

infix operator fun Number.rem(b: Vec2b) = rem(Vec2b(), this.i, this.i, b)
fun Number.rem(b: Vec2b, res: Vec2b) = rem(res, b, this.i, this.i)
infix fun Number.remAssign(b: Vec2b) = rem(b, this.i, this.i, b)