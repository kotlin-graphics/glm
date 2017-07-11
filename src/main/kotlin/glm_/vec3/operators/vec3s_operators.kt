package glm_.vec3.operators

import glm_.*
import glm_.vec3.Vec3s
import glm_.vec3.Vec3s.Companion.div
import glm_.vec3.Vec3s.Companion.minus
import glm_.vec3.Vec3s.Companion.plus
import glm_.vec3.Vec3s.Companion.rem
import glm_.vec3.Vec3s.Companion.times
import kotlin.experimental.and
import kotlin.experimental.inv
import kotlin.experimental.or
import kotlin.experimental.xor

/**
 * Created by GBarbieri on 08.11.2016.
 */
interface vec3s_operators {

    fun plus(res: Vec3s, a: Vec3s, bX: Short, bY: Short, bZ: Short): Vec3s {
        res.x = (a.x + bX).s
        res.y = (a.y + bY).s
        res.z = (a.z + bZ).s
        return res
    }

    fun plus(res: Vec3s, a: Vec3s, bX: Int, bY: Int, bZ: Int): Vec3s {
        res.x = (a.x + bX).s
        res.y = (a.y + bY).s
        res.z = (a.z + bZ).s
        return res
    }

    fun minus(res: Vec3s, a: Vec3s, bX: Short, bY: Short, bZ: Short): Vec3s {
        res.x = (a.x - bX).s
        res.y = (a.y - bY).s
        res.z = (a.z - bZ).s
        return res
    }

    fun minus(res: Vec3s, a: Vec3s, bX: Int, bY: Int, bZ: Int): Vec3s {
        res.x = (a.x - bX).s
        res.y = (a.y - bY).s
        res.z = (a.z - bZ).s
        return res
    }

    fun minus(res: Vec3s, aX: Short, aY: Short, aZ: Short, b: Vec3s): Vec3s {
        res.x = (aX - b.x).s
        res.y = (aY - b.y).s
        res.z = (aZ - b.z).s
        return res
    }

    fun minus(res: Vec3s, aX: Int, aY: Int, aZ: Int, b: Vec3s): Vec3s {
        res.x = (aX - b.x).s
        res.y = (aY - b.y).s
        res.z = (aZ - b.z).s
        return res
    }

    fun times(res: Vec3s, a: Vec3s, bX: Short, bY: Short, bZ: Short): Vec3s {
        res.x = (a.x * bX).s
        res.y = (a.y * bY).s
        res.z = (a.z * bZ).s
        return res
    }

    fun times(res: Vec3s, a: Vec3s, bX: Int, bY: Int, bZ: Int): Vec3s {
        res.x = (a.x * bX).s
        res.y = (a.y * bY).s
        res.z = (a.z * bZ).s
        return res
    }

    fun div(res: Vec3s, a: Vec3s, bX: Short, bY: Short, bZ: Short): Vec3s {
        res.x = (a.x / bX).s
        res.y = (a.y / bY).s
        res.z = (a.z / bZ).s
        return res
    }

    fun div(res: Vec3s, a: Vec3s, bX: Int, bY: Int, bZ: Int): Vec3s {
        res.x = (a.x / bX).s
        res.y = (a.y / bY).s
        res.z = (a.z / bZ).s
        return res
    }

    fun div(res: Vec3s, aX: Short, aY: Short, aZ: Short, b: Vec3s): Vec3s {
        res.x = (aX / b.x).s
        res.y = (aY / b.y).s
        res.z = (aZ / b.z).s
        return res
    }

    fun div(res: Vec3s, aX: Int, aY: Int, aZ: Int, b: Vec3s): Vec3s {
        res.x = (aX / b.x).s
        res.y = (aY / b.y).s
        res.z = (aZ / b.z).s
        return res
    }

    fun rem(res: Vec3s, a: Vec3s, bX: Short, bY: Short, bZ: Short): Vec3s {
        res.x = (a.x % bX).s
        res.y = (a.y % bY).s
        res.z = (a.z % bZ).s
        return res
    }

