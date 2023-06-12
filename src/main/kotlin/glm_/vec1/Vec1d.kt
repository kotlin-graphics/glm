package glm_.vec1

import glm_.*
import glm_.vec1.operators.opVec1d
import glm_.vec2.Vec2bool
import glm_.vec2.Vec2d
import glm_.vec2.Vec2t
import glm_.vec3.Vec3bool
import glm_.vec3.Vec3d
import glm_.vec3.Vec3t
import glm_.vec4.Vec4bool
import glm_.vec4.Vec4d
import glm_.vec4.Vec4t
import kool.*
import java.nio.*
import kotlin.math.abs

/**
 * Created by GBarbieri on 28.04.2017.
 */

class Vec1d(@JvmField inline var x: Double) : Vec1t<Double>, ToDoubleBuffer {

    // -- Implicit basic constructors --

    constructor() : this(0f)
    constructor(s: Number) : this(s.d)

    // -- Explicit basic constructors --
    // Explicit conversions (From section 5.4.1 Conversion and scalar constructors of GLSL 1.30.08 specification)

    constructor(v: Vec1d) : this(v.x)
    constructor(v: Vec2d) : this(v.x)
    constructor(v: Vec3d) : this(v.x)
    constructor(v: Vec4d) : this(v.x)

    constructor(v: Vec1t<out Number>) : this(v._x)
    constructor(v: Vec2t<out Number>) : this(v._x)
    constructor(v: Vec3t<out Number>) : this(v._x)
    constructor(v: Vec4t<out Number>) : this(v._x)

    constructor(v: Vec1bool) : this(v.x.d)
    constructor(v: Vec2bool) : this(v.x.d)
    constructor(v: Vec3bool) : this(v.x.d)
    constructor(v: Vec4bool) : this(v.x.d)

    constructor(bytes: ByteArray, index: Int = 0, oneByteOneDouble: Boolean = false, bigEndian: Boolean = true)
            : this(if (oneByteOneDouble) bytes[index].d else bytes.getDouble(index, bigEndian))

    constructor(chars: CharArray, index: Int = 0) : this(chars[index].d)
    constructor(shorts: ShortArray, index: Int = 0) : this(shorts[index])
    constructor(ints: IntArray, index: Int = 0) : this(ints[index])
    constructor(longs: LongArray, index: Int = 0) : this(longs[index])
    constructor(floats: FloatArray, index: Int = 0) : this(floats[index])
    constructor(doubles: DoubleArray, index: Int = 0) : this(doubles[index])
    constructor(booleans: BooleanArray, index: Int = 0) : this(booleans[index].d)

    constructor(numbers: Array<out Number>, index: Int = 0) : this(numbers[index])
    constructor(chars: Array<Char>, index: Int = 0) : this(chars[index].d)
    constructor(booleans: Array<Boolean>, index: Int = 0) : this(booleans[index].d)

    constructor(list: List<Any>, index: Int = 0) : this() {
        put(list, index)
    }

    constructor(bytes: ByteBuffer, index: Int = bytes.pos, oneByteOneDouble: Boolean = false)
            : this(if (oneByteOneDouble) bytes[index].d else bytes.getDouble(index))

    constructor(chars: CharBuffer, index: Int = chars.pos) : this(chars[index].d)
    constructor(shorts: ShortBuffer, index: Int = shorts.pos) : this(shorts[index])
    constructor(ints: IntBuffer, index: Int = ints.pos) : this(ints[index])
    constructor(longs: LongBuffer, index: Int = longs.pos) : this(longs[index])
    constructor(floats: FloatBuffer, index: Int = floats.pos) : this(floats[index])
    constructor(doubles: DoubleBuffer, index: Int = doubles.pos) : this(doubles[index])

    constructor(block: (Int) -> Double) : this(block(0))
    constructor(ptr: Ptr<Double>) : this(ptr[0])


    fun set(bytes: ByteArray, index: Int = 0, oneByteOneDouble: Boolean = false, bigEndian: Boolean = true) {
        x = if (oneByteOneDouble) bytes[index].d else bytes.getDouble(index, bigEndian)
    }

