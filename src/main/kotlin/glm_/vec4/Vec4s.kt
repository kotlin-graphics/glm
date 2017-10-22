package glm_.vec4

import glm_.*
import glm_.vec2.Vec2bool
import glm_.vec2.Vec2t
import glm_.vec3.Vec3bool
import glm_.vec3.Vec3t
import glm_.vec4.operators.vec4s_operators
import java.nio.*

/**
 * Created by elect on 09/10/16.
 */

class Vec4s(x: Short, y: Short, z: Short, w: Short) : Vec4t<Short>(x, y, z, w) {

    // -- Explicit basic, conversion other main.and conversion vector constructors --

    constructor() : this(0)

    constructor(v: Vec2t<out Number>) : this(v.x, v.y, 0, 1)
    constructor(v: Vec2t<out Number>, z: Number, w: Number) : this(v.x, v.y, z, w)
    constructor(v: Vec3t<out Number>) : this(v, 1)
    constructor(v: Vec3t<out Number>, w: Number) : this(v.x, v.y, v.z, w)
    constructor(x: Number, v: Vec3t<out Number>) : this(x, v.x, v.y, v.z)
    constructor(v: Vec4t<out Number>) : this(v.x, v.y, v.z, v.w)

    constructor(v: Vec2bool) : this(v.x.s, v.y.s, 0, 1)
    constructor(v: Vec3bool) : this(v.x.s, v.y.s, v.z.s, 1)
    constructor(v: Vec4bool) : this(v.x.s, v.y.s, v.z.s, v.w.s)

    constructor(bytes: ByteArray, index: Int = 0, oneByteOneShort: Boolean = false, bigEndian: Boolean = true) : this(
            if (oneByteOneShort) bytes[index].s else bytes.getShort(index, bigEndian),
            if (oneByteOneShort) bytes[index + 1].s else bytes.getShort(index + Short.BYTES, bigEndian),
            if (oneByteOneShort) bytes[index + 2].s else bytes.getShort(index + Short.BYTES * 2, bigEndian),
            if (oneByteOneShort) bytes[index + 3].s else bytes.getShort(index + Short.BYTES * 3, bigEndian))

    constructor(chars: CharArray, index: Int = 0) : this(chars[index].s, chars[index + 1].s, chars[index + 2].s, chars[index + 3].s)
    constructor(shorts: ShortArray, index: Int = 0) : this(shorts[index], shorts[index + 1], shorts[index + 2], shorts[index + 3])
    constructor(ints: IntArray, index: Int = 0) : this(ints[index], ints[index + 1], ints[index + 2], ints[index + 3])
    constructor(longs: LongArray, index: Int = 0) : this(longs[index], longs[index + 1], longs[index + 2], longs[index + 3])
    constructor(floats: FloatArray, index: Int = 0) : this(floats[index], floats[index + 1], floats[index + 2], floats[index + 3])
    constructor(doubles: DoubleArray, index: Int = 0) : this(doubles[index], doubles[index + 1], doubles[index + 2], doubles[index + 3])
    constructor(booleans: BooleanArray, index: Int = 0) : this(booleans[index].s, booleans[index + 1].s, booleans[index + 2].s, booleans[index + 3].s)

    constructor(numbers: Array<out Number>, index: Int = 0) : this(numbers[index], numbers[index + 1], numbers[index + 2], numbers[index + 3])
    constructor(chars: Array<Char>, index: Int = 0) : this(chars[index].s, chars[index + 1].s, chars[index + 2].s, chars[index + 3].s)
    constructor(booleans: Array<Boolean>, index: Int = 0) : this(booleans[index].s, booleans[index + 1].s, booleans[index + 2].s, booleans[index + 3].s)

    constructor(list: List<Any>, index: Int = 0) : this(list[index].toShort, list[index + 1].toShort, list[index + 2].toShort, list[index + 3].toShort)

    constructor(bytes: ByteBuffer, index: Int = bytes.position(), oneByteOneShort: Boolean = false) : this(
            if (oneByteOneShort) bytes[index].s else bytes.getShort(index),
            if (oneByteOneShort) bytes[index + 1].s else bytes.getShort(index + Short.BYTES),
            if (oneByteOneShort) bytes[index + 2].s else bytes.getShort(index + Short.BYTES * 2),
            if (oneByteOneShort) bytes[index + 3].s else bytes.getShort(index + Short.BYTES * 3))

