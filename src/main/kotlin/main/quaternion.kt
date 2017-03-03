package main

import main.Glm.sqrt
import mat.Mat3
import mat.Mat4
import quat.Quat

/**
 * Created by elect on 03/03/17.
 */

interface quaternion {

    fun quat_cast(res: Quat = Quat(), m: Mat3) = quat_cast(res, m[0][0], m[0][1], m[0][2], m[1][0], m[1][1], m[1][2], m[2][0], m[2][1], m[2][2])

    fun quat_cast(res: Quat = Quat(), m: Mat4) = quat_cast(res, m[0][0], m[0][1], m[0][2], m[1][0], m[1][1], m[1][2], m[2][0], m[2][1], m[2][2])

    fun quat_cast(res: Quat,
                  m00: Float, m01: Float, m02: Float,
                  m10: Float, m11: Float, m12: Float,
                  m20: Float, m21: Float, m22: Float): Quat {

        val fourXSquaredMinus1 = m00 - m11 - m22
        val fourYSquaredMinus1 = m11 - m00 - m22
        val fourZSquaredMinus1 = m22 - m00 - m11
        val fourWSquaredMinus1 = m00 + m11 + m22

        var biggestIndex = 0
        var fourBiggestSquaredMinus1 = fourWSquaredMinus1
        if (fourXSquaredMinus1 > fourBiggestSquaredMinus1) {
            fourBiggestSquaredMinus1 = fourXSquaredMinus1
            biggestIndex = 1
        }
        if (fourYSquaredMinus1 > fourBiggestSquaredMinus1) {
            fourBiggestSquaredMinus1 = fourYSquaredMinus1
            biggestIndex = 2
        }
        if (fourZSquaredMinus1 > fourBiggestSquaredMinus1) {
            fourBiggestSquaredMinus1 = fourZSquaredMinus1
            biggestIndex = 3
        }

        val biggestVal = sqrt(fourBiggestSquaredMinus1 + 1f) * 0.5f
        val mult = 0.25f / biggestVal

        when (biggestIndex) {
            0 -> {
                res.w = biggestVal
                res.x = (m12 - m21) * mult
                res.y = (m20 - m02) * mult
                res.z = (m01 - m10) * mult
            }
            1 -> {
                res.w = (m12 - m21) * mult
                res.x = biggestVal
                res.y = (m01 + m10) * mult
                res.z = (m20 + m02) * mult
            }
            2 -> {
                res.w = (m20 - m02) * mult
                res.x = (m01 + m10) * mult
                res.y = biggestVal
                res.z = (m12 + m21) * mult
            }
            3 -> {
                res.w = (m01 - m10) * mult
                res.x = (m20 + m02) * mult
                res.y = (m12 + m21) * mult
                res.z = biggestVal
            }

        // Silence a -Wswitch-default warning in GCC. Should never actually get here. Assert is just for sanity.
            else -> assert(false)
        }
        return res
    }

    fun mat4_cast(res: Mat4 = Mat4(), q: Quat): Mat4 {

        res put 1f
        val qxx = q.x * q.x
        val qyy = q.y * q.y
        val qzz = q.z * q.z
        val qxz = q.x * q.z
        val qxy = q.x * q.y
        val qyz = q.y * q.z
        val qwx = q.w * q.x
        val qwy = q.w * q.y
        val qwz = q.w * q.z

        res[0][0] = 1 - 2 * (qyy + qzz)
        res[0][1] = 2 * (qxy + qwz)
        res[0][2] = 2 * (qxz - qwy)

        res[1][0] = 2 * (qxy - qwz)
        res[1][1] = 1 - 2 * (qxx + qzz)
        res[1][2] = 2 * (qyz + qwx)

        res[2][0] = 2 * (qxz + qwy)
        res[2][1] = 2 * (qyz - qwx)
        res[2][2] = 1 - 2 * (qxx + qyy)
        return res
    }

    fun mat3_cast(res: Mat3 = Mat3(), q: Quat): Mat3 {

        res put 1f
        val qxx = q.x * q.x
        val qyy = q.y * q.y
        val qzz = q.z * q.z
        val qxz = q.x * q.z
        val qxy = q.x * q.y
        val qyz = q.y * q.z
        val qwx = q.w * q.x
        val qwy = q.w * q.y
        val qwz = q.w * q.z

        res[0][0] = 1 - 2 * (qyy + qzz)
        res[0][1] = 2 * (qxy + qwz)
        res[0][2] = 2 * (qxz - qwy)

        res[1][0] = 2 * (qxy - qwz)
        res[1][1] = 1 - 2 * (qxx + qzz)
        res[1][2] = 2 * (qyz + qwx)

        res[2][0] = 2 * (qxz + qwy)
        res[2][1] = 2 * (qyz - qwx)
        res[2][2] = 1 - 2 * (qxx + qyy)
        return res
    }
}