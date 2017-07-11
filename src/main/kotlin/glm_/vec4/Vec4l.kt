package glm_.vec4

import glm_.BYTES
import glm_.L
import glm_.getLong
import glm_.vec2.Vec2bool
import glm_.vec2.Vec2t
import glm_.vec3.Vec3bool
import glm_.vec3.Vec3t
import glm_.vec4.operators.vec4l_operators
import java.nio.*

/**
 * Created by elect on 09/10/16.
 */

class Vec4l(x: Long, y: Long, z: Long, w: Long) : Vec4t<Long>(x, y, z, w) {

    // -- Explicit basic, conversion other main.and conversion vector constructors --

    constructor() : this(0)

    constructor(v: Vec2t<out Number>) : this(v.x, v.y, 0, 1)
    constructor(v: Vec2t<out Number>, z: Number, w: Number) : this(v.x, v.y, z, w)
    constructor(v: Vec3t<out Number>) : this(v, 1)
    constructor(v: Vec3t<out Number>, w: Number) : this(v.x, v.y, v.z, w)
    constructor(x: Number, v: Vec3t<out Number>) : this(x, v.x, v.y, v.z)
    constructor(v: Vec4t<out Number>) : this(v.x, v.y, v.z, v.w)

    constructor(v: Vec2bool) : this(v.x.L, v.y.L, 0, 1)
    constructor(v: Vec3bool) : this(v.x.L, v.y.L, v.z.L, 1)
    constructor(v: Vec4bool) : this(v.x.L, v.y.L, v.z.L, v.w.L)

    constructor(bytes: ByteArray, index: Int = 0, oneByteOneLong: Boolean = true, bigEndianess: Boolean = true) : this(
            if (oneByteOneLong) bytes[index].L else bytes.getLong(index, bigEndianess),
            if (oneByteOneLong) bytes[index + 1].L else bytes.getLong(index + Long.BYTES, bigEndianess),
            if (oneByteOneLong) bytes[index + 2].L else bytes.getLong(index + Long.BYTES * 2, bigEndianess),
            if (oneByteOneLong) bytes[index + 3].L else bytes.getLong(index + Long.BYTES * 3, bigEndianess))

    constructor(chars: CharArray, index: Int = 0) : this(chars[index].L, chars[index + 1].L, chars[index + 2].L, chars[index + 3].L)
    constructor(shorts: ShortArray, index: Int = 0) : this(shorts[index], shorts[index + 1], shorts[index + 2], shorts[index + 3])
    constructor(ints: IntArray, index: Int = 0) : this(ints[index], ints[index + 1], ints[index + 2], ints[index + 3])
    constructor(longs: LongArray, index: Int = 0) : this(longs[index], longs[index + 1], longs[index + 2], longs[index + 3])
    constructor(floats: FloatArray, index: Int = 0) : this(floats[index], floats[index + 1], floats[index + 2], floats[index + 3])
    constructor(doubles: DoubleArray, index: Int = 0) : this(doubles[index], doubles[index + 1], doubles[index + 2], doubles[index + 3])
    constructor(booleans: BooleanArray, index: Int = 0) : this(booleans[index].L, booleans[index + 1].L, booleans[index + 2].L, booleans[index + 3].L)

    constructor(numbers: Array<out Number>, index: Int = 0) : this(numbers[index], numbers[index + 1], numbers[index + 2], numbers[index + 3])
    constructor(chars: Array<Char>, index: Int = 0) : this(chars[index].L, chars[index + 1].L, chars[index + 2].L, chars[index + 3].L)
    constructor(booleans: Array<Boolean>, index: Int = 0) : this(booleans[index].L, booleans[index + 1].L, booleans[index + 2].L, booleans[index + 3].L)

    constructor(list: List<Any>, index: Int = 0) : this() {
        put(list, index)
    }

