package  glm.mat4x3

import glm.BYTES
import  glm.vec3.Vec3

/**
 * Created by GBarbieri on 09.12.2016.
 */

import glm.mat4x3.Mat4x3


data class Mat4x3(override var value: MutableList<Vec3>) : Mat4x3t<Vec3> {

    companion object {
        @JvmField val size = 4 * 3 * Float.BYTES
    }
}