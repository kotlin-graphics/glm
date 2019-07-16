package glm_.vec2

import glm_.*
import glm_.vec2.operators.opVec2b
import glm_.vec3.Vec3bool
import glm_.vec3.Vec3t
import glm_.vec4.Vec4bool
import glm_.vec4.Vec4t
import kool.Ptr
import kool.pos
import org.lwjgl.system.MemoryUtil.memGetByte
import org.lwjgl.system.MemoryUtil.memPutByte
import java.io.PrintStream
import java.nio.*

/**
 * Created bY GBarbieri on 06.10.2016.
 */

class Vec2b(var ofs: Int, var array: ByteArray) : Vec2t<Byte>() {

    constructor(x: Byte, y: Byte) : this(0, byteArrayOf(x, y))

    override var x: Byte
        get() = array[ofs]
        set(value) = array.set(ofs, value)
    override var y: Byte
        get() = array[ofs + 1]
        set(value) = array.set(ofs + 1, value)

    // -- Explicit basic, conversion other main.and conversion vector constructors --

    constructor() : this(0)

    constructor(v: Vec2t<out Number>) : this(v.x, v.y)
    constructor(v: Vec3t<out Number>) : this(v.x, v.y)
    constructor(v: Vec4t<out Number>) : this(v.x, v.y)

    constructor(v: Vec2bool) : this(v.x.b, v.y.b)
    constructor(v: Vec3bool) : this(v.x.b, v.y.b)
    constructor(v: Vec4bool) : this(v.x.b, v.y.b)

    constructor(bytes: ByteArray, index: Int = 0) : this(bytes[index], bytes[index + 1])
    constructor(chars: CharArray, index: Int = 0) : this(chars[index].b, chars[index + 1].b)
    constructor(shorts: ShortArray, index: Int = 0) : this(shorts[index], shorts[index + 1])
    constructor(ints: IntArray, index: Int = 0) : this(ints[index], ints[index + 1])
    constructor(longs: LongArray, index: Int = 0) : this(longs[index], longs[index + 1])
    constructor(floats: FloatArray, index: Int = 0) : this(floats[index], floats[index + 1])
    constructor(doubles: DoubleArray, index: Int = 0) : this(doubles[index], doubles[index + 1])
    constructor(booleans: BooleanArray, index: Int = 0) : this(booleans[index].b, booleans[index + 1].b)

    constructor(numbers: Array<out Number>, index: Int = 0) : this(numbers[index], numbers[index + 1])
    constructor(chars: Array<Char>, index: Int = 0) : this(chars[index].b, chars[index + 1].b)
    constructor(booleans: Array<Boolean>, index: Int = 0) : this(booleans[index].b, booleans[index + 1].b)

    constructor(list: Iterable<*>, index: Int = 0) : this(list.elementAt(index)!!.toByte, list.elementAt(index + 1)!!.toByte)

    constructor(bytes: ByteBuffer, index: Int = bytes.pos) : this(bytes[index], bytes[index + 1])
    constructor(chars: CharBuffer, index: Int = chars.pos) : this(chars[index].b, chars[index + 1].b)
    constructor(shorts: ShortBuffer, index: Int = shorts.pos) : this(shorts[index], shorts[index + 1])
    constructor(ints: IntBuffer, index: Int = ints.pos) : this(ints[index], ints[index + 1])
    constructor(longs: LongBuffer, index: Int = longs.pos) : this(longs[index], longs[index + 1])
    constructor(floats: FloatBuffer, index: Int = floats.pos) : this(floats[index], floats[index + 1])
    constructor(doubles: DoubleBuffer, index: Int = doubles.pos) : this(doubles[index], doubles[index + 1])

    constructor(block: (Int) -> Byte) : this(block(0), block(1))

    constructor(s: Number) : this(s, s)
    constructor(x: Number, y: Number) : this(x.b, y.b)


    fun put(x: Byte, y: Byte) {
        this.x = x
        this.y = y
    }

    operator fun invoke(x: Byte, y: Byte): Vec2b {
        this.x = x
        this.y = y
        return this
    }

