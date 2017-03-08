package vec._2.operators

import glm.*
import unsigned.*
import vec._2.Vec2ub
import vec._2.Vec2ub.Companion.add
import vec._2.Vec2ub.Companion.div
import vec._2.Vec2ub.Companion.mul
import vec._2.Vec2ub.Companion.rem
import vec._2.Vec2ub.Companion.sub
import kotlin.experimental.inv

/**
 * Created by GBarbieri on 08.11.2016.
 */

interface vec2ub_operators {

    fun add(res: Vec2ub, a: Vec2ub, bX: Ubyte, bY: Ubyte): Vec2ub {
        res.x.v = (a.x.v + bX.v).b
        res.y.v = (a.y.v + bY.v).b
        return res
    }

    fun add(res: Vec2ub, a: Vec2ub, bX: Byte, bY: Byte): Vec2ub {
        res.x.v = (a.x.v + bX).b
        res.y.v = (a.y.v + bY).b
        return res
    }

    fun add(res: Vec2ub, a: Vec2ub, bX: Int, bY: Int): Vec2ub {
        res.x.v = (a.x.v + bX).b
        res.y.v = (a.y.v + bY).b
        return res
    }

    fun sub(res: Vec2ub, a: Vec2ub, bX: Ubyte, bY: Ubyte): Vec2ub {
        res.x.v = (a.x.v - bX.v).b
        res.y.v = (a.y.v - bY.v).b
        return res
    }

    fun sub(res: Vec2ub, a: Vec2ub, bX: Byte, bY: Byte): Vec2ub {
        res.x.v = (a.x.v - bX).b
        res.y.v = (a.y.v - bY).b
        return res
    }

    fun sub(res: Vec2ub, a: Vec2ub, bX: Int, bY: Int): Vec2ub {
        res.x.v = (a.x.v - bX).b
        res.y.v = (a.y.v - bY).b
        return res
    }

    fun sub(res: Vec2ub, aX: Ubyte, aY: Ubyte, b: Vec2ub): Vec2ub {
        res.x.v = (aX.v - b.x.v).b
        res.y.v = (aY.v - b.y.v).b
        return res
    }

    fun sub(res: Vec2ub, aX: Byte, aY: Byte, b: Vec2ub): Vec2ub {
        res.x.v = (aX - b.x.v).b
        res.y.v = (aY - b.y.v).b
        return res
    }

    fun sub(res: Vec2ub, aX: Int, aY: Int, b: Vec2ub): Vec2ub {
        res.x.v = (aX - b.x.v).b
        res.y.v = (aY - b.y.v).b
        return res
    }

    fun mul(res: Vec2ub, a: Vec2ub, bX: Ubyte, bY: Ubyte): Vec2ub {
        res.x.v = (a.x.v * bX.v).b
        res.y.v = (a.y.v * bY.v).b
        return res
    }

    fun mul(res: Vec2ub, a: Vec2ub, bX: Byte, bY: Byte): Vec2ub {
        res.x.v = (a.x.v * bX).b
        res.y.v = (a.y.v * bY).b
        return res
    }

    fun mul(res: Vec2ub, a: Vec2ub, bX: Int, bY: Int): Vec2ub {
        res.x.v = (a.x.v * bX).b
        res.y.v = (a.y.v * bY).b
        return res
    }

    fun div(res: Vec2ub, a: Vec2ub, bX: Ubyte, bY: Ubyte): Vec2ub {
        res.x.v = a.x.v udiv bX.v
        res.y.v = a.y.v udiv bY.v
        return res
    }

    fun div(res: Vec2ub, a: Vec2ub, bX: Byte, bY: Byte): Vec2ub {
        res.x.v = a.x.v udiv bX
        res.y.v = a.y.v udiv bY
        return res
    }

    fun div(res: Vec2ub, a: Vec2ub, bX: Int, bY: Int): Vec2ub {
        res.x.v = a.x.v udiv bX
        res.y.v = a.y.v udiv bY
        return res
    }

