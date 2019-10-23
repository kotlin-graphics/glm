package glm_.vec2

import glm_.*
import glm_.vec1.Vec1bool
import glm_.vec1.Vec1t
import glm_.vec2.operators.opVec2us
import glm_.vec3.Vec3bool
import glm_.vec3.Vec3t
import glm_.vec4.Vec4bool
import glm_.vec4.Vec4t
import kool.Ptr
import kool.pos
import kool.ShortBuffer
import kool.set
import org.lwjgl.system.MemoryStack
import org.lwjgl.system.MemoryUtil.memGetShort
import org.lwjgl.system.MemoryUtil.memPutShort
import unsigned.Ushort
import java.io.PrintStream
import java.nio.*
import kotlin.math.abs

/**
 * Created by elect on 08/10/16.
 */

class Vec2us(var ofs: Int, var array: ShortArray) : Vec2t<Ushort>(), ToBuffer {

    override var x: Ushort
        get() = Ushort(array[ofs])
        set(value) = array.set(ofs, value.v)
    override var y: Ushort
        get() = Ushort(array[ofs + 1])
        set(value) = array.set(ofs + 1, value.v)

    inline var vX: Short
        get() = array[ofs]
        set(value) = array.set(ofs, value)
    inline var vY: Short
        get() = array[ofs + 1]
        set(value) = array.set(ofs + 1, value)

    // -- Implicit basic constructors --

    constructor() : this(0)
    constructor(v: Vec2us) : this(v.x, v.y)

    // -- Explicit basic constructors --

    @JvmOverloads
    constructor(x: Short, y: Short = x) : this(x.us, y.us)
    @JvmOverloads
    constructor(x: Ushort, y: Ushort = x) : this(0, shortArrayOf(x.v, y.v))

    // -- Conversion constructors --

    @JvmOverloads
    constructor(x: Number, y: Number = x) : this(x.us, y.us)

    // Explicit conversions (From section 5.4.1 Conversion and scalar constructors of GLSL 1.30.08 specification)

    constructor(x: Number, v: Vec1t<out Number>) : this(x, v.x)
    @JvmOverloads
    constructor(v: Vec1t<out Number>, y: Number = v.x) : this(v.x, y)
    constructor(x: Vec1t<out Number>, y: Vec1t<out Number>) : this(x.x, y.x)

    constructor(v: Vec2t<out Number>) : this(v.x, v.y)
    constructor(v: Vec3t<out Number>) : this(v.x, v.y)
    constructor(v: Vec4t<out Number>) : this(v.x, v.y)

    @JvmOverloads
    constructor(x: Boolean, y: Boolean = x) : this(x.us, y.us)
    constructor(x: Boolean, v: Vec1bool) : this(x.us, v.x.us)
    @JvmOverloads
    constructor(v: Vec1bool, y: Boolean = v.x) : this(v.x.us, y.us)
    constructor(x: Vec1bool, y: Vec1bool) : this(x.x.us, y.x.us)

    constructor(v: Vec2bool) : this(v.x.us, v.y.us)
    constructor(v: Vec3bool) : this(v.x.us, v.y.us)
    constructor(v: Vec4bool) : this(v.x.us, v.y.us)

    constructor(bytes: ByteArray, index: Int = 0, oneByteOneUshort: Boolean = false, bigEndian: Boolean = true) : this(
            if (oneByteOneUshort) bytes[index].us else bytes.getUshort(index, bigEndian),
            if (oneByteOneUshort) bytes[index + 1].us else bytes.getUshort(index + Ushort.BYTES, bigEndian))

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

    constructor(list: Iterable<*>, index: Int = 0) : this(list.elementAt(index)!!.toShort, list.elementAt(index + 1)!!.toShort)

    constructor(bytes: ByteBuffer, index: Int = bytes.pos, oneByteOneUshort: Boolean = false) : this(
            if (oneByteOneUshort) bytes[index].us else bytes.getShort(index).us,
            if (oneByteOneUshort) bytes[index + 1].us else bytes.getShort(index + Ushort.BYTES).us)

