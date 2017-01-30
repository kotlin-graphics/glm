package vec._2.operators

import main.L
import main.i
import vec._2.Vec2l
import vec._2.Vec2l.Companion.add
import vec._2.Vec2l.Companion.div
import vec._2.Vec2l.Companion.mul
import vec._2.Vec2l.Companion.rem
import vec._2.Vec2l.Companion.sub


/**
 * Created by GBarbieri on 08.11.2016.
 */
interface vec2l_operators {

    fun add(res: Vec2l, a: Vec2l, bX: Long, bY: Long): Vec2l {
        res.x = a.x + bX
        res.y = a.y + bY
        return res
    }

    fun sub(res: Vec2l, a: Vec2l, bX: Long, bY: Long): Vec2l {
        res.x = a.x - bX
        res.y = a.y - bY
        return res
    }

    fun sub(res: Vec2l, aX: Long, aY: Long, b: Vec2l): Vec2l {
        res.x = aX - b.x
        res.y = aY - b.y
        return res
    }

    fun mul(res: Vec2l, a: Vec2l, bX: Long, bY: Long): Vec2l {
        res.x = a.x * bX
        res.y = a.y * bY
        return res
    }

    fun div(res: Vec2l, a: Vec2l, bX: Long, bY: Long): Vec2l {
        res.x = a.x / bX
        res.y = a.y / bY
        return res
    }

    fun div(res: Vec2l, aX: Long, aY: Long, b: Vec2l): Vec2l {
        res.x = aX / b.x
        res.y = aY / b.y
        return res
    }

    fun rem(res: Vec2l, a: Vec2l, bX: Long, bY: Long): Vec2l {
        res.x = a.x % bX
        res.y = a.y % bY
        return res
    }

    fun rem(res: Vec2l, aX: Long, aY: Long, b: Vec2l): Vec2l {
        res.x = aX % b.x
        res.y = aY % b.y
        return res
    }

    fun and(res: Vec2l, a: Vec2l, bX: Long, bY: Long): Vec2l {
        res.x = a.x and bX
        res.y = a.y and bY
        return res
    }

    fun or(res: Vec2l, a: Vec2l, bX: Long, bY: Long): Vec2l {
        res.x = a.x or bX
        res.y = a.y or bY
        return res
    }

    fun xor(res: Vec2l, a: Vec2l, bX: Long, bY: Long): Vec2l {
        res.x = a.x xor bX
        res.y = a.y xor bY
        return res
    }

    fun shl(res: Vec2l, a: Vec2l, bX: Long, bY: Long): Vec2l {
        res.x = a.x shl bX.i
        res.y = a.y shl bY.i
        return res
    }

    fun shl(res: Vec2l, a: Vec2l, bX: Int, bY: Int): Vec2l {
        res.x = a.x shl bX
        res.y = a.y shl bY
        return res
    }

    fun shr(res: Vec2l, a: Vec2l, bX: Long, bY: Long): Vec2l {
        res.x = a.x shr bX.i
        res.y = a.y shr bY.i
        return res
    }

    fun shr(res: Vec2l, a: Vec2l, bX: Int, bY: Int): Vec2l {
        res.x = a.x shr bX
        res.y = a.y shr bY
        return res
    }

    fun inv(res: Vec2l, a: Vec2l): Vec2l {
        res.x = a.x.inv()
        res.y = a.y.inv()
        return res
    }
}


// -- Specific binary arithmetic operators --

operator fun Long.plus(b: Vec2l) = add(Vec2l(), b, this, this)
fun Long.add(b: Vec2l, res: Vec2l = Vec2l()) = add(res, b, this, this)
infix fun Long.add_(b: Vec2l) = add(b, b, this, this)

operator fun Long.minus(b: Vec2l) = sub(Vec2l(), this, this, b)
fun Long.sub(b: Vec2l, res: Vec2l = Vec2l()) = sub(res, b, this, this)
infix fun Long.sub_(b: Vec2l) = sub(b, this, this, b)

operator fun Long.times(b: Vec2l) = mul(Vec2l(), b, this, this)
fun Long.mul(b: Vec2l, res: Vec2l = Vec2l()) = mul(res, b, this, this)
infix fun Long.mul_(b: Vec2l) = mul(b, b, this, this)

operator fun Long.div(b: Vec2l) = div(Vec2l(), this, this, b)
fun Long.div(b: Vec2l, res: Vec2l) = div(res, b, this, this)
infix fun Long.div_(b: Vec2l) = div(b, this, this, b)

operator fun Long.rem(b: Vec2l) = rem(Vec2l(), this, this, b)
fun Long.rem(b: Vec2l, res: Vec2l) = rem(res, b, this, this)
infix fun Long.rem_(b: Vec2l) = rem(b, this, this, b)


// -- Generic binary arithmetic operators --

operator fun Number.plus(b: Vec2l) = add(Vec2l(), b, this.L, this.L)
fun Number.add(b: Vec2l, res: Vec2l = Vec2l()) = add(res, b, this.L, this.L)
infix fun Number.add_(b: Vec2l) = add(b, b, this.L, this.L)

operator fun Number.minus(b: Vec2l) = sub(Vec2l(), this.L, this.L, b)
fun Number.sub(b: Vec2l, res: Vec2l = Vec2l()) = sub(res, b, this.L, this.L)
infix fun Number.sub_(b: Vec2l) = sub(b, this.L, this.L, b)

operator fun Number.times(b: Vec2l) = mul(Vec2l(), b, this.L, this.L)
fun Number.mul(b: Vec2l, res: Vec2l = Vec2l()) = mul(res, b, this.L, this.L)
infix fun Number.mul_(b: Vec2l) = mul(b, b, this.L, this.L)

operator fun Number.div(b: Vec2l) = div(Vec2l(), this.L, this.L, b)
fun Number.div(b: Vec2l, res: Vec2l) = div(res, b, this.L, this.L)
infix fun Number.div_(b: Vec2l) = div(b, this.L, this.L, b)

operator fun Number.rem(b: Vec2l) = rem(Vec2l(), this.L, this.L, b)
fun Number.rem(b: Vec2l, res: Vec2l) = rem(res, b, this.L, this.L)
infix fun Number.rem_(b: Vec2l) = rem(b, this.L, this.L, b)