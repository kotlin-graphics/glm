package glm.mat2x4

/**
 * Created by GBarbieri on 26.04.2017.
 */

import glm.vec4.Vec4t

abstract interface Mat2x4t<T : Vec4t<*>> {

    var value: MutableList<T>

    fun length() = 2

    operator fun get(i: Int) = value[i]
}