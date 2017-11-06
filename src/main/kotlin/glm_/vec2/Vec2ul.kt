package glm_.vec2

import glm_.*
import glm_.vec2.operators.opVec2ul
import glm_.vec3.Vec3bool
import glm_.vec3.Vec3t
import glm_.vec4.Vec4bool
import glm_.vec4.Vec4t
import unsigned.Ulong
import java.nio.*

/**
 * Created by elect on 08/10/16.
 */

class Vec2ul(x: Ulong, y: Ulong) : Vec2t<Ulong>(x, y) {

    // -- Explicit basic, conversion other main.and conversion vector constructors --

    constructor() : this(0)

    constructor(v: Vec2t<out Number>) : this(v.x, v.y)
    constructor(v: Vec3t<out Number>) : this(v.x, v.y)
    constructor(v: Vec4t<out Number>) : this(v.x, v.y)

    constructor(v: Vec2bool) : this(v.x.ul, v.y.ul)
    constructor(v: Vec3bool) : this(v.x.ul, v.y.ul)
    constructor(v: Vec4bool) : this(v.x.ul, v.y.ul)

    constructor(bytes: ByteArray, index: Int = 0, oneByteOneUlong: Boolean = false, bigEndian: Boolean = true) : this(
            if (oneByteOneUlong) bytes[index].ul else bytes.getUlong(index, bigEndian),
            if (oneByteOneUlong) bytes[index + 1].ul else bytes.getUlong(index + Ulong.BYTES, bigEndian))

    constructor(chars: CharArray, index: Int = 0) : this(chars[index].ul, chars[index + 1].ul)
    constructor(shorts: ShortArray, index: Int = 0) : this(shorts[index], shorts[index + 1])
    constructor(ints: IntArray, index: Int = 0) : this(ints[index], ints[index + 1])
    constructor(longs: LongArray, index: Int = 0) : this(longs[index], longs[index + 1])
    constructor(floats: FloatArray, index: Int = 0) : this(floats[index], floats[index + 1])
    constructor(doubles: DoubleArray, index: Int = 0) : this(doubles[index], doubles[index + 1])
    constructor(booleans: BooleanArray, index: Int = 0) : this(booleans[index].ul, booleans[index + 1].ul)

    constructor(numbers: Array<out Number>, index: Int = 0) : this(numbers[index], numbers[index + 1])
    constructor(chars: Array<Char>, index: Int = 0) : this(chars[index].ul, chars[index + 1].ul)
    constructor(booleans: Array<Boolean>, index: Int = 0) : this(booleans[index].ul, booleans[index + 1].ul)

    constructor(list: List<Any>, index: Int = 0) : this(list[index].toLong, list[index + 1].toLong)

    constructor(bytes: ByteBuffer, index: Int = bytes.position(), oneByteOneUlong: Boolean = false) : this(
            if (oneByteOneUlong) bytes[index].ul else bytes.getLong(index).ul,
            if (oneByteOneUlong) bytes[index + 1].ul else bytes.getLong(index + Ulong.BYTES).ul)

    constructor(chars: CharBuffer, index: Int = chars.position()) : this(chars[index].ul, chars[index + 1].ul)
    constructor(shorts: ShortBuffer, index: Int = shorts.position()) : this(shorts[index], shorts[index + 1])
    constructor(ints: IntBuffer, index: Int = ints.position()) : this(ints[index], ints[index + 1])
    constructor(longs: LongBuffer, index: Int = longs.position()) : this(longs[index], longs[index + 1])
    constructor(floats: FloatBuffer, index: Int = floats.position()) : this(floats[index], floats[index + 1])
    constructor(doubles: DoubleBuffer, index: Int = doubles.position()) : this(doubles[index], doubles[index + 1])

    constructor(s: Number) : this(s, s)
    constructor(x: Number, y: Number) : this(x.ul, y.ul)


    fun set(bytes: ByteArray, index: Int = 0, oneByteOneUlong: Boolean = false, bigEndian: Boolean = true) {
        x.v = if (oneByteOneUlong) bytes[index].L else bytes.getLong(index, bigEndian)
        y.v = if (oneByteOneUlong) bytes[index + 1].L else bytes.getLong(index + Ulong.BYTES, bigEndian)
    }

    fun set(bytes: ByteBuffer, index: Int = bytes.position(), oneByteOneUlong: Boolean = false) {
        x.v = if (oneByteOneUlong) bytes[index].L else bytes.getLong(index)
        y.v = if (oneByteOneUlong) bytes[index + 1].L else bytes.getLong(index + Ulong.BYTES)
    }


