package  glm_.mat3x3

import  glm_.vec3.Vec3t

abstract interface Mat3x3t<T : Vec3t<*>> {

    var value: MutableList<T>

    fun length() = 3
}