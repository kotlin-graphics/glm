package glm

import glm.Glm.abs
import glm.Glm.greaterThan
import glm.Glm.lessThan
import glm.quat.Quat
import glm.quat.QuatD
import glm.vec._2.*
import glm.vec._3.*
import glm.vec._4.*
import glm.vec.bool.Vec2bool
import glm.vec.bool.Vec3bool
import glm.vec.bool.Vec4bool

/**
 * Created by GBarbieri on 11.11.2016.
 */


interface epsilon {

    fun epsilonEqual(x: Float, y: Float, epsilon: Float) = Math.abs(x - y) < epsilon
    fun epsilonEqual(x: Byte, y: Byte, epsilon: Byte) = Math.abs(x - y) < epsilon
    fun epsilonEqual(x: Double, y: Double, epsilon: Double) = Math.abs(x - y) < epsilon
    fun epsilonEqual(x: Int, y: Int, epsilon: Int) = Math.abs(x - y) < epsilon
    fun epsilonEqual(x: Long, y: Long, epsilon: Long) = Math.abs(x - y) < epsilon
    fun epsilonEqual(x: Short, y: Short, epsilon: Short) = Math.abs(x - y) < epsilon

    fun epsilonNotEqual(x: Float, y: Float, epsilon: Float) = Math.abs(x - y) >= epsilon
    fun epsilonNotEqual(x: Byte, y: Byte, epsilon: Byte) = Math.abs(x - y) >= epsilon
    fun epsilonNotEqual(x: Double, y: Double, epsilon: Double) = Math.abs(x - y) >= epsilon
    fun epsilonNotEqual(x: Int, y: Int, epsilon: Int) = Math.abs(x - y) >= epsilon
    fun epsilonNotEqual(x: Long, y: Long, epsilon: Long) = Math.abs(x - y) >= epsilon
    fun epsilonNotEqual(x: Short, y: Short, epsilon: Short) = Math.abs(x - y) >= epsilon


    fun epsilonEqual(a: Vec2, b: Vec2, epsilon: Float, res: Vec2bool = Vec2bool()) = lessThan(abs(a - b), Vec2(epsilon), res)
    fun epsilonEqual(a: Vec2, b: Vec2, epsilon: Vec2, res: Vec2bool = Vec2bool()) = lessThan(abs(a - b), epsilon)

    fun epsilonEqual(a: Vec2b, b: Vec2b, epsilon: Byte, res: Vec2bool = Vec2bool()) = lessThan(abs(a - b), Vec2b(epsilon), res)
    fun epsilonEqual(a: Vec2b, b: Vec2b, epsilon: Int, res: Vec2bool = Vec2bool()) = lessThan(abs(a - b), Vec2b(epsilon), res)
    fun epsilonEqual(a: Vec2b, b: Vec2b, epsilon: Vec2b, res: Vec2bool = Vec2bool()) = lessThan(abs(a - b), epsilon)

    fun epsilonEqual(a: Vec2d, b: Vec2d, epsilon: Double, res: Vec2bool = Vec2bool()) = lessThan(abs(a - b), Vec2d(epsilon), res)
    fun epsilonEqual(a: Vec2d, b: Vec2d, epsilon: Vec2d, res: Vec2bool = Vec2bool()) = lessThan(abs(a - b), epsilon)

    fun epsilonEqual(a: Vec2i, b: Vec2i, epsilon: Int, res: Vec2bool = Vec2bool()) = lessThan(abs(a - b), Vec2i(epsilon), res)
    fun epsilonEqual(a: Vec2i, b: Vec2i, epsilon: Vec2i, res: Vec2bool = Vec2bool()) = lessThan(abs(a - b), epsilon)

    fun epsilonEqual(a: Vec2l, b: Vec2l, epsilon: Long, res: Vec2bool = Vec2bool()) = lessThan(abs(a - b), Vec2l(epsilon), res)
    fun epsilonEqual(a: Vec2l, b: Vec2l, epsilon: Vec2l, res: Vec2bool = Vec2bool()) = lessThan(abs(a - b), epsilon)

