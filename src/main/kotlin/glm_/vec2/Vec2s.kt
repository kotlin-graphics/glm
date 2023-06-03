package glm_.vec2

import glm_.*
import glm_.vec1.Vec1bool
import glm_.vec1.Vec1s
import glm_.vec1.Vec1t
import glm_.vec2.operators.opVec2s
import glm_.vec3.Vec3bool
import glm_.vec3.Vec3s
import glm_.vec3.Vec3t
import glm_.vec4.Vec4bool
import glm_.vec4.Vec4s
import glm_.vec4.Vec4t
import kool.*
import java.io.PrintStream
import java.nio.*

/**
 * Created by GBarbieri on 06.10.2016.
 */

class Vec2s(@JvmField var ofs: Int, @JvmField var array: ShortArray) : Vec2t<Short>, ToShortBuffer {

    inline var x: Short
        get() = array[ofs]
        set(value) = array.set(ofs, value)
    inline var y: Short
        get() = array[ofs + 1]
        set(value) = array.set(ofs + 1, value)

    // -- Implicit basic constructors --

    constructor() : this(0)
    constructor(v: Vec2s) : this(v.x, v.y)

    // -- Explicit basic constructors --

    @JvmOverloads
    constructor(x: Short, y: Short = x) : this(0, shortArrayOf(x, y))

    // -- Conversion constructors --


    constructor(v: Number) : this(v.s)
    constructor(x: Number, y: Number) : this(x.s, y.s)
    // Explicit conversions (From section 5.4.1 Conversion and scalar constructors of GLSL 1.30.08 specification)

    constructor(v: Vec1t<out Number>) : this(v._x)
    constructor(x: Vec1t<out Number>, y: Number) : this(x._x, y)
    constructor(x: Number, y: Vec1t<out Number>) : this(x, y._x)
    constructor(x: Vec1t<out Number>, y: Vec1t<out Number>) : this(x._x, y._x)

    constructor(v: Vec2t<out Number>) : this(v._x, v._y)
    constructor(v: Vec3t<out Number>) : this(v._x, v._y)
    constructor(v: Vec4t<out Number>) : this(v._x, v._y)

    constructor(v: Vec1s) : this(v.x, v.x)
    constructor(x: Vec1s, y: Short) : this(x.x, y)
    constructor(x: Short, y: Vec1s) : this(x, y.x)
    constructor(x: Vec1s, y: Vec1s) : this(x.x, y.x)

    constructor(v: Vec3s) : this(v.x, v.y)
    constructor(v: Vec4s) : this(v.x, v.y)

    @JvmOverloads
    constructor(x: Boolean, y: Boolean = x) : this(x.s, y.s)

    constructor(x: Boolean, v: Vec1bool) : this(x.s, v.x.s)

    @JvmOverloads
    constructor(v: Vec1bool, y: Boolean = v.x) : this(v.x.s, y.s)

    constructor(x: Vec1bool, y: Vec1bool) : this(x.x.s, y.x.s)

    constructor(v: Vec2bool) : this(v.x.s, v.y.s)
    constructor(v: Vec3bool) : this(v.x.s, v.y.s)
    constructor(v: Vec4bool) : this(v.x.s, v.y.s)

    constructor(bytes: ByteArray, index: Int = 0, oneByteOneShort: Boolean = false, bigEndian: Boolean = true) : this(
            if (oneByteOneShort) bytes[index].s else bytes.getShort(index, bigEndian),
            if (oneByteOneShort) bytes[index + 1].s else bytes.getShort(index + Short.BYTES, bigEndian))

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

    constructor(list: Iterable<*>, index: Int = 0) : this(list.elementAt(index)!!.toShort, list.elementAt(index + 1)!!.toShort)

    constructor(bytes: ByteBuffer, index: Int = bytes.pos, oneByteOneShort: Boolean = false) : this(
            if (oneByteOneShort) bytes[index].s else bytes.getShort(index),
            if (oneByteOneShort) bytes[index + 1].s else bytes.getShort(index + Short.BYTES))

