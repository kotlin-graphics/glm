package glm_.gtc

import glm_.detail.GLM_COORDINATE_SYSTEM
import glm_.detail.GlmCoordinateSystem
import glm_.glm.sqrt
import glm_.mat3x3.Mat3
import glm_.mat3x3.Mat3d
import glm_.mat4x4.Mat4
import glm_.mat4x4.Mat4d
import glm_.quat.Quat
import glm_.quat.QuatD
import glm_.vec3.Vec3
import glm_.vec3.Vec3d
import glm_.vec4.Vec4bool

/**
 * Created by GBarbieri on 14.12.2016.
 */

interface gtc_Quaternion {


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

        res[0, 0] = 1f - 2f * (qyy + qzz)
        res[0, 1] = 2f * (qxy + qwz)
        res[0, 2] = 2f * (qxz - qwy)

        res[1, 0] = 2f * (qxy - qwz)
        res[1, 1] = 1f - 2f * (qxx + qzz)
        res[1, 2] = 2f * (qyz + qwx)

        res[2, 0] = 2f * (qxz + qwy)
        res[2, 1] = 2f * (qyz - qwx)
        res[2, 2] = 1f - 2f * (qxx + qyy)

        return res
    }

    fun mat3_cast(q: Quat) = mat3_cast(q, Mat3())

    /** Converts a quaternion to a 3 * 3 matrix.    */
    fun mat3d_cast(q: QuatD, m: Mat3): Mat3 {

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
//        res[0, 0] = 1f - 2f * (qyy + qzz)
//        res[0, 1] = 2f * (qxy + qwz)
//        res[0, 2] = 2f * (qxz - qwy)
//
//        res[1, 0] = 2f * (qxy - qwz)
//        res[1, 1] = 1f - 2f * (qxx + qzz)
//        res[1, 2] = 2f * (qyz + qwx)
//
//        res[2, 0] = 2f * (qxz + qwy)
//        res[2, 1] = 2f * (qyz - qwx)
//        res[2, 2] = 1f - 2f * (qxx + qyy)
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

        res[0, 0] = 1f - 2f * (qyy + qzz)
        res[0, 1] = 2f * (qxy + qwz)
        res[0, 2] = 2f * (qxz - qwy)

        res[1, 0] = 2f * (qxy - qwz)
        res[1, 1] = 1f - 2f * (qxx + qzz)
        res[1, 2] = 2f * (qyz + qwx)

        res[2, 0] = 2f * (qxz + qwy)
        res[2, 1] = 2f * (qyz - qwx)
        res[2, 2] = 1f - 2f * (qxx + qyy)

        return res
    }

    fun mat4_cast(q: Quat) = mat4_cast(q, Mat4())


    fun mat4d_cast(res: Mat4, q: QuatD): Mat4 = TODO()


    /** Converts a pure rotation 3 * 3 matrix to a quaternion.    */
    fun quat_cast(m: Mat3, res: Quat): Quat =
            quat_cast(m[0, 0], m[0, 1], m[0, 2], m[1, 0], m[1, 1], m[1, 2], m[2, 0], m[2, 1], m[2, 2], res)

    fun quatD_cast(m: Mat3d, res: QuatD): QuatD =
            quatD_cast(m[0, 0], m[0, 1], m[0, 2], m[1, 0], m[1, 1], m[1, 2], m[2, 0], m[2, 1], m[2, 2], res)

    fun quat_cast(m: Mat3): Quat =
            quat_cast(m, Quat())

    fun quatD_cast(m: Mat3d): QuatD =
            quatD_cast(m, QuatD())

    /** Converts a pure rotation 4 * 4 matrix to a quaternion.    */
    fun quat_cast(m: Mat4, res: Quat): Quat =
            quat_cast(m[0, 0], m[0, 1], m[0, 2], m[1, 0], m[1, 1], m[1, 2], m[2, 0], m[2, 1], m[2, 2], res)

    fun quatD_cast(m: Mat4d, res: QuatD): QuatD =
            quatD_cast(m[0, 0], m[0, 1], m[0, 2], m[1, 0], m[1, 1], m[1, 2], m[2, 0], m[2, 1], m[2, 2], res)

    fun quat_cast(m: Mat4): Quat =
            quat_cast(m, Quat())

    fun quatD_cast(m: Mat4d): QuatD =
            quatD_cast(m, QuatD())


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

        return when (biggestIndex) {
            0 -> res.put(biggestVal, (m12 - m21) * mult, (m20 - m02) * mult, (m01 - m10) * mult)
            1 -> res.put((m12 - m21) * mult, biggestVal, (m01 + m10) * mult, (m20 + m02) * mult)
            2 -> res.put((m20 - m02) * mult, (m01 + m10) * mult, biggestVal, (m12 + m21) * mult)
            3 -> res.put((m01 - m10) * mult, (m20 + m02) * mult, (m12 + m21) * mult, biggestVal)
            // Silence a -Wswitch-default warning in GCC. Should never actually get here. Assert is just for sanity.
            else -> {
                assert(false)
                res.put(1f, 0f, 0f, 0f)
            }
        }
    }

    fun quat_cast(
            m00: Float, m01: Float, m02: Float,
            m10: Float, m11: Float, m12: Float,
            m20: Float, m21: Float, m22: Float) = quat_cast(m00, m01, m02, m10, m11, m12, m20, m21, m22, Quat())


    fun quatD_cast(
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

    fun quatD_cast(
            m00: Double, m01: Double, m02: Double,
            m10: Double, m11: Double, m12: Double,
            m20: Double, m21: Double, m22: Double) = quatD_cast(m00, m01, m02, m10, m11, m12, m20, m21, m22, QuatD())


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


    /** Build a look at quaternion based on the default handedness.
     *  @param direction Desired forward direction. Needs to be normalized.
     *  @param up Up vector, how the camera is oriented. Typically (0, 1, 0). */
    fun quatLookAt(direction: Vec3, up: Vec3): Quat = when (GLM_COORDINATE_SYSTEM) {
        GlmCoordinateSystem.LEFT_HANDED -> quatLookAtLH(direction, up)
        else -> quatLookAtRH(direction, up)
    }

    /** Build a right-handed look at quaternion.
     *  @param direction Desired forward direction onto which the -z-axis gets mapped. Needs to be normalized.
     *  @param up Up vector, how the camera is oriented. Typically (0, 1, 0).   */
    fun quatLookAtRH(direction: Vec3, up: Vec3): Quat {
        val result = Mat3()

        result[2] = -direction
        result[0] = (up cross result[2]).normalizeAssign()
        result[1] = result[2] cross result[0]

        return result.toQuat()
    }

    /** Build a left-handed look at quaternion.
     *  @param direction Desired forward direction onto which the +z-axis gets mapped. Needs to be normalized.
     *  @param up Up vector, how the camera is oriented. Typically (0, 1, 0). */
    fun quatLookAtLH(direction: Vec3, up: Vec3): Quat {
        val result = Mat3()

        result[2] = direction
        result[0] = (up cross result[2]).normalizeAssign()
        result[1] = result[2] cross result[0]

        return result.toQuat()
    }

    // ------------------------------ QuatD ------------------------------

    /** Build a look at quaternion based on the default handedness.
     *  @param direction Desired forward direction. Needs to be normalized.
     *  @param up Up vector, how the camera is oriented. Typically (0, 1, 0). */
    fun quatLookAt(direction: Vec3d, up: Vec3d): QuatD = when (GLM_COORDINATE_SYSTEM) {
        GlmCoordinateSystem.LEFT_HANDED -> quatLookAtLH(direction, up)
        else -> quatLookAtRH(direction, up)
    }

    /** Build a right-handed look at quaternion.
     *  @param direction Desired forward direction onto which the -z-axis gets mapped. Needs to be normalized.
     *  @param up Up vector, how the camera is oriented. Typically (0, 1, 0).   */
    fun quatLookAtRH(direction: Vec3d, up: Vec3d): QuatD {
        val result = Mat3d()

        result[2] = -direction
        result[0] = (up cross result[2]).normalizeAssign()
        result[1] = result[2] cross result[0]

        return result.toQuatD()
    }

    /** Build a left-handed look at quaternion.
     *  @param direction Desired forward direction onto which the +z-axis gets mapped. Needs to be normalized.
     *  @param up Up vector, how the camera is oriented. Typically (0, 1, 0). */
    fun quatLookAtLH(direction: Vec3d, up: Vec3d): QuatD {
        val result = Mat3d()

        result[2] = direction
        result[0] = (up cross result[2]).normalizeAssign()
        result[1] = result[2] cross result[0]

        return result.toQuatD()
    }
}