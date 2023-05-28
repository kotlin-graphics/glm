package glm_.vec4

import glm_.*
import glm_.vec1.Vec1bool
import glm_.vec1.Vec1t
import glm_.vec2.Vec2
import glm_.vec2.Vec2bool
import glm_.vec2.Vec2t
import glm_.vec3.Vec3
import glm_.vec3.Vec3bool
import glm_.vec3.Vec3t
import glm_.vec4.operators.vec4_operators
import kool.*
import org.lwjgl.system.MemoryUtil.memGetFloat
import org.lwjgl.system.MemoryUtil.memPutFloat
import java.awt.Color
import java.io.InputStream
import java.io.PrintStream
import java.nio.*
import kotlin.math.abs

/**
 * Created by elect on 09/10/16.
 */

class Vec4(@JvmField var ofs: Int, @JvmField var array: FloatArray) : Vec4t<Float>, ToFloatBuffer {

    inline var x: Float
        get() = array[ofs]
        set(value) = array.set(ofs, value)
    inline var y: Float
        get() = array[ofs + 1]
        set(value) = array.set(ofs + 1, value)
    inline var z: Float
        get() = array[ofs + 2]
        set(value) = array.set(ofs + 2, value)
    inline var w: Float
        get() = array[ofs + 3]
        set(value) = array.set(ofs + 3, value)

    // -- Implicit basic constructors --

    constructor() : this(0)
    constructor(v: Vec4) : this(v.x, v.y, v.z, v.w)
    constructor(v: Vec3) : this(v.x, v.y, v.z, 0f)
    constructor(v: Vec2) : this(v.x, v.y, 0f, 0f)

    // -- Explicit basic constructors --

    constructor(x: Float) : this(x, x, x, x)
    constructor(x: Float, y: Float, z: Float, w: Float) : this(0, floatArrayOf(x, y, z, w))

    // -- Conversion scalar constructors --

    constructor(v: Vec1t<out Number>) : this(v._x, v._x, v._x, v._x)

    // Explicit conversions (From section 5.4.1 Conversion and scalar constructors of GLSL 1.30.08 specification)

    constructor(v: Number) : this(v.f)
    constructor(x: Number, y: Number, z: Number, w: Number) : this(x.f, y.f, z.f, w.f)

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


    constructor(v: Vec1) : this(v.x)
    constructor(x: Vec1, y: Float, z: Float, w: Float) : this(x.x, y, z, w)
    constructor(x: Float, y: Vec1, z: Float, w: Float) : this(x, y.x, z, w)
    constructor(x: Float, y: Float, z: Vec1, w: Float) : this(x, y, z.x, w)
    constructor(x: Float, y: Float, z: Float, w: Vec1) : this(x, y, z, w.x)
    constructor(x: Vec1, y: Vec1, z: Vec1, w: Vec1) : this(x.x, y.x, z.x, w.x)


    constructor(xy: Vec2, z: Float, w: Float) : this(xy.x, xy.y, z, w)
    constructor(x: Float, yz: Vec2, w: Float) : this(x, yz.x, yz.y, w)
    constructor(x: Float, y: Float, zw: Vec2) : this(x, y, zw.x, zw.y)
    constructor(xy: Vec2, zw: Vec2) : this(xy.x, xy.y, zw.x, zw.y)

    constructor(xyz: Vec3, w: Float) : this(xyz.x, xyz.y, xyz.z, w)
    constructor(x: Float, yzw: Vec3) : this(x, yzw.x, yzw.y, yzw.z)


    constructor(v: Vec1bool) : this(v.x.f, 0, 0, 1)
    constructor(v: Vec2bool) : this(v.x.f, v.y.f, 0, 1)
    constructor(v: Vec3bool) : this(v.x.f, v.y.f, v.z.f, 1)
    constructor(v: Vec4bool) : this(v.x.f, v.y.f, v.z.f, v.w.f)

    // TODO oneByteOne* = false
    constructor(bytes: ByteArray, index: Int = 0, oneByteOneFloat: Boolean = false, bigEndian: Boolean = true) : this(
            if (oneByteOneFloat) bytes[index].f else bytes.getFloat(index, bigEndian),
            if (oneByteOneFloat) bytes[index + 1].f else bytes.getFloat(index + Float.BYTES, bigEndian),
            if (oneByteOneFloat) bytes[index + 2].f else bytes.getFloat(index + Float.BYTES * 2, bigEndian),
            if (oneByteOneFloat) bytes[index + 3].f else bytes.getFloat(index + Float.BYTES * 3, bigEndian))

