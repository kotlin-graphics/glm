package vec._3

import main.BYTES
import main.getShort
import main.s
import vec.Vec2t
import vec.Vec3t
import vec.Vec4t
import vec._3.operators.vec3s_operators
import vec.bool.Vec2bool
import vec.bool.Vec3bool
import vec.bool.Vec4bool
import java.nio.*

/**
 * Created by elect on 09/10/16.
 */

data class Vec3s(override var x: Short, override var y: Short, override var z: Short) : Vec3t<Short>() {

    // -- Explicit basic, conversion other main.and conversion vector constructors --

    constructor() : this(0)

    constructor(v: Vec2t<out Number>) : this(v.x, v.y, 0)
    constructor(v: Vec3t<out Number>) : this(v.x, v.y, v.z)
    constructor(v: Vec4t<out Number>) : this(v.x, v.y, v.z)

    constructor(v: Vec2bool) : this(v.x.s, v.y.s, 0)
    constructor(v: Vec3bool) : this(v.x.s, v.y.s, v.z.s)
    constructor(v: Vec4bool) : this(v.x.s, v.y.s, v.z.s)

    constructor(bytes: ByteArray, index: Int = 0, oneByteOneShort: Boolean = true, bigEndianess: Boolean = true) : this(
            if (oneByteOneShort) bytes[index].s else bytes.getShort(index, bigEndianess),
            if (oneByteOneShort) bytes[index + 1].s else bytes.getShort(index + Int.BYTES, bigEndianess),
            if (oneByteOneShort) bytes[index + 2].s else bytes.getShort(index + Int.BYTES * 2, bigEndianess))

    constructor(chars: CharArray, index: Int = 0) : this(chars[index].s, chars[index + 1].s, chars[index + 2].s)
    constructor(shorts: ShortArray, index: Int = 0) : this(shorts[index], shorts[index + 1], shorts[index + 2])
    constructor(ints: IntArray, index: Int = 0) : this(ints[index], ints[index + 1], ints[index + 2])
    constructor(longs: LongArray, index: Int = 0) : this(longs[index], longs[index + 1], longs[index + 2])
    constructor(floats: FloatArray, index: Int = 0) : this(floats[index], floats[index + 1], floats[index + 2])
    constructor(doubles: DoubleArray, index: Int = 0) : this(doubles[index], doubles[index + 1], doubles[index + 2])
    constructor(booleans: BooleanArray, index: Int = 0) : this(booleans[index].s, booleans[index + 1].s, booleans[index + 2].s)

    constructor(numbers: Array<out Number>, index: Int = 0) : this(numbers[index], numbers[index + 1], numbers[index + 2])
    constructor(chars: Array<Char>, index: Int = 0) : this(chars[index].s, chars[index + 1].s, chars[index + 2].s)
    constructor(booleans: Array<Boolean>, index: Int = 0) : this(booleans[index].s, booleans[index + 1].s, booleans[index + 2].s)

    constructor(list: List<Any>, index: Int = 0) : this() {
        put(list, index)
    }

    constructor(bytes: ByteBuffer, index: Int = bytes.position(), oneByteOneShort: Boolean = true) : this(
            if (oneByteOneShort) bytes[index].s else bytes.getShort(index),
            if (oneByteOneShort) bytes[index + 1].s else bytes.getShort(index + Int.BYTES),
            if (oneByteOneShort) bytes[index + 2].s else bytes.getShort(index + Int.BYTES * 2))

    constructor(chars: CharBuffer, index: Int = chars.position()) : this(chars[index].s, chars[index + 1].s, chars[index + 2].s)
    constructor(shorts: ShortBuffer, index: Int = shorts.position()) : this(shorts[index], shorts[index + 1], shorts[index + 2])
    constructor(ints: IntBuffer, index: Int = ints.position()) : this(ints[index], ints[index + 1], ints[index + 2])
    constructor(longs: LongBuffer, index: Int = longs.position()) : this(longs[index], longs[index + 1], longs[index + 2])
    constructor(floats: FloatBuffer, index: Int = floats.position()) : this(floats[index], floats[index + 1], floats[index + 2])
    constructor(doubles: DoubleBuffer, index: Int = doubles.position()) : this(doubles[index], doubles[index + 1], doubles[index + 2])

