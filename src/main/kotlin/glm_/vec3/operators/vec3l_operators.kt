package glm_.vec3.operators

import glm_.*
import glm_.vec3.Vec3l
import glm_.vec3.Vec3l.Companion.div
import glm_.vec3.Vec3l.Companion.minus
import glm_.vec3.Vec3l.Companion.plus
import glm_.vec3.Vec3l.Companion.rem
import glm_.vec3.Vec3l.Companion.times

/**
 * Created by GBarbieri on 08.11.2016.
 */
open class vec3l_operators {

    inline fun plus(res: Vec3l, a: Vec3l, bX: Int, bY: Int, bZ: Int): Vec3l {
        res.x = a.x + bX
        res.y = a.y + bY
        res.z = a.z + bZ
        return res
    }

    inline fun plus(res: Vec3l, a: Vec3l, bX: Long, bY: Long, bZ: Long): Vec3l {
        res.x = a.x + bX
        res.y = a.y + bY
        res.z = a.z + bZ
        return res
    }

    inline fun minus(res: Vec3l, a: Vec3l, bX: Int, bY: Int, bZ: Int): Vec3l {
        res.x = a.x - bX
        res.y = a.y - bY
        res.z = a.z - bZ
        return res
    }

    inline fun minus(res: Vec3l, a: Vec3l, bX: Long, bY: Long, bZ: Long): Vec3l {
        res.x = a.x - bX
        res.y = a.y - bY
        res.z = a.z - bZ
        return res
    }

    inline fun minus(res: Vec3l, aX: Int, aY: Int, aZ: Int, b: Vec3l): Vec3l {
        res.x = aX - b.x
        res.y = aY - b.y
        res.z = aZ - b.z
        return res
    }

    inline fun minus(res: Vec3l, aX: Long, aY: Long, aZ: Long, b: Vec3l): Vec3l {
        res.x = aX - b.x
        res.y = aY - b.y
        res.z = aZ - b.z
        return res
    }

    inline fun times(res: Vec3l, a: Vec3l, bX: Int, bY: Int, bZ: Int): Vec3l {
        res.x = a.x * bX
        res.y = a.y * bY
        res.z = a.z * bZ
        return res
    }

    inline fun times(res: Vec3l, a: Vec3l, bX: Long, bY: Long, bZ: Long): Vec3l {
        res.x = a.x * bX
        res.y = a.y * bY
        res.z = a.z * bZ
        return res
    }

    inline fun div(res: Vec3l, a: Vec3l, bX: Int, bY: Int, bZ: Int): Vec3l {
        res.x = a.x / bX
        res.y = a.y / bY
        res.z = a.z / bZ
        return res
    }

    inline fun div(res: Vec3l, a: Vec3l, bX: Long, bY: Long, bZ: Long): Vec3l {
        res.x = a.x / bX
        res.y = a.y / bY
        res.z = a.z / bZ
        return res
    }

    inline fun div(res: Vec3l, aX: Int, aY: Int, aZ: Int, b: Vec3l): Vec3l {
        res.x = aX / b.x
        res.y = aY / b.y
        res.z = aZ / b.z
        return res
    }

    inline fun div(res: Vec3l, aX: Long, aY: Long, aZ: Long, b: Vec3l): Vec3l {
        res.x = aX / b.x
        res.y = aY / b.y
        res.z = aZ / b.z
        return res
    }

    inline fun rem(res: Vec3l, a: Vec3l, bX: Int, bY: Int, bZ: Int): Vec3l {
        res.x = a.x % bX
        res.y = a.y % bY
        res.z = a.z % bZ
        return res
    }

    inline fun rem(res: Vec3l, a: Vec3l, bX: Long, bY: Long, bZ: Long): Vec3l {
        res.x = a.x % bX
        res.y = a.y % bY
        res.z = a.z % bZ
        return res
    }

    inline fun rem(res: Vec3l, aX: Int, aY: Int, aZ: Int, b: Vec3l): Vec3l {
        res.x = aX % b.x
        res.y = aY % b.y
        res.z = aZ % b.z
        return res
    }

    inline fun rem(res: Vec3l, aX: Long, aY: Long, aZ: Long, b: Vec3l): Vec3l {
        res.x = aX % b.x
        res.y = aY % b.y
        res.z = aZ % b.z
        return res
    }

    inline fun and(res: Vec3l, a: Vec3l, bX: Int, bY: Int, bZ: Int): Vec3l {
        res.x = a.x and bX
        res.y = a.y and bY
        res.z = a.z and bZ
        return res
    }

    inline fun and(res: Vec3l, a: Vec3l, bX: Long, bY: Long, bZ: Long): Vec3l {
        res.x = a.x and bX
        res.y = a.y and bY
        res.z = a.z and bZ
        return res
    }

    inline fun or(res: Vec3l, a: Vec3l, bX: Int, bY: Int, bZ: Int): Vec3l {
        res.x = a.x or bX
        res.y = a.y or bY
        res.z = a.z or bZ
        return res
    }

    inline fun or(res: Vec3l, a: Vec3l, bX: Long, bY: Long, bZ: Long): Vec3l {
        res.x = a.x or bX
        res.y = a.y or bY
        res.z = a.z or bZ
        return res
    }

    inline fun xor(res: Vec3l, a: Vec3l, bX: Int, bY: Int, bZ: Int): Vec3l {
        res.x = a.x xor bX
        res.y = a.y xor bY
        res.z = a.z xor bZ
        return res
    }

    inline fun xor(res: Vec3l, a: Vec3l, bX: Long, bY: Long, bZ: Long): Vec3l {
        res.x = a.x xor bX
        res.y = a.y xor bY
        res.z = a.z xor bZ
        return res
    }

