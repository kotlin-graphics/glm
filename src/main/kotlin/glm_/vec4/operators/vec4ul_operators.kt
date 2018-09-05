package glm_.vec4.operators

import glm_.*
import glm_.vec4.Vec4ul
import glm_.vec4.Vec4ul.Companion.div
import glm_.vec4.Vec4ul.Companion.minus
import glm_.vec4.Vec4ul.Companion.plus
import glm_.vec4.Vec4ul.Companion.rem
import glm_.vec4.Vec4ul.Companion.times
import unsigned.udiv
import unsigned.Ulong
import unsigned.udiv
import unsigned.urem
import unsigned.urem

/**
 * Created by elect on 09/11/16.
 */
interface vec4ul_operators {


    fun plus(res: Vec4ul, a: Vec4ul, bX: Int, bY: Int, bZ: Int, bW: Int): Vec4ul {
        res.x.v = a.x.v + bX
        res.y.v = a.y.v + bY
        res.z.v = a.z.v + bZ
        res.w.v = a.w.v + bW
        return res
    }

    fun plus(res: Vec4ul, a: Vec4ul, bX: Ulong, bY: Ulong, bZ: Ulong, bW: Ulong): Vec4ul {
        res.x.v = a.x.v + bX.v
        res.y.v = a.y.v + bY.v
        res.z.v = a.z.v + bZ.v
        res.w.v = a.w.v + bW.v
        return res
    }

    fun plus(res: Vec4ul, a: Vec4ul, bX: Long, bY: Long, bZ: Long, bW: Long): Vec4ul {
        res.x.v = a.x.v + bX
        res.y.v = a.y.v + bY
        res.z.v = a.z.v + bZ
        res.w.v = a.w.v + bW
        return res
    }

    fun minus(res: Vec4ul, a: Vec4ul, bX: Int, bY: Int, bZ: Int, bW: Int): Vec4ul {
        res.x.v = a.x.v - bX
        res.y.v = a.y.v - bY
        res.z.v = a.z.v - bZ
        res.w.v = a.w.v - bW
        return res
    }

    fun minus(res: Vec4ul, a: Vec4ul, bX: Ulong, bY: Ulong, bZ: Ulong, bW: Ulong): Vec4ul {
        res.x.v = a.x.v - bX.v
        res.y.v = a.y.v - bY.v
        res.z.v = a.z.v - bZ.v
        res.w.v = a.w.v - bW.v
        return res
    }

    fun minus(res: Vec4ul, a: Vec4ul, bX: Long, bY: Long, bZ: Long, bW: Long): Vec4ul {
        res.x.v = a.x.v - bX
        res.y.v = a.y.v - bY
        res.z.v = a.z.v - bZ
        res.w.v = a.w.v - bW
        return res
    }

    fun minus(res: Vec4ul, aX: Int, aY: Int, aZ: Int, aW: Int, b: Vec4ul): Vec4ul {
        res.x.v = aX - b.x.v
        res.y.v = aY - b.y.v
        res.z.v = aZ - b.z.v
        res.w.v = aW - b.w.v
        return res
    }

    fun minus(res: Vec4ul, aX: Ulong, aY: Ulong, aZ: Ulong, aW: Ulong, b: Vec4ul): Vec4ul {
        res.x.v = aX.v - b.x.v
        res.y.v = aY.v - b.y.v
        res.z.v = aZ.v - b.z.v
        res.w.v = aW.v - b.w.v
        return res
    }

    fun minus(res: Vec4ul, aX: Long, aY: Long, aZ: Long, aW: Long, b: Vec4ul): Vec4ul {
        res.x.v = aX - b.x.v
        res.y.v = aY - b.y.v
        res.z.v = aZ - b.z.v
        res.w.v = aW - b.w.v
        return res
    }

    fun times(res: Vec4ul, a: Vec4ul, bX: Int, bY: Int, bZ: Int, bW: Int): Vec4ul {
        res.x.v = a.x.v * bX
        res.y.v = a.y.v * bY
        res.z.v = a.z.v * bZ
        res.w.v = a.w.v * bW
        return res
    }

