package vec._4

import main.BYTES
import Uint
import main.getInt
import main.getUint
import main.i
import main.ui
import vec.Vec2t
import vec.Vec3t
import vec.Vec4t
import vec._4.operators.vec4ui_operators
import vec.bool.Vec2bool
import vec.bool.Vec3bool
import vec.bool.Vec4bool
import java.nio.*

/**
 * Created by elect on 09/10/16.
 */

data class Vec4ui(override var x: Uint, override var y: Uint, override var z: Uint, override var w: Uint) : Vec4t<Uint>() {

    // -- Explicit basic, conversion other main.and conversion vector constructors --

    constructor() : this(0)

    constructor(v: Vec2t<out Number>) : this(v.x, v.y, 0, 1)
    constructor(v: Vec3t<out Number>) : this(v.x, v.y, v.z, 1)
    constructor(v: Vec4t<out Number>) : this(v.x, v.y, v.z, v.w)

    constructor(v: Vec2bool) : this(v.x.ui, v.y.ui, 0, 1)
    constructor(v: Vec3bool) : this(v.x.ui, v.y.ui, v.z.ui, 1)
    constructor(v: Vec4bool) : this(v.x.ui, v.y.ui, v.z.ui, v.w.ui)

    constructor(bytes: ByteArray, index: Int = 0, oneByteOneUint: Boolean = true, bigEndianess: Boolean = true) : this(
            if (oneByteOneUint) bytes[index].ui else bytes.getUint(index, bigEndianess),
            if (oneByteOneUint) bytes[index + 1].ui else bytes.getUint(index + Uint.BYTES, bigEndianess),
            if (oneByteOneUint) bytes[index + 2].ui else bytes.getUint(index + Uint.BYTES * 2, bigEndianess),
            if (oneByteOneUint) bytes[index + 3].ui else bytes.getUint(index + Uint.BYTES * 3, bigEndianess))

    constructor(chars: CharArray, index: Int = 0) : this(chars[index].ui, chars[index + 1].ui, chars[index + 2].ui, chars[index + 3].ui)
    constructor(shorts: ShortArray, index: Int = 0) : this(shorts[index], shorts[index + 1], shorts[index + 2], shorts[index + 3])
    constructor(ints: IntArray, index: Int = 0) : this(ints[index], ints[index + 1], ints[index + 2], ints[index + 3])
    constructor(longs: LongArray, index: Int = 0) : this(longs[index], longs[index + 1], longs[index + 2], longs[index + 3])
    constructor(floats: FloatArray, index: Int = 0) : this(floats[index], floats[index + 1], floats[index + 2], floats[index + 3])
    constructor(doubles: DoubleArray, index: Int = 0) : this(doubles[index], doubles[index + 1], doubles[index + 2], doubles[index + 3])
    constructor(booleans: BooleanArray, index: Int = 0) : this(booleans[index].ui, booleans[index + 1].ui, booleans[index + 2].ui, booleans[index + 3].ui)

    constructor(numbers: Array<out Number>, index: Int = 0) : this(numbers[index], numbers[index + 1], numbers[index + 2], numbers[index + 3])
    constructor(chars: Array<Char>, index: Int = 0) : this(chars[index].ui, chars[index + 1].ui, chars[index + 2].ui, chars[index + 3].ui)
    constructor(booleans: Array<Boolean>, index: Int = 0) : this(booleans[index].ui, booleans[index + 1].ui, booleans[index + 2].ui, booleans[index + 3].ui)

    constructor(list: List<Any>, index: Int = 0) : this() {
        Set(list, index)
    }

    constructor(bytes: ByteBuffer, index: Int = bytes.position(), oneByteOneUint: Boolean = true) : this(
            if (oneByteOneUint) bytes[index].ui else bytes.getInt(index).ui,
            if (oneByteOneUint) bytes[index + 1].ui else bytes.getInt(index + Uint.BYTES).ui,
            if (oneByteOneUint) bytes[index + 2].ui else bytes.getInt(index + Uint.BYTES * 2).ui,
            if (oneByteOneUint) bytes[index + 3].ui else bytes.getInt(index + Uint.BYTES * 3).ui)

