package vec._4

import main.BYTES
import main.b
import main.i
import vec.Vec2t
import vec.Vec3t
import vec.Vec4t
import vec._4.operators.vec4b_operators
import vec.bool.Vec2bool
import vec.bool.Vec3bool
import vec.bool.Vec4bool
import java.nio.*

/**
 * Created by elect on 09/10/16.
 */

data class Vec4b(override var x: Byte, override var y: Byte, override var z: Byte, override var w: Byte) : Vec4t<Byte>() {


    // -- Explicit basic, conversion other main.and conversion vector constructors --

    constructor() : this(0)

    constructor(v: Vec2t<out Number>) : this(v.x, v.y, 0, 1)
    constructor(v: Vec3t<out Number>) : this(v.x, v.y, v.z, 1)
    constructor(v: Vec4t<out Number>) : this(v.x, v.y, v.z, v.w)

    constructor(v: Vec2bool) : this(v.x.b, v.y.b, 0, 1)
    constructor(v: Vec3bool) : this(v.x.b, v.y.b, v.z.b, 1)
    constructor(v: Vec4bool) : this(v.x.b, v.y.b, v.z.b, v.w.b)

    constructor(bytes: ByteArray, index: Int = 0) : this(bytes[index], bytes[index + 1], bytes[index + 2], bytes[index + 3])
    constructor(chars: CharArray, index: Int = 0) : this(chars[index].b, chars[index + 1].b, chars[index + 2].b, chars[index + 3].b)
    constructor(shorts: ShortArray, index: Int = 0) : this(shorts[index], shorts[index + 1], shorts[index + 2], shorts[index + 3])
    constructor(ints: IntArray, index: Int = 0) : this(ints[index], ints[index + 1], ints[index + 2], ints[index + 3])
    constructor(longs: LongArray, index: Int = 0) : this(longs[index], longs[index + 1], longs[index + 2], longs[index + 3])
    constructor(floats: FloatArray, index: Int = 0) : this(floats[index], floats[index + 1], floats[index + 2], floats[index + 3])
    constructor(doubles: DoubleArray, index: Int = 0) : this(doubles[index], doubles[index + 1], doubles[index + 2], doubles[index + 3])
    constructor(booleans: BooleanArray, index: Int = 0) : this(booleans[index].b, booleans[index + 1].b, booleans[index + 2].b, booleans[index + 3].b)

    constructor(numbers: Array<out Number>, index: Int = 0) : this(numbers[index], numbers[index + 1], numbers[index + 2], numbers[index + 3])
    constructor(chars: Array<Char>, index: Int = 0) : this(chars[index].b, chars[index + 1].b, chars[index + 2].b, chars[index + 3].b)
    constructor(booleans: Array<Boolean>, index: Int = 0) : this(booleans[index].b, booleans[index + 1].b, booleans[index + 2].b, booleans[index + 3].b)

    constructor(list: List<Any>, index: Int = 0) : this() {
        put(list, index)
    }

    constructor(bytes: ByteBuffer, index: Int = bytes.position()) : this(bytes[index], bytes[index + 1], bytes[index + 2], bytes[index + 3])
    constructor(chars: CharBuffer, index: Int = chars.position()) : this(chars[index].b, chars[index + 1].b, chars[index + 2].b, chars[index + 3].b)
    constructor(shorts: ShortBuffer, index: Int = shorts.position()) : this(shorts[index], shorts[index + 1], shorts[index + 2], shorts[index + 3])
    constructor(ints: IntBuffer, index: Int = ints.position()) : this(ints[index], ints[index + 1], ints[index + 2], ints[index + 3])
    constructor(longs: LongBuffer, index: Int = longs.position()) : this(longs[index], longs[index + 1], longs[index + 2], longs[index + 3])
    constructor(floats: FloatBuffer, index: Int = floats.position()) : this(floats[index], floats[index + 1], floats[index + 2], floats[index + 3])
    constructor(doubles: DoubleBuffer, index: Int = doubles.position()) : this(doubles[index], doubles[index + 1], doubles[index + 2], doubles[index + 3])

    constructor(s: Number) : this(s, s, s, s)
    constructor(x: Number, y: Number, z: Number, w: Number) : this(x.b, y.b, z.b, w.b)


