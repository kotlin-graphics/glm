package glm_.vec2

import glm_.*
import glm_.vec2.operators.opVec2l
import glm_.vec3.Vec3bool
import glm_.vec3.Vec3t
import glm_.vec4.Vec4bool
import glm_.vec4.Vec4t
import kool.Ptr
import kool.LongBuffer
import kool.pos
import org.lwjgl.system.MemoryStack
import org.lwjgl.system.MemoryUtil.memGetLong
import org.lwjgl.system.MemoryUtil.memPutLong
import java.io.PrintStream
import java.nio.*

/**
 * Created bY GBarbieri on 06.10.2016.
 */

class Vec2l(var ofs: Int, var array: LongArray) : Vec2t<Long>(), ToBuffer {

    constructor(x: Long, y: Long) : this(0, longArrayOf(x, y))

    override var x: Long
        get() = array[ofs]
        set(value) = array.set(ofs, value)
    override var y: Long
        get() = array[ofs + 1]
        set(value) = array.set(ofs + 1, value)

    // -- Explicit basic, conversion other main.and conversion vector constructors --

    constructor() : this(0)

    constructor(v: Vec2t<out Number>) : this(v.x, v.y)
    constructor(v: Vec3t<out Number>) : this(v.x, v.y)
    constructor(v: Vec4t<out Number>) : this(v.x, v.y)

    constructor(v: Vec2bool) : this(v.x.L, v.y.L)
    constructor(v: Vec3bool) : this(v.x.L, v.y.L)
    constructor(v: Vec4bool) : this(v.x.L, v.y.L)

    constructor(bytes: ByteArray, index: Int = 0, oneByteOneLong: Boolean = false, bigEndian: Boolean = true) : this(
            if (oneByteOneLong) bytes[index].L else bytes.getLong(index, bigEndian),
            if (oneByteOneLong) bytes[index + 1].L else bytes.getLong(index + Long.BYTES, bigEndian))

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

    constructor(list: Iterable<*>, index: Int = 0) : this(list.elementAt(index)!!.toLong, list.elementAt(index + 1)!!.toLong)

    constructor(bytes: ByteBuffer, index: Int = bytes.pos, oneByteOneLong: Boolean = false) : this(
            if (oneByteOneLong) bytes[index].L else bytes.getLong(index),
            if (oneByteOneLong) bytes[index + 1].L else bytes.getLong(index + Long.BYTES))

    constructor(chars: CharBuffer, index: Int = chars.pos) : this(chars[index].L, chars[index + 1].L)
    constructor(shorts: ShortBuffer, index: Int = shorts.pos) : this(shorts[index], shorts[index + 1])
    constructor(ints: IntBuffer, index: Int = ints.pos) : this(ints[index], ints[index + 1])
    constructor(longs: LongBuffer, index: Int = longs.pos) : this(longs[index], longs[index + 1])
    constructor(floats: FloatBuffer, index: Int = floats.pos) : this(floats[index], floats[index + 1])
    constructor(doubles: DoubleBuffer, index: Int = doubles.pos) : this(doubles[index], doubles[index + 1])

    constructor(block: (Int) -> Long) : this(block(0), block(1))

    constructor(s: Number) : this(s, s)
    constructor(x: Number, y: Number) : this(x.L, y.L)

    fun set(bytes: ByteArray, index: Int = 0, oneByteOneLong: Boolean = false, bigEndian: Boolean = true) {
        x = if (oneByteOneLong) bytes[index].L else bytes.getLong(index, bigEndian)
        y = if (oneByteOneLong) bytes[index + 1].L else bytes.getLong(index + Long.BYTES, bigEndian)
    }

    fun set(bytes: ByteBuffer, index: Int = bytes.pos, oneByteOneLong: Boolean = false) {
        x = if (oneByteOneLong) bytes[index].L else bytes.getLong(index)
        y = if (oneByteOneLong) bytes[index + 1].L else bytes.getLong(index + Long.BYTES)
    }


    fun put(x: Long, y: Long) {
        this.x = x
        this.y = y
    }

    fun invoke(x: Long, y: Long): Vec2l {
        this.x = x
        this.y = y
        return this
    }

    override fun put(x: Number, y: Number) {
        this.x = x.L
        this.y = y.L
    }

