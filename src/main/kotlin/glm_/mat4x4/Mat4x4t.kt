package  glm_.mat4x4

import  glm_.vec4.Vec4t

abstract class Mat4x4t<T : Vec4t<*>>(open var value: MutableList<T>) {

    fun length() = 4

    // -- Accesses --

    open operator fun get(i: Int) = value[i]

    override fun toString() =
            "| ${this[0][0]}][ ${this[1][0]}][ ${this[2][0]}][ ${this[3][0]} |\n" +
                    "| ${this[0][1]}][ ${this[1][1]}][ ${this[2][1]}][ ${this[3][1]} |\n" +
                    "| ${this[0][2]}][ ${this[1][2]}][ ${this[2][2]}][ ${this[3][2]} |\n" +
                    "| ${this[0][3]}][ ${this[1][3]}][ ${this[2][3]}][ ${this[3][3]} |"
}