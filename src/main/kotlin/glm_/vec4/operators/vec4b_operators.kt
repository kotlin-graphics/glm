package glm_.vec4.operators

import glm_.*
import glm_.vec4.Vec4b
import glm_.vec4.Vec4b.Companion.div
import glm_.vec4.Vec4b.Companion.minus
import glm_.vec4.Vec4b.Companion.plus
import glm_.vec4.Vec4b.Companion.rem
import glm_.vec4.Vec4b.Companion.times
import kotlin.experimental.and
import kotlin.experimental.inv
import kotlin.experimental.or
import kotlin.experimental.xor

/**
 * Created by GBarbieri on 08.11.2016.
 */
interface vec4b_operators {

    fun plus(res: Vec4b, a: Vec4b, bX: Byte, bY: Byte, bZ: Byte, bW: Byte): Vec4b {
        res.x = (a.x + bX).b
        res.y = (a.y + bY).b
        res.z = (a.z + bZ).b
        res.w = (a.w + bW).b
        return res
    }

    fun plus(res: Vec4b, a: Vec4b, bX: Int, bY: Int, bZ: Int, bW: Int): Vec4b {
        res.x = (a.x + bX).b
        res.y = (a.y + bY).b
        res.z = (a.z + bZ).b
        res.w = (a.w + bW).b
        return res
    }

    fun minus(res: Vec4b, a: Vec4b, bX: Byte, bY: Byte, bZ: Byte, bW: Byte): Vec4b {
        res.x = (a.x - bX).b
        res.y = (a.y - bY).b
        res.z = (a.z - bZ).b
        res.w = (a.w - bW).b
        return res
    }

    fun minus(res: Vec4b, a: Vec4b, bX: Int, bY: Int, bZ: Int, bW: Int): Vec4b {
        res.x = (a.x - bX).b
        res.y = (a.y - bY).b
        res.z = (a.z - bZ).b
        res.w = (a.w - bW).b
        return res
    }

    fun minus(res: Vec4b, aX: Byte, aY: Byte, aZ: Byte, aW: Byte, b: Vec4b): Vec4b {
        res.x = (aX - b.x).b
        res.y = (aY - b.y).b
        res.z = (aZ - b.z).b
        res.w = (aW - b.w).b
        return res
    }

    fun minus(res: Vec4b, aX: Int, aY: Int, aZ: Int, aW: Int, b: Vec4b): Vec4b {
        res.x = (aX - b.x).b
        res.y = (aY - b.y).b
        res.z = (aZ - b.z).b
        res.w = (aW - b.w).b
        return res
    }

    fun times(res: Vec4b, a: Vec4b, bX: Byte, bY: Byte, bZ: Byte, bW: Byte): Vec4b {
        res.x = (a.x * bX).b
        res.y = (a.y * bY).b
        res.z = (a.z * bZ).b
        res.w = (a.w * bW).b
        return res
    }