    override fun put(x: Number, y: Number) {
        this.x = x.b
        this.y = y.b
    }

    override operator fun invoke(x: Number, y: Number): Vec2b {
        this.x = x.b
        this.y = y.b
        return this
    }

    fun to(bytes: ByteArray, index: Int) = to(bytes, index, true)
    override fun to(bytes: ByteArray, index: Int, bigEndian: Boolean): ByteArray {
        System.arraycopy(array, ofs, bytes, index, length)
        return bytes
    }

    override fun to(buf: ByteBuffer, offset: Int): ByteBuffer {
        return buf
                .put(offset + 0, array[0])
                .put(offset + 1, array[1])
    }

    infix fun to(ptr: Ptr) {
        memPutByte(ptr, x)
        memPutByte(ptr + Byte.BYTES, y)
    }

    // -- Component accesses --

    operator fun set(index: Int, value: Byte) = when (index) {
        0 -> x = value
        1 -> y = value
        else -> throw ArrayIndexOutOfBoundsException()
    }

    override operator fun set(index: Int, value: Number) = when (index) {
        0 -> x = value.b
        1 -> y = value.b
        else -> throw ArrayIndexOutOfBoundsException()
    }


    // -- Unary arithmetic operators --

    operator fun unaryPlus() = this

    operator fun unaryMinus() = Vec2b(-x, -y)

    // -- Increment main.and decrement operators --

    operator fun inc() = plus(Vec2b(), this, 1, 1)
    infix fun inc(res: Vec2b) = plus(res, this, 1, 1)
    fun incAssign() = plus(this, this, 1, 1)


    operator fun dec() = minus(Vec2b(), this, 1, 1)
    infix fun dec(res: Vec2b) = minus(res, this, 1, 1)
    fun decAssign() = minus(this, this, 1, 1)


    // -- Specific binary arithmetic operators --

    infix operator fun plus(b: Byte) = plus(Vec2b(), this, b, b)
    infix operator fun plus(b: Int) = plus(Vec2b(), this, b, b)
    infix operator fun plus(b: Vec2b) = plus(Vec2b(), this, b.x, b.y)

    @JvmOverloads
    fun plus(bX: Byte, bY: Byte, res: Vec2b = Vec2b()) = plus(res, this, bX, bY)

    @JvmOverloads
    fun plus(bX: Int, bY: Int, res: Vec2b = Vec2b()) = plus(res, this, bX, bY)

    fun plus(b: Byte, res: Vec2b) = plus(res, this, b, b)
    fun plus(b: Int, res: Vec2b) = plus(res, this, b, b)
    fun plus(b: Vec2b, res: Vec2b) = plus(res, this, b.x, b.y)

    fun plusAssign(bX: Byte, bY: Byte) = plus(this, this, bX, bY)
    fun plusAssign(bX: Int, bY: Int) = plus(this, this, bX, bY)
    infix operator fun plusAssign(b: Byte) {
        plus(this, this, b, b)
    }

    infix operator fun plusAssign(b: Int) {
        plus(this, this, b, b)
    }

    infix operator fun plusAssign(b: Vec2b) {
        plus(this, this, b.x, b.y)
    }


    infix operator fun minus(b: Byte) = minus(Vec2b(), this, b, b)
    infix operator fun minus(b: Int) = minus(Vec2b(), this, b, b)
    infix operator fun minus(b: Vec2b) = minus(Vec2b(), this, b.x, b.y)

    @JvmOverloads
    fun minus(bX: Byte, bY: Byte, res: Vec2b = Vec2b()) = minus(res, this, bX, bY)

    @JvmOverloads
    fun minus(bX: Int, bY: Int, res: Vec2b = Vec2b()) = minus(res, this, bX, bY)

    fun minus(b: Byte, res: Vec2b) = minus(res, this, b, b)
    fun minus(b: Int, res: Vec2b) = minus(res, this, b, b)
    fun minus(b: Vec2b, res: Vec2b) = minus(res, this, b.x, b.y)

