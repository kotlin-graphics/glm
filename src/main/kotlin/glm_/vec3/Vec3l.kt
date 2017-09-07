package glm_.vec3

import glm_.BYTES
import glm_.L
import glm_.getLong
import glm_.vec2.Vec2bool
import glm_.vec2.Vec2t
import glm_.vec3.operators.vec3l_operators
import glm_.vec4.Vec4bool
import glm_.vec4.Vec4t
import java.nio.*

/**
 * Created by elect on 09/10/16.
 */

class Vec3l(x: Long, y: Long, z: Long) : Vec3t<Long>(x, y, z) {

    // -- Explicit basic, conversion other main.and conversion vector constructors --

    constructor() : this(0)

    constructor(v: Vec2t<out Number>) : this(v.x, v.y, 0)
    constructor(v: Vec2t<out Number>, z: Number) : this(v.x, v.y, z)
    constructor(x: Number, v: Vec2t<out Number>) : this(x, v.x, v.y)
    constructor(v: Vec3t<out Number>) : this(v.x, v.y, v.z)
    constructor(v: Vec4t<out Number>) : this(v.x, v.y, v.z)

    constructor(v: Vec2bool) : this(v.x.L, v.y.L, 0)
    constructor(v: Vec3bool) : this(v.x.L, v.y.L, v.z.L)
    constructor(v: Vec4bool) : this(v.x.L, v.y.L, v.z.L)

    constructor(bytes: ByteArray, index: Int = 0, oneByteOneLong: Boolean = true, bigEndianess: Boolean = true) : this(
            if (oneByteOneLong) bytes[index].L else bytes.getLong(index, bigEndianess),
            if (oneByteOneLong) bytes[index + 1].L else bytes.getLong(index + Long.BYTES, bigEndianess),
            if (oneByteOneLong) bytes[index + 2].L else bytes.getLong(index + Long.BYTES * 2, bigEndianess))

    constructor(chars: CharArray, index: Int = 0) : this(chars[index].L, chars[index + 1].L, chars[index + 2].L)
    constructor(shorts: ShortArray, index: Int = 0) : this(shorts[index], shorts[index + 1], shorts[index + 2])
    constructor(ints: IntArray, index: Int = 0) : this(ints[index], ints[index + 1], ints[index + 2])
    constructor(longs: LongArray, index: Int = 0) : this(longs[index], longs[index + 1], longs[index + 2])
    constructor(floats: FloatArray, index: Int = 0) : this(floats[index], floats[index + 1], floats[index + 2])
    constructor(doubles: DoubleArray, index: Int = 0) : this(doubles[index], doubles[index + 1], doubles[index + 2])
    constructor(booleans: BooleanArray, index: Int = 0) : this(booleans[index].L, booleans[index + 1].L, booleans[index + 2].L)

    constructor(numbers: Array<out Number>, index: Int = 0) : this(numbers[index], numbers[index + 1], numbers[index + 2])
    constructor(chars: Array<Char>, index: Int = 0) : this(chars[index].L, chars[index + 1].L, chars[index + 2].L)
    constructor(booleans: Array<Boolean>, index: Int = 0) : this(booleans[index].L, booleans[index + 1].L, booleans[index + 2].L)

    constructor(list: List<Any>, index: Int = 0) : this(list[index].L, list[index + 1].L, list[index + 2].L)

    constructor(bytes: ByteBuffer, index: Int = bytes.position(), oneByteOneLong: Boolean = true) : this(
            if (oneByteOneLong) bytes[index].L else bytes.getLong(index),
            if (oneByteOneLong) bytes[index + 1].L else bytes.getLong(index + Long.BYTES),
            if (oneByteOneLong) bytes[index + 2].L else bytes.getLong(index + Long.BYTES * 2))

    constructor(chars: CharBuffer, index: Int = chars.position()) : this(chars[index].L, chars[index + 1].L, chars[index + 2].L)
    constructor(shorts: ShortBuffer, index: Int = shorts.position()) : this(shorts[index], shorts[index + 1], shorts[index + 2])
    constructor(ints: IntBuffer, index: Int = ints.position()) : this(ints[index], ints[index + 1], ints[index + 2])
    constructor(longs: LongBuffer, index: Int = longs.position()) : this(longs[index], longs[index + 1], longs[index + 2])
    constructor(floats: FloatBuffer, index: Int = floats.position()) : this(floats[index], floats[index + 1], floats[index + 2])
    constructor(doubles: DoubleBuffer, index: Int = doubles.position()) : this(doubles[index], doubles[index + 1], doubles[index + 2])

