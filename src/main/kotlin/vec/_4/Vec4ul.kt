package vec._4

import main.*
import unsigned.Ulong
import vec.Vec2t
import vec.Vec3t
import vec.Vec4t
import vec._4.operators.vec4ul_operators
import vec.bool.Vec2bool
import vec.bool.Vec3bool
import vec.bool.Vec4bool
import java.nio.*

/**
 * Created by elect on 09/10/16.
 */

data class Vec4ul(override var x: Ulong, override var y: Ulong, override var z: Ulong, override var w: Ulong) : Vec4t<Ulong>() {

    // -- Explicit basic, conversion other main.and conversion vector constructors --

    constructor() : this(0)

    constructor(v: Vec2t<out Number>) : this(v.x, v.y, 0, 1)
    constructor(v: Vec3t<out Number>) : this(v.x, v.y, v.z, 1)
    constructor(v: Vec4t<out Number>) : this(v.x, v.y, v.z, v.w)

    constructor(v: Vec2bool) : this(v.x.ul, v.y.ul, 0, 1)
    constructor(v: Vec3bool) : this(v.x.ul, v.y.ul, v.z.ul, 1)
    constructor(v: Vec4bool) : this(v.x.ul, v.y.ul, v.z.ul, v.w.ul)

    constructor(bytes: ByteArray, index: Int = 0, oneByteOneUlong: Boolean = true, bigEndianess: Boolean = true) : this(
            if (oneByteOneUlong) bytes[index].ul else bytes.getUlong(index, bigEndianess),
            if (oneByteOneUlong) bytes[index + 1].ul else bytes.getUlong(index + Ulong.BYTES, bigEndianess),
            if (oneByteOneUlong) bytes[index + 2].ul else bytes.getUlong(index + Ulong.BYTES * 2, bigEndianess),
            if (oneByteOneUlong) bytes[index + 3].ul else bytes.getUlong(index + Ulong.BYTES * 3, bigEndianess))

    constructor(chars: CharArray, index: Int = 0) : this(chars[index].ul, chars[index + 1].ul, chars[index + 2].ul, chars[index + 3].ul)
    constructor(shorts: ShortArray, index: Int = 0) : this(shorts[index], shorts[index + 1], shorts[index + 2], shorts[index + 3])
    constructor(ints: IntArray, index: Int = 0) : this(ints[index], ints[index + 1], ints[index + 2], ints[index + 3])
    constructor(longs: LongArray, index: Int = 0) : this(longs[index], longs[index + 1], longs[index + 2], longs[index + 3])
    constructor(floats: FloatArray, index: Int = 0) : this(floats[index], floats[index + 1], floats[index + 2], floats[index + 3])
    constructor(doubles: DoubleArray, index: Int = 0) : this(doubles[index], doubles[index + 1], doubles[index + 2], doubles[index + 3])
    constructor(booleans: BooleanArray, index: Int = 0) : this(booleans[index].ul, booleans[index + 1].ul, booleans[index + 2].ul, booleans[index + 3].ul)

    constructor(numbers: Array<out Number>, index: Int = 0) : this(numbers[index], numbers[index + 1], numbers[index + 2], numbers[index + 3])
    constructor(chars: Array<Char>, index: Int = 0) : this(chars[index].ul, chars[index + 1].ul, chars[index + 2].ul, chars[index + 3].ul)
    constructor(booleans: Array<Boolean>, index: Int = 0) : this(booleans[index].ul, booleans[index + 1].ul, booleans[index + 2].ul, booleans[index + 3].ul)

    constructor(list: List<Any>, index: Int = 0) : this() {
        put(list, index)
    }

    constructor(bytes: ByteBuffer, index: Int = bytes.position(), oneByteOneUlong: Boolean = true) : this(
            if (oneByteOneUlong) bytes[index].ul else bytes.getLong(index).ul,
            if (oneByteOneUlong) bytes[index + 1].ul else bytes.getLong(index + Ulong.BYTES).ul,
            if (oneByteOneUlong) bytes[index + 2].ul else bytes.getLong(index + Ulong.BYTES * 2).ul,
            if (oneByteOneUlong) bytes[index + 3].ul else bytes.getLong(index + Ulong.BYTES * 3).ul)

