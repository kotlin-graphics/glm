package  glm_.mat4x3

/**
 * Created by GBarbieri on 09.12.2016.
 */

import glm_.BYTES
import glm_.set
import glm_.vec3.Vec3d
import java.nio.DoubleBuffer


data class Mat4x3d(override var value: MutableList<Vec3d>) : Mat4x3t<Vec3d>(value) {

    // -- Accesses --

    operator fun set(i: Int, v: Vec3d) = value[i] put v


    infix fun to(dfb: DoubleBuffer) = to(dfb, 0)

    fun to(dfb: DoubleBuffer, offset: Int): DoubleBuffer {
        dfb[offset + 0] = value[0][0]
        dfb[offset + 1] = value[0][1]
        dfb[offset + 2] = value[0][2]
        dfb[offset + 3] = value[1][0]
        dfb[offset + 4] = value[1][1]
        dfb[offset + 5] = value[1][2]
        dfb[offset + 6] = value[2][0]
        dfb[offset + 7] = value[2][1]
        dfb[offset + 8] = value[2][2]
        dfb[offset + 9] = value[3][0]
        dfb[offset + 10] = value[3][1]
        dfb[offset + 11] = value[3][2]
        return dfb
    }

    companion object {
        @JvmField val size = 4 * 3 * Double.BYTES
    }

    override fun toString() = super.toString()
}