package glm_

//import glm_.mat4x4.Mat4
//import unsigned.*
//import java.io.InputStream
//import java.math.BigInteger
import glm_.extensions.*
import glm_.scalar.abs
import glm_.scalar.bitsToDouble
import glm_.scalar.bitsToFloat
import glm_.scalar.bitsToInt
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


//fun Float.equal(other: Float, epsilon: Float = Float.MIN_VALUE): Boolean = abs(this - other) <= epsilon
//fun Double.equal(other: Double, epsilon: Double = Double.MIN_VALUE): Boolean = abs(this - other) <= epsilon

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

fun Short.toFloat32(): Float {

    val s = (this.i shr 15) and 0x00000001
    var e = (this.i shr 10) and 0x0000001f
    var m = this.i and 0x000003ff

    if (e == 0) {
        if (m == 0)
        // Plus or minus zero
            return (s shl 31).bitsToFloat()
        else {
            // Denormalized number -- renormalize it
            while ((m and 0x00000400) == 0) {
                m = m shl 1
                e -= 1
            }
            e += 1
            m = m and 0x00000400.inv()
        }
    } else if (e == 31)
        return when (m) {
            // Positive or negative infinity
            0 -> ((s shl 31) or 0x7f800000).bitsToFloat()
            // Nan -- preserve sign and significand bits
            else -> ((s shl 31) or 0x7f800000 or (m shl 13)).bitsToFloat()
        }
    // Normalized number
    e += 127 - 15
    m = m shl 13
    // Assemble s, e and m.
    return ((s shl 31) or (e shl 23) or m).bitsToFloat()
}

fun Float.toFloat16(): Short {

    val i = bitsToInt()

    /*  Our floating point number, f, is represented by the bit pattern in integer i.  Disassemble that bit pattern
        into the sign, s, the exponent, e, and the significand, m.
        Shift s into the position where it will go in the resulting half number.
        Adjust e, accounting for the different exponent bias of float and half (127 versus 15). */

    val s = (i ushr 16) and 0x00008000
    var e = ((i ushr 23) and 0x000000ff) - (127 - 15)
    var m = i and 0x007fffff

    // Now reassemble s, e and m into a half:
    if (e <= 0) {
        if (e < -10)
        /*  E is less than -10.  The absolute value of f is less than half_MIN (f may be a small normalized
            float, a denormalized float or a zero).
            We convert f to a half zero.    */
            return s.s

        /*  E is between -10 and 0.  F is a normalized float, whose magnitude is less than __half_NRM_MIN.
            We convert f to a denormalized half.    */
        m = (m or 0x00800000) ushr (1 - e)

        /*  Round to nearest, round "0.5" up.
            Rounding may cause the significand to overflow and make our number normalized.  Because of the way a
            half's bits are laid out, we don't have to treat this case separately; the code below will handle it
            correctly.    */
        if ((m and 0x00001000) != 0)
            m += 0x00002000

        // Assemble the half from s, e (zero) and m.
        return (s or (m shr 13)).s

    } else if (e == 0xff - (127 - 15))
        return when (m) {
            //  F is an infinity; convert f to a half infinity with the same sign as f.
            0 -> (s or 0x7c00).s
            else -> {
                /*  F is a NAN; we produce a half NAN that preserves the sign bit and the 10 leftmost bits of the
                        significand of f, with one exception: If the 10 leftmost bits are all zero, the NAN would turn into
                        an infinity, so we have to set at least one bit in the significand. */
                m = m shr 13
                (s or 0x7c00 or m or (if (m == 0) 1 else 0)).s
            }
        }
    else {
        /*  E is greater than zero.  F is a normalized float.
            We try to convert f to a normalized half.             */
        // Round to nearest, round "0.5" up
        if ((m and 0x00001000) != 0) {
            m += 0x00002000
            if ((m and 0x00800000) != 0) {
                m = 0   // overflow in significand,
                e += 1  // adjust exponent
            }
        }
        // Handle exponent overflow
        if (e > 30) {
            println("overflow") // Cause a hardware floating point overflow;
            return (s or 0x7c00).s  // if this returns, the half becomes an infinity with the same sign as f.
        }
        // Assemble the half from s, e and m.
        return (s or (e shl 10) or (m shr 13)).s
    }
}