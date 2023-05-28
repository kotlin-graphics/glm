package glm_.vec2

import glm_.*
import glm_.vec1.Vec1bool
import glm_.vec1.Vec1t
import glm_.vec2.operators.opVec2d
import glm_.vec3.Vec3bool
import glm_.vec3.Vec3t
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
 * Created bY GBarbieri on 06.10.2016.
 */

class Vec2d(@JvmField var ofs: Int, @JvmField var array: DoubleArray) : Vec2t<Double>, ToDoubleBuffer {

    inline var x: Double
        get() = array[ofs]
        set(value) = array.set(ofs, value)
    inline var y: Double
        get() = array[ofs + 1]
        set(value) = array.set(ofs + 1, value)

    // -- Implicit basic constructors --

    constructor() : this(0)
    constructor(v: Vec2d) : this(v.x, v.y)

    // -- Explicit basic constructors --

    @JvmOverloads
    constructor(x: Double, y: Double = x) : this(0, doubleArrayOf(x, y))

    // -- Conversion constructors --

    @JvmOverloads
    constructor(x: Number, y: Number = x) : this(x.d, y.d)

    // Explicit conversions (From section 5.4.1 Conversion and scalar constructors of GLSL 1.30.08 specification)

    constructor(v: Vec1t<out Number>) : this(v._x, v._x)
    constructor(x: Vec1t<out Number>, y: Number) : this(x._x, y)
    constructor(x: Number, y: Vec1t<out Number>) : this(x, y._x)
    constructor(x: Vec1t<out Number>, y: Vec1t<out Number>) : this(x._x, y._x)

    constructor(v: Vec2t<out Number>) : this(v._x, v._y)
    constructor(v: Vec3t<out Number>) : this(v._x, v._y)
    constructor(v: Vec4t<out Number>) : this(v._x, v._y)

    constructor(v: Vec1d) : this(v.x, v.x)
    constructor(x: Vec1d, y: Double) : this(x.x, y)
    constructor(x: Double, y: Vec1d) : this(x, y.x)
    constructor(x: Vec1d, y: Vec1d) : this(x.x, y.x)

    constructor(v: Vec3d) : this(v.x, v.y)
    constructor(v: Vec4d) : this(v.x, v.y)

    @JvmOverloads
    constructor(x: Boolean, y: Boolean = x) : this(x.d, y.d)

    constructor(x: Boolean, v: Vec1bool) : this(x.d, v.x.d)

    @JvmOverloads
    constructor(v: Vec1bool, y: Boolean = v.x) : this(v.x.d, y.d)

    constructor(x: Vec1bool, y: Vec1bool) : this(x.x.d, y.x.d)

    constructor(v: Vec2bool) : this(v.x.d, v.y.d)
    constructor(v: Vec3bool) : this(v.x.d, v.y.d)
    constructor(v: Vec4bool) : this(v.x.d, v.y.d)

    constructor(bytes: ByteArray, index: Int = 0, oneByteOneDouble: Boolean = false, bigEndian: Boolean = true) : this(
        if (oneByteOneDouble) bytes[index].d else bytes.getDouble(index, bigEndian),
        if (oneByteOneDouble) bytes[index + 1].d else bytes.getDouble(index + Double.BYTES, bigEndian))

    constructor(chars: CharArray, index: Int = 0) : this(chars[index].d, chars[index + 1].d)
    constructor(shorts: ShortArray, index: Int = 0) : this(shorts[index], shorts[index + 1])
    constructor(ints: IntArray, index: Int = 0) : this(ints[index], ints[index + 1])
    constructor(longs: LongArray, index: Int = 0) : this(longs[index], longs[index + 1])
    constructor(floats: FloatArray, index: Int = 0) : this(floats[index], floats[index + 1])
    constructor(doubles: DoubleArray, index: Int = 0) : this(doubles[index], doubles[index + 1])
    constructor(booleans: BooleanArray, index: Int = 0) : this(booleans[index].d, booleans[index + 1].d)

    constructor(numbers: Array<out Number>, index: Int = 0) : this(numbers[index], numbers[index + 1])
    constructor(chars: Array<Char>, index: Int = 0) : this(chars[index].d, chars[index + 1].d)
    constructor(booleans: Array<Boolean>, index: Int = 0) : this(booleans[index].d, booleans[index + 1].d)

    constructor(list: Iterable<*>, index: Int = 0) : this(list.elementAt(index)!!.toDouble, list.elementAt(index + 1)!!.toDouble)