    override fun invoke(x: Number, y: Number): Vec2l {
        this.x = x.L
        this.y = y.L
        return this
    }

    fun to(bytes: ByteArray, index: Int) = to(bytes, index, true)
    override fun to(bytes: ByteArray, index: Int, bigEndian: Boolean): ByteArray {
        bytes.putLong(index, x)
        bytes.putLong(index + Long.BYTES, y)
        return bytes
    }

    fun toLongArray(): LongArray = to(LongArray(length), 0)
    infix fun to(longs: LongArray): LongArray = to(longs, 0)
    fun to(longs: LongArray, index: Int): LongArray {
        System.arraycopy(array, ofs, longs, index, length)
        return longs
    }

    override fun to(buf: ByteBuffer, offset: Int): ByteBuffer {
        buf.putLong(offset, x)
        buf.putLong(offset + Long.BYTES, y)
        return buf
    }

    fun toLongBufferStack(): LongBuffer = to(MemoryStack.stackPush().mallocLong(length), 0)
    infix fun toLongBuffer(stack: MemoryStack): LongBuffer = to(stack.mallocLong(length), 0)
    fun toLongBuffer(): LongBuffer = to(LongBuffer(length), 0)
    infix fun to(buf: LongBuffer): LongBuffer = to(buf, buf.pos)
    fun to(buf: LongBuffer, index: Int): LongBuffer {
        buf[index] = x
        buf[index + 1] = y
        return buf
    }

    infix fun to(ptr: Ptr) {
        memPutLong(ptr, x)
        memPutLong(ptr + Long.BYTES, y)
    }

    // -- Component accesses --

    operator fun set(index: Int, value: Long) = when (index) {
        0 -> x = value
        1 -> y = value
        else -> throw ArrayIndexOutOfBoundsException()
    }

    override operator fun set(index: Int, value: Number) = when (index) {
        0 -> x = value.L
        1 -> y = value.L
        else -> throw ArrayIndexOutOfBoundsException()
    }


    // -- Unary arithmetic operators --

    operator fun unaryPlus() = this

    operator fun unaryMinus() = Vec2l(-x, -y)

    // -- Increment main.and decrement operators --

    operator fun inc() = plus(Vec2l(), this, 1, 1)
    infix fun inc(res: Vec2l) = plus(res, this, 1, 1)
    fun inc_() = plus(this, this, 1, 1)


    operator fun dec() = minus(Vec2l(), this, 1, 1)
    infix fun dec(res: Vec2l) = minus(res, this, 1, 1)
    fun dec_() = minus(this, this, 1, 1)


    // -- Specific binary arithmetic operators --

    infix operator fun plus(b: Long) = plus(Vec2l(), this, b, b)
    infix operator fun plus(b: Vec2l) = plus(Vec2l(), this, b.x, b.y)

    @JvmOverloads
    fun plus(bX: Long, bY: Long, res: Vec2l = Vec2l()) = plus(res, this, bX, bY)

    fun plus(b: Long, res: Vec2l) = plus(res, this, b, b)
    fun plus(b: Vec2l, res: Vec2l) = plus(res, this, b.x, b.y)

    fun plus_(bX: Long, bY: Long) = plus(this, this, bX, bY)
    infix fun plus_(b: Long) = plus(this, this, b, b)
    infix fun plus_(b: Vec2l) = plus(this, this, b.x, b.y)


    infix operator fun minus(b: Long) = minus(Vec2l(), this, b, b)
    infix operator fun minus(b: Vec2l) = minus(Vec2l(), this, b.x, b.y)

    @JvmOverloads
    fun minus(bX: Long, bY: Long, res: Vec2l = Vec2l()) = minus(res, this, bX, bY)

    fun minus(b: Long, res: Vec2l) = minus(res, this, b, b)
    fun minus(b: Vec2l, res: Vec2l) = minus(res, this, b.x, b.y)

    fun minus_(bX: Long, bY: Long) = minus(this, this, bX, bY)
    infix fun minus_(b: Long) = minus(this, this, b, b)
    infix fun minus_(b: Vec2l) = minus(this, this, b.x, b.y)


    infix operator fun times(b: Long) = times(Vec2l(), this, b, b)
    infix operator fun times(b: Vec2l) = times(Vec2l(), this, b.x, b.y)

