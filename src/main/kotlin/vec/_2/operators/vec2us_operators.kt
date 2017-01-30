package vec._2.operators

import Ushort
import main.and
import main.i
import main.or
import main.s
import main.shl
import udiv
import urem
import ushr
import vec._2.Vec2us
import vec._2.Vec2us.Companion.add
import vec._2.Vec2us.Companion.div
import vec._2.Vec2us.Companion.mul
import vec._2.Vec2us.Companion.rem
import vec._2.Vec2us.Companion.sub
import main.xor

/**
 * Created by elect on 09/11/16.
 */

interface vec2us_operators {

    fun add(res: Vec2us, a: Vec2us, bX: Ushort, bY: Ushort): Vec2us {
        res.x.v = (a.x.v + bX.v).s
        res.y.v = (a.y.v + bY.v).s
        return res
    }

    fun add(res: Vec2us, a: Vec2us, bX: Short, bY: Short): Vec2us {
        res.x.v = (a.x.v + bX).s
        res.y.v = (a.y.v + bY).s
        return res
    }

    fun add(res: Vec2us, a: Vec2us, bX: Int, bY: Int): Vec2us {
        res.x.v = (a.x.v + bX).s
        res.y.v = (a.y.v + bY).s
        return res
    }

    fun sub(res: Vec2us, a: Vec2us, bX: Ushort, bY: Ushort): Vec2us {
        res.x.v = (a.x.v - bX.v).s
        res.y.v = (a.y.v - bY.v).s
        return res
    }

    fun sub(res: Vec2us, a: Vec2us, bX: Short, bY: Short): Vec2us {
        res.x.v = (a.x.v - bX).s
        res.y.v = (a.y.v - bY).s
        return res
    }

    fun sub(res: Vec2us, a: Vec2us, bX: Int, bY: Int): Vec2us {
        res.x.v = (a.x.v - bX).s
        res.y.v = (a.y.v - bY).s
        return res
    }

    fun sub(res: Vec2us, aX: Ushort, aY: Ushort, b: Vec2us): Vec2us {
        res.x.v = (aX.v - b.x.v).s
        res.y.v = (aY.v - b.y.v).s
        return res
    }

    fun sub(res: Vec2us, aX: Short, aY: Short, b: Vec2us): Vec2us {
        res.x.v = (aX - b.x.v).s
        res.y.v = (aY - b.y.v).s
        return res
    }

    fun sub(res: Vec2us, aX: Int, aY: Int, b: Vec2us): Vec2us {
        res.x.v = (aX - b.x.v).s
        res.y.v = (aY - b.y.v).s
        return res
    }

    fun mul(res: Vec2us, a: Vec2us, bX: Ushort, bY: Ushort): Vec2us {
        res.x.v = (a.x.v * bX.v).s
        res.y.v = (a.y.v * bY.v).s
        return res
    }

    fun mul(res: Vec2us, a: Vec2us, bX: Short, bY: Short): Vec2us {
        res.x.v = (a.x.v * bX).s
        res.y.v = (a.y.v * bY).s
        return res
    }

    fun mul(res: Vec2us, a: Vec2us, bX: Int, bY: Int): Vec2us {
        res.x.v = (a.x.v * bX).s
        res.y.v = (a.y.v * bY).s
        return res
    }

    fun div(res: Vec2us, a: Vec2us, bX: Ushort, bY: Ushort): Vec2us {
        res.x.v = a.x.v udiv bX.v
        res.y.v = a.y.v udiv bY.v
        return res
    }

    fun div(res: Vec2us, a: Vec2us, bX: Short, bY: Short): Vec2us {
        res.x.v = a.x.v udiv bX
        res.y.v = a.y.v udiv bY
        return res
    }

    fun div(res: Vec2us, a: Vec2us, bX: Int, bY: Int): Vec2us {
        res.x.v = a.x.v udiv bX
        res.y.v = a.y.v udiv bY
        return res
    }

    fun div(res: Vec2us, aX: Ushort, aY: Ushort, b: Vec2us): Vec2us {
        res.x.v = aX.v udiv b.x.v
        res.y.v = aY.v udiv b.y.v
        return res
    }

    fun div(res: Vec2us, aX: Short, aY: Short, b: Vec2us): Vec2us {
        res.x.v = aX udiv b.x.v
        res.y.v = aY udiv b.y.v
        return res
    }

