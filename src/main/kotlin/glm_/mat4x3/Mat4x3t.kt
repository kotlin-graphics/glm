package glm_.mat4x3

/**
 * Created by GBarbieri on 26.04.2017.
 */

import glm_.vec3.Vec3t

abstract interface Mat4x3t<T : Vec3t<*>> {

    var value: MutableList<T>

    fun length() = 4

    operator fun get(i: Int) = value[i]
}