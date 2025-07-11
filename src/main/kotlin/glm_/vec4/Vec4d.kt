package glm_.vec4

import glm_.*
import glm_.vec1.Vec1bool
import glm_.vec1.Vec1d
import glm_.vec1.Vec1t
import glm_.vec2.Vec2bool
import glm_.vec2.Vec2d
import glm_.vec2.Vec2t
import glm_.vec3.Vec3bool
import glm_.vec3.Vec3d
import glm_.vec3.Vec3t
import glm_.vec4.operators.vec4d_operators
import kool.*
import java.awt.Color
import java.io.InputStream
import java.io.PrintStream
import java.nio.*
import kotlin.math.abs

/**
 * Created by elect on 09/10/16.
 */

class Vec4d(@JvmField var ofs: Int, @JvmField var array: DoubleArray) : Vec4t<Double>, ToDoubleBuffer {

    inline var x: Double
        get() = array[ofs]
        set(value) = array.set(ofs, value)
    inline var y: Double
        get() = array[ofs + 1]
        set(value) = array.set(ofs + 1, value)
    inline var z: Double
        get() = array[ofs + 2]
        set(value) = array.set(ofs + 2, value)
    inline var w: Double
        get() = array[ofs + 3]
        set(value) = array.set(ofs + 3, value)

    // -- Implicit basic constructors --

    constructor() : this(0)
    constructor(v: Vec4d) : this(v.x, v.y, v.z, v.w)
    constructor(v: Vec3d) : this(v.x, v.y, v.z, 0.0)
    constructor(v: Vec2d) : this(v.x, v.y, 0.0, 0.0)

    // -- Explicit basic constructors --

    constructor(x: Double) : this(x, x, x, x)
    constructor(x: Int) : this(x.d)
    constructor(x: Float) : this(x.d)

    constructor(x: Double, y: Double, z: Double, w: Double) : this(0, doubleArrayOf(x, y, z, w))
    constructor(x: Float, y: Float, z: Float, w: Float) : this(0, doubleArrayOf(x.d, y.d, z.d, w.d))
    constructor(x: Int, y: Int, z: Int, w: Int) : this(0, doubleArrayOf(x.d, y.d, z.d, w.d))

    // -- Conversion scalar constructors --

    constructor(v: Vec1t<out Number>) : this(v._x)

    // Explicit conversions (From section 5.4.1 Conversion and scalar constructors of GLSL 1.30.08 specification)

    constructor(v: Number) : this(v.d)
    constructor(x: Number, y: Number, z: Number, w: Number) : this(x.d, y.d, z.d, w.d)

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


    constructor(v: Vec1d) : this(v.x)
    constructor(x: Vec1d, y: Double, z: Double, w: Double) : this(x.x, y, z, w)
    constructor(x: Double, y: Vec1d, z: Double, w: Double) : this(x, y.x, z, w)
    constructor(x: Double, y: Double, z: Vec1d, w: Double) : this(x, y, z.x, w)
    constructor(x: Double, y: Double, z: Double, w: Vec1d) : this(x, y, z, w.x)
    constructor(x: Vec1d, y: Vec1d, z: Vec1d, w: Vec1d) : this(x.x, y.x, z.x, w.x)


    constructor(xy: Vec2d, z: Double, w: Double) : this(xy.x, xy.y, z, w)
    constructor(x: Double, yz: Vec2d, w: Double) : this(x, yz.x, yz.y, w)
    constructor(x: Double, y: Double, zw: Vec2d) : this(x, y, zw.x, zw.y)
    constructor(xy: Vec2d, zw: Vec2d) : this(xy.x, xy.y, zw.x, zw.y)

    constructor(xyz: Vec3d, w: Double) : this(xyz.x, xyz.y, xyz.z, w)
    constructor(x: Double, yzw: Vec3d) : this(x, yzw.x, yzw.y, yzw.z)

    constructor(v: Vec1bool) : this(v.x.d, 0, 0, 1)
    constructor(v: Vec2bool) : this(v.x.d, v.y.d, 0, 1)
    constructor(v: Vec3bool) : this(v.x.d, v.y.d, v.z.d, 1)
    constructor(v: Vec4bool) : this(v.x.d, v.y.d, v.z.d, v.w.d)

