package vec._4.operators

import Ubyte
import and
import b
import i
import or
import shl
import shr
import udiv
import urem
import ushr
import vec._4.Vec4ub
import vec._4.Vec4ub.Companion.add
import vec._4.Vec4ub.Companion.div
import vec._4.Vec4ub.Companion.mul
import vec._4.Vec4ub.Companion.rem
import vec._4.Vec4ub.Companion.sub
import xor

/**
 * Created by GBarbieri on 08.11.2016.
 */

interface vec4ub_operators {

    fun add(res: Vec4ub, a: Vec4ub, bX: Ubyte, bY: Ubyte, bZ: Ubyte, bW: Ubyte): Vec4ub {
        res.x.v = (a.x.v + bX.v).b
        res.y.v = (a.y.v + bY.v).b
        res.z.v = (a.z.v + bZ.v).b
        res.w.v = (a.w.v + bW.v).b
        return res
    }

    fun add(res: Vec4ub, a: Vec4ub, bX: Byte, bY: Byte, bZ: Byte, bW: Byte): Vec4ub {
        res.x.v = (a.x.v + bX).b
        res.y.v = (a.y.v + bY).b
        res.z.v = (a.z.v + bZ).b
        res.w.v = (a.w.v + bW).b
        return res
    }

    fun add(res: Vec4ub, a: Vec4ub, bX: Int, bY: Int, bZ: Int, bW: Int): Vec4ub {
        res.x.v = (a.x.v + bX).b
        res.y.v = (a.y.v + bY).b
        res.z.v = (a.z.v + bZ).b
        res.w.v = (a.w.v + bW).b
        return res
    }

    fun sub(res: Vec4ub, a: Vec4ub, bX: Ubyte, bY: Ubyte, bZ: Ubyte, bW: Ubyte): Vec4ub {
        res.x.v = (a.x.v - bX.v).b
        res.y.v = (a.y.v - bY.v).b
        res.z.v = (a.z.v - bZ.v).b
        res.w.v = (a.w.v - bW.v).b
        return res
    }

    fun sub(res: Vec4ub, a: Vec4ub, bX: Byte, bY: Byte, bZ: Byte, bW: Byte): Vec4ub {
        res.x.v = (a.x.v - bX).b
        res.y.v = (a.y.v - bY).b
        res.z.v = (a.z.v - bZ).b
        res.w.v = (a.w.v - bW).b
        return res
    }

    fun sub(res: Vec4ub, a: Vec4ub, bX: Int, bY: Int, bZ: Int, bW: Int): Vec4ub {
        res.x.v = (a.x.v - bX).b
        res.y.v = (a.y.v - bY).b
        res.z.v = (a.z.v - bZ).b
        res.w.v = (a.w.v - bW).b
        return res
    }

    fun sub(res: Vec4ub, aX: Ubyte, aY: Ubyte, aZ: Ubyte, aW: Ubyte, b: Vec4ub): Vec4ub {
        res.x.v = (aX.v - b.x.v).b
        res.y.v = (aY.v - b.y.v).b
        res.z.v = (aZ.v - b.z.v).b
        res.w.v = (aW.v - b.w.v).b
        return res
    }

    fun sub(res: Vec4ub, aX: Byte, aY: Byte, aZ: Byte, aW: Byte, b: Vec4ub): Vec4ub {
        res.x.v = (aX - b.x.v).b
        res.y.v = (aY - b.y.v).b
        res.z.v = (aZ - b.z.v).b
        res.w.v = (aW - b.w.v).b
        return res
    }

    fun sub(res: Vec4ub, aX: Int, aY: Int, aZ: Int, aW: Int, b: Vec4ub): Vec4ub {
        res.x.v = (aX - b.x.v).b
        res.y.v = (aY - b.y.v).b
        res.z.v = (aZ - b.z.v).b
        res.w.v = (aW - b.w.v).b
        return res
    }

