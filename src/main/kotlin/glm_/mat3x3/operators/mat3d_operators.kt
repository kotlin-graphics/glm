package  glm_.mat3x3.operators

import glm_.mat2x3.Mat2x3d
import glm_.mat3x3.Mat3d
import glm_.mat3x3.Mat3d.Companion.div
import glm_.mat3x3.Mat3d.Companion.minus
import glm_.mat3x3.Mat3d.Companion.plus
import glm_.mat3x3.Mat3d.Companion.times
import glm_.mat4x3.Mat4x3
import glm_.vec3.Vec3d
import glm_.vec3.Vec3d.Companion.div
import glm_.vec3.Vec3d.Companion.minus
import glm_.vec3.Vec3d.Companion.plus
import glm_.vec3.Vec3d.Companion.times

/**
 * Created by GBarbieri on 10.11.2016.
 */

interface mat3d_operators {


    fun plus(res: Mat3d, a: Mat3d, b: Double): Mat3d {
        plus(res[0], a[0], b, b, b)
        plus(res[1], a[1], b, b, b)
        plus(res[2], a[2], b, b, b)
        return res
    }

    fun plus(res: Mat3d, a: Mat3d, b: Mat3d): Mat3d {
        plus(res[0], a[0], b[0][0], b[0][1], b[0][2])
        plus(res[1], a[1], b[1][0], b[1][1], b[1][2])
        plus(res[2], a[2], b[2][0], b[2][1], b[2][2])
        return res
    }


    fun minus(res: Mat3d, a: Mat3d, b: Double): Mat3d {
        minus(res[0], a[0], b, b, b)
        minus(res[1], a[1], b, b, b)
        minus(res[2], a[2], b, b, b)
        return res
    }

    fun minus(res: Mat3d, a: Double, b: Mat3d): Mat3d {
        minus(res[0], a, a, a, b[0])
        minus(res[1], a, a, a, b[1])
        minus(res[2], a, a, a, b[2])
        return res
    }

    fun minus(res: Mat3d, a: Mat3d, b: Mat3d): Mat3d {
        minus(res[0], a[0], b[0][0], b[0][1], b[0][2])
        minus(res[1], a[1], b[1][0], b[1][1], b[1][2])
        minus(res[2], a[2], b[2][0], b[2][1], b[2][2])
        return res
    }


    fun times(res: Mat3d, a: Mat3d, b: Double): Mat3d {
        times(res[0], a[0], b, b, b)
        times(res[1], a[1], b, b, b)
        times(res[2], a[2], b, b, b)
        return res
    }

    fun times(res: Vec3d, a: Mat3d, b: Vec3d): Vec3d {
        res[0] = a[0][0] * b.x + a[1][0] * b.y + a[2][0] * b.z
        res[1] = a[0][1] * b.x + a[1][1] * b.y + a[2][1] * b.z
        res[2] = a[0][2] * b.x + a[1][2] * b.y + a[2][2] * b.z
        return res
    }

    fun times(res: Vec3d, a: Vec3d, b: Mat3d): Vec3d {
        res[0] = a.x * b[0][0] + a.y * b[0][1] + a.z * b[0][2]
        res[1] = a.x * b[1][0] + a.y * b[1][1] + a.z * b[1][2]
        res[2] = a.x * b[2][0] + a.y * b[2][1] + a.z * b[2][2]
        return res
    }

    fun times(res: Mat3d, a: Mat3d, b: Mat3d): Mat3d {
        val v00 = a[0][0] * b[0][0] + a[1][0] * b[0][1] + a[2][0] * b[0][2]
        val v01 = a[0][1] * b[0][0] + a[1][1] * b[0][1] + a[2][1] * b[0][2]
        val v02 = a[0][2] * b[0][0] + a[1][2] * b[0][1] + a[2][2] * b[0][2]
        val v10 = a[0][0] * b[1][0] + a[1][0] * b[1][1] + a[2][0] * b[1][2]
        val v11 = a[0][1] * b[1][0] + a[1][1] * b[1][1] + a[2][1] * b[1][2]
        val v12 = a[0][2] * b[1][0] + a[1][2] * b[1][1] + a[2][2] * b[1][2]
        val v20 = a[0][0] * b[2][0] + a[1][0] * b[2][1] + a[2][0] * b[2][2]
        val v21 = a[0][1] * b[2][0] + a[1][1] * b[2][1] + a[2][1] * b[2][2]
        val v22 = a[0][2] * b[2][0] + a[1][2] * b[2][1] + a[2][2] * b[2][2]
        res[0][0] = v00
        res[0][1] = v01
        res[0][2] = v02
        res[1][0] = v10
        res[1][1] = v11
        res[1][2] = v12
        res[2][0] = v20
        res[2][1] = v21
        res[2][2] = v22
        return res
    }

