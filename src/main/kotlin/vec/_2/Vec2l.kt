package vec._2

import BYTES
import L
import getLong
import vec.Vec2t
import vec.Vec3t
import vec.Vec4t
import vec._2.operators.vec2l_operators
import vec.bool.Vec2bool
import vec.bool.Vec3bool
import vec.bool.Vec4bool
import java.nio.*

/**
 * Created bY GBarbieri on 06.10.2016.
 */

data class Vec2l(override var x: Long, override var y: Long) : Vec2t<Long>() {

    // -- Explicit basic, conversion other and conversion vector constructors --

    constructor() : this(0)

    constructor(v: Vec2t<out Number>) : this(v.x, v.y)
    constructor(v: Vec3t<out Number>) : this(v.x, v.y)
    constructor(v: Vec4t<out Number>) : this(v.x, v.y)

    constructor(v: Vec2bool) : this(v.x.L, v.y.L)
    constructor(v: Vec3bool) : this(v.x.L, v.y.L)
    constructor(v: Vec4bool) : this(v.x.L, v.y.L)

    constructor(bytes: ByteArray, index: Int = 0, oneByteOneLong: Boolean = true, bigEndianess: Boolean = true) : this(
            if (oneByteOneLong) bytes[index].L else bytes.getLong(index, bigEndianess),
            if (oneByteOneLong) bytes[index + 1].L else bytes.getLong(index + Long.BYTES, bigEndianess))

    constructor(chars: CharArray, index: Int = 0) : this(chars[index].L, chars[index + 1].L)
    constructor(shorts: ShortArray, index: Int = 0) : this(shorts[index], shorts[index + 1])
    constructor(ints: IntArray, index: Int = 0) : this(ints[index], ints[index + 1])
    constructor(longs: LongArray, index: Int = 0) : this(longs[index], longs[index + 1])
    constructor(floats: FloatArray, index: Int = 0) : this(floats[index], floats[index + 1])
    constructor(doubles: DoubleArray, index: Int = 0) : this(doubles[index], doubles[index + 1])
    constructor(booleans: BooleanArray, index: Int = 0) : this(booleans[index].L, booleans[index + 1].L)

    constructor(numbers: Array<out Number>, index: Int = 0) : this(numbers[index], numbers[index + 1])
    constructor(chars: Array<Char>, index: Int = 0) : this(chars[index].L, chars[index + 1].L)
    constructor(booleans: Array<Boolean>, index: Int = 0) : this(booleans[index].L, booleans[index + 1].L)

    constructor(list: List<Any>, index: Int = 0) : this() {
        Set(list, index)
    }

    constructor(bytes: ByteBuffer, index: Int = bytes.position(), oneByteOneLong: Boolean = true) : this(
            if (oneByteOneLong) bytes[index].L else bytes.getLong(index),
            if (oneByteOneLong) bytes[index + 1].L else bytes.getLong(index + Long.BYTES))

    constructor(chars: CharBuffer, index: Int = chars.position()) : this(chars[index].L, chars[index + 1].L)
    constructor(shorts: ShortBuffer, index: Int = shorts.position()) : this(shorts[index], shorts[index + 1])
    constructor(ints: IntBuffer, index: Int = ints.position()) : this(ints[index], ints[index + 1])
    constructor(longs: LongBuffer, index: Int = longs.position()) : this(longs[index], longs[index + 1])
    constructor(floats: FloatBuffer, index: Int = floats.position()) : this(floats[index], floats[index + 1])
    constructor(doubles: DoubleBuffer, index: Int = doubles.position()) : this(doubles[index], doubles[index + 1])

    constructor(s: Number) : this(s, s)
    constructor(x: Number, y: Number) : this(x.L, y.L)


    fun set(bytes: ByteArray, index: Int = 0, oneByteOneLong: Boolean = true, bigEndianess: Boolean = true) {
        x = if (oneByteOneLong) bytes[index].L else bytes.getLong(index, bigEndianess)
        y = if (oneByteOneLong) bytes[index + 1].L else bytes.getLong(index + Long.BYTES, bigEndianess)
    }

