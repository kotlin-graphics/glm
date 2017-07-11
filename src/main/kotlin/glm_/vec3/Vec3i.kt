package glm_.vec3

import glm_.BYTES
import glm_.getInt
import glm_.i
import glm_.vec2.Vec2bool
import glm_.vec2.Vec2t
import glm_.vec3.operators.vec3i_operators
import glm_.vec4.Vec4bool
import glm_.vec4.Vec4t
import java.nio.*

/**
 * Created by elect on 08/10/16.
 */

class Vec3i(x: Int, y: Int, z: Int) : Vec3t<Int>(x, y, z) {

    // -- Explicit basic, conversion other main.and conversion vector constructors --

    constructor() : this(0)

    constructor(v: Vec2t<out Number>) : this(v.x, v.y, 0)
    constructor(v: Vec2t<out Number>, z: Number) : this(v.x, v.y, z)
    constructor(x: Number, v: Vec2t<out Number>) : this(x, v.x, v.y)    // TODO all combo
    constructor(v: Vec3t<out Number>) : this(v.x, v.y, v.z)
    constructor(v: Vec4t<out Number>) : this(v.x, v.y, v.z)

    constructor(v: Vec2bool) : this(v.x.i, v.y.i, 0)
    constructor(v: Vec3bool) : this(v.x.i, v.y.i, v.z.i)
    constructor(v: Vec4bool) : this(v.x.i, v.y.i, v.z.i)

    constructor(bytes: ByteArray, index: Int = 0, oneByteOneInt: Boolean = true, bigEndianess: Boolean = true) : this(
            if (oneByteOneInt) bytes[index].i else bytes.getInt(index, bigEndianess),
            if (oneByteOneInt) bytes[index + 1].i else bytes.getInt(index + Int.BYTES, bigEndianess),
            if (oneByteOneInt) bytes[index + 2].i else bytes.getInt(index + Int.BYTES * 2, bigEndianess))

    constructor(chars: CharArray, index: Int = 0) : this(chars[index].i, chars[index + 1].i, chars[index + 2].i)
    constructor(shorts: ShortArray, index: Int = 0) : this(shorts[index], shorts[index + 1], shorts[index + 2])
    constructor(ints: IntArray, index: Int = 0) : this(ints[index], ints[index + 1], ints[index + 2])
    constructor(longs: LongArray, index: Int = 0) : this(longs[index], longs[index + 1], longs[index + 2])
    constructor(floats: FloatArray, index: Int = 0) : this(floats[index], floats[index + 1], floats[index + 2])
    constructor(doubles: DoubleArray, index: Int = 0) : this(doubles[index], doubles[index + 1], doubles[index + 2])
    constructor(booleans: BooleanArray, index: Int = 0) : this(booleans[index].i, booleans[index + 1].i, booleans[index + 2].i)

    constructor(numbers: Array<out Number>, index: Int = 0) : this(numbers[index], numbers[index + 1], numbers[index + 2])
    constructor(chars: Array<Char>, index: Int = 0) : this(chars[index].i, chars[index + 1].i, chars[index + 2].i)
    constructor(booleans: Array<Boolean>, index: Int = 0) : this(booleans[index].i, booleans[index + 1].i, booleans[index + 2].i)

    constructor(list: List<Any>, index: Int = 0) : this() {
        put(list, index)
    }

    constructor(bytes: ByteBuffer, index: Int = bytes.position(), oneByteOneInt: Boolean = true) : this(
            if (oneByteOneInt) bytes[index].i else bytes.getInt(index),
            if (oneByteOneInt) bytes[index + 1].i else bytes.getInt(index + Int.BYTES),
            if (oneByteOneInt) bytes[index + 2].i else bytes.getInt(index + Int.BYTES * 2))

