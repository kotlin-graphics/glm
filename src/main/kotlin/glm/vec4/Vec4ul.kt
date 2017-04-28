package glm.vec4

import glm.*
import unsigned.Ulong
import glm.vec2.Vec2t
import glm.vec2.Vec2bool
import glm.vec3.Vec3t
import glm.vec3.Vec3bool
import java.nio.*
import glm.vec4.operators.vec4ul_operators

/**
 * Created by elect on 09/10/16.
 */

class Vec4ul(x: Ulong, y: Ulong, z: Ulong, w: Ulong) : Vec4t<Ulong>(x, y, z, w) {

    // -- Explicit basic, conversion other main.and conversion vector constructors --

    constructor() : this(0)

    constructor(v: Vec2t<out Number>) : this(v.x, v.y, 0, 1)
    constructor(v: Vec2t<out Number>, z: Number, w: Number) : this(v.x, v.y, z, w)
    constructor(v: Vec3t<out Number>) : this(v, 1)
    constructor(v: Vec3t<out Number>, w: Number) : this(v.x, v.y, v.z, w)
    constructor(x: Number, v: Vec3t<out Number>) : this(x, v.x, v.y, v.z)
    constructor(v: Vec4t<out Number>) : this(v.x, v.y, v.z, v.w)

    constructor(v: Vec2bool) : this(v.x.ul, v.y.ul, 0, 1)
    constructor(v: Vec3bool) : this(v.x.ul, v.y.ul, v.z.ul, 1)
    constructor(v: Vec4bool) : this(v.x.ul, v.y.ul, v.z.ul, v.w.ul)

    constructor(bytes: ByteArray, index: Int = 0, oneByteOneUlong: Boolean = true, bigEndianess: Boolean = true) : this(
            if (oneByteOneUlong) bytes[index].ul else bytes.getUlong(index, bigEndianess),
            if (oneByteOneUlong) bytes[index + 1].ul else bytes.getUlong(index + Ulong.BYTES, bigEndianess),
            if (oneByteOneUlong) bytes[index + 2].ul else bytes.getUlong(index + Ulong.BYTES * 2, bigEndianess),
            if (oneByteOneUlong) bytes[index + 3].ul else bytes.getUlong(index + Ulong.BYTES * 3, bigEndianess))

    constructor(chars: CharArray, index: Int = 0) : this(chars[index].ul, chars[index + 1].ul, chars[index + 2].ul, chars[index + 3].ul)
    constructor(shorts: ShortArray, index: Int = 0) : this(shorts[index], shorts[index + 1], shorts[index + 2], shorts[index + 3])
    constructor(ints: IntArray, index: Int = 0) : this(ints[index], ints[index + 1], ints[index + 2], ints[index + 3])
    constructor(longs: LongArray, index: Int = 0) : this(longs[index], longs[index + 1], longs[index + 2], longs[index + 3])
    constructor(floats: FloatArray, index: Int = 0) : this(floats[index], floats[index + 1], floats[index + 2], floats[index + 3])
    constructor(doubles: DoubleArray, index: Int = 0) : this(doubles[index], doubles[index + 1], doubles[index + 2], doubles[index + 3])
    constructor(booleans: BooleanArray, index: Int = 0) : this(booleans[index].ul, booleans[index + 1].ul, booleans[index + 2].ul, booleans[index + 3].ul)

    constructor(numbers: Array<out Number>, index: Int = 0) : this(numbers[index], numbers[index + 1], numbers[index + 2], numbers[index + 3])
    constructor(chars: Array<Char>, index: Int = 0) : this(chars[index].ul, chars[index + 1].ul, chars[index + 2].ul, chars[index + 3].ul)
    constructor(booleans: Array<Boolean>, index: Int = 0) : this(booleans[index].ul, booleans[index + 1].ul, booleans[index + 2].ul, booleans[index + 3].ul)

    constructor(list: List<Any>, index: Int = 0) : this() {
        put(list, index)
    }

    constructor(bytes: ByteBuffer, index: Int = bytes.position(), oneByteOneUlong: Boolean = true) : this(
            if (oneByteOneUlong) bytes[index].ul else bytes.getLong(index).ul,
            if (oneByteOneUlong) bytes[index + 1].ul else bytes.getLong(index + Ulong.BYTES).ul,
            if (oneByteOneUlong) bytes[index + 2].ul else bytes.getLong(index + Ulong.BYTES * 2).ul,
            if (oneByteOneUlong) bytes[index + 3].ul else bytes.getLong(index + Ulong.BYTES * 3).ul)

