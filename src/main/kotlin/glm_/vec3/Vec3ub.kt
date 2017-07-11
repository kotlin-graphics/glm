package glm_.vec3

import glm_.BYTES
import glm_.i
import glm_.ub
import unsigned.Ubyte
import glm_.vec2.Vec2t
import glm_.vec4.Vec4t
import glm_.vec3.operators.vec3ub_operators
import glm_.vec2.Vec2bool
import glm_.vec4.Vec4bool
import java.nio.*

/**
 * Created by elect on 09/10/16.
 */

class Vec3ub(x: Ubyte, y: Ubyte, z: Ubyte) : Vec3t<Ubyte>(x, y, z) {

    // -- Explicit basic, conversion main.getB main.and conversion vector constructors --

    constructor() : this(0)

    constructor(v: Vec2t<out Number>) : this(v.x, v.y, 0)
    constructor(v: Vec2t<out Number>, z: Number) : this(v.x, v.y, z)
    constructor(x: Number, v: Vec2t<out Number>) : this(x, v.x, v.y)
    constructor(v: Vec3t<out Number>) : this(v.x, v.y, v.z)
    constructor(v: Vec4t<out Number>) : this(v.x, v.y, v.z)

    constructor(v: Vec2bool) : this(v.x.ub, v.y.ub, 0)
    constructor(v: Vec3bool) : this(v.x.ub, v.y.ub, v.z.ub)
    constructor(v: Vec4bool) : this(v.x.ub, v.y.ub, v.z.ub)

    constructor(bytes: ByteArray, index: Int = 0) : this(bytes[index], bytes[index + 1], bytes[index + 2])
    constructor(chars: CharArray, index: Int = 0) : this(chars[index].ub, chars[index + 1].ub, chars[index + 2].ub)
    constructor(shorts: ShortArray, index: Int = 0) : this(shorts[index], shorts[index + 1], shorts[index + 2])
    constructor(ints: IntArray, index: Int = 0) : this(ints[index], ints[index + 1], ints[index + 2])
    constructor(longs: LongArray, index: Int = 0) : this(longs[index], longs[index + 1], longs[index + 2])
    constructor(floats: FloatArray, index: Int = 0) : this(floats[index], floats[index + 1], floats[index + 2])
    constructor(doubles: DoubleArray, index: Int = 0) : this(doubles[index], doubles[index + 1], doubles[index + 2])
    constructor(booleans: BooleanArray, index: Int = 0) : this(booleans[index].ub, booleans[index + 1].ub, booleans[index + 2].ub)

    constructor(numbers: Array<out Number>, index: Int = 0) : this(numbers[index], numbers[index + 1], numbers[index + 2])
    constructor(chars: Array<Char>, index: Int = 0) : this(chars[index].ub, chars[index + 1].ub, chars[index + 2].ub)
    constructor(booleans: Array<Boolean>, index: Int = 0) : this(booleans[index].ub, booleans[index + 1].ub, booleans[index + 2].ub)

    constructor(list: List<Any>, index: Int = 0) : this() {
        put(list, index)
    }

    constructor(bytes: ByteBuffer, index: Int = bytes.position()) : this(bytes[index], bytes[index + 1], bytes[index + 2])
    constructor(chars: CharBuffer, index: Int = chars.position()) : this(chars[index].ub, chars[index + 1].ub, chars[index + 2].ub)
    constructor(shorts: ShortBuffer, index: Int = shorts.position()) : this(shorts[index], shorts[index + 1], shorts[index + 2])
    constructor(ints: IntBuffer, index: Int = ints.position()) : this(ints[index], ints[index + 1], ints[index + 2])
    constructor(longs: LongBuffer, index: Int = longs.position()) : this(longs[index], longs[index + 1], longs[index + 2])
    constructor(floats: FloatBuffer, index: Int = floats.position()) : this(floats[index], floats[index + 1], floats[index + 2])
    constructor(doubles: DoubleBuffer, index: Int = doubles.position()) : this(doubles[index], doubles[index + 1], doubles[index + 2])

    constructor(s: Number) : this(s, s, s)
    constructor(x: Number, y: Number, z: Number) : this(x.ub, y.ub, z.ub)


    override fun put(x: Number, y: Number, z: Number): Vec3ub {
        this.x = x.ub
        this.y = y.ub
        this.z = z.ub
        return this
    }


    // -- Component accesses --

