package glm_.vec3

import glm_.*
import glm_.vec1.Vec1
import glm_.vec1.Vec1bool
import glm_.vec1.Vec1t
import glm_.vec2.Vec2
import glm_.vec2.Vec2bool
import glm_.vec2.Vec2t
import glm_.vec3.operators.vec3_operators
import glm_.vec4.Vec4
import glm_.vec4.Vec4bool
import glm_.vec4.Vec4t
import kool.*
import java.awt.Color
import java.io.InputStream
import java.io.PrintStream
import java.nio.*
import kotlin.math.abs

/**
 * Created bY GBarbieri on 05.10.2016.
 */

class Vec3(@JvmField var ofs: Int, @JvmField var array: FloatArray) : Vec3t<Float>, ToFloatBuffer {

    inline var x: Float
        get() = array[ofs]
        set(value) = array.set(ofs, value)
    inline var y: Float
        get() = array[ofs + 1]
        set(value) = array.set(ofs + 1, value)
    inline var z: Float
        get() = array[ofs + 2]
        set(value) = array.set(ofs + 2, value)

    // -- Implicit basic constructors --

    constructor() : this(0, 0, 0)
    constructor(v: Vec3) : this(v.x, v.y, v.z)

    // -- Explicit basic constructors --

    @JvmOverloads
    constructor(x: Float, y: Float = x, z: Float = x) : this(0, floatArrayOf(x, y, z))

    // -- Conversion scalar constructors --

    constructor(v: Vec1t<out Number>) : this(v._x.f)

    // Explicit conversions (From section 5.4.1 Conversion and scalar constructors of GLSL 1.30.08 specification)

    constructor(v: Number) : this(v.f)
    constructor(x: Number, y: Number, z: Number) : this(x.f, y.f, z.f)

    constructor(x: Vec1t<out Number>, y: Number, z: Number) : this(x._x, y, z)
    constructor(x: Number, y: Vec1t<out Number>, z: Number) : this(x, y._x, z)
    constructor(x: Vec1t<out Number>, y: Vec1t<out Number>, z: Number) : this(x._x, y._x, z)
    constructor(x: Number, y: Number, z: Vec1t<out Number>) : this(x, y, z._x)
    constructor(x: Vec1t<out Number>, y: Number, z: Vec1t<out Number>) : this(x._x, y, z._x)
    constructor(x: Number, y: Vec1t<out Number>, z: Vec1t<out Number>) : this(x, y._x, z._x)
    constructor(x: Vec1t<out Number>, y: Vec1t<out Number>, z: Vec1t<out Number>) : this(x._x, y._x, z._x)

    // -- Conversion vector constructors --

    // Explicit conversions (From section 5.4.1 Conversion and scalar constructors of GLSL 1.30.08 specification)

    @JvmOverloads
    constructor(xy: Vec2t<out Number>, z: Number = 0) : this(xy._x, xy._y, z)

    constructor(xy: Vec2t<out Number>, z: Vec1t<out Number>) : this(xy._x, xy._y, z._x)
    constructor(x: Number, yz: Vec2t<out Number>) : this(x, yz._x, yz._y)
    constructor(x: Vec1t<out Number>, yz: Vec2t<out Number>) : this(x._x, yz._x, yz._y)
    constructor(v: Vec3t<out Number>) : this(v._x, v._y, v._z)
    constructor(v: Vec4t<out Number>) : this(v._x, v._y, v._z)


    constructor(v: Vec1) : this(v.x)
    constructor(x: Vec1, y: Float, z: Float) : this(x.x, y, z)
    constructor(x: Float, y: Vec1, z: Float) : this(x, y.x, z)
    constructor(x: Float, y: Float, z: Vec1) : this(x, y, z.x)
    constructor(x: Vec1, y: Vec1, z: Vec1) : this(x.x, y.x, z.x)

    constructor(xy: Vec2, z: Float) : this(xy.x, xy.y, z)
    constructor(x: Float, yz: Vec2) : this(x, yz.x, yz.y)
    constructor(v: Vec4) : this(v.x, v.y, v.z)


