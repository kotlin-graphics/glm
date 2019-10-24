package glm_

import glm_.glm.abs
import glm_.glm.greaterThan
import glm_.glm.lessThan
import glm_.mat4x4.Mat4
import glm_.quat.Quat
import glm_.quat.QuatD
import glm_.vec1.Vec1
import glm_.vec1.Vec1bool
import glm_.vec1.Vec1d
import glm_.vec2.*
import glm_.vec3.*
import glm_.vec4.*
import glm_.glm.equal

/**
 * Created by GBarbieri on 11.11.2016.
 */


interface epsilon {


    fun equal(a: Vec1, b: Vec1, epsilon: Float, res: Vec1bool = Vec1bool()) = lessThan(abs(a - b), Vec1(epsilon), res)
    fun equal(a: Vec1, b: Vec1, epsilon: Vec1, res: Vec1bool = Vec1bool()) = lessThan(abs(a - b), epsilon)
// TODO
//    fun equal(a: Vec1b, b: Vec1b, epsilon: Byte, res: Vec1bool = Vec1bool()) = lessThan(abs(a - b), Vec1b(epsilon), res)
//    fun equal(a: Vec1b, b: Vec1b, epsilon: Int, res: Vec1bool = Vec1bool()) = lessThan(abs(a - b), Vec1b(epsilon), res)
//    fun equal(a: Vec1b, b: Vec1b, epsilon: Vec1b, res: Vec1bool = Vec1bool()) = lessThan(abs(a - b), epsilon)

    fun equal(a: Vec1d, b: Vec1d, epsilon: Double, res: Vec1bool = Vec1bool()) = lessThan(abs(a - b), Vec1d(epsilon), res)
    fun equal(a: Vec1d, b: Vec1d, epsilon: Vec1d, res: Vec1bool = Vec1bool()) = lessThan(abs(a - b), epsilon)

//    fun equal(a: Vec1i, b: Vec1i, epsilon: Int, res: Vec1bool = Vec1bool()) = lessThan(abs(a - b), Vec1i(epsilon), res)
//    fun equal(a: Vec1i, b: Vec1i, epsilon: Vec1i, res: Vec1bool = Vec1bool()) = lessThan(abs(a - b), epsilon)
//
//    fun equal(a: Vec1l, b: Vec1l, epsilon: Long, res: Vec1bool = Vec1bool()) = lessThan(abs(a - b), Vec1l(epsilon), res)
//    fun equal(a: Vec1l, b: Vec1l, epsilon: Vec1l, res: Vec1bool = Vec1bool()) = lessThan(abs(a - b), epsilon)
//
//    fun equal(a: Vec1s, b: Vec1s, epsilon: Short, res: Vec1bool = Vec1bool()) = lessThan(abs(a - b), Vec1s(epsilon), res)
//    fun equal(a: Vec1s, b: Vec1s, epsilon: Int, res: Vec1bool = Vec1bool()) = lessThan(abs(a - b), Vec1s(epsilon), res)
//    fun equal(a: Vec1s, b: Vec1s, epsilon: Vec1s, res: Vec1bool = Vec1bool()) = lessThan(abs(a - b), epsilon)


    fun equal(a: Vec2, b: Vec2, epsilon: Float, res: Vec2bool = Vec2bool()) = lessThan(abs(a - b), Vec2(epsilon), res)
    fun equal(a: Vec2, b: Vec2, epsilon: Vec2, res: Vec2bool = Vec2bool()) = lessThan(abs(a - b), epsilon)

    fun equal(a: Vec2b, b: Vec2b, epsilon: Byte, res: Vec2bool = Vec2bool()) = lessThan(abs(a - b), Vec2b(epsilon), res)
    fun equal(a: Vec2b, b: Vec2b, epsilon: Int, res: Vec2bool = Vec2bool()) = lessThan(abs(a - b), Vec2b(epsilon), res)
    fun equal(a: Vec2b, b: Vec2b, epsilon: Vec2b, res: Vec2bool = Vec2bool()) = lessThan(abs(a - b), epsilon)

    fun equal(a: Vec2d, b: Vec2d, epsilon: Double, res: Vec2bool = Vec2bool()) = lessThan(abs(a - b), Vec2d(epsilon), res)
    fun equal(a: Vec2d, b: Vec2d, epsilon: Vec2d, res: Vec2bool = Vec2bool()) = lessThan(abs(a - b), epsilon)

    fun equal(a: Vec2i, b: Vec2i, epsilon: Int, res: Vec2bool = Vec2bool()) = lessThan(abs(a - b), Vec2i(epsilon), res)
    fun equal(a: Vec2i, b: Vec2i, epsilon: Vec2i, res: Vec2bool = Vec2bool()) = lessThan(abs(a - b), epsilon)