    constructor(bytes: ByteBuffer, index: Int = bytes.position(), oneByteOneLong: Boolean = true) : this(
            if (oneByteOneLong) bytes[index].L else bytes.getLong(index),
            if (oneByteOneLong) bytes[index + 1].L else bytes.getLong(index + Long.BYTES),
            if (oneByteOneLong) bytes[index + 2].L else bytes.getLong(index + Long.BYTES * 2),
            if (oneByteOneLong) bytes[index + 3].L else bytes.getLong(index + Long.BYTES * 3))

    constructor(chars: CharBuffer, index: Int = chars.position()) : this(chars[index].L, chars[index + 1].L, chars[index + 2].L, chars[index + 3].L)
    constructor(shorts: ShortBuffer, index: Int = shorts.position()) : this(shorts[index], shorts[index + 1], shorts[index + 2], shorts[index + 3])
    constructor(ints: IntBuffer, index: Int = ints.position()) : this(ints[index], ints[index + 1], ints[index + 2], ints[index + 3])
    constructor(longs: LongBuffer, index: Int = longs.position()) : this(longs[index], longs[index + 1], longs[index + 2], longs[index + 3])
    constructor(floats: FloatBuffer, index: Int = floats.position()) : this(floats[index], floats[index + 1], floats[index + 2], floats[index + 3])
    constructor(doubles: DoubleBuffer, index: Int = doubles.position()) : this(doubles[index], doubles[index + 1], doubles[index + 2], doubles[index + 3])

    constructor(s: Number) : this(s, s, s, s)
    constructor(x: Number, y: Number, z: Number, w: Number) : this(x.L, y.L, z.L, w.L)


    fun set(bytes: ByteArray, index: Int = 0, oneByteOneLong: Boolean = true, bigEndianess: Boolean = true) {
        x = if (oneByteOneLong) bytes[index].L else bytes.getLong(index, bigEndianess)
        y = if (oneByteOneLong) bytes[index + 1].L else bytes.getLong(index + Long.BYTES, bigEndianess)
        z = if (oneByteOneLong) bytes[index + 2].L else bytes.getLong(index + Long.BYTES * 2, bigEndianess)
        w = if (oneByteOneLong) bytes[index + 3].L else bytes.getLong(index + Long.BYTES * 3, bigEndianess)
    }

    fun set(bytes: ByteBuffer, index: Int = bytes.position(), oneByteOneLong: Boolean = true) {
        x = if (oneByteOneLong) bytes[index].L else bytes.getLong(index)
        y = if (oneByteOneLong) bytes[index + 1].L else bytes.getLong(index + Long.BYTES)
        z = if (oneByteOneLong) bytes[index + 2].L else bytes.getLong(index + Long.BYTES * 2)
        w = if (oneByteOneLong) bytes[index + 3].L else bytes.getLong(index + Long.BYTES * 3)
    }


    override fun put(x: Number, y: Number, z: Number, w: Number): Vec4l {
        this.x = x.L
        this.y = y.L
        this.z = z.L
        this.w = w.L
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
        0 -> x = s.L
        1 -> y = s.L
        2 -> z = s.L
        3 -> w = s.L
        else -> throw ArrayIndexOutOfBoundsException()
    }


    companion object : vec4l_operators {
        @JvmField val length = 4
        @JvmField val size = length * Long.BYTES
    }

    override fun instanceSize() = Vec4l.size

    override infix fun to(bytes: ByteBuffer) = to(bytes, bytes.position())

    override fun to(bytes: ByteBuffer, index: Int): ByteBuffer {
        bytes.putLong(index, x)
        bytes.putLong(index + Long.BYTES, y)
        bytes.putLong(index + Long.BYTES * 2, z)
        bytes.putLong(index + Long.BYTES * 3, w)
        return bytes
    }


    // -- Unary arithmetic operators --

    operator fun unaryPlus() = this

    operator fun unaryMinus() = Vec4l(-x, -y, -z, -w)

    // -- Increment main.and decrement operators --

    operator fun inc(res: Vec4l = Vec4l()) = plus(res, this, 1, 1, 1, 1)
    fun inc_() = plus(this, this, 1, 1, 1, 1)


