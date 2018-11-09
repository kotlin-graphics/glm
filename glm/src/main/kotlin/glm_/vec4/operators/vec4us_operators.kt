package glm_.vec4.operators

import glm_.*
import glm_.vec4.Vec4us
import glm_.vec4.Vec4us.Companion.div
import glm_.vec4.Vec4us.Companion.minus
import glm_.vec4.Vec4us.Companion.plus
import glm_.vec4.Vec4us.Companion.rem
import glm_.vec4.Vec4us.Companion.times
import unsigned.*
import kotlin.experimental.and
import kotlin.experimental.inv
import kotlin.experimental.or
import kotlin.experimental.xor

/**
 * Created by elect on 09/11/16.
 */

interface vec4us_operators {

    fun plus(res: Vec4us, a: Vec4us, bX: Ushort, bY: Ushort, bZ: Ushort, bW: Ushort): Vec4us {
        res.x.v = (a.x.v + bX.v).s
        res.y.v = (a.y.v + bY.v).s
        res.z.v = (a.z.v + bZ.v).s
        res.w.v = (a.w.v + bW.v).s
        return res
    }

    fun plus(res: Vec4us, a: Vec4us, bX: Short, bY: Short, bZ: Short, bW: Short): Vec4us {
        res.x.v = (a.x.v + bX).s
        res.y.v = (a.y.v + bY).s
        res.z.v = (a.z.v + bZ).s
        res.w.v = (a.w.v + bW).s
        return res
    }

    fun plus(res: Vec4us, a: Vec4us, bX: Int, bY: Int, bZ: Int, bW: Int): Vec4us {
        res.x.v = (a.x.v + bX).s
        res.y.v = (a.y.v + bY).s
        res.z.v = (a.z.v + bZ).s
        res.w.v = (a.w.v + bW).s
        return res
    }

    fun minus(res: Vec4us, a: Vec4us, bX: Ushort, bY: Ushort, bZ: Ushort, bW: Ushort): Vec4us {
        res.x.v = (a.x.v - bX.v).s
        res.y.v = (a.y.v - bY.v).s
        res.z.v = (a.z.v - bZ.v).s
        res.w.v = (a.w.v - bW.v).s
        return res
    }

    fun minus(res: Vec4us, a: Vec4us, bX: Short, bY: Short, bZ: Short, bW: Short): Vec4us {
        res.x.v = (a.x.v - bX).s
        res.y.v = (a.y.v - bY).s
        res.z.v = (a.z.v - bZ).s
        res.w.v = (a.w.v - bW).s
        return res
    }

    fun minus(res: Vec4us, a: Vec4us, bX: Int, bY: Int, bZ: Int, bW: Int): Vec4us {
        res.x.v = (a.x.v - bX).s
        res.y.v = (a.y.v - bY).s
        res.z.v = (a.z.v - bZ).s
        res.w.v = (a.w.v - bW).s
        return res
    }

    fun minus(res: Vec4us, aX: Ushort, aY: Ushort, aZ: Ushort, aW: Ushort, b: Vec4us): Vec4us {
        res.x.v = (aX.v - b.x.v).s
        res.y.v = (aY.v - b.y.v).s
        res.z.v = (aZ.v - b.z.v).s
        res.w.v = (aW.v - b.w.v).s
        return res
    }

    fun minus(res: Vec4us, aX: Short, aY: Short, aZ: Short, aW: Short, b: Vec4us): Vec4us {
        res.x.v = (aX - b.x.v).s
        res.y.v = (aY - b.y.v).s
        res.z.v = (aZ - b.z.v).s
        res.w.v = (aW - b.w.v).s
        return res
    }

    fun minus(res: Vec4us, aX: Int, aY: Int, aZ: Int, aW: Int, b: Vec4us): Vec4us {
        res.x.v = (aX - b.x.v).s
        res.y.v = (aY - b.y.v).s
        res.z.v = (aZ - b.z.v).s
        res.w.v = (aW - b.w.v).s
        return res
    }

    fun times(res: Vec4us, a: Vec4us, bX: Ushort, bY: Ushort, bZ: Ushort, bW: Ushort): Vec4us {
        res.x.v = (a.x.v * bX.v).s
        res.y.v = (a.y.v * bY.v).s
        res.z.v = (a.z.v * bZ.v).s
        res.w.v = (a.w.v * bW.v).s
        return res
    }

