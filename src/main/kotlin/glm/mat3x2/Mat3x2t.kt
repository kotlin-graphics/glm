package glm.mat3x2

/**
 * Created by GBarbieri on 26.04.2017.
 */

import glm.vec2.Vec2t

abstract interface Mat3x2t<T : Vec2t<*>> {

    var value: MutableList<T>

    fun length() = 3

    operator fun get(i: Int) = value[i]
}