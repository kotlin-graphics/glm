package glm_.vec2

import glm_.*
import glm_.vec1.Vec1bool
import glm_.vec1.Vec1t
import glm_.vec2.operators.opVec2i
import glm_.vec3.Vec3bool
import glm_.vec3.Vec3t
import glm_.vec4.Vec4bool
import glm_.vec4.Vec4t
import kool.*
import org.lwjgl.system.MemoryStack
import org.lwjgl.system.MemoryUtil.memGetInt
import org.lwjgl.system.MemoryUtil.memPutInt
import java.io.PrintStream
import java.nio.*
import kotlin.math.abs

/**
 * Created bY GBarbieri on 06.10.2016.
 */

class Vec2i(@JvmField var ofs: Int, @JvmField var array: IntArray) : Vec2t<Int> {

    inline var x: Int
        get() = array[ofs]
        set(value) = array.set(ofs, value)
    inline var y: Int
        get() = array[ofs + 1]
        set(value) = array.set(ofs + 1, value)

    // -- Implicit basic constructors --

    constructor() : this(0)
    constructor(v: Vec2i) : this(v.x, v.y)

    // -- Explicit basic constructors --

    @JvmOverloads
    constructor(x: Int, y: Int = x) : this(0, intArrayOf(x, y))

    // -- Conversion constructors --


    constructor(v: Number) : this(v.i)
    constructor(x: Number, y: Number) : this(x.i, y.i)

    // Explicit conversions (From section 5.4.1 Conversion and scalar constructors of GLSL 1.30.08 specification)

    constructor(v: Vec1t<out Number>) : this(v._x)
    constructor(x: Vec1t<out Number>, y: Number) : this(x._x, y)
    constructor(x: Number, y: Vec1t<out Number>) : this(x, y._x)
    constructor(x: Vec1t<out Number>, y: Vec1t<out Number>) : this(x._x, y._x)

    constructor(v: Vec2t<out Number>) : this(v._x, v._y)
    constructor(v: Vec3t<out Number>) : this(v._x, v._y)
    constructor(v: Vec4t<out Number>) : this(v._x, v._y)

    constructor(v: Vec1i) : this(v.x, v.x)
    constructor(x: Vec1i, y: Int) : this(x.x, y)
    constructor(x: Int, y: Vec1i) : this(x, y.x)
    constructor(x: Vec1i, y: Vec1i) : this(x.x, y.x)

    constructor(v: Vec3i) : this(v.x, v.y)
    constructor(v: Vec4i) : this(v.x, v.y)

    constructor(v: Vec2) : this(v.x.toInt(), v.y.toInt())
    constructor(v: Vec2d) : this(v.x.toInt(), v.y.toInt())

    @JvmOverloads
    constructor(x: Boolean, y: Boolean = x) : this(x.i, y.i)

    constructor(x: Boolean, v: Vec1bool) : this(x.i, v.x.i)

    @JvmOverloads
    constructor(v: Vec1bool, y: Boolean = v.x) : this(v.x.i, y.i)

    constructor(x: Vec1bool, y: Vec1bool) : this(x.x.i, y.x.i)

    constructor(v: Vec2bool) : this(v.x.i, v.y.i)
    constructor(v: Vec3bool) : this(v.x.i, v.y.i)
    constructor(v: Vec4bool) : this(v.x.i, v.y.i)

    constructor(bytes: ByteArray, index: Int = 0, oneByteOneInt: Boolean = false, bigEndian: Boolean = true) : this(
            if (oneByteOneInt) bytes[index].i else bytes.getInt(index, bigEndian),
            if (oneByteOneInt) bytes[index + 1].i else bytes.getInt(index + Int.BYTES, bigEndian))

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

    constructor(list: Iterable<*>, index: Int = 0) : this(list.elementAt(index)!!.toInt, list.elementAt(index + 1)!!.toInt)

    constructor(bytes: ByteBuffer, index: Int = bytes.pos, oneByteOneInt: Boolean = false) : this(
            if (oneByteOneInt) bytes[index].i else bytes.getInt(index),
            if (oneByteOneInt) bytes[index + 1].i else bytes.getInt(index + Int.BYTES))

