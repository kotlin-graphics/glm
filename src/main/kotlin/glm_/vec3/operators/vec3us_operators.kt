package glm_.vec3.operators

import glm_.*
import glm_.vec3.Vec3us
import glm_.vec3.Vec3us.Companion.div
import glm_.vec3.Vec3us.Companion.minus
import glm_.vec3.Vec3us.Companion.plus
import glm_.vec3.Vec3us.Companion.rem
import glm_.vec3.Vec3us.Companion.times
import unsigned.*
import kotlin.experimental.and
import kotlin.experimental.inv
import kotlin.experimental.or
import kotlin.experimental.xor


/**
 * Created by elect on 09/11/16.
 */

open class vec3us_operators {

    inline fun plus(res: Vec3us, a: Vec3us, bX: Ushort, bY: Ushort, bZ: Ushort): Vec3us {
        res.x.v = (a.x.v + bX.v).s
        res.y.v = (a.y.v + bY.v).s
        res.z.v = (a.z.v + bZ.v).s
        return res
    }

    inline fun plus(res: Vec3us, a: Vec3us, bX: Short, bY: Short, bZ: Short): Vec3us {
        res.x.v = (a.x.v + bX).s
        res.y.v = (a.y.v + bY).s
        res.z.v = (a.z.v + bZ).s
        return res
    }

    inline fun plus(res: Vec3us, a: Vec3us, bX: Int, bY: Int, bZ: Int): Vec3us {
        res.x.v = (a.x.v + bX).s
        res.y.v = (a.y.v + bY).s
        res.z.v = (a.z.v + bZ).s
        return res
    }

    inline fun minus(res: Vec3us, a: Vec3us, bX: Ushort, bY: Ushort, bZ: Ushort): Vec3us {
        res.x.v = (a.x.v - bX.v).s
        res.y.v = (a.y.v - bY.v).s
        res.z.v = (a.z.v - bZ.v).s
        return res
    }

    inline fun minus(res: Vec3us, a: Vec3us, bX: Short, bY: Short, bZ: Short): Vec3us {
        res.x.v = (a.x.v - bX).s
        res.y.v = (a.y.v - bY).s
        res.z.v = (a.z.v - bZ).s
        return res
    }

    inline fun minus(res: Vec3us, a: Vec3us, bX: Int, bY: Int, bZ: Int): Vec3us {
        res.x.v = (a.x.v - bX).s
        res.y.v = (a.y.v - bY).s
        res.z.v = (a.z.v - bZ).s
        return res
    }

    inline fun minus(res: Vec3us, aX: Ushort, aY: Ushort, aZ: Ushort, b: Vec3us): Vec3us {
        res.x.v = (aX.v - b.x.v).s
        res.y.v = (aY.v - b.y.v).s
        res.z.v = (aZ.v - b.z.v).s
        return res
    }

    inline fun minus(res: Vec3us, aX: Short, aY: Short, aZ: Short, b: Vec3us): Vec3us {
        res.x.v = (aX - b.x.v).s
        res.y.v = (aY - b.y.v).s
        res.z.v = (aZ - b.z.v).s
        return res
    }

    inline fun minus(res: Vec3us, aX: Int, aY: Int, aZ: Int, b: Vec3us): Vec3us {
        res.x.v = (aX - b.x.v).s
        res.y.v = (aY - b.y.v).s
        res.z.v = (aZ - b.z.v).s
        return res
    }

    inline fun times(res: Vec3us, a: Vec3us, bX: Ushort, bY: Ushort, bZ: Ushort): Vec3us {
        res.x.v = (a.x.v * bX.v).s
        res.y.v = (a.y.v * bY.v).s
        res.z.v = (a.z.v * bZ.v).s
        return res
    }

    inline fun times(res: Vec3us, a: Vec3us, bX: Short, bY: Short, bZ: Short): Vec3us {
        res.x.v = (a.x.v * bX).s
        res.y.v = (a.y.v * bY).s
        res.z.v = (a.z.v * bZ).s
        return res
    }

    inline fun times(res: Vec3us, a: Vec3us, bX: Int, bY: Int, bZ: Int): Vec3us {
        res.x.v = (a.x.v * bX).s
        res.y.v = (a.y.v * bY).s
        res.z.v = (a.z.v * bZ).s
        return res
    }

    inline fun div(res: Vec3us, a: Vec3us, bX: Ushort, bY: Ushort, bZ: Ushort): Vec3us {
        res.x.v = a.x.v udiv bX.v
        res.y.v = a.y.v udiv bY.v
        res.z.v = a.z.v udiv bZ.v
        return res
    }