    constructor(chars: CharBuffer, index: Int = chars.pos) : this(chars[index].s, chars[index + 1].s)
    constructor(shorts: ShortBuffer, index: Int = shorts.pos) : this(shorts[index], shorts[index + 1])
    constructor(ints: IntBuffer, index: Int = ints.pos) : this(ints[index], ints[index + 1])
    constructor(longs: LongBuffer, index: Int = longs.pos) : this(longs[index], longs[index + 1])
    constructor(floats: FloatBuffer, index: Int = floats.pos) : this(floats[index], floats[index + 1])
    constructor(doubles: DoubleBuffer, index: Int = doubles.pos) : this(doubles[index], doubles[index + 1])

    constructor(block: (Int) -> Short) : this(block(0), block(1))
    constructor(ptr: Ptr<Short>) : this(ptr[0], ptr[1])


    fun set(bytes: ByteArray, index: Int = 0, oneByteOneShort: Boolean = false, bigEndian: Boolean = true) {
        x = if (oneByteOneShort) bytes[index].s else bytes.getShort(index, bigEndian)
        y = if (oneByteOneShort) bytes[index + 1].s else bytes.getShort(index + Short.BYTES, bigEndian)
    }

    fun set(bytes: ByteBuffer, index: Int = bytes.pos, oneByteOneShort: Boolean = false) {
        x = if (oneByteOneShort) bytes[index].s else bytes.getShort(index)
        y = if (oneByteOneShort) bytes[index + 1].s else bytes.getShort(index + Short.BYTES)
    }


    fun put(x: Short, y: Short) {
        this.x = x
        this.y = y
    }

    operator fun invoke(x: Short, y: Short): Vec2s {
        this.x = x
        this.y = y
        return this
    }

    override fun put(x: Number, y: Number) {
        this.x = x.s
        this.y = y.s
    }

    override operator fun invoke(x: Number, y: Number): Vec2s {
        this.x = x.s
        this.y = y.s
        return this
    }

    fun to(bytes: ByteArray, index: Int) = to(bytes, index, true)
    override fun to(bytes: ByteArray, index: Int, bigEndian: Boolean): ByteArray {
        bytes.putShort(index, x)
        bytes.putShort(index + Short.BYTES, y)
        return bytes
    }

    fun toShortArray(): ShortArray = to(ShortArray(length), 0)
    infix fun to(shorts: ShortArray): ShortArray = to(shorts, 0)
    fun to(shorts: ShortArray, index: Int): ShortArray {
        System.arraycopy(array, ofs, shorts, index, length)
        return shorts
    }

    override fun to(buf: ByteBuffer, offset: Int): ByteBuffer {
        buf.putShort(offset, x)
        buf.putShort(offset + Short.BYTES, y)
        return buf
    }

   override fun to(buf: ShortBuffer, index: Int): ShortBuffer {
        buf[index] = x
        buf[index + 1] = y
        return buf
    }

    infix fun to(ptr: Ptr<Short>) {
        ptr[0] = x
        ptr[1] = y
    }

    // -- Component accesses --

    override operator fun set(index: Int, value: Number) = when (index) {
        0 -> x = value.s
        1 -> y = value.s
        else -> throw ArrayIndexOutOfBoundsException()
    }


    // -- Unary arithmetic operators --

    operator fun unaryPlus() = this

    operator fun unaryMinus() = Vec2s(-x, -y)


    // -- Increment main.and decrement operators --

    operator fun inc() = plus(Vec2s(), this, 1, 1)
    infix fun inc(res: Vec2s) = plus(res, this, 1, 1)
    fun incAssign() = plus(this, this, 1, 1)


    operator fun dec() = minus(Vec2s(), this, 1, 1)
    infix fun dec(res: Vec2s) = minus(res, this, 1, 1)
    fun decAssign() = minus(this, this, 1, 1)


    // -- Specific binary arithmetic operators --

    infix operator fun plus(b: Short) = plus(Vec2s(), this, b, b)
    infix operator fun plus(b: Int) = plus(Vec2s(), this, b, b)
    infix operator fun plus(b: Vec2s) = plus(Vec2s(), this, b.x, b.y)

    @JvmOverloads
    fun plus(bX: Short, bY: Short, res: Vec2s = Vec2s()) = plus(res, this, bX, bY)

    @JvmOverloads
    fun plus(bX: Int, bY: Int, res: Vec2s = Vec2s()) = plus(res, this, bX, bY)

