package glm_.vec4.operators

import glm_.i
import glm_.vec4.Vec4ui
import glm_.vec4.Vec4ui.Companion.div
import glm_.vec4.Vec4ui.Companion.minus
import glm_.vec4.Vec4ui.Companion.plus
import glm_.vec4.Vec4ui.Companion.rem
import glm_.vec4.Vec4ui.Companion.times
import unsigned.Uint
import unsigned.udiv
import unsigned.urem

/**
 * Created by GBarbieri on 08.11.2016.
 */

interface vec4ui_operators {

    fun plus(res: Vec4ui, a: Vec4ui, bX: Uint, bY: Uint, bZ: Uint, bW: Uint): Vec4ui {
        res.x.v = a.x.v + bX.v
        res.y.v = a.y.v + bY.v
        res.z.v = a.z.v + bZ.v
        res.w.v = a.w.v + bW.v
        return res
    }

    fun plus(res: Vec4ui, a: Vec4ui, bX: Int, bY: Int, bZ: Int, bW: Int): Vec4ui {
        res.x.v = a.x.v + bX
        res.y.v = a.y.v + bY
        res.z.v = a.z.v + bZ
        res.w.v = a.w.v + bW
        return res
    }

    fun minus(res: Vec4ui, a: Vec4ui, bX: Uint, bY: Uint, bZ: Uint, bW: Uint): Vec4ui {
        res.x.v = a.x.v - bX.v
        res.y.v = a.y.v - bY.v
        res.z.v = a.z.v - bZ.v
        res.w.v = a.w.v - bW.v
        return res
    }

    fun minus(res: Vec4ui, a: Vec4ui, bX: Int, bY: Int, bZ: Int, bW: Int): Vec4ui {
        res.x.v = a.x.v - bX
        res.y.v = a.y.v - bY
        res.z.v = a.z.v - bZ
        res.w.v = a.w.v - bW
        return res
    }

    fun minus(res: Vec4ui, aX: Uint, aY: Uint, aZ: Uint, aW: Uint, b: Vec4ui): Vec4ui {
        res.x.v = aX.v - b.x.v
        res.y.v = aY.v - b.y.v
        res.z.v = aZ.v - b.z.v
        res.w.v = aW.v - b.w.v
        return res
    }

    fun minus(res: Vec4ui, aX: Int, aY: Int, aZ: Int, aW: Int, b: Vec4ui): Vec4ui {
        res.x.v = aX - b.x.v
        res.y.v = aY - b.y.v
        res.z.v = aZ - b.z.v
        res.w.v = aW - b.w.v
        return res
    }

    fun times(res: Vec4ui, a: Vec4ui, bX: Uint, bY: Uint, bZ: Uint, bW: Uint): Vec4ui {
        res.x.v = a.x.v * bX.v
        res.y.v = a.y.v * bY.v
        res.z.v = a.z.v * bZ.v
        res.w.v = a.w.v * bW.v
        return res
    }

    fun times(res: Vec4ui, a: Vec4ui, bX: Int, bY: Int, bZ: Int, bW: Int): Vec4ui {
        res.x.v = a.x.v * bX
        res.y.v = a.y.v * bY
        res.z.v = a.z.v * bZ
        res.w.v = a.w.v * bW
        return res
    }

    fun div(res: Vec4ui, a: Vec4ui, bX: Uint, bY: Uint, bZ: Uint, bW: Uint): Vec4ui {
        res.x.v = a.x.v udiv bX.v
        res.y.v = a.y.v udiv bY.v
        res.z.v = a.z.v udiv bZ.v
        res.w.v = a.w.v udiv bW.v
        return res
    }

    fun div(res: Vec4ui, a: Vec4ui, bX: Int, bY: Int, bZ: Int, bW: Int): Vec4ui {
        res.x.v = a.x.v udiv bX
        res.y.v = a.y.v udiv bY
        res.z.v = a.z.v udiv bZ
        res.w.v = a.w.v udiv bW
        return res
    }

    fun div(res: Vec4ui, aX: Uint, aY: Uint, aZ: Uint, aW: Uint, b: Vec4ui): Vec4ui {
        res.x.v = aX.v udiv b.x.v
        res.y.v = aY.v udiv b.y.v
        res.z.v = aZ.v udiv b.z.v
        res.w.v = aW.v udiv b.w.v
        return res
    }

    fun div(res: Vec4ui, aX: Int, aY: Int, aZ: Int, aW: Int, b: Vec4ui): Vec4ui {
        res.x.v = aX udiv b.x.v
        res.y.v = aY udiv b.y.v
        res.z.v = aZ udiv b.z.v
        res.w.v = aW udiv b.w.v
        return res
    }

    fun rem(res: Vec4ui, a: Vec4ui, bX: Uint, bY: Uint, bZ: Uint, bW: Uint): Vec4ui {
        res.x.v = a.x.v urem bX.v
        res.y.v = a.y.v urem bY.v
        res.z.v = a.z.v urem bZ.v
        res.w.v = a.w.v urem bW.v
        return res
    }

