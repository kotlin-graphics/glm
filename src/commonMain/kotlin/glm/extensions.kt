@file:OptIn(ExperimentalContracts::class)

package glm

//import glm_.mat4x4.Mat4
//import unsigned.*
//import java.io.InputStream
//import java.math.BigInteger
import glm.extensions.*
import kotlin.contracts.ExperimentalContracts
import kotlin.math.*
import kotlin.math.pow


infix fun Char.shl(bits: Int) = i shl bits
infix fun Char.shr(bits: Int) = i shr bits
operator fun Char.compareTo(other: Int) = i.compareTo(other)
operator fun Int.plus(b: Char) = this + b.i
operator fun Int.minus(b: Char) = this - b.i
infix fun Int.xor(b: Char) = this xor b.i


val Int.uc get() = (this % 256).c // TODO others

fun ByteArray.getFloat(index: Int, bigEndian: Boolean = true) = Float.fromBits(getInt(index, bigEndian))

fun ByteArray.getDouble(index: Int, bigEndian: Boolean = true) = Double.fromBits(getLong(index, bigEndian))

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

fun ByteArray.putFloat(index: Int, float: Float, bigEndian: Boolean = true) = putInt(index, float.toRawBits(), bigEndian)

fun ByteArray.putDouble(index: Int, double: Double, bigEndian: Boolean = true) = putLong(index, double.toRawBits(), bigEndian)

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


inline infix fun Int.pow(exponent: Int) = f.pow(exponent).i
inline infix fun Int.pow(exponent: Float) = f.pow(exponent).i
inline infix fun Float.pow(exponent: Int) = pow(exponent)
inline infix fun Float.pow(exponent: Float) = pow(exponent)
inline infix fun Double.pow(exponent: Int) = pow(exponent)
inline infix fun Double.pow(exponent: Double) = pow(exponent)
inline fun Byte.abs() = abs(toInt()).toByte()
inline fun Short.abs() = abs(toInt()).toShort()
inline fun Int.abs() = abs(this)
inline fun Long.abs() = abs(this)
inline fun Float.abs() = abs(this)
inline fun Double.abs() = abs(this)
inline fun Float.ceil() = ceil(this)
inline fun Double.ceil() = ceil(this)
inline fun Byte.clamp(min: Byte, max: Byte): Byte = max(min) min max
inline fun Int.clamp(min: Int, max: Int) = max(min) min max
inline infix fun Int.clamp(range: IntRange) = max(range.first) min range.last
inline fun Short.clamp(min: Short, max: Short): Short = max(min) min max
inline fun Long.clamp(min: Long, max: Long) = max(min) min max
inline fun Float.clamp(min: Float, max: Float) = max(min) min max
inline fun Double.clamp(min: Double, max: Double) = max(min) min max
inline fun Float.exp() = exp(this)
inline fun Double.exp() = exp(this)
inline fun Float.exp2() = 2f pow this
inline fun Double.exp2() = 2.0 pow this
inline fun Float.floor() = floor(this)
inline fun Double.floor() = floor(this)
inline fun Float.fract() = 1f - floor()
inline fun Double.fract() = 1.0 - floor()
inline fun Float.log() = ln(this)
inline fun Double.log() = ln(this)
inline fun Float.log2() = log2(this)
inline fun Double.log2() = log2(this)
inline fun Float.modf(i: (Float) -> Unit): Float {
    kotlin.contracts.contract { callsInPlace(i, kotlin.contracts.InvocationKind.EXACTLY_ONCE) }
    val int = if (this > 0f) floor() else ceil()
    i(int)
    return this - int
}

inline fun Double.modf(i: (Double) -> Unit): Double {
    kotlin.contracts.contract { callsInPlace(i, kotlin.contracts.InvocationKind.EXACTLY_ONCE) }
    val int = if (this > 0.0) floor() else ceil()
    i(int)
    return this - int
}

fun Float.modf(): Pair<Float, Float> {
    val int = if (this > 0f) floor() else ceil()
    return (this - int) to int
}

fun Double.modf(): Pair<Double, Double> {
    val int = if (this > 0.0) floor() else ceil()
    return (this - int) to int
}
//inline fun Double.modf(i: (Int) -> Unit) = log2(this)
inline infix fun Byte.min(b: Byte) = min(i, b.i).b
inline infix fun Int.min(b: Int) = min(this, b)
inline infix fun Short.min(b: Short) = min(i, b.i).s
inline infix fun Long.min(b: Long) = min(this, b)
inline infix fun UInt.min(b: UInt) = min(this, b)
inline infix fun ULong.min(b: ULong) = min(this, b)
inline infix fun Float.min(b: Float) = min(this, b)
inline infix fun Double.min(b: Double) = min(this, b)

inline infix fun Byte.max(b: Byte) = max(i, b.i).b
inline infix fun Int.max(b: Int) = max(this, b)
inline infix fun Short.max(b: Short) = max(i, b.i).s
inline infix fun Long.max(b: Long) = max(this, b)
inline infix fun UInt.max(b: UInt) = max(this, b)
inline infix fun ULong.max(b: ULong) = max(this, b)
inline infix fun Float.max(b: Float) = max(this, b)
inline infix fun Double.max(b: Double) = max(this, b)
inline fun Float.round() = roundToInt().toFloat()
inline fun Double.round() = roundToInt().toDouble()
inline fun Float.roundEven() = round(this)
inline fun Double.roundEven() = round(this)
inline fun Float.sqrt() = sqrt(this)
inline fun Double.sqrt() = sqrt(this)
inline fun Float.trunc() = truncate(this)
inline fun Double.trunc() = truncate(this)
inline fun Float.inverseSqrt() = 1f / sqrt()
inline fun Double.inverseSqrt() = 1.0 / sqrt()

fun Float.equal(other: Float, epsilon: Float = Float.MIN_VALUE): Boolean = abs(this - other) <= epsilon
fun Double.equal(other: Double, epsilon: Double = Double.MIN_VALUE): Boolean = abs(this - other) <= epsilon