package glm_.vec4

import glm_.*
import glm_.vec2.Vec2bool
import glm_.vec2.Vec2l
import glm_.vec2.Vec2t
import glm_.vec3.Vec3bool
import glm_.vec3.Vec3l
import glm_.vec3.Vec3t
import glm_.vec4.operators.vec4l_operators
import kool.Ptr
import kool.longBufferBig
import kool.pos
import org.lwjgl.system.MemoryStack
import org.lwjgl.system.MemoryUtil.memGetLong
import org.lwjgl.system.MemoryUtil.memPutLong
import java.nio.*

/**
 * Created by elect on 09/10/16.
 */

class Vec4l(var ofs: Int, var array: LongArray) : Vec4t<Long>(), ToBuffer {

    constructor(x: Long, y: Long, z: Long, w: Long) : this(0, longArrayOf(x, y, z, w))

    override var x: Long
        get() = array[ofs]
        set(value) = array.set(ofs, value)
    override var y: Long
        get() = array[ofs + 1]
        set(value) = array.set(ofs + 1, value)
    override var z: Long
        get() = array[ofs + 2]
        set(value) = array.set(ofs + 2, value)
    override var w: Long
        get() = array[ofs + 3]
        set(value) = array.set(ofs + 3, value)

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

    constructor(bytes: ByteArray, index: Int = 0, oneByteOneLong: Boolean = false, bigEndian: Boolean = true) : this(
            if (oneByteOneLong) bytes[index].L else bytes.getLong(index, bigEndian),
            if (oneByteOneLong) bytes[index + 1].L else bytes.getLong(index + Long.BYTES, bigEndian),
            if (oneByteOneLong) bytes[index + 2].L else bytes.getLong(index + Long.BYTES * 2, bigEndian),
            if (oneByteOneLong) bytes[index + 3].L else bytes.getLong(index + Long.BYTES * 3, bigEndian))

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

    constructor(list: Iterable<*>, index: Int = 0) : this(list.elementAt(index)!!.toLong, list.elementAt(index + 1)!!.toLong,
            list.elementAt(index + 2)!!.toLong, list.elementAt(index + 3)!!.toLong)

    constructor(bytes: ByteBuffer, index: Int = bytes.pos, oneByteOneLong: Boolean = false) : this(
            if (oneByteOneLong) bytes[index].L else bytes.getLong(index),
            if (oneByteOneLong) bytes[index + 1].L else bytes.getLong(index + Long.BYTES),
            if (oneByteOneLong) bytes[index + 2].L else bytes.getLong(index + Long.BYTES * 2),
            if (oneByteOneLong) bytes[index + 3].L else bytes.getLong(index + Long.BYTES * 3))

    constructor(chars: CharBuffer, index: Int = chars.pos) : this(chars[index].L, chars[index + 1].L, chars[index + 2].L, chars[index + 3].L)
    constructor(shorts: ShortBuffer, index: Int = shorts.pos) : this(shorts[index], shorts[index + 1], shorts[index + 2], shorts[index + 3])
    constructor(ints: IntBuffer, index: Int = ints.pos) : this(ints[index], ints[index + 1], ints[index + 2], ints[index + 3])
    constructor(longs: LongBuffer, index: Int = longs.pos) : this(longs[index], longs[index + 1], longs[index + 2], longs[index + 3])
    constructor(floats: FloatBuffer, index: Int = floats.pos) : this(floats[index], floats[index + 1], floats[index + 2], floats[index + 3])
    constructor(doubles: DoubleBuffer, index: Int = doubles.pos) : this(doubles[index], doubles[index + 1], doubles[index + 2], doubles[index + 3])

    constructor(block: (Int) -> Long) : this(block(0), block(1), block(2), block(3))

    constructor(s: Number) : this(s, s, s, s)
    constructor(x: Number, y: Number, z: Number, w: Number) : this(x.L, y.L, z.L, w.L)


    fun set(bytes: ByteArray, index: Int = 0, oneByteOneLong: Boolean = false, bigEndian: Boolean = true) {
        x = if (oneByteOneLong) bytes[index].L else bytes.getLong(index, bigEndian)
        y = if (oneByteOneLong) bytes[index + 1].L else bytes.getLong(index + Long.BYTES, bigEndian)
        z = if (oneByteOneLong) bytes[index + 2].L else bytes.getLong(index + Long.BYTES * 2, bigEndian)
        w = if (oneByteOneLong) bytes[index + 3].L else bytes.getLong(index + Long.BYTES * 3, bigEndian)
    }

