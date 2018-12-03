package glm_.vec2

import glm_.*
import glm_.vec2.operators.opVec2ui
import glm_.vec3.Vec3bool
import glm_.vec3.Vec3t
import glm_.vec4.Vec4bool
import glm_.vec4.Vec4t
import kool.Ptr
import kool.IntBuffer
import kool.pos
import kool.set
import org.lwjgl.system.MemoryStack
import org.lwjgl.system.MemoryUtil.memGetInt
import org.lwjgl.system.MemoryUtil.memPutInt
import unsigned.Uint
import java.io.PrintStream
import java.nio.*

/**
 * Created by elect on 08/10/16.
 */

class Vec2ui(var ofs: Int, var array: IntArray) : Vec2t<Uint>(), ToBuffer {

    constructor(x: Uint, y: Uint) : this(0, intArrayOf(x.v, y.v))
    constructor(x: Int, y: Int) : this(0, intArrayOf(x, y))

    override var x: Uint
        get() = Uint(array[ofs])
        set(value) = array.set(ofs, value.v)
    override var y: Uint
        get() = Uint(array[ofs + 1])
        set(value) = array.set(ofs + 1, value.v)

    inline var vX: Int
        get() = array[ofs]
        set(value) = array.set(ofs, value)
    inline var vY: Int
        get() = array[ofs + 1]
        set(value) = array.set(ofs + 1, value)

    // -- Explicit basic, conversion other main.and conversion vector constructors --

    constructor() : this(0)

    constructor(v: Vec2t<out Number>) : this(v.x, v.y)
    constructor(v: Vec3t<out Number>) : this(v.x, v.y)
    constructor(v: Vec4t<out Number>) : this(v.x, v.y)

    constructor(v: Vec2bool) : this(v.x.ui, v.y.ui)
    constructor(v: Vec3bool) : this(v.x.ui, v.y.ui)
    constructor(v: Vec4bool) : this(v.x.ui, v.y.ui)

    constructor(bytes: ByteArray, index: Int = 0, oneByteOneUint: Boolean = false, bigEndian: Boolean = true) : this(
            if (oneByteOneUint) bytes[index].ui else bytes.getUint(index, bigEndian),
            if (oneByteOneUint) bytes[index + 1].ui else bytes.getUint(index + Uint.BYTES, bigEndian))

    constructor(chars: CharArray, index: Int = 0) : this(chars[index].ui, chars[index + 1].ui)
    constructor(shorts: ShortArray, index: Int = 0) : this(shorts[index], shorts[index + 1])
    constructor(ints: IntArray, index: Int = 0) : this(ints[index], ints[index + 1])
    constructor(longs: LongArray, index: Int = 0) : this(longs[index], longs[index + 1])
    constructor(floats: FloatArray, index: Int = 0) : this(floats[index], floats[index + 1])
    constructor(doubles: DoubleArray, index: Int = 0) : this(doubles[index], doubles[index + 1])
    constructor(booleans: BooleanArray, index: Int = 0) : this(booleans[index].ui, booleans[index + 1].ui)

    constructor(numbers: Array<out Number>, index: Int = 0) : this(numbers[index], numbers[index + 1])
    constructor(chars: Array<Char>, index: Int = 0) : this(chars[index].ui, chars[index + 1].ui)
    constructor(booleans: Array<Boolean>, index: Int = 0) : this(booleans[index].ui, booleans[index + 1].ui)

    constructor(list: Iterable<*>, index: Int = 0) : this(list.elementAt(index)!!.toInt, list.elementAt(index + 1)!!.toInt)

    constructor(bytes: ByteBuffer, index: Int = bytes.pos, oneByteOneUint: Boolean = false) : this(
            if (oneByteOneUint) bytes[index].ui else bytes.getInt(index).ui,
            if (oneByteOneUint) bytes[index + 1].ui else bytes.getInt(index + Uint.BYTES).ui)

