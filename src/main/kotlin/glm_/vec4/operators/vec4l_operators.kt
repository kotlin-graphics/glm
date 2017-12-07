package glm_.vec4.operators

import glm_.*
import glm_.vec4.Vec4l
import glm_.vec4.Vec4l.Companion.div
import glm_.vec4.Vec4l.Companion.minus
import glm_.vec4.Vec4l.Companion.plus
import glm_.vec4.Vec4l.Companion.rem
import glm_.vec4.Vec4l.Companion.times

/**
 * Created by GBarbieri on 08.11.2016.
 */
open class vec4l_operators {

    inline fun plus(res: Vec4l, a: Vec4l, bX: Int, bY: Int, bZ: Int, bW: Int): Vec4l {
        res.x = a.x + bX
        res.y = a.y + bY
        res.z = a.z + bZ
        res.w = a.w + bW
        return res
    }

    inline fun plus(res: Vec4l, a: Vec4l, bX: Long, bY: Long, bZ: Long, bW: Long): Vec4l {
        res.x = a.x + bX
        res.y = a.y + bY
        res.z = a.z + bZ
        res.w = a.w + bW
        return res
    }

    inline fun minus(res: Vec4l, a: Vec4l, bX: Int, bY: Int, bZ: Int, bW: Int): Vec4l {
        res.x = a.x - bX
        res.y = a.y - bY
        res.z = a.z - bZ
        res.w = a.w - bW
        return res
    }

    inline fun minus(res: Vec4l, a: Vec4l, bX: Long, bY: Long, bZ: Long, bW: Long): Vec4l {
        res.x = a.x - bX
        res.y = a.y - bY
        res.z = a.z - bZ
        res.w = a.w - bW
        return res
    }

    inline fun minus(res: Vec4l, aX: Int, aY: Int, aZ: Int, aW: Int, b: Vec4l): Vec4l {
        res.x = aX - b.x
        res.y = aY - b.y
        res.z = aZ - b.z
        res.w = aW - b.w
        return res
    }

    inline fun minus(res: Vec4l, aX: Long, aY: Long, aZ: Long, aW: Long, b: Vec4l): Vec4l {
        res.x = aX - b.x
        res.y = aY - b.y
        res.z = aZ - b.z
        res.w = aW - b.w
        return res
    }

    inline fun times(res: Vec4l, a: Vec4l, bX: Int, bY: Int, bZ: Int, bW: Int): Vec4l {
        res.x = a.x * bX
        res.y = a.y * bY
        res.z = a.z * bZ
        res.w = a.w * bW
        return res
    }

    inline fun times(res: Vec4l, a: Vec4l, bX: Long, bY: Long, bZ: Long, bW: Long): Vec4l {
        res.x = a.x * bX
        res.y = a.y * bY
        res.z = a.z * bZ
        res.w = a.w * bW
        return res
    }

    inline fun div(res: Vec4l, a: Vec4l, bX: Int, bY: Int, bZ: Int, bW: Int): Vec4l {
        res.x = a.x / bX
        res.y = a.y / bY
        res.z = a.z / bZ
        res.w = a.w / bW
        return res
    }


    inline fun div(res: Vec4l, a: Vec4l, bX: Long, bY: Long, bZ: Long, bW: Long): Vec4l {
        res.x = a.x / bX
        res.y = a.y / bY
        res.z = a.z / bZ
        res.w = a.w / bW
        return res
    }

    inline fun div(res: Vec4l, aX: Int, aY: Int, aZ: Int, aW: Int, b: Vec4l): Vec4l {
        res.x = aX / b.x
        res.y = aY / b.y
        res.z = aZ / b.z
        res.w = aW / b.w
        return res
    }

    inline fun div(res: Vec4l, aX: Long, aY: Long, aZ: Long, aW: Long, b: Vec4l): Vec4l {
        res.x = aX / b.x
        res.y = aY / b.y
        res.z = aZ / b.z
        res.w = aW / b.w
        return res
    }

    inline fun rem(res: Vec4l, a: Vec4l, bX: Int, bY: Int, bZ: Int, bW: Int): Vec4l {
        res.x = a.x % bX
        res.y = a.y % bY
        res.z = a.z % bZ
        res.w = a.w % bW
        return res
    }