    constructor(chars: CharBuffer, index: Int = chars.position()) : this(chars[index].ul, chars[index + 1].ul, chars[index + 2].ul, chars[index + 3].ul)
    constructor(shorts: ShortBuffer, index: Int = shorts.position()) : this(shorts[index], shorts[index + 1], shorts[index + 2], shorts[index + 3])
    constructor(ints: IntBuffer, index: Int = ints.position()) : this(ints[index], ints[index + 1], ints[index + 2], ints[index + 3])
    constructor(longs: LongBuffer, index: Int = longs.position()) : this(longs[index], longs[index + 1], longs[index + 2], longs[index + 3])
    constructor(floats: FloatBuffer, index: Int = floats.position()) : this(floats[index], floats[index + 1], floats[index + 2], floats[index + 3])
    constructor(doubles: DoubleBuffer, index: Int = doubles.position()) : this(doubles[index], doubles[index + 1], doubles[index + 2], doubles[index + 3])

    constructor(s: Number) : this(s, s, s, s)
    constructor(x: Number, y: Number, z: Number, w: Number) : this(x.ul, y.ul, z.ul, w.ul)


    fun set(bytes: ByteArray, index: Int = 0, oneByteOneUlong: Boolean = true, bigEndianess: Boolean = true) {
        x.v = if (oneByteOneUlong) bytes[index].L else bytes.getLong(index, bigEndianess)
        y.v = if (oneByteOneUlong) bytes[index + 1].L else bytes.getLong(index + Ulong.BYTES, bigEndianess)
        z.v = if (oneByteOneUlong) bytes[index + 2].L else bytes.getLong(index + Ulong.BYTES * 2, bigEndianess)
        w.v = if (oneByteOneUlong) bytes[index + 3].L else bytes.getLong(index + Ulong.BYTES * 3, bigEndianess)
    }

    fun set(bytes: ByteBuffer, index: Int = bytes.position(), oneByteOneUlong: Boolean = true) {
        x.v = if (oneByteOneUlong) bytes[index].L else bytes.getLong(index)
        y.v = if (oneByteOneUlong) bytes[index + 1].L else bytes.getLong(index + Ulong.BYTES)
        z.v = if (oneByteOneUlong) bytes[index + 2].L else bytes.getLong(index + Ulong.BYTES * 2)
        w.v = if (oneByteOneUlong) bytes[index + 3].L else bytes.getLong(index + Ulong.BYTES * 3)
    }


    override fun put(x: Number, y: Number, z: Number, w: Number): Vec4ul {
        this.x = x.ul
        this.y = y.ul
        this.z = z.ul
        this.w = w.ul
        return this
    }


    // -- Component accesses --

    operator fun get(i: Int) = when (i) {
        0 -> x
        1 -> y
        2 -> z
        3 -> w
        else -> throw ArrayIndexOutOfBoundsException()
    }

    operator fun set(i: Int, s: Number) = when (i) {
        0 -> x = s.ul
        1 -> y = s.ul
        2 -> y = s.ul
        3 -> w = s.ul
        else -> throw ArrayIndexOutOfBoundsException()
    }

    override fun instanceSIZE() = size


    companion object : vec4ul_operators {
        @JvmField val length = 4
        @JvmField val size = length * Ulong.BYTES
    }

    override infix fun to(bytes: ByteBuffer) = to(bytes, bytes.position())

    override fun to(bytes: ByteBuffer, index: Int): ByteBuffer {
        bytes.putLong(index, x.v)
        bytes.putLong(index + Long.BYTES, y.v)
        bytes.putLong(index + Long.BYTES * 2, z.v)
        bytes.putLong(index + Long.BYTES * 3, w.v)
        return bytes
    }


    // -- Unary arithmetic operators --

    operator fun unaryPlus() = this

    // no unaryMinus operator, only signed

    // -- Increment main.and decrement operators --

    operator fun inc(res: Vec4ul = Vec4ul()) = plus(res, this, 1, 1, 1, 1)
    fun inc_() = plus(this, this, 1, 1, 1, 1)