    constructor(chars: CharBuffer, index: Int = chars.pos) : this(chars[index].ui, chars[index + 1].ui)
    constructor(shorts: ShortBuffer, index: Int = shorts.pos) : this(shorts[index], shorts[index + 1])
    constructor(ints: IntBuffer, index: Int = ints.pos) : this(ints[index], ints[index + 1])
    constructor(longs: LongBuffer, index: Int = longs.pos) : this(longs[index], longs[index + 1])
    constructor(floats: FloatBuffer, index: Int = floats.pos) : this(floats[index], floats[index + 1])
    constructor(doubles: DoubleBuffer, index: Int = doubles.pos) : this(doubles[index], doubles[index + 1])

    constructor(block: (Int) -> Uint) : this(block(0), block(1))

    constructor(s: Number) : this(s, s)
    constructor(x: Number, y: Number) : this(x.ui, y.ui)


    fun set(bytes: ByteArray, index: Int = 0, oneByteOneUint: Boolean = false, bigEndian: Boolean = true) {
        x.v = if (oneByteOneUint) bytes[index].i else bytes.getInt(index, bigEndian)
        y.v = if (oneByteOneUint) bytes[index + 1].i else bytes.getInt(index + Uint.BYTES, bigEndian)
    }

    fun set(bytes: ByteBuffer, index: Int = bytes.pos, oneByteOneUint: Boolean = false) {
        x.v = if (oneByteOneUint) bytes[index].i else bytes.getInt(index)
        y.v = if (oneByteOneUint) bytes[index + 1].i else bytes.getInt(index + Uint.BYTES)
    }


    fun put(x: Uint, y: Uint) {
        this.x = x
        this.y = y
    }

    fun invoke(x: Uint, y: Uint): Vec2ui {
        this.x = x
        this.y = y
        return this
    }

    fun put(x: Int, y: Int) {
        this.x.v = x
        this.y.v = y
    }

    fun invoke(x: Int, y: Int): Vec2ui {
        this.x.v = x
        this.y.v = y
        return this
    }

    override fun put(x: Number, y: Number) {
        this.x = x.ui
        this.y = y.ui
    }

    override fun invoke(x: Number, y: Number): Vec2ui {
        this.x = x.ui
        this.y = y.ui
        return this
    }

    fun to(bytes: ByteArray, index: Int) = to(bytes, index, true)
    override fun to(bytes: ByteArray, index: Int, bigEndian: Boolean): ByteArray {
        bytes.putInt(index, x.v)
        bytes.putInt(index + Int.BYTES, y.v)
        return bytes
    }

    fun toIntArray(): IntArray = to(IntArray(length), 0)
    infix fun to(ints: IntArray): IntArray = to(ints, 0)
    fun to(ints: IntArray, index: Int): IntArray {
        System.arraycopy(array, ofs, ints, index, length)
        return ints
    }

    override fun to(buf: ByteBuffer, offset: Int): ByteBuffer {
        buf.putInt(offset, x.v)
        buf.putInt(offset + Int.BYTES, y.v)
        return buf
    }

    fun toIntBufferStack(): IntBuffer = to(MemoryStack.stackPush().mallocInt(length), 0)
    infix fun toIntBuffer(stack: MemoryStack): IntBuffer = to(stack.mallocInt(length), 0)
    fun toIntBuffer(): IntBuffer = to(IntBuffer(length), 0)
    infix fun to(buf: IntBuffer): IntBuffer = to(buf, buf.pos)
    fun to(buf: IntBuffer, index: Int): IntBuffer {
        buf[index] = x.v
        buf[index + 1] = y.v
        return buf
    }

    infix fun to(ptr: Ptr) {
        memPutInt(ptr, x.v)
        memPutInt(ptr + Int.BYTES, y.v)
    }

    // -- Component accesses --

    operator fun set(index: Int, value: Uint) = when (index) {
        0 -> x = value
        1 -> y = value
        else -> throw ArrayIndexOutOfBoundsException()
    }

