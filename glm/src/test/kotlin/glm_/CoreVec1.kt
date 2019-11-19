package glm_

import glm_.vec1.Vec1
import glm_.vec1.Vec1d
import glm_.vec1.Vec1i
import glm_.vec2.Vec2
import glm_.vec2.Vec2d
import glm_.vec2.Vec2i
import glm_.vec2.operators.timesAssign
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class CoreVec1 : StringSpec() {

    init {

        "vec1 operators"        {

            val A = Vec1i(1)
            val B = Vec1i(1)
            run {
                val R = A != B
                val S = A == B

                (S && !R) shouldBe true
            }

            run {
                A *= 1
                B *= 1
                A += 1
                B += 1

                val R = A != B
                val S = A == B

                (S && !R) shouldBe true
            }
        }

//        int test_vec1_ctor()
//        {
//            int Error = 0;
//
//            #	if GLM_HAS_TRIVIAL_QUERIES
//            //	Error += std::is_trivially_default_constructible<glm::vec1>::value ? 0 : 1;
//            //	Error += std::is_trivially_copy_assignable<glm::vec1>::value ? 0 : 1;
//            Error += std::is_trivially_copyable<glm::vec1>::value ? 0 : 1;
//            Error += std::is_trivially_copyable<glm::dvec1>::value ? 0 : 1;
//            Error += std::is_trivially_copyable<glm::ivec1>::value ? 0 : 1;
//            Error += std::is_trivially_copyable<glm::uvec1>::value ? 0 : 1;
//
//            Error += std::is_copy_constructible<glm::vec1>::value ? 0 : 1;
//            #	endif
//
///*
//#if GLM_HAS_INITIALIZER_LISTS
//	{
//		glm::vec1 a{ 0 };
//		std::vector<glm::vec1> v = {
//			{0.f},
//			{4.f},
//			{8.f}};
//	}
//
//	{
//		glm::dvec2 a{ 0 };
//		std::vector<glm::dvec1> v = {
//			{0.0},
//			{4.0},
//			{8.0}};
//	}
//#endif
//*/
//
            run {
                val A = Vec2(2f)
                val B = Vec2(2f, 3f)
                val C = Vec2(2f, 3.0)
                //glm::vec2 D = glm::dvec2(2.0); // Build error TODO: What does the specification says?
                val E = Vec2(Vec2d(2.0))
                val F = Vec2(Vec2i(2))
            }

        "vec1 size"        {
            Vec1.size shouldBe Float.BYTES
            Vec1d.size shouldBe Double.BYTES
        }

        "vec1 operator increment"        {

            val v0 = Vec1i(1)
            var v1 = Vec1i(v0)
            var v2 = Vec1i(v0)
            val v3 = ++v1
            val v4 = v2++

            v0 shouldBe v4
            v1 shouldBe v2
            v1 shouldBe v3

            val i0 = 1
            var i1 = i0
            var i2 = i0
            val i3 = ++i1
            val i4 = i2++

            i0 shouldBe i4
            i1 shouldBe i2
            i1 shouldBe i3
        }

        "test swizzle"        {

//            #if GLM_HAS_ANONYMOUS_STRUCT && GLM_SWIZZLE == GLM_ENABLE
//            {
                val A = Vec1(1f)
                //glm::vec1 B = A.x;
                val C = Vec1(A.x)

                //Error += glm::all(glm::equal(A, B)) ? 0 : 1;
                A shouldEqual C
            }
//            #endif//GLM_SWIZZLE == GLM_ENABLE

//        static int test_constexpr()
//        {
//            #if GLM_HAS_CONSTEXPR_CXX14
//            static_assert(glm::vec1::length() == 1, "GLM: Failed constexpr");
//            static_assert(glm::vec1(1.0f).x > 0.0f, "GLM: Failed constexpr");
//            #endif
//
//            return 0;
//        }
    }
}