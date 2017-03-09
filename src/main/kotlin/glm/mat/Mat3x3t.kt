package  glm.mat

import  glm.vec.Vec3t

abstract interface Mat3x3t<T : Vec3t<*>> {

    var value: MutableList<T>

    fun length() = 3
}