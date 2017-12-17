package glm_.vec3

import glm_.*
import glm_.vec2.Vec2bool
import glm_.vec2.Vec2t
import glm_.vec3.operators.vec3ul_operators
import glm_.vec4.Vec4bool
import glm_.vec4.Vec4t
import unsigned.Ulong
import java.nio.*

/**
 * Created by elect on 09/10/16.
 */

class Vec3ul(x: Ulong, y: Ulong, z: Ulong) : Vec3t<Ulong>(x, y, z) {

    // -- Explicit basic, conversion other main.and conversion vector constructors --

    constructor() : this(0)

    constructor(v: Vec2t<out Number>) : this(v.x, v.y, 0)
    constructor(v: Vec2t<out Number>, z: Number) : this(v.x, v.y, z)
    constructor(x: Number, v: Vec2t<out Number>) : this(x, v.x, v.y)
    constructor(v: Vec3t<out Number>) : this(v.x, v.y, v.z)
    constructor(v: Vec4t<out Number>) : this(v.x, v.y, v.z)

    constructor(v: Vec2bool) : this(v.x.ul, v.y.ul, 0)
    constructor(v: Vec3bool) : this(v.x.ul, v.y.ul, v.z.ul)
    constructor(v: Vec4bool) : this(v.x.ul, v.y.ul, v.z.ul)

    constructor(bytes: ByteArray, index: Int = 0, oneByteOneUlong: Boolean = false, bigEndian: Boolean = true) : this(
            if (oneByteOneUlong) bytes[index].ul else bytes.getUlong(index, bigEndian),
            if (oneByteOneUlong) bytes[index + 1].ul else bytes.getUlong(index + Ulong.BYTES, bigEndian),
            if (oneByteOneUlong) bytes[index + 2].ul else bytes.getUlong(index + Ulong.BYTES * 2, bigEndian))

    constructor(chars: CharArray, index: Int = 0) : this(chars[index].ul, chars[index + 1].ul, chars[index + 2].ul)
    constructor(shorts: ShortArray, index: Int = 0) : this(shorts[index], shorts[index + 1], shorts[index + 2])
    constructor(ints: IntArray, index: Int = 0) : this(ints[index], ints[index + 1], ints[index + 2])
    constructor(longs: LongArray, index: Int = 0) : this(longs[index], longs[index + 1], longs[index + 2])
    constructor(floats: FloatArray, index: Int = 0) : this(floats[index], floats[index + 1], floats[index + 2])
    constructor(doubles: DoubleArray, index: Int = 0) : this(doubles[index], doubles[index + 1], doubles[index + 2])
    constructor(booleans: BooleanArray, index: Int = 0) : this(booleans[index].ul, booleans[index + 1].ul, booleans[index + 2].ul)

    constructor(numbers: Array<out Number>, index: Int = 0) : this(numbers[index], numbers[index + 1], numbers[index + 2])
    constructor(chars: Array<Char>, index: Int = 0) : this(chars[index].ul, chars[index + 1].ul, chars[index + 2].ul)
    constructor(booleans: Array<Boolean>, index: Int = 0) : this(booleans[index].ul, booleans[index + 1].ul, booleans[index + 2].ul)

    constructor(list: Iterable<*>, index: Int = 0) : this(list.elementAt(index)!!.toLong, list.elementAt(index + 1)!!.toLong,
            list.elementAt(index + 2)!!.toLong)

    constructor(bytes: ByteBuffer, index: Int = bytes.position(), oneByteOneUlong: Boolean = false) : this(
            if (oneByteOneUlong) bytes[index].ul else bytes.getLong(index).ul,
            if (oneByteOneUlong) bytes[index + 1].ul else bytes.getLong(index + Ulong.BYTES).ul,
            if (oneByteOneUlong) bytes[index + 2].ul else bytes.getLong(index + Ulong.BYTES * 2).ul)