    fun minusAssign(bX: Byte, bY: Byte) = minus(this, this, bX, bY)
    fun minusAssign(bX: Int, bY: Int) = minus(this, this, bX, bY)
    infix operator fun minusAssign(b: Byte) {
        minus(this, this, b, b)
    }

    infix operator fun minusAssign(b: Int) {
        minus(this, this, b, b)
    }

    infix operator fun minusAssign(b: Vec2b) {
        minus(this, this, b.x, b.y)
    }


    infix operator fun times(b: Byte) = times(Vec2b(), this, b, b)
    infix operator fun times(b: Int) = times(Vec2b(), this, b, b)
    infix operator fun times(b: Vec2b) = times(Vec2b(), this, b.x, b.y)

    @JvmOverloads
    fun times(bX: Byte, bY: Byte, res: Vec2b = Vec2b()) = times(res, this, bX, bY)

    @JvmOverloads
    fun times(bX: Int, bY: Int, res: Vec2b = Vec2b()) = times(res, this, bX, bY)

    fun times(b: Byte, res: Vec2b) = times(res, this, b, b)
    fun times(b: Int, res: Vec2b) = times(res, this, b, b)
    fun times(b: Vec2b, res: Vec2b) = times(res, this, b.x, b.y)

    fun timesAssign(bX: Byte, bY: Byte) = times(this, this, bX, bY)
    fun timesAssign(bX: Int, bY: Int) = times(this, this, bX, bY)
    infix operator fun timesAssign(b: Byte) {
        times(this, this, b, b)
    }

    infix operator fun timesAssign(b: Int) {
        times(this, this, b, b)
    }

    infix operator fun timesAssign(b: Vec2b) {
        times(this, this, b.x, b.y)
    }


    infix operator fun div(b: Byte) = div(Vec2b(), this, b, b)
    infix operator fun div(b: Int) = div(Vec2b(), this, b, b)
    infix operator fun div(b: Vec2b) = div(Vec2b(), this, b.x, b.y)

    @JvmOverloads
    fun div(bX: Byte, bY: Byte, res: Vec2b = Vec2b()) = div(res, this, bX, bY)

    @JvmOverloads
    fun div(bX: Int, bY: Int, res: Vec2b = Vec2b()) = div(res, this, bX, bY)

    fun div(b: Byte, res: Vec2b) = div(res, this, b, b)
    fun div(b: Int, res: Vec2b) = div(res, this, b, b)
    fun div(b: Vec2b, res: Vec2b) = div(res, this, b.x, b.y)

    fun divAssign(bX: Byte, bY: Byte) = div(this, this, bX, bY)
    fun divAssign(bX: Int, bY: Int) = div(this, this, bX, bY)
    infix operator fun divAssign(b: Byte) {
        div(this, this, b, b)
    }

    infix operator fun divAssign(b: Int) {
        div(this, this, b, b)
    }

    infix operator fun divAssign(b: Vec2b) {
        div(this, this, b.x, b.y)
    }


    infix operator fun rem(b: Byte) = rem(Vec2b(), this, b, b)
    infix operator fun rem(b: Int) = rem(Vec2b(), this, b, b)
    infix operator fun rem(b: Vec2b) = rem(Vec2b(), this, b.x, b.y)

    @JvmOverloads
    fun rem(bX: Byte, bY: Byte, res: Vec2b = Vec2b()) = rem(res, this, bX, bY)

    @JvmOverloads
    fun rem(bX: Int, bY: Int, res: Vec2b = Vec2b()) = rem(res, this, bX, bY)

    fun rem(b: Byte, res: Vec2b) = rem(res, this, b, b)
    fun rem(b: Int, res: Vec2b) = rem(res, this, b, b)
    fun rem(b: Vec2b, res: Vec2b) = rem(res, this, b.x, b.y)

    fun remAssign(bX: Byte, bY: Byte) = rem(this, this, bX, bY)
    fun remAssign(bX: Int, bY: Int) = rem(this, this, bX, bY)
    infix operator fun remAssign(b: Byte) {
        rem(this, this, b, b)
    }

