package glm_.vec4

import glm_.*
import glm_.vec1.Vec1bool
import glm_.vec1.Vec1t
import glm_.vec2.Vec2bool
import glm_.vec2.Vec2s
import glm_.vec2.Vec2t
import glm_.vec3.Vec3bool
import glm_.vec3.Vec3s
import glm_.vec3.Vec3t
import glm_.vec4.operators.vec4s_operators
import kool.*
import org.lwjgl.system.MemoryStack
import org.lwjgl.system.MemoryUtil.memGetShort
import java.io.PrintStream
import java.nio.*

/**
 * Created by elect on 09/10/16.
 */

class Vec4s(var ofs: Int, var array: ShortArray) : Vec4t<Short>(), ToBuffer {

    override var x: Short
        get() = array[ofs]
        set(value) = array.set(ofs, value)
    override var y: Short
        get() = array[ofs + 1]
        set(value) = array.set(ofs + 1, value)
    override var z: Short
        get() = array[ofs + 2]
        set(value) = array.set(ofs + 2, value)
    override var w: Short
        get() = array[ofs + 3]
        set(value) = array.set(ofs + 3, value)

    // -- Implicit basic constructors --

    constructor() : this(0)
    constructor(v: Vec4s) : this(v.x, v.y, v.z, v.w)
    constructor(v: Vec3s) : this(v.x, v.y, v.z, 0)
    constructor(v: Vec2s) : this(v.x, v.y, 0, 0)

    // -- Explicit basic constructors --

    constructor(x: Short) : this(x, x, x, x)
    constructor(x: Short, y: Short, z: Short, w: Short) : this(0, shortArrayOf(x, y, z, w))
    constructor(x: Int) : this(x, x, x, x)
    constructor(x: Int, y: Int, z: Int, w: Int) : this(0, shortArrayOf(x.s, y.s, z.s, w.s))

    // -- Conversion scalar constructors --

    constructor(v: Vec1t<out Number>) : this(v.x, v.x, v.x, v.x)

    // Explicit conversions (From section 5.4.1 Conversion and scalar constructors of GLSL 1.30.08 specification)

    constructor(x: Number) : this(x, x, x, x)
    constructor(x: Number, y: Number, z: Number, w: Number) : this(x.s, y.s, z.s, w.s)

    constructor(x: Vec1t<out Number>, y: Number, z: Number, w: Number) : this(x.x, y, z, w)
    constructor(x: Number, y: Vec1t<out Number>, z: Number, w: Number) : this(x, y.x, z, w)
    constructor(x: Vec1t<out Number>, y: Vec1t<out Number>, z: Number, w: Number) : this(x.x, y.x, z, w)
    constructor(x: Number, y: Number, z: Vec1t<out Number>, w: Number) : this(x, y, z.x, w)
    constructor(x: Vec1t<out Number>, y: Number, z: Vec1t<out Number>, w: Number) : this(x.x, y, z.x, w)
    constructor(x: Number, y: Vec1t<out Number>, z: Vec1t<out Number>, w: Number) : this(x, y.x, z.x, w)
    constructor(x: Vec1t<out Number>, y: Vec1t<out Number>, z: Vec1t<out Number>, w: Number) : this(x.x, y.x, z.x, w)
    constructor(x: Vec1t<out Number>, y: Number, z: Number, w: Vec1t<out Number>) : this(x.x, y, z, w.x)
    constructor(x: Number, y: Vec1t<out Number>, z: Number, w: Vec1t<out Number>) : this(x, y.x, z, w.x)
    constructor(x: Vec1t<out Number>, y: Vec1t<out Number>, z: Number, w: Vec1t<out Number>) : this(x.x, y.x, z, w.x)
    constructor(x: Number, y: Number, z: Vec1t<out Number>, w: Vec1t<out Number>) : this(x, y, z.x, w.x)
    constructor(x: Vec1t<out Number>, y: Number, z: Vec1t<out Number>, w: Vec1t<out Number>) : this(x.x, y, z.x, w.x)
    constructor(x: Number, y: Vec1t<out Number>, z: Vec1t<out Number>, w: Vec1t<out Number>) : this(x, y.x, z.x, w.x)
    constructor(x: Vec1t<out Number>, y: Vec1t<out Number>, z: Vec1t<out Number>, w: Vec1t<out Number>) : this(x.x, y.x, z.x, w.x)

