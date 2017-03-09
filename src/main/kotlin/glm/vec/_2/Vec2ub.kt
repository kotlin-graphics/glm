package glm.vec._2

import glm.BYTES
import unsigned.Ubyte
import glm.i
import glm.ub
import glm.vec.Vec2t
import glm.vec.Vec3t
import glm.vec.Vec4t
import glm.vec._2.operators.vec2ub_operators
import glm.vec.bool.Vec2bool
import glm.vec.bool.Vec3bool
import glm.vec.bool.Vec4bool
import java.nio.*

/**
 * Created by elect on 07/10/16.
 */

class Vec2ub(x: Ubyte, y: Ubyte) : Vec2t<Ubyte>(x, y) {

    // -- Explicit basic, conversion other main.and conversion vector constructors --

    constructor() : this(0)

    constructor(v: Vec2t<out Number>) : this(v.x, v.y)
    constructor(v: Vec3t<out Number>) : this(v.x, v.y)
    constructor(v: Vec4t<out Number>) : this(v.x, v.y)

    constructor(v: Vec2bool) : this(v.x.ub, v.y.ub)
    constructor(v: Vec3bool) : this(v.x.ub, v.y.ub)
    constructor(v: Vec4bool) : this(v.x.ub, v.y.ub)

    constructor(bytes: ByteArray, index: Int = 0) : this(bytes[index], bytes[index + 1])
    constructor(chars: CharArray, index: Int = 0) : this(chars[index].ub, chars[index + 1].ub)
    constructor(shorts: ShortArray, index: Int = 0) : this(shorts[index], shorts[index + 1])
    constructor(ints: IntArray, index: Int = 0) : this(ints[index], ints[index + 1])
    constructor(longs: LongArray, index: Int = 0) : this(longs[index], longs[index + 1])
    constructor(floats: FloatArray, index: Int = 0) : this(floats[index], floats[index + 1])
    constructor(doubles: DoubleArray, index: Int = 0) : this(doubles[index], doubles[index + 1])
    constructor(booleans: BooleanArray, index: Int = 0) : this(booleans[index].ub, booleans[index + 1].ub)

    constructor(numbers: Array<out Number>, index: Int = 0) : this(numbers[index], numbers[index + 1])
    constructor(chars: Array<Char>, index: Int = 0) : this(chars[index].ub, chars[index + 1].ub)
    constructor(booleans: Array<Boolean>, index: Int = 0) : this(booleans[index].ub, booleans[index + 1].ub)

    constructor(list: List<Any>, index: Int = 0) : this() {
        put(list, index)
    }

    constructor(bytes: ByteBuffer, index: Int = bytes.position()) : this(bytes[index], bytes[index + 1])
    constructor(chars: CharBuffer, index: Int = chars.position()) : this(chars[index].ub, chars[index + 1].ub)
    constructor(shorts: ShortBuffer, index: Int = shorts.position()) : this(shorts[index], shorts[index + 1])
    constructor(ints: IntBuffer, index: Int = ints.position()) : this(ints[index], ints[index + 1])
    constructor(longs: LongBuffer, index: Int = longs.position()) : this(longs[index], longs[index + 1])
    constructor(floats: FloatBuffer, index: Int = floats.position()) : this(floats[index], floats[index + 1])
    constructor(doubles: DoubleBuffer, index: Int = doubles.position()) : this(doubles[index], doubles[index + 1])

    constructor(s: Number) : this(s, s)
    constructor(x: Number, y: Number) : this(x.ub, y.ub)


    override fun put(x: Number, y: Number): Vec2ub {
        this.x = x.ub
        this.y = y.ub
        return this
    }


    // -- Component accesses --

    operator fun get(i: Int) = when (i) {
        0 -> x
        1 -> y
        else -> throw ArrayIndexOutOfBoundsException()
    }

    operator fun set(i: Int, s: Number) = when (i) {
        0 -> x = s.ub
        1 -> y = s.ub
        else -> throw ArrayIndexOutOfBoundsException()
    }

    
    companion object : vec2ub_operators {
        @JvmField val length = 2
        @JvmField val SIZE = length * Ubyte.BYTES
    }


    // -- Unary arithmetic operators --

    operator fun unaryPlus() = this

    // no unaryMinus operator, only signed

    // -- Increment main.and decrement operators --

