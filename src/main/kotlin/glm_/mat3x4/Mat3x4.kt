package  glm_.mat3x4

import glm_.BYTES
import glm_.set
import glm_.vec4.Vec4
import java.nio.FloatBuffer

/**
 * Created by GBarbieri on 09.12.2016.
 */

data class Mat3x4(override var value: MutableList<Vec4>) : Mat3x4t<Vec4>(value) {

    // -- Accesses --

    operator fun set(i: Int, v: Vec4) = value[i] put v

    infix fun to(dfb: FloatBuffer) = to(dfb, 0)

    fun to(dfb: FloatBuffer, offset: Int): FloatBuffer {
        dfb[offset + 0] = value[0][0]
        dfb[offset + 1] = value[0][1]
        dfb[offset + 2] = value[0][2]
        dfb[offset + 3] = value[0][3]
        dfb[offset + 4] = value[1][0]
        dfb[offset + 5] = value[1][1]
        dfb[offset + 6] = value[1][2]
        dfb[offset + 7] = value[1][3]
        dfb[offset + 8] = value[2][0]
        dfb[offset + 9] = value[2][1]
        dfb[offset + 10] = value[2][2]
        dfb[offset + 11] = value[2][3]
        return dfb
    }

    companion object {
        @JvmField val size = 3 * 4 * Float.BYTES
    }

    override fun toString() = super.toString()
}