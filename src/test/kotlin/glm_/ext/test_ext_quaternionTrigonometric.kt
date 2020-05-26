package glm_.ext

import glm_.func.deg
import glm_.glm
import glm_.quat.Quat
import glm_.shouldEqual
import glm_.vec3.Vec3
import io.kotest.core.spec.style.StringSpec

class test_ext_quaternionTrigonometric : StringSpec() {

    init {

        "angle" {

            run {
                val Q = Quat(Vec3(1, 0, 0), Vec3(0, 1, 0))
                val A = glm.angle(Q).deg
                A shouldEqual 90f
            }

            run {
                val Q = Quat(Vec3(0, 1, 0), Vec3(1, 0, 0))
                val A = glm.angle(Q).deg
                A shouldEqual 90f
            }
        }
    }
}