    operator fun inc(res: Vec2ub = Vec2ub()) = plus(res, this, 1, 1)
    fun inc_() = plus(this, this, 1, 1)


    operator fun dec(res: Vec2ub = Vec2ub()) = minus(res, this, 1, 1)
    fun dec_() = minus(this, this, 1, 1)


    // -- Specific binary arithmetic operators --

    operator fun plus(b: Ubyte) = plus(Vec2ub(), this, b, b)
    operator fun plus(b: Byte) = plus(Vec2ub(), this, b, b)
    operator fun plus(b: Int) = plus(Vec2ub(), this, b, b)
    operator fun plus(b: Vec2ub) = plus(Vec2ub(), this, b.x, b.y)

    fun plus(bX: Ubyte, bY: Ubyte, res: Vec2ub = Vec2ub()) = plus(res, this, bX, bY)
    fun plus(bX: Byte, bY: Byte, res: Vec2ub = Vec2ub()) = plus(res, this, bX, bY)
    fun plus(bX: Int, bY: Int, res: Vec2ub = Vec2ub()) = plus(res, this, bX, bY)
    fun plus(b: Ubyte, res: Vec2ub = Vec2ub()) = plus(res, this, b, b)
    fun plus(b: Byte, res: Vec2ub = Vec2ub()) = plus(res, this, b, b)
    fun plus(b: Int, res: Vec2ub = Vec2ub()) = plus(res, this, b, b)
    fun plus(b: Vec2ub, res: Vec2ub = Vec2ub()) = plus(res, this, b.x, b.y)

    fun plus_(bX: Ubyte, bY: Ubyte) = plus(this, this, bX, bY)
    fun plus_(bX: Byte, bY: Byte) = plus(this, this, bX, bY)
    fun plus_(bX: Int, bY: Int) = plus(this, this, bX, bY)
    infix fun plus_(b: Ubyte) = plus(this, this, b, b)
    infix fun plus_(b: Byte) = plus(this, this, b, b)
    infix fun plus_(b: Int) = plus(this, this, b, b)
    infix fun plus_(b: Vec2ub) = plus(this, this, b.x, b.y)


    operator fun minus(b: Ubyte) = minus(Vec2ub(), this, b, b)
    operator fun minus(b: Byte) = minus(Vec2ub(), this, b, b)
    operator fun minus(b: Int) = minus(Vec2ub(), this, b, b)
    operator fun minus(b: Vec2ub) = minus(Vec2ub(), this, b.x, b.y)

    fun minus(bX: Ubyte, bY: Ubyte, res: Vec2ub = Vec2ub()) = minus(res, this, bX, bY)
    fun minus(bX: Byte, bY: Byte, res: Vec2ub = Vec2ub()) = minus(res, this, bX, bY)
    fun minus(bX: Int, bY: Int, res: Vec2ub = Vec2ub()) = minus(res, this, bX, bY)
    fun minus(b: Ubyte, res: Vec2ub = Vec2ub()) = minus(res, this, b, b)
    fun minus(b: Byte, res: Vec2ub = Vec2ub()) = minus(res, this, b, b)
    fun minus(b: Int, res: Vec2ub = Vec2ub()) = minus(res, this, b, b)
    fun minus(b: Vec2ub, res: Vec2ub = Vec2ub()) = minus(res, this, b.x, b.y)

    fun minus_(bX: Ubyte, bY: Ubyte) = minus(this, this, bX, bY)
    fun minus_(bX: Byte, bY: Byte) = minus(this, this, bX, bY)
    fun minus_(bX: Int, bY: Int) = minus(this, this, bX, bY)
    infix fun minus_(b: Ubyte) = minus(this, this, b, b)
    infix fun minus_(b: Byte) = minus(this, this, b, b)
    infix fun minus_(b: Int) = minus(this, this, b, b)
    infix fun minus_(b: Vec2ub) = minus(this, this, b.x, b.y)


    operator fun times(b: Ubyte) = times(Vec2ub(), this, b, b)
    operator fun times(b: Byte) = times(Vec2ub(), this, b, b)
    operator fun times(b: Int) = times(Vec2ub(), this, b, b)
    operator fun times(b: Vec2ub) = times(Vec2ub(), this, b.x, b.y)