    constructor(s: Number) : this(s, s, s)
    constructor(x: Number, y: Number, z: Number) : this(x.s, y.s, z.s)


    fun set(bytes: ByteArray, index: Int = 0, oneByteOneShort: Boolean = true, bigEndianess: Boolean = true) {
        x = if (oneByteOneShort) bytes[index].s else bytes.getShort(index, bigEndianess)
        y = if (oneByteOneShort) bytes[index + 1].s else bytes.getShort(index + Short.BYTES, bigEndianess)
        z = if (oneByteOneShort) bytes[index + 2].s else bytes.getShort(index + Short.BYTES * 2, bigEndianess)
    }

    fun set(bytes: ByteBuffer, index: Int = bytes.position(), oneByteOneShort: Boolean = true) {
        x = if (oneByteOneShort) bytes[index].s else bytes.getShort(index)
        y = if (oneByteOneShort) bytes[index + 1].s else bytes.getShort(index + Short.BYTES)
        z = if (oneByteOneShort) bytes[index + 2].s else bytes.getShort(index + Short.BYTES * 2)
    }


    override fun put(x: Number, y: Number, z: Number): Vec3s {
        this.x = x.s
        this.y = y.s
        this.z = z.s
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
        0 -> x = s.s
        1 -> y = s.s
        2 -> z = s.s
        else -> throw ArrayIndexOutOfBoundsException()
    }


    companion object : vec3s_operators {
        @JvmField val SIZE = 3 * Short.BYTES
    }


    // -- Unary arithmetic operators --

    operator fun unaryPlus() = this

    operator fun unaryMinus() = Vec3s(-x, -y, -z)


    // -- Increment main.and decrement operators --

    operator fun inc(res: Vec3s = Vec3s()) = add(res, this, 1, 1, 1)
    fun inc_() = add(this, this, 1, 1, 1)


    operator fun dec(res: Vec3s = Vec3s()) = sub(res, this, 1, 1, 1)
    fun dec_() = sub(this, this, 1, 1, 1)


    // -- Specific binary arithmetic operators --

    operator fun plus(b: Short) = add(Vec3s(), this, b, b, b)
    operator fun plus(b: Int) = add(Vec3s(), this, b, b, b)
    operator fun plus(b: Vec3s) = add(Vec3s(), this, b.x, b.y, b.z)

    fun add(bX: Short, bY: Short, bZ: Short, res: Vec3s = Vec3s()) = add(res, this, bX, bY, bZ)
    fun add(bX: Int, bY: Int, bZ: Int, res: Vec3s = Vec3s()) = add(res, this, bX, bY, bZ)
    fun add(b: Short, res: Vec3s = Vec3s()) = add(res, this, b, b, b)
    fun add(b: Int, res: Vec3s = Vec3s()) = add(res, this, b, b, b)
    fun add(b: Vec3s, res: Vec3s = Vec3s()) = add(res, this, b.x, b.y, b.z)

    fun add_(bX: Short, bY: Short, bZ: Short) = add(this, this, bX, bY, bZ)
    fun add_(bX: Int, bY: Int, bZ: Int) = add(this, this, bX, bY, bZ)
    infix fun add_(b: Short) = add(this, this, b, b, b)
    infix fun add_(b: Int) = add(this, this, b, b, b)
    infix fun add_(b: Vec3s) = add(this, this, b.x, b.y, b.z)


    operator fun minus(b: Short) = sub(Vec3s(), this, b, b, b)
    operator fun minus(b: Int) = sub(Vec3s(), this, b, b, b)
    operator fun minus(b: Vec3s) = sub(Vec3s(), this, b.x, b.y, b.z)

    fun sub(bX: Short, bY: Short, bZ: Short, res: Vec3s = Vec3s()) = sub(res, this, bX, bY, bZ)
    fun sub(bX: Int, bY: Int, bZ: Int, res: Vec3s = Vec3s()) = sub(res, this, bX, bY, bZ)
    fun sub(b: Short, res: Vec3s = Vec3s()) = sub(res, this, b, b, b)
    fun sub(b: Int, res: Vec3s = Vec3s()) = sub(res, this, b, b, b)
    fun sub(b: Vec3s, res: Vec3s = Vec3s()) = sub(res, this, b.x, b.y, b.z)