    fun times(res: Vec4us, a: Vec4us, bX: Short, bY: Short, bZ: Short, bW: Short): Vec4us {
        res.x.v = (a.x.v * bX).s
        res.y.v = (a.y.v * bY).s
        res.z.v = (a.z.v * bZ).s
        res.w.v = (a.w.v * bW).s
        return res
    }

    fun times(res: Vec4us, a: Vec4us, bX: Int, bY: Int, bZ: Int, bW: Int): Vec4us {
        res.x.v = (a.x.v * bX).s
        res.y.v = (a.y.v * bY).s
        res.z.v = (a.z.v * bZ).s
        res.w.v = (a.w.v * bW).s
        return res
    }

    fun div(res: Vec4us, a: Vec4us, bX: Ushort, bY: Ushort, bZ: Ushort, bW: Ushort): Vec4us {
        res.x.v = a.x.v udiv bX.v
        res.y.v = a.y.v udiv bY.v
        res.z.v = a.z.v udiv bZ.v
        res.w.v = a.w.v udiv bW.v
        return res
    }

    fun div(res: Vec4us, a: Vec4us, bX: Short, bY: Short, bZ: Short, bW: Short): Vec4us {
        res.x.v = a.x.v udiv bX
        res.y.v = a.y.v udiv bY
        res.z.v = a.z.v udiv bZ
        res.w.v = a.w.v udiv bW
        return res
    }

    fun div(res: Vec4us, a: Vec4us, bX: Int, bY: Int, bZ: Int, bW: Int): Vec4us {
        res.x.v = a.x.v udiv bX
        res.y.v = a.y.v udiv bY
        res.z.v = a.z.v udiv bZ
        res.w.v = a.w.v udiv bW
        return res
    }

    fun div(res: Vec4us, aX: Ushort, aY: Ushort, aZ: Ushort, aW: Ushort, b: Vec4us): Vec4us {
        res.x.v = aX.v udiv b.x.v
        res.y.v = aY.v udiv b.y.v
        res.z.v = aZ.v udiv b.z.v
        res.w.v = aW.v udiv b.w.v
        return res
    }

    fun div(res: Vec4us, aX: Short, aY: Short, aZ: Short, aW: Short, b: Vec4us): Vec4us {
        res.x.v = aX udiv b.x.v
        res.y.v = aY udiv b.y.v
        res.z.v = aZ udiv b.z.v
        res.w.v = aW udiv b.w.v
        return res
    }

    fun div(res: Vec4us, aX: Int, aY: Int, aZ: Int, aW: Int, b: Vec4us): Vec4us {
        res.x.v = (aX udiv b.x.v).s
        res.y.v = (aY udiv b.y.v).s
        res.z.v = (aZ udiv b.z.v).s
        res.w.v = (aW udiv b.w.v).s
        return res
    }

    fun rem(res: Vec4us, a: Vec4us, bX: Ushort, bY: Ushort, bZ: Ushort, bW: Ushort): Vec4us {
        res.x.v = a.x.v urem bX.v
        res.y.v = a.y.v urem bY.v
        res.z.v = a.z.v urem bZ.v
        res.w.v = a.w.v urem bW.v
        return res
    }

    fun rem(res: Vec4us, a: Vec4us, bX: Short, bY: Short, bZ: Short, bW: Short): Vec4us {
        res.x.v = a.x.v urem bX
        res.y.v = a.y.v urem bY
        res.z.v = a.z.v urem bZ
        res.w.v = a.w.v urem bW
        return res
    }

    fun rem(res: Vec4us, a: Vec4us, bX: Int, bY: Int, bZ: Int, bW: Int): Vec4us {
        res.x.v = a.x.v urem bX
        res.y.v = a.y.v urem bY
        res.z.v = a.z.v urem bZ
        res.w.v = a.w.v urem bW
        return res
    }

    fun rem(res: Vec4us, aX: Ushort, aY: Ushort, aZ: Ushort, aW: Ushort, b: Vec4us): Vec4us {
        res.x.v = aX.v urem b.x.v
        res.y.v = aY.v urem b.y.v
        res.z.v = aZ.v urem b.z.v
        res.w.v = aW.v urem b.w.v
        return res
    }