    constructor(chars: CharBuffer, index: Int = chars.position()) : this(chars[index].i, chars[index + 1].i, chars[index + 2].i)
    constructor(shorts: ShortBuffer, index: Int = shorts.position()) : this(shorts[index], shorts[index + 1], shorts[index + 2])
    constructor(ints: IntBuffer, index: Int = ints.position()) : this(ints[index], ints[index + 1], ints[index + 2])
    constructor(longs: LongBuffer, index: Int = longs.position()) : this(longs[index], longs[index + 1], longs[index + 2])
    constructor(floats: FloatBuffer, index: Int = floats.position()) : this(floats[index], floats[index + 1], floats[index + 2])
    constructor(doubles: DoubleBuffer, index: Int = doubles.position()) : this(doubles[index], doubles[index + 1], doubles[index + 2])

    constructor(s: Number) : this(s, s, s)
    constructor(x: Number, y: Number, z: Number) : this(x.i, y.i, z.i)


    fun set(bytes: ByteArray, index: Int = 0, oneByteOneInt: Boolean = true, bigEndianess: Boolean = true) {
        x = if (oneByteOneInt) bytes[index].i else bytes.getInt(index, bigEndianess)
        y = if (oneByteOneInt) bytes[index + 1].i else bytes.getInt(index + Int.BYTES, bigEndianess)
        z = if (oneByteOneInt) bytes[index + 2].i else bytes.getInt(index + Int.BYTES * 2, bigEndianess)
    }

    fun set(bytes: ByteBuffer, index: Int = bytes.position(), oneByteOneInt: Boolean = true) {
        x = if (oneByteOneInt) bytes[index].i else bytes.getInt(index)
        y = if (oneByteOneInt) bytes[index + 1].i else bytes.getInt(index + Int.BYTES)
        z = if (oneByteOneInt) bytes[index + 2].i else bytes.getInt(index + Int.BYTES * 2)
    }


    override fun put(x: Number, y: Number, z: Number): Vec3i {
        this.x = x.i
        this.y = y.i
        this.z = z.i
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
        0 -> x = s.i
        1 -> y = s.i
        2 -> z = s.i
        else -> throw ArrayIndexOutOfBoundsException()
    }


    companion object : vec3i_operators {
        @JvmField val length = 3
        @JvmField val size = Vec3i.Companion.length * Int.BYTES
    }


    // -- Unary arithmetic operators --

    operator fun unaryPlus() = this

    operator fun unaryMinus() = Vec3i(-x, -y, -z)

    // -- Increment main.and decrement operators --

    operator fun inc(res: Vec3i = Vec3i()) = plus(res, this, 1, 1, 1)
    fun inc_() = plus(this, this, 1, 1, 1)


    operator fun dec(res: Vec3i = Vec3i()) = minus(res, this, 1, 1, 1)
    fun dec_() = minus(this, this, 1, 1, 1)


    // -- Specific binary arithmetic operators --

    operator fun plus(b: Int) = plus(Vec3i(), this, b, b, b)
    operator fun plus(b: Vec3i) = plus(Vec3i(), this, b.x, b.y, b.z)

    fun plus(bX: Int, bY: Int, bZ: Int, res: Vec3i = Vec3i()) = plus(res, this, bX, bY, bZ)
    fun plus(b: Int, res: Vec3i = Vec3i()) = plus(res, this, b, b, b)
    fun plus(b: Vec3i, res: Vec3i = Vec3i()) = plus(res, this, b.x, b.y, b.z)

    fun plus_(bX: Int, bY: Int, bZ: Int) = plus(this, this, bX, bY, bZ)
    infix fun plus_(b: Int) = plus(this, this, b, b, b)
    infix fun plus_(b: Vec3i) = plus(this, this, b.x, b.y, b.z)


    operator fun minus(b: Int) = minus(Vec3i(), this, b, b, b)
    operator fun minus(b: Vec3i) = minus(Vec3i(), this, b.x, b.y, b.z)

    fun minus(bX: Int, bY: Int, bZ: Int, res: Vec3i = Vec3i()) = minus(res, this, bX, bY, bZ)
    fun minus(b: Int, res: Vec3i = Vec3i()) = minus(res, this, b, b, b)
    fun minus(b: Vec3i, res: Vec3i = Vec3i()) = minus(res, this, b.x, b.y, b.z)

    fun minus_(bX: Int, bY: Int, bZ: Int) = minus(this, this, bX, bY, bZ)
    infix fun minus_(b: Int) = minus(this, this, b, b, b)
    infix fun minus_(b: Vec3i) = minus(this, this, b.x, b.y, b.z)