    inline fun div(res: Vec3us, a: Vec3us, bX: Short, bY: Short, bZ: Short): Vec3us {
        res.x.v = a.x.v udiv bX
        res.y.v = a.y.v udiv bY
        res.z.v = a.z.v udiv bZ
        return res
    }

    inline fun div(res: Vec3us, a: Vec3us, bX: Int, bY: Int, bZ: Int): Vec3us {
        res.x.v = a.x.v udiv bX
        res.y.v = a.y.v udiv bY
        res.z.v = a.z.v udiv bZ
        return res
    }

    inline fun div(res: Vec3us, aX: Ushort, aY: Ushort, aZ: Ushort, b: Vec3us): Vec3us {
        res.x.v = aX.v udiv b.x.v
        res.y.v = aY.v udiv b.y.v
        res.z.v = aZ.v udiv b.z.v
        return res
    }

    inline fun div(res: Vec3us, aX: Short, aY: Short, aZ: Short, b: Vec3us): Vec3us {
        res.x.v = aX udiv b.x.v
        res.y.v = aY udiv b.y.v
        res.z.v = aZ udiv b.z.v
        return res
    }

    inline fun div(res: Vec3us, aX: Int, aY: Int, aZ: Int, b: Vec3us): Vec3us {
        res.x.v = (aX udiv b.x.v).s
        res.y.v = (aY udiv b.y.v).s
        res.z.v = (aZ udiv b.z.v).s
        return res
    }

    inline fun rem(res: Vec3us, a: Vec3us, bX: Ushort, bY: Ushort, bZ: Ushort): Vec3us {
        res.x.v = a.x.v urem bX.v
        res.y.v = a.y.v urem bY.v
        res.z.v = a.z.v urem bZ.v
        return res
    }

    inline fun rem(res: Vec3us, a: Vec3us, bX: Short, bY: Short, bZ: Short): Vec3us {
        res.x.v = a.x.v urem bX
        res.y.v = a.y.v urem bY
        res.z.v = a.z.v urem bZ
        return res
    }

    inline fun rem(res: Vec3us, a: Vec3us, bX: Int, bY: Int, bZ: Int): Vec3us {
        res.x.v = a.x.v urem bX
        res.y.v = a.y.v urem bY
        res.z.v = a.z.v urem bZ
        return res
    }

    inline fun rem(res: Vec3us, aX: Ushort, aY: Ushort, aZ: Ushort, b: Vec3us): Vec3us {
        res.x.v = aX.v urem b.x.v
        res.y.v = aY.v urem b.y.v
        res.z.v = aZ.v urem b.z.v
        return res
    }

    inline fun rem(res: Vec3us, aX: Short, aY: Short, aZ: Short, b: Vec3us): Vec3us {
        res.x.v = aX urem b.x.v
        res.y.v = aY urem b.y.v
        res.z.v = aZ urem b.z.v
        return res
    }

    inline fun rem(res: Vec3us, aX: Int, aY: Int, aZ: Int, b: Vec3us): Vec3us {
        res.x.v = (aX urem b.x.v).s
        res.y.v = (aY urem b.y.v).s
        res.z.v = (aZ urem b.z.v).s
        return res
    }

    inline fun and(res: Vec3us, a: Vec3us, bX: Ushort, bY: Ushort, bZ: Ushort): Vec3us {
        res.x.v = a.x.v and bX.v
        res.y.v = a.y.v and bY.v
        res.z.v = a.z.v and bZ.v
        return res
    }

    inline fun and(res: Vec3us, a: Vec3us, bX: Short, bY: Short, bZ: Short): Vec3us {
        res.x.v = a.x.v and bX
        res.y.v = a.y.v and bY
        res.z.v = a.z.v and bZ
        return res
    }

    inline fun and(res: Vec3us, a: Vec3us, bX: Int, bY: Int, bZ: Int): Vec3us {
        res.x.v = a.x.v and bX
        res.y.v = a.y.v and bY
        res.z.v = a.z.v and bZ
        return res
    }

    inline fun or(res: Vec3us, a: Vec3us, bX: Ushort, bY: Ushort, bZ: Ushort): Vec3us {
        res.x.v = a.x.v or bX
        res.y.v = a.y.v or bY
        res.z.v = a.z.v or bZ
        return res
    }

    inline fun or(res: Vec3us, a: Vec3us, bX: Short, bY: Short, bZ: Short): Vec3us {
        res.x.v = a.x.v or bX
        res.y.v = a.y.v or bY
        res.z.v = a.z.v or bZ
        return res
    }

