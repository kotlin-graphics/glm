package glm.vec3.operators

import glm.*
import glm.vec3.Vec3b
import kotlin.experimental.*
import glm.vec3.Vec3b.Companion.plus
import glm.vec3.Vec3b.Companion.div
import glm.vec3.Vec3b.Companion.times
import glm.vec3.Vec3b.Companion.rem
import glm.vec3.Vec3b.Companion.minus

/**
 * Created by GBarbieri on 08.11.2016.
 */
interface vec3b_operators {

    fun plus(res: Vec3b, a: Vec3b, bX: Byte, bY: Byte, bZ: Byte): Vec3b {
        res.x = (a.x + bX).b
        res.y = (a.y + bY).b
        res.z = (a.z + bZ).b
        return res
    }

    fun plus(res: Vec3b, a: Vec3b, bX: Int, bY: Int, bZ: Int): Vec3b {
        res.x = (a.x + bX).b
        res.y = (a.y + bY).b
        res.z = (a.z + bZ).b
        return res
    }

    fun minus(res: Vec3b, a: Vec3b, bX: Byte, bY: Byte, bZ: Byte): Vec3b {
        res.x = (a.x - bX).b
        res.y = (a.y - bY).b
        res.z = (a.z - bZ).b
        return res
    }

    fun minus(res: Vec3b, a: Vec3b, bX: Int, bY: Int, bZ: Int): Vec3b {
        res.x = (a.x - bX).b
        res.y = (a.y - bY).b
        res.z = (a.z - bZ).b
        return res
    }

    fun minus(res: Vec3b, aX: Byte, aY: Byte, aZ: Byte, b: Vec3b): Vec3b {
        res.x = (aX - b.x).b
        res.y = (aY - b.y).b
        res.z = (aZ - b.z).b
        return res
    }

    fun minus(res: Vec3b, aX: Int, aY: Int, aZ: Int, b: Vec3b): Vec3b {
        res.x = (aX - b.x).b
        res.y = (aY - b.y).b
        res.z = (aZ - b.z).b
        return res
    }

    fun times(res: Vec3b, a: Vec3b, bX: Byte, bY: Byte, bZ: Byte): Vec3b {
        res.x = (a.x * bX).b
        res.y = (a.y * bY).b
        res.z = (a.z * bZ).b
        return res
    }

    fun times(res: Vec3b, a: Vec3b, bX: Int, bY: Int, bZ: Int): Vec3b {
        res.x = (a.x * bX).b
        res.y = (a.y * bY).b
        res.z = (a.z * bZ).b
        return res
    }

    fun div(res: Vec3b, a: Vec3b, bX: Byte, bY: Byte, bZ: Byte): Vec3b {
        res.x = (a.x / bX).b
        res.y = (a.y / bY).b
        res.z = (a.z / bZ).b
        return res
    }

    fun div(res: Vec3b, a: Vec3b, bX: Int, bY: Int, bZ: Int): Vec3b {
        res.x = (a.x / bX).b
        res.y = (a.y / bY).b
        res.z = (a.z / bZ).b
        return res
    }

    fun div(res: Vec3b, aX: Byte, aY: Byte, aZ: Byte, b: Vec3b): Vec3b {
        res.x = (aX / b.x).b
        res.y = (aY / b.y).b
        res.z = (aZ / b.z).b
        return res
    }

    fun div(res: Vec3b, aX: Int, aY: Int, aZ: Int, b: Vec3b): Vec3b {
        res.x = (aX / b.x).b
        res.y = (aY / b.y).b
        res.z = (aZ / b.z).b
        return res
    }

    fun rem(res: Vec3b, a: Vec3b, bX: Byte, bY: Byte, bZ: Byte): Vec3b {
        res.x = (a.x % bX).b
        res.y = (a.y % bY).b
        res.z = (a.z % bZ).b
        return res
    }