    constructor(v: Vec3i) : this(v.x.toFloat(), v.y.toFloat(), v.z.toFloat())
    constructor(v: Vec3d) : this(v.x.toFloat(), v.y.toFloat(), v.z.toFloat())

    constructor(v: Vec1bool) : this(v.x.f, 0, 0)
    constructor(v: Vec2bool) : this(v.x.f, v.y.f, 0)
    constructor(v: Vec3bool) : this(v.x.f, v.y.f, v.z.f)
    constructor(v: Vec4bool) : this(v.x.f, v.y.f, v.z.f)

    constructor(bytes: ByteArray, index: Int = 0, oneByteOneFloat: Boolean = false, bigEndian: Boolean = true) : this(
            if (oneByteOneFloat) bytes[index].f else bytes.getFloat(index, bigEndian),
            if (oneByteOneFloat) bytes[index + 1].f else bytes.getFloat(index + Float.BYTES, bigEndian),
            if (oneByteOneFloat) bytes[index + 2].f else bytes.getFloat(index + Float.BYTES * 2, bigEndian))

    constructor(chars: CharArray, index: Int = 0) : this(chars[index].f, chars[index + 1].f, chars[index + 2].f)
    constructor(shorts: ShortArray, index: Int = 0) : this(shorts[index], shorts[index + 1], shorts[index + 2])
    constructor(ints: IntArray, index: Int = 0) : this(ints[index], ints[index + 1], ints[index + 2])
    constructor(longs: LongArray, index: Int = 0) : this(longs[index], longs[index + 1], longs[index + 2])
    constructor(floats: FloatArray, index: Int = 0) : this(floats[index], floats[index + 1], floats[index + 2])
    constructor(doubles: DoubleArray, index: Int = 0) : this(doubles[index], doubles[index + 1], doubles[index + 2])
    constructor(booleans: BooleanArray, index: Int = 0) : this(booleans[index].f, booleans[index + 1].f, booleans[index + 2].f)

    constructor(numbers: Array<out Number>, index: Int = 0) : this(numbers[index], numbers[index + 1], numbers[index + 2])
    constructor(chars: Array<Char>, index: Int = 0) : this(chars[index].f, chars[index + 1].f, chars[index + 2].f)
    constructor(booleans: Array<Boolean>, index: Int = 0) : this(booleans[index].f, booleans[index + 1].f, booleans[index + 2].f)

    constructor(list: Iterable<*>, index: Int = 0) : this(list.elementAt(index)!!.toFloat, list.elementAt(index + 1)!!.toFloat,
            list.elementAt(index + 2)!!.toFloat)

    constructor(bytes: ByteBuffer, index: Int = bytes.pos, oneByteOneFloat: Boolean = false) : this(
            if (oneByteOneFloat) bytes[index].f else bytes.getFloat(index),
            if (oneByteOneFloat) bytes[index + 1].f else bytes.getFloat(index + Float.BYTES),
            if (oneByteOneFloat) bytes[index + 2].f else bytes.getFloat(index + Float.BYTES * 2))

    constructor(chars: CharBuffer, index: Int = chars.pos) : this(chars[index].f, chars[index + 1].f, chars[index + 2].f)
    constructor(shorts: ShortBuffer, index: Int = shorts.pos) : this(shorts[index], shorts[index + 1], shorts[index + 2])
    constructor(ints: IntBuffer, index: Int = ints.pos) : this(ints[index], ints[index + 1], ints[index + 2])
    constructor(longs: LongBuffer, index: Int = longs.pos) : this(longs[index], longs[index + 1], longs[index + 2])
    constructor(floats: FloatBuffer, index: Int = floats.pos) : this(floats[index], floats[index + 1], floats[index + 2])
    constructor(doubles: DoubleBuffer, index: Int = doubles.pos) : this(doubles[index], doubles[index + 1], doubles[index + 2])

    constructor(block: (Int) -> Float) : this(block(0), block(1), block(2))
    constructor(ptr: Ptr<Float>) : this(ptr[0], ptr[1], ptr[2])


