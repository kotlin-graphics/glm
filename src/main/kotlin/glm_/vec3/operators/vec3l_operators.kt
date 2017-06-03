package glm_.vec3.operators

import glm_.L
import glm_.i
import glm_.vec3.Vec3l
import glm_.vec3.Vec3l.Companion.plus
import glm_.vec3.Vec3l.Companion.div
import glm_.vec3.Vec3l.Companion.times
import glm_.vec3.Vec3l.Companion.rem
import glm_.vec3.Vec3l.Companion.minus
import glm_.and
import glm_.or
import glm_.xor

/**
 * Created by GBarbieri on 08.11.2016.
 */
interface vec3l_operators {

    fun plus(res: Vec3l, a: Vec3l, bX: Int, bY: Int, bZ: Int): Vec3l {
        res.x = a.x + bX
        res.y = a.y + bY
        res.z = a.z + bZ
        return res
    }

    fun plus(res: Vec3l, a: Vec3l, bX: Long, bY: Long, bZ: Long): Vec3l {
        res.x = a.x + bX
        res.y = a.y + bY
        res.z = a.z + bZ
        return res
    }

    fun minus(res: Vec3l, a: Vec3l, bX: Int, bY: Int, bZ: Int): Vec3l {
        res.x = a.x - bX
        res.y = a.y - bY
        res.z = a.z - bZ
        return res
    }

    fun minus(res: Vec3l, a: Vec3l, bX: Long, bY: Long, bZ: Long): Vec3l {
        res.x = a.x - bX
        res.y = a.y - bY
        res.z = a.z - bZ
        return res
    }

    fun minus(res: Vec3l, aX: Int, aY: Int, aZ: Int, b: Vec3l): Vec3l {
        res.x = aX - b.x
        res.y = aY - b.y
        res.z = aZ - b.z
        return res
    }

    fun minus(res: Vec3l, aX: Long, aY: Long, aZ: Long, b: Vec3l): Vec3l {
        res.x = aX - b.x
        res.y = aY - b.y
        res.z = aZ - b.z
        return res
    }

    fun times(res: Vec3l, a: Vec3l, bX: Int, bY: Int, bZ: Int): Vec3l {
        res.x = a.x * bX
        res.y = a.y * bY
        res.z = a.z * bZ
        return res
    }

    fun times(res: Vec3l, a: Vec3l, bX: Long, bY: Long, bZ: Long): Vec3l {
        res.x = a.x * bX
        res.y = a.y * bY
        res.z = a.z * bZ
        return res
    }

    fun div(res: Vec3l, a: Vec3l, bX: Int, bY: Int, bZ: Int): Vec3l {
        res.x = a.x / bX
        res.y = a.y / bY
        res.z = a.z / bZ
        return res
    }

    fun div(res: Vec3l, a: Vec3l, bX: Long, bY: Long, bZ: Long): Vec3l {
        res.x = a.x / bX
        res.y = a.y / bY
        res.z = a.z / bZ
        return res
    }

    fun div(res: Vec3l, aX: Int, aY: Int, aZ: Int, b: Vec3l): Vec3l {
        res.x = aX / b.x
        res.y = aY / b.y
        res.z = aZ / b.z
        return res
    }

    fun div(res: Vec3l, aX: Long, aY: Long, aZ: Long, b: Vec3l): Vec3l {
        res.x = aX / b.x
        res.y = aY / b.y
        res.z = aZ / b.z
        return res
    }

    fun rem(res: Vec3l, a: Vec3l, bX: Int, bY: Int, bZ: Int): Vec3l {
        res.x = a.x % bX
        res.y = a.y % bY
        res.z = a.z % bZ
        return res
    }

    fun rem(res: Vec3l, a: Vec3l, bX: Long, bY: Long, bZ: Long): Vec3l {
        res.x = a.x % bX
        res.y = a.y % bY
        res.z = a.z % bZ
        return res
    }

    fun rem(res: Vec3l, aX: Int, aY: Int, aZ: Int, b: Vec3l): Vec3l {
        res.x = aX % b.x
        res.y = aY % b.y
        res.z = aZ % b.z
        return res
    }

    fun rem(res: Vec3l, aX: Long, aY: Long, aZ: Long, b: Vec3l): Vec3l {
        res.x = aX % b.x
        res.y = aY % b.y
        res.z = aZ % b.z
        return res
    }

    fun and(res: Vec3l, a: Vec3l, bX: Int, bY: Int, bZ: Int): Vec3l {
        res.x = a.x and bX
        res.y = a.y and bY
        res.z = a.z and bZ
        return res
    }

    fun and(res: Vec3l, a: Vec3l, bX: Long, bY: Long, bZ: Long): Vec3l {
        res.x = a.x and bX
        res.y = a.y and bY
        res.z = a.z and bZ
        return res
    }

    fun or(res: Vec3l, a: Vec3l, bX: Int, bY: Int, bZ: Int): Vec3l {
        res.x = a.x or bX
        res.y = a.y or bY
        res.z = a.z or bZ
        return res
    }