    fun rem(res: Vec3b, a: Vec3b, bX: Int, bY: Int, bZ: Int): Vec3b {
        res.x = (a.x % bX).b
        res.y = (a.y % bY).b
        res.z = (a.z % bZ).b
        return res
    }

    fun rem(res: Vec3b, aX: Byte, aY: Byte, aZ: Byte, b: Vec3b): Vec3b {
        res.x = (aX % b.x).b
        res.y = (aY % b.y).b
        res.z = (aZ % b.z).b
        return res
    }

    fun rem(res: Vec3b, aX: Int, aY: Int, aZ: Int, b: Vec3b): Vec3b {
        res.x = (aX % b.x).b
        res.y = (aY % b.y).b
        res.z = (aZ % b.z).b
        return res
    }

    fun and(res: Vec3b, a: Vec3b, bX: Byte, bY: Byte, bZ: Byte): Vec3b {
        res.x = a.x and bX
        res.y = a.y and bY
        res.z = a.z and bZ
        return res
    }

    fun and(res: Vec3b, a: Vec3b, bX: Int, bY: Int, bZ: Int): Vec3b {
        res.x = a.x and bX
        res.y = a.y and bY
        res.z = a.z and bZ
        return res
    }

    fun or(res: Vec3b, a: Vec3b, bX: Byte, bY: Byte, bZ: Byte): Vec3b {
        res.x = a.x or bX
        res.y = a.y or bY
        res.z = a.z or bZ
        return res
    }

    fun or(res: Vec3b, a: Vec3b, bX: Int, bY: Int, bZ: Int): Vec3b {
        res.x = a.x or bX
        res.y = a.y or bY
        res.z = a.z or bZ
        return res
    }

    fun xor(res: Vec3b, a: Vec3b, bX: Byte, bY: Byte, bZ: Byte): Vec3b {
        res.x = a.x xor bX
        res.y = a.y xor bY
        res.z = a.z xor bZ
        return res
    }

    fun xor(res: Vec3b, a: Vec3b, bX: Int, bY: Int, bZ: Int): Vec3b {
        res.x = a.x xor bX
        res.y = a.y xor bY
        res.z = a.z xor bZ
        return res
    }

    fun shl(res: Vec3b, a: Vec3b, bX: Byte, bY: Byte, bZ: Byte): Vec3b {
        res.x = a.x shl bX
        res.y = a.y shl bY
        res.z = a.z shl bZ
        return res
    }

    fun shl(res: Vec3b, a: Vec3b, bX: Int, bY: Int, bZ: Int): Vec3b {
        res.x = a.x shl bX
        res.y = a.y shl bY
        res.z = a.z shl bZ
        return res
    }

    fun shr(res: Vec3b, a: Vec3b, bX: Byte, bY: Byte, bZ: Byte): Vec3b {
        res.x = a.x shr bX
        res.y = a.y shr bY
        res.z = a.z shr bZ
        return res
    }

    fun shr(res: Vec3b, a: Vec3b, bX: Int, bY: Int, bZ: Int): Vec3b {
        res.x = a.x shr bX
        res.y = a.y shr bY
        res.z = a.z shr bZ
        return res
    }

    fun inv(res: Vec3b, a: Vec3b): Vec3b {
        res.x = a.x.inv()
        res.y = a.y.inv()
        res.z = a.z.inv()
        return res
    }
}


// -- Specific binary arithmetic operators --

infix operator fun Byte.plus(b: Vec3b) = plus(Vec3b(), b, this, this, this)
fun Byte.plus(b: Vec3b, res: Vec3b) = plus(res, b, this, this, this)
infix fun Byte.plus_(b: Vec3b) = plus(b, b, this, this, this)

infix operator fun Byte.minus(b: Vec3b) = minus(Vec3b(), this, this, this, b)
fun Byte.minus(b: Vec3b, res: Vec3b) = minus(res, b, this, this, this)
infix fun Byte.minus_(b: Vec3b) = minus(b, this, this, this, b)

