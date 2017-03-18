package glm.quat

import glm.Glm.abs
import glm.Glm.acos
import glm.Glm.asin
import glm.Glm.atan
import glm.Glm.clamp
import glm.Glm.cos
import glm.Glm.epsilonD
import glm.Glm.epsilonF
import glm.Glm.mix
import glm.Glm.sin
import glm.Glm.sqrt
import glm.glm
import glm.mat.Mat3
import glm.mat.Mat3x3
import glm.mat.Mat4
import glm.mat.Mat4x4
import glm.vec._3.Vec3
import glm.vec._3.Vec3d
import glm.vec.bool.Vec4bool

/**
 * Created by GBarbieri on 14.12.2016.
 */

interface quat_func {


    /** Returns the length of the quaternion.   */
    fun length(q: Quat) = sqrt(dot(q, q))

    /** Returns the length of the quaternion.   */
    fun length(q: QuatD) = sqrt(dot(q, q))


    /** Returns the normalized quaternion.  */
    fun normalize(q: Quat, res: Quat): Quat {
        val len = length(q)
        if (len <= 0f)   // Problem
            return res.put(1f, 0f, 0f, 0f)
        val oneOverLen = 1f / len
        return res.put(q.w * oneOverLen, q.x * oneOverLen, q.y * oneOverLen, q.z * oneOverLen)
    }

    fun normalize(q: Quat) = normalize(q, Quat())

    /** Returns the normalized quaternion.  */
    fun normalize(q: QuatD, res: QuatD): QuatD {
        val len = length(q)
        if (len <= 0.0)   // Problem
            return res.put(1.0, 0.0, 0.0, 0.0)
        val oneOverLen = 1.0 / len
        return res.put(q.w * oneOverLen, q.x * oneOverLen, q.y * oneOverLen, q.z * oneOverLen)
    }

    fun normalize(q: QuatD) = normalize(q, QuatD())


    /** Returns dot product of q1 main.and q2, main.getI.e., q1[0] * q2[0] + q1[1] * q2[1] + ... */
    fun dot(a: Quat, b: Quat) = a.x * b.x + a.y * b.y + a.z * b.z + a.w * b.w

    /** Returns dot product of q1 main.and q2, main.getI.e., q1[0] * q2[0] + q1[1] * q2[1] + ... */
    fun dot(a: QuatD, b: QuatD) = a.x * b.x + a.y * b.y + a.z * b.z + a.w * b.w


    /** Spherical linear interpolation of two quaternions.
     * The interpolation is oriented main.and the rotation is performed at constant speed.
     * For short path spherical linear interpolation, use the slerp function.     */
    fun mix(a: Quat, b: Quat, interp: Float, res: Quat): Quat {

        val cosTheta = dot(a, b)

        // Perform a linear interpolation when cosTheta is close to 1 to avoid side effect of sin(angle) becoming a zero denominator
        if (cosTheta > 1f - epsilonF) {
            // Linear interpolation
            res.w = mix(a.w, b.w, interp)
            res.x = mix(a.x, b.x, interp)
            res.y = mix(a.y, b.y, interp)
            res.z = mix(a.z, b.z, interp)
            return res
        } else {
            // Essential Mathematics, page 467
            val angle = acos(cosTheta)
            val s0 = sin((1f - interp) * angle)
            val s1 = sin(interp * angle)
            val s2 = sin(angle)
            res.w = (s0 * a.w + s1 * b.w) / s2
            res.x = (s0 * a.x + s1 * b.x) / s2
            res.y = (s0 * a.y + s1 * b.y) / s2
            res.z = (s0 * a.z + s1 * b.z) / s2
            return res
        }
    }

    fun mix(a: Quat, b: Quat, interp: Float) = mix(a, b, interp, Quat())

