package  glm_.mat4x2

import glm_.BYTES
import glm_.f
import glm_.set
import glm_.vec2.Vec2
import glm_.vec2.Vec2t
import java.nio.FloatBuffer
import java.util.*

/**
 * Created by GBarbieri on 09.12.2016.
 */

class Mat4x2(dummy: Int, var array: FloatArray) : Mat4x2t<Float>() {

    // -- Accesses --

    override inline operator fun get(index: Int) = Vec2(index * 2, array)
    override inline operator fun get(column: Int, row: Int) = array[column * 2 + row]

    override inline operator fun set(column: Int, row: Int, value: Float) = array.set(column * 2 + row, value)

    override inline operator fun set(index: Int, value: Vec2t<out Number>) {
        array[index * 2] = value.x.f
        array[index * 2 + 1] = value.y.f
    }

    inline operator fun set(i: Int, v: Vec2) {
        v.to(array, i * 2)
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
        return dfb
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

    override fun equals(other: Any?) = other is Mat4x2 && Arrays.equals(array, other.array)

    override fun hashCode() = 31 * (31 * (31 * this[0].hashCode() + this[1].hashCode()) + this[2].hashCode()) + this[3].hashCode()
}