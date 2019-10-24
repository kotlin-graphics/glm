package glm_

import glm_.vec2.Vec2
import glm_.vec3.Vec3
import glm_.vec4.Vec4
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class testColorSpace : StringSpec() {

    init {

        "test" {

            val colorSourceRGB = Vec3(1.0f, 0.5f, 0.0f)

            run {
                val colorSRGB = glm.convertLinearToSRGB(colorSourceRGB)
                val colorRGB = glm.convertSRGBToLinear(colorSRGB)
                glm.all(glm.equal(colorSourceRGB, colorRGB, 0.00001f)) shouldBe true
            }

            run {
                val colorSRGB = glm.convertLinearToSRGB(colorSourceRGB, 2.8f)
                val colorRGB = glm.convertSRGBToLinear(colorSRGB, 2.8f)
                glm.all(glm.equal(colorSourceRGB, colorRGB, 0.00001f)) shouldBe true
            }

            val colorSourceRGBA = Vec4(1.0f, 0.5f, 0.0f, 1.0f)

            run {
                val colorSRGB = glm.convertLinearToSRGB(colorSourceRGBA)
                val colorRGB = glm.convertSRGBToLinear(colorSRGB)
                glm.all(glm.equal(colorSourceRGBA, colorRGB, 0.00001f)) shouldBe true
            }

            run {
                val colorSRGB = glm.convertLinearToSRGB(colorSourceRGBA, 2.8f)
                val colorRGB = glm.convertSRGBToLinear(colorSRGB, 2.8f)
                glm.all(glm.equal(colorSourceRGBA, colorRGB, 0.00001f)) shouldBe true
            }

            val a = Vec2()
            a put listOf("516", "139")
            println(a)
        }
    }
}