    operator fun times(b: Int) = times(Vec3i(), this, b, b, b)
    operator fun times(b: Vec3i) = times(Vec3i(), this, b.x, b.y, b.z)

    fun times(bX: Int, bY: Int, bZ: Int, res: Vec3i = Vec3i()) = times(res, this, bX, bY, bZ)
    fun times(b: Int, res: Vec3i = Vec3i()) = times(res, this, b, b, b)
    fun times(b: Vec3i, res: Vec3i = Vec3i()) = times(res, this, b.x, b.y, b.z)

    fun times_(bX: Int, bY: Int, bZ: Int) = times(this, this, bX, bY, bZ)
    infix fun times_(b: Int) = times(this, this, b, b, b)
    infix fun times_(b: Vec3i) = times(this, this, b.x, b.y, b.z)


    operator fun div(b: Int) = div(Vec3i(), this, b, b, b)
    operator fun div(b: Vec3i) = div(Vec3i(), this, b.x, b.y, b.z)

    fun div(bX: Int, bY: Int, bZ: Int, res: Vec3i = Vec3i()) = div(res, this, bX, bY, bZ)
    fun div(b: Int, res: Vec3i) = div(res, this, b, b, b)
    fun div(b: Vec3i, res: Vec3i) = div(res, this, b.x, b.y, b.z)

    fun div_(bX: Int, bY: Int, bZ: Int) = div(this, this, bX, bY, bZ)
    infix fun div_(b: Int) = div(this, this, b, b, b)
    infix fun div_(b: Vec3i) = div(this, this, b.x, b.y, b.z)


    operator fun rem(b: Int) = rem(Vec3i(), this, b, b, b)
    operator fun rem(b: Vec3i) = rem(Vec3i(), this, b.x, b.y, b.z)

    fun rem(bX: Int, bY: Int, bZ: Int, res: Vec3i = Vec3i()) = rem(res, this, bX, bY, bZ)
    fun rem(b: Int, res: Vec3i) = rem(res, this, b, b, b)
    fun rem(b: Vec3i, res: Vec3i) = rem(res, this, b.x, b.y, b.z)

    fun rem_(bX: Int, bY: Int, bZ: Int) = rem(this, this, bX, bY, bZ)
    infix fun rem_(b: Int) = rem(this, this, b, b, b)
    infix fun rem_(b: Vec3i) = rem(this, this, b.x, b.y, b.z)


    // -- Generic binary arithmetic operators --

    operator fun plus(b: Number) = plus(Vec3i(), this, b.i, b.i, b.i)
    operator fun plus(b: Vec3t<out Number>) = plus(Vec3i(), this, b.x.i, b.y.i, b.z.i)

    fun plus(bX: Number, bY: Number, bZ: Number, res: Vec3i = Vec3i()) = plus(res, this, bX.i, bY.i, bZ.i)
    fun plus(b: Number, res: Vec3i = Vec3i()) = plus(res, this, b.i, b.i, b.i)
    fun plus(b: Vec3t<out Number>, res: Vec3i = Vec3i()) = plus(res, this, b.x.i, b.y.i, b.z.i)

    fun plus_(bX: Number, bY: Number, bZ: Number) = plus(this, this, bX.i, bY.i, bZ.i)
    infix fun plus_(b: Number) = plus(this, this, b.i, b.i, b.i)
    infix fun plus_(b: Vec3t<out Number>) = plus(this, this, b.x.i, b.y.i, b.z.i)


    operator fun minus(b: Number) = minus(Vec3i(), this, b.i, b.i, b.i)
    operator fun minus(b: Vec3t<out Number>) = minus(Vec3i(), this, b.x.i, b.y.i, b.z.i)

    fun minus(bX: Number, bY: Number, bZ: Number, res: Vec3i = Vec3i()) = minus(res, this, bX.i, bY.i, bZ.i)
    fun minus(b: Number, res: Vec3i = Vec3i()) = minus(res, this, b.i, b.i, b.i)
    fun minus(b: Vec3t<out Number>, res: Vec3i = Vec3i()) = minus(res, this, b.x.i, b.y.i, b.z.i)