    fun set(bytes: ByteBuffer, index: Int = bytes.pos, oneByteOneLong: Boolean = false) {
        x = if (oneByteOneLong) bytes[index].L else bytes.getLong(index)
        y = if (oneByteOneLong) bytes[index + 1].L else bytes.getLong(index + Long.BYTES)
        z = if (oneByteOneLong) bytes[index + 2].L else bytes.getLong(index + Long.BYTES * 2)
        w = if (oneByteOneLong) bytes[index + 3].L else bytes.getLong(index + Long.BYTES * 3)
    }


    fun put(x: Long, y: Long, z: Long, w: Long) {
        this.x = x
        this.y = y
        this.z = z
        this.w = w
    }

    fun invoke(x: Long, y: Long, z: Long, w: Long): Vec4l {
        this.x = x
        this.y = y
        this.z = z
        this.w = w
        return this
    }

    override fun put(x: Number, y: Number, z: Number, w: Number) {
        this.x = x.L
        this.y = y.L
        this.z = z.L
        this.w = w.L
    }

    override fun invoke(x: Number, y: Number, z: Number, w: Number): Vec4l {
        this.x = x.L
        this.y = y.L
        this.z = z.L
        this.w = w.L
        return this
    }

    fun to(bytes: ByteArray, index: Int): ByteArray = to(bytes, index, true)
    override fun to(bytes: ByteArray, index: Int, bigEndian: Boolean): ByteArray {
        bytes.putLong(index, x)
        bytes.putLong(index + Long.BYTES, y)
        bytes.putLong(index + Long.BYTES * 2, z)
        bytes.putLong(index + Long.BYTES * 3, w)
        return bytes
    }

    fun toLongArray(): LongArray = to(LongArray(length), 0)
    infix fun to(longs: LongArray): LongArray = to(longs, 0)
    fun to(longs: LongArray, index: Int): LongArray {
        System.arraycopy(array, ofs, longs, index, length)
        return longs
    }

    override fun to(buf: ByteBuffer, offset: Int): ByteBuffer {
        buf.putLong(offset, x)
        buf.putLong(offset + Long.BYTES, y)
        buf.putLong(offset + Long.BYTES * 2, z)
        buf.putLong(offset + Long.BYTES * 3, w)
        return buf
    }

    fun toLongBufferStack(): LongBuffer = to(MemoryStack.stackPush().mallocLong(length), 0)
    infix fun toLongBuffer(stack: MemoryStack): LongBuffer = to(stack.mallocLong(length), 0)
    fun toLongBuffer(): LongBuffer = to(longBufferBig(length), 0)
    infix fun to(buf: LongBuffer): LongBuffer = to(buf, buf.pos)
    fun to(buf: LongBuffer, index: Int): LongBuffer {
        buf[index] = x
        buf[index + 1] = y
        buf[index + 2] = z
        buf[index + 3] = w
        return buf
    }

    infix fun to(ptr: Ptr) {
        memPutLong(ptr, x)
        memPutLong(ptr + Long.BYTES, y)
        memPutLong(ptr + Long.BYTES * 2, z)
        memPutLong(ptr + Long.BYTES * 3, w)
    }

    // -- Component accesses --

    operator fun set(index: Int, value: Long) = when (index) {
        0 -> x = value
        1 -> y = value
        2 -> z = value
        3 -> w = value
        else -> throw ArrayIndexOutOfBoundsException()
    }

    override operator fun set(index: Int, value: Number) = when (index) {
        0 -> x = value.L
        1 -> y = value.L
        2 -> z = value.L
        3 -> w = value.L
        else -> throw ArrayIndexOutOfBoundsException()
    }





    // -- Unary arithmetic operators --

    operator fun unaryPlus() = this

    operator fun unaryMinus() = Vec4l(-x, -y, -z, -w)

    // -- Increment main.and decrement operators --

    operator fun inc(res: Vec4l = Vec4l()) = plus(res, this, 1, 1, 1, 1)
    fun incAssign() = plus(this, this, 1, 1, 1, 1)


