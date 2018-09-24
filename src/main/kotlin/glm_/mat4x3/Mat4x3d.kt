package  glm_.mat4x3

/**
 * Created by GBarbieri on 09.12.2016.
 */

import glm_.BYTES
import glm_.d
import glm_.set
import glm_.vec3.Vec3d
import glm_.vec3.Vec3t
import java.nio.DoubleBuffer
import java.util.*


class Mat4x3d(dummy: Int, var array: DoubleArray) : Mat4x3t<Double>() {

    // -- Accesses --

    override operator fun get(index: Int) = Vec3d(index * 3, array)
    override operator fun get(column: Int, row: Int) = array[column * 3 + row]

    override operator fun set(column: Int, row: Int, value: Double) = array.set(column * 3 + row, value)

    override operator fun set(index: Int, value: Vec3t<out Number>) {
        array[index * 3] = value.x.d
        array[index * 3 + 1] = value.y.d
        array[index * 3 + 2] = value.z.d
    }

    operator fun set(i: Int, v: Vec3d) {
        v.to(array, i * 3)
    }

    fun toDoubleArray(): DoubleArray = to(DoubleArray(length), 0)
    infix fun to(doubles: DoubleArray): DoubleArray = to(doubles, 0)
    fun to(doubles: DoubleArray, index: Int): DoubleArray {
        System.arraycopy(array, 0, doubles, index, length)
        return doubles
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

    override var b0: Double
        get() = array[3]
        set(v) = array.set(3, v)
    override var b1: Double
        get() = array[4]
        set(v) = array.set(4, v)
    override var b2: Double
        get() = array[5]
        set(v) = array.set(5, v)

    override var c0: Double
        get() = array[6]
        set(v) = array.set(6, v)
    override var c1: Double
        get() = array[7]
        set(v) = array.set(7, v)
    override var c2: Double
        get() = array[8]
        set(v) = array.set(8, v)

    override var d0: Double
        get() = array[9]
        set(v) = array.set(9, v)
    override var d1: Double
        get() = array[10]
        set(v) = array.set(10, v)
    override var d2: Double
        get() = array[11]
        set(v) = array.set(11, v)


    companion object {
        const val length = Mat4x3t.length
        @JvmField
        val size = length * Double.BYTES
    }

    override fun size() = size

    override fun equals(other: Any?) = other is Mat4x3d && Arrays.equals(array, other.array)

    override fun hashCode() = 31 * (31 * (31 * this[0].hashCode() + this[1].hashCode()) + this[2].hashCode()) + this[3].hashCode()
}