    override fun put(x: Number, y: Number): Vec2ul {
        this.x = x.ul
        this.y = y.ul
        return this
    }


    infix fun to(longs: LongArray) = to(longs, 0)
    fun to(longs: LongArray, index: Int): LongArray {
        longs[index] = x.v
        longs[index + 1] = y.v
        return longs
    }

    infix fun to(longs: LongBuffer) = to(longs, 0)
    fun to(longs: LongBuffer, index: Int): LongBuffer {
        longs[index] = x.v
        longs[index + 1] = y.v
        return longs
    }

    infix fun to(bytes: ByteBuffer) = to(bytes, bytes.position())
    fun to(bytes: ByteBuffer, offset: Int): ByteBuffer {
        bytes.putLong(offset, x.v)
        bytes.putLong(offset + Long.BYTES, y.v)
        return bytes
    }


    // -- Component accesses --

    override operator fun get(i: Int) = when (i) {
        0 -> x
        1 -> y
        else -> throw ArrayIndexOutOfBoundsException()
    }

    operator fun set(i: Int, s: Number) = when (i) {
        0 -> x = s.ul
        1 -> y = s.ul
        else -> throw ArrayIndexOutOfBoundsException()
    }


    companion object : opVec2ul() {
        @JvmField
        val length = 2
        @JvmField
        val size = length * Ulong.BYTES
    }


    // -- Unary arithmetic operators --

    operator fun unaryPlus() = this

    // no unaryMinus operator, only signed

    // -- Increment main.and decrement operators --

    operator fun inc(res: Vec2ul = Vec2ul()) = plus(res, this, 1, 1)
    fun incAssign() = plus(this, this, 1, 1)


    operator fun dec(res: Vec2ul = Vec2ul()) = minus(res, this, 1, 1)
    fun decAssign() = minus(this, this, 1, 1)


    // -- Specific binary arithmetic operators --

    infix operator fun plus(b: Ulong) = plus(Vec2ul(), this, b, b)
    infix operator fun plus(b: Long) = plus(Vec2ul(), this, b, b)
    infix operator fun plus(b: Vec2ul) = plus(Vec2ul(), this, b.x, b.y)

    @JvmOverloads
    fun plus(bX: Ulong, bY: Ulong, res: Vec2ul = Vec2ul()) = plus(res, this, bX, bY)

    @JvmOverloads
    fun plus(bX: Long, bY: Long, res: Vec2ul = Vec2ul()) = plus(res, this, bX, bY)

    fun plus(b: Ulong, res: Vec2ul) = plus(res, this, b, b)
    fun plus(b: Long, res: Vec2ul) = plus(res, this, b, b)
    fun plus(b: Vec2ul, res: Vec2ul) = plus(res, this, b.x, b.y)

    fun plusAssign(bX: Ulong, bY: Ulong) = plus(this, this, bX, bY)
    fun plusAssign(bX: Long, bY: Long) = plus(this, this, bX, bY)
    infix operator fun plusAssign(b: Ulong) {
        plus(this, this, b, b)
    }
    infix operator fun plusAssign(b: Long) {
        plus(this, this, b, b)
    }
    infix operator fun plusAssign(b: Vec2ul) {
        plus(this, this, b.x, b.y)
    }


    infix operator fun minus(b: Ulong) = minus(Vec2ul(), this, b, b)
    infix operator fun minus(b: Long) = minus(Vec2ul(), this, b, b)
    infix operator fun minus(b: Vec2ul) = minus(Vec2ul(), this, b.x, b.y)

    @JvmOverloads
    fun minus(bX: Ulong, bY: Ulong, res: Vec2ul = Vec2ul()) = minus(res, this, bX, bY)

    @JvmOverloads
    fun minus(bX: Long, bY: Long, res: Vec2ul = Vec2ul()) = minus(res, this, bX, bY)

    fun minus(b: Ulong, res: Vec2ul) = minus(res, this, b, b)
    fun minus(b: Long, res: Vec2ul) = minus(res, this, b, b)
    fun minus(b: Vec2ul, res: Vec2ul) = minus(res, this, b.x, b.y)

