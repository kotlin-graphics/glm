package glm.vec2.operators

import glm.L
import glm.i
import glm.vec2.Vec2l
import glm.vec2.Vec2l.Companion.plus
import glm.vec2.Vec2l.Companion.div
import glm.vec2.Vec2l.Companion.times
import glm.vec2.Vec2l.Companion.rem
import glm.vec2.Vec2l.Companion.minus
import glm.xor
import glm.or
import glm.and


/**
 * Created by GBarbieri on 08.11.2016.
 */
interface vec2l_operators {

    fun plus(res: Vec2l, a: Vec2l, bX: Int, bY: Int): Vec2l {
        res.x = a.x + bX
        res.y = a.y + bY
        return res
    }

    fun plus(res: Vec2l, a: Vec2l, bX: Long, bY: Long): Vec2l {
        res.x = a.x + bX
        res.y = a.y + bY
        return res
    }

    fun minus(res: Vec2l, a: Vec2l, bX: Int, bY: Int): Vec2l {
        res.x = a.x - bX
        res.y = a.y - bY
        return res
    }

    fun minus(res: Vec2l, a: Vec2l, bX: Long, bY: Long): Vec2l {
        res.x = a.x - bX
        res.y = a.y - bY
        return res
    }

    fun minus(res: Vec2l, aX: Int, aY: Int, b: Vec2l): Vec2l {
        res.x = aX - b.x
        res.y = aY - b.y
        return res
    }

    fun minus(res: Vec2l, aX: Long, aY: Long, b: Vec2l): Vec2l {
        res.x = aX - b.x
        res.y = aY - b.y
        return res
    }

    fun times(res: Vec2l, a: Vec2l, bX: Int, bY: Int): Vec2l {
        res.x = a.x * bX
        res.y = a.y * bY
        return res
    }

    fun times(res: Vec2l, a: Vec2l, bX: Long, bY: Long): Vec2l {
        res.x = a.x * bX
        res.y = a.y * bY
        return res
    }

    fun div(res: Vec2l, a: Vec2l, bX: Int, bY: Int): Vec2l {
        res.x = a.x / bX
        res.y = a.y / bY
        return res
    }

    fun div(res: Vec2l, a: Vec2l, bX: Long, bY: Long): Vec2l {
        res.x = a.x / bX
        res.y = a.y / bY
        return res
    }

    fun div(res: Vec2l, aX: Int, aY: Int, b: Vec2l): Vec2l {
        res.x = aX / b.x
        res.y = aY / b.y
        return res
    }

    fun div(res: Vec2l, aX: Long, aY: Long, b: Vec2l): Vec2l {
        res.x = aX / b.x
        res.y = aY / b.y
        return res
    }

    fun rem(res: Vec2l, a: Vec2l, bX: Int, bY: Int): Vec2l {
        res.x = a.x % bX
        res.y = a.y % bY
        return res
    }

    fun rem(res: Vec2l, a: Vec2l, bX: Long, bY: Long): Vec2l {
        res.x = a.x % bX
        res.y = a.y % bY
        return res
    }

    fun rem(res: Vec2l, aX: Int, aY: Int, b: Vec2l): Vec2l {
        res.x = aX % b.x
        res.y = aY % b.y
        return res
    }

    fun rem(res: Vec2l, aX: Long, aY: Long, b: Vec2l): Vec2l {
        res.x = aX % b.x
        res.y = aY % b.y
        return res
    }

    fun and(res: Vec2l, a: Vec2l, bX: Int, bY: Int): Vec2l {
        res.x = a.x and bX
        res.y = a.y and bY
        return res
    }

    fun and(res: Vec2l, a: Vec2l, bX: Long, bY: Long): Vec2l {
        res.x = a.x and bX
        res.y = a.y and bY
        return res
    }

    fun or(res: Vec2l, a: Vec2l, bX: Int, bY: Int): Vec2l {
        res.x = a.x or bX
        res.y = a.y or bY
        return res
    }

    fun or(res: Vec2l, a: Vec2l, bX: Long, bY: Long): Vec2l {
        res.x = a.x or bX
        res.y = a.y or bY
        return res
    }

    fun xor(res: Vec2l, a: Vec2l, bX: Int, bY: Int): Vec2l {
        res.x = a.x xor bX
        res.y = a.y xor bY
        return res
    }

    fun xor(res: Vec2l, a: Vec2l, bX: Long, bY: Long): Vec2l {
        res.x = a.x xor bX
        res.y = a.y xor bY
        return res
    }

    fun shl(res: Vec2l, a: Vec2l, bX: Long, bY: Long): Vec2l {
        res.x = a.x shl bX.i
        res.y = a.y shl bY.i
        return res
    }

    fun shl(res: Vec2l, a: Vec2l, bX: Int, bY: Int): Vec2l {
        res.x = a.x shl bX
        res.y = a.y shl bY
        return res
    }

