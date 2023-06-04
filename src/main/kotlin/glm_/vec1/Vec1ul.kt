package glm_.vec1

import glm_.*
import glm_.vec1.operators.opVec1ul
import glm_.vec2.Vec2bool
import glm_.vec2.Vec2t
import glm_.vec2.Vec2ub
import glm_.vec2.Vec2ul
import glm_.vec3.Vec3bool
import glm_.vec3.Vec3t
import glm_.vec3.Vec3ub
import glm_.vec3.Vec3ul
import glm_.vec4.Vec4bool
import glm_.vec4.Vec4t
import glm_.vec4.Vec4ub
import glm_.vec4.Vec4ul
import kool.*
import org.lwjgl.system.MemoryStack
import unsigned.Ulong
import java.io.PrintStream
import java.lang.Math.abs
import java.nio.*

/**
 * Created by elect on 08/10/16.
 */

class Vec1ul(@JvmField inline var x: Ulong) : Vec1t<Ulong> {

    // -- Implicit basic constructors --

    constructor() : this(0)
    constructor(s: Number) : this(s.ul)

    // -- Explicit basic constructors --
    // Explicit conversions (From section 5.4.1 Conversion and scalar constructors of GLSL 1.30.08 specification)

    constructor(v: Vec1ul) : this(v.x)
    constructor(v: Vec2ul) : this(v.x)
    constructor(v: Vec3ul) : this(v.x)
    constructor(v: Vec4ul) : this(v.x)

    constructor(v: Vec1t<out Number>) : this(v._x)
    constructor(v: Vec2t<out Number>) : this(v._x)
    constructor(v: Vec3t<out Number>) : this(v._x)
    constructor(v: Vec4t<out Number>) : this(v._x)

    constructor(v: Vec1bool) : this(v.x.ul)
    constructor(v: Vec2bool) : this(v.x.ul)
    constructor(v: Vec3bool) : this(v.x.ul)
    constructor(v: Vec4bool) : this(v.x.ul)

    constructor(bytes: ByteArray, index: Int = 0, oneByteOneUlong: Boolean = false, bigEndian: Boolean = true) : this(
        if (oneByteOneUlong) bytes[index].ul else bytes.getUlong(index, bigEndian))

    constructor(chars: CharArray, index: Int = 0) : this(chars[index].ul)
    constructor(shorts: ShortArray, index: Int = 0) : this(shorts[index])
    constructor(ints: IntArray, index: Int = 0) : this(ints[index])
    constructor(longs: LongArray, index: Int = 0) : this(longs[index])
    constructor(floats: FloatArray, index: Int = 0) : this(floats[index])
    constructor(doubles: DoubleArray, index: Int = 0) : this(doubles[index])
    constructor(booleans: BooleanArray, index: Int = 0) : this(booleans[index].ul)

    constructor(numbers: Array<out Number>, index: Int = 0) : this(numbers[index])
    constructor(chars: Array<Char>, index: Int = 0) : this(chars[index].ul)
    constructor(booleans: Array<Boolean>, index: Int = 0) : this(booleans[index].ul)

    constructor(list: Iterable<*>, index: Int = 0) : this(list.elementAt(index)!!.toLong)

    constructor(bytes: ByteBuffer, index: Int = bytes.pos, oneByteOneUlong: Boolean = false) : this(
        if (oneByteOneUlong) bytes[index].ul else bytes.getLong(index).ul)

    constructor(chars: CharBuffer, index: Int = chars.pos) : this(chars[index].ul)
    constructor(shorts: ShortBuffer, index: Int = shorts.pos) : this(shorts[index])
    constructor(ints: IntBuffer, index: Int = ints.pos) : this(ints[index])
    constructor(longs: LongBuffer, index: Int = longs.pos) : this(longs[index])
    constructor(floats: FloatBuffer, index: Int = floats.pos) : this(floats[index])
    constructor(doubles: DoubleBuffer, index: Int = doubles.pos) : this(doubles[index])

    constructor(block: (Int) -> Ulong) : this(block(0))


