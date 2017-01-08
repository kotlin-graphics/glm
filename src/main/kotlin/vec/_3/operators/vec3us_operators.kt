package vec._3.operators

import Ushort
import and
import i
import or
import s
import shl
import udiv
import urem
import ushr
import vec._3.Vec3us
import vec._3.Vec3us.Companion.add
import vec._3.Vec3us.Companion.div
import vec._3.Vec3us.Companion.mul
import vec._3.Vec3us.Companion.rem
import vec._3.Vec3us.Companion.sub
import xor


/**
 * Created by elect on 09/11/16.
 */

interface vec3us_operators {

    fun add(res: Vec3us, a: Vec3us, bX: Ushort, bY: Ushort, bZ: Ushort): Vec3us {
        res.x.v = (a.x.v + bX.v).s
        res.y.v = (a.y.v + bY.v).s
        res.z.v = (a.z.v + bZ.v).s
        return res
    }

    fun add(res: Vec3us, a: Vec3us, bX: Short, bY: Short, bZ: Short): Vec3us {
        res.x.v = (a.x.v + bX).s
        res.y.v = (a.y.v + bY).s
        res.z.v = (a.z.v + bZ).s
        return res
    }

    fun add(res: Vec3us, a: Vec3us, bX: Int, bY: Int, bZ: Int): Vec3us {
        res.x.v = (a.x.v + bX).s
        res.y.v = (a.y.v + bY).s
        res.z.v = (a.z.v + bZ).s
        return res
    }

    fun sub(res: Vec3us, a: Vec3us, bX: Ushort, bY: Ushort, bZ: Ushort): Vec3us {
        res.x.v = (a.x.v - bX.v).s
        res.y.v = (a.y.v - bY.v).s
        res.z.v = (a.z.v - bZ.v).s
        return res
    }

    fun sub(res: Vec3us, a: Vec3us, bX: Short, bY: Short, bZ: Short): Vec3us {
        res.x.v = (a.x.v - bX).s
        res.y.v = (a.y.v - bY).s
        res.z.v = (a.z.v - bZ).s
        return res
    }

    fun sub(res: Vec3us, a: Vec3us, bX: Int, bY: Int, bZ: Int): Vec3us {
        res.x.v = (a.x.v - bX).s
        res.y.v = (a.y.v - bY).s
        res.z.v = (a.z.v - bZ).s
        return res
    }

    fun sub(res: Vec3us, aX: Ushort, aY: Ushort, aZ: Ushort, b: Vec3us): Vec3us {
        res.x.v = (aX.v - b.x.v).s
        res.y.v = (aY.v - b.y.v).s
        res.z.v = (aZ.v - b.z.v).s
        return res
    }

    fun sub(res: Vec3us, aX: Short, aY: Short, aZ: Short, b: Vec3us): Vec3us {
        res.x.v = (aX - b.x.v).s
        res.y.v = (aY - b.y.v).s
        res.z.v = (aZ - b.z.v).s
        return res
    }

    fun sub(res: Vec3us, aX: Int, aY: Int, aZ: Int, b: Vec3us): Vec3us {
        res.x.v = (aX - b.x.v).s
        res.y.v = (aY - b.y.v).s
        res.z.v = (aZ - b.z.v).s
        return res
    }

    fun mul(res: Vec3us, a: Vec3us, bX: Ushort, bY: Ushort, bZ: Ushort): Vec3us {
        res.x.v = (a.x.v * bX.v).s
        res.y.v = (a.y.v * bY.v).s
        res.z.v = (a.z.v * bZ.v).s
        return res
    }

    fun mul(res: Vec3us, a: Vec3us, bX: Short, bY: Short, bZ: Short): Vec3us {
        res.x.v = (a.x.v * bX).s
        res.y.v = (a.y.v * bY).s
        res.z.v = (a.z.v * bZ).s
        return res
    }

