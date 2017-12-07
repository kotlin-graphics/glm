package glm_.vec2

import glm_.*
import glm_.vec2.operators.opVec2ub
import glm_.vec3.Vec3bool
import glm_.vec3.Vec3t
import glm_.vec4.Vec4bool
import glm_.vec4.Vec4t
import unsigned.Ubyte
import java.nio.*

/**
 * Created by elect on 07/10/16.
 */

class Vec2ub(x: Ubyte, y: Ubyte) : Vec2t<Ubyte>(x, y) {

    // -- Explicit basic, conversion other main.and conversion vector constructors --

    constructor() : this(0)

    constructor(v: Vec2t<out Number>) : this(v.x, v.y)
    constructor(v: Vec3t<out Number>) : this(v.x, v.y)
    constructor(v: Vec4t<out Number>) : this(v.x, v.y)

    constructor(v: Vec2bool) : this(v.x.ub, v.y.ub)
    constructor(v: Vec3bool) : this(v.x.ub, v.y.ub)
    constructor(v: Vec4bool) : this(v.x.ub, v.y.ub)

    constructor(bytes: ByteArray, index: Int = 0) : this(bytes[index], bytes[index + 1])
    constructor(chars: CharArray, index: Int = 0) : this(chars[index].ub, chars[index + 1].ub)
    constructor(shorts: ShortArray, index: Int = 0) : this(shorts[index], shorts[index + 1])
    constructor(ints: IntArray, index: Int = 0) : this(ints[index], ints[index + 1])
    constructor(longs: LongArray, index: Int = 0) : this(longs[index], longs[index + 1])
    constructor(floats: FloatArray, index: Int = 0) : this(floats[index], floats[index + 1])
    constructor(doubles: DoubleArray, index: Int = 0) : this(doubles[index], doubles[index + 1])
    constructor(booleans: BooleanArray, index: Int = 0) : this(booleans[index].ub, booleans[index + 1].ub)

    constructor(numbers: Array<out Number>, index: Int = 0) : this(numbers[index], numbers[index + 1])
    constructor(chars: Array<Char>, index: Int = 0) : this(chars[index].ub, chars[index + 1].ub)
    constructor(booleans: Array<Boolean>, index: Int = 0) : this(booleans[index].ub, booleans[index + 1].ub)

    constructor(list: List<Any>, index: Int = 0) : this(list[index].toByte, list[index + 1].toByte) // TODO ub kuns

    constructor(bytes: ByteBuffer, index: Int = bytes.position()) : this(bytes[index], bytes[index + 1])
    constructor(chars: CharBuffer, index: Int = chars.position()) : this(chars[index].ub, chars[index + 1].ub)
    constructor(shorts: ShortBuffer, index: Int = shorts.position()) : this(shorts[index], shorts[index + 1])
    constructor(ints: IntBuffer, index: Int = ints.position()) : this(ints[index], ints[index + 1])
    constructor(longs: LongBuffer, index: Int = longs.position()) : this(longs[index], longs[index + 1])
    constructor(floats: FloatBuffer, index: Int = floats.position()) : this(floats[index], floats[index + 1])
    constructor(doubles: DoubleBuffer, index: Int = doubles.position()) : this(doubles[index], doubles[index + 1])

    constructor(block: (Int) -> Ubyte) : this(block(0), block(1))

    constructor(s: Number) : this(s, s)
    constructor(x: Number, y: Number) : this(x.ub, y.ub)


    override fun put(x: Number, y: Number): Vec2ub {
        this.x = x.ub
        this.y = y.ub
        return this
    }


    infix fun to(bytes: ByteArray) = to(bytes, 0)
    fun to(bytes: ByteArray, index: Int): ByteArray {
        bytes[index] = x.v
        bytes[index + 1] = y.v
        return bytes
    }

    infix fun to(bytes: ByteBuffer) = to(bytes, bytes.position())
    fun to(bytes: ByteBuffer, offset: Int): ByteBuffer {
        bytes.put(offset, x.v)
        bytes.put(offset + Byte.BYTES, y.v)
        return bytes
    }


    // -- Component accesses --

