package vec._3.operators

import main.*
import unsigned.*
import vec._3.Vec3ul
import vec._3.Vec3ul.Companion.add
import vec._3.Vec3ul.Companion.div
import vec._3.Vec3ul.Companion.mul
import vec._3.Vec3ul.Companion.rem
import vec._3.Vec3ul.Companion.sub

/**
 * Created by elect on 09/11/16.
 */
interface vec3ul_operators {


    fun add(res: Vec3ul, a: Vec3ul, bX: Ulong, bY: Ulong, bZ: Ulong): Vec3ul {
        res.x.v = a.x.v + bX.v
        res.y.v = a.y.v + bY.v
        res.z.v = a.z.v + bZ.v
        return res
    }

    fun add(res: Vec3ul, a: Vec3ul, bX: Long, bY: Long, bZ: Long): Vec3ul {
        res.x.v = a.x.v + bX
        res.y.v = a.y.v + bY
        res.z.v = a.z.v + bZ
        return res
    }

    fun sub(res: Vec3ul, a: Vec3ul, bX: Ulong, bY: Ulong, bZ: Ulong): Vec3ul {
        res.x.v = a.x.v - bX.v
        res.y.v = a.y.v - bY.v
        res.z.v = a.z.v - bZ.v
        return res
    }

    fun sub(res: Vec3ul, a: Vec3ul, bX: Long, bY: Long, bZ: Long): Vec3ul {
        res.x.v = a.x.v - bX
        res.y.v = a.y.v - bY
        res.z.v = a.z.v - bZ
        return res
    }

    fun sub(res: Vec3ul, aX: Ulong, aY: Ulong, aZ: Ulong, b: Vec3ul): Vec3ul {
        res.x.v = aX.v - b.x.v
        res.y.v = aY.v - b.y.v
        res.z.v = aZ.v - b.z.v
        return res
    }

    fun sub(res: Vec3ul, aX: Long, aY: Long, aZ: Long, b: Vec3ul): Vec3ul {
        res.x.v = aX - b.x.v
        res.y.v = aY - b.y.v
        res.z.v = aZ - b.z.v
        return res
    }

    fun mul(res: Vec3ul, a: Vec3ul, bX: Ulong, bY: Ulong, bZ: Ulong): Vec3ul {
        res.x.v = a.x.v * bX.v
        res.y.v = a.y.v * bY.v
        res.z.v = a.z.v * bZ.v
        return res
    }

    fun mul(res: Vec3ul, a: Vec3ul, bX: Long, bY: Long, bZ: Long): Vec3ul {
        res.x.v = a.x.v * bX
        res.y.v = a.y.v * bY
        res.z.v = a.z.v * bZ
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

    fun shl(res: Vec3ul, a: Vec3ul, bX: Long, bY: Long, bZ: Long): Vec3ul {
        res.x.v = a.x.v shl bX.i
        res.y.v = a.y.v shl bY.i
        res.z.v = a.z.v shl bZ.i
        return res
    }

    fun shl(res: Vec3ul, a: Vec3ul, bX: Int, bY: Int, bZ: Int): Vec3ul {
        res.x.v = a.x.v shl bX
        res.y.v = a.y.v shl bY
        res.z.v = a.z.v shl bZ
        return res
    }

    fun shr(res: Vec3ul, a: Vec3ul, bX: Long, bY: Long, bZ: Long): Vec3ul {
        res.x.v = a.x.v ushr bX.i
        res.y.v = a.y.v ushr bY.i
        res.z.v = a.z.v ushr bZ.i
        return res
    }

    fun shr(res: Vec3ul, a: Vec3ul, bX: Int, bY: Int, bZ: Int): Vec3ul {
        res.x.v = a.x.v ushr bX
        res.y.v = a.y.v ushr bY
        res.z.v = a.z.v ushr bZ
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

operator fun Ulong.plus(b: Vec3ul) = add(Vec3ul(), b, this, this, this)
infix fun Ulong.add_(b: Vec3ul) = add(b, b, this, this, this)

operator fun Ulong.minus(b: Vec3ul) = sub(Vec3ul(), this, this, this, b)
infix fun Ulong.sub_(b: Vec3ul) = sub(b, this, this, this, b)

operator fun Ulong.times(b: Vec3ul) = mul(Vec3ul(), b, this, this, this)
infix fun Ulong.mul_(b: Vec3ul) = mul(b, b, this, this, this)

operator fun Ulong.div(b: Vec3ul) = div(Vec3ul(), this, this, this, b)
infix fun Ulong.div_(b: Vec3ul) = div(b, this, this, this, b)

operator fun Ulong.rem(b: Vec3ul) = rem(Vec3ul(), this, this, this, b)
infix fun Ulong.rem_(b: Vec3ul) = rem(b, this, this, this, b)


operator fun Long.plus(b: Vec3ul) = add(Vec3ul(), b, this, this, this)
infix fun Long.add_(b: Vec3ul) = add(b, b, this, this, this)

operator fun Long.minus(b: Vec3ul) = sub(Vec3ul(), this, this, this, b)
infix fun Long.sub_(b: Vec3ul) = sub(b, this, this, this, b)

operator fun Long.times(b: Vec3ul) = mul(Vec3ul(), b, this, this, this)
infix fun Long.mul_(b: Vec3ul) = mul(b, b, this, this, this)

operator fun Long.div(b: Vec3ul) = div(Vec3ul(), this, this, this, b)
infix fun Long.div_(b: Vec3ul) = div(b, this, this, this, b)

operator fun Long.rem(b: Vec3ul) = rem(Vec3ul(), this, this, this, b)
infix fun Long.rem_(b: Vec3ul) = rem(b, this, this, this, b)


// -- Generic binary arithmetic operators --

operator fun Number.plus(b: Vec3ul) = add(Vec3ul(), b, this.L, this.L, this.L)
infix fun Number.add_(b: Vec3ul) = add(b, b, this.L, this.L, this.L)

operator fun Number.minus(b: Vec3ul) = sub(Vec3ul(), this.L, this.L, this.L, b)
infix fun Number.sub_(b: Vec3ul) = sub(b, this.L, this.L, this.L, b)

operator fun Number.times(b: Vec3ul) = mul(Vec3ul(), b, this.L, this.L, this.L)
infix fun Number.mul_(b: Vec3ul) = mul(b, b, this.L, this.L, this.L)

operator fun Number.div(b: Vec3ul) = div(Vec3ul(), this.L, this.L, this.L, b)
infix fun Number.div_(b: Vec3ul) = div(b, this.L, this.L, this.L, b)

operator fun Number.rem(b: Vec3ul) = rem(Vec3ul(), this.L, this.L, this.L, b)
infix fun Number.rem_(b: Vec3ul) = rem(b, this.L, this.L, this.L, b)