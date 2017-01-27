package vec._2

import BYTES
import f
import getFloat
import vec.Vec2t
import vec.Vec3t
import vec.Vec4t
import vec._2.operators.vec2_operators
import vec.bool.Vec2bool
import vec.bool.Vec3bool
import vec.bool.Vec4bool
import java.nio.*

/**
 * Created bY GBarbieri on 05.10.2016.
 */

data class Vec2(override var x: Float, override var y: Float) : Vec2t<Float>() {

    // -- Explicit basic, conversion other and conversion vector constructors --

    constructor() : this(0)

    constructor(v: Vec2t<out Number>) : this(v.x, v.y)
    constructor(v: Vec3t<out Number>) : this(v.x, v.y)
    constructor(v: Vec4t<out Number>) : this(v.x, v.y)

    constructor(v: Vec2bool) : this(v.x.f, v.y.f)
    constructor(v: Vec3bool) : this(v.x.f, v.y.f)
    constructor(v: Vec4bool) : this(v.x.f, v.y.f)

    constructor(bytes: ByteArray, index: Int = 0, oneByteOneFloat: Boolean = true, bigEndianess: Boolean = true) : this(
            if (oneByteOneFloat) bytes[index].f else bytes.getFloat(index, bigEndianess),
            if (oneByteOneFloat) bytes[index + 1].f else bytes.getFloat(index + Float.BYTES, bigEndianess))

    constructor(chars: CharArray, index: Int = 0) : this(chars[index].f, chars[index + 1].f)
    constructor(shorts: ShortArray, index: Int = 0) : this(shorts[index], shorts[index + 1])
    constructor(ints: IntArray, index: Int = 0) : this(ints[index], ints[index + 1])
    constructor(longs: LongArray, index: Int = 0) : this(longs[index], longs[index + 1])
    constructor(floats: FloatArray, index: Int = 0) : this(floats[index], floats[index + 1])
    constructor(doubles: DoubleArray, index: Int = 0) : this(doubles[index], doubles[index + 1])
    constructor(booleans: BooleanArray, index: Int = 0) : this(booleans[index].f, booleans[index + 1].f)

    constructor(numbers: Array<out Number>, index: Int = 0) : this(numbers[index], numbers[index + 1])
    constructor(chars: Array<Char>, index: Int = 0) : this(chars[index].f, chars[index + 1].f)
    constructor(booleans: Array<Boolean>, index: Int = 0) : this(booleans[index].f, booleans[index + 1].f)

    constructor(list: List<Any>, index: Int = 0) : this() {
        Set(list, index)
    }

    constructor(bytes: ByteBuffer, index: Int = bytes.position(), oneByteOneFloat: Boolean = true) : this(
            if (oneByteOneFloat) bytes[index].f else bytes.getFloat(index),
            if (oneByteOneFloat) bytes[index + 1].f else bytes.getFloat(index + Float.BYTES))

    constructor(chars: CharBuffer, index: Int = chars.position()) : this(chars[index].f, chars[index + 1].f)
    constructor(shorts: ShortBuffer, index: Int = shorts.position()) : this(shorts[index], shorts[index + 1])
    constructor(ints: IntBuffer, index: Int = ints.position()) : this(ints[index], ints[index + 1])
    constructor(longs: LongBuffer, index: Int = longs.position()) : this(longs[index], longs[index + 1])
    constructor(floats: FloatBuffer, index: Int = floats.position()) : this(floats[index], floats[index + 1])
    constructor(doubles: DoubleBuffer, index: Int = doubles.position()) : this(doubles[index], doubles[index + 1])

    constructor(s: Number) : this(s, s)
    constructor(x: Number, y: Number) : this(x.f, y.f)


    fun set(bytes: ByteArray, index: Int = 0, oneByteOneFloat: Boolean = true, bigEndianess: Boolean = true) {
        x = if (oneByteOneFloat) bytes[index].f else bytes.getFloat(index, bigEndianess)
        y = if (oneByteOneFloat) bytes[index + 1].f else bytes.getFloat(index + Float.BYTES, bigEndianess)
    }

    fun set(bytes: ByteBuffer, index: Int = bytes.position(), oneByteOneFloat: Boolean = true) {
        x = if (oneByteOneFloat) bytes[index].f else bytes.getFloat(index)
        y = if (oneByteOneFloat) bytes[index + 1].f else bytes.getFloat(index + Float.BYTES)
    }


