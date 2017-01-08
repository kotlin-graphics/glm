package vec._2

import BYTES
import getShort
import s
import vec.Vec2t
import vec.Vec3t
import vec.Vec4t
import vec._2.operators.vec2s_operators
import vec.bool.Vec2bool
import vec.bool.Vec3bool
import vec.bool.Vec4bool
import java.nio.*

/**
 * Created by GBarbieri on 06.10.2016.
 */

data class Vec2s(override var x: Short, override var y: Short) : Vec2t<Short>() {

    // -- Explicit basic, conversion other and conversion vector constructors --

    constructor() : this(0)

    constructor(v: Vec2t<out Number>) : this(v.x, v.y)
    constructor(v: Vec3t<out Number>) : this(v.x, v.y)
    constructor(v: Vec4t<out Number>) : this(v.x, v.y)

    constructor(v: Vec2bool) : this(v.x.s, v.y.s)
    constructor(v: Vec3bool) : this(v.x.s, v.y.s)
    constructor(v: Vec4bool) : this(v.x.s, v.y.s)

    constructor(bytes: ByteArray, index: Int = 0, oneByteOneShort: Boolean = true, bigEndianess: Boolean = true) : this(
            if (oneByteOneShort) bytes[index].s else bytes.getShort(index, bigEndianess),
            if (oneByteOneShort) bytes[index + 1].s else bytes.getShort(index + Short.BYTES, bigEndianess))

    constructor(chars: CharArray, index: Int = 0) : this(chars[index].s, chars[index + 1].s)
    constructor(shorts: ShortArray, index: Int = 0) : this(shorts[index], shorts[index + 1])
    constructor(ints: IntArray, index: Int = 0) : this(ints[index], ints[index + 1])
    constructor(longs: LongArray, index: Int = 0) : this(longs[index], longs[index + 1])
    constructor(floats: FloatArray, index: Int = 0) : this(floats[index], floats[index + 1])
    constructor(doubles: DoubleArray, index: Int = 0) : this(doubles[index], doubles[index + 1])
    constructor(booleans: BooleanArray, index: Int = 0) : this(booleans[index].s, booleans[index + 1].s)

    constructor(numbers: Array<out Number>, index: Int = 0) : this(numbers[index], numbers[index + 1])
    constructor(chars: Array<Char>, index: Int = 0) : this(chars[index].s, chars[index + 1].s)
    constructor(booleans: Array<Boolean>, index: Int = 0) : this(booleans[index].s, booleans[index + 1].s)

    constructor(list: List<Any>, index: Int = 0) : this() {
        Set(list, index)
    }

    constructor(bytes: ByteBuffer, index: Int = bytes.position(), oneByteOneShort: Boolean = true) : this(
            if (oneByteOneShort) bytes[index].s else bytes.getShort(index),
            if (oneByteOneShort) bytes[index + 1].s else bytes.getShort(index + Short.BYTES))

    constructor(chars: CharBuffer, index: Int = chars.position()) : this(chars[index].s, chars[index + 1].s)
    constructor(shorts: ShortBuffer, index: Int = shorts.position()) : this(shorts[index], shorts[index + 1])
    constructor(ints: IntBuffer, index: Int = ints.position()) : this(ints[index], ints[index + 1])
    constructor(longs: LongBuffer, index: Int = longs.position()) : this(longs[index], longs[index + 1])
    constructor(floats: FloatBuffer, index: Int = floats.position()) : this(floats[index], floats[index + 1])
    constructor(doubles: DoubleBuffer, index: Int = doubles.position()) : this(doubles[index], doubles[index + 1])

    constructor(s: Number) : this(s, s)
    constructor(x: Number, y: Number) : this(x.s, y.s)


    fun set(bytes: ByteArray, index: Int = 0, oneByteOneShort: Boolean = true, bigEndianess: Boolean = true) {
        x = if (oneByteOneShort) bytes[index].s else bytes.getShort(index, bigEndianess)
        y = if (oneByteOneShort) bytes[index + 1].s else bytes.getShort(index + Short.BYTES, bigEndianess)
    }