    fun times(bX: Ubyte, bY: Ubyte, res: Vec2ub = Vec2ub()) = times(res, this, bX, bY)
    fun times(bX: Byte, bY: Byte, res: Vec2ub = Vec2ub()) = times(res, this, bX, bY)
    fun times(bX: Int, bY: Int, res: Vec2ub = Vec2ub()) = times(res, this, bX, bY)
    fun times(b: Ubyte, res: Vec2ub = Vec2ub()) = times(res, this, b, b)
    fun times(b: Byte, res: Vec2ub = Vec2ub()) = times(res, this, b, b)
    fun times(b: Int, res: Vec2ub = Vec2ub()) = times(res, this, b, b)
    fun times(b: Vec2ub, res: Vec2ub = Vec2ub()) = times(res, this, b.x, b.y)

    fun times_(bX: Ubyte, bY: Ubyte) = times(this, this, bX, bY)
    fun times_(bX: Byte, bY: Byte) = times(this, this, bX, bY)
    fun times_(bX: Int, bY: Int) = times(this, this, bX, bY)
    infix fun times_(b: Ubyte) = times(this, this, b, b)
    infix fun times_(b: Byte) = times(this, this, b, b)
    infix fun times_(b: Int) = times(this, this, b, b)
    infix fun times_(b: Vec2ub) = times(this, this, b.x, b.y)


    operator fun div(b: Ubyte) = div(Vec2ub(), this, b, b)
    operator fun div(b: Byte) = div(Vec2ub(), this, b, b)
    operator fun div(b: Int) = div(Vec2ub(), this, b, b)
    operator fun div(b: Vec2ub) = div(Vec2ub(), this, b.x, b.y)

    fun div(bX: Ubyte, bY: Ubyte, res: Vec2ub = Vec2ub()) = div(res, this, bX, bY)
    fun div(bX: Byte, bY: Byte, res: Vec2ub = Vec2ub()) = div(res, this, bX, bY)
    fun div(bX: Int, bY: Int, res: Vec2ub = Vec2ub()) = div(res, this, bX, bY)
    fun div(b: Ubyte, res: Vec2ub) = div(res, this, b, b)
    fun div(b: Byte, res: Vec2ub) = div(res, this, b, b)
    fun div(b: Int, res: Vec2ub) = div(res, this, b, b)
    fun div(b: Vec2ub, res: Vec2ub) = div(res, this, b.x, b.y)

    fun div_(bX: Ubyte, bY: Ubyte) = div(this, this, bX, bY)
    fun div_(bX: Byte, bY: Byte) = div(this, this, bX, bY)
    fun div_(bX: Int, bY: Int) = div(this, this, bX, bY)
    infix fun div_(b: Ubyte) = div(this, this, b, b)
    infix fun div_(b: Byte) = div(this, this, b, b)
    infix fun div_(b: Int) = div(this, this, b, b)
    infix fun div_(b: Vec2ub) = div(this, this, b.x, b.y)


    operator fun rem(b: Ubyte) = rem(Vec2ub(), this, b, b)
    operator fun rem(b: Byte) = rem(Vec2ub(), this, b, b)
    operator fun rem(b: Int) = rem(Vec2ub(), this, b, b)
    operator fun rem(b: Vec2ub) = rem(Vec2ub(), this, b.x, b.y)

    fun rem(bX: Ubyte, bY: Ubyte, res: Vec2ub = Vec2ub()) = rem(res, this, bX, bY)
    fun rem(bX: Byte, bY: Byte, res: Vec2ub = Vec2ub()) = rem(res, this, bX, bY)
    fun rem(bX: Int, bY: Int, res: Vec2ub = Vec2ub()) = rem(res, this, bX, bY)
    fun rem(b: Ubyte, res: Vec2ub) = rem(res, this, b, b)
    fun rem(b: Byte, res: Vec2ub) = rem(res, this, b, b)
    fun rem(b: Int, res: Vec2ub) = rem(res, this, b, b)
    fun rem(b: Vec2ub, res: Vec2ub) = rem(res, this, b.x, b.y)

    fun rem_(bX: Ubyte, bY: Ubyte) = rem(this, this, bX, bY)
    fun rem_(bX: Byte, bY: Byte) = rem(this, this, bX, bY)
    fun rem_(bX: Int, bY: Int) = rem(this, this, bX, bY)
    infix fun rem_(b: Ubyte) = rem(this, this, b, b)
    infix fun rem_(b: Byte) = rem(this, this, b, b)
    infix fun rem_(b: Int) = rem(this, this, b, b)
    infix fun rem_(b: Vec2ub) = rem(this, this, b.x, b.y)