    constructor(chars: CharBuffer, index: Int = chars.pos) : this(chars[index].i, chars[index + 1].i)
    constructor(shorts: ShortBuffer, index: Int = shorts.pos) : this(shorts[index], shorts[index + 1])
    constructor(ints: IntBuffer, index: Int = ints.pos) : this(ints[index], ints[index + 1])
    constructor(longs: LongBuffer, index: Int = longs.pos) : this(longs[index], longs[index + 1])
    constructor(floats: FloatBuffer, index: Int = floats.pos) : this(floats[index], floats[index + 1])
    constructor(doubles: DoubleBuffer, index: Int = doubles.pos) : this(doubles[index], doubles[index + 1])

    constructor(block: (Int) -> Int) : this(block(0), block(1))
    constructor(ptr: Ptr<Int>) : this(ptr[0], ptr[1])

    // for opengl
    constructor(x: IntBuffer, y: IntBuffer) : this(x[0], y[0]) // TODO others?


    fun set(bytes: ByteArray, index: Int = 0, oneByteOneInt: Boolean = false, bigEndian: Boolean = true) {
        x = if (oneByteOneInt) bytes[index].i else bytes.getInt(index, bigEndian)
        y = if (oneByteOneInt) bytes[index + 1].i else bytes.getInt(index + Int.BYTES, bigEndian)
    }

    fun set(bytes: ByteBuffer, index: Int = bytes.pos, oneByteOneInt: Boolean = false) {
        x = if (oneByteOneInt) bytes[index].i else bytes.getInt(index)
        y = if (oneByteOneInt) bytes[index + 1].i else bytes.getInt(index + Int.BYTES)
    }


    fun put(x: Int, y: Int) {
        this.x = x
        this.y = y
    }

    operator fun invoke(x: Int, y: Int): Vec2i {
        this.x = x
        this.y = y
        return this
    }

    override fun put(x: Number, y: Number) {
        this.x = x.i
        this.y = y.i
    }

    override operator fun invoke(x: Number, y: Number): Vec2i {
        this.x = x.i
        this.y = y.i
        return this
    }

    fun to(bytes: ByteArray, index: Int) = to(bytes, index, true)
    override fun to(bytes: ByteArray, index: Int, bigEndian: Boolean): ByteArray {
        bytes.putInt(index, x)
        bytes.putInt(index + Int.BYTES, y)
        return bytes
    }

    fun toIntArray(): IntArray = to(IntArray(length), 0)
    infix fun to(ints: IntArray): IntArray = to(ints, 0)
    fun to(ints: IntArray, index: Int): IntArray {
        System.arraycopy(array, ofs, ints, index, length)
        return ints
    }

    override fun to(buf: ByteBuffer, offset: Int): ByteBuffer {
        buf.putInt(offset, x)
        buf.putInt(offset + Int.BYTES, y)
        return buf
    }

    fun toIntBufferStack(): IntBuffer = to(MemoryStack.stackGet().mallocInt(length))
    infix fun toIntBuffer(stack: MemoryStack): IntBuffer = to(stack.mallocInt(length))
    fun toIntBuffer(): IntBuffer = to(IntBuffer(length))
    infix fun to(buf: IntBuffer): IntBuffer = to(buf, buf.pos)

    fun to(buf: IntBuffer, index: Int = 0): IntBuffer {
        buf[index] = x
        buf[index + 1] = y
        return buf
    }

    infix fun to(ptr: Ptr<Int>) {
        ptr[0] = x
        ptr[1] = y
    }

    // -- Component accesses --

    override operator fun set(index: Int, value: Number) = when (index) {
        0 -> x = value.i
        1 -> y = value.i
        else -> throw ArrayIndexOutOfBoundsException()
    }

    // TODO
    fun comptimes() = x * y


    // -- Unary arithmetic operators --

    operator fun unaryPlus() = this

    operator fun unaryMinus() = Vec2i(-x, -y)

    // -- Increment main.and decrement operators --

    operator fun inc() = plus(Vec2i(), this, 1, 1)
    infix fun inc(res: Vec2i) = plus(res, this, 1, 1)
    fun incAssign() = plus(this, this, 1, 1)


    operator fun dec() = minus(Vec2i(), this, 1, 1)
    infix fun dec(res: Vec2i) = minus(res, this, 1, 1)
    fun decAssign() = minus(this, this, 1, 1)


    // -- Specific binary arithmetic operators --

