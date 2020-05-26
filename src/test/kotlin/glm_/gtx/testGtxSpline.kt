package glm_.gtx

import glm_.glm
import glm_.vec2.Vec2
import glm_.vec3.Vec3
import glm_.vec4.Vec4
import io.kotest.matchers.shouldBe
import io.kotest.core.spec.style.StringSpec

class testGtxSpline : StringSpec() {

    init {

        "catmullRom" {

            val result2 = glm.catmullRom(
                    Vec2(0f, 0f),
                    Vec2(1f, 0f),
                    Vec2(1f, 1f),
                    Vec2(0f, 1f), 0.5f)

            result2 shouldBe Vec2(1.125f, 0.5f)

            val result3 = glm.catmullRom(
                    Vec3(0f, 0f, 0f),
                    Vec3(1f, 0f, 0f),
                    Vec3(1f, 1f, 0f),
                    Vec3(0f, 1f, 0f), 0.5f)

            result3 shouldBe Vec3(1.125f, 0.5f, 0f)

            val result4 = glm.catmullRom(
                    Vec4(0f, 0f, 0f, 1f),
                    Vec4(1f, 0f, 0f, 1f),
                    Vec4(1f, 1f, 0f, 1f),
                    Vec4(0f, 1f, 0f, 1f), 0.5f)

            result4 shouldBe Vec4(1.125f, 0.5f, 0f, 1f)
        }

        "hermite" {

            val result2 = glm.hermite(
                    Vec2(0f, 0f),
                    Vec2(1f, 0f),
                    Vec2(1f, 1f),
                    Vec2(0f, 1f), 0.5f)

            result2 shouldBe Vec2(0.625f, 0.375f)

            val result3 = glm.hermite(
                    Vec3(0f, 0f, 0f),
                    Vec3(1f, 0f, 0f),
                    Vec3(1f, 1f, 0f),
                    Vec3(0f, 1f, 0f), 0.5f)

            result3 shouldBe Vec3(0.625f, 0.375f, 0f)

            val result4 = glm.hermite(
                    Vec4(0f, 0f, 0f, 1f),
                    Vec4(1f, 0f, 0f, 1f),
                    Vec4(1f, 1f, 0f, 1f),
                    Vec4(0f, 1f, 0f, 1f), 0.5f)

            result4 shouldBe Vec4(0.625f, 0.375f, 0f, 1f)
        }

        "cubic" {

            val result2 = glm.cubic(
                    Vec2(0f, 0f),
                    Vec2(1f, 0f),
                    Vec2(1f, 1f),
                    Vec2(0f, 1f), 0.5f)

            result2 shouldBe Vec2(0.75f, 1.5f)

            val result3 = glm.cubic(
                    Vec3(0f, 0f, 0f),
                    Vec3(1f, 0f, 0f),
                    Vec3(1f, 1f, 0f),
                    Vec3(0f, 1f, 0f), 0.5f)

            result3 shouldBe Vec3(0.75f, 1.5f, 0f)

            val result4 = glm.cubic(
                    Vec4(0f, 0f, 0f, 1f),
                    Vec4(1f, 0f, 0f, 1f),
                    Vec4(1f, 1f, 0f, 1f),
                    Vec4(0f, 1f, 0f, 1f), 0.5f)

            result4 shouldBe Vec4(0.75f, 1.5f, 0f, 1.875f)
        }
    }
}