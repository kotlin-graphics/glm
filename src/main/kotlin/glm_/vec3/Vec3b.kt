package glm_.vec3

import glm_.BYTES
import glm_.b
import glm_.i
import glm_.toByte
import glm_.vec2.Vec2bool
import glm_.vec2.Vec2t
import glm_.vec3.operators.vec3b_operators
import glm_.vec4.Vec4bool
import glm_.vec4.Vec4t
import java.nio.*

/**
 * Created by elect on 08/10/16.
 */

class Vec3b(x: Byte, y: Byte, z: Byte) : Vec3t<Byte>(x, y, z) {

    // -- Explicit basic, conversion other main.and conversion vector constructors --

    constructor() : this(0)

    constructor(v: Vec2t<out Number>) : this(v.x, v.y, 0)
    constructor(v: Vec2t<out Number>, z: Number) : this(v.x, v.y, z)
    constructor(x: Number, v: Vec2t<out Number>) : this(x, v.x, v.y)
    constructor(v: Vec3t<out Number>) : this(v.x, v.y, v.z)
    constructor(v: Vec4t<out Number>) : this(v.x, v.y, v.z)

    constructor(v: Vec2bool) : this(v.x.b, v.y.b, 0)
    constructor(v: Vec3bool) : this(v.x.b, v.y.b, v.z.b)
    constructor(v: Vec4bool) : this(v.x.b, v.y.b, v.z.b)

    constructor(bytes: ByteArray, index: Int = 0) : this(bytes[index], bytes[index + 1], bytes[index + 2])
    constructor(chars: CharArray, index: Int = 0) : this(chars[index].b, chars[index + 1].b, chars[index + 2].b)
    constructor(shorts: ShortArray, index: Int = 0) : this(shorts[index], shorts[index + 1], shorts[index + 2])
    constructor(ints: IntArray, index: Int = 0) : this(ints[index], ints[index + 1], ints[index + 2])
    constructor(longs: LongArray, index: Int = 0) : this(longs[index], longs[index + 1], longs[index + 2])
    constructor(floats: FloatArray, index: Int = 0) : this(floats[index], floats[index + 1], floats[index + 2])
    constructor(doubles: DoubleArray, index: Int = 0) : this(doubles[index], doubles[index + 1], doubles[index + 2])
    constructor(booleans: BooleanArray, index: Int = 0) : this(booleans[index].b, booleans[index + 1].b, booleans[index + 2].b)

    constructor(numbers: Array<out Number>, index: Int = 0) : this(numbers[index], numbers[index + 1], numbers[index + 2])
    constructor(chars: Array<Char>, index: Int = 0) : this(chars[index].b, chars[index + 1].b, chars[index + 2].b)
    constructor(booleans: Array<Boolean>, index: Int = 0) : this(booleans[index].b, booleans[index + 1].b, booleans[index + 2].b)

    constructor(list: List<Any>, index: Int = 0) : this(list[index].toByte, list[index + 1].toByte, list[index + 2].toByte)

    constructor(bytes: ByteBuffer, index: Int = bytes.position()) : this(bytes[index], bytes[index + 1], bytes[index + 2])
    constructor(chars: CharBuffer, index: Int = chars.position()) : this(chars[index].b, chars[index + 1].b, chars[index + 2].b)
    constructor(shorts: ShortBuffer, index: Int = shorts.position()) : this(shorts[index], shorts[index + 1], shorts[index + 2])
    constructor(ints: IntBuffer, index: Int = ints.position()) : this(ints[index], ints[index + 1], ints[index + 2])
    constructor(longs: LongBuffer, index: Int = longs.position()) : this(longs[index], longs[index + 1], longs[index + 2])
    constructor(floats: FloatBuffer, index: Int = floats.position()) : this(floats[index], floats[index + 1], floats[index + 2])
    constructor(doubles: DoubleBuffer, index: Int = doubles.position()) : this(doubles[index], doubles[index + 1], doubles[index + 2])

    constructor(s: Number) : this(s, s, s)
    constructor(x: Number, y: Number, z: Number) : this(x.b, y.b, z.b)


    override fun put(x: Number, y: Number, z: Number): Vec3b {
        this.x = x.b
        this.y = y.b
        this.z = z.b
        return this
    }


