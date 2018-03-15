package glm_.vec1

import glm_.BYTES
import glm_.toByte
import glm_.ub
import glm_.vec2.Vec2bool
import glm_.vec2.Vec2t
import glm_.vec3.Vec3bool
import glm_.vec3.Vec3t
import glm_.vec4.Vec4bool
import glm_.vec4.Vec4t
import unsigned.Ubyte
import java.nio.*

/**
 * Created by elect on 07/10/16.
 */

class Vec1ub(x: Ubyte) : Vec1t<Ubyte>(x) {

    // -- Explicit basic, conversion other main.and conversion vector constructors --

    constructor() : this(0)

    constructor(v: Vec2t<out Number>) : this(v.x)
    constructor(v: Vec3t<out Number>) : this(v.x)
    constructor(v: Vec4t<out Number>) : this(v.x)

    constructor(v: Vec2bool) : this(v.x.ub)
    constructor(v: Vec3bool) : this(v.x.ub)
    constructor(v: Vec4bool) : this(v.x.ub)

    constructor(bytes: ByteArray, index: Int = 0) : this(bytes[index])
    constructor(chars: CharArray, index: Int = 0) : this(chars[index].ub)
    constructor(shorts: ShortArray, index: Int = 0) : this(shorts[index])
    constructor(ints: IntArray, index: Int = 0) : this(ints[index])
    constructor(longs: LongArray, index: Int = 0) : this(longs[index])
    constructor(floats: FloatArray, index: Int = 0) : this(floats[index])
    constructor(doubles: DoubleArray, index: Int = 0) : this(doubles[index])
    constructor(booleans: BooleanArray, index: Int = 0) : this(booleans[index].ub)

    constructor(numbers: Array<out Number>, index: Int = 0) : this(numbers[index])
    constructor(chars: Array<Char>, index: Int = 0) : this(chars[index].ub)
    constructor(booleans: Array<Boolean>, index: Int = 0) : this(booleans[index].ub)

    constructor(list: List<Any>, index: Int = 0) : this(list[index].toByte) // TODO ub kuns

    constructor(bytes: ByteBuffer, index: Int = bytes.position()) : this(bytes[index])
    constructor(chars: CharBuffer, index: Int = chars.position()) : this(chars[index].ub)
    constructor(shorts: ShortBuffer, index: Int = shorts.position()) : this(shorts[index])
    constructor(ints: IntBuffer, index: Int = ints.position()) : this(ints[index])
    constructor(longs: LongBuffer, index: Int = longs.position()) : this(longs[index])
    constructor(floats: FloatBuffer, index: Int = floats.position()) : this(floats[index])
    constructor(doubles: DoubleBuffer, index: Int = doubles.position()) : this(doubles[index])

    constructor(x: Number) : this(x.ub)


    override fun put(x: Number): Vec1ub {
        this.x = x.ub
        return this
    }


    infix fun to(bytes: ByteArray) = to(bytes, 0)
    fun to(bytes: ByteArray, index: Int): ByteArray {
        bytes[index] = x.v
        return bytes
    }

    infix fun to(bytes: ByteBuffer) = to(bytes, bytes.position())
    fun to(bytes: ByteBuffer, offset: Int):ByteBuffer = bytes.put(offset, x.v)


    // -- Component accesses --

    override operator fun set(index: Int, value: Number) = when (index) {
        0 -> x = value.ub
        else -> throw ArrayIndexOutOfBoundsException()
    }


    companion object /*: opVec2ub*/ {
        @JvmField
        val length = 1
        @JvmField
        val size = length * Ubyte.BYTES
    }

    override fun size() = size


    // -- Unary arithmetic operators --

    operator fun unaryPlus() = this

    // no unaryMinus operator, only signed

