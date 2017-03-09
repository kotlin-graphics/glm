package glm.vec._4.operators

import glm.s
import glm.and
import glm.or
import glm.xor
import glm.shl
import glm.shr
import glm.vec._4.Vec4s
import glm.vec._4.Vec4s.Companion.plus
import glm.vec._4.Vec4s.Companion.div
import glm.vec._4.Vec4s.Companion.times
import glm.vec._4.Vec4s.Companion.rem
import glm.vec._4.Vec4s.Companion.minus
import kotlin.experimental.and
import kotlin.experimental.inv
import kotlin.experimental.xor
import kotlin.experimental.or

/**
 * Created by GBarbieri on 08.11.2016.
 */
interface vec4s_operators {

    fun plus(res: Vec4s, a: Vec4s, bX: Short, bY: Short, bZ: Short, bW: Short): Vec4s {
        res.x = (a.x + bX).s
        res.y = (a.y + bY).s
        res.z = (a.z + bZ).s
        res.w = (a.w + bW).s
        return res
    }

    fun plus(res: Vec4s, a: Vec4s, bX: Int, bY: Int, bZ: Int, bW: Int): Vec4s {
        res.x = (a.x + bX).s
        res.y = (a.y + bY).s
        res.z = (a.z + bZ).s
        res.w = (a.w + bW).s
        return res
    }

    fun minus(res: Vec4s, a: Vec4s, bX: Short, bY: Short, bZ: Short, bW: Short): Vec4s {
        res.x = (a.x - bX).s
        res.y = (a.y - bY).s
        res.z = (a.z - bZ).s
        res.w = (a.w - bW).s
        return res
    }

    fun minus(res: Vec4s, a: Vec4s, bX: Int, bY: Int, bZ: Int, bW: Int): Vec4s {
        res.x = (a.x - bX).s
        res.y = (a.y - bY).s
        res.z = (a.z - bZ).s
        res.w = (a.w - bW).s
        return res
    }

    fun minus(res: Vec4s, aX: Short, aY: Short, aZ: Short, aW: Short, b: Vec4s): Vec4s {
        res.x = (aX - b.x).s
        res.y = (aY - b.y).s
        res.z = (aZ - b.z).s
        res.w = (aW - b.w).s
        return res
    }

    fun minus(res: Vec4s, aX: Int, aY: Int, aZ: Int, aW: Int, b: Vec4s): Vec4s {
        res.x = (aX - b.x).s
        res.y = (aY - b.y).s
        res.z = (aZ - b.z).s
        res.w = (aW - b.w).s
        return res
    }

    fun times(res: Vec4s, a: Vec4s, bX: Short, bY: Short, bZ: Short, bW: Short): Vec4s {
        res.x = (a.x * bX).s
        res.y = (a.y * bY).s
        res.z = (a.z * bZ).s
        res.w = (a.w * bW).s
        return res
    }