    fun times(res: Vec4ul, a: Vec4ul, bX: Ulong, bY: Ulong, bZ: Ulong, bW: Ulong): Vec4ul {
        res.x.v = a.x.v * bX.v
        res.y.v = a.y.v * bY.v
        res.z.v = a.z.v * bZ.v
        res.w.v = a.w.v * bW.v
        return res
    }

    fun times(res: Vec4ul, a: Vec4ul, bX: Long, bY: Long, bZ: Long, bW: Long): Vec4ul {
        res.x.v = a.x.v * bX
        res.y.v = a.y.v * bY
        res.z.v = a.z.v * bZ
        res.w.v = a.w.v * bW
        return res
    }

    fun div(res: Vec4ul, a: Vec4ul, bX: Int, bY: Int, bZ: Int, bW: Int): Vec4ul {
        res.x.v = a.x.v udiv bX
        res.y.v = a.y.v udiv bY
        res.z.v = a.z.v udiv bZ
        res.w.v = a.w.v udiv bW
        return res
    }

    fun div(res: Vec4ul, a: Vec4ul, bX: Ulong, bY: Ulong, bZ: Ulong, bW: Ulong): Vec4ul {
        res.x.v = a.x.v udiv bX.v
        res.y.v = a.y.v udiv bY.v
        res.z.v = a.z.v udiv bZ.v
        res.w.v = a.w.v udiv bW.v
        return res
    }

    fun div(res: Vec4ul, a: Vec4ul, bX: Long, bY: Long, bZ: Long, bW: Long): Vec4ul {
        res.x.v = a.x.v udiv bX
        res.y.v = a.y.v udiv bY
        res.z.v = a.z.v udiv bZ
        res.w.v = a.w.v udiv bW
        return res
    }

    fun div(res: Vec4ul, aX: Int, aY: Int, aZ: Int, aW: Int, b: Vec4ul): Vec4ul {
        res.x.v = (aX udiv b.x.v).L
        res.y.v = (aY udiv b.y.v).L
        res.z.v = (aZ udiv b.z.v).L
        res.w.v = (aW udiv b.w.v).L
        return res
    }

    fun div(res: Vec4ul, aX: Ulong, aY: Ulong, aZ: Ulong, aW: Ulong, b: Vec4ul): Vec4ul {
        res.x.v = aX.v udiv b.x.v
        res.y.v = aY.v udiv b.y.v
        res.z.v = aZ.v udiv b.z.v
        res.w.v = aW.v udiv b.w.v
        return res
    }

    fun div(res: Vec4ul, aX: Long, aY: Long, aZ: Long, aW: Long, b: Vec4ul): Vec4ul {
        res.x.v = aX udiv b.x.v
        res.y.v = aY udiv b.y.v
        res.z.v = aZ udiv b.z.v
        res.w.v = aW udiv b.w.v
        return res
    }

    fun rem(res: Vec4ul, a: Vec4ul, bX: Int, bY: Int, bZ: Int, bW: Int): Vec4ul {
        res.x.v = a.x.v urem bX
        res.y.v = a.y.v urem bY
        res.z.v = a.z.v urem bZ
        res.w.v = a.w.v urem bW
        return res
    }

    fun rem(res: Vec4ul, a: Vec4ul, bX: Ulong, bY: Ulong, bZ: Ulong, bW: Ulong): Vec4ul {
        res.x.v = a.x.v urem bX.v
        res.y.v = a.y.v urem bY.v
        res.z.v = a.z.v urem bZ.v
        res.w.v = a.w.v urem bW.v
        return res
    }

    fun rem(res: Vec4ul, a: Vec4ul, bX: Long, bY: Long, bZ: Long, bW: Long): Vec4ul {
        res.x.v = a.x.v urem bX
        res.y.v = a.y.v urem bY
        res.z.v = a.z.v urem bZ
        res.w.v = a.w.v urem bW
        return res
    }

