package glm_

import unsigned.Ubyte
import unsigned.Uint
import unsigned.Ulong
import unsigned.Ushort


infix fun Byte.compare(other: Byte) = java.lang.Byte.compare(this, other)
val String.decodeByte: Byte
    get () = java.lang.Byte.decode(this)
val Byte.hashCode: Int
    get() = java.lang.Byte.hashCode(this)

fun String.parseByte(radix: Int = 10): Byte = java.lang.Byte.parseByte(this, radix)
val Byte.asString: String
    get() = java.lang.Byte.toString(this)
val Byte.asUnsignedInt: Int
    get() = java.lang.Byte.toUnsignedInt(this)
val Byte.asUnsignedLong: Long
    get() = java.lang.Byte.toUnsignedLong(this)
val Byte.value: Byte
    get() = java.lang.Byte.valueOf(this)

fun String.byteValue(radix: Int = 10): Byte = java.lang.Byte.valueOf(this, radix)
// bonus
val Byte.asBinaryString: String
    get() = i.asBinaryString
val Byte.asHexString: String
    get() = i.asHexString
val Byte.asOctalString: String
    get() = i.asOctalString


infix fun Short.compare(other: Short) = java.lang.Short.compare(this, other)
val String.decodeShort: Short
    get () = java.lang.Short.decode(this)
val Short.hashCode: Int
    get() = java.lang.Short.hashCode(this)

fun String.parseShort(radix: Int = 10): Short = java.lang.Short.parseShort(this, radix)
val Short.reverseBytes: Short
    get() = java.lang.Short.reverseBytes(this)
val Short.asString: String
    get() = java.lang.Short.toString(this)
val Short.asUnsignedInt: Int
    get() = java.lang.Short.toUnsignedInt(this)
val Short.asUnsignedLong: Long
    get() = java.lang.Short.toUnsignedLong(this)
val Short.value: Short
    get() = java.lang.Short.valueOf(this)

fun String.shortValue(radix: Int = 10): Short = java.lang.Short.valueOf(this, radix)
// bonus
val Short.asBinaryString: String
    get() = i.asBinaryString
val Short.asHexString: String
    get() = i.asHexString
val Short.asOctalString: String
    get() = i.asOctalString


infix fun Int.compare(other: Int): Int = Integer.compare(this, other)
infix fun Int.compareUnsigned(other: Int): Int = Integer.compareUnsigned(this, other)
val Int.bitCount: Int
    get() = Integer.bitCount(this)
val String.decondeInt: Int
    get () = Integer.decode(this)

infix fun Int.divideUnsigned(divisor: Int): Int = Integer.divideUnsigned(this, divisor)
// we have both ::integer because they have different codepaths
val String.integer: Int
    get () = Integer.getInteger(this)

fun String.integer(default: Int): Int = Integer.getInteger(this, default)
val Int.hashCode: Int
    get() = Integer.hashCode(this)
val Int.highestOneBit: Int
    get() = Integer.highestOneBit(this)
val Int.lowestOneBit: Int
    get() = Integer.lowestOneBit(this)

infix fun Int.max(other: Int): Int = Integer.max(this, other)
infix fun Int.min(other: Int): Int = Integer.min(this, other)
val Int.numberOfLeadingZeros: Int
    get() = Integer.numberOfLeadingZeros(this)
val Int.numberOfTrailingZeros: Int
    get() = Integer.numberOfTrailingZeros(this)

fun String.parseInt(radix: Int = 10): Int = Integer.parseInt(this, radix)
fun String.parseUnsignedInt(radix: Int = 10): Int = Integer.parseUnsignedInt(this, radix)
infix fun Int.remainderUnsigned(divisor: Int): Int = Integer.remainderUnsigned(this, divisor)
val Int.reverse: Int
    get() = Integer.reverse(this)
val Int.reverseBytes: Int
    get() = Integer.reverseBytes(this)

infix fun Int.rotateLeft(distance: Int): Int = Integer.rotateLeft(this, distance)
infix fun Int.rotateRight(distance: Int): Int = Integer.rotateRight(this, distance)
val Int.signum: Int
    get() = Integer.signum(this)

infix fun Int.sum(other: Int): Int = Integer.sum(this, other)
val Int.asBinaryString: String
    get() = Integer.toBinaryString(this)
val Int.asHexString: String
    get() = Integer.toHexString(this)
val Int.asOctalString: String
    get() = Integer.toOctalString(this)
// we have both asString and toString because they have different codepaths
val Int.asString: String
    get() = Integer.toString(this)