    constructor(chars: CharBuffer, index: Int = chars.pos) : this(chars[index].us, chars[index + 1].us)
    constructor(shorts: ShortBuffer, index: Int = shorts.pos) : this(shorts[index], shorts[index + 1])
    constructor(ints: IntBuffer, index: Int = ints.pos) : this(ints[index], ints[index + 1])
    constructor(longs: LongBuffer, index: Int = longs.pos) : this(longs[index], longs[index + 1])
    constructor(floats: FloatBuffer, index: Int = floats.pos) : this(floats[index], floats[index + 1])
    constructor(doubles: DoubleBuffer, index: Int = doubles.pos) : this(doubles[index], doubles[index + 1])

    constructor(block: (Int) -> Ushort) : this(block(0), block(1))


    fun set(bytes: ByteArray, index: Int = 0, oneByteOneShort: Boolean = false, bigEndian: Boolean = true) {
        x.v = if (oneByteOneShort) bytes[index].s else bytes.getShort(index, bigEndian)
        y.v = if (oneByteOneShort) bytes[index + 1].s else bytes.getShort(index + Ushort.BYTES, bigEndian)
    }

    fun set(bytes: ByteBuffer, index: Int = bytes.pos, oneByteOneShort: Boolean = false) {
        x.v = if (oneByteOneShort) bytes[index].s else bytes.getShort(index)
        y.v = if (oneByteOneShort) bytes[index + 1].s else bytes.getShort(index + Ushort.BYTES)
    }


    fun put(x: Ushort, y: Ushort) {
        this.x = x
        this.y = y
    }

    operator fun invoke(x: Ushort, y: Ushort): Vec2us {
        this.x = x
        this.y = y
        return this
    }

    fun put(x: Short, y: Short) {
        this.x.v = x
        this.y.v = y
    }

    operator fun invoke(x: Short, y: Short): Vec2us {
        this.x.v = x
        this.y.v = y
        return this
    }

    override fun put(x: Number, y: Number) {
        this.x = x.us
        this.y = y.us
    }

    override operator fun invoke(x: Number, y: Number): Vec2us {
        this.x = x.us
        this.y = y.us
        return this
    }

    fun to(bytes: ByteArray, index: Int) = to(bytes, index, true)
    override fun to(bytes: ByteArray, index: Int, bigEndian: Boolean): ByteArray {
        bytes.putShort(index, x.v)
        bytes.putShort(index + Short.BYTES, y.v)
        return bytes
    }

    fun toShortArray(): ShortArray = to(ShortArray(length), 0)
    infix fun to(shorts: ShortArray): ShortArray = to(shorts, 0)
    fun to(shorts: ShortArray, index: Int): ShortArray {
        System.arraycopy(array, ofs, shorts, index, length)
        return shorts
    }

    override fun to(buf: ByteBuffer, offset: Int): ByteBuffer {
        buf.putShort(offset, x.v)
        buf.putShort(offset + Short.BYTES, y.v)
        return buf
    }

    fun toShortBufferStack(): ShortBuffer = to(MemoryStack.stackPush().mallocShort(length), 0)
    infix fun toShortBuffer(stack: MemoryStack): ShortBuffer = to(stack.mallocShort(length), 0)
    fun toShortBuffer(): ShortBuffer = to(ShortBuffer(length), 0)
    infix fun to(buf: ShortBuffer): ShortBuffer = to(buf, buf.pos)
    fun to(buf: ShortBuffer, index: Int): ShortBuffer {
        buf[index] = x.v
        buf[index + 1] = y.v
        return buf
    }

    infix fun to(ptr: Ptr) {
        memPutShort(ptr, x.v)
        memPutShort(ptr + Short.BYTES, y.v)
    }

    // -- Component accesses --

    operator fun set(index: Int, value: Ushort) = when (index) {
        0 -> x = value
        1 -> y = value
        else -> throw ArrayIndexOutOfBoundsException()
    }

    override operator fun set(index: Int, value: Number) = when (index) {
        0 -> x = value.us
        1 -> y = value.us
        else -> throw ArrayIndexOutOfBoundsException()
    }

    // -- Unary arithmetic operators --

    operator fun unaryPlus() = this

    // no unaryMinus operator, only signed

