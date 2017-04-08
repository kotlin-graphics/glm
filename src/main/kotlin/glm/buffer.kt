package glm

import glm.vec.Vec4t
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
operator fun ShortBuffer.set(index: Int, short: Short): ShortBuffer = put(index, short)
operator fun IntBuffer.set(index: Int, int: Int): IntBuffer = put(index, int)
operator fun LongBuffer.set(index: Int, long: Long): LongBuffer = put(index, long)

operator fun FloatBuffer.set(index: Int, float: Float): FloatBuffer = put(index, float)
operator fun DoubleBuffer.set(index: Int, double: Double): DoubleBuffer = put(index, double)

operator fun CharBuffer.set(index: Int, char: Char): CharBuffer = put(index, char)

operator fun ByteBuffer.set(index: Int, vec4: Vec4t<*>) =  vec4.to(this, index)