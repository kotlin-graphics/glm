package glm_.vec3

import glm_.*
import glm_.vec1.Vec1bool
import glm_.vec1.Vec1t
import glm_.vec2.Vec2bool
import glm_.vec2.Vec2d
import glm_.vec2.Vec2t
import glm_.vec3.operators.vec3d_operators
import glm_.vec4.Vec4bool
import glm_.vec4.Vec4t
import kool.*
import org.lwjgl.system.MemoryUtil.memGetDouble
import org.lwjgl.system.MemoryUtil.memPutDouble
import java.awt.Color
import java.io.InputStream
import java.io.PrintStream
import java.nio.*
import kotlin.math.abs

/**
 * Created by elect on 08/10/16.
 */

class Vec3d(@JvmField var ofs: Int, @JvmField var array: DoubleArray) : Vec3t<Double>(), ToDoubleBuffer {

    override inline var x: Double
        get() = array[ofs]
        set(value) = array.set(ofs, value)
    override inline var y: Double
        get() = array[ofs + 1]
        set(value) = array.set(ofs + 1, value)
    override inline var z: Double
        get() = array[ofs + 2]
        set(value) = array.set(ofs + 2, value)

    // -- Implicit basic constructors --

    constructor() : this(0, 0, 0)
    constructor(v: Vec3d) : this(v.x, v.y, v.z)
    constructor(v: Vec2d) : this(v.x, v.y, 0.0)

    // -- Explicit basic constructors --

    @JvmOverloads
    constructor(x: Double, y: Double = x, z: Double = x) : this(0, doubleArrayOf(x, y, z))

    // -- Conversion scalar constructors --

    constructor(v: Vec1t<out Number>) : this(v.x, v.x, v.x)

    // Explicit converions (From section 5.4.1 Conversion and scalar constructors of GLSL 1.30.08 specification)

    @JvmOverloads
    constructor(x: Number, y: Number = x, z: Number = x) : this(x.d, y.d, z.d)

    constructor(x: Vec1t<out Number>, y: Number, z: Number) : this(x.x, y, z)
    constructor(x: Number, y: Vec1t<out Number>, z: Number) : this(x, y.x, z)
    constructor(x: Vec1t<out Number>, y: Vec1t<out Number>, z: Number) : this(x.x, y.x, z)
    constructor(x: Number, y: Number, z: Vec1t<out Number>) : this(x, y, z.x)
    constructor(x: Vec1t<out Number>, y: Number, z: Vec1t<out Number>) : this(x.x, y, z.x)
    constructor(x: Number, y: Vec1t<out Number>, z: Vec1t<out Number>) : this(x, y.x, z.x)
    constructor(x: Vec1t<out Number>, y: Vec1t<out Number>, z: Vec1t<out Number>) : this(x.x, y.x, z.x)

    // -- Conversion vector constructors --

    // Explicit conversions (From section 5.4.1 Conversion and scalar constructors of GLSL 1.30.08 specification)

    @JvmOverloads
    constructor(xy: Vec2t<out Number>, z: Number = 0) : this(xy.x, xy.y, z)

    constructor(xy: Vec2t<out Number>, z: Vec1t<out Number>) : this(xy.x, xy.y, z.x)
    constructor(x: Number, yz: Vec2t<out Number>) : this(x, yz.x, yz.y)
    constructor(x: Vec1t<out Number>, yz: Vec2t<out Number>) : this(x.x, yz.x, yz.y)
    constructor(v: Vec3t<out Number>) : this(v.x, v.y, v.z)
    constructor(v: Vec4t<out Number>) : this(v.x, v.y, v.z)

    constructor(v: Vec1bool) : this(v.x.d, 0, 0)
    constructor(v: Vec2bool) : this(v.x.d, v.y.d, 0)
    constructor(v: Vec3bool) : this(v.x.d, v.y.d, v.z.d)
    constructor(v: Vec4bool) : this(v.x.d, v.y.d, v.z.d)

    constructor(bytes: ByteArray, index: Int = 0, oneByteOneDouble: Boolean = false, bigEndian: Boolean = true) : this(
        if (oneByteOneDouble) bytes[index].d else bytes.getDouble(index, bigEndian),
        if (oneByteOneDouble) bytes[index + 1].d else bytes.getDouble(index + Double.BYTES, bigEndian),
        if (oneByteOneDouble) bytes[index + 2].d else bytes.getDouble(index + Double.BYTES * 2, bigEndian))

