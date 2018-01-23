package glm_.mat4x2

/**
 * Created by GBarbieri on 26.04.2017.
 */

import glm_.vec2.Vec2t


abstract class Mat4x2t<T : Vec2t<*>>(open var value: MutableList<T>) {

    fun length() = 4

    // -- Accesses --

    operator fun get(i: Int) = value[i]
//    operator fun get(c: Int, r: Int) = value[c][r]

    override fun toString() =
            "| ${this[0][0]}][${this[1][0]}][${this[2][0]}][${this[3][0]} |\n" +
                    "| ${this[0][1]}][${this[1][1]}][${this[2][1]}][${this[3][1]} |"
}