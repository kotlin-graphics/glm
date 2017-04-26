package glm.vec4.operators

import glm.*
import unsigned.*
import glm.vec4.Vec4ub
import glm.vec4.Vec4ub.Companion.plus
import glm.vec4.Vec4ub.Companion.minus
import glm.vec4.Vec4ub.Companion.times
import glm.vec4.Vec4ub.Companion.div
import glm.vec4.Vec4ub.Companion.rem
import kotlin.experimental.*

/**
 * Created by GBarbieri on 08.11.2016.
 */

interface vec4ub_operators {

    fun plus(res: Vec4ub, a: Vec4ub, bX: Ubyte, bY: Ubyte, bZ: Ubyte, bW: Ubyte): Vec4ub {
        res.x.v = (a.x.v + bX.v).b
        res.y.v = (a.y.v + bY.v).b
        res.z.v = (a.z.v + bZ.v).b
        res.w.v = (a.w.v + bW.v).b
        return res
    }

    fun plus(res: Vec4ub, a: Vec4ub, bX: Byte, bY: Byte, bZ: Byte, bW: Byte): Vec4ub {
        res.x.v = (a.x.v + bX).b
        res.y.v = (a.y.v + bY).b
        res.z.v = (a.z.v + bZ).b
        res.w.v = (a.w.v + bW).b
        return res
    }

    fun plus(res: Vec4ub, a: Vec4ub, bX: Int, bY: Int, bZ: Int, bW: Int): Vec4ub {
        res.x.v = (a.x.v + bX).b
        res.y.v = (a.y.v + bY).b
        res.z.v = (a.z.v + bZ).b
        res.w.v = (a.w.v + bW).b
        return res
    }

    fun minus(res: Vec4ub, a: Vec4ub, bX: Ubyte, bY: Ubyte, bZ: Ubyte, bW: Ubyte): Vec4ub {
        res.x.v = (a.x.v - bX.v).b
        res.y.v = (a.y.v - bY.v).b
        res.z.v = (a.z.v - bZ.v).b
        res.w.v = (a.w.v - bW.v).b
        return res
    }

    fun minus(res: Vec4ub, a: Vec4ub, bX: Byte, bY: Byte, bZ: Byte, bW: Byte): Vec4ub {
        res.x.v = (a.x.v - bX).b
        res.y.v = (a.y.v - bY).b
        res.z.v = (a.z.v - bZ).b
        res.w.v = (a.w.v - bW).b
        return res
    }

    fun minus(res: Vec4ub, a: Vec4ub, bX: Int, bY: Int, bZ: Int, bW: Int): Vec4ub {
        res.x.v = (a.x.v - bX).b
        res.y.v = (a.y.v - bY).b
        res.z.v = (a.z.v - bZ).b
        res.w.v = (a.w.v - bW).b
        return res
    }

    fun minus(res: Vec4ub, aX: Ubyte, aY: Ubyte, aZ: Ubyte, aW: Ubyte, b: Vec4ub): Vec4ub {
        res.x.v = (aX.v - b.x.v).b
        res.y.v = (aY.v - b.y.v).b
        res.z.v = (aZ.v - b.z.v).b
        res.w.v = (aW.v - b.w.v).b
        return res
    }

    fun minus(res: Vec4ub, aX: Byte, aY: Byte, aZ: Byte, aW: Byte, b: Vec4ub): Vec4ub {
        res.x.v = (aX - b.x.v).b
        res.y.v = (aY - b.y.v).b
        res.z.v = (aZ - b.z.v).b
        res.w.v = (aW - b.w.v).b
        return res
    }

    fun minus(res: Vec4ub, aX: Int, aY: Int, aZ: Int, aW: Int, b: Vec4ub): Vec4ub {
        res.x.v = (aX - b.x.v).b
        res.y.v = (aY - b.y.v).b
        res.z.v = (aZ - b.z.v).b
        res.w.v = (aW - b.w.v).b
        return res
    }

    fun times(res: Vec4ub, a: Vec4ub, bX: Ubyte, bY: Ubyte, bZ: Ubyte, bW: Ubyte): Vec4ub {
        res.x.v = (a.x.v * bX.v).b
        res.y.v = (a.y.v * bY.v).b
        res.z.v = (a.z.v * bZ.v).b
        res.w.v = (a.w.v * bW.v).b
        return res
    }