    constructor(inputStream: InputStream, bigEndian: Boolean = true) :
            this(inputStream.float(bigEndian), inputStream.float(bigEndian), inputStream.float(bigEndian))

    constructor(color: Color) : this(color.red / 255f, color.green / 255f, color.blue / 255f)

    fun set(bytes: ByteArray, index: Int = 0, oneByteOneFloat: Boolean = false, bigEndian: Boolean = true) {
        x = if (oneByteOneFloat) bytes[index].f else bytes.getFloat(index, bigEndian)
        y = if (oneByteOneFloat) bytes[index + 1].f else bytes.getFloat(index + Float.BYTES, bigEndian)
        z = if (oneByteOneFloat) bytes[index + 2].f else bytes.getFloat(index + Float.BYTES * 2, bigEndian)
    }

    fun set(bytes: ByteBuffer, index: Int = bytes.pos, oneByteOneFloat: Boolean = false) {
        x = if (oneByteOneFloat) bytes[index].f else bytes.getFloat(index)
        y = if (oneByteOneFloat) bytes[index + 1].f else bytes.getFloat(index + Float.BYTES)
        z = if (oneByteOneFloat) bytes[index + 2].f else bytes.getFloat(index + Float.BYTES * 2)
    }


    fun put(x: Float, y: Float, z: Float) {
        this.x = x
        this.y = y
        this.z = z
    }

    operator fun invoke(x: Float, y: Float, z: Float): Vec3 {
        this.x = x
        this.y = y
        this.z = z
        return this
    }

    override fun put(x: Number, y: Number, z: Number) {
        this.x = x.f
        this.y = y.f
        this.z = z.f
    }

    override operator fun invoke(x: Number, y: Number, z: Number): Vec3 {
        this.x = x.f
        this.y = y.f
        this.z = z.f
        return this
    }

    fun to(bytes: ByteArray, index: Int): ByteArray = to(bytes, index, true)
    override fun to(bytes: ByteArray, index: Int, bigEndian: Boolean): ByteArray {
        bytes.putFloat(index, x, bigEndian)
        bytes.putFloat(index + Float.BYTES, y, bigEndian)
        bytes.putFloat(index + Float.BYTES * 2, z, bigEndian)
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
        return buf
    }

    override fun to(buf: FloatBuffer, offset: Int): FloatBuffer {
        buf[offset] = x
        buf[offset + 1] = y
        buf[offset + 2] = z
        return buf
    }

    infix fun to(ptr: Ptr<Float>){
        ptr[0] = x
        ptr[1] = y
        ptr[2] = z
    }

    @JvmName("toPtrByte")
    infix fun to(ptr: Ptr<Byte>) = to(ptr.toPtr<Float>())

    // -- Component accesses --

    override operator fun set(index: Int, value: Number) = when (index) {
        0 -> x = value.f
        1 -> y = value.f
        2 -> z = value.f
        else -> throw ArrayIndexOutOfBoundsException()
    }

    // -- Unary arithmetic operators --

    operator fun unaryPlus() = this

    operator fun unaryMinus() = Vec3(-x, -y, -z)

    // -- Increment main.and decrement operators --

    operator fun inc(res: Vec3 = Vec3()) = plus(res, this, 1f, 1f, 1f)
    fun incAssign() = plus(this, this, 1f, 1f, 1f)


    operator fun dec(res: Vec3 = Vec3()) = minus(res, this, 1f, 1f, 1f)
    fun decAssign() = minus(this, this, 1f, 1f, 1f)


    // -- Specific binary arithmetic operators --

    infix operator fun plus(b: Float) = plus(Vec3(), this, b, b, b)
    infix operator fun plus(b: Vec3) = plus(Vec3(), this, b.x, b.y, b.z)

    @JvmOverloads
    fun plus(bX: Float, bY: Float, bZ: Float, res: Vec3 = Vec3()) = plus(res, this, bX, bY, bZ)

    fun plus(b: Float, res: Vec3 = Vec3()) = plus(res, this, b, b, b)
    fun plus(b: Vec3, res: Vec3 = Vec3()) = plus(res, this, b.x, b.y, b.z)