    constructor(chars: CharBuffer, index: Int = chars.position()) : this(chars[index].ui, chars[index + 1].ui, chars[index + 2].ui, chars[index + 3].ui)
    constructor(shorts: ShortBuffer, index: Int = shorts.position()) : this(shorts[index], shorts[index + 1], shorts[index + 2], shorts[index + 3])
    constructor(ints: IntBuffer, index: Int = ints.position()) : this(ints[index], ints[index + 1], ints[index + 2], ints[index + 3])
    constructor(longs: LongBuffer, index: Int = longs.position()) : this(longs[index], longs[index + 1], longs[index + 2], longs[index + 3])
    constructor(floats: FloatBuffer, index: Int = floats.position()) : this(floats[index], floats[index + 1], floats[index + 2], floats[index + 3])
    constructor(doubles: DoubleBuffer, index: Int = doubles.position()) : this(doubles[index], doubles[index + 1], doubles[index + 2], doubles[index + 3])

    constructor(s: Number) : this(s, s, s, s)
    constructor(x: Number, y: Number, z: Number, w: Number) : this(x.ui, y.ui, z.ui, w.ui)


    fun set(bytes: ByteArray, index: Int = 0, oneByteOneUint: Boolean = true, bigEndianess: Boolean = true) {
        x.v = if (oneByteOneUint) bytes[index].i else bytes.getInt(index, bigEndianess)
        y.v = if (oneByteOneUint) bytes[index + 1].i else bytes.getInt(index + Uint.BYTES, bigEndianess)
        z.v = if (oneByteOneUint) bytes[index + 2].i else bytes.getInt(index + Uint.BYTES * 2, bigEndianess)
        w.v = if (oneByteOneUint) bytes[index + 3].i else bytes.getInt(index + Uint.BYTES * 3, bigEndianess)
    }

    fun set(bytes: ByteBuffer, index: Int = bytes.position(), oneByteOneUint: Boolean = true) {
        x.v = if (oneByteOneUint) bytes[index].i else bytes.getInt(index)
        y.v = if (oneByteOneUint) bytes[index + 1].i else bytes.getInt(index + Uint.BYTES)
        z.v = if (oneByteOneUint) bytes[index + 2].i else bytes.getInt(index + Uint.BYTES * 2)
        w.v = if (oneByteOneUint) bytes[index + 3].i else bytes.getInt(index + Uint.BYTES * 3)
    }


    override fun Set(x: Number, y: Number, z: Number, w: Number): Vec4ui {
        this.x = x.ui
        this.y = y.ui
        this.z = z.ui
        this.w = w.ui
        return this
    }


    // -- Component accesses --

    operator fun get(i: Int) = when (i) {
        0 -> x
        1 -> y
        2 -> z
        3 -> w
        else -> throw ArrayIndexOutOfBoundsException()
    }

    operator fun set(i: Int, s: Number) = when (i) {
        0 -> x = s.ui
        1 -> y = s.ui
        2 -> z = s.ui
        3 -> w = s.ui
        else -> throw ArrayIndexOutOfBoundsException()
    }


    companion object : vec4ui_operators {
        @JvmField val SIZE = 4 * Uint.BYTES
    }


    // -- Unary arithmetic operators --

    operator fun unaryPlus() = this

    // no unaryMinus operator, only signed

    // -- Increment main.and decrement operators --

    operator fun inc(res: Vec4ui = Vec4ui()) = add(res, this, 1, 1, 1, 1)
    fun inc_() = add(this, this, 1, 1, 1, 1)


    operator fun dec(res: Vec4ui = Vec4ui()) = sub(res, this, 1, 1, 1, 1)
    fun dec_() = sub(this, this, 1, 1, 1, 1)


    // -- Specific binary arithmetic operators --

    operator fun plus(b: Uint) = add(Vec4ui(), this, b, b, b, b)
    operator fun plus(b: Int) = add(Vec4ui(), this, b, b, b, b)
    operator fun plus(b: Vec4ui) = add(Vec4ui(), this, b.x, b.y, b.z, b.w)

