package glm.vec3.operators

import glm.*
import unsigned.*
import glm.vec3.Vec3ub
import glm.vec3.Vec3ub.Companion.plus
import glm.vec3.Vec3ub.Companion.minus
import glm.vec3.Vec3ub.Companion.times
import glm.vec3.Vec3ub.Companion.div
import glm.vec3.Vec3ub.Companion.rem
import kotlin.experimental.*

/**
 * Created by GBarbieri on 08.11.2016.
 */

interface vec3ub_operators {

    fun plus(res: Vec3ub, a: Vec3ub, bX: Ubyte, bY: Ubyte, bZ: Ubyte): Vec3ub {
        res.x.v = (a.x.v + bX.v).b
        res.y.v = (a.y.v + bY.v).b
        res.z.v = (a.z.v + bZ.v).b
        return res
    }

    fun plus(res: Vec3ub, a: Vec3ub, bX: Byte, bY: Byte, bZ: Byte): Vec3ub {
        res.x.v = (a.x.v + bX).b
        res.y.v = (a.y.v + bY).b
        res.z.v = (a.z.v + bZ).b
        return res
    }

    fun plus(res: Vec3ub, a: Vec3ub, bX: Int, bY: Int, bZ: Int): Vec3ub {
        res.x.v = (a.x.v + bX).b
        res.y.v = (a.y.v + bY).b
        res.z.v = (a.z.v + bZ).b
        return res
    }

    fun minus(res: Vec3ub, a: Vec3ub, bX: Ubyte, bY: Ubyte, bZ: Ubyte): Vec3ub {
        res.x.v = (a.x.v - bX.v).b
        res.y.v = (a.y.v - bY.v).b
        res.z.v = (a.z.v - bZ.v).b
        return res
    }

    fun minus(res: Vec3ub, a: Vec3ub, bX: Byte, bY: Byte, bZ: Byte): Vec3ub {
        res.x.v = (a.x.v - bX).b
        res.y.v = (a.y.v - bY).b
        res.z.v = (a.z.v - bZ).b
        return res
    }

    fun minus(res: Vec3ub, a: Vec3ub, bX: Int, bY: Int, bZ: Int): Vec3ub {
        res.x.v = (a.x.v - bX).b
        res.y.v = (a.y.v - bY).b
        res.z.v = (a.z.v - bZ).b
        return res
    }

    fun minus(res: Vec3ub, aX: Ubyte, aY: Ubyte, aZ: Ubyte, b: Vec3ub): Vec3ub {
        res.x.v = (aX.v - b.x.v).b
        res.y.v = (aY.v - b.y.v).b
        res.z.v = (aZ.v - b.z.v).b
        return res
    }

    fun minus(res: Vec3ub, aX: Byte, aY: Byte, aZ: Byte, b: Vec3ub): Vec3ub {
        res.x.v = (aX - b.x.v).b
        res.y.v = (aY - b.y.v).b
        res.z.v = (aZ - b.z.v).b
        return res
    }

    fun minus(res: Vec3ub, aX: Int, aY: Int, aZ: Int, b: Vec3ub): Vec3ub {
        res.x.v = (aX - b.x.v).b
        res.y.v = (aY - b.y.v).b
        res.z.v = (aZ - b.z.v).b
        return res
    }

    fun times(res: Vec3ub, a: Vec3ub, bX: Ubyte, bY: Ubyte, bZ: Ubyte): Vec3ub {
        res.x.v = (a.x.v * bX.v).b
        res.y.v = (a.y.v * bY.v).b
        res.z.v = (a.z.v * bZ.v).b
        return res
    }

    fun times(res: Vec3ub, a: Vec3ub, bX: Byte, bY: Byte, bZ: Byte): Vec3ub {
        res.x.v = (a.x.v * bX).b
        res.y.v = (a.y.v * bY).b
        res.z.v = (a.z.v * bZ).b
        return res
    }

    fun times(res: Vec3ub, a: Vec3ub, bX: Int, bY: Int, bZ: Int): Vec3ub {
        res.x.v = (a.x.v * bX).b
        res.y.v = (a.y.v * bY).b
        res.z.v = (a.z.v * bZ).b
        return res
    }

    fun div(res: Vec3ub, a: Vec3ub, bX: Ubyte, bY: Ubyte, bZ: Ubyte): Vec3ub {
        res.x.v = a.x.v udiv bX.v
        res.y.v = a.y.v udiv bY.v
        res.z.v = a.z.v udiv bZ.v
        return res
    }