    override operator fun get(i: Int) = when (i) {
        0 -> x
        1 -> y
        else -> throw ArrayIndexOutOfBoundsException()
    }

    operator fun set(i: Int, s: Number) = when (i) {
        0 -> x = s.ub
        1 -> y = s.ub
        else -> throw ArrayIndexOutOfBoundsException()
    }


    companion object : opVec2ub() {
        @JvmField
        val length = 2
        @JvmField
        val size = length * Ubyte.BYTES
    }


    // -- Unary arithmetic operators --

    operator fun unaryPlus() = this

    // no unaryMinus operator, only signed

    // -- Increment main.and decrement operators --

    operator fun inc() = plus(Vec2ub(), this, 1, 1)
    infix fun inc(res: Vec2ub) = plus(res, this, 1, 1)
    fun incAssign() = plus(this, this, 1, 1)


    operator fun dec() = minus(Vec2ub(), this, 1, 1)
    infix fun dec(res: Vec2ub) = minus(res, this, 1, 1)
    fun decAssign() = minus(this, this, 1, 1)


    // -- Specific binary arithmetic operators --

    infix operator fun plus(b: Ubyte) = plus(Vec2ub(), this, b, b)
    infix operator fun plus(b: Byte) = plus(Vec2ub(), this, b, b)
    infix operator fun plus(b: Int) = plus(Vec2ub(), this, b, b)
    infix operator fun plus(b: Vec2ub) = plus(Vec2ub(), this, b.x, b.y)

    @JvmOverloads
    fun plus(bX: Ubyte, bY: Ubyte, res: Vec2ub = Vec2ub()) = plus(res, this, bX, bY)

    @JvmOverloads
    fun plus(bX: Byte, bY: Byte, res: Vec2ub = Vec2ub()) = plus(res, this, bX, bY)

    @JvmOverloads
    fun plus(bX: Int, bY: Int, res: Vec2ub = Vec2ub()) = plus(res, this, bX, bY)

    fun plus(b: Ubyte, res: Vec2ub) = plus(res, this, b, b)
    fun plus(b: Byte, res: Vec2ub) = plus(res, this, b, b)
    fun plus(b: Int, res: Vec2ub) = plus(res, this, b, b)
    fun plus(b: Vec2ub, res: Vec2ub) = plus(res, this, b.x, b.y)

    fun plusAssign(bX: Ubyte, bY: Ubyte) = plus(this, this, bX, bY)
    fun plusAssign(bX: Byte, bY: Byte) = plus(this, this, bX, bY)
    fun plusAssign(bX: Int, bY: Int) = plus(this, this, bX, bY)
    infix operator fun plusAssign(b: Ubyte) {
        plus(this, this, b, b)
    }
    infix operator fun plusAssign(b: Byte) {
        plus(this, this, b, b)
    }
    infix operator fun plusAssign(b: Int) {
        plus(this, this, b, b)
    }
    infix operator fun plusAssign(b: Vec2ub) {
        plus(this, this, b.x, b.y)
    }


    infix operator fun minus(b: Ubyte) = minus(Vec2ub(), this, b, b)
    infix operator fun minus(b: Byte) = minus(Vec2ub(), this, b, b)
    infix operator fun minus(b: Int) = minus(Vec2ub(), this, b, b)
    infix operator fun minus(b: Vec2ub) = minus(Vec2ub(), this, b.x, b.y)

    @JvmOverloads
    fun minus(bX: Ubyte, bY: Ubyte, res: Vec2ub = Vec2ub()) = minus(res, this, bX, bY)

    @JvmOverloads
    fun minus(bX: Byte, bY: Byte, res: Vec2ub = Vec2ub()) = minus(res, this, bX, bY)

    @JvmOverloads
    fun minus(bX: Int, bY: Int, res: Vec2ub = Vec2ub()) = minus(res, this, bX, bY)

    fun minus(b: Ubyte, res: Vec2ub) = minus(res, this, b, b)
    fun minus(b: Byte, res: Vec2ub) = minus(res, this, b, b)
    fun minus(b: Int, res: Vec2ub) = minus(res, this, b, b)
    fun minus(b: Vec2ub, res: Vec2ub) = minus(res, this, b.x, b.y)

