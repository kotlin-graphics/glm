package glm_

import glm_.vec2.Vec2
import glm_.vec2.Vec2b
import glm_.vec2.Vec2d
import glm_.vec3.Vec3
import glm_.vec3.Vec3d
import glm_.vec4.Vec4
import glm_.vec4.Vec4d
import java.util.concurrent.ThreadLocalRandom


interface random {

    fun linearRand(min: Float, max: Float): Float {
        var d = ThreadLocalRandom.current().nextDouble(min.d, max + Double.MIN_VALUE)
        while (d > max) d = ThreadLocalRandom.current().nextDouble(min.d, max + Double.MIN_VALUE)
        return d.f
    }

    fun linearRand(min: Double, max: Double): Double {
        var d = ThreadLocalRandom.current().nextDouble(min, max + Double.MIN_VALUE)
        while (d > max) d = ThreadLocalRandom.current().nextDouble(min, max + Double.MIN_VALUE)
        return d
    }

    fun linearRand(min: Int, max: Int): Int {
        var d = ThreadLocalRandom.current().nextInt(min, max + Int.MIN_VALUE)
        while (d > max) d = ThreadLocalRandom.current().nextInt(min, max + Int.MIN_VALUE)
        return d
    }

    fun linearRand(min: Long, max: Long): Long {
        var d = ThreadLocalRandom.current().nextLong(min, max + Long.MIN_VALUE)
        while (d > max) d = ThreadLocalRandom.current().nextLong(min, max + Long.MIN_VALUE)
        return d
    }

    fun linearRand(min: Vec2, max: Vec2, res: Vec2 = Vec2()): Vec2 {
        res.x = linearRand(min.x, max.x)
        res.y = linearRand(min.y, max.y)
        return res
    }

    fun double(min: Vec2d, max: Vec2d, res: Vec2d = Vec2d()): Vec2d {
        res.x = linearRand(min.x, max.x)
        res.y = linearRand(min.y, max.y)
        return res
    }

    fun linearRand(min: Vec2b, max: Vec2b, res: Vec2b = Vec2b()): Vec2b {
        res.x = linearRand(min.x.i, max.x.i).b
        res.y = linearRand(min.y.i, max.y.i).b
        return res
    }

    fun float(min: Vec3, max: Vec3, res: Vec3 = Vec3()): Vec3 {
        res.x = linearRand(min.x, max.x)
        res.y = linearRand(min.y, max.y)
        res.z = linearRand(min.z, max.z)
        return res
    }

    fun double(min: Vec3d, max: Vec3d, res: Vec3d = Vec3d()): Vec3d {
        res.x = linearRand(min.x, max.x)
        res.y = linearRand(min.y, max.y)
        res.z = linearRand(min.z, max.z)
        return res
    }

    fun float(min: Vec4, max: Vec4, res: Vec4 = Vec4()): Vec4 {
        res.x = linearRand(min.x, max.x)
        res.y = linearRand(min.y, max.y)
        res.z = linearRand(min.z, max.z)
        res.w = linearRand(min.w, max.w)
        return res
    }

    fun double(min: Vec4d, max: Vec4d, res: Vec4d = Vec4d()): Vec4d {
        res.x = linearRand(min.x, max.x)
        res.y = linearRand(min.y, max.y)
        res.z = linearRand(min.z, max.z)
        res.w = linearRand(min.w, max.w)
        return res
    }

    fun gaussRand(mean: Float, deviation: Float): Float {

        var x1 = linearRand(-1f, 1f)
        var x2 = linearRand(-1f, 1f)
        var w = x1 * x1 + x2 * x2

        while (w > 1) {
            x1 = linearRand(-1f, 1f)
            x2 = linearRand(-1f, 1f)
            w = x1 * x1 + x2 * x2
        }

        return x2 * deviation * deviation * glm.sqrt(-2 * glm.log(w)) + mean
    }

    fun gaussRand(mean: Double, deviation: Double): Double {

        var x1 = linearRand(-1.0, 1.0)
        var x2 = linearRand(-1.0, 1.0)
        var w = x1 * x1 + x2 * x2

        while (w > 1) {
            x1 = linearRand(-1.0, 1.0)
            x2 = linearRand(-1.0, 1.0)
            w = x1 * x1 + x2 * x2
        }

        return x2 * deviation * deviation * glm.sqrt(-2 * glm.log(w)) + mean
    }

    fun gaussRand(mean: Vec2, deviation: Vec2, res: Vec2 = Vec2()): Vec2 {
        res.x = gaussRand(mean.x, deviation.x)
        res.y = gaussRand(mean.y, deviation.y)
        return res
    }