    fun times(res: Vec4ub, a: Vec4ub, bX: Byte, bY: Byte, bZ: Byte, bW: Byte): Vec4ub {
        res.x.v = (a.x.v * bX).b
        res.y.v = (a.y.v * bY).b
        res.z.v = (a.z.v * bZ).b
        res.w.v = (a.w.v * bW).b
        return res
    }

    fun times(res: Vec4ub, a: Vec4ub, bX: Int, bY: Int, bZ: Int, bW: Int): Vec4ub {
        res.x.v = (a.x.v * bX).b
        res.y.v = (a.y.v * bY).b
        res.z.v = (a.z.v * bZ).b
        res.w.v = (a.w.v * bW).b
        return res
    }

    fun div(res: Vec4ub, a: Vec4ub, bX: Ubyte, bY: Ubyte, bZ: Ubyte, bW: Ubyte): Vec4ub {
        res.x.v = a.x.v udiv bX.v
        res.y.v = a.y.v udiv bY.v
        res.z.v = a.z.v udiv bZ.v
        res.w.v = a.w.v udiv bW.v
        return res
    }

    fun div(res: Vec4ub, a: Vec4ub, bX: Byte, bY: Byte, bZ: Byte, bW: Byte): Vec4ub {
        res.x.v = a.x.v udiv bX
        res.y.v = a.y.v udiv bY
        res.z.v = a.z.v udiv bZ
        res.w.v = a.w.v udiv bW
        return res
    }

    fun div(res: Vec4ub, a: Vec4ub, bX: Int, bY: Int, bZ: Int, bW: Int): Vec4ub {
        res.x.v = a.x.v udiv bX
        res.y.v = a.y.v udiv bY
        res.z.v = a.z.v udiv bZ
        res.w.v = a.w.v udiv bW
        return res
    }

    fun div(res: Vec4ub, aX: Ubyte, aY: Ubyte, aZ: Ubyte, aW: Ubyte, b: Vec4ub): Vec4ub {
        res.x.v = aX.v udiv b.x.v
        res.y.v = aY.v udiv b.y.v
        res.z.v = aZ.v udiv b.z.v
        res.w.v = aW.v udiv b.w.v
        return res
    }

    fun div(res: Vec4ub, aX: Byte, aY: Byte, aZ: Byte, aW: Byte, b: Vec4ub): Vec4ub {
        res.x.v = aX udiv b.x.v
        res.y.v = aY udiv b.y.v
        res.z.v = aZ udiv b.z.v
        res.w.v = aW udiv b.w.v
        return res
    }

    fun div(res: Vec4ub, aX: Int, aY: Int, aZ: Int, aW: Int, b: Vec4ub): Vec4ub {
        res.x.v = (aX udiv b.x.v).b
        res.y.v = (aY udiv b.y.v).b
        res.z.v = (aZ udiv b.z.v).b
        res.w.v = (aW udiv b.w.v).b
        return res
    }

    fun rem(res: Vec4ub, a: Vec4ub, bX: Ubyte, bY: Ubyte, bZ: Ubyte, bW: Ubyte): Vec4ub {
        res.x.v = a.x.v urem bX.v
        res.y.v = a.y.v urem bY.v
        res.z.v = a.z.v urem bZ.v
        res.w.v = a.w.v urem bW.v
        return res
    }

    fun rem(res: Vec4ub, a: Vec4ub, bX: Byte, bY: Byte, bZ: Byte, bW: Byte): Vec4ub {
        res.x.v = a.x.v urem bX
        res.y.v = a.y.v urem bY
        res.z.v = a.z.v urem bZ
        res.w.v = a.w.v urem bW
        return res
    }

    fun rem(res: Vec4ub, a: Vec4ub, bX: Int, bY: Int, bZ: Int, bW: Int): Vec4ub {
        res.x.v = a.x.v urem bX
        res.y.v = a.y.v urem bY
        res.z.v = a.z.v urem bZ
        res.w.v = a.w.v urem bW
        return res
    }

    fun rem(res: Vec4ub, aX: Ubyte, aY: Ubyte, aZ: Ubyte, aW: Ubyte, b: Vec4ub): Vec4ub {
        res.x.v = aX.v urem b.x.v
        res.y.v = aY.v urem b.y.v
        res.z.v = aZ.v urem b.z.v
        res.w.v = aW.v urem b.w.v
        return res
    }

