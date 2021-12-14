package glm.core

import glm.assert
import glm.extensions.BYTES
import glm.mat2.*
import glm.mat2x3.Mat2x3
import glm.mat2x4.Mat2x4
import glm.mat3.Mat3
import glm.mat3x2.Mat3x2
import glm.mat3x4.Mat3x4
import glm.mat4.Mat4
import glm.mat4x2.Mat4x2
import glm.mat4x3.Mat4x3
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
        val a: Vec2 = m * u
        val b: Vec2 = v * m
        val n: Mat2 = x / m
        val o: Mat2 = m / x
        val p: Mat2 = x * m
        val q: Mat2 = m * x
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

    @Test
    fun ctr() {

        run {
            val a = Mat2(1f)
            val b = Mat2(a)
            val c = Mat2(b)

            assert(a.allEqual(c))
        }

        //        #if GLM_HAS_INITIALIZER_LISTS
        //        glm::mat2x2 m0(
        //                glm::vec2(0, 1),
        //        glm::vec2(2, 3))
        //
        //        glm::mat2x2 m1{0, 1, 2, 3}
        //
        //        glm::mat2x2 m2{
        //            {0, 1},
        //            {2, 3}}
        //
        //        Error += glm::all(glm::equal(m0, m2, glm::epsilon<float>())) ? 0 : 1
        //        Error += glm::all(glm::equal(m1, m2, glm::epsilon<float>())) ? 0 : 1
        //
        //        std::vector<glm::mat2x2> v1{
        //            {0, 1, 2, 3},
        //            {0, 1, 2, 3}
        //        }
        //
        //        std::vector<glm::mat2x2> v2{
        //            {
        //                { 0, 1},
        //                { 4, 5}
        //            },
        //            {
        //                { 0, 1},
        //                { 4, 5}
        //            }
        //        }
        //
        //        #endif//GLM_HAS_INITIALIZER_LISTS
    }

    @Test
    fun cast() {
        fun entry(b: Mat2) {
            val identity = Mat2(1f)
            assert(b.allEqual(identity))
        }

        entry(Mat2(Mat2(1f)))
        entry(Mat2(Mat2x3(1f)))
        entry(Mat2(Mat2x4(1f)))
        entry(Mat2(Mat3x2(1f)))
        entry(Mat2(Mat3(1f)))
        entry(Mat2(Mat3x4(1f)))
        entry(Mat2(Mat4x2(1f)))
        entry(Mat2(Mat4x3(1f)))
        entry(Mat2(Mat4(1f)))
    }

    @Test
    fun size() {
        assert(Mat2.size == 2 * 2 * Float.BYTES)
        assert(Mat2d.size == 2 * 2 * Double.BYTES)
        assert(Mat2.length == 2 * 2)
        assert(Mat2d.length == 2 * 2)
    }
}