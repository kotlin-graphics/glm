package vec._4.operators

import L
import i
import vec._4.Vec4l
import vec._4.Vec4l.Companion.add
import vec._4.Vec4l.Companion.div
import vec._4.Vec4l.Companion.mul
import vec._4.Vec4l.Companion.rem
import vec._4.Vec4l.Companion.sub

/**
 * Created by GBarbieri on 08.11.2016.
 */
interface vec4l_operators {

    fun add(res: Vec4l, a: Vec4l, bX: Long, bY: Long, bZ: Long, bW: Long): Vec4l {
        res.x = a.x + bX
        res.y = a.y + bY
        res.z = a.z + bZ
        res.w = a.w + bW
        return res
    }

    fun sub(res: Vec4l, a: Vec4l, bX: Long, bY: Long, bZ: Long, bW: Long): Vec4l {
        res.x = a.x - bX
        res.y = a.y - bY
        res.z = a.z - bZ
        res.w = a.w - bW
        return res
    }

    fun sub(res: Vec4l, aX: Long, aY: Long, aZ: Long, aW: Long, b: Vec4l): Vec4l {
        res.x = aX - b.x
        res.y = aY - b.y
        res.z = aZ - b.z
        res.w = aW - b.w
        return res
    }

    fun mul(res: Vec4l, a: Vec4l, bX: Long, bY: Long, bZ: Long, bW: Long): Vec4l {
        res.x = a.x * bX
        res.y = a.y * bY
        res.z = a.z * bZ
        res.w = a.w * bW
        return res
    }

    fun div(res: Vec4l, a: Vec4l, bX: Long, bY: Long, bZ: Long, bW: Long): Vec4l {
        res.x = a.x / bX
        res.y = a.y / bY
        res.z = a.z / bZ
        res.w = a.w / bW
        return res
    }

    fun div(res: Vec4l, aX: Long, aY: Long, aZ: Long, aW: Long, b: Vec4l): Vec4l {
        res.x = aX / b.x
        res.y = aY / b.y
        res.z = aZ / b.z
        res.w = aW / b.w
        return res
    }

    fun rem(res: Vec4l, a: Vec4l, bX: Long, bY: Long, bZ: Long, bW: Long): Vec4l {
        res.x = a.x % bX
        res.y = a.y % bY
        res.z = a.z % bZ
        res.w = a.w % bW
        return res
    }

    fun rem(res: Vec4l, aX: Long, aY: Long, aZ: Long, aW: Long, b: Vec4l): Vec4l {
        res.x = aX % b.x
        res.y = aY % b.y
        res.z = aZ % b.z
        res.w = aW % b.w
        return res
    }

    fun and(res: Vec4l, a: Vec4l, bX: Long, bY: Long, bZ: Long, bW: Long): Vec4l {
        res.x = a.x and bX
        res.y = a.y and bY
        res.z = a.z and bZ
        res.w = a.w and bW
        return res
    }

    fun or(res: Vec4l, a: Vec4l, bX: Long, bY: Long, bZ: Long, bW: Long): Vec4l {
        res.x = a.x or bX
        res.y = a.y or bY
        res.z = a.z or bZ
        res.w = a.w or bW
        return res
    }

    fun xor(res: Vec4l, a: Vec4l, bX: Long, bY: Long, bZ: Long, bW: Long): Vec4l {
        res.x = a.x xor bX
        res.y = a.y xor bY
        res.z = a.z xor bZ
        res.w = a.w xor bW
        return res
    }

    fun shl(res: Vec4l, a: Vec4l, bX: Long, bY: Long, bZ: Long, bW: Long): Vec4l {
        res.x = a.x shl bX.i
        res.y = a.y shl bY.i
        res.z = a.z shl bZ.i
        res.w = a.w shl bW.i
        return res
    }

    fun shl(res: Vec4l, a: Vec4l, bX: Int, bY: Int, bZ: Int, bW: Int): Vec4l {
        res.x = a.x shl bX
        res.y = a.y shl bY
        res.z = a.z shl bZ
        res.w = a.w shl bW
        return res
    }

