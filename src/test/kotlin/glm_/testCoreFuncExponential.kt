package glm_

import glm_.glm.Ef
import glm_.glm.εf
import glm_.vec1.Vec1
import glm_.vec2.Vec2
import glm_.vec3.Vec3
import glm_.vec4.Vec4
import io.kotest.matchers.shouldBe
import io.kotest.core.spec.style.StringSpec

class testCoreFuncExponential : StringSpec() {

    init {
        "pow" {

            val a = glm.pow(2f, 2f)
            a.shouldEqual(4f, 0.01f)

            val b = glm.pow(Vec1(2f), Vec1(2f))
            b.shouldEqual(Vec1(4f), 0.01f)

            val c = glm.pow(Vec2(2f), Vec2(2f))
            c.shouldEqual(Vec2(4f), 0.01f)

            val d = glm.pow(Vec3(2f), Vec3(2f))
            d.shouldEqual(Vec3(4f), 0.01f)

            val e = glm.pow(Vec4(2f), Vec4(2f))
            e.shouldEqual(Vec4(4f), 0.01f)
        }

        "sqrt" {

            val a = glm.sqrt(4f)
            a.shouldEqual(2f, 0.01f)

            val b = glm.sqrt(Vec1(4f))
            b.shouldEqual(Vec1(2f), 0.01f)

            val c = glm.sqrt(Vec2(4f))
            c.shouldEqual(Vec2(2f), 0.01f)

            val d = glm.sqrt(Vec3(4f))
            d.shouldEqual(Vec3(2f), 0.01f)

            val e = glm.sqrt(Vec4(4f))
            e.shouldEqual(Vec4(2f), 0.01f)
        }

        "exp" {

            val a = glm.exp(1f)

            glm.equal(a, Ef, 0.01f) shouldBe true

            val b = glm.exp(Vec1(1f))
            b.shouldEqual(Vec1(Ef), 0.01f)

            val c = glm.exp(Vec2(1f))
            c.shouldEqual(Vec2(Ef), 0.01f)

            val d = glm.exp(Vec3(1f))
            d.shouldEqual(Vec3(Ef), 0.01f)

            val e = glm.exp(Vec4(1f))
            e.shouldEqual(Vec4(Ef), 0.01f)
        }

        "log" {

            val a = glm.log(Ef)
            a.shouldEqual(1f, 0.01f)

            val b = glm.log(Vec1(Ef))
            b.shouldEqual(Vec1(1f), 0.01f)

            val c = glm.log(Vec2(Ef))
            c.shouldEqual(Vec2(1f), 0.01f)

            val d = glm.log(Vec3(Ef))
            d.shouldEqual(Vec3(1f), 0.01f)

            val e = glm.log(Vec4(Ef))
            e.shouldEqual(Vec4(1f), 0.01f)
        }

        "exp2" {

            val a = glm.exp2(4f)
            a.shouldEqual(16f, 0.01f)

            val b = glm.exp2(Vec1(4f))
            b.shouldEqual(Vec1(16f), 0.01f)

            val c = glm.exp2(Vec2(4f, 3f))
            c.shouldEqual(Vec2(16f, 8f), 0.01f)

            val d = glm.exp2(Vec3(4f, 3f, 2f))
            d.shouldEqual(Vec3(16f, 8f, 4f), 0.01f)

            val e = glm.exp2(Vec4(4f, 3f, 2f, 1f))
            e.shouldEqual(Vec4(16f, 8f, 4f, 2f), 0.01f)
        }

        "log2" {

            val a = glm.log2(16f)
            a.shouldEqual(4f, 0.01f)

            val b = glm.log2(Vec1(16f))
            b.shouldEqual(Vec1(4f), 0.01f)

            val c = glm.log2(Vec2(16f, 8f))
            c.shouldEqual(Vec2(4f, 3f), 0.01f)

            val d = glm.log2(Vec3(16f, 8f, 4f))
            d.shouldEqual(Vec3(4f, 3f, 2f), 0.01f)

            val e = glm.log2(Vec4(16f, 8f, 4f, 2f))
            e.shouldEqual(Vec4(4f, 3f, 2f, 1f), 0.01f)
        }

        "inverse sqrt" {

            val a = glm.inverseSqrt(16f) * glm.sqrt(16f)
            a.shouldEqual(1f, 0.01f)

            val b = glm.inverseSqrt(Vec1(16f)) * glm.sqrt(16f)
            b.shouldEqual(Vec1(1.f), 0.01f)

            val c = glm.inverseSqrt(Vec2(16f)) * glm.sqrt(16f)
            c.shouldEqual(Vec2(1f), 0.01f)

            val d = glm.inverseSqrt(Vec3(16f)) * glm.sqrt(16f)
            d.shouldEqual(Vec3(1.f), 0.01f)

            val e = glm.inverseSqrt(Vec4(16f)) * glm.sqrt(16f)
            e.shouldEqual(Vec4(1f), 0.01f)
        }
    }
}