package glm_

import glm_.vec1.Vec1i
import glm_.vec2.Vec2i
import glm_.vec3.Vec3i
import glm_.vec4.Vec4
import glm_.vec4.Vec4i
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec
import kotlin.math.abs

class coreFuncSwizzle: StringSpec() {

    init {
        "ivec2 swizzle"        {

//            #	if GLM_SWIZZLE
            run {
                val A = Vec2i(1, 2)
                val B = Vec2i(A.yx)
                val C = Vec2i(B.yx)

                assert(A != B)
                A shouldBe C
            }
//            #	endif//GLM_SWIZZLE

//            #	if GLM_SWIZZLE == GLM_SWIZZLE_OPERATOR
            run {
                val A = Vec2i(1, 2)
                val B = Vec2i(A.yx)
                val C = Vec2i(A.yx)

                assert(A != B)
                B shouldBe C

                B.xy = B.yx
                C.xy = C.yx

                B shouldBe C

                val D = Vec2i(0, 0)
                D.yx = A.xy
                A.yx shouldBe D

                val E = Vec2i(A.yx)
                E shouldBe D
            }
//            #	endif//GLM_SWIZZLE
        }

        "ivec3 swizzle"        {

//            #	if GLM_SWIZZLE == GLM_ENABLE
            run {
                val A = Vec3i(1, 2, 3)
                val B = Vec3i(A.zyx)
                val C = Vec3i(B.zyx)

                assert(A != B)
                A shouldBe C
            }
//            #	endif//GLM_SWIZZLE == GLM_ENABLE

//            #	if GLM_SWIZZLE == GLM_SWIZZLE_OPERATOR
            run {
                val A = Vec3i(1, 2, 3)
                val B = Vec2i(A.yx)
                val C = Vec2i(A.yx)

                A.yx shouldBe B
                B shouldBe C

                B.xy = B.yx
                C.xy = C.yx

                B shouldBe C

                val D = Vec2i(0, 0)
                D.yx = A.xy

                A.yx shouldBe D

                val E = Vec2i(0, 0)
                E.xy = A.xy

                E shouldBe A.xy
                E.xy shouldBe A.xy

                val F = Vec3i(A.xxx) + A.xxx
                F shouldBe Vec3i(2)

                val G = Vec3i(A.xxx) - A.xxx
                G shouldBe Vec3i(0)

                val H = Vec3i(A.xxx) * A.xxx
                H shouldBe Vec3i(1)

                val I = Vec3i(A.xxx) / A.xxx
                I shouldBe Vec3i(1)

                val J = Vec3i(1, 2, 3)
//                Vec3i(J.xyz) += Vec3i(1)  TODO
                J.xyz = Vec3i(1) + J.xyz
                J shouldBe Vec3i(2, 3, 4)

                val K = Vec3i(1, 2, 3)
                K.xyz = Vec3i(A.xyz) + K.xyz
                K shouldBe Vec3i(2, 4, 6)
            }
//            #	endif//GLM_SWIZZLE
        }

        "ivec4 swizzle"        {

//            #if GLM_SWIZZLE == GLM_ENABLE
            val A = Vec4i(1, 2, 3, 4)
            val B = Vec4i(A.wzyx)
            val C = Vec4i(B.wzyx)

            assert(A != B)
            A shouldBe C
//            #endif//GLM_SWIZZLE == GLM_ENABLE
        }

        "vec4 swizzle"        {

//            #if GLM_SWIZZLE == GLM_ENABLE
            val A = Vec4(1, 2, 3, 4)
            val B = Vec4(A.wzyx)
            val C = Vec4(B.wzyx)

            assert(A != B)
            A shouldBe C

            val f = glm.dot(Vec4(C.wzyx), Vec4(C.xyzw))
            assert(abs(f - 20f) < 0.01f)
//            #endif//GLM_SWIZZLE == GLM_ENABLE
        }
    }
}