    operator fun dec(res: Vec4l = Vec4l()) = minus(res, this, 1, 1, 1, 1)
    fun dec_() = minus(this, this, 1, 1, 1, 1)


    // -- Specific binary arithmetic operators --

    operator fun plus(b: Long) = plus(Vec4l(), this, b, b, b, b)
    operator fun plus(b: Vec4l) = plus(Vec4l(), this, b.x, b.y, b.z, b.w)

    fun plus(bX: Long, bY: Long, bZ: Long, bW: Long, res: Vec4l = Vec4l()) = plus(res, this, bX, bY, bZ, bW)
    fun plus(b: Long, res: Vec4l = Vec4l()) = plus(res, this, b, b, b, b)
    fun plus(b: Vec4l, res: Vec4l = Vec4l()) = plus(res, this, b.x, b.y, b.z, b.w)

    fun plus_(bX: Long, bY: Long, bZ: Long, bW: Long) = plus(this, this, bX, bY, bZ, bW)
    infix fun plus_(b: Long) = plus(this, this, b, b, b, b)
    infix fun plus_(b: Vec4l) = plus(this, this, b.x, b.y, b.z, b.w)


    operator fun minus(b: Long) = minus(Vec4l(), this, b, b, b, b)
    operator fun minus(b: Vec4l) = minus(Vec4l(), this, b.x, b.y, b.z, b.w)

    fun minus(bX: Long, bY: Long, bZ: Long, bW: Long, res: Vec4l = Vec4l()) = minus(res, this, bX, bY, bZ, bW)
    fun minus(b: Long, res: Vec4l = Vec4l()) = minus(res, this, b, b, b, b)
    fun minus(b: Vec4l, res: Vec4l = Vec4l()) = minus(res, this, b.x, b.y, b.z, b.w)

    fun minus_(bX: Long, bY: Long, bZ: Long, bW: Long) = minus(this, this, bX, bY, bZ, bW)
    infix fun minus_(b: Long) = minus(this, this, b, b, b, b)
    infix fun minus_(b: Vec4l) = minus(this, this, b.x, b.y, b.z, b.w)


    operator fun times(b: Long) = times(Vec4l(), this, b, b, b, b)
    operator fun times(b: Vec4l) = times(Vec4l(), this, b.x, b.y, b.z, b.w)

    fun times(bX: Long, bY: Long, bZ: Long, bW: Long, res: Vec4l = Vec4l()) = times(res, this, bX, bY, bZ, bW)
    fun times(b: Long, res: Vec4l = Vec4l()) = times(res, this, b, b, b, b)
    fun times(b: Vec4l, res: Vec4l = Vec4l()) = times(res, this, b.x, b.y, b.z, b.w)

    fun times_(bX: Long, bY: Long, bZ: Long, bW: Long) = times(this, this, bX, bY, bZ, bW)
    infix fun times_(b: Long) = times(this, this, b, b, b, b)
    infix fun times_(b: Vec4l) = times(this, this, b.x, b.y, b.z, b.w)


    operator fun div(b: Long) = div(Vec4l(), this, b, b, b, b)
    operator fun div(b: Vec4l) = div(Vec4l(), this, b.x, b.y, b.z, b.w)

    fun div(bX: Long, bY: Long, bZ: Long, bW: Long, res: Vec4l = Vec4l()) = div(res, this, bX, bY, bZ, bW)
    fun div(b: Long, res: Vec4l) = div(res, this, b, b, b, b)
    fun div(b: Vec4l, res: Vec4l) = div(res, this, b.x, b.y, b.z, b.w)

    fun div_(bX: Long, bY: Long, bZ: Long, bW: Long) = div(this, this, bX, bY, bZ, bW)
    infix fun div_(b: Long) = div(this, this, b, b, b, b)
    infix fun div_(b: Vec4l) = div(this, this, b.x, b.y, b.z, b.w)


