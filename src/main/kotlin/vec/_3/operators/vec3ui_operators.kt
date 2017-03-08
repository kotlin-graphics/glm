package vec._3.operators

import glm.*
import unsigned.*
import vec._3.Vec3ui
import vec._3.Vec3ui.Companion.add
import vec._3.Vec3ui.Companion.div
import vec._3.Vec3ui.Companion.mul
import vec._3.Vec3ui.Companion.rem
import vec._3.Vec3ui.Companion.sub


/**
 * Created by GBarbieri on 08.11.2016.
 */

interface vec3ui_operators {

    fun add(res: Vec3ui, a: Vec3ui, bX: Uint, bY: Uint, bZ: Uint): Vec3ui {
        res.x.v = a.x.v + bX.v
        res.y.v = a.y.v + bY.v
        res.z.v = a.z.v + bZ.v
        return res
    }

    fun add(res: Vec3ui, a: Vec3ui, bX: Int, bY: Int, bZ: Int): Vec3ui {
        res.x.v = a.x.v + bX
        res.y.v = a.y.v + bY
        res.z.v = a.z.v + bZ
        return res
    }

    fun sub(res: Vec3ui, a: Vec3ui, bX: Uint, bY: Uint, bZ: Uint): Vec3ui {
        res.x.v = a.x.v - bX.v
        res.y.v = a.y.v - bY.v
        res.z.v = a.z.v - bZ.v
        return res
    }

    fun sub(res: Vec3ui, a: Vec3ui, bX: Int, bY: Int, bZ: Int): Vec3ui {
        res.x.v = a.x.v - bX
        res.y.v = a.y.v - bY
        res.z.v = a.z.v - bZ
        return res
    }

    fun sub(res: Vec3ui, aX: Uint, aY: Uint, aZ: Uint, b: Vec3ui): Vec3ui {
        res.x.v = aX.v - b.x.v
        res.y.v = aY.v - b.y.v
        res.z.v = aZ.v - b.z.v
        return res
    }

    fun sub(res: Vec3ui, aX: Int, aY: Int, aZ: Int, b: Vec3ui): Vec3ui {
        res.x.v = aX - b.x.v
        res.y.v = aY - b.y.v
        res.z.v = aZ - b.z.v
        return res
    }

    fun mul(res: Vec3ui, a: Vec3ui, bX: Uint, bY: Uint, bZ: Uint): Vec3ui {
        res.x.v = a.x.v * bX.v
        res.y.v = a.y.v * bY.v
        res.z.v = a.z.v * bZ.v
        return res
    }

    fun mul(res: Vec3ui, a: Vec3ui, bX: Int, bY: Int, bZ: Int): Vec3ui {
        res.x.v = a.x.v * bX
        res.y.v = a.y.v * bY
        res.z.v = a.z.v * bZ
        return res
    }

    fun div(res: Vec3ui, a: Vec3ui, bX: Uint, bY: Uint, bZ: Uint): Vec3ui {
        res.x.v = a.x.v udiv bX.v
        res.y.v = a.y.v udiv bY.v
        res.z.v = a.z.v udiv bZ.v
        return res
    }

    fun div(res: Vec3ui, a: Vec3ui, bX: Int, bY: Int, bZ: Int): Vec3ui {
        res.x.v = a.x.v udiv bX
        res.y.v = a.y.v udiv bY
        res.z.v = a.z.v udiv bZ
        return res
    }

    fun div(res: Vec3ui, aX: Uint, aY: Uint, aZ: Uint, b: Vec3ui): Vec3ui {
        res.x.v = aX.v udiv b.x.v
        res.y.v = aY.v udiv b.y.v
        res.z.v = aZ.v udiv b.z.v
        return res
    }

    fun div(res: Vec3ui, aX: Int, aY: Int, aZ: Int, b: Vec3ui): Vec3ui {
        res.x.v = aX udiv b.x.v
        res.y.v = aY udiv b.y.v
        res.z.v = aZ udiv b.z.v
        return res
    }

    fun rem(res: Vec3ui, a: Vec3ui, bX: Uint, bY: Uint, bZ: Uint): Vec3ui {
        res.x.v = a.x.v urem bX.v
        res.y.v = a.y.v urem bY.v
        res.z.v = a.z.v urem bZ.v
        return res
    }