    inline fun or(res: Vec3us, a: Vec3us, bX: Int, bY: Int, bZ: Int): Vec3us {
        res.x.v = a.x.v or bX
        res.y.v = a.y.v or bY
        res.z.v = a.z.v or bZ
        return res
    }

    inline fun xor(res: Vec3us, a: Vec3us, bX: Ushort, bY: Ushort, bZ: Ushort): Vec3us {
        res.x.v = a.x.v xor bX
        res.y.v = a.y.v xor bY
        res.z.v = a.z.v xor bZ
        return res
    }

    inline fun xor(res: Vec3us, a: Vec3us, bX: Short, bY: Short, bZ: Short): Vec3us {
        res.x.v = a.x.v xor bX
        res.y.v = a.y.v xor bY
        res.z.v = a.z.v xor bZ
        return res
    }

    inline fun xor(res: Vec3us, a: Vec3us, bX: Int, bY: Int, bZ: Int): Vec3us {
        res.x.v = a.x.v xor bX
        res.y.v = a.y.v xor bY
        res.z.v = a.z.v xor bZ
        return res
    }

    inline fun shl(res: Vec3us, a: Vec3us, bX: Ushort, bY: Ushort, bZ: Ushort): Vec3us {
        res.x.v = a.x.v shl bX
        res.y.v = a.y.v shl bY
        res.z.v = a.z.v shl bZ
        return res
    }

    inline fun shl(res: Vec3us, a: Vec3us, bX: Short, bY: Short, bZ: Short): Vec3us {
        res.x.v = a.x.v shl bX
        res.y.v = a.y.v shl bY
        res.z.v = a.z.v shl bZ
        return res
    }

    inline fun shl(res: Vec3us, a: Vec3us, bX: Int, bY: Int, bZ: Int): Vec3us {
        res.x.v = a.x.v shl bX
        res.y.v = a.y.v shl bY
        res.z.v = a.z.v shl bZ
        return res
    }

    inline fun shr(res: Vec3us, a: Vec3us, bX: Ushort, bY: Ushort, bZ: Ushort): Vec3us {
        res.x.v = a.x.v ushr bX.v
        res.y.v = a.y.v ushr bY.v
        res.z.v = a.z.v ushr bZ.v
        return res
    }

    inline fun shr(res: Vec3us, a: Vec3us, bX: Short, bY: Short, bZ: Short): Vec3us {
        res.x.v = a.x.v ushr bX
        res.y.v = a.y.v ushr bY
        res.z.v = a.z.v ushr bZ
        return res
    }

    inline fun shr(res: Vec3us, a: Vec3us, bX: Int, bY: Int, bZ: Int): Vec3us {
        res.x.v = a.x.v ushr bX
        res.y.v = a.y.v ushr bY
        res.z.v = a.z.v ushr bZ
        return res
    }

    inline fun inv(res: Vec3us, a: Vec3us): Vec3us {
        res.x.v = a.x.v.inv()
        res.y.v = a.y.v.inv()
        res.z.v = a.z.v.inv()
        return res
    }
}


// -- Specific binary arithmetic operators --

infix operator fun Ushort.plus(b: Vec3us) = plus(Vec3us(), b, this, this, this)
fun Ushort.plus(b: Vec3us, res: Vec3us) = plus(res, b, this, this, this)
infix fun Ushort.plusAssign(b: Vec3us) = plus(b, b, this, this, this)

infix operator fun Ushort.minus(b: Vec3us) = minus(Vec3us(), this, this, this, b)
fun Ushort.minus(b: Vec3us, res: Vec3us) = minus(res, this, this, this, b)
infix fun Ushort.minusAssign(b: Vec3us) = minus(b, this, this, this, b)

infix operator fun Ushort.times(b: Vec3us) = times(Vec3us(), b, this, this, this)
fun Ushort.times(b: Vec3us, res: Vec3us) = times(res, b, this, this, this)
infix fun Ushort.timesAssign(b: Vec3us) = times(b, b, this, this, this)

infix operator fun Ushort.div(b: Vec3us) = div(Vec3us(), this, this, this, b)
fun Ushort.div(b: Vec3us, res: Vec3us) = div(res, this, this, this, b)
infix fun Ushort.divAssign(b: Vec3us) = div(b, this, this, this, b)

infix operator fun Ushort.rem(b: Vec3us) = rem(Vec3us(), this, this, this, b)
fun Ushort.rem(b: Vec3us, res: Vec3us) = rem(res, this, this, this, b)
infix fun Ushort.remAssign(b: Vec3us) = rem(b, this, this, this, b)