    constructor(xy: Vec2t<out Number>, z: Number, w: Number) : this(xy.x, xy.y, z, w)
    constructor(xy: Vec2t<out Number>, z: Vec1t<out Number>, w: Number) : this(xy.x, xy.y, z.x, w)
    constructor(xy: Vec2t<out Number>, z: Number, w: Vec1t<out Number>) : this(xy.x, xy.y, z, w.x)
    constructor(xy: Vec2t<out Number>, z: Vec1t<out Number>, w: Vec1t<out Number>) : this(xy.x, xy.y, z.x, w.x)
    constructor(x: Number, yz: Vec2t<out Number>, w: Number) : this(x, yz.x, yz.y, w)
    constructor(x: Vec1t<out Number>, yz: Vec2t<out Number>, w: Number) : this(x.x, yz.x, yz.y, w)
    constructor(x: Number, yz: Vec2t<out Number>, w: Vec1t<out Number>) : this(x, yz.x, yz.y, w.x)
    constructor(x: Vec1t<out Number>, yz: Vec2t<out Number>, w: Vec1t<out Number>) : this(x.x, yz.x, yz.y, w.x)
    constructor(x: Number, y: Number, zw: Vec2t<out Number>) : this(x, y, zw.x, zw.y)
    constructor(x: Vec1t<out Number>, y: Number, zw: Vec2t<out Number>) : this(x.x, y, zw.x, zw.y)
    constructor(x: Number, y: Vec1t<out Number>, zw: Vec2t<out Number>) : this(x, y, zw.x, zw.y)
    constructor(x: Vec1t<out Number>, y: Vec1t<out Number>, zw: Vec2t<out Number>) : this(x.x, y.x, zw.x, zw.y)
    constructor(xyz: Vec3t<out Number>, w: Number) : this(xyz.x, xyz.y, xyz.z, w)
    constructor(xyz: Vec3t<out Number>, w: Vec1t<out Number>) : this(xyz.x, xyz.y, xyz.z, w.x)
    constructor(x: Number, yzw: Vec3t<out Number>) : this(x, yzw.x, yzw.y, yzw.z)
    constructor(x: Vec1t<out Number>, yzw: Vec3t<out Number>) : this(x.x, yzw.x, yzw.y, yzw.z)
    constructor(xy: Vec2t<out Number>, zw: Vec2t<out Number>) : this(xy.x, xy.y, zw.x, zw.y)
    constructor(v: Vec4t<out Number>) : this(v.x, v.y, v.z, v.w)

    constructor(v: Vec1bool) : this(v.x.s, 0, 0, 1)
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

    constructor(list: Iterable<*>, index: Int = 0) : this(list.elementAt(index)!!.toShort, list.elementAt(index + 1)!!.toShort,
            list.elementAt(index + 2)!!.toShort, list.elementAt(index + 3)!!.toShort)

    constructor(bytes: ByteBuffer, index: Int = bytes.pos, oneByteOneShort: Boolean = false) : this(
            if (oneByteOneShort) bytes[index].s else bytes.getShort(index),
            if (oneByteOneShort) bytes[index + 1].s else bytes.getShort(index + Short.BYTES),
            if (oneByteOneShort) bytes[index + 2].s else bytes.getShort(index + Short.BYTES * 2),
            if (oneByteOneShort) bytes[index + 3].s else bytes.getShort(index + Short.BYTES * 3))

    constructor(chars: CharBuffer, index: Int = chars.pos) : this(chars[index].s, chars[index + 1].s, chars[index + 2].s, chars[index + 3].s)
    constructor(shorts: ShortBuffer, index: Int = shorts.pos) : this(shorts[index], shorts[index + 1], shorts[index + 2], shorts[index + 3])
    constructor(ints: IntBuffer, index: Int = ints.pos) : this(ints[index], ints[index + 1], ints[index + 2], ints[index + 3])
    constructor(longs: LongBuffer, index: Int = longs.pos) : this(longs[index], longs[index + 1], longs[index + 2], longs[index + 3])
    constructor(floats: FloatBuffer, index: Int = floats.pos) : this(floats[index], floats[index + 1], floats[index + 2], floats[index + 3])
    constructor(doubles: DoubleBuffer, index: Int = doubles.pos) : this(doubles[index], doubles[index + 1], doubles[index + 2], doubles[index + 3])

    constructor(block: (Int) -> Short) : this(block(0), block(1), block(2), block(3))
    constructor(ptr: Ptr<Short>) : this(ptr[0], ptr[1], ptr[2], ptr[3])


    fun set(bytes: ByteArray, index: Int = 0, oneByteOneShort: Boolean = false, bigEndian: Boolean = true) {
        x = if (oneByteOneShort) bytes[index].s else bytes.getShort(index, bigEndian)
        y = if (oneByteOneShort) bytes[index + 1].s else bytes.getShort(index + Short.BYTES, bigEndian)
        z = if (oneByteOneShort) bytes[index + 2].s else bytes.getShort(index + Short.BYTES * 2, bigEndian)
        w = if (oneByteOneShort) bytes[index + 3].s else bytes.getShort(index + Short.BYTES * 3, bigEndian)
    }

    fun set(bytes: ByteBuffer, index: Int = bytes.pos, oneByteOneShort: Boolean = false) {
        x = if (oneByteOneShort) bytes[index].s else bytes.getShort(index)
        y = if (oneByteOneShort) bytes[index + 1].s else bytes.getShort(index + Short.BYTES)
        z = if (oneByteOneShort) bytes[index + 2].s else bytes.getShort(index + Short.BYTES * 2)
        w = if (oneByteOneShort) bytes[index + 3].s else bytes.getShort(index + Short.BYTES * 3)
    }


    fun put(x: Short, y: Short, z: Short, w: Short) {
        this.x = x
        this.y = y
        this.z = z
        this.w = w
    }

    operator fun invoke(x: Short, y: Short, z: Short, w: Short): Vec4s {
        this.x = x
        this.y = y
        this.z = z
        this.w = w
        return this
    }

    override fun put(x: Number, y: Number, z: Number, w: Number) {
        this.x = x.s
        this.y = y.s
        this.z = z.s
        this.w = w.s
    }

    override operator fun invoke(x: Number, y: Number, z: Number, w: Number): Vec4s {
        this.x = x.s
        this.y = y.s
        this.z = z.s
        this.w = w.s
        return this
    }

    fun to(bytes: ByteArray, index: Int): ByteArray = to(bytes, index, true)
    override fun to(bytes: ByteArray, index: Int, bigEndian: Boolean): ByteArray {
        bytes.putShort(index, x, bigEndian)
        bytes.putShort(index + Short.BYTES, y, bigEndian)
        bytes.putShort(index + Short.BYTES * 2, z, bigEndian)
        bytes.putShort(index + Short.BYTES * 3, w, bigEndian)
        return bytes
    }

