package main.func

import main.d
import main.f
import main.glm.Companion.sqrt
import main.glm.Companion.inverseSqrt
import vec._2.Vec2
import vec._2.Vec2d
import vec._3.Vec3
import vec._3.Vec3d
import vec._4.Vec4
import vec._4.Vec4d
import quat.Quat

/**
 * Created by GBarbieri on 12.12.2016.
 */

interface func_geometric {

    fun length(a: Vec2) = sqrt(dot(a, a))
    fun length(a: Vec2d) = sqrt(dot(a, a))

    fun length(a: Vec3) = sqrt(dot(a, a))
    fun length(a: Vec3d) = sqrt(dot(a, a))

    fun length(a: Vec4) = sqrt(dot(a, a))
    fun length(a: Vec4d) = sqrt(dot(a, a))


    fun distance(a: Vec2, b: Vec2) = Math.sqrt(((a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y)).d).f
    fun distance(a: Vec2d, b: Vec2d) = Math.sqrt((a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y))

    fun distance(a: Vec3, b: Vec3) = Math.sqrt(((a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y) + (a.z - b.z) * (a.z - b.z)).d).f
    fun distance(a: Vec3d, b: Vec3d) = Math.sqrt((a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y) + (a.z - b.z) * (a.z - b.z))

    fun distance(a: Vec4, b: Vec4) = Math.sqrt(((a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y) + (a.z - b.z) * (a.z - b.z) + (a.w - b.w) * (a.w - b.w)).d).f
    fun distance(a: Vec4d, b: Vec4d) = Math.sqrt((a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y) + (a.z - b.z) * (a.z - b.z) + (a.w - b.w) * (a.w - b.w))


    fun dot(a: Float, b: Float) = a * b
    fun dot(a: Double, b: Double) = a * b

    fun dot(a: Vec2, b: Vec2) = a.x * b.x + a.y * b.y
    fun dot(a: Vec2d, b: Vec2d) = a.x * b.x + a.y * b.y

    fun dot(a: Vec3, b: Vec3) = a.x * b.x + a.y * b.y + a.z * b.z
    fun dot(a: Vec3d, b: Vec3d) = a.x * b.x + a.y * b.y + a.z * b.z

    fun dot(a: Vec4, b: Vec4) = a.x * b.x + a.y * b.y + a.z * b.z + a.w * b.w
    fun dot(a: Vec4d, b: Vec4d) = a.x * b.x + a.y * b.y + a.z * b.z + a.w * b.w




    fun cross(a: Vec3, b: Vec3, res: Vec3 = Vec3()): Vec3 {
        res.x = a.y * b.z - b.y * a.z
        res.y = a.z * b.x - b.z * a.x
        res.z = a.x * b.y - b.x * a.y
        return res
    }

    fun cross(a: Vec3d, b: Vec3d, res: Vec3d = Vec3d()): Vec3d {
        res.x = a.y * b.z - b.y * a.z
        res.y = a.z * b.x - b.z * a.x
        res.z = a.x * b.y - b.x * a.y
        return res
    }

    fun cross(a: Quat, b: Quat, res: Quat = Quat()): Quat {
        res.w = a.w * b.w - a.x * b.x - a.y * b.y - a.z * b.z
        res.x = a.w * b.x + a.x * b.w + a.y * b.z - a.z * b.y
        res.y = a.w * b.y + a.y * b.w + a.z * b.x - a.x * b.z
        res.z = a.w * b.z + a.z * b.w + a.x * b.y - a.y * b.x
        return res
    }


    fun normalize(a: Float) = if (a < 0f) -1f else 1f
    fun normalize(a: Double) = if (a < 0.0) -1.0 else 1.0

    fun normalize(a: Vec2, res: Vec2 = Vec2()): Vec2 {
        res.x = a.x * inverseSqrt(dot(a, a))
        res.y = a.y * inverseSqrt(dot(a, a))
        return res
    }

    fun normalize(a: Vec2d, res: Vec2d = Vec2d()): Vec2d {
        res.x = a.x * inverseSqrt(dot(a, a))
        res.y = a.y * inverseSqrt(dot(a, a))
        return res
    }

    fun normalize(a: Vec3, res: Vec3 = Vec3()): Vec3 {
        res.x = a.x * inverseSqrt(dot(a, a))
        res.y = a.y * inverseSqrt(dot(a, a))
        res.z = a.z * inverseSqrt(dot(a, a))
        return res
    }

    fun normalize(a: Vec3d, res: Vec3d = Vec3d()): Vec3d {
        res.x = a.x * inverseSqrt(dot(a, a))
        res.y = a.y * inverseSqrt(dot(a, a))
        res.z = a.z * inverseSqrt(dot(a, a))
        return res
    }