    constructor(chars: CharBuffer, index: Int = chars.position()) : this(chars[index].ul, chars[index + 1].ul, chars[index + 2].ul)
    constructor(shorts: ShortBuffer, index: Int = shorts.position()) : this(shorts[index], shorts[index + 1], shorts[index + 2])
    constructor(ints: IntBuffer, index: Int = ints.position()) : this(ints[index], ints[index + 1], ints[index + 2])
    constructor(longs: LongBuffer, index: Int = longs.position()) : this(longs[index], longs[index + 1], longs[index + 2])
    constructor(floats: FloatBuffer, index: Int = floats.position()) : this(floats[index], floats[index + 1], floats[index + 2])
    constructor(doubles: DoubleBuffer, index: Int = doubles.position()) : this(doubles[index], doubles[index + 1], doubles[index + 2])

    constructor(block: (Int) -> Ulong) : this(block(0), block(1), block(2))

    constructor(s: Number) : this(s, s, s)
    constructor(x: Number, y: Number, z: Number) : this(x.ul, y.ul, z.ul)


    fun set(bytes: ByteArray, index: Int = 0, oneByteOneUlong: Boolean = false, bigEndian: Boolean = true) {
        x.v = if (oneByteOneUlong) bytes[index].L else bytes.getLong(index, bigEndian)
        y.v = if (oneByteOneUlong) bytes[index + 1].L else bytes.getLong(index + Ulong.BYTES, bigEndian)
        z.v = if (oneByteOneUlong) bytes[index + 2].L else bytes.getLong(index + Ulong.BYTES * 2, bigEndian)
    }

    fun set(bytes: ByteBuffer, index: Int = bytes.position(), oneByteOneUlong: Boolean = false) {
        x.v = if (oneByteOneUlong) bytes[index].L else bytes.getLong(index)
        y.v = if (oneByteOneUlong) bytes[index + 1].L else bytes.getLong(index + Ulong.BYTES)
        z.v = if (oneByteOneUlong) bytes[index + 2].L else bytes.getLong(index + Ulong.BYTES * 2)
    }


    override fun put(x: Number, y: Number, z: Number): Vec3ul {
        this.x = x.ul
        this.y = y.ul
        this.z = z.ul
        return this
    }


    infix fun to(longs: LongArray) = to(longs, 0)
    fun to(longs: LongArray, index: Int): LongArray {
        longs[index] = x.v
        longs[index + 1] = y.v
        longs[index + 2] = z.v
        return longs
    }

    infix fun to(longs: LongBuffer) = to(longs, 0)
    fun to(longs: LongBuffer, index: Int): LongBuffer {
        longs[index] = x.v
        longs[index + 1] = y.v
        longs[index + 2] = z.v
        return longs
    }

    infix fun to(bytes: ByteBuffer) = to(bytes, bytes.position())
    fun to(bytes: ByteBuffer, offset: Int): ByteBuffer {
        bytes.putLong(offset, x.v)
        bytes.putLong(offset + Long.BYTES, y.v)
        bytes.putLong(offset + Long.BYTES * 2, z.v)
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
        0 -> x = s.ul
        1 -> y = s.ul
        2 -> y = s.ul
        else -> throw ArrayIndexOutOfBoundsException()
    }


    companion object : vec3ul_operators() {
        @JvmField
        val length = 3
        @JvmField
        val size = length * Ulong.BYTES
    }


    // -- Unary arithmetic operators --

    operator fun unaryPlus() = this

    // no unaryMinus operator, only signed

    // -- Increment main.and decrement operators --

    operator fun inc(res: Vec3ul = Vec3ul()) = plus(res, this, 1, 1, 1)
    fun incAssign() = plus(this, this, 1, 1, 1)


    operator fun dec(res: Vec3ul = Vec3ul()) = minus(res, this, 1, 1, 1)
    fun decAssign() = minus(this, this, 1, 1, 1)


    // -- Specific binary arithmetic operators --

    operator fun plus(b: Ulong) = plus(Vec3ul(), this, b, b, b)
    operator fun plus(b: Long) = plus(Vec3ul(), this, b, b, b)
    operator fun plus(b: Vec3ul) = plus(Vec3ul(), this, b.x, b.y, b.z)