    operator fun dec(res: Vec4l = Vec4l()) = minus(res, this, 1, 1, 1, 1)
    fun decAssign() = minus(this, this, 1, 1, 1, 1)


    // -- Specific binary arithmetic operators --

    operator fun plus(b: Long) = plus(Vec4l(), this, b, b, b, b)
    operator fun plus(b: Vec4l) = plus(Vec4l(), this, b.x, b.y, b.z, b.w)

    fun plus(bX: Long, bY: Long, bZ: Long, bW: Long, res: Vec4l = Vec4l()) = plus(res, this, bX, bY, bZ, bW)
    fun plus(b: Long, res: Vec4l = Vec4l()) = plus(res, this, b, b, b, b)
    fun plus(b: Vec4l, res: Vec4l = Vec4l()) = plus(res, this, b.x, b.y, b.z, b.w)

    fun plusAssign(bX: Long, bY: Long, bZ: Long, bW: Long) = plus(this, this, bX, bY, bZ, bW)
    infix operator fun plusAssign(b: Long) {
        plus(this, this, b, b, b, b)
    }
    infix operator fun plusAssign(b: Vec4l) {
        plus(this, this, b.x, b.y, b.z, b.w)
    }


    operator fun minus(b: Long) = minus(Vec4l(), this, b, b, b, b)
    operator fun minus(b: Vec4l) = minus(Vec4l(), this, b.x, b.y, b.z, b.w)

    fun minus(bX: Long, bY: Long, bZ: Long, bW: Long, res: Vec4l = Vec4l()) = minus(res, this, bX, bY, bZ, bW)
    fun minus(b: Long, res: Vec4l = Vec4l()) = minus(res, this, b, b, b, b)
    fun minus(b: Vec4l, res: Vec4l = Vec4l()) = minus(res, this, b.x, b.y, b.z, b.w)

    fun minusAssign(bX: Long, bY: Long, bZ: Long, bW: Long) = minus(this, this, bX, bY, bZ, bW)
    infix operator fun minusAssign(b: Long) {
        minus(this, this, b, b, b, b)
    }
    infix operator fun minusAssign(b: Vec4l) {
        minus(this, this, b.x, b.y, b.z, b.w)
    }


    operator fun times(b: Long) = times(Vec4l(), this, b, b, b, b)
    operator fun times(b: Vec4l) = times(Vec4l(), this, b.x, b.y, b.z, b.w)

    fun times(bX: Long, bY: Long, bZ: Long, bW: Long, res: Vec4l = Vec4l()) = times(res, this, bX, bY, bZ, bW)
    fun times(b: Long, res: Vec4l = Vec4l()) = times(res, this, b, b, b, b)
    fun times(b: Vec4l, res: Vec4l = Vec4l()) = times(res, this, b.x, b.y, b.z, b.w)

    fun timesAssign(bX: Long, bY: Long, bZ: Long, bW: Long) = times(this, this, bX, bY, bZ, bW)
    infix operator fun timesAssign(b: Long) {
        times(this, this, b, b, b, b)
    }
    infix operator fun timesAssign(b: Vec4l) {
        times(this, this, b.x, b.y, b.z, b.w)
    }


    operator fun div(b: Long) = div(Vec4l(), this, b, b, b, b)
    operator fun div(b: Vec4l) = div(Vec4l(), this, b.x, b.y, b.z, b.w)

    fun div(bX: Long, bY: Long, bZ: Long, bW: Long, res: Vec4l = Vec4l()) = div(res, this, bX, bY, bZ, bW)
    fun div(b: Long, res: Vec4l) = div(res, this, b, b, b, b)
    fun div(b: Vec4l, res: Vec4l) = div(res, this, b.x, b.y, b.z, b.w)

    fun divAssign(bX: Long, bY: Long, bZ: Long, bW: Long) = div(this, this, bX, bY, bZ, bW)
    infix operator fun divAssign(b: Long) {
        div(this, this, b, b, b, b)
    }
    infix operator fun divAssign(b: Vec4l) {
        div(this, this, b.x, b.y, b.z, b.w)
    }


    operator fun rem(b: Long) = rem(Vec4l(), this, b, b, b, b)
    operator fun rem(b: Vec4l) = rem(Vec4l(), this, b.x, b.y, b.z, b.w)

