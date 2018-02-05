package glm_.func

import glm_.*
import unsigned.toULong

/**
 * Created by GBarbieri on 06.04.2017.
 */

interface funcInteger {

    //
//    // uaddCarry
//    GLM_FUNC_QUALIFIER uint uaddCarry(uint const& x, uint const& y, uint & Carry)
//    {
//        uint64 const Value64(static_cast<uint64>(x) + static_cast<uint64>(y));
//        uint64 const Max32((static_cast<uint64>(1) << static_cast<uint64>(32)) - static_cast<uint64>(1));
//        Carry = Value64 > Max32 ? 1u : 0u;
//        return static_cast<uint32>(Value64 % (Max32 + static_cast<uint64>(1)));
//    }
//
//    template<length_t L, qualifier Q>
//    GLM_FUNC_QUALIFIER vec<L, uint, Q> uaddCarry(vec<L, uint, Q> const& x, vec<L, uint, Q> const& y, vec<L, uint, Q>& Carry)
//    {
//        vec<L, uint64, Q> Value64(vec<L, uint64, Q>(x) + vec<L, uint64, Q>(y));
//        vec<L, uint64, Q> Max32((static_cast<uint64>(1) << static_cast<uint64>(32)) - static_cast<uint64>(1));
//        Carry = mix(vec<L, uint32, Q>(0), vec<L, uint32, Q>(1), greaterThan(Value64, Max32));
//        return vec<L, uint32, Q>(Value64 % (Max32 + static_cast<uint64>(1)));
//    }
//
//    // usubBorrow
//    GLM_FUNC_QUALIFIER uint usubBorrow(uint const& x, uint const& y, uint & Borrow)
//    {
//        GLM_STATIC_ASSERT(sizeof(uint) == sizeof(uint32), "uint and uint32 size mismatch");
//
//        Borrow = x >= y ? static_cast<uint32>(0) : static_cast<uint32>(1);
//        if(y >= x)
//            return y - x;
//        else
//            return static_cast<uint32>((static_cast<int64>(1) << static_cast<int64>(32)) + (static_cast<int64>(y) - static_cast<int64>(x)));
//    }
//
//    template<length_t L, qualifier Q>
//    GLM_FUNC_QUALIFIER vec<L, uint, Q> usubBorrow(vec<L, uint, Q> const& x, vec<L, uint, Q> const& y, vec<L, uint, Q>& Borrow)
//    {
//        Borrow = mix(vec<L, uint, Q>(1), vec<L, uint, Q>(0), greaterThanEqual(x, y));
//        vec<L, uint, Q> const YgeX(y - x);
//        vec<L, uint, Q> const XgeY(vec<L, uint32, Q>((static_cast<int64>(1) << static_cast<int64>(32)) + (vec<L, int64, Q>(y) - vec<L, int64, Q>(x))));
//        return mix(XgeY, YgeX, greaterThanEqual(y, x));
//    }
//
//    // umulExtended
//    GLM_FUNC_QUALIFIER void umulExtended(uint const& x, uint const& y, uint & msb, uint & lsb)
//    {
//        GLM_STATIC_ASSERT(sizeof(uint) == sizeof(uint32), "uint and uint32 size mismatch");
//
//        uint64 Value64 = static_cast<uint64>(x) * static_cast<uint64>(y);
//        msb = static_cast<uint>(Value64 >> static_cast<uint64>(32));
//        lsb = static_cast<uint>(Value64);
//    }
//
//    template<length_t L, qualifier Q>
//    GLM_FUNC_QUALIFIER void umulExtended(vec<L, uint, Q> const& x, vec<L, uint, Q> const& y, vec<L, uint, Q>& msb, vec<L, uint, Q>& lsb)
//    {
//        GLM_STATIC_ASSERT(sizeof(uint) == sizeof(uint32), "uint and uint32 size mismatch");
//
//        vec<L, uint64, Q> Value64(vec<L, uint64, Q>(x) * vec<L, uint64, Q>(y));
//        msb = vec<L, uint32, Q>(Value64 >> static_cast<uint64>(32));
//        lsb = vec<L, uint32, Q>(Value64);
//    }
//
//    // imulExtended
//    GLM_FUNC_QUALIFIER void imulExtended(int x, int y, int& msb, int& lsb)
//    {
//        GLM_STATIC_ASSERT(sizeof(int) == sizeof(int32), "int and int32 size mismatch");
//
//        int64 Value64 = static_cast<int64>(x) * static_cast<int64>(y);
//        msb = static_cast<int>(Value64 >> static_cast<int64>(32));
//        lsb = static_cast<int>(Value64);
//    }
//
//    template<length_t L, qualifier Q>
//    GLM_FUNC_QUALIFIER void imulExtended(vec<L, int, Q> const& x, vec<L, int, Q> const& y, vec<L, int, Q>& msb, vec<L, int, Q>& lsb)
//    {
//        GLM_STATIC_ASSERT(sizeof(int) == sizeof(int32), "int and int32 size mismatch");
//
//        vec<L, int64, Q> Value64(vec<L, int64, Q>(x) * vec<L, int64, Q>(y));
//        lsb = vec<L, int32, Q>(Value64 & static_cast<int64>(0xFFFFFFFF));
//        msb = vec<L, int32, Q>((Value64 >> static_cast<int64>(32)) & static_cast<int64>(0xFFFFFFFF));
//    }
//
    // bitfieldExtract
    fun bitfieldExtract(value: uint, offset: Int, bits: Int): uint = (value ushr offset) and glm.detail.mask(bits)