    fun set(bytes: ByteBuffer, index: Int = bytes.position(), oneByteOneLong: Boolean = true) {
        x = if (oneByteOneLong) bytes[index].L else bytes.getLong(index)
        y = if (oneByteOneLong) bytes[index + 1].L else bytes.getLong(index + Long.BYTES)
    }


    override fun Set(x: Number, y: Number): Vec2l {
        this.x = x.L
        this.y = y.L
        return this
    }


    // -- Component accesses --

    operator fun get(i: Int) = when (i) {
        0 -> x
        1 -> y
        else -> throw ArrayIndexOutOfBoundsException()
    }

    operator fun set(i: Int, s: Number) = when (i) {
        0 -> x = s.L
        1 -> y = s.L
        else -> throw ArrayIndexOutOfBoundsException()
    }


    companion object : vec2l_operators


    // -- Unary arithmetic operators --

    operator fun unaryPlus() = this

    operator fun unaryMinus() = Vec2l(-x, -y)

    // -- Increment and decrement operators --

    operator fun inc(res: Vec2l = Vec2l()) = add(res, this, 1, 1)
    fun inc_() = add(this, this, 1, 1)


    operator fun dec(res: Vec2l = Vec2l()) = sub(res, this, 1, 1)
    fun dec_() = sub(this, this, 1, 1)


    // -- Specific binary arithmetic operators --

    operator fun plus(b: Long) = add(Vec2l(), this, b, b)
    operator fun plus(b: Vec2l) = add(Vec2l(), this, b.x, b.y)

    fun add(bX: Long, bY: Long, res: Vec2l = Vec2l()) = add(res, this, bX, bY)
    fun add(b: Long, res: Vec2l = Vec2l()) = add(res, this, b, b)
    fun add(b: Vec2l, res: Vec2l = Vec2l()) = add(res, this, b.x, b.y)

    fun add_(bX: Long, bY: Long) = add(this, this, bX, bY)
    infix fun add_(b: Long) = add(this, this, b, b)
    infix fun add_(b: Vec2l) = add(this, this, b.x, b.y)


    operator fun minus(b: Long) = sub(Vec2l(), this, b, b)
    operator fun minus(b: Vec2l) = sub(Vec2l(), this, b.x, b.y)

    fun sub(bX: Long, bY: Long, res: Vec2l = Vec2l()) = sub(res, this, bX, bY)
    fun sub(b: Long, res: Vec2l = Vec2l()) = sub(res, this, b, b)
    fun sub(b: Vec2l, res: Vec2l = Vec2l()) = sub(res, this, b.x, b.y)

    fun sub_(bX: Long, bY: Long) = sub(this, this, bX, bY)
    infix fun sub_(b: Long) = sub(this, this, b, b)
    infix fun sub_(b: Vec2l) = sub(this, this, b.x, b.y)


    operator fun times(b: Long) = mul(Vec2l(), this, b, b)
    operator fun times(b: Vec2l) = mul(Vec2l(), this, b.x, b.y)

    fun mul(bX: Long, bY: Long, res: Vec2l = Vec2l()) = mul(res, this, bX, bY)
    fun mul(b: Long, res: Vec2l = Vec2l()) = mul(res, this, b, b)
    fun mul(b: Vec2l, res: Vec2l = Vec2l()) = mul(res, this, b.x, b.y)

    fun mul_(bX: Long, bY: Long) = mul(this, this, bX, bY)
    infix fun mul_(b: Long) = mul(this, this, b, b)
    infix fun mul_(b: Vec2l) = mul(this, this, b.x, b.y)


    operator fun div(b: Long) = div(Vec2l(), this, b, b)
    operator fun div(b: Vec2l) = div(Vec2l(), this, b.x, b.y)

    fun div(bX: Long, bY: Long, res: Vec2l = Vec2l()) = div(res, this, bX, bY)
    fun div(b: Long, res: Vec2l) = div(res, this, b, b)
    fun div(b: Vec2l, res: Vec2l) = div(res, this, b.x, b.y)

    fun div_(bX: Long, bY: Long) = div(this, this, bX, bY)
    infix fun div_(b: Long) = div(this, this, b, b)
    infix fun div_(b: Vec2l) = div(this, this, b.x, b.y)


