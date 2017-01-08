package vec._3

import BYTES
import Uint
import getInt
import getUint
import i
import ui
import vec.Vec2t
import vec.Vec3t
import vec.Vec4t
import vec._3.operators.vec3ui_operators
import vec.bool.Vec2bool
import vec.bool.Vec3bool
import vec.bool.Vec4bool
import java.nio.*

/**
 * Created by elect on 09/10/16.
 */

data class Vec3ui(override var x: Uint, override var y: Uint, override var z: Uint) : Vec3t<Uint>() {

    // -- Explicit basic, conversion other and conversion vector constructors --

    constructor() : this(0)

    constructor(v: Vec2t<out Number>) : this(v.x, v.y, 0)
    constructor(v: Vec3t<out Number>) : this(v.x, v.y, v.z)
    constructor(v: Vec4t<out Number>) : this(v.x, v.y, v.z)

    constructor(v: Vec2bool) : this(v.x.ui, v.y.ui, 0)
    constructor(v: Vec3bool) : this(v.x.ui, v.y.ui, v.z.ui)
    constructor(v: Vec4bool) : this(v.x.ui, v.y.ui, v.z.ui)

    constructor(bytes: ByteArray, index: Int = 0, oneByteOneUint: Boolean = true, bigEndianess: Boolean = true) : this(
            if (oneByteOneUint) bytes[index].ui else bytes.getUint(index, bigEndianess),
            if (oneByteOneUint) bytes[index + 1].ui else bytes.getUint(index + Uint.BYTES, bigEndianess),
            if (oneByteOneUint) bytes[index + 2].ui else bytes.getUint(index + Uint.BYTES * 2, bigEndianess))

    constructor(chars: CharArray, index: Int = 0) : this(chars[index].ui, chars[index + 1].ui, chars[index + 2].ui)
    constructor(shorts: ShortArray, index: Int = 0) : this(shorts[index], shorts[index + 1], shorts[index + 2])
    constructor(ints: IntArray, index: Int = 0) : this(ints[index], ints[index + 1], ints[index + 2])
    constructor(longs: LongArray, index: Int = 0) : this(longs[index], longs[index + 1], longs[index + 2])
    constructor(floats: FloatArray, index: Int = 0) : this(floats[index], floats[index + 1], floats[index + 2])
    constructor(doubles: DoubleArray, index: Int = 0) : this(doubles[index], doubles[index + 1], doubles[index + 2])
    constructor(booleans: BooleanArray, index: Int = 0) : this(booleans[index].ui, booleans[index + 1].ui, booleans[index + 2].ui)

    constructor(numbers: Array<out Number>, index: Int = 0) : this(numbers[index], numbers[index + 1], numbers[index + 2])
    constructor(chars: Array<Char>, index: Int = 0) : this(chars[index].ui, chars[index + 1].ui, chars[index + 2].ui)
    constructor(booleans: Array<Boolean>, index: Int = 0) : this(booleans[index].ui, booleans[index + 1].ui, booleans[index + 2].ui)

    constructor(list: List<Any>, index: Int = 0) : this() {
        Set(list, index)
    }

    constructor(bytes: ByteBuffer, index: Int = bytes.position(), oneByteOneUint: Boolean = true) : this(
            if (oneByteOneUint) bytes[index].ui else bytes.getInt(index).ui,
            if (oneByteOneUint) bytes[index + 1].ui else bytes.getInt(index + Uint.BYTES).ui,
            if (oneByteOneUint) bytes[index + 2].ui else bytes.getInt(index + Uint.BYTES * 2).ui)

    constructor(chars: CharBuffer, index: Int = chars.position()) : this(chars[index].ui, chars[index + 1].ui, chars[index + 2].ui)
    constructor(shorts: ShortBuffer, index: Int = shorts.position()) : this(shorts[index], shorts[index + 1], shorts[index + 2])
    constructor(ints: IntBuffer, index: Int = ints.position()) : this(ints[index], ints[index + 1], ints[index + 2])
    constructor(longs: LongBuffer, index: Int = longs.position()) : this(longs[index], longs[index + 1], longs[index + 2])
    constructor(floats: FloatBuffer, index: Int = floats.position()) : this(floats[index], floats[index + 1], floats[index + 2])
    constructor(doubles: DoubleBuffer, index: Int = doubles.position()) : this(doubles[index], doubles[index + 1], doubles[index + 2])