    fun sub_(bX: Short, bY: Short, bZ: Short) = sub(this, this, bX, bY, bZ)
    fun sub_(bX: Int, bY: Int, bZ: Int) = sub(this, this, bX, bY, bZ)
    infix fun sub_(b: Short) = sub(this, this, b, b, b)
    infix fun sub_(b: Int) = sub(this, this, b, b, b)
    infix fun sub_(b: Vec3s) = sub(this, this, b.x, b.y, b.z)


    operator fun times(b: Short) = mul(Vec3s(), this, b, b, b)
    operator fun times(b: Int) = mul(Vec3s(), this, b, b, b)
    operator fun times(b: Vec3s) = mul(Vec3s(), this, b.x, b.y, b.z)

    fun mul(bX: Short, bY: Short, bZ: Short, res: Vec3s = Vec3s()) = mul(res, this, bX, bY, bZ)
    fun mul(bX: Int, bY: Int, bZ: Int, res: Vec3s = Vec3s()) = mul(res, this, bX, bY, bZ)
    fun mul(b: Short, res: Vec3s = Vec3s()) = mul(res, this, b, b, b)
    fun mul(b: Int, res: Vec3s = Vec3s()) = mul(res, this, b, b, b)
    fun mul(b: Vec3s, res: Vec3s = Vec3s()) = mul(res, this, b.x, b.y, b.z)

    fun mul_(bX: Short, bY: Short, bZ: Short) = mul(this, this, bX, bY, bZ)
    fun mul_(bX: Int, bY: Int, bZ: Int) = mul(this, this, bX, bY, bZ)
    infix fun mul_(b: Short) = mul(this, this, b, b, b)
    infix fun mul_(b: Int) = mul(this, this, b, b, b)
    infix fun mul_(b: Vec3s) = mul(this, this, b.x, b.y, b.z)


    operator fun div(b: Short) = div(Vec3s(), this, b, b, b)
    operator fun div(b: Int) = div(Vec3s(), this, b, b, b)
    operator fun div(b: Vec3s) = div(Vec3s(), this, b.x, b.y, b.z)

    fun div(bX: Short, bY: Short, bZ: Short, res: Vec3s = Vec3s()) = div(res, this, bX, bY, bZ)
    fun div(bX: Int, bY: Int, bZ: Int, res: Vec3s = Vec3s()) = div(res, this, bX, bY, bZ)
    fun div(b: Short, res: Vec3s) = div(res, this, b, b, b)
    fun div(b: Int, res: Vec3s) = div(res, this, b, b, b)
    fun div(b: Vec3s, res: Vec3s) = div(res, this, b.x, b.y, b.z)

    fun div_(bX: Short, bY: Short, bZ: Short) = div(this, this, bX, bY, bZ)
    fun div_(bX: Int, bY: Int, bZ: Int) = div(this, this, bX, bY, bZ)
    infix fun div_(b: Short) = div(this, this, b, b, b)
    infix fun div_(b: Int) = div(this, this, b, b, b)
    infix fun div_(b: Vec3s) = div(this, this, b.x, b.y, b.z)


    operator fun rem(b: Short) = rem(Vec3s(), this, b, b, b)
    operator fun rem(b: Int) = rem(Vec3s(), this, b, b, b)
    operator fun rem(b: Vec3s) = rem(Vec3s(), this, b.x, b.y, b.z)

    fun rem(bX: Short, bY: Short, bZ: Short, res: Vec3s = Vec3s()) = rem(res, this, bX, bY, bZ)
    fun rem(bX: Int, bY: Int, bZ: Int, res: Vec3s = Vec3s()) = rem(res, this, bX, bY, bZ)
    fun rem(b: Short, res: Vec3s) = rem(res, this, b, b, b)
    fun rem(b: Int, res: Vec3s) = rem(res, this, b, b, b)
    fun rem(b: Vec3s, res: Vec3s) = rem(res, this, b.x, b.y, b.z)

