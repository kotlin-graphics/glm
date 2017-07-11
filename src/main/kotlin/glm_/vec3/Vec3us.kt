package glm_.vec3

import glm_.*
import glm_.vec2.Vec2bool
import glm_.vec2.Vec2t
import glm_.vec4.Vec4bool
import glm_.vec4.Vec4t
import glm_.vec3.operators.vec3us_operators
import unsigned.Ushort
import java.nio.*

/**
 * Created by elect on 09/10/16.
 */

class Vec3us(x: Ushort, y: Ushort, z: Ushort) : Vec3t<Ushort>(x, y, z) {

    // -- Explicit basic, conversion other main.and conversion vector constructors --

    constructor() : this(0)

    constructor(v: Vec2t<out Number>) : this(v.x, v.y, 0)
    constructor(v: Vec2t<out Number>, z: Number) : this(v.x, v.y, z)
    constructor(x: Number, v: Vec2t<out Number>) : this(x, v.x, v.y)
    constructor(v: Vec3t<out Number>) : this(v.x, v.y, v.z)
    constructor(v: Vec4t<out Number>) : this(v.x, v.y, v.z)

    constructor(v: Vec2bool) : this(v.x.us, v.y.us, 0)
    constructor(v: Vec3bool) : this(v.x.us, v.y.us, v.z.us)
    constructor(v: Vec4bool) : this(v.x.us, v.y.us, v.z.us)

    constructor(bytes: ByteArray, index: Int = 0, oneByteOneUshort: Boolean = true, bigEndianess: Boolean = true) : this(
            if (oneByteOneUshort) bytes[index].us else bytes.getUshort(index, bigEndianess),
            if (oneByteOneUshort) bytes[index + 1].us else bytes.getUshort(index + Ushort.BYTES, bigEndianess),
            if (oneByteOneUshort) bytes[index + 2].us else bytes.getUshort(index + Ushort.BYTES * 2, bigEndianess))

    constructor(chars: CharArray, index: Int = 0) : this(chars[index].us, chars[index + 1].us, chars[index + 2].us)
    constructor(shorts: ShortArray, index: Int = 0) : this(shorts[index], shorts[index + 1], shorts[index + 2])
    constructor(ints: IntArray, index: Int = 0) : this(ints[index], ints[index + 1], ints[index + 2])
    constructor(longs: LongArray, index: Int = 0) : this(longs[index], longs[index + 1], longs[index + 2])
    constructor(floats: FloatArray, index: Int = 0) : this(floats[index], floats[index + 1], floats[index + 2])
    constructor(doubles: DoubleArray, index: Int = 0) : this(doubles[index], doubles[index + 1], doubles[index + 2])
    constructor(booleans: BooleanArray, index: Int = 0) : this(booleans[index].us, booleans[index + 1].us, booleans[index + 2].us)

    constructor(numbers: Array<out Number>, index: Int = 0) : this(numbers[index], numbers[index + 1], numbers[index + 2])
    constructor(chars: Array<Char>, index: Int = 0) : this(chars[index].us, chars[index + 1].us, chars[index + 2].us)
    constructor(booleans: Array<Boolean>, index: Int = 0) : this(booleans[index].us, booleans[index + 1].us, booleans[index + 2].us)

    constructor(list: List<Any>, index: Int = 0) : this() {
        put(list, index)
    }

    constructor(bytes: ByteBuffer, index: Int = bytes.position(), oneByteOneUshort: Boolean = true) : this(
            if (oneByteOneUshort) bytes[index].us else bytes.getShort(index).us,
            if (oneByteOneUshort) bytes[index + 1].us else bytes.getShort(index + Ushort.BYTES).us,
            if (oneByteOneUshort) bytes[index + 2].us else bytes.getShort(index + Ushort.BYTES * 2).us)

    constructor(chars: CharBuffer, index: Int = chars.position()) : this(chars[index].us, chars[index + 1].us, chars[index + 2].us)
    constructor(shorts: ShortBuffer, index: Int = shorts.position()) : this(shorts[index], shorts[index + 1], shorts[index + 2])
    constructor(ints: IntBuffer, index: Int = ints.position()) : this(ints[index], ints[index + 1], ints[index + 2])
    constructor(longs: LongBuffer, index: Int = longs.position()) : this(longs[index], longs[index + 1], longs[index + 2])
    constructor(floats: FloatBuffer, index: Int = floats.position()) : this(floats[index], floats[index + 1], floats[index + 2])
    constructor(doubles: DoubleBuffer, index: Int = doubles.position()) : this(doubles[index], doubles[index + 1], doubles[index + 2])

    constructor(s: Number) : this(s, s, s)
    constructor(x: Number, y: Number, z: Number) : this(x.us, y.us, z.us)