    override fun put(x: Number, y: Number, z: Number, w: Number): Vec4b {
        this.x = x.b
        this.y = y.b
        this.z = z.b
        this.w = w.b
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
        0 -> x = s.b
        1 -> y = s.b
        2 -> z = s.b
        3 -> w = s.b
        else -> throw ArrayIndexOutOfBoundsException()
    }


    companion object : vec4b_operators {
        @JvmField val length = 4
        @JvmField val SIZE = length * Byte.BYTES
    }


    // -- Unary arithmetic operators --

    operator fun unaryPlus() = this

    operator fun unaryMinus() = Vec4b(-x.b, -y.b, -z.b, -w.b)

    // -- Increment main.and decrement operators --

    operator fun inc(res: Vec4b = Vec4b()) = add(res, this, 1, 1, 1, 1)
    fun inc_() = add(this, this, 1, 1, 1, 1)


    operator fun dec(res: Vec4b = Vec4b()) = sub(res, this, 1, 1, 1, 1)
    fun dec_() = sub(this, this, 1, 1, 1, 1)


    // -- Specific binary arithmetic operators --

    operator fun plus(b: Byte) = add(Vec4b(), this, b, b, b, b)
    operator fun plus(b: Int) = add(Vec4b(), this, b, b, b, b)
    operator fun plus(b: Vec4b) = add(Vec4b(), this, b.x, b.y, b.z, b.w)

    fun add(bX: Byte, bY: Byte, bZ: Byte, bW: Byte, res: Vec4b = Vec4b()) = add(res, this, bX, bY, bZ, bW)
    fun add(bX: Int, bY: Int, bZ: Int, bW: Int, res: Vec4b = Vec4b()) = add(res, this, bX, bY, bZ, bW)
    fun add(b: Byte, res: Vec4b = Vec4b()) = add(res, this, b, b, b, b)
    fun add(b: Int, res: Vec4b = Vec4b()) = add(res, this, b, b, b, b)
    fun add(b: Vec4b, res: Vec4b = Vec4b()) = add(res, this, b.x, b.y, b.z, b.w)

    fun add_(bX: Byte, bY: Byte, bZ: Byte, bW: Byte) = add(this, this, bX, bY, bZ, bW)
    fun add_(bX: Int, bY: Int, bZ: Int, bW: Int) = add(this, this, bX, bY, bZ, bW)
    infix fun add_(b: Byte) = add(this, this, b, b, b, b)
    infix fun add_(b: Int) = add(this, this, b, b, b, b)
    infix fun add_(b: Vec4b) = add(this, this, b.x, b.y, b.z, b.w)


    operator fun minus(b: Byte) = sub(Vec4b(), this, b, b, b, b)
    operator fun minus(b: Int) = sub(Vec4b(), this, b, b, b, b)
    operator fun minus(b: Vec4b) = sub(Vec4b(), this, b.x, b.y, b.z, b.w)

    fun sub(bX: Byte, bY: Byte, bZ: Byte, bW: Byte, res: Vec4b = Vec4b()) = sub(res, this, bX, bY, bZ, bW)
    fun sub(bX: Int, bY: Int, bZ: Int, bW: Int, res: Vec4b = Vec4b()) = sub(res, this, bX, bY, bZ, bW)
    fun sub(b: Byte, res: Vec4b = Vec4b()) = sub(res, this, b, b, b, b)
    fun sub(b: Int, res: Vec4b = Vec4b()) = sub(res, this, b, b, b, b)
    fun sub(b: Vec4b, res: Vec4b = Vec4b()) = sub(res, this, b.x, b.y, b.z, b.w)

    fun sub_(bX: Byte, bY: Byte, bZ: Byte, bW: Byte) = sub(this, this, bX, bY, bZ, bW)
    fun sub_(bX: Int, bY: Int, bZ: Int, bW: Int) = sub(this, this, bX, bY, bZ, bW)
    infix fun sub_(b: Byte) = sub(this, this, b, b, b, b)
    infix fun sub_(b: Int) = sub(this, this, b, b, b, b)
    infix fun sub_(b: Vec4b) = sub(this, this, b.x, b.y, b.z, b.w)


    operator fun times(b: Byte) = mul(Vec4b(), this, b, b, b, b)
    operator fun times(b: Int) = mul(Vec4b(), this, b, b, b, b)
    operator fun times(b: Vec4b) = mul(Vec4b(), this, b.x, b.y, b.z, b.w)