    // -- Generic binary arithmetic operators --

    operator fun plus(b: Number) = plus(Vec2ub(), this, b.i, b.i)
    operator fun plus(b: Vec2t<Number>) = plus(Vec2ub(), this, b.x.i, b.y.i)

    fun plus(bX: Number, bY: Number, res: Vec2ub = Vec2ub()) = plus(res, this, bX.i, bY.i)
    fun plus(b: Number, res: Vec2ub = Vec2ub()) = plus(res, this, b.i, b.i)
    fun plus(b: Vec2t<Number>, res: Vec2ub = Vec2ub()) = plus(res, this, b.x.i, b.y.i)

    fun plus_(bX: Number, bY: Number) = plus(this, this, bX.i, bY.i)
    infix fun plus_(b: Number) = plus(this, this, b.i, b.i)
    infix fun plus_(b: Vec2t<Number>) = plus(this, this, b.x.i, b.y.i)


    operator fun minus(b: Number) = minus(Vec2ub(), this, b.i, b.i)
    operator fun minus(b: Vec2t<Number>) = minus(Vec2ub(), this, b.x.i, b.y.i)

    fun minus(bX: Number, bY: Number, res: Vec2ub = Vec2ub()) = minus(res, this, bX.i, bY.i)
    fun minus(b: Number, res: Vec2ub = Vec2ub()) = minus(res, this, b.i, b.i)
    fun minus(b: Vec2t<Number>, res: Vec2ub = Vec2ub()) = minus(res, this, b.x.i, b.y.i)

    fun minus_(bX: Number, bY: Number) = minus(this, this, bX.i, bY.i)
    infix fun minus_(b: Number) = minus(this, this, b.i, b.i)
    infix fun minus_(b: Vec2t<Number>) = minus(this, this, b.x.i, b.y.i)


    operator fun times(b: Number) = times(Vec2ub(), this, b.i, b.i)
    operator fun times(b: Vec2t<Number>) = times(Vec2ub(), this, b.x.i, b.y.i)

    fun times(bX: Number, bY: Number, res: Vec2ub = Vec2ub()) = times(res, this, bX.i, bY.i)
    fun times(b: Number, res: Vec2ub = Vec2ub()) = times(res, this, b.i, b.i)
    fun times(b: Vec2t<Number>, res: Vec2ub = Vec2ub()) = times(res, this, b.x.i, b.y.i)

    fun times_(bX: Number, bY: Number) = times(this, this, bX.i, bY.i)
    infix fun times_(b: Number) = times(this, this, b.i, b.i)
    infix fun times_(b: Vec2t<Number>) = times(this, this, b.x.i, b.y.i)


    operator fun div(b: Number) = div(Vec2ub(), this, b.i, b.i)
    operator fun div(b: Vec2t<Number>) = div(Vec2ub(), this, b.x.i, b.y.i)

    fun div(bX: Number, bY: Number, res: Vec2ub = Vec2ub()) = div(res, this, bX.i, bY.i)
    fun div(b: Number, res: Vec2ub) = div(res, this, b.i, b.i)
    fun div(b: Vec2t<Number>, res: Vec2ub) = div(res, this, b.x.i, b.y.i)

    fun div_(bX: Number, bY: Number) = div(this, this, bX.i, bY.i)
    infix fun div_(b: Number) = div(this, this, b.i, b.i)
    infix fun div_(b: Vec2t<Number>) = div(this, this, b.x.i, b.y.i)


    operator fun rem(b: Number) = rem(Vec2ub(), this, b.i, b.i)
    operator fun rem(b: Vec2t<Number>) = rem(Vec2ub(), this, b.x.i, b.y.i)

    fun rem(bX: Number, bY: Number, res: Vec2ub = Vec2ub()) = rem(res, this, bX.i, bY.i)
    fun rem(b: Number, res: Vec2ub) = rem(res, this, b.i, b.i)
    fun rem(b: Vec2t<Number>, res: Vec2ub) = rem(res, this, b.x.i, b.y.i)

