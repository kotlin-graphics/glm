package glm_.ext

import glm_.glm
import glm_.quat.Quat
import glm_.quat.QuatD

interface extQuaternionGeometric {

    /** Returns the length of the quaternion.   */
    fun length(q: Quat): Float = glm.sqrt(dot(q, q))

    /** Returns the length of the quaternion.   */
    fun length(q: QuatD): Double = glm.sqrt(dot(q, q))


    /** Returns the normalized quaternion.  */
    fun normalize(q: Quat, res: Quat = Quat()): Quat {
        val len = length(q)
        if (len <= 0f)   // Problem
            return res.put(1f, 0f, 0f, 0f)
        val oneOverLen = 1f / len
        return res.put(q.w * oneOverLen, q.x * oneOverLen, q.y * oneOverLen, q.z * oneOverLen)
    }

    /** Returns the normalized quaternion.  */
    fun normalize(q: QuatD, res: QuatD = QuatD()): QuatD {
        val len = length(q)
        if (len <= 0.0)   // Problem
            return res.put(1.0, 0.0, 0.0, 0.0)
        val oneOverLen = 1.0 / len
        return res.put(q.w * oneOverLen, q.x * oneOverLen, q.y * oneOverLen, q.z * oneOverLen)
    }


    /** Returns dot product of q1 main.and q2, main.getI.e., q1[0] * q2[0] + q1[1] * q2[1] + ... */
    fun dot(a: Quat, b: Quat): Float = a.x * b.x + a.y * b.y + a.z * b.z + a.w * b.w

    /** Returns dot product of q1 main.and q2, main.getI.e., q1[0] * q2[0] + q1[1] * q2[1] + ... */
    fun dot(a: QuatD, b: QuatD): Double = a.x * b.x + a.y * b.y + a.z * b.z + a.w * b.w

    fun cross(q1: Quat, q2: Quat, res: Quat = Quat()): Quat {
        res.w = q1.w * q2.w - q1.x * q2.x - q1.y * q2.y - q1.z * q2.z
        res.x = q1.w * q2.x + q1.x * q2.w + q1.y * q2.z - q1.z * q2.y
        res.y = q1.w * q2.y + q1.y * q2.w + q1.z * q2.x - q1.x * q2.z
        res.z = q1.w * q2.z + q1.z * q2.w + q1.x * q2.y - q1.y * q2.x
        return res
    }

    fun cross(q1: QuatD, q2: QuatD, res: QuatD = QuatD()): QuatD {
        res.w = q1.w * q2.w - q1.x * q2.x - q1.y * q2.y - q1.z * q2.z
        res.x = q1.w * q2.x + q1.x * q2.w + q1.y * q2.z - q1.z * q2.y
        res.y = q1.w * q2.y + q1.y * q2.w + q1.z * q2.x - q1.x * q2.z
        res.z = q1.w * q2.z + q1.z * q2.w + q1.x * q2.y - q1.y * q2.x
        return res
    }
}