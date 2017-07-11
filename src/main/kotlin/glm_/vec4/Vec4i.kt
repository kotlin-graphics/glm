package glm_.vec4

import glm_.BYTES
import glm_.getInt
import glm_.i
import glm_.vec2.Vec2bool
import glm_.vec2.Vec2t
import glm_.vec3.Vec3bool
import glm_.vec3.Vec3t
import glm_.vec4.operators.vec4i_operators
import java.nio.*

/**
 * Created by elect on 09/10/16.
 */

open class Vec4i(x: Int, y: Int, z: Int, w: Int) : Vec4t<Int>(x, y, z, w) {

    // -- Explicit basic, conversion other main.and conversion vector constructors --

    constructor() : this(0)

    constructor(v: Vec2t<out Number>) : this(v.x, v.y, 0, 1)
    constructor(v: Vec2t<out Number>, z: Number, w: Number) : this(v.x, v.y, z, w)
    constructor(v: Vec3t<out Number>) : this(v, 1)
    constructor(v: Vec3t<out Number>, w: Number) : this(v.x, v.y, v.z, w)
    constructor(x: Number, v: Vec3t<out Number>) : this(x, v.x, v.y, v.z)
    constructor(v: Vec4t<out Number>) : this(v.x, v.y, v.z, v.w)

    constructor(v: Vec2bool) : this(v.x.i, v.y.i, 0, 1)
    constructor(v: Vec3bool) : this(v.x.i, v.y.i, v.z.i, 1)
    constructor(v: Vec4bool) : this(v.x.i, v.y.i, v.z.i, v.w.i)

    constructor(bytes: ByteArray, index: Int = 0, oneByteOneInt: Boolean = true, bigEndianess: Boolean = true) : this(
            if (oneByteOneInt) bytes[index].i else bytes.getInt(index, bigEndianess),
            if (oneByteOneInt) bytes[index + 1].i else bytes.getInt(index + Int.BYTES, bigEndianess),
            if (oneByteOneInt) bytes[index + 2].i else bytes.getInt(index + Int.BYTES * 2, bigEndianess),
            if (oneByteOneInt) bytes[index + 3].i else bytes.getInt(index + Int.BYTES * 3, bigEndianess))

    constructor(chars: CharArray, index: Int = 0) : this(chars[index].i, chars[index + 1].i, chars[index + 2].i, chars[index + 3].i)
    constructor(shorts: ShortArray, index: Int = 0) : this(shorts[index], shorts[index + 1], shorts[index + 2], shorts[index + 3])
    constructor(ints: IntArray, index: Int = 0) : this(ints[index], ints[index + 1], ints[index + 2], ints[index + 3])
    constructor(longs: LongArray, index: Int = 0) : this(longs[index], longs[index + 1], longs[index + 2], longs[index + 3])
    constructor(floats: FloatArray, index: Int = 0) : this(floats[index], floats[index + 1], floats[index + 2], floats[index + 3])
    constructor(doubles: DoubleArray, index: Int = 0) : this(doubles[index], doubles[index + 1], doubles[index + 2], doubles[index + 3])
    constructor(booleans: BooleanArray, index: Int = 0) : this(booleans[index].i, booleans[index + 1].i, booleans[index + 2].i, booleans[index + 3].i)

    constructor(numbers: Array<out Number>, index: Int = 0) : this(numbers[index], numbers[index + 1], numbers[index + 2], numbers[index + 3])
    constructor(chars: Array<Char>, index: Int = 0) : this(chars[index].i, chars[index + 1].i, chars[index + 2].i, chars[index + 3].i)
    constructor(booleans: Array<Boolean>, index: Int = 0) : this(booleans[index].i, booleans[index + 1].i, booleans[index + 2].i, booleans[index + 2].i)

    constructor(list: List<Any>, index: Int = 0) : this() {
        put(list, index)
    }

