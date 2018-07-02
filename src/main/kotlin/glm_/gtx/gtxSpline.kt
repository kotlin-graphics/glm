package glm_.gtx

import glm_.glm.pow2
import glm_.glm.pow3
import glm_.vec1.Vec1
import glm_.vec2.Vec2
import glm_.vec3.Vec3
import glm_.vec4.Vec4

interface gxtSpline {

    /** Return a point from a catmull rom curve.
     *  @see gtx_spline extension. */
    fun catmullRom(v1: Vec1, v2: Vec1, v3: Vec1, v4: Vec1, s: Float) = catmullRom(Vec1(), v1, v2, v3, v4, s)

    /** Return a point from a catmull rom curve.
     *  @see gtx_spline extension. */
    fun catmullRom(
            res: Vec1,
            v1: Vec1,
            v2: Vec1,
            v3: Vec1,
            v4: Vec1,
            s: Float): Vec1 {

        val s2 = pow2(s)
        val s3 = pow3(s)

        val f1 = -s3 + 2f * s2 - s
        val f2 = 3f * s3 - 5f * s2 + 2f
        val f3 = -3f * s3 + 4f * s2 + s
        val f4 = s3 - s2

        return res((f1 * v1.x + f2 * v2.x + f3 * v3.x + f4 * v4.x) / 2f)
    }

    /** Return a point from a catmull rom curve.
     *  @see gtx_spline extension. */
    fun catmullRom(v1: Vec2, v2: Vec2, v3: Vec2, v4: Vec2, s: Float): Vec2 = catmullRom(Vec2(), v1, v2, v3, v4, s)

    /** Return a point from a catmull rom curve.
     *  @see gtx_spline extension. */
    fun catmullRom(
            res: Vec2,
            v1: Vec2,
            v2: Vec2,
            v3: Vec2,
            v4: Vec2,
            s: Float): Vec2 {

        val s2 = pow2(s)
        val s3 = pow3(s)

        val f1 = -s3 + 2f * s2 - s
        val f2 = 3f * s3 - 5f * s2 + 2f
        val f3 = -3f * s3 + 4f * s2 + s
        val f4 = s3 - s2

        return res(
                (f1 * v1.x + f2 * v2.x + f3 * v3.x + f4 * v4.x) / 2f,
                (f1 * v1.y + f2 * v2.y + f3 * v3.y + f4 * v4.y) / 2f)
    }

    /** Return a point from a catmull rom curve.
     *  @see gtx_spline extension. */
    fun catmullRom(v1: Vec3, v2: Vec3, v3: Vec3, v4: Vec3, s: Float): Vec3 = catmullRom(Vec3(), v1, v2, v3, v4, s)

    /** Return a point from a catmull rom curve.
     *  @see gtx_spline extension. */
    fun catmullRom(
            res: Vec3,
            v1: Vec3,
            v2: Vec3,
            v3: Vec3,
            v4: Vec3,
            s: Float): Vec3 {

        val s2 = pow2(s)
        val s3 = pow3(s)

        val f1 = -s3 + 2f * s2 - s
        val f2 = 3f * s3 - 5f * s2 + 2f
        val f3 = -3f * s3 + 4f * s2 + s
        val f4 = s3 - s2

        return res(
                (f1 * v1.x + f2 * v2.x + f3 * v3.x + f4 * v4.x) / 2f,
                (f1 * v1.y + f2 * v2.y + f3 * v3.y + f4 * v4.y) / 2f,
                (f1 * v1.z + f2 * v2.z + f3 * v3.z + f4 * v4.z) / 2f)
    }

    /** Return a point from a catmull rom curve.
     *  @see gtx_spline extension. */
    fun catmullRom(v1: Vec4, v2: Vec4, v3: Vec4, v4: Vec4, s: Float): Vec4 = catmullRom(Vec4(), v1, v2, v3, v4, s)

