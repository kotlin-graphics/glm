package glm_.mat3x4

import glm_.vec4.Vec4t

/**
 * Created by GBarbieri on 26.04.2017.
 */


abstract class Mat3x4t<T : Number> {

    abstract var a0: T
    abstract var a1: T
    abstract var a2: T
    abstract var a3: T

    abstract var b0: T
    abstract var b1: T
    abstract var b2: T
    abstract var b3: T

    abstract var c0: T
    abstract var c1: T
    abstract var c2: T
    abstract var c3: T


    operator fun component1() = a0
    operator fun component2() = a1
    operator fun component3() = a2
    operator fun component4() = a3

    operator fun component5() = b0
    operator fun component6() = b1
    operator fun component7() = b2
    operator fun component8() = b3

    operator fun component9() = c0
    operator fun component10() = c1
    operator fun component11() = c2
    operator fun component12() = c3

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

    var v20
        @JvmName("v20") get() = c0
        @JvmName("v20") set(value) {
            c0 = value
        }
    var v21
        @JvmName("v21") get() = c1
        @JvmName("v21") set(value) {
            c1 = value
        }
    var v22
        @JvmName("v22") get() = c2
        @JvmName("v22") set(value) {
            c2 = value
        }
    var v23
        @JvmName("v23") get() = c3
        @JvmName("v23") set(value) {
            c3 = value
        }

    abstract fun size(): Int

    companion object {
        const val length = 3 * 4
    }

//    override fun toString() =
//            "| ${this[0][0]}][${this[1][0]}][${this[2][0]} |\n" +
//                    "| ${this[0][1]}][${this[1][1]}][${this[2][1]} |\n" +
//                    "| ${this[0][2]}][${this[1][2]}][${this[2][2]} |\n" +
//                    "| ${this[0][3]}][${this[1][3]}][${this[2][3]} |"
}