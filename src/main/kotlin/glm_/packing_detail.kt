package glm_

import glm_.vec2.Vec2
import glm_.vec3.Vec3
import glm_.vec4.Vec4
import glm_.vec4.Vec4i
import unsigned.toUInt
import unsigned.toUShort
import unsigned.ushr
import java.math.BigInteger
import kotlin.experimental.or
import glm_.glm.isNan
import glm_.glm.isInf
import glm_.glm.floatBitsToInt
import glm_.glm.intBitsToFloat
import glm_.glm.clamp
import glm_.glm.round
import glm_.glm.pow
import glm_.glm.max
import glm_.glm.detail
import glm_.glm.floor
import glm_.glm.log2

interface packing_detail {

    fun float2half(f: Int): Short {
        /*  10 bits    =>                         EE EEEFFFFF
            11 bits    =>                        EEE EEFFFFFF
            Half bits  =>                   SEEEEEFF FFFFFFFF
            Float bits => SEEEEEEE EFFFFFFF FFFFFFFF FFFFFFFF

            0x00007c00 => 00000000 00000000 01111100 00000000
            0x000003ff => 00000000 00000000 00000011 11111111
            0x38000000 => 00111000 00000000 00000000 00000000
            0x7f800000 => 01111111 10000000 00000000 00000000
            0x00008000 => 00000000 00000000 10000000 00000000   */
        val sign = (f ushr 16) and 0x8000
        val exponential = (((f and 0x7f800000) - 0x38000000) ushr 13) and 0x7c00
        val mantissa = (f ushr 13) and 0x03ff
        return (sign or exponential or mantissa).s
    }

    fun float2packed11(f: Int): Int {
        /*  10 bits    =>                         EE EEEFFFFF
            11 bits    =>                        EEE EEFFFFFF
            Half bits  =>                   SEEEEEFF FFFFFFFF
            Float bits => SEEEEEEE EFFFFFFF FFFFFFFF FFFFFFFF

            0x000007c0 => 00000000 00000000 00000111 11000000
            0x00007c00 => 00000000 00000000 01111100 00000000
            0x000003ff => 00000000 00000000 00000011 11111111
            0x38000000 => 00111000 00000000 00000000 00000000
            0x7f800000 => 01111111 10000000 00000000 00000000
            0x00008000 => 00000000 00000000 10000000 00000000   */
        val exponential = (((f and 0x7f800000) - 0x38000000) ushr 17) and 0x07c0
        val mantissa = (f ushr 17) and 0x003f
        return exponential or mantissa
    }

    fun packed11ToFloat(p: Int): Int {
        /*  10 bits    =>                         EE EEEFFFFF
            11 bits    =>                        EEE EEFFFFFF
            Half bits  =>                   SEEEEEFF FFFFFFFF
            Float bits => SEEEEEEE EFFFFFFF FFFFFFFF FFFFFFFF

            0x000007c0 => 00000000 00000000 00000111 11000000
            0x00007c00 => 00000000 00000000 01111100 00000000
            0x000003ff => 00000000 00000000 00000011 11111111
            0x38000000 => 00111000 00000000 00000000 00000000
            0x7f800000 => 01111111 10000000 00000000 00000000
            0x00008000 => 00000000 00000000 10000000 00000000   */
        val exponential = (((p and 0x07c0) shl 17) + 0x38000000) and 0x7f800000
        val mantissa = (p and 0x003f) shl 17
        return exponential or mantissa
    }

    fun float2packed10(f: Int): Int {
        /*  10 bits    =>                         EE EEEFFFFF
            11 bits    =>                        EEE EEFFFFFF
            Half bits  =>                   SEEEEEFF FFFFFFFF
            Float bits => SEEEEEEE EFFFFFFF FFFFFFFF FFFFFFFF

            0x0000001F => 00000000 00000000 00000000 00011111
            0x0000003F => 00000000 00000000 00000000 00111111
            0x000003E0 => 00000000 00000000 00000011 11100000
            0x000007C0 => 00000000 00000000 00000111 11000000
            0x00007C00 => 00000000 00000000 01111100 00000000
            0x000003FF => 00000000 00000000 00000011 11111111
            0x38000000 => 00111000 00000000 00000000 00000000
            0x7f800000 => 01111111 10000000 00000000 00000000
            0x00008000 => 00000000 00000000 10000000 00000000   */
        val exponential = (((f and 0x7f800000) - 0x38000000) ushr 18) and 0x03E0
        val mantissa = (f ushr 18) and 0x001f
        return exponential or mantissa
    }