    fun plus(b: Short, res: Vec2s) = plus(res, this, b, b)
    fun plus(b: Int, res: Vec2s) = plus(res, this, b, b)
    fun plus(b: Vec2s, res: Vec2s) = plus(res, this, b.x, b.y)

    fun plusAssign(bX: Short, bY: Short) = plus(this, this, bX, bY)
    fun plusAssign(bX: Int, bY: Int) = plus(this, this, bX, bY)
    infix operator fun plusAssign(b: Short) {
        plus(this, this, b, b)
    }

    infix operator fun plusAssign(b: Int) {
        plus(this, this, b, b)
    }

    infix operator fun plusAssign(b: Vec2s) {
        plus(this, this, b.x, b.y)
    }


    infix operator fun minus(b: Short) = minus(Vec2s(), this, b, b)
    infix operator fun minus(b: Int) = minus(Vec2s(), this, b, b)
    infix operator fun minus(b: Vec2s) = minus(Vec2s(), this, b.x, b.y)

    @JvmOverloads
    fun minus(bX: Short, bY: Short, res: Vec2s = Vec2s()) = minus(res, this, bX, bY)

    @JvmOverloads
    fun minus(bX: Int, bY: Int, res: Vec2s = Vec2s()) = minus(res, this, bX, bY)

    fun minus(b: Short, res: Vec2s) = minus(res, this, b, b)
    fun minus(b: Int, res: Vec2s) = minus(res, this, b, b)
    fun minus(b: Vec2s, res: Vec2s) = minus(res, this, b.x, b.y)

    fun minusAssign(bX: Short, bY: Short) = minus(this, this, bX, bY)
    fun minusAssign(bX: Int, bY: Int) = minus(this, this, bX, bY)
    infix operator fun minusAssign(b: Short) {
        minus(this, this, b, b)
    }

    infix operator fun minusAssign(b: Int) {
        minus(this, this, b, b)
    }

    infix operator fun minusAssign(b: Vec2s) {
        minus(this, this, b.x, b.y)
    }


    infix operator fun times(b: Short) = times(Vec2s(), this, b, b)
    infix operator fun times(b: Int) = times(Vec2s(), this, b, b)
    infix operator fun times(b: Vec2s) = times(Vec2s(), this, b.x, b.y)

    @JvmOverloads
    fun times(bX: Short, bY: Short, res: Vec2s = Vec2s()) = times(res, this, bX, bY)

    @JvmOverloads
    fun times(bX: Int, bY: Int, res: Vec2s = Vec2s()) = times(res, this, bX, bY)

    fun times(b: Short, res: Vec2s) = times(res, this, b, b)
    fun times(b: Int, res: Vec2s) = times(res, this, b, b)
    fun times(b: Vec2s, res: Vec2s) = times(res, this, b.x, b.y)

    fun timesAssign(bX: Short, bY: Short) = times(this, this, bX, bY)
    fun timesAssign(bX: Int, bY: Int) = times(this, this, bX, bY)
    infix operator fun timesAssign(b: Short) {
        times(this, this, b, b)
    }

    infix operator fun timesAssign(b: Int) {
        times(this, this, b, b)
    }

    infix operator fun timesAssign(b: Vec2s) {
        times(this, this, b.x, b.y)
    }


    infix operator fun div(b: Short) = div(Vec2s(), this, b, b)
    infix operator fun div(b: Int) = div(Vec2s(), this, b, b)
    infix operator fun div(b: Vec2s) = div(Vec2s(), this, b.x, b.y)

    @JvmOverloads
    fun div(bX: Short, bY: Short, res: Vec2s = Vec2s()) = div(res, this, bX, bY)

    @JvmOverloads
    fun div(bX: Int, bY: Int, res: Vec2s = Vec2s()) = div(res, this, bX, bY)

    fun div(b: Short, res: Vec2s) = div(res, this, b, b)
    fun div(b: Int, res: Vec2s) = div(res, this, b, b)
    fun div(b: Vec2s, res: Vec2s) = div(res, this, b.x, b.y)

    fun divAssign(bX: Short, bY: Short) = div(this, this, bX, bY)
    fun divAssign(bX: Int, bY: Int) = div(this, this, bX, bY)
    infix operator fun divAssign(b: Short) {
        div(this, this, b, b)
    }

