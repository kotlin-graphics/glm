package glm_

import glm_.mat2x2.Mat2
import glm_.mat2x2.operators.times
import glm_.vec2.Vec2
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

/**
 * Created by GBarbieri on 11.11.2016.
 */

class testCoreMat2 : StringSpec() {

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


        "constructor" {

            Mat2 { i -> i } shouldBe Mat2(0, 1, 2, 3)
            Mat2(arrayListOf(0f, 1f, 2f, 3f)) shouldBe Mat2(0, 1, 2, 3)

        }
    }
}