    fun add(bX: Uint, bY: Uint, bZ: Uint, bW: Uint, res: Vec4ui = Vec4ui()) = add(res, this, bX, bY, bZ, bW)
    fun add(bX: Int, bY: Int, bZ: Int, bW: Int, res: Vec4ui = Vec4ui()) = add(res, this, bX, bY, bZ, bW)
    fun add(b: Uint, res: Vec4ui = Vec4ui()) = add(res, this, b, b, b, b)
    fun add(b: Int, res: Vec4ui = Vec4ui()) = add(res, this, b, b, b, b)
    fun add(b: Vec4ui, res: Vec4ui = Vec4ui()) = add(res, this, b.x, b.y, b.z, b.w)

    fun add_(bX: Uint, bY: Uint, bZ: Uint, bW: Uint) = add(this, this, bX, bY, bZ, bW)
    fun add_(bX: Int, bY: Int, bZ: Int, bW: Int) = add(this, this, bX, bY, bZ, bW)
    infix fun add_(b: Uint) = add(this, this, b, b, b, b)
    infix fun add_(b: Int) = add(this, this, b, b, b, b)
    infix fun add_(b: Vec4ui) = add(this, this, b.x, b.y, b.z, b.w)


    operator fun minus(b: Uint) = sub(Vec4ui(), this, b, b, b, b)
    operator fun minus(b: Int) = sub(Vec4ui(), this, b, b, b, b)
    operator fun minus(b: Vec4ui) = sub(Vec4ui(), this, b.x, b.y, b.z, b.w)

    fun sub(bX: Uint, bY: Uint, bZ: Uint, bW: Uint, res: Vec4ui = Vec4ui()) = sub(res, this, bX, bY, bZ, bW)
    fun sub(bX: Int, bY: Int, bZ: Int, bW: Int, res: Vec4ui = Vec4ui()) = sub(res, this, bX, bY, bZ, bW)
    fun sub(b: Uint, res: Vec4ui = Vec4ui()) = sub(res, this, b, b, b, b)
    fun sub(b: Int, res: Vec4ui = Vec4ui()) = sub(res, this, b, b, b, b)
    fun sub(b: Vec4ui, res: Vec4ui = Vec4ui()) = sub(res, this, b.x, b.y, b.z, b.w)

    fun sub_(bX: Uint, bY: Uint, bZ: Uint, bW: Uint) = sub(this, this, bX, bY, bZ, bW)
    fun sub_(bX: Int, bY: Int, bZ: Int, bW: Int) = sub(this, this, bX, bY, bZ, bW)
    infix fun sub_(b: Uint) = sub(this, this, b, b, b, b)
    infix fun sub_(b: Int) = sub(this, this, b, b, b, b)
    infix fun sub_(b: Vec4ui) = sub(this, this, b.x, b.y, b.z, b.w)


    operator fun times(b: Uint) = mul(Vec4ui(), this, b, b, b, b)
    operator fun times(b: Int) = mul(Vec4ui(), this, b, b, b, b)
    operator fun times(b: Vec4ui) = mul(Vec4ui(), this, b.x, b.y, b.z, b.w)

    fun mul(bX: Uint, bY: Uint, bZ: Uint, bW: Uint, res: Vec4ui = Vec4ui()) = mul(res, this, bX, bY, bZ, bW)
    fun mul(bX: Int, bY: Int, bZ: Int, bW: Int, res: Vec4ui = Vec4ui()) = mul(res, this, bX, bY, bZ, bW)
    fun mul(b: Uint, res: Vec4ui = Vec4ui()) = mul(res, this, b, b, b, b)
    fun mul(b: Int, res: Vec4ui = Vec4ui()) = mul(res, this, b, b, b, b)
    fun mul(b: Vec4ui, res: Vec4ui = Vec4ui()) = mul(res, this, b.x, b.y, b.z, b.w)

    fun mul_(bX: Uint, bY: Uint, bZ: Uint, bW: Uint) = mul(this, this, bX, bY, bZ, bW)
    fun mul_(bX: Int, bY: Int, bZ: Int, bW: Int) = mul(this, this, bX, bY, bZ, bW)
    infix fun mul_(b: Uint) = mul(this, this, b, b, b, b)
    infix fun mul_(b: Int) = mul(this, this, b, b, b, b)
    infix fun mul_(b: Vec4ui) = mul(this, this, b.x, b.y, b.z, b.w)


