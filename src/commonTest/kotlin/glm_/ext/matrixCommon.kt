package glm_.ext

import glm_.mat4.Mat4
import glm_.mat4.Mat4d
import glm_.shouldBe
import kotlin.test.Test

class matrixCommon {

    @Test
    fun mix() {

        run {
            val a = Mat4(2)
            val b = Mat4(4)
            val c = a.mix(b, 0.5f)
            val d = c.equal(Mat4(3), 1)
            d.all() shouldBe true
        }

        run {
            val a = Mat4(2)
            val b = Mat4(4)
            val c = a.mix(b, 0.5f)
            val d = c.equal(Mat4(3), 1)
            d.all() shouldBe true
        }

        run {
            val a = Mat4d(2)
            val b = Mat4d(4)
            val c = a.mix(b, 0.5)
            val d = c.equal(Mat4d(3), 1)
            d.all() shouldBe true
        }

        run {
            val a = Mat4d(2)
            val b = Mat4d(4)
            val c = a.mix(b, 0.5)
            val d = c.equal(Mat4d(3), 1)
            d.all() shouldBe true
        }
    }
}