    infix operator fun plus(b: Int) = plus(Vec2i(), this, b, b)
    infix operator fun plus(b: Vec2i) = plus(Vec2i(), this, b.x, b.y)

    @JvmOverloads
    fun plus(bX: Int, bY: Int, res: Vec2i = Vec2i()) = plus(res, this, bX, bY)

    fun plus(b: Int, res: Vec2i) = plus(res, this, b, b)
    fun plus(b: Vec2i, res: Vec2i) = plus(res, this, b.x, b.y)

    fun plusAssign(bX: Int, bY: Int) = plus(this, this, bX, bY)
    infix operator fun plusAssign(b: Int) {
        plus(this, this, b, b)
    }

    infix operator fun plusAssign(b: Vec2i) {
        plus(this, this, b.x, b.y)
    }


    infix operator fun minus(b: Int) = minus(Vec2i(), this, b, b)
    infix operator fun minus(b: Vec2i) = minus(Vec2i(), this, b.x, b.y)

    @JvmOverloads
    fun minus(bX: Int, bY: Int, res: Vec2i = Vec2i()) = minus(res, this, bX, bY)

    fun minus(b: Int, res: Vec2i) = minus(res, this, b, b)
    fun minus(b: Vec2i, res: Vec2i) = minus(res, this, b.x, b.y)

    fun minusAssign(bX: Int, bY: Int) = minus(this, this, bX, bY)
    infix operator fun minusAssign(b: Int) {
        minus(this, this, b, b)
    }

    infix operator fun minusAssign(b: Vec2i) {
        minus(this, this, b.x, b.y)
    }


    infix operator fun times(b: Int) = times(Vec2i(), this, b, b)
    infix operator fun times(b: Vec2i) = times(Vec2i(), this, b.x, b.y)

    @JvmOverloads
    fun times(bX: Int, bY: Int, res: Vec2i = Vec2i()) = times(res, this, bX, bY)

    fun times(b: Int, res: Vec2i) = times(res, this, b, b)
    fun times(b: Vec2i, res: Vec2i) = times(res, this, b.x, b.y)

    fun timesAssign(bX: Int, bY: Int) = times(this, this, bX, bY)
    infix operator fun timesAssign(b: Int) {
        times(this, this, b, b)
    }

    infix operator fun timesAssign(b: Vec2i) {
        times(this, this, b.x, b.y)
    }


    infix operator fun div(b: Int) = div(Vec2i(), this, b, b)
    infix operator fun div(b: Vec2i) = div(Vec2i(), this, b.x, b.y)

    @JvmOverloads
    fun div(bX: Int, bY: Int, res: Vec2i = Vec2i()) = div(res, this, bX, bY)

    fun div(b: Int, res: Vec2i) = div(res, this, b, b)
    fun div(b: Vec2i, res: Vec2i) = div(res, this, b.x, b.y)

    fun divAssign(bX: Int, bY: Int) = div(this, this, bX, bY)
    infix operator fun divAssign(b: Int) {
        div(this, this, b, b)
    }

    infix operator fun divAssign(b: Vec2i) {
        div(this, this, b.x, b.y)
    }


    infix operator fun rem(b: Int) = rem(Vec2i(), this, b, b)
    infix operator fun rem(b: Vec2i) = rem(Vec2i(), this, b.x, b.y)

    @JvmOverloads
    fun rem(bX: Int, bY: Int, res: Vec2i = Vec2i()) = rem(res, this, bX, bY)

    fun rem(b: Int, res: Vec2i) = rem(res, this, b, b)
    fun rem(b: Vec2i, res: Vec2i) = rem(res, this, b.x, b.y)

    fun remAssign(bX: Int, bY: Int) = rem(this, this, bX, bY)
    infix operator fun remAssign(b: Int) {
        rem(this, this, b, b)
    }

    infix operator fun remAssign(b: Vec2i) {
        rem(this, this, b.x, b.y)
    }


    // -- Generic binary arithmetic operators --

    infix operator fun plus(b: Number) = plus(Vec2i(), this, b.i, b.i)
    infix operator fun plus(b: Vec2t<out Number>) = plus(Vec2i(), this, b._x.i, b._y.i)

    @JvmOverloads
    fun plus(bX: Number, bY: Number, res: Vec2i = Vec2i()) = plus(res, this, bX.i, bY.i)