    override operator fun get(i: Int) = when (i) {
        0 -> x
        1 -> y
        2 -> z
        else -> throw ArrayIndexOutOfBoundsException()
    }

    operator fun set(i: Int, s: Number) = when (i) {
        0 -> x = s.ub
        1 -> y = s.ub
        2 -> z = s.ub
        else -> throw ArrayIndexOutOfBoundsException()
    }


    companion object : vec3ub_operators {
        @JvmField val length = 3
        @JvmField val size = length * Ubyte.BYTES
    }


    // -- Unary arithmetic operators --

    operator fun unaryPlus() = this

    // no unaryMinus operator, only signed

    // -- Increment main.and decrement operators --

    operator fun inc(res: Vec3ub = Vec3ub()) = plus(res, this, 1, 1, 1)
    fun inc_() = plus(this, this, 1, 1, 1)


    operator fun dec(res: Vec3ub = Vec3ub()) = minus(res, this, 1, 1, 1)
    fun dec_() = minus(this, this, 1, 1, 1)


    // -- Specific binary arithmetic operators --

    operator fun plus(b: Ubyte) = plus(Vec3ub(), this, b, b, b)
    operator fun plus(b: Byte) = plus(Vec3ub(), this, b, b, b)
    operator fun plus(b: Int) = plus(Vec3ub(), this, b, b, b)
    operator fun plus(b: Vec3ub) = plus(Vec3ub(), this, b.x, b.y, b.z)

    fun plus(bX: Ubyte, bY: Ubyte, bZ: Ubyte, res: Vec3ub = Vec3ub()) = plus(res, this, bX, bY, bZ)
    fun plus(bX: Byte, bY: Byte, bZ: Byte, res: Vec3ub = Vec3ub()) = plus(res, this, bX, bY, bZ)
    fun plus(bX: Int, bY: Int, bZ: Int, res: Vec3ub = Vec3ub()) = plus(res, this, bX, bY, bZ)
    fun plus(b: Ubyte, res: Vec3ub = Vec3ub()) = plus(res, this, b, b, b)
    fun plus(b: Byte, res: Vec3ub = Vec3ub()) = plus(res, this, b, b, b)
    fun plus(b: Int, res: Vec3ub = Vec3ub()) = plus(res, this, b, b, b)
    fun plus(b: Vec3ub, res: Vec3ub = Vec3ub()) = plus(res, this, b.x, b.y, b.z)

    fun plus_(bX: Ubyte, bY: Ubyte, bZ: Ubyte) = plus(this, this, bX, bY, bZ)
    fun plus_(bX: Byte, bY: Byte, bZ: Byte) = plus(this, this, bX, bY, bZ)
    fun plus_(bX: Int, bY: Int, bZ: Int) = plus(this, this, bX, bY, bZ)
    infix fun plus_(b: Ubyte) = plus(this, this, b, b, b)
    infix fun plus_(b: Byte) = plus(this, this, b, b, b)
    infix fun plus_(b: Int) = plus(this, this, b, b, b)
    infix fun plus_(b: Vec3ub) = plus(this, this, b.x, b.y, b.z)


    operator fun minus(b: Ubyte) = minus(Vec3ub(), this, b, b, b)
    operator fun minus(b: Byte) = minus(Vec3ub(), this, b, b, b)
    operator fun minus(b: Int) = minus(Vec3ub(), this, b, b, b)
    operator fun minus(b: Vec3ub) = minus(Vec3ub(), this, b.x, b.y, b.z)

    fun minus(bX: Ubyte, bY: Ubyte, bZ: Ubyte, res: Vec3ub = Vec3ub()) = minus(res, this, bX, bY, bZ)
    fun minus(bX: Byte, bY: Byte, bZ: Byte, res: Vec3ub = Vec3ub()) = minus(res, this, bX, bY, bZ)
    fun minus(bX: Int, bY: Int, bZ: Int, res: Vec3ub = Vec3ub()) = minus(res, this, bX, bY, bZ)
    fun minus(b: Ubyte, res: Vec3ub = Vec3ub()) = minus(res, this, b, b, b)
    fun minus(b: Byte, res: Vec3ub = Vec3ub()) = minus(res, this, b, b, b)
    fun minus(b: Int, res: Vec3ub = Vec3ub()) = minus(res, this, b, b, b)
    fun minus(b: Vec3ub, res: Vec3ub = Vec3ub()) = minus(res, this, b.x, b.y, b.z)