    /** Spherical linear interpolation of two quaternions.
     * The interpolation is oriented main.and the rotation is performed at constant speed.
     * For short path spherical linear interpolation, use the slerp function.     */
    fun mix(a: QuatD, b: QuatD, interp: Double, res: QuatD): QuatD {

        val cosTheta = dot(a, b)

        // Perform a linear interpolation when cosTheta is close to 1 to avoid side effect of sin(angle) becoming a zero denominator
        if (cosTheta > 1.0 - epsilonD) {
            // Linear interpolation
            res.w = mix(a.w, b.w, interp)
            res.x = mix(a.x, b.x, interp)
            res.y = mix(a.y, b.y, interp)
            res.z = mix(a.z, b.z, interp)
            return res
        } else {
            // Essential Mathematics, page 467
            val angle = acos(cosTheta)
            val s0 = sin((1.0 - interp) * angle)
            val s1 = sin(interp * angle)
            val s2 = sin(angle)
            res.w = (s0 * a.w + s1 * b.w) / s2
            res.x = (s0 * a.x + s1 * b.x) / s2
            res.y = (s0 * a.y + s1 * b.y) / s2
            res.z = (s0 * a.z + s1 * b.z) / s2
            return res
        }
    }

    fun mix(a: QuatD, b: QuatD, interp: Double) = mix(a, b, interp, QuatD())


    /** Linear interpolation of two quaternions.
     * The interpolation is oriented.     */
    fun lerp(a: Quat, b: Quat, interp: Float, res: Quat): Quat {
        // Lerp is only defined in [0, 1]
        if (interp < 0f || interp > 1f)
            throw ArithmeticException("interp outside [0, 1]")

        res.w = a.w * (1f - interp) + b.w * interp
        res.x = a.x * (1f - interp) + b.x * interp
        res.y = a.y * (1f - interp) + b.y * interp
        res.z = a.z * (1f - interp) + b.z * interp
        return res
    }

    fun lerp(a: Quat, b: Quat, interp: Float) = lerp(a, b, interp, Quat())

    /** Linear interpolation of two quaternions.
     * The interpolation is oriented.     */
    fun lerp(a: QuatD, b: QuatD, interp: Double, res: QuatD): QuatD {
        // Lerp is only defined in [0, 1]
        if (interp < 0.0 || interp > 1.0)
            throw ArithmeticException("interp outside [0, 1]")

        res.w = a.w * (1.0 - interp) + b.w * interp
        res.x = a.x * (1.0 - interp) + b.x * interp
        res.y = a.y * (1.0 - interp) + b.y * interp
        res.z = a.z * (1.0 - interp) + b.z * interp
        return res
    }

    fun lerp(a: QuatD, b: QuatD, interp: Double) = lerp(a, b, interp, QuatD())


    /** Spherical linear interpolation of two quaternions.
     * The interpolation always take the short path main.and the rotation is performed at constant speed.     */
    fun slerp(a: Quat, b: Quat, interp: Float, res: Quat): Quat {

        var zW = b.w
        var zX = b.x
        var zY = b.y
        var zZ = b.z

        var cosTheta = dot(a, b)

        // If cosTheta < 0, the interpolation will take the long way around the sphere.
        // To fix this, one quat must be negated.
        if (cosTheta < 0f) {
            zW = -b.w
            zX = -b.x
            zY = -b.y
            zZ = -b.z
            cosTheta = -cosTheta
        }

        // Perform a linear interpolation when cosTheta is close to 1 to avoid side effect of sin(angle) becoming a zero denominator
        if (cosTheta > 1f - epsilonF) {
            // Linear interpolation
            res.w = mix(a.w, zW, interp)
            res.x = mix(a.x, zX, interp)
            res.y = mix(a.y, zY, interp)
            res.z = mix(a.z, zZ, interp)
            return res
        } else {
            // Essential Mathematics, page 467
            val angle = acos(cosTheta)
            val s0 = sin((1f - interp) * angle)
            val s1 = sin(interp * angle)
            val s2 = sin(angle)
            res.w = (s0 * a.w + s1 * zW) / s2
            res.x = (s0 * a.x + s1 * zX) / s2
            res.y = (s0 * a.y + s1 * zY) / s2
            res.z = (s0 * a.z + s1 * zZ) / s2
            return res
        }
    }

