package glm_

import glm_.vec2.Vec2
import glm_.vec2.Vec2b
import glm_.vec2.Vec2s
import glm_.vec3.Vec3
import glm_.vec4.Vec4
import glm_.vec4.Vec4b
import glm_.vec4.Vec4i
import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.StringSpec
import kotlin.coroutines.experimental.EmptyCoroutineContext.plus
import kotlin.system.measureNanoTime

class packing_ : StringSpec() {

    init {

        "float2half" {

            val ints = intArrayOf(2863311530.i)

            val res = shortArrayOf(38229.s)

            repeat(ints.size) {
                glm.detail.float2half(ints[it]) shouldBe res[it]
            }
        }

        "float2packed11" {

            val ints = intArrayOf(2863311530.i)

            val res = intArrayOf(341)

            repeat(ints.size) {
                glm.detail.float2packed11(ints[it]) shouldBe res[it]
            }
        }

        "packed11ToFloat" {

            val ints = intArrayOf(2863311530.i)

            val res = intArrayOf(1028915200.i)

            repeat(ints.size) {
                glm.detail.packed11ToFloat(ints[it]) shouldBe res[it]
            }
        }

        "float2packed10" {

            val ints = intArrayOf(2863311530.i)

            val res = intArrayOf(170)

            repeat(ints.size) {
                glm.detail.float2packed10(ints[it]) shouldBe res[it]
            }
        }

        "packed10ToFloat" {

            val ints = intArrayOf(2863311530.i)

            val res = intArrayOf(1118306304.i)

            repeat(ints.size) {
                glm.detail.packed10ToFloat(ints[it]) shouldBe res[it]
            }
        }

        "half2float" {

            val ints = intArrayOf(2863311530.i)

            val res = intArrayOf(3176480768.i)

            repeat(ints.size) {
                glm.detail.half2float(ints[it]) shouldBe res[it]
            }
        }

        "packUnorm1x8" {

            val floats = floatArrayOf(0f, .1f, -1f, .2f, 20f)

            val res = byteArrayOf(0, 26, 0, 51, 255.b)

            repeat(floats.size) {
                glm.packUnorm1x8(floats[it]) shouldBe res[it]
            }
        }

        "unpackUnorm1x8" {

            val bytes = byteArrayOf(0, 26, 1, 51, 255.b)

            val res = floatArrayOf(0.000000f, 0.101961f, 0.003922f, 0.200000f, 1.000000f)


            repeat(bytes.size) {
                glm.epsilonEqual(glm.unpackUnorm1x8(bytes[it]), res[it], 0.000001f) shouldBe true
            }
        }

        "packUnorm2x8" {

            val vecs = arrayOf(Vec2(0f, .1f), Vec2(.2f, .3f))

            val res = shortArrayOf(26, 13133)


            repeat(vecs.size) {
                glm.packUnorm2x8(vecs[it]) shouldBe res[it]
            }
        }

        "unpackUnorm2x8" {

            val shorts = shortArrayOf(26, 13133)

            val res = arrayOf(Vec2(0f, 0.101960793f), Vec2(0.200000018f, 0.301960796f))

            repeat(res.size) {
                glm.all(
                        glm.epsilonEqual(
                                glm.unpackUnorm2x8(shorts[it]),
                                res[it],
                                0.000001f)) shouldBe true
            }
        }

        "packSnorm1x8" {

            val floats = floatArrayOf(0f, .1f, -1f, 2f)

            val res = byteArrayOf(0, 13, 129.b, 127)

            repeat(res.size) {
                glm.packSnorm1x8(floats[it]) shouldBe res[it]
            }
        }

        "unpackSnorm1x8" {

            val bytes = byteArrayOf(0, 1, 250.b, 255.b)

            val res = floatArrayOf(0.000000f, 0.007874f, -0.047244f, -0.007874f)

            repeat(res.size) {
                glm.epsilonEqual(glm.unpackSnorm1x8(bytes[it]), res[it], 0.000001f) shouldBe true
            }
        }

        "packSnorm2x8" {

            val vecs = arrayOf(Vec2(0f, .1f), Vec2(.2f, .3f))

            val res = shortArrayOf(13, 6438)

            repeat(res.size) {
                glm.packSnorm2x8(vecs[it]) shouldBe res[it]
            }
        }

        "unpackSnorm2x8" {

            val shorts = shortArrayOf(0, 1, -1, 32767)

            val res = arrayOf(Vec2(0f, 0f), Vec2(0f, 0.00787401572f), Vec2(-0.00787401572f), Vec2(1f, -0.00787401572f))


            repeat(shorts.size) {
                glm.all(
                        glm.epsilonEqual(
                                glm.unpackSnorm2x8(shorts[it]),
                                res[it],
                                0.000001f)) shouldBe true
            }
        }

        "packUnorm1x16" {

            val floats = floatArrayOf(0f, .1f, 1f)

            val res = shortArrayOf(0, 6554, 65535.s)

            repeat(floats.size) {
                glm.packUnorm1x16(floats[it]) shouldBe res[it]
            }
        }

        "packUnorm4x16" {

            val vecs = arrayOf(Vec4(0f, .1f, .2f, .3f))

            val res = longArrayOf(28150074657997)

            repeat(vecs.size) {
                glm.packUnorm4x16(vecs[it]) shouldBe res[it]
            }
        }

        "unpackUnorm4x16" {

            val longs = longArrayOf(28150074657997)

            val res = arrayOf(Vec4(0f, 0.1f, 0.2f, 0.3f))

            repeat(res.size) {
                glm.all(
                        glm.epsilonEqual(
                                glm.unpackUnorm4x16(longs[it]),
                                res[it],
                                0.00001f)) shouldBe true
            }
        }

        "packSnorm1x16" {

            val floats = floatArrayOf(0f, .1f, -1f, 32767f, 255f)

            val res = shortArrayOf(0, 3277, 32769.s, 32767, 32767)

            repeat(res.size) {
                glm.packSnorm1x16(floats[it]) shouldBe res[it]
            }
        }

        "unpackSnorm1x16" {

            val shorts = shortArrayOf(0, 1, -2, 10_000, -20_000)

            val res = floatArrayOf(0.000000f, 0.000031f, -0.000061f, 0.305185f, -0.610370f)

            repeat(res.size) {
                glm.epsilonEqual(
                        glm.unpackSnorm1x16(shorts[it]),
                        res[it],
                        0.000001f) shouldBe true
            }
        }

        "packSnorm4x16" {

            val vecs = arrayOf(Vec4(0f, .1f, -.2f, 3f))

            val res = longArrayOf(14078473371647)

            repeat(res.size) {
                glm.packSnorm4x16(vecs[it]) shouldBe res[it]
            }
        }

        "unpackSnorm4x16" {

            val longs = longArrayOf(14078473371647)

            val res = arrayOf(Vec4(0f, .1f, -.2f, 3f))

            repeat(longs.size) {
                glm.all(
                        glm.epsilonEqual(
                                glm.unpackSnorm4x16(longs[it]),
                                res[it],
                                0.000001f))
            }
        }

        "packHalf1x16" {

            val floats = floatArrayOf(0f, 1f, -1f, 2f, -2f, 1.9f)

            val res = shortArrayOf(0, 15360, 48128.s, 16384, 49152.s, 16282)

            repeat(floats.size) {
                glm.packHalf1x16(floats[it]) shouldBe res[it]
            }
        }

        "unpackHalf1x16" {

            val shorts = shortArrayOf(0, 15360, 48128.s, 16384, 49152.s, 16282)

            val res = floatArrayOf(0f, 1f, -1f, 2f, -2f, 1.9f)

            repeat(shorts.size) {
                glm.epsilonEqual(glm.unpackHalf1x16(shorts[it]), res[it], 0.000001f)
            }
        }


        "test_Half1x16" {

            floatArrayOf(0f, 1f, -1f, 2f, -2f, 1.9f).forEach {

                val p0 = glm.packHalf1x16(it)
                val v0 = glm.unpackHalf1x16(p0)
                val p1 = glm.packHalf1x16(v0)
                val v1 = glm.unpackHalf1x16(p1)
                v0 shouldBe v1
            }
        }

        "test_Half4x16" {

            val tests = arrayOf(Vec4(1f), Vec4(0f), Vec4(2f), Vec4(.1f), Vec4(.5f), Vec4(.9f))

            repeat(tests.size) {

                val p0 = glm.packHalf4x16(tests[it])
                val v0 = glm.unpackHalf4x16(p0)
                val p1 = glm.packHalf4x16(v0)
                val v1 = glm.unpackHalf4x16(p1)
//                val p2 = glm.packHalf(tests[it])
//                val v2 = glm.unpackHalf(p2)
                v0 shouldBe v1
            }
        }

        "test_I3x10_1x2" {

            val tests = arrayOf(Vec4i(0), Vec4i(1), Vec4i(-1), Vec4i(2), Vec4i(-2), Vec4i(3))

            repeat(tests.size) {

                val p0 = glm.packI3x10_1x2(tests[it])
                val v0 = glm.unpackI3x10_1x2(p0)
                val p1 = glm.packI3x10_1x2(v0)
                val v1 = glm.unpackI3x10_1x2(p1)
              v0 shouldBe v1
            }
        }

        "test_U3x10_1x2" {

            val tests = arrayOf(Vec4i(0), Vec4i(1), Vec4i(2), Vec4i(3), Vec4i(4), Vec4i(5))

            repeat(tests.size) {

                val p0 = glm.packU3x10_1x2(tests[it])
                val v0 = glm.unpackU3x10_1x2(p0)
                val p1 = glm.packU3x10_1x2(v0)
                val v1 = glm.unpackU3x10_1x2(p1)
                glm.all(glm.equal(v0, v1)) shouldBe true
            }
        }

        "test_Snorm3x10_1x2" {

            val tests = arrayOf(Vec4(0f), Vec4(1f), Vec4(2f), Vec4(3f), Vec4(4f), Vec4(5f))

            repeat(tests.size) {

                val p0 = glm.packSnorm3x10_1x2(tests[it])
                val v0 = glm.unpackSnorm3x10_1x2(p0)
                val p1 = glm.packSnorm3x10_1x2(v0)
                val v1 = glm.unpackSnorm3x10_1x2(p1)

                glm.all(glm.epsilonEqual(v0, v1, 0.01f)) shouldBe true
            }
        }

        "test_Unorm3x10_1x2" {

            val tests = arrayOf(Vec4(1f), Vec4(0f), Vec4(2f), Vec4(.1f), Vec4(.5f), Vec4(.9f))

            repeat(tests.size) {

                val p0 = glm.packUnorm3x10_1x2(tests[it])
                val v0 = glm.unpackUnorm3x10_1x2(p0)
                val p1 = glm.packUnorm3x10_1x2(v0)
                val v1 = glm.unpackUnorm3x10_1x2(p1)

                glm.all(glm.epsilonEqual(v0, v1, 0.001f)) shouldBe true
            }
        }

        "test_F2x11_1x10" {

            val tests = arrayOf(Vec3(1f), Vec3(0f), Vec3(2f), Vec3(.1f), Vec3(.5f), Vec3(.9f))

            repeat(tests.size) {

                val p0 = glm.packF2x11_1x10(tests[it])
                val v0 = glm.unpackF2x11_1x10(p0)
                val p1 = glm.packF2x11_1x10(v0)
                val v1 = glm.unpackF2x11_1x10(p1)
                glm.all(glm.equal(v0, v1)) shouldBe true
            }
        }

        "test_F3x9_E1x5" {

            val tests = arrayOf(Vec3(1f), Vec3(0f), Vec3(2f), Vec3(.1f), Vec3(.5f), Vec3(.9f))

            repeat(tests.size) {

                val p0 = glm.packF3x9_E1x5(tests[it])
                val v0 = glm.unpackF3x9_E1x5(p0)
                val p1 = glm.packF3x9_E1x5(v0)
                val v1 = glm.unpackF3x9_E1x5(p1)
                glm.all(glm.epsilonEqual(v0, v1, 0.01f)) shouldBe true
            }
        }
    }
}