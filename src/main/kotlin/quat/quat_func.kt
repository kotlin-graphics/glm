package quat

import main.Glm.abs
import main.Glm.acos
import main.Glm.asin
import main.Glm.atan
import main.Glm.clamp
import main.Glm.cos
import main.Glm.length
import main.Glm.mix
import main.Glm.sin
import main.Glm.sqrt
import main.epsilon
import main.f
import mat.Mat3
import mat.Mat3x3
import mat.Mat4
import mat.Mat4x4
import vec._3.Vec3
import vec.bool.Vec4bool

/**
 * Created by GBarbieri on 14.12.2016.
 */

interface quat_func {


    /** Returns the length of the quaternion.   */
    fun length(q: Quat) = sqrt(dot(q, q))


    /** Returns the normalized quaternion.  */
    fun normalize(res: Quat, q: Quat): Quat {
        val len = length(q)
        if (len <= 0f)   // Problem
            return res.put(1f, 0f, 0f, 0f)
        val oneOverLen = 1f / len
        return res.put(q.w * oneOverLen, q.x * oneOverLen, q.y * oneOverLen, q.z * oneOverLen)
    }

    /** Returns dot product of q1 main.and q2, main.getI.e., q1[0] * q2[0] + q1[1] * q2[1] + ... */
    fun dot(a: Quat, b: Quat) = a.x * b.x + a.y * b.y + a.z * b.z + a.w * b.w


