package glm_.vec1

import glm_.*
import glm_.vec1.operators.opVec1ui
import glm_.vec2.Vec2bool
import glm_.vec2.Vec2t
import glm_.vec3.Vec3bool
import glm_.vec3.Vec3t
import glm_.vec4.Vec4bool
import glm_.vec4.Vec4t
import kool.IntBuffer
import kool.pos
import kool.set
import org.lwjgl.system.MemoryStack
import unsigned.Uint
import java.nio.*
import kotlin.math.abs

/**
 * Created by elect on 08/10/16.
 */

class Vec1ui(x: Uint) : Vec1t<Uint>(x) {

    // -- Implicit basic constructors --

    constructor() : this(0)
    constructor(x: Number) : this(x.ui)

    // -- Explicit basic constructors --
    // Explicit conversions (From section 5.4.1 Conversion and scalar constructors of GLSL 1.30.08 specification)

    constructor(v: Vec1t<out Number>) : this(v.x)
    constructor(v: Vec2t<out Number>) : this(v.x)
    constructor(v: Vec3t<out Number>) : this(v.x)
    constructor(v: Vec4t<out Number>) : this(v.x)

    constructor(v: Vec1bool) : this(v.x.ui)
    constructor(v: Vec2bool) : this(v.x.ui)
    constructor(v: Vec3bool) : this(v.x.ui)
    constructor(v: Vec4bool) : this(v.x.ui)

    constructor(bytes: ByteArray, index: Int = 0, oneByteOneUint: Boolean = false, bigEndian: Boolean = true) : this(
            if (oneByteOneUint) bytes[index].ui else bytes.getUint(index, bigEndian))

    constructor(chars: CharArray, index: Int = 0) : this(chars[index].ui)
    constructor(shorts: ShortArray, index: Int = 0) : this(shorts[index])
    constructor(ints: IntArray, index: Int = 0) : this(ints[index])
    constructor(longs: LongArray, index: Int = 0) : this(longs[index])
    constructor(floats: FloatArray, index: Int = 0) : this(floats[index])
    constructor(doubles: DoubleArray, index: Int = 0) : this(doubles[index])
    constructor(booleans: BooleanArray, index: Int = 0) : this(booleans[index].ui)

    constructor(numbers: Array<out Number>, index: Int = 0) : this(numbers[index])
    constructor(chars: Array<Char>, index: Int = 0) : this(chars[index].ui)
    constructor(booleans: Array<Boolean>, index: Int = 0) : this(booleans[index].ui)

    constructor(list: List<Any>, index: Int = 0) : this(list[index].toInt)

    constructor(bytes: ByteBuffer, index: Int = bytes.pos, oneByteOneUint: Boolean = false) : this(
            if (oneByteOneUint) bytes[index].ui else bytes.getInt(index).ui)

    constructor(chars: CharBuffer, index: Int = chars.pos) : this(chars[index].ui)
    constructor(shorts: ShortBuffer, index: Int = shorts.pos) : this(shorts[index])
    constructor(ints: IntBuffer, index: Int = ints.pos) : this(ints[index])
    constructor(longs: LongBuffer, index: Int = longs.pos) : this(longs[index])
    constructor(floats: FloatBuffer, index: Int = floats.pos) : this(floats[index])
    constructor(doubles: DoubleBuffer, index: Int = doubles.pos) : this(doubles[index])

    constructor(block: (Int) -> Uint) : this(block(0))


    fun set(bytes: ByteArray, index: Int = 0, oneByteOneUint: Boolean = false, bigEndian: Boolean = true) {
        x.v = if (oneByteOneUint) bytes[index].i else bytes.getInt(index, bigEndian)
    }

    fun set(bytes: ByteBuffer, index: Int = bytes.pos, oneByteOneUint: Boolean = false) {
        x.v = if (oneByteOneUint) bytes[index].i else bytes.getInt(index)
    }


    fun put(x: Uint) {
        this.x = x
    }

