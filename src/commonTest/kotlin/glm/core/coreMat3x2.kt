package glm.core

import glm.assert
import glm.extensions.BYTES
import glm.mat2.Mat2
import glm.mat2x3.Mat2x3
import glm.mat2x4.Mat2x4
import glm.mat3.Mat3
import glm.mat3x2.*
import glm.mat3x4.Mat3x4
import glm.mat4.Mat4
import glm.mat4x2.Mat4x2
import glm.mat4x3.Mat4x3
import glm.vec2.Vec2
import glm.vec3.Vec3
import kotlin.test.Test

class coreMat3x2 {

    @Test
    fun operators() {
        val l = Mat3x2(1f)
        val m = Mat3x2(1f)
        val u = Vec3(1f)
        val v = Vec2(1f)
        val x = 1f
        val a: Vec2 = m * u
        val b: Vec3 = v * m
        val n: Mat3x2 = x / m
        val o: Mat3x2 = m / x
        val p: Mat3x2 = x * m
        val q: Mat3x2 = m * x
        val r = m.anyNotEqual(q)
        val s = m.allEqual(l)

        assert(s && !r)
    }

    @Test
    fun ctr() {

//        #if(GLM_HAS_INITIALIZER_LISTS)
//        glm::mat3x2 m0(
//                glm::vec2(0, 1),
//        glm::vec2(2, 3),
//        glm::vec2(4, 5));
//
//        glm::mat3x2 m1{0, 1, 2, 3, 4, 5};
//
//        glm::mat3x2 m2{
//            {0, 1},
//            {2, 3},
//            {4, 5}};
//
//        Error += glm::all(glm::equal(m0, m2, glm::epsilon<float>())) ? 0 : 1;
//        Error += glm::all(glm::equal(m1, m2, glm::epsilon<float>())) ? 0 : 1;
//
//        std::vector<glm::mat3x2> v1{
//            {0, 1, 2, 3, 4, 5},
//            {0, 1, 2, 3, 4, 5}
//        };
//
//        std::vector<glm::mat3x2> v2{
//            {
//                { 0, 1},
//                { 2, 3},
//                { 4, 5}
//            },
//            {
//                { 0, 1},
//                { 2, 3},
//                { 4, 5}
//            }
//        };
//
//        #endif//GLM_HAS_INITIALIZER_LISTS
    }

    @Test
    fun cast() {
        fun entry(b: Mat3x2) {
            val identity = Mat3x2(1f)
            assert(b.allEqual(identity))
        }

        entry(Mat3x2(Mat2(1f)))
        entry(Mat3x2(Mat2x3(1f)))
        entry(Mat3x2(Mat2x4(1f)))
        entry(Mat3x2(Mat3x2(1f)))
        entry(Mat3x2(Mat3(1f)))
        entry(Mat3x2(Mat3x4(1f)))
        entry(Mat3x2(Mat4x2(1f)))
        entry(Mat3x2(Mat4x3(1f)))
        entry(Mat3x2(Mat4(1f)))
    }

    @Test
    fun size() {

        assert(Mat3x2.size == 3 * 2 * Float.BYTES)
        assert(Mat3x2d.size == 3 * 2 * Double.BYTES)
        assert(Mat3x2.length == 3 * 2)
        assert(Mat3x2d.length == 3 * 2)
    }
}