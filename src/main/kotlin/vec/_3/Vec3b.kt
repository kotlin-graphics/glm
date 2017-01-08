package vec._3

import b
import i
import vec.Vec2t
import vec.Vec3t
import vec.Vec4t
import vec._3.operators.vec3b_operators
import vec.bool.Vec2bool
import vec.bool.Vec3bool
import vec.bool.Vec4bool
import java.nio.*

/**
 * Created by elect on 08/10/16.
 */

data class Vec3b(override var x: Byte, override var y: Byte, override var z: Byte) : Vec3t<Byte>() {

    // -- Explicit basic, conversion other and conversion vector constructors --

    constructor() : this(0)

    constructor(v: Vec2t<out Number>) : this(v.x, v.y, 0)
    constructor(v: Vec3t<out Number>) : this(v.x, v.y, v.z)
    constructor(v: Vec4t<out Number>) : this(v.x, v.y, v.z)

    constructor(v: Vec2bool) : this(v.x.b, v.y.b, 0)
    constructor(v: Vec3bool) : this(v.x.b, v.y.b, v.z.b)
    constructor(v: Vec4bool) : this(v.x.b, v.y.b, v.z.b)

    constructor(bytes: ByteArray, index: Int = 0) : this(bytes[index], bytes[index + 1], bytes[index + 2])
    constructor(chars: CharArray, index: Int = 0) : this(chars[index].b, chars[index + 1].b, chars[index + 2].b)
    constructor(shorts: ShortArray, index: Int = 0) : this(shorts[index], shorts[index + 1], shorts[index + 2])
    constructor(ints: IntArray, index: Int = 0) : this(ints[index], ints[index + 1], ints[index + 2])
    constructor(longs: LongArray, index: Int = 0) : this(longs[index], longs[index + 1], longs[index + 2])
    constructor(floats: FloatArray, index: Int = 0) : this(floats[index], floats[index + 1], floats[index + 2])
    constructor(doubles: DoubleArray, index: Int = 0) : this(doubles[index], doubles[index + 1], doubles[index + 2])
    constructor(booleans: BooleanArray, index: Int = 0) : this(booleans[index].b, booleans[index + 1].b, booleans[index + 2].b)

    constructor(numbers: Array<out Number>, index: Int = 0) : this(numbers[index], numbers[index + 1], numbers[index + 2])
    constructor(chars: Array<Char>, index: Int = 0) : this(chars[index].b, chars[index + 1].b, chars[index + 2].b)
    constructor(booleans: Array<Boolean>, index: Int = 0) : this(booleans[index].b, booleans[index + 1].b, booleans[index + 2].b)

    constructor(list: List<Any>, index: Int = 0) : this() {
        Set(list, index)
    }

    constructor(bytes: ByteBuffer, index: Int = bytes.position()) : this(bytes[index], bytes[index + 1], bytes[index + 2])
    constructor(chars: CharBuffer, index: Int = chars.position()) : this(chars[index].b, chars[index + 1].b, chars[index + 2].b)
    constructor(shorts: ShortBuffer, index: Int = shorts.position()) : this(shorts[index], shorts[index + 1], shorts[index + 2])
    constructor(ints: IntBuffer, index: Int = ints.position()) : this(ints[index], ints[index + 1], ints[index + 2])
    constructor(longs: LongBuffer, index: Int = longs.position()) : this(longs[index], longs[index + 1], longs[index + 2])
    constructor(floats: FloatBuffer, index: Int = floats.position()) : this(floats[index], floats[index + 1], floats[index + 2])
    constructor(doubles: DoubleBuffer, index: Int = doubles.position()) : this(doubles[index], doubles[index + 1], doubles[index + 2])

    constructor(s: Number) : this(s, s, s)
    constructor(x: Number, y: Number, z: Number) : this(x.b, y.b, z.b)


    override fun Set(x: Number, y: Number, z: Number): Vec3b {
        this.x = x.b
        this.y = y.b
        this.z = z.b
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
        0 -> x = s.b
        1 -> y = s.b
        2 -> z = s.b
        else -> throw ArrayIndexOutOfBoundsException()
    }