    fun minus_(bX: Ubyte, bY: Ubyte, bZ: Ubyte) = minus(this, this, bX, bY, bZ)
    fun minus_(bX: Byte, bY: Byte, bZ: Byte) = minus(this, this, bX, bY, bZ)
    fun minus_(bX: Int, bY: Int, bZ: Int) = minus(this, this, bX, bY, bZ)
    infix fun minus_(b: Ubyte) = minus(this, this, b, b, b)
    infix fun minus_(b: Byte) = minus(this, this, b, b, b)
    infix fun minus_(b: Int) = minus(this, this, b, b, b)
    infix fun minus_(b: Vec3ub) = minus(this, this, b.x, b.y, b.z)


    operator fun times(b: Ubyte) = times(Vec3ub(), this, b, b, b)
    operator fun times(b: Byte) = times(Vec3ub(), this, b, b, b)
    operator fun times(b: Int) = times(Vec3ub(), this, b, b, b)
    operator fun times(b: Vec3ub) = times(Vec3ub(), this, b.x, b.y, b.z)

    fun times(bX: Ubyte, bY: Ubyte, bZ: Ubyte, res: Vec3ub = Vec3ub()) = times(res, this, bX, bY, bZ)
    fun times(bX: Byte, bY: Byte, bZ: Byte, res: Vec3ub = Vec3ub()) = times(res, this, bX, bY, bZ)
    fun times(bX: Int, bY: Int, bZ: Int, res: Vec3ub = Vec3ub()) = times(res, this, bX, bY, bZ)
    fun times(b: Ubyte, res: Vec3ub = Vec3ub()) = times(res, this, b, b, b)
    fun times(b: Byte, res: Vec3ub = Vec3ub()) = times(res, this, b, b, b)
    fun times(b: Int, res: Vec3ub = Vec3ub()) = times(res, this, b, b, b)
    fun times(b: Vec3ub, res: Vec3ub = Vec3ub()) = times(res, this, b.x, b.y, b.z)

    fun times_(bX: Ubyte, bY: Ubyte, bZ: Ubyte) = times(this, this, bX, bY, bZ)
    fun times_(bX: Byte, bY: Byte, bZ: Byte) = times(this, this, bX, bY, bZ)
    fun times_(bX: Int, bY: Int, bZ: Int) = times(this, this, bX, bY, bZ)
    infix fun times_(b: Ubyte) = times(this, this, b, b, b)
    infix fun times_(b: Byte) = times(this, this, b, b, b)
    infix fun times_(b: Int) = times(this, this, b, b, b)
    infix fun times_(b: Vec3ub) = times(this, this, b.x, b.y, b.z)


    operator fun div(b: Ubyte) = div(Vec3ub(), this, b, b, b)
    operator fun div(b: Byte) = div(Vec3ub(), this, b, b, b)
    operator fun div(b: Int) = div(Vec3ub(), this, b, b, b)
    operator fun div(b: Vec3ub) = div(Vec3ub(), this, b.x, b.y, b.z)

    fun div(bX: Ubyte, bY: Ubyte, bZ: Ubyte, res: Vec3ub = Vec3ub()) = div(res, this, bX, bY, bZ)
    fun div(bX: Byte, bY: Byte, bZ: Byte, res: Vec3ub = Vec3ub()) = div(res, this, bX, bY, bZ)
    fun div(bX: Int, bY: Int, bZ: Int, res: Vec3ub = Vec3ub()) = div(res, this, bX, bY, bZ)
    fun div(b: Ubyte, res: Vec3ub) = div(res, this, b, b, b)
    fun div(b: Byte, res: Vec3ub) = div(res, this, b, b, b)
    fun div(b: Int, res: Vec3ub) = div(res, this, b, b, b)
    fun div(b: Vec3ub, res: Vec3ub) = div(res, this, b.x, b.y, b.z)

    fun div_(bX: Ubyte, bY: Ubyte, bZ: Ubyte) = div(this, this, bX, bY, bZ)
    fun div_(bX: Byte, bY: Byte, bZ: Byte) = div(this, this, bX, bY, bZ)
    fun div_(bX: Int, bY: Int, bZ: Int) = div(this, this, bX, bY, bZ)
    infix fun div_(b: Ubyte) = div(this, this, b, b, b)
    infix fun div_(b: Byte) = div(this, this, b, b, b)
    infix fun div_(b: Int) = div(this, this, b, b, b)
    infix fun div_(b: Vec3ub) = div(this, this, b.x, b.y, b.z)


