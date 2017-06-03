package glm_

import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.StringSpec
import glm_.vec2.Vec2
import glm_.vec2.Vec2ub

/**
 * Created by elect on 11/11/16.
 */

class coreFunCommon : StringSpec() {

    init {

        "floor" {

            run {
                val a = 1.1f
                glm.floor(a) shouldBe  1f
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
    }
}