    fun minusAssign(bX: Ubyte, bY: Ubyte) = minus(this, this, bX, bY)
    fun minusAssign(bX: Byte, bY: Byte) = minus(this, this, bX, bY)
    fun minusAssign(bX: Int, bY: Int) = minus(this, this, bX, bY)
    infix operator fun minusAssign(b: Ubyte) {
        minus(this, this, b, b)
    }
    infix operator fun minusAssign(b: Byte) {
        minus(this, this, b, b)
    }
    infix operator fun minusAssign(b: Int) {
        minus(this, this, b, b)
    }
    infix operator fun minusAssign(b: Vec2ub) {
        minus(this, this, b.x, b.y)
    }


    infix operator fun times(b: Ubyte) = times(Vec2ub(), this, b, b)
    infix operator fun times(b: Byte) = times(Vec2ub(), this, b, b)
    infix operator fun times(b: Int) = times(Vec2ub(), this, b, b)
    infix operator fun times(b: Vec2ub) = times(Vec2ub(), this, b.x, b.y)

    @JvmOverloads
    fun times(bX: Ubyte, bY: Ubyte, res: Vec2ub = Vec2ub()) = times(res, this, bX, bY)

    @JvmOverloads
    fun times(bX: Byte, bY: Byte, res: Vec2ub = Vec2ub()) = times(res, this, bX, bY)

    @JvmOverloads
    fun times(bX: Int, bY: Int, res: Vec2ub = Vec2ub()) = times(res, this, bX, bY)

    fun times(b: Ubyte, res: Vec2ub) = times(res, this, b, b)
    fun times(b: Byte, res: Vec2ub) = times(res, this, b, b)
    fun times(b: Int, res: Vec2ub) = times(res, this, b, b)
    fun times(b: Vec2ub, res: Vec2ub) = times(res, this, b.x, b.y)

    fun timesAssign(bX: Ubyte, bY: Ubyte) = times(this, this, bX, bY)
    fun timesAssign(bX: Byte, bY: Byte) = times(this, this, bX, bY)
    fun timesAssign(bX: Int, bY: Int) = times(this, this, bX, bY)
    infix operator fun timesAssign(b: Ubyte) {
        times(this, this, b, b)
    }
    infix operator fun timesAssign(b: Byte) {
        times(this, this, b, b)
    }
    infix operator fun timesAssign(b: Int) {
        times(this, this, b, b)
    }
    infix operator fun timesAssign(b: Vec2ub) {
        times(this, this, b.x, b.y)
    }


    infix operator fun div(b: Ubyte) = div(Vec2ub(), this, b, b)
    infix operator fun div(b: Byte) = div(Vec2ub(), this, b, b)
    infix operator fun div(b: Int) = div(Vec2ub(), this, b, b)
    infix operator fun div(b: Vec2ub) = div(Vec2ub(), this, b.x, b.y)

    @JvmOverloads
    fun div(bX: Ubyte, bY: Ubyte, res: Vec2ub = Vec2ub()) = div(res, this, bX, bY)

    @JvmOverloads
    fun div(bX: Byte, bY: Byte, res: Vec2ub = Vec2ub()) = div(res, this, bX, bY)

    @JvmOverloads
    fun div(bX: Int, bY: Int, res: Vec2ub = Vec2ub()) = div(res, this, bX, bY)

    fun div(b: Ubyte, res: Vec2ub) = div(res, this, b, b)
    fun div(b: Byte, res: Vec2ub) = div(res, this, b, b)
    fun div(b: Int, res: Vec2ub) = div(res, this, b, b)
    fun div(b: Vec2ub, res: Vec2ub) = div(res, this, b.x, b.y)

