package glm_.vec3.operators

import glm_.*
import glm_.vec3.Vec3ul
import glm_.vec3.Vec3ul.Companion.div
import glm_.vec3.Vec3ul.Companion.minus
import glm_.vec3.Vec3ul.Companion.plus
import glm_.vec3.Vec3ul.Companion.rem
import glm_.vec3.Vec3ul.Companion.times
import unsigned.udiv
import unsigned.Ulong
import unsigned.udiv
import unsigned.urem
import unsigned.urem

/**
 * Created by elect on 09/11/16.
 */
interface vec3ul_operators {


    fun plus(res: Vec3ul, a: Vec3ul, bX: Int, bY: Int, bZ: Int): Vec3ul {
        res.x.v = a.x.v + bX
        res.y.v = a.y.v + bY
        res.z.v = a.z.v + bZ
        return res
    }

    fun plus(res: Vec3ul, a: Vec3ul, bX: Ulong, bY: Ulong, bZ: Ulong): Vec3ul {
        res.x.v = a.x.v + bX.v
        res.y.v = a.y.v + bY.v
        res.z.v = a.z.v + bZ.v
        return res
    }

    fun plus(res: Vec3ul, a: Vec3ul, bX: Long, bY: Long, bZ: Long): Vec3ul {
        res.x.v = a.x.v + bX
        res.y.v = a.y.v + bY
        res.z.v = a.z.v + bZ
        return res
    }

    fun minus(res: Vec3ul, a: Vec3ul, bX: Int, bY: Int, bZ: Int): Vec3ul {
        res.x.v = a.x.v - bX
        res.y.v = a.y.v - bY
        res.z.v = a.z.v - bZ
        return res
    }

    fun minus(res: Vec3ul, a: Vec3ul, bX: Ulong, bY: Ulong, bZ: Ulong): Vec3ul {
        res.x.v = a.x.v - bX.v
        res.y.v = a.y.v - bY.v
        res.z.v = a.z.v - bZ.v
        return res
    }

    fun minus(res: Vec3ul, a: Vec3ul, bX: Long, bY: Long, bZ: Long): Vec3ul {
        res.x.v = a.x.v - bX
        res.y.v = a.y.v - bY
        res.z.v = a.z.v - bZ
        return res
    }

    fun minus(res: Vec3ul, aX: Int, aY: Int, aZ: Int, b: Vec3ul): Vec3ul {
        res.x.v = aX - b.x.v
        res.y.v = aY - b.y.v
        res.z.v = aZ - b.z.v
        return res
    }

    fun minus(res: Vec3ul, aX: Ulong, aY: Ulong, aZ: Ulong, b: Vec3ul): Vec3ul {
        res.x.v = aX.v - b.x.v
        res.y.v = aY.v - b.y.v
        res.z.v = aZ.v - b.z.v
        return res
    }

    fun minus(res: Vec3ul, aX: Long, aY: Long, aZ: Long, b: Vec3ul): Vec3ul {
        res.x.v = aX - b.x.v
        res.y.v = aY - b.y.v
        res.z.v = aZ - b.z.v
        return res
    }

    fun times(res: Vec3ul, a: Vec3ul, bX: Int, bY: Int, bZ: Int): Vec3ul {
        res.x.v = a.x.v * bX
        res.y.v = a.y.v * bY
        res.z.v = a.z.v * bZ
        return res
    }

    fun times(res: Vec3ul, a: Vec3ul, bX: Ulong, bY: Ulong, bZ: Ulong): Vec3ul {
        res.x.v = a.x.v * bX.v
        res.y.v = a.y.v * bY.v
        res.z.v = a.z.v * bZ.v
        return res
    }

    fun times(res: Vec3ul, a: Vec3ul, bX: Long, bY: Long, bZ: Long): Vec3ul {
        res.x.v = a.x.v * bX
        res.y.v = a.y.v * bY
        res.z.v = a.z.v * bZ
        return res
    }

    fun div(res: Vec3ul, a: Vec3ul, bX: Int, bY: Int, bZ: Int): Vec3ul {
        res.x.v = a.x.v udiv bX
        res.y.v = a.y.v udiv bY
        res.z.v = a.z.v udiv bZ
        return res
    }

