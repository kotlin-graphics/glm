package glm

import glm.mat.Mat2
import glm.vec2.Vec2
import glm.mat.operators.times
import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.StringSpec

/**
 * Created by GBarbieri on 11.11.2016.
 */

class coreMat2 : StringSpec() {

    init {

        "test operators" {

            val l = Mat2(1f)
            val m = Mat2(1f)
            val u = Vec2(1f)
            val v = Vec2(1f)
            val x = 1f
            val a = m * u
            val b = v * m
            val p = x * m
            val q = m * x
            val R = m != q
            val S = m == l

            (S && !R) shouldBe true
        }

        "test inverse" {

            run {
                val matrix = Mat2(1, 2, 3, 4)
                val inverse = matrix.inverse()
                val identity = matrix * inverse

                glm.all(glm.epsilonEqual(identity[0], Vec2(1.0f, 0.0f), Vec2(0.01f))) shouldBe true
                glm.all(glm.epsilonEqual(identity[1], Vec2(0.0f, 1.0f), Vec2(0.01f))) shouldBe true
            }
            run {
                val matrix = Mat2(1, 2, 3, 4)
                val identity = matrix / matrix

                glm.all(glm.epsilonEqual(identity[0], Vec2(1.0f, 0.0f), Vec2(0.01f))) shouldBe true
                glm.all(glm.epsilonEqual(identity[1], Vec2(0.0f, 1.0f), Vec2(0.01f))) shouldBe true
            }
        }

    }
}