    fun gaussRand(mean: Vec2d, deviation: Vec2d, res: Vec2d = Vec2d()): Vec2d {
        res.x = gaussRand(mean.x, deviation.x)
        res.y = gaussRand(mean.y, deviation.y)
        return res
    }

    fun gaussRand(mean: Vec3, deviation: Vec3, res: Vec3 = Vec3()): Vec3 {
        res.x = gaussRand(mean.x, deviation.x)
        res.y = gaussRand(mean.y, deviation.y)
        res.z = gaussRand(mean.z, deviation.z)
        return res
    }

    fun gaussRand(mean: Vec3d, deviation: Vec3d, res: Vec3d = Vec3d()): Vec3d {
        res.x = gaussRand(mean.x, deviation.x)
        res.y = gaussRand(mean.y, deviation.y)
        res.z = gaussRand(mean.z, deviation.z)
        return res
    }

    fun gaussRand(mean: Vec4, deviation: Vec4, res: Vec4 = Vec4()): Vec4 {
        res.x = gaussRand(mean.x, deviation.x)
        res.y = gaussRand(mean.y, deviation.y)
        res.z = gaussRand(mean.z, deviation.z)
        res.w = gaussRand(mean.w, deviation.w)
        return res
    }

    fun gaussRand(mean: Vec4d, deviation: Vec4d, res: Vec4d = Vec4d()): Vec4d {
        res.x = gaussRand(mean.x, deviation.x)
        res.y = gaussRand(mean.y, deviation.y)
        res.z = gaussRand(mean.z, deviation.z)
        res.w = gaussRand(mean.w, deviation.w)
        return res
    }

    fun diskRand(radius: Float, res: Vec2 = Vec2()): Vec2 {

        res.x = linearRand(-radius, radius)
        res.y = linearRand(-radius, radius)
        var lenRadius = res.length()

        while (lenRadius > radius) {
            res.x = linearRand(-radius, radius)
            res.y = linearRand(-radius, radius)
            lenRadius = res.length()
        }
        return res
    }

    fun diskRand(radius: Double, res: Vec2d = Vec2d()): Vec2d {

        res.x = linearRand(-radius, radius)
        res.y = linearRand(-radius, radius)
        var lenRadius = res.length()

        while (lenRadius > radius) {
            res.x = linearRand(-radius, radius)
            res.y = linearRand(-radius, radius)
            lenRadius = res.length()
        }
        return res
    }

    fun diskRand(radius: Float, res: Vec3 = Vec3()): Vec3 {

        res.x = linearRand(-radius, radius)
        res.y = linearRand(-radius, radius)
        res.z = linearRand(-radius, radius)
        var lenRadius = res.length()

        while (lenRadius > radius) {
            res.x = linearRand(-radius, radius)
            res.y = linearRand(-radius, radius)
            res.z = linearRand(-radius, radius)
            lenRadius = res.length()
        }
        return res
    }

    fun diskRand(radius: Double, res: Vec3d = Vec3d()): Vec3d {

        res.x = linearRand(-radius, radius)
        res.y = linearRand(-radius, radius)
        res.z = linearRand(-radius, radius)
        var lenRadius = res.length()

        while (lenRadius > radius) {
            res.x = linearRand(-radius, radius)
            res.y = linearRand(-radius, radius)
            res.z = linearRand(-radius, radius)
            lenRadius = res.length()
        }
        return res
    }

    fun diskRand(radius: Float, res: Vec4 = Vec4()): Vec4 {

        res.x = linearRand(-radius, radius)
        res.y = linearRand(-radius, radius)
        res.z = linearRand(-radius, radius)
        res.w = linearRand(-radius, radius)
        var lenRadius = res.length()

        while (lenRadius > radius) {
            res.x = linearRand(-radius, radius)
            res.y = linearRand(-radius, radius)
            res.z = linearRand(-radius, radius)
            res.w = linearRand(-radius, radius)
            lenRadius = res.length()
        }
        return res
    }

    fun diskRand(radius: Double, res: Vec4d = Vec4d()): Vec4d {

        res.x = linearRand(-radius, radius)
        res.y = linearRand(-radius, radius)
        res.z = linearRand(-radius, radius)
        res.w = linearRand(-radius, radius)
        var lenRadius = res.length()

        while (lenRadius > radius) {
            res.x = linearRand(-radius, radius)
            res.y = linearRand(-radius, radius)
            res.z = linearRand(-radius, radius)
            res.w = linearRand(-radius, radius)
            lenRadius = res.length()
        }
        return res
    }

    //TODO sphericalRand
}

