package glm_

import glm_.glm.epsilonF
import glm_.vec2.Vec2
import glm_.vec2.Vec2ub
import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.StringSpec

/**
 * Created by elect on 11/11/16.
 */

class coreFunCommon : StringSpec() {

    init {

        "floor" {

            run {
                val a = 1.1f
                glm.floor(a) shouldBe 1f
            }

            run {
                val a = 1.1
                glm.floor(a) shouldBe 1.d
            }

            run {
                val a = Vec2(1.1f)
                val b = glm.floor(a)

                val c = Vec2ub(2)
                val d = Vec2ub(3, 1)
                val g = glm.lessThan(a, b)
                val f = a lessThan b
                val e = c.lessThan(d)
            }
        }

        "step scalar"{
            val edge = 2f

            val A = glm.step(edge, 1f)
            glm.epsilonEqual(A, 0f, epsilonF) shouldBe true

            val B = glm.step(edge, 3f)
            glm.epsilonEqual(B, 1f, epsilonF) shouldBe true

            val C = glm.step(edge, 2f)
            glm.epsilonEqual(C, 1f, epsilonF) shouldBe true
        }
    }
}