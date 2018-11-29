package  glm_.mat4x2

import glm_.*
import glm_.vec2.Vec2d
import glm_.vec2.Vec2t
import kool.DoubleBuffer
import kool.pos
import org.lwjgl.system.MemoryStack
import java.nio.ByteBuffer
import java.nio.DoubleBuffer
import java.util.*

/**
 * Created by GBarbieri on 09.12.2016.
 */

class Mat4x2d(var array: DoubleArray) : Mat4x2t<Double>(), ToDoubleBuffer {

    constructor(list: Iterable<*>, index: Int = 0) : this(DoubleArray(8) { list.elementAt(index + it)!!.toDouble })

    // -- Accesses --

    override operator fun get(index: Int) = Vec2d(index * 2, array)
    override operator fun get(column: Int, row: Int) = array[column * 2 + row]

    override operator fun set(column: Int, row: Int, value: Double) = array.set(column * 2 + row, value)

    override operator fun set(index: Int, value: Vec2t<out Number>) {
        array[index * 2] = value.x.d
        array[index * 2 + 1] = value.y.d
    }

    operator fun set(i: Int, v: Vec2d) {
        v.to(array, i * 2)
    }

    fun toDoubleArray(): DoubleArray = to(DoubleArray(length), 0)
    infix fun to(doubles: DoubleArray): DoubleArray = to(doubles, 0)
    fun to(doubles: DoubleArray, index: Int): DoubleArray {
        System.arraycopy(array, 0, doubles, index, length)
        return doubles
    }

    override fun to(buf: ByteBuffer, offset: Int): ByteBuffer {
        return buf
                .putDouble(offset + 0 * Double.BYTES, array[0])
                .putDouble(offset + 1 * Double.BYTES, array[1])
                .putDouble(offset + 2 * Double.BYTES, array[2])
                .putDouble(offset + 3 * Double.BYTES, array[3])
                .putDouble(offset + 4 * Double.BYTES, array[4])
                .putDouble(offset + 5 * Double.BYTES, array[5])
                .putDouble(offset + 6 * Double.BYTES, array[6])
                .putDouble(offset + 7 * Double.BYTES, array[7])
    }

    override fun to(buf: DoubleBuffer, offset: Int): DoubleBuffer {
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

    override var a0: Double
        get() = array[0]
        set(v) = array.set(0, v)
    override var a1: Double
        get() = array[1]
        set(v) = array.set(1, v)

    override var b0: Double
        get() = array[2]
        set(v) = array.set(2, v)
    override var b1: Double
        get() = array[3]
        set(v) = array.set(3, v)

    override var c0: Double
        get() = array[4]
        set(v) = array.set(4, v)
    override var c1: Double
        get() = array[5]
        set(v) = array.set(5, v)

    override var d0: Double
        get() = array[6]
        set(v) = array.set(6, v)
    override var d1: Double
        get() = array[7]
        set(v) = array.set(7, v)


    companion object {
        const val length = Mat4x2t.length
        @JvmField
        val size = length * Double.BYTES
    }

    override fun size() = size

    override fun elementCount() = length

    override fun equals(other: Any?) = other is Mat4x2d && Arrays.equals(array, other.array)

    override fun hashCode() = 31 * (31 * (31 * this[0].hashCode() + this[1].hashCode()) + this[2].hashCode()) + this[3].hashCode()
}