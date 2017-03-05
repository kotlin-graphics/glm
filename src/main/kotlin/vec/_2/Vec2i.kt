package vec._2

import main.BYTES
import main.getInt
import main.i
import vec.Vec2t
import vec.Vec3t
import vec.Vec4t
import vec._2.operators.vec2i_operators
import vec.bool.Vec2bool
import vec.bool.Vec3bool
import vec.bool.Vec4bool
import java.nio.*

/**
 * Created bY GBarbieri on 06.10.2016.
 */

data class Vec2i(override var x: Int, override var y: Int) : Vec2t<Int>() {

    // -- Explicit basic, conversion other main.and conversion vector constructors --

    constructor() : this(0)

    constructor(v: Vec2t<out Number>) : this(v.x, v.y)
    constructor(v: Vec3t<out Number>) : this(v.x, v.y)
    constructor(v: Vec4t<out Number>) : this(v.x, v.y)

    constructor(v: Vec2bool) : this(v.x.i, v.y.i)
    constructor(v: Vec3bool) : this(v.x.i, v.y.i)
    constructor(v: Vec4bool) : this(v.x.i, v.y.i)

    constructor(bytes: ByteArray, index: Int = 0, oneByteOneInt: Boolean = true, bigEndianess: Boolean = true) : this(
            if (oneByteOneInt) bytes[index].i else bytes.getInt(index, bigEndianess),
            if (oneByteOneInt) bytes[index + 1].i else bytes.getInt(index + Int.BYTES, bigEndianess))

    constructor(chars: CharArray, index: Int = 0) : this(chars[index].i, chars[index + 1].i)
    constructor(shorts: ShortArray, index: Int = 0) : this(shorts[index], shorts[index + 1])
    constructor(ints: IntArray, index: Int = 0) : this(ints[index], ints[index + 1])
    constructor(longs: LongArray, index: Int = 0) : this(longs[index], longs[index + 1])
    constructor(floats: FloatArray, index: Int = 0) : this(floats[index], floats[index + 1])
    constructor(doubles: DoubleArray, index: Int = 0) : this(doubles[index], doubles[index + 1])
    constructor(booleans: BooleanArray, index: Int = 0) : this(booleans[index].i, booleans[index + 1].i)

    constructor(numbers: Array<out Number>, index: Int = 0) : this(numbers[index], numbers[index + 1])
    constructor(chars: Array<Char>, index: Int = 0) : this(chars[index].i, chars[index + 1].i)
    constructor(booleans: Array<Boolean>, index: Int = 0) : this(booleans[index].i, booleans[index + 1].i)

    constructor(list: List<Any>, index: Int = 0) : this() {
        put(list, index)
    }

    constructor(bytes: ByteBuffer, index: Int = bytes.position(), oneByteOneInt: Boolean = true) : this(
            if (oneByteOneInt) bytes[index].i else bytes.getInt(index),
            if (oneByteOneInt) bytes[index + 1].i else bytes.getInt(index + Int.BYTES))

    constructor(chars: CharBuffer, index: Int = chars.position()) : this(chars[index].i, chars[index + 1].i)
    constructor(shorts: ShortBuffer, index: Int = shorts.position()) : this(shorts[index], shorts[index + 1])
    constructor(ints: IntBuffer, index: Int = ints.position()) : this(ints[index], ints[index + 1])
    constructor(longs: LongBuffer, index: Int = longs.position()) : this(longs[index], longs[index + 1])
    constructor(floats: FloatBuffer, index: Int = floats.position()) : this(floats[index], floats[index + 1])
    constructor(doubles: DoubleBuffer, index: Int = doubles.position()) : this(doubles[index], doubles[index + 1])

    constructor(s: Number) : this(s, s)
    constructor(x: Number, y: Number) : this(x.i, y.i)


    fun set(bytes: ByteArray, index: Int = 0, oneByteOneInt: Boolean = true, bigEndianess: Boolean = true) {
        x = if (oneByteOneInt) bytes[index].i else bytes.getInt(index, bigEndianess)
        y = if (oneByteOneInt) bytes[index + 1].i else bytes.getInt(index + Int.BYTES, bigEndianess)
    }