    fun set(bytes: ByteArray, index: Int = 0, oneByteOneShort: Boolean = true, bigEndianess: Boolean = true) {
        x.v = if (oneByteOneShort) bytes[index].s else bytes.getShort(index, bigEndianess)
        y.v = if (oneByteOneShort) bytes[index + 1].s else bytes.getShort(index + Ushort.BYTES, bigEndianess)
        z.v = if (oneByteOneShort) bytes[index + 2].s else bytes.getShort(index + Ushort.BYTES * 2, bigEndianess)
    }

    fun set(bytes: ByteBuffer, index: Int = bytes.position(), oneByteOneShort: Boolean = true) {
        x.v = if (oneByteOneShort) bytes[index].s else bytes.getShort(index)
        y.v = if (oneByteOneShort) bytes[index + 1].s else bytes.getShort(index + Ushort.BYTES)
        z.v = if (oneByteOneShort) bytes[index + 2].s else bytes.getShort(index + Ushort.BYTES * 2)
    }


    override fun put(x: Number, y: Number, z: Number): Vec3us {
        this.x = x.us
        this.y = y.us
        this.z = z.us
        return this
    }


    // -- Component accesses --

    override operator fun get(i: Int) = when (i) {
        0 -> x
        1 -> y
        2 -> z
        else -> throw ArrayIndexOutOfBoundsException()
    }

    operator fun set(i: Int, s: Number) = when (i) {
        0 -> x = s.us
        1 -> y = s.us
        2 -> z = s.us
        else -> throw ArrayIndexOutOfBoundsException()
    }


    companion object : vec3us_operators {
        @JvmField val length = 3
        @JvmField val size = length * Ushort.BYTES
    }


    // -- Unary arithmetic operators --

    operator fun unaryPlus() = this

    // no unaryMinus operator, only signed

    // -- Increment main.and decrement operators --

    operator fun inc(res: Vec3us = Vec3us()) = plus(res, this, 1, 1, 1)
    fun inc_() = plus(this, this, 1, 1, 1)


    operator fun dec(res: Vec3us = Vec3us()) = minus(res, this, 1, 1, 1)
    fun dec_() = minus(this, this, 1, 1, 1)


    // -- Specific binary arithmetic operators --

    operator fun plus(b: Ushort) = plus(Vec3us(), this, b, b, b)
    operator fun plus(b: Short) = plus(Vec3us(), this, b, b, b)
    operator fun plus(b: Int) = plus(Vec3us(), this, b, b, b)
    operator fun plus(b: Vec3us) = plus(Vec3us(), this, b.x, b.y, b.z)

    fun plus(bX: Ushort, bY: Ushort, bZ: Ushort, res: Vec3us = Vec3us()) = plus(res, this, bX, bY, bZ)
    fun plus(bX: Short, bY: Short, bZ: Short, res: Vec3us = Vec3us()) = plus(res, this, bX, bY, bZ)
    fun plus(bX: Int, bY: Int, bZ: Int, res: Vec3us = Vec3us()) = plus(res, this, bX, bY, bZ)
    fun plus(b: Ushort, res: Vec3us = Vec3us()) = plus(res, this, b, b, b)
    fun plus(b: Short, res: Vec3us = Vec3us()) = plus(res, this, b, b, b)
    fun plus(b: Int, res: Vec3us = Vec3us()) = plus(res, this, b, b, b)
    fun plus(b: Vec3us, res: Vec3us = Vec3us()) = plus(res, this, b.x, b.y, b.z)

    fun plus_(bX: Ushort, bY: Ushort, bZ: Ushort) = plus(this, this, bX, bY, bZ)
    fun plus_(bX: Short, bY: Short, bZ: Short) = plus(this, this, bX, bY, bZ)
    fun plus_(bX: Int, bY: Int, bZ: Int) = plus(this, this, bX, bY, bZ)
    infix fun plus_(b: Ushort) = plus(this, this, b, b, b)
    infix fun plus_(b: Short) = plus(this, this, b, b, b)
    infix fun plus_(b: Int) = plus(this, this, b, b, b)
    infix fun plus_(b: Vec3us) = plus(this, this, b.x, b.y, b.z)


    operator fun minus(b: Ushort) = minus(Vec3us(), this, b, b, b)
    operator fun minus(b: Short) = minus(Vec3us(), this, b, b, b)
    operator fun minus(b: Int) = minus(Vec3us(), this, b, b, b)
    operator fun minus(b: Vec3us) = minus(Vec3us(), this, b.x, b.y, b.z)

