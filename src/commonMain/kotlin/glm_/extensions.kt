package glm_

//import glm_.mat4x4.Mat4
//import unsigned.*
//import java.io.InputStream
//import java.math.BigInteger
import glm_.extensions.*
import kotlin.math.*


infix fun Char.shl(bits: Int): Int = i shl bits
infix fun Char.shr(bits: Int): Int = i shr bits
operator fun Char.compareTo(other: Int): Int = i.compareTo(other)
operator fun Int.plus(b: Char): Int = this + b.i
operator fun Int.minus(b: Char): Int = this - b.i
infix fun Int.xor(b: Char): Int = this xor b.i


val Int.uc: Char get() = (this % 256).c // TODO others

fun ByteArray.getFloat(index: Int, bigEndian: Boolean = true): Float = Float.fromBits(getInt(index, bigEndian))

fun ByteArray.getDouble(index: Int, bigEndian: Boolean = true): Double = Double.fromBits(getLong(index, bigEndian))

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
fun ByteArray.getUint(index: Int, bigEndian: Boolean = true): UInt = getInt(index, bigEndian).ui

fun ByteArray.getUlong(index: Int, bigEndian: Boolean = true): ULong = getLong(index, bigEndian).ul
fun ByteArray.getUshort(index: Int, bigEndian: Boolean = true): UShort = getShort(index, bigEndian).us



//inline fun Double.modf(i: (Int) -> Unit) = log2(this)


fun Float.equal(other: Float, epsilon: Float = Float.MIN_VALUE): Boolean = abs(this - other) <= epsilon
fun Double.equal(other: Double, epsilon: Double = Double.MIN_VALUE): Boolean = abs(this - other) <= epsilon

val Int.mask: Int
    get() = when {
        this >= Int.SIZE_BYTES * 8 -> 0.inv()
        else -> (1 shl this) - 1
    }
val Long.mask: Long
    get() = when {
        this >= Long.SIZE_BYTES * 8 -> 0.inv()
        else -> (1L shl this.toInt()) - 1
    }
val UInt.mask: UInt
    get() = when {
        this >= UInt.SIZE_BYTES.toUInt() * 8u -> 0u.inv()
        else -> (1u shl this) - 1u
    }
val ULong.mask: ULong
    get() = when {
        this >= ULong.SIZE_BYTES.toUInt() * 8u -> 0uL.inv()
        else -> (1uL shl this.toInt()) - 1uL
    }

infix fun Int.has(flag: Int): Boolean = and(flag) != 0