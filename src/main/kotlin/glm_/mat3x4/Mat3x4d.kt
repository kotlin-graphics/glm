package  glm_.mat3x4

import glm_.BYTES
import glm_.d
import glm_.set
import glm_.vec4.Vec4d
import glm_.vec4.Vec4t
import java.nio.DoubleBuffer
import java.util.*

/**
 * Created by GBarbieri on 09.12.2016.
 */

class Mat3x4d(dummy: Int, var array: DoubleArray) : Mat3x4t<Double>() {

    // -- Accesses --

    override inline operator fun get(index: Int) = Vec4d(index * 4, array)
    override inline operator fun get(column: Int, row: Int) = array[column * 4 + row]

    override inline operator fun set(column: Int, row: Int, value: Double) = array.set(column * 4 + row, value)

    override inline operator fun set(index: Int, value: Vec4t<out Number>) {
        array[index * 4] = value.x.d
        array[index * 4 + 1] = value.y.d
        array[index * 4 + 2] = value.z.d
        array[index * 4 + 2] = value.w.d
    }

    inline operator fun set(i: Int, v: Vec4d) {
        v.to(array, i * 4)
    }


    infix fun to(dfb: DoubleBuffer) = to(dfb, 0)

    fun to(dfb: DoubleBuffer, offset: Int): DoubleBuffer {
        dfb[offset + 0] = array[0]
        dfb[offset + 1] = array[1]
        dfb[offset + 2] = array[2]
        dfb[offset + 3] = array[3]
        dfb[offset + 4] = array[4]
        dfb[offset + 5] = array[5]
        dfb[offset + 6] = array[6]
        dfb[offset + 7] = array[7]
        dfb[offset + 8] = array[8]
        dfb[offset + 9] = array[9]
        dfb[offset + 10] = array[10]
        dfb[offset + 11] = array[11]
        return dfb
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

    override fun equals(other: Any?) = other is Mat3x4d && Arrays.equals(array, other.array)

    override fun hashCode() = 31 * this[0].hashCode() + this[1].hashCode()
}