    override operator fun set(index: Int, value: Number) = when (index) {
        0 -> x = value.ui
        1 -> y = value.ui
        else -> throw ArrayIndexOutOfBoundsException()
    }

    // -- Unary arithmetic operators --

    operator fun unaryPlus() = this

    // no unaryMinus operator, only signed

    // -- Increment main.and decrement operators --

    operator fun inc(res: Vec2ui = Vec2ui()) = plus(res, this, 1, 1)
    fun incAssign() = plus(this, this, 1, 1)


    operator fun dec(res: Vec2ui = Vec2ui()) = minus(res, this, 1, 1)
    fun decAssign() = minus(this, this, 1, 1)


    // -- Specific binary arithmetic operators --

    infix operator fun plus(b: Uint) = plus(Vec2ui(), this, b, b)
    infix operator fun plus(b: Int) = plus(Vec2ui(), this, b, b)
    infix operator fun plus(b: Vec2ui) = plus(Vec2ui(), this, b.x, b.y)

    @JvmOverloads
    fun plus(bX: Uint, bY: Uint, res: Vec2ui = Vec2ui()) = plus(res, this, bX, bY)

    @JvmOverloads
    fun plus(bX: Int, bY: Int, res: Vec2ui = Vec2ui()) = plus(res, this, bX, bY)

    fun plus(b: Uint, res: Vec2ui) = plus(res, this, b, b)
    fun plus(b: Int, res: Vec2ui) = plus(res, this, b, b)
    fun plus(b: Vec2ui, res: Vec2ui) = plus(res, this, b.x, b.y)

    fun plusAssign(bX: Uint, bY: Uint) = plus(this, this, bX, bY)
    fun plusAssign(bX: Int, bY: Int) = plus(this, this, bX, bY)
    infix operator fun plusAssign(b: Uint) {
        plus(this, this, b, b)
    }

    infix operator fun plusAssign(b: Int) {
        plus(this, this, b, b)
    }

    infix operator fun plusAssign(b: Vec2ui) {
        plus(this, this, b.x, b.y)
    }


    infix operator fun minus(b: Uint) = minus(Vec2ui(), this, b, b)
    infix operator fun minus(b: Int) = minus(Vec2ui(), this, b, b)
    infix operator fun minus(b: Vec2ui) = minus(Vec2ui(), this, b.x, b.y)

    @JvmOverloads
    fun minus(bX: Uint, bY: Uint, res: Vec2ui = Vec2ui()) = minus(res, this, bX, bY)

    @JvmOverloads
    fun minus(bX: Int, bY: Int, res: Vec2ui = Vec2ui()) = minus(res, this, bX, bY)

    fun minus(b: Uint, res: Vec2ui) = minus(res, this, b, b)
    fun minus(b: Int, res: Vec2ui) = minus(res, this, b, b)
    fun minus(b: Vec2ui, res: Vec2ui) = minus(res, this, b.x, b.y)

    fun minusAssign(bX: Uint, bY: Uint) = minus(this, this, bX, bY)
    fun minusAssign(bX: Int, bY: Int) = minus(this, this, bX, bY)
    infix operator fun minusAssign(b: Uint) {
        minus(this, this, b, b)
    }

    infix operator fun minusAssign(b: Int) {
        minus(this, this, b, b)
    }

    infix operator fun minusAssign(b: Vec2ui) {
        minus(this, this, b.x, b.y)
    }


    infix operator fun times(b: Uint) = times(Vec2ui(), this, b, b)
    infix operator fun times(b: Int) = times(Vec2ui(), this, b, b)
    infix operator fun times(b: Vec2ui) = times(Vec2ui(), this, b.x, b.y)

    @JvmOverloads
    fun times(bX: Uint, bY: Uint, res: Vec2ui = Vec2ui()) = times(res, this, bX, bY)

    @JvmOverloads
    fun times(bX: Int, bY: Int, res: Vec2ui = Vec2ui()) = times(res, this, bX, bY)