    operator fun rem(b: Long) = rem(Vec2l(), this, b, b)
    operator fun rem(b: Vec2l) = rem(Vec2l(), this, b.x, b.y)

    fun rem(bX: Long, bY: Long, res: Vec2l = Vec2l()) = rem(res, this, bX, bY)
    fun rem(b: Long, res: Vec2l) = rem(res, this, b, b)
    fun rem(b: Vec2l, res: Vec2l) = rem(res, this, b.x, b.y)

    fun rem_(bX: Long, bY: Long) = rem(this, this, bX, bY)
    infix fun rem_(b: Long) = rem(this, this, b, b)
    infix fun rem_(b: Vec2l) = rem(this, this, b.x, b.y)


    // -- Generic binary arithmetic operators --

    operator fun plus(b: Number) = add(Vec2l(), this, b.L, b.L)
    operator fun plus(b: Vec2t<Number>) = add(Vec2l(), this, b.x.L, b.y.L)

    fun add(bX: Number, bY: Number, res: Vec2l = Vec2l()) = add(res, this, bX.L, bY.L)
    fun add(b: Number, res: Vec2l = Vec2l()) = add(res, this, b.L, b.L)
    fun add(b: Vec2t<Number>, res: Vec2l = Vec2l()) = add(res, this, b.x.L, b.y.L)

    fun add_(bX: Number, bY: Number) = add(this, this, bX.L, bY.L)
    infix fun add_(b: Number) = add(this, this, b.L, b.L)
    infix fun add_(b: Vec2t<Number>) = add(this, this, b.x.L, b.y.L)


    operator fun minus(b: Number) = sub(Vec2l(), this, b.L, b.L)
    operator fun minus(b: Vec2t<Number>) = sub(Vec2l(), this, b.x.L, b.y.L)

    fun sub(bX: Number, bY: Number, res: Vec2l = Vec2l()) = sub(res, this, bX.L, bY.L)
    fun sub(b: Number, res: Vec2l = Vec2l()) = sub(res, this, b.L, b.L)
    fun sub(b: Vec2t<Number>, res: Vec2l = Vec2l()) = sub(res, this, b.x.L, b.y.L)

    fun sub_(bX: Number, bY: Number) = sub(this, this, bX.L, bY.L)
    infix fun sub_(b: Number) = sub(this, this, b.L, b.L)
    infix fun sub_(b: Vec2t<Number>) = sub(this, this, b.x.L, b.y.L)


    operator fun times(b: Number) = mul(Vec2l(), this, b.L, b.L)
    operator fun times(b: Vec2t<Number>) = mul(Vec2l(), this, b.x.L, b.y.L)

    fun mul(bX: Number, bY: Number, res: Vec2l = Vec2l()) = mul(res, this, bX.L, bY.L)
    fun mul(b: Number, res: Vec2l = Vec2l()) = mul(res, this, b.L, b.L)
    fun mul(b: Vec2t<Number>, res: Vec2l = Vec2l()) = mul(res, this, b.x.L, b.y.L)

    fun mul_(bX: Number, bY: Number) = mul(this, this, bX.L, bY.L)
    infix fun mul_(b: Number) = mul(this, this, b.L, b.L)
    infix fun mul_(b: Vec2t<Number>) = mul(this, this, b.x.L, b.y.L)


    operator fun div(b: Number) = div(Vec2l(), this, b.L, b.L)
    operator fun div(b: Vec2t<Number>) = div(Vec2l(), this, b.x.L, b.y.L)

    fun div(bX: Number, bY: Number, res: Vec2l = Vec2l()) = div(res, this, bX.L, bY.L)
    fun div(b: Number, res: Vec2l) = div(res, this, b.L, b.L)
    fun div(b: Vec2t<Number>, res: Vec2l) = div(res, this, b.x.L, b.y.L)

    fun div_(bX: Number, bY: Number) = div(this, this, bX.L, bY.L)
    infix fun div_(b: Number) = div(this, this, b.L, b.L)
    infix fun div_(b: Vec2t<Number>) = div(this, this, b.x.L, b.y.L)


    operator fun rem(b: Number) = rem(Vec2l(), this, b.L, b.L)
    operator fun rem(b: Vec2t<Number>) = rem(Vec2l(), this, b.x.L, b.y.L)