    inline fun rem(res: Vec4l, a: Vec4l, bX: Long, bY: Long, bZ: Long, bW: Long): Vec4l {
        res.x = a.x % bX
        res.y = a.y % bY
        res.z = a.z % bZ
        res.w = a.w % bW
        return res
    }

    inline fun rem(res: Vec4l, aX: Int, aY: Int, aZ: Int, aW: Int, b: Vec4l): Vec4l {
        res.x = aX % b.x
        res.y = aY % b.y
        res.z = aZ % b.z
        res.w = aW % b.w
        return res
    }

    inline fun rem(res: Vec4l, aX: Long, aY: Long, aZ: Long, aW: Long, b: Vec4l): Vec4l {
        res.x = aX % b.x
        res.y = aY % b.y
        res.z = aZ % b.z
        res.w = aW % b.w
        return res
    }

    inline fun and(res: Vec4l, a: Vec4l, bX: Int, bY: Int, bZ: Int, bW: Int): Vec4l {
        res.x = a.x and bX
        res.y = a.y and bY
        res.z = a.z and bZ
        res.w = a.w and bW
        return res
    }


    inline fun and(res: Vec4l, a: Vec4l, bX: Long, bY: Long, bZ: Long, bW: Long): Vec4l {
        res.x = a.x and bX
        res.y = a.y and bY
        res.z = a.z and bZ
        res.w = a.w and bW
        return res
    }

    inline fun or(res: Vec4l, a: Vec4l, bX: Int, bY: Int, bZ: Int, bW: Int): Vec4l {
        res.x = a.x or bX
        res.y = a.y or bY
        res.z = a.z or bZ
        res.w = a.w or bW
        return res
    }

    inline fun or(res: Vec4l, a: Vec4l, bX: Long, bY: Long, bZ: Long, bW: Long): Vec4l {
        res.x = a.x or bX
        res.y = a.y or bY
        res.z = a.z or bZ
        res.w = a.w or bW
        return res
    }

    inline fun xor(res: Vec4l, a: Vec4l, bX: Int, bY: Int, bZ: Int, bW: Int): Vec4l {
        res.x = a.x xor bX
        res.y = a.y xor bY
        res.z = a.z xor bZ
        res.w = a.w xor bW
        return res
    }

    inline fun xor(res: Vec4l, a: Vec4l, bX: Long, bY: Long, bZ: Long, bW: Long): Vec4l {
        res.x = a.x xor bX
        res.y = a.y xor bY
        res.z = a.z xor bZ
        res.w = a.w xor bW
        return res
    }


    inline fun shl(res: Vec4l, a: Vec4l, bX: Int, bY: Int, bZ: Int, bW: Int): Vec4l {
        res.x = a.x shl bX
        res.y = a.y shl bY
        res.z = a.z shl bZ
        res.w = a.w shl bW
        return res
    }

    inline fun shl(res: Vec4l, a: Vec4l, bX: Long, bY: Long, bZ: Long, bW: Long): Vec4l {
        res.x = a.x shl bX.i
        res.y = a.y shl bY.i
        res.z = a.z shl bZ.i
        res.w = a.w shl bW.i
        return res
    }


    inline fun shr(res: Vec4l, a: Vec4l, bX: Int, bY: Int, bZ: Int, bW: Int): Vec4l {
        res.x = a.x shr bX
        res.y = a.y shr bY
        res.z = a.z shr bZ
        res.w = a.w shr bW
        return res
    }

    inline fun shr(res: Vec4l, a: Vec4l, bX: Long, bY: Long, bZ: Long, bW: Long): Vec4l {
        res.x = a.x shr bX.i
        res.y = a.y shr bY.i
        res.z = a.z shr bZ.i
        res.w = a.w shr bW.i
        return res
    }

    inline fun inv(res: Vec4l, a: Vec4l): Vec4l {
        res.x = a.x.inv()
        res.y = a.y.inv()
        res.z = a.z.inv()
        res.w = a.w.inv()
        return res
    }
}


// -- Specific binary arithmetic operators --

infix operator fun Long.plus(b: Vec4l) = plus(Vec4l(), b, this, this, this, this)
fun Long.plus(b: Vec4l, res: Vec4l) = plus(res, b, this, this, this, this)
infix fun Long.plus_(b: Vec4l) = plus(b, b, this, this, this, this)

