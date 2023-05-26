package glm_.vec2

import glm_.*
import glm_.vec1.Vec1bool
import glm_.vec1.Vec1t
import glm_.vec2.operators.opVec2
import glm_.vec3.Vec3bool
import glm_.vec3.Vec3t
import glm_.vec4.Vec4bool
import glm_.vec4.Vec4t
import kool.*
import org.lwjgl.system.MemoryUtil.memGetFloat
import java.awt.Color
import java.io.InputStream
import java.io.PrintStream
import java.nio.*
import kotlin.math.abs

/**
 * Created bY GBarbieri on 05.10.2016.
 */

class Vec2(@JvmField var ofs: Int, @JvmField var array: FloatArray) : Vec2t<Float>(), ToFloatBuffer {

    override inline var x: Float
        get() = array[ofs]
        set(value) = array.set(ofs, value)
    override inline var y: Float
        get() = array[ofs + 1]
        set(value) = array.set(ofs + 1, value)

    // -- Implicit basic constructors --

    constructor() : this(0, 0)
    constructor(v: Vec2) : this(v.x, v.y)

    // -- Explicit basic constructors --

    @JvmOverloads
    constructor(x: Float, y: Float = x) : this(0, floatArrayOf(x, y))

    // -- Conversion constructors --

    @JvmOverloads
    constructor(x: Number, y: Number = x) : this(x.f, y.f)

    // Explicit conversions (From section 5.4.1 Conversion and scalar constructors of GLSL 1.30.08 specification)

    constructor(x: Number, v: Vec1t<out Number>) : this(x, v.x)
    @JvmOverloads
    constructor(v: Vec1t<out Number>, y: Number = v.x) : this(v.x, y)

    constructor(x: Vec1t<out Number>, y: Vec1t<out Number>) : this(x.x, y.x)

    constructor(v: Vec2t<out Number>) : this(v.x, v.y)
    constructor(v: Vec3t<out Number>) : this(v.x, v.y)
    constructor(v: Vec4t<out Number>) : this(v.x, v.y)

    @JvmOverloads
    constructor(x: Boolean, y: Boolean = x) : this(x.f, y.f)

    constructor(x: Boolean, v: Vec1bool) : this(x.f, v.x.f)
    @JvmOverloads
    constructor(v: Vec1bool, y: Boolean = v.x) : this(v.x.f, y.f)

    constructor(x: Vec1bool, y: Vec1bool) : this(x.x.f, y.x.f)

    constructor(v: Vec2bool) : this(v.x.f, v.y.f)
    constructor(v: Vec3bool) : this(v.x.f, v.y.f)
    constructor(v: Vec4bool) : this(v.x.f, v.y.f)

    constructor(bytes: ByteArray, index: Int = 0, oneByteOneFloat: Boolean = false, bigEndian: Boolean = true) : this(
            if (oneByteOneFloat) bytes[index].f else bytes.getFloat(index, bigEndian),
            if (oneByteOneFloat) bytes[index + 1].f else bytes.getFloat(index + Float.BYTES, bigEndian))

    constructor(chars: CharArray, index: Int = 0) : this(chars[index].f, chars[index + 1].f)
    constructor(shorts: ShortArray, index: Int = 0) : this(shorts[index], shorts[index + 1])
    constructor(ints: IntArray, index: Int = 0) : this(ints[index], ints[index + 1])
    constructor(longs: LongArray, index: Int = 0) : this(longs[index], longs[index + 1])
    constructor(floats: FloatArray, index: Int = 0) : this(floats[index], floats[index + 1])
    constructor(doubles: DoubleArray, index: Int = 0) : this(doubles[index], doubles[index + 1])
    constructor(booleans: BooleanArray, index: Int = 0) : this(booleans[index].f, booleans[index + 1].f)

    constructor(numbers: Array<out Number>, index: Int = 0) : this(numbers[index], numbers[index + 1])
    constructor(chars: Array<Char>, index: Int = 0) : this(chars[index].f, chars[index + 1].f)
    constructor(booleans: Array<Boolean>, index: Int = 0) : this(booleans[index].f, booleans[index + 1].f)

    constructor(list: Iterable<*>, index: Int = 0) : this(list.elementAt(index)!!.toFloat, list.elementAt(index + 1)!!.toFloat)

    constructor(bytes: ByteBuffer, index: Int = bytes.pos, oneByteOneFloat: Boolean = false) : this(
            if (oneByteOneFloat) bytes[index].f else bytes.getFloat(index),
            if (oneByteOneFloat) bytes[index + 1].f else bytes.getFloat(index + Float.BYTES))

