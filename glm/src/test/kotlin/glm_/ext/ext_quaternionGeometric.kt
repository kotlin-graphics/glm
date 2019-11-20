package glm_.ext

import glm_.func.deg
import glm_.glm
import glm_.quat.Quat
import glm_.shouldEqual
import glm_.vec3.Vec3
import io.kotlintest.specs.StringSpec

class ext_quaternionGeometric : StringSpec() {

    init {

//        float const Epsilon = 0.001f [JVM] not really useful

        "test angle"        {

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

        "test length" {

            run {
                val A = Quat(1, 0, 0, 0).length()
                A shouldEqual 1f
            }

            run {
                val A = Quat(1f, Vec3(0)).length()
                A shouldEqual 1f
            }

            run {
                val A = Quat(Vec3(1, 0, 0), Vec3(0, 1, 0)).length()
                A.shouldEqual(1f, 0.0001f)
            }
        }

        "test normalize"        {

            run {
                val A = Quat(1, 0, 0, 0)
                val N = A.normalize()
                A shouldEqual N
            }

            run {
                val A = Quat(1f, Vec3(0))
                val N = A.normalize()
                A shouldEqual N
            }
        }
    }
}