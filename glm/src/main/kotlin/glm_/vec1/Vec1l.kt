package glm_.vec1

import glm_.BYTES
import glm_.L
import glm_.getLong
import glm_.putLong
import glm_.vec1.operators.opVec1l
import glm_.vec2.Vec2bool
import glm_.vec2.Vec2t
import glm_.vec3.Vec3bool
import glm_.vec3.Vec3t
import glm_.vec4.Vec4bool
import glm_.vec4.Vec4t
import kool.LongBuffer
import kool.pos
import kool.set
import org.lwjgl.system.MemoryStack
import java.nio.*
import kotlin.math.abs

class Vec1l(x: Long) : Vec1t<Long>(x) {

    // -- Implicit basic constructors --

    constructor() : this(0)
    constructor(s: Number) : this(s.L)

    // -- Explicit basic constructors --
    // Explicit conversions (From section 5.4.1 Conversion and scalar constructors of GLSL 1.30.08 specification)

    constructor(v: Vec1t<out Number>) : this(v.x)
    constructor(v: Vec2t<out Number>) : this(v.x)
    constructor(v: Vec3t<out Number>) : this(v.x)
    constructor(v: Vec4t<out Number>) : this(v.x)

    constructor(v: Vec1bool) : this(v.x.L)
    constructor(v: Vec2bool) : this(v.x.L)
    constructor(v: Vec3bool) : this(v.x.L)
    constructor(v: Vec4bool) : this(v.x.L)

    constructor(bytes: ByteArray, index: Int = 0, oneByteOneLong: Boolean = false, bigEndian: Boolean = true)
            : this(if (oneByteOneLong) bytes[index].L else bytes.getLong(index, bigEndian))

    constructor(chars: CharArray, index: Int = 0) : this(chars[index].L)
    constructor(shorts: ShortArray, index: Int = 0) : this(shorts[index])
    constructor(ints: IntArray, index: Int = 0) : this(ints[index])
    constructor(longs: LongArray, index: Int = 0) : this(longs[index])
    constructor(floats: FloatArray, index: Int = 0) : this(floats[index])
    constructor(doubles: DoubleArray, index: Int = 0) : this(doubles[index])
    constructor(booleans: BooleanArray, index: Int = 0) : this(booleans[index].L)

    constructor(numbers: Array<out Number>, index: Int = 0) : this(numbers[index])
    constructor(chars: Array<Char>, index: Int = 0) : this(chars[index].L)
    constructor(booleans: Array<Boolean>, index: Int = 0) : this(booleans[index].L)

    constructor(list: List<Any>, index: Int = 0) : this() {
        put(list, index)
    }

    constructor(bytes: ByteBuffer, index: Int = bytes.pos, oneByteOneLong: Boolean = false)
            : this(if (oneByteOneLong) bytes[index].L else bytes.getLong(index))

    constructor(chars: CharBuffer, index: Int = chars.pos) : this(chars[index].L)
    constructor(shorts: ShortBuffer, index: Int = shorts.pos) : this(shorts[index])
    constructor(ints: IntBuffer, index: Int = ints.pos) : this(ints[index])
    constructor(longs: LongBuffer, index: Int = longs.pos) : this(longs[index])
    constructor(floats: FloatBuffer, index: Int = floats.pos) : this(floats[index])
    constructor(doubles: DoubleBuffer, index: Int = doubles.pos) : this(doubles[index])

    constructor(block: (Int) -> Int) : this(block(0))


    fun set(bytes: ByteArray, index: Int = 0, oneByteOneLong: Boolean = false, bigEndian: Boolean = true) {
        x = if (oneByteOneLong) bytes[index].L else bytes.getLong(index, bigEndian)
    }

    fun set(bytes: ByteBuffer, index: Int = bytes.pos, oneByteOneLong: Boolean = false) {
        x = if (oneByteOneLong) bytes[index].L else bytes.getLong(index)
    }


    fun put(x: Long) {
        this.x = x
    }

    operator fun invoke(x: Long): Vec1l {
        this.x = x
        return this
    }

    override fun put(x: Number) {
        this.x = x.L
    }

    override operator fun invoke(x: Number): Vec1l {
        this.x = x.L
        return this
    }

    fun to(bytes: ByteArray, index: Int): ByteArray = to(bytes, index, true)
    override fun to(bytes: ByteArray, index: Int, bigEndian: Boolean): ByteArray {
        bytes.putLong(index, x)
        return bytes
    }

    override fun to(buf: ByteBuffer, offset: Int): ByteBuffer = buf.putLong(offset, x)

    fun toLongArray(): LongArray = to(LongArray(length), 0)
    infix fun to(shorts: LongArray): LongArray = to(shorts, 0)
    fun to(longs: LongArray, index: Int): LongArray {
        longs[index] = x
        return longs
    }

    infix fun toLongBuffer(stack: MemoryStack): LongBuffer = to(stack.mallocLong(length), 0)
    fun toLongBuffer(): LongBuffer = to(LongBuffer(length), 0)
    infix fun to(buf: LongBuffer): LongBuffer = to(buf, buf.pos)
    fun to(buf: LongBuffer, index: Int): LongBuffer {
        buf[index] = x
        return buf
    }


    // -- Specific binary arithmetic operators --

// TODO

    companion object : opVec1l {
        const val length = Vec1t.length
        @JvmField
        val size = length * Long.BYTES
    }

    override fun size() = size

    override fun equals(other: Any?) = other is Vec1l && this[0] == other[0]
    fun equal(b: Vec1l, epsilon: Long = 0): Boolean = abs(x - b.x) <= epsilon
    fun notEqual(b: Vec1l, epsilon: Long = 0): Boolean = !equal(b, epsilon)

    override fun hashCode() = x.hashCode()
}