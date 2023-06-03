package glm_.ext

import glm_.func.deg
import glm_.glm
import glm_.quat.Quat
import glm_.shouldEqual
import glm_.vec3.Vec3
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class test_ext_quaternionCommon : StringSpec() {

    init {

        "conjugate" {

            val A = Quat(Vec3(1, 0, 0), Vec3(0, 1, 0))
            val C = A.conjugate()
            A.anyNotEqual(C) shouldBe true

            val B = C.conjugate()
            A shouldEqual B
        }

        "mix" {

            val Q1 = Quat(Vec3(1, 0, 0), Vec3(1, 0, 0))
            val Q2 = Quat(Vec3(1, 0, 0), Vec3(0, 1, 0))

            run {
                val Q3 = glm.mix(Q1, Q2, 0.5f)
                val F3 = glm.angle(Q3).deg
                F3.shouldEqual(45f, 0.001f)

                val Q4 = glm.mix(Q2, Q1, 0.5f)
                val F4 = glm.angle(Q4).deg
                F4.shouldEqual(45f, 0.001f)
            }

            run {
                val Q3 = glm.slerp(Q1, Q2, 0.5f)
                val F3 = glm.angle(Q3).deg
                F3.shouldEqual(45f, 0.001f)

                val Q4 = glm.slerp(Q2, Q1, 0.5f)
                val F4 = glm.angle(Q4).deg
                F4.shouldEqual(45f, 0.001f)
            }
        }
    }
}
