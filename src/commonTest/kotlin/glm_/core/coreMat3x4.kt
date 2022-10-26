package glm_.core

import glm_.assert
import glm_.extensions.BYTES
import glm_.glm
import glm_.mat2.Mat2
import glm_.mat2x3.Mat2x3
import glm_.mat2x4.Mat2x4
import glm_.mat3.Mat3
import glm_.mat3x2.Mat3x2
import glm_.mat3x4.*
import glm_.mat4.Mat4
import glm_.mat4x2.Mat4x2
import glm_.mat4x3.Mat4x3
import glm_.vec3.Vec3
import glm_.vec4.Vec4
import kotlin.test.Test

class coreMat3x4 {

    @Test
    fun operators() {
        val l = Mat3x4(1f)
        val m = Mat3x4(1f)
        val u = Vec3(1f)
        val v = Vec4(1f)
        val x = 1f
        val a: Vec4 = m * u
        val b: Vec3 = v * m
        val n: Mat3x4 = x / m
        val o: Mat3x4 = m / x
        val p: Mat3x4 = x * m
        val q: Mat3x4 = m * x
        val r = m.notEqual(q, glm.epsilon.f).any()
        val s = m.equal(l, glm.epsilon.f).all()

        assert(s && !r)
    }

    @Test
    fun ctr() {

        //        #if(GLM_HAS_INITIALIZER_LISTS)
        //        glm::mat3x4 m0(
        //                glm::vec4(0, 1, 2, 3),
        //        glm::vec4(4, 5, 6, 7),
        //        glm::vec4(8, 9, 10, 11));
        //
        //        glm::mat3x4 m1{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        //
        //        glm::mat3x4 m2{
        //            {0, 1, 2, 3},
        //            {4, 5, 6, 7},
        //            {8, 9, 10, 11}};
        //
        //        Error += glm::all(glm::equal(m0, m2, glm::epsilon<float>())) ? 0 : 1;
        //        Error += glm::all(glm::equal(m1, m2, glm::epsilon<float>())) ? 0 : 1;
        //
        //        std::vector<glm::mat3x4> v1{
        //            {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11},
        //            {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11}
        //        };
        //
        //        std::vector<glm::mat3x4> v2{
        //            {
        //                { 0, 1, 2, 3},
        //                { 4, 5, 6, 7},
        //                { 8, 9, 10, 11}
        //            },
        //            {
        //                { 0, 1, 2, 3},
        //                { 4, 5, 6, 7},
        //                { 8, 9, 10, 11}
        //            }
        //        };
        //
        //        #endif//GLM_HAS_INITIALIZER_LISTS
    }

    @Test
    fun cast() {
        fun entry(b: Mat3x4) {
            val identity = Mat3x4(1f)
            assert(b.equal(identity, glm.epsilon.f).all())
        }

        entry(Mat3x4(Mat2(1f)))
        entry(Mat3x4(Mat2x3(1f)))
        entry(Mat3x4(Mat2x4(1f)))
        entry(Mat3x4(Mat3x2(1f)))
        entry(Mat3x4(Mat3(1f)))
        entry(Mat3x4(Mat3x4(1f)))
        entry(Mat3x4(Mat4x2(1f)))
        entry(Mat3x4(Mat4x3(1f)))
        entry(Mat3x4(Mat4(1f)))
    }

    @Test
    fun size() {

        assert(Mat3x4.size == 3 * 4 * Float.BYTES)
        assert(Mat3x4d.size == 3 * 4 * Double.BYTES)
        assert(Mat3x4.length == 3 * 4)
        assert(Mat3x4d.length == 3 * 4)
    }

}