    /** Return a point from a catmull rom curve.
     *  @see gtx_spline extension. */
    fun catmullRom(
            res: Vec4,
            v1: Vec4,
            v2: Vec4,
            v3: Vec4,
            v4: Vec4,
            s: Float): Vec4 {

        val s2 = pow2(s)
        val s3 = pow3(s)

        val f1 = -s3 + 2f * s2 - s
        val f2 = 3f * s3 - 5f * s2 + 2f
        val f3 = -3f * s3 + 4f * s2 + s
        val f4 = s3 - s2

        return res(
                (f1 * v1.x + f2 * v2.x + f3 * v3.x + f4 * v4.x) / 2f,
                (f1 * v1.y + f2 * v2.y + f3 * v3.y + f4 * v4.y) / 2f,
                (f1 * v1.z + f2 * v2.z + f3 * v3.z + f4 * v4.z) / 2f,
                (f1 * v1.w + f2 * v2.w + f3 * v3.w + f4 * v4.w) / 2f)
    }

    /** Return a point from a hermite curve.
     *  @see gtx_spline extension. */
    fun hermite(v1: Vec1, t1: Vec1, v2: Vec1, t2: Vec1, s: Float): Vec1 = hermite(Vec1(), v1, t1, v2, t2, s)

    /** Return a point from a hermite curve.
     *  @see gtx_spline extension. */
    fun hermite(res: Vec1,
                v1: Vec1,
                t1: Vec1,
                v2: Vec1,
                t2: Vec1,
                s: Float): Vec1 {

        val s2 = pow2(s)
        val s3 = pow3(s)

        val f1 = 2f * s3 - 3f * s2 + 1f
        val f2 = -2f * s3 + 3f * s2
        val f3 = s3 - 2f * s2 + s
        val f4 = s3 - s2

        return res(f1 * v1.x + f2 * v2.x + f3 * t1.x + f4 * t2.x)
    }

    /** Return a point from a hermite curve.
     *  @see gtx_spline extension. */
    fun hermite(v1: Vec2, t1: Vec2, v2: Vec2, t2: Vec2, s: Float): Vec2 = hermite(Vec2(), v1, t1, v2, t2, s)

    /** Return a point from a hermite curve.
     *  @see gtx_spline extension. */
    fun hermite(res: Vec2,
                v1: Vec2,
                t1: Vec2,
                v2: Vec2,
                t2: Vec2,
                s: Float): Vec2 {

        val s2 = pow2(s)
        val s3 = pow3(s)

        val f1 = 2f * s3 - 3f * s2 + 1f
        val f2 = -2f * s3 + 3f * s2
        val f3 = s3 - 2f * s2 + s
        val f4 = s3 - s2

        return res(
                f1 * v1.x + f2 * v2.x + f3 * t1.x + f4 * t2.x,
                f1 * v1.y + f2 * v2.y + f3 * t1.y + f4 * t2.y)
    }

    /** Return a point from a hermite curve.
     *  @see gtx_spline extension. */
    fun hermite(v1: Vec3, t1: Vec3, v2: Vec3, t2: Vec3, s: Float): Vec3 = hermite(Vec3(), v1, t1, v2, t2, s)

    /** Return a point from a hermite curve.
     *  @see gtx_spline extension. */
    fun hermite(res: Vec3,
                v1: Vec3,
                t1: Vec3,
                v2: Vec3,
                t2: Vec3,
                s: Float): Vec3 {

        val s2 = pow2(s)
        val s3 = pow3(s)

        val f1 = 2f * s3 - 3f * s2 + 1f
        val f2 = -2f * s3 + 3f * s2
        val f3 = s3 - 2f * s2 + s
        val f4 = s3 - s2

        return res(
                f1 * v1.x + f2 * v2.x + f3 * t1.x + f4 * t2.x,
                f1 * v1.y + f2 * v2.y + f3 * t1.y + f4 * t2.y,
                f1 * v1.z + f2 * v2.z + f3 * t1.z + f4 * t2.z)
    }