    fun packed10ToFloat(p: Int): Int {
        /*  10 bits    =>                         EE EEEFFFFF
            11 bits    =>                        EEE EEFFFFFF
            Half bits  =>                   SEEEEEFF FFFFFFFF
            Float bits => SEEEEEEE EFFFFFFF FFFFFFFF FFFFFFFF

            0x0000001F => 00000000 00000000 00000000 00011111
            0x0000003F => 00000000 00000000 00000000 00111111
            0x000003E0 => 00000000 00000000 00000011 11100000
            0x000007C0 => 00000000 00000000 00000111 11000000
            0x00007C00 => 00000000 00000000 01111100 00000000
            0x000003FF => 00000000 00000000 00000011 11111111
            0x38000000 => 00111000 00000000 00000000 00000000
            0x7f800000 => 01111111 10000000 00000000 00000000
            0x00008000 => 00000000 00000000 10000000 00000000   */
        val exponential = (((p and 0x03E0) shl 18) + 0x38000000) and 0x7f800000
        val mantissa = (p and 0x001f) shl 18
        return exponential or mantissa
    }

    fun half2float(h: Int) = ((h and 0x8000) shl 16) or (((h and 0x7c00) + 0x1C000) shl 13) or ((h and 0x03FF) shl 13)

    fun floatTo11bit(x: Float): Int {

        if (x == 0f)
            return 0
        else if (isNan(x))
            return 0.inv()
        else if (isInf(x))
            return 0x1F shl 6

        val pack = floatBitsToInt(x)
        return float2packed11(pack)
    }

    fun packed11bitToFloat(x: Int): Float {

        if (x == 0)
            return 0f
        else if (x == ((1 shl 11) - 1))
            return 0.inv().f  //NaN
        else if (x == (0x1f shl 6))
            return 0.inv().f   //Inf

        val result = packed11ToFloat(x)

        return intBitsToFloat(result)
    }

    fun floatTo10bit(x: Float): Int {

        if (x == 0f)
            return 0
        else if (isNan(x))
            return 0.inv()
        else if (isInf(x))
            return 0x1F shl 5

        val pack = floatBitsToInt(x)
        return float2packed10(pack)
    }

    fun packed10bitToFloat(x: Int): Float {

        if (x == 0)
            return 0f
        else if (x == ((1 shl 10) - 1))
            return 0.inv().f    //NaN
        else if (x == (0x1f shl 5))
            return 0.inv().f   //Inf

        val result = packed10ToFloat(x)

        return intBitsToFloat(result)
    }
}

interface packing {

    fun packUnorm1x8(v: Float) = round(clamp(v, 0f, 1f) * 255f).b

    fun unpackUnorm1x8(p: Byte) = p.toUInt().f * 0.0039215686274509803921568627451f // 1 / 255

    fun packUnorm2x8(v: Vec2): Short {
        val x = round(clamp(v.x, 0f, 1f) * 255f)
        val y = round(clamp(v.y, 0f, 1f) * 255f)
        return (x.s shl 8) or y.s
    }

    fun unpackUnorm2x8(p: Short, res: Vec2 = Vec2()): Vec2 {
        res.x = (p ushr 8).b.f
        res.y = p.b.f
        return res times_ 0.0039215686274509803921568627451f // 1 / 255
    }

    fun packSnorm1x8(v: Float) = round(clamp(v, -1f, 1f) * 127f).b

    fun unpackSnorm1x8(p: Byte) = clamp(p.f * 0.00787401574803149606299212598425f, // 1f / 127f
            -1f, 1f)

    fun packSnorm2x8(v: Vec2): Short {
        val x = round(clamp(v.x, -1f, 1f) * 127f)
        val y = round(clamp(v.y, -1f, 1f) * 127f)
        return (x.s shl 8) or y.s
    }

    fun unpackSnorm2x8(p: Short, res: Vec2 = Vec2()): Vec2 {
        res.x = clamp((p ushr 8).b.f * 0.00787401574803149606299212598425f, // 1.0f / 127.0f
                -1f, 1f)
        res.y = clamp(p.b.f * 0.00787401574803149606299212598425f, // 1.0f / 127.0f
                -1f, 1f)
        return res
    }

    fun packUnorm1x16(s: Float) = round(clamp(s, 0f, 1f) * 65535f).s

    fun unpackUnorm1x16(p: Short) = p.f * 1.5259021896696421759365224689097e-5f // 1.0 / 65535.0

    fun packUnorm4x16(v: Vec4): Long {
        val x = round(clamp(v.x, 0f, 1f) * 65535f)
        val y = round(clamp(v.y, 0f, 1f) * 65535f)
        val z = round(clamp(v.z, 0f, 1f) * 65535f)
        val w = round(clamp(v.w, 0f, 1f) * 65535f)
        val a = x.L shl 48
        val b = y.L shl 32
        val c = z.L shl 16
        val d = w.L
        return (a and "0xffff000000000000".L) or (b and 0xffff00000000) or (c and 0xffff0000) or (d and 0xffff)
    }