    fun times(b: Uint, res: Vec2ui) = times(res, this, b, b)
    fun times(b: Int, res: Vec2ui) = times(res, this, b, b)
    fun times(b: Vec2ui, res: Vec2ui) = times(res, this, b.x, b.y)

    fun timesAssign(bX: Uint, bY: Uint) = times(this, this, bX, bY)
    fun timesAssign(bX: Int, bY: Int) = times(this, this, bX, bY)
    infix operator fun timesAssign(b: Uint) {
        times(this, this, b, b)
    }

    infix operator fun timesAssign(b: Int) {
        times(this, this, b, b)
    }

    infix operator fun timesAssign(b: Vec2ui) {
        times(this, this, b.x, b.y)
    }


    infix operator fun div(b: Uint) = div(Vec2ui(), this, b, b)
    infix operator fun div(b: Int) = div(Vec2ui(), this, b, b)
    infix operator fun div(b: Vec2ui) = div(Vec2ui(), this, b.x, b.y)

    @JvmOverloads
    fun div(bX: Uint, bY: Uint, res: Vec2ui = Vec2ui()) = div(res, this, bX, bY)

    @JvmOverloads
    fun div(bX: Int, bY: Int, res: Vec2ui = Vec2ui()) = div(res, this, bX, bY)

    fun div(b: Uint, res: Vec2ui) = div(res, this, b, b)
    fun div(b: Int, res: Vec2ui) = div(res, this, b, b)
    fun div(b: Vec2ui, res: Vec2ui) = div(res, this, b.x, b.y)

    fun divAssign(bX: Uint, bY: Uint) = div(this, this, bX, bY)
    fun divAssign(bX: Int, bY: Int) = div(this, this, bX, bY)
    infix operator fun divAssign(b: Uint) {
        div(this, this, b, b)
    }

    infix operator fun divAssign(b: Int) {
        div(this, this, b, b)
    }

    infix operator fun divAssign(b: Vec2ui) {
        div(this, this, b.x, b.y)
    }


    infix operator fun rem(b: Uint) = rem(Vec2ui(), this, b, b)
    infix operator fun rem(b: Int) = rem(Vec2ui(), this, b, b)
    infix operator fun rem(b: Vec2ui) = rem(Vec2ui(), this, b.x, b.y)

    @JvmOverloads
    fun rem(bX: Uint, bY: Uint, res: Vec2ui = Vec2ui()) = rem(res, this, bX, bY)

    @JvmOverloads
    fun rem(bX: Int, bY: Int, res: Vec2ui = Vec2ui()) = rem(res, this, bX, bY)

    fun rem(b: Uint, res: Vec2ui) = rem(res, this, b, b)
    fun rem(b: Int, res: Vec2ui) = rem(res, this, b, b)
    fun rem(b: Vec2ui, res: Vec2ui) = rem(res, this, b.x, b.y)

    fun remAssign(bX: Uint, bY: Uint) = rem(this, this, bX, bY)
    fun remAssign(bX: Int, bY: Int) = rem(this, this, bX, bY)
    infix operator fun remAssign(b: Uint) {
        rem(this, this, b, b)
    }

    infix operator fun remAssign(b: Int) {
        rem(this, this, b, b)
    }

    infix operator fun remAssign(b: Vec2ui) {
        rem(this, this, b.x, b.y)
    }


    // -- Generic binary arithmetic operators --

    infix operator fun plus(b: Number) = plus(Vec2ui(), this, b.i, b.i)
    infix operator fun plus(b: Vec2t<out Number>) = plus(Vec2ui(), this, b.x.i, b.y.i)

    @JvmOverloads
    fun plus(bX: Number, bY: Number, res: Vec2ui = Vec2ui()) = plus(res, this, bX.i, bY.i)