    constructor(chars: CharBuffer, index: Int = chars.position()) : this(chars[index].s, chars[index + 1].s, chars[index + 2].s, chars[index + 3].s)
    constructor(shorts: ShortBuffer, index: Int = shorts.position()) : this(shorts[index], shorts[index + 1], shorts[index + 2], shorts[index + 3])
    constructor(ints: IntBuffer, index: Int = ints.position()) : this(ints[index], ints[index + 1], ints[index + 2], ints[index + 3])
    constructor(longs: LongBuffer, index: Int = longs.position()) : this(longs[index], longs[index + 1], longs[index + 2], longs[index + 3])
    constructor(floats: FloatBuffer, index: Int = floats.position()) : this(floats[index], floats[index + 1], floats[index + 2], floats[index + 3])
    constructor(doubles: DoubleBuffer, index: Int = doubles.position()) : this(doubles[index], doubles[index + 1], doubles[index + 2], doubles[index + 3])

    constructor(s: Number) : this(s, s, s, s)
    constructor(x: Number, y: Number, z: Number, w: Number) : this(x.s, y.s, z.s, w.s)


    fun set(bytes: ByteArray, index: Int = 0, oneByteOneShort: Boolean = false, bigEndian: Boolean = true) {
        x = if (oneByteOneShort) bytes[index].s else bytes.getShort(index, bigEndian)
        y = if (oneByteOneShort) bytes[index + 1].s else bytes.getShort(index + Short.BYTES, bigEndian)
        z = if (oneByteOneShort) bytes[index + 2].s else bytes.getShort(index + Short.BYTES * 2, bigEndian)
        w = if (oneByteOneShort) bytes[index + 3].s else bytes.getShort(index + Short.BYTES * 3, bigEndian)
    }

    fun set(bytes: ByteBuffer, index: Int = bytes.position(), oneByteOneShort: Boolean = false) {
        x = if (oneByteOneShort) bytes[index].s else bytes.getShort(index)
        y = if (oneByteOneShort) bytes[index + 1].s else bytes.getShort(index + Short.BYTES)
        z = if (oneByteOneShort) bytes[index + 2].s else bytes.getShort(index + Short.BYTES * 2)
        w = if (oneByteOneShort) bytes[index + 3].s else bytes.getShort(index + Short.BYTES * 3)
    }


    override fun put(x: Number, y: Number, z: Number, w: Number): Vec4s {
        this.x = x.s
        this.y = y.s
        this.z = z.s
        this.w = w.s
        return this
    }


    infix fun to(shorts: ShortArray) = to(shorts, 0)
    fun to(shorts: ShortArray, index: Int): ShortArray {
        shorts[index] = x
        shorts[index + 1] = y
        shorts[index + 2] = z
        shorts[index + 3] = w
        return shorts
    }

    infix fun to(floats: ShortBuffer) = to(floats, 0)
    fun to(shorts: ShortBuffer, index: Int): ShortBuffer {
        shorts[index] = x
        shorts[index + 1] = y
        shorts[index + 2] = z
        shorts[index + 3] = w
        return shorts
    }

    override infix fun to(bytes: ByteBuffer) = to(bytes, bytes.position())
    override fun to(bytes: ByteBuffer, index: Int): ByteBuffer {
        bytes.putShort(index, x)
        bytes.putShort(index + Short.BYTES, y)
        bytes.putShort(index + Short.BYTES * 2, z)
        bytes.putShort(index + Short.BYTES * 3, w)
        return bytes
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
        0 -> x = s.s
        1 -> y = s.s
        2 -> z = s.s
        3 -> w = s.s
        else -> throw ArrayIndexOutOfBoundsException()
    }


    companion object : vec4s_operators {
        @JvmField
        val length = 4
        @JvmField
        val size = length * Short.BYTES
    }

    override fun instanceSize() = size



    // -- Unary arithmetic operators --

    operator fun unaryPlus() = this

    operator fun unaryMinus() = Vec4s(-x.s, -y.s, -z.s, -w.s) // TODO other .main.getS


    // -- Increment main.and decrement operators --

    operator fun inc(res: Vec4s = Vec4s()) = plus(res, this, 1, 1, 1, 1)
    fun inc_() = plus(this, this, 1, 1, 1, 1)