    fun toShortArray(): ShortArray = to(ShortArray(length), 0)
    infix fun to(shorts: ShortArray): ShortArray = to(shorts, 0)
    fun to(shorts: ShortArray, index: Int): ShortArray {
        System.arraycopy(array, ofs, shorts, index, length)
        return shorts
    }

    override fun to(buf: ByteBuffer, offset: Int): ByteBuffer {
        buf.putShort(offset, x)
        buf.putShort(offset + Short.BYTES, y)
        buf.putShort(offset + Short.BYTES * 2, z)
        buf.putShort(offset + Short.BYTES * 3, w)
        return buf
    }

    fun toShortBufferStack(): ShortBuffer = to(MemoryStack.stackGet().mallocShort(length), 0)
    infix fun toShortBuffer(stack: MemoryStack): ShortBuffer = to(stack.mallocShort(length), 0)
    fun toShortBuffer(): ShortBuffer = to(ShortBuffer(length), 0)
    infix fun to(buf: ShortBuffer): ShortBuffer = to(buf, buf.pos)
    fun to(buf: ShortBuffer, index: Int): ShortBuffer {
        buf[index] = x
        buf[index + 1] = y
        buf[index + 2] = z
        buf[index + 3] = w
        return buf
    }

    // -- Component accesses --

    operator fun set(index: Int, value: Short) = when (index) {
        0 -> x = value
        1 -> y = value
        2 -> z = value
        3 -> w = value
        else -> throw ArrayIndexOutOfBoundsException()
    }

    override operator fun set(index: Int, value: Number) = when (index) {
        0 -> x = value.s
        1 -> y = value.s
        2 -> z = value.s
        3 -> w = value.s
        else -> throw ArrayIndexOutOfBoundsException()
    }


    // -- Unary arithmetic operators --

    operator fun unaryPlus() = this

    operator fun unaryMinus() = Vec4s(-x.s, -y.s, -z.s, -w.s) // TODO other .main.getS


    // -- Increment main.and decrement operators --

    operator fun inc(res: Vec4s = Vec4s()) = plus(res, this, 1, 1, 1, 1)
    fun incAssign() = plus(this, this, 1, 1, 1, 1)


    operator fun dec(res: Vec4s = Vec4s()) = minus(res, this, 1, 1, 1, 1)
    fun decAssign() = minus(this, this, 1, 1, 1, 1)


    // -- Specific binary arithmetic operators --

    operator fun plus(b: Short) = plus(Vec4s(), this, b, b, b, b)
    operator fun plus(b: Int) = plus(Vec4s(), this, b, b, b, b)
    operator fun plus(b: Vec4s) = plus(Vec4s(), this, b.x, b.y, b.z, b.w)

    fun plus(bX: Short, bY: Short, bZ: Short, bW: Short, res: Vec4s = Vec4s()) = plus(res, this, bX, bY, bZ, bW)
    fun plus(bX: Int, bY: Int, bZ: Int, bW: Int, res: Vec4s = Vec4s()) = plus(res, this, bX, bY, bZ, bW)
    fun plus(b: Short, res: Vec4s = Vec4s()) = plus(res, this, b, b, b, b)
    fun plus(b: Int, res: Vec4s = Vec4s()) = plus(res, this, b, b, b, b)
    fun plus(b: Vec4s, res: Vec4s = Vec4s()) = plus(res, this, b.x, b.y, b.z, b.w)

    fun plusAssign(bX: Short, bY: Short, bZ: Short, bW: Short) = plus(this, this, bX, bY, bZ, bW)
    fun plusAssign(bX: Int, bY: Int, bZ: Int, bW: Int) = plus(this, this, bX, bY, bZ, bW)
    infix operator fun plusAssign(b: Short) {
        plus(this, this, b, b, b, b)
    }

    infix operator fun plusAssign(b: Int) {
        plus(this, this, b, b, b, b)
    }

    infix operator fun plusAssign(b: Vec4s) {
        plus(this, this, b.x, b.y, b.z, b.w)
    }


    operator fun minus(b: Short) = minus(Vec4s(), this, b, b, b, b)
    operator fun minus(b: Int) = minus(Vec4s(), this, b, b, b, b)
    operator fun minus(b: Vec4s) = minus(Vec4s(), this, b.x, b.y, b.z, b.w)

    fun minus(bX: Short, bY: Short, bZ: Short, bW: Short, res: Vec4s = Vec4s()) = minus(res, this, bX, bY, bZ, bW)
    fun minus(bX: Int, bY: Int, bZ: Int, bW: Int, res: Vec4s = Vec4s()) = minus(res, this, bX, bY, bZ, bW)
    fun minus(b: Short, res: Vec4s = Vec4s()) = minus(res, this, b, b, b, b)
    fun minus(b: Int, res: Vec4s = Vec4s()) = minus(res, this, b, b, b, b)
    fun minus(b: Vec4s, res: Vec4s = Vec4s()) = minus(res, this, b.x, b.y, b.z, b.w)

    fun minusAssign(bX: Short, bY: Short, bZ: Short, bW: Short) = minus(this, this, bX, bY, bZ, bW)
    fun minusAssign(bX: Int, bY: Int, bZ: Int, bW: Int) = minus(this, this, bX, bY, bZ, bW)
    infix operator fun minusAssign(b: Short) {
        minus(this, this, b, b, b, b)
    }

