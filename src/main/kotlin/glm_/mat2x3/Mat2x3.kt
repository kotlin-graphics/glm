package  glm_.mat2x3

import glm_.BYTES
import glm_.f
import glm_.set
import glm_.vec3.Vec3
import glm_.vec3.Vec3t
import kool.Ptr
import kool.floatBufferBig
import kool.pos
import org.lwjgl.system.MemoryStack
import org.lwjgl.system.MemoryUtil.memGetFloat
import java.nio.ByteBuffer
import java.nio.FloatBuffer
import java.util.*

/**
 * Created by GBarbieri on 09.12.2016.
 */

class Mat2x3(var array: FloatArray) : Mat2x3t<Float>() {

    // -- Accesses --

    override operator fun get(index: Int) = Vec3(index * 3, array)
    override operator fun get(column: Int, row: Int) = array[column * 3 + row]

    override operator fun set(column: Int, row: Int, value: Float) = array.set(column * 3 + row, value)

    override operator fun set(index: Int, value: Vec3t<out Number>) {
        array[index * 3] = value.x.f
        array[index * 3 + 1] = value.y.f
        array[index * 3 + 2] = value.z.f
    }

    operator fun set(i: Int, v: Vec3) {
        v.to(array, i * 3)
    }


    fun toFloatArray(): FloatArray = to(FloatArray(length), 0)
    infix fun to(floats: FloatArray): FloatArray = to(floats, 0)
    fun to(floats: FloatArray, index: Int): FloatArray {
        System.arraycopy(array, 0, floats, index, length)
        return floats
    }


    override fun to(buf: ByteBuffer, offset: Int): ByteBuffer {
        return buf
                .putFloat(offset + 0 * Float.BYTES, array[0])
                .putFloat(offset + 1 * Float.BYTES, array[1])
                .putFloat(offset + 2 * Float.BYTES, array[2])
                .putFloat(offset + 3 * Float.BYTES, array[3])
                .putFloat(offset + 4 * Float.BYTES, array[4])
                .putFloat(offset + 5 * Float.BYTES, array[5])
    }


    fun toFloatBufferStack(): FloatBuffer = to(MemoryStack.stackGet().mallocFloat(length), 0)
    infix fun toFloatBuffer(stack: MemoryStack): FloatBuffer = to(stack.mallocFloat(length), 0)
    fun toFloatBuffer(): FloatBuffer = to(floatBufferBig(length), 0)
    infix fun to(buf: FloatBuffer): FloatBuffer = to(buf, buf.pos)

    fun to(buf: FloatBuffer, offset: Int): FloatBuffer {
        buf[offset + 0] = array[0]
        buf[offset + 1] = array[1]
        buf[offset + 2] = array[2]
        buf[offset + 3] = array[3]
        buf[offset + 4] = array[4]
        buf[offset + 5] = array[5]
        return buf
    }

    override var a0: Float
        get() = array[0]
        set(v) = array.set(0, v)
    override var a1: Float
        get() = array[1]
        set(v) = array.set(1, v)
    override var a2: Float
        get() = array[2]
        set(v) = array.set(2, v)

    override var b0: Float
        get() = array[4]
        set(v) = array.set(4, v)
    override var b1: Float
        get() = array[5]
        set(v) = array.set(5, v)
    override var b2: Float
        get() = array[6]
        set(v) = array.set(6, v)


    companion object {
        const val length = Mat2x3t.length
        @JvmField
        val size = length * Float.BYTES

//        @JvmStatic TODO constructors first
//        fun fromPointer(ptr: Ptr, transpose: Boolean = false): Mat2x3 {
//            return when {
//                transpose -> Mat2x3(
//                        memGetFloat(ptr), memGetFloat(ptr + Float.BYTES * 2),
//                        memGetFloat(ptr + Float.BYTES), memGetFloat(ptr + Float.BYTES * 3))
//                else -> Mat2x3(
//                        memGetFloat(ptr), memGetFloat(ptr + Float.BYTES), memGetFloat(ptr + Float.BYTES * 2),
//                        memGetFloat(ptr + Float.BYTES * 3), memGetFloat(ptr + Float.BYTES * 4), memGetFloat(ptr + Float.BYTES * 5))
//            }
//        }
    }

    override fun size() = size

    override fun equals(other: Any?) = other is Mat2x3 && Arrays.equals(array, other.array)

    override fun hashCode() = 31 * this[0].hashCode() + this[1].hashCode()
}