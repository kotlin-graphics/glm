package glm_.mat3x4

/**
 * Created by GBarbieri on 26.04.2017.
 */

import glm_.vec4.Vec4t

abstract interface Mat3x4t<T : Vec4t<*>> {

    var value: MutableList<T>

    fun length() = 3

    operator fun get(i: Int) = value[i]
}