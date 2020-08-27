package glm_.gtx

import glm_.glm
import glm_.vec2.Vec2
import glm_.vec3.Vec3
import glm_.vec4.Vec4
import io.kotest.matchers.shouldBe
import io.kotest.core.spec.style.StringSpec

class testGtxVectorAngle : StringSpec() {

    init {

        "angle" {

            val angleA = glm.angle(Vec2(1, 0), Vec2(1, 1).normalize())
            glm.equal(angleA, glm.PIf * 0.25f, 0.01f) shouldBe true
            val angleB = glm.angle(Vec3(1, 0, 0), Vec3(1, 1, 0).normalize())
            glm.equal(angleB, glm.PIf * 0.25f, 0.01f) shouldBe true
            val angleC = glm.angle(Vec4(1, 0, 0, 0), Vec4(1, 1, 0, 0).normalize())
            glm.equal(angleC, glm.PIf * 0.25f, 0.01f) shouldBe true
        }

        "oriented angle Vec2 "{

            val angleA = glm.orientedAngle(Vec2(1, 0), Vec2(1, 1).normalize())
            glm.equal(angleA, glm.PIf * 0.25f, 0.01f) shouldBe true
            val angleB = glm.orientedAngle(Vec2(0, 1), Vec2(1, 1).normalize())
            glm.equal(angleB, -glm.PIf * 0.25f, 0.01f) shouldBe true
            val angleC = glm.orientedAngle(Vec2(1, 1).normalize(), Vec2(0, 1))
            glm.equal(angleC, glm.PIf * 0.25f, 0.01f) shouldBe true
        }

        "oriented angle Vec3"{

            val angleA = glm.orientedAngle(Vec3(1, 0, 0), Vec3(1, 1, 0).normalize(), Vec3(0, 0, 1))
            glm.equal(angleA, glm.PIf * 0.25f, 0.01f) shouldBe true
            val angleB = glm.orientedAngle(Vec3(0, 1, 0), Vec3(1, 1, 0).normalize(), Vec3(0, 0, 1))
            glm.equal(angleB, -glm.PIf * 0.25f, 0.01f) shouldBe true
            val angleC = glm.orientedAngle(Vec3(1, 1, 0).normalize(), Vec3(0, 1, 0), Vec3(0, 0, 1))
            glm.equal(angleC, glm.PIf * 0.25f, 0.01f) shouldBe true
        }
    }
}