    constructor(bytes: ByteArray, index: Int = 0, oneByteOneDouble: Boolean = false, bigEndian: Boolean = true) : this(
            if (oneByteOneDouble) bytes[index].d else bytes.getDouble(index, bigEndian),
            if (oneByteOneDouble) bytes[index + 1].d else bytes.getDouble(index + Double.BYTES, bigEndian),
            if (oneByteOneDouble) bytes[index + 2].d else bytes.getDouble(index + Double.BYTES * 2, bigEndian),
            if (oneByteOneDouble) bytes[index + 3].d else bytes.getDouble(index + Double.BYTES * 3, bigEndian))

    constructor(chars: CharArray, index: Int = 0) : this(chars[index].d, chars[index + 1].d, chars[index + 2].d, chars[index + 3].d)
    constructor(shorts: ShortArray, index: Int = 0) : this(shorts[index], shorts[index + 1], shorts[index + 2], shorts[index + 3])
    constructor(ints: IntArray, index: Int = 0) : this(ints[index], ints[index + 1], ints[index + 2], ints[index + 3])
    constructor(longs: LongArray, index: Int = 0) : this(longs[index], longs[index + 1], longs[index + 2], longs[index + 3])
    constructor(floats: FloatArray, index: Int = 0) : this(floats[index], floats[index + 1], floats[index + 2], floats[index + 3])
    constructor(doubles: DoubleArray, index: Int = 0) : this(doubles[index], doubles[index + 1], doubles[index + 2], doubles[index + 3])
    constructor(booleans: BooleanArray, index: Int = 0) : this(booleans[index].d, booleans[index + 1].d, booleans[index + 2].d, booleans[index + 3].d)

    constructor(numbers: Array<out Number>, index: Int = 0) : this(numbers[index], numbers[index + 1], numbers[index + 2], numbers[index + 3])
    constructor(chars: Array<Char>, index: Int = 0) : this(chars[index].d, chars[index + 1].d, chars[index + 2].d, chars[index + 3].d)
    constructor(booleans: Array<Boolean>, index: Int = 0) : this(booleans[index].d, booleans[index + 1].d, booleans[index + 2].d, booleans[index + 3].d)

    constructor(list: Iterable<*>, index: Int = 0) : this(list.elementAt(index)!!.toDouble, list.elementAt(index + 1)!!.toDouble,
            list.elementAt(index + 2)!!.toDouble, list.elementAt(index + 3)!!.toDouble)

    constructor(bytes: ByteBuffer, index: Int = bytes.pos, oneByteOneDouble: Boolean = false) : this(
            if (oneByteOneDouble) bytes[index].d else bytes.getDouble(index),
            if (oneByteOneDouble) bytes[index + 1].d else bytes.getDouble(index + Double.BYTES),
            if (oneByteOneDouble) bytes[index + 2].d else bytes.getDouble(index + Double.BYTES * 2),
            if (oneByteOneDouble) bytes[index + 3].d else bytes.getDouble(index + Double.BYTES * 3))

    constructor(chars: CharBuffer, index: Int = chars.pos) : this(chars[index].d, chars[index + 1].d, chars[index + 2].d, chars[index + 3].d)
    constructor(shorts: ShortBuffer, index: Int = shorts.pos) : this(shorts[index], shorts[index + 1], shorts[index + 2], shorts[index + 3])
    constructor(ints: IntBuffer, index: Int = ints.pos) : this(ints[index], ints[index + 1], ints[index + 2], ints[index + 3])
    constructor(longs: LongBuffer, index: Int = longs.pos) : this(longs[index], longs[index + 1], longs[index + 2], longs[index + 3])
    constructor(floats: FloatBuffer, index: Int = floats.pos) : this(floats[index], floats[index + 1], floats[index + 2], floats[index + 3])
    constructor(doubles: DoubleBuffer, index: Int = doubles.pos) : this(doubles[index], doubles[index + 1], doubles[index + 2], doubles[index + 3])

    constructor(block: (Int) -> Double) : this(block(0), block(1), block(2), block(3))
    constructor(ptr: Ptr<Double>) : this(ptr[0], ptr[1], ptr[2], ptr[3])


