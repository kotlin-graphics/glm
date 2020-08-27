package glm_.func

import glm_.d
import glm_.f
import glm_.glm.inverseSqrt
import glm_.quat.Quat
import glm_.vec1.Vec1
import glm_.vec1.Vec1d
import glm_.vec2.Vec2
import glm_.vec2.Vec2d
import glm_.vec3.Vec3
import glm_.vec3.Vec3d
import glm_.vec3.Vec3t
import glm_.vec4.Vec4
import glm_.vec4.Vec4d
import kotlin.math.abs
import kotlin.math.sqrt

/**
 * Created by GBarbieri on 12.12.2016.
 */

interface func_geometric {


    fun length(a: Vec1) = sqrt(dot(a, a))
    fun length(a: Vec1d) = sqrt(dot(a, a))

    fun length(a: Vec2) = sqrt(dot(a, a))
    fun length(a: Vec2d) = sqrt(dot(a, a))

    fun length(a: Vec3) = sqrt(dot(a, a))
    fun length(a: Vec3d) = sqrt(dot(a, a))

    fun length(a: Vec4) = sqrt(dot(a, a))
    fun length(a: Vec4d) = sqrt(dot(a, a))

    fun length2(a: Vec2) = a dot a
    fun length2(a: Vec2d) = a dot a

    fun length2(a: Vec3) = a dot a
    fun length2(a: Vec3d) = a dot a

    fun length2(a: Vec4) = a dot a
    fun length2(a: Vec4d) = a dot a


    fun distance(a: Vec1, b: Vec1) = sqrt((a.x - b.x) * (a.x - b.x))
    fun distance(a: Vec1d, b: Vec1d) = sqrt((a.x - b.x) * (a.x - b.x))

    fun distance(a: Vec2, b: Vec2) = sqrt((a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y))
    fun distance(a: Vec2d, b: Vec2d) = sqrt((a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y))

    fun distance(a: Vec3, b: Vec3) = sqrt((a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y) + (a.z - b.z) * (a.z - b.z))
    fun distance(a: Vec3d, b: Vec3d) = sqrt((a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y) + (a.z - b.z) * (a.z - b.z))

    fun distance(a: Vec4, b: Vec4) = sqrt((a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y) + (a.z - b.z) * (a.z - b.z) + (a.w - b.w) * (a.w - b.w))
    fun distance(a: Vec4d, b: Vec4d) = sqrt((a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y) + (a.z - b.z) * (a.z - b.z) + (a.w - b.w) * (a.w - b.w))


    /** Shortest distance between Point and Line    */
    fun distance(point: Vec3, lineA: Vec3, lineB: Vec3) = abs(((point - lineA) cross (point - lineB)).length()) / abs((lineB - lineA).length())


    fun dot(a: Float, b: Float) = a * b
    fun dot(a: Double, b: Double) = a * b

    fun dot(a: Vec1, b: Vec1) = a.x * b.x
    fun dot(a: Vec1d, b: Vec1d) = a.x * b.x

    fun dot(a: Vec2, b: Vec2) = a.x * b.x + a.y * b.y
    fun dot(a: Vec2d, b: Vec2d) = a.x * b.x + a.y * b.y

    fun dot(a: Vec3, b: Vec3) = a.x * b.x + a.y * b.y + a.z * b.z
    fun dot(a: Vec3d, b: Vec3d) = a.x * b.x + a.y * b.y + a.z * b.z

    fun dot(a: Vec3, b: Vec3t<out Number>) = a.x * b.x.f + a.y * b.y.f + a.z * b.z.f
    fun dot(a: Vec3d, b: Vec3t<out Number>) = a.x * b.x.f + a.y * b.y.f + a.z * b.z.f

    fun dot(a: Vec4, b: Vec4) = a.x * b.x + a.y * b.y + a.z * b.z + a.w * b.w
    fun dot(a: Vec4d, b: Vec4d) = a.x * b.x + a.y * b.y + a.z * b.z + a.w * b.w


    fun cross(a: Vec2, b: Vec2) = a.x * b.y - b.x * a.y
    fun cross(a: Vec2d, b: Vec2d) = a.x * b.y - b.x * a.y


    fun cross(a: Vec3, b: Vec3, res: Vec3 = Vec3()): Vec3 {
        val x = a.y * b.z - b.y * a.z
        val y = a.z * b.x - b.z * a.x
        val z = a.x * b.y - b.x * a.y
        res.x = x
        res.y = y
        res.z = z
        return res
    }

    fun cross(a: Vec3d, b: Vec3d, res: Vec3d = Vec3d()): Vec3d {
        val x = a.y * b.z - b.y * a.z
        val y = a.z * b.x - b.z * a.x
        val z = a.x * b.y - b.x * a.y
        res.x = x
        res.y = y
        res.z = z
        return res
    }


    fun normalize(a: Float) = if (a < 0f) -1f else 1f
    fun normalize(a: Double) = if (a < 0.0) -1.0 else 1.0

    fun normalize(a: Vec2, res: Vec2 = Vec2()): Vec2 {
        val inv = inverseSqrt(dot(a, a))
        res.x = a.x * inv
        res.y = a.y * inv
        return res
    }

    fun normalize(a: Vec2d, res: Vec2d = Vec2d()): Vec2d {
        val inv = inverseSqrt(dot(a, a))
        res.x = a.x * inv
        res.y = a.y * inv
        return res
    }

