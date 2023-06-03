package glm_.vec1

import glm_.ToIntBuffer
import glm_.getInt
import glm_.i
import glm_.putInt
import glm_.vec1.operators.opVec1i
import glm_.vec2.Vec2bool
import glm_.vec2.Vec2i
import glm_.vec2.Vec2t
import glm_.vec3.Vec3bool
import glm_.vec3.Vec3i
import glm_.vec3.Vec3t
import glm_.vec4.Vec4bool
import glm_.vec4.Vec4i
import glm_.vec4.Vec4t
import kool.*
import java.nio.*
import kotlin.math.abs

/**
 * Created by GBarbieri on 04.04.2017.
 */

class Vec1i(@JvmField inline var x: Int) : Vec1t<Int> , ToIntBuffer {

    // -- Implicit basic constructors --

    constructor() : this(0)
    constructor(s: Number) : this(s.i)

    // -- Explicit basic constructors --
    // Explicit conversions (From section 5.4.1 Conversion and scalar constructors of GLSL 1.30.08 specification)

    constructor(v: Vec1i) : this(v.x)
    constructor(v: Vec2i) : this(v.x)
    constructor(v: Vec3i) : this(v.x)
    constructor(v: Vec4i) : this(v.x)

    constructor(v: Vec1t<out Number>) : this(v._x)
    constructor(v: Vec2t<out Number>) : this(v._x)
    constructor(v: Vec3t<out Number>) : this(v._x)
    constructor(v: Vec4t<out Number>) : this(v._x)

    constructor(v: Vec1bool) : this(v.x.i)
    constructor(v: Vec2bool) : this(v.x.i)
    constructor(v: Vec3bool) : this(v.x.i)
    constructor(v: Vec4bool) : this(v.x.i)

    constructor(bytes: ByteArray, index: Int = 0, oneByteOneInt: Boolean = false, bigEndian: Boolean = true)
            : this(if (oneByteOneInt) bytes[index].i else bytes.getInt(index, bigEndian))

    constructor(chars: CharArray, index: Int = 0) : this(chars[index].i)
    constructor(shorts: ShortArray, index: Int = 0) : this(shorts[index])
    constructor(ints: IntArray, index: Int = 0) : this(ints[index])
    constructor(longs: LongArray, index: Int = 0) : this(longs[index])
    constructor(floats: FloatArray, index: Int = 0) : this(floats[index])
    constructor(doubles: DoubleArray, index: Int = 0) : this(doubles[index])
    constructor(booleans: BooleanArray, index: Int = 0) : this(booleans[index].i)

    constructor(numbers: Array<out Number>, index: Int = 0) : this(numbers[index])
    constructor(chars: Array<Char>, index: Int = 0) : this(chars[index].i)
    constructor(booleans: Array<Boolean>, index: Int = 0) : this(booleans[index].i)

    constructor(list: List<Any>, index: Int = 0) : this() {
        put(list, index)
    }

    constructor(bytes: ByteBuffer, index: Int = bytes.pos, oneByteOneInt: Boolean = false)
            : this(if (oneByteOneInt) bytes[index].i else bytes.getInt(index))

    constructor(chars: CharBuffer, index: Int = chars.pos) : this(chars[index].i)
    constructor(shorts: ShortBuffer, index: Int = shorts.pos) : this(shorts[index])
    constructor(ints: IntBuffer, index: Int = ints.pos) : this(ints[index])
    constructor(longs: LongBuffer, index: Int = longs.pos) : this(longs[index])
    constructor(floats: FloatBuffer, index: Int = floats.pos) : this(floats[index])
    constructor(doubles: DoubleBuffer, index: Int = doubles.pos) : this(doubles[index])

    constructor(block: (Int) -> Int) : this(block(0))
    constructor(ptr: Ptr<Int>) : this(ptr[0])


    fun set(bytes: ByteArray, index: Int = 0, oneByteOneInt: Boolean = false, bigEndian: Boolean = true) {
        x = if (oneByteOneInt) bytes[index].i else bytes.getInt(index, bigEndian)
    }

    fun set(bytes: ByteBuffer, index: Int = bytes.pos, oneByteOneInt: Boolean = false) {
        x = if (oneByteOneInt) bytes[index].i else bytes.getInt(index)
    }


    fun put(x: Int) {
        this.x = x
    }

    operator fun invoke(x: Int): Vec1i {
        this.x = x
        return this
    }

    override fun put(x: Number) {
        this.x = x.i
    }

    override operator fun invoke(x: Number): Vec1i {
        this.x = x.i
        return this
    }

    fun to(bytes: ByteArray, index: Int) = to(bytes, index, true)
    override fun to(bytes: ByteArray, index: Int, bigEndian: Boolean): ByteArray {
        bytes.putInt(index, x)
        return bytes
    }

    override fun to(buf: ByteBuffer, offset: Int): ByteBuffer = buf.putInt(offset, x)

    fun toIntArray(): IntArray = to(IntArray(length), 0)
    infix fun to(ints: IntArray): IntArray = to(ints, 0)
    fun to(ints: IntArray, index: Int): IntArray {
        ints[index] = x
        return ints
    }

   override fun to(buf: IntBuffer, index: Int): IntBuffer {
        buf[index] = x
        return buf
    }

    // TODO others Vec1*
    operator fun inc() = Vec1i(x + 1)
    operator fun dec() = Vec1i(x - 1)

    // -- Specific binary arithmetic operators --

    infix operator fun plus(b: Int) = plus(Vec1i(), this, b)
    infix operator fun plus(b: Vec1i) = plus(Vec1i(), this, b.x)

