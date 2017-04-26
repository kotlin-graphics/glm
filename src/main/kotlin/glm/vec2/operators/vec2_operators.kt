package glm.vec2.operators

import glm.f
import glm.vec2.Vec2
import glm.vec2.Vec2.Companion.plus
import glm.vec2.Vec2.Companion.div
import glm.vec2.Vec2.Companion.times
import glm.vec2.Vec2.Companion.rem
import glm.vec2.Vec2.Companion.minus

/**
 * Created by GBarbieri on 13.12.2016.
 */

interface vec2_operators {

    fun plus(res: Vec2, a: Vec2, bX: Float, bY: Float): Vec2 {
        res.x = a.x + bX
        res.y = a.y + bY
        return res
    }

    fun minus(res: Vec2, a: Vec2, bX: Float, bY: Float): Vec2 {
        res.x = a.x - bX
        res.y = a.y - bY
        return res
    }

    fun minus(res: Vec2, aX: Float, aY: Float, b: Vec2): Vec2 {
        res.x = aX - b.x
        res.y = aY - b.y
        return res
    }

    fun times(res: Vec2, a: Vec2, bX: Float, bY: Float): Vec2 {
        res.x = a.x * bX
        res.y = a.y * bY
        return res
    }

    fun div(res: Vec2, a: Vec2, bX: Float, bY: Float): Vec2 {
        res.x = a.x / bX
        res.y = a.y / bY
        return res
    }

    fun div(res: Vec2, aX: Float, aY: Float, b: Vec2): Vec2 {
        res.x = aX / b.x
        res.y = aY / b.y
        return res
    }

    fun rem(res: Vec2, a: Vec2, bX: Float, bY: Float): Vec2 {
        res.x = a.x % bX
        res.y = a.y % bY
        return res
    }

    fun rem(res: Vec2, aX: Float, aY: Float, b: Vec2): Vec2 {
        res.x = aX % b.x
        res.y = aY % b.y
        return res
    }
}


// -- Specific binary arithmetic operators --

infix operator fun Float.plus(b: Vec2) = plus(Vec2(), b, this, this)
fun Float.plus(b: Vec2, res: Vec2) = plus(res, b, this, this)
infix fun Float.plus_(b: Vec2) = plus(b, b, this, this)

infix operator fun Float.minus(b: Vec2) = minus(Vec2(), this, this, b)
fun Float.minus(b: Vec2, res: Vec2) = minus(res, b, this, this)
infix fun Float.minus_(b: Vec2) = minus(b, this, this, b)

infix operator fun Float.times(b: Vec2) = times(Vec2(), b, this, this)
fun Float.times(b: Vec2, res: Vec2) = times(res, b, this, this)
infix fun Float.times_(b: Vec2) = times(b, b, this, this)

infix operator fun Float.div(b: Vec2) = div(Vec2(), this, this, b)
fun Float.div(b: Vec2, res: Vec2) = div(res, b, this, this)
infix fun Float.div_(b: Vec2) = div(b, this, this, b)

infix operator fun Float.rem(b: Vec2) = rem(Vec2(), this, this, b)
fun Float.rem(b: Vec2, res: Vec2) = rem(res, b, this, this)
infix fun Float.rem_(b: Vec2) = rem(b, this, this, b)


// -- Generic binary arithmetic operators --

infix operator fun Number.plus(b: Vec2) = plus(Vec2(), b, this.f, this.f)
fun Number.plus(b: Vec2, res: Vec2) = plus(res, b, this.f, this.f)
infix fun Number.plus_(b: Vec2) = plus(b, b, this.f, this.f)

infix operator fun Number.minus(b: Vec2) = minus(Vec2(), this.f, this.f, b)
fun Number.minus(b: Vec2, res: Vec2) = minus(res, b, this.f, this.f)
infix fun Number.minus_(b: Vec2) = minus(b, this.f, this.f, b)

infix operator fun Number.times(b: Vec2) = times(Vec2(), b, this.f, this.f)
fun Number.times(b: Vec2, res: Vec2) = times(res, b, this.f, this.f)
infix fun Number.times_(b: Vec2) = times(b, b, this.f, this.f)

infix operator fun Number.div(b: Vec2) = div(Vec2(), this.f, this.f, b)
fun Number.div(b: Vec2, res: Vec2) = div(res, b, this.f, this.f)
infix fun Number.div_(b: Vec2) = div(b, this.f, this.f, b)

infix operator fun Number.rem(b: Vec2) = rem(Vec2(), this.f, this.f, b)
fun Number.rem(b: Vec2, res: Vec2) = rem(res, b, this.f, this.f)
infix fun Number.rem_(b: Vec2) = rem(b, this.f, this.f, b)