package vec._3.operators

import f
import vec._3.Vec3
import vec._3.Vec3.Companion.add
import vec._3.Vec3.Companion.div
import vec._3.Vec3.Companion.mul
import vec._3.Vec3.Companion.rem
import vec._3.Vec3.Companion.sub

/**
 * Created by elect on 05/11/16.
 */

interface vec3_operators {

    fun add(res: Vec3, a: Vec3, bX: Float, bY: Float, bZ: Float): Vec3 {
        res.x = a.x + bX
        res.y = a.y + bY
        res.z = a.z + bZ
        return res
    }

    fun sub(res: Vec3, a: Vec3, bX: Float, bY: Float, bZ: Float): Vec3 {
        res.x = a.x - bX
        res.y = a.y - bY
        res.z = a.z - bZ
        return res
    }

    fun sub(res: Vec3, aX: Float, aY: Float, aZ: Float, b: Vec3): Vec3 {
        res.x = aX - b.x
        res.y = aY - b.y
        res.z = aZ - b.z
        return res
    }

    fun mul(res: Vec3, a: Vec3, bX: Float, bY: Float, bZ: Float): Vec3 {
        res.x = a.x * bX
        res.y = a.y * bY
        res.z = a.z * bZ
        return res
    }

    fun div(res: Vec3, a: Vec3, bX: Float, bY: Float, bZ: Float): Vec3 {
        res.x = a.x / bX
        res.y = a.y / bY
        res.z = a.z / bZ
        return res
    }

    fun div(res: Vec3, aX: Float, aY: Float, aZ: Float, b: Vec3): Vec3 {
        res.x = aX / b.x
        res.y = aY / b.y
        res.z = aZ / b.z
        return res
    }

    fun rem(res: Vec3, a: Vec3, bX: Float, bY: Float, bZ: Float): Vec3 {
        res.x = a.x % bX
        res.y = a.y % bY
        res.z = a.z % bZ
        return res
    }

    fun rem(res: Vec3, aX: Float, aY: Float, aZ: Float, b: Vec3): Vec3 {
        res.x = aX % b.x
        res.y = aY % b.y
        res.z = aZ % b.z
        return res
    }
}


// -- Specific binary arithmetic operators --

operator fun Float.plus(b: Vec3) = add(Vec3(), b, this, this, this)
fun Float.add(b: Vec3, res: Vec3 = Vec3()) = add(res, b, this, this, this)
infix fun Float.add_(b: Vec3) = add(b, b, this, this, this)

operator fun Float.minus(b: Vec3) = sub(Vec3(), this, this, this, b)
fun Float.sub(b: Vec3, res: Vec3 = Vec3()) = sub(res, b, this, this, this)
infix fun Float.sub_(b: Vec3) = sub(b, this, this, this, b)

operator fun Float.times(b: Vec3) = mul(Vec3(), b, this, this, this)
fun Float.mul(b: Vec3, res: Vec3 = Vec3()) = mul(res, b, this, this, this)
infix fun Float.mul_(b: Vec3) = mul(b, b, this, this, this)

operator fun Float.div(b: Vec3) = div(Vec3(), this, this, this, b)
fun Float.div(b: Vec3, res: Vec3 = Vec3()) = div(res, b, this, this, this)
infix fun Float.div_(b: Vec3) = div(b, this, this, this, b)

operator fun Float.rem(b: Vec3) = rem(Vec3(), this, this, this, b)
fun Float.rem(b: Vec3, res: Vec3 = Vec3()) = rem(res, b, this, this, this)
infix fun Float.rem_(b: Vec3) = rem(b, this, this, this, b)


// -- Generic binary arithmetic operators --

operator fun Number.plus(b: Vec3) = add(Vec3(), b, this.f, this.f, this.f)
fun Number.add(b: Vec3, res: Vec3 = Vec3()) = add(res, b, this.f, this.f, this.f)
infix fun Number.add_(b: Vec3) = add(b, b, this.f, this.f, this.f)

operator fun Number.minus(b: Vec3) = sub(Vec3(), this.f, this.f, this.f, b)
fun Number.sub(b: Vec3, res: Vec3 = Vec3()) = sub(res, b, this.f, this.f, this.f)
infix fun Number.sub_(b: Vec3) = sub(b, this.f, this.f, this.f, b)

operator fun Number.times(b: Vec3) = mul(Vec3(), b, this.f, this.f, this.f)
fun Number.mul(b: Vec3, res: Vec3 = Vec3()) = mul(res, b, this.f, this.f, this.f)
infix fun Number.mul_(b: Vec3) = mul(b, b, this.f, this.f, this.f)

operator fun Number.div(b: Vec3) = div(Vec3(), this.f, this.f, this.f, b)
fun Number.div(b: Vec3, res: Vec3 = Vec3()) = div(res, b, this.f, this.f, this.f)
infix fun Number.div_(b: Vec3) = div(b, this.f, this.f, this.f, b)

operator fun Number.rem(b: Vec3) = rem(Vec3(), this.f, this.f, this.f, b)
fun Number.rem(b: Vec3, res: Vec3 = Vec3()) = rem(res, b, this.f, this.f, this.f)
infix fun Number.rem_(b: Vec3) = rem(b, this.f, this.f, this.f, b)