    fun plus(b: Number, res: Vec2ui) = plus(res, this, b.i, b.i)
    fun plus(b: Vec2t<out Number>, res: Vec2ui) = plus(res, this, b.x.i, b.y.i)

    fun plusAssign(bX: Number, bY: Number) = plus(this, this, bX.i, bY.i)
    infix operator fun plusAssign(b: Number) {
        plus(this, this, b.i, b.i)
    }

    infix operator fun plusAssign(b: Vec2t<out Number>) {
        plus(this, this, b.x.i, b.y.i)
    }


    infix operator fun minus(b: Number) = minus(Vec2ui(), this, b.i, b.i)
    infix operator fun minus(b: Vec2t<out Number>) = minus(Vec2ui(), this, b.x.i, b.y.i)

    @JvmOverloads
    fun minus(bX: Number, bY: Number, res: Vec2ui = Vec2ui()) = minus(res, this, bX.i, bY.i)

    fun minus(b: Number, res: Vec2ui) = minus(res, this, b.i, b.i)
    fun minus(b: Vec2t<out Number>, res: Vec2ui) = minus(res, this, b.x.i, b.y.i)

    fun minusAssign(bX: Number, bY: Number) = minus(this, this, bX.i, bY.i)
    infix operator fun minusAssign(b: Number) {
        minus(this, this, b.i, b.i)
    }

    infix operator fun minusAssign(b: Vec2t<out Number>) {
        minus(this, this, b.x.i, b.y.i)
    }


    infix operator fun times(b: Number) = times(Vec2ui(), this, b.i, b.i)
    infix operator fun times(b: Vec2t<out Number>) = times(Vec2ui(), this, b.x.i, b.y.i)

    @JvmOverloads
    fun times(bX: Number, bY: Number, res: Vec2ui = Vec2ui()) = times(res, this, bX.i, bY.i)

    fun times(b: Number, res: Vec2ui) = times(res, this, b.i, b.i)
    fun times(b: Vec2t<out Number>, res: Vec2ui) = times(res, this, b.x.i, b.y.i)

    fun timesAssign(bX: Number, bY: Number) = times(this, this, bX.i, bY.i)
    infix operator fun timesAssign(b: Number) {
        times(this, this, b.i, b.i)
    }

    infix operator fun timesAssign(b: Vec2t<out Number>) {
        times(this, this, b.x.i, b.y.i)
    }


    infix operator fun div(b: Number) = div(Vec2ui(), this, b.i, b.i)
    infix operator fun div(b: Vec2t<out Number>) = div(Vec2ui(), this, b.x.i, b.y.i)

    @JvmOverloads
    fun div(bX: Number, bY: Number, res: Vec2ui = Vec2ui()) = div(res, this, bX.i, bY.i)

    fun div(b: Number, res: Vec2ui) = div(res, this, b.i, b.i)
    fun div(b: Vec2t<out Number>, res: Vec2ui) = div(res, this, b.x.i, b.y.i)

    fun divAssign(bX: Number, bY: Number) = div(this, this, bX.i, bY.i)
    infix operator fun divAssign(b: Number) {
        div(this, this, b.i, b.i)
    }

    infix operator fun divAssign(b: Vec2t<out Number>) {
        div(this, this, b.x.i, b.y.i)
    }


    infix operator fun rem(b: Number) = rem(Vec2ui(), this, b.i, b.i)
    infix operator fun rem(b: Vec2t<out Number>) = rem(Vec2ui(), this, b.x.i, b.y.i)

    @JvmOverloads
    fun rem(bX: Number, bY: Number, res: Vec2ui = Vec2ui()) = rem(res, this, bX.i, bY.i)

    fun rem(b: Number, res: Vec2ui) = rem(res, this, b.i, b.i)
    fun rem(b: Vec2t<out Number>, res: Vec2ui) = rem(res, this, b.x.i, b.y.i)

    fun remAssign(bX: Number, bY: Number) = rem(this, this, bX.i, bY.i)
    infix operator fun remAssign(b: Number) {
        rem(this, this, b.i, b.i)
    }

