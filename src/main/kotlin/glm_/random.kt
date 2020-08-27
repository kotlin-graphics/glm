package glm_

import glm_.vec2.Vec2
import glm_.vec2.Vec2b
import glm_.vec2.Vec2d
import glm_.vec3.Vec3
import glm_.vec3.Vec3d
import glm_.vec4.Vec4
import glm_.vec4.Vec4d
import java.util.concurrent.ThreadLocalRandom
import kotlin.math.acos
import kotlin.math.cos
import kotlin.math.sin


interface random {

    /** Generate random numbers in the interval [min, max], according a linear distribution
     *  @param min Minimum value included in the sampling
     *  @param max Maximum value included in the sampling */
    fun linearRand(min: Float, max: Float): Float {
        var d = ThreadLocalRandom.current().nextDouble(min.d, max + Double.MIN_VALUE)
        while (d > max) d = ThreadLocalRandom.current().nextDouble(min.d, max + Double.MIN_VALUE)
        return d.f
    }

    /** Generate random numbers in the interval [min, max], according a linear distribution
     *  @param min Minimum value included in the sampling
     *  @param max Maximum value included in the sampling */
    fun linearRand(min: Double, max: Double): Double {
        var d = ThreadLocalRandom.current().nextDouble(min, max + Double.MIN_VALUE)
        while (d > max) d = ThreadLocalRandom.current().nextDouble(min, max + Double.MIN_VALUE)
        return d
    }

    /** Generate random numbers in the interval [min, max], according a linear distribution
     *  @param min Minimum value included in the sampling
     *  @param max Maximum value included in the sampling */
    fun linearRand(min: Int, max: Int): Int {
        var d = ThreadLocalRandom.current().nextInt(min, max)
        while (d > max) d = ThreadLocalRandom.current().nextInt(min, max)
        return d
    }

    /** Generate random numbers in the interval [min, max], according a linear distribution
     *  @param min Minimum value included in the sampling
     *  @param max Maximum value included in the sampling */
    fun linearRand(min: Long, max: Long): Long {
        var d = ThreadLocalRandom.current().nextLong(min, max)
        while (d > max) d = ThreadLocalRandom.current().nextLong(min, max)
        return d
    }

    /** Generate random numbers in the interval [min, max], according a linear distribution
     *  @param min Minimum value included in the sampling
     *  @param max Maximum value included in the sampling */
    fun linearRand(min: Vec2, max: Vec2, res: Vec2 = Vec2()): Vec2 {
        res.x = linearRand(min.x, max.x)
        res.y = linearRand(min.y, max.y)
        return res
    }

    /** Generate random numbers in the interval [min, max], according a linear distribution
     *  @param min Minimum value included in the sampling
     *  @param max Maximum value included in the sampling */
    fun linearRand(min: Vec2d, max: Vec2d, res: Vec2d = Vec2d()): Vec2d {
        res.x = linearRand(min.x, max.x)
        res.y = linearRand(min.y, max.y)
        return res
    }

    /** Generate random numbers in the interval [min, max], according a linear distribution
     *  @param min Minimum value included in the sampling
     *  @param max Maximum value included in the sampling */
    fun linearRand(min: Vec2b, max: Vec2b, res: Vec2b = Vec2b()): Vec2b {
        res.x = linearRand(min.x.i, max.x.i).b
        res.y = linearRand(min.y.i, max.y.i).b
        return res
    }

    /** Generate random numbers in the interval [min, max], according a linear distribution
     *  @param min Minimum value included in the sampling
     *  @param max Maximum value included in the sampling */
    fun linearRand(min: Vec3, max: Vec3, res: Vec3 = Vec3()): Vec3 {
        res.x = linearRand(min.x, max.x)
        res.y = linearRand(min.y, max.y)
        res.z = linearRand(min.z, max.z)
        return res
    }

