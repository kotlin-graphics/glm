package vec._2

import main.BYTES
import unsigned.Ushort
import main.getShort
import main.getUshort
import main.i
import main.s
import main.us
import vec.Vec2t
import vec.Vec3t
import vec.Vec4t
import vec._2.operators.vec2us_operators
import vec.bool.Vec2bool
import vec.bool.Vec3bool
import vec.bool.Vec4bool
import java.nio.*

/**
 * Created by elect on 08/10/16.
 */

data class Vec2us(override var x: Ushort, override var y: Ushort) : Vec2t<Ushort>() {

    // -- Explicit basic, conversion other main.and conversion vector constructors --

    constructor() : this(0)

    constructor(v: Vec2t<out Number>) : this(v.x, v.y)
    constructor(v: Vec3t<out Number>) : this(v.x, v.y)
    constructor(v: Vec4t<out Number>) : this(v.x, v.y)

    constructor(v: Vec2bool) : this(v.x.us, v.y.us)
    constructor(v: Vec3bool) : this(v.x.us, v.y.us)
    constructor(v: Vec4bool) : this(v.x.us, v.y.us)

    constructor(bytes: ByteArray, index: Int = 0, oneByteOneUshort: Boolean = true, bigEndianess: Boolean = true) : this(
            if (oneByteOneUshort) bytes[index].us else bytes.getUshort(index, bigEndianess),
            if (oneByteOneUshort) bytes[index + 1].us else bytes.getUshort(index + Ushort.BYTES, bigEndianess))

    constructor(chars: CharArray, index: Int = 0) : this(chars[index].us, chars[index + 1].us)
    constructor(shorts: ShortArray, index: Int = 0) : this(shorts[index], shorts[index + 1])
    constructor(ints: IntArray, index: Int = 0) : this(ints[index], ints[index + 1])
    constructor(longs: LongArray, index: Int = 0) : this(longs[index], longs[index + 1])
    constructor(floats: FloatArray, index: Int = 0) : this(floats[index], floats[index + 1])
    constructor(doubles: DoubleArray, index: Int = 0) : this(doubles[index], doubles[index + 1])
    constructor(booleans: BooleanArray, index: Int = 0) : this(booleans[index].us, booleans[index + 1].us)

    constructor(numbers: Array<out Number>, index: Int = 0) : this(numbers[index], numbers[index + 1])
    constructor(chars: Array<Char>, index: Int = 0) : this(chars[index].us, chars[index + 1].us)
    constructor(booleans: Array<Boolean>, index: Int = 0) : this(booleans[index].us, booleans[index + 1].us)

    constructor(list: List<Any>, index: Int = 0) : this() {
        put(list, index)
    }

    constructor(bytes: ByteBuffer, index: Int = bytes.position(), oneByteOneUshort: Boolean = true) : this(
            if (oneByteOneUshort) bytes[index].us else bytes.getShort(index).us,
            if (oneByteOneUshort) bytes[index + 1].us else bytes.getShort(index + Ushort.BYTES).us)

    constructor(chars: CharBuffer, index: Int = chars.position()) : this(chars[index].us, chars[index + 1].us)
    constructor(shorts: ShortBuffer, index: Int = shorts.position()) : this(shorts[index], shorts[index + 1])
    constructor(ints: IntBuffer, index: Int = ints.position()) : this(ints[index], ints[index + 1])
    constructor(longs: LongBuffer, index: Int = longs.position()) : this(longs[index], longs[index + 1])
    constructor(floats: FloatBuffer, index: Int = floats.position()) : this(floats[index], floats[index + 1])
    constructor(doubles: DoubleBuffer, index: Int = doubles.position()) : this(doubles[index], doubles[index + 1])

    constructor(s: Number) : this(s, s)
    constructor(x: Number, y: Number) : this(x.us, y.us)