    @JvmOverloads
    fun times(bX: Long, bY: Long, res: Vec2l = Vec2l()) = times(res, this, bX, bY)

    fun times(b: Long, res: Vec2l) = times(res, this, b, b)
    fun times(b: Vec2l, res: Vec2l) = times(res, this, b.x, b.y)

    fun times_(bX: Long, bY: Long) = times(this, this, bX, bY)
    infix fun times_(b: Long) = times(this, this, b, b)
    infix fun times_(b: Vec2l) = times(this, this, b.x, b.y)


    infix operator fun div(b: Long) = div(Vec2l(), this, b, b)
    infix operator fun div(b: Vec2l) = div(Vec2l(), this, b.x, b.y)

    @JvmOverloads
    fun div(bX: Long, bY: Long, res: Vec2l = Vec2l()) = div(res, this, bX, bY)

    fun div(b: Long, res: Vec2l) = div(res, this, b, b)
    fun div(b: Vec2l, res: Vec2l) = div(res, this, b.x, b.y)

    fun div_(bX: Long, bY: Long) = div(this, this, bX, bY)
    infix fun div_(b: Long) = div(this, this, b, b)
    infix fun div_(b: Vec2l) = div(this, this, b.x, b.y)


    infix operator fun rem(b: Long) = rem(Vec2l(), this, b, b)
    infix operator fun rem(b: Vec2l) = rem(Vec2l(), this, b.x, b.y)

    @JvmOverloads
    fun rem(bX: Long, bY: Long, res: Vec2l = Vec2l()) = rem(res, this, bX, bY)

    fun rem(b: Long, res: Vec2l) = rem(res, this, b, b)
    fun rem(b: Vec2l, res: Vec2l) = rem(res, this, b.x, b.y)

    fun rem_(bX: Long, bY: Long) = rem(this, this, bX, bY)
    infix fun rem_(b: Long) = rem(this, this, b, b)
    infix fun rem_(b: Vec2l) = rem(this, this, b.x, b.y)


    // -- Generic binary arithmetic operators --

    infix operator fun plus(b: Number) = plus(Vec2l(), this, b.L, b.L)
    infix operator fun plus(b: Vec2t<out Number>) = plus(Vec2l(), this, b.x.L, b.y.L)

    @JvmOverloads
    fun plus(bX: Number, bY: Number, res: Vec2l = Vec2l()) = plus(res, this, bX.L, bY.L)

    fun plus(b: Number, res: Vec2l) = plus(res, this, b.L, b.L)
    fun plus(b: Vec2t<out Number>, res: Vec2l) = plus(res, this, b.x.L, b.y.L)

    fun plus_(bX: Number, bY: Number) = plus(this, this, bX.L, bY.L)
    infix fun plus_(b: Number) = plus(this, this, b.L, b.L)
    infix fun plus_(b: Vec2t<out Number>) = plus(this, this, b.x.L, b.y.L)


    infix operator fun minus(b: Number) = minus(Vec2l(), this, b.L, b.L)
    infix operator fun minus(b: Vec2t<out Number>) = minus(Vec2l(), this, b.x.L, b.y.L)

    @JvmOverloads
    fun minus(bX: Number, bY: Number, res: Vec2l = Vec2l()) = minus(res, this, bX.L, bY.L)

    fun minus(b: Number, res: Vec2l) = minus(res, this, b.L, b.L)
    fun minus(b: Vec2t<out Number>, res: Vec2l) = minus(res, this, b.x.L, b.y.L)

    fun minus_(bX: Number, bY: Number) = minus(this, this, bX.L, bY.L)
    infix fun minus_(b: Number) = minus(this, this, b.L, b.L)
    infix fun minus_(b: Vec2t<out Number>) = minus(this, this, b.x.L, b.y.L)


    infix operator fun times(b: Number) = times(Vec2l(), this, b.L, b.L)
    infix operator fun times(b: Vec2t<out Number>) = times(Vec2l(), this, b.x.L, b.y.L)

    @JvmOverloads
    fun times(bX: Number, bY: Number, res: Vec2l = Vec2l()) = times(res, this, bX.L, bY.L)

    fun times(b: Number, res: Vec2l) = times(res, this, b.L, b.L)
    fun times(b: Vec2t<out Number>, res: Vec2l) = times(res, this, b.x.L, b.y.L)