    operator fun rem(b: Long) = rem(Vec4l(), this, b, b, b, b)
    operator fun rem(b: Vec4l) = rem(Vec4l(), this, b.x, b.y, b.z, b.w)

    fun rem(bX: Long, bY: Long, bZ: Long, bW: Long, res: Vec4l = Vec4l()) = rem(res, this, bX, bY, bZ, bW)
    fun rem(b: Long, res: Vec4l) = rem(res, this, b, b, b, b)
    fun rem(b: Vec4l, res: Vec4l) = rem(res, this, b.x, b.y, b.z, b.w)

    fun rem_(bX: Long, bY: Long, bZ: Long, bW: Long) = rem(this, this, bX, bY, bZ, bW)
    infix fun rem_(b: Long) = rem(this, this, b, b, b, b)
    infix fun rem_(b: Vec4l) = rem(this, this, b.x, b.y, b.z, b.w)


    // -- Generic binary arithmetic operators --

    operator fun plus(b: Number) = plus(Vec4l(), this, b.L, b.L, b.L, b.L)
    operator fun plus(b: Vec4t<out Number>) = plus(Vec4l(), this, b.x.L, b.y.L, b.z.L, b.w.L)

    fun plus(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4l = Vec4l()) = plus(res, this, bX.L, bY.L, bZ.L, bW.L)
    fun plus(b: Number, res: Vec4l = Vec4l()) = plus(res, this, b.L, b.L, b.L, b.L)
    fun plus(b: Vec4t<out Number>, res: Vec4l = Vec4l()) = plus(res, this, b.x.L, b.y.L, b.z.L, b.w.L)

    fun plus_(bX: Number, bY: Number, bZ: Number, bW: Number) = plus(this, this, bX.L, bY.L, bZ.L, bW.L)
    infix fun plus_(b: Number) = plus(this, this, b.L, b.L, b.L, b.L)
    infix fun plus_(b: Vec4t<out Number>) = plus(this, this, b.x.L, b.y.L, b.z.L, b.w.L)


    operator fun minus(b: Number) = minus(Vec4l(), this, b.L, b.L, b.L, b.L)
    operator fun minus(b: Vec4t<out Number>) = minus(Vec4l(), this, b.x.L, b.y.L, b.z.L, b.w.L)

    fun minus(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4l = Vec4l()) = minus(res, this, bX.L, bY.L, bZ.L, bW.L)
    fun minus(b: Number, res: Vec4l = Vec4l()) = minus(res, this, b.L, b.L, b.L, b.L)
    fun minus(b: Vec4t<out Number>, res: Vec4l = Vec4l()) = minus(res, this, b.x.L, b.y.L, b.z.L, b.w.L)

    fun minus_(bX: Number, bY: Number, bZ: Number, bW: Number) = minus(this, this, bX.L, bY.L, bZ.L, bW.L)
    infix fun minus_(b: Number) = minus(this, this, b.L, b.L, b.L, b.L)
    infix fun minus_(b: Vec4t<out Number>) = minus(this, this, b.x.L, b.y.L, b.z.L, b.w.L)


    operator fun times(b: Number) = times(Vec4l(), this, b.L, b.L, b.L, b.L)
    operator fun times(b: Vec4t<out Number>) = times(Vec4l(), this, b.x.L, b.y.L, b.z.L, b.w.L)

    fun times(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4l = Vec4l()) = times(res, this, bX.L, bY.L, bZ.L, bW.L)
    fun times(b: Number, res: Vec4l = Vec4l()) = times(res, this, b.L, b.L, b.L, b.L)
    fun times(b: Vec4t<out Number>, res: Vec4l = Vec4l()) = times(res, this, b.x.L, b.y.L, b.z.L, b.w.L)

    fun times_(bX: Number, bY: Number, bZ: Number, bW: Number) = times(this, this, bX.L, bY.L, bZ.L, bW.L)
    infix fun times_(b: Number) = times(this, this, b.L, b.L, b.L, b.L)
    infix fun times_(b: Vec4t<out Number>) = times(this, this, b.x.L, b.y.L, b.z.L, b.w.L)