    constructor(inputStream: InputStream, bigEndian: Boolean = true) :
            this(inputStream.double(bigEndian), inputStream.double(bigEndian), inputStream.double(bigEndian), inputStream.double(bigEndian))

    constructor(color: Color) : this(color.red / 255.0, color.green / 255.0, color.blue / 255.0, color.alpha / 255.0)


    fun set(bytes: ByteArray, index: Int = 0, oneByteOneDouble: Boolean = false, bigEndian: Boolean = true) {
        x = if (oneByteOneDouble) bytes[index].d else bytes.getDouble(index, bigEndian)
        y = if (oneByteOneDouble) bytes[index + 1].d else bytes.getDouble(index + Double.BYTES, bigEndian)
        z = if (oneByteOneDouble) bytes[index + 2].d else bytes.getDouble(index + Double.BYTES * 2, bigEndian)
        w = if (oneByteOneDouble) bytes[index + 3].d else bytes.getDouble(index + Double.BYTES * 3, bigEndian)
    }

    fun set(bytes: ByteBuffer, index: Int = bytes.pos, oneByteOneDouble: Boolean = false) {
        x = if (oneByteOneDouble) bytes[index].d else bytes.getDouble(index)
        y = if (oneByteOneDouble) bytes[index + 1].d else bytes.getDouble(index + Double.BYTES)
        z = if (oneByteOneDouble) bytes[index + 2].d else bytes.getDouble(index + Double.BYTES * 2)
        w = if (oneByteOneDouble) bytes[index + 3].d else bytes.getDouble(index + Double.BYTES * 3)
    }


    fun put(x: Double, y: Double, z: Double, w: Double) {
        this.x = x
        this.y = y
        this.z = z
        this.w = w
    }

    operator fun invoke(x: Double, y: Double, z: Double, w: Double): Vec4d {
        this.x = x
        this.y = y
        this.z = z
        this.w = w
        return this
    }

    override fun put(x: Number, y: Number, z: Number, w: Number) {
        this.x = x.d
        this.y = y.d
        this.z = z.d
        this.w = w.d
    }

    override operator fun invoke(x: Number, y: Number, z: Number, w: Number): Vec4d {
        this.x = x.d
        this.y = y.d
        this.z = z.d
        this.w = w.d
        return this
    }

    fun to(bytes: ByteArray, index: Int): ByteArray = to(bytes, index, true)
    override fun to(bytes: ByteArray, index: Int, bigEndian: Boolean): ByteArray {
        bytes.putDouble(index, x, bigEndian)
        bytes.putDouble(index + Double.BYTES, y, bigEndian)
        bytes.putDouble(index + Double.BYTES * 2, z, bigEndian)
        bytes.putDouble(index + Double.BYTES * 3, w, bigEndian)
        return bytes
    }

    fun toDoubleArray(): DoubleArray = to(DoubleArray(length), 0)
    infix fun to(doubles: DoubleArray): DoubleArray = to(doubles, 0)
    fun to(doubles: DoubleArray, index: Int): DoubleArray {
        System.arraycopy(array, ofs, doubles, index, length)
        return doubles
    }

    override fun to(buf: ByteBuffer, offset: Int): ByteBuffer {
        buf.putDouble(offset, x)
        buf.putDouble(offset + Double.BYTES, y)
        buf.putDouble(offset + Double.BYTES * 2, z)
        buf.putDouble(offset + Double.BYTES * 3, w)
        return buf
    }

    override fun to(buf: DoubleBuffer, index: Int): DoubleBuffer {
        buf[index] = x
        buf[index + 1] = y
        buf[index + 2] = z
        buf[index + 3] = w
        return buf
    }

    infix fun to(ptr: Ptr<Double>) {
        ptr[0] = x
        ptr[1] = y
        ptr[2] = z
        ptr[3] = w
    }

    // -- Component accesses --


    override operator fun set(index: Int, value: Number) = when (index) {
        0 -> x = value.d
        1 -> y = value.d
        2 -> z = value.d
        3 -> w = value.d
        else -> throw ArrayIndexOutOfBoundsException()
    }


    // -- Unary arithmetic operators --

    operator fun unaryPlus() = this

    operator fun unaryMinus() = Vec4d(-x, -y, -z, -w)

    // -- Increment main.and decrement operators --