    constructor(bytes: ByteBuffer, index: Int = bytes.position(), oneByteOneInt: Boolean = true) : this(
            if (oneByteOneInt) bytes[index].i else bytes.getInt(index),
            if (oneByteOneInt) bytes[index + 1].i else bytes.getInt(index + Int.BYTES),
            if (oneByteOneInt) bytes[index + 2].i else bytes.getInt(index + Int.BYTES * 2),
            if (oneByteOneInt) bytes[index + 3].i else bytes.getInt(index + Int.BYTES * 3))

    constructor(chars: CharBuffer, index: Int = chars.position()) : this(chars[index].i, chars[index + 1].i, chars[index + 2].i, chars[index + 3].i)
    constructor(shorts: ShortBuffer, index: Int = shorts.position()) : this(shorts[index], shorts[index + 1], shorts[index + 2], shorts[index + 3])
    constructor(ints: IntBuffer, index: Int = ints.position()) : this(ints[index], ints[index + 1], ints[index + 2], ints[index + 3])
    constructor(longs: LongBuffer, index: Int = longs.position()) : this(longs[index], longs[index + 1], longs[index + 2], longs[index + 3])
    constructor(floats: FloatBuffer, index: Int = floats.position()) : this(floats[index], floats[index + 1], floats[index + 2], floats[index + 3])
    constructor(doubles: DoubleBuffer, index: Int = doubles.position()) : this(doubles[index], doubles[index + 1], doubles[index + 2], doubles[index + 2])

    constructor(s: Number) : this(s, s, s, s)
    constructor(x: Number, y: Number, z: Number, w: Number) : this(x.i, y.i, z.i, w.i)


    fun set(bytes: ByteArray, index: Int = 0, oneByteOneInt: Boolean = true, bigEndianess: Boolean = true) {
        x = if (oneByteOneInt) bytes[index].i else bytes.getInt(index, bigEndianess)
        y = if (oneByteOneInt) bytes[index + 1].i else bytes.getInt(index + Int.BYTES, bigEndianess)
        z = if (oneByteOneInt) bytes[index + 2].i else bytes.getInt(index + Int.BYTES * 2, bigEndianess)
        w = if (oneByteOneInt) bytes[index + 3].i else bytes.getInt(index + Int.BYTES * 3, bigEndianess)
    }

    fun set(bytes: ByteBuffer, index: Int = bytes.position(), oneByteOneInt: Boolean = true) {
        x = if (oneByteOneInt) bytes[index].i else bytes.getInt(index)
        y = if (oneByteOneInt) bytes[index + 1].i else bytes.getInt(index + Int.BYTES)
        z = if (oneByteOneInt) bytes[index + 2].i else bytes.getInt(index + Int.BYTES * 2)
        w = if (oneByteOneInt) bytes[index + 3].i else bytes.getInt(index + Int.BYTES * 3)
    }


    override fun put(x: Number, y: Number, z: Number, w: Number): Vec4i {
        this.x = x.i
        this.y = y.i
        this.z = z.i
        this.w = w.i
        return this
    }


    // -- Component accesses --

    override operator fun get(i: Int) = when (i) {
        0 -> x
        1 -> y
        2 -> z
        3 -> w
        else -> throw ArrayIndexOutOfBoundsException()
    }

    operator fun set(i: Int, s: Number) = when (i) {
        0 -> x = s.i
        1 -> y = s.i
        2 -> z = s.i
        3 -> w = s.i
        else -> throw ArrayIndexOutOfBoundsException()
    }


    companion object : vec4i_operators {
        @JvmField val length = 4
        @JvmField val size = length * Int.BYTES
    }
    override fun instanceSize() = size

    override infix fun to(bytes: ByteBuffer) = to(bytes, bytes.position())

    override fun to(bytes: ByteBuffer, index: Int): ByteBuffer {
        bytes.putInt(index, x)
        bytes.putInt(index + Int.BYTES, y)
        bytes.putInt(index + Int.BYTES * 2, z)
        bytes.putInt(index + Int.BYTES * 3, w)
        return bytes
    }


    // -- Unary arithmetic operators --

    operator fun unaryPlus() = this

    operator fun unaryMinus() = Vec4i(-x, -y, -z, -w)