    infix operator fun minusAssign(b: Int) {
        minus(this, this, b, b, b, b)
    }

    infix operator fun minusAssign(b: Vec4s) {
        minus(this, this, b.x, b.y, b.z, b.w)
    }


    operator fun times(b: Short) = times(Vec4s(), this, b, b, b, b)
    operator fun times(b: Int) = times(Vec4s(), this, b, b, b, b)
    operator fun times(b: Vec4s) = times(Vec4s(), this, b.x, b.y, b.z, b.w)

    fun times(bX: Short, bY: Short, bZ: Short, bW: Short, res: Vec4s = Vec4s()) = times(res, this, bX, bY, bZ, bW)
    fun times(bX: Int, bY: Int, bZ: Int, bW: Int, res: Vec4s = Vec4s()) = times(res, this, bX, bY, bZ, bW)
    fun times(b: Short, res: Vec4s = Vec4s()) = times(res, this, b, b, b, b)
    fun times(b: Int, res: Vec4s = Vec4s()) = times(res, this, b, b, b, b)
    fun times(b: Vec4s, res: Vec4s = Vec4s()) = times(res, this, b.x, b.y, b.z, b.w)

    fun timesAssign(bX: Short, bY: Short, bZ: Short, bW: Short) = times(this, this, bX, bY, bZ, bW)
    fun timesAssign(bX: Int, bY: Int, bZ: Int, bW: Int) = times(this, this, bX, bY, bZ, bW)
    infix operator fun timesAssign(b: Short) {
        times(this, this, b, b, b, b)
    }

    infix operator fun timesAssign(b: Int) {
        times(this, this, b, b, b, b)
    }

    infix operator fun timesAssign(b: Vec4s) {
        times(this, this, b.x, b.y, b.z, b.w)
    }


    operator fun div(b: Short) = div(Vec4s(), this, b, b, b, b)
    operator fun div(b: Int) = div(Vec4s(), this, b, b, b, b)
    operator fun div(b: Vec4s) = div(Vec4s(), this, b.x, b.y, b.z, b.w)

    fun div(bX: Short, bY: Short, bZ: Short, bW: Short, res: Vec4s = Vec4s()) = div(res, this, bX, bY, bZ, bW)
    fun div(bX: Int, bY: Int, bZ: Int, bW: Int, res: Vec4s = Vec4s()) = div(res, this, bX, bY, bZ, bW)
    fun div(b: Short, res: Vec4s) = div(res, this, b, b, b, b)
    fun div(b: Int, res: Vec4s) = div(res, this, b, b, b, b)
    fun div(b: Vec4s, res: Vec4s) = div(res, this, b.x, b.y, b.z, b.w)

    fun divAssign(bX: Short, bY: Short, bZ: Short, bW: Short) = div(this, this, bX, bY, bZ, bW)
    fun divAssign(bX: Int, bY: Int, bZ: Int, bW: Int) = div(this, this, bX, bY, bZ, bW)
    infix operator fun divAssign(b: Short) {
        div(this, this, b, b, b, b)
    }

    infix operator fun divAssign(b: Int) {
        div(this, this, b, b, b, b)
    }

    infix operator fun divAssign(b: Vec4s) {
        div(this, this, b.x, b.y, b.z, b.w)
    }


    operator fun rem(b: Short) = rem(Vec4s(), this, b, b, b, b)
    operator fun rem(b: Int) = rem(Vec4s(), this, b, b, b, b)
    operator fun rem(b: Vec4s) = rem(Vec4s(), this, b.x, b.y, b.z, b.w)

    fun rem(bX: Short, bY: Short, bZ: Short, bW: Short, res: Vec4s = Vec4s()) = rem(res, this, bX, bY, bZ, bW)
    fun rem(bX: Int, bY: Int, bZ: Int, bW: Int, res: Vec4s = Vec4s()) = rem(res, this, bX, bY, bZ, bW)
    fun rem(b: Short, res: Vec4s) = rem(res, this, b, b, b, b)
    fun rem(b: Int, res: Vec4s) = rem(res, this, b, b, b, b)
    fun rem(b: Vec4s, res: Vec4s) = rem(res, this, b.x, b.y, b.z, b.w)

    fun remAssign(bX: Short, bY: Short, bZ: Short, bW: Short) = rem(this, this, bX, bY, bZ, bW)
    fun remAssign(bX: Int, bY: Int, bZ: Int, bW: Int) = rem(this, this, bX, bY, bZ, bW)
    infix operator fun remAssign(b: Short) {
        rem(this, this, b, b, b, b)
    }

    infix operator fun remAssign(b: Int) {
        rem(this, this, b, b, b, b)
    }

    infix operator fun remAssign(b: Vec4s) {
        rem(this, this, b.x, b.y, b.z, b.w)
    }


    // -- Generic binary arithmetic operators --

    operator fun plus(b: Number) = plus(Vec4s(), this, b.s, b.s, b.s, b.s)
    operator fun plus(b: Vec4t<out Number>) = plus(Vec4s(), this, b.x.s, b.y.s, b.z.s, b.w.s)

    fun plus(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4s = Vec4s()) = plus(res, this, bX.s, bY.s, bZ.s, bW.s)
    fun plus(b: Number, res: Vec4s = Vec4s()) = plus(res, this, b.s, b.s, b.s, b.s)
    fun plus(b: Vec4t<out Number>, res: Vec4s = Vec4s()) = plus(res, this, b.x.s, b.y.s, b.z.s, b.w.s)

