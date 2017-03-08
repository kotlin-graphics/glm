package vec._4.operators

import glm.b
import glm.and
import glm.or
import glm.xor
import glm.shl
import glm.shr
import vec._4.Vec4b
import vec._4.Vec4b.Companion.add
import vec._4.Vec4b.Companion.div
import vec._4.Vec4b.Companion.mul
import vec._4.Vec4b.Companion.rem
import vec._4.Vec4b.Companion.sub
import kotlin.experimental.inv

/**
 * Created by GBarbieri on 08.11.2016.
 */
interface vec4b_operators {

    fun add(res: Vec4b, a: Vec4b, bX: Byte, bY: Byte, bZ: Byte, bW: Byte): Vec4b {
        res.x = (a.x + bX).b
        res.y = (a.y + bY).b
        res.z = (a.z + bZ).b
        res.w = (a.w + bW).b
        return res
    }

    fun add(res: Vec4b, a: Vec4b, bX: Int, bY: Int, bZ: Int, bW: Int): Vec4b {
        res.x = (a.x + bX).b
        res.y = (a.y + bY).b
        res.z = (a.z + bZ).b
        res.w = (a.w + bW).b
        return res
    }

    fun sub(res: Vec4b, a: Vec4b, bX: Byte, bY: Byte, bZ: Byte, bW: Byte): Vec4b {
        res.x = (a.x - bX).b
        res.y = (a.y - bY).b
        res.z = (a.z - bZ).b
        res.w = (a.w - bW).b
        return res
    }

    fun sub(res: Vec4b, a: Vec4b, bX: Int, bY: Int, bZ: Int, bW: Int): Vec4b {
        res.x = (a.x - bX).b
        res.y = (a.y - bY).b
        res.z = (a.z - bZ).b
        res.w = (a.w - bW).b
        return res
    }

    fun sub(res: Vec4b, aX: Byte, aY: Byte, aZ: Byte, aW: Byte, b: Vec4b): Vec4b {
        res.x = (aX - b.x).b
        res.y = (aY - b.y).b
        res.z = (aZ - b.z).b
        res.w = (aW - b.w).b
        return res
    }

    fun sub(res: Vec4b, aX: Int, aY: Int, aZ: Int, aW: Int, b: Vec4b): Vec4b {
        res.x = (aX - b.x).b
        res.y = (aY - b.y).b
        res.z = (aZ - b.z).b
        res.w = (aW - b.w).b
        return res
    }

    fun mul(res: Vec4b, a: Vec4b, bX: Byte, bY: Byte, bZ: Byte, bW: Byte): Vec4b {
        res.x = (a.x * bX).b
        res.y = (a.y * bY).b
        res.z = (a.z * bZ).b
        res.w = (a.w * bW).b
        return res
    }

    fun mul(res: Vec4b, a: Vec4b, bX: Int, bY: Int, bZ: Int, bW: Int): Vec4b {
        res.x = (a.x * bX).b
        res.y = (a.y * bY).b
        res.z = (a.z * bZ).b
        res.w = (a.w * bW).b
        return res
    }

    fun div(res: Vec4b, a: Vec4b, bX: Byte, bY: Byte, bZ: Byte, bW: Byte): Vec4b {
        res.x = (a.x / bX).b
        res.y = (a.y / bY).b
        res.z = (a.z / bZ).b
        res.w = (a.w / bW).b
        return res
    }

    fun div(res: Vec4b, a: Vec4b, bX: Int, bY: Int, bZ: Int, bW: Int): Vec4b {
        res.x = (a.x / bX).b
        res.y = (a.y / bY).b
        res.z = (a.z / bZ).b
        res.w = (a.w / bW).b
        return res
    }

    fun div(res: Vec4b, aX: Byte, aY: Byte, aZ: Byte, aW: Byte, b: Vec4b): Vec4b {
        res.x = (aX / b.x).b
        res.y = (aY / b.y).b
        res.z = (aZ / b.z).b
        res.w = (aW / b.w).b
        return res
    }

    fun div(res: Vec4b, aX: Int, aY: Int, aZ: Int, aW: Int, b: Vec4b): Vec4b {
        res.x = (aX / b.x).b
        res.y = (aY / b.y).b
        res.z = (aZ / b.z).b
        res.w = (aW / b.w).b
        return res
    }

    fun rem(res: Vec4b, a: Vec4b, bX: Byte, bY: Byte, bZ: Byte, bW: Byte): Vec4b {
        res.x = (a.x % bX).b
        res.y = (a.y % bY).b
        res.z = (a.z % bZ).b
        res.w = (a.w % bW).b
        return res
    }

