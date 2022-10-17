package glm_.func

import glm_.extensions.f
import glm_.mat2.Mat2
import glm_.mat2x3.Mat2x3
import glm_.mat2x4.Mat2x4
import glm_.mat3.Mat3
import glm_.mat3x2.Mat3x2
import glm_.mat3x4.Mat3x4
import glm_.mat4.Mat4
import glm_.mat4x2.Mat4x2
import glm_.mat4x3.Mat4x3
import glm_.scalar.pow
import glm_.shouldEqual
import glm_.vec2.Vec2
import glm_.vec3.Vec3
import glm_.vec4.Vec4
import kotlin.test.Test

class funcMatrix {

    @Test
    fun matrixCompMult() {

        run {
            val m = Mat2 { i -> i.f }
            val n = m compMult m
            val expected = Mat2 { i -> i.f pow 2 }
            n shouldEqual expected
        }

        run {
            val m = Mat2x3 { i -> i.f }
            val n = m compMult m
            val expected = Mat2x3 { i -> i.f pow 2 }
            n shouldEqual expected
        }

        run {
            val m = Mat2x4 { i -> i.f }
            val n = m compMult m
            val expected = Mat2x4 { i -> i.f pow 2 }
            n shouldEqual expected
        }

        run {
            val m = Mat3 { i -> i.f }
            val n = m compMult m
            val expected = Mat3 { i -> i.f pow 2 }
            n shouldEqual expected
        }

        run {
            val m = Mat3x2 { i -> i.f }
            val n = m compMult m
            val expected = Mat3x2 { i -> i.f pow 2 }
            n shouldEqual expected
        }

        run {
            val m = Mat3x4 { i -> i.f }
            val n = m compMult m
            val expected = Mat3x4 { i -> i.f pow 2 }
            n shouldEqual expected
        }

        run {
            val m = Mat4 { i -> i.f }
            val n = m compMult m
            val expected = Mat4 { i -> i.f pow 2 }
            n shouldEqual expected
        }

        run {
            val m = Mat4x2 { i -> i.f }
            val n = m compMult m
            val expected = Mat4x2 { i -> i.f pow 2 }
            n shouldEqual expected
        }

        run {
            val m = Mat4x3 { i -> i.f }
            val n = m compMult m
            val expected = Mat4x3 { i -> i.f pow 2 }
            n shouldEqual expected
        }
    }

    @Test
    fun outerProduct() {
        Vec2(1f) outerProduct Vec2(1f) shouldEqual Mat2 { _ -> 1f }
        Vec3(1f) outerProduct Vec3(1f) shouldEqual Mat3 { _ -> 1f }
        Vec4(1f) outerProduct Vec4(1f) shouldEqual Mat4 { _ -> 1f }

        Vec3(1f) outerProduct Vec2(1f) shouldEqual Mat2x3 { _ -> 1f }
        Vec4(1f) outerProduct Vec2(1f) shouldEqual Mat2x4 { _ -> 1f }

        Vec2(1f) outerProduct Vec3(1f) shouldEqual Mat3x2 { _ -> 1f }
        Vec4(1f) outerProduct Vec3(1f) shouldEqual Mat3x4 { _ -> 1f }

        Vec2(1f) outerProduct Vec4(1f) shouldEqual Mat4x2 { _ -> 1f }
        Vec3(1f) outerProduct Vec4(1f) shouldEqual Mat4x3 { _ -> 1f }
    }

    @Test
    fun transpose() {
        Mat2 { i -> i.f }.transpose() shouldEqual Mat2(0, 2, 1, 3)
        Mat2x3 { i -> i.f }.transpose() shouldEqual Mat3x2(0, 3, 1, 4, 2, 5)
        Mat2x4 { i -> i.f }.transpose() shouldEqual Mat4x2(0, 4, 1, 5, 2, 6, 3, 7)
        Mat3 { i -> i.f }.transpose() shouldEqual Mat3(0, 3, 6, 1, 4, 7, 2, 5, 8)
        Mat3x2 { i -> i.f }.transpose() shouldEqual Mat2x3(0, 2, 4, 1, 3, 5)
        Mat3x4 { i -> i.f }.transpose() shouldEqual Mat4x3(0, 4, 8, 1, 5, 9, 2, 6, 10, 3, 7, 11)
        Mat4 { i -> i.f }.transpose() shouldEqual Mat4(0, 4, 8, 12, 1, 5, 9, 13, 2, 6, 10, 14, 3, 7, 11, 15)
        Mat4x2 { i -> i.f }.transpose() shouldEqual Mat2x4(0, 2, 4, 6, 1, 3, 5, 7)
        Mat4x3 { i -> i.f }.transpose() shouldEqual Mat3x4(0, 3, 6, 9, 1, 4, 7, 10, 2, 5, 8, 11)
    }

    @Test
    fun determinant() {

        Mat2 { i -> i.f }.determinant() shouldEqual -2f
        Mat3 { i -> i.f }.determinant() shouldEqual 0f
        Mat4 { i -> i.f }.determinant() shouldEqual 0f
    }

    @Test
    fun inverse() {
        run {
            val a = Mat4(1, 0, 1, 0,
                            0, 1, 0, 0,
                            0, 0, 1, 0,
                            0, 0, 0, 1)
            val b = a.inverse()
            val i = a * b
            val identity = Mat4(1)
            i shouldEqual identity
        }

        run {
            val a = Mat3(1, 0, 1,
                         0, 1, 0,
                         0, 0, 1)
            val b = a.inverse()
            val i = a * b
            val identity = Mat3(1)
            i shouldEqual identity
        }

        run {
            val a = Mat2(1, 1,
                         0, 1)
            val b = a.inverse()
            val i = a * b
            val identity = Mat2(1)
            i shouldEqual identity
        }
    }
}