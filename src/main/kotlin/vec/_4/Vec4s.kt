package vec._4

import main.BYTES
import main.getShort
import main.s
import vec.Vec2t
import vec.Vec3t
import vec.Vec4t
import vec._4.operators.vec4s_operators
import vec.bool.Vec2bool
import vec.bool.Vec3bool
import vec.bool.Vec4bool
import java.nio.*

/**
 * Created by elect on 09/10/16.
 */

data class Vec4s(override var x: Short, override var y: Short, override var z: Short, override var w: Short) : Vec4t<Short>() {

    // -- Explicit basic, conversion other main.and conversion vector constructors --

    constructor() : this(0)

    constructor(v: Vec2t<out Number>) : this(v.x, v.y, 0, 1)
    constructor(v: Vec3t<out Number>) : this(v.x, v.y, v.z, 1)
    constructor(v: Vec4t<out Number>) : this(v.x, v.y, v.z, v.w)

    constructor(v: Vec2bool) : this(v.x.s, v.y.s, 0, 1)
    constructor(v: Vec3bool) : this(v.x.s, v.y.s, v.z.s, 1)
    constructor(v: Vec4bool) : this(v.x.s, v.y.s, v.z.s, v.w.s)

    constructor(bytes: ByteArray, index: Int = 0, oneByteOneShort: Boolean = true, bigEndianess: Boolean = true) : this(
            if (oneByteOneShort) bytes[index].s else bytes.getShort(index, bigEndianess),
            if (oneByteOneShort) bytes[index + 1].s else bytes.getShort(index + Short.BYTES, bigEndianess),
            if (oneByteOneShort) bytes[index + 2].s else bytes.getShort(index + Short.BYTES * 2, bigEndianess),
            if (oneByteOneShort) bytes[index + 3].s else bytes.getShort(index + Short.BYTES * 3, bigEndianess))

    constructor(chars: CharArray, index: Int = 0) : this(chars[index].s, chars[index + 1].s, chars[index + 2].s, chars[index + 3].s)
    constructor(shorts: ShortArray, index: Int = 0) : this(shorts[index], shorts[index + 1], shorts[index + 2], shorts[index + 3])
    constructor(ints: IntArray, index: Int = 0) : this(ints[index], ints[index + 1], ints[index + 2], ints[index + 3])
    constructor(longs: LongArray, index: Int = 0) : this(longs[index], longs[index + 1], longs[index + 2], longs[index + 3])
    constructor(floats: FloatArray, index: Int = 0) : this(floats[index], floats[index + 1], floats[index + 2], floats[index + 3])
    constructor(doubles: DoubleArray, index: Int = 0) : this(doubles[index], doubles[index + 1], doubles[index + 2], doubles[index + 3])
    constructor(booleans: BooleanArray, index: Int = 0) : this(booleans[index].s, booleans[index + 1].s, booleans[index + 2].s, booleans[index + 3].s)

    constructor(numbers: Array<out Number>, index: Int = 0) : this(numbers[index], numbers[index + 1], numbers[index + 2], numbers[index + 3])
    constructor(chars: Array<Char>, index: Int = 0) : this(chars[index].s, chars[index + 1].s, chars[index + 2].s, chars[index + 3].s)
    constructor(booleans: Array<Boolean>, index: Int = 0) : this(booleans[index].s, booleans[index + 1].s, booleans[index + 2].s, booleans[index + 3].s)

    constructor(list: List<Any>, index: Int = 0) : this() {
        put(list, index)
    }

    constructor(bytes: ByteBuffer, index: Int = bytes.position(), oneByteOneShort: Boolean = true) : this(
            if (oneByteOneShort) bytes[index].s else bytes.getShort(index),
            if (oneByteOneShort) bytes[index + 1].s else bytes.getShort(index + Short.BYTES),
            if (oneByteOneShort) bytes[index + 2].s else bytes.getShort(index + Short.BYTES * 2),
            if (oneByteOneShort) bytes[index + 3].s else bytes.getShort(index + Short.BYTES * 3))

