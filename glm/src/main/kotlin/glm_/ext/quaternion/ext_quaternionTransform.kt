package glm_.ext.quaternion

import glm_.glm
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

    fun rotate(q: QuatD, angle: Double, vX: Double, vY: Double, vZ: Double) =
            rotate(q, angle, vX, vY, vZ, QuatD())

    fun rotate(q: QuatD, angle: Double, v: Vec3d, res: QuatD) =
            rotate(q, angle, v.x, v.y, v.z, res)

    fun rotate(q: QuatD, angle: Double, v: Vec3d): QuatD =
            rotate(q, angle, v.x, v.y, v.z, QuatD())
}