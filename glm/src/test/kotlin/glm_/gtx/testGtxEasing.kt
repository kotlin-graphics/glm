package glm_.gtx

import glm_.glm
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class testGtxEasing : StringSpec() {

    init {

        "easing" {

            val a = 0.5f

            glm.linearInterpolation(a) shouldBe 0.5f

            glm.quadraticEaseIn(a) shouldBe 0.25f
            glm.quadraticEaseOut(a) shouldBe 0.75f
            glm.quadraticEaseInOut(a) shouldBe 0.5f

            glm.cubicEaseIn(a) shouldBe 0.125f
            glm.cubicEaseOut(a) shouldBe 0.875f
            glm.cubicEaseInOut(a) shouldBe 0.5f

            glm.quarticEaseIn(a) shouldBe 0.0625f
            glm.quarticEaseOut(a) shouldBe 0.9375f
            glm.quinticEaseInOut(a) shouldBe 0.5f

            glm.sineEaseIn(a) shouldBe 0.292893231f
            glm.sineEaseOut(a) shouldBe 0.707106769f
            glm.sineEaseInOut(a) shouldBe 0.5f

            glm.circularEaseIn(a) shouldBe 0.133974612f
            glm.circularEaseOut(a) shouldBe 0.866025388f
            glm.circularEaseInOut(a) shouldBe 0.5f

            glm.exponentialEaseIn(a) shouldBe 0.03125f
            glm.exponentialEaseOut(a) shouldBe 0.96875f
            glm.exponentialEaseInOut(a) shouldBe 0.5f

            glm.elasticEaseIn(a) shouldBe -0.0220970940f
            glm.elasticEaseOut(a) shouldBe 1.02209711f
            glm.elasticEaseInOut(a) shouldBe 0.5f

            glm.backEaseIn(a) shouldBe -0.0876975060f
            glm.backEaseOut(a) shouldBe 1.08769751f
            glm.backEaseInOut(a) shouldBe 0.5f

            glm.bounceEaseIn(a) shouldBe 0.281249762f
            glm.bounceEaseOut(a) shouldBe 0.718750238f
            glm.bounceEaseInOut(a) shouldBe 0.5f
        }
    }
}