    constructor(chars: CharArray, index: Int = 0) : this(chars[index].d, chars[index + 1].d, chars[index + 2].d)
    constructor(shorts: ShortArray, index: Int = 0) : this(shorts[index], shorts[index + 1], shorts[index + 2])
    constructor(ints: IntArray, index: Int = 0) : this(ints[index], ints[index + 1], ints[index + 2])
    constructor(longs: LongArray, index: Int = 0) : this(longs[index], longs[index + 1], longs[index + 2])
    constructor(floats: FloatArray, index: Int = 0) : this(floats[index], floats[index + 1], floats[index + 2])
    constructor(doubles: DoubleArray, index: Int = 0) : this(doubles[index], doubles[index + 1], doubles[index + 2])
    constructor(booleans: BooleanArray, index: Int = 0) : this(booleans[index].d, booleans[index + 1].d, booleans[index + 2].d)

    constructor(numbers: Array<out Number>, index: Int = 0) : this(numbers[index], numbers[index + 1], numbers[index + 2])
    constructor(chars: Array<Char>, index: Int = 0) : this(chars[index].d, chars[index + 1].d, chars[index + 2].d)
    constructor(booleans: Array<Boolean>, index: Int = 0) : this(booleans[index].d, booleans[index + 1].d, booleans[index + 2].d)

    constructor(list: Iterable<*>, index: Int = 0) : this(list.elementAt(index)!!.toDouble, list.elementAt(index + 1)!!.toDouble,
                                                          list.elementAt(index + 2)!!.toDouble)

    constructor(bytes: ByteBuffer, index: Int = bytes.pos, oneByteOneDouble: Boolean = false) : this(
        if (oneByteOneDouble) bytes[index].d else bytes.getDouble(index),
        if (oneByteOneDouble) bytes[index + 1].d else bytes.getDouble(index + Double.BYTES),
        if (oneByteOneDouble) bytes[index + 2].d else bytes.getDouble(index + Double.BYTES * 2))

    constructor(chars: CharBuffer, index: Int = chars.pos) : this(chars[index].d, chars[index + 1].d, chars[index + 2].d)
    constructor(shorts: ShortBuffer, index: Int = shorts.pos) : this(shorts[index], shorts[index + 1], shorts[index + 2])
    constructor(ints: IntBuffer, index: Int = ints.pos) : this(ints[index], ints[index + 1], ints[index + 2])
    constructor(longs: LongBuffer, index: Int = longs.pos) : this(longs[index], longs[index + 1], longs[index + 2])
    constructor(floats: FloatBuffer, index: Int = floats.pos) : this(floats[index], floats[index + 1], floats[index + 2])
    constructor(doubles: DoubleBuffer, index: Int = doubles.pos) : this(doubles[index], doubles[index + 1], doubles[index + 2])

    constructor(block: (Int) -> Double) : this(block(0), block(1), block(2))
    constructor(ptr: Ptr<Double>) : this(ptr[0], ptr[1], ptr[2])

    // TODO others
    constructor(inputStream: InputStream, bigEndian: Boolean = true) :
            this(inputStream.double(bigEndian), inputStream.double(bigEndian), inputStream.double(bigEndian))

    constructor(color: Color) : this(color.red / 255.0, color.green / 255.0, color.blue / 255.0)

    fun set(bytes: ByteArray, index: Int = 0, oneByteOneDouble: Boolean = false, bigEndian: Boolean = true) {
        x = if (oneByteOneDouble) bytes[index].d else bytes.getDouble(index, bigEndian)
        y = if (oneByteOneDouble) bytes[index + 1].d else bytes.getDouble(index + Double.BYTES, bigEndian)
        z = if (oneByteOneDouble) bytes[index + 2].d else bytes.getDouble(index + Double.BYTES * 2, bigEndian)
    }

    fun set(bytes: ByteBuffer, index: Int = bytes.pos, oneByteOneDouble: Boolean = false) {
        x = if (oneByteOneDouble) bytes[index].d else bytes.getDouble(index)
        y = if (oneByteOneDouble) bytes[index + 1].d else bytes.getDouble(index + Double.BYTES)
        z = if (oneByteOneDouble) bytes[index + 2].d else bytes.getDouble(index + Double.BYTES * 2)
    }


    fun put(x: Double, y: Double, z: Double) {
        this.x = x
        this.y = y
        this.z = z
    }

    operator fun invoke(x: Double, y: Double, z: Double): Vec3d {
        this.x = x
        this.y = y
        this.z = z
        return this
    }

