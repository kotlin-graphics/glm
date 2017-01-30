package vec._3.operators

import Ubyte
import main.and
import main.b
import main.i
import main.or
import main.shl
import main.shr
import udiv
import urem
import ushr
import vec._3.Vec3ub
import vec._3.Vec3ub.Companion.add
import vec._3.Vec3ub.Companion.div
import vec._3.Vec3ub.Companion.mul
import vec._3.Vec3ub.Companion.rem
import vec._3.Vec3ub.Companion.sub
import main.xor

/**
 * Created by GBarbieri on 08.11.2016.
 */

interface vec3ub_operators {

    fun add(res: Vec3ub, a: Vec3ub, bX: Ubyte, bY: Ubyte, bZ: Ubyte): Vec3ub {
        res.x.v = (a.x.v + bX.v).b
        res.y.v = (a.y.v + bY.v).b
        res.z.v = (a.z.v + bZ.v).b
        return res
    }

    fun add(res: Vec3ub, a: Vec3ub, bX: Byte, bY: Byte, bZ: Byte): Vec3ub {
        res.x.v = (a.x.v + bX).b
        res.y.v = (a.y.v + bY).b
        res.z.v = (a.z.v + bZ).b
        return res
    }

    fun add(res: Vec3ub, a: Vec3ub, bX: Int, bY: Int, bZ: Int): Vec3ub {
        res.x.v = (a.x.v + bX).b
        res.y.v = (a.y.v + bY).b
        res.z.v = (a.z.v + bZ).b
        return res
    }

    fun sub(res: Vec3ub, a: Vec3ub, bX: Ubyte, bY: Ubyte, bZ: Ubyte): Vec3ub {
        res.x.v = (a.x.v - bX.v).b
        res.y.v = (a.y.v - bY.v).b
        res.z.v = (a.z.v - bZ.v).b
        return res
    }

    fun sub(res: Vec3ub, a: Vec3ub, bX: Byte, bY: Byte, bZ: Byte): Vec3ub {
        res.x.v = (a.x.v - bX).b
        res.y.v = (a.y.v - bY).b
        res.z.v = (a.z.v - bZ).b
        return res
    }

    fun sub(res: Vec3ub, a: Vec3ub, bX: Int, bY: Int, bZ: Int): Vec3ub {
        res.x.v = (a.x.v - bX).b
        res.y.v = (a.y.v - bY).b
        res.z.v = (a.z.v - bZ).b
        return res
    }

    fun sub(res: Vec3ub, aX: Ubyte, aY: Ubyte, aZ: Ubyte, b: Vec3ub): Vec3ub {
        res.x.v = (aX.v - b.x.v).b
        res.y.v = (aY.v - b.y.v).b
        res.z.v = (aZ.v - b.z.v).b
        return res
    }

    fun sub(res: Vec3ub, aX: Byte, aY: Byte, aZ: Byte, b: Vec3ub): Vec3ub {
        res.x.v = (aX - b.x.v).b
        res.y.v = (aY - b.y.v).b
        res.z.v = (aZ - b.z.v).b
        return res
    }

    fun sub(res: Vec3ub, aX: Int, aY: Int, aZ: Int, b: Vec3ub): Vec3ub {
        res.x.v = (aX - b.x.v).b
        res.y.v = (aY - b.y.v).b
        res.z.v = (aZ - b.z.v).b
        return res
    }

    fun mul(res: Vec3ub, a: Vec3ub, bX: Ubyte, bY: Ubyte, bZ: Ubyte): Vec3ub {
        res.x.v = (a.x.v * bX.v).b
        res.y.v = (a.y.v * bY.v).b
        res.z.v = (a.z.v * bZ.v).b
        return res
    }

    fun mul(res: Vec3ub, a: Vec3ub, bX: Byte, bY: Byte, bZ: Byte): Vec3ub {
        res.x.v = (a.x.v * bX).b
        res.y.v = (a.y.v * bY).b
        res.z.v = (a.z.v * bZ).b
        return res
    }

