package glm_

import glm_.mat4x4.Mat4
import unsigned.*
import java.io.InputStream
import java.math.BigInteger
import kotlin.math.pow

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
infix fun Char.shr(bits: Int) = i shr bits
operator fun Char.compareTo(other: Int) = i.compareTo(other)
operator fun Int.plus(b: Char) = this + b.i
operator fun Int.minus(b: Char) = this - b.i
infix fun Int.xor(b: Char) = this xor b.i


val Int.uc get() = (this % 256).c // TODO others

fun ByteArray.getFloat(index: Int, bigEndian: Boolean = true) = getInt(index, bigEndian).bitsAsFloat

fun ByteArray.getDouble(index: Int, bigEndian: Boolean = true) = getLong(index, bigEndian).bitsAsDouble

fun ByteArray.getShort(index: Int, bigEndian: Boolean = true): Short {
    val a: Int
    val b: Int
    if (bigEndian) {
        a = this[index + 1].i and 0xFF
        b = (this[index].i and 0xFF) shl 8
    } else {
        a = this[index].i and 0xFF
        b = (this[index + 1].i and 0xFF) shl 8
    }
    return (a or b).s
}

fun ByteArray.getInt(index: Int, bigEndian: Boolean = true): Int {
    val a: Int
    val b: Int
    val c: Int
    val d: Int
    if (bigEndian) {
        a = this[index + 3].i and 0xFF
        b = (this[index + 2].i and 0xFF) shl 8
        c = (this[index + 1].i and 0xFF) shl 16
        d = (this[index].i and 0xFF) shl 24
    } else {
        a = this[index].i and 0xFF
        b = (this[index + 1].i and 0xFF) shl 8
        c = (this[index + 2].i and 0xFF) shl 16
        d = (this[index + 3].i and 0xFF) shl 24
    }
    return a or b or c or d
}

fun ByteArray.getLong(index: Int, bigEndian: Boolean = true): Long {
    val a: Long
    val b: Long
    val c: Long
    val d: Long
    val e: Long
    val f: Long
    val g: Long
    val h: Long
    if (bigEndian) {
        a = this[index + 7].L and 0xFF
        b = (this[index + 6].L and 0xFF) shl 8
        c = (this[index + 5].L and 0xFF) shl 16
        d = (this[index + 4].L and 0xFF) shl 24
        e = (this[index + 3].L and 0xFF) shl 32
        f = (this[index + 2].L and 0xFF) shl 40
        g = (this[index + 1].L and 0xFF) shl 48
        h = (this[index].L and 0xFF) shl 56
    } else {
        a = this[index].L and 0xFF
        b = (this[index + 1].L and 0xFF) shl 8
        c = (this[index + 2].L and 0xFF) shl 16
        d = (this[index + 3].L and 0xFF) shl 24
        e = (this[index + 4].L and 0xFF) shl 32
        f = (this[index + 5].L and 0xFF) shl 40
        g = (this[index + 6].L and 0xFF) shl 48
        h = (this[index + 7].L and 0xFF) shl 56
    }
    return a or b or c or d or e or f or g or h
}

fun ByteArray.putFloat(index: Int, float: Float, bigEndian: Boolean = true) = putInt(index, float.asRawIntBits, bigEndian)

fun ByteArray.putDouble(index: Int, double: Double, bigEndian: Boolean = true) = putLong(index, double.asRawLongBits, bigEndian)

fun ByteArray.putShort(index: Int, short: Short, bigEndian: Boolean = true) {
    val int = short.i
    if (bigEndian) {
        this[index + 1] = (int and 0xFF).b
        this[index] = ((int ushr 8) and 0xFF).b
    } else {
        this[index] = (int and 0xFF).b
        this[index + 1] = ((int ushr 8) and 0xFF).b
    }
}

fun ByteArray.putInt(index: Int, int: Int, bigEndian: Boolean = true) {
    if (bigEndian) {
        this[index + 3] = (int and 0xFF).b
        this[index + 2] = ((int ushr 8) and 0xFF).b
        this[index + 1] = ((int ushr 16) and 0xFF).b
        this[index] = ((int ushr 24) and 0xFF).b
    } else {
        this[index] = (int and 0xFF).b
        this[index + 1] = ((int ushr 8) and 0xFF).b
        this[index + 2] = ((int ushr 16) and 0xFF).b
        this[index + 3] = ((int ushr 24) and 0xFF).b
    }
}

