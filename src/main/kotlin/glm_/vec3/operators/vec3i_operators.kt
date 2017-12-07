package glm_.vec3.operators

import glm_.i
import glm_.vec3.Vec3i
import glm_.vec3.Vec3i.Companion.div
import glm_.vec3.Vec3i.Companion.minus
import glm_.vec3.Vec3i.Companion.plus
import glm_.vec3.Vec3i.Companion.rem
import glm_.vec3.Vec3i.Companion.times


/**
 * Created by GBarbieri on 08.11.2016.
 */
open class vec3i_operators {

    inline fun plus(res: Vec3i, a: Vec3i, bX: Int, bY: Int, bZ: Int): Vec3i {
        res.x = a.x + bX
        res.y = a.y + bY
        res.z = a.z + bZ
        return res
    }

    inline fun minus(res: Vec3i, a: Vec3i, bX: Int, bY: Int, bZ: Int): Vec3i {
        res.x = a.x - bX
        res.y = a.y - bY
        res.z = a.z - bZ
        return res
    }

    inline fun minus(res: Vec3i, aX: Int, aY: Int, aZ: Int, b: Vec3i): Vec3i {
        res.x = aX - b.x
        res.y = aY - b.y
        res.z = aZ - b.z
        return res
    }

    inline fun times(res: Vec3i, a: Vec3i, bX: Int, bY: Int, bZ: Int): Vec3i {
        res.x = a.x * bX
        res.y = a.y * bY
        res.z = a.z * bZ
        return res
    }

    inline fun div(res: Vec3i, a: Vec3i, bX: Int, bY: Int, bZ: Int): Vec3i {
        res.x = a.x / bX
        res.y = a.y / bY
        res.z = a.z / bZ
        return res
    }

    inline fun div(res: Vec3i, aX: Int, aY: Int, aZ: Int, b: Vec3i): Vec3i {
        res.x = aX / b.x
        res.y = aY / b.y
        res.z = aZ / b.z
        return res
    }

    inline fun rem(res: Vec3i, a: Vec3i, bX: Int, bY: Int, bZ: Int): Vec3i {
        res.x = a.x % bX
        res.y = a.y % bY
        res.z = a.z % bZ
        return res
    }

    inline fun rem(res: Vec3i, aX: Int, aY: Int, aZ: Int, b: Vec3i): Vec3i {
        res.x = aX % b.x
        res.y = aY % b.y
        res.z = aZ % b.z
        return res
    }

    inline fun and(res: Vec3i, a: Vec3i, bX: Int, bY: Int, bZ: Int): Vec3i {
        res.x = a.x and bX
        res.y = a.y and bY
        res.z = a.z and bZ
        return res
    }

    inline fun or(res: Vec3i, a: Vec3i, bX: Int, bY: Int, bZ: Int): Vec3i {
        res.x = a.x or bX
        res.y = a.y or bY
        res.z = a.z or bZ
        return res
    }

    inline fun xor(res: Vec3i, a: Vec3i, bX: Int, bY: Int, bZ: Int): Vec3i {
        res.x = a.x xor bX
        res.y = a.y xor bY
        res.z = a.z xor bZ
        return res
    }

    inline fun shl(res: Vec3i, a: Vec3i, bX: Int, bY: Int, bZ: Int): Vec3i {
        res.x = a.x shl bX
        res.y = a.y shl bY
        res.z = a.z shl bZ
        return res
    }

    inline fun shr(res: Vec3i, a: Vec3i, bX: Int, bY: Int, bZ: Int): Vec3i {
        res.x = a.x shr bX
        res.y = a.y shr bY
        res.z = a.z shr bZ
        return res
    }

    // TODO others
    inline fun ushr(res: Vec3i, a: Vec3i, bX: Int, bY: Int, bZ: Int): Vec3i {
        res.x = a.x ushr bX
        res.y = a.y ushr bY
        res.z = a.z ushr bZ
        return res
    }

    inline fun inv(res: Vec3i, a: Vec3i): Vec3i {
        res.x = a.x.inv()
        res.y = a.y.inv()
        res.z = a.z.inv()
        return res
    }
}


// -- Specific binary arithmetic operators --

infix operator fun Int.plus(b: Vec3i) = plus(Vec3i(), b, this, this, this)
fun Int.plus(b: Vec3i, res: Vec3i) = plus(res, b, this, this, this)
infix fun Int.plusAssign(b: Vec3i) = plus(b, b, this, this, this)

infix operator fun Int.minus(b: Vec3i) = minus(Vec3i(), this, this, this, b)
fun Int.minus(b: Vec3i, res: Vec3i) = minus(res, b, this, this, this)
infix fun Int.minusAssign(b: Vec3i) = minus(b, this, this, this, b)

infix operator fun Int.times(b: Vec3i) = times(Vec3i(), b, this, this, this)
fun Int.times(b: Vec3i, res: Vec3i) = times(res, b, this, this, this)
infix fun Int.timesAssign(b: Vec3i) = times(b, b, this, this, this)

infix operator fun Int.div(b: Vec3i) = div(Vec3i(), this, this, this, b)
fun Int.div(b: Vec3i, res: Vec3i) = div(res, b, this, this, this)
infix fun Int.divAssign(b: Vec3i) = div(b, this, this, this, b)

infix operator fun Int.rem(b: Vec3i) = rem(Vec3i(), this, this, this, b)
fun Int.rem(b: Vec3i, res: Vec3i) = rem(res, b, this, this, this)
infix fun Int.remAssign(b: Vec3i) = rem(b, this, this, this, b)


// -- Generic binary arithmetic operators --

infix operator fun Number.plus(b: Vec3i) = plus(Vec3i(), b, this.i, this.i, this.i)
fun Number.plus(b: Vec3i, res: Vec3i) = plus(res, b, this.i, this.i, this.i)
infix fun Number.plusAssign(b: Vec3i) = plus(b, b, this.i, this.i, this.i)

infix operator fun Number.minus(b: Vec3i) = minus(Vec3i(), this.i, this.i, this.i, b)
fun Number.minus(b: Vec3i, res: Vec3i) = minus(res, b, this.i, this.i, this.i)
infix fun Number.minusAssign(b: Vec3i) = minus(b, this.i, this.i, this.i, b)

infix operator fun Number.times(b: Vec3i) = times(Vec3i(), b, this.i, this.i, this.i)
fun Number.times(b: Vec3i, res: Vec3i) = times(res, b, this.i, this.i, this.i)
infix fun Number.timesAssign(b: Vec3i) = times(b, b, this.i, this.i, this.i)

infix operator fun Number.div(b: Vec3i) = div(Vec3i(), this.i, this.i, this.i, b)
fun Number.div(b: Vec3i, res: Vec3i) = div(res, b, this.i, this.i, this.i)
infix fun Number.divAssign(b: Vec3i) = div(b, this.i, this.i, this.i, b)

infix operator fun Number.rem(b: Vec3i) = rem(Vec3i(), this.i, this.i, this.i, b)
fun Number.rem(b: Vec3i, res: Vec3i) = rem(res, b, this.i, this.i, this.i)
infix fun Number.remAssign(b: Vec3i) = rem(b, this.i, this.i, this.i, b)