    operator fun dec(res: Vec4ul = Vec4ul()) = minus(res, this, 1, 1, 1, 1)
    fun dec_() = minus(this, this, 1, 1, 1, 1)


    // -- Specific binary arithmetic operators --

    operator fun plus(b: Ulong) = plus(Vec4ul(), this, b, b, b, b)
    operator fun plus(b: Long) = plus(Vec4ul(), this, b, b, b, b)
    operator fun plus(b: Vec4ul) = plus(Vec4ul(), this, b.x, b.y, b.z, b.w)

    fun plus(bX: Ulong, bY: Ulong, bZ: Ulong, bW: Ulong, res: Vec4ul = Vec4ul()) = plus(res, this, bX, bY, bZ, bW)
    fun plus(bX: Long, bY: Long, bZ: Long, bW: Long, res: Vec4ul = Vec4ul()) = plus(res, this, bX, bY, bZ, bW)
    fun plus(b: Ulong, res: Vec4ul = Vec4ul()) = plus(res, this, b, b, b, b)
    fun plus(b: Long, res: Vec4ul = Vec4ul()) = plus(res, this, b, b, b, b)
    fun plus(b: Vec4ul, res: Vec4ul = Vec4ul()) = plus(res, this, b.x, b.y, b.z, b.w)

    fun plus_(bX: Ulong, bY: Ulong, bZ: Ulong, bW: Ulong) = plus(this, this, bX, bY, bZ, bW)
    fun plus_(bX: Long, bY: Long, bZ: Long, bW: Long) = plus(this, this, bX, bY, bZ, bW)
    infix fun plus_(b: Ulong) = plus(this, this, b, b, b, b)
    infix fun plus_(b: Long) = plus(this, this, b, b, b, b)
    infix fun plus_(b: Vec4ul) = plus(this, this, b.x, b.y, b.z, b.w)


    operator fun minus(b: Ulong) = minus(Vec4ul(), this, b, b, b, b)
    operator fun minus(b: Long) = minus(Vec4ul(), this, b, b, b, b)
    operator fun minus(b: Vec4ul) = minus(Vec4ul(), this, b.x, b.y, b.z, b.w)

    fun minus(bX: Ulong, bY: Ulong, bZ: Ulong, bW: Ulong, res: Vec4ul = Vec4ul()) = minus(res, this, bX, bY, bZ, bW)
    fun minus(bX: Long, bY: Long, bZ: Long, bW: Long, res: Vec4ul = Vec4ul()) = minus(res, this, bX, bY, bZ, bW)
    fun minus(b: Ulong, res: Vec4ul = Vec4ul()) = minus(res, this, b, b, b, b)
    fun minus(b: Long, res: Vec4ul = Vec4ul()) = minus(res, this, b, b, b, b)
    fun minus(b: Vec4ul, res: Vec4ul = Vec4ul()) = minus(res, this, b.x, b.y, b.z, b.w)

    fun minus_(bX: Ulong, bY: Ulong, bZ: Ulong, bW: Ulong) = minus(this, this, bX, bY, bZ, bW)
    fun minus_(bX: Long, bY: Long, bZ: Long, bW: Long) = minus(this, this, bX, bY, bZ, bW)
    infix fun minus_(b: Ulong) = minus(this, this, b, b, b, b)
    infix fun minus_(b: Long) = minus(this, this, b, b, b, b)
    infix fun minus_(b: Vec4ul) = minus(this, this, b.x, b.y, b.z, b.w)


    operator fun times(b: Ulong) = times(Vec4ul(), this, b, b, b, b)
    operator fun times(b: Long) = times(Vec4ul(), this, b, b, b, b)
    operator fun times(b: Vec4ul) = times(Vec4ul(), this, b.x, b.y, b.z, b.w)

    fun times(bX: Ulong, bY: Ulong, bZ: Ulong, bW: Ulong, res: Vec4ul = Vec4ul()) = times(res, this, bX, bY, bZ, bW)
    fun times(bX: Long, bY: Long, bZ: Long, bW: Long, res: Vec4ul = Vec4ul()) = times(res, this, bX, bY, bZ, bW)
    fun times(b: Ulong, res: Vec4ul = Vec4ul()) = times(res, this, b, b, b, b)
    fun times(b: Long, res: Vec4ul = Vec4ul()) = times(res, this, b, b, b, b)
    fun times(b: Vec4ul, res: Vec4ul = Vec4ul()) = times(res, this, b.x, b.y, b.z, b.w)

