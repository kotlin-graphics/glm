package glm_.gtx

import glm_.glm
import glm_.vec2.Vec2
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class testGtxExteriorProduct : StringSpec() {

    init {
        "cross" {
            val f = Vec2(1f) cross Vec2(1f)
            glm.equal(f, 0f, 0.001f) shouldBe true
        }
    }
}