    constructor(chars: CharArray, index: Int = 0) : this(chars[index].f, chars[index + 1].f, chars[index + 2].f, chars[index + 3].f)
    constructor(shorts: ShortArray, index: Int = 0) : this(shorts[index], shorts[index + 1], shorts[index + 2], shorts[index + 3])
    constructor(ints: IntArray, index: Int = 0) : this(ints[index], ints[index + 1], ints[index + 2], ints[index + 3])
    constructor(longs: LongArray, index: Int = 0) : this(longs[index], longs[index + 1], longs[index + 2], longs[index + 3])
    constructor(floats: FloatArray, index: Int = 0) : this(floats[index], floats[index + 1], floats[index + 2], floats[index + 3])
    constructor(doubles: DoubleArray, index: Int = 0) : this(doubles[index], doubles[index + 1], doubles[index + 2], doubles[index + 3])
    constructor(booleans: BooleanArray, index: Int = 0) : this(booleans[index].f, booleans[index + 1].f, booleans[index + 2].f, booleans[index + 3].f)

    constructor(floats: FloatArray, index: Int, w: Float) : this(floats[index], floats[index + 1], floats[index + 2], w) // TODO others

    constructor(numbers: Array<out Number>, index: Int = 0) : this(numbers[index], numbers[index + 1], numbers[index + 2], numbers[index + 3])
    constructor(chars: Array<Char>, index: Int = 0) : this(chars[index].f, chars[index + 1].f, chars[index + 2].f, chars[index + 3].f)
    constructor(booleans: Array<Boolean>, index: Int = 0) : this(booleans[index].f, booleans[index + 1].f, booleans[index + 2].f, booleans[index + 3].f)

    constructor(list: Iterable<*>, index: Int = 0) : this(list.elementAt(index)!!.toFloat, list.elementAt(index + 1)!!.toFloat,
            list.elementAt(index + 2)!!.toFloat, list.elementAt(index + 3)!!.toFloat)

    constructor(bytes: ByteBuffer, index: Int = bytes.pos, oneByteOneFloat: Boolean = false) : this(
            if (oneByteOneFloat) bytes[index].f else bytes.getFloat(index),
            if (oneByteOneFloat) bytes[index + 1].f else bytes.getFloat(index + Float.BYTES),
            if (oneByteOneFloat) bytes[index + 2].f else bytes.getFloat(index + Float.BYTES * 2),
            if (oneByteOneFloat) bytes[index + 3].f else bytes.getFloat(index + Float.BYTES * 3))

    constructor(chars: CharBuffer, index: Int = chars.pos) : this(chars[index].f, chars[index + 1].f, chars[index + 2].f, chars[index + 3].f)
    constructor(shorts: ShortBuffer, index: Int = shorts.pos) : this(shorts[index], shorts[index + 1], shorts[index + 2], shorts[index + 3])
    constructor(ints: IntBuffer, index: Int = ints.pos) : this(ints[index], ints[index + 1], ints[index + 2], ints[index + 3])
    constructor(longs: LongBuffer, index: Int = longs.pos) : this(longs[index], longs[index + 1], longs[index + 2], longs[index + 3])
    constructor(floats: FloatBuffer, index: Int = floats.pos) : this(floats[index], floats[index + 1], floats[index + 2], floats[index + 3])
    constructor(doubles: DoubleBuffer, index: Int = doubles.pos) : this(doubles[index], doubles[index + 1], doubles[index + 2], doubles[index + 3])

    constructor(block: (Int) -> Float) : this(block(0), block(1), block(2), block(3))
    constructor(ptr: Ptr<Float>) : this(ptr[0], ptr[1], ptr[2], ptr[3])

    constructor(inputStream: InputStream, bigEndian: Boolean = true) :
            this(inputStream.float(bigEndian), inputStream.float(bigEndian), inputStream.float(bigEndian), inputStream.float(bigEndian))

    // TODO other non float?
    constructor(color: Color) : this(color.red / 255f, color.green / 255f, color.blue / 255f, color.alpha / 255f)