    infix operator fun divAssign(b: Int) {
        div(this, this, b, b)
    }

    infix operator fun divAssign(b: Vec2s) {
        div(this, this, b.x, b.y)
    }


    infix operator fun rem(b: Short) = rem(Vec2s(), this, b, b)
    infix operator fun rem(b: Int) = rem(Vec2s(), this, b, b)
    infix operator fun rem(b: Vec2s) = rem(Vec2s(), this, b.x, b.y)

    @JvmOverloads
    fun rem(bX: Short, bY: Short, res: Vec2s = Vec2s()) = rem(res, this, bX, bY)

    @JvmOverloads
    fun rem(bX: Int, bY: Int, res: Vec2s = Vec2s()) = rem(res, this, bX, bY)

    fun rem(b: Short, res: Vec2s) = rem(res, this, b, b)
    fun rem(b: Int, res: Vec2s) = rem(res, this, b, b)
    fun rem(b: Vec2s, res: Vec2s) = rem(res, this, b.x, b.y)

    fun remAssign(bX: Short, bY: Short) = rem(this, this, bX, bY)
    fun remAssign(bX: Int, bY: Int) = rem(this, this, bX, bY)
    infix operator fun remAssign(b: Short) {
        rem(this, this, b, b)
    }

    infix operator fun remAssign(b: Int) {
        rem(this, this, b, b)
    }

    infix operator fun remAssign(b: Vec2s) {
        rem(this, this, b.x, b.y)
    }


    // -- Generic binary arithmetic operators --

    infix operator fun plus(b: Number) = plus(Vec2s(), this, b.s, b.s)
    infix operator fun plus(b: Vec2t<out Number>) = plus(Vec2s(), this, b._x.s, b._y.s)

    @JvmOverloads
    fun plus(bX: Number, bY: Number, res: Vec2s = Vec2s()) = plus(res, this, bX.s, bY.s)

    fun plus(b: Number, res: Vec2s) = plus(res, this, b.s, b.s)
    fun plus(b: Vec2t<out Number>, res: Vec2s) = plus(res, this, b._x.s, b._y.s)

    fun plusAssign(bX: Number, bY: Number) = plus(this, this, bX.s, bY.s)
    infix operator fun plusAssign(b: Number) {
        plus(this, this, b.s, b.s)
    }

    infix operator fun plusAssign(b: Vec2t<out Number>) {
        plus(this, this, b._x.s, b._y.s)
    }


    infix operator fun minus(b: Number) = minus(Vec2s(), this, b.s, b.s)
    infix operator fun minus(b: Vec2t<out Number>) = minus(Vec2s(), this, b._x.s, b._y.s)

    @JvmOverloads
    fun minus(bX: Number, bY: Number, res: Vec2s = Vec2s()) = minus(res, this, bX.s, bY.s)

    fun minus(b: Number, res: Vec2s) = minus(res, this, b.s, b.s)
    fun minus(b: Vec2t<out Number>, res: Vec2s) = minus(res, this, b._x.s, b._y.s)

    fun minusAssign(bX: Number, bY: Number) = minus(this, this, bX.s, bY.s)
    infix operator fun minusAssign(b: Number) {
        minus(this, this, b.s, b.s)
    }

    infix operator fun minusAssign(b: Vec2t<out Number>) {
        minus(this, this, b._x.s, b._y.s)
    }


    infix operator fun times(b: Number) = times(Vec2s(), this, b.s, b.s)
    infix operator fun times(b: Vec2t<out Number>) = times(Vec2s(), this, b._x.s, b._y.s)

    @JvmOverloads
    fun times(bX: Number, bY: Number, res: Vec2s = Vec2s()) = times(res, this, bX.s, bY.s)

    fun times(b: Number, res: Vec2s) = times(res, this, b.s, b.s)
    fun times(b: Vec2t<out Number>, res: Vec2s) = times(res, this, b._x.s, b._y.s)

    fun timesAssign(bX: Number, bY: Number) = times(this, this, bX.s, bY.s)
    infix operator fun timesAssign(b: Number) {
        times(this, this, b.s, b.s)
    }

    infix operator fun timesAssign(b: Vec2t<out Number>) {
        times(this, this, b._x.s, b._y.s)
    }


