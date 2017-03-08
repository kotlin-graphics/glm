package vec._4.operators

import glm.s
import glm.and
import glm.or
import glm.xor
import glm.shl
import glm.shr
import vec._4.Vec4s
import vec._4.Vec4s.Companion.add
import vec._4.Vec4s.Companion.div
import vec._4.Vec4s.Companion.mul
import vec._4.Vec4s.Companion.rem
import vec._4.Vec4s.Companion.sub
import kotlin.experimental.inv

/**
 * Created by GBarbieri on 08.11.2016.
 */
interface vec4s_operators {

    fun add(res: Vec4s, a: Vec4s, bX: Short, bY: Short, bZ: Short, bW: Short): Vec4s {
        res.x = (a.x + bX).s
        res.y = (a.y + bY).s
        res.z = (a.z + bZ).s
        res.w = (a.w + bW).s
        return res
    }

    fun add(res: Vec4s, a: Vec4s, bX: Int, bY: Int, bZ: Int, bW: Int): Vec4s {
        res.x = (a.x + bX).s
        res.y = (a.y + bY).s
        res.z = (a.z + bZ).s
        res.w = (a.w + bW).s
        return res
    }

    fun sub(res: Vec4s, a: Vec4s, bX: Short, bY: Short, bZ: Short, bW: Short): Vec4s {
        res.x = (a.x - bX).s
        res.y = (a.y - bY).s
        res.z = (a.z - bZ).s
        res.w = (a.w - bW).s
        return res
    }

    fun sub(res: Vec4s, a: Vec4s, bX: Int, bY: Int, bZ: Int, bW: Int): Vec4s {
        res.x = (a.x - bX).s
        res.y = (a.y - bY).s
        res.z = (a.z - bZ).s
        res.w = (a.w - bW).s
        return res
    }

    fun sub(res: Vec4s, aX: Short, aY: Short, aZ: Short, aW: Short, b: Vec4s): Vec4s {
        res.x = (aX - b.x).s
        res.y = (aY - b.y).s
        res.z = (aZ - b.z).s
        res.w = (aW - b.w).s
        return res
    }

    fun sub(res: Vec4s, aX: Int, aY: Int, aZ: Int, aW: Int, b: Vec4s): Vec4s {
        res.x = (aX - b.x).s
        res.y = (aY - b.y).s
        res.z = (aZ - b.z).s
        res.w = (aW - b.w).s
        return res
    }

    fun mul(res: Vec4s, a: Vec4s, bX: Short, bY: Short, bZ: Short, bW: Short): Vec4s {
        res.x = (a.x * bX).s
        res.y = (a.y * bY).s
        res.z = (a.z * bZ).s
        res.w = (a.w * bW).s
        return res
    }

    fun mul(res: Vec4s, a: Vec4s, bX: Int, bY: Int, bZ: Int, bW: Int): Vec4s {
        res.x = (a.x * bX).s
        res.y = (a.y * bY).s
        res.z = (a.z * bZ).s
        res.w = (a.w * bW).s
        return res
    }

    fun div(res: Vec4s, a: Vec4s, bX: Short, bY: Short, bZ: Short, bW: Short): Vec4s {
        res.x = (a.x / bX).s
        res.y = (a.y / bY).s
        res.z = (a.z / bZ).s
        res.w = (a.w / bW).s
        return res
    }

    fun div(res: Vec4s, a: Vec4s, bX: Int, bY: Int, bZ: Int, bW: Int): Vec4s {
        res.x = (a.x / bX).s
        res.y = (a.y / bY).s
        res.z = (a.z / bZ).s
        res.w = (a.w / bW).s
        return res
    }

    fun div(res: Vec4s, aX: Short, aY: Short, aZ: Short, aW: Short, b: Vec4s): Vec4s {
        res.x = (aX / b.x).s
        res.y = (aY / b.y).s
        res.z = (aZ / b.z).s
        res.w = (aW / b.w).s
        return res
    }

    fun div(res: Vec4s, aX: Int, aY: Int, aZ: Int, aW: Int, b: Vec4s): Vec4s {
        res.x = (aX / b.x).s
        res.y = (aY / b.y).s
        res.z = (aZ / b.z).s
        res.w = (aW / b.w).s
        return res
    }

    fun rem(res: Vec4s, a: Vec4s, bX: Short, bY: Short, bZ: Short, bW: Short): Vec4s {
        res.x = (a.x % bX).s
        res.y = (a.y % bY).s
        res.z = (a.z % bZ).s
        res.w = (a.w % bW).s
        return res
    }