    operator fun invoke(x: Uint): Vec1ui {
        this.x = x
        return this
    }

    fun put(x: Int) {
        this.x.v = x
    }

    operator fun invoke(x: Int): Vec1ui {
        this.x.v = x
        return this
    }

    override fun put(x: Number) {
        this.x = x.ui
    }

    override operator fun invoke(x: Number): Vec1ui {
        this.x = x.ui
        return this
    }

    fun to(bytes: ByteArray, index: Int) = to(bytes, index, true)
    override fun to(bytes: ByteArray, index: Int, bigEndian: Boolean): ByteArray {
        bytes.putInt(index, x.v)
        return bytes
    }

    override fun to(buf: ByteBuffer, offset: Int): ByteBuffer = buf.putInt(offset, x.v)

    fun toIntArray(): IntArray = to(IntArray(length), 0)
    infix fun to(ints: IntArray): IntArray = to(ints, 0)
    fun to(ints: IntArray, index: Int): IntArray {
        ints[index] = x.v
        return ints
    }

    infix fun toIntBuffer(stack: MemoryStack): IntBuffer = to(stack.mallocInt(length), 0)
    fun toIntBuffer(): IntBuffer = to(IntBuffer(length), 0)
    infix fun to(buf: IntBuffer): IntBuffer = to(buf, buf.pos)
    fun to(buf: IntBuffer, index: Int): IntBuffer {
        buf[index] = x.v
        return buf
    }


    // -- Unary arithmetic operators --

    operator fun unaryPlus() = this

    // no unaryMinus operator, only signed

    // -- Increment main.and decrement operators --

    operator fun inc(res: Vec1ui = Vec1ui()) = plus(res, this, 1)
    fun incAssign() = plus(this, this, 1)


    operator fun dec(res: Vec1ui = Vec1ui()) = minus(res, this, 1)
    fun decAssign() = minus(this, this, 1)


    // -- Specific binary arithmetic operators --

    infix operator fun plus(b: Uint) = plus(Vec1ui(), this, b)
    infix operator fun plus(b: Int) = plus(Vec1ui(), this, b)
    infix operator fun plus(b: Vec1ui) = plus(Vec1ui(), this, b.x)

    fun plus(b: Uint, res: Vec1ui) = plus(res, this, b)
    fun plus(b: Int, res: Vec1ui) = plus(res, this, b)
    fun plus(b: Vec1ui, res: Vec1ui) = plus(res, this, b.x)

    infix operator fun plusAssign(b: Uint) {
        plus(this, this, b)
    }

    infix operator fun plusAssign(b: Int) {
        plus(this, this, b)
    }

    infix operator fun plusAssign(b: Vec1ui) {
        plus(this, this, b.x)
    }


    infix operator fun minus(b: Uint) = minus(Vec1ui(), this, b)
    infix operator fun minus(b: Int) = minus(Vec1ui(), this, b)
    infix operator fun minus(b: Vec1ui) = minus(Vec1ui(), this, b.x)

    fun minus(b: Uint, res: Vec1ui) = minus(res, this, b)
    fun minus(b: Int, res: Vec1ui) = minus(res, this, b)
    fun minus(b: Vec1ui, res: Vec1ui) = minus(res, this, b.x)

    infix operator fun minusAssign(b: Uint) {
        minus(this, this, b)
    }

    infix operator fun minusAssign(b: Int) {
        minus(this, this, b)
    }

    infix operator fun minusAssign(b: Vec1ui) {
        minus(this, this, b.x)
    }


    infix operator fun times(b: Uint) = times(Vec1ui(), this, b)
    infix operator fun times(b: Int) = times(Vec1ui(), this, b)
    infix operator fun times(b: Vec1ui) = times(Vec1ui(), this, b.x)

    fun times(b: Uint, res: Vec1ui) = times(res, this, b)
    fun times(b: Int, res: Vec1ui) = times(res, this, b)
    fun times(b: Vec1ui, res: Vec1ui) = times(res, this, b.x)

