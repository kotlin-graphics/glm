package glm_

import unsigned.Ubyte
import unsigned.Uint
import unsigned.Ulong
import unsigned.Ushort


infix fun Byte.compare(other: Byte) = java.lang.Byte.compare(this, other)
val String.decodeByte get () = java.lang.Byte.decode(this)
val Byte.hashCode get() = java.lang.Byte.hashCode(this)
val String.parseByte get() = java.lang.Byte.parseByte(this)
fun String.parseByte(radix: Int) = java.lang.Byte.parseByte(this, radix)
val Byte.toString get() = java.lang.Byte.toString(this)
val Byte.toUnsignedInt get() = java.lang.Byte.toUnsignedInt(this)
val Byte.toUnsignedLong get() = java.lang.Byte.toUnsignedLong(this)
val Byte.value get() = java.lang.Byte.valueOf(this)
val String.byteValue get() = java.lang.Byte.valueOf(this)
fun String.byteValue(radix: Int) = java.lang.Byte.valueOf(this, radix)


infix fun Short.compare(other: Short) = java.lang.Short.compare(this, other)
val String.decodeShort get () = java.lang.Short.decode(this)
val Short.hashCode get() = java.lang.Short.hashCode(this)
val String.parseShort get() = java.lang.Short.parseShort(this)
fun String.parseShort(radix: Int) = java.lang.Short.parseShort(this, radix)
val Short.reverseBytes get() = java.lang.Short.reverseBytes(this)
val Short.toString get() = java.lang.Short.toString(this)
val Short.toUnsignedInt get() = java.lang.Short.toUnsignedInt(this)
val Short.toUnsignedLong get() = java.lang.Short.toUnsignedLong(this)
val Short.value get() = java.lang.Short.valueOf(this)
val String.shortValue get() = java.lang.Short.valueOf(this)
fun String.shortValue(radix: Int) = java.lang.Short.valueOf(this, radix)


infix fun Int.compare(other: Int) = java.lang.Integer.compare(this, other)
infix fun Int.compareUnsigned(other: Int) = java.lang.Integer.compareUnsigned(this, other)
val Int.bitCount get() = java.lang.Integer.bitCount(this)
val String.decondeInt get () = java.lang.Integer.decode(this)
infix fun Int.divideUnsigned(divisor: Int) = java.lang.Integer.divideUnsigned(this, divisor)
val String.integer get () = java.lang.Integer.getInteger(this)
fun String.integer(value: Int) = java.lang.Integer.getInteger(this, value)
val Int.hashCode get() = java.lang.Integer.hashCode(this)
val Int.highestOneBit get() = java.lang.Integer.highestOneBit(this)
val Int.lowestOneBit get() = java.lang.Integer.lowestOneBit(this)
infix fun Int.max(other: Int) = java.lang.Integer.max(this, other)
infix fun Int.min(other: Int) = java.lang.Integer.min(this, other)
val Int.numberOfLeadingZeros get() = java.lang.Integer.numberOfLeadingZeros(this)
val Int.numberOfTrailingZeros get() = java.lang.Integer.numberOfTrailingZeros(this)
val String.parseInt get() = java.lang.Integer.parseInt(this)
fun String.parseInt(radix: Int) = java.lang.Integer.parseInt(this, radix)
val String.parseUnsignedInt get() = java.lang.Integer.parseUnsignedInt(this)
fun String.parseUnsignedInt(radix: Int) = java.lang.Integer.parseUnsignedInt(this, radix)
infix fun Int.remainderUnsigned(divisor: Int) = java.lang.Integer.remainderUnsigned(this, divisor)
val Int.reverse get() = java.lang.Integer.reverse(this)
val Int.reverseBytes get() = java.lang.Integer.reverseBytes(this)
infix fun Int.rotateLeft(distance: Int) = java.lang.Integer.rotateLeft(this, distance)
infix fun Int.rotateRight(distance: Int) = java.lang.Integer.rotateRight(this, distance)
val Int.signum get() = java.lang.Integer.signum(this)
infix fun Int.sum(other: Int) = java.lang.Integer.sum(this, other)
val Int.toBinaryString get() = java.lang.Integer.toBinaryString(this)
val Int.toHexString get() = java.lang.Integer.toHexString(this)
val Int.toOctalString get() = java.lang.Integer.toOctalString(this)
val Int.toString get() = java.lang.Integer.toString(this)
fun Int.toString(radix: Int) = java.lang.Integer.toString(this, radix)
val Int.toUnsignedLong get() = java.lang.Integer.toUnsignedLong(this)
val Int.value get() = java.lang.Integer.valueOf(this)
val String.intValue get() = java.lang.Integer.valueOf(this)
fun String.intValue(radix: Int) = java.lang.Integer.valueOf(this, radix)

// bonus
val Int.msb get() = 31 - java.lang.Integer.numberOfLeadingZeros(this)
val Int.lsb: Int
    get() {
        val res = java.lang.Integer.numberOfTrailingZeros(this)
        return if (res == 32) -1 else res
    }


