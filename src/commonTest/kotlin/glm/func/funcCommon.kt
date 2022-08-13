package glm.func

import glm.assert
import glm.equal
import glm.floor
import glm.modf
import glm.vec1.Vec1
import glm.vec1.Vec1d
import glm.vec2.Vec2
import glm.vec2.Vec2d
import glm.vec3.Vec3
import glm.vec3.Vec3d
import glm.vec4.Vec4
import glm.vec4.Vec4d
import kotlin.test.Test

class funcCommon {

    @Test
    fun floor() {

        run {
            val a = 1.1f
            val b = a.floor()
            assert(b.equal(1f, 0.0001f))
        }

        run {
            val a = 1.1
            val b = a.floor()
            assert(b.equal(1.0, 0.0001))
        }

        run {
            val a = Vec1(1.1f)
            val b = a.floor()

            assert(b.allEqual(Vec1(1.0), 0.0001f))
        }

        run {
            val a = Vec1d(1.1)
            val b = a.floor()

            assert(b.allEqual(Vec1d(1.0), 0.0001))
        }

        run {
            val a = Vec2(1.1f)
            val b = a.floor()

            assert(b.allEqual(Vec2(1.0), 0.0001f))
        }

        run {
            val a = Vec2d(1.1)
            val b = a.floor()

            assert(b.allEqual(Vec2d(1.0), 0.0001))
        }

        run {
            val a = Vec3(1.1f)
            val b = a.floor()

            assert(b.allEqual(Vec3(1.0), 0.0001f))
        }

        run {
            val a = Vec3d(1.1)
            val b = a.floor()

            assert(b.allEqual(Vec3d(1.0), 0.0001))
        }

        run {
            val a = Vec4(1.1f)
            val b = a.floor()

            assert(b.allEqual(Vec4(1.0), 0.0001f))
        }

        run {
            val a = Vec4d(1.1)
            val b = a.floor()

            assert(b.allEqual(Vec4d(1.0), 0.0001))
        }
    }

    @Test
    fun modf() {

        run {
            val x = 1.5f
            val i: Float
            val a = x.modf { i = it }

            assert(i.equal(1f, 0.0001f))
            assert(a.equal(0.5f, 0.0001f))
        }

//        run {
//            val x = Vec4(1.1f, 1.2f, 1.5f, 1.7f)
//            glm::vec4 I (0.0f)
//            glm::vec4 A = glm ::modf(X, I)
//
//            Error += glm::ivec4(I) == glm::ivec4(1) ? 0 : 1
//            Error += glm::all(glm::equal(A, glm::vec4(0.1f, 0.2f, 0.5f, 0.7f), 0.00001f)) ? 0 : 1
//        }
//
//        {
//            glm::dvec4 X (1.1, 1.2, 1.5, 1.7)
//            glm::dvec4 I (0.0)
//            glm::dvec4 A = glm ::modf(X, I)
//
//            Error += glm::ivec4(I) == glm::ivec4(1) ? 0 : 1
//            Error += glm::all(glm::equal(A, glm::dvec4(0.1, 0.2, 0.5, 0.7), 0.000000001)) ? 0 : 1
//        }
//
//        {
//            double X (1.5)
//            double I (0.0)
//            double A = glm ::modf(X, I)
//
//            Error += glm::equal(I, 1.0, 0.0001) ? 0 : 1
//            Error += glm::equal(A, 0.5, 0.0001) ? 0 : 1
//        }
    }
}