    fun set(bytes: ByteArray, index: Int = 0, oneByteOneUlong: Boolean = false, bigEndian: Boolean = true) {
        x.v = if (oneByteOneUlong) bytes[index].L else bytes.getLong(index, bigEndian)
    }

    fun set(bytes: ByteBuffer, index: Int = bytes.pos, oneByteOneUlong: Boolean = false) {
        x.v = if (oneByteOneUlong) bytes[index].L else bytes.getLong(index)
    }


    fun put(x: Ulong) {
        this.x = x
    }

    operator fun invoke(x: Ulong): Vec1ul {
        this.x = x
        return this
    }

    fun put(x: Long) {
        this.x.v = x
    }

    operator fun invoke(x: Long): Vec1ul {
        this.x.v = x
        return this
    }

    override fun put(x: Number) {
        this.x = x.ul
    }

    override operator fun invoke(x: Number): Vec1ul {
        this.x = x.ul
        return this
    }

    fun to(bytes: ByteArray, index: Int) = to(bytes, index, true)
    override fun to(bytes: ByteArray, index: Int, bigEndian: Boolean): ByteArray {
        bytes.putLong(index, x.v)
        return bytes
    }

    fun toLongArray(): LongArray = to(LongArray(length), 0)
    infix fun to(longs: LongArray): LongArray = to(longs, 0)
    fun to(longs: LongArray, index: Int): LongArray {
        longs[index] = x.v
        return longs
    }

    override fun to(buf: ByteBuffer, offset: Int): ByteBuffer {
        buf.putLong(offset, x.v)
        return buf
    }

    fun toLongBufferStack(): LongBuffer = to(MemoryStack.stackGet().mallocLong(length), 0)
    infix fun toLongBuffer(stack: MemoryStack): LongBuffer = to(stack.mallocLong(length), 0)
    fun toLongBuffer(): LongBuffer = to(LongBuffer(length), 0)
    infix fun to(buf: LongBuffer): LongBuffer = to(buf, buf.pos)
    fun to(buf: LongBuffer, index: Int): LongBuffer {
        buf[index] = x.v
        return buf
    }

    infix fun to(ptr: Ptr<Ulong>) {
        val p = ptr.toPtr<Long>()
        p[0] = x.v
    }


    // -- Unary arithmetic operators --

    operator fun unaryPlus() = this

    // no unaryMinus operator, only signed

    // -- Increment main.and decrement operators --

    operator fun inc(res: Vec1ul = Vec1ul()) = plus(res, this, 1)
    fun incAssign() = plus(this, this, 1)


    operator fun dec(res: Vec1ul = Vec1ul()) = minus(res, this, 1)
    fun decAssign() = minus(this, this, 1)


    // -- Specific binary arithmetic operators --

    infix operator fun plus(b: Ulong) = plus(Vec1ul(), this, b)
    infix operator fun plus(b: Long) = plus(Vec1ul(), this, b)
    infix operator fun plus(b: Vec1ul) = plus(Vec1ul(), this, b.x)

    fun plus(b: Ulong, res: Vec1ul) = plus(res, this, b)
    fun plus(b: Long, res: Vec1ul) = plus(res, this, b)
    fun plus(b: Vec1ul, res: Vec1ul) = plus(res, this, b.x)

    infix operator fun plusAssign(b: Ulong) {
        plus(this, this, b)
    }

    infix operator fun plusAssign(b: Long) {
        plus(this, this, b)
    }

    infix operator fun plusAssign(b: Vec1ul) {
        plus(this, this, b.x)
    }


    infix operator fun minus(b: Ulong) = minus(Vec1ul(), this, b)
    infix operator fun minus(b: Long) = minus(Vec1ul(), this, b)
    infix operator fun minus(b: Vec1ul) = minus(Vec1ul(), this, b.x)

    fun minus(b: Ulong, res: Vec1ul) = minus(res, this, b)
    fun minus(b: Long, res: Vec1ul) = minus(res, this, b)
    fun minus(b: Vec1ul, res: Vec1ul) = minus(res, this, b.x)

