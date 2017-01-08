package vec._4.operators

import d
import vec._4.Vec4d
import vec._4.Vec4d.Companion.add
import vec._4.Vec4d.Companion.div
import vec._4.Vec4d.Companion.mul
import vec._4.Vec4d.Companion.rem
import vec._4.Vec4d.Companion.sub

/**
 * Created by GBarbieri on 08.11.2016.
 */
interface vec4d_operators {

    fun add(res: Vec4d, a: Vec4d, bX: Double, bY: Double, bZ: Double, bW: Double): Vec4d {
        res.x = a.x + bX
        res.y = a.y + bY
        res.z = a.z + bZ
        res.w = a.w + bW
        return res
    }

    fun sub(res: Vec4d, a: Vec4d, bX: Double, bY: Double, bZ: Double, bW: Double): Vec4d {
        res.x = a.x - bX
        res.y = a.y - bY
        res.z = a.z - bZ
        res.w = a.w - bW
        return res
    }

    fun sub(res: Vec4d, aX: Double, aY: Double, aZ: Double, aW: Double, b: Vec4d): Vec4d {
        res.x = aX - b.x
        res.y = aY - b.y
        res.z = aZ - b.z
        res.w = aW - b.w
        return res
    }

    fun mul(res: Vec4d, a: Vec4d, bX: Double, bY: Double, bZ: Double, bW: Double): Vec4d {
        res.x = a.x * bX
        res.y = a.y * bY
        res.z = a.z * bZ
        res.w = a.w * bW
        return res
    }

    fun div(res: Vec4d, a: Vec4d, bX: Double, bY: Double, bZ: Double, bW: Double): Vec4d {
        res.x = a.x / bX
        res.y = a.y / bY
        res.z = a.z / bZ
        res.w = a.w / bW
        return res
    }

    fun div(res: Vec4d, aX: Double, aY: Double, aZ: Double, aW: Double, b: Vec4d): Vec4d {
        res.x = aX / b.x
        res.y = aY / b.y
        res.z = aZ / b.z
        res.w = aW / b.w
        return res
    }

    fun rem(res: Vec4d, a: Vec4d, bX: Double, bY: Double, bZ: Double, bW: Double): Vec4d {
        res.x = a.x % bX
        res.y = a.y % bY
        res.z = a.z % bZ
        res.w = a.w % bW
        return res
    }

    fun rem(res: Vec4d, aX: Double, aY: Double, aZ: Double, aW: Double, b: Vec4d): Vec4d {
        res.x = aX % b.x
        res.y = aY % b.y
        res.z = aZ % b.z
        res.w = aW % b.w
        return res
    }
}


// -- Specific binary arithmetic operators --

operator fun Double.plus(b: Vec4d) = add(Vec4d(), b, this, this, this, this)
fun Double.add(b: Vec4d, res: Vec4d = Vec4d()) = add(res, b, this, this, this, this)
infix fun Double.add_(b: Vec4d) = add(b, b, this, this, this, this)

operator fun Double.minus(b: Vec4d) = sub(Vec4d(), this, this, this, this, b)
fun Double.sub(b: Vec4d, res: Vec4d = Vec4d()) = sub(res, b, this, this, this, this)
infix fun Double.sub_(b: Vec4d) = sub(b, this, this, this, this, b)

operator fun Double.times(b: Vec4d) = mul(Vec4d(), b, this, this, this, this)
fun Double.mul(b: Vec4d, res: Vec4d = Vec4d()) = mul(res, b, this, this, this, this)
infix fun Double.mul_(b: Vec4d) = mul(b, b, this, this, this, this)

operator fun Double.div(b: Vec4d) = div(Vec4d(), this, this, this, this, b)
fun Double.div(b: Vec4d, res: Vec4d = Vec4d()) = div(res, b, this, this, this, this)
infix fun Double.div_(b: Vec4d) = div(b, this, this, this, this, b)

operator fun Double.rem(b: Vec4d) = rem(Vec4d(), this, this, this, this, b)
fun Double.rem(b: Vec4d, res: Vec4d = Vec4d()) = rem(res, b, this, this, this, this)
infix fun Double.rem_(b: Vec4d) = rem(b, this, this, this, this, b)


// -- Generic binary arithmetic operators --

operator fun Number.plus(b: Vec4d) = add(Vec4d(), b, this.d, this.d, this.d, this.d)
fun Number.add(b: Vec4d, res: Vec4d = Vec4d()) = add(res, b, this.d, this.d, this.d, this.d)
infix fun Number.add_(b: Vec4d) = add(b, b, this.d, this.d, this.d, this.d)

operator fun Number.minus(b: Vec4d) = sub(Vec4d(), this.d, this.d, this.d, this.d, b)
fun Number.sub(b: Vec4d, res: Vec4d = Vec4d()) = sub(res, b, this.d, this.d, this.d, this.d)
infix fun Number.sub_(b: Vec4d) = sub(b, this.d, this.d, this.d, this.d, b)

operator fun Number.times(b: Vec4d) = mul(Vec4d(), b, this.d, this.d, this.d, this.d)
fun Number.mul(b: Vec4d, res: Vec4d = Vec4d()) = mul(res, b, this.d, this.d, this.d, this.d)
infix fun Number.mul_(b: Vec4d) = mul(b, b, this.d, this.d, this.d, this.d)

operator fun Number.div(b: Vec4d) = div(Vec4d(), this.d, this.d, this.d, this.d, b)
fun Number.div(b: Vec4d, res: Vec4d = Vec4d()) = div(res, b, this.d, this.d, this.d, this.d)
infix fun Number.div_(b: Vec4d) = div(b, this.d, this.d, this.d, this.d, b)

operator fun Number.rem(b: Vec4d) = rem(Vec4d(), this.d, this.d, this.d, this.d, b)
fun Number.rem(b: Vec4d, res: Vec4d = Vec4d()) = rem(res, b, this.d, this.d, this.d, this.d)
infix fun Number.rem_(b: Vec4d) = rem(b, this.d, this.d, this.d, this.d, b)