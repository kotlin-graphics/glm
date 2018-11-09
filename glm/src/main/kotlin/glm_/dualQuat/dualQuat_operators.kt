package glm_.dualQuat

import glm_.dualQuat.DualQuat.Companion.times
import glm_.vec3.Vec3
import glm_.vec4.Vec4

/**
 * Created by GBarbieri on 13.12.2016.
 */

interface dualQuat_operators {

    fun plus(res: DualQuat, a: DualQuat, b: DualQuat): DualQuat {
        a.real.plus(b.real, res.real)
        a.dual.plus(b.dual, res.dual)
        return res
    }

//    fun minus(res: Quat, a: Quat, b: Quat): Quat {
//        res.w = a.w - b.w
//        res.x = a.x - b.x
//        res.y = a.y - b.y
//        res.z = a.z - b.z
//        return res
//    }

    fun times(res: DualQuat, a: DualQuat, b: DualQuat): DualQuat {
        a.real.times(b.real, res.real)
        a.real.times(b.dual, res.dual)
        val w = a.dual.w * b.real.w - a.dual.x * b.real.x - a.dual.y * b.real.y - a.dual.z * b.real.z
        val x = a.dual.w * b.real.x + a.dual.x * b.real.w + a.dual.y * b.real.z - a.dual.z * b.real.y
        val y = a.dual.w * b.real.y + a.dual.y * b.real.w + a.dual.z * b.real.x - a.dual.x * b.real.z
        val z = a.dual.w * b.real.z + a.dual.z * b.real.w + a.dual.x * b.real.y - a.dual.y * b.real.x
        res.dual.w += w
        res.dual.x += x
        res.dual.y += y
        res.dual.z += z
        return res
    }

    fun times(res: Vec3, q: DualQuat, v: Vec3): Vec3 {
        // t = cross(real_v3,v) + v * q.real.w + dual_v3)
        val t0 = q.real.y * v.z - v.y * q.real.z + v.x * q.real.w + q.dual.x
        val t1 = q.real.z * v.x - v.z * q.real.x + v.y * q.real.w + q.dual.y
        val t2 = q.real.x * v.y - v.x * q.real.y + v.z * q.real.w + q.dual.z
        // c = cross(real_v3, t + dual_v3 * q.real.w - real_v3 * q.dual.w)
        val c0 = q.real.y * t2 - t1 * q.real.z + q.dual.x * q.real.w - q.real.x * q.dual.w
        val c1 = q.real.z * t0 - t2 * q.real.x + q.dual.y * q.real.w - q.real.y * q.dual.w
        val c2 = q.real.x * t1 - t0 * q.real.y + q.dual.z * q.real.w - q.real.z * q.dual.w
        // c * 2f + v
        return res(
                c0 * 2f + v.x,
                c1 * 2f + v.y,
                c2 * 2f + v.z)
    }

    fun times(res: Vec3, v: Vec3, q: DualQuat): Vec3 {
        // inverse
        // conjugate
        val realW = q.real.w
        val realX = -q.real.x
        val realY = -q.real.y
        val realZ = -q.real.z
        // conjugate
        val dualW = q.dual.w
        val dualX = -q.dual.x
        val dualY = -q.dual.y
        val dualZ = -q.dual.z

        val dot = realX * dualX + realY * dualY + realZ * dualZ + realW * dualW
        val w = dualW + realW * (-2f * dot)
        val x = dualX + realX * (-2f * dot)
        val y = dualY + realY * (-2f * dot)
        val z = dualZ + realZ * (-2f * dot)
        //res(realW, realX, realY, realZ, w, x, y, z)

        //(cross(real_v3, cross(real_v3,v) + v * q.real.w + dual_v3) + dual_v3 * q.real.w - real_v3 * q.dual.w) * T(2) + v
        val t0 = realY * v.z - v.y * realZ + v.x * realW + x
        val t1 = realZ * v.x - v.z * realX + v.y * realW + y
        val t2 = realX * v.y - v.x * realY + v.z * realW + z
        val c0 = realY * t2 - t1 * realZ + x * realW - realX * w
        val c1 = realZ * t0 - t2 * realX + y * realW - realY * w
        val c2 = realX * t1 - t0 * realY + z * realW - realZ * w

        return res(
                c0 * 2f + v.x,
                c1 * 2f + v.y,
                c2 * 2f + v.z)
    }

    fun times(res: Vec4, q: DualQuat, v: Vec4): Vec4 {
        // t = cross(real_v3,v) + v * q.real.w + dual_v3)
        val t0 = q.real.y * v.z - v.y * q.real.z + v.x * q.real.w + q.dual.x
        val t1 = q.real.z * v.x - v.z * q.real.x + v.y * q.real.w + q.dual.y
        val t2 = q.real.x * v.y - v.x * q.real.y + v.z * q.real.w + q.dual.z
        // c = cross(real_v3, t + dual_v3 * q.real.w - real_v3 * q.dual.w)
        val c0 = q.real.y * t2 - t1 * q.real.z + q.dual.x * q.real.w - q.real.x * q.dual.w
        val c1 = q.real.z * t0 - t2 * q.real.x + q.dual.y * q.real.w - q.real.y * q.dual.w
        val c2 = q.real.x * t1 - t0 * q.real.y + q.dual.z * q.real.w - q.real.z * q.dual.w
        // c * 2f + v
        return res(
                c0 * 2f + v.x,
                c1 * 2f + v.y,
                c2 * 2f + v.z,
                v.w)
    }

    fun times(res: Vec4, v: Vec4, q: DualQuat): Vec4 {
        // inverse
        // conjugate
        val realW = q.real.w
        val realX = -q.real.x
        val realY = -q.real.y
        val realZ = -q.real.z
        // conjugate
        val dualW = q.dual.w
        val dualX = -q.dual.x
        val dualY = -q.dual.y
        val dualZ = -q.dual.z

        val dot = realX * dualX + realY * dualY + realZ * dualZ + realW * dualW
        val w = dualW + realW * (-2f * dot)
        val x = dualX + realX * (-2f * dot)
        val y = dualY + realY * (-2f * dot)
        val z = dualZ + realZ * (-2f * dot)
        //res(realW, realX, realY, realZ, w, x, y, z)

        //(cross(real_v3, cross(real_v3,v) + v * q.real.w + dual_v3) + dual_v3 * q.real.w - real_v3 * q.dual.w) * T(2) + v
        val t0 = realY * v.z - v.y * realZ + v.x * realW + x
        val t1 = realZ * v.x - v.z * realX + v.y * realW + y
        val t2 = realX * v.y - v.x * realY + v.z * realW + z
        val c0 = realY * t2 - t1 * realZ + x * realW - realX * w
        val c1 = realZ * t0 - t2 * realX + y * realW - realY * w
        val c2 = realX * t1 - t0 * realY + z * realW - realZ * w

        return res(
                c0 * 2f + v.x,
                c1 * 2f + v.y,
                c2 * 2f + v.z,
                v.w)
    }

    fun times(res: DualQuat, q: DualQuat, s: Float): DualQuat {
        q.real.times(s, res.real)
        q.dual.times(s, res.dual)
        return res
    }

    fun div(res: DualQuat, q: DualQuat, s: Float): DualQuat {
        q.real.div(s, res.real)
        q.dual.div(s, res.dual)
        return res
    }
}


infix operator fun Float.times(b: DualQuat) = times(DualQuat(), b, this)
infix operator fun Vec3.times(b: DualQuat) = times(Vec3(), this, b)
infix operator fun Vec4.times(b: DualQuat) = times(Vec4(), this, b)