    infix operator fun minusAssign(b: Ulong) {
        minus(this, this, b)
    }

    infix operator fun minusAssign(b: Long) {
        minus(this, this, b)
    }

    infix operator fun minusAssign(b: Vec1ul) {
        minus(this, this, b.x)
    }


    infix operator fun times(b: Ulong) = times(Vec1ul(), this, b)
    infix operator fun times(b: Long) = times(Vec1ul(), this, b)
    infix operator fun times(b: Vec1ul) = times(Vec1ul(), this, b.x)

    fun times(b: Ulong, res: Vec1ul) = times(res, this, b)
    fun times(b: Long, res: Vec1ul) = times(res, this, b)
    fun times(b: Vec1ul, res: Vec1ul) = times(res, this, b.x)

    infix operator fun timesAssign(b: Ulong) {
        times(this, this, b)
    }

    infix operator fun timesAssign(b: Long) {
        times(this, this, b)
    }

    infix operator fun timesAssign(b: Vec1ul) {
        times(this, this, b.x)
    }


    infix operator fun div(b: Ulong) = div(Vec1ul(), this, b)
    infix operator fun div(b: Long) = div(Vec1ul(), this, b)
    infix operator fun div(b: Vec1ul) = div(Vec1ul(), this, b.x)

    fun div(b: Ulong, res: Vec1ul) = div(res, this, b)
    fun div(b: Long, res: Vec1ul) = div(res, this, b)
    fun div(b: Vec1ul, res: Vec1ul) = div(res, this, b.x)

    infix operator fun divAssign(b: Ulong) {
        div(this, this, b)
    }

    infix operator fun divAssign(b: Long) {
        div(this, this, b)
    }

    infix operator fun divAssign(b: Vec1ul) {
        div(this, this, b.x)
    }


    infix operator fun rem(b: Ulong) = rem(Vec1ul(), this, b)
    infix operator fun rem(b: Long) = rem(Vec1ul(), this, b)
    infix operator fun rem(b: Vec1ul) = rem(Vec1ul(), this, b.x)

    fun rem(b: Ulong, res: Vec1ul) = rem(res, this, b)
    fun rem(b: Long, res: Vec1ul) = rem(res, this, b)
    fun rem(b: Vec1ul, res: Vec1ul) = rem(res, this, b.x)

    infix operator fun remAssign(b: Ulong) {
        rem(this, this, b)
    }

    infix operator fun remAssign(b: Long) {
        rem(this, this, b)
    }

    infix operator fun remAssign(b: Vec1ul) {
        rem(this, this, b.x)
    }


    // -- Generic binary arithmetic operators --

    infix operator fun plus(b: Number) = plus(Vec1ul(), this, b.L)
    infix operator fun plus(b: Vec1t<out Number>) = plus(Vec1ul(), this, b._x.L)

    fun plus(b: Number, res: Vec1ul) = plus(res, this, b.L)
    fun plus(b: Vec1t<out Number>, res: Vec1ul) = plus(res, this, b._x.L)

    infix operator fun plusAssign(b: Number) {
        plus(this, this, b.L)
    }

    infix operator fun plusAssign(b: Vec1t<out Number>) {
        plus(this, this, b._x.L)
    }


    infix operator fun minus(b: Number) = minus(Vec1ul(), this, b.L)
    infix operator fun minus(b: Vec1t<out Number>) = minus(Vec1ul(), this, b._x.L)

    fun minus(b: Number, res: Vec1ul) = minus(res, this, b.L)
    fun minus(b: Vec1t<out Number>, res: Vec1ul) = minus(res, this, b._x.L)

    infix operator fun minusAssign(b: Number) {
        minus(this, this, b.L)
    }

    infix operator fun minusAssign(b: Vec1t<out Number>) {
        minus(this, this, b._x.L)
    }


    infix operator fun times(b: Number) = times(Vec1ul(), this, b.L)
    infix operator fun times(b: Vec1t<out Number>) = times(Vec1ul(), this, b._x.L)