    fun plus(bX: Ulong, bY: Ulong, bZ: Ulong, res: Vec3ul = Vec3ul()) = plus(res, this, bX, bY, bZ)
    fun plus(bX: Long, bY: Long, bZ: Long, res: Vec3ul = Vec3ul()) = plus(res, this, bX, bY, bZ)
    fun plus(b: Ulong, res: Vec3ul = Vec3ul()) = plus(res, this, b, b, b)
    fun plus(b: Long, res: Vec3ul = Vec3ul()) = plus(res, this, b, b, b)
    fun plus(b: Vec3ul, res: Vec3ul = Vec3ul()) = plus(res, this, b.x, b.y, b.z)

    fun plusAssign(bX: Ulong, bY: Ulong, bZ: Ulong) = plus(this, this, bX, bY, bZ)
    fun plusAssign(bX: Long, bY: Long, bZ: Long) = plus(this, this, bX, bY, bZ)
    infix operator fun plusAssign(b: Ulong) {
        plus(this, this, b, b, b)
    }
    infix operator fun plusAssign(b: Long) {
        plus(this, this, b, b, b)
    }
    infix operator fun plusAssign(b: Vec3ul) {
        plus(this, this, b.x, b.y, b.z)
    }


    operator fun minus(b: Ulong) = minus(Vec3ul(), this, b, b, b)
    operator fun minus(b: Long) = minus(Vec3ul(), this, b, b, b)
    operator fun minus(b: Vec3ul) = minus(Vec3ul(), this, b.x, b.y, b.z)

    fun minus(bX: Ulong, bY: Ulong, bZ: Ulong, res: Vec3ul = Vec3ul()) = minus(res, this, bX, bY, bZ)
    fun minus(bX: Long, bY: Long, bZ: Long, res: Vec3ul = Vec3ul()) = minus(res, this, bX, bY, bZ)
    fun minus(b: Ulong, res: Vec3ul = Vec3ul()) = minus(res, this, b, b, b)
    fun minus(b: Long, res: Vec3ul = Vec3ul()) = minus(res, this, b, b, b)
    fun minus(b: Vec3ul, res: Vec3ul = Vec3ul()) = minus(res, this, b.x, b.y, b.z)

    fun minusAssign(bX: Ulong, bY: Ulong, bZ: Ulong) = minus(this, this, bX, bY, bZ)
    fun minusAssign(bX: Long, bY: Long, bZ: Long) = minus(this, this, bX, bY, bZ)
    infix operator fun minusAssign(b: Ulong) {
        minus(this, this, b, b, b)
    }
    infix operator fun minusAssign(b: Long) {
        minus(this, this, b, b, b)
    }
    infix operator fun minusAssign(b: Vec3ul) {
        minus(this, this, b.x, b.y, b.z)
    }


    operator fun times(b: Ulong) = times(Vec3ul(), this, b, b, b)
    operator fun times(b: Long) = times(Vec3ul(), this, b, b, b)
    operator fun times(b: Vec3ul) = times(Vec3ul(), this, b.x, b.y, b.z)

    fun times(bX: Ulong, bY: Ulong, bZ: Ulong, res: Vec3ul = Vec3ul()) = times(res, this, bX, bY, bZ)
    fun times(bX: Long, bY: Long, bZ: Long, res: Vec3ul = Vec3ul()) = times(res, this, bX, bY, bZ)
    fun times(b: Ulong, res: Vec3ul = Vec3ul()) = times(res, this, b, b, b)
    fun times(b: Long, res: Vec3ul = Vec3ul()) = times(res, this, b, b, b)
    fun times(b: Vec3ul, res: Vec3ul = Vec3ul()) = times(res, this, b.x, b.y, b.z)