    constructor(chars: CharBuffer, index: Int = chars.pos) : this(chars[index].f, chars[index + 1].f)
    constructor(shorts: ShortBuffer, index: Int = shorts.pos) : this(shorts[index], shorts[index + 1])
    constructor(ints: IntBuffer, index: Int = ints.pos) : this(ints[index], ints[index + 1])
    constructor(longs: LongBuffer, index: Int = longs.pos) : this(longs[index], longs[index + 1])
    constructor(floats: FloatBuffer, index: Int = floats.pos) : this(floats[index], floats[index + 1])
    constructor(doubles: DoubleBuffer, index: Int = doubles.pos) : this(doubles[index], doubles[index + 1])

    constructor(block: (Int) -> Float) : this(block(0), block(1))
    constructor(ptr: Ptr<Float>) : this(ptr[0], ptr[1])

    constructor(inputStream: InputStream, bigEndian: Boolean = true) : this(inputStream.float(bigEndian), inputStream.float(bigEndian))

    constructor(color: Color) : this(color.red / 255f, color.green / 255f)

    fun set(bytes: ByteArray, index: Int = 0, oneByteOneFloat: Boolean = false, bigEndian: Boolean = true) {
        if (oneByteOneFloat) {
            x = bytes[index].f
            y = bytes[index + 1].f
        } else {
            x = bytes.getFloat(index, bigEndian)
            y = bytes.getFloat(index + Float.BYTES, bigEndian)
        }
    }

    fun set(bytes: ByteBuffer, index: Int = bytes.pos, oneByteOneFloat: Boolean = false) {
        if (oneByteOneFloat) {
            x = bytes[index].f
            y = bytes[index + 1].f
        } else {
            x = bytes.getFloat(index)
            y = bytes.getFloat(index + Float.BYTES)
        }
    }


    fun put(x: Float, y: Float) {
        this.x = x
        this.y = y
    }

    operator fun invoke(x: Float, y: Float): Vec2 {
        this.x = x
        this.y = y
        return this
    }

    override fun put(x: Number, y: Number) {
        this.x = x.f
        this.y = y.f
    }

    override operator fun invoke(x: Number, y: Number): Vec2 {
        this.x = x.f
        this.y = y.f
        return this
    }

    fun to(bytes: ByteArray, index: Int) = to(bytes, index, true)
    override fun to(bytes: ByteArray, index: Int, bigEndian: Boolean): ByteArray {
        bytes.putFloat(index, x, bigEndian)
        bytes.putFloat(index + Float.BYTES, y, bigEndian)
        return bytes
    }

    fun toFloatArray(): FloatArray = to(FloatArray(length), 0)
    infix fun to(floats: FloatArray): FloatArray = to(floats, 0)
    fun to(floats: FloatArray, index: Int): FloatArray {
        System.arraycopy(array, 0, floats, index, length)
        return floats
    }

    override fun to(buf: ByteBuffer, offset: Int): ByteBuffer {
        return buf
                .putFloat(offset + 0 * Float.BYTES, array[0])
                .putFloat(offset + 1 * Float.BYTES, array[1])
    }

    override fun to(buf: FloatBuffer, offset: Int): FloatBuffer {
        buf[offset + 0] = array[0]
        buf[offset + 1] = array[1]
        return buf
    }

    infix fun to(ptr: Ptr<Float>){
        ptr[0] = x
        ptr[1] = y
    }

    @JvmName("toPtrByte")
    infix fun to(ptr: Ptr<Byte>) = to(ptr.toPtr<Float>())

    // -- Component accesses --

    operator fun set(index: Int, value: Float) = when (index) {
        0 -> x = value
        1 -> y = value
        else -> throw ArrayIndexOutOfBoundsException()
    }

    override operator fun set(index: Int, value: Number) = when (index) {
        0 -> x = value.f
        1 -> y = value.f
        else -> throw ArrayIndexOutOfBoundsException()
    }

    // -- Unary arithmetic operators --

    operator fun unaryPlus() = this

    operator fun unaryMinus() = Vec2(-x, -y)

    // -- Increment main.and decrement operators --

    operator fun inc() = plus(Vec2(), this, 1f, 1f)

    infix fun inc(res: Vec2) = plus(res, this, 1f, 1f)
    fun incAssign() = plus(this, this, 1f, 1f)