    fun minus_(bX: Number, bY: Number, bZ: Number) = minus(this, this, bX.i, bY.i, bZ.i)
    infix fun minus_(b: Number) = minus(this, this, b.i, b.i, b.i)
    infix fun minus_(b: Vec3t<out Number>) = minus(this, this, b.x.i, b.y.i, b.z.i)


    operator fun times(b: Number) = times(Vec3i(), this, b.i, b.i, b.i)
    operator fun times(b: Vec3t<out Number>) = times(Vec3i(), this, b.x.i, b.y.i, b.z.i)

    fun times(bX: Number, bY: Number, bZ: Number, res: Vec3i = Vec3i()) = times(res, this, bX.i, bY.i, bZ.i)
    fun times(b: Number, res: Vec3i = Vec3i()) = times(res, this, b.i, b.i, b.i)
    fun times(b: Vec3t<out Number>, res: Vec3i = Vec3i()) = times(res, this, b.x.i, b.y.i, b.z.i)

    fun times_(bX: Number, bY: Number, bZ: Number) = times(this, this, bX.i, bY.i, bZ.i)
    infix fun times_(b: Number) = times(this, this, b.i, b.i, b.i)
    infix fun times_(b: Vec3t<out Number>) = times(this, this, b.x.i, b.y.i, b.z.i)


    operator fun div(b: Number) = div(Vec3i(), this, b.i, b.i, b.i)
    operator fun div(b: Vec3t<out Number>) = div(Vec3i(), this, b.x.i, b.y.i, b.z.i)

    fun div(bX: Number, bY: Number, bZ: Number, res: Vec3i = Vec3i()) = div(res, this, bX.i, bY.i, bZ.i)
    fun div(b: Number, res: Vec3i) = div(res, this, b.i, b.i, b.i)
    fun div(b: Vec3t<out Number>, res: Vec3i) = div(res, this, b.x.i, b.y.i, b.z.i)

    fun div_(bX: Number, bY: Number, bZ: Number) = div(this, this, bX.i, bY.i, bZ.i)
    infix fun div_(b: Number) = div(this, this, b.i, b.i, b.i)
    infix fun div_(b: Vec3t<out Number>) = div(this, this, b.x.i, b.y.i, b.z.i)


    operator fun rem(b: Number) = rem(Vec3i(), this, b.i, b.i, b.i)
    operator fun rem(b: Vec3t<out Number>) = rem(Vec3i(), this, b.x.i, b.y.i, b.z.i)

    fun rem(bX: Number, bY: Number, bZ: Number, res: Vec3i = Vec3i()) = rem(res, this, bX.i, bY.i, bZ.i)
    fun rem(b: Number, res: Vec3i) = rem(res, this, b.i, b.i, b.i)
    fun rem(b: Vec3t<out Number>, res: Vec3i) = rem(res, this, b.x.i, b.y.i, b.z.i)

    fun rem_(bX: Number, bY: Number, bZ: Number) = rem(this, this, bX.i, bY.i, bZ.i)
    infix fun rem_(b: Number) = rem(this, this, b.i, b.i, b.i)
    infix fun rem_(b: Vec3t<out Number>) = rem(this, this, b.x.i, b.y.i, b.z.i)


    // -- Specific bitwise operators --

    infix fun and(b: Int) = and(Vec3i(), this, b, b, b)
    infix fun and(b: Vec3i) = and(Vec3i(), this, b.x, b.y, b.z)

    infix fun and_(b: Int) = and(this, this, b, b, b)
    infix fun and_(b: Vec3i) = and(this, this, b.x, b.y, b.z)

    fun and(b: Int, res: Vec3i) = and(res, this, b, b, b)
    fun and(b: Vec3i, res: Vec3i) = and(res, this, b.x, b.y, b.z)

    fun and(bX: Int, bY: Int, bZ: Int, res: Vec3i = Vec3i()) = and(res, this, bX, bY, bZ)

    fun and_(bX: Int, bY: Int, bZ: Int) = and(this, this, bX, bY, bZ)


    infix fun or(b: Int) = or(Vec3i(), this, b, b, b)
    infix fun or(b: Vec3i) = or(Vec3i(), this, b.x, b.y, b.z)

