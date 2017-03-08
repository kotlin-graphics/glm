package vec._2.operators

import glm.and
import glm.or
import glm.s
import glm.shl
import glm.shr
import vec._2.Vec2s
import vec._2.Vec2s.Companion.add
import vec._2.Vec2s.Companion.div
import vec._2.Vec2s.Companion.mul
import vec._2.Vec2s.Companion.rem
import vec._2.Vec2s.Companion.sub
import glm.xor
import kotlin.experimental.inv

/**
 * Created by GBarbieri on 08.11.2016.
 */
interface vec2s_operators {

    fun add(res: Vec2s, a: Vec2s, bX: Short, bY: Short): Vec2s {
        res.x = (a.x + bX).s
        res.y = (a.y + bY).s
        return res
    }

    fun add(res: Vec2s, a: Vec2s, bX: Int, bY: Int): Vec2s {
        res.x = (a.x + bX).s
        res.y = (a.y + bY).s
        return res
    }

    fun sub(res: Vec2s, a: Vec2s, bX: Short, bY: Short): Vec2s {
        res.x = (a.x - bX).s
        res.y = (a.y - bY).s
        return res
    }

    fun sub(res: Vec2s, a: Vec2s, bX: Int, bY: Int): Vec2s {
        res.x = (a.x - bX).s
        res.y = (a.y - bY).s
        return res
    }

    fun sub(res: Vec2s, aX: Short, aY: Short, b: Vec2s): Vec2s {
        res.x = (aX - b.x).s
        res.y = (aY - b.y).s
        return res
    }

    fun sub(res: Vec2s, aX: Int, aY: Int, b: Vec2s): Vec2s {
        res.x = (aX - b.x).s
        res.y = (aY - b.y).s
        return res
    }

    fun mul(res: Vec2s, a: Vec2s, bX: Short, bY: Short): Vec2s {
        res.x = (a.x * bX).s
        res.y = (a.y * bY).s
        return res
    }

    fun mul(res: Vec2s, a: Vec2s, bX: Int, bY: Int): Vec2s {
        res.x = (a.x * bX).s
        res.y = (a.y * bY).s
        return res
    }

    fun div(res: Vec2s, a: Vec2s, bX: Short, bY: Short): Vec2s {
        res.x = (a.x / bX).s
        res.y = (a.y / bY).s
        return res
    }

    fun div(res: Vec2s, a: Vec2s, bX: Int, bY: Int): Vec2s {
        res.x = (a.x / bX).s
        res.y = (a.y / bY).s
        return res
    }

    fun div(res: Vec2s, aX: Short, aY: Short, b: Vec2s): Vec2s {
        res.x = (aX / b.x).s
        res.y = (aY / b.y).s
        return res
    }

    fun div(res: Vec2s, aX: Int, aY: Int, b: Vec2s): Vec2s {
        res.x = (aX / b.x).s
        res.y = (aY / b.y).s
        return res
    }

    fun rem(res: Vec2s, a: Vec2s, bX: Short, bY: Short): Vec2s {
        res.x = (a.x % bX).s
        res.y = (a.y % bY).s
        return res
    }

    fun rem(res: Vec2s, a: Vec2s, bX: Int, bY: Int): Vec2s {
        res.x = (a.x % bX).s
        res.y = (a.y % bY).s
        return res
    }

    fun rem(res: Vec2s, aX: Short, aY: Short, b: Vec2s): Vec2s {
        res.x = (aX % b.x).s
        res.y = (aY % b.y).s
        return res
    }

    fun rem(res: Vec2s, aX: Int, aY: Int, b: Vec2s): Vec2s {
        res.x = (aX % b.x).s
        res.y = (aY % b.y).s
        return res
    }

    fun and(res: Vec2s, a: Vec2s, bX: Short, bY: Short): Vec2s {
        res.x = a.x and bX
        res.y = a.y and bY
        return res
    }

    fun and(res: Vec2s, a: Vec2s, bX: Int, bY: Int): Vec2s {
        res.x = a.x and  bX
        res.y = a.y and bY
        return res
    }

    fun or(res: Vec2s, a: Vec2s, bX: Short, bY: Short): Vec2s {
        res.x = a.x or bX
        res.y = a.y or bY
        return res
    }

    fun or(res: Vec2s, a: Vec2s, bX: Int, bY: Int): Vec2s {
        res.x = a.x or bX
        res.y = a.y or bY
        return res
    }

    fun xor(res: Vec2s, a: Vec2s, bX: Short, bY: Short): Vec2s {
        res.x = a.x xor bX
        res.y = a.y xor bY
        return res
    }

    fun xor(res: Vec2s, a: Vec2s, bX: Int, bY: Int): Vec2s {
        res.x = a.x xor bX
        res.y = a.y xor bY
        return res
    }

    fun shl(res: Vec2s, a: Vec2s, bX: Short, bY: Short): Vec2s {
        res.x = a.x shl bX
        res.y = a.y shl bY
        return res
    }

