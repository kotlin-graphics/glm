package glm_

import glm_.vec1.Vec1
import glm_.vec1.Vec1d
import glm_.vec2.Vec2
import glm_.vec3.Vec3
import glm_.vec4.Vec4
import glm_.vec4.Vec4bool
import glm_.vec4.Vec4d
import glm_.vec4.Vec4i
import glm_.vec4.operators.div
import glm_.vec4.operators.minus
import glm_.vec4.operators.plus
import glm_.vec4.operators.times
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class testCoreVec4 : StringSpec() {

    init {

        "ctor"        {

            run {
                val A = Vec4i(1, 2, 3, 4)
                val B = Vec4i(A)
                A shouldBe B
            }

//            #	if GLM_HAS_TRIVIAL_QUERIES
//            //	Error += std::is_trivially_default_constructible<glm::vec4>::value ? 0 : 1;
//            //	Error += std::is_trivially_copy_assignable<glm::vec4>::value ? 0 : 1;
//            Error += std::is_trivially_copyable<glm::vec4>::value ? 0 : 1;
//            Error += std::is_trivially_copyable<glm::dvec4>::value ? 0 : 1;
//            Error += std::is_trivially_copyable<glm::ivec4>::value ? 0 : 1;
//            Error += std::is_trivially_copyable<glm::uvec4>::value ? 0 : 1;
//
//            Error += std::is_copy_constructible<glm::vec4>::value ? 0 : 1;
//            #	endif
//
//            #if GLM_HAS_INITIALIZER_LISTS
//            {
//                glm::vec4 a{ 0, 1, 2, 3 };
//                std::vector<glm::vec4> v = {
//                    {0, 1, 2, 3},
//                    {4, 5, 6, 7},
//                    {8, 9, 0, 1}};
//            }
//
//            {
//                glm::dvec4 a{ 0, 1, 2, 3 };
//                std::vector<glm::dvec4> v = {
//                    {0, 1, 2, 3},
//                    {4, 5, 6, 7},
//                    {8, 9, 0, 1}};
//            }
//            #endif

            run {
                val A = Vec4(1f, 2f, 3f, 4f)
                val B = Vec4(A.xyzw)
                val C = Vec4(A.xyzw)
                val D = Vec4(A.xyzw)
                val E = Vec4(A.x, A.yzw)
                val F = Vec4(A.x, A.yzw)
                val G = Vec4(A.xyz, A.w)
                val H = Vec4(A.xyz, A.w)
                val I = Vec4(A.xy, A.zw)
                val J = Vec4(A.xy, A.zw)
                val K = Vec4(A.x, A.y, A.zw)
                val L = Vec4(A.x, A.yz, A.w)
                val M = Vec4(A.xy, A.z, A.w)

                A shouldBe B
                A shouldBe C
                A shouldBe D
                A shouldBe E
                A shouldBe F
                A shouldBe G
                A shouldBe H
                A shouldBe I
                A shouldBe J
                A shouldBe K
                A shouldBe L
                A shouldBe M
            }
//            #endif// GLM_HAS_UNRESTRICTED_UNIONS && defined(GLM_FORCE_SWIZZLE)

//            #	if GLM_HAS_CONSTEXPR && GLM_ARCH == GLM_ARCH_PURE && !(GLM_COMPILER & GLM_COMPILER_VC) // Visual Studio bug?
//            {
//                constexpr glm::ivec4 v(1);
//
//                Error += v.x == 1 ? 0 : 1;
//                Error += v.y == 1 ? 0 : 1;
//                Error += v.z == 1 ? 0 : 1;
//                Error += v.w == 1 ? 0 : 1;
//            }
//            #	endif
//
//            {
//                glm::vec4 A(1);
//                glm::vec4 B(1, 1, 1, 1);
//
//                Error += A == B ? 0 : 1;
//            }
//
            run {
                arrayOf(
                        Vec4(Vec2(1, 2), 3, 4),
                        Vec4(1, Vec2(2, 3), 4),
                        Vec4(1, 2, Vec2(3, 4)),
                        Vec4(Vec3(1, 2, 3), 4),
                        Vec4(1, Vec3(2, 3, 4)),
                        Vec4(Vec2(1, 2), Vec2(3, 4)),
                        Vec4(1, 2, 3, 4),
                        Vec4(Vec4(1, 2, 3, 4))).forEach { it shouldBe Vec4(1, 2, 3, 4) }
            }

            run {
                val R = Vec1(1f)
                val S = Vec1(2f)
                val T = Vec1(3f)
                val U = Vec1(4.0f)
                val O = Vec4(1f, 2f, 3f, 4f)

                val A = Vec4(R)
                val B = Vec4(1f)
                A shouldBe B

                val C = Vec4(R, S, T, U)
                C shouldBe O

                val D = Vec4(R, 2f, 3f, 4f)
                D shouldBe O

                val E = Vec4(1f, S, 3f, 4f)
                E shouldBe O

                val F = Vec4(R, S, 3f, 4f)
                F shouldBe O

                val G = Vec4(1f, 2f, T, 4f)
                G shouldBe O

                val H = Vec4(R, 2f, T, 4f)
                H shouldBe O

                val I = Vec4(1f, S, T, 4f)
                I shouldBe O

                val J = Vec4(R, S, T, 4f)
                J shouldBe O

                val K = Vec4(R, 2f, 3f, U)
                K shouldBe O

                val L = Vec4(1f, S, 3f, U)
                L shouldBe O

                val M = Vec4(R, S, 3f, U)
                M shouldBe O

                val N = Vec4(1f, 2f, T, U)
                N shouldBe O

                val P = Vec4(R, 2f, T, U)
                P shouldBe O

                val Q = Vec4(1f, S, T, U)
                Q shouldBe O

                val V = Vec4(R, S, T, U)
                V shouldBe O
            }

            run {
                val R = Vec1(1f)
                val S = Vec1d(2.0)
                val T = Vec1(3.0)
                val U = Vec1d(4.0)
                val O = Vec4(1f, 2.0, 3f, 4.0)

                val A = Vec4(R)
                val B = Vec4(1.0)
                A shouldBe B

                val C = Vec4(R, S, T, U)
                C shouldBe O

                val D = Vec4(R, 2f, 3.0, 4f)
                D shouldBe O

                val E = Vec4(1.0, S, 3f, 4.0)
                E shouldBe O

                val F = Vec4(R, S, 3.0, 4f)
                F shouldBe O

                val G = Vec4(1f, 2.0, T, 4.0)
                G shouldBe O

                val H = Vec4(R, 2.0, T, 4.0)
                H shouldBe O

                val I = Vec4(1.0, S, T, 4f)
                I shouldBe O

                val J = Vec4(R, S, T, 4f)
                J shouldBe O

                val K = Vec4(R, 2f, 3.0, U)
                K shouldBe O

                val L = Vec4(1f, S, 3.0, U)
                L shouldBe O

                val M = Vec4(R, S, 3.0, U)
                M shouldBe O

                val N = Vec4(1f, 2.0, T, U)
                N shouldBe O

                val P = Vec4(R, 2.0, T, U)
                P shouldBe O

                val Q = Vec4(1f, S, T, U)
                Q shouldBe O

                val V = Vec4(R, S, T, U)
                V shouldBe O
            }

            run {
                val v1_0 = Vec1(1f)
                val v1_1 = Vec1(2f)
                val v1_2 = Vec1(3f)
                val v1_3 = Vec1(4f)

                val v2_0 = Vec2(1f, 2f)
                val v2_1 = Vec2(2f, 3f)
                val v2_2 = Vec2(3f, 4f)

                val v3_0 = Vec3(1f, 2f, 3f)
                val v3_1 = Vec3(2f, 3f, 4f)

                val O = Vec4(1f, 2.0, 3f, 4.0)

                val A = Vec4(v1_0, v1_1, v2_2)
                A shouldBe O

                val B = Vec4(1f, 2f, v2_2)
                B shouldBe O

                val C = Vec4(v1_0, 2f, v2_2)
                C shouldBe O

                val D = Vec4(1f, v1_1, v2_2)
                D shouldBe O

                val E = Vec4(v2_0, v1_2, v1_3)
                E shouldBe O

                val F = Vec4(v2_0, 3.0, v1_3)
                F shouldBe O

                val G = Vec4(v2_0, v1_2, 4.0)
                G shouldBe O

                val H = Vec4(v2_0, 3f, 4.0)
                H shouldBe O
            }

            run {
                val v1_0 = Vec1(1f)
                val v1_1 = Vec1(2f)
                val v1_2 = Vec1(3f)
                val v1_3 = Vec1(4f)

                val v2 = Vec2(2f, 3f)

                val v3_0 = Vec3(1f, 2f, 3f)
                val v3_1 = Vec3(2f, 3f, 4f)

                val O = Vec4(1f, 2.0, 3f, 4.0)

                val A = Vec4(v1_0, v2, v1_3)
                A shouldBe O

                val B = Vec4(v1_0, v2, 4.0)
                B shouldBe O

                val C = Vec4(1.0, v2, v1_3)
                C shouldBe O

                val D = Vec4(1f, v2, 4.0)
                D shouldBe O

                val E = Vec4(1.0, v2, 4f)
                E shouldBe O
            }
        }

        "bvec4_ctor"        {

            val A = Vec4bool(true)
            val B = Vec4bool(true)
            val C = Vec4bool(false)
            val D = A and B
            val E = A and C
            val F = A or C

            D shouldBe Vec4bool(true)
            E shouldBe Vec4bool(false)
            F shouldBe Vec4bool(true)

            val G = A == C
            val H = A != C
            G shouldBe false
            H shouldBe true
        }

        "vec4 operators"        {

            run {
                val A = Vec4(1f)
                val B = Vec4(1f)
                val R = A != B
                val S = A == B

                assert(S && !R)
            }

            run {
                val A = Vec4(1f, 2f, 3f, 4f)
                val B = Vec4(4f, 5f, 6f, 7f)

                val C = A + B
                C shouldBe Vec4(5, 7, 9, 11)

                val D = B - A
                D shouldBe Vec4(3, 3, 3, 3)

                val E = A * B
                E shouldBe Vec4(4, 10, 18, 28)

                val F = B / A
                F shouldBe Vec4(4, 2.5, 2, 7f / 4f)

                val G = A + 1f
                G shouldBe Vec4(2, 3, 4, 5)

                val H = B - 1f
                H shouldBe Vec4(3, 4, 5, 6)

                val I = A * 2f
                I shouldBe Vec4(2, 4, 6, 8)

                val J = B / 2f
                J shouldBe Vec4(2, 2.5, 3, 3.5)

                val K = 1f + A
                K shouldBe Vec4(2, 3, 4, 5)

                val L = 1f - B
                L shouldBe Vec4(-3, -4, -5, -6)

                val M = 2f * A
                M shouldBe Vec4(2, 4, 6, 8)

                val N = 2f / B
                N shouldBe Vec4(0.5, 2.0 / 5.0, 2.0 / 6.0, 2.0 / 7.0)
            }

            run {
                val A = Vec4(1f, 2f, 3f, 4f)
                val B = Vec4(4f, 5f, 6f, 7f)

                A += B
                A shouldBe Vec4(5, 7, 9, 11)

                A += 1f
                A shouldBe Vec4(6, 8, 10, 12)
            }

            run {
                val A = Vec4(1f, 2f, 3f, 4f)
                val B = Vec4(4f, 5f, 6f, 7f)

                B -= A
                B shouldBe Vec4(3, 3, 3, 3)

                B -= 1f
                B shouldBe Vec4(2, 2, 2, 2)
            }
            run {
                val A = Vec4(1f, 2f, 3f, 4f)
                val B = Vec4(4f, 5f, 6f, 7f)

                A *= B
                A shouldBe Vec4(4, 10, 18, 28)

                A *= 2f
                A shouldBe Vec4(8, 20, 36, 56)
            }
            run {
                val A = Vec4(1f, 2f, 3f, 4f)
                val B = Vec4(4f, 5f, 6f, 7f)

                B /= A
                B shouldBe Vec4(4, 2.5, 2, 7f / 4f)

                B /= 2f
                B shouldBe Vec4(2, 1.25, 1, 7f / 4f / 2f)
            }
            run {
                val B = Vec4(2f)

                B /= B.y
                B shouldBe Vec4(1f)
            }

            run {
                val A = Vec4(1f, 2f, 3f, 4f)
                val B = -A
                B shouldBe Vec4(-1f, -2f, -3f, -4f)
            }

            run {
                var A = Vec4(1f, 2f, 3f, 4f)
                val B = --A
                B shouldBe Vec4(0f, 1f, 2f, 3f)
            }

            run {
                var A = Vec4(1f, 2f, 3f, 4f)
                val B = A--
                B shouldBe Vec4(1f, 2f, 3f, 4f)
                A shouldBe Vec4(0f, 1f, 2f, 3f)
            }

            run {
                var A = Vec4(1f, 2f, 3f, 4f)
                val B = ++A
                B shouldBe Vec4(2f, 3f, 4f, 5f)
            }

            run {
                var A = Vec4(1f, 2f, 3f, 4f)
                val B = A++
                B shouldBe Vec4(1f, 2f, 3f, 4f)
                A shouldBe Vec4(2f, 3f, 4f, 5f)
            }
        }

        "vec4 equal"        {

            run {
                val A = Vec4(1, 2, 3, 4)
                val B = Vec4(1, 2, 3, 4)
                (A == B) shouldBe true
                (A != B) shouldBe false
            }

            run {
                val A = Vec4i(1, 2, 3, 4)
                val B = Vec4i(1, 2, 3, 4)
                (A == B) shouldBe true
                (A != B) shouldBe false
            }
        }

        "vec4 size"        {

            Vec4.size shouldBe 4 * Float.BYTES
            Vec4d.size shouldBe 4 * Double.BYTES
            Vec4.length shouldBe 4
            Vec4d.length shouldBe 4
        }

        "swizzle"        {

            //            #    if GLM_SWIZZLE == GLM_ENABLE && GLM_HAS_ANONYMOUS_STRUCT
//            {
//                glm::vec4 A = glm ::vec4(1.0f, 2.0f, 3.0f, 4.0f);
//                glm::vec4 B = A . xyzw;
//                glm::vec4 C (A.xyzw);
//                glm::vec4 D (A.xyzw());
//                glm::vec4 E (A.x, A.yzw);
//                glm::vec4 F (A.x, A.yzw());
//                glm::vec4 G (A.xyz, A.w);
//                glm::vec4 H (A.xyz(), A.w);
//                glm::vec4 I (A.xy, A.zw);
//                glm::vec4 J (A.xy(), A.zw());
//                glm::vec4 K (A.x, A.y, A.zw);
//                glm::vec4 L (A.x, A.yz, A.w);
//                glm::vec4 M (A.xy, A.z, A.w);
//
//                Error += glm::all(glm::equal(A, B)) ? 0 : 1;
//                Error += glm::all(glm::equal(A, C)) ? 0 : 1;
//                Error += glm::all(glm::equal(A, D)) ? 0 : 1;
//                Error += glm::all(glm::equal(A, E)) ? 0 : 1;
//                Error += glm::all(glm::equal(A, F)) ? 0 : 1;
//                Error += glm::all(glm::equal(A, G)) ? 0 : 1;
//                Error += glm::all(glm::equal(A, H)) ? 0 : 1;
//                Error += glm::all(glm::equal(A, I)) ? 0 : 1;
//                Error += glm::all(glm::equal(A, J)) ? 0 : 1;
//                Error += glm::all(glm::equal(A, K)) ? 0 : 1;
//                Error += glm::all(glm::equal(A, L)) ? 0 : 1;
//                Error += glm::all(glm::equal(A, M)) ? 0 : 1;
//            }
//            #    elif GLM_SWIZZLE == GLM_ENABLE
//                {
            val A = Vec4(1f, 2f, 3f, 4f)
            val B = Vec4(A.xyzw)
            val C = Vec4(A.xyzw)
            val D = Vec4(A.xyzw)
            val E = Vec4(A.x, A.yzw)
            val F = Vec4(A.x, A.yzw)
            val G = Vec4(A.xyz, A.w)
            val H = Vec4(A.xyz, A.w)
            val I = Vec4(A.xy, A.zw)
            val J = Vec4(A.xy, A.zw)
            val K = Vec4(A.x, A.y, A.zw)
            val L = Vec4(A.x, A.yz, A.w)
            val M = Vec4(A.xy, A.z, A.w)

            A shouldBe B
            A shouldBe C
            A shouldBe D
            A shouldBe E
            A shouldBe F
            A shouldBe G
            A shouldBe H
            A shouldBe I
            A shouldBe J
            A shouldBe K
            A shouldBe L
            A shouldBe M
        }
//            #    endif//GLM_SWIZZLE == GLM_ENABLE && GLM_HAS_ANONYMOUS_STRUCT
//        }

        "vec4 swizzle partial"        {

            val A = Vec4(1, 2, 3, 4)

//            #	if GLM_HAS_UNRESTRICTED_UNIONS && defined(GLM_SWIZZLE_RELAX)
            run {
                val B = Vec4(A.xy, A.zw)
                A shouldBe B
            }
            run {
                val B = Vec4(A.xy, 3f, 4f)
                A shouldBe B
            }
            run {
                val B = Vec4(1f, A.yz, 4f)
                A shouldBe B
            }
            run {
                val B = Vec4(1f, 2f, A.zw)
                A shouldBe B
            }

            run {
                val B = Vec4(A.xyz, 4f)
                A shouldBe B
            }
            run {
                val B = Vec4(1f, A.yzw)
                A shouldBe B
            }
        }

        "operator increment"        {

            val v0 = Vec4i(1)
            var v1 = Vec4i(v0)
            var v2 = Vec4i(v0)
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

//        struct AoS
//                {
//                    glm::vec4 A;
//                    glm::vec3 B;
//                    glm::vec3 C;
//                    glm::vec2 D;
//                };
//
//        static int test_vec4_perf_AoS(std::size_t Size)
//        {
//            int Error(0);
//
//            std::vector<AoS> In;
//            std::vector<AoS> Out;
//            In.resize(Size);
//            Out.resize(Size);
//
//            std::clock_t StartTime = std::clock();
//
//            for(std::size_t i = 0; i < In.size(); ++i)
//            Out[i] = In[i];
//
//            std::clock_t EndTime = std::clock();
//
//            std::printf("AoS: %d\n", static_cast<int>(EndTime - StartTime));
//
//            return Error;
//        }
//
//        static int test_vec4_perf_SoA(std::size_t Size)
//        {
//            int Error(0);
//
//            std::vector<glm::vec4> InA;
//            std::vector<glm::vec3> InB;
//            std::vector<glm::vec3> InC;
//            std::vector<glm::vec2> InD;
//            std::vector<glm::vec4> OutA;
//            std::vector<glm::vec3> OutB;
//            std::vector<glm::vec3> OutC;
//            std::vector<glm::vec2> OutD;
//
//            InA.resize(Size);
//            InB.resize(Size);
//            InC.resize(Size);
//            InD.resize(Size);
//            OutA.resize(Size);
//            OutB.resize(Size);
//            OutC.resize(Size);
//            OutD.resize(Size);
//
//            std::clock_t StartTime = std::clock();
//
//            for(std::size_t i = 0; i < InA.size(); ++i)
//            {
//                OutA[i] = InA[i];
//                OutB[i] = InB[i];
//                OutC[i] = InC[i];
//                OutD[i] = InD[i];
//            }
//
//            std::clock_t EndTime = std::clock();
//
//            std::printf("SoA: %d\n", static_cast<int>(EndTime - StartTime));
//
//            return Error;
//        }
//
//        namespace heap
//                {
//                    struct A
//                            {
//                                float f;
//                            };
//
//                    struct B : public A
//                    {
//                        float g;
//                        glm::vec4 v;
//                    };
//
//                    static int test()
//                    {
//                        int Error = 0;
//
//                        A* p = new B;
//                        p->f = 0.0f;
//                        delete p;
//
//                        Error += sizeof(B) == sizeof(glm::vec4) + sizeof(float) * 2 ? 0 : 1;
//
//                        return Error;
//                    }
//                }//namespace heap
//
//        static int test_vec4_simd()
//        {
//            int Error = 0;
//
//            glm::vec4 const a(std::clock(), std::clock(), std::clock(), std::clock());
//            glm::vec4 const b(std::clock(), std::clock(), std::clock(), std::clock());
//
//            glm::vec4 const c(b * a);
//            glm::vec4 const d(a + c);
//
//            Error += glm::all(glm::greaterThanEqual(d, glm::vec4(0))) ? 0 : 1;
//
//            return Error;
//        }
//
//        static int test_inheritance()
//        {
//            struct my_vec4 : public glm::vec4
//            {
//                my_vec4()
//                : glm::vec4(76.f, 75.f, 74.f, 73.f)
//                , member(82)
//            {}
//
//                int member;
//            };
//
//            int Error = 0;
//
//            my_vec4 v;
//
//            Error += v.member == 82 ? 0 : 1;
//            Error += glm::epsilonEqual(v.x, 76.f, glm::epsilon<float>()) ? 0 : 1;
//            Error += glm::epsilonEqual(v.y, 75.f, glm::epsilon<float>()) ? 0 : 1;
//            Error += glm::epsilonEqual(v.z, 74.f, glm::epsilon<float>()) ? 0 : 1;
//            Error += glm::epsilonEqual(v.w, 73.f, glm::epsilon<float>()) ? 0 : 1;
//
//            return Error;
//        }

        "toColor" {

            Vec4 { it.f }.toColor(normalized = false)
            Vec4(0f, 0.5f, 1f, 1f).toColor()
            Vec4(1f).toColor()

            val c = floatArrayOf(0.2f, 0.2f, 0.2f, 1f)
            Vec4(c, 0).toColor()
        }
    }
}