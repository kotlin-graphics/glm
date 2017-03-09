package glm.vec._2.operators

import glm.i
import unsigned.Uint
import unsigned.udiv
import unsigned.urem
import glm.vec._2.Vec2ui
import glm.vec._2.Vec2ui.Companion.plus
import glm.vec._2.Vec2ui.Companion.div
import glm.vec._2.Vec2ui.Companion.times
import glm.vec._2.Vec2ui.Companion.rem
import glm.vec._2.Vec2ui.Companion.minus

/**
 * Created by GBarbieri on 08.11.2016.
 */

interface vec2ui_operators {

    fun plus(res: Vec2ui, a: Vec2ui, bX: Uint, bY: Uint): Vec2ui {
        res.x.v = a.x.v + bX.v
        res.y.v = a.y.v + bY.v
        return res
    }

    fun plus(res: Vec2ui, a: Vec2ui, bX: Int, bY: Int): Vec2ui {
        res.x.v = a.x.v + bX
        res.y.v = a.y.v + bY
        return res
    }

    fun minus(res: Vec2ui, a: Vec2ui, bX: Uint, bY: Uint): Vec2ui {
        res.x.v = a.x.v - bX.v
        res.y.v = a.y.v - bY.v
        return res
    }

    fun minus(res: Vec2ui, a: Vec2ui, bX: Int, bY: Int): Vec2ui {
        res.x.v = a.x.v - bX
        res.y.v = a.y.v - bY
        return res
    }

    fun minus(res: Vec2ui, aX: Uint, aY: Uint, b: Vec2ui): Vec2ui {
        res.x.v = aX.v - b.x.v
        res.y.v = aY.v - b.y.v
        return res
    }

    fun minus(res: Vec2ui, aX: Int, aY: Int, b: Vec2ui): Vec2ui {
        res.x.v = aX - b.x.v
        res.y.v = aY - b.y.v
        return res
    }

    fun times(res: Vec2ui, a: Vec2ui, bX: Uint, bY: Uint): Vec2ui {
        res.x.v = a.x.v * bX.v
        res.y.v = a.y.v * bY.v
        return res
    }

    fun times(res: Vec2ui, a: Vec2ui, bX: Int, bY: Int): Vec2ui {
        res.x.v = a.x.v * bX
        res.y.v = a.y.v * bY
        return res
    }

    fun div(res: Vec2ui, a: Vec2ui, bX: Uint, bY: Uint): Vec2ui {
        res.x.v = a.x.v udiv bX.v
        res.y.v = a.y.v udiv bY.v
        return res
    }

    fun div(res: Vec2ui, a: Vec2ui, bX: Int, bY: Int): Vec2ui {
        res.x.v = a.x.v udiv bX
        res.y.v = a.y.v udiv bY
        return res
    }

    fun div(res: Vec2ui, aX: Uint, aY: Uint, b: Vec2ui): Vec2ui {
        res.x.v = aX.v udiv b.x.v
        res.y.v = aY.v udiv b.y.v
        return res
    }

    fun div(res: Vec2ui, aX: Int, aY: Int, b: Vec2ui): Vec2ui {
        res.x.v = aX udiv b.x.v
        res.y.v = aY udiv b.y.v
        return res
    }

    fun rem(res: Vec2ui, a: Vec2ui, bX: Uint, bY: Uint): Vec2ui {
        res.x.v = a.x.v urem bX.v
        res.y.v = a.y.v urem bY.v
        return res
    }

    fun rem(res: Vec2ui, a: Vec2ui, bX: Int, bY: Int): Vec2ui {
        res.x.v = a.x.v urem bX
        res.y.v = a.y.v urem bY
        return res
    }

    fun rem(res: Vec2ui, aX: Uint, aY: Uint, b: Vec2ui): Vec2ui {
        res.x.v = aX.v urem b.x.v
        res.y.v = aY.v urem b.y.v
        return res
    }

    fun rem(res: Vec2ui, aX: Int, aY: Int, b: Vec2ui): Vec2ui {
        res.x.v = aX urem b.x.v
        res.y.v = aY urem b.y.v
        return res
    }

    fun and(res: Vec2ui, a: Vec2ui, bX: Uint, bY: Uint): Vec2ui {
        res.x.v = a.x.v and bX.v
        res.y.v = a.y.v and bY.v
        return res
    }

    fun and(res: Vec2ui, a: Vec2ui, bX: Int, bY: Int): Vec2ui {
        res.x.v = a.x.v and bX
        res.y.v = a.y.v and bY
        return res
    }

    fun or(res: Vec2ui, a: Vec2ui, bX: Uint, bY: Uint): Vec2ui {
        res.x.v = a.x.v or bX.v
        res.y.v = a.y.v or bY.v
        return res
    }

    fun or(res: Vec2ui, a: Vec2ui, bX: Int, bY: Int): Vec2ui {
        res.x.v = a.x.v or bX
        res.y.v = a.y.v or bY
        return res
    }

    fun xor(res: Vec2ui, a: Vec2ui, bX: Uint, bY: Uint): Vec2ui {
        res.x.v = a.x.v xor bX.v
        res.y.v = a.y.v xor bY.v
        return res
    }

    fun xor(res: Vec2ui, a: Vec2ui, bX: Int, bY: Int): Vec2ui {
        res.x.v = a.x.v xor bX
        res.y.v = a.y.v xor bY
        return res
    }