    fun times_(bX: Number, bY: Number) = times(this, this, bX.L, bY.L)
    infix fun times_(b: Number) = times(this, this, b.L, b.L)
    infix fun times_(b: Vec2t<out Number>) = times(this, this, b.x.L, b.y.L)


    infix operator fun div(b: Number) = div(Vec2l(), this, b.L, b.L)
    infix operator fun div(b: Vec2t<out Number>) = div(Vec2l(), this, b.x.L, b.y.L)

    @JvmOverloads
    fun div(bX: Number, bY: Number, res: Vec2l = Vec2l()) = div(res, this, bX.L, bY.L)

    fun div(b: Number, res: Vec2l) = div(res, this, b.L, b.L)
    fun div(b: Vec2t<out Number>, res: Vec2l) = div(res, this, b.x.L, b.y.L)

    fun div_(bX: Number, bY: Number) = div(this, this, bX.L, bY.L)
    infix fun div_(b: Number) = div(this, this, b.L, b.L)
    infix fun div_(b: Vec2t<out Number>) = div(this, this, b.x.L, b.y.L)


    infix operator fun rem(b: Number) = rem(Vec2l(), this, b.L, b.L)
    infix operator fun rem(b: Vec2t<out Number>) = rem(Vec2l(), this, b.x.L, b.y.L)

    @JvmOverloads
    fun rem(bX: Number, bY: Number, res: Vec2l = Vec2l()) = rem(res, this, bX.L, bY.L)

    fun rem(b: Number, res: Vec2l) = rem(res, this, b.L, b.L)
    fun rem(b: Vec2t<out Number>, res: Vec2l) = rem(res, this, b.x.L, b.y.L)

    fun rem_(bX: Number, bY: Number) = rem(this, this, bX.L, bY.L)
    infix fun rem_(b: Number) = rem(this, this, b.L, b.L)
    infix fun rem_(b: Vec2t<out Number>) = rem(this, this, b.x.L, b.y.L)


    // -- Specific bitwise operators --

    infix fun and(b: Int) = and(Vec2l(), this, b, b)
    infix fun and(b: Long) = and(Vec2l(), this, b, b)
    infix fun and(b: Vec2l) = and(Vec2l(), this, b.x, b.y)

    fun and(b: Int, res: Vec2l) = and(res, this, b, b)
    fun and(b: Long, res: Vec2l) = and(res, this, b, b)
    fun and(b: Vec2l, res: Vec2l) = and(res, this, b.x, b.y)
    @JvmOverloads
    fun and(bX: Int, bY: Int, res: Vec2l = Vec2l()) = and(res, this, bX, bY)

    @JvmOverloads
    fun and(bX: Long, bY: Long, res: Vec2l = Vec2l()) = and(res, this, bX, bY)

    infix fun and_(b: Int) = and(this, this, b, b)
    infix fun and_(b: Long) = and(this, this, b, b)
    infix fun and_(b: Vec2l) = and(this, this, b.x, b.y)
    fun and_(bX: Int, bY: Int) = and(this, this, bX, bY)
    fun and_(bX: Long, bY: Long) = and(this, this, bX, bY)


    infix fun or(b: Int) = or(Vec2l(), this, b, b)
    infix fun or(b: Long) = or(Vec2l(), this, b, b)
    infix fun or(b: Vec2l) = or(Vec2l(), this, b.x, b.y)

    fun or(b: Int, res: Vec2l) = or(res, this, b, b)
    fun or(b: Long, res: Vec2l) = or(res, this, b, b)
    fun or(b: Vec2l, res: Vec2l) = or(res, this, b.x, b.y)
    @JvmOverloads
    fun or(bX: Int, bY: Int, res: Vec2l = Vec2l()) = or(res, this, bX, bY)

    @JvmOverloads
    fun or(bX: Long, bY: Long, res: Vec2l = Vec2l()) = or(res, this, bX, bY)

    infix fun or_(b: Int) = or(this, this, b, b)
    infix fun or_(b: Long) = or(this, this, b, b)
    infix fun or_(b: Vec2l) = or(this, this, b.x, b.y)
    fun or_(bX: Int, bY: Int) = or(this, this, bX, bY)
    fun or_(bX: Long, bY: Long) = or(this, this, bX, bY)