    fun rem(res: Vec4s, a: Vec4s, bX: Int, bY: Int, bZ: Int, bW: Int): Vec4s {
        res.x = (a.x % bX).s
        res.y = (a.y % bY).s
        res.z = (a.z % bZ).s
        res.w = (a.w % bW).s
        return res
    }

    fun rem(res: Vec4s, aX: Short, aY: Short, aZ: Short, aW: Short, b: Vec4s): Vec4s {
        res.x = (aX % b.x).s
        res.y = (aY % b.y).s
        res.z = (aZ % b.z).s
        res.w = (aW % b.w).s
        return res
    }

    fun rem(res: Vec4s, aX: Int, aY: Int, aZ: Int, aW: Int, b: Vec4s): Vec4s {
        res.x = (aX % b.x).s
        res.y = (aY % b.y).s
        res.z = (aZ % b.z).s
        res.w = (aW % b.w).s
        return res
    }

    fun and(res: Vec4s, a: Vec4s, bX: Short, bY: Short, bZ: Short, bW: Short): Vec4s {
        res.x = a.x and bX
        res.y = a.y and bY
        res.z = a.z and bZ
        res.w = a.w and bW
        return res
    }

    fun and(res: Vec4s, a: Vec4s, bX: Int, bY: Int, bZ: Int, bW: Int): Vec4s {
        res.x = a.x and bX
        res.y = a.y and bY
        res.z = a.z and bZ
        res.w = a.w and bW
        return res
    }

    fun or(res: Vec4s, a: Vec4s, bX: Short, bY: Short, bZ: Short, bW: Short): Vec4s {
        res.x = a.x or bX
        res.y = a.y or bY
        res.z = a.z or bZ
        res.w = a.w or bW
        return res
    }

    fun or(res: Vec4s, a: Vec4s, bX: Int, bY: Int, bZ: Int, bW: Int): Vec4s {
        res.x = a.x or bX
        res.y = a.y or bY
        res.z = a.z or bZ
        res.w = a.w or bW
        return res
    }

    fun xor(res: Vec4s, a: Vec4s, bX: Short, bY: Short, bZ: Short, bW: Short): Vec4s {
        res.x = a.x xor bX
        res.y = a.y xor bY
        res.z = a.z xor bZ
        res.w = a.w xor bW
        return res
    }

    fun xor(res: Vec4s, a: Vec4s, bX: Int, bY: Int, bZ: Int, bW: Int): Vec4s {
        res.x = a.x xor bX
        res.y = a.y xor bY
        res.z = a.z xor bZ
        res.w = a.w xor bW
        return res
    }

    fun shl(res: Vec4s, a: Vec4s, bX: Short, bY: Short, bZ: Short, bW: Short): Vec4s {
        res.x = a.x shl bX
        res.y = a.y shl bY
        res.z = a.z shl bZ
        res.w = a.w shl bW
        return res
    }

    fun shl(res: Vec4s, a: Vec4s, bX: Int, bY: Int, bZ: Int, bW: Int): Vec4s {
        res.x = a.x shl bX
        res.y = a.y shl bY
        res.z = a.z shl bZ
        res.w = a.w shl bW
        return res
    }

    fun shr(res: Vec4s, a: Vec4s, bX: Short, bY: Short, bZ: Short, bW: Short): Vec4s {
        res.x = a.x shr bX
        res.y = a.y shr bY
        res.z = a.z shr bZ
        res.w = a.w shr bW
        return res
    }

    fun shr(res: Vec4s, a: Vec4s, bX: Int, bY: Int, bZ: Int, bW: Int): Vec4s {
        res.x = a.x shr bX
        res.y = a.y shr bY
        res.z = a.z shr bZ
        res.w = a.w shr bW
        return res
    }

    fun inv(res: Vec4s, a: Vec4s): Vec4s {
        res.x = a.x.inv()
        res.y = a.y.inv()
        res.z = a.z.inv()
        res.w = a.w.inv()
        return res
    }
}


// -- Specific binary arithmetic operators --

operator fun Short.plus(b: Vec4s) = add(Vec4s(), b, this, this, this, this)
fun Short.add(b: Vec4s, res: Vec4s = Vec4s()) = add(res, b, this, this, this, this)
infix fun Short.add_(b: Vec4s) = add(b, b, this, this, this, this)

