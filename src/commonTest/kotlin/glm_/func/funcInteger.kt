package glm_.func

import glm_.assert
import glm_.extensions.L
import glm_.extensions.i
import glm_.extensions.toUInt
import glm_.has
import glm_.scalar.bitCount
import glm_.scalar.bitfieldReverse
import glm_.shouldBe
import glm_.vec1.Vec1i
import glm_.vec1.Vec1ui
import kotlin.test.Test

class funcInteger {

    @Test
    fun bitCount() {
        val values = listOf(0x00000001, 0x00000003, 0x00000002, 0x7fffffff, 0x00000000)
        val results = listOf(1, 2, 1, 31, 0)

        fun bitCount_if(v: Int) = (0 until Int.SIZE_BYTES * 8).count { v has (1 shl it) }

        fun bitCount_vec(v: Int) = (0 until Int.SIZE_BYTES * 8).sumOf { (v shr it) and 1 }

        fun bitCount_bitfield(v: Vec1i): Vec1i {
            fun Vec1ui.call(mask: UInt, shift: Int) = Vec1ui((x and mask) + ((x shr shift) and mask))
            val x = Vec1ui(v)
                    .call(0x5555555555555555uL.toUInt(), 1)
                    .call(0x3333333333333333uL.toUInt(), 2)
                    .call(0x0F0F0F0F0F0F0F0FuL.toUInt(), 4)
                    .call(0x00FF00FF00FF00FFuL.toUInt(), 8)
                    .call(0x0000FFFF0000FFFFuL.toUInt(), 16)
                    .call(0x00000000FFFFFFFFuL.toUInt(), 32)
            return Vec1i(x)
        }

        fun bitCount_bitfield(x: Int) = bitCount_bitfield(Vec1i(x)).x

        run {
            for (i in values.indices) {
                val resultA = values[i].bitCount
                val resultB = bitCount_if(values[i])
                val resultC = bitCount_vec(values[i])
                val resultE = bitCount_bitfield(values[i])

                results[i] shouldBe resultA
                results[i] shouldBe resultB
                results[i] shouldBe resultC
                //                results[i] shouldBe resultE FIXME error on native as well
            }
        }
    }

