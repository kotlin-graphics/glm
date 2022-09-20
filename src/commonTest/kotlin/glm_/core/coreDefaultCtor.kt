package glm_.core

import glm_.assert
import glm_.mat2.Mat2
import glm_.mat2x3.Mat2x3
import glm_.mat2x4.Mat2x4
import glm_.mat3.Mat3
import glm_.mat3x2.Mat3x2
import glm_.mat3x4.Mat3x4
import glm_.mat4.Mat4
import glm_.mat4x2.Mat4x2
import glm_.mat4x3.Mat4x3
import glm_.vec1.Vec1i
import glm_.vec2.Vec2i
import glm_.vec3.Vec3i
import glm_.vec4.Vec4i
import kotlin.test.Test

class coreDefaultCtor {

    @Test
    fun `vec memcpy`() {

        run {
            val a = Vec1i(76)
            val b = Vec1i()
            a.array.copyInto(b.array)
            assert(b == a)
        }

        run {
            val a = Vec2i(76)
            val b = Vec2i()
            a.array.copyInto(b.array)
            assert(b == a)
        }

        run {
            val a = Vec3i(76)
            val b = Vec3i()
            b.array.copyInto(a.array)
            assert(b == a)
        }

        run {
            val a = Vec4i(76)
            val b = Vec4i()
            a.array.copyInto(b.array)
            assert(b == a)
        }
    }

    @Test
    fun `mat memcpy`() {

        run {
            val a = Mat2(76)
            val b = Mat2()
            a.array.copyInto(b.array)
            assert(b.allEqual(a))
        }

        run {
            val a = Mat2x3(76)
            val b = Mat2x3()
            a.array.copyInto(b.array)
            assert(b.allEqual(a))
        }

        run {
            val a = Mat2x4(76)
            val b = Mat2x4()
            a.array.copyInto(b.array)
            assert(b.allEqual(a))
        }

        run {
            val a = Mat3x2(76)
            val b = Mat3x2()
            a.array.copyInto(b.array)
            assert(b.allEqual(a))
        }

        run {
            val a = Mat3(76)
            val b = Mat3()
            a.array.copyInto(b.array)
            assert(b.allEqual(a))
        }

        run {
            val a = Mat3x4(76)
            val b = Mat3x4()
            a.array.copyInto(b.array)
            assert(b.allEqual(a))
        }

        run {
            val a = Mat4x2(76)
            val b = Mat4x2()
            a.array.copyInto(b.array)
            assert(b.allEqual(a))
        }

        run {
            val a = Mat4x3(76)
            val b = Mat4x3()
            a.array.copyInto(b.array)
            assert(b.allEqual(a))
        }

        run {
            val a = Mat4(76)
            val b = Mat4()
            a.array.copyInto(b.array)
            assert(b.allEqual(a))
        }
    }
}