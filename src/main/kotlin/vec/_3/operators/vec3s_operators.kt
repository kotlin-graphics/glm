package vec._3.operators

import main.and
import main.or
import main.s
import main.shl
import main.shr
import vec._3.Vec3s
import vec._3.Vec3s.Companion.add
import vec._3.Vec3s.Companion.div
import vec._3.Vec3s.Companion.mul
import vec._3.Vec3s.Companion.rem
import vec._3.Vec3s.Companion.sub
import main.xor

/**
 * Created by GBarbieri on 08.11.2016.
 */
interface vec3s_operators {

    fun add(res: Vec3s, a: Vec3s, bX: Short, bY: Short, bZ: Short): Vec3s {
        res.x = (a.x + bX).s
        res.y = (a.y + bY).s
        res.z = (a.z + bZ).s
        return res
    }

    fun add(res: Vec3s, a: Vec3s, bX: Int, bY: Int, bZ: Int): Vec3s {
        res.x = (a.x + bX).s
        res.y = (a.y + bY).s
        res.z = (a.z + bZ).s
        return res
    }

    fun sub(res: Vec3s, a: Vec3s, bX: Short, bY: Short, bZ: Short): Vec3s {
        res.x = (a.x - bX).s
        res.y = (a.y - bY).s
        res.z = (a.z - bZ).s
        return res
    }

    fun sub(res: Vec3s, a: Vec3s, bX: Int, bY: Int, bZ: Int): Vec3s {
        res.x = (a.x - bX).s
        res.y = (a.y - bY).s
        res.z = (a.z - bZ).s
        return res
    }

    fun sub(res: Vec3s, aX: Short, aY: Short, aZ: Short, b: Vec3s): Vec3s {
        res.x = (aX - b.x).s
        res.y = (aY - b.y).s
        res.z = (aZ - b.z).s
        return res
    }

    fun sub(res: Vec3s, aX: Int, aY: Int, aZ: Int, b: Vec3s): Vec3s {
        res.x = (aX - b.x).s
        res.y = (aY - b.y).s
        res.z = (aZ - b.z).s
        return res
    }

    fun mul(res: Vec3s, a: Vec3s, bX: Short, bY: Short, bZ: Short): Vec3s {
        res.x = (a.x * bX).s
        res.y = (a.y * bY).s
        res.z = (a.z * bZ).s
        return res
    }

    fun mul(res: Vec3s, a: Vec3s, bX: Int, bY: Int, bZ: Int): Vec3s {
        res.x = (a.x * bX).s
        res.y = (a.y * bY).s
        res.z = (a.z * bZ).s
        return res
    }

    fun div(res: Vec3s, a: Vec3s, bX: Short, bY: Short, bZ: Short): Vec3s {
        res.x = (a.x / bX).s
        res.y = (a.y / bY).s
        res.z = (a.z / bZ).s
        return res
    }

    fun div(res: Vec3s, a: Vec3s, bX: Int, bY: Int, bZ: Int): Vec3s {
        res.x = (a.x / bX).s
        res.y = (a.y / bY).s
        res.z = (a.z / bZ).s
        return res
    }

    fun div(res: Vec3s, aX: Short, aY: Short, aZ: Short, b: Vec3s): Vec3s {
        res.x = (aX / b.x).s
        res.y = (aY / b.y).s
        res.z = (aZ / b.z).s
        return res
    }

    fun div(res: Vec3s, aX: Int, aY: Int, aZ: Int, b: Vec3s): Vec3s {
        res.x = (aX / b.x).s
        res.y = (aY / b.y).s
        res.z = (aZ / b.z).s
        return res
    }

    fun rem(res: Vec3s, a: Vec3s, bX: Short, bY: Short, bZ: Short): Vec3s {
        res.x = (a.x % bX).s
        res.y = (a.y % bY).s
        res.z = (a.z % bZ).s
        return res
    }

