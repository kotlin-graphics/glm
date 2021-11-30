package glm

import glm.vec1.Vec1
import glm.vec1.Vec1d
import glm.vec2.Vec2
import glm.vec2.Vec2i
import glm.vec3.Vec3
import glm.vec3.Vec3i
import glm.vec4.*
import kotlin.test.Test
import kotlin.test.assertFalse

class coreVec4 {

    @Test
    fun `vec4 ctor`() {

        run {
            val a = Vec4i(1, 2, 3, 4)
            val b = Vec4i(a)
            assert(a == b)
        }

//       #if GLM_HAS_INITIALIZER_LISTS
//        {
//            glm::vec4 a{ 0, 1, 2, 3 };
//            std::vector<glm::vec4> v = {
//                {0, 1, 2, 3},
//                {4, 5, 6, 7},
//                {8, 9, 0, 1}};
//        }
//
//        {
//            glm::dvec4 a{ 0, 1, 2, 3 };
//            std::vector<glm::dvec4> v = {
//                {0, 1, 2, 3},
//                {4, 5, 6, 7},
//                {8, 9, 0, 1}};
//        }
//        #endif

        run {
            val a=Vec4i(1)
            val b=Vec4i(1, 1, 1, 1)

            assert(a == b)
        }

        run {
            for (test in listOf(Vec4i(Vec2i(1, 2), 3, 4),
                                Vec4i(1, Vec2i(2, 3), 4),
                                Vec4i(1, 2, Vec2i(3, 4)),
                                Vec4i(Vec3i(1, 2, 3), 4),
                                Vec4i(1, Vec3i(2, 3, 4)),
                                Vec4i(Vec2i(1, 2), Vec2i(3, 4)),
                                Vec4i(1, 2, 3, 4),
                                Vec4i(Vec4i(1, 2, 3, 4))))
                assert(test == Vec4i(1, 2, 3, 4))
        }

        run {
            val r=Vec1(1f)
            val s=Vec1(2f)
            val t=Vec1(3f)
            val u=Vec1(4f)
            val o=Vec4(1f, 2f, 3f, 4f)

            val a=Vec4(r)
            val b=Vec4(1f)
            assert(a == b)

            val c=Vec4(r, s, t, u)
            assert(c == o)

            val d = Vec4(r, 2f, 3f, 4f)
            assert(d == o)

            val e=Vec4(1f, s, 3f, 4f)
            assert(e == o)

            val f = Vec4(r, s, 3f, 4f)
            assert(f == o)

            val g=Vec4(1f, 2f, t, 4f)
            assert(g == o)

            val h=Vec4(r, 2f, t, 4f)
            assert(h == o)

            val i=Vec4(1f, s, t, 4f)
            assert(i == o)

            val j=Vec4(r, s, t, 4f)
            assert(j == o)

            val k=Vec4(r, 2f, 3f, u)
            assert(k == o)

            val l=Vec4(1f, s, 3f, u)
            assert(l == o)

            val m=Vec4(r, s, 3f, u)
            assert(m == o)

            val n=Vec4(1f, 2f, t, u)
            assert(n == o)

            val p=Vec4(r, 2f, t, u)
            assert(p == o)

            val q=Vec4(1f, s, t, u)
            assert(q == o)

            val v = Vec4(r, s, t, u)
            assert(v == o)
        }

        run {
            val r=Vec1(1f)
            val s=Vec1d(2.0)
            val t=Vec1(3.0)
            val u=Vec1d(4.0)
            val o=Vec4(1f, 2.0, 3f, 4.0)

            val a=Vec4(r)
            val b=Vec4(1.0)
            assert(a == b)

            val c=Vec4(r, s, t, u)
            assert(c == o)

            val d=Vec4(r, 2f, 3.0, 4f)
            assert(d == o)

            val e=Vec4(1.0, s, 3f, 4.0)
            assert(e == o)

            val f=Vec4(r, s, 3.0, 4f)
            assert(f == o)

            val g=Vec4(1f, 2.0, t, 4.0)
            assert(g == o)

            val h=Vec4(r, 2.0, t, 4.0)
            assert(h == o)

            val i=Vec4(1.0, s, t, 4f)
            assert(i == o)

            val j=Vec4(r, s, t, 4f)
            assert(j == o)

            val k = Vec4(r, 2f, 3.0, u)
            assert(k == o)

            val l=Vec4(1f, s, 3.0, u)
            assert(l == o)

            val m=Vec4(r, s, 3.0, u)
            assert(m == o)

            val n=Vec4(1f, 2.0, t, u)
            assert(n == o)

            val p=Vec4(r, 2.0, t, u)
            assert(p == o)

            val q=Vec4(1f, s, t, u)
            assert(q == o)

            val v=Vec4(r, s, t, u)
            assert(v == o)
        }

        run {
            val v1_0 = Vec1(1f)
            val v1_1 = Vec1(2f)
            val v1_2 = Vec1(3f)
            val v1_3 = Vec1(4f)

            val v2_0= Vec2(1f, 2f)
            val v2_1= Vec2(2f, 3f)
            val v2_2= Vec2(3f, 4f)

            val v3_0 = Vec3(1f, 2f, 3f)
            val v3_1 = Vec3(2f, 3f, 4f)

            val o=Vec4(1f, 2, 3f, 4.0)

            val a=Vec4(v1_0, v1_1, v2_2)
            assert(a == o)

            val b=Vec4(1f, 2f, v2_2)
            assert(b == o)

            val c=Vec4(v1_0, 2f, v2_2)
            assert(c == o)

            val d=Vec4(1f, v1_1, v2_2)
            assert(d == o)

            val e=Vec4(v2_0, v1_2, v1_3)
            assert(e == o)

            val f=Vec4(v2_0, 3.0, v1_3)
            assert(f == o)

            val g=Vec4(v2_0, v1_2, 4.0)
            assert(g == o)

            val h=Vec4(v2_0, 3f, 4.0)
            assert(h == o)
        }

        run {
            val v1_0= Vec1(1f)
            val v1_1= Vec1(2f)
            val v1_2= Vec1(3f)
            val v1_3= Vec1(4f)

            val v2=Vec2(2f, 3f)

            val o=Vec4(1f, 2.0, 3f, 4.0)

            val a=Vec4(v1_0, v2, v1_3)
            assert(a == o)

            val b=Vec4(v1_0, v2, 4.0)
            assert(b == o)

            val c=Vec4(1.0, v2, v1_3)
            assert(c == o)

            val d=Vec4(1f, v2, 4.0)
            assert(d == o)

            val e=Vec4(1.0, v2, 4f)
            assert(e == o)
        }
    }