    operator fun dec() = minus(Vec2(), this, 1f, 1f)
    infix fun dec(res: Vec2) = minus(res, this, 1f, 1f)
    fun decAssign() = minus(this, this, 1f, 1f)

    // -- Specific binary arithmetic operators --

    infix operator fun plus(b: Float) = plus(Vec2(), this, b, b)
    infix operator fun plus(b: Vec2) = plus(Vec2(), this, b.x, b.y)

    @JvmOverloads
    fun plus(bX: Float, bY: Float, res: Vec2 = Vec2()) = plus(res, this, bX, bY)

    fun plus(b: Float, res: Vec2) = plus(res, this, b, b)
    fun plus(b: Vec2, res: Vec2) = plus(res, this, b.x, b.y)

    fun plusAssign(bX: Float, bY: Float) = plus(this, this, bX, bY)
    infix operator fun plusAssign(b: Float) {
        plus(this, this, b, b)
    }

    infix operator fun plusAssign(b: Vec2) {
        plus(this, this, b.x, b.y)
    }


    infix operator fun minus(b: Float) = minus(Vec2(), this, b, b)
    infix operator fun minus(b: Vec2) = minus(Vec2(), this, b.x, b.y)

    @JvmOverloads
    fun minus(bX: Float, bY: Float, res: Vec2 = Vec2()) = minus(res, this, bX, bY)

    fun minus(b: Float, res: Vec2) = minus(res, this, b, b)
    fun minus(b: Vec2, res: Vec2) = minus(res, this, b.x, b.y)

    fun minusAssign(bX: Float, bY: Float) = minus(this, this, bX, bY)
    infix operator fun minusAssign(b: Float) {
        minus(this, this, b, b)
    }

    infix operator fun minusAssign(b: Vec2) {
        minus(this, this, b.x, b.y)
    }


    infix operator fun times(b: Float) = times(Vec2(), this, b, b)
    infix operator fun times(b: Vec2) = times(Vec2(), this, b.x, b.y)

    @JvmOverloads
    fun times(bX: Float, bY: Float, res: Vec2 = Vec2()) = times(res, this, bX, bY)

    fun times(b: Float, res: Vec2) = times(res, this, b, b)
    fun times(b: Vec2, res: Vec2) = times(res, this, b.x, b.y)

    fun timesAssign(bX: Float, bY: Float) = times(this, this, bX, bY)
    infix operator fun timesAssign(b: Float) {
        times(this, this, b, b)
    }

    infix operator fun timesAssign(b: Vec2) {
        times(this, this, b.x, b.y)
    }


    infix operator fun div(b: Float) = div(Vec2(), this, b, b)
    infix operator fun div(b: Vec2) = div(Vec2(), this, b.x, b.y)

    @JvmOverloads
    fun div(bX: Float, bY: Float, res: Vec2 = Vec2()) = div(res, this, bX, bY)

    fun div(b: Float, res: Vec2) = div(res, this, b, b)
    fun div(b: Vec2, res: Vec2) = div(res, this, b.x, b.y)

    fun divAssign(bX: Float, bY: Float) = div(this, this, bX, bY)
    infix operator fun divAssign(b: Float) {
        div(this, this, b, b)
    }

    infix operator fun divAssign(b: Vec2) {
        div(this, this, b.x, b.y)
    }


    infix operator fun rem(b: Float) = rem(Vec2(), this, b, b)
    infix operator fun rem(b: Vec2) = rem(Vec2(), this, b.x, b.y)

    @JvmOverloads
    fun rem(bX: Float, bY: Float, res: Vec2 = Vec2()) = rem(res, this, bX, bY)

    fun rem(b: Float, res: Vec2) = rem(res, this, b, b)
    fun rem(b: Vec2, res: Vec2) = rem(res, this, b.x, b.y)

    fun remAssign(bX: Float, bY: Float) = rem(this, this, bX, bY)
    infix operator fun remAssign(b: Float) {
        rem(this, this, b, b)
    }

    infix operator fun remAssign(b: Vec2) {
        rem(this, this, b.x, b.y)
    }


    // -- Generic binary arithmetic operators --

    infix operator fun plus(b: Number) = plus(Vec2(), this, b.f, b.f)
    infix operator fun plus(b: Vec2t<out Number>) = plus(Vec2(), this, b.x.f, b.y.f)

    @JvmOverloads
    fun plus(bX: Number, bY: Number, res: Vec2 = Vec2()) = plus(res, this, bX.f, bY.f)