    constructor(s: Number) : this(s, s, s)
    constructor(x: Number, y: Number, z: Number) : this(x.ui, y.ui, z.ui)


    fun set(bytes: ByteArray, index: Int = 0, oneByteOneUint: Boolean = true, bigEndianess: Boolean = true) {
        x.v = if (oneByteOneUint) bytes[index].i else bytes.getInt(index, bigEndianess)
        y.v = if (oneByteOneUint) bytes[index + 1].i else bytes.getInt(index + Uint.BYTES, bigEndianess)
        z.v = if (oneByteOneUint) bytes[index + 2].i else bytes.getInt(index + Uint.BYTES * 2, bigEndianess)
    }

    fun set(bytes: ByteBuffer, index: Int = bytes.position(), oneByteOneUint: Boolean = true) {
        x.v = if (oneByteOneUint) bytes[index].i else bytes.getInt(index)
        y.v = if (oneByteOneUint) bytes[index + 1].i else bytes.getInt(index + Uint.BYTES)
        z.v = if (oneByteOneUint) bytes[index + 2].i else bytes.getInt(index + Uint.BYTES * 2)
    }


    override fun Set(x: Number, y: Number, z: Number): Vec3ui {
        this.x = x.ui
        this.y = y.ui
        this.z = z.ui
        return this
    }


    // -- Component accesses --

    operator fun get(i: Int) = when (i) {
        0 -> x
        1 -> y
        2 -> z
        else -> throw ArrayIndexOutOfBoundsException()
    }

    operator fun set(i: Int, s: Number) = when (i) {
        0 -> x = s.ui
        1 -> y = s.ui
        2 -> z = s.ui
        else -> throw ArrayIndexOutOfBoundsException()
    }


    companion object : vec3ui_operators


    // -- Unary arithmetic operators --

    operator fun unaryPlus() = this

    // no unaryMinus operator, only signed

    // -- Increment and decrement operators --

    operator fun inc(res: Vec3ui = Vec3ui()) = add(res, this, 1, 1, 1)
    fun inc_() = add(this, this, 1, 1, 1)


    operator fun dec(res: Vec3ui = Vec3ui()) = sub(res, this, 1, 1, 1)
    fun dec_() = sub(this, this, 1, 1, 1)


    // -- Specific binary arithmetic operators --

    operator fun plus(b: Uint) = add(Vec3ui(), this, b, b, b)
    operator fun plus(b: Int) = add(Vec3ui(), this, b, b, b)
    operator fun plus(b: Vec3ui) = add(Vec3ui(), this, b.x, b.y, b.z)

    fun add(bX: Uint, bY: Uint, bZ: Uint, res: Vec3ui = Vec3ui()) = add(res, this, bX, bY, bZ)
    fun add(bX: Int, bY: Int, bZ: Int, res: Vec3ui = Vec3ui()) = add(res, this, bX, bY, bZ)
    fun add(b: Uint, res: Vec3ui = Vec3ui()) = add(res, this, b, b, b)
    fun add(b: Int, res: Vec3ui = Vec3ui()) = add(res, this, b, b, b)
    fun add(b: Vec3ui, res: Vec3ui = Vec3ui()) = add(res, this, b.x, b.y, b.z)

    fun add_(bX: Uint, bY: Uint, bZ: Uint) = add(this, this, bX, bY, bZ)
    fun add_(bX: Int, bY: Int, bZ: Int) = add(this, this, bX, bY, bZ)
    infix fun add_(b: Uint) = add(this, this, b, b, b)
    infix fun add_(b: Int) = add(this, this, b, b, b)
    infix fun add_(b: Vec3ui) = add(this, this, b.x, b.y, b.z)


    operator fun minus(b: Uint) = sub(Vec3ui(), this, b, b, b)
    operator fun minus(b: Int) = sub(Vec3ui(), this, b, b, b)
    operator fun minus(b: Vec3ui) = sub(Vec3ui(), this, b.x, b.y, b.z)