    fun rem(res: Vec3s, a: Vec3s, bX: Int, bY: Int, bZ: Int): Vec3s {
        res.x = (a.x % bX).s
        res.y = (a.y % bY).s
        res.z = (a.z % bZ).s
        return res
    }

    fun rem(res: Vec3s, aX: Short, aY: Short, aZ: Short, b: Vec3s): Vec3s {
        res.x = (aX % b.x).s
        res.y = (aY % b.y).s
        res.z = (aZ % b.z).s
        return res
    }

    fun rem(res: Vec3s, aX: Int, aY: Int, aZ: Int, b: Vec3s): Vec3s {
        res.x = (aX % b.x).s
        res.y = (aY % b.y).s
        res.z = (aZ % b.z).s
        return res
    }

    fun and(res: Vec3s, a: Vec3s, bX: Short, bY: Short, bZ: Short): Vec3s {
        res.x = a.x and bX
        res.y = a.y and bY
        res.z = a.z and bZ
        return res
    }

    fun and(res: Vec3s, a: Vec3s, bX: Int, bY: Int, bZ: Int): Vec3s {
        res.x = a.x and bX
        res.y = a.y and bY
        res.z = a.z and bZ
        return res
    }

    fun or(res: Vec3s, a: Vec3s, bX: Short, bY: Short, bZ: Short): Vec3s {
        res.x = a.x or bX
        res.y = a.y or bY
        res.z = a.z or bZ
        return res
    }

    fun or(res: Vec3s, a: Vec3s, bX: Int, bY: Int, bZ: Int): Vec3s {
        res.x = a.x or bX
        res.y = a.y or bY
        res.z = a.z or bZ
        return res
    }

    fun xor(res: Vec3s, a: Vec3s, bX: Short, bY: Short, bZ: Short): Vec3s {
        res.x = a.x xor bX
        res.y = a.y xor bY
        res.z = a.z xor bZ
        return res
    }

    fun xor(res: Vec3s, a: Vec3s, bX: Int, bY: Int, bZ: Int): Vec3s {
        res.x = a.x xor bX
        res.y = a.y xor bY
        res.z = a.z xor bZ
        return res
    }

    fun shl(res: Vec3s, a: Vec3s, bX: Short, bY: Short, bZ: Short): Vec3s {
        res.x = a.x shl bX
        res.y = a.y shl bY
        res.z = a.z shl bZ
        return res
    }

    fun shl(res: Vec3s, a: Vec3s, bX: Int, bY: Int, bZ: Int): Vec3s {
        res.x = a.x shl bX
        res.y = a.y shl bY
        res.z = a.z shl bZ
        return res
    }

    fun shr(res: Vec3s, a: Vec3s, bX: Short, bY: Short, bZ: Short): Vec3s {
        res.x = a.x shr bX
        res.y = a.y shr bY
        res.z = a.z shr bZ
        return res
    }

    fun shr(res: Vec3s, a: Vec3s, bX: Int, bY: Int, bZ: Int): Vec3s {
        res.x = a.x shr bX
        res.y = a.y shr bY
        res.z = a.z shr bZ
        return res
    }

    fun inv(res: Vec3s, a: Vec3s): Vec3s {
        res.x = a.x.inv()
        res.y = a.y.inv()
        res.z = a.z.inv()
        return res
    }
}


// -- Specific binary arithmetic operators --

operator fun Short.plus(b: Vec3s) = add(Vec3s(), b, this, this, this)
fun Short.add(b: Vec3s, res: Vec3s = Vec3s()) = add(res, b, this, this, this)
infix fun Short.add_(b: Vec3s) = add(b, b, this, this, this)

operator fun Short.minus(b: Vec3s) = sub(Vec3s(), this, this, this, b)
fun Short.sub(b: Vec3s, res: Vec3s = Vec3s()) = sub(res, b, this, this, this)
infix fun Short.sub_(b: Vec3s) = sub(b, this, this, this, b)

