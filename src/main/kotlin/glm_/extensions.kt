package glm_

import glm_.mat4x4.Mat4
import unsigned.*
import java.io.DataInputStream
import kotlin.experimental.or

/**
 * Created by GBarbieri on 07.12.2016.
 */

val Number.f get() = toFloat()
val Number.b get() = toByte()
val Number.d get() = toDouble()
val Number.i get() = toInt()
val Number.L get() = toLong()
val Number.s get() = toShort()
val Number.ub get() = toUbyte()
val Number.ui get() = toUint()
val Number.ul get() = toUlong()
val Number.us get() = toUshort()
val Number.c get() = toChar()
val Number.bool get() = i != 0


val Boolean.f get() = if (this) 1f else 0f
val Boolean.b get() = if (this) 1.b else 0.b
val Boolean.d get() = if (this) 1.0 else 0.0
val Boolean.i get() = if (this) 1 else 0
val Boolean.L get() = if (this) 1L else 0L
val Boolean.s get() = if (this) 1.s else 0.s
val Boolean.ub get() = if (this) 1.ub else 0.ub
val Boolean.ui get() = if (this) 1.ui else 0.ui
val Boolean.ul get() = if (this) 1.ul else 0.ul
val Boolean.us get() = if (this) 1.us else 0.us


val Char.f get() = toFloat()
val Char.b get() = toByte()
val Char.d get() = toDouble()
val Char.i get() = toInt()
val Char.L get() = toLong()
val Char.s get() = toShort()
val Char.ub get() = toUbyte()
val Char.ui get() = toUint()
val Char.ul get() = toUlong()
val Char.us get() = toUshort()

infix fun Char.shl(bits: Int) = i shl bits
operator fun Char.compareTo(other: Int) = i.compareTo(other)
operator fun Int.plus(b: Char) = this + b.i
operator fun Int.minus(b: Char) = this - b.i
infix fun Int.xor(b: Char) = this xor b.i

val Int.uc get() = (this % 256).c // TODO others

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
        if (bigEndianess)
            this[index].s and 0xFF or (this[index + 1].s and 0xFF shl 8)
        else
            this[index + 1].s and 0xFF or (this[index].s and 0xFF shl 56)

// skipping getUbyte, since it'main.getS a simply .main.getUb
fun ByteArray.getUint(index: Int, bigEndianess: Boolean = true) = getInt(index, bigEndianess).ui

fun ByteArray.getUlong(index: Int, bigEndianess: Boolean = true) = getLong(index, bigEndianess).ul
fun ByteArray.getUshort(index: Int, bigEndianess: Boolean = true) = getShort(index, bigEndianess).us


infix fun Byte.shl(other: Byte) = (i shl other.i).b
infix fun Byte.shr(other: Byte) = (i shr other.i).b

infix fun Byte.and(other: Int) = (i and other).b
infix fun Byte.or(other: Int) = (i or other).b
infix fun Byte.xor(other: Int) = (i xor other).b
infix fun Byte.shl(other: Int) = (i shl other).b
infix fun Byte.shr(other: Int) = (i shr other).b

infix fun Short.shl(other: Short) = (i shl other.i).s
infix fun Short.shr(other: Short) = (i shr other.i).s

infix fun Short.and(other: Int) = (i and other).s
infix fun Short.or(other: Int) = (i or other).s
infix fun Short.xor(other: Int) = (i xor other).s
infix fun Short.shl(other: Int) = (i shl other).s
infix fun Short.shr(other: Int) = (i shr other).s

infix fun Long.and(other: Int) = this and other.L
infix fun Long.or(other: Int) = this or other.L
infix fun Long.xor(other: Int) = this xor other.L

val String.f get() = toFloat()
val String.b get() = toByte()
val String.d get() = toDouble()
val String.i get() = toInt()
val String.L get() = toLong()
val String.s get() = toShort()
// TODO unsigned String extensions
val String.ub get() = Ubyte(this)
val String.ui get() = Uint(this)
val String.ul get() = Ulong(this)
val String.us get() = Ushort(this)


val Float.deg get() = Math.toDegrees(this.d).f
val Double.deg get() = Math.toDegrees(this)
val Float.rad get() = Math.toRadians(this.d).f
val Double.rad get() = Math.toRadians(this)

val Float.cos get() = Math.cos(this.d).f
val Double.cos get() = Math.cos(this)
val Float.sin get() = Math.sin(this.d).f
val Double.sin get() = Math.sin(this)

fun DataInputStream.readMat4() = Mat4(
        readFloat(), readFloat(), readFloat(), readFloat(),
        readFloat(), readFloat(), readFloat(), readFloat(),
        readFloat(), readFloat(), readFloat(), readFloat(),
        readFloat(), readFloat(), readFloat(), readFloat())