    fun timesAssign(bX: Ulong, bY: Ulong, bZ: Ulong) = times(this, this, bX, bY, bZ)
    fun timesAssign(bX: Long, bY: Long, bZ: Long) = times(this, this, bX, bY, bZ)
    infix operator fun timesAssign(b: Ulong) {
        times(this, this, b, b, b)
    }
    infix operator fun timesAssign(b: Long) {
        times(this, this, b, b, b)
    }
    infix operator fun timesAssign(b: Vec3ul) {
        times(this, this, b.x, b.y, b.z)
    }


    operator fun div(b: Ulong) = div(Vec3ul(), this, b, b, b)
    operator fun div(b: Long) = div(Vec3ul(), this, b, b, b)
    operator fun div(b: Vec3ul) = div(Vec3ul(), this, b.x, b.y, b.z)

    fun div(bX: Ulong, bY: Ulong, bZ: Ulong, res: Vec3ul = Vec3ul()) = div(res, this, bX, bY, bZ)
    fun div(bX: Long, bY: Long, bZ: Long, res: Vec3ul = Vec3ul()) = div(res, this, bX, bY, bZ)
    fun div(b: Ulong, res: Vec3ul = Vec3ul()) = div(res, this, b, b, b)
    fun div(b: Long, res: Vec3ul = Vec3ul()) = div(res, this, b, b, b)
    fun div(b: Vec3ul, res: Vec3ul = Vec3ul()) = div(res, this, b.x, b.y, b.z)

    fun divAssign(bX: Ulong, bY: Ulong, bZ: Ulong) = div(this, this, bX, bY, bZ)
    fun divAssign(bX: Long, bY: Long, bZ: Long) = div(this, this, bX, bY, bZ)
    infix operator fun divAssign(b: Ulong) {
        div(this, this, b, b, b)
    }
    infix operator fun divAssign(b: Long) {
        div(this, this, b, b, b)
    }
    infix operator fun divAssign(b: Vec3ul) {
        div(this, this, b.x, b.y, b.z)
    }


    operator fun rem(b: Ulong) = rem(Vec3ul(), this, b, b, b)
    operator fun rem(b: Long) = rem(Vec3ul(), this, b, b, b)
    operator fun rem(b: Vec3ul) = rem(Vec3ul(), this, b.x, b.y, b.z)

    fun rem(bX: Ulong, bY: Ulong, bZ: Ulong, res: Vec3ul = Vec3ul()) = rem(res, this, bX, bY, bZ)
    fun rem(bX: Long, bY: Long, bZ: Long, res: Vec3ul = Vec3ul()) = rem(res, this, bX, bY, bZ)
    fun rem(b: Ulong, res: Vec3ul = Vec3ul()) = rem(res, this, b, b, b)
    fun rem(b: Long, res: Vec3ul = Vec3ul()) = rem(res, this, b, b, b)
    fun rem(b: Vec3ul, res: Vec3ul = Vec3ul()) = rem(res, this, b.x, b.y, b.z)

    fun remAssign(bX: Ulong, bY: Ulong, bZ: Ulong) = rem(this, this, bX, bY, bZ)
    fun remAssign(bX: Long, bY: Long, bZ: Long) = rem(this, this, bX, bY, bZ)
    infix operator fun remAssign(b: Ulong) {
        rem(this, this, b, b, b)
    }
    infix operator fun remAssign(b: Long) {
        rem(this, this, b, b, b)
    }
    infix operator fun remAssign(b: Vec3ul) {
        rem(this, this, b.x, b.y, b.z)
    }


    // -- Generic binary arithmetic operators --

    operator fun plus(b: Number) = plus(Vec3ul(), this, b.L, b.L, b.L)
    operator fun plus(b: Vec3t<out Number>) = plus(Vec3ul(), this, b.x.L, b.y.L, b.z.L)

    fun plus(bX: Number, bY: Number, bZ: Number, res: Vec3ul = Vec3ul()) = plus(res, this, bX.L, bY.L, bZ.L)
    fun plus(b: Number, res: Vec3ul = Vec3ul()) = plus(res, this, b.L, b.L, b.L)
    fun plus(b: Vec3t<out Number>, res: Vec3ul = Vec3ul()) = plus(res, this, b.x.L, b.y.L, b.z.L)

