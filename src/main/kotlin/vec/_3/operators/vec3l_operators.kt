package vec._3.operators

import glm.L
import glm.i
import vec._3.Vec3l
import vec._3.Vec3l.Companion.add
import vec._3.Vec3l.Companion.div
import vec._3.Vec3l.Companion.mul
import vec._3.Vec3l.Companion.rem
import vec._3.Vec3l.Companion.sub

/**
 * Created by GBarbieri on 08.11.2016.
 */
interface vec3l_operators {

    fun add(res: Vec3l, a: Vec3l, bX: Long, bY: Long, bZ: Long): Vec3l {
        res.x = a.x + bX
        res.y = a.y + bY
        res.z = a.z + bZ
        return res
    }

    fun sub(res: Vec3l, a: Vec3l, bX: Long, bY: Long, bZ: Long): Vec3l {
        res.x = a.x - bX
        res.y = a.y - bY
        res.z = a.z - bZ
        return res
    }

    fun sub(res: Vec3l, aX: Long, aY: Long, aZ: Long, b: Vec3l): Vec3l {
        res.x = aX - b.x
        res.y = aY - b.y
        res.z = aZ - b.z
        return res
    }

    fun mul(res: Vec3l, a: Vec3l, bX: Long, bY: Long, bZ: Long): Vec3l {
        res.x = a.x * bX
        res.y = a.y * bY
        res.z = a.z * bZ
        return res
    }

    fun div(res: Vec3l, a: Vec3l, bX: Long, bY: Long, bZ: Long): Vec3l {
        res.x = a.x / bX
        res.y = a.y / bY
        res.z = a.z / bZ
        return res
    }

    fun div(res: Vec3l, aX: Long, aY: Long, aZ: Long, b: Vec3l): Vec3l {
        res.x = aX / b.x
        res.y = aY / b.y
        res.z = aZ / b.z
        return res
    }

    fun rem(res: Vec3l, a: Vec3l, bX: Long, bY: Long, bZ: Long): Vec3l {
        res.x = a.x % bX
        res.y = a.y % bY
        res.z = a.z % bZ
        return res
    }

    fun rem(res: Vec3l, aX: Long, aY: Long, aZ: Long, b: Vec3l): Vec3l {
        res.x = aX % b.x
        res.y = aY % b.y
        res.z = aZ % b.z
        return res
    }

    fun and(res: Vec3l, a: Vec3l, bX: Long, bY: Long, bZ: Long): Vec3l {
        res.x = a.x and bX
        res.y = a.y and bY
        res.z = a.z and bZ
        return res
    }

    fun or(res: Vec3l, a: Vec3l, bX: Long, bY: Long, bZ: Long): Vec3l {
        res.x = a.x or bX
        res.y = a.y or bY
        res.z = a.z or bZ
        return res
    }

    fun xor(res: Vec3l, a: Vec3l, bX: Long, bY: Long, bZ: Long): Vec3l {
        res.x = a.x xor bX
        res.y = a.y xor bY
        res.z = a.z xor bZ
        return res
    }

    fun shl(res: Vec3l, a: Vec3l, bX: Long, bY: Long, bZ: Long): Vec3l {
        res.x = a.x shl bX.i
        res.y = a.y shl bY.i
        res.z = a.z shl bZ.i
        return res
    }

    fun shl(res: Vec3l, a: Vec3l, bX: Int, bY: Int, bZ: Int): Vec3l {
        res.x = a.x shl bX
        res.y = a.y shl bY
        res.z = a.z shl bZ
        return res
    }

    fun shr(res: Vec3l, a: Vec3l, bX: Long, bY: Long, bZ: Long): Vec3l {
        res.x = a.x shr bX.i
        res.y = a.y shr bY.i
        res.z = a.z shr bZ.i
        return res
    }

    fun shr(res: Vec3l, a: Vec3l, bX: Int, bY: Int, bZ: Int): Vec3l {
        res.x = a.x shr bX
        res.y = a.y shr bY
        res.z = a.z shr bZ
        return res
    }

    fun inv(res: Vec3l, a: Vec3l): Vec3l {
        res.x = a.x.inv()
        res.y = a.y.inv()
        res.z = a.z.inv()
        return res
    }
}


// -- Specific binary arithmetic operators --

operator fun Long.plus(b: Vec3l) = add(Vec3l(), b, this, this, this)
fun Long.add(b: Vec3l, res: Vec3l = Vec3l()) = add(res, b, this, this, this)
infix fun Long.add_(b: Vec3l) = add(b, b, this, this, this)

operator fun Long.minus(b: Vec3l) = sub(Vec3l(), this, this, this, b)
fun Long.sub(b: Vec3l, res: Vec3l = Vec3l()) = sub(res, b, this, this, this)
infix fun Long.sub_(b: Vec3l) = sub(b, this, this, this, b)

operator fun Long.times(b: Vec3l) = mul(Vec3l(), b, this, this, this)
fun Long.mul(b: Vec3l, res: Vec3l = Vec3l()) = mul(res, b, this, this, this)
infix fun Long.mul_(b: Vec3l) = mul(b, b, this, this, this)

operator fun Long.div(b: Vec3l) = div(Vec3l(), this, this, this, b)
fun Long.div(b: Vec3l, res: Vec3l) = div(res, b, this, this, this)
infix fun Long.div_(b: Vec3l) = div(b, this, this, this, b)

operator fun Long.rem(b: Vec3l) = rem(Vec3l(), this, this, this, b)
fun Long.rem(b: Vec3l, res: Vec3l) = rem(res, b, this, this, this)
infix fun Long.rem_(b: Vec3l) = rem(b, this, this, this, b)


// -- Generic binary arithmetic operators --

operator fun Number.plus(b: Vec3l) = add(Vec3l(), b, this.L, this.L, this.L)
fun Number.add(b: Vec3l, res: Vec3l = Vec3l()) = add(res, b, this.L, this.L, this.L)
infix fun Number.add_(b: Vec3l) = add(b, b, this.L, this.L, this.L)

operator fun Number.minus(b: Vec3l) = sub(Vec3l(), this.L, this.L, this.L, b)
fun Number.sub(b: Vec3l, res: Vec3l = Vec3l()) = sub(res, b, this.L, this.L, this.L)
infix fun Number.sub_(b: Vec3l) = sub(b, this.L, this.L, this.L, b)

operator fun Number.times(b: Vec3l) = mul(Vec3l(), b, this.L, this.L, this.L)
fun Number.mul(b: Vec3l, res: Vec3l = Vec3l()) = mul(res, b, this.L, this.L, this.L)
infix fun Number.mul_(b: Vec3l) = mul(b, b, this.L, this.L, this.L)

operator fun Number.div(b: Vec3l) = div(Vec3l(), this.L, this.L, this.L, b)
fun Number.div(b: Vec3l, res: Vec3l) = div(res, b, this.L, this.L, this.L)
infix fun Number.div_(b: Vec3l) = div(b, this.L, this.L, this.L, b)

operator fun Number.rem(b: Vec3l) = rem(Vec3l(), this.L, this.L, this.L, b)
fun Number.rem(b: Vec3l, res: Vec3l) = rem(res, b, this.L, this.L, this.L)
infix fun Number.rem_(b: Vec3l) = rem(b, this.L, this.L, this.L, b)