    fun normalize(a: Vec4, res: Vec4 = Vec4()): Vec4 {
        res.x = a.x * inverseSqrt(dot(a, a))
        res.y = a.y * inverseSqrt(dot(a, a))
        res.z = a.z * inverseSqrt(dot(a, a))
        res.w = a.w * inverseSqrt(dot(a, a))
        return res
    }

    fun normalize(a: Vec4d, res: Vec4d = Vec4d()): Vec4d {
        res.x = a.x * inverseSqrt(dot(a, a))
        res.y = a.y * inverseSqrt(dot(a, a))
        res.z = a.z * inverseSqrt(dot(a, a))
        res.w = a.w * inverseSqrt(dot(a, a))
        return res
    }


    fun faceForward(n: Float, i: Float, nRef: Float) = i - n * dot(n, i) * 2f
    fun faceForward(n: Double, i: Double, nRef: Double) = i - n * dot(n, i) * 2.0

    fun faceForward(n: Vec2, i: Vec2, nRef: Vec2, res: Vec2 = Vec2()): Vec2 {
        val neg = dot(nRef, i) < 0
        res.x = if (neg) n.x else -n.x
        res.y = if (neg) n.y else -n.y
        return res
    }

    fun faceForward(n: Vec2d, i: Vec2d, nRef: Vec2d, res: Vec2d = Vec2d()): Vec2d {
        val neg = dot(nRef, i) < 0
        res.x = if (neg) n.x else -n.x
        res.y = if (neg) n.y else -n.y
        return res
    }

    fun faceForward(n: Vec3, i: Vec3, nRef: Vec3, res: Vec3 = Vec3()): Vec3 {
        val neg = dot(nRef, i) < 0
        res.x = if (neg) n.x else -n.x
        res.y = if (neg) n.y else -n.y
        res.z = if (neg) n.z else -n.z
        return res
    }

    fun faceForward(n: Vec3d, i: Vec3d, nRef: Vec3d, res: Vec3d = Vec3d()): Vec3d {
        val neg = dot(nRef, i) < 0
        res.x = if (neg) n.x else -n.x
        res.y = if (neg) n.y else -n.y
        res.z = if (neg) n.z else -n.z
        return res
    }

    fun faceForward(n: Vec4, i: Vec4, nRef: Vec4, res: Vec4 = Vec4()): Vec4 {
        val neg = dot(nRef, i) < 0
        res.x = if (neg) n.x else -n.x
        res.y = if (neg) n.y else -n.y
        res.z = if (neg) n.z else -n.z
        res.w = if (neg) n.w else -n.w
        return res
    }

    fun faceForward(n: Vec4d, i: Vec4d, nRef: Vec4d, res: Vec4d = Vec4d()): Vec4d {
        val neg = dot(nRef, i) < 0
        res.x = if (neg) n.x else -n.x
        res.y = if (neg) n.y else -n.y
        res.z = if (neg) n.z else -n.z
        res.w = if (neg) n.w else -n.w
        return res
    }


    fun reflect(i: Float, n: Float) = i * n * dot(n, i) * 2
    fun reflect(i: Double, n: Double) = i * n * dot(n, i) * 2

    fun reflect(i: Vec2, n: Vec2, res: Vec2 = Vec2()): Vec2 {
        val dot2 = dot(n, i) * 2
        res.x = i.x - n.x * dot2
        res.y = i.y - n.y * dot2
        return res
    }

    fun reflect(i: Vec2d, n: Vec2d, res: Vec2d = Vec2d()): Vec2d {
        val dot2 = dot(n, i) * 2
        res.x = i.x - n.x * dot2
        res.y = i.y - n.y * dot2
        return res
    }

    fun reflect(i: Vec3, n: Vec3, res: Vec3 = Vec3()): Vec3 {
        val dot2 = dot(n, i) * 2
        res.x = i.x - n.x * dot2
        res.y = i.y - n.y * dot2
        res.z = i.z - n.z * dot2
        return res
    }

    fun reflect(i: Vec3d, n: Vec3d, res: Vec3d = Vec3d()): Vec3d {
        val dot2 = dot(n, i) * 2
        res.x = i.x - n.x * dot2
        res.y = i.y - n.y * dot2
        res.z = i.z - n.z * dot2
        return res
    }

    fun reflect(i: Vec4, n: Vec4, res: Vec4 = Vec4()): Vec4 {
        val dot2 = dot(n, i) * 2
        res.x = i.x - n.x * dot2
        res.y = i.y - n.y * dot2
        res.z = i.z - n.z * dot2
        res.w = i.w - n.w * dot2
        return res
    }