    fun plus(b: Number, res: Vec2i) = plus(res, this, b.i, b.i)
    fun plus(b: Vec2t<out Number>, res: Vec2i) = plus(res, this, b._x.i, b._y.i)

    fun plusAssign(bX: Number, bY: Number) = plus(this, this, bX.i, bY.i)
    infix operator fun plusAssign(b: Number) {
        plus(this, this, b.i, b.i)
    }

    infix operator fun plusAssign(b: Vec2t<out Number>) {
        plus(this, this, b._x.i, b._y.i)
    }


    infix operator fun minus(b: Number) = minus(Vec2i(), this, b.i, b.i)
    infix operator fun minus(b: Vec2t<out Number>) = minus(Vec2i(), this, b._x.i, b._y.i)

    @JvmOverloads
    fun minus(bX: Number, bY: Number, res: Vec2i = Vec2i()) = minus(res, this, bX.i, bY.i)

    fun minus(b: Number, res: Vec2i) = minus(res, this, b.i, b.i)
    fun minus(b: Vec2t<out Number>, res: Vec2i) = minus(res, this, b._x.i, b._y.i)

    fun minusAssign(bX: Number, bY: Number) = minus(this, this, bX.i, bY.i)
    infix operator fun minusAssign(b: Number) {
        minus(this, this, b.i, b.i)
    }

    infix operator fun minusAssign(b: Vec2t<out Number>) {
        minus(this, this, b._x.i, b._y.i)
    }


    infix operator fun times(b: Number) = times(Vec2i(), this, b.i, b.i)
    infix operator fun times(b: Vec2t<out Number>) = times(Vec2i(), this, b._x.i, b._y.i)

    @JvmOverloads
    fun times(bX: Number, bY: Number, res: Vec2i = Vec2i()) = times(res, this, bX.i, bY.i)

    fun times(b: Number, res: Vec2i) = times(res, this, b.i, b.i)
    fun times(b: Vec2t<out Number>, res: Vec2i) = times(res, this, b._x.i, b._y.i)

    fun timesAssign(bX: Number, bY: Number) = times(this, this, bX.i, bY.i)
    infix operator fun timesAssign(b: Number) {
        times(this, this, b.i, b.i)
    }

    infix operator fun timesAssign(b: Vec2t<out Number>) {
        times(this, this, b._x.i, b._y.i)
    }


    infix operator fun div(b: Number) = div(Vec2i(), this, b.i, b.i)
    infix operator fun div(b: Vec2t<out Number>) = div(Vec2i(), this, b._x.i, b._y.i)

    @JvmOverloads
    fun div(bX: Number, bY: Number, res: Vec2i = Vec2i()) = div(res, this, bX.i, bY.i)

    fun div(b: Number, res: Vec2i) = div(res, this, b.i, b.i)
    fun div(b: Vec2t<out Number>, res: Vec2i) = div(res, this, b._x.i, b._y.i)

    fun divAssign(bX: Number, bY: Number) = div(this, this, bX.i, bY.i)
    infix operator fun divAssign(b: Number) {
        div(this, this, b.i, b.i)
    }

    infix operator fun divAssign(b: Vec2t<out Number>) {
        div(this, this, b._x.i, b._y.i)
    }


    infix operator fun rem(b: Number) = rem(Vec2i(), this, b.i, b.i)
    infix operator fun rem(b: Vec2t<out Number>) = rem(Vec2i(), this, b._x.i, b._y.i)

    @JvmOverloads
    fun rem(bX: Number, bY: Number, res: Vec2i = Vec2i()) = rem(res, this, bX.i, bY.i)

    fun rem(b: Number, res: Vec2i) = rem(res, this, b.i, b.i)
    fun rem(b: Vec2t<out Number>, res: Vec2i) = rem(res, this, b._x.i, b._y.i)

    fun remAssign(bX: Number, bY: Number) = rem(this, this, bX.i, bY.i)
    infix operator fun remAssign(b: Number) {
        rem(this, this, b.i, b.i)
    }

    infix operator fun remAssign(b: Vec2t<out Number>) {
        rem(this, this, b._x.i, b._y.i)
    }


    // -- Specific bitwise operators --