    operator fun rem(b: Ubyte) = rem(Vec3ub(), this, b, b, b)
    operator fun rem(b: Byte) = rem(Vec3ub(), this, b, b, b)
    operator fun rem(b: Int) = rem(Vec3ub(), this, b, b, b)
    operator fun rem(b: Vec3ub) = rem(Vec3ub(), this, b.x, b.y, b.z)

    fun rem(bX: Ubyte, bY: Ubyte, bZ: Ubyte, res: Vec3ub = Vec3ub()) = rem(res, this, bX, bY, bZ)
    fun rem(bX: Byte, bY: Byte, bZ: Byte, res: Vec3ub = Vec3ub()) = rem(res, this, bX, bY, bZ)
    fun rem(bX: Int, bY: Int, bZ: Int, res: Vec3ub = Vec3ub()) = rem(res, this, bX, bY, bZ)
    fun rem(b: Ubyte, res: Vec3ub) = rem(res, this, b, b, b)
    fun rem(b: Byte, res: Vec3ub) = rem(res, this, b, b, b)
    fun rem(b: Int, res: Vec3ub) = rem(res, this, b, b, b)
    fun rem(b: Vec3ub, res: Vec3ub) = rem(res, this, b.x, b.y, b.z)

    fun rem_(bX: Ubyte, bY: Ubyte, bZ: Ubyte) = rem(this, this, bX, bY, bZ)
    fun rem_(bX: Byte, bY: Byte, bZ: Byte) = rem(this, this, bX, bY, bZ)
    fun rem_(bX: Int, bY: Int, bZ: Int) = rem(this, this, bX, bY, bZ)
    infix fun rem_(b: Ubyte) = rem(this, this, b, b, b)
    infix fun rem_(b: Byte) = rem(this, this, b, b, b)
    infix fun rem_(b: Int) = rem(this, this, b, b, b)
    infix fun rem_(b: Vec3ub) = rem(this, this, b.x, b.y, b.z)


    // -- Generic binary arithmetic operators --

    operator fun plus(b: Number) = plus(Vec3ub(), this, b.i, b.i, b.i)
    operator fun plus(b: Vec3t<out Number>) = plus(Vec3ub(), this, b.x.i, b.y.i, b.z.i)

    fun plus(bX: Number, bY: Number, bZ: Number, res: Vec3ub = Vec3ub()) = plus(res, this, bX.i, bY.i, bZ.i)
    fun plus(b: Number, res: Vec3ub = Vec3ub()) = plus(res, this, b.i, b.i, b.i)
    fun plus(b: Vec3t<out Number>, res: Vec3ub = Vec3ub()) = plus(res, this, b.x.i, b.y.i, b.z.i)

    fun plus_(bX: Number, bY: Number, bZ: Number) = plus(this, this, bX.i, bY.i, bZ.i)
    infix fun plus_(b: Number) = plus(this, this, b.i, b.i, b.i)
    infix fun plus_(b: Vec3t<out Number>) = plus(this, this, b.x.i, b.y.i, b.z.i)


    operator fun minus(b: Number) = minus(Vec3ub(), this, b.i, b.i, b.i)
    operator fun minus(b: Vec3t<out Number>) = minus(Vec3ub(), this, b.x.i, b.y.i, b.z.i)

    fun minus(bX: Number, bY: Number, bZ: Number, res: Vec3ub = Vec3ub()) = minus(res, this, bX.i, bY.i, bZ.i)
    fun minus(b: Number, res: Vec3ub = Vec3ub()) = minus(res, this, b.i, b.i, b.i)
    fun minus(b: Vec3t<out Number>, res: Vec3ub = Vec3ub()) = minus(res, this, b.x.i, b.y.i, b.z.i)

    fun minus_(bX: Number, bY: Number, bZ: Number) = minus(this, this, bX.i, bY.i, bZ.i)
    infix fun minus_(b: Number) = minus(this, this, b.i, b.i, b.i)
    infix fun minus_(b: Vec3t<out Number>) = minus(this, this, b.x.i, b.y.i, b.z.i)


    operator fun times(b: Number) = times(Vec3ub(), this, b.i, b.i, b.i)
    operator fun times(b: Vec3t<out Number>) = times(Vec3ub(), this, b.x.i, b.y.i, b.z.i)

