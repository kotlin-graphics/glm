package glm_.mat2x4

/**
 * Created by GBarbieri on 26.04.2017.
 */

import glm_.vec4.Vec4t

abstract class Mat2x4t<T : Vec4t<*>>(open var value: MutableList<T>) {

    fun length() = 2

    // -- Accesses --

    open operator fun get(i: Int) = value[i]
//    operator fun get(c: Int, r: Int) = value[c][r]

    override fun toString() =
            "| ${this[0][ 0]}][ ${this[1][ 0]} |\n" +
                    "| ${this[0][ 1]}][ ${this[1][ 1]} |\n" +
                    "| ${this[0][ 2]}][ ${this[1][ 2]} |\n" +
                    "| ${this[0][ 3]}][ ${this[1][ 3]} |"
}