    fun set(bytes: ByteArray, index: Int = 0, oneByteOneFloat: Boolean = false, bigEndian: Boolean = true) {
        x = if (oneByteOneFloat) bytes[index].f else bytes.getFloat(index, bigEndian)
        y = if (oneByteOneFloat) bytes[index + 1].f else bytes.getFloat(index + Float.BYTES, bigEndian)
        z = if (oneByteOneFloat) bytes[index + 2].f else bytes.getFloat(index + Float.BYTES * 2, bigEndian)
        w = if (oneByteOneFloat) bytes[index + 3].f else bytes.getFloat(index + Float.BYTES * 3, bigEndian)
    }

    fun set(bytes: ByteBuffer, index: Int = bytes.pos, oneByteOneFloat: Boolean = false) {
        x = if (oneByteOneFloat) bytes[index].f else bytes.getFloat(index)
        y = if (oneByteOneFloat) bytes[index + 1].f else bytes.getFloat(index + Float.BYTES)
        z = if (oneByteOneFloat) bytes[index + 2].f else bytes.getFloat(index + Float.BYTES * 2)
        w = if (oneByteOneFloat) bytes[index + 3].f else bytes.getFloat(index + Float.BYTES * 3)
    }


    fun put(x: Float, y: Float, z: Float, w: Float) {
        this.x = x
        this.y = y
        this.z = z
        this.w = w
    }

    operator fun invoke(x: Float, y: Float, z: Float, w: Float): Vec4 {
        this.x = x
        this.y = y
        this.z = z
        this.w = w
        return this
    }

    override fun put(x: Number, y: Number, z: Number, w: Number) {
        this.x = x.f
        this.y = y.f
        this.z = z.f
        this.w = w.f
    }

    override operator fun invoke(x: Number, y: Number, z: Number, w: Number): Vec4 {
        this.x = x.f
        this.y = y.f
        this.z = z.f
        this.w = w.f
        return this
    }

    fun to(bytes: ByteArray, index: Int): ByteArray = to(bytes, index, true)
    override fun to(bytes: ByteArray, index: Int, bigEndian: Boolean): ByteArray {
        bytes.putFloat(index, x, bigEndian)
        bytes.putFloat(index + Float.BYTES, y, bigEndian)
        bytes.putFloat(index + Float.BYTES * 2, z, bigEndian)
        bytes.putFloat(index + Float.BYTES * 3, w, bigEndian)
        return bytes
    }

    fun toFloatArray(): FloatArray = to(FloatArray(length), 0)
    infix fun to(floats: FloatArray): FloatArray = to(floats, 0)
    fun to(floats: FloatArray, index: Int): FloatArray {
        System.arraycopy(array, ofs, floats, index, length)
        return floats
    }

    override fun to(buf: ByteBuffer, offset: Int): ByteBuffer {
        buf.putFloat(offset, x)
        buf.putFloat(offset + Float.BYTES, y)
        buf.putFloat(offset + Float.BYTES * 2, z)
        buf.putFloat(offset + Float.BYTES * 3, w)
        return buf
    }

    override fun to(buf: FloatBuffer, offset: Int): FloatBuffer {
        buf[offset] = x
        buf[offset + 1] = y
        buf[offset + 2] = z
        buf[offset + 3] = w
        return buf
    }

    infix fun to(ptr: Ptr<Float>) {
        ptr[0] = x
        ptr[1] = y
        ptr[2] = z
        ptr[3] = w
    }

    // -- Component accesses --

    override operator fun set(index: Int, value: Number) = when (index) {
        0 -> x = value.f
        1 -> y = value.f
        2 -> z = value.f
        3 -> w = value.f
        else -> throw ArrayIndexOutOfBoundsException()
    }


    fun toVec3() = Vec3(this)
    fun to(res: Vec3) = res put this

    // -- Unary arithmetic operators --

    operator fun unaryPlus() = this

    operator fun unaryMinus() = Vec4(-x, -y, -z, -w)

    // -- Increment main.and decrement operators --

    operator fun inc(res: Vec4 = Vec4()) = plus(res, this, 1f, 1f, 1f, 1f)
    fun incAssign() = plus(this, this, 1f, 1f, 1f, 1f)


    operator fun dec(res: Vec4 = Vec4()) = minus(res, this, 1f, 1f, 1f, 1f)
    fun decAssign() = minus(this, this, 1f, 1f, 1f, 1f)


    // -- Specific binary arithmetic operators --