infix fun Long.compare(other: Long) = java.lang.Long.compare(this, other)
infix fun Long.compareUnsigned(other: Long) = java.lang.Long.compareUnsigned(this, other)
val Long.bitCount get() = java.lang.Long.bitCount(this)
val String.decodeLong get () = java.lang.Long.decode(this)
infix fun Long.divideUnsigned(divisor: Long) = java.lang.Long.divideUnsigned(this, divisor)
val String.long get () = java.lang.Long.getLong(this)
fun String.long(value: Long) = java.lang.Long.getLong(this, value)
val Long.hashCode get() = java.lang.Long.hashCode(this)
val Long.highestOneBit get() = java.lang.Long.highestOneBit(this)
val Long.lowestOneBit get() = java.lang.Long.lowestOneBit(this)
infix fun Long.max(other: Long) = java.lang.Long.max(this, other)
infix fun Long.min(other: Long) = java.lang.Long.min(this, other)
val Long.numberOfLeadingZeros get() = java.lang.Long.numberOfLeadingZeros(this)
val Long.numberOfTrailingZeros get() = java.lang.Long.numberOfTrailingZeros(this)
val String.parseLong get() = java.lang.Long.parseLong(this)
fun String.parseLong(radix: Int) = java.lang.Long.parseLong(this, radix)
val String.parseUnsignedLong get() = java.lang.Long.parseUnsignedLong(this)

fun String.parseUnsignedLong(radix: Int) = java.lang.Long.parseUnsignedLong(this, radix)
infix fun Long.remainderUnsigned(divisor: Long) = java.lang.Long.remainderUnsigned(this, divisor)
val Long.reverse get() = java.lang.Long.reverse(this)
val Long.reverseBytes get() = java.lang.Long.reverseBytes(this)
infix fun Long.rotateLeft(distance: Int) = java.lang.Long.rotateLeft(this, distance)
infix fun Long.rotateRight(distance: Int) = java.lang.Long.rotateRight(this, distance)
val Long.signum get() = java.lang.Long.signum(this)
infix fun Long.sum(other: Long) = java.lang.Long.sum(this, other)
val Long.toBinaryString get() = java.lang.Long.toBinaryString(this)
val Long.toHexString get() = java.lang.Long.toHexString(this)
val Long.toOctalString get() = java.lang.Long.toOctalString(this)
val Long.toString get() = java.lang.Long.toString(this)
fun Long.toString(radix: Int) = java.lang.Long.toString(this, radix)
val Long.toUnsignedLong get() = java.lang.Long.toUnsignedString(this)
fun Long.toUnsignedLong(radix: Int) = java.lang.Long.toUnsignedString(this, radix)
val Long.value get() = java.lang.Long.valueOf(this)
val String.longValue get() = java.lang.Long.valueOf(this)
fun String.longValue(radix: Int) = java.lang.Long.valueOf(this, radix)


infix fun Float.compare(other: Float) = java.lang.Float.compare(this, other)
val Float.toIntBits get () = java.lang.Float.floatToIntBits(this)
val Float.toRawIntBits get() = java.lang.Float.floatToRawIntBits(this)
val Float.hashCode get() = java.lang.Float.hashCode(this)
val Int.bitsToFloat get() = java.lang.Float.intBitsToFloat(this)
val Float.isFinite get() = java.lang.Float.isFinite(this)
val Float.isInfinite get() = java.lang.Float.isInfinite(this)
val Float.isNaN get() = java.lang.Float.isNaN(this)
infix fun Float.max(other: Float) = java.lang.Float.max(this, other)
infix fun Float.min(other: Float) = java.lang.Float.min(this, other)
val Float.toString get() = java.lang.Float.toString(this)
val Float.toHexString get() = java.lang.Float.toHexString(this)
val Float.value get() = java.lang.Float.valueOf(this)
val String.floatValue get() = java.lang.Float.valueOf(this)
val String.parseFloat get() = java.lang.Float.parseFloat(this)


infix fun Double.compare(other: Double) = java.lang.Double.compare(this, other)
val Double.toLongBits get () = java.lang.Double.doubleToLongBits(this)
val Double.toRawLongBits get() = java.lang.Double.doubleToRawLongBits(this)
val Double.hashCode get() = java.lang.Double.hashCode(this)
val Long.bitsToDouble get() = java.lang.Double.longBitsToDouble(this)
val Double.isFinite get() = java.lang.Double.isFinite(this)
val Double.isInfinite get() = java.lang.Double.isInfinite(this)
val Double.isNaN get() = java.lang.Double.isNaN(this)
infix fun Double.max(other: Double) = java.lang.Double.max(this, other)
infix fun Double.min(other: Double) = java.lang.Double.min(this, other)
val Double.toString get() = java.lang.Double.toString(this)
val Double.toHexString get() = java.lang.Double.toHexString(this)
val Double.value get() = java.lang.Double.valueOf(this)
val String.doubleValue get() = java.lang.Double.valueOf(this)
val String.parseDouble get() = java.lang.Double.parseDouble(this)


// TODO check https://youtrack.jetbrains.com/issue/KT-8247
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