    fun plusAssign(bX: Number, bY: Number, bZ: Number, bW: Number) = plus(this, this, bX.s, bY.s, bZ.s, bW.s)
    infix operator fun plusAssign(b: Number) {
        plus(this, this, b.s, b.s, b.s, b.s)
    }

    infix operator fun plusAssign(b: Vec4t<out Number>) {
        plus(this, this, b.x.s, b.y.s, b.z.s, b.w.s)
    }


    operator fun minus(b: Number) = minus(Vec4s(), this, b.s, b.s, b.s, b.s)
    operator fun minus(b: Vec4t<out Number>) = minus(Vec4s(), this, b.x.s, b.y.s, b.z.s, b.w.s)

    fun minus(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4s = Vec4s()) = minus(res, this, bX.s, bY.s, bZ.s, bW.s)
    fun minus(b: Number, res: Vec4s = Vec4s()) = minus(res, this, b.s, b.s, b.s, b.s)
    fun minus(b: Vec4t<out Number>, res: Vec4s = Vec4s()) = minus(res, this, b.x.s, b.y.s, b.z.s, b.w.s)

    fun minusAssign(bX: Number, bY: Number, bZ: Number, bW: Number) = minus(this, this, bX.s, bY.s, bZ.s, bW.s)
    infix operator fun minusAssign(b: Number) {
        minus(this, this, b.s, b.s, b.s, b.s)
    }

    infix operator fun minusAssign(b: Vec4t<out Number>) {
        minus(this, this, b.x.s, b.y.s, b.z.s, b.w.s)
    }


    operator fun times(b: Number) = times(Vec4s(), this, b.s, b.s, b.s, b.s)
    operator fun times(b: Vec4t<out Number>) = times(Vec4s(), this, b.x.s, b.y.s, b.z.s, b.w.s)

    fun times(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4s = Vec4s()) = times(res, this, bX.s, bY.s, bZ.s, bW.s)
    fun times(b: Number, res: Vec4s = Vec4s()) = times(res, this, b.s, b.s, b.s, b.s)
    fun times(b: Vec4t<out Number>, res: Vec4s = Vec4s()) = times(res, this, b.x.s, b.y.s, b.z.s, b.w.s)

    fun timesAssign(bX: Number, bY: Number, bZ: Number, bW: Number) = times(this, this, bX.s, bY.s, bZ.s, bW.s)
    infix operator fun timesAssign(b: Number) {
        times(this, this, b.s, b.s, b.s, b.s)
    }

    infix operator fun timesAssign(b: Vec4t<out Number>) {
        times(this, this, b.x.s, b.y.s, b.z.s, b.w.s)
    }


    operator fun div(b: Number) = div(Vec4s(), this, b.s, b.s, b.s, b.s)
    operator fun div(b: Vec4t<out Number>) = div(Vec4s(), this, b.x.s, b.y.s, b.z.s, b.w.s)

    fun div(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4s = Vec4s()) = div(res, this, bX.s, bY.s, bZ.s, bW.s)
    fun div(b: Number, res: Vec4s) = div(res, this, b.s, b.s, b.s, b.s)
    fun div(b: Vec4t<out Number>, res: Vec4s) = div(res, this, b.x.s, b.y.s, b.z.s, b.w.s)

    fun divAssign(bX: Number, bY: Number, bZ: Number, bW: Number) = div(this, this, bX.s, bY.s, bZ.s, bW.s)
    infix operator fun divAssign(b: Number) {
        div(this, this, b.s, b.s, b.s, b.s)
    }

    infix operator fun divAssign(b: Vec4t<out Number>) {
        div(this, this, b.x.s, b.y.s, b.z.s, b.w.s)
    }


    operator fun rem(b: Number) = rem(Vec4s(), this, b.s, b.s, b.s, b.s)
    operator fun rem(b: Vec4t<out Number>) = rem(Vec4s(), this, b.x.s, b.y.s, b.z.s, b.w.s)

    fun rem(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4s = Vec4s()) = rem(res, this, bX.s, bY.s, bZ.s, bW.s)
    fun rem(b: Number, res: Vec4s) = rem(res, this, b.s, b.s, b.s, b.s)
    fun rem(b: Vec4t<out Number>, res: Vec4s) = rem(res, this, b.x.s, b.y.s, b.z.s, b.w.s)

    fun remAssign(bX: Number, bY: Number, bZ: Number, bW: Number) = rem(this, this, bX.s, bY.s, bZ.s, bW.s)
    infix operator fun remAssign(b: Number) {
        rem(this, this, b.s, b.s, b.s, b.s)
    }

    infix operator fun remAssign(b: Vec4t<out Number>) {
        rem(this, this, b.x.s, b.y.s, b.z.s, b.w.s)
    }


    // -- Specific bitwise operators --

    infix fun and(b: Short) = and(Vec4s(), this, b, b, b, b)
    infix fun and(b: Int) = and(Vec4s(), this, b, b, b, b)
    infix fun and(b: Vec4s) = and(Vec4s(), this, b.x, b.y, b.z, b.w)

    infix fun andAssign(b: Short) = and(this, this, b, b, b, b)
    infix fun andAssign(b: Int) = and(this, this, b, b, b, b)
    infix fun andAssign(b: Vec4s) = and(this, this, b.x, b.y, b.z, b.w)

    fun and(b: Short, res: Vec4s) = and(res, this, b, b, b, b)
    fun and(b: Int, res: Vec4s) = and(res, this, b, b, b, b)
    fun and(b: Vec4s, res: Vec4s) = and(res, this, b.x, b.y, b.z, b.w)