    // -- Increment main.and decrement operators --

    operator fun inc(res: Vec2us = Vec2us()) = plus(res, this, 1, 1)
    fun incAssign() = plus(this, this, 1, 1)


    operator fun dec(res: Vec2us = Vec2us()) = minus(res, this, 1, 1)
    fun decAssign() = minus(this, this, 1, 1)


    // -- Specific binary arithmetic operators --

    operator fun plus(b: Ushort) = plus(Vec2us(), this, b, b)
    operator fun plus(b: Short) = plus(Vec2us(), this, b, b)
    operator fun plus(b: Int) = plus(Vec2us(), this, b, b)
    operator fun plus(b: Vec2us) = plus(Vec2us(), this, b.x, b.y)

    fun plus(bX: Ushort, bY: Ushort, res: Vec2us = Vec2us()) = plus(res, this, bX, bY)
    fun plus(bX: Short, bY: Short, res: Vec2us = Vec2us()) = plus(res, this, bX, bY)
    fun plus(bX: Int, bY: Int, res: Vec2us = Vec2us()) = plus(res, this, bX, bY)
    fun plus(b: Ushort, res: Vec2us = Vec2us()) = plus(res, this, b, b)
    fun plus(b: Short, res: Vec2us = Vec2us()) = plus(res, this, b, b)
    fun plus(b: Int, res: Vec2us = Vec2us()) = plus(res, this, b, b)
    fun plus(b: Vec2us, res: Vec2us = Vec2us()) = plus(res, this, b.x, b.y)

    fun plusAssign(bX: Ushort, bY: Ushort) = plus(this, this, bX, bY)
    fun plusAssign(bX: Short, bY: Short) = plus(this, this, bX, bY)
    fun plusAssign(bX: Int, bY: Int) = plus(this, this, bX, bY)
    infix operator fun plusAssign(b: Ushort) {
        plus(this, this, b, b)
    }

    infix operator fun plusAssign(b: Short) {
        plus(this, this, b, b)
    }

    infix operator fun plusAssign(b: Int) {
        plus(this, this, b, b)
    }

    infix operator fun plusAssign(b: Vec2us) {
        plus(this, this, b.x, b.y)
    }


    operator fun minus(b: Ushort) = minus(Vec2us(), this, b, b)
    operator fun minus(b: Short) = minus(Vec2us(), this, b, b)
    operator fun minus(b: Int) = minus(Vec2us(), this, b, b)
    operator fun minus(b: Vec2us) = minus(Vec2us(), this, b.x, b.y)

    fun minus(bX: Ushort, bY: Ushort, res: Vec2us = Vec2us()) = minus(res, this, bX, bY)
    fun minus(bX: Short, bY: Short, res: Vec2us = Vec2us()) = minus(res, this, bX, bY)
    fun minus(bX: Int, bY: Int, res: Vec2us = Vec2us()) = minus(res, this, bX, bY)
    fun minus(b: Ushort, res: Vec2us = Vec2us()) = minus(res, this, b, b)
    fun minus(b: Short, res: Vec2us = Vec2us()) = minus(res, this, b, b)
    fun minus(b: Int, res: Vec2us = Vec2us()) = minus(res, this, b, b)
    fun minus(b: Vec2us, res: Vec2us = Vec2us()) = minus(res, this, b.x, b.y)

    fun minusAssign(bX: Ushort, bY: Ushort) = minus(this, this, bX, bY)
    fun minusAssign(bX: Short, bY: Short) = minus(this, this, bX, bY)
    fun minusAssign(bX: Int, bY: Int) = minus(this, this, bX, bY)
    infix operator fun minusAssign(b: Ushort) {
        minus(this, this, b, b)
    }

    infix operator fun minusAssign(b: Short) {
        minus(this, this, b, b)
    }

    infix operator fun minusAssign(b: Int) {
        minus(this, this, b, b)
    }

    infix operator fun minusAssign(b: Vec2us) {
        minus(this, this, b.x, b.y)
    }


