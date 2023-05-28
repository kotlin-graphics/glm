package glm_.vec4

import glm_.*
import glm_.vec1.Vec1bool
import glm_.vec1.Vec1l
import glm_.vec1.Vec1t
import glm_.vec2.Vec2bool
import glm_.vec2.Vec2l
import glm_.vec2.Vec2t
import glm_.vec3.Vec3bool
import glm_.vec3.Vec3l
import glm_.vec3.Vec3t
import glm_.vec4.operators.vec4l_operators
import kool.*
import org.lwjgl.system.MemoryStack
import java.io.PrintStream
import java.nio.*

/**
 * Created by elect on 09/10/16.
 */

class Vec4l(@JvmField var ofs: Int, @JvmField var array: LongArray) : Vec4t<Long>, ToBuffer {

    inline var x: Long
        get() = array[ofs]
        set(value) = array.set(ofs, value)
    inline var y: Long
        get() = array[ofs + 1]
        set(value) = array.set(ofs + 1, value)
    inline var z: Long
        get() = array[ofs + 2]
        set(value) = array.set(ofs + 2, value)
    inline var w: Long
        get() = array[ofs + 3]
        set(value) = array.set(ofs + 3, value)

    // -- Implicit basic constructors --

    constructor() : this(0)
    constructor(v: Vec4l) : this(v.x, v.y, v.z, v.w)
    constructor(v: Vec3l) : this(v.x, v.y, v.z, 0)
    constructor(v: Vec2l) : this(v.x, v.y, 0, 0)

    // -- Explicit basic constructors --

    constructor(x: Long) : this(x, x, x, x)
    constructor(x: Long, y: Long, z: Long, w: Long) : this(0, longArrayOf(x, y, z, w))

    // -- Conversion scalar constructors --

    constructor(v: Vec1t<out Number>) : this(v._x)

    // Explicit conversions (From section 5.4.1 Conversion and scalar constructors of GLSL 1.30.08 specification)

    constructor(v: Number) : this(v.L)
    constructor(x: Number, y: Number, z: Number, w: Number) : this(x.L, y.L, z.L, w.L)

    constructor(x: Vec1t<out Number>, y: Number, z: Number, w: Number) : this(x._x, y, z, w)
    constructor(x: Number, y: Vec1t<out Number>, z: Number, w: Number) : this(x, y._x, z, w)
    constructor(x: Vec1t<out Number>, y: Vec1t<out Number>, z: Number, w: Number) : this(x._x, y._x, z, w)
    constructor(x: Number, y: Number, z: Vec1t<out Number>, w: Number) : this(x, y, z._x, w)
    constructor(x: Vec1t<out Number>, y: Number, z: Vec1t<out Number>, w: Number) : this(x._x, y, z._x, w)
    constructor(x: Number, y: Vec1t<out Number>, z: Vec1t<out Number>, w: Number) : this(x, y._x, z._x, w)
    constructor(x: Vec1t<out Number>, y: Vec1t<out Number>, z: Vec1t<out Number>, w: Number) : this(x._x, y._x, z._x, w)
    constructor(x: Vec1t<out Number>, y: Number, z: Number, w: Vec1t<out Number>) : this(x._x, y, z, w._x)
    constructor(x: Number, y: Vec1t<out Number>, z: Number, w: Vec1t<out Number>) : this(x, y._x, z, w._x)
    constructor(x: Vec1t<out Number>, y: Vec1t<out Number>, z: Number, w: Vec1t<out Number>) : this(x._x, y._x, z, w._x)
    constructor(x: Number, y: Number, z: Vec1t<out Number>, w: Vec1t<out Number>) : this(x, y, z._x, w._x)
    constructor(x: Vec1t<out Number>, y: Number, z: Vec1t<out Number>, w: Vec1t<out Number>) : this(x._x, y, z._x, w._x)
    constructor(x: Number, y: Vec1t<out Number>, z: Vec1t<out Number>, w: Vec1t<out Number>) : this(x, y._x, z._x, w._x)
    constructor(x: Vec1t<out Number>, y: Vec1t<out Number>, z: Vec1t<out Number>, w: Vec1t<out Number>) : this(x._x, y._x, z._x, w._x)

