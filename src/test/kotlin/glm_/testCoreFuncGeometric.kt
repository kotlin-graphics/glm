package glm_

import glm_.vec1.Vec1
import glm_.vec2.Vec2
import glm_.vec2.Vec2d
import glm_.vec3.Vec3
import glm_.vec4.Vec4
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class testCoreFuncGeometric : StringSpec() {

    init {
        "length" {

            val length1 = glm.length(Vec1(1))
            val length2 = glm.length(Vec2(1, 0))
            val length3 = glm.length(Vec3(1, 0, 0))
            val length4 = glm.length(Vec4(1, 0, 0, 0))

            (glm.abs(length1 - 1f) < Float.MIN_VALUE) shouldBe true
            (glm.abs(length2 - 1f) < Float.MIN_VALUE) shouldBe true
            (glm.abs(length3 - 1f) < Float.MIN_VALUE) shouldBe true
            (glm.abs(length4 - 1f) < Float.MIN_VALUE) shouldBe true
        }

        "distance" {

            val distance1 = glm.distance(Vec1(1), Vec1(1))
            val distance2 = glm.distance(Vec2(1, 0), Vec2(1, 0))
            val distance3 = glm.distance(Vec3(1, 0, 0), Vec3(1, 0, 0))
            val distance4 = glm.distance(Vec4(1, 0, 0, 0), Vec4(1, 0, 0, 0))

            (glm.abs(distance1) < Float.MIN_VALUE) shouldBe true
            (glm.abs(distance2) < Float.MIN_VALUE) shouldBe true
            (glm.abs(distance3) < Float.MIN_VALUE) shouldBe true
            (glm.abs(distance4) < Float.MIN_VALUE) shouldBe true
        }

        "distance point line" {

            val point = Vec3(0, 1, 0)
            val lineA = Vec3()
            val lineB = Vec3(0, 0, 1)
            val distance = glm.distance(point, lineA, lineB)

            distance shouldBe 1f
        }

        "dot" {

            val dot1 = glm.dot(Vec1(1), Vec1(1))
            val dot2 = glm.dot(Vec2(1), Vec2(1))
            val dot3 = glm.dot(Vec3(1), Vec3(1))
            val dot4 = glm.dot(Vec4(1), Vec4(1))

            (glm.abs(dot1 - 1f) < Float.MIN_VALUE) shouldBe true
            (glm.abs(dot2 - 2f) < Float.MIN_VALUE) shouldBe true
            (glm.abs(dot3 - 3f) < Float.MIN_VALUE) shouldBe true
            (glm.abs(dot4 - 4f) < Float.MIN_VALUE) shouldBe true
        }

        "cross" {
            val cross1 = glm.cross(Vec3(1, 0, 0), Vec3(0, 1, 0))
            val cross2 = glm.cross(Vec3(0, 1, 0), Vec3(1, 0, 0))

            glm.all(glm.lessThan(glm.abs(cross1 - Vec3(0, 0, 1)), Vec3(Float.MIN_VALUE))) shouldBe true
            glm.all(glm.lessThan(glm.abs(cross2 - Vec3(0, 0, -1)), Vec3(Float.MIN_VALUE))) shouldBe true
        }

        "normalize" {

            val normalize1 = glm.normalize(Vec3(1, 0, 0))
            val normalize2 = glm.normalize(Vec3(2, 0, 0))

            val normalize3 = glm.normalize(Vec3(-0.6, 0.7, -0.5))

            val ro = Vec3(glm.cos(5f) * 3f, 2f, glm.sin(5f) * 3f)
            val w = glm.normalize(Vec3(0, -0.2f, 0) - ro)
            val u = glm.normalize(glm.cross(w, Vec3(0, 1, 0)))
            val v = glm.cross(u, w)

            glm.all(glm.lessThan(glm.abs(normalize1 - Vec3(1, 0, 0)), Vec3(Float.MIN_VALUE))) shouldBe true
            glm.all(glm.lessThan(glm.abs(normalize2 - Vec3(1, 0, 0)), Vec3(Float.MIN_VALUE))) shouldBe true
        }

        "face forward" {

            val n = Vec3(0f, 0f, 1f)
            val i = Vec3(1f, 0f, 1f)
            val nRef = Vec3(0f, 0f, 1f)
            val f = glm.faceForward(n, i, nRef)

            f shouldBe Vec3(0f, 0f, -1f)
        }

        "reflect" {

            run {
                val a = Vec2(1f, -1f)
                val b = Vec2(0f, 1f)
                val c = glm.reflect(a, b)
                c.shouldEqual(Vec2(1f), 0.0001f)
            }

            run {
                val a = Vec2d(1.0, -1.0)
                val b = Vec2d(0.0, 1.0)
                val c = glm.reflect(a, b)
                c.shouldEqual(Vec2d(1.0), 0.0001)
            }
        }

        "refract" {

            run {
                val a = -1f
                val b = 1f
                val c = glm.refract(a, b, 0.5f)
                c.shouldEqual(-1f, 0.0001f)
            }

            run {
                val a = Vec2(0f, -1f)
                val b = Vec2(0f, 1f)
                val c = glm.refract(a, b, 0.5f)
                c.shouldEqual(Vec2(0, -1), 0.0001f)
            }

            run {
                val a = Vec2d(0.0, -1.0)
                val b = Vec2d(0.0, 1.0)
                val c = glm.refract(a, b, 0.5)
                c shouldEqual Vec2d(0.0, -1.0)
            }
        }
    }
}
