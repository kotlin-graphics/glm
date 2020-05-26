package glm_.ext

import glm_.glm
import io.kotest.matchers.shouldBe
import io.kotest.core.spec.style.StringSpec

class ext_scalarRelational: StringSpec() {

    init {
        "test equal"        {

            glm.equal(1.01f, 1.02f, 0.1f) shouldBe true
            glm.equal(1.01f, 1.02f, 0.001f) shouldBe false
        }

        "test notEqual"        {

            glm.notEqual(1.01f, 1.02f, 0.001f) shouldBe true
            glm.notEqual(1.01f, 1.02f, 0.1f) shouldBe false
        }
    }
}