    constructor(chars: CharBuffer, index: Int = chars.position()) : this(chars[index].ul, chars[index + 1].ul, chars[index + 2].ul, chars[index + 3].ul)
    constructor(shorts: ShortBuffer, index: Int = shorts.position()) : this(shorts[index], shorts[index + 1], shorts[index + 2], shorts[index + 3])
    constructor(ints: IntBuffer, index: Int = ints.position()) : this(ints[index], ints[index + 1], ints[index + 2], ints[index + 3])
    constructor(longs: LongBuffer, index: Int = longs.position()) : this(longs[index], longs[index + 1], longs[index + 2], longs[index + 3])
    constructor(floats: FloatBuffer, index: Int = floats.position()) : this(floats[index], floats[index + 1], floats[index + 2], floats[index + 3])
    constructor(doubles: DoubleBuffer, index: Int = doubles.position()) : this(doubles[index], doubles[index + 1], doubles[index + 2], doubles[index + 3])

    constructor(s: Number) : this(s, s, s, s)
    constructor(x: Number, y: Number, z: Number, w: Number) : this(x.ul, y.ul, z.ul, w.ul)


    fun set(bytes: ByteArray, index: Int = 0, oneByteOneUlong: Boolean = true, bigEndianess: Boolean = true) {
        x.v = if (oneByteOneUlong) bytes[index].L else bytes.getLong(index, bigEndianess)
        y.v = if (oneByteOneUlong) bytes[index + 1].L else bytes.getLong(index + Ulong.BYTES, bigEndianess)
        z.v = if (oneByteOneUlong) bytes[index + 2].L else bytes.getLong(index + Ulong.BYTES * 2, bigEndianess)
        w.v = if (oneByteOneUlong) bytes[index + 3].L else bytes.getLong(index + Ulong.BYTES * 3, bigEndianess)
    }

    fun set(bytes: ByteBuffer, index: Int = bytes.position(), oneByteOneUlong: Boolean = true) {
        x.v = if (oneByteOneUlong) bytes[index].L else bytes.getLong(index)
        y.v = if (oneByteOneUlong) bytes[index + 1].L else bytes.getLong(index + Ulong.BYTES)
        z.v = if (oneByteOneUlong) bytes[index + 2].L else bytes.getLong(index + Ulong.BYTES * 2)
        w.v = if (oneByteOneUlong) bytes[index + 3].L else bytes.getLong(index + Ulong.BYTES * 3)
    }


    override fun put(x: Number, y: Number, z: Number, w: Number): Vec4ul {
        this.x = x.ul
        this.y = y.ul
        this.z = z.ul
        this.w = w.ul
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
        0 -> x = s.ul
        1 -> y = s.ul
        2 -> y = s.ul
        3 -> w = s.ul
        else -> throw ArrayIndexOutOfBoundsException()
    }


    companion object : vec4ul_operators {
        @JvmField val length = 4
        @JvmField val SIZE = length * Ulong.BYTES
    }


    // -- Unary arithmetic operators --

    operator fun unaryPlus() = this

    // no unaryMinus operator, only signed

    // -- Increment main.and decrement operators --

    operator fun inc(res: Vec4ul = Vec4ul()) = add(res, this, 1, 1, 1, 1)
    fun inc_() = add(this, this, 1, 1, 1, 1)


    operator fun dec(res: Vec4ul = Vec4ul()) = sub(res, this, 1, 1, 1, 1)
    fun dec_() = sub(this, this, 1, 1, 1, 1)


    // -- Specific binary arithmetic operators --

    operator fun plus(b: Ulong) = add(Vec4ul(), this, b, b, b, b)
    operator fun plus(b: Long) = add(Vec4ul(), this, b, b, b, b)
    operator fun plus(b: Vec4ul) = add(Vec4ul(), this, b.x, b.y, b.z, b.w)