    fun normalize(a: Vec3, res: Vec3 = Vec3()): Vec3 {
        val inv = inverseSqrt(dot(a, a))
        res.x = a.x * inv
        res.y = a.y * inv
        res.z = a.z * inv
        return res
    }

    fun normalize(a: Vec3d, res: Vec3d = Vec3d()): Vec3d {
        val inv = inverseSqrt(dot(a, a))
        res.x = a.x * inv
        res.y = a.y * inv
        res.z = a.z * inv
        return res
    }

    fun normalize(a: Vec4, res: Vec4 = Vec4()): Vec4 {
        val inv = inverseSqrt(dot(a, a))
        res.x = a.x * inv
        res.y = a.y * inv
        res.z = a.z * inv
        res.w = a.w * inv
        return res
    }

    fun normalize(a: Vec4d, res: Vec4d = Vec4d()): Vec4d {
        val inv = inverseSqrt(dot(a, a))
        res.x = a.x * inv
        res.y = a.y * inv
        res.z = a.z * inv
        res.w = a.w * inv
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
        return when {
            k >= 0 -> eta * i - (eta * dot + sqrt(k)) * n
            else -> 0f
        }
    }

    fun refract(i: Double, n: Double, eta: Double): Double {
        val dot = dot(n, i)
        val k = 1.0 - eta * eta * (1.0 - dot * dot)
        return when {
            k >= 0 -> eta * i - (eta * dot + sqrt(k)) * n
            else -> 0.0
        }
    }

    fun refract(i: Vec2, n: Vec2, eta: Float, res: Vec2 = Vec2()): Vec2 {
        val dot = dot(n, i)
        val k = 1f - eta * eta * (1f - dot * dot)
        when {
            k >= 0 -> {
                res.x = eta * i.x - (eta * dot + sqrt(k)) * n.x
                res.y = eta * i.y - (eta * dot + sqrt(k)) * n.y
            }
            else -> {
                res.x = 0f
                res.y = 0f
            }
        }
        return res
    }

    fun refract(i: Vec2d, n: Vec2d, eta: Double, res: Vec2d = Vec2d()): Vec2d {
        val dot = dot(n, i)
        val k = 1.0 - eta * eta * (1.0 - dot * dot)
        when {
            k >= 0 -> {
                res.x = eta * i.x - (eta * dot + sqrt(k)) * n.x
                res.y = eta * i.y - (eta * dot + sqrt(k)) * n.y
            }
            else -> {
                res.x = 0.0
                res.y = 0.0
            }
        }
        return res
    }

    fun refract(i: Vec3, n: Vec3, eta: Float, res: Vec3 = Vec3()): Vec3 {
        val dot = dot(n, i)
        val k = 1f - eta * eta * (1f - dot * dot)
        when {
            k >= 0 -> {
                res.x = eta * i.x - (eta * dot + sqrt(k)) * n.x
                res.y = eta * i.y - (eta * dot + sqrt(k)) * n.y
                res.z = eta * i.z - (eta * dot + sqrt(k)) * n.z
            }
            else -> {
                res.x = 0f
                res.y = 0f
                res.z = 0f
            }
        }
        return res
    }

    fun refract(i: Vec3d, n: Vec3d, eta: Double, res: Vec3d = Vec3d()): Vec3d {
        val dot = dot(n, i)
        val k = 1.0 - eta * eta * (1.0 - dot * dot)
        when {
            k >= 0 -> {
                res.x = eta * i.x - (eta * dot + sqrt(k)) * n.x
                res.y = eta * i.y - (eta * dot + sqrt(k)) * n.y
                res.z = eta * i.z - (eta * dot + sqrt(k)) * n.z
            }
            else -> {
                res.x = 0.0
                res.y = 0.0
                res.z = 0.0
            }
        }
        return res
    }

    fun refract(i: Vec4, n: Vec4, eta: Float, res: Vec4 = Vec4()): Vec4 {
        val dot = dot(n, i)
        val k = 1f - eta * eta * (1f - dot * dot)
        when {
            k >= 0 -> {
                res.x = eta * i.x - (eta * dot + sqrt(k)) * n.x
                res.y = eta * i.y - (eta * dot + sqrt(k)) * n.y
                res.z = eta * i.z - (eta * dot + sqrt(k)) * n.z
                res.w = eta * i.w - (eta * dot + sqrt(k)) * n.w
            }
            else -> {
                res.x = 0f
                res.y = 0f
                res.z = 0f
                res.w = 0f
            }
        }
        return res
    }

    fun refract(i: Vec4d, n: Vec4d, eta: Double, res: Vec4d = Vec4d()): Vec4d {
        assert(eta >= -1.0 && eta <= 1.0)
        val dot = dot(n, i)
        val k = 1.0 - eta * eta * (1.0 - dot * dot)
        when {
            k >= 0 -> {
                res.x = eta * i.x - (eta * dot + sqrt(k)) * n.x
                res.y = eta * i.y - (eta * dot + sqrt(k)) * n.y
                res.z = eta * i.z - (eta * dot + sqrt(k)) * n.z
                res.w = eta * i.w - (eta * dot + sqrt(k)) * n.w
            }
            else -> {
                res.x = 0.0
                res.y = 0.0
                res.z = 0.0
                res.w = 0.0
            }
        }
        return res
    }
}