    fun div(res: Vec3ub, a: Vec3ub, bX: Byte, bY: Byte, bZ: Byte): Vec3ub {
        res.x.v = a.x.v udiv bX
        res.y.v = a.y.v udiv bY
        res.z.v = a.z.v udiv bZ
        return res
    }

    fun div(res: Vec3ub, a: Vec3ub, bX: Int, bY: Int, bZ: Int): Vec3ub {
        res.x.v = a.x.v udiv bX
        res.y.v = a.y.v udiv bY
        res.z.v = a.z.v udiv bZ
        return res
    }

    fun div(res: Vec3ub, aX: Ubyte, aY: Ubyte, aZ: Ubyte, b: Vec3ub): Vec3ub {
        res.x.v = aX.v udiv b.x.v
        res.y.v = aY.v udiv b.y.v
        res.z.v = aZ.v udiv b.z.v
        return res
    }

    fun div(res: Vec3ub, aX: Byte, aY: Byte, aZ: Byte, b: Vec3ub): Vec3ub {
        res.x.v = aX udiv b.x.v
        res.y.v = aY udiv b.y.v
        res.z.v = aZ udiv b.z.v
        return res
    }

    fun div(res: Vec3ub, aX: Int, aY: Int, aZ: Int, b: Vec3ub): Vec3ub {
        res.x.v = (aX udiv b.x.v).b
        res.y.v = (aY udiv b.y.v).b
        res.z.v = (aZ udiv b.z.v).b
        return res
    }

    fun rem(res: Vec3ub, a: Vec3ub, bX: Ubyte, bY: Ubyte, bZ: Ubyte): Vec3ub {
        res.x.v = a.x.v urem bX.v
        res.y.v = a.y.v urem bY.v
        res.z.v = a.z.v urem bZ.v
        return res
    }

    fun rem(res: Vec3ub, a: Vec3ub, bX: Byte, bY: Byte, bZ: Byte): Vec3ub {
        res.x.v = a.x.v urem bX
        res.y.v = a.y.v urem bY
        res.z.v = a.z.v urem bZ
        return res
    }

    fun rem(res: Vec3ub, a: Vec3ub, bX: Int, bY: Int, bZ: Int): Vec3ub {
        res.x.v = a.x.v urem bX
        res.y.v = a.y.v urem bY
        res.z.v = a.z.v urem bZ
        return res
    }

    fun rem(res: Vec3ub, aX: Ubyte, aY: Ubyte, aZ: Ubyte, b: Vec3ub): Vec3ub {
        res.x.v = aX.v urem b.x.v
        res.y.v = aY.v urem b.y.v
        res.z.v = aZ.v urem b.z.v
        return res
    }

    fun rem(res: Vec3ub, aX: Byte, aY: Byte, aZ: Byte, b: Vec3ub): Vec3ub {
        res.x.v = aX urem b.x.v
        res.y.v = aY urem b.y.v
        res.z.v = aZ urem b.z.v
        return res
    }

    fun rem(res: Vec3ub, aX: Int, aY: Int, aZ: Int, b: Vec3ub): Vec3ub {
        res.x.v = (aX urem b.x.v).b
        res.y.v = (aY urem b.y.v).b
        res.z.v = (aZ urem b.z.v).b
        return res
    }

    fun and(res: Vec3ub, a: Vec3ub, bX: Ubyte, bY: Ubyte, bZ: Ubyte): Vec3ub {
        res.x.v = a.x.v and bX.v
        res.y.v = a.y.v and bY.v
        res.z.v = a.z.v and bZ.v
        return res
    }

    fun and(res: Vec3ub, a: Vec3ub, bX: Byte, bY: Byte, bZ: Byte): Vec3ub {
        res.x.v = a.x.v and bX
        res.y.v = a.y.v and bY
        res.z.v = a.z.v and bZ
        return res
    }

    fun and(res: Vec3ub, a: Vec3ub, bX: Int, bY: Int, bZ: Int): Vec3ub {
        res.x.v = a.x.v and bX
        res.y.v = a.y.v and bY
        res.z.v = a.z.v and bZ
        return res
    }

    fun or(res: Vec3ub, a: Vec3ub, bX: Ubyte, bY: Ubyte, bZ: Ubyte): Vec3ub {
        res.x.v = a.x.v or bX
        res.y.v = a.y.v or bY
        res.z.v = a.z.v or bZ
        return res
    }

    fun or(res: Vec3ub, a: Vec3ub, bX: Byte, bY: Byte, bZ: Byte): Vec3ub {
        res.x.v = a.x.v or bX
        res.y.v = a.y.v or bY
        res.z.v = a.z.v or bZ
        return res
    }