fun Int.toString(radix: Int = 10): String = Integer.toString(this, radix)
fun Int.toUnsignedString(radix: Int = 10): String = Integer.toUnsignedString(this, radix)
val Int.asUnsignedLong: Long
    get() = Integer.toUnsignedLong(this)
val Int.value: Int
    get() = Integer.valueOf(this)

fun String.intValue(radix: Int = 10): Int = Integer.valueOf(this, radix)
// bonus
val Int.msb: Int
    get() = 31 - Integer.numberOfLeadingZeros(this)
val Int.lsb: Int
    get() {
        val res = Integer.numberOfTrailingZeros(this)
        return if (res == 32) -1 else res
    }


infix fun Long.compare(other: Long): Int = java.lang.Long.compare(this, other)
infix fun Long.compareUnsigned(other: Long): Int = java.lang.Long.compareUnsigned(this, other)
val Long.bitCount: Int
    get() = java.lang.Long.bitCount(this)
val String.decodeLong: Long
    get () = java.lang.Long.decode(this)

infix fun Long.divideUnsigned(divisor: Long): Long = java.lang.Long.divideUnsigned(this, divisor)
// we have both ::long because they have different codepaths
val String.long: Long
    get () = java.lang.Long.getLong(this)

fun String.long(default: Long): Long = java.lang.Long.getLong(this, default)
val Long.hashCode: Int
    get() = java.lang.Long.hashCode(this)
val Long.highestOneBit: Long
    get() = java.lang.Long.highestOneBit(this)
val Long.lowestOneBit: Long
    get() = java.lang.Long.lowestOneBit(this)

infix fun Long.max(other: Long): Long = java.lang.Long.max(this, other)
infix fun Long.min(other: Long): Long = java.lang.Long.min(this, other)
val Long.numberOfLeadingZeros: Int
    get() = java.lang.Long.numberOfLeadingZeros(this)
val Long.numberOfTrailingZeros: Int
    get() = java.lang.Long.numberOfTrailingZeros(this)

fun String.parseLong(radix: Int = 10): Long = java.lang.Long.parseLong(this, radix)
fun String.parseUnsignedLong(radix: Int = 10): Long = java.lang.Long.parseUnsignedLong(this, radix)
infix fun Long.remainderUnsigned(divisor: Long): Long = java.lang.Long.remainderUnsigned(this, divisor)
val Long.reverse: Long
    get() = java.lang.Long.reverse(this)
val Long.reverseBytes: Long
    get() = java.lang.Long.reverseBytes(this)

infix fun Long.rotateLeft(distance: Int): Long = java.lang.Long.rotateLeft(this, distance)
infix fun Long.rotateRight(distance: Int): Long = java.lang.Long.rotateRight(this, distance)
val Long.signum: Int
    get() = java.lang.Long.signum(this)

infix fun Long.sum(other: Long): Long = java.lang.Long.sum(this, other)
val Long.asBinaryString: String
    get() = java.lang.Long.toBinaryString(this)
val Long.asHexString: String
    get() = java.lang.Long.toHexString(this)
val Long.asOctalString: String
    get() = java.lang.Long.toOctalString(this)
// we have both asString and toString because they have different codepaths
val Long.asString: String
    get() = java.lang.Long.toString(this)

fun Long.toString(radix: Int = 10): String = java.lang.Long.toString(this, radix)
fun Long.toUnsignedString(radix: Int = 10): String = java.lang.Long.toUnsignedString(this, radix)
val Long.value: Long
    get() = java.lang.Long.valueOf(this)

fun String.longValue(radix: Int = 10): Long = java.lang.Long.valueOf(this, radix)


infix fun Float.compare(other: Float): Int = java.lang.Float.compare(this, other)
fun Float.isEqual(other: Float, maxUlps: Int): Boolean = when {
    this == other -> true
    // Different signs means they do not match.
    asIntBits < 0 != other.asIntBits < 0 ->
        mantissa.asIntBits == other.mantissa.asIntBits && exponent == other.exponent // Check for equality to make sure +0==-0
    else -> {
        // Find the difference in ULPs.
        val bits = if (asIntBits < 0) 0x80000000.i - asIntBits else asIntBits
        val otherBits = if (other.asIntBits < 0) 0x80000000.i - other.asIntBits else other.asIntBits
        val difference = if (bits > otherBits) bits - otherBits else otherBits - bits

        !isNaN && !other.isNaN && difference <= maxUlps
    }
}

val Float.asIntBits: Int
    get () = java.lang.Float.floatToIntBits(this)