    operator fun div(b: Uint) = div(Vec4ui(), this, b, b, b, b)
    operator fun div(b: Int) = div(Vec4ui(), this, b, b, b, b)
    operator fun div(b: Vec4ui) = div(Vec4ui(), this, b.x, b.y, b.z, b.w)

    fun div(bX: Uint, bY: Uint, bZ: Uint, bW: Uint, res: Vec4ui = Vec4ui()) = div(res, this, bX, bY, bZ, bW)
    fun div(bX: Int, bY: Int, bZ: Int, bW: Int, res: Vec4ui = Vec4ui()) = div(res, this, bX, bY, bZ, bW)
    fun div(b: Uint, res: Vec4ui) = div(res, this, b, b, b, b)
    fun div(b: Int, res: Vec4ui) = div(res, this, b, b, b, b)
    fun div(b: Vec4ui, res: Vec4ui) = div(res, this, b.x, b.y, b.z, b.w)

    fun div_(bX: Uint, bY: Uint, bZ: Uint, bW: Uint) = div(this, this, bX, bY, bZ, bW)
    fun div_(bX: Int, bY: Int, bZ: Int, bW: Int) = div(this, this, bX, bY, bZ, bW)
    infix fun div_(b: Uint) = div(this, this, b, b, b, b)
    infix fun div_(b: Int) = div(this, this, b, b, b, b)
    infix fun div_(b: Vec4ui) = div(this, this, b.x, b.y, b.z, b.w)


    operator fun rem(b: Uint) = rem(Vec4ui(), this, b, b, b, b)
    operator fun rem(b: Int) = rem(Vec4ui(), this, b, b, b, b)
    operator fun rem(b: Vec4ui) = rem(Vec4ui(), this, b.x, b.y, b.z, b.w)

    fun rem(bX: Uint, bY: Uint, bZ: Uint, bW: Uint, res: Vec4ui = Vec4ui()) = rem(res, this, bX, bY, bZ, bW)
    fun rem(bX: Int, bY: Int, bZ: Int, bW: Int, res: Vec4ui = Vec4ui()) = rem(res, this, bX, bY, bZ, bW)
    fun rem(b: Uint, res: Vec4ui) = rem(res, this, b, b, b, b)
    fun rem(b: Int, res: Vec4ui) = rem(res, this, b, b, b, b)
    fun rem(b: Vec4ui, res: Vec4ui) = rem(res, this, b.x, b.y, b.z, b.w)

    fun rem_(bX: Uint, bY: Uint, bZ: Uint, bW: Uint) = rem(this, this, bX, bY, bZ, bW)
    fun rem_(bX: Int, bY: Int, bZ: Int, bW: Int) = rem(this, this, bX, bY, bZ, bW)
    infix fun rem_(b: Uint) = rem(this, this, b, b, b, b)
    infix fun rem_(b: Int) = rem(this, this, b, b, b, b)
    infix fun rem_(b: Vec4ui) = rem(this, this, b.x, b.y, b.z, b.w)


    // -- Generic binary arithmetic operators --

    operator fun plus(b: Number) = add(Vec4ui(), this, b.i, b.i, b.i, b.i)
    operator fun plus(b: Vec4t<Number>) = add(Vec4ui(), this, b.x.i, b.y.i, b.z.i, b.w.i)

    fun add(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4ui = Vec4ui()) = add(res, this, bX.i, bY.i, bZ.i, bW.i)
    fun add(b: Number, res: Vec4ui = Vec4ui()) = add(res, this, b.i, b.i, b.i, b.i)
    fun add(b: Vec4t<Number>, res: Vec4ui = Vec4ui()) = add(res, this, b.x.i, b.y.i, b.z.i, b.w.i)

    fun add_(bX: Number, bY: Number, bZ: Number, bW: Number) = add(this, this, bX.i, bY.i, bZ.i, bW.i)
    infix fun add_(b: Number) = add(this, this, b.i, b.i, b.i, b.i)
    infix fun add_(b: Vec4t<Number>) = add(this, this, b.x.i, b.y.i, b.z.i, b.w.i)


    operator fun minus(b: Number) = sub(Vec4ui(), this, b.i, b.i, b.i, b.i)
    operator fun minus(b: Vec4t<Number>) = sub(Vec4ui(), this, b.x.i, b.y.i, b.z.i, b.w.i)