    infix operator fun remAssign(b: Vec2t<out Number>) {
        rem(this, this, b.x.i, b.y.i)
    }


    // -- Specific bitwise operators --

    infix fun and(b: Uint) = and(Vec2ui(), this, b, b)
    infix fun and(b: Int) = and(Vec2ui(), this, b, b)
    infix fun and(b: Vec2ui) = and(Vec2ui(), this, b.x, b.y)

    fun and(b: Uint, res: Vec2ui) = and(res, this, b, b)
    fun and(b: Int, res: Vec2ui) = and(res, this, b, b)
    fun and(b: Vec2ui, res: Vec2ui) = and(res, this, b.x, b.y)
    @JvmOverloads
    fun and(bX: Uint, bY: Uint, res: Vec2ui = Vec2ui()) = and(res, this, bX, bY)

    @JvmOverloads
    fun and(bX: Int, bY: Int, res: Vec2ui = Vec2ui()) = and(res, this, bX, bY)

    infix fun andAssign(b: Uint) = and(this, this, b, b)
    infix fun andAssign(b: Int) = and(this, this, b, b)
    infix fun andAssign(b: Vec2ui) = and(this, this, b.x, b.y)
    fun andAssign(bX: Uint, bY: Uint) = and(this, this, bX, bY)
    fun andAssign(bX: Int, bY: Int) = and(this, this, bX, bY)


    infix fun or(b: Uint) = or(Vec2ui(), this, b, b)
    infix fun or(b: Int) = or(Vec2ui(), this, b, b)
    infix fun or(b: Vec2ui) = or(Vec2ui(), this, b.x, b.y)

    fun or(b: Uint, res: Vec2ui) = or(res, this, b, b)
    fun or(b: Int, res: Vec2ui) = or(res, this, b, b)
    fun or(b: Vec2ui, res: Vec2ui) = or(res, this, b.x, b.y)
    @JvmOverloads
    fun or(bX: Uint, bY: Uint, res: Vec2ui = Vec2ui()) = or(res, this, bX, bY)

    @JvmOverloads
    fun or(bX: Int, bY: Int, res: Vec2ui = Vec2ui()) = or(res, this, bX, bY)

    infix fun orAssign(b: Uint) = or(this, this, b, b)
    infix fun orAssign(b: Int) = or(this, this, b, b)
    infix fun orAssign(b: Vec2ui) = or(this, this, b.x, b.y)
    fun orAssign(bX: Uint, bY: Uint) = or(this, this, bX, bY)
    fun orAssign(bX: Int, bY: Int) = or(this, this, bX, bY)


    infix fun xor(b: Uint) = xor(Vec2ui(), this, b, b)
    infix fun xor(b: Int) = xor(Vec2ui(), this, b, b)
    infix fun xor(b: Vec2ui) = xor(Vec2ui(), this, b.x, b.y)

    fun xor(b: Uint, res: Vec2ui) = xor(res, this, b, b)
    fun xor(b: Int, res: Vec2ui) = xor(res, this, b, b)
    fun xor(b: Vec2ui, res: Vec2ui) = xor(res, this, b.x, b.y)
    @JvmOverloads
    fun xor(bX: Uint, bY: Uint, res: Vec2ui = Vec2ui()) = xor(res, this, bX, bY)

    @JvmOverloads
    fun xor(bX: Int, bY: Int, res: Vec2ui = Vec2ui()) = xor(res, this, bX, bY)

    infix fun xorAssign(b: Uint) = xor(this, this, b, b)
    infix fun xorAssign(b: Int) = xor(this, this, b, b)
    infix fun xorAssign(b: Vec2ui) = xor(this, this, b.x, b.y)
    fun xorAssign(bX: Uint, bY: Uint) = xor(this, this, bX, bY)
    fun xorAssign(bX: Int, bY: Int) = xor(this, this, bX, bY)