    fun plus(b: Int, res: Vec1i) = plus(res, this, b)
    fun plus(b: Vec1i, res: Vec1i) = plus(res, this, b.x)

    infix operator fun plusAssign(b: Int) {
        plus(this, this, b)
    }
    infix operator fun plusAssign(b: Vec1i) {
        plus(this, this, b.x)
    }


    infix operator fun minus(b: Int) = minus(Vec1i(), this, b)
    infix operator fun minus(b: Vec1i) = minus(Vec1i(), this, b.x)

    fun minus(b: Int, res: Vec1i) = minus(res, this, b)
    fun minus(b: Vec1i, res: Vec1i) = minus(res, this, b.x)

    infix operator fun minusAssign(b: Int) {
        minus(this, this, b)
    }
    infix operator fun minusAssign(b: Vec1i) {
        minus(this, this, b.x)
    }


    infix operator fun times(b: Int) = times(Vec1i(), this, b)
    infix operator fun times(b: Vec1i) = times(Vec1i(), this, b.x)

    fun times(b: Int, res: Vec1i) = times(res, this, b)
    fun times(b: Vec1i, res: Vec1i) = times(res, this, b.x)

    infix operator fun timesAssign(b: Int) {
        times(this, this, b)
    }
    infix operator fun timesAssign(b: Vec1i) {
        times(this, this, b.x)
    }


    infix operator fun div(b: Int) = div(Vec1i(), this, b)
    infix operator fun div(b: Vec1i) = div(Vec1i(), this, b.x)

    fun div(b: Int, res: Vec1i) = div(res, this, b)
    fun div(b: Vec1i, res: Vec1i) = div(res, this, b.x)

    infix operator fun divAssign(b: Int) {
        div(this, this, b)
    }
    infix operator fun divAssign(b: Vec1i) {
        div(this, this, b.x)
    }


    infix operator fun rem(b: Int) = rem(Vec1i(), this, b)
    infix operator fun rem(b: Vec1i) = rem(Vec1i(), this, b.x)

    fun rem(b: Int, res: Vec1i) = rem(res, this, b)
    fun rem(b: Vec1i, res: Vec1i) = rem(res, this, b.x)

    infix operator fun remAssign(b: Int) {
        rem(this, this, b)
    }
    infix operator fun remAssign(b: Vec1i) {
        rem(this, this, b.x)
    }

    
    // -- Specific bitwise operators --

    infix fun and(b: Int) = and(Vec1i(), this, b)
    infix fun and(b: Vec1i) = and(Vec1i(), this, b.x)

    fun and(b: Int, res: Vec1i) = and(res, this, b)
    fun and(b: Vec1i, res: Vec1i) = and(res, this, b.x)

    infix fun andAssign(b: Int) = and(this, this, b)
    infix fun andAssign(b: Vec1i) = and(this, this, b.x)


    infix fun or(b: Int) = or(Vec1i(), this, b)
    infix fun or(b: Vec1i) = or(Vec1i(), this, b.x)

    fun or(b: Int, res: Vec1i) = or(res, this, b)
    fun or(b: Vec1i, res: Vec1i) = or(res, this, b.x)

    infix fun orAssign(b: Int) = or(this, this, b)
    infix fun orAssign(b: Vec1i) = or(this, this, b.x)


    infix fun xor(b: Int) = xor(Vec1i(), this, b)
    infix fun xor(b: Vec1i) = xor(Vec1i(), this, b.x)

    fun xor(b: Int, res: Vec1i) = xor(res, this, b)
    fun xor(b: Vec1i, res: Vec1i) = xor(res, this, b.x)

    infix fun xorAssign(b: Int) = xor(this, this, b)
    infix fun xorAssign(b: Vec1i) = xor(this, this, b.x)


    infix fun shl(b: Int) = shl(Vec1i(), this, b)
    infix fun shl(b: Vec1i) = shl(Vec1i(), this, b.x)

    fun shl(b: Int, res: Vec1i) = shl(res, this, b)
    fun shl(b: Vec1i, res: Vec1i) = shl(res, this, b.x)

    infix fun shlAssign(b: Int) = shl(this, this, b)
    infix fun shlAssign(b: Vec1i) = shl(this, this, b.x)


    infix fun shr(b: Int) = shr(Vec1i(), this, b)
    infix fun shr(b: Vec1i) = shr(Vec1i(), this, b.x)

    fun shr(b: Int, res: Vec1i) = shr(res, this, b)
    fun shr(b: Vec1i, res: Vec1i) = shr(res, this, b.x)

    infix fun shrAssign(b: Int) = shr(this, this, b)
    infix fun shrAssign(b: Vec1i) = shr(this, this, b.x)

    companion object : opVec1i {
        const val length = Vec1t.LENGTH
        @JvmField
        val size = length * Int.BYTES
    }

    override fun size() = size

    override fun equals(other: Any?) = other is Vec1i && this[0] == other[0]
    fun equal(b: Vec1i, epsilon: Int = 0): Boolean = abs(x - b.x) <= epsilon
    fun notEqual(b: Vec1i, epsilon: Int = 0): Boolean = !equal(b, epsilon)

    override fun hashCode() = x.hashCode()

    //@formatter:off
    override inline var _x get() = x; set(value) { x = value }
    override inline var r get() = x; set(value) { x = value }
    override inline var s get() = x; set(value) { x = value }
    //@formatter:on

    override inline operator fun get(index: Int): Int {
        if (index == 0) return x
        throw IndexOutOfBoundsException()
    }

    override inline operator fun set(index: Int, value: Int) {
        if (index == 0) {
            x = value
        } else throw IndexOutOfBoundsException()
    }

    override inline operator fun component1() = x

    override fun toString(): String = "($x)"
}