    fun set(bytes: ByteArray, index: Int = 0, oneByteOneShort: Boolean = true, bigEndianess: Boolean = true) {
        x.v = if (oneByteOneShort) bytes[index].s else bytes.getShort(index, bigEndianess)
        y.v = if (oneByteOneShort) bytes[index + 1].s else bytes.getShort(index + Ushort.BYTES, bigEndianess)
    }

    fun set(bytes: ByteBuffer, index: Int = bytes.position(), oneByteOneShort: Boolean = true) {
        x.v = if (oneByteOneShort) bytes[index].s else bytes.getShort(index)
        y.v = if (oneByteOneShort) bytes[index + 1].s else bytes.getShort(index + Ushort.BYTES)
    }


    override fun put(x: Number, y: Number): Vec2us {
        this.x = x.us
        this.y = y.us
        return this
    }


    // -- Component accesses --

    operator fun get(i: Int) = when (i) {
        0 -> x
        1 -> y
        else -> throw ArrayIndexOutOfBoundsException()
    }

    operator fun set(i: Int, s: Number) = when (i) {
        0 -> x = s.us
        1 -> y = s.us
        else -> throw ArrayIndexOutOfBoundsException()
    }


    companion object : vec2us_operators {
        @JvmStatic val SIZE = 2 * Ushort.BYTES
    }


    // -- Unary arithmetic operators --

    operator fun unaryPlus() = this

    // no unaryMinus operator, only signed

    // -- Increment main.and decrement operators --

    operator fun inc(res: Vec2us = Vec2us()) = add(res, this, 1, 1)
    fun inc_() = add(this, this, 1, 1)


    operator fun dec(res: Vec2us = Vec2us()) = sub(res, this, 1, 1)
    fun dec_() = sub(this, this, 1, 1)


    // -- Specific binary arithmetic operators --

    operator fun plus(b: Ushort) = add(Vec2us(), this, b, b)
    operator fun plus(b: Short) = add(Vec2us(), this, b, b)
    operator fun plus(b: Int) = add(Vec2us(), this, b, b)
    operator fun plus(b: Vec2us) = add(Vec2us(), this, b.x, b.y)

    fun add(bX: Ushort, bY: Ushort, res: Vec2us = Vec2us()) = add(res, this, bX, bY)
    fun add(bX: Short, bY: Short, res: Vec2us = Vec2us()) = add(res, this, bX, bY)
    fun add(bX: Int, bY: Int, res: Vec2us = Vec2us()) = add(res, this, bX, bY)
    fun add(b: Ushort, res: Vec2us = Vec2us()) = add(res, this, b, b)
    fun add(b: Short, res: Vec2us = Vec2us()) = add(res, this, b, b)
    fun add(b: Int, res: Vec2us = Vec2us()) = add(res, this, b, b)
    fun add(b: Vec2us, res: Vec2us = Vec2us()) = add(res, this, b.x, b.y)

    fun add_(bX: Ushort, bY: Ushort) = add(this, this, bX, bY)
    fun add_(bX: Short, bY: Short) = add(this, this, bX, bY)
    fun add_(bX: Int, bY: Int) = add(this, this, bX, bY)
    infix fun add_(b: Ushort) = add(this, this, b, b)
    infix fun add_(b: Short) = add(this, this, b, b)
    infix fun add_(b: Int) = add(this, this, b, b)
    infix fun add_(b: Vec2us) = add(this, this, b.x, b.y)


    operator fun minus(b: Ushort) = sub(Vec2us(), this, b, b)
    operator fun minus(b: Short) = sub(Vec2us(), this, b, b)
    operator fun minus(b: Int) = sub(Vec2us(), this, b, b)
    operator fun minus(b: Vec2us) = sub(Vec2us(), this, b.x, b.y)

