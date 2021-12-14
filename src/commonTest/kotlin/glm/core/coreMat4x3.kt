package glm.core

import glm.assert
import glm.extensions.BYTES
import glm.mat2.Mat2
import glm.mat2x3.Mat2x3
import glm.mat2x4.Mat2x4
import glm.mat3.Mat3
import glm.mat3x2.Mat3x2
import glm.mat3x4.Mat3x4
import glm.mat4.Mat4
import glm.mat4x2.Mat4x2
import glm.mat4x3.Mat4x3
import glm.mat4x3.Mat4x3d
import glm.mat4x3.div
import glm.mat4x3.times
import glm.vec3.Vec3
import glm.vec4.Vec4
import kotlin.test.Test

class coreMat4x3 {

    @Test
    fun operators() {
        val l = Mat4x3(1f)
        val m = Mat4x3(1f)
        val u = Vec4(1f)
        val v = Vec3(1f)
        val x = 1f
        val a: Vec3 = m * u
        val b: Vec4 = v * m
        val n: Mat4x3 = x / m
        val o: Mat4x3 = m / x
        val p: Mat4x3 = x * m
        val q: Mat4x3 = m * x
        val r = m.anyNotEqual(q)
        val s = m.allEqual(l)

        assert(s && !r)
    }

    @Test
    fun ctr() {

        val m0 = Mat4x3(
            Vec3(0, 1, 2),
            Vec3(3, 4, 5),
            Vec3(6, 7, 8),
            Vec3(9, 10, 11))

        val m1 = Mat4x3(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11)

//        glm::mat4x3 m2 {
//            { 0, 1, 2 },
//            { 3, 4, 5 },
//            { 6, 7, 8 },
//            { 9, 10, 11 }
//        }

//        assert(m0.allEqual(m2))
//        Error += glm::all(glm::equal(m1, m2, glm::epsilon<float>())) ? 0 : 1

//        std::vector < glm::mat4x3 > v1 {
//            { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 },
//            { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 }
//        }
//
//        std::vector < glm::mat4x3 > v2 {
//            {
//                { 0, 1, 2 },
//                { 4, 5, 6 },
//                { 8, 9, 10 },
//                { 12, 13, 14 }
//            },
//            {
//                { 0, 1, 2 },
//                { 4, 5, 6 },
//                { 8, 9, 10 },
//                { 12, 13, 14 }
//            }
//        }
    }

    @Test
    fun cast() {
        fun entry(b: Mat4x3) {
            val identity = Mat4x3(1f)
            assert(b.allEqual(identity))
        }

        entry(Mat4x3(Mat2(1f)))
        entry(Mat4x3(Mat2x3(1f)))
        entry(Mat4x3(Mat2x4(1f)))
        entry(Mat4x3(Mat3x2(1f)))
        entry(Mat4x3(Mat3(1f)))
        entry(Mat4x3(Mat3x4(1f)))
        entry(Mat4x3(Mat4x2(1f)))
        entry(Mat4x3(Mat4x3(1f)))
        entry(Mat4x3(Mat4(1f)))
    }

    @Test
    fun size() {

        assert(Mat4x3.size == 4 * 3 * Float.BYTES)
        assert(Mat4x3d.size == 4 * 3 * Double.BYTES)
        assert(Mat4x3.length == 4 * 3)
        assert(Mat4x3d.length == 4 * 3)
    }
}