operator fun Short.times(b: Vec3s) = mul(Vec3s(), b, this, this, this)
fun Short.mul(b: Vec3s, res: Vec3s = Vec3s()) = mul(res, b, this, this, this)
infix fun Short.mul_(b: Vec3s) = mul(b, b, this, this, this)

operator fun Short.div(b: Vec3s) = div(Vec3s(), this, this, this, b)
fun Short.div(b: Vec3s, res: Vec3s) = div(res, b, this, this, this)
infix fun Short.div_(b: Vec3s) = div(b, this, this, this, b)

operator fun Short.rem(b: Vec3s) = rem(Vec3s(), this, this, this, b)
fun Short.rem(b: Vec3s, res: Vec3s) = rem(res, b, this, this, this)
infix fun Short.rem_(b: Vec3s) = rem(b, this, this, this, b)


operator fun Int.plus(b: Vec3s) = add(Vec3s(), b, this, this, this)
fun Int.add(b: Vec3s, res: Vec3s = Vec3s()) = add(res, b, this, this, this)
infix fun Int.add_(b: Vec3s) = add(b, b, this, this, this)

operator fun Int.minus(b: Vec3s) = sub(Vec3s(), this, this, this, b)
fun Int.sub(b: Vec3s, res: Vec3s = Vec3s()) = sub(res, b, this, this, this)
infix fun Int.sub_(b: Vec3s) = sub(b, this, this, this, b)

operator fun Int.times(b: Vec3s) = mul(Vec3s(), b, this, this, this)
fun Int.mul(b: Vec3s, res: Vec3s = Vec3s()) = mul(res, b, this, this, this)
infix fun Int.mul_(b: Vec3s) = mul(b, b, this, this, this)

operator fun Int.div(b: Vec3s) = div(Vec3s(), this, this, this, b)
fun Int.div(b: Vec3s, res: Vec3s) = div(res, b, this, this, this)
infix fun Int.div_(b: Vec3s) = div(b, this, this, this, b)

operator fun Int.rem(b: Vec3s) = rem(Vec3s(), this, this, this, b)
fun Int.rem(b: Vec3s, res: Vec3s) = rem(res, b, this, this, this)
infix fun Int.rem_(b: Vec3s) = rem(b, this, this, this, b)


// -- Specific binary arithmetic operators --

operator fun Number.plus(b: Vec3s) = add(Vec3s(), b, this.s, this.s, this.s)
fun Number.add(b: Vec3s, res: Vec3s = Vec3s()) = add(res, b, this.s, this.s, this.s)
infix fun Number.add_(b: Vec3s) = add(b, b, this.s, this.s, this.s)

operator fun Number.minus(b: Vec3s) = sub(Vec3s(), this.s, this.s, this.s, b)
fun Number.sub(b: Vec3s, res: Vec3s = Vec3s()) = sub(res, b, this.s, this.s, this.s)
infix fun Number.sub_(b: Vec3s) = sub(b, this.s, this.s, this.s, b)

operator fun Number.times(b: Vec3s) = mul(Vec3s(), b, this.s, this.s, this.s)
fun Number.mul(b: Vec3s, res: Vec3s = Vec3s()) = mul(res, b, this.s, this.s, this.s)
infix fun Number.mul_(b: Vec3s) = mul(b, b, this.s, this.s, this.s)

operator fun Number.div(b: Vec3s) = div(Vec3s(), this.s, this.s, this.s, b)
fun Number.div(b: Vec3s, res: Vec3s) = div(res, b, this.s, this.s, this.s)
infix fun Number.div_(b: Vec3s) = div(b, this.s, this.s, this.s, b)

operator fun Number.rem(b: Vec3s) = rem(Vec3s(), this.s, this.s, this.s, b)
fun Number.rem(b: Vec3s, res: Vec3s) = rem(res, b, this.s, this.s, this.s)
infix fun Number.rem_(b: Vec3s) = rem(b, this.s, this.s, this.s, b)