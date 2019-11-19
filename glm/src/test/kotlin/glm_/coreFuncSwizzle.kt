package glm_

import glm_.ext.equal
import glm_.vec1.Vec1i
import glm_.vec2.Vec2i
import glm_.vec2.swizzle.xy
import glm_.vec2.swizzle.yx
import glm_.vec3.Vec3i
import glm_.vec3.swizzle.*
import glm_.vec4.Vec4
import glm_.vec4.Vec4i
import glm_.vec4.swizzle.wzyx
import glm_.vec4.swizzle.xyzw
import io.kotlintest.shouldBe
import io.kotlintest.shouldNotBe
import io.kotlintest.specs.StringSpec
import kotlin.math.abs

class coreFuncSwizzle : StringSpec() {

    init {
        "ivec2 swizzle"        {

            //            #	if GLM_SWIZZLE
            run {
                val A = Vec2i(1, 2)
                val B = A.yx
                val C = Vec2i(B.yx)

                A shouldNotBe B
                A shouldBe C
            }
//            #	endif//GLM_SWIZZLE

//            #	if GLM_SWIZZLE == GLM_SWIZZLE_OPERATOR
            run {
                val A = Vec2i(1, 2)
                val B = A.yx
                val C = Vec2i(A.yx)

                A shouldNotBe B
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
                val B = A.zyx
                val C = Vec3i(B.zyx)

                A shouldNotBe B
                A shouldBe C
            }
//            #	endif//GLM_SWIZZLE == GLM_ENABLE

//            #	if GLM_SWIZZLE == GLM_SWIZZLE_OPERATOR
            run {
                val A = Vec3i(1, 2, 3)
                val B = A.yx
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

                val F = A.xxx + A.xxx
                F shouldBe Vec3i(2)

                val G = A.xxx - A.xxx
                G shouldBe Vec3i(0)

                val H = A.xxx * A.xxx
                H shouldBe Vec3i(1)

                val I = A.xxx / A.xxx
                I shouldBe Vec3i(1)

                val J = Vec3i(1, 2, 3)
//                Vec3i(J.xyz) += Vec3i(1)  TODO
                J.xyz = Vec3i(1) + J.xyz
                J shouldBe Vec3i(2, 3, 4)

                val K = Vec3i(1, 2, 3)
                K.xyz = A.xyz + K.xyz
                K shouldBe Vec3i(2, 4, 6)
            }
//            #	endif//GLM_SWIZZLE
        }

        "ivec4 swizzle"        {

            //            #if GLM_SWIZZLE == GLM_ENABLE
            val A = Vec4i(1, 2, 3, 4)
            val B = A.wzyx
            val C = Vec4i(B.wzyx)

            A shouldNotBe B
            A shouldBe C
//            #endif//GLM_SWIZZLE == GLM_ENABLE
        }

        "vec4 swizzle"        {

            //            #if GLM_SWIZZLE == GLM_ENABLE
            val A = Vec4(1, 2, 3, 4)
            val B = A.wzyx
            val C = Vec4(B.wzyx)

            A shouldNotBe B
            A shouldEqual C

            val D = glm.dot(C.wzyx, C.xyzw)
            D.equal(20f, 0.01f) shouldBe true
//            #endif//GLM_SWIZZLE == GLM_ENABLE
        }
    }
}