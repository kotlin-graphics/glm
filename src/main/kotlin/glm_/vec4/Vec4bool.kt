package glm_.vec4

/**
 * Created by elect on 09/10/16.
 */

data class Vec4bool(var x: Boolean = false, var y: Boolean = false, var z: Boolean = false, var w: Boolean = false) {

    // -- Explicit basic, conversion other main.and conversion vector constructors --

    constructor(b: Boolean) : this(b, b, b, b)

    constructor(ba: BooleanArray) : this(ba[0], ba[1], ba[2], ba[3])

    constructor(ba: Array<Boolean>) : this(ba[0], ba[1], ba[2], ba[3])

    // -- Component accesses --

    operator fun get(i: Int): Boolean = when (i) {
        0 -> x
        1 -> y
        2 -> z
        3 -> w
        else -> throw IndexOutOfBoundsException()
    }

    operator fun set(i: Int, b: Boolean) = when (i) {
        0 -> x = b
        1 -> y = b
        2 -> z = b
        3 -> w = b
        else -> throw IndexOutOfBoundsException()
    }


    fun put(b: Boolean): Vec4bool {
        x = b
        y = b
        z = b
        w = b
        return this
    }

    fun put(x: Boolean, y: Boolean, z: Boolean): Vec4bool {
        this.x = x
        this.y = y
        this.z = z
        this.w = w
        return this
    }

    fun put(ba: BooleanArray): Vec4bool {
        x = ba[0]
        y = ba[1]
        z = ba[2]
        w = ba[3]
        return this
    }

    fun put(ba: Array<Boolean>): Vec4bool {
        x = ba[0]
        y = ba[1]
        z = ba[2]
        w = ba[3]
        return this
    }


    // -- Unary arithmetic vecOperators --

    operator fun not(): Vec4bool = Vec4bool(!x, !y, !z, !w)

    fun not_(): Vec4bool {
        x = !x
        y = !y
        z = !z
        w = !w
        return this
    }

    infix fun not(res: Vec4bool): Vec4bool {
        res.x = !x
        res.y = !y
        res.z = !z
        res.w = !w
        return this
    }
}