    fun div(res: Vec3ul, a: Vec3ul, bX: Ulong, bY: Ulong, bZ: Ulong): Vec3ul {
        res.x.v = a.x.v udiv bX.v
        res.y.v = a.y.v udiv bY.v
        res.z.v = a.z.v udiv bZ.v
        return res
    }

    fun div(res: Vec3ul, a: Vec3ul, bX: Long, bY: Long, bZ: Long): Vec3ul {
        res.x.v = a.x.v udiv bX
        res.y.v = a.y.v udiv bY
        res.z.v = a.z.v udiv bZ
        return res
    }

    fun div(res: Vec3ul, aX: Int, aY: Int, aZ: Int, b: Vec3ul): Vec3ul {
        res.x.v = (aX udiv b.x.v).L
        res.y.v = (aY udiv b.y.v).L
        res.z.v = (aZ udiv b.z.v).L
        return res
    }

    fun div(res: Vec3ul, aX: Ulong, aY: Ulong, aZ: Ulong, b: Vec3ul): Vec3ul {
        res.x.v = aX.v udiv b.x.v
        res.y.v = aY.v udiv b.y.v
        res.z.v = aZ.v udiv b.z.v
        return res
    }

    fun div(res: Vec3ul, aX: Long, aY: Long, aZ: Long, b: Vec3ul): Vec3ul {
        res.x.v = aX udiv b.x.v
        res.y.v = aY udiv b.y.v
        res.z.v = aZ udiv b.z.v
        return res
    }

    fun rem(res: Vec3ul, a: Vec3ul, bX: Int, bY: Int, bZ: Int): Vec3ul {
        res.x.v = a.x.v urem bX
        res.y.v = a.y.v urem bY
        res.z.v = a.z.v urem bZ
        return res
    }

    fun rem(res: Vec3ul, a: Vec3ul, bX: Ulong, bY: Ulong, bZ: Ulong): Vec3ul {
        res.x.v = a.x.v urem bX.v
        res.y.v = a.y.v urem bY.v
        res.z.v = a.z.v urem bZ.v
        return res
    }

    fun rem(res: Vec3ul, a: Vec3ul, bX: Long, bY: Long, bZ: Long): Vec3ul {
        res.x.v = a.x.v urem bX
        res.y.v = a.y.v urem bY
        res.z.v = a.z.v urem bZ
        return res
    }

    fun rem(res: Vec3ul, aX: Int, aY: Int, aZ: Int, b: Vec3ul): Vec3ul {
        res.x.v = (aX urem b.x.v).L
        res.y.v = (aY urem b.y.v).L
        res.z.v = (aZ urem b.z.v).L
        return res
    }

    fun rem(res: Vec3ul, aX: Ulong, aY: Ulong, aZ: Ulong, b: Vec3ul): Vec3ul {
        res.x.v = aX.v urem b.x.v
        res.y.v = aY.v urem b.y.v
        res.z.v = aZ.v urem b.z.v
        return res
    }

    fun rem(res: Vec3ul, aX: Long, aY: Long, aZ: Long, b: Vec3ul): Vec3ul {
        res.x.v = aX urem b.x.v
        res.y.v = aY urem b.y.v
        res.z.v = aZ urem b.z.v
        return res
    }

    fun and(res: Vec3ul, a: Vec3ul, bX: Int, bY: Int, bZ: Int): Vec3ul {
        res.x.v = a.x.v and bX
        res.y.v = a.y.v and bY
        res.z.v = a.z.v and bZ
        return res
    }

    fun and(res: Vec3ul, a: Vec3ul, bX: Ulong, bY: Ulong, bZ: Ulong): Vec3ul {
        res.x.v = a.x.v and bX.v
        res.y.v = a.y.v and bY.v
        res.z.v = a.z.v and bZ.v
        return res
    }

    fun and(res: Vec3ul, a: Vec3ul, bX: Long, bY: Long, bZ: Long): Vec3ul {
        res.x.v = a.x.v and bX
        res.y.v = a.y.v and bY
        res.z.v = a.z.v and bZ
        return res
    }

    fun or(res: Vec3ul, a: Vec3ul, bX: Int, bY: Int, bZ: Int): Vec3ul {
        res.x.v = a.x.v or bX
        res.y.v = a.y.v or bY
        res.z.v = a.z.v or bZ
        return res
    }

