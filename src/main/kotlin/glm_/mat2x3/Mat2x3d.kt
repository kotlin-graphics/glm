package  glm_.mat2x3

import glm_.BYTES
import glm_.d
import glm_.set
import glm_.vec3.Vec3d
import glm_.vec3.Vec3t
import java.nio.DoubleBuffer
import java.util.*

/**
 * Created by GBarbieri on 09.12.2016.
 */

class Mat2x3d(dummy: Int, var array: DoubleArray) : Mat2x3t<Double>() {

    // -- Accesses --

    override inline operator fun get(index: Int) = Vec3d(index * 3, array)
    override inline operator fun get(column: Int, row: Int) = array[column * 3 + row]

    override inline operator fun set(column: Int, row: Int, value: Double) = array.set(column * 3 + row, value)

    override inline operator fun set(index: Int, value: Vec3t<out Number>) {
        array[index * 3] = value.x.d
        array[index * 3 + 1] = value.y.d
        array[index * 3 + 2] = value.z.d
    }

    inline operator fun set(i: Int, v: Vec3d) {
        v.to(array, i * 3)
    }


    infix fun to(dfb: DoubleBuffer) = to(dfb, 0)

    fun to(dfb: DoubleBuffer, offset: Int): DoubleBuffer {
        dfb[offset + 0] = array[0]
        dfb[offset + 1] = array[1]
        dfb[offset + 2] = array[2]
        dfb[offset + 3] = array[3]
        dfb[offset + 4] = array[4]
        dfb[offset + 5] = array[5]
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

    override var b0: Double
        get() = array[4]
        set(v) = array.set(4, v)
    override var b1: Double
        get() = array[5]
        set(v) = array.set(5, v)
    override var b2: Double
        get() = array[6]
        set(v) = array.set(6, v)


    companion object {
        const val length = Mat2x3t.length
        @JvmField
        val size = length * Double.BYTES
    }

    override fun size() = size

    override fun equals(other: Any?) = other is Mat2x3d && Arrays.equals(array, other.array)

    override fun hashCode() = 31 * this[0].hashCode() + this[1].hashCode()
}