    fun minusAssign(bX: Ulong, bY: Ulong) = minus(this, this, bX, bY)
    fun minusAssign(bX: Long, bY: Long) = minus(this, this, bX, bY)
    infix operator fun minusAssign(b: Ulong) {
        minus(this, this, b, b)
    }
    infix operator fun minusAssign(b: Long) {
        minus(this, this, b, b)
    }
    infix operator fun minusAssign(b: Vec2ul) {
        minus(this, this, b.x, b.y)
    }


    infix operator fun times(b: Ulong) = times(Vec2ul(), this, b, b)
    infix operator fun times(b: Long) = times(Vec2ul(), this, b, b)
    infix operator fun times(b: Vec2ul) = times(Vec2ul(), this, b.x, b.y)

    @JvmOverloads
    fun times(bX: Ulong, bY: Ulong, res: Vec2ul = Vec2ul()) = times(res, this, bX, bY)

    @JvmOverloads
    fun times(bX: Long, bY: Long, res: Vec2ul = Vec2ul()) = times(res, this, bX, bY)

    fun times(b: Ulong, res: Vec2ul) = times(res, this, b, b)
    fun times(b: Long, res: Vec2ul) = times(res, this, b, b)
    fun times(b: Vec2ul, res: Vec2ul) = times(res, this, b.x, b.y)

    fun timesAssign(bX: Ulong, bY: Ulong) = times(this, this, bX, bY)
    fun timesAssign(bX: Long, bY: Long) = times(this, this, bX, bY)
    infix operator fun timesAssign(b: Ulong) {
        times(this, this, b, b)
    }
    infix operator fun timesAssign(b: Long) {
        times(this, this, b, b)
    }
    infix operator fun timesAssign(b: Vec2ul) {
        times(this, this, b.x, b.y)
    }


    infix operator fun div(b: Ulong) = div(Vec2ul(), this, b, b)
    infix operator fun div(b: Long) = div(Vec2ul(), this, b, b)
    infix operator fun div(b: Vec2ul) = div(Vec2ul(), this, b.x, b.y)

    @JvmOverloads
    fun div(bX: Ulong, bY: Ulong, res: Vec2ul = Vec2ul()) = div(res, this, bX, bY)

    @JvmOverloads
    fun div(bX: Long, bY: Long, res: Vec2ul = Vec2ul()) = div(res, this, bX, bY)

    fun div(b: Ulong, res: Vec2ul) = div(res, this, b, b)
    fun div(b: Long, res: Vec2ul) = div(res, this, b, b)
    fun div(b: Vec2ul, res: Vec2ul) = div(res, this, b.x, b.y)

    fun divAssign(bX: Ulong, bY: Ulong) = div(this, this, bX, bY)
    fun divAssign(bX: Long, bY: Long) = div(this, this, bX, bY)
    infix operator fun divAssign(b: Ulong) {
        div(this, this, b, b)
    }
    infix operator fun divAssign(b: Long) {
        div(this, this, b, b)
    }
    infix operator fun divAssign(b: Vec2ul) {
        div(this, this, b.x, b.y)
    }


    infix operator fun rem(b: Ulong) = rem(Vec2ul(), this, b, b)
    infix operator fun rem(b: Long) = rem(Vec2ul(), this, b, b)
    infix operator fun rem(b: Vec2ul) = rem(Vec2ul(), this, b.x, b.y)

    @JvmOverloads
    fun rem(bX: Ulong, bY: Ulong, res: Vec2ul = Vec2ul()) = rem(res, this, bX, bY)

    @JvmOverloads
    fun rem(bX: Long, bY: Long, res: Vec2ul = Vec2ul()) = rem(res, this, bX, bY)

    fun rem(b: Ulong, res: Vec2ul) = rem(res, this, b, b)
    fun rem(b: Long, res: Vec2ul) = rem(res, this, b, b)
    fun rem(b: Vec2ul, res: Vec2ul) = rem(res, this, b.x, b.y)

    fun remAssign(bX: Ulong, bY: Ulong) = rem(this, this, bX, bY)
    fun remAssign(bX: Long, bY: Long) = rem(this, this, bX, bY)
    infix operator fun remAssign(b: Ulong) {
        rem(this, this, b, b)
    }
    infix operator fun remAssign(b: Long) {
        rem(this, this, b, b)
    }
    infix operator fun remAssign(b: Vec2ul) {
        rem(this, this, b.x, b.y)
    }


    // -- Generic binary arithmetic operators --

    infix operator fun plus(b: Number) = plus(Vec2ul(), this, b.L, b.L)
    infix operator fun plus(b: Vec2t<out Number>) = plus(Vec2ul(), this, b.x.L, b.y.L)

