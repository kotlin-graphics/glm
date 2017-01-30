package vec._3.operators

import main.and
import main.b
import main.or
import main.shl
import main.shr
import vec._3.Vec3b
import vec._3.Vec3b.Companion.add
import vec._3.Vec3b.Companion.div
import vec._3.Vec3b.Companion.mul
import vec._3.Vec3b.Companion.rem
import vec._3.Vec3b.Companion.sub
import main.xor

/**
 * Created by GBarbieri on 08.11.2016.
 */
interface vec3b_operators {

    fun add(res: Vec3b, a: Vec3b, bX: Byte, bY: Byte, bZ: Byte): Vec3b {
        res.x = (a.x + bX).b
        res.y = (a.y + bY).b
        res.z = (a.z + bZ).b
        return res
    }

    fun add(res: Vec3b, a: Vec3b, bX: Int, bY: Int, bZ: Int): Vec3b {
        res.x = (a.x + bX).b
        res.y = (a.y + bY).b
        res.z = (a.z + bZ).b
        return res
    }

    fun sub(res: Vec3b, a: Vec3b, bX: Byte, bY: Byte, bZ: Byte): Vec3b {
        res.x = (a.x - bX).b
        res.y = (a.y - bY).b
        res.z = (a.z - bZ).b
        return res
    }

    fun sub(res: Vec3b, a: Vec3b, bX: Int, bY: Int, bZ: Int): Vec3b {
        res.x = (a.x - bX).b
        res.y = (a.y - bY).b
        res.z = (a.z - bZ).b
        return res
    }

    fun sub(res: Vec3b, aX: Byte, aY: Byte, aZ: Byte, b: Vec3b): Vec3b {
        res.x = (aX - b.x).b
        res.y = (aY - b.y).b
        res.z = (aZ - b.z).b
        return res
    }

    fun sub(res: Vec3b, aX: Int, aY: Int, aZ: Int, b: Vec3b): Vec3b {
        res.x = (aX - b.x).b
        res.y = (aY - b.y).b
        res.z = (aZ - b.z).b
        return res
    }

    fun mul(res: Vec3b, a: Vec3b, bX: Byte, bY: Byte, bZ: Byte): Vec3b {
        res.x = (a.x * bX).b
        res.y = (a.y * bY).b
        res.z = (a.z * bZ).b
        return res
    }

    fun mul(res: Vec3b, a: Vec3b, bX: Int, bY: Int, bZ: Int): Vec3b {
        res.x = (a.x * bX).b
        res.y = (a.y * bY).b
        res.z = (a.z * bZ).b
        return res
    }

    fun div(res: Vec3b, a: Vec3b, bX: Byte, bY: Byte, bZ: Byte): Vec3b {
        res.x = (a.x / bX).b
        res.y = (a.y / bY).b
        res.z = (a.z / bZ).b
        return res
    }

    fun div(res: Vec3b, a: Vec3b, bX: Int, bY: Int, bZ: Int): Vec3b {
        res.x = (a.x / bX).b
        res.y = (a.y / bY).b
        res.z = (a.z / bZ).b
        return res
    }

    fun div(res: Vec3b, aX: Byte, aY: Byte, aZ: Byte, b: Vec3b): Vec3b {
        res.x = (aX / b.x).b
        res.y = (aY / b.y).b
        res.z = (aZ / b.z).b
        return res
    }

    fun div(res: Vec3b, aX: Int, aY: Int, aZ: Int, b: Vec3b): Vec3b {
        res.x = (aX / b.x).b
        res.y = (aY / b.y).b
        res.z = (aZ / b.z).b
        return res
    }

    fun rem(res: Vec3b, a: Vec3b, bX: Byte, bY: Byte, bZ: Byte): Vec3b {
        res.x = (a.x % bX).b
        res.y = (a.y % bY).b
        res.z = (a.z % bZ).b
        return res
    }

