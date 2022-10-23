package glm_.ext

import glm_.mat2.Mat2i
import glm_.mat2x3.Mat2x3i
import glm_.mat2x4.Mat2x4i
import glm_.mat3.Mat3i
import glm_.mat3x2.Mat3x2i
import glm_.mat3x4.Mat3x4i
import glm_.mat4.Mat4i
import glm_.mat4x2.Mat4x2i
import glm_.mat4x3.Mat4x3i
import glm_.shouldBe
import glm_.vec2.Vec2i
import glm_.vec3.Vec3i
import glm_.vec4.Vec4i
import kotlin.test.Test

class matrixInteger {

    @Test
    fun matrixCompMult() {

        run {
            val m = Mat2i { i -> i }
            val n = m compMult m
            val expected = Mat2i { i -> i * i }
            n.equal(expected).all() shouldBe true
        }

        run {
            val m = Mat2x3i { i -> i }
            val n = m compMult m
            val expected = Mat2x3i { i -> i * i }
            n.equal(expected).all() shouldBe true
        }

        run {
            val m = Mat2x4i { i -> i }
            val n = m compMult m
            val expected = Mat2x4i { i -> i * i }
            n.equal(expected).all() shouldBe true
        }

        run {
            val m = Mat3i { i -> i }
            val n = m compMult m
            val expected = Mat3i { i -> i * i }
            n.equal(expected).all() shouldBe true
        }

        run {
            val m = Mat3x2i { i -> i }
            val n = m compMult m
            val expected = Mat3x2i { i -> i * i }
            n.equal(expected).all() shouldBe true
        }

        run {
            val m = Mat3x4i { i -> i }
            val n = m compMult m
            val expected = Mat3x4i { i -> i * i }
            n.equal(expected).all() shouldBe true
        }

        run {
            val m = Mat4i { i -> i }
            val n = m compMult m
            val expected = Mat4i { i -> i * i }
            n.equal(expected).all() shouldBe true
        }

        run {
            val m = Mat4x2i { i -> i }
            val n = m compMult m
            val expected = Mat4x2i { i -> i * i }
            n.equal(expected).all() shouldBe true
        }

        run {
            val m = Mat4x3i { i -> i }
            val n = m compMult m
            val expected = Mat4x3i { i -> i * i }
            n.equal(expected).all() shouldBe true
        }
    }

    @Test
    fun outerProduct() {

        run {
            val m = Vec2i(1) outerProduct Vec2i(1)
            m.equal(Mat2i { _ -> 1 }).all() shouldBe true
        }
        run {
            val m = Vec3i(1) outerProduct Vec2i(1)
            m.equal(Mat2x3i { _ -> 1 }).all() shouldBe true
        }
        run {
            val m = Vec4i(1) outerProduct Vec2i(1)
            m.equal(Mat2x4i{_->1}).all() shouldBe true
        }

        run {
            val m = Vec2i(1) outerProduct Vec3i(1)
            m.equal(Mat3x2i{_->1}).all() shouldBe true
        }
        run{
            val m = Vec3i(1) outerProduct Vec3i(1)
            m.equal(Mat3i{_->1}).all() shouldBe true
        }
        run {
            val m = Vec4i(1) outerProduct Vec3i(1)
            m.equal(Mat3x4i { _->1 }).all() shouldBe true
        }


        run {
            val m = Vec2i(1) outerProduct Vec4i(1)
            m.equal(Mat4x2i { _->1 }).all() shouldBe true
        }
        run {
            val m = Vec3i(1) outerProduct Vec4i(1)
            m.equal(Mat4x3i{_->1}).all() shouldBe true
        }
        run {
            val m = Vec4i(1) outerProduct Vec4i(1)
            m.equal(Mat4i { _->1 }).all() shouldBe true
        }
    }

    @Test
    fun transpose() {

        run {
            val m = Mat2i{i -> i }
            val t = m.transpose()
            val expected = Mat2i(0, 2, 1, 3)
            t.equal(expected).all() shouldBe true
        }

        run {
            val m = Mat2x3i{i -> i }
            val t = m.transpose ()
            val expected = Mat3x2i(0, 3, 1, 4, 2, 5)
            t.equal(expected).all() shouldBe true
        }

        run {
            val m = Mat2x4i{i -> i }
            val t = m.transpose ()
            val expected = Mat4x2i(0, 4, 1, 5, 2, 6, 3, 7)
            t.equal(expected) .all() shouldBe true
        }

        run {
            val m = Mat3i{i -> i }
            val t = m.transpose ()
            val expected = Mat3i(0, 3, 6, 1, 4, 7, 2, 5, 8)
            t.equal( expected).all() shouldBe true
        }

        run {
            val m = Mat3x2i{i -> i }
            val t = m.transpose ()
            val expected = Mat2x3i(0, 2, 4, 1, 3, 5)
            t.equal(expected).all() shouldBe true
        }

        run {
            val m = Mat3x4i {i -> i }
            val t = m.transpose ()
            val expected = Mat4x3i(0, 4, 8, 1, 5, 9, 2, 6, 10, 3, 7, 11)
            t.equal(expected).all()shouldBe true
        }

        run {
            val m = Mat4i{i -> i }
            val t = m.transpose ()
            val expected = Mat4i(0, 4, 8, 12, 1, 5, 9, 13, 2, 6, 10, 14, 3, 7, 11, 15)
            t.equal(expected).all() shouldBe true
        }

        run {
            val m = Mat4x2i{i -> i }
            val t = m.transpose ()
            val expected = Mat2x4i(0, 2, 4, 6, 1, 3, 5, 7)
            t.equal(expected).all() shouldBe true
        }

        run {
            val m = Mat4x3i {i -> i }
            val t = m.transpose ()
            val expected = Mat3x4i(0, 3, 6, 9, 1, 4, 7, 10, 2, 5, 8, 11)
            t.equal(expected).all() shouldBe true
        }
    }

    @Test
    fun determinant() {

        run {
            val m = Mat2i{_ -> 1 }
            val t = m.determinant()
            t shouldBe 0
        }

        run {
            val m = Mat3i{_->1}
            val t = m.determinant ()
            t shouldBe 0
        }

        run {
            val m = Mat4i{_->1}
            val t = m.determinant ()
            t shouldBe 0
        }
    }
}