    infix fun or_(b: Int) = or(this, this, b, b, b)
    infix fun or_(b: Vec3i) = or(this, this, b.x, b.y, b.z)

    fun or(b: Int, res: Vec3i) = or(res, this, b, b, b)
    fun or(b: Vec3i, res: Vec3i) = or(res, this, b.x, b.y, b.z)

    fun or(bX: Int, bY: Int, bZ: Int, res: Vec3i = Vec3i()) = or(res, this, bX, bY, bZ)

    fun or_(bX: Int, bY: Int, bZ: Int) = or(this, this, bX, bY, bZ)


    infix fun xor(b: Int) = xor(Vec3i(), this, b, b, b)
    infix fun xor(b: Vec3i) = xor(Vec3i(), this, b.x, b.y, b.z)

    infix fun xor_(b: Int) = xor(this, this, b, b, b)
    infix fun xor_(b: Vec3i) = xor(this, this, b.x, b.y, b.z)

    fun xor(b: Int, res: Vec3i) = xor(res, this, b, b, b)
    fun xor(b: Vec3i, res: Vec3i) = xor(res, this, b.x, b.y, b.z)

    fun xor(bX: Int, bY: Int, bZ: Int, res: Vec3i = Vec3i()) = xor(res, this, bX, bY, bZ)

    fun xor_(bX: Int, bY: Int, bZ: Int) = xor(this, this, bX, bY, bZ)


    infix fun shl(b: Int) = shl(Vec3i(), this, b, b, b)
    infix fun shl(b: Vec3i) = shl(Vec3i(), this, b.x, b.y, b.z)

    infix fun shl_(b: Int) = shl(this, this, b, b, b)
    infix fun shl_(b: Vec3i) = shl(this, this, b.x, b.y, b.z)

    fun shl(b: Int, res: Vec3i) = shl(res, this, b, b, b)
    fun shl(b: Vec3i, res: Vec3i) = shl(res, this, b.x, b.y, b.z)

    fun shl(bX: Int, bY: Int, bZ: Int, res: Vec3i = Vec3i()) = shl(res, this, bX, bY, bZ)

    fun shl_(bX: Int, bY: Int, bZ: Int) = shl(this, this, bX, bY, bZ)


    infix fun shr(b: Int) = shr(Vec3i(), this, b, b, b)
    infix fun shr(b: Vec3i) = shr(Vec3i(), this, b.x, b.y, b.z)

    infix fun shr_(b: Int) = shr(this, this, b, b, b)
    infix fun shr_(b: Vec3i) = shr(this, this, b.x, b.y, b.z)

    fun shr(b: Int, res: Vec3i) = shr(res, this, b, b, b)
    fun shr(b: Vec3i, res: Vec3i) = shr(res, this, b.x, b.y, b.z)

    fun shr(bX: Int, bY: Int, bZ: Int, res: Vec3i = Vec3i()) = shr(res, this, bX, bY, bZ)

    fun shr_(bX: Int, bY: Int, bZ: Int) = shr(this, this, bX, bY, bZ)


    fun inv(res: Vec3i = Vec3i()) = inv(res, this)
    fun inv_() = inv(this, this)


    // TODO others
    infix fun ushr(b: Int) = ushr(Vec3i(), this, b, b, b)


    // -- Generic bitwise operators --

    infix fun and(b: Number) = and(Vec3i(), this, b.i, b.i, b.i)
    infix fun and(b: Vec3t<out Number>) = and(Vec3i(), this, b.x.i, b.y.i, b.z.i)

    infix fun and_(b: Number) = and(this, this, b.i, b.i, b.i)
    infix fun and_(b: Vec3t<out Number>) = and(this, this, b.x.i, b.y.i, b.z.i)

    fun and(b: Number, res: Vec3i) = and(res, this, b.i, b.i, b.i)
    fun and(b: Vec3t<out Number>, res: Vec3i) = and(res, this, b.x.i, b.y.i, b.z.i)

    fun and(bX: Number, bY: Number, bZ: Number, res: Vec3i = Vec3i()) = and(res, this, bX.i, bY.i, bZ.i)