    constructor(s: Number) : this(s, s, s)
    constructor(x: Number, y: Number, z: Number) : this(x.L, y.L, z.L)


    fun set(bytes: ByteArray, index: Int = 0, oneByteOneLong: Boolean = true, bigEndianess: Boolean = true) {
        x = if (oneByteOneLong) bytes[index].L else bytes.getLong(index, bigEndianess)
        y = if (oneByteOneLong) bytes[index + 1].L else bytes.getLong(index + Long.BYTES, bigEndianess)
        z = if (oneByteOneLong) bytes[index + 2].L else bytes.getLong(index + Long.BYTES * 2, bigEndianess)
    }

    fun set(bytes: ByteBuffer, index: Int = bytes.position(), oneByteOneLong: Boolean = true) {
        x = if (oneByteOneLong) bytes[index].L else bytes.getLong(index)
        y = if (oneByteOneLong) bytes[index + 1].L else bytes.getLong(index + Long.BYTES)
        z = if (oneByteOneLong) bytes[index + 2].L else bytes.getLong(index + Long.BYTES * 2)
    }


    override fun put(x: Number, y: Number, z: Number): Vec3l {
        this.x = x.L
        this.y = y.L
        this.z = z.L
        return this
    }


    // -- Component accesses --

    override operator fun get(i: Int) = when (i) {
        0 -> x
        1 -> y
        2 -> z
        else -> throw ArrayIndexOutOfBoundsException()
    }

    operator fun set(i: Int, s: Number) = when (i) {
        0 -> x = s.L
        1 -> y = s.L
        2 -> z = s.L
        else -> throw ArrayIndexOutOfBoundsException()
    }


    companion object : vec3l_operators {
        @JvmField
        val length = 3
        @JvmField
        val size = length * Long.BYTES
    }


    // -- Unary arithmetic operators --

    operator fun unaryPlus() = this

    operator fun unaryMinus() = Vec3l(-x, -y, -z)

    // -- Increment main.and decrement operators --

    operator fun inc(res: Vec3l = Vec3l()) = plus(res, this, 1, 1, 1)
    fun inc_() = plus(this, this, 1, 1, 1)


    operator fun dec(res: Vec3l = Vec3l()) = minus(res, this, 1, 1, 1)
    fun dec_() = minus(this, this, 1, 1, 1)


    // -- Specific binary arithmetic operators --

    operator fun plus(b: Long) = plus(Vec3l(), this, b, b, b)
    operator fun plus(b: Vec3l) = plus(Vec3l(), this, b.x, b.y, b.z)

    fun plus(bX: Long, bY: Long, bZ: Long, res: Vec3l = Vec3l()) = plus(res, this, bX, bY, bZ)
    fun plus(b: Long, res: Vec3l = Vec3l()) = plus(res, this, b, b, b)
    fun plus(b: Vec3l, res: Vec3l = Vec3l()) = plus(res, this, b.x, b.y, b.z)

    fun plus_(bX: Long, bY: Long, bZ: Long) = plus(this, this, bX, bY, bZ)
    infix fun plus_(b: Long) = plus(this, this, b, b, b)
    infix fun plus_(b: Vec3l) = plus(this, this, b.x, b.y, b.z)


    operator fun minus(b: Long) = minus(Vec3l(), this, b, b, b)
    operator fun minus(b: Vec3l) = minus(Vec3l(), this, b.x, b.y, b.z)

    fun minus(bX: Long, bY: Long, bZ: Long, res: Vec3l = Vec3l()) = minus(res, this, bX, bY, bZ)
    fun minus(b: Long, res: Vec3l = Vec3l()) = minus(res, this, b, b, b)
    fun minus(b: Vec3l, res: Vec3l = Vec3l()) = minus(res, this, b.x, b.y, b.z)