operator fun Short.minus(b: Vec4s) = sub(Vec4s(), this, this, this, this, b)
fun Short.sub(b: Vec4s, res: Vec4s = Vec4s()) = sub(res, b, this, this, this, this)
infix fun Short.sub_(b: Vec4s) = sub(b, this, this, this, this, b)

operator fun Short.times(b: Vec4s) = mul(Vec4s(), b, this, this, this, this)
fun Short.mul(b: Vec4s, res: Vec4s = Vec4s()) = mul(res, b, this, this, this, this)
infix fun Short.mul_(b: Vec4s) = mul(b, b, this, this, this, this)

operator fun Short.div(b: Vec4s) = div(Vec4s(), this, this, this, this, b)
fun Short.div(b: Vec4s, res: Vec4s) = div(res, b, this, this, this, this)
infix fun Short.div_(b: Vec4s) = div(b, this, this, this, this, b)

operator fun Short.rem(b: Vec4s) = rem(Vec4s(), this, this, this, this, b)
fun Short.rem(b: Vec4s, res: Vec4s) = rem(res, b, this, this, this, this)
infix fun Short.rem_(b: Vec4s) = rem(b, this, this, this, this, b)


operator fun Int.plus(b: Vec4s) = add(Vec4s(), b, this, this, this, this)
fun Int.add(b: Vec4s, res: Vec4s = Vec4s()) = add(res, b, this, this, this, this)
infix fun Int.add_(b: Vec4s) = add(b, b, this, this, this, this)

operator fun Int.minus(b: Vec4s) = sub(Vec4s(), this, this, this, this, b)
fun Int.sub(b: Vec4s, res: Vec4s = Vec4s()) = sub(res, b, this, this, this, this)
infix fun Int.sub_(b: Vec4s) = sub(b, this, this, this, this, b)

operator fun Int.times(b: Vec4s) = mul(Vec4s(), b, this, this, this, this)
fun Int.mul(b: Vec4s, res: Vec4s = Vec4s()) = mul(res, b, this, this, this, this)
infix fun Int.mul_(b: Vec4s) = mul(b, b, this, this, this, this)

operator fun Int.div(b: Vec4s) = div(Vec4s(), this, this, this, this, b)
fun Int.div(b: Vec4s, res: Vec4s) = div(res, b, this, this, this, this)
infix fun Int.div_(b: Vec4s) = div(b, this, this, this, this, b)

operator fun Int.rem(b: Vec4s) = rem(Vec4s(), this, this, this, this, b)
fun Int.rem(b: Vec4s, res: Vec4s) = rem(res, b, this, this, this, this)
infix fun Int.rem_(b: Vec4s) = rem(b, this, this, this, this, b)


// -- Specific binary arithmetic operators --

operator fun Number.plus(b: Vec4s) = add(Vec4s(), b, this.s, this.s, this.s, this.s)
fun Number.add(b: Vec4s, res: Vec4s = Vec4s()) = add(res, b, this.s, this.s, this.s, this.s)
infix fun Number.add_(b: Vec4s) = add(b, b, this.s, this.s, this.s, this.s)

operator fun Number.minus(b: Vec4s) = sub(Vec4s(), this.s, this.s, this.s, this.s, b)
fun Number.sub(b: Vec4s, res: Vec4s = Vec4s()) = sub(res, b, this.s, this.s, this.s, this.s)
infix fun Number.sub_(b: Vec4s) = sub(b, this.s, this.s, this.s, this.s, b)

operator fun Number.times(b: Vec4s) = mul(Vec4s(), b, this.s, this.s, this.s, this.s)
fun Number.mul(b: Vec4s, res: Vec4s = Vec4s()) = mul(res, b, this.s, this.s, this.s, this.s)
infix fun Number.mul_(b: Vec4s) = mul(b, b, this.s, this.s, this.s, this.s)

operator fun Number.div(b: Vec4s) = div(Vec4s(), this.s, this.s, this.s, this.s, b)
fun Number.div(b: Vec4s, res: Vec4s) = div(res, b, this.s, this.s, this.s, this.s)
infix fun Number.div_(b: Vec4s) = div(b, this.s, this.s, this.s, this.s, b)

operator fun Number.rem(b: Vec4s) = rem(Vec4s(), this.s, this.s, this.s, this.s, b)
fun Number.rem(b: Vec4s, res: Vec4s) = rem(res, b, this.s, this.s, this.s, this.s)
infix fun Number.rem_(b: Vec4s) = rem(b, this.s, this.s, this.s, this.s, b)