    fun times(res: Vec4b, a: Vec4b, bX: Int, bY: Int, bZ: Int, bW: Int): Vec4b {
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

infix operator fun Byte.plus(b: Vec4b) = plus(Vec4b(), b, this, this, this, this)
fun Byte.plus(b: Vec4b, res: Vec4b) = plus(res, b, this, this, this, this)
infix fun Byte.plusAssign(b: Vec4b) = plus(b, b, this, this, this, this)

infix operator fun Byte.minus(b: Vec4b) = minus(Vec4b(), this, this, this, this, b)
fun Byte.minus(b: Vec4b, res: Vec4b) = minus(res, b, this, this, this, this)
infix fun Byte.minusAssign(b: Vec4b) = minus(b, this, this, this, this, b)

infix operator fun Byte.times(b: Vec4b) = times(Vec4b(), b, this, this, this, this)
fun Byte.times(b: Vec4b, res: Vec4b) = times(res, b, this, this, this, this)
infix fun Byte.timesAssign(b: Vec4b) = times(b, b, this, this, this, this)

infix operator fun Byte.div(b: Vec4b) = div(Vec4b(), this, this, this, this, b)
fun Byte.div(b: Vec4b, res: Vec4b) = div(res, b, this, this, this, this)
infix fun Byte.divAssign(b: Vec4b) = div(b, this, this, this, this, b)

infix operator fun Byte.rem(b: Vec4b) = rem(Vec4b(), this, this, this, this, b)
fun Byte.rem(b: Vec4b, res: Vec4b) = rem(res, b, this, this, this, this)
infix fun Byte.remAssign(b: Vec4b) = rem(b, this, this, this, this, b)


infix operator fun Int.plus(b: Vec4b) = plus(Vec4b(), b, this, this, this, this)
fun Int.plus(b: Vec4b, res: Vec4b) = plus(res, b, this, this, this, this)
infix fun Int.plusAssign(b: Vec4b) = plus(b, b, this, this, this, this)

infix operator fun Int.minus(b: Vec4b) = minus(Vec4b(), this, this, this, this, b)
fun Int.minus(b: Vec4b, res: Vec4b) = minus(res, b, this, this, this, this)
infix fun Int.minusAssign(b: Vec4b) = minus(b, this, this, this, this, b)

infix operator fun Int.times(b: Vec4b) = times(Vec4b(), b, this, this, this, this)
fun Int.times(b: Vec4b, res: Vec4b) = times(res, b, this, this, this, this)
infix fun Int.timesAssign(b: Vec4b) = times(b, b, this, this, this, this)

infix operator fun Int.div(b: Vec4b) = div(Vec4b(), this, this, this, this, b)
fun Int.div(b: Vec4b, res: Vec4b) = div(res, b, this, this, this, this)
infix fun Int.divAssign(b: Vec4b) = div(b, this, this, this, this, b)

infix operator fun Int.rem(b: Vec4b) = rem(Vec4b(), this, this, this, this, b)
fun Int.rem(b: Vec4b, res: Vec4b) = rem(res, b, this, this, this, this)
infix fun Int.remAssign(b: Vec4b) = rem(b, this, this, this, this, b)


// -- Generic binary arithmetic operators --

infix operator fun Number.plus(b: Vec4b) = plus(Vec4b(), b, this.b, this.b, this.b, this.b)
fun Number.plus(b: Vec4b, res: Vec4b) = plus(res, b, this.b, this.b, this.b, this.b)
infix fun Number.plusAssign(b: Vec4b) = plus(b, b, this.b, this.b, this.b, this.b)

infix operator fun Number.minus(b: Vec4b) = minus(Vec4b(), this.b, this.b, this.b, this.b, b)
fun Number.minus(b: Vec4b, res: Vec4b) = minus(res, b, this.b, this.b, this.b, this.b)
infix fun Number.minusAssign(b: Vec4b) = minus(b, this.b, this.b, this.b, this.b, b)

infix operator fun Number.times(b: Vec4b) = times(Vec4b(), b, this.b, this.b, this.b, this.b)
fun Number.times(b: Vec4b, res: Vec4b) = times(res, b, this.b, this.b, this.b, this.b)
infix fun Number.timesAssign(b: Vec4b) = times(b, b, this.b, this.b, this.b, this.b)

infix operator fun Number.div(b: Vec4b) = div(Vec4b(), this.b, this.b, this.b, this.b, b)
fun Number.div(b: Vec4b, res: Vec4b) = div(res, b, this.b, this.b, this.b, this.b)
infix fun Number.divAssign(b: Vec4b) = div(b, this.b, this.b, this.b, this.b, b)

infix operator fun Number.rem(b: Vec4b) = rem(Vec4b(), this.b, this.b, this.b, this.b, b)
fun Number.rem(b: Vec4b, res: Vec4b) = rem(res, b, this.b, this.b, this.b, this.b)
infix fun Number.remAssign(b: Vec4b) = rem(b, this.b, this.b, this.b, this.b, b)