    fun times_(bX: Ulong, bY: Ulong, bZ: Ulong, bW: Ulong) = times(this, this, bX, bY, bZ, bW)
    fun times_(bX: Long, bY: Long, bZ: Long, bW: Long) = times(this, this, bX, bY, bZ, bW)
    infix fun times_(b: Ulong) = times(this, this, b, b, b, b)
    infix fun times_(b: Long) = times(this, this, b, b, b, b)
    infix fun times_(b: Vec4ul) = times(this, this, b.x, b.y, b.z, b.w)


    operator fun div(b: Ulong) = div(Vec4ul(), this, b, b, b, b)
    operator fun div(b: Long) = div(Vec4ul(), this, b, b, b, b)
    operator fun div(b: Vec4ul) = div(Vec4ul(), this, b.x, b.y, b.z, b.w)

    fun div(bX: Ulong, bY: Ulong, bZ: Ulong, bW: Ulong, res: Vec4ul = Vec4ul()) = div(res, this, bX, bY, bZ, bW)
    fun div(bX: Long, bY: Long, bZ: Long, bW: Long, res: Vec4ul = Vec4ul()) = div(res, this, bX, bY, bZ, bW)
    fun div(b: Ulong, res: Vec4ul = Vec4ul()) = div(res, this, b, b, b, b)
    fun div(b: Long, res: Vec4ul = Vec4ul()) = div(res, this, b, b, b, b)
    fun div(b: Vec4ul, res: Vec4ul = Vec4ul()) = div(res, this, b.x, b.y, b.z, b.w)

    fun div_(bX: Ulong, bY: Ulong, bZ: Ulong, bW: Ulong) = div(this, this, bX, bY, bZ, bW)
    fun div_(bX: Long, bY: Long, bZ: Long, bW: Long) = div(this, this, bX, bY, bZ, bW)
    infix fun div_(b: Ulong) = div(this, this, b, b, b, b)
    infix fun div_(b: Long) = div(this, this, b, b, b, b)
    infix fun div_(b: Vec4ul) = div(this, this, b.x, b.y, b.z, b.w)


    operator fun rem(b: Ulong) = rem(Vec4ul(), this, b, b, b, b)
    operator fun rem(b: Long) = rem(Vec4ul(), this, b, b, b, b)
    operator fun rem(b: Vec4ul) = rem(Vec4ul(), this, b.x, b.y, b.z, b.w)

    fun rem(bX: Ulong, bY: Ulong, bZ: Ulong, bW: Ulong, res: Vec4ul = Vec4ul()) = rem(res, this, bX, bY, bZ, bW)
    fun rem(bX: Long, bY: Long, bZ: Long, bW: Long, res: Vec4ul = Vec4ul()) = rem(res, this, bX, bY, bZ, bW)
    fun rem(b: Ulong, res: Vec4ul = Vec4ul()) = rem(res, this, b, b, b, b)
    fun rem(b: Long, res: Vec4ul = Vec4ul()) = rem(res, this, b, b, b, b)
    fun rem(b: Vec4ul, res: Vec4ul = Vec4ul()) = rem(res, this, b.x, b.y, b.z, b.w)

    fun rem_(bX: Ulong, bY: Ulong, bZ: Ulong, bW: Ulong) = rem(this, this, bX, bY, bZ, bW)
    fun rem_(bX: Long, bY: Long, bZ: Long, bW: Long) = rem(this, this, bX, bY, bZ, bW)
    infix fun rem_(b: Ulong) = rem(this, this, b, b, b, b)
    infix fun rem_(b: Long) = rem(this, this, b, b, b, b)
    infix fun rem_(b: Vec4ul) = rem(this, this, b.x, b.y, b.z, b.w)


    // -- Generic binary arithmetic operators --

    operator fun plus(b: Number) = plus(Vec4ul(), this, b.L, b.L, b.L, b.L)
    operator fun plus(b: Vec4t<out Number>) = plus(Vec4ul(), this, b.x.L, b.y.L, b.z.L, b.w.L)

