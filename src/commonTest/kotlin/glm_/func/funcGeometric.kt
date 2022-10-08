package glm_.func

import glm_.scalar.abs
import glm_.assert
import glm_.glm
import glm_.scalar.cos
import glm_.scalar.refract
import glm_.scalar.sin
import glm_.shouldEqual
import glm_.vec1.Vec1
import glm_.vec2.Vec2
import glm_.vec2.Vec2d
import glm_.vec3.Vec3
import glm_.vec4.Vec4
import kotlin.test.Test

class funcGeometric {

    @Test
    fun length() {
        val length1 = Vec1(1).length()
        val length2 = Vec2(1, 0).length()
        val length3 = Vec3(1, 0, 0).length()
        val length4 = Vec4(1, 0, 0, 0).length()

        assert((length1 - 1f).abs() < Float.MIN_VALUE)
        assert((length2 - 1f).abs() < Float.MIN_VALUE)
        assert((length3 - 1f).abs() < Float.MIN_VALUE)
        assert((length4 - 1f).abs() < Float.MIN_VALUE)
    }

    @Test
    fun distance() {
        val distance1 = Vec1(1) distance Vec1(1)
        val distance2 = Vec2(1, 0) distance Vec2(1, 0)
        val distance3 = Vec3(1, 0, 0) distance Vec3(1, 0, 0)
        val distance4 = Vec4(1, 0, 0, 0) distance Vec4(1, 0, 0, 0)

        assert(distance1.abs() < Float.MIN_VALUE)
        assert(distance2.abs() < Float.MIN_VALUE)
        assert(distance3.abs() < Float.MIN_VALUE)
        assert(distance4.abs() < Float.MIN_VALUE)
    }

    @Test
    fun dot() {
        val dot1 = Vec1(1) dot Vec1(1)
        val dot2 = Vec2(1) dot Vec2(1)
        val dot3 = Vec3(1) dot Vec3(1)
        val dot4 = Vec4(1) dot Vec4(1)

        assert((dot1 - 1f).abs() < Float.MIN_VALUE)
        assert((dot2 - 2f).abs() < Float.MIN_VALUE)
        assert((dot3 - 3f).abs() < Float.MIN_VALUE)
        assert((dot4 - 4f).abs() < Float.MIN_VALUE)
    }

    @Test
    fun cross() {
        val cross1 = Vec3(1, 0, 0) cross Vec3(0, 1, 0)
        val cross2 = Vec3(0, 1, 0) cross Vec3(1, 0, 0)

        assert((cross1 - Vec3(0, 0, 1)).abs().all { it < glm.epsilon.f })
        assert((cross2 - Vec3(0, 0, -1)).abs().all { it < glm.epsilon.f })
    }

    @Test
    fun normalize() {

        val normalize1 = Vec3(1, 0, 0).normalize()
        val normalize2 = Vec3(2, 0, 0).normalize()

        val normalize3 = Vec3(-0.6, 0.7, -0.5).normalize()

        val ro = Vec3(5f.cos * 3f, 2f, 5f.sin * 3f)
        val w = (Vec3(0, -0.2f, 0) - ro).normalize()
        val u = (w cross Vec3(0, 1, 0)).normalize()
        val v = u cross w

        assert((normalize1 - Vec3(1, 0, 0)).abs().all { it < glm.epsilon.f })
        assert((normalize2 - Vec3(1, 0, 0)).abs().all { it < glm.epsilon.f })
    }

    @Test
    fun faceForward() {
        val n = Vec3(0f, 0f, 1f)
        val i = Vec3(1f, 0f, 1f)
        val nRef = Vec3(0f, 0f, 1f)
        val f = n.faceForward(i, nRef)
        f shouldEqual Vec3(0f, 0f, -1f)
    }

    @Test
    fun reflect() {
        run {
            val a = Vec2(1f, -1f)
            val b = Vec2(0f, 1f)
            val c = a reflect b
            c.shouldEqual(Vec2(1.0), 0.0001f)
        }

        run {
            val a = Vec2d(1.0, -1.0)
            val b = Vec2d(0.0, 1.0)
            val c = a reflect b
            c.shouldEqual(Vec2d(1.0), 0.0001)
        }
    }

    @Test
    fun refract() {

        run {
            val a = -1f
            val b = 1f
            val c = a.refract(b, 0.5f)
            c.shouldEqual(-1f, 0.0001f)
        }

        run {
            val a = Vec2(0f, -1f)
            val b = Vec2(0f, 1f)
            val c = a.refract(b, 0.5f)
            c.shouldEqual(Vec2(0.0, -1.0), 0.0001f)
        }

        run {
            val a = Vec2d(0.0, -1.0)
            val b = Vec2d(0.0, 1.0)
            val c = a.refract(b, 0.5)
            c.shouldEqual(Vec2d(0.0, -1.0), 0.0001)
        }
    }
}