    @Test
    fun bitfieldReverse() {
        /*
            GLM_FUNC_QUALIFIER unsigned int bitfieldReverseLoop(unsigned int v)
            {
                unsigned int Result(0);
                unsigned int const BitSize = static_cast<unsigned int>(sizeof(unsigned int) * 8);
                for(unsigned int i = 0; i < BitSize; ++i)
                {
                    unsigned int const BitSet(v & (static_cast<unsigned int>(1) << i));
                    unsigned int const BitFirst(BitSet >> i);
                    Result |= BitFirst << (BitSize - 1 - i);
                }
                return Result;
            }

            GLM_FUNC_QUALIFIER glm::uint64_t bitfieldReverseLoop(glm::uint64_t v)
            {
                glm::uint64_t Result(0);
                glm::uint64_t const BitSize = static_cast<glm::uint64_t>(sizeof(unsigned int) * 8);
                for(glm::uint64_t i = 0; i < BitSize; ++i)
                {
                    glm::uint64_t const BitSet(v & (static_cast<glm::uint64_t>(1) << i));
                    glm::uint64_t const BitFirst(BitSet >> i);
                    Result |= BitFirst << (BitSize - 1 - i);
                }
                return Result;
            }
        */
        fun UInt.bitfieldReverseLoop(): UInt {
            var result = 0u
            val bitSize = UInt.SIZE_BYTES * 8
            for (i in 0 until bitSize) {
                val bitSet = this and (1u shl i)
                val bitFirst = bitSet shr i
                result = result or (bitFirst shl (bitSize - 1 - i))
            }
            return result
        }

        fun ULong.bitfieldReverseLoop(): ULong {
            var result = 0uL
            val bitSize = ULong.SIZE_BYTES * 8
            for (i in 0 until bitSize) {
                val bitSet = this and (1uL shl i)
                val bitFirst = bitSet shr i
                result = result or (bitFirst shl (bitSize - 1 - i))
            }
            return result
        }

        fun UInt.bitfieldReverseUint32(): UInt {
            var x = (this and 0x55555555u shl 1) or (this and 0xAAAAAAAAu shr 1)
            x = (x and 0x33333333u shl 2) or (x and 0xCCCCCCCCu shr 2)
            x = (x and 0x0F0F0F0Fu shl 4) or (x and 0xF0F0F0F0u shr 4)
            x = (x and 0x00FF00FFu shl 8) or (x and 0xFF00FF00u shr 8)
            return (x and 0x0000FFFFu shl 16) or (x and 0xFFFF0000u shr 16)
        }

        fun ULong.bitfieldReverseUint64(): ULong {
            var x = (this and 0x5555555555555555uL shl 1) or (this and 0xAAAAAAAAAAAAAAAAuL shr 1)
            x = (x and 0x3333333333333333uL shl 2) or (x and 0xCCCCCCCCCCCCCCCCuL shr 2)
            x = (x and 0x0F0F0F0F0F0F0F0FuL shl 4) or (x and 0xF0F0F0F0F0F0F0F0uL shr 4)
            x = (x and 0x00FF00FF00FF00FFuL shl 8) or (x and 0xFF00FF00FF00FF00uL shr 8)
            x = (x and 0x0000FFFF0000FFFFuL shl 16) or (x and 0xFFFF0000FFFF0000uL shr 16)
            return (x and 0x00000000FFFFFFFFuL shl 32) or (x and 0xFFFFFFFF00000000uL shr 32)
        }

        fun UInt.compute_bitfieldReverseStep(mask: ULong, shift: Int) = ((toULong() and mask shl shift) or (toULong() and mask.inv() shr shift)).toUInt()
        fun ULong.compute_bitfieldReverseStep(mask: ULong, shift: Int) = ((this and mask shl shift) or (this and mask.inv() shr shift))

        fun UInt.bitfieldReverseOps() = compute_bitfieldReverseStep(0x5555555555555555uL, 1)
                .compute_bitfieldReverseStep(0x3333333333333333uL, 2)
                .compute_bitfieldReverseStep(0x0F0F0F0F0F0F0F0FuL, 4)
                .compute_bitfieldReverseStep(0x00FF00FF00FF00FFuL, 8)
                .compute_bitfieldReverseStep(0x0000FFFF0000FFFFuL, 16)

        fun ULong.bitfieldReverseOps() = compute_bitfieldReverseStep(0x5555555555555555uL, 1)
                .compute_bitfieldReverseStep(0x3333333333333333uL, 2)
                .compute_bitfieldReverseStep(0x0F0F0F0F0F0F0F0FuL, 4)
                .compute_bitfieldReverseStep(0x00FF00FF00FF00FFuL, 8)
                .compute_bitfieldReverseStep(0x0000FFFF0000FFFFuL, 16)
                .compute_bitfieldReverseStep(0x00000000FFFFFFFFuL, 32)

        val data32 = listOf(0x00000001u, 0x0000000fu, 0x000000ffu, 0xf0000000u, 0xff000000u, 0xffffffffu, 0x00000000u)
        val res32 = listOf(0x80000000u, 0xf0000000u, 0xff000000u, 0x0000000fu, 0x000000ffu, 0xffffffffu, 0x00000000u)
        val data64 = listOf(0x00000000000000ffuL, 0x000000000000000fuL, 0xf000000000000000uL, 0xffffffffffffffffuL, 0x0000000000000000uL)
        val res64 = listOf(0xff00000000000000uL, 0xf000000000000000uL, 0x000000000000000fuL, 0xffffffffffffffffuL, 0x0000000000000000uL)

        fun test32_bitfieldReverse() {
            for (i in data32.indices)
                data32[i].bitfieldReverse() shouldBe res32[i]
        }

        fun test32_bitfieldReverseLoop() {
            for (i in data32.indices)
                data32[i].bitfieldReverseLoop() shouldBe res32[i]
        }

        fun test32_bitfieldReverseUint32() {
            for (i in data32.indices)
                data32[i].bitfieldReverseUint32() shouldBe res32[i]
        }

        fun test32_bitfieldReverseOps() {
            for (i in data32.indices)
                data32[i].bitfieldReverseOps() shouldBe res32[i]
        }

        fun test64_bitfieldReverse() {
            for (i in data64.indices)
                data64[i].bitfieldReverse() shouldBe res64[i]
        }

        fun test64_bitfieldReverseLoop() {
            for (i in data64.indices)
                data64[i].bitfieldReverseLoop() shouldBe res64[i]
        }

        fun test64_bitfieldReverseUint64() {
            for (i in data64.indices)
                data64[i].bitfieldReverseUint64() shouldBe res64[i]
        }

        fun test64_bitfieldReverseOps() {
            for (i in data64.indices)
                data64[i].bitfieldReverseOps() shouldBe res64[i]
        }

        test32_bitfieldReverse()
        test32_bitfieldReverseLoop()
        test32_bitfieldReverseUint32()
        test32_bitfieldReverseOps()

        test64_bitfieldReverse()
        test64_bitfieldReverseLoop()
        test64_bitfieldReverseUint64()
        test64_bitfieldReverseOps()
    }
}