    fun mul(res: Vec3us, a: Vec3us, bX: Int, bY: Int, bZ: Int): Vec3us {
        res.x.v = (a.x.v * bX).s
        res.y.v = (a.y.v * bY).s
        res.z.v = (a.z.v * bZ).s
        return res
    }

    fun div(res: Vec3us, a: Vec3us, bX: Ushort, bY: Ushort, bZ: Ushort): Vec3us {
        res.x.v = a.x.v udiv bX.v
        res.y.v = a.y.v udiv bY.v
        res.z.v = a.z.v udiv bZ.v
        return res
    }

    fun div(res: Vec3us, a: Vec3us, bX: Short, bY: Short, bZ: Short): Vec3us {
        res.x.v = a.x.v udiv bX
        res.y.v = a.y.v udiv bY
        res.z.v = a.z.v udiv bZ
        return res
    }

    fun div(res: Vec3us, a: Vec3us, bX: Int, bY: Int, bZ: Int): Vec3us {
        res.x.v = a.x.v udiv bX
        res.y.v = a.y.v udiv bY
        res.z.v = a.z.v udiv bZ
        return res
    }

    fun div(res: Vec3us, aX: Ushort, aY: Ushort, aZ: Ushort, b: Vec3us): Vec3us {
        res.x.v = aX.v udiv b.x.v
        res.y.v = aY.v udiv b.y.v
        res.z.v = aZ.v udiv b.z.v
        return res
    }

    fun div(res: Vec3us, aX: Short, aY: Short, aZ: Short, b: Vec3us): Vec3us {
        res.x.v = aX udiv b.x.v
        res.y.v = aY udiv b.y.v
        res.z.v = aZ udiv b.z.v
        return res
    }

    fun div(res: Vec3us, aX: Int, aY: Int, aZ: Int, b: Vec3us): Vec3us {
        res.x.v = (aX udiv b.x.v).s
        res.y.v = (aY udiv b.y.v).s
        res.z.v = (aZ udiv b.z.v).s
        return res
    }

    fun rem(res: Vec3us, a: Vec3us, bX: Ushort, bY: Ushort, bZ: Ushort): Vec3us {
        res.x.v = a.x.v urem bX.v
        res.y.v = a.y.v urem bY.v
        res.z.v = a.z.v urem bZ.v
        return res
    }

    fun rem(res: Vec3us, a: Vec3us, bX: Short, bY: Short, bZ: Short): Vec3us {
        res.x.v = a.x.v urem bX
        res.y.v = a.y.v urem bY
        res.z.v = a.z.v urem bZ
        return res
    }

    fun rem(res: Vec3us, a: Vec3us, bX: Int, bY: Int, bZ: Int): Vec3us {
        res.x.v = a.x.v urem bX
        res.y.v = a.y.v urem bY
        res.z.v = a.z.v urem bZ
        return res
    }

    fun rem(res: Vec3us, aX: Ushort, aY: Ushort, aZ: Ushort, b: Vec3us): Vec3us {
        res.x.v = aX.v urem b.x.v
        res.y.v = aY.v urem b.y.v
        res.z.v = aZ.v urem b.z.v
        return res
    }

    fun rem(res: Vec3us, aX: Short, aY: Short, aZ: Short, b: Vec3us): Vec3us {
        res.x.v = aX urem b.x.v
        res.y.v = aY urem b.y.v
        res.z.v = aZ urem b.z.v
        return res
    }

    fun rem(res: Vec3us, aX: Int, aY: Int, aZ: Int, b: Vec3us): Vec3us {
        res.x.v = (aX urem b.x.v).s
        res.y.v = (aY urem b.y.v).s
        res.z.v = (aZ urem b.z.v).s
        return res
    }

    fun and(res: Vec3us, a: Vec3us, bX: Ushort, bY: Ushort, bZ: Ushort): Vec3us {
        res.x.v = a.x.v and bX.v
        res.y.v = a.y.v and bY.v
        res.z.v = a.z.v and bZ.v
        return res
    }