    infix fun to(bytes: ByteArray) = to(bytes, 0)
    fun to(bytes: ByteArray, index: Int): ByteArray {
        bytes[index] = x
        bytes[index + 1] = y
        bytes[index + 2] = z
        return bytes
    }

    infix fun to(bytes: ByteBuffer) = to(bytes, bytes.position())
    fun to(bytes: ByteBuffer, offset: Int): ByteBuffer {
        bytes.put(offset, x)
        bytes.put(offset + Byte.BYTES, y)
        bytes.put(offset + Byte.BYTES * 2, z)
        return bytes
    }


    // -- Component accesses --

    override operator fun get(i: Int) = when (i) {
        0 -> x
        1 -> y
        2 -> z
        else -> throw ArrayIndexOutOfBoundsException()
    }

    operator fun set(i: Int, s: Number) = when (i) {
        0 -> x = s.b
        1 -> y = s.b
        2 -> z = s.b
        else -> throw ArrayIndexOutOfBoundsException()
    }


    companion object : vec3b_operators {
        @JvmField
        val length = 3
        @JvmField
        val size = length * Byte.BYTES
    }


    // -- Unary arithmetic operators --

    operator fun unaryPlus() = this

    operator fun unaryMinus() = Vec3b(-x.b, -y.b, -z.b)

    // -- Increment main.and decrement operators --

    operator fun inc(res: Vec3b = Vec3b()) = plus(res, this, 1, 1, 1)
    fun inc_() = plus(this, this, 1, 1, 1)


    operator fun dec(res: Vec3b = Vec3b()) = minus(res, this, 1, 1, 1)
    fun dec_() = minus(this, this, 1, 1, 1)


    // -- Specific binary arithmetic operators --

    operator fun plus(b: Byte) = plus(Vec3b(), this, b, b, b)
    operator fun plus(b: Int) = plus(Vec3b(), this, b, b, b)
    operator fun plus(b: Vec3b) = plus(Vec3b(), this, b.x, b.y, b.z)

    fun plus(bX: Byte, bY: Byte, bZ: Byte, res: Vec3b = Vec3b()) = plus(res, this, bX, bY, bZ)
    fun plus(bX: Int, bY: Int, bZ: Int, res: Vec3b = Vec3b()) = plus(res, this, bX, bY, bZ)
    fun plus(b: Byte, res: Vec3b = Vec3b()) = plus(res, this, b, b, b)
    fun plus(b: Int, res: Vec3b = Vec3b()) = plus(res, this, b, b, b)
    fun plus(b: Vec3b, res: Vec3b = Vec3b()) = plus(res, this, b.x, b.y, b.z)

    fun plus_(bX: Byte, bY: Byte, bZ: Byte) = plus(this, this, bX, bY, bZ)
    fun plus_(bX: Int, bY: Int, bZ: Int) = plus(this, this, bX, bY, bZ)
    infix fun plus_(b: Byte) = plus(this, this, b, b, b)
    infix fun plus_(b: Int) = plus(this, this, b, b, b)
    infix fun plus_(b: Vec3b) = plus(this, this, b.x, b.y, b.z)


    operator fun minus(b: Byte) = minus(Vec3b(), this, b, b, b)
    operator fun minus(b: Int) = minus(Vec3b(), this, b, b, b)
    operator fun minus(b: Vec3b) = minus(Vec3b(), this, b.x, b.y, b.z)

    fun minus(bX: Byte, bY: Byte, bZ: Byte, res: Vec3b = Vec3b()) = minus(res, this, bX, bY, bZ)
    fun minus(bX: Int, bY: Int, bZ: Int, res: Vec3b = Vec3b()) = minus(res, this, bX, bY, bZ)
    fun minus(b: Byte, res: Vec3b = Vec3b()) = minus(res, this, b, b, b)
    fun minus(b: Int, res: Vec3b = Vec3b()) = minus(res, this, b, b, b)
    fun minus(b: Vec3b, res: Vec3b = Vec3b()) = minus(res, this, b.x, b.y, b.z)

