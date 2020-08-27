package glm_

import kool.*
import org.lwjgl.system.MemoryStack
import java.nio.*

interface ToBuffer {

    fun toBufferStack(): ByteBuffer = to(MemoryStack.stackGet().malloc(size()))
    infix fun toBuffer(stack: MemoryStack): ByteBuffer = to(stack.malloc(size()))
    fun toBuffer(): ByteBuffer = to(Buffer(size()))
    infix fun to(buf: ByteBuffer): ByteBuffer = to(buf, buf.pos)

    fun to(buf: ByteBuffer, offset: Int = 0): ByteBuffer

    /**
     * The size of the object in bytes
     */
    fun size(): Int

    val size: Int
        get() = 0
}

/**
 * copies all elements of the list into the buffer. This assumes all elements in the list have the same size
 */
fun List<ToBuffer>.to(buf: ByteBuffer): ByteBuffer {
    this.forEachIndexed { index, value ->
        val targetOffset = buf.pos + index * value.size()
        value.to(buf, targetOffset)
    }
    return buf
}

/**
 * Creates a new ByteBuffer containing all elements of the list.
 *
 * @param assumeConstSize if this is true, it assumes all elements have the same size, otherwise the size of
 *              the buffer is calculated by first summing the size of all elements
 */
fun List<ToBuffer>.toBuffer(assumeConstSize: Boolean = true): ByteBuffer {

    if (this.isEmpty()) return Buffer(0)

    val totalSize = if (assumeConstSize) this.first().size() * this.size else this.sumBy { it.size() }

    val buffer = Buffer(totalSize)
    this.to(buffer)

    return buffer
}

interface ToFloatBuffer : ToBuffer {

    fun toFloatBufferStack(): FloatBuffer = to(MemoryStack.stackGet().mallocFloat(elementCount()), 0)
    infix fun toFloatBuffer(stack: MemoryStack): FloatBuffer = to(stack.mallocFloat(elementCount()), 0)
    fun toFloatBuffer(): FloatBuffer = to(FloatBuffer(elementCount()), 0)
    infix fun to(buf: FloatBuffer): FloatBuffer = to(buf, buf.pos)

    fun to(buf: FloatBuffer, offset: Int): FloatBuffer

    /**
     * The size of the object in number of floats.
     *
     * Also see [ToBuffer.size]
     */
    fun elementCount(): Int     // HINT this can not be called length, as it would conflict with Vec.lengt() which is more important
}

/**
 * copies all elements of the list into the buffer. This assumes all elements in the list have the same size
 */
fun List<ToFloatBuffer>.to(buf: FloatBuffer): FloatBuffer {
    this.forEachIndexed { index, value ->
        val targetOffset = buf.pos + index * value.elementCount()
        value.to(buf, targetOffset)
    }
    return buf
}

/**
 * Creates a new FloatBuffer containing all elements of the list.
 *
 * @param assumeConstSize if this is true, it assumes all elements have the same size, otherwise the size of
 *              the buffer is calculated by first summing the size of all elements
 */
fun List<ToFloatBuffer>.toFloatBuffer(assumeConstSize: Boolean = true): FloatBuffer {

    if (this.isEmpty()) return FloatBuffer(0)

    val totalSize = if (assumeConstSize) this.first().elementCount() * this.size else this.sumBy { it.elementCount() }

    val buffer = FloatBuffer(totalSize)
    this.to(buffer)

    return buffer
}

interface ToDoubleBuffer : ToBuffer {

    fun toDoubleBufferStack(): DoubleBuffer = to(MemoryStack.stackGet().mallocDouble(elementCount()), 0)
    infix fun toDoubleBuffer(stack: MemoryStack): DoubleBuffer = to(stack.mallocDouble(elementCount()), 0)
    fun toDoubleBuffer(): DoubleBuffer = to(DoubleBuffer.allocate(elementCount()), 0)
    infix fun to(buf: DoubleBuffer): DoubleBuffer = to(buf, buf.pos)

    fun to(buf: DoubleBuffer, offset: Int): DoubleBuffer

    /**
     * The size of the object in number of doubles.
     *
     * Also see [ToBuffer.size]
     */
    fun elementCount(): Int    // HINT this can not be called length, as it would conflict with Vec.lengt() which is more important
}

/**
 * copies all elements of the list into the buffer. This assumes all elements in the list have the same size
 */
fun List<ToDoubleBuffer>.to(buf: DoubleBuffer): DoubleBuffer {
    this.forEachIndexed { index, value ->
        val targetOffset = buf.pos + index * value.elementCount()
        value.to(buf, targetOffset)
    }
    return buf
}

/**
 * Creates a new DoubleBuffer containing all elements of the list.
 *
 * @param assumeConstSize if this is true, it assumes all elements have the same size, otherwise the size of
 *              the buffer is calculated by first summing the size of all elements
 */
fun List<ToDoubleBuffer>.toDoubleBuffer(assumeConstSize: Boolean = true): DoubleBuffer {

    if (this.isEmpty()) return DoubleBuffer(0)

    val totalSize = if (assumeConstSize) this.first().elementCount() * this.size else this.sumBy { it.elementCount() }

    val buffer = DoubleBuffer(totalSize)
    this.to(buffer)

    return buffer
}