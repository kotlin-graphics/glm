package vec._3.operators

import glm.i
import vec._3.Vec3i
import vec._3.Vec3i.Companion.add
import vec._3.Vec3i.Companion.div
import vec._3.Vec3i.Companion.mul
import vec._3.Vec3i.Companion.rem
import vec._3.Vec3i.Companion.sub


/**
 * Created by GBarbieri on 08.11.2016.
 */
interface vec3i_operators {

    fun add(res: Vec3i, a: Vec3i, bX: Int, bY: Int, bZ: Int): Vec3i {
        res.x = a.x + bX
        res.y = a.y + bY
        res.z = a.z + bZ
        return res
    }

    fun sub(res: Vec3i, a: Vec3i, bX: Int, bY: Int, bZ: Int): Vec3i {
        res.x = a.x - bX
        res.y = a.y - bY
        res.z = a.z - bZ
        return res
    }

    fun sub(res: Vec3i, aX: Int, aY: Int, aZ: Int, b: Vec3i): Vec3i {
        res.x = aX - b.x
        res.y = aY - b.y
        res.z = aZ - b.z
        return res
    }

    fun mul(res: Vec3i, a: Vec3i, bX: Int, bY: Int, bZ: Int): Vec3i {
        res.x = a.x * bX
        res.y = a.y * bY
        res.z = a.z * bZ
        return res
    }

    fun div(res: Vec3i, a: Vec3i, bX: Int, bY: Int, bZ: Int): Vec3i {
        res.x = a.x / bX
        res.y = a.y / bY
        res.z = a.z / bZ
        return res
    }

    fun div(res: Vec3i, aX: Int, aY: Int, aZ: Int, b: Vec3i): Vec3i {
        res.x = aX / b.x
        res.y = aY / b.y
        res.z = aZ / b.z
        return res
    }

    fun rem(res: Vec3i, a: Vec3i, bX: Int, bY: Int, bZ: Int): Vec3i {
        res.x = a.x % bX
        res.y = a.y % bY
        res.z = a.z % bZ
        return res
    }

    fun rem(res: Vec3i, aX: Int, aY: Int, aZ: Int, b: Vec3i): Vec3i {
        res.x = aX % b.x
        res.y = aY % b.y
        res.z = aZ % b.z
        return res
    }

    fun and(res: Vec3i, a: Vec3i, bX: Int, bY: Int, bZ: Int): Vec3i {
        res.x = a.x and bX
        res.y = a.y and bY
        res.z = a.z and bZ
        return res
    }

    fun or(res: Vec3i, a: Vec3i, bX: Int, bY: Int, bZ: Int): Vec3i {
        res.x = a.x or bX
        res.y = a.y or bY
        res.z = a.z or bZ
        return res
    }

    fun xor(res: Vec3i, a: Vec3i, bX: Int, bY: Int, bZ: Int): Vec3i {
        res.x = a.x xor bX
        res.y = a.y xor bY
        res.z = a.z xor bZ
        return res
    }

    fun shl(res: Vec3i, a: Vec3i, bX: Int, bY: Int, bZ: Int): Vec3i {
        res.x = a.x shl bX
        res.y = a.y shl bY
        res.z = a.z shl bZ
        return res
    }

    fun shr(res: Vec3i, a: Vec3i, bX: Int, bY: Int, bZ: Int): Vec3i {
        res.x = a.x shr bX
        res.y = a.y shr bY
        res.z = a.z shr bZ
        return res
    }

    fun inv(res: Vec3i, a: Vec3i): Vec3i {
        res.x = a.x.inv()
        res.y = a.y.inv()
        res.z = a.z.inv()
        return res
    }
}


// -- Specific binary arithmetic operators --

operator fun Int.plus(b: Vec3i) = add(Vec3i(), b, this, this, this)
fun Int.add(b: Vec3i, res: Vec3i = Vec3i()) = add(res, b, this, this, this)
infix fun Int.add_(b: Vec3i) = add(b, b, this, this, this)

operator fun Int.minus(b: Vec3i) = sub(Vec3i(), this, this, this, b)
fun Int.sub(b: Vec3i, res: Vec3i = Vec3i()) = sub(res, b, this, this, this)
infix fun Int.sub_(b: Vec3i) = sub(b, this, this, this, b)

operator fun Int.times(b: Vec3i) = mul(Vec3i(), b, this, this, this)
fun Int.mul(b: Vec3i, res: Vec3i = Vec3i()) = mul(res, b, this, this, this)
infix fun Int.mul_(b: Vec3i) = mul(b, b, this, this, this)

operator fun Int.div(b: Vec3i) = div(Vec3i(), this, this, this, b)
fun Int.div(b: Vec3i, res: Vec3i) = div(res, b, this, this, this)
infix fun Int.div_(b: Vec3i) = div(b, this, this, this, b)

operator fun Int.rem(b: Vec3i) = rem(Vec3i(), this, this, this, b)
fun Int.rem(b: Vec3i, res: Vec3i) = rem(res, b, this, this, this)
infix fun Int.rem_(b: Vec3i) = rem(b, this, this, this, b)


// -- Generic binary arithmetic operators --

operator fun Number.plus(b: Vec3i) = add(Vec3i(), b, this.i, this.i, this.i)
fun Number.add(b: Vec3i, res: Vec3i = Vec3i()) = add(res, b, this.i, this.i, this.i)
infix fun Number.add_(b: Vec3i) = add(b, b, this.i, this.i, this.i)

operator fun Number.minus(b: Vec3i) = sub(Vec3i(), this.i, this.i, this.i, b)
fun Number.sub(b: Vec3i, res: Vec3i = Vec3i()) = sub(res, b, this.i, this.i, this.i)
infix fun Number.sub_(b: Vec3i) = sub(b, this.i, this.i, this.i, b)

operator fun Number.times(b: Vec3i) = mul(Vec3i(), b, this.i, this.i, this.i)
fun Number.mul(b: Vec3i, res: Vec3i = Vec3i()) = mul(res, b, this.i, this.i, this.i)
infix fun Number.mul_(b: Vec3i) = mul(b, b, this.i, this.i, this.i)

operator fun Number.div(b: Vec3i) = div(Vec3i(), this.i, this.i, this.i, b)
fun Number.div(b: Vec3i, res: Vec3i) = div(res, b, this.i, this.i, this.i)
infix fun Number.div_(b: Vec3i) = div(b, this.i, this.i, this.i, b)

operator fun Number.rem(b: Vec3i) = rem(Vec3i(), this.i, this.i, this.i, b)
fun Number.rem(b: Vec3i, res: Vec3i) = rem(res, b, this.i, this.i, this.i)
infix fun Number.rem_(b: Vec3i) = rem(b, this.i, this.i, this.i, b)