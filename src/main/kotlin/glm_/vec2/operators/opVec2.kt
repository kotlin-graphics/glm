package glm_.vec2.operators

import glm_.f
import glm_.vec2.Vec2
import glm_.vec2.Vec2.Companion.div
import glm_.vec2.Vec2.Companion.minus
import glm_.vec2.Vec2.Companion.plus
import glm_.vec2.Vec2.Companion.rem
import glm_.vec2.Vec2.Companion.times

/**
 * Created by GBarbieri on 13.12.2016.
 */

open class opVec2 {

    inline fun plus(res: Vec2, a: Vec2, bX: Float, bY: Float): Vec2 {
        res.x = a.x + bX
        res.y = a.y + bY
        return res
    }

    inline fun minus(res: Vec2, a: Vec2, bX: Float, bY: Float): Vec2 {
        res.x = a.x - bX
        res.y = a.y - bY
        return res
    }

    inline fun minus(res: Vec2, aX: Float, aY: Float, b: Vec2): Vec2 {
        res.x = aX - b.x
        res.y = aY - b.y
        return res
    }

    inline fun times(res: Vec2, a: Vec2, bX: Float, bY: Float): Vec2 {
        res.x = a.x * bX
        res.y = a.y * bY
        return res
    }

    inline fun div(res: Vec2, a: Vec2, bX: Float, bY: Float): Vec2 {
        res.x = a.x / bX
        res.y = a.y / bY
        return res
    }

    inline fun div(res: Vec2, aX: Float, aY: Float, b: Vec2): Vec2 {
        res.x = aX / b.x
        res.y = aY / b.y
        return res
    }

    inline fun rem(res: Vec2, a: Vec2, bX: Float, bY: Float): Vec2 {
        res.x = a.x % bX
        res.y = a.y % bY
        return res
    }

    inline fun rem(res: Vec2, aX: Float, aY: Float, b: Vec2): Vec2 {
        res.x = aX % b.x
        res.y = aY % b.y
        return res
    }
}


// -- Specific binary arithmetic operators --

infix operator fun Float.plus(b: Vec2) = plus(Vec2(), b, this, this)
fun Float.plus(b: Vec2, res: Vec2) = plus(res, b, this, this)
infix fun Float.plusAssign(b: Vec2) = plus(b, b, this, this)

infix operator fun Float.minus(b: Vec2) = minus(Vec2(), this, this, b)  // TODO it was wrong operand order, check others
fun Float.minus(b: Vec2, res: Vec2) = minus(res, this, this, b)
infix fun Float.minusAssign(b: Vec2) = minus(b, this, this, b)

infix operator fun Float.times(b: Vec2) = times(Vec2(), b, this, this)
fun Float.times(b: Vec2, res: Vec2) = times(res, b, this, this)
infix fun Float.timesAssign(b: Vec2) = times(b, b, this, this)

infix operator fun Float.div(b: Vec2) = div(Vec2(), this, this, b)
fun Float.div(b: Vec2, res: Vec2) = div(res, b, this, this)
infix fun Float.divAssign(b: Vec2) = div(b, this, this, b)

infix operator fun Float.rem(b: Vec2) = rem(Vec2(), this, this, b)
fun Float.rem(b: Vec2, res: Vec2) = rem(res, b, this, this)
infix fun Float.remAssign(b: Vec2) = rem(b, this, this, b)


// -- Generic binary arithmetic operators --

infix operator fun Number.plus(b: Vec2) = plus(Vec2(), b, f, f)
fun Number.plus(b: Vec2, res: Vec2) = plus(res, b, f, f)
infix fun Number.plusAssign(b: Vec2) = plus(b, b, f, f)

infix operator fun Number.minus(b: Vec2) = minus(Vec2(), f, f, b)
fun Number.minus(b: Vec2, res: Vec2) = minus(res, b, f, f)
infix fun Number.minusAssign(b: Vec2) = minus(b, f, f, b)

infix operator fun Number.times(b: Vec2) = times(Vec2(), b, f, f)
fun Number.times(b: Vec2, res: Vec2) = times(res, b, f, f)
infix fun Number.timesAssign(b: Vec2) = times(b, b, f, f)

infix operator fun Number.div(b: Vec2) = div(Vec2(), f, f, b)
fun Number.div(b: Vec2, res: Vec2) = div(res, b, f, f)
infix fun Number.divAssign(b: Vec2) = div(b, f, f, b)

infix operator fun Number.rem(b: Vec2) = rem(Vec2(), f, f, b)
fun Number.rem(b: Vec2, res: Vec2) = rem(res, b, f, f)
infix fun Number.remAssign(b: Vec2) = rem(b, f, f, b)