    fun sub(bX: Ushort, bY: Ushort, res: Vec2us = Vec2us()) = sub(res, this, bX, bY)
    fun sub(bX: Short, bY: Short, res: Vec2us = Vec2us()) = sub(res, this, bX, bY)
    fun sub(bX: Int, bY: Int, res: Vec2us = Vec2us()) = sub(res, this, bX, bY)
    fun sub(b: Ushort, res: Vec2us = Vec2us()) = sub(res, this, b, b)
    fun sub(b: Short, res: Vec2us = Vec2us()) = sub(res, this, b, b)
    fun sub(b: Int, res: Vec2us = Vec2us()) = sub(res, this, b, b)
    fun sub(b: Vec2us, res: Vec2us = Vec2us()) = sub(res, this, b.x, b.y)

    fun sub_(bX: Ushort, bY: Ushort) = sub(this, this, bX, bY)
    fun sub_(bX: Short, bY: Short) = sub(this, this, bX, bY)
    fun sub_(bX: Int, bY: Int) = sub(this, this, bX, bY)
    infix fun sub_(b: Ushort) = sub(this, this, b, b)
    infix fun sub_(b: Short) = sub(this, this, b, b)
    infix fun sub_(b: Int) = sub(this, this, b, b)
    infix fun sub_(b: Vec2us) = sub(this, this, b.x, b.y)


    operator fun times(b: Ushort) = mul(Vec2us(), this, b, b)
    operator fun times(b: Short) = mul(Vec2us(), this, b, b)
    operator fun times(b: Int) = mul(Vec2us(), this, b, b)
    operator fun times(b: Vec2us) = mul(Vec2us(), this, b.x, b.y)

    fun mul(bX: Ushort, bY: Ushort, res: Vec2us = Vec2us()) = mul(res, this, bX, bY)
    fun mul(bX: Short, bY: Short, res: Vec2us = Vec2us()) = mul(res, this, bX, bY)
    fun mul(bX: Int, bY: Int, res: Vec2us = Vec2us()) = mul(res, this, bX, bY)
    fun mul(b: Ushort, res: Vec2us = Vec2us()) = mul(res, this, b, b)
    fun mul(b: Short, res: Vec2us = Vec2us()) = mul(res, this, b, b)
    fun mul(b: Int, res: Vec2us = Vec2us()) = mul(res, this, b, b)
    fun mul(b: Vec2us, res: Vec2us = Vec2us()) = mul(res, this, b.x, b.y)

    fun mul_(bX: Ushort, bY: Ushort) = mul(this, this, bX, bY)
    fun mul_(bX: Short, bY: Short) = mul(this, this, bX, bY)
    fun mul_(bX: Int, bY: Int) = mul(this, this, bX, bY)
    infix fun mul_(b: Ushort) = mul(this, this, b, b)
    infix fun mul_(b: Short) = mul(this, this, b, b)
    infix fun mul_(b: Int) = mul(this, this, b, b)
    infix fun mul_(b: Vec2us) = mul(this, this, b.x, b.y)


    operator fun div(b: Ushort) = div(Vec2us(), this, b, b)
    operator fun div(b: Short) = div(Vec2us(), this, b, b)
    operator fun div(b: Int) = div(Vec2us(), this, b, b)
    operator fun div(b: Vec2us) = div(Vec2us(), this, b.x, b.y)

    fun div(bX: Ushort, bY: Ushort, res: Vec2us = Vec2us()) = div(res, this, bX, bY)
    fun div(bX: Short, bY: Short, res: Vec2us = Vec2us()) = div(res, this, bX, bY)
    fun div(bX: Int, bY: Int, res: Vec2us = Vec2us()) = div(res, this, bX, bY)
    fun div(b: Ushort, res: Vec2us = Vec2us()) = div(res, this, b, b)
    fun div(b: Short, res: Vec2us = Vec2us()) = div(res, this, b, b)
    fun div(b: Int, res: Vec2us = Vec2us()) = div(res, this, b, b)
    fun div(b: Vec2us, res: Vec2us = Vec2us()) = div(res, this, b.x, b.y)

    fun div_(bX: Ushort, bY: Ushort) = div(this, this, bX, bY)
    fun div_(bX: Short, bY: Short) = div(this, this, bX, bY)
    fun div_(bX: Int, bY: Int) = div(this, this, bX, bY)
    infix fun div_(b: Ushort) = div(this, this, b, b)
    infix fun div_(b: Short) = div(this, this, b, b)
    infix fun div_(b: Int) = div(this, this, b, b)
    infix fun div_(b: Vec2us) = div(this, this, b.x, b.y)


