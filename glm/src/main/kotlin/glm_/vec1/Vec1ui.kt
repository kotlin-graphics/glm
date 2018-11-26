package glm_.vec1

import glm_.*
import glm_.vec2.Vec2bool
import glm_.vec2.Vec2t
import glm_.vec3.Vec3bool
import glm_.vec3.Vec3t
import glm_.vec4.Vec4bool
import glm_.vec4.Vec4t
import kool.IntBuffer
import kool.pos
import org.lwjgl.system.MemoryStack
import unsigned.Uint
import java.nio.*

/**
 * Created by elect on 08/10/16.
 */

class Vec1ui(x: Uint) : Vec1t<Uint>(x) {

    // -- Explicit basic, conversion other main.and conversion vector constructors --

    constructor() : this(0)

    constructor(v: Vec2t<out Number>) : this(v.x)
    constructor(v: Vec3t<out Number>) : this(v.x)
    constructor(v: Vec4t<out Number>) : this(v.x)

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

    constructor(x: Number) : this(x.ui)


    fun set(bytes: ByteArray, index: Int = 0, oneByteOneUint: Boolean = false, bigEndian: Boolean = true) {
        x.v = if (oneByteOneUint) bytes[index].i else bytes.getInt(index, bigEndian)
    }

    fun set(bytes: ByteBuffer, index: Int = bytes.pos, oneByteOneUint: Boolean = false) {
        x.v = if (oneByteOneUint) bytes[index].i else bytes.getInt(index)
    }


    fun put(x: Uint) {
        this.x = x
    }

    fun invoke(x: Uint): Vec1ui {
        this.x = x
        return this
    }

    fun put(x: Int) {
        this.x.v = x
    }

    fun invoke(x: Int): Vec1ui {
        this.x.v = x
        return this
    }

    override fun put(x: Number) {
        this.x = x.ui
    }

    override fun invoke(x: Number): Vec1ui {
        this.x = x.ui
        return this
    }

    fun to(bytes: ByteArray, index: Int) = to(bytes, index, true)
    override fun to(bytes: ByteArray, index: Int, bigEndian: Boolean): ByteArray {
        bytes.putInt(index, x.v)
        return bytes
    }