    fun rem(res: Vec3ui, a: Vec3ui, bX: Int, bY: Int, bZ: Int): Vec3ui {
        res.x.v = a.x.v urem bX
        res.y.v = a.y.v urem bY
        res.z.v = a.z.v urem bZ
        return res
    }

    fun rem(res: Vec3ui, aX: Uint, aY: Uint, aZ: Uint, b: Vec3ui): Vec3ui {
        res.x.v = aX.v urem b.x.v
        res.y.v = aY.v urem b.y.v
        res.z.v = aZ.v urem b.z.v
        return res
    }

    fun rem(res: Vec3ui, aX: Int, aY: Int, aZ: Int, b: Vec3ui): Vec3ui {
        res.x.v = aX urem b.x.v
        res.y.v = aY urem b.y.v
        res.z.v = aZ urem b.z.v
        return res
    }

    fun and(res: Vec3ui, a: Vec3ui, bX: Uint, bY: Uint, bZ: Uint): Vec3ui {
        res.x.v = a.x.v and bX.v
        res.y.v = a.y.v and bY.v
        res.z.v = a.z.v and bZ.v
        return res
    }

    fun and(res: Vec3ui, a: Vec3ui, bX: Int, bY: Int, bZ: Int): Vec3ui {
        res.x.v = a.x.v and bX
        res.y.v = a.y.v and bY
        res.z.v = a.z.v and bZ
        return res
    }

    fun or(res: Vec3ui, a: Vec3ui, bX: Uint, bY: Uint, bZ: Uint): Vec3ui {
        res.x.v = a.x.v or bX.v
        res.y.v = a.y.v or bY.v
        res.z.v = a.z.v or bZ.v
        return res
    }

    fun or(res: Vec3ui, a: Vec3ui, bX: Int, bY: Int, bZ: Int): Vec3ui {
        res.x.v = a.x.v or bX
        res.y.v = a.y.v or bY
        res.z.v = a.z.v or bZ
        return res
    }

    fun xor(res: Vec3ui, a: Vec3ui, bX: Uint, bY: Uint, bZ: Uint): Vec3ui {
        res.x.v = a.x.v xor bX.v
        res.y.v = a.y.v xor bY.v
        res.z.v = a.z.v xor bZ.v
        return res
    }

    fun xor(res: Vec3ui, a: Vec3ui, bX: Int, bY: Int, bZ: Int): Vec3ui {
        res.x.v = a.x.v xor bX
        res.y.v = a.y.v xor bY
        res.z.v = a.z.v xor bZ
        return res
    }

    fun shl(res: Vec3ui, a: Vec3ui, bX: Uint, bY: Uint, bZ: Uint): Vec3ui {
        res.x.v = a.x.v shl bX.v
        res.y.v = a.y.v shl bY.v
        res.z.v = a.z.v shl bZ.v
        return res
    }

    fun shl(res: Vec3ui, a: Vec3ui, bX: Int, bY: Int, bZ: Int): Vec3ui {
        res.x.v = a.x.v shl bX
        res.y.v = a.y.v shl bY
        res.z.v = a.z.v shl bZ
        return res
    }

    fun shr(res: Vec3ui, a: Vec3ui, bX: Uint, bY: Uint, bZ: Uint): Vec3ui {
        res.x.v = a.x.v ushr bX.v
        res.y.v = a.y.v ushr bY.v
        res.z.v = a.z.v ushr bZ.v
        return res
    }

    fun shr(res: Vec3ui, a: Vec3ui, bX: Int, bY: Int, bZ: Int): Vec3ui {
        res.x.v = a.x.v ushr bX
        res.y.v = a.y.v ushr bY
        res.z.v = a.z.v ushr bZ
        return res
    }

    fun inv(res: Vec3ui, a: Vec3ui): Vec3ui {
        res.x.v = a.x.v.inv()
        res.y.v = a.y.v.inv()
        res.z.v = a.z.v.inv()
        return res
    }
}


// -- Specific binary arithmetic operators --

operator fun Uint.plus(b: Vec3ui) = add(Vec3ui(), b, this, this, this)
fun Uint.add(b: Vec3ui, res: Vec3ui = Vec3ui()) = add(res, b, this, this, this)
infix fun Uint.add_(b: Vec3ui) = add(b, b, this, this, this)

