package glm

import glm.Glm.matrixCompMult
import glm.mat.Mat2
import glm.mat.Mat3
import glm.mat.Mat4
import glm.vec._2.Vec2
import glm.vec._3.Vec3
import glm.vec._4.Vec4
import io.kotlintest.specs.StringSpec

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

                n shouldBe Mat4(0, 1, 4, 9, 16, 25, 36, 49, 64, 81, 100, 121, 144, 169, 196, 225)
            }

            // TODO others
        }

        "transpose" {

            run {
                val m = Mat2(0, 1, 2, 3)
                val t = m.transpose()

                t shouldBe Mat2(0, 2, 1, 3)
            }

            run {
                val m = Mat3(0, 1, 2, 3, 4, 5, 6, 7, 8)
                val t = m.transpose()

                t shouldBe Mat3(0, 3, 6, 1, 4, 7, 2, 5, 8)
            }

            run {
                val m = Mat4(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15)
                val t = m.transpose()

                t shouldBe Mat4(0, 4, 8, 12, 1, 5, 9, 13, 2, 6, 10, 14, 3, 7, 11, 15)
            }
            // TODO others
        }

        "inverse" {

            run {
                val a = Mat2(
                        1, 1,
                        0, 1)
                val b = a.inverse()
                val i = a * b
                i.isIdentity() shouldBe true
            }
            run {
                val a = Mat3(
                        1, 0, 1,
                        0, 1, 0,
                        0, 0, 1)
                val b = a.inverse()
                val i = a * b
                i.isIdentity() shouldBe true
            }
            run {
                val a = Mat4(
                        1, 0, 1, 0,
                        0, 1, 0, 0,
                        0, 0, 1, 0,
                        0, 0, 0, 1)
                val b = a.inverse()
                val i = a * b
                i.isIdentity() shouldBe true
            }
        }

        "determinant" {

            Mat2(0, 1, 2, 3).det() shouldBe -2f
            Mat3(0, 1, 2, 3, 4, 5, 6, 7, 8).det() shouldBe 0f
            Mat4(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15).det() shouldBe 0f
        }

        "outerProduct" {

            glm.outerProduct(Vec2(0f, 1f), Vec2(2f, 3f)) shouldBe Mat2(0f, 2f, 0f, 3f)

            glm.outerProduct(Vec3(0f, 1f, 2f), Vec3(3f, 4f, 5f)) shouldBe Mat3(
                    0f, 3f, 6f,
                    0f, 4f, 8f,
                    0f, 5f, 10f)

            glm.outerProduct(Vec4(0f, 1f, 2f, 3f), Vec4(4f, 5f, 6f, 7f)) shouldBe Mat4(
                    0f, 4f, 8f, 12f,
                    0f, 5f, 10f, 15f,
                    0f, 6f, 12f, 18f,
                    0f, 7f, 14f, 21f)

            // TODO other matrices
        }
    }
}