    fun rem_(bX: Short, bY: Short, bZ: Short) = rem(this, this, bX, bY, bZ)
    fun rem_(bX: Int, bY: Int, bZ: Int) = rem(this, this, bX, bY, bZ)
    infix fun rem_(b: Short) = rem(this, this, b, b, b)
    infix fun rem_(b: Int) = rem(this, this, b, b, b)
    infix fun rem_(b: Vec3s) = rem(this, this, b.x, b.y, b.z)


    // -- Generic binary arithmetic operators --

    operator fun plus(b: Number) = add(Vec3s(), this, b.s, b.s, b.s)
    operator fun plus(b: Vec3t<Number>) = add(Vec3s(), this, b.x.s, b.y.s, b.z.s)

    fun add(bX: Number, bY: Number, bZ: Number, res: Vec3s = Vec3s()) = add(res, this, bX.s, bY.s, bZ.s)
    fun add(b: Number, res: Vec3s = Vec3s()) = add(res, this, b.s, b.s, b.s)
    fun add(b: Vec3t<Number>, res: Vec3s = Vec3s()) = add(res, this, b.x.s, b.y.s, b.z.s)

    fun add_(bX: Number, bY: Number, bZ: Number) = add(this, this, bX.s, bY.s, bZ.s)
    infix fun add_(b: Number) = add(this, this, b.s, b.s, b.s)
    infix fun add_(b: Vec3t<Number>) = add(this, this, b.x.s, b.y.s, b.z.s)


    operator fun minus(b: Number) = sub(Vec3s(), this, b.s, b.s, b.s)
    operator fun minus(b: Vec3t<Number>) = sub(Vec3s(), this, b.x.s, b.y.s, b.z.s)

    fun sub(bX: Number, bY: Number, bZ: Number, res: Vec3s = Vec3s()) = sub(res, this, bX.s, bY.s, bZ.s)
    fun sub(b: Number, res: Vec3s = Vec3s()) = sub(res, this, b.s, b.s, b.s)
    fun sub(b: Vec3t<Number>, res: Vec3s = Vec3s()) = sub(res, this, b.x.s, b.y.s, b.z.s)

    fun sub_(bX: Number, bY: Number, bZ: Number) = sub(this, this, bX.s, bY.s, bZ.s)
    infix fun sub_(b: Number) = sub(this, this, b.s, b.s, b.s)
    infix fun sub_(b: Vec3t<Number>) = sub(this, this, b.x.s, b.y.s, b.z.s)


    operator fun times(b: Number) = mul(Vec3s(), this, b.s, b.s, b.s)
    operator fun times(b: Vec3t<Number>) = mul(Vec3s(), this, b.x.s, b.y.s, b.z.s)

    fun mul(bX: Number, bY: Number, bZ: Number, res: Vec3s = Vec3s()) = mul(res, this, bX.s, bY.s, bZ.s)
    fun mul(b: Number, res: Vec3s = Vec3s()) = mul(res, this, b.s, b.s, b.s)
    fun mul(b: Vec3t<Number>, res: Vec3s = Vec3s()) = mul(res, this, b.x.s, b.y.s, b.z.s)

    fun mul_(bX: Number, bY: Number, bZ: Number) = mul(this, this, bX.s, bY.s, bZ.s)
    infix fun mul_(b: Number) = mul(this, this, b.s, b.s, b.s)
    infix fun mul_(b: Vec3t<Number>) = mul(this, this, b.x.s, b.y.s, b.z.s)


    operator fun div(b: Number) = div(Vec3s(), this, b.s, b.s, b.s)
    operator fun div(b: Vec3t<Number>) = div(Vec3s(), this, b.x.s, b.y.s, b.z.s)

    fun div(bX: Number, bY: Number, bZ: Number, res: Vec3s = Vec3s()) = div(res, this, bX.s, bY.s, bZ.s)
    fun div(b: Number, res: Vec3s) = div(res, this, b.s, b.s, b.s)
    fun div(b: Vec3t<Number>, res: Vec3s) = div(res, this, b.x.s, b.y.s, b.z.s)