    infix fun and(b: Int) = and(Vec2i(), this, b, b)
    infix fun and(b: Vec2i) = and(Vec2i(), this, b.x, b.y)

    fun and(b: Int, res: Vec2i) = and(res, this, b, b)
    fun and(b: Vec2i, res: Vec2i) = and(res, this, b.x, b.y)
    @JvmOverloads
    fun and(bX: Int, bY: Int, res: Vec2i = Vec2i()) = and(res, this, bX, bY)

    infix fun andAssign(b: Int) = and(this, this, b, b)
    infix fun andAssign(b: Vec2i) = and(this, this, b.x, b.y)
    fun andAssign(bX: Int, bY: Int) = and(this, this, bX, bY)


    infix fun or(b: Int) = or(Vec2i(), this, b, b)
    infix fun or(b: Vec2i) = or(Vec2i(), this, b.x, b.y)

    fun or(b: Int, res: Vec2i) = or(res, this, b, b)
    fun or(b: Vec2i, res: Vec2i) = or(res, this, b.x, b.y)
    @JvmOverloads
    fun or(bX: Int, bY: Int, res: Vec2i = Vec2i()) = or(res, this, bX, bY)

    infix fun orAssign(b: Int) = or(this, this, b, b)
    infix fun orAssign(b: Vec2i) = or(this, this, b.x, b.y)
    fun orAssign(bX: Int, bY: Int) = or(this, this, bX, bY)


    infix fun xor(b: Int) = xor(Vec2i(), this, b, b)
    infix fun xor(b: Vec2i) = xor(Vec2i(), this, b.x, b.y)

    fun xor(b: Int, res: Vec2i) = xor(res, this, b, b)
    fun xor(b: Vec2i, res: Vec2i) = xor(res, this, b.x, b.y)
    @JvmOverloads
    fun xor(bX: Int, bY: Int, res: Vec2i = Vec2i()) = xor(res, this, bX, bY)

    infix fun xorAssign(b: Int) = xor(this, this, b, b)
    infix fun xorAssign(b: Vec2i) = xor(this, this, b.x, b.y)
    fun xorAssign(bX: Int, bY: Int) = xor(this, this, bX, bY)


    infix fun shl(b: Int) = shl(Vec2i(), this, b, b)
    infix fun shl(b: Vec2i) = shl(Vec2i(), this, b.x, b.y)

    fun shl(b: Int, res: Vec2i) = shl(res, this, b, b)
    fun shl(b: Vec2i, res: Vec2i) = shl(res, this, b.x, b.y)
    @JvmOverloads
    fun shl(bX: Int, bY: Int, res: Vec2i = Vec2i()) = shl(res, this, bX, bY)

    infix fun shlAssign(b: Int) = shl(this, this, b, b)
    infix fun shlAssign(b: Vec2i) = shl(this, this, b.x, b.y)
    fun shlAssign(bX: Int, bY: Int) = shl(this, this, bX, bY)


    infix fun shr(b: Int) = shr(Vec2i(), this, b, b)
    infix fun shr(b: Vec2i) = shr(Vec2i(), this, b.x, b.y)

    fun shr(b: Int, res: Vec2i) = shr(res, this, b, b)
    fun shr(b: Vec2i, res: Vec2i) = shr(res, this, b.x, b.y)
    @JvmOverloads
    fun shr(bX: Int, bY: Int, res: Vec2i = Vec2i()) = shr(res, this, bX, bY)

    infix fun shrAssign(b: Int) = shr(this, this, b, b)
    infix fun shrAssign(b: Vec2i) = shr(this, this, b.x, b.y)
    fun shrAssign(bX: Int, bY: Int) = shr(this, this, bX, bY)


    // TODO fill & others
    infix fun ushr(b: Int) = ushr(Vec2i(), this, b, b)


    @JvmOverloads
    fun inv(res: Vec2i = Vec2i()) = inv(res, this)

    fun invAssign() = inv(this, this)


    // -- Generic bitwise operators --

    infix fun and(b: Number) = and(Vec2i(), this, b.i, b.i)
    infix fun and(b: Vec2t<out Number>) = and(Vec2i(), this, b._x.i, b._y.i)

    fun and(b: Number, res: Vec2i) = and(res, this, b.i, b.i)
    fun and(b: Vec2t<out Number>, res: Vec2i) = and(res, this, b._x.i, b._y.i)

