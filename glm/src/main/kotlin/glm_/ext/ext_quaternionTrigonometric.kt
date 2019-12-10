package glm_.ext

import glm_.ext.equal
import glm_.glm
import glm_.quat.Quat
import glm_.quat.QuatD
import glm_.vec3.Vec3
import glm_.vec3.Vec3d

interface ext_quaternionTrigonometric {

    /** Returns euler angles, pitch as x, yaw as y, roll as z.
     * The result is expressed in radians.     */
    fun eulerAngles(a: Quat, res: Vec3): Vec3 {
        res.x = pitch(a)
        res.y = yaw(a)
        res.z = roll(a)
        return res
    }

    infix fun eulerAngles(a: Quat): Vec3 =
            eulerAngles(a, Vec3())

    /** Returns euler angles, pitch as x, yaw as y, roll as z.
     * The result is expressed in radians.     */
    fun eulerAngles(a: QuatD, res: Vec3d): Vec3d {
        res.x = pitch(a)
        res.y = yaw(a)
        res.z = roll(a)
        return res
    }

    infix fun eulerAngles(a: QuatD): Vec3d =
            eulerAngles(a, Vec3d())

    /** Returns roll value of euler angles expressed in radians.    */
    infix fun roll(q: Quat): Float =
            glm.atan(2f * (q.x * q.y + q.w * q.z), q.w * q.w + q.x * q.x - q.y * q.y - q.z * q.z)

    /** Returns roll value of euler angles expressed in radians.    */
    infix fun roll(q: QuatD): Double =
            glm.atan(2.0 * (q.x * q.y + q.w * q.z), q.w * q.w + q.x * q.x - q.y * q.y - q.z * q.z)


    /** Returns pitch value of euler angles expressed in radians.   */
    infix fun pitch(q: Quat): Float {
        //atan(2f * (q.y * q.z + q.w * q.x), q.w * q.w - q.x * q.x - q.y * q.y + q.z * q.z)
        val y = 2f * (q.y * q.z + q.w * q.x)
        val x = q.w * q.w - q.x * q.x - q.y * q.y + q.z * q.z
        return when {
            //avoid atan2(0,0) - handle singularity - Matiis
            y.equal(0f) && x.equal(0f) -> 2f * glm.atan(q.x, q.w)
            else -> glm.atan(y, x)
        }
    }

    /** Returns pitch value of euler angles expressed in radians.   */
    infix fun pitch(q: QuatD): Double =
            glm.atan(2.0 * (q.y * q.z + q.w * q.x), q.w * q.w - q.x * q.x - q.y * q.y + q.z * q.z)


    /** Returns yaw value of euler angles expressed in radians. */
    infix fun yaw(q: Quat): Float =
            glm.asin(glm.clamp(-2f * (q.x * q.z - q.w * q.y), -1f, 1f))

    /** Returns yaw value of euler angles expressed in radians. */
    infix fun yaw(q: QuatD): Double =
            glm.asin(glm.clamp(-2.0 * (q.x * q.z - q.w * q.y), -1.0, 1.0))
}