    fun sub(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4ui = Vec4ui()) = sub(res, this, bX.i, bY.i, bZ.i, bW.i)
    fun sub(b: Number, res: Vec4ui = Vec4ui()) = sub(res, this, b.i, b.i, b.i, b.i)
    fun sub(b: Vec4t<Number>, res: Vec4ui = Vec4ui()) = sub(res, this, b.x.i, b.y.i, b.z.i, b.w.i)

    fun sub_(bX: Number, bY: Number, bZ: Number, bW: Number) = sub(this, this, bX.i, bY.i, bZ.i, bW.i)
    infix fun sub_(b: Number) = sub(this, this, b.i, b.i, b.i, b.i)
    infix fun sub_(b: Vec4t<Number>) = sub(this, this, b.x.i, b.y.i, b.z.i, b.w.i)


    operator fun times(b: Number) = mul(Vec4ui(), this, b.i, b.i, b.i, b.i)
    operator fun times(b: Vec4t<Number>) = mul(Vec4ui(), this, b.x.i, b.y.i, b.z.i, b.w.i)

    fun mul(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4ui = Vec4ui()) = mul(res, this, bX.i, bY.i, bZ.i, bW.i)
    fun mul(b: Number, res: Vec4ui = Vec4ui()) = mul(res, this, b.i, b.i, b.i, b.i)
    fun mul(b: Vec4t<Number>, res: Vec4ui = Vec4ui()) = mul(res, this, b.x.i, b.y.i, b.z.i, b.w.i)

    fun mul_(bX: Number, bY: Number, bZ: Number, bW: Number) = mul(this, this, bX.i, bY.i, bZ.i, bW.i)
    infix fun mul_(b: Number) = mul(this, this, b.i, b.i, b.i, b.i)
    infix fun mul_(b: Vec4t<Number>) = mul(this, this, b.x.i, b.y.i, b.z.i, b.w.i)


    operator fun div(b: Number) = div(Vec4ui(), this, b.i, b.i, b.i, b.i)
    operator fun div(b: Vec4t<Number>) = div(Vec4ui(), this, b.x.i, b.y.i, b.z.i, b.w.i)

    fun div(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4ui = Vec4ui()) = div(res, this, bX.i, bY.i, bZ.i, bW.i)
    fun div(b: Number, res: Vec4ui) = div(res, this, b.i, b.i, b.i, b.i)
    fun div(b: Vec4t<Number>, res: Vec4ui) = div(res, this, b.x.i, b.y.i, b.z.i, b.w.i)

    fun div_(bX: Number, bY: Number, bZ: Number, bW: Number) = div(this, this, bX.i, bY.i, bZ.i, bW.i)
    infix fun div_(b: Number) = div(this, this, b.i, b.i, b.i, b.i)
    infix fun div_(b: Vec4t<Number>) = div(this, this, b.x.i, b.y.i, b.z.i, b.w.i)


    operator fun rem(b: Number) = rem(Vec4ui(), this, b.i, b.i, b.i, b.i)
    operator fun rem(b: Vec4t<Number>) = rem(Vec4ui(), this, b.x.i, b.y.i, b.z.i, b.w.i)

    fun rem(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4ui = Vec4ui()) = rem(res, this, bX.i, bY.i, bZ.i, bW.i)
    fun rem(b: Number, res: Vec4ui) = rem(res, this, b.i, b.i, b.i, b.i)
    fun rem(b: Vec4t<Number>, res: Vec4ui) = rem(res, this, b.x.i, b.y.i, b.z.i, b.w.i)

    fun rem_(bX: Number, bY: Number, bZ: Number, bW: Number) = rem(this, this, bX.i, bY.i, bZ.i, bW.i)
    infix fun rem_(b: Number) = rem(this, this, b.i, b.i, b.i, b.i)
    infix fun rem_(b: Vec4t<Number>) = rem(this, this, b.x.i, b.y.i, b.z.i, b.w.i)


    // -- Specific bitwise operators --

    infix fun and(b: Uint) = and(Vec4ui(), this, b, b, b, b)
    infix fun and(b: Int) = and(Vec4ui(), this, b, b, b, b)
    infix fun and(b: Vec4ui) = and(Vec4ui(), this, b.x, b.y, b.z, b.w)