    fun add(bX: Ulong, bY: Ulong, bZ: Ulong, bW: Ulong, res: Vec4ul = Vec4ul()) = add(res, this, bX, bY, bZ, bW)
    fun add(bX: Long, bY: Long, bZ: Long, bW: Long, res: Vec4ul = Vec4ul()) = add(res, this, bX, bY, bZ, bW)
    fun add(b: Ulong, res: Vec4ul = Vec4ul()) = add(res, this, b, b, b, b)
    fun add(b: Long, res: Vec4ul = Vec4ul()) = add(res, this, b, b, b, b)
    fun add(b: Vec4ul, res: Vec4ul = Vec4ul()) = add(res, this, b.x, b.y, b.z, b.w)

    fun add_(bX: Ulong, bY: Ulong, bZ: Ulong, bW: Ulong) = add(this, this, bX, bY, bZ, bW)
    fun add_(bX: Long, bY: Long, bZ: Long, bW: Long) = add(this, this, bX, bY, bZ, bW)
    infix fun add_(b: Ulong) = add(this, this, b, b, b, b)
    infix fun add_(b: Long) = add(this, this, b, b, b, b)
    infix fun add_(b: Vec4ul) = add(this, this, b.x, b.y, b.z, b.w)


    operator fun minus(b: Ulong) = sub(Vec4ul(), this, b, b, b, b)
    operator fun minus(b: Long) = sub(Vec4ul(), this, b, b, b, b)
    operator fun minus(b: Vec4ul) = sub(Vec4ul(), this, b.x, b.y, b.z, b.w)

    fun sub(bX: Ulong, bY: Ulong, bZ: Ulong, bW: Ulong, res: Vec4ul = Vec4ul()) = sub(res, this, bX, bY, bZ, bW)
    fun sub(bX: Long, bY: Long, bZ: Long, bW: Long, res: Vec4ul = Vec4ul()) = sub(res, this, bX, bY, bZ, bW)
    fun sub(b: Ulong, res: Vec4ul = Vec4ul()) = sub(res, this, b, b, b, b)
    fun sub(b: Long, res: Vec4ul = Vec4ul()) = sub(res, this, b, b, b, b)
    fun sub(b: Vec4ul, res: Vec4ul = Vec4ul()) = sub(res, this, b.x, b.y, b.z, b.w)

    fun sub_(bX: Ulong, bY: Ulong, bZ: Ulong, bW: Ulong) = sub(this, this, bX, bY, bZ, bW)
    fun sub_(bX: Long, bY: Long, bZ: Long, bW: Long) = sub(this, this, bX, bY, bZ, bW)
    infix fun sub_(b: Ulong) = sub(this, this, b, b, b, b)
    infix fun sub_(b: Long) = sub(this, this, b, b, b, b)
    infix fun sub_(b: Vec4ul) = sub(this, this, b.x, b.y, b.z, b.w)


    operator fun times(b: Ulong) = mul(Vec4ul(), this, b, b, b, b)
    operator fun times(b: Long) = mul(Vec4ul(), this, b, b, b, b)
    operator fun times(b: Vec4ul) = mul(Vec4ul(), this, b.x, b.y, b.z, b.w)

    fun mul(bX: Ulong, bY: Ulong, bZ: Ulong, bW: Ulong, res: Vec4ul = Vec4ul()) = mul(res, this, bX, bY, bZ, bW)
    fun mul(bX: Long, bY: Long, bZ: Long, bW: Long, res: Vec4ul = Vec4ul()) = mul(res, this, bX, bY, bZ, bW)
    fun mul(b: Ulong, res: Vec4ul = Vec4ul()) = mul(res, this, b, b, b, b)
    fun mul(b: Long, res: Vec4ul = Vec4ul()) = mul(res, this, b, b, b, b)
    fun mul(b: Vec4ul, res: Vec4ul = Vec4ul()) = mul(res, this, b.x, b.y, b.z, b.w)

    fun mul_(bX: Ulong, bY: Ulong, bZ: Ulong, bW: Ulong) = mul(this, this, bX, bY, bZ, bW)
    fun mul_(bX: Long, bY: Long, bZ: Long, bW: Long) = mul(this, this, bX, bY, bZ, bW)
    infix fun mul_(b: Ulong) = mul(this, this, b, b, b, b)
    infix fun mul_(b: Long) = mul(this, this, b, b, b, b)
    infix fun mul_(b: Vec4ul) = mul(this, this, b.x, b.y, b.z, b.w)