    operator fun inc(res: Vec4d = Vec4d()) = plus(res, this, 1.0, 1.0, 1.0, 1.0)
    fun incAssign() = plus(this, this, 1.0, 1.0, 1.0, 1.0)


    operator fun dec(res: Vec4d = Vec4d()) = minus(res, this, 1.0, 1.0, 1.0, 1.0)
    fun decAssign() = minus(this, this, 1.0, 1.0, 1.0, 1.0)


    // -- Specific binary arithmetic operators --

    operator fun plus(b: Double) = plus(Vec4d(), this, b, b, b, b)
    operator fun plus(b: Vec4d) = plus(Vec4d(), this, b.x, b.y, b.z, b.w)

    fun plus(bX: Double, bY: Double, bZ: Double, bW: Double, res: Vec4d = Vec4d()) = plus(res, this, bX, bY, bZ, bW)
    fun plus(b: Double, res: Vec4d = Vec4d()) = plus(res, this, b, b, b, b)
    fun plus(b: Vec4d, res: Vec4d = Vec4d()) = plus(res, this, b.x, b.y, b.z, b.w)

    fun plusAssign(bX: Double, bY: Double, bZ: Double, bW: Double) = plus(this, this, bX, bY, bZ, bW)
    infix operator fun plusAssign(b: Double) {
        plus(this, this, b, b, b, b)
    }

    infix operator fun plusAssign(b: Vec4d) {
        plus(this, this, b.x, b.y, b.z, b.w)
    }


    operator fun minus(b: Double) = minus(Vec4d(), this, b, b, b, b)
    operator fun minus(b: Vec4d) = minus(Vec4d(), this, b.x, b.y, b.z, b.w)

    fun minus(bX: Double, bY: Double, bZ: Double, bW: Double, res: Vec4d = Vec4d()) = minus(res, this, bX, bY, bZ, bW)
    fun minus(b: Double, res: Vec4d = Vec4d()) = minus(res, this, b, b, b, b)
    fun minus(b: Vec4d, res: Vec4d = Vec4d()) = minus(res, this, b.x, b.y, b.z, b.w)

    fun minusAssign(bX: Double, bY: Double, bZ: Double, bW: Double) = minus(this, this, bX, bY, bZ, bW)
    infix operator fun minusAssign(b: Double) {
        minus(this, this, b, b, b, b)
    }

    infix operator fun minusAssign(b: Vec4d) {
        minus(this, this, b.x, b.y, b.z, b.w)
    }


    operator fun times(b: Double) = times(Vec4d(), this, b, b, b, b)
    operator fun times(b: Vec4d) = times(Vec4d(), this, b.x, b.y, b.z, b.w)

    fun times(bX: Double, bY: Double, bZ: Double, bW: Double, res: Vec4d = Vec4d()) = times(res, this, bX, bY, bZ, bW)
    fun times(b: Double, res: Vec4d = Vec4d()) = times(res, this, b, b, b, b)
    fun times(b: Vec4d, res: Vec4d = Vec4d()) = times(res, this, b.x, b.y, b.z, b.w)

    fun timesAssign(bX: Double, bY: Double, bZ: Double, bW: Double) = times(this, this, bX, bY, bZ, bW)
    infix operator fun timesAssign(b: Double) {
        times(this, this, b, b, b, b)
    }

    infix operator fun timesAssign(b: Vec4d) {
        times(this, this, b.x, b.y, b.z, b.w)
    }


    operator fun div(b: Double) = div(Vec4d(), this, b, b, b, b)
    operator fun div(b: Vec4d) = div(Vec4d(), this, b.x, b.y, b.z, b.w)

    fun div(bX: Double, bY: Double, bZ: Double, bW: Double, res: Vec4d = Vec4d()) = div(res, this, bX, bY, bZ, bW)
    fun div(b: Double, res: Vec4d = Vec4d()) = div(res, this, b, b, b, b)
    fun div(b: Vec4d, res: Vec4d = Vec4d()) = div(res, this, b.x, b.y, b.z, b.w)

    fun divAssign(bX: Double, bY: Double, bZ: Double, bW: Double) = div(this, this, bX, bY, bZ, bW)
    infix operator fun divAssign(b: Double) {
        div(this, this, b, b, b, b)
    }

