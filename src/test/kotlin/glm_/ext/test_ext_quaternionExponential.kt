package glm_.ext

import glm_.glm
import glm_.quat.Quat
import glm_.quat.QuatD
import glm_.shouldEqual
import glm_.vec3.Vec3
import glm_.vec3.Vec3d
import io.kotest.matchers.shouldBe
import io.kotest.core.spec.style.StringSpec

class test_ext_quaternionExponential : StringSpec() {

    init {

        "log" {
            run {
                val epsilon = 0.001f

                val Q = Quat(Vec3(1, 0, 0), Vec3(0, 1, 0))
                val P = glm.log(Q)
                Q.anyNotEqual(P, epsilon) shouldBe true

                val R = glm.exp(P)
                Q.shouldEqual(R, epsilon)
            }
            run {
                val epsilon = 0.001

                val Q = QuatD(Vec3d(1, 0, 0), Vec3d(0, 1, 0))
                val P = glm.log(Q)
                Q.anyNotEqual(P, epsilon) shouldBe true

                val R = glm.exp(P)
                Q.shouldEqual(R, epsilon)
            }
        }

        "pow" {
            run {
                val epsilon = 0.001f

                val Q = Quat(Vec3(1, 0, 0), Vec3(0, 1, 0))

                run {
                    val one = 1f
                    val P = glm.pow(Q, one)
                    Q.shouldEqual(P, epsilon)
                }

                run {
                    val two = 2f
                    val P = glm.pow(Q, two)
                    val R = Q * Q
                    P.shouldEqual(R, epsilon)

                    val U = glm.sqrt(P)
                    Q.shouldEqual(U, epsilon)
                }
            }
            run {
                val epsilon = 0.001

                val Q = QuatD(Vec3d(1, 0, 0), Vec3d(0, 1, 0))

                run {
                    val one = 1.0
                    val P = glm.pow(Q, one)
                    Q.shouldEqual(P, epsilon)
                }

                run {
                    val two = 2.0
                    val P = glm.pow(Q, two)
                    val R = Q * Q
                    P.shouldEqual(R, epsilon)

                    val U = glm.sqrt(P)
                    Q.shouldEqual(U, epsilon)
                }
            }
        }
    }
}