    fun times(bX: Number, bY: Number, bZ: Number, res: Vec3ub = Vec3ub()) = times(res, this, bX.i, bY.i, bZ.i)
    fun times(b: Number, res: Vec3ub = Vec3ub()) = times(res, this, b.i, b.i, b.i)
    fun times(b: Vec3t<out Number>, res: Vec3ub = Vec3ub()) = times(res, this, b.x.i, b.y.i, b.z.i)

    fun times_(bX: Number, bY: Number, bZ: Number) = times(this, this, bX.i, bY.i, bZ.i)
    infix fun times_(b: Number) = times(this, this, b.i, b.i, b.i)
    infix fun times_(b: Vec3t<out Number>) = times(this, this, b.x.i, b.y.i, b.z.i)


    operator fun div(b: Number) = div(Vec3ub(), this, b.i, b.i, b.i)
    operator fun div(b: Vec3t<out Number>) = div(Vec3ub(), this, b.x.i, b.y.i, b.z.i)

    fun div(bX: Number, bY: Number, bZ: Number, res: Vec3ub = Vec3ub()) = div(res, this, bX.i, bY.i, bZ.i)
    fun div(b: Number, res: Vec3ub) = div(res, this, b.i, b.i, b.i)
    fun div(b: Vec3t<out Number>, res: Vec3ub) = div(res, this, b.x.i, b.y.i, b.z.i)

    fun div_(bX: Number, bY: Number, bZ: Number) = div(this, this, bX.i, bY.i, bZ.i)
    infix fun div_(b: Number) = div(this, this, b.i, b.i, b.i)
    infix fun div_(b: Vec3t<out Number>) = div(this, this, b.x.i, b.y.i, b.z.i)


    operator fun rem(b: Number) = rem(Vec3ub(), this, b.i, b.i, b.i)
    operator fun rem(b: Vec3t<out Number>) = rem(Vec3ub(), this, b.x.i, b.y.i, b.z.i)

    fun rem(bX: Number, bY: Number, bZ: Number, res: Vec3ub = Vec3ub()) = rem(res, this, bX.i, bY.i, bZ.i)
    fun rem(b: Number, res: Vec3ub) = rem(res, this, b.i, b.i, b.i)
    fun rem(b: Vec3t<out Number>, res: Vec3ub) = rem(res, this, b.x.i, b.y.i, b.z.i)

    fun rem_(bX: Number, bY: Number, bZ: Number) = rem(this, this, bX.i, bY.i, bZ.i)
    infix fun rem_(b: Number) = rem(this, this, b.i, b.i, b.i)
    infix fun rem_(b: Vec3t<out Number>) = rem(this, this, b.x.i, b.y.i, b.z.i)


    // -- Specific bitwise operators --

    infix fun and(b: Ubyte) = and(Vec3ub(), this, b, b, b)
    infix fun and(b: Byte) = and(Vec3ub(), this, b, b, b)
    infix fun and(b: Int) = and(Vec3ub(), this, b, b, b)
    infix fun and(b: Vec3ub) = and(Vec3ub(), this, b.x, b.y, b.z)

    infix fun and_(b: Ubyte) = and(this, this, b, b, b)
    infix fun and_(b: Byte) = and(this, this, b, b, b)
    infix fun and_(b: Int) = and(this, this, b, b, b)
    infix fun and_(b: Vec3ub) = and(this, this, b.x, b.y, b.z)

    fun and(b: Ubyte, res: Vec3ub) = and(res, this, b, b, b)
    fun and(b: Byte, res: Vec3ub) = and(res, this, b, b, b)
    fun and(b: Int, res: Vec3ub) = and(res, this, b, b, b)
    fun and(b: Vec3ub, res: Vec3ub) = and(res, this, b.x, b.y, b.z)

    fun and(bX: Ubyte, bY: Ubyte, bZ: Ubyte, res: Vec3ub = Vec3ub()) = and(res, this, bX, bY, bZ)
    fun and(bX: Byte, bY: Byte, bZ: Byte, res: Vec3ub = Vec3ub()) = and(res, this, bX, bY, bZ)
    fun and(bX: Int, bY: Int, bZ: Int, res: Vec3ub = Vec3ub()) = and(res, this, bX, bY, bZ)