    fun rem_(bX: Number, bY: Number) = rem(this, this, bX.i, bY.i)
    infix fun rem_(b: Number) = rem(this, this, b.i, b.i)
    infix fun rem_(b: Vec2t<Number>) = rem(this, this, b.x.i, b.y.i)


    // -- Specific bitwise operators --

    infix fun and(b: Ubyte) = and(Vec2ub(), this, b, b)
    infix fun and(b: Byte) = and(Vec2ub(), this, b, b)
    infix fun and(b: Int) = and(Vec2ub(), this, b, b)
    infix fun and(b: Vec2ub) = and(Vec2ub(), this, b.x, b.y)

    infix fun and_(b: Ubyte) = and(this, this, b, b)
    infix fun and_(b: Byte) = and(this, this, b, b)
    infix fun and_(b: Int) = and(this, this, b, b)
    infix fun and_(b: Vec2ub) = and(this, this, b.x, b.y)

    fun and(b: Ubyte, res: Vec2ub) = and(res, this, b, b)
    fun and(b: Byte, res: Vec2ub) = and(res, this, b, b)
    fun and(b: Int, res: Vec2ub) = and(res, this, b, b)
    fun and(b: Vec2ub, res: Vec2ub) = and(res, this, b.x, b.y)

    fun and(bX: Ubyte, bY: Ubyte, res: Vec2ub = Vec2ub()) = and(res, this, bX, bY)
    fun and(bX: Byte, bY: Byte, res: Vec2ub = Vec2ub()) = and(res, this, bX, bY)
    fun and(bX: Int, bY: Int, res: Vec2ub = Vec2ub()) = and(res, this, bX, bY)

    fun and_(bX: Ubyte, bY: Ubyte) = and(this, this, bX, bY)
    fun and_(bX: Byte, bY: Byte) = and(this, this, bX, bY)
    fun and_(bX: Int, bY: Int) = and(this, this, bX, bY)


    infix fun or(b: Ubyte) = or(Vec2ub(), this, b, b)
    infix fun or(b: Byte) = or(Vec2ub(), this, b, b)
    infix fun or(b: Int) = or(Vec2ub(), this, b, b)
    infix fun or(b: Vec2ub) = or(Vec2ub(), this, b.x, b.y)

    infix fun or_(b: Ubyte) = or(this, this, b, b)
    infix fun or_(b: Byte) = or(this, this, b, b)
    infix fun or_(b: Int) = or(this, this, b, b)
    infix fun or_(b: Vec2ub) = or(this, this, b.x, b.y)

    fun or(b: Ubyte, res: Vec2ub) = or(res, this, b, b)
    fun or(b: Byte, res: Vec2ub) = or(res, this, b, b)
    fun or(b: Int, res: Vec2ub) = or(res, this, b, b)
    fun or(b: Vec2ub, res: Vec2ub) = or(res, this, b.x, b.y)

    fun or(bX: Ubyte, bY: Ubyte, res: Vec2ub = Vec2ub()) = or(res, this, bX, bY)
    fun or(bX: Byte, bY: Byte, res: Vec2ub = Vec2ub()) = or(res, this, bX, bY)
    fun or(bX: Int, bY: Int, res: Vec2ub = Vec2ub()) = or(res, this, bX, bY)

    fun or_(bX: Ubyte, bY: Ubyte) = or(this, this, bX, bY)
    fun or_(bX: Byte, bY: Byte) = or(this, this, bX, bY)
    fun or_(bX: Int, bY: Int) = or(this, this, bX, bY)


    infix fun xor(b: Ubyte) = xor(Vec2ub(), this, b, b)
    infix fun xor(b: Byte) = xor(Vec2ub(), this, b, b)
    infix fun xor(b: Int) = xor(Vec2ub(), this, b, b)
    infix fun xor(b: Vec2ub) = xor(Vec2ub(), this, b.x, b.y)

    infix fun xor_(b: Ubyte) = xor(this, this, b, b)
    infix fun xor_(b: Byte) = xor(this, this, b, b)
    infix fun xor_(b: Int) = xor(this, this, b, b)
    infix fun xor_(b: Vec2ub) = xor(this, this, b.x, b.y)

    fun xor(b: Ubyte, res: Vec2ub) = xor(res, this, b, b)
    fun xor(b: Byte, res: Vec2ub) = xor(res, this, b, b)
    fun xor(b: Int, res: Vec2ub) = xor(res, this, b, b)
    fun xor(b: Vec2ub, res: Vec2ub) = xor(res, this, b.x, b.y)