    fun plusAssign(bX: Number, bY: Number, bZ: Number) = plus(this, this, bX.L, bY.L, bZ.L)
    infix operator fun plusAssign(b: Number) {
        plus(this, this, b.L, b.L, b.L)
    }
    infix operator fun plusAssign(b: Vec3t<out Number>) {
        plus(this, this, b.x.L, b.y.L, b.z.L)
    }


    operator fun minus(b: Number) = minus(Vec3ul(), this, b.L, b.L, b.L)
    operator fun minus(b: Vec3t<out Number>) = minus(Vec3ul(), this, b.x.L, b.y.L, b.z.L)

    fun minus(bX: Number, bY: Number, bZ: Number, res: Vec3ul = Vec3ul()) = minus(res, this, bX.L, bY.L, bZ.L)
    fun minus(b: Number, res: Vec3ul = Vec3ul()) = minus(res, this, b.L, b.L, b.L)
    fun minus(b: Vec3t<out Number>, res: Vec3ul = Vec3ul()) = minus(res, this, b.x.L, b.y.L, b.z.L)

    fun minusAssign(bX: Number, bY: Number, bZ: Number) = minus(this, this, bX.L, bY.L, bZ.L)
    infix operator fun minusAssign(b: Number) {
        minus(this, this, b.L, b.L, b.L)
    }
    infix operator fun minusAssign(b: Vec3t<out Number>) {
        minus(this, this, b.x.L, b.y.L, b.z.L)
    }


    operator fun times(b: Number) = times(Vec3ul(), this, b.L, b.L, b.L)
    operator fun times(b: Vec3t<out Number>) = times(Vec3ul(), this, b.x.L, b.y.L, b.z.L)

    fun times(bX: Number, bY: Number, bZ: Number, res: Vec3ul = Vec3ul()) = times(res, this, bX.L, bY.L, bZ.L)
    fun times(b: Number, res: Vec3ul = Vec3ul()) = times(res, this, b.L, b.L, b.L)
    fun times(b: Vec3t<out Number>, res: Vec3ul = Vec3ul()) = times(res, this, b.x.L, b.y.L, b.z.L)

    fun timesAssign(bX: Number, bY: Number, bZ: Number) = times(this, this, bX.L, bY.L, bZ.L)
    infix operator fun timesAssign(b: Number) {
        times(this, this, b.L, b.L, b.L)
    }
    infix operator fun timesAssign(b: Vec3t<out Number>) {
        times(this, this, b.x.L, b.y.L, b.z.L)
    }


    operator fun div(b: Number) = div(Vec3ul(), this, b.L, b.L, b.L)
    operator fun div(b: Vec3t<out Number>) = div(Vec3ul(), this, b.x.L, b.y.L, b.z.L)

    fun div(bX: Number, bY: Number, bZ: Number, res: Vec3ul = Vec3ul()) = div(res, this, bX.L, bY.L, bZ.L)
    fun div(b: Number, res: Vec3ul = Vec3ul()) = div(res, this, b.L, b.L, b.L)
    fun div(b: Vec3t<out Number>, res: Vec3ul = Vec3ul()) = div(res, this, b.x.L, b.y.L, b.z.L)

    fun divAssign(bX: Number, bY: Number, bZ: Number) = div(this, this, bX.L, bY.L, bZ.L)
    infix operator fun divAssign(b: Number) {
        div(this, this, b.L, b.L, b.L)
    }
    infix operator fun divAssign(b: Vec3t<out Number>) {
        div(this, this, b.x.L, b.y.L, b.z.L)
    }


    operator fun rem(b: Number) = rem(Vec3ul(), this, b.L, b.L, b.L)
    operator fun rem(b: Vec3t<out Number>) = rem(Vec3ul(), this, b.x.L, b.y.L, b.z.L)