    fun times(b: Number, res: Vec1ul) = times(res, this, b.L)
    fun times(b: Vec1t<out Number>, res: Vec1ul) = times(res, this, b._x.L)

    infix operator fun timesAssign(b: Number) {
        times(this, this, b.L)
    }

    infix operator fun timesAssign(b: Vec1t<out Number>) {
        times(this, this, b._x.L)
    }


    infix operator fun div(b: Number) = div(Vec1ul(), this, b.L)
    infix operator fun div(b: Vec1t<out Number>) = div(Vec1ul(), this, b._x.L)

    fun div(b: Number, res: Vec1ul) = div(res, this, b.L)
    fun div(b: Vec1t<out Number>, res: Vec1ul) = div(res, this, b._x.L)

    infix operator fun divAssign(b: Number) {
        div(this, this, b.L)
    }

    infix operator fun divAssign(b: Vec1t<out Number>) {
        div(this, this, b._x.L)
    }


    infix operator fun rem(b: Number) = rem(Vec1ul(), this, b.L)
    infix operator fun rem(b: Vec1t<out Number>) = rem(Vec1ul(), this, b._x.L)

    fun rem(b: Number, res: Vec1ul) = rem(res, this, b.L)
    fun rem(b: Vec1t<out Number>, res: Vec1ul) = rem(res, this, b._x.L)

    infix operator fun remAssign(b: Number) {
        rem(this, this, b.L)
    }

    infix operator fun remAssign(b: Vec1t<out Number>) {
        rem(this, this, b._x.L)
    }


    // -- Specific bitwise operators --

    infix fun and(b: Ulong) = and(Vec1ul(), this, b)
    infix fun and(b: Long) = and(Vec1ul(), this, b)
    infix fun and(b: Vec1ul) = and(Vec1ul(), this, b.x)

    fun and(b: Ulong, res: Vec1ul) = and(res, this, b)
    fun and(b: Long, res: Vec1ul) = and(res, this, b)
    fun and(b: Vec1ul, res: Vec1ul) = and(res, this, b.x)

    infix fun andAssign(b: Ulong) = and(this, this, b)
    infix fun andAssign(b: Long) = and(this, this, b)
    infix fun andAssign(b: Vec1ul) = and(this, this, b.x)


    infix fun or(b: Ulong) = or(Vec1ul(), this, b)
    infix fun or(b: Long) = or(Vec1ul(), this, b)
    infix fun or(b: Vec1ul) = or(Vec1ul(), this, b.x)

    fun or(b: Ulong, res: Vec1ul) = or(res, this, b)
    fun or(b: Long, res: Vec1ul) = or(res, this, b)
    fun or(b: Vec1ul, res: Vec1ul) = or(res, this, b.x)

    infix fun orAssign(b: Ulong) = or(this, this, b)
    infix fun orAssign(b: Long) = or(this, this, b)
    infix fun orAssign(b: Vec1ul) = or(this, this, b.x)


    infix fun xor(b: Ulong) = xor(Vec1ul(), this, b)
    infix fun xor(b: Long) = xor(Vec1ul(), this, b)
    infix fun xor(b: Vec1ul) = xor(Vec1ul(), this, b.x)

    fun xor(b: Ulong, res: Vec1ul) = xor(res, this, b)
    fun xor(b: Long, res: Vec1ul) = xor(res, this, b)
    fun xor(b: Vec1ul, res: Vec1ul) = xor(res, this, b.x)

    infix fun xorAssign(b: Ulong) = xor(this, this, b)
    infix fun xorAssign(b: Long) = xor(this, this, b)
    infix fun xorAssign(b: Vec1ul) = xor(this, this, b.x)


    infix fun shl(b: Int) = shl(Vec1ul(), this, b)

    fun shl(b: Int, res: Vec1ul) = shl(res, this, b)

    infix fun shlAssign(b: Int) = shl(this, this, b)
    fun shlAssign(bX: Int, bY: Int) = shl(this, this, bX)