    fun rem(bX: Long, bY: Long, bZ: Long, bW: Long, res: Vec4l = Vec4l()) = rem(res, this, bX, bY, bZ, bW)
    fun rem(b: Long, res: Vec4l) = rem(res, this, b, b, b, b)
    fun rem(b: Vec4l, res: Vec4l) = rem(res, this, b.x, b.y, b.z, b.w)

    fun remAssign(bX: Long, bY: Long, bZ: Long, bW: Long) = rem(this, this, bX, bY, bZ, bW)
    infix operator fun remAssign(b: Long) {
        rem(this, this, b, b, b, b)
    }
    infix operator fun remAssign(b: Vec4l) {
        rem(this, this, b.x, b.y, b.z, b.w)
    }


    // -- Generic binary arithmetic operators --

    operator fun plus(b: Number) = plus(Vec4l(), this, b.L, b.L, b.L, b.L)
    operator fun plus(b: Vec4t<out Number>) = plus(Vec4l(), this, b.x.L, b.y.L, b.z.L, b.w.L)

    fun plus(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4l = Vec4l()) = plus(res, this, bX.L, bY.L, bZ.L, bW.L)
    fun plus(b: Number, res: Vec4l = Vec4l()) = plus(res, this, b.L, b.L, b.L, b.L)
    fun plus(b: Vec4t<out Number>, res: Vec4l = Vec4l()) = plus(res, this, b.x.L, b.y.L, b.z.L, b.w.L)

    fun plusAssign(bX: Number, bY: Number, bZ: Number, bW: Number) = plus(this, this, bX.L, bY.L, bZ.L, bW.L)
    infix operator fun plusAssign(b: Number) {
        plus(this, this, b.L, b.L, b.L, b.L)
    }
    infix operator fun plusAssign(b: Vec4t<out Number>) {
        plus(this, this, b.x.L, b.y.L, b.z.L, b.w.L)
    }


    operator fun minus(b: Number) = minus(Vec4l(), this, b.L, b.L, b.L, b.L)
    operator fun minus(b: Vec4t<out Number>) = minus(Vec4l(), this, b.x.L, b.y.L, b.z.L, b.w.L)

    fun minus(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4l = Vec4l()) = minus(res, this, bX.L, bY.L, bZ.L, bW.L)
    fun minus(b: Number, res: Vec4l = Vec4l()) = minus(res, this, b.L, b.L, b.L, b.L)
    fun minus(b: Vec4t<out Number>, res: Vec4l = Vec4l()) = minus(res, this, b.x.L, b.y.L, b.z.L, b.w.L)

    fun minusAssign(bX: Number, bY: Number, bZ: Number, bW: Number) = minus(this, this, bX.L, bY.L, bZ.L, bW.L)
    infix operator fun minusAssign(b: Number) {
        minus(this, this, b.L, b.L, b.L, b.L)
    }
    infix operator fun minusAssign(b: Vec4t<out Number>) {
        minus(this, this, b.x.L, b.y.L, b.z.L, b.w.L)
    }


    operator fun times(b: Number) = times(Vec4l(), this, b.L, b.L, b.L, b.L)
    operator fun times(b: Vec4t<out Number>) = times(Vec4l(), this, b.x.L, b.y.L, b.z.L, b.w.L)

    fun times(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4l = Vec4l()) = times(res, this, bX.L, bY.L, bZ.L, bW.L)
    fun times(b: Number, res: Vec4l = Vec4l()) = times(res, this, b.L, b.L, b.L, b.L)
    fun times(b: Vec4t<out Number>, res: Vec4l = Vec4l()) = times(res, this, b.x.L, b.y.L, b.z.L, b.w.L)

    fun timesAssign(bX: Number, bY: Number, bZ: Number, bW: Number) = times(this, this, bX.L, bY.L, bZ.L, bW.L)
    infix operator fun timesAssign(b: Number) {
        times(this, this, b.L, b.L, b.L, b.L)
    }
    infix operator fun timesAssign(b: Vec4t<out Number>) {
        times(this, this, b.x.L, b.y.L, b.z.L, b.w.L)
    }


    operator fun div(b: Number) = div(Vec4l(), this, b.L, b.L, b.L, b.L)
    operator fun div(b: Vec4t<out Number>) = div(Vec4l(), this, b.x.L, b.y.L, b.z.L, b.w.L)

