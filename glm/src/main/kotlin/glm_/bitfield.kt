package glm_

import glm_.vec1.Vec1i
import glm_.vec2.Vec2i
import glm_.vec3.Vec3i
import glm_.vec4.Vec4i
import unsigned.toUInt
import unsigned.toULong
import unsigned.toUShort
import kotlin.experimental.or

interface bitfield {

    fun bitfieldInterleave(x: Byte, y: Byte): Short {

        var reg1 = x.toUShort()
        var reg2 = y.toUShort()

        reg1 = ((reg1 shl 4) or reg1) and 0x0F0F
        reg2 = ((reg2 shl 4) or reg2) and 0x0F0F

        reg1 = ((reg1 shl 2) or reg1) and 0x3333
        reg2 = ((reg2 shl 2) or reg2) and 0x3333

        reg1 = ((reg1 shl 1) or reg1) and 0x5555
        reg2 = ((reg2 shl 1) or reg2) and 0x5555

        return (reg1 or (reg2 shl 1))
    }

    fun bitfieldInterleave(x: Short, y: Short): Int {

        var reg1 = x.toUInt()
        var reg2 = y.toUInt()

        reg1 = ((reg1 shl 8) or reg1) and 0x00FF00FF
        reg2 = ((reg2 shl 8) or reg2) and 0x00FF00FF

        reg1 = ((reg1 shl 4) or reg1) and 0x0F0F0F0F
        reg2 = ((reg2 shl 4) or reg2) and 0x0F0F0F0F

        reg1 = ((reg1 shl 2) or reg1) and 0x33333333
        reg2 = ((reg2 shl 2) or reg2) and 0x33333333

        reg1 = ((reg1 shl 1) or reg1) and 0x55555555
        reg2 = ((reg2 shl 1) or reg2) and 0x55555555

        return reg1 or (reg2 shl 1)
    }