    fun unpackUnorm4x16(p: Long, res: Vec4 = Vec4()): Vec4 {
        res.x = (p ushr 48).s.f * 1.5259021896696421759365224689097e-5f // 1.0 / 65535.0
        res.y = ((p ushr 32) and 0xffff).s.f * 1.5259021896696421759365224689097e-5f // 1.0 / 65535.0
        res.z = ((p ushr 16) and 0xffff).s.f * 1.5259021896696421759365224689097e-5f // 1.0 / 65535.0
        res.w = (p and 0xffff).s.f * 1.5259021896696421759365224689097e-5f // 1.0 / 65535.0
        return res
    }

    fun packSnorm1x16(v: Float) = round(clamp(v, -1f, 1f) * 32767f).s

    fun unpackSnorm1x16(p: Short) = clamp(p.f * 3.0518509475997192297128208258309e-5f, //1.0f / 32767.0f,
            -1f, 1f)

    fun packSnorm4x16(v: Vec4): Long {
        val x = round(clamp(v.x, -1f, 1f) * 32767f).s
        val y = round(clamp(v.y, -1f, 1f) * 32767f).s
        val z = round(clamp(v.z, -1f, 1f) * 32767f).s
        val w = round(clamp(v.w, -1f, 1f) * 32767f).s
        val a = x.L shl 48
        val b = y.L shl 32
        val c = z.L shl 16
        val d = w.L
        return (a and "0xffff000000000000".L) or (b and 0xffff00000000) or (c and 0xffff0000) or (d and 0xffff)
    }

    fun unpackSnorm4x16(p: Long, res: Vec4 = Vec4()): Vec4 {
        val x = (p ushr 48).s
        val y = ((p ushr 32) and 0xffff).s
        val z = ((p ushr 16) and 0xffff).s
        val w = (p and 0xffff).s
        res.x = clamp(x * 3.0518509475997192297128208258309e-5f, //1.0f / 32767.0f,
                -1f, 1f)
        res.y = clamp(y * 3.0518509475997192297128208258309e-5f, //1.0f / 32767.0f,
                -1f, 1f)
        res.z = clamp(z * 3.0518509475997192297128208258309e-5f, //1.0f / 32767.0f,
                -1f, 1f)
        res.w = clamp(w * 3.0518509475997192297128208258309e-5f, //1.0f / 32767.0f,
                -1f, 1f)
        return res
    }

    fun packHalf1x16(v: Float) = detail.toFloat16(v)

    fun unpackHalf1x16(v: Short) = detail.toFloat32(v)

    fun packHalf4x16(v: Vec4): Long {
        val x = detail.toFloat16(v.x)
        val y = detail.toFloat16(v.y)
        val z = detail.toFloat16(v.z)
        val w = detail.toFloat16(v.w)
        return (x.L shl 48) or (y.L shl 32) or (z.L shl 16) or w.L
    }

    fun unpackHalf4x16(v: Long, res: Vec4 = Vec4()): Vec4 {
        val x = (v ushr 48).s
        val y = ((v ushr 32) and 0xffff).s
        val z = ((v ushr 16) and 0xffff).s
        val w = (v and 0xffff).s
        res.x = detail.toFloat32(x)
        res.y = detail.toFloat32(y)
        res.z = detail.toFloat32(z)
        res.w = detail.toFloat32(w)
        return res
    }

    fun packI3x10_1x2(v: Vec4i): Int {
        val x = v.x shl 22
        val y = (v.y and 0b11_1111_1111) shl 12
        val z = (v.z and 0b11_1111_1111) shl 2
        val w = v.w and 0b11
        return x or y or z or w
    }

    fun unpackI3x10_1x2(v: Int, res: Vec4i = Vec4i()): Vec4i {
        res.x = v ushr 22
        res.y = (v ushr 12) and 0b11_1111_1111
        res.z = (v ushr 2) and 0b11_1111_1111
        res.w = v and 0b11
        return res
    }

    fun packU3x10_1x2(v: Vec4i): Int {
        val x = v.x shl 22
        val y = (v.y and 0b11_1111_1111) shl 12
        val z = (v.z and 0b11_1111_1111) shl 2
        val w = v.w and 0b11
        return x or y or z or w
    }

    fun unpackU3x10_1x2(v: Int, res: Vec4i = Vec4i()): Vec4i {
        res.x = v ushr 22
        res.y = (v ushr 12) and 0b11_1111_1111
        res.z = (v ushr 2) and 0b11_1111_1111
        res.w = v and 0b11
        return res
    }

