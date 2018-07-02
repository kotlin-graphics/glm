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

var ByteBuffer.pos
    get() = position()
    set(value) {
        position(value)
    }
var ShortBuffer.pos
    get() = position()
    set(value) {
        position(value)
    }
var IntBuffer.pos
    get() = position()
    set(value) {
        position(value)
    }
var LongBuffer.pos
    get() = position()
    set(value) {
        position(value)
    }
var FloatBuffer.pos
    get() = position()
    set(value) {
        position(value)
    }
var DoubleBuffer.pos
    get() = position()
    set(value) {
        position(value)
    }
var CharBuffer.pos
    get() = position()
    set(value) {
        position(value)
    }

val ByteBuffer.cap get() = capacity()
val ShortBuffer.cap get() = capacity()
val IntBuffer.cap get() = capacity()
val LongBuffer.cap get() = capacity()
val FloatBuffer.cap get() = capacity()
val DoubleBuffer.cap get() = capacity()
val CharBuffer.cap get() = capacity()

val ByteBuffer.rem get() = remaining()
val ShortBuffer.rem get() = remaining()
val IntBuffer.rem get() = remaining()
val LongBuffer.rem get() = remaining()
val FloatBuffer.rem get() = remaining()
val DoubleBuffer.rem get() = remaining()
val CharBuffer.rem get() = remaining()