    constructor(xy: Vec2t<out Number>, z: Number, w: Number) : this(xy._x, xy._y, z, w)
    constructor(xy: Vec2t<out Number>, z: Vec1t<out Number>, w: Number) : this(xy._x, xy._y, z._x, w)
    constructor(xy: Vec2t<out Number>, z: Number, w: Vec1t<out Number>) : this(xy._x, xy._y, z, w._x)
    constructor(xy: Vec2t<out Number>, z: Vec1t<out Number>, w: Vec1t<out Number>) : this(xy._x, xy._y, z._x, w._x)
    constructor(x: Number, yz: Vec2t<out Number>, w: Number) : this(x, yz._x, yz._y, w)
    constructor(x: Vec1t<out Number>, yz: Vec2t<out Number>, w: Number) : this(x._x, yz._x, yz._y, w)
    constructor(x: Number, yz: Vec2t<out Number>, w: Vec1t<out Number>) : this(x, yz._x, yz._y, w._x)
    constructor(x: Vec1t<out Number>, yz: Vec2t<out Number>, w: Vec1t<out Number>) : this(x._x, yz._x, yz._y, w._x)
    constructor(x: Number, y: Number, zw: Vec2t<out Number>) : this(x, y, zw._x, zw._y)
    constructor(x: Vec1t<out Number>, y: Number, zw: Vec2t<out Number>) : this(x._x, y, zw._x, zw._y)
    constructor(x: Number, y: Vec1t<out Number>, zw: Vec2t<out Number>) : this(x, y, zw._x, zw._y)
    constructor(x: Vec1t<out Number>, y: Vec1t<out Number>, zw: Vec2t<out Number>) : this(x._x, y._x, zw._x, zw._y)
    constructor(xyz: Vec3t<out Number>, w: Number) : this(xyz._x, xyz._y, xyz._z, w)
    constructor(xyz: Vec3t<out Number>, w: Vec1t<out Number>) : this(xyz._x, xyz._y, xyz._z, w._x)
    constructor(x: Number, yzw: Vec3t<out Number>) : this(x, yzw._x, yzw._y, yzw._z)
    constructor(x: Vec1t<out Number>, yzw: Vec3t<out Number>) : this(x._x, yzw._x, yzw._y, yzw._z)
    constructor(xy: Vec2t<out Number>, zw: Vec2t<out Number>) : this(xy._x, xy._y, zw._x, zw._y)
    constructor(v: Vec4t<out Number>) : this(v._x, v._y, v._z, v._w)


    constructor(v: Vec1l) : this(v.x)
    constructor(x: Vec1l, y: Long, z: Long, w: Long) : this(x.x, y, z, w)
    constructor(x: Long, y: Vec1l, z: Long, w: Long) : this(x, y.x, z, w)
    constructor(x: Long, y: Long, z: Vec1l, w: Long) : this(x, y, z.x, w)
    constructor(x: Long, y: Long, z: Long, w: Vec1l) : this(x, y, z, w.x)
    constructor(x: Vec1l, y: Vec1l, z: Vec1l, w: Vec1l) : this(x.x, y.x, z.x, w.x)


    constructor(xy: Vec2l, z: Long, w: Long) : this(xy.x, xy.y, z, w)
    constructor(x: Long, yz: Vec2l, w: Long) : this(x, yz.x, yz.y, w)
    constructor(x: Long, y: Long, zw: Vec2l) : this(x, y, zw.x, zw.y)
    constructor(xy: Vec2l, zw: Vec2l) : this(xy.x, xy.y, zw.x, zw.y)

    constructor(xyz: Vec3l, w: Long) : this(xyz.x, xyz.y, xyz.z, w)
    constructor(x: Long, yzw: Vec3l) : this(x, yzw.x, yzw.y, yzw.z)

    constructor(v: Vec1bool) : this(v.x.L, 0, 0, 1)
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
    // clashing
//    constructor(ptr: Ptr<Long>) : this(ptr[0], ptr[1], ptr[2], ptr[3])


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

