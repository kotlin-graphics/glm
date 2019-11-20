package glm_.ext

import glm_.quat.Quat
import glm_.shouldEqual
import glm_.vec3.Vec3
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class test_ext_quaternionCommon : StringSpec() {

    init {

        "conjugate" {

            val A = Quat(Vec3(1, 0, 0), Vec3(0, 1, 0))
            val C = A.conjugate()
            A.anyNotEqual(C) shouldBe true

            val B = C.conjugate()
            A shouldEqual B
        }
    }
}