    // -- Increment main.and decrement operators --

    operator fun inc(res: Vec4i = Vec4i()) = plus(res, this, 1, 1, 1, 1)
    fun inc_() = plus(this, this, 1, 1, 1, 1)


    operator fun dec(res: Vec4i = Vec4i()) = minus(res, this, 1, 1, 1, 1)
    fun dec_() = minus(this, this, 1, 1, 1, 1)


    // -- Specific binary arithmetic operators --

    operator fun plus(b: Int) = plus(Vec4i(), this, b, b, b, b)
    operator fun plus(b: Vec4i) = plus(Vec4i(), this, b.x, b.y, b.z, b.w)

    fun plus(bX: Int, bY: Int, bZ: Int, bW: Int, res: Vec4i = Vec4i()) = plus(res, this, bX, bY, bZ, bW)
    fun plus(b: Int, res: Vec4i = Vec4i()) = plus(res, this, b, b, b, b)
    fun plus(b: Vec4i, res: Vec4i = Vec4i()) = plus(res, this, b.x, b.y, b.z, b.w)

    fun plus_(bX: Int, bY: Int, bZ: Int, bW: Int) = plus(this, this, bX, bY, bZ, bW)
    infix fun plus_(b: Int) = plus(this, this, b, b, b, b)
    infix fun plus_(b: Vec4i) = plus(this, this, b.x, b.y, b.z, b.w)


    operator fun minus(b: Int) = minus(Vec4i(), this, b, b, b, b)
    operator fun minus(b: Vec4i) = minus(Vec4i(), this, b.x, b.y, b.z, b.w)

    fun minus(bX: Int, bY: Int, bZ: Int, bW: Int, res: Vec4i = Vec4i()) = minus(res, this, bX, bY, bZ, bW)
    fun minus(b: Int, res: Vec4i = Vec4i()) = minus(res, this, b, b, b, b)
    fun minus(b: Vec4i, res: Vec4i = Vec4i()) = minus(res, this, b.x, b.y, b.z, b.w)

    fun minus_(bX: Int, bY: Int, bZ: Int, bW: Int) = minus(this, this, bX, bY, bZ, bW)
    infix fun minus_(b: Int) = minus(this, this, b, b, b, b)
    infix fun minus_(b: Vec4i) = minus(this, this, b.x, b.y, b.z, b.w)


    operator fun times(b: Int) = times(Vec4i(), this, b, b, b, b)
    operator fun times(b: Vec4i) = times(Vec4i(), this, b.x, b.y, b.z, b.w)

    fun times(bX: Int, bY: Int, bZ: Int, bW: Int, res: Vec4i = Vec4i()) = times(res, this, bX, bY, bZ, bW)
    fun times(b: Int, res: Vec4i = Vec4i()) = times(res, this, b, b, b, b)
    fun times(b: Vec4i, res: Vec4i = Vec4i()) = times(res, this, b.x, b.y, b.z, b.w)

    fun times_(bX: Int, bY: Int, bZ: Int, bW: Int) = times(this, this, bX, bY, bZ, bW)
    infix fun times_(b: Int) = times(this, this, b, b, b, b)
    infix fun times_(b: Vec4i) = times(this, this, b.x, b.y, b.z, b.w)


    operator fun div(b: Int) = div(Vec4i(), this, b, b, b, b)
    operator fun div(b: Vec4i) = div(Vec4i(), this, b.x, b.y, b.z, b.w)

    fun div(bX: Int, bY: Int, bZ: Int, bW: Int, res: Vec4i = Vec4i()) = div(res, this, bX, bY, bZ, bW)
    fun div(b: Int, res: Vec4i) = div(res, this, b, b, b, b)
    fun div(b: Vec4i, res: Vec4i) = div(res, this, b.x, b.y, b.z, b.w)

    fun div_(bX: Int, bY: Int, bZ: Int, bW: Int) = div(this, this, bX, bY, bZ, bW)
    infix fun div_(b: Int) = div(this, this, b, b, b, b)
    infix fun div_(b: Vec4i) = div(this, this, b.x, b.y, b.z, b.w)


