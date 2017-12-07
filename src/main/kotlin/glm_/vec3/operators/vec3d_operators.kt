package glm_.vec3.operators

import glm_.d
import glm_.vec3.Vec3d
import glm_.vec3.Vec3d.Companion.div
import glm_.vec3.Vec3d.Companion.minus
import glm_.vec3.Vec3d.Companion.plus
import glm_.vec3.Vec3d.Companion.rem
import glm_.vec3.Vec3d.Companion.times

/**
 * Created by GBarbieri on 08.11.2016.
 */
open class vec3d_operators() {

    inline fun plus(res: Vec3d, a: Vec3d, bX: Double, bY: Double, bZ: Double): Vec3d {
        res.x = a.x + bX
        res.y = a.y + bY
        res.z = a.z + bZ
        return res
    }

    inline fun minus(res: Vec3d, a: Vec3d, bX: Double, bY: Double, bZ: Double): Vec3d {
        res.x = a.x - bX
        res.y = a.y - bY
        res.z = a.z - bZ
        return res
    }

    inline fun minus(res: Vec3d, aX: Double, aY: Double, aZ: Double, b: Vec3d): Vec3d {
        res.x = aX - b.x
        res.y = aY - b.y
        res.z = aZ - b.z
        return res
    }

    inline fun times(res: Vec3d, a: Vec3d, bX: Double, bY: Double, bZ: Double): Vec3d {
        res.x = a.x * bX
        res.y = a.y * bY
        res.z = a.z * bZ
        return res
    }

    inline fun div(res: Vec3d, a: Vec3d, bX: Double, bY: Double, bZ: Double): Vec3d {
        res.x = a.x / bX
        res.y = a.y / bY
        res.z = a.z / bZ
        return res
    }

    inline fun div(res: Vec3d, aX: Double, aY: Double, aZ: Double, b: Vec3d): Vec3d {
        res.x = aX / b.x
        res.y = aY / b.y
        res.z = aZ / b.z
        return res
    }

    inline fun rem(res: Vec3d, a: Vec3d, bX: Double, bY: Double, bZ: Double): Vec3d {
        res.x = a.x % bX
        res.y = a.y % bY
        res.z = a.z % bZ
        return res
    }

    inline fun rem(res: Vec3d, aX: Double, aY: Double, aZ: Double, b: Vec3d): Vec3d {
        res.x = aX % b.x
        res.y = aY % b.y
        res.z = aZ % b.z
        return res
    }
}


// -- Specific binary arithmetic operators --

infix operator fun Double.plus(b: Vec3d) = plus(Vec3d(), b, this, this, this)
fun Double.plus(b: Vec3d, res: Vec3d) = plus(res, b, this, this, this)
infix fun Double.plusAssign(b: Vec3d) = plus(b, b, this, this, this)

infix operator fun Double.minus(b: Vec3d) = minus(Vec3d(), this, this, this, b)
fun Double.minus(b: Vec3d, res: Vec3d) = minus(res, b, this, this, this)
infix fun Double.minusAssign(b: Vec3d) = minus(b, this, this, this, b)

infix operator fun Double.times(b: Vec3d) = times(Vec3d(), b, this, this, this)
fun Double.times(b: Vec3d, res: Vec3d) = times(res, b, this, this, this)
infix fun Double.timesAssign(b: Vec3d) = times(b, b, this, this, this)

infix operator fun Double.div(b: Vec3d) = div(Vec3d(), this, this, this, b)
fun Double.div(b: Vec3d, res: Vec3d) = div(res, b, this, this, this)
infix fun Double.divAssign(b: Vec3d) = div(b, this, this, this, b)

infix operator fun Double.rem(b: Vec3d) = rem(Vec3d(), this, this, this, b)
fun Double.rem(b: Vec3d, res: Vec3d) = rem(res, b, this, this, this)
infix fun Double.remAssign(b: Vec3d) = rem(b, this, this, this, b)


// -- Generic binary arithmetic operators --

infix operator fun Number.plus(b: Vec3d) = plus(Vec3d(), b, this.d, this.d, this.d)
fun Number.plus(b: Vec3d, res: Vec3d) = plus(res, b, this.d, this.d, this.d)
infix fun Number.plusAssign(b: Vec3d) = plus(b, b, this.d, this.d, this.d)

infix operator fun Number.minus(b: Vec3d) = minus(Vec3d(), this.d, this.d, this.d, b)
fun Number.minus(b: Vec3d, res: Vec3d) = minus(res, b, this.d, this.d, this.d)
infix fun Number.minusAssign(b: Vec3d) = minus(b, this.d, this.d, this.d, b)

infix operator fun Number.times(b: Vec3d) = times(Vec3d(), b, this.d, this.d, this.d)
fun Number.times(b: Vec3d, res: Vec3d) = times(res, b, this.d, this.d, this.d)
infix fun Number.timesAssign(b: Vec3d) = times(b, b, this.d, this.d, this.d)

infix operator fun Number.div(b: Vec3d) = div(Vec3d(), this.d, this.d, this.d, b)
fun Number.div(b: Vec3d, res: Vec3d) = div(res, b, this.d, this.d, this.d)
infix fun Number.divAssign(b: Vec3d) = div(b, this.d, this.d, this.d, b)

infix operator fun Number.rem(b: Vec3d) = rem(Vec3d(), this.d, this.d, this.d, b)
fun Number.rem(b: Vec3d, res: Vec3d) = rem(res, b, this.d, this.d, this.d)
infix fun Number.remAssign(b: Vec3d) = rem(b, this.d, this.d, this.d, b)