    infix operator fun timesAssign(b: Uint) {
        times(this, this, b)
    }

    infix operator fun timesAssign(b: Int) {
        times(this, this, b)
    }

    infix operator fun timesAssign(b: Vec1ui) {
        times(this, this, b.x)
    }


    infix operator fun div(b: Uint) = div(Vec1ui(), this, b)
    infix operator fun div(b: Int) = div(Vec1ui(), this, b)
    infix operator fun div(b: Vec1ui) = div(Vec1ui(), this, b.x)

    fun div(b: Uint, res: Vec1ui) = div(res, this, b)
    fun div(b: Int, res: Vec1ui) = div(res, this, b)
    fun div(b: Vec1ui, res: Vec1ui) = div(res, this, b.x)

    infix operator fun divAssign(b: Uint) {
        div(this, this, b)
    }

    infix operator fun divAssign(b: Int) {
        div(this, this, b)
    }

    infix operator fun divAssign(b: Vec1ui) {
        div(this, this, b.x)
    }


    infix operator fun rem(b: Uint) = rem(Vec1ui(), this, b)
    infix operator fun rem(b: Int) = rem(Vec1ui(), this, b)
    infix operator fun rem(b: Vec1ui) = rem(Vec1ui(), this, b.x)

    fun rem(b: Uint, res: Vec1ui) = rem(res, this, b)
    fun rem(b: Int, res: Vec1ui) = rem(res, this, b)
    fun rem(b: Vec1ui, res: Vec1ui) = rem(res, this, b.x)

    infix operator fun remAssign(b: Uint) {
        rem(this, this, b)
    }

    infix operator fun remAssign(b: Int) {
        rem(this, this, b)
    }

    infix operator fun remAssign(b: Vec1ui) {
        rem(this, this, b.x)
    }


    // -- Generic binary arithmetic operators --

    infix operator fun plus(b: Number) = plus(Vec1ui(), this, b.i)
    infix operator fun plus(b: Vec2t<out Number>) = plus(Vec1ui(), this, b.x.i)

    fun plus(b: Number, res: Vec1ui) = plus(res, this, b.i)
    fun plus(b: Vec2t<out Number>, res: Vec1ui) = plus(res, this, b.x.i)

    infix operator fun plusAssign(b: Number) {
        plus(this, this, b.i)
    }

    infix operator fun plusAssign(b: Vec2t<out Number>) {
        plus(this, this, b.x.i)
    }


    infix operator fun minus(b: Number) = minus(Vec1ui(), this, b.i)
    infix operator fun minus(b: Vec2t<out Number>) = minus(Vec1ui(), this, b.x.i)

    fun minus(b: Number, res: Vec1ui) = minus(res, this, b.i)
    fun minus(b: Vec2t<out Number>, res: Vec1ui) = minus(res, this, b.x.i)

    infix operator fun minusAssign(b: Number) {
        minus(this, this, b.i)
    }

    infix operator fun minusAssign(b: Vec2t<out Number>) {
        minus(this, this, b.x.i)
    }


    infix operator fun times(b: Number) = times(Vec1ui(), this, b.i)
    infix operator fun times(b: Vec2t<out Number>) = times(Vec1ui(), this, b.x.i)

    fun times(b: Number, res: Vec1ui) = times(res, this, b.i)
    fun times(b: Vec2t<out Number>, res: Vec1ui) = times(res, this, b.x.i)

    infix operator fun timesAssign(b: Number) {
        times(this, this, b.i)
    }

    infix operator fun timesAssign(b: Vec2t<out Number>) {
        times(this, this, b.x.i)
    }


    infix operator fun div(b: Number) = div(Vec1ui(), this, b.i)
    infix operator fun div(b: Vec2t<out Number>) = div(Vec1ui(), this, b.x.i)