    constructor(chars: CharBuffer, index: Int = chars.position()) : this(chars[index].s, chars[index + 1].s, chars[index + 2].s, chars[index + 3].s)
    constructor(shorts: ShortBuffer, index: Int = shorts.position()) : this(shorts[index], shorts[index + 1], shorts[index + 2], shorts[index + 3])
    constructor(ints: IntBuffer, index: Int = ints.position()) : this(ints[index], ints[index + 1], ints[index + 2], ints[index + 3])
    constructor(longs: LongBuffer, index: Int = longs.position()) : this(longs[index], longs[index + 1], longs[index + 2], longs[index + 3])
    constructor(floats: FloatBuffer, index: Int = floats.position()) : this(floats[index], floats[index + 1], floats[index + 2], floats[index + 3])
    constructor(doubles: DoubleBuffer, index: Int = doubles.position()) : this(doubles[index], doubles[index + 1], doubles[index + 2], doubles[index + 3])

    constructor(s: Number) : this(s, s, s, s)
    constructor(x: Number, y: Number, z: Number, w: Number) : this(x.s, y.s, z.s, w.s)


    fun set(bytes: ByteArray, index: Int = 0, oneByteOneShort: Boolean = true, bigEndianess: Boolean = true) {
        x = if (oneByteOneShort) bytes[index].s else bytes.getShort(index, bigEndianess)
        y = if (oneByteOneShort) bytes[index + 1].s else bytes.getShort(index + Short.BYTES, bigEndianess)
        z = if (oneByteOneShort) bytes[index + 2].s else bytes.getShort(index + Short.BYTES * 2, bigEndianess)
        w = if (oneByteOneShort) bytes[index + 3].s else bytes.getShort(index + Short.BYTES * 3, bigEndianess)
    }

    fun set(bytes: ByteBuffer, index: Int = bytes.position(), oneByteOneShort: Boolean = true) {
        x = if (oneByteOneShort) bytes[index].s else bytes.getShort(index)
        y = if (oneByteOneShort) bytes[index + 1].s else bytes.getShort(index + Short.BYTES)
        z = if (oneByteOneShort) bytes[index + 2].s else bytes.getShort(index + Short.BYTES * 2)
        w = if (oneByteOneShort) bytes[index + 3].s else bytes.getShort(index + Short.BYTES * 3)
    }


    override fun put(x: Number, y: Number, z: Number, w: Number): Vec4s {
        this.x = x.s
        this.y = y.s
        this.z = z.s
        this.w = w.s
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
        0 -> x = s.s
        1 -> y = s.s
        2 -> z = s.s
        3 -> w = s.s
        else -> throw ArrayIndexOutOfBoundsException()
    }


    companion object : vec4s_operators {
        @JvmField val SIZE = 4 * Short.BYTES
    }


    // -- Unary arithmetic operators --

    operator fun unaryPlus() = this

    operator fun unaryMinus() = Vec4s(-x.s, -y.s, -z.s, -w.s) // TODO other .main.getS


    // -- Increment main.and decrement operators --

    operator fun inc(res: Vec4s = Vec4s()) = add(res, this, 1, 1, 1, 1)
    fun inc_() = add(this, this, 1, 1, 1, 1)


    operator fun dec(res: Vec4s = Vec4s()) = sub(res, this, 1, 1, 1, 1)
    fun dec_() = sub(this, this, 1, 1, 1, 1)


    // -- Specific binary arithmetic operators --

    operator fun plus(b: Short) = add(Vec4s(), this, b, b, b, b)
    operator fun plus(b: Int) = add(Vec4s(), this, b, b, b, b)
    operator fun plus(b: Vec4s) = add(Vec4s(), this, b.x, b.y, b.z, b.w)

    fun add(bX: Short, bY: Short, bZ: Short, bW: Short, res: Vec4s = Vec4s()) = add(res, this, bX, bY, bZ, bW)
    fun add(bX: Int, bY: Int, bZ: Int, bW: Int, res: Vec4s = Vec4s()) = add(res, this, bX, bY, bZ, bW)
    fun add(b: Short, res: Vec4s = Vec4s()) = add(res, this, b, b, b, b)
    fun add(b: Int, res: Vec4s = Vec4s()) = add(res, this, b, b, b, b)
    fun add(b: Vec4s, res: Vec4s = Vec4s()) = add(res, this, b.x, b.y, b.z, b.w)