    fun and_(bX: Ubyte, bY: Ubyte, bZ: Ubyte) = and(this, this, bX, bY, bZ)
    fun and_(bX: Byte, bY: Byte, bZ: Byte) = and(this, this, bX, bY, bZ)
    fun and_(bX: Int, bY: Int, bZ: Int) = and(this, this, bX, bY, bZ)


    infix fun or(b: Ubyte) = or(Vec3ub(), this, b, b, b)
    infix fun or(b: Byte) = or(Vec3ub(), this, b, b, b)
    infix fun or(b: Int) = or(Vec3ub(), this, b, b, b)
    infix fun or(b: Vec3ub) = or(Vec3ub(), this, b.x, b.y, b.z)

    infix fun or_(b: Ubyte) = or(this, this, b, b, b)
    infix fun or_(b: Byte) = or(this, this, b, b, b)
    infix fun or_(b: Int) = or(this, this, b, b, b)
    infix fun or_(b: Vec3ub) = or(this, this, b.x, b.y, b.z)

    fun or(b: Ubyte, res: Vec3ub) = or(res, this, b, b, b)
    fun or(b: Byte, res: Vec3ub) = or(res, this, b, b, b)
    fun or(b: Int, res: Vec3ub) = or(res, this, b, b, b)
    fun or(b: Vec3ub, res: Vec3ub) = or(res, this, b.x, b.y, b.z)

    fun or(bX: Ubyte, bY: Ubyte, bZ: Ubyte, res: Vec3ub = Vec3ub()) = or(res, this, bX, bY, bZ)
    fun or(bX: Byte, bY: Byte, bZ: Byte, res: Vec3ub = Vec3ub()) = or(res, this, bX, bY, bZ)
    fun or(bX: Int, bY: Int, bZ: Int, res: Vec3ub = Vec3ub()) = or(res, this, bX, bY, bZ)

    fun or_(bX: Ubyte, bY: Ubyte, bZ: Ubyte) = or(this, this, bX, bY, bZ)
    fun or_(bX: Byte, bY: Byte, bZ: Byte) = or(this, this, bX, bY, bZ)
    fun or_(bX: Int, bY: Int, bZ: Int) = or(this, this, bX, bY, bZ)


    infix fun xor(b: Ubyte) = xor(Vec3ub(), this, b, b, b)
    infix fun xor(b: Byte) = xor(Vec3ub(), this, b, b, b)
    infix fun xor(b: Int) = xor(Vec3ub(), this, b, b, b)
    infix fun xor(b: Vec3ub) = xor(Vec3ub(), this, b.x, b.y, b.z)

    infix fun xor_(b: Ubyte) = xor(this, this, b, b, b)
    infix fun xor_(b: Byte) = xor(this, this, b, b, b)
    infix fun xor_(b: Int) = xor(this, this, b, b, b)
    infix fun xor_(b: Vec3ub) = xor(this, this, b.x, b.y, b.z)

    fun xor(b: Ubyte, res: Vec3ub) = xor(res, this, b, b, b)
    fun xor(b: Byte, res: Vec3ub) = xor(res, this, b, b, b)
    fun xor(b: Int, res: Vec3ub) = xor(res, this, b, b, b)
    fun xor(b: Vec3ub, res: Vec3ub) = xor(res, this, b.x, b.y, b.z)

    fun xor(bX: Ubyte, bY: Ubyte, bZ: Ubyte, res: Vec3ub = Vec3ub()) = xor(res, this, bX, bY, bZ)
    fun xor(bX: Byte, bY: Byte, bZ: Byte, res: Vec3ub = Vec3ub()) = xor(res, this, bX, bY, bZ)
    fun xor(bX: Int, bY: Int, bZ: Int, res: Vec3ub = Vec3ub()) = xor(res, this, bX, bY, bZ)

    fun xor_(bX: Ubyte, bY: Ubyte, bZ: Ubyte) = xor(this, this, bX, bY, bZ)
    fun xor_(bX: Byte, bY: Byte, bZ: Byte) = xor(this, this, bX, bY, bZ)
    fun xor_(bX: Int, bY: Int, bZ: Int) = xor(this, this, bX, bY, bZ)


    infix fun shl(b: Ubyte) = shl(Vec3ub(), this, b, b, b)
    infix fun shl(b: Byte) = shl(Vec3ub(), this, b, b, b)
    infix fun shl(b: Int) = shl(Vec3ub(), this, b, b, b)
    infix fun shl(b: Vec3ub) = shl(Vec3ub(), this, b.x, b.y, b.z)