    fun minus(bX: Ushort, bY: Ushort, bZ: Ushort, res: Vec3us = Vec3us()) = minus(res, this, bX, bY, bZ)
    fun minus(bX: Short, bY: Short, bZ: Short, res: Vec3us = Vec3us()) = minus(res, this, bX, bY, bZ)
    fun minus(bX: Int, bY: Int, bZ: Int, res: Vec3us = Vec3us()) = minus(res, this, bX, bY, bZ)
    fun minus(b: Ushort, res: Vec3us = Vec3us()) = minus(res, this, b, b, b)
    fun minus(b: Short, res: Vec3us = Vec3us()) = minus(res, this, b, b, b)
    fun minus(b: Int, res: Vec3us = Vec3us()) = minus(res, this, b, b, b)
    fun minus(b: Vec3us, res: Vec3us = Vec3us()) = minus(res, this, b.x, b.y, b.z)

    fun minus_(bX: Ushort, bY: Ushort, bZ: Ushort) = minus(this, this, bX, bY, bZ)
    fun minus_(bX: Short, bY: Short, bZ: Short) = minus(this, this, bX, bY, bZ)
    fun minus_(bX: Int, bY: Int, bZ: Int) = minus(this, this, bX, bY, bZ)
    infix fun minus_(b: Ushort) = minus(this, this, b, b, b)
    infix fun minus_(b: Short) = minus(this, this, b, b, b)
    infix fun minus_(b: Int) = minus(this, this, b, b, b)
    infix fun minus_(b: Vec3us) = minus(this, this, b.x, b.y, b.z)


    operator fun times(b: Ushort) = times(Vec3us(), this, b, b, b)
    operator fun times(b: Short) = times(Vec3us(), this, b, b, b)
    operator fun times(b: Int) = times(Vec3us(), this, b, b, b)
    operator fun times(b: Vec3us) = times(Vec3us(), this, b.x, b.y, b.z)

    fun times(bX: Ushort, bY: Ushort, bZ: Ushort, res: Vec3us = Vec3us()) = times(res, this, bX, bY, bZ)
    fun times(bX: Short, bY: Short, bZ: Short, res: Vec3us = Vec3us()) = times(res, this, bX, bY, bZ)
    fun times(bX: Int, bY: Int, bZ: Int, res: Vec3us = Vec3us()) = times(res, this, bX, bY, bZ)
    fun times(b: Ushort, res: Vec3us = Vec3us()) = times(res, this, b, b, b)
    fun times(b: Short, res: Vec3us = Vec3us()) = times(res, this, b, b, b)
    fun times(b: Int, res: Vec3us = Vec3us()) = times(res, this, b, b, b)
    fun times(b: Vec3us, res: Vec3us = Vec3us()) = times(res, this, b.x, b.y, b.z)

    fun times_(bX: Ushort, bY: Ushort, bZ: Ushort) = times(this, this, bX, bY, bZ)
    fun times_(bX: Short, bY: Short, bZ: Short) = times(this, this, bX, bY, bZ)
    fun times_(bX: Int, bY: Int, bZ: Int) = times(this, this, bX, bY, bZ)
    infix fun times_(b: Ushort) = times(this, this, b, b, b)
    infix fun times_(b: Short) = times(this, this, b, b, b)
    infix fun times_(b: Int) = times(this, this, b, b, b)
    infix fun times_(b: Vec3us) = times(this, this, b.x, b.y, b.z)


    operator fun div(b: Ushort) = div(Vec3us(), this, b, b, b)
    operator fun div(b: Short) = div(Vec3us(), this, b, b, b)
    operator fun div(b: Int) = div(Vec3us(), this, b, b, b)
    operator fun div(b: Vec3us) = div(Vec3us(), this, b.x, b.y, b.z)

    fun div(bX: Ushort, bY: Ushort, bZ: Ushort, res: Vec3us = Vec3us()) = div(res, this, bX, bY, bZ)
    fun div(bX: Short, bY: Short, bZ: Short, res: Vec3us = Vec3us()) = div(res, this, bX, bY, bZ)
    fun div(bX: Int, bY: Int, bZ: Int, res: Vec3us = Vec3us()) = div(res, this, bX, bY, bZ)
    fun div(b: Ushort, res: Vec3us = Vec3us()) = div(res, this, b, b, b)
    fun div(b: Short, res: Vec3us = Vec3us()) = div(res, this, b, b, b)
    fun div(b: Int, res: Vec3us = Vec3us()) = div(res, this, b, b, b)
    fun div(b: Vec3us, res: Vec3us = Vec3us()) = div(res, this, b.x, b.y, b.z)

    fun div_(bX: Ushort, bY: Ushort, bZ: Ushort) = div(this, this, bX, bY, bZ)
    fun div_(bX: Short, bY: Short, bZ: Short) = div(this, this, bX, bY, bZ)
    fun div_(bX: Int, bY: Int, bZ: Int) = div(this, this, bX, bY, bZ)
    infix fun div_(b: Ushort) = div(this, this, b, b, b)
    infix fun div_(b: Short) = div(this, this, b, b, b)
    infix fun div_(b: Int) = div(this, this, b, b, b)
    infix fun div_(b: Vec3us) = div(this, this, b.x, b.y, b.z)