    infix operator fun remAssign(b: Int) {
        rem(this, this, b, b)
    }

    infix operator fun remAssign(b: Vec2b) {
        rem(this, this, b.x, b.y)
    }


    // -- Generic binary arithmetic infix operators --

    infix operator fun plus(b: Number) = plus(Vec2b(), this, b.i, b.i)
    infix operator fun plus(b: Vec2t<out Number>) = plus(Vec2b(), this, b.x.i, b.y.i)

    @JvmOverloads
    fun plus(bX: Number, bY: Number, res: Vec2b = Vec2b()) = plus(res, this, bX.i, bY.i)

    fun plus(b: Number, res: Vec2b) = plus(res, this, b.i, b.i)
    fun plus(b: Vec2t<out Number>, res: Vec2b) = plus(res, this, b.x.i, b.y.i)

    fun plusAssign(bX: Number, bY: Number) = plus(this, this, bX.i, bY.i)
    infix operator fun plusAssign(b: Number) {
        plus(this, this, b.i, b.i)
    }

    infix operator fun plusAssign(b: Vec2t<out Number>) {
        plus(this, this, b.x.i, b.y.i)
    }


    infix operator fun minus(b: Number) = minus(Vec2b(), this, b.i, b.i)
    infix operator fun minus(b: Vec2t<out Number>) = minus(Vec2b(), this, b.x.i, b.y.i)

    @JvmOverloads
    fun minus(bX: Number, bY: Number, res: Vec2b = Vec2b()) = minus(res, this, bX.i, bY.i)

    fun minus(b: Number, res: Vec2b) = minus(res, this, b.i, b.i)
    fun minus(b: Vec2t<out Number>, res: Vec2b) = minus(res, this, b.x.i, b.y.i)

    fun minusAssign(bX: Number, bY: Number) = minus(this, this, bX.i, bY.i)
    infix operator fun minusAssign(b: Number) {
        minus(this, this, b.i, b.i)
    }

    infix operator fun minusAssign(b: Vec2t<out Number>) {
        minus(this, this, b.x.i, b.y.i)
    }


    infix operator fun times(b: Number) = times(Vec2b(), this, b.i, b.i)
    infix operator fun times(b: Vec2t<out Number>) = times(Vec2b(), this, b.x.i, b.y.i)

    @JvmOverloads
    fun times(bX: Number, bY: Number, res: Vec2b = Vec2b()) = times(res, this, bX.i, bY.i)

    fun times(b: Number, res: Vec2b) = times(res, this, b.i, b.i)
    fun times(b: Vec2t<out Number>, res: Vec2b) = times(res, this, b.x.i, b.y.i)

    fun timesAssign(bX: Number, bY: Number) = times(this, this, bX.i, bY.i)
    infix operator fun timesAssign(b: Number) {
        times(this, this, b.i, b.i)
    }

    infix operator fun timesAssign(b: Vec2t<out Number>) {
        times(this, this, b.x.i, b.y.i)
    }


    infix operator fun div(b: Number) = div(Vec2b(), this, b.i, b.i)
    infix operator fun div(b: Vec2t<out Number>) = div(Vec2b(), this, b.x.i, b.y.i)

    @JvmOverloads
    fun div(bX: Number, bY: Number, res: Vec2b = Vec2b()) = div(res, this, bX.i, bY.i)

    fun div(b: Number, res: Vec2b) = div(res, this, b.i, b.i)
    fun div(b: Vec2t<out Number>, res: Vec2b) = div(res, this, b.x.i, b.y.i)

    fun divAssign(bX: Number, bY: Number) = div(this, this, bX.i, bY.i)
    infix operator fun divAssign(b: Number) {
        div(this, this, b.i, b.i)
    }

    infix operator fun divAssign(b: Vec2t<out Number>) {
        div(this, this, b.x.i, b.y.i)
    }


    infix operator fun rem(b: Number) = rem(Vec2b(), this, b.i, b.i)
    infix operator fun rem(b: Vec2t<out Number>) = rem(Vec2b(), this, b.x.i, b.y.i)