    fun rem(res: Vec4ul, aX: Int, aY: Int, aZ: Int, aW: Int, b: Vec4ul): Vec4ul {
        res.x.v = (aX urem b.x.v).L
        res.y.v = (aY urem b.y.v).L
        res.z.v = (aZ urem b.z.v).L
        res.w.v = (aW urem b.w.v).L
        return res
    }

    fun rem(res: Vec4ul, aX: Ulong, aY: Ulong, aZ: Ulong, aW: Ulong, b: Vec4ul): Vec4ul {
        res.x.v = aX.v urem b.x.v
        res.y.v = aY.v urem b.y.v
        res.z.v = aZ.v urem b.z.v
        res.w.v = aW.v urem b.w.v
        return res
    }

    fun rem(res: Vec4ul, aX: Long, aY: Long, aZ: Long, aW: Long, b: Vec4ul): Vec4ul {
        res.x.v = aX urem b.x.v
        res.y.v = aY urem b.y.v
        res.z.v = aZ urem b.z.v
        res.w.v = aW urem b.w.v
        return res
    }

    fun and(res: Vec4ul, a: Vec4ul, bX: Int, bY: Int, bZ: Int, bW: Int): Vec4ul {
        res.x.v = a.x.v and bX
        res.y.v = a.y.v and bY
        res.z.v = a.z.v and bZ
        res.w.v = a.w.v and bW
        return res
    }

    fun and(res: Vec4ul, a: Vec4ul, bX: Ulong, bY: Ulong, bZ: Ulong, bW: Ulong): Vec4ul {
        res.x.v = a.x.v and bX.v
        res.y.v = a.y.v and bY.v
        res.z.v = a.z.v and bZ.v
        res.w.v = a.w.v and bW.v
        return res
    }

    fun and(res: Vec4ul, a: Vec4ul, bX: Long, bY: Long, bZ: Long, bW: Long): Vec4ul {
        res.x.v = a.x.v and bX
        res.y.v = a.y.v and bY
        res.z.v = a.z.v and bZ
        res.w.v = a.w.v and bW
        return res
    }

    fun or(res: Vec4ul, a: Vec4ul, bX: Int, bY: Int, bZ: Int, bW: Int): Vec4ul {
        res.x.v = a.x.v or bX
        res.y.v = a.y.v or bY
        res.z.v = a.z.v or bZ
        res.w.v = a.w.v or bW
        return res
    }

    fun or(res: Vec4ul, a: Vec4ul, bX: Ulong, bY: Ulong, bZ: Ulong, bW: Ulong): Vec4ul {
        res.x.v = a.x.v or bX.v
        res.y.v = a.y.v or bY.v
        res.z.v = a.z.v or bZ.v
        res.w.v = a.w.v or bW.v
        return res
    }

    fun or(res: Vec4ul, a: Vec4ul, bX: Long, bY: Long, bZ: Long, bW: Long): Vec4ul {
        res.x.v = a.x.v or bX
        res.y.v = a.y.v or bY
        res.z.v = a.z.v or bZ
        res.w.v = a.w.v or bW
        return res
    }

    fun xor(res: Vec4ul, a: Vec4ul, bX: Int, bY: Int, bZ: Int, bW: Int): Vec4ul {
        res.x.v = a.x.v xor bX
        res.y.v = a.y.v xor bY
        res.z.v = a.z.v xor bZ
        res.w.v = a.w.v xor bW
        return res
    }

    fun xor(res: Vec4ul, a: Vec4ul, bX: Ulong, bY: Ulong, bZ: Ulong, bW: Ulong): Vec4ul {
        res.x.v = a.x.v xor bX.v
        res.y.v = a.y.v xor bY.v
        res.z.v = a.z.v xor bZ.v
        res.w.v = a.w.v xor bW.v
        return res
    }

