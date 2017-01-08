package  mat

import  vec.Vec3t

abstract interface Mat2x3t<T : Vec3t<*>> {

    var value: MutableList<T>

    fun length() = 2

    // -- Accesses --

    operator fun get(i: Int) = value[i]
}