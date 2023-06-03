package glm_.vec1

import glm_.*
import glm_.vec1.operators.opVec1us
import glm_.vec2.Vec2bool
import glm_.vec2.Vec2t
import glm_.vec2.Vec2ub
import glm_.vec2.Vec2us
import glm_.vec3.Vec3bool
import glm_.vec3.Vec3t
import glm_.vec3.Vec3ub
import glm_.vec3.Vec3us
import glm_.vec4.Vec4bool
import glm_.vec4.Vec4t
import glm_.vec4.Vec4ub
import glm_.vec4.Vec4us
import kool.ShortBuffer
import kool.pos
import kool.set
import unsigned.Ushort
import java.lang.Math.abs
import java.nio.*

/**
 * Created by elect on 08/10/16.
 */

class Vec1us(@JvmField inline var x: Ushort) : Vec1t<Ushort>, ToShortBuffer {

    // -- Implicit basic constructors --

    constructor() : this(0)
    constructor(v: Number) : this(v.us)

    // -- Explicit basic constructors --
    // Explicit conversions (From section 5.4.1 Conversion and scalar constructors of GLSL 1.30.08 specification)

    constructor(v: Vec1us) : this(v.x)
    constructor(v: Vec2us) : this(v.x)
    constructor(v: Vec3us) : this(v.x)
    constructor(v: Vec4us) : this(v.x)

    constructor(v: Vec1t<out Number>) : this(v._x)
    constructor(v: Vec2t<out Number>) : this(v._x)
    constructor(v: Vec3t<out Number>) : this(v._x)
    constructor(v: Vec4t<out Number>) : this(v._x)

    constructor(v: Vec1bool) : this(v.x.us)
    constructor(v: Vec2bool) : this(v.x.us)
    constructor(v: Vec3bool) : this(v.x.us)
    constructor(v: Vec4bool) : this(v.x.us)

    constructor(bytes: ByteArray, index: Int = 0, oneByteOneUshort: Boolean = false, bigEndian: Boolean = true) : this(
            if (oneByteOneUshort) bytes[index].us else bytes.getUshort(index, bigEndian))

    constructor(chars: CharArray, index: Int = 0) : this(chars[index].us)
    constructor(shorts: ShortArray, index: Int = 0) : this(shorts[index])
    constructor(ints: IntArray, index: Int = 0) : this(ints[index])
    constructor(longs: LongArray, index: Int = 0) : this(longs[index])
    constructor(floats: FloatArray, index: Int = 0) : this(floats[index])
    constructor(doubles: DoubleArray, index: Int = 0) : this(doubles[index])
    constructor(booleans: BooleanArray, index: Int = 0) : this(booleans[index].us)

    constructor(numbers: Array<out Number>, index: Int = 0) : this(numbers[index])
    constructor(chars: Array<Char>, index: Int = 0) : this(chars[index].us)
    constructor(booleans: Array<Boolean>, index: Int = 0) : this(booleans[index].us)

    constructor(list: List<Any>, index: Int = 0) : this(list[index].toShort)

    constructor(bytes: ByteBuffer, index: Int = bytes.pos, oneByteOneUshort: Boolean = false) : this(
            if (oneByteOneUshort) bytes[index].us else bytes.getShort(index).us)

    constructor(chars: CharBuffer, index: Int = chars.pos) : this(chars[index].us)
    constructor(shorts: ShortBuffer, index: Int = shorts.pos) : this(shorts[index])
    constructor(ints: IntBuffer, index: Int = ints.pos) : this(ints[index])
    constructor(longs: LongBuffer, index: Int = longs.pos) : this(longs[index])
    constructor(floats: FloatBuffer, index: Int = floats.pos) : this(floats[index])
    constructor(doubles: DoubleBuffer, index: Int = doubles.pos) : this(doubles[index])

    constructor(block: (Int) -> Ushort) : this(block(0))


    fun set(bytes: ByteArray, index: Int = 0, oneByteOneShort: Boolean = false, bigEndian: Boolean = true) {
        x.v = if (oneByteOneShort) bytes[index].s else bytes.getShort(index, bigEndian)
    }

    fun set(bytes: ByteBuffer, index: Int = bytes.pos, oneByteOneShort: Boolean = false) {
        x.v = if (oneByteOneShort) bytes[index].s else bytes.getShort(index)
    }