    fun minus_(bX: Byte, bY: Byte, bZ: Byte) = minus(this, this, bX, bY, bZ)
    fun minus_(bX: Int, bY: Int, bZ: Int) = minus(this, this, bX, bY, bZ)
    infix fun minus_(b: Byte) = minus(this, this, b, b, b)
    infix fun minus_(b: Int) = minus(this, this, b, b, b)
    infix fun minus_(b: Vec3b) = minus(this, this, b.x, b.y, b.z)


    operator fun times(b: Byte) = times(Vec3b(), this, b, b, b)
    operator fun times(b: Int) = times(Vec3b(), this, b, b, b)
    operator fun times(b: Vec3b) = times(Vec3b(), this, b.x, b.y, b.z)

    fun times(bX: Byte, bY: Byte, bZ: Byte, res: Vec3b = Vec3b()) = times(res, this, bX, bY, bZ)
    fun times(bX: Int, bY: Int, bZ: Int, res: Vec3b = Vec3b()) = times(res, this, bX, bY, bZ)
    fun times(b: Byte, res: Vec3b = Vec3b()) = times(res, this, b, b, b)
    fun times(b: Int, res: Vec3b = Vec3b()) = times(res, this, b, b, b)
    fun times(b: Vec3b, res: Vec3b = Vec3b()) = times(res, this, b.x, b.y, b.z)

    fun times_(bX: Byte, bY: Byte, bZ: Byte) = times(this, this, bX, bY, bZ)
    fun times_(bX: Int, bY: Int, bZ: Int) = times(this, this, bX, bY, bZ)
    infix fun times_(b: Byte) = times(this, this, b, b, b)
    infix fun times_(b: Int) = times(this, this, b, b, b)
    infix fun times_(b: Vec3b) = times(this, this, b.x, b.y, b.z)


    operator fun div(b: Byte) = div(Vec3b(), this, b, b, b)
    operator fun div(b: Int) = div(Vec3b(), this, b, b, b)
    operator fun div(b: Vec3b) = div(Vec3b(), this, b.x, b.y, b.z)

    fun div(bX: Byte, bY: Byte, bZ: Byte, res: Vec3b = Vec3b()) = div(res, this, bX, bY, bZ)
    fun div(bX: Int, bY: Int, bZ: Int, res: Vec3b = Vec3b()) = div(res, this, bX, bY, bZ)
    fun div(b: Byte, res: Vec3b) = div(res, this, b, b, b)
    fun div(b: Int, res: Vec3b) = div(res, this, b, b, b)
    fun div(b: Vec3b, res: Vec3b) = div(res, this, b.x, b.y, b.z)

    fun div_(bX: Byte, bY: Byte, bZ: Byte) = div(this, this, bX, bY, bZ)
    fun div_(bX: Int, bY: Int, bZ: Int) = div(this, this, bX, bY, bZ)
    infix fun div_(b: Byte) = div(this, this, b, b, b)
    infix fun div_(b: Int) = div(this, this, b, b, b)
    infix fun div_(b: Vec3b) = div(this, this, b.x, b.y, b.z)


    operator fun rem(b: Byte) = rem(Vec3b(), this, b, b, b)
    operator fun rem(b: Int) = rem(Vec3b(), this, b, b, b)
    operator fun rem(b: Vec3b) = rem(Vec3b(), this, b.x, b.y, b.z)

    fun rem(bX: Byte, bY: Byte, bZ: Byte, res: Vec3b = Vec3b()) = rem(res, this, bX, bY, bZ)
    fun rem(bX: Int, bY: Int, bZ: Int, res: Vec3b = Vec3b()) = rem(res, this, bX, bY, bZ)
    fun rem(b: Byte, res: Vec3b) = rem(res, this, b, b, b)
    fun rem(b: Int, res: Vec3b) = rem(res, this, b, b, b)
    fun rem(b: Vec3b, res: Vec3b) = rem(res, this, b.x, b.y, b.z)

    fun rem_(bX: Byte, bY: Byte, bZ: Byte) = rem(this, this, bX, bY, bZ)
    fun rem_(bX: Int, bY: Int, bZ: Int) = rem(this, this, bX, bY, bZ)
    infix fun rem_(b: Byte) = rem(this, this, b, b, b)
    infix fun rem_(b: Int) = rem(this, this, b, b, b)
    infix fun rem_(b: Vec3b) = rem(this, this, b.x, b.y, b.z)