    fun minus_(bX: Long, bY: Long, bZ: Long) = minus(this, this, bX, bY, bZ)
    infix fun minus_(b: Long) = minus(this, this, b, b, b)
    infix fun minus_(b: Vec3l) = minus(this, this, b.x, b.y, b.z)


    operator fun times(b: Long) = times(Vec3l(), this, b, b, b)
    operator fun times(b: Vec3l) = times(Vec3l(), this, b.x, b.y, b.z)

    fun times(bX: Long, bY: Long, bZ: Long, res: Vec3l = Vec3l()) = times(res, this, bX, bY, bZ)
    fun times(b: Long, res: Vec3l = Vec3l()) = times(res, this, b, b, b)
    fun times(b: Vec3l, res: Vec3l = Vec3l()) = times(res, this, b.x, b.y, b.z)

    fun times_(bX: Long, bY: Long, bZ: Long) = times(this, this, bX, bY, bZ)
    infix fun times_(b: Long) = times(this, this, b, b, b)
    infix fun times_(b: Vec3l) = times(this, this, b.x, b.y, b.z)


    operator fun div(b: Long) = div(Vec3l(), this, b, b, b)
    operator fun div(b: Vec3l) = div(Vec3l(), this, b.x, b.y, b.z)

    fun div(bX: Long, bY: Long, bZ: Long, res: Vec3l = Vec3l()) = div(res, this, bX, bY, bZ)
    fun div(b: Long, res: Vec3l) = div(res, this, b, b, b)
    fun div(b: Vec3l, res: Vec3l) = div(res, this, b.x, b.y, b.z)

    fun div_(bX: Long, bY: Long, bZ: Long) = div(this, this, bX, bY, bZ)
    infix fun div_(b: Long) = div(this, this, b, b, b)
    infix fun div_(b: Vec3l) = div(this, this, b.x, b.y, b.z)


    operator fun rem(b: Long) = rem(Vec3l(), this, b, b, b)
    operator fun rem(b: Vec3l) = rem(Vec3l(), this, b.x, b.y, b.z)

    fun rem(bX: Long, bY: Long, bZ: Long, res: Vec3l = Vec3l()) = rem(res, this, bX, bY, bZ)
    fun rem(b: Long, res: Vec3l) = rem(res, this, b, b, b)
    fun rem(b: Vec3l, res: Vec3l) = rem(res, this, b.x, b.y, b.z)

    fun rem_(bX: Long, bY: Long, bZ: Long) = rem(this, this, bX, bY, bZ)
    infix fun rem_(b: Long) = rem(this, this, b, b, b)
    infix fun rem_(b: Vec3l) = rem(this, this, b.x, b.y, b.z)


    // -- Generic binary arithmetic operators --

    operator fun plus(b: Number) = plus(Vec3l(), this, b.L, b.L, b.L)
    operator fun plus(b: Vec3t<out Number>) = plus(Vec3l(), this, b.x.L, b.y.L, b.z.L)

    fun plus(bX: Number, bY: Number, bZ: Number, res: Vec3l = Vec3l()) = plus(res, this, bX.L, bY.L, bZ.L)
    fun plus(b: Number, res: Vec3l = Vec3l()) = plus(res, this, b.L, b.L, b.L)
    fun plus(b: Vec3t<out Number>, res: Vec3l = Vec3l()) = plus(res, this, b.x.L, b.y.L, b.z.L)

    fun plus_(bX: Number, bY: Number, bZ: Number) = plus(this, this, bX.L, bY.L, bZ.L)
    infix fun plus_(b: Number) = plus(this, this, b.L, b.L, b.L)
    infix fun plus_(b: Vec3t<out Number>) = plus(this, this, b.x.L, b.y.L, b.z.L)


    operator fun minus(b: Number) = minus(Vec3l(), this, b.L, b.L, b.L)
    operator fun minus(b: Vec3t<out Number>) = minus(Vec3l(), this, b.x.L, b.y.L, b.z.L)

    fun minus(bX: Number, bY: Number, bZ: Number, res: Vec3l = Vec3l()) = minus(res, this, bX.L, bY.L, bZ.L)
    fun minus(b: Number, res: Vec3l = Vec3l()) = minus(res, this, b.L, b.L, b.L)
    fun minus(b: Vec3t<out Number>, res: Vec3l = Vec3l()) = minus(res, this, b.x.L, b.y.L, b.z.L)