    @JvmOverloads
    fun and(bX: Number, bY: Number, res: Vec2i = Vec2i()) = and(res, this, bX.i, bY.i)

    infix fun andAssign(b: Number) = and(this, this, b.i, b.i)
    infix fun andAssign(b: Vec2t<out Number>) = and(this, this, b._x.i, b._y.i)
    fun andAssign(bX: Number, bY: Number) = and(this, this, bX.i, bY.i)


    infix fun or(b: Number) = or(Vec2i(), this, b.i, b.i)
    infix fun or(b: Vec2t<out Number>) = or(Vec2i(), this, b._x.i, b._y.i)

    fun or(b: Number, res: Vec2i) = or(res, this, b.i, b.i)
    fun or(b: Vec2t<out Number>, res: Vec2i) = or(res, this, b._x.i, b._y.i)

    @JvmOverloads
    fun or(bX: Number, bY: Number, res: Vec2i = Vec2i()) = or(res, this, bX.i, bY.i)

    infix fun orAssign(b: Number) = or(this, this, b.i, b.i)
    infix fun orAssign(b: Vec2t<out Number>) = or(this, this, b._x.i, b._y.i)
    fun orAssign(bX: Number, bY: Number) = or(this, this, bX.i, bY.i)


    infix fun xor(b: Number) = xor(Vec2i(), this, b.i, b.i)
    infix fun xor(b: Vec2t<out Number>) = xor(Vec2i(), this, b._x.i, b._y.i)

    fun xor(b: Number, res: Vec2i) = xor(res, this, b.i, b.i)
    fun xor(b: Vec2t<out Number>, res: Vec2i) = xor(res, this, b._x.i, b._y.i)

    @JvmOverloads
    fun xor(bX: Number, bY: Number, res: Vec2i = Vec2i()) = xor(res, this, bX.i, bY.i)

    infix fun xorAssign(b: Number) = xor(this, this, b.i, b.i)
    infix fun xorAssign(b: Vec2t<out Number>) = xor(this, this, b._x.i, b._y.i)
    fun xorAssign(bX: Number, bY: Number) = xor(this, this, bX.i, bY.i)


    infix fun shl(b: Number) = shl(Vec2i(), this, b.i, b.i)
    infix fun shl(b: Vec2t<out Number>) = shl(Vec2i(), this, b._x.i, b._y.i)

    fun shl(b: Number, res: Vec2i) = shl(res, this, b.i, b.i)
    fun shl(b: Vec2t<out Number>, res: Vec2i) = shl(res, this, b._x.i, b._y.i)

    @JvmOverloads
    fun shl(bX: Number, bY: Number, res: Vec2i = Vec2i()) = shl(res, this, bX.i, bY.i)

    infix fun shlAssign(b: Number) = shl(this, this, b.i, b.i)
    infix fun shlAssign(b: Vec2t<out Number>) = shl(this, this, b._x.i, b._y.i)
    fun shlAssign(bX: Number, bY: Number) = shl(this, this, bX.i, bY.i)


    infix fun shr(b: Number) = shr(Vec2i(), this, b.i, b.i)
    infix fun shr(b: Vec2t<out Number>) = shr(Vec2i(), this, b._x.i, b._y.i)

    fun shr(b: Number, res: Vec2i) = shr(res, this, b.i, b.i)
    fun shr(b: Vec2t<out Number>, res: Vec2i) = shr(res, this, b._x.i, b._y.i)

    @JvmOverloads
    fun shr(bX: Number, bY: Number, res: Vec2i = Vec2i()) = shr(res, this, bX.i, bY.i)

    infix fun shrAssign(b: Number) = shr(this, this, b.i, b.i)
    infix fun shrAssign(b: Vec2t<out Number>) = shr(this, this, b._x.i, b._y.i)
    fun shrAssign(bX: Number, bY: Number) = shr(this, this, bX.i, bY.i)


    infix fun allLessThan(i: Int): Boolean = x < i && y < i
    infix fun anyLessThan(i: Int): Boolean = x < i || y < i
    infix fun lessThan(i: Int): Vec2bool = Vec2bool { get(it) < i }

