package  glm_.mat4x2

import glm_.*
import glm_.vec2.Vec2
import glm_.vec2.Vec2t
import kool.BYTES
import kool.FloatBuffer
import kool.pos
import kool.set
import org.lwjgl.system.MemoryStack
import java.nio.ByteBuffer
import java.nio.FloatBuffer
import java.util.*

/**
 * Created by GBarbieri on 09.12.2016.
 */

class Mat4x2(var array: FloatArray) : Mat4x2t<Float>(), ToFloatBuffer {

    constructor(list: Iterable<*>, index: Int = 0) : this(FloatArray(8) { list.elementAt(index + it)!!.toFloat })

    // -- Accesses --

    override operator fun get(index: Int) = Vec2(index * 2, array)
    override operator fun get(column: Int, row: Int) = array[column * 2 + row]

    override operator fun set(column: Int, row: Int, value: Float) = array.set(column * 2 + row, value)

    override operator fun set(index: Int, value: Vec2t<out Number>) {
        array[index * 2] = value._x.f
        array[index * 2 + 1] = value._y.f
    }

    operator fun set(i: Int, v: Vec2) {
        v.to(array, i * 2)
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
                .putFloat(offset + 6 * Float.BYTES, array[6])
                .putFloat(offset + 7 * Float.BYTES, array[7])
    }

    override fun to(buf: FloatBuffer, offset: Int): FloatBuffer {
        buf[offset + 0] = array[0]
        buf[offset + 1] = array[1]
        buf[offset + 2] = array[2]
        buf[offset + 3] = array[3]
        buf[offset + 4] = array[4]
        buf[offset + 5] = array[5]
        buf[offset + 6] = array[6]
        buf[offset + 7] = array[7]
        return buf
    }

    override var a0: Float
        get() = array[0]
        set(v) = array.set(0, v)
    override var a1: Float
        get() = array[1]
        set(v) = array.set(1, v)

    override var b0: Float
        get() = array[2]
        set(v) = array.set(2, v)
    override var b1: Float
        get() = array[3]
        set(v) = array.set(3, v)

    override var c0: Float
        get() = array[4]
        set(v) = array.set(4, v)
    override var c1: Float
        get() = array[5]
        set(v) = array.set(5, v)

    override var d0: Float
        get() = array[6]
        set(v) = array.set(6, v)
    override var d1: Float
        get() = array[7]
        set(v) = array.set(7, v)


    companion object {
        const val length = Mat4x2t.length
        @JvmField
        val size = length * Float.BYTES
    }

    override fun size() = size

    override fun elementCount() = length

    override fun equals(other: Any?) = other is Mat4x2 && array.contentEquals(other.array)

    override fun hashCode() = 31 * (31 * (31 * this[0].hashCode() + this[1].hashCode()) + this[2].hashCode()) + this[3].hashCode()
}
