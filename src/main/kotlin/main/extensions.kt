package main

import unsigned.*
import java.nio.*

/**
 * Created by GBarbieri on 07.12.2016.
 */

val Number.f: Float
    get() = toFloat()
val Number.b: Byte
    get() = toByte()
val Number.d: Double
    get() = toDouble()
val Number.i: Int
    get() = toInt()
val Number.L: Long
    get() = toLong()
val Number.s: Short
    get() = toShort()
val Number.ub: Ubyte
    get() = toUbyte()
val Number.ui: Uint
    get() = toUint()
val Number.ul: Ulong
    get() = toUlong()
val Number.us: Ushort
    get() = toUshort()


val Boolean.f: Float
    get() = if (this) 1f else 0f
val Boolean.b: Byte
    get() = if (this) 1.b else 0.b
val Boolean.d: Double
    get() = if (this) 1.0 else 0.0
val Boolean.i: Int
    get() = if (this) 1 else 0
val Boolean.L: Long
    get() = if (this) 1L else 0L
val Boolean.s: Short
    get() = if (this) 1.s else 0.s
val Boolean.ub: Ubyte
    get() = if (this) 1.ub else 0.ub
val Boolean.ui: Uint
    get() = if (this) 1.ui else 0.ui
val Boolean.ul: Ulong
    get() = if (this) 1.ul else 0.ul
val Boolean.us: Ushort
    get() = if (this) 1.us else 0.us


val Char.f: Float
    get() = toFloat()
val Char.b: Byte
    get() = toByte()
val Char.d: Double
    get() = toDouble()
val Char.i: Int
    get() = toInt()
val Char.L: Long
    get() = toLong()
val Char.s: Short
    get() = toShort()
val Char.ub: Ubyte
    get() = toUbyte()
val Char.ui: Uint
    get() = toUint()
val Char.ul: Ulong
    get() = toUlong()
val Char.us: Ushort
    get() = toUshort()


fun ByteArray.getFloat(index: Int, bigEndianess: Boolean = true) = Float.intBitsToFloat(
        if (bigEndianess) this[index].i and 0xFF or
                (this[index + 1].i and 0xFF shl 8) or
                (this[index + 2].i and 0xFF shl 16) or
                (this[index + 3].i and 0xFF shl 24)
        else this[index + 3].i and 0xFF or
                (this[index + 2].i and 0xFF shl 8) or
                (this[index + 1].i and 0xFF shl 16) or
                (this[index].i and 0xFF shl 24)
)

fun ByteArray.getDouble(index: Int, bigEndianess: Boolean = true) = Double.longBitsToDouble(
        if (bigEndianess) this[index].L and 0xFF or
                (this[index + 1].L and 0xFF shl 8) or
                (this[index + 2].L and 0xFF shl 16) or
                (this[index + 3].L and 0xFF shl 24) or
                (this[index + 4].L and 0xFF shl 32) or
                (this[index + 5].L and 0xFF shl 40) or
                (this[index + 6].L and 0xFF shl 48) or
                (this[index + 7].L and 0xFF shl 56)
        else this[index + 7].L and 0xFF or
                (this[index + 6].L and 0xFF shl 8) or
                (this[index + 5].L and 0xFF shl 16) or
                (this[index + 4].L and 0xFF shl 24) or
                (this[index + 3].L and 0xFF shl 32) or
                (this[index + 2].L and 0xFF shl 40) or
                (this[index + 1].L and 0xFF shl 48) or
                (this[index].L and 0xFF shl 56))

fun ByteArray.getInt(index: Int, bigEndianess: Boolean = true) =
        if (bigEndianess) this[index].i and 0xFF or
                (this[index + 1].i and 0xFF shl 8) or
                (this[index + 2].i and 0xFF shl 16) or
                (this[index + 3].i and 0xFF shl 24)
        else this[index + 3].i and 0xFF or
                (this[index + 2].i and 0xFF shl 8) or
                (this[index + 1].i and 0xFF shl 16) or
                (this[index].i and 0xFF shl 24)