    infix operator fun divAssign(b: Vec4d) {
        div(this, this, b.x, b.y, b.z, b.w)
    }


    operator fun rem(b: Double) = rem(Vec4d(), this, b, b, b, b)
    operator fun rem(b: Vec4d) = rem(Vec4d(), this, b.x, b.y, b.z, b.w)

    fun rem(bX: Double, bY: Double, bZ: Double, bW: Double, res: Vec4d = Vec4d()) = rem(res, this, bX, bY, bZ, bW)
    fun rem(b: Double, res: Vec4d = Vec4d()) = rem(res, this, b, b, b, b)
    fun rem(b: Vec4d, res: Vec4d = Vec4d()) = rem(res, this, b.x, b.y, b.z, b.w)

    fun remAssign(bX: Double, bY: Double, bZ: Double, bW: Double) = rem(this, this, bX, bY, bZ, bW)
    infix operator fun remAssign(b: Double) {
        rem(this, this, b, b, b, b)
    }

    infix operator fun remAssign(b: Vec4d) {
        rem(this, this, b.x, b.y, b.z, b.w)
    }


    // -- Generic binary arithmetic operators --

    operator fun plus(b: Number) = plus(Vec4d(), this, b.d, b.d, b.d, b.d)
    operator fun plus(b: Vec4t<out Number>) = plus(Vec4d(), this, b._x.d, b._y.d, b._z.d, b._w.d)

    fun plus(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4d = Vec4d()) = plus(res, this, bX.d, bY.d, bZ.d, bW.d)
    fun plus(b: Number, res: Vec4d = Vec4d()) = plus(res, this, b.d, b.d, b.d, b.d)
    fun plus(b: Vec4t<out Number>, res: Vec4d = Vec4d()) = plus(res, this, b._x.d, b._y.d, b._z.d, b._w.d)

    fun plusAssign(bX: Number, bY: Number, bZ: Number, bW: Number) = plus(this, this, bX.d, bY.d, bZ.d, bW.d)
    infix operator fun plusAssign(b: Number) {
        plus(this, this, b.d, b.d, b.d, b.d)
    }

    infix operator fun plusAssign(b: Vec4t<out Number>) {
        plus(this, this, b._x.d, b._y.d, b._z.d, b._w.d)
    }


    operator fun minus(b: Number) = minus(Vec4d(), this, b.d, b.d, b.d, b.d)
    operator fun minus(b: Vec4t<out Number>) = minus(Vec4d(), this, b._x.d, b._y.d, b._z.d, b._w.d)

    fun minus(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4d = Vec4d()) = minus(res, this, bX.d, bY.d, bZ.d, bW.d)
    fun minus(b: Number, res: Vec4d = Vec4d()) = minus(res, this, b.d, b.d, b.d, b.d)
    fun minus(b: Vec4t<out Number>, res: Vec4d = Vec4d()) = minus(res, this, b._x.d, b._y.d, b._z.d, b._w.d)

    fun minusAssign(bX: Number, bY: Number, bZ: Number, bW: Number) = minus(this, this, bX.d, bY.d, bZ.d, bW.d)
    infix operator fun minusAssign(b: Number) {
        minus(this, this, b.d, b.d, b.d, b.d)
    }

    infix operator fun minusAssign(b: Vec4t<out Number>) {
        minus(this, this, b._x.d, b._y.d, b._z.d, b._w.d)
    }


    operator fun times(b: Number) = times(Vec4d(), this, b.d, b.d, b.d, b.d)
    operator fun times(b: Vec4t<out Number>) = times(Vec4d(), this, b._x.d, b._y.d, b._z.d, b._w.d)

    fun times(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4d = Vec4d()) = times(res, this, bX.d, bY.d, bZ.d, bW.d)
    fun times(b: Number, res: Vec4d = Vec4d()) = times(res, this, b.d, b.d, b.d, b.d)
    fun times(b: Vec4t<out Number>, res: Vec4d = Vec4d()) = times(res, this, b._x.d, b._y.d, b._z.d, b._w.d)

    fun timesAssign(bX: Number, bY: Number, bZ: Number, bW: Number) = times(this, this, bX.d, bY.d, bZ.d, bW.d)
    infix operator fun timesAssign(b: Number) {
        times(this, this, b.d, b.d, b.d, b.d)
    }

