package glm.vec2.operators

import glm.*
import glm.vec2.Vec2s
import glm.vec2.Vec2s.Companion.plus
import glm.vec2.Vec2s.Companion.minus
import glm.vec2.Vec2s.Companion.times
import glm.vec2.Vec2s.Companion.div
import glm.vec2.Vec2s.Companion.rem
import kotlin.experimental.and
import kotlin.experimental.inv
import kotlin.experimental.or
import kotlin.experimental.xor

/**
 * Created by GBarbieri on 08.11.2016.
 */
interface vec2s_operators {

    fun plus(res: Vec2s, a: Vec2s, bX: Short, bY: Short): Vec2s {
        res.x = (a.x + bX).s
        res.y = (a.y + bY).s
        return res
    }

    fun plus(res: Vec2s, a: Vec2s, bX: Int, bY: Int): Vec2s {
        res.x = (a.x + bX).s
        res.y = (a.y + bY).s
        return res
    }

    fun minus(res: Vec2s, a: Vec2s, bX: Short, bY: Short): Vec2s {
        res.x = (a.x - bX).s
        res.y = (a.y - bY).s
        return res
    }

    fun minus(res: Vec2s, a: Vec2s, bX: Int, bY: Int): Vec2s {
        res.x = (a.x - bX).s
        res.y = (a.y - bY).s
        return res
    }

    fun minus(res: Vec2s, aX: Short, aY: Short, b: Vec2s): Vec2s {
        res.x = (aX - b.x).s
        res.y = (aY - b.y).s
        return res
    }

    fun minus(res: Vec2s, aX: Int, aY: Int, b: Vec2s): Vec2s {
        res.x = (aX - b.x).s
        res.y = (aY - b.y).s
        return res
    }

    fun times(res: Vec2s, a: Vec2s, bX: Short, bY: Short): Vec2s {
        res.x = (a.x * bX).s
        res.y = (a.y * bY).s
        return res
    }

    fun times(res: Vec2s, a: Vec2s, bX: Int, bY: Int): Vec2s {
        res.x = (a.x * bX).s
        res.y = (a.y * bY).s
        return res
    }

    fun div(res: Vec2s, a: Vec2s, bX: Short, bY: Short): Vec2s {
        res.x = (a.x / bX).s
        res.y = (a.y / bY).s
        return res
    }

    fun div(res: Vec2s, a: Vec2s, bX: Int, bY: Int): Vec2s {
        res.x = (a.x / bX).s
        res.y = (a.y / bY).s
        return res
    }

    fun div(res: Vec2s, aX: Short, aY: Short, b: Vec2s): Vec2s {
        res.x = (aX / b.x).s
        res.y = (aY / b.y).s
        return res
    }

    fun div(res: Vec2s, aX: Int, aY: Int, b: Vec2s): Vec2s {
        res.x = (aX / b.x).s
        res.y = (aY / b.y).s
        return res
    }

    fun rem(res: Vec2s, a: Vec2s, bX: Short, bY: Short): Vec2s {
        res.x = (a.x % bX).s
        res.y = (a.y % bY).s
        return res
    }

    fun rem(res: Vec2s, a: Vec2s, bX: Int, bY: Int): Vec2s {
        res.x = (a.x % bX).s
        res.y = (a.y % bY).s
        return res
    }

    fun rem(res: Vec2s, aX: Short, aY: Short, b: Vec2s): Vec2s {
        res.x = (aX % b.x).s
        res.y = (aY % b.y).s
        return res
    }

    fun rem(res: Vec2s, aX: Int, aY: Int, b: Vec2s): Vec2s {
        res.x = (aX % b.x).s
        res.y = (aY % b.y).s
        return res
    }

    fun and(res: Vec2s, a: Vec2s, bX: Short, bY: Short): Vec2s {
        res.x = a.x and bX
        res.y = a.y and bY
        return res
    }

    fun and(res: Vec2s, a: Vec2s, bX: Int, bY: Int): Vec2s {
        res.x = a.x and  bX
        res.y = a.y and bY
        return res
    }

    fun or(res: Vec2s, a: Vec2s, bX: Short, bY: Short): Vec2s {
        res.x = a.x or bX
        res.y = a.y or bY
        return res
    }

    fun or(res: Vec2s, a: Vec2s, bX: Int, bY: Int): Vec2s {
        res.x = a.x or bX
        res.y = a.y or bY
        return res
    }

    fun xor(res: Vec2s, a: Vec2s, bX: Short, bY: Short): Vec2s {
        res.x = a.x xor bX
        res.y = a.y xor bY
        return res
    }

    fun xor(res: Vec2s, a: Vec2s, bX: Int, bY: Int): Vec2s {
        res.x = a.x xor bX
        res.y = a.y xor bY
        return res
    }

    fun shl(res: Vec2s, a: Vec2s, bX: Short, bY: Short): Vec2s {
        res.x = a.x shl bX
        res.y = a.y shl bY
        return res
    }

