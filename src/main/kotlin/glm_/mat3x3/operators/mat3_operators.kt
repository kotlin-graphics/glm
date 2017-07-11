package  glm_.mat3x3.operators

import glm_.mat2x3.Mat2x3
import glm_.mat3x3.Mat3
import glm_.mat3x3.Mat3.Companion.div
import glm_.mat3x3.Mat3.Companion.minus
import glm_.mat3x3.Mat3.Companion.plus
import glm_.mat3x3.Mat3.Companion.times
import glm_.mat4x3.Mat4x3
import glm_.vec3.Vec3
import glm_.vec3.Vec3.Companion.div
import glm_.vec3.Vec3.Companion.minus
import glm_.vec3.Vec3.Companion.plus
import glm_.vec3.Vec3.Companion.times

/**
 * Created by GBarbieri on 10.11.2016.
 */

interface mat3x3_operators {


    fun plus(res: Mat3, a: Mat3, b: Float): Mat3 {
        plus(res[0], a[0], b, b, b)
        plus(res[1], a[1], b, b, b)
        plus(res[2], a[2], b, b, b)
        return res
    }

    fun plus(res: Mat3, a: Mat3, b: Mat3): Mat3 {
        plus(res[0], a[0], b[0][0], b[0][1], b[0][2])
        plus(res[1], a[1], b[1][0], b[1][1], b[1][2])
        plus(res[2], a[2], b[2][0], b[2][1], b[2][2])
        return res
    }


    fun minus(res: Mat3, a: Mat3, b: Float): Mat3 {
        minus(res[0], a[0], b, b, b)
        minus(res[1], a[1], b, b, b)
        minus(res[2], a[2], b, b, b)
        return res
    }

    fun minus(res: Mat3, a: Float, b: Mat3): Mat3 {
        minus(res[0], a, a, a, b[0])
        minus(res[1], a, a, a, b[1])
        minus(res[2], a, a, a, b[2])
        return res
    }

    fun minus(res: Mat3, a: Mat3, b: Mat3): Mat3 {
        minus(res[0], a[0], b[0][0], b[0][1], b[0][2])
        minus(res[1], a[1], b[1][0], b[1][1], b[1][2])
        minus(res[2], a[2], b[2][0], b[2][1], b[2][2])
        return res
    }


    fun times(res: Mat3, a: Mat3, b: Float): Mat3 {
        times(res[0], a[0], b, b, b)
        times(res[1], a[1], b, b, b)
        times(res[2], a[2], b, b, b)
        return res
    }

    fun times(res: Vec3, a: Mat3, b: Vec3): Vec3 {
        res[0] = a[0][0] * b.x + a[1][0] * b.y + a[2][0] * b.z
        res[1] = a[0][1] * b.x + a[1][1] * b.y + a[2][1] * b.z
        res[2] = a[0][2] * b.x + a[1][2] * b.y + a[2][2] * b.z
        return res
    }

    fun times(res: Vec3, a: Vec3, b: Mat3): Vec3 {
        res[0] = a.x * b[0][0] + a.y * b[0][1] + a.z * b[0][2]
        res[1] = a.x * b[1][0] + a.y * b[1][1] + a.z * b[1][2]
        res[2] = a.x * b[2][0] + a.y * b[2][1] + a.z * b[2][2]
        return res
    }

    fun times(res: Mat3, a: Mat3, b: Mat3): Mat3 {
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

    fun times(res: Mat2x3, a: Mat3, b: Mat2x3): Mat2x3 {
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

    fun times(res: Mat4x3, a: Mat3, b: Mat4x3): Mat4x3 {
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


    fun div(res: Mat3, a: Mat3, b: Float): Mat3 {
        div(res[0], a[0], b, b, b)
        div(res[1], a[1], b, b, b)
        div(res[2], a[2], b, b, b)
        return res
    }

    fun div(res: Mat3, a: Float, b: Mat3): Mat3 {
        div(res[0], a, a, a, b[0])
        div(res[1], a, a, a, b[1])
        div(res[2], a, a, a, b[2])
        return res
    }

    fun div(res: Vec3, a: Mat3, b: Vec3): Vec3 {
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

    fun div(res: Vec3, a: Vec3, b: Mat3): Vec3 {
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

    fun div(res: Mat3, a: Mat3, b: Mat3) = b.inverse(res) times_ a
}


// -- Specific binary arithmetic operators --

operator fun Float.plus(b: Mat3) = plus(Mat3(), b, this)
fun Float.plus(b: Mat3, res: Mat3 = Mat3()) = plus(res, b, this)
infix fun Float.plus_(b: Mat3) = plus(b, b, this)

operator fun Float.minus(b: Mat3) = minus(Mat3(), this, b)
fun Float.minus(b: Mat3, res: Mat3 = Mat3()) = minus(res, this, b)
infix fun Float.minus_(b: Mat3) = minus(b, this, b)

operator fun Float.times(b: Mat3) = times(Mat3(), b, this)
fun Float.times(b: Mat3, res: Mat3 = Mat3()) = times(res, b, this)
infix fun Float.times_(b: Mat3) = times(b, b, this)

operator fun Vec3.times(b: Mat3) = times(Vec3(), this, b)
fun Vec3.times(b: Mat3, res: Vec3 = Vec3()) = times(res, this, b)
infix fun Vec3.times_(b: Mat3) = times(this, this, b)

operator fun Float.div(b: Mat3) = div(Mat3(), this, b)
fun Float.div(b: Mat3, res: Mat3 = Mat3()) = div(res, this, b)
infix fun Float.div_(b: Mat3) = div(b, this, b)