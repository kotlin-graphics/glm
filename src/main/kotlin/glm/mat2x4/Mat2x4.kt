package  glm.mat2x4

import glm.BYTES
import glm.mat2x4.Mat2x4t
import  glm.vec4.Vec4

/**
 * Created by GBarbieri on 09.12.2016.
 */

data class Mat2x4(override var value: MutableList<Vec4>) : Mat2x4t<Vec4> {

    companion object {
        @JvmField val size = 2 * 4 * Float.BYTES
    }
}