    fun and(bX: Short, bY: Short, bZ: Short, bW: Short, res: Vec4s = Vec4s()) = and(res, this, bX, bY, bZ, bW)
    fun and(bX: Int, bY: Int, bZ: Int, bW: Int, res: Vec4s = Vec4s()) = and(res, this, bX, bY, bZ, bW)

    fun andAssign(bX: Short, bY: Short, bZ: Short, bW: Short) = and(this, this, bX, bY, bZ, bW)
    fun andAssign(bX: Int, bY: Int, bZ: Int, bW: Int) = and(this, this, bX, bY, bZ, bW)


    infix fun or(b: Short) = or(Vec4s(), this, b, b, b, b)
    infix fun or(b: Int) = or(Vec4s(), this, b, b, b, b)
    infix fun or(b: Vec4s) = or(Vec4s(), this, b.x, b.y, b.z, b.w)

    infix fun orAssign(b: Short) = or(this, this, b, b, b, b)
    infix fun orAssign(b: Int) = or(this, this, b, b, b, b)
    infix fun orAssign(b: Vec4s) = or(this, this, b.x, b.y, b.z, b.w)

    fun or(b: Short, res: Vec4s) = or(res, this, b, b, b, b)
    fun or(b: Int, res: Vec4s) = or(res, this, b, b, b, b)
    fun or(b: Vec4s, res: Vec4s) = or(res, this, b.x, b.y, b.z, b.w)

    fun or(bX: Short, bY: Short, bZ: Short, bW: Short, res: Vec4s = Vec4s()) = or(res, this, bX, bY, bZ, bW)
    fun or(bX: Int, bY: Int, bZ: Int, bW: Int, res: Vec4s = Vec4s()) = or(res, this, bX, bY, bZ, bW)

    fun orAssign(bX: Short, bY: Short, bZ: Short, bW: Short) = or(this, this, bX, bY, bZ, bW)
    fun orAssign(bX: Int, bY: Int, bZ: Int, bW: Int) = or(this, this, bX, bY, bZ, bW)


    infix fun xor(b: Short) = xor(Vec4s(), this, b, b, b, b)
    infix fun xor(b: Int) = xor(Vec4s(), this, b, b, b, b)
    infix fun xor(b: Vec4s) = xor(Vec4s(), this, b.x, b.y, b.z, b.w)

    infix fun xorAssign(b: Short) = xor(this, this, b, b, b, b)
    infix fun xorAssign(b: Int) = xor(this, this, b, b, b, b)
    infix fun xorAssign(b: Vec4s) = xor(this, this, b.x, b.y, b.z, b.w)

    fun xor(b: Short, res: Vec4s) = xor(res, this, b, b, b, b)
    fun xor(b: Int, res: Vec4s) = xor(res, this, b, b, b, b)
    fun xor(b: Vec4s, res: Vec4s) = xor(res, this, b.x, b.y, b.z, b.w)

    fun xor(bX: Short, bY: Short, bZ: Short, bW: Short, res: Vec4s = Vec4s()) = xor(res, this, bX, bY, bZ, bW)
    fun xor(bX: Int, bY: Int, bZ: Int, bW: Int, res: Vec4s = Vec4s()) = xor(res, this, bX, bY, bZ, bW)

    fun xorAssign(bX: Short, bY: Short, bZ: Short, bW: Short) = xor(this, this, bX, bY, bZ, bW)
    fun xorAssign(bX: Int, bY: Int, bZ: Int, bW: Int) = xor(this, this, bX, bY, bZ, bW)


    infix fun shl(b: Short) = shl(Vec4s(), this, b, b, b, b)
    infix fun shl(b: Int) = shl(Vec4s(), this, b, b, b, b)
    infix fun shl(b: Vec4s) = shl(Vec4s(), this, b.x, b.y, b.z, b.w)

    infix fun shlAssign(b: Short) = shl(this, this, b, b, b, b)
    infix fun shlAssign(b: Int) = shl(this, this, b, b, b, b)
    infix fun shlAssign(b: Vec4s) = shl(this, this, b.x, b.y, b.z, b.w)

    fun shl(b: Short, res: Vec4s) = shl(res, this, b, b, b, b)
    fun shl(b: Int, res: Vec4s) = shl(res, this, b, b, b, b)
    fun shl(b: Vec4s, res: Vec4s) = shl(res, this, b.x, b.y, b.z, b.w)

    fun shl(bX: Short, bY: Short, bZ: Short, bW: Short, res: Vec4s = Vec4s()) = shl(res, this, bX, bY, bZ, bW)
    fun shl(bX: Int, bY: Int, bZ: Int, bW: Int, res: Vec4s = Vec4s()) = shl(res, this, bX, bY, bZ, bW)

    fun shlAssign(bX: Short, bY: Short, bZ: Short, bW: Short) = shl(this, this, bX, bY, bZ, bW)
    fun shlAssign(bX: Int, bY: Int, bZ: Int, bW: Int) = shl(this, this, bX, bY, bZ, bW)


    infix fun shr(b: Short) = shr(Vec4s(), this, b, b, b, b)
    infix fun shr(b: Int) = shr(Vec4s(), this, b, b, b, b)
    infix fun shr(b: Vec4s) = shr(Vec4s(), this, b.x, b.y, b.z, b.w)

    infix fun shrAssign(b: Short) = shr(this, this, b, b, b, b)
    infix fun shrAssign(b: Int) = shr(this, this, b, b, b, b)
    infix fun shrAssign(b: Vec4s) = shr(this, this, b.x, b.y, b.z, b.w)