    fun plus(b: Number, res: Vec2) = plus(res, this, b.f, b.f)
    fun plus(b: Vec2t<out Number>, res: Vec2) = plus(res, this, b.x.f, b.y.f)

    fun plusAssign(bX: Number, bY: Number) = plus(this, this, bX.f, bY.f)
    infix operator fun plusAssign(b: Number) {
        plus(this, this, b.f, b.f)
    }

    infix operator fun plusAssign(b: Vec2t<out Number>) {
        plus(this, this, b.x.f, b.y.f)
    }


    infix operator fun minus(b: Number) = minus(Vec2(), this, b.f, b.f)
    infix operator fun minus(b: Vec2t<out Number>) = minus(Vec2(), this, b.x.f, b.y.f)

    @JvmOverloads
    fun minus(bX: Number, bY: Number, res: Vec2 = Vec2()) = minus(res, this, bX.f, bY.f)

    fun minus(b: Number, res: Vec2) = minus(res, this, b.f, b.f)
    fun minus(b: Vec2t<out Number>, res: Vec2) = minus(res, this, b.x.f, b.y.f)

    fun minusAssign(bX: Number, bY: Number) = minus(this, this, bX.f, bY.f)
    infix operator fun minusAssign(b: Number) {
        minus(this, this, b.f, b.f)
    }

    infix operator fun minusAssign(b: Vec2t<out Number>) {
        minus(this, this, b.x.f, b.y.f)
    }


    infix operator fun times(b: Number) = times(Vec2(), this, b.f, b.f)
    infix operator fun times(b: Vec2t<out Number>) = times(Vec2(), this, b.x.f, b.y.f)

    @JvmOverloads
    fun times(bX: Number, bY: Number, res: Vec2 = Vec2()) = times(res, this, bX.f, bY.f)

    fun times(b: Number, res: Vec2) = times(res, this, b.f, b.f)
    fun times(b: Vec2t<out Number>, res: Vec2) = times(res, this, b.x.f, b.y.f)

    fun timesAssign(bX: Number, bY: Number) = times(this, this, bX.f, bY.f)
    infix operator fun timesAssign(b: Number) {
        times(this, this, b.f, b.f)
    }

    infix operator fun timesAssign(b: Vec2t<out Number>) {
        times(this, this, b.x.f, b.y.f)
    }


    infix operator fun div(b: Number) = div(Vec2(), this, b.f, b.f)
    infix operator fun div(b: Vec2t<out Number>) = div(Vec2(), this, b.x.f, b.y.f)

    @JvmOverloads
    fun div(bX: Number, bY: Number, res: Vec2 = Vec2()) = div(res, this, bX.f, bY.f)

    fun div(b: Number, res: Vec2) = div(res, this, b.f, b.f)
    fun div(b: Vec2t<out Number>, res: Vec2) = div(res, this, b.x.f, b.y.f)

    fun divAssign(bX: Number, bY: Number) = div(this, this, bX.f, bY.f)
    infix operator fun divAssign(b: Number) {
        div(this, this, b.f, b.f)
    }

    infix operator fun divAssign(b: Vec2t<out Number>) {
        div(this, this, b.x.f, b.y.f)
    }


    infix operator fun rem(b: Number) = rem(Vec2(), this, b.f, b.f)
    infix operator fun rem(b: Vec2t<out Number>) = rem(Vec2(), this, b.x.f, b.y.f)

    @JvmOverloads
    fun rem(bX: Number, bY: Number, res: Vec2 = Vec2()) = rem(res, this, bX.f, bY.f)

    fun rem(b: Number, res: Vec2) = rem(res, this, b.f, b.f)
    fun rem(b: Vec2t<out Number>, res: Vec2) = rem(res, this, b.x.f, b.y.f)

    fun remAssign(bX: Number, bY: Number) = rem(this, this, bX.f, bY.f)
    infix operator fun remAssign(b: Number) {
        rem(this, this, b.f, b.f)
    }

    infix operator fun remAssign(b: Vec2t<out Number>) {
        rem(this, this, b.x.f, b.y.f)
    }

    // -- functions --

    // TODO others
    infix fun max(b: Vec2) = glm.max(this, b, Vec2())

    infix fun maxAssign(b: Vec2) {
        x = glm.max(x, b.x)
        y = glm.max(y, b.y)
    }

    infix fun max(b: Vec2t<*>): Vec2 {
        val res = Vec2()
        res.x = glm.max(x, b.x.f)
        res.y = glm.max(y, b.y.f)
        return res
    }