    fun packSnorm3x10_1x2(v: Vec4): Int {
        val x = round(clamp(v.x, -1f, 1f) * 511f).i
        val y = round(clamp(v.y, -1f, 1f) * 511f).i
        val z = round(clamp(v.z, -1f, 1f) * 511f).i
        val w = round(clamp(v.w, -1f, 1f)).i
        val a = x shl 22
        val b = (y and 0b11_1111_1111) shl 12
        val c = (z and 0b11_1111_1111) shl 2
        val d = w and 0b11
        return a or b or c or d
    }

    fun unpackSnorm3x10_1x2(v: Int, res: Vec4 = Vec4()): Vec4 {
        res.x = (v ushr 22).f
        res.y = ((v ushr 12) and 0b11_1111_1111).f
        res.z = ((v ushr 2) and 0b11_1111_1111).f
        res.z = (v and 0b11).f
        val tmp = 1f / 511f
        res.x = clamp(res.x * tmp, -1f, 1f)
        res.y = clamp(res.y * tmp, -1f, 1f)
        res.z = clamp(res.z * tmp, -1f, 1f)
        res.w = clamp(res.w * tmp, -1f, 1f)
        return res
    }

    fun packUnorm3x10_1x2(v: Vec4): Int {
        val x = round(clamp(v.x, 0f, 1f) * 1023f).i
        val y = round(clamp(v.y, 0f, 1f) * 1023f).i
        val z = round(clamp(v.z, 0f, 1f) * 1023f).i
        val w = round(clamp(v.w, 0f, 1f) * 3f).i
        val a = x shl 22
        val b = (y and 0b11_1111_1111) shl 12
        val c = (z and 0b11_1111_1111) shl 2
        val d = w and 0b11
        return a or b or c or d
    }

    fun unpackUnorm3x10_1x2(v: Int, res: Vec4 = Vec4()): Vec4 {
        val a = 1f / 1023f
        res.x = (v ushr 22) * a
        res.y = ((v ushr 12) and 0b11_1111_1111) * a
        res.z = ((v ushr 2) and 0b11_1111_1111) * a
        res.w = (v and 0b11) * 1f / 3f
        return res
    }

    fun packF2x11_1x10(v: Vec3) = ((detail.floatTo11bit(v.x) and ((1 shl 11) - 1)) shl 22) or
            ((detail.floatTo11bit(v.y) and ((1 shl 11) - 1)) shl 11) or
            ((detail.floatTo10bit(v.z) and ((1 shl 10) - 1)) shl 0)

    fun unpackF2x11_1x10(v: Int, res: Vec3 = Vec3()): Vec3 {
        res.x = detail.packed11bitToFloat(v ushr 22)
        res.y = detail.packed11bitToFloat(v ushr 11)
        res.z = detail.packed10bitToFloat(v ushr 0)
        return res
    }

    fun packF3x9_E1x5(v: Vec3): Int {
        val sharedExpMax = (pow(2f, 9f - 1f) / pow(2f, 9f)) * pow(2f, 31f - 15f)
        val colorX = clamp(v.x, 0f, sharedExpMax)
        val colorY = clamp(v.y, 0f, sharedExpMax)
        val colorZ = clamp(v.z, 0f, sharedExpMax)
        val maxColor = max(colorX, max(colorY, colorZ))

        val expSharedP = max(-15f - 1f, floor(log2(maxColor))) + 1f + 15f
        val maxShared = floor(maxColor / pow(2f, (expSharedP - 15f - 9f)) + 0.5f)
        val expShared = if (maxShared == pow(2f, 9f)) expSharedP + 1f else expSharedP

        val x = floor(colorX / pow(2f, (expShared - 15f - 9f)) + 0.5f).i
        val y = floor(colorY / pow(2f, (expShared - 15f - 9f)) + 0.5f).i
        val z = floor(colorZ / pow(2f, (expShared - 15f - 9f)) + 0.5f).i

        val a = x shl 23
        val b = (y and 0b1_1111_1111) shl 23
        val c = (z and 0b1_1111_1111) shl 23
        val d = expShared.i
        return a or b or c or d
    }

    fun unpackF3x9_E1x5(v: Int, res: Vec3 = Vec3()): Vec3 {

        val pow = pow(2f, (v and 0b1_1111).f - 15f - 9f)
        res.x = (v ushr 23).f * pow
        res.y = ((v ushr 14) and 0b1_1111_1111).f * pow
        res.z = ((v ushr 5) and 0b1_1111_1111).f * pow

        return res
    }
}