    fun set(bytes: ByteBuffer, index: Int = bytes.position(), oneByteOneShort: Boolean = true) {
        x = if (oneByteOneShort) bytes[index].s else bytes.getShort(index)
        y = if (oneByteOneShort) bytes[index + 1].s else bytes.getShort(index + Short.BYTES)
    }


    override fun Set(x: Number, y: Number): Vec2s {
        this.x = x.s
        this.y = y.s
        return this
    }


    // -- Component accesses --

    operator fun get(i: Int) = when (i) {
        0 -> x
        1 -> y
        else -> throw ArrayIndexOutOfBoundsException()
    }

    operator fun set(i: Int, s: Number) = when (i) {
        0 -> x = s.s
        1 -> y = s.s
        else -> throw ArrayIndexOutOfBoundsException()
    }


    companion object : vec2s_operators


    // -- Unary arithmetic operators --

    operator fun unaryPlus() = this

    operator fun unaryMinus() = Vec2s(-x, -y)


    // -- Increment and decrement operators --

    operator fun inc(res: Vec2s = Vec2s()) = add(res, this, 1, 1)
    fun inc_() = add(this, this, 1, 1)


    operator fun dec(res: Vec2s = Vec2s()) = sub(res, this, 1, 1)
    fun dec_() = sub(this, this, 1, 1)


    // -- Specific binary arithmetic operators --

    operator fun plus(b: Short) = add(Vec2s(), this, b, b)
    operator fun plus(b: Int) = add(Vec2s(), this, b, b)
    operator fun plus(b: Vec2s) = add(Vec2s(), this, b.x, b.y)

    fun add(bX: Short, bY: Short, res: Vec2s = Vec2s()) = add(res, this, bX, bY)
    fun add(bX: Int, bY: Int, res: Vec2s = Vec2s()) = add(res, this, bX, bY)
    fun add(b: Short, res: Vec2s = Vec2s()) = add(res, this, b, b)
    fun add(b: Int, res: Vec2s = Vec2s()) = add(res, this, b, b)
    fun add(b: Vec2s, res: Vec2s = Vec2s()) = add(res, this, b.x, b.y)

    fun add_(bX: Short, bY: Short) = add(this, this, bX, bY)
    fun add_(bX: Int, bY: Int) = add(this, this, bX, bY)
    infix fun add_(b: Short) = add(this, this, b, b)
    infix fun add_(b: Int) = add(this, this, b, b)
    infix fun add_(b: Vec2s) = add(this, this, b.x, b.y)


    operator fun minus(b: Short) = sub(Vec2s(), this, b, b)
    operator fun minus(b: Int) = sub(Vec2s(), this, b, b)
    operator fun minus(b: Vec2s) = sub(Vec2s(), this, b.x, b.y)

    fun sub(bX: Short, bY: Short, res: Vec2s = Vec2s()) = sub(res, this, bX, bY)
    fun sub(bX: Int, bY: Int, res: Vec2s = Vec2s()) = sub(res, this, bX, bY)
    fun sub(b: Short, res: Vec2s = Vec2s()) = sub(res, this, b, b)
    fun sub(b: Int, res: Vec2s = Vec2s()) = sub(res, this, b, b)
    fun sub(b: Vec2s, res: Vec2s = Vec2s()) = sub(res, this, b.x, b.y)

    fun sub_(bX: Short, bY: Short) = sub(this, this, bX, bY)
    fun sub_(bX: Int, bY: Int) = sub(this, this, bX, bY)
    infix fun sub_(b: Short) = sub(this, this, b, b)
    infix fun sub_(b: Int) = sub(this, this, b, b)
    infix fun sub_(b: Vec2s) = sub(this, this, b.x, b.y)


    operator fun times(b: Short) = mul(Vec2s(), this, b, b)
    operator fun times(b: Int) = mul(Vec2s(), this, b, b)
    operator fun times(b: Vec2s) = mul(Vec2s(), this, b.x, b.y)

    fun mul(bX: Short, bY: Short, res: Vec2s = Vec2s()) = mul(res, this, bX, bY)
    fun mul(bX: Int, bY: Int, res: Vec2s = Vec2s()) = mul(res, this, bX, bY)
    fun mul(b: Short, res: Vec2s = Vec2s()) = mul(res, this, b, b)
    fun mul(b: Int, res: Vec2s = Vec2s()) = mul(res, this, b, b)
    fun mul(b: Vec2s, res: Vec2s = Vec2s()) = mul(res, this, b.x, b.y)