    fun epsilonEqual(a: Vec2s, b: Vec2s, epsilon: Short, res: Vec2bool = Vec2bool()) = lessThan(abs(a - b), Vec2s(epsilon), res)
    fun epsilonEqual(a: Vec2s, b: Vec2s, epsilon: Int, res: Vec2bool = Vec2bool()) = lessThan(abs(a - b), Vec2s(epsilon), res)
    fun epsilonEqual(a: Vec2s, b: Vec2s, epsilon: Vec2s, res: Vec2bool = Vec2bool()) = lessThan(abs(a - b), epsilon)


    fun epsilonEqual(a: Vec3, b: Vec3, epsilon: Float, res: Vec3bool = Vec3bool()) = lessThan(abs(a - b), Vec3(epsilon), res)
    fun epsilonEqual(a: Vec3, b: Vec3, epsilon: Vec3, res: Vec3bool = Vec3bool()) = lessThan(abs(a - b), epsilon)

    fun epsilonEqual(a: Vec3b, b: Vec3b, epsilon: Byte, res: Vec3bool = Vec3bool()) = lessThan(abs(a - b), Vec3b(epsilon), res)
    fun epsilonEqual(a: Vec3b, b: Vec3b, epsilon: Int, res: Vec3bool = Vec3bool()) = lessThan(abs(a - b), Vec3b(epsilon), res)
    fun epsilonEqual(a: Vec3b, b: Vec3b, epsilon: Vec3b, res: Vec3bool = Vec3bool()) = lessThan(abs(a - b), epsilon)

    fun epsilonEqual(a: Vec3d, b: Vec3d, epsilon: Double, res: Vec3bool = Vec3bool()) = lessThan(abs(a - b), Vec3d(epsilon), res)
    fun epsilonEqual(a: Vec3d, b: Vec3d, epsilon: Vec3d, res: Vec3bool = Vec3bool()) = lessThan(abs(a - b), epsilon)

    fun epsilonEqual(a: Vec3i, b: Vec3i, epsilon: Int, res: Vec3bool = Vec3bool()) = lessThan(abs(a - b), Vec3i(epsilon), res)
    fun epsilonEqual(a: Vec3i, b: Vec3i, epsilon: Vec3i, res: Vec3bool = Vec3bool()) = lessThan(abs(a - b), epsilon)

    fun epsilonEqual(a: Vec3l, b: Vec3l, epsilon: Long, res: Vec3bool = Vec3bool()) = lessThan(abs(a - b), Vec3l(epsilon), res)
    fun epsilonEqual(a: Vec3l, b: Vec3l, epsilon: Vec3l, res: Vec3bool = Vec3bool()) = lessThan(abs(a - b), epsilon)

    fun epsilonEqual(a: Vec3s, b: Vec3s, epsilon: Short, res: Vec3bool = Vec3bool()) = lessThan(abs(a - b), Vec3s(epsilon), res)
    fun epsilonEqual(a: Vec3s, b: Vec3s, epsilon: Int, res: Vec3bool = Vec3bool()) = lessThan(abs(a - b), Vec3s(epsilon), res)
    fun epsilonEqual(a: Vec3s, b: Vec3s, epsilon: Vec3s, res: Vec3bool = Vec3bool()) = lessThan(abs(a - b), epsilon)


    fun epsilonEqual(a: Vec4, b: Vec4, epsilon: Float, res: Vec4bool = Vec4bool()) = lessThan(abs(a - b), Vec4(epsilon), res)
    fun epsilonEqual(a: Vec4, b: Vec4, epsilon: Vec4, res: Vec4bool = Vec4bool()) = lessThan(abs(a - b), epsilon)

    fun epsilonEqual(a: Vec4b, b: Vec4b, epsilon: Byte, res: Vec4bool = Vec4bool()) = lessThan(abs(a - b), Vec4b(epsilon), res)
    fun epsilonEqual(a: Vec4b, b: Vec4b, epsilon: Int, res: Vec4bool = Vec4bool()) = lessThan(abs(a - b), Vec4b(epsilon), res)
    fun epsilonEqual(a: Vec4b, b: Vec4b, epsilon: Vec4b, res: Vec4bool = Vec4bool()) = lessThan(abs(a - b), epsilon)