    fun reflect(i: Vec4d, n: Vec4d, res: Vec4d = Vec4d()): Vec4d {
        val dot2 = dot(n, i) * 2
        res.x = i.x - n.x * dot2
        res.y = i.y - n.y * dot2
        res.z = i.z - n.z * dot2
        res.w = i.w - n.w * dot2
        return res
    }


    fun refract(i: Float, n: Float, eta: Float): Float {
        val dot = dot(n, i)
        val k = 1f - eta * eta * (1f - dot * dot)
        return (eta * i - (eta * dot + sqrt(k)) * n) * if (k >= 0f) 1f else 0f
    }

    fun refract(i: Double, n: Double, eta: Double): Double {
        val dot = dot(n, i)
        val k = 1.0 - eta * eta * (1.0 - dot * dot)
        return (eta * i - (eta * dot + sqrt(k)) * n) * if (k >= 0.0) 1.0 else 0.0
    }

    fun refract(i: Vec2, n: Vec2, eta: Number, res: Vec2 = Vec2()): Vec2 {
        val dot = dot(n, i)
        val k = 1f - eta.f * eta.f * (1f - dot * dot)
        res.x = eta.f * i.x - (eta.f * dot + sqrt(k)) * n.x * if (k >= 0f) 1f else 0f
        res.y = eta.f * i.y - (eta.f * dot + sqrt(k)) * n.y * if (k >= 0f) 1f else 0f
        return res
    }

    fun refract(i: Vec2d, n: Vec2d, eta: Number, res: Vec2d = Vec2d()): Vec2d {
        val dot = dot(n, i)
        val k = 1.0 - eta.d * eta.d * (1.0 - dot * dot)
        res.x = eta.d * i.x - (eta.d * dot + sqrt(k)) * n.x * if (k >= 0.0) 1.0 else 0.0
        res.y = eta.d * i.y - (eta.d * dot + sqrt(k)) * n.y * if (k >= 0.0) 1.0 else 0.0
        return res
    }

    fun refract(i: Vec3, n: Vec3, eta: Number, res: Vec3 = Vec3()): Vec3 {
        val dot = dot(n, i)
        val k = 1f - eta.f * eta.f * (1f - dot * dot)
        res.x = eta.f * i.x - (eta.f * dot + sqrt(k)) * n.x * if (k >= 0f) 1f else 0f
        res.y = eta.f * i.y - (eta.f * dot + sqrt(k)) * n.y * if (k >= 0f) 1f else 0f
        res.z = eta.f * i.z - (eta.f * dot + sqrt(k)) * n.z * if (k >= 0f) 1f else 0f
        return res
    }

    fun refract(i: Vec3d, n: Vec3d, eta: Number, res: Vec3d = Vec3d()): Vec3d {
        val dot = dot(n, i)
        val k = 1.0 - eta.d * eta.d * (1.0 - dot * dot)
        res.x = eta.d * i.x - (eta.d * dot + sqrt(k)) * n.x * if (k >= 0.0) 1.0 else 0.0
        res.y = eta.d * i.y - (eta.d * dot + sqrt(k)) * n.y * if (k >= 0.0) 1.0 else 0.0
        res.z = eta.d * i.z - (eta.d * dot + sqrt(k)) * n.z * if (k >= 0.0) 1.0 else 0.0
        return res
    }

    fun refract(i: Vec4, n: Vec4, eta: Number, res: Vec4 = Vec4()): Vec4 {
        val dot = dot(n, i)
        val k = 1f - eta.f * eta.f * (1f - dot * dot)
        res.x = eta.f * i.x - (eta.f * dot + sqrt(k)) * n.x * if (k >= 0f) 1f else 0f
        res.y = eta.f * i.y - (eta.f * dot + sqrt(k)) * n.y * if (k >= 0f) 1f else 0f
        res.z = eta.f * i.z - (eta.f * dot + sqrt(k)) * n.z * if (k >= 0f) 1f else 0f
        res.w = eta.f * i.w - (eta.f * dot + sqrt(k)) * n.w * if (k >= 0f) 1f else 0f
        return res
    }

    fun refract(i: Vec4d, n: Vec4d, eta: Number, res: Vec4d = Vec4d()): Vec4d {
        val dot = dot(n, i)
        val k = 1.0 - eta.d * eta.d * (1.0 - dot * dot)
        res.x = eta.d * i.x - (eta.d * dot + sqrt(k)) * n.x * if (k >= 0.0) 1.0 else 0.0
        res.y = eta.d * i.y - (eta.d * dot + sqrt(k)) * n.y * if (k >= 0.0) 1.0 else 0.0
        res.z = eta.d * i.z - (eta.d * dot + sqrt(k)) * n.z * if (k >= 0.0) 1.0 else 0.0
        res.w = eta.d * i.w - (eta.d * dot + sqrt(k)) * n.w * if (k >= 0.0) 1.0 else 0.0
        return res
    }
}