    infix fun and_(b: Uint) = and(this, this, b, b, b, b)
    infix fun and_(b: Int) = and(this, this, b, b, b, b)
    infix fun and_(b: Vec4ui) = and(this, this, b.x, b.y, b.z, b.w)

    fun and(b: Uint, res: Vec4ui) = and(res, this, b, b, b, b)
    fun and(b: Int, res: Vec4ui) = and(res, this, b, b, b, b)
    fun and(b: Vec4ui, res: Vec4ui) = and(res, this, b.x, b.y, b.z, b.w)

    fun and(bX: Uint, bY: Uint, bZ: Uint, bW: Uint, res: Vec4ui = Vec4ui()) = and(res, this, bX, bY, bZ, bW)
    fun and(bX: Int, bY: Int, bZ: Int, bW: Int, res: Vec4ui = Vec4ui()) = and(res, this, bX, bY, bZ, bW)

    fun and_(bX: Uint, bY: Uint, bZ: Uint, bW: Uint) = and(this, this, bX, bY, bZ, bW)
    fun and_(bX: Int, bY: Int, bZ: Int, bW: Int) = and(this, this, bX, bY, bZ, bW)


    infix fun or(b: Uint) = or(Vec4ui(), this, b, b, b, b)
    infix fun or(b: Int) = or(Vec4ui(), this, b, b, b, b)
    infix fun or(b: Vec4ui) = or(Vec4ui(), this, b.x, b.y, b.z, b.w)

    infix fun or_(b: Uint) = or(this, this, b, b, b, b)
    infix fun or_(b: Int) = or(this, this, b, b, b, b)
    infix fun or_(b: Vec4ui) = or(this, this, b.x, b.y, b.z, b.w)

    fun or(b: Uint, res: Vec4ui) = or(res, this, b, b, b, b)
    fun or(b: Int, res: Vec4ui) = or(res, this, b, b, b, b)
    fun or(b: Vec4ui, res: Vec4ui) = or(res, this, b.x, b.y, b.z, b.w)

    fun or(bX: Uint, bY: Uint, bZ: Uint, bW: Uint, res: Vec4ui = Vec4ui()) = or(res, this, bX, bY, bZ, bW)
    fun or(bX: Int, bY: Int, bZ: Int, bW: Int, res: Vec4ui = Vec4ui()) = or(res, this, bX, bY, bZ, bW)

    fun or_(bX: Uint, bY: Uint, bZ: Uint, bW: Uint) = or(this, this, bX, bY, bZ, bW)
    fun or_(bX: Int, bY: Int, bZ: Int, bW: Int) = or(this, this, bX, bY, bZ, bW)


    infix fun xor(b: Uint) = xor(Vec4ui(), this, b, b, b, b)
    infix fun xor(b: Int) = xor(Vec4ui(), this, b, b, b, b)
    infix fun xor(b: Vec4ui) = xor(Vec4ui(), this, b.x, b.y, b.z, b.w)

    infix fun xor_(b: Uint) = xor(this, this, b, b, b, b)
    infix fun xor_(b: Int) = xor(this, this, b, b, b, b)
    infix fun xor_(b: Vec4ui) = xor(this, this, b.x, b.y, b.z, b.w)

    fun xor(b: Uint, res: Vec4ui) = xor(res, this, b, b, b, b)
    fun xor(b: Int, res: Vec4ui) = xor(res, this, b, b, b, b)
    fun xor(b: Vec4ui, res: Vec4ui) = xor(res, this, b.x, b.y, b.z, b.w)

    fun xor(bX: Uint, bY: Uint, bZ: Uint, bW: Uint, res: Vec4ui = Vec4ui()) = xor(res, this, bX, bY, bZ, bW)
    fun xor(bX: Int, bY: Int, bZ: Int, bW: Int, res: Vec4ui = Vec4ui()) = xor(res, this, bX, bY, bZ, bW)

    fun xor_(bX: Uint, bY: Uint, bZ: Uint, bW: Uint) = xor(this, this, bX, bY, bZ, bW)
    fun xor_(bX: Int, bY: Int, bZ: Int, bW: Int) = xor(this, this, bX, bY, bZ, bW)