    fun div(res: Vec2ub, aX: Ubyte, aY: Ubyte, b: Vec2ub): Vec2ub {
        res.x.v = aX.v udiv b.x.v
        res.y.v = aY.v udiv b.y.v
        return res
    }

    fun div(res: Vec2ub, aX: Byte, aY: Byte, b: Vec2ub): Vec2ub {
        res.x.v = aX udiv b.x.v
        res.y.v = aY udiv b.y.v
        return res
    }

    fun div(res: Vec2ub, aX: Int, aY: Int, b: Vec2ub): Vec2ub {
        res.x.v = (aX udiv b.x.v).b
        res.y.v = (aY udiv b.y.v).b
        return res
    }

    fun rem(res: Vec2ub, a: Vec2ub, bX: Ubyte, bY: Ubyte): Vec2ub {
        res.x.v = a.x.v urem bX.v
        res.y.v = a.y.v urem bY.v
        return res
    }

    fun rem(res: Vec2ub, a: Vec2ub, bX: Byte, bY: Byte): Vec2ub {
        res.x.v = a.x.v urem bX
        res.y.v = a.y.v urem bY
        return res
    }

    fun rem(res: Vec2ub, a: Vec2ub, bX: Int, bY: Int): Vec2ub {
        res.x.v = a.x.v urem bX
        res.y.v = a.y.v urem bY
        return res
    }

    fun rem(res: Vec2ub, aX: Ubyte, aY: Ubyte, b: Vec2ub): Vec2ub {
        res.x.v = aX.v urem b.x.v
        res.y.v = aY.v urem b.y.v
        return res
    }

    fun rem(res: Vec2ub, aX: Byte, aY: Byte, b: Vec2ub): Vec2ub {
        res.x.v = aX urem b.x.v
        res.y.v = aY urem b.y.v
        return res
    }

    fun rem(res: Vec2ub, aX: Int, aY: Int, b: Vec2ub): Vec2ub {
        res.x.v = (aX urem b.x.v).b
        res.y.v = (aY urem b.y.v).b
        return res
    }

    fun and(res: Vec2ub, a: Vec2ub, bX: Ubyte, bY: Ubyte): Vec2ub {
        res.x.v = a.x.v and bX.v
        res.y.v = a.y.v and bY.v
        return res
    }

    fun and(res: Vec2ub, a: Vec2ub, bX: Byte, bY: Byte): Vec2ub {
        res.x.v = a.x.v and bX
        res.y.v = a.y.v and bY
        return res
    }

    fun and(res: Vec2ub, a: Vec2ub, bX: Int, bY: Int): Vec2ub {
        res.x.v = a.x.v and bX
        res.y.v = a.y.v and bY
        return res
    }

    fun or(res: Vec2ub, a: Vec2ub, bX: Ubyte, bY: Ubyte): Vec2ub {
        res.x.v = a.x.v or bX
        res.y.v = a.y.v or bY
        return res
    }

    fun or(res: Vec2ub, a: Vec2ub, bX: Byte, bY: Byte): Vec2ub {
        res.x.v = a.x.v or bX
        res.y.v = a.y.v or bY
        return res
    }

    fun or(res: Vec2ub, a: Vec2ub, bX: Int, bY: Int): Vec2ub {
        res.x.v = a.x.v or bX
        res.y.v = a.y.v or bY
        return res
    }

    fun xor(res: Vec2ub, a: Vec2ub, bX: Ubyte, bY: Ubyte): Vec2ub {
        res.x.v = a.x.v xor bX
        res.y.v = a.y.v xor bY
        return res
    }

    fun xor(res: Vec2ub, a: Vec2ub, bX: Byte, bY: Byte): Vec2ub {
        res.x.v = a.x.v xor bX
        res.y.v = a.y.v xor bY
        return res
    }