    override fun to(buf: ByteBuffer, index: Int): ByteBuffer = buf.putInt(index, x.v)

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

//    operator fun unaryPlus() = this
//
//    // no unaryMinus operator, only signed
//
//    // -- Increment main.and decrement operators --
//
//    operator fun inc(res: Vec1ui = Vec1ui()) = plus(res, this, 1, 1)
//    fun inc_() = plus(this, this, 1, 1)
//
//
//    operator fun dec(res: Vec1ui = Vec1ui()) = minus(res, this, 1, 1)
//    fun dec_() = minus(this, this, 1, 1)
//
//
//    // -- Specific binary arithmetic operators --
//
//    infix operator fun plus(b: Uint) = plus(Vec1ui(), this, b, b)
//    infix operator fun plus(b: Int) = plus(Vec1ui(), this, b, b)
//    infix operator fun plus(b: Vec1ui) = plus(Vec1ui(), this, b.x, b.y)
//
//    @JvmOverloads
//    fun plus(bX: Uint, bY: Uint, res: Vec1ui = Vec1ui()) = plus(res, this, bX, bY)
//
//    @JvmOverloads
//    fun plus(bX: Int, bY: Int, res: Vec1ui = Vec1ui()) = plus(res, this, bX, bY)
//
//    fun plus(b: Uint, res: Vec1ui) = plus(res, this, b, b)
//    fun plus(b: Int, res: Vec1ui) = plus(res, this, b, b)
//    fun plus(b: Vec1ui, res: Vec1ui) = plus(res, this, b.x, b.y)
//
//    fun plus_(bX: Uint, bY: Uint) = plus(this, this, bX, bY)
//    fun plus_(bX: Int, bY: Int) = plus(this, this, bX, bY)
//    infix fun plus_(b: Uint) = plus(this, this, b, b)
//    infix fun plus_(b: Int) = plus(this, this, b, b)
//    infix fun plus_(b: Vec1ui) = plus(this, this, b.x, b.y)
//
//
//    infix operator fun minus(b: Uint) = minus(Vec1ui(), this, b, b)
//    infix operator fun minus(b: Int) = minus(Vec1ui(), this, b, b)
//    infix operator fun minus(b: Vec1ui) = minus(Vec1ui(), this, b.x, b.y)
//
//    @JvmOverloads
//    fun minus(bX: Uint, bY: Uint, res: Vec1ui = Vec1ui()) = minus(res, this, bX, bY)
//
//    @JvmOverloads
//    fun minus(bX: Int, bY: Int, res: Vec1ui = Vec1ui()) = minus(res, this, bX, bY)
//
//    fun minus(b: Uint, res: Vec1ui) = minus(res, this, b, b)
//    fun minus(b: Int, res: Vec1ui) = minus(res, this, b, b)
//    fun minus(b: Vec1ui, res: Vec1ui) = minus(res, this, b.x, b.y)
//
//    fun minus_(bX: Uint, bY: Uint) = minus(this, this, bX, bY)
//    fun minus_(bX: Int, bY: Int) = minus(this, this, bX, bY)
//    infix fun minus_(b: Uint) = minus(this, this, b, b)
//    infix fun minus_(b: Int) = minus(this, this, b, b)
//    infix fun minus_(b: Vec1ui) = minus(this, this, b.x, b.y)
//
//
//    infix operator fun times(b: Uint) = times(Vec1ui(), this, b, b)
//    infix operator fun times(b: Int) = times(Vec1ui(), this, b, b)
//    infix operator fun times(b: Vec1ui) = times(Vec1ui(), this, b.x, b.y)
//
//    @JvmOverloads
//    fun times(bX: Uint, bY: Uint, res: Vec1ui = Vec1ui()) = times(res, this, bX, bY)
//
//    @JvmOverloads
//    fun times(bX: Int, bY: Int, res: Vec1ui = Vec1ui()) = times(res, this, bX, bY)
//
//    fun times(b: Uint, res: Vec1ui) = times(res, this, b, b)
//    fun times(b: Int, res: Vec1ui) = times(res, this, b, b)
//    fun times(b: Vec1ui, res: Vec1ui) = times(res, this, b.x, b.y)
//
//    fun times_(bX: Uint, bY: Uint) = times(this, this, bX, bY)
//    fun times_(bX: Int, bY: Int) = times(this, this, bX, bY)
//    infix fun times_(b: Uint) = times(this, this, b, b)
//    infix fun times_(b: Int) = times(this, this, b, b)
//    infix fun times_(b: Vec1ui) = times(this, this, b.x, b.y)
//
//
//    infix operator fun div(b: Uint) = div(Vec1ui(), this, b, b)
//    infix operator fun div(b: Int) = div(Vec1ui(), this, b, b)
//    infix operator fun div(b: Vec1ui) = div(Vec1ui(), this, b.x, b.y)
//
//    @JvmOverloads
//    fun div(bX: Uint, bY: Uint, res: Vec1ui = Vec1ui()) = div(res, this, bX, bY)
//
//    @JvmOverloads
//    fun div(bX: Int, bY: Int, res: Vec1ui = Vec1ui()) = div(res, this, bX, bY)
//
//    fun div(b: Uint, res: Vec1ui) = div(res, this, b, b)
//    fun div(b: Int, res: Vec1ui) = div(res, this, b, b)
//    fun div(b: Vec1ui, res: Vec1ui) = div(res, this, b.x, b.y)
//
//    fun div_(bX: Uint, bY: Uint) = div(this, this, bX, bY)
//    fun div_(bX: Int, bY: Int) = div(this, this, bX, bY)
//    infix fun div_(b: Uint) = div(this, this, b, b)
//    infix fun div_(b: Int) = div(this, this, b, b)
//    infix fun div_(b: Vec1ui) = div(this, this, b.x, b.y)
//
//
//    infix operator fun rem(b: Uint) = rem(Vec1ui(), this, b, b)
//    infix operator fun rem(b: Int) = rem(Vec1ui(), this, b, b)
//    infix operator fun rem(b: Vec1ui) = rem(Vec1ui(), this, b.x, b.y)
//
//    @JvmOverloads
//    fun rem(bX: Uint, bY: Uint, res: Vec1ui = Vec1ui()) = rem(res, this, bX, bY)
//
//    @JvmOverloads
//    fun rem(bX: Int, bY: Int, res: Vec1ui = Vec1ui()) = rem(res, this, bX, bY)
//
//    fun rem(b: Uint, res: Vec1ui) = rem(res, this, b, b)
//    fun rem(b: Int, res: Vec1ui) = rem(res, this, b, b)
//    fun rem(b: Vec1ui, res: Vec1ui) = rem(res, this, b.x, b.y)
//
//    fun rem_(bX: Uint, bY: Uint) = rem(this, this, bX, bY)
//    fun rem_(bX: Int, bY: Int) = rem(this, this, bX, bY)
//    infix fun rem_(b: Uint) = rem(this, this, b, b)
//    infix fun rem_(b: Int) = rem(this, this, b, b)
//    infix fun rem_(b: Vec1ui) = rem(this, this, b.x, b.y)
//
//
//    // -- Generic binary arithmetic operators --
//
//    infix operator fun plus(b: Number) = plus(Vec1ui(), this, b.i, b.i)
//    infix operator fun plus(b: Vec2t<out Number>) = plus(Vec1ui(), this, b.x.i, b.y.i)
//
//    @JvmOverloads
//    fun plus(bX: Number, bY: Number, res: Vec1ui = Vec1ui()) = plus(res, this, bX.i, bY.i)
//
//    fun plus(b: Number, res: Vec1ui) = plus(res, this, b.i, b.i)
//    fun plus(b: Vec2t<out Number>, res: Vec1ui) = plus(res, this, b.x.i, b.y.i)
//
//    fun plus_(bX: Number, bY: Number) = plus(this, this, bX.i, bY.i)
//    infix fun plus_(b: Number) = plus(this, this, b.i, b.i)
//    infix fun plus_(b: Vec2t<out Number>) = plus(this, this, b.x.i, b.y.i)
//
//
//    infix operator fun minus(b: Number) = minus(Vec1ui(), this, b.i, b.i)
//    infix operator fun minus(b: Vec2t<out Number>) = minus(Vec1ui(), this, b.x.i, b.y.i)
//
//    @JvmOverloads
//    fun minus(bX: Number, bY: Number, res: Vec1ui = Vec1ui()) = minus(res, this, bX.i, bY.i)
//
//    fun minus(b: Number, res: Vec1ui) = minus(res, this, b.i, b.i)
//    fun minus(b: Vec2t<out Number>, res: Vec1ui) = minus(res, this, b.x.i, b.y.i)
//
//    fun minus_(bX: Number, bY: Number) = minus(this, this, bX.i, bY.i)
//    infix fun minus_(b: Number) = minus(this, this, b.i, b.i)
//    infix fun minus_(b: Vec2t<out Number>) = minus(this, this, b.x.i, b.y.i)
//
//
//    infix operator fun times(b: Number) = times(Vec1ui(), this, b.i, b.i)
//    infix operator fun times(b: Vec2t<out Number>) = times(Vec1ui(), this, b.x.i, b.y.i)
//
//    @JvmOverloads
//    fun times(bX: Number, bY: Number, res: Vec1ui = Vec1ui()) = times(res, this, bX.i, bY.i)
//
//    fun times(b: Number, res: Vec1ui) = times(res, this, b.i, b.i)
//    fun times(b: Vec2t<out Number>, res: Vec1ui) = times(res, this, b.x.i, b.y.i)
//
//    fun times_(bX: Number, bY: Number) = times(this, this, bX.i, bY.i)
//    infix fun times_(b: Number) = times(this, this, b.i, b.i)
//    infix fun times_(b: Vec2t<out Number>) = times(this, this, b.x.i, b.y.i)
//
//
//    infix operator fun div(b: Number) = div(Vec1ui(), this, b.i, b.i)
//    infix operator fun div(b: Vec2t<out Number>) = div(Vec1ui(), this, b.x.i, b.y.i)
//
//    @JvmOverloads
//    fun div(bX: Number, bY: Number, res: Vec1ui = Vec1ui()) = div(res, this, bX.i, bY.i)
//
//    fun div(b: Number, res: Vec1ui) = div(res, this, b.i, b.i)
//    fun div(b: Vec2t<out Number>, res: Vec1ui) = div(res, this, b.x.i, b.y.i)
//
//    fun div_(bX: Number, bY: Number) = div(this, this, bX.i, bY.i)
//    infix fun div_(b: Number) = div(this, this, b.i, b.i)
//    infix fun div_(b: Vec2t<out Number>) = div(this, this, b.x.i, b.y.i)
//
//
//    infix operator fun rem(b: Number) = rem(Vec1ui(), this, b.i, b.i)
//    infix operator fun rem(b: Vec2t<out Number>) = rem(Vec1ui(), this, b.x.i, b.y.i)
//
//    @JvmOverloads
//    fun rem(bX: Number, bY: Number, res: Vec1ui = Vec1ui()) = rem(res, this, bX.i, bY.i)
//
//    fun rem(b: Number, res: Vec1ui) = rem(res, this, b.i, b.i)
//    fun rem(b: Vec2t<out Number>, res: Vec1ui) = rem(res, this, b.x.i, b.y.i)
//
//    fun rem_(bX: Number, bY: Number) = rem(this, this, bX.i, bY.i)
//    infix fun rem_(b: Number) = rem(this, this, b.i, b.i)
//    infix fun rem_(b: Vec2t<out Number>) = rem(this, this, b.x.i, b.y.i)
//
//
//    // -- Specific bitwise operators --
//
//    infix fun and(b: Uint) = and(Vec1ui(), this, b, b)
//    infix fun and(b: Int) = and(Vec1ui(), this, b, b)
//    infix fun and(b: Vec1ui) = and(Vec1ui(), this, b.x, b.y)
//
//    fun and(b: Uint, res: Vec1ui) = and(res, this, b, b)
//    fun and(b: Int, res: Vec1ui) = and(res, this, b, b)
//    fun and(b: Vec1ui, res: Vec1ui) = and(res, this, b.x, b.y)
//    @JvmOverloads
//    fun and(bX: Uint, bY: Uint, res: Vec1ui = Vec1ui()) = and(res, this, bX, bY)
//
//    @JvmOverloads
//    fun and(bX: Int, bY: Int, res: Vec1ui = Vec1ui()) = and(res, this, bX, bY)
//
//    infix fun and_(b: Uint) = and(this, this, b, b)
//    infix fun and_(b: Int) = and(this, this, b, b)
//    infix fun and_(b: Vec1ui) = and(this, this, b.x, b.y)
//    fun and_(bX: Uint, bY: Uint) = and(this, this, bX, bY)
//    fun and_(bX: Int, bY: Int) = and(this, this, bX, bY)
//
//
//    infix fun or(b: Uint) = or(Vec1ui(), this, b, b)
//    infix fun or(b: Int) = or(Vec1ui(), this, b, b)
//    infix fun or(b: Vec1ui) = or(Vec1ui(), this, b.x, b.y)
//
//    fun or(b: Uint, res: Vec1ui) = or(res, this, b, b)
//    fun or(b: Int, res: Vec1ui) = or(res, this, b, b)
//    fun or(b: Vec1ui, res: Vec1ui) = or(res, this, b.x, b.y)
//    @JvmOverloads
//    fun or(bX: Uint, bY: Uint, res: Vec1ui = Vec1ui()) = or(res, this, bX, bY)
//
//    @JvmOverloads
//    fun or(bX: Int, bY: Int, res: Vec1ui = Vec1ui()) = or(res, this, bX, bY)
//
//    infix fun or_(b: Uint) = or(this, this, b, b)
//    infix fun or_(b: Int) = or(this, this, b, b)
//    infix fun or_(b: Vec1ui) = or(this, this, b.x, b.y)
//    fun or_(bX: Uint, bY: Uint) = or(this, this, bX, bY)
//    fun or_(bX: Int, bY: Int) = or(this, this, bX, bY)
//
//
//    infix fun xor(b: Uint) = xor(Vec1ui(), this, b, b)
//    infix fun xor(b: Int) = xor(Vec1ui(), this, b, b)
//    infix fun xor(b: Vec1ui) = xor(Vec1ui(), this, b.x, b.y)
//
//    fun xor(b: Uint, res: Vec1ui) = xor(res, this, b, b)
//    fun xor(b: Int, res: Vec1ui) = xor(res, this, b, b)
//    fun xor(b: Vec1ui, res: Vec1ui) = xor(res, this, b.x, b.y)
//    @JvmOverloads
//    fun xor(bX: Uint, bY: Uint, res: Vec1ui = Vec1ui()) = xor(res, this, bX, bY)
//
//    @JvmOverloads
//    fun xor(bX: Int, bY: Int, res: Vec1ui = Vec1ui()) = xor(res, this, bX, bY)
//
//    infix fun xor_(b: Uint) = xor(this, this, b, b)
//    infix fun xor_(b: Int) = xor(this, this, b, b)
//    infix fun xor_(b: Vec1ui) = xor(this, this, b.x, b.y)
//    fun xor_(bX: Uint, bY: Uint) = xor(this, this, bX, bY)
//    fun xor_(bX: Int, bY: Int) = xor(this, this, bX, bY)
//
//
//    infix fun shl(b: Uint) = shl(Vec1ui(), this, b, b)
//    infix fun shl(b: Int) = shl(Vec1ui(), this, b, b)
//    infix fun shl(b: Vec1ui) = shl(Vec1ui(), this, b.x, b.y)
//
//    fun shl(b: Uint, res: Vec1ui) = shl(res, this, b, b)
//    fun shl(b: Int, res: Vec1ui) = shl(res, this, b, b)
//    fun shl(b: Vec1ui, res: Vec1ui) = shl(res, this, b.x, b.y)
//    @JvmOverloads
//    fun shl(bX: Uint, bY: Uint, res: Vec1ui = Vec1ui()) = shl(res, this, bX, bY)
//
//    @JvmOverloads
//    fun shl(bX: Int, bY: Int, res: Vec1ui = Vec1ui()) = shl(res, this, bX, bY)
//
//    infix fun shl_(b: Uint) = shl(this, this, b, b)
//    infix fun shl_(b: Int) = shl(this, this, b, b)
//    infix fun shl_(b: Vec1ui) = shl(this, this, b.x, b.y)
//    fun shl_(bX: Uint, bY: Uint) = shl(this, this, bX, bY)
//    fun shl_(bX: Int, bY: Int) = shl(this, this, bX, bY)
//
//
//    infix fun shr(b: Uint) = shr(Vec1ui(), this, b, b)
//    infix fun shr(b: Int) = shr(Vec1ui(), this, b, b)
//    infix fun shr(b: Vec1ui) = shr(Vec1ui(), this, b.x, b.y)
//
//    fun shr(b: Uint, res: Vec1ui) = shr(res, this, b, b)
//    fun shr(b: Int, res: Vec1ui) = shr(res, this, b, b)
//    fun shr(b: Vec1ui, res: Vec1ui) = shr(res, this, b.x, b.y)
//    @JvmOverloads
//    fun shr(bX: Uint, bY: Uint, res: Vec1ui = Vec1ui()) = shr(res, this, bX, bY)
//
//    @JvmOverloads
//    fun shr(bX: Int, bY: Int, res: Vec1ui = Vec1ui()) = shr(res, this, bX, bY)
//
//    infix fun shr_(b: Uint) = shr(this, this, b, b)
//    infix fun shr_(b: Int) = shr(this, this, b, b)
//    infix fun shr_(b: Vec1ui) = shr(this, this, b.x, b.y)
//    fun shr_(bX: Uint, bY: Uint) = shr(this, this, bX, bY)
//    fun shr_(bX: Int, bY: Int) = shr(this, this, bX, bY)
//
//
//    @JvmOverloads
//    fun inv(res: Vec1ui = Vec1ui()) = inv(res, this)
//
//    fun inv_() = inv(this, this)
//
//
//    // -- Generic bitwise operators --
//
//    infix fun and(b: Number) = and(Vec1ui(), this, b.i, b.i)
//    infix fun and(b: Vec2t<out Number>) = and(Vec1ui(), this, b.x.i, b.y.i)
//
//    fun and(b: Number, res: Vec1ui) = and(res, this, b.i, b.i)
//    fun and(b: Vec2t<out Number>, res: Vec1ui) = and(res, this, b.x.i, b.y.i)
//    @JvmOverloads
//    fun and(bX: Number, bY: Number, res: Vec1ui = Vec1ui()) = and(res, this, bX.i, bY.i)
//
//    infix fun and_(b: Number) = and(this, this, b.i, b.i)
//    infix fun and_(b: Vec2t<out Number>) = and(this, this, b.x.i, b.y.i)
//    fun and_(bX: Number, bY: Number) = and(this, this, bX.i, bY.i)
//
//
//    infix fun or(b: Number) = or(Vec1ui(), this, b.i, b.i)
//    infix fun or(b: Vec2t<out Number>) = or(Vec1ui(), this, b.x.i, b.y.i)
//
//    fun or(b: Number, res: Vec1ui) = or(res, this, b.i, b.i)
//    fun or(b: Vec2t<out Number>, res: Vec1ui) = or(res, this, b.x.i, b.y.i)
//    @JvmOverloads
//    fun or(bX: Number, bY: Number, res: Vec1ui = Vec1ui()) = or(res, this, bX.i, bY.i)
//
//    infix fun or_(b: Number) = or(this, this, b.i, b.i)
//    infix fun or_(b: Vec2t<out Number>) = or(this, this, b.x.i, b.y.i)
//    fun or_(bX: Number, bY: Number) = or(this, this, bX.i, bY.i)
//
//
//    infix fun xor(b: Number) = xor(Vec1ui(), this, b.i, b.i)
//    infix fun xor(b: Vec2t<out Number>) = xor(Vec1ui(), this, b.x.i, b.y.i)
//
//    fun xor(b: Number, res: Vec1ui) = xor(res, this, b.i, b.i)
//    fun xor(b: Vec2t<out Number>, res: Vec1ui) = xor(res, this, b.x.i, b.y.i)
//    @JvmOverloads
//    fun xor(bX: Number, bY: Number, res: Vec1ui = Vec1ui()) = xor(res, this, bX.i, bY.i)
//
//    infix fun xor_(b: Number) = xor(this, this, b.i, b.i)
//    infix fun xor_(b: Vec2t<out Number>) = xor(this, this, b.x.i, b.y.i)
//    fun xor_(bX: Number, bY: Number) = xor(this, this, bX.i, bY.i)
//
//
//    infix fun shl(b: Number) = shl(Vec1ui(), this, b.i, b.i)
//    infix fun shl(b: Vec2t<out Number>) = shl(Vec1ui(), this, b.x.i, b.y.i)
//
//    fun shl(b: Number, res: Vec1ui) = shl(res, this, b.i, b.i)
//    fun shl(b: Vec2t<out Number>, res: Vec1ui) = shl(res, this, b.x.i, b.y.i)
//    @JvmOverloads
//    fun shl(bX: Number, bY: Number, res: Vec1ui = Vec1ui()) = shl(res, this, bX.i, bY.i)
//
//    infix fun shl_(b: Number) = shl(this, this, b.i, b.i)
//    infix fun shl_(b: Vec2t<out Number>) = shl(this, this, b.x.i, b.y.i)
//    fun shl_(bX: Number, bY: Number) = shl(this, this, bX.i, bY.i)
//
//
//    infix fun shr(b: Number) = shr(Vec1ui(), this, b.i, b.i)
//    infix fun shr(b: Vec2t<out Number>) = shr(Vec1ui(), this, b.x.i, b.y.i)
//
//    fun shr(b: Number, res: Vec1ui) = shr(res, this, b.i, b.i)
//    fun shr(b: Vec2t<out Number>, res: Vec1ui) = shr(res, this, b.x.i, b.y.i)
//    @JvmOverloads
//    fun shr(bX: Number, bY: Number, res: Vec1ui = Vec1ui()) = shr(res, this, bX.i, bY.i)
//
//    infix fun shr_(b: Number) = shr(this, this, b.i, b.i)
//    infix fun shr_(b: Vec2t<out Number>) = shr(this, this, b.x.i, b.y.i)
//    fun shr_(bX: Number, bY: Number) = shr(this, this, bX.i, bY.i)


    companion object /*: opVec2ui */ {
        const val length = Vec1t.length
        @JvmField
        val size = length * Uint.BYTES
    }

    override fun size() = size

    override fun equals(other: Any?) = other is Vec1ui && this[0] == other[0]
    override fun hashCode() = x.v.hashCode()
}