    fun set(bytes: ByteBuffer, index: Int = bytes.pos, oneByteOneDouble: Boolean = false) {
        x = if (oneByteOneDouble) bytes[index].d else bytes.getDouble(index)
    }


    fun put(x: Double) {
        this.x = x
    }

    operator fun invoke(x: Double): Vec1d {
        this.x = x
        return this
    }

    override fun put(x: Number) {
        this.x = x.d
    }

    override operator fun invoke(x: Number): Vec1d {
        this.x = x.d
        return this
    }

    fun to(bytes: ByteArray, index: Int) = to(bytes, index, true)
    override fun to(bytes: ByteArray, index: Int, bigEndian: Boolean): ByteArray {
        bytes.putDouble(index, x)
        return bytes
    }

    override fun to(buf: ByteBuffer, offset: Int): ByteBuffer = buf.putDouble(offset, x)

    fun toDoubleArray(): DoubleArray = to(DoubleArray(length), 0)
    infix fun to(doubles: DoubleArray): DoubleArray = to(doubles, 0)
    fun to(doubles: DoubleArray, index: Int): DoubleArray {
        doubles[index] = x
        return doubles
    }

    override fun to(buf: DoubleBuffer, index: Int): DoubleBuffer {
        buf[index] = x
        return buf
    }

    // -- Unary arithmetic operators --

    operator fun unaryPlus() = this

    operator fun unaryMinus() = Vec1d(-x)

    // -- Increment main.and decrement operators --

    operator fun inc() = plus(Vec1d(), this, 1.0)

    infix fun inc(res: Vec1d) = plus(res, this, 1.0)
    fun incAssign() = plus(this, this, 1.0)


    operator fun dec() = minus(Vec1d(), this, 1.0)
    infix fun dec(res: Vec1d) = minus(res, this, 1.0)
    fun decAssign() = minus(this, this, 1.0)

    // -- Specific binary arithmetic operators --

    infix operator fun plus(b: Double) = plus(Vec1d(), this, b)
    infix operator fun plus(b: Vec1d) = plus(Vec1d(), this, b.x)

    fun plus(b: Double, res: Vec1d) = plus(res, this, b)
    fun plus(b: Vec1d, res: Vec1d) = plus(res, this, b.x)

    infix operator fun plusAssign(b: Double) {
        plus(this, this, b)
    }

    infix operator fun plusAssign(b: Vec1d) {
        plus(this, this, b.x)
    }


    infix operator fun minus(b: Double) = minus(Vec1d(), this, b)
    infix operator fun minus(b: Vec1d) = minus(Vec1d(), this, b.x)

    fun minus(b: Double, res: Vec1d) = minus(res, this, b)
    fun minus(b: Vec1d, res: Vec1d) = minus(res, this, b.x)

    infix operator fun minusAssign(b: Double) {
        minus(this, this, b)
    }

    infix operator fun minusAssign(b: Vec1d) {
        minus(this, this, b.x)
    }


    infix operator fun times(b: Double) = times(Vec1d(), this, b)
    infix operator fun times(b: Vec1d) = times(Vec1d(), this, b.x)

    fun times(b: Double, res: Vec1d) = times(res, this, b)
    fun times(b: Vec1d, res: Vec1d) = times(res, this, b.x)

    infix operator fun timesAssign(b: Double) {
        times(this, this, b)
    }

    infix operator fun timesAssign(b: Vec1d) {
        times(this, this, b.x)
    }


    infix operator fun div(b: Double) = div(Vec1d(), this, b)
    infix operator fun div(b: Vec1d) = div(Vec1d(), this, b.x)

    fun div(b: Double, res: Vec1d) = div(res, this, b)
    fun div(b: Vec1d, res: Vec1d) = div(res, this, b.x)

    infix operator fun divAssign(b: Double) {
        div(this, this, b)
    }

    infix operator fun divAssign(b: Vec1d) {
        div(this, this, b.x)
    }


    infix operator fun rem(b: Double) = rem(Vec1d(), this, b)
    infix operator fun rem(b: Vec1d) = rem(Vec1d(), this, b.x)

    fun rem(b: Double, res: Vec1d) = rem(res, this, b)
    fun rem(b: Vec1d, res: Vec1d) = rem(res, this, b.x)

