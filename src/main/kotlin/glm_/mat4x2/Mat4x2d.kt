package  glm_.mat4x2

import glm_.BYTES
import glm_.set
import glm_.vec2.Vec2d
import java.nio.DoubleBuffer

/**
 * Created by GBarbieri on 09.12.2016.
 */

data class Mat4x2d(override var value: MutableList<Vec2d>) : Mat4x2t<Vec2d> {

    // -- Accesses --

    override operator fun get(i: Int) = value[i]

    operator fun set(i: Int, v: Vec2d) = value[i] put v


    infix fun to(dfb: DoubleBuffer) = to(dfb, 0)

    fun to(dfb: DoubleBuffer, offset: Int): DoubleBuffer {
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
        @JvmField val size = 4 * 2 * Double.BYTES
    }
}