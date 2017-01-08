package vec._2.operators

import L
import Ulong
import i
import udiv
import urem
import vec._2.Vec2ul
import vec._2.Vec2ul.Companion.add
import vec._2.Vec2ul.Companion.div
import vec._2.Vec2ul.Companion.mul
import vec._2.Vec2ul.Companion.rem
import vec._2.Vec2ul.Companion.sub

/**
 * Created by elect on 09/11/16.
 */
interface vec2ul_operators {


    fun add(res: Vec2ul, a: Vec2ul, bX: Ulong, bY: Ulong): Vec2ul {
        res.x.v = a.x.v + bX.v
        res.y.v = a.y.v + bY.v
        return res
    }

    fun add(res: Vec2ul, a: Vec2ul, bX: Long, bY: Long): Vec2ul {
        res.x.v = a.x.v + bX
        res.y.v = a.y.v + bY
        return res
    }

    fun sub(res: Vec2ul, a: Vec2ul, bX: Ulong, bY: Ulong): Vec2ul {
        res.x.v = a.x.v - bX.v
        res.y.v = a.y.v - bY.v
        return res
    }

    fun sub(res: Vec2ul, a: Vec2ul, bX: Long, bY: Long): Vec2ul {
        res.x.v = a.x.v - bX
        res.y.v = a.y.v - bY
        return res
    }

    fun sub(res: Vec2ul, aX: Ulong, aY: Ulong, b: Vec2ul): Vec2ul {
        res.x.v = aX.v - b.x.v
        res.y.v = aY.v - b.y.v
        return res
    }

    fun sub(res: Vec2ul, aX: Long, aY: Long, b: Vec2ul): Vec2ul {
        res.x.v = aX - b.x.v
        res.y.v = aY - b.y.v
        return res
    }

    fun mul(res: Vec2ul, a: Vec2ul, bX: Ulong, bY: Ulong): Vec2ul {
        res.x.v = a.x.v * bX.v
        res.y.v = a.y.v * bY.v
        return res
    }

    fun mul(res: Vec2ul, a: Vec2ul, bX: Long, bY: Long): Vec2ul {
        res.x.v = a.x.v * bX
        res.y.v = a.y.v * bY
        return res
    }

    fun div(res: Vec2ul, a: Vec2ul, bX: Ulong, bY: Ulong): Vec2ul {
        res.x.v = a.x.v udiv bX.v
        res.y.v = a.y.v udiv bY.v
        return res
    }

    fun div(res: Vec2ul, a: Vec2ul, bX: Long, bY: Long): Vec2ul {
        res.x.v = a.x.v udiv bX
        res.y.v = a.y.v udiv bY
        return res
    }

    fun div(res: Vec2ul, aX: Ulong, aY: Ulong, b: Vec2ul): Vec2ul {
        res.x.v = aX.v udiv b.x.v
        res.y.v = aY.v udiv b.y.v
        return res
    }

    fun div(res: Vec2ul, aX: Long, aY: Long, b: Vec2ul): Vec2ul {
        res.x.v = aX udiv b.x.v
        res.y.v = aY udiv b.y.v
        return res
    }

    fun rem(res: Vec2ul, a: Vec2ul, bX: Ulong, bY: Ulong): Vec2ul {
        res.x.v = a.x.v urem bX.v
        res.y.v = a.y.v urem bY.v
        return res
    }

    fun rem(res: Vec2ul, a: Vec2ul, bX: Long, bY: Long): Vec2ul {
        res.x.v = a.x.v urem bX
        res.y.v = a.y.v urem bY
        return res
    }

    fun rem(res: Vec2ul, aX: Ulong, aY: Ulong, b: Vec2ul): Vec2ul {
        res.x.v = aX.v urem b.x.v
        res.y.v = aY.v urem b.y.v
        return res
    }

    fun rem(res: Vec2ul, aX: Long, aY: Long, b: Vec2ul): Vec2ul {
        res.x.v = aX urem b.x.v
        res.y.v = aY urem b.y.v
        return res
    }

    fun and(res: Vec2ul, a: Vec2ul, bX: Ulong, bY: Ulong): Vec2ul {
        res.x.v = a.x.v and bX.v
        res.y.v = a.y.v and bY.v
        return res
    }

    fun and(res: Vec2ul, a: Vec2ul, bX: Long, bY: Long): Vec2ul {
        res.x.v = a.x.v and bX
        res.y.v = a.y.v and bY
        return res
    }

    fun or(res: Vec2ul, a: Vec2ul, bX: Ulong, bY: Ulong): Vec2ul {
        res.x.v = a.x.v or bX.v
        res.y.v = a.y.v or bY.v
        return res
    }