    fun div(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4l = Vec4l()) = div(res, this, bX.L, bY.L, bZ.L, bW.L)
    fun div(b: Number, res: Vec4l) = div(res, this, b.L, b.L, b.L, b.L)
    fun div(b: Vec4t<out Number>, res: Vec4l) = div(res, this, b.x.L, b.y.L, b.z.L, b.w.L)

    fun divAssign(bX: Number, bY: Number, bZ: Number, bW: Number) = div(this, this, bX.L, bY.L, bZ.L, bW.L)
    infix operator fun divAssign(b: Number) {
        div(this, this, b.L, b.L, b.L, b.L)
    }
    infix operator fun divAssign(b: Vec4t<out Number>) {
        div(this, this, b.x.L, b.y.L, b.z.L, b.w.L)
    }


    operator fun rem(b: Number) = rem(Vec4l(), this, b.L, b.L, b.L, b.L)
    operator fun rem(b: Vec4t<out Number>) = rem(Vec4l(), this, b.x.L, b.y.L, b.z.L, b.w.L)

    fun rem(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4l = Vec4l()) = rem(res, this, bX.L, bY.L, bZ.L, bW.L)
    fun rem(b: Number, res: Vec4l) = rem(res, this, b.L, b.L, b.L, b.L)
    fun rem(b: Vec4t<out Number>, res: Vec4l) = rem(res, this, b.x.L, b.y.L, b.z.L, b.w.L)

    fun remAssign(bX: Number, bY: Number, bZ: Number, bW: Number) = rem(this, this, bX.L, bY.L, bZ.L, bW.L)
    infix operator fun remAssign(b: Number) {
        rem(this, this, b.L, b.L, b.L, b.L)
    }
    infix operator fun remAssign(b: Vec4t<out Number>) {
        rem(this, this, b.x.L, b.y.L, b.z.L, b.w.L)
    }


    // -- Specific bitwise operators --

    infix fun and(b: Long) = and(Vec4l(), this, b, b, b, b)
    infix fun and(b: Vec4l) = and(Vec4l(), this, b.x, b.y, b.z, b.w)

    infix fun andAssign(b: Long) = and(this, this, b, b, b, b)
    infix fun andAssign(b: Vec4l) = and(this, this, b.x, b.y, b.z, b.w)

    fun and(b: Long, res: Vec4l) = and(res, this, b, b, b, b)
    fun and(b: Vec4l, res: Vec4l) = and(res, this, b.x, b.y, b.z, b.w)

    fun and(bX: Long, bY: Long, bZ: Long, bW: Long, res: Vec4l = Vec4l()) = and(res, this, bX, bY, bZ, bW)

    fun andAssign(bX: Long, bY: Long, bZ: Long, bW: Long) = and(this, this, bX, bY, bZ, bW)


    infix fun or(b: Long) = or(Vec4l(), this, b, b, b, b)
    infix fun or(b: Vec4l) = or(Vec4l(), this, b.x, b.y, b.z, b.w)

    infix fun orAssign(b: Long) = or(this, this, b, b, b, b)
    infix fun orAssign(b: Vec4l) = or(this, this, b.x, b.y, b.z, b.w)

    fun or(b: Long, res: Vec4l) = or(res, this, b, b, b, b)
    fun or(b: Vec4l, res: Vec4l) = or(res, this, b.x, b.y, b.z, b.w)

    fun or(bX: Long, bY: Long, bZ: Long, bW: Long, res: Vec4l = Vec4l()) = or(res, this, bX, bY, bZ, bW)

    fun orAssign(bX: Long, bY: Long, bZ: Long, bW: Long) = or(this, this, bX, bY, bZ, bW)


    infix fun xor(b: Long) = xor(Vec4l(), this, b, b, b, b)
    infix fun xor(b: Vec4l) = xor(Vec4l(), this, b.x, b.y, b.z, b.w)

    infix fun xorAssign(b: Long) = xor(this, this, b, b, b, b)
    infix fun xorAssign(b: Vec4l) = xor(this, this, b.x, b.y, b.z, b.w)

    fun xor(b: Long, res: Vec4l) = xor(res, this, b, b, b, b)
    fun xor(b: Vec4l, res: Vec4l) = xor(res, this, b.x, b.y, b.z, b.w)

