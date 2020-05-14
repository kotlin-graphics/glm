package glm_.ext

import glm_.func.cos
import glm_.func.sin
import glm_.glm
import glm_.quat.Quat
import glm_.quat.QuatD
import glm_.vec3.Vec3
import glm_.vec3.Vec3d
import glm_.vec3.operators.times
import kotlin.math.*

interface ext_quaternionExponential {

    /** Returns a exp of a quaternion.
     *  @see gtx_quaternion */
    fun exp(q: Quat): Quat {

        val u = Vec3(q.x, q.y, q.z)
        val angle = u.length()
        if (angle < glm.εf)
            return Quat()

        val v = u / angle
        return Quat(angle.cos, angle.sin * v)
    }

    /** Returns a log of a quaternion.
     *  @see gtx_quaternion */
    fun log(q: Quat): Quat {

        val u = Vec3(q.x, q.y, q.z)
        val vec3Len = u.length()

        return when {
            vec3Len < glm.εf -> when {
                q.w > 0f -> Quat(glm.log(q.w), 0f, 0f, 0f)
                q.w < 0f -> Quat(glm.log(-q.w), glm.πf, 0f, 0f)
                else -> Quat(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY)
            }
            else -> {
                val t = glm.atan(vec3Len, q.w) / vec3Len
                val quatLen2 = vec3Len * vec3Len + q.w * q.w
                Quat(0.5f * glm.log(quatLen2), t * q.x, t * q.y, t * q.z)
            }
        }
    }

    /** Returns x raised to the y power.
     *  @see gtx_quaternion */
    fun pow(x: Quat, y: Float): Quat {
        // Raising to the power of 0 should yield 1
        // Needed to prevent a division by 0 error later on
        if (y > -glm.εf && y < glm.εf) return Quat(1f, 0f, 0f, 0f)

        // To deal with non-unit quaternions
        val magnitude = sqrt(x.x * x.x + x.y * x.y + x.z * x.z + x.w * x.w)

        // Equivalent to raising a real number to a power
        // Needed to prevent a division by 0 error later on
        if (abs(x.w / magnitude) > 1f - glm.εf && abs(x.w / magnitude) < 1 + glm.εf)
            return Quat(glm.pow(x.w, y), 0f, 0f, 0f)

        val angle = acos(x.w / magnitude)
        val newAngle = angle * y
        val div = sin(newAngle) / sin(angle)
        val mag = glm.pow(magnitude, y - 1)

        return Quat(cos(newAngle) * magnitude * mag, x.x * div * mag, x.y * div * mag, x.z * div * mag)
    }

    /** Returns quarternion square root.
     *  @see gtx_quaternion */
    fun sqrt(q: Quat): Quat =
            pow(q, 0.5f)

    // ------------------------------ QuatD ------------------------------

    /** Returns a exp of a quaternion.
     *  @see gtx_quaternion */
    fun exp(q: QuatD): QuatD {

        val u = Vec3d(q.x, q.y, q.z)
        val angle = u.length()
        if (angle < glm.ε)
            return QuatD()

        val v = u / angle
        return QuatD(angle.cos, angle.sin * v)
    }

    /** Returns a log of a quaternion.
     *  @see gtx_quaternion */
    fun log(q: QuatD): QuatD {

        val u = Vec3d(q.x, q.y, q.z)
        val vec3Len = u.length()

        return when {
            vec3Len < glm.ε -> when {
                q.w > 0.0 -> QuatD(glm.log(q.w), 0.0, 0.0, 0.0)
                q.w < 0.0 -> QuatD(glm.log(-q.w), glm.π, 0.0, 0.0)
                else -> QuatD(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY)
            }
            else -> {
                val t = glm.atan(vec3Len, q.w) / vec3Len
                val quatLen2 = vec3Len * vec3Len + q.w * q.w
                QuatD(0.5 * glm.log(quatLen2), t * q.x, t * q.y, t * q.z)
            }
        }
    }

    /** Returns x raised to the y power.
     *  @see gtx_quaternion */
    fun pow(x: QuatD, y: Double): QuatD {
        // Raising to the power of 0 should yield 1
        // Needed to prevent a division by 0 error later on
        if (y > -glm.ε && y < glm.ε) return QuatD(1.0, 0.0, 0.0, 0.0)

        // To deal with non-unit quaternions
        val magnitude = sqrt(x.x * x.x + x.y * x.y + x.z * x.z + x.w * x.w)

        // Equivalent to raising a real number to a power
        // Needed to prevent a division by 0 error later on
        if (abs(x.w / magnitude) > 1f - glm.ε && abs(x.w / magnitude) < 1 + glm.ε)
            return QuatD(glm.pow(x.w, y), 0.0, 0.0, 0.0)

        val angle = acos(x.w / magnitude)
        val newAngle = angle * y
        val div = sin(newAngle) / sin(angle)
        val mag = glm.pow(magnitude, y - 1)

        return QuatD(cos(newAngle) * magnitude * mag, x.x * div * mag, x.y * div * mag, x.z * div * mag)
    }

    /** Returns quarternion square root.
     *  @see gtx_quaternion */
    fun sqrt(q: QuatD): QuatD =
            pow(q, 0.5)
}