    fun rem(res: Vec3b, a: Vec3b, bX: Int, bY: Int, bZ: Int): Vec3b {
        res.x = (a.x % bX).b
        res.y = (a.y % bY).b
        res.z = (a.z % bZ).b
        return res
    }

    fun rem(res: Vec3b, aX: Byte, aY: Byte, aZ: Byte, b: Vec3b): Vec3b {
        res.x = (aX % b.x).b
        res.y = (aY % b.y).b
        res.z = (aZ % b.z).b
        return res
    }

    fun rem(res: Vec3b, aX: Int, aY: Int, aZ: Int, b: Vec3b): Vec3b {
        res.x = (aX % b.x).b
        res.y = (aY % b.y).b
        res.z = (aZ % b.z).b
        return res
    }

    fun and(res: Vec3b, a: Vec3b, bX: Byte, bY: Byte, bZ: Byte): Vec3b {
        res.x = a.x and bX
        res.y = a.y and bY
        res.z = a.z and bZ
        return res
    }

    fun and(res: Vec3b, a: Vec3b, bX: Int, bY: Int, bZ: Int): Vec3b {
        res.x = a.x and bX
        res.y = a.y and bY
        res.z = a.z and bZ
        return res
    }

    fun or(res: Vec3b, a: Vec3b, bX: Byte, bY: Byte, bZ: Byte): Vec3b {
        res.x = a.x or bX
        res.y = a.y or bY
        res.z = a.z or bZ
        return res
    }

    fun or(res: Vec3b, a: Vec3b, bX: Int, bY: Int, bZ: Int): Vec3b {
        res.x = a.x or bX
        res.y = a.y or bY
        res.z = a.z or bZ
        return res
    }

    fun xor(res: Vec3b, a: Vec3b, bX: Byte, bY: Byte, bZ: Byte): Vec3b {
        res.x = a.x xor bX
        res.y = a.y xor bY
        res.z = a.z xor bZ
        return res
    }

    fun xor(res: Vec3b, a: Vec3b, bX: Int, bY: Int, bZ: Int): Vec3b {
        res.x = a.x xor bX
        res.y = a.y xor bY
        res.z = a.z xor bZ
        return res
    }

    fun shl(res: Vec3b, a: Vec3b, bX: Byte, bY: Byte, bZ: Byte): Vec3b {
        res.x = a.x shl bX
        res.y = a.y shl bY
        res.z = a.z shl bZ
        return res
    }

    fun shl(res: Vec3b, a: Vec3b, bX: Int, bY: Int, bZ: Int): Vec3b {
        res.x = a.x shl bX
        res.y = a.y shl bY
        res.z = a.z shl bZ
        return res
    }

    fun shr(res: Vec3b, a: Vec3b, bX: Byte, bY: Byte, bZ: Byte): Vec3b {
        res.x = a.x shr bX
        res.y = a.y shr bY
        res.z = a.z shr bZ
        return res
    }

    fun shr(res: Vec3b, a: Vec3b, bX: Int, bY: Int, bZ: Int): Vec3b {
        res.x = a.x shr bX
        res.y = a.y shr bY
        res.z = a.z shr bZ
        return res
    }

    fun inv(res: Vec3b, a: Vec3b): Vec3b {
        res.x = a.x.inv()
        res.y = a.y.inv()
        res.z = a.z.inv()
        return res
    }
}


// -- Specific binary arithmetic operators --

operator fun Byte.plus(b: Vec3b) = add(Vec3b(), b, this, this, this)
fun Byte.add(b: Vec3b, res: Vec3b = Vec3b()) = add(res, b, this, this, this)
infix fun Byte.add_(b: Vec3b) = add(b, b, this, this, this)

operator fun Byte.minus(b: Vec3b) = sub(Vec3b(), this, this, this, b)
fun Byte.sub(b: Vec3b, res: Vec3b = Vec3b()) = sub(res, b, this, this, this)
infix fun Byte.sub_(b: Vec3b) = sub(b, this, this, this, b)