    operator fun div(b: Number) = div(Vec4l(), this, b.L, b.L, b.L, b.L)
    operator fun div(b: Vec4t<out Number>) = div(Vec4l(), this, b.x.L, b.y.L, b.z.L, b.w.L)

    fun div(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4l = Vec4l()) = div(res, this, bX.L, bY.L, bZ.L, bW.L)
    fun div(b: Number, res: Vec4l) = div(res, this, b.L, b.L, b.L, b.L)
    fun div(b: Vec4t<out Number>, res: Vec4l) = div(res, this, b.x.L, b.y.L, b.z.L, b.w.L)

    fun div_(bX: Number, bY: Number, bZ: Number, bW: Number) = div(this, this, bX.L, bY.L, bZ.L, bW.L)
    infix fun div_(b: Number) = div(this, this, b.L, b.L, b.L, b.L)
    infix fun div_(b: Vec4t<out Number>) = div(this, this, b.x.L, b.y.L, b.z.L, b.w.L)


    operator fun rem(b: Number) = rem(Vec4l(), this, b.L, b.L, b.L, b.L)
    operator fun rem(b: Vec4t<out Number>) = rem(Vec4l(), this, b.x.L, b.y.L, b.z.L, b.w.L)

    fun rem(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4l = Vec4l()) = rem(res, this, bX.L, bY.L, bZ.L, bW.L)
    fun rem(b: Number, res: Vec4l) = rem(res, this, b.L, b.L, b.L, b.L)
    fun rem(b: Vec4t<out Number>, res: Vec4l) = rem(res, this, b.x.L, b.y.L, b.z.L, b.w.L)

    fun rem_(bX: Number, bY: Number, bZ: Number, bW: Number) = rem(this, this, bX.L, bY.L, bZ.L, bW.L)
    infix fun rem_(b: Number) = rem(this, this, b.L, b.L, b.L, b.L)
    infix fun rem_(b: Vec4t<out Number>) = rem(this, this, b.x.L, b.y.L, b.z.L, b.w.L)


    // -- Specific bitwise operators --

    infix fun and(b: Long) = and(Vec4l(), this, b, b, b, b)
    infix fun and(b: Vec4l) = and(Vec4l(), this, b.x, b.y, b.z, b.w)

    infix fun and_(b: Long) = and(this, this, b, b, b, b)
    infix fun and_(b: Vec4l) = and(this, this, b.x, b.y, b.z, b.w)

    fun and(b: Long, res: Vec4l) = and(res, this, b, b, b, b)
    fun and(b: Vec4l, res: Vec4l) = and(res, this, b.x, b.y, b.z, b.w)

    fun and(bX: Long, bY: Long, bZ: Long, bW: Long, res: Vec4l = Vec4l()) = and(res, this, bX, bY, bZ, bW)

    fun and_(bX: Long, bY: Long, bZ: Long, bW: Long) = and(this, this, bX, bY, bZ, bW)


    infix fun or(b: Long) = or(Vec4l(), this, b, b, b, b)
    infix fun or(b: Vec4l) = or(Vec4l(), this, b.x, b.y, b.z, b.w)

    infix fun or_(b: Long) = or(this, this, b, b, b, b)
    infix fun or_(b: Vec4l) = or(this, this, b.x, b.y, b.z, b.w)

    fun or(b: Long, res: Vec4l) = or(res, this, b, b, b, b)
    fun or(b: Vec4l, res: Vec4l) = or(res, this, b.x, b.y, b.z, b.w)

    fun or(bX: Long, bY: Long, bZ: Long, bW: Long, res: Vec4l = Vec4l()) = or(res, this, bX, bY, bZ, bW)

    fun or_(bX: Long, bY: Long, bZ: Long, bW: Long) = or(this, this, bX, bY, bZ, bW)


    infix fun xor(b: Long) = xor(Vec4l(), this, b, b, b, b)
    infix fun xor(b: Vec4l) = xor(Vec4l(), this, b.x, b.y, b.z, b.w)

