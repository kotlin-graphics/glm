package glm_.func

import glm_.scalar.*
import glm_.shouldBe
import glm_.shouldEqual
import glm_.vec2.Vec2
import glm_.vec2.Vec2ui
import glm_.vec4.Vec4
import kotlin.test.Test

class funcPacking {

    @Test
    fun packSnorm4x8() {
        val a = listOf(Vec4( 1f, 0f,-0.5f,-1f), Vec4(-0.7f,-0.1f, 0.1f, 0.7f))
        val b = listOf(0x81C0007Fu, 0x590DF3A7u)
        for (i in a.indices) {
            val c = a[i]
            val d = c.packSnorm4x8()
            d shouldBe b[i]
            val e = d.unpackSnorm4x8()
            c.shouldEqual(e, 1f / 127f)
        }
    }

    @Test
    fun packUnorm4x8() {

//        val packed = Vec4(1f, 0.5f, 0f, 1f).packUnorm4x8()
//        val vec = Vec4ub(255, 128, 0, 255)
//        glm::uint32 & Ref = *reinterpret_cast<glm::uint32*>(&Vec[0])

//        Error += Packed == Ref ? 0 : 1

        val a = listOf(Vec4(1f, 0.7f, 0.3f, 0f), Vec4(0.5f, 0.1f, 0.2f, 0.3f))
        val b = listOf(0x4DB3FFu, 0x4D331A80u)

        for(i in a.indices) {
            val c = a[i]
            val d = c.packUnorm4x8()
            d shouldBe b[i]
            val e = d.unpackUnorm4x8()
            c.shouldEqual(e, 1f / 255f)
        }
    }

    @Test
    fun packSnorm2x16() {
        val a = listOf(Vec2( 1f, 0f), Vec2(-0.5f,-0.7f), Vec2(-0.1f, 0.1f))
        val b = listOf(0x7FFFu, 0xA667C000u, 0xCCDF333u)

        for(i in a.indices) {
            val c = a[i]
            val d = c.packSnorm2x16()
            d shouldBe b[i]
            val e = d.unpackSnorm2x16()
            c.shouldEqual(e, 1f / 32767f * 2f)
        }
    }

    @Test
    fun packUnorm2x16() {

        val a = listOf(Vec2(1f, 0f), Vec2(0.5f, 0.7f), Vec2(0.1f, 0.2f))
        val b = listOf(0xFFFFu, 0xB3338000u, 0x3333199Au)
        for(i in a.indices) {
            val c = a[i]
            val d = c.packUnorm2x16()
            d shouldBe b[i]
            val e = d.unpackUnorm2x16()
            c.shouldEqual(e, 1f / 65535f)
        }
    }

    @Test
    fun packHalf2x16() {
        /*
            std::vector<glm::hvec2> A;
            A.push_back(glm::hvec2(glm::half( 1.0f), glm::half( 2.0f)));
            A.push_back(glm::hvec2(glm::half(-1.0f), glm::half(-2.0f)));
            A.push_back(glm::hvec2(glm::half(-1.1f), glm::half( 1.1f)));
        */
        val a = listOf(Vec2( 1f, 2f), Vec2(-1f,-2f), Vec2(-1.1f, 1.1f))
        val b = listOf(0x40003C00u, 0xC000BC00u, 0x3C66BC66u)

        for(i in a.indices) {
            val c = a[i]
            val d = c.packHalf2x16()
            d shouldBe b[i]
            val e = d.unpackHalf2x16()
            c.shouldEqual(e, 1f / 127f)
        }
    }

    @Test
    fun packDouble2x32() {
        val a = listOf(Vec2ui( 1, 2), Vec2ui(-1,-2), Vec2ui(-1000, 1100))
//        val b = listOf(0xC43E1B73u, 0u, 0u)
        for(i in a.indices) {
            val c = a[i]
            val d = c.packDouble2x32()
//            d shouldEqual b[i]
            val e = d.unpackDouble2x32()
            c shouldBe e
        }
    }
}