    fun mul(bX: Byte, bY: Byte, bZ: Byte, bW: Byte, res: Vec4b = Vec4b()) = mul(res, this, bX, bY, bZ, bW)
    fun mul(bX: Int, bY: Int, bZ: Int, bW: Int, res: Vec4b = Vec4b()) = mul(res, this, bX, bY, bZ, bW)
    fun mul(b: Byte, res: Vec4b = Vec4b()) = mul(res, this, b, b, b, b)
    fun mul(b: Int, res: Vec4b = Vec4b()) = mul(res, this, b, b, b, b)
    fun mul(b: Vec4b, res: Vec4b = Vec4b()) = mul(res, this, b.x, b.y, b.z, b.w)

    fun mul_(bX: Byte, bY: Byte, bZ: Byte, bW: Byte) = mul(this, this, bX, bY, bZ, bW)
    fun mul_(bX: Int, bY: Int, bZ: Int, bW: Int) = mul(this, this, bX, bY, bZ, bW)
    infix fun mul_(b: Byte) = mul(this, this, b, b, b, b)
    infix fun mul_(b: Int) = mul(this, this, b, b, b, b)
    infix fun mul_(b: Vec4b) = mul(this, this, b.x, b.y, b.z, b.w)


    operator fun div(b: Byte) = div(Vec4b(), this, b, b, b, b)
    operator fun div(b: Int) = div(Vec4b(), this, b, b, b, b)
    operator fun div(b: Vec4b) = div(Vec4b(), this, b.x, b.y, b.z, b.w)

    fun div(bX: Byte, bY: Byte, bZ: Byte, bW: Byte, res: Vec4b = Vec4b()) = div(res, this, bX, bY, bZ, bW)
    fun div(bX: Int, bY: Int, bZ: Int, bW: Int, res: Vec4b = Vec4b()) = div(res, this, bX, bY, bZ, bW)
    fun div(b: Byte, res: Vec4b) = div(res, this, b, b, b, b)
    fun div(b: Int, res: Vec4b) = div(res, this, b, b, b, b)
    fun div(b: Vec4b, res: Vec4b) = div(res, this, b.x, b.y, b.z, b.w)

    fun div_(bX: Byte, bY: Byte, bZ: Byte, bW: Byte) = div(this, this, bX, bY, bZ, bW)
    fun div_(bX: Int, bY: Int, bZ: Int, bW: Int) = div(this, this, bX, bY, bZ, bW)
    infix fun div_(b: Byte) = div(this, this, b, b, b, b)
    infix fun div_(b: Int) = div(this, this, b, b, b, b)
    infix fun div_(b: Vec4b) = div(this, this, b.x, b.y, b.z, b.w)


    operator fun rem(b: Byte) = rem(Vec4b(), this, b, b, b, b)
    operator fun rem(b: Int) = rem(Vec4b(), this, b, b, b, b)
    operator fun rem(b: Vec4b) = rem(Vec4b(), this, b.x, b.y, b.z, b.w)

    fun rem(bX: Byte, bY: Byte, bZ: Byte, bW: Byte, res: Vec4b = Vec4b()) = rem(res, this, bX, bY, bZ, bW)
    fun rem(bX: Int, bY: Int, bZ: Int, bW: Int, res: Vec4b = Vec4b()) = rem(res, this, bX, bY, bZ, bW)
    fun rem(b: Byte, res: Vec4b) = rem(res, this, b, b, b, b)
    fun rem(b: Int, res: Vec4b) = rem(res, this, b, b, b, b)
    fun rem(b: Vec4b, res: Vec4b) = rem(res, this, b.x, b.y, b.z, b.w)

    fun rem_(bX: Byte, bY: Byte, bZ: Byte, bW: Byte) = rem(this, this, bX, bY, bZ, bW)
    fun rem_(bX: Int, bY: Int, bZ: Int, bW: Int) = rem(this, this, bX, bY, bZ, bW)
    infix fun rem_(b: Byte) = rem(this, this, b, b, b, b)
    infix fun rem_(b: Int) = rem(this, this, b, b, b, b)
    infix fun rem_(b: Vec4b) = rem(this, this, b.x, b.y, b.z, b.w)


    // -- Generic binary arithmetic operators --

    operator fun plus(b: Number) = add(Vec4b(), this, b.i, b.i, b.i, b.i)
    operator fun plus(b: Vec4t<Number>) = add(Vec4b(), this, b.x.i, b.y.i, b.z.i, b.w.i)

