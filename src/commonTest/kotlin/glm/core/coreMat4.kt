package glm.core

import glm.assert
import glm.extensions.BYTES
import glm.mat4.*
import glm.vec4.Vec4
import glm.vec4.Vec4d
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

            val w = u / m
            assert(w.allEqual(Vec4(1f), epsilon))
        }

        run {
            val o = m * n
            assert(o.allEqual(Mat4(2f), epsilon))
        }
    }

    @Test
    fun operatorsMat4d() {

        val epsilon = 0.001

        val m = Mat4d(2.0)
        val n = Mat4d(1.0)
        val u = Vec4d(2.0)

        run {
            val p = n * 2.0
            assert(p.allEqual(m, epsilon))

            val q = m / 2.0
            assert(q.allEqual(n, epsilon))
        }

        run {
            val v = m * u
            assert(v.allEqual(Vec4d(4.0), epsilon))

            val w = u / m
            assert(w.allEqual(Vec4d(1.0), epsilon))
        }

        run {
            val o = m * n
            assert(o.allEqual(Mat4d(2.0), epsilon))
        }
    }

    @Test
    fun inverseMat4() {

        val epsilon = 0.001f

        val identity = Mat4(1f)
        val matrix = Mat4(
            Vec4(0.6f, 0.2f, 0.3f, 0.4f),
            Vec4(0.2f, 0.7f, 0.5f, 0.3f),
            Vec4(0.3f, 0.5f, 0.7f, 0.2f),
            Vec4(0.4f, 0.3f, 0.2f, 0.6f))
        val inverse = identity / matrix
        val result = matrix * inverse

        assert(identity.allEqual(result, epsilon))
    }

    @Test
    fun inverseMat4d() {

        val epsilon = 0.001

        val identity = Mat4d(1.0)
        val matrix = Mat4d(
            Vec4d(0.6, 0.2, 0.3, 0.4),
            Vec4d(0.2, 0.7, 0.5, 0.3),
            Vec4d(0.3, 0.5, 0.7, 0.2),
            Vec4d(0.4, 0.3, 0.2, 0.6))
        val inverse = identity / matrix
        val result = matrix * inverse

        assert(identity.allEqual(result, epsilon))
    }

    @Test
    fun ctr() {

        //        #if GLM_HAS_TRIVIAL_QUERIES
        //        //Error += std::is_trivially_default_constructible<glm::mat4>::value ? 0 : 1;
        //        //Error += std::is_trivially_copy_assignable<glm::mat4>::value ? 0 : 1;
        //        Error += std::is_trivially_copyable<glm::mat4>::value ? 0 : 1;
        //        //Error += std::is_copy_constructible<glm::mat4>::value ? 0 : 1;
        //        //Error += std::has_trivial_copy_constructor<glm::mat4>::value ? 0 : 1;
        //        #endif
        //
        //        #if GLM_HAS_INITIALIZER_LISTS
        //        glm::mat4 const m0(
        //            glm::vec4(0, 1, 2, 3),
        //            glm::vec4(4, 5, 6, 7),
        //            glm::vec4(8, 9, 10, 11),
        //            glm::vec4(12, 13, 14, 15));
        //
        //        assert(sizeof(m0) == 4 * 4 * 4);
        //
        //        glm::vec4 const V{0, 1, 2, 3};
        //
        //        glm::mat4 const m1{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        //
        //        glm::mat4 const m2{
        //            {0, 1, 2, 3},
        //            {4, 5, 6, 7},
        //            {8, 9, 10, 11},
        //            {12, 13, 14, 15}};
        //
        //        Error += glm::all(glm::equal(m0, m2, glm::epsilon<float>())) ? 0 : 1;
        //        Error += glm::all(glm::equal(m1, m2, glm::epsilon<float>())) ? 0 : 1;
        //
        //
        //        std::vector<glm::mat4> const m3{
        //            {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15},
        //            {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15},
        //            {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15},
        //            {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15}};
        //
        //        glm::mat4 const m4{
        //            {1, 0, 0, 0},
        //            {0, 1, 0, 0},
        //            {0, 0, 1, 0},
        //            {0, 0, 0, 1} };
        //
        //        Error += glm::equal(m4[0][0], 1.0f, 0.0001f) ? 0 : 1;
        //        Error += glm::equal(m4[3][3], 1.0f, 0.0001f) ? 0 : 1;
        //
        //        std::vector<glm::mat4> const v1{
        //            {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15},
        //            {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15}};
        //
        //        std::vector<glm::mat4> const v2{
        //            {
        //                { 0, 1, 2, 3 },
        //                { 4, 5, 6, 7 },
        //                { 8, 9, 10, 11 },
        //                { 12, 13, 14, 15 }
        //            },
        //            {
        //                { 0, 1, 2, 3 },
        //                { 4, 5, 6, 7 },
        //                { 8, 9, 10, 11 },
        //                { 12, 13, 14, 15 }
        //            }};
        //
        //        #endif//GLM_HAS_INITIALIZER_LISTS
    }

    @Test
    fun size() {

        assert(Mat4.size == 4 * 4 * Float.BYTES)
        assert(Mat4d.size == 4 * 4 * Double.BYTES)
        assert(Mat4.length == 4 * 4)
        assert(Mat4d.length == 4 * 4)
    }
}