    @JvmOverloads
    fun rem(bX: Number, bY: Number, res: Vec2b = Vec2b()) = rem(res, this, bX.i, bY.i)

    fun rem(b: Number, res: Vec2b) = rem(res, this, b.i, b.i)
    fun rem(b: Vec2t<out Number>, res: Vec2b) = rem(res, this, b.x.i, b.y.i)

    fun remAssign(bX: Number, bY: Number) = rem(this, this, bX.i, bY.i)
    infix operator fun remAssign(b: Number) {
        rem(this, this, b.i, b.i)
    }

    infix operator fun remAssign(b: Vec2t<out Number>) {
        rem(this, this, b.x.i, b.y.i)
    }


    // -- Specific bitwise operators --

    infix fun and(b: Byte) = and(Vec2b(), this, b, b)
    infix fun and(b: Int) = and(Vec2b(), this, b, b)
    infix fun and(b: Vec2b) = and(Vec2b(), this, b.x, b.y)

    fun and(b: Byte, res: Vec2b) = and(res, this, b, b)
    fun and(b: Int, res: Vec2b) = and(res, this, b, b)
    fun and(b: Vec2b, res: Vec2b) = and(res, this, b.x, b.y)
    @JvmOverloads
    fun and(bX: Byte, bY: Byte, res: Vec2b = Vec2b()) = and(res, this, bX, bY)

    @JvmOverloads
    fun and(bX: Int, bY: Int, res: Vec2b = Vec2b()) = and(res, this, bX, bY)

    infix fun andAssign(b: Byte) = and(this, this, b, b)
    infix fun andAssign(b: Int) = and(this, this, b, b)
    infix fun andAssign(b: Vec2b) = and(this, this, b.x, b.y)
    fun andAssign(bX: Byte, bY: Byte) = and(this, this, bX, bY)
    fun andAssign(bX: Int, bY: Int) = and(this, this, bX, bY)


    infix fun or(b: Byte) = or(Vec2b(), this, b, b)
    infix fun or(b: Int) = or(Vec2b(), this, b, b)
    infix fun or(b: Vec2b) = or(Vec2b(), this, b.x, b.y)

    fun or(b: Byte, res: Vec2b) = or(res, this, b, b)
    fun or(b: Int, res: Vec2b) = or(res, this, b, b)
    fun or(b: Vec2b, res: Vec2b) = or(res, this, b.x, b.y)
    @JvmOverloads
    fun or(bX: Byte, bY: Byte, res: Vec2b = Vec2b()) = or(res, this, bX, bY)

    @JvmOverloads
    fun or(bX: Int, bY: Int, res: Vec2b = Vec2b()) = or(res, this, bX, bY)

    infix fun orAssign(b: Byte) = or(this, this, b, b)
    infix fun orAssign(b: Int) = or(this, this, b, b)
    infix fun orAssign(b: Vec2b) = or(this, this, b.x, b.y)
    fun orAssign(bX: Byte, bY: Byte) = or(this, this, bX, bY)
    fun orAssign(bX: Int, bY: Int) = or(this, this, bX, bY)


    infix fun xor(b: Byte) = xor(Vec2b(), this, b, b)
    infix fun xor(b: Int) = xor(Vec2b(), this, b, b)
    infix fun xor(b: Vec2b) = xor(Vec2b(), this, b.x, b.y)

    fun xor(b: Byte, res: Vec2b) = xor(res, this, b, b)
    fun xor(b: Int, res: Vec2b) = xor(res, this, b, b)
    fun xor(b: Vec2b, res: Vec2b) = xor(res, this, b.x, b.y)
    @JvmOverloads
    fun xor(bX: Byte, bY: Byte, res: Vec2b = Vec2b()) = xor(res, this, bX, bY)

    @JvmOverloads
    fun xor(bX: Int, bY: Int, res: Vec2b = Vec2b()) = xor(res, this, bX, bY)