    fun set(bytes: ByteBuffer, index: Int = bytes.position(), oneByteOneInt: Boolean = true) {
        x = if (oneByteOneInt) bytes[index].i else bytes.getInt(index)
        y = if (oneByteOneInt) bytes[index + 1].i else bytes.getInt(index + Int.BYTES)
    }


    override fun put(x: Number, y: Number): Vec2i {
        this.x = x.i
        this.y = y.i
        return this
    }


    // -- Component accesses --

    operator fun get(i: Int) = when (i) {
        0 -> x
        1 -> y
        else -> throw ArrayIndexOutOfBoundsException()
    }

    operator fun set(i: Int, s: Number) = when (i) {
        0 -> x = s.i
        1 -> y = s.i
        else -> throw ArrayIndexOutOfBoundsException()
    }


    // TODO
    fun compMul() = x * y


    companion object : vec2i_operators {
        @JvmField val length = 2
        @JvmField val SIZE = length * Int.BYTES
    }


    // -- Unary arithmetic operators --

    operator fun unaryPlus() = this

    operator fun unaryMinus() = Vec2i(-x, -y)

    // -- Increment main.and decrement operators --

    operator fun inc(res: Vec2i = Vec2i()) = add(res, this, 1, 1)
    fun inc_() = add(this, this, 1, 1)


    operator fun dec(res: Vec2i = Vec2i()) = sub(res, this, 1, 1)
    fun dec_() = sub(this, this, 1, 1)


    // -- Specific binary arithmetic operators --

    operator fun plus(b: Int) = add(Vec2i(), this, b, b)
    operator fun plus(b: Vec2i) = add(Vec2i(), this, b.x, b.y)

    fun add(bX: Int, bY: Int, res: Vec2i = Vec2i()) = add(res, this, bX, bY)
    fun add(b: Int, res: Vec2i = Vec2i()) = add(res, this, b, b)
    fun add(b: Vec2i, res: Vec2i = Vec2i()) = add(res, this, b.x, b.y)

    fun add_(bX: Int, bY: Int) = add(this, this, bX, bY)
    infix fun add_(b: Int) = add(this, this, b, b)
    infix fun add_(b: Vec2i) = add(this, this, b.x, b.y)


    operator fun minus(b: Int) = sub(Vec2i(), this, b, b)
    operator fun minus(b: Vec2i) = sub(Vec2i(), this, b.x, b.y)

    fun sub(bX: Int, bY: Int, res: Vec2i = Vec2i()) = sub(res, this, bX, bY)
    fun sub(b: Int, res: Vec2i = Vec2i()) = sub(res, this, b, b)
    fun sub(b: Vec2i, res: Vec2i = Vec2i()) = sub(res, this, b.x, b.y)

    fun sub_(bX: Int, bY: Int) = sub(this, this, bX, bY)
    infix fun sub_(b: Int) = sub(this, this, b, b)
    infix fun sub_(b: Vec2i) = sub(this, this, b.x, b.y)


    operator fun times(b: Int) = mul(Vec2i(), this, b, b)
    operator fun times(b: Vec2i) = mul(Vec2i(), this, b.x, b.y)

    fun mul(bX: Int, bY: Int, res: Vec2i = Vec2i()) = mul(res, this, bX, bY)
    fun mul(b: Int, res: Vec2i = Vec2i()) = mul(res, this, b, b)
    fun mul(b: Vec2i, res: Vec2i = Vec2i()) = mul(res, this, b.x, b.y)

    fun mul_(bX: Int, bY: Int) = mul(this, this, bX, bY)
    infix fun mul_(b: Int) = mul(this, this, b, b)
    infix fun mul_(b: Vec2i) = mul(this, this, b.x, b.y)


    operator fun div(b: Int) = div(Vec2i(), this, b, b)
    operator fun div(b: Vec2i) = div(Vec2i(), this, b.x, b.y)

    fun div(bX: Int, bY: Int, res: Vec2i = Vec2i()) = div(res, this, bX, bY)
    fun div(b: Int, res: Vec2i) = div(res, this, b, b)
    fun div(b: Vec2i, res: Vec2i) = div(res, this, b.x, b.y)

    fun div_(bX: Int, bY: Int) = div(this, this, bX, bY)
    infix fun div_(b: Int) = div(this, this, b, b)
    infix fun div_(b: Vec2i) = div(this, this, b.x, b.y)