    fun rem(res: Vec4us, aX: Short, aY: Short, aZ: Short, aW: Short, b: Vec4us): Vec4us {
        res.x.v = aX urem b.x.v
        res.y.v = aY urem b.y.v
        res.z.v = aZ urem b.z.v
        res.w.v = aW urem b.w.v
        return res
    }

    fun rem(res: Vec4us, aX: Int, aY: Int, aZ: Int, aW: Int, b: Vec4us): Vec4us {
        res.x.v = (aX urem b.x.v).s
        res.y.v = (aY urem b.y.v).s
        res.z.v = (aZ urem b.z.v).s
        res.w.v = (aW urem b.w.v).s
        return res
    }

    fun and(res: Vec4us, a: Vec4us, bX: Ushort, bY: Ushort, bZ: Ushort, bW: Ushort): Vec4us {
        res.x.v = a.x.v and bX.v
        res.y.v = a.y.v and bY.v
        res.z.v = a.z.v and bZ.v
        res.w.v = a.w.v and bW.v
        return res
    }

    fun and(res: Vec4us, a: Vec4us, bX: Short, bY: Short, bZ: Short, bW: Short): Vec4us {
        res.x.v = a.x.v and bX
        res.y.v = a.y.v and bY
        res.z.v = a.z.v and bZ
        res.w.v = a.w.v and bW
        return res
    }

    fun and(res: Vec4us, a: Vec4us, bX: Int, bY: Int, bZ: Int, bW: Int): Vec4us {
        res.x.v = a.x.v and bX
        res.y.v = a.y.v and bY
        res.z.v = a.z.v and bZ
        res.w.v = a.w.v and bW
        return res
    }

    fun or(res: Vec4us, a: Vec4us, bX: Ushort, bY: Ushort, bZ: Ushort, bW: Ushort): Vec4us {
        res.x.v = a.x.v or bX
        res.y.v = a.y.v or bY
        res.z.v = a.z.v or bZ
        res.w.v = a.w.v or bW
        return res
    }

    fun or(res: Vec4us, a: Vec4us, bX: Short, bY: Short, bZ: Short, bW: Short): Vec4us {
        res.x.v = a.x.v or bX
        res.y.v = a.y.v or bY
        res.z.v = a.z.v or bZ
        res.w.v = a.w.v or bW
        return res
    }

    fun or(res: Vec4us, a: Vec4us, bX: Int, bY: Int, bZ: Int, bW: Int): Vec4us {
        res.x.v = a.x.v or bX
        res.y.v = a.y.v or bY
        res.z.v = a.z.v or bZ
        res.w.v = a.w.v or bW
        return res
    }

    fun xor(res: Vec4us, a: Vec4us, bX: Ushort, bY: Ushort, bZ: Ushort, bW: Ushort): Vec4us {
        res.x.v = a.x.v xor bX
        res.y.v = a.y.v xor bY
        res.z.v = a.z.v xor bZ
        res.w.v = a.w.v xor bW
        return res
    }

    fun xor(res: Vec4us, a: Vec4us, bX: Short, bY: Short, bZ: Short, bW: Short): Vec4us {
        res.x.v = a.x.v xor bX
        res.y.v = a.y.v xor bY
        res.z.v = a.z.v xor bZ
        res.w.v = a.w.v xor bW
        return res
    }

    fun xor(res: Vec4us, a: Vec4us, bX: Int, bY: Int, bZ: Int, bW: Int): Vec4us {
        res.x.v = a.x.v xor bX
        res.y.v = a.y.v xor bY
        res.z.v = a.z.v xor bZ
        res.w.v = a.w.v xor bW
        return res
    }

    fun shl(res: Vec4us, a: Vec4us, bX: Ushort, bY: Ushort, bZ: Ushort, bW: Ushort): Vec4us {
        res.x.v = a.x.v shl bX
        res.y.v = a.y.v shl bY
        res.z.v = a.z.v shl bZ
        res.w.v = a.w.v shl bW
        return res
    }