    operator fun plus(b: Float) = plus(Vec4(), this, b, b, b, b)
    operator fun plus(b: Vec4) = plus(Vec4(), this, b.x, b.y, b.z, b.w)

    fun plus(bX: Float, bY: Float, bZ: Float, bW: Float, res: Vec4 = Vec4()) = plus(res, this, bX, bY, bZ, bW)
    fun plus(b: Float, res: Vec4 = Vec4()) = plus(res, this, b, b, b, b)
    fun plus(b: Vec4, res: Vec4 = Vec4()) = plus(res, this, b.x, b.y, b.z, b.w)

    fun plusAssign(bX: Float, bY: Float, bZ: Float, bW: Float) = plus(this, this, bX, bY, bZ, bW)
    infix operator fun plusAssign(b: Float) {
        plus(this, this, b, b, b, b)
    }

    infix operator fun plusAssign(b: Vec4) {
        plus(this, this, b.x, b.y, b.z, b.w)
    }


    operator fun minus(b: Float) = minus(Vec4(), this, b, b, b, b)
    operator fun minus(b: Vec4) = minus(Vec4(), this, b.x, b.y, b.z, b.w)

    fun minus(bX: Float, bY: Float, bZ: Float, bW: Float, res: Vec4 = Vec4()) = minus(res, this, bX, bY, bZ, bW)
    fun minus(b: Float, res: Vec4 = Vec4()) = minus(res, this, b, b, b, b)
    fun minus(b: Vec4, res: Vec4 = Vec4()) = minus(res, this, b.x, b.y, b.z, b.w)

    fun minusAssign(bX: Float, bY: Float, bZ: Float, bW: Float) = minus(this, this, bX, bY, bZ, bW)
    infix operator fun minusAssign(b: Float) {
        minus(this, this, b, b, b, b)
    }

    infix operator fun minusAssign(b: Vec4) {
        minus(this, this, b.x, b.y, b.z, b.w)
    }


    operator fun times(b: Float) = times(Vec4(), this, b, b, b, b)
    operator fun times(b: Vec4) = times(Vec4(), this, b.x, b.y, b.z, b.w)

    fun times(bX: Float, bY: Float, bZ: Float, bW: Float, res: Vec4 = Vec4()) = times(res, this, bX, bY, bZ, bW)
    fun times(b: Float, res: Vec4 = Vec4()) = times(res, this, b, b, b, b)
    fun times(b: Vec4, res: Vec4 = Vec4()) = times(res, this, b.x, b.y, b.z, b.w)

    fun timesAssign(bX: Float, bY: Float, bZ: Float, bW: Float) = times(this, this, bX, bY, bZ, bW)
    infix operator fun timesAssign(b: Float) {
        times(this, this, b, b, b, b)
    }

    infix operator fun timesAssign(b: Vec4) {
        times(this, this, b.x, b.y, b.z, b.w)
    }


    operator fun div(b: Float) = div(Vec4(), this, b, b, b, b)
    operator fun div(b: Vec4) = div(Vec4(), this, b.x, b.y, b.z, b.w)

    fun div(bX: Float, bY: Float, bZ: Float, bW: Float, res: Vec4 = Vec4()) = div(res, this, bX, bY, bZ, bW)
    fun div(b: Float, res: Vec4 = Vec4()) = div(res, this, b, b, b, b)
    fun div(b: Vec4, res: Vec4 = Vec4()) = div(res, this, b.x, b.y, b.z, b.w)

    fun divAssign(bX: Float, bY: Float, bZ: Float, bW: Float) = div(this, this, bX, bY, bZ, bW)
    infix operator fun divAssign(b: Float) {
        div(this, this, b, b, b, b)
    }

    infix operator fun divAssign(b: Vec4) {
        div(this, this, b.x, b.y, b.z, b.w)
    }


    operator fun rem(b: Float) = rem(Vec4(), this, b, b, b, b)
    operator fun rem(b: Vec4) = rem(Vec4(), this, b.x, b.y, b.z, b.w)

    fun rem(bX: Float, bY: Float, bZ: Float, bW: Float, res: Vec4 = Vec4()) = rem(res, this, bX, bY, bZ, bW)
    fun rem(b: Float, res: Vec4 = Vec4()) = rem(res, this, b, b, b, b)
    fun rem(b: Vec4, res: Vec4 = Vec4()) = rem(res, this, b.x, b.y, b.z, b.w)