    fun mul_(bX: Short, bY: Short) = mul(this, this, bX, bY)
    fun mul_(bX: Int, bY: Int) = mul(this, this, bX, bY)
    infix fun mul_(b: Short) = mul(this, this, b, b)
    infix fun mul_(b: Int) = mul(this, this, b, b)
    infix fun mul_(b: Vec2s) = mul(this, this, b.x, b.y)


    operator fun div(b: Short) = div(Vec2s(), this, b, b)
    operator fun div(b: Int) = div(Vec2s(), this, b, b)
    operator fun div(b: Vec2s) = div(Vec2s(), this, b.x, b.y)

    fun div(bX: Short, bY: Short, res: Vec2s = Vec2s()) = div(res, this, bX, bY)
    fun div(bX: Int, bY: Int, res: Vec2s = Vec2s()) = div(res, this, bX, bY)
    fun div(b: Short, res: Vec2s) = div(res, this, b, b)
    fun div(b: Int, res: Vec2s) = div(res, this, b, b)
    fun div(b: Vec2s, res: Vec2s) = div(res, this, b.x, b.y)

    fun div_(bX: Short, bY: Short) = div(this, this, bX, bY)
    fun div_(bX: Int, bY: Int) = div(this, this, bX, bY)
    infix fun div_(b: Short) = div(this, this, b, b)
    infix fun div_(b: Int) = div(this, this, b, b)
    infix fun div_(b: Vec2s) = div(this, this, b.x, b.y)


    operator fun rem(b: Short) = rem(Vec2s(), this, b, b)
    operator fun rem(b: Int) = rem(Vec2s(), this, b, b)
    operator fun rem(b: Vec2s) = rem(Vec2s(), this, b.x, b.y)

    fun rem(bX: Short, bY: Short, res: Vec2s = Vec2s()) = rem(res, this, bX, bY)
    fun rem(bX: Int, bY: Int, res: Vec2s = Vec2s()) = rem(res, this, bX, bY)
    fun rem(b: Short, res: Vec2s) = rem(res, this, b, b)
    fun rem(b: Int, res: Vec2s) = rem(res, this, b, b)
    fun rem(b: Vec2s, res: Vec2s) = rem(res, this, b.x, b.y)

    fun rem_(bX: Short, bY: Short) = rem(this, this, bX, bY)
    fun rem_(bX: Int, bY: Int) = rem(this, this, bX, bY)
    infix fun rem_(b: Short) = rem(this, this, b, b)
    infix fun rem_(b: Int) = rem(this, this, b, b)
    infix fun rem_(b: Vec2s) = rem(this, this, b.x, b.y)


    // -- Generic binary arithmetic operators --

    operator fun plus(b: Number) = add(Vec2s(), this, b.s, b.s)
    operator fun plus(b: Vec2t<Number>) = add(Vec2s(), this, b.x.s, b.y.s)

    fun add(bX: Number, bY: Number, res: Vec2s = Vec2s()) = add(res, this, bX.s, bY.s)
    fun add(b: Number, res: Vec2s = Vec2s()) = add(res, this, b.s, b.s)
    fun add(b: Vec2t<Number>, res: Vec2s = Vec2s()) = add(res, this, b.x.s, b.y.s)

    fun add_(bX: Number, bY: Number) = add(this, this, bX.s, bY.s)
    infix fun add_(b: Number) = add(this, this, b.s, b.s)
    infix fun add_(b: Vec2t<Number>) = add(this, this, b.x.s, b.y.s)


    operator fun minus(b: Number) = sub(Vec2s(), this, b.s, b.s)
    operator fun minus(b: Vec2t<Number>) = sub(Vec2s(), this, b.x.s, b.y.s)

    fun sub(bX: Number, bY: Number, res: Vec2s = Vec2s()) = sub(res, this, bX.s, bY.s)
    fun sub(b: Number, res: Vec2s = Vec2s()) = sub(res, this, b.s, b.s)
    fun sub(b: Vec2t<Number>, res: Vec2s = Vec2s()) = sub(res, this, b.x.s, b.y.s)