    operator fun dec(res: Vec4s = Vec4s()) = minus(res, this, 1, 1, 1, 1)
    fun dec_() = minus(this, this, 1, 1, 1, 1)


    // -- Specific binary arithmetic operators --

    operator fun plus(b: Short) = plus(Vec4s(), this, b, b, b, b)
    operator fun plus(b: Int) = plus(Vec4s(), this, b, b, b, b)
    operator fun plus(b: Vec4s) = plus(Vec4s(), this, b.x, b.y, b.z, b.w)

    fun plus(bX: Short, bY: Short, bZ: Short, bW: Short, res: Vec4s = Vec4s()) = plus(res, this, bX, bY, bZ, bW)
    fun plus(bX: Int, bY: Int, bZ: Int, bW: Int, res: Vec4s = Vec4s()) = plus(res, this, bX, bY, bZ, bW)
    fun plus(b: Short, res: Vec4s = Vec4s()) = plus(res, this, b, b, b, b)
    fun plus(b: Int, res: Vec4s = Vec4s()) = plus(res, this, b, b, b, b)
    fun plus(b: Vec4s, res: Vec4s = Vec4s()) = plus(res, this, b.x, b.y, b.z, b.w)

    fun plus_(bX: Short, bY: Short, bZ: Short, bW: Short) = plus(this, this, bX, bY, bZ, bW)
    fun plus_(bX: Int, bY: Int, bZ: Int, bW: Int) = plus(this, this, bX, bY, bZ, bW)
    infix fun plus_(b: Short) = plus(this, this, b, b, b, b)
    infix fun plus_(b: Int) = plus(this, this, b, b, b, b)
    infix fun plus_(b: Vec4s) = plus(this, this, b.x, b.y, b.z, b.w)


    operator fun minus(b: Short) = minus(Vec4s(), this, b, b, b, b)
    operator fun minus(b: Int) = minus(Vec4s(), this, b, b, b, b)
    operator fun minus(b: Vec4s) = minus(Vec4s(), this, b.x, b.y, b.z, b.w)

    fun minus(bX: Short, bY: Short, bZ: Short, bW: Short, res: Vec4s = Vec4s()) = minus(res, this, bX, bY, bZ, bW)
    fun minus(bX: Int, bY: Int, bZ: Int, bW: Int, res: Vec4s = Vec4s()) = minus(res, this, bX, bY, bZ, bW)
    fun minus(b: Short, res: Vec4s = Vec4s()) = minus(res, this, b, b, b, b)
    fun minus(b: Int, res: Vec4s = Vec4s()) = minus(res, this, b, b, b, b)
    fun minus(b: Vec4s, res: Vec4s = Vec4s()) = minus(res, this, b.x, b.y, b.z, b.w)

    fun minus_(bX: Short, bY: Short, bZ: Short, bW: Short) = minus(this, this, bX, bY, bZ, bW)
    fun minus_(bX: Int, bY: Int, bZ: Int, bW: Int) = minus(this, this, bX, bY, bZ, bW)
    infix fun minus_(b: Short) = minus(this, this, b, b, b, b)
    infix fun minus_(b: Int) = minus(this, this, b, b, b, b)
    infix fun minus_(b: Vec4s) = minus(this, this, b.x, b.y, b.z, b.w)


    operator fun times(b: Short) = times(Vec4s(), this, b, b, b, b)
    operator fun times(b: Int) = times(Vec4s(), this, b, b, b, b)
    operator fun times(b: Vec4s) = times(Vec4s(), this, b.x, b.y, b.z, b.w)

    fun times(bX: Short, bY: Short, bZ: Short, bW: Short, res: Vec4s = Vec4s()) = times(res, this, bX, bY, bZ, bW)
    fun times(bX: Int, bY: Int, bZ: Int, bW: Int, res: Vec4s = Vec4s()) = times(res, this, bX, bY, bZ, bW)
    fun times(b: Short, res: Vec4s = Vec4s()) = times(res, this, b, b, b, b)
    fun times(b: Int, res: Vec4s = Vec4s()) = times(res, this, b, b, b, b)
    fun times(b: Vec4s, res: Vec4s = Vec4s()) = times(res, this, b.x, b.y, b.z, b.w)