    operator fun rem(b: Ushort) = rem(Vec2us(), this, b, b)
    operator fun rem(b: Short) = rem(Vec2us(), this, b, b)
    operator fun rem(b: Int) = rem(Vec2us(), this, b, b)
    operator fun rem(b: Vec2us) = rem(Vec2us(), this, b.x, b.y)

    fun rem(bX: Ushort, bY: Ushort, res: Vec2us = Vec2us()) = rem(res, this, bX, bY)
    fun rem(bX: Short, bY: Short, res: Vec2us = Vec2us()) = rem(res, this, bX, bY)
    fun rem(bX: Int, bY: Int, res: Vec2us = Vec2us()) = rem(res, this, bX, bY)
    fun rem(b: Ushort, res: Vec2us = Vec2us()) = rem(res, this, b, b)
    fun rem(b: Short, res: Vec2us = Vec2us()) = rem(res, this, b, b)
    fun rem(b: Int, res: Vec2us = Vec2us()) = rem(res, this, b, b)
    fun rem(b: Vec2us, res: Vec2us = Vec2us()) = rem(res, this, b.x, b.y)

    fun rem_(bX: Ushort, bY: Ushort) = rem(this, this, bX, bY)
    fun rem_(bX: Short, bY: Short) = rem(this, this, bX, bY)
    fun rem_(bX: Int, bY: Int) = rem(this, this, bX, bY)
    infix fun rem_(b: Ushort) = rem(this, this, b, b)
    infix fun rem_(b: Short) = rem(this, this, b, b)
    infix fun rem_(b: Int) = rem(this, this, b, b)
    infix fun rem_(b: Vec2us) = rem(this, this, b.x, b.y)


    // -- Generic binary arithmetic operators --

    operator fun plus(b: Number) = add(Vec2us(), this, b.i, b.i)
    operator fun plus(b: Vec2t<Number>) = add(Vec2us(), this, b.x.i, b.y.i)

    fun add(bX: Number, bY: Number, res: Vec2us = Vec2us()) = add(res, this, bX.i, bY.i)
    fun add(b: Number, res: Vec2us = Vec2us()) = add(res, this, b.i, b.i)
    fun add(b: Vec2t<Number>, res: Vec2us = Vec2us()) = add(res, this, b.x.i, b.y.i)

    fun add_(bX: Number, bY: Number) = add(this, this, bX.i, bY.i)
    infix fun add_(b: Number) = add(this, this, b.i, b.i)
    infix fun add_(b: Vec2t<Number>) = add(this, this, b.x.i, b.y.i)


    operator fun minus(b: Number) = sub(Vec2us(), this, b.i, b.i)
    operator fun minus(b: Vec2t<Number>) = sub(Vec2us(), this, b.x.i, b.y.i)

    fun sub(bX: Number, bY: Number, res: Vec2us = Vec2us()) = sub(res, this, bX.i, bY.i)
    fun sub(b: Number, res: Vec2us = Vec2us()) = sub(res, this, b.i, b.i)
    fun sub(b: Vec2t<Number>, res: Vec2us = Vec2us()) = sub(res, this, b.x.i, b.y.i)

    fun sub_(bX: Number, bY: Number) = sub(this, this, bX.i, bY.i)
    infix fun sub_(b: Number) = sub(this, this, b.i, b.i)
    infix fun sub_(b: Vec2t<Number>) = sub(this, this, b.x.i, b.y.i)


    operator fun times(b: Number) = mul(Vec2us(), this, b.i, b.i)
    operator fun times(b: Vec2t<Number>) = mul(Vec2us(), this, b.x.i, b.y.i)