    fun equal(a: Vec2l, b: Vec2l, epsilon: Long, res: Vec2bool = Vec2bool()) = lessThan(abs(a - b), Vec2l(epsilon), res)
    fun equal(a: Vec2l, b: Vec2l, epsilon: Vec2l, res: Vec2bool = Vec2bool()) = lessThan(abs(a - b), epsilon)

    fun equal(a: Vec2s, b: Vec2s, epsilon: Short, res: Vec2bool = Vec2bool()) = lessThan(abs(a - b), Vec2s(epsilon), res)
    fun equal(a: Vec2s, b: Vec2s, epsilon: Int, res: Vec2bool = Vec2bool()) = lessThan(abs(a - b), Vec2s(epsilon), res)
    fun equal(a: Vec2s, b: Vec2s, epsilon: Vec2s, res: Vec2bool = Vec2bool()) = lessThan(abs(a - b), epsilon)


    fun equal(a: Vec3, b: Vec3, epsilon: Float, res: Vec3bool = Vec3bool()) = lessThan(abs(a - b), Vec3(epsilon), res)
    fun equal(a: Vec3, b: Vec3, epsilon: Vec3, res: Vec3bool = Vec3bool()) = lessThan(abs(a - b), epsilon)

    fun equal(a: Vec3b, b: Vec3b, epsilon: Byte, res: Vec3bool = Vec3bool()) = lessThan(abs(a - b), Vec3b(epsilon), res)
    fun equal(a: Vec3b, b: Vec3b, epsilon: Int, res: Vec3bool = Vec3bool()) = lessThan(abs(a - b), Vec3b(epsilon), res)
    fun equal(a: Vec3b, b: Vec3b, epsilon: Vec3b, res: Vec3bool = Vec3bool()) = lessThan(abs(a - b), epsilon)

    fun equal(a: Vec3d, b: Vec3d, epsilon: Double, res: Vec3bool = Vec3bool()) = lessThan(abs(a - b), Vec3d(epsilon), res)
    fun equal(a: Vec3d, b: Vec3d, epsilon: Vec3d, res: Vec3bool = Vec3bool()) = lessThan(abs(a - b), epsilon)

    fun equal(a: Vec3i, b: Vec3i, epsilon: Int, res: Vec3bool = Vec3bool()) = lessThan(abs(a - b), Vec3i(epsilon), res)
    fun equal(a: Vec3i, b: Vec3i, epsilon: Vec3i, res: Vec3bool = Vec3bool()) = lessThan(abs(a - b), epsilon)

    fun equal(a: Vec3l, b: Vec3l, epsilon: Long, res: Vec3bool = Vec3bool()) = lessThan(abs(a - b), Vec3l(epsilon), res)
    fun equal(a: Vec3l, b: Vec3l, epsilon: Vec3l, res: Vec3bool = Vec3bool()) = lessThan(abs(a - b), epsilon)

    fun equal(a: Vec3s, b: Vec3s, epsilon: Short, res: Vec3bool = Vec3bool()) = lessThan(abs(a - b), Vec3s(epsilon), res)
    fun equal(a: Vec3s, b: Vec3s, epsilon: Int, res: Vec3bool = Vec3bool()) = lessThan(abs(a - b), Vec3s(epsilon), res)
    fun equal(a: Vec3s, b: Vec3s, epsilon: Vec3s, res: Vec3bool = Vec3bool()) = lessThan(abs(a - b), epsilon)


    fun equal(a: Vec4, b: Vec4, epsilon: Float, res: Vec4bool = Vec4bool()) = lessThan(abs(a - b), Vec4(epsilon), res)
    fun equal(a: Vec4, b: Vec4, epsilon: Vec4, res: Vec4bool = Vec4bool()) = lessThan(abs(a - b), epsilon)

    fun equal(a: Vec4b, b: Vec4b, epsilon: Byte, res: Vec4bool = Vec4bool()) = lessThan(abs(a - b), Vec4b(epsilon), res)
    fun equal(a: Vec4b, b: Vec4b, epsilon: Int, res: Vec4bool = Vec4bool()) = lessThan(abs(a - b), Vec4b(epsilon), res)
    fun equal(a: Vec4b, b: Vec4b, epsilon: Vec4b, res: Vec4bool = Vec4bool()) = lessThan(abs(a - b), epsilon)