    companion object : vec3b_operators


    // -- Unary arithmetic operators --

    operator fun unaryPlus() = this

    operator fun unaryMinus() = Vec3b(-x.b, -y.b, -z.b)

    // -- Increment and decrement operators --

    operator fun inc(res: Vec3b = Vec3b()) = add(res, this, 1, 1, 1)
    fun inc_() = add(this, this, 1, 1, 1)


    operator fun dec(res: Vec3b = Vec3b()) = sub(res, this, 1, 1, 1)
    fun dec_() = sub(this, this, 1, 1, 1)


    // -- Specific binary arithmetic operators --

    operator fun plus(b: Byte) = add(Vec3b(), this, b, b, b)
    operator fun plus(b: Int) = add(Vec3b(), this, b, b, b)
    operator fun plus(b: Vec3b) = add(Vec3b(), this, b.x, b.y, b.z)

    fun add(bX: Byte, bY: Byte, bZ: Byte, res: Vec3b = Vec3b()) = add(res, this, bX, bY, bZ)
    fun add(bX: Int, bY: Int, bZ: Int, res: Vec3b = Vec3b()) = add(res, this, bX, bY, bZ)
    fun add(b: Byte, res: Vec3b = Vec3b()) = add(res, this, b, b, b)
    fun add(b: Int, res: Vec3b = Vec3b()) = add(res, this, b, b, b)
    fun add(b: Vec3b, res: Vec3b = Vec3b()) = add(res, this, b.x, b.y, b.z)

    fun add_(bX: Byte, bY: Byte, bZ: Byte) = add(this, this, bX, bY, bZ)
    fun add_(bX: Int, bY: Int, bZ: Int) = add(this, this, bX, bY, bZ)
    infix fun add_(b: Byte) = add(this, this, b, b, b)
    infix fun add_(b: Int) = add(this, this, b, b, b)
    infix fun add_(b: Vec3b) = add(this, this, b.x, b.y, b.z)


    operator fun minus(b: Byte) = sub(Vec3b(), this, b, b, b)
    operator fun minus(b: Int) = sub(Vec3b(), this, b, b, b)
    operator fun minus(b: Vec3b) = sub(Vec3b(), this, b.x, b.y, b.z)

    fun sub(bX: Byte, bY: Byte, bZ: Byte, res: Vec3b = Vec3b()) = sub(res, this, bX, bY, bZ)
    fun sub(bX: Int, bY: Int, bZ: Int, res: Vec3b = Vec3b()) = sub(res, this, bX, bY, bZ)
    fun sub(b: Byte, res: Vec3b = Vec3b()) = sub(res, this, b, b, b)
    fun sub(b: Int, res: Vec3b = Vec3b()) = sub(res, this, b, b, b)
    fun sub(b: Vec3b, res: Vec3b = Vec3b()) = sub(res, this, b.x, b.y, b.z)

    fun sub_(bX: Byte, bY: Byte, bZ: Byte) = sub(this, this, bX, bY, bZ)
    fun sub_(bX: Int, bY: Int, bZ: Int) = sub(this, this, bX, bY, bZ)
    infix fun sub_(b: Byte) = sub(this, this, b, b, b)
    infix fun sub_(b: Int) = sub(this, this, b, b, b)
    infix fun sub_(b: Vec3b) = sub(this, this, b.x, b.y, b.z)


    operator fun times(b: Byte) = mul(Vec3b(), this, b, b, b)
    operator fun times(b: Int) = mul(Vec3b(), this, b, b, b)
    operator fun times(b: Vec3b) = mul(Vec3b(), this, b.x, b.y, b.z)

