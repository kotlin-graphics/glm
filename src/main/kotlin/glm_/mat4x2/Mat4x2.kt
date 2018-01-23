package  glm_.mat4x2

import glm_.BYTES
import glm_.set
import glm_.vec2.Vec2
import java.nio.FloatBuffer

/**
 * Created by GBarbieri on 09.12.2016.
 */

data class Mat4x2(override var value: MutableList<Vec2>) : Mat4x2t<Vec2>(value) {

    // -- Accesses --

    operator fun set(i: Int, v: Vec2) = value[i] put v
    operator fun set(c: Int, r: Int, v: Float) {
        value[c][r] = v
    }
    operator fun get(c: Int, r: Int) = value[c][r]


    infix fun to(dfb: FloatBuffer) = to(dfb, 0)

    fun to(dfb: FloatBuffer, offset: Int): FloatBuffer {
        dfb[offset + 0] = value[0][0]
        dfb[offset + 1] = value[0][1]
        dfb[offset + 2] = value[1][0]
        dfb[offset + 3] = value[1][1]
        dfb[offset + 4] = value[2][0]
        dfb[offset + 5] = value[2][1]
        dfb[offset + 6] = value[3][0]
        dfb[offset + 7] = value[3][1]
        return dfb
    }

    companion object {
        @JvmField
        val size = 4 * 2 * Float.BYTES
    }

    override fun toString() = super.toString()
}