    infix fun shl_(b: Ubyte) = shl(this, this, b, b, b)
    infix fun shl_(b: Byte) = shl(this, this, b, b, b)
    infix fun shl_(b: Int) = shl(this, this, b, b, b)
    infix fun shl_(b: Vec3ub) = shl(this, this, b.x, b.y, b.z)

    fun shl(b: Ubyte, res: Vec3ub) = shl(res, this, b, b, b)
    fun shl(b: Byte, res: Vec3ub) = shl(res, this, b, b, b)
    fun shl(b: Int, res: Vec3ub) = shl(res, this, b, b, b)
    fun shl(b: Vec3ub, res: Vec3ub) = shl(res, this, b.x, b.y, b.z)

    fun shl(bX: Ubyte, bY: Ubyte, bZ: Ubyte, res: Vec3ub = Vec3ub()) = shl(res, this, bX, bY, bZ)
    fun shl(bX: Byte, bY: Byte, bZ: Byte, res: Vec3ub = Vec3ub()) = shl(res, this, bX, bY, bZ)
    fun shl(bX: Int, bY: Int, bZ: Int, res: Vec3ub = Vec3ub()) = shl(res, this, bX, bY, bZ)

    fun shl_(bX: Ubyte, bY: Ubyte, bZ: Ubyte) = shl(this, this, bX, bY, bZ)
    fun shl_(bX: Byte, bY: Byte, bZ: Byte) = shl(this, this, bX, bY, bZ)
    fun shl_(bX: Int, bY: Int, bZ: Int) = shl(this, this, bX, bY, bZ)


    infix fun shr(b: Ubyte) = shr(Vec3ub(), this, b, b, b)
    infix fun shr(b: Byte) = shr(Vec3ub(), this, b, b, b)
    infix fun shr(b: Int) = shr(Vec3ub(), this, b, b, b)
    infix fun shr(b: Vec3ub) = shr(Vec3ub(), this, b.x, b.y, b.z)

    infix fun shr_(b: Ubyte) = shr(this, this, b, b, b)
    infix fun shr_(b: Byte) = shr(this, this, b, b, b)
    infix fun shr_(b: Int) = shr(this, this, b, b, b)
    infix fun shr_(b: Vec3ub) = shr(this, this, b.x, b.y, b.z)

    fun shr(b: Ubyte, res: Vec3ub) = shr(res, this, b, b, b)
    fun shr(b: Byte, res: Vec3ub) = shr(res, this, b, b, b)
    fun shr(b: Int, res: Vec3ub) = shr(res, this, b, b, b)
    fun shr(b: Vec3ub, res: Vec3ub) = shr(res, this, b.x, b.y, b.z)

    fun shr(bX: Ubyte, bY: Ubyte, bZ: Ubyte, res: Vec3ub = Vec3ub()) = shr(res, this, bX, bY, bZ)
    fun shr(bX: Byte, bY: Byte, bZ: Byte, res: Vec3ub = Vec3ub()) = shr(res, this, bX, bY, bZ)
    fun shr(bX: Int, bY: Int, bZ: Int, res: Vec3ub = Vec3ub()) = shr(res, this, bX, bY, bZ)

    fun shr_(bX: Ubyte, bY: Ubyte, bZ: Ubyte) = shr(this, this, bX, bY, bZ)
    fun shr_(bX: Byte, bY: Byte, bZ: Byte) = shr(this, this, bX, bY, bZ)
    fun shr_(bX: Int, bY: Int, bZ: Int) = shr(this, this, bX, bY, bZ)


    fun inv(res: Vec3ub = Vec3ub()) = inv(res, this)
    fun inv_() = inv(this, this)


    // -- Generic bitwise operators --

    infix fun and(b: Number) = and(Vec3ub(), this, b.i, b.i, b.i)
    infix fun and(b: Vec3t<out Number>) = and(Vec3ub(), this, b.x.i, b.y.i, b.z.i)

    infix fun and_(b: Number) = and(this, this, b.i, b.i, b.i)
    infix fun and_(b: Vec3t<out Number>) = and(this, this, b.x.i, b.y.i, b.z.i)

    fun and(b: Number, res: Vec3ub) = and(res, this, b.i, b.i, b.i)
    fun and(b: Vec3t<out Number>, res: Vec3ub) = and(res, this, b.x.i, b.y.i, b.z.i)