    fun mul(bX: Byte, bY: Byte, bZ: Byte, res: Vec3b = Vec3b()) = mul(res, this, bX, bY, bZ)
    fun mul(bX: Int, bY: Int, bZ: Int, res: Vec3b = Vec3b()) = mul(res, this, bX, bY, bZ)
    fun mul(b: Byte, res: Vec3b = Vec3b()) = mul(res, this, b, b, b)
    fun mul(b: Int, res: Vec3b = Vec3b()) = mul(res, this, b, b, b)
    fun mul(b: Vec3b, res: Vec3b = Vec3b()) = mul(res, this, b.x, b.y, b.z)

    fun mul_(bX: Byte, bY: Byte, bZ: Byte) = mul(this, this, bX, bY, bZ)
    fun mul_(bX: Int, bY: Int, bZ: Int) = mul(this, this, bX, bY, bZ)
    infix fun mul_(b: Byte) = mul(this, this, b, b, b)
    infix fun mul_(b: Int) = mul(this, this, b, b, b)
    infix fun mul_(b: Vec3b) = mul(this, this, b.x, b.y, b.z)


    operator fun div(b: Byte) = div(Vec3b(), this, b, b, b)
    operator fun div(b: Int) = div(Vec3b(), this, b, b, b)
    operator fun div(b: Vec3b) = div(Vec3b(), this, b.x, b.y, b.z)

    fun div(bX: Byte, bY: Byte, bZ: Byte, res: Vec3b = Vec3b()) = div(res, this, bX, bY, bZ)
    fun div(bX: Int, bY: Int, bZ: Int, res: Vec3b = Vec3b()) = div(res, this, bX, bY, bZ)
    fun div(b: Byte, res: Vec3b) = div(res, this, b, b, b)
    fun div(b: Int, res: Vec3b) = div(res, this, b, b, b)
    fun div(b: Vec3b, res: Vec3b) = div(res, this, b.x, b.y, b.z)

    fun div_(bX: Byte, bY: Byte, bZ: Byte) = div(this, this, bX, bY, bZ)
    fun div_(bX: Int, bY: Int, bZ: Int) = div(this, this, bX, bY, bZ)
    infix fun div_(b: Byte) = div(this, this, b, b, b)
    infix fun div_(b: Int) = div(this, this, b, b, b)
    infix fun div_(b: Vec3b) = div(this, this, b.x, b.y, b.z)


    operator fun rem(b: Byte) = rem(Vec3b(), this, b, b, b)
    operator fun rem(b: Int) = rem(Vec3b(), this, b, b, b)
    operator fun rem(b: Vec3b) = rem(Vec3b(), this, b.x, b.y, b.z)

    fun rem(bX: Byte, bY: Byte, bZ: Byte, res: Vec3b = Vec3b()) = rem(res, this, bX, bY, bZ)
    fun rem(bX: Int, bY: Int, bZ: Int, res: Vec3b = Vec3b()) = rem(res, this, bX, bY, bZ)
    fun rem(b: Byte, res: Vec3b) = rem(res, this, b, b, b)
    fun rem(b: Int, res: Vec3b) = rem(res, this, b, b, b)
    fun rem(b: Vec3b, res: Vec3b) = rem(res, this, b.x, b.y, b.z)

    fun rem_(bX: Byte, bY: Byte, bZ: Byte) = rem(this, this, bX, bY, bZ)
    fun rem_(bX: Int, bY: Int, bZ: Int) = rem(this, this, bX, bY, bZ)
    infix fun rem_(b: Byte) = rem(this, this, b, b, b)
    infix fun rem_(b: Int) = rem(this, this, b, b, b)
    infix fun rem_(b: Vec3b) = rem(this, this, b.x, b.y, b.z)


    // -- Generic binary arithmetic operators --

    operator fun plus(b: Number) = add(Vec3b(), this, b.i, b.i, b.i)
    operator fun plus(b: Vec3t<Number>) = add(Vec3b(), this, b.x.i, b.y.i, b.z.i)

    fun add(bX: Number, bY: Number, bZ: Number, res: Vec3b = Vec3b()) = add(res, this, bX.i, bY.i, bZ.i)
    fun add(b: Number, res: Vec3b = Vec3b()) = add(res, this, b.i, b.i, b.i)
    fun add(b: Vec3t<Number>, res: Vec3b = Vec3b()) = add(res, this, b.x.i, b.y.i, b.z.i)