    fun div(res: Vec2us, aX: Int, aY: Int, b: Vec2us): Vec2us {
        res.x.v = (aX udiv b.x.v).s
        res.y.v = (aY udiv b.y.v).s
        return res
    }

    fun rem(res: Vec2us, a: Vec2us, bX: Ushort, bY: Ushort): Vec2us {
        res.x.v = a.x.v urem bX.v
        res.y.v = a.y.v urem bY.v
        return res
    }

    fun rem(res: Vec2us, a: Vec2us, bX: Short, bY: Short): Vec2us {
        res.x.v = a.x.v urem bX
        res.y.v = a.y.v urem bY
        return res
    }

    fun rem(res: Vec2us, a: Vec2us, bX: Int, bY: Int): Vec2us {
        res.x.v = a.x.v urem bX
        res.y.v = a.y.v urem bY
        return res
    }

    fun rem(res: Vec2us, aX: Ushort, aY: Ushort, b: Vec2us): Vec2us {
        res.x.v = aX.v urem b.x.v
        res.y.v = aY.v urem b.y.v
        return res
    }

    fun rem(res: Vec2us, aX: Short, aY: Short, b: Vec2us): Vec2us {
        res.x.v = aX urem b.x.v
        res.y.v = aY urem b.y.v
        return res
    }

    fun rem(res: Vec2us, aX: Int, aY: Int, b: Vec2us): Vec2us {
        res.x.v = (aX urem b.x.v).s
        res.y.v = (aY urem b.y.v).s
        return res
    }

    fun and(res: Vec2us, a: Vec2us, bX: Ushort, bY: Ushort): Vec2us {
        res.x.v = a.x.v and bX.v
        res.y.v = a.y.v and bY.v
        return res
    }

    fun and(res: Vec2us, a: Vec2us, bX: Short, bY: Short): Vec2us {
        res.x.v = a.x.v and bX
        res.y.v = a.y.v and bY
        return res
    }

    fun and(res: Vec2us, a: Vec2us, bX: Int, bY: Int): Vec2us {
        res.x.v = a.x.v and bX
        res.y.v = a.y.v and bY
        return res
    }

    fun or(res: Vec2us, a: Vec2us, bX: Ushort, bY: Ushort): Vec2us {
        res.x.v = a.x.v or bX
        res.y.v = a.y.v or bY
        return res
    }

    fun or(res: Vec2us, a: Vec2us, bX: Short, bY: Short): Vec2us {
        res.x.v = a.x.v or bX
        res.y.v = a.y.v or bY
        return res
    }

    fun or(res: Vec2us, a: Vec2us, bX: Int, bY: Int): Vec2us {
        res.x.v = a.x.v or bX
        res.y.v = a.y.v or bY
        return res
    }

    fun xor(res: Vec2us, a: Vec2us, bX: Ushort, bY: Ushort): Vec2us {
        res.x.v = a.x.v xor bX
        res.y.v = a.y.v xor bY
        return res
    }

    fun xor(res: Vec2us, a: Vec2us, bX: Short, bY: Short): Vec2us {
        res.x.v = a.x.v xor bX
        res.y.v = a.y.v xor bY
        return res
    }

    fun xor(res: Vec2us, a: Vec2us, bX: Int, bY: Int): Vec2us {
        res.x.v = a.x.v xor bX
        res.y.v = a.y.v xor bY
        return res
    }

    fun shl(res: Vec2us, a: Vec2us, bX: Ushort, bY: Ushort): Vec2us {
        res.x.v = a.x.v shl bX
        res.y.v = a.y.v shl bY
        return res
    }

    fun shl(res: Vec2us, a: Vec2us, bX: Short, bY: Short): Vec2us {
        res.x.v = a.x.v shl bX
        res.y.v = a.y.v shl bY
        return res
    }

    fun shl(res: Vec2us, a: Vec2us, bX: Int, bY: Int): Vec2us {
        res.x.v = a.x.v shl bX
        res.y.v = a.y.v shl bY
        return res
    }

    fun shr(res: Vec2us, a: Vec2us, bX: Ushort, bY: Ushort): Vec2us {
        res.x.v = a.x.v ushr bX.v
        res.y.v = a.y.v ushr bY.v
        return res
    }