    fun or(res: Vec3ub, a: Vec3ub, bX: Int, bY: Int, bZ: Int): Vec3ub {
        res.x.v = a.x.v or bX
        res.y.v = a.y.v or bY
        res.z.v = a.z.v or bZ
        return res
    }

    fun xor(res: Vec3ub, a: Vec3ub, bX: Ubyte, bY: Ubyte, bZ: Ubyte): Vec3ub {
        res.x.v = a.x.v xor bX
        res.y.v = a.y.v xor bY
        res.z.v = a.z.v xor bZ
        return res
    }

    fun xor(res: Vec3ub, a: Vec3ub, bX: Byte, bY: Byte, bZ: Byte): Vec3ub {
        res.x.v = a.x.v xor bX
        res.y.v = a.y.v xor bY
        res.z.v = a.z.v xor bZ
        return res
    }

    fun xor(res: Vec3ub, a: Vec3ub, bX: Int, bY: Int, bZ: Int): Vec3ub {
        res.x.v = a.x.v xor bX
        res.y.v = a.y.v xor bY
        res.z.v = a.z.v xor bZ
        return res
    }

    fun shl(res: Vec3ub, a: Vec3ub, bX: Ubyte, bY: Ubyte, bZ: Ubyte): Vec3ub {
        res.x.v = a.x.v shl bX
        res.y.v = a.y.v shl bY
        res.z.v = a.z.v shl bZ
        return res
    }

    fun shl(res: Vec3ub, a: Vec3ub, bX: Byte, bY: Byte, bZ: Byte): Vec3ub {
        res.x.v = a.x.v shl bX
        res.y.v = a.y.v shl bY
        res.z.v = a.z.v shl bZ
        return res
    }

    fun shl(res: Vec3ub, a: Vec3ub, bX: Int, bY: Int, bZ: Int): Vec3ub {
        res.x.v = a.x.v shl bX
        res.y.v = a.y.v shl bY
        res.z.v = a.z.v shl bZ
        return res
    }

    fun shr(res: Vec3ub, a: Vec3ub, bX: Ubyte, bY: Ubyte, bZ: Ubyte): Vec3ub {
        res.x.v = a.x.v ushr bX
        res.y.v = a.y.v ushr bY
        res.z.v = a.z.v ushr bZ
        return res
    }

    fun shr(res: Vec3ub, a: Vec3ub, bX: Byte, bY: Byte, bZ: Byte): Vec3ub {
        res.x.v = a.x.v ushr bX
        res.y.v = a.y.v ushr bY
        res.z.v = a.z.v ushr bZ
        return res
    }

    fun shr(res: Vec3ub, a: Vec3ub, bX: Int, bY: Int, bZ: Int): Vec3ub {
        res.x.v = a.x.v ushr bX
        res.y.v = a.y.v ushr bY
        res.z.v = a.z.v ushr bZ
        return res
    }

    fun inv(res: Vec3ub, a: Vec3ub): Vec3ub {
        res.x.v = a.x.v.inv()
        res.y.v = a.y.v.inv()
        res.z.v = a.z.v.inv()
        return res
    }
}


// -- Specific binary arithmetic operators --

infix operator fun Ubyte.plus(b: Vec3ub) = plus(Vec3ub(), b, this, this, this)
fun Ubyte.plus(b: Vec3ub, res: Vec3ub) = plus(res, b, this, this, this)
infix fun Ubyte.plus_(b: Vec3ub) = plus(b, b, this, this, this)

infix operator fun Ubyte.minus(b: Vec3ub) = minus(Vec3ub(), this, this, this, b)
fun Ubyte.minus(b: Vec3ub, res: Vec3ub) = minus(res, b, this, this, this)
infix fun Ubyte.minus_(b: Vec3ub) = minus(b, this, this, this, b)

infix operator fun Ubyte.times(b: Vec3ub) = times(Vec3ub(), b, this, this, this)
fun Ubyte.times(b: Vec3ub, res: Vec3ub) = times(res, b, this, this, this)
infix fun Ubyte.times_(b: Vec3ub) = times(b, b, this, this, this)

infix operator fun Ubyte.div(b: Vec3ub) = div(Vec3ub(), this, this, this, b)
fun Ubyte.div(b: Vec3ub, res: Vec3ub) = div(res, b, this, this, this)
infix fun Ubyte.div_(b: Vec3ub) = div(b, this, this, this, b)

infix operator fun Ubyte.rem(b: Vec3ub) = rem(Vec3ub(), this, this, this, b)
fun Ubyte.rem(b: Vec3ub, res: Vec3ub) = rem(res, b, this, this, this)
infix fun Ubyte.rem_(b: Vec3ub) = rem(b, this, this, this, b)