    fun slerp(a: Quat, b: Quat, interp: Float) = slerp(a, b, interp, Quat())

    /** Spherical linear interpolation of two quaternions.
     * The interpolation always take the short path main.and the rotation is performed at constant speed.     */
    fun slerp(a: QuatD, b: QuatD, interp: Double, res: QuatD): QuatD {

        var zW = b.w
        var zX = b.x
        var zY = b.y
        var zZ = b.z

        var cosTheta = dot(a, b)

        // If cosTheta < 0, the interpolation will take the long way around the sphere.
        // To fix this, one quat must be negated.
        if (cosTheta < 0.0) {
            zW = -b.w
            zX = -b.x
            zY = -b.y
            zZ = -b.z
            cosTheta = -cosTheta
        }

        // Perform a linear interpolation when cosTheta is close to 1 to avoid side effect of sin(angle) becoming a zero denominator
        if (cosTheta > 1.0 - epsilonD) {
            // Linear interpolation
            res.w = mix(a.w, zW, interp)
            res.x = mix(a.x, zX, interp)
            res.y = mix(a.y, zY, interp)
            res.z = mix(a.z, zZ, interp)
            return res
        } else {
            // Essential Mathematics, page 467
            val angle = acos(cosTheta)
            val s0 = sin((1.0 - interp) * angle)
            val s1 = sin(interp * angle)
            val s2 = sin(angle)
            res.w = (s0 * a.w + s1 * b.w) / s2
            res.x = (s0 * a.x + s1 * b.x) / s2
            res.y = (s0 * a.y + s1 * b.y) / s2
            res.z = (s0 * a.z + s1 * b.z) / s2
            return res
        }
    }

    fun slerp(a: QuatD, b: QuatD, interp: Double) = slerp(a, b, interp, QuatD())


    /** Returns the q conjugate.    */
    fun conjugate(a: Quat, res: Quat): Quat {
        res.w = a.w
        res.x = -a.x
        res.y = -a.y
        res.z = -a.z
        return res
    }

    fun conjugate(a: Quat) = conjugate(a, Quat())

    /** Returns the q conjugate.    */
    fun conjugate(a: QuatD, res: QuatD): QuatD {
        res.w = a.w
        res.x = -a.x
        res.y = -a.y
        res.z = -a.z
        return res
    }

    fun conjugate(a: QuatD) = conjugate(a, QuatD())


    /** Returns the q inverse.  */
    fun inverse(a: Quat, res: Quat): Quat {
        val dot = dot(a, a)
        res.w = a.w / dot
        res.x = -a.x / dot
        res.y = -a.y / dot
        res.z = -a.z / dot
        return res
    }

    fun inverse(a: Quat) = inverse(a, Quat())

    /** Returns the q inverse.  */
    fun inverse(a: QuatD, res: QuatD): QuatD {
        val dot = dot(a, a)
        res.w = a.w / dot
        res.x = -a.x / dot
        res.y = -a.y / dot
        res.z = -a.z / dot
        return res
    }

    fun inverse(a: QuatD) = inverse(a, QuatD())


    /** Rotates a quaternion from a vector of 3 components axis main.and an angle.   */
    fun rotate(q: Quat, angle: Float, vX: Float, vY: Float, vZ: Float, res: Quat): Quat {

        var tmpX = vX
        var tmpY = vY
        var tmpZ = vZ
        // Axis of rotation must be normalised
        val len = glm.sqrt(vX * vX + vY * vY + vZ * vZ)
        if (abs(len - 1f) > 0.001f) {
            val oneOverLen = 1f / len
            tmpX *= oneOverLen
            tmpY *= oneOverLen
            tmpZ *= oneOverLen
        }
        val sin = sin(angle * 0.5f)

        val pW = cos(angle * 0.5f)
        val pX = tmpX * sin
        val pY = tmpY * sin
        val pZ = tmpZ * sin

        val w = q.w * pW - q.x * pX - q.y * pY - q.z * pZ
        val x = q.w * pX + q.x * pW + q.y * pZ - q.z * pY
        val y = q.w * pY + q.y * pW + q.z * pX - q.x * pZ
        val z = q.w * pZ + q.z * pW + q.x * pY - q.y * pX

        res.w = w
        res.x = x
        res.y = y
        res.z = z

        return res
    }