    fun shl(res: Vec2ui, a: Vec2ui, bX: Uint, bY: Uint): Vec2ui {
        res.x.v = a.x.v shl bX.v
        res.y.v = a.y.v shl bY.v
        return res
    }

    fun shl(res: Vec2ui, a: Vec2ui, bX: Int, bY: Int): Vec2ui {
        res.x.v = a.x.v shl bX
        res.y.v = a.y.v shl bY
        return res
    }

    fun shr(res: Vec2ui, a: Vec2ui, bX: Uint, bY: Uint): Vec2ui {
        res.x.v = a.x.v ushr bX.v
        res.y.v = a.y.v ushr bY.v
        return res
    }

    fun shr(res: Vec2ui, a: Vec2ui, bX: Int, bY: Int): Vec2ui {
        res.x.v = a.x.v ushr bX
        res.y.v = a.y.v ushr bY
        return res
    }

    fun inv(res: Vec2ui, a: Vec2ui): Vec2ui {
        res.x.v = a.x.v.inv()
        res.y.v = a.y.v.inv()
        return res
    }
}


// -- Specific binary arithmetic operators --

infix operator fun Uint.plus(b: Vec2ui) = plus(Vec2ui(), b, this, this)
fun Uint.plus(b: Vec2ui, res: Vec2ui) = plus(res, b, this, this)
infix fun Uint.plus_(b: Vec2ui) = plus(b, b, this, this)

infix operator fun Uint.minus(b: Vec2ui) = minus(Vec2ui(), this, this, b)
fun Uint.minus(b: Vec2ui, res: Vec2ui) = minus(res, b, this, this)
infix fun Uint.minus_(b: Vec2ui) = minus(b, this, this, b)

infix operator fun Uint.times(b: Vec2ui) = times(Vec2ui(), b, this, this)
fun Uint.times(b: Vec2ui, res: Vec2ui) = times(res, b, this, this)
infix fun Uint.times_(b: Vec2ui) = times(b, b, this, this)

infix operator fun Uint.div(b: Vec2ui) = div(Vec2ui(), this, this, b)
fun Uint.div(b: Vec2ui, res: Vec2ui) = div(res, b, this, this)
infix fun Uint.div_(b: Vec2ui) = div(b, this, this, b)

infix operator fun Uint.rem(b: Vec2ui) = rem(Vec2ui(), this, this, b)
fun Uint.rem(b: Vec2ui, res: Vec2ui) = rem(res, b, this, this)
infix fun Uint.rem_(b: Vec2ui) = rem(b, this, this, b)


infix operator fun Int.plus(b: Vec2ui) = plus(Vec2ui(), b, this, this)
fun Int.plus(b: Vec2ui, res: Vec2ui) = plus(res, b, this, this)
infix fun Int.plus_(b: Vec2ui) = plus(b, b, this, this)

infix operator fun Int.minus(b: Vec2ui) = minus(Vec2ui(), this, this, b)
fun Int.minus(b: Vec2ui, res: Vec2ui) = minus(res, b, this, this)
infix fun Int.minus_(b: Vec2ui) = minus(b, this, this, b)

infix operator fun Int.times(b: Vec2ui) = times(Vec2ui(), b, this, this)
fun Int.times(b: Vec2ui, res: Vec2ui) = times(res, b, this, this)
infix fun Int.times_(b: Vec2ui) = times(b, b, this, this)

infix operator fun Int.div(b: Vec2ui) = div(Vec2ui(), this, this, b)
fun Int.div(b: Vec2ui, res: Vec2ui) = div(res, b, this, this)
infix fun Int.div_(b: Vec2ui) = div(b, this, this, b)

infix operator fun Int.rem(b: Vec2ui) = rem(Vec2ui(), this, this, b)
fun Int.rem(b: Vec2ui, res: Vec2ui) = rem(res, b, this, this)
infix fun Int.rem_(b: Vec2ui) = rem(b, this, this, b)


// -- Generic binary arithmetic operators --

infix operator fun Number.plus(b: Vec2ui) = plus(Vec2ui(), b, this.i, this.i)
fun Number.plus(b: Vec2ui, res: Vec2ui) = plus(res, b, this.i, this.i)
infix fun Number.plus_(b: Vec2ui) = plus(b, b, this.i, this.i)

infix operator fun Number.minus(b: Vec2ui) = minus(Vec2ui(), this.i, this.i, b)
fun Number.minus(b: Vec2ui, res: Vec2ui) = minus(res, b, this.i, this.i)
infix fun Number.minus_(b: Vec2ui) = minus(b, this.i, this.i, b)

infix operator fun Number.times(b: Vec2ui) = times(Vec2ui(), b, this.i, this.i)
fun Number.times(b: Vec2ui, res: Vec2ui) = times(res, b, this.i, this.i)
infix fun Number.times_(b: Vec2ui) = times(b, b, this.i, this.i)

infix operator fun Number.div(b: Vec2ui) = div(Vec2ui(), this.i, this.i, b)
fun Number.div(b: Vec2ui, res: Vec2ui) = div(res, b, this.i, this.i)
infix fun Number.div_(b: Vec2ui) = div(b, this.i, this.i, b)

infix operator fun Number.rem(b: Vec2ui) = rem(Vec2ui(), this.i, this.i, b)
fun Number.rem(b: Vec2ui, res: Vec2ui) = rem(res, b, this.i, this.i)
infix fun Number.rem_(b: Vec2ui) = rem(b, this.i, this.i, b)