    fun epsilonEqual(a: Vec4d, b: Vec4d, epsilon: Double, res: Vec4bool = Vec4bool()) = lessThan(abs(a - b), Vec4d(epsilon), res)
    fun epsilonEqual(a: Vec4d, b: Vec4d, epsilon: Vec4d, res: Vec4bool = Vec4bool()) = lessThan(abs(a - b), epsilon)

    fun epsilonEqual(a: Vec4i, b: Vec4i, epsilon: Int, res: Vec4bool = Vec4bool()) = lessThan(abs(a - b), Vec4i(epsilon), res)
    fun epsilonEqual(a: Vec4i, b: Vec4i, epsilon: Vec4i, res: Vec4bool = Vec4bool()) = lessThan(abs(a - b), epsilon)

    fun epsilonEqual(a: Vec4l, b: Vec4l, epsilon: Long, res: Vec4bool = Vec4bool()) = lessThan(abs(a - b), Vec4l(epsilon), res)
    fun epsilonEqual(a: Vec4l, b: Vec4l, epsilon: Vec4l, res: Vec4bool = Vec4bool()) = lessThan(abs(a - b), epsilon)

    fun epsilonEqual(a: Vec4s, b: Vec4s, epsilon: Short, res: Vec4bool = Vec4bool()) = lessThan(abs(a - b), Vec4s(epsilon), res)
    fun epsilonEqual(a: Vec4s, b: Vec4s, epsilon: Int, res: Vec4bool = Vec4bool()) = lessThan(abs(a - b), Vec4s(epsilon), res)
    fun epsilonEqual(a: Vec4s, b: Vec4s, epsilon: Vec4s, res: Vec4bool = Vec4bool()) = lessThan(abs(a - b), epsilon)


    fun epsilonNotEqual(a: Vec2, b: Vec2, epsilon: Float, res: Vec2bool = Vec2bool()) = greaterThan(abs(a - b), Vec2(epsilon), res)
    fun epsilonNotEqual(a: Vec2, b: Vec2, epsilon: Vec2, res: Vec2bool = Vec2bool()) = greaterThan(abs(a - b), epsilon)

    fun epsilonNotEqual(a: Vec2b, b: Vec2b, epsilon: Byte, res: Vec2bool = Vec2bool()) = greaterThan(abs(a - b), Vec2b(epsilon), res)
    fun epsilonNotEqual(a: Vec2b, b: Vec2b, epsilon: Int, res: Vec2bool = Vec2bool()) = greaterThan(abs(a - b), Vec2b(epsilon), res)
    fun epsilonNotEqual(a: Vec2b, b: Vec2b, epsilon: Vec2b, res: Vec2bool = Vec2bool()) = greaterThan(abs(a - b), epsilon)

    fun epsilonNotEqual(a: Vec2d, b: Vec2d, epsilon: Double, res: Vec2bool = Vec2bool()) = greaterThan(abs(a - b), Vec2d(epsilon), res)
    fun epsilonNotEqual(a: Vec2d, b: Vec2d, epsilon: Vec2d, res: Vec2bool = Vec2bool()) = greaterThan(abs(a - b), epsilon)

    fun epsilonNotEqual(a: Vec2i, b: Vec2i, epsilon: Int, res: Vec2bool = Vec2bool()) = greaterThan(abs(a - b), Vec2i(epsilon), res)
    fun epsilonNotEqual(a: Vec2i, b: Vec2i, epsilon: Vec2i, res: Vec2bool = Vec2bool()) = greaterThan(abs(a - b), epsilon)