    fun div_(bX: Number, bY: Number, bZ: Number) = div(this, this, bX.s, bY.s, bZ.s)
    infix fun div_(b: Number) = div(this, this, b.s, b.s, b.s)
    infix fun div_(b: Vec3t<Number>) = div(this, this, b.x.s, b.y.s, b.z.s)


    operator fun rem(b: Number) = rem(Vec3s(), this, b.s, b.s, b.s)
    operator fun rem(b: Vec3t<Number>) = rem(Vec3s(), this, b.x.s, b.y.s, b.z.s)

    fun rem(bX: Number, bY: Number, bZ: Number, res: Vec3s = Vec3s()) = rem(res, this, bX.s, bY.s, bZ.s)
    fun rem(b: Number, res: Vec3s) = rem(res, this, b.s, b.s, b.s)
    fun rem(b: Vec3t<Number>, res: Vec3s) = rem(res, this, b.x.s, b.y.s, b.z.s)

    fun rem_(bX: Number, bY: Number, bZ: Number) = rem(this, this, bX.s, bY.s, bZ.s)
    infix fun rem_(b: Number) = rem(this, this, b.s, b.s, b.s)
    infix fun rem_(b: Vec3t<Number>) = rem(this, this, b.x.s, b.y.s, b.z.s)


    // -- Specific bitwise operators --

    infix fun and(b: Short) = and(Vec3s(), this, b, b, b)
    infix fun and(b: Int) = and(Vec3s(), this, b, b, b)
    infix fun and(b: Vec3s) = and(Vec3s(), this, b.x, b.y, b.z)

    infix fun and_(b: Short) = and(this, this, b, b, b)
    infix fun and_(b: Int) = and(this, this, b, b, b)
    infix fun and_(b: Vec3s) = and(this, this, b.x, b.y, b.z)

    fun and(b: Short, res: Vec3s) = and(res, this, b, b, b)
    fun and(b: Int, res: Vec3s) = and(res, this, b, b, b)
    fun and(b: Vec3s, res: Vec3s) = and(res, this, b.x, b.y, b.z)

    fun and(bX: Short, bY: Short, bZ: Short, res: Vec3s = Vec3s()) = and(res, this, bX, bY, bZ)
    fun and(bX: Int, bY: Int, bZ: Int, res: Vec3s = Vec3s()) = and(res, this, bX, bY, bZ)

    fun and_(bX: Short, bY: Short, bZ: Short) = and(this, this, bX, bY, bZ)
    fun and_(bX: Int, bY: Int, bZ: Int) = and(this, this, bX, bY, bZ)


    infix fun or(b: Short) = or(Vec3s(), this, b, b, b)
    infix fun or(b: Int) = or(Vec3s(), this, b, b, b)
    infix fun or(b: Vec3s) = or(Vec3s(), this, b.x, b.y, b.z)

    infix fun or_(b: Short) = or(this, this, b, b, b)
    infix fun or_(b: Int) = or(this, this, b, b, b)
    infix fun or_(b: Vec3s) = or(this, this, b.x, b.y, b.z)

    fun or(b: Short, res: Vec3s) = or(res, this, b, b, b)
    fun or(b: Int, res: Vec3s) = or(res, this, b, b, b)
    fun or(b: Vec3s, res: Vec3s) = or(res, this, b.x, b.y, b.z)

    fun or(bX: Short, bY: Short, bZ: Short, res: Vec3s = Vec3s()) = or(res, this, bX, bY, bZ)
    fun or(bX: Int, bY: Int, bZ: Int, res: Vec3s = Vec3s()) = or(res, this, bX, bY, bZ)

    fun or_(bX: Short, bY: Short, bZ: Short) = or(this, this, bX, bY, bZ)
    fun or_(bX: Int, bY: Int, bZ: Int) = or(this, this, bX, bY, bZ)


    infix fun xor(b: Short) = xor(Vec3s(), this, b, b, b)
    infix fun xor(b: Int) = xor(Vec3s(), this, b, b, b)
    infix fun xor(b: Vec3s) = xor(Vec3s(), this, b.x, b.y, b.z)

    infix fun xor_(b: Short) = xor(this, this, b, b, b)
    infix fun xor_(b: Int) = xor(this, this, b, b, b)
    infix fun xor_(b: Vec3s) = xor(this, this, b.x, b.y, b.z)