    fun add_(bX: Short, bY: Short, bZ: Short, bW: Short) = add(this, this, bX, bY, bZ, bW)
    fun add_(bX: Int, bY: Int, bZ: Int, bW: Int) = add(this, this, bX, bY, bZ, bW)
    infix fun add_(b: Short) = add(this, this, b, b, b, b)
    infix fun add_(b: Int) = add(this, this, b, b, b, b)
    infix fun add_(b: Vec4s) = add(this, this, b.x, b.y, b.z, b.w)


    operator fun minus(b: Short) = sub(Vec4s(), this, b, b, b, b)
    operator fun minus(b: Int) = sub(Vec4s(), this, b, b, b, b)
    operator fun minus(b: Vec4s) = sub(Vec4s(), this, b.x, b.y, b.z, b.w)

    fun sub(bX: Short, bY: Short, bZ: Short, bW: Short, res: Vec4s = Vec4s()) = sub(res, this, bX, bY, bZ, bW)
    fun sub(bX: Int, bY: Int, bZ: Int, bW: Int, res: Vec4s = Vec4s()) = sub(res, this, bX, bY, bZ, bW)
    fun sub(b: Short, res: Vec4s = Vec4s()) = sub(res, this, b, b, b, b)
    fun sub(b: Int, res: Vec4s = Vec4s()) = sub(res, this, b, b, b, b)
    fun sub(b: Vec4s, res: Vec4s = Vec4s()) = sub(res, this, b.x, b.y, b.z, b.w)

    fun sub_(bX: Short, bY: Short, bZ: Short, bW: Short) = sub(this, this, bX, bY, bZ, bW)
    fun sub_(bX: Int, bY: Int, bZ: Int, bW: Int) = sub(this, this, bX, bY, bZ, bW)
    infix fun sub_(b: Short) = sub(this, this, b, b, b, b)
    infix fun sub_(b: Int) = sub(this, this, b, b, b, b)
    infix fun sub_(b: Vec4s) = sub(this, this, b.x, b.y, b.z, b.w)


    operator fun times(b: Short) = mul(Vec4s(), this, b, b, b, b)
    operator fun times(b: Int) = mul(Vec4s(), this, b, b, b, b)
    operator fun times(b: Vec4s) = mul(Vec4s(), this, b.x, b.y, b.z, b.w)

    fun mul(bX: Short, bY: Short, bZ: Short, bW: Short, res: Vec4s = Vec4s()) = mul(res, this, bX, bY, bZ, bW)
    fun mul(bX: Int, bY: Int, bZ: Int, bW: Int, res: Vec4s = Vec4s()) = mul(res, this, bX, bY, bZ, bW)
    fun mul(b: Short, res: Vec4s = Vec4s()) = mul(res, this, b, b, b, b)
    fun mul(b: Int, res: Vec4s = Vec4s()) = mul(res, this, b, b, b, b)
    fun mul(b: Vec4s, res: Vec4s = Vec4s()) = mul(res, this, b.x, b.y, b.z, b.w)

    fun mul_(bX: Short, bY: Short, bZ: Short, bW: Short) = mul(this, this, bX, bY, bZ, bW)
    fun mul_(bX: Int, bY: Int, bZ: Int, bW: Int) = mul(this, this, bX, bY, bZ, bW)
    infix fun mul_(b: Short) = mul(this, this, b, b, b, b)
    infix fun mul_(b: Int) = mul(this, this, b, b, b, b)
    infix fun mul_(b: Vec4s) = mul(this, this, b.x, b.y, b.z, b.w)


    operator fun div(b: Short) = div(Vec4s(), this, b, b, b, b)
    operator fun div(b: Int) = div(Vec4s(), this, b, b, b, b)
    operator fun div(b: Vec4s) = div(Vec4s(), this, b.x, b.y, b.z, b.w)