    fun sub_(bX: Number, bY: Number) = sub(this, this, bX.s, bY.s)
    infix fun sub_(b: Number) = sub(this, this, b.s, b.s)
    infix fun sub_(b: Vec2t<Number>) = sub(this, this, b.x.s, b.y.s)


    operator fun times(b: Number) = mul(Vec2s(), this, b.s, b.s)
    operator fun times(b: Vec2t<Number>) = mul(Vec2s(), this, b.x.s, b.y.s)

    fun mul(bX: Number, bY: Number, res: Vec2s = Vec2s()) = mul(res, this, bX.s, bY.s)
    fun mul(b: Number, res: Vec2s = Vec2s()) = mul(res, this, b.s, b.s)
    fun mul(b: Vec2t<Number>, res: Vec2s = Vec2s()) = mul(res, this, b.x.s, b.y.s)

    fun mul_(bX: Number, bY: Number) = mul(this, this, bX.s, bY.s)
    infix fun mul_(b: Number) = mul(this, this, b.s, b.s)
    infix fun mul_(b: Vec2t<Number>) = mul(this, this, b.x.s, b.y.s)


    operator fun div(b: Number) = div(Vec2s(), this, b.s, b.s)
    operator fun div(b: Vec2t<Number>) = div(Vec2s(), this, b.x.s, b.y.s)

    fun div(bX: Number, bY: Number, res: Vec2s = Vec2s()) = div(res, this, bX.s, bY.s)
    fun div(b: Number, res: Vec2s) = div(res, this, b.s, b.s)
    fun div(b: Vec2t<Number>, res: Vec2s) = div(res, this, b.x.s, b.y.s)

    fun div_(bX: Number, bY: Number) = div(this, this, bX.s, bY.s)
    infix fun div_(b: Number) = div(this, this, b.s, b.s)
    infix fun div_(b: Vec2t<Number>) = div(this, this, b.x.s, b.y.s)


    operator fun rem(b: Number) = rem(Vec2s(), this, b.s, b.s)
    operator fun rem(b: Vec2t<Number>) = rem(Vec2s(), this, b.x.s, b.y.s)

    fun rem(bX: Number, bY: Number, res: Vec2s = Vec2s()) = rem(res, this, bX.s, bY.s)
    fun rem(b: Number, res: Vec2s) = rem(res, this, b.s, b.s)
    fun rem(b: Vec2t<Number>, res: Vec2s) = rem(res, this, b.x.s, b.y.s)

    fun rem_(bX: Number, bY: Number) = rem(this, this, bX.s, bY.s)
    infix fun rem_(b: Number) = rem(this, this, b.s, b.s)
    infix fun rem_(b: Vec2t<Number>) = rem(this, this, b.x.s, b.y.s)


    // -- Specific bitwise operators --

    infix fun and(b: Short) = and(Vec2s(), this, b, b)
    infix fun and(b: Int) = and(Vec2s(), this, b, b)
    infix fun and(b: Vec2s) = and(Vec2s(), this, b.x, b.y)

    infix fun and_(b: Short) = and(this, this, b, b)
    infix fun and_(b: Int) = and(this, this, b, b)
    infix fun and_(b: Vec2s) = and(this, this, b.x, b.y)

    fun and(b: Short, res: Vec2s) = and(res, this, b, b)
    fun and(b: Int, res: Vec2s) = and(res, this, b, b)
    fun and(b: Vec2s, res: Vec2s) = and(res, this, b.x, b.y)

    fun and(bX: Short, bY: Short, res: Vec2s = Vec2s()) = and(res, this, bX, bY)
    fun and(bX: Int, bY: Int, res: Vec2s = Vec2s()) = and(res, this, bX, bY)

    fun and_(bX: Short, bY: Short) = and(this, this, bX, bY)
    fun and_(bX: Int, bY: Int) = and(this, this, bX, bY)


    infix fun or(b: Short) = or(Vec2s(), this, b, b)
    infix fun or(b: Int) = or(Vec2s(), this, b, b)
    infix fun or(b: Vec2s) = or(Vec2s(), this, b.x, b.y)