    operator fun times(b: Ushort) = times(Vec2us(), this, b, b)
    operator fun times(b: Short) = times(Vec2us(), this, b, b)
    operator fun times(b: Int) = times(Vec2us(), this, b, b)
    operator fun times(b: Vec2us) = times(Vec2us(), this, b.x, b.y)

    fun times(bX: Ushort, bY: Ushort, res: Vec2us = Vec2us()) = times(res, this, bX, bY)
    fun times(bX: Short, bY: Short, res: Vec2us = Vec2us()) = times(res, this, bX, bY)
    fun times(bX: Int, bY: Int, res: Vec2us = Vec2us()) = times(res, this, bX, bY)
    fun times(b: Ushort, res: Vec2us = Vec2us()) = times(res, this, b, b)
    fun times(b: Short, res: Vec2us = Vec2us()) = times(res, this, b, b)
    fun times(b: Int, res: Vec2us = Vec2us()) = times(res, this, b, b)
    fun times(b: Vec2us, res: Vec2us = Vec2us()) = times(res, this, b.x, b.y)

    fun timesAssign(bX: Ushort, bY: Ushort) = times(this, this, bX, bY)
    fun timesAssign(bX: Short, bY: Short) = times(this, this, bX, bY)
    fun timesAssign(bX: Int, bY: Int) = times(this, this, bX, bY)
    infix operator fun timesAssign(b: Ushort) {
        times(this, this, b, b)
    }

    infix operator fun timesAssign(b: Short) {
        times(this, this, b, b)
    }

    infix operator fun timesAssign(b: Int) {
        times(this, this, b, b)
    }

    infix operator fun timesAssign(b: Vec2us) {
        times(this, this, b.x, b.y)
    }


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

    fun divAssign(bX: Ushort, bY: Ushort) = div(this, this, bX, bY)
    fun divAssign(bX: Short, bY: Short) = div(this, this, bX, bY)
    fun divAssign(bX: Int, bY: Int) = div(this, this, bX, bY)
    infix operator fun divAssign(b: Ushort) {
        div(this, this, b, b)
    }

    infix operator fun divAssign(b: Short) {
        div(this, this, b, b)
    }

    infix operator fun divAssign(b: Int) {
        div(this, this, b, b)
    }

    infix operator fun divAssign(b: Vec2us) {
        div(this, this, b.x, b.y)
    }


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

    fun remAssign(bX: Ushort, bY: Ushort) = rem(this, this, bX, bY)
    fun remAssign(bX: Short, bY: Short) = rem(this, this, bX, bY)
    fun remAssign(bX: Int, bY: Int) = rem(this, this, bX, bY)
    infix operator fun remAssign(b: Ushort) {
        rem(this, this, b, b)
    }

    infix operator fun remAssign(b: Short) {
        rem(this, this, b, b)
    }

    infix operator fun remAssign(b: Int) {
        rem(this, this, b, b)
    }

    infix operator fun remAssign(b: Vec2us) {
        rem(this, this, b.x, b.y)
    }


    // -- Generic binary arithmetic operators --

    operator fun plus(b: Number) = plus(Vec2us(), this, b.i, b.i)
    operator fun plus(b: Vec2t<out Number>) = plus(Vec2us(), this, b.x.i, b.y.i)

    fun plus(bX: Number, bY: Number, res: Vec2us = Vec2us()) = plus(res, this, bX.i, bY.i)
    fun plus(b: Number, res: Vec2us = Vec2us()) = plus(res, this, b.i, b.i)
    fun plus(b: Vec2t<out Number>, res: Vec2us = Vec2us()) = plus(res, this, b.x.i, b.y.i)

    fun plusAssign(bX: Number, bY: Number) = plus(this, this, bX.i, bY.i)
    infix operator fun plusAssign(b: Number) {
        plus(this, this, b.i, b.i)
    }

    infix operator fun plusAssign(b: Vec2t<out Number>) {
        plus(this, this, b.x.i, b.y.i)
    }


    operator fun minus(b: Number) = minus(Vec2us(), this, b.i, b.i)
    operator fun minus(b: Vec2t<out Number>) = minus(Vec2us(), this, b.x.i, b.y.i)