    infix fun shl(b: Uint) = shl(Vec4ui(), this, b, b, b, b)
    infix fun shl(b: Int) = shl(Vec4ui(), this, b, b, b, b)
    infix fun shl(b: Vec4ui) = shl(Vec4ui(), this, b.x, b.y, b.z, b.w)

    infix fun shl_(b: Uint) = shl(this, this, b, b, b, b)
    infix fun shl_(b: Int) = shl(this, this, b, b, b, b)
    infix fun shl_(b: Vec4ui) = shl(this, this, b.x, b.y, b.z, b.w)

    fun shl(b: Uint, res: Vec4ui) = shl(res, this, b, b, b, b)
    fun shl(b: Int, res: Vec4ui) = shl(res, this, b, b, b, b)
    fun shl(b: Vec4ui, res: Vec4ui) = shl(res, this, b.x, b.y, b.z, b.w)

    fun shl(bX: Uint, bY: Uint, bZ: Uint, bW: Uint, res: Vec4ui = Vec4ui()) = shl(res, this, bX, bY, bZ, bW)
    fun shl(bX: Int, bY: Int, bZ: Int, bW: Int, res: Vec4ui = Vec4ui()) = shl(res, this, bX, bY, bZ, bW)

    fun shl_(bX: Uint, bY: Uint, bZ: Uint, bW: Uint) = shl(this, this, bX, bY, bZ, bW)
    fun shl_(bX: Int, bY: Int, bZ: Int, bW: Int) = shl(this, this, bX, bY, bZ, bW)


    infix fun shr(b: Uint) = shr(Vec4ui(), this, b, b, b, b)
    infix fun shr(b: Int) = shr(Vec4ui(), this, b, b, b, b)
    infix fun shr(b: Vec4ui) = shr(Vec4ui(), this, b.x, b.y, b.z, b.w)

    infix fun shr_(b: Uint) = shr(this, this, b, b, b, b)
    infix fun shr_(b: Int) = shr(this, this, b, b, b, b)
    infix fun shr_(b: Vec4ui) = shr(this, this, b.x, b.y, b.z, b.w)

    fun shr(b: Uint, res: Vec4ui) = shr(res, this, b, b, b, b)
    fun shr(b: Int, res: Vec4ui) = shr(res, this, b, b, b, b)
    fun shr(b: Vec4ui, res: Vec4ui) = shr(res, this, b.x, b.y, b.z, b.w)

    fun shr(bX: Uint, bY: Uint, bZ: Uint, bW: Uint, res: Vec4ui = Vec4ui()) = shr(res, this, bX, bY, bZ, bW)
    fun shr(bX: Int, bY: Int, bZ: Int, bW: Int, res: Vec4ui = Vec4ui()) = shr(res, this, bX, bY, bZ, bW)

    fun shr_(bX: Uint, bY: Uint, bZ: Uint, bW: Uint) = shr(this, this, bX, bY, bZ, bW)
    fun shr_(bX: Int, bY: Int, bZ: Int, bW: Int) = shr(this, this, bX, bY, bZ, bW)


    fun inv(res: Vec4ui = Vec4ui()) = inv(res, this)
    fun inv_() = inv(this, this)


    // -- Generic bitwise operators --

    infix fun and(b: Number) = and(Vec4ui(), this, b.i, b.i, b.i, b.i)
    infix fun and(b: Vec4t<Number>) = and(Vec4ui(), this, b.x.i, b.y.i, b.z.i, b.w.i)

    infix fun and_(b: Number) = and(this, this, b.i, b.i, b.i, b.i)
    infix fun and_(b: Vec4t<Number>) = and(this, this, b.x.i, b.y.i, b.z.i, b.w.i)

    fun and(b: Number, res: Vec4ui) = and(res, this, b.i, b.i, b.i, b.i)
    fun and(b: Vec4t<Number>, res: Vec4ui) = and(res, this, b.x.i, b.y.i, b.z.i, b.w.i)

    fun and(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4ui = Vec4ui()) = and(res, this, bX.i, bY.i, bZ.i, bW.i)

