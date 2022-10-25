package glm_.ext

import glm_.quat.Quat
import glm_.shouldBe
import glm_.vec3.Vec3
import kotlin.test.Test

class quatGeometrical {
    val epsilon = 0.001f
    @Test
    fun length() {

        run {
            val a = Quat(1, 0, 0, 0).length()
            a.equal(1f, epsilon) shouldBe true
        }

        run {
            val a = Quat(1, Vec3(0)).length()
            a.equal(1f, epsilon) shouldBe true
        }

        run {
            val a = Quat(Vec3(1, 0, 0), Vec3(0, 1, 0)).length()
            a.equal(1f, epsilon) shouldBe true
        }
    }

    @Test
    fun normalize() {

        run {
            val a = Quat(1, 0, 0, 0)
            val n = a.normalize()
            a.equal(n, epsilon).all() shouldBe true
        }

        run {
            val a = Quat(1, Vec3(0))
            val n = a.normalize()
            a.equal(n, epsilon).all()shouldBe true
        }
    }

    @Test
    fun dot() {

        run {
            val a = Quat(1, 0, 0, 0)
            val b = Quat(1, 0, 0, 0)
            val c = a dot b
            c.equal(1f, epsilon) shouldBe true
        }
    }

    @Test
    fun cross() {
        val a = Quat(0, 1, 2, 3)
        val b = Quat(4, 5, 6, 7)
        val c = a cross b
        c.equal(Quat(-38, 0, 16, 8), epsilon).all() shouldBe true
    }
}