    operator fun rem(b: Int) = rem(Vec4i(), this, b, b, b, b)
    operator fun rem(b: Vec4i) = rem(Vec4i(), this, b.x, b.y, b.z, b.w)

    fun rem(bX: Int, bY: Int, bZ: Int, bW: Int, res: Vec4i = Vec4i()) = rem(res, this, bX, bY, bZ, bW)
    fun rem(b: Int, res: Vec4i) = rem(res, this, b, b, b, b)
    fun rem(b: Vec4i, res: Vec4i) = rem(res, this, b.x, b.y, b.z, b.w)

    fun rem_(bX: Int, bY: Int, bZ: Int, bW: Int) = rem(this, this, bX, bY, bZ, bW)
    infix fun rem_(b: Int) = rem(this, this, b, b, b, b)
    infix fun rem_(b: Vec4i) = rem(this, this, b.x, b.y, b.z, b.w)


    // -- Generic binary arithmetic operators --

    operator fun plus(b: Number) = plus(Vec4i(), this, b.i, b.i, b.i, b.i)
    operator fun plus(b: Vec4t<out Number>) = plus(Vec4i(), this, b.x.i, b.y.i, b.z.i, b.w.i)

    fun plus(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4i = Vec4i()) = plus(res, this, bX.i, bY.i, bZ.i, bW.i)
    fun plus(b: Number, res: Vec4i = Vec4i()) = plus(res, this, b.i, b.i, b.i, b.i)
    fun plus(b: Vec4t<out Number>, res: Vec4i = Vec4i()) = plus(res, this, b.x.i, b.y.i, b.z.i, b.w.i)

    fun plus_(bX: Number, bY: Number, bZ: Number, bW: Number) = plus(this, this, bX.i, bY.i, bZ.i, bW.i)
    infix fun plus_(b: Number) = plus(this, this, b.i, b.i, b.i, b.i)
    infix fun plus_(b: Vec4t<out Number>) = plus(this, this, b.x.i, b.y.i, b.z.i, b.w.i)


    operator fun minus(b: Number) = minus(Vec4i(), this, b.i, b.i, b.i, b.i)
    operator fun minus(b: Vec4t<out Number>) = minus(Vec4i(), this, b.x.i, b.y.i, b.z.i, b.w.i)

    fun minus(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4i = Vec4i()) = minus(res, this, bX.i, bY.i, bZ.i, bW.i)
    fun minus(b: Number, res: Vec4i = Vec4i()) = minus(res, this, b.i, b.i, b.i, b.i)
    fun minus(b: Vec4t<out Number>, res: Vec4i = Vec4i()) = minus(res, this, b.x.i, b.y.i, b.z.i, b.w.i)

    fun minus_(bX: Number, bY: Number, bZ: Number, bW: Number) = minus(this, this, bX.i, bY.i, bZ.i, bW.i)
    infix fun minus_(b: Number) = minus(this, this, b.i, b.i, b.i, b.i)
    infix fun minus_(b: Vec4t<out Number>) = minus(this, this, b.x.i, b.y.i, b.z.i, b.w.i)


    operator fun times(b: Number) = times(Vec4i(), this, b.i, b.i, b.i, b.i)
    operator fun times(b: Vec4t<out Number>) = times(Vec4i(), this, b.x.i, b.y.i, b.z.i, b.w.i)

    fun times(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4i = Vec4i()) = times(res, this, bX.i, bY.i, bZ.i, bW.i)
    fun times(b: Number, res: Vec4i = Vec4i()) = times(res, this, b.i, b.i, b.i, b.i)
    fun times(b: Vec4t<out Number>, res: Vec4i = Vec4i()) = times(res, this, b.x.i, b.y.i, b.z.i, b.w.i)

    fun times_(bX: Number, bY: Number, bZ: Number, bW: Number) = times(this, this, bX.i, bY.i, bZ.i, bW.i)
    infix fun times_(b: Number) = times(this, this, b.i, b.i, b.i, b.i)
    infix fun times_(b: Vec4t<out Number>) = times(this, this, b.x.i, b.y.i, b.z.i, b.w.i)


