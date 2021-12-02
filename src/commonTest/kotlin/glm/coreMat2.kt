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
//        glm::mat2x2 o = m / x
//        glm::mat2x2 p = x * m
//        glm::mat2x2 q = m * x
//        bool R = glm::any(glm::notEqual(m, q, glm::epsilon<float>()))
//        bool S = glm::all(glm::equal(m, l, glm::epsilon<float>()))

//        assert (S && !R) ? 0 : 1
    }
}