    /** Return a point from a hermite curve.
     *  @see gtx_spline extension. */
    fun hermite(v1: Vec4, t1: Vec4, v2: Vec4, t2: Vec4, s: Float): Vec4 = hermite(Vec4(), v1, t1, v2, t2, s)

    /** Return a point from a hermite curve.
     *  @see gtx_spline extension. */
    fun hermite(res: Vec4,
                v1: Vec4,
                t1: Vec4,
                v2: Vec4,
                t2: Vec4,
                s: Float): Vec4 {

        val s2 = pow2(s)
        val s3 = pow3(s)

        val f1 = 2f * s3 - 3f * s2 + 1f
        val f2 = -2f * s3 + 3f * s2
        val f3 = s3 - 2f * s2 + s
        val f4 = s3 - s2

        return res(
                f1 * v1.x + f2 * v2.x + f3 * t1.x + f4 * t2.x,
                f1 * v1.y + f2 * v2.y + f3 * t1.y + f4 * t2.y,
                f1 * v1.z + f2 * v2.z + f3 * t1.z + f4 * t2.z,
                f1 * v1.w + f2 * v2.w + f3 * t1.w + f4 * t2.w)
    }

    /** Return a point from a cubic curve.
     *  @see gtx_spline extension. */
    fun cubic(v1: Vec1, v2: Vec1, v3: Vec1, v4: Vec1, s: Float): Vec1 = cubic(Vec1(), v1, v2, v3, v4, s)

    /** Return a point from a cubic curve.
     *  @see gtx_spline extension. */
    fun cubic(res: Vec1,
              v1: Vec1,
              v2: Vec1,
              v3: Vec1,
              v4: Vec1,
              s: Float): Vec1 = res(((v1.x * s + v2.x) * s + v3.x) * s + v4.x)

    /** Return a point from a cubic curve.
     *  @see gtx_spline extension. */
    fun cubic(v1: Vec2, v2: Vec2, v3: Vec2, v4: Vec2, s: Float): Vec2 = cubic(Vec2(), v1, v2, v3, v4, s)

    /** Return a point from a cubic curve.
     *  @see gtx_spline extension. */
    fun cubic(res: Vec2,
              v1: Vec2,
              v2: Vec2,
              v3: Vec2,
              v4: Vec2,
              s: Float): Vec2 = res(
            ((v1.x * s + v2.x) * s + v3.x) * s + v4.x,
            ((v1.y * s + v2.y) * s + v3.y) * s + v4.y)

    /** Return a point from a cubic curve.
     *  @see gtx_spline extension. */
    fun cubic(v1: Vec3, v2: Vec3, v3: Vec3, v4: Vec3, s: Float): Vec3 = cubic(Vec3(), v1, v2, v3, v4, s)

    /** Return a point from a cubic curve.
     *  @see gtx_spline extension. */
    fun cubic(res: Vec3,
              v1: Vec3,
              v2: Vec3,
              v3: Vec3,
              v4: Vec3,
              s: Float): Vec3 = res(
            ((v1.x * s + v2.x) * s + v3.x) * s + v4.x,
            ((v1.y * s + v2.y) * s + v3.y) * s + v4.y,
            ((v1.z * s + v2.z) * s + v3.z) * s + v4.z)

    /** Return a point from a cubic curve.
     *  @see gtx_spline extension. */
    fun cubic(v1: Vec4, v2: Vec4, v3: Vec4, v4: Vec4, s: Float): Vec4 = cubic(Vec4(), v1, v2, v3, v4, s)

    /** Return a point from a cubic curve.
     *  @see gtx_spline extension. */
    fun cubic(res: Vec4,
              v1: Vec4,
              v2: Vec4,
              v3: Vec4,
              v4: Vec4,
              s: Float): Vec4 = res(
            ((v1.x * s + v2.x) * s + v3.x) * s + v4.x,
            ((v1.y * s + v2.y) * s + v3.y) * s + v4.y,
            ((v1.z * s + v2.z) * s + v3.z) * s + v4.z,
            ((v1.w * s + v2.w) * s + v3.w) * s + v4.w)
}