    fun remAssign(bX: Float, bY: Float, bZ: Float, bW: Float) = rem(this, this, bX, bY, bZ, bW)
    infix operator fun remAssign(b: Float) {
        rem(this, this, b, b, b, b)
    }

    infix operator fun remAssign(b: Vec4) {
        rem(this, this, b.x, b.y, b.z, b.w)
    }


    // -- Generic binary arithmetic operators --

    operator fun plus(b: Number) = plus(Vec4(), this, b.f, b.f, b.f, b.f)
    operator fun plus(b: Vec4t<out Number>) = plus(Vec4(), this, b._x.f, b._y.f, b._z.f, b._w.f)

    fun plus(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4 = Vec4()) = plus(res, this, bX.f, bY.f, bZ.f, bW.f)
    fun plus(b: Number, res: Vec4 = Vec4()) = plus(res, this, b.f, b.f, b.f, b.f)
    fun plus(b: Vec4t<out Number>, res: Vec4 = Vec4()) = plus(res, this, b._x.f, b._y.f, b._z.f, b._w.f)

    fun plusAssign(bX: Number, bY: Number, bZ: Number, bW: Number) = plus(this, this, bX.f, bY.f, bZ.f, bW.f)
    infix operator fun plusAssign(b: Number) {
        plus(this, this, b.f, b.f, b.f, b.f)
    }

    infix operator fun plusAssign(b: Vec4t<out Number>) {
        plus(this, this, b._x.f, b._y.f, b._z.f, b._w.f)
    }


    operator fun minus(b: Number) = minus(Vec4(), this, b.f, b.f, b.f, b.f)
    operator fun minus(b: Vec4t<out Number>) = minus(Vec4(), this, b._x.f, b._y.f, b._z.f, b._w.f)

    fun minus(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4 = Vec4()) = minus(res, this, bX.f, bY.f, bZ.f, bW.f)
    fun minus(b: Number, res: Vec4 = Vec4()) = minus(res, this, b.f, b.f, b.f, b.f)
    fun minus(b: Vec4t<out Number>, res: Vec4 = Vec4()) = minus(res, this, b._x.f, b._y.f, b._z.f, b._w.f)

    fun minusAssign(bX: Number, bY: Number, bZ: Number, bW: Number) = minus(this, this, bX.f, bY.f, bZ.f, bW.f)
    infix operator fun minusAssign(b: Number) {
        minus(this, this, b.f, b.f, b.f, b.f)
    }

    infix operator fun minusAssign(b: Vec4t<out Number>) {
        minus(this, this, b._x.f, b._y.f, b._z.f, b._w.f)
    }


    operator fun times(b: Number) = times(Vec4(), this, b.f, b.f, b.f, b.f)
    operator fun times(b: Vec4t<out Number>) = times(Vec4(), this, b._x.f, b._y.f, b._z.f, b._w.f)

    fun times(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4 = Vec4()) = times(res, this, bX.f, bY.f, bZ.f, bW.f)
    fun times(b: Number, res: Vec4 = Vec4()) = times(res, this, b.f, b.f, b.f, b.f)
    fun times(b: Vec4t<out Number>, res: Vec4 = Vec4()) = times(res, this, b._x.f, b._y.f, b._z.f, b._w.f)

    fun timesAssign(bX: Number, bY: Number, bZ: Number, bW: Number) = times(this, this, bX.f, bY.f, bZ.f, bW.f)
    infix operator fun timesAssign(b: Number) {
        times(this, this, b.f, b.f, b.f, b.f)
    }

    infix operator fun timesAssign(b: Vec4t<out Number>) {
        times(this, this, b._x.f, b._y.f, b._z.f, b._w.f)
    }


    operator fun div(b: Number) = div(Vec4(), this, b.f, b.f, b.f, b.f)
    operator fun div(b: Vec4t<out Number>) = div(Vec4(), this, b._x.f, b._y.f, b._z.f, b._w.f)

    fun div(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4 = Vec4()) = div(res, this, bX.f, bY.f, bZ.f, bW.f)
    fun div(b: Number, res: Vec4 = Vec4()) = div(res, this, b.f, b.f, b.f, b.f)
    fun div(b: Vec4t<out Number>, res: Vec4 = Vec4()) = div(res, this, b._x.f, b._y.f, b._z.f, b._w.f)