    fun or(res: Vec3ul, a: Vec3ul, bX: Ulong, bY: Ulong, bZ: Ulong): Vec3ul {
        res.x.v = a.x.v or bX.v
        res.y.v = a.y.v or bY.v
        res.z.v = a.z.v or bZ.v
        return res
    }

    fun or(res: Vec3ul, a: Vec3ul, bX: Long, bY: Long, bZ: Long): Vec3ul {
        res.x.v = a.x.v or bX
        res.y.v = a.y.v or bY
        res.z.v = a.z.v or bZ
        return res
    }

    fun xor(res: Vec3ul, a: Vec3ul, bX: Int, bY: Int, bZ: Int): Vec3ul {
        res.x.v = a.x.v xor bX
        res.y.v = a.y.v xor bY
        res.z.v = a.z.v xor bZ
        return res
    }

    fun xor(res: Vec3ul, a: Vec3ul, bX: Ulong, bY: Ulong, bZ: Ulong): Vec3ul {
        res.x.v = a.x.v xor bX.v
        res.y.v = a.y.v xor bY.v
        res.z.v = a.z.v xor bZ.v
        return res
    }

    fun xor(res: Vec3ul, a: Vec3ul, bX: Long, bY: Long, bZ: Long): Vec3ul {
        res.x.v = a.x.v xor bX
        res.y.v = a.y.v xor bY
        res.z.v = a.z.v xor bZ
        return res
    }


    fun shl(res: Vec3ul, a: Vec3ul, bX: Int, bY: Int, bZ: Int): Vec3ul {
        res.x.v = a.x.v shl bX
        res.y.v = a.y.v shl bY
        res.z.v = a.z.v shl bZ
        return res
    }

    fun shl(res: Vec3ul, a: Vec3ul, bX: Long, bY: Long, bZ: Long): Vec3ul {
        res.x.v = a.x.v shl bX.i
        res.y.v = a.y.v shl bY.i
        res.z.v = a.z.v shl bZ.i
        return res
    }

    fun shl(res: Vec3ul, a: Vec3ul, bX: Ulong, bY: Ulong, bZ: Ulong): Vec3ul {
        res.x.v = a.x.v shl bX.v.i
        res.y.v = a.y.v shl bY.v.i
        res.z.v = a.z.v shl bZ.v.i
        return res
    }

    fun shr(res: Vec3ul, a: Vec3ul, bX: Int, bY: Int, bZ: Int): Vec3ul {
        res.x.v = a.x.v ushr bX
        res.y.v = a.y.v ushr bY
        res.z.v = a.z.v ushr bZ
        return res
    }

    fun shr(res: Vec3ul, a: Vec3ul, bX: Long, bY: Long, bZ: Long): Vec3ul {
        res.x.v = a.x.v ushr bX.i
        res.y.v = a.y.v ushr bY.i
        res.z.v = a.z.v ushr bZ.i
        return res
    }

    fun shr(res: Vec3ul, a: Vec3ul, bX: Ulong, bY: Ulong, bZ: Ulong): Vec3ul {
        res.x.v = a.x.v ushr bX.v.i
        res.y.v = a.y.v ushr bY.v.i
        res.z.v = a.z.v ushr bZ.v.i
        return res
    }

    fun inv(res: Vec3ul, a: Vec3ul): Vec3ul {
        res.x.v = a.x.v.inv()
        res.y.v = a.y.v.inv()
        res.z.v = a.z.v.inv()
        return res
    }
}


// -- Specific binary arithmetic operators --

infix operator fun Ulong.plus(b: Vec3ul) = plus(Vec3ul(), b, this, this, this)
fun Ulong.plus(b: Vec3ul, res: Vec3ul) = plus(res, b, this, this, this)
infix fun Ulong.plusAssign(b: Vec3ul) = plus(b, b, this, this, this)

infix operator fun Ulong.minus(b: Vec3ul) = minus(Vec3ul(), this, this, this, b)
fun Ulong.minus(b: Vec3ul, res: Vec3ul) = minus(res, this, this, this, b)
infix fun Ulong.minusAssign(b: Vec3ul) = minus(b, this, this, this, b)

