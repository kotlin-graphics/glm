package glm_.vec1

import glm_.BYTES
import glm_.b
import glm_.toByte
import glm_.vec1.operators.opVec1b
import glm_.vec2.Vec2bool
import glm_.vec2.Vec2t
import glm_.vec3.Vec3bool
import glm_.vec3.Vec3t
import glm_.vec4.Vec4bool
import glm_.vec4.Vec4t
import kool.pos
import java.nio.*
import kotlin.math.abs

class Vec1b(x: Byte) : Vec1t<Byte>(x) {

    // -- Explicit basic, conversion other main.and conversion vector constructors --

    constructor() : this(0)

    constructor(v: Vec2t<out Number>) : this(v.x)
    constructor(v: Vec3t<out Number>) : this(v.x)
    constructor(v: Vec4t<out Number>) : this(v.x)

    constructor(v: Vec2bool) : this(v.x.b)
    constructor(v: Vec3bool) : this(v.x.b)
    constructor(v: Vec4bool) : this(v.x.b)

    constructor(bytes: ByteArray, index: Int = 0) : this(bytes[index])
    constructor(chars: CharArray, index: Int = 0) : this(chars[index].b)
    constructor(shorts: ShortArray, index: Int = 0) : this(shorts[index])
    constructor(ints: IntArray, index: Int = 0) : this(ints[index])
    constructor(longs: LongArray, index: Int = 0) : this(longs[index])
    constructor(floats: FloatArray, index: Int = 0) : this(floats[index])
    constructor(doubles: DoubleArray, index: Int = 0) : this(doubles[index])
    constructor(booleans: BooleanArray, index: Int = 0) : this(booleans[index].b)

    constructor(numbers: Array<out Number>, index: Int = 0) : this(numbers[index])
    constructor(chars: Array<Char>, index: Int = 0) : this(chars[index].b)
    constructor(booleans: Array<Boolean>, index: Int = 0) : this(booleans[index].b)

    constructor(list: List<Any>, index: Int = 0) : this(list[index].toByte)

    constructor(bytes: ByteBuffer, index: Int = bytes.pos) : this(bytes[index])
    constructor(chars: CharBuffer, index: Int = chars.pos) : this(chars[index].b)
    constructor(shorts: ShortBuffer, index: Int = shorts.pos) : this(shorts[index])
    constructor(ints: IntBuffer, index: Int = ints.pos) : this(ints[index])
    constructor(longs: LongBuffer, index: Int = longs.pos) : this(longs[index])
    constructor(floats: FloatBuffer, index: Int = floats.pos) : this(floats[index])
    constructor(doubles: DoubleBuffer, index: Int = doubles.pos) : this(doubles[index])

    constructor(block: (Int) -> Byte) : this(block(0))

    constructor(x: Number) : this(x.b)


    fun put(x: Byte) {
        this.x = x
    }

    operator fun invoke(x: Byte): Vec1b {
        this.x = x.b
        return this
    }

    override fun put(x: Number) {
        this.x = x.b
    }

    override operator fun invoke(x: Number): Vec1b {
        this.x = x.b
        return this
    }

    fun to(bytes: ByteArray, index: Int) = to(bytes, index, true)
    override fun to(bytes: ByteArray, index: Int, bigEndian: Boolean): ByteArray {
        bytes[index] = x
        return bytes
    }

    override fun to(buf: ByteBuffer, offset: Int): ByteBuffer = buf.put(offset, x)

    companion object : opVec1b {
        const val length = Vec1t.length
        @JvmField
        val size = length * Byte.BYTES
    }

    override fun size() = size

    override fun equals(other: Any?) = other is Vec1b && this[0] == other[0]
    override fun hashCode() = x.hashCode()

    fun equal(b: Vec1b, epsilon: Int = 0): Boolean = abs(x - b.x) <= epsilon

    fun notEqual(b: Vec1b, epsilon: Int = 0): Boolean = !equal(b, epsilon)
}