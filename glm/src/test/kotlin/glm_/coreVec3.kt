package glm_

import glm_.vec1.Vec1
import glm_.vec1.Vec1d
import glm_.vec2.Vec2
import glm_.vec2.Vec2t
import glm_.vec3.*
import glm_.vec3.operators.div
import glm_.vec3.operators.minus
import glm_.vec3.operators.plus
import glm_.vec3.operators.times
import glm_.vec4.Vec4
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class coreVec3 : StringSpec() {

    init {

        "vec3 constructor" {

            run {
                val a = Vec3(1f, 2f, 3f)
                val b = a.xyz
                val c = Vec3(a.xyz)
                val d = a.xyz as Vec3
                val e = Vec3(a.x, a.yz)
                val f = Vec3(a.x, a.yz)
                val g = Vec3(a.xy, a.z)
                val h = Vec3(a.xy, a.z)

                a shouldBe b
                a shouldBe c
                a shouldBe d
                a shouldBe e
                a shouldBe f
                a shouldBe g
                a shouldBe h
            }

            run {
                val a = Vec3(1)
                val b = Vec3(1, 1, 1)

                a shouldBe b
            }

            run {
                listOf(
                        Vec3(Vec2(1, 2), 3),
                        Vec3(1, Vec2(2, 3)),
                        Vec3(1, 2, 3),
                        Vec3(Vec4(1, 2, 3, 4))).forEach {

                    it shouldBe Vec3(1, 2, 3)
                }
            }

            run {
                val R = Vec1(1f)
                val S = Vec1(2f)
                val T = Vec1(3f)
                val O = Vec3(1f, 2f, 3f)

                val A = Vec3(R)
                val B = Vec3(1.0f)
                A shouldBe B

                val C = Vec3(R, S, T)
                C shouldBe O

                val D = Vec3(R, 2.0f, 3.0f)
                D shouldBe O

                val E = Vec3(1f, S, 3f)
                E shouldBe O

                val F = Vec3(1f, S, T)
                F shouldBe O

                val G = Vec3(R, 2f, T)
                G shouldBe O

                val H = Vec3(R, S, 3f)
                H shouldBe O
            }

            run {
                val R = Vec1(1.0)
                val S = Vec1d(2.0)
                val T = Vec1(3.0)
                val O = Vec3(1f, 2f, 3f)

                val A = Vec3(R)
                val B = Vec3(1.0)
                A shouldBe B

                val C = Vec3(R, S, T)
                C shouldBe O

                val D = Vec3(R, 2.0, 3.0)
                D shouldBe O

                val E = Vec3(1.0f, S, 3.0)
                E shouldBe O

                val F = Vec3(1.0, S, T)
                F shouldBe O

                val G = Vec3(R, 2.0, T)
                G shouldBe O

                val H = Vec3(R, S, 3.0)
                H shouldBe O
            }
        }

        "vec3bool" {

            val a = Vec3bool(true)
            val b = Vec3bool(true)
            val c = Vec3bool(false)
            val d = a and b
            val e = a and c
            val f = a or c

            d shouldBe Vec3bool(true)
            e shouldBe Vec3bool(false)
            f shouldBe Vec3bool(true)

            val g = a == c
            val h = a != c
            g shouldBe false
            h shouldBe true
        }

        "vec3 operators" {

            run {
                val a = Vec3(1f)
                val b = Vec3(1f)
                val r = a != b
                val s = a == b

                assert(s && !r)
            }

            run {
                val a = Vec3(1f, 2f, 3f)
                val b = Vec3(4f, 5f, 6f)

                val c = a + b
                c shouldBe Vec3(5, 7, 9)

                val d = b - a
                d shouldBe Vec3(3, 3, 3)

                val e = a * b
                e shouldBe Vec3(4, 10, 18)

                val f = b / a
                f shouldBe Vec3(4, 2.5, 2)

                val g = a + 1f
                g shouldBe Vec3(2, 3, 4)

                val h = b - 1f
                h shouldBe Vec3(3, 4, 5)

                val i = a * 2f
                i shouldBe Vec3(2, 4, 6)

                val j = b / 2f
                j shouldBe Vec3(2, 2.5, 3)

                val k = 1f + a
                k shouldBe Vec3(2, 3, 4)

                val l = 1f - b
                l shouldBe Vec3(-3, -4, -5)

                val m = 2f * a
                m shouldBe Vec3(2, 4, 6)

                val n = 2f / b
                n shouldBe Vec3(0.5, 2.0 / 5.0, 2.0 / 6.0)
            }

            run {
                val a = Vec3(1f, 2f, 3f)
                val b = Vec3(4f, 5f, 6f)

                a += b
                a shouldBe Vec3(5, 7, 9)

                a += 1f
                a shouldBe Vec3(6, 8, 10)
            }
            run {
                val a = Vec3(1f, 2f, 3f)
                val b = Vec3(4f, 5f, 6f)

                b -= a
                b shouldBe Vec3(3, 3, 3)

                b -= 1f
                b shouldBe Vec3(2, 2, 2)
            }
            run {
                val a = Vec3(1f, 2f, 3f)
                val b = Vec3(4f, 5f, 6f)

                a *= b
                a shouldBe Vec3(4, 10, 18)

                a *= 2f
                a shouldBe Vec3(8, 20, 36)
            }
            run {
                val a = Vec3(1f, 2f, 3f)
                val b = Vec3(4f, 5f, 6f)

                b /= a
                b shouldBe Vec3(4, 2.5, 2)

                b /= 2f
                b shouldBe Vec3(2, 1.25, 1)
            }
            run {
                val b = Vec3(2f)

                b /= b.y
                b shouldBe Vec3(1f)
            }

            run {
                val a = Vec3(1f, 2f, 3f)
                val b = -a
                b shouldBe Vec3(-1f, -2f, -3f)
            }

            run {
                var a = Vec3(1f, 2f, 3f)
                val b = --a
                b shouldBe Vec3(0f, 1f, 2f)
            }

            run {
                var a = Vec3(1f, 2f, 3f)
                val b = a--
                b shouldBe Vec3(1f, 2f, 3f)
                a shouldBe Vec3(0f, 1f, 2f)
            }

            run {
                var a = Vec3(1f, 2f, 3f)
                val b = ++a
                b shouldBe Vec3(2f, 3f, 4f)
            }

            run {
                var a = Vec3(1f, 2f, 3f)
                val b = a++
                b shouldBe Vec3(1f, 2f, 3f)
                a shouldBe Vec3(2f, 3f, 4f)
            }
        }

        "size" {

            Vec3.size shouldBe Float.BYTES * 3
            Vec3.length shouldBe 3
            Vec3d.length shouldBe 3
        }

        "swizzle"        {

            //            #	if GLM_SWIZZLE == GLM_ENABLE && GLM_HAS_ANONYMOUS_STRUCT
//            {
//                glm::vec3 A = glm::vec3(1.0f, 2.0f, 3.0f);
//                glm::vec3 B = A.xyz;
//                glm::vec3 C(A.xyz);
//                glm::vec3 D(A.xyz());
//                glm::vec3 E(A.x, A.yz);
//                glm::vec3 F(A.x, A.yz());
//                glm::vec3 G(A.xy, A.z);
//                glm::vec3 H(A.xy(), A.z);
//
//                Error += glm::all(glm::equal(A, B)) ? 0 : 1;
//                Error += glm::all(glm::equal(A, C)) ? 0 : 1;
//                Error += glm::all(glm::equal(A, D)) ? 0 : 1;
//                Error += glm::all(glm::equal(A, E)) ? 0 : 1;
//                Error += glm::all(glm::equal(A, F)) ? 0 : 1;
//                Error += glm::all(glm::equal(A, G)) ? 0 : 1;
//                Error += glm::all(glm::equal(A, H)) ? 0 : 1;
//            }
//            #	elif GLM_SWIZZLE == GLM_ENABLE
//                {
            val A = Vec3(1f, 2f, 3f)
            val B = A.xyz
            val C = Vec3(A.xyz)
            val D = Vec3(A.xyz)
            val E = Vec3(A.x, A.yz)
            val F = Vec3(A.x, A.yz)
            val G = Vec3(A.xy, A.z)
            val H = Vec3(A.xy, A.z)

            A shouldBe B
            A shouldBe C
            A shouldBe D
            A shouldBe E
            A shouldBe F
            A shouldBe G
            A shouldBe H
//        }
//            #	endif//GLM_SWIZZLE == GLM_ENABLE
        }

        "swizzle3 2" {

            var v = Vec3(1, 2, 3)
            var u: Vec2t<out Number>

            // Can not assign a vec3 swizzle to a vec2
            //u = v.xyz;    //Illegal
            //u = v.rgb;    //Illegal
            //u = v.stp;    //Illegal

            u = v.xx; assert(u.x == 1f && u.y == 1f)
            u = v.xy; assert(u.x == 1f && u.y == 2f)
            u = v.xz; assert(u.x == 1f && u.y == 3f)
            u = v.yx; assert(u.x == 2f && u.y == 1f)
            u = v.yy; assert(u.x == 2f && u.y == 2f)
            u = v.yz; assert(u.x == 2f && u.y == 3f)
            u = v.zx; assert(u.x == 3f && u.y == 1f)
            u = v.zy; assert(u.x == 3f && u.y == 2f)
            u = v.zz; assert(u.x == 3f && u.y == 3f)

//          TODO  u = v.rr;       assert(u.r == 1f && u.g == 1f)
//            u = v.rg;       assert(u.r == 1f && u.g == 2f)
//            u = v.rb;       assert(u.r == 1f && u.g == 3f)
//            u = v.gr;       assert(u.r == 2f && u.g == 1f)
//            u = v.gg;       assert(u.r == 2f && u.g == 2f)
//            u = v.gb;       assert(u.r == 2f && u.g == 3f)
//            u = v.br;       assert(u.r == 3f && u.g == 1f)
//            u = v.bg;       assert(u.r == 3f && u.g == 2f)
//            u = v.bb;       assert(u.r == 3f && u.g == 3f)
//
//            u = v.ss;       assert(u.s == 1f && u.t == 1f)
//            u = v.st;       assert(u.s == 1f && u.t == 2f)
//            u = v.sp;       assert(u.s == 1f && u.t == 3f)
//            u = v.ts;       assert(u.s == 2f && u.t == 1f)
//            u = v.tt;       assert(u.s == 2f && u.t == 2f)
//            u = v.tp;       assert(u.s == 2f && u.t == 3f)
//            u = v.ps;       assert(u.s == 3f && u.t == 1f)
//            u = v.pt;       assert(u.s == 3f && u.t == 2f)
//            u = v.pp;       assert(u.s == 3f && u.t == 3f)
//            // Mixed member aliases are not valid
//            //u = v.rx;     //Illegal
//            //u = v.sy;     //Illegal
//
            u = Vec2(1, 2)
            v = Vec3(1, 2, 3)
            //v.xx = u;     //Illegal
            v.xy = u; assert(v.x == 1f && v.y == 2f && v.z == 3f)
            v.xz = u; assert(v.x == 1f && v.y == 2f && v.z == 2f)
            v.yx = u; assert(v.x == 2f && v.y == 1f && v.z == 2f)
            //v.yy = u;     //Illegal
            v.yz = u; assert(v.x == 2f && v.y == 1f && v.z == 2f)
            v.zx = u; assert(v.x == 2f && v.y == 1f && v.z == 1f)
            v.zy = u; assert(v.x == 2f && v.y == 2f && v.z == 1f)
            //v.zz = u;     //Illegal
        }

        "swizzle3 3" {

            val v = Vec3(1, 2, 3)
            var u: Vec3t<out Number>

            u = v; assert(u.x == 1f && u.y == 2f && u.z == 3f)

            u = v.xyz; assert(u.x == 1f && u.y == 2f && u.z == 3f)
            u = v.zyx; assert(u.x == 3f && u.y == 2f && u.z == 1f)
            u.zyx = v; assert(u.x == 3f && u.y == 2f && u.z == 1f)

//          TODO  u = v.rgb;      assert(u.x == 1f && u.y == 2f && u.z == 3f)
//            u = v.bgr;      assert(u.x == 3f && u.y == 2f && u.z == 1f)
//            u.bgr = v;      assert(u.x == 3f && u.y == 2f && u.z == 1f)
//
//            u = v.stp;      assert(u.x == 1f && u.y == 2f && u.z == 3f)
//            u = v.pts;      assert(u.x == 3f && u.y == 2f && u.z == 1f)
//            u.pts = v;      assert(u.x == 3f && u.y == 2f && u.z == 1f)
        }

        "operator increment" {

            val v0 = Vec3i(1)
            var v1 = Vec3i(v0)
            var v2 = Vec3i(v0)
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

        "swizzle partial" {

            run {
                val A = Vec3(1, 2, 3)
                val B = Vec3(A.xy, 3f)
                A shouldBe B
            }

            run {
                val A = Vec3(1, 2, 3)
                val B = Vec3(1f, A.yz)
                A shouldBe B
            }

            run {
                val A = Vec3(1, 2, 3)
                val B = Vec3(A.xyz)
                A shouldBe B
            }
        }

        "swizzle operators" {

            val u = Vec3(1, 2, 3)
            val v = Vec3(10, 20, 30)

            var q: Vec3t<out Number>

            // Swizzle, swizzle binary operators
            q = u.xyz as Vec3 + v.xyz as Vec3; q shouldBe (u + v)
            q = (u.zyx as Vec3 + v.zyx as Vec3).zyx; q shouldBe (u + v)
            q = u.xyz as Vec3 - v.xyz as Vec3; q shouldBe (u - v)
            q = u.xyz as Vec3 * v.xyz as Vec3; q shouldBe (u * v)
            q = u.xxx as Vec3 * v.xxx as Vec3; q shouldBe Vec3(u.x * v.x)
            q = u.xyz as Vec3 / v.xyz as Vec3; q shouldBe (u / v)

            // vec, swizzle binary operators
            q = u + v.xyz as Vec3; q shouldBe (u + v)
            q = u - v.xyz as Vec3; q shouldBe (u - v)
            q = u * v.xyz as Vec3; q shouldBe (u * v)
            q = u * v.xxx as Vec3; q shouldBe v.x * u
            q = u / v.xyz as Vec3; q shouldBe (u / v)

            // swizzle,vec binary operators
            q = u.xyz as Vec3 + v; q shouldBe (u + v)
            q = u.xyz as Vec3 - v; q shouldBe (u - v)
            q = u.xyz as Vec3 * v; q shouldBe (u * v)
            q = u.xxx as Vec3 * v; q shouldBe u.x * v
            q = u.xyz as Vec3 / v; q shouldBe (u / v)

            // Compile errors
            //q = (u.yz * v.xyz);
            //q = (u * v.xy);
        }

        "swizzle functions" {

            // NOTE: template functions cannot pick up the implicit conversion from
            // a swizzle to the unswizzled type, therefore the operator() must be
            // used.  E.g.:
            //
            // glm::dot(u.xy, v.xy);        <--- Compile error
            // glm::dot(u.xy(), v.xy());    <--- Compiles correctly

            var r: Float

            // vec2
            val a = Vec2(1, 2)
            val b = Vec2(10, 20)
            r = glm.dot(a, b); r.i shouldBe 50
            r = glm.dot(Vec2(a.xy), Vec2(b.xy)); r.i shouldBe 50
            r = glm.dot(Vec2(a.xy), Vec2(b.yy)); r.i shouldBe 60

            // vec3
            val u = Vec3(1, 2, 3)
            val v = Vec3(10, 20, 30)
            r = glm.dot(u, v); r.i shouldBe 140
            r = glm.dot(u.xyz as Vec3, v.zyz as Vec3); r.i shouldBe 160
            r = glm.dot(u, v.zyx as Vec3); r.i shouldBe 100
            r = glm.dot(u.xyz as Vec3, v); r.i shouldBe 140
            r = glm.dot(u.xy as Vec2, v.xy as Vec2); r.i shouldBe 50

            // vec4
            val s = Vec4(1, 2, 3, 4)
            val t = Vec4(10, 20, 30, 40)
            r = glm.dot(s, t); r.i shouldBe 300
            r = glm.dot(s.xyzw as Vec4, t.xyzw as Vec4); r.i shouldBe 300
            r = glm.dot(s.xyz as Vec3, t.xyz as Vec3); r.i shouldBe 140
        }

        "toColor" {

            Vec3 { it.f }.toColor(normalized = false)
            Vec3(0f, 0.5f, 1f).toColor(1f)
            Vec3(1f).toColor()
        }
    }
}