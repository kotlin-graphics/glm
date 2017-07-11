package glm_.mat2x3

import glm_.vec3.Vec3t


abstract class Mat2x3t<T : Vec3t<*>>(open var value: MutableList<T>) {

    fun length() = 2

    // -- Accesses --

    operator fun get(i: Int) = value[i]
    operator fun get(c: Int, r: Int) = value[c][r]

    override fun toString() =
            "| ${this[0, 0]}, ${this[1, 0]} |" +
                    "| ${this[0, 1]}, ${this[1, 1]} |" +
                    "| ${this[0, 2]}, ${this[1, 2]} |"
}