    infix operator fun div(b: Number) = div(Vec2s(), this, b.s, b.s)
    infix operator fun div(b: Vec2t<out Number>) = div(Vec2s(), this, b._x.s, b._y.s)

    @JvmOverloads
    fun div(bX: Number, bY: Number, res: Vec2s = Vec2s()) = div(res, this, bX.s, bY.s)

    fun div(b: Number, res: Vec2s) = div(res, this, b.s, b.s)
    fun div(b: Vec2t<out Number>, res: Vec2s) = div(res, this, b._x.s, b._y.s)

    fun divAssign(bX: Number, bY: Number) = div(this, this, bX.s, bY.s)
    infix operator fun divAssign(b: Number) {
        div(this, this, b.s, b.s)
    }

    infix operator fun divAssign(b: Vec2t<out Number>) {
        div(this, this, b._x.s, b._y.s)
    }


    infix operator fun rem(b: Number) = rem(Vec2s(), this, b.s, b.s)
    infix operator fun rem(b: Vec2t<out Number>) = rem(Vec2s(), this, b._x.s, b._y.s)

    @JvmOverloads
    fun rem(bX: Number, bY: Number, res: Vec2s = Vec2s()) = rem(res, this, bX.s, bY.s)

    fun rem(b: Number, res: Vec2s) = rem(res, this, b.s, b.s)
    fun rem(b: Vec2t<out Number>, res: Vec2s) = rem(res, this, b._x.s, b._y.s)

    fun remAssign(bX: Number, bY: Number) = rem(this, this, bX.s, bY.s)
    infix operator fun remAssign(b: Number) {
        rem(this, this, b.s, b.s)
    }

    infix operator fun remAssign(b: Vec2t<out Number>) {
        rem(this, this, b._x.s, b._y.s)
    }


    // -- Specific bitwise operators --

    infix fun and(b: Short) = and(Vec2s(), this, b, b)
    infix fun and(b: Int) = and(Vec2s(), this, b, b)
    infix fun and(b: Vec2s) = and(Vec2s(), this, b.x, b.y)

    fun and(b: Short, res: Vec2s) = and(res, this, b, b)
    fun and(b: Int, res: Vec2s) = and(res, this, b, b)
    fun and(b: Vec2s, res: Vec2s) = and(res, this, b.x, b.y)
    @JvmOverloads
    fun and(bX: Short, bY: Short, res: Vec2s = Vec2s()) = and(res, this, bX, bY)

    @JvmOverloads
    fun and(bX: Int, bY: Int, res: Vec2s = Vec2s()) = and(res, this, bX, bY)

    infix fun andAssign(b: Short) = and(this, this, b, b)
    infix fun andAssign(b: Int) = and(this, this, b, b)
    infix fun andAssign(b: Vec2s) = and(this, this, b.x, b.y)
    fun andAssign(bX: Short, bY: Short) = and(this, this, bX, bY)
    fun andAssign(bX: Int, bY: Int) = and(this, this, bX, bY)


    infix fun or(b: Short) = or(Vec2s(), this, b, b)
    infix fun or(b: Int) = or(Vec2s(), this, b, b)
    infix fun or(b: Vec2s) = or(Vec2s(), this, b.x, b.y)

    fun or(b: Short, res: Vec2s) = or(res, this, b, b)
    fun or(b: Int, res: Vec2s) = or(res, this, b, b)
    fun or(b: Vec2s, res: Vec2s) = or(res, this, b.x, b.y)
    @JvmOverloads
    fun or(bX: Short, bY: Short, res: Vec2s = Vec2s()) = or(res, this, bX, bY)

    @JvmOverloads
    fun or(bX: Int, bY: Int, res: Vec2s = Vec2s()) = or(res, this, bX, bY)

    infix fun orAssign(b: Short) = or(this, this, b, b)
    infix fun orAssign(b: Int) = or(this, this, b, b)
    infix fun orAssign(b: Vec2s) = or(this, this, b.x, b.y)
    fun orAssign(bX: Short, bY: Short) = or(this, this, bX, bY)
    fun orAssign(bX: Int, bY: Int) = or(this, this, bX, bY)