    operator fun div(b: Ulong) = div(Vec4ul(), this, b, b, b, b)
    operator fun div(b: Long) = div(Vec4ul(), this, b, b, b, b)
    operator fun div(b: Vec4ul) = div(Vec4ul(), this, b.x, b.y, b.z, b.w)

    fun div(bX: Ulong, bY: Ulong, bZ: Ulong, bW: Ulong, res: Vec4ul = Vec4ul()) = div(res, this, bX, bY, bZ, bW)
    fun div(bX: Long, bY: Long, bZ: Long, bW: Long, res: Vec4ul = Vec4ul()) = div(res, this, bX, bY, bZ, bW)
    fun div(b: Ulong, res: Vec4ul = Vec4ul()) = div(res, this, b, b, b, b)
    fun div(b: Long, res: Vec4ul = Vec4ul()) = div(res, this, b, b, b, b)
    fun div(b: Vec4ul, res: Vec4ul = Vec4ul()) = div(res, this, b.x, b.y, b.z, b.w)

    fun div_(bX: Ulong, bY: Ulong, bZ: Ulong, bW: Ulong) = div(this, this, bX, bY, bZ, bW)
    fun div_(bX: Long, bY: Long, bZ: Long, bW: Long) = div(this, this, bX, bY, bZ, bW)
    infix fun div_(b: Ulong) = div(this, this, b, b, b, b)
    infix fun div_(b: Long) = div(this, this, b, b, b, b)
    infix fun div_(b: Vec4ul) = div(this, this, b.x, b.y, b.z, b.w)


    operator fun rem(b: Ulong) = rem(Vec4ul(), this, b, b, b, b)
    operator fun rem(b: Long) = rem(Vec4ul(), this, b, b, b, b)
    operator fun rem(b: Vec4ul) = rem(Vec4ul(), this, b.x, b.y, b.z, b.w)

    fun rem(bX: Ulong, bY: Ulong, bZ: Ulong, bW: Ulong, res: Vec4ul = Vec4ul()) = rem(res, this, bX, bY, bZ, bW)
    fun rem(bX: Long, bY: Long, bZ: Long, bW: Long, res: Vec4ul = Vec4ul()) = rem(res, this, bX, bY, bZ, bW)
    fun rem(b: Ulong, res: Vec4ul = Vec4ul()) = rem(res, this, b, b, b, b)
    fun rem(b: Long, res: Vec4ul = Vec4ul()) = rem(res, this, b, b, b, b)
    fun rem(b: Vec4ul, res: Vec4ul = Vec4ul()) = rem(res, this, b.x, b.y, b.z, b.w)

    fun rem_(bX: Ulong, bY: Ulong, bZ: Ulong, bW: Ulong) = rem(this, this, bX, bY, bZ, bW)
    fun rem_(bX: Long, bY: Long, bZ: Long, bW: Long) = rem(this, this, bX, bY, bZ, bW)
    infix fun rem_(b: Ulong) = rem(this, this, b, b, b, b)
    infix fun rem_(b: Long) = rem(this, this, b, b, b, b)
    infix fun rem_(b: Vec4ul) = rem(this, this, b.x, b.y, b.z, b.w)


    // -- Generic binary arithmetic operators --

    operator fun plus(b: Number) = add(Vec4ul(), this, b.L, b.L, b.L, b.L)
    operator fun plus(b: Vec4t<Number>) = add(Vec4ul(), this, b.x.L, b.y.L, b.z.L, b.w.L)

    fun add(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4ul = Vec4ul()) = add(res, this, bX.L, bY.L, bZ.L, bW.L)
    fun add(b: Number, res: Vec4ul = Vec4ul()) = add(res, this, b.L, b.L, b.L, b.L)
    fun add(b: Vec4t<Number>, res: Vec4ul = Vec4ul()) = add(res, this, b.x.L, b.y.L, b.z.L, b.w.L)