    fun xor(res: Vec2ub, a: Vec2ub, bX: Int, bY: Int): Vec2ub {
        res.x.v = a.x.v xor bX
        res.y.v = a.y.v xor bY
        return res
    }

    fun shl(res: Vec2ub, a: Vec2ub, bX: Ubyte, bY: Ubyte): Vec2ub {
        res.x.v = a.x.v shl bX
        res.y.v = a.y.v shl bY
        return res
    }

    fun shl(res: Vec2ub, a: Vec2ub, bX: Byte, bY: Byte): Vec2ub {
        res.x.v = a.x.v shl bX
        res.y.v = a.y.v shl bY
        return res
    }

    fun shl(res: Vec2ub, a: Vec2ub, bX: Int, bY: Int): Vec2ub {
        res.x.v = a.x.v shl bX
        res.y.v = a.y.v shl bY
        return res
    }

    fun shr(res: Vec2ub, a: Vec2ub, bX: Ubyte, bY: Ubyte): Vec2ub {
        res.x.v = a.x.v ushr bX
        res.y.v = a.y.v ushr bY
        return res
    }

    fun shr(res: Vec2ub, a: Vec2ub, bX: Byte, bY: Byte): Vec2ub {
        res.x.v = a.x.v ushr bX
        res.y.v = a.y.v ushr bY
        return res
    }

    fun shr(res: Vec2ub, a: Vec2ub, bX: Int, bY: Int): Vec2ub {
        res.x.v = a.x.v ushr bX
        res.y.v = a.y.v ushr bY
        return res
    }

    fun inv(res: Vec2ub, a: Vec2ub): Vec2ub {
        res.x.v = a.x.v.inv()
        res.y.v = a.y.v.inv()
        return res
    }
}


// -- Specific binary arithmetic operators --

operator fun Ubyte.plus(b: Vec2ub) = add(Vec2ub(), b, this, this)
fun Ubyte.add(b: Vec2ub, res: Vec2ub = Vec2ub()) = add(res, b, this, this)
infix fun Ubyte.add_(b: Vec2ub) = add(b, b, this, this)

operator fun Ubyte.minus(b: Vec2ub) = sub(Vec2ub(), this, this, b)
fun Ubyte.sub(b: Vec2ub, res: Vec2ub = Vec2ub()) = sub(res, b, this, this)
infix fun Ubyte.sub_(b: Vec2ub) = sub(b, this, this, b)

operator fun Ubyte.times(b: Vec2ub) = mul(Vec2ub(), b, this, this)
fun Ubyte.mul(b: Vec2ub, res: Vec2ub = Vec2ub()) = mul(res, b, this, this)
infix fun Ubyte.mul_(b: Vec2ub) = mul(b, b, this, this)

operator fun Ubyte.div(b: Vec2ub) = div(Vec2ub(), this, this, b)
fun Ubyte.div(b: Vec2ub, res: Vec2ub) = div(res, b, this, this)
infix fun Ubyte.div_(b: Vec2ub) = div(b, this, this, b)

operator fun Ubyte.rem(b: Vec2ub) = rem(Vec2ub(), this, this, b)
fun Ubyte.rem(b: Vec2ub, res: Vec2ub) = rem(res, b, this, this)
infix fun Ubyte.rem_(b: Vec2ub) = rem(b, this, this, b)


operator fun Byte.plus(b: Vec2ub) = add(Vec2ub(), b, this, this)
fun Byte.add(b: Vec2ub, res: Vec2ub = Vec2ub()) = add(res, b, this, this)
infix fun Byte.add_(b: Vec2ub) = add(b, b, this, this)

operator fun Byte.minus(b: Vec2ub) = sub(Vec2ub(), this, this, b)
fun Byte.sub(b: Vec2ub, res: Vec2ub = Vec2ub()) = sub(res, b, this, this)
infix fun Byte.sub_(b: Vec2ub) = sub(b, this, this, b)