    fun equal(a: Vec4d, b: Vec4d, epsilon: Double, res: Vec4bool = Vec4bool()) = lessThan(abs(a - b), Vec4d(epsilon), res)
    fun equal(a: Vec4d, b: Vec4d, epsilon: Vec4d, res: Vec4bool = Vec4bool()) = lessThan(abs(a - b), epsilon)

    fun equal(a: Vec4i, b: Vec4i, epsilon: Int, res: Vec4bool = Vec4bool()) = lessThan(abs(a - b), Vec4i(epsilon), res)
    fun equal(a: Vec4i, b: Vec4i, epsilon: Vec4i, res: Vec4bool = Vec4bool()) = lessThan(abs(a - b), epsilon)

    fun equal(a: Vec4l, b: Vec4l, epsilon: Long, res: Vec4bool = Vec4bool()) = lessThan(abs(a - b), Vec4l(epsilon), res)
    fun equal(a: Vec4l, b: Vec4l, epsilon: Vec4l, res: Vec4bool = Vec4bool()) = lessThan(abs(a - b), epsilon)

    fun equal(a: Vec4s, b: Vec4s, epsilon: Short, res: Vec4bool = Vec4bool()) = lessThan(abs(a - b), Vec4s(epsilon), res)
    fun equal(a: Vec4s, b: Vec4s, epsilon: Int, res: Vec4bool = Vec4bool()) = lessThan(abs(a - b), Vec4s(epsilon), res)
    fun equal(a: Vec4s, b: Vec4s, epsilon: Vec4s, res: Vec4bool = Vec4bool()) = lessThan(abs(a - b), epsilon)


    fun equal(a: Mat4, b: Mat4, epsilon: Float): Boolean {
        for (i in 0..15)
            if (!equal(a.array[i], b.array[i], epsilon))
                return false
        return true
    }


    fun notEqual(a: Vec1, b: Vec1, epsilon: Float, res: Vec1bool = Vec1bool()) = greaterThan(abs(a - b), Vec1(epsilon), res)
    fun notEqual(a: Vec1, b: Vec1, epsilon: Vec1, res: Vec1bool = Vec1bool()) = greaterThan(abs(a - b), epsilon)

//    fun notEqual(a: Vec1b, b: Vec1b, epsilon: Byte, res: Vec1bool = Vec1bool()) = greaterThan(abs(a - b), Vec1b(epsilon), res)
//    fun notEqual(a: Vec1b, b: Vec1b, epsilon: Int, res: Vec1bool = Vec1bool()) = greaterThan(abs(a - b), Vec1b(epsilon), res)
//    fun notEqual(a: Vec1b, b: Vec1b, epsilon: Vec1b, res: Vec1bool = Vec1bool()) = greaterThan(abs(a - b), epsilon)

    fun notEqual(a: Vec1d, b: Vec1d, epsilon: Double, res: Vec1bool = Vec1bool()) = greaterThan(abs(a - b), Vec1d(epsilon), res)
    fun notEqual(a: Vec1d, b: Vec1d, epsilon: Vec1d, res: Vec1bool = Vec1bool()) = greaterThan(abs(a - b), epsilon)

//    fun notEqual(a: Vec1i, b: Vec1i, epsilon: Int, res: Vec1bool = Vec1bool()) = greaterThan(abs(a - b), Vec1i(epsilon), res)
//    fun notEqual(a: Vec1i, b: Vec1i, epsilon: Vec1i, res: Vec1bool = Vec1bool()) = greaterThan(abs(a - b), epsilon)
//
//    fun notEqual(a: Vec1l, b: Vec1l, epsilon: Long, res: Vec1bool = Vec1bool()) = greaterThan(abs(a - b), Vec1l(epsilon), res)
//    fun notEqual(a: Vec1l, b: Vec1l, epsilon: Vec1l, res: Vec1bool = Vec1bool()) = greaterThan(abs(a - b), epsilon)
//
//    fun notEqual(a: Vec1s, b: Vec1s, epsilon: Short, res: Vec1bool = Vec1bool()) = greaterThan(abs(a - b), Vec1s(epsilon), res)
//    fun notEqual(a: Vec1s, b: Vec1s, epsilon: Int, res: Vec1bool = Vec1bool()) = greaterThan(abs(a - b), Vec1s(epsilon), res)
//    fun notEqual(a: Vec1s, b: Vec1s, epsilon: Vec1s, res: Vec1bool = Vec1bool()) = greaterThan(abs(a - b), epsilon)


    fun notEqual(a: Vec2, b: Vec2, epsilon: Float, res: Vec2bool = Vec2bool()) = greaterThan(abs(a - b), Vec2(epsilon), res)
    fun notEqual(a: Vec2, b: Vec2, epsilon: Vec2, res: Vec2bool = Vec2bool()) = greaterThan(abs(a - b), epsilon)