    fun rem(bX: Number, bY: Number, bZ: Number, res: Vec3ul = Vec3ul()) = rem(res, this, bX.L, bY.L, bZ.L)
    fun rem(b: Number, res: Vec3ul = Vec3ul()) = rem(res, this, b.L, b.L, b.L)
    fun rem(b: Vec3t<out Number>, res: Vec3ul = Vec3ul()) = rem(res, this, b.x.L, b.y.L, b.z.L)

    fun remAssign(bX: Number, bY: Number, bZ: Number) = rem(this, this, bX.L, bY.L, bZ.L)
    infix operator fun remAssign(b: Number) {
        rem(this, this, b.L, b.L, b.L)
    }
    infix operator fun remAssign(b: Vec3t<out Number>) {
        rem(this, this, b.x.L, b.y.L, b.z.L)
    }


    // -- Specific bitwise operators --

    infix fun and(b: Ulong) = and(Vec3ul(), this, b, b, b)
    infix fun and(b: Long) = and(Vec3ul(), this, b, b, b)
    fun and(bX: Ulong, bY: Ulong, bZ: Ulong) = and(Vec3ul(), this, bX, bY, bZ)
    fun and(bX: Long, bY: Long, bZ: Long) = and(Vec3ul(), this, bX, bY, bZ)
    fun and(b: Vec3ul) = and(Vec3ul(), this, b.x, b.y, b.z)

    infix fun andAssign(b: Ulong) = and(this, this, b, b, b)
    infix fun andAssign(b: Long) = and(this, this, b, b, b)
    fun andAssign(bX: Ulong, bY: Ulong, bZ: Ulong) = and(this, this, bX, bY, bZ)
    fun andAssign(bX: Long, bY: Long, bZ: Long) = and(this, this, bX, bY, bZ)
    infix fun andAssign(b: Vec3ul) = and(this, this, b.x, b.y, b.z)

    fun and(b: Ulong, res: Vec3ul) = and(res, this, b, b, b)
    fun and(b: Long, res: Vec3ul) = and(res, this, b, b, b)
    fun and(bX: Ulong, bY: Ulong, bZ: Ulong, res: Vec3ul) = and(res, this, bX, bY, bZ)
    fun and(bX: Long, bY: Long, bZ: Long, res: Vec3ul) = and(res, this, bX, bY, bZ)
    fun and(b: Vec3ul, res: Vec3ul) = and(res, this, b.x, b.y, b.z)


    infix fun or(b: Ulong) = or(Vec3ul(), this, b, b, b)
    infix fun or(b: Long) = or(Vec3ul(), this, b, b, b)
    fun or(bX: Ulong, bY: Ulong, bZ: Ulong) = or(Vec3ul(), this, bX, bY, bZ)
    fun or(bX: Long, bY: Long, bZ: Long) = or(Vec3ul(), this, bX, bY, bZ)
    fun or(b: Vec3ul) = or(Vec3ul(), this, b.x, b.y, b.z)

    infix fun orAssign(b: Ulong) = or(this, this, b, b, b)
    infix fun orAssign(b: Long) = or(this, this, b, b, b)
    fun orAssign(bX: Ulong, bY: Ulong, bZ: Ulong) = or(this, this, bX, bY, bZ)
    fun orAssign(bX: Long, bY: Long, bZ: Long) = or(this, this, bX, bY, bZ)
    infix fun orAssign(b: Vec3ul) = or(this, this, b.x, b.y, b.z)

    fun or(b: Ulong, res: Vec3ul) = or(res, this, b, b, b)
    fun or(b: Long, res: Vec3ul) = or(res, this, b, b, b)
    fun or(bX: Ulong, bY: Ulong, bZ: Ulong, res: Vec3ul) = or(res, this, bX, bY, bZ)
    fun or(bX: Long, bY: Long, bZ: Long, res: Vec3ul) = or(res, this, bX, bY, bZ)
    fun or(b: Vec3ul, res: Vec3ul) = or(res, this, b.x, b.y, b.z)


