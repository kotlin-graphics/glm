package glm.vec._2.operators

import glm.i
import glm.vec._2.Vec2i
import glm.vec._2.Vec2i.Companion.plus
import glm.vec._2.Vec2i.Companion.div
import glm.vec._2.Vec2i.Companion.times
import glm.vec._2.Vec2i.Companion.rem
import glm.vec._2.Vec2i.Companion.minus

/**
 * Created by GBarbieri on 08.11.2016.
 */
interface vec2i_operators {

    fun plus(res: Vec2i, a: Vec2i, bX: Int, bY: Int): Vec2i {
        res.x = a.x + bX
        res.y = a.y + bY
        return res
    }

    fun minus(res: Vec2i, a: Vec2i, bX: Int, bY: Int): Vec2i {
        res.x = a.x - bX
        res.y = a.y - bY
        return res
    }

    fun minus(res: Vec2i, aX: Int, aY: Int, b: Vec2i): Vec2i {
        res.x = aX - b.x
        res.y = aY - b.y
        return res
    }

    fun times(res: Vec2i, a: Vec2i, bX: Int, bY: Int): Vec2i {
        res.x = a.x * bX
        res.y = a.y * bY
        return res
    }

    fun div(res: Vec2i, a: Vec2i, bX: Int, bY: Int): Vec2i {
        res.x = a.x / bX
        res.y = a.y / bY
        return res
    }

    fun div(res: Vec2i, aX: Int, aY: Int, b: Vec2i): Vec2i {
        res.x = aX / b.x
        res.y = aY / b.y
        return res
    }

    fun rem(res: Vec2i, a: Vec2i, bX: Int, bY: Int): Vec2i {
        res.x = a.x % bX
        res.y = a.y % bY
        return res
    }

    fun rem(res: Vec2i, aX: Int, aY: Int, b: Vec2i): Vec2i {
        res.x = aX % b.x
        res.y = aY % b.y
        return res
    }

    fun and(res: Vec2i, a: Vec2i, bX: Int, bY: Int): Vec2i {
        res.x = a.x and bX
        res.y = a.y and bY
        return res
    }

    fun or(res: Vec2i, a: Vec2i, bX: Int, bY: Int): Vec2i {
        res.x = a.x or bX
        res.y = a.y or bY
        return res
    }

    fun xor(res: Vec2i, a: Vec2i, bX: Int, bY: Int): Vec2i {
        res.x = a.x xor bX
        res.y = a.y xor bY
        return res
    }

    fun shl(res: Vec2i, a: Vec2i, bX: Int, bY: Int): Vec2i {
        res.x = a.x shl bX
        res.y = a.y shl bY
        return res
    }

    fun shr(res: Vec2i, a: Vec2i, bX: Int, bY: Int): Vec2i {
        res.x = a.x shr bX
        res.y = a.y shr bY
        return res
    }

    fun inv(res: Vec2i, a: Vec2i): Vec2i {
        res.x = a.x.inv()
        res.y = a.y.inv()
        return res
    }
}


// -- Specific binary arithmetic operators --

infix operator fun Int.plus(b: Vec2i) = plus(Vec2i(), b, this, this)
fun Int.plus(b: Vec2i, res: Vec2i) = plus(res, b, this, this)
infix fun Int.plus_(b: Vec2i) = plus(b, b, this, this)

infix operator fun Int.minus(b: Vec2i) = minus(Vec2i(), this, this, b)
fun Int.minus(b: Vec2i, res: Vec2i) = minus(res, b, this, this)
infix fun Int.minus_(b: Vec2i) = minus(b, this, this, b)

infix operator fun Int.times(b: Vec2i) = times(Vec2i(), b, this, this)
fun Int.times(b: Vec2i, res: Vec2i) = times(res, b, this, this)
infix fun Int.times_(b: Vec2i) = times(b, b, this, this)

infix operator fun Int.div(b: Vec2i) = div(Vec2i(), this, this, b)
fun Int.div(b: Vec2i, res: Vec2i) = div(res, b, this, this)
infix fun Int.div_(b: Vec2i) = div(b, this, this, b)

infix operator fun Int.rem(b: Vec2i) = rem(Vec2i(), this, this, b)
fun Int.rem(b: Vec2i, res: Vec2i) = rem(res, b, this, this)
infix fun Int.rem_(b: Vec2i) = rem(b, this, this, b)


// -- Generic binary arithmetic operators --

infix operator fun Number.plus(b: Vec2i) = plus(Vec2i(), b, this.i, this.i)
fun Number.plus(b: Vec2i, res: Vec2i) = plus(res, b, this.i, this.i)
infix fun Number.plus_(b: Vec2i) = plus(b, b, this.i, this.i)

infix operator fun Number.minus(b: Vec2i) = minus(Vec2i(), this.i, this.i, b)
fun Number.minus(b: Vec2i, res: Vec2i) = minus(res, b, this.i, this.i)
infix fun Number.minus_(b: Vec2i) = minus(b, this.i, this.i, b)

infix operator fun Number.times(b: Vec2i) = times(Vec2i(), b, this.i, this.i)
fun Number.times(b: Vec2i, res: Vec2i) = times(res, b, this.i, this.i)
infix fun Number.times_(b: Vec2i) = times(b, b, this.i, this.i)

infix operator fun Number.div(b: Vec2i) = div(Vec2i(), this.i, this.i, b)
fun Number.div(b: Vec2i, res: Vec2i) = div(res, b, this.i, this.i)
infix fun Number.div_(b: Vec2i) = div(b, this.i, this.i, b)

infix operator fun Number.rem(b: Vec2i) = rem(Vec2i(), this.i, this.i, b)
fun Number.rem(b: Vec2i, res: Vec2i) = rem(res, b, this.i, this.i)
infix fun Number.rem_(b: Vec2i) = rem(b, this.i, this.i, b)