    operator fun rem(b: Ushort) = rem(Vec3us(), this, b, b, b)
    operator fun rem(b: Short) = rem(Vec3us(), this, b, b, b)
    operator fun rem(b: Int) = rem(Vec3us(), this, b, b, b)
    operator fun rem(b: Vec3us) = rem(Vec3us(), this, b.x, b.y, b.z)

    fun rem(bX: Ushort, bY: Ushort, bZ: Ushort, res: Vec3us = Vec3us()) = rem(res, this, bX, bY, bZ)
    fun rem(bX: Short, bY: Short, bZ: Short, res: Vec3us = Vec3us()) = rem(res, this, bX, bY, bZ)
    fun rem(bX: Int, bY: Int, bZ: Int, res: Vec3us = Vec3us()) = rem(res, this, bX, bY, bZ)
    fun rem(b: Ushort, res: Vec3us = Vec3us()) = rem(res, this, b, b, b)
    fun rem(b: Short, res: Vec3us = Vec3us()) = rem(res, this, b, b, b)
    fun rem(b: Int, res: Vec3us = Vec3us()) = rem(res, this, b, b, b)
    fun rem(b: Vec3us, res: Vec3us = Vec3us()) = rem(res, this, b.x, b.y, b.z)

    fun rem_(bX: Ushort, bY: Ushort, bZ: Ushort) = rem(this, this, bX, bY, bZ)
    fun rem_(bX: Short, bY: Short, bZ: Short) = rem(this, this, bX, bY, bZ)
    fun rem_(bX: Int, bY: Int, bZ: Int) = rem(this, this, bX, bY, bZ)
    infix fun rem_(b: Ushort) = rem(this, this, b, b, b)
    infix fun rem_(b: Short) = rem(this, this, b, b, b)
    infix fun rem_(b: Int) = rem(this, this, b, b, b)
    infix fun rem_(b: Vec3us) = rem(this, this, b.x, b.y, b.z)


    // -- Generic binary arithmetic operators --

    operator fun plus(b: Number) = plus(Vec3us(), this, b.i, b.i, b.i)
    operator fun plus(b: Vec3t<out Number>) = plus(Vec3us(), this, b.x.i, b.y.i, b.z.i)

    fun plus(bX: Number, bY: Number, bZ: Number, res: Vec3us = Vec3us()) = plus(res, this, bX.i, bY.i, bZ.i)
    fun plus(b: Number, res: Vec3us = Vec3us()) = plus(res, this, b.i, b.i, b.i)
    fun plus(b: Vec3t<out Number>, res: Vec3us = Vec3us()) = plus(res, this, b.x.i, b.y.i, b.z.i)

    fun plus_(bX: Number, bY: Number, bZ: Number) = plus(this, this, bX.i, bY.i, bZ.i)
    infix fun plus_(b: Number) = plus(this, this, b.i, b.i, b.i)
    infix fun plus_(b: Vec3t<out Number>) = plus(this, this, b.x.i, b.y.i, b.z.i)


    operator fun minus(b: Number) = minus(Vec3us(), this, b.i, b.i, b.i)
    operator fun minus(b: Vec3t<out Number>) = minus(Vec3us(), this, b.x.i, b.y.i, b.z.i)

    fun minus(bX: Number, bY: Number, bZ: Number, res: Vec3us = Vec3us()) = minus(res, this, bX.i, bY.i, bZ.i)
    fun minus(b: Number, res: Vec3us = Vec3us()) = minus(res, this, b.i, b.i, b.i)
    fun minus(b: Vec3t<out Number>, res: Vec3us = Vec3us()) = minus(res, this, b.x.i, b.y.i, b.z.i)

    fun minus_(bX: Number, bY: Number, bZ: Number) = minus(this, this, bX.i, bY.i, bZ.i)
    infix fun minus_(b: Number) = minus(this, this, b.i, b.i, b.i)
    infix fun minus_(b: Vec3t<out Number>) = minus(this, this, b.x.i, b.y.i, b.z.i)


    operator fun times(b: Number) = times(Vec3us(), this, b.i, b.i, b.i)
    operator fun times(b: Vec3t<out Number>) = times(Vec3us(), this, b.x.i, b.y.i, b.z.i)

