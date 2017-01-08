package vec._2.operators

import d
import vec._2.Vec2d
import vec._2.Vec2d.Companion.add
import vec._2.Vec2d.Companion.div
import vec._2.Vec2d.Companion.mul
import vec._2.Vec2d.Companion.rem
import vec._2.Vec2d.Companion.sub

/**
 * Created by GBarbieri on 08.11.2016.
 */
interface vec2d_operators {

    fun add(res: Vec2d, a: Vec2d, bX: Double, bY: Double): Vec2d {
        res.x = a.x + bX
        res.y = a.y + bY
        return res
    }

    fun sub(res: Vec2d, a: Vec2d, bX: Double, bY: Double): Vec2d {
        res.x = a.x - bX
        res.y = a.y - bY
        return res
    }

    fun sub(res: Vec2d, aX: Double, aY: Double, b: Vec2d): Vec2d {
        res.x = aX - b.x
        res.y = aY - b.y
        return res
    }

    fun mul(res: Vec2d, a: Vec2d, bX: Double, bY: Double): Vec2d {
        res.x = a.x * bX
        res.y = a.y * bY
        return res
    }

    fun div(res: Vec2d, a: Vec2d, bX: Double, bY: Double): Vec2d {
        res.x = a.x / bX
        res.y = a.y / bY
        return res
    }

    fun div(res: Vec2d, aX: Double, aY: Double, b: Vec2d): Vec2d {
        res.x = aX / b.x
        res.y = aY / b.y
        return res
    }

    fun rem(res: Vec2d, a: Vec2d, bX: Double, bY: Double): Vec2d {
        res.x = a.x % bX
        res.y = a.y % bY
        return res
    }

    fun rem(res: Vec2d, aX: Double, aY: Double, b: Vec2d): Vec2d {
        res.x = aX % b.x
        res.y = aY % b.y
        return res
    }
}


// -- Specific binary arithmetic operators --

operator fun Double.plus(b: Vec2d) = add(Vec2d(), b, this, this)
fun Double.add(b: Vec2d, res: Vec2d = Vec2d()) = add(res, b, this, this)
infix fun Double.add_(b: Vec2d) = add(b, b, this, this)

operator fun Double.minus(b: Vec2d) = sub(Vec2d(), this, this, b)
fun Double.sub(b: Vec2d, res: Vec2d = Vec2d()) = sub(res, b, this, this)
infix fun Double.sub_(b: Vec2d) = sub(b, this, this, b)

operator fun Double.times(b: Vec2d) = mul(Vec2d(), b, this, this)
fun Double.mul(b: Vec2d, res: Vec2d = Vec2d()) = mul(res, b, this, this)
infix fun Double.mul_(b: Vec2d) = mul(b, b, this, this)

operator fun Double.div(b: Vec2d) = div(Vec2d(), this, this, b)
fun Double.div(b: Vec2d, res: Vec2d = Vec2d()) = div(res, b, this, this)
infix fun Double.div_(b: Vec2d) = div(b, this, this, b)

operator fun Double.rem(b: Vec2d) = rem(Vec2d(), this, this, b)
fun Double.rem(b: Vec2d, res: Vec2d = Vec2d()) = rem(res, b, this, this)
infix fun Double.rem_(b: Vec2d) = rem(b, this, this, b)


// -- Generic binary arithmetic operators --

operator fun Number.plus(b: Vec2d) = add(Vec2d(), b, this.d, this.d)
fun Number.add(b: Vec2d, res: Vec2d = Vec2d()) = add(res, b, this.d, this.d)
infix fun Number.add_(b: Vec2d) = add(b, b, this.d, this.d)

operator fun Number.minus(b: Vec2d) = sub(Vec2d(), this.d, this.d, b)
fun Number.sub(b: Vec2d, res: Vec2d = Vec2d()) = sub(res, b, this.d, this.d)
infix fun Number.sub_(b: Vec2d) = sub(b, this.d, this.d, b)

operator fun Number.times(b: Vec2d) = mul(Vec2d(), b, this.d, this.d)
fun Number.mul(b: Vec2d, res: Vec2d = Vec2d()) = mul(res, b, this.d, this.d)
infix fun Number.mul_(b: Vec2d) = mul(b, b, this.d, this.d)

operator fun Number.div(b: Vec2d) = div(Vec2d(), this.d, this.d, b)
fun Number.div(b: Vec2d, res: Vec2d = Vec2d()) = div(res, b, this.d, this.d)
infix fun Number.div_(b: Vec2d) = div(b, this.d, this.d, b)

operator fun Number.rem(b: Vec2d) = rem(Vec2d(), this.d, this.d, b)
fun Number.rem(b: Vec2d, res: Vec2d = Vec2d()) = rem(res, b, this.d, this.d)
infix fun Number.rem_(b: Vec2d) = rem(b, this.d, this.d, b)