    infix fun allLessThanEqual(i: Int): Boolean = x <= i && y <= i
    infix fun anyLessThanEqual(i: Int): Boolean = x <= i || y <= i
    infix fun lessThanEqual(i: Int): Vec2bool = Vec2bool { get(it) <= i }

    infix fun allEqual(i: Int): Boolean = x == i && y == i
    infix fun anyEqual(i: Int): Boolean = x == i || y == i
    infix fun equal(i: Int): Vec2bool = Vec2bool { get(it) == i }

    infix fun allNotEqual(i: Int): Boolean = x != i && y != i
    infix fun anyNotEqual(i: Int): Boolean = x != i || y != i
    infix fun notEqual(i: Int): Vec2bool = Vec2bool { get(it) != i }

    infix fun allGreaterThan(i: Int): Boolean = x > i && y > i
    infix fun anyGreaterThan(i: Int): Boolean = x > i || y > i
    infix fun greaterThan(i: Int): Vec2bool = Vec2bool { get(it) > i }

    infix fun allGreaterThanEqual(i: Int): Boolean = x >= i && y >= i
    infix fun anyGreaterThanEqual(i: Int): Boolean = x >= i || y >= i
    infix fun greaterThanEqual(i: Int): Vec2bool = Vec2bool { get(it) >= i }


    infix fun allLessThan(v: Vec2i): Boolean = x < v.x && y < v.y
    infix fun anyLessThan(v: Vec2i): Boolean = x < v.x || y < v.y
    infix fun lessThan(v: Vec2i): Vec2bool = Vec2bool { get(it) < v[it] }

    infix fun allLessThanEqual(v: Vec2i): Boolean = x <= v.x && y <= v.y
    infix fun anyLessThanEqual(v: Vec2i): Boolean = x <= v.x || y <= v.y
    infix fun lessThanEqual(v: Vec2i): Vec2bool = Vec2bool { get(it) <= v[it] }

    infix fun allEqual(v: Vec2i): Boolean = x == v.x && y == v.y
    infix fun anyEqual(v: Vec2i): Boolean = x == v.x || y == v.y
    infix fun equal(v: Vec2i): Vec2bool = Vec2bool { get(it) == v[it] }

    infix fun allNotEqual(v: Vec2i): Boolean = x != v.x && y != v.y
    infix fun anyNotEqual(v: Vec2i): Boolean = x != v.x || y != v.y
    infix fun notEqual(v: Vec2i): Vec2bool = Vec2bool { get(it) != v[it] }

    infix fun allGreaterThan(v: Vec2i): Boolean = x > v.x && y > v.y
    infix fun anyGreaterThan(v: Vec2i): Boolean = x > v.x || y > v.y
    infix fun greaterThan(v: Vec2i): Vec2bool = Vec2bool { get(it) > v[it] }

    infix fun allGreaterThanEqual(v: Vec2i): Boolean = x >= v.x && y >= v.y
    infix fun anyGreaterThanEqual(v: Vec2i): Boolean = x >= v.x || y >= v.y
    infix fun greaterThanEqual(v: Vec2i): Vec2bool = Vec2bool { get(it) >= v[it] }

//    operator fun compareTo(b: Vec2i): Int = when { TODO evaluate
//        x < b.x && y < b.y -> -1
//        x > b.x && y > b.y -> +1
//        else -> 0
//    }


    infix fun clamp(int: Int) {
        if (x < int) x = int
        if (y < int) y = int
    }

    /** for perspective matrix for example */
    val aspect: Float
        get() = x.f / y


    companion object : opVec2i {
        const val length = Vec2t.LENGTH

        @JvmField
        val size = length * Int.BYTES

        @JvmStatic
        fun fromPointer(ptr: Ptr<Int>) = Vec2i(ptr)
    }

    override fun size() = size

    override fun equals(other: Any?) = other is Vec2i && this[0] == other[0] && this[1] == other[1]
    fun equal(b: Vec2i, epsilon: Int = 0): Boolean = abs(x - b.x) <= epsilon && abs(y - b.y) <= epsilon
    fun notEqual(b: Vec2i, epsilon: Int = 0): Boolean = !equal(b, epsilon)

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

    inline operator fun set(index: Int, value: Int) {
        array[ofs + index] = value
    }

    override inline fun component1() = x
    override inline fun component2() = y


    override fun toString(): String = "($x, $y)"
}