    fun mul(bX: Number, bY: Number, res: Vec2us = Vec2us()) = mul(res, this, bX.i, bY.i)
    fun mul(b: Number, res: Vec2us = Vec2us()) = mul(res, this, b.i, b.i)
    fun mul(b: Vec2t<Number>, res: Vec2us = Vec2us()) = mul(res, this, b.x.i, b.y.i)

    fun mul_(bX: Number, bY: Number) = mul(this, this, bX.i, bY.i)
    infix fun mul_(b: Number) = mul(this, this, b.i, b.i)
    infix fun mul_(b: Vec2t<Number>) = mul(this, this, b.x.i, b.y.i)


    operator fun div(b: Number) = div(Vec2us(), this, b.i, b.i)
    operator fun div(b: Vec2t<Number>) = div(Vec2us(), this, b.x.i, b.y.i)

    fun div(bX: Number, bY: Number, res: Vec2us = Vec2us()) = div(res, this, bX.i, bY.i)
    fun div(b: Number, res: Vec2us = Vec2us()) = div(res, this, b.i, b.i)
    fun div(b: Vec2t<Number>, res: Vec2us = Vec2us()) = div(res, this, b.x.i, b.y.i)

    fun div_(bX: Number, bY: Number) = div(this, this, bX.i, bY.i)
    infix fun div_(b: Number) = div(this, this, b.i, b.i)
    infix fun div_(b: Vec2t<Number>) = div(this, this, b.x.i, b.y.i)


    operator fun rem(b: Number) = rem(Vec2us(), this, b.i, b.i)
    operator fun rem(b: Vec2t<Number>) = rem(Vec2us(), this, b.x.i, b.y.i)

    fun rem(bX: Number, bY: Number, res: Vec2us = Vec2us()) = rem(res, this, bX.i, bY.i)
    fun rem(b: Number, res: Vec2us = Vec2us()) = rem(res, this, b.i, b.i)
    fun rem(b: Vec2t<Number>, res: Vec2us = Vec2us()) = rem(res, this, b.x.i, b.y.i)

    fun rem_(bX: Number, bY: Number) = rem(this, this, bX.i, bY.i)
    infix fun rem_(b: Number) = rem(this, this, b.i, b.i)
    infix fun rem_(b: Vec2t<Number>) = rem(this, this, b.x.i, b.y.i)


    // -- Specific bitwise operators --

    infix fun and(b: Ushort) = and(Vec2us(), this, b, b)
    infix fun and(b: Short) = and(Vec2us(), this, b, b)
    infix fun and(b: Int) = and(Vec2us(), this, b, b)
    fun and(bX: Ushort, bY: Ushort) = and(Vec2us(), this, bX, bY)
    fun and(bX: Short, bY: Short) = and(Vec2us(), this, bX, bY)
    fun and(bX: Int, bY: Int) = and(Vec2us(), this, bX, bY)
    fun and(b: Vec2us) = and(Vec2us(), this, b.x, b.y)

    infix fun and_(b: Ushort) = and(this, this, b, b)
    infix fun and_(b: Short) = and(this, this, b, b)
    infix fun and_(b: Int) = and(this, this, b, b)
    fun and_(bX: Ushort, bY: Ushort) = and(this, this, bX, bY)
    fun and_(bX: Short, bY: Short) = and(this, this, bX, bY)
    fun and_(bX: Int, bY: Int) = and(this, this, bX, bY)
    infix fun and_(b: Vec2us) = and(this, this, b.x, b.y)

    fun and(b: Ushort, res: Vec2us) = and(res, this, b, b)
    fun and(b: Short, res: Vec2us) = and(res, this, b, b)
    fun and(b: Int, res: Vec2us) = and(res, this, b, b)
    fun and(bX: Ushort, bY: Ushort, res: Vec2us) = and(res, this, bX, bY)
    fun and(bX: Short, bY: Short, res: Vec2us) = and(res, this, bX, bY)
    fun and(bX: Int, bY: Int, res: Vec2us) = and(res, this, bX, bY)
    fun and(b: Vec2us, res: Vec2us) = and(res, this, b.x, b.y)


