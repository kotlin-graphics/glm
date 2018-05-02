package  glm_.mat4x3

/**
 * Created by GBarbieri on 09.12.2016.
 */

import glm_.BYTES
import glm_.f
import glm_.set
import glm_.vec3.Vec3
import glm_.vec3.Vec3t
import java.nio.FloatBuffer
import java.util.*


class Mat4x3(dummy: Int, var array: FloatArray) : Mat4x3t<Float>() {

    // -- Accesses --

    override inline operator fun get(index: Int) = Vec3(index * 3, array)
    override inline operator fun get(c: Int, r: Int) = array[c * 3 + r]

    override inline operator fun set(c: Int, r: Int, s: Float) = array.set(c * 3 + r, s)

    override inline operator fun set(i: Int, v: Vec3t<out Number>) {
        array[i * 3] = v.x.f
        array[i * 3 + 1] = v.y.f
        array[i * 3 + 2] = v.z.f
    }

    inline operator fun set(i: Int, v: Vec3) {
        v.to(array, i * 3)
    }


    infix fun to(dfb: FloatBuffer) = to(dfb, 0)

    fun to(dfb: FloatBuffer, offset: Int): FloatBuffer {
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
        get() = array[3]
        set(v) = array.set(3, v)
    override var b1: Float
        get() = array[4]
        set(v) = array.set(4, v)
    override var b2: Float
        get() = array[5]
        set(v) = array.set(5, v)

    override var c0: Float
        get() = array[6]
        set(v) = array.set(6, v)
    override var c1: Float
        get() = array[7]
        set(v) = array.set(7, v)
    override var c2: Float
        get() = array[8]
        set(v) = array.set(8, v)

    override var d0: Float
        get() = array[9]
        set(v) = array.set(9, v)
    override var d1: Float
        get() = array[10]
        set(v) = array.set(10, v)
    override var d2: Float
        get() = array[11]
        set(v) = array.set(11, v)


    companion object {
        const val length = Mat4x3t.length
        @JvmField
        val size = length * Float.BYTES
    }

    override fun size() = size

    override fun equals(other: Any?) = other is Mat4x3 && Arrays.equals(array, other.array)

    override fun hashCode() = 31 * (31 * (31 * this[0].hashCode() + this[1].hashCode()) + this[2].hashCode()) + this[3].hashCode()
}