    fun add(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4b = Vec4b()) = add(res, this, bX.i, bY.i, bZ.i, bW.i)
    fun add(b: Number, res: Vec4b = Vec4b()) = add(res, this, b.i, b.i, b.i, b.i)
    fun add(b: Vec4t<Number>, res: Vec4b = Vec4b()) = add(res, this, b.x.i, b.y.i, b.z.i, b.w.i)

    fun add_(bX: Number, bY: Number, bZ: Number, bW: Number) = add(this, this, bX.i, bY.i, bZ.i, bW.i)
    infix fun add_(b: Number) = add(this, this, b.i, b.i, b.i, b.i)
    infix fun add_(b: Vec4t<Number>) = add(this, this, b.x.i, b.y.i, b.z.i, b.w.i)


    operator fun minus(b: Number) = sub(Vec4b(), this, b.i, b.i, b.i, b.i)
    operator fun minus(b: Vec4t<Number>) = sub(Vec4b(), this, b.x.i, b.y.i, b.z.i, b.w.i)

    fun sub(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4b = Vec4b()) = sub(res, this, bX.i, bY.i, bZ.i, bW.i)
    fun sub(b: Number, res: Vec4b = Vec4b()) = sub(res, this, b.i, b.i, b.i, b.i)
    fun sub(b: Vec4t<Number>, res: Vec4b = Vec4b()) = sub(res, this, b.x.i, b.y.i, b.z.i, b.w.i)

    fun sub_(bX: Number, bY: Number, bZ: Number, bW: Number) = sub(this, this, bX.i, bY.i, bZ.i, bW.i)
    infix fun sub_(b: Number) = sub(this, this, b.i, b.i, b.i, b.i)
    infix fun sub_(b: Vec4t<Number>) = sub(this, this, b.x.i, b.y.i, b.z.i, b.w.i)


    operator fun times(b: Number) = mul(Vec4b(), this, b.i, b.i, b.i, b.i)
    operator fun times(b: Vec4t<Number>) = mul(Vec4b(), this, b.x.i, b.y.i, b.z.i, b.w.i)

    fun mul(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4b = Vec4b()) = mul(res, this, bX.i, bY.i, bZ.i, bW.i)
    fun mul(b: Number, res: Vec4b = Vec4b()) = mul(res, this, b.i, b.i, b.i, b.i)
    fun mul(b: Vec4t<Number>, res: Vec4b = Vec4b()) = mul(res, this, b.x.i, b.y.i, b.z.i, b.w.i)

    fun mul_(bX: Number, bY: Number, bZ: Number, bW: Number) = mul(this, this, bX.i, bY.i, bZ.i, bW.i)
    infix fun mul_(b: Number) = mul(this, this, b.i, b.i, b.i, b.i)
    infix fun mul_(b: Vec4t<Number>) = mul(this, this, b.x.i, b.y.i, b.z.i, b.w.i)


    operator fun div(b: Number) = div(Vec4b(), this, b.i, b.i, b.i, b.i)
    operator fun div(b: Vec4t<Number>) = div(Vec4b(), this, b.x.i, b.y.i, b.z.i, b.w.i)

    fun div(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4b = Vec4b()) = div(res, this, bX.i, bY.i, bZ.i, bW.i)
    fun div(b: Number, res: Vec4b = Vec4b()) = div(res, this, b.i, b.i, b.i, b.i)
    fun div(b: Vec4t<Number>, res: Vec4b = Vec4b()) = div(res, this, b.x.i, b.y.i, b.z.i, b.w.i)

    fun div_(bX: Number, bY: Number, bZ: Number, bW: Number) = div(this, this, bX.i, bY.i, bZ.i, bW.i)
    infix fun div_(b: Number) = div(this, this, b.i, b.i, b.i, b.i)
    infix fun div_(b: Vec4t<Number>) = div(this, this, b.x.i, b.y.i, b.z.i, b.w.i)


    operator fun rem(b: Number) = rem(Vec4b(), this, b.i, b.i, b.i, b.i)
    operator fun rem(b: Vec4t<Number>) = rem(Vec4b(), this, b.x.i, b.y.i, b.z.i, b.w.i)

    fun rem(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4b = Vec4b()) = rem(res, this, bX.i, bY.i, bZ.i, bW.i)
    fun rem(b: Number, res: Vec4b = Vec4b()) = rem(res, this, b.i, b.i, b.i, b.i)
    fun rem(b: Vec4t<Number>, res: Vec4b = Vec4b()) = rem(res, this, b.x.i, b.y.i, b.z.i, b.w.i)