    fun rem(res: Vec4b, a: Vec4b, bX: Int, bY: Int, bZ: Int, bW: Int): Vec4b {
        res.x = (a.x % bX).b
        res.y = (a.y % bY).b
        res.z = (a.z % bZ).b
        res.w = (a.w % bW).b
        return res
    }

    fun rem(res: Vec4b, aX: Byte, aY: Byte, aZ: Byte, aW: Byte, b: Vec4b): Vec4b {
        res.x = (aX % b.x).b
        res.y = (aY % b.y).b
        res.z = (aZ % b.z).b
        res.w = (aW % b.w).b
        return res
    }

    fun rem(res: Vec4b, aX: Int, aY: Int, aZ: Int, aW: Int, b: Vec4b): Vec4b {
        res.x = (aX % b.x).b
        res.y = (aY % b.y).b
        res.z = (aZ % b.z).b
        res.w = (aW % b.w).b
        return res
    }

    fun and(res: Vec4b, a: Vec4b, bX: Byte, bY: Byte, bZ: Byte, bW: Byte): Vec4b {
        res.x = a.x and bX
        res.y = a.y and bY
        res.z = a.z and bZ
        res.w = a.w and bW
        return res
    }

    fun and(res: Vec4b, a: Vec4b, bX: Int, bY: Int, bZ: Int, bW: Int): Vec4b {
        res.x = a.x and bX
        res.y = a.y and bY
        res.z = a.z and bZ
        res.w = a.w and bW
        return res
    }

    fun or(res: Vec4b, a: Vec4b, bX: Byte, bY: Byte, bZ: Byte, bW: Byte): Vec4b {
        res.x = a.x or bX
        res.y = a.y or bY
        res.z = a.z or bZ
        res.w = a.w or bW
        return res
    }

    fun or(res: Vec4b, a: Vec4b, bX: Int, bY: Int, bZ: Int, bW: Int): Vec4b {
        res.x = a.x or bX
        res.y = a.y or bY
        res.z = a.z or bZ
        res.w = a.w or bW
        return res
    }

    fun xor(res: Vec4b, a: Vec4b, bX: Byte, bY: Byte, bZ: Byte, bW: Byte): Vec4b {
        res.x = a.x xor bX
        res.y = a.y xor bY
        res.z = a.z xor bZ
        res.w = a.w xor bW
        return res
    }

    fun xor(res: Vec4b, a: Vec4b, bX: Int, bY: Int, bZ: Int, bW: Int): Vec4b {
        res.x = a.x xor bX
        res.y = a.y xor bY
        res.z = a.z xor bZ
        res.w = a.w xor bW
        return res
    }

    fun shl(res: Vec4b, a: Vec4b, bX: Byte, bY: Byte, bZ: Byte, bW: Byte): Vec4b {
        res.x = a.x shl bX
        res.y = a.y shl bY
        res.z = a.z shl bZ
        res.w = a.w shl bW
        return res
    }

    fun shl(res: Vec4b, a: Vec4b, bX: Int, bY: Int, bZ: Int, bW: Int): Vec4b {
        res.x = a.x shl bX
        res.y = a.y shl bY
        res.z = a.z shl bZ
        res.w = a.w shl bW
        return res
    }

    fun shr(res: Vec4b, a: Vec4b, bX: Byte, bY: Byte, bZ: Byte, bW: Byte): Vec4b {
        res.x = a.x shr bX
        res.y = a.y shr bY
        res.z = a.z shr bZ
        res.w = a.w shr bW
        return res
    }

    fun shr(res: Vec4b, a: Vec4b, bX: Int, bY: Int, bZ: Int, bW: Int): Vec4b {
        res.x = a.x shr bX
        res.y = a.y shr bY
        res.z = a.z shr bZ
        res.w = a.w shr bW
        return res
    }

    fun inv(res: Vec4b, a: Vec4b): Vec4b {
        res.x = a.x.inv()
        res.y = a.y.inv()
        res.z = a.z.inv()
        res.w = a.w.inv()
        return res
    }
}


// -- Specific binary arithmetic operators --

operator fun Byte.plus(b: Vec4b) = add(Vec4b(), b, this, this, this, this)
fun Byte.add(b: Vec4b, res: Vec4b = Vec4b()) = add(res, b, this, this, this, this)
infix fun Byte.add_(b: Vec4b) = add(b, b, this, this, this, this)