    infix operator fun remAssign(b: Double) {
        rem(this, this, b)
    }

    infix operator fun remAssign(b: Vec1d) {
        rem(this, this, b.x)
    }


    // -- Generic binary arithmetic operators --

    infix operator fun plus(b: Number) = plus(Vec1d(), this, b.d)
    infix operator fun plus(b: Vec1t<out Number>) = plus(Vec1d(), this, b._x.d)

    fun plus(b: Number, res: Vec1d) = plus(res, this, b.d)
    fun plus(b: Vec1t<out Number>, res: Vec1d) = plus(res, this, b._x.d)

    infix operator fun plusAssign(b: Number) {
        plus(this, this, b.d)
    }

    infix operator fun plusAssign(b: Vec1t<out Number>) {
        plus(this, this, b._x.d)
    }


    infix operator fun minus(b: Number) = minus(Vec1d(), this, b.d)
    infix operator fun minus(b: Vec1t<out Number>) = minus(Vec1d(), this, b._x.d)

    fun minus(b: Number, res: Vec1d) = minus(res, this, b.d)
    fun minus(b: Vec1t<out Number>, res: Vec1d) = minus(res, this, b._x.d)

    infix operator fun minusAssign(b: Number) {
        minus(this, this, b.d)
    }

    infix operator fun minusAssign(b: Vec1t<out Number>) {
        minus(this, this, b._x.d)
    }


    infix operator fun times(b: Number) = times(Vec1d(), this, b.d)
    infix operator fun times(b: Vec1t<out Number>) = times(Vec1d(), this, b._x.d)

    fun times(b: Number, res: Vec1d) = times(res, this, b.d)
    fun times(b: Vec1t<out Number>, res: Vec1d) = times(res, this, b._x.d)

    infix operator fun timesAssign(b: Number) {
        times(this, this, b.d)
    }

    infix operator fun timesAssign(b: Vec1t<out Number>) {
        times(this, this, b._x.d)
    }


    infix operator fun div(b: Number) = div(Vec1d(), this, b.d)
    infix operator fun div(b: Vec1t<out Number>) = div(Vec1d(), this, b._x.d)

    fun div(b: Number, res: Vec1d) = div(res, this, b.d)
    fun div(b: Vec1t<out Number>, res: Vec1d) = div(res, this, b._x.d)

    infix operator fun divAssign(b: Number) {
        div(this, this, b.d)
    }

    infix operator fun divAssign(b: Vec1t<out Number>) {
        div(this, this, b._x.d)
    }


    infix operator fun rem(b: Number) = rem(Vec1d(), this, b.d)
    infix operator fun rem(b: Vec1t<out Number>) = rem(Vec1d(), this, b._x.d)

    fun rem(b: Number, res: Vec1d) = rem(res, this, b.d)
    fun rem(b: Vec1t<out Number>, res: Vec1d) = rem(res, this, b._x.d)

    infix operator fun remAssign(b: Number) {
        rem(this, this, b.d)
    }

    infix operator fun remAssign(b: Vec1t<out Number>) {
        rem(this, this, b._x.d)
    }


    companion object : opVec1d {
        const val length = Vec1t.LENGTH
        @JvmField
        val size = length * Double.BYTES
    }

    override fun size() = size

    override fun equals(other: Any?) = other is Vec1d && this[0] == other[0]
    fun equal(b: Vec1d, epsilon: Double = glm.ε): Boolean = abs(x - b.x) <= epsilon
    fun notEqual(b: Vec1d, epsilon: Double = glm.ε): Boolean = !equal(b, epsilon)

    override fun hashCode() = x.hashCode()

    //@formatter:off
    override inline var _x get() = x; set(value) { x = value }
    override inline var r get() = x; set(value) { x = value }
    override inline var s get() = x; set(value) { x = value }
    //@formatter:on

    override inline operator fun get(index: Int): Double {
        if (index == 0) return x
        throw IndexOutOfBoundsException()
    }

    override inline operator fun set(index: Int, value: Double) {
        if (index == 0) {
            x = value
        } else throw IndexOutOfBoundsException()
    }

    override inline operator fun component1() = x

    override fun toString(): String = "($x)"
}