    fun bitfieldInterleave(x: Int, y: Int): Long {

        var reg1 = x.toULong()
        var reg2 = y.toULong()

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

    fun bitfieldInterleave(x: Byte, y: Byte, z: Byte): Int {

        var reg1 = x.toUInt()
        var reg2 = y.toUInt()
        var reg3 = z.toUInt()

        reg1 = ((reg1 shl 16) or reg1) and 0xFF0000FF.i
        reg2 = ((reg2 shl 16) or reg2) and 0xFF0000FF.i
        reg3 = ((reg3 shl 16) or reg3) and 0xFF0000FF.i

        reg1 = ((reg1 shl 8) or reg1) and 0x0F00F00F.i
        reg2 = ((reg2 shl 8) or reg2) and 0x0F00F00F.i
        reg3 = ((reg3 shl 8) or reg3) and 0x0F00F00F.i

        reg1 = ((reg1 shl 4) or reg1) and 0xC30C30C3.i
        reg2 = ((reg2 shl 4) or reg2) and 0xC30C30C3.i
        reg3 = ((reg3 shl 4) or reg3) and 0xC30C30C3.i

        reg1 = ((reg1 shl 2) or reg1) and 0x49249249.i
        reg2 = ((reg2 shl 2) or reg2) and 0x49249249.i
        reg3 = ((reg3 shl 2) or reg3) and 0x49249249.i

        return reg1 or (reg2 shl 1) or (reg3 shl 2)
    }

    fun bitfieldInterleave(x: Short, y: Short, z: Short): Long {

        var reg1 = x.toULong()
        var reg2 = y.toULong()
        var reg3 = z.toULong()

        reg1 = ((reg1 shl 32) or reg1) and "0xFFFF00000000FFFF".bi.L
        reg2 = ((reg2 shl 32) or reg2) and "0xFFFF00000000FFFF".bi.L
        reg3 = ((reg3 shl 32) or reg3) and "0xFFFF00000000FFFF".bi.L

        reg1 = ((reg1 shl 16) or reg1) and "0x00FF0000FF0000FF".L
        reg2 = ((reg2 shl 16) or reg2) and "0x00FF0000FF0000FF".L
        reg3 = ((reg3 shl 16) or reg3) and "0x00FF0000FF0000FF".L

        reg1 = ((reg1 shl 8) or reg1) and "0xF00F00F00F00F00F".bi.L
        reg2 = ((reg2 shl 8) or reg2) and "0xF00F00F00F00F00F".bi.L
        reg3 = ((reg3 shl 8) or reg3) and "0xF00F00F00F00F00F".bi.L

        reg1 = ((reg1 shl 4) or reg1) and "0x30C30C30C30C30C3".L
        reg2 = ((reg2 shl 4) or reg2) and "0x30C30C30C30C30C3".L
        reg3 = ((reg3 shl 4) or reg3) and "0x30C30C30C30C30C3".L

        reg1 = ((reg1 shl 2) or reg1) and "0x9249249249249249".bi.L
        reg2 = ((reg2 shl 2) or reg2) and "0x9249249249249249".bi.L
        reg3 = ((reg3 shl 2) or reg3) and "0x9249249249249249".bi.L

        return reg1 or (reg2 shl 1) or (reg3 shl 2)
    }

    fun bitfieldInterleave(x: Int, y: Int, z: Int): Long {

        var reg1 = x.toULong()
        var reg2 = y.toULong()
        var reg3 = z.toULong()

        reg1 = ((reg1 shl 32) or reg1) and "0xFFFF00000000FFFF".bi.L
        reg2 = ((reg2 shl 32) or reg2) and "0xFFFF00000000FFFF".bi.L
        reg3 = ((reg3 shl 32) or reg3) and "0xFFFF00000000FFFF".bi.L

        reg1 = ((reg1 shl 16) or reg1) and "0x00FF0000FF0000FF".L
        reg2 = ((reg2 shl 16) or reg2) and "0x00FF0000FF0000FF".L
        reg3 = ((reg3 shl 16) or reg3) and "0x00FF0000FF0000FF".L

        reg1 = ((reg1 shl 8) or reg1) and "0xF00F00F00F00F00F".bi.L
        reg2 = ((reg2 shl 8) or reg2) and "0xF00F00F00F00F00F".bi.L
        reg3 = ((reg3 shl 8) or reg3) and "0xF00F00F00F00F00F".bi.L

        reg1 = ((reg1 shl 4) or reg1) and "0x30C30C30C30C30C3".L
        reg2 = ((reg2 shl 4) or reg2) and "0x30C30C30C30C30C3".L
        reg3 = ((reg3 shl 4) or reg3) and "0x30C30C30C30C30C3".L

        reg1 = ((reg1 shl 2) or reg1) and "0x9249249249249249".bi.L
        reg2 = ((reg2 shl 2) or reg2) and "0x9249249249249249".bi.L
        reg3 = ((reg3 shl 2) or reg3) and "0x9249249249249249".bi.L

        return reg1 or (reg2 shl 1) or (reg3 shl 2)
    }

    fun bitfieldInterleave(x: Byte, y: Byte, z: Byte, w: Byte): Int {

        var reg1 = x.toUInt()
        var reg2 = y.toUInt()
        var reg3 = z.toUInt()
        var reg4 = w.toUInt()

        reg1 = ((reg1 shl 12) or reg1) and "0x000F000F000F000F".L.i
        reg2 = ((reg2 shl 12) or reg2) and "0x000F000F000F000F".L.i
        reg3 = ((reg3 shl 12) or reg3) and "0x000F000F000F000F".L.i
        reg4 = ((reg4 shl 12) or reg4) and "0x000F000F000F000F".L.i

        reg1 = ((reg1 shl 6) or reg1) and "0x0303030303030303".L.i
        reg2 = ((reg2 shl 6) or reg2) and "0x0303030303030303".L.i
        reg3 = ((reg3 shl 6) or reg3) and "0x0303030303030303".L.i
        reg4 = ((reg4 shl 6) or reg4) and "0x0303030303030303".L.i

        reg1 = ((reg1 shl 3) or reg1) and "0x1111111111111111".L.i
        reg2 = ((reg2 shl 3) or reg2) and "0x1111111111111111".L.i
        reg3 = ((reg3 shl 3) or reg3) and "0x1111111111111111".L.i
        reg4 = ((reg4 shl 3) or reg4) and "0x1111111111111111".L.i

        return reg1 or (reg2 shl 1) or (reg3 shl 2) or (reg4 shl 3)
    }

    fun bitfieldInterleave(x: Short, y: Short, z: Short, w: Short): Long {

        var reg1 = x.toULong()
        var reg2 = y.toULong()
        var reg3 = z.toULong()
        var reg4 = w.toULong()

        reg1 = ((reg1 shl 24) or reg1) and "0x000000FF000000FF".L
        reg2 = ((reg2 shl 24) or reg2) and "0x000000FF000000FF".L
        reg3 = ((reg3 shl 24) or reg3) and "0x000000FF000000FF".L
        reg4 = ((reg4 shl 24) or reg4) and "0x000000FF000000FF".L

        reg1 = ((reg1 shl 12) or reg1) and "0x000F000F000F000F".L
        reg2 = ((reg2 shl 12) or reg2) and "0x000F000F000F000F".L
        reg3 = ((reg3 shl 12) or reg3) and "0x000F000F000F000F".L
        reg4 = ((reg4 shl 12) or reg4) and "0x000F000F000F000F".L

        reg1 = ((reg1 shl 6) or reg1) and "0x0303030303030303".L
        reg2 = ((reg2 shl 6) or reg2) and "0x0303030303030303".L
        reg3 = ((reg3 shl 6) or reg3) and "0x0303030303030303".L
        reg4 = ((reg4 shl 6) or reg4) and "0x0303030303030303".L

        reg1 = ((reg1 shl 3) or reg1) and "0x1111111111111111".L
        reg2 = ((reg2 shl 3) or reg2) and "0x1111111111111111".L
        reg3 = ((reg3 shl 3) or reg3) and "0x1111111111111111".L
        reg4 = ((reg4 shl 3) or reg4) and "0x1111111111111111".L

        return reg1 or (reg2 shl 1) or (reg3 shl 2) or (reg4 shl 3)
    }


    fun mask(bits: Int) = if (bits >= Int.BYTES * 8) 0.inv() else (1 shl bits) - 1

    fun mask(bits: Vec1i, res: Vec1i = Vec1i()): Vec1i {
        res.x = mask(bits.x)
        return res
    }

    fun mask(bits: Vec2i, res: Vec2i = Vec2i()): Vec2i {
        res.x = mask(bits.x)
        res.y = mask(bits.y)
        return res
    }

    fun mask(bits: Vec3i, res: Vec3i = Vec3i()): Vec3i {
        res.x = mask(bits.x)
        res.y = mask(bits.y)
        res.z = mask(bits.z)
        return res
    }

    fun mask(bits: Vec4i, res: Vec4i = Vec4i()): Vec4i {
        res.x = mask(bits.x)
        res.y = mask(bits.y)
        res.z = mask(bits.z)
        res.w = mask(bits.w)
        return res
    }


    fun bitfieldRotateRight(in_: Int, shift: Int) = (in_ shl shift) or (in_ ushr (Int.BYTES - shift))

    fun bitfieldRotateRight(in_: Vec1i, shift: Int, res: Vec1i = Vec1i()): Vec1i {
        res.x = bitfieldRotateRight(in_.x, shift)
        return res
    }

    fun bitfieldRotateRight(in_: Vec2i, shift: Int, res: Vec2i = Vec2i()): Vec2i {
        res.x = bitfieldRotateRight(in_.x, shift)
        res.y = bitfieldRotateRight(in_.y, shift)
        return res
    }

    fun bitfieldRotateRight(in_: Vec3i, shift: Int, res: Vec3i = Vec3i()): Vec3i {
        res.x = bitfieldRotateRight(in_.x, shift)
        res.y = bitfieldRotateRight(in_.y, shift)
        res.z = bitfieldRotateRight(in_.z, shift)
        return res
    }

    fun bitfieldRotateRight(in_: Vec4i, shift: Int, res: Vec4i = Vec4i()): Vec4i {
        res.x = bitfieldRotateRight(in_.x, shift)
        res.y = bitfieldRotateRight(in_.y, shift)
        res.z = bitfieldRotateRight(in_.z, shift)
        res.w = bitfieldRotateRight(in_.w, shift)
        return res
    }

    fun bitfieldRotateLeft(in_: Int, shift: Int) = (in_ ushr shift) or (in_ shl (Int.BYTES - shift))

    fun bitfieldRotateLeft(in_: Vec1i, shift: Int, res: Vec1i = Vec1i()): Vec1i {
        res.x = bitfieldRotateLeft(in_.x, shift)
        return res
    }

    fun bitfieldRotateLeft(in_: Vec2i, shift: Int, res: Vec2i = Vec2i()): Vec2i {
        res.x = bitfieldRotateLeft(in_.x, shift)
        res.y = bitfieldRotateLeft(in_.y, shift)
        return res
    }

    fun bitfieldRotateLeft(in_: Vec3i, shift: Int, res: Vec3i = Vec3i()): Vec3i {
        res.x = bitfieldRotateLeft(in_.x, shift)
        res.y = bitfieldRotateLeft(in_.y, shift)
        res.z = bitfieldRotateLeft(in_.z, shift)
        return res
    }

    fun bitfieldRotateLeft(in_: Vec4i, shift: Int, res: Vec4i = Vec4i()): Vec4i {
        res.x = bitfieldRotateLeft(in_.x, shift)
        res.y = bitfieldRotateLeft(in_.y, shift)
        res.z = bitfieldRotateLeft(in_.z, shift)
        res.w = bitfieldRotateLeft(in_.w, shift)
        return res
    }

    fun bitfieldFillOne(value: Int, firstBit: Int, bitCount: Int) = value or (mask(bitCount) shl firstBit)

    fun bitfieldFillOne(in_: Vec1i, firstBit: Int, bitCount: Int, res: Vec1i = Vec1i()): Vec1i {
        res.x = bitfieldFillOne(in_.x, firstBit, bitCount)
        return res
    }

    fun bitfieldFillOne(in_: Vec2i, firstBit: Int, bitCount: Int, res: Vec2i = Vec2i()): Vec2i {
        res.x = bitfieldFillOne(in_.x, firstBit, bitCount)
        res.y = bitfieldFillOne(in_.y, firstBit, bitCount)
        return res
    }

    fun bitfieldFillOne(in_: Vec3i, firstBit: Int, bitCount: Int, res: Vec3i = Vec3i()): Vec3i {
        res.x = bitfieldFillOne(in_.x, firstBit, bitCount)
        res.y = bitfieldFillOne(in_.y, firstBit, bitCount)
        res.z = bitfieldFillOne(in_.z, firstBit, bitCount)
        return res
    }

    fun bitfieldFillOne(in_: Vec4i, firstBit: Int, bitCount: Int, res: Vec4i = Vec4i()): Vec4i {
        res.x = bitfieldFillOne(in_.x, firstBit, bitCount)
        res.y = bitfieldFillOne(in_.y, firstBit, bitCount)
        res.z = bitfieldFillOne(in_.z, firstBit, bitCount)
        res.w = bitfieldFillOne(in_.w, firstBit, bitCount)
        return res
    }

    fun bitfieldFillZero(value: Int, firstBit: Int, bitCount: Int) = value and (mask(bitCount) shl firstBit).inv()

    fun bitfieldFillZero(in_: Vec1i, firstBit: Int, bitCount: Int, res: Vec1i = Vec1i()): Vec1i {
        res.x = bitfieldFillZero(in_.x, firstBit, bitCount)
        return res
    }

    fun bitfieldFillZero(in_: Vec2i, firstBit: Int, bitCount: Int, res: Vec2i = Vec2i()): Vec2i {
        res.x = bitfieldFillZero(in_.x, firstBit, bitCount)
        res.y = bitfieldFillZero(in_.y, firstBit, bitCount)
        return res
    }

    fun bitfieldFillZero(in_: Vec3i, firstBit: Int, bitCount: Int, res: Vec3i = Vec3i()): Vec3i {
        res.x = bitfieldFillZero(in_.x, firstBit, bitCount)
        res.y = bitfieldFillZero(in_.y, firstBit, bitCount)
        res.z = bitfieldFillZero(in_.z, firstBit, bitCount)
        return res
    }

    fun bitfieldFillZero(in_: Vec4i, firstBit: Int, bitCount: Int, res: Vec4i = Vec4i()): Vec4i {
        res.x = bitfieldFillZero(in_.x, firstBit, bitCount)
        res.y = bitfieldFillZero(in_.y, firstBit, bitCount)
        res.z = bitfieldFillZero(in_.z, firstBit, bitCount)
        res.w = bitfieldFillZero(in_.w, firstBit, bitCount)
        return res
    }
}