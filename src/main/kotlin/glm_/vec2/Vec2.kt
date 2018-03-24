package glm_.vec2

import glm_.*
import glm_.vec2.operators.opVec2
import glm_.vec3.Vec3bool
import glm_.vec3.Vec3t
import glm_.vec4.Vec4bool
import glm_.vec4.Vec4t
import java.nio.*

/**
 * Created bY GBarbieri on 05.10.2016.
 */

class Vec2(x: Float, y: Float) : Vec2t<Float>(x, y) {

    // -- Explicit basic, conversion other main.and conversion vector constructors --

    constructor() : this(0)

    constructor(v: Vec2t<out Number>) : this(v.x, v.y)
    constructor(v: Vec3t<out Number>) : this(v.x, v.y)
    constructor(v: Vec4t<out Number>) : this(v.x, v.y)

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

    constructor(bytes: ByteBuffer, index: Int = bytes.position(), oneByteOneFloat: Boolean = false) : this(
            if (oneByteOneFloat) bytes[index].f else bytes.getFloat(index),
            if (oneByteOneFloat) bytes[index + 1].f else bytes.getFloat(index + Float.BYTES))

    constructor(chars: CharBuffer, index: Int = chars.position()) : this(chars[index].f, chars[index + 1].f)
    constructor(shorts: ShortBuffer, index: Int = shorts.position()) : this(shorts[index], shorts[index + 1])
    constructor(ints: IntBuffer, index: Int = ints.position()) : this(ints[index], ints[index + 1])
    constructor(longs: LongBuffer, index: Int = longs.position()) : this(longs[index], longs[index + 1])
    constructor(floats: FloatBuffer, index: Int = floats.position()) : this(floats[index], floats[index + 1])
    constructor(doubles: DoubleBuffer, index: Int = doubles.position()) : this(doubles[index], doubles[index + 1])

    constructor(block: (Int) -> Float) : this(block(0), block(1))

    constructor(s: Number) : this(s, s)
    constructor(x: Number, y: Number) : this(x.f, y.f)


    fun set(bytes: ByteArray, index: Int = 0, oneByteOneFloat: Boolean = false, bigEndian: Boolean = true) {
        if (oneByteOneFloat) {
            x = bytes[index].f
            y = bytes[index + 1].f
        } else {
            x = bytes.getFloat(index, bigEndian)
            y = bytes.getFloat(index + Float.BYTES, bigEndian)
        }
    }

    fun set(bytes: ByteBuffer, index: Int = bytes.position(), oneByteOneFloat: Boolean = false) {
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

    fun invoke(x: Float, y: Float): Vec2 {
        this.x = x
        this.y = y
        return this
    }

    override fun put(x: Number, y: Number) {
        this.x = x.f
        this.y = y.f
    }

    override fun invoke(x: Number, y: Number): Vec2 {
        this.x = x.f
        this.y = y.f
        return this
    }

    fun to(bytes: ByteArray, index: Int) = to(bytes, index, true)
    override fun to(bytes: ByteArray, index: Int, bigEndian: Boolean): ByteArray {
        bytes.setFloat(index, x)
        bytes.setFloat(index + Float.BYTES, y)
        return bytes
    }

    override fun to(bytes: ByteBuffer, index: Int): ByteBuffer {
        bytes.putFloat(index, x)
        bytes.putFloat(index + Float.BYTES, y)
        return bytes
    }

    fun toFloatArray() = to(FloatArray(Companion.length), 0)
    infix fun to(floats: FloatArray) = to(floats, 0)
    fun to(floats: FloatArray, index: Int): FloatArray {
        floats[index] = x
        floats[index + 1] = y
        return floats
    }

    fun toFloatBuffer() = to(ByteBuffer.allocateDirect(size).asFloatBuffer(), 0)
    infix fun to(floats: FloatBuffer) = to(floats, floats.position())
    fun to(floats: FloatBuffer, index: Int): FloatBuffer {
        floats[index] = x
        floats[index + 1] = y
        return floats
    }

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

    infix fun lessThan(f: Float) = x < f && y < f
    infix fun lessThanEqual(f: Float) = x <= f && y <= f
    infix fun equal(f: Float) = x == f && y == f
    infix fun notEqual(f: Float) = x != f && y != f
    infix fun greaterThan(f: Float) = x > f && y > f
    infix fun greaterThanEqual(f: Float) = x >= f && y >= f

    infix fun dot(b: Vec2) = glm.dot(this, b)

    infix fun rotate(angle: Float) = glm.rotate(Vec2(), this, angle)

    val length get() = glm.length(this)
    val length2 get() = glm.length2(this)

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


    companion object : opVec2() {
        const val length = Vec2t.length
        @JvmField
        val size = length * Float.BYTES
    }

    override fun size() = size

    override fun equals(other: Any?) = other is Vec2 && this[0] == other[0] && this[1] == other[1]
    override fun hashCode() = 31 * x.hashCode() + y.hashCode()
}