    fun rem(res: Vec4ub, aX: Byte, aY: Byte, aZ: Byte, aW: Byte, b: Vec4ub): Vec4ub {
        res.x.v = aX urem b.x.v
        res.y.v = aY urem b.y.v
        res.z.v = aZ urem b.z.v
        res.w.v = aW urem b.w.v
        return res
    }

    fun rem(res: Vec4ub, aX: Int, aY: Int, aZ: Int, aW: Int, b: Vec4ub): Vec4ub {
        res.x.v = (aX urem b.x.v).b
        res.y.v = (aY urem b.y.v).b
        res.z.v = (aZ urem b.z.v).b
        res.w.v = (aW urem b.w.v).b
        return res
    }

    fun and(res: Vec4ub, a: Vec4ub, bX: Ubyte, bY: Ubyte, bZ: Ubyte, bW: Ubyte): Vec4ub {
        res.x.v = a.x.v and bX.v
        res.y.v = a.y.v and bY.v
        res.z.v = a.z.v and bZ.v
        res.w.v = a.w.v and bW.v
        return res
    }

    fun and(res: Vec4ub, a: Vec4ub, bX: Byte, bY: Byte, bZ: Byte, bW: Byte): Vec4ub {
        res.x.v = a.x.v and bX
        res.y.v = a.y.v and bY
        res.z.v = a.z.v and bZ
        res.w.v = a.w.v and bW
        return res
    }

    fun and(res: Vec4ub, a: Vec4ub, bX: Int, bY: Int, bZ: Int, bW: Int): Vec4ub {
        res.x.v = a.x.v and bX
        res.y.v = a.y.v and bY
        res.z.v = a.z.v and bZ
        res.w.v = a.w.v and bW
        return res
    }

    fun or(res: Vec4ub, a: Vec4ub, bX: Ubyte, bY: Ubyte, bZ: Ubyte, bW: Ubyte): Vec4ub {
        res.x.v = a.x.v or bX
        res.y.v = a.y.v or bY
        res.z.v = a.z.v or bZ
        res.w.v = a.w.v or bW
        return res
    }

    fun or(res: Vec4ub, a: Vec4ub, bX: Byte, bY: Byte, bZ: Byte, bW: Byte): Vec4ub {
        res.x.v = a.x.v or bX
        res.y.v = a.y.v or bY
        res.z.v = a.z.v or bZ
        res.w.v = a.w.v or bW
        return res
    }

    fun or(res: Vec4ub, a: Vec4ub, bX: Int, bY: Int, bZ: Int, bW: Int): Vec4ub {
        res.x.v = a.x.v or bX
        res.y.v = a.y.v or bY
        res.z.v = a.z.v or bZ
        res.w.v = a.w.v or bW
        return res
    }

    fun xor(res: Vec4ub, a: Vec4ub, bX: Ubyte, bY: Ubyte, bZ: Ubyte, bW: Ubyte): Vec4ub {
        res.x.v = a.x.v xor bX
        res.y.v = a.y.v xor bY
        res.z.v = a.z.v xor bZ
        res.w.v = a.w.v xor bW
        return res
    }

    fun xor(res: Vec4ub, a: Vec4ub, bX: Byte, bY: Byte, bZ: Byte, bW: Byte): Vec4ub {
        res.x.v = a.x.v xor bX
        res.y.v = a.y.v xor bY
        res.z.v = a.z.v xor bZ
        res.w.v = a.w.v xor bW
        return res
    }

    fun xor(res: Vec4ub, a: Vec4ub, bX: Int, bY: Int, bZ: Int, bW: Int): Vec4ub {
        res.x.v = a.x.v xor bX
        res.y.v = a.y.v xor bY
        res.z.v = a.z.v xor bZ
        res.w.v = a.w.v xor bW
        return res
    }

    fun shl(res: Vec4ub, a: Vec4ub, bX: Ubyte, bY: Ubyte, bZ: Ubyte, bW: Ubyte): Vec4ub {
        res.x.v = a.x.v shl bX
        res.y.v = a.y.v shl bY
        res.z.v = a.z.v shl bZ
        res.w.v = a.w.v shl bW
        return res
    }