    infix fun xor(b: Int) = xor(Vec2l(), this, b, b)
    infix fun xor(b: Long) = xor(Vec2l(), this, b, b)
    infix fun xor(b: Vec2l) = xor(Vec2l(), this, b.x, b.y)

    fun xor(b: Int, res: Vec2l) = xor(res, this, b, b)
    fun xor(b: Long, res: Vec2l) = xor(res, this, b, b)
    fun xor(b: Vec2l, res: Vec2l) = xor(res, this, b.x, b.y)
    @JvmOverloads
    fun xor(bX: Int, bY: Int, res: Vec2l = Vec2l()) = xor(res, this, bX, bY)

    @JvmOverloads
    fun xor(bX: Long, bY: Long, res: Vec2l = Vec2l()) = xor(res, this, bX, bY)

    infix fun xor_(b: Int) = xor(this, this, b, b)
    infix fun xor_(b: Long) = xor(this, this, b, b)
    infix fun xor_(b: Vec2l) = xor(this, this, b.x, b.y)
    fun xor_(bX: Int, bY: Int) = xor(this, this, bX, bY)
    fun xor_(bX: Long, bY: Long) = xor(this, this, bX, bY)


    infix fun shl(b: Int) = shl(Vec2l(), this, b, b)
    infix fun shl(b: Long) = shl(Vec2l(), this, b, b)
    infix fun shl(b: Vec2l) = shl(Vec2l(), this, b.x, b.y)

    fun shl(b: Int, res: Vec2l) = shl(res, this, b, b)
    fun shl(b: Long, res: Vec2l) = shl(res, this, b, b)
    fun shl(b: Vec2l, res: Vec2l) = shl(res, this, b.x, b.y)
    @JvmOverloads
    fun shl(bX: Int, bY: Int, res: Vec2l = Vec2l()) = shl(res, this, bX, bY)

    @JvmOverloads
    fun shl(bX: Long, bY: Long, res: Vec2l = Vec2l()) = shl(res, this, bX, bY)

    infix fun shl_(b: Int) = shl(this, this, b, b)
    infix fun shl_(b: Long) = shl(this, this, b, b)
    infix fun shl_(b: Vec2l) = shl(this, this, b.x, b.y)
    fun shl_(bX: Int, bY: Int) = shl(this, this, bX, bY)
    fun shl_(bX: Long, bY: Long) = shl(this, this, bX, bY)


    infix fun shr(b: Int) = shr(Vec2l(), this, b, b)
    infix fun shr(b: Long) = shr(Vec2l(), this, b, b)
    infix fun shr(b: Vec2l) = shr(Vec2l(), this, b.x, b.y)

    fun shr(b: Int, res: Vec2l) = shr(res, this, b, b)
    fun shr(b: Long, res: Vec2l) = shr(res, this, b, b)
    fun shr(b: Vec2l, res: Vec2l) = shr(res, this, b.x, b.y)
    @JvmOverloads
    fun shr(bX: Int, bY: Int, res: Vec2l = Vec2l()) = shr(res, this, bX, bY)

    @JvmOverloads
    fun shr(bX: Long, bY: Long, res: Vec2l = Vec2l()) = shr(res, this, bX, bY)

    infix fun shr_(b: Int) = shr(this, this, b, b)
    infix fun shr_(b: Long) = shr(this, this, b, b)
    infix fun shr_(b: Vec2l) = shr(this, this, b.x, b.y)
    fun shr_(bX: Int, bY: Int) = shr(this, this, bX, bY)
    fun shr_(bX: Long, bY: Long) = shr(this, this, bX, bY)


    @JvmOverloads
    fun inv(res: Vec2l = Vec2l()) = inv(res, this)

    fun inv_() = inv(this, this)


    // -- Generic bitwise operators --

    infix fun and(b: Number) = and(Vec2l(), this, b.L, b.L)
    infix fun and(b: Vec2t<out Number>) = and(Vec2l(), this, b.x.L, b.y.L)

    fun and(b: Number, res: Vec2l) = and(res, this, b.L, b.L)
    fun and(b: Vec2t<out Number>, res: Vec2l) = and(res, this, b.x.L, b.y.L)
    @JvmOverloads
    fun and(bX: Number, bY: Number, res: Vec2l = Vec2l()) = and(res, this, bX.L, bY.L)