    //    template<length_t L, typename T, qualifier Q>
//    GLM_FUNC_QUALIFIER vec<L, T, Q> bitfieldExtract(vec<L, T, Q> const& Value, int Offset, int Bits)
//    {
//        GLM_STATIC_ASSERT(std::numeric_limits<T>::is_integer, "'bitfieldExtract' only accept integer inputs");
//
//        return (Value >> static_cast<T>(Offset)) & static_cast<T>(detail::mask(Bits));
//    }
//
    // bitfieldInsert
    fun bitfieldInsert(base: uint, insert: uint, offset: Int, bits: Int): uint {
        val mask = glm.detail.mask(bits) shl offset
        return (base and mask.inv()) or (insert and mask)
    }

    //    template<length_t L, typename T, qualifier Q>
//    GLM_FUNC_QUALIFIER vec<L, T, Q> bitfieldInsert(vec<L, T, Q> const& Base, vec<L, T, Q> const& Insert, int Offset, int Bits)
//    {
//        GLM_STATIC_ASSERT(std::numeric_limits<T>::is_integer, "'bitfieldInsert' only accept integer values");
//
//        T const Mask = static_cast<T>(detail::mask(Bits) << Offset);
//        return (Base & ~Mask) | (Insert & Mask);
//    }
//
    // bitfieldReverse
    fun bitfieldReverse(v: uint): uint {
        var x = glm.detail.compute_bitfieldReverseStep(v, 0x5555555555555555, 1)
        x = glm.detail.compute_bitfieldReverseStep(x, 0x3333333333333333, 2)
        x = glm.detail.compute_bitfieldReverseStep(x, 0x0F0F0F0F0F0F0F0F, 4)
        x = glm.detail.compute_bitfieldReverseStep(x, 0x00FF00FF00FF00FF, 8)
        return glm.detail.compute_bitfieldReverseStep(x, 0x0000FFFF0000FFFF, 16)
    }

    fun bitfieldReverse(v: ulong): ulong {
        var x = glm.detail.compute_bitfieldReverseStep(v, 0x5555555555555555, 1)
        x = glm.detail.compute_bitfieldReverseStep(x, 0x3333333333333333, 2)
        x = glm.detail.compute_bitfieldReverseStep(x, 0x0F0F0F0F0F0F0F0F, 4)
        x = glm.detail.compute_bitfieldReverseStep(x, 0x00FF00FF00FF00FF, 8)
        x = glm.detail.compute_bitfieldReverseStep(x, 0x0000FFFF0000FFFF, 16)
        return glm.detail.compute_bitfieldReverseStep(x, 0x00000000FFFFFFFF, 32)
    }

    //    fun bitCount(byte: Byte) = byte.bitCount(byte.i)
//    fun bitCount(short: Short) = java.lang.Integer.bitCount(short.i)
    fun bitCount(int: Int) = int.bitCount

    fun bitCount(long: Long) = long.bitCount
}

interface detail_integer {

    fun mask(bits: Int) = if (bits >= Int.BYTES * 8) 0.inv() else (1 shl bits) - 1

    fun compute_bitfieldReverseStep(v: uint, mask: ulong, shift: uint): uint {
        val vL = v.toULong()
        return (((vL and mask) shl shift) or ((vL and mask.inv()) ushr shift)).i
    }

    fun compute_bitfieldReverseStep(v: ulong, mask: ulong, shift: uint): ulong  = ((v and mask) shl shift) or ((v and mask.inv()) ushr shift)
}