    constructor(bytes: ByteBuffer, index: Int = bytes.pos, oneByteOneDouble: Boolean = false) : this(
        if (oneByteOneDouble) bytes[index].d else bytes.getDouble(index),
        if (oneByteOneDouble) bytes[index + 1].d else bytes.getDouble(index + Double.BYTES))

    constructor(chars: CharBuffer, index: Int = chars.pos) : this(chars[index].d, chars[index + 1].d)
    constructor(shorts: ShortBuffer, index: Int = shorts.pos) : this(shorts[index], shorts[index + 1])
    constructor(ints: IntBuffer, index: Int = ints.pos) : this(ints[index], ints[index + 1])
    constructor(longs: LongBuffer, index: Int = longs.pos) : this(longs[index], longs[index + 1])
    constructor(floats: FloatBuffer, index: Int = floats.pos) : this(floats[index], floats[index + 1])
    constructor(doubles: DoubleBuffer, index: Int = doubles.pos) : this(doubles[index], doubles[index + 1])

    constructor(block: (Int) -> Double) : this(block(0), block(1))
    constructor(ptr: Ptr<Double>) : this(ptr[0], ptr[1])

    constructor(inputStream: InputStream, bigEndian: Boolean = true) : this(inputStream.double(bigEndian), inputStream.double(bigEndian))

    constructor(color: Color) : this(color.red / 255.0, color.green / 255.0)

    fun set(bytes: ByteArray, index: Int = 0, oneByteOneDouble: Boolean = false, bigEndian: Boolean = true) {
        x = if (oneByteOneDouble) bytes[index].d else bytes.getDouble(index, bigEndian)
        y = if (oneByteOneDouble) bytes[index + 1].d else bytes.getDouble(index + Double.BYTES, bigEndian)
    }

    fun set(bytes: ByteBuffer, index: Int = bytes.pos, oneByteOneDouble: Boolean = false) {
        x = if (oneByteOneDouble) bytes[index].d else bytes.getDouble(index)
        y = if (oneByteOneDouble) bytes[index + 1].d else bytes.getDouble(index + Double.BYTES)
    }


    fun put(x: Double, y: Double) {
        this.x = x
        this.y = y
    }

    operator fun invoke(x: Double, y: Double): Vec2d {
        this.x = x
        this.y = y
        return this
    }

    override fun put(x: Number, y: Number) {
        this.x = x.d
        this.y = y.d
    }

    override operator fun invoke(x: Number, y: Number): Vec2d {
        this.x = x.d
        this.y = y.d
        return this
    }

    fun to(bytes: ByteArray, index: Int): ByteArray = to(bytes, index, true)
    override fun to(bytes: ByteArray, index: Int, bigEndian: Boolean): ByteArray {
        bytes.putDouble(index, x)
        bytes.putDouble(index + Double.BYTES, y)
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
        return buf
    }

    override fun to(buf: DoubleBuffer, offset: Int): DoubleBuffer {
        buf[offset] = x
        buf[offset + 1] = y
        return buf
    }

    infix fun to(ptr: Ptr<Double>) {
        ptr[0] = x
        ptr[1] = y
    }

    // -- Component accesses --

    override operator fun set(index: Int, value: Number) = when (index) {
        0 -> x = value.d
        1 -> y = value.d
        else -> throw ArrayIndexOutOfBoundsException()
    }


    // -- Unary arithmetic operators --

    operator fun unaryPlus() = this

    operator fun unaryMinus() = Vec2d(-x, -y)

    // -- Increment main.and decrement operators --

    operator fun inc() = plus(Vec2d(), this, 1.0, 1.0)
    infix fun inc(res: Vec2d) = plus(res, this, 1.0, 1.0)
    fun incAssign() = plus(this, this, 1.0, 1.0)


    operator fun dec() = minus(Vec2d(), this, 1.0, 1.0)
    infix fun dec(res: Vec2d) = minus(res, this, 1.0, 1.0)
    fun decAssign() = minus(this, this, 1.0, 1.0)


    // -- Specific binary arithmetic operators --

    infix operator fun plus(b: Double) = plus(Vec2d(), this, b, b)
    infix operator fun plus(b: Vec2d) = plus(Vec2d(), this, b.x, b.y)

    @JvmOverloads
    fun plus(bX: Double, bY: Double, res: Vec2d = Vec2d()) = plus(res, this, bX, bY)

    fun plus(b: Double, res: Vec2d) = plus(res, this, b, b)
    fun plus(b: Vec2d, res: Vec2d) = plus(res, this, b.x, b.y)