    fun xor(bX: Long, bY: Long, bZ: Long, bW: Long, res: Vec4l = Vec4l()) = xor(res, this, bX, bY, bZ, bW)

    fun xorAssign(bX: Long, bY: Long, bZ: Long, bW: Long) = xor(this, this, bX, bY, bZ, bW)


    infix fun shl(b: Long) = shl(Vec4l(), this, b, b, b, b)
    infix fun shl(b: Vec4l) = shl(Vec4l(), this, b.x, b.y, b.z, b.w)

    infix fun shlAssign(b: Long) = shl(this, this, b, b, b, b)
    infix fun shlAssign(b: Vec4l) = shl(this, this, b.x, b.y, b.z, b.w)

    fun shl(b: Long, res: Vec4l) = shl(res, this, b, b, b, b)
    fun shl(b: Vec4l, res: Vec4l) = shl(res, this, b.x, b.y, b.z, b.w)

    fun shl(bX: Long, bY: Long, bZ: Long, bW: Long, res: Vec4l = Vec4l()) = shl(res, this, bX, bY, bZ, bW)

    fun shlAssign(bX: Long, bY: Long, bZ: Long, bW: Long) = shl(this, this, bX, bY, bZ, bW)


    infix fun shr(b: Long) = shr(Vec4l(), this, b, b, b, b)
    infix fun shr(b: Vec4l) = shr(Vec4l(), this, b.x, b.y, b.z, b.w)

    infix fun shrAssign(b: Long) = shr(this, this, b, b, b, b)
    infix fun shrAssign(b: Vec4l) = shr(this, this, b.x, b.y, b.z, b.w)

    fun shr(b: Long, res: Vec4l) = shr(res, this, b, b, b, b)
    fun shr(b: Vec4l, res: Vec4l) = shr(res, this, b.x, b.y, b.z, b.w)

    fun shr(bX: Long, bY: Long, bZ: Long, bW: Long, res: Vec4l = Vec4l()) = shr(res, this, bX, bY, bZ, bW)

    fun shrAssign(bX: Long, bY: Long, bZ: Long, bW: Long) = shr(this, this, bX, bY, bZ, bW)


    fun inv(res: Vec4l = Vec4l()) = inv(res, this)
    fun invAssign() = inv(this, this)


    // -- Generic bitwise operators --

    infix fun and(b: Number) = and(Vec4l(), this, b.L, b.L, b.L, b.L)
    infix fun and(b: Vec4t<out Number>) = and(Vec4l(), this, b.x.L, b.y.L, b.z.L, b.w.L)

    infix fun andAssign(b: Number) = and(this, this, b.L, b.L, b.L, b.L)
    infix fun andAssign(b: Vec4t<out Number>) = and(this, this, b.x.L, b.y.L, b.z.L, b.w.L)

    fun and(b: Number, res: Vec4l) = and(res, this, b.L, b.L, b.L, b.L)
    fun and(b: Vec4t<out Number>, res: Vec4l) = and(res, this, b.x.L, b.y.L, b.z.L, b.w.L)

    fun and(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4l = Vec4l()) = and(res, this, bX.L, bY.L, bZ.L, bW.L)

    fun andAssign(bX: Number, bY: Number, bZ: Number, bW: Number) = and(this, this, bX.L, bY.L, bZ.L, bW.L)


    infix fun or(b: Number) = or(Vec4l(), this, b.L, b.L, b.L, b.L)
    infix fun or(b: Vec4t<out Number>) = or(Vec4l(), this, b.x.L, b.y.L, b.z.L, b.w.L)

    infix fun orAssign(b: Number) = or(this, this, b.L, b.L, b.L, b.L)
    infix fun orAssign(b: Vec4t<out Number>) = or(this, this, b.x.L, b.y.L, b.z.L, b.w.L)

    fun or(b: Number, res: Vec4l) = or(res, this, b.L, b.L, b.L, b.L)
    fun or(b: Vec4t<out Number>, res: Vec4l) = or(res, this, b.x.L, b.y.L, b.z.L, b.w.L)

    fun or(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4l = Vec4l()) = or(res, this, bX.L, bY.L, bZ.L, bW.L)

