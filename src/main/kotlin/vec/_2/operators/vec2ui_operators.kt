package vec._2.operators

import Uint
import i
import udiv
import urem
import vec._2.Vec2ui
import vec._2.Vec2ui.Companion.add
import vec._2.Vec2ui.Companion.div
import vec._2.Vec2ui.Companion.mul
import vec._2.Vec2ui.Companion.rem
import vec._2.Vec2ui.Companion.sub

/**
 * Created by GBarbieri on 08.11.2016.
 */

interface vec2ui_operators {

    fun add(res: Vec2ui, a: Vec2ui, bX: Uint, bY: Uint): Vec2ui {
        res.x.v = a.x.v + bX.v
        res.y.v = a.y.v + bY.v
        return res
    }

    fun add(res: Vec2ui, a: Vec2ui, bX: Int, bY: Int): Vec2ui {
        res.x.v = a.x.v + bX
        res.y.v = a.y.v + bY
        return res
    }

    fun sub(res: Vec2ui, a: Vec2ui, bX: Uint, bY: Uint): Vec2ui {
        res.x.v = a.x.v - bX.v
        res.y.v = a.y.v - bY.v
        return res
    }

    fun sub(res: Vec2ui, a: Vec2ui, bX: Int, bY: Int): Vec2ui {
        res.x.v = a.x.v - bX
        res.y.v = a.y.v - bY
        return res
    }

    fun sub(res: Vec2ui, aX: Uint, aY: Uint, b: Vec2ui): Vec2ui {
        res.x.v = aX.v - b.x.v
        res.y.v = aY.v - b.y.v
        return res
    }

    fun sub(res: Vec2ui, aX: Int, aY: Int, b: Vec2ui): Vec2ui {
        res.x.v = aX - b.x.v
        res.y.v = aY - b.y.v
        return res
    }

    fun mul(res: Vec2ui, a: Vec2ui, bX: Uint, bY: Uint): Vec2ui {
        res.x.v = a.x.v * bX.v
        res.y.v = a.y.v * bY.v
        return res
    }

    fun mul(res: Vec2ui, a: Vec2ui, bX: Int, bY: Int): Vec2ui {
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

operator fun Uint.plus(b: Vec2ui) = add(Vec2ui(), b, this, this)
fun Uint.add(b: Vec2ui, res: Vec2ui = Vec2ui()) = add(res, b, this, this)
infix fun Uint.add_(b: Vec2ui) = add(b, b, this, this)

operator fun Uint.minus(b: Vec2ui) = sub(Vec2ui(), this, this, b)
fun Uint.sub(b: Vec2ui, res: Vec2ui = Vec2ui()) = sub(res, b, this, this)
infix fun Uint.sub_(b: Vec2ui) = sub(b, this, this, b)

operator fun Uint.times(b: Vec2ui) = mul(Vec2ui(), b, this, this)
fun Uint.mul(b: Vec2ui, res: Vec2ui = Vec2ui()) = mul(res, b, this, this)
infix fun Uint.mul_(b: Vec2ui) = mul(b, b, this, this)

operator fun Uint.div(b: Vec2ui) = div(Vec2ui(), this, this, b)
fun Uint.div(b: Vec2ui, res: Vec2ui) = div(res, b, this, this)
infix fun Uint.div_(b: Vec2ui) = div(b, this, this, b)

operator fun Uint.rem(b: Vec2ui) = rem(Vec2ui(), this, this, b)
fun Uint.rem(b: Vec2ui, res: Vec2ui) = rem(res, b, this, this)
infix fun Uint.rem_(b: Vec2ui) = rem(b, this, this, b)


operator fun Int.plus(b: Vec2ui) = add(Vec2ui(), b, this, this)
fun Int.add(b: Vec2ui, res: Vec2ui = Vec2ui()) = add(res, b, this, this)
infix fun Int.add_(b: Vec2ui) = add(b, b, this, this)

operator fun Int.minus(b: Vec2ui) = sub(Vec2ui(), this, this, b)
fun Int.sub(b: Vec2ui, res: Vec2ui = Vec2ui()) = sub(res, b, this, this)
infix fun Int.sub_(b: Vec2ui) = sub(b, this, this, b)

operator fun Int.times(b: Vec2ui) = mul(Vec2ui(), b, this, this)
fun Int.mul(b: Vec2ui, res: Vec2ui = Vec2ui()) = mul(res, b, this, this)
infix fun Int.mul_(b: Vec2ui) = mul(b, b, this, this)

operator fun Int.div(b: Vec2ui) = div(Vec2ui(), this, this, b)
fun Int.div(b: Vec2ui, res: Vec2ui) = div(res, b, this, this)
infix fun Int.div_(b: Vec2ui) = div(b, this, this, b)

operator fun Int.rem(b: Vec2ui) = rem(Vec2ui(), this, this, b)
fun Int.rem(b: Vec2ui, res: Vec2ui) = rem(res, b, this, this)
infix fun Int.rem_(b: Vec2ui) = rem(b, this, this, b)


// -- Generic binary arithmetic operators --

operator fun Number.plus(b: Vec2ui) = add(Vec2ui(), b, this.i, this.i)
fun Number.add(b: Vec2ui, res: Vec2ui = Vec2ui()) = add(res, b, this.i, this.i)
infix fun Number.add_(b: Vec2ui) = add(b, b, this.i, this.i)

operator fun Number.minus(b: Vec2ui) = sub(Vec2ui(), this.i, this.i, b)
fun Number.sub(b: Vec2ui, res: Vec2ui = Vec2ui()) = sub(res, b, this.i, this.i)
infix fun Number.sub_(b: Vec2ui) = sub(b, this.i, this.i, b)

operator fun Number.times(b: Vec2ui) = mul(Vec2ui(), b, this.i, this.i)
fun Number.mul(b: Vec2ui, res: Vec2ui = Vec2ui()) = mul(res, b, this.i, this.i)
infix fun Number.mul_(b: Vec2ui) = mul(b, b, this.i, this.i)

operator fun Number.div(b: Vec2ui) = div(Vec2ui(), this.i, this.i, b)
fun Number.div(b: Vec2ui, res: Vec2ui) = div(res, b, this.i, this.i)
infix fun Number.div_(b: Vec2ui) = div(b, this.i, this.i, b)

operator fun Number.rem(b: Vec2ui) = rem(Vec2ui(), this.i, this.i, b)
fun Number.rem(b: Vec2ui, res: Vec2ui) = rem(res, b, this.i, this.i)
infix fun Number.rem_(b: Vec2ui) = rem(b, this.i, this.i, b)