    fun shr(b: Short, res: Vec4s) = shr(res, this, b, b, b, b)
    fun shr(b: Int, res: Vec4s) = shr(res, this, b, b, b, b)
    fun shr(b: Vec4s, res: Vec4s) = shr(res, this, b.x, b.y, b.z, b.w)

    fun shr(bX: Short, bY: Short, bZ: Short, bW: Short, res: Vec4s = Vec4s()) = shr(res, this, bX, bY, bZ, bW)
    fun shr(bX: Int, bY: Int, bZ: Int, bW: Int, res: Vec4s = Vec4s()) = shr(res, this, bX, bY, bZ, bW)

    fun shrAssign(bX: Short, bY: Short, bZ: Short, bW: Short) = shr(this, this, bX, bY, bZ, bW)
    fun shrAssign(bX: Int, bY: Int, bZ: Int, bW: Int) = shr(this, this, bX, bY, bZ, bW)


    fun inv(res: Vec4s = Vec4s()) = inv(res, this)
    fun invAssign() = inv(this, this)


    // -- Generic bitwise operators --

    infix fun and(b: Number) = and(Vec4s(), this, b.s, b.s, b.s, b.s)
    infix fun and(b: Vec4t<out Number>) = and(Vec4s(), this, b.x.s, b.y.s, b.z.s, b.w.s)

    infix fun andAssign(b: Number) = and(this, this, b.s, b.s, b.s, b.s)
    infix fun andAssign(b: Vec4t<out Number>) = and(this, this, b.x.s, b.y.s, b.z.s, b.w.s)

    fun and(b: Number, res: Vec4s) = and(res, this, b.s, b.s, b.s, b.s)
    fun and(b: Vec4t<out Number>, res: Vec4s) = and(res, this, b.x.s, b.y.s, b.z.s, b.w.s)

    fun and(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4s = Vec4s()) = and(res, this, bX.s, bY.s, bZ.s, bW.s)

    fun andAssign(bX: Number, bY: Number, bZ: Number, bW: Number) = and(this, this, bX.s, bY.s, bZ.s, bW.s)


    infix fun or(b: Number) = or(Vec4s(), this, b.s, b.s, b.s, b.s)
    infix fun or(b: Vec4t<out Number>) = or(Vec4s(), this, b.x.s, b.y.s, b.z.s, b.w.s)

    infix fun orAssign(b: Number) = or(this, this, b.s, b.s, b.s, b.s)
    infix fun orAssign(b: Vec4t<out Number>) = or(this, this, b.x.s, b.y.s, b.z.s, b.w.s)

    fun or(b: Number, res: Vec4s) = or(res, this, b.s, b.s, b.s, b.s)
    fun or(b: Vec4t<out Number>, res: Vec4s) = or(res, this, b.x.s, b.y.s, b.z.s, b.w.s)

    fun or(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4s = Vec4s()) = or(res, this, bX.s, bY.s, bZ.s, bW.s)

    fun orAssign(bX: Number, bY: Number, bZ: Number, bW: Number) = or(this, this, bX.s, bY.s, bZ.s, bW.s)


    infix fun xor(b: Number) = xor(Vec4s(), this, b.s, b.s, b.s, b.s)
    infix fun xor(b: Vec4t<out Number>) = xor(Vec4s(), this, b.x.s, b.y.s, b.z.s, b.w.s)

    infix fun xorAssign(b: Number) = xor(this, this, b.s, b.s, b.s, b.s)
    infix fun xorAssign(b: Vec4t<out Number>) = xor(this, this, b.x.s, b.y.s, b.z.s, b.w.s)

    fun xor(b: Number, res: Vec4s) = xor(res, this, b.s, b.s, b.s, b.s)
    fun xor(b: Vec4t<out Number>, res: Vec4s) = xor(res, this, b.x.s, b.y.s, b.z.s, b.w.s)

    fun xor(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4s = Vec4s()) = xor(res, this, bX.s, bY.s, bZ.s, bW.s)

    fun xorAssign(bX: Number, bY: Number, bZ: Number, bW: Number) = xor(this, this, bX.s, bY.s, bZ.s, bW.s)


    infix fun shl(b: Number) = shl(Vec4s(), this, b.s, b.s, b.s, b.s)
    infix fun shl(b: Vec4t<out Number>) = shl(Vec4s(), this, b.x.s, b.y.s, b.z.s, b.w.s)

    infix fun shlAssign(b: Number) = shl(this, this, b.s, b.s, b.s, b.s)
    infix fun shlAssign(b: Vec4t<out Number>) = shl(this, this, b.x.s, b.y.s, b.z.s, b.w.s)

    fun shl(b: Number, res: Vec4s) = shl(res, this, b.s, b.s, b.s, b.s)
    fun shl(b: Vec4t<out Number>, res: Vec4s) = shl(res, this, b.x.s, b.y.s, b.z.s, b.w.s)

    fun shl(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4s = Vec4s()) = shl(res, this, bX.s, bY.s, bZ.s, bW.s)

    fun shlAssign(bX: Number, bY: Number, bZ: Number, bW: Number) = shl(this, this, bX.s, bY.s, bZ.s, bW.s)


    infix fun shr(b: Number) = shr(Vec4s(), this, b.s, b.s, b.s, b.s)
    infix fun shr(b: Vec4t<out Number>) = shr(Vec4s(), this, b.x.s, b.y.s, b.z.s, b.w.s)

