package glm_.buffer


import glm_.BYTES
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


fun Buffer.free() = MemoryUtil.memFree(this)

inline val Buffer.adr: Pointer
    get() = when (this) {
        is ByteBuffer -> MemoryUtil.memAddress(this)
        is ShortBuffer -> MemoryUtil.memAddress(this)
        is IntBuffer -> MemoryUtil.memAddress(this)
        is LongBuffer -> MemoryUtil.memAddress(this)
        is FloatBuffer -> MemoryUtil.memAddress(this)
        is DoubleBuffer -> MemoryUtil.memAddress(this)
        is CharBuffer -> MemoryUtil.memAddress(this)
        else -> throw Error("unsupported buffer type")
    }

inline val PointerBuffer.adr: Pointer
    get() = MemoryUtil.memAddress(this)


inline var Buffer.pos: Int
    get() = position()
    set(value) {
        position(value)
    }

inline val Buffer.cap: Int
    get() = capacity()

inline val Buffer.rem: Int
    get() = remaining()

inline val Buffer.remSize: Int
    get() = rem * when(this) {
        is ByteBuffer -> Byte.BYTES
        is ShortBuffer -> Short.BYTES
        is IntBuffer -> Int.BYTES
        is LongBuffer -> Long.BYTES
        is FloatBuffer -> Float.BYTES
        is DoubleBuffer -> Double.BYTES
        is CharBuffer -> Char.BYTES
        else -> throw Error("unsupported buffer type")
    }

typealias Pointer = Long // TODO -> inline class