    fun or(res: Vec3l, a: Vec3l, bX: Long, bY: Long, bZ: Long): Vec3l {
        res.x = a.x or bX
        res.y = a.y or bY
        res.z = a.z or bZ
        return res
    }

    fun xor(res: Vec3l, a: Vec3l, bX: Int, bY: Int, bZ: Int): Vec3l {
        res.x = a.x xor bX
        res.y = a.y xor bY
        res.z = a.z xor bZ
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

infix operator fun Long.plus(b: Vec3l) = plus(Vec3l(), b, this, this, this)
fun Long.plus(b: Vec3l, res: Vec3l) = plus(res, b, this, this, this)
infix fun Long.plus_(b: Vec3l) = plus(b, b, this, this, this)

infix operator fun Long.minus(b: Vec3l) = minus(Vec3l(), this, this, this, b)
fun Long.minus(b: Vec3l, res: Vec3l) = minus(res, b, this, this, this)
infix fun Long.minus_(b: Vec3l) = minus(b, this, this, this, b)

infix operator fun Long.times(b: Vec3l) = times(Vec3l(), b, this, this, this)
fun Long.times(b: Vec3l, res: Vec3l) = times(res, b, this, this, this)
infix fun Long.times_(b: Vec3l) = times(b, b, this, this, this)

infix operator fun Long.div(b: Vec3l) = div(Vec3l(), this, this, this, b)
fun Long.div(b: Vec3l, res: Vec3l) = div(res, b, this, this, this)
infix fun Long.div_(b: Vec3l) = div(b, this, this, this, b)

infix operator fun Long.rem(b: Vec3l) = rem(Vec3l(), this, this, this, b)
fun Long.rem(b: Vec3l, res: Vec3l) = rem(res, b, this, this, this)
infix fun Long.rem_(b: Vec3l) = rem(b, this, this, this, b)


infix operator fun Int.plus(b: Vec3l) = plus(Vec3l(), b, this, this, this)
fun Int.plus(b: Vec3l, res: Vec3l) = plus(res, b, this, this, this)
infix fun Int.plus_(b: Vec3l) = plus(b, b, this, this, this)

infix operator fun Int.minus(b: Vec3l) = minus(Vec3l(), this, this, this, b)
fun Int.minus(b: Vec3l, res: Vec3l) = minus(res, b, this, this, this)
infix fun Int.minus_(b: Vec3l) = minus(b, this, this, this, b)

infix operator fun Int.times(b: Vec3l) = times(Vec3l(), b, this, this, this)
fun Int.times(b: Vec3l, res: Vec3l) = times(res, b, this, this, this)
infix fun Int.times_(b: Vec3l) = times(b, b, this, this, this)

infix operator fun Int.div(b: Vec3l) = div(Vec3l(), this, this, this, b)
fun Int.div(b: Vec3l, res: Vec3l) = div(res, b, this, this, this)
infix fun Int.div_(b: Vec3l) = div(b, this, this, this, b)

infix operator fun Int.rem(b: Vec3l) = rem(Vec3l(), this, this, this, b)
fun Int.rem(b: Vec3l, res: Vec3l) = rem(res, b, this, this, this)
infix fun Int.rem_(b: Vec3l) = rem(b, this, this, this, b)


// -- Generic binary arithmetic operators --

infix operator fun Number.plus(b: Vec3l) = plus(Vec3l(), b, this.L, this.L, this.L)
fun Number.plus(b: Vec3l, res: Vec3l) = plus(res, b, this.L, this.L, this.L)
infix fun Number.plus_(b: Vec3l) = plus(b, b, this.L, this.L, this.L)

infix operator fun Number.minus(b: Vec3l) = minus(Vec3l(), this.L, this.L, this.L, b)
fun Number.minus(b: Vec3l, res: Vec3l) = minus(res, b, this.L, this.L, this.L)
infix fun Number.minus_(b: Vec3l) = minus(b, this.L, this.L, this.L, b)

infix operator fun Number.times(b: Vec3l) = times(Vec3l(), b, this.L, this.L, this.L)
fun Number.times(b: Vec3l, res: Vec3l) = times(res, b, this.L, this.L, this.L)
infix fun Number.times_(b: Vec3l) = times(b, b, this.L, this.L, this.L)

infix operator fun Number.div(b: Vec3l) = div(Vec3l(), this.L, this.L, this.L, b)
fun Number.div(b: Vec3l, res: Vec3l) = div(res, b, this.L, this.L, this.L)
infix fun Number.div_(b: Vec3l) = div(b, this.L, this.L, this.L, b)

infix operator fun Number.rem(b: Vec3l) = rem(Vec3l(), this.L, this.L, this.L, b)
fun Number.rem(b: Vec3l, res: Vec3l) = rem(res, b, this.L, this.L, this.L)
infix fun Number.rem_(b: Vec3l) = rem(b, this.L, this.L, this.L, b)