operator fun Uint.minus(b: Vec3ui) = sub(Vec3ui(), this, this, this, b)
fun Uint.sub(b: Vec3ui, res: Vec3ui = Vec3ui()) = sub(res, b, this, this, this)
infix fun Uint.sub_(b: Vec3ui) = sub(b, this, this, this, b)

operator fun Uint.times(b: Vec3ui) = mul(Vec3ui(), b, this, this, this)
fun Uint.mul(b: Vec3ui, res: Vec3ui = Vec3ui()) = mul(res, b, this, this, this)
infix fun Uint.mul_(b: Vec3ui) = mul(b, b, this, this, this)

operator fun Uint.div(b: Vec3ui) = div(Vec3ui(), this, this, this, b)
fun Uint.div(b: Vec3ui, res: Vec3ui) = div(res, b, this, this, this)
infix fun Uint.div_(b: Vec3ui) = div(b, this, this, this, b)

operator fun Uint.rem(b: Vec3ui) = rem(Vec3ui(), this, this, this, b)
fun Uint.rem(b: Vec3ui, res: Vec3ui) = rem(res, b, this, this, this)
infix fun Uint.rem_(b: Vec3ui) = rem(b, this, this, this, b)


operator fun Int.plus(b: Vec3ui) = add(Vec3ui(), b, this, this, this)
fun Int.add(b: Vec3ui, res: Vec3ui = Vec3ui()) = add(res, b, this, this, this)
infix fun Int.add_(b: Vec3ui) = add(b, b, this, this, this)

operator fun Int.minus(b: Vec3ui) = sub(Vec3ui(), this, this, this, b)
fun Int.sub(b: Vec3ui, res: Vec3ui = Vec3ui()) = sub(res, b, this, this, this)
infix fun Int.sub_(b: Vec3ui) = sub(b, this, this, this, b)

operator fun Int.times(b: Vec3ui) = mul(Vec3ui(), b, this, this, this)
fun Int.mul(b: Vec3ui, res: Vec3ui = Vec3ui()) = mul(res, b, this, this, this)
infix fun Int.mul_(b: Vec3ui) = mul(b, b, this, this, this)

operator fun Int.div(b: Vec3ui) = div(Vec3ui(), this, this, this, b)
fun Int.div(b: Vec3ui, res: Vec3ui) = div(res, b, this, this, this)
infix fun Int.div_(b: Vec3ui) = div(b, this, this, this, b)

operator fun Int.rem(b: Vec3ui) = rem(Vec3ui(), this, this, this, b)
fun Int.rem(b: Vec3ui, res: Vec3ui) = rem(res, b, this, this, this)
infix fun Int.rem_(b: Vec3ui) = rem(b, this, this, this, b)


// -- Generic binary arithmetic operators --

operator fun Number.plus(b: Vec3ui) = add(Vec3ui(), b, this.i, this.i, this.i)
fun Number.add(b: Vec3ui, res: Vec3ui = Vec3ui()) = add(res, b, this.i, this.i, this.i)
infix fun Number.add_(b: Vec3ui) = add(b, b, this.i, this.i, this.i)

operator fun Number.minus(b: Vec3ui) = sub(Vec3ui(), this.i, this.i, this.i, b)
fun Number.sub(b: Vec3ui, res: Vec3ui = Vec3ui()) = sub(res, b, this.i, this.i, this.i)
infix fun Number.sub_(b: Vec3ui) = sub(b, this.i, this.i, this.i, b)

operator fun Number.times(b: Vec3ui) = mul(Vec3ui(), b, this.i, this.i, this.i)
fun Number.mul(b: Vec3ui, res: Vec3ui = Vec3ui()) = mul(res, b, this.i, this.i, this.i)
infix fun Number.mul_(b: Vec3ui) = mul(b, b, this.i, this.i, this.i)

operator fun Number.div(b: Vec3ui) = div(Vec3ui(), this.i, this.i, this.i, b)
fun Number.div(b: Vec3ui, res: Vec3ui) = div(res, b, this.i, this.i, this.i)
infix fun Number.div_(b: Vec3ui) = div(b, this.i, this.i, this.i, b)

operator fun Number.rem(b: Vec3ui) = rem(Vec3ui(), this.i, this.i, this.i, b)
fun Number.rem(b: Vec3ui, res: Vec3ui) = rem(res, b, this.i, this.i, this.i)
infix fun Number.rem_(b: Vec3ui) = rem(b, this.i, this.i, this.i, b)