    fun times_(bX: Short, bY: Short, bZ: Short, bW: Short) = times(this, this, bX, bY, bZ, bW)
    fun times_(bX: Int, bY: Int, bZ: Int, bW: Int) = times(this, this, bX, bY, bZ, bW)
    infix fun times_(b: Short) = times(this, this, b, b, b, b)
    infix fun times_(b: Int) = times(this, this, b, b, b, b)
    infix fun times_(b: Vec4s) = times(this, this, b.x, b.y, b.z, b.w)


    operator fun div(b: Short) = div(Vec4s(), this, b, b, b, b)
    operator fun div(b: Int) = div(Vec4s(), this, b, b, b, b)
    operator fun div(b: Vec4s) = div(Vec4s(), this, b.x, b.y, b.z, b.w)

    fun div(bX: Short, bY: Short, bZ: Short, bW: Short, res: Vec4s = Vec4s()) = div(res, this, bX, bY, bZ, bW)
    fun div(bX: Int, bY: Int, bZ: Int, bW: Int, res: Vec4s = Vec4s()) = div(res, this, bX, bY, bZ, bW)
    fun div(b: Short, res: Vec4s) = div(res, this, b, b, b, b)
    fun div(b: Int, res: Vec4s) = div(res, this, b, b, b, b)
    fun div(b: Vec4s, res: Vec4s) = div(res, this, b.x, b.y, b.z, b.w)

    fun div_(bX: Short, bY: Short, bZ: Short, bW: Short) = div(this, this, bX, bY, bZ, bW)
    fun div_(bX: Int, bY: Int, bZ: Int, bW: Int) = div(this, this, bX, bY, bZ, bW)
    infix fun div_(b: Short) = div(this, this, b, b, b, b)
    infix fun div_(b: Int) = div(this, this, b, b, b, b)
    infix fun div_(b: Vec4s) = div(this, this, b.x, b.y, b.z, b.w)


    operator fun rem(b: Short) = rem(Vec4s(), this, b, b, b, b)
    operator fun rem(b: Int) = rem(Vec4s(), this, b, b, b, b)
    operator fun rem(b: Vec4s) = rem(Vec4s(), this, b.x, b.y, b.z, b.w)

    fun rem(bX: Short, bY: Short, bZ: Short, bW: Short, res: Vec4s = Vec4s()) = rem(res, this, bX, bY, bZ, bW)
    fun rem(bX: Int, bY: Int, bZ: Int, bW: Int, res: Vec4s = Vec4s()) = rem(res, this, bX, bY, bZ, bW)
    fun rem(b: Short, res: Vec4s) = rem(res, this, b, b, b, b)
    fun rem(b: Int, res: Vec4s) = rem(res, this, b, b, b, b)
    fun rem(b: Vec4s, res: Vec4s) = rem(res, this, b.x, b.y, b.z, b.w)

    fun rem_(bX: Short, bY: Short, bZ: Short, bW: Short) = rem(this, this, bX, bY, bZ, bW)
    fun rem_(bX: Int, bY: Int, bZ: Int, bW: Int) = rem(this, this, bX, bY, bZ, bW)
    infix fun rem_(b: Short) = rem(this, this, b, b, b, b)
    infix fun rem_(b: Int) = rem(this, this, b, b, b, b)
    infix fun rem_(b: Vec4s) = rem(this, this, b.x, b.y, b.z, b.w)


    // -- Generic binary arithmetic operators --

    operator fun plus(b: Number) = plus(Vec4s(), this, b.s, b.s, b.s, b.s)
    operator fun plus(b: Vec4t<out Number>) = plus(Vec4s(), this, b.x.s, b.y.s, b.z.s, b.w.s)

    fun plus(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4s = Vec4s()) = plus(res, this, bX.s, bY.s, bZ.s, bW.s)
    fun plus(b: Number, res: Vec4s = Vec4s()) = plus(res, this, b.s, b.s, b.s, b.s)
    fun plus(b: Vec4t<out Number>, res: Vec4s = Vec4s()) = plus(res, this, b.x.s, b.y.s, b.z.s, b.w.s)