    infix fun shl(b: Uint) = shl(Vec2ui(), this, b, b)
    infix fun shl(b: Int) = shl(Vec2ui(), this, b, b)
    infix fun shl(b: Vec2ui) = shl(Vec2ui(), this, b.x, b.y)

    fun shl(b: Uint, res: Vec2ui) = shl(res, this, b, b)
    fun shl(b: Int, res: Vec2ui) = shl(res, this, b, b)
    fun shl(b: Vec2ui, res: Vec2ui) = shl(res, this, b.x, b.y)
    @JvmOverloads
    fun shl(bX: Uint, bY: Uint, res: Vec2ui = Vec2ui()) = shl(res, this, bX, bY)

    @JvmOverloads
    fun shl(bX: Int, bY: Int, res: Vec2ui = Vec2ui()) = shl(res, this, bX, bY)

    infix fun shlAssign(b: Uint) = shl(this, this, b, b)
    infix fun shlAssign(b: Int) = shl(this, this, b, b)
    infix fun shlAssign(b: Vec2ui) = shl(this, this, b.x, b.y)
    fun shlAssign(bX: Uint, bY: Uint) = shl(this, this, bX, bY)
    fun shlAssign(bX: Int, bY: Int) = shl(this, this, bX, bY)


    infix fun shr(b: Uint) = shr(Vec2ui(), this, b, b)
    infix fun shr(b: Int) = shr(Vec2ui(), this, b, b)
    infix fun shr(b: Vec2ui) = shr(Vec2ui(), this, b.x, b.y)

    fun shr(b: Uint, res: Vec2ui) = shr(res, this, b, b)
    fun shr(b: Int, res: Vec2ui) = shr(res, this, b, b)
    fun shr(b: Vec2ui, res: Vec2ui) = shr(res, this, b.x, b.y)
    @JvmOverloads
    fun shr(bX: Uint, bY: Uint, res: Vec2ui = Vec2ui()) = shr(res, this, bX, bY)

    @JvmOverloads
    fun shr(bX: Int, bY: Int, res: Vec2ui = Vec2ui()) = shr(res, this, bX, bY)

    infix fun shrAssign(b: Uint) = shr(this, this, b, b)
    infix fun shrAssign(b: Int) = shr(this, this, b, b)
    infix fun shrAssign(b: Vec2ui) = shr(this, this, b.x, b.y)
    fun shrAssign(bX: Uint, bY: Uint) = shr(this, this, bX, bY)
    fun shrAssign(bX: Int, bY: Int) = shr(this, this, bX, bY)


    @JvmOverloads
    fun inv(res: Vec2ui = Vec2ui()) = inv(res, this)

    fun invAssign() = inv(this, this)


    // -- Generic bitwise operators --

    infix fun and(b: Number) = and(Vec2ui(), this, b.i, b.i)
    infix fun and(b: Vec2t<out Number>) = and(Vec2ui(), this, b.x.i, b.y.i)

    fun and(b: Number, res: Vec2ui) = and(res, this, b.i, b.i)
    fun and(b: Vec2t<out Number>, res: Vec2ui) = and(res, this, b.x.i, b.y.i)
    @JvmOverloads
    fun and(bX: Number, bY: Number, res: Vec2ui = Vec2ui()) = and(res, this, bX.i, bY.i)

    infix fun andAssign(b: Number) = and(this, this, b.i, b.i)
    infix fun andAssign(b: Vec2t<out Number>) = and(this, this, b.x.i, b.y.i)
    fun andAssign(bX: Number, bY: Number) = and(this, this, bX.i, bY.i)


    infix fun or(b: Number) = or(Vec2ui(), this, b.i, b.i)
    infix fun or(b: Vec2t<out Number>) = or(Vec2ui(), this, b.x.i, b.y.i)

