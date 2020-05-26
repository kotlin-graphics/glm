package glm_.mat2x4

/**
 * Created by GBarbieri on 26.04.2017.
 */

import glm_.ToBuffer
import glm_.vec4.Vec4t
import java.io.PrintStream

abstract class Mat2x4t<T : Number> : ToBuffer {

    abstract var a0: T
    abstract var a1: T
    abstract var a2: T
    abstract var a3: T

    abstract var b0: T
    abstract var b1: T
    abstract var b2: T
    abstract var b3: T


    operator fun component1() = a0
    operator fun component2() = a1
    operator fun component3() = a2
    operator fun component4() = a3

    operator fun component5() = b0
    operator fun component6() = b1
    operator fun component7() = b2
    operator fun component8() = b3

    // -- Accesses --

    abstract operator fun get(index: Int): Vec4t<out Number>
    abstract operator fun get(column: Int, row: Int): T

    abstract operator fun set(index: Int, value: Vec4t<out Number>)
    abstract operator fun set(column: Int, row: Int, value: T)


    // component alias

    var v00
        @JvmName("v00") get() = a0
        @JvmName("v00") set(value) {
            a0 = value
        }
    var v01
        @JvmName("v01") get() = a1
        @JvmName("v01") set(value) {
            a1 = value
        }
    var v02
        @JvmName("v02") get() = a2
        @JvmName("v02") set(value) {
            a2 = value
        }
    var v03
        @JvmName("v03") get() = a3
        @JvmName("v03") set(value) {
            a3 = value
        }

    var v10
        @JvmName("v10") get() = b0
        @JvmName("v10") set(value) {
            b0 = value
        }
    var v11
        @JvmName("v11") get() = b1
        @JvmName("v11") set(value) {
            b1 = value
        }
    var v12
        @JvmName("v12") get() = b2
        @JvmName("v12") set(value) {
            b2 = value
        }
    var v13
        @JvmName("v13") get() = b3
        @JvmName("v13") set(value) {
            b3 = value
        }


    companion object {
        const val length = 2 * 4
    }

    @JvmOverloads
    fun print(name: String = "", stream: PrintStream = System.out) = stream.print("""$name:
        $this""")

    @JvmOverloads
    fun println(name: String = "", stream: PrintStream = System.out) = stream.println("""$name:
        $this""")

    override fun toString() = """
        $v00 $v10
        $v01 $v11
        $v02 $v12
        $v03 $v13"""

//    override fun toString() =
//            "| ${this[0][ 0]}][ ${this[1][ 0]} |\n" +
//                    "| ${this[0][ 1]}][ ${this[1][ 1]} |\n" +
//                    "| ${this[0][ 2]}][ ${this[1][ 2]} |\n" +
//                    "| ${this[0][ 3]}][ ${this[1][ 3]} |"
}