    operator fun div(b: Number) = div(Vec4i(), this, b.i, b.i, b.i, b.i)
    operator fun div(b: Vec4t<out Number>) = div(Vec4i(), this, b.x.i, b.y.i, b.z.i, b.w.i)

    fun div(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4i = Vec4i()) = div(res, this, bX.i, bY.i, bZ.i, bW.i)
    fun div(b: Number, res: Vec4i) = div(res, this, b.i, b.i, b.i, b.i)
    fun div(b: Vec4t<out Number>, res: Vec4i) = div(res, this, b.x.i, b.y.i, b.z.i, b.w.i)

    fun div_(bX: Number, bY: Number, bZ: Number, bW: Number) = div(this, this, bX.i, bY.i, bZ.i, bW.i)
    infix fun div_(b: Number) = div(this, this, b.i, b.i, b.i, b.i)
    infix fun div_(b: Vec4t<out Number>) = div(this, this, b.x.i, b.y.i, b.z.i, b.w.i)


    operator fun rem(b: Number) = rem(Vec4i(), this, b.i, b.i, b.i, b.i)
    operator fun rem(b: Vec4t<out Number>) = rem(Vec4i(), this, b.x.i, b.y.i, b.z.i, b.w.i)

    fun rem(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4i = Vec4i()) = rem(res, this, bX.i, bY.i, bZ.i, bW.i)
    fun rem(b: Number, res: Vec4i) = rem(res, this, b.i, b.i, b.i, b.i)
    fun rem(b: Vec4t<out Number>, res: Vec4i) = rem(res, this, b.x.i, b.y.i, b.z.i, b.w.i)

    fun rem_(bX: Number, bY: Number, bZ: Number, bW: Number) = rem(this, this, bX.i, bY.i, bZ.i, bW.i)
    infix fun rem_(b: Number) = rem(this, this, b.i, b.i, b.i, b.i)
    infix fun rem_(b: Vec4t<out Number>) = rem(this, this, b.x.i, b.y.i, b.z.i, b.w.i)


    // -- Specific bitwise operators --

    infix fun and(b: Int) = and(Vec4i(), this, b, b, b, b)
    infix fun and(b: Vec4i) = and(Vec4i(), this, b.x, b.y, b.z, b.w)

    infix fun and_(b: Int) = and(this, this, b, b, b, b)
    infix fun and_(b: Vec4i) = and(this, this, b.x, b.y, b.z, b.w)

    fun and(b: Int, res: Vec4i) = and(res, this, b, b, b, b)
    fun and(b: Vec4i, res: Vec4i) = and(res, this, b.x, b.y, b.z, b.w)

    fun and(bX: Int, bY: Int, bZ: Int, bW: Int, res: Vec4i = Vec4i()) = and(res, this, bX, bY, bZ, bW)

    fun and_(bX: Int, bY: Int, bZ: Int, bW: Int) = and(this, this, bX, bY, bZ, bW)


    infix fun or(b: Int) = or(Vec4i(), this, b, b, b, b)
    infix fun or(b: Vec4i) = or(Vec4i(), this, b.x, b.y, b.z, b.w)

    infix fun or_(b: Int) = or(this, this, b, b, b, b)
    infix fun or_(b: Vec4i) = or(this, this, b.x, b.y, b.z, b.w)

    fun or(b: Int, res: Vec4i) = or(res, this, b, b, b, b)
    fun or(b: Vec4i, res: Vec4i) = or(res, this, b.x, b.y, b.z, b.w)

    fun or(bX: Int, bY: Int, bZ: Int, bW: Int, res: Vec4i = Vec4i()) = or(res, this, bX, bY, bZ, bW)

    fun or_(bX: Int, bY: Int, bZ: Int, bW: Int) = or(this, this, bX, bY, bZ, bW)