    /** Generate random numbers in the interval [min, max], according a linear distribution
     *  @param min Minimum value included in the sampling
     *  @param max Maximum value included in the sampling */
    fun linearRand(min: Vec3d, max: Vec3d, res: Vec3d = Vec3d()): Vec3d {
        res.x = linearRand(min.x, max.x)
        res.y = linearRand(min.y, max.y)
        res.z = linearRand(min.z, max.z)
        return res
    }

    /** Generate random numbers in the interval [min, max], according a linear distribution
     *  @param min Minimum value included in the sampling
     *  @param max Maximum value included in the sampling */
    fun linearRand(min: Vec4, max: Vec4, res: Vec4 = Vec4()): Vec4 {
        res.x = linearRand(min.x, max.x)
        res.y = linearRand(min.y, max.y)
        res.z = linearRand(min.z, max.z)
        res.w = linearRand(min.w, max.w)
        return res
    }

    /** Generate random numbers in the interval [min, max], according a linear distribution
     *  @param min Minimum value included in the sampling
     *  @param max Maximum value included in the sampling */
    fun linearRand(min: Vec4d, max: Vec4d, res: Vec4d = Vec4d()): Vec4d {
        res.x = linearRand(min.x, max.x)
        res.y = linearRand(min.y, max.y)
        res.z = linearRand(min.z, max.z)
        res.w = linearRand(min.w, max.w)
        return res
    }

    /** Generate random numbers in the interval [min, max], according a gaussian distribution */
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

    /** Generate random numbers in the interval [min, max], according a gaussian distribution */
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

    /** Generate random numbers in the interval [min, max], according a gaussian distribution */
    fun gaussRand(mean: Vec2, deviation: Vec2, res: Vec2 = Vec2()): Vec2 {
        res.x = gaussRand(mean.x, deviation.x)
        res.y = gaussRand(mean.y, deviation.y)
        return res
    }

    /** Generate random numbers in the interval [min, max], according a gaussian distribution */
    fun gaussRand(mean: Vec2d, deviation: Vec2d, res: Vec2d = Vec2d()): Vec2d {
        res.x = gaussRand(mean.x, deviation.x)
        res.y = gaussRand(mean.y, deviation.y)
        return res
    }

    /** Generate random numbers in the interval [min, max], according a gaussian distribution */
    fun gaussRand(mean: Vec3, deviation: Vec3, res: Vec3 = Vec3()): Vec3 {
        res.x = gaussRand(mean.x, deviation.x)
        res.y = gaussRand(mean.y, deviation.y)
        res.z = gaussRand(mean.z, deviation.z)
        return res
    }

    /** Generate random numbers in the interval [min, max], according a gaussian distribution */
    fun gaussRand(mean: Vec3d, deviation: Vec3d, res: Vec3d = Vec3d()): Vec3d {
        res.x = gaussRand(mean.x, deviation.x)
        res.y = gaussRand(mean.y, deviation.y)
        res.z = gaussRand(mean.z, deviation.z)
        return res
    }

    /** Generate random numbers in the interval [min, max], according a gaussian distribution */
    fun gaussRand(mean: Vec4, deviation: Vec4, res: Vec4 = Vec4()): Vec4 {
        res.x = gaussRand(mean.x, deviation.x)
        res.y = gaussRand(mean.y, deviation.y)
        res.z = gaussRand(mean.z, deviation.z)
        res.w = gaussRand(mean.w, deviation.w)
        return res
    }

    /** Generate random numbers in the interval [min, max], according a gaussian distribution */
    fun gaussRand(mean: Vec4d, deviation: Vec4d, res: Vec4d = Vec4d()): Vec4d {
        res.x = gaussRand(mean.x, deviation.x)
        res.y = gaussRand(mean.y, deviation.y)
        res.z = gaussRand(mean.z, deviation.z)
        res.w = gaussRand(mean.w, deviation.w)
        return res
    }