    fun epsilonNotEqual(a: Vec2l, b: Vec2l, epsilon: Long, res: Vec2bool = Vec2bool()) = greaterThan(abs(a - b), Vec2l(epsilon), res)
    fun epsilonNotEqual(a: Vec2l, b: Vec2l, epsilon: Vec2l, res: Vec2bool = Vec2bool()) = greaterThan(abs(a - b), epsilon)

    fun epsilonNotEqual(a: Vec2s, b: Vec2s, epsilon: Short, res: Vec2bool = Vec2bool()) = greaterThan(abs(a - b), Vec2s(epsilon), res)
    fun epsilonNotEqual(a: Vec2s, b: Vec2s, epsilon: Int, res: Vec2bool = Vec2bool()) = greaterThan(abs(a - b), Vec2s(epsilon), res)
    fun epsilonNotEqual(a: Vec2s, b: Vec2s, epsilon: Vec2s, res: Vec2bool = Vec2bool()) = greaterThan(abs(a - b), epsilon)


    fun epsilonNotEqual(a: Vec3, b: Vec3, epsilon: Float, res: Vec3bool = Vec3bool()) = greaterThan(abs(a - b), Vec3(epsilon), res)
    fun epsilonNotEqual(a: Vec3, b: Vec3, epsilon: Vec3, res: Vec3bool = Vec3bool()) = greaterThan(abs(a - b), epsilon)

    fun epsilonNotEqual(a: Vec3b, b: Vec3b, epsilon: Byte, res: Vec3bool = Vec3bool()) = greaterThan(abs(a - b), Vec3b(epsilon), res)
    fun epsilonNotEqual(a: Vec3b, b: Vec3b, epsilon: Int, res: Vec3bool = Vec3bool()) = greaterThan(abs(a - b), Vec3b(epsilon), res)
    fun epsilonNotEqual(a: Vec3b, b: Vec3b, epsilon: Vec3b, res: Vec3bool = Vec3bool()) = greaterThan(abs(a - b), epsilon)

    fun epsilonNotEqual(a: Vec3d, b: Vec3d, epsilon: Double, res: Vec3bool = Vec3bool()) = greaterThan(abs(a - b), Vec3d(epsilon), res)
    fun epsilonNotEqual(a: Vec3d, b: Vec3d, epsilon: Vec3d, res: Vec3bool = Vec3bool()) = greaterThan(abs(a - b), epsilon)

    fun epsilonNotEqual(a: Vec3i, b: Vec3i, epsilon: Int, res: Vec3bool = Vec3bool()) = greaterThan(abs(a - b), Vec3i(epsilon), res)
    fun epsilonNotEqual(a: Vec3i, b: Vec3i, epsilon: Vec3i, res: Vec3bool = Vec3bool()) = greaterThan(abs(a - b), epsilon)

    fun epsilonNotEqual(a: Vec3l, b: Vec3l, epsilon: Long, res: Vec3bool = Vec3bool()) = greaterThan(abs(a - b), Vec3l(epsilon), res)
    fun epsilonNotEqual(a: Vec3l, b: Vec3l, epsilon: Vec3l, res: Vec3bool = Vec3bool()) = greaterThan(abs(a - b), epsilon)

    fun epsilonNotEqual(a: Vec3s, b: Vec3s, epsilon: Short, res: Vec3bool = Vec3bool()) = greaterThan(abs(a - b), Vec3s(epsilon), res)
    fun epsilonNotEqual(a: Vec3s, b: Vec3s, epsilon: Int, res: Vec3bool = Vec3bool()) = greaterThan(abs(a - b), Vec3s(epsilon), res)
    fun epsilonNotEqual(a: Vec3s, b: Vec3s, epsilon: Vec3s, res: Vec3bool = Vec3bool()) = greaterThan(abs(a - b), epsilon)


    fun epsilonNotEqual(a: Vec4, b: Vec4, epsilon: Float, res: Vec4bool = Vec4bool()) = greaterThan(abs(a - b), Vec4(epsilon), res)
    fun epsilonNotEqual(a: Vec4, b: Vec4, epsilon: Vec4, res: Vec4bool = Vec4bool()) = greaterThan(abs(a - b), epsilon)