    infix fun shrAssign(b: Number) = shr(this, this, b.s, b.s, b.s, b.s)
    infix fun shrAssign(b: Vec4t<out Number>) = shr(this, this, b.x.s, b.y.s, b.z.s, b.w.s)

    fun shr(b: Number, res: Vec4s) = shr(res, this, b.s, b.s, b.s, b.s)
    fun shr(b: Vec4t<out Number>, res: Vec4s) = shr(res, this, b.x.s, b.y.s, b.z.s, b.w.s)

    fun shr(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4s = Vec4s()) = shr(res, this, bX.s, bY.s, bZ.s, bW.s)

    fun shrAssign(bX: Number, bY: Number, bZ: Number, bW: Number) = shr(this, this, bX.s, bY.s, bZ.s, bW.s)


    infix fun allLessThan(s: Short): Boolean = x < s && y < s && z < s && w < s
    infix fun anyLessThan(s: Short): Boolean = x < s || y < s || z < s || w < s
    infix fun lessThan(s: Short): Vec4bool = Vec4bool { get(it) < s }

    infix fun allLessThanEqual(s: Short): Boolean = x <= s && y <= s && z <= s && w <= s
    infix fun anyLessThanEqual(s: Short): Boolean = x <= s || y <= s || z <= s || w <= s
    infix fun lessThanEqual(s: Short): Vec4bool = Vec4bool { get(it) <= s }

    infix fun allEqual(s: Short): Boolean = x == s && y == s && z == s && w == s
    infix fun anyEqual(s: Short): Boolean = x == s || y == s || z == s || w == s
    infix fun equal(s: Short): Vec4bool = Vec4bool { get(it) == s }

    infix fun allNotEqual(s: Short): Boolean = x != s && y != s && z != s && w != s
    infix fun anyNotEqual(s: Short): Boolean = x != s || y != s || z != s || w != s
    infix fun notEqual(s: Short): Vec4bool = Vec4bool { get(it) != s }

    infix fun allGreaterThan(s: Short): Boolean = x > s && y > s && z > s && w > s
    infix fun anyGreaterThan(s: Short): Boolean = x > s || y > s || z > s || w > s
    infix fun greaterThan(s: Short): Vec4bool = Vec4bool { get(it) > s }

    infix fun allGreaterThanEqual(s: Short): Boolean = x >= s && y >= s && z >= s && w >= s
    infix fun anyGreaterThanEqual(s: Short): Boolean = x >= s || y >= s || z >= s || w >= s
    infix fun greaterThanEqual(s: Short): Vec4bool = Vec4bool { get(it) >= s }


    infix fun allLessThan(v: Vec4s): Boolean = x < v.x && y < v.y && z < v.z && w < v.w
    infix fun anyLessThan(v: Vec4s): Boolean = x < v.x || y < v.y || z < v.z || w < v.w
    infix fun lessThan(v: Vec4s): Vec4bool = Vec4bool { get(it) < v[it] }

    infix fun allLessThanEqual(v: Vec4s): Boolean = x <= v.x && y <= v.y && z <= v.z && w <= v.w
    infix fun anyLessThanEqual(v: Vec4s): Boolean = x <= v.x || y <= v.y || z <= v.z || w <= v.w
    infix fun lessThanEqual(v: Vec4s): Vec4bool = Vec4bool { get(it) <= v[it] }

    infix fun allEqual(v: Vec4s): Boolean = x == v.x && y == v.y && z == v.z && w == v.w
    infix fun anyEqual(v: Vec4s): Boolean = x == v.x || y == v.y || z == v.z || w == v.w
    infix fun equal(v: Vec4s): Vec4bool = Vec4bool { get(it) == v[it] }

    infix fun allNotEqual(v: Vec4s): Boolean = x != v.x && y != v.y && z != v.z && w != v.w
    infix fun anyNotEqual(v: Vec4s): Boolean = x != v.x || y != v.y || z != v.z || w != v.w
    infix fun notEqual(v: Vec4s): Vec4bool = Vec4bool { get(it) != v[it] }

    infix fun allGreaterThan(v: Vec4s): Boolean = x > v.x && y > v.y && z > v.z && w > v.w
    infix fun anyGreaterThan(v: Vec4s): Boolean = x > v.x || y > v.y || z > v.z || w > v.w
    infix fun greaterThan(v: Vec4s): Vec4bool = Vec4bool { get(it) > v[it] }

    infix fun allGreaterThanEqual(v: Vec4s): Boolean = x >= v.x && y >= v.y && z >= v.z && w >= v.w
    infix fun anyGreaterThanEqual(v: Vec4s): Boolean = x >= v.x || y >= v.y || z >= v.z || w >= v.w
    infix fun greaterThanEqual(v: Vec4s): Vec4bool = Vec4bool { get(it) >= v[it] }


    companion object : vec4s_operators {
        const val length = Vec4t.length
        @JvmField
        val size = length * Short.BYTES

        @JvmStatic
        fun fromPointer(ptr: Ptr<Short>) = Vec4s(ptr)
    }

    override fun size() = size


    override fun equals(other: Any?) = other is Vec4s && this[0] == other[0] && this[1] == other[1] && this[2] == other[2] && this[3] == other[3]
    override fun hashCode() = 31 * (31 * (31 * x.hashCode() + y.hashCode()) + z.hashCode()) + w.hashCode()

    @JvmOverloads
    fun print(name: String = "", stream: PrintStream = System.out) = stream.print("$name$this")

    @JvmOverloads
    fun println(name: String = "", stream: PrintStream = System.out) = stream.println("$name$this")

    override fun toString(): String = "($x, $y, $z, $w)"
}