    fun and_(bX: Number, bY: Number, bZ: Number) = and(this, this, bX.i, bY.i, bZ.i)


    infix fun or(b: Number) = or(Vec3i(), this, b.i, b.i, b.i)
    infix fun or(b: Vec3t<out Number>) = or(Vec3i(), this, b.x.i, b.y.i, b.z.i)

    infix fun or_(b: Number) = or(this, this, b.i, b.i, b.i)
    infix fun or_(b: Vec3t<out Number>) = or(this, this, b.x.i, b.y.i, b.z.i)

    fun or(b: Number, res: Vec3i) = or(res, this, b.i, b.i, b.i)
    fun or(b: Vec3t<out Number>, res: Vec3i) = or(res, this, b.x.i, b.y.i, b.z.i)

    fun or(bX: Number, bY: Number, bZ: Number, res: Vec3i = Vec3i()) = or(res, this, bX.i, bY.i, bZ.i)

    fun or_(bX: Number, bY: Number, bZ: Number) = or(this, this, bX.i, bY.i, bZ.i)


    infix fun xor(b: Number) = xor(Vec3i(), this, b.i, b.i, b.i)
    infix fun xor(b: Vec3t<out Number>) = xor(Vec3i(), this, b.x.i, b.y.i, b.z.i)

    infix fun xor_(b: Number) = xor(this, this, b.i, b.i, b.i)
    infix fun xor_(b: Vec3t<out Number>) = xor(this, this, b.x.i, b.y.i, b.z.i)

    fun xor(b: Number, res: Vec3i) = xor(res, this, b.i, b.i, b.i)
    fun xor(b: Vec3t<out Number>, res: Vec3i) = xor(res, this, b.x.i, b.y.i, b.z.i)

    fun xor(bX: Number, bY: Number, bZ: Number, res: Vec3i = Vec3i()) = xor(res, this, bX.i, bY.i, bZ.i)

    fun xor_(bX: Number, bY: Number, bZ: Number) = xor(this, this, bX.i, bY.i, bZ.i)


    infix fun shl(b: Number) = shl(Vec3i(), this, b.i, b.i, b.i)
    infix fun shl(b: Vec3t<out Number>) = shl(Vec3i(), this, b.x.i, b.y.i, b.z.i)

    infix fun shl_(b: Number) = shl(this, this, b.i, b.i, b.i)
    infix fun shl_(b: Vec3t<out Number>) = shl(this, this, b.x.i, b.y.i, b.z.i)

    fun shl(b: Number, res: Vec3i) = shl(res, this, b.i, b.i, b.i)
    fun shl(b: Vec3t<out Number>, res: Vec3i) = shl(res, this, b.x.i, b.y.i, b.z.i)

    fun shl(bX: Number, bY: Number, bZ: Number, res: Vec3i = Vec3i()) = shl(res, this, bX.i, bY.i, bZ.i)

    fun shl_(bX: Number, bY: Number, bZ: Number) = shl(this, this, bX.i, bY.i, bZ.i)


    infix fun shr(b: Number) = shr(Vec3i(), this, b.i, b.i, b.i)
    infix fun shr(b: Vec3t<out Number>) = shr(Vec3i(), this, b.x.i, b.y.i, b.z.i)

    infix fun shr_(b: Number) = shr(this, this, b.i, b.i, b.i)
    infix fun shr_(b: Vec3t<out Number>) = shr(this, this, b.x.i, b.y.i, b.z.i)

    fun shr(b: Number, res: Vec3i) = shr(res, this, b.i, b.i, b.i)
    fun shr(b: Vec3t<out Number>, res: Vec3i) = shr(res, this, b.x.i, b.y.i, b.z.i)

    fun shr(bX: Number, bY: Number, bZ: Number, res: Vec3i = Vec3i()) = shr(res, this, bX.i, bY.i, bZ.i)

    fun shr_(bX: Number, bY: Number, bZ: Number) = shr(this, this, bX.i, bY.i, bZ.i)


    override fun equals(other: Any?) =
            if (other is Vec3i)
                this[0] == other[0] && this[1] == other[1] && this[2] == other[2]
            else false
}