infix operator fun Byte.times(b: Vec3b) = times(Vec3b(), b, this, this, this)
fun Byte.times(b: Vec3b, res: Vec3b) = times(res, b, this, this, this)
infix fun Byte.times_(b: Vec3b) = times(b, b, this, this, this)

infix operator fun Byte.div(b: Vec3b) = div(Vec3b(), this, this, this, b)
fun Byte.div(b: Vec3b, res: Vec3b) = div(res, b, this, this, this)
infix fun Byte.div_(b: Vec3b) = div(b, this, this, this, b)

infix operator fun Byte.rem(b: Vec3b) = rem(Vec3b(), this, this, this, b)
fun Byte.rem(b: Vec3b, res: Vec3b) = rem(res, b, this, this, this)
infix fun Byte.rem_(b: Vec3b) = rem(b, this, this, this, b)


infix operator fun Int.plus(b: Vec3b) = plus(Vec3b(), b, this, this, this)
fun Int.plus(b: Vec3b, res: Vec3b) = plus(res, b, this, this, this)
infix fun Int.plus_(b: Vec3b) = plus(b, b, this, this, this)

infix operator fun Int.minus(b: Vec3b) = minus(Vec3b(), this, this, this, b)
fun Int.minus(b: Vec3b, res: Vec3b) = minus(res, b, this, this, this)
infix fun Int.minus_(b: Vec3b) = minus(b, this, this, this, b)

infix operator fun Int.times(b: Vec3b) = times(Vec3b(), b, this, this, this)
fun Int.times(b: Vec3b, res: Vec3b) = times(res, b, this, this, this)
infix fun Int.times_(b: Vec3b) = times(b, b, this, this, this)

infix operator fun Int.div(b: Vec3b) = div(Vec3b(), this, this, this, b)
fun Int.div(b: Vec3b, res: Vec3b) = div(res, b, this, this, this)
infix fun Int.div_(b: Vec3b) = div(b, this, this, this, b)

infix operator fun Int.rem(b: Vec3b) = rem(Vec3b(), this, this, this, b)
fun Int.rem(b: Vec3b, res: Vec3b) = rem(res, b, this, this, this)
infix fun Int.rem_(b: Vec3b) = rem(b, this, this, this, b)


// -- Generic binary arithmetic operators --

infix operator fun Number.plus(b: Vec3b) = plus(Vec3b(), b, this.b, this.b, this.b)
fun Number.plus(b: Vec3b, res: Vec3b) = plus(res, b, this.b, this.b, this.b)
infix fun Number.plus_(b: Vec3b) = plus(b, b, this.b, this.b, this.b)

infix operator fun Number.minus(b: Vec3b) = minus(Vec3b(), this.b, this.b, this.b, b)
fun Number.minus(b: Vec3b, res: Vec3b) = minus(res, b, this.b, this.b, this.b)
infix fun Number.minus_(b: Vec3b) = minus(b, this.b, this.b, this.b, b)

infix operator fun Number.times(b: Vec3b) = times(Vec3b(), b, this.b, this.b, this.b)
fun Number.times(b: Vec3b, res: Vec3b) = times(res, b, this.b, this.b, this.b)
infix fun Number.times_(b: Vec3b) = times(b, b, this.b, this.b, this.b)

infix operator fun Number.div(b: Vec3b) = div(Vec3b(), this.b, this.b, this.b, b)
fun Number.div(b: Vec3b, res: Vec3b) = div(res, b, this.b, this.b, this.b)
infix fun Number.div_(b: Vec3b) = div(b, this.b, this.b, this.b, b)

infix operator fun Number.rem(b: Vec3b) = rem(Vec3b(), this.b, this.b, this.b, b)
fun Number.rem(b: Vec3b, res: Vec3b) = rem(res, b, this.b, this.b, this.b)
infix fun Number.rem_(b: Vec3b) = rem(b, this.b, this.b, this.b, b)