package vec._4.operators

import Ushort
import s
import i
import and
import or
import xor
import shl
import ushr
import udiv
import urem
import vec._4.Vec4us
import vec._4.Vec4us.Companion.add
import vec._4.Vec4us.Companion.div
import vec._4.Vec4us.Companion.mul
import vec._4.Vec4us.Companion.rem
import vec._4.Vec4us.Companion.sub

/**
 * Created by elect on 09/11/16.
 */

interface vec4us_operators {

    fun add(res: Vec4us, a: Vec4us, bX: Ushort, bY: Ushort, bZ: Ushort, bW: Ushort): Vec4us {
        res.x.v = (a.x.v + bX.v).s
        res.y.v = (a.y.v + bY.v).s
        res.z.v = (a.z.v + bZ.v).s
        res.w.v = (a.w.v + bW.v).s
        return res
    }

    fun add(res: Vec4us, a: Vec4us, bX: Short, bY: Short, bZ: Short, bW: Short): Vec4us {
        res.x.v = (a.x.v + bX).s
        res.y.v = (a.y.v + bY).s
        res.z.v = (a.z.v + bZ).s
        res.w.v = (a.w.v + bW).s
        return res
    }

    fun add(res: Vec4us, a: Vec4us, bX: Int, bY: Int, bZ: Int, bW: Int): Vec4us {
        res.x.v = (a.x.v + bX).s
        res.y.v = (a.y.v + bY).s
        res.z.v = (a.z.v + bZ).s
        res.w.v = (a.w.v + bW).s
        return res
    }

    fun sub(res: Vec4us, a: Vec4us, bX: Ushort, bY: Ushort, bZ: Ushort, bW: Ushort): Vec4us {
        res.x.v = (a.x.v - bX.v).s
        res.y.v = (a.y.v - bY.v).s
        res.z.v = (a.z.v - bZ.v).s
        res.w.v = (a.w.v - bW.v).s
        return res
    }

    fun sub(res: Vec4us, a: Vec4us, bX: Short, bY: Short, bZ: Short, bW: Short): Vec4us {
        res.x.v = (a.x.v - bX).s
        res.y.v = (a.y.v - bY).s
        res.z.v = (a.z.v - bZ).s
        res.w.v = (a.w.v - bW).s
        return res
    }

    fun sub(res: Vec4us, a: Vec4us, bX: Int, bY: Int, bZ: Int, bW: Int): Vec4us {
        res.x.v = (a.x.v - bX).s
        res.y.v = (a.y.v - bY).s
        res.z.v = (a.z.v - bZ).s
        res.w.v = (a.w.v - bW).s
        return res
    }

    fun sub(res: Vec4us, aX: Ushort, aY: Ushort, aZ: Ushort, aW: Ushort, b: Vec4us): Vec4us {
        res.x.v = (aX.v - b.x.v).s
        res.y.v = (aY.v - b.y.v).s
        res.z.v = (aZ.v - b.z.v).s
        res.w.v = (aW.v - b.w.v).s
        return res
    }

    fun sub(res: Vec4us, aX: Short, aY: Short, aZ: Short, aW: Short, b: Vec4us): Vec4us {
        res.x.v = (aX - b.x.v).s
        res.y.v = (aY - b.y.v).s
        res.z.v = (aZ - b.z.v).s
        res.w.v = (aW - b.w.v).s
        return res
    }

    fun sub(res: Vec4us, aX: Int, aY: Int, aZ: Int, aW: Int, b: Vec4us): Vec4us {
        res.x.v = (aX - b.x.v).s
        res.y.v = (aY - b.y.v).s
        res.z.v = (aZ - b.z.v).s
        res.w.v = (aW - b.w.v).s
        return res
    }

    fun mul(res: Vec4us, a: Vec4us, bX: Ushort, bY: Ushort, bZ: Ushort, bW: Ushort): Vec4us {
        res.x.v = (a.x.v * bX.v).s
        res.y.v = (a.y.v * bY.v).s
        res.z.v = (a.z.v * bZ.v).s
        res.w.v = (a.w.v * bW.v).s
        return res
    }

    fun mul(res: Vec4us, a: Vec4us, bX: Short, bY: Short, bZ: Short, bW: Short): Vec4us {
        res.x.v = (a.x.v * bX).s
        res.y.v = (a.y.v * bY).s
        res.z.v = (a.z.v * bZ).s
        res.w.v = (a.w.v * bW).s
        return res
    }