    infix fun xor(b: Int) = xor(Vec4i(), this, b, b, b, b)
    infix fun xor(b: Vec4i) = xor(Vec4i(), this, b.x, b.y, b.z, b.w)

    infix fun xor_(b: Int) = xor(this, this, b, b, b, b)
    infix fun xor_(b: Vec4i) = xor(this, this, b.x, b.y, b.z, b.w)

    fun xor(b: Int, res: Vec4i) = xor(res, this, b, b, b, b)
    fun xor(b: Vec4i, res: Vec4i) = xor(res, this, b.x, b.y, b.z, b.w)

    fun xor(bX: Int, bY: Int, bZ: Int, bW: Int, res: Vec4i = Vec4i()) = xor(res, this, bX, bY, bZ, bW)

    fun xor_(bX: Int, bY: Int, bZ: Int, bW: Int) = xor(this, this, bX, bY, bZ, bW)


    infix fun shl(b: Int) = shl(Vec4i(), this, b, b, b, b)
    infix fun shl(b: Vec4i) = shl(Vec4i(), this, b.x, b.y, b.z, b.w)

    infix fun shl_(b: Int) = shl(this, this, b, b, b, b)
    infix fun shl_(b: Vec4i) = shl(this, this, b.x, b.y, b.z, b.w)

    fun shl(b: Int, res: Vec4i) = shl(res, this, b, b, b, b)
    fun shl(b: Vec4i, res: Vec4i) = shl(res, this, b.x, b.y, b.z, b.w)

    fun shl(bX: Int, bY: Int, bZ: Int, bW: Int, res: Vec4i = Vec4i()) = shl(res, this, bX, bY, bZ, bW)

    fun shl_(bX: Int, bY: Int, bZ: Int, bW: Int) = shl(this, this, bX, bY, bZ, bW)


    infix fun shr(b: Int) = shr(Vec4i(), this, b, b, b, b)
    infix fun shr(b: Vec4i) = shr(Vec4i(), this, b.x, b.y, b.z, b.w)

    infix fun shr_(b: Int) = shr(this, this, b, b, b, b)
    infix fun shr_(b: Vec4i) = shr(this, this, b.x, b.y, b.z, b.w)

    fun shr(b: Int, res: Vec4i) = shr(res, this, b, b, b, b)
    fun shr(b: Vec4i, res: Vec4i) = shr(res, this, b.x, b.y, b.z, b.w)

    fun shr(bX: Int, bY: Int, bZ: Int, bW: Int, res: Vec4i = Vec4i()) = shr(res, this, bX, bY, bZ, bW)

    fun shr_(bX: Int, bY: Int, bZ: Int, bW: Int) = shr(this, this, bX, bY, bZ, bW)


    fun inv(res: Vec4i = Vec4i()) = inv(res, this)
    fun inv_() = inv(this, this)


    // -- Generic bitwise operators --

    infix fun and(b: Number) = and(Vec4i(), this, b.i, b.i, b.i, b.i)
    infix fun and(b: Vec4t<out Number>) = and(Vec4i(), this, b.x.i, b.y.i, b.z.i, b.w.i)

    infix fun and_(b: Number) = and(this, this, b.i, b.i, b.i, b.i)
    infix fun and_(b: Vec4t<out Number>) = and(this, this, b.x.i, b.y.i, b.z.i, b.w.i)

    fun and(b: Number, res: Vec4i) = and(res, this, b.i, b.i, b.i, b.i)
    fun and(b: Vec4t<out Number>, res: Vec4i) = and(res, this, b.x.i, b.y.i, b.z.i, b.w.i)

    fun and(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4i = Vec4i()) = and(res, this, bX.i, bY.i, bZ.i, bW.i)

    fun and_(bX: Number, bY: Number, bZ: Number, bW: Number) = and(this, this, bX.i, bY.i, bZ.i, bW.i)


    infix fun or(b: Number) = or(Vec4i(), this, b.i, b.i, b.i, b.i)
    infix fun or(b: Vec4t<out Number>) = or(Vec4i(), this, b.x.i, b.y.i, b.z.i, b.w.i)

