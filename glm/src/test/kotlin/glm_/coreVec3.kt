package glm_

import glm_.vec1.Vec1
import glm_.vec1.Vec1d
import glm_.vec2.Vec2
import glm_.vec2.Vec2i
import glm_.vec2.Vec2t
import glm_.vec2.swizzle.xy
import glm_.vec2.swizzle.yy
import glm_.vec3.*
import glm_.vec3.operators.*
import glm_.vec3.swizzle.*
import glm_.vec4.Vec4
import glm_.vec4.swizzle.xyz
import glm_.vec4.swizzle.xyzw
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class coreVec3 : StringSpec() {

    init {

        "vec3 constructor" {

            run {
                val a = Vec3(1f, 2f, 3f)
                val b = Vec3(a.xyz)
                val c = Vec3(a.xyz)
                val d = a.xyz as Vec3
                val e = Vec3(a.x, a.yz)
                val f = Vec3(a.x, a.yz)
                val g = Vec3(a.xy, a.z)
                val h = Vec3(a.xy, a.z)

                a shouldEqual b
                a shouldEqual c
                a shouldEqual d
                a shouldEqual e
                a shouldEqual f
                a shouldEqual g
                a shouldEqual h
            }

            run {
                val a = Vec3(1)
                val b = Vec3(1, 1, 1)

                a shouldEqual b
            }

            run {
                listOf(
                        Vec3(Vec2(1, 2), 3),
                        Vec3(1, Vec2(2, 3)),
                        Vec3(1, 2, 3),
                        Vec3(Vec4(1, 2, 3, 4))).forEach {

                    it shouldEqual Vec3(1, 2, 3)
                }
            }

            run {
                val R = Vec1(1f)
                val S = Vec1(2f)
                val T = Vec1(3f)
                val O = Vec3(1f, 2f, 3f)

                val A = Vec3(R)
                val B = Vec3(1.0f)
                A shouldEqual B

                val C = Vec3(R, S, T)
                C shouldEqual O

                val D = Vec3(R, 2.0f, 3.0f)
                D shouldEqual O

                val E = Vec3(1f, S, 3f)
                E shouldEqual O

                val F = Vec3(1f, S, T)
                F shouldEqual O

                val G = Vec3(R, 2f, T)
                G shouldEqual O

                val H = Vec3(R, S, 3f)
                H shouldEqual O
            }

            run {
                val R = Vec1(1.0)
                val S = Vec1d(2.0)
                val T = Vec1(3.0)
                val O = Vec3(1f, 2f, 3f)

                val A = Vec3(R)
                val B = Vec3(1.0)
                A shouldEqual B

                val C = Vec3(R, S, T)
                C shouldEqual O

                val D = Vec3(R, 2.0, 3.0)
                D shouldEqual O

                val E = Vec3(1.0f, S, 3.0)
                E shouldEqual O

                val F = Vec3(1.0, S, T)
                F shouldEqual O

                val G = Vec3(R, 2.0, T)
                G shouldEqual O

                val H = Vec3(R, S, 3.0)
                H shouldEqual O
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
                val a = Vec3i(1)
                val b = Vec3i(1)
                val r = a != b
                val s = a == b

                assert(s && !r)
            }

            run {
                val a = Vec3(1f, 2f, 3f)
                val b = Vec3(4f, 5f, 6f)

                val c = a + b
                c shouldEqual Vec3(5, 7, 9)

                val d = b - a
                d shouldEqual Vec3(3, 3, 3)

                val e = a * b
                e shouldEqual Vec3(4, 10, 18)

                val f = b / a
                f shouldEqual Vec3(4, 2.5, 2)

                val g = a + 1f
                g shouldEqual Vec3(2, 3, 4)

                val h = b - 1f
                h shouldEqual Vec3(3, 4, 5)

                val i = a * 2f
                i shouldEqual Vec3(2, 4, 6)

                val j = b / 2f
                j shouldEqual Vec3(2, 2.5, 3)

                val k = 1f + a
                k shouldEqual Vec3(2, 3, 4)

                val l = 1f - b
                l shouldEqual Vec3(-3, -4, -5)

                val m = 2f * a
                m shouldEqual Vec3(2, 4, 6)

                val n = 2f / b
                n shouldEqual Vec3(0.5, 2.0 / 5.0, 2.0 / 6.0)
            }

            run {
                val a = Vec3i(1f, 2f, 3f)
                val b = Vec3i(4f, 5f, 6f)

                a += b
                a shouldEqual Vec3i(5, 7, 9)

                a += 1
                a shouldEqual Vec3i(6, 8, 10)
            }
            run {
                val a = Vec3i(1f, 2f, 3f)
                val b = Vec3i(4f, 5f, 6f)

                b -= a
                b shouldEqual Vec3i(3, 3, 3)

                b -= 1
                b shouldEqual Vec3i(2, 2, 2)
            }
            run {
                val a = Vec3i(1f, 2f, 3f)
                val b = Vec3i(4f, 5f, 6f)

                a *= b
                a shouldEqual Vec3i(4, 10, 18)

                a *= 2
                a shouldEqual Vec3i(8, 20, 36)
            }
            run {
                val a = Vec3i(1f, 2f, 3f)
                val b = Vec3i(4f, 4f, 6f)

                b /= a
                b shouldEqual Vec3i(4, 2, 2)

                b /= 2
                b shouldEqual Vec3i(2, 1, 1)
            }
            run {
                val b = Vec3i(2)

                b /= b.y
                b shouldEqual Vec3i(1)
            }

            run {
                val a = Vec3i(1f, 2f, 3f)
                val b = -a
                b shouldEqual Vec3i(-1f, -2f, -3f)
            }

            run {
                var a = Vec3(1f, 2f, 3f)
                val b = --a
                b shouldEqual Vec3(0f, 1f, 2f)
            }

            run {
                var a = Vec3i(1f, 2f, 3f)
                val b = a--
                b shouldEqual Vec3i(1f, 2f, 3f)
                a shouldEqual Vec3i(0f, 1f, 2f)
            }

            run {
                var a = Vec3i(1f, 2f, 3f)
                val b = ++a
                b shouldEqual Vec3i(2f, 3f, 4f)
            }

            run {
                var a = Vec3i(1f, 2f, 3f)
                val b = a++
                b shouldEqual Vec3i(1f, 2f, 3f)
                a shouldEqual Vec3i(2f, 3f, 4f)
            }
        }

        "size" {

            Vec3.size shouldBe Float.BYTES * 3
            Vec3.length shouldBe 3
            Vec3d.length shouldBe 3
        }

        "swizzle3 2"        {

            //            #	if GLM_SWIZZLE == GLM_SWIZZLE_OPERATOR
            run {
                var v = Vec3i(1, 2, 3)
                var u: Vec2i

                // Can not assign a vec3 swizzle to a vec2
                //u = v.xyz;    //Illegal
                //u = v.rgb;    //Illegal
                //u = v.stp;    //Illegal

                u = v.xx; assert(u.x == 1 && u.y == 1)
                u = v.xy; assert(u.x == 1 && u.y == 2)
                u = v.xz; assert(u.x == 1 && u.y == 3)
                u = v.yx; assert(u.x == 2 && u.y == 1)
                u = v.yy; assert(u.x == 2 && u.y == 2)
                u = v.yz; assert(u.x == 2 && u.y == 3)
                u = v.zx; assert(u.x == 3 && u.y == 1)
                u = v.zy; assert(u.x == 3 && u.y == 2)
                u = v.zz; assert(u.x == 3 && u.y == 3)

                u = v.rr; assert(u.r == 1 && u.g == 1)
                u = v.rg; assert(u.r == 1 && u.g == 2)
                u = v.rb; assert(u.r == 1 && u.g == 3)
                u = v.gr; assert(u.r == 2 && u.g == 1)
                u = v.gg; assert(u.r == 2 && u.g == 2)
                u = v.gb; assert(u.r == 2 && u.g == 3)
                u = v.br; assert(u.r == 3 && u.g == 1)
                u = v.bg; assert(u.r == 3 && u.g == 2)
                u = v.bb; assert(u.r == 3 && u.g == 3)
// TODO
//                u = v.ss;       assert(u.s == 1 && u.t == 1)
//                u = v.st;       assert(u.s == 1 && u.t == 2)
//                u = v.sp;       assert(u.s == 1 && u.t == 3)
//                u = v.ts;       assert(u.s == 2 && u.t == 1)
//                u = v.tt;       assert(u.s == 2 && u.t == 2)
//                u = v.tp;       assert(u.s == 2 && u.t == 3)
//                u = v.ps;       assert(u.s == 3 && u.t == 1)
//                u = v.pt;       assert(u.s == 3 && u.t == 2)
//                u = v.pp;       assert(u.s == 3 && u.t == 3)
//                // Mixed member aliases are not valid
//                //u = v.rx;     //Illegal
//                //u = v.sy;     //Illegal

                u = Vec2i(1, 2)
                v = Vec3i(1, 2, 3)
                //v.xx = u;     //Illegal
                v.xy = u; assert(v.x == 1 && v.y == 2 && v.z == 3)
                v.xz = u; assert(v.x == 1 && v.y == 2 && v.z == 2)
                v.yx = u; assert(v.x == 2 && v.y == 1 && v.z == 2)
                //v.yy = u;     //Illegal
                v.yz = u; assert(v.x == 2 && v.y == 1 && v.z == 2)
                v.zx = u; assert(v.x == 2 && v.y == 1 && v.z == 1)
                v.zy = u; assert(v.x == 2 && v.y == 2 && v.z == 1)
                //v.zz = u;     //Illegal
            }
//            #	endif//GLM_SWIZZLE == GLM_SWIZZLE_OPERATOR
        }

        "vec3 swizzle3 3"        {

            //            #	if GLM_SWIZZLE == GLM_SWIZZLE_OPERATOR
//            {
            val v = Vec3i(1, 2, 3)
            var u: Vec3i

            u = v; assert(u.x == 1 && u.y == 2 && u.z == 3)

            u = v.xyz; assert(u.x == 1 && u.y == 2 && u.z == 3)
            u = v.zyx; assert(u.x == 3 && u.y == 2 && u.z == 1)
            u.zyx = v; assert(u.x == 3 && u.y == 2 && u.z == 1)

            // TODO
//            u = v.rgb; assert(u.x == 1 && u.y == 2 && u.z == 3)
//            u = v.bgr; assert(u.x == 3 && u.y == 2 && u.z == 1)
//            u.bgr = v; assert(u.x == 3 && u.y == 2 && u.z == 1)
//
//            u = v.stp; assert(u.x == 1 && u.y == 2 && u.z == 3)
//            u = v.pts; assert(u.x == 3 && u.y == 2 && u.z == 1)
//            u.pts = v; assert(u.x == 3 && u.y == 2 && u.z == 1)
//            }
//            #	endif//GLM_LANG
        }

        "vec3 swizzle operators"        {

            val u = Vec3i(1, 2, 3)
            val v = Vec3i(10, 20, 30)

//            #    if GLM_SWIZZLE == GLM_SWIZZLE_OPERATOR
//            {
            var q: Vec3i

            // Swizzle, swizzle binary operators
            q = u.xyz + v.xyz; assert(q == (u + v))
            q = (u.zyx + v.zyx).zyx; assert(q == (u + v))
            q = (u.xyz - v.xyz); assert(q == (u - v))
            q = (u.xyz * v.xyz); assert(q == (u * v))
            q = (u.xxx * v.xxx); assert(q == Vec3i(u.x * v.x))
            q = (u.xyz / v.xyz); assert(q == (u / v))

            // vec, swizzle binary operators
            q = u + v.xyz; assert(q == (u + v))
            q = (u - v.xyz); assert(q == (u - v))
            q = (u * v.xyz); assert(q == (u * v))
            q = (u * v.xxx); assert(q == v.x * u)
            q = (u / v.xyz); assert(q == (u / v))

            // swizzle,vec binary operators
            q = u.xyz + v; assert(q == (u + v))
            q = (u.xyz - v); assert(q == (u - v))
            q = (u.xyz * v); assert(q == (u * v))
            q = (u.xxx * v); assert(q == u.x * v)
            q = (u.xyz / v); assert(q == (u / v))
//            }
//            #    endif//GLM_LANG

            // Compile errors
            //q = (u.yz * v.xyz);
            //q = (u * v.xy);
        }

        "vec3 swizzle functions"        {

            //            #	if GLM_SWIZZLE == GLM_SWIZZLE_OPERATOR || GLM_SWIZZLE == GLM_SWIZZLE_FUNCTION
//            {
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
            r = a dot b; assert(r.i == 50)
            r = glm.dot(a.xy, b.xy); assert(r.i == 50)
            r = glm.dot(a.xy, b.yy); assert(r.i == 60)

            // vec3
            val u = Vec3(1, 2, 3)
            val v = Vec3(10, 20, 30)
            r = glm.dot(u, v); assert(r.i == 140)
            r = glm.dot(u.xyz, v.zyz); assert(r.i == 160)
            r = glm.dot(u, v.zyx); assert(r.i == 100)
            r = glm.dot(u.xyz, v); assert(r.i == 140)
            r = glm.dot(u.xy, v.xy); assert(r.i == 50)

            // vec4
            val s = Vec4(1, 2, 3, 4)
            val t = Vec4(10, 20, 30, 40)
            r = glm.dot(s, t); assert(r.i == 300)
            r = glm.dot(s.xyzw, t.xyzw); assert(r.i == 300)
            r = glm.dot(s.xyz, t.xyz); assert(r.i == 140)
//            }
//            #	endif//GLM_SWIZZLE == GLM_SWIZZLE_OPERATOR || GLM_SWIZZLE == GLM_SWIZZLE_FUNCTION
        }

        "vec3 swizzle partial"        {

//            #	if GLM_SWIZZLE == GLM_SWIZZLE_OPERATOR
            run {
                val A = Vec3i(1, 2, 3)
                val B = Vec3i(A.xy, 3)
                A shouldEqual B
            }

            run {
                val A = Vec3i(1, 2, 3)
                val B = Vec3i(1, A.yz)
                A shouldEqual B
            }

            run {
                val A = Vec3i(1, 2, 3)
                val B = Vec3i(A.xyz)
                A shouldEqual B
            }
//            #	endif//GLM_SWIZZLE == GLM_SWIZZLE_OPERATOR
        }

        "toColor" {

            Vec3 { it.f }.toColor(normalized = false)
            Vec3(0f, 0.5f, 1f).toColor(1f)
            Vec3(1f).toColor()
        }
    }
}