    fun shl(res: Vec4us, a: Vec4us, bX: Short, bY: Short, bZ: Short, bW: Short): Vec4us {
        res.x.v = a.x.v shl bX
        res.y.v = a.y.v shl bY
        res.z.v = a.z.v shl bZ
        res.w.v = a.w.v shl bW
        return res
    }

    fun shl(res: Vec4us, a: Vec4us, bX: Int, bY: Int, bZ: Int, bW: Int): Vec4us {
        res.x.v = a.x.v shl bX
        res.y.v = a.y.v shl bY
        res.z.v = a.z.v shl bZ
        res.w.v = a.w.v shl bW
        return res
    }

    fun shr(res: Vec4us, a: Vec4us, bX: Ushort, bY: Ushort, bZ: Ushort, bW: Ushort): Vec4us {
        res.x.v = a.x.v ushr bX.v
        res.y.v = a.y.v ushr bY.v
        res.z.v = a.z.v ushr bZ.v
        res.w.v = a.w.v ushr bW.v
        return res
    }

    fun shr(res: Vec4us, a: Vec4us, bX: Short, bY: Short, bZ: Short, bW: Short): Vec4us {
        res.x.v = a.x.v ushr bX
        res.y.v = a.y.v ushr bY
        res.z.v = a.z.v ushr bZ
        res.w.v = a.w.v ushr bW
        return res
    }

    fun shr(res: Vec4us, a: Vec4us, bX: Int, bY: Int, bZ: Int, bW: Int): Vec4us {
        res.x.v = a.x.v ushr bX
        res.y.v = a.y.v ushr bY
        res.z.v = a.z.v ushr bZ
        res.w.v = a.w.v ushr bW
        return res
    }

    fun inv(res: Vec4us, a: Vec4us): Vec4us {
        res.x.v = a.x.v.inv()
        res.y.v = a.y.v.inv()
        res.z.v = a.z.v.inv()
        res.w.v = a.w.v.inv()
        return res
    }
}


// -- Specific binary arithmetic operators --

infix operator fun Ushort.plus(b: Vec4us) = plus(Vec4us(), b, this, this, this, this)
fun Ushort.plus(b: Vec4us, res: Vec4us) = plus(res, b, this, this, this, this)
infix fun Ushort.plusAssign(b: Vec4us) = plus(b, b, this, this, this, this)

infix operator fun Ushort.minus(b: Vec4us) = minus(Vec4us(), this, this, this, this, b)
fun Ushort.minus(b: Vec4us, res: Vec4us) = minus(res, this, this, this, this, b)
infix fun Ushort.minusAssign(b: Vec4us) = minus(b, this, this, this, this, b)

infix operator fun Ushort.times(b: Vec4us) = times(Vec4us(), b, this, this, this, this)
fun Ushort.times(b: Vec4us, res: Vec4us) = times(res, b, this, this, this, this)
infix fun Ushort.timesAssign(b: Vec4us) = times(b, b, this, this, this, this)

infix operator fun Ushort.div(b: Vec4us) = div(Vec4us(), this, this, this, this, b)
fun Ushort.div(b: Vec4us, res: Vec4us) = div(res, this, this, this, this, b)
infix fun Ushort.divAssign(b: Vec4us) = div(b, this, this, this, this, b)

infix operator fun Ushort.rem(b: Vec4us) = rem(Vec4us(), this, this, this, this, b)
fun Ushort.rem(b: Vec4us, res: Vec4us) = rem(res, this, this, this, this, b)
infix fun Ushort.remAssign(b: Vec4us) = rem(b, this, this, this, this, b)


infix operator fun Short.plus(b: Vec4us) = plus(Vec4us(), b, this, this, this, this)
fun Short.plus(b: Vec4us, res: Vec4us) = plus(res, b, this, this, this, this)
infix fun Short.plusAssign(b: Vec4us) = plus(b, b, this, this, this, this)

infix operator fun Short.minus(b: Vec4us) = minus(Vec4us(), this, this, this, this, b)
fun Short.minus(b: Vec4us, res: Vec4us) = minus(res, this, this, this, this, b)
infix fun Short.minusAssign(b: Vec4us) = minus(b, this, this, this, this, b)

