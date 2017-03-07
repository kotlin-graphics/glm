package main

import io.kotlintest.specs.StringSpec
import mat.Mat2
import main.Glm.matrixCompMult
import mat.Mat3
import mat.Mat4

/**
 * Created by GBarbieri on 07.03.2017.
 */

class coreFuncMatrix : StringSpec() {

    init {

        "matrixCompMult" {

            run {
                val m = Mat2(0, 1, 2, 3)
                val n = matrixCompMult(m, m)

                n shouldBe Mat2(0, 1, 4, 9)
            }

            run {
                val m = Mat3(0, 1, 2, 3, 4, 5, 6, 7, 8)
                val n = matrixCompMult(m, m)

                n shouldBe Mat3(0, 1, 4, 9, 16, 25, 36, 49, 64)
            }

            run {
                val m = Mat4(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15)
                val n = matrixCompMult(m, m)

                n shouldBe  Mat4(0, 1, 4, 9, 16, 25, 36, 49, 64, 81, 100, 121, 144, 169, 196, 225)
            }

            // TODO others
        }

        "transpose" {

            run {
                val m = Mat2(0, 1, 2, 3)
                val t = m.transpose()

                t shouldBe  Mat2(0, 2, 1, 3)
            }
        }
    }
}