    fun shl(res: Vec2s, a: Vec2s, bX: Int, bY: Int): Vec2s {
        res.x = a.x shl bX
        res.y = a.y shl bY
        return res
    }

    fun shr(res: Vec2s, a: Vec2s, bX: Short, bY: Short): Vec2s {
        res.x = a.x shr bX
        res.y = a.y shr bY
        return res
    }

    fun shr(res: Vec2s, a: Vec2s, bX: Int, bY: Int): Vec2s {
        res.x = a.x shr bX
        res.y = a.y shr bY
        return res
    }

    fun inv(res: Vec2s, a: Vec2s): Vec2s {
        res.x = a.x.inv()
        res.y = a.y.inv()
        return res
    }
}


// -- Specific binary arithmetic operators --

operator fun Short.plus(b: Vec2s) = add(Vec2s(), b, this, this)
fun Short.add(b: Vec2s, res: Vec2s = Vec2s()) = add(res, b, this, this)
infix fun Short.add_(b: Vec2s) = add(b, b, this, this)

operator fun Short.minus(b: Vec2s) = sub(Vec2s(), this, this, b)
fun Short.sub(b: Vec2s, res: Vec2s = Vec2s()) = sub(res, b, this, this)
infix fun Short.sub_(b: Vec2s) = sub(b, this, this, b)

operator fun Short.times(b: Vec2s) = mul(Vec2s(), b, this, this)
fun Short.mul(b: Vec2s, res: Vec2s = Vec2s()) = mul(res, b, this, this)
infix fun Short.mul_(b: Vec2s) = mul(b, b, this, this)

operator fun Short.div(b: Vec2s) = div(Vec2s(), this, this, b)
fun Short.div(b: Vec2s, res: Vec2s) = div(res, b, this, this)
infix fun Short.div_(b: Vec2s) = div(b, this, this, b)

operator fun Short.rem(b: Vec2s) = rem(Vec2s(), this, this, b)
fun Short.rem(b: Vec2s, res: Vec2s) = rem(res, b, this, this)
infix fun Short.rem_(b: Vec2s) = rem(b, this, this, b)


operator fun Int.plus(b: Vec2s) = add(Vec2s(), b, this, this)
fun Int.add(b: Vec2s, res: Vec2s = Vec2s()) = add(res, b, this, this)
infix fun Int.add_(b: Vec2s) = add(b, b, this, this)

operator fun Int.minus(b: Vec2s) = sub(Vec2s(), this, this, b)
fun Int.sub(b: Vec2s, res: Vec2s = Vec2s()) = sub(res, b, this, this)
infix fun Int.sub_(b: Vec2s) = sub(b, this, this, b)

operator fun Int.times(b: Vec2s) = mul(Vec2s(), b, this, this)
fun Int.mul(b: Vec2s, res: Vec2s = Vec2s()) = mul(res, b, this, this)
infix fun Int.mul_(b: Vec2s) = mul(b, b, this, this)

operator fun Int.div(b: Vec2s) = div(Vec2s(), this, this, b)
fun Int.div(b: Vec2s, res: Vec2s) = div(res, b, this, this)
infix fun Int.div_(b: Vec2s) = div(b, this, this, b)

operator fun Int.rem(b: Vec2s) = rem(Vec2s(), this, this, b)
fun Int.rem(b: Vec2s, res: Vec2s) = rem(res, b, this, this)
infix fun Int.rem_(b: Vec2s) = rem(b, this, this, b)


// -- Specific binary arithmetic operators --

operator fun Number.plus(b: Vec2s) = add(Vec2s(), b, this.s, this.s)
fun Number.add(b: Vec2s, res: Vec2s = Vec2s()) = add(res, b, this.s, this.s)
infix fun Number.add_(b: Vec2s) = add(b, b, this.s, this.s)

operator fun Number.minus(b: Vec2s) = sub(Vec2s(), this.s, this.s, b)
fun Number.sub(b: Vec2s, res: Vec2s = Vec2s()) = sub(res, b, this.s, this.s)
infix fun Number.sub_(b: Vec2s) = sub(b, this.s, this.s, b)

operator fun Number.times(b: Vec2s) = mul(Vec2s(), b, this.s, this.s)
fun Number.mul(b: Vec2s, res: Vec2s = Vec2s()) = mul(res, b, this.s, this.s)
infix fun Number.mul_(b: Vec2s) = mul(b, b, this.s, this.s)

operator fun Number.div(b: Vec2s) = div(Vec2s(), this.s, this.s, b)
fun Number.div(b: Vec2s, res: Vec2s) = div(res, b, this.s, this.s)
infix fun Number.div_(b: Vec2s) = div(b, this.s, this.s, b)

operator fun Number.rem(b: Vec2s) = rem(Vec2s(), this.s, this.s, b)
fun Number.rem(b: Vec2s, res: Vec2s) = rem(res, b, this.s, this.s)
infix fun Number.rem_(b: Vec2s) = rem(b, this.s, this.s, b)