    infix fun or(b: Ushort) = or(Vec2us(), this, b, b)
    infix fun or(b: Short) = or(Vec2us(), this, b, b)
    infix fun or(b: Int) = or(Vec2us(), this, b, b)
    fun or(bX: Ushort, bY: Ushort) = or(Vec2us(), this, bX, bY)
    fun or(bX: Short, bY: Short) = or(Vec2us(), this, bX, bY)
    fun or(bX: Int, bY: Int) = or(Vec2us(), this, bX, bY)
    fun or(b: Vec2us) = or(Vec2us(), this, b.x, b.y)

    infix fun or_(b: Ushort) = or(this, this, b, b)
    infix fun or_(b: Short) = or(this, this, b, b)
    infix fun or_(b: Int) = or(this, this, b, b)
    fun or_(bX: Ushort, bY: Ushort) = or(this, this, bX, bY)
    fun or_(bX: Short, bY: Short) = or(this, this, bX, bY)
    fun or_(bX: Int, bY: Int) = or(this, this, bX, bY)
    infix fun or_(b: Vec2us) = or(this, this, b.x, b.y)

    fun or(b: Ushort, res: Vec2us) = or(res, this, b, b)
    fun or(b: Short, res: Vec2us) = or(res, this, b, b)
    fun or(b: Int, res: Vec2us) = or(res, this, b, b)
    fun or(bX: Ushort, bY: Ushort, res: Vec2us) = or(res, this, bX, bY)
    fun or(bX: Short, bY: Short, res: Vec2us) = or(res, this, bX, bY)
    fun or(bX: Int, bY: Int, res: Vec2us) = or(res, this, bX, bY)
    fun or(b: Vec2us, res: Vec2us) = or(res, this, b.x, b.y)


    infix fun xor(b: Ushort) = xor(Vec2us(), this, b, b)
    infix fun xor(b: Short) = xor(Vec2us(), this, b, b)
    infix fun xor(b: Int) = xor(Vec2us(), this, b, b)
    fun xor(bX: Ushort, bY: Ushort) = xor(Vec2us(), this, bX, bY)
    fun xor(bX: Short, bY: Short) = xor(Vec2us(), this, bX, bY)
    fun xor(bX: Int, bY: Int) = xor(Vec2us(), this, bX, bY)
    fun xor(b: Vec2us) = xor(Vec2us(), this, b.x, b.y)

    infix fun xor_(b: Ushort) = xor(this, this, b, b)
    infix fun xor_(b: Short) = xor(this, this, b, b)
    infix fun xor_(b: Int) = xor(this, this, b, b)
    fun xor_(bX: Ushort, bY: Ushort) = xor(this, this, bX, bY)
    fun xor_(bX: Short, bY: Short) = xor(this, this, bX, bY)
    fun xor_(bX: Int, bY: Int) = xor(this, this, bX, bY)
    infix fun xor_(b: Vec2us) = xor(this, this, b.x, b.y)

    fun xor(b: Ushort, res: Vec2us) = xor(res, this, b, b)
    fun xor(b: Short, res: Vec2us) = xor(res, this, b, b)
    fun xor(b: Int, res: Vec2us) = xor(res, this, b, b)
    fun xor(bX: Ushort, bY: Ushort, res: Vec2us) = xor(res, this, bX, bY)
    fun xor(bX: Short, bY: Short, res: Vec2us) = xor(res, this, bX, bY)
    fun xor(bX: Int, bY: Int, res: Vec2us) = xor(res, this, bX, bY)
    fun xor(b: Vec2us, res: Vec2us) = xor(res, this, b.x, b.y)


    infix fun shl(b: Ushort) = shl(Vec2us(), this, b, b)
    infix fun shl(b: Short) = shl(Vec2us(), this, b, b)
    infix fun shl(b: Int) = shl(Vec2us(), this, b, b)
    fun shl(bX: Ushort, bY: Ushort) = shl(Vec2us(), this, bX, bY)
    fun shl(bX: Short, bY: Short) = shl(Vec2us(), this, bX, bY)
    fun shl(bX: Int, bY: Int) = shl(Vec2us(), this, bX, bY)
    fun shl(b: Vec2us) = shl(Vec2us(), this, b.x, b.y)