    fun minus(bX: Number, bY: Number, res: Vec2us = Vec2us()) = minus(res, this, bX.i, bY.i)
    fun minus(b: Number, res: Vec2us = Vec2us()) = minus(res, this, b.i, b.i)
    fun minus(b: Vec2t<out Number>, res: Vec2us = Vec2us()) = minus(res, this, b.x.i, b.y.i)

    fun minusAssign(bX: Number, bY: Number) = minus(this, this, bX.i, bY.i)
    infix operator fun minusAssign(b: Number) {
        minus(this, this, b.i, b.i)
    }

    infix operator fun minusAssign(b: Vec2t<out Number>) {
        minus(this, this, b.x.i, b.y.i)
    }


    operator fun times(b: Number) = times(Vec2us(), this, b.i, b.i)
    operator fun times(b: Vec2t<out Number>) = times(Vec2us(), this, b.x.i, b.y.i)

    fun times(bX: Number, bY: Number, res: Vec2us = Vec2us()) = times(res, this, bX.i, bY.i)
    fun times(b: Number, res: Vec2us = Vec2us()) = times(res, this, b.i, b.i)
    fun times(b: Vec2t<out Number>, res: Vec2us = Vec2us()) = times(res, this, b.x.i, b.y.i)

    fun timesAssign(bX: Number, bY: Number) = times(this, this, bX.i, bY.i)
    infix operator fun timesAssign(b: Number) {
        times(this, this, b.i, b.i)
    }

    infix operator fun timesAssign(b: Vec2t<out Number>) {
        times(this, this, b.x.i, b.y.i)
    }


    operator fun div(b: Number) = div(Vec2us(), this, b.i, b.i)
    operator fun div(b: Vec2t<out Number>) = div(Vec2us(), this, b.x.i, b.y.i)

    fun div(bX: Number, bY: Number, res: Vec2us = Vec2us()) = div(res, this, bX.i, bY.i)
    fun div(b: Number, res: Vec2us = Vec2us()) = div(res, this, b.i, b.i)
    fun div(b: Vec2t<out Number>, res: Vec2us = Vec2us()) = div(res, this, b.x.i, b.y.i)

    fun divAssign(bX: Number, bY: Number) = div(this, this, bX.i, bY.i)
    infix operator fun divAssign(b: Number) {
        div(this, this, b.i, b.i)
    }

    infix operator fun divAssign(b: Vec2t<out Number>) {
        div(this, this, b.x.i, b.y.i)
    }


    operator fun rem(b: Number) = rem(Vec2us(), this, b.i, b.i)
    operator fun rem(b: Vec2t<out Number>) = rem(Vec2us(), this, b.x.i, b.y.i)

    fun rem(bX: Number, bY: Number, res: Vec2us = Vec2us()) = rem(res, this, bX.i, bY.i)
    fun rem(b: Number, res: Vec2us = Vec2us()) = rem(res, this, b.i, b.i)
    fun rem(b: Vec2t<out Number>, res: Vec2us = Vec2us()) = rem(res, this, b.x.i, b.y.i)

    fun remAssign(bX: Number, bY: Number) = rem(this, this, bX.i, bY.i)
    infix operator fun remAssign(b: Number) {
        rem(this, this, b.i, b.i)
    }

    infix operator fun remAssign(b: Vec2t<out Number>) {
        rem(this, this, b.x.i, b.y.i)
    }


    // -- Specific bitwise operators --

    infix fun and(b: Ushort) = and(Vec2us(), this, b, b)
    infix fun and(b: Short) = and(Vec2us(), this, b, b)
    infix fun and(b: Int) = and(Vec2us(), this, b, b)
    fun and(bX: Ushort, bY: Ushort) = and(Vec2us(), this, bX, bY)
    fun and(bX: Short, bY: Short) = and(Vec2us(), this, bX, bY)
    fun and(bX: Int, bY: Int) = and(Vec2us(), this, bX, bY)
    fun and(b: Vec2us) = and(Vec2us(), this, b.x, b.y)