infix operator fun Long.minus(b: Vec4l) = minus(Vec4l(), this, this, this, this, b)
fun Long.minus(b: Vec4l, res: Vec4l) = minus(res, b, this, this, this, this)
infix fun Long.minus_(b: Vec4l) = minus(b, this, this, this, this, b)

infix operator fun Long.times(b: Vec4l) = times(Vec4l(), b, this, this, this, this)
fun Long.times(b: Vec4l, res: Vec4l) = times(res, b, this, this, this, this)
infix fun Long.times_(b: Vec4l) = times(b, b, this, this, this, this)

infix operator fun Long.div(b: Vec4l) = div(Vec4l(), this, this, this, this, b)
fun Long.div(b: Vec4l, res: Vec4l) = div(res, b, this, this, this, this)
infix fun Long.div_(b: Vec4l) = div(b, this, this, this, this, b)

infix operator fun Long.rem(b: Vec4l) = rem(Vec4l(), this, this, this, this, b)
fun Long.rem(b: Vec4l, res: Vec4l) = rem(res, b, this, this, this, this)
infix fun Long.rem_(b: Vec4l) = rem(b, this, this, this, this, b)


infix operator fun Int.plus(b: Vec4l) = plus(Vec4l(), b, this, this, this, this)
fun Int.plus(b: Vec4l, res: Vec4l) = plus(res, b, this, this, this, this)
infix fun Int.plus_(b: Vec4l) = plus(b, b, this, this, this, this)

infix operator fun Int.minus(b: Vec4l) = minus(Vec4l(), this, this, this, this, b)
fun Int.minus(b: Vec4l, res: Vec4l) = minus(res, b, this, this, this, this)
infix fun Int.minus_(b: Vec4l) = minus(b, this, this, this, this, b)

infix operator fun Int.times(b: Vec4l) = times(Vec4l(), b, this, this, this, this)
fun Int.times(b: Vec4l, res: Vec4l) = times(res, b, this, this, this, this)
infix fun Int.times_(b: Vec4l) = times(b, b, this, this, this, this)

infix operator fun Int.div(b: Vec4l) = div(Vec4l(), this, this, this, this, b)
fun Int.div(b: Vec4l, res: Vec4l) = div(res, b, this, this, this, this)
infix fun Int.div_(b: Vec4l) = div(b, this, this, this, this, b)

infix operator fun Int.rem(b: Vec4l) = rem(Vec4l(), this, this, this, this, b)
fun Int.rem(b: Vec4l, res: Vec4l) = rem(res, b, this, this, this, this)
infix fun Int.rem_(b: Vec4l) = rem(b, this, this, this, this, b)


// -- Generic binary arithmetic operators --

infix operator fun Number.plus(b: Vec4l) = plus(Vec4l(), b, this.L, this.L, this.L, this.L)
fun Number.plus(b: Vec4l, res: Vec4l) = plus(res, b, this.L, this.L, this.L, this.L)
infix fun Number.plus_(b: Vec4l) = plus(b, b, this.L, this.L, this.L, this.L)

infix operator fun Number.minus(b: Vec4l) = minus(Vec4l(), this.L, this.L, this.L, this.L, b)
fun Number.minus(b: Vec4l, res: Vec4l) = minus(res, b, this.L, this.L, this.L, this.L)
infix fun Number.minus_(b: Vec4l) = minus(b, this.L, this.L, this.L, this.L, b)

infix operator fun Number.times(b: Vec4l) = times(Vec4l(), b, this.L, this.L, this.L, this.L)
fun Number.times(b: Vec4l, res: Vec4l) = times(res, b, this.L, this.L, this.L, this.L)
infix fun Number.times_(b: Vec4l) = times(b, b, this.L, this.L, this.L, this.L)

infix operator fun Number.div(b: Vec4l) = div(Vec4l(), this.L, this.L, this.L, this.L, b)
fun Number.div(b: Vec4l, res: Vec4l) = div(res, b, this.L, this.L, this.L, this.L)
infix fun Number.div_(b: Vec4l) = div(b, this.L, this.L, this.L, this.L, b)

infix operator fun Number.rem(b: Vec4l) = rem(Vec4l(), this.L, this.L, this.L, this.L, b)
fun Number.rem(b: Vec4l, res: Vec4l) = rem(res, b, this.L, this.L, this.L, this.L)
infix fun Number.rem_(b: Vec4l) = rem(b, this.L, this.L, this.L, this.L, b)