    infix fun xor(b: Short) = xor(Vec2s(), this, b, b)
    infix fun xor(b: Int) = xor(Vec2s(), this, b, b)
    infix fun xor(b: Vec2s) = xor(Vec2s(), this, b.x, b.y)

    fun xor(b: Short, res: Vec2s) = xor(res, this, b, b)
    fun xor(b: Int, res: Vec2s) = xor(res, this, b, b)
    fun xor(b: Vec2s, res: Vec2s) = xor(res, this, b.x, b.y)
    @JvmOverloads
    fun xor(bX: Short, bY: Short, res: Vec2s = Vec2s()) = xor(res, this, bX, bY)

    @JvmOverloads
    fun xor(bX: Int, bY: Int, res: Vec2s = Vec2s()) = xor(res, this, bX, bY)

    infix fun xorAssign(b: Short) = xor(this, this, b, b)
    infix fun xorAssign(b: Int) = xor(this, this, b, b)
    infix fun xorAssign(b: Vec2s) = xor(this, this, b.x, b.y)
    fun xorAssign(bX: Short, bY: Short) = xor(this, this, bX, bY)
    fun xorAssign(bX: Int, bY: Int) = xor(this, this, bX, bY)


    infix fun shl(b: Short) = shl(Vec2s(), this, b, b)
    infix fun shl(b: Int) = shl(Vec2s(), this, b, b)
    infix fun shl(b: Vec2s) = shl(Vec2s(), this, b.x, b.y)

    fun shl(b: Short, res: Vec2s) = shl(res, this, b, b)
    fun shl(b: Int, res: Vec2s) = shl(res, this, b, b)
    fun shl(b: Vec2s, res: Vec2s) = shl(res, this, b.x, b.y)
    @JvmOverloads
    fun shl(bX: Short, bY: Short, res: Vec2s = Vec2s()) = shl(res, this, bX, bY)

    @JvmOverloads
    fun shl(bX: Int, bY: Int, res: Vec2s = Vec2s()) = shl(res, this, bX, bY)

    infix fun shlAssign(b: Short) = shl(this, this, b, b)
    infix fun shlAssign(b: Int) = shl(this, this, b, b)
    infix fun shlAssign(b: Vec2s) = shl(this, this, b.x, b.y)
    fun shlAssign(bX: Short, bY: Short) = shl(this, this, bX, bY)
    fun shlAssign(bX: Int, bY: Int) = shl(this, this, bX, bY)


    infix fun shr(b: Short) = shr(Vec2s(), this, b, b)
    infix fun shr(b: Int) = shr(Vec2s(), this, b, b)
    infix fun shr(b: Vec2s) = shr(Vec2s(), this, b.x, b.y)

    fun shr(b: Short, res: Vec2s) = shr(res, this, b, b)
    fun shr(b: Int, res: Vec2s) = shr(res, this, b, b)
    fun shr(b: Vec2s, res: Vec2s) = shr(res, this, b.x, b.y)
    @JvmOverloads
    fun shr(bX: Short, bY: Short, res: Vec2s = Vec2s()) = shr(res, this, bX, bY)

    @JvmOverloads
    fun shr(bX: Int, bY: Int, res: Vec2s = Vec2s()) = shr(res, this, bX, bY)

    infix fun shrAssign(b: Short) = shr(this, this, b, b)
    infix fun shrAssign(b: Int) = shr(this, this, b, b)
    infix fun shrAssign(b: Vec2s) = shr(this, this, b.x, b.y)
    fun shrAssign(bX: Short, bY: Short) = shr(this, this, bX, bY)
    fun shrAssign(bX: Int, bY: Int) = shr(this, this, bX, bY)


    @JvmOverloads
    fun inv(res: Vec2s = Vec2s()) = inv(res, this)

    fun invAssign() = inv(this, this)


    // -- Generic bitwise operators --

    infix fun and(b: Number) = and(Vec2s(), this, b.s, b.s)
    infix fun and(b: Vec2t<out Number>) = and(Vec2s(), this, b._x.s, b._y.s)

    fun and(b: Number, res: Vec2s) = and(res, this, b.s, b.s)
    fun and(b: Vec2t<out Number>, res: Vec2s) = and(res, this, b._x.s, b._y.s)

    @JvmOverloads
    fun and(bX: Number, bY: Number, res: Vec2s = Vec2s()) = and(res, this, bX.s, bY.s)

