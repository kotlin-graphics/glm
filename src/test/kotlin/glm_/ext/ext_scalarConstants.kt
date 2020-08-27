package glm_.ext

import glm_.glm
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.doubles.shouldBeGreaterThan
import io.kotest.matchers.doubles.shouldBeLessThan
import io.kotest.matchers.floats.shouldBeGreaterThan
import io.kotest.matchers.floats.shouldBeLessThan

class ext_scalarConstants : StringSpec() {

    init {

        "epsilon" {

            run {
                val test = glm.εf
                test shouldBeGreaterThan 0f
            }
            run {
                val test = glm.ε
                test shouldBeGreaterThan 0.0
            }
        }

        "pi" {
            run {
                val test = glm.πf
                test shouldBeGreaterThan 3.14f
                test shouldBeLessThan 3.15f
            }
            run {
                val test = glm.π
                test shouldBeGreaterThan 3.14
                test shouldBeLessThan 3.15
            }
        }
    }
}