    fun div(bX: Short, bY: Short, bZ: Short, bW: Short, res: Vec4s = Vec4s()) = div(res, this, bX, bY, bZ, bW)
    fun div(bX: Int, bY: Int, bZ: Int, bW: Int, res: Vec4s = Vec4s()) = div(res, this, bX, bY, bZ, bW)
    fun div(b: Short, res: Vec4s) = div(res, this, b, b, b, b)
    fun div(b: Int, res: Vec4s) = div(res, this, b, b, b, b)
    fun div(b: Vec4s, res: Vec4s) = div(res, this, b.x, b.y, b.z, b.w)

    fun div_(bX: Short, bY: Short, bZ: Short, bW: Short) = div(this, this, bX, bY, bZ, bW)
    fun div_(bX: Int, bY: Int, bZ: Int, bW: Int) = div(this, this, bX, bY, bZ, bW)
    infix fun div_(b: Short) = div(this, this, b, b, b, b)
    infix fun div_(b: Int) = div(this, this, b, b, b, b)
    infix fun div_(b: Vec4s) = div(this, this, b.x, b.y, b.z, b.w)


    operator fun rem(b: Short) = rem(Vec4s(), this, b, b, b, b)
    operator fun rem(b: Int) = rem(Vec4s(), this, b, b, b, b)
    operator fun rem(b: Vec4s) = rem(Vec4s(), this, b.x, b.y, b.z, b.w)

    fun rem(bX: Short, bY: Short, bZ: Short, bW: Short, res: Vec4s = Vec4s()) = rem(res, this, bX, bY, bZ, bW)
    fun rem(bX: Int, bY: Int, bZ: Int, bW: Int, res: Vec4s = Vec4s()) = rem(res, this, bX, bY, bZ, bW)
    fun rem(b: Short, res: Vec4s) = rem(res, this, b, b, b, b)
    fun rem(b: Int, res: Vec4s) = rem(res, this, b, b, b, b)
    fun rem(b: Vec4s, res: Vec4s) = rem(res, this, b.x, b.y, b.z, b.w)

    fun rem_(bX: Short, bY: Short, bZ: Short, bW: Short) = rem(this, this, bX, bY, bZ, bW)
    fun rem_(bX: Int, bY: Int, bZ: Int, bW: Int) = rem(this, this, bX, bY, bZ, bW)
    infix fun rem_(b: Short) = rem(this, this, b, b, b, b)
    infix fun rem_(b: Int) = rem(this, this, b, b, b, b)
    infix fun rem_(b: Vec4s) = rem(this, this, b.x, b.y, b.z, b.w)


    // -- Generic binary arithmetic operators --

    operator fun plus(b: Number) = add(Vec4s(), this, b.s, b.s, b.s, b.s)
    operator fun plus(b: Vec4t<Number>) = add(Vec4s(), this, b.x.s, b.y.s, b.z.s, b.w.s)

    fun add(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4s = Vec4s()) = add(res, this, bX.s, bY.s, bZ.s, bW.s)
    fun add(b: Number, res: Vec4s = Vec4s()) = add(res, this, b.s, b.s, b.s, b.s)
    fun add(b: Vec4t<Number>, res: Vec4s = Vec4s()) = add(res, this, b.x.s, b.y.s, b.z.s, b.w.s)

    fun add_(bX: Number, bY: Number, bZ: Number, bW: Number) = add(this, this, bX.s, bY.s, bZ.s, bW.s)
    infix fun add_(b: Number) = add(this, this, b.s, b.s, b.s, b.s)
    infix fun add_(b: Vec4t<Number>) = add(this, this, b.x.s, b.y.s, b.z.s, b.w.s)


    operator fun minus(b: Number) = sub(Vec4s(), this, b.s, b.s, b.s, b.s)
    operator fun minus(b: Vec4t<Number>) = sub(Vec4s(), this, b.x.s, b.y.s, b.z.s, b.w.s)

