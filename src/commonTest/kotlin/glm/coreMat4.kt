package glm

import glm.mat4.*
import glm.vec4.Vec4
import kotlin.test.Test

class coreMat4 {

    @Test
    fun operatorsMat4() {

        val epsilon = 0.001f

        val m = Mat4(2f)
        val n = Mat4(1f)
        val u = Vec4(2f)

        run {
            val p = n * 2f
            assert(p.allEqual(m, epsilon))

            val q = m / 2f
            assert(q.allEqual(n, epsilon))
        }

        run {
            val v = m * u
            assert(v.allEqual(Vec4(4f), epsilon))

//            val w = u / m
//            Error += glm::all(glm::equal(W, vecType(static_cast<value_type>(1.f)), Epsilon)) ? 0 : 1
        }

//        {
//            matType const O = m * n
//            Error += glm::all(glm::equal(O, matType(static_cast<value_type>(2.f)), Epsilon)) ? 0 : 1
//        }
    }
}