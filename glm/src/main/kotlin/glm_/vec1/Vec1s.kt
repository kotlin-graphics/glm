package glm_.vec1

import glm_.*
import glm_.vec1.operators.opVec1s
import glm_.vec2.Vec2bool
import glm_.vec2.Vec2t
import glm_.vec3.Vec3bool
import glm_.vec3.Vec3t
import glm_.vec4.Vec4bool
import glm_.vec4.Vec4t
import kool.pos
import kool.ShortBuffer
import kool.set
import org.lwjgl.system.MemoryStack
import java.nio.*
import kotlin.math.abs

/**
 * Created by GBarbieri on 04.04.2017.
 */

class Vec1s(x: Short) : Vec1t<Short>(x) {

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

    constructor(bytes: ByteBuffer, index: Int = bytes.pos, oneByteOneInt: Boolean = false)
            : this(if (oneByteOneInt) bytes[index].i else bytes.getInt(index))

    constructor(chars: CharBuffer, index: Int = chars.pos) : this(chars[index].i)
    constructor(shorts: ShortBuffer, index: Int = shorts.pos) : this(shorts[index])
    constructor(ints: IntBuffer, index: Int = ints.pos) : this(ints[index])
    constructor(longs: LongBuffer, index: Int = longs.pos) : this(longs[index])
    constructor(floats: FloatBuffer, index: Int = floats.pos) : this(floats[index])
    constructor(doubles: DoubleBuffer, index: Int = doubles.pos) : this(doubles[index])

    constructor(block: (Int) -> Int) : this(block(0))

    constructor(s: Number) : this(s.s)


    fun set(bytes: ByteArray, index: Int = 0, oneByteOneInt: Boolean = false, bigEndian: Boolean = true) {
        x = if (oneByteOneInt) bytes[index].s else bytes.getShort(index, bigEndian)
    }

    fun set(bytes: ByteBuffer, index: Int = bytes.pos, oneByteOneInt: Boolean = false) {
        x = if (oneByteOneInt) bytes[index].s else bytes.getShort(index)
    }


    fun put(x: Short) {
        this.x = x
    }

    operator fun invoke(x: Short): Vec1s {
        this.x = x
        return this
    }

    override fun put(x: Number) {
        this.x = x.s
    }

    override operator fun invoke(x: Number): Vec1s {
        this.x = x.s
        return this
    }

    fun to(bytes: ByteArray, index: Int): ByteArray = to(bytes, index, true)
    override fun to(bytes: ByteArray, index: Int, bigEndian: Boolean): ByteArray {
        bytes.putShort(index, x)
        return bytes
    }

    override fun to(buf: ByteBuffer, offset: Int): ByteBuffer = buf.putShort(offset, x)

    fun toShortArray(): ShortArray = to(ShortArray(length), 0)
    infix fun to(shorts: ShortArray): ShortArray = to(shorts, 0)
    fun to(shorts: ShortArray, index: Int): ShortArray {
        shorts[index] = x
        return shorts
    }

    infix fun toShortBuffer(stack: MemoryStack): ShortBuffer = to(stack.mallocShort(length), 0)
    fun toShortBuffer(): ShortBuffer = to(ShortBuffer(length), 0)
    infix fun to(buf: ShortBuffer): ShortBuffer = to(buf, buf.pos)
    fun to(buf: ShortBuffer, index: Int): ShortBuffer {
        buf[index] = x
        return buf
    }


    // -- Specific binary arithmetic operators --

//    infix operator fun plus(b: Int) = plus(Vec1s(), this, b)
//    infix operator fun plus(b: Vec1s) = plus(Vec1s(), this, b.x)
//
//    fun plus(b: Int, res: Vec1s) = plus(res, this, b)
//    fun plus(b: Vec1s, res: Vec1s) = plus(res, this, b.x)
//
//    infix fun plusAssign(b: Short) = plus(this, this, b)
//    infix fun plusAssign(b: Vec1s) = plus(this, this, b.x)
//
//
//    infix operator fun minus(b: Short) = minus(Vec1s(), this, b)
//    infix operator fun minus(b: Vec1s) = minus(Vec1s(), this, b.x)
//
//    fun minus(b: Int, res: Vec1s) = minus(res, this, b)
//    fun minus(b: Vec1s, res: Vec1s) = minus(res, this, b.x)
//
//    infix fun minusAssign(b: Short) = minus(this, this, b)
//    infix fun minusAssign(b: Vec1s) = minus(this, this, b.x)
//
//
//    infix operator fun times(b: Short) = times(Vec1s(), this, b)
//    infix operator fun times(b: Vec1s) = times(Vec1s(), this, b.x)
//
//    fun times(b: Int, res: Vec1s) = times(res, this, b)
//    fun times(b: Vec1s, res: Vec1s) = times(res, this, b.x)
//
//    infix fun timesAssign(b: Int) = times(this, this, b)
//    infix fun timesAssign(b: Vec1s) = times(this, this, b.x)
//
//
//    infix operator fun div(b: Int) = div(Vec1i(), this, b)
//    infix operator fun div(b: Vec1s) = div(Vec1i(), this, b.x)
//
//    fun div(b: Int, res: Vec1s) = div(res, this, b)
//    fun div(b: Vec1s, res: Vec1s) = div(res, this, b.x)
//
//    infix fun divAssign(b: Int) = div(this, this, b)
//    infix fun divAssign(b: Vec1s) = div(this, this, b.x)
//
//
//    infix operator fun rem(b: Int) = rem(Vec1i(), this, b)
//    infix operator fun rem(b: Vec1s) = rem(Vec1i(), this, b.x)
//
//    fun rem(b: Int, res: Vec1s) = rem(res, this, b)
//    fun rem(b: Vec1s, res: Vec1s) = rem(res, this, b.x)
//
//    infix fun remAssign(b: Int) = rem(this, this, b)
//    infix fun remAssign(b: Vec1s) = rem(this, this, b.x)

    companion object : opVec1s {
        const val length = Vec1t.length
        @JvmField
        val size = length * Short.BYTES
    }

    override fun size() = size

    override fun equals(other: Any?) = other is Vec1s && this[0] == other[0]
    fun equal(b: Vec1s, epsilon: Int = 0): Boolean = abs(x - b.x) <= epsilon
    fun notEqual(b: Vec1s, epsilon: Int = 0): Boolean = !equal(b, epsilon)

    override fun hashCode() = x.hashCode()
}