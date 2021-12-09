package glm

import glm.extensions.BYTES
import glm.mat2.Mat2
import glm.mat2x3.Mat2x3
import glm.mat2x4.Mat2x4
import glm.mat2x4.Mat2x4d
import glm.mat2x4.div
import glm.mat2x4.times
import glm.mat3.Mat3
import glm.mat3x2.Mat3x2
import glm.mat3x4.Mat3x4
import glm.mat4.Mat4
import glm.mat4x2.Mat4x2
import glm.mat4x3.Mat4x3
import glm.vec2.Vec2
import glm.vec4.Vec4
import kotlin.test.Test

class coreMat2x4 {

    @Test
    fun operators() {
        val l = Mat2x4 (1f)
        val m = Mat2x4 (1f)
        val u = Vec2(1f)
        val v = Vec4(1f)
        val x = 1f
        val a: Vec4 = m * u
        val b: Vec2 = v * m
        val n: Mat2x4 = x / m
        val o: Mat2x4 = m / x
        val p: Mat2x4 = x * m
        val q: Mat2x4 = m * x
        val r = m.anyNotEqual(q)
        val s = m.allEqual(l)

        assert (s && !r)
    }

    @Test
    fun ctr() {

//        #if(GLM_HAS_INITIALIZER_LISTS)
//            glm::mat2x4 m0(
//                    glm::vec4(0, 1, 2, 3),
//        glm::vec4(4, 5, 6, 7));
//
//        glm::mat2x4 m1{0, 1, 2, 3, 4, 5, 6, 7};
//
//        glm::mat2x4 m2{
//            {0, 1, 2, 3},
//            {4, 5, 6, 7}};
//
//        Error += glm::all(glm::equal(m0, m2, glm::epsilon<float>())) ? 0 : 1;
//        Error += glm::all(glm::equal(m1, m2, glm::epsilon<float>())) ? 0 : 1;
//
//        std::vector<glm::mat2x4> v1{
//            {0, 1, 2, 3, 4, 5, 6, 7},
//            {0, 1, 2, 3, 4, 5, 6, 7}
//        };
//
//        std::vector<glm::mat2x4> v2{
//            {
//                { 0, 1, 2, 3},
//                { 4, 5, 6, 7}
//            },
//            {
//                { 0, 1, 2, 3},
//                { 4, 5, 6, 7}
//            }
//        };
    }

    @Test
    fun cast() {
        fun entry(b: Mat2x4) {
            val identity = Mat2x4(1f)
            assert(b.allEqual(identity))
        }

        entry(Mat2x4(Mat2(1f)))
        entry(Mat2x4(Mat2x3(1f)))
        entry(Mat2x4(Mat2x4(1f)))
        entry(Mat2x4(Mat3x2(1f)))
        entry(Mat2x4(Mat3(1f)))
        entry(Mat2x4(Mat3x4(1f)))
        entry(Mat2x4(Mat4x2(1f)))
        entry(Mat2x4(Mat4x3(1f)))
        entry(Mat2x4(Mat4(1f)))
    }

    @Test
    fun size() {

        assert(Mat2x4.size == 2 * 4 * Float.BYTES)
        assert(Mat2x4d.size == 2 * 4 * Double.BYTES)
        assert(Mat2x4.length == 2 * 4)
        assert(Mat2x4d.length == 2 * 4)
    }
}