    infix fun or_(b: Number) = or(this, this, b.i, b.i, b.i, b.i)
    infix fun or_(b: Vec4t<out Number>) = or(this, this, b.x.i, b.y.i, b.z.i, b.w.i)

    fun or(b: Number, res: Vec4i) = or(res, this, b.i, b.i, b.i, b.i)
    fun or(b: Vec4t<out Number>, res: Vec4i) = or(res, this, b.x.i, b.y.i, b.z.i, b.w.i)

    fun or(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4i = Vec4i()) = or(res, this, bX.i, bY.i, bZ.i, bW.i)

    fun or_(bX: Number, bY: Number, bZ: Number, bW: Number) = or(this, this, bX.i, bY.i, bZ.i, bW.i)


    infix fun xor(b: Number) = xor(Vec4i(), this, b.i, b.i, b.i, b.i)
    infix fun xor(b: Vec4t<out Number>) = xor(Vec4i(), this, b.x.i, b.y.i, b.z.i, b.w.i)

    infix fun xor_(b: Number) = xor(this, this, b.i, b.i, b.i, b.i)
    infix fun xor_(b: Vec4t<out Number>) = xor(this, this, b.x.i, b.y.i, b.z.i, b.w.i)

    fun xor(b: Number, res: Vec4i) = xor(res, this, b.i, b.i, b.i, b.i)
    fun xor(b: Vec4t<out Number>, res: Vec4i) = xor(res, this, b.x.i, b.y.i, b.z.i, b.w.i)

    fun xor(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4i = Vec4i()) = xor(res, this, bX.i, bY.i, bZ.i, bW.i)

    fun xor_(bX: Number, bY: Number, bZ: Number, bW: Number) = xor(this, this, bX.i, bY.i, bZ.i, bW.i)


    infix fun shl(b: Number) = shl(Vec4i(), this, b.i, b.i, b.i, b.i)
    infix fun shl(b: Vec4t<out Number>) = shl(Vec4i(), this, b.x.i, b.y.i, b.z.i, b.w.i)

    infix fun shl_(b: Number) = shl(this, this, b.i, b.i, b.i, b.i)
    infix fun shl_(b: Vec4t<out Number>) = shl(this, this, b.x.i, b.y.i, b.z.i, b.w.i)

    fun shl(b: Number, res: Vec4i) = shl(res, this, b.i, b.i, b.i, b.i)
    fun shl(b: Vec4t<out Number>, res: Vec4i) = shl(res, this, b.x.i, b.y.i, b.z.i, b.w.i)

    fun shl(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4i = Vec4i()) = shl(res, this, bX.i, bY.i, bZ.i, bW.i)

    fun shl_(bX: Number, bY: Number, bZ: Number, bW: Number) = shl(this, this, bX.i, bY.i, bZ.i, bW.i)


    infix fun shr(b: Number) = shr(Vec4i(), this, b.i, b.i, b.i, b.i)
    infix fun shr(b: Vec4t<out Number>) = shr(Vec4i(), this, b.x.i, b.y.i, b.z.i, b.w.i)

    infix fun shr_(b: Number) = shr(this, this, b.i, b.i, b.i, b.i)
    infix fun shr_(b: Vec4t<out Number>) = shr(this, this, b.x.i, b.y.i, b.z.i, b.w.i)

    fun shr(b: Number, res: Vec4i) = shr(res, this, b.i, b.i, b.i, b.i)
    fun shr(b: Vec4t<out Number>, res: Vec4i) = shr(res, this, b.x.i, b.y.i, b.z.i, b.w.i)

    fun shr(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4i = Vec4i()) = shr(res, this, bX.i, bY.i, bZ.i, bW.i)

    fun shr_(bX: Number, bY: Number, bZ: Number, bW: Number) = shr(this, this, bX.i, bY.i, bZ.i, bW.i)


    override fun equals(other: Any?) =
            if (other is Vec4i)
                this[0] == other[0] && this[1] == other[1] && this[2] == other[2] && this[3] == other[3]
            else false
}