    fun add_(bX: Number, bY: Number, bZ: Number, bW: Number) = add(this, this, bX.L, bY.L, bZ.L, bW.L)
    infix fun add_(b: Number) = add(this, this, b.L, b.L, b.L, b.L)
    infix fun add_(b: Vec4t<Number>) = add(this, this, b.x.L, b.y.L, b.z.L, b.w.L)


    operator fun minus(b: Number) = sub(Vec4ul(), this, b.L, b.L, b.L, b.L)
    operator fun minus(b: Vec4t<Number>) = sub(Vec4ul(), this, b.x.L, b.y.L, b.z.L, b.w.L)

    fun sub(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4ul = Vec4ul()) = sub(res, this, bX.L, bY.L, bZ.L, bW.L)
    fun sub(b: Number, res: Vec4ul = Vec4ul()) = sub(res, this, b.L, b.L, b.L, b.L)
    fun sub(b: Vec4t<Number>, res: Vec4ul = Vec4ul()) = sub(res, this, b.x.L, b.y.L, b.z.L, b.w.L)

    fun sub_(bX: Number, bY: Number, bZ: Number, bW: Number) = sub(this, this, bX.L, bY.L, bZ.L, bW.L)
    infix fun sub_(b: Number) = sub(this, this, b.L, b.L, b.L, b.L)
    infix fun sub_(b: Vec4t<Number>) = sub(this, this, b.x.L, b.y.L, b.z.L, b.w.L)


    operator fun times(b: Number) = mul(Vec4ul(), this, b.L, b.L, b.L, b.L)
    operator fun times(b: Vec4t<Number>) = mul(Vec4ul(), this, b.x.L, b.y.L, b.z.L, b.w.L)

    fun mul(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4ul = Vec4ul()) = mul(res, this, bX.L, bY.L, bZ.L, bW.L)
    fun mul(b: Number, res: Vec4ul = Vec4ul()) = mul(res, this, b.L, b.L, b.L, b.L)
    fun mul(b: Vec4t<Number>, res: Vec4ul = Vec4ul()) = mul(res, this, b.x.L, b.y.L, b.z.L, b.w.L)

    fun mul_(bX: Number, bY: Number, bZ: Number, bW: Number) = mul(this, this, bX.L, bY.L, bZ.L, bW.L)
    infix fun mul_(b: Number) = mul(this, this, b.L, b.L, b.L, b.L)
    infix fun mul_(b: Vec4t<Number>) = mul(this, this, b.x.L, b.y.L, b.z.L, b.w.L)


    operator fun div(b: Number) = div(Vec4ul(), this, b.L, b.L, b.L, b.L)
    operator fun div(b: Vec4t<Number>) = div(Vec4ul(), this, b.x.L, b.y.L, b.z.L, b.w.L)

    fun div(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4ul = Vec4ul()) = div(res, this, bX.L, bY.L, bZ.L, bW.L)
    fun div(b: Number, res: Vec4ul = Vec4ul()) = div(res, this, b.L, b.L, b.L, b.L)
    fun div(b: Vec4t<Number>, res: Vec4ul = Vec4ul()) = div(res, this, b.x.L, b.y.L, b.z.L, b.w.L)

    fun div_(bX: Number, bY: Number, bZ: Number, bW: Number) = div(this, this, bX.L, bY.L, bZ.L, bW.L)
    infix fun div_(b: Number) = div(this, this, b.L, b.L, b.L, b.L)
    infix fun div_(b: Vec4t<Number>) = div(this, this, b.x.L, b.y.L, b.z.L, b.w.L)


    operator fun rem(b: Number) = rem(Vec4ul(), this, b.L, b.L, b.L, b.L)
    operator fun rem(b: Vec4t<Number>) = rem(Vec4ul(), this, b.x.L, b.y.L, b.z.L, b.w.L)

    fun rem(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4ul = Vec4ul()) = rem(res, this, bX.L, bY.L, bZ.L, bW.L)
    fun rem(b: Number, res: Vec4ul = Vec4ul()) = rem(res, this, b.L, b.L, b.L, b.L)
    fun rem(b: Vec4t<Number>, res: Vec4ul = Vec4ul()) = rem(res, this, b.x.L, b.y.L, b.z.L, b.w.L)