infix operator fun Byte.plus(b: Vec3ub) = plus(Vec3ub(), b, this, this, this)
fun Byte.plus(b: Vec3ub, res: Vec3ub) = plus(res, b, this, this, this)
infix fun Byte.plus_(b: Vec3ub) = plus(b, b, this, this, this)

infix operator fun Byte.minus(b: Vec3ub) = minus(Vec3ub(), this, this, this, b)
fun Byte.minus(b: Vec3ub, res: Vec3ub) = minus(res, b, this, this, this)
infix fun Byte.minus_(b: Vec3ub) = minus(b, this, this, this, b)

infix operator fun Byte.times(b: Vec3ub) = times(Vec3ub(), b, this, this, this)
fun Byte.times(b: Vec3ub, res: Vec3ub) = times(res, b, this, this, this)
infix fun Byte.times_(b: Vec3ub) = times(b, b, this, this, this)

infix operator fun Byte.div(b: Vec3ub) = div(Vec3ub(), this, this, this, b)
fun Byte.div(b: Vec3ub, res: Vec3ub) = div(res, b, this, this, this)
infix fun Byte.div_(b: Vec3ub) = div(b, this, this, this, b)

infix operator fun Byte.rem(b: Vec3ub) = rem(Vec3ub(), this, this, this, b)
fun Byte.rem(b: Vec3ub, res: Vec3ub) = rem(res, b, this, this, this)
infix fun Byte.rem_(b: Vec3ub) = rem(b, this, this, this, b)


infix operator fun Int.plus(b: Vec3ub) = plus(Vec3ub(), b, this, this, this)
fun Int.plus(b: Vec3ub, res: Vec3ub) = plus(res, b, this, this, this)
infix fun Int.plus_(b: Vec3ub) = plus(b, b, this, this, this)

infix operator fun Int.minus(b: Vec3ub) = minus(Vec3ub(), this, this, this, b)
fun Int.minus(b: Vec3ub, res: Vec3ub) = minus(res, b, this, this, this)
infix fun Int.minus_(b: Vec3ub) = minus(b, this, this, this, b)

infix operator fun Int.times(b: Vec3ub) = times(Vec3ub(), b, this, this, this)
fun Int.times(b: Vec3ub, res: Vec3ub) = times(res, b, this, this, this)
infix fun Int.times_(b: Vec3ub) = times(b, b, this, this, this)

infix operator fun Int.div(b: Vec3ub) = div(Vec3ub(), this, this, this, b)
fun Int.div(b: Vec3ub, res: Vec3ub) = div(res, b, this, this, this)
infix fun Int.div_(b: Vec3ub) = div(b, this, this, this, b)

infix operator fun Int.rem(b: Vec3ub) = rem(Vec3ub(), this, this, this, b)
fun Int.rem(b: Vec3ub, res: Vec3ub) = rem(res, b, this, this, this)
infix fun Int.rem_(b: Vec3ub) = rem(b, this, this, this, b)


// -- Specific binary arithmetic operators --

infix operator fun Number.plus(b: Vec3ub) = plus(Vec3ub(), b, this.i, this.i, this.i)
fun Number.plus(b: Vec3ub, res: Vec3ub) = plus(res, b, this.i, this.i, this.i)
infix fun Number.plus_(b: Vec3ub) = plus(b, b, this.i, this.i, this.i)

infix operator fun Number.minus(b: Vec3ub) = minus(Vec3ub(), this.i, this.i, this.i, b)
fun Number.minus(b: Vec3ub, res: Vec3ub) = minus(res, b, this.i, this.i, this.i)
infix fun Number.minus_(b: Vec3ub) = minus(b, this.i, this.i, this.i, b)

infix operator fun Number.times(b: Vec3ub) = times(Vec3ub(), b, this.i, this.i, this.i)
fun Number.times(b: Vec3ub, res: Vec3ub) = times(res, b, this.i, this.i, this.i)
infix fun Number.times_(b: Vec3ub) = times(b, b, this.i, this.i, this.i)

infix operator fun Number.div(b: Vec3ub) = div(Vec3ub(), this.i, this.i, this.i, b)
fun Number.div(b: Vec3ub, res: Vec3ub) = div(res, b, this.i, this.i, this.i)
infix fun Number.div_(b: Vec3ub) = div(b, this.i, this.i, this.i, b)

infix operator fun Number.rem(b: Vec3ub) = rem(Vec3ub(), this.i, this.i, this.i, b)
fun Number.rem(b: Vec3ub, res: Vec3ub) = rem(res, b, this.i, this.i, this.i)
infix fun Number.rem_(b: Vec3ub) = rem(b, this.i, this.i, this.i, b)