    fun xor(bX: Ubyte, bY: Ubyte, res: Vec2ub = Vec2ub()) = xor(res, this, bX, bY)
    fun xor(bX: Byte, bY: Byte, res: Vec2ub = Vec2ub()) = xor(res, this, bX, bY)
    fun xor(bX: Int, bY: Int, res: Vec2ub = Vec2ub()) = xor(res, this, bX, bY)

    fun xor_(bX: Ubyte, bY: Ubyte) = xor(this, this, bX, bY)
    fun xor_(bX: Byte, bY: Byte) = xor(this, this, bX, bY)
    fun xor_(bX: Int, bY: Int) = xor(this, this, bX, bY)


    infix fun shl(b: Ubyte) = shl(Vec2ub(), this, b, b)
    infix fun shl(b: Byte) = shl(Vec2ub(), this, b, b)
    infix fun shl(b: Int) = shl(Vec2ub(), this, b, b)
    infix fun shl(b: Vec2ub) = shl(Vec2ub(), this, b.x, b.y)

    infix fun shl_(b: Ubyte) = shl(this, this, b, b)
    infix fun shl_(b: Byte) = shl(this, this, b, b)
    infix fun shl_(b: Int) = shl(this, this, b, b)
    infix fun shl_(b: Vec2ub) = shl(this, this, b.x, b.y)

    fun shl(b: Ubyte, res: Vec2ub) = shl(res, this, b, b)
    fun shl(b: Byte, res: Vec2ub) = shl(res, this, b, b)
    fun shl(b: Int, res: Vec2ub) = shl(res, this, b, b)
    fun shl(b: Vec2ub, res: Vec2ub) = shl(res, this, b.x, b.y)

    fun shl(bX: Ubyte, bY: Ubyte, res: Vec2ub = Vec2ub()) = shl(res, this, bX, bY)
    fun shl(bX: Byte, bY: Byte, res: Vec2ub = Vec2ub()) = shl(res, this, bX, bY)
    fun shl(bX: Int, bY: Int, res: Vec2ub = Vec2ub()) = shl(res, this, bX, bY)

    fun shl_(bX: Ubyte, bY: Ubyte) = shl(this, this, bX, bY)
    fun shl_(bX: Byte, bY: Byte) = shl(this, this, bX, bY)
    fun shl_(bX: Int, bY: Int) = shl(this, this, bX, bY)


    infix fun shr(b: Ubyte) = shr(Vec2ub(), this, b, b)
    infix fun shr(b: Byte) = shr(Vec2ub(), this, b, b)
    infix fun shr(b: Int) = shr(Vec2ub(), this, b, b)
    infix fun shr(b: Vec2ub) = shr(Vec2ub(), this, b.x, b.y)

    infix fun shr_(b: Ubyte) = shr(this, this, b, b)
    infix fun shr_(b: Byte) = shr(this, this, b, b)
    infix fun shr_(b: Int) = shr(this, this, b, b)
    infix fun shr_(b: Vec2ub) = shr(this, this, b.x, b.y)

    fun shr(b: Ubyte, res: Vec2ub) = shr(res, this, b, b)
    fun shr(b: Byte, res: Vec2ub) = shr(res, this, b, b)
    fun shr(b: Int, res: Vec2ub) = shr(res, this, b, b)
    fun shr(b: Vec2ub, res: Vec2ub) = shr(res, this, b.x, b.y)

    fun shr(bX: Ubyte, bY: Ubyte, res: Vec2ub = Vec2ub()) = shr(res, this, bX, bY)
    fun shr(bX: Byte, bY: Byte, res: Vec2ub = Vec2ub()) = shr(res, this, bX, bY)
    fun shr(bX: Int, bY: Int, res: Vec2ub = Vec2ub()) = shr(res, this, bX, bY)

    fun shr_(bX: Ubyte, bY: Ubyte) = shr(this, this, bX, bY)
    fun shr_(bX: Byte, bY: Byte) = shr(this, this, bX, bY)
    fun shr_(bX: Int, bY: Int) = shr(this, this, bX, bY)


    fun inv(res: Vec2ub = Vec2ub()) = inv(res, this)
    fun inv_() = inv(this, this)