    fun and(bX: Number, bY: Number, bZ: Number, res: Vec3ub = Vec3ub()) = and(res, this, bX.i, bY.i, bZ.i)

    fun and_(bX: Number, bY: Number, bZ: Number) = and(this, this, bX.i, bY.i, bZ.i)


    infix fun or(b: Number) = or(Vec3ub(), this, b.i, b.i, b.i)
    infix fun or(b: Vec3t<out Number>) = or(Vec3ub(), this, b.x.i, b.y.i, b.z.i)

    infix fun or_(b: Number) = or(this, this, b.i, b.i, b.i)
    infix fun or_(b: Vec3t<out Number>) = or(this, this, b.x.i, b.y.i, b.z.i)

    fun or(b: Number, res: Vec3ub) = or(res, this, b.i, b.i, b.i)
    fun or(b: Vec3t<out Number>, res: Vec3ub) = or(res, this, b.x.i, b.y.i, b.z.i)

    fun or(bX: Number, bY: Number, bZ: Number, res: Vec3ub = Vec3ub()) = or(res, this, bX.i, bY.i, bZ.i)

    fun or_(bX: Number, bY: Number, bZ: Number) = or(this, this, bX.i, bY.i, bZ.i)


    infix fun xor(b: Number) = xor(Vec3ub(), this, b.i, b.i, b.i)
    infix fun xor(b: Vec3t<out Number>) = xor(Vec3ub(), this, b.x.i, b.y.i, b.z.i)

    infix fun xor_(b: Number) = xor(this, this, b.i, b.i, b.i)
    infix fun xor_(b: Vec3t<out Number>) = xor(this, this, b.x.i, b.y.i, b.z.i)

    fun xor(b: Number, res: Vec3ub) = xor(res, this, b.i, b.i, b.i)
    fun xor(b: Vec3t<out Number>, res: Vec3ub) = xor(res, this, b.x.i, b.y.i, b.z.i)

    fun xor(bX: Number, bY: Number, bZ: Number, res: Vec3ub = Vec3ub()) = xor(res, this, bX.i, bY.i, bZ.i)

    fun xor_(bX: Number, bY: Number, bZ: Number) = xor(this, this, bX.i, bY.i, bZ.i)


    infix fun shl(b: Number) = shl(Vec3ub(), this, b.i, b.i, b.i)
    infix fun shl(b: Vec3t<out Number>) = shl(Vec3ub(), this, b.x.i, b.y.i, b.z.i)

    infix fun shl_(b: Number) = shl(this, this, b.i, b.i, b.i)
    infix fun shl_(b: Vec3t<out Number>) = shl(this, this, b.x.i, b.y.i, b.z.i)

    fun shl(b: Number, res: Vec3ub) = shl(res, this, b.i, b.i, b.i)
    fun shl(b: Vec3t<out Number>, res: Vec3ub) = shl(res, this, b.x.i, b.y.i, b.z.i)

    fun shl(bX: Number, bY: Number, bZ: Number, res: Vec3ub = Vec3ub()) = shl(res, this, bX.i, bY.i, bZ.i)

    fun shl_(bX: Number, bY: Number, bZ: Number) = shl(this, this, bX.i, bY.i, bZ.i)


    infix fun shr(b: Number) = shr(Vec3ub(), this, b.i, b.i, b.i)
    infix fun shr(b: Vec3t<out Number>) = shr(Vec3ub(), this, b.x.i, b.y.i, b.z.i)

    infix fun shr_(b: Number) = shr(this, this, b.i, b.i, b.i)
    infix fun shr_(b: Vec3t<out Number>) = shr(this, this, b.x.i, b.y.i, b.z.i)

    fun shr(b: Number, res: Vec3ub) = shr(res, this, b.i, b.i, b.i)
    fun shr(b: Vec3t<out Number>, res: Vec3ub) = shr(res, this, b.x.i, b.y.i, b.z.i)

    fun shr(bX: Number, bY: Number, bZ: Number, res: Vec3ub = Vec3ub()) = shr(res, this, bX.i, bY.i, bZ.i)

    fun shr_(bX: Number, bY: Number, bZ: Number) = shr(this, this, bX.i, bY.i, bZ.i)


    override fun equals(other: Any?) =
            if (other is Vec3ub)
                this[0] == other[0] && this[1] == other[1] && this[2] == other[2]
            else false
}