    fun div(b: Number, res: Vec1ui) = div(res, this, b.i)
    fun div(b: Vec2t<out Number>, res: Vec1ui) = div(res, this, b.x.i)

    infix operator fun divAssign(b: Number) {
        div(this, this, b.i)
    }

    infix operator fun divAssign(b: Vec2t<out Number>) {
        div(this, this, b.x.i)
    }


    infix operator fun rem(b: Number) = rem(Vec1ui(), this, b.i)
    infix operator fun rem(b: Vec2t<out Number>) = rem(Vec1ui(), this, b.x.i)

    fun rem(b: Number, res: Vec1ui) = rem(res, this, b.i)
    fun rem(b: Vec2t<out Number>, res: Vec1ui) = rem(res, this, b.x.i)

    infix operator fun remAssign(b: Number) {
        rem(this, this, b.i)
    }

    infix operator fun remAssign(b: Vec2t<out Number>) {
        rem(this, this, b.x.i)
    }


    // -- Specific bitwise operators --

    infix fun and(b: Uint) = and(Vec1ui(), this, b)
    infix fun and(b: Int) = and(Vec1ui(), this, b)
    infix fun and(b: Vec1ui) = and(Vec1ui(), this, b.x)

    fun and(b: Uint, res: Vec1ui) = and(res, this, b)
    fun and(b: Int, res: Vec1ui) = and(res, this, b)
    fun and(b: Vec1ui, res: Vec1ui) = and(res, this, b.x)

    infix fun andAssign(b: Uint) = and(this, this, b)
    infix fun andAssign(b: Int) = and(this, this, b)
    infix fun andAssign(b: Vec1ui) = and(this, this, b.x)


    infix fun or(b: Uint) = or(Vec1ui(), this, b)
    infix fun or(b: Int) = or(Vec1ui(), this, b)
    infix fun or(b: Vec1ui) = or(Vec1ui(), this, b.x)

    fun or(b: Uint, res: Vec1ui) = or(res, this, b)
    fun or(b: Int, res: Vec1ui) = or(res, this, b)
    fun or(b: Vec1ui, res: Vec1ui) = or(res, this, b.x)

    infix fun orAssign(b: Uint) = or(this, this, b)
    infix fun orAssign(b: Int) = or(this, this, b)
    infix fun orAssign(b: Vec1ui) = or(this, this, b.x)

    infix fun xor(b: Uint) = xor(Vec1ui(), this, b)
    infix fun xor(b: Int) = xor(Vec1ui(), this, b)
    infix fun xor(b: Vec1ui) = xor(Vec1ui(), this, b.x)

    fun xor(b: Uint, res: Vec1ui) = xor(res, this, b)
    fun xor(b: Int, res: Vec1ui) = xor(res, this, b)
    fun xor(b: Vec1ui, res: Vec1ui) = xor(res, this, b.x)

    infix fun xorAssign(b: Uint) = xor(this, this, b)
    infix fun xorAssign(b: Int) = xor(this, this, b)
    infix fun xorAssign(b: Vec1ui) = xor(this, this, b.x)

    infix fun shl(b: Uint) = shl(Vec1ui(), this, b)
    infix fun shl(b: Int) = shl(Vec1ui(), this, b)
    infix fun shl(b: Vec1ui) = shl(Vec1ui(), this, b.x)

    fun shl(b: Uint, res: Vec1ui) = shl(res, this, b)
    fun shl(b: Int, res: Vec1ui) = shl(res, this, b)
    fun shl(b: Vec1ui, res: Vec1ui) = shl(res, this, b.x)

    infix fun shlAssign(b: Uint) = shl(this, this, b)
    infix fun shlAssign(b: Int) = shl(this, this, b)
    infix fun shlAssign(b: Vec1ui) = shl(this, this, b.x)

    infix fun shr(b: Uint) = shr(Vec1ui(), this, b)
    infix fun shr(b: Int) = shr(Vec1ui(), this, b)
    infix fun shr(b: Vec1ui) = shr(Vec1ui(), this, b.x)