    inline fun shl(res: Vec3l, a: Vec3l, bX: Long, bY: Long, bZ: Long): Vec3l {
        res.x = a.x shl bX.i
        res.y = a.y shl bY.i
        res.z = a.z shl bZ.i
        return res
    }

    inline fun shl(res: Vec3l, a: Vec3l, bX: Int, bY: Int, bZ: Int): Vec3l {
        res.x = a.x shl bX
        res.y = a.y shl bY
        res.z = a.z shl bZ
        return res
    }

    inline fun shr(res: Vec3l, a: Vec3l, bX: Long, bY: Long, bZ: Long): Vec3l {
        res.x = a.x shr bX.i
        res.y = a.y shr bY.i
        res.z = a.z shr bZ.i
        return res
    }

    inline fun shr(res: Vec3l, a: Vec3l, bX: Int, bY: Int, bZ: Int): Vec3l {
        res.x = a.x shr bX
        res.y = a.y shr bY
        res.z = a.z shr bZ
        return res
    }

    inline fun inv(res: Vec3l, a: Vec3l): Vec3l {
        res.x = a.x.inv()
        res.y = a.y.inv()
        res.z = a.z.inv()
        return res
    }
}


// -- Specific binary arithmetic operators --

infix operator fun Long.plus(b: Vec3l) = plus(Vec3l(), b, this, this, this)
fun Long.plus(b: Vec3l, res: Vec3l) = plus(res, b, this, this, this)
infix fun Long.plusAssign(b: Vec3l) = plus(b, b, this, this, this)

infix operator fun Long.minus(b: Vec3l) = minus(Vec3l(), this, this, this, b)
fun Long.minus(b: Vec3l, res: Vec3l) = minus(res, b, this, this, this)
infix fun Long.minusAssign(b: Vec3l) = minus(b, this, this, this, b)

infix operator fun Long.times(b: Vec3l) = times(Vec3l(), b, this, this, this)
fun Long.times(b: Vec3l, res: Vec3l) = times(res, b, this, this, this)
infix fun Long.timesAssign(b: Vec3l) = times(b, b, this, this, this)

infix operator fun Long.div(b: Vec3l) = div(Vec3l(), this, this, this, b)
fun Long.div(b: Vec3l, res: Vec3l) = div(res, b, this, this, this)
infix fun Long.divAssign(b: Vec3l) = div(b, this, this, this, b)

infix operator fun Long.rem(b: Vec3l) = rem(Vec3l(), this, this, this, b)
fun Long.rem(b: Vec3l, res: Vec3l) = rem(res, b, this, this, this)
infix fun Long.remAssign(b: Vec3l) = rem(b, this, this, this, b)


infix operator fun Int.plus(b: Vec3l) = plus(Vec3l(), b, this, this, this)
fun Int.plus(b: Vec3l, res: Vec3l) = plus(res, b, this, this, this)
infix fun Int.plusAssign(b: Vec3l) = plus(b, b, this, this, this)

infix operator fun Int.minus(b: Vec3l) = minus(Vec3l(), this, this, this, b)
fun Int.minus(b: Vec3l, res: Vec3l) = minus(res, b, this, this, this)
infix fun Int.minusAssign(b: Vec3l) = minus(b, this, this, this, b)

infix operator fun Int.times(b: Vec3l) = times(Vec3l(), b, this, this, this)
fun Int.times(b: Vec3l, res: Vec3l) = times(res, b, this, this, this)
infix fun Int.timesAssign(b: Vec3l) = times(b, b, this, this, this)

infix operator fun Int.div(b: Vec3l) = div(Vec3l(), this, this, this, b)
fun Int.div(b: Vec3l, res: Vec3l) = div(res, b, this, this, this)
infix fun Int.divAssign(b: Vec3l) = div(b, this, this, this, b)

infix operator fun Int.rem(b: Vec3l) = rem(Vec3l(), this, this, this, b)
fun Int.rem(b: Vec3l, res: Vec3l) = rem(res, b, this, this, this)
infix fun Int.remAssign(b: Vec3l) = rem(b, this, this, this, b)


// -- Generic binary arithmetic operators --

infix operator fun Number.plus(b: Vec3l) = plus(Vec3l(), b, this.L, this.L, this.L)
fun Number.plus(b: Vec3l, res: Vec3l) = plus(res, b, this.L, this.L, this.L)
infix fun Number.plusAssign(b: Vec3l) = plus(b, b, this.L, this.L, this.L)

infix operator fun Number.minus(b: Vec3l) = minus(Vec3l(), this.L, this.L, this.L, b)
fun Number.minus(b: Vec3l, res: Vec3l) = minus(res, b, this.L, this.L, this.L)
infix fun Number.minusAssign(b: Vec3l) = minus(b, this.L, this.L, this.L, b)

infix operator fun Number.times(b: Vec3l) = times(Vec3l(), b, this.L, this.L, this.L)
fun Number.times(b: Vec3l, res: Vec3l) = times(res, b, this.L, this.L, this.L)
infix fun Number.timesAssign(b: Vec3l) = times(b, b, this.L, this.L, this.L)

infix operator fun Number.div(b: Vec3l) = div(Vec3l(), this.L, this.L, this.L, b)
fun Number.div(b: Vec3l, res: Vec3l) = div(res, b, this.L, this.L, this.L)
infix fun Number.divAssign(b: Vec3l) = div(b, this.L, this.L, this.L, b)

infix operator fun Number.rem(b: Vec3l) = rem(Vec3l(), this.L, this.L, this.L, b)
fun Number.rem(b: Vec3l, res: Vec3l) = rem(res, b, this.L, this.L, this.L)
infix fun Number.remAssign(b: Vec3l) = rem(b, this.L, this.L, this.L, b)