    fun divAssign(bX: Ubyte, bY: Ubyte) = div(this, this, bX, bY)
    fun divAssign(bX: Byte, bY: Byte) = div(this, this, bX, bY)
    fun divAssign(bX: Int, bY: Int) = div(this, this, bX, bY)
    infix operator fun divAssign(b: Ubyte) {
        div(this, this, b, b)
    }
    infix operator fun divAssign(b: Byte) {
        div(this, this, b, b)
    }
    infix operator fun divAssign(b: Int) {
        div(this, this, b, b)
    }
    infix operator fun divAssign(b: Vec2ub) {
        div(this, this, b.x, b.y)
    }


    infix operator fun rem(b: Ubyte) = rem(Vec2ub(), this, b, b)
    infix operator fun rem(b: Byte) = rem(Vec2ub(), this, b, b)
    infix operator fun rem(b: Int) = rem(Vec2ub(), this, b, b)
    infix operator fun rem(b: Vec2ub) = rem(Vec2ub(), this, b.x, b.y)

    @JvmOverloads
    fun rem(bX: Ubyte, bY: Ubyte, res: Vec2ub = Vec2ub()) = rem(res, this, bX, bY)

    @JvmOverloads
    fun rem(bX: Byte, bY: Byte, res: Vec2ub = Vec2ub()) = rem(res, this, bX, bY)

    @JvmOverloads
    fun rem(bX: Int, bY: Int, res: Vec2ub = Vec2ub()) = rem(res, this, bX, bY)

    fun rem(b: Ubyte, res: Vec2ub) = rem(res, this, b, b)
    fun rem(b: Byte, res: Vec2ub) = rem(res, this, b, b)
    fun rem(b: Int, res: Vec2ub) = rem(res, this, b, b)
    fun rem(b: Vec2ub, res: Vec2ub) = rem(res, this, b.x, b.y)

    fun remAssign(bX: Ubyte, bY: Ubyte) = rem(this, this, bX, bY)
    fun remAssign(bX: Byte, bY: Byte) = rem(this, this, bX, bY)
    fun remAssign(bX: Int, bY: Int) = rem(this, this, bX, bY)
    infix operator fun remAssign(b: Ubyte) {
        rem(this, this, b, b)
    }
    infix operator fun remAssign(b: Byte) {
        rem(this, this, b, b)
    }
    infix operator fun remAssign(b: Int) {
        rem(this, this, b, b)
    }
    infix operator fun remAssign(b: Vec2ub) {
        rem(this, this, b.x, b.y)
    }


    // -- Generic binary arithmetic operators --

    infix operator fun plus(b: Number) = plus(Vec2ub(), this, b.i, b.i)
    infix operator fun plus(b: Vec2t<out Number>) = plus(Vec2ub(), this, b.x.i, b.y.i)

    @JvmOverloads
    fun plus(bX: Number, bY: Number, res: Vec2ub = Vec2ub()) = plus(res, this, bX.i, bY.i)

    fun plus(b: Number, res: Vec2ub) = plus(res, this, b.i, b.i)
    fun plus(b: Vec2t<out Number>, res: Vec2ub) = plus(res, this, b.x.i, b.y.i)

    fun plusAssign(bX: Number, bY: Number) = plus(this, this, bX.i, bY.i)
    infix operator fun plusAssign(b: Number) {
        plus(this, this, b.i, b.i)
    }
    infix operator fun plusAssign(b: Vec2t<out Number>) {
        plus(this, this, b.x.i, b.y.i)
    }


    infix operator fun minus(b: Number) = minus(Vec2ub(), this, b.i, b.i)
    infix operator fun minus(b: Vec2t<out Number>) = minus(Vec2ub(), this, b.x.i, b.y.i)

    @JvmOverloads
    fun minus(bX: Number, bY: Number, res: Vec2ub = Vec2ub()) = minus(res, this, bX.i, bY.i)

    fun minus(b: Number, res: Vec2ub) = minus(res, this, b.i, b.i)
    fun minus(b: Vec2t<out Number>, res: Vec2ub) = minus(res, this, b.x.i, b.y.i)

    fun minusAssign(bX: Number, bY: Number) = minus(this, this, bX.i, bY.i)
    infix operator fun minusAssign(b: Number) {
        minus(this, this, b.i, b.i)
    }
    infix operator fun minusAssign(b: Vec2t<out Number>) {
        minus(this, this, b.x.i, b.y.i)
    }