    fun plusAssign(bX: Double, bY: Double) = plus(this, this, bX, bY)
    infix operator fun plusAssign(b: Double) {
        plus(this, this, b, b)
    }

    infix operator fun plusAssign(b: Vec2d) {
        plus(this, this, b.x, b.y)
    }


    infix operator fun minus(b: Double) = minus(Vec2d(), this, b, b)
    infix operator fun minus(b: Vec2d) = minus(Vec2d(), this, b.x, b.y)

    @JvmOverloads
    fun minus(bX: Double, bY: Double, res: Vec2d = Vec2d()) = minus(res, this, bX, bY)

    fun minus(b: Double, res: Vec2d) = minus(res, this, b, b)
    fun minus(b: Vec2d, res: Vec2d) = minus(res, this, b.x, b.y)

    fun minusAssign(bX: Double, bY: Double) = minus(this, this, bX, bY)
    infix operator fun minusAssign(b: Double) {
        minus(this, this, b, b)
    }

    infix operator fun minusAssign(b: Vec2d) {
        minus(this, this, b.x, b.y)
    }


    infix operator fun times(b: Double) = times(Vec2d(), this, b, b)
    infix operator fun times(b: Vec2d) = times(Vec2d(), this, b.x, b.y)

    @JvmOverloads
    fun times(bX: Double, bY: Double, res: Vec2d = Vec2d()) = times(res, this, bX, bY)

    fun times(b: Double, res: Vec2d) = times(res, this, b, b)
    fun times(b: Vec2d, res: Vec2d) = times(res, this, b.x, b.y)

    fun timesAssign(bX: Double, bY: Double) = times(this, this, bX, bY)
    infix operator fun timesAssign(b: Double) {
        times(this, this, b, b)
    }

    infix operator fun timesAssign(b: Vec2d) {
        times(this, this, b.x, b.y)
    }


    infix operator fun div(b: Double) = div(Vec2d(), this, b, b)
    infix operator fun div(b: Vec2d) = div(Vec2d(), this, b.x, b.y)

    @JvmOverloads
    fun div(bX: Double, bY: Double, res: Vec2d = Vec2d()) = div(res, this, bX, bY)

    fun div(b: Double, res: Vec2d) = div(res, this, b, b)
    fun div(b: Vec2d, res: Vec2d) = div(res, this, b.x, b.y)

    fun divAssign(bX: Double, bY: Double) = div(this, this, bX, bY)
    infix operator fun divAssign(b: Double) {
        div(this, this, b, b)
    }

    infix operator fun divAssign(b: Vec2d) {
        div(this, this, b.x, b.y)
    }


    infix operator fun rem(b: Double) = rem(Vec2d(), this, b, b)
    infix operator fun rem(b: Vec2d) = rem(Vec2d(), this, b.x, b.y)

    @JvmOverloads
    fun rem(bX: Double, bY: Double, res: Vec2d = Vec2d()) = rem(res, this, bX, bY)

    fun rem(b: Double, res: Vec2d) = rem(res, this, b, b)
    fun rem(b: Vec2d, res: Vec2d) = rem(res, this, b.x, b.y)

    fun remAssign(bX: Double, bY: Double) = rem(this, this, bX, bY)
    infix operator fun remAssign(b: Double) {
        rem(this, this, b, b)
    }

    infix operator fun remAssign(b: Vec2d) {
        rem(this, this, b.x, b.y)
    }


    // -- Generic binary arithmetic operators --

    infix operator fun plus(b: Number) = plus(Vec2d(), this, b.d, b.d)
    infix operator fun plus(b: Vec2t<out Number>) = plus(Vec2d(), this, b._x.d, b._y.d)

    @JvmOverloads
    fun plus(bX: Number, bY: Number, res: Vec2d = Vec2d()) = plus(res, this, bX.d, bY.d)

    fun plus(b: Number, res: Vec2d) = plus(res, this, b.d, b.d)
    fun plus(b: Vec2t<out Number>, res: Vec2d) = plus(res, this, b._x.d, b._y.d)

    fun plusAssign(bX: Number, bY: Number) = plus(this, this, bX.d, bY.d)
    infix operator fun plusAssign(b: Number) {
        plus(this, this, b.d, b.d)
    }

    infix operator fun plusAssign(b: Vec2t<out Number>) {
        plus(this, this, b._x.d, b._y.d)
    }


    infix operator fun minus(b: Number) = minus(Vec2d(), this, b.d, b.d)
    infix operator fun minus(b: Vec2t<out Number>) = minus(Vec2d(), this, b._x.d, b._y.d)