    fun plusAssign(bX: Float, bY: Float, bZ: Float) = plus(this, this, bX, bY, bZ)
    infix operator fun plusAssign(b: Float) {
        plus(this, this, b, b, b)
    }

    infix operator fun plusAssign(b: Vec3) {
        plus(this, this, b.x, b.y, b.z)
    }


    infix operator fun minus(b: Float) = minus(Vec3(), this, b, b, b)
    infix operator fun minus(b: Vec3) = minus(Vec3(), this, b.x, b.y, b.z)

    @JvmOverloads
    fun minus(bX: Float, bY: Float, bZ: Float, res: Vec3 = Vec3()) = minus(res, this, bX, bY, bZ)

    fun minus(b: Float, res: Vec3 = Vec3()) = minus(res, this, b, b, b)
    fun minus(b: Vec3, res: Vec3 = Vec3()) = minus(res, this, b.x, b.y, b.z) // TODO overload others

    fun minusAssign(bX: Float, bY: Float, bZ: Float) = minus(this, this, bX, bY, bZ)
    infix operator fun minusAssign(b: Float) {
        minus(this, this, b, b, b)
    }

    infix operator fun minusAssign(b: Vec3) {
        minus(this, this, b.x, b.y, b.z)
    }


    infix operator fun times(b: Float) = times(Vec3(), this, b, b, b)
    infix operator fun times(b: Vec3) = times(Vec3(), this, b.x, b.y, b.z)

    @JvmOverloads
    fun times(bX: Float, bY: Float, bZ: Float, res: Vec3 = Vec3()) = times(res, this, bX, bY, bZ)

    fun times(b: Float, res: Vec3 = Vec3()) = times(res, this, b, b, b)
    fun times(b: Vec3, res: Vec3 = Vec3()) = times(res, this, b.x, b.y, b.z)

    fun timesAssign(bX: Float, bY: Float, bZ: Float) = times(this, this, bX, bY, bZ)
    infix operator fun timesAssign(b: Float) {
        times(this, this, b, b, b)
    }

    infix operator fun timesAssign(b: Vec3) {
        times(this, this, b.x, b.y, b.z)
    }


    operator fun div(b: Float) = div(Vec3(), this, b, b, b)
    operator fun div(b: Vec3) = div(Vec3(), this, b.x, b.y, b.z)

    @JvmOverloads
    fun div(bX: Float, bY: Float, bZ: Float, res: Vec3 = Vec3()) = div(res, this, bX, bY, bZ)

    fun div(b: Float, res: Vec3 = Vec3()) = div(res, this, b, b, b)
    fun div(b: Vec3, res: Vec3 = Vec3()) = div(res, this, b.x, b.y, b.z)

    fun divAssign(bX: Float, bY: Float, bZ: Float) = div(this, this, bX, bY, bZ)
    infix operator fun divAssign(b: Float) {
        div(this, this, b, b, b)
    }

    infix operator fun divAssign(b: Vec3) {
        div(this, this, b.x, b.y, b.z)
    }


    infix operator fun rem(b: Float) = rem(Vec3(), this, b, b, b)
    infix operator fun rem(b: Vec3) = rem(Vec3(), this, b.x, b.y, b.z)

    @JvmOverloads
    fun rem(bX: Float, bY: Float, bZ: Float, res: Vec3 = Vec3()) = rem(res, this, bX, bY, bZ)

    fun rem(b: Float, res: Vec3 = Vec3()) = rem(res, this, b, b, b)
    fun rem(b: Vec3, res: Vec3 = Vec3()) = rem(res, this, b.x, b.y, b.z)

    fun remAssign(bX: Float, bY: Float, bZ: Float) = rem(this, this, bX, bY, bZ)
    infix operator fun remAssign(b: Float) {
        rem(this, this, b, b, b)
    }

    infix operator fun remAssign(b: Vec3) {
        rem(this, this, b.x, b.y, b.z)
    }


    // -- Generic binary arithmetic operators --

