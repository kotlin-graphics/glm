package glm_

import glm_.vec2.Vec2b
import glm_.vec2.Vec2s
import glm_.vec4.Vec4b
import glm_.vec4.Vec4i
import io.kotest.matchers.shouldBe
import io.kotest.core.spec.style.StringSpec
import kool.BYTES
import unsigned.toUInt
import unsigned.toULong
import kotlin.system.measureNanoTime

class testBitfield : StringSpec() {

    init {

        "test_uint" {

            val data = listOf(
                    0 to 0x00000000,
                    1 to 0x00000001,
                    2 to 0x00000003,
                    3 to 0x00000007,
                    31 to 0x7fffffff.i,
                    32 to 0xffffffff.i)

            fun maskMix(bits: Int) = if (bits >= Int.BYTES * 8) 0xffffffff.i else (1 shl bits) - 1

            fun maskHalf(bits: Int): Int {
                // We do the shift in two steps because 1 << 32 on an int is undefined.
                val half = bits shr 1
                val fill = 0.inv()
                val shiftHaft = fill shl half
                val rest = bits - half
                val reversed = shiftHaft shl rest

                return reversed.inv()
            }

            fun maskLoop(bits: Int): Int {
                var mask = 0
                for (bit in 0 until bits)
                    mask = mask or (1 shl bit)
                return mask
            }

            data.forEach { maskMix(it.first) shouldBe it.second }
            data.forEach { maskHalf(it.first) shouldBe it.second }
            data.forEach { maskLoop(it.first) shouldBe it.second }
            data.forEach { glm.mask(it.first) shouldBe it.second }
        }

        "test_uvec4" {

            val data = listOf(
                    Vec4i(0) to Vec4i(0x00000000),
                    Vec4i(1) to Vec4i(0x00000001),
                    Vec4i(2) to Vec4i(0x00000003),
                    Vec4i(3) to Vec4i(0x00000007),
                    Vec4i(31) to Vec4i(0x7fffffff),
                    Vec4i(32) to Vec4i(0xffffffff))

            data.forEach {
                val result = glm.mask(it.first)
                glm.all(glm.equal(it.second, result)) shouldBe true
            }
        }

        /*"bitfieldInterleave3" { TODO jvm fix https://github.com/g-truc/glm/commit/cad2c545f6123a77af0a583861ae6c91d5330e75
        check also all the rest

            fun refBitfieldInterleave(x: Short, y: Short, z: Short): Long {

                var result = 0L
                var i = 0
                while (i < Short.BYTES * 8) {
                    result = result or ((x.L and (1.L shl i)) shl ((i shl 1) + 0))
                    result = result or ((y.L and (1.L shl i)) shl ((i shl 1) + 1))
                    result = result or ((z.L and (1.L shl i)) shl ((i shl 1) + 2))
                    ++i
                }
                return result
            }


            val xMax = 1 shl 11
            val yMax = 1 shl 11
            val zMax = 1 shl 11

            for (z in 0 until zMax step 27)
                for (y in 0 until yMax step 27)
                    for (x in 0 until xMax step 27) {
                        val resultA = refBitfieldInterleave(x.s, y.s, z.s)
                        val resultB = glm.bitfieldInterleave(x.s, y.s, z.s)
                        resultA shouldBe resultB
                    }
        }

        "bitfieldInterleave4" {

            fun loopBitfieldInterleave(x: Short, y: Short, z: Short, w: Short): Long {

                val v = arrayOf(x.L, y.L, z.L, w.L)
                var result = 0L
                for (i in 0 until Short.BYTES * 8) {
                    result = result or ((((v[0] ushr i) and 1)) shl ((i shl 2) + 0))
                    result = result or ((((v[1] ushr i) and 1)) shl ((i shl 2) + 1))
                    result = result or ((((v[2] ushr i) and 1)) shl ((i shl 2) + 2))
                    result = result or ((((v[3] ushr i) and 1)) shl ((i shl 2) + 3))
                }
                return result
            }

            val xMax = 1 shl 11
            val yMax = 1 shl 11
            val zMax = 1 shl 11
            val wMax = 1 shl 11

            for (w in 0 until wMax step 27)
                for (z in 0 until zMax step 27)
                    for (y in 0 until yMax step 27)
                        for (x in 0 until xMax step 27) {
                            val resultA = loopBitfieldInterleave(x.s, y.s, z.s, w.s)
                            val resultB = glm.bitfieldInterleave(x.s, y.s, z.s, w.s)
                            resultA shouldBe resultB
                        }
        }*/

        "bitfieldInterleave" {

            fun fastBitfieldInterleave(x: Int, y: Int): Long {

                var reg1 = x.L
                var reg2 = y.L

                reg1 = ((reg1 shl 16) or reg1) and "0x0000FFFF0000FFFF".L
                reg1 = ((reg1 shl 8) or reg1) and "0x00FF00FF00FF00FF".L
                reg1 = ((reg1 shl 4) or reg1) and "0x0F0F0F0F0F0F0F0F".L
                reg1 = ((reg1 shl 2) or reg1) and "0x3333333333333333".L
                reg1 = ((reg1 shl 1) or reg1) and "0x5555555555555555".L

                reg2 = ((reg2 shl 16) or reg2) and "0x0000FFFF0000FFFF".L
                reg2 = ((reg2 shl 8) or reg2) and "0x00FF00FF00FF00FF".L
                reg2 = ((reg2 shl 4) or reg2) and "0x0F0F0F0F0F0F0F0F".L
                reg2 = ((reg2 shl 2) or reg2) and "0x3333333333333333".L
                reg2 = ((reg2 shl 1) or reg2) and "0x5555555555555555".L

                return reg1 or (reg2 shl 1)
            }

            fun interleaveBitfieldInterleave(x: Int, y: Int): Long {

                var reg1 = x.L
                var reg2 = y.L

                reg1 = ((reg1 shl 16) or reg1) and "0x0000FFFF0000FFFF".L
                reg2 = ((reg2 shl 16) or reg2) and "0x0000FFFF0000FFFF".L

                reg1 = ((reg1 shl 8) or reg1) and "0x00FF00FF00FF00FF".L
                reg2 = ((reg2 shl 8) or reg2) and "0x00FF00FF00FF00FF".L

                reg1 = ((reg1 shl 4) or reg1) and "0x0F0F0F0F0F0F0F0F".L
                reg2 = ((reg2 shl 4) or reg2) and "0x0F0F0F0F0F0F0F0F".L

                reg1 = ((reg1 shl 2) or reg1) and "0x3333333333333333".L
                reg2 = ((reg2 shl 2) or reg2) and "0x3333333333333333".L

                reg1 = ((reg1 shl 1) or reg1) and "0x5555555555555555".L
                reg2 = ((reg2 shl 1) or reg2) and "0x5555555555555555".L

                return reg1 or (reg2 shl 1)
            }

            run {
                for (y in 0 until (1 shl 10))
                    for (x in 0 until (1 shl 10)) {

                        val a = glm.bitfieldInterleave(x, y)
                        val b = fastBitfieldInterleave(x, y)
                        //glm::uint64 C = loopBitfieldInterleave(x, y);
                        val d = interleaveBitfieldInterleave(x, y)

                        a shouldBe b
                        //assert(A == C);
                        a shouldBe d
                    }
            }

            run {
                for (y in 0 until 127)
                    for (x in 0 until 127) {

                        val a = glm.bitfieldInterleave(x.b, y.b)
                        val b = glm.bitfieldInterleave(x.s, y.s)
                        val c = glm.bitfieldInterleave(x, y)

                        val d = glm.bitfieldInterleave(x.b, y.b).L
                        val e = glm.bitfieldInterleave(x.s, y.s).L
                        val f = glm.bitfieldInterleave(x, y)

                        d shouldBe e
                        d shouldBe f
                    }
            }
        }

        "bitfieldInterleave5" {

            fun bitfieldInterleave_u8vec2(x: Byte, y: Byte): Short {
                var result = (y.toUInt() shl 16) or x.toUInt()
                result = ((result shl 4) or result) and 0x0F0F0F0F
                result = ((result shl 2) or result) and 0x33333333
                result = ((result shl 1) or result) and 0x55555555
                return ((result and 0x0000FFFF) or (result ushr 15)).s
            }

            fun bitfieldDeinterleave_u8vec2(interleavedBitfield: Short): Vec2b {
                var result = interleavedBitfield.toUInt()
                result = ((result shl 15) or result) and 0x55555555
                result = ((result ushr 1) or result) and 0x33333333
                result = ((result ushr 2) or result) and 0x0F0F0F0F
                result = ((result ushr 4) or result) and 0x00FF00FF
                return Vec2b(result and 0x0000FFFF, result ushr 16)
            }

            fun bitfieldInterleave_u8vec4(x: Byte, y: Byte, z: Byte, w: Byte): Int {
                var result = (w.toULong() shl 48) or (z.toULong() shl 32) or (y.toULong() shl 16) or x.toULong()
                result = ((result shl 12) or result) and "0x000F000F000F000F".L
                result = ((result shl 6) or result) and "0x0303030303030303".L
                result = ((result shl 3) or result) and "0x1111111111111111".L

                val a = ((result and 0x000000000000FFFF) ushr (0 - 0)).i
                val b = ((result and 0x00000000FFFF0000) ushr (16 - 3)).i
                val c = ((result and 0x0000FFFF00000000) ushr (32 - 6)).i
                val d = ((result and "0xFFFF000000000000".bi.L) ushr (48 - 12)).i

                return a or b or c or d
            }

            fun bitfieldDeinterleave_u8vec4(interleavedBitfield: Int): Vec4b {
                var result = interleavedBitfield.toULong()
                result = ((result shl 15) or result) and "0x9249249249249249".L
                result = ((result ushr 1) or result) and "0x30C30C30C30C30C3".L
                result = ((result ushr 2) or result) and "0xF00F00F00F00F00F".bi.L
                result = ((result ushr 4) or result) and "0x00FF0000FF0000FF".L
                return Vec4b(
                        (result ushr 0) and "0x000000000000FFFF".L,
                        (result ushr 16) and "0x00000000FFFF0000".L,
                        (result ushr 32) and "0x0000FFFF00000000".L,
                        (result ushr 48) and "0xFFFF000000000000".bi.L)
            }

            fun bitfieldInterleave_u16vec2(x: Short, y: Short): Int {
                var result = (y.toULong() shl 32) or x.toULong()
                result = ((result shl 8) or result) and "0x00FF00FF00FF00FF".L
                result = ((result shl 4) or result) and "0x0F0F0F0F0F0F0F0F".L
                result = ((result shl 2) or result) and "0x3333333333333333".L
                result = ((result shl 1) or result) and "0x5555555555555555".L
                return ((result and "0x00000000FFFFFFFF".L) or (result ushr 31)).i
            }

            fun bitfieldDeinterleave_u16vec2(interleavedBitfield: Int): Vec2s {
                var result = interleavedBitfield.toULong()
                result = ((result shl 31) or result) and "0x5555555555555555".L
                result = ((result ushr 1) or result) and "0x3333333333333333".L
                result = ((result ushr 2) or result) and "0x0F0F0F0F0F0F0F0F".L
                result = ((result ushr 4) or result) and "0x00FF00FF00FF00FF".L
                result = ((result ushr 8) or result) and "0x0000FFFF0000FFFF".L
                return Vec2s(result and "0x00000000FFFFFFFF".L, result ushr 32)
            }

            for (j in 0 until 256)
                for (i in 0 until 256) {
                    val A = bitfieldInterleave_u8vec2(i.b, j.b)
                    val B = glm.bitfieldInterleave(i.b, j.b)
                    A shouldBe B

                    val C = bitfieldDeinterleave_u8vec2(A)
                    C.x shouldBe i.b
                    C.y shouldBe j.b
                }

            for (j in 0 until 256)
                for (i in 0 until 256) {
                    val A = bitfieldInterleave_u8vec4(i.b, j.b, i.b, j.b)
                    val B = glm.bitfieldInterleave(i.b, j.b, i.b, j.b)
//                    println("[$j, $i], $A == $B")
//                    A shouldBe B
/*
			glm::u8vec4 C = bitfieldDeinterleave_u8vec4(A);
			Error += C.x == glm::uint8(i) ? 0 : 1;
			Error += C.y == glm::uint8(j) ? 0 : 1;
			Error += C.z == glm::uint8(i) ? 0 : 1;
			Error += C.w == glm::uint8(j) ? 0 : 1;
*/
                }

            for (j in 0 until 256)
                for (i in 0 until 256) {
                    val A = bitfieldInterleave_u16vec2(i.s, j.s)
                    val B = glm.bitfieldInterleave(i.s, j.s)
                    A shouldBe B
                }

            fun ShortArray.perf_old_u8vec2() = measureNanoTime {
                for (k in 0 until 10_000)
                    for (j in 0 until 256)
                        for (i in 0 until 256)
                            if (this[j * 256 + i] != glm.bitfieldInterleave(i.b, j.b))
                                throw Error()
            }.also { println("glm.bitfieldInterleave(Byte, Byte) Time ${it / 9e9f} seconds") }

            fun ShortArray.perf_new_u8vec2() = measureNanoTime {
                for (k in 0 until 10_000)
                    for (j in 0 until 256)
                        for (i in 0 until 256)
                            if (this[j * 256 + i] != bitfieldInterleave_u8vec2(i.b, j.b))
                                throw Error()
            }.also { println("bitfieldInterleave_u8vec2 Time ${it / 9e9f} seconds") }

            fun IntArray.perf_old_u8vec4() = measureNanoTime {
                for (k in 0 until 10_000)
                    for (j in 0 until 256)
                        for (i in 0 until 256)
                            if (this[j * 256 + i] != glm.bitfieldInterleave(i.b, j.b, i.b, j.b))
                                throw Error()
            }.also { println("glm::bitfieldInterleave(Byte, Byte, Byte, Byte) Time ${it / 9e9f} seconds") }

            fun IntArray.perf_new_u8vec4() = measureNanoTime {
                for (k in 0 until 10_000)
                    for (j in 0 until 256)
                        for (i in 0 until 256) {
//                            if (this[j * 256 + i] != bitfieldInterleave_u8vec4(i.b, j.b, i.b, j.b))
//                                throw Error()
                            val A = this[j * 256 + i]
                            val B = bitfieldInterleave_u8vec4(i.b, j.b, i.b, j.b)
                            if (A != B)
                                println("[$k, $j, $i], $A == $B")
                        }
            }.also { println("bitfieldInterleave_u8vec4 Time ${it / 9e9f} seconds") }

            fun IntArray.perf_old_u16vec2() = measureNanoTime {
                for (k in 0 until 10_000)
                    for (j in 0 until 256)
                        for (i in 0 until 256)
                            if (this[j * 256 + i] != glm.bitfieldInterleave(i.s, j.s))
                                throw Error()
            }.also { println("glm::bitfieldInterleave(Short, Short) Time ${it / 9e9f} seconds") }

            fun IntArray.perf_new_u16vec2() = measureNanoTime {
                for (k in 0 until 10_000)
                    for (j in 0 until 256)
                        for (i in 0 until 256)
                            if (this[j * 256 + i] != bitfieldInterleave_u16vec2(i.s, j.s))
                                throw Error()
            }.also { println("bitfieldInterleave_u16vec2 Time ${it / 9e9f} seconds") }

            val result_u8vec2 = ShortArray(256 * 256)
            for (j in 0 until 256)
                for (i in 0 until 256)
                    result_u8vec2[j * 256 + i] = glm.bitfieldInterleave(i.b, j.b)

            result_u8vec2.perf_old_u8vec2()
            result_u8vec2.perf_new_u8vec2()

            val result_u8vec4 = IntArray(256 * 256)
            for (j in 0 until 256)
                for (i in 0 until 256)
                    result_u8vec4[j * 256 + i] = glm.bitfieldInterleave(i.b, j.b, i.b, j.b)

//            result_u8vec4.perf_old_u8vec4()
//            result_u8vec4.perf_new_u8vec4()

            val result_u16vec2 = IntArray(256 * 256)
            for (j in 0 until 256)
                for (i in 0 until 256)
                    result_u16vec2[j * 256 + i] = glm.bitfieldInterleave(i.s, j.s)

            result_u16vec2.perf_old_u16vec2()
            result_u16vec2.perf_new_u16vec2()
        }
    }
}