    @Test
    fun `vec4bool ctor`() {

        val a=Vec4bool(true)
        val b=Vec4bool(true)
        val c=Vec4bool(false)
        val d = a and b
        val e = a and c
        val f = a or c

        assert(d == Vec4bool(true))
        assert(e == Vec4bool(false))
        assert(f == Vec4bool(true))

        val g = a == c
        val h = a != c
        assert(!g)
        assert(h)
    }
    
    @Test
    fun operators() {
        
        run {
            val a=Vec4i(1)
            val b=Vec4i(1)
            val r = a != b
            val s = a == b

            assert(s && !r)
        }

        run {
            val a=Vec4(1f, 2f, 3f, 4f)
            val b=Vec4(4f, 5f, 6f, 7f)

            val c = a + b
            assert(c == Vec4(5, 7, 9, 11))

            val d = b - a
            assert(d == Vec4(3, 3, 3, 3))

            val e = a * b
            assert(e == Vec4(4, 10, 18, 28))

            val f = b / a
            assert(f == Vec4(4, 2.5, 2, 7f / 4f))

            val g = a + 1f
            assert(g == Vec4(2, 3, 4, 5))

            val h = b - 1f
            assert(h == Vec4(3, 4, 5, 6))

            val i = a * 2f
            assert(i == Vec4(2, 4, 6, 8))

            val j = b / 2f
            assert(j == Vec4(2, 2.5, 3, 3.5))

            val k = 1f + a
            assert(k == Vec4(2, 3, 4, 5))

            val l = 1f - b
            assert(l == Vec4(-3, -4, -5, -6))

            val m = 2f * a
            assert(m == Vec4(2, 4, 6, 8))

            val n = 2f / b
            assert(n == Vec4(0.5, 2.0 / 5.0, 2.0 / 6.0, 2.0 / 7.0))
        }

        run {
            val a=Vec4i(1f, 2f, 3f, 4f)
            val b=Vec4i(4f, 5f, 6f, 7f)

            a += b
            assert(a == Vec4i(5, 7, 9, 11))

            a += 1
            assert(a == Vec4i(6, 8, 10, 12))
        }
        run {
            val a=Vec4i(1f, 2f, 3f, 4f)
            val b=Vec4i(4f, 5f, 6f, 7f)

            b -= a
            assert(b == Vec4i(3, 3, 3, 3))

            b -= 1
            assert(b == Vec4i(2, 2, 2, 2))
        }
        run {
            val a=Vec4i(1f, 2f, 3f, 4f)
            val b=Vec4i(4f, 5f, 6f, 7f)

            a *= b
            assert(a == Vec4i(4, 10, 18, 28))

            a *= 2
            assert(a == Vec4i(8, 20, 36, 56))
        }
        run {
            val a=Vec4i(1f, 2f, 2f, 4f)
            val b=Vec4i(4f, 4f, 8f, 8f)

            b /= a
            assert(b == Vec4i(4, 2, 4, 2))

            b /= 2
            assert(b == Vec4i(2, 1, 2, 1))
        }
        run {
            val b=Vec4i(2)

            b /= b.y
            assert(b == Vec4i(1))
        }

        run {
            val a=Vec4i(1f, 2f, 3f, 4f)
            val b = -a
            assert(b == Vec4i(-1f, -2f, -3f, -4f))
        }

        run {
            var a=Vec4i(1f, 2f, 3f, 4f)
            val b = --a
            assert(b == Vec4i(0f, 1f, 2f, 3f))
        }

        run {
            var a=Vec4i(1f, 2f, 3f, 4f)
            val b = a--
//            assert(b == Vec4i(1f, 2f, 3f, 4f))
            assert(a == Vec4i(0f, 1f, 2f, 3f))
        }

        run {
            var a=Vec4i(1f, 2f, 3f, 4f)
            val b = ++a
            assert(b == Vec4i(2f, 3f, 4f, 5f))
        }

        run {
            var a=Vec4i(1f, 2f, 3f, 4f)
            val b = a++
//            assert(b == Vec4i(1f, 2f, 3f, 4f))
            assert(a == Vec4i(2f, 3f, 4f, 5f))
        }
    }