    fun shl(res: Vec4ub, a: Vec4ub, bX: Byte, bY: Byte, bZ: Byte, bW: Byte): Vec4ub {
        res.x.v = a.x.v shl bX
        res.y.v = a.y.v shl bY
        res.z.v = a.z.v shl bZ
        res.w.v = a.w.v shl bW
        return res
    }

    fun shl(res: Vec4ub, a: Vec4ub, bX: Int, bY: Int, bZ: Int, bW: Int): Vec4ub {
        res.x.v = a.x.v shl bX
        res.y.v = a.y.v shl bY
        res.z.v = a.z.v shl bZ
        res.w.v = a.w.v shl bW
        return res
    }

    fun shr(res: Vec4ub, a: Vec4ub, bX: Ubyte, bY: Ubyte, bZ: Ubyte, bW: Ubyte): Vec4ub {
        res.x.v = a.x.v ushr bX
        res.y.v = a.y.v ushr bY
        res.z.v = a.z.v ushr bZ
        res.w.v = a.w.v ushr bW // TODO -v shr?
        return res
    }

    fun shr(res: Vec4ub, a: Vec4ub, bX: Byte, bY: Byte, bZ: Byte, bW: Byte): Vec4ub {
        res.x.v = a.x.v ushr bX
        res.y.v = a.y.v ushr bY
        res.z.v = a.z.v ushr bZ
        res.w.v = a.w.v ushr bW
        return res
    }

    fun shr(res: Vec4ub, a: Vec4ub, bX: Int, bY: Int, bZ: Int, bW: Int): Vec4ub {
        res.x.v = a.x.v ushr bX
        res.y.v = a.y.v ushr bY
        res.z.v = a.z.v ushr bZ
        res.w.v = a.w.v ushr bW
        return res
    }

    fun inv(res: Vec4ub, a: Vec4ub): Vec4ub {
        res.x.v = a.x.v.inv()
        res.y.v = a.y.v.inv()
        res.z.v = a.z.v.inv()
        res.w.v = a.w.v.inv()
        return res
    }
}


// -- Specific binary arithmetic operators --

infix operator fun Ubyte.plus(b: Vec4ub) = plus(Vec4ub(), b, this, this, this, this)
fun Ubyte.plus(b: Vec4ub, res: Vec4ub) = plus(res, b, this, this, this, this)
infix fun Ubyte.plus_(b: Vec4ub) = plus(b, b, this, this, this, this)

infix operator fun Ubyte.minus(b: Vec4ub) = minus(Vec4ub(), this, this, this, this, b)
fun Ubyte.minus(b: Vec4ub, res: Vec4ub) = minus(res, b, this, this, this, this)
infix fun Ubyte.minus_(b: Vec4ub) = minus(b, this, this, this, this, b)

infix operator fun Ubyte.times(b: Vec4ub) = times(Vec4ub(), b, this, this, this, this)
fun Ubyte.times(b: Vec4ub, res: Vec4ub) = times(res, b, this, this, this, this)
infix fun Ubyte.times_(b: Vec4ub) = times(b, b, this, this, this, this)

infix operator fun Ubyte.div(b: Vec4ub) = div(Vec4ub(), this, this, this, this, b)
fun Ubyte.div(b: Vec4ub, res: Vec4ub) = div(res, b, this, this, this, this)
infix fun Ubyte.div_(b: Vec4ub) = div(b, this, this, this, this, b)

infix operator fun Ubyte.rem(b: Vec4ub) = rem(Vec4ub(), this, this, this, this, b)
fun Ubyte.rem(b: Vec4ub, res: Vec4ub) = rem(res, b, this, this, this, this)
infix fun Ubyte.rem_(b: Vec4ub) = rem(b, this, this, this, this, b)


infix operator fun Byte.plus(b: Vec4ub) = plus(Vec4ub(), b, this, this, this, this)
fun Byte.plus(b: Vec4ub, res: Vec4ub) = plus(res, b, this, this, this, this)
infix fun Byte.plus_(b: Vec4ub) = plus(b, b, this, this, this, this)

infix operator fun Byte.minus(b: Vec4ub) = minus(Vec4ub(), this, this, this, this, b)
fun Byte.minus(b: Vec4ub, res: Vec4ub) = minus(res, b, this, this, this, this)
infix fun Byte.minus_(b: Vec4ub) = minus(b, this, this, this, this, b)