    infix operator fun times(b: Number) = times(Vec2ub(), this, b.i, b.i)
    infix operator fun times(b: Vec2t<out Number>) = times(Vec2ub(), this, b.x.i, b.y.i)

    @JvmOverloads
    fun times(bX: Number, bY: Number, res: Vec2ub = Vec2ub()) = times(res, this, bX.i, bY.i)

    fun times(b: Number, res: Vec2ub) = times(res, this, b.i, b.i)
    fun times(b: Vec2t<out Number>, res: Vec2ub) = times(res, this, b.x.i, b.y.i)

    fun timesAssign(bX: Number, bY: Number) = times(this, this, bX.i, bY.i)
    infix operator fun timesAssign(b: Number) {
        times(this, this, b.i, b.i)
    }
    infix operator fun timesAssign(b: Vec2t<out Number>) {
        times(this, this, b.x.i, b.y.i)
    }


    infix operator fun div(b: Number) = div(Vec2ub(), this, b.i, b.i)
    infix operator fun div(b: Vec2t<out Number>) = div(Vec2ub(), this, b.x.i, b.y.i)

    @JvmOverloads
    fun div(bX: Number, bY: Number, res: Vec2ub = Vec2ub()) = div(res, this, bX.i, bY.i)

    fun div(b: Number, res: Vec2ub) = div(res, this, b.i, b.i)
    fun div(b: Vec2t<out Number>, res: Vec2ub) = div(res, this, b.x.i, b.y.i)

    fun divAssign(bX: Number, bY: Number) = div(this, this, bX.i, bY.i)
    infix operator fun divAssign(b: Number) {
        div(this, this, b.i, b.i)
    }
    infix operator fun divAssign(b: Vec2t<out Number>) {
        div(this, this, b.x.i, b.y.i)
    }


    infix operator fun rem(b: Number) = rem(Vec2ub(), this, b.i, b.i)
    infix operator fun rem(b: Vec2t<out Number>) = rem(Vec2ub(), this, b.x.i, b.y.i)

    @JvmOverloads
    fun rem(bX: Number, bY: Number, res: Vec2ub = Vec2ub()) = rem(res, this, bX.i, bY.i)

    fun rem(b: Number, res: Vec2ub) = rem(res, this, b.i, b.i)
    fun rem(b: Vec2t<out Number>, res: Vec2ub) = rem(res, this, b.x.i, b.y.i)

    fun remAssign(bX: Number, bY: Number) = rem(this, this, bX.i, bY.i)
    infix operator fun remAssign(b: Number) {
        rem(this, this, b.i, b.i)
    }
    infix operator fun remAssign(b: Vec2t<out Number>) {
        rem(this, this, b.x.i, b.y.i)
    }


    // -- Specific bitwise operators --

    infix fun and(b: Ubyte) = and(Vec2ub(), this, b, b)
    infix fun and(b: Byte) = and(Vec2ub(), this, b, b)
    infix fun and(b: Int) = and(Vec2ub(), this, b, b)
    infix fun and(b: Vec2ub) = and(Vec2ub(), this, b.x, b.y)

    fun and(b: Ubyte, res: Vec2ub) = and(res, this, b, b)
    fun and(b: Byte, res: Vec2ub) = and(res, this, b, b)
    fun and(b: Int, res: Vec2ub) = and(res, this, b, b)
    fun and(b: Vec2ub, res: Vec2ub) = and(res, this, b.x, b.y)
    @JvmOverloads
    fun and(bX: Ubyte, bY: Ubyte, res: Vec2ub = Vec2ub()) = and(res, this, bX, bY)

    @JvmOverloads
    fun and(bX: Byte, bY: Byte, res: Vec2ub = Vec2ub()) = and(res, this, bX, bY)

    @JvmOverloads
    fun and(bX: Int, bY: Int, res: Vec2ub = Vec2ub()) = and(res, this, bX, bY)