    // -- Increment main.and decrement operators --

//    operator fun inc() = plus(Vec1ub(), this, 1, 1)
//    infix fun inc(res: Vec1ub) = plus(res, this, 1, 1)
//    fun inc_() = plus(this, this, 1, 1)
//
//
//    operator fun dec() = minus(Vec1ub(), this, 1, 1)
//    infix fun dec(res: Vec1ub) = minus(res, this, 1, 1)
//    fun dec_() = minus(this, this, 1, 1)
//
//
//    // -- Specific binary arithmetic operators --
//
//    infix operator fun plus(b: Ubyte) = plus(Vec1ub(), this, b, b)
//    infix operator fun plus(b: Byte) = plus(Vec1ub(), this, b, b)
//    infix operator fun plus(b: Int) = plus(Vec1ub(), this, b, b)
//    infix operator fun plus(b: Vec1ub) = plus(Vec1ub(), this, b.x, b.y)
//
//    @JvmOverloads
//    fun plus(bX: Ubyte, bY: Ubyte, res: Vec1ub = Vec1ub()) = plus(res, this, bX, bY)
//
//    @JvmOverloads
//    fun plus(bX: Byte, bY: Byte, res: Vec1ub = Vec1ub()) = plus(res, this, bX, bY)
//
//    @JvmOverloads
//    fun plus(bX: Int, bY: Int, res: Vec1ub = Vec1ub()) = plus(res, this, bX, bY)
//
//    fun plus(b: Ubyte, res: Vec1ub) = plus(res, this, b, b)
//    fun plus(b: Byte, res: Vec1ub) = plus(res, this, b, b)
//    fun plus(b: Int, res: Vec1ub) = plus(res, this, b, b)
//    fun plus(b: Vec1ub, res: Vec1ub) = plus(res, this, b.x, b.y)
//
//    fun plus_(bX: Ubyte, bY: Ubyte) = plus(this, this, bX, bY)
//    fun plus_(bX: Byte, bY: Byte) = plus(this, this, bX, bY)
//    fun plus_(bX: Int, bY: Int) = plus(this, this, bX, bY)
//    infix fun plus_(b: Ubyte) = plus(this, this, b, b)
//    infix fun plus_(b: Byte) = plus(this, this, b, b)
//    infix fun plus_(b: Int) = plus(this, this, b, b)
//    infix fun plus_(b: Vec1ub) = plus(this, this, b.x, b.y)
//
//
//    infix operator fun minus(b: Ubyte) = minus(Vec1ub(), this, b, b)
//    infix operator fun minus(b: Byte) = minus(Vec1ub(), this, b, b)
//    infix operator fun minus(b: Int) = minus(Vec1ub(), this, b, b)
//    infix operator fun minus(b: Vec1ub) = minus(Vec1ub(), this, b.x, b.y)
//
//    @JvmOverloads
//    fun minus(bX: Ubyte, bY: Ubyte, res: Vec1ub = Vec1ub()) = minus(res, this, bX, bY)
//
//    @JvmOverloads
//    fun minus(bX: Byte, bY: Byte, res: Vec1ub = Vec1ub()) = minus(res, this, bX, bY)
//
//    @JvmOverloads
//    fun minus(bX: Int, bY: Int, res: Vec1ub = Vec1ub()) = minus(res, this, bX, bY)
//
//    fun minus(b: Ubyte, res: Vec1ub) = minus(res, this, b, b)
//    fun minus(b: Byte, res: Vec1ub) = minus(res, this, b, b)
//    fun minus(b: Int, res: Vec1ub) = minus(res, this, b, b)
//    fun minus(b: Vec1ub, res: Vec1ub) = minus(res, this, b.x, b.y)
//
//    fun minus_(bX: Ubyte, bY: Ubyte) = minus(this, this, bX, bY)
//    fun minus_(bX: Byte, bY: Byte) = minus(this, this, bX, bY)
//    fun minus_(bX: Int, bY: Int) = minus(this, this, bX, bY)
//    infix fun minus_(b: Ubyte) = minus(this, this, b, b)
//    infix fun minus_(b: Byte) = minus(this, this, b, b)
//    infix fun minus_(b: Int) = minus(this, this, b, b)
//    infix fun minus_(b: Vec1ub) = minus(this, this, b.x, b.y)
//
//
//    infix operator fun times(b: Ubyte) = times(Vec1ub(), this, b, b)
//    infix operator fun times(b: Byte) = times(Vec1ub(), this, b, b)
//    infix operator fun times(b: Int) = times(Vec1ub(), this, b, b)
//    infix operator fun times(b: Vec1ub) = times(Vec1ub(), this, b.x, b.y)
//
//    @JvmOverloads
//    fun times(bX: Ubyte, bY: Ubyte, res: Vec1ub = Vec1ub()) = times(res, this, bX, bY)
//
//    @JvmOverloads
//    fun times(bX: Byte, bY: Byte, res: Vec1ub = Vec1ub()) = times(res, this, bX, bY)
//
//    @JvmOverloads
//    fun times(bX: Int, bY: Int, res: Vec1ub = Vec1ub()) = times(res, this, bX, bY)
//
//    fun times(b: Ubyte, res: Vec1ub) = times(res, this, b, b)
//    fun times(b: Byte, res: Vec1ub) = times(res, this, b, b)
//    fun times(b: Int, res: Vec1ub) = times(res, this, b, b)
//    fun times(b: Vec1ub, res: Vec1ub) = times(res, this, b.x, b.y)
//
//    fun times_(bX: Ubyte, bY: Ubyte) = times(this, this, bX, bY)
//    fun times_(bX: Byte, bY: Byte) = times(this, this, bX, bY)
//    fun times_(bX: Int, bY: Int) = times(this, this, bX, bY)
//    infix fun times_(b: Ubyte) = times(this, this, b, b)
//    infix fun times_(b: Byte) = times(this, this, b, b)
//    infix fun times_(b: Int) = times(this, this, b, b)
//    infix fun times_(b: Vec1ub) = times(this, this, b.x, b.y)
//
//
//    infix operator fun div(b: Ubyte) = div(Vec1ub(), this, b, b)
//    infix operator fun div(b: Byte) = div(Vec1ub(), this, b, b)
//    infix operator fun div(b: Int) = div(Vec1ub(), this, b, b)
//    infix operator fun div(b: Vec1ub) = div(Vec1ub(), this, b.x, b.y)
//
//    @JvmOverloads
//    fun div(bX: Ubyte, bY: Ubyte, res: Vec1ub = Vec1ub()) = div(res, this, bX, bY)
//
//    @JvmOverloads
//    fun div(bX: Byte, bY: Byte, res: Vec1ub = Vec1ub()) = div(res, this, bX, bY)
//
//    @JvmOverloads
//    fun div(bX: Int, bY: Int, res: Vec1ub = Vec1ub()) = div(res, this, bX, bY)
//
//    fun div(b: Ubyte, res: Vec1ub) = div(res, this, b, b)
//    fun div(b: Byte, res: Vec1ub) = div(res, this, b, b)
//    fun div(b: Int, res: Vec1ub) = div(res, this, b, b)
//    fun div(b: Vec1ub, res: Vec1ub) = div(res, this, b.x, b.y)
//
//    fun div_(bX: Ubyte, bY: Ubyte) = div(this, this, bX, bY)
//    fun div_(bX: Byte, bY: Byte) = div(this, this, bX, bY)
//    fun div_(bX: Int, bY: Int) = div(this, this, bX, bY)
//    infix fun div_(b: Ubyte) = div(this, this, b, b)
//    infix fun div_(b: Byte) = div(this, this, b, b)
//    infix fun div_(b: Int) = div(this, this, b, b)
//    infix fun div_(b: Vec1ub) = div(this, this, b.x, b.y)
//
//
//    infix operator fun rem(b: Ubyte) = rem(Vec1ub(), this, b, b)
//    infix operator fun rem(b: Byte) = rem(Vec1ub(), this, b, b)
//    infix operator fun rem(b: Int) = rem(Vec1ub(), this, b, b)
//    infix operator fun rem(b: Vec1ub) = rem(Vec1ub(), this, b.x, b.y)
//
//    @JvmOverloads
//    fun rem(bX: Ubyte, bY: Ubyte, res: Vec1ub = Vec1ub()) = rem(res, this, bX, bY)
//
//    @JvmOverloads
//    fun rem(bX: Byte, bY: Byte, res: Vec1ub = Vec1ub()) = rem(res, this, bX, bY)
//
//    @JvmOverloads
//    fun rem(bX: Int, bY: Int, res: Vec1ub = Vec1ub()) = rem(res, this, bX, bY)
//
//    fun rem(b: Ubyte, res: Vec1ub) = rem(res, this, b, b)
//    fun rem(b: Byte, res: Vec1ub) = rem(res, this, b, b)
//    fun rem(b: Int, res: Vec1ub) = rem(res, this, b, b)
//    fun rem(b: Vec1ub, res: Vec1ub) = rem(res, this, b.x, b.y)
//
//    fun rem_(bX: Ubyte, bY: Ubyte) = rem(this, this, bX, bY)
//    fun rem_(bX: Byte, bY: Byte) = rem(this, this, bX, bY)
//    fun rem_(bX: Int, bY: Int) = rem(this, this, bX, bY)
//    infix fun rem_(b: Ubyte) = rem(this, this, b, b)
//    infix fun rem_(b: Byte) = rem(this, this, b, b)
//    infix fun rem_(b: Int) = rem(this, this, b, b)
//    infix fun rem_(b: Vec1ub) = rem(this, this, b.x, b.y)
//
//
//    // -- Generic binary arithmetic operators --
//
//    infix operator fun plus(b: Number) = plus(Vec1ub(), this, b.i, b.i)
//    infix operator fun plus(b: Vec2t<out Number>) = plus(Vec1ub(), this, b.x.i, b.y.i)
//
//    @JvmOverloads
//    fun plus(bX: Number, bY: Number, res: Vec1ub = Vec1ub()) = plus(res, this, bX.i, bY.i)
//
//    fun plus(b: Number, res: Vec1ub) = plus(res, this, b.i, b.i)
//    fun plus(b: Vec2t<out Number>, res: Vec1ub) = plus(res, this, b.x.i, b.y.i)
//
//    fun plus_(bX: Number, bY: Number) = plus(this, this, bX.i, bY.i)
//    infix fun plus_(b: Number) = plus(this, this, b.i, b.i)
//    infix fun plus_(b: Vec2t<out Number>) = plus(this, this, b.x.i, b.y.i)
//
//
//    infix operator fun minus(b: Number) = minus(Vec1ub(), this, b.i, b.i)
//    infix operator fun minus(b: Vec2t<out Number>) = minus(Vec1ub(), this, b.x.i, b.y.i)
//
//    @JvmOverloads
//    fun minus(bX: Number, bY: Number, res: Vec1ub = Vec1ub()) = minus(res, this, bX.i, bY.i)
//
//    fun minus(b: Number, res: Vec1ub) = minus(res, this, b.i, b.i)
//    fun minus(b: Vec2t<out Number>, res: Vec1ub) = minus(res, this, b.x.i, b.y.i)
//
//    fun minus_(bX: Number, bY: Number) = minus(this, this, bX.i, bY.i)
//    infix fun minus_(b: Number) = minus(this, this, b.i, b.i)
//    infix fun minus_(b: Vec2t<out Number>) = minus(this, this, b.x.i, b.y.i)
//
//
//    infix operator fun times(b: Number) = times(Vec1ub(), this, b.i, b.i)
//    infix operator fun times(b: Vec2t<out Number>) = times(Vec1ub(), this, b.x.i, b.y.i)
//
//    @JvmOverloads
//    fun times(bX: Number, bY: Number, res: Vec1ub = Vec1ub()) = times(res, this, bX.i, bY.i)
//
//    fun times(b: Number, res: Vec1ub) = times(res, this, b.i, b.i)
//    fun times(b: Vec2t<out Number>, res: Vec1ub) = times(res, this, b.x.i, b.y.i)
//
//    fun times_(bX: Number, bY: Number) = times(this, this, bX.i, bY.i)
//    infix fun times_(b: Number) = times(this, this, b.i, b.i)
//    infix fun times_(b: Vec2t<out Number>) = times(this, this, b.x.i, b.y.i)
//
//
//    infix operator fun div(b: Number) = div(Vec1ub(), this, b.i, b.i)
//    infix operator fun div(b: Vec2t<out Number>) = div(Vec1ub(), this, b.x.i, b.y.i)
//
//    @JvmOverloads
//    fun div(bX: Number, bY: Number, res: Vec1ub = Vec1ub()) = div(res, this, bX.i, bY.i)
//
//    fun div(b: Number, res: Vec1ub) = div(res, this, b.i, b.i)
//    fun div(b: Vec2t<out Number>, res: Vec1ub) = div(res, this, b.x.i, b.y.i)
//
//    fun div_(bX: Number, bY: Number) = div(this, this, bX.i, bY.i)
//    infix fun div_(b: Number) = div(this, this, b.i, b.i)
//    infix fun div_(b: Vec2t<out Number>) = div(this, this, b.x.i, b.y.i)
//
//
//    infix operator fun rem(b: Number) = rem(Vec1ub(), this, b.i, b.i)
//    infix operator fun rem(b: Vec2t<out Number>) = rem(Vec1ub(), this, b.x.i, b.y.i)
//
//    @JvmOverloads
//    fun rem(bX: Number, bY: Number, res: Vec1ub = Vec1ub()) = rem(res, this, bX.i, bY.i)
//
//    fun rem(b: Number, res: Vec1ub) = rem(res, this, b.i, b.i)
//    fun rem(b: Vec2t<out Number>, res: Vec1ub) = rem(res, this, b.x.i, b.y.i)
//
//    fun rem_(bX: Number, bY: Number) = rem(this, this, bX.i, bY.i)
//    infix fun rem_(b: Number) = rem(this, this, b.i, b.i)
//    infix fun rem_(b: Vec2t<out Number>) = rem(this, this, b.x.i, b.y.i)
//
//
//    // -- Specific bitwise operators --
//
//    infix fun and(b: Ubyte) = and(Vec1ub(), this, b, b)
//    infix fun and(b: Byte) = and(Vec1ub(), this, b, b)
//    infix fun and(b: Int) = and(Vec1ub(), this, b, b)
//    infix fun and(b: Vec1ub) = and(Vec1ub(), this, b.x, b.y)
//
//    fun and(b: Ubyte, res: Vec1ub) = and(res, this, b, b)
//    fun and(b: Byte, res: Vec1ub) = and(res, this, b, b)
//    fun and(b: Int, res: Vec1ub) = and(res, this, b, b)
//    fun and(b: Vec1ub, res: Vec1ub) = and(res, this, b.x, b.y)
//    @JvmOverloads
//    fun and(bX: Ubyte, bY: Ubyte, res: Vec1ub = Vec1ub()) = and(res, this, bX, bY)
//
//    @JvmOverloads
//    fun and(bX: Byte, bY: Byte, res: Vec1ub = Vec1ub()) = and(res, this, bX, bY)
//
//    @JvmOverloads
//    fun and(bX: Int, bY: Int, res: Vec1ub = Vec1ub()) = and(res, this, bX, bY)
//
//    infix fun and_(b: Ubyte) = and(this, this, b, b)
//    infix fun and_(b: Byte) = and(this, this, b, b)
//    infix fun and_(b: Int) = and(this, this, b, b)
//    infix fun and_(b: Vec1ub) = and(this, this, b.x, b.y)
//    fun and_(bX: Ubyte, bY: Ubyte) = and(this, this, bX, bY)
//    fun and_(bX: Byte, bY: Byte) = and(this, this, bX, bY)
//    fun and_(bX: Int, bY: Int) = and(this, this, bX, bY)
//
//
//    infix fun or(b: Ubyte) = or(Vec1ub(), this, b, b)
//    infix fun or(b: Byte) = or(Vec1ub(), this, b, b)
//    infix fun or(b: Int) = or(Vec1ub(), this, b, b)
//    infix fun or(b: Vec1ub) = or(Vec1ub(), this, b.x, b.y)
//
//    fun or(b: Ubyte, res: Vec1ub) = or(res, this, b, b)
//    fun or(b: Byte, res: Vec1ub) = or(res, this, b, b)
//    fun or(b: Int, res: Vec1ub) = or(res, this, b, b)
//    fun or(b: Vec1ub, res: Vec1ub) = or(res, this, b.x, b.y)
//    @JvmOverloads
//    fun or(bX: Ubyte, bY: Ubyte, res: Vec1ub = Vec1ub()) = or(res, this, bX, bY)
//
//    @JvmOverloads
//    fun or(bX: Byte, bY: Byte, res: Vec1ub = Vec1ub()) = or(res, this, bX, bY)
//
//    @JvmOverloads
//    fun or(bX: Int, bY: Int, res: Vec1ub = Vec1ub()) = or(res, this, bX, bY)
//
//    infix fun or_(b: Ubyte) = or(this, this, b, b)
//    infix fun or_(b: Byte) = or(this, this, b, b)
//    infix fun or_(b: Int) = or(this, this, b, b)
//    infix fun or_(b: Vec1ub) = or(this, this, b.x, b.y)
//    fun or_(bX: Ubyte, bY: Ubyte) = or(this, this, bX, bY)
//    fun or_(bX: Byte, bY: Byte) = or(this, this, bX, bY)
//    fun or_(bX: Int, bY: Int) = or(this, this, bX, bY)
//
//
//    infix fun xor(b: Ubyte) = xor(Vec1ub(), this, b, b)
//    infix fun xor(b: Byte) = xor(Vec1ub(), this, b, b)
//    infix fun xor(b: Int) = xor(Vec1ub(), this, b, b)
//    infix fun xor(b: Vec1ub) = xor(Vec1ub(), this, b.x, b.y)
//
//    fun xor(b: Ubyte, res: Vec1ub) = xor(res, this, b, b)
//    fun xor(b: Byte, res: Vec1ub) = xor(res, this, b, b)
//    fun xor(b: Int, res: Vec1ub) = xor(res, this, b, b)
//    fun xor(b: Vec1ub, res: Vec1ub) = xor(res, this, b.x, b.y)
//    @JvmOverloads
//    fun xor(bX: Ubyte, bY: Ubyte, res: Vec1ub = Vec1ub()) = xor(res, this, bX, bY)
//
//    @JvmOverloads
//    fun xor(bX: Byte, bY: Byte, res: Vec1ub = Vec1ub()) = xor(res, this, bX, bY)
//
//    @JvmOverloads
//    fun xor(bX: Int, bY: Int, res: Vec1ub = Vec1ub()) = xor(res, this, bX, bY)
//
//    infix fun xor_(b: Ubyte) = xor(this, this, b, b)
//    infix fun xor_(b: Byte) = xor(this, this, b, b)
//    infix fun xor_(b: Int) = xor(this, this, b, b)
//    infix fun xor_(b: Vec1ub) = xor(this, this, b.x, b.y)
//    fun xor_(bX: Ubyte, bY: Ubyte) = xor(this, this, bX, bY)
//    fun xor_(bX: Byte, bY: Byte) = xor(this, this, bX, bY)
//    fun xor_(bX: Int, bY: Int) = xor(this, this, bX, bY)
//
//
//    infix fun shl(b: Ubyte) = shl(Vec1ub(), this, b, b)
//    infix fun shl(b: Byte) = shl(Vec1ub(), this, b, b)
//    infix fun shl(b: Int) = shl(Vec1ub(), this, b, b)
//    infix fun shl(b: Vec1ub) = shl(Vec1ub(), this, b.x, b.y)
//
//    fun shl(b: Ubyte, res: Vec1ub) = shl(res, this, b, b)
//    fun shl(b: Byte, res: Vec1ub) = shl(res, this, b, b)
//    fun shl(b: Int, res: Vec1ub) = shl(res, this, b, b)
//    fun shl(b: Vec1ub, res: Vec1ub) = shl(res, this, b.x, b.y)
//    @JvmOverloads
//    fun shl(bX: Ubyte, bY: Ubyte, res: Vec1ub = Vec1ub()) = shl(res, this, bX, bY)
//
//    @JvmOverloads
//    fun shl(bX: Byte, bY: Byte, res: Vec1ub = Vec1ub()) = shl(res, this, bX, bY)
//
//    @JvmOverloads
//    fun shl(bX: Int, bY: Int, res: Vec1ub = Vec1ub()) = shl(res, this, bX, bY)
//
//    infix fun shl_(b: Ubyte) = shl(this, this, b, b)
//    infix fun shl_(b: Byte) = shl(this, this, b, b)
//    infix fun shl_(b: Int) = shl(this, this, b, b)
//    infix fun shl_(b: Vec1ub) = shl(this, this, b.x, b.y)
//    fun shl_(bX: Ubyte, bY: Ubyte) = shl(this, this, bX, bY)
//    fun shl_(bX: Byte, bY: Byte) = shl(this, this, bX, bY)
//    fun shl_(bX: Int, bY: Int) = shl(this, this, bX, bY)
//
//
//    infix fun shr(b: Ubyte) = shr(Vec1ub(), this, b, b)
//    infix fun shr(b: Byte) = shr(Vec1ub(), this, b, b)
//    infix fun shr(b: Int) = shr(Vec1ub(), this, b, b)
//    infix fun shr(b: Vec1ub) = shr(Vec1ub(), this, b.x, b.y)
//
//    fun shr(b: Ubyte, res: Vec1ub) = shr(res, this, b, b)
//    fun shr(b: Byte, res: Vec1ub) = shr(res, this, b, b)
//    fun shr(b: Int, res: Vec1ub) = shr(res, this, b, b)
//    fun shr(b: Vec1ub, res: Vec1ub) = shr(res, this, b.x, b.y)
//    @JvmOverloads
//    fun shr(bX: Ubyte, bY: Ubyte, res: Vec1ub = Vec1ub()) = shr(res, this, bX, bY)
//
//    @JvmOverloads
//    fun shr(bX: Byte, bY: Byte, res: Vec1ub = Vec1ub()) = shr(res, this, bX, bY)
//
//    @JvmOverloads
//    fun shr(bX: Int, bY: Int, res: Vec1ub = Vec1ub()) = shr(res, this, bX, bY)
//
//    infix fun shr_(b: Ubyte) = shr(this, this, b, b)
//    infix fun shr_(b: Byte) = shr(this, this, b, b)
//    infix fun shr_(b: Int) = shr(this, this, b, b)
//    infix fun shr_(b: Vec1ub) = shr(this, this, b.x, b.y)
//    fun shr_(bX: Ubyte, bY: Ubyte) = shr(this, this, bX, bY)
//    fun shr_(bX: Byte, bY: Byte) = shr(this, this, bX, bY)
//    fun shr_(bX: Int, bY: Int) = shr(this, this, bX, bY)
//
//
//    @JvmOverloads
//    fun inv(res: Vec1ub = Vec1ub()) = inv(res, this)
//
//    fun inv_() = inv(this, this)
//
//
//    // -- Generic bitwise operators --
//
//    infix fun and(b: Number) = and(Vec1ub(), this, b.b, b.b)
//    infix fun and(b: Vec2t<out Number>) = and(Vec1ub(), this, b.x.b, b.y.b)
//
//    fun and(b: Number, res: Vec1ub) = and(res, this, b.i, b.i)
//    fun and(b: Vec2t<out Number>, res: Vec1ub) = and(res, this, b.x.i, b.y.i)
//    @JvmOverloads
//    fun and(bX: Number, bY: Number, res: Vec1ub = Vec1ub()) = and(res, this, bX.i, bY.i)
//
//    infix fun and_(b: Number) = and(this, this, b.i, b.i)
//    infix fun and_(b: Vec2t<out Number>) = and(this, this, b.x.i, b.y.i)
//    fun and_(bX: Number, bY: Number) = and(this, this, bX.i, bY.i)
//
//
//    infix fun or(b: Number) = or(Vec1ub(), this, b.i, b.i)
//    infix fun or(b: Vec2t<out Number>) = or(Vec1ub(), this, b.x.i, b.y.i)
//
//    fun or(b: Number, res: Vec1ub) = or(res, this, b.i, b.i)
//    fun or(b: Vec2t<out Number>, res: Vec1ub) = or(res, this, b.x.i, b.y.i)
//    @JvmOverloads
//    fun or(bX: Number, bY: Number, res: Vec1ub = Vec1ub()) = or(res, this, bX.i, bY.i)
//
//    infix fun or_(b: Number) = or(this, this, b.i, b.i)
//    infix fun or_(b: Vec2t<out Number>) = or(this, this, b.x.i, b.y.i)
//    fun or_(bX: Number, bY: Number) = or(this, this, bX.i, bY.i)
//
//
//    infix fun xor(b: Number) = xor(Vec1ub(), this, b.i, b.i)
//    infix fun xor(b: Vec2t<out Number>) = xor(Vec1ub(), this, b.x.i, b.y.i)
//
//    fun xor(b: Number, res: Vec1ub) = xor(res, this, b.i, b.i)
//    fun xor(b: Vec2t<out Number>, res: Vec1ub) = xor(res, this, b.x.i, b.y.i)
//    @JvmOverloads
//    fun xor(bX: Number, bY: Number, res: Vec1ub = Vec1ub()) = xor(res, this, bX.i, bY.i)
//
//    infix fun xor_(b: Number) = xor(this, this, b.i, b.i)
//    infix fun xor_(b: Vec2t<out Number>) = xor(this, this, b.x.i, b.y.i)
//    fun xor_(bX: Number, bY: Number) = xor(this, this, bX.i, bY.i)
//
//
//    infix fun shl(b: Number) = shl(Vec1ub(), this, b.i, b.i)
//    infix fun shl(b: Vec2t<out Number>) = shl(Vec1ub(), this, b.x.i, b.y.i)
//
//    fun shl(b: Number, res: Vec1ub) = shl(res, this, b.i, b.i)
//    fun shl(b: Vec2t<out Number>, res: Vec1ub) = shl(res, this, b.x.i, b.y.i)
//    @JvmOverloads
//    fun shl(bX: Number, bY: Number, res: Vec1ub = Vec1ub()) = shl(res, this, bX.i, bY.i)
//
//    infix fun shl_(b: Number) = shl(this, this, b.i, b.i)
//    infix fun shl_(b: Vec2t<out Number>) = shl(this, this, b.x.i, b.y.i)
//    fun shl_(bX: Number, bY: Number) = shl(this, this, bX.i, bY.i)
//
//
//    infix fun shr(b: Number) = shr(Vec1ub(), this, b.i, b.i)
//    infix fun shr(b: Vec2t<out Number>) = shr(Vec1ub(), this, b.x.i, b.y.i)
//
//    fun shr(b: Number, res: Vec1ub) = shr(res, this, b.i, b.i)
//    fun shr(b: Vec2t<out Number>, res: Vec1ub) = shr(res, this, b.x.i, b.y.i)
//    @JvmOverloads
//    fun shr(bX: Number, bY: Number, res: Vec1ub = Vec1ub()) = shr(res, this, bX.i, bY.i)
//
//    infix fun shr_(b: Number) = shr(this, this, b.i, b.i)
//    infix fun shr_(b: Vec2t<out Number>) = shr(this, this, b.x.i, b.y.i)
//    fun shr_(bX: Number, bY: Number) = shr(this, this, bX.i, bY.i)


    override fun equals(other: Any?) = other is Vec1ub && this[0] == other[0]
    override fun hashCode() = x.v.hashCode()
}