    override fun put(x: Number, y: Number, z: Number) {
        this.x = x.d
        this.y = y.d
        this.z = z.d
    }

    override operator fun invoke(x: Number, y: Number, z: Number): Vec3d {
        this.x = x.d
        this.y = y.d
        this.z = z.d
        return this
    }

    fun to(bytes: ByteArray, index: Int): ByteArray = to(bytes, index, true)
    override fun to(bytes: ByteArray, index: Int, bigEndian: Boolean): ByteArray {
        bytes.putDouble(index, x, bigEndian)
        bytes.putDouble(index + Double.BYTES, y, bigEndian)
        bytes.putDouble(index + Double.BYTES * 2, z, bigEndian)
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
        return buf
    }

    override fun to(buf: DoubleBuffer, offset: Int): DoubleBuffer {
        buf[offset] = x
        buf[offset + 1] = y
        buf[offset + 2] = z
        return buf
    }

    infix fun to(ptr: Ptr<Double>) {
        ptr[0] = x
        ptr[1] = y
        ptr[2] = z
    }

    // -- Component accesses --

    operator fun set(index: Int, value: Double) = when (index) {
        0 -> x = value
        1 -> y = value
        2 -> z = value
        else -> throw ArrayIndexOutOfBoundsException()
    }

    override operator fun set(index: Int, value: Number) = when (index) {
        0 -> x = value.d
        1 -> y = value.d
        2 -> z = value.d
        else -> throw ArrayIndexOutOfBoundsException()
    }

    // -- Unary arithmetic operators --

    operator fun unaryPlus() = this

    operator fun unaryMinus() = Vec3d(-x, -y, -z)

    // -- Increment main.and decrement operators --

    operator fun inc(res: Vec3d = Vec3d()) = plus(res, this, 1.0, 1.0, 1.0)
    fun incAssign() = plus(this, this, 1.0, 1.0, 1.0)


    operator fun dec(res: Vec3d = Vec3d()) = minus(res, this, 1.0, 1.0, 1.0)
    fun decAssign() = minus(this, this, 1.0, 1.0, 1.0)


    // -- Specific binary arithmetic operators --

    operator fun plus(b: Double) = plus(Vec3d(), this, b, b, b)
    operator fun plus(b: Vec3d) = plus(Vec3d(), this, b.x, b.y, b.z)

    fun plus(bX: Double, bY: Double, bZ: Double, res: Vec3d = Vec3d()) = plus(res, this, bX, bY, bZ)
    fun plus(b: Double, res: Vec3d = Vec3d()) = plus(res, this, b, b, b)
    fun plus(b: Vec3d, res: Vec3d = Vec3d()) = plus(res, this, b.x, b.y, b.z)

    fun plusAssign(bX: Double, bY: Double, bZ: Double) = plus(this, this, bX, bY, bZ)
    infix operator fun plusAssign(b: Double) {
        plus(this, this, b, b, b)
    }

    infix operator fun plusAssign(b: Vec3d) {
        plus(this, this, b.x, b.y, b.z)
    }


    operator fun minus(b: Double) = minus(Vec3d(), this, b, b, b)
    operator fun minus(b: Vec3d) = minus(Vec3d(), this, b.x, b.y, b.z)

    fun minus(bX: Double, bY: Double, bZ: Double, res: Vec3d = Vec3d()) = minus(res, this, bX, bY, bZ)
    fun minus(b: Double, res: Vec3d = Vec3d()) = minus(res, this, b, b, b)
    fun minus(b: Vec3d, res: Vec3d = Vec3d()) = minus(res, this, b.x, b.y, b.z)

    fun minusAssign(bX: Double, bY: Double, bZ: Double) = minus(this, this, bX, bY, bZ)
    infix operator fun minusAssign(b: Double) {
        minus(this, this, b, b, b)
    }

    infix operator fun minusAssign(b: Vec3d) {
        minus(this, this, b.x, b.y, b.z)
    }


    operator fun times(b: Double) = times(Vec3d(), this, b, b, b)
    operator fun times(b: Vec3d) = times(Vec3d(), this, b.x, b.y, b.z)

    fun times(bX: Double, bY: Double, bZ: Double, res: Vec3d = Vec3d()) = times(res, this, bX, bY, bZ)
    fun times(b: Double, res: Vec3d = Vec3d()) = times(res, this, b, b, b)
    fun times(b: Vec3d, res: Vec3d = Vec3d()) = times(res, this, b.x, b.y, b.z)