    fun plus(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4ul = Vec4ul()) = plus(res, this, bX.L, bY.L, bZ.L, bW.L)
    fun plus(b: Number, res: Vec4ul = Vec4ul()) = plus(res, this, b.L, b.L, b.L, b.L)
    fun plus(b: Vec4t<out Number>, res: Vec4ul = Vec4ul()) = plus(res, this, b.x.L, b.y.L, b.z.L, b.w.L)

    fun plus_(bX: Number, bY: Number, bZ: Number, bW: Number) = plus(this, this, bX.L, bY.L, bZ.L, bW.L)
    infix fun plus_(b: Number) = plus(this, this, b.L, b.L, b.L, b.L)
    infix fun plus_(b: Vec4t<out Number>) = plus(this, this, b.x.L, b.y.L, b.z.L, b.w.L)


    operator fun minus(b: Number) = minus(Vec4ul(), this, b.L, b.L, b.L, b.L)
    operator fun minus(b: Vec4t<out Number>) = minus(Vec4ul(), this, b.x.L, b.y.L, b.z.L, b.w.L)

    fun minus(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4ul = Vec4ul()) = minus(res, this, bX.L, bY.L, bZ.L, bW.L)
    fun minus(b: Number, res: Vec4ul = Vec4ul()) = minus(res, this, b.L, b.L, b.L, b.L)
    fun minus(b: Vec4t<out Number>, res: Vec4ul = Vec4ul()) = minus(res, this, b.x.L, b.y.L, b.z.L, b.w.L)

    fun minus_(bX: Number, bY: Number, bZ: Number, bW: Number) = minus(this, this, bX.L, bY.L, bZ.L, bW.L)
    infix fun minus_(b: Number) = minus(this, this, b.L, b.L, b.L, b.L)
    infix fun minus_(b: Vec4t<out Number>) = minus(this, this, b.x.L, b.y.L, b.z.L, b.w.L)


    operator fun times(b: Number) = times(Vec4ul(), this, b.L, b.L, b.L, b.L)
    operator fun times(b: Vec4t<out Number>) = times(Vec4ul(), this, b.x.L, b.y.L, b.z.L, b.w.L)

    fun times(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4ul = Vec4ul()) = times(res, this, bX.L, bY.L, bZ.L, bW.L)
    fun times(b: Number, res: Vec4ul = Vec4ul()) = times(res, this, b.L, b.L, b.L, b.L)
    fun times(b: Vec4t<out Number>, res: Vec4ul = Vec4ul()) = times(res, this, b.x.L, b.y.L, b.z.L, b.w.L)

    fun times_(bX: Number, bY: Number, bZ: Number, bW: Number) = times(this, this, bX.L, bY.L, bZ.L, bW.L)
    infix fun times_(b: Number) = times(this, this, b.L, b.L, b.L, b.L)
    infix fun times_(b: Vec4t<out Number>) = times(this, this, b.x.L, b.y.L, b.z.L, b.w.L)


    operator fun div(b: Number) = div(Vec4ul(), this, b.L, b.L, b.L, b.L)
    operator fun div(b: Vec4t<out Number>) = div(Vec4ul(), this, b.x.L, b.y.L, b.z.L, b.w.L)

    fun div(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4ul = Vec4ul()) = div(res, this, bX.L, bY.L, bZ.L, bW.L)
    fun div(b: Number, res: Vec4ul = Vec4ul()) = div(res, this, b.L, b.L, b.L, b.L)
    fun div(b: Vec4t<out Number>, res: Vec4ul = Vec4ul()) = div(res, this, b.x.L, b.y.L, b.z.L, b.w.L)

    fun div_(bX: Number, bY: Number, bZ: Number, bW: Number) = div(this, this, bX.L, bY.L, bZ.L, bW.L)
    infix fun div_(b: Number) = div(this, this, b.L, b.L, b.L, b.L)
    infix fun div_(b: Vec4t<out Number>) = div(this, this, b.x.L, b.y.L, b.z.L, b.w.L)


    operator fun rem(b: Number) = rem(Vec4ul(), this, b.L, b.L, b.L, b.L)
    operator fun rem(b: Vec4t<out Number>) = rem(Vec4ul(), this, b.x.L, b.y.L, b.z.L, b.w.L)