    fun and(res: Vec3us, a: Vec3us, bX: Short, bY: Short, bZ: Short): Vec3us {
        res.x.v = a.x.v and bX
        res.y.v = a.y.v and bY
        res.z.v = a.z.v and bZ
        return res
    }

    fun and(res: Vec3us, a: Vec3us, bX: Int, bY: Int, bZ: Int): Vec3us {
        res.x.v = a.x.v and bX
        res.y.v = a.y.v and bY
        res.z.v = a.z.v and bZ
        return res
    }

    fun or(res: Vec3us, a: Vec3us, bX: Ushort, bY: Ushort, bZ: Ushort): Vec3us {
        res.x.v = a.x.v or bX
        res.y.v = a.y.v or bY
        res.z.v = a.z.v or bZ
        return res
    }

    fun or(res: Vec3us, a: Vec3us, bX: Short, bY: Short, bZ: Short): Vec3us {
        res.x.v = a.x.v or bX
        res.y.v = a.y.v or bY
        res.z.v = a.z.v or bZ
        return res
    }

    fun or(res: Vec3us, a: Vec3us, bX: Int, bY: Int, bZ: Int): Vec3us {
        res.x.v = a.x.v or bX
        res.y.v = a.y.v or bY
        res.z.v = a.z.v or bZ
        return res
    }

    fun xor(res: Vec3us, a: Vec3us, bX: Ushort, bY: Ushort, bZ: Ushort): Vec3us {
        res.x.v = a.x.v xor bX
        res.y.v = a.y.v xor bY
        res.z.v = a.z.v xor bZ
        return res
    }

    fun xor(res: Vec3us, a: Vec3us, bX: Short, bY: Short, bZ: Short): Vec3us {
        res.x.v = a.x.v xor bX
        res.y.v = a.y.v xor bY
        res.z.v = a.z.v xor bZ
        return res
    }

    fun xor(res: Vec3us, a: Vec3us, bX: Int, bY: Int, bZ: Int): Vec3us {
        res.x.v = a.x.v xor bX
        res.y.v = a.y.v xor bY
        res.z.v = a.z.v xor bZ
        return res
    }

    fun shl(res: Vec3us, a: Vec3us, bX: Ushort, bY: Ushort, bZ: Ushort): Vec3us {
        res.x.v = a.x.v shl bX
        res.y.v = a.y.v shl bY
        res.z.v = a.z.v shl bZ
        return res
    }

    fun shl(res: Vec3us, a: Vec3us, bX: Short, bY: Short, bZ: Short): Vec3us {
        res.x.v = a.x.v shl bX
        res.y.v = a.y.v shl bY
        res.z.v = a.z.v shl bZ
        return res
    }

    fun shl(res: Vec3us, a: Vec3us, bX: Int, bY: Int, bZ: Int): Vec3us {
        res.x.v = a.x.v shl bX
        res.y.v = a.y.v shl bY
        res.z.v = a.z.v shl bZ
        return res
    }

    fun shr(res: Vec3us, a: Vec3us, bX: Ushort, bY: Ushort, bZ: Ushort): Vec3us {
        res.x.v = a.x.v ushr bX.v
        res.y.v = a.y.v ushr bY.v
        res.z.v = a.z.v ushr bZ.v
        return res
    }

    fun shr(res: Vec3us, a: Vec3us, bX: Short, bY: Short, bZ: Short): Vec3us {
        res.x.v = a.x.v ushr bX
        res.y.v = a.y.v ushr bY
        res.z.v = a.z.v ushr bZ
        return res
    }

    fun shr(res: Vec3us, a: Vec3us, bX: Int, bY: Int, bZ: Int): Vec3us {
        res.x.v = a.x.v ushr bX
        res.y.v = a.y.v ushr bY
        res.z.v = a.z.v ushr bZ
        return res
    }

    fun inv(res: Vec3us, a: Vec3us): Vec3us {
        res.x.v = a.x.v.inv()
        res.y.v = a.y.v.inv()
        res.z.v = a.z.v.inv()
        return res
    }
}


