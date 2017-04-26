package glm

import unsigned.Ubyte
import unsigned.Uint
import unsigned.Ulong
import unsigned.Ushort

/**
 * Created by GBarbieri on 13.12.2016.
 */

fun Float.Companion.intBitsToFloat(bits: Int) = java.lang.Float.intBitsToFloat(bits)
fun Double.Companion.longBitsToDouble(bits: Long) = java.lang.Double.longBitsToDouble(bits)

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