    @JvmOverloads
    fun plus(bX: Number, bY: Number, res: Vec2ul = Vec2ul()) = plus(res, this, bX.L, bY.L)

    fun plus(b: Number, res: Vec2ul) = plus(res, this, b.L, b.L)
    fun plus(b: Vec2t<out Number>, res: Vec2ul) = plus(res, this, b.x.L, b.y.L)

    fun plusAssign(bX: Number, bY: Number) = plus(this, this, bX.L, bY.L)
    infix operator fun plusAssign(b: Number) {
        plus(this, this, b.L, b.L)
    }
    infix operator fun plusAssign(b: Vec2t<out Number>) {
        plus(this, this, b.x.L, b.y.L)
    }


    infix operator fun minus(b: Number) = minus(Vec2ul(), this, b.L, b.L)
    infix operator fun minus(b: Vec2t<out Number>) = minus(Vec2ul(), this, b.x.L, b.y.L)

    @JvmOverloads
    fun minus(bX: Number, bY: Number, res: Vec2ul = Vec2ul()) = minus(res, this, bX.L, bY.L)

    fun minus(b: Number, res: Vec2ul) = minus(res, this, b.L, b.L)
    fun minus(b: Vec2t<out Number>, res: Vec2ul) = minus(res, this, b.x.L, b.y.L)

    fun minusAssign(bX: Number, bY: Number) = minus(this, this, bX.L, bY.L)
    infix operator fun minusAssign(b: Number) {
        minus(this, this, b.L, b.L)
    }
    infix operator fun minusAssign(b: Vec2t<out Number>) {
        minus(this, this, b.x.L, b.y.L)
    }


    infix operator fun times(b: Number) = times(Vec2ul(), this, b.L, b.L)
    infix operator fun times(b: Vec2t<out Number>) = times(Vec2ul(), this, b.x.L, b.y.L)

    @JvmOverloads
    fun times(bX: Number, bY: Number, res: Vec2ul = Vec2ul()) = times(res, this, bX.L, bY.L)

    fun times(b: Number, res: Vec2ul) = times(res, this, b.L, b.L)
    fun times(b: Vec2t<out Number>, res: Vec2ul) = times(res, this, b.x.L, b.y.L)

    fun timesAssign(bX: Number, bY: Number) = times(this, this, bX.L, bY.L)
    infix operator fun timesAssign(b: Number) {
        times(this, this, b.L, b.L)
    }
    infix operator fun timesAssign(b: Vec2t<out Number>) {
        times(this, this, b.x.L, b.y.L)
    }


    infix operator fun div(b: Number) = div(Vec2ul(), this, b.L, b.L)
    infix operator fun div(b: Vec2t<out Number>) = div(Vec2ul(), this, b.x.L, b.y.L)

    @JvmOverloads
    fun div(bX: Number, bY: Number, res: Vec2ul = Vec2ul()) = div(res, this, bX.L, bY.L)

    fun div(b: Number, res: Vec2ul) = div(res, this, b.L, b.L)
    fun div(b: Vec2t<out Number>, res: Vec2ul) = div(res, this, b.x.L, b.y.L)

    fun divAssign(bX: Number, bY: Number) = div(this, this, bX.L, bY.L)
    infix operator fun divAssign(b: Number) {
        div(this, this, b.L, b.L)
    }
    infix operator fun divAssign(b: Vec2t<out Number>) {
        div(this, this, b.x.L, b.y.L)
    }


    infix operator fun rem(b: Number) = rem(Vec2ul(), this, b.L, b.L)
    infix operator fun rem(b: Vec2t<out Number>) = rem(Vec2ul(), this, b.x.L, b.y.L)

    @JvmOverloads
    fun rem(bX: Number, bY: Number, res: Vec2ul = Vec2ul()) = rem(res, this, bX.L, bY.L)

    fun rem(b: Number, res: Vec2ul) = rem(res, this, b.L, b.L)
    fun rem(b: Vec2t<out Number>, res: Vec2ul) = rem(res, this, b.x.L, b.y.L)

    fun remAssign(bX: Number, bY: Number) = rem(this, this, bX.L, bY.L)
    infix operator fun remAssign(b: Number) {
        rem(this, this, b.L, b.L)
    }
    infix operator fun remAssign(b: Vec2t<out Number>) {
        rem(this, this, b.x.L, b.y.L)
    }


    // -- Specific bitwise operators --