    fun or(b: Number, res: Vec2ui) = or(res, this, b.i, b.i)
    fun or(b: Vec2t<out Number>, res: Vec2ui) = or(res, this, b.x.i, b.y.i)
    @JvmOverloads
    fun or(bX: Number, bY: Number, res: Vec2ui = Vec2ui()) = or(res, this, bX.i, bY.i)

    infix fun orAssign(b: Number) = or(this, this, b.i, b.i)
    infix fun orAssign(b: Vec2t<out Number>) = or(this, this, b.x.i, b.y.i)
    fun orAssign(bX: Number, bY: Number) = or(this, this, bX.i, bY.i)


    infix fun xor(b: Number) = xor(Vec2ui(), this, b.i, b.i)
    infix fun xor(b: Vec2t<out Number>) = xor(Vec2ui(), this, b.x.i, b.y.i)

    fun xor(b: Number, res: Vec2ui) = xor(res, this, b.i, b.i)
    fun xor(b: Vec2t<out Number>, res: Vec2ui) = xor(res, this, b.x.i, b.y.i)
    @JvmOverloads
    fun xor(bX: Number, bY: Number, res: Vec2ui = Vec2ui()) = xor(res, this, bX.i, bY.i)

    infix fun xorAssign(b: Number) = xor(this, this, b.i, b.i)
    infix fun xorAssign(b: Vec2t<out Number>) = xor(this, this, b.x.i, b.y.i)
    fun xorAssign(bX: Number, bY: Number) = xor(this, this, bX.i, bY.i)


    infix fun shl(b: Number) = shl(Vec2ui(), this, b.i, b.i)
    infix fun shl(b: Vec2t<out Number>) = shl(Vec2ui(), this, b.x.i, b.y.i)

    fun shl(b: Number, res: Vec2ui) = shl(res, this, b.i, b.i)
    fun shl(b: Vec2t<out Number>, res: Vec2ui) = shl(res, this, b.x.i, b.y.i)
    @JvmOverloads
    fun shl(bX: Number, bY: Number, res: Vec2ui = Vec2ui()) = shl(res, this, bX.i, bY.i)

    infix fun shlAssign(b: Number) = shl(this, this, b.i, b.i)
    infix fun shlAssign(b: Vec2t<out Number>) = shl(this, this, b.x.i, b.y.i)
    fun shlAssign(bX: Number, bY: Number) = shl(this, this, bX.i, bY.i)


    infix fun shr(b: Number) = shr(Vec2ui(), this, b.i, b.i)
    infix fun shr(b: Vec2t<out Number>) = shr(Vec2ui(), this, b.x.i, b.y.i)

    fun shr(b: Number, res: Vec2ui) = shr(res, this, b.i, b.i)
    fun shr(b: Vec2t<out Number>, res: Vec2ui) = shr(res, this, b.x.i, b.y.i)
    @JvmOverloads
    fun shr(bX: Number, bY: Number, res: Vec2ui = Vec2ui()) = shr(res, this, bX.i, bY.i)

    infix fun shrAssign(b: Number) = shr(this, this, b.i, b.i)
    infix fun shrAssign(b: Vec2t<out Number>) = shr(this, this, b.x.i, b.y.i)
    fun shrAssign(bX: Number, bY: Number) = shr(this, this, bX.i, bY.i)


    override fun createInstance(x: Uint, y: Uint) = Vec2ui(x, y)


    companion object : opVec2ui {
        const val length = 2
        @JvmField
        val size = length * Uint.BYTES

        @JvmStatic
        fun fromPointer(ptr: Ptr) = Vec2ui(memGetInt(ptr), memGetInt(ptr + Int.BYTES))
    }

    override fun size() = size

    override fun equals(other: Any?) = other is Vec2ui && this[0] == other[0] && this[1] == other[1]
    override fun hashCode() = 31 * x.v.hashCode() + y.v.hashCode()

    fun print(name: String = "", stream: PrintStream = System.out) = stream.println("$name [${x.v}, ${y.v}]")
    override fun toString(): String = "Vec2ui [${x.v}, ${y.v}]"
}