    fun xor(b: Short, res: Vec3s) = xor(res, this, b, b, b)
    fun xor(b: Int, res: Vec3s) = xor(res, this, b, b, b)
    fun xor(b: Vec3s, res: Vec3s) = xor(res, this, b.x, b.y, b.z)

    fun xor(bX: Short, bY: Short, bZ: Short, res: Vec3s = Vec3s()) = xor(res, this, bX, bY, bZ)
    fun xor(bX: Int, bY: Int, bZ: Int, res: Vec3s = Vec3s()) = xor(res, this, bX, bY, bZ)

    fun xor_(bX: Short, bY: Short, bZ: Short) = xor(this, this, bX, bY, bZ)
    fun xor_(bX: Int, bY: Int, bZ: Int) = xor(this, this, bX, bY, bZ)


    infix fun shl(b: Short) = shl(Vec3s(), this, b, b, b)
    infix fun shl(b: Int) = shl(Vec3s(), this, b, b, b)
    infix fun shl(b: Vec3s) = shl(Vec3s(), this, b.x, b.y, b.z)

    infix fun shl_(b: Short) = shl(this, this, b, b, b)
    infix fun shl_(b: Int) = shl(this, this, b, b, b)
    infix fun shl_(b: Vec3s) = shl(this, this, b.x, b.y, b.z)

    fun shl(b: Short, res: Vec3s) = shl(res, this, b, b, b)
    fun shl(b: Int, res: Vec3s) = shl(res, this, b, b, b)
    fun shl(b: Vec3s, res: Vec3s) = shl(res, this, b.x, b.y, b.z)

    fun shl(bX: Short, bY: Short, bZ: Short, res: Vec3s = Vec3s()) = shl(res, this, bX, bY, bZ)
    fun shl(bX: Int, bY: Int, bZ: Int, res: Vec3s = Vec3s()) = shl(res, this, bX, bY, bZ)

    fun shl_(bX: Short, bY: Short, bZ: Short) = shl(this, this, bX, bY, bZ)
    fun shl_(bX: Int, bY: Int, bZ: Int) = shl(this, this, bX, bY, bZ)


    infix fun shr(b: Short) = shr(Vec3s(), this, b, b, b)
    infix fun shr(b: Int) = shr(Vec3s(), this, b, b, b)
    infix fun shr(b: Vec3s) = shr(Vec3s(), this, b.x, b.y, b.z)

    infix fun shr_(b: Short) = shr(this, this, b, b, b)
    infix fun shr_(b: Int) = shr(this, this, b, b, b)
    infix fun shr_(b: Vec3s) = shr(this, this, b.x, b.y, b.z)

    fun shr(b: Short, res: Vec3s) = shr(res, this, b, b, b)
    fun shr(b: Int, res: Vec3s) = shr(res, this, b, b, b)
    fun shr(b: Vec3s, res: Vec3s) = shr(res, this, b.x, b.y, b.z)

    fun shr(bX: Short, bY: Short, bZ: Short, res: Vec3s = Vec3s()) = shr(res, this, bX, bY, bZ)
    fun shr(bX: Int, bY: Int, bZ: Int, res: Vec3s = Vec3s()) = shr(res, this, bX, bY, bZ)

    fun shr_(bX: Short, bY: Short, bZ: Short) = shr(this, this, bX, bY, bZ)
    fun shr_(bX: Int, bY: Int, bZ: Int) = shr(this, this, bX, bY, bZ)


    fun inv(res: Vec3s = Vec3s()) = inv(res, this)
    fun inv_() = inv(this, this)


    // -- Generic bitwise operators --

    infix fun and(b: Number) = and(Vec3s(), this, b.s, b.s, b.s)
    infix fun and(b: Vec3t<Number>) = and(Vec3s(), this, b.x.s, b.y.s, b.z.s)

    infix fun and_(b: Number) = and(this, this, b.s, b.s, b.s)
    infix fun and_(b: Vec3t<Number>) = and(this, this, b.x.s, b.y.s, b.z.s)

    fun and(b: Number, res: Vec3s) = and(res, this, b.s, b.s, b.s)
    fun and(b: Vec3t<Number>, res: Vec3s) = and(res, this, b.x.s, b.y.s, b.z.s)