    @JvmOverloads
    fun minus(bX: Number, bY: Number, res: Vec2d = Vec2d()) = minus(res, this, bX.d, bY.d)

    fun minus(b: Number, res: Vec2d) = minus(res, this, b.d, b.d)
    fun minus(b: Vec2t<out Number>, res: Vec2d) = minus(res, this, b._x.d, b._y.d)

    fun minusAssign(bX: Number, bY: Number) = minus(this, this, bX.d, bY.d)
    infix operator fun minusAssign(b: Number) {
        minus(this, this, b.d, b.d)
    }

    infix operator fun minusAssign(b: Vec2t<out Number>) {
        minus(this, this, b._x.d, b._y.d)
    }


    infix operator fun times(b: Number) = times(Vec2d(), this, b.d, b.d)
    infix operator fun times(b: Vec2t<out Number>) = times(Vec2d(), this, b._x.d, b._y.d)

    @JvmOverloads
    fun times(bX: Number, bY: Number, res: Vec2d = Vec2d()) = times(res, this, bX.d, bY.d)

    fun times(b: Number, res: Vec2d) = times(res, this, b.d, b.d)
    fun times(b: Vec2t<out Number>, res: Vec2d) = times(res, this, b._x.d, b._y.d)

    fun timesAssign(bX: Number, bY: Number) = times(this, this, bX.d, bY.d)
    infix operator fun timesAssign(b: Number) {
        times(this, this, b.d, b.d)
    }

    infix operator fun timesAssign(b: Vec2t<out Number>) {
        times(this, this, b._x.d, b._y.d)
    }


    infix operator fun div(b: Number) = div(Vec2d(), this, b.d, b.d)
    infix operator fun div(b: Vec2t<out Number>) = div(Vec2d(), this, b._x.d, b._y.d)

    @JvmOverloads
    fun div(bX: Number, bY: Number, res: Vec2d = Vec2d()) = div(res, this, bX.d, bY.d)

    fun div(b: Number, res: Vec2d) = div(res, this, b.d, b.d)
    fun div(b: Vec2t<out Number>, res: Vec2d) = div(res, this, b._x.d, b._y.d)

    fun divAssign(bX: Number, bY: Number) = div(this, this, bX.d, bY.d)
    infix operator fun divAssign(b: Number) {
        div(this, this, b.d, b.d)
    }

    infix operator fun divAssign(b: Vec2t<out Number>) {
        div(this, this, b._x.d, b._y.d)
    }


    infix operator fun rem(b: Number) = rem(Vec2d(), this, b.d, b.d)
    infix operator fun rem(b: Vec2t<out Number>) = rem(Vec2d(), this, b._x.d, b._y.d)

    @JvmOverloads
    fun rem(bX: Number, bY: Number, res: Vec2d = Vec2d()) = rem(res, this, bX.d, bY.d)

    fun rem(b: Number, res: Vec2d) = rem(res, this, b.d, b.d)
    fun rem(b: Vec2t<out Number>, res: Vec2d) = rem(res, this, b._x.d, b._y.d)

    fun remAssign(bX: Number, bY: Number) = rem(this, this, bX.d, bY.d)
    infix operator fun remAssign(b: Number) {
        rem(this, this, b.d, b.d)
    }

    infix operator fun remAssign(b: Vec2t<out Number>) {
        rem(this, this, b._x.d, b._y.d)
    }


    infix fun allLessThan(d: Double): Boolean = x < d && y < d
    infix fun anyLessThan(d: Double): Boolean = x < d || y < d
    infix fun lessThan(d: Double): Vec2bool = Vec2bool { get(it) < d }

    infix fun allLessThanEqual(d: Double): Boolean = x <= d && y <= d
    infix fun anyLessThanEqual(d: Double): Boolean = x <= d || y <= d
    infix fun lessThanEqual(d: Double): Vec2bool = Vec2bool { get(it) <= d }

    fun allEqual(d: Double, epsilon: Double = glm.ε): Boolean = abs(x - d) < epsilon && (y - d) < epsilon
    fun anyEqual(d: Double, epsilon: Double = glm.ε): Boolean = abs(x - d) < epsilon || (y - d) < epsilon
    fun equal(d: Double, epsilon: Double = glm.ε): Vec2bool = Vec2bool { abs(get(it) - d) < epsilon }

