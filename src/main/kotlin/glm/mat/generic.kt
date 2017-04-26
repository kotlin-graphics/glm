package  glm.mat

import glm.vec2.Vec2t
import glm.vec3.Vec3t
import glm.vec4.Vec4t

/**
 * Created by GBarbieri on 08.11.2016.
 */

typealias Mat2x2 = Mat2
typealias Mat3x3 = Mat3
typealias Mat4x4 = Mat4

abstract interface Mat2x4t<T : Vec4t<*>> {

    var value: MutableList<T>

    fun length() = 2

    operator fun get(i: Int) = value[i]
}

abstract interface Mat3x2t<T : Vec2t<*>> {

    var value: MutableList<T>

    fun length() = 3

    operator fun get(i: Int) = value[i]
}

abstract interface Mat3x4t<T : Vec4t<*>> {

    var value: MutableList<T>

    fun length() = 3

    operator fun get(i: Int) = value[i]
}

abstract interface Mat4x2t<T : Vec2t<*>> {

    var value: MutableList<T>

    fun length() = 4

    operator fun get(i: Int) = value[i]
}

abstract interface Mat4x3t<T : Vec3t<*>> {

    var value: MutableList<T>

    fun length() = 4

    operator fun get(i: Int) = value[i]
}