fun ByteArray.getLong(index: Int, bigEndianess: Boolean = true) =
        if (bigEndianess) this[index].L and 0xFF or
                (this[index + 1].L and 0xFF shl 8) or
                (this[index + 2].L and 0xFF shl 16) or
                (this[index + 3].L and 0xFF shl 24) or
                (this[index + 4].L and 0xFF shl 32) or
                (this[index + 5].L and 0xFF shl 40) or
                (this[index + 6].L and 0xFF shl 48) or
                (this[index + 7].L and 0xFF shl 56)
        else this[index + 7].L and 0xFF or
                (this[index + 6].L and 0xFF shl 8) or
                (this[index + 5].L and 0xFF shl 16) or
                (this[index + 4].L and 0xFF shl 24) or
                (this[index + 3].L and 0xFF shl 32) or
                (this[index + 2].L and 0xFF shl 40) or
                (this[index + 1].L and 0xFF shl 48) or
                (this[index].L and 0xFF shl 56)

fun ByteArray.getShort(index: Int, bigEndianess: Boolean = true) =
        if (bigEndianess) this[index].s and 0xFF or
                (this[index + 1].s and 0xFF shl 8)
        else this[index + 1].s and 0xFF or
                (this[index].s and 0xFF shl 56)

// skipping getUbyte, since it'main.getS a simply .main.getUb
fun ByteArray.getUint(index: Int, bigEndianess: Boolean = true) = getInt(index, bigEndianess).ui
fun ByteArray.getUlong(index: Int, bigEndianess: Boolean = true) = getLong(index, bigEndianess).ul
fun ByteArray.getUshort(index: Int, bigEndianess: Boolean = true) = getShort(index, bigEndianess).us


infix fun Byte.and(other: Byte) = (i and other.i).b
infix fun Byte.or(other: Byte) = (i or other.i).b
infix fun Byte.xor(other: Byte) = (i xor other.i).b
infix fun Byte.shl(other: Byte) = (i shl other.i).b
infix fun Byte.shr(other: Byte) = (i shr other.i).b

infix fun Byte.and(other: Int) = (i and other).b
infix fun Byte.or(other: Int) = (i or other).b
infix fun Byte.xor(other: Int) = (i xor other).b
infix fun Byte.shl(other: Int) = (i shl other).b
infix fun Byte.shr(other: Int) = (i shr other).b

infix fun Short.and(other: Short) = (i and other.i).s
infix fun Short.or(other: Short) = (i or other.i).s
infix fun Short.xor(other: Short) = (i xor other.i).s
infix fun Short.shl(other: Short) = (i shl other.i).s
infix fun Short.shr(other: Short) = (i shr other.i).s

infix fun Short.and(other: Int) = (i and other).s
infix fun Short.or(other: Int) = (i or other).s
infix fun Short.xor(other: Int) = (i xor other).s
infix fun Short.shl(other: Int) = (i shl other).s
infix fun Short.shr(other: Int) = (i shr other).s

val String.f: Float
    get() = toFloat()
val String.b: Byte
    get() = toByte()
val String.d: Double
    get() = toDouble()
val String.i: Int
    get() = toInt()
val String.L: Long
    get() = toLong()
val String.s: Short
    get() = toShort()
// TODO unsigned String extensions
val String.ub: Ubyte
    get() = Ubyte(this)
val String.ui: Uint
    get() = Uint(this)
val String.ul: Ulong
    get() = Ulong(this)
val String.us: Ushort
    get() = Ushort(this)


val ByteBuffer.SIZE
    get() = capacity() * Byte.BYTES
val ShortBuffer.SIZE
    get() = capacity() * Short.BYTES
val IntBuffer.SIZE
    get() = capacity() * Int.BYTES
val LongBuffer.SIZE
    get() = capacity() * Long.BYTES
val FloatBuffer.SIZE
    get() = capacity() * Float.BYTES
val DoubleBuffer.SIZE
    get() = capacity() * Double.BYTES
val CharBuffer.SIZE
    get() = capacity() * Byte.BYTES // Note: it'main.getS byte main.and not char