    infix fun andAssign(b: Number) = and(this, this, b.s, b.s)
    infix fun andAssign(b: Vec2t<out Number>) = and(this, this, b._x.s, b._y.s)
    fun andAssign(bX: Number, bY: Number) = and(this, this, bX.s, bY.s)


    infix fun or(b: Number) = or(Vec2s(), this, b.s, b.s)
    infix fun or(b: Vec2t<out Number>) = or(Vec2s(), this, b._x.s, b._y.s)

    fun or(b: Number, res: Vec2s) = or(res, this, b.s, b.s)
    fun or(b: Vec2t<out Number>, res: Vec2s) = or(res, this, b._x.s, b._y.s)

    @JvmOverloads
    fun or(bX: Number, bY: Number, res: Vec2s = Vec2s()) = or(res, this, bX.s, bY.s)

    infix fun orAssign(b: Number) = or(this, this, b.s, b.s)
    infix fun orAssign(b: Vec2t<out Number>) = or(this, this, b._x.s, b._y.s)
    fun orAssign(bX: Number, bY: Number) = or(this, this, bX.s, bY.s)


    infix fun xor(b: Number) = xor(Vec2s(), this, b.s, b.s)
    infix fun xor(b: Vec2t<out Number>) = xor(Vec2s(), this, b._x.s, b._y.s)

    fun xor(b: Number, res: Vec2s) = xor(res, this, b.s, b.s)
    fun xor(b: Vec2t<out Number>, res: Vec2s) = xor(res, this, b._x.s, b._y.s)

    @JvmOverloads
    fun xor(bX: Number, bY: Number, res: Vec2s = Vec2s()) = xor(res, this, bX.s, bY.s)

    infix fun xorAssign(b: Number) = xor(this, this, b.s, b.s)
    infix fun xorAssign(b: Vec2t<out Number>) = xor(this, this, b._x.s, b._y.s)
    fun xorAssign(bX: Number, bY: Number) = xor(this, this, bX.s, bY.s)


    infix fun shl(b: Number) = shl(Vec2s(), this, b.s, b.s)
    infix fun shl(b: Vec2t<out Number>) = shl(Vec2s(), this, b._x.s, b._y.s)

    fun shl(b: Number, res: Vec2s) = shl(res, this, b.s, b.s)
    fun shl(b: Vec2t<out Number>, res: Vec2s) = shl(res, this, b._x.s, b._y.s)

    @JvmOverloads
    fun shl(bX: Number, bY: Number, res: Vec2s = Vec2s()) = shl(res, this, bX.s, bY.s)

    infix fun shlAssign(b: Number) = shl(this, this, b.s, b.s)
    infix fun shlAssign(b: Vec2t<out Number>) = shl(this, this, b._x.s, b._y.s)
    fun shlAssign(bX: Number, bY: Number) = shl(this, this, bX.s, bY.s)


    infix fun shr(b: Number) = shr(Vec2s(), this, b.s, b.s)
    infix fun shr(b: Vec2t<out Number>) = shr(Vec2s(), this, b._x.s, b._y.s)

    fun shr(b: Number, res: Vec2s) = shr(res, this, b.s, b.s)
    fun shr(b: Vec2t<out Number>, res: Vec2s) = shr(res, this, b._x.s, b._y.s)

    @JvmOverloads
    fun shr(bX: Number, bY: Number, res: Vec2s = Vec2s()) = shr(res, this, bX.s, bY.s)

    infix fun shrAssign(b: Number) = shr(this, this, b.s, b.s)
    infix fun shrAssign(b: Vec2t<out Number>) = shr(this, this, b._x.s, b._y.s)
    fun shrAssign(bX: Number, bY: Number) = shr(this, this, bX.s, bY.s)


    infix fun allLessThan(s: Short): Boolean = x < s && y < s
    infix fun anyLessThan(s: Short): Boolean = x < s || y < s
    infix fun lessThan(s: Short): Vec2bool = Vec2bool { get(it) < s }

    infix fun allLessThanEqual(s: Short): Boolean = x <= s && y <= s
    infix fun anyLessThanEqual(s: Short): Boolean = x <= s || y <= s
    infix fun lessThanEqual(s: Short): Vec2bool = Vec2bool { get(it) <= s }

