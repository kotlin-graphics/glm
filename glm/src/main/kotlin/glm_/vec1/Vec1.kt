package glm_.vec1

import glm_.*
import glm_.vec1.operators.opVec1
import glm_.vec2.Vec2bool
import glm_.vec2.Vec2t
import glm_.vec3.Vec3bool
import glm_.vec3.Vec3t
import glm_.vec4.Vec4bool
import glm_.vec4.Vec4t
import kool.pos
import kool.set
import java.nio.*
import kotlin.math.abs

/**
 * Created by GBarbieri on 28.04.2017.
 */

class Vec1(x: Float) : Vec1t<Float>(x), ToFloatBuffer {

    // -- Explicit basic, conversion other main.and conversion vector constructors --

    constructor() : this(0f)

    constructor(v: Vec1t<out Number>) : this(v.x)
    constructor(v: Vec2t<out Number>) : this(v.x)
    constructor(v: Vec3t<out Number>) : this(v.x)
    constructor(v: Vec4t<out Number>) : this(v.x)

    constructor(v: Vec1bool) : this(v.x.f)
    constructor(v: Vec2bool) : this(v.x.f)
    constructor(v: Vec3bool) : this(v.x.f)
    constructor(v: Vec4bool) : this(v.x.f)

    constructor(bytes: ByteArray, index: Int = 0, oneByteOneFloat: Boolean = false, bigEndian: Boolean = true)
            : this(if (oneByteOneFloat) bytes[index].f else bytes.getFloat(index, bigEndian))

    constructor(chars: CharArray, index: Int = 0) : this(chars[index].f)
    constructor(shorts: ShortArray, index: Int = 0) : this(shorts[index])
    constructor(ints: IntArray, index: Int = 0) : this(ints[index])
    constructor(longs: LongArray, index: Int = 0) : this(longs[index])
    constructor(floats: FloatArray, index: Int = 0) : this(floats[index])
    constructor(doubles: DoubleArray, index: Int = 0) : this(doubles[index])
    constructor(booleans: BooleanArray, index: Int = 0) : this(booleans[index].f)

    constructor(numbers: Array<out Number>, index: Int = 0) : this(numbers[index])
    constructor(chars: Array<Char>, index: Int = 0) : this(chars[index].f)
    constructor(booleans: Array<Boolean>, index: Int = 0) : this(booleans[index].f)

    constructor(list: List<Any>, index: Int = 0) : this() {
        put(list, index)
    }

    constructor(bytes: ByteBuffer, index: Int = bytes.pos, oneByteOneFloat: Boolean = false)
            : this(if (oneByteOneFloat) bytes[index].f else bytes.getFloat(index))

    constructor(chars: CharBuffer, index: Int = chars.pos) : this(chars[index].f)
    constructor(shorts: ShortBuffer, index: Int = shorts.pos) : this(shorts[index])
    constructor(ints: IntBuffer, index: Int = ints.pos) : this(ints[index])
    constructor(longs: LongBuffer, index: Int = longs.pos) : this(longs[index])
    constructor(floats: FloatBuffer, index: Int = floats.pos) : this(floats[index])
    constructor(doubles: DoubleBuffer, index: Int = doubles.pos) : this(doubles[index])

    constructor(block: (Int) -> Float) : this(block(0))

    constructor(s: Number) : this(s.f)


    fun set(bytes: ByteArray, index: Int = 0, oneByteOneFloat: Boolean = false, bigEndian: Boolean = true) {
        x = if (oneByteOneFloat) bytes[index].f else bytes.getFloat(index, bigEndian)
    }

    fun set(bytes: ByteBuffer, index: Int = bytes.pos, oneByteOneFloat: Boolean = false) {
        x = if (oneByteOneFloat) bytes[index].f else bytes.getFloat(index)
    }

    fun put(x: Float) {
        this.x = x
    }

    operator fun invoke(x: Float): Vec1 {
        this.x = x
        return this
    }

    override fun put(x: Number) {
        this.x = x.f
    }

    override operator fun invoke(x: Number): Vec1 {
        this.x = x.f
        return this
    }

    fun to(bytes: ByteArray, index: Int) = to(bytes, index, true)
    override fun to(bytes: ByteArray, index: Int, bigEndian: Boolean): ByteArray {
        bytes.putFloat(index, x, bigEndian)
        return bytes
    }


    override fun to(buf: ByteBuffer, offset: Int): ByteBuffer = buf.putFloat(offset, x)

    fun toFloatArray(): FloatArray = to(FloatArray(length), 0)
    infix fun to(floats: FloatArray): FloatArray = to(floats, 0)
    fun to(floats: FloatArray, index: Int): FloatArray {
        floats[index] = x
        return floats
    }

    override fun to(buf: FloatBuffer, offset: Int): FloatBuffer {
        buf[offset] = x
        return buf
    }

    // -- Unary arithmetic operators --

    operator fun unaryPlus() = this

    operator fun unaryMinus() = Vec1(-x)


    // -- Increment main.and decrement operators --

    operator fun inc() = plus(Vec1(), this, 1f)

    infix fun inc(res: Vec1) = plus(res, this, 1f)
    fun incAssign() = plus(this, this, 1f)


    operator fun dec() = minus(Vec1(), this, 1f)
    infix fun dec(res: Vec1) = minus(res, this, 1f)
    fun decAssign() = minus(this, this, 1f)


    // -- Specific binary arithmetic operators --

    infix operator fun plus(b: Float) = plus(Vec1(), this, b)
    infix operator fun plus(b: Vec1) = plus(Vec1(), this, b.x)