    fun times(bX: Number, bY: Number, bZ: Number, res: Vec3us = Vec3us()) = times(res, this, bX.i, bY.i, bZ.i)
    fun times(b: Number, res: Vec3us = Vec3us()) = times(res, this, b.i, b.i, b.i)
    fun times(b: Vec3t<out Number>, res: Vec3us = Vec3us()) = times(res, this, b.x.i, b.y.i, b.z.i)

    fun times_(bX: Number, bY: Number, bZ: Number) = times(this, this, bX.i, bY.i, bZ.i)
    infix fun times_(b: Number) = times(this, this, b.i, b.i, b.i)
    infix fun times_(b: Vec3t<out Number>) = times(this, this, b.x.i, b.y.i, b.z.i)


    operator fun div(b: Number) = div(Vec3us(), this, b.i, b.i, b.i)
    operator fun div(b: Vec3t<out Number>) = div(Vec3us(), this, b.x.i, b.y.i, b.z.i)

    fun div(bX: Number, bY: Number, bZ: Number, res: Vec3us = Vec3us()) = div(res, this, bX.i, bY.i, bZ.i)
    fun div(b: Number, res: Vec3us = Vec3us()) = div(res, this, b.i, b.i, b.i)
    fun div(b: Vec3t<out Number>, res: Vec3us = Vec3us()) = div(res, this, b.x.i, b.y.i, b.z.i)

    fun div_(bX: Number, bY: Number, bZ: Number) = div(this, this, bX.i, bY.i, bZ.i)
    infix fun div_(b: Number) = div(this, this, b.i, b.i, b.i)
    infix fun div_(b: Vec3t<out Number>) = div(this, this, b.x.i, b.y.i, b.z.i)


    operator fun rem(b: Number) = rem(Vec3us(), this, b.i, b.i, b.i)
    operator fun rem(b: Vec3t<out Number>) = rem(Vec3us(), this, b.x.i, b.y.i, b.z.i)

    fun rem(bX: Number, bY: Number, bZ: Number, res: Vec3us = Vec3us()) = rem(res, this, bX.i, bY.i, bZ.i)
    fun rem(b: Number, res: Vec3us = Vec3us()) = rem(res, this, b.i, b.i, b.i)
    fun rem(b: Vec3t<out Number>, res: Vec3us = Vec3us()) = rem(res, this, b.x.i, b.y.i, b.z.i)

    fun rem_(bX: Number, bY: Number, bZ: Number) = rem(this, this, bX.i, bY.i, bZ.i)
    infix fun rem_(b: Number) = rem(this, this, b.i, b.i, b.i)
    infix fun rem_(b: Vec3t<out Number>) = rem(this, this, b.x.i, b.y.i, b.z.i)


    // -- Specific bitwise operators --

    infix fun and(b: Ushort) = and(Vec3us(), this, b, b, b)
    infix fun and(b: Short) = and(Vec3us(), this, b, b, b)
    infix fun and(b: Int) = and(Vec3us(), this, b, b, b)
    fun and(bX: Ushort, bY: Ushort, bZ: Ushort) = and(Vec3us(), this, bX, bY, bZ)
    fun and(bX: Short, bY: Short, bZ: Short) = and(Vec3us(), this, bX, bY, bZ)
    fun and(bX: Int, bY: Int, bZ: Int) = and(Vec3us(), this, bX, bY, bZ)
    fun and(b: Vec3us) = and(Vec3us(), this, b.x, b.y, b.z)

    infix fun and_(b: Ushort) = and(this, this, b, b, b)
    infix fun and_(b: Short) = and(this, this, b, b, b)
    infix fun and_(b: Int) = and(this, this, b, b, b)
    fun and_(bX: Ushort, bY: Ushort, bZ: Ushort) = and(this, this, bX, bY, bZ)
    fun and_(bX: Short, bY: Short, bZ: Short) = and(this, this, bX, bY, bZ)
    fun and_(bX: Int, bY: Int, bZ: Int) = and(this, this, bX, bY, bZ)
    infix fun and_(b: Vec3us) = and(this, this, b.x, b.y, b.z)

    fun and(b: Ushort, res: Vec3us) = and(res, this, b, b, b)
    fun and(b: Short, res: Vec3us) = and(res, this, b, b, b)
    fun and(b: Int, res: Vec3us) = and(res, this, b, b, b)
    fun and(bX: Ushort, bY: Ushort, bZ: Ushort, res: Vec3us) = and(res, this, bX, bY, bZ)
    fun and(bX: Short, bY: Short, bZ: Short, res: Vec3us) = and(res, this, bX, bY, bZ)
    fun and(bX: Int, bY: Int, bZ: Int, res: Vec3us) = and(res, this, bX, bY, bZ)
    fun and(b: Vec3us, res: Vec3us) = and(res, this, b.x, b.y, b.z)