    fun sub(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4s = Vec4s()) = sub(res, this, bX.s, bY.s, bZ.s, bW.s)
    fun sub(b: Number, res: Vec4s = Vec4s()) = sub(res, this, b.s, b.s, b.s, b.s)
    fun sub(b: Vec4t<Number>, res: Vec4s = Vec4s()) = sub(res, this, b.x.s, b.y.s, b.z.s, b.w.s)

    fun sub_(bX: Number, bY: Number, bZ: Number, bW: Number) = sub(this, this, bX.s, bY.s, bZ.s, bW.s)
    infix fun sub_(b: Number) = sub(this, this, b.s, b.s, b.s, b.s)
    infix fun sub_(b: Vec4t<Number>) = sub(this, this, b.x.s, b.y.s, b.z.s, b.w.s)


    operator fun times(b: Number) = mul(Vec4s(), this, b.s, b.s, b.s, b.s)
    operator fun times(b: Vec4t<Number>) = mul(Vec4s(), this, b.x.s, b.y.s, b.z.s, b.w.s)

    fun mul(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4s = Vec4s()) = mul(res, this, bX.s, bY.s, bZ.s, bW.s)
    fun mul(b: Number, res: Vec4s = Vec4s()) = mul(res, this, b.s, b.s, b.s, b.s)
    fun mul(b: Vec4t<Number>, res: Vec4s = Vec4s()) = mul(res, this, b.x.s, b.y.s, b.z.s, b.w.s)

    fun mul_(bX: Number, bY: Number, bZ: Number, bW: Number) = mul(this, this, bX.s, bY.s, bZ.s, bW.s)
    infix fun mul_(b: Number) = mul(this, this, b.s, b.s, b.s, b.s)
    infix fun mul_(b: Vec4t<Number>) = mul(this, this, b.x.s, b.y.s, b.z.s, b.w.s)


    operator fun div(b: Number) = div(Vec4s(), this, b.s, b.s, b.s, b.s)
    operator fun div(b: Vec4t<Number>) = div(Vec4s(), this, b.x.s, b.y.s, b.z.s, b.w.s)

    fun div(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4s = Vec4s()) = div(res, this, bX.s, bY.s, bZ.s, bW.s)
    fun div(b: Number, res: Vec4s) = div(res, this, b.s, b.s, b.s, b.s)
    fun div(b: Vec4t<Number>, res: Vec4s) = div(res, this, b.x.s, b.y.s, b.z.s, b.w.s)

    fun div_(bX: Number, bY: Number, bZ: Number, bW: Number) = div(this, this, bX.s, bY.s, bZ.s, bW.s)
    infix fun div_(b: Number) = div(this, this, b.s, b.s, b.s, b.s)
    infix fun div_(b: Vec4t<Number>) = div(this, this, b.x.s, b.y.s, b.z.s, b.w.s)


    operator fun rem(b: Number) = rem(Vec4s(), this, b.s, b.s, b.s, b.s)
    operator fun rem(b: Vec4t<Number>) = rem(Vec4s(), this, b.x.s, b.y.s, b.z.s, b.w.s)

    fun rem(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4s = Vec4s()) = rem(res, this, bX.s, bY.s, bZ.s, bW.s)
    fun rem(b: Number, res: Vec4s) = rem(res, this, b.s, b.s, b.s, b.s)
    fun rem(b: Vec4t<Number>, res: Vec4s) = rem(res, this, b.x.s, b.y.s, b.z.s, b.w.s)

    fun rem_(bX: Number, bY: Number, bZ: Number, bW: Number) = rem(this, this, bX.s, bY.s, bZ.s, bW.s)
    infix fun rem_(b: Number) = rem(this, this, b.s, b.s, b.s, b.s)
    infix fun rem_(b: Vec4t<Number>) = rem(this, this, b.x.s, b.y.s, b.z.s, b.w.s)


    // -- Specific bitwise operators --

    infix fun and(b: Short) = and(Vec4s(), this, b, b, b, b)
    infix fun and(b: Int) = and(Vec4s(), this, b, b, b, b)
    infix fun and(b: Vec4s) = and(Vec4s(), this, b.x, b.y, b.z, b.w)