    fun rotate(q: Quat, angle: Float, vX: Float, vY: Float, vZ: Float) = rotate(q, angle, vX, vY, vZ, Quat())
    fun rotate(q: Quat, angle: Float, v: Vec3, res: Quat) = rotate(q, angle, v.x, v.y, v.z, res)
    fun rotate(q: Quat, angle: Float, v: Vec3) = rotate(q, angle, v.x, v.y, v.z, Quat())

    /** Rotates a quaternion from a vector of 3 components axis main.and an angle.   */
    fun rotate(q: QuatD, angle: Double, vX: Double, vY: Double, vZ: Double, res: QuatD): QuatD {

        var tmpX = vX
        var tmpY = vY
        var tmpZ = vZ
        // Axis of rotation must be normalised
        val len = glm.sqrt(vX * vX + vY * vY + vZ * vZ)
        if (abs(len - 1f) > 0.001) {
            val oneOverLen = 1f / len
            tmpX *= oneOverLen
            tmpY *= oneOverLen
            tmpZ *= oneOverLen
        }
        val sin = sin(angle * 0.5f)

        val pW = cos(angle * 0.5f)
        val pX = tmpX * sin
        val pY = tmpY * sin
        val pZ = tmpZ * sin

        val w = q.w * pW - q.x * pX - q.y * pY - q.z * pZ
        val x = q.w * pX + q.x * pW + q.y * pZ - q.z * pY
        val y = q.w * pY + q.y * pW + q.z * pX - q.x * pZ
        val z = q.w * pZ + q.z * pW + q.x * pY - q.y * pX

        res.w = w
        res.x = x
        res.y = y
        res.z = z

        return res
    }

    fun rotate(q: QuatD, angle: Double, vX: Double, vY: Double, vZ: Double) = rotate(q, angle, vX, vY, vZ, QuatD())
    fun rotate(q: QuatD, angle: Double, v: Vec3d, res: QuatD) = rotate(q, angle, v.x, v.y, v.z, res)
    fun rotate(q: QuatD, angle: Double, v: Vec3d) = rotate(q, angle, v.x, v.y, v.z, QuatD())


    /** Returns euler angles, pitch as x, yaw as y, roll as z.
     * The result is expressed in radians.     */
    fun eulerAngles(a: Quat, res: Vec3): Vec3 {
        res.x = pitch(a)
        res.y = yaw(a)
        res.z = roll(a)
        return res
    }

    fun eulerAngles(a: Quat) = eulerAngles(a, Vec3())

    /** Returns euler angles, pitch as x, yaw as y, roll as z.
     * The result is expressed in radians.     */
    fun eulerAngles(a: QuatD, res: Vec3d): Vec3d {
        res.x = pitch(a)
        res.y = yaw(a)
        res.z = roll(a)
        return res
    }

    fun eulerAngles(a: QuatD) = eulerAngles(a, Vec3d())

    /** Returns roll value of euler angles expressed in radians.    */
    fun roll(q: Quat) = atan(2f * (q.x * q.y + q.w * q.z), q.w * q.w + q.x * q.x - q.y * q.y - q.z * q.z)

    /** Returns roll value of euler angles expressed in radians.    */
    fun roll(q: QuatD) = atan(2.0 * (q.x * q.y + q.w * q.z), q.w * q.w + q.x * q.x - q.y * q.y - q.z * q.z)


    /** Returns pitch value of euler angles expressed in radians.   */
    fun pitch(q: Quat) = atan(2f * (q.y * q.z + q.w * q.x), q.w * q.w - q.x * q.x - q.y * q.y + q.z * q.z)

    /** Returns pitch value of euler angles expressed in radians.   */
    fun pitch(q: QuatD) = atan(2.0 * (q.y * q.z + q.w * q.x), q.w * q.w - q.x * q.x - q.y * q.y + q.z * q.z)