    fun epsilonNotEqual(a: Vec4b, b: Vec4b, epsilon: Byte, res: Vec4bool = Vec4bool()) = greaterThan(abs(a - b), Vec4b(epsilon), res)
    fun epsilonNotEqual(a: Vec4b, b: Vec4b, epsilon: Int, res: Vec4bool = Vec4bool()) = greaterThan(abs(a - b), Vec4b(epsilon), res)
    fun epsilonNotEqual(a: Vec4b, b: Vec4b, epsilon: Vec4b, res: Vec4bool = Vec4bool()) = greaterThan(abs(a - b), epsilon)

    fun epsilonNotEqual(a: Vec4d, b: Vec4d, epsilon: Double, res: Vec4bool = Vec4bool()) = greaterThan(abs(a - b), Vec4d(epsilon), res)
    fun epsilonNotEqual(a: Vec4d, b: Vec4d, epsilon: Vec4d, res: Vec4bool = Vec4bool()) = greaterThan(abs(a - b), epsilon)

    fun epsilonNotEqual(a: Vec4i, b: Vec4i, epsilon: Int, res: Vec4bool = Vec4bool()) = greaterThan(abs(a - b), Vec4i(epsilon), res)
    fun epsilonNotEqual(a: Vec4i, b: Vec4i, epsilon: Vec4i, res: Vec4bool = Vec4bool()) = greaterThan(abs(a - b), epsilon)

    fun epsilonNotEqual(a: Vec4l, b: Vec4l, epsilon: Long, res: Vec4bool = Vec4bool()) = greaterThan(abs(a - b), Vec4l(epsilon), res)
    fun epsilonNotEqual(a: Vec4l, b: Vec4l, epsilon: Vec4l, res: Vec4bool = Vec4bool()) = greaterThan(abs(a - b), epsilon)

    fun epsilonNotEqual(a: Vec4s, b: Vec4s, epsilon: Short, res: Vec4bool = Vec4bool()) = greaterThan(abs(a - b), Vec4s(epsilon), res)
    fun epsilonNotEqual(a: Vec4s, b: Vec4s, epsilon: Int, res: Vec4bool = Vec4bool()) = greaterThan(abs(a - b), Vec4s(epsilon), res)
    fun epsilonNotEqual(a: Vec4s, b: Vec4s, epsilon: Vec4s, res: Vec4bool = Vec4bool()) = greaterThan(abs(a - b), epsilon)


    fun epsilonEqual(a: Quat, b: Quat, epsilon: Float, res: Vec4bool = Vec4bool()): Vec4bool {
        res.x = abs(a.x - b.x) < epsilon
        res.y = abs(a.y - b.y) < epsilon
        res.z = abs(a.z - b.z) < epsilon
        res.w = abs(a.w - b.w) < epsilon
        return res
    }
    
    fun epsilonEqual(a: QuatD, b: QuatD, epsilon: Double, res: Vec4bool = Vec4bool()): Vec4bool {
        res.x = abs(a.x - b.x) < epsilon
        res.y = abs(a.y - b.y) < epsilon
        res.z = abs(a.z - b.z) < epsilon
        res.w = abs(a.w - b.w) < epsilon
        return res
    }
    fun epsilonNotEqual(a: Quat, b: Quat, epsilon: Float, res: Vec4bool = Vec4bool()): Vec4bool {
        res.x = abs(a.x - b.x) >= epsilon
        res.y = abs(a.y - b.y) >= epsilon
        res.z = abs(a.z - b.z) >= epsilon
        res.w = abs(a.w - b.w) >= epsilon
        return res
    }
    
    fun epsilonNotEqual(a: QuatD, b: QuatD, epsilon: Double, res: Vec4bool = Vec4bool()): Vec4bool {
        res.x = abs(a.x - b.x) >= epsilon
        res.y = abs(a.y - b.y) >= epsilon
        res.z = abs(a.z - b.z) >= epsilon
        res.w = abs(a.w - b.w) >= epsilon
        return res
    }
}