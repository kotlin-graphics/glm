package quat

import vec._3.Vec3
import vec._4.Vec4
import quat.Quat.Companion.add
import quat.Quat.Companion.sub
import quat.Quat.Companion.mul
import quat.Quat.Companion.div
import main.Glm.dot

/**
 * Created by GBarbieri on 13.12.2016.
 */

interface quat_operators {

    fun add(res: Quat, a: Quat, b: Quat): Quat {
        res.w = a.w + b.w
        res.x = a.x + b.x
        res.y = a.y + b.y
        res.z = a.z + b.z
        return res
    }


    fun sub(res: Quat, a: Quat, b: Quat): Quat {
        res.w = a.w - b.w
        res.x = a.x - b.x
        res.y = a.y - b.y
        res.z = a.z - b.z
        return res
    }


    fun mul(res: Quat, a: Quat, b: Quat): Quat {
        res.w = a.w * b.w - a.x * b.x - a.y * b.y - a.z * b.z
        res.x = a.w * b.x + a.x * b.w + a.y * b.z - a.z * b.y
        res.y = a.w * b.y + a.y * b.w + a.z * b.x - a.x * b.z
        res.z = a.w * b.z + a.z * b.w + a.x * b.y - a.y * b.x
        return res
    }

    fun mul(res: Quat, a: Quat, b: Float): Quat {
        res.w = a.w * b
        res.x = a.x * b
        res.y = a.y * b
        res.z = a.z * b
        return res
    }

    fun mul(res: Vec3, a: Quat, b: Vec3): Vec3 {
        val uvX = a.y * b.z - b.y * a.z
        val uvY = a.z * b.x - b.z * a.x
        val uvZ = a.x * b.y - b.x * a.y
        val uuvX = a.y * uvZ - uvY * a.z
        val uuvY = a.z * uvX - uvZ * a.x
        val uuvZ = a.x * uvY - uvX * a.y
        res.x = b.x + (uvX * a.w + uuvX) * 2f
        res.y = b.y + (uvY * a.w + uuvY) * 2f
        res.z = b.z + (uvZ * a.w + uuvZ) * 2f
        return res
    }

    fun mul(res: Vec3, a: Vec3, b: Quat): Vec3 {
        val dot = dot(a, a)
        val iW = b.w / dot
        val iX = -b.x / dot
        val iY = -b.y / dot
        val iZ = -b.z / dot
        val uvX = iY * a.z - a.y * iZ
        val uvY = iZ * a.x - a.z * iX
        val uvZ = iX * a.y - a.x * iY
        val uuvX = iY * uvZ - uvY * iZ
        val uuvY = iZ * uvX - uvZ * iX
        val uuvZ = iX * uvY - uvX * iY
        res.x = a.x + (uvX * iW + uuvX) * 2f
        res.y = a.y + (uvY * iW + uuvY) * 2f
        res.z = a.z + (uvZ * iW + uuvZ) * 2f
        return res
    }

    fun mul(res: Quat, a: Quat, b: Vec4): Quat {
        res.w = a.w
        res.x = a.x * b.x
        res.y = a.y * b.y
        res.z = a.z * b.z
        return res
    }


    fun div(res: Quat, a: Quat, b: Float): Quat {
        res.w = a.w / b
        res.x = a.x / b
        res.y = a.y / b
        res.z = a.z / b
        return res
    }
}

// -- Unary arithmetic operators --

operator fun Quat.unaryPlus() = this

operator fun Quat.unaryMinus() = Quat(-w, -x, -y, -z)


// -- Specific binary arithmetic operators --

operator fun Quat.plus(b: Quat) = add(Quat(), this, b)

fun Quat.add(b: Quat, res: Quat = Quat()) = add(res, this, b)

infix fun Quat.add_(b: Quat) = add(this, this, b)


operator fun Quat.minus(b: Quat) = sub(Quat(), this, b)

fun Quat.sub(b: Quat, res: Quat = Quat()) = sub(res, this, b)

infix fun Quat.sub_(b: Quat) = sub(this, this, b)


operator fun Quat.times(b: Quat) = mul(Quat(), this, b)
operator fun Quat.times(b: Float) = mul(Quat(), this, b)
operator fun Quat.times(b: Vec3) = mul(Vec3(), this, b)
operator fun Quat.times(b: Vec4) = mul(Quat(), this, b)

fun Quat.mul(b: Quat, res: Quat = Quat()) = mul(res, this, b)
fun Quat.mul(b: Float, res: Quat = Quat()) = mul(res, this, b)
fun Quat.mul(b: Vec3, res: Vec3 = Vec3()) = mul(res, this, b)
fun Quat.mul(b: Vec4, res: Quat = Quat()) = mul(res, this, b)

infix fun Quat.mul_(b: Quat) = mul(this, this, b)
infix fun Quat.mul_(b: Float) = mul(this, this, b)
infix fun Quat.mul_(b: Vec3) = mul(b, this, b)
infix fun Quat.mul_(b: Vec4) = mul(this, this, b)

operator fun Float.times(b: Quat) = mul(Quat(), b, this)
operator fun Vec3.times(b: Quat) = mul(Vec3(), this, b)
operator fun Vec4.times(b: Quat) = mul(Quat(), b, this)


operator fun Quat.div(b: Float) = div(Quat(), this, b)

fun Quat.div(b: Float, res: Quat = Quat()) = div(res, this, b)

infix fun Quat.div_(b: Float) = div(this, this, b)