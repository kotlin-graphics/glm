package glm_

import glm_.glm.Ef
import glm_.vec1.Vec1
import glm_.vec2.Vec2
import glm_.vec3.Vec3
import glm_.vec4.Vec4
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class testCoreFuncExponential : StringSpec() {

    init {
        "pow" {

            val a = glm.pow(2f, 2f)
            glm.equal(a, 4f, 0.01f) shouldBe true

            val b = glm.pow(Vec1(2f), Vec1(2f))
            glm.all(glm.equal(b, Vec1(4f), 0.01f)) shouldBe true

            val c = glm.pow(Vec2(2f), Vec2(2f))
            glm.all(glm.equal(c, Vec2(4f), 0.01f)) shouldBe true

            val d = glm.pow(Vec3(2f), Vec3(2f))
            glm.all(glm.equal(d, Vec3(4f), 0.01f)) shouldBe true

            val e = glm.pow(Vec4(2f), Vec4(2f))
            glm.all(glm.equal(e, Vec4(4.f), 0.01f)) shouldBe true
        }

        "sqrt" {

            val a = glm.sqrt(4f)
            glm.equal(a, 2f, 0.01f) shouldBe true

            val b = glm.sqrt(Vec1(4f))
            glm.all(glm.equal(b, Vec1(2f), 0.01f)) shouldBe true

            val c = glm.sqrt(Vec2(4f))
            glm.all(glm.equal(c, Vec2(2f), 0.01f)) shouldBe true

            val d = glm.sqrt(Vec3(4f))
            glm.all(glm.equal(d, Vec3(2f), 0.01f)) shouldBe true

            val e = glm.sqrt(Vec4(4f))
            glm.all(glm.equal(e, Vec4(2f), 0.01f)) shouldBe true
        }

        "exp" {

            val a = glm.exp(1f)

            glm.equal(a, Ef, 0.01f) shouldBe true

            val b = glm.exp(Vec1(1f))
            glm.all(glm.equal(b, Vec1(Ef), 0.01f)) shouldBe true

            val c = glm.exp(Vec2(1f))
            glm.all(glm.equal(c, Vec2(Ef), 0.01f)) shouldBe true

            val d = glm.exp(Vec3(1f))
            glm.all(glm.equal(d, Vec3(Ef), 0.01f)) shouldBe true

            val e = glm.exp(Vec4(1f))
            glm.all(glm.equal(e, Vec4(Ef), 0.01f)) shouldBe true
        }

        "log" {

            val a = glm.log(Ef)
            glm.equal(a, 1f, 0.01f) shouldBe true

            val b = glm.log(Vec1(Ef))
            glm.all(glm.equal(b, Vec1(1f), 0.01f)) shouldBe true

            val c = glm.log(Vec2(Ef))
            glm.all(glm.equal(c, Vec2(1f), 0.01f)) shouldBe true

            val d = glm.log(Vec3(Ef))
            glm.all(glm.equal(d, Vec3(1f), 0.01f)) shouldBe true

            val e = glm.log(Vec4(Ef))
            glm.all(glm.equal(e, Vec4(1.f), 0.01f)) shouldBe true
        }

        "exp2" {

            val a = glm.exp2(4f)
            glm.equal(a, 16f, 0.01f) shouldBe true

            val b = glm.exp2(Vec1(4f))
            glm.all(glm.equal(b, Vec1(16f), 0.01f)) shouldBe true

            val c = glm.exp2(Vec2(4f, 3f))
            glm.all(glm.equal(c, Vec2(16f, 8f), 0.01f)) shouldBe true

            val d = glm.exp2(Vec3(4f, 3f, 2f))
            glm.all(glm.equal(d, Vec3(16f, 8f, 4f), 0.01f)) shouldBe true

            val e = glm.exp2(Vec4(4f, 3f, 2f, 1f))
            glm.all(glm.equal(e, Vec4(16f, 8f, 4f, 2f), 0.01f)) shouldBe true
        }

        "log2" {

            val a = glm.log2(16f)
            glm.equal(a, 4f, 0.01f) shouldBe true

            val b = glm.log2(Vec1(16f))
            glm.all(glm.equal(b, Vec1(4f), 0.01f)) shouldBe true

            val c = glm.log2(Vec2(16f, 8f))
            glm.all(glm.equal(c, Vec2(4f, 3f), 0.01f)) shouldBe true

            val d = glm.log2(Vec3(16f, 8f, 4f))
            glm.all(glm.equal(d, Vec3(4f, 3f, 2f), 0.01f)) shouldBe true

            val e = glm.log2(Vec4(16f, 8f, 4f, 2f))
            glm.all(glm.equal(e, Vec4(4f, 3f, 2f, 1f), 0.01f)) shouldBe true
        }

        "inverse sqrt" {

            val a = glm.inverseSqrt(16f) * glm.sqrt(16f)
            glm.equal(a, 1f, 0.01f) shouldBe true

            val b = glm.inverseSqrt(Vec1(16f)) * glm.sqrt(16f)
            glm.all(glm.equal(b, Vec1(1.f), 0.01f)) shouldBe true

            val c = glm.inverseSqrt(Vec2(16f)) * glm.sqrt(16f)
            glm.all(glm.equal(c, Vec2(1f), 0.01f)) shouldBe true

            val d = glm.inverseSqrt(Vec3(16f)) * glm.sqrt(16f)
            glm.all(glm.equal(d, Vec3(1.f), 0.01f)) shouldBe true

            val e = glm.inverseSqrt(Vec4(16f)) * glm.sqrt(16f)
            glm.all(glm.equal(e, Vec4(1f), 0.01f)) shouldBe true
        }
    }
}