    // -- Generic binary arithmetic operators --

    operator fun plus(b: Number) = plus(Vec3b(), this, b.i, b.i, b.i)
    operator fun plus(b: Vec3t<out Number>) = plus(Vec3b(), this, b.x.i, b.y.i, b.z.i)

    fun plus(bX: Number, bY: Number, bZ: Number, res: Vec3b = Vec3b()) = plus(res, this, bX.i, bY.i, bZ.i)
    fun plus(b: Number, res: Vec3b = Vec3b()) = plus(res, this, b.i, b.i, b.i)
    fun plus(b: Vec3t<out Number>, res: Vec3b = Vec3b()) = plus(res, this, b.x.i, b.y.i, b.z.i)

    fun plus_(bX: Number, bY: Number, bZ: Number) = plus(this, this, bX.i, bY.i, bZ.i)
    infix fun plus_(b: Number) = plus(this, this, b.i, b.i, b.i)
    infix fun plus_(b: Vec3t<out Number>) = plus(this, this, b.x.i, b.y.i, b.z.i)


    operator fun minus(b: Number) = minus(Vec3b(), this, b.i, b.i, b.i)
    operator fun minus(b: Vec3t<out Number>) = minus(Vec3b(), this, b.x.i, b.y.i, b.z.i)

    fun minus(bX: Number, bY: Number, bZ: Number, res: Vec3b = Vec3b()) = minus(res, this, bX.i, bY.i, bZ.i)
    fun minus(b: Number, res: Vec3b = Vec3b()) = minus(res, this, b.i, b.i, b.i)
    fun minus(b: Vec3t<out Number>, res: Vec3b = Vec3b()) = minus(res, this, b.x.i, b.y.i, b.z.i)

    fun minus_(bX: Number, bY: Number, bZ: Number) = minus(this, this, bX.i, bY.i, bZ.i)
    infix fun minus_(b: Number) = minus(this, this, b.i, b.i, b.i)
    infix fun minus_(b: Vec3t<out Number>) = minus(this, this, b.x.i, b.y.i, b.z.i)


    operator fun times(b: Number) = times(Vec3b(), this, b.i, b.i, b.i)
    operator fun times(b: Vec3t<out Number>) = times(Vec3b(), this, b.x.i, b.y.i, b.z.i)

    fun times(bX: Number, bY: Number, bZ: Number, res: Vec3b = Vec3b()) = times(res, this, bX.i, bY.i, bZ.i)
    fun times(b: Number, res: Vec3b = Vec3b()) = times(res, this, b.i, b.i, b.i)
    fun times(b: Vec3t<out Number>, res: Vec3b = Vec3b()) = times(res, this, b.x.i, b.y.i, b.z.i)

    fun times_(bX: Number, bY: Number, bZ: Number) = times(this, this, bX.i, bY.i, bZ.i)
    infix fun times_(b: Number) = times(this, this, b.i, b.i, b.i)
    infix fun times_(b: Vec3t<out Number>) = times(this, this, b.x.i, b.y.i, b.z.i)


    operator fun div(b: Number) = div(Vec3b(), this, b.i, b.i, b.i)
    operator fun div(b: Vec3t<out Number>) = div(Vec3b(), this, b.x.i, b.y.i, b.z.i)

    fun div(bX: Number, bY: Number, bZ: Number, res: Vec3b = Vec3b()) = div(res, this, bX.i, bY.i, bZ.i)
    fun div(b: Number, res: Vec3b = Vec3b()) = div(res, this, b.i, b.i, b.i)
    fun div(b: Vec3t<out Number>, res: Vec3b = Vec3b()) = div(res, this, b.x.i, b.y.i, b.z.i)

    fun div_(bX: Number, bY: Number, bZ: Number) = div(this, this, bX.i, bY.i, bZ.i)
    infix fun div_(b: Number) = div(this, this, b.i, b.i, b.i)
    infix fun div_(b: Vec3t<out Number>) = div(this, this, b.x.i, b.y.i, b.z.i)


    operator fun rem(b: Number) = rem(Vec3b(), this, b.i, b.i, b.i)
    operator fun rem(b: Vec3t<out Number>) = rem(Vec3b(), this, b.x.i, b.y.i, b.z.i)