    infix fun or_(b: Short) = or(this, this, b, b)
    infix fun or_(b: Int) = or(this, this, b, b)
    infix fun or_(b: Vec2s) = or(this, this, b.x, b.y)

    fun or(b: Short, res: Vec2s) = or(res, this, b, b)
    fun or(b: Int, res: Vec2s) = or(res, this, b, b)
    fun or(b: Vec2s, res: Vec2s) = or(res, this, b.x, b.y)

    fun or(bX: Short, bY: Short, res: Vec2s = Vec2s()) = or(res, this, bX, bY)
    fun or(bX: Int, bY: Int, res: Vec2s = Vec2s()) = or(res, this, bX, bY)

    fun or_(bX: Short, bY: Short) = or(this, this, bX, bY)
    fun or_(bX: Int, bY: Int) = or(this, this, bX, bY)


    infix fun xor(b: Short) = xor(Vec2s(), this, b, b)
    infix fun xor(b: Int) = xor(Vec2s(), this, b, b)
    infix fun xor(b: Vec2s) = xor(Vec2s(), this, b.x, b.y)

    infix fun xor_(b: Short) = xor(this, this, b, b)
    infix fun xor_(b: Int) = xor(this, this, b, b)
    infix fun xor_(b: Vec2s) = xor(this, this, b.x, b.y)

    fun xor(b: Short, res: Vec2s) = xor(res, this, b, b)
    fun xor(b: Int, res: Vec2s) = xor(res, this, b, b)
    fun xor(b: Vec2s, res: Vec2s) = xor(res, this, b.x, b.y)

    fun xor(bX: Short, bY: Short, res: Vec2s = Vec2s()) = xor(res, this, bX, bY)
    fun xor(bX: Int, bY: Int, res: Vec2s = Vec2s()) = xor(res, this, bX, bY)

    fun xor_(bX: Short, bY: Short) = xor(this, this, bX, bY)
    fun xor_(bX: Int, bY: Int) = xor(this, this, bX, bY)


    infix fun shl(b: Short) = shl(Vec2s(), this, b, b)
    infix fun shl(b: Int) = shl(Vec2s(), this, b, b)
    infix fun shl(b: Vec2s) = shl(Vec2s(), this, b.x, b.y)

    infix fun shl_(b: Short) = shl(this, this, b, b)
    infix fun shl_(b: Int) = shl(this, this, b, b)
    infix fun shl_(b: Vec2s) = shl(this, this, b.x, b.y)

    fun shl(b: Short, res: Vec2s) = shl(res, this, b, b)
    fun shl(b: Int, res: Vec2s) = shl(res, this, b, b)
    fun shl(b: Vec2s, res: Vec2s) = shl(res, this, b.x, b.y)

    fun shl(bX: Short, bY: Short, res: Vec2s = Vec2s()) = shl(res, this, bX, bY)
    fun shl(bX: Int, bY: Int, res: Vec2s = Vec2s()) = shl(res, this, bX, bY)

    fun shl_(bX: Short, bY: Short) = shl(this, this, bX, bY)
    fun shl_(bX: Int, bY: Int) = shl(this, this, bX, bY)


    infix fun shr(b: Short) = shr(Vec2s(), this, b, b)
    infix fun shr(b: Int) = shr(Vec2s(), this, b, b)
    infix fun shr(b: Vec2s) = shr(Vec2s(), this, b.x, b.y)

    infix fun shr_(b: Short) = shr(this, this, b, b)
    infix fun shr_(b: Int) = shr(this, this, b, b)
    infix fun shr_(b: Vec2s) = shr(this, this, b.x, b.y)

    fun shr(b: Short, res: Vec2s) = shr(res, this, b, b)
    fun shr(b: Int, res: Vec2s) = shr(res, this, b, b)
    fun shr(b: Vec2s, res: Vec2s) = shr(res, this, b.x, b.y)

    fun shr(bX: Short, bY: Short, res: Vec2s = Vec2s()) = shr(res, this, bX, bY)
    fun shr(bX: Int, bY: Int, res: Vec2s = Vec2s()) = shr(res, this, bX, bY)

    fun shr_(bX: Short, bY: Short) = shr(this, this, bX, bY)
    fun shr_(bX: Int, bY: Int) = shr(this, this, bX, bY)