    fun sub(bX: Uint, bY: Uint, bZ: Uint, res: Vec3ui = Vec3ui()) = sub(res, this, bX, bY, bZ)
    fun sub(bX: Int, bY: Int, bZ: Int, res: Vec3ui = Vec3ui()) = sub(res, this, bX, bY, bZ)
    fun sub(b: Uint, res: Vec3ui = Vec3ui()) = sub(res, this, b, b, b)
    fun sub(b: Int, res: Vec3ui = Vec3ui()) = sub(res, this, b, b, b)
    fun sub(b: Vec3ui, res: Vec3ui = Vec3ui()) = sub(res, this, b.x, b.y, b.z)

    fun sub_(bX: Uint, bY: Uint, bZ: Uint) = sub(this, this, bX, bY, bZ)
    fun sub_(bX: Int, bY: Int, bZ: Int) = sub(this, this, bX, bY, bZ)
    infix fun sub_(b: Uint) = sub(this, this, b, b, b)
    infix fun sub_(b: Int) = sub(this, this, b, b, b)
    infix fun sub_(b: Vec3ui) = sub(this, this, b.x, b.y, b.z)


    operator fun times(b: Uint) = mul(Vec3ui(), this, b, b, b)
    operator fun times(b: Int) = mul(Vec3ui(), this, b, b, b)
    operator fun times(b: Vec3ui) = mul(Vec3ui(), this, b.x, b.y, b.z)

    fun mul(bX: Uint, bY: Uint, bZ: Uint, res: Vec3ui = Vec3ui()) = mul(res, this, bX, bY, bZ)
    fun mul(bX: Int, bY: Int, bZ: Int, res: Vec3ui = Vec3ui()) = mul(res, this, bX, bY, bZ)
    fun mul(b: Uint, res: Vec3ui = Vec3ui()) = mul(res, this, b, b, b)
    fun mul(b: Int, res: Vec3ui = Vec3ui()) = mul(res, this, b, b, b)
    fun mul(b: Vec3ui, res: Vec3ui = Vec3ui()) = mul(res, this, b.x, b.y, b.z)

    fun mul_(bX: Uint, bY: Uint, bZ: Uint) = mul(this, this, bX, bY, bZ)
    fun mul_(bX: Int, bY: Int, bZ: Int) = mul(this, this, bX, bY, bZ)
    infix fun mul_(b: Uint) = mul(this, this, b, b, b)
    infix fun mul_(b: Int) = mul(this, this, b, b, b)
    infix fun mul_(b: Vec3ui) = mul(this, this, b.x, b.y, b.z)


    operator fun div(b: Uint) = div(Vec3ui(), this, b, b, b)
    operator fun div(b: Int) = div(Vec3ui(), this, b, b, b)
    operator fun div(b: Vec3ui) = div(Vec3ui(), this, b.x, b.y, b.z)

    fun div(bX: Uint, bY: Uint, bZ: Uint, res: Vec3ui = Vec3ui()) = div(res, this, bX, bY, bZ)
    fun div(bX: Int, bY: Int, bZ: Int, res: Vec3ui = Vec3ui()) = div(res, this, bX, bY, bZ)
    fun div(b: Uint, res: Vec3ui) = div(res, this, b, b, b)
    fun div(b: Int, res: Vec3ui) = div(res, this, b, b, b)
    fun div(b: Vec3ui, res: Vec3ui) = div(res, this, b.x, b.y, b.z)

    fun div_(bX: Uint, bY: Uint, bZ: Uint) = div(this, this, bX, bY, bZ)
    fun div_(bX: Int, bY: Int, bZ: Int) = div(this, this, bX, bY, bZ)
    infix fun div_(b: Uint) = div(this, this, b, b, b)
    infix fun div_(b: Int) = div(this, this, b, b, b)
    infix fun div_(b: Vec3ui) = div(this, this, b.x, b.y, b.z)


    operator fun rem(b: Uint) = rem(Vec3ui(), this, b, b, b)
    operator fun rem(b: Int) = rem(Vec3ui(), this, b, b, b)
    operator fun rem(b: Vec3ui) = rem(Vec3ui(), this, b.x, b.y, b.z)

    fun rem(bX: Uint, bY: Uint, bZ: Uint, res: Vec3ui = Vec3ui()) = rem(res, this, bX, bY, bZ)
    fun rem(bX: Int, bY: Int, bZ: Int, res: Vec3ui = Vec3ui()) = rem(res, this, bX, bY, bZ)
    fun rem(b: Uint, res: Vec3ui) = rem(res, this, b, b, b)
    fun rem(b: Int, res: Vec3ui) = rem(res, this, b, b, b)
    fun rem(b: Vec3ui, res: Vec3ui) = rem(res, this, b.x, b.y, b.z)