    fun rem(res: Vec3s, a: Vec3s, bX: Int, bY: Int, bZ: Int): Vec3s {
        res.x = (a.x % bX).s
        res.y = (a.y % bY).s
        res.z = (a.z % bZ).s
        return res
    }

    fun rem(res: Vec3s, aX: Short, aY: Short, aZ: Short, b: Vec3s): Vec3s {
        res.x = (aX % b.x).s
        res.y = (aY % b.y).s
        res.z = (aZ % b.z).s
        return res
    }

    fun rem(res: Vec3s, aX: Int, aY: Int, aZ: Int, b: Vec3s): Vec3s {
        res.x = (aX % b.x).s
        res.y = (aY % b.y).s
        res.z = (aZ % b.z).s
        return res
    }

    fun and(res: Vec3s, a: Vec3s, bX: Short, bY: Short, bZ: Short): Vec3s {
        res.x = a.x and bX
        res.y = a.y and bY
        res.z = a.z and bZ
        return res
    }

    fun and(res: Vec3s, a: Vec3s, bX: Int, bY: Int, bZ: Int): Vec3s {
        res.x = a.x and bX
        res.y = a.y and bY
        res.z = a.z and bZ
        return res
    }

    fun or(res: Vec3s, a: Vec3s, bX: Short, bY: Short, bZ: Short): Vec3s {
        res.x = a.x or bX
        res.y = a.y or bY
        res.z = a.z or bZ
        return res
    }

    fun or(res: Vec3s, a: Vec3s, bX: Int, bY: Int, bZ: Int): Vec3s {
        res.x = a.x or bX
        res.y = a.y or bY
        res.z = a.z or bZ
        return res
    }

    fun xor(res: Vec3s, a: Vec3s, bX: Short, bY: Short, bZ: Short): Vec3s {
        res.x = a.x xor bX
        res.y = a.y xor bY
        res.z = a.z xor bZ
        return res
    }

    fun xor(res: Vec3s, a: Vec3s, bX: Int, bY: Int, bZ: Int): Vec3s {
        res.x = a.x xor bX
        res.y = a.y xor bY
        res.z = a.z xor bZ
        return res
    }

    fun shl(res: Vec3s, a: Vec3s, bX: Short, bY: Short, bZ: Short): Vec3s {
        res.x = a.x shl bX
        res.y = a.y shl bY
        res.z = a.z shl bZ
        return res
    }

    fun shl(res: Vec3s, a: Vec3s, bX: Int, bY: Int, bZ: Int): Vec3s {
        res.x = a.x shl bX
        res.y = a.y shl bY
        res.z = a.z shl bZ
        return res
    }

    fun shr(res: Vec3s, a: Vec3s, bX: Short, bY: Short, bZ: Short): Vec3s {
        res.x = a.x shr bX
        res.y = a.y shr bY
        res.z = a.z shr bZ
        return res
    }

    fun shr(res: Vec3s, a: Vec3s, bX: Int, bY: Int, bZ: Int): Vec3s {
        res.x = a.x shr bX
        res.y = a.y shr bY
        res.z = a.z shr bZ
        return res
    }

    fun inv(res: Vec3s, a: Vec3s): Vec3s {
        res.x = a.x.inv()
        res.y = a.y.inv()
        res.z = a.z.inv()
        return res
    }
}


// -- Specific binary arithmetic operators --

infix operator fun Short.plus(b: Vec3s) = plus(Vec3s(), b, this, this, this)
fun Short.plus(b: Vec3s, res: Vec3s) = plus(res, b, this, this, this)
infix fun Short.plus_(b: Vec3s) = plus(b, b, this, this, this)

infix operator fun Short.minus(b: Vec3s) = minus(Vec3s(), this, this, this, b)
fun Short.minus(b: Vec3s, res: Vec3s) = minus(res, b, this, this, this)
infix fun Short.minus_(b: Vec3s) = minus(b, this, this, this, b)

