package glm

import glm.vec2.Vec2
import glm.vec2.Vec2i
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

//            val k = 1f + a
//            Error += glm::all(glm::equal(K, glm::vec2(2, 3), glm::epsilon<float>())) ? 0 : 1
//
//            glm::vec2 L = 1.0f - B
//            Error += glm::all(glm::equal(L, glm::vec2(-3, -4), glm::epsilon<float>())) ? 0 : 1
//
//            glm::vec2 M = 2.0f * A
//            Error += glm::all(glm::equal(M, glm::vec2(2, 4), glm::epsilon<float>())) ? 0 : 1
//
//            glm::vec2 N = 2.0f / B
//            Error += glm::all(glm::equal(N, glm::vec2(0.5, 2.0 / 5.0), glm::epsilon<float>())) ? 0 : 1
        }
//
//        {
//            glm::vec2 A(1.0f, 2.0f);
//            glm::vec2 B(4.0f, 5.0f);
//
//            A += B;
//            Error += glm::all(glm::equal(A, glm::vec2(5, 7), glm::epsilon<float>())) ? 0 : 1;
//
//            A += 1.0f;
//            Error += glm::all(glm::equal(A, glm::vec2(6, 8), glm::epsilon<float>())) ? 0 : 1;
//        }
//        {
//            glm::ivec2 A(1.0f, 2.0f);
//            glm::ivec2 B(4.0f, 5.0f);
//
//            B -= A;
//            Error += B == glm::ivec2(3, 3) ? 0 : 1;
//
//            B -= 1.0f;
//            Error += B == glm::ivec2(2, 2) ? 0 : 1;
//        }
//        {
//            glm::ivec2 A(1.0f, 2.0f);
//            glm::ivec2 B(4.0f, 5.0f);
//
//            A *= B;
//            Error += A == glm::ivec2(4, 10) ? 0 : 1;
//
//            A *= 2;
//            Error += A == glm::ivec2(8, 20) ? 0 : 1;
//        }
//        {
//            glm::ivec2 A(1.0f, 2.0f);
//            glm::ivec2 B(4.0f, 16.0f);
//
//            B /= A;
//            Error += B == glm::ivec2(4, 8) ? 0 : 1;
//
//            B /= 2.0f;
//            Error += B == glm::ivec2(2, 4) ? 0 : 1;
//        }
//        {
//            glm::ivec2 B(2);
//
//            B /= B.y;
//            Error += B == glm::ivec2(1) ? 0 : 1;
//        }
//
//        {
//            glm::ivec2 A(1.0f, 2.0f);
//            glm::ivec2 B = -A;
//            Error += B == glm::ivec2(-1.0f, -2.0f) ? 0 : 1;
//        }
//
//        {
//            glm::ivec2 A(1.0f, 2.0f);
//            glm::ivec2 B = --A;
//            Error += B == glm::ivec2(0.0f, 1.0f) ? 0 : 1;
//        }
//
//        {
//            glm::ivec2 A(1.0f, 2.0f);
//            glm::ivec2 B = A--;
//            Error += B == glm::ivec2(1.0f, 2.0f) ? 0 : 1;
//            Error += A == glm::ivec2(0.0f, 1.0f) ? 0 : 1;
//        }
//
//        {
//            glm::ivec2 A(1.0f, 2.0f);
//            glm::ivec2 B = ++A;
//            Error += B == glm::ivec2(2.0f, 3.0f) ? 0 : 1;
//        }
//
//        {
//            glm::ivec2 A(1.0f, 2.0f);
//            glm::ivec2 B = A++;
//            Error += B == glm::ivec2(1.0f, 2.0f) ? 0 : 1;
//            Error += A == glm::ivec2(2.0f, 3.0f) ? 0 : 1;
//        }
    }
}