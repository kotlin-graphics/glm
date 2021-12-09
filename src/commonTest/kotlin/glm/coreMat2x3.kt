package glm

import glm.extensions.BYTES
import glm.mat2.Mat2
import glm.mat2x3.*
import glm.mat2x4.Mat2x4
import glm.mat3.Mat3
import glm.mat3x2.Mat3x2
import glm.mat3x4.Mat3x4
import glm.mat4.Mat4
import glm.mat4x2.Mat4x2
import glm.mat4x3.Mat4x3
import glm.vec2.Vec2
import glm.vec3.Vec3
import kotlin.test.Test

class coreMat2x3 {

    @Test
    fun operators() {
        val l = Mat2x3(1f)
        val m = Mat2x3(1f)
        val u = Vec2(1f)
        val v = Vec3(1f)
        val x = 1f
        val a: Vec3 = m * u
        val b: Vec2 = v * m
        val n: Mat2x3 = x / m
        val o: Mat2x3 = m / x
        val p: Mat2x3 = x * m
        val q: Mat2x3 = m * x
        val r = m.anyNotEqual(q)
        val s = m.allEqual(l)

        assert(s && !r)
    }

    @Test
    fun ctr() {

        //        #if GLM_HAS_INITIALIZER_LISTS
        //        glm::mat2x3 m0(
        //                glm::vec3(0, 1, 2),
        //        glm::vec3(3, 4, 5));
        //
        //        glm::mat2x3 m1{0, 1, 2, 3, 4, 5};
        //
        //        glm::mat2x3 m2{
        //            {0, 1, 2},
        //            {3, 4, 5}};
        //
        //        Error += glm::all(glm::equal(m0, m2, glm::epsilon<float>())) ? 0 : 1;
        //        Error += glm::all(glm::equal(m1, m2, glm::epsilon<float>())) ? 0 : 1;
        //
        //        std::vector<glm::mat2x3> v1{
        //            {0, 1, 2, 3, 4, 5},
        //            {0, 1, 2, 3, 4, 5}
        //        };
        //
        //        std::vector<glm::mat2x3> v2{
        //            {
        //                { 0, 1, 2},
        //                { 4, 5, 6}
        //            },
        //            {
        //                { 0, 1, 2},
        //                { 4, 5, 6}
        //            }
        //        };
        //
        //        #endif//GLM_HAS_INITIALIZER_LISTS
    }

    @Test
    fun cast() {
        fun entry(b: Mat2x3) {
            val identity = Mat2x3(1f)
            assert(b.allEqual(identity))
        }

        entry(Mat2x3(Mat2(1f)))
        entry(Mat2x3(Mat2x3(1f)))
        entry(Mat2x3(Mat2x4(1f)))
        entry(Mat2x3(Mat3x2(1f)))
        entry(Mat2x3(Mat3(1f)))
        entry(Mat2x3(Mat3x4(1f)))
        entry(Mat2x3(Mat4x2(1f)))
        entry(Mat2x3(Mat4x3(1f)))
        entry(Mat2x3(Mat4(1f)))
    }

    @Test
    fun size() {

        assert(Mat2x3.size == 2 * 3 * Float.BYTES)
        assert(Mat2x3d.size == 2 * 3 * Double.BYTES)
        assert(Mat2x3.length == 2 * 3)
        assert(Mat2x3d.length == 2 * 3)
    }
}