    fun minus_(bX: Number, bY: Number, bZ: Number) = minus(this, this, bX.L, bY.L, bZ.L)
    infix fun minus_(b: Number) = minus(this, this, b.L, b.L, b.L)
    infix fun minus_(b: Vec3t<out Number>) = minus(this, this, b.x.L, b.y.L, b.z.L)


    operator fun times(b: Number) = times(Vec3l(), this, b.L, b.L, b.L)
    operator fun times(b: Vec3t<out Number>) = times(Vec3l(), this, b.x.L, b.y.L, b.z.L)

    fun times(bX: Number, bY: Number, bZ: Number, res: Vec3l = Vec3l()) = times(res, this, bX.L, bY.L, bZ.L)
    fun times(b: Number, res: Vec3l = Vec3l()) = times(res, this, b.L, b.L, b.L)
    fun times(b: Vec3t<out Number>, res: Vec3l = Vec3l()) = times(res, this, b.x.L, b.y.L, b.z.L)

    fun times_(bX: Number, bY: Number, bZ: Number) = times(this, this, bX.L, bY.L, bZ.L)
    infix fun times_(b: Number) = times(this, this, b.L, b.L, b.L)
    infix fun times_(b: Vec3t<out Number>) = times(this, this, b.x.L, b.y.L, b.z.L)


    operator fun div(b: Number) = div(Vec3l(), this, b.L, b.L, b.L)
    operator fun div(b: Vec3t<out Number>) = div(Vec3l(), this, b.x.L, b.y.L, b.z.L)

    fun div(bX: Number, bY: Number, bZ: Number, res: Vec3l = Vec3l()) = div(res, this, bX.L, bY.L, bZ.L)
    fun div(b: Number, res: Vec3l) = div(res, this, b.L, b.L, b.L)
    fun div(b: Vec3t<out Number>, res: Vec3l) = div(res, this, b.x.L, b.y.L, b.z.L)

    fun div_(bX: Number, bY: Number, bZ: Number) = div(this, this, bX.L, bY.L, bZ.L)
    infix fun div_(b: Number) = div(this, this, b.L, b.L, b.L)
    infix fun div_(b: Vec3t<out Number>) = div(this, this, b.x.L, b.y.L, b.z.L)


    operator fun rem(b: Number) = rem(Vec3l(), this, b.L, b.L, b.L)
    operator fun rem(b: Vec3t<out Number>) = rem(Vec3l(), this, b.x.L, b.y.L, b.z.L)

    fun rem(bX: Number, bY: Number, bZ: Number, res: Vec3l = Vec3l()) = rem(res, this, bX.L, bY.L, bZ.L)
    fun rem(b: Number, res: Vec3l) = rem(res, this, b.L, b.L, b.L)
    fun rem(b: Vec3t<out Number>, res: Vec3l) = rem(res, this, b.x.L, b.y.L, b.z.L)

    fun rem_(bX: Number, bY: Number, bZ: Number) = rem(this, this, bX.L, bY.L, bZ.L)
    infix fun rem_(b: Number) = rem(this, this, b.L, b.L, b.L)
    infix fun rem_(b: Vec3t<out Number>) = rem(this, this, b.x.L, b.y.L, b.z.L)


    // -- Specific bitwise operators --

    infix fun and(b: Long) = and(Vec3l(), this, b, b, b)
    infix fun and(b: Vec3l) = and(Vec3l(), this, b.x, b.y, b.z)

    infix fun and_(b: Long) = and(this, this, b, b, b)
    infix fun and_(b: Vec3l) = and(this, this, b.x, b.y, b.z)

    fun and(b: Long, res: Vec3l) = and(res, this, b, b, b)
    fun and(b: Vec3l, res: Vec3l) = and(res, this, b.x, b.y, b.z)

    fun and(bX: Long, bY: Long, bZ: Long, res: Vec3l = Vec3l()) = and(res, this, bX, bY, bZ)

    fun and_(bX: Long, bY: Long, bZ: Long) = and(this, this, bX, bY, bZ)