    fun shl(res: Vec2s, a: Vec2s, bX: Int, bY: Int): Vec2s {
        res.x = a.x shl bX
        res.y = a.y shl bY
        return res
    }

    fun shr(res: Vec2s, a: Vec2s, bX: Short, bY: Short): Vec2s {
        res.x = a.x shr bX
        res.y = a.y shr bY
        return res
    }

    fun shr(res: Vec2s, a: Vec2s, bX: Int, bY: Int): Vec2s {
        res.x = a.x shr bX
        res.y = a.y shr bY
        return res
    }

    fun inv(res: Vec2s, a: Vec2s): Vec2s {
        res.x = a.x.inv()
        res.y = a.y.inv()
        return res
    }
}


// -- Specific binary arithmetic operators --

infix operator fun Short.plus(b: Vec2s) = plus(Vec2s(), b, this, this)
fun Short.plus(b: Vec2s, res: Vec2s) = plus(res, b, this, this)
infix fun Short.plus_(b: Vec2s) = plus(b, b, this, this)

infix operator fun Short.minus(b: Vec2s) = minus(Vec2s(), this, this, b)
fun Short.minus(b: Vec2s, res: Vec2s) = minus(res, b, this, this)
infix fun Short.minus_(b: Vec2s) = minus(b, this, this, b)

infix operator fun Short.times(b: Vec2s) = times(Vec2s(), b, this, this)
fun Short.times(b: Vec2s, res: Vec2s) = times(res, b, this, this)
infix fun Short.times_(b: Vec2s) = times(b, b, this, this)

infix operator fun Short.div(b: Vec2s) = div(Vec2s(), this, this, b)
fun Short.div(b: Vec2s, res: Vec2s) = div(res, b, this, this)
infix fun Short.div_(b: Vec2s) = div(b, this, this, b)

infix operator fun Short.rem(b: Vec2s) = rem(Vec2s(), this, this, b)
fun Short.rem(b: Vec2s, res: Vec2s) = rem(res, b, this, this)
infix fun Short.rem_(b: Vec2s) = rem(b, this, this, b)


infix operator fun Int.plus(b: Vec2s) = plus(Vec2s(), b, this, this)
fun Int.plus(b: Vec2s, res: Vec2s) = plus(res, b, this, this)
infix fun Int.plus_(b: Vec2s) = plus(b, b, this, this)

infix operator fun Int.minus(b: Vec2s) = minus(Vec2s(), this, this, b)
fun Int.minus(b: Vec2s, res: Vec2s) = minus(res, b, this, this)
infix fun Int.minus_(b: Vec2s) = minus(b, this, this, b)

infix operator fun Int.times(b: Vec2s) = times(Vec2s(), b, this, this)
fun Int.times(b: Vec2s, res: Vec2s) = times(res, b, this, this)
infix fun Int.times_(b: Vec2s) = times(b, b, this, this)

infix operator fun Int.div(b: Vec2s) = div(Vec2s(), this, this, b)
fun Int.div(b: Vec2s, res: Vec2s) = div(res, b, this, this)
infix fun Int.div_(b: Vec2s) = div(b, this, this, b)

infix operator fun Int.rem(b: Vec2s) = rem(Vec2s(), this, this, b)
fun Int.rem(b: Vec2s, res: Vec2s) = rem(res, b, this, this)
infix fun Int.rem_(b: Vec2s) = rem(b, this, this, b)


// -- Specific binary arithmetic operators --

infix operator fun Number.plus(b: Vec2s) = plus(Vec2s(), b, this.s, this.s)
fun Number.plus(b: Vec2s, res: Vec2s) = plus(res, b, this.s, this.s)
infix fun Number.plus_(b: Vec2s) = plus(b, b, this.s, this.s)

infix operator fun Number.minus(b: Vec2s) = minus(Vec2s(), this.s, this.s, b)
fun Number.minus(b: Vec2s, res: Vec2s) = minus(res, b, this.s, this.s)
infix fun Number.minus_(b: Vec2s) = minus(b, this.s, this.s, b)

infix operator fun Number.times(b: Vec2s) = times(Vec2s(), b, this.s, this.s)
fun Number.times(b: Vec2s, res: Vec2s) = times(res, b, this.s, this.s)
infix fun Number.times_(b: Vec2s) = times(b, b, this.s, this.s)

infix operator fun Number.div(b: Vec2s) = div(Vec2s(), this.s, this.s, b)
fun Number.div(b: Vec2s, res: Vec2s) = div(res, b, this.s, this.s)
infix fun Number.div_(b: Vec2s) = div(b, this.s, this.s, b)

infix operator fun Number.rem(b: Vec2s) = rem(Vec2s(), this.s, this.s, b)
fun Number.rem(b: Vec2s, res: Vec2s) = rem(res, b, this.s, this.s)
infix fun Number.rem_(b: Vec2s) = rem(b, this.s, this.s, b)