    override fun Set(x: Number, y: Number): Vec2 {
        this.x = x.f
        this.y = y.f
        return this
    }

    // -- Component accesses --

    operator fun get(i: Int) = when (i) {
        0 -> x
        1 -> y
        else -> throw ArrayIndexOutOfBoundsException()
    }

    operator fun set(i: Int, s: Number) = when (i) {
        0 -> x = s.f
        1 -> y = s.f
        else -> throw ArrayIndexOutOfBoundsException()
    }


    companion object : vec2_operators {
        @JvmStatic val SIZE = 2 * Float.BYTES
    }


    // -- Unary arithmetic operators --

    operator fun unaryPlus() = this

    operator fun unaryMinus() = Vec2(-x, -y)

    // -- Increment and decrement operators --

    operator fun inc(res: Vec2 = Vec2()) = add(res, this, 1f, 1f)
    fun inc_() = add(this, this, 1f, 1f)


    operator fun dec(res: Vec2 = Vec2()) = sub(res, this, 1f, 1f)
    fun dec_() = sub(this, this, 1f, 1f)

    // -- Specific binary arithmetic operators --

    operator fun plus(b: Float) = add(Vec2(), this, b, b)
    operator fun plus(b: Vec2) = add(Vec2(), this, b.x, b.y)

    fun add(bX: Float, bY: Float, res: Vec2 = Vec2()) = add(res, this, bX, bY)
    fun add(b: Float, res: Vec2 = Vec2()) = add(res, this, b, b)
    fun add(b: Vec2, res: Vec2 = Vec2()) = add(res, this, b.x, b.y)

    fun add_(bX: Float, bY: Float) = add(this, this, bX, bY)
    infix fun add_(b: Float) = add(this, this, b, b)
    infix fun add_(b: Vec2) = add(this, this, b.x, b.y)


    operator fun minus(b: Float) = sub(Vec2(), this, b, b)
    operator fun minus(b: Vec2) = sub(Vec2(), this, b.x, b.y)

    fun sub(bX: Float, bY: Float, res: Vec2 = Vec2()) = sub(res, this, bX, bY)
    fun sub(b: Float, res: Vec2 = Vec2()) = sub(res, this, b, b)
    fun sub(b: Vec2, res: Vec2 = Vec2()) = sub(res, this, b.x, b.y)

    fun sub_(bX: Float, bY: Float) = sub(this, this, bX, bY)
    infix fun sub_(b: Float) = sub(this, this, b, b)
    infix fun sub_(b: Vec2) = sub(this, this, b.x, b.y)


    operator fun times(b: Float) = mul(Vec2(), this, b, b)
    operator fun times(b: Vec2) = mul(Vec2(), this, b.x, b.y)

    fun mul(bX: Float, bY: Float, res: Vec2 = Vec2()) = mul(res, this, bX, bY)
    fun mul(b: Float, res: Vec2 = Vec2()) = mul(res, this, b, b)
    fun mul(b: Vec2, res: Vec2 = Vec2()) = mul(res, this, b.x, b.y)

    fun mul_(bX: Float, bY: Float) = mul(this, this, bX, bY)
    infix fun mul_(b: Float) = mul(this, this, b, b)
    infix fun mul_(b: Vec2) = mul(this, this, b.x, b.y)


    operator fun div(b: Float) = div(Vec2(), this, b, b)
    operator fun div(b: Vec2) = div(Vec2(), this, b.x, b.y)

    fun div(bX: Float, bY: Float, res: Vec2 = Vec2()) = div(res, this, bX, bY)
    fun div(b: Float, res: Vec2 = Vec2()) = div(res, this, b, b)
    fun div(b: Vec2, res: Vec2 = Vec2()) = div(res, this, b.x, b.y)

    fun div_(bX: Float, bY: Float) = div(this, this, bX, bY)
    infix fun div_(b: Float) = div(this, this, b, b)
    infix fun div_(b: Vec2) = div(this, this, b.x, b.y)


    operator fun rem(b: Float) = rem(Vec2(), this, b, b)
    operator fun rem(b: Vec2) = rem(Vec2(), this, b.x, b.y)

    fun rem(bX: Float, bY: Float, res: Vec2 = Vec2()) = rem(res, this, bX, bY)
    fun rem(b: Float, res: Vec2 = Vec2()) = rem(res, this, b, b)
    fun rem(b: Vec2, res: Vec2 = Vec2()) = rem(res, this, b.x, b.y)