val Float.asRawIntBits: Int
    get() = java.lang.Float.floatToRawIntBits(this)
val Float.hashCode: Int
    get() = java.lang.Float.hashCode(this)
val Int.bitsAsFloat: Float
    get() = java.lang.Float.intBitsToFloat(this)
val Float.isFinite: Boolean
    get() = java.lang.Float.isFinite(this)
val Float.isInfinite: Boolean
    get() = java.lang.Float.isInfinite(this)
val Float.isNaN: Boolean
    get() = java.lang.Float.isNaN(this)

infix fun Float.max(other: Float): Float = java.lang.Float.max(this, other)
infix fun Float.min(other: Float): Float = java.lang.Float.min(this, other)
val Float.asString: String
    get() = java.lang.Float.toString(this)
val Float.asHexString: String
    get() = java.lang.Float.toHexString(this)
val Float.value: Float
    get() = java.lang.Float.valueOf(this)
val String.floatValue: Float
    get() = java.lang.Float.valueOf(this)
val String.parseFloat: Float
    get() = java.lang.Float.parseFloat(this)
// bonus
val Float.ulp: Float
    get() = Math.ulp(this)
val Float.exponent: Int
    get() = Math.getExponent(this)
val Float.mantissa: Float
    get() = this / (2 pow exponent)


infix fun Double.compare(other: Double): Int = java.lang.Double.compare(this, other)
fun Double.isEqual(other: Double, maxUlps: Int): Boolean = when {
    this == other -> true
    // Different signs means they do not match.
    asLongBits < 0 != other.asLongBits < 0 ->
        mantissa == other.mantissa && exponent == other.exponent // Check for equality to make sure +0==-0
    else -> {
        // Find the difference in ULPs.
        val bits = if (asLongBits < 0) (0x8000000000000000u).toLong() - asLongBits else asLongBits
        val otherBits = if (other.asLongBits < 0) (0x8000000000000000u).toLong() - other.asLongBits else other.asLongBits
        val difference = if (bits > otherBits) bits - otherBits else otherBits - bits

        !isNaN && !other.isNaN && difference <= maxUlps
    }
}
val Double.asLongBits: Long
    get () = java.lang.Double.doubleToLongBits(this)
val Double.asRawLongBits: Long
    get() = java.lang.Double.doubleToRawLongBits(this)
val Double.hashCode: Int
    get() = java.lang.Double.hashCode(this)
val Long.bitsAsDouble: Double
    get() = java.lang.Double.longBitsToDouble(this)
val Double.isFinite: Boolean
    get() = java.lang.Double.isFinite(this)
val Double.isInfinite: Boolean
    get() = java.lang.Double.isInfinite(this)
val Double.isNaN: Boolean
    get() = java.lang.Double.isNaN(this)

infix fun Double.max(other: Double): Double = java.lang.Double.max(this, other)
infix fun Double.min(other: Double): Double = java.lang.Double.min(this, other)
val Double.asString: String
    get() = java.lang.Double.toString(this)
val Double.asHexString: String
    get() = java.lang.Double.toHexString(this)
val Double.value: Double
    get() = java.lang.Double.valueOf(this)
val String.doubleValue: Double
    get() = java.lang.Double.valueOf(this)
val String.parseDouble: Double
    get() = java.lang.Double.parseDouble(this)
// bonus
val Double.ulp: Double
    get() = Math.ulp(this)
val Double.exponent: Int
    get() = Math.getExponent(this)
val Double.mantissa: Double
    get() = this / (2 pow exponent)


// Unfortunately Jetbrain went its own way: https://youtrack.jetbrains.com/issue/KT-8247 , let's keep it coherent with Java
val Byte.Companion.BYTES: Int
    get() = java.lang.Byte.BYTES
val Float.Companion.BYTES: Int
    get() = java.lang.Float.BYTES
val Double.Companion.BYTES: Int
    get() = java.lang.Double.BYTES
val Int.Companion.BYTES: Int
    get() = Integer.BYTES
val Long.Companion.BYTES: Int
    get() = java.lang.Long.BYTES
val Short.Companion.BYTES: Int
    get() = java.lang.Short.BYTES
val Ubyte.Companion.BYTES: Int
    get() = java.lang.Byte.BYTES
val Uint.Companion.BYTES: Int
    get() = Integer.BYTES
val Ulong.Companion.BYTES: Int
    get() = java.lang.Long.BYTES
val Ushort.Companion.BYTES: Int
    get() = java.lang.Short.BYTES
val Char.Companion.BYTES: Int
    get() = Character.BYTES