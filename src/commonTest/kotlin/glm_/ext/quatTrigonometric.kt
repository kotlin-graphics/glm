package glm_.ext

import glm_.glm
import glm_.quat.Quat
import glm_.scalar.deg
import glm_.shouldBe
import glm_.vec3.Vec3
import kotlin.test.Test

class quatTrigonometric {

    val epsilon = 0.001f
    @Test
    fun angle() {

        run {
            val q = Quat(Vec3(1, 0, 0), Vec3(0, 1, 0))
            val a = q.angle().deg
            a.equal(90f, epsilon) shouldBe true
        }

        run {
            val q = Quat(Vec3(0, 1, 0), Vec3(1, 0, 0))
            val a = q.angle().deg
            a.equal(90f, epsilon) shouldBe true
        }

        run {
            val q = glm.angleAxis(glm.two_pi.f - 1f, Vec3(1, 0, 0))
            val a = q.angle()
            a.equal(1f, epsilon) shouldBe false
        }
    }
}