    infix fun or(b: Long) = or(Vec3l(), this, b, b, b)
    infix fun or(b: Vec3l) = or(Vec3l(), this, b.x, b.y, b.z)

    infix fun or_(b: Long) = or(this, this, b, b, b)
    infix fun or_(b: Vec3l) = or(this, this, b.x, b.y, b.z)

    fun or(b: Long, res: Vec3l) = or(res, this, b, b, b)
    fun or(b: Vec3l, res: Vec3l) = or(res, this, b.x, b.y, b.z)

    fun or(bX: Long, bY: Long, bZ: Long, res: Vec3l = Vec3l()) = or(res, this, bX, bY, bZ)

    fun or_(bX: Long, bY: Long, bZ: Long) = or(this, this, bX, bY, bZ)


    infix fun xor(b: Long) = xor(Vec3l(), this, b, b, b)
    infix fun xor(b: Vec3l) = xor(Vec3l(), this, b.x, b.y, b.z)

    infix fun xor_(b: Long) = xor(this, this, b, b, b)
    infix fun xor_(b: Vec3l) = xor(this, this, b.x, b.y, b.z)

    fun xor(b: Long, res: Vec3l) = xor(res, this, b, b, b)
    fun xor(b: Vec3l, res: Vec3l) = xor(res, this, b.x, b.y, b.z)

    fun xor(bX: Long, bY: Long, bZ: Long, res: Vec3l = Vec3l()) = xor(res, this, bX, bY, bZ)

    fun xor_(bX: Long, bY: Long, bZ: Long) = xor(this, this, bX, bY, bZ)


    infix fun shl(b: Long) = shl(Vec3l(), this, b, b, b)
    infix fun shl(b: Vec3l) = shl(Vec3l(), this, b.x, b.y, b.z)

    infix fun shl_(b: Long) = shl(this, this, b, b, b)
    infix fun shl_(b: Vec3l) = shl(this, this, b.x, b.y, b.z)

    fun shl(b: Long, res: Vec3l) = shl(res, this, b, b, b)
    fun shl(b: Vec3l, res: Vec3l) = shl(res, this, b.x, b.y, b.z)

    fun shl(bX: Long, bY: Long, bZ: Long, res: Vec3l = Vec3l()) = shl(res, this, bX, bY, bZ)

    fun shl_(bX: Long, bY: Long, bZ: Long) = shl(this, this, bX, bY, bZ)


    infix fun shr(b: Long) = shr(Vec3l(), this, b, b, b)
    infix fun shr(b: Vec3l) = shr(Vec3l(), this, b.x, b.y, b.z)

    infix fun shr_(b: Long) = shr(this, this, b, b, b)
    infix fun shr_(b: Vec3l) = shr(this, this, b.x, b.y, b.z)

    fun shr(b: Long, res: Vec3l) = shr(res, this, b, b, b)
    fun shr(b: Vec3l, res: Vec3l) = shr(res, this, b.x, b.y, b.z)

    fun shr(bX: Long, bY: Long, bZ: Long, res: Vec3l = Vec3l()) = shr(res, this, bX, bY, bZ)

    fun shr_(bX: Long, bY: Long, bZ: Long) = shr(this, this, bX, bY, bZ)


    fun inv(res: Vec3l = Vec3l()) = inv(res, this)
    fun inv_() = inv(this, this)


    // -- Generic bitwise operators --

    infix fun and(b: Number) = and(Vec3l(), this, b.L, b.L, b.L)
    infix fun and(b: Vec3t<out Number>) = and(Vec3l(), this, b.x.L, b.y.L, b.z.L)

    infix fun and_(b: Number) = and(this, this, b.L, b.L, b.L)
    infix fun and_(b: Vec3t<out Number>) = and(this, this, b.x.L, b.y.L, b.z.L)

    fun and(b: Number, res: Vec3l) = and(res, this, b.L, b.L, b.L)
    fun and(b: Vec3t<out Number>, res: Vec3l) = and(res, this, b.x.L, b.y.L, b.z.L)

    fun and(bX: Number, bY: Number, bZ: Number, res: Vec3l = Vec3l()) = and(res, this, bX.L, bY.L, bZ.L)

