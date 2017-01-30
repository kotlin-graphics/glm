package vec._3.operators

import main.d
import vec._3.Vec3d
import vec._3.Vec3d.Companion.add
import vec._3.Vec3d.Companion.div
import vec._3.Vec3d.Companion.mul
import vec._3.Vec3d.Companion.rem
import vec._3.Vec3d.Companion.sub

/**
 * Created by GBarbieri on 08.11.2016.
 */
interface vec3d_operators {

    fun add(res: Vec3d, a: Vec3d, bX: Double, bY: Double, bZ: Double): Vec3d {
        res.x = a.x + bX
        res.y = a.y + bY
        res.z = a.z + bZ
        return res
    }

    fun sub(res: Vec3d, a: Vec3d, bX: Double, bY: Double, bZ: Double): Vec3d {
        res.x = a.x - bX
        res.y = a.y - bY
        res.z = a.z - bZ
        return res
    }

    fun sub(res: Vec3d, aX: Double, aY: Double, aZ: Double, b: Vec3d): Vec3d {
        res.x = aX - b.x
        res.y = aY - b.y
        res.z = aZ - b.z
        return res
    }

    fun mul(res: Vec3d, a: Vec3d, bX: Double, bY: Double, bZ: Double): Vec3d {
        res.x = a.x * bX
        res.y = a.y * bY
        res.z = a.z * bZ
        return res
    }

    fun div(res: Vec3d, a: Vec3d, bX: Double, bY: Double, bZ: Double): Vec3d {
        res.x = a.x / bX
        res.y = a.y / bY
        res.z = a.z / bZ
        return res
    }

    fun div(res: Vec3d, aX: Double, aY: Double, aZ: Double, b: Vec3d): Vec3d {
        res.x = aX / b.x
        res.y = aY / b.y
        res.z = aZ / b.z
        return res
    }

    fun rem(res: Vec3d, a: Vec3d, bX: Double, bY: Double, bZ: Double): Vec3d {
        res.x = a.x % bX
        res.y = a.y % bY
        res.z = a.z % bZ
        return res
    }

    fun rem(res: Vec3d, aX: Double, aY: Double, aZ: Double, b: Vec3d): Vec3d {
        res.x = aX % b.x
        res.y = aY % b.y
        res.z = aZ % b.z
        return res
    }
}


// -- Specific binary arithmetic operators --

operator fun Double.plus(b: Vec3d) = add(Vec3d(), b, this, this, this)
fun Double.add(b: Vec3d, res: Vec3d = Vec3d()) = add(res, b, this, this, this)
infix fun Double.add_(b: Vec3d) = add(b, b, this, this, this)

operator fun Double.minus(b: Vec3d) = sub(Vec3d(), this, this, this, b)
fun Double.sub(b: Vec3d, res: Vec3d = Vec3d()) = sub(res, b, this, this, this)
infix fun Double.sub_(b: Vec3d) = sub(b, this, this, this, b)

operator fun Double.times(b: Vec3d) = mul(Vec3d(), b, this, this, this)
fun Double.mul(b: Vec3d, res: Vec3d = Vec3d()) = mul(res, b, this, this, this)
infix fun Double.mul_(b: Vec3d) = mul(b, b, this, this, this)

operator fun Double.div(b: Vec3d) = div(Vec3d(), this, this, this, b)
fun Double.div(b: Vec3d, res: Vec3d = Vec3d()) = div(res, b, this, this, this)
infix fun Double.div_(b: Vec3d) = div(b, this, this, this, b)

operator fun Double.rem(b: Vec3d) = rem(Vec3d(), this, this, this, b)
fun Double.rem(b: Vec3d, res: Vec3d = Vec3d()) = rem(res, b, this, this, this)
infix fun Double.rem_(b: Vec3d) = rem(b, this, this, this, b)


// -- Generic binary arithmetic operators --

operator fun Number.plus(b: Vec3d) = add(Vec3d(), b, this.d, this.d, this.d)
fun Number.add(b: Vec3d, res: Vec3d = Vec3d()) = add(res, b, this.d, this.d, this.d)
infix fun Number.add_(b: Vec3d) = add(b, b, this.d, this.d, this.d)

operator fun Number.minus(b: Vec3d) = sub(Vec3d(), this.d, this.d, this.d, b)
fun Number.sub(b: Vec3d, res: Vec3d = Vec3d()) = sub(res, b, this.d, this.d, this.d)
infix fun Number.sub_(b: Vec3d) = sub(b, this.d, this.d, this.d, b)

operator fun Number.times(b: Vec3d) = mul(Vec3d(), b, this.d, this.d, this.d)
fun Number.mul(b: Vec3d, res: Vec3d = Vec3d()) = mul(res, b, this.d, this.d, this.d)
infix fun Number.mul_(b: Vec3d) = mul(b, b, this.d, this.d, this.d)

operator fun Number.div(b: Vec3d) = div(Vec3d(), this.d, this.d, this.d, b)
fun Number.div(b: Vec3d, res: Vec3d = Vec3d()) = div(res, b, this.d, this.d, this.d)
infix fun Number.div_(b: Vec3d) = div(b, this.d, this.d, this.d, b)

operator fun Number.rem(b: Vec3d) = rem(Vec3d(), this.d, this.d, this.d, b)
fun Number.rem(b: Vec3d, res: Vec3d = Vec3d()) = rem(res, b, this.d, this.d, this.d)
infix fun Number.rem_(b: Vec3d) = rem(b, this.d, this.d, this.d, b)