    fun rem_(bX: Number, bY: Number, bZ: Number, bW: Number) = rem(this, this, bX.i, bY.i, bZ.i, bW.i)
    infix fun rem_(b: Number) = rem(this, this, b.i, b.i, b.i, b.i)
    infix fun rem_(b: Vec4t<Number>) = rem(this, this, b.x.i, b.y.i, b.z.i, b.w.i)


    // -- Specific bitwise operators --

    infix fun and(b: Byte) = and(Vec4b(), this, b, b, b, b)
    infix fun and(b: Int) = and(Vec4b(), this, b, b, b, b)
    infix fun and(b: Vec4b) = and(Vec4b(), this, b.x, b.y, b.z, b.w)

    infix fun and_(b: Byte) = and(this, this, b, b, b, b)
    infix fun and_(b: Int) = and(this, this, b, b, b, b)
    infix fun and_(b: Vec4b) = and(this, this, b.x, b.y, b.z, b.w)

    fun and(b: Byte, res: Vec4b) = and(res, this, b, b, b, b)
    fun and(b: Int, res: Vec4b) = and(res, this, b, b, b, b)
    fun and(b: Vec4b, res: Vec4b) = and(res, this, b.x, b.y, b.z, b.w)

    fun and(bX: Byte, bY: Byte, bZ: Byte, bW: Byte, res: Vec4b = Vec4b()) = and(res, this, bX, bY, bZ, bW)
    fun and(bX: Int, bY: Int, bZ: Int, bW: Int, res: Vec4b = Vec4b()) = and(res, this, bX, bY, bZ, bW)

    fun and_(bX: Byte, bY: Byte, bZ: Byte, bW: Byte) = and(this, this, bX, bY, bZ, bW)
    fun and_(bX: Int, bY: Int, bZ: Int, bW: Int) = and(this, this, bX, bY, bZ, bW)


    infix fun or(b: Byte) = or(Vec4b(), this, b, b, b, b)
    infix fun or(b: Int) = or(Vec4b(), this, b, b, b, b)
    infix fun or(b: Vec4b) = or(Vec4b(), this, b.x, b.y, b.z, b.w)

    infix fun or_(b: Byte) = or(this, this, b, b, b, b)
    infix fun or_(b: Int) = or(this, this, b, b, b, b)
    infix fun or_(b: Vec4b) = or(this, this, b.x, b.y, b.z, b.w)

    fun or(b: Byte, res: Vec4b) = or(res, this, b, b, b, b)
    fun or(b: Int, res: Vec4b) = or(res, this, b, b, b, b)
    fun or(b: Vec4b, res: Vec4b) = or(res, this, b.x, b.y, b.z, b.w)

    fun or(bX: Byte, bY: Byte, bZ: Byte, bW: Byte, res: Vec4b = Vec4b()) = or(res, this, bX, bY, bZ, bW)
    fun or(bX: Int, bY: Int, bZ: Int, bW: Int, res: Vec4b = Vec4b()) = or(res, this, bX, bY, bZ, bW)

    fun or_(bX: Byte, bY: Byte, bZ: Byte, bW: Byte) = or(this, this, bX, bY, bZ, bW)
    fun or_(bX: Int, bY: Int, bZ: Int, bW: Int) = or(this, this, bX, bY, bZ, bW)


    infix fun xor(b: Byte) = xor(Vec4b(), this, b, b, b, b)
    infix fun xor(b: Int) = xor(Vec4b(), this, b, b, b, b)
    infix fun xor(b: Vec4b) = xor(Vec4b(), this, b.x, b.y, b.z, b.w)

    infix fun xor_(b: Byte) = xor(this, this, b, b, b, b)
    infix fun xor_(b: Int) = xor(this, this, b, b, b, b)
    infix fun xor_(b: Vec4b) = xor(this, this, b.x, b.y, b.z, b.w)

    fun xor(b: Byte, res: Vec4b) = xor(res, this, b, b, b, b)
    fun xor(b: Int, res: Vec4b) = xor(res, this, b, b, b, b)
    fun xor(b: Vec4b, res: Vec4b) = xor(res, this, b.x, b.y, b.z, b.w)