    fun xor(res: Vec4ul, a: Vec4ul, bX: Long, bY: Long, bZ: Long, bW: Long): Vec4ul {
        res.x.v = a.x.v xor bX
        res.y.v = a.y.v xor bY
        res.z.v = a.z.v xor bZ
        res.w.v = a.w.v xor bW
        return res
    }


    fun shl(res: Vec4ul, a: Vec4ul, bX: Int, bY: Int, bZ: Int, bW: Int): Vec4ul {
        res.x.v = a.x.v shl bX
        res.y.v = a.y.v shl bY
        res.z.v = a.z.v shl bZ
        res.w.v = a.w.v shl bW
        return res
    }

    fun shl(res: Vec4ul, a: Vec4ul, bX: Ulong, bY: Ulong, bZ: Ulong, bW: Ulong): Vec4ul {
        res.x.v = a.x.v shl bX.v.i
        res.y.v = a.y.v shl bY.v.i
        res.z.v = a.z.v shl bZ.v.i
        res.w.v = a.w.v shl bW.v.i
        return res
    }

    fun shl(res: Vec4ul, a: Vec4ul, bX: Long, bY: Long, bZ: Long, bW: Long): Vec4ul {
        res.x.v = a.x.v shl bX.i
        res.y.v = a.y.v shl bY.i
        res.z.v = a.z.v shl bZ.i
        res.w.v = a.w.v shl bW.i
        return res
    }

    fun shr(res: Vec4ul, a: Vec4ul, bX: Int, bY: Int, bZ: Int, bW: Int): Vec4ul {
        res.x.v = a.x.v ushr bX
        res.y.v = a.y.v ushr bY
        res.z.v = a.z.v ushr bZ
        res.w.v = a.w.v ushr bW
        return res
    }

    fun shr(res: Vec4ul, a: Vec4ul, bX: Ulong, bY: Ulong, bZ: Ulong, bW: Ulong): Vec4ul {
        res.x.v = a.x.v ushr bX.v.i
        res.y.v = a.y.v ushr bY.v.i
        res.z.v = a.z.v ushr bZ.v.i
        res.w.v = a.w.v ushr bW.v.i
        return res
    }

    fun shr(res: Vec4ul, a: Vec4ul, bX: Long, bY: Long, bZ: Long, bW: Long): Vec4ul {
        res.x.v = a.x.v ushr bX.i
        res.y.v = a.y.v ushr bY.i
        res.z.v = a.z.v ushr bZ.i
        res.w.v = a.w.v ushr bW.i
        return res
    }


    fun inv(res: Vec4ul, a: Vec4ul): Vec4ul {
        res.x.v = a.x.v.inv()
        res.y.v = a.y.v.inv()
        res.z.v = a.z.v.inv()
        res.w.v = a.w.v.inv()
        return res
    }
}


// -- Specific binary arithmetic operators --

infix operator fun Ulong.plus(b: Vec4ul) = plus(Vec4ul(), b, this, this, this, this)
fun Ulong.plus(b: Vec4ul, res: Vec4ul) = plus(res, b, this, this, this, this)
infix fun Ulong.plusAssign(b: Vec4ul) = plus(b, b, this, this, this, this)

infix operator fun Ulong.minus(b: Vec4ul) = minus(Vec4ul(), this, this, this, this, b)
fun Ulong.minus(b: Vec4ul, res: Vec4ul) = minus(res, this, this, this, this, b)
infix fun Ulong.minusAssign(b: Vec4ul) = minus(b, this, this, this, this, b)

infix operator fun Ulong.times(b: Vec4ul) = times(Vec4ul(), b, this, this, this, this)
fun Ulong.times(b: Vec4ul, res: Vec4ul) = times(res, b, this, this, this, this)
infix fun Ulong.timesAssign(b: Vec4ul) = times(b, b, this, this, this, this)

infix operator fun Ulong.div(b: Vec4ul) = div(Vec4ul(), this, this, this, this, b)
fun Ulong.div(b: Vec4ul, res: Vec4ul) = div(res, this, this, this, this, b)
infix fun Ulong.divAssign(b: Vec4ul) = div(b, this, this, this, this, b)