    fun or(res: Vec2ul, a: Vec2ul, bX: Long, bY: Long): Vec2ul {
        res.x.v = a.x.v or bX
        res.y.v = a.y.v or bY
        return res
    }

    fun xor(res: Vec2ul, a: Vec2ul, bX: Ulong, bY: Ulong): Vec2ul {
        res.x.v = a.x.v xor bX.v
        res.y.v = a.y.v xor bY.v
        return res
    }

    fun xor(res: Vec2ul, a: Vec2ul, bX: Long, bY: Long): Vec2ul {
        res.x.v = a.x.v xor bX
        res.y.v = a.y.v xor bY
        return res
    }

    fun shl(res: Vec2ul, a: Vec2ul, bX: Long, bY: Long): Vec2ul {
        res.x.v = a.x.v shl bX.i
        res.y.v = a.y.v shl bY.i
        return res
    }

    fun shl(res: Vec2ul, a: Vec2ul, bX: Int, bY: Int): Vec2ul {
        res.x.v = a.x.v shl bX
        res.y.v = a.y.v shl bY
        return res
    }


    fun shr(res: Vec2ul, a: Vec2ul, bX: Long, bY: Long): Vec2ul {
        res.x.v = a.x.v ushr bX.i
        res.y.v = a.y.v ushr bY.i
        return res
    }

    fun shr(res: Vec2ul, a: Vec2ul, bX: Int, bY: Int): Vec2ul {
        res.x.v = a.x.v ushr bX
        res.y.v = a.y.v ushr bY
        return res
    }

    fun inv(res: Vec2ul, a: Vec2ul): Vec2ul {
        res.x.v = a.x.v.inv()
        res.y.v = a.y.v.inv()
        return res
    }
}


// -- Specific binary arithmetic operators --

operator fun Ulong.plus(b: Vec2ul) = add(Vec2ul(), b, this, this)
infix fun Ulong.add_(b: Vec2ul) = add(b, b, this, this)

operator fun Ulong.minus(b: Vec2ul) = sub(Vec2ul(), this, this, b)
infix fun Ulong.sub_(b: Vec2ul) = sub(b, this, this, b)

operator fun Ulong.times(b: Vec2ul) = mul(Vec2ul(), b, this, this)
infix fun Ulong.mul_(b: Vec2ul) = mul(b, b, this, this)

operator fun Ulong.div(b: Vec2ul) = div(Vec2ul(), this, this, b)
infix fun Ulong.div_(b: Vec2ul) = div(b, this, this, b)

operator fun Ulong.rem(b: Vec2ul) = rem(Vec2ul(), this, this, b)
infix fun Ulong.rem_(b: Vec2ul) = rem(b, this, this, b)


operator fun Long.plus(b: Vec2ul) = add(Vec2ul(), b, this, this)
infix fun Long.add_(b: Vec2ul) = add(b, b, this, this)

operator fun Long.minus(b: Vec2ul) = sub(Vec2ul(), this, this, b)
infix fun Long.sub_(b: Vec2ul) = sub(b, this, this, b)

operator fun Long.times(b: Vec2ul) = mul(Vec2ul(), b, this, this)
infix fun Long.mul_(b: Vec2ul) = mul(b, b, this, this)

operator fun Long.div(b: Vec2ul) = div(Vec2ul(), this, this, b)
infix fun Long.div_(b: Vec2ul) = div(b, this, this, b)

operator fun Long.rem(b: Vec2ul) = rem(Vec2ul(), this, this, b)
infix fun Long.rem_(b: Vec2ul) = rem(b, this, this, b)


// -- Generic binary arithmetic operators --

operator fun Number.plus(b: Vec2ul) = add(Vec2ul(), b, this.L, this.L)
infix fun Number.add_(b: Vec2ul) = add(b, b, this.L, this.L)

operator fun Number.minus(b: Vec2ul) = sub(Vec2ul(), this.L, this.L, b)
infix fun Number.sub_(b: Vec2ul) = sub(b, this.L, this.L, b)

operator fun Number.times(b: Vec2ul) = mul(Vec2ul(), b, this.L, this.L)
infix fun Number.mul_(b: Vec2ul) = mul(b, b, this.L, this.L)

operator fun Number.div(b: Vec2ul) = div(Vec2ul(), this.L, this.L, b)
infix fun Number.div_(b: Vec2ul) = div(b, this.L, this.L, b)

operator fun Number.rem(b: Vec2ul) = rem(Vec2ul(), this.L, this.L, b)
infix fun Number.rem_(b: Vec2ul) = rem(b, this.L, this.L, b)