    infix fun and_(b: Short) = and(this, this, b, b, b, b)
    infix fun and_(b: Int) = and(this, this, b, b, b, b)
    infix fun and_(b: Vec4s) = and(this, this, b.x, b.y, b.z, b.w)

    fun and(b: Short, res: Vec4s) = and(res, this, b, b, b, b)
    fun and(b: Int, res: Vec4s) = and(res, this, b, b, b, b)
    fun and(b: Vec4s, res: Vec4s) = and(res, this, b.x, b.y, b.z, b.w)

    fun and(bX: Short, bY: Short, bZ: Short, bW: Short, res: Vec4s = Vec4s()) = and(res, this, bX, bY, bZ, bW)
    fun and(bX: Int, bY: Int, bZ: Int, bW: Int, res: Vec4s = Vec4s()) = and(res, this, bX, bY, bZ, bW)

    fun and_(bX: Short, bY: Short, bZ: Short, bW: Short) = and(this, this, bX, bY, bZ, bW)
    fun and_(bX: Int, bY: Int, bZ: Int, bW: Int) = and(this, this, bX, bY, bZ, bW)


    infix fun or(b: Short) = or(Vec4s(), this, b, b, b, b)
    infix fun or(b: Int) = or(Vec4s(), this, b, b, b, b)
    infix fun or(b: Vec4s) = or(Vec4s(), this, b.x, b.y, b.z, b.w)

    infix fun or_(b: Short) = or(this, this, b, b, b, b)
    infix fun or_(b: Int) = or(this, this, b, b, b, b)
    infix fun or_(b: Vec4s) = or(this, this, b.x, b.y, b.z, b.w)

    fun or(b: Short, res: Vec4s) = or(res, this, b, b, b, b)
    fun or(b: Int, res: Vec4s) = or(res, this, b, b, b, b)
    fun or(b: Vec4s, res: Vec4s) = or(res, this, b.x, b.y, b.z, b.w)

    fun or(bX: Short, bY: Short, bZ: Short, bW: Short, res: Vec4s = Vec4s()) = or(res, this, bX, bY, bZ, bW)
    fun or(bX: Int, bY: Int, bZ: Int, bW: Int, res: Vec4s = Vec4s()) = or(res, this, bX, bY, bZ, bW)

    fun or_(bX: Short, bY: Short, bZ: Short, bW: Short) = or(this, this, bX, bY, bZ, bW)
    fun or_(bX: Int, bY: Int, bZ: Int, bW: Int) = or(this, this, bX, bY, bZ, bW)


    infix fun xor(b: Short) = xor(Vec4s(), this, b, b, b, b)
    infix fun xor(b: Int) = xor(Vec4s(), this, b, b, b, b)
    infix fun xor(b: Vec4s) = xor(Vec4s(), this, b.x, b.y, b.z, b.w)

    infix fun xor_(b: Short) = xor(this, this, b, b, b, b)
    infix fun xor_(b: Int) = xor(this, this, b, b, b, b)
    infix fun xor_(b: Vec4s) = xor(this, this, b.x, b.y, b.z, b.w)

    fun xor(b: Short, res: Vec4s) = xor(res, this, b, b, b, b)
    fun xor(b: Int, res: Vec4s) = xor(res, this, b, b, b, b)
    fun xor(b: Vec4s, res: Vec4s) = xor(res, this, b.x, b.y, b.z, b.w)

    fun xor(bX: Short, bY: Short, bZ: Short, bW: Short, res: Vec4s = Vec4s()) = xor(res, this, bX, bY, bZ, bW)
    fun xor(bX: Int, bY: Int, bZ: Int, bW: Int, res: Vec4s = Vec4s()) = xor(res, this, bX, bY, bZ, bW)

    fun xor_(bX: Short, bY: Short, bZ: Short, bW: Short) = xor(this, this, bX, bY, bZ, bW)
    fun xor_(bX: Int, bY: Int, bZ: Int, bW: Int) = xor(this, this, bX, bY, bZ, bW)