    infix fun shr(b: Int) = shr(Vec1ul(), this, b)

    fun shr(b: Int, res: Vec1ul) = shr(res, this, b)

    infix fun shrAssign(b: Int) = shr(this, this, b)
    fun shrAssign(bX: Int, bY: Int) = shr(this, this, bX)


    @JvmOverloads
    fun inv(res: Vec1ul = Vec1ul()) = inv(res, this)

    fun invAssign() = inv(this, this)


    // -- Generic bitwise operators --

    infix fun and(b: Number) = and(Vec1ul(), this, b.L)
    fun and(b: Vec1t<out Number>) = and(Vec1ul(), this, b._x.L)

    fun and(b: Number, res: Vec1ul) = and(res, this, b.L)
    fun and(b: Vec1t<out Number>, res: Vec1ul) = and(res, this, b._x.L)

    infix fun andAssign(b: Number) = and(this, this, b.L)
    infix fun andAssign(b: Vec1t<out Number>) = and(this, this, b._x.L)


    infix fun or(b: Number) = or(Vec1ul(), this, b.L)
    fun or(b: Vec1t<out Number>) = or(Vec1ul(), this, b._x.L)

    fun or(b: Number, res: Vec1ul) = or(res, this, b.L)
    fun or(b: Vec1t<out Number>, res: Vec1ul) = or(res, this, b._x.L)

    infix fun orAssign(b: Number) = or(this, this, b.L)
    infix fun orAssign(b: Vec1t<out Number>) = or(this, this, b._x.L)


    infix fun xor(b: Number) = xor(Vec1ul(), this, b.L)
    fun xor(b: Vec1t<out Number>) = xor(Vec1ul(), this, b._x.L)

    fun xor(b: Number, res: Vec1ul) = xor(res, this, b.L)
    fun xor(b: Vec1t<out Number>, res: Vec1ul) = xor(res, this, b._x.L)

    infix fun xorAssign(b: Number) = xor(this, this, b.L)
    infix fun xorAssign(b: Vec1t<out Number>) = xor(this, this, b._x.L)


    infix fun shl(b: Number) = shl(Vec1ul(), this, b.L)

    fun shl(b: Number, res: Vec1ul) = shl(res, this, b.L)

    infix fun shlAssign(b: Number) = shl(this, this, b.L)


    infix fun shr(b: Number) = shr(Vec1ul(), this, b.L)

    fun shr(b: Number, res: Vec1ul) = shr(res, this, b.L)

    infix fun shrAssign(b: Number) = shr(this, this, b.L)


    companion object : opVec1ul {
        const val length = Vec1t.LENGTH

        @JvmField
        val size = length * Ulong.BYTES

        @JvmStatic
        fun fromPointer(ptr: Ptr<Ulong>) = Vec1ul(ptr.toPtr<Long>()[0])
    }

    override fun size() = size

    override fun equals(other: Any?) = other is Vec1ul && this[0] == other[0]
    fun equal(b: Vec1ul, epsilon: Int = 0): Boolean = abs(x.v - b.x.v) <= epsilon
    fun notEqual(b: Vec1ul, epsilon: Int = 0): Boolean = !equal(b, epsilon)

    override fun hashCode() = x.v.hashCode()

    @JvmOverloads
    fun print(name: String = "", stream: PrintStream = System.out) = stream.print("$name$this")

    @JvmOverloads
    fun println(name: String = "", stream: PrintStream = System.out) = stream.println("$name$this")

    //@formatter:off
    override inline var _x get() = x; set(value) { x = value }
    override inline var r get() = x; set(value) { x = value }
    override inline var s get() = x; set(value) { x = value }
    //@formatter:on

    override inline operator fun get(index: Int): Ulong {
        if (index == 0) return x
        throw IndexOutOfBoundsException()
    }

    override inline operator fun set(index: Int, value: Ulong) {
        if (index == 0) {
            x = value
        } else throw IndexOutOfBoundsException()
    }

    override inline operator fun component1() = x

    override fun toString(): String = "($x)"
}