    fun rem_(bX: Uint, bY: Uint, bZ: Uint) = rem(this, this, bX, bY, bZ)
    fun rem_(bX: Int, bY: Int, bZ: Int) = rem(this, this, bX, bY, bZ)
    infix fun rem_(b: Uint) = rem(this, this, b, b, b)
    infix fun rem_(b: Int) = rem(this, this, b, b, b)
    infix fun rem_(b: Vec3ui) = rem(this, this, b.x, b.y, b.z)


    // -- Generic binary arithmetic operators --

    operator fun plus(b: Number) = add(Vec3ui(), this, b.i, b.i, b.i)
    operator fun plus(b: Vec3t<Number>) = add(Vec3ui(), this, b.x.i, b.y.i, b.z.i)

    fun add(bX: Number, bY: Number, bZ: Number, res: Vec3ui = Vec3ui()) = add(res, this, bX.i, bY.i, bZ.i)
    fun add(b: Number, res: Vec3ui = Vec3ui()) = add(res, this, b.i, b.i, b.i)
    fun add(b: Vec3t<Number>, res: Vec3ui = Vec3ui()) = add(res, this, b.x.i, b.y.i, b.z.i)

    fun add_(bX: Number, bY: Number, bZ: Number) = add(this, this, bX.i, bY.i, bZ.i)
    infix fun add_(b: Number) = add(this, this, b.i, b.i, b.i)
    infix fun add_(b: Vec3t<Number>) = add(this, this, b.x.i, b.y.i, b.z.i)


    operator fun minus(b: Number) = sub(Vec3ui(), this, b.i, b.i, b.i)
    operator fun minus(b: Vec3t<Number>) = sub(Vec3ui(), this, b.x.i, b.y.i, b.z.i)

    fun sub(bX: Number, bY: Number, bZ: Number, res: Vec3ui = Vec3ui()) = sub(res, this, bX.i, bY.i, bZ.i)
    fun sub(b: Number, res: Vec3ui = Vec3ui()) = sub(res, this, b.i, b.i, b.i)
    fun sub(b: Vec3t<Number>, res: Vec3ui = Vec3ui()) = sub(res, this, b.x.i, b.y.i, b.z.i)

    fun sub_(bX: Number, bY: Number, bZ: Number) = sub(this, this, bX.i, bY.i, bZ.i)
    infix fun sub_(b: Number) = sub(this, this, b.i, b.i, b.i)
    infix fun sub_(b: Vec3t<Number>) = sub(this, this, b.x.i, b.y.i, b.z.i)


    operator fun times(b: Number) = mul(Vec3ui(), this, b.i, b.i, b.i)
    operator fun times(b: Vec3t<Number>) = mul(Vec3ui(), this, b.x.i, b.y.i, b.z.i)

    fun mul(bX: Number, bY: Number, bZ: Number, res: Vec3ui = Vec3ui()) = mul(res, this, bX.i, bY.i, bZ.i)
    fun mul(b: Number, res: Vec3ui = Vec3ui()) = mul(res, this, b.i, b.i, b.i)
    fun mul(b: Vec3t<Number>, res: Vec3ui = Vec3ui()) = mul(res, this, b.x.i, b.y.i, b.z.i)

    fun mul_(bX: Number, bY: Number, bZ: Number) = mul(this, this, bX.i, bY.i, bZ.i)
    infix fun mul_(b: Number) = mul(this, this, b.i, b.i, b.i)
    infix fun mul_(b: Vec3t<Number>) = mul(this, this, b.x.i, b.y.i, b.z.i)


    operator fun div(b: Number) = div(Vec3ui(), this, b.i, b.i, b.i)
    operator fun div(b: Vec3t<Number>) = div(Vec3ui(), this, b.x.i, b.y.i, b.z.i)

    fun div(bX: Number, bY: Number, bZ: Number, res: Vec3ui = Vec3ui()) = div(res, this, bX.i, bY.i, bZ.i)
    fun div(b: Number, res: Vec3ui) = div(res, this, b.i, b.i, b.i)
    fun div(b: Vec3t<Number>, res: Vec3ui) = div(res, this, b.x.i, b.y.i, b.z.i)