    fun put(x: Ushort) {
        this.x = x
    }

    operator fun invoke(x: Ushort): Vec1us {
        this.x = x
        return this
    }

    fun put(x: Short) {
        this.x.v = x
    }

    operator fun invoke(x: Short): Vec1us {
        this.x.v = x
        return this
    }

    override fun put(x: Number) {
        this.x = x.us
    }

    override operator fun invoke(x: Number): Vec1us {
        this.x = x.us
        return this
    }

    fun to(bytes: ByteArray, offset: Int) = to(bytes, offset, true)
    override fun to(bytes: ByteArray, index: Int, bigEndian: Boolean): ByteArray {
        bytes.putShort(index, x.v)
        return bytes
    }

    override fun to(buf: ByteBuffer, offset: Int): ByteBuffer = buf.putShort(offset, x.v)

    fun toShortArray(): ShortArray = to(ShortArray(length), 0)
    infix fun to(shorts: ShortArray): ShortArray = to(shorts, 0)
    fun to(shorts: ShortArray, index: Int): ShortArray {
        shorts[index] = x.v
        return shorts
    }

    fun to(buf: ShortBuffer, index: Int): ShortBuffer {
        buf[index] = x.v
        return buf
    }


    // -- Unary arithmetic operators --

//    operator fun unaryPlus() = this
//
//    // no unaryMinus operator, only signed
//
//    // -- Increment main.and decrement operators --
//
//    operator fun inc(res: Vec1us = Vec1us()) = plus(res, this, 1, 1)
//    fun inc_() = plus(this, this, 1, 1)
//
//
//    operator fun dec(res: Vec1us = Vec1us()) = minus(res, this, 1, 1)
//    fun dec_() = minus(this, this, 1, 1)
//
//
//    // -- Specific binary arithmetic operators --
//
//    operator fun plus(b: Ushort) = plus(Vec1us(), this, b, b)
//    operator fun plus(b: Short) = plus(Vec1us(), this, b, b)
//    operator fun plus(b: Int) = plus(Vec1us(), this, b, b)
//    operator fun plus(b: Vec1us) = plus(Vec1us(), this, b.x, b.y)
//
//    fun plus(bX: Ushort, bY: Ushort, res: Vec1us = Vec1us()) = plus(res, this, bX, bY)
//    fun plus(bX: Short, bY: Short, res: Vec1us = Vec1us()) = plus(res, this, bX, bY)
//    fun plus(bX: Int, bY: Int, res: Vec1us = Vec1us()) = plus(res, this, bX, bY)
//    fun plus(b: Ushort, res: Vec1us = Vec1us()) = plus(res, this, b, b)
//    fun plus(b: Short, res: Vec1us = Vec1us()) = plus(res, this, b, b)
//    fun plus(b: Int, res: Vec1us = Vec1us()) = plus(res, this, b, b)
//    fun plus(b: Vec1us, res: Vec1us = Vec1us()) = plus(res, this, b.x, b.y)
//
//    fun plus_(bX: Ushort, bY: Ushort) = plus(this, this, bX, bY)
//    fun plus_(bX: Short, bY: Short) = plus(this, this, bX, bY)
//    fun plus_(bX: Int, bY: Int) = plus(this, this, bX, bY)
//    infix fun plus_(b: Ushort) = plus(this, this, b, b)
//    infix fun plus_(b: Short) = plus(this, this, b, b)
//    infix fun plus_(b: Int) = plus(this, this, b, b)
//    infix fun plus_(b: Vec1us) = plus(this, this, b.x, b.y)
//
//
//    operator fun minus(b: Ushort) = minus(Vec1us(), this, b, b)
//    operator fun minus(b: Short) = minus(Vec1us(), this, b, b)
//    operator fun minus(b: Int) = minus(Vec1us(), this, b, b)
//    operator fun minus(b: Vec1us) = minus(Vec1us(), this, b.x, b.y)
//
//    fun minus(bX: Ushort, bY: Ushort, res: Vec1us = Vec1us()) = minus(res, this, bX, bY)
//    fun minus(bX: Short, bY: Short, res: Vec1us = Vec1us()) = minus(res, this, bX, bY)
//    fun minus(bX: Int, bY: Int, res: Vec1us = Vec1us()) = minus(res, this, bX, bY)
//    fun minus(b: Ushort, res: Vec1us = Vec1us()) = minus(res, this, b, b)
//    fun minus(b: Short, res: Vec1us = Vec1us()) = minus(res, this, b, b)
//    fun minus(b: Int, res: Vec1us = Vec1us()) = minus(res, this, b, b)
//    fun minus(b: Vec1us, res: Vec1us = Vec1us()) = minus(res, this, b.x, b.y)
//
//    fun minus_(bX: Ushort, bY: Ushort) = minus(this, this, bX, bY)
//    fun minus_(bX: Short, bY: Short) = minus(this, this, bX, bY)
//    fun minus_(bX: Int, bY: Int) = minus(this, this, bX, bY)
//    infix fun minus_(b: Ushort) = minus(this, this, b, b)
//    infix fun minus_(b: Short) = minus(this, this, b, b)
//    infix fun minus_(b: Int) = minus(this, this, b, b)
//    infix fun minus_(b: Vec1us) = minus(this, this, b.x, b.y)
//
//
//    operator fun times(b: Ushort) = times(Vec1us(), this, b, b)
//    operator fun times(b: Short) = times(Vec1us(), this, b, b)
//    operator fun times(b: Int) = times(Vec1us(), this, b, b)
//    operator fun times(b: Vec1us) = times(Vec1us(), this, b.x, b.y)
//
//    fun times(bX: Ushort, bY: Ushort, res: Vec1us = Vec1us()) = times(res, this, bX, bY)
//    fun times(bX: Short, bY: Short, res: Vec1us = Vec1us()) = times(res, this, bX, bY)
//    fun times(bX: Int, bY: Int, res: Vec1us = Vec1us()) = times(res, this, bX, bY)
//    fun times(b: Ushort, res: Vec1us = Vec1us()) = times(res, this, b, b)
//    fun times(b: Short, res: Vec1us = Vec1us()) = times(res, this, b, b)
//    fun times(b: Int, res: Vec1us = Vec1us()) = times(res, this, b, b)
//    fun times(b: Vec1us, res: Vec1us = Vec1us()) = times(res, this, b.x, b.y)
//
//    fun times_(bX: Ushort, bY: Ushort) = times(this, this, bX, bY)
//    fun times_(bX: Short, bY: Short) = times(this, this, bX, bY)
//    fun times_(bX: Int, bY: Int) = times(this, this, bX, bY)
//    infix fun times_(b: Ushort) = times(this, this, b, b)
//    infix fun times_(b: Short) = times(this, this, b, b)
//    infix fun times_(b: Int) = times(this, this, b, b)
//    infix fun times_(b: Vec1us) = times(this, this, b.x, b.y)
//
//
//    operator fun div(b: Ushort) = div(Vec1us(), this, b, b)
//    operator fun div(b: Short) = div(Vec1us(), this, b, b)
//    operator fun div(b: Int) = div(Vec1us(), this, b, b)
//    operator fun div(b: Vec1us) = div(Vec1us(), this, b.x, b.y)
//
//    fun div(bX: Ushort, bY: Ushort, res: Vec1us = Vec1us()) = div(res, this, bX, bY)
//    fun div(bX: Short, bY: Short, res: Vec1us = Vec1us()) = div(res, this, bX, bY)
//    fun div(bX: Int, bY: Int, res: Vec1us = Vec1us()) = div(res, this, bX, bY)
//    fun div(b: Ushort, res: Vec1us = Vec1us()) = div(res, this, b, b)
//    fun div(b: Short, res: Vec1us = Vec1us()) = div(res, this, b, b)
//    fun div(b: Int, res: Vec1us = Vec1us()) = div(res, this, b, b)
//    fun div(b: Vec1us, res: Vec1us = Vec1us()) = div(res, this, b.x, b.y)
//
//    fun div_(bX: Ushort, bY: Ushort) = div(this, this, bX, bY)
//    fun div_(bX: Short, bY: Short) = div(this, this, bX, bY)
//    fun div_(bX: Int, bY: Int) = div(this, this, bX, bY)
//    infix fun div_(b: Ushort) = div(this, this, b, b)
//    infix fun div_(b: Short) = div(this, this, b, b)
//    infix fun div_(b: Int) = div(this, this, b, b)
//    infix fun div_(b: Vec1us) = div(this, this, b.x, b.y)
//
//
//    operator fun rem(b: Ushort) = rem(Vec1us(), this, b, b)
//    operator fun rem(b: Short) = rem(Vec1us(), this, b, b)
//    operator fun rem(b: Int) = rem(Vec1us(), this, b, b)
//    operator fun rem(b: Vec1us) = rem(Vec1us(), this, b.x, b.y)
//
//    fun rem(bX: Ushort, bY: Ushort, res: Vec1us = Vec1us()) = rem(res, this, bX, bY)
//    fun rem(bX: Short, bY: Short, res: Vec1us = Vec1us()) = rem(res, this, bX, bY)
//    fun rem(bX: Int, bY: Int, res: Vec1us = Vec1us()) = rem(res, this, bX, bY)
//    fun rem(b: Ushort, res: Vec1us = Vec1us()) = rem(res, this, b, b)
//    fun rem(b: Short, res: Vec1us = Vec1us()) = rem(res, this, b, b)
//    fun rem(b: Int, res: Vec1us = Vec1us()) = rem(res, this, b, b)
//    fun rem(b: Vec1us, res: Vec1us = Vec1us()) = rem(res, this, b.x, b.y)
//
//    fun rem_(bX: Ushort, bY: Ushort) = rem(this, this, bX, bY)
//    fun rem_(bX: Short, bY: Short) = rem(this, this, bX, bY)
//    fun rem_(bX: Int, bY: Int) = rem(this, this, bX, bY)
//    infix fun rem_(b: Ushort) = rem(this, this, b, b)
//    infix fun rem_(b: Short) = rem(this, this, b, b)
//    infix fun rem_(b: Int) = rem(this, this, b, b)
//    infix fun rem_(b: Vec1us) = rem(this, this, b.x, b.y)
//
//
//    // -- Generic binary arithmetic operators --
//
//    operator fun plus(b: Number) = plus(Vec1us(), this, b.i, b.i)
//    operator fun plus(b: Vec2t<out Number>) = plus(Vec1us(), this, b.x.i, b.y.i)
//
//    fun plus(bX: Number, bY: Number, res: Vec1us = Vec1us()) = plus(res, this, bX.i, bY.i)
//    fun plus(b: Number, res: Vec1us = Vec1us()) = plus(res, this, b.i, b.i)
//    fun plus(b: Vec2t<out Number>, res: Vec1us = Vec1us()) = plus(res, this, b.x.i, b.y.i)
//
//    fun plus_(bX: Number, bY: Number) = plus(this, this, bX.i, bY.i)
//    infix fun plus_(b: Number) = plus(this, this, b.i, b.i)
//    infix fun plus_(b: Vec2t<out Number>) = plus(this, this, b.x.i, b.y.i)
//
//
//    operator fun minus(b: Number) = minus(Vec1us(), this, b.i, b.i)
//    operator fun minus(b: Vec2t<out Number>) = minus(Vec1us(), this, b.x.i, b.y.i)
//
//    fun minus(bX: Number, bY: Number, res: Vec1us = Vec1us()) = minus(res, this, bX.i, bY.i)
//    fun minus(b: Number, res: Vec1us = Vec1us()) = minus(res, this, b.i, b.i)
//    fun minus(b: Vec2t<out Number>, res: Vec1us = Vec1us()) = minus(res, this, b.x.i, b.y.i)
//
//    fun minus_(bX: Number, bY: Number) = minus(this, this, bX.i, bY.i)
//    infix fun minus_(b: Number) = minus(this, this, b.i, b.i)
//    infix fun minus_(b: Vec2t<out Number>) = minus(this, this, b.x.i, b.y.i)
//
//
//    operator fun times(b: Number) = times(Vec1us(), this, b.i, b.i)
//    operator fun times(b: Vec2t<out Number>) = times(Vec1us(), this, b.x.i, b.y.i)
//
//    fun times(bX: Number, bY: Number, res: Vec1us = Vec1us()) = times(res, this, bX.i, bY.i)
//    fun times(b: Number, res: Vec1us = Vec1us()) = times(res, this, b.i, b.i)
//    fun times(b: Vec2t<out Number>, res: Vec1us = Vec1us()) = times(res, this, b.x.i, b.y.i)
//
//    fun times_(bX: Number, bY: Number) = times(this, this, bX.i, bY.i)
//    infix fun times_(b: Number) = times(this, this, b.i, b.i)
//    infix fun times_(b: Vec2t<out Number>) = times(this, this, b.x.i, b.y.i)
//
//
//    operator fun div(b: Number) = div(Vec1us(), this, b.i, b.i)
//    operator fun div(b: Vec2t<out Number>) = div(Vec1us(), this, b.x.i, b.y.i)
//
//    fun div(bX: Number, bY: Number, res: Vec1us = Vec1us()) = div(res, this, bX.i, bY.i)
//    fun div(b: Number, res: Vec1us = Vec1us()) = div(res, this, b.i, b.i)
//    fun div(b: Vec2t<out Number>, res: Vec1us = Vec1us()) = div(res, this, b.x.i, b.y.i)
//
//    fun div_(bX: Number, bY: Number) = div(this, this, bX.i, bY.i)
//    infix fun div_(b: Number) = div(this, this, b.i, b.i)
//    infix fun div_(b: Vec2t<out Number>) = div(this, this, b.x.i, b.y.i)
//
//
//    operator fun rem(b: Number) = rem(Vec1us(), this, b.i, b.i)
//    operator fun rem(b: Vec2t<out Number>) = rem(Vec1us(), this, b.x.i, b.y.i)
//
//    fun rem(bX: Number, bY: Number, res: Vec1us = Vec1us()) = rem(res, this, bX.i, bY.i)
//    fun rem(b: Number, res: Vec1us = Vec1us()) = rem(res, this, b.i, b.i)
//    fun rem(b: Vec2t<out Number>, res: Vec1us = Vec1us()) = rem(res, this, b.x.i, b.y.i)
//
//    fun rem_(bX: Number, bY: Number) = rem(this, this, bX.i, bY.i)
//    infix fun rem_(b: Number) = rem(this, this, b.i, b.i)
//    infix fun rem_(b: Vec2t<out Number>) = rem(this, this, b.x.i, b.y.i)
//
//
//    // -- Specific bitwise operators --
//
//    infix fun and(b: Ushort) = and(Vec1us(), this, b, b)
//    infix fun and(b: Short) = and(Vec1us(), this, b, b)
//    infix fun and(b: Int) = and(Vec1us(), this, b, b)
//    fun and(bX: Ushort, bY: Ushort) = and(Vec1us(), this, bX, bY)
//    fun and(bX: Short, bY: Short) = and(Vec1us(), this, bX, bY)
//    fun and(bX: Int, bY: Int) = and(Vec1us(), this, bX, bY)
//    fun and(b: Vec1us) = and(Vec1us(), this, b.x, b.y)
//
//    infix fun and_(b: Ushort) = and(this, this, b, b)
//    infix fun and_(b: Short) = and(this, this, b, b)
//    infix fun and_(b: Int) = and(this, this, b, b)
//    fun and_(bX: Ushort, bY: Ushort) = and(this, this, bX, bY)
//    fun and_(bX: Short, bY: Short) = and(this, this, bX, bY)
//    fun and_(bX: Int, bY: Int) = and(this, this, bX, bY)
//    infix fun and_(b: Vec1us) = and(this, this, b.x, b.y)
//
//    fun and(b: Ushort, res: Vec1us) = and(res, this, b, b)
//    fun and(b: Short, res: Vec1us) = and(res, this, b, b)
//    fun and(b: Int, res: Vec1us) = and(res, this, b, b)
//    fun and(bX: Ushort, bY: Ushort, res: Vec1us) = and(res, this, bX, bY)
//    fun and(bX: Short, bY: Short, res: Vec1us) = and(res, this, bX, bY)
//    fun and(bX: Int, bY: Int, res: Vec1us) = and(res, this, bX, bY)
//    fun and(b: Vec1us, res: Vec1us) = and(res, this, b.x, b.y)
//
//
//    infix fun or(b: Ushort) = or(Vec1us(), this, b, b)
//    infix fun or(b: Short) = or(Vec1us(), this, b, b)
//    infix fun or(b: Int) = or(Vec1us(), this, b, b)
//    fun or(bX: Ushort, bY: Ushort) = or(Vec1us(), this, bX, bY)
//    fun or(bX: Short, bY: Short) = or(Vec1us(), this, bX, bY)
//    fun or(bX: Int, bY: Int) = or(Vec1us(), this, bX, bY)
//    fun or(b: Vec1us) = or(Vec1us(), this, b.x, b.y)
//
//    infix fun or_(b: Ushort) = or(this, this, b, b)
//    infix fun or_(b: Short) = or(this, this, b, b)
//    infix fun or_(b: Int) = or(this, this, b, b)
//    fun or_(bX: Ushort, bY: Ushort) = or(this, this, bX, bY)
//    fun or_(bX: Short, bY: Short) = or(this, this, bX, bY)
//    fun or_(bX: Int, bY: Int) = or(this, this, bX, bY)
//    infix fun or_(b: Vec1us) = or(this, this, b.x, b.y)
//
//    fun or(b: Ushort, res: Vec1us) = or(res, this, b, b)
//    fun or(b: Short, res: Vec1us) = or(res, this, b, b)
//    fun or(b: Int, res: Vec1us) = or(res, this, b, b)
//    fun or(bX: Ushort, bY: Ushort, res: Vec1us) = or(res, this, bX, bY)
//    fun or(bX: Short, bY: Short, res: Vec1us) = or(res, this, bX, bY)
//    fun or(bX: Int, bY: Int, res: Vec1us) = or(res, this, bX, bY)
//    fun or(b: Vec1us, res: Vec1us) = or(res, this, b.x, b.y)
//
//
//    infix fun xor(b: Ushort) = xor(Vec1us(), this, b, b)
//    infix fun xor(b: Short) = xor(Vec1us(), this, b, b)
//    infix fun xor(b: Int) = xor(Vec1us(), this, b, b)
//    fun xor(bX: Ushort, bY: Ushort) = xor(Vec1us(), this, bX, bY)
//    fun xor(bX: Short, bY: Short) = xor(Vec1us(), this, bX, bY)
//    fun xor(bX: Int, bY: Int) = xor(Vec1us(), this, bX, bY)
//    fun xor(b: Vec1us) = xor(Vec1us(), this, b.x, b.y)
//
//    infix fun xor_(b: Ushort) = xor(this, this, b, b)
//    infix fun xor_(b: Short) = xor(this, this, b, b)
//    infix fun xor_(b: Int) = xor(this, this, b, b)
//    fun xor_(bX: Ushort, bY: Ushort) = xor(this, this, bX, bY)
//    fun xor_(bX: Short, bY: Short) = xor(this, this, bX, bY)
//    fun xor_(bX: Int, bY: Int) = xor(this, this, bX, bY)
//    infix fun xor_(b: Vec1us) = xor(this, this, b.x, b.y)
//
//    fun xor(b: Ushort, res: Vec1us) = xor(res, this, b, b)
//    fun xor(b: Short, res: Vec1us) = xor(res, this, b, b)
//    fun xor(b: Int, res: Vec1us) = xor(res, this, b, b)
//    fun xor(bX: Ushort, bY: Ushort, res: Vec1us) = xor(res, this, bX, bY)
//    fun xor(bX: Short, bY: Short, res: Vec1us) = xor(res, this, bX, bY)
//    fun xor(bX: Int, bY: Int, res: Vec1us) = xor(res, this, bX, bY)
//    fun xor(b: Vec1us, res: Vec1us) = xor(res, this, b.x, b.y)
//
//
//    infix fun shl(b: Ushort) = shl(Vec1us(), this, b, b)
//    infix fun shl(b: Short) = shl(Vec1us(), this, b, b)
//    infix fun shl(b: Int) = shl(Vec1us(), this, b, b)
//    fun shl(bX: Ushort, bY: Ushort) = shl(Vec1us(), this, bX, bY)
//    fun shl(bX: Short, bY: Short) = shl(Vec1us(), this, bX, bY)
//    fun shl(bX: Int, bY: Int) = shl(Vec1us(), this, bX, bY)
//    fun shl(b: Vec1us) = shl(Vec1us(), this, b.x, b.y)
//
//    infix fun shl_(b: Ushort) = shl(this, this, b, b)
//    infix fun shl_(b: Short) = shl(this, this, b, b)
//    infix fun shl_(b: Int) = shl(this, this, b, b)
//    fun shl_(bX: Ushort, bY: Ushort) = shl(this, this, bX, bY)
//    fun shl_(bX: Short, bY: Short) = shl(this, this, bX, bY)
//    fun shl_(bX: Int, bY: Int) = shl(this, this, bX, bY)
//    infix fun shl_(b: Vec1us) = shl(this, this, b.x, b.y)
//
//    fun shl(b: Ushort, res: Vec1us) = shl(res, this, b, b)
//    fun shl(b: Short, res: Vec1us) = shl(res, this, b, b)
//    fun shl(b: Int, res: Vec1us) = shl(res, this, b, b)
//    fun shl(bX: Ushort, bY: Ushort, res: Vec1us) = shl(res, this, bX, bY)
//    fun shl(bX: Short, bY: Short, res: Vec1us) = shl(res, this, bX, bY)
//    fun shl(bX: Int, bY: Int, res: Vec1us) = shl(res, this, bX, bY)
//    fun shl(b: Vec1us, res: Vec1us) = shl(res, this, b.x, b.y)
//
//
//    infix fun shr(b: Ushort) = shr(Vec1us(), this, b, b)
//    infix fun shr(b: Short) = shr(Vec1us(), this, b, b)
//    infix fun shr(b: Int) = shr(Vec1us(), this, b, b)
//    fun shr(bX: Ushort, bY: Ushort) = shr(Vec1us(), this, bX, bY)
//    fun shr(bX: Short, bY: Short) = shr(Vec1us(), this, bX, bY)
//    fun shr(bX: Int, bY: Int) = shr(Vec1us(), this, bX, bY)
//    fun shr(b: Vec1us) = shr(Vec1us(), this, b.x, b.y)
//
//    infix fun shr_(b: Ushort) = shr(this, this, b, b)
//    infix fun shr_(b: Short) = shr(this, this, b, b)
//    infix fun shr_(b: Int) = shr(this, this, b, b)
//    fun shr_(bX: Ushort, bY: Ushort) = shr(this, this, bX, bY)
//    fun shr_(bX: Short, bY: Short) = shr(this, this, bX, bY)
//    fun shr_(bX: Int, bY: Int) = shr(this, this, bX, bY)
//    infix fun shr_(b: Vec1us) = shr(this, this, b.x, b.y)
//
//    fun shr(b: Ushort, res: Vec1us) = shr(res, this, b, b)
//    fun shr(b: Short, res: Vec1us) = shr(res, this, b, b)
//    fun shr(b: Int, res: Vec1us) = shr(res, this, b, b)
//    fun shr(bX: Ushort, bY: Ushort, res: Vec1us) = shr(res, this, bX, bY)
//    fun shr(bX: Short, bY: Short, res: Vec1us) = shr(res, this, bX, bY)
//    fun shr(bX: Int, bY: Int, res: Vec1us) = shr(res, this, bX, bY)
//    fun shr(b: Vec1us, res: Vec1us) = shr(res, this, b.x, b.y)
//
//
//    fun inv(res: Vec1us = Vec1us()) = inv(res, this)
//    fun inv_() = inv(this, this)
//
//
//    // -- Generic bitwise operators --
//
//    infix fun and(b: Number) = and(Vec1us(), this, b.i, b.i)
//    fun and(bX: Number, bY: Number) = and(Vec1us(), this, bX.i, bY.i)
//    fun and(b: Vec2t<out Number>) = and(Vec1us(), this, b.x.i, b.y.i)
//
//    infix fun and_(b: Number) = and(this, this, b.i, b.i)
//    fun and_(bX: Number, bY: Number) = and(this, this, bX.i, bY.i)
//    infix fun and_(b: Vec2t<out Number>) = and(this, this, b.x.i, b.y.i)
//
//    fun and(b: Number, res: Vec1us) = and(res, this, b.i, b.i)
//    fun and(bX: Number, bY: Number, res: Vec1us) = and(res, this, bX.i, bY.i)
//    fun and(b: Vec2t<out Number>, res: Vec1us) = and(res, this, b.x.i, b.y.i)
//
//
//    infix fun or(b: Number) = or(Vec1us(), this, b.i, b.i)
//    fun or(bX: Number, bY: Number) = or(Vec1us(), this, bX.i, bY.i)
//    fun or(b: Vec2t<out Number>) = or(Vec1us(), this, b.x.i, b.y.i)
//
//    infix fun or_(b: Number) = or(this, this, b.i, b.i)
//    fun or_(bX: Number, bY: Number) = or(this, this, bX.i, bY.i)
//    infix fun or_(b: Vec2t<out Number>) = or(this, this, b.x.i, b.y.i)
//
//    fun or(b: Number, res: Vec1us) = or(res, this, b.i, b.i)
//    fun or(bX: Number, bY: Number, res: Vec1us) = or(res, this, bX.i, bY.i)
//    fun or(b: Vec2t<out Number>, res: Vec1us) = or(res, this, b.x.i, b.y.i)
//
//
//    infix fun xor(b: Number) = xor(Vec1us(), this, b.i, b.i)
//    fun xor(bX: Number, bY: Number) = xor(Vec1us(), this, bX.i, bY.i)
//    fun xor(b: Vec2t<out Number>) = xor(Vec1us(), this, b.x.i, b.y.i)
//
//    infix fun xor_(b: Number) = xor(this, this, b.i, b.i)
//    fun xor_(bX: Number, bY: Number) = xor(this, this, bX.i, bY.i)
//    infix fun xor_(b: Vec2t<out Number>) = xor(this, this, b.x.i, b.y.i)
//
//    fun xor(b: Number, res: Vec1us) = xor(res, this, b.i, b.i)
//    fun xor(bX: Number, bY: Number, res: Vec1us) = xor(res, this, bX.i, bY.i)
//    fun xor(b: Vec2t<out Number>, res: Vec1us) = xor(res, this, b.x.i, b.y.i)
//
//
//    infix fun shl(b: Number) = shl(Vec1us(), this, b.i, b.i)
//    fun shl(bX: Number, bY: Number) = shl(Vec1us(), this, bX.i, bY.i)
//    fun shl(b: Vec2t<out Number>) = shl(Vec1us(), this, b.x.i, b.y.i)
//
//    infix fun shl_(b: Number) = shl(this, this, b.i, b.i)
//    fun shl_(bX: Number, bY: Number) = shl(this, this, bX.i, bY.i)
//    infix fun shl_(b: Vec2t<out Number>) = shl(this, this, b.x.i, b.y.i)
//
//    fun shl(b: Number, res: Vec1us) = shl(res, this, b.i, b.i)
//    fun shl(bX: Number, bY: Number, res: Vec1us) = shl(res, this, bX.i, bY.i)
//    fun shl(b: Vec2t<out Number>, res: Vec1us) = shl(res, this, b.x.i, b.y.i)
//
//
//    infix fun shr(b: Number) = shr(Vec1us(), this, b.i, b.i)
//    fun shr(bX: Number, bY: Number) = shr(Vec1us(), this, bX.i, bY.i)
//    fun shr(b: Vec2t<out Number>) = shr(Vec1us(), this, b.x.i, b.y.i)
//
//    infix fun shr_(b: Number) = shr(this, this, b.i, b.i)
//    fun shr_(bX: Number, bY: Number) = shr(this, this, bX.i, bY.i)
//    infix fun shr_(b: Vec2t<out Number>) = shr(this, this, b.x.i, b.y.i)
//
//    fun shr(b: Number, res: Vec1us) = shr(res, this, b.i, b.i)
//    fun shr(bX: Number, bY: Number, res: Vec1us) = shr(res, this, bX.i, bY.i)
//    fun shr(b: Vec2t<out Number>, res: Vec1us) = shr(res, this, b.x.i, b.y.i)


    companion object : opVec1us {
        const val length = Vec1t.LENGTH

        @JvmField
        val size = length * Ushort.BYTES
    }

    override fun size() = size

    override fun equals(other: Any?) = other is Vec1us && this[0] == other[0]
    fun equal(b: Vec1us, epsilon: Int = 0): Boolean = abs(x.v - b.x.v) <= epsilon
    fun notEqual(b: Vec1us, epsilon: Int = 0): Boolean = !equal(b, epsilon)

    override fun hashCode() = x.v.hashCode()


    //@formatter:off
    override inline var _x get() = x; set(value) { x = value }
    override inline var r get() = x; set(value) { x = value }
    override inline var s get() = x; set(value) { x = value }
    //@formatter:on

    override inline operator fun get(index: Int): Ushort {
        if (index == 0) return x
        throw IndexOutOfBoundsException()
    }

    override inline operator fun set(index: Int, value: Ushort) {
        if (index == 0) {
            x = value
        } else throw IndexOutOfBoundsException()
    }

    override inline operator fun component1() = x

    override fun toString(): String = "($x)"
}