    fun plus_(bX: Number, bY: Number, bZ: Number, bW: Number) = plus(this, this, bX.s, bY.s, bZ.s, bW.s)
    infix fun plus_(b: Number) = plus(this, this, b.s, b.s, b.s, b.s)
    infix fun plus_(b: Vec4t<out Number>) = plus(this, this, b.x.s, b.y.s, b.z.s, b.w.s)


    operator fun minus(b: Number) = minus(Vec4s(), this, b.s, b.s, b.s, b.s)
    operator fun minus(b: Vec4t<out Number>) = minus(Vec4s(), this, b.x.s, b.y.s, b.z.s, b.w.s)

    fun minus(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4s = Vec4s()) = minus(res, this, bX.s, bY.s, bZ.s, bW.s)
    fun minus(b: Number, res: Vec4s = Vec4s()) = minus(res, this, b.s, b.s, b.s, b.s)
    fun minus(b: Vec4t<out Number>, res: Vec4s = Vec4s()) = minus(res, this, b.x.s, b.y.s, b.z.s, b.w.s)

    fun minus_(bX: Number, bY: Number, bZ: Number, bW: Number) = minus(this, this, bX.s, bY.s, bZ.s, bW.s)
    infix fun minus_(b: Number) = minus(this, this, b.s, b.s, b.s, b.s)
    infix fun minus_(b: Vec4t<out Number>) = minus(this, this, b.x.s, b.y.s, b.z.s, b.w.s)


    operator fun times(b: Number) = times(Vec4s(), this, b.s, b.s, b.s, b.s)
    operator fun times(b: Vec4t<out Number>) = times(Vec4s(), this, b.x.s, b.y.s, b.z.s, b.w.s)

    fun times(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4s = Vec4s()) = times(res, this, bX.s, bY.s, bZ.s, bW.s)
    fun times(b: Number, res: Vec4s = Vec4s()) = times(res, this, b.s, b.s, b.s, b.s)
    fun times(b: Vec4t<out Number>, res: Vec4s = Vec4s()) = times(res, this, b.x.s, b.y.s, b.z.s, b.w.s)

    fun times_(bX: Number, bY: Number, bZ: Number, bW: Number) = times(this, this, bX.s, bY.s, bZ.s, bW.s)
    infix fun times_(b: Number) = times(this, this, b.s, b.s, b.s, b.s)
    infix fun times_(b: Vec4t<out Number>) = times(this, this, b.x.s, b.y.s, b.z.s, b.w.s)


    operator fun div(b: Number) = div(Vec4s(), this, b.s, b.s, b.s, b.s)
    operator fun div(b: Vec4t<out Number>) = div(Vec4s(), this, b.x.s, b.y.s, b.z.s, b.w.s)

    fun div(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4s = Vec4s()) = div(res, this, bX.s, bY.s, bZ.s, bW.s)
    fun div(b: Number, res: Vec4s) = div(res, this, b.s, b.s, b.s, b.s)
    fun div(b: Vec4t<out Number>, res: Vec4s) = div(res, this, b.x.s, b.y.s, b.z.s, b.w.s)

    fun div_(bX: Number, bY: Number, bZ: Number, bW: Number) = div(this, this, bX.s, bY.s, bZ.s, bW.s)
    infix fun div_(b: Number) = div(this, this, b.s, b.s, b.s, b.s)
    infix fun div_(b: Vec4t<out Number>) = div(this, this, b.x.s, b.y.s, b.z.s, b.w.s)


    operator fun rem(b: Number) = rem(Vec4s(), this, b.s, b.s, b.s, b.s)
    operator fun rem(b: Vec4t<out Number>) = rem(Vec4s(), this, b.x.s, b.y.s, b.z.s, b.w.s)

    fun rem(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4s = Vec4s()) = rem(res, this, bX.s, bY.s, bZ.s, bW.s)
    fun rem(b: Number, res: Vec4s) = rem(res, this, b.s, b.s, b.s, b.s)
    fun rem(b: Vec4t<out Number>, res: Vec4s) = rem(res, this, b.x.s, b.y.s, b.z.s, b.w.s)

    fun rem_(bX: Number, bY: Number, bZ: Number, bW: Number) = rem(this, this, bX.s, bY.s, bZ.s, bW.s)
    infix fun rem_(b: Number) = rem(this, this, b.s, b.s, b.s, b.s)
    infix fun rem_(b: Vec4t<out Number>) = rem(this, this, b.x.s, b.y.s, b.z.s, b.w.s)