    infix operator fun plus(b: Number) = plus(Vec3(), this, b.f, b.f, b.f)

    @JvmOverloads
    fun plus(bX: Number, bY: Number, bZ: Number, res: Vec3 = Vec3()) = plus(res, this, bX.f, bY.f, bZ.f)

    fun plus(b: Number, res: Vec3) = plus(res, this, b.f, b.f, b.f)
    fun plus(b: Vec3t<out Number>, res: Vec3 = Vec3()) = plus(res, this, b._x.f, b._y.f, b._z.f)

    fun plusAssign(bX: Number, bY: Number, bZ: Number) = plus(this, this, bX.f, bY.f, bZ.f)
    infix operator fun plusAssign(b: Number) {
        plus(this, this, b.f, b.f, b.f)
    }

    infix operator fun plusAssign(b: Vec3t<out Number>) {
        plus(this, this, b._x.f, b._y.f, b._z.f)
    }


    infix operator fun minus(b: Number) = minus(Vec3(), this, b.f, b.f, b.f)

    fun minus(bX: Number, bY: Number, bZ: Number, res: Vec3 = Vec3()) = minus(res, this, bX.f, bY.f, bZ.f)
    fun minus(b: Number, res: Vec3 = Vec3()) = minus(res, this, b.f, b.f, b.f)
    fun minus(b: Vec3t<out Number>, res: Vec3 = Vec3()) = minus(res, this, b._x.f, b._y.f, b._z.f)

    fun minusAssign(bX: Number, bY: Number, bZ: Number) = minus(this, this, bX.f, bY.f, bZ.f)
    infix operator fun minusAssign(b: Number) {
        minus(this, this, b.f, b.f, b.f)
    }

    infix operator fun minusAssign(b: Vec3t<out Number>) {
        minus(this, this, b._x.f, b._y.f, b._z.f)
    }


    infix operator fun times(b: Number) = times(Vec3(), this, b.f, b.f, b.f)
    infix operator fun times(b: Vec3t<out Number>) = times(Vec3(), this, b._x.f, b._y.f, b._z.f)

    fun times(bX: Number, bY: Number, bZ: Number, res: Vec3 = Vec3()) = times(res, this, bX.f, bY.f, bZ.f)
    fun times(b: Number, res: Vec3 = Vec3()) = times(res, this, b.f, b.f, b.f)
    fun times(b: Vec3t<out Number>, res: Vec3 = Vec3()) = times(res, this, b._x.f, b._y.f, b._z.f)

    fun timesAssign(bX: Number, bY: Number, bZ: Number) = times(this, this, bX.f, bY.f, bZ.f)
    infix operator fun timesAssign(b: Number) {
        times(this, this, b.f, b.f, b.f)
    }

    infix operator fun timesAssign(b: Vec3t<out Number>) {
        times(this, this, b._x.f, b._y.f, b._z.f)
    }


    infix operator fun div(b: Number) = div(Vec3(), this, b.f, b.f, b.f)
    infix operator fun div(b: Vec3t<out Number>) = div(Vec3(), this, b._x.f, b._y.f, b._z.f)

    fun div(bX: Number, bY: Number, bZ: Number, res: Vec3 = Vec3()) = div(res, this, bX.f, bY.f, bZ.f)
    fun div(b: Number, res: Vec3 = Vec3()) = div(res, this, b.f, b.f, b.f)
    fun div(b: Vec3t<out Number>, res: Vec3 = Vec3()) = div(res, this, b._x.f, b._y.f, b._z.f)

    fun divAssign(bX: Number, bY: Number, bZ: Number) = div(this, this, bX.f, bY.f, bZ.f)
    infix operator fun divAssign(b: Number) {
        div(this, this, b.f, b.f, b.f)
    }

    infix operator fun divAssign(b: Vec3t<out Number>) {
        div(this, this, b._x.f, b._y.f, b._z.f)
    }


    infix operator fun rem(b: Number) = rem(Vec3(), this, b.f, b.f, b.f)
    infix operator fun rem(b: Vec3t<out Number>) = rem(Vec3(), this, b._x.f, b._y.f, b._z.f)