    fun div_(bX: Number, bY: Number, bZ: Number) = div(this, this, bX.i, bY.i, bZ.i)
    infix fun div_(b: Number) = div(this, this, b.i, b.i, b.i)
    infix fun div_(b: Vec3t<Number>) = div(this, this, b.x.i, b.y.i, b.z.i)


    operator fun rem(b: Number) = rem(Vec3ui(), this, b.i, b.i, b.i)
    operator fun rem(b: Vec3t<Number>) = rem(Vec3ui(), this, b.x.i, b.y.i, b.z.i)

    fun rem(bX: Number, bY: Number, bZ: Number, res: Vec3ui = Vec3ui()) = rem(res, this, bX.i, bY.i, bZ.i)
    fun rem(b: Number, res: Vec3ui) = rem(res, this, b.i, b.i, b.i)
    fun rem(b: Vec3t<Number>, res: Vec3ui) = rem(res, this, b.x.i, b.y.i, b.z.i)

    fun rem_(bX: Number, bY: Number, bZ: Number) = rem(this, this, bX.i, bY.i, bZ.i)
    infix fun rem_(b: Number) = rem(this, this, b.i, b.i, b.i)
    infix fun rem_(b: Vec3t<Number>) = rem(this, this, b.x.i, b.y.i, b.z.i)


    // -- Specific bitwise operators --

    infix fun and(b: Uint) = and(Vec3ui(), this, b, b, b)
    infix fun and(b: Int) = and(Vec3ui(), this, b, b, b)
    infix fun and(b: Vec3ui) = and(Vec3ui(), this, b.x, b.y, b.z)

    infix fun and_(b: Uint) = and(this, this, b, b, b)
    infix fun and_(b: Int) = and(this, this, b, b, b)
    infix fun and_(b: Vec3ui) = and(this, this, b.x, b.y, b.z)

    fun and(b: Uint, res: Vec3ui) = and(res, this, b, b, b)
    fun and(b: Int, res: Vec3ui) = and(res, this, b, b, b)
    fun and(b: Vec3ui, res: Vec3ui) = and(res, this, b.x, b.y, b.z)

    fun and(bX: Uint, bY: Uint, bZ: Uint, res: Vec3ui = Vec3ui()) = and(res, this, bX, bY, bZ)
    fun and(bX: Int, bY: Int, bZ: Int, res: Vec3ui = Vec3ui()) = and(res, this, bX, bY, bZ)

    fun and_(bX: Uint, bY: Uint, bZ: Uint) = and(this, this, bX, bY, bZ)
    fun and_(bX: Int, bY: Int, bZ: Int) = and(this, this, bX, bY, bZ)


    infix fun or(b: Uint) = or(Vec3ui(), this, b, b, b)
    infix fun or(b: Int) = or(Vec3ui(), this, b, b, b)
    infix fun or(b: Vec3ui) = or(Vec3ui(), this, b.x, b.y, b.z)

    infix fun or_(b: Uint) = or(this, this, b, b, b)
    infix fun or_(b: Int) = or(this, this, b, b, b)
    infix fun or_(b: Vec3ui) = or(this, this, b.x, b.y, b.z)

    fun or(b: Uint, res: Vec3ui) = or(res, this, b, b, b)
    fun or(b: Int, res: Vec3ui) = or(res, this, b, b, b)
    fun or(b: Vec3ui, res: Vec3ui) = or(res, this, b.x, b.y, b.z)

    fun or(bX: Uint, bY: Uint, bZ: Uint, res: Vec3ui = Vec3ui()) = or(res, this, bX, bY, bZ)
    fun or(bX: Int, bY: Int, bZ: Int, res: Vec3ui = Vec3ui()) = or(res, this, bX, bY, bZ)

    fun or_(bX: Uint, bY: Uint, bZ: Uint) = or(this, this, bX, bY, bZ)
    fun or_(bX: Int, bY: Int, bZ: Int) = or(this, this, bX, bY, bZ)


    infix fun xor(b: Uint) = xor(Vec3ui(), this, b, b, b)
    infix fun xor(b: Int) = xor(Vec3ui(), this, b, b, b)
    infix fun xor(b: Vec3ui) = xor(Vec3ui(), this, b.x, b.y, b.z)

    infix fun xor_(b: Uint) = xor(this, this, b, b, b)
    infix fun xor_(b: Int) = xor(this, this, b, b, b)
    infix fun xor_(b: Vec3ui) = xor(this, this, b.x, b.y, b.z)

