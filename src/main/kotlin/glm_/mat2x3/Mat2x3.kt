package  glm_.mat2x3

import glm_.BYTES
import glm_.set
import glm_.vec3.Vec3
import java.nio.FloatBuffer

/**
 * Created by GBarbieri on 09.12.2016.
 */

data class Mat2x3(override var value: MutableList<Vec3>) : Mat2x3t<Vec3>(value) {


    // -- Accesses --

    operator fun set(i: Int, v: Vec3) = value[i] put v

    infix fun to(dfb: FloatBuffer) = to(dfb, 0)

    fun to(dfb: FloatBuffer, offset: Int): FloatBuffer {
        dfb[offset + 0] = value[0][0]
        dfb[offset + 1] = value[0][1]
        dfb[offset + 2] = value[0][2]
        dfb[offset + 3] = value[1][0]
        dfb[offset + 4] = value[1][1]
        dfb[offset + 5] = value[1][2]
        return dfb
    }

    companion object {
        @JvmField
        val size = 2 * 3 * Float.BYTES
    }

    override fun toString() = super.toString()
}