    infix fun or(b: Ushort) = or(Vec3us(), this, b, b, b)
    infix fun or(b: Short) = or(Vec3us(), this, b, b, b)
    infix fun or(b: Int) = or(Vec3us(), this, b, b, b)
    fun or(bX: Ushort, bY: Ushort, bZ: Ushort) = or(Vec3us(), this, bX, bY, bZ)
    fun or(bX: Short, bY: Short, bZ: Short) = or(Vec3us(), this, bX, bY, bZ)
    fun or(bX: Int, bY: Int, bZ: Int) = or(Vec3us(), this, bX, bY, bZ)
    fun or(b: Vec3us) = or(Vec3us(), this, b.x, b.y, b.z)

    infix fun or_(b: Ushort) = or(this, this, b, b, b)
    infix fun or_(b: Short) = or(this, this, b, b, b)
    infix fun or_(b: Int) = or(this, this, b, b, b)
    fun or_(bX: Ushort, bY: Ushort, bZ: Ushort) = or(this, this, bX, bY, bZ)
    fun or_(bX: Short, bY: Short, bZ: Short) = or(this, this, bX, bY, bZ)
    fun or_(bX: Int, bY: Int, bZ: Int) = or(this, this, bX, bY, bZ)
    infix fun or_(b: Vec3us) = or(this, this, b.x, b.y, b.z)

    fun or(b: Ushort, res: Vec3us) = or(res, this, b, b, b)
    fun or(b: Short, res: Vec3us) = or(res, this, b, b, b)
    fun or(b: Int, res: Vec3us) = or(res, this, b, b, b)
    fun or(bX: Ushort, bY: Ushort, bZ: Ushort, res: Vec3us) = or(res, this, bX, bY, bZ)
    fun or(bX: Short, bY: Short, bZ: Short, res: Vec3us) = or(res, this, bX, bY, bZ)
    fun or(bX: Int, bY: Int, bZ: Int, res: Vec3us) = or(res, this, bX, bY, bZ)
    fun or(b: Vec3us, res: Vec3us) = or(res, this, b.x, b.y, b.z)


    infix fun xor(b: Ushort) = xor(Vec3us(), this, b, b, b)
    infix fun xor(b: Short) = xor(Vec3us(), this, b, b, b)
    infix fun xor(b: Int) = xor(Vec3us(), this, b, b, b)
    fun xor(bX: Ushort, bY: Ushort, bZ: Ushort) = xor(Vec3us(), this, bX, bY, bZ)
    fun xor(bX: Short, bY: Short, bZ: Short) = xor(Vec3us(), this, bX, bY, bZ)
    fun xor(bX: Int, bY: Int, bZ: Int) = xor(Vec3us(), this, bX, bY, bZ)
    fun xor(b: Vec3us) = xor(Vec3us(), this, b.x, b.y, b.z)

    infix fun xor_(b: Ushort) = xor(this, this, b, b, b)
    infix fun xor_(b: Short) = xor(this, this, b, b, b)
    infix fun xor_(b: Int) = xor(this, this, b, b, b)
    fun xor_(bX: Ushort, bY: Ushort, bZ: Ushort) = xor(this, this, bX, bY, bZ)
    fun xor_(bX: Short, bY: Short, bZ: Short) = xor(this, this, bX, bY, bZ)
    fun xor_(bX: Int, bY: Int, bZ: Int) = xor(this, this, bX, bY, bZ)
    infix fun xor_(b: Vec3us) = xor(this, this, b.x, b.y, b.z)

    fun xor(b: Ushort, res: Vec3us) = xor(res, this, b, b, b)
    fun xor(b: Short, res: Vec3us) = xor(res, this, b, b, b)
    fun xor(b: Int, res: Vec3us) = xor(res, this, b, b, b)
    fun xor(bX: Ushort, bY: Ushort, bZ: Ushort, res: Vec3us) = xor(res, this, bX, bY, bZ)
    fun xor(bX: Short, bY: Short, bZ: Short, res: Vec3us) = xor(res, this, bX, bY, bZ)
    fun xor(bX: Int, bY: Int, bZ: Int, res: Vec3us) = xor(res, this, bX, bY, bZ)
    fun xor(b: Vec3us, res: Vec3us) = xor(res, this, b.x, b.y, b.z)


    infix fun shl(b: Ushort) = shl(Vec3us(), this, b, b, b)
    infix fun shl(b: Short) = shl(Vec3us(), this, b, b, b)
    infix fun shl(b: Int) = shl(Vec3us(), this, b, b, b)
    fun shl(bX: Ushort, bY: Ushort, bZ: Ushort) = shl(Vec3us(), this, bX, bY, bZ)
    fun shl(bX: Short, bY: Short, bZ: Short) = shl(Vec3us(), this, bX, bY, bZ)
    fun shl(bX: Int, bY: Int, bZ: Int) = shl(Vec3us(), this, bX, bY, bZ)
    fun shl(b: Vec3us) = shl(Vec3us(), this, b.x, b.y, b.z)