    fun timesAssign(bX: Double, bY: Double, bZ: Double) = times(this, this, bX, bY, bZ)
    infix operator fun timesAssign(b: Double) {
        times(this, this, b, b, b)
    }

    infix operator fun timesAssign(b: Vec3d) {
        times(this, this, b.x, b.y, b.z)
    }


    operator fun div(b: Double) = div(Vec3d(), this, b, b, b)
    operator fun div(b: Vec3d) = div(Vec3d(), this, b.x, b.y, b.z)

    fun div(bX: Double, bY: Double, bZ: Double, res: Vec3d = Vec3d()) = div(res, this, bX, bY, bZ)
    fun div(b: Double, res: Vec3d = Vec3d()) = div(res, this, b, b, b)
    fun div(b: Vec3d, res: Vec3d = Vec3d()) = div(res, this, b.x, b.y, b.z)

    fun divAssign(bX: Double, bY: Double, bZ: Double) = div(this, this, bX, bY, bZ)
    infix operator fun divAssign(b: Double) {
        div(this, this, b, b, b)
    }

    infix operator fun divAssign(b: Vec3d) {
        div(this, this, b.x, b.y, b.z)
    }


    operator fun rem(b: Double) = rem(Vec3d(), this, b, b, b)
    operator fun rem(b: Vec3d) = rem(Vec3d(), this, b.x, b.y, b.z)

    fun rem(bX: Double, bY: Double, bZ: Double, res: Vec3d = Vec3d()) = rem(res, this, bX, bY, bZ)
    fun rem(b: Double, res: Vec3d = Vec3d()) = rem(res, this, b, b, b)
    fun rem(b: Vec3d, res: Vec3d = Vec3d()) = rem(res, this, b.x, b.y, b.z)

    fun remAssign(bX: Double, bY: Double, bZ: Double) = rem(this, this, bX, bY, bZ)
    infix operator fun remAssign(b: Double) {
        rem(this, this, b, b, b)
    }

    infix operator fun remAssign(b: Vec3d) {
        rem(this, this, b.x, b.y, b.z)
    }


    // -- Generic binary arithmetic operators --

    operator fun plus(b: Number) = plus(Vec3d(), this, b.d, b.d, b.d)
    operator fun plus(b: Vec3t<out Number>) = plus(Vec3d(), this, b.x.d, b.y.d, b.z.d)

    fun plus(bX: Number, bY: Number, bZ: Number, res: Vec3d = Vec3d()) = plus(res, this, bX.d, bY.d, bZ.d)
    fun plus(b: Number, res: Vec3d = Vec3d()) = plus(res, this, b.d, b.d, b.d)
    fun plus(b: Vec3t<out Number>, res: Vec3d = Vec3d()) = plus(res, this, b.x.d, b.y.d, b.z.d)

    fun plusAssign(bX: Number, bY: Number, bZ: Number) = plus(this, this, bX.d, bY.d, bZ.d)
    infix operator fun plusAssign(b: Number) {
        plus(this, this, b.d, b.d, b.d)
    }

    infix operator fun plusAssign(b: Vec3t<out Number>) {
        plus(this, this, b.x.d, b.y.d, b.z.d)
    }


    operator fun minus(b: Number) = minus(Vec3d(), this, b.d, b.d, b.d)
    operator fun minus(b: Vec3t<out Number>) = minus(Vec3d(), this, b.x.d, b.y.d, b.z.d)

    fun minus(bX: Number, bY: Number, bZ: Number, res: Vec3d = Vec3d()) = minus(res, this, bX.d, bY.d, bZ.d)
    fun minus(b: Number, res: Vec3d = Vec3d()) = minus(res, this, b.d, b.d, b.d)
    fun minus(b: Vec3t<out Number>, res: Vec3d = Vec3d()) = minus(res, this, b.x.d, b.y.d, b.z.d)

    fun minusAssign(bX: Number, bY: Number, bZ: Number) = minus(this, this, bX.d, bY.d, bZ.d)
    infix operator fun minusAssign(b: Number) {
        minus(this, this, b.d, b.d, b.d)
    }

    infix operator fun minusAssign(b: Vec3t<out Number>) {
        minus(this, this, b.x.d, b.y.d, b.z.d)
    }


    operator fun times(b: Number) = times(Vec3d(), this, b.d, b.d, b.d)
    operator fun times(b: Vec3t<out Number>) = times(Vec3d(), this, b.x.d, b.y.d, b.z.d)