    infix fun andAssign(b: Ushort) = and(this, this, b, b)
    infix fun andAssign(b: Short) = and(this, this, b, b)
    infix fun andAssign(b: Int) = and(this, this, b, b)
    fun andAssign(bX: Ushort, bY: Ushort) = and(this, this, bX, bY)
    fun andAssign(bX: Short, bY: Short) = and(this, this, bX, bY)
    fun andAssign(bX: Int, bY: Int) = and(this, this, bX, bY)
    infix fun andAssign(b: Vec2us) = and(this, this, b.x, b.y)

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

    infix fun orAssign(b: Ushort) = or(this, this, b, b)
    infix fun orAssign(b: Short) = or(this, this, b, b)
    infix fun orAssign(b: Int) = or(this, this, b, b)
    fun orAssign(bX: Ushort, bY: Ushort) = or(this, this, bX, bY)
    fun orAssign(bX: Short, bY: Short) = or(this, this, bX, bY)
    fun orAssign(bX: Int, bY: Int) = or(this, this, bX, bY)
    infix fun orAssign(b: Vec2us) = or(this, this, b.x, b.y)

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

    infix fun xorAssign(b: Ushort) = xor(this, this, b, b)
    infix fun xorAssign(b: Short) = xor(this, this, b, b)
    infix fun xorAssign(b: Int) = xor(this, this, b, b)
    fun xorAssign(bX: Ushort, bY: Ushort) = xor(this, this, bX, bY)
    fun xorAssign(bX: Short, bY: Short) = xor(this, this, bX, bY)
    fun xorAssign(bX: Int, bY: Int) = xor(this, this, bX, bY)
    infix fun xorAssign(b: Vec2us) = xor(this, this, b.x, b.y)

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

    infix fun shlAssign(b: Ushort) = shl(this, this, b, b)
    infix fun shlAssign(b: Short) = shl(this, this, b, b)
    infix fun shlAssign(b: Int) = shl(this, this, b, b)
    fun shlAssign(bX: Ushort, bY: Ushort) = shl(this, this, bX, bY)
    fun shlAssign(bX: Short, bY: Short) = shl(this, this, bX, bY)
    fun shlAssign(bX: Int, bY: Int) = shl(this, this, bX, bY)
    infix fun shlAssign(b: Vec2us) = shl(this, this, b.x, b.y)

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

    infix fun shrAssign(b: Ushort) = shr(this, this, b, b)
    infix fun shrAssign(b: Short) = shr(this, this, b, b)
    infix fun shrAssign(b: Int) = shr(this, this, b, b)
    fun shrAssign(bX: Ushort, bY: Ushort) = shr(this, this, bX, bY)
    fun shrAssign(bX: Short, bY: Short) = shr(this, this, bX, bY)
    fun shrAssign(bX: Int, bY: Int) = shr(this, this, bX, bY)
    infix fun shrAssign(b: Vec2us) = shr(this, this, b.x, b.y)

    fun shr(b: Ushort, res: Vec2us) = shr(res, this, b, b)
    fun shr(b: Short, res: Vec2us) = shr(res, this, b, b)
    fun shr(b: Int, res: Vec2us) = shr(res, this, b, b)
    fun shr(bX: Ushort, bY: Ushort, res: Vec2us) = shr(res, this, bX, bY)
    fun shr(bX: Short, bY: Short, res: Vec2us) = shr(res, this, bX, bY)
    fun shr(bX: Int, bY: Int, res: Vec2us) = shr(res, this, bX, bY)
    fun shr(b: Vec2us, res: Vec2us) = shr(res, this, b.x, b.y)


    fun inv(res: Vec2us = Vec2us()) = inv(res, this)
    fun invAssign() = inv(this, this)


    // -- Generic bitwise operators --

    infix fun and(b: Number) = and(Vec2us(), this, b.i, b.i)
    fun and(bX: Number, bY: Number) = and(Vec2us(), this, bX.i, bY.i)
    fun and(b: Vec2t<out Number>) = and(Vec2us(), this, b.x.i, b.y.i)

    infix fun andAssign(b: Number) = and(this, this, b.i, b.i)
    fun andAssign(bX: Number, bY: Number) = and(this, this, bX.i, bY.i)
    infix fun andAssign(b: Vec2t<out Number>) = and(this, this, b.x.i, b.y.i)

