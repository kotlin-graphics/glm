package glm_.vec4.operators

import glm_.i
import glm_.vec4.Vec4i
import glm_.vec4.Vec4i.Companion.plus
import glm_.vec4.Vec4i.Companion.div
import glm_.vec4.Vec4i.Companion.times
import glm_.vec4.Vec4i.Companion.rem
import glm_.vec4.Vec4i.Companion.minus

/**
 * Created by GBarbieri on 08.11.2016.
 */
interface vec4i_operators {

    fun plus(res: Vec4i, a: Vec4i, bX: Int, bY: Int, bZ: Int, bW: Int): Vec4i {
        res.x = a.x + bX
        res.y = a.y + bY
        res.z = a.z + bZ
        res.w = a.w + bW
        return res
    }

    fun minus(res: Vec4i, a: Vec4i, bX: Int, bY: Int, bZ: Int, bW: Int): Vec4i {
        res.x = a.x - bX
        res.y = a.y - bY
        res.z = a.z - bZ
        res.w = a.w - bW
        return res
    }

    fun minus(res: Vec4i, aX: Int, aY: Int, aZ: Int, aW: Int, b: Vec4i): Vec4i {
        res.x = aX - b.x
        res.y = aY - b.y
        res.z = aZ - b.z
        res.w = aW - b.w
        return res
    }

    fun times(res: Vec4i, a: Vec4i, bX: Int, bY: Int, bZ: Int, bW: Int): Vec4i {
        res.x = a.x * bX
        res.y = a.y * bY
        res.z = a.z * bZ
        res.w = a.w * bW
        return res
    }

    fun div(res: Vec4i, a: Vec4i, bX: Int, bY: Int, bZ: Int, bW: Int): Vec4i {
        res.x = a.x / bX
        res.y = a.y / bY
        res.z = a.z / bZ
        res.w = a.w / bW
        return res
    }

    fun div(res: Vec4i, aX: Int, aY: Int, aZ: Int, aW: Int, b: Vec4i): Vec4i {
        res.x = aX / b.x
        res.y = aY / b.y
        res.z = aZ / b.z
        res.w = aW / b.w
        return res
    }

    fun rem(res: Vec4i, a: Vec4i, bX: Int, bY: Int, bZ: Int, bW: Int): Vec4i {
        res.x = a.x % bX
        res.y = a.y % bY
        res.z = a.z % bZ
        res.w = a.w % bW
        return res
    }

    fun rem(res: Vec4i, aX: Int, aY: Int, aZ: Int, aW: Int, b: Vec4i): Vec4i {
        res.x = aX % b.x
        res.y = aY % b.y
        res.z = aZ % b.z
        res.w = aW % b.w
        return res
    }

    fun and(res: Vec4i, a: Vec4i, bX: Int, bY: Int, bZ: Int, bW: Int): Vec4i {
        res.x = a.x and bX
        res.y = a.y and bY
        res.z = a.z and bZ
        res.w = a.w and bW
        return res
    }

    fun or(res: Vec4i, a: Vec4i, bX: Int, bY: Int, bZ: Int, bW: Int): Vec4i {
        res.x = a.x or bX
        res.y = a.y or bY
        res.z = a.z or bZ
        res.w = a.w or bW
        return res
    }

    fun xor(res: Vec4i, a: Vec4i, bX: Int, bY: Int, bZ: Int, bW: Int): Vec4i {
        res.x = a.x xor bX
        res.y = a.y xor bY
        res.z = a.z xor bZ
        res.w = a.w xor bW
        return res
    }

    fun shl(res: Vec4i, a: Vec4i, bX: Int, bY: Int, bZ: Int, bW: Int): Vec4i {
        res.x = a.x shl bX
        res.y = a.y shl bY
        res.z = a.z shl bZ
        res.w = a.w shl bZ
        return res
    }

    fun shr(res: Vec4i, a: Vec4i, bX: Int, bY: Int, bZ: Int, bW: Int): Vec4i {
        res.x = a.x shr bX
        res.y = a.y shr bY
        res.z = a.z shr bZ
        res.w = a.w shr bW
        return res
    }

    fun inv(res: Vec4i, a: Vec4i): Vec4i {
        res.x = a.x.inv()
        res.y = a.y.inv()
        res.z = a.z.inv()
        res.w = a.w.inv()
        return res
    }
}


// -- Specific binary arithmetic operators --

infix operator fun Int.plus(b: Vec4i) = plus(Vec4i(), b, this, this, this, this)
fun Int.plus(b: Vec4i, res: Vec4i) = plus(res, b, this, this, this, this)
infix fun Int.plus_(b: Vec4i) = plus(b, b, this, this, this, this)

infix operator fun Int.minus(b: Vec4i) = minus(Vec4i(), this, this, this, this, b)
fun Int.minus(b: Vec4i, res: Vec4i) = minus(res, b, this, this, this, this)
infix fun Int.minus_(b: Vec4i) = minus(b, this, this, this, this, b)

infix operator fun Int.times(b: Vec4i) = times(Vec4i(), b, this, this, this, this)
fun Int.times(b: Vec4i, res: Vec4i) = times(res, b, this, this, this, this)
infix fun Int.times_(b: Vec4i) = times(b, b, this, this, this, this)

infix operator fun Int.div(b: Vec4i) = div(Vec4i(), this, this, this, this, b)
fun Int.div(b: Vec4i, res: Vec4i) = div(res, b, this, this, this, this)
infix fun Int.div_(b: Vec4i) = div(b, this, this, this, this, b)

infix operator fun Int.rem(b: Vec4i) = rem(Vec4i(), this, this, this, this, b)
fun Int.rem(b: Vec4i, res: Vec4i) = rem(res, b, this, this, this, this)
infix fun Int.rem_(b: Vec4i) = rem(b, this, this, this, this, b)


// -- Generic binary arithmetic operators --

infix operator fun Number.plus(b: Vec4i) = plus(Vec4i(), b, this.i, this.i, this.i, this.i)
fun Number.plus(b: Vec4i, res: Vec4i) = plus(res, b, this.i, this.i, this.i, this.i)
infix fun Number.plus_(b: Vec4i) = plus(b, b, this.i, this.i, this.i, this.i)

infix operator fun Number.minus(b: Vec4i) = minus(Vec4i(), this.i, this.i, this.i, this.i, b)
fun Number.minus(b: Vec4i, res: Vec4i) = minus(res, b, this.i, this.i, this.i, this.i)
infix fun Number.minus_(b: Vec4i) = minus(b, this.i, this.i, this.i, this.i, b)

infix operator fun Number.times(b: Vec4i) = times(Vec4i(), b, this.i, this.i, this.i, this.i)
fun Number.times(b: Vec4i, res: Vec4i) = times(res, b, this.i, this.i, this.i, this.i)
infix fun Number.times_(b: Vec4i) = times(b, b, this.i, this.i, this.i, this.i)

infix operator fun Number.div(b: Vec4i) = div(Vec4i(), this.i, this.i, this.i, this.i, b)
fun Number.div(b: Vec4i, res: Vec4i) = div(res, b, this.i, this.i, this.i, this.i)
infix fun Number.div_(b: Vec4i) = div(b, this.i, this.i, this.i, this.i, b)

infix operator fun Number.rem(b: Vec4i) = rem(Vec4i(), this.i, this.i, this.i, this.i, b)
fun Number.rem(b: Vec4i, res: Vec4i) = rem(res, b, this.i, this.i, this.i, this.i)
infix fun Number.rem_(b: Vec4i) = rem(b, this.i, this.i, this.i, this.i, b)