    infix fun shl_(b: Ushort) = shl(this, this, b, b)
    infix fun shl_(b: Short) = shl(this, this, b, b)
    infix fun shl_(b: Int) = shl(this, this, b, b)
    fun shl_(bX: Ushort, bY: Ushort) = shl(this, this, bX, bY)
    fun shl_(bX: Short, bY: Short) = shl(this, this, bX, bY)
    fun shl_(bX: Int, bY: Int) = shl(this, this, bX, bY)
    infix fun shl_(b: Vec2us) = shl(this, this, b.x, b.y)

    fun shl(b: Ushort, res: Vec2us) = shl(res, this, b, b)
    fun shl(b: Short, res: Vec2us) = shl(res, this, b, b)
    fun shl(b: Int, res: Vec2us) = shl(res, this, b, b)
    fun shl(bX: Ushort, bY: Ushort, res: Vec2us) = shl(res, this, bX, bY)
    fun shl(bX: Short, bY: Short, res: Vec2us) = shl(res, this, bX, bY)
    fun shl(bX: Int, bY: Int, res: Vec2us) = shl(res, this, bX, bY)
    fun shl(b: Vec2us, res: Vec2us) = shl(res, this, b.x, b.y)


    infix fun shr(b: Ushort) = shr(Vec2us(), this, b, b)
    infix fun shr(b: Short) = shr(Vec2us(), this, b, b)
    infix fun shr(b: Int) = shr(Vec2us(), this, b, b)
    fun shr(bX: Ushort, bY: Ushort) = shr(Vec2us(), this, bX, bY)
    fun shr(bX: Short, bY: Short) = shr(Vec2us(), this, bX, bY)
    fun shr(bX: Int, bY: Int) = shr(Vec2us(), this, bX, bY)
    fun shr(b: Vec2us) = shr(Vec2us(), this, b.x, b.y)

    infix fun shr_(b: Ushort) = shr(this, this, b, b)
    infix fun shr_(b: Short) = shr(this, this, b, b)
    infix fun shr_(b: Int) = shr(this, this, b, b)
    fun shr_(bX: Ushort, bY: Ushort) = shr(this, this, bX, bY)
    fun shr_(bX: Short, bY: Short) = shr(this, this, bX, bY)
    fun shr_(bX: Int, bY: Int) = shr(this, this, bX, bY)
    infix fun shr_(b: Vec2us) = shr(this, this, b.x, b.y)

    fun shr(b: Ushort, res: Vec2us) = shr(res, this, b, b)
    fun shr(b: Short, res: Vec2us) = shr(res, this, b, b)
    fun shr(b: Int, res: Vec2us) = shr(res, this, b, b)
    fun shr(bX: Ushort, bY: Ushort, res: Vec2us) = shr(res, this, bX, bY)
    fun shr(bX: Short, bY: Short, res: Vec2us) = shr(res, this, bX, bY)
    fun shr(bX: Int, bY: Int, res: Vec2us) = shr(res, this, bX, bY)
    fun shr(b: Vec2us, res: Vec2us) = shr(res, this, b.x, b.y)


    fun inv(res: Vec2us = Vec2us()) = inv(res, this)
    fun inv_() = inv(this, this)


    // -- Generic bitwise operators --

    infix fun and(b: Number) = and(Vec2us(), this, b.i, b.i)
    fun and(bX: Number, bY: Number) = and(Vec2us(), this, bX.i, bY.i)
    fun and(b: Vec2t<Number>) = and(Vec2us(), this, b.x.i, b.y.i)

    infix fun and_(b: Number) = and(this, this, b.i, b.i)
    fun and_(bX: Number, bY: Number) = and(this, this, bX.i, bY.i)
    infix fun and_(b: Vec2t<Number>) = and(this, this, b.x.i, b.y.i)