    fun rem_(bX: Number, bY: Number, bZ: Number, bW: Number) = rem(this, this, bX.L, bY.L, bZ.L, bW.L)
    infix fun rem_(b: Number) = rem(this, this, b.L, b.L, b.L, b.L)
    infix fun rem_(b: Vec4t<Number>) = rem(this, this, b.x.L, b.y.L, b.z.L, b.w.L)


    // -- Specific bitwise operators --

    infix fun and(b: Ulong) = and(Vec4ul(), this, b, b, b, b)
    infix fun and(b: Long) = and(Vec4ul(), this, b, b, b, b)
    fun and(bX: Ulong, bY: Ulong, bZ: Ulong, bW: Ulong) = and(Vec4ul(), this, bX, bY, bZ, bW)
    fun and(bX: Long, bY: Long, bZ: Long, bW: Long) = and(Vec4ul(), this, bX, bY, bZ, bW)
    fun and(b: Vec4ul) = and(Vec4ul(), this, b.x, b.y, b.z, b.w)

    infix fun and_(b: Ulong) = and(this, this, b, b, b, b)
    infix fun and_(b: Long) = and(this, this, b, b, b, b)
    fun and_(bX: Ulong, bY: Ulong, bZ: Ulong, bW: Ulong) = and(this, this, bX, bY, bZ, bW)
    fun and_(bX: Long, bY: Long, bZ: Long, bW: Long) = and(this, this, bX, bY, bZ, bW)
    infix fun and_(b: Vec4ul) = and(this, this, b.x, b.y, b.z, b.w)

    fun and(b: Ulong, res: Vec4ul) = and(res, this, b, b, b, b)
    fun and(b: Long, res: Vec4ul) = and(res, this, b, b, b, b)
    fun and(bX: Ulong, bY: Ulong, bZ: Ulong, bW: Ulong, res: Vec4ul) = and(res, this, bX, bY, bZ, bW)
    fun and(bX: Long, bY: Long, bZ: Long, bW: Long, res: Vec4ul) = and(res, this, bX, bY, bZ, bW)
    fun and(b: Vec4ul, res: Vec4ul) = and(res, this, b.x, b.y, b.z, b.w)


    infix fun or(b: Ulong) = or(Vec4ul(), this, b, b, b, b)
    infix fun or(b: Long) = or(Vec4ul(), this, b, b, b, b)
    fun or(bX: Ulong, bY: Ulong, bZ: Ulong, bW: Ulong) = or(Vec4ul(), this, bX, bY, bZ, bW)
    fun or(bX: Long, bY: Long, bZ: Long, bW: Long) = or(Vec4ul(), this, bX, bY, bZ, bW)
    fun or(b: Vec4ul) = or(Vec4ul(), this, b.x, b.y, b.z, b.w)

    infix fun or_(b: Ulong) = or(this, this, b, b, b, b)
    infix fun or_(b: Long) = or(this, this, b, b, b, b)
    fun or_(bX: Ulong, bY: Ulong, bZ: Ulong, bW: Ulong) = or(this, this, bX, bY, bZ, bW)
    fun or_(bX: Long, bY: Long, bZ: Long, bW: Long) = or(this, this, bX, bY, bZ, bW)
    infix fun or_(b: Vec4ul) = or(this, this, b.x, b.y, b.z, b.w)

    fun or(b: Ulong, res: Vec4ul) = or(res, this, b, b, b, b)
    fun or(b: Long, res: Vec4ul) = or(res, this, b, b, b, b)
    fun or(bX: Ulong, bY: Ulong, bZ: Ulong, bW: Ulong, res: Vec4ul) = or(res, this, bX, bY, bZ, bW)
    fun or(bX: Long, bY: Long, bZ: Long, bW: Long, res: Vec4ul) = or(res, this, bX, bY, bZ, bW)
    fun or(b: Vec4ul, res: Vec4ul) = or(res, this, b.x, b.y, b.z, b.w)


