package glm_

import glm_.vec2.Vec2
import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.StringSpec

class gtxExteriorProduct : StringSpec() {

    init {
        "cross" {
            val f = Vec2(1f) cross Vec2(1f)
            glm.epsilonEqual(f, 0f, 0.001f) shouldBe true
        }
    }
}