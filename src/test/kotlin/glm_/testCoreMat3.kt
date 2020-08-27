package glm_

import glm_.mat3x3.Mat3
import glm_.mat3x3.operators.times
import glm_.vec3.Vec3
import io.kotest.matchers.shouldBe
import io.kotest.core.spec.style.StringSpec

/**
 * Created by GBarbieri on 11.11.2016.
 */

class testCoreMat3 : StringSpec() {

    init {

        "test operators" {

            val l = Mat3(1f)
            val m = Mat3(1f)
            val u = Vec3(1f)
            val v = Vec3(1f)
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
                val matrix = Mat3(
                        0.6f, 0.2f, 0.3f,
                        0.2f, 0.7f, 0.5f,
                        0.3f, 0.5f, 0.7f)
                val inverse = matrix.inverse()
                val identity = matrix * inverse

                identity[0].shouldEqual(Vec3(1f, 0f, 0f), 0.01f)
                identity[1].shouldEqual(Vec3(0f, 1f, 0f), 0.01f)
                identity[2].shouldEqual(Vec3(0f, 0f, 1f), 0.01f)
            }
            run {
                val matrix = Mat3(
                        0.6f, 0.2f, 0.3f,
                        0.2f, 0.7f, 0.5f,
                        0.3f, 0.5f, 0.7f)
                val identity = matrix / matrix

                identity[0].shouldEqual(Vec3(1f, 0f, 0f), 0.01f)
                identity[1].shouldEqual(Vec3(0f, 1f, 0f), 0.01f)
                identity[2].shouldEqual(Vec3(0f, 0f, 1f), 0.01f)
            }
        }


        "constructor" {

            val m0 = Mat3(
                    Vec3(0, 1, 2),
                    Vec3(3, 4, 5),
                    Vec3(6, 7, 8))

            val m1 = Mat3 (0, 1, 2, 3, 4, 5, 6, 7, 8 )

            val m2 = Mat3 { i -> i }

            m0 shouldEqual m2
            m1 shouldEqual m2
        }
    }
}