    infix fun xor_(b: Long) = xor(this, this, b, b, b, b)
    infix fun xor_(b: Vec4l) = xor(this, this, b.x, b.y, b.z, b.w)

    fun xor(b: Long, res: Vec4l) = xor(res, this, b, b, b, b)
    fun xor(b: Vec4l, res: Vec4l) = xor(res, this, b.x, b.y, b.z, b.w)

    fun xor(bX: Long, bY: Long, bZ: Long, bW: Long, res: Vec4l = Vec4l()) = xor(res, this, bX, bY, bZ, bW)

    fun xor_(bX: Long, bY: Long, bZ: Long, bW: Long) = xor(this, this, bX, bY, bZ, bW)


    infix fun shl(b: Long) = shl(Vec4l(), this, b, b, b, b)
    infix fun shl(b: Vec4l) = shl(Vec4l(), this, b.x, b.y, b.z, b.w)

    infix fun shl_(b: Long) = shl(this, this, b, b, b, b)
    infix fun shl_(b: Vec4l) = shl(this, this, b.x, b.y, b.z, b.w)

    fun shl(b: Long, res: Vec4l) = shl(res, this, b, b, b, b)
    fun shl(b: Vec4l, res: Vec4l) = shl(res, this, b.x, b.y, b.z, b.w)

    fun shl(bX: Long, bY: Long, bZ: Long, bW: Long, res: Vec4l = Vec4l()) = shl(res, this, bX, bY, bZ, bW)

    fun shl_(bX: Long, bY: Long, bZ: Long, bW: Long) = shl(this, this, bX, bY, bZ, bW)


    infix fun shr(b: Long) = shr(Vec4l(), this, b, b, b, b)
    infix fun shr(b: Vec4l) = shr(Vec4l(), this, b.x, b.y, b.z, b.w)

    infix fun shr_(b: Long) = shr(this, this, b, b, b, b)
    infix fun shr_(b: Vec4l) = shr(this, this, b.x, b.y, b.z, b.w)

    fun shr(b: Long, res: Vec4l) = shr(res, this, b, b, b, b)
    fun shr(b: Vec4l, res: Vec4l) = shr(res, this, b.x, b.y, b.z, b.w)

    fun shr(bX: Long, bY: Long, bZ: Long, bW: Long, res: Vec4l = Vec4l()) = shr(res, this, bX, bY, bZ, bW)

    fun shr_(bX: Long, bY: Long, bZ: Long, bW: Long) = shr(this, this, bX, bY, bZ, bW)


    fun inv(res: Vec4l = Vec4l()) = inv(res, this)
    fun inv_() = inv(this, this)


    // -- Generic bitwise operators --

    infix fun and(b: Number) = and(Vec4l(), this, b.L, b.L, b.L, b.L)
    infix fun and(b: Vec4t<out Number>) = and(Vec4l(), this, b.x.L, b.y.L, b.z.L, b.w.L)

    infix fun and_(b: Number) = and(this, this, b.L, b.L, b.L, b.L)
    infix fun and_(b: Vec4t<out Number>) = and(this, this, b.x.L, b.y.L, b.z.L, b.w.L)

    fun and(b: Number, res: Vec4l) = and(res, this, b.L, b.L, b.L, b.L)
    fun and(b: Vec4t<out Number>, res: Vec4l) = and(res, this, b.x.L, b.y.L, b.z.L, b.w.L)

    fun and(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4l = Vec4l()) = and(res, this, bX.L, bY.L, bZ.L, bW.L)

    fun and_(bX: Number, bY: Number, bZ: Number, bW: Number) = and(this, this, bX.L, bY.L, bZ.L, bW.L)


    infix fun or(b: Number) = or(Vec4l(), this, b.L, b.L, b.L, b.L)
    infix fun or(b: Vec4t<out Number>) = or(Vec4l(), this, b.x.L, b.y.L, b.z.L, b.w.L)

