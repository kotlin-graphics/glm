package glm_

import glm_.mat3x3.Mat3
import glm_.mat3x3.operators.times
import glm_.vec3.Vec3
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

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
            val R = m != q
            val S = m == l

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

                glm.all(glm.epsilonEqual(identity[0], Vec3(1f, 0f, 0f), Vec3(0.01f))) shouldBe true
                glm.all(glm.epsilonEqual(identity[1], Vec3(0f, 1f, 0f), Vec3(0.01f))) shouldBe true
                glm.all(glm.epsilonEqual(identity[2], Vec3(0f, 0f, 1f), Vec3(0.01f))) shouldBe true
            }
            run {
                val matrix = Mat3(
                        0.6f, 0.2f, 0.3f,
                        0.2f, 0.7f, 0.5f,
                        0.3f, 0.5f, 0.7f)
                val identity = matrix / matrix

                glm.all(glm.epsilonEqual(identity[0], Vec3(1f, 0f, 0f), Vec3(0.01f))) shouldBe true
                glm.all(glm.epsilonEqual(identity[1], Vec3(0f, 1f, 0f), Vec3(0.01f))) shouldBe true
                glm.all(glm.epsilonEqual(identity[2], Vec3(0f, 0f, 1f), Vec3(0.01f))) shouldBe true
            }
        }


        "constructor" {

            Mat3 { i -> i } shouldBe Mat3(
                    0, 1, 2,
                    3, 4, 5,
                    6, 7, 8)
            Mat3(arrayListOf(
                    0f, 1f, 2f,
                    3f, 4f, 5f,
                    6f, 7f, 8f)) shouldBe Mat3(
                    0, 1, 2,
                    3, 4, 5,
                    6, 7, 8)
        }
    }
}