    fun rem(res: Vec4ui, a: Vec4ui, bX: Int, bY: Int, bZ: Int, bW: Int): Vec4ui {
        res.x.v = a.x.v urem bX
        res.y.v = a.y.v urem bY
        res.z.v = a.z.v urem bZ
        res.w.v = a.w.v urem bW
        return res
    }

    fun rem(res: Vec4ui, aX: Uint, aY: Uint, aZ: Uint, aW: Uint, b: Vec4ui): Vec4ui {
        res.x.v = aX.v urem b.x.v
        res.y.v = aY.v urem b.y.v
        res.z.v = aZ.v urem b.z.v
        res.w.v = aW.v urem b.w.v
        return res
    }

    fun rem(res: Vec4ui, aX: Int, aY: Int, aZ: Int, aW: Int, b: Vec4ui): Vec4ui {
        res.x.v = aX urem b.x.v
        res.y.v = aY urem b.y.v
        res.z.v = aZ urem b.z.v
        res.w.v = aW urem b.w.v
        return res
    }

    fun and(res: Vec4ui, a: Vec4ui, bX: Uint, bY: Uint, bZ: Uint, bW: Uint): Vec4ui {
        res.x.v = a.x.v and bX.v
        res.y.v = a.y.v and bY.v
        res.z.v = a.z.v and bZ.v
        res.w.v = a.w.v and bW.v
        return res
    }

    fun and(res: Vec4ui, a: Vec4ui, bX: Int, bY: Int, bZ: Int, bW: Int): Vec4ui {
        res.x.v = a.x.v and bX
        res.y.v = a.y.v and bY
        res.z.v = a.z.v and bZ
        res.w.v = a.w.v and bW
        return res
    }

    fun or(res: Vec4ui, a: Vec4ui, bX: Uint, bY: Uint, bZ: Uint, bW: Uint): Vec4ui {
        res.x.v = a.x.v or bX.v
        res.y.v = a.y.v or bY.v
        res.z.v = a.z.v or bZ.v
        res.w.v = a.w.v or bW.v
        return res
    }

    fun or(res: Vec4ui, a: Vec4ui, bX: Int, bY: Int, bZ: Int, bW: Int): Vec4ui {
        res.x.v = a.x.v or bX
        res.y.v = a.y.v or bY
        res.z.v = a.z.v or bZ
        res.w.v = a.w.v or bW
        return res
    }

    fun xor(res: Vec4ui, a: Vec4ui, bX: Uint, bY: Uint, bZ: Uint, bW: Uint): Vec4ui {
        res.x.v = a.x.v xor bX.v
        res.y.v = a.y.v xor bY.v
        res.z.v = a.z.v xor bZ.v
        res.w.v = a.w.v xor bW.v
        return res
    }

    fun xor(res: Vec4ui, a: Vec4ui, bX: Int, bY: Int, bZ: Int, bW: Int): Vec4ui {
        res.x.v = a.x.v xor bX
        res.y.v = a.y.v xor bY
        res.z.v = a.z.v xor bZ
        res.w.v = a.w.v xor bW
        return res
    }

    fun shl(res: Vec4ui, a: Vec4ui, bX: Uint, bY: Uint, bZ: Uint, bW: Uint): Vec4ui {
        res.x.v = a.x.v shl bX.v
        res.y.v = a.y.v shl bY.v
        res.z.v = a.z.v shl bZ.v
        res.w.v = a.w.v shl bW.v
        return res
    }

    fun shl(res: Vec4ui, a: Vec4ui, bX: Int, bY: Int, bZ: Int, bW: Int): Vec4ui {
        res.x.v = a.x.v shl bX
        res.y.v = a.y.v shl bY
        res.z.v = a.z.v shl bZ
        res.w.v = a.w.v shl bW
        return res
    }

    fun shr(res: Vec4ui, a: Vec4ui, bX: Uint, bY: Uint, bZ: Uint, bW: Uint): Vec4ui {
        res.x.v = a.x.v ushr bX.v
        res.y.v = a.y.v ushr bY.v
        res.z.v = a.z.v ushr bZ.v
        res.w.v = a.w.v ushr bW.v
        return res
    }

    fun shr(res: Vec4ui, a: Vec4ui, bX: Int, bY: Int, bZ: Int, bW: Int): Vec4ui {
        res.x.v = a.x.v ushr bX
        res.y.v = a.y.v ushr bY
        res.z.v = a.z.v ushr bZ
        res.w.v = a.w.v ushr bW
        return res
    }

    fun inv(res: Vec4ui, a: Vec4ui): Vec4ui {
        res.x.v = a.x.v.inv()
        res.y.v = a.y.v.inv()
        res.z.v = a.z.v.inv()
        res.w.v = a.w.v.inv()
        return res
    }
}


// -- Specific binary arithmetic operators --