    fun rem(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4ul = Vec4ul()) = rem(res, this, bX.L, bY.L, bZ.L, bW.L)
    fun rem(b: Number, res: Vec4ul = Vec4ul()) = rem(res, this, b.L, b.L, b.L, b.L)
    fun rem(b: Vec4t<out Number>, res: Vec4ul = Vec4ul()) = rem(res, this, b.x.L, b.y.L, b.z.L, b.w.L)

    fun rem_(bX: Number, bY: Number, bZ: Number, bW: Number) = rem(this, this, bX.L, bY.L, bZ.L, bW.L)
    infix fun rem_(b: Number) = rem(this, this, b.L, b.L, b.L, b.L)
    infix fun rem_(b: Vec4t<out Number>) = rem(this, this, b.x.L, b.y.L, b.z.L, b.w.L)


    // -- Specific bitwise operators --

    infix fun and(b: Ulong) = and(Vec4ul(), this, b, b, b, b)
    infix fun and(b: Long) = and(Vec4ul(), this, b, b, b, b)
    fun and(bX: Ulong, bY: Ulong, bZ: Ulong, bW: Ulong) = and(Vec4ul(), this, bX, bY, bZ, bW)
    fun and(bX: Long, bY: Long, bZ: Long, bW: Long) = and(Vec4ul(), this, bX, bY, bZ, bW)
    fun and(b: Vec4ul) = and(Vec4ul(), this, b.x, b.y, b.z, b.w)

    infix fun and_(b: Ulong) = and(this, this, b, b, b, b)
    infix fun and_(b: Long) = and(this, this, b, b, b, b)
    fun and_(bX: Ulong, bY: Ulong, bZ: Ulong, bW: Ulong) = and(this, this, bX, bY, bZ, bW)
    fun and_(bX: Long, bY: Long, bZ: Long, bW: Long) = and(this, this, bX, bY, bZ, bW)
    infix fun and_(b: Vec4ul) = and(this, this, b.x, b.y, b.z, b.w)

    fun and(b: Ulong, res: Vec4ul) = and(res, this, b, b, b, b)
    fun and(b: Long, res: Vec4ul) = and(res, this, b, b, b, b)
    fun and(bX: Ulong, bY: Ulong, bZ: Ulong, bW: Ulong, res: Vec4ul) = and(res, this, bX, bY, bZ, bW)
    fun and(bX: Long, bY: Long, bZ: Long, bW: Long, res: Vec4ul) = and(res, this, bX, bY, bZ, bW)
    fun and(b: Vec4ul, res: Vec4ul) = and(res, this, b.x, b.y, b.z, b.w)


    infix fun or(b: Ulong) = or(Vec4ul(), this, b, b, b, b)
    infix fun or(b: Long) = or(Vec4ul(), this, b, b, b, b)
    fun or(bX: Ulong, bY: Ulong, bZ: Ulong, bW: Ulong) = or(Vec4ul(), this, bX, bY, bZ, bW)
    fun or(bX: Long, bY: Long, bZ: Long, bW: Long) = or(Vec4ul(), this, bX, bY, bZ, bW)
    fun or(b: Vec4ul) = or(Vec4ul(), this, b.x, b.y, b.z, b.w)

    infix fun or_(b: Ulong) = or(this, this, b, b, b, b)
    infix fun or_(b: Long) = or(this, this, b, b, b, b)
    fun or_(bX: Ulong, bY: Ulong, bZ: Ulong, bW: Ulong) = or(this, this, bX, bY, bZ, bW)
    fun or_(bX: Long, bY: Long, bZ: Long, bW: Long) = or(this, this, bX, bY, bZ, bW)
    infix fun or_(b: Vec4ul) = or(this, this, b.x, b.y, b.z, b.w)

    fun or(b: Ulong, res: Vec4ul) = or(res, this, b, b, b, b)
    fun or(b: Long, res: Vec4ul) = or(res, this, b, b, b, b)
    fun or(bX: Ulong, bY: Ulong, bZ: Ulong, bW: Ulong, res: Vec4ul) = or(res, this, bX, bY, bZ, bW)
    fun or(bX: Long, bY: Long, bZ: Long, bW: Long, res: Vec4ul) = or(res, this, bX, bY, bZ, bW)
    fun or(b: Vec4ul, res: Vec4ul) = or(res, this, b.x, b.y, b.z, b.w)


