package glm_.ext

import glm_.quat.Quat
import glm_.quat.QuatD
import glm_.shouldEqual
import glm_.vec3.Vec3
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class ext_quaternionType : StringSpec() {

    init {

        "test two axis ctr" {

            val q1 = Quat(Vec3(1, 0, 0), Vec3(0, 1, 0))
            val v1 = q1 * Vec3(1, 0, 0)
            v1.shouldEqual(Vec3(0, 1, 0), 0.0001f)

            val q2 = q1 * q1
            val v2 = q2 * Vec3(1, 0, 0)
            v2.shouldEqual(Vec3(-1, 0, 0), 0.0001f)

            val q3 = Quat(Vec3(1, 0, 0), Vec3(-1, 0, 0))
            val v3 = q3 * Vec3(1, 0, 0)
            v3.shouldEqual(Vec3(-1, 0, 0), 0.0001f)

            val q4 = Quat(Vec3(0, 1, 0), Vec3(0, -1, 0))
            val v4 = q4 * Vec3(0, 1, 0)
            v4.shouldEqual(Vec3(0, -1, 0), 0.0001f)

            val q5 = Quat(Vec3(0, 0, 1), Vec3(0, 0, -1))
            val v5 = q5 * Vec3(0, 0, 1)
            v5.shouldEqual(Vec3(0, 0, -1), 0.0001f)
        }

        "size" {
            val A = Quat.size
            16 shouldBe A
            val B = QuatD.size
            32 shouldBe B
            Quat.length shouldBe 4
            QuatD.length shouldBe 4
        }
    }
}