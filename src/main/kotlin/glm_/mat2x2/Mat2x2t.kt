package  glm_.mat2x2

import glm_.vec2.Vec2t

abstract interface Mat2x2t<T : Vec2t<*>> {

    var value: MutableList<T>

    fun length() = 2

    // -- Accesses --

    operator fun get(i: Int) = value[i]
}