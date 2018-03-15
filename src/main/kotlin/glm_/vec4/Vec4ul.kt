package glm_.vec4

import glm_.*
import glm_.vec2.Vec2bool
import glm_.vec2.Vec2t
import glm_.vec3.Vec3bool
import glm_.vec3.Vec3t
import glm_.vec4.operators.vec4ul_operators
import unsigned.Ulong
import java.nio.*

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

    constructor(bytes: ByteArray, index: Int = 0, oneByteOneUlong: Boolean = false, bigEndian: Boolean = true) : this(
            if (oneByteOneUlong) bytes[index].ul else bytes.getUlong(index, bigEndian),
            if (oneByteOneUlong) bytes[index + 1].ul else bytes.getUlong(index + Ulong.BYTES, bigEndian),
            if (oneByteOneUlong) bytes[index + 2].ul else bytes.getUlong(index + Ulong.BYTES * 2, bigEndian),
            if (oneByteOneUlong) bytes[index + 3].ul else bytes.getUlong(index + Ulong.BYTES * 3, bigEndian))

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

    constructor(list: Iterable<*>, index: Int = 0) : this(list.elementAt(index)!!.toLong, list.elementAt(index + 1)!!.toLong,
            list.elementAt(index + 2)!!.toLong, list.elementAt(index + 3)!!.toLong)

    constructor(bytes: ByteBuffer, index: Int = bytes.position(), oneByteOneUlong: Boolean = false) : this(
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

    constructor(block: (Int) -> Ulong) : this(block(0), block(1), block(2), block(3))

    constructor(s: Number) : this(s, s, s, s)
    constructor(x: Number, y: Number, z: Number, w: Number) : this(x.ul, y.ul, z.ul, w.ul)


    fun set(bytes: ByteArray, index: Int = 0, oneByteOneUlong: Boolean = false, bigEndian: Boolean = true) {
        x.v = if (oneByteOneUlong) bytes[index].L else bytes.getLong(index, bigEndian)
        y.v = if (oneByteOneUlong) bytes[index + 1].L else bytes.getLong(index + Ulong.BYTES, bigEndian)
        z.v = if (oneByteOneUlong) bytes[index + 2].L else bytes.getLong(index + Ulong.BYTES * 2, bigEndian)
        w.v = if (oneByteOneUlong) bytes[index + 3].L else bytes.getLong(index + Ulong.BYTES * 3, bigEndian)
    }

    fun set(bytes: ByteBuffer, index: Int = bytes.position(), oneByteOneUlong: Boolean = false) {
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


    infix fun to(longs: LongArray) = to(longs, 0)
    fun to(longs: LongArray, index: Int): LongArray {
        longs[index] = x.v
        longs[index + 1] = y.v
        longs[index + 2] = z.v
        longs[index + 3] = w.v
        return longs
    }

    infix fun to(longs: LongBuffer) = to(longs, 0)
    fun to(longs: LongBuffer, index: Int): LongBuffer {
        longs[index] = x.v
        longs[index + 1] = y.v
        longs[index + 2] = z.v
        longs[index + 3] = w.v
        return longs
    }

    override infix fun to(bytes: ByteBuffer) = to(bytes, bytes.position())
    override fun to(bytes: ByteBuffer, index: Int): ByteBuffer {
        bytes.putLong(index, x.v)
        bytes.putLong(index + Long.BYTES, y.v)
        bytes.putLong(index + Long.BYTES * 2, z.v)
        bytes.putLong(index + Long.BYTES * 3, w.v)
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
        0 -> x = s.ul
        1 -> y = s.ul
        2 -> y = s.ul
        3 -> w = s.ul
        else -> throw ArrayIndexOutOfBoundsException()
    }

    override fun size() = size


    companion object : vec4ul_operators() {
        @JvmField
        val length = 4
        @JvmField
        val size = length * Ulong.BYTES
    }


    // -- Unary arithmetic operators --

    operator fun unaryPlus() = this

    // no unaryMinus operator, only signed

    // -- Increment main.and decrement operators --

    operator fun inc(res: Vec4ul = Vec4ul()) = plus(res, this, 1, 1, 1, 1)
    fun incAssign() = plus(this, this, 1, 1, 1, 1)


    operator fun dec(res: Vec4ul = Vec4ul()) = minus(res, this, 1, 1, 1, 1)
    fun decAssign() = minus(this, this, 1, 1, 1, 1)


    // -- Specific binary arithmetic operators --

    operator fun plus(b: Ulong) = plus(Vec4ul(), this, b, b, b, b)
    operator fun plus(b: Long) = plus(Vec4ul(), this, b, b, b, b)
    operator fun plus(b: Vec4ul) = plus(Vec4ul(), this, b.x, b.y, b.z, b.w)

    fun plus(bX: Ulong, bY: Ulong, bZ: Ulong, bW: Ulong, res: Vec4ul = Vec4ul()) = plus(res, this, bX, bY, bZ, bW)
    fun plus(bX: Long, bY: Long, bZ: Long, bW: Long, res: Vec4ul = Vec4ul()) = plus(res, this, bX, bY, bZ, bW)
    fun plus(b: Ulong, res: Vec4ul = Vec4ul()) = plus(res, this, b, b, b, b)
    fun plus(b: Long, res: Vec4ul = Vec4ul()) = plus(res, this, b, b, b, b)
    fun plus(b: Vec4ul, res: Vec4ul = Vec4ul()) = plus(res, this, b.x, b.y, b.z, b.w)

    fun plusAssign(bX: Ulong, bY: Ulong, bZ: Ulong, bW: Ulong) = plus(this, this, bX, bY, bZ, bW)
    fun plusAssign(bX: Long, bY: Long, bZ: Long, bW: Long) = plus(this, this, bX, bY, bZ, bW)
    infix operator fun plusAssign(b: Ulong) {
        plus(this, this, b, b, b, b)
    }
    infix operator fun plusAssign(b: Long) {
        plus(this, this, b, b, b, b)
    }
    infix operator fun plusAssign(b: Vec4ul) {
        plus(this, this, b.x, b.y, b.z, b.w)
    }


    operator fun minus(b: Ulong) = minus(Vec4ul(), this, b, b, b, b)
    operator fun minus(b: Long) = minus(Vec4ul(), this, b, b, b, b)
    operator fun minus(b: Vec4ul) = minus(Vec4ul(), this, b.x, b.y, b.z, b.w)

    fun minus(bX: Ulong, bY: Ulong, bZ: Ulong, bW: Ulong, res: Vec4ul = Vec4ul()) = minus(res, this, bX, bY, bZ, bW)
    fun minus(bX: Long, bY: Long, bZ: Long, bW: Long, res: Vec4ul = Vec4ul()) = minus(res, this, bX, bY, bZ, bW)
    fun minus(b: Ulong, res: Vec4ul = Vec4ul()) = minus(res, this, b, b, b, b)
    fun minus(b: Long, res: Vec4ul = Vec4ul()) = minus(res, this, b, b, b, b)
    fun minus(b: Vec4ul, res: Vec4ul = Vec4ul()) = minus(res, this, b.x, b.y, b.z, b.w)

    fun minusAssign(bX: Ulong, bY: Ulong, bZ: Ulong, bW: Ulong) = minus(this, this, bX, bY, bZ, bW)
    fun minusAssign(bX: Long, bY: Long, bZ: Long, bW: Long) = minus(this, this, bX, bY, bZ, bW)
    infix operator fun minusAssign(b: Ulong) {
        minus(this, this, b, b, b, b)
    }
    infix operator fun minusAssign(b: Long) {
        minus(this, this, b, b, b, b)
    }
    infix operator fun minusAssign(b: Vec4ul) {
        minus(this, this, b.x, b.y, b.z, b.w)
    }


    operator fun times(b: Ulong) = times(Vec4ul(), this, b, b, b, b)
    operator fun times(b: Long) = times(Vec4ul(), this, b, b, b, b)
    operator fun times(b: Vec4ul) = times(Vec4ul(), this, b.x, b.y, b.z, b.w)

    fun times(bX: Ulong, bY: Ulong, bZ: Ulong, bW: Ulong, res: Vec4ul = Vec4ul()) = times(res, this, bX, bY, bZ, bW)
    fun times(bX: Long, bY: Long, bZ: Long, bW: Long, res: Vec4ul = Vec4ul()) = times(res, this, bX, bY, bZ, bW)
    fun times(b: Ulong, res: Vec4ul = Vec4ul()) = times(res, this, b, b, b, b)
    fun times(b: Long, res: Vec4ul = Vec4ul()) = times(res, this, b, b, b, b)
    fun times(b: Vec4ul, res: Vec4ul = Vec4ul()) = times(res, this, b.x, b.y, b.z, b.w)

    fun timesAssign(bX: Ulong, bY: Ulong, bZ: Ulong, bW: Ulong) = times(this, this, bX, bY, bZ, bW)
    fun timesAssign(bX: Long, bY: Long, bZ: Long, bW: Long) = times(this, this, bX, bY, bZ, bW)
    infix operator fun timesAssign(b: Ulong) {
        times(this, this, b, b, b, b)
    }
    infix operator fun timesAssign(b: Long) {
        times(this, this, b, b, b, b)
    }
    infix operator fun timesAssign(b: Vec4ul) {
        times(this, this, b.x, b.y, b.z, b.w)
    }


    operator fun div(b: Ulong) = div(Vec4ul(), this, b, b, b, b)
    operator fun div(b: Long) = div(Vec4ul(), this, b, b, b, b)
    operator fun div(b: Vec4ul) = div(Vec4ul(), this, b.x, b.y, b.z, b.w)

    fun div(bX: Ulong, bY: Ulong, bZ: Ulong, bW: Ulong, res: Vec4ul = Vec4ul()) = div(res, this, bX, bY, bZ, bW)
    fun div(bX: Long, bY: Long, bZ: Long, bW: Long, res: Vec4ul = Vec4ul()) = div(res, this, bX, bY, bZ, bW)
    fun div(b: Ulong, res: Vec4ul = Vec4ul()) = div(res, this, b, b, b, b)
    fun div(b: Long, res: Vec4ul = Vec4ul()) = div(res, this, b, b, b, b)
    fun div(b: Vec4ul, res: Vec4ul = Vec4ul()) = div(res, this, b.x, b.y, b.z, b.w)

    fun divAssign(bX: Ulong, bY: Ulong, bZ: Ulong, bW: Ulong) = div(this, this, bX, bY, bZ, bW)
    fun divAssign(bX: Long, bY: Long, bZ: Long, bW: Long) = div(this, this, bX, bY, bZ, bW)
    infix operator fun divAssign(b: Ulong) {
        div(this, this, b, b, b, b)
    }
    infix operator fun divAssign(b: Long) {
        div(this, this, b, b, b, b)
    }
    infix operator fun divAssign(b: Vec4ul) {
        div(this, this, b.x, b.y, b.z, b.w)
    }


    operator fun rem(b: Ulong) = rem(Vec4ul(), this, b, b, b, b)
    operator fun rem(b: Long) = rem(Vec4ul(), this, b, b, b, b)
    operator fun rem(b: Vec4ul) = rem(Vec4ul(), this, b.x, b.y, b.z, b.w)

    fun rem(bX: Ulong, bY: Ulong, bZ: Ulong, bW: Ulong, res: Vec4ul = Vec4ul()) = rem(res, this, bX, bY, bZ, bW)
    fun rem(bX: Long, bY: Long, bZ: Long, bW: Long, res: Vec4ul = Vec4ul()) = rem(res, this, bX, bY, bZ, bW)
    fun rem(b: Ulong, res: Vec4ul = Vec4ul()) = rem(res, this, b, b, b, b)
    fun rem(b: Long, res: Vec4ul = Vec4ul()) = rem(res, this, b, b, b, b)
    fun rem(b: Vec4ul, res: Vec4ul = Vec4ul()) = rem(res, this, b.x, b.y, b.z, b.w)

    fun remAssign(bX: Ulong, bY: Ulong, bZ: Ulong, bW: Ulong) = rem(this, this, bX, bY, bZ, bW)
    fun remAssign(bX: Long, bY: Long, bZ: Long, bW: Long) = rem(this, this, bX, bY, bZ, bW)
    infix operator fun remAssign(b: Ulong) {
        rem(this, this, b, b, b, b)
    }
    infix operator fun remAssign(b: Long) {
        rem(this, this, b, b, b, b)
    }
    infix operator fun remAssign(b: Vec4ul) {
        rem(this, this, b.x, b.y, b.z, b.w)
    }


    // -- Generic binary arithmetic operators --

    operator fun plus(b: Number) = plus(Vec4ul(), this, b.L, b.L, b.L, b.L)
    operator fun plus(b: Vec4t<out Number>) = plus(Vec4ul(), this, b.x.L, b.y.L, b.z.L, b.w.L)

    fun plus(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4ul = Vec4ul()) = plus(res, this, bX.L, bY.L, bZ.L, bW.L)
    fun plus(b: Number, res: Vec4ul = Vec4ul()) = plus(res, this, b.L, b.L, b.L, b.L)
    fun plus(b: Vec4t<out Number>, res: Vec4ul = Vec4ul()) = plus(res, this, b.x.L, b.y.L, b.z.L, b.w.L)

    fun plusAssign(bX: Number, bY: Number, bZ: Number, bW: Number) = plus(this, this, bX.L, bY.L, bZ.L, bW.L)
    infix operator fun plusAssign(b: Number) {
        plus(this, this, b.L, b.L, b.L, b.L)
    }
    infix operator fun plusAssign(b: Vec4t<out Number>) {
        plus(this, this, b.x.L, b.y.L, b.z.L, b.w.L)
    }


    operator fun minus(b: Number) = minus(Vec4ul(), this, b.L, b.L, b.L, b.L)
    operator fun minus(b: Vec4t<out Number>) = minus(Vec4ul(), this, b.x.L, b.y.L, b.z.L, b.w.L)

    fun minus(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4ul = Vec4ul()) = minus(res, this, bX.L, bY.L, bZ.L, bW.L)
    fun minus(b: Number, res: Vec4ul = Vec4ul()) = minus(res, this, b.L, b.L, b.L, b.L)
    fun minus(b: Vec4t<out Number>, res: Vec4ul = Vec4ul()) = minus(res, this, b.x.L, b.y.L, b.z.L, b.w.L)

    fun minusAssign(bX: Number, bY: Number, bZ: Number, bW: Number) = minus(this, this, bX.L, bY.L, bZ.L, bW.L)
    infix operator fun minusAssign(b: Number) {
        minus(this, this, b.L, b.L, b.L, b.L)
    }
    infix operator fun minusAssign(b: Vec4t<out Number>) {
        minus(this, this, b.x.L, b.y.L, b.z.L, b.w.L)
    }


    operator fun times(b: Number) = times(Vec4ul(), this, b.L, b.L, b.L, b.L)
    operator fun times(b: Vec4t<out Number>) = times(Vec4ul(), this, b.x.L, b.y.L, b.z.L, b.w.L)

    fun times(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4ul = Vec4ul()) = times(res, this, bX.L, bY.L, bZ.L, bW.L)
    fun times(b: Number, res: Vec4ul = Vec4ul()) = times(res, this, b.L, b.L, b.L, b.L)
    fun times(b: Vec4t<out Number>, res: Vec4ul = Vec4ul()) = times(res, this, b.x.L, b.y.L, b.z.L, b.w.L)

    fun timesAssign(bX: Number, bY: Number, bZ: Number, bW: Number) = times(this, this, bX.L, bY.L, bZ.L, bW.L)
    infix operator fun timesAssign(b: Number) {
        times(this, this, b.L, b.L, b.L, b.L)
    }
    infix operator fun timesAssign(b: Vec4t<out Number>) {
        times(this, this, b.x.L, b.y.L, b.z.L, b.w.L)
    }


    operator fun div(b: Number) = div(Vec4ul(), this, b.L, b.L, b.L, b.L)
    operator fun div(b: Vec4t<out Number>) = div(Vec4ul(), this, b.x.L, b.y.L, b.z.L, b.w.L)

    fun div(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4ul = Vec4ul()) = div(res, this, bX.L, bY.L, bZ.L, bW.L)
    fun div(b: Number, res: Vec4ul = Vec4ul()) = div(res, this, b.L, b.L, b.L, b.L)
    fun div(b: Vec4t<out Number>, res: Vec4ul = Vec4ul()) = div(res, this, b.x.L, b.y.L, b.z.L, b.w.L)

    fun divAssign(bX: Number, bY: Number, bZ: Number, bW: Number) = div(this, this, bX.L, bY.L, bZ.L, bW.L)
    infix operator fun divAssign(b: Number) {
        div(this, this, b.L, b.L, b.L, b.L)
    }
    infix operator fun divAssign(b: Vec4t<out Number>) {
        div(this, this, b.x.L, b.y.L, b.z.L, b.w.L)
    }


    operator fun rem(b: Number) = rem(Vec4ul(), this, b.L, b.L, b.L, b.L)
    operator fun rem(b: Vec4t<out Number>) = rem(Vec4ul(), this, b.x.L, b.y.L, b.z.L, b.w.L)

    fun rem(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4ul = Vec4ul()) = rem(res, this, bX.L, bY.L, bZ.L, bW.L)
    fun rem(b: Number, res: Vec4ul = Vec4ul()) = rem(res, this, b.L, b.L, b.L, b.L)
    fun rem(b: Vec4t<out Number>, res: Vec4ul = Vec4ul()) = rem(res, this, b.x.L, b.y.L, b.z.L, b.w.L)

    fun remAssign(bX: Number, bY: Number, bZ: Number, bW: Number) = rem(this, this, bX.L, bY.L, bZ.L, bW.L)
    infix operator fun remAssign(b: Number) {
        rem(this, this, b.L, b.L, b.L, b.L)
    }
    infix operator fun remAssign(b: Vec4t<out Number>) {
        rem(this, this, b.x.L, b.y.L, b.z.L, b.w.L)
    }


    // -- Specific bitwise operators --

    infix fun and(b: Ulong) = and(Vec4ul(), this, b, b, b, b)
    infix fun and(b: Long) = and(Vec4ul(), this, b, b, b, b)
    fun and(bX: Ulong, bY: Ulong, bZ: Ulong, bW: Ulong) = and(Vec4ul(), this, bX, bY, bZ, bW)
    fun and(bX: Long, bY: Long, bZ: Long, bW: Long) = and(Vec4ul(), this, bX, bY, bZ, bW)
    fun and(b: Vec4ul) = and(Vec4ul(), this, b.x, b.y, b.z, b.w)

    infix fun andAssign(b: Ulong) = and(this, this, b, b, b, b)
    infix fun andAssign(b: Long) = and(this, this, b, b, b, b)
    fun andAssign(bX: Ulong, bY: Ulong, bZ: Ulong, bW: Ulong) = and(this, this, bX, bY, bZ, bW)
    fun andAssign(bX: Long, bY: Long, bZ: Long, bW: Long) = and(this, this, bX, bY, bZ, bW)
    infix fun andAssign(b: Vec4ul) = and(this, this, b.x, b.y, b.z, b.w)

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

    infix fun orAssign(b: Ulong) = or(this, this, b, b, b, b)
    infix fun orAssign(b: Long) = or(this, this, b, b, b, b)
    fun orAssign(bX: Ulong, bY: Ulong, bZ: Ulong, bW: Ulong) = or(this, this, bX, bY, bZ, bW)
    fun orAssign(bX: Long, bY: Long, bZ: Long, bW: Long) = or(this, this, bX, bY, bZ, bW)
    infix fun orAssign(b: Vec4ul) = or(this, this, b.x, b.y, b.z, b.w)

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

    infix fun xorAssign(b: Ulong) = xor(this, this, b, b, b, b)
    infix fun xorAssign(b: Long) = xor(this, this, b, b, b, b)
    fun xorAssign(bX: Ulong, bY: Ulong, bZ: Ulong, bW: Ulong) = xor(this, this, bX, bY, bZ, bW)
    fun xorAssign(bX: Long, bY: Long, bZ: Long, bW: Long) = xor(this, this, bX, bY, bZ, bW)
    infix fun xorAssign(b: Vec4ul) = xor(this, this, b.x, b.y, b.z, b.w)

    fun xor(b: Ulong, res: Vec4ul) = xor(res, this, b, b, b, b)
    fun xor(b: Long, res: Vec4ul) = xor(res, this, b, b, b, b)
    fun xor(bX: Ulong, bY: Ulong, bZ: Ulong, bW: Ulong, res: Vec4ul) = xor(res, this, bX, bY, bZ, bW)
    fun xor(bX: Long, bY: Long, bZ: Long, bW: Long, res: Vec4ul) = xor(res, this, bX, bY, bZ, bW)
    fun xor(b: Vec4ul, res: Vec4ul) = xor(res, this, b.x, b.y, b.z, b.w)


    infix fun shl(b: Int) = shl(Vec4ul(), this, b, b, b, b)
    fun shl(bX: Int, bY: Int, bZ: Int, bW: Int) = shl(Vec4ul(), this, bX, bY, bZ, bW)

    infix fun shlAssign(b: Int) = shl(this, this, b, b, b, b)
    fun shlAssign(bX: Int, bY: Int, bZ: Int, bW: Int) = shl(this, this, bX, bY, bZ, bW)

    fun shl(b: Int, res: Vec4ul) = shl(res, this, b, b, b, b)
    fun shl(bX: Int, bY: Int, bZ: Int, bW: Int, res: Vec4ul) = shl(res, this, bX, bY, bZ, bW)


    infix fun shr(b: Int) = shr(Vec4ul(), this, b, b, b, b)
    fun shr(bX: Int, bY: Int, bZ: Int, bW: Int) = shr(Vec4ul(), this, bX, bY, bZ, bW)

    infix fun shrAssign(b: Int) = shr(this, this, b, b, b, b)
    fun shrAssign(bX: Int, bY: Int, bZ: Int, bW: Int) = shr(this, this, bX, bY, bZ, bW)

    fun shr(b: Int, res: Vec4ul) = shr(res, this, b, b, b, b)
    fun shr(bX: Int, bY: Int, bZ: Int, bW: Int, res: Vec4ul) = shr(res, this, bX, bY, bZ, bW)


    fun inv(res: Vec4ul = Vec4ul()) = inv(res, this)
    fun invAssign() = inv(this, this)


    // -- Generic bitwise operators --

    infix fun and(b: Number) = and(Vec4ul(), this, b.L, b.L, b.L, b.L)
    fun and(bX: Number, bY: Number, bZ: Number, bW: Number) = and(Vec4ul(), this, bX.L, bY.L, bZ.L, bW.L)
    fun and(b: Vec4t<out Number>) = and(Vec4ul(), this, b.x.L, b.y.L, b.z.L, b.w.L)

    infix fun andAssign(b: Number) = and(this, this, b.L, b.L, b.L, b.L)
    fun andAssign(bX: Number, bY: Number, bZ: Number, bW: Number) = and(this, this, bX.L, bY.L, bZ.L, bW.L)
    infix fun andAssign(b: Vec4t<out Number>) = and(this, this, b.x.L, b.y.L, b.z.L, b.w.L)

    fun and(b: Number, res: Vec4ul) = and(res, this, b.L, b.L, b.L, b.L)
    fun and(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4ul) = and(res, this, bX.L, bY.L, bZ.L, bW.L)
    fun and(b: Vec4t<out Number>, res: Vec4ul) = and(res, this, b.x.L, b.y.L, b.z.L, b.w.L)


    infix fun or(b: Number) = or(Vec4ul(), this, b.L, b.L, b.L, b.L)
    fun or(bX: Number, bY: Number, bZ: Number, bW: Number) = or(Vec4ul(), this, bX.L, bY.L, bZ.L, bW.L)
    fun or(b: Vec4t<out Number>) = or(Vec4ul(), this, b.x.L, b.y.L, b.z.L, b.w.L)

    infix fun orAssign(b: Number) = or(this, this, b.L, b.L, b.L, b.L)
    fun orAssign(bX: Number, bY: Number, bZ: Number, bW: Number) = or(this, this, bX.L, bY.L, bZ.L, bW.L)
    infix fun orAssign(b: Vec4t<out Number>) = or(this, this, b.x.L, b.y.L, b.z.L, b.w.L)

    fun or(b: Number, res: Vec4ul) = or(res, this, b.L, b.L, b.L, b.L)
    fun or(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4ul) = or(res, this, bX.L, bY.L, bZ.L, bW.L)
    fun or(b: Vec4t<out Number>, res: Vec4ul) = or(res, this, b.x.L, b.y.L, b.z.L, b.w.L)


    infix fun xor(b: Number) = xor(Vec4ul(), this, b.L, b.L, b.L, b.L)
    fun xor(bX: Number, bY: Number, bZ: Number, bW: Number) = xor(Vec4ul(), this, bX.L, bY.L, bZ.L, bW.L)
    fun xor(b: Vec4t<out Number>) = xor(Vec4ul(), this, b.x.L, b.y.L, b.z.L, b.w.L)

    infix fun xorAssign(b: Number) = xor(this, this, b.L, b.L, b.L, b.L)
    fun xorAssign(bX: Number, bY: Number, bZ: Number, bW: Number) = xor(this, this, bX.L, bY.L, bZ.L, bW.L)
    infix fun xorAssign(b: Vec4t<out Number>) = xor(this, this, b.x.L, b.y.L, b.z.L, b.w.L)

    fun xor(b: Number, res: Vec4ul) = xor(res, this, b.L, b.L, b.L, b.L)
    fun xor(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4ul) = xor(res, this, bX.L, bY.L, bZ.L, bW.L)
    fun xor(b: Vec4t<out Number>, res: Vec4ul) = xor(res, this, b.x.L, b.y.L, b.z.L, b.w.L)


    infix fun shl(b: Number) = shl(Vec4ul(), this, b.L, b.L, b.L, b.L)
    fun shl(bX: Number, bY: Number, bZ: Number, bW: Number) = shl(Vec4ul(), this, bX.L, bY.L, bZ.L, bW.L)

    infix fun shlAssign(b: Number) = shl(this, this, b.L, b.L, b.L, b.L)
    fun shlAssign(bX: Number, bY: Number, bZ: Number, bW: Number) = shl(this, this, bX.L, bY.L, bZ.L, bW.L)

    fun shl(b: Number, res: Vec4ul) = shl(res, this, b.L, b.L, b.L, b.L)
    fun shl(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4ul) = shl(res, this, bX.L, bY.L, bZ.L, bW.L)


    infix fun shr(b: Number) = shr(Vec4ul(), this, b.L, b.L, b.L, b.L)
    fun shr(bX: Number, bY: Number, bZ: Number, bW: Number) = shr(Vec4ul(), this, bX.L, bY.L, bZ.L, bW.L)

    infix fun shrAssign(b: Number) = shr(this, this, b.L, b.L, b.L, b.L)
    fun shrAssign(bX: Number, bY: Number, bZ: Number, bW: Number) = shr(this, this, bX.L, bY.L, bZ.L, bW.L)

    fun shr(b: Number, res: Vec4ul) = shr(res, this, b.L, b.L, b.L, b.L)
    fun shr(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4ul) = shr(res, this, bX.L, bY.L, bZ.L, bW.L)


    override fun equals(other: Any?) = other is Vec4ul && this[0] == other[0] && this[1] == other[1] && this[2] == other[2] && this[3] == other[3]
    override fun hashCode() = 31 * (31 * (31 * x.v.hashCode() + y.v.hashCode()) + z.v.hashCode()) + w.v.hashCode()
}