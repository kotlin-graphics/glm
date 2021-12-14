package glm.core

import glm.assert
import glm.vec1.Vec1
import glm.vec1.Vec1d
import glm.vec2.*
import kotlin.test.Test
import kotlin.test.assertFalse

class coreVec2 {

    @Test
    fun operators() {

        run {
            val a = Vec2i(1)
            val b = Vec2i(1)
            assertFalse(a != b)
            assert(a == b)
        }

        run {
            val a = Vec2(1f)
            val c = a + 1f
            a += 1f
            assert(a == Vec2(2f))
            assert(a == c)
        }

        run {
            val a = Vec2(1f)
            val b = Vec2(2f, -1f)
            val c = a + b
            a += b
            assert(a == Vec2(3f, 0f))
            assert(a == c)
        }

        run {
            val a = Vec2(1f)
            val c = a - 1f
            a -= 1f
            assert(a == Vec2(0f))
            assert(a == c)
        }

        run {
            val a = Vec2(1f)
            val b = Vec2(2f, -1f)
            val c = a - b
            a -= b
            assert(a == Vec2(-1f, 2f))
            assert(a == c)
        }

        run {
            val a = Vec2(1f)
            val c = a * 2f
            a *= 2f
            assert(a == Vec2(2f))
            assert(a == c)
        }

        run {
            val a = Vec2(2f)
            val b = Vec2(2f)
            val c = a / b
            a /= b
            assert(a == Vec2(1f))
            assert(a == c)
        }

        run {
            val a = Vec2(1f, 2f)
            val b = Vec2(4f, 5f)

            val c = a + b
            assert(c == Vec2(5, 7))

            val d = b - a
            assert(d == Vec2(3))

            val e = a * b
            assert(e == Vec2(4, 10))

            val f = b / a
            assert(f == Vec2(4, 2.5))

            val g = a + 1f
            assert(g == Vec2(2, 3))

            val h = b - 1f
            assert(h == Vec2(3, 4))

            val i = a * 2f
            assert(i == Vec2(2, 4))

            val j = b / 2f
            assert(j == Vec2(2, 2.5))

            val k = 1f + a
            assert(k == Vec2(2, 3))

            val l = 1f - b
            assert(l == Vec2(-3, -4))

            val m = 2f * a
            assert(m == Vec2(2, 4))

            val n = 2f / b
            assert(n == Vec2(0.5, 2.0 / 5.0))
        }

        run {
            val a = Vec2(1f, 2f)
            val b = Vec2(4f, 5f)

            a += b
            assert(a == Vec2(5, 7))

            a += 1f
            assert(a == Vec2(6, 8))
        }
        run {
            val a = Vec2i(1f, 2f)
            val b = Vec2i(4f, 5f)

            b -= a
            assert(b == Vec2i(3))

            b -= 1f
            assert(b == Vec2i(2))
        }
        run {
            val a = Vec2i(1f, 2f)
            val b = Vec2i(4f, 5f)

            a *= b
            assert(a == Vec2i(4, 10))

            a *= 2
            assert(a == Vec2i(8, 20))
        }
        run {
            val a = Vec2i(1f, 2f)
            val b = Vec2i(4f, 16f)

            b /= a
            assert(b == Vec2i(4, 8))

            b /= 2f
            assert(b == Vec2i(2, 4))
        }
        run {
            val b = Vec2i(2)

            b /= b.y
            assert(b == Vec2i(1))
        }

        run {
            val a = Vec2i(1f, 2f)
            val b = -a
            assert(b == Vec2i(-1f, -2f))
        }

        run {
            var a = Vec2i(1f, 2f)
            val b = --a
            assert(b == Vec2i(0f, 1.0f))
        }

        run {
            var a = Vec2i(1f, 2f)
            val b = a--
//            assert(b == Vec2i(1f, 2f))
            assert(a == Vec2i(0f, 1f))
        }

        run {
            var a = Vec2i(1f, 2f)
            val b = ++a
            assert(b == Vec2i(2f, 3f))
        }

        run {
            var a = Vec2i(1f, 2f)
            val b = a++
//            assert(b == Vec2i(1f, 2f))
            assert(a == Vec2i(2f, 3f))
        }
    }

    @Test
    fun `ctor`() {

        run {
            val a = Vec2i(1)
            val b = Vec2i(a)
            assert(a == b)
        }

//        #if GLM_HAS_INITIALIZER_LISTS
//        {
//            glm::vec2 a{ 0, 1 }
//            std::vector<glm::vec2> v = {
//                {0, 1},
//                {4, 5},
//                {8, 9}}
//        }
//
//        {
//            glm::dvec2 a{ 0, 1 }
//            std::vector<glm::dvec2> v = {
//                {0, 1},
//                {4, 5},
//                {8, 9}}
//        }
//        #endif

        run {
            val a = Vec2(2f)
            val b = Vec2(2f, 3f)
            val c = Vec2(2f, 3)
            //glm::vec2 D = glm::dvec2(2.0); // Build error TODO: What does the specification says?
            val e = Vec2(Vec2d(2.0))
            val f = Vec2(Vec2i(2))
            assert(a.x == 2f && a.y == 2f)
            assert(b.x == 2f && b.y == 3f)
            assert(c.x == 2f && c.y == 3f)
            assert(e.x == 2f && e.y == 2f)
            assert(f.x == 2f && f.y == 2f)
        }

        run {
            val r = Vec1(1f)
            val s = Vec1(2f)
            val o = Vec2(1f, 2f)

            val a = Vec2(r)
            val b = Vec2(1f)
            assert(a == b)

            val c = Vec2(r, s)
            assert(c == o)

            val d = Vec2(r, 2f)
            assert(d == o)

            val e = Vec2(1f, s)
            assert(e == o)
        }

        run {
            val r = Vec1(1f)
            val s = Vec1d(2.0)
            val o = Vec2(1.0, 2.0)

            val a = Vec2(r)
            val b = Vec2(1.0)
            assert(a == b)

            val c = Vec2(r, s)
            assert(c == o)

            val d = Vec2(r, 2.0)
            assert(d == o)

            val e = Vec2(1.0, s)
            assert(e == o)
        }
    }

    @Test
    fun size() {

//        Error += sizeof(glm::vec2) == sizeof(glm::mediump_vec2) ? 0 : 1;
//        Error += 8 == sizeof(glm::mediump_vec2) ? 0 : 1;
//        Error += sizeof(glm::dvec2) == sizeof(glm::highp_dvec2) ? 0 : 1;
//        Error += 16 == sizeof(glm::highp_dvec2) ? 0 : 1;
        assert(Vec2.length == 2)
        assert(Vec2d.length == 2)
    }

    @Test
    fun `operator increment`() {

        val v0 = Vec2i(1)
        var v1 = Vec2i(v0)
        var v2 = Vec2i(v0)
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
}