    fun times(res: Mat2x3d, a: Mat3d, b: Mat2x3d): Mat2x3d {
        val v00 = a[0][0] * b[0][0] + a[1][0] * b[0][1] + a[2][0] * b[0][2]
        val v01 = a[0][1] * b[0][0] + a[1][1] * b[0][1] + a[2][1] * b[0][2]
        val v02 = a[0][2] * b[0][0] + a[1][2] * b[0][1] + a[2][2] * b[0][2]
        val v10 = a[0][0] * b[1][0] + a[1][0] * b[1][1] + a[2][0] * b[1][2]
        val v11 = a[0][1] * b[1][0] + a[1][1] * b[1][1] + a[2][1] * b[1][2]
        val v12 = a[0][2] * b[1][0] + a[1][2] * b[1][1] + a[2][2] * b[1][2]
        res[0][0] = v00
        res[0][1] = v01
        res[0][2] = v02
        res[1][0] = v10
        res[1][1] = v11
        res[1][2] = v12
        return res
    }

    fun times(res: Mat4x3, a: Mat3d, b: Mat4x3): Mat4x3 {
        val v00 = a[0][0] * b[0][0] + a[1][0] * b[0][1] + a[2][0] * b[0][2]
        val v01 = a[0][1] * b[0][0] + a[1][1] * b[0][1] + a[2][1] * b[0][2]
        val v02 = a[0][2] * b[0][0] + a[1][2] * b[0][1] + a[2][2] * b[0][2]
        val v10 = a[0][0] * b[1][0] + a[1][0] * b[1][1] + a[2][0] * b[1][2]
        val v11 = a[0][1] * b[1][0] + a[1][1] * b[1][1] + a[2][1] * b[1][2]
        val v12 = a[0][2] * b[1][0] + a[1][2] * b[1][1] + a[2][2] * b[1][2]
        val v20 = a[0][0] * b[2][0] + a[1][0] * b[2][1] + a[2][0] * b[2][2]
        val v21 = a[0][1] * b[2][0] + a[1][1] * b[2][1] + a[2][1] * b[2][2]
        val v22 = a[0][2] * b[2][0] + a[1][2] * b[2][1] + a[2][2] * b[2][2]
        val v30 = a[0][0] * b[3][0] + a[1][0] * b[3][1] + a[2][0] * b[3][2]
        val v31 = a[0][1] * b[3][0] + a[1][1] * b[3][1] + a[2][1] * b[3][2]
        val v32 = a[0][2] * b[3][0] + a[1][2] * b[3][1] + a[2][2] * b[3][2]
        res[0][0] = v00
        res[0][1] = v01
        res[0][2] = v02
        res[1][0] = v10
        res[1][1] = v11
        res[1][2] = v12
        res[2][0] = v20
        res[2][1] = v21
        res[2][2] = v22
        res[3][0] = v30
        res[3][1] = v31
        res[3][2] = v32
        return res
    }


    fun div(res: Mat3d, a: Mat3d, b: Double): Mat3d {
        div(res[0], a[0], b, b, b)
        div(res[1], a[1], b, b, b)
        div(res[2], a[2], b, b, b)
        return res
    }

    fun div(res: Mat3d, a: Double, b: Mat3d): Mat3d {
        div(res[0], a, a, a, b[0])
        div(res[1], a, a, a, b[1])
        div(res[2], a, a, a, b[2])
        return res
    }