    fun rem(bX: Number, bY: Number, bZ: Number, res: Vec3b = Vec3b()) = rem(res, this, bX.i, bY.i, bZ.i)
    fun rem(b: Number, res: Vec3b = Vec3b()) = rem(res, this, b.i, b.i, b.i)
    fun rem(b: Vec3t<out Number>, res: Vec3b = Vec3b()) = rem(res, this, b.x.i, b.y.i, b.z.i)

    fun rem_(bX: Number, bY: Number, bZ: Number) = rem(this, this, bX.i, bY.i, bZ.i)
    infix fun rem_(b: Number) = rem(this, this, b.i, b.i, b.i)
    infix fun rem_(b: Vec3t<out Number>) = rem(this, this, b.x.i, b.y.i, b.z.i)


    // -- Specific bitwise operators --

    infix fun and(b: Byte) = and(Vec3b(), this, b, b, b)
    infix fun and(b: Int) = and(Vec3b(), this, b, b, b)
    infix fun and(b: Vec3b) = and(Vec3b(), this, b.x, b.y, b.z)

    infix fun and_(b: Byte) = and(this, this, b, b, b)
    infix fun and_(b: Int) = and(this, this, b, b, b)
    infix fun and_(b: Vec3b) = and(this, this, b.x, b.y, b.z)

    fun and(b: Byte, res: Vec3b) = and(res, this, b, b, b)
    fun and(b: Int, res: Vec3b) = and(res, this, b, b, b)
    fun and(b: Vec3b, res: Vec3b) = and(res, this, b.x, b.y, b.z)

    fun and(bX: Byte, bY: Byte, bZ: Byte, res: Vec3b = Vec3b()) = and(res, this, bX, bY, bZ)
    fun and(bX: Int, bY: Int, bZ: Int, res: Vec3b = Vec3b()) = and(res, this, bX, bY, bZ)

    fun and_(bX: Byte, bY: Byte, bZ: Byte) = and(this, this, bX, bY, bZ)
    fun and_(bX: Int, bY: Int, bZ: Int) = and(this, this, bX, bY, bZ)


    infix fun or(b: Byte) = or(Vec3b(), this, b, b, b)
    infix fun or(b: Int) = or(Vec3b(), this, b, b, b)
    infix fun or(b: Vec3b) = or(Vec3b(), this, b.x, b.y, b.z)

    infix fun or_(b: Byte) = or(this, this, b, b, b)
    infix fun or_(b: Int) = or(this, this, b, b, b)
    infix fun or_(b: Vec3b) = or(this, this, b.x, b.y, b.z)

    fun or(b: Byte, res: Vec3b) = or(res, this, b, b, b)
    fun or(b: Int, res: Vec3b) = or(res, this, b, b, b)
    fun or(b: Vec3b, res: Vec3b) = or(res, this, b.x, b.y, b.z)

    fun or(bX: Byte, bY: Byte, bZ: Byte, res: Vec3b = Vec3b()) = or(res, this, bX, bY, bZ)
    fun or(bX: Int, bY: Int, bZ: Int, res: Vec3b = Vec3b()) = or(res, this, bX, bY, bZ)

    fun or_(bX: Byte, bY: Byte, bZ: Byte) = or(this, this, bX, bY, bZ)
    fun or_(bX: Int, bY: Int, bZ: Int) = or(this, this, bX, bY, bZ)


    infix fun xor(b: Byte) = xor(Vec3b(), this, b, b, b)
    infix fun xor(b: Int) = xor(Vec3b(), this, b, b, b)
    infix fun xor(b: Vec3b) = xor(Vec3b(), this, b.x, b.y, b.z)

    infix fun xor_(b: Byte) = xor(this, this, b, b, b)
    infix fun xor_(b: Int) = xor(this, this, b, b, b)
    infix fun xor_(b: Vec3b) = xor(this, this, b.x, b.y, b.z)

    fun xor(b: Byte, res: Vec3b) = xor(res, this, b, b, b)
    fun xor(b: Int, res: Vec3b) = xor(res, this, b, b, b)
    fun xor(b: Vec3b, res: Vec3b) = xor(res, this, b.x, b.y, b.z)