    fun xor(b: Uint, res: Vec3ui) = xor(res, this, b, b, b)
    fun xor(b: Int, res: Vec3ui) = xor(res, this, b, b, b)
    fun xor(b: Vec3ui, res: Vec3ui) = xor(res, this, b.x, b.y, b.z)

    fun xor(bX: Uint, bY: Uint, bZ: Uint, res: Vec3ui = Vec3ui()) = xor(res, this, bX, bY, bZ)
    fun xor(bX: Int, bY: Int, bZ: Int, res: Vec3ui = Vec3ui()) = xor(res, this, bX, bY, bZ)

    fun xor_(bX: Uint, bY: Uint, bZ: Uint) = xor(this, this, bX, bY, bZ)
    fun xor_(bX: Int, bY: Int, bZ: Int) = xor(this, this, bX, bY, bZ)


    infix fun shl(b: Uint) = shl(Vec3ui(), this, b, b, b)
    infix fun shl(b: Int) = shl(Vec3ui(), this, b, b, b)
    infix fun shl(b: Vec3ui) = shl(Vec3ui(), this, b.x, b.y, b.z)

    infix fun shl_(b: Uint) = shl(this, this, b, b, b)
    infix fun shl_(b: Int) = shl(this, this, b, b, b)
    infix fun shl_(b: Vec3ui) = shl(this, this, b.x, b.y, b.z)

    fun shl(b: Uint, res: Vec3ui) = shl(res, this, b, b, b)
    fun shl(b: Int, res: Vec3ui) = shl(res, this, b, b, b)
    fun shl(b: Vec3ui, res: Vec3ui) = shl(res, this, b.x, b.y, b.z)

    fun shl(bX: Uint, bY: Uint, bZ: Uint, res: Vec3ui = Vec3ui()) = shl(res, this, bX, bY, bZ)
    fun shl(bX: Int, bY: Int, bZ: Int, res: Vec3ui = Vec3ui()) = shl(res, this, bX, bY, bZ)

    fun shl_(bX: Uint, bY: Uint, bZ: Uint) = shl(this, this, bX, bY, bZ)
    fun shl_(bX: Int, bY: Int, bZ: Int) = shl(this, this, bX, bY, bZ)


    infix fun shr(b: Uint) = shr(Vec3ui(), this, b, b, b)
    infix fun shr(b: Int) = shr(Vec3ui(), this, b, b, b)
    infix fun shr(b: Vec3ui) = shr(Vec3ui(), this, b.x, b.y, b.z)

    infix fun shr_(b: Uint) = shr(this, this, b, b, b)
    infix fun shr_(b: Int) = shr(this, this, b, b, b)
    infix fun shr_(b: Vec3ui) = shr(this, this, b.x, b.y, b.z)

    fun shr(b: Uint, res: Vec3ui) = shr(res, this, b, b, b)
    fun shr(b: Int, res: Vec3ui) = shr(res, this, b, b, b)
    fun shr(b: Vec3ui, res: Vec3ui) = shr(res, this, b.x, b.y, b.z)

    fun shr(bX: Uint, bY: Uint, bZ: Uint, res: Vec3ui = Vec3ui()) = shr(res, this, bX, bY, bZ)
    fun shr(bX: Int, bY: Int, bZ: Int, res: Vec3ui = Vec3ui()) = shr(res, this, bX, bY, bZ)

    fun shr_(bX: Uint, bY: Uint, bZ: Uint) = shr(this, this, bX, bY, bZ)
    fun shr_(bX: Int, bY: Int, bZ: Int) = shr(this, this, bX, bY, bZ)


    fun inv(res: Vec3ui = Vec3ui()) = inv(res, this)
    fun inv_() = inv(this, this)


    // -- Generic bitwise operators --

    infix fun and(b: Number) = and(Vec3ui(), this, b.i, b.i, b.i)
    infix fun and(b: Vec3t<Number>) = and(Vec3ui(), this, b.x.i, b.y.i, b.z.i)

    infix fun and_(b: Number) = and(this, this, b.i, b.i, b.i)
    infix fun and_(b: Vec3t<Number>) = and(this, this, b.x.i, b.y.i, b.z.i)