    infix fun and(b: Ulong) = and(Vec2ul(), this, b, b)
    infix fun and(b: Long) = and(Vec2ul(), this, b, b)
    infix fun and(b: Vec2ul) = and(Vec2ul(), this, b.x, b.y)

    fun and(b: Ulong, res: Vec2ul) = and(res, this, b, b)
    fun and(b: Long, res: Vec2ul) = and(res, this, b, b)
    fun and(b: Vec2ul, res: Vec2ul) = and(res, this, b.x, b.y)
    @JvmOverloads
    fun and(bX: Ulong, bY: Ulong, res: Vec2ul = Vec2ul()) = and(res, this, bX, bY)

    @JvmOverloads
    fun and(bX: Long, bY: Long, res: Vec2ul = Vec2ul()) = and(res, this, bX, bY)

    infix fun andAssign(b: Ulong) = and(this, this, b, b)
    infix fun andAssign(b: Long) = and(this, this, b, b)
    infix fun andAssign(b: Vec2ul) = and(this, this, b.x, b.y)
    fun andAssign(bX: Ulong, bY: Ulong) = and(this, this, bX, bY)
    fun andAssign(bX: Long, bY: Long) = and(this, this, bX, bY)


    infix fun or(b: Ulong) = or(Vec2ul(), this, b, b)
    infix fun or(b: Long) = or(Vec2ul(), this, b, b)
    infix fun or(b: Vec2ul) = or(Vec2ul(), this, b.x, b.y)

    fun or(b: Ulong, res: Vec2ul) = or(res, this, b, b)
    fun or(b: Long, res: Vec2ul) = or(res, this, b, b)
    fun or(b: Vec2ul, res: Vec2ul) = or(res, this, b.x, b.y)
    @JvmOverloads
    fun or(bX: Ulong, bY: Ulong, res: Vec2ul = Vec2ul()) = or(res, this, bX, bY)

    @JvmOverloads
    fun or(bX: Long, bY: Long, res: Vec2ul = Vec2ul()) = or(res, this, bX, bY)

    infix fun orAssign(b: Ulong) = or(this, this, b, b)
    infix fun orAssign(b: Long) = or(this, this, b, b)
    infix fun orAssign(b: Vec2ul) = or(this, this, b.x, b.y)
    fun orAssign(bX: Ulong, bY: Ulong) = or(this, this, bX, bY)
    fun orAssign(bX: Long, bY: Long) = or(this, this, bX, bY)


    infix fun xor(b: Ulong) = xor(Vec2ul(), this, b, b)
    infix fun xor(b: Long) = xor(Vec2ul(), this, b, b)
    infix fun xor(b: Vec2ul) = xor(Vec2ul(), this, b.x, b.y)

    fun xor(b: Ulong, res: Vec2ul) = xor(res, this, b, b)
    fun xor(b: Long, res: Vec2ul) = xor(res, this, b, b)
    fun xor(b: Vec2ul, res: Vec2ul) = xor(res, this, b.x, b.y)
    @JvmOverloads
    fun xor(bX: Ulong, bY: Ulong, res: Vec2ul = Vec2ul()) = xor(res, this, bX, bY)

    @JvmOverloads
    fun xor(bX: Long, bY: Long, res: Vec2ul = Vec2ul()) = xor(res, this, bX, bY)

    infix fun xorAssign(b: Ulong) = xor(this, this, b, b)
    infix fun xorAssign(b: Long) = xor(this, this, b, b)
    infix fun xorAssign(b: Vec2ul) = xor(this, this, b.x, b.y)
    fun xorAssign(bX: Ulong, bY: Ulong) = xor(this, this, bX, bY)
    fun xorAssign(bX: Long, bY: Long) = xor(this, this, bX, bY)


    infix fun shl(b: Int) = shl(Vec2ul(), this, b, b)

    fun shl(b: Int, res: Vec2ul) = shl(res, this, b, b)
    @JvmOverloads
    fun shl(bX: Int, bY: Int, res: Vec2ul = Vec2ul()) = shl(res, this, bX, bY)

    infix fun shlAssign(b: Int) = shl(this, this, b, b)
    fun shlAssign(bX: Int, bY: Int) = shl(this, this, bX, bY)


    infix fun shr(b: Int) = shr(Vec2ul(), this, b, b)

    fun shr(b: Int, res: Vec2ul) = shr(res, this, b, b)
    @JvmOverloads
    fun shr(bX: Int, bY: Int, res: Vec2ul = Vec2ul()) = shr(res, this, bX, bY)