    fun inv(res: Vec2s = Vec2s()) = inv(res, this)
    fun inv_() = inv(this, this)


    // -- Generic bitwise operators --

    infix fun and(b: Number) = and(Vec2s(), this, b.s, b.s)
    infix fun and(b: Vec2t<Number>) = and(Vec2s(), this, b.x.s, b.y.s)

    infix fun and_(b: Number) = and(this, this, b.s, b.s)
    infix fun and_(b: Vec2t<Number>) = and(this, this, b.x.s, b.y.s)

    fun and(b: Number, res: Vec2s) = and(res, this, b.s, b.s)
    fun and(b: Vec2t<Number>, res: Vec2s) = and(res, this, b.x.s, b.y.s)

    fun and(bX: Number, bY: Number, res: Vec2s = Vec2s()) = and(res, this, bX.s, bY.s)

    fun and_(bX: Number, bY: Number) = and(this, this, bX.s, bY.s)


    infix fun or(b: Number) = or(Vec2s(), this, b.s, b.s)
    infix fun or(b: Vec2t<Number>) = or(Vec2s(), this, b.x.s, b.y.s)

    infix fun or_(b: Number) = or(this, this, b.s, b.s)
    infix fun or_(b: Vec2t<Number>) = or(this, this, b.x.s, b.y.s)

    fun or(b: Number, res: Vec2s) = or(res, this, b.s, b.s)
    fun or(b: Vec2t<Number>, res: Vec2s) = or(res, this, b.x.s, b.y.s)

    fun or(bX: Number, bY: Number, res: Vec2s = Vec2s()) = or(res, this, bX.s, bY.s)

    fun or_(bX: Number, bY: Number) = or(this, this, bX.s, bY.s)


    infix fun xor(b: Number) = xor(Vec2s(), this, b.s, b.s)
    infix fun xor(b: Vec2t<Number>) = xor(Vec2s(), this, b.x.s, b.y.s)

    infix fun xor_(b: Number) = xor(this, this, b.s, b.s)
    infix fun xor_(b: Vec2t<Number>) = xor(this, this, b.x.s, b.y.s)

    fun xor(b: Number, res: Vec2s) = xor(res, this, b.s, b.s)
    fun xor(b: Vec2t<Number>, res: Vec2s) = xor(res, this, b.x.s, b.y.s)

    fun xor(bX: Number, bY: Number, res: Vec2s = Vec2s()) = xor(res, this, bX.s, bY.s)

    fun xor_(bX: Number, bY: Number) = xor(this, this, bX.s, bY.s)


    infix fun shl(b: Number) = shl(Vec2s(), this, b.s, b.s)
    infix fun shl(b: Vec2t<Number>) = shl(Vec2s(), this, b.x.s, b.y.s)

    infix fun shl_(b: Number) = shl(this, this, b.s, b.s)
    infix fun shl_(b: Vec2t<Number>) = shl(this, this, b.x.s, b.y.s)

    fun shl(b: Number, res: Vec2s) = shl(res, this, b.s, b.s)
    fun shl(b: Vec2t<Number>, res: Vec2s) = shl(res, this, b.x.s, b.y.s)

    fun shl(bX: Number, bY: Number, res: Vec2s = Vec2s()) = shl(res, this, bX.s, bY.s)

    fun shl_(bX: Number, bY: Number) = shl(this, this, bX.s, bY.s)


    infix fun shr(b: Number) = shr(Vec2s(), this, b.s, b.s)
    infix fun shr(b: Vec2t<Number>) = shr(Vec2s(), this, b.x.s, b.y.s)

    infix fun shr_(b: Number) = shr(this, this, b.s, b.s)
    infix fun shr_(b: Vec2t<Number>) = shr(this, this, b.x.s, b.y.s)

    fun shr(b: Number, res: Vec2s) = shr(res, this, b.s, b.s)
    fun shr(b: Vec2t<Number>, res: Vec2s) = shr(res, this, b.x.s, b.y.s)

    fun shr(bX: Number, bY: Number, res: Vec2s = Vec2s()) = shr(res, this, bX.s, bY.s)

    fun shr_(bX: Number, bY: Number) = shr(this, this, bX.s, bY.s)
}