    infix fun andAssign(b: Ubyte) = and(this, this, b, b)
    infix fun andAssign(b: Byte) = and(this, this, b, b)
    infix fun andAssign(b: Int) = and(this, this, b, b)
    infix fun andAssign(b: Vec2ub) = and(this, this, b.x, b.y)
    fun andAssign(bX: Ubyte, bY: Ubyte) = and(this, this, bX, bY)
    fun andAssign(bX: Byte, bY: Byte) = and(this, this, bX, bY)
    fun andAssign(bX: Int, bY: Int) = and(this, this, bX, bY)


    infix fun or(b: Ubyte) = or(Vec2ub(), this, b, b)
    infix fun or(b: Byte) = or(Vec2ub(), this, b, b)
    infix fun or(b: Int) = or(Vec2ub(), this, b, b)
    infix fun or(b: Vec2ub) = or(Vec2ub(), this, b.x, b.y)

    fun or(b: Ubyte, res: Vec2ub) = or(res, this, b, b)
    fun or(b: Byte, res: Vec2ub) = or(res, this, b, b)
    fun or(b: Int, res: Vec2ub) = or(res, this, b, b)
    fun or(b: Vec2ub, res: Vec2ub) = or(res, this, b.x, b.y)
    @JvmOverloads
    fun or(bX: Ubyte, bY: Ubyte, res: Vec2ub = Vec2ub()) = or(res, this, bX, bY)

    @JvmOverloads
    fun or(bX: Byte, bY: Byte, res: Vec2ub = Vec2ub()) = or(res, this, bX, bY)

    @JvmOverloads
    fun or(bX: Int, bY: Int, res: Vec2ub = Vec2ub()) = or(res, this, bX, bY)

    infix fun orAssign(b: Ubyte) = or(this, this, b, b)
    infix fun orAssign(b: Byte) = or(this, this, b, b)
    infix fun orAssign(b: Int) = or(this, this, b, b)
    infix fun orAssign(b: Vec2ub) = or(this, this, b.x, b.y)
    fun orAssign(bX: Ubyte, bY: Ubyte) = or(this, this, bX, bY)
    fun orAssign(bX: Byte, bY: Byte) = or(this, this, bX, bY)
    fun orAssign(bX: Int, bY: Int) = or(this, this, bX, bY)


    infix fun xor(b: Ubyte) = xor(Vec2ub(), this, b, b)
    infix fun xor(b: Byte) = xor(Vec2ub(), this, b, b)
    infix fun xor(b: Int) = xor(Vec2ub(), this, b, b)
    infix fun xor(b: Vec2ub) = xor(Vec2ub(), this, b.x, b.y)

    fun xor(b: Ubyte, res: Vec2ub) = xor(res, this, b, b)
    fun xor(b: Byte, res: Vec2ub) = xor(res, this, b, b)
    fun xor(b: Int, res: Vec2ub) = xor(res, this, b, b)
    fun xor(b: Vec2ub, res: Vec2ub) = xor(res, this, b.x, b.y)
    @JvmOverloads
    fun xor(bX: Ubyte, bY: Ubyte, res: Vec2ub = Vec2ub()) = xor(res, this, bX, bY)

    @JvmOverloads
    fun xor(bX: Byte, bY: Byte, res: Vec2ub = Vec2ub()) = xor(res, this, bX, bY)

    @JvmOverloads
    fun xor(bX: Int, bY: Int, res: Vec2ub = Vec2ub()) = xor(res, this, bX, bY)

    infix fun xorAssign(b: Ubyte) = xor(this, this, b, b)
    infix fun xorAssign(b: Byte) = xor(this, this, b, b)
    infix fun xorAssign(b: Int) = xor(this, this, b, b)
    infix fun xorAssign(b: Vec2ub) = xor(this, this, b.x, b.y)
    fun xorAssign(bX: Ubyte, bY: Ubyte) = xor(this, this, bX, bY)
    fun xorAssign(bX: Byte, bY: Byte) = xor(this, this, bX, bY)
    fun xorAssign(bX: Int, bY: Int) = xor(this, this, bX, bY)