    infix fun shrAssign(b: Int) = shr(this, this, b, b)
    fun shrAssign(bX: Int, bY: Int) = shr(this, this, bX, bY)


    @JvmOverloads
    fun inv(res: Vec2ul = Vec2ul()) = inv(res, this)

    fun invAssign() = inv(this, this)


    // -- Generic bitwise operators --

    infix fun and(b: Number) = and(Vec2ul(), this, b.L, b.L)
    fun and(bX: Number, bY: Number) = and(Vec2ul(), this, bX.L, bY.L)
    fun and(b: Vec2t<out Number>) = and(Vec2ul(), this, b.x.L, b.y.L)

    fun and(b: Number, res: Vec2ul) = and(res, this, b.L, b.L)
    fun and(bX: Number, bY: Number, res: Vec2ul) = and(res, this, bX.L, bY.L)
    fun and(b: Vec2t<out Number>, res: Vec2ul) = and(res, this, b.x.L, b.y.L)

    infix fun andAssign(b: Number) = and(this, this, b.L, b.L)
    fun andAssign(bX: Number, bY: Number) = and(this, this, bX.L, bY.L)
    infix fun andAssign(b: Vec2t<out Number>) = and(this, this, b.x.L, b.y.L)


    infix fun or(b: Number) = or(Vec2ul(), this, b.L, b.L)
    fun or(bX: Number, bY: Number) = or(Vec2ul(), this, bX.L, bY.L)
    fun or(b: Vec2t<out Number>) = or(Vec2ul(), this, b.x.L, b.y.L)

    fun or(b: Number, res: Vec2ul) = or(res, this, b.L, b.L)
    fun or(bX: Number, bY: Number, res: Vec2ul) = or(res, this, bX.L, bY.L)
    fun or(b: Vec2t<out Number>, res: Vec2ul) = or(res, this, b.x.L, b.y.L)

    infix fun orAssign(b: Number) = or(this, this, b.L, b.L)
    fun orAssign(bX: Number, bY: Number) = or(this, this, bX.L, bY.L)
    infix fun orAssign(b: Vec2t<out Number>) = or(this, this, b.x.L, b.y.L)


    infix fun xor(b: Number) = xor(Vec2ul(), this, b.L, b.L)
    fun xor(bX: Number, bY: Number) = xor(Vec2ul(), this, bX.L, bY.L)
    fun xor(b: Vec2t<out Number>) = xor(Vec2ul(), this, b.x.L, b.y.L)

    fun xor(b: Number, res: Vec2ul) = xor(res, this, b.L, b.L)
    fun xor(bX: Number, bY: Number, res: Vec2ul) = xor(res, this, bX.L, bY.L)
    fun xor(b: Vec2t<out Number>, res: Vec2ul) = xor(res, this, b.x.L, b.y.L)

    infix fun xorAssign(b: Number) = xor(this, this, b.L, b.L)
    fun xorAssign(bX: Number, bY: Number) = xor(this, this, bX.L, bY.L)
    infix fun xorAssign(b: Vec2t<out Number>) = xor(this, this, b.x.L, b.y.L)


    infix fun shl(b: Number) = shl(Vec2ul(), this, b.L, b.L)
    fun shl(bX: Number, bY: Number) = shl(Vec2ul(), this, bX.L, bY.L)

    fun shl(b: Number, res: Vec2ul) = shl(res, this, b.L, b.L)
    fun shl(bX: Number, bY: Number, res: Vec2ul) = shl(res, this, bX.L, bY.L)

    infix fun shlAssign(b: Number) = shl(this, this, b.L, b.L)
    fun shlAssign(bX: Number, bY: Number) = shl(this, this, bX.L, bY.L)


    infix fun shr(b: Number) = shr(Vec2ul(), this, b.L, b.L)
    fun shr(bX: Number, bY: Number) = shr(Vec2ul(), this, bX.L, bY.L)

    fun shr(b: Number, res: Vec2ul) = shr(res, this, b.L, b.L)
    fun shr(bX: Number, bY: Number, res: Vec2ul) = shr(res, this, bX.L, bY.L)

    infix fun shrAssign(b: Number) = shr(this, this, b.L, b.L)
    fun shrAssign(bX: Number, bY: Number) = shr(this, this, bX.L, bY.L)


    override fun equals(other: Any?) = other is Vec2ul && this[0] == other[0] && this[1] == other[1]
    override fun hashCode() = 31 * x.v.hashCode() + y.v.hashCode()
}