    fun and(b: Number, res: Vec2us) = and(res, this, b.i, b.i)
    fun and(bX: Number, bY: Number, res: Vec2us) = and(res, this, bX.i, bY.i)
    fun and(b: Vec2t<Number>, res: Vec2us) = and(res, this, b.x.i, b.y.i)


    infix fun or(b: Number) = or(Vec2us(), this, b.i, b.i)
    fun or(bX: Number, bY: Number) = or(Vec2us(), this, bX.i, bY.i)
    fun or(b: Vec2t<Number>) = or(Vec2us(), this, b.x.i, b.y.i)

    infix fun or_(b: Number) = or(this, this, b.i, b.i)
    fun or_(bX: Number, bY: Number) = or(this, this, bX.i, bY.i)
    infix fun or_(b: Vec2t<Number>) = or(this, this, b.x.i, b.y.i)

    fun or(b: Number, res: Vec2us) = or(res, this, b.i, b.i)
    fun or(bX: Number, bY: Number, res: Vec2us) = or(res, this, bX.i, bY.i)
    fun or(b: Vec2t<Number>, res: Vec2us) = or(res, this, b.x.i, b.y.i)


    infix fun xor(b: Number) = xor(Vec2us(), this, b.i, b.i)
    fun xor(bX: Number, bY: Number) = xor(Vec2us(), this, bX.i, bY.i)
    fun xor(b: Vec2t<Number>) = xor(Vec2us(), this, b.x.i, b.y.i)

    infix fun xor_(b: Number) = xor(this, this, b.i, b.i)
    fun xor_(bX: Number, bY: Number) = xor(this, this, bX.i, bY.i)
    infix fun xor_(b: Vec2t<Number>) = xor(this, this, b.x.i, b.y.i)

    fun xor(b: Number, res: Vec2us) = xor(res, this, b.i, b.i)
    fun xor(bX: Number, bY: Number, res: Vec2us) = xor(res, this, bX.i, bY.i)
    fun xor(b: Vec2t<Number>, res: Vec2us) = xor(res, this, b.x.i, b.y.i)


    infix fun shl(b: Number) = shl(Vec2us(), this, b.i, b.i)
    fun shl(bX: Number, bY: Number) = shl(Vec2us(), this, bX.i, bY.i)
    fun shl(b: Vec2t<Number>) = shl(Vec2us(), this, b.x.i, b.y.i)

    infix fun shl_(b: Number) = shl(this, this, b.i, b.i)
    fun shl_(bX: Number, bY: Number) = shl(this, this, bX.i, bY.i)
    infix fun shl_(b: Vec2t<Number>) = shl(this, this, b.x.i, b.y.i)

    fun shl(b: Number, res: Vec2us) = shl(res, this, b.i, b.i)
    fun shl(bX: Number, bY: Number, res: Vec2us) = shl(res, this, bX.i, bY.i)
    fun shl(b: Vec2t<Number>, res: Vec2us) = shl(res, this, b.x.i, b.y.i)


    infix fun shr(b: Number) = shr(Vec2us(), this, b.i, b.i)
    fun shr(bX: Number, bY: Number) = shr(Vec2us(), this, bX.i, bY.i)
    fun shr(b: Vec2t<Number>) = shr(Vec2us(), this, b.x.i, b.y.i)

    infix fun shr_(b: Number) = shr(this, this, b.i, b.i)
    fun shr_(bX: Number, bY: Number) = shr(this, this, bX.i, bY.i)
    infix fun shr_(b: Vec2t<Number>) = shr(this, this, b.x.i, b.y.i)

    fun shr(b: Number, res: Vec2us) = shr(res, this, b.i, b.i)
    fun shr(bX: Number, bY: Number, res: Vec2us) = shr(res, this, bX.i, bY.i)
    fun shr(b: Vec2t<Number>, res: Vec2us) = shr(res, this, b.x.i, b.y.i)
}