    fun div(res: Vec3d, a: Mat3d, b: Vec3d): Vec3d {
        val oneOverDet = 1 / a.det()
        val i00 = +(a[1][1] * a[2][2] - a[2][1] * a[1][2]) * oneOverDet
        val i01 = -(a[1][0] * a[2][2] - a[2][0] * a[1][2]) * oneOverDet
        val i02 = +(a[1][0] * a[2][1] - a[2][0] * a[1][1]) * oneOverDet
        val i10 = -(a[0][1] * a[2][2] - a[2][1] * a[0][2]) * oneOverDet
        val i11 = +(a[0][0] * a[2][2] - a[2][0] * a[0][2]) * oneOverDet
        val i12 = -(a[0][0] * a[2][1] - a[2][0] * a[0][1]) * oneOverDet
        val i20 = +(a[0][1] * a[1][2] - a[1][1] * a[0][2]) * oneOverDet
        val i21 = -(a[0][0] * a[1][2] - a[1][0] * a[0][2]) * oneOverDet
        val i22 = +(a[0][0] * a[1][1] - a[1][0] * a[0][1]) * oneOverDet
        res[0] = i00 * b.x + i10 * b.y + i20 * b.z
        res[1] = i01 * b.x + i11 * b.y + i21 * b.z
        res[2] = i02 * b.x + i12 * b.y + i22 * b.z
        return res
    }

    fun div(res: Vec3d, a: Vec3d, b: Mat3d): Vec3d {
        val oneOverDet = 1 / b.det()
        val i00 = +(b[1][1] * b[2][2] - b[2][1] * b[1][2]) * oneOverDet
        val i01 = -(b[1][0] * b[2][2] - b[2][0] * b[1][2]) * oneOverDet
        val i02 = +(b[1][0] * b[2][1] - b[2][0] * b[1][1]) * oneOverDet
        val i10 = -(b[0][1] * b[2][2] - b[2][1] * b[0][2]) * oneOverDet
        val i11 = +(b[0][0] * b[2][2] - b[2][0] * b[0][2]) * oneOverDet
        val i12 = -(b[0][0] * b[2][1] - b[2][0] * b[0][1]) * oneOverDet
        val i20 = +(b[0][1] * b[1][2] - b[1][1] * b[0][2]) * oneOverDet
        val i21 = -(b[0][0] * b[1][2] - b[1][0] * b[0][2]) * oneOverDet
        val i22 = +(b[0][0] * b[1][1] - b[1][0] * b[0][1]) * oneOverDet
        res[0] = a.x * i00 + a.y * i01 + a.z * i02
        res[1] = a.x * i10 + a.y * i11 + a.z * i12
        res[2] = a.x * i20 + a.y * i21 + a.z * i22
        return res
    }

    fun div(res: Mat3d, a: Mat3d, b: Mat3d): Mat3d {
        b.inverse(res) *= a
        return res
    }
}


// -- Specific binary arithmetic operators --

operator fun Double.plus(b: Mat3d) = plus(Mat3d(), b, this)
fun Double.plus(b: Mat3d, res: Mat3d = Mat3d()) = plus(res, b, this)
infix fun Double.plus_(b: Mat3d) = plus(b, b, this)

operator fun Double.minus(b: Mat3d) = minus(Mat3d(), this, b)
fun Double.minus(b: Mat3d, res: Mat3d = Mat3d()) = minus(res, this, b)
infix fun Double.minus_(b: Mat3d) = minus(b, this, b)

operator fun Double.times(b: Mat3d) = times(Mat3d(), b, this)
fun Double.times(b: Mat3d, res: Mat3d = Mat3d()) = times(res, b, this)
infix fun Double.times_(b: Mat3d) = times(b, b, this)

operator fun Vec3d.times(b: Mat3d) = times(Vec3d(), this, b)
fun Vec3d.times(b: Mat3d, res: Vec3d = Vec3d()) = times(res, this, b)
infix fun Vec3d.times_(b: Mat3d) = times(this, this, b)

operator fun Double.div(b: Mat3d) = div(Mat3d(), this, b)
fun Double.div(b: Mat3d, res: Mat3d = Mat3d()) = div(res, this, b)
infix fun Double.div_(b: Mat3d) = div(b, this, b)