    fun notEqual(a: Vec2b, b: Vec2b, epsilon: Byte, res: Vec2bool = Vec2bool()) = greaterThan(abs(a - b), Vec2b(epsilon), res)
    fun notEqual(a: Vec2b, b: Vec2b, epsilon: Int, res: Vec2bool = Vec2bool()) = greaterThan(abs(a - b), Vec2b(epsilon), res)
    fun notEqual(a: Vec2b, b: Vec2b, epsilon: Vec2b, res: Vec2bool = Vec2bool()) = greaterThan(abs(a - b), epsilon)

    fun notEqual(a: Vec2d, b: Vec2d, epsilon: Double, res: Vec2bool = Vec2bool()) = greaterThan(abs(a - b), Vec2d(epsilon), res)
    fun notEqual(a: Vec2d, b: Vec2d, epsilon: Vec2d, res: Vec2bool = Vec2bool()) = greaterThan(abs(a - b), epsilon)

    fun notEqual(a: Vec2i, b: Vec2i, epsilon: Int, res: Vec2bool = Vec2bool()) = greaterThan(abs(a - b), Vec2i(epsilon), res)
    fun notEqual(a: Vec2i, b: Vec2i, epsilon: Vec2i, res: Vec2bool = Vec2bool()) = greaterThan(abs(a - b), epsilon)

    fun notEqual(a: Vec2l, b: Vec2l, epsilon: Long, res: Vec2bool = Vec2bool()) = greaterThan(abs(a - b), Vec2l(epsilon), res)
    fun notEqual(a: Vec2l, b: Vec2l, epsilon: Vec2l, res: Vec2bool = Vec2bool()) = greaterThan(abs(a - b), epsilon)

    fun notEqual(a: Vec2s, b: Vec2s, epsilon: Short, res: Vec2bool = Vec2bool()) = greaterThan(abs(a - b), Vec2s(epsilon), res)
    fun notEqual(a: Vec2s, b: Vec2s, epsilon: Int, res: Vec2bool = Vec2bool()) = greaterThan(abs(a - b), Vec2s(epsilon), res)
    fun notEqual(a: Vec2s, b: Vec2s, epsilon: Vec2s, res: Vec2bool = Vec2bool()) = greaterThan(abs(a - b), epsilon)


    fun notEqual(a: Vec3, b: Vec3, epsilon: Float, res: Vec3bool = Vec3bool()) = greaterThan(abs(a - b), Vec3(epsilon), res)
    fun notEqual(a: Vec3, b: Vec3, epsilon: Vec3, res: Vec3bool = Vec3bool()) = greaterThan(abs(a - b), epsilon)

    fun notEqual(a: Vec3b, b: Vec3b, epsilon: Byte, res: Vec3bool = Vec3bool()) = greaterThan(abs(a - b), Vec3b(epsilon), res)
    fun notEqual(a: Vec3b, b: Vec3b, epsilon: Int, res: Vec3bool = Vec3bool()) = greaterThan(abs(a - b), Vec3b(epsilon), res)
    fun notEqual(a: Vec3b, b: Vec3b, epsilon: Vec3b, res: Vec3bool = Vec3bool()) = greaterThan(abs(a - b), epsilon)

    fun notEqual(a: Vec3d, b: Vec3d, epsilon: Double, res: Vec3bool = Vec3bool()) = greaterThan(abs(a - b), Vec3d(epsilon), res)
    fun notEqual(a: Vec3d, b: Vec3d, epsilon: Vec3d, res: Vec3bool = Vec3bool()) = greaterThan(abs(a - b), epsilon)

    fun notEqual(a: Vec3i, b: Vec3i, epsilon: Int, res: Vec3bool = Vec3bool()) = greaterThan(abs(a - b), Vec3i(epsilon), res)
    fun notEqual(a: Vec3i, b: Vec3i, epsilon: Vec3i, res: Vec3bool = Vec3bool()) = greaterThan(abs(a - b), epsilon)

    fun notEqual(a: Vec3l, b: Vec3l, epsilon: Long, res: Vec3bool = Vec3bool()) = greaterThan(abs(a - b), Vec3l(epsilon), res)
    fun notEqual(a: Vec3l, b: Vec3l, epsilon: Vec3l, res: Vec3bool = Vec3bool()) = greaterThan(abs(a - b), epsilon)

