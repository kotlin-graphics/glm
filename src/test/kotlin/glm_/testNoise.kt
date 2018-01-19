package glm_

import glm_.vec2.Vec2
import glm_.vec3.Vec3
import glm_.vec4.Vec4
import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.StringSpec

class testNoise : StringSpec() {

    init {

        "grad4" {

            val j = 1f
            val ip = Vec4(2f, 3f, 4f, 5f)
        }

        "classic perlin" {

            run {
                val pos = Vec2(0 / 255f, 63f / 255)
                val res = glm.perlin(pos)
                ((res - 0.342978686f) < 0.000001f) shouldBe true
            }

            run {
                val pos = Vec3(0 / 255f, 63f / 255, 127f / 255)
                val res = glm.perlin(pos)
                ((res - -0.268357933f) < 0.000001f) shouldBe true
            }

            run {
                val pos = Vec4(0f, 63f / 255, 127f / 255, 1f)
                val res = glm.perlin(pos)
                ((res - -0.430175841f) < 0.000001f) shouldBe true
            }
        }

        "periodic perlin" {

            run {
                val pos = Vec2(0 / 255f, 63f / 255)
                val res = glm.perlin(pos, Vec2(2f))
                ((res - 0.342978686f) < 0.000001f) shouldBe true
            }

            run {
                val pos = Vec3(0 / 255f, 63f / 255, 127f / 255)
                val res = glm.perlin(pos, Vec3(2f))
                ((res - -0.268357933f) < 0.000001f) shouldBe true
            }

            run {
                val pos = Vec4(0f, 63f / 255, 127f / 255, 1f)
                val res = glm.perlin(pos, Vec4(2f))
                ((res - -0.430175841f) < 0.000001f) shouldBe true
            }
        }

        "simplex" {

            run {
                val pos = Vec2(0 / 255f, 63f / 255)
                val res = glm.simplex(pos)
                ((res - 0.963419318f) < 0.000001f) shouldBe true
            }

            run {
                val pos = Vec3(0 / 255f, 63f / 255, 127f / 255)
                val res = glm.simplex(pos)
                ((res - -0.297128230f) < 0.000001f) shouldBe true
            }

            run {
                val pos = Vec4(0f, 63f / 255, 127f / 255, 1f)
                val res = glm.simplex(pos)
                ((res - 0.200833604f) < 0.000001f) shouldBe true
            }
        }
    }
}