infix operator fun Short.times(b: Vec4us) = times(Vec4us(), b, this, this, this, this)
fun Short.times(b: Vec4us, res: Vec4us) = times(res, b, this, this, this, this)
infix fun Short.timesAssign(b: Vec4us) = times(b, b, this, this, this, this)

infix operator fun Short.div(b: Vec4us) = div(Vec4us(), this, this, this, this, b)
fun Short.div(b: Vec4us, res: Vec4us) = div(res, this, this, this, this, b)
infix fun Short.divAssign(b: Vec4us) = div(b, this, this, this, this, b)

infix operator fun Short.rem(b: Vec4us) = rem(Vec4us(), this, this, this, this, b)
fun Short.rem(b: Vec4us, res: Vec4us) = rem(res, this, this, this, this, b)
infix fun Short.remAssign(b: Vec4us) = rem(b, this, this, this, this, b)


infix operator fun Int.plus(b: Vec4us) = plus(Vec4us(), b, this, this, this, this)
fun Int.plus(b: Vec4us, res: Vec4us) = plus(res, b, this, this, this, this)
infix fun Int.plusAssign(b: Vec4us) = plus(b, b, this, this, this, this)

infix operator fun Int.minus(b: Vec4us) = minus(Vec4us(), this, this, this, this, b)
fun Int.minus(b: Vec4us, res: Vec4us) = minus(res, this, this, this, this, b)
infix fun Int.minusAssign(b: Vec4us) = minus(b, this, this, this, this, b)

infix operator fun Int.times(b: Vec4us) = times(Vec4us(), b, this, this, this, this)
fun Int.times(b: Vec4us, res: Vec4us) = times(res, b, this, this, this, this)
infix fun Int.timesAssign(b: Vec4us) = times(b, b, this, this, this, this)

infix operator fun Int.div(b: Vec4us) = div(Vec4us(), this, this, this, this, b)
fun Int.div(b: Vec4us, res: Vec4us) = div(res, this, this, this, this, b)
infix fun Int.divAssign(b: Vec4us) = div(b, this, this, this, this, b)

infix operator fun Int.rem(b: Vec4us) = rem(Vec4us(), this, this, this, this, b)
fun Int.rem(b: Vec4us, res: Vec4us) = rem(res, this, this, this, this, b)
infix fun Int.remAssign(b: Vec4us) = rem(b, this, this, this, this, b)


// -- Generic binary arithmetic operators --

infix operator fun Number.plus(b: Vec4us) = plus(Vec4us(), b, this.i, this.i, this.i, this.i)
fun Number.plus(b: Vec4us, res: Vec4us) = plus(res, b, this.i, this.i, this.i, this.i)
infix fun Number.plusAssign(b: Vec4us) = plus(b, b, this.i, this.i, this.i, this.i)

infix operator fun Number.minus(b: Vec4us) = minus(Vec4us(), this.i, this.i, this.i, this.i, b)
fun Number.minus(b: Vec4us, res: Vec4us) = minus(res, this.i, this.i, this.i, this.i, b)
infix fun Number.minusAssign(b: Vec4us) = minus(b, this.i, this.i, this.i, this.i, b)

infix operator fun Number.times(b: Vec4us) = times(Vec4us(), b, this.i, this.i, this.i, this.i)
fun Number.timesAssign(b: Vec4us, res: Vec4us) = times(res, b, this.i, this.i, this.i, this.i)
infix fun Number.timesAssign(b: Vec4us) = times(b, b, this.i, this.i, this.i, this.i)

infix operator fun Number.div(b: Vec4us) = div(Vec4us(), this.i, this.i, this.i, this.i, b)
fun Number.div(b: Vec4us, res: Vec4us) = div(res, this.i, this.i, this.i, this.i, b)
infix fun Number.divAssign(b: Vec4us) = div(b, this.i, this.i, this.i, this.i, b)

infix operator fun Number.rem(b: Vec4us) = rem(Vec4us(), this.i, this.i, this.i, this.i, b)
fun Number.rem(b: Vec4us, res: Vec4us) = rem(res, this.i, this.i, this.i, this.i, b)
infix fun Number.remAssign(b: Vec4us) = rem(b, this.i, this.i, this.i, this.i, b)