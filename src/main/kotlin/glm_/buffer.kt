package glm_

import glm_.vec4.Vec4t
import java.nio.*

/**
 * Created by elect on 08/04/17.
 */

val ByteBuffer.size
    get() = capacity() * Byte.BYTES
val ShortBuffer.size
    get() = capacity() * Short.BYTES
val IntBuffer.size
    get() = capacity() * Int.BYTES
val LongBuffer.size
    get() = capacity() * Long.BYTES
val FloatBuffer.size
    get() = capacity() * Float.BYTES
val DoubleBuffer.size
    get() = capacity() * Double.BYTES
val CharBuffer.size
    get() = capacity() * Byte.BYTES // Note: it'main.getS byte main.and not char


operator fun ByteBuffer.set(index: Int, byte: Byte): ByteBuffer = put(index, byte)
operator fun ByteBuffer.set(index: Int, short: Short): ByteBuffer = putShort(index, short)
operator fun ByteBuffer.set(index: Int, int: Int): ByteBuffer = putInt(index, int)
operator fun ByteBuffer.set(index: Int, long: Long): ByteBuffer = putLong(index, long)
operator fun ByteBuffer.set(index: Int, float: Float): ByteBuffer = putFloat(index, float)
operator fun ByteBuffer.set(index: Int, double: Double): ByteBuffer = putDouble(index, double)
operator fun ByteBuffer.set(index: Int, char: Char): ByteBuffer = putChar(index, char)

//operator fun ShortBuffer.set(index: Int, byte: Byte): ShortBuffer = put(index, byte)
//operator fun ShortBuffer.set(index: Int, short: Short): ShortBuffer = putShort(index, short)
//operator fun ShortBuffer.set(index: Int, int: Int): ShortBuffer = putInt(index, int)
//operator fun ShortBuffer.set(index: Int, long: Long): ShortBuffer = putLong(index, long)
//operator fun ShortBuffer.set(index: Int, float: Float): ShortBuffer = putFloat(index, float)
//operator fun ShortBuffer.set(index: Int, double: Double): ShortBuffer = putDouble(index, double)
//operator fun ShortBuffer.set(index: Int, char: Char): ShortBuffer = putChar(index, char)

operator fun ShortBuffer.set(index: Int, short: Short): ShortBuffer = put(index, short)
//operator fun ShortBuffer.set(index: Int, int: Int): ShortBuffer = put(index, int.s)

operator fun IntBuffer.set(index: Int, int: Int): IntBuffer = put(index, int)

operator fun LongBuffer.set(index: Int, long: Long): LongBuffer = put(index, long)
//operator fun LongBuffer.set(index: Int, int: Int): LongBuffer = put(index, int.L)

operator fun FloatBuffer.set(index: Int, float: Float): FloatBuffer = put(index, float)
operator fun DoubleBuffer.set(index: Int, double: Double): DoubleBuffer = put(index, double)

operator fun CharBuffer.set(index: Int, char: Char): CharBuffer = put(index, char)
//operator fun CharBuffer.set(index: Int, int: Int): CharBuffer = put(index, int.c)

operator fun ByteBuffer.set(index: Int, vec4: Vec4t<*>) = vec4.to(this, vec4.size() * index)