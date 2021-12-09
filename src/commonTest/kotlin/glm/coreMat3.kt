package glm

import glm.extensions.BYTES
import glm.mat2.Mat2
import glm.mat2x3.Mat2x3
import glm.mat2x4.Mat2x4
import glm.mat3.*
import glm.mat3.Mat3d
import glm.mat3x2.Mat3x2
import glm.mat3x4.Mat3x4
import glm.mat4.Mat4
import glm.mat4x2.Mat4x2
import glm.mat4x3.Mat4x3
import glm.vec3.Vec3
import glm.vec3.Vec3d
import kotlin.test.Test

class coreMat3 {

    @Test
    fun mat3x3() {
        val mat0 = Mat3d(
            Vec3d(0.6f, 0.2f, 0.3f),
            Vec3d(0.2f, 0.7f, 0.5f),
            Vec3d(0.3f, 0.5f, 0.7f))
        val inv0 = mat0.inverse()
        val res0 = mat0 * inv0

        assert(res0.allEqual(Mat3d(1.0), epsilon = 0.01))
    }

    @Test
    fun operators() {
        val l = Mat3(1f)
        val m = Mat3(1f)
        val u = Vec3(1f)
        val v = Vec3(1f)
        val x = 1f
        val a: Vec3 = m * u
        val b: Vec3 = v * m
        val n: Mat3 = x / m
        val o: Mat3 = m / x
        val p: Mat3 = x * m
        val q: Mat3 = m * x
        val r = m.anyNotEqual(q)
        val s = m.allEqual(l)

        assert(s && !r)
    }

    @Test
    fun inverse() {

        run {
            val matrix = Mat3(
                Vec3(0.6f, 0.2f, 0.3f),
                Vec3(0.2f, 0.7f, 0.5f),
                Vec3(0.3f, 0.5f, 0.7f))
            val inverse = matrix.inverse()
            val identity = matrix * inverse

            assert(identity.allEqual(Mat3(1f), epsilon = 0.01f))
        }

        run {
            val matrix = Mat3(
                Vec3(0.6f, 0.2f, 0.3f),
                Vec3(0.2f, 0.7f, 0.5f),
                Vec3(0.3f, 0.5f, 0.7f))
            val identity = matrix / matrix

            assert(identity.allEqual(Mat3(1f), epsilon = 0.01f))
        }
    }

    @Test
    fun ctr() {

//        #if(GLM_HAS_INITIALIZER_LISTS)
//            glm::mat3x3 m0(
//                    glm::vec3(0, 1, 2),
//        glm::vec3(3, 4, 5),
//        glm::vec3(6, 7, 8));
//
//        glm::mat3x3 m1{0, 1, 2, 3, 4, 5, 6, 7, 8};
//
//        glm::mat3x3 m2{
//            {0, 1, 2},
//            {3, 4, 5},
//            {6, 7, 8}};
//
//        Error += glm::all(glm::equal(m0, m2, glm::epsilon<float>())) ? 0 : 1;
//        Error += glm::all(glm::equal(m1, m2, glm::epsilon<float>())) ? 0 : 1;
//
//        std::vector<glm::mat3x3> v1{
//            {0, 1, 2, 3, 4, 5, 6, 7, 8},
//            {0, 1, 2, 3, 4, 5, 6, 7, 8}
//        };
//
//        std::vector<glm::mat3x3> v2{
//            {
//                { 0, 1, 2},
//                { 3, 4, 5},
//                { 6, 7, 8}
//            },
//            {
//                { 0, 1, 2},
//                { 3, 4, 5},
//                { 6, 7, 8}
//            }
//        };
//
//        #endif//GLM_HAS_INITIALIZER_LISTS
    }

    @Test
    fun cast() {
        fun entry(b: Mat3) {
            val identity = Mat3(1f)
            assert(b.allEqual(identity))
        }

        entry(Mat3(Mat2(1f)))
        entry(Mat3(Mat2x3(1f)))
        entry(Mat3(Mat2x4(1f)))
        entry(Mat3(Mat3x2(1f)))
        entry(Mat3(Mat3(1f)))
        entry(Mat3(Mat3x4(1f)))
        entry(Mat3(Mat4x2(1f)))
        entry(Mat3(Mat4x3(1f)))
        entry(Mat3(Mat4(1f)))
    }

    @Test
    fun size() {

        assert(Mat3.size == 3 * 3 * Float.BYTES)
        assert(Mat3d.size == 3 * 3 * Double.BYTES)
        assert(Mat3.length == 3 * 3)
        assert(Mat3d.length == 3 * 3)
    }
}