    fun shr(res: Vec2l, a: Vec2l, bX: Long, bY: Long): Vec2l {
        res.x = a.x shr bX.i
        res.y = a.y shr bY.i
        return res
    }

    fun shr(res: Vec2l, a: Vec2l, bX: Int, bY: Int): Vec2l {
        res.x = a.x shr bX
        res.y = a.y shr bY
        return res
    }

    fun inv(res: Vec2l, a: Vec2l): Vec2l {
        res.x = a.x.inv()
        res.y = a.y.inv()
        return res
    }
}


// -- Specific binary arithmetic operators --

infix operator fun Long.plus(b: Vec2l) = plus(Vec2l(), b, this, this)
fun Long.plus(b: Vec2l, res: Vec2l) = plus(res, b, this, this)
infix fun Long.plus_(b: Vec2l) = plus(b, b, this, this)

infix operator fun Long.minus(b: Vec2l) = minus(Vec2l(), this, this, b)
fun Long.minus(b: Vec2l, res: Vec2l) = minus(res, b, this, this)
infix fun Long.minus_(b: Vec2l) = minus(b, this, this, b)

infix operator fun Long.times(b: Vec2l) = times(Vec2l(), b, this, this)
fun Long.times(b: Vec2l, res: Vec2l) = times(res, b, this, this)
infix fun Long.times_(b: Vec2l) = times(b, b, this, this)

infix operator fun Long.div(b: Vec2l) = div(Vec2l(), this, this, b)
fun Long.div(b: Vec2l, res: Vec2l) = div(res, b, this, this)
infix fun Long.div_(b: Vec2l) = div(b, this, this, b)

infix operator fun Long.rem(b: Vec2l) = rem(Vec2l(), this, this, b)
fun Long.rem(b: Vec2l, res: Vec2l) = rem(res, b, this, this)
infix fun Long.rem_(b: Vec2l) = rem(b, this, this, b)


infix operator fun Int.plus(b: Vec2l) = plus(Vec2l(), b, this, this)
fun Int.plus(b: Vec2l, res: Vec2l) = plus(res, b, this, this)
infix fun Int.plus_(b: Vec2l) = plus(b, b, this, this)

infix operator fun Int.minus(b: Vec2l) = minus(Vec2l(), this, this, b)
fun Int.minus(b: Vec2l, res: Vec2l) = minus(res, b, this, this)
infix fun Int.minus_(b: Vec2l) = minus(b, this, this, b)

infix operator fun Int.times(b: Vec2l) = times(Vec2l(), b, this, this)
fun Int.times(b: Vec2l, res: Vec2l) = times(res, b, this, this)
infix fun Int.times_(b: Vec2l) = times(b, b, this, this)

infix operator fun Int.div(b: Vec2l) = div(Vec2l(), this, this, b)
fun Int.div(b: Vec2l, res: Vec2l) = div(res, b, this, this)
infix fun Int.div_(b: Vec2l) = div(b, this, this, b)

infix operator fun Int.rem(b: Vec2l) = rem(Vec2l(), this, this, b)
fun Int.rem(b: Vec2l, res: Vec2l) = rem(res, b, this, this)
infix fun Int.rem_(b: Vec2l) = rem(b, this, this, b)


// -- Generic binary arithmetic operators --

infix operator fun Number.plus(b: Vec2l) = plus(Vec2l(), b, this.L, this.L)
fun Number.plus(b: Vec2l, res: Vec2l) = plus(res, b, this.L, this.L)
infix fun Number.plus_(b: Vec2l) = plus(b, b, this.L, this.L)

infix operator fun Number.minus(b: Vec2l) = minus(Vec2l(), this.L, this.L, b)
fun Number.minus(b: Vec2l, res: Vec2l) = minus(res, b, this.L, this.L)
infix fun Number.minus_(b: Vec2l) = minus(b, this.L, this.L, b)

infix operator fun Number.times(b: Vec2l) = times(Vec2l(), b, this.L, this.L)
fun Number.times(b: Vec2l, res: Vec2l) = times(res, b, this.L, this.L)
infix fun Number.times_(b: Vec2l) = times(b, b, this.L, this.L)

infix operator fun Number.div(b: Vec2l) = div(Vec2l(), this.L, this.L, b)
fun Number.div(b: Vec2l, res: Vec2l) = div(res, b, this.L, this.L)
infix fun Number.div_(b: Vec2l) = div(b, this.L, this.L, b)

infix operator fun Number.rem(b: Vec2l) = rem(Vec2l(), this.L, this.L, b)
fun Number.rem(b: Vec2l, res: Vec2l) = rem(res, b, this.L, this.L)
infix fun Number.rem_(b: Vec2l) = rem(b, this.L, this.L, b)