// -- Specific binary arithmetic operators --

operator fun Ushort.plus(b: Vec3us) = add(Vec3us(), b, this, this, this)
infix fun Ushort.add_(b: Vec3us) = add(b, b, this, this, this)

operator fun Ushort.minus(b: Vec3us) = sub(Vec3us(), this, this, this, b)
infix fun Ushort.sub_(b: Vec3us) = sub(b, this, this, this, b)

operator fun Ushort.times(b: Vec3us) = mul(Vec3us(), b, this, this, this)
infix fun Ushort.mul_(b: Vec3us) = mul(b, b, this, this, this)

operator fun Ushort.div(b: Vec3us) = div(Vec3us(), this, this, this, b)
infix fun Ushort.div_(b: Vec3us) = div(b, this, this, this, b)

operator fun Ushort.rem(b: Vec3us) = rem(Vec3us(), this, this, this, b)
infix fun Ushort.rem_(b: Vec3us) = rem(b, this, this, this, b)


operator fun Short.plus(b: Vec3us) = add(Vec3us(), b, this, this, this)
infix fun Short.add_(b: Vec3us) = add(b, b, this, this, this)

operator fun Short.minus(b: Vec3us) = sub(Vec3us(), this, this, this, b)
infix fun Short.sub_(b: Vec3us) = sub(b, this, this, this, b)

operator fun Short.times(b: Vec3us) = mul(Vec3us(), b, this, this, this)
infix fun Short.mul_(b: Vec3us) = mul(b, b, this, this, this)

operator fun Short.div(b: Vec3us) = div(Vec3us(), this, this, this, b)
infix fun Short.div_(b: Vec3us) = div(b, this, this, this, b)

operator fun Short.rem(b: Vec3us) = rem(Vec3us(), this, this, this, b)
infix fun Short.rem_(b: Vec3us) = rem(b, this, this, this, b)


operator fun Int.plus(b: Vec3us) = add(Vec3us(), b, this, this, this)
infix fun Int.add_(b: Vec3us) = add(b, b, this, this, this)

operator fun Int.minus(b: Vec3us) = sub(Vec3us(), this, this, this, b)
infix fun Int.sub_(b: Vec3us) = sub(b, this, this, this, b)

operator fun Int.times(b: Vec3us) = mul(Vec3us(), b, this, this, this)
infix fun Int.mul_(b: Vec3us) = mul(b, b, this, this, this)

operator fun Int.div(b: Vec3us) = div(Vec3us(), this, this, this, b)
infix fun Int.div_(b: Vec3us) = div(b, this, this, this, b)

operator fun Int.rem(b: Vec3us) = rem(Vec3us(), this, this, this, b)
infix fun Int.rem_(b: Vec3us) = rem(b, this, this, this, b)


// -- Generic binary arithmetic operators --

operator fun Number.plus(b: Vec3us) = add(Vec3us(), b, this.i, this.i, this.i)
infix fun Number.add_(b: Vec3us) = add(b, b, this.i, this.i, this.i)

operator fun Number.minus(b: Vec3us) = sub(Vec3us(), this.i, this.i, this.i, b)
infix fun Number.sub_(b: Vec3us) = sub(b, this.i, this.i, this.i, b)

operator fun Number.times(b: Vec3us) = mul(Vec3us(), b, this.i, this.i, this.i)
infix fun Number.mul_(b: Vec3us) = mul(b, b, this.i, this.i, this.i)

operator fun Number.div(b: Vec3us) = div(Vec3us(), this.i, this.i, this.i, b)
infix fun Number.div_(b: Vec3us) = div(b, this.i, this.i, this.i, b)

operator fun Number.rem(b: Vec3us) = rem(Vec3us(), this.i, this.i, this.i, b)
infix fun Number.rem_(b: Vec3us) = rem(b, this.i, this.i, this.i, b)