    /** Returns yaw value of euler angles expressed in radians. */
    fun yaw(q: Quat) = asin(clamp(-2f * (q.x * q.z - q.w * q.y), -1f, 1f))

    /** Returns yaw value of euler angles expressed in radians. */
    fun yaw(q: QuatD) = asin(clamp(-2.0 * (q.x * q.z - q.w * q.y), -1.0, 1.0))


    /** Converts a quaternion to a 3 * 3 matrix.    */
    fun mat3_cast(q: Quat, res: Mat3): Mat3 {

        val qxx = q.x * q.x
        val qyy = q.y * q.y
        val qzz = q.z * q.z
        val qxz = q.x * q.z
        val qxy = q.x * q.y
        val qyz = q.y * q.z
        val qwx = q.w * q.x
        val qwy = q.w * q.y
        val qwz = q.w * q.z

        res[0][0] = 1f - 2f * (qyy + qzz)
        res[0][1] = 2f * (qxy + qwz)
        res[0][2] = 2f * (qxz - qwy)

        res[1][0] = 2f * (qxy - qwz)
        res[1][1] = 1f - 2f * (qxx + qzz)
        res[1][2] = 2f * (qyz + qwx)

        res[2][0] = 2f * (qxz + qwy)
        res[2][1] = 2f * (qyz - qwx)
        res[2][2] = 1f - 2f * (qxx + qyy)

        return res
    }

    fun mat3_cast(q: Quat) = mat3_cast(q, Mat3())

    /** Converts a quaternion to a 3 * 3 matrix.    */
    fun mat3d_cast(q: QuatD, m: Mat3): Mat3x3 {

        TODO()
//        val qxx = q.x * q.x
//        val qyy = q.y * q.y
//        val qzz = q.z * q.z
//        val qxz = q.x * q.z
//        val qxy = q.x * q.y
//        val qyz = q.y * q.z
//        val qwx = q.w * q.x
//        val qwy = q.w * q.y
//        val qwz = q.w * q.z
//
//        res[0][0] = 1f - 2f * (qyy + qzz)
//        res[0][1] = 2f * (qxy + qwz)
//        res[0][2] = 2f * (qxz - qwy)
//
//        res[1][0] = 2f * (qxy - qwz)
//        res[1][1] = 1f - 2f * (qxx + qzz)
//        res[1][2] = 2f * (qyz + qwx)
//
//        res[2][0] = 2f * (qxz + qwy)
//        res[2][1] = 2f * (qyz - qwx)
//        res[2][2] = 1f - 2f * (qxx + qyy)
//
//        return res
    }

    /** Converts a quaternion to a 4 * 4 matrix.    */
    fun mat4_cast(q: Quat, res: Mat4): Mat4 {

        val qxx = q.x * q.x
        val qyy = q.y * q.y
        val qzz = q.z * q.z
        val qxz = q.x * q.z
        val qxy = q.x * q.y
        val qyz = q.y * q.z
        val qwx = q.w * q.x
        val qwy = q.w * q.y
        val qwz = q.w * q.z

        res[0][0] = 1f - 2f * (qyy + qzz)
        res[0][1] = 2f * (qxy + qwz)
        res[0][2] = 2f * (qxz - qwy)

        res[1][0] = 2f * (qxy - qwz)
        res[1][1] = 1f - 2f * (qxx + qzz)
        res[1][2] = 2f * (qyz + qwx)

        res[2][0] = 2f * (qxz + qwy)
        res[2][1] = 2f * (qyz - qwx)
        res[2][2] = 1f - 2f * (qxx + qyy)

        return res
    }

    fun mat4_cast(q: Quat) = mat4_cast(q, Mat4())


    fun mat4d_cast(res: Mat4x4, q: QuatD): Mat4x4 = TODO()


    /** Converts a 3 * 3 matrix to a quaternion.    */
    fun quat_cast(m: Mat3, res: Quat) = quat_cast(m[0][0], m[0][1], m[0][2], m[1][0], m[1][1], m[1][2], m[2][0], m[2][1], m[2][2], res)