    infix fun xor(b: Ulong) = xor(Vec4ul(), this, b, b, b, b)
    infix fun xor(b: Long) = xor(Vec4ul(), this, b, b, b, b)
    fun xor(bX: Ulong, bY: Ulong, bZ: Ulong, bW: Ulong) = xor(Vec4ul(), this, bX, bY, bZ, bW)
    fun xor(bX: Long, bY: Long, bZ: Long, bW: Long) = xor(Vec4ul(), this, bX, bY, bZ, bW)
    fun xor(b: Vec4ul) = xor(Vec4ul(), this, b.x, b.y, b.z, b.w)

    infix fun xor_(b: Ulong) = xor(this, this, b, b, b, b)
    infix fun xor_(b: Long) = xor(this, this, b, b, b, b)
    fun xor_(bX: Ulong, bY: Ulong, bZ: Ulong, bW: Ulong) = xor(this, this, bX, bY, bZ, bW)
    fun xor_(bX: Long, bY: Long, bZ: Long, bW: Long) = xor(this, this, bX, bY, bZ, bW)
    infix fun xor_(b: Vec4ul) = xor(this, this, b.x, b.y, b.z, b.w)

    fun xor(b: Ulong, res: Vec4ul) = xor(res, this, b, b, b, b)
    fun xor(b: Long, res: Vec4ul) = xor(res, this, b, b, b, b)
    fun xor(bX: Ulong, bY: Ulong, bZ: Ulong, bW: Ulong, res: Vec4ul) = xor(res, this, bX, bY, bZ, bW)
    fun xor(bX: Long, bY: Long, bZ: Long, bW: Long, res: Vec4ul) = xor(res, this, bX, bY, bZ, bW)
    fun xor(b: Vec4ul, res: Vec4ul) = xor(res, this, b.x, b.y, b.z, b.w)


    infix fun shl(b: Int) = shl(Vec4ul(), this, b, b, b, b)
    fun shl(bX: Int, bY: Int, bZ: Int, bW: Int) = shl(Vec4ul(), this, bX, bY, bZ, bW)

    infix fun shl_(b: Int) = shl(this, this, b, b, b, b)
    fun shl_(bX: Int, bY: Int, bZ: Int, bW: Int) = shl(this, this, bX, bY, bZ, bW)

    fun shl(b: Int, res: Vec4ul) = shl(res, this, b, b, b, b)
    fun shl(bX: Int, bY: Int, bZ: Int, bW: Int, res: Vec4ul) = shl(res, this, bX, bY, bZ, bW)


    infix fun shr(b: Int) = shr(Vec4ul(), this, b, b, b, b)
    fun shr(bX: Int, bY: Int, bZ: Int, bW: Int) = shr(Vec4ul(), this, bX, bY, bZ, bW)

    infix fun shr_(b: Int) = shr(this, this, b, b, b, b)
    fun shr_(bX: Int, bY: Int, bZ: Int, bW: Int) = shr(this, this, bX, bY, bZ, bW)

    fun shr(b: Int, res: Vec4ul) = shr(res, this, b, b, b, b)
    fun shr(bX: Int, bY: Int, bZ: Int, bW: Int, res: Vec4ul) = shr(res, this, bX, bY, bZ, bW)


    fun inv(res: Vec4ul = Vec4ul()) = inv(res, this)
    fun inv_() = inv(this, this)


    // -- Generic bitwise operators --

    infix fun and(b: Number) = and(Vec4ul(), this, b.L, b.L, b.L, b.L)
    fun and(bX: Number, bY: Number, bZ: Number, bW: Number) = and(Vec4ul(), this, bX.L, bY.L, bZ.L, bW.L)
    fun and(b: Vec4t<out Number>) = and(Vec4ul(), this, b.x.L, b.y.L, b.z.L, b.w.L)

    infix fun and_(b: Number) = and(this, this, b.L, b.L, b.L, b.L)
    fun and_(bX: Number, bY: Number, bZ: Number, bW: Number) = and(this, this, bX.L, bY.L, bZ.L, bW.L)
    infix fun and_(b: Vec4t<out Number>) = and(this, this, b.x.L, b.y.L, b.z.L, b.w.L)