    fun allNotEqual(d: Double, epsilon: Double = glm.ε): Boolean = abs(x - d) >= epsilon && (y - d) >= epsilon
    fun anyNotEqual(d: Double, epsilon: Double = glm.ε): Boolean = abs(x - d) >= epsilon || (y - d) >= epsilon
    fun notEqual(d: Double, epsilon: Double = glm.ε): Vec2bool = Vec2bool { abs(get(it) - d) >= epsilon }

    infix fun allGreaterThan(d: Double): Boolean = x > d && y > d
    infix fun anyGreaterThan(d: Double): Boolean = x > d || y > d
    infix fun greaterThan(d: Double): Vec2bool = Vec2bool { get(it) > d }

    infix fun allGreaterThanEqual(d: Double): Boolean = x >= d && y >= d
    infix fun anyGreaterThanEqual(d: Double): Boolean = x >= d || y >= d
    infix fun greaterThanEqual(d: Double): Vec2bool = Vec2bool { get(it) >= d }


    infix fun allLessThan(v: Vec2d): Boolean = x < v.x && y < v.y
    infix fun anyLessThan(v: Vec2d): Boolean = x < v.x || y < v.y
    infix fun lessThan(v: Vec2d): Vec2bool = Vec2bool { get(it) < v[it] }

    infix fun allLessThanEqual(v: Vec2d): Boolean = x <= v.x && y <= v.y
    infix fun anyLessThanEqual(v: Vec2d): Boolean = x <= v.x || y <= v.y
    infix fun lessThanEqual(v: Vec2d): Vec2bool = Vec2bool { get(it) <= v[it] }

    fun allEqual(v: Vec2d, epsilon: Double = glm.ε): Boolean = abs(x - v.x) < epsilon && abs(y - v.y) < epsilon
    fun anyEqual(v: Vec2d, epsilon: Double = glm.ε): Boolean = abs(x - v.x) < epsilon || abs(y - v.y) < epsilon
    fun equal(v: Vec2d, epsilon: Double = glm.ε): Vec2bool = Vec2bool { abs(get(it) - v[it]) < epsilon }

    fun allNotEqual(v: Vec2d, epsilon: Double = glm.ε): Boolean = abs(x - v.x) >= epsilon && abs(y - v.y) >= epsilon
    fun anyNotEqual(v: Vec2d, epsilon: Double = glm.ε): Boolean = abs(x - v.x) >= epsilon || abs(y - v.y) >= epsilon
    fun notEqual(v: Vec2d, epsilon: Double = glm.ε): Vec2bool = Vec2bool { abs(get(it) - v[it]) >= epsilon }

    infix fun allGreaterThan(v: Vec2d): Boolean = x > v.x && y > v.y
    infix fun anyGreaterThan(v: Vec2d): Boolean = x > v.x || y > v.y
    infix fun greaterThan(v: Vec2d): Vec2bool = Vec2bool { get(it) > v[it] }

    infix fun allGreaterThanEqual(v: Vec2d): Boolean = x >= v.x && y >= v.y
    infix fun anyGreaterThanEqual(v: Vec2d): Boolean = x >= v.x || y >= v.y
    infix fun greaterThanEqual(v: Vec2d): Vec2bool = Vec2bool { get(it) >= v[it] }


    // -- functions --

    infix fun dot(b: Vec2d) = glm.dot(this, b)

    fun length() = glm.length(this)
    fun length2() = glm.length2(this)

    @JvmOverloads
    fun normalize(res: Vec2d = Vec2d()) = glm.normalize(this, res) // TODO others

    fun normalizeAssign() = glm.normalize(this, this)

    infix fun cross(b: Vec2d) = glm.cross(this, b)

    @JvmOverloads
    fun negate(res: Vec2d = Vec2d()): Vec2d {
        res.x = -x
        res.y = -y
        return res
    }

    fun negateAssign() = negate(this)


    companion object : opVec2d {
        const val length = Vec2t.LENGTH

        @JvmField
        val size = length * Double.BYTES

        @JvmStatic
        fun fromPointer(ptr: Ptr<Double>) = Vec2d(ptr)
    }

    override fun size() = size

    override fun elementCount() = length

    override fun equals(other: Any?) = other is Vec2d && this[0] == other[0] && this[1] == other[1]

    override fun hashCode() = 31 * x.hashCode() + y.hashCode()

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
    //@formatter:on

    override inline operator fun get(index: Int): Double = array[ofs + index]

    override inline operator fun set(index: Int, value: Double) {
        array[ofs + index] = value
    }

    override inline fun component1() = x
    override inline fun component2() = y


    override fun toString(): String = "($x, $y)"
}