    fun orAssign(bX: Number, bY: Number, bZ: Number, bW: Number) = or(this, this, bX.L, bY.L, bZ.L, bW.L)


    infix fun xor(b: Number) = xor(Vec4l(), this, b.L, b.L, b.L, b.L)
    infix fun xor(b: Vec4t<out Number>) = xor(Vec4l(), this, b.x.L, b.y.L, b.z.L, b.w.L)

    infix fun xorAssign(b: Number) = xor(this, this, b.L, b.L, b.L, b.L)
    infix fun xorAssign(b: Vec4t<out Number>) = xor(this, this, b.x.L, b.y.L, b.z.L, b.w.L)

    fun xor(b: Number, res: Vec4l) = xor(res, this, b.L, b.L, b.L, b.L)
    fun xor(b: Vec4t<out Number>, res: Vec4l) = xor(res, this, b.x.L, b.y.L, b.z.L, b.w.L)

    fun xor(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4l = Vec4l()) = xor(res, this, bX.L, bY.L, bZ.L, bW.L)

    fun xorAssign(bX: Number, bY: Number, bZ: Number, bW: Number) = xor(this, this, bX.L, bY.L, bZ.L, bW.L)


    infix fun shl(b: Number) = shl(Vec4l(), this, b.L, b.L, b.L, b.L)
    infix fun shl(b: Vec4t<out Number>) = shl(Vec4l(), this, b.x.L, b.y.L, b.z.L, b.w.L)

    infix fun shlAssign(b: Number) = shl(this, this, b.L, b.L, b.L, b.L)
    infix fun shlAssign(b: Vec4t<out Number>) = shl(this, this, b.x.L, b.y.L, b.z.L, b.w.L)

    fun shl(b: Number, res: Vec4l) = shl(res, this, b.L, b.L, b.L, b.L)
    fun shl(b: Vec4t<out Number>, res: Vec4l) = shl(res, this, b.x.L, b.y.L, b.z.L, b.w.L)

    fun shl(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4l = Vec4l()) = shl(res, this, bX.L, bY.L, bZ.L, bW.L)

    fun shlAssign(bX: Number, bY: Number, bZ: Number, bW: Number) = shl(this, this, bX.L, bY.L, bZ.L, bW.L)


    infix fun shr(b: Number) = shr(Vec4l(), this, b.L, b.L, b.L, b.L)
    infix fun shr(b: Vec4t<out Number>) = shr(Vec4l(), this, b.x.L, b.y.L, b.z.L, b.w.L)

    infix fun shrAssign(b: Number) = shr(this, this, b.L, b.L, b.L, b.L)
    infix fun shrAssign(b: Vec4t<out Number>) = shr(this, this, b.x.L, b.y.L, b.z.L, b.w.L)

    fun shr(b: Number, res: Vec4l) = shr(res, this, b.L, b.L, b.L, b.L)
    fun shr(b: Vec4t<out Number>, res: Vec4l) = shr(res, this, b.x.L, b.y.L, b.z.L, b.w.L)

    fun shr(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4l = Vec4l()) = shr(res, this, bX.L, bY.L, bZ.L, bW.L)

    fun shrAssign(bX: Number, bY: Number, bZ: Number, bW: Number) = shr(this, this, bX.L, bY.L, bZ.L, bW.L)


    override fun createInstance(x: Long, y: Long) = Vec2l(x, y)
    override fun createInstance(x: Long, y: Long, z: Long) = Vec3l(x, y, z)
    override fun createInstance(x: Long, y: Long, z: Long, w: Long) = Vec4l(x, y, z, w)


    companion object : vec4l_operators {
        const val length = Vec4t.length
        @JvmField
        val size = length * Long.BYTES

        @JvmStatic
        fun fromPointer(ptr: Ptr) = Vec4l(memGetLong(ptr), memGetLong(ptr + Long.BYTES), memGetLong(ptr + Long.BYTES * 2), memGetLong(ptr + Long.BYTES * 3))
    }

    override fun size() = Vec4l.size


    override fun equals(other: Any?) = other is Vec4l && this[0] == other[0] && this[1] == other[1] && this[2] == other[2] && this[3] == other[3]
    override fun hashCode() = 31 * (31 * (31 * x.hashCode() + y.hashCode()) + z.hashCode()) + w.hashCode()
}