    @Test
    fun equal() {

        run {
            val a=Vec4ui(1, 2, 3, 4)
            val b=Vec4ui(1, 2, 3, 4)
            assert(a == b)
            assertFalse(a != b)
        }

        run {
            val a=Vec4i(1, 2, 3, 4)
            val b=Vec4i(1, 2, 3, 4)
            assert(a == b)
            assertFalse(a != b)
        }
    }

    @Test
    fun size() {
        assert(Vec4.length == 4)
        assert(Vec4d.length == 4)
    }

    @Test
    fun `operator increment`() {

        val v0 = Vec4i(1)
        var v1 = Vec4i(v0)
        var v2 = Vec4i(v0)
        val v3 = ++v1
        val v4 = v2++

//        assert(v0 == v4)
        assert(v1 == v2)
        assert(v1 == v3)

        val i0 = 1
        var i1 = i0
        var i2 = i0
        val i3 = ++i1
        val i4 = i2++

        assert(i0 == i4)
        assert(i1 == i2)
        assert(i1 == i3)
    }

    @Test
    fun inheritance() {
        val v = object : Vec4(76f, 75f, 74f, 73f) {
            val member = 82
        }

        assert(v.member == 82)
        assert(v.x == 76f && v.y == 75f && v.z == 74f && v.w == 73f)
    }
}