    fun xor(bX: Byte, bY: Byte, bZ: Byte, bW: Byte, res: Vec4b = Vec4b()) = xor(res, this, bX, bY, bZ, bW)
    fun xor(bX: Int, bY: Int, bZ: Int, bW: Int, res: Vec4b = Vec4b()) = xor(res, this, bX, bY, bZ, bW)

    fun xor_(bX: Byte, bY: Byte, bZ: Byte, bW: Byte) = xor(this, this, bX, bY, bZ, bW)
    fun xor_(bX: Int, bY: Int, bZ: Int, bW: Int) = xor(this, this, bX, bY, bZ, bW)


    infix fun shl(b: Byte) = shl(Vec4b(), this, b, b, b, b)
    infix fun shl(b: Int) = shl(Vec4b(), this, b, b, b, b)
    infix fun shl(b: Vec4b) = shl(Vec4b(), this, b.x, b.y, b.z, b.w)

    infix fun shl_(b: Byte) = shl(this, this, b, b, b, b)
    infix fun shl_(b: Int) = shl(this, this, b, b, b, b)
    infix fun shl_(b: Vec4b) = shl(this, this, b.x, b.y, b.z, b.w)

    fun shl(b: Byte, res: Vec4b) = shl(res, this, b, b, b, b)
    fun shl(b: Int, res: Vec4b) = shl(res, this, b, b, b, b)
    fun shl(b: Vec4b, res: Vec4b) = shl(res, this, b.x, b.y, b.z, b.w)

    fun shl(bX: Byte, bY: Byte, bZ: Byte, bW: Byte, res: Vec4b = Vec4b()) = shl(res, this, bX, bY, bZ, bW)
    fun shl(bX: Int, bY: Int, bZ: Int, bW: Int, res: Vec4b = Vec4b()) = shl(res, this, bX, bY, bZ, bW)

    fun shl_(bX: Byte, bY: Byte, bZ: Byte, bW: Byte) = shl(this, this, bX, bY, bZ, bW)
    fun shl_(bX: Int, bY: Int, bZ: Int, bW: Int) = shl(this, this, bX, bY, bZ, bW)


    infix fun shr(b: Byte) = shr(Vec4b(), this, b, b, b, b)
    infix fun shr(b: Int) = shr(Vec4b(), this, b, b, b, b)
    infix fun shr(b: Vec4b) = shr(Vec4b(), this, b.x, b.y, b.z, b.w)

    infix fun shr_(b: Byte) = shr(this, this, b, b, b, b)
    infix fun shr_(b: Int) = shr(this, this, b, b, b, b)
    infix fun shr_(b: Vec4b) = shr(this, this, b.x, b.y, b.z, b.w)

    fun shr(b: Byte, res: Vec4b) = shr(res, this, b, b, b, b)
    fun shr(b: Int, res: Vec4b) = shr(res, this, b, b, b, b)
    fun shr(b: Vec4b, res: Vec4b) = shr(res, this, b.x, b.y, b.z, b.w)

    fun shr(bX: Byte, bY: Byte, bZ: Byte, bW: Byte, res: Vec4b = Vec4b()) = shr(res, this, bX, bY, bZ, bW)
    fun shr(bX: Int, bY: Int, bZ: Int, bW: Int, res: Vec4b = Vec4b()) = shr(res, this, bX, bY, bZ, bW)

    fun shr_(bX: Byte, bY: Byte, bZ: Byte, bW: Byte) = shr(this, this, bX, bY, bZ, bW)
    fun shr_(bX: Int, bY: Int, bZ: Int, bW: Int) = shr(this, this, bX, bY, bZ, bW)


    fun inv(res: Vec4b = Vec4b()) = inv(res, this)
    fun inv_() = inv(this, this)


    // -- Generic bitwise operators --

    infix fun and(b: Number) = and(Vec4b(), this, b.b, b.b, b.b, b.b)
    infix fun and(b: Vec4t<Number>) = and(Vec4b(), this, b.x.b, b.y.b, b.z.b, b.w.b)

    infix fun and_(b: Number) = and(this, this, b.b, b.b, b.b, b.b)
    infix fun and_(b: Vec4t<Number>) = and(this, this, b.x.b, b.y.b, b.z.b, b.w.b)

    fun and(b: Number, res: Vec4b = Vec4b()) = and(res, this, b.b, b.b, b.b, b.b)
    fun and(b: Vec4t<Number>, res: Vec4b = Vec4b()) = and(res, this, b.x.b, b.y.b, b.z.b, b.w.b)