    infix fun xor(b: Ulong) = xor(Vec4ul(), this, b, b, b, b)
    infix fun xor(b: Long) = xor(Vec4ul(), this, b, b, b, b)
    fun xor(bX: Ulong, bY: Ulong, bZ: Ulong, bW: Ulong) = xor(Vec4ul(), this, bX, bY, bZ, bW)
    fun xor(bX: Long, bY: Long, bZ: Long, bW: Long) = xor(Vec4ul(), this, bX, bY, bZ, bW)
    fun xor(b: Vec4ul) = xor(Vec4ul(), this, b.x, b.y, b.z, b.w)

    infix fun xor_(b: Ulong) = xor(this, this, b, b, b, b)
    infix fun xor_(b: Long) = xor(this, this, b, b, b, b)
    fun xor_(bX: Ulong, bY: Ulong, bZ: Ulong, bW: Ulong) = xor(this, this, bX, bY, bZ, bW)
    fun xor_(bX: Long, bY: Long, bZ: Long, bW: Long) = xor(this, this, bX, bY, bZ, bW)
    infix fun xor_(b: Vec4ul) = xor(this, this, b.x, b.y, b.z, b.w)

    fun xor(b: Ulong, res: Vec4ul) = xor(res, this, b, b, b, b)
    fun xor(b: Long, res: Vec4ul) = xor(res, this, b, b, b, b)
    fun xor(bX: Ulong, bY: Ulong, bZ: Ulong, bW: Ulong, res: Vec4ul) = xor(res, this, bX, bY, bZ, bW)
    fun xor(bX: Long, bY: Long, bZ: Long, bW: Long, res: Vec4ul) = xor(res, this, bX, bY, bZ, bW)
    fun xor(b: Vec4ul, res: Vec4ul) = xor(res, this, b.x, b.y, b.z, b.w)


    infix fun shl(b: Int) = shl(Vec4ul(), this, b, b, b, b)
    fun shl(bX: Int, bY: Int, bZ: Int, bW: Int) = shl(Vec4ul(), this, bX, bY, bZ, bW)

    infix fun shl_(b: Int) = shl(this, this, b, b, b, b)
    fun shl_(bX: Int, bY: Int, bZ: Int, bW: Int) = shl(this, this, bX, bY, bZ, bW)

    fun shl(b: Int, res: Vec4ul) = shl(res, this, b, b, b, b)
    fun shl(bX: Int, bY: Int, bZ: Int, bW: Int, res: Vec4ul) = shl(res, this, bX, bY, bZ, bW)


    infix fun shr(b: Int) = shr(Vec4ul(), this, b, b, b, b)
    fun shr(bX: Int, bY: Int, bZ: Int, bW: Int) = shr(Vec4ul(), this, bX, bY, bZ, bW)

    infix fun shr_(b: Int) = shr(this, this, b, b, b, b)
    fun shr_(bX: Int, bY: Int, bZ: Int, bW: Int) = shr(this, this, bX, bY, bZ, bW)

    fun shr(b: Int, res: Vec4ul) = shr(res, this, b, b, b, b)
    fun shr(bX: Int, bY: Int, bZ: Int, bW: Int, res: Vec4ul) = shr(res, this, bX, bY, bZ, bW)


    fun inv(res: Vec4ul = Vec4ul()) = inv(res, this)
    fun inv_() = inv(this, this)


    // -- Generic bitwise operators --

    infix fun and(b: Number) = and(Vec4ul(), this, b.L, b.L, b.L, b.L)
    fun and(bX: Number, bY: Number, bZ: Number, bW: Number) = and(Vec4ul(), this, bX.L, bY.L, bZ.L, bW.L)
    fun and(b: Vec4t<Number>) = and(Vec4ul(), this, b.x.L, b.y.L, b.z.L, b.w.L)

    infix fun and_(b: Number) = and(this, this, b.L, b.L, b.L, b.L)
    fun and_(bX: Number, bY: Number, bZ: Number, bW: Number) = and(this, this, bX.L, bY.L, bZ.L, bW.L)
    infix fun and_(b: Vec4t<Number>) = and(this, this, b.x.L, b.y.L, b.z.L, b.w.L)