infix operator fun Ulong.rem(b: Vec4ul) = rem(Vec4ul(), this, this, this, this, b)
fun Ulong.rem(b: Vec4ul, res: Vec4ul) = rem(res, this, this, this, this, b)
infix fun Ulong.remAssign(b: Vec4ul) = rem(b, this, this, this, this, b)


infix operator fun Long.plus(b: Vec4ul) = plus(Vec4ul(), b, this, this, this, this)
fun Long.plus(b: Vec4ul, res: Vec4ul) = plus(res, b, this, this, this, this)
infix fun Long.plusAssign(b: Vec4ul) = plus(b, b, this, this, this, this)

infix operator fun Long.minus(b: Vec4ul) = minus(Vec4ul(), this, this, this, this, b)
fun Long.minus(b: Vec4ul, res: Vec4ul) = minus(res, this, this, this, this, b)
infix fun Long.minusAssign(b: Vec4ul) = minus(b, this, this, this, this, b)

infix operator fun Long.times(b: Vec4ul) = times(Vec4ul(), b, this, this, this, this)
fun Long.times(b: Vec4ul, res: Vec4ul) = times(res, b, this, this, this, this)
infix fun Long.timesAssign(b: Vec4ul) = times(b, b, this, this, this, this)

infix operator fun Long.div(b: Vec4ul) = div(Vec4ul(), this, this, this, this, b)
fun Long.div(b: Vec4ul, res: Vec4ul) = div(res, this, this, this, this, b)
infix fun Long.divAssign(b: Vec4ul) = div(b, this, this, this, this, b)

infix operator fun Long.rem(b: Vec4ul) = rem(Vec4ul(), this, this, this, this, b)
fun Long.rem(b: Vec4ul, res: Vec4ul) = rem(res, this, this, this, this, b)
infix fun Long.remAssign(b: Vec4ul) = rem(b, this, this, this, this, b)


// -- Generic binary arithmetic operators --

infix operator fun Number.plus(b: Vec4ul) = plus(Vec4ul(), b, this.L, this.L, this.L, this.L)
fun Number.plus(b: Vec4ul, res: Vec4ul) = plus(res, b, this.L, this.L, this.L, this.L)
infix fun Number.plusAssign(b: Vec4ul) = plus(b, b, this.L, this.L, this.L, this.L)

infix operator fun Number.minus(b: Vec4ul) = minus(Vec4ul(), this.L, this.L, this.L, this.L, b)
fun Number.minus(b: Vec4ul, res: Vec4ul) = minus(res, this.L, this.L, this.L, this.L, b)
infix fun Number.minusAssign(b: Vec4ul) = minus(b, this.L, this.L, this.L, this.L, b)

infix operator fun Number.times(b: Vec4ul) = times(Vec4ul(), b, this.L, this.L, this.L, this.L)
fun Number.timesAssign(b: Vec4ul, res: Vec4ul) = times(res, b, this.L, this.L, this.L, this.L)
infix fun Number.timesAssign(b: Vec4ul) = times(b, b, this.L, this.L, this.L, this.L)

infix operator fun Number.div(b: Vec4ul) = div(Vec4ul(), this.L, this.L, this.L, this.L, b)
fun Number.div(b: Vec4ul, res: Vec4ul) = div(res, this.L, this.L, this.L, this.L, b)
infix fun Number.divAssign(b: Vec4ul) = div(b, this.L, this.L, this.L, this.L, b)

infix operator fun Number.rem(b: Vec4ul) = rem(Vec4ul(), this.L, this.L, this.L, this.L, b)
fun Number.rem(b: Vec4ul, res: Vec4ul) = rem(res, this.L, this.L, this.L, this.L, b)
infix fun Number.remAssign(b: Vec4ul) = rem(b, this.L, this.L, this.L, this.L, b)