    fun xor(bX: Byte, bY: Byte, bZ: Byte, res: Vec3b = Vec3b()) = xor(res, this, bX, bY, bZ)
    fun xor(bX: Int, bY: Int, bZ: Int, res: Vec3b = Vec3b()) = xor(res, this, bX, bY, bZ)

    fun xor_(bX: Byte, bY: Byte, bZ: Byte) = xor(this, this, bX, bY, bZ)
    fun xor_(bX: Int, bY: Int, bZ: Int) = xor(this, this, bX, bY, bZ)


    infix fun shl(b: Byte) = shl(Vec3b(), this, b, b, b)
    infix fun shl(b: Int) = shl(Vec3b(), this, b, b, b)
    infix fun shl(b: Vec3b) = shl(Vec3b(), this, b.x, b.y, b.z)

    infix fun shl_(b: Byte) = shl(this, this, b, b, b)
    infix fun shl_(b: Int) = shl(this, this, b, b, b)
    infix fun shl_(b: Vec3b) = shl(this, this, b.x, b.y, b.z)

    fun shl(b: Byte, res: Vec3b) = shl(res, this, b, b, b)
    fun shl(b: Int, res: Vec3b) = shl(res, this, b, b, b)
    fun shl(b: Vec3b, res: Vec3b) = shl(res, this, b.x, b.y, b.z)

    fun shl(bX: Byte, bY: Byte, bZ: Byte, res: Vec3b = Vec3b()) = shl(res, this, bX, bY, bZ)
    fun shl(bX: Int, bY: Int, bZ: Int, res: Vec3b = Vec3b()) = shl(res, this, bX, bY, bZ)

    fun shl_(bX: Byte, bY: Byte, bZ: Byte) = shl(this, this, bX, bY, bZ)
    fun shl_(bX: Int, bY: Int, bZ: Int) = shl(this, this, bX, bY, bZ)


    infix fun shr(b: Byte) = shr(Vec3b(), this, b, b, b)
    infix fun shr(b: Int) = shr(Vec3b(), this, b, b, b)
    infix fun shr(b: Vec3b) = shr(Vec3b(), this, b.x, b.y, b.z)

    infix fun shr_(b: Byte) = shr(this, this, b, b, b)
    infix fun shr_(b: Int) = shr(this, this, b, b, b)
    infix fun shr_(b: Vec3b) = shr(this, this, b.x, b.y, b.z)

    fun shr(b: Byte, res: Vec3b) = shr(res, this, b, b, b)
    fun shr(b: Int, res: Vec3b) = shr(res, this, b, b, b)
    fun shr(b: Vec3b, res: Vec3b) = shr(res, this, b.x, b.y, b.z)

    fun shr(bX: Byte, bY: Byte, bZ: Byte, res: Vec3b = Vec3b()) = shr(res, this, bX, bY, bZ)
    fun shr(bX: Int, bY: Int, bZ: Int, res: Vec3b = Vec3b()) = shr(res, this, bX, bY, bZ)

    fun shr_(bX: Byte, bY: Byte, bZ: Byte) = shr(this, this, bX, bY, bZ)
    fun shr_(bX: Int, bY: Int, bZ: Int) = shr(this, this, bX, bY, bZ)


    fun inv(res: Vec3b = Vec3b()) = inv(res, this)
    fun inv_() = inv(this, this)


    // -- Generic bitwise operators --

    infix fun and(b: Number) = and(Vec3b(), this, b.b, b.b, b.b)
    infix fun and(b: Vec3t<out Number>) = and(Vec3b(), this, b.x.b, b.y.b, b.z.b)

    infix fun and_(b: Number) = and(this, this, b.b, b.b, b.b)
    infix fun and_(b: Vec3t<out Number>) = and(this, this, b.x.b, b.y.b, b.z.b)

    fun and(b: Number, res: Vec3b = Vec3b()) = and(res, this, b.b, b.b, b.b)
    fun and(b: Vec3t<out Number>, res: Vec3b = Vec3b()) = and(res, this, b.x.b, b.y.b, b.z.b)

    fun and(bX: Number, bY: Number, bZ: Number, res: Vec3b = Vec3b()) = and(res, this, bX.b, bY.b, bZ.b)

    fun and_(bX: Number, bY: Number, bZ: Number) = and(this, this, bX.b, bY.b, bZ.b)