    infix fun shl_(b: Ushort) = shl(this, this, b, b, b)
    infix fun shl_(b: Short) = shl(this, this, b, b, b)
    infix fun shl_(b: Int) = shl(this, this, b, b, b)
    fun shl_(bX: Ushort, bY: Ushort, bZ: Ushort) = shl(this, this, bX, bY, bZ)
    fun shl_(bX: Short, bY: Short, bZ: Short) = shl(this, this, bX, bY, bZ)
    fun shl_(bX: Int, bY: Int, bZ: Int) = shl(this, this, bX, bY, bZ)
    infix fun shl_(b: Vec3us) = shl(this, this, b.x, b.y, b.z)

    fun shl(b: Ushort, res: Vec3us) = shl(res, this, b, b, b)
    fun shl(b: Short, res: Vec3us) = shl(res, this, b, b, b)
    fun shl(b: Int, res: Vec3us) = shl(res, this, b, b, b)
    fun shl(bX: Ushort, bY: Ushort, bZ: Ushort, res: Vec3us) = shl(res, this, bX, bY, bZ)
    fun shl(bX: Short, bY: Short, bZ: Short, res: Vec3us) = shl(res, this, bX, bY, bZ)
    fun shl(bX: Int, bY: Int, bZ: Int, res: Vec3us) = shl(res, this, bX, bY, bZ)
    fun shl(b: Vec3us, res: Vec3us) = shl(res, this, b.x, b.y, b.z)


    infix fun shr(b: Ushort) = shr(Vec3us(), this, b, b, b)
    infix fun shr(b: Short) = shr(Vec3us(), this, b, b, b)
    infix fun shr(b: Int) = shr(Vec3us(), this, b, b, b)
    fun shr(bX: Ushort, bY: Ushort, bZ: Ushort) = shr(Vec3us(), this, bX, bY, bZ)
    fun shr(bX: Short, bY: Short, bZ: Short) = shr(Vec3us(), this, bX, bY, bZ)
    fun shr(bX: Int, bY: Int, bZ: Int) = shr(Vec3us(), this, bX, bY, bZ)
    fun shr(b: Vec3us) = shr(Vec3us(), this, b.x, b.y, b.z)

    infix fun shr_(b: Ushort) = shr(this, this, b, b, b)
    infix fun shr_(b: Short) = shr(this, this, b, b, b)
    infix fun shr_(b: Int) = shr(this, this, b, b, b)
    fun shr_(bX: Ushort, bY: Ushort, bZ: Ushort) = shr(this, this, bX, bY, bZ)
    fun shr_(bX: Short, bY: Short, bZ: Short) = shr(this, this, bX, bY, bZ)
    fun shr_(bX: Int, bY: Int, bZ: Int) = shr(this, this, bX, bY, bZ)
    infix fun shr_(b: Vec3us) = shr(this, this, b.x, b.y, b.z)

    fun shr(b: Ushort, res: Vec3us) = shr(res, this, b, b, b)
    fun shr(b: Short, res: Vec3us) = shr(res, this, b, b, b)
    fun shr(b: Int, res: Vec3us) = shr(res, this, b, b, b)
    fun shr(bX: Ushort, bY: Ushort, bZ: Ushort, res: Vec3us) = shr(res, this, bX, bY, bZ)
    fun shr(bX: Short, bY: Short, bZ: Short, res: Vec3us) = shr(res, this, bX, bY, bZ)
    fun shr(bX: Int, bY: Int, bZ: Int, res: Vec3us) = shr(res, this, bX, bY, bZ)
    fun shr(b: Vec3us, res: Vec3us) = shr(res, this, b.x, b.y, b.z)


    fun inv(res: Vec3us = Vec3us()) = inv(res, this)
    fun inv_() = inv(this, this)


    // -- Generic bitwise operators --

    infix fun and(b: Number) = and(Vec3us(), this, b.i, b.i, b.i)
    fun and(bX: Number, bY: Number, bZ: Number) = and(Vec3us(), this, bX.i, bY.i, bZ.i)
    fun and(b: Vec3t<out Number>) = and(Vec3us(), this, b.x.i, b.y.i, b.z.i)

    infix fun and_(b: Number) = and(this, this, b.i, b.i, b.i)
    fun and_(bX: Number, bY: Number, bZ: Number) = and(this, this, bX.i, bY.i, bZ.i)
    infix fun and_(b: Vec3t<out Number>) = and(this, this, b.x.i, b.y.i, b.z.i)