    fun times(res: Vec4s, a: Vec4s, bX: Int, bY: Int, bZ: Int, bW: Int): Vec4s {
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

infix operator fun Short.plus(b: Vec4s) = plus(Vec4s(), b, this, this, this, this)
fun Short.plus(b: Vec4s, res: Vec4s) = plus(res, b, this, this, this, this)
infix fun Short.plus_(b: Vec4s) = plus(b, b, this, this, this, this)

infix operator fun Short.minus(b: Vec4s) = minus(Vec4s(), this, this, this, this, b)
fun Short.minus(b: Vec4s, res: Vec4s) = minus(res, b, this, this, this, this)
infix fun Short.minus_(b: Vec4s) = minus(b, this, this, this, this, b)

infix operator fun Short.times(b: Vec4s) = times(Vec4s(), b, this, this, this, this)
fun Short.times(b: Vec4s, res: Vec4s) = times(res, b, this, this, this, this)
infix fun Short.times_(b: Vec4s) = times(b, b, this, this, this, this)

infix operator fun Short.div(b: Vec4s) = div(Vec4s(), this, this, this, this, b)
fun Short.div(b: Vec4s, res: Vec4s) = div(res, b, this, this, this, this)
infix fun Short.div_(b: Vec4s) = div(b, this, this, this, this, b)

infix operator fun Short.rem(b: Vec4s) = rem(Vec4s(), this, this, this, this, b)
fun Short.rem(b: Vec4s, res: Vec4s) = rem(res, b, this, this, this, this)
infix fun Short.rem_(b: Vec4s) = rem(b, this, this, this, this, b)


infix operator fun Int.plus(b: Vec4s) = plus(Vec4s(), b, this, this, this, this)
fun Int.plus(b: Vec4s, res: Vec4s) = plus(res, b, this, this, this, this)
infix fun Int.plus_(b: Vec4s) = plus(b, b, this, this, this, this)

infix operator fun Int.minus(b: Vec4s) = minus(Vec4s(), this, this, this, this, b)
fun Int.minus(b: Vec4s, res: Vec4s) = minus(res, b, this, this, this, this)
infix fun Int.minus_(b: Vec4s) = minus(b, this, this, this, this, b)

infix operator fun Int.times(b: Vec4s) = times(Vec4s(), b, this, this, this, this)
fun Int.times(b: Vec4s, res: Vec4s) = times(res, b, this, this, this, this)
infix fun Int.times_(b: Vec4s) = times(b, b, this, this, this, this)

infix operator fun Int.div(b: Vec4s) = div(Vec4s(), this, this, this, this, b)
fun Int.div(b: Vec4s, res: Vec4s) = div(res, b, this, this, this, this)
infix fun Int.div_(b: Vec4s) = div(b, this, this, this, this, b)

infix operator fun Int.rem(b: Vec4s) = rem(Vec4s(), this, this, this, this, b)
fun Int.rem(b: Vec4s, res: Vec4s) = rem(res, b, this, this, this, this)
infix fun Int.rem_(b: Vec4s) = rem(b, this, this, this, this, b)


// -- Specific binary arithmetic operators --

infix operator fun Number.plus(b: Vec4s) = plus(Vec4s(), b, this.s, this.s, this.s, this.s)
fun Number.plus(b: Vec4s, res: Vec4s) = plus(res, b, this.s, this.s, this.s, this.s)
infix fun Number.plus_(b: Vec4s) = plus(b, b, this.s, this.s, this.s, this.s)

infix operator fun Number.minus(b: Vec4s) = minus(Vec4s(), this.s, this.s, this.s, this.s, b)
fun Number.minus(b: Vec4s, res: Vec4s) = minus(res, b, this.s, this.s, this.s, this.s)
infix fun Number.minus_(b: Vec4s) = minus(b, this.s, this.s, this.s, this.s, b)

infix operator fun Number.times(b: Vec4s) = times(Vec4s(), b, this.s, this.s, this.s, this.s)
fun Number.times(b: Vec4s, res: Vec4s) = times(res, b, this.s, this.s, this.s, this.s)
infix fun Number.times_(b: Vec4s) = times(b, b, this.s, this.s, this.s, this.s)

infix operator fun Number.div(b: Vec4s) = div(Vec4s(), this.s, this.s, this.s, this.s, b)
fun Number.div(b: Vec4s, res: Vec4s) = div(res, b, this.s, this.s, this.s, this.s)
infix fun Number.div_(b: Vec4s) = div(b, this.s, this.s, this.s, this.s, b)

infix operator fun Number.rem(b: Vec4s) = rem(Vec4s(), this.s, this.s, this.s, this.s, b)
fun Number.rem(b: Vec4s, res: Vec4s) = rem(res, b, this.s, this.s, this.s, this.s)
infix fun Number.rem_(b: Vec4s) = rem(b, this.s, this.s, this.s, this.s, b)