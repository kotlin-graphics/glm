package vec._4.operators

import main.f
import vec._4.Vec4
import vec._4.Vec4.Companion.add
import vec._4.Vec4.Companion.div
import vec._4.Vec4.Companion.mul
import vec._4.Vec4.Companion.rem
import vec._4.Vec4.Companion.sub

/**
 * Created by elect on 05/11/16.
 */

interface vec4_operators {

    fun add(res: Vec4, a: Vec4, bX: Float, bY: Float, bZ: Float, bW: Float): Vec4 {
        res.x = a.x + bX
        res.y = a.y + bY
        res.z = a.z + bZ
        res.w = a.w + bW
        return res
    }

    fun sub(res: Vec4, a: Vec4, bX: Float, bY: Float, bZ: Float, bW: Float): Vec4 {
        res.x = a.x - bX
        res.y = a.y - bY
        res.z = a.z - bZ
        res.w = a.w - bW
        return res
    }

    fun sub(res: Vec4, aX: Float, aY: Float, aZ: Float, aW: Float, b: Vec4): Vec4 {
        res.x = aX - b.x
        res.y = aY - b.y
        res.z = aZ - b.z
        res.w = aW - b.w
        return res
    }

    fun mul(res: Vec4, a: Vec4, bX: Float, bY: Float, bZ: Float, bW: Float): Vec4 {
        res.x = a.x * bX
        res.y = a.y * bY
        res.z = a.z * bZ
        res.w = a.w * bW
        return res
    }

    fun div(res: Vec4, a: Vec4, bX: Float, bY: Float, bZ: Float, bW: Float): Vec4 {
        res.x = a.x / bX
        res.y = a.y / bY
        res.z = a.z / bZ
        res.w = a.w / bW
        return res
    }

    fun div(res: Vec4, aX: Float, aY: Float, aZ: Float, aW: Float, b: Vec4): Vec4 {
        res.x = aX / b.x
        res.y = aY / b.y
        res.z = aZ / b.z
        res.w = aW / b.w
        return res
    }

    fun rem(res: Vec4, a: Vec4, bX: Float, bY: Float, bZ: Float, bW: Float): Vec4 {
        res.x = a.x % bX
        res.y = a.y % bY
        res.z = a.z % bZ
        res.w = a.w % bW
        return res
    }

    fun rem(res: Vec4, aX: Float, aY: Float, aZ: Float, aW: Float, b: Vec4): Vec4 {
        res.x = aX % b.x
        res.y = aY % b.y
        res.z = aZ % b.z
        res.w = aW % b.w
        return res
    }
}


// -- Specific binary arithmetic operators --

operator fun Float.plus(b: Vec4) = add(Vec4(), b, this, this, this, this)
fun Float.add(b: Vec4, res: Vec4 = Vec4()) = add(res, b, this, this, this, this)
infix fun Float.add_(b: Vec4) = add(b, b, this, this, this, this)

operator fun Float.minus(b: Vec4) = sub(Vec4(), this, this, this, this, b)
fun Float.sub(b: Vec4, res: Vec4 = Vec4()) = sub(res, b, this, this, this, this)
infix fun Float.sub_(b: Vec4) = sub(b, this, this, this, this, b)

operator fun Float.times(b: Vec4) = mul(Vec4(), b, this, this, this, this)
fun Float.mul(b: Vec4, res: Vec4 = Vec4()) = mul(res, b, this, this, this, this)
infix fun Float.mul_(b: Vec4) = mul(b, b, this, this, this, this)

operator fun Float.div(b: Vec4) = div(Vec4(), this, this, this, this, b)
fun Float.div(b: Vec4, res: Vec4 = Vec4()) = div(res, b, this, this, this, this)
infix fun Float.div_(b: Vec4) = div(b, this, this, this, this, b)

operator fun Float.rem(b: Vec4) = rem(Vec4(), this, this, this, this, b)
fun Float.rem(b: Vec4, res: Vec4 = Vec4()) = rem(res, b, this, this, this, this)
infix fun Float.rem_(b: Vec4) = rem(b, this, this, this, this, b)


// -- Generic binary arithmetic operators --

operator fun Number.plus(b: Vec4) = add(Vec4(), b, this.f, this.f, this.f, this.f)
fun Number.add(b: Vec4, res: Vec4 = Vec4()) = add(res, b, this.f, this.f, this.f, this.f)
infix fun Number.add_(b: Vec4) = add(b, b, this.f, this.f, this.f, this.f)

operator fun Number.minus(b: Vec4) = sub(Vec4(), this.f, this.f, this.f, this.f, b)
fun Number.sub(b: Vec4, res: Vec4 = Vec4()) = sub(res, b, this.f, this.f, this.f, this.f)
infix fun Number.sub_(b: Vec4) = sub(b, this.f, this.f, this.f, this.f, b)

operator fun Number.times(b: Vec4) = mul(Vec4(), b, this.f, this.f, this.f, this.f)
fun Number.mul(b: Vec4, res: Vec4 = Vec4()) = mul(res, b, this.f, this.f, this.f, this.f)
infix fun Number.mul_(b: Vec4) = mul(b, b, this.f, this.f, this.f, this.f)

operator fun Number.div(b: Vec4) = div(Vec4(), this.f, this.f, this.f, this.f, b)
fun Number.div(b: Vec4, res: Vec4 = Vec4()) = div(res, b, this.f, this.f, this.f, this.f)
infix fun Number.div_(b: Vec4) = div(b, this.f, this.f, this.f, this.f, b)

operator fun Number.rem(b: Vec4) = rem(Vec4(), this.f, this.f, this.f, this.f, b)
fun Number.rem(b: Vec4, res: Vec4 = Vec4()) = rem(res, b, this.f, this.f, this.f, this.f)
infix fun Number.rem_(b: Vec4) = rem(b, this.f, this.f, this.f, this.f, b)