    fun and_(bX: Number, bY: Number, bZ: Number) = and(this, this, bX.L, bY.L, bZ.L)


    infix fun or(b: Number) = or(Vec3l(), this, b.L, b.L, b.L)
    infix fun or(b: Vec3t<out Number>) = or(Vec3l(), this, b.x.L, b.y.L, b.z.L)

    infix fun or_(b: Number) = or(this, this, b.L, b.L, b.L)
    infix fun or_(b: Vec3t<out Number>) = or(this, this, b.x.L, b.y.L, b.z.L)

    fun or(b: Number, res: Vec3l) = or(res, this, b.L, b.L, b.L)
    fun or(b: Vec3t<out Number>, res: Vec3l) = or(res, this, b.x.L, b.y.L, b.z.L)

    fun or(bX: Number, bY: Number, bZ: Number, res: Vec3l = Vec3l()) = or(res, this, bX.L, bY.L, bZ.L)

    fun or_(bX: Number, bY: Number, bZ: Number) = or(this, this, bX.L, bY.L, bZ.L)


    infix fun xor(b: Number) = xor(Vec3l(), this, b.L, b.L, b.L)
    infix fun xor(b: Vec3t<out Number>) = xor(Vec3l(), this, b.x.L, b.y.L, b.z.L)

    infix fun xor_(b: Number) = xor(this, this, b.L, b.L, b.L)
    infix fun xor_(b: Vec3t<out Number>) = xor(this, this, b.x.L, b.y.L, b.z.L)

    fun xor(b: Number, res: Vec3l) = xor(res, this, b.L, b.L, b.L)
    fun xor(b: Vec3t<out Number>, res: Vec3l) = xor(res, this, b.x.L, b.y.L, b.z.L)

    fun xor(bX: Number, bY: Number, bZ: Number, res: Vec3l = Vec3l()) = xor(res, this, bX.L, bY.L, bZ.L)

    fun xor_(bX: Number, bY: Number, bZ: Number) = xor(this, this, bX.L, bY.L, bZ.L)


    infix fun shl(b: Number) = shl(Vec3l(), this, b.L, b.L, b.L)
    infix fun shl(b: Vec3t<out Number>) = shl(Vec3l(), this, b.x.L, b.y.L, b.z.L)

    infix fun shl_(b: Number) = shl(this, this, b.L, b.L, b.L)
    infix fun shl_(b: Vec3t<out Number>) = shl(this, this, b.x.L, b.y.L, b.z.L)

    fun shl(b: Number, res: Vec3l) = shl(res, this, b.L, b.L, b.L)
    fun shl(b: Vec3t<out Number>, res: Vec3l) = shl(res, this, b.x.L, b.y.L, b.z.L)

    fun shl(bX: Number, bY: Number, bZ: Number, res: Vec3l = Vec3l()) = shl(res, this, bX.L, bY.L, bZ.L)

    fun shl_(bX: Number, bY: Number, bZ: Number) = shl(this, this, bX.L, bY.L, bZ.L)


    infix fun shr(b: Number) = shr(Vec3l(), this, b.L, b.L, b.L)
    infix fun shr(b: Vec3t<out Number>) = shr(Vec3l(), this, b.x.L, b.y.L, b.z.L)

    infix fun shr_(b: Number) = shr(this, this, b.L, b.L, b.L)
    infix fun shr_(b: Vec3t<out Number>) = shr(this, this, b.x.L, b.y.L, b.z.L)

    fun shr(b: Number, res: Vec3l) = shr(res, this, b.L, b.L, b.L)
    fun shr(b: Vec3t<out Number>, res: Vec3l) = shr(res, this, b.x.L, b.y.L, b.z.L)

    fun shr(bX: Number, bY: Number, bZ: Number, res: Vec3l = Vec3l()) = shr(res, this, bX.L, bY.L, bZ.L)

    fun shr_(bX: Number, bY: Number, bZ: Number) = shr(this, this, bX.L, bY.L, bZ.L)


    override fun equals(other: Any?) =
            if (other is Vec3l)
                this[0] == other[0] && this[1] == other[1] && this[2] == other[2]
            else false
}