    fun add_(bX: Number, bY: Number, bZ: Number) = add(this, this, bX.i, bY.i, bZ.i)
    infix fun add_(b: Number) = add(this, this, b.i, b.i, b.i)
    infix fun add_(b: Vec3t<Number>) = add(this, this, b.x.i, b.y.i, b.z.i)


    operator fun minus(b: Number) = sub(Vec3b(), this, b.i, b.i, b.i)
    operator fun minus(b: Vec3t<Number>) = sub(Vec3b(), this, b.x.i, b.y.i, b.z.i)

    fun sub(bX: Number, bY: Number, bZ: Number, res: Vec3b = Vec3b()) = sub(res, this, bX.i, bY.i, bZ.i)
    fun sub(b: Number, res: Vec3b = Vec3b()) = sub(res, this, b.i, b.i, b.i)
    fun sub(b: Vec3t<Number>, res: Vec3b = Vec3b()) = sub(res, this, b.x.i, b.y.i, b.z.i)

    fun sub_(bX: Number, bY: Number, bZ: Number) = sub(this, this, bX.i, bY.i, bZ.i)
    infix fun sub_(b: Number) = sub(this, this, b.i, b.i, b.i)
    infix fun sub_(b: Vec3t<Number>) = sub(this, this, b.x.i, b.y.i, b.z.i)


    operator fun times(b: Number) = mul(Vec3b(), this, b.i, b.i, b.i)
    operator fun times(b: Vec3t<Number>) = mul(Vec3b(), this, b.x.i, b.y.i, b.z.i)

    fun mul(bX: Number, bY: Number, bZ: Number, res: Vec3b = Vec3b()) = mul(res, this, bX.i, bY.i, bZ.i)
    fun mul(b: Number, res: Vec3b = Vec3b()) = mul(res, this, b.i, b.i, b.i)
    fun mul(b: Vec3t<Number>, res: Vec3b = Vec3b()) = mul(res, this, b.x.i, b.y.i, b.z.i)

    fun mul_(bX: Number, bY: Number, bZ: Number) = mul(this, this, bX.i, bY.i, bZ.i)
    infix fun mul_(b: Number) = mul(this, this, b.i, b.i, b.i)
    infix fun mul_(b: Vec3t<Number>) = mul(this, this, b.x.i, b.y.i, b.z.i)


    operator fun div(b: Number) = div(Vec3b(), this, b.i, b.i, b.i)
    operator fun div(b: Vec3t<Number>) = div(Vec3b(), this, b.x.i, b.y.i, b.z.i)

    fun div(bX: Number, bY: Number, bZ: Number, res: Vec3b = Vec3b()) = div(res, this, bX.i, bY.i, bZ.i)
    fun div(b: Number, res: Vec3b = Vec3b()) = div(res, this, b.i, b.i, b.i)
    fun div(b: Vec3t<Number>, res: Vec3b = Vec3b()) = div(res, this, b.x.i, b.y.i, b.z.i)

    fun div_(bX: Number, bY: Number, bZ: Number) = div(this, this, bX.i, bY.i, bZ.i)
    infix fun div_(b: Number) = div(this, this, b.i, b.i, b.i)
    infix fun div_(b: Vec3t<Number>) = div(this, this, b.x.i, b.y.i, b.z.i)


    operator fun rem(b: Number) = rem(Vec3b(), this, b.i, b.i, b.i)
    operator fun rem(b: Vec3t<Number>) = rem(Vec3b(), this, b.x.i, b.y.i, b.z.i)

    fun rem(bX: Number, bY: Number, bZ: Number, res: Vec3b = Vec3b()) = rem(res, this, bX.i, bY.i, bZ.i)
    fun rem(b: Number, res: Vec3b = Vec3b()) = rem(res, this, b.i, b.i, b.i)
    fun rem(b: Vec3t<Number>, res: Vec3b = Vec3b()) = rem(res, this, b.x.i, b.y.i, b.z.i)