infix operator fun Uint.plus(b: Vec4ui) = plus(Vec4ui(), b, this, this, this, this)
fun Uint.plus(b: Vec4ui, res: Vec4ui) = plus(res, b, this, this, this, this)
infix fun Uint.plus_(b: Vec4ui) = plus(b, b, this, this, this, this)

infix operator fun Uint.minus(b: Vec4ui) = minus(Vec4ui(), this, this, this, this, b)
fun Uint.minus(b: Vec4ui, res: Vec4ui) = minus(res, b, this, this, this, this)
infix fun Uint.minus_(b: Vec4ui) = minus(b, this, this, this, this, b)

infix operator fun Uint.times(b: Vec4ui) = times(Vec4ui(), b, this, this, this, this)
fun Uint.times(b: Vec4ui, res: Vec4ui) = times(res, b, this, this, this, this)
infix fun Uint.times_(b: Vec4ui) = times(b, b, this, this, this, this)

infix operator fun Uint.div(b: Vec4ui) = div(Vec4ui(), this, this, this, this, b)
fun Uint.div(b: Vec4ui, res: Vec4ui) = div(res, b, this, this, this, this)
infix fun Uint.div_(b: Vec4ui) = div(b, this, this, this, this, b)

infix operator fun Uint.rem(b: Vec4ui) = rem(Vec4ui(), this, this, this, this, b)
fun Uint.rem(b: Vec4ui, res: Vec4ui) = rem(res, b, this, this, this, this)
infix fun Uint.rem_(b: Vec4ui) = rem(b, this, this, this, this, b)


infix operator fun Int.plus(b: Vec4ui) = plus(Vec4ui(), b, this, this, this, this)
fun Int.plus(b: Vec4ui, res: Vec4ui) = plus(res, b, this, this, this, this)
infix fun Int.plus_(b: Vec4ui) = plus(b, b, this, this, this, this)

infix operator fun Int.minus(b: Vec4ui) = minus(Vec4ui(), this, this, this, this, b)
fun Int.minus(b: Vec4ui, res: Vec4ui) = minus(res, b, this, this, this, this)
infix fun Int.minus_(b: Vec4ui) = minus(b, this, this, this, this, b)

infix operator fun Int.times(b: Vec4ui) = times(Vec4ui(), b, this, this, this, this)
fun Int.times(b: Vec4ui, res: Vec4ui) = times(res, b, this, this, this, this)
infix fun Int.times_(b: Vec4ui) = times(b, b, this, this, this, this)

infix operator fun Int.div(b: Vec4ui) = div(Vec4ui(), this, this, this, this, b)
fun Int.div(b: Vec4ui, res: Vec4ui) = div(res, b, this, this, this, this)
infix fun Int.div_(b: Vec4ui) = div(b, this, this, this, this, b)

infix operator fun Int.rem(b: Vec4ui) = rem(Vec4ui(), this, this, this, this, b)
fun Int.rem(b: Vec4ui, res: Vec4ui) = rem(res, b, this, this, this, this)
infix fun Int.rem_(b: Vec4ui) = rem(b, this, this, this, this, b)


// -- Generic binary arithmetic operators --

infix operator fun Number.plus(b: Vec4ui) = plus(Vec4ui(), b, this.i, this.i, this.i, this.i)
fun Number.plus(b: Vec4ui, res: Vec4ui) = plus(res, b, this.i, this.i, this.i, this.i)
infix fun Number.plus_(b: Vec4ui) = plus(b, b, this.i, this.i, this.i, this.i)

infix operator fun Number.minus(b: Vec4ui) = minus(Vec4ui(), this.i, this.i, this.i, this.i, b)
fun Number.minus(b: Vec4ui, res: Vec4ui) = minus(res, b, this.i, this.i, this.i, this.i)
infix fun Number.minus_(b: Vec4ui) = minus(b, this.i, this.i, this.i, this.i, b)

infix operator fun Number.times(b: Vec4ui) = times(Vec4ui(), b, this.i, this.i, this.i, this.i)
fun Number.times(b: Vec4ui, res: Vec4ui) = times(res, b, this.i, this.i, this.i, this.i)
infix fun Number.times_(b: Vec4ui) = times(b, b, this.i, this.i, this.i, this.i)

infix operator fun Number.div(b: Vec4ui) = div(Vec4ui(), this.i, this.i, this.i, this.i, b)
fun Number.div(b: Vec4ui, res: Vec4ui) = div(res, b, this.i, this.i, this.i, this.i)
infix fun Number.div_(b: Vec4ui) = div(b, this.i, this.i, this.i, this.i, b)

infix operator fun Number.rem(b: Vec4ui) = rem(Vec4ui(), this.i, this.i, this.i, this.i, b)
fun Number.rem(b: Vec4ui, res: Vec4ui) = rem(res, b, this.i, this.i, this.i, this.i)
infix fun Number.rem_(b: Vec4ui) = rem(b, this.i, this.i, this.i, this.i, b)