package glm_.gtx

import glm_.glm
import glm_.vec2.Vec2i
import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.StringSpec

class testGtxTexture : StringSpec() {

    init {
        "levels" {

            val levels = glm.levels(Vec2i(3, 2))
            levels shouldBe 2
        }
    }
}