    fun and(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4b = Vec4b()) = and(res, this, bX.b, bY.b, bZ.b, bW.b)

    fun and_(bX: Number, bY: Number, bZ: Number, bW: Number) = and(this, this, bX.b, bY.b, bZ.b, bW.b)


    infix fun or(b: Number) = or(Vec4b(), this, b.b, b.b, b.b, b.b)
    infix fun or(b: Vec4t<Number>) = or(Vec4b(), this, b.x.b, b.y.b, b.z.b, b.w.b)

    infix fun or_(b: Number) = or(this, this, b.b, b.b, b.b, b.b)
    infix fun or_(b: Vec4t<Number>) = or(this, this, b.x.b, b.y.b, b.z.b, b.w.b)

    fun or(b: Number, res: Vec4b = Vec4b()) = or(res, this, b.b, b.b, b.b, b.b)
    fun or(b: Vec4t<Number>, res: Vec4b = Vec4b()) = or(res, this, b.x.b, b.y.b, b.z.b, b.w.b)

    fun or(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4b = Vec4b()) = or(res, this, bX.b, bY.b, bZ.b, bW.b)

    fun or_(bX: Number, bY: Number, bZ: Number, bW: Number) = or(this, this, bX.b, bY.b, bZ.b, bW.b)


    infix fun xor(b: Number) = xor(Vec4b(), this, b.b, b.b, b.b, b.b)
    infix fun xor(b: Vec4t<Number>) = xor(Vec4b(), this, b.x.b, b.y.b, b.z.b, b.w.b)

    infix fun xor_(b: Number) = xor(this, this, b.b, b.b, b.b, b.b)
    infix fun xor_(b: Vec4t<Number>) = xor(this, this, b.x.b, b.y.b, b.z.b, b.w.b)

    fun xor(b: Number, res: Vec4b = Vec4b()) = xor(res, this, b.b, b.b, b.b, b.b)
    fun xor(b: Vec4t<Number>, res: Vec4b = Vec4b()) = xor(res, this, b.x.b, b.y.b, b.z.b, b.w.b)

    fun xor(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4b = Vec4b()) = xor(res, this, bX.b, bY.b, bZ.b, bW.b)

    fun xor_(bX: Number, bY: Number, bZ: Number, bW: Number) = xor(this, this, bX.b, bY.b, bZ.b, bW.b)


    infix fun shl(b: Number) = shl(Vec4b(), this, b.b, b.b, b.b, b.b)
    infix fun shl(b: Vec4t<Number>) = shl(Vec4b(), this, b.x.b, b.y.b, b.z.b, b.w.b)

    infix fun shl_(b: Number) = shl(this, this, b.b, b.b, b.b, b.b)
    infix fun shl_(b: Vec4t<Number>) = shl(this, this, b.x.b, b.y.b, b.z.b, b.w.b)

    fun shl(b: Number, res: Vec4b = Vec4b()) = shl(res, this, b.b, b.b, b.b, b.b)
    fun shl(b: Vec4t<Number>, res: Vec4b = Vec4b()) = shl(res, this, b.x.b, b.y.b, b.z.b, b.w.b)

    fun shl(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4b = Vec4b()) = shl(res, this, bX.b, bY.b, bZ.b, bW.b)

    fun shl_(bX: Number, bY: Number, bZ: Number, bW: Number) = shl(this, this, bX.b, bY.b, bZ.b, bW.b)


    infix fun shr(b: Number) = shr(Vec4b(), this, b.b, b.b, b.b, b.b)
    infix fun shr(b: Vec4t<Number>) = shr(Vec4b(), this, b.x.b, b.y.b, b.z.b, b.w.b)

    infix fun shr_(b: Number) = shr(this, this, b.b, b.b, b.b, b.b)
    infix fun shr_(b: Vec4t<Number>) = shr(this, this, b.x.b, b.y.b, b.z.b, b.w.b)

    fun shr(b: Number, res: Vec4b = Vec4b()) = shr(res, this, b.b, b.b, b.b, b.b)
    fun shr(b: Vec4t<Number>, res: Vec4b = Vec4b()) = shr(res, this, b.x.b, b.y.b, b.z.b, b.w.b)

    fun shr(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4b = Vec4b()) = shr(res, this, bX.b, bY.b, bZ.b, bW.b)

    fun shr_(bX: Number, bY: Number, bZ: Number, bW: Number) = shr(this, this, bX.b, bY.b, bZ.b, bW.b)
}