infix operator fun Short.times(b: Vec3s) = times(Vec3s(), b, this, this, this)
fun Short.times(b: Vec3s, res: Vec3s) = times(res, b, this, this, this)
infix fun Short.times_(b: Vec3s) = times(b, b, this, this, this)

infix operator fun Short.div(b: Vec3s) = div(Vec3s(), this, this, this, b)
fun Short.div(b: Vec3s, res: Vec3s) = div(res, b, this, this, this)
infix fun Short.div_(b: Vec3s) = div(b, this, this, this, b)

infix operator fun Short.rem(b: Vec3s) = rem(Vec3s(), this, this, this, b)
fun Short.rem(b: Vec3s, res: Vec3s) = rem(res, b, this, this, this)
infix fun Short.rem_(b: Vec3s) = rem(b, this, this, this, b)


infix operator fun Int.plus(b: Vec3s) = plus(Vec3s(), b, this, this, this)
fun Int.plus(b: Vec3s, res: Vec3s) = plus(res, b, this, this, this)
infix fun Int.plus_(b: Vec3s) = plus(b, b, this, this, this)

infix operator fun Int.minus(b: Vec3s) = minus(Vec3s(), this, this, this, b)
fun Int.minus(b: Vec3s, res: Vec3s) = minus(res, b, this, this, this)
infix fun Int.minus_(b: Vec3s) = minus(b, this, this, this, b)

infix operator fun Int.times(b: Vec3s) = times(Vec3s(), b, this, this, this)
fun Int.times(b: Vec3s, res: Vec3s) = times(res, b, this, this, this)
infix fun Int.times_(b: Vec3s) = times(b, b, this, this, this)

infix operator fun Int.div(b: Vec3s) = div(Vec3s(), this, this, this, b)
fun Int.div(b: Vec3s, res: Vec3s) = div(res, b, this, this, this)
infix fun Int.div_(b: Vec3s) = div(b, this, this, this, b)

infix operator fun Int.rem(b: Vec3s) = rem(Vec3s(), this, this, this, b)
fun Int.rem(b: Vec3s, res: Vec3s) = rem(res, b, this, this, this)
infix fun Int.rem_(b: Vec3s) = rem(b, this, this, this, b)


// -- Specific binary arithmetic operators --

infix operator fun Number.plus(b: Vec3s) = plus(Vec3s(), b, this.s, this.s, this.s)
fun Number.plus(b: Vec3s, res: Vec3s) = plus(res, b, this.s, this.s, this.s)
infix fun Number.plus_(b: Vec3s) = plus(b, b, this.s, this.s, this.s)

infix operator fun Number.minus(b: Vec3s) = minus(Vec3s(), this.s, this.s, this.s, b)
fun Number.minus(b: Vec3s, res: Vec3s) = minus(res, b, this.s, this.s, this.s)
infix fun Number.minus_(b: Vec3s) = minus(b, this.s, this.s, this.s, b)

infix operator fun Number.times(b: Vec3s) = times(Vec3s(), b, this.s, this.s, this.s)
fun Number.times(b: Vec3s, res: Vec3s) = times(res, b, this.s, this.s, this.s)
infix fun Number.times_(b: Vec3s) = times(b, b, this.s, this.s, this.s)

infix operator fun Number.div(b: Vec3s) = div(Vec3s(), this.s, this.s, this.s, b)
fun Number.div(b: Vec3s, res: Vec3s) = div(res, b, this.s, this.s, this.s)
infix fun Number.div_(b: Vec3s) = div(b, this.s, this.s, this.s, b)

infix operator fun Number.rem(b: Vec3s) = rem(Vec3s(), this.s, this.s, this.s, b)
fun Number.rem(b: Vec3s, res: Vec3s) = rem(res, b, this.s, this.s, this.s)
infix fun Number.rem_(b: Vec3s) = rem(b, this.s, this.s, this.s, b)