operator fun Byte.times(b: Vec2ub) = mul(Vec2ub(), b, this, this)
fun Byte.mul(b: Vec2ub, res: Vec2ub = Vec2ub()) = mul(res, b, this, this)
infix fun Byte.mul_(b: Vec2ub) = mul(b, b, this, this)

operator fun Byte.div(b: Vec2ub) = div(Vec2ub(), this, this, b)
fun Byte.div(b: Vec2ub, res: Vec2ub) = div(res, b, this, this)
infix fun Byte.div_(b: Vec2ub) = div(b, this, this, b)

operator fun Byte.rem(b: Vec2ub) = rem(Vec2ub(), this, this, b)
fun Byte.rem(b: Vec2ub, res: Vec2ub) = rem(res, b, this, this)
infix fun Byte.rem_(b: Vec2ub) = rem(b, this, this, b)


operator fun Int.plus(b: Vec2ub) = add(Vec2ub(), b, this, this)
fun Int.add(b: Vec2ub, res: Vec2ub = Vec2ub()) = add(res, b, this, this)
infix fun Int.add_(b: Vec2ub) = add(b, b, this, this)

operator fun Int.minus(b: Vec2ub) = sub(Vec2ub(), this, this, b)
fun Int.sub(b: Vec2ub, res: Vec2ub = Vec2ub()) = sub(res, b, this, this)
infix fun Int.sub_(b: Vec2ub) = sub(b, this, this, b)

operator fun Int.times(b: Vec2ub) = mul(Vec2ub(), b, this, this)
fun Int.mul(b: Vec2ub, res: Vec2ub = Vec2ub()) = mul(res, b, this, this)
infix fun Int.mul_(b: Vec2ub) = mul(b, b, this, this)

operator fun Int.div(b: Vec2ub) = div(Vec2ub(), this, this, b)
fun Int.div(b: Vec2ub, res: Vec2ub) = div(res, b, this, this)
infix fun Int.div_(b: Vec2ub) = div(b, this, this, b)

operator fun Int.rem(b: Vec2ub) = rem(Vec2ub(), this, this, b)
fun Int.rem(b: Vec2ub, res: Vec2ub) = rem(res, b, this, this)
infix fun Int.rem_(b: Vec2ub) = rem(b, this, this, b)


// -- Specific binary arithmetic operators --

operator fun Number.plus(b: Vec2ub) = add(Vec2ub(), b, this.i, this.i)
fun Number.add(b: Vec2ub, res: Vec2ub = Vec2ub()) = add(res, b, this.i, this.i)
infix fun Number.add_(b: Vec2ub) = add(b, b, this.i, this.i)

operator fun Number.minus(b: Vec2ub) = sub(Vec2ub(), this.i, this.i, b)
fun Number.sub(b: Vec2ub, res: Vec2ub = Vec2ub()) = sub(res, b, this.i, this.i)
infix fun Number.sub_(b: Vec2ub) = sub(b, this.i, this.i, b)

operator fun Number.times(b: Vec2ub) = mul(Vec2ub(), b, this.i, this.i)
fun Number.mul(b: Vec2ub, res: Vec2ub = Vec2ub()) = mul(res, b, this.i, this.i)
infix fun Number.mul_(b: Vec2ub) = mul(b, b, this.i, this.i)

operator fun Number.div(b: Vec2ub) = div(Vec2ub(), this.i, this.i, b)
fun Number.div(b: Vec2ub, res: Vec2ub) = div(res, b, this.i, this.i)
infix fun Number.div_(b: Vec2ub) = div(b, this.i, this.i, b)

operator fun Number.rem(b: Vec2ub) = rem(Vec2ub(), this.i, this.i, b)
fun Number.rem(b: Vec2ub, res: Vec2ub) = rem(res, b, this.i, this.i)
infix fun Number.rem_(b: Vec2ub) = rem(b, this.i, this.i, b)