    infix fun shl(b: Ubyte) = shl(Vec2ub(), this, b, b)
    infix fun shl(b: Byte) = shl(Vec2ub(), this, b, b)
    infix fun shl(b: Int) = shl(Vec2ub(), this, b, b)
    infix fun shl(b: Vec2ub) = shl(Vec2ub(), this, b.x, b.y)

    fun shl(b: Ubyte, res: Vec2ub) = shl(res, this, b, b)
    fun shl(b: Byte, res: Vec2ub) = shl(res, this, b, b)
    fun shl(b: Int, res: Vec2ub) = shl(res, this, b, b)
    fun shl(b: Vec2ub, res: Vec2ub) = shl(res, this, b.x, b.y)
    @JvmOverloads
    fun shl(bX: Ubyte, bY: Ubyte, res: Vec2ub = Vec2ub()) = shl(res, this, bX, bY)

    @JvmOverloads
    fun shl(bX: Byte, bY: Byte, res: Vec2ub = Vec2ub()) = shl(res, this, bX, bY)

    @JvmOverloads
    fun shl(bX: Int, bY: Int, res: Vec2ub = Vec2ub()) = shl(res, this, bX, bY)

    infix fun shlAssign(b: Ubyte) = shl(this, this, b, b)
    infix fun shlAssign(b: Byte) = shl(this, this, b, b)
    infix fun shlAssign(b: Int) = shl(this, this, b, b)
    infix fun shlAssign(b: Vec2ub) = shl(this, this, b.x, b.y)
    fun shlAssign(bX: Ubyte, bY: Ubyte) = shl(this, this, bX, bY)
    fun shlAssign(bX: Byte, bY: Byte) = shl(this, this, bX, bY)
    fun shlAssign(bX: Int, bY: Int) = shl(this, this, bX, bY)


    infix fun shr(b: Ubyte) = shr(Vec2ub(), this, b, b)
    infix fun shr(b: Byte) = shr(Vec2ub(), this, b, b)
    infix fun shr(b: Int) = shr(Vec2ub(), this, b, b)
    infix fun shr(b: Vec2ub) = shr(Vec2ub(), this, b.x, b.y)

    fun shr(b: Ubyte, res: Vec2ub) = shr(res, this, b, b)
    fun shr(b: Byte, res: Vec2ub) = shr(res, this, b, b)
    fun shr(b: Int, res: Vec2ub) = shr(res, this, b, b)
    fun shr(b: Vec2ub, res: Vec2ub) = shr(res, this, b.x, b.y)
    @JvmOverloads
    fun shr(bX: Ubyte, bY: Ubyte, res: Vec2ub = Vec2ub()) = shr(res, this, bX, bY)

    @JvmOverloads
    fun shr(bX: Byte, bY: Byte, res: Vec2ub = Vec2ub()) = shr(res, this, bX, bY)

    @JvmOverloads
    fun shr(bX: Int, bY: Int, res: Vec2ub = Vec2ub()) = shr(res, this, bX, bY)

    infix fun shrAssign(b: Ubyte) = shr(this, this, b, b)
    infix fun shrAssign(b: Byte) = shr(this, this, b, b)
    infix fun shrAssign(b: Int) = shr(this, this, b, b)
    infix fun shrAssign(b: Vec2ub) = shr(this, this, b.x, b.y)
    fun shrAssign(bX: Ubyte, bY: Ubyte) = shr(this, this, bX, bY)
    fun shrAssign(bX: Byte, bY: Byte) = shr(this, this, bX, bY)
    fun shrAssign(bX: Int, bY: Int) = shr(this, this, bX, bY)


    @JvmOverloads
    fun inv(res: Vec2ub = Vec2ub()) = inv(res, this)

    fun invAssign() = inv(this, this)


    // -- Generic bitwise operators --

    infix fun and(b: Number) = and(Vec2ub(), this, b.b, b.b)
    infix fun and(b: Vec2t<out Number>) = and(Vec2ub(), this, b.x.b, b.y.b)

    fun and(b: Number, res: Vec2ub) = and(res, this, b.i, b.i)
    fun and(b: Vec2t<out Number>, res: Vec2ub) = and(res, this, b.x.i, b.y.i)
    @JvmOverloads
    fun and(bX: Number, bY: Number, res: Vec2ub = Vec2ub()) = and(res, this, bX.i, bY.i)