    fun rem(bX: Number, bY: Number, res: Vec2l = Vec2l()) = rem(res, this, bX.L, bY.L)
    fun rem(b: Number, res: Vec2l) = rem(res, this, b.L, b.L)
    fun rem(b: Vec2t<Number>, res: Vec2l) = rem(res, this, b.x.L, b.y.L)

    fun rem_(bX: Number, bY: Number) = rem(this, this, bX.L, bY.L)
    infix fun rem_(b: Number) = rem(this, this, b.L, b.L)
    infix fun rem_(b: Vec2t<Number>) = rem(this, this, b.x.L, b.y.L)


    // -- Specific bitwise operators --

    infix fun and(b: Long) = and(Vec2l(), this, b, b)
    infix fun and(b: Vec2l) = and(Vec2l(), this, b.x, b.y)

    infix fun and_(b: Long) = and(this, this, b, b)
    infix fun and_(b: Vec2l) = and(this, this, b.x, b.y)

    fun and(b: Long, res: Vec2l) = and(res, this, b, b)
    fun and(b: Vec2l, res: Vec2l) = and(res, this, b.x, b.y)

    fun and(bX: Long, bY: Long, res: Vec2l = Vec2l()) = and(res, this, bX, bY)

    fun and_(bX: Long, bY: Long) = and(this, this, bX, bY)


    infix fun or(b: Long) = or(Vec2l(), this, b, b)
    infix fun or(b: Vec2l) = or(Vec2l(), this, b.x, b.y)

    infix fun or_(b: Long) = or(this, this, b, b)
    infix fun or_(b: Vec2l) = or(this, this, b.x, b.y)

    fun or(b: Long, res: Vec2l) = or(res, this, b, b)
    fun or(b: Vec2l, res: Vec2l) = or(res, this, b.x, b.y)

    fun or(bX: Long, bY: Long, res: Vec2l = Vec2l()) = or(res, this, bX, bY)

    fun or_(bX: Long, bY: Long) = or(this, this, bX, bY)


    infix fun xor(b: Long) = xor(Vec2l(), this, b, b)
    infix fun xor(b: Vec2l) = xor(Vec2l(), this, b.x, b.y)

    infix fun xor_(b: Long) = xor(this, this, b, b)
    infix fun xor_(b: Vec2l) = xor(this, this, b.x, b.y)

    fun xor(b: Long, res: Vec2l) = xor(res, this, b, b)
    fun xor(b: Vec2l, res: Vec2l) = xor(res, this, b.x, b.y)

    fun xor(bX: Long, bY: Long, res: Vec2l = Vec2l()) = xor(res, this, bX, bY)

    fun xor_(bX: Long, bY: Long) = xor(this, this, bX, bY)


    infix fun shl(b: Long) = shl(Vec2l(), this, b, b)
    infix fun shl(b: Vec2l) = shl(Vec2l(), this, b.x, b.y)

    infix fun shl_(b: Long) = shl(this, this, b, b)
    infix fun shl_(b: Vec2l) = shl(this, this, b.x, b.y)

    fun shl(b: Long, res: Vec2l) = shl(res, this, b, b)
    fun shl(b: Vec2l, res: Vec2l) = shl(res, this, b.x, b.y)

    fun shl(bX: Long, bY: Long, res: Vec2l = Vec2l()) = shl(res, this, bX, bY)

    fun shl_(bX: Long, bY: Long) = shl(this, this, bX, bY)


    infix fun shr(b: Long) = shr(Vec2l(), this, b, b)
    infix fun shr(b: Vec2l) = shr(Vec2l(), this, b.x, b.y)

    infix fun shr_(b: Long) = shr(this, this, b, b)
    infix fun shr_(b: Vec2l) = shr(this, this, b.x, b.y)

    fun shr(b: Long, res: Vec2l) = shr(res, this, b, b)
    fun shr(b: Vec2l, res: Vec2l) = shr(res, this, b.x, b.y)

    fun shr(bX: Long, bY: Long, res: Vec2l = Vec2l()) = shr(res, this, bX, bY)

    fun shr_(bX: Long, bY: Long) = shr(this, this, bX, bY)


