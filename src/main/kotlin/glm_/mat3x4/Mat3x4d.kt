package  glm_.mat3x4

import glm_.*
import glm_.vec4.Vec4d
import glm_.vec4.Vec4t
import kool.BYTES
import kool.set
import java.nio.ByteBuffer
import java.nio.DoubleBuffer
import java.util.*

/**
 * Created by GBarbieri on 09.12.2016.
 */

class Mat3x4d(var array: DoubleArray) : Mat3x4t<Double>(), ToDoubleBuffer {

    constructor(list: Iterable<*>, index: Int = 0) : this(DoubleArray(12) { list.elementAt(index + it)!!.toDouble })

    // -- Accesses --

    override operator fun get(index: Int) = Vec4d(index * 4, array)
    override operator fun get(column: Int, row: Int) = array[column * 4 + row]

    override operator fun set(column: Int, row: Int, value: Double) = array.set(column * 4 + row, value)

    override operator fun set(index: Int, value: Vec4t<out Number>) {
        array[index * 4] = value._x.d
        array[index * 4 + 1] = value._y.d
        array[index * 4 + 2] = value._z.d
        array[index * 4 + 2] = value._w.d
    }

    operator fun set(i: Int, v: Vec4d) {
        v.to(array, i * 4)
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
                .putDouble(offset + 8 * Double.BYTES, array[8])
                .putDouble(offset + 9 * Double.BYTES, array[9])
                .putDouble(offset + 10 * Double.BYTES, array[10])
                .putDouble(offset + 11 * Double.BYTES, array[11])
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
        buf[offset + 8] = array[8]
        buf[offset + 9] = array[9]
        buf[offset + 10] = array[10]
        buf[offset + 11] = array[11]
        return buf
    }

    override var a0: Double
        get() = array[0]
        set(v) = array.set(0, v)
    override var a1: Double
        get() = array[1]
        set(v) = array.set(1, v)
    override var a2: Double
        get() = array[2]
        set(v) = array.set(2, v)
    override var a3: Double
        get() = array[3]
        set(v) = array.set(3, v)

    override var b0: Double
        get() = array[4]
        set(v) = array.set(4, v)
    override var b1: Double
        get() = array[5]
        set(v) = array.set(5, v)
    override var b2: Double
        get() = array[6]
        set(v) = array.set(6, v)
    override var b3: Double
        get() = array[7]
        set(v) = array.set(7, v)

    override var c0: Double
        get() = array[8]
        set(v) = array.set(8, v)
    override var c1: Double
        get() = array[9]
        set(v) = array.set(9, v)
    override var c2: Double
        get() = array[10]
        set(v) = array.set(10, v)
    override var c3: Double
        get() = array[11]
        set(v) = array.set(11, v)


    companion object {
        const val length = Mat3x4t.length
        @JvmField
        val size = length * Double.BYTES
    }

    override fun size() = size

    override fun elementCount() = length

    override fun equals(other: Any?) = other is Mat3x4d && array.contentEquals(other.array)

    override fun hashCode() = 31 * this[0].hashCode() + this[1].hashCode()
}