    fun and(b: Number, res: Vec4ul) = and(res, this, b.L, b.L, b.L, b.L)
    fun and(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4ul) = and(res, this, bX.L, bY.L, bZ.L, bW.L)
    fun and(b: Vec4t<Number>, res: Vec4ul) = and(res, this, b.x.L, b.y.L, b.z.L, b.w.L)


    infix fun or(b: Number) = or(Vec4ul(), this, b.L, b.L, b.L, b.L)
    fun or(bX: Number, bY: Number, bZ: Number, bW: Number) = or(Vec4ul(), this, bX.L, bY.L, bZ.L, bW.L)
    fun or(b: Vec4t<Number>) = or(Vec4ul(), this, b.x.L, b.y.L, b.z.L, b.w.L)

    infix fun or_(b: Number) = or(this, this, b.L, b.L, b.L, b.L)
    fun or_(bX: Number, bY: Number, bZ: Number, bW: Number) = or(this, this, bX.L, bY.L, bZ.L, bW.L)
    infix fun or_(b: Vec4t<Number>) = or(this, this, b.x.L, b.y.L, b.z.L, b.w.L)

    fun or(b: Number, res: Vec4ul) = or(res, this, b.L, b.L, b.L, b.L)
    fun or(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4ul) = or(res, this, bX.L, bY.L, bZ.L, bW.L)
    fun or(b: Vec4t<Number>, res: Vec4ul) = or(res, this, b.x.L, b.y.L, b.z.L, b.w.L)


    infix fun xor(b: Number) = xor(Vec4ul(), this, b.L, b.L, b.L, b.L)
    fun xor(bX: Number, bY: Number, bZ: Number, bW: Number) = xor(Vec4ul(), this, bX.L, bY.L, bZ.L, bW.L)
    fun xor(b: Vec4t<Number>) = xor(Vec4ul(), this, b.x.L, b.y.L, b.z.L, b.w.L)

    infix fun xor_(b: Number) = xor(this, this, b.L, b.L, b.L, b.L)
    fun xor_(bX: Number, bY: Number, bZ: Number, bW: Number) = xor(this, this, bX.L, bY.L, bZ.L, bW.L)
    infix fun xor_(b: Vec4t<Number>) = xor(this, this, b.x.L, b.y.L, b.z.L, b.w.L)

    fun xor(b: Number, res: Vec4ul) = xor(res, this, b.L, b.L, b.L, b.L)
    fun xor(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4ul) = xor(res, this, bX.L, bY.L, bZ.L, bW.L)
    fun xor(b: Vec4t<Number>, res: Vec4ul) = xor(res, this, b.x.L, b.y.L, b.z.L, b.w.L)


    infix fun shl(b: Number) = shl(Vec4ul(), this, b.L, b.L, b.L, b.L)
    fun shl(bX: Number, bY: Number, bZ: Number, bW: Number) = shl(Vec4ul(), this, bX.L, bY.L, bZ.L, bW.L)

    infix fun shl_(b: Number) = shl(this, this, b.L, b.L, b.L, b.L)
    fun shl_(bX: Number, bY: Number, bZ: Number, bW: Number) = shl(this, this, bX.L, bY.L, bZ.L, bW.L)

    fun shl(b: Number, res: Vec4ul) = shl(res, this, b.L, b.L, b.L, b.L)
    fun shl(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4ul) = shl(res, this, bX.L, bY.L, bZ.L, bW.L)


    infix fun shr(b: Number) = shr(Vec4ul(), this, b.L, b.L, b.L, b.L)
    fun shr(bX: Number, bY: Number, bZ: Number, bW: Number) = shr(Vec4ul(), this, bX.L, bY.L, bZ.L, bW.L)

    infix fun shr_(b: Number) = shr(this, this, b.L, b.L, b.L, b.L)
    fun shr_(bX: Number, bY: Number, bZ: Number, bW: Number) = shr(this, this, bX.L, bY.L, bZ.L, bW.L)

    fun shr(b: Number, res: Vec4ul) = shr(res, this, b.L, b.L, b.L, b.L)
    fun shr(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4ul) = shr(res, this, bX.L, bY.L, bZ.L, bW.L)
}