    // -- Generic bitwise operators --

    infix fun and(b: Number) = and(Vec2ub(), this, b.i, b.i)
    infix fun and(b: Vec2t<Number>) = and(Vec2ub(), this, b.x.i, b.y.i)

    infix fun and_(b: Number) = and(this, this, b.i, b.i)
    infix fun and_(b: Vec2t<Number>) = and(this, this, b.x.i, b.y.i)

    fun and(b: Number, res: Vec2ub) = and(res, this, b.i, b.i)
    fun and(b: Vec2t<Number>, res: Vec2ub) = and(res, this, b.x.i, b.y.i)

    fun and(bX: Number, bY: Number, res: Vec2ub = Vec2ub()) = and(res, this, bX.i, bY.i)

    fun and_(bX: Number, bY: Number) = and(this, this, bX.i, bY.i)


    infix fun or(b: Number) = or(Vec2ub(), this, b.i, b.i)
    infix fun or(b: Vec2t<Number>) = or(Vec2ub(), this, b.x.i, b.y.i)

    infix fun or_(b: Number) = or(this, this, b.i, b.i)
    infix fun or_(b: Vec2t<Number>) = or(this, this, b.x.i, b.y.i)

    fun or(b: Number, res: Vec2ub) = or(res, this, b.i, b.i)
    fun or(b: Vec2t<Number>, res: Vec2ub) = or(res, this, b.x.i, b.y.i)

    fun or(bX: Number, bY: Number, res: Vec2ub = Vec2ub()) = or(res, this, bX.i, bY.i)

    fun or_(bX: Number, bY: Number) = or(this, this, bX.i, bY.i)


    infix fun xor(b: Number) = xor(Vec2ub(), this, b.i, b.i)
    infix fun xor(b: Vec2t<Number>) = xor(Vec2ub(), this, b.x.i, b.y.i)

    infix fun xor_(b: Number) = xor(this, this, b.i, b.i)
    infix fun xor_(b: Vec2t<Number>) = xor(this, this, b.x.i, b.y.i)

    fun xor(b: Number, res: Vec2ub) = xor(res, this, b.i, b.i)
    fun xor(b: Vec2t<Number>, res: Vec2ub) = xor(res, this, b.x.i, b.y.i)

    fun xor(bX: Number, bY: Number, res: Vec2ub = Vec2ub()) = xor(res, this, bX.i, bY.i)

    fun xor_(bX: Number, bY: Number) = xor(this, this, bX.i, bY.i)


    infix fun shl(b: Number) = shl(Vec2ub(), this, b.i, b.i)
    infix fun shl(b: Vec2t<Number>) = shl(Vec2ub(), this, b.x.i, b.y.i)

    infix fun shl_(b: Number) = shl(this, this, b.i, b.i)
    infix fun shl_(b: Vec2t<Number>) = shl(this, this, b.x.i, b.y.i)

    fun shl(b: Number, res: Vec2ub) = shl(res, this, b.i, b.i)
    fun shl(b: Vec2t<Number>, res: Vec2ub) = shl(res, this, b.x.i, b.y.i)

    fun shl(bX: Number, bY: Number, res: Vec2ub = Vec2ub()) = shl(res, this, bX.i, bY.i)

    fun shl_(bX: Number, bY: Number) = shl(this, this, bX.i, bY.i)


    infix fun shr(b: Number) = shr(Vec2ub(), this, b.i, b.i)
    infix fun shr(b: Vec2t<Number>) = shr(Vec2ub(), this, b.x.i, b.y.i)

    infix fun shr_(b: Number) = shr(this, this, b.i, b.i)
    infix fun shr_(b: Vec2t<Number>) = shr(this, this, b.x.i, b.y.i)

    fun shr(b: Number, res: Vec2ub) = shr(res, this, b.i, b.i)
    fun shr(b: Vec2t<Number>, res: Vec2ub) = shr(res, this, b.x.i, b.y.i)

    fun shr(bX: Number, bY: Number, res: Vec2ub = Vec2ub()) = shr(res, this, bX.i, bY.i)

    fun shr_(bX: Number, bY: Number) = shr(this, this, bX.i, bY.i)


    override fun equals(other: Any?) =
            if (other is Vec2ub)
                this[0] == other[0] && this[1] == other[1]
            else false
}