    fun plus(b: Float, res: Vec1) = plus(res, this, b)
    fun plus(b: Vec1, res: Vec1) = plus(res, this, b.x)

    infix operator fun plusAssign(b: Float) {
        plus(this, this, b)
    }

    infix operator fun plusAssign(b: Vec1) {
        plus(this, this, b.x)
    }


    infix operator fun minus(b: Float) = minus(Vec1(), this, b)
    infix operator fun minus(b: Vec1) = minus(Vec1(), this, b.x)

    fun minus(b: Float, res: Vec1) = minus(res, this, b)
    fun minus(b: Vec1, res: Vec1) = minus(res, this, b.x)

    infix operator fun minusAssign(b: Float) {
        minus(this, this, b)
    }

    infix operator fun minusAssign(b: Vec1) {
        minus(this, this, b.x)
    }


    infix operator fun times(b: Float) = times(Vec1(), this, b)
    infix operator fun times(b: Vec1) = times(Vec1(), this, b.x)

    fun times(b: Float, res: Vec1) = times(res, this, b)
    fun times(b: Vec1, res: Vec1) = times(res, this, b.x)

    infix operator fun timesAssign(b: Float) {
        times(this, this, b)
    }

    infix operator fun timesAssign(b: Vec1) {
        times(this, this, b.x)
    }


    infix operator fun div(b: Float) = div(Vec1(), this, b)
    infix operator fun div(b: Vec1) = div(Vec1(), this, b.x)

    fun div(b: Float, res: Vec1) = div(res, this, b)
    fun div(b: Vec1, res: Vec1) = div(res, this, b.x)

    infix operator fun divAssign(b: Float) {
        div(this, this, b)
    }

    infix operator fun divAssign(b: Vec1) {
        div(this, this, b.x)
    }


    infix operator fun rem(b: Float) = rem(Vec1(), this, b)
    infix operator fun rem(b: Vec1) = rem(Vec1(), this, b.x)

    fun rem(b: Float, res: Vec1) = rem(res, this, b)
    fun rem(b: Vec1, res: Vec1) = rem(res, this, b.x)

    infix operator fun remAssign(b: Float) {
        rem(this, this, b)
    }

    infix operator fun remAssign(b: Vec1) {
        rem(this, this, b.x)
    }


    // -- Generic binary arithmetic operators --

    infix operator fun plus(b: Number) = plus(Vec1(), this, b.f)
    infix operator fun plus(b: Vec1t<out Number>) = plus(Vec1(), this, b.x.f)

    fun plus(b: Number, res: Vec1) = plus(res, this, b.f)
    fun plus(b: Vec1t<out Number>, res: Vec1) = plus(res, this, b.x.f)

    infix operator fun plusAssign(b: Number) {
        plus(this, this, b.f)
    }

    infix operator fun plusAssign(b: Vec1t<out Number>) {
        plus(this, this, b.x.f)
    }


    infix operator fun minus(b: Number) = minus(Vec1(), this, b.f)
    infix operator fun minus(b: Vec1t<out Number>) = minus(Vec1(), this, b.x.f)

    fun minus(b: Number, res: Vec1) = minus(res, this, b.f)
    fun minus(b: Vec1t<out Number>, res: Vec1) = minus(res, this, b.x.f)

    infix operator fun minusAssign(b: Number) {
        minus(this, this, b.f)
    }

    infix operator fun minusAssign(b: Vec1t<out Number>) {
        minus(this, this, b.x.f)
    }


    infix operator fun times(b: Number) = times(Vec1(), this, b.f)
    infix operator fun times(b: Vec1t<out Number>) = times(Vec1(), this, b.x.f)

    fun times(b: Number, res: Vec1) = times(res, this, b.f)
    fun times(b: Vec1t<out Number>, res: Vec1) = times(res, this, b.x.f)

    infix operator fun timesAssign(b: Number) {
        times(this, this, b.f)
    }

    infix operator fun timesAssign(b: Vec1t<out Number>) {
        times(this, this, b.x.f)
    }


    infix operator fun div(b: Number) = div(Vec1(), this, b.f)
    infix operator fun div(b: Vec1t<out Number>) = div(Vec1(), this, b.x.f)

    fun div(b: Number, res: Vec1) = div(res, this, b.f)
    fun div(b: Vec1t<out Number>, res: Vec1) = div(res, this, b.x.f)

    infix operator fun divAssign(b: Number) {
        div(this, this, b.f)
    }

    infix operator fun divAssign(b: Vec1t<out Number>) {
        div(this, this, b.x.f)
    }


    infix operator fun rem(b: Number) = rem(Vec1(), this, b.f)
    infix operator fun rem(b: Vec1t<out Number>) = rem(Vec1(), this, b.x.f)

    fun rem(b: Number, res: Vec1) = rem(res, this, b.f)
    fun rem(b: Vec1t<out Number>, res: Vec1) = rem(res, this, b.x.f)

    infix operator fun remAssign(b: Number) {
        rem(this, this, b.f)
    }

    infix operator fun remAssign(b: Vec1t<out Number>) {
        rem(this, this, b.x.f)
    }


    companion object : opVec1 {
        const val length = Vec1t.length
        @JvmField
        val size = length * Float.BYTES
    }

    override fun size() = size

    override fun elementCount() = length

    override fun equals(other: Any?) = other is Vec1 && this[0] == other[0]
    fun equal(b: Vec1, epsilon: Float = 0f): Boolean = abs(x - b.x) <= epsilon
    fun notEqual(b: Vec1, epsilon: Float = 0f): Boolean = !equal(b, epsilon)

    override fun hashCode() = x.hashCode()
}
