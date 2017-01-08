package vec.bool

/**
 * Created by elect on 08/10/16.
 */

data class Vec3bool(var x: Boolean = false, var y: Boolean = false, var z: Boolean = false) {

    // -- Explicit basic, conversion other and conversion vector constructors --

    constructor(b: Boolean) : this(b, b, b)

    constructor(ba: BooleanArray) : this(ba[0], ba[1], ba[2])

    constructor(ba: Array<Boolean>) : this(ba[0], ba[1], ba[2])

    // -- Component accesses --

    operator fun get(i: Int): Boolean = when (i) {0 -> x; 1 -> y; else -> z; }

    operator fun set(i: Int, b: Boolean) = when (i) {0 -> x = b; 1 -> y = b; else -> z = b; }


    fun set(b: Boolean): Vec3bool {
        x = b; y = b; z = b; return this
    }

    fun set(x: Boolean, y: Boolean, z: Boolean): Vec3bool {
        this.x = x; this.y = y; this.z = z; return this
    }

    fun set(ba: BooleanArray): Vec3bool {
        x = ba[0]; y = ba[1]; z = ba[2]; return this
    }

    fun set(ba: Array<Boolean>): Vec3bool {
        x = ba[0]; y = ba[1]; z = ba[2]; return this
    }


    // -- Unary arithmetic vecOperators --

    operator fun not(): Vec3bool = Vec3bool(x = !x, y = !y, z = !z)

    fun notAss(): Vec3bool {
        x = !x
        y = !y
        z = !z
        return this
    }

    infix fun not(res: Vec3bool): Vec3bool {
        res.x = !x; res.y = !y; res.z = !z; return this
    }

    fun all() = x && y && z
}