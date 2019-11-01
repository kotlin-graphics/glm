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
            val R = m.anyNotEqual(q, Float.MIN_VALUE)
            val S = m.allEqual(l, Float.MIN_VALUE)

            (S && !R) shouldBe true
        }

        "test inverse" {

            run {
                val matrix = Mat2(1, 2, 3, 4)
                val inverse = matrix.inverse()
                val identity = matrix * inverse

                glm.all(glm.equal(identity[0], Vec2(1.0f, 0.0f), Vec2(0.01f))) shouldBe true
                glm.all(glm.equal(identity[1], Vec2(0.0f, 1.0f), Vec2(0.01f))) shouldBe true
            }
            run {
                val matrix = Mat2(1, 2, 3, 4)
                val identity = matrix / matrix

                glm.all(glm.equal(identity[0], Vec2(1.0f, 0.0f), Vec2(0.01f))) shouldBe true
                glm.all(glm.equal(identity[1], Vec2(0.0f, 1.0f), Vec2(0.01f))) shouldBe true
            }
        }


        "constructor" {

            run {
                val A = Mat2(1f)
                val B = Mat2(A)
                val C = Mat2(B)

                A shouldEqual C
            }


            val m0 = Mat2(
                    Vec2(0, 1),
                    Vec2(2, 3))
            val m1 = Mat2(0, 1, 2, 3)
            val m2 = Mat2 { i -> i }

            m0 shouldEqual m2
            m1 shouldEqual m2
        }
    }
}