    fun and(b: Number, res: Vec2us) = and(res, this, b.i, b.i)
    fun and(bX: Number, bY: Number, res: Vec2us) = and(res, this, bX.i, bY.i)
    fun and(b: Vec2t<out Number>, res: Vec2us) = and(res, this, b.x.i, b.y.i)


    infix fun or(b: Number) = or(Vec2us(), this, b.i, b.i)
    fun or(bX: Number, bY: Number) = or(Vec2us(), this, bX.i, bY.i)
    fun or(b: Vec2t<out Number>) = or(Vec2us(), this, b.x.i, b.y.i)

    infix fun orAssign(b: Number) = or(this, this, b.i, b.i)
    fun orAssign(bX: Number, bY: Number) = or(this, this, bX.i, bY.i)
    infix fun orAssign(b: Vec2t<out Number>) = or(this, this, b.x.i, b.y.i)

    fun or(b: Number, res: Vec2us) = or(res, this, b.i, b.i)
    fun or(bX: Number, bY: Number, res: Vec2us) = or(res, this, bX.i, bY.i)
    fun or(b: Vec2t<out Number>, res: Vec2us) = or(res, this, b.x.i, b.y.i)


    infix fun xor(b: Number) = xor(Vec2us(), this, b.i, b.i)
    fun xor(bX: Number, bY: Number) = xor(Vec2us(), this, bX.i, bY.i)
    fun xor(b: Vec2t<out Number>) = xor(Vec2us(), this, b.x.i, b.y.i)

    infix fun xorAssign(b: Number) = xor(this, this, b.i, b.i)
    fun xorAssign(bX: Number, bY: Number) = xor(this, this, bX.i, bY.i)
    infix fun xorAssign(b: Vec2t<out Number>) = xor(this, this, b.x.i, b.y.i)

    fun xor(b: Number, res: Vec2us) = xor(res, this, b.i, b.i)
    fun xor(bX: Number, bY: Number, res: Vec2us) = xor(res, this, bX.i, bY.i)
    fun xor(b: Vec2t<out Number>, res: Vec2us) = xor(res, this, b.x.i, b.y.i)


    infix fun shl(b: Number) = shl(Vec2us(), this, b.i, b.i)
    fun shl(bX: Number, bY: Number) = shl(Vec2us(), this, bX.i, bY.i)
    fun shl(b: Vec2t<out Number>) = shl(Vec2us(), this, b.x.i, b.y.i)

    infix fun shlAssign(b: Number) = shl(this, this, b.i, b.i)
    fun shlAssign(bX: Number, bY: Number) = shl(this, this, bX.i, bY.i)
    infix fun shlAssign(b: Vec2t<out Number>) = shl(this, this, b.x.i, b.y.i)

    fun shl(b: Number, res: Vec2us) = shl(res, this, b.i, b.i)
    fun shl(bX: Number, bY: Number, res: Vec2us) = shl(res, this, bX.i, bY.i)
    fun shl(b: Vec2t<out Number>, res: Vec2us) = shl(res, this, b.x.i, b.y.i)


    infix fun shr(b: Number) = shr(Vec2us(), this, b.i, b.i)
    fun shr(bX: Number, bY: Number) = shr(Vec2us(), this, bX.i, bY.i)
    fun shr(b: Vec2t<out Number>) = shr(Vec2us(), this, b.x.i, b.y.i)

    infix fun shrAssign(b: Number) = shr(this, this, b.i, b.i)
    fun shrAssign(bX: Number, bY: Number) = shr(this, this, bX.i, bY.i)
    infix fun shrAssign(b: Vec2t<out Number>) = shr(this, this, b.x.i, b.y.i)

    fun shr(b: Number, res: Vec2us) = shr(res, this, b.i, b.i)
    fun shr(bX: Number, bY: Number, res: Vec2us) = shr(res, this, bX.i, bY.i)
    fun shr(b: Vec2t<out Number>, res: Vec2us) = shr(res, this, b.x.i, b.y.i)


    infix fun allLessThan(us: Ushort): Boolean = x < us && y < us
    infix fun anyLessThan(us: Ushort): Boolean = x < us || y < us
    infix fun lessThan(us: Ushort): Vec2bool = Vec2bool { get(it) < us }