    infix fun and_(b: Number) = and(this, this, b.L, b.L)
    infix fun and_(b: Vec2t<out Number>) = and(this, this, b.x.L, b.y.L)
    fun and_(bX: Number, bY: Number) = and(this, this, bX.L, bY.L)


    infix fun or(b: Number) = or(Vec2l(), this, b.L, b.L)
    infix fun or(b: Vec2t<out Number>) = or(Vec2l(), this, b.x.L, b.y.L)

    fun or(b: Number, res: Vec2l) = or(res, this, b.L, b.L)
    fun or(b: Vec2t<out Number>, res: Vec2l) = or(res, this, b.x.L, b.y.L)
    @JvmOverloads
    fun or(bX: Number, bY: Number, res: Vec2l = Vec2l()) = or(res, this, bX.L, bY.L)

    infix fun or_(b: Number) = or(this, this, b.L, b.L)
    infix fun or_(b: Vec2t<out Number>) = or(this, this, b.x.L, b.y.L)
    fun or_(bX: Number, bY: Number) = or(this, this, bX.L, bY.L)


    infix fun xor(b: Number) = xor(Vec2l(), this, b.L, b.L)
    infix fun xor(b: Vec2t<out Number>) = xor(Vec2l(), this, b.x.L, b.y.L)

    fun xor(b: Number, res: Vec2l) = xor(res, this, b.L, b.L)
    fun xor(b: Vec2t<out Number>, res: Vec2l) = xor(res, this, b.x.L, b.y.L)
    @JvmOverloads
    fun xor(bX: Number, bY: Number, res: Vec2l = Vec2l()) = xor(res, this, bX.L, bY.L)

    infix fun xor_(b: Number) = xor(this, this, b.L, b.L)
    infix fun xor_(b: Vec2t<out Number>) = xor(this, this, b.x.L, b.y.L)
    fun xor_(bX: Number, bY: Number) = xor(this, this, bX.L, bY.L)


    infix fun shl(b: Number) = shl(Vec2l(), this, b.L, b.L)
    infix fun shl(b: Vec2t<out Number>) = shl(Vec2l(), this, b.x.L, b.y.L)

    fun shl(b: Number, res: Vec2l) = shl(res, this, b.L, b.L)
    fun shl(b: Vec2t<out Number>, res: Vec2l) = shl(res, this, b.x.L, b.y.L)
    @JvmOverloads
    fun shl(bX: Number, bY: Number, res: Vec2l = Vec2l()) = shl(res, this, bX.L, bY.L)

    infix fun shl_(b: Number) = shl(this, this, b.L, b.L)
    infix fun shl_(b: Vec2t<out Number>) = shl(this, this, b.x.L, b.y.L)
    fun shl_(bX: Number, bY: Number) = shl(this, this, bX.L, bY.L)


    infix fun shr(b: Number) = shr(Vec2l(), this, b.L, b.L)
    infix fun shr(b: Vec2t<out Number>) = shr(Vec2l(), this, b.x.L, b.y.L)

    fun shr(b: Number, res: Vec2l) = shr(res, this, b.L, b.L)
    fun shr(b: Vec2t<out Number>, res: Vec2l) = shr(res, this, b.x.L, b.y.L)
    @JvmOverloads
    fun shr(bX: Number, bY: Number, res: Vec2l = Vec2l()) = shr(res, this, bX.L, bY.L)

    infix fun shr_(b: Number) = shr(this, this, b.L, b.L)
    infix fun shr_(b: Vec2t<out Number>) = shr(this, this, b.x.L, b.y.L)
    fun shr_(bX: Number, bY: Number) = shr(this, this, bX.L, bY.L)


    override fun createInstance(x: Long, y: Long) = Vec2l(x, y)


    companion object : opVec2l {
        const val length = Vec2t.length
        @JvmField
        val size = length * Long.BYTES

        @JvmStatic
        fun fromPointer(ptr: Ptr) = Vec2l(memGetLong(ptr), memGetLong(ptr + Long.BYTES))
    }

    override fun size() = size

    override fun equals(other: Any?) = other is Vec2l && this[0] == other[0] && this[1] == other[1]
    override fun hashCode() = 31 * x.hashCode() + y.hashCode()

    fun print(name: String = "", stream: PrintStream = System.out) = stream.println("$name [$x, $y]")
    override fun toString(): String = "Vec2l [$x, $y]"
}