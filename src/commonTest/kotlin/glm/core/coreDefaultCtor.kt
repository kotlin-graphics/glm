package glm.core

import glm.assert
import glm.mat2.Mat2
import glm.mat2x3.Mat2x3
import glm.mat2x4.Mat2x4
import glm.mat3.Mat3
import glm.mat3x2.Mat3x2
import glm.mat3x4.Mat3x4
import glm.mat4.Mat4
import glm.mat4x2.Mat4x2
import glm.mat4x3.Mat4x3
import glm.vec1.Vec1i
import glm.vec2.Vec2i
import glm.vec3.Vec3i
import glm.vec4.Vec4i
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