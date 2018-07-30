package glm_.buffer


import org.lwjgl.PointerBuffer
import org.lwjgl.system.MemoryUtil
import java.nio.*

/**
 * Created by elect on 05/03/17.
 */

fun floatBufferBig(capacity: Int): FloatBuffer = MemoryUtil.memCallocFloat(capacity)

fun doubleBufferBig(capacity: Int): DoubleBuffer = MemoryUtil.memCallocDouble(capacity)

fun bufferBig(capacity: Int): ByteBuffer = MemoryUtil.memCalloc(capacity)
fun shortBufferBig(capacity: Int): ShortBuffer = MemoryUtil.memCallocShort(capacity)
fun intBufferBig(capacity: Int): IntBuffer = MemoryUtil.memCallocInt(capacity)
fun longBufferBig(capacity: Int): LongBuffer = MemoryUtil.memCallocLong(capacity)

fun charBufferBig(capacity: Int): CharBuffer = TODO()

fun pointerBufferBig(capacity: Int): PointerBuffer = MemoryUtil.memCallocPointer(capacity)
fun pointerBufferBig(capacity: IntBuffer): PointerBuffer = MemoryUtil.memCallocPointer(capacity[0])
fun pointerBufferBig(capacity: IntArray): PointerBuffer = MemoryUtil.memCallocPointer(capacity[0])


fun ByteBuffer.free() = MemoryUtil.memFree(this)
fun ShortBuffer.free() = MemoryUtil.memFree(this)
fun IntBuffer.free() = MemoryUtil.memFree(this)
fun LongBuffer.free() = MemoryUtil.memFree(this)
fun FloatBuffer.free() = MemoryUtil.memFree(this)
fun DoubleBuffer.free() = MemoryUtil.memFree(this)
fun CharBuffer.free() = MemoryUtil.memFree(this)


val ByteBuffer.adr get() = MemoryUtil.memAddress(this)
val ShortBuffer.adr get() = MemoryUtil.memAddress(this)
val IntBuffer.adr get() = MemoryUtil.memAddress(this)
val LongBuffer.adr get() = MemoryUtil.memAddress(this)
val FloatBuffer.adr get() = MemoryUtil.memAddress(this)
val DoubleBuffer.adr get() = MemoryUtil.memAddress(this)
val CharBuffer.adr get() = MemoryUtil.memAddress(this)

inline var Buffer.pos: Int
    get() = position()
    set(value) {
        position(value)
    }

inline val Buffer.cap: Int
    get() = capacity()

inline val Buffer.rem: Int
    get() = remaining()