    /** Spherical linear interpolation of two quaternions.
     * The interpolation is oriented main.and the rotation is performed at constant speed.
     * For short path spherical linear interpolation, use the slerp function.     */
    fun mix(res: Quat, a: Quat, b: Quat, interp: Float): Quat {

        val cosTheta = dot(a, b)

        // Perform a linear interpolation when cosTheta is close to 1 to avoid side effect of sin(angle) becoming a zero denominator
        if (cosTheta > 1f - epsilon(cosTheta, 1f)) {
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


    /** Linear interpolation of two quaternions.
     * The interpolation is oriented.     */
    fun lerp(res: Quat, a: Quat, b: Quat, interp: Float): Quat {
        // Lerp is only defined in [0, 1]
        if (interp < 0f || interp > 1f)
            throw ArithmeticException("interp outside [0, 1]")

        res.w = a.w * (1f - interp) + b.w * interp
        res.x = a.x * (1f - interp) + b.x * interp
        res.y = a.y * (1f - interp) + b.y * interp
        res.z = a.z * (1f - interp) + b.z * interp
        return res
    }


    /** Spherical linear interpolation of two quaternions.
     * The interpolation always take the short path main.and the rotation is performed at constant speed.     */
    fun slerp(res: Quat, a: Quat, b: Quat, interp: Float): Quat {

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
        if (cosTheta > 1f - epsilon(cosTheta, 1f)) {
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
            res.w = (s0 * a.w + s1 * b.w) / s2
            res.x = (s0 * a.x + s1 * b.x) / s2
            res.y = (s0 * a.y + s1 * b.y) / s2
            res.z = (s0 * a.z + s1 * b.z) / s2
            return res
        }
    }


    /** Returns the q conjugate.    */
    fun conjugate(res: Quat, a: Quat): Quat {
        res.w = a.w
        res.x = -a.x
        res.y = -a.y
        res.z = -a.z
        return res
    }

    /** Returns the q inverse.  */
    fun inverse(res: Quat, a: Quat): Quat {
        val dot = dot(a, a)
        res.w = a.w / dot
        res.x = -a.x / dot
        res.y = -a.y / dot
        res.z = -a.z / dot
        return res
    }


    /** Rotates a quaternion from a vector of 3 components axis main.and an angle.   */
    fun rotate(res: Quat, q: Quat, angle: Float, v: Vec3): Quat {

        var tmpX = v.x
        var tmpY = v.y
        var tmpZ = v.z
        // Axis of rotation must be normalised
        val len = length(v)
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

        res.w = (q.w * pW - q.x * pX - q.y * pY - q.z * pZ).f
        res.x = (q.w * pX + q.x * pW + q.y * pZ - q.z * pY).f
        res.y = (q.w * pY + q.y * pW + q.z * pX - q.x * pZ).f
        res.z = (q.w * pZ + q.z * pW + q.x * pY - q.y * pX).f

        return res
    }


    /** Returns euler angles, pitch as x, yaw as y, roll as z.
     * The result is expressed in radians.     */
    fun eulerAngles(res: Vec3, a: Quat): Vec3 {
        res.x = pitch(a)
        res.y = yaw(a)
        res.z = roll(a)
        return res
    }

    /** Returns roll value of euler angles expressed in radians.    */
    fun roll(q: Quat) = atan(2f * (q.x * q.y + q.w * q.z), q.w * q.w + q.x * q.x - q.y * q.y - q.z * q.z)

    /** Returns pitch value of euler angles expressed in radians.   */
    fun pitch(q: Quat) = atan(2f * (q.y * q.z + q.w * q.x), q.w * q.w - q.x * q.x - q.y * q.y + q.z * q.z)

    /** Returns yaw value of euler angles expressed in radians. */
    fun yaw(q: Quat) = asin(clamp(-2f * (q.x * q.z - q.w * q.y), -1f, 1f))


    /** Converts a quaternion to a 3 * 3 matrix.    */
    fun mat3_cast(res: Mat3x3, q: Quat): Mat3x3 {

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

    /** Converts a quaternion to a 4 * 4 matrix.    */
    fun mat4_cast(res: Mat4x4, q: Quat): Mat4x4 {

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


    /** Converts a 3 * 3 matrix to a quaternion.    */
    fun quat_cast(res: Quat = Quat(), m: Mat3) = quat_cast(res, m[0][0], m[0][1], m[0][2], m[1][0], m[1][1], m[1][2], m[2][0], m[2][1], m[2][2])

    /** Converts a 4 * 4 matrix to a quaternion.    */
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


    /** Returns the quaternion rotation angle.  */
    fun angle(q: Quat) = acos(q.w) * 2f

    /** Returns the q rotation axis.    */
    fun axis(q: Quat, res: Vec3): Vec3 {

        val tmp1 = 1f - q.w * q.w
        if (tmp1 <= 0f) {
            res.x = 0f
            res.y = 0f
            res.z = 1f
            return res
        }
        val tmp2 = 1 / sqrt(tmp1)
        res.x = q.x * tmp2
        res.y = q.y * tmp2
        res.z = q.z * tmp2
        return res
    }

    /** Build a quaternion from an angle main.and a normalized axis. */
    fun angleAxis(res: Quat, angle: Float, axis: Vec3): Quat {

        val a = angle * 0.5f
        val s = sin(a)

        res.w = cos(a)
        res.x = axis.x * s
        res.y = axis.y * s
        res.z = axis.z * s

        return res
    }


    //TODO move res in front, default arg on classes
    /** Returns the component-wise comparison result of x < y.  */
    fun lessThan(a: Quat, b: Quat, res: Vec4bool = Vec4bool()): Vec4bool {
        res.x = a.x < b.x
        res.y = a.y < b.y
        res.z = a.z < b.z
        res.w = a.w < b.w
        return res
    }

    /** Returns the component-wise comparison result of x <= y.  */
    fun lessThanEqual(a: Quat, b: Quat, res: Vec4bool = Vec4bool()): Vec4bool {
        res.x = a.x <= b.x
        res.y = a.y <= b.y
        res.z = a.z <= b.z
        res.w = a.w <= b.w
        return res
    }

    /** Returns the component-wise comparison result of x > y.  */
    fun greater(a: Quat, b: Quat, res: Vec4bool = Vec4bool()): Vec4bool {
        res.x = a.x > b.x
        res.y = a.y > b.y
        res.z = a.z > b.z
        res.w = a.w > b.w
        return res
    }

    /** Returns the component-wise comparison result of x >= y.  */
    fun greaterThan(a: Quat, b: Quat, res: Vec4bool = Vec4bool()): Vec4bool {
        res.x = a.x >= b.x
        res.y = a.y >= b.y
        res.z = a.z >= b.z
        res.w = a.w >= b.w
        return res
    }

    /** Returns the component-wise comparison of result x == y. */
    fun equal(a: Quat, b: Quat, res: Vec4bool = Vec4bool()): Vec4bool {
        res.x = a.x == b.x
        res.y = a.y == b.y
        res.z = a.z == b.z
        res.w = a.w == b.w
        return res
    }

    /** Returns the component-wise comparison of result x != y. */
    fun notEqual(a: Quat, b: Quat, res: Vec4bool = Vec4bool()): Vec4bool {
        res.x = a.x != b.x
        res.y = a.y != b.y
        res.z = a.z != b.z
        res.w = a.w != b.w
        return res
    }

    /** Returns true if x holds a NaN (not a number).   */
    fun isNan(q: Quat, res: Vec4bool = Vec4bool()): Vec4bool {
        res.x = q.x.isNaN()
        res.y = q.y.isNaN()
        res.z = q.z.isNaN()
        res.w = q.w.isNaN()
        return res
    }

    /** Returns true if x holds a positive infinity main.or negative infinity.   */
    fun isInf(q: Quat, res: Vec4bool = Vec4bool()): Vec4bool {
        res.x = q.x.isInfinite()
        res.y = q.y.isInfinite()
        res.z = q.z.isInfinite()
        res.w = q.w.isInfinite()
        return res
    }
}