    fun rem_(bX: Number, bY: Number, bZ: Number) = rem(this, this, bX.i, bY.i, bZ.i)
    infix fun rem_(b: Number) = rem(this, this, b.i, b.i, b.i)
    infix fun rem_(b: Vec3t<Number>) = rem(this, this, b.x.i, b.y.i, b.z.i)


    // -- Specific bitwise operators --

    infix fun and(b: Byte) = and(Vec3b(), this, b, b, b)
    infix fun and(b: Int) = and(Vec3b(), this, b, b, b)
    infix fun and(b: Vec3b) = and(Vec3b(), this, b.x, b.y, b.z)

    infix fun and_(b: Byte) = and(this, this, b, b, b)
    infix fun and_(b: Int) = and(this, this, b, b, b)
    infix fun and_(b: Vec3b) = and(this, this, b.x, b.y, b.z)

    fun and(b: Byte, res: Vec3b) = and(res, this, b, b, b)
    fun and(b: Int, res: Vec3b) = and(res, this, b, b, b)
    fun and(b: Vec3b, res: Vec3b) = and(res, this, b.x, b.y, b.z)

    fun and(bX: Byte, bY: Byte, bZ: Byte, res: Vec3b = Vec3b()) = and(res, this, bX, bY, bZ)
    fun and(bX: Int, bY: Int, bZ: Int, res: Vec3b = Vec3b()) = and(res, this, bX, bY, bZ)

    fun and_(bX: Byte, bY: Byte, bZ: Byte) = and(this, this, bX, bY, bZ)
    fun and_(bX: Int, bY: Int, bZ: Int) = and(this, this, bX, bY, bZ)


    infix fun or(b: Byte) = or(Vec3b(), this, b, b, b)
    infix fun or(b: Int) = or(Vec3b(), this, b, b, b)
    infix fun or(b: Vec3b) = or(Vec3b(), this, b.x, b.y, b.z)

    infix fun or_(b: Byte) = or(this, this, b, b, b)
    infix fun or_(b: Int) = or(this, this, b, b, b)
    infix fun or_(b: Vec3b) = or(this, this, b.x, b.y, b.z)

    fun or(b: Byte, res: Vec3b) = or(res, this, b, b, b)
    fun or(b: Int, res: Vec3b) = or(res, this, b, b, b)
    fun or(b: Vec3b, res: Vec3b) = or(res, this, b.x, b.y, b.z)

    fun or(bX: Byte, bY: Byte, bZ: Byte, res: Vec3b = Vec3b()) = or(res, this, bX, bY, bZ)
    fun or(bX: Int, bY: Int, bZ: Int, res: Vec3b = Vec3b()) = or(res, this, bX, bY, bZ)

    fun or_(bX: Byte, bY: Byte, bZ: Byte) = or(this, this, bX, bY, bZ)
    fun or_(bX: Int, bY: Int, bZ: Int) = or(this, this, bX, bY, bZ)


    infix fun xor(b: Byte) = xor(Vec3b(), this, b, b, b)
    infix fun xor(b: Int) = xor(Vec3b(), this, b, b, b)
    infix fun xor(b: Vec3b) = xor(Vec3b(), this, b.x, b.y, b.z)

    infix fun xor_(b: Byte) = xor(this, this, b, b, b)
    infix fun xor_(b: Int) = xor(this, this, b, b, b)
    infix fun xor_(b: Vec3b) = xor(this, this, b.x, b.y, b.z)

    fun xor(b: Byte, res: Vec3b) = xor(res, this, b, b, b)
    fun xor(b: Int, res: Vec3b) = xor(res, this, b, b, b)
    fun xor(b: Vec3b, res: Vec3b) = xor(res, this, b.x, b.y, b.z)

    fun xor(bX: Byte, bY: Byte, bZ: Byte, res: Vec3b = Vec3b()) = xor(res, this, bX, bY, bZ)
    fun xor(bX: Int, bY: Int, bZ: Int, res: Vec3b = Vec3b()) = xor(res, this, bX, bY, bZ)