    fun shr(res: Vec4l, a: Vec4l, bX: Long, bY: Long, bZ: Long, bW: Long): Vec4l {
        res.x = a.x shr bX.i
        res.y = a.y shr bY.i
        res.z = a.z shr bZ.i
        res.w = a.w shr bW.i
        return res
    }

    fun shr(res: Vec4l, a: Vec4l, bX: Int, bY: Int, bZ: Int, bW: Int): Vec4l {
        res.x = a.x shr bX
        res.y = a.y shr bY
        res.z = a.z shr bZ
        res.w = a.w shr bW
        return res
    }

    fun inv(res: Vec4l, a: Vec4l): Vec4l {
        res.x = a.x.inv()
        res.y = a.y.inv()
        res.z = a.z.inv()
        res.w = a.w.inv()
        return res
    }
}


// -- Specific binary arithmetic operators --

operator fun Long.plus(b: Vec4l) = add(Vec4l(), b, this, this, this, this)
fun Long.add(b: Vec4l, res: Vec4l = Vec4l()) = add(res, b, this, this, this, this)
infix fun Long.add_(b: Vec4l) = add(b, b, this, this, this, this)

operator fun Long.minus(b: Vec4l) = sub(Vec4l(), this, this, this, this, b)
fun Long.sub(b: Vec4l, res: Vec4l = Vec4l()) = sub(res, b, this, this, this, this)
infix fun Long.sub_(b: Vec4l) = sub(b, this, this, this, this, b)

operator fun Long.times(b: Vec4l) = mul(Vec4l(), b, this, this, this, this)
fun Long.mul(b: Vec4l, res: Vec4l = Vec4l()) = mul(res, b, this, this, this, this)
infix fun Long.mul_(b: Vec4l) = mul(b, b, this, this, this, this)

operator fun Long.div(b: Vec4l) = div(Vec4l(), this, this, this, this, b)
fun Long.div(b: Vec4l, res: Vec4l) = div(res, b, this, this, this, this)
infix fun Long.div_(b: Vec4l) = div(b, this, this, this, this, b)

operator fun Long.rem(b: Vec4l) = rem(Vec4l(), this, this, this, this, b)
fun Long.rem(b: Vec4l, res: Vec4l) = rem(res, b, this, this, this, this)
infix fun Long.rem_(b: Vec4l) = rem(b, this, this, this, this, b)


// -- Generic binary arithmetic operators --

operator fun Number.plus(b: Vec4l) = add(Vec4l(), b, this.L, this.L, this.L, this.L)
fun Number.add(b: Vec4l, res: Vec4l = Vec4l()) = add(res, b, this.L, this.L, this.L, this.L)
infix fun Number.add_(b: Vec4l) = add(b, b, this.L, this.L, this.L, this.L)

operator fun Number.minus(b: Vec4l) = sub(Vec4l(), this.L, this.L, this.L, this.L, b)
fun Number.sub(b: Vec4l, res: Vec4l = Vec4l()) = sub(res, b, this.L, this.L, this.L, this.L)
infix fun Number.sub_(b: Vec4l) = sub(b, this.L, this.L, this.L, this.L, b)

operator fun Number.times(b: Vec4l) = mul(Vec4l(), b, this.L, this.L, this.L, this.L)
fun Number.mul(b: Vec4l, res: Vec4l = Vec4l()) = mul(res, b, this.L, this.L, this.L, this.L)
infix fun Number.mul_(b: Vec4l) = mul(b, b, this.L, this.L, this.L, this.L)

operator fun Number.div(b: Vec4l) = div(Vec4l(), this.L, this.L, this.L, this.L, b)
fun Number.div(b: Vec4l, res: Vec4l) = div(res, b, this.L, this.L, this.L, this.L)
infix fun Number.div_(b: Vec4l) = div(b, this.L, this.L, this.L, this.L, b)

operator fun Number.rem(b: Vec4l) = rem(Vec4l(), this.L, this.L, this.L, this.L, b)
fun Number.rem(b: Vec4l, res: Vec4l) = rem(res, b, this.L, this.L, this.L, this.L)
infix fun Number.rem_(b: Vec4l) = rem(b, this.L, this.L, this.L, this.L, b)