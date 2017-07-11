package glm_.mat2x2

import glm_.vec2.Vec2t


abstract class Mat2x2t<T : Vec2t<*>>(open var value: MutableList<T>) {

    fun length() = 2

    // -- Accesses --

    operator fun get(i: Int) = value[i]
    operator fun get(c: Int, r: Int) = value[c][r]

    override fun toString() =
            "| ${this[0, 0]}, ${this[1, 0]} |\n" +
                    "| ${this[0, 1]}, ${this[1, 1]} |"
}