    fun xor_(bX: Byte, bY: Byte, bZ: Byte) = xor(this, this, bX, bY, bZ)
    fun xor_(bX: Int, bY: Int, bZ: Int) = xor(this, this, bX, bY, bZ)


    infix fun shl(b: Byte) = shl(Vec3b(), this, b, b, b)
    infix fun shl(b: Int) = shl(Vec3b(), this, b, b, b)
    infix fun shl(b: Vec3b) = shl(Vec3b(), this, b.x, b.y, b.z)

    infix fun shl_(b: Byte) = shl(this, this, b, b, b)
    infix fun shl_(b: Int) = shl(this, this, b, b, b)
    infix fun shl_(b: Vec3b) = shl(this, this, b.x, b.y, b.z)

    fun shl(b: Byte, res: Vec3b) = shl(res, this, b, b, b)
    fun shl(b: Int, res: Vec3b) = shl(res, this, b, b, b)
    fun shl(b: Vec3b, res: Vec3b) = shl(res, this, b.x, b.y, b.z)

    fun shl(bX: Byte, bY: Byte, bZ: Byte, res: Vec3b = Vec3b()) = shl(res, this, bX, bY, bZ)
    fun shl(bX: Int, bY: Int, bZ: Int, res: Vec3b = Vec3b()) = shl(res, this, bX, bY, bZ)

    fun shl_(bX: Byte, bY: Byte, bZ: Byte) = shl(this, this, bX, bY, bZ)
    fun shl_(bX: Int, bY: Int, bZ: Int) = shl(this, this, bX, bY, bZ)


    infix fun shr(b: Byte) = shr(Vec3b(), this, b, b, b)
    infix fun shr(b: Int) = shr(Vec3b(), this, b, b, b)
    infix fun shr(b: Vec3b) = shr(Vec3b(), this, b.x, b.y, b.z)

    infix fun shr_(b: Byte) = shr(this, this, b, b, b)
    infix fun shr_(b: Int) = shr(this, this, b, b, b)
    infix fun shr_(b: Vec3b) = shr(this, this, b.x, b.y, b.z)

    fun shr(b: Byte, res: Vec3b) = shr(res, this, b, b, b)
    fun shr(b: Int, res: Vec3b) = shr(res, this, b, b, b)
    fun shr(b: Vec3b, res: Vec3b) = shr(res, this, b.x, b.y, b.z)

    fun shr(bX: Byte, bY: Byte, bZ: Byte, res: Vec3b = Vec3b()) = shr(res, this, bX, bY, bZ)
    fun shr(bX: Int, bY: Int, bZ: Int, res: Vec3b = Vec3b()) = shr(res, this, bX, bY, bZ)

    fun shr_(bX: Byte, bY: Byte, bZ: Byte) = shr(this, this, bX, bY, bZ)
    fun shr_(bX: Int, bY: Int, bZ: Int) = shr(this, this, bX, bY, bZ)


    fun inv(res: Vec3b = Vec3b()) = inv(res, this)
    fun inv_() = inv(this, this)


    // -- Generic bitwise operators --

    infix fun and(b: Number) = and(Vec3b(), this, b.b, b.b, b.b)
    infix fun and(b: Vec3t<Number>) = and(Vec3b(), this, b.x.b, b.y.b, b.z.b)

    infix fun and_(b: Number) = and(this, this, b.b, b.b, b.b)
    infix fun and_(b: Vec3t<Number>) = and(this, this, b.x.b, b.y.b, b.z.b)

    fun and(b: Number, res: Vec3b = Vec3b()) = and(res, this, b.b, b.b, b.b)
    fun and(b: Vec3t<Number>, res: Vec3b = Vec3b()) = and(res, this, b.x.b, b.y.b, b.z.b)

    fun and(bX: Number, bY: Number, bZ: Number, res: Vec3b = Vec3b()) = and(res, this, bX.b, bY.b, bZ.b)

    fun and_(bX: Number, bY: Number, bZ: Number) = and(this, this, bX.b, bY.b, bZ.b)