    fun mul(res: Vec3ub, a: Vec3ub, bX: Int, bY: Int, bZ: Int): Vec3ub {
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
        res.x.v = a.x.v shr bX
        res.y.v = a.y.v shr bY
        res.z.v = a.z.v shr bZ
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

operator fun Ubyte.plus(b: Vec3ub) = add(Vec3ub(), b, this, this, this)
fun Ubyte.add(b: Vec3ub, res: Vec3ub = Vec3ub()) = add(res, b, this, this, this)
infix fun Ubyte.add_(b: Vec3ub) = add(b, b, this, this, this)

operator fun Ubyte.minus(b: Vec3ub) = sub(Vec3ub(), this, this, this, b)
fun Ubyte.sub(b: Vec3ub, res: Vec3ub = Vec3ub()) = sub(res, b, this, this, this)
infix fun Ubyte.sub_(b: Vec3ub) = sub(b, this, this, this, b)

operator fun Ubyte.times(b: Vec3ub) = mul(Vec3ub(), b, this, this, this)
fun Ubyte.mul(b: Vec3ub, res: Vec3ub = Vec3ub()) = mul(res, b, this, this, this)
infix fun Ubyte.mul_(b: Vec3ub) = mul(b, b, this, this, this)

operator fun Ubyte.div(b: Vec3ub) = div(Vec3ub(), this, this, this, b)
fun Ubyte.div(b: Vec3ub, res: Vec3ub) = div(res, b, this, this, this)
infix fun Ubyte.div_(b: Vec3ub) = div(b, this, this, this, b)

operator fun Ubyte.rem(b: Vec3ub) = rem(Vec3ub(), this, this, this, b)
fun Ubyte.rem(b: Vec3ub, res: Vec3ub) = rem(res, b, this, this, this)
infix fun Ubyte.rem_(b: Vec3ub) = rem(b, this, this, this, b)


operator fun Byte.plus(b: Vec3ub) = add(Vec3ub(), b, this, this, this)
fun Byte.add(b: Vec3ub, res: Vec3ub = Vec3ub()) = add(res, b, this, this, this)
infix fun Byte.add_(b: Vec3ub) = add(b, b, this, this, this)

operator fun Byte.minus(b: Vec3ub) = sub(Vec3ub(), this, this, this, b)
fun Byte.sub(b: Vec3ub, res: Vec3ub = Vec3ub()) = sub(res, b, this, this, this)
infix fun Byte.sub_(b: Vec3ub) = sub(b, this, this, this, b)

operator fun Byte.times(b: Vec3ub) = mul(Vec3ub(), b, this, this, this)
fun Byte.mul(b: Vec3ub, res: Vec3ub = Vec3ub()) = mul(res, b, this, this, this)
infix fun Byte.mul_(b: Vec3ub) = mul(b, b, this, this, this)

operator fun Byte.div(b: Vec3ub) = div(Vec3ub(), this, this, this, b)
fun Byte.div(b: Vec3ub, res: Vec3ub) = div(res, b, this, this, this)
infix fun Byte.div_(b: Vec3ub) = div(b, this, this, this, b)

operator fun Byte.rem(b: Vec3ub) = rem(Vec3ub(), this, this, this, b)
fun Byte.rem(b: Vec3ub, res: Vec3ub) = rem(res, b, this, this, this)
infix fun Byte.rem_(b: Vec3ub) = rem(b, this, this, this, b)


operator fun Int.plus(b: Vec3ub) = add(Vec3ub(), b, this, this, this)
fun Int.add(b: Vec3ub, res: Vec3ub = Vec3ub()) = add(res, b, this, this, this)
infix fun Int.add_(b: Vec3ub) = add(b, b, this, this, this)

operator fun Int.minus(b: Vec3ub) = sub(Vec3ub(), this, this, this, b)
fun Int.sub(b: Vec3ub, res: Vec3ub = Vec3ub()) = sub(res, b, this, this, this)
infix fun Int.sub_(b: Vec3ub) = sub(b, this, this, this, b)

operator fun Int.times(b: Vec3ub) = mul(Vec3ub(), b, this, this, this)
fun Int.mul(b: Vec3ub, res: Vec3ub = Vec3ub()) = mul(res, b, this, this, this)
infix fun Int.mul_(b: Vec3ub) = mul(b, b, this, this, this)

operator fun Int.div(b: Vec3ub) = div(Vec3ub(), this, this, this, b)
fun Int.div(b: Vec3ub, res: Vec3ub) = div(res, b, this, this, this)
infix fun Int.div_(b: Vec3ub) = div(b, this, this, this, b)

operator fun Int.rem(b: Vec3ub) = rem(Vec3ub(), this, this, this, b)
fun Int.rem(b: Vec3ub, res: Vec3ub) = rem(res, b, this, this, this)
infix fun Int.rem_(b: Vec3ub) = rem(b, this, this, this, b)


// -- Specific binary arithmetic operators --

operator fun Number.plus(b: Vec3ub) = add(Vec3ub(), b, this.i, this.i, this.i)
fun Number.add(b: Vec3ub, res: Vec3ub = Vec3ub()) = add(res, b, this.i, this.i, this.i)
infix fun Number.add_(b: Vec3ub) = add(b, b, this.i, this.i, this.i)

operator fun Number.minus(b: Vec3ub) = sub(Vec3ub(), this.i, this.i, this.i, b)
fun Number.sub(b: Vec3ub, res: Vec3ub = Vec3ub()) = sub(res, b, this.i, this.i, this.i)
infix fun Number.sub_(b: Vec3ub) = sub(b, this.i, this.i, this.i, b)

operator fun Number.times(b: Vec3ub) = mul(Vec3ub(), b, this.i, this.i, this.i)
fun Number.mul(b: Vec3ub, res: Vec3ub = Vec3ub()) = mul(res, b, this.i, this.i, this.i)
infix fun Number.mul_(b: Vec3ub) = mul(b, b, this.i, this.i, this.i)

operator fun Number.div(b: Vec3ub) = div(Vec3ub(), this.i, this.i, this.i, b)
fun Number.div(b: Vec3ub, res: Vec3ub) = div(res, b, this.i, this.i, this.i)
infix fun Number.div_(b: Vec3ub) = div(b, this.i, this.i, this.i, b)

operator fun Number.rem(b: Vec3ub) = rem(Vec3ub(), this.i, this.i, this.i, b)
fun Number.rem(b: Vec3ub, res: Vec3ub) = rem(res, b, this.i, this.i, this.i)
infix fun Number.rem_(b: Vec3ub) = rem(b, this.i, this.i, this.i, b)