    fun and(b: Number, res: Vec4ul) = and(res, this, b.L, b.L, b.L, b.L)
    fun and(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4ul) = and(res, this, bX.L, bY.L, bZ.L, bW.L)
    fun and(b: Vec4t<out Number>, res: Vec4ul) = and(res, this, b.x.L, b.y.L, b.z.L, b.w.L)


    infix fun or(b: Number) = or(Vec4ul(), this, b.L, b.L, b.L, b.L)
    fun or(bX: Number, bY: Number, bZ: Number, bW: Number) = or(Vec4ul(), this, bX.L, bY.L, bZ.L, bW.L)
    fun or(b: Vec4t<out Number>) = or(Vec4ul(), this, b.x.L, b.y.L, b.z.L, b.w.L)

    infix fun or_(b: Number) = or(this, this, b.L, b.L, b.L, b.L)
    fun or_(bX: Number, bY: Number, bZ: Number, bW: Number) = or(this, this, bX.L, bY.L, bZ.L, bW.L)
    infix fun or_(b: Vec4t<out Number>) = or(this, this, b.x.L, b.y.L, b.z.L, b.w.L)

    fun or(b: Number, res: Vec4ul) = or(res, this, b.L, b.L, b.L, b.L)
    fun or(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4ul) = or(res, this, bX.L, bY.L, bZ.L, bW.L)
    fun or(b: Vec4t<out Number>, res: Vec4ul) = or(res, this, b.x.L, b.y.L, b.z.L, b.w.L)


    infix fun xor(b: Number) = xor(Vec4ul(), this, b.L, b.L, b.L, b.L)
    fun xor(bX: Number, bY: Number, bZ: Number, bW: Number) = xor(Vec4ul(), this, bX.L, bY.L, bZ.L, bW.L)
    fun xor(b: Vec4t<out Number>) = xor(Vec4ul(), this, b.x.L, b.y.L, b.z.L, b.w.L)

    infix fun xor_(b: Number) = xor(this, this, b.L, b.L, b.L, b.L)
    fun xor_(bX: Number, bY: Number, bZ: Number, bW: Number) = xor(this, this, bX.L, bY.L, bZ.L, bW.L)
    infix fun xor_(b: Vec4t<out Number>) = xor(this, this, b.x.L, b.y.L, b.z.L, b.w.L)

    fun xor(b: Number, res: Vec4ul) = xor(res, this, b.L, b.L, b.L, b.L)
    fun xor(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4ul) = xor(res, this, bX.L, bY.L, bZ.L, bW.L)
    fun xor(b: Vec4t<out Number>, res: Vec4ul) = xor(res, this, b.x.L, b.y.L, b.z.L, b.w.L)


    infix fun shl(b: Number) = shl(Vec4ul(), this, b.L, b.L, b.L, b.L)
    fun shl(bX: Number, bY: Number, bZ: Number, bW: Number) = shl(Vec4ul(), this, bX.L, bY.L, bZ.L, bW.L)

    infix fun shl_(b: Number) = shl(this, this, b.L, b.L, b.L, b.L)
    fun shl_(bX: Number, bY: Number, bZ: Number, bW: Number) = shl(this, this, bX.L, bY.L, bZ.L, bW.L)

    fun shl(b: Number, res: Vec4ul) = shl(res, this, b.L, b.L, b.L, b.L)
    fun shl(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4ul) = shl(res, this, bX.L, bY.L, bZ.L, bW.L)


    infix fun shr(b: Number) = shr(Vec4ul(), this, b.L, b.L, b.L, b.L)
    fun shr(bX: Number, bY: Number, bZ: Number, bW: Number) = shr(Vec4ul(), this, bX.L, bY.L, bZ.L, bW.L)

    infix fun shr_(b: Number) = shr(this, this, b.L, b.L, b.L, b.L)
    fun shr_(bX: Number, bY: Number, bZ: Number, bW: Number) = shr(this, this, bX.L, bY.L, bZ.L, bW.L)

    fun shr(b: Number, res: Vec4ul) = shr(res, this, b.L, b.L, b.L, b.L)
    fun shr(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4ul) = shr(res, this, bX.L, bY.L, bZ.L, bW.L)


    override fun equals(other: Any?) =
            if (other is Vec4ul)
                this[0] == other[0] && this[1] == other[1] && this[2] == other[2] && this[3] == other[3]
            else false
}