    infix fun allEqual(s: Short): Boolean = x == s && y == s
    infix fun anyEqual(s: Short): Boolean = x == s || y == s
    infix fun equal(s: Short): Vec2bool = Vec2bool { get(it) == s }

    infix fun allNotEqual(s: Short): Boolean = x != s && y != s
    infix fun anyNotEqual(s: Short): Boolean = x != s || y != s
    infix fun notEqual(s: Short): Vec2bool = Vec2bool { get(it) != s }

    infix fun allGreaterThan(s: Short): Boolean = x > s && y > s
    infix fun anyGreaterThan(s: Short): Boolean = x > s || y > s
    infix fun greaterThan(s: Short): Vec2bool = Vec2bool { get(it) > s }

    infix fun allGreaterThanEqual(s: Short): Boolean = x >= s && y >= s
    infix fun anyGreaterThanEqual(s: Short): Boolean = x >= s || y >= s
    infix fun greaterThanEqual(s: Short): Vec2bool = Vec2bool { get(it) >= s }


    infix fun allLessThan(v: Vec2s): Boolean = x < v.x && y < v.y
    infix fun anyLessThan(v: Vec2s): Boolean = x < v.x || y < v.y
    infix fun lessThan(v: Vec2s): Vec2bool = Vec2bool { get(it) < v[it] }

    infix fun allLessThanEqual(v: Vec2s): Boolean = x <= v.x && y <= v.y
    infix fun anyLessThanEqual(v: Vec2s): Boolean = x <= v.x || y <= v.y
    infix fun lessThanEqual(v: Vec2s): Vec2bool = Vec2bool { get(it) <= v[it] }

    infix fun allEqual(v: Vec2s): Boolean = x == v.x && y == v.y
    infix fun anyEqual(v: Vec2s): Boolean = x == v.x || y == v.y
    infix fun equal(v: Vec2s): Vec2bool = Vec2bool { get(it) == v[it] }

    infix fun allNotEqual(v: Vec2s): Boolean = x != v.x && y != v.y
    infix fun anyNotEqual(v: Vec2s): Boolean = x != v.x || y != v.y
    infix fun notEqual(v: Vec2s): Vec2bool = Vec2bool { get(it) != v[it] }

    infix fun allGreaterThan(v: Vec2s): Boolean = x > v.x && y > v.y
    infix fun anyGreaterThan(v: Vec2s): Boolean = x > v.x || y > v.y
    infix fun greaterThan(v: Vec2s): Vec2bool = Vec2bool { get(it) > v[it] }

    infix fun allGreaterThanEqual(v: Vec2s): Boolean = x >= v.x && y >= v.y
    infix fun anyGreaterThanEqual(v: Vec2s): Boolean = x >= v.x || y >= v.y
    infix fun greaterThanEqual(v: Vec2s): Vec2bool = Vec2bool { get(it) >= v[it] }


    companion object : opVec2s {
        const val length = Vec2t.LENGTH

        @JvmField
        val size = length * Short.BYTES

        @JvmStatic
        fun fromPointer(ptr: Ptr<Short>) = Vec2s(ptr)
    }

    override fun size() = size

    override fun equals(other: Any?) = other is Vec2s && this[0] == other[0] && this[1] == other[1]

    override fun hashCode() = 31 * x.hashCode() + y.hashCode()

    @JvmOverloads
    fun print(name: String = "", stream: PrintStream = System.out) = stream.print("$name$this")

    @JvmOverloads
    fun println(name: String = "", stream: PrintStream = System.out) = stream.println("$name$this")


    //@formatter:off
    override inline var _x get() = x; set(value) { x = value }
    override inline var r get() = x; set(value) { x = value }
    override inline var s get() = x; set(value) { x = value }

    override inline var _y get() = y; set(value) { y = value }
    override inline var g get() = y; set(value) { y = value }
    override inline var t get() = y; set(value) { y = value }
    //@formatter:on

    override inline operator fun get(index: Int) = array[ofs + index]

    inline operator fun set(index: Int, value: Short) {
        array[ofs + index] = value
    }

    override inline operator fun component1() = x
    override inline operator fun component2() = y


    override fun toString(): String = "($x, $y)"
}