operator fun Byte.times(b: Vec3b) = mul(Vec3b(), b, this, this, this)
fun Byte.mul(b: Vec3b, res: Vec3b = Vec3b()) = mul(res, b, this, this, this)
infix fun Byte.mul_(b: Vec3b) = mul(b, b, this, this, this)

operator fun Byte.div(b: Vec3b) = div(Vec3b(), this, this, this, b)
fun Byte.div(b: Vec3b, res: Vec3b) = div(res, b, this, this, this)
infix fun Byte.div_(b: Vec3b) = div(b, this, this, this, b)

operator fun Byte.rem(b: Vec3b) = rem(Vec3b(), this, this, this, b)
fun Byte.rem(b: Vec3b, res: Vec3b) = rem(res, b, this, this, this)
infix fun Byte.rem_(b: Vec3b) = rem(b, this, this, this, b)


operator fun Int.plus(b: Vec3b) = add(Vec3b(), b, this, this, this)
fun Int.add(b: Vec3b, res: Vec3b = Vec3b()) = add(res, b, this, this, this)
infix fun Int.add_(b: Vec3b) = add(b, b, this, this, this)

operator fun Int.minus(b: Vec3b) = sub(Vec3b(), this, this, this, b)
fun Int.sub(b: Vec3b, res: Vec3b = Vec3b()) = sub(res, b, this, this, this)
infix fun Int.sub_(b: Vec3b) = sub(b, this, this, this, b)

operator fun Int.times(b: Vec3b) = mul(Vec3b(), b, this, this, this)
fun Int.mul(b: Vec3b, res: Vec3b = Vec3b()) = mul(res, b, this, this, this)
infix fun Int.mul_(b: Vec3b) = mul(b, b, this, this, this)

operator fun Int.div(b: Vec3b) = div(Vec3b(), this, this, this, b)
fun Int.div(b: Vec3b, res: Vec3b) = div(res, b, this, this, this)
infix fun Int.div_(b: Vec3b) = div(b, this, this, this, b)

operator fun Int.rem(b: Vec3b) = rem(Vec3b(), this, this, this, b)
fun Int.rem(b: Vec3b, res: Vec3b) = rem(res, b, this, this, this)
infix fun Int.rem_(b: Vec3b) = rem(b, this, this, this, b)


// -- Generic binary arithmetic operators --

operator fun Number.plus(b: Vec3b) = add(Vec3b(), b, this.b, this.b, this.b)
fun Number.add(b: Vec3b, res: Vec3b = Vec3b()) = add(res, b, this.b, this.b, this.b)
infix fun Number.add_(b: Vec3b) = add(b, b, this.b, this.b, this.b)

operator fun Number.minus(b: Vec3b) = sub(Vec3b(), this.b, this.b, this.b, b)
fun Number.sub(b: Vec3b, res: Vec3b = Vec3b()) = sub(res, b, this.b, this.b, this.b)
infix fun Number.sub_(b: Vec3b) = sub(b, this.b, this.b, this.b, b)

operator fun Number.times(b: Vec3b) = mul(Vec3b(), b, this.b, this.b, this.b)
fun Number.mul(b: Vec3b, res: Vec3b = Vec3b()) = mul(res, b, this.b, this.b, this.b)
infix fun Number.mul_(b: Vec3b) = mul(b, b, this.b, this.b, this.b)

operator fun Number.div(b: Vec3b) = div(Vec3b(), this.b, this.b, this.b, b)
fun Number.div(b: Vec3b, res: Vec3b) = div(res, b, this.b, this.b, this.b)
infix fun Number.div_(b: Vec3b) = div(b, this.b, this.b, this.b, b)

operator fun Number.rem(b: Vec3b) = rem(Vec3b(), this.b, this.b, this.b, b)
fun Number.rem(b: Vec3b, res: Vec3b) = rem(res, b, this.b, this.b, this.b)
infix fun Number.rem_(b: Vec3b) = rem(b, this.b, this.b, this.b, b)