    infix fun shl(b: Short) = shl(Vec4s(), this, b, b, b, b)
    infix fun shl(b: Int) = shl(Vec4s(), this, b, b, b, b)
    infix fun shl(b: Vec4s) = shl(Vec4s(), this, b.x, b.y, b.z, b.w)

    infix fun shl_(b: Short) = shl(this, this, b, b, b, b)
    infix fun shl_(b: Int) = shl(this, this, b, b, b, b)
    infix fun shl_(b: Vec4s) = shl(this, this, b.x, b.y, b.z, b.w)

    fun shl(b: Short, res: Vec4s) = shl(res, this, b, b, b, b)
    fun shl(b: Int, res: Vec4s) = shl(res, this, b, b, b, b)
    fun shl(b: Vec4s, res: Vec4s) = shl(res, this, b.x, b.y, b.z, b.w)

    fun shl(bX: Short, bY: Short, bZ: Short, bW: Short, res: Vec4s = Vec4s()) = shl(res, this, bX, bY, bZ, bW)
    fun shl(bX: Int, bY: Int, bZ: Int, bW: Int, res: Vec4s = Vec4s()) = shl(res, this, bX, bY, bZ, bW)

    fun shl_(bX: Short, bY: Short, bZ: Short, bW: Short) = shl(this, this, bX, bY, bZ, bW)
    fun shl_(bX: Int, bY: Int, bZ: Int, bW: Int) = shl(this, this, bX, bY, bZ, bW)


    infix fun shr(b: Short) = shr(Vec4s(), this, b, b, b, b)
    infix fun shr(b: Int) = shr(Vec4s(), this, b, b, b, b)
    infix fun shr(b: Vec4s) = shr(Vec4s(), this, b.x, b.y, b.z, b.w)

    infix fun shr_(b: Short) = shr(this, this, b, b, b, b)
    infix fun shr_(b: Int) = shr(this, this, b, b, b, b)
    infix fun shr_(b: Vec4s) = shr(this, this, b.x, b.y, b.z, b.w)

    fun shr(b: Short, res: Vec4s) = shr(res, this, b, b, b, b)
    fun shr(b: Int, res: Vec4s) = shr(res, this, b, b, b, b)
    fun shr(b: Vec4s, res: Vec4s) = shr(res, this, b.x, b.y, b.z, b.w)

    fun shr(bX: Short, bY: Short, bZ: Short, bW: Short, res: Vec4s = Vec4s()) = shr(res, this, bX, bY, bZ, bW)
    fun shr(bX: Int, bY: Int, bZ: Int, bW: Int, res: Vec4s = Vec4s()) = shr(res, this, bX, bY, bZ, bW)

    fun shr_(bX: Short, bY: Short, bZ: Short, bW: Short) = shr(this, this, bX, bY, bZ, bW)
    fun shr_(bX: Int, bY: Int, bZ: Int, bW: Int) = shr(this, this, bX, bY, bZ, bW)


    fun inv(res: Vec4s = Vec4s()) = inv(res, this)
    fun inv_() = inv(this, this)


    // -- Generic bitwise operators --

    infix fun and(b: Number) = and(Vec4s(), this, b.s, b.s, b.s, b.s)
    infix fun and(b: Vec4t<Number>) = and(Vec4s(), this, b.x.s, b.y.s, b.z.s, b.w.s)

    infix fun and_(b: Number) = and(this, this, b.s, b.s, b.s, b.s)
    infix fun and_(b: Vec4t<Number>) = and(this, this, b.x.s, b.y.s, b.z.s, b.w.s)

    fun and(b: Number, res: Vec4s) = and(res, this, b.s, b.s, b.s, b.s)
    fun and(b: Vec4t<Number>, res: Vec4s) = and(res, this, b.x.s, b.y.s, b.z.s, b.w.s)

    fun and(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4s = Vec4s()) = and(res, this, bX.s, bY.s, bZ.s, bW.s)

    fun and_(bX: Number, bY: Number, bZ: Number, bW: Number) = and(this, this, bX.s, bY.s, bZ.s, bW.s)