    fun rem_(bX: Float, bY: Float) = rem(this, this, bX, bY)
    infix fun rem_(b: Float) = rem(this, this, b, b)
    infix fun rem_(b: Vec2) = rem(this, this, b.x, b.y)


    // -- Generic binary arithmetic operators --

    operator fun plus(b: Number) = add(Vec2(), this, b.f, b.f)
    operator fun plus(b: Vec2t<Number>) = add(Vec2(), this, b.x.f, b.y.f)

    fun add(bX: Number, bY: Number, res: Vec2 = Vec2()) = add(res, this, bX.f, bY.f)
    fun add(b: Number, res: Vec2 = Vec2()) = add(res, this, b.f, b.f)
    fun add(b: Vec2t<Number>, res: Vec2 = Vec2()) = add(res, this, b.x.f, b.y.f)

    fun add_(bX: Number, bY: Number) = add(this, this, bX.f, bY.f)
    infix fun add_(b: Number) = add(this, this, b.f, b.f)
    infix fun add_(b: Vec2t<Number>) = add(this, this, b.x.f, b.y.f)


    operator fun minus(b: Number) = sub(Vec2(), this, b.f, b.f)
    operator fun minus(b: Vec2t<Number>) = sub(Vec2(), this, b.x.f, b.y.f)

    fun sub(bX: Number, bY: Number, res: Vec2 = Vec2()) = sub(res, this, bX.f, bY.f)
    fun sub(b: Number, res: Vec2 = Vec2()) = sub(res, this, b.f, b.f)
    fun sub(b: Vec2t<Number>, res: Vec2 = Vec2()) = sub(res, this, b.x.f, b.y.f)

    fun sub_(bX: Number, bY: Number) = sub(this, this, bX.f, bY.f)
    infix fun sub_(b: Number) = sub(this, this, b.f, b.f)
    infix fun sub_(b: Vec2t<Number>) = sub(this, this, b.x.f, b.y.f)


    operator fun times(b: Number) = mul(Vec2(), this, b.f, b.f)
    operator fun times(b: Vec2t<Number>) = mul(Vec2(), this, b.x.f, b.y.f)

    fun mul(bX: Number, bY: Number, res: Vec2 = Vec2()) = mul(res, this, bX.f, bY.f)
    fun mul(b: Number, res: Vec2 = Vec2()) = mul(res, this, b.f, b.f)
    fun mul(b: Vec2t<Number>, res: Vec2 = Vec2()) = mul(res, this, b.x.f, b.y.f)

    fun mul_(bX: Number, bY: Number) = mul(this, this, bX.f, bY.f)
    infix fun mul_(b: Number) = mul(this, this, b.f, b.f)
    infix fun mul_(b: Vec2t<Number>) = mul(this, this, b.x.f, b.y.f)


    operator fun div(b: Number) = div(Vec2(), this, b.f, b.f)
    operator fun div(b: Vec2t<Number>) = div(Vec2(), this, b.x.f, b.y.f)

    fun div(bX: Number, bY: Number, res: Vec2 = Vec2()) = div(res, this, bX.f, bY.f)
    fun div(b: Number, res: Vec2 = Vec2()) = div(res, this, b.f, b.f)
    fun div(b: Vec2t<Number>, res: Vec2 = Vec2()) = div(res, this, b.x.f, b.y.f)

    fun div_(bX: Number, bY: Number) = div(this, this, bX.f, bY.f)
    infix fun div_(b: Number) = div(this, this, b.f, b.f)
    infix fun div_(b: Vec2t<Number>) = div(this, this, b.x.f, b.y.f)


    operator fun rem(b: Number) = rem(Vec2(), this, b.f, b.f)
    operator fun rem(b: Vec2t<Number>) = rem(Vec2(), this, b.x.f, b.y.f)

    fun rem(bX: Number, bY: Number, res: Vec2 = Vec2()) = rem(res, this, bX.f, bY.f)
    fun rem(b: Number, res: Vec2 = Vec2()) = rem(res, this, b.f, b.f)
    fun rem(b: Vec2t<Number>, res: Vec2 = Vec2()) = rem(res, this, b.x.f, b.y.f)

    fun rem_(bX: Number, bY: Number) = rem(this, this, bX.f, bY.f)
    infix fun rem_(b: Number) = rem(this, this, b.f, b.f)
    infix fun rem_(b: Vec2t<Number>) = rem(this, this, b.x.f, b.y.f)
}