    infix operator fun timesAssign(b: Vec4t<out Number>) {
        times(this, this, b._x.d, b._y.d, b._z.d, b._w.d)
    }


    operator fun div(b: Number) = div(Vec4d(), this, b.d, b.d, b.d, b.d)
    operator fun div(b: Vec4t<out Number>) = div(Vec4d(), this, b._x.d, b._y.d, b._z.d, b._w.d)

    fun div(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4d = Vec4d()) = div(res, this, bX.d, bY.d, bZ.d, bW.d)
    fun div(b: Number, res: Vec4d = Vec4d()) = div(res, this, b.d, b.d, b.d, b.d)
    fun div(b: Vec4t<out Number>, res: Vec4d = Vec4d()) = div(res, this, b._x.d, b._y.d, b._z.d, b._w.d)

    fun divAssign(bX: Number, bY: Number, bZ: Number, bW: Number) = div(this, this, bX.d, bY.d, bZ.d, bW.d)
    infix operator fun divAssign(b: Number) {
        div(this, this, b.d, b.d, b.d, b.d)
    }

    infix operator fun divAssign(b: Vec4t<out Number>) {
        div(this, this, b._x.d, b._y.d, b._z.d, b._w.d)
    }


    operator fun rem(b: Number) = rem(Vec4d(), this, b.d, b.d, b.d, b.d)
    operator fun rem(b: Vec4t<out Number>) = rem(Vec4d(), this, b._x.d, b._y.d, b._z.d, b._w.d)

    fun rem(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4d = Vec4d()) = rem(res, this, bX.d, bY.d, bZ.d, bW.d)
    fun rem(b: Number, res: Vec4d = Vec4d()) = rem(res, this, b.d, b.d, b.d, b.d)
    fun rem(b: Vec4t<out Number>, res: Vec4d = Vec4d()) = rem(res, this, b._x.d, b._y.d, b._z.d, b._w.d)

    fun remAssign(bX: Number, bY: Number, bZ: Number, bW: Number) = rem(this, this, bX.d, bY.d, bZ.d, bW.d)
    infix operator fun remAssign(b: Number) {
        rem(this, this, b.d, b.d, b.d, b.d)
    }

    infix operator fun remAssign(b: Vec4t<out Number>) {
        rem(this, this, b._x.d, b._y.d, b._z.d, b._w.d)
    }


    infix fun allLessThan(d: Double): Boolean = x < d && y < d && z < d && w < d
    infix fun anyLessThan(d: Double): Boolean = x < d || y < d || z < d || w < d
    infix fun lessThan(d: Double): Vec4bool = Vec4bool { get(it) < d }

    infix fun allLessThanEqual(d: Double): Boolean = x <= d && y <= d && z <= d && w <= d
    infix fun anyLessThanEqual(d: Double): Boolean = x <= d || y <= d || z <= d || w <= d
    infix fun lessThanEqual(d: Double): Vec4bool = Vec4bool { get(it) <= d }

    fun allEqual(d: Double, epsilon: Double = glm.ε): Boolean = abs(x - d) < epsilon && abs(y - d) < epsilon && abs(z - d) < epsilon && abs(w - d) < epsilon
    fun anyEqual(d: Double, epsilon: Double = glm.ε): Boolean = abs(x - d) < epsilon || abs(y - d) < epsilon || abs(z - d) < epsilon || abs(w - d) < epsilon
    fun equal(d: Double, epsilon: Double = glm.ε): Vec4bool = Vec4bool { abs(get(it) - d) < epsilon }

    fun allNotEqual(d: Double, epsilon: Double = glm.ε): Boolean = abs(x - d) >= epsilon && abs(y - d) >= epsilon && abs(z - d) >= epsilon && abs(w - d) >= epsilon
    fun anyNotEqual(d: Double, epsilon: Double = glm.ε): Boolean = abs(x - d) >= epsilon || abs(y - d) >= epsilon || abs(z - d) >= epsilon || abs(w - d) >= epsilon
    fun notEqual(d: Double, epsilon: Double = glm.ε): Vec4bool = Vec4bool{ abs(get(it) - d) >= epsilon }