    infix fun maxAssign(b: Vec2t<*>) {
        x = glm.max(x, b.x.f)
        y = glm.max(y, b.y.f)
    }

    infix fun max(b: Float) = glm.max(this, b, Vec2())

    infix fun maxAssign(b: Float) {
        x = glm.max(x, b)
        y = glm.max(y, b)
    }

    infix fun max(b: Number): Vec2 {
        val res = Vec2()
        res.x = glm.max(x, b.f)
        res.y = glm.max(y, b.f)
        return res
    }

    infix fun maxAssign(b: Number) {
        x = glm.max(x, b.f)
        y = glm.max(y, b.f)
    }

    infix fun min(b: Vec2) = glm.min(this, b, Vec2())

    infix fun minAssign(b: Vec2) {
        x = glm.min(x, b.x)
        y = glm.min(y, b.y)
    }

    infix fun min(b: Vec2t<*>): Vec2 {
        val res = Vec2()
        res.x = glm.min(x, b.x.f)
        res.y = glm.min(y, b.y.f)
        return res
    }

    infix fun minAssign(b: Vec2t<*>) {
        x = glm.min(x, b.x.f)
        y = glm.min(y, b.y.f)
    }

    infix fun min(b: Float) = glm.min(this, b, Vec2())

    infix fun minAssign(b: Float) {
        x = glm.min(x, b)
        y = glm.min(y, b)
    }

    infix fun min(b: Number): Vec2 {
        val res = Vec2()
        res.x = glm.min(x, b.f)
        res.y = glm.min(y, b.f)
        return res
    }

    infix fun minAssign(b: Number) {
        x = glm.min(x, b.f)
        y = glm.min(y, b.f)
    }


    infix fun allLessThan(f: Float): Boolean = x < f && y < f
    infix fun anyLessThan(f: Float): Boolean = x < f || y < f
    infix fun lessThan(f: Float): Vec2bool = Vec2bool { get(it) < f }

    infix fun allLessThanEqual(f: Float): Boolean = x <= f && y <= f
    infix fun anyLessThanEqual(f: Float): Boolean = x <= f || y <= f
    infix fun lessThanEqual(f: Float): Vec2bool = Vec2bool { get(it) <= f }

    fun allEqual(f: Float, epsilon: Float = glm.εf): Boolean = abs(x - f) < epsilon && abs(y - f) < epsilon
    fun anyEqual(f: Float, epsilon: Float = glm.εf): Boolean = abs(x - f) < epsilon || abs(y - f) < epsilon
    fun equal(f: Float, epsilon: Float = glm.εf): Vec2bool = Vec2bool { abs(get(it) - f) < epsilon }

    fun allNotEqual(f: Float, epsilon: Float = glm.εf): Boolean = abs(x - f) >= epsilon && abs(y - f) >= epsilon
    fun anyNotEqual(f: Float, epsilon: Float = glm.εf): Boolean = abs(x - f) >= epsilon || abs(y - f) >= epsilon
    fun notEqual(f: Float, epsilon: Float = glm.εf): Vec2bool = Vec2bool { abs(get(it) - f) >= epsilon }

    infix fun allGreaterThan(f: Float): Boolean = x > f && y > f
    infix fun anyGreaterThan(f: Float): Boolean = x > f || y > f
    infix fun greaterThan(f: Float): Vec2bool = Vec2bool { get(it) > f }

    infix fun allGreaterThanEqual(f: Float): Boolean = x >= f && y >= f
    infix fun anyGreaterThanEqual(f: Float): Boolean = x >= f || y >= f
    infix fun greaterThanEqual(f: Float): Vec2bool = Vec2bool { get(it) >= f }


    infix fun allLessThan(v: Vec2): Boolean = x < v.x && y < v.y
    infix fun anyLessThan(v: Vec2): Boolean = x < v.x || y < v.y
    infix fun lessThan(v: Vec2): Vec2bool = Vec2bool { get(it) < v[it] }

    infix fun allLessThanEqual(v: Vec2): Boolean = x <= v.x && y <= v.y
    infix fun anyLessThanEqual(v: Vec2): Boolean = x <= v.x || y <= v.y
    infix fun lessThanEqual(v: Vec2): Vec2bool = Vec2bool { get(it) <= v[it] }

