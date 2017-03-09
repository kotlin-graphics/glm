package glm.vec._4.operators

import glm.d
import glm.vec._4.Vec4d
import glm.vec._4.Vec4d.Companion.plus
import glm.vec._4.Vec4d.Companion.div
import glm.vec._4.Vec4d.Companion.times
import glm.vec._4.Vec4d.Companion.rem
import glm.vec._4.Vec4d.Companion.minus

/**
 * Created by GBarbieri on 08.11.2016.
 */
interface vec4d_operators {

    fun plus(res: Vec4d, a: Vec4d, bX: Double, bY: Double, bZ: Double, bW: Double): Vec4d {
        res.x = a.x + bX
        res.y = a.y + bY
        res.z = a.z + bZ
        res.w = a.w + bW
        return res
    }

    fun minus(res: Vec4d, a: Vec4d, bX: Double, bY: Double, bZ: Double, bW: Double): Vec4d {
        res.x = a.x - bX
        res.y = a.y - bY
        res.z = a.z - bZ
        res.w = a.w - bW
        return res
    }

    fun minus(res: Vec4d, aX: Double, aY: Double, aZ: Double, aW: Double, b: Vec4d): Vec4d {
        res.x = aX - b.x
        res.y = aY - b.y
        res.z = aZ - b.z
        res.w = aW - b.w
        return res
    }

    fun times(res: Vec4d, a: Vec4d, bX: Double, bY: Double, bZ: Double, bW: Double): Vec4d {
        res.x = a.x * bX
        res.y = a.y * bY
        res.z = a.z * bZ
        res.w = a.w * bW
        return res
    }

    fun div(res: Vec4d, a: Vec4d, bX: Double, bY: Double, bZ: Double, bW: Double): Vec4d {
        res.x = a.x / bX
        res.y = a.y / bY
        res.z = a.z / bZ
        res.w = a.w / bW
        return res
    }

    fun div(res: Vec4d, aX: Double, aY: Double, aZ: Double, aW: Double, b: Vec4d): Vec4d {
        res.x = aX / b.x
        res.y = aY / b.y
        res.z = aZ / b.z
        res.w = aW / b.w
        return res
    }

    fun rem(res: Vec4d, a: Vec4d, bX: Double, bY: Double, bZ: Double, bW: Double): Vec4d {
        res.x = a.x % bX
        res.y = a.y % bY
        res.z = a.z % bZ
        res.w = a.w % bW
        return res
    }

    fun rem(res: Vec4d, aX: Double, aY: Double, aZ: Double, aW: Double, b: Vec4d): Vec4d {
        res.x = aX % b.x
        res.y = aY % b.y
        res.z = aZ % b.z
        res.w = aW % b.w
        return res
    }
}


// -- Specific binary arithmetic operators --

infix operator fun Double.plus(b: Vec4d) = plus(Vec4d(), b, this, this, this, this)
fun Double.plus(b: Vec4d, res: Vec4d) = plus(res, b, this, this, this, this)
infix fun Double.plus_(b: Vec4d) = plus(b, b, this, this, this, this)

infix operator fun Double.minus(b: Vec4d) = minus(Vec4d(), this, this, this, this, b)
fun Double.minus(b: Vec4d, res: Vec4d) = minus(res, b, this, this, this, this)
infix fun Double.minus_(b: Vec4d) = minus(b, this, this, this, this, b)

infix operator fun Double.times(b: Vec4d) = times(Vec4d(), b, this, this, this, this)
fun Double.times(b: Vec4d, res: Vec4d) = times(res, b, this, this, this, this)
infix fun Double.times_(b: Vec4d) = times(b, b, this, this, this, this)

infix operator fun Double.div(b: Vec4d) = div(Vec4d(), this, this, this, this, b)
fun Double.div(b: Vec4d, res: Vec4d) = div(res, b, this, this, this, this)
infix fun Double.div_(b: Vec4d) = div(b, this, this, this, this, b)

infix operator fun Double.rem(b: Vec4d) = rem(Vec4d(), this, this, this, this, b)
fun Double.rem(b: Vec4d, res: Vec4d) = rem(res, b, this, this, this, this)
infix fun Double.rem_(b: Vec4d) = rem(b, this, this, this, this, b)


// -- Generic binary arithmetic operators --

infix operator fun Number.plus(b: Vec4d) = plus(Vec4d(), b, this.d, this.d, this.d, this.d)
fun Number.plus(b: Vec4d, res: Vec4d) = plus(res, b, this.d, this.d, this.d, this.d)
infix fun Number.plus_(b: Vec4d) = plus(b, b, this.d, this.d, this.d, this.d)

infix operator fun Number.minus(b: Vec4d) = minus(Vec4d(), this.d, this.d, this.d, this.d, b)
fun Number.minus(b: Vec4d, res: Vec4d) = minus(res, b, this.d, this.d, this.d, this.d)
infix fun Number.minus_(b: Vec4d) = minus(b, this.d, this.d, this.d, this.d, b)

infix operator fun Number.times(b: Vec4d) = times(Vec4d(), b, this.d, this.d, this.d, this.d)
fun Number.times(b: Vec4d, res: Vec4d) = times(res, b, this.d, this.d, this.d, this.d)
infix fun Number.times_(b: Vec4d) = times(b, b, this.d, this.d, this.d, this.d)

infix operator fun Number.div(b: Vec4d) = div(Vec4d(), this.d, this.d, this.d, this.d, b)
fun Number.div(b: Vec4d, res: Vec4d) = div(res, b, this.d, this.d, this.d, this.d)
infix fun Number.div_(b: Vec4d) = div(b, this.d, this.d, this.d, this.d, b)

infix operator fun Number.rem(b: Vec4d) = rem(Vec4d(), this.d, this.d, this.d, this.d, b)
fun Number.rem(b: Vec4d, res: Vec4d) = rem(res, b, this.d, this.d, this.d, this.d)
infix fun Number.rem_(b: Vec4d) = rem(b, this.d, this.d, this.d, this.d, b)