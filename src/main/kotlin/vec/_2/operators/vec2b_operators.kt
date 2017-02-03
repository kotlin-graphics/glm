package vec._2.operators

import main.and
import main.b
import main.i
import main.or
import main.shl
import main.shr
import vec._2.Vec2b
import vec._2.Vec2b.Companion.add
import vec._2.Vec2b.Companion.div
import vec._2.Vec2b.Companion.mul
import vec._2.Vec2b.Companion.rem
import vec._2.Vec2b.Companion.sub
import main.xor
import kotlin.experimental.inv

/**
 * Created by GBarbieri on 08.11.2016.
 */
interface vec2b_operators {

    fun add(res: Vec2b, a: Vec2b, bX: Byte, bY: Byte): Vec2b {
        res.x = (a.x + bX).b
        res.y = (a.y + bY).b
        return res
    }

    fun add(res: Vec2b, a: Vec2b, bX: Int, bY: Int): Vec2b {
        res.x = (a.x + bX).b
        res.y = (a.y + bY).b
        return res
    }

    fun sub(res: Vec2b, a: Vec2b, bX: Byte, bY: Byte): Vec2b {
        res.x = (a.x - bX).b
        res.y = (a.y - bY).b
        return res
    }

    fun sub(res: Vec2b, a: Vec2b, bX: Int, bY: Int): Vec2b {
        res.x = (a.x - bX).b
        res.y = (a.y - bY).b
        return res
    }

    fun sub(res: Vec2b, aX: Byte, aY: Byte, b: Vec2b): Vec2b {
        res.x = (aX - b.x).b
        res.y = (aY - b.y).b
        return res
    }

    fun sub(res: Vec2b, aX: Int, aY: Int, b: Vec2b): Vec2b {
        res.x = (aX - b.x).b
        res.y = (aY - b.y).b
        return res
    }

    fun mul(res: Vec2b, a: Vec2b, bX: Byte, bY: Byte): Vec2b {
        res.x = (a.x * bX).b
        res.y = (a.y * bY).b
        return res
    }

    fun mul(res: Vec2b, a: Vec2b, bX: Int, bY: Int): Vec2b {
        res.x = (a.x * bX).b
        res.y = (a.y * bY).b
        return res
    }

    fun div(res: Vec2b, a: Vec2b, bX: Byte, bY: Byte): Vec2b {
        res.x = (a.x / bX).b
        res.y = (a.y / bY).b
        return res
    }

    fun div(res: Vec2b, a: Vec2b, bX: Int, bY: Int): Vec2b {
        res.x = (a.x / bX).b
        res.y = (a.y / bY).b
        return res
    }

    fun div(res: Vec2b, aX: Byte, aY: Byte, b: Vec2b): Vec2b {
        res.x = (aX / b.x).b
        res.y = (aY / b.y).b
        return res
    }

    fun div(res: Vec2b, aX: Int, aY: Int, b: Vec2b): Vec2b {
        res.x = (aX / b.x).b
        res.y = (aY / b.y).b
        return res
    }

    fun rem(res: Vec2b, a: Vec2b, bX: Byte, bY: Byte): Vec2b {
        res.x = (a.x % bX).b
        res.y = (a.y % bY).b
        return res
    }

    fun rem(res: Vec2b, a: Vec2b, bX: Int, bY: Int): Vec2b {
        res.x = (a.x % bX).b
        res.y = (a.y % bY).b
        return res
    }

    fun rem(res: Vec2b, aX: Byte, aY: Byte, b: Vec2b): Vec2b {
        res.x = (aX % b.x).b
        res.y = (aY % b.y).b
        return res
    }

    fun rem(res: Vec2b, aX: Int, aY: Int, b: Vec2b): Vec2b {
        res.x = (aX % b.x).b
        res.y = (aY % b.y).b
        return res
    }

    fun and(res: Vec2b, a: Vec2b, bX: Byte, bY: Byte): Vec2b {
        res.x = a.x and bX
        res.y = a.y and bY
        return res
    }

    fun and(res: Vec2b, a: Vec2b, bX: Int, bY: Int): Vec2b {
        res.x = a.x and  bX
        res.y = a.y and bY
        return res
    }

    fun or(res: Vec2b, a: Vec2b, bX: Byte, bY: Byte): Vec2b {
        res.x = a.x or bX
        res.y = a.y or bY
        return res
    }

    fun or(res: Vec2b, a: Vec2b, bX: Int, bY: Int): Vec2b {
        res.x = a.x or bX
        res.y = a.y or bY
        return res
    }

    fun xor(res: Vec2b, a: Vec2b, bX: Byte, bY: Byte): Vec2b {
        res.x = a.x xor bX
        res.y = a.y xor bY
        return res
    }

    fun xor(res: Vec2b, a: Vec2b, bX: Int, bY: Int): Vec2b {
        res.x = a.x xor bX
        res.y = a.y xor bY
        return res
    }

    fun shl(res: Vec2b, a: Vec2b, bX: Byte, bY: Byte): Vec2b {
        res.x = a.x shl bX
        res.y = a.y shl bY
        return res
    }

