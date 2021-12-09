package glm

import glm.extensions.BYTES
import glm.mat2.Mat2
import glm.mat2x3.Mat2x3
import glm.mat2x4.Mat2x4
import glm.mat3.Mat3
import glm.mat3x2.Mat3x2
import glm.mat3x4.Mat3x4
import glm.mat3x4.Mat3x4d
import glm.mat4.Mat4
import glm.mat4x2.*
import glm.mat4x3.Mat4x3
import glm.vec2.Vec2
import glm.vec4.Vec4
import kotlin.test.Test

class coreMat4x2 {

    @Test
    fun operators() {
        val l = Mat4x2(1f)
        val m = Mat4x2(1f)
        val u = Vec4(1f)
        val v = Vec2(1f)
        val x = 1f
        val a: Vec2 = m * u
        val b: Vec4 = v * m
        val n: Mat4x2 = x / m
        val o: Mat4x2 = m / x
        val p: Mat4x2 = x * m
        val q: Mat4x2 = m * x
        val r = m.anyNotEqual(q)
        val s = m.allEqual(l)

        assert (s && !r)
    }

    @Test
    fun ctr() {

//        #if(GLM_HAS_INITIALIZER_LISTS)
//        glm::mat4x2 m0(
//                glm::vec2(0, 1),
//        glm::vec2(2, 3),
//        glm::vec2(4, 5),
//        glm::vec2(6, 7));
//
//        glm::mat4x2 m1{0, 1, 2, 3, 4, 5, 6, 7};
//
//        glm::mat4x2 m2{
//            {0, 1},
//            {2, 3},
//            {4, 5},
//            {6, 7}};
//
//        Error += glm::all(glm::equal(m0, m2, glm::epsilon<float>())) ? 0 : 1;
//        Error += glm::all(glm::equal(m1, m2, glm::epsilon<float>())) ? 0 : 1;
//
//        std::vector<glm::mat4x2> v1{
//            {0, 1, 2, 3, 4, 5, 6, 7},
//            {0, 1, 2, 3, 4, 5, 6, 7}
//        };
//
//        std::vector<glm::mat4x2> v2{
//            {
//                { 0, 1},
//                { 4, 5},
//                { 8, 9},
//                { 12, 13}
//            },
//            {
//                { 0, 1},
//                { 4, 5},
//                { 8, 9},
//                { 12, 13}
//            }
//        };
//
//        #endif//GLM_HAS_INITIALIZER_LISTS
    }

    @Test
    fun cast() {
        fun entry(b: Mat4x2) {
            val identity = Mat4x2(1f)
            assert(b.allEqual(identity))
        }

        entry(Mat4x2(Mat2(1f)))
        entry(Mat4x2(Mat2x3(1f)))
        entry(Mat4x2(Mat2x4(1f)))
        entry(Mat4x2(Mat3x2(1f)))
        entry(Mat4x2(Mat3(1f)))
        entry(Mat4x2(Mat3x4(1f)))
        entry(Mat4x2(Mat4x2(1f)))
        entry(Mat4x2(Mat4x3(1f)))
        entry(Mat4x2(Mat4(1f)))
    }

    @Test
    fun size() {

        assert(Mat4x2.size == 4 * 2 * Float.BYTES)
        assert(Mat4x2d.size == 4 * 2 * Double.BYTES)
        assert(Mat4x2.length == 4 * 2)
        assert(Mat4x2d.length == 4 * 2)
    }
}