    /** Generate a random 2D vector which coordinates are regulary distributed on a circle of a given radius */
    fun circularRand(radius: Float, res: Vec2 = Vec2()): Vec2 {

        assert(radius > 0f)

        val a = linearRand(0f, 6.283185307179586476925286766559f)
        res.put(glm.cos(a), glm.sin(a))
        res *= radius
        return res
    }

    /** Generate a random 2D vector which coordinates are regulary distributed on a circle of a given radius */
    fun circularRand(radius: Double, res: Vec2d = Vec2d()): Vec2d {

        assert(radius > 0.0)

        val a = linearRand(0.0, 6.283185307179586476925286766559)
        res.put(glm.cos(a), glm.sin(a))
        res *= radius
        return res
    }

    /** Generate a random 3D vector which coordinates are regulary distributed on a sphere of a given radius */
    fun sphericalRand(radius: Float, res: Vec3 = Vec3()): Vec3 {

        assert(radius > 0f)

        val theta = linearRand(0f, 6.283185307179586476925286766559f)
        val phi = acos(linearRand(-1f, 1f))

        val sinPhi = sin(phi)
        val x = sinPhi * cos(theta)
        val y = sinPhi * sin(theta)
        val z = cos(phi)

        res.put(x, y, z)
        res *= radius
        return res
    }

    /** Generate a random 3D vector which coordinates are regulary distributed on a sphere of a given radius */
    fun sphericalRand(radius: Double, res: Vec3d = Vec3d()): Vec3d {

        assert(radius > 0.0)

        val theta = linearRand(0.0, 6.283185307179586476925286766559)
        val phi = acos(linearRand(-1.0, 1.0))

        val sinPhi = sin(phi)
        val x = sinPhi * cos(theta)
        val y = sinPhi * sin(theta)
        val z = cos(phi)

        res.put(x, y, z)
        res *= radius
        return res
    }

    /** Generate a random 2D vector which coordinates are regulary distributed within the area of a disk of a given radius */
    fun diskRand(radius: Float, res: Vec2 = Vec2()): Vec2 {

        assert(radius > 0f)

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

    /** Generate a random 2D vector which coordinates are regulary distributed within the area of a disk of a given radius */
    fun diskRand(radius: Double, res: Vec2d = Vec2d()): Vec2d {

        assert(radius > 0.0)

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

    /** Generate a random 2D vector which coordinates are regulary distributed within the area of a disk of a given radius */
    fun diskRand(radius: Float, res: Vec3 = Vec3()): Vec3 {

        assert(radius > 0f)

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

    /** Generate a random 2D vector which coordinates are regulary distributed within the area of a disk of a given radius */
    fun diskRand(radius: Double, res: Vec3d = Vec3d()): Vec3d {

        assert(radius > 0.0)

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

    /** Generate a random 2D vector which coordinates are regulary distributed within the area of a disk of a given radius */
    fun diskRand(radius: Float, res: Vec4 = Vec4()): Vec4 {

        assert(radius > 0f)

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

    /** Generate a random 2D vector which coordinates are regulary distributed within the area of a disk of a given radius */
    fun diskRand(radius: Double, res: Vec4d = Vec4d()): Vec4d {

        assert(radius > 0.0)

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

    /** Generate a random 3D vector which coordinates are regulary distributed within the volume of a ball of a given radius */
    fun ballRand(radius: Float, res: Vec3 = Vec3()): Vec3 {

        assert(radius > 0f)

        res put 0f
        var lenRadius: Float

        do {
            res put linearRand(Vec3(-radius), Vec3(radius))
            lenRadius = res.length()
        } while (lenRadius > radius)

        return res
    }

    /** Generate a random 3D vector which coordinates are regulary distributed within the volume of a ball of a given radius */
    fun ballRand(radius: Double, res: Vec3d = Vec3d()): Vec3d {

        assert(radius > 0.0)

        res put 0.0
        var lenRadius: Double

        do {
            res put linearRand(Vec3d(-radius), Vec3d(radius))
            lenRadius = res.length()
        } while (lenRadius > radius)

        return res
    }
}