    fun allEqual(v: Vec2, epsilon: Float = glm.εf): Boolean = abs(x - v.x) < epsilon && abs(y - v.y) < epsilon
    fun anyEqual(v: Vec2, epsilon: Float = glm.εf): Boolean = abs(x - v.x) < epsilon || abs(y - v.y) < epsilon
    fun equal(v: Vec2, epsilon: Float = glm.εf): Vec2bool = Vec2bool { abs(get(it) - v[it]) < epsilon }

    fun allNotEqual(v: Vec2, epsilon: Float = glm.εf): Boolean = abs(x - v.x) >= epsilon && abs(y - v.y) >= epsilon
    fun anyNotEqual(v: Vec2, epsilon: Float = glm.εf): Boolean = abs(x - v.x) >= epsilon || abs(y - v.y) >= epsilon
    fun notEqual(v: Vec2, epsilon: Float = glm.εf): Vec2bool = Vec2bool { abs(get(it) - v[it]) >= epsilon }

    infix fun allGreaterThan(v: Vec2): Boolean = x > v.x && y > v.y
    infix fun anyGreaterThan(v: Vec2): Boolean = x > v.x || y > v.y
    infix fun greaterThan(v: Vec2): Vec2bool = Vec2bool { get(it) > v[it] }

    infix fun allGreaterThanEqual(v: Vec2): Boolean = x >= v.x && y >= v.y
    infix fun anyGreaterThanEqual(v: Vec2): Boolean = x >= v.x || y >= v.y
    infix fun greaterThanEqual(v: Vec2): Vec2bool = Vec2bool { get(it) >= v[it] }


    infix fun <T : Number> allLessThan(v: Vec2t<T>): Boolean = x < v.x.f && y < v.y.f
    infix fun <T : Number> anyLessThan(v: Vec2t<T>): Boolean = x < v.x.f || y < v.y.f

    infix fun <T : Number> allLessThanEqual(v: Vec2t<T>): Boolean = x <= v.x.f && y <= v.y.f
    infix fun <T : Number> anyLessThanEqual(v: Vec2t<T>): Boolean = x <= v.x.f || y <= v.y.f

    infix fun <T : Number> allEqual(v: Vec2t<T>): Boolean = x == v.x.f && y == v.y.f
    infix fun <T : Number> anyEqual(v: Vec2t<T>): Boolean = x == v.x.f || y == v.y.f

    infix fun <T : Number> allNotEqual(v: Vec2t<T>): Boolean = x != v.x.f && y != v.y.f
    infix fun <T : Number> anyNotEqual(v: Vec2t<T>): Boolean = x != v.x.f || y != v.y.f

    infix fun <T : Number> allGreaterThan(v: Vec2t<T>): Boolean = x > v.x.f && y > v.y.f
    infix fun <T : Number> anyGreaterThan(v: Vec2t<T>): Boolean = x > v.x.f || y > v.y.f

    infix fun <T : Number> allGreaterThanEqual(v: Vec2t<T>): Boolean = x >= v.x.f && y >= v.y.f
    infix fun <T : Number> anyGreaterThanEqual(v: Vec2t<T>): Boolean = x >= v.x.f || y >= v.y.f


    infix fun dot(b: Vec2) = glm.dot(this, b)

    infix fun rotate(angle: Float) = glm.rotate(Vec2(), this, angle)

    fun length() = glm.length(this)
    fun length2() = glm.length2(this)

    @JvmOverloads
    fun normalize(res: Vec2 = Vec2()) = glm.normalize(this, res) // TODO others

    fun normalizeAssign() = glm.normalize(this, this)

    infix fun cross(b: Vec2) = glm.cross(this, b)

    fun negateAssign() = negate(this)

    @JvmOverloads
    fun negate(res: Vec2 = Vec2()): Vec2 {
        res.x = -x
        res.y = -y
        return res
    }


    companion object : opVec2 {
        const val length = Vec2t.length
        @JvmField
        val size = length * Float.BYTES

        @JvmStatic
        fun fromPointer(ptr: Ptr<Float>) = Vec2(ptr)
    }

    override fun size() = size

    override fun elementCount() = length

    override fun equals(other: Any?) = other is Vec2 && this[0] == other[0] && this[1] == other[1]

    override fun hashCode() = 31 * x.hashCode() + y.hashCode()

    @JvmOverloads
    fun print(name: String = "", stream: PrintStream = System.out) = stream.print("$name$this")

    @JvmOverloads
    fun println(name: String = "", stream: PrintStream = System.out) = stream.println("$name$this")
}