    fun and(b: Number, res: Vec3us) = and(res, this, b.i, b.i, b.i)
    fun and(bX: Number, bY: Number, bZ: Number, res: Vec3us) = and(res, this, bX.i, bY.i, bZ.i)
    fun and(b: Vec3t<out Number>, res: Vec3us) = and(res, this, b.x.i, b.y.i, b.z.i)


    infix fun or(b: Number) = or(Vec3us(), this, b.i, b.i, b.i)
    fun or(bX: Number, bY: Number, bZ: Number) = or(Vec3us(), this, bX.i, bY.i, bZ.i)
    fun or(b: Vec3t<out Number>) = or(Vec3us(), this, b.x.i, b.y.i, b.z.i)

    infix fun or_(b: Number) = or(this, this, b.i, b.i, b.i)
    fun or_(bX: Number, bY: Number, bZ: Number) = or(this, this, bX.i, bY.i, bZ.i)
    infix fun or_(b: Vec3t<out Number>) = or(this, this, b.x.i, b.y.i, b.z.i)

    fun or(b: Number, res: Vec3us) = or(res, this, b.i, b.i, b.i)
    fun or(bX: Number, bY: Number, bZ: Number, res: Vec3us) = or(res, this, bX.i, bY.i, bZ.i)
    fun or(b: Vec3t<out Number>, res: Vec3us) = or(res, this, b.x.i, b.y.i, b.z.i)


    infix fun xor(b: Number) = xor(Vec3us(), this, b.i, b.i, b.i)
    fun xor(bX: Number, bY: Number, bZ: Number) = xor(Vec3us(), this, bX.i, bY.i, bZ.i)
    fun xor(b: Vec3t<out Number>) = xor(Vec3us(), this, b.x.i, b.y.i, b.z.i)

    infix fun xor_(b: Number) = xor(this, this, b.i, b.i, b.i)
    fun xor_(bX: Number, bY: Number, bZ: Number) = xor(this, this, bX.i, bY.i, bZ.i)
    infix fun xor_(b: Vec3t<out Number>) = xor(this, this, b.x.i, b.y.i, b.z.i)

    fun xor(b: Number, res: Vec3us) = xor(res, this, b.i, b.i, b.i)
    fun xor(bX: Number, bY: Number, bZ: Number, res: Vec3us) = xor(res, this, bX.i, bY.i, bZ.i)
    fun xor(b: Vec3t<out Number>, res: Vec3us) = xor(res, this, b.x.i, b.y.i, b.z.i)


    infix fun shl(b: Number) = shl(Vec3us(), this, b.i, b.i, b.i)
    fun shl(bX: Number, bY: Number, bZ: Number) = shl(Vec3us(), this, bX.i, bY.i, bZ.i)
    fun shl(b: Vec3t<out Number>) = shl(Vec3us(), this, b.x.i, b.y.i, b.z.i)

    infix fun shl_(b: Number) = shl(this, this, b.i, b.i, b.i)
    fun shl_(bX: Number, bY: Number, bZ: Number) = shl(this, this, bX.i, bY.i, bZ.i)
    infix fun shl_(b: Vec3t<out Number>) = shl(this, this, b.x.i, b.y.i, b.z.i)

    fun shl(b: Number, res: Vec3us) = shl(res, this, b.i, b.i, b.i)
    fun shl(bX: Number, bY: Number, bZ: Number, res: Vec3us) = shl(res, this, bX.i, bY.i, bZ.i)
    fun shl(b: Vec3t<out Number>, res: Vec3us) = shl(res, this, b.x.i, b.y.i, b.z.i)


    infix fun shr(b: Number) = shr(Vec3us(), this, b.i, b.i, b.i)
    fun shr(bX: Number, bY: Number, bZ: Number) = shr(Vec3us(), this, bX.i, bY.i, bZ.i)
    fun shr(b: Vec3t<out Number>) = shr(Vec3us(), this, b.x.i, b.y.i, b.z.i)

    infix fun shr_(b: Number) = shr(this, this, b.i, b.i, b.i)
    fun shr_(bX: Number, bY: Number, bZ: Number) = shr(this, this, bX.i, bY.i, bZ.i)
    infix fun shr_(b: Vec3t<out Number>) = shr(this, this, b.x.i, b.y.i, b.z.i)

    fun shr(b: Number, res: Vec3us) = shr(res, this, b.i, b.i, b.i)
    fun shr(bX: Number, bY: Number, bZ: Number, res: Vec3us) = shr(res, this, bX.i, bY.i, bZ.i)
    fun shr(b: Vec3t<out Number>, res: Vec3us) = shr(res, this, b.x.i, b.y.i, b.z.i)


    override fun equals(other: Any?) =
            if (other is Vec3us)
                this[0] == other[0] && this[1] == other[1] && this[2] == other[2]
            else false
}