fun ByteArray.putLong(index: Int, long: Long, bigEndian: Boolean = true) {
    if (bigEndian) {
        this[index + 7] = (long and 0xFF).b
        this[index + 6] = ((long ushr 8) and 0xFF).b
        this[index + 5] = ((long ushr 16) and 0xFF).b
        this[index + 4] = ((long ushr 24) and 0xFF).b
        this[index + 3] = ((long ushr 32) and 0xFF).b
        this[index + 2] = ((long ushr 40) and 0xFF).b
        this[index + 1] = ((long ushr 48) and 0xFF).b
        this[index] = ((long ushr 56) and 0xFF).b
    } else {
        this[index] = (long and 0xFF).b
        this[index + 1] = ((long ushr 8) and 0xFF).b
        this[index + 2] = ((long ushr 16) and 0xFF).b
        this[index + 3] = ((long ushr 24) and 0xFF).b
        this[index + 4] = ((long ushr 32) and 0xFF).b
        this[index + 5] = ((long ushr 40) and 0xFF).b
        this[index + 6] = ((long ushr 48) and 0xFF).b
        this[index + 7] = ((long ushr 56) and 0xFF).b
    }
}

// skipping getUbyte, since it'main.getS a simply .main.getUb
fun ByteArray.getUint(index: Int, bigEndian: Boolean = true) = getInt(index, bigEndian).ui

fun ByteArray.getUlong(index: Int, bigEndian: Boolean = true) = getLong(index, bigEndian).ul
fun ByteArray.getUshort(index: Int, bigEndian: Boolean = true) = getShort(index, bigEndian).us


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
val String.i get() = if (startsWith("0x")) java.lang.Integer.parseInt(substring(2), 16) else toInt()
val String.L
    get() = try {
        if (startsWith("0x"))
            java.lang.Long.parseLong(substring(2), 16)
        else toLong()
    } catch (ex: NumberFormatException) {
        bi.L
    }
val String.s get() = toShort()
// TODO unsigned String extensions
val String.ub get() = Ubyte(this)
val String.ui get() = Uint(this)
val String.ul get() = Ulong(this)
val String.us get() = Ushort(this)
val String.bi get() = if (startsWith("0x")) BigInteger(substring(2), 16) else BigInteger(this)


fun InputStream.int(bigEndian: Boolean = true): Int {
    val a = read()
    val b = read()
    val c = read()
    val d = read()
    if (bigEndian)
        return (a shl 24) + (b shl 16) + (c shl 8) + d
    else
        return (d shl 24) + (c shl 16) + (b shl 8) + a
}

fun InputStream.short(bigEndian: Boolean = true): Int {
    val a = read()
    val b = read()
    if (bigEndian)
        return (a shl 8) + b
    else
        return (b shl 8) + a
}

fun InputStream.byte() = read().b

fun InputStream.float(bigEndian: Boolean = true) = int(bigEndian).bitsAsFloat
fun InputStream.double(bigEndian: Boolean = true) = long(bigEndian).bitsAsDouble

fun InputStream.long(bigEndian: Boolean = true): Long {
    val a = int(bigEndian)
    val b = int(bigEndian)
    return (b.L shl 32) + a
}

fun InputStream.mat4(bigEndian: Boolean = true) = Mat4(
        float(bigEndian), float(bigEndian), float(bigEndian), float(bigEndian),
        float(bigEndian), float(bigEndian), float(bigEndian), float(bigEndian),
        float(bigEndian), float(bigEndian), float(bigEndian), float(bigEndian),
        float(bigEndian), float(bigEndian), float(bigEndian), float(bigEndian))

internal val Any.toFloat: Float
    get() = when (this) {
        is Number -> this.f
        is Char -> this.f
        is Boolean -> this.f
        is String -> this.f
        else -> throw ArithmeticException("incompatible type")
    }

internal val Any.toByte: Byte
    get() = when (this) {
        is Number -> this.b
        is Char -> this.b
        is Boolean -> this.b
        is String -> this.b
        else -> throw ArithmeticException("incompatible type")
    }

internal val Any.toDouble: Double
    get() = when (this) {
        is Number -> this.d
        is Char -> this.d
        is Boolean -> this.d
        is String -> this.d
        else -> throw ArithmeticException("incompatible type")
    }

internal val Any.toInt: Int
    get() = when (this) {
        is Number -> this.i
        is Char -> this.i
        is Boolean -> this.i
        is String -> this.i
        else -> throw ArithmeticException("incompatible type")
    }

internal val Any.toLong: Long
    get() = when (this) {
        is Number -> this.L
        is Char -> this.L
        is Boolean -> this.L
        is String -> this.L
        else -> throw ArithmeticException("incompatible type")
    }

internal val Any.toShort: Short
    get() = when (this) {
        is Number -> this.s
        is Char -> this.s
        is Boolean -> this.s
        is String -> this.s
        else -> throw ArithmeticException("incompatible type")
    }

infix fun Int.pow(exponent: Int) = f.pow(exponent).i
infix fun Int.pow(exponent: Float) = f.pow(exponent).i
infix fun Float.pow(exponent: Int) = pow(exponent)
infix fun Float.pow(exponent: Float) = pow(exponent)