    fun mul(res: Vec4ub, a: Vec4ub, bX: Ubyte, bY: Ubyte, bZ: Ubyte, bW: Ubyte): Vec4ub {
        res.x.v = (a.x.v * bX.v).b
        res.y.v = (a.y.v * bY.v).b
        res.z.v = (a.z.v * bZ.v).b
        res.w.v = (a.w.v * bW.v).b
        return res
    }

    fun mul(res: Vec4ub, a: Vec4ub, bX: Byte, bY: Byte, bZ: Byte, bW: Byte): Vec4ub {
        res.x.v = (a.x.v * bX).b
        res.y.v = (a.y.v * bY).b
        res.z.v = (a.z.v * bZ).b
        res.w.v = (a.w.v * bW).b
        return res
    }

    fun mul(res: Vec4ub, a: Vec4ub, bX: Int, bY: Int, bZ: Int, bW: Int): Vec4ub {
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
        res.x.v = a.x.v shr bX
        res.y.v = a.y.v shr bY
        res.z.v = a.z.v shr bZ
        res.w.v = a.w.v shr bW
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

operator fun Ubyte.plus(b: Vec4ub) = add(Vec4ub(), b, this, this, this, this)
fun Ubyte.add(b: Vec4ub, res: Vec4ub = Vec4ub()) = add(res, b, this, this, this, this)
infix fun Ubyte.add_(b: Vec4ub) = add(b, b, this, this, this, this)

operator fun Ubyte.minus(b: Vec4ub) = sub(Vec4ub(), this, this, this, this, b)
fun Ubyte.sub(b: Vec4ub, res: Vec4ub = Vec4ub()) = sub(res, b, this, this, this, this)
infix fun Ubyte.sub_(b: Vec4ub) = sub(b, this, this, this, this, b)

operator fun Ubyte.times(b: Vec4ub) = mul(Vec4ub(), b, this, this, this, this)
fun Ubyte.mul(b: Vec4ub, res: Vec4ub = Vec4ub()) = mul(res, b, this, this, this, this)
infix fun Ubyte.mul_(b: Vec4ub) = mul(b, b, this, this, this, this)

operator fun Ubyte.div(b: Vec4ub) = div(Vec4ub(), this, this, this, this, b)
fun Ubyte.div(b: Vec4ub, res: Vec4ub) = div(res, b, this, this, this, this)
infix fun Ubyte.div_(b: Vec4ub) = div(b, this, this, this, this, b)

operator fun Ubyte.rem(b: Vec4ub) = rem(Vec4ub(), this, this, this, this, b)
fun Ubyte.rem(b: Vec4ub, res: Vec4ub) = rem(res, b, this, this, this, this)
infix fun Ubyte.rem_(b: Vec4ub) = rem(b, this, this, this, this, b)


operator fun Byte.plus(b: Vec4ub) = add(Vec4ub(), b, this, this, this, this)
fun Byte.add(b: Vec4ub, res: Vec4ub = Vec4ub()) = add(res, b, this, this, this, this)
infix fun Byte.add_(b: Vec4ub) = add(b, b, this, this, this, this)

operator fun Byte.minus(b: Vec4ub) = sub(Vec4ub(), this, this, this, this, b)
fun Byte.sub(b: Vec4ub, res: Vec4ub = Vec4ub()) = sub(res, b, this, this, this, this)
infix fun Byte.sub_(b: Vec4ub) = sub(b, this, this, this, this, b)

operator fun Byte.times(b: Vec4ub) = mul(Vec4ub(), b, this, this, this, this)
fun Byte.mul(b: Vec4ub, res: Vec4ub = Vec4ub()) = mul(res, b, this, this, this, this)
infix fun Byte.mul_(b: Vec4ub) = mul(b, b, this, this, this, this)

operator fun Byte.div(b: Vec4ub) = div(Vec4ub(), this, this, this, this, b)
fun Byte.div(b: Vec4ub, res: Vec4ub) = div(res, b, this, this, this, this)
infix fun Byte.div_(b: Vec4ub) = div(b, this, this, this, this, b)

operator fun Byte.rem(b: Vec4ub) = rem(Vec4ub(), this, this, this, this, b)
fun Byte.rem(b: Vec4ub, res: Vec4ub) = rem(res, b, this, this, this, this)
infix fun Byte.rem_(b: Vec4ub) = rem(b, this, this, this, this, b)


operator fun Int.plus(b: Vec4ub) = add(Vec4ub(), b, this, this, this, this)
fun Int.add(b: Vec4ub, res: Vec4ub = Vec4ub()) = add(res, b, this, this, this, this)
infix fun Int.add_(b: Vec4ub) = add(b, b, this, this, this, this)

operator fun Int.minus(b: Vec4ub) = sub(Vec4ub(), this, this, this, this, b)
fun Int.sub(b: Vec4ub, res: Vec4ub = Vec4ub()) = sub(res, b, this, this, this, this)
infix fun Int.sub_(b: Vec4ub) = sub(b, this, this, this, this, b)

operator fun Int.times(b: Vec4ub) = mul(Vec4ub(), b, this, this, this, this)
fun Int.mul(b: Vec4ub, res: Vec4ub = Vec4ub()) = mul(res, b, this, this, this, this)
infix fun Int.mul_(b: Vec4ub) = mul(b, b, this, this, this, this)

operator fun Int.div(b: Vec4ub) = div(Vec4ub(), this, this, this, this, b)
fun Int.div(b: Vec4ub, res: Vec4ub) = div(res, b, this, this, this, this)
infix fun Int.div_(b: Vec4ub) = div(b, this, this, this, this, b)

operator fun Int.rem(b: Vec4ub) = rem(Vec4ub(), this, this, this, this, b)
fun Int.rem(b: Vec4ub, res: Vec4ub) = rem(res, b, this, this, this, this)
infix fun Int.rem_(b: Vec4ub) = rem(b, this, this, this, this, b)


// -- Specific binary arithmetic operators --

operator fun Number.plus(b: Vec4ub) = add(Vec4ub(), b, this.i, this.i, this.i, this.i)
fun Number.add(b: Vec4ub, res: Vec4ub = Vec4ub()) = add(res, b, this.i, this.i, this.i, this.i)
infix fun Number.add_(b: Vec4ub) = add(b, b, this.i, this.i, this.i, this.i)

operator fun Number.minus(b: Vec4ub) = sub(Vec4ub(), this.i, this.i, this.i, this.i, b)
fun Number.sub(b: Vec4ub, res: Vec4ub = Vec4ub()) = sub(res, b, this.i, this.i, this.i, this.i)
infix fun Number.sub_(b: Vec4ub) = sub(b, this.i, this.i, this.i, this.i, b)

operator fun Number.times(b: Vec4ub) = mul(Vec4ub(), b, this.i, this.i, this.i, this.i)
fun Number.mul(b: Vec4ub, res: Vec4ub = Vec4ub()) = mul(res, b, this.i, this.i, this.i, this.i)
infix fun Number.mul_(b: Vec4ub) = mul(b, b, this.i, this.i, this.i, this.i)

operator fun Number.div(b: Vec4ub) = div(Vec4ub(), this.i, this.i, this.i, this.i, b)
fun Number.div(b: Vec4ub, res: Vec4ub) = div(res, b, this.i, this.i, this.i, this.i)
infix fun Number.div_(b: Vec4ub) = div(b, this.i, this.i, this.i, this.i, b)

operator fun Number.rem(b: Vec4ub) = rem(Vec4ub(), this.i, this.i, this.i, this.i, b)
fun Number.rem(b: Vec4ub, res: Vec4ub) = rem(res, b, this.i, this.i, this.i, this.i)
infix fun Number.rem_(b: Vec4ub) = rem(b, this.i, this.i, this.i, this.i, b)