    fun times(bX: Number, bY: Number, bZ: Number, res: Vec3d = Vec3d()) = times(res, this, bX.d, bY.d, bZ.d)
    fun times(b: Number, res: Vec3d = Vec3d()) = times(res, this, b.d, b.d, b.d)
    fun times(b: Vec3t<out Number>, res: Vec3d = Vec3d()) = times(res, this, b.x.d, b.y.d, b.z.d)

    fun timesAssign(bX: Number, bY: Number, bZ: Number) = times(this, this, bX.d, bY.d, bZ.d)
    infix operator fun timesAssign(b: Number) {
        times(this, this, b.d, b.d, b.d)
    }

    infix operator fun timesAssign(b: Vec3t<out Number>) {
        times(this, this, b.x.d, b.y.d, b.z.d)
    }


    operator fun div(b: Number) = div(Vec3d(), this, b.d, b.d, b.d)
    operator fun div(b: Vec3t<out Number>) = div(Vec3d(), this, b.x.d, b.y.d, b.z.d)

    fun div(bX: Number, bY: Number, bZ: Number, res: Vec3d = Vec3d()) = div(res, this, bX.d, bY.d, bZ.d)
    fun div(b: Number, res: Vec3d = Vec3d()) = div(res, this, b.d, b.d, b.d)
    fun div(b: Vec3t<out Number>, res: Vec3d = Vec3d()) = div(res, this, b.x.d, b.y.d, b.z.d)

    fun divAssign(bX: Number, bY: Number, bZ: Number) = div(this, this, bX.d, bY.d, bZ.d)
    infix operator fun divAssign(b: Number) {
        div(this, this, b.d, b.d, b.d)
    }

    infix operator fun divAssign(b: Vec3t<out Number>) {
        div(this, this, b.x.d, b.y.d, b.z.d)
    }


    operator fun rem(b: Number) = rem(Vec3d(), this, b.d, b.d, b.d)
    operator fun rem(b: Vec3t<out Number>) = rem(Vec3d(), this, b.x.d, b.y.d, b.z.d)

    fun rem(bX: Number, bY: Number, bZ: Number, res: Vec3d = Vec3d()) = rem(res, this, bX.d, bY.d, bZ.d)
    fun rem(b: Number, res: Vec3d = Vec3d()) = rem(res, this, b.d, b.d, b.d)
    fun rem(b: Vec3t<out Number>, res: Vec3d = Vec3d()) = rem(res, this, b.x.d, b.y.d, b.z.d)

    fun remAssign(bX: Number, bY: Number, bZ: Number) = rem(this, this, bX.d, bY.d, bZ.d)
    infix operator fun remAssign(b: Number) {
        rem(this, this, b.d, b.d, b.d)
    }

    infix operator fun remAssign(b: Vec3t<out Number>) {
        rem(this, this, b.x.d, b.y.d, b.z.d)
    }


    infix fun allLessThan(d: Double): Boolean = x < d && y < d && z < d
    infix fun anyLessThan(d: Double): Boolean = x < d || y < d || z < d
    infix fun lessThan(d: Double): Vec3bool = Vec3bool { get(it) < d }

    infix fun allLessThanEqual(d: Double): Boolean = x <= d && y <= d && z <= d
    infix fun anyLessThanEqual(d: Double): Boolean = x <= d || y <= d || z <= d
    infix fun lessThanEqual(d: Double): Vec3bool = Vec3bool { get(it) <= d }

    fun allEqual(d: Double, epsilon: Float = glm.εf): Boolean = abs(x - d) < epsilon && abs(y - d) < epsilon && abs(z - d) < epsilon
    fun anyEqual(d: Double, epsilon: Float = glm.εf): Boolean = abs(x - d) < epsilon || abs(y - d) < epsilon || abs(z - d) < epsilon
    fun equal(d: Double, epsilon: Float = glm.εf): Vec3bool = Vec3bool { abs(get(it) - d) < epsilon }

    fun allNotEqual(d: Double, epsilon: Float = glm.εf): Boolean = abs(x - d) >= epsilon && abs(y - d) >= epsilon && abs(z - d) >= epsilon
    fun anyNotEqual(d: Double, epsilon: Float = glm.εf): Boolean = abs(x - d) >= epsilon || abs(y - d) >= epsilon || abs(z - d) >= epsilon
    fun notEqual(d: Double, epsilon: Float = glm.εf): Vec3bool = Vec3bool { abs(get(it) - d) >= epsilon }

    infix fun allGreaterThan(d: Double): Boolean = x > d && y > d && z > d
    infix fun anyGreaterThan(d: Double): Boolean = x > d || y > d || z > d
    infix fun greaterThan(d: Double): Vec3bool = Vec3bool { get(it) > d }