infix operator fun Ulong.times(b: Vec3ul) = times(Vec3ul(), b, this, this, this)
fun Ulong.times(b: Vec3ul, res: Vec3ul) = times(res, b, this, this, this)
infix fun Ulong.timesAssign(b: Vec3ul) = times(b, b, this, this, this)

infix operator fun Ulong.div(b: Vec3ul) = div(Vec3ul(), this, this, this, b)
fun Ulong.divAssign(b: Vec3ul, res: Vec3ul) = div(res, this, this, this, b)
infix fun Ulong.divAssign(b: Vec3ul) = div(b, this, this, this, b)

infix operator fun Ulong.rem(b: Vec3ul) = rem(Vec3ul(), this, this, this, b)
fun Ulong.rem(b: Vec3ul, res: Vec3ul) = rem(res, this, this, this, b)
infix fun Ulong.remAssign(b: Vec3ul) = rem(b, this, this, this, b)


infix operator fun Long.plus(b: Vec3ul) = plus(Vec3ul(), b, this, this, this)
fun Long.plusAssign(b: Vec3ul, res: Vec3ul) = plus(res, b, this, this, this)
infix fun Long.plusAssign(b: Vec3ul) = plus(b, b, this, this, this)

infix operator fun Long.minus(b: Vec3ul) = minus(Vec3ul(), this, this, this, b)
fun Long.minus(b: Vec3ul, res: Vec3ul) = minus(res, this, this, this, b)
infix fun Long.minusAssign(b: Vec3ul) = minus(b, this, this, this, b)

infix operator fun Long.times(b: Vec3ul) = times(Vec3ul(), b, this, this, this)
fun Long.times(b: Vec3ul, res: Vec3ul) = times(res, b, this, this, this)
infix fun Long.timesAssign(b: Vec3ul) = times(b, b, this, this, this)

infix operator fun Long.div(b: Vec3ul) = div(Vec3ul(), this, this, this, b)
fun Long.div(b: Vec3ul, res: Vec3ul) = div(res, this, this, this, b)
infix fun Long.divAssign(b: Vec3ul) = div(b, this, this, this, b)

infix operator fun Long.rem(b: Vec3ul) = rem(Vec3ul(), this, this, this, b)
fun Long.rem(b: Vec3ul, res: Vec3ul) = rem(res, this, this, this, b)
infix fun Long.remAssign(b: Vec3ul) = rem(b, this, this, this, b)


// -- Generic binary arithmetic operators --

infix operator fun Number.plus(b: Vec3ul) = plus(Vec3ul(), b, this.L, this.L, this.L)
fun Number.plus(b: Vec3ul, res: Vec3ul) = plus(res, b, this.L, this.L, this.L)
infix fun Number.plusAssign(b: Vec3ul) = plus(b, b, this.L, this.L, this.L)

infix operator fun Number.minus(b: Vec3ul) = minus(Vec3ul(), this.L, this.L, this.L, b)
fun Number.minus(b: Vec3ul, res: Vec3ul) = minus(res, this.L, this.L, this.L, b)
infix fun Number.minusAssign(b: Vec3ul) = minus(b, this.L, this.L, this.L, b)

infix operator fun Number.times(b: Vec3ul) = times(Vec3ul(), b, this.L, this.L, this.L)
fun Number.times(b: Vec3ul, res: Vec3ul) = times(res, b, this.L, this.L, this.L)
infix fun Number.timesAssign(b: Vec3ul) = times(b, b, this.L, this.L, this.L)

infix operator fun Number.div(b: Vec3ul) = div(Vec3ul(), this.L, this.L, this.L, b)
fun Number.div(b: Vec3ul, res: Vec3ul) = div(res, this.L, this.L, this.L, b)
infix fun Number.divAssign(b: Vec3ul) = div(b, this.L, this.L, this.L, b)

infix operator fun Number.rem(b: Vec3ul) = rem(Vec3ul(), this.L, this.L, this.L, b)
fun Number.rem(b: Vec3ul, res: Vec3ul) = rem(res, this.L, this.L, this.L, b)
infix fun Number.remAssign(b: Vec3ul) = rem(b, this.L, this.L, this.L, b)