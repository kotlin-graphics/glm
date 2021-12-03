package glm

import glm.mat2.*
import glm.vec2.*
import kotlin.test.Test

class coreMat2 {

    @Test
    fun operators() {
        val l = Mat2(1f)
        val m = Mat2(1f)
        val u = Vec2(1f)
        val v = Vec2(1f)
        val x = 1f
        val a = m * u
        val b = v * m
        val n = x / m
        val o = m / x
        val p = x * m
        val q = m * x
        val r = m.anyNotEqual(q)
        val s = m.allEqual(l)

        assert(s && !r)
    }

    @Test
    fun inverse() {

        run {
            val matrix = Mat2(1, 2, 3, 4)
            val inverse = matrix.inverse()
            val identity = matrix * inverse

            assert(identity.allEqual(Mat2(1f), 0.01f))
        }

        run {
            val matrix = Mat2(1, 2, 3, 4)
            val identity = matrix / matrix

            assert(identity.allEqual(Mat2(1f), 0.01f))
        }
    }
}