    fun notEqual(a: Vec3s, b: Vec3s, epsilon: Short, res: Vec3bool = Vec3bool()) = greaterThan(abs(a - b), Vec3s(epsilon), res)
    fun notEqual(a: Vec3s, b: Vec3s, epsilon: Int, res: Vec3bool = Vec3bool()) = greaterThan(abs(a - b), Vec3s(epsilon), res)
    fun notEqual(a: Vec3s, b: Vec3s, epsilon: Vec3s, res: Vec3bool = Vec3bool()) = greaterThan(abs(a - b), epsilon)


    fun notEqual(a: Vec4, b: Vec4, epsilon: Float, res: Vec4bool = Vec4bool()) = greaterThan(abs(a - b), Vec4(epsilon), res)
    fun notEqual(a: Vec4, b: Vec4, epsilon: Vec4, res: Vec4bool = Vec4bool()) = greaterThan(abs(a - b), epsilon)

    fun notEqual(a: Vec4b, b: Vec4b, epsilon: Byte, res: Vec4bool = Vec4bool()) = greaterThan(abs(a - b), Vec4b(epsilon), res)
    fun notEqual(a: Vec4b, b: Vec4b, epsilon: Int, res: Vec4bool = Vec4bool()) = greaterThan(abs(a - b), Vec4b(epsilon), res)
    fun notEqual(a: Vec4b, b: Vec4b, epsilon: Vec4b, res: Vec4bool = Vec4bool()) = greaterThan(abs(a - b), epsilon)

    fun notEqual(a: Vec4d, b: Vec4d, epsilon: Double, res: Vec4bool = Vec4bool()) = greaterThan(abs(a - b), Vec4d(epsilon), res)
    fun notEqual(a: Vec4d, b: Vec4d, epsilon: Vec4d, res: Vec4bool = Vec4bool()) = greaterThan(abs(a - b), epsilon)

    fun notEqual(a: Vec4i, b: Vec4i, epsilon: Int, res: Vec4bool = Vec4bool()) = greaterThan(abs(a - b), Vec4i(epsilon), res)
    fun notEqual(a: Vec4i, b: Vec4i, epsilon: Vec4i, res: Vec4bool = Vec4bool()) = greaterThan(abs(a - b), epsilon)

    fun notEqual(a: Vec4l, b: Vec4l, epsilon: Long, res: Vec4bool = Vec4bool()) = greaterThan(abs(a - b), Vec4l(epsilon), res)
    fun notEqual(a: Vec4l, b: Vec4l, epsilon: Vec4l, res: Vec4bool = Vec4bool()) = greaterThan(abs(a - b), epsilon)

    fun notEqual(a: Vec4s, b: Vec4s, epsilon: Short, res: Vec4bool = Vec4bool()) = greaterThan(abs(a - b), Vec4s(epsilon), res)
    fun notEqual(a: Vec4s, b: Vec4s, epsilon: Int, res: Vec4bool = Vec4bool()) = greaterThan(abs(a - b), Vec4s(epsilon), res)
    fun notEqual(a: Vec4s, b: Vec4s, epsilon: Vec4s, res: Vec4bool = Vec4bool()) = greaterThan(abs(a - b), epsilon)

    fun equal(a: Quat, b: Quat, epsilon: Float, res: Vec4bool = Vec4bool()): Vec4bool {
        res.x = abs(a.x - b.x) < epsilon
        res.y = abs(a.y - b.y) < epsilon
        res.z = abs(a.z - b.z) < epsilon
        res.w = abs(a.w - b.w) < epsilon
        return res
    }

    fun equal(a: QuatD, b: QuatD, epsilon: Double, res: Vec4bool = Vec4bool()): Vec4bool {
        res.x = abs(a.x - b.x) < epsilon
        res.y = abs(a.y - b.y) < epsilon
        res.z = abs(a.z - b.z) < epsilon
        res.w = abs(a.w - b.w) < epsilon
        return res
    }

    fun notEqual(a: Quat, b: Quat, epsilon: Float, res: Vec4bool = Vec4bool()): Vec4bool {
        res.x = abs(a.x - b.x) >= epsilon
        res.y = abs(a.y - b.y) >= epsilon
        res.z = abs(a.z - b.z) >= epsilon
        res.w = abs(a.w - b.w) >= epsilon
        return res
    }

    fun notEqual(a: QuatD, b: QuatD, epsilon: Double, res: Vec4bool = Vec4bool()): Vec4bool {
        res.x = abs(a.x - b.x) >= epsilon
        res.y = abs(a.y - b.y) >= epsilon
        res.z = abs(a.z - b.z) >= epsilon
        res.w = abs(a.w - b.w) >= epsilon
        return res
    }
}