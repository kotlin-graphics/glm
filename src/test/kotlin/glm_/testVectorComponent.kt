package glm_

import glm_.vec1.Vec1
import glm_.vec1.Vec1i
import glm_.vec2.Vec2
import glm_.vec2.Vec2i
import glm_.vec3.Vec3
import glm_.vec3.Vec3i
import glm_.vec4.Vec4
import glm_.vec4.Vec4i
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe


class testVectorComponent : StringSpec() {

    init {

        "v1 component" {
            val v = Vec1 { it.f }
            val (x) = v
            x shouldBe 0f
        }
        "v1i component" {
            val v = Vec1i { it }
            val (x) = v
            x shouldBe 0
        }
        "v2 component" {
            val v = Vec2 { it.f }
            val (x, y) = v
            x shouldBe 0f
            y shouldBe 1f
        }
        "v2i component" {
            val v = Vec2i { it }
            val (x, y) = v
            x shouldBe 0
            y shouldBe 1
        }
        "v3 component" {
            val v = Vec3 { it.f }
            val (x, y, z) = v
            x shouldBe 0f
            y shouldBe 1f
            z shouldBe 2f
        }
        "v3i component" {
            val v = Vec3i { it }
            val (x, y, z) = v
            x shouldBe 0
            y shouldBe 1
            z shouldBe 2
        }
        "v4 component" {
            val v = Vec4 { it.f }
            val (x, y, z, w) = v
            x shouldBe 0f
            y shouldBe 1f
            z shouldBe 2f
            w shouldBe 3f
        }
        "v4i component" {
            val v = Vec4i { it }
            val (x, y, z, w) = v
            x shouldBe 0
            y shouldBe 1
            z shouldBe 2
            w shouldBe 3
        }
    }
}