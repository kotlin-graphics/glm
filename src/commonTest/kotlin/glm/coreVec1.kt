package glm

import glm.vec1.Vec1
import glm.vec1.Vec1d
import glm.vec1.Vec1i
import glm.vec2.Vec2
import glm.vec2.Vec2d
import glm.vec2.Vec2i
import kotlin.test.Test

class coreVec1 {

    @Test
    fun `vec1 operators`() {

        val a = Vec1i(1)
        val b = Vec1i(1)
        run {
            val r = a != b
            val s = a == b

            assert(s && !r)
        }

        run {
            a *= 1
            b *= 1
            a += 1
            b += 1

            val r = a != b
            val s = a == b

            assert(s && !r)
        }
    }

    @Test
    fun `vec1 ctor`() {

        /*
        #if GLM_HAS_INITIALIZER_LISTS
            {
                glm::vec1 a{ 0 };
                std::vector<glm::vec1> v = {
                    {0.f},
                    {4.f},
                    {8.f}};
            }

            {
                glm::dvec2 a{ 0 };
                std::vector<glm::dvec1> v = {
                    {0.0},
                    {4.0},
                    {8.0}};
            }
        #endif
        */

        run {
            val a = Vec2(2f)
            val b = Vec2(2f, 3f)
            val c = Vec2(2f, 3)
            //glm::vec2 D = glm::dvec2(2.0); // Build error TODO: What does the specification says?
            val e = Vec2(Vec2d(2.0))
            val f = Vec2(Vec2i(2))
            assert(a.x == 2f)
            assert(b.x == 2f && b.y == 3f)
            assert(c.x == 2f && c.y == 3f)
            assert(e.x == 2f && e.y == 2f)
            assert(f.x == 2f && f.y == 2f)
        }
    }

    @Test
    fun `vec1 size`() {

//        Error += sizeof(glm::vec1) == sizeof(glm::mediump_vec1) ? 0 : 1;
//        Error += 4 == sizeof(glm::mediump_vec1) ? 0 : 1;
//        Error += sizeof(glm::dvec1) == sizeof(glm::highp_dvec1) ? 0 : 1;
//        Error += 8 == sizeof(glm::highp_dvec1) ? 0 : 1;
        assert(Vec1.length == 1)
        assert(Vec1d.length == 1)
    }

    @Test
    fun `vec1 operator increment`() {

        val v0 = Vec1i(1)
        var v1 = Vec1i(v0)
        var v2 = Vec1i(v0)
        val v3 = ++v1
        val v4 = v2++

//        assert(v0 == v4) TODO, this is different
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