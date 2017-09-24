package glm_.vec1

import glm_.BYTES
import glm_.f
import glm_.getFloat
import glm_.set
import glm_.vec2.Vec2bool
import glm_.vec2.Vec2t
import glm_.vec3.Vec3bool
import glm_.vec3.Vec3t
import glm_.vec4.Vec4bool
import glm_.vec4.Vec4t
import java.nio.*

/**
 * Created by GBarbieri on 28.04.2017.
 */

class Vec1(x: Float) : Vec1t<Float>(x) {

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

    constructor(bytes: ByteBuffer, index: Int = bytes.position(), oneByteOneFloat: Boolean = false)
            : this(if (oneByteOneFloat) bytes[index].f else bytes.getFloat(index))

    constructor(chars: CharBuffer, index: Int = chars.position()) : this(chars[index].f)
    constructor(shorts: ShortBuffer, index: Int = shorts.position()) : this(shorts[index])
    constructor(ints: IntBuffer, index: Int = ints.position()) : this(ints[index])
    constructor(longs: LongBuffer, index: Int = longs.position()) : this(longs[index])
    constructor(floats: FloatBuffer, index: Int = floats.position()) : this(floats[index])
    constructor(doubles: DoubleBuffer, index: Int = doubles.position()) : this(doubles[index])

    constructor(s: Number) : this(s.f)


    fun set(bytes: ByteArray, index: Int = 0, oneByteOneFloat: Boolean = false, bigEndian: Boolean = true) {
        x = if (oneByteOneFloat) bytes[index].f else bytes.getFloat(index, bigEndian)
    }

    fun set(bytes: ByteBuffer, index: Int = bytes.position(), oneByteOneFloat: Boolean = false) {
        x = if (oneByteOneFloat) bytes[index].f else bytes.getFloat(index)
    }


    fun put(x: Float): Vec1 {
        this.x = x
        return this
    }

    override fun put(x: Number): Vec1 {
        this.x = x.f
        return this
    }

    infix fun to(floats: FloatArray) = to(floats, 0)
    fun to(floats: FloatArray, index: Int): FloatArray {
        floats[index] = x
        return floats
    }

    infix fun to(floats: FloatBuffer) = to(floats, floats.position())
    fun to(floats: FloatBuffer, index: Int): FloatBuffer {
        floats[index] = x
        return floats
    }

    infix fun to(bytes: ByteBuffer) = to(bytes, bytes.position())
    fun to(bytes: ByteBuffer, index: Int): ByteBuffer = bytes.putFloat(index, x)


    // -- Component accesses --

    infix operator fun get(i: Int) = when (i) {
        0 -> x
        else -> throw ArrayIndexOutOfBoundsException()
    }

    operator fun set(i: Int, s: Float) = when (i) {
        0 -> x = s
        else -> throw ArrayIndexOutOfBoundsException()
    }

    operator fun set(i: Int, s: Number) = when (i) {
        0 -> x = s.f
        else -> throw ArrayIndexOutOfBoundsException()
    }

    companion object {//TODO : vec2b_operators {
        @JvmField
        val length = 1
        @JvmField
        val size = length * Float.BYTES
    }

    override fun equals(other: Any?) = other is Vec1 && this[0] == other[0]
    override fun hashCode() = x.hashCode()
}