    fun divAssign(bX: Number, bY: Number, bZ: Number, bW: Number) = div(this, this, bX.f, bY.f, bZ.f, bW.f)
    infix operator fun divAssign(b: Number) {
        div(this, this, b.f, b.f, b.f, b.f)
    }

    infix operator fun divAssign(b: Vec4t<out Number>) {
        div(this, this, b._x.f, b._y.f, b._z.f, b._w.f)
    }


    operator fun rem(b: Number) = rem(Vec4(), this, b.f, b.f, b.f, b.f)
    operator fun rem(b: Vec4t<out Number>) = rem(Vec4(), this, b._x.f, b._y.f, b._z.f, b._w.f)

    fun rem(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4 = Vec4()) = rem(res, this, bX.f, bY.f, bZ.f, bW.f)
    fun rem(b: Number, res: Vec4 = Vec4()) = rem(res, this, b.f, b.f, b.f, b.f)
    fun rem(b: Vec4t<out Number>, res: Vec4 = Vec4()) = rem(res, this, b._x.f, b._y.f, b._z.f, b._w.f)

    fun remAssign(bX: Number, bY: Number, bZ: Number, bW: Number) = rem(this, this, bX.f, bY.f, bZ.f, bW.f)
    infix operator fun remAssign(b: Number) {
        rem(this, this, b.f, b.f, b.f, b.f)
    }

    infix operator fun remAssign(b: Vec4t<out Number>) {
        rem(this, this, b._x.f, b._y.f, b._z.f, b._w.f)
    }


    infix fun allLessThan(f: Float): Boolean = x < f && y < f && z < f && w < f
    infix fun anyLessThan(f: Float): Boolean = x < f || y < f || z < f || w < f
    infix fun lessThan(f: Float): Vec4bool = Vec4bool { get(it) < f }

    infix fun allLessThanEqual(f: Float): Boolean = x <= f && y <= f && z <= f && w <= f
    infix fun anyLessThanEqual(f: Float): Boolean = x <= f || y <= f || z <= f || w <= f
    infix fun lessThanEqual(f: Float): Vec4bool = Vec4bool { get(it) <= f }

    fun allEqual(f: Float, epsilon: Float = glm.εf): Boolean = abs(x - f) < epsilon && abs(y - f) < epsilon && abs(z - f) < epsilon && abs(w - f) < epsilon
    fun anyEqual(f: Float, epsilon: Float = glm.εf): Boolean = abs(x - f) < epsilon || abs(y - f) < epsilon || abs(z - f) < epsilon || abs(w - f) < epsilon
    fun equal(f: Float, epsilon: Float = glm.εf): Vec4bool = Vec4bool { abs(get(it) - f) < epsilon }

    fun allNotEqual(f: Float, epsilon: Float = GLM.εf): Boolean = abs(x - f) >= epsilon && abs(y - f) >= epsilon && abs(z - f) >= epsilon && abs(w - f) >= epsilon
    fun anyNotEqual(f: Float, epsilon: Float = GLM.εf): Boolean = abs(x - f) >= epsilon || abs(y - f) >= epsilon || abs(z - f) >= epsilon || abs(w - f) >= epsilon
    fun notEqual(f: Float, epsilon: Float = GLM.εf): Vec4bool = Vec4bool { abs(get(it) - f) >= epsilon }

    infix fun allGreaterThan(f: Float): Boolean = x > f && y > f && z > f && w > f
    infix fun anyGreaterThan(f: Float): Boolean = x > f || y > f || z > f || w > f
    infix fun greaterThan(f: Float): Vec4bool = Vec4bool { get(it) > f }

    infix fun allGreaterThanEqual(f: Float): Boolean = x >= f && y >= f && z >= f && w >= f
    infix fun anyGreaterThanEqual(f: Float): Boolean = x >= f || y >= f || z >= f || w >= f
    infix fun greaterThanEqual(f: Float): Vec4bool = Vec4bool { get(it) >= f }


    infix fun allLessThan(v: Vec4): Boolean = x < v.x && y < v.y && z < v.z && w < v.w
    infix fun anyLessThan(v: Vec4): Boolean = x < v.x || y < v.y || z < v.z || w < v.w
    infix fun lessThan(v: Vec4): Vec4bool = Vec4bool { get(it) < v[it] }