    fun rem(bX: Number, bY: Number, bZ: Number, res: Vec3 = Vec3()) = rem(res, this, bX.f, bY.f, bZ.f)
    fun rem(b: Number, res: Vec3 = Vec3()) = rem(res, this, b.f, b.f, b.f)
    fun rem(b: Vec3t<out Number>, res: Vec3 = Vec3()) = rem(res, this, b._x.f, b._y.f, b._z.f)

    fun remAssign(bX: Number, bY: Number, bZ: Number) = rem(this, this, bX.f, bY.f, bZ.f)
    infix operator fun remAssign(b: Number) {
        rem(this, this, b.f, b.f, b.f)
    }

    infix operator fun remAssign(b: Vec3t<out Number>) {
        rem(this, this, b._x.f, b._y.f, b._z.f)
    }


    infix fun allLessThan(f: Float): Boolean = x < f && y < f && z < f
    infix fun anyLessThan(f: Float): Boolean = x < f || y < f || z < f
    infix fun lessThan(f: Float): Vec3bool = Vec3bool { get(it) < f }

    infix fun allLessThanEqual(f: Float): Boolean = x <= f && y <= f && z <= f
    infix fun anyLessThanEqual(f: Float): Boolean = x <= f || y <= f || z <= f
    infix fun lessThanEqual(f: Float): Vec3bool = Vec3bool { get(it) <= f }

    fun allEqual(f: Float, epsilon: Float = glm.εf): Boolean = abs(x - f) < epsilon && abs(y - f) < epsilon && abs(z - f) < epsilon
    fun anyEqual(f: Float, epsilon: Float = glm.εf): Boolean = abs(x - f) < epsilon || abs(y - f) < epsilon || abs(z - f) < epsilon
    fun equal(f: Float, epsilon: Float = glm.εf): Vec3bool = Vec3bool { abs(get(it) - f) < epsilon }

    fun allNotEqual(f: Float, epsilon: Float = glm.εf): Boolean = abs(x - f) >= epsilon && abs(y - f) >= epsilon && abs(z - f) >= epsilon
    fun anyNotEqual(f: Float, epsilon: Float = glm.εf): Boolean = abs(x - f) >= epsilon || abs(y - f) >= epsilon || abs(z - f) >= epsilon
    fun notEqual(f: Float, epsilon: Float = glm.εf): Vec3bool = Vec3bool { abs(get(it) - f) >= epsilon }

    infix fun allGreaterThan(f: Float): Boolean = x > f && y > f && z > f
    infix fun anyGreaterThan(f: Float): Boolean = x > f || y > f || z > f
    infix fun greaterThan(f: Float): Vec3bool = Vec3bool { get(it) > f }

    infix fun allGreaterThanEqual(f: Float): Boolean = x >= f && y >= f && z >= f
    infix fun anyGreaterThanEqual(f: Float): Boolean = x >= f || y >= f || z >= f
    infix fun greaterThanEqual(f: Float): Vec3bool = Vec3bool { get(it) >= f }


    infix fun allLessThan(v: Vec3): Boolean = x < v.x && y < v.y && z < v.z
    infix fun anyLessThan(v: Vec3): Boolean = x < v.x || y < v.y || z < v.z
    infix fun lessThan(v: Vec3): Vec3bool = Vec3bool { get(it) < v[it] }

    infix fun allLessThanEqual(v: Vec3): Boolean = x <= v.x && y <= v.y && z <= v.z
    infix fun anyLessThanEqual(v: Vec3): Boolean = x <= v.x || y <= v.y || z <= v.z
    infix fun lessThanEqual(v: Vec3): Vec3bool = Vec3bool { get(it) <= v[it] }

    fun allEqual(v: Vec3, epsilon: Float = glm.εf): Boolean = abs(x - v.x) < epsilon && abs(y - v.y) < epsilon && abs(z - v.z) < epsilon
    fun anyEqual(v: Vec3, epsilon: Float = glm.εf): Boolean = abs(x - v.x) < epsilon || abs(y - v.y) < epsilon || abs(z - v.z) < epsilon
    fun equal(v: Vec3, epsilon: Float = glm.εf): Vec3bool = Vec3bool { abs(get(it) - v[it]) < epsilon }