    // -- Specific bitwise operators --

    infix fun and(b: Short) = and(Vec4s(), this, b, b, b, b)
    infix fun and(b: Int) = and(Vec4s(), this, b, b, b, b)
    infix fun and(b: Vec4s) = and(Vec4s(), this, b.x, b.y, b.z, b.w)

    infix fun and_(b: Short) = and(this, this, b, b, b, b)
    infix fun and_(b: Int) = and(this, this, b, b, b, b)
    infix fun and_(b: Vec4s) = and(this, this, b.x, b.y, b.z, b.w)

    fun and(b: Short, res: Vec4s) = and(res, this, b, b, b, b)
    fun and(b: Int, res: Vec4s) = and(res, this, b, b, b, b)
    fun and(b: Vec4s, res: Vec4s) = and(res, this, b.x, b.y, b.z, b.w)

    fun and(bX: Short, bY: Short, bZ: Short, bW: Short, res: Vec4s = Vec4s()) = and(res, this, bX, bY, bZ, bW)
    fun and(bX: Int, bY: Int, bZ: Int, bW: Int, res: Vec4s = Vec4s()) = and(res, this, bX, bY, bZ, bW)

    fun and_(bX: Short, bY: Short, bZ: Short, bW: Short) = and(this, this, bX, bY, bZ, bW)
    fun and_(bX: Int, bY: Int, bZ: Int, bW: Int) = and(this, this, bX, bY, bZ, bW)


    infix fun or(b: Short) = or(Vec4s(), this, b, b, b, b)
    infix fun or(b: Int) = or(Vec4s(), this, b, b, b, b)
    infix fun or(b: Vec4s) = or(Vec4s(), this, b.x, b.y, b.z, b.w)

    infix fun or_(b: Short) = or(this, this, b, b, b, b)
    infix fun or_(b: Int) = or(this, this, b, b, b, b)
    infix fun or_(b: Vec4s) = or(this, this, b.x, b.y, b.z, b.w)

    fun or(b: Short, res: Vec4s) = or(res, this, b, b, b, b)
    fun or(b: Int, res: Vec4s) = or(res, this, b, b, b, b)
    fun or(b: Vec4s, res: Vec4s) = or(res, this, b.x, b.y, b.z, b.w)

    fun or(bX: Short, bY: Short, bZ: Short, bW: Short, res: Vec4s = Vec4s()) = or(res, this, bX, bY, bZ, bW)
    fun or(bX: Int, bY: Int, bZ: Int, bW: Int, res: Vec4s = Vec4s()) = or(res, this, bX, bY, bZ, bW)

    fun or_(bX: Short, bY: Short, bZ: Short, bW: Short) = or(this, this, bX, bY, bZ, bW)
    fun or_(bX: Int, bY: Int, bZ: Int, bW: Int) = or(this, this, bX, bY, bZ, bW)


    infix fun xor(b: Short) = xor(Vec4s(), this, b, b, b, b)
    infix fun xor(b: Int) = xor(Vec4s(), this, b, b, b, b)
    infix fun xor(b: Vec4s) = xor(Vec4s(), this, b.x, b.y, b.z, b.w)

    infix fun xor_(b: Short) = xor(this, this, b, b, b, b)
    infix fun xor_(b: Int) = xor(this, this, b, b, b, b)
    infix fun xor_(b: Vec4s) = xor(this, this, b.x, b.y, b.z, b.w)

    fun xor(b: Short, res: Vec4s) = xor(res, this, b, b, b, b)
    fun xor(b: Int, res: Vec4s) = xor(res, this, b, b, b, b)
    fun xor(b: Vec4s, res: Vec4s) = xor(res, this, b.x, b.y, b.z, b.w)

    fun xor(bX: Short, bY: Short, bZ: Short, bW: Short, res: Vec4s = Vec4s()) = xor(res, this, bX, bY, bZ, bW)
    fun xor(bX: Int, bY: Int, bZ: Int, bW: Int, res: Vec4s = Vec4s()) = xor(res, this, bX, bY, bZ, bW)

    fun xor_(bX: Short, bY: Short, bZ: Short, bW: Short) = xor(this, this, bX, bY, bZ, bW)
    fun xor_(bX: Int, bY: Int, bZ: Int, bW: Int) = xor(this, this, bX, bY, bZ, bW)