    infix fun or(b: Number) = or(Vec4s(), this, b.s, b.s, b.s, b.s)
    infix fun or(b: Vec4t<Number>) = or(Vec4s(), this, b.x.s, b.y.s, b.z.s, b.w.s)

    infix fun or_(b: Number) = or(this, this, b.s, b.s, b.s, b.s)
    infix fun or_(b: Vec4t<Number>) = or(this, this, b.x.s, b.y.s, b.z.s, b.w.s)

    fun or(b: Number, res: Vec4s) = or(res, this, b.s, b.s, b.s, b.s)
    fun or(b: Vec4t<Number>, res: Vec4s) = or(res, this, b.x.s, b.y.s, b.z.s, b.w.s)

    fun or(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4s = Vec4s()) = or(res, this, bX.s, bY.s, bZ.s, bW.s)

    fun or_(bX: Number, bY: Number, bZ: Number, bW: Number) = or(this, this, bX.s, bY.s, bZ.s, bW.s)


    infix fun xor(b: Number) = xor(Vec4s(), this, b.s, b.s, b.s, b.s)
    infix fun xor(b: Vec4t<Number>) = xor(Vec4s(), this, b.x.s, b.y.s, b.z.s, b.w.s)

    infix fun xor_(b: Number) = xor(this, this, b.s, b.s, b.s, b.s)
    infix fun xor_(b: Vec4t<Number>) = xor(this, this, b.x.s, b.y.s, b.z.s, b.w.s)

    fun xor(b: Number, res: Vec4s) = xor(res, this, b.s, b.s, b.s, b.s)
    fun xor(b: Vec4t<Number>, res: Vec4s) = xor(res, this, b.x.s, b.y.s, b.z.s, b.w.s)

    fun xor(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4s = Vec4s()) = xor(res, this, bX.s, bY.s, bZ.s, bW.s)

    fun xor_(bX: Number, bY: Number, bZ: Number, bW: Number) = xor(this, this, bX.s, bY.s, bZ.s, bW.s)


    infix fun shl(b: Number) = shl(Vec4s(), this, b.s, b.s, b.s, b.s)
    infix fun shl(b: Vec4t<Number>) = shl(Vec4s(), this, b.x.s, b.y.s, b.z.s, b.w.s)

    infix fun shl_(b: Number) = shl(this, this, b.s, b.s, b.s, b.s)
    infix fun shl_(b: Vec4t<Number>) = shl(this, this, b.x.s, b.y.s, b.z.s, b.w.s)

    fun shl(b: Number, res: Vec4s) = shl(res, this, b.s, b.s, b.s, b.s)
    fun shl(b: Vec4t<Number>, res: Vec4s) = shl(res, this, b.x.s, b.y.s, b.z.s, b.w.s)

    fun shl(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4s = Vec4s()) = shl(res, this, bX.s, bY.s, bZ.s, bW.s)

    fun shl_(bX: Number, bY: Number, bZ: Number, bW: Number) = shl(this, this, bX.s, bY.s, bZ.s, bW.s)


    infix fun shr(b: Number) = shr(Vec4s(), this, b.s, b.s, b.s, b.s)
    infix fun shr(b: Vec4t<Number>) = shr(Vec4s(), this, b.x.s, b.y.s, b.z.s, b.w.s)

    infix fun shr_(b: Number) = shr(this, this, b.s, b.s, b.s, b.s)
    infix fun shr_(b: Vec4t<Number>) = shr(this, this, b.x.s, b.y.s, b.z.s, b.w.s)

    fun shr(b: Number, res: Vec4s) = shr(res, this, b.s, b.s, b.s, b.s)
    fun shr(b: Vec4t<Number>, res: Vec4s) = shr(res, this, b.x.s, b.y.s, b.z.s, b.w.s)

    fun shr(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4s = Vec4s()) = shr(res, this, bX.s, bY.s, bZ.s, bW.s)

    fun shr_(bX: Number, bY: Number, bZ: Number, bW: Number) = shr(this, this, bX.s, bY.s, bZ.s, bW.s)
}