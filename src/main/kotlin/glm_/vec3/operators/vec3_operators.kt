package glm_.vec3.operators

import glm_.f
import glm_.vec3.Vec3
import glm_.vec3.Vec3.Companion.div
import glm_.vec3.Vec3.Companion.minus
import glm_.vec3.Vec3.Companion.plus
import glm_.vec3.Vec3.Companion.rem
import glm_.vec3.Vec3.Companion.times

/**
 * Created by elect on 05/11/16.
 */

interface vec3_operators {

    fun plus(res: Vec3, a: Vec3, bX: Float, bY: Float, bZ: Float): Vec3 {
        res.x = a.x + bX
        res.y = a.y + bY
        res.z = a.z + bZ
        return res
    }

    fun minus(res: Vec3, a: Vec3, bX: Float, bY: Float, bZ: Float): Vec3 {
        res.x = a.x - bX
        res.y = a.y - bY
        res.z = a.z - bZ
        return res
    }

    fun minus(res: Vec3, aX: Float, aY: Float, aZ: Float, b: Vec3): Vec3 {
        res.x = aX - b.x
        res.y = aY - b.y
        res.z = aZ - b.z
        return res
    }

    fun times(res: Vec3, a: Vec3, bX: Float, bY: Float, bZ: Float): Vec3 {
        res.x = a.x * bX
        res.y = a.y * bY
        res.z = a.z * bZ
        return res
    }

    fun div(res: Vec3, a: Vec3, bX: Float, bY: Float, bZ: Float): Vec3 {
        res.x = a.x / bX
        res.y = a.y / bY
        res.z = a.z / bZ
        return res
    }

    fun div(res: Vec3, aX: Float, aY: Float, aZ: Float, b: Vec3): Vec3 {
        res.x = aX / b.x
        res.y = aY / b.y
        res.z = aZ / b.z
        return res
    }

    fun rem(res: Vec3, a: Vec3, bX: Float, bY: Float, bZ: Float): Vec3 {
        res.x = a.x % bX
        res.y = a.y % bY
        res.z = a.z % bZ
        return res
    }

    fun rem(res: Vec3, aX: Float, aY: Float, aZ: Float, b: Vec3): Vec3 {
        res.x = aX % b.x
        res.y = aY % b.y
        res.z = aZ % b.z
        return res
    }
}


// -- Specific binary arithmetic operators --

infix operator fun Float.plus(b: Vec3) = plus(Vec3(), b, this, this, this)
fun Float.plus(b: Vec3, res: Vec3) = plus(res, b, this, this, this)
infix fun Float.plusAssign(b: Vec3) = plus(b, b, this, this, this)

infix operator fun Float.minus(b: Vec3) = minus(Vec3(), this, this, this, b)
fun Float.minus(b: Vec3, res: Vec3) = minus(res, b, this, this, this)
infix fun Float.minusAssign(b: Vec3) = minus(b, this, this, this, b)

infix operator fun Float.times(b: Vec3) = times(Vec3(), b, this, this, this)
fun Float.times(b: Vec3, res: Vec3) = times(res, b, this, this, this)
infix fun Float.timesAssign(b: Vec3) = times(b, b, this, this, this)

infix operator fun Float.div(b: Vec3) = div(Vec3(), this, this, this, b)
fun Float.div(b: Vec3, res: Vec3) = div(res, b, this, this, this)
infix fun Float.divAssign(b: Vec3) = div(b, this, this, this, b)

infix operator fun Float.rem(b: Vec3) = rem(Vec3(), this, this, this, b)
fun Float.rem(b: Vec3, res: Vec3) = rem(res, b, this, this, this)
infix fun Float.remAssign(b: Vec3) = rem(b, this, this, this, b)


// -- Generic binary arithmetic operators --

infix operator fun Number.plus(b: Vec3) = plus(Vec3(), b, this.f, this.f, this.f)
fun Number.plus(b: Vec3, res: Vec3) = plus(res, b, this.f, this.f, this.f)
infix fun Number.plusAssign(b: Vec3) = plus(b, b, this.f, this.f, this.f)

infix operator fun Number.minus(b: Vec3) = minus(Vec3(), this.f, this.f, this.f, b)
fun Number.minus(b: Vec3, res: Vec3) = minus(res, b, this.f, this.f, this.f)
infix fun Number.minusAssign(b: Vec3) = minus(b, this.f, this.f, this.f, b)

infix operator fun Number.times(b: Vec3) = times(Vec3(), b, this.f, this.f, this.f)
fun Number.times(b: Vec3, res: Vec3) = times(res, b, this.f, this.f, this.f)
infix fun Number.timesAssign(b: Vec3) = times(b, b, this.f, this.f, this.f)

infix operator fun Number.div(b: Vec3) = div(Vec3(), this.f, this.f, this.f, b)
fun Number.div(b: Vec3, res: Vec3) = div(res, b, this.f, this.f, this.f)
infix fun Number.divAssign(b: Vec3) = div(b, this.f, this.f, this.f, b)

infix operator fun Number.rem(b: Vec3) = rem(Vec3(), this.f, this.f, this.f, b)
fun Number.rem(b: Vec3, res: Vec3) = rem(res, b, this.f, this.f, this.f)
infix fun Number.remAssign(b: Vec3) = rem(b, this.f, this.f, this.f, b)