    infix fun xor(b: Ulong) = xor(Vec3ul(), this, b, b, b)
    infix fun xor(b: Long) = xor(Vec3ul(), this, b, b, b)
    fun xor(bX: Ulong, bY: Ulong, bZ: Ulong) = xor(Vec3ul(), this, bX, bY, bZ)
    fun xor(bX: Long, bY: Long, bZ: Long) = xor(Vec3ul(), this, bX, bY, bZ)
    fun xor(b: Vec3ul) = xor(Vec3ul(), this, b.x, b.y, b.z)

    infix fun xorAssign(b: Ulong) = xor(this, this, b, b, b)
    infix fun xorAssign(b: Long) = xor(this, this, b, b, b)
    fun xorAssign(bX: Ulong, bY: Ulong, bZ: Ulong) = xor(this, this, bX, bY, bZ)
    fun xorAssign(bX: Long, bY: Long, bZ: Long) = xor(this, this, bX, bY, bZ)
    infix fun xorAssign(b: Vec3ul) = xor(this, this, b.x, b.y, b.z)

    fun xor(b: Ulong, res: Vec3ul) = xor(res, this, b, b, b)
    fun xor(b: Long, res: Vec3ul) = xor(res, this, b, b, b)
    fun xor(bX: Ulong, bY: Ulong, bZ: Ulong, res: Vec3ul) = xor(res, this, bX, bY, bZ)
    fun xor(bX: Long, bY: Long, bZ: Long, res: Vec3ul) = xor(res, this, bX, bY, bZ)
    fun xor(b: Vec3ul, res: Vec3ul) = xor(res, this, b.x, b.y, b.z)


    infix fun shl(b: Int) = shl(Vec3ul(), this, b, b, b)
    fun shl(bX: Int, bY: Int, bZ: Int) = shl(Vec3ul(), this, bX, bY, bZ)

    infix fun shlAssign(b: Int) = shl(this, this, b, b, b)
    fun shlAssign(bX: Int, bY: Int, bZ: Int) = shl(this, this, bX, bY, bZ)

    fun shl(b: Int, res: Vec3ul) = shl(res, this, b, b, b)
    fun shl(bX: Int, bY: Int, bZ: Int, res: Vec3ul) = shl(res, this, bX, bY, bZ)


    infix fun shr(b: Int) = shr(Vec3ul(), this, b, b, b)
    fun shr(bX: Int, bY: Int, bZ: Int) = shr(Vec3ul(), this, bX, bY, bZ)

    infix fun shrAssign(b: Int) = shr(this, this, b, b, b)
    fun shrAssign(bX: Int, bY: Int, bZ: Int) = shr(this, this, bX, bY, bZ)

    fun shr(b: Int, res: Vec3ul) = shr(res, this, b, b, b)
    fun shr(bX: Int, bY: Int, bZ: Int, res: Vec3ul) = shr(res, this, bX, bY, bZ)


    fun inv(res: Vec3ul = Vec3ul()) = inv(res, this)
    fun invAssign() = inv(this, this)


    // -- Generic bitwise operators --

    infix fun and(b: Number) = and(Vec3ul(), this, b.L, b.L, b.L)
    fun and(bX: Number, bY: Number, bZ: Number) = and(Vec3ul(), this, bX.L, bY.L, bZ.L)
    fun and(b: Vec3t<out Number>) = and(Vec3ul(), this, b.x.L, b.y.L, b.z.L)

    infix fun andAssign(b: Number) = and(this, this, b.L, b.L, b.L)
    fun andAssign(bX: Number, bY: Number, bZ: Number) = and(this, this, bX.L, bY.L, bZ.L)
    infix fun andAssign(b: Vec3t<out Number>) = and(this, this, b.x.L, b.y.L, b.z.L)

    fun and(b: Number, res: Vec3ul) = and(res, this, b.L, b.L, b.L)
    fun and(bX: Number, bY: Number, bZ: Number, res: Vec3ul) = and(res, this, bX.L, bY.L, bZ.L)
    fun and(b: Vec3t<out Number>, res: Vec3ul) = and(res, this, b.x.L, b.y.L, b.z.L)