    infix fun andAssign(b: Number) = and(this, this, b.i, b.i)
    infix fun andAssign(b: Vec2t<out Number>) = and(this, this, b.x.i, b.y.i)
    fun andAssign(bX: Number, bY: Number) = and(this, this, bX.i, bY.i)


    infix fun or(b: Number) = or(Vec2ub(), this, b.i, b.i)
    infix fun or(b: Vec2t<out Number>) = or(Vec2ub(), this, b.x.i, b.y.i)

    fun or(b: Number, res: Vec2ub) = or(res, this, b.i, b.i)
    fun or(b: Vec2t<out Number>, res: Vec2ub) = or(res, this, b.x.i, b.y.i)
    @JvmOverloads
    fun or(bX: Number, bY: Number, res: Vec2ub = Vec2ub()) = or(res, this, bX.i, bY.i)

    infix fun orAssign(b: Number) = or(this, this, b.i, b.i)
    infix fun orAssign(b: Vec2t<out Number>) = or(this, this, b.x.i, b.y.i)
    fun orAssign(bX: Number, bY: Number) = or(this, this, bX.i, bY.i)


    infix fun xor(b: Number) = xor(Vec2ub(), this, b.i, b.i)
    infix fun xor(b: Vec2t<out Number>) = xor(Vec2ub(), this, b.x.i, b.y.i)

    fun xor(b: Number, res: Vec2ub) = xor(res, this, b.i, b.i)
    fun xor(b: Vec2t<out Number>, res: Vec2ub) = xor(res, this, b.x.i, b.y.i)
    @JvmOverloads
    fun xor(bX: Number, bY: Number, res: Vec2ub = Vec2ub()) = xor(res, this, bX.i, bY.i)

    infix fun xorAssign(b: Number) = xor(this, this, b.i, b.i)
    infix fun xorAssign(b: Vec2t<out Number>) = xor(this, this, b.x.i, b.y.i)
    fun xorAssign(bX: Number, bY: Number) = xor(this, this, bX.i, bY.i)


    infix fun shl(b: Number) = shl(Vec2ub(), this, b.i, b.i)
    infix fun shl(b: Vec2t<out Number>) = shl(Vec2ub(), this, b.x.i, b.y.i)

    fun shl(b: Number, res: Vec2ub) = shl(res, this, b.i, b.i)
    fun shl(b: Vec2t<out Number>, res: Vec2ub) = shl(res, this, b.x.i, b.y.i)
    @JvmOverloads
    fun shl(bX: Number, bY: Number, res: Vec2ub = Vec2ub()) = shl(res, this, bX.i, bY.i)

    infix fun shlAssign(b: Number) = shl(this, this, b.i, b.i)
    infix fun shlAssign(b: Vec2t<out Number>) = shl(this, this, b.x.i, b.y.i)
    fun shlAssign(bX: Number, bY: Number) = shl(this, this, bX.i, bY.i)


    infix fun shr(b: Number) = shr(Vec2ub(), this, b.i, b.i)
    infix fun shr(b: Vec2t<out Number>) = shr(Vec2ub(), this, b.x.i, b.y.i)

    fun shr(b: Number, res: Vec2ub) = shr(res, this, b.i, b.i)
    fun shr(b: Vec2t<out Number>, res: Vec2ub) = shr(res, this, b.x.i, b.y.i)
    @JvmOverloads
    fun shr(bX: Number, bY: Number, res: Vec2ub = Vec2ub()) = shr(res, this, bX.i, bY.i)

    infix fun shrAssign(b: Number) = shr(this, this, b.i, b.i)
    infix fun shrAssign(b: Vec2t<out Number>) = shr(this, this, b.x.i, b.y.i)
    fun shrAssign(bX: Number, bY: Number) = shr(this, this, bX.i, bY.i)


    override fun equals(other: Any?) = other is Vec2ub && this[0] == other[0] && this[1] == other[1]
    override fun hashCode() = 31 * x.v.hashCode() + y.v.hashCode()
}