    fun quat_cast(m: Mat3) = quat_cast(m, Quat())

    /** Converts a 3 * 3 matrix to a quaternion.    */
    fun quatD_cast(res: QuatD = QuatD(), m: Mat3): Mat3 = TODO()

    /** Converts a 4 * 4 matrix to a quaternion.    */
    fun quat_cast(m: Mat4, res: Quat) = quat_cast(m[0][0], m[0][1], m[0][2], m[1][0], m[1][1], m[1][2], m[2][0], m[2][1], m[2][2], res)

    fun quat_cast(m: Mat4) = quat_cast(m, Quat())

    /** Converts a 4 * 4 matrix to a quaternion.    */
    fun quatD_cast(res: QuatD = QuatD(), m: Mat4): Mat4 = TODO()


    fun quat_cast(
            m00: Float, m01: Float, m02: Float,
            m10: Float, m11: Float, m12: Float,
            m20: Float, m21: Float, m22: Float,
            res: Quat): Quat {

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

    fun quat_cast(
            m00: Float, m01: Float, m02: Float,
            m10: Float, m11: Float, m12: Float,
            m20: Float, m21: Float, m22: Float) = quat_cast(m00, m01, m02, m10, m11, m12, m20, m21, m22, Quat())


    fun quat_cast(
            m00: Double, m01: Double, m02: Double,
            m10: Double, m11: Double, m12: Double,
            m20: Double, m21: Double, m22: Double,
            res: QuatD): QuatD {

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

        val biggestVal = sqrt(fourBiggestSquaredMinus1 + 1.0) * 0.5
        val mult = 0.25 / biggestVal

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

    fun quat_cast(
            m00: Double, m01: Double, m02: Double,
            m10: Double, m11: Double, m12: Double,
            m20: Double, m21: Double, m22: Double) = quat_cast(m00, m01, m02, m10, m11, m12, m20, m21, m22, QuatD())


    /** Returns the quaternion rotation angle.  */
    fun angle(q: Quat) = acos(q.w) * 2f

    /** Returns the quaternion rotation angle.  */
    fun angle(q: QuatD) = acos(q.w) * 2.0


    /** Returns the q rotation axis.    */
    fun axis(q: Quat, res: Vec3): Vec3 {

        val tmp1 = 1f - q.w * q.w
        if (tmp1 <= 0f) {
            res.x = 0f
            res.y = 0f
            res.z = 1f
            return res
        }
        val tmp2 = 1f / sqrt(tmp1)
        res.x = q.x * tmp2
        res.y = q.y * tmp2
        res.z = q.z * tmp2
        return res
    }

    fun axis(q: Quat) = axis(q, Vec3())

    /** Returns the q rotation axis.    */
    fun axis(q: QuatD, res: Vec3d): Vec3d {

        val tmp1 = 1.0 - q.w * q.w
        if (tmp1 <= 0.0) {
            res.x = 0.0
            res.y = 0.0
            res.z = 1.0
            return res
        }
        val tmp2 = 1.0 / sqrt(tmp1)
        res.x = q.x * tmp2
        res.y = q.y * tmp2
        res.z = q.z * tmp2
        return res
    }

    fun axis(q: QuatD) = axis(q, Vec3d())


    /** Build a quaternion from an angle main.and a normalized axis. */
    fun angleAxis(angle: Float, axisX: Float, axisY: Float, axisZ: Float, res: Quat): Quat {

        val a = angle * 0.5f
        val s = sin(a)

        res.w = cos(a)
        res.x = axisX * s
        res.y = axisY * s
        res.z = axisZ * s

        return res
    }
    fun angleAxis(angle: Float, axisX: Float, axisY: Float, axisZ: Float) = angleAxis(angle, axisX, axisY, axisZ, Quat())
    fun angleAxis(angle: Float, axis: Vec3, res: Quat) = angleAxis(angle, axis.x, axis.y, axis.z, res)
    fun angleAxis(angle: Float, axis: Vec3) = angleAxis(angle, axis.x, axis.y, axis.z, Quat())


    /** Build a quaternion from an angle main.and a normalized axis. */
    fun angleAxis(angle: Double, axisX: Double, axisY: Double, axisZ: Double, res: QuatD): QuatD {

        val a = angle * 0.5
        val s = sin(a)

        res.w = cos(a)
        res.x = axisX * s
        res.y = axisY * s
        res.z = axisZ * s

        return res
    }
    fun angleAxis(angle: Double, axisX: Double, axisY: Double, axisZ: Double) = angleAxis(angle, axisX, axisY, axisZ, QuatD())
    fun angleAxis(angle: Double, axis: Vec3d, res: QuatD) = angleAxis(angle, axis.x, axis.y, axis.z, res)
    fun angleAxis(angle: Double, axis: Vec3d) = angleAxis(angle, axis.x, axis.y, axis.z, QuatD())


    //TODO move res in front, default arg on classes
    /** Returns the component-wise comparison result of x < y.  */
    fun lessThan(a: Quat, b: Quat, res: Vec4bool): Vec4bool {
        res.x = a.x < b.x
        res.y = a.y < b.y
        res.z = a.z < b.z
        res.w = a.w < b.w
        return res
    }

    fun lessThan(a: Quat, b: Quat) = lessThan(a, b, Vec4bool())

    /** Returns the component-wise comparison result of x <= y.  */
    fun lessThanEqual(a: Quat, b: Quat, res: Vec4bool): Vec4bool {
        res.x = a.x <= b.x
        res.y = a.y <= b.y
        res.z = a.z <= b.z
        res.w = a.w <= b.w
        return res
    }

    fun lessThanEqual(a: Quat, b: Quat) = lessThanEqual(a, b, Vec4bool())

    /** Returns the component-wise comparison result of x > y.  */
    fun greater(a: Quat, b: Quat, res: Vec4bool): Vec4bool {
        res.x = a.x > b.x
        res.y = a.y > b.y
        res.z = a.z > b.z
        res.w = a.w > b.w
        return res
    }

    fun greater(a: Quat, b: Quat) = greater(a, b, Vec4bool())

    /** Returns the component-wise comparison result of x >= y.  */
    fun greaterThan(a: Quat, b: Quat, res: Vec4bool): Vec4bool {
        res.x = a.x >= b.x
        res.y = a.y >= b.y
        res.z = a.z >= b.z
        res.w = a.w >= b.w
        return res
    }

    fun greaterThan(a: Quat, b: Quat) = greaterThan(a, b, Vec4bool())


    /** Returns the component-wise comparison of result x == y. */
    fun equal(a: Quat, b: Quat, res: Vec4bool): Vec4bool {
        res.x = a.x == b.x
        res.y = a.y == b.y
        res.z = a.z == b.z
        res.w = a.w == b.w
        return res
    }

    fun equal(a: Quat, b: Quat) = equal(a, b, Vec4bool())


    /** Returns the component-wise comparison of result x != y. */
    fun notEqual(a: Quat, b: Quat, res: Vec4bool): Vec4bool {
        res.x = a.x != b.x
        res.y = a.y != b.y
        res.z = a.z != b.z
        res.w = a.w != b.w
        return res
    }

    fun notEqual(a: Quat, b: Quat) = notEqual(a, b, Vec4bool())


    /** Returns true if x holds a NaN (not a number).   */
    fun isNan(q: Quat, res: Vec4bool): Vec4bool {
        res.x = q.x.isNaN()
        res.y = q.y.isNaN()
        res.z = q.z.isNaN()
        res.w = q.w.isNaN()
        return res
    }

    fun isNan(q: Quat) = isNan(q, Vec4bool())


    /** Returns true if x holds a positive infinity main.or negative infinity.   */
    fun isInf(q: Quat, res: Vec4bool): Vec4bool {
        res.x = q.x.isInfinite()
        res.y = q.y.isInfinite()
        res.z = q.z.isInfinite()
        res.w = q.w.isInfinite()
        return res
    }

    fun isInf(q: Quat) = isInf(q, Vec4bool())
}