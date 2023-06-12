package glm_.gtc

import glm_.*
import glm_.vec1.Vec1
import glm_.vec2.*
import glm_.vec3.Vec3
import glm_.vec4.*
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import unsigned.Uint
import unsigned.Ulong
import unsigned.Ushort

class gtc_packing : StringSpec() {

    init {
        "Half1x16" {

            floatArrayOf(0f, 1f, -1f, 2f, -2f, 1.9f)
                    .forEach {
                        val p0 = glm.packHalf1x16(it)
                        val v0 = glm.unpackHalf1x16(p0)
                        val p1 = glm.packHalf1x16(v0)
                        val v1 = glm.unpackHalf1x16(p1)
                        v0 shouldEqual v1
                    }
        }

        "Half4x16"        {

            listOf(Vec4(1f), Vec4(0f), Vec4(2f), Vec4(0.1f), Vec4(0.5f), Vec4(-0.9f))
                    .forEach {
                        val p0 = glm.packHalf4x16(it)
                        val v0 = glm.unpackHalf4x16(p0)
                        val p1 = glm.packHalf4x16(v0)
                        val v1 = glm.unpackHalf4x16(p1)
                        val p2 = glm.detail.packHalf(v0)
                        val v2 = glm.detail.unpackHalf(p2)

                        v0 shouldEqual v1
                        v0 shouldEqual v2
                    }
        }

        "I3x10_1x2" {

            listOf(Vec4i(0), Vec4i(1), Vec4i(-1), Vec4i(2), Vec4i(-2), Vec4i(3))
                    .forEach {
                        val p0 = glm.packI3x10_1x2(it)
                        val v0 = glm.unpackI3x10_1x2(p0)
                        val p1 = glm.packI3x10_1x2(v0)
                        val v1 = glm.unpackI3x10_1x2(p1)
                        v0 shouldBe v1
                    }
        }

        "U3x10_1x2" {

            listOf(Vec4ui(0), Vec4ui(1), Vec4ui(2), Vec4ui(3), Vec4ui(4), Vec4ui(5))
                    .forEach {
                        val p0 = glm.packU3x10_1x2(it)
                        val v0 = glm.unpackU3x10_1x2(p0)
                        val p1 = glm.packU3x10_1x2(v0)
                        val v1 = glm.unpackU3x10_1x2(p1)
                        v0 shouldBe v1
                    }

            val v0 = Vec4ub(0xff, 0x77, 0x0, 0x33)
            val p0 = Uint((v0.x.i shl 24) or (v0.y.i shl 16) or (v0.z.i shl 8) or v0.w.i)
            val r0 = Uint(0xff770033) // 0x330077ff is LSB

            p0 shouldBe r0

            val v1 = Vec4ui(0xff, 0x77, 0x0, 0x33)
            val p1 = glm.packU3x10_1x2(v1)
            val r1 = Uint(0x3fc77003) // 0xc001dcff is LSB

            p1 shouldBe r1
        }

        "Snorm3x10_1x2" {

            listOf(Vec4(1f), Vec4(0f), Vec4(2f), Vec4(0.1f), Vec4(0.5f), Vec4(0.9f))
                    .forEach {
                        val p0 = glm.packSnorm3x10_1x2(it)
                        val v0 = glm.unpackSnorm3x10_1x2(p0)
                        val p1 = glm.packSnorm3x10_1x2(v0)
                        val v1 = glm.unpackSnorm3x10_1x2(p1)

                        v0.shouldEqual(v1, 0.01f)
                    }
        }

        "Unorm3x10_1x2" {

            listOf(Vec4(1f), Vec4(0f), Vec4(2f), Vec4(0.1f), Vec4(0.5f), Vec4(0.9f))
                    .forEach {
                        val p0 = glm.packUnorm3x10_1x2(it)
                        val v0 = glm.unpackUnorm3x10_1x2(p0)
                        val p1 = glm.packUnorm3x10_1x2(v0)
                        val v1 = glm.unpackUnorm3x10_1x2(p1)

                        v0.shouldEqual(v1, 0.001f)
                    }
        }

        "F2x11_1x10" {

            listOf(Vec3(1f), Vec3(0f), Vec3(2f), Vec3(0.1f), Vec3(0.5f), Vec3(0.9f))
                    .forEach {
                        val p0 = glm.packF2x11_1x10(it)
                        val v0 = glm.unpackF2x11_1x10(p0)
                        val p1 = glm.packF2x11_1x10(v0)
                        val v1 = glm.unpackF2x11_1x10(p1)
                        v0 shouldEqual v1
                    }
        }

        "F3x9_E1x5" {

            listOf(Vec3(1f), Vec3(0f), Vec3(2f), Vec3(0.1f), Vec3(0.5f), Vec3(0.9f))
                    .forEach {
                        val p0 = glm.packF3x9_E1x5(it)
                        val v0 = glm.unpackF3x9_E1x5(p0)
                        val p1 = glm.packF3x9_E1x5(v0)
                        val v1 = glm.unpackF3x9_E1x5(p1)
                        v0 shouldEqual v1
                    }
        }

        "RGBM" {

            repeat(1024) {
                val color = Vec3(it.f)
                val rgbm = glm.packRGBM(color)
                val result = glm.unpackRGBM(rgbm)

                color.shouldEqual(result, 0.01f)
            }
        }

        "packUnorm1x16" {

            listOf(Vec1(1f), Vec1(0.5f), Vec1(0.1f), Vec1(0f))
                    .forEach { A ->
                        val B = glm.packUnorm1x16(A.x)
                        val C = Vec1(glm.unpackUnorm1x16(B))
                        A.shouldEqual(C, 1f / 65535f)
                    }
        }

        "packSnorm1x16"        {

            listOf(Vec1(1f), Vec1(0f), Vec1(-0.5f), Vec1(-0.1f))
                    .forEach { A ->
                        val B = glm.packSnorm1x16(A.x)
                        val C = Vec1(glm.unpackSnorm1x16(B))
                        A.shouldEqual(C, 1f / 32767f * 2f)
                    }
        }

        "packUnorm2x16"        {

            listOf(Vec2(1f, 0f), Vec2(0.5f, 0.7f), Vec2(0.1f, 0.2f))
                    .forEach { A ->
                        val B = glm.packUnorm2x16(A)
                        val C = glm.unpackUnorm2x16(B)
                        A.shouldEqual(C, 1f / 65535f)
                    }
        }

        "packSnorm2x16" {

            listOf(Vec2(1f, 0f), Vec2(-0.5f, -0.7f), Vec2(-0.1f, 0.1f))
                    .forEach { A ->
                        val B = glm.packSnorm2x16(A)
                        val C = glm.unpackSnorm2x16(B)
                        A.shouldEqual(C, 1f / 32767f * 2f)
                    }
        }

        "packUnorm4x16" {

            listOf(Vec4(1f), Vec4(0.5f), Vec4(0.1f), Vec4(0f))
                    .forEach { A ->
                        val B = glm.packUnorm4x16(A)
                        val C = glm.unpackUnorm4x16(B)
                        A.shouldEqual(C, 1f / 65535f)
                    }
        }

        "packSnorm4x16" {

            listOf(Vec4(1.0f, 0.0f, -0.5f, 0.5f), Vec4(-0.3f, -0.7f, 0.3f, 0.7f), Vec4(-0.1f, 0.1f, -0.2f, 0.2f))
                    .forEach { A ->
                        val B = glm.packSnorm4x16(A)
                        val C = glm.unpackSnorm4x16(B)
                        A.shouldEqual(C, 1f / 32767f * 2f)
                    }
        }

        "packUnorm1x8"        {

            listOf(Vec1(1f), Vec1(0.5f), Vec1(0f))
                    .forEach { A ->
                        val B = glm.packUnorm1x8(A.x)
                        val C = Vec1(glm.unpackUnorm1x8(B))
                        A.shouldEqual(C, 1f / 255f)
                    }
        }

        "packSnorm1x8" {

            listOf(Vec1(1f), Vec1(-0.7f), Vec1(-1f))
                    .forEach { A ->
                        val B = glm.packSnorm1x8(A.x)
                        val C = Vec1(glm.unpackSnorm1x8(B))
                        A.shouldEqual(C, 1f / 127f)
                    }
        }

        "packUnorm2x8"        {

            listOf(Vec2(1f, 0.7f), Vec2(0.5f, 0.1f))
                    .forEach { A ->
                        val B = glm.packUnorm2x8(A)
                        val C = glm.unpackUnorm2x8(B)
                        A.shouldEqual(C, 1f / 255f)
                    }
        }

        "packSnorm2x8"        {

            listOf(Vec2(1f, 0f), Vec2(-0.7f, -0.1f))
                    .forEach { A ->
                        val B = glm.packSnorm2x8(A)
                        val C = glm.unpackSnorm2x8(B)
                        A.shouldEqual(C, 1f / 127f)
                    }
        }

        "packUnorm4x8"        {

            listOf(Vec4(1f, 0.7f, 0.3f, 0f), Vec4(0.5f, 0.1f, 0.2f, 0.3f))
                    .forEach { A ->
                        val B = glm.packUnorm4x8(A)
                        val C = glm.unpackUnorm4x8(B)
                        A.shouldEqual(C, 1f / 255f)
                    }
        }

        "packSnorm4x8"        {

            listOf(Vec4(1f, 0f, -0.5f, -1f), Vec4(-0.7f, -0.1f, 0.1f, 0.7f))
                    .forEach { A ->
                        val B = glm.packSnorm4x8(A)
                        val C = glm.unpackSnorm4x8(B)
                        A.shouldEqual(C, 1f / 127f)
                    }
        }

//        "packUnorm"        {
//
//            listOf(Vec2(1f, 0.7f), Vec2(0.5f, 0.1f))
//                    .forEach { A ->
//                val B = glm.packUnorm(B);
//                glm::vec2 D = glm::unpackUnorm<float>(C);
//                Error += glm::all(glm::epsilonEqual(B, D, 1.0f / 255.f)) ? 0 : 1;
//                assert(!Error);
//            }
//
//            return Error;
//        }

//        int test_packSnorm()
//        {
//            int Error = 0;
//
//            std::vector<glm::vec2> A;
//            A.push_back(glm::vec2( 1.0f, 0.0f));
//            A.push_back(glm::vec2(-0.5f,-0.7f));
//            A.push_back(glm::vec2(-0.1f, 0.1f));
//
//            for(std::size_t i = 0; i < A.size(); ++i)
//            {
//                glm::vec2 B(A[i]);
//                glm::i16vec2 C = glm::packSnorm<glm::int16>(B);
//                glm::vec2 D = glm::unpackSnorm<float>(C);
//                Error += glm::all(glm::epsilonEqual(B, D, 1.0f / 32767.0f * 2.0f)) ? 0 : 1;
//                assert(!Error);
//            }
//
//            return Error;
//        }
//
        "packUnorm2x4" {

            listOf(Vec2(1f, 0.7f), Vec2(0.5f, 0f))
                    .forEach { A ->
                        val B = glm.packUnorm2x4(A)
                        val C = glm.unpackUnorm2x4(B)
                        A.shouldEqual(C, 1f / 15f)
                    }
        }

        "packUnorm4x4"        {

            listOf(Vec4(1f, 0.7f, 0.5f, 0f), Vec4(0.5f, 0.1f, 0f, 1f))
                    .forEach { A ->
                        val B = glm.packUnorm4x4(A);
                        val C = glm.unpackUnorm4x4(B)
                        A.shouldEqual(C, 1f / 15f)
                    }
        }

        "packUnorm3x5_1x1"        {

            listOf(Vec4(1f, 0.7f, 0.5f, 0f), Vec4(0.5f, 0.1f, 0f, 1f))
                    .forEach { A ->
                        val B = glm.packUnorm3x5_1x1(A)
                        val C = glm.unpackUnorm3x5_1x1(B)
                        A.shouldEqual(C, 1f / 15f)
                    }
        }

        "packUnorm1x5_1x6_1x5" {

            listOf(Vec3(1f, 0.7f, 0.5f), Vec3(0.5f, 0.1f, 0f))
                    .forEach { A ->
                        val B = glm.packUnorm1x5_1x6_1x5(A)
                        val C = glm.unpackUnorm1x5_1x6_1x5(B)
                        A.shouldEqual(C, 1f / 15f)
                    }
        }

        "packUnorm2x3_1x2"        {

            listOf(Vec3(1f, 0.7f, 0.5f), Vec3(0.5f, 0.1f, 0f))
                    .forEach { A ->
                        val B = glm.packUnorm2x3_1x2(A)
                        val C = glm.unpackUnorm2x3_1x2(B)
                        A.shouldEqual(C, 1f / 3f)
                    }
        }

        "packUint2x8" {

            val source = Vec2ub(1, 2)

            val packed = glm.packUint2x8(source)
            packed shouldNotBe Ushort(0)

            val unpacked = glm.unpackUint2x8(packed)
            source shouldBe unpacked
        }

        "packUint4x8"        {

            val source = Vec4ub(1, 2, 3, 4)

            val packed = glm.packUint4x8(source)
            packed shouldNotBe Uint(0)

            val unpacked = glm.unpackUint4x8(packed)
            source shouldBe unpacked
        }

        "packUint2x16"        {

            val source = Vec2us(1, 2)

            val packed = glm.packUint2x16(source)
            packed shouldNotBe Uint(0)

            val unpacked = glm.unpackUint2x16(packed)
            source shouldBe unpacked
        }

        "packUint4x16"        {

            val source = Vec4us(1, 2, 3, 4)

            val packed = glm.packUint4x16(source)
            packed shouldNotBe Ulong(0)

            val unpacked = glm.unpackUint4x16(packed)
            source shouldBe unpacked
        }

        "packUint2x32" {

            val source = Vec2ui(1, 2)

            val packed = glm.packUint2x32(source)
            packed shouldNotBe Ulong(0)

            val unpacked = glm.unpackUint2x32(packed)
            source shouldBe unpacked
        }

        "packInt2x8"        {

            val source = Vec2b(1, 2)

            val packed = glm.packInt2x8(source)
            packed shouldNotBe 0.s

            val unpacked = glm.unpackInt2x8(packed)
            source shouldBe unpacked
        }

        "packInt4x8"        {

            val source = Vec4b(1, 2, 3, 4)

            val packed = glm.packInt4x8(source)
            packed shouldNotBe 0

            val unpacked = glm.unpackInt4x8(packed)
            source shouldBe unpacked
        }

        "packInt2x16"        {

            val source = Vec2s(1, 2)

            val packed = glm.packInt2x16(source)
            packed shouldNotBe 0

            val unpacked = glm.unpackInt2x16(packed)
            source shouldBe unpacked
        }

        "packInt4x16"        {

            val source = Vec4s(1, 2, 3, 4)

            val packed = glm.packInt4x16(source)
            packed shouldNotBe 0L

            val unpacked = glm.unpackInt4x16(packed)
            source shouldBe unpacked
        }

        "packInt2x32"        {

            val source = Vec2i(1, 2)

            val packed = glm.packInt2x32(source)
            packed shouldNotBe 0L

            val unpacked = glm.unpackInt2x32(packed)
            source shouldBe unpacked
        }

        // custom

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
    }
}
