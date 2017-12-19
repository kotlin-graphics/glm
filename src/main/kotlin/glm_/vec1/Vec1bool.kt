package glm_.vec1


/**
 * Created bY GBarbieri on 05.10.2016.
 */

// TODO fill vec1bool methods as others
data class Vec1bool(var x: Boolean = false) {

    // -- Explicit basic, conversion other main.and conversion vector constructors --

    constructor(ba: BooleanArray) : this(ba[0])

    constructor(ba: Array<Boolean>) : this(ba[0])

    // -- Component accesses --

    operator fun get(i: Int): Boolean = when (i) {
        0 -> x
        else -> throw IndexOutOfBoundsException()
    }

    operator fun set(i: Int, b: Boolean) = when (i) {
        0 -> x = b
        else -> throw IndexOutOfBoundsException()
    }


    fun put(b: Boolean): Vec1bool {
        x = b
        return this
    }

    fun put(ba: BooleanArray): Vec1bool {
        x = ba[0]
        return this
    }

    fun put(ba: Array<Boolean>): Vec1bool {
        x = ba[0]
        return this
    }


    // -- Unary arithmetic vecOperators --

    operator fun not(): Vec1bool = Vec1bool(!x)

    fun notAss(): Vec1bool {
        x = !x
        return this
    }

    infix fun not(res: Vec1bool): Vec1bool {
        res.x = !x
        return this
    }

    // -- relational --

    // TODO
//    infix fun equal(b: Vec2bool) = glm.equal(this, b)
//    infix fun equal_(b: Vec2bool) = glm.equal(this, this, b)
//    fun equal(b: Vec2bool, res: Vec2bool) = glm.equal(res, this, b)
//
//    infix fun notEqual(b: Vec2bool) = glm.notEqual(this, b)
//    fun notEqual(b: Vec2bool, res: Vec2bool) = glm.notEqual(res, this, b)
//
//    fun any() = glm.any(this)
//
//    fun all() = glm.all(this)
}