    infix fun or_(b: Number) = or(this, this, b.L, b.L, b.L, b.L)
    infix fun or_(b: Vec4t<out Number>) = or(this, this, b.x.L, b.y.L, b.z.L, b.w.L)

    fun or(b: Number, res: Vec4l) = or(res, this, b.L, b.L, b.L, b.L)
    fun or(b: Vec4t<out Number>, res: Vec4l) = or(res, this, b.x.L, b.y.L, b.z.L, b.w.L)

    fun or(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4l = Vec4l()) = or(res, this, bX.L, bY.L, bZ.L, bW.L)

    fun or_(bX: Number, bY: Number, bZ: Number, bW: Number) = or(this, this, bX.L, bY.L, bZ.L, bW.L)


    infix fun xor(b: Number) = xor(Vec4l(), this, b.L, b.L, b.L, b.L)
    infix fun xor(b: Vec4t<out Number>) = xor(Vec4l(), this, b.x.L, b.y.L, b.z.L, b.w.L)

    infix fun xor_(b: Number) = xor(this, this, b.L, b.L, b.L, b.L)
    infix fun xor_(b: Vec4t<out Number>) = xor(this, this, b.x.L, b.y.L, b.z.L, b.w.L)

    fun xor(b: Number, res: Vec4l) = xor(res, this, b.L, b.L, b.L, b.L)
    fun xor(b: Vec4t<out Number>, res: Vec4l) = xor(res, this, b.x.L, b.y.L, b.z.L, b.w.L)

    fun xor(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4l = Vec4l()) = xor(res, this, bX.L, bY.L, bZ.L, bW.L)

    fun xor_(bX: Number, bY: Number, bZ: Number, bW: Number) = xor(this, this, bX.L, bY.L, bZ.L, bW.L)


    infix fun shl(b: Number) = shl(Vec4l(), this, b.L, b.L, b.L, b.L)
    infix fun shl(b: Vec4t<out Number>) = shl(Vec4l(), this, b.x.L, b.y.L, b.z.L, b.w.L)

    infix fun shl_(b: Number) = shl(this, this, b.L, b.L, b.L, b.L)
    infix fun shl_(b: Vec4t<out Number>) = shl(this, this, b.x.L, b.y.L, b.z.L, b.w.L)

    fun shl(b: Number, res: Vec4l) = shl(res, this, b.L, b.L, b.L, b.L)
    fun shl(b: Vec4t<out Number>, res: Vec4l) = shl(res, this, b.x.L, b.y.L, b.z.L, b.w.L)

    fun shl(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4l = Vec4l()) = shl(res, this, bX.L, bY.L, bZ.L, bW.L)

    fun shl_(bX: Number, bY: Number, bZ: Number, bW: Number) = shl(this, this, bX.L, bY.L, bZ.L, bW.L)


    infix fun shr(b: Number) = shr(Vec4l(), this, b.L, b.L, b.L, b.L)
    infix fun shr(b: Vec4t<out Number>) = shr(Vec4l(), this, b.x.L, b.y.L, b.z.L, b.w.L)

    infix fun shr_(b: Number) = shr(this, this, b.L, b.L, b.L, b.L)
    infix fun shr_(b: Vec4t<out Number>) = shr(this, this, b.x.L, b.y.L, b.z.L, b.w.L)

    fun shr(b: Number, res: Vec4l) = shr(res, this, b.L, b.L, b.L, b.L)
    fun shr(b: Vec4t<out Number>, res: Vec4l) = shr(res, this, b.x.L, b.y.L, b.z.L, b.w.L)

    fun shr(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4l = Vec4l()) = shr(res, this, bX.L, bY.L, bZ.L, bW.L)

    fun shr_(bX: Number, bY: Number, bZ: Number, bW: Number) = shr(this, this, bX.L, bY.L, bZ.L, bW.L)


    override fun equals(other: Any?) =
            if (other is Vec4l)
                this[0] == other[0] && this[1] == other[1] && this[2] == other[2] && this[3] == other[3]
            else false
}