    infix fun allGreaterThan(d: Double): Boolean = x > d && y > d && z > d && w > d
    infix fun anyGreaterThan(d: Double): Boolean = x > d || y > d || z > d || w > d
    infix fun greaterThan(d: Double): Vec4bool = Vec4bool{ get(it) > d }

    infix fun allGreaterThanEqual(d: Double): Boolean = x >= d && y >= d && z >= d && w >= d
    infix fun anyGreaterThanEqual(d: Double): Boolean = x >= d || y >= d || z >= d || w >= d
    infix fun greaterThanEqual(d: Double): Vec4bool = Vec4bool{ get(it) >= d }


    infix fun allLessThan(v: Vec4d): Boolean = x < v.x && y < v.y && z < v.z && w < v.w
    infix fun anyLessThan(v: Vec4d): Boolean = x < v.x || y < v.y || z < v.z || w < v.w
    infix fun lessThan(v: Vec4d): Vec4bool = Vec4bool { get(it) < v[it] }

    infix fun allLessThanEqual(v: Vec4d): Boolean = x <= v.x && y <= v.y && z <= v.z && w <= v.w
    infix fun anyLessThanEqual(v: Vec4d): Boolean = x <= v.x || y <= v.y || z <= v.z || w <= v.w
    infix fun lessThanEqual(v: Vec4d): Vec4bool = Vec4bool { get(it) <= v[it] }

    fun allEqual(v: Vec4d, epsilon: Double = glm.ε): Boolean = abs(x - v.x) < epsilon && abs(y - v.y) < epsilon && abs(z - v.z) < epsilon && abs(w - v.w) < epsilon
    fun anyEqual(v: Vec4d, epsilon: Double = glm.ε): Boolean = abs(x - v.x) < epsilon || abs(y - v.y) < epsilon || abs(z - v.z) < epsilon || abs(w - v.w) < epsilon
    fun equal(v: Vec4d, epsilon: Double = glm.ε): Vec4bool = Vec4bool { abs(get(it) - v[it]) < epsilon }

    fun allNotEqual(v: Vec4d, epsilon: Double = glm.ε): Boolean = abs(x - v.x) >= epsilon && abs(y - v.y) >= epsilon && abs(z - v.z) >= epsilon && abs(w - v.w) >= epsilon
    fun anyNotEqual(v: Vec4d, epsilon: Double = glm.ε): Boolean = abs(x - v.x) >= epsilon || abs(y - v.y) >= epsilon || abs(z - v.z) >= epsilon || abs(w - v.w) >= epsilon
    fun notEqual(v: Vec4d, epsilon: Double = glm.ε): Vec4bool = Vec4bool{ abs(get(it) - v[it]) >= epsilon }

    infix fun allGreaterThan(v: Vec4d): Boolean = x > v.x && y > v.y && z > v.z && w > v.w
    infix fun anyGreaterThan(v: Vec4d): Boolean = x > v.x || y > v.y || z > v.z || w > v.w
    infix fun greaterThan(v: Vec4d): Vec4bool = Vec4bool{ get(it) > v[it] }

    infix fun allGreaterThanEqual(v: Vec4d): Boolean = x >= v.x && y >= v.y && z >= v.z && w >= v.w
    infix fun anyGreaterThanEqual(v: Vec4d): Boolean = x >= v.x || y >= v.y || z >= v.z || w >= v.w
    infix fun greaterThanEqual(v: Vec4d): Vec4bool = Vec4bool{ get(it) >= v[it] }


    infix fun dot(b: Vec4d) = glm.dot(this, b)   // TODO others

    fun length() = glm.length(this)
    fun length2() = glm.length2(this)


    companion object : vec4d_operators {
        const val length = Vec4t.LENGTH

        @JvmField
        val size = length * Double.BYTES

        @JvmStatic
        fun fromPointer(ptr: Ptr<Double>) = Vec4d(ptr)
    }

    override fun size() = size

    override fun equals(other: Any?) = other is Vec4d && this[0] == other[0] && this[1] == other[1] && this[2] == other[2] && this[3] == other[3]
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

    inline operator fun set(index: Int, value: Double) {
        array[ofs + index] = value
    }

    override inline operator fun component1() = x
    override inline operator fun component2() = y
    override inline operator fun component3() = z
    override inline operator fun component4() = w

    override fun toString(): String = "($x, $y, $z, $w)"
}