operator fun Byte.minus(b: Vec4b) = sub(Vec4b(), this, this, this, this, b)
fun Byte.sub(b: Vec4b, res: Vec4b = Vec4b()) = sub(res, b, this, this, this, this)
infix fun Byte.sub_(b: Vec4b) = sub(b, this, this, this, this, b)

operator fun Byte.times(b: Vec4b) = mul(Vec4b(), b, this, this, this, this)
fun Byte.mul(b: Vec4b, res: Vec4b = Vec4b()) = mul(res, b, this, this, this, this)
infix fun Byte.mul_(b: Vec4b) = mul(b, b, this, this, this, this)

operator fun Byte.div(b: Vec4b) = div(Vec4b(), this, this, this, this, b)
fun Byte.div(b: Vec4b, res: Vec4b) = div(res, b, this, this, this, this)
infix fun Byte.div_(b: Vec4b) = div(b, this, this, this, this, b)

operator fun Byte.rem(b: Vec4b) = rem(Vec4b(), this, this, this, this, b)
fun Byte.rem(b: Vec4b, res: Vec4b) = rem(res, b, this, this, this, this)
infix fun Byte.rem_(b: Vec4b) = rem(b, this, this, this, this, b)


operator fun Int.plus(b: Vec4b) = add(Vec4b(), b, this, this, this, this)
fun Int.add(b: Vec4b, res: Vec4b = Vec4b()) = add(res, b, this, this, this, this)
infix fun Int.add_(b: Vec4b) = add(b, b, this, this, this, this)

operator fun Int.minus(b: Vec4b) = sub(Vec4b(), this, this, this, this, b)
fun Int.sub(b: Vec4b, res: Vec4b = Vec4b()) = sub(res, b, this, this, this, this)
infix fun Int.sub_(b: Vec4b) = sub(b, this, this, this, this, b)

operator fun Int.times(b: Vec4b) = mul(Vec4b(), b, this, this, this, this)
fun Int.mul(b: Vec4b, res: Vec4b = Vec4b()) = mul(res, b, this, this, this, this)
infix fun Int.mul_(b: Vec4b) = mul(b, b, this, this, this, this)

operator fun Int.div(b: Vec4b) = div(Vec4b(), this, this, this, this, b)
fun Int.div(b: Vec4b, res: Vec4b) = div(res, b, this, this, this, this)
infix fun Int.div_(b: Vec4b) = div(b, this, this, this, this, b)

operator fun Int.rem(b: Vec4b) = rem(Vec4b(), this, this, this, this, b)
fun Int.rem(b: Vec4b, res: Vec4b) = rem(res, b, this, this, this, this)
infix fun Int.rem_(b: Vec4b) = rem(b, this, this, this, this, b)


// -- Generic binary arithmetic operators --

operator fun Number.plus(b: Vec4b) = add(Vec4b(), b, this.b, this.b, this.b, this.b)
fun Number.add(b: Vec4b, res: Vec4b = Vec4b()) = add(res, b, this.b, this.b, this.b, this.b)
infix fun Number.add_(b: Vec4b) = add(b, b, this.b, this.b, this.b, this.b)

operator fun Number.minus(b: Vec4b) = sub(Vec4b(), this.b, this.b, this.b, this.b, b)
fun Number.sub(b: Vec4b, res: Vec4b = Vec4b()) = sub(res, b, this.b, this.b, this.b, this.b)
infix fun Number.sub_(b: Vec4b) = sub(b, this.b, this.b, this.b, this.b, b)

operator fun Number.times(b: Vec4b) = mul(Vec4b(), b, this.b, this.b, this.b, this.b)
fun Number.mul(b: Vec4b, res: Vec4b = Vec4b()) = mul(res, b, this.b, this.b, this.b, this.b)
infix fun Number.mul_(b: Vec4b) = mul(b, b, this.b, this.b, this.b, this.b)

operator fun Number.div(b: Vec4b) = div(Vec4b(), this.b, this.b, this.b, this.b, b)
fun Number.div(b: Vec4b, res: Vec4b) = div(res, b, this.b, this.b, this.b, this.b)
infix fun Number.div_(b: Vec4b) = div(b, this.b, this.b, this.b, this.b, b)

operator fun Number.rem(b: Vec4b) = rem(Vec4b(), this.b, this.b, this.b, this.b, b)
fun Number.rem(b: Vec4b, res: Vec4b) = rem(res, b, this.b, this.b, this.b, this.b)
infix fun Number.rem_(b: Vec4b) = rem(b, this.b, this.b, this.b, this.b, b)