package glm_.ext

import glm_.glm
import glm_.quat.Quat
import glm_.quat.Quatd
import glm_.shouldBe
import kotlin.test.Test

class quatRelational {

    @Test
    fun equal() {
        run {
            val q = Quat(1, 0, 0, 0)
            val p = Quat(1, 0, 0, 0)
            q.equal(p, glm.epsilon.f).all() shouldBe true
        }
        run {
            val q = Quatd(1, 0, 0, 0)
            val p = Quatd(1, 0, 0, 0)
            q.equal(p, glm.epsilon.d).all() shouldBe true
        }
    }
    @Test
    fun notEqual() {
        run {
            val q = Quat(1, 0, 0, 0)
            val p = Quat(1, 0, 0, 0)
            q.notEqual(p, glm.epsilon.f).all() shouldBe false
        }
        run {
            val q = Quatd(1, 0, 0, 0)
            val p = Quatd(1, 0, 0, 0)
            q.notEqual(p, glm.epsilon.d).all() shouldBe false
        }
    }
}