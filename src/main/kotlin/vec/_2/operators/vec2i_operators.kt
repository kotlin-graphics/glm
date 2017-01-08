package vec._2.operators

import i
import vec._2.Vec2i
import vec._2.Vec2i.Companion.add
import vec._2.Vec2i.Companion.div
import vec._2.Vec2i.Companion.mul
import vec._2.Vec2i.Companion.rem
import vec._2.Vec2i.Companion.sub

/**
 * Created by GBarbieri on 08.11.2016.
 */
interface vec2i_operators {

    fun add(res: Vec2i, a: Vec2i, bX: Int, bY: Int): Vec2i {
        res.x = a.x + bX
        res.y = a.y + bY
        return res
    }

    fun sub(res: Vec2i, a: Vec2i, bX: Int, bY: Int): Vec2i {
        res.x = a.x - bX
        res.y = a.y - bY
        return res
    }

    fun sub(res: Vec2i, aX: Int, aY: Int, b: Vec2i): Vec2i {
        res.x = aX - b.x
        res.y = aY - b.y
        return res
    }

    fun mul(res: Vec2i, a: Vec2i, bX: Int, bY: Int): Vec2i {
        res.x = a.x * bX
        res.y = a.y * bY
        return res
    }

    fun div(res: Vec2i, a: Vec2i, bX: Int, bY: Int): Vec2i {
        res.x = a.x / bX
        res.y = a.y / bY
        return res
    }

    fun div(res: Vec2i, aX: Int, aY: Int, b: Vec2i): Vec2i {
        res.x = aX / b.x
        res.y = aY / b.y
        return res
    }

    fun rem(res: Vec2i, a: Vec2i, bX: Int, bY: Int): Vec2i {
        res.x = a.x % bX
        res.y = a.y % bY
        return res
    }

    fun rem(res: Vec2i, aX: Int, aY: Int, b: Vec2i): Vec2i {
        res.x = aX % b.x
        res.y = aY % b.y
        return res
    }

    fun and(res: Vec2i, a: Vec2i, bX: Int, bY: Int): Vec2i {
        res.x = a.x and bX
        res.y = a.y and bY
        return res
    }

    fun or(res: Vec2i, a: Vec2i, bX: Int, bY: Int): Vec2i {
        res.x = a.x or bX
        res.y = a.y or bY
        return res
    }

    fun xor(res: Vec2i, a: Vec2i, bX: Int, bY: Int): Vec2i {
        res.x = a.x xor bX
        res.y = a.y xor bY
        return res
    }

    fun shl(res: Vec2i, a: Vec2i, bX: Int, bY: Int): Vec2i {
        res.x = a.x shl bX
        res.y = a.y shl bY
        return res
    }

    fun shr(res: Vec2i, a: Vec2i, bX: Int, bY: Int): Vec2i {
        res.x = a.x shr bX
        res.y = a.y shr bY
        return res
    }

    fun inv(res: Vec2i, a: Vec2i): Vec2i {
        res.x = a.x.inv()
        res.y = a.y.inv()
        return res
    }
}


// -- Specific binary arithmetic operators --

operator fun Int.plus(b: Vec2i) = add(Vec2i(), b, this, this)
fun Int.add(b: Vec2i, res: Vec2i = Vec2i()) = add(res, b, this, this)
infix fun Int.add_(b: Vec2i) = add(b, b, this, this)

operator fun Int.minus(b: Vec2i) = sub(Vec2i(), this, this, b)
fun Int.sub(b: Vec2i, res: Vec2i = Vec2i()) = sub(res, b, this, this)
infix fun Int.sub_(b: Vec2i) = sub(b, this, this, b)

operator fun Int.times(b: Vec2i) = mul(Vec2i(), b, this, this)
fun Int.mul(b: Vec2i, res: Vec2i = Vec2i()) = mul(res, b, this, this)
infix fun Int.mul_(b: Vec2i) = mul(b, b, this, this)

operator fun Int.div(b: Vec2i) = div(Vec2i(), this, this, b)
fun Int.div(b: Vec2i, res: Vec2i) = div(res, b, this, this)
infix fun Int.div_(b: Vec2i) = div(b, this, this, b)

operator fun Int.rem(b: Vec2i) = rem(Vec2i(), this, this, b)
fun Int.rem(b: Vec2i, res: Vec2i) = rem(res, b, this, this)
infix fun Int.rem_(b: Vec2i) = rem(b, this, this, b)


// -- Generic binary arithmetic operators --

operator fun Number.plus(b: Vec2i) = add(Vec2i(), b, this.i, this.i)
fun Number.add(b: Vec2i, res: Vec2i = Vec2i()) = add(res, b, this.i, this.i)
infix fun Number.add_(b: Vec2i) = add(b, b, this.i, this.i)

operator fun Number.minus(b: Vec2i) = sub(Vec2i(), this.i, this.i, b)
fun Number.sub(b: Vec2i, res: Vec2i = Vec2i()) = sub(res, b, this.i, this.i)
infix fun Number.sub_(b: Vec2i) = sub(b, this.i, this.i, b)

operator fun Number.times(b: Vec2i) = mul(Vec2i(), b, this.i, this.i)
fun Number.mul(b: Vec2i, res: Vec2i = Vec2i()) = mul(res, b, this.i, this.i)
infix fun Number.mul_(b: Vec2i) = mul(b, b, this.i, this.i)

operator fun Number.div(b: Vec2i) = div(Vec2i(), this.i, this.i, b)
fun Number.div(b: Vec2i, res: Vec2i) = div(res, b, this.i, this.i)
infix fun Number.div_(b: Vec2i) = div(b, this.i, this.i, b)

operator fun Number.rem(b: Vec2i) = rem(Vec2i(), this.i, this.i, b)
fun Number.rem(b: Vec2i, res: Vec2i) = rem(res, b, this.i, this.i)
infix fun Number.rem_(b: Vec2i) = rem(b, this.i, this.i, b)