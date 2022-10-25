package glm_.ext

import glm_.extensions.f
import glm_.quat.Quat
import glm_.quat.Quatd
import glm_.shouldBe
import glm_.vec3.Vec3
import kotlin.test.Test

class quatType {

    @Test
    fun ctr() {
        val a = Quat(0, 1, 2, 3)
        val b = Quat { it.f }
        a.equal(b).all() shouldBe true
    }

    @Test
    fun two_axis_ctr() {

        val q1 = Quat(Vec3(1, 0, 0), Vec3(0, 1, 0))
        val v1 = q1 * Vec3(1, 0, 0)
        v1.equal(Vec3(0, 1, 0), 0.0001f).all() shouldBe true

        val q2 = q1 * q1
        val v2 = q2 * Vec3(1, 0, 0)
        v2.equal(Vec3(-1, 0, 0), 0.0001f).all() shouldBe true

        val q3 = Quat(Vec3(1, 0, 0), Vec3(-1, 0, 0))
        val v3 = q3 * Vec3(1, 0, 0)
        v3.equal(Vec3(-1, 0, 0), 0.0001f).all() shouldBe true

        val q4 = Quat(Vec3(0, 1, 0), Vec3(0, -1, 0))
        val v4 = q4 * Vec3(0, 1, 0)
        v4.equal(Vec3(0, -1, 0), 0.0001f).all() shouldBe true

        val q5 = Quat(Vec3(0, 0, 1), Vec3(0, 0, -1))
        val v5 = q5 * Vec3(0, 0, 1)
        v5.equal(Vec3(0, 0, -1), 0.0001f).all() shouldBe true
    }

    @Test
    fun size() {

        Quat.size shouldBe 16
        Quatd.size shouldBe 32
        Quat.length shouldBe 4
        Quatd.length shouldBe 4
    }
}