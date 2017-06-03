package glm_.vec4.operators

import glm_.f
import glm_.vec4.Vec4
import glm_.vec4.Vec4.Companion.plus
import glm_.vec4.Vec4.Companion.div
import glm_.vec4.Vec4.Companion.times
import glm_.vec4.Vec4.Companion.rem
import glm_.vec4.Vec4.Companion.minus

/**
 * Created by elect on 05/11/16.
 */

interface vec4_operators {

    fun plus(res: Vec4, a: Vec4, bX: Float, bY: Float, bZ: Float, bW: Float): Vec4 {
        res.x = a.x + bX
        res.y = a.y + bY
        res.z = a.z + bZ
        res.w = a.w + bW
        return res
    }

    fun minus(res: Vec4, a: Vec4, bX: Float, bY: Float, bZ: Float, bW: Float): Vec4 {
        res.x = a.x - bX
        res.y = a.y - bY
        res.z = a.z - bZ
        res.w = a.w - bW
        return res
    }

    fun minus(res: Vec4, aX: Float, aY: Float, aZ: Float, aW: Float, b: Vec4): Vec4 {
        res.x = aX - b.x
        res.y = aY - b.y
        res.z = aZ - b.z
        res.w = aW - b.w
        return res
    }

    fun times(res: Vec4, a: Vec4, bX: Float, bY: Float, bZ: Float, bW: Float): Vec4 {
        res.x = a.x * bX
        res.y = a.y * bY
        res.z = a.z * bZ
        res.w = a.w * bW
        return res
    }

    fun div(res: Vec4, a: Vec4, bX: Float, bY: Float, bZ: Float, bW: Float): Vec4 {
        res.x = a.x / bX
        res.y = a.y / bY
        res.z = a.z / bZ
        res.w = a.w / bW
        return res
    }

    fun div(res: Vec4, aX: Float, aY: Float, aZ: Float, aW: Float, b: Vec4): Vec4 {
        res.x = aX / b.x
        res.y = aY / b.y
        res.z = aZ / b.z
        res.w = aW / b.w
        return res
    }

    fun rem(res: Vec4, a: Vec4, bX: Float, bY: Float, bZ: Float, bW: Float): Vec4 {
        res.x = a.x % bX
        res.y = a.y % bY
        res.z = a.z % bZ
        res.w = a.w % bW
        return res
    }

    fun rem(res: Vec4, aX: Float, aY: Float, aZ: Float, aW: Float, b: Vec4): Vec4 {
        res.x = aX % b.x
        res.y = aY % b.y
        res.z = aZ % b.z
        res.w = aW % b.w
        return res
    }
}


// -- Specific binary arithmetic operators --

infix operator fun Float.plus(b: Vec4) = plus(Vec4(), b, this, this, this, this)
fun Float.plus(b: Vec4, res: Vec4) = plus(res, b, this, this, this, this)
infix fun Float.plus_(b: Vec4) = plus(b, b, this, this, this, this)

infix operator fun Float.minus(b: Vec4) = minus(Vec4(), this, this, this, this, b)
fun Float.minus(b: Vec4, res: Vec4) = minus(res, b, this, this, this, this)
infix fun Float.minus_(b: Vec4) = minus(b, this, this, this, this, b)

infix operator fun Float.times(b: Vec4) = times(Vec4(), b, this, this, this, this)
fun Float.times(b: Vec4, res: Vec4) = times(res, b, this, this, this, this)
infix fun Float.times_(b: Vec4) = times(b, b, this, this, this, this)

infix operator fun Float.div(b: Vec4) = div(Vec4(), this, this, this, this, b)
fun Float.div(b: Vec4, res: Vec4) = div(res, b, this, this, this, this)
infix fun Float.div_(b: Vec4) = div(b, this, this, this, this, b)

infix operator fun Float.rem(b: Vec4) = rem(Vec4(), this, this, this, this, b)
fun Float.rem(b: Vec4, res: Vec4) = rem(res, b, this, this, this, this)
infix fun Float.rem_(b: Vec4) = rem(b, this, this, this, this, b)


// -- Generic binary arithmetic operators --

infix operator fun Number.plus(b: Vec4) = plus(Vec4(), b, this.f, this.f, this.f, this.f)
fun Number.plus(b: Vec4, res: Vec4) = plus(res, b, this.f, this.f, this.f, this.f)
infix fun Number.plus_(b: Vec4) = plus(b, b, this.f, this.f, this.f, this.f)

infix operator fun Number.minus(b: Vec4) = minus(Vec4(), this.f, this.f, this.f, this.f, b)
fun Number.minus(b: Vec4, res: Vec4) = minus(res, b, this.f, this.f, this.f, this.f)
infix fun Number.minus_(b: Vec4) = minus(b, this.f, this.f, this.f, this.f, b)

infix operator fun Number.times(b: Vec4) = times(Vec4(), b, this.f, this.f, this.f, this.f)
fun Number.times(b: Vec4, res: Vec4) = times(res, b, this.f, this.f, this.f, this.f)
infix fun Number.times_(b: Vec4) = times(b, b, this.f, this.f, this.f, this.f)

infix operator fun Number.div(b: Vec4) = div(Vec4(), this.f, this.f, this.f, this.f, b)
fun Number.div(b: Vec4, res: Vec4) = div(res, b, this.f, this.f, this.f, this.f)
infix fun Number.div_(b: Vec4) = div(b, this.f, this.f, this.f, this.f, b)

infix operator fun Number.rem(b: Vec4) = rem(Vec4(), this.f, this.f, this.f, this.f, b)
fun Number.rem(b: Vec4, res: Vec4) = rem(res, b, this.f, this.f, this.f, this.f)
infix fun Number.rem_(b: Vec4) = rem(b, this.f, this.f, this.f, this.f, b)