    fun and(b: Number, res: Vec3ui) = and(res, this, b.i, b.i, b.i)
    fun and(b: Vec3t<Number>, res: Vec3ui) = and(res, this, b.x.i, b.y.i, b.z.i)

    fun and(bX: Number, bY: Number, bZ: Number, res: Vec3ui = Vec3ui()) = and(res, this, bX.i, bY.i, bZ.i)

    fun and_(bX: Number, bY: Number, bZ: Number) = and(this, this, bX.i, bY.i, bZ.i)


    infix fun or(b: Number) = or(Vec3ui(), this, b.i, b.i, b.i)
    infix fun or(b: Vec3t<Number>) = or(Vec3ui(), this, b.x.i, b.y.i, b.z.i)

    infix fun or_(b: Number) = or(this, this, b.i, b.i, b.i)
    infix fun or_(b: Vec3t<Number>) = or(this, this, b.x.i, b.y.i, b.z.i)

    fun or(b: Number, res: Vec3ui) = or(res, this, b.i, b.i, b.i)
    fun or(b: Vec3t<Number>, res: Vec3ui) = or(res, this, b.x.i, b.y.i, b.z.i)

    fun or(bX: Number, bY: Number, bZ: Number, res: Vec3ui = Vec3ui()) = or(res, this, bX.i, bY.i, bZ.i)

    fun or_(bX: Number, bY: Number, bZ: Number) = or(this, this, bX.i, bY.i, bZ.i)


    infix fun xor(b: Number) = xor(Vec3ui(), this, b.i, b.i, b.i)
    infix fun xor(b: Vec3t<Number>) = xor(Vec3ui(), this, b.x.i, b.y.i, b.z.i)

    infix fun xor_(b: Number) = xor(this, this, b.i, b.i, b.i)
    infix fun xor_(b: Vec3t<Number>) = xor(this, this, b.x.i, b.y.i, b.z.i)

    fun xor(b: Number, res: Vec3ui) = xor(res, this, b.i, b.i, b.i)
    fun xor(b: Vec3t<Number>, res: Vec3ui) = xor(res, this, b.x.i, b.y.i, b.z.i)

    fun xor(bX: Number, bY: Number, bZ: Number, res: Vec3ui = Vec3ui()) = xor(res, this, bX.i, bY.i, bZ.i)

    fun xor_(bX: Number, bY: Number, bZ: Number) = xor(this, this, bX.i, bY.i, bZ.i)


    infix fun shl(b: Number) = shl(Vec3ui(), this, b.i, b.i, b.i)
    infix fun shl(b: Vec3t<Number>) = shl(Vec3ui(), this, b.x.i, b.y.i, b.z.i)

    infix fun shl_(b: Number) = shl(this, this, b.i, b.i, b.i)
    infix fun shl_(b: Vec3t<Number>) = shl(this, this, b.x.i, b.y.i, b.z.i)

    fun shl(b: Number, res: Vec3ui) = shl(res, this, b.i, b.i, b.i)
    fun shl(b: Vec3t<Number>, res: Vec3ui) = shl(res, this, b.x.i, b.y.i, b.z.i)

    fun shl(bX: Number, bY: Number, bZ: Number, res: Vec3ui = Vec3ui()) = shl(res, this, bX.i, bY.i, bZ.i)

    fun shl_(bX: Number, bY: Number, bZ: Number) = shl(this, this, bX.i, bY.i, bZ.i)


    infix fun shr(b: Number) = shr(Vec3ui(), this, b.i, b.i, b.i)
    infix fun shr(b: Vec3t<Number>) = shr(Vec3ui(), this, b.x.i, b.y.i, b.z.i)

    infix fun shr_(b: Number) = shr(this, this, b.i, b.i, b.i)
    infix fun shr_(b: Vec3t<Number>) = shr(this, this, b.x.i, b.y.i, b.z.i)

    fun shr(b: Number, res: Vec3ui) = shr(res, this, b.i, b.i, b.i)
    fun shr(b: Vec3t<Number>, res: Vec3ui) = shr(res, this, b.x.i, b.y.i, b.z.i)

    fun shr(bX: Number, bY: Number, bZ: Number, res: Vec3ui = Vec3ui()) = shr(res, this, bX.i, bY.i, bZ.i)

    fun shr_(bX: Number, bY: Number, bZ: Number) = shr(this, this, bX.i, bY.i, bZ.i)
}