infix operator fun Short.plus(b: Vec3us) = plus(Vec3us(), b, this, this, this)
fun Short.plus(b: Vec3us, res: Vec3us) = plus(res, b, this, this, this)
infix fun Short.plusAssign(b: Vec3us) = plus(b, b, this, this, this)

infix operator fun Short.minus(b: Vec3us) = minus(Vec3us(), this, this, this, b)
fun Short.minus(b: Vec3us, res: Vec3us) = minus(res, this, this, this, b)
infix fun Short.minusAssign(b: Vec3us) = minus(b, this, this, this, b)

infix operator fun Short.times(b: Vec3us) = times(Vec3us(), b, this, this, this)
fun Short.times(b: Vec3us, res: Vec3us) = times(res, b, this, this, this)
infix fun Short.timesAssign(b: Vec3us) = times(b, b, this, this, this)

infix operator fun Short.div(b: Vec3us) = div(Vec3us(), this, this, this, b)
fun Short.div(b: Vec3us, res: Vec3us) = div(res, this, this, this, b)
infix fun Short.divAssign(b: Vec3us) = div(b, this, this, this, b)

infix operator fun Short.rem(b: Vec3us) = rem(Vec3us(), this, this, this, b)
fun Short.rem(b: Vec3us, res: Vec3us) = rem(res, this, this, this, b)
infix fun Short.remAssign(b: Vec3us) = rem(b, this, this, this, b)


infix operator fun Int.plus(b: Vec3us) = plus(Vec3us(), b, this, this, this)
fun Int.plus(b: Vec3us, res: Vec3us) = plus(res, b, this, this, this)
infix fun Int.plusAssign(b: Vec3us) = plus(b, b, this, this, this)

infix operator fun Int.minus(b: Vec3us) = minus(Vec3us(), this, this, this, b)
fun Int.minus(b: Vec3us, res: Vec3us) = minus(res, this, this, this, b)
infix fun Int.minusAssign(b: Vec3us) = minus(b, this, this, this, b)

infix operator fun Int.times(b: Vec3us) = times(Vec3us(), b, this, this, this)
fun Int.times(b: Vec3us, res: Vec3us) = times(res, b, this, this, this)
infix fun Int.timesAssign(b: Vec3us) = times(b, b, this, this, this)

infix operator fun Int.div(b: Vec3us) = div(Vec3us(), this, this, this, b)
fun Int.div(b: Vec3us, res: Vec3us) = div(res, this, this, this, b)
infix fun Int.divAssign(b: Vec3us) = div(b, this, this, this, b)

infix operator fun Int.rem(b: Vec3us) = rem(Vec3us(), this, this, this, b)
fun Int.rem(b: Vec3us, res: Vec3us) = rem(res, this, this, this, b)
infix fun Int.remAssign(b: Vec3us) = rem(b, this, this, this, b)


// -- Generic binary arithmetic operators --

infix operator fun Number.plus(b: Vec3us) = plus(Vec3us(), b, this.i, this.i, this.i)
fun Number.plus(b: Vec3us, res: Vec3us) = plus(res, b, this.i, this.i, this.i)
infix fun Number.plusAssign(b: Vec3us) = plus(b, b, this.i, this.i, this.i)

infix operator fun Number.minus(b: Vec3us) = minus(Vec3us(), this.i, this.i, this.i, b)
fun Number.minus(b: Vec3us, res: Vec3us) = minus(res, this.i, this.i, this.i, b)
infix fun Number.minusAssign(b: Vec3us) = minus(b, this.i, this.i, this.i, b)

infix operator fun Number.times(b: Vec3us) = times(Vec3us(), b, this.i, this.i, this.i)
fun Number.times(b: Vec3us, res: Vec3us) = times(res, b, this.i, this.i, this.i)
infix fun Number.timesAssign(b: Vec3us) = times(b, b, this.i, this.i, this.i)

infix operator fun Number.div(b: Vec3us) = div(Vec3us(), this.i, this.i, this.i, b)
fun Number.div(b: Vec3us, res: Vec3us) = div(res, this.i, this.i, this.i, b)
infix fun Number.divAssign(b: Vec3us) = div(b, this.i, this.i, this.i, b)

infix operator fun Number.rem(b: Vec3us) = rem(Vec3us(), this.i, this.i, this.i, b)
fun Number.rem(b: Vec3us, res: Vec3us) = rem(res, this.i, this.i, this.i, b)
infix fun Number.remAssign(b: Vec3us) = rem(b, this.i, this.i, this.i, b)