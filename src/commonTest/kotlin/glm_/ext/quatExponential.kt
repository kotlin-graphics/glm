package glm_.ext

import glm_.quat.Quat
import glm_.quat.Quatd
import glm_.shouldBe
import glm_.vec3.Vec3
import glm_.vec3.Vec3d
import kotlin.test.Test

class quatExponential {

    @Test
    fun log() {
        run {
            val epsilon = 0.001f

            val q = Quat(Vec3(1, 0, 0), Vec3(0, 1, 0))
            val p = q.log()
            q.notEqual(p, epsilon).any() shouldBe true

            val r = p.exp()
            q.equal(r, epsilon).all() shouldBe true
        }
        run {
            val epsilon = 0.001

            val q = Quatd(Vec3d(1, 0, 0), Vec3d(0, 1, 0))
            val p = q.log()
            q.notEqual(p, epsilon).any() shouldBe true

            val r = p.exp()
            q.equal(r, epsilon).all() shouldBe true
        }
    }

    @Test
    fun pow() {
        run {
            val epsilon = 0.001f

            val q = Quat(Vec3(1, 0, 0), Vec3(0, 1, 0))

            run {
                val one = 1.0f
                val p = q pow one
                q.equal(p, epsilon).all() shouldBe true
            }

            run {
                val two = 2f
                val p = q pow two
                val r = q * q
                p.equal(r, epsilon).all() shouldBe true

                val u = p.sqrt()
                q.equal(u, epsilon).all() shouldBe true
            }
        }
        run {
            val epsilon = 0.001

            val q = Quatd(Vec3d(1, 0, 0), Vec3d(0, 1, 0))

            run {
                val one = 1.0
                val p = q pow one
                q.equal(p, epsilon).all() shouldBe true
            }

            run {
                val two = 2.0
                val p = q pow two
                val r = q * q
                p.equal(r, epsilon).all() shouldBe true

                val u = p.sqrt()
                q.equal(u, epsilon).all() shouldBe true
            }
        }
    }
}