    fun inv(res: Vec2l = Vec2l()) = inv(res, this)
    fun inv_() = inv(this, this)


    // -- Generic bitwise operators --

    infix fun and(b: Number) = and(Vec2l(), this, b.L, b.L)
    infix fun and(b: Vec2t<Number>) = and(Vec2l(), this, b.x.L, b.y.L)

    infix fun and_(b: Number) = and(this, this, b.L, b.L)
    infix fun and_(b: Vec2t<Number>) = and(this, this, b.x.L, b.y.L)

    fun and(b: Number, res: Vec2l) = and(res, this, b.L, b.L)
    fun and(b: Vec2t<Number>, res: Vec2l) = and(res, this, b.x.L, b.y.L)

    fun and(bX: Number, bY: Number, res: Vec2l = Vec2l()) = and(res, this, bX.L, bY.L)

    fun and_(bX: Number, bY: Number) = and(this, this, bX.L, bY.L)


    infix fun or(b: Number) = or(Vec2l(), this, b.L, b.L)
    infix fun or(b: Vec2t<Number>) = or(Vec2l(), this, b.x.L, b.y.L)

    infix fun or_(b: Number) = or(this, this, b.L, b.L)
    infix fun or_(b: Vec2t<Number>) = or(this, this, b.x.L, b.y.L)

    fun or(b: Number, res: Vec2l) = or(res, this, b.L, b.L)
    fun or(b: Vec2t<Number>, res: Vec2l) = or(res, this, b.x.L, b.y.L)

    fun or(bX: Number, bY: Number, res: Vec2l = Vec2l()) = or(res, this, bX.L, bY.L)

    fun or_(bX: Number, bY: Number) = or(this, this, bX.L, bY.L)


    infix fun xor(b: Number) = xor(Vec2l(), this, b.L, b.L)
    infix fun xor(b: Vec2t<Number>) = xor(Vec2l(), this, b.x.L, b.y.L)

    infix fun xor_(b: Number) = xor(this, this, b.L, b.L)
    infix fun xor_(b: Vec2t<Number>) = xor(this, this, b.x.L, b.y.L)

    fun xor(b: Number, res: Vec2l) = xor(res, this, b.L, b.L)
    fun xor(b: Vec2t<Number>, res: Vec2l) = xor(res, this, b.x.L, b.y.L)

    fun xor(bX: Number, bY: Number, res: Vec2l = Vec2l()) = xor(res, this, bX.L, bY.L)

    fun xor_(bX: Number, bY: Number) = xor(this, this, bX.L, bY.L)


    infix fun shl(b: Number) = shl(Vec2l(), this, b.L, b.L)
    infix fun shl(b: Vec2t<Number>) = shl(Vec2l(), this, b.x.L, b.y.L)

    infix fun shl_(b: Number) = shl(this, this, b.L, b.L)
    infix fun shl_(b: Vec2t<Number>) = shl(this, this, b.x.L, b.y.L)

    fun shl(b: Number, res: Vec2l) = shl(res, this, b.L, b.L)
    fun shl(b: Vec2t<Number>, res: Vec2l) = shl(res, this, b.x.L, b.y.L)

    fun shl(bX: Number, bY: Number, res: Vec2l = Vec2l()) = shl(res, this, bX.L, bY.L)

    fun shl_(bX: Number, bY: Number) = shl(this, this, bX.L, bY.L)


    infix fun shr(b: Number) = shr(Vec2l(), this, b.L, b.L)
    infix fun shr(b: Vec2t<Number>) = shr(Vec2l(), this, b.x.L, b.y.L)

    infix fun shr_(b: Number) = shr(this, this, b.L, b.L)
    infix fun shr_(b: Vec2t<Number>) = shr(this, this, b.x.L, b.y.L)

    fun shr(b: Number, res: Vec2l) = shr(res, this, b.L, b.L)
    fun shr(b: Vec2t<Number>, res: Vec2l) = shr(res, this, b.x.L, b.y.L)

    fun shr(bX: Number, bY: Number, res: Vec2l = Vec2l()) = shr(res, this, bX.L, bY.L)

    fun shr_(bX: Number, bY: Number) = shr(this, this, bX.L, bY.L)
}