    operator fun invoke(x: Long, y: Long, z: Long, w: Long): Vec4l {
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

    override operator fun invoke(x: Number, y: Number, z: Number, w: Number): Vec4l {
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

    fun toLongBufferStack(): LongBuffer = to(MemoryStack.stackGet().mallocLong(length), 0)
    infix fun toLongBuffer(stack: MemoryStack): LongBuffer = to(stack.mallocLong(length), 0)
    fun toLongBuffer(): LongBuffer = to(LongBuffer(length), 0)
    infix fun to(buf: LongBuffer): LongBuffer = to(buf, buf.pos)
    fun to(buf: LongBuffer, index: Int): LongBuffer {
        buf[index] = x
        buf[index + 1] = y
        buf[index + 2] = z
        buf[index + 3] = w
        return buf
    }

    infix fun to(ptr: Ptr<Long>) {
        ptr[0] = x
        ptr[1] = y
        ptr[2] = z
        ptr[3] = w
    }

    // -- Component accesses --

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
    operator fun plus(b: Vec4t<out Number>) = plus(Vec4l(), this, b._x.L, b._y.L, b._z.L, b._w.L)

    fun plus(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4l = Vec4l()) = plus(res, this, bX.L, bY.L, bZ.L, bW.L)
    fun plus(b: Number, res: Vec4l = Vec4l()) = plus(res, this, b.L, b.L, b.L, b.L)
    fun plus(b: Vec4t<out Number>, res: Vec4l = Vec4l()) = plus(res, this, b._x.L, b._y.L, b._z.L, b._w.L)

    fun plusAssign(bX: Number, bY: Number, bZ: Number, bW: Number) = plus(this, this, bX.L, bY.L, bZ.L, bW.L)
    infix operator fun plusAssign(b: Number) {
        plus(this, this, b.L, b.L, b.L, b.L)
    }

    infix operator fun plusAssign(b: Vec4t<out Number>) {
        plus(this, this, b._x.L, b._y.L, b._z.L, b._w.L)
    }


    operator fun minus(b: Number) = minus(Vec4l(), this, b.L, b.L, b.L, b.L)
    operator fun minus(b: Vec4t<out Number>) = minus(Vec4l(), this, b._x.L, b._y.L, b._z.L, b._w.L)

    fun minus(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4l = Vec4l()) = minus(res, this, bX.L, bY.L, bZ.L, bW.L)
    fun minus(b: Number, res: Vec4l = Vec4l()) = minus(res, this, b.L, b.L, b.L, b.L)
    fun minus(b: Vec4t<out Number>, res: Vec4l = Vec4l()) = minus(res, this, b._x.L, b._y.L, b._z.L, b._w.L)

    fun minusAssign(bX: Number, bY: Number, bZ: Number, bW: Number) = minus(this, this, bX.L, bY.L, bZ.L, bW.L)
    infix operator fun minusAssign(b: Number) {
        minus(this, this, b.L, b.L, b.L, b.L)
    }

    infix operator fun minusAssign(b: Vec4t<out Number>) {
        minus(this, this, b._x.L, b._y.L, b._z.L, b._w.L)
    }


    operator fun times(b: Number) = times(Vec4l(), this, b.L, b.L, b.L, b.L)
    operator fun times(b: Vec4t<out Number>) = times(Vec4l(), this, b._x.L, b._y.L, b._z.L, b._w.L)

    fun times(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4l = Vec4l()) = times(res, this, bX.L, bY.L, bZ.L, bW.L)
    fun times(b: Number, res: Vec4l = Vec4l()) = times(res, this, b.L, b.L, b.L, b.L)
    fun times(b: Vec4t<out Number>, res: Vec4l = Vec4l()) = times(res, this, b._x.L, b._y.L, b._z.L, b._w.L)

    fun timesAssign(bX: Number, bY: Number, bZ: Number, bW: Number) = times(this, this, bX.L, bY.L, bZ.L, bW.L)
    infix operator fun timesAssign(b: Number) {
        times(this, this, b.L, b.L, b.L, b.L)
    }

    infix operator fun timesAssign(b: Vec4t<out Number>) {
        times(this, this, b._x.L, b._y.L, b._z.L, b._w.L)
    }


    operator fun div(b: Number) = div(Vec4l(), this, b.L, b.L, b.L, b.L)
    operator fun div(b: Vec4t<out Number>) = div(Vec4l(), this, b._x.L, b._y.L, b._z.L, b._w.L)

    fun div(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4l = Vec4l()) = div(res, this, bX.L, bY.L, bZ.L, bW.L)
    fun div(b: Number, res: Vec4l) = div(res, this, b.L, b.L, b.L, b.L)
    fun div(b: Vec4t<out Number>, res: Vec4l) = div(res, this, b._x.L, b._y.L, b._z.L, b._w.L)

    fun divAssign(bX: Number, bY: Number, bZ: Number, bW: Number) = div(this, this, bX.L, bY.L, bZ.L, bW.L)
    infix operator fun divAssign(b: Number) {
        div(this, this, b.L, b.L, b.L, b.L)
    }

    infix operator fun divAssign(b: Vec4t<out Number>) {
        div(this, this, b._x.L, b._y.L, b._z.L, b._w.L)
    }


    operator fun rem(b: Number) = rem(Vec4l(), this, b.L, b.L, b.L, b.L)
    operator fun rem(b: Vec4t<out Number>) = rem(Vec4l(), this, b._x.L, b._y.L, b._z.L, b._w.L)

    fun rem(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4l = Vec4l()) = rem(res, this, bX.L, bY.L, bZ.L, bW.L)
    fun rem(b: Number, res: Vec4l) = rem(res, this, b.L, b.L, b.L, b.L)
    fun rem(b: Vec4t<out Number>, res: Vec4l) = rem(res, this, b._x.L, b._y.L, b._z.L, b._w.L)

    fun remAssign(bX: Number, bY: Number, bZ: Number, bW: Number) = rem(this, this, bX.L, bY.L, bZ.L, bW.L)
    infix operator fun remAssign(b: Number) {
        rem(this, this, b.L, b.L, b.L, b.L)
    }

    infix operator fun remAssign(b: Vec4t<out Number>) {
        rem(this, this, b._x.L, b._y.L, b._z.L, b._w.L)
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
    infix fun and(b: Vec4t<out Number>) = and(Vec4l(), this, b._x.L, b._y.L, b._z.L, b._w.L)

    infix fun andAssign(b: Number) = and(this, this, b.L, b.L, b.L, b.L)
    infix fun andAssign(b: Vec4t<out Number>) = and(this, this, b._x.L, b._y.L, b._z.L, b._w.L)

    fun and(b: Number, res: Vec4l) = and(res, this, b.L, b.L, b.L, b.L)
    fun and(b: Vec4t<out Number>, res: Vec4l) = and(res, this, b._x.L, b._y.L, b._z.L, b._w.L)

    fun and(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4l = Vec4l()) = and(res, this, bX.L, bY.L, bZ.L, bW.L)

    fun andAssign(bX: Number, bY: Number, bZ: Number, bW: Number) = and(this, this, bX.L, bY.L, bZ.L, bW.L)


    infix fun or(b: Number) = or(Vec4l(), this, b.L, b.L, b.L, b.L)
    infix fun or(b: Vec4t<out Number>) = or(Vec4l(), this, b._x.L, b._y.L, b._z.L, b._w.L)

    infix fun orAssign(b: Number) = or(this, this, b.L, b.L, b.L, b.L)
    infix fun orAssign(b: Vec4t<out Number>) = or(this, this, b._x.L, b._y.L, b._z.L, b._w.L)

    fun or(b: Number, res: Vec4l) = or(res, this, b.L, b.L, b.L, b.L)
    fun or(b: Vec4t<out Number>, res: Vec4l) = or(res, this, b._x.L, b._y.L, b._z.L, b._w.L)

    fun or(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4l = Vec4l()) = or(res, this, bX.L, bY.L, bZ.L, bW.L)

    fun orAssign(bX: Number, bY: Number, bZ: Number, bW: Number) = or(this, this, bX.L, bY.L, bZ.L, bW.L)


    infix fun xor(b: Number) = xor(Vec4l(), this, b.L, b.L, b.L, b.L)
    infix fun xor(b: Vec4t<out Number>) = xor(Vec4l(), this, b._x.L, b._y.L, b._z.L, b._w.L)

    infix fun xorAssign(b: Number) = xor(this, this, b.L, b.L, b.L, b.L)
    infix fun xorAssign(b: Vec4t<out Number>) = xor(this, this, b._x.L, b._y.L, b._z.L, b._w.L)

    fun xor(b: Number, res: Vec4l) = xor(res, this, b.L, b.L, b.L, b.L)
    fun xor(b: Vec4t<out Number>, res: Vec4l) = xor(res, this, b._x.L, b._y.L, b._z.L, b._w.L)

    fun xor(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4l = Vec4l()) = xor(res, this, bX.L, bY.L, bZ.L, bW.L)

    fun xorAssign(bX: Number, bY: Number, bZ: Number, bW: Number) = xor(this, this, bX.L, bY.L, bZ.L, bW.L)


    infix fun shl(b: Number) = shl(Vec4l(), this, b.L, b.L, b.L, b.L)
    infix fun shl(b: Vec4t<out Number>) = shl(Vec4l(), this, b._x.L, b._y.L, b._z.L, b._w.L)

    infix fun shlAssign(b: Number) = shl(this, this, b.L, b.L, b.L, b.L)
    infix fun shlAssign(b: Vec4t<out Number>) = shl(this, this, b._x.L, b._y.L, b._z.L, b._w.L)

    fun shl(b: Number, res: Vec4l) = shl(res, this, b.L, b.L, b.L, b.L)
    fun shl(b: Vec4t<out Number>, res: Vec4l) = shl(res, this, b._x.L, b._y.L, b._z.L, b._w.L)

    fun shl(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4l = Vec4l()) = shl(res, this, bX.L, bY.L, bZ.L, bW.L)

    fun shlAssign(bX: Number, bY: Number, bZ: Number, bW: Number) = shl(this, this, bX.L, bY.L, bZ.L, bW.L)


    infix fun shr(b: Number) = shr(Vec4l(), this, b.L, b.L, b.L, b.L)
    infix fun shr(b: Vec4t<out Number>) = shr(Vec4l(), this, b._x.L, b._y.L, b._z.L, b._w.L)

    infix fun shrAssign(b: Number) = shr(this, this, b.L, b.L, b.L, b.L)
    infix fun shrAssign(b: Vec4t<out Number>) = shr(this, this, b._x.L, b._y.L, b._z.L, b._w.L)

    fun shr(b: Number, res: Vec4l) = shr(res, this, b.L, b.L, b.L, b.L)
    fun shr(b: Vec4t<out Number>, res: Vec4l) = shr(res, this, b._x.L, b._y.L, b._z.L, b._w.L)

    fun shr(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4l = Vec4l()) = shr(res, this, bX.L, bY.L, bZ.L, bW.L)

    fun shrAssign(bX: Number, bY: Number, bZ: Number, bW: Number) = shr(this, this, bX.L, bY.L, bZ.L, bW.L)


    infix fun allLessThan(L: Long): Boolean = x < L && y < L && z < L && w < L
    infix fun anyLessThan(L: Long): Boolean = x < L || y < L || z < L || w < L
    infix fun lessThan(L: Long): Vec4bool = Vec4bool { get(it) < L }

    infix fun allLessThanEqual(L: Long): Boolean = x <= L && y <= L && z <= L && w <= L
    infix fun anyLessThanEqual(L: Long): Boolean = x <= L || y <= L || z <= L || w <= L
    infix fun lessThanEqual(L: Long): Vec4bool = Vec4bool { get(it) <= L }

    infix fun allEqual(L: Long): Boolean = x == L && y == L && z == L && w == L
    infix fun anyEqual(L: Long): Boolean = x == L || y == L || z == L || w == L
    infix fun equal(L: Long): Vec4bool = Vec4bool { get(it) == L }

    infix fun allNotEqual(L: Long): Boolean = x != L && y != L && z != L && w != L
    infix fun anyNotEqual(L: Long): Boolean = x != L || y != L || z != L || w != L
    infix fun notEqual(L: Long): Vec4bool = Vec4bool { get(it) != L }

    infix fun allGreaterThan(L: Long): Boolean = x > L && y > L && z > L && w > L
    infix fun anyGreaterThan(L: Long): Boolean = x > L || y > L || z > L || w > L
    infix fun greaterThan(L: Long): Vec4bool = Vec4bool { get(it) > L }

    infix fun allGreaterThanEqual(L: Long): Boolean = x >= L && y >= L && z >= L && w >= L
    infix fun anyGreaterThanEqual(L: Long): Boolean = x >= L || y >= L || z >= L || w >= L
    infix fun greaterThanEqual(L: Long): Vec4bool = Vec4bool { get(it) >= L }


    infix fun allLessThan(v: Vec4l): Boolean = x < v.x && y < v.y && z < v.z && w < v.w
    infix fun anyLessThan(v: Vec4l): Boolean = x < v.x || y < v.y || z < v.z || w < v.w
    infix fun lessThan(v: Vec4l): Vec4bool = Vec4bool { get(it) < v[it] }

    infix fun allLessThanEqual(v: Vec4l): Boolean = x <= v.x && y <= v.y && z <= v.z && w <= v.w
    infix fun anyLessThanEqual(v: Vec4l): Boolean = x <= v.x || y <= v.y || z <= v.z || w <= v.w
    infix fun lessThanEqual(v: Vec4l): Vec4bool = Vec4bool { get(it) <= v[it] }

    infix fun allEqual(v: Vec4l): Boolean = x == v.x && y == v.y && z == v.z && w == v.w
    infix fun anyEqual(v: Vec4l): Boolean = x == v.x || y == v.y || z == v.z || w == v.w
    infix fun equal(v: Vec4l): Vec4bool = Vec4bool { get(it) == v[it] }

    infix fun allNotEqual(v: Vec4l): Boolean = x != v.x && y != v.y && z != v.z && w != v.w
    infix fun anyNotEqual(v: Vec4l): Boolean = x != v.x || y != v.y || z != v.z || w != v.w
    infix fun notEqual(v: Vec4l): Vec4bool = Vec4bool { get(it) != v[it] }

    infix fun allGreaterThan(v: Vec4l): Boolean = x > v.x && y > v.y && z > v.z && w > v.w
    infix fun anyGreaterThan(v: Vec4l): Boolean = x > v.x || y > v.y || z > v.z || w > v.w
    infix fun greaterThan(v: Vec4l): Vec4bool = Vec4bool { get(it) > v[it] }

    infix fun allGreaterThanEqual(v: Vec4l): Boolean = x >= v.x && y >= v.y && z >= v.z && w >= v.w
    infix fun anyGreaterThanEqual(v: Vec4l): Boolean = x >= v.x || y >= v.y || z >= v.z || w >= v.w
    infix fun greaterThanEqual(v: Vec4l): Vec4bool = Vec4bool { get(it) >= v[it] }


    companion object : vec4l_operators {
        const val length = Vec4t.LENGTH

        @JvmField
        val size = length * Long.BYTES

        @JvmStatic
        fun fromPointer(ptr: Ptr<Long>) = Vec4l().apply {
            x = ptr[0]
            y = ptr[1]
            z = ptr[2]
            w = ptr[3]
        }
    }

    override fun size() = Vec4l.size


    override fun equals(other: Any?) = other is Vec4l && this[0] == other[0] && this[1] == other[1] && this[2] == other[2] && this[3] == other[3]
    override fun hashCode() = 31 * (31 * (31 * x.hashCode() + y.hashCode()) + z.hashCode()) + w.hashCode()

    @JvmOverloads
    fun print(name: String = "", stream: PrintStream = System.out) = stream.print("$name$this")

    @JvmOverloads
    fun println(name: String = "", stream: PrintStream = System.out) = stream.println("$name$this")


    //@formatter:off
    override inline var _x get() = x; set(value) { x = value }
    override inline var r get() = x; set(value) { x = value }
    override inline var s get() = x; set(value) { x = value }

    override inline var _y get() = y; set(value) { y = value }
    override inline var g get() = y; set(value) { y = value }
    override inline var t get() = y; set(value) { y = value }

    override inline var _z get() = z; set(value) { z = value }
    override inline var b get() = z; set(value) { z = value }
    override inline var p get() = z; set(value) { z = value }

    override inline var _w get() = w; set(value) { w = value }
    override inline var a get() = w; set(value) { w = value }
    override inline var q get() = w; set(value) { w = value }
    //@formatter:on

    override inline operator fun get(index: Int) = array[ofs + index]

    inline operator fun set(index: Int, value: Long) {
        array[ofs + index] = value
    }

    override inline fun component1() = x
    override inline fun component2() = y
    override inline fun component3() = z
    override inline fun component4() = w

    override fun toString(): String = "($x, $y, $z, $w)"
}
