package glm

import glm.vec1.Vec1
import glm.vec1.Vec1d
import glm.vec2.Vec2i
import glm.vec3.*
import glm.vec4.Vec4i
import kotlin.test.Test

class coreVec3 {

    @Test
    fun ctor() {

        //        #	if GLM_HAS_INITIALIZER_LISTS
        //        {
        //            glm::vec3 a{ 0, 1, 2 };
        //            std::vector<glm::vec3> v = {
        //                {0, 1, 2},
        //                {4, 5, 6},
        //                {8, 9, 0}};
        //        }
        //
        //        {
        //            glm::dvec3 a{ 0, 1, 2 };
        //            std::vector<glm::dvec3> v = {
        //                {0, 1, 2},
        //                {4, 5, 6},
        //                {8, 9, 0}};
        //        }
        //        #	endif

        run {
            val a = Vec3i(1)
            val b = Vec3i(1, 1, 1)

            assert(a == b)
        }

        run {
            for (test in listOf(Vec3i(Vec2i(1, 2), 3),
                                Vec3i(1, Vec2i(2, 3)),
                                Vec3i(1, 2, 3),
                                Vec3i(Vec4i(1, 2, 3, 4))))
                assert(test == Vec3i(1, 2, 3))
        }

        run {
            val r = Vec1(1f)
            val s = Vec1(2f)
            val t = Vec1(3f)
            val o = Vec3(1f, 2f, 3f)

            val a = Vec3(r)
            val b = Vec3(1f)
            assert(a == b)

            val c = Vec3(r, s, t)
            assert(c == o)

            val d = Vec3(r, 2f, 3f)
            assert(d == o)

            val e = Vec3(1f, s, 3f)
            assert(e == o)

            val f = Vec3(1f, s, t)
            assert(f == o)

            val g = Vec3(r, 2f, t)
            assert(g == o)

            val h = Vec3(r, s, 3f)
            assert(h == o)
        }

        run {
            val r = Vec1(1.0)
            val s = Vec1d(2.0)
            val t = Vec1(3.0)
            val o = Vec3(1f, 2f, 3f)

            val a = Vec3(r)
            val b = Vec3(1.0)
            assert(a == b)

            val c = Vec3(r, s, t)
            assert(c == o)

            val d = Vec3(r, 2.0, 3.0)
            assert(d == o)

            val e = Vec3(1f, s, 3.0)
            assert(e == o)

            val f = Vec3(1.0, s, t)
            assert(f == o)

            val g = Vec3(r, 2.0, t)
            assert(g == o)

            val h = Vec3(r, s, 3.0)
            assert(h == o)
        }
    }

    @Test
    fun `vec3bool ctor`() {

        val a=Vec3bool(true)
        val b=Vec3bool(true)
        val c=Vec3bool(false)
        val d = a and b
        val e = a and c
        val f = a or c

        assert(d == Vec3bool(true))
        assert(e == Vec3bool(false))
        assert(f == Vec3bool(true))

        val g = a == c
        val h = a != c
        assert(!g)
        assert(h)
    }

    @Test
    fun operators() {

        run {
            val a=Vec3i(1)
            val b = Vec3i(1)
            val r = a != b
            val s = a == b

            assert(s && !r)
        }

        run {
            val a=Vec3(1f, 2f, 3f)
            val b=Vec3(4f, 5f, 6f)

            val c = a + b
            assert(c == Vec3(5, 7, 9))

            val d = b - a
            assert(d == Vec3(3))

            val e = a * b
            assert(e == Vec3(4, 10, 18))

            val f = b / a
            assert(f == Vec3(4, 2.5, 2))

            val g = a + 1f
            assert(g== Vec3(2, 3, 4))

            val h = b - 1f
            assert(h== Vec3(3, 4, 5))

            val i = a * 2f
            assert(i== Vec3(2, 4, 6))

            val j = b / 2f
            assert(j== Vec3(2, 2.5, 3))

            val k = 1f + a
            assert(k== Vec3(2, 3, 4))

            val l = 1f - b
            assert(l== Vec3(-3, -4, -5))

            val m = 2f * a
            assert(m== Vec3(2, 4, 6))

            val n = 2f / b
            assert(n== Vec3(0.5, 2.0 / 5.0, 2.0 / 6.0))
        }

        run {
            val a=Vec3i(1f, 2f, 3f)
            val b=Vec3i(4f, 5f, 6f)

            a += b
            assert(a == Vec3i(5, 7, 9))

            a += 1
            assert(a == Vec3i(6, 8, 10))
        }
        run {
            val a=Vec3i(1f, 2f, 3f)
            val b=Vec3i(4f, 5f, 6f)

            b -= a
            assert(b == Vec3i(3))

            b -= 1
            assert(b == Vec3i(2))
        }
        run {
            val a=Vec3i(1f, 2f, 3f)
            val b=Vec3i(4f, 5f, 6f)

            a *= b
            assert(a == Vec3i(4, 10, 18))

            a *= 2
            assert(a == Vec3i(8, 20, 36))
        }
        run {
            val a=Vec3i(1f, 2f, 3f)
            val b=Vec3i(4f, 4f, 6f)

            b /= a
            assert(b == Vec3i(4, 2, 2))

            b /= 2
            assert(b == Vec3i(2, 1, 1))
        }
        run {
            val b=Vec3i(2)

            b /= b.y
            assert(b == Vec3i(1))
        }

        run {
            val a=Vec3i(1f, 2f, 3f)
            val b = -a
            assert(b == Vec3i(-1f, -2f, -3f))
        }

        run {
            var a=Vec3i(1f, 2f, 3f)
            val b = --a
            assert(b == Vec3i(0f, 1f, 2f))
        }

        run {
            var a=Vec3i(1f, 2f, 3f)
            val b = a--
//            assert(b == Vec3i(1f, 2f, 3f))
            assert(a == Vec3i(0f, 1f, 2f))
        }

        run {
            var a=Vec3i(1f, 2f, 3f)
            val b = ++a
            assert(b == Vec3i(2f, 3f, 4f))
        }

        run {
            var a=Vec3i(1f, 2f, 3f)
            val b = a++
//            assert(b == Vec3i(1f, 2f, 3f))
            assert(a == Vec3i(2f, 3f, 4f))
        }
    }

    @Test
    fun size() {
        assert(Vec3.length == 3)
        assert(Vec3d.length == 3)
    }
}