    infix fun xorAssign(b: Byte) = xor(this, this, b, b)
    infix fun xorAssign(b: Int) = xor(this, this, b, b)
    infix fun xorAssign(b: Vec2b) = xor(this, this, b.x, b.y)
    fun xorAssign(bX: Byte, bY: Byte) = xor(this, this, bX, bY)
    fun xorAssign(bX: Int, bY: Int) = xor(this, this, bX, bY)


    infix fun shl(b: Byte) = shl(Vec2b(), this, b, b)
    infix fun shl(b: Int) = shl(Vec2b(), this, b, b)
    infix fun shl(b: Vec2b) = shl(Vec2b(), this, b.x, b.y)

    fun shl(b: Byte, res: Vec2b) = shl(res, this, b, b)
    fun shl(b: Int, res: Vec2b) = shl(res, this, b, b)
    fun shl(b: Vec2b, res: Vec2b) = shl(res, this, b.x, b.y)
    @JvmOverloads
    fun shl(bX: Byte, bY: Byte, res: Vec2b = Vec2b()) = shl(res, this, bX, bY)

    @JvmOverloads
    fun shl(bX: Int, bY: Int, res: Vec2b = Vec2b()) = shl(res, this, bX, bY)

    infix fun shlAssign(b: Byte) = shl(this, this, b, b)
    infix fun shlAssign(b: Int) = shl(this, this, b, b)
    infix fun shlAssign(b: Vec2b) = shl(this, this, b.x, b.y)
    fun shlAssign(bX: Byte, bY: Byte) = shl(this, this, bX, bY)
    fun shlAssign(bX: Int, bY: Int) = shl(this, this, bX, bY)


    infix fun shr(b: Byte) = shr(Vec2b(), this, b, b)
    infix fun shr(b: Int) = shr(Vec2b(), this, b, b)
    infix fun shr(b: Vec2b) = shr(Vec2b(), this, b.x, b.y)

    fun shr(b: Byte, res: Vec2b) = shr(res, this, b, b)
    fun shr(b: Int, res: Vec2b) = shr(res, this, b, b)
    fun shr(b: Vec2b, res: Vec2b) = shr(res, this, b.x, b.y)
    @JvmOverloads
    fun shr(bX: Byte, bY: Byte, res: Vec2b = Vec2b()) = shr(res, this, bX, bY)

    @JvmOverloads
    fun shr(bX: Int, bY: Int, res: Vec2b = Vec2b()) = shr(res, this, bX, bY)

    infix fun shrAssign(b: Byte) = shr(this, this, b, b)
    infix fun shrAssign(b: Int) = shr(this, this, b, b)
    infix fun shrAssign(b: Vec2b) = shr(this, this, b.x, b.y)
    fun shrAssign(bX: Byte, bY: Byte) = shr(this, this, bX, bY)
    fun shrAssign(bX: Int, bY: Int) = shr(this, this, bX, bY)


    @JvmOverloads
    fun inv(res: Vec2b = Vec2b()) = inv(res, this)

    fun invAssign() = inv(this, this)


    // -- Generic bitwise operators --

    infix fun and(b: Number) = and(Vec2b(), this, b.b, b.b)
    infix fun and(b: Vec2t<out Number>) = and(Vec2b(), this, b.x.b, b.y.b)

    fun and(b: Number, res: Vec2b) = and(res, this, b.b, b.b)
    fun and(b: Vec2t<out Number>, res: Vec2b) = and(res, this, b.x.b, b.y.b)
    @JvmOverloads
    fun and(bX: Number, bY: Number, res: Vec2b = Vec2b()) = and(res, this, bX.b, bY.b)

    infix fun andAssign(b: Number) = and(this, this, b.b, b.b)
    infix fun andAssign(b: Vec2t<out Number>) = and(this, this, b.x.b, b.y.b)
    fun andAssign(bX: Number, bY: Number) = and(this, this, bX.b, bY.b)


    infix fun or(b: Number) = or(Vec2b(), this, b.b, b.b)
    infix fun or(b: Vec2t<out Number>) = or(Vec2b(), this, b.x.b, b.y.b)

