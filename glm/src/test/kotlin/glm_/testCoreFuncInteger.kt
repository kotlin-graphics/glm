package glm_

import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec
import unsigned.toULong
import glm_.testCoreFuncInteger.Result.*

class testCoreFuncInteger : StringSpec() {

    enum class Result { SUCCESS, FAIL, ASSERT, STATIC_ASSERT }

    init {

        "bitfield insert" {

            class Type(val base: uint, val insert: uint, val offset: Int, val bits: Int, val return_: uint)

            val data32 = arrayOf(
                    Type(0x00000000, 0xffffffff.i, 0, 32, 0xffffffff.i),
                    Type(0x00000000, 0xffffffff.i, 0, 31, 0x7fffffff),
                    Type(0x00000000, 0xffffffff.i, 0, 0, 0x00000000),
                    Type(0xff000000.i, 0x0000ff00, 8, 8, 0xff00ff00.i),
                    Type(0xffff0000.i, 0x0000ffff, 16, 16, 0x00000000),
                    Type(0x0000ffff, 0xffff0000.i, 16, 16, 0xffffffff.i))

            for (d in data32) {

                val return_ = glm.bitfieldInsert(d.base, d.insert, d.offset, d.bits)

                d.return_ shouldBe return_
            }
        }

        "bitfield extract" {

            class Type(val value: uint, val offset: Int, val bits: uint, val return_: uint, val result: Result)

            val data32 = arrayOf(
                    Type(0xffffffff.i, 0, 32, 0xffffffff.i, SUCCESS),
                    Type(0xffffffff.i, 8, 0, 0x00000000, SUCCESS),
                    Type(0x00000000, 0, 32, 0x00000000, SUCCESS),
                    Type(0x0f0f0f0f, 0, 32, 0x0f0f0f0f, SUCCESS),
                    Type(0x00000000, 8, 0, 0x00000000, SUCCESS),
                    Type(0x80000000.i, 31, 1, 0x00000001, SUCCESS),
                    Type(0x7fffffff, 31, 1, 0x00000000, SUCCESS),
                    Type(0x00000300, 8, 8, 0x00000003, SUCCESS),
                    Type(0x0000ff00, 8, 8, 0x000000ff, SUCCESS),
                    Type(0xfffffff0.i, 0, 5, 0x00000010, SUCCESS),
                    Type(0x000000ff, 1, 3, 0x00000007, SUCCESS),
                    Type(0x000000ff, 0, 3, 0x00000007, SUCCESS),
                    Type(0x00000000, 0, 2, 0x00000000, SUCCESS),
                    Type(0xffffffff.i, 0, 8, 0x000000ff, SUCCESS),
                    Type(0xffff0000.i, 16, 16, 0x0000ffff, SUCCESS),
                    Type(0xfffffff0.i, 0, 8, 0x00000000, FAIL),
                    Type(0xffffffff.i, 16, 16, 0x00000000, FAIL)
                    //Type(0xffffffff,32, 1, 0x00000000, ASSERT), // Throw an assert
                    //Type(0xffffffff, 0,33, 0x00000000, ASSERT), // Throw an assert
                    //Type(0xffffffff,16,16, 0x00000000, ASSERT), // Throw an assert
            )

            for (d in data32) {

                val return_ = glm.bitfieldExtract(d.value, d.offset, d.bits)

                val compare = d.return_ == return_

                if (d.result == SUCCESS && compare) continue
                else if (d.result == FAIL && !compare) continue
            }
        }

        // bitfield reverse
        run {

            class Type(val value: uint, val return_: uint, val result: Result)

            val data32 = arrayOf(
                    Type(0x00000001, 0x80000000.i, SUCCESS),
                    Type(0x0000000f, 0xf0000000.i, SUCCESS),
                    Type(0x000000ff, 0xff000000.i, SUCCESS),
                    Type(0xf0000000.i, 0x0000000f, SUCCESS),
                    Type(0xff000000.i, 0x000000ff, SUCCESS),
                    Type(0xffffffff.i, 0xffffffff.i, SUCCESS),
                    Type(0x00000000, 0x00000000, SUCCESS))

            "uint bitfield reverse" {

                for (d in data32) {

                    val return_ = glm.bitfieldReverse(d.value)

                    val compare = d.return_ == return_

                    compare shouldBe (d.result == SUCCESS)
                }
            }

            "uint bitfield reverse loop" {

                fun bitfieldReverseLoop(v: uint): uint {

                    var result = 0
                    val bitSize = Int.BYTES * 8
                    for (i in 0 until bitSize) {
                        val bitSet = v and (1 shl i)
                        val bitFirst = bitSet ushr i
                        result = result or (bitFirst shl (bitSize - 1 - i))
                    }
                    return result
                }

                for (d in data32) {

                    val return_ = bitfieldReverseLoop(d.value)

                    val compare = d.return_ == return_

                    compare shouldBe (d.result == SUCCESS)
                }
            }

            "uint bitfield reverse uint" {

                fun bitfieldReverseUint32(x_: uint): uint {
                    var x = ((x_ and 0x55555555) shl 1) or ((x_ and 0xAAAAAAAA.i) ushr 1)
                    x = ((x and 0x33333333) shl 2) or ((x and 0xCCCCCCCC.i) ushr 2)
                    x = ((x and 0x0F0F0F0F) shl 4) or ((x and 0xF0F0F0F0.i) ushr 4)
                    x = ((x and 0x00FF00FF) shl 8) or ((x and 0xFF00FF00.i) ushr 8)
                    return ((x and 0x0000FFFF) shl 16) or ((x and 0xFFFF0000.i) ushr 16)
                }

                for (d in data32) {

                    val return_ = bitfieldReverseUint32(d.value)

                    val compare = d.return_ == return_

                    compare shouldBe (d.result == SUCCESS)
                }
            }

            "uint bitfield reverse ops" {

                fun compute_bitfieldReverseStep(v: uint, mask: ulong, shift: uint): uint {
                    val vL = v.toULong()
                    return (((vL and mask) shl shift) or ((vL and mask.inv()) ushr shift)).i
                }

                fun bitfieldReverseOps(v: uint): uint {
                    var x = compute_bitfieldReverseStep(v, 0x5555555555555555, 1)
                    x = compute_bitfieldReverseStep(x, 0x3333333333333333, 2)
                    x = compute_bitfieldReverseStep(x, 0x0F0F0F0F0F0F0F0F, 4)
                    x = compute_bitfieldReverseStep(x, 0x00FF00FF00FF00FF, 8)
                    return compute_bitfieldReverseStep(x, 0x0000FFFF0000FFFF, 16)
                }

                for (d in data32) {

                    val return_ = bitfieldReverseOps(d.value)

                    val compare = d.return_ == return_

                    compare shouldBe (d.result == SUCCESS)
                }
            }

            class Type_(val value: ulong, val return_: ulong, val result: Result)

            val data64 = arrayOf(
                    Type_(0x00000000000000ff, "ff00000000000000".parseUnsignedLong(16), SUCCESS),
                    Type_(0x000000000000000f, "f000000000000000".parseUnsignedLong(16), SUCCESS),
                    Type_("f000000000000000".parseUnsignedLong(16), 0x000000000000000f, SUCCESS),
                    Type_("ffffffffffffffff".parseUnsignedLong(16), "ffffffffffffffff".parseUnsignedLong(16), SUCCESS),
                    Type_(0x0000000000000000, 0x0000000000000000, SUCCESS))

            "ulong bitfield reverse" {

                for (d in data64) {

                    val return_ = glm.bitfieldReverse(d.value)
                    val compare = d.return_ == return_

                    compare shouldBe (d.result == SUCCESS)
                }
            }

            "ulong bitfield reverse loop" {

                fun bitfieldReverseLoop(v: ulong): ulong {

                    var result = 0L
                    val bitSize = Long.BYTES * 8
                    for (i in 0 until bitSize) {
                        val bitSet = v and (1L shl i)
                        val bitFirst = bitSet ushr i
                        result = result or (bitFirst shl (bitSize - 1 - i))
                    }
                    return result
                }

                for (d in data64) {

                    val return_ = bitfieldReverseLoop(d.value)

                    val compare = d.return_ == return_

                    compare shouldBe (d.result == SUCCESS)
                }
            }

            "ulong bitfield reverse ulong" {

                fun bitfieldReverseUlong64(x_: ulong): ulong {
                    var x = ((x_ and 0x5555555555555555) shl 1) or ((x_ and "AAAAAAAAAAAAAAAA".parseUnsignedLong(16)) ushr 1)
                    x = ((x and 0x3333333333333333) shl 2) or ((x and "CCCCCCCCCCCCCCCC".parseUnsignedLong(16)) ushr 2)
                    x = ((x and 0x0F0F0F0F0F0F0F0F) shl 4) or ((x and "F0F0F0F0F0F0F0F0".parseUnsignedLong(16)) ushr 4)
                    x = ((x and 0x00FF00FF00FF00FF) shl 8) or ((x and "FF00FF00FF00FF00".parseUnsignedLong(16)) ushr 8)
                    x = ((x and 0x0000FFFF0000FFFF) shl 16) or ((x and "FFFF0000FFFF0000".parseUnsignedLong(16)) ushr 16)
                    return ((x and 0x00000000FFFFFFFF) shl 32) or ((x and "FFFFFFFF00000000".parseUnsignedLong(16)) ushr 32)
                }

                for (d in data64) {

                    val return_ = bitfieldReverseUlong64(d.value)

                    val compare = d.return_ == return_

                    compare shouldBe (d.result == SUCCESS)
                }
            }

            "ulong bitfield reverse ops" {

                fun compute_bitfieldReverseStep(v: ulong, mask: ulong, shift: uint): ulong = ((v and mask) shl shift) or ((v and mask.inv()) ushr shift)

                fun bitfieldReverseOps(v: ulong): ulong {
                    var x = compute_bitfieldReverseStep(v, 0x5555555555555555, 1)
                    x = compute_bitfieldReverseStep(x, 0x3333333333333333, 2)
                    x = compute_bitfieldReverseStep(x, 0x0F0F0F0F0F0F0F0F, 4)
                    x = compute_bitfieldReverseStep(x, 0x00FF00FF00FF00FF, 8)
                    x = compute_bitfieldReverseStep(x, 0x0000FFFF0000FFFF, 16)
                    return compute_bitfieldReverseStep(x, 0x00000000FFFFFFFF, 32)
                }

                for (d in data64) {

                    val return_ = bitfieldReverseOps(d.value)

                    val compare = d.return_ == return_

                    compare shouldBe (d.result == SUCCESS)
                }
            }

            "most significant bit" {

                val data = arrayOf(
                        Pair(0x00000000, -1),
                        Pair(0x00000001, 0),
                        Pair(0x00000002, 1),
                        Pair(0x00000003, 1),
                        Pair(0x00000004, 2),
                        Pair(0x00000005, 2),
                        Pair(0x00000007, 2),
                        Pair(0x00000008, 3),
                        Pair(0x00000010, 4),
                        Pair(0x00000020, 5),
                        Pair(0x00000040, 6),
                        Pair(0x00000080, 7),
                        Pair(0x00000100, 8),
                        Pair(0x00000200, 9),
                        Pair(0x00000400, 10),
                        Pair(0x00000800, 11),
                        Pair(0x00001000, 12),
                        Pair(0x00002000, 13),
                        Pair(0x00004000, 14),
                        Pair(0x00008000, 15),
                        Pair(0x00010000, 16),
                        Pair(0x00020000, 17),
                        Pair(0x00040000, 18),
                        Pair(0x00080000, 19),
                        Pair(0x00100000, 20),
                        Pair(0x00200000, 21),
                        Pair(0x00400000, 22),
                        Pair(0x00800000, 23),
                        Pair(0x01000000, 24),
                        Pair(0x02000000, 25),
                        Pair(0x04000000, 26),
                        Pair(0x08000000, 27),
                        Pair(0x10000000, 28),
                        Pair(0x20000000, 29),
                        Pair(0x40000000, 30))

                for (d in data)
                    d.first.msb shouldBe d.second
            }

            "last significant bit" {

                val data = arrayOf(
                        Pair(0x00000001, 0),
                        Pair(0x00000003, 0),
                        Pair(0x00000002, 1),
                        // Pair(0x80000000, 31), // Clang generates an error with this
                        Pair(0x00010000, 16),
                        Pair(0x7FFF0000, 16),
                        Pair(0x7F000000, 24),
                        Pair(0x7F00FF00, 8),
                        Pair(0x00000000, -1))

                for (d in data)
                    d.first.lsb shouldBe d.second
            }
        }
    }
}