    infix fun shl(b: Short) = shl(Vec4s(), this, b, b, b, b)
    infix fun shl(b: Int) = shl(Vec4s(), this, b, b, b, b)
    infix fun shl(b: Vec4s) = shl(Vec4s(), this, b.x, b.y, b.z, b.w)

    infix fun shl_(b: Short) = shl(this, this, b, b, b, b)
    infix fun shl_(b: Int) = shl(this, this, b, b, b, b)
    infix fun shl_(b: Vec4s) = shl(this, this, b.x, b.y, b.z, b.w)

    fun shl(b: Short, res: Vec4s) = shl(res, this, b, b, b, b)
    fun shl(b: Int, res: Vec4s) = shl(res, this, b, b, b, b)
    fun shl(b: Vec4s, res: Vec4s) = shl(res, this, b.x, b.y, b.z, b.w)

    fun shl(bX: Short, bY: Short, bZ: Short, bW: Short, res: Vec4s = Vec4s()) = shl(res, this, bX, bY, bZ, bW)
    fun shl(bX: Int, bY: Int, bZ: Int, bW: Int, res: Vec4s = Vec4s()) = shl(res, this, bX, bY, bZ, bW)

    fun shl_(bX: Short, bY: Short, bZ: Short, bW: Short) = shl(this, this, bX, bY, bZ, bW)
    fun shl_(bX: Int, bY: Int, bZ: Int, bW: Int) = shl(this, this, bX, bY, bZ, bW)


    infix fun shr(b: Short) = shr(Vec4s(), this, b, b, b, b)
    infix fun shr(b: Int) = shr(Vec4s(), this, b, b, b, b)
    infix fun shr(b: Vec4s) = shr(Vec4s(), this, b.x, b.y, b.z, b.w)

    infix fun shr_(b: Short) = shr(this, this, b, b, b, b)
    infix fun shr_(b: Int) = shr(this, this, b, b, b, b)
    infix fun shr_(b: Vec4s) = shr(this, this, b.x, b.y, b.z, b.w)

    fun shr(b: Short, res: Vec4s) = shr(res, this, b, b, b, b)
    fun shr(b: Int, res: Vec4s) = shr(res, this, b, b, b, b)
    fun shr(b: Vec4s, res: Vec4s) = shr(res, this, b.x, b.y, b.z, b.w)

    fun shr(bX: Short, bY: Short, bZ: Short, bW: Short, res: Vec4s = Vec4s()) = shr(res, this, bX, bY, bZ, bW)
    fun shr(bX: Int, bY: Int, bZ: Int, bW: Int, res: Vec4s = Vec4s()) = shr(res, this, bX, bY, bZ, bW)

    fun shr_(bX: Short, bY: Short, bZ: Short, bW: Short) = shr(this, this, bX, bY, bZ, bW)
    fun shr_(bX: Int, bY: Int, bZ: Int, bW: Int) = shr(this, this, bX, bY, bZ, bW)


    fun inv(res: Vec4s = Vec4s()) = inv(res, this)
    fun inv_() = inv(this, this)


    // -- Generic bitwise operators --

    infix fun and(b: Number) = and(Vec4s(), this, b.s, b.s, b.s, b.s)
    infix fun and(b: Vec4t<out Number>) = and(Vec4s(), this, b.x.s, b.y.s, b.z.s, b.w.s)

    infix fun and_(b: Number) = and(this, this, b.s, b.s, b.s, b.s)
    infix fun and_(b: Vec4t<out Number>) = and(this, this, b.x.s, b.y.s, b.z.s, b.w.s)

    fun and(b: Number, res: Vec4s) = and(res, this, b.s, b.s, b.s, b.s)
    fun and(b: Vec4t<out Number>, res: Vec4s) = and(res, this, b.x.s, b.y.s, b.z.s, b.w.s)

    fun and(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4s = Vec4s()) = and(res, this, bX.s, bY.s, bZ.s, bW.s)

    fun and_(bX: Number, bY: Number, bZ: Number, bW: Number) = and(this, this, bX.s, bY.s, bZ.s, bW.s)


