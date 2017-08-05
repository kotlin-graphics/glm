package glm_.detail

import glm_.d
import glm_.f
import glm_.vec2.Vec2
import glm_.vec2.Vec2d
import glm_.vec3.Vec3
import glm_.vec3.Vec3d
import glm_.vec4.Vec4
import glm_.vec4.Vec4d
import java.util.concurrent.ThreadLocalRandom

object Random {

    operator fun get(min: Float, max: Float): Float {
        var d = ThreadLocalRandom.current().nextDouble(min.d, max + Double.MIN_VALUE)
        while (d > max) d = ThreadLocalRandom.current().nextDouble(min.d, max + Double.MIN_VALUE)
        return d.f
    }

    operator fun get(min: Double, max: Double): Double {
        var d = ThreadLocalRandom.current().nextDouble(min, max + Double.MIN_VALUE)
        while (d > max) d = ThreadLocalRandom.current().nextDouble(min, max + Double.MIN_VALUE)
        return d
    }

    operator fun get(min: Vec2, max: Vec2, res: Vec2 = Vec2()): Vec2 {
        res.x = this[min.x, max.x]
        res.y = this[min.y, max.y]
        return res
    }

    fun double(min: Vec2d, max: Vec2d, res: Vec2d = Vec2d()): Vec2d {
        res.x = this[min.x, max.x]
        res.y = this[min.y, max.y]
        return res
    }

    fun float(min: Vec3, max: Vec3, res: Vec3 = Vec3()): Vec3 {
        res.x = this[min.x, max.x]
        res.y = this[min.y, max.y]
        res.z = this[min.z, max.z]
        return res
    }

    fun double(min: Vec3d, max: Vec3d, res: Vec3d = Vec3d()): Vec3d {
        res.x = this[min.x, max.x]
        res.y = this[min.y, max.y]
        res.z = this[min.z, max.z]
        return res
    }

    fun float(min: Vec4, max: Vec4, res: Vec4 = Vec4()): Vec4 {
        res.x = this[min.x, max.x]
        res.y = this[min.y, max.y]
        res.z = this[min.z, max.z]
        res.w = this[min.w, max.w]
        return res
    }

    fun double(min: Vec4d, max: Vec4d, res: Vec4d = Vec4d()): Vec4d {
        res.x = this[min.x, max.x]
        res.y = this[min.y, max.y]
        res.z = this[min.z, max.z]
        res.w = this[min.w, max.w]
        return res
    }
}