    operator fun rem(b: Int) = rem(Vec2i(), this, b, b)
    operator fun rem(b: Vec2i) = rem(Vec2i(), this, b.x, b.y)

    fun rem(bX: Int, bY: Int, res: Vec2i = Vec2i()) = rem(res, this, bX, bY)
    fun rem(b: Int, res: Vec2i) = rem(res, this, b, b)
    fun rem(b: Vec2i, res: Vec2i) = rem(res, this, b.x, b.y)

    fun rem_(bX: Int, bY: Int) = rem(this, this, bX, bY)
    infix fun rem_(b: Int) = rem(this, this, b, b)
    infix fun rem_(b: Vec2i) = rem(this, this, b.x, b.y)


    // -- Generic binary arithmetic operators --

    operator fun plus(b: Number) = add(Vec2i(), this, b.i, b.i)
    operator fun plus(b: Vec2t<Number>) = add(Vec2i(), this, b.x.i, b.y.i)

    fun add(bX: Number, bY: Number, res: Vec2i = Vec2i()) = add(res, this, bX.i, bY.i)
    fun add(b: Number, res: Vec2i = Vec2i()) = add(res, this, b.i, b.i)
    fun add(b: Vec2t<Number>, res: Vec2i = Vec2i()) = add(res, this, b.x.i, b.y.i)

    fun add_(bX: Number, bY: Number) = add(this, this, bX.i, bY.i)
    infix fun add_(b: Number) = add(this, this, b.i, b.i)
    infix fun add_(b: Vec2t<Number>) = add(this, this, b.x.i, b.y.i)


    operator fun minus(b: Number) = sub(Vec2i(), this, b.i, b.i)
    operator fun minus(b: Vec2t<Number>) = sub(Vec2i(), this, b.x.i, b.y.i)

    fun sub(bX: Number, bY: Number, res: Vec2i = Vec2i()) = sub(res, this, bX.i, bY.i)
    fun sub(b: Number, res: Vec2i = Vec2i()) = sub(res, this, b.i, b.i)
    fun sub(b: Vec2t<Number>, res: Vec2i = Vec2i()) = sub(res, this, b.x.i, b.y.i)

    fun sub_(bX: Number, bY: Number) = sub(this, this, bX.i, bY.i)
    infix fun sub_(b: Number) = sub(this, this, b.i, b.i)
    infix fun sub_(b: Vec2t<Number>) = sub(this, this, b.x.i, b.y.i)


    operator fun times(b: Number) = mul(Vec2i(), this, b.i, b.i)
    operator fun times(b: Vec2t<Number>) = mul(Vec2i(), this, b.x.i, b.y.i)

    fun mul(bX: Number, bY: Number, res: Vec2i = Vec2i()) = mul(res, this, bX.i, bY.i)
    fun mul(b: Number, res: Vec2i = Vec2i()) = mul(res, this, b.i, b.i)
    fun mul(b: Vec2t<Number>, res: Vec2i = Vec2i()) = mul(res, this, b.x.i, b.y.i)

    fun mul_(bX: Number, bY: Number) = mul(this, this, bX.i, bY.i)
    infix fun mul_(b: Number) = mul(this, this, b.i, b.i)
    infix fun mul_(b: Vec2t<Number>) = mul(this, this, b.x.i, b.y.i)


    operator fun div(b: Number) = div(Vec2i(), this, b.i, b.i)
    operator fun div(b: Vec2t<Number>) = div(Vec2i(), this, b.x.i, b.y.i)

    fun div(bX: Number, bY: Number, res: Vec2i = Vec2i()) = div(res, this, bX.i, bY.i)
    fun div(b: Number, res: Vec2i) = div(res, this, b.i, b.i)
    fun div(b: Vec2t<Number>, res: Vec2i) = div(res, this, b.x.i, b.y.i)

    fun div_(bX: Number, bY: Number) = div(this, this, bX.i, bY.i)
    infix fun div_(b: Number) = div(this, this, b.i, b.i)
    infix fun div_(b: Vec2t<Number>) = div(this, this, b.x.i, b.y.i)