    fun mul(res: Vec4us, a: Vec4us, bX: Int, bY: Int, bZ: Int, bW: Int): Vec4us {
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

operator fun Ushort.plus(b: Vec4us) = add(Vec4us(), b, this, this, this, this)
infix fun Ushort.add_(b: Vec4us) = add(b, b, this, this, this, this)

operator fun Ushort.minus(b: Vec4us) = sub(Vec4us(), this, this, this, this, b)
infix fun Ushort.sub_(b: Vec4us) = sub(b, this, this, this, this, b)

operator fun Ushort.times(b: Vec4us) = mul(Vec4us(), b, this, this, this, this)
infix fun Ushort.mul_(b: Vec4us) = mul(b, b, this, this, this, this)

operator fun Ushort.div(b: Vec4us) = div(Vec4us(), this, this, this, this, b)
infix fun Ushort.div_(b: Vec4us) = div(b, this, this, this, this, b)

operator fun Ushort.rem(b: Vec4us) = rem(Vec4us(), this, this, this, this, b)
infix fun Ushort.rem_(b: Vec4us) = rem(b, this, this, this, this, b)


operator fun Short.plus(b: Vec4us) = add(Vec4us(), b, this, this, this, this)
infix fun Short.add_(b: Vec4us) = add(b, b, this, this, this, this)

operator fun Short.minus(b: Vec4us) = sub(Vec4us(), this, this, this, this, b)
infix fun Short.sub_(b: Vec4us) = sub(b, this, this, this, this, b)

operator fun Short.times(b: Vec4us) = mul(Vec4us(), b, this, this, this, this)
infix fun Short.mul_(b: Vec4us) = mul(b, b, this, this, this, this)

operator fun Short.div(b: Vec4us) = div(Vec4us(), this, this, this, this, b)
infix fun Short.div_(b: Vec4us) = div(b, this, this, this, this, b)

operator fun Short.rem(b: Vec4us) = rem(Vec4us(), this, this, this, this, b)
infix fun Short.rem_(b: Vec4us) = rem(b, this, this, this, this, b)


operator fun Int.plus(b: Vec4us) = add(Vec4us(), b, this, this, this, this)
infix fun Int.add_(b: Vec4us) = add(b, b, this, this, this, this)

operator fun Int.minus(b: Vec4us) = sub(Vec4us(), this, this, this, this, b)
infix fun Int.sub_(b: Vec4us) = sub(b, this, this, this, this, b)

operator fun Int.times(b: Vec4us) = mul(Vec4us(), b, this, this, this, this)
infix fun Int.mul_(b: Vec4us) = mul(b, b, this, this, this, this)

operator fun Int.div(b: Vec4us) = div(Vec4us(), this, this, this, this, b)
infix fun Int.div_(b: Vec4us) = div(b, this, this, this, this, b)

operator fun Int.rem(b: Vec4us) = rem(Vec4us(), this, this, this, this, b)
infix fun Int.rem_(b: Vec4us) = rem(b, this, this, this, this, b)


// -- Generic binary arithmetic operators --

operator fun Number.plus(b: Vec4us) = add(Vec4us(), b, this.i, this.i, this.i, this.i)
infix fun Number.add_(b: Vec4us) = add(b, b, this.i, this.i, this.i, this.i)

operator fun Number.minus(b: Vec4us) = sub(Vec4us(), this.i, this.i, this.i, this.i, b)
infix fun Number.sub_(b: Vec4us) = sub(b, this.i, this.i, this.i, this.i, b)

operator fun Number.times(b: Vec4us) = mul(Vec4us(), b, this.i, this.i, this.i, this.i)
infix fun Number.mul_(b: Vec4us) = mul(b, b, this.i, this.i, this.i, this.i)

operator fun Number.div(b: Vec4us) = div(Vec4us(), this.i, this.i, this.i, this.i, b)
infix fun Number.div_(b: Vec4us) = div(b, this.i, this.i, this.i, this.i, b)

operator fun Number.rem(b: Vec4us) = rem(Vec4us(), this.i, this.i, this.i, this.i, b)
infix fun Number.rem_(b: Vec4us) = rem(b, this.i, this.i, this.i, this.i, b)