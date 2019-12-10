package glm_.ext

import glm_.detail.GLM_COORDINATE_SYSTEM
import glm_.detail.GlmCoordinateSystem
import glm_.glm
import glm_.mat3x3.Mat3
import glm_.mat3x3.Mat3d
import glm_.quat.Quat
import glm_.quat.QuatD
import glm_.vec3.Vec3
import glm_.vec3.Vec3d

interface ext_quaternionTransform {

    /** Rotates a quaternion from a vector of 3 components axis main.and an angle.   */
    fun rotate(q: Quat, angle: Float, vX: Float, vY: Float, vZ: Float, res: Quat): Quat {

        var tmpX = vX
        var tmpY = vY
        var tmpZ = vZ
        // Axis of rotation must be normalised
        val len = glm.sqrt(vX * vX + vY * vY + vZ * vZ)
        if (glm.abs(len - 1f) > 0.001f) {
            val oneOverLen = 1f / len
            tmpX *= oneOverLen
            tmpY *= oneOverLen
            tmpZ *= oneOverLen
        }
        val sin = glm.sin(angle * 0.5f)

        val pW = glm.cos(angle * 0.5f)
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

    fun rotate(q: Quat, angle: Float, vX: Float, vY: Float, vZ: Float): Quat =
            rotate(q, angle, vX, vY, vZ, Quat())

    fun rotate(q: Quat, angle: Float, v: Vec3, res: Quat): Quat =
            rotate(q, angle, v.x, v.y, v.z, res)

    fun rotate(q: Quat, angle: Float, v: Vec3): Quat =
            rotate(q, angle, v.x, v.y, v.z, Quat())

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

    /** Rotates a quaternion from a vector of 3 components axis main.and an angle.   */
    fun rotate(q: QuatD, angle: Double, vX: Double, vY: Double, vZ: Double, res: QuatD): QuatD {

        var tmpX = vX
        var tmpY = vY
        var tmpZ = vZ
        // Axis of rotation must be normalised
        val len = glm.sqrt(vX * vX + vY * vY + vZ * vZ)
        if (glm.abs(len - 1f) > 0.001) {
            val oneOverLen = 1f / len
            tmpX *= oneOverLen
            tmpY *= oneOverLen
            tmpZ *= oneOverLen
        }
        val sin = glm.sin(angle * 0.5f)

        val pW = glm.cos(angle * 0.5f)
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

    fun rotate(q: QuatD, angle: Double, vX: Double, vY: Double, vZ: Double): QuatD =
            rotate(q, angle, vX, vY, vZ, QuatD())

    fun rotate(q: QuatD, angle: Double, v: Vec3d, res: QuatD): QuatD =
            rotate(q, angle, v.x, v.y, v.z, res)

    fun rotate(q: QuatD, angle: Double, v: Vec3d): QuatD =
            rotate(q, angle, v.x, v.y, v.z, QuatD())

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