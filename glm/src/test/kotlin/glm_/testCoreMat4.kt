package glm_

import glm_.ext.equal
import glm_.mat4x4.Mat4
import glm_.mat4x4.Mat4d
import glm_.mat4x4.operators.times
import glm_.mat4x4.operators.div
import glm_.test.*
import glm_.vec4.Vec4
import glm_.vec4.Vec4d
import io.kotlintest.*
import io.kotlintest.specs.StringSpec

/**
 * Created by GBarbieri on 12.12.2016.
 */

class testCoreMat4 : StringSpec() {

    init {

        "inverse mat4" {

            val matrix = Mat4(
                    0.6f, 0.2f, 0.3f, 0.4f,
                    0.2f, 0.7f, 0.5f, 0.3f,
                    0.3f, 0.5f, 0.743f, 0.2f,
                    0.4f, 0.3f, 0.2f, 0.6f)
            val inverse = matrix.inverse()
            val identity = matrix * inverse

            matrix.print("mat")

            glm.all(glm.equal(identity[0], Vec4(1f, 0f, 0f, 0f), Vec4(0.01f))) shouldBe true
            glm.all(glm.equal(identity[1], Vec4(0f, 1f, 0f, 0f), Vec4(0.01f))) shouldBe true
            glm.all(glm.equal(identity[2], Vec4(0f, 0f, 1f, 0f), Vec4(0.01f))) shouldBe true
            glm.all(glm.equal(identity[3], Vec4(0f, 0f, 0f, 1f), Vec4(0.01f))) shouldBe true
        }

        "inverse mat4d" {
            val matrix = Mat4d(
                    0.6, 0.2, 0.3, 0.4,
                    0.2, 0.7, 0.5, 0.3,
                    0.3, 0.5, 0.7, 0.2,
                    0.4, 0.3, 0.2, 0.6)
            val identity = matrix / matrix

            glm.all(glm.equal(identity[0], Vec4d(1.0, 0.0, 0.0, 0.0), Vec4d(0.01))) shouldBe true
            glm.all(glm.equal(identity[1], Vec4d(0.0, 1.0, 0.0, 0.0), Vec4d(0.01))) shouldBe true
            glm.all(glm.equal(identity[2], Vec4d(0.0, 0.0, 1.0, 0.0), Vec4d(0.01))) shouldBe true
            glm.all(glm.equal(identity[3], Vec4d(0.0, 0.0, 0.0, 1.0), Vec4d(0.01))) shouldBe true
        }

        "operators" {

            val l = Mat4(1f)
            val m = Mat4(1f)
            val u = Vec4(1f)
            val v = Vec4(1f)
            val x = 1f
            val a = m * u
            val b = v * m
            val n = x / m
            val o = m / x
            val p = x * m
            val q = m * x
            val R = m.anyNotEqual(q, Float.MIN_VALUE)
            val S = m.allEqual(l, Float.MIN_VALUE)

            (S && !R) shouldBe true
        }

        "inverse"        {

            run {
                val matrix = Mat4(
                        Vec4(0.6f, 0.2f, 0.3f, 0.4f),
                        Vec4(0.2f, 0.7f, 0.5f, 0.3f),
                        Vec4(0.3f, 0.5f, 0.7f, 0.2f),
                        Vec4(0.4f, 0.3f, 0.2f, 0.6f))
                val inverse = matrix.inverse()
                val identity = matrix * inverse
//                print(Matrix);
//                print(Inverse);
//                print(Identity);
                identity[0].shouldEqual(Vec4(1f, 0f, 0f, 0f), 0.01f)
                identity[1].shouldEqual(Vec4(0f, 1f, 0f, 0f), 0.01f)
                identity[2].shouldEqual(Vec4(0f, 0f, 1f, 0f), 0.01f)
                identity[3].shouldEqual(Vec4(0f, 0f, 0f, 1f), 0.01f)
            }
        }

        "ctr"        {

            //            #if GLM_HAS_TRIVIAL_QUERIES
            //Error += std::is_trivially_default_constructible<glm::mat4>::value ? 0 : 1;
            //Error += std::is_trivially_copy_assignable<glm::mat4>::value ? 0 : 1;
//            Error += std::is_trivially_copyable<glm::mat4>::value ? 0 : 1;
            //Error += std::is_copy_constructible<glm::mat4>::value ? 0 : 1;
            //Error += std::has_trivial_copy_constructor<glm::mat4>::value ? 0 : 1;
//            #endif
//            #if GLM_HAS_INITIALIZER_LISTS
            val m0 = Mat4(
                    Vec4(0, 1, 2, 3),
                    Vec4(4, 5, 6, 7),
                    Vec4(8, 9, 10, 11),
                    Vec4(12, 13, 14, 15))
            assert(m0.size() == 4 * 4 * Float.BYTES)
            val V = Vec4(0, 1, 2, 3)
            val m1 = Mat4(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15)
            val m2 = Mat4 { i -> i }

            m0 shouldEqual m2
            m1 shouldEqual m2

            val m3 = arrayOf(
                    Mat4(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15),
                    Mat4(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15),
                    Mat4(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15),
                    Mat4(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15))
            val m4 = Mat4(
                    1, 0, 0, 0,
                    0, 1, 0, 0,
                    0, 0, 1, 0,
                    0, 0, 0, 1)
            m4[0][0].equal(1f, 0.0001f) shouldBe true
            m4[3][3].equal(1f, 0.0001f) shouldBe true
//            val v1 = arrayOf(
//                Mat4(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15),
//                Mat4(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15))
//            std::vector < glm::mat4 > v2 {
//                {
//                    { 0, 1, 2, 3 },
//                    { 4, 5, 6, 7 },
//                    { 8, 9, 10, 11 },
//                    { 12, 13, 14, 15 }
//                },
//                {
//                    { 0, 1, 2, 3 },
//                    { 4, 5, 6, 7 },
//                    { 8, 9, 10, 11 },
//                    { 12, 13, 14, 15 }
//                }
//            };
//            #endif//GLM_HAS_INITIALIZER_LISTS
        }

        "rotate" {

            val rotate = glm.rotate(Mat4(), 1f, 2f, 3f, 4f)

            glm.all(glm.equal(rotate[0], Vec4(x = 0.60370886, y = 0.7201388, z = -0.34195852, w = 0.0), Vec4(0.01f))) shouldBe true
            glm.all(glm.equal(rotate[1], Vec4(x = -0.529919, y = 0.68296707, z = 0.5027342, w = 0.0), Vec4(0.01f))) shouldBe true
            glm.all(glm.equal(rotate[2], Vec4(x = 0.59558487, y = -0.12229471, z = 0.7939286, w = 0.0), Vec4(0.01f))) shouldBe true
            glm.all(glm.equal(rotate[3], Vec4(x = 0.0, y = 0.0, z = 0.0, w = 1.0), Vec4(0.01f))) shouldBe true
        }

        "test multiplication" {

            val m1f = Mat4(List(16) { it + 1f })
            val m2f = Mat4(List(16) { it + 17f })

            val m1d = Mat4d(List(16) { it + 1.0 })
            val m2d = Mat4d(List(16) { it + 17.0 })

            val expectedF = Mat4(538, 612, 686, 760,
                    650, 740, 830, 920,
                    762, 868, 974, 1080,
                    874, 996, 1118, 1240)

            val resultF = m1f * m2f

            val expectedD = Mat4d(538, 612, 686, 760,
                    650, 740, 830, 920,
                    762, 868, 974, 1080,
                    874, 996, 1118, 1240)
            val resultD = m1d * m2d

            assertSoftly {
                resultF shouldBe (expectedF plusOrMinus 0.000001f)
                resultD shouldBe (expectedD plusOrMinus 0.000001)
            }
        }

//        namespace cast TODO
//                {
//                    template<typename genType>
//                    int entry()
//                    {
//                        int Error = 0;
//
//                        genType A(1.0f);
//                        glm::mat4x4 B(A);
//                        glm::mat4x4 Identity(1.0f);
//
//                        for(glm::length_t i = 0, length = B.length(); i < length; ++i)
//                        Error += glm::all(glm::equal(B[i], Identity[i], glm::epsilon<float>())) ? 0 : 1;
//
//                        return Error;
//                    }
//
//                    int test()
//                    {
//                        int Error = 0;
//
//                        Error += entry<glm::mat2x2>();
//                        Error += entry<glm::mat2x3>();
//                        Error += entry<glm::mat2x4>();
//                        Error += entry<glm::mat3x2>();
//                        Error += entry<glm::mat3x3>();
//                        Error += entry<glm::mat3x4>();
//                        Error += entry<glm::mat4x2>();
//                        Error += entry<glm::mat4x3>();
//                        Error += entry<glm::mat4x4>();
//
//                        return Error;
//                    }
//                }
    }
}