    fun and(bX: Number, bY: Number, bZ: Number, res: Vec3s = Vec3s()) = and(res, this, bX.s, bY.s, bZ.s)

    fun and_(bX: Number, bY: Number, bZ: Number) = and(this, this, bX.s, bY.s, bZ.s)


    infix fun or(b: Number) = or(Vec3s(), this, b.s, b.s, b.s)
    infix fun or(b: Vec3t<Number>) = or(Vec3s(), this, b.x.s, b.y.s, b.z.s)

    infix fun or_(b: Number) = or(this, this, b.s, b.s, b.s)
    infix fun or_(b: Vec3t<Number>) = or(this, this, b.x.s, b.y.s, b.z.s)

    fun or(b: Number, res: Vec3s) = or(res, this, b.s, b.s, b.s)
    fun or(b: Vec3t<Number>, res: Vec3s) = or(res, this, b.x.s, b.y.s, b.z.s)

    fun or(bX: Number, bY: Number, bZ: Number, res: Vec3s = Vec3s()) = or(res, this, bX.s, bY.s, bZ.s)

    fun or_(bX: Number, bY: Number, bZ: Number) = or(this, this, bX.s, bY.s, bZ.s)


    infix fun xor(b: Number) = xor(Vec3s(), this, b.s, b.s, b.s)
    infix fun xor(b: Vec3t<Number>) = xor(Vec3s(), this, b.x.s, b.y.s, b.z.s)

    infix fun xor_(b: Number) = xor(this, this, b.s, b.s, b.s)
    infix fun xor_(b: Vec3t<Number>) = xor(this, this, b.x.s, b.y.s, b.z.s)

    fun xor(b: Number, res: Vec3s) = xor(res, this, b.s, b.s, b.s)
    fun xor(b: Vec3t<Number>, res: Vec3s) = xor(res, this, b.x.s, b.y.s, b.z.s)

    fun xor(bX: Number, bY: Number, bZ: Number, res: Vec3s = Vec3s()) = xor(res, this, bX.s, bY.s, bZ.s)

    fun xor_(bX: Number, bY: Number, bZ: Number) = xor(this, this, bX.s, bY.s, bZ.s)


    infix fun shl(b: Number) = shl(Vec3s(), this, b.s, b.s, b.s)
    infix fun shl(b: Vec3t<Number>) = shl(Vec3s(), this, b.x.s, b.y.s, b.z.s)

    infix fun shl_(b: Number) = shl(this, this, b.s, b.s, b.s)
    infix fun shl_(b: Vec3t<Number>) = shl(this, this, b.x.s, b.y.s, b.z.s)

    fun shl(b: Number, res: Vec3s) = shl(res, this, b.s, b.s, b.s)
    fun shl(b: Vec3t<Number>, res: Vec3s) = shl(res, this, b.x.s, b.y.s, b.z.s)

    fun shl(bX: Number, bY: Number, bZ: Number, res: Vec3s = Vec3s()) = shl(res, this, bX.s, bY.s, bZ.s)

    fun shl_(bX: Number, bY: Number, bZ: Number) = shl(this, this, bX.s, bY.s, bZ.s)


    infix fun shr(b: Number) = shr(Vec3s(), this, b.s, b.s, b.s)
    infix fun shr(b: Vec3t<Number>) = shr(Vec3s(), this, b.x.s, b.y.s, b.z.s)

    infix fun shr_(b: Number) = shr(this, this, b.s, b.s, b.s)
    infix fun shr_(b: Vec3t<Number>) = shr(this, this, b.x.s, b.y.s, b.z.s)

    fun shr(b: Number, res: Vec3s) = shr(res, this, b.s, b.s, b.s)
    fun shr(b: Vec3t<Number>, res: Vec3s) = shr(res, this, b.x.s, b.y.s, b.z.s)

    fun shr(bX: Number, bY: Number, bZ: Number, res: Vec3s = Vec3s()) = shr(res, this, bX.s, bY.s, bZ.s)

    fun shr_(bX: Number, bY: Number, bZ: Number) = shr(this, this, bX.s, bY.s, bZ.s)
}