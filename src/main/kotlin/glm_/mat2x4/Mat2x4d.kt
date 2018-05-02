package  glm_.mat2x4

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

class Mat2x4d(dummy: Int, var array: DoubleArray) : Mat2x4t<Double>() {

    // -- Accesses --

    override inline operator fun get(index: Int) = Vec4d(index * 4, array)
    override inline operator fun get(c: Int, r: Int) = array[c * 4 + r]

    override inline operator fun set(c: Int, r: Int, s: Double) = array.set(c * 4 + r, s)

    override inline operator fun set(i: Int, v: Vec4t<out Number>) {
        array[i * 4] = v.x.d
        array[i * 4 + 1] = v.y.d
        array[i * 4 + 2] = v.z.d
        array[i * 4 + 2] = v.w.d
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


    companion object {
        const val length = Mat2x4t.length
        @JvmField
        val size = length * Double.BYTES
    }

    override fun size() = size

    override fun equals(other: Any?) = other is Mat2x4d && Arrays.equals(array, other.array)

    override fun hashCode() = 31 * this[0].hashCode() + this[1].hashCode()
}