infix operator fun Byte.times(b: Vec4ub) = times(Vec4ub(), b, this, this, this, this)
fun Byte.times(b: Vec4ub, res: Vec4ub) = times(res, b, this, this, this, this)
infix fun Byte.times_(b: Vec4ub) = times(b, b, this, this, this, this)

infix operator fun Byte.div(b: Vec4ub) = div(Vec4ub(), this, this, this, this, b)
fun Byte.div(b: Vec4ub, res: Vec4ub) = div(res, b, this, this, this, this)
infix fun Byte.div_(b: Vec4ub) = div(b, this, this, this, this, b)

infix operator fun Byte.rem(b: Vec4ub) = rem(Vec4ub(), this, this, this, this, b)
fun Byte.rem(b: Vec4ub, res: Vec4ub) = rem(res, b, this, this, this, this)
infix fun Byte.rem_(b: Vec4ub) = rem(b, this, this, this, this, b)


infix operator fun Int.plus(b: Vec4ub) = plus(Vec4ub(), b, this, this, this, this)
fun Int.plus(b: Vec4ub, res: Vec4ub) = plus(res, b, this, this, this, this)
infix fun Int.plus_(b: Vec4ub) = plus(b, b, this, this, this, this)

infix operator fun Int.minus(b: Vec4ub) = minus(Vec4ub(), this, this, this, this, b)
fun Int.minus(b: Vec4ub, res: Vec4ub) = minus(res, b, this, this, this, this)
infix fun Int.minus_(b: Vec4ub) = minus(b, this, this, this, this, b)

infix operator fun Int.times(b: Vec4ub) = times(Vec4ub(), b, this, this, this, this)
fun Int.times(b: Vec4ub, res: Vec4ub) = times(res, b, this, this, this, this)
infix fun Int.times_(b: Vec4ub) = times(b, b, this, this, this, this)

infix operator fun Int.div(b: Vec4ub) = div(Vec4ub(), this, this, this, this, b)
fun Int.div(b: Vec4ub, res: Vec4ub) = div(res, b, this, this, this, this)
infix fun Int.div_(b: Vec4ub) = div(b, this, this, this, this, b)

infix operator fun Int.rem(b: Vec4ub) = rem(Vec4ub(), this, this, this, this, b)
fun Int.rem(b: Vec4ub, res: Vec4ub) = rem(res, b, this, this, this, this)
infix fun Int.rem_(b: Vec4ub) = rem(b, this, this, this, this, b)


// -- Specific binary arithmetic operators --

infix operator fun Number.plus(b: Vec4ub) = plus(Vec4ub(), b, this.i, this.i, this.i, this.i)
fun Number.plus(b: Vec4ub, res: Vec4ub) = plus(res, b, this.i, this.i, this.i, this.i)
infix fun Number.plus_(b: Vec4ub) = plus(b, b, this.i, this.i, this.i, this.i)

infix operator fun Number.minus(b: Vec4ub) = minus(Vec4ub(), this.i, this.i, this.i, this.i, b)
fun Number.minus(b: Vec4ub, res: Vec4ub) = minus(res, b, this.i, this.i, this.i, this.i)
infix fun Number.minus_(b: Vec4ub) = minus(b, this.i, this.i, this.i, this.i, b)

infix operator fun Number.times(b: Vec4ub) = times(Vec4ub(), b, this.i, this.i, this.i, this.i)
fun Number.times(b: Vec4ub, res: Vec4ub) = times(res, b, this.i, this.i, this.i, this.i)
infix fun Number.times_(b: Vec4ub) = times(b, b, this.i, this.i, this.i, this.i)

infix operator fun Number.div(b: Vec4ub) = div(Vec4ub(), this.i, this.i, this.i, this.i, b)
fun Number.div(b: Vec4ub, res: Vec4ub) = div(res, b, this.i, this.i, this.i, this.i)
infix fun Number.div_(b: Vec4ub) = div(b, this.i, this.i, this.i, this.i, b)

infix operator fun Number.rem(b: Vec4ub) = rem(Vec4ub(), this.i, this.i, this.i, this.i, b)
fun Number.rem(b: Vec4ub, res: Vec4ub) = rem(res, b, this.i, this.i, this.i, this.i)
infix fun Number.rem_(b: Vec4ub) = rem(b, this.i, this.i, this.i, this.i, b)