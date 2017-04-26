package  glm.mat3x3

import  glm.vec3.Vec3t

abstract interface Mat3x3t<T : Vec3t<*>> {

    var value: MutableList<T>

    fun length() = 3
}