package glm_.ext

import glm_.glm
import glm_.quat.Quat
import glm_.scalar.deg
import glm_.shouldBe
import glm_.vec3.Vec3
import kotlin.test.Test

class quatCommon {

    @Test
    fun conjugate() {

        val a = Quat(Vec3(1, 0, 0), Vec3(0, 1, 0))
        val c = a.conjugate()
        a.notEqual(c, glm.epsilon.f).any() shouldBe true

        val b = c.conjugate()
        a.equal(b, glm.epsilon.f).all() shouldBe true
    }

    @Test
    fun mix() {

        val q1 = Quat(Vec3(1, 0, 0), Vec3(1, 0, 0))
        val q2 = Quat(Vec3(1, 0, 0), Vec3(0, 1, 0))

        run {
            val q3 = q1.mix(q2, 0.5f)
            val f3 = q3.angle().deg
            f3.equal(45f, 0.001f) shouldBe true

            val q4 = q2.mix(q1, 0.5f)
            val f4 = q4.angle().deg
            f4.equal(45f, 0.001f) shouldBe true
        }

        run {
            val q3 = q1.slerp(q2, 0.5f)
            val f3 = q3.angle().deg
            f3.equal(45f, 0.001f) shouldBe true

            val q4 = q2.slerp(q1, 0.5f)
            val f4 = q4.angle().deg
            f4.equal(45f, 0.001f) shouldBe true
        }
    }
}