    fun or(b: Number, res: Vec2b) = or(res, this, b.b, b.b)
    fun or(b: Vec2t<out Number>, res: Vec2b) = or(res, this, b.x.b, b.y.b)
    @JvmOverloads
    fun or(bX: Number, bY: Number, res: Vec2b = Vec2b()) = or(res, this, bX.b, bY.b)

    infix fun orAssign(b: Number) = or(this, this, b.b, b.b)
    infix fun orAssign(b: Vec2t<out Number>) = or(this, this, b.x.b, b.y.b)
    fun orAssign(bX: Number, bY: Number) = or(this, this, bX.b, bY.b)


    infix fun xor(b: Number) = xor(Vec2b(), this, b.b, b.b)
    infix fun xor(b: Vec2t<out Number>) = xor(Vec2b(), this, b.x.b, b.y.b)

    fun xor(b: Number, res: Vec2b) = xor(res, this, b.b, b.b)
    fun xor(b: Vec2t<out Number>, res: Vec2b) = xor(res, this, b.x.b, b.y.b)
    @JvmOverloads
    fun xor(bX: Number, bY: Number, res: Vec2b = Vec2b()) = xor(res, this, bX.b, bY.b)

    infix fun xorAssign(b: Number) = xor(this, this, b.b, b.b)
    infix fun xorAssign(b: Vec2t<out Number>) = xor(this, this, b.x.b, b.y.b)
    fun xorAssign(bX: Number, bY: Number) = xor(this, this, bX.b, bY.b)


    infix fun shl(b: Number) = shl(Vec2b(), this, b.b, b.b)
    infix fun shl(b: Vec2t<out Number>) = shl(Vec2b(), this, b.x.b, b.y.b)

    fun shl(b: Number, res: Vec2b) = shl(res, this, b.b, b.b)
    fun shl(b: Vec2t<out Number>, res: Vec2b) = shl(res, this, b.x.b, b.y.b)
    @JvmOverloads
    fun shl(bX: Number, bY: Number, res: Vec2b = Vec2b()) = shl(res, this, bX.b, bY.b)

    infix fun shlAssign(b: Number) = shl(this, this, b.b, b.b)
    infix fun shlAssign(b: Vec2t<out Number>) = shl(this, this, b.x.b, b.y.b)
    fun shlAssign(bX: Number, bY: Number) = shl(this, this, bX.b, bY.b)


    infix fun shr(b: Number) = shr(Vec2b(), this, b.b, b.b)
    infix fun shr(b: Vec2t<out Number>) = shr(Vec2b(), this, b.x.b, b.y.b)

    fun shr(b: Number, res: Vec2b) = shr(res, this, b.b, b.b)
    fun shr(b: Vec2t<out Number>, res: Vec2b) = shr(res, this, b.x.b, b.y.b)
    @JvmOverloads
    fun shr(bX: Number, bY: Number, res: Vec2b = Vec2b()) = shr(res, this, bX.b, bY.b)

    infix fun shrAssign(b: Number) = shr(this, this, b.b, b.b)
    infix fun shrAssign(b: Vec2t<out Number>) = shr(this, this, b.x.b, b.y.b)
    fun shrAssign(bX: Number, bY: Number) = shr(this, this, bX.b, bY.b)


    override fun createInstance(x: Byte, y: Byte) = Vec2b(x, y)


    companion object : opVec2b {
        const val length = Vec2t.length
        @JvmField
        val size = length * Byte.BYTES

        @JvmStatic
        fun fromPointer(ptr: Ptr) = Vec2b(memGetByte(ptr), memGetByte(ptr + Byte.BYTES))
    }

    override fun size() = size

    override fun equals(other: Any?) = other is Vec2b && this[0] == other[0] && this[1] == other[1]
    override fun hashCode() = 31 * x.hashCode() + y.hashCode()

    @JvmOverloads
    fun print(name: String = "", stream: PrintStream = System.out) = stream.print("$name$this")

    @JvmOverloads
    fun println(name: String = "", stream: PrintStream = System.out) = stream.println("$name$this")

    override fun toString(): String = "[$x, $y]"
}