    infix fun or(b: Number) = or(Vec3ul(), this, b.L, b.L, b.L)
    fun or(bX: Number, bY: Number, bZ: Number) = or(Vec3ul(), this, bX.L, bY.L, bZ.L)
    fun or(b: Vec3t<out Number>) = or(Vec3ul(), this, b.x.L, b.y.L, b.z.L)

    infix fun orAssign(b: Number) = or(this, this, b.L, b.L, b.L)
    fun orAssign(bX: Number, bY: Number, bZ: Number) = or(this, this, bX.L, bY.L, bZ.L)
    infix fun orAssign(b: Vec3t<out Number>) = or(this, this, b.x.L, b.y.L, b.z.L)

    fun or(b: Number, res: Vec3ul) = or(res, this, b.L, b.L, b.L)
    fun or(bX: Number, bY: Number, bZ: Number, res: Vec3ul) = or(res, this, bX.L, bY.L, bZ.L)
    fun or(b: Vec3t<out Number>, res: Vec3ul) = or(res, this, b.x.L, b.y.L, b.z.L)


    infix fun xor(b: Number) = xor(Vec3ul(), this, b.L, b.L, b.L)
    fun xor(bX: Number, bY: Number, bZ: Number) = xor(Vec3ul(), this, bX.L, bY.L, bZ.L)
    fun xor(b: Vec3t<out Number>) = xor(Vec3ul(), this, b.x.L, b.y.L, b.z.L)

    infix fun xorAssign(b: Number) = xor(this, this, b.L, b.L, b.L)
    fun xorAssign(bX: Number, bY: Number, bZ: Number) = xor(this, this, bX.L, bY.L, bZ.L)
    infix fun xorAssign(b: Vec3t<out Number>) = xor(this, this, b.x.L, b.y.L, b.z.L)

    fun xor(b: Number, res: Vec3ul) = xor(res, this, b.L, b.L, b.L)
    fun xor(bX: Number, bY: Number, bZ: Number, res: Vec3ul) = xor(res, this, bX.L, bY.L, bZ.L)
    fun xor(b: Vec3t<out Number>, res: Vec3ul) = xor(res, this, b.x.L, b.y.L, b.z.L)


    infix fun shl(b: Number) = shl(Vec3ul(), this, b.L, b.L, b.L)
    fun shl(bX: Number, bY: Number, bZ: Number) = shl(Vec3ul(), this, bX.L, bY.L, bZ.L)

    infix fun shlAssign(b: Number) = shl(this, this, b.L, b.L, b.L)
    fun shlAssign(bX: Number, bY: Number, bZ: Number) = shl(this, this, bX.L, bY.L, bZ.L)

    fun shl(b: Number, res: Vec3ul) = shl(res, this, b.L, b.L, b.L)
    fun shl(bX: Number, bY: Number, bZ: Number, res: Vec3ul) = shl(res, this, bX.L, bY.L, bZ.L)


    infix fun shr(b: Number) = shr(Vec3ul(), this, b.L, b.L, b.L)
    fun shr(bX: Number, bY: Number, bZ: Number) = shr(Vec3ul(), this, bX.L, bY.L, bZ.L)

    infix fun shrAssign(b: Number) = shr(this, this, b.L, b.L, b.L)
    fun shrAssign(bX: Number, bY: Number, bZ: Number) = shr(this, this, bX.L, bY.L, bZ.L)

    fun shr(b: Number, res: Vec3ul) = shr(res, this, b.L, b.L, b.L)
    fun shr(bX: Number, bY: Number, bZ: Number, res: Vec3ul) = shr(res, this, bX.L, bY.L, bZ.L)


    override fun equals(other: Any?) = other is Vec3ul && this[0] == other[0] && this[1] == other[1] && this[2] == other[2]
    override fun hashCode() = 31 * (31 * x.v.hashCode() + y.v.hashCode()) + z.v.hashCode()
}