    infix fun allLessThanEqual(v: Vec4): Boolean = x <= v.x && y <= v.y && z <= v.z && w <= v.w
    infix fun anyLessThanEqual(v: Vec4): Boolean = x <= v.x || y <= v.y || z <= v.z || w <= v.w
    infix fun lessThanEqual(v: Vec4): Vec4bool = Vec4bool { get(it) <= v[it] }

    fun allEqual(v: Vec4, epsilon: Float = glm.εf): Boolean = abs(x - v.x) < epsilon && abs(y - v.y) < epsilon && abs(z - v.z) < epsilon && abs(w - v.w) < epsilon
    fun anyEqual(v: Vec4, epsilon: Float = glm.εf): Boolean = abs(x - v.x) < epsilon || abs(y - v.y) < epsilon || abs(z - v.z) < epsilon || abs(w - v.w) < epsilon
    fun equal(v: Vec4, epsilon: Float = glm.εf): Vec4bool = Vec4bool { abs(get(it) - v[it]) < epsilon }

    fun allNotEqual(v: Vec4, epsilon: Float = GLM.εf): Boolean = abs(x - v.x) >= epsilon && abs(y - v.y) >= epsilon && abs(z - v.z) >= epsilon && abs(w - v.w) >= epsilon
    fun anyNotEqual(v: Vec4, epsilon: Float = GLM.εf): Boolean = abs(x - v.x) >= epsilon || abs(y - v.y) >= epsilon || abs(z - v.z) >= epsilon || abs(w - v.w) >= epsilon
    fun notEqual(v: Vec4, epsilon: Float = GLM.εf): Vec4bool = Vec4bool { abs(get(it) - v[it]) >= epsilon }

    infix fun allGreaterThan(v: Vec4): Boolean = x > v.x && y > v.y && z > v.z && w > v.w
    infix fun anyGreaterThan(v: Vec4): Boolean = x > v.x || y > v.y || z > v.z || w > v.w
    infix fun greaterThan(v: Vec4): Vec4bool = Vec4bool { get(it) > v[it] }

    infix fun allGreaterThanEqual(v: Vec4): Boolean = x >= v.x && y >= v.y && z >= v.z && w >= v.w
    infix fun anyGreaterThanEqual(v: Vec4): Boolean = x >= v.x || y >= v.y || z >= v.z || w >= v.w
    infix fun greaterThanEqual(v: Vec4): Vec4bool = Vec4bool { get(it) >= v[it] }


    // -- functions --

    infix fun dot(b: Vec4) = glm.dot(this, b)   // TODO others

    fun length() = glm.length(this)
    fun length2() = glm.length2(this)

    @JvmOverloads
    fun normalize(res: Vec4 = Vec4()) = glm.normalize(this, res) // TODO others

    fun normalizeAssign() = glm.normalize(this, this)

    @JvmOverloads
    fun negate(res: Vec4 = Vec4()): Vec4 {
        res.x = -x
        res.y = -y
        res.z = -z
        res.w = -w
        return res
    }

    fun negateAssign() = negate(this)


    companion object : vec4_operators {
        const val length = Vec4t.LENGTH

        @JvmField
        val size = length * Float.BYTES

        @JvmStatic
        fun fromPointer(ptr: Ptr<Float>) = Vec4(ptr)

        // TODO other? d?
        fun fromColor(n: Number) = Vec4(n.f / 255, n.f / 255, n.f / 255f, n.f / 255)

        fun fromColor(r: Number, g: Number, b: Number, a: Number = 255f) = Vec4(r.f / 255, g.f / 255, b.f / 255f, a.f / 255)
    }

    @JvmOverloads
    fun toColor(normalized: Boolean = true): Color = when {
        normalized -> Color(r, g, b, w)
        else -> {
            val i = 1f / 255
            Color(r * i, g * i, b * i, w * i)
        }
    }

    override fun size() = size

    override fun elementCount() = length

    override fun equals(other: Any?) = other is Vec4 && this[0] == other[0] && this[1] == other[1] && this[2] == other[2] && this[3] == other[3]
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

    inline operator fun set(index: Int, value: Float) {
        array[ofs + index] = value
    }

    override inline fun component1() = x
    override inline fun component2() = y
    override inline fun component3() = z
    override inline fun component4() = w

    override fun toString(): String = "($x, $y, $z, $w)"
}