    fun shr(res: Vec2us, a: Vec2us, bX: Short, bY: Short): Vec2us {
        res.x.v = a.x.v ushr bX
        res.y.v = a.y.v ushr bY
        return res
    }

    fun shr(res: Vec2us, a: Vec2us, bX: Int, bY: Int): Vec2us {
        res.x.v = a.x.v ushr bX
        res.y.v = a.y.v ushr bY
        return res
    }

    fun inv(res: Vec2us, a: Vec2us): Vec2us {
        res.x.v = a.x.v.inv()
        res.y.v = a.y.v.inv()
        return res
    }
}


// -- Specific binary arithmetic operators --

operator fun Ushort.plus(b: Vec2us) = add(Vec2us(), b, this, this)
infix fun Ushort.add_(b: Vec2us) = add(b, b, this, this)

operator fun Ushort.minus(b: Vec2us) = sub(Vec2us(), this, this, b)
infix fun Ushort.sub_(b: Vec2us) = sub(b, this, this, b)

operator fun Ushort.times(b: Vec2us) = mul(Vec2us(), b, this, this)
infix fun Ushort.mul_(b: Vec2us) = mul(b, b, this, this)

operator fun Ushort.div(b: Vec2us) = div(Vec2us(), this, this, b)
infix fun Ushort.div_(b: Vec2us) = div(b, this, this, b)

operator fun Ushort.rem(b: Vec2us) = rem(Vec2us(), this, this, b)
infix fun Ushort.rem_(b: Vec2us) = rem(b, this, this, b)


operator fun Short.plus(b: Vec2us) = add(Vec2us(), b, this, this)
infix fun Short.add_(b: Vec2us) = add(b, b, this, this)

operator fun Short.minus(b: Vec2us) = sub(Vec2us(), this, this, b)
infix fun Short.sub_(b: Vec2us) = sub(b, this, this, b)

operator fun Short.times(b: Vec2us) = mul(Vec2us(), b, this, this)
infix fun Short.mul_(b: Vec2us) = mul(b, b, this, this)

operator fun Short.div(b: Vec2us) = div(Vec2us(), this, this, b)
infix fun Short.div_(b: Vec2us) = div(b, this, this, b)

operator fun Short.rem(b: Vec2us) = rem(Vec2us(), this, this, b)
infix fun Short.rem_(b: Vec2us) = rem(b, this, this, b)


operator fun Int.plus(b: Vec2us) = add(Vec2us(), b, this, this)
infix fun Int.add_(b: Vec2us) = add(b, b, this, this)

operator fun Int.minus(b: Vec2us) = sub(Vec2us(), this, this, b)
infix fun Int.sub_(b: Vec2us) = sub(b, this, this, b)

operator fun Int.times(b: Vec2us) = mul(Vec2us(), b, this, this)
infix fun Int.mul_(b: Vec2us) = mul(b, b, this, this)

operator fun Int.div(b: Vec2us) = div(Vec2us(), this, this, b)
infix fun Int.div_(b: Vec2us) = div(b, this, this, b)

operator fun Int.rem(b: Vec2us) = rem(Vec2us(), this, this, b)
infix fun Int.rem_(b: Vec2us) = rem(b, this, this, b)


// -- Generic binary arithmetic operators --

operator fun Number.plus(b: Vec2us) = add(Vec2us(), b, this.i, this.i)
infix fun Number.add_(b: Vec2us) = add(b, b, this.i, this.i)

operator fun Number.minus(b: Vec2us) = sub(Vec2us(), this.i, this.i, b)
infix fun Number.sub_(b: Vec2us) = sub(b, this.i, this.i, b)

operator fun Number.times(b: Vec2us) = mul(Vec2us(), b, this.i, this.i)
infix fun Number.mul_(b: Vec2us) = mul(b, b, this.i, this.i)

operator fun Number.div(b: Vec2us) = div(Vec2us(), this.i, this.i, b)
infix fun Number.div_(b: Vec2us) = div(b, this.i, this.i, b)

operator fun Number.rem(b: Vec2us) = rem(Vec2us(), this.i, this.i, b)
infix fun Number.rem_(b: Vec2us) = rem(b, this.i, this.i, b)