    infix fun allGreaterThanEqual(d: Double): Boolean = x >= d && y >= d && z >= d
    infix fun anyGreaterThanEqual(d: Double): Boolean = x >= d || y >= d || z >= d
    infix fun greaterThanEqual(d: Double): Vec3bool = Vec3bool { get(it) >= d }


    infix fun allLessThan(v: Vec3d): Boolean = x < v.x && y < v.y && z < v.z
    infix fun anyLessThan(v: Vec3d): Boolean = x < v.x || y < v.y || z < v.z
    infix fun lessThan(v: Vec3d): Vec3bool = Vec3bool { get(it) < v[it] }

    infix fun allLessThanEqual(v: Vec3d): Boolean = x <= v.x && y <= v.y && z <= v.z
    infix fun anyLessThanEqual(v: Vec3d): Boolean = x <= v.x || y <= v.y || z <= v.z
    infix fun lessThanEqual(v: Vec3d): Vec3bool = Vec3bool { get(it) <= v[it] }

    fun allEqual(v: Vec3d, epsilon: Double = glm.ε): Boolean = abs(x - v.x) < epsilon && abs(y - v.y) < epsilon && abs(z - v.z) < epsilon
    fun anyEqual(v: Vec3d, epsilon: Double = glm.ε): Boolean = abs(x - v.x) < epsilon || abs(y - v.y) < epsilon || abs(z - v.z) < epsilon
    fun equal(v: Vec3d, epsilon: Double = glm.ε): Vec3bool = Vec3bool { abs(get(it) - v[it]) < epsilon }

    fun allNotEqual(v: Vec3d, epsilon: Double = glm.ε): Boolean = abs(x - v.x) >= epsilon && abs(y - v.y) >= epsilon && abs(z - v.z) >= epsilon
    fun anyNotEqual(v: Vec3d, epsilon: Double = glm.ε): Boolean = abs(x - v.x) >= epsilon || abs(y - v.y) >= epsilon || abs(z - v.z) >= epsilon
    fun notEqual(v: Vec3d, epsilon: Double = glm.ε): Vec3bool = Vec3bool { abs(get(it) - v[it]) >= epsilon }

    infix fun allGreaterThan(v: Vec3d): Boolean = x > v.x && y > v.y && z > v.z
    infix fun anyGreaterThan(v: Vec3d): Boolean = x > v.x || y > v.y || z > v.z
    infix fun greaterThan(v: Vec3d): Vec3bool = Vec3bool { get(it) > v[it] }

    infix fun allGreaterThanEqual(v: Vec3d): Boolean = x >= v.x && y >= v.y && z >= v.z
    infix fun anyGreaterThanEqual(v: Vec3d): Boolean = x >= v.x || y >= v.y || z >= v.z
    infix fun greaterThanEqual(v: Vec3d): Vec3bool = Vec3bool { get(it) >= v[it] }


    // -- functions --

    infix fun dot(b: Vec3d) = glm.dot(this, b)   // TODO others

    fun length() = glm.length(this)
    fun length2() = glm.length2(this)

    @JvmOverloads
    fun normalize(res: Vec3d = Vec3d()) = glm.normalize(this, res) // TODO others

    fun normalizeAssign() = glm.normalize(this, this)

    infix fun cross(b: Vec3d) = glm.cross(this, b)
    fun crossAssign(b: Vec3d) = glm.cross(this, b, this)

    @JvmOverloads
    fun negate(res: Vec3d = Vec3d()): Vec3d {
        res.x = -x
        res.y = -y
        res.z = -z
        return res
    }

    fun negateAssign() = negate(this)


    companion object : vec3d_operators {
        const val length = Vec3t.length

        @JvmField
        val size = length * Double.BYTES

        @JvmStatic
        fun fromPointer(ptr: Ptr<Double>) = Vec3d(ptr)
    }

    override fun size() = size

    override fun elementCount() = length

    override fun equals(other: Any?) = other is Vec3d && this[0] == other[0] && this[1] == other[1] && this[2] == other[2]
    override fun hashCode() = 31 * (31 * x.hashCode() + y.hashCode()) + z.hashCode()

    @JvmOverloads
    fun print(name: String = "", stream: PrintStream = System.out) = stream.print("$name$this")

    @JvmOverloads
    fun println(name: String = "", stream: PrintStream = System.out) = stream.println("$name$this")

    override fun toString(): String = "($x, $y, $z)"
}