package vec._2.operators

import main.f
import vec._2.Vec2
import vec._2.Vec2.Companion.add
import vec._2.Vec2.Companion.div
import vec._2.Vec2.Companion.mul
import vec._2.Vec2.Companion.rem
import vec._2.Vec2.Companion.sub

/**
 * Created by GBarbieri on 13.12.2016.
 */

interface vec2_operators {

    fun add(res: Vec2, a: Vec2, bX: Float, bY: Float): Vec2 {
        res.x = a.x + bX
        res.y = a.y + bY
        return res
    }

    fun sub(res: Vec2, a: Vec2, bX: Float, bY: Float): Vec2 {
        res.x = a.x - bX
        res.y = a.y - bY
        return res
    }

    fun sub(res: Vec2, aX: Float, aY: Float, b: Vec2): Vec2 {
        res.x = aX - b.x
        res.y = aY - b.y
        return res
    }

    fun mul(res: Vec2, a: Vec2, bX: Float, bY: Float): Vec2 {
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

operator fun Float.plus(b: Vec2) = add(Vec2(), b, this, this)
fun Float.add(b: Vec2, res: Vec2 = Vec2()) = add(res, b, this, this)
infix fun Float.add_(b: Vec2) = add(b, b, this, this)

operator fun Float.minus(b: Vec2) = sub(Vec2(), this, this, b)
fun Float.sub(b: Vec2, res: Vec2 = Vec2()) = sub(res, b, this, this)
infix fun Float.sub_(b: Vec2) = sub(b, this, this, b)

operator fun Float.times(b: Vec2) = mul(Vec2(), b, this, this)
fun Float.mul(b: Vec2, res: Vec2 = Vec2()) = mul(res, b, this, this)
infix fun Float.mul_(b: Vec2) = mul(b, b, this, this)

operator fun Float.div(b: Vec2) = div(Vec2(), this, this, b)
fun Float.div(b: Vec2, res: Vec2 = Vec2()) = div(res, b, this, this)
infix fun Float.div_(b: Vec2) = div(b, this, this, b)

operator fun Float.rem(b: Vec2) = rem(Vec2(), this, this, b)
fun Float.rem(b: Vec2, res: Vec2 = Vec2()) = rem(res, b, this, this)
infix fun Float.rem_(b: Vec2) = rem(b, this, this, b)


// -- Generic binary arithmetic operators --

operator fun Number.plus(b: Vec2) = add(Vec2(), b, this.f, this.f)
fun Number.add(b: Vec2, res: Vec2 = Vec2()) = add(res, b, this.f, this.f)
infix fun Number.add_(b: Vec2) = add(b, b, this.f, this.f)

operator fun Number.minus(b: Vec2) = sub(Vec2(), this.f, this.f, b)
fun Number.sub(b: Vec2, res: Vec2 = Vec2()) = sub(res, b, this.f, this.f)
infix fun Number.sub_(b: Vec2) = sub(b, this.f, this.f, b)

operator fun Number.times(b: Vec2) = mul(Vec2(), b, this.f, this.f)
fun Number.mul(b: Vec2, res: Vec2 = Vec2()) = mul(res, b, this.f, this.f)
infix fun Number.mul_(b: Vec2) = mul(b, b, this.f, this.f)

operator fun Number.div(b: Vec2) = div(Vec2(), this.f, this.f, b)
fun Number.div(b: Vec2, res: Vec2 = Vec2()) = div(res, b, this.f, this.f)
infix fun Number.div_(b: Vec2) = div(b, this.f, this.f, b)

operator fun Number.rem(b: Vec2) = rem(Vec2(), this.f, this.f, b)
fun Number.rem(b: Vec2, res: Vec2 = Vec2()) = rem(res, b, this.f, this.f)
infix fun Number.rem_(b: Vec2) = rem(b, this.f, this.f, b)