    fun and_(bX: Number, bY: Number, bZ: Number, bW: Number) = and(this, this, bX.i, bY.i, bZ.i, bW.i)


    infix fun or(b: Number) = or(Vec4ui(), this, b.i, b.i, b.i, b.i)
    infix fun or(b: Vec4t<Number>) = or(Vec4ui(), this, b.x.i, b.y.i, b.z.i, b.w.i)

    infix fun or_(b: Number) = or(this, this, b.i, b.i, b.i, b.i)
    infix fun or_(b: Vec4t<Number>) = or(this, this, b.x.i, b.y.i, b.z.i, b.w.i)

    fun or(b: Number, res: Vec4ui) = or(res, this, b.i, b.i, b.i, b.i)
    fun or(b: Vec4t<Number>, res: Vec4ui) = or(res, this, b.x.i, b.y.i, b.z.i, b.w.i)

    fun or(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4ui = Vec4ui()) = or(res, this, bX.i, bY.i, bZ.i, bW.i)

    fun or_(bX: Number, bY: Number, bZ: Number, bW: Number) = or(this, this, bX.i, bY.i, bZ.i, bW.i)


    infix fun xor(b: Number) = xor(Vec4ui(), this, b.i, b.i, b.i, b.i)
    infix fun xor(b: Vec4t<Number>) = xor(Vec4ui(), this, b.x.i, b.y.i, b.z.i, b.w.i)

    infix fun xor_(b: Number) = xor(this, this, b.i, b.i, b.i, b.i)
    infix fun xor_(b: Vec4t<Number>) = xor(this, this, b.x.i, b.y.i, b.z.i, b.w.i)

    fun xor(b: Number, res: Vec4ui) = xor(res, this, b.i, b.i, b.i, b.i)
    fun xor(b: Vec4t<Number>, res: Vec4ui) = xor(res, this, b.x.i, b.y.i, b.z.i, b.w.i)

    fun xor(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4ui = Vec4ui()) = xor(res, this, bX.i, bY.i, bZ.i, bW.i)

    fun xor_(bX: Number, bY: Number, bZ: Number, bW: Number) = xor(this, this, bX.i, bY.i, bZ.i, bW.i)


    infix fun shl(b: Number) = shl(Vec4ui(), this, b.i, b.i, b.i, b.i)
    infix fun shl(b: Vec4t<Number>) = shl(Vec4ui(), this, b.x.i, b.y.i, b.z.i, b.w.i)

    infix fun shl_(b: Number) = shl(this, this, b.i, b.i, b.i, b.i)
    infix fun shl_(b: Vec4t<Number>) = shl(this, this, b.x.i, b.y.i, b.z.i, b.w.i)

    fun shl(b: Number, res: Vec4ui) = shl(res, this, b.i, b.i, b.i, b.i)
    fun shl(b: Vec4t<Number>, res: Vec4ui) = shl(res, this, b.x.i, b.y.i, b.z.i, b.w.i)

    fun shl(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4ui = Vec4ui()) = shl(res, this, bX.i, bY.i, bZ.i, bW.i)

    fun shl_(bX: Number, bY: Number, bZ: Number, bW: Number) = shl(this, this, bX.i, bY.i, bZ.i, bW.i)


    infix fun shr(b: Number) = shr(Vec4ui(), this, b.i, b.i, b.i, b.i)
    infix fun shr(b: Vec4t<Number>) = shr(Vec4ui(), this, b.x.i, b.y.i, b.z.i, b.w.i)

    infix fun shr_(b: Number) = shr(this, this, b.i, b.i, b.i, b.i)
    infix fun shr_(b: Vec4t<Number>) = shr(this, this, b.x.i, b.y.i, b.z.i, b.w.i)

    fun shr(b: Number, res: Vec4ui) = shr(res, this, b.i, b.i, b.i, b.i)
    fun shr(b: Vec4t<Number>, res: Vec4ui) = shr(res, this, b.x.i, b.y.i, b.z.i, b.w.i)

    fun shr(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4ui = Vec4ui()) = shr(res, this, bX.i, bY.i, bZ.i, bW.i)

    fun shr_(bX: Number, bY: Number, bZ: Number, bW: Number) = shr(this, this, bX.i, bY.i, bZ.i, bW.i)
}