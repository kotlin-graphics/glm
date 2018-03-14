package glm_.vec1

import glm_.BYTES
import glm_.getInt
import glm_.i
import glm_.set
import glm_.vec1.operators.vec1i_operators
import glm_.vec2.Vec2bool
import glm_.vec2.Vec2t
import glm_.vec3.Vec3bool
import glm_.vec3.Vec3t
import glm_.vec4.Vec4bool
import glm_.vec4.Vec4t
import java.nio.*

/**
 * Created by GBarbieri on 04.04.2017.
 */

class Vec1i(x: Int) : Vec1t<Int>(x) {

    // -- Explicit basic, conversion other main.and conversion vector constructors --

    constructor() : this(0)

    constructor(v: Vec1t<out Number>) : this(v.x)
    constructor(v: Vec2t<out Number>) : this(v.x)
    constructor(v: Vec3t<out Number>) : this(v.x)
    constructor(v: Vec4t<out Number>) : this(v.x)

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

    constructor(bytes: ByteBuffer, index: Int = bytes.position(), oneByteOneInt: Boolean = false)
            : this(if (oneByteOneInt) bytes[index].i else bytes.getInt(index))

    constructor(chars: CharBuffer, index: Int = chars.position()) : this(chars[index].i)
    constructor(shorts: ShortBuffer, index: Int = shorts.position()) : this(shorts[index])
    constructor(ints: IntBuffer, index: Int = ints.position()) : this(ints[index])
    constructor(longs: LongBuffer, index: Int = longs.position()) : this(longs[index])
    constructor(floats: FloatBuffer, index: Int = floats.position()) : this(floats[index])
    constructor(doubles: DoubleBuffer, index: Int = doubles.position()) : this(doubles[index])

    constructor(s: Number) : this(s.i)


    fun set(bytes: ByteArray, index: Int = 0, oneByteOneInt: Boolean = false, bigEndian: Boolean = true) {
        x = if (oneByteOneInt) bytes[index].i else bytes.getInt(index, bigEndian)
    }

    fun set(bytes: ByteBuffer, index: Int = bytes.position(), oneByteOneInt: Boolean = false) {
        x = if (oneByteOneInt) bytes[index].i else bytes.getInt(index)
    }


    fun put(x: Int): Vec1i {
        this.x = x
        return this
    }

    override fun put(x: Number): Vec1i {
        this.x = x.i
        return this
    }

    infix fun to(ints: IntArray) = to(ints, 0)
    fun to(ints: IntArray, index: Int): IntArray {
        ints[index] = x
        return ints
    }

    infix fun to(ints: IntBuffer) = to(ints, ints.position())
    fun to(ints: IntBuffer, index: Int): IntBuffer {
        ints[index] = x
        return ints
    }

    infix fun to(bytes: ByteBuffer) = to(bytes, bytes.position())
    fun to(bytes: ByteBuffer, index: Int): ByteBuffer = bytes.putInt(index, x)

    // -- Component accesses --

    override infix operator fun get(index: Int) = when (index) {
        0 -> x
        else -> throw ArrayIndexOutOfBoundsException()
    }

    operator fun set(i: Int, s: Int) = when (i) {
        0 -> x = s
        else -> throw ArrayIndexOutOfBoundsException()
    }

    operator fun set(i: Int, s: Number) = when (i) {
        0 -> x = s.i
        else -> throw ArrayIndexOutOfBoundsException()
    }

    companion object : vec1i_operators {
    @JvmField
    val length = 1
        @JvmField
        val size = length * Int.BYTES
    }


    // -- Specific binary arithmetic operators --

    infix operator fun plus(b: Int) = plus(Vec1i(), this, b)
    infix operator fun plus(b: Vec1i) = plus(Vec1i(), this, b.x)

    fun plus(b: Int, res: Vec1i) = plus(res, this, b)
    fun plus(b: Vec1i, res: Vec1i) = plus(res, this, b.x)

    infix fun plus_(b: Int) = plus(this, this, b)
    infix fun plus_(b: Vec1i) = plus(this, this, b.x)


    infix operator fun minus(b: Int) = minus(Vec1i(), this, b)
    infix operator fun minus(b: Vec1i) = minus(Vec1i(), this, b.x)

    fun minus(b: Int, res: Vec1i) = minus(res, this, b)
    fun minus(b: Vec1i, res: Vec1i) = minus(res, this, b.x)

    infix fun minus_(b: Int) = minus(this, this, b)
    infix fun minus_(b: Vec1i) = minus(this, this, b.x)


    infix operator fun times(b: Int) = times(Vec1i(), this, b)
    infix operator fun times(b: Vec1i) = times(Vec1i(), this, b.x)

    fun times(b: Int, res: Vec1i) = times(res, this, b)
    fun times(b: Vec1i, res: Vec1i) = times(res, this, b.x)

    infix fun times_(b: Int) = times(this, this, b)
    infix fun times_(b: Vec1i) = times(this, this, b.x)


    infix operator fun div(b: Int) = div(Vec1i(), this, b)
    infix operator fun div(b: Vec1i) = div(Vec1i(), this, b.x)

    fun div(b: Int, res: Vec1i) = div(res, this, b)
    fun div(b: Vec1i, res: Vec1i) = div(res, this, b.x)

    infix fun div_(b: Int) = div(this, this, b)
    infix fun div_(b: Vec1i) = div(this, this, b.x)


    infix operator fun rem(b: Int) = rem(Vec1i(), this, b)
    infix operator fun rem(b: Vec1i) = rem(Vec1i(), this, b.x)

    fun rem(b: Int, res: Vec1i) = rem(res, this, b)
    fun rem(b: Vec1i, res: Vec1i) = rem(res, this, b.x)

    infix fun rem_(b: Int) = rem(this, this, b)
    infix fun rem_(b: Vec1i) = rem(this, this, b.x)


    override fun equals(other: Any?) = other is Vec1i && this[0] == other[0]
    override fun hashCode() = x.hashCode()
}