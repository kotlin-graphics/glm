package glm.func

import glm.*
import glm.vec1.Vec1
import glm.vec2.Vec2
import glm.vec3.Vec3
import glm.vec4.Vec4
import kotlin.test.Test

class funcExponential {

    @Test
    fun pow() {

        val a = 2f pow 2f
        assert(a.equal(4f, 0.01f))

        val b = Vec1(2f) pow Vec1(2f)
        assert(b.allEqual(Vec1(4f), 0.01f))

        val c = Vec2(2f) pow Vec2(2f)
        assert(c.allEqual(Vec2(4f), 0.01f))

        val d = Vec3(2f) pow Vec3(2f)
        assert(d.allEqual(Vec3(4f), 0.01f))

        val e = Vec4(2f) pow Vec4(2f)
        assert(e.allEqual(Vec4(4f), 0.01f))
    }

    @Test
    fun sqrt() {

        val a = 4f.sqrt()
        assert(a.equal(2f, 0.01f))

        val b = Vec1(4f).sqrt()
        assert(b.allEqual(Vec1(2f), 0.01f))

        val c = Vec2(4f).sqrt()
        assert(c.allEqual(Vec2(2f), 0.01f))

        val d = Vec3(4f).sqrt()
        assert(d.allEqual(Vec3(2f), 0.01f))

        val e = Vec4(4f).sqrt()
        assert(e.allEqual(Vec4(2f), 0.01f))
    }

    @Test
    fun exp() {

        val a = 1f.exp()
        assert(a.equal(glm.e.f, 0.01f))

        val b = Vec1(1f).exp()
        assert(b.allEqual(Vec1(glm.e.f), 0.01f))

        val c = Vec2(1f).exp()
        assert(c.allEqual(Vec2(glm.e.f), 0.01f))

        val d = Vec3(1f).exp()
        assert(d.allEqual(Vec3(glm.e.f), 0.01f))

        val e = Vec4(1f).exp()
        assert(e.allEqual(Vec4(glm.e.f), 0.01f))
    }

    @Test
    fun log() {

        val a = glm.e.f.log()
        assert(a.equal(1f, 0.01f))

        val b = Vec1(glm.e.f).log()
        assert(b.allEqual(Vec1(1f), 0.01f))

        val c = Vec2(glm.e.f).log()
        assert(c.allEqual(Vec2(1f), 0.01f))

        val d = Vec3(glm.e.f).log()
        assert(d.allEqual(Vec3(1f), 0.01f))

        val e = Vec4(glm.e.f).log()
        assert(e.allEqual(Vec4(1f), 0.01f))
    }

    @Test
    fun exp2() {

        val a = 4f.exp2()
        assert(a.equal(16f, 0.01f))

        val b = Vec1(4f).exp2()
        assert(b.allEqual(Vec1(16f), 0.01f))

        val c = Vec2(4f, 3f).exp2()
        assert(c.allEqual(Vec2(16f, 8f), 0.01f))

        val d = Vec3(4f, 3f, 2f).exp2()
        assert(d.allEqual(Vec3(16f, 8f, 4f), 0.01f))

        val e = Vec4(4f, 3f, 2f, 1f).exp2()
        assert(e.allEqual(Vec4(16f, 8f, 4f, 2f), 0.01f))
    }

    @Test
    fun log2() {

        val a = 16f.log2()
        assert(a.equal(4f, 0.01f))

        val b = Vec1(16f).log2()
        assert(b.allEqual(Vec1(4f), 0.01f))

        val c = Vec2(16f, 8f).log2()
        assert(c.allEqual(Vec2(4f, 3f), 0.01f))

        val d = Vec3(16f, 8f, 4f).log2()
        assert(d.allEqual(Vec3(4f, 3f, 2f), 0.01f))

        val e = Vec4(16f, 8f, 4f, 2f).log2()
        assert(e.allEqual(Vec4(4f, 3f, 2f, 1f), 0.01f))
    }

    @Test
    fun inverseSqrt() {

        val a = 16f.inverseSqrt() * 16f.sqrt()
        assert(a.equal(1f, 0.01f))

        val b = Vec1(16f).inverseSqrt() * 16f.sqrt()
        assert(b.allEqual(Vec1(1f), 0.01f))

        val c = Vec2(16f).inverseSqrt() * 16f.sqrt()
        assert(c.allEqual(Vec2(1f), 0.01f))

        val d = Vec3(16f).inverseSqrt() * 16f.sqrt()
        assert(d.allEqual(Vec3(1f), 0.01f))

        val e = Vec4(16f).inverseSqrt() * 16f.sqrt()
        assert(e.allEqual(Vec4(1f), 0.01f))
    }
}