    fun shr(b: Uint, res: Vec1ui) = shr(res, this, b)
    fun shr(b: Int, res: Vec1ui) = shr(res, this, b)
    fun shr(b: Vec1ui, res: Vec1ui) = shr(res, this, b.x)

    infix fun shrAssign(b: Uint) = shr(this, this, b)
    infix fun shrAssign(b: Int) = shr(this, this, b)
    infix fun shrAssign(b: Vec1ui) = shr(this, this, b.x)

    @JvmOverloads
    fun inv(res: Vec1ui = Vec1ui()) = inv(res, this)

    fun invAssign() = inv(this, this)


    // -- Generic bitwise operators --

    infix fun and(b: Number) = and(Vec1ui(), this, b.i)
    infix fun and(b: Vec2t<out Number>) = and(Vec1ui(), this, b.x.i)

    fun and(b: Number, res: Vec1ui) = and(res, this, b.i)
    fun and(b: Vec2t<out Number>, res: Vec1ui) = and(res, this, b.x.i)

    infix fun andAssign(b: Number) = and(this, this, b.i)
    infix fun andAssign(b: Vec2t<out Number>) = and(this, this, b.x.i)


    infix fun or(b: Number) = or(Vec1ui(), this, b.i)
    infix fun or(b: Vec2t<out Number>) = or(Vec1ui(), this, b.x.i)

    fun or(b: Number, res: Vec1ui) = or(res, this, b.i)
    fun or(b: Vec2t<out Number>, res: Vec1ui) = or(res, this, b.x.i)

    infix fun orAssign(b: Number) = or(this, this, b.i)
    infix fun orAssign(b: Vec2t<out Number>) = or(this, this, b.x.i)


    infix fun xor(b: Number) = xor(Vec1ui(), this, b.i)
    infix fun xor(b: Vec2t<out Number>) = xor(Vec1ui(), this, b.x.i)

    fun xor(b: Number, res: Vec1ui) = xor(res, this, b.i)
    fun xor(b: Vec2t<out Number>, res: Vec1ui) = xor(res, this, b.x.i)

    infix fun xorAssign(b: Number) = xor(this, this, b.i)
    infix fun xorAssign(b: Vec2t<out Number>) = xor(this, this, b.x.i)


    infix fun shl(b: Number) = shl(Vec1ui(), this, b.i)
    infix fun shl(b: Vec2t<out Number>) = shl(Vec1ui(), this, b.x.i)

    fun shl(b: Number, res: Vec1ui) = shl(res, this, b.i)
    fun shl(b: Vec2t<out Number>, res: Vec1ui) = shl(res, this, b.x.i)

    infix fun shlAssign(b: Number) = shl(this, this, b.i)
    infix fun shlAssign(b: Vec2t<out Number>) = shl(this, this, b.x.i)


    infix fun shr(b: Number) = shr(Vec1ui(), this, b.i)
    infix fun shr(b: Vec2t<out Number>) = shr(Vec1ui(), this, b.x.i)

    fun shr(b: Number, res: Vec1ui) = shr(res, this, b.i)
    fun shr(b: Vec2t<out Number>, res: Vec1ui) = shr(res, this, b.x.i)

    infix fun shrAssign(b: Number) = shr(this, this, b.i)
    infix fun shrAssign(b: Vec2t<out Number>) = shr(this, this, b.x.i)


    companion object : opVec1ui {
        const val length = Vec1t.length
        @JvmField
        val size = length * Uint.BYTES
    }

    override fun size() = size

    override fun equals(other: Any?) = other is Vec1ui && this[0] == other[0]
    fun equal(b: Vec1ui, epsilon: Int = 0): Boolean = abs(x.v - b.x.v) <= epsilon
    fun notEqual(b: Vec1ui, epsilon: Int = 0): Boolean = !equal(b, epsilon)

    override fun hashCode() = x.v.hashCode()
}