    infix fun or(b: Number) = or(Vec3b(), this, b.b, b.b, b.b)
    infix fun or(b: Vec3t<out Number>) = or(Vec3b(), this, b.x.b, b.y.b, b.z.b)

    infix fun or_(b: Number) = or(this, this, b.b, b.b, b.b)
    infix fun or_(b: Vec3t<out Number>) = or(this, this, b.x.b, b.y.b, b.z.b)

    fun or(b: Number, res: Vec3b = Vec3b()) = or(res, this, b.b, b.b, b.b)
    fun or(b: Vec3t<out Number>, res: Vec3b = Vec3b()) = or(res, this, b.x.b, b.y.b, b.z.b)

    fun or(bX: Number, bY: Number, bZ: Number, res: Vec3b = Vec3b()) = or(res, this, bX.b, bY.b, bZ.b)

    fun or_(bX: Number, bY: Number, bZ: Number) = or(this, this, bX.b, bY.b, bZ.b)


    infix fun xor(b: Number) = xor(Vec3b(), this, b.b, b.b, b.b)
    infix fun xor(b: Vec3t<out Number>) = xor(Vec3b(), this, b.x.b, b.y.b, b.z.b)

    infix fun xor_(b: Number) = xor(this, this, b.b, b.b, b.b)
    infix fun xor_(b: Vec3t<out Number>) = xor(this, this, b.x.b, b.y.b, b.z.b)

    fun xor(b: Number, res: Vec3b = Vec3b()) = xor(res, this, b.b, b.b, b.b)
    fun xor(b: Vec3t<out Number>, res: Vec3b = Vec3b()) = xor(res, this, b.x.b, b.y.b, b.z.b)

    fun xor(bX: Number, bY: Number, bZ: Number, res: Vec3b = Vec3b()) = xor(res, this, bX.b, bY.b, bZ.b)

    fun xor_(bX: Number, bY: Number, bZ: Number) = xor(this, this, bX.b, bY.b, bZ.b)


    infix fun shl(b: Number) = shl(Vec3b(), this, b.b, b.b, b.b)
    infix fun shl(b: Vec3t<out Number>) = shl(Vec3b(), this, b.x.b, b.y.b, b.z.b)

    infix fun shl_(b: Number) = shl(this, this, b.b, b.b, b.b)
    infix fun shl_(b: Vec3t<out Number>) = shl(this, this, b.x.b, b.y.b, b.z.b)

    fun shl(b: Number, res: Vec3b = Vec3b()) = shl(res, this, b.b, b.b, b.b)
    fun shl(b: Vec3t<out Number>, res: Vec3b = Vec3b()) = shl(res, this, b.x.b, b.y.b, b.z.b)

    fun shl(bX: Number, bY: Number, bZ: Number, res: Vec3b = Vec3b()) = shl(res, this, bX.b, bY.b, bZ.b)

    fun shl_(bX: Number, bY: Number, bZ: Number) = shl(this, this, bX.b, bY.b, bZ.b)


    infix fun shr(b: Number) = shr(Vec3b(), this, b.b, b.b, b.b)
    infix fun shr(b: Vec3t<out Number>) = shr(Vec3b(), this, b.x.b, b.y.b, b.z.b)

    infix fun shr_(b: Number) = shr(this, this, b.b, b.b, b.b)
    infix fun shr_(b: Vec3t<out Number>) = shr(this, this, b.x.b, b.y.b, b.z.b)

    fun shr(b: Number, res: Vec3b = Vec3b()) = shr(res, this, b.b, b.b, b.b)
    fun shr(b: Vec3t<out Number>, res: Vec3b = Vec3b()) = shr(res, this, b.x.b, b.y.b, b.z.b)

    fun shr(bX: Number, bY: Number, bZ: Number, res: Vec3b = Vec3b()) = shr(res, this, bX.b, bY.b, bZ.b)

    fun shr_(bX: Number, bY: Number, bZ: Number) = shr(this, this, bX.b, bY.b, bZ.b)


    override fun equals(other: Any?) = other is Vec3b && this[0] == other[0] && this[1] == other[1] && this[2] == other[2]
    override fun hashCode() = 31 * (31 * x.hashCode() + y.hashCode()) + z.hashCode()
}