    operator fun rem(b: Number) = rem(Vec2i(), this, b.i, b.i)
    operator fun rem(b: Vec2t<Number>) = rem(Vec2i(), this, b.x.i, b.y.i)

    fun rem(bX: Number, bY: Number, res: Vec2i = Vec2i()) = rem(res, this, bX.i, bY.i)
    fun rem(b: Number, res: Vec2i) = rem(res, this, b.i, b.i)
    fun rem(b: Vec2t<Number>, res: Vec2i) = rem(res, this, b.x.i, b.y.i)

    fun rem_(bX: Number, bY: Number) = rem(this, this, bX.i, bY.i)
    infix fun rem_(b: Number) = rem(this, this, b.i, b.i)
    infix fun rem_(b: Vec2t<Number>) = rem(this, this, b.x.i, b.y.i)


    // -- Specific bitwise operators --

    infix fun and(b: Int) = and(Vec2i(), this, b, b)
    infix fun and(b: Vec2i) = and(Vec2i(), this, b.x, b.y)

    infix fun and_(b: Int) = and(this, this, b, b)
    infix fun and_(b: Vec2i) = and(this, this, b.x, b.y)

    fun and(b: Int, res: Vec2i) = and(res, this, b, b)
    fun and(b: Vec2i, res: Vec2i) = and(res, this, b.x, b.y)

    fun and(bX: Int, bY: Int, res: Vec2i = Vec2i()) = and(res, this, bX, bY)

    fun and_(bX: Int, bY: Int) = and(this, this, bX, bY)


    infix fun or(b: Int) = or(Vec2i(), this, b, b)
    infix fun or(b: Vec2i) = or(Vec2i(), this, b.x, b.y)

    infix fun or_(b: Int) = or(this, this, b, b)
    infix fun or_(b: Vec2i) = or(this, this, b.x, b.y)

    fun or(b: Int, res: Vec2i) = or(res, this, b, b)
    fun or(b: Vec2i, res: Vec2i) = or(res, this, b.x, b.y)

    fun or(bX: Int, bY: Int, res: Vec2i = Vec2i()) = or(res, this, bX, bY)

    fun or_(bX: Int, bY: Int) = or(this, this, bX, bY)


    infix fun xor(b: Int) = xor(Vec2i(), this, b, b)
    infix fun xor(b: Vec2i) = xor(Vec2i(), this, b.x, b.y)

    infix fun xor_(b: Int) = xor(this, this, b, b)
    infix fun xor_(b: Vec2i) = xor(this, this, b.x, b.y)

    fun xor(b: Int, res: Vec2i) = xor(res, this, b, b)
    fun xor(b: Vec2i, res: Vec2i) = xor(res, this, b.x, b.y)

    fun xor(bX: Int, bY: Int, res: Vec2i = Vec2i()) = xor(res, this, bX, bY)

    fun xor_(bX: Int, bY: Int) = xor(this, this, bX, bY)


    infix fun shl(b: Int) = shl(Vec2i(), this, b, b)
    infix fun shl(b: Vec2i) = shl(Vec2i(), this, b.x, b.y)

    infix fun shl_(b: Int) = shl(this, this, b, b)
    infix fun shl_(b: Vec2i) = shl(this, this, b.x, b.y)

    fun shl(b: Int, res: Vec2i) = shl(res, this, b, b)
    fun shl(b: Vec2i, res: Vec2i) = shl(res, this, b.x, b.y)

    fun shl(bX: Int, bY: Int, res: Vec2i = Vec2i()) = shl(res, this, bX, bY)

    fun shl_(bX: Int, bY: Int) = shl(this, this, bX, bY)


    infix fun shr(b: Int) = shr(Vec2i(), this, b, b)
    infix fun shr(b: Vec2i) = shr(Vec2i(), this, b.x, b.y)

    infix fun shr_(b: Int) = shr(this, this, b, b)
    infix fun shr_(b: Vec2i) = shr(this, this, b.x, b.y)

    fun shr(b: Int, res: Vec2i) = shr(res, this, b, b)
    fun shr(b: Vec2i, res: Vec2i) = shr(res, this, b.x, b.y)

    fun shr(bX: Int, bY: Int, res: Vec2i = Vec2i()) = shr(res, this, bX, bY)

    fun shr_(bX: Int, bY: Int) = shr(this, this, bX, bY)


