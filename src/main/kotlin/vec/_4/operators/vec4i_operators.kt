package vec._4.operators

import glm.i
import vec._4.Vec4i
import vec._4.Vec4i.Companion.add
import vec._4.Vec4i.Companion.div
import vec._4.Vec4i.Companion.mul
import vec._4.Vec4i.Companion.rem
import vec._4.Vec4i.Companion.sub

/**
 * Created by GBarbieri on 08.11.2016.
 */
interface vec4i_operators {

    fun add(res: Vec4i, a: Vec4i, bX: Int, bY: Int, bZ: Int, bW: Int): Vec4i {
        res.x = a.x + bX
        res.y = a.y + bY
        res.z = a.z + bZ
        res.w = a.w + bW
        return res
    }

    fun sub(res: Vec4i, a: Vec4i, bX: Int, bY: Int, bZ: Int, bW: Int): Vec4i {
        res.x = a.x - bX
        res.y = a.y - bY
        res.z = a.z - bZ
        res.w = a.w - bW
        return res
    }

    fun sub(res: Vec4i, aX: Int, aY: Int, aZ: Int, aW: Int, b: Vec4i): Vec4i {
        res.x = aX - b.x
        res.y = aY - b.y
        res.z = aZ - b.z
        res.w = aW - b.w
        return res
    }

    fun mul(res: Vec4i, a: Vec4i, bX: Int, bY: Int, bZ: Int, bW: Int): Vec4i {
        res.x = a.x * bX
        res.y = a.y * bY
        res.z = a.z * bZ
        res.w = a.w * bW
        return res
    }

    fun div(res: Vec4i, a: Vec4i, bX: Int, bY: Int, bZ: Int, bW: Int): Vec4i {
        res.x = a.x / bX
        res.y = a.y / bY
        res.z = a.z / bZ
        res.w = a.w / bW
        return res
    }

    fun div(res: Vec4i, aX: Int, aY: Int, aZ: Int, aW: Int, b: Vec4i): Vec4i {
        res.x = aX / b.x
        res.y = aY / b.y
        res.z = aZ / b.z
        res.w = aW / b.w
        return res
    }

    fun rem(res: Vec4i, a: Vec4i, bX: Int, bY: Int, bZ: Int, bW: Int): Vec4i {
        res.x = a.x % bX
        res.y = a.y % bY
        res.z = a.z % bZ
        res.w = a.w % bW
        return res
    }

    fun rem(res: Vec4i, aX: Int, aY: Int, aZ: Int, aW: Int, b: Vec4i): Vec4i {
        res.x = aX % b.x
        res.y = aY % b.y
        res.z = aZ % b.z
        res.w = aW % b.w
        return res
    }

    fun and(res: Vec4i, a: Vec4i, bX: Int, bY: Int, bZ: Int, bW: Int): Vec4i {
        res.x = a.x and bX
        res.y = a.y and bY
        res.z = a.z and bZ
        res.w = a.w and bW
        return res
    }

    fun or(res: Vec4i, a: Vec4i, bX: Int, bY: Int, bZ: Int, bW: Int): Vec4i {
        res.x = a.x or bX
        res.y = a.y or bY
        res.z = a.z or bZ
        res.w = a.w or bW
        return res
    }

    fun xor(res: Vec4i, a: Vec4i, bX: Int, bY: Int, bZ: Int, bW: Int): Vec4i {
        res.x = a.x xor bX
        res.y = a.y xor bY
        res.z = a.z xor bZ
        res.w = a.w xor bW
        return res
    }

    fun shl(res: Vec4i, a: Vec4i, bX: Int, bY: Int, bZ: Int, bW: Int): Vec4i {
        res.x = a.x shl bX
        res.y = a.y shl bY
        res.z = a.z shl bZ
        res.w = a.w shl bZ
        return res
    }

    fun shr(res: Vec4i, a: Vec4i, bX: Int, bY: Int, bZ: Int, bW: Int): Vec4i {
        res.x = a.x shr bX
        res.y = a.y shr bY
        res.z = a.z shr bZ
        res.w = a.w shr bW
        return res
    }

    fun inv(res: Vec4i, a: Vec4i): Vec4i {
        res.x = a.x.inv()
        res.y = a.y.inv()
        res.z = a.z.inv()
        res.w = a.w.inv()
        return res
    }
}


// -- Specific binary arithmetic operators --

operator fun Int.plus(b: Vec4i) = add(Vec4i(), b, this, this, this, this)
fun Int.add(b: Vec4i, res: Vec4i = Vec4i()) = add(res, b, this, this, this, this)
infix fun Int.add_(b: Vec4i) = add(b, b, this, this, this, this)

operator fun Int.minus(b: Vec4i) = sub(Vec4i(), this, this, this, this, b)
fun Int.sub(b: Vec4i, res: Vec4i = Vec4i()) = sub(res, b, this, this, this, this)
infix fun Int.sub_(b: Vec4i) = sub(b, this, this, this, this, b)

operator fun Int.times(b: Vec4i) = mul(Vec4i(), b, this, this, this, this)
fun Int.mul(b: Vec4i, res: Vec4i = Vec4i()) = mul(res, b, this, this, this, this)
infix fun Int.mul_(b: Vec4i) = mul(b, b, this, this, this, this)

operator fun Int.div(b: Vec4i) = div(Vec4i(), this, this, this, this, b)
fun Int.div(b: Vec4i, res: Vec4i) = div(res, b, this, this, this, this)
infix fun Int.div_(b: Vec4i) = div(b, this, this, this, this, b)

operator fun Int.rem(b: Vec4i) = rem(Vec4i(), this, this, this, this, b)
fun Int.rem(b: Vec4i, res: Vec4i) = rem(res, b, this, this, this, this)
infix fun Int.rem_(b: Vec4i) = rem(b, this, this, this, this, b)


// -- Generic binary arithmetic operators --

operator fun Number.plus(b: Vec4i) = add(Vec4i(), b, this.i, this.i, this.i, this.i)
fun Number.add(b: Vec4i, res: Vec4i = Vec4i()) = add(res, b, this.i, this.i, this.i, this.i)
infix fun Number.add_(b: Vec4i) = add(b, b, this.i, this.i, this.i, this.i)

operator fun Number.minus(b: Vec4i) = sub(Vec4i(), this.i, this.i, this.i, this.i, b)
fun Number.sub(b: Vec4i, res: Vec4i = Vec4i()) = sub(res, b, this.i, this.i, this.i, this.i)
infix fun Number.sub_(b: Vec4i) = sub(b, this.i, this.i, this.i, this.i, b)

operator fun Number.times(b: Vec4i) = mul(Vec4i(), b, this.i, this.i, this.i, this.i)
fun Number.mul(b: Vec4i, res: Vec4i = Vec4i()) = mul(res, b, this.i, this.i, this.i, this.i)
infix fun Number.mul_(b: Vec4i) = mul(b, b, this.i, this.i, this.i, this.i)

operator fun Number.div(b: Vec4i) = div(Vec4i(), this.i, this.i, this.i, this.i, b)
fun Number.div(b: Vec4i, res: Vec4i) = div(res, b, this.i, this.i, this.i, this.i)
infix fun Number.div_(b: Vec4i) = div(b, this.i, this.i, this.i, this.i, b)

operator fun Number.rem(b: Vec4i) = rem(Vec4i(), this.i, this.i, this.i, this.i, b)
fun Number.rem(b: Vec4i, res: Vec4i) = rem(res, b, this.i, this.i, this.i, this.i)
infix fun Number.rem_(b: Vec4i) = rem(b, this.i, this.i, this.i, this.i, b)