    fun shl(res: Vec2b, a: Vec2b, bX: Int, bY: Int): Vec2b {
        res.x = a.x shl bX
        res.y = a.y shl bY
        return res
    }

    fun shr(res: Vec2b, a: Vec2b, bX: Byte, bY: Byte): Vec2b {
        res.x = a.x shr bX
        res.y = a.y shr bY
        return res
    }

    fun shr(res: Vec2b, a: Vec2b, bX: Int, bY: Int): Vec2b {
        res.x = a.x shr bX
        res.y = a.y shr bY
        return res
    }

    fun inv(res: Vec2b, a: Vec2b): Vec2b {
        res.x = a.x.inv()
        res.y = a.y.inv()
        return res
    }
}


// -- Specific binary arithmetic operators --

operator fun Byte.plus(b: Vec2b) = add(Vec2b(), b, this, this)
fun Byte.add(b: Vec2b, res: Vec2b = Vec2b()) = add(res, b, this, this)
infix fun Byte.add_(b: Vec2b) = add(b, b, this, this)

operator fun Byte.minus(b: Vec2b) = sub(Vec2b(), this, this, b)
fun Byte.sub(b: Vec2b, res: Vec2b = Vec2b()) = sub(res, b, this, this)
infix fun Byte.sub_(b: Vec2b) = sub(b, this, this, b)

operator fun Byte.times(b: Vec2b) = mul(Vec2b(), b, this, this)
fun Byte.mul(b: Vec2b, res: Vec2b = Vec2b()) = mul(res, b, this, this)
infix fun Byte.mul_(b: Vec2b) = mul(b, b, this, this)

operator fun Byte.div(b: Vec2b) = div(Vec2b(), this, this, b)
fun Byte.div(b: Vec2b, res: Vec2b) = div(res, b, this, this)
infix fun Byte.div_(b: Vec2b) = div(b, this, this, b)

operator fun Byte.rem(b: Vec2b) = rem(Vec2b(), this, this, b)
fun Byte.rem(b: Vec2b, res: Vec2b) = rem(res, b, this, this)
infix fun Byte.rem_(b: Vec2b) = rem(b, this, this, b)


operator fun Int.plus(b: Vec2b) = add(Vec2b(), b, this, this)
fun Int.add(b: Vec2b, res: Vec2b = Vec2b()) = add(res, b, this, this)
infix fun Int.add_(b: Vec2b) = add(b, b, this, this)

operator fun Int.minus(b: Vec2b) = sub(Vec2b(), this, this, b)
fun Int.sub(b: Vec2b, res: Vec2b = Vec2b()) = sub(res, b, this, this)
infix fun Int.sub_(b: Vec2b) = sub(b, this, this, b)

operator fun Int.times(b: Vec2b) = mul(Vec2b(), b, this, this)
fun Int.mul(b: Vec2b, res: Vec2b = Vec2b()) = mul(res, b, this, this)
infix fun Int.mul_(b: Vec2b) = mul(b, b, this, this)

operator fun Int.div(b: Vec2b) = div(Vec2b(), this, this, b)
fun Int.div(b: Vec2b, res: Vec2b) = div(res, b, this, this)
infix fun Int.div_(b: Vec2b) = div(b, this, this, b)

operator fun Int.rem(b: Vec2b) = rem(Vec2b(), this, this, b)
fun Int.rem(b: Vec2b, res: Vec2b) = rem(res, b, this, this)
infix fun Int.rem_(b: Vec2b) = rem(b, this, this, b)


// -- Specific binary arithmetic operators --

operator fun Number.plus(b: Vec2b) = add(Vec2b(), b, this.i, this.i)
fun Number.add(b: Vec2b, res: Vec2b = Vec2b()) = add(res, b, this.i, this.i)
infix fun Number.add_(b: Vec2b) = add(b, b, this.i, this.i)

operator fun Number.minus(b: Vec2b) = sub(Vec2b(), this.i, this.i, b)
fun Number.sub(b: Vec2b, res: Vec2b = Vec2b()) = sub(res, b, this.i, this.i)
infix fun Number.sub_(b: Vec2b) = sub(b, this.i, this.i, b)

operator fun Number.times(b: Vec2b) = mul(Vec2b(), b, this.i, this.i)
fun Number.mul(b: Vec2b, res: Vec2b = Vec2b()) = mul(res, b, this.i, this.i)
infix fun Number.mul_(b: Vec2b) = mul(b, b, this.i, this.i)

operator fun Number.div(b: Vec2b) = div(Vec2b(), this.i, this.i, b)
fun Number.div(b: Vec2b, res: Vec2b) = div(res, b, this.i, this.i)
infix fun Number.div_(b: Vec2b) = div(b, this.i, this.i, b)

operator fun Number.rem(b: Vec2b) = rem(Vec2b(), this.i, this.i, b)
fun Number.rem(b: Vec2b, res: Vec2b) = rem(res, b, this.i, this.i)
infix fun Number.rem_(b: Vec2b) = rem(b, this.i, this.i, b)