    infix fun allLessThanEqual(us: Ushort): Boolean = x <= us && y <= us
    infix fun anyLessThanEqual(us: Ushort): Boolean = x <= us || y <= us
    infix fun lessThanEqual(us: Ushort): Vec2bool = Vec2bool { get(it) <= us }

    infix fun allEqual(us: Ushort): Boolean = x == us && y == us
    infix fun anyEqual(us: Ushort): Boolean = x == us || y == us
    infix fun equal(us: Ushort): Vec2bool = Vec2bool { get(it) == us }

    infix fun allNotEqual(us: Ushort): Boolean = x != us && y != us
    infix fun anyNotEqual(us: Ushort): Boolean = x != us || y != us
    infix fun notEqual(us: Ushort): Vec2bool = Vec2bool { get(it) != us }

    infix fun allGreaterThan(us: Ushort): Boolean = x > us && y > us
    infix fun anyGreaterThan(us: Ushort): Boolean = x > us || y > us
    infix fun greaterThan(us: Ushort): Vec2bool = Vec2bool { get(it) > us }

    infix fun allGreaterThanEqual(us: Ushort): Boolean = x >= us && y >= us
    infix fun anyGreaterThanEqual(us: Ushort): Boolean = x >= us || y >= us
    infix fun greaterThanEqual(us: Ushort): Vec2bool = Vec2bool { get(it) >= us }


    infix fun allLessThan(v: Vec2us): Boolean = x < v.x && y < v.y
    infix fun anyLessThan(v: Vec2us): Boolean = x < v.x || y < v.y
    infix fun lessThan(v: Vec2us): Vec2bool = Vec2bool { get(it) < v[it] }

    infix fun allLessThanEqual(v: Vec2us): Boolean = x <= v.x && y <= v.y
    infix fun anyLessThanEqual(v: Vec2us): Boolean = x <= v.x || y <= v.y
    infix fun lessThanEqual(v: Vec2us): Vec2bool = Vec2bool { get(it) <= v[it] }

    infix fun allEqual(v: Vec2us): Boolean = x == v.x && y == v.y
    infix fun anyEqual(v: Vec2us): Boolean = x == v.x || y == v.y
    infix fun equal(v: Vec2us): Vec2bool = Vec2bool { get(it) == v[it] }

    infix fun allNotEqual(v: Vec2us): Boolean = x != v.x && y != v.y
    infix fun anyNotEqual(v: Vec2us): Boolean = x != v.x || y != v.y
    infix fun notEqual(v: Vec2us): Vec2bool = Vec2bool { get(it) != v[it] }

    infix fun allGreaterThan(v: Vec2us): Boolean = x > v.x && y > v.y
    infix fun anyGreaterThan(v: Vec2us): Boolean = x > v.x || y > v.y
    infix fun greaterThan(v: Vec2us): Vec2bool = Vec2bool { get(it) > v[it] }

    infix fun allGreaterThanEqual(v: Vec2us): Boolean = x >= v.x && y >= v.y
    infix fun anyGreaterThanEqual(v: Vec2us): Boolean = x >= v.x || y >= v.y
    infix fun greaterThanEqual(v: Vec2us): Vec2bool = Vec2bool { get(it) >= v[it] }


    override fun createInstance(x: Ushort, y: Ushort) = Vec2us(x, y)


    companion object : opVec2us {
        const val length = Vec2t.length
        @JvmField
        val size = length * Ushort.BYTES

        @JvmStatic
        fun fromPointer(ptr: Ptr) = Vec2us(memGetShort(ptr), memGetShort(ptr + Short.BYTES))
    }

    override fun size() = size

    override fun equals(other: Any?) = other is Vec2us && this[0] == other[0] && this[1] == other[1]

    override fun hashCode() = 31 * x.v.hashCode() + y.v.hashCode()

    @JvmOverloads
    fun print(name: String = "", stream: PrintStream = System.out) = stream.print("$name$this")

    @JvmOverloads
    fun println(name: String = "", stream: PrintStream = System.out) = stream.println("$name$this")
}