    infix fun or(b: Number) = or(Vec4s(), this, b.s, b.s, b.s, b.s)
    infix fun or(b: Vec4t<out Number>) = or(Vec4s(), this, b.x.s, b.y.s, b.z.s, b.w.s)

    infix fun or_(b: Number) = or(this, this, b.s, b.s, b.s, b.s)
    infix fun or_(b: Vec4t<out Number>) = or(this, this, b.x.s, b.y.s, b.z.s, b.w.s)

    fun or(b: Number, res: Vec4s) = or(res, this, b.s, b.s, b.s, b.s)
    fun or(b: Vec4t<out Number>, res: Vec4s) = or(res, this, b.x.s, b.y.s, b.z.s, b.w.s)

    fun or(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4s = Vec4s()) = or(res, this, bX.s, bY.s, bZ.s, bW.s)

    fun or_(bX: Number, bY: Number, bZ: Number, bW: Number) = or(this, this, bX.s, bY.s, bZ.s, bW.s)


    infix fun xor(b: Number) = xor(Vec4s(), this, b.s, b.s, b.s, b.s)
    infix fun xor(b: Vec4t<out Number>) = xor(Vec4s(), this, b.x.s, b.y.s, b.z.s, b.w.s)

    infix fun xor_(b: Number) = xor(this, this, b.s, b.s, b.s, b.s)
    infix fun xor_(b: Vec4t<out Number>) = xor(this, this, b.x.s, b.y.s, b.z.s, b.w.s)

    fun xor(b: Number, res: Vec4s) = xor(res, this, b.s, b.s, b.s, b.s)
    fun xor(b: Vec4t<out Number>, res: Vec4s) = xor(res, this, b.x.s, b.y.s, b.z.s, b.w.s)

    fun xor(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4s = Vec4s()) = xor(res, this, bX.s, bY.s, bZ.s, bW.s)

    fun xor_(bX: Number, bY: Number, bZ: Number, bW: Number) = xor(this, this, bX.s, bY.s, bZ.s, bW.s)


    infix fun shl(b: Number) = shl(Vec4s(), this, b.s, b.s, b.s, b.s)
    infix fun shl(b: Vec4t<out Number>) = shl(Vec4s(), this, b.x.s, b.y.s, b.z.s, b.w.s)

    infix fun shl_(b: Number) = shl(this, this, b.s, b.s, b.s, b.s)
    infix fun shl_(b: Vec4t<out Number>) = shl(this, this, b.x.s, b.y.s, b.z.s, b.w.s)

    fun shl(b: Number, res: Vec4s) = shl(res, this, b.s, b.s, b.s, b.s)
    fun shl(b: Vec4t<out Number>, res: Vec4s) = shl(res, this, b.x.s, b.y.s, b.z.s, b.w.s)

    fun shl(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4s = Vec4s()) = shl(res, this, bX.s, bY.s, bZ.s, bW.s)

    fun shl_(bX: Number, bY: Number, bZ: Number, bW: Number) = shl(this, this, bX.s, bY.s, bZ.s, bW.s)


    infix fun shr(b: Number) = shr(Vec4s(), this, b.s, b.s, b.s, b.s)
    infix fun shr(b: Vec4t<out Number>) = shr(Vec4s(), this, b.x.s, b.y.s, b.z.s, b.w.s)

    infix fun shr_(b: Number) = shr(this, this, b.s, b.s, b.s, b.s)
    infix fun shr_(b: Vec4t<out Number>) = shr(this, this, b.x.s, b.y.s, b.z.s, b.w.s)

    fun shr(b: Number, res: Vec4s) = shr(res, this, b.s, b.s, b.s, b.s)
    fun shr(b: Vec4t<out Number>, res: Vec4s) = shr(res, this, b.x.s, b.y.s, b.z.s, b.w.s)

    fun shr(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4s = Vec4s()) = shr(res, this, bX.s, bY.s, bZ.s, bW.s)

    fun shr_(bX: Number, bY: Number, bZ: Number, bW: Number) = shr(this, this, bX.s, bY.s, bZ.s, bW.s)


    override fun equals(other: Any?) = other is Vec4s && this[0] == other[0] && this[1] == other[1] && this[2] == other[2] && this[3] == other[3]
    override fun hashCode() = 31 * (31 * (31 * x.hashCode() + y.hashCode()) + z.hashCode()) + w.hashCode()
}