    fun inv(res: Vec2i = Vec2i()) = inv(res, this)
    fun inv_() = inv(this, this)


    // -- Generic bitwise operators --

    infix fun and(b: Number) = and(Vec2i(), this, b.i, b.i)
    infix fun and(b: Vec2t<Number>) = and(Vec2i(), this, b.x.i, b.y.i)

    infix fun and_(b: Number) = and(this, this, b.i, b.i)
    infix fun and_(b: Vec2t<Number>) = and(this, this, b.x.i, b.y.i)

    fun and(b: Number, res: Vec2i) = and(res, this, b.i, b.i)
    fun and(b: Vec2t<Number>, res: Vec2i) = and(res, this, b.x.i, b.y.i)

    fun and(bX: Number, bY: Number, res: Vec2i = Vec2i()) = and(res, this, bX.i, bY.i)

    fun and_(bX: Number, bY: Number) = and(this, this, bX.i, bY.i)


    infix fun or(b: Number) = or(Vec2i(), this, b.i, b.i)
    infix fun or(b: Vec2t<Number>) = or(Vec2i(), this, b.x.i, b.y.i)

    infix fun or_(b: Number) = or(this, this, b.i, b.i)
    infix fun or_(b: Vec2t<Number>) = or(this, this, b.x.i, b.y.i)

    fun or(b: Number, res: Vec2i) = or(res, this, b.i, b.i)
    fun or(b: Vec2t<Number>, res: Vec2i) = or(res, this, b.x.i, b.y.i)

    fun or(bX: Number, bY: Number, res: Vec2i = Vec2i()) = or(res, this, bX.i, bY.i)

    fun or_(bX: Number, bY: Number) = or(this, this, bX.i, bY.i)


    infix fun xor(b: Number) = xor(Vec2i(), this, b.i, b.i)
    infix fun xor(b: Vec2t<Number>) = xor(Vec2i(), this, b.x.i, b.y.i)

    infix fun xor_(b: Number) = xor(this, this, b.i, b.i)
    infix fun xor_(b: Vec2t<Number>) = xor(this, this, b.x.i, b.y.i)

    fun xor(b: Number, res: Vec2i) = xor(res, this, b.i, b.i)
    fun xor(b: Vec2t<Number>, res: Vec2i) = xor(res, this, b.x.i, b.y.i)

    fun xor(bX: Number, bY: Number, res: Vec2i = Vec2i()) = xor(res, this, bX.i, bY.i)

    fun xor_(bX: Number, bY: Number) = xor(this, this, bX.i, bY.i)


    infix fun shl(b: Number) = shl(Vec2i(), this, b.i, b.i)
    infix fun shl(b: Vec2t<Number>) = shl(Vec2i(), this, b.x.i, b.y.i)

    infix fun shl_(b: Number) = shl(this, this, b.i, b.i)
    infix fun shl_(b: Vec2t<Number>) = shl(this, this, b.x.i, b.y.i)

    fun shl(b: Number, res: Vec2i) = shl(res, this, b.i, b.i)
    fun shl(b: Vec2t<Number>, res: Vec2i) = shl(res, this, b.x.i, b.y.i)

    fun shl(bX: Number, bY: Number, res: Vec2i = Vec2i()) = shl(res, this, bX.i, bY.i)

    fun shl_(bX: Number, bY: Number) = shl(this, this, bX.i, bY.i)


    infix fun shr(b: Number) = shr(Vec2i(), this, b.i, b.i)
    infix fun shr(b: Vec2t<Number>) = shr(Vec2i(), this, b.x.i, b.y.i)

    infix fun shr_(b: Number) = shr(this, this, b.i, b.i)
    infix fun shr_(b: Vec2t<Number>) = shr(this, this, b.x.i, b.y.i)

    fun shr(b: Number, res: Vec2i) = shr(res, this, b.i, b.i)
    fun shr(b: Vec2t<Number>, res: Vec2i) = shr(res, this, b.x.i, b.y.i)

    fun shr(bX: Number, bY: Number, res: Vec2i = Vec2i()) = shr(res, this, bX.i, bY.i)

    fun shr_(bX: Number, bY: Number) = shr(this, this, bX.i, bY.i)

}