    infix fun or(b: Number) = or(Vec3b(), this, b.b, b.b, b.b)
    infix fun or(b: Vec3t<Number>) = or(Vec3b(), this, b.x.b, b.y.b, b.z.b)

    infix fun or_(b: Number) = or(this, this, b.b, b.b, b.b)
    infix fun or_(b: Vec3t<Number>) = or(this, this, b.x.b, b.y.b, b.z.b)

    fun or(b: Number, res: Vec3b = Vec3b()) = or(res, this, b.b, b.b, b.b)
    fun or(b: Vec3t<Number>, res: Vec3b = Vec3b()) = or(res, this, b.x.b, b.y.b, b.z.b)

    fun or(bX: Number, bY: Number, bZ: Number, res: Vec3b = Vec3b()) = or(res, this, bX.b, bY.b, bZ.b)

    fun or_(bX: Number, bY: Number, bZ: Number) = or(this, this, bX.b, bY.b, bZ.b)


    infix fun xor(b: Number) = xor(Vec3b(), this, b.b, b.b, b.b)
    infix fun xor(b: Vec3t<Number>) = xor(Vec3b(), this, b.x.b, b.y.b, b.z.b)

    infix fun xor_(b: Number) = xor(this, this, b.b, b.b, b.b)
    infix fun xor_(b: Vec3t<Number>) = xor(this, this, b.x.b, b.y.b, b.z.b)

    fun xor(b: Number, res: Vec3b = Vec3b()) = xor(res, this, b.b, b.b, b.b)
    fun xor(b: Vec3t<Number>, res: Vec3b = Vec3b()) = xor(res, this, b.x.b, b.y.b, b.z.b)

    fun xor(bX: Number, bY: Number, bZ: Number, res: Vec3b = Vec3b()) = xor(res, this, bX.b, bY.b, bZ.b)

    fun xor_(bX: Number, bY: Number, bZ: Number) = xor(this, this, bX.b, bY.b, bZ.b)


    infix fun shl(b: Number) = shl(Vec3b(), this, b.b, b.b, b.b)
    infix fun shl(b: Vec3t<Number>) = shl(Vec3b(), this, b.x.b, b.y.b, b.z.b)

    infix fun shl_(b: Number) = shl(this, this, b.b, b.b, b.b)
    infix fun shl_(b: Vec3t<Number>) = shl(this, this, b.x.b, b.y.b, b.z.b)

    fun shl(b: Number, res: Vec3b = Vec3b()) = shl(res, this, b.b, b.b, b.b)
    fun shl(b: Vec3t<Number>, res: Vec3b = Vec3b()) = shl(res, this, b.x.b, b.y.b, b.z.b)

    fun shl(bX: Number, bY: Number, bZ: Number, res: Vec3b = Vec3b()) = shl(res, this, bX.b, bY.b, bZ.b)

    fun shl_(bX: Number, bY: Number, bZ: Number) = shl(this, this, bX.b, bY.b, bZ.b)


    infix fun shr(b: Number) = shr(Vec3b(), this, b.b, b.b, b.b)
    infix fun shr(b: Vec3t<Number>) = shr(Vec3b(), this, b.x.b, b.y.b, b.z.b)

    infix fun shr_(b: Number) = shr(this, this, b.b, b.b, b.b)
    infix fun shr_(b: Vec3t<Number>) = shr(this, this, b.x.b, b.y.b, b.z.b)

    fun shr(b: Number, res: Vec3b = Vec3b()) = shr(res, this, b.b, b.b, b.b)
    fun shr(b: Vec3t<Number>, res: Vec3b = Vec3b()) = shr(res, this, b.x.b, b.y.b, b.z.b)

    fun shr(bX: Number, bY: Number, bZ: Number, res: Vec3b = Vec3b()) = shr(res, this, bX.b, bY.b, bZ.b)

    fun shr_(bX: Number, bY: Number, bZ: Number) = shr(this, this, bX.b, bY.b, bZ.b)
}