    fun allNotEqual(v: Vec3, epsilon: Float = glm.εf): Boolean = abs(x - v.x) >= epsilon && abs(y - v.y) >= epsilon && abs(z - v.z) >= epsilon
    fun anyNotEqual(v: Vec3, epsilon: Float = glm.εf): Boolean = abs(x - v.x) >= epsilon || abs(y - v.y) >= epsilon || abs(z - v.z) >= epsilon
    fun notEqual(v: Vec3, epsilon: Float = glm.εf): Vec3bool = Vec3bool { abs(get(it) - v[it]) >= epsilon }

    infix fun allGreaterThan(v: Vec3): Boolean = x > v.x && y > v.y && z > v.z
    infix fun anyGreaterThan(v: Vec3): Boolean = x > v.x || y > v.y || z > v.z
    infix fun greaterThan(v: Vec3): Vec3bool = Vec3bool { get(it) > v[it] }

    infix fun allGreaterThanEqual(v: Vec3): Boolean = x >= v.x && y >= v.y && z >= v.z
    infix fun anyGreaterThanEqual(v: Vec3): Boolean = x >= v.x || y >= v.y || z >= v.z
    infix fun greaterThanEqual(v: Vec3): Vec3bool = Vec3bool { get(it) >= v[it] }


    // -- functions --

    infix fun dot(b: Vec3) = glm.dot(this, b)   // TODO others
    infix fun dot(b: Vec3t<out Number>) = glm.dot(this, b)   // TODO others

    fun length() = glm.length(this)
    fun length2() = glm.length2(this)

    @JvmOverloads
    fun normalize(res: Vec3 = Vec3()) = glm.normalize(this, res) // TODO others

    fun normalizeAssign() = glm.normalize(this, this)

    infix fun cross(b: Vec3) = glm.cross(this, b, Vec3())
    infix fun crossAssign(b: Vec3) = glm.cross(this, b, this)

    @JvmOverloads
    fun negate(res: Vec3 = Vec3()): Vec3 {
        res.x = -x
        res.y = -y
        res.z = -z
        return res
    }

    fun negateAssign() = negate(this)


    companion object : vec3_operators {
        const val length = Vec3t.LENGTH

        @JvmField
        val size = length * Float.BYTES

        @JvmStatic // TODO 1.3 use inline classes
        fun fromPointer(ptr: Ptr<Float>) = Vec3(ptr)

        fun fromColor(n: Number) = Vec3(n.f / 255, n.f / 255, n.f / 255f)
        fun fromColor(r: Number, g: Number, b: Number) = Vec3(r.f / 255, g.f / 255, b.f / 255f)
    }

    @JvmOverloads
    fun toColor(alpha: Float? = null, normalized: Boolean = true) = when {
        normalized -> Color(r, g, b, alpha ?: 1f)
        else -> {
            val i = 1f / 255
            Color(r * i, g * i, b * i, alpha?.times(i) ?: 1f)
        }
    }

    fun toColor(normalized: Boolean = true) = when {
        normalized -> Color(r, g, b, 1f)
        else -> {
            val i = 1f / 255
            Color(r * i, g * i, b * i, 1f)
        }
    }

    override fun size() = size

    override fun elementCount() = length

    override fun equals(other: Any?) = other is Vec3 && this[0] == other[0] && this[1] == other[1] && this[2] == other[2]
    override fun hashCode() = 31 * (31 * x.hashCode() + y.hashCode()) + z.hashCode()

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
    //@formatter:on

    override inline operator fun get(index: Int) = array[ofs + index]

    inline operator fun set(index: Int, value: Float) {
        array[ofs + index] = value
    }

    override inline operator fun component1() = x
    override inline operator fun component2() = y
    override inline operator fun component3() = z

    override fun toString(): String = "($x, $y, $z)"
}
