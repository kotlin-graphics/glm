package  glm_.mat2x3

import  glm_.vec3.Vec3t

abstract interface Mat2x3t<T : Vec3t<*>> {

    var value: MutableList<T>

    fun length() = 2

    // -- Accesses --

    operator fun get(i: Int) = value[i]
}