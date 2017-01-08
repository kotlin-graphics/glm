package  mat

import vec.Vec2t

abstract interface Mat2x2t<T : Vec2t<*>> {

    var value: MutableList<T>

    fun length() = 2

    // -- Accesses --

    operator fun get(i: Int) = value[i]
}