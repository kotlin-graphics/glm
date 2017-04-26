package glm.vec2

import glm.BYTES
import glm.b
import glm.i
import glm.vec2.operators.vec2b_operators
import glm.vec3.Vec3bool
import glm.vec3.Vec3t
import glm.vec4.Vec4bool
import glm.vec4.Vec4t
import java.nio.*

/**
 * Created bY GBarbieri on 06.10.2016.
 */

class Vec2b(x: Byte, y: Byte) : glm.vec2.Vec2t<Byte>(x, y) {

    // -- Explicit basic, conversion other main.and conversion vector constructors --

    constructor() : this(0)

    constructor(v: glm.vec2.Vec2t<out Number>) : this(v.x, v.y)
    constructor(v: Vec3t<out Number>) : this(v.x, v.y)
    constructor(v: Vec4t<out Number>) : this(v.x, v.y)

    constructor(v: Vec2bool) : this(v.x.b, v.y.b)
    constructor(v: Vec3bool) : this(v.x.b, v.y.b)
    constructor(v: Vec4bool) : this(v.x.b, v.y.b)

    constructor(bytes: ByteArray, index: Int = 0) : this(bytes[index], bytes[index + 1])
    constructor(chars: CharArray, index: Int = 0) : this(chars[index].b, chars[index + 1].b)
    constructor(shorts: ShortArray, index: Int = 0) : this(shorts[index], shorts[index + 1])
    constructor(ints: IntArray, index: Int = 0) : this(ints[index], ints[index + 1])
    constructor(longs: LongArray, index: Int = 0) : this(longs[index], longs[index + 1])
    constructor(floats: FloatArray, index: Int = 0) : this(floats[index], floats[index + 1])
    constructor(doubles: DoubleArray, index: Int = 0) : this(doubles[index], doubles[index + 1])
    constructor(booleans: BooleanArray, index: Int = 0) : this(booleans[index].b, booleans[index + 1].b)

    constructor(numbers: Array<out Number>, index: Int = 0) : this(numbers[index], numbers[index + 1])
    constructor(chars: Array<Char>, index: Int = 0) : this(chars[index].b, chars[index + 1].b)
    constructor(booleans: Array<Boolean>, index: Int = 0) : this(booleans[index].b, booleans[index + 1].b)

    constructor(list: List<Any>, index: Int = 0) : this() {
        put(list, index)
    }

    constructor(bytes: ByteBuffer, index: Int = bytes.position()) : this(bytes[index], bytes[index + 1])
    constructor(chars: CharBuffer, index: Int = chars.position()) : this(chars[index].b, chars[index + 1].b)
    constructor(shorts: ShortBuffer, index: Int = shorts.position()) : this(shorts[index], shorts[index + 1])
    constructor(ints: IntBuffer, index: Int = ints.position()) : this(ints[index], ints[index + 1])
    constructor(longs: LongBuffer, index: Int = longs.position()) : this(longs[index], longs[index + 1])
    constructor(floats: FloatBuffer, index: Int = floats.position()) : this(floats[index], floats[index + 1])
    constructor(doubles: DoubleBuffer, index: Int = doubles.position()) : this(doubles[index], doubles[index + 1])

    constructor(s: Number) : this(s, s)
    constructor(x: Number, y: Number) : this(x.b, y.b)


    fun put(x: Byte, y: Byte): glm.vec2.Vec2b {
        this.x = x
        this.y = y
        return this
    }

    override fun put(x: Number, y: Number): glm.vec2.Vec2b {
        this.x = x.b
        this.y = y.b
        return this
    }


    // -- Component accesses --

    infix operator fun get(i: Int) = when (i) {
        0 -> x
        1 -> y
        else -> throw ArrayIndexOutOfBoundsException()
    }

    operator fun set(i: Int, s: Byte) = when (i) {
        0 -> x = s
        1 -> y = s
        else -> throw ArrayIndexOutOfBoundsException()
    }

    operator fun set(i: Int, s: Number) = when (i) {
        0 -> x = s.b
        1 -> y = s.b
        else -> throw ArrayIndexOutOfBoundsException()
    }


    companion object : vec2b_operators {
        @JvmField val length = 2
        @JvmField val size = glm.vec2.Vec2b.Companion.length * Byte.BYTES
    }


    // -- Unary arithmetic operators --

    operator fun unaryPlus() = this

    operator fun unaryMinus() = glm.vec2.Vec2b(-x, -y)

    // -- Increment main.and decrement operators --

    operator fun inc() = glm.vec2.Vec2b.Companion.plus(Vec2b(), this, 1, 1)
    infix fun inc(res: glm.vec2.Vec2b) = glm.vec2.Vec2b.Companion.plus(res, this, 1, 1)
    fun inc_() = glm.vec2.Vec2b.Companion.plus(this, this, 1, 1)


    operator fun dec() = glm.vec2.Vec2b.Companion.minus(Vec2b(), this, 1, 1)
    infix fun dec(res: glm.vec2.Vec2b) = glm.vec2.Vec2b.Companion.minus(res, this, 1, 1)
    fun dec_() = glm.vec2.Vec2b.Companion.minus(this, this, 1, 1)


    // -- Specific binary arithmetic operators --

    infix operator fun plus(b: Byte) = glm.vec2.Vec2b.Companion.plus(Vec2b(), this, b, b)
    infix operator fun plus(b: Int) = glm.vec2.Vec2b.Companion.plus(Vec2b(), this, b, b)
    infix operator fun plus(b: glm.vec2.Vec2b) = glm.vec2.Vec2b.Companion.plus(Vec2b(), this, b.x, b.y)

    @JvmOverloads fun plus(bX: Byte, bY: Byte, res: glm.vec2.Vec2b = glm.vec2.Vec2b()) = glm.vec2.Vec2b.Companion.plus(res, this, bX, bY)
    @JvmOverloads fun plus(bX: Int, bY: Int, res: glm.vec2.Vec2b = glm.vec2.Vec2b()) = glm.vec2.Vec2b.Companion.plus(res, this, bX, bY)
    fun plus(b: Byte, res: glm.vec2.Vec2b) = glm.vec2.Vec2b.Companion.plus(res, this, b, b)
    fun plus(b: Int, res: glm.vec2.Vec2b) = glm.vec2.Vec2b.Companion.plus(res, this, b, b)
    fun plus(b: glm.vec2.Vec2b, res: glm.vec2.Vec2b) = glm.vec2.Vec2b.Companion.plus(res, this, b.x, b.y)

    fun plus_(bX: Byte, bY: Byte) = glm.vec2.Vec2b.Companion.plus(this, this, bX, bY)
    fun plus_(bX: Int, bY: Int) = glm.vec2.Vec2b.Companion.plus(this, this, bX, bY)
    infix fun plus_(b: Byte) = glm.vec2.Vec2b.Companion.plus(this, this, b, b)
    infix fun plus_(b: Int) = glm.vec2.Vec2b.Companion.plus(this, this, b, b)
    infix fun plus_(b: glm.vec2.Vec2b) = glm.vec2.Vec2b.Companion.plus(this, this, b.x, b.y)


    infix operator fun minus(b: Byte) = glm.vec2.Vec2b.Companion.minus(Vec2b(), this, b, b)
    infix operator fun minus(b: Int) = glm.vec2.Vec2b.Companion.minus(Vec2b(), this, b, b)
    infix operator fun minus(b: glm.vec2.Vec2b) = glm.vec2.Vec2b.Companion.minus(Vec2b(), this, b.x, b.y)

    @JvmOverloads fun minus(bX: Byte, bY: Byte, res: glm.vec2.Vec2b = glm.vec2.Vec2b()) = glm.vec2.Vec2b.Companion.minus(res, this, bX, bY)
    @JvmOverloads fun minus(bX: Int, bY: Int, res: glm.vec2.Vec2b = glm.vec2.Vec2b()) = glm.vec2.Vec2b.Companion.minus(res, this, bX, bY)
    fun minus(b: Byte, res: glm.vec2.Vec2b) = glm.vec2.Vec2b.Companion.minus(res, this, b, b)
    fun minus(b: Int, res: glm.vec2.Vec2b) = glm.vec2.Vec2b.Companion.minus(res, this, b, b)
    fun minus(b: glm.vec2.Vec2b, res: glm.vec2.Vec2b) = glm.vec2.Vec2b.Companion.minus(res, this, b.x, b.y)

    fun minus_(bX: Byte, bY: Byte) = glm.vec2.Vec2b.Companion.minus(this, this, bX, bY)
    fun minus_(bX: Int, bY: Int) = glm.vec2.Vec2b.Companion.minus(this, this, bX, bY)
    infix fun minus_(b: Byte) = glm.vec2.Vec2b.Companion.minus(this, this, b, b)
    infix fun minus_(b: Int) = glm.vec2.Vec2b.Companion.minus(this, this, b, b)
    infix fun minus_(b: glm.vec2.Vec2b) = glm.vec2.Vec2b.Companion.minus(this, this, b.x, b.y)


    infix operator fun times(b: Byte) = glm.vec2.Vec2b.Companion.times(Vec2b(), this, b, b)
    infix operator fun times(b: Int) = glm.vec2.Vec2b.Companion.times(Vec2b(), this, b, b)
    infix operator fun times(b: glm.vec2.Vec2b) = glm.vec2.Vec2b.Companion.times(Vec2b(), this, b.x, b.y)

    @JvmOverloads fun times(bX: Byte, bY: Byte, res: glm.vec2.Vec2b = glm.vec2.Vec2b()) = glm.vec2.Vec2b.Companion.times(res, this, bX, bY)
    @JvmOverloads fun times(bX: Int, bY: Int, res: glm.vec2.Vec2b = glm.vec2.Vec2b()) = glm.vec2.Vec2b.Companion.times(res, this, bX, bY)
    fun times(b: Byte, res: glm.vec2.Vec2b) = glm.vec2.Vec2b.Companion.times(res, this, b, b)
    fun times(b: Int, res: glm.vec2.Vec2b) = glm.vec2.Vec2b.Companion.times(res, this, b, b)
    fun times(b: glm.vec2.Vec2b, res: glm.vec2.Vec2b) = glm.vec2.Vec2b.Companion.times(res, this, b.x, b.y)

    fun times_(bX: Byte, bY: Byte) = glm.vec2.Vec2b.Companion.times(this, this, bX, bY)
    fun times_(bX: Int, bY: Int) = glm.vec2.Vec2b.Companion.times(this, this, bX, bY)
    infix fun times_(b: Byte) = glm.vec2.Vec2b.Companion.times(this, this, b, b)
    infix fun times_(b: Int) = glm.vec2.Vec2b.Companion.times(this, this, b, b)
    infix fun times_(b: glm.vec2.Vec2b) = glm.vec2.Vec2b.Companion.times(this, this, b.x, b.y)


    infix operator fun div(b: Byte) = glm.vec2.Vec2b.Companion.div(Vec2b(), this, b, b)
    infix operator fun div(b: Int) = glm.vec2.Vec2b.Companion.div(Vec2b(), this, b, b)
    infix operator fun div(b: glm.vec2.Vec2b) = glm.vec2.Vec2b.Companion.div(Vec2b(), this, b.x, b.y)

    @JvmOverloads fun div(bX: Byte, bY: Byte, res: glm.vec2.Vec2b = glm.vec2.Vec2b()) = glm.vec2.Vec2b.Companion.div(res, this, bX, bY)
    @JvmOverloads fun div(bX: Int, bY: Int, res: glm.vec2.Vec2b = glm.vec2.Vec2b()) = glm.vec2.Vec2b.Companion.div(res, this, bX, bY)
    fun div(b: Byte, res: glm.vec2.Vec2b) = glm.vec2.Vec2b.Companion.div(res, this, b, b)
    fun div(b: Int, res: glm.vec2.Vec2b) = glm.vec2.Vec2b.Companion.div(res, this, b, b)
    fun div(b: glm.vec2.Vec2b, res: glm.vec2.Vec2b) = glm.vec2.Vec2b.Companion.div(res, this, b.x, b.y)

    fun div_(bX: Byte, bY: Byte) = glm.vec2.Vec2b.Companion.div(this, this, bX, bY)
    fun div_(bX: Int, bY: Int) = glm.vec2.Vec2b.Companion.div(this, this, bX, bY)
    infix fun div_(b: Byte) = glm.vec2.Vec2b.Companion.div(this, this, b, b)
    infix fun div_(b: Int) = glm.vec2.Vec2b.Companion.div(this, this, b, b)
    infix fun div_(b: glm.vec2.Vec2b) = glm.vec2.Vec2b.Companion.div(this, this, b.x, b.y)


    infix operator fun rem(b: Byte) = glm.vec2.Vec2b.Companion.rem(Vec2b(), this, b, b)
    infix operator fun rem(b: Int) = glm.vec2.Vec2b.Companion.rem(Vec2b(), this, b, b)
    infix operator fun rem(b: glm.vec2.Vec2b) = glm.vec2.Vec2b.Companion.rem(Vec2b(), this, b.x, b.y)

    @JvmOverloads fun rem(bX: Byte, bY: Byte, res: glm.vec2.Vec2b = glm.vec2.Vec2b()) = glm.vec2.Vec2b.Companion.rem(res, this, bX, bY)
    @JvmOverloads fun rem(bX: Int, bY: Int, res: glm.vec2.Vec2b = glm.vec2.Vec2b()) = glm.vec2.Vec2b.Companion.rem(res, this, bX, bY)
    fun rem(b: Byte, res: glm.vec2.Vec2b) = glm.vec2.Vec2b.Companion.rem(res, this, b, b)
    fun rem(b: Int, res: glm.vec2.Vec2b) = glm.vec2.Vec2b.Companion.rem(res, this, b, b)
    fun rem(b: glm.vec2.Vec2b, res: glm.vec2.Vec2b) = glm.vec2.Vec2b.Companion.rem(res, this, b.x, b.y)

    fun rem_(bX: Byte, bY: Byte) = glm.vec2.Vec2b.Companion.rem(this, this, bX, bY)
    fun rem_(bX: Int, bY: Int) = glm.vec2.Vec2b.Companion.rem(this, this, bX, bY)
    infix fun rem_(b: Byte) = glm.vec2.Vec2b.Companion.rem(this, this, b, b)
    infix fun rem_(b: Int) = glm.vec2.Vec2b.Companion.rem(this, this, b, b)
    infix fun rem_(b: glm.vec2.Vec2b) = glm.vec2.Vec2b.Companion.rem(this, this, b.x, b.y)


    // -- Generic binary arithmetic infix operators --

    infix operator fun plus(b: Number) = glm.vec2.Vec2b.Companion.plus(Vec2b(), this, b.i, b.i)
    infix operator fun plus(b: glm.vec2.Vec2t<out Number>) = glm.vec2.Vec2b.Companion.plus(Vec2b(), this, b.x.i, b.y.i)

    @JvmOverloads fun plus(bX: Number, bY: Number, res: glm.vec2.Vec2b = glm.vec2.Vec2b()) = glm.vec2.Vec2b.Companion.plus(res, this, bX.i, bY.i)
    fun plus(b: Number, res: glm.vec2.Vec2b) = glm.vec2.Vec2b.Companion.plus(res, this, b.i, b.i)
    fun plus(b: glm.vec2.Vec2t<out Number>, res: glm.vec2.Vec2b) = glm.vec2.Vec2b.Companion.plus(res, this, b.x.i, b.y.i)

    fun plus_(bX: Number, bY: Number) = glm.vec2.Vec2b.Companion.plus(this, this, bX.i, bY.i)
    infix fun plus_(b: Number) = glm.vec2.Vec2b.Companion.plus(this, this, b.i, b.i)
    infix fun plus_(b: glm.vec2.Vec2t<out Number>) = glm.vec2.Vec2b.Companion.plus(this, this, b.x.i, b.y.i)


    infix operator fun minus(b: Number) = glm.vec2.Vec2b.Companion.minus(Vec2b(), this, b.i, b.i)
    infix operator fun minus(b: glm.vec2.Vec2t<out Number>) = glm.vec2.Vec2b.Companion.minus(Vec2b(), this, b.x.i, b.y.i)

    @JvmOverloads fun minus(bX: Number, bY: Number, res: glm.vec2.Vec2b = glm.vec2.Vec2b()) = glm.vec2.Vec2b.Companion.minus(res, this, bX.i, bY.i)
    fun minus(b: Number, res: glm.vec2.Vec2b) = glm.vec2.Vec2b.Companion.minus(res, this, b.i, b.i)
    fun minus(b: glm.vec2.Vec2t<out Number>, res: glm.vec2.Vec2b) = glm.vec2.Vec2b.Companion.minus(res, this, b.x.i, b.y.i)

    fun minus_(bX: Number, bY: Number) = glm.vec2.Vec2b.Companion.minus(this, this, bX.i, bY.i)
    infix fun minus_(b: Number) = glm.vec2.Vec2b.Companion.minus(this, this, b.i, b.i)
    infix fun minus_(b: glm.vec2.Vec2t<out Number>) = glm.vec2.Vec2b.Companion.minus(this, this, b.x.i, b.y.i)


    infix operator fun times(b: Number) = glm.vec2.Vec2b.Companion.times(Vec2b(), this, b.i, b.i)
    infix operator fun times(b: glm.vec2.Vec2t<out Number>) = glm.vec2.Vec2b.Companion.times(Vec2b(), this, b.x.i, b.y.i)

    @JvmOverloads fun times(bX: Number, bY: Number, res: glm.vec2.Vec2b = glm.vec2.Vec2b()) = glm.vec2.Vec2b.Companion.times(res, this, bX.i, bY.i)
    fun times(b: Number, res: glm.vec2.Vec2b) = glm.vec2.Vec2b.Companion.times(res, this, b.i, b.i)
    fun times(b: glm.vec2.Vec2t<out Number>, res: glm.vec2.Vec2b) = glm.vec2.Vec2b.Companion.times(res, this, b.x.i, b.y.i)

    fun times_(bX: Number, bY: Number) = glm.vec2.Vec2b.Companion.times(this, this, bX.i, bY.i)
    infix fun times_(b: Number) = glm.vec2.Vec2b.Companion.times(this, this, b.i, b.i)
    infix fun times_(b: glm.vec2.Vec2t<out Number>) = glm.vec2.Vec2b.Companion.times(this, this, b.x.i, b.y.i)


    infix operator fun div(b: Number) = glm.vec2.Vec2b.Companion.div(Vec2b(), this, b.i, b.i)
    infix operator fun div(b: glm.vec2.Vec2t<out Number>) = glm.vec2.Vec2b.Companion.div(Vec2b(), this, b.x.i, b.y.i)

    @JvmOverloads fun div(bX: Number, bY: Number, res: glm.vec2.Vec2b = glm.vec2.Vec2b()) = glm.vec2.Vec2b.Companion.div(res, this, bX.i, bY.i)
    fun div(b: Number, res: glm.vec2.Vec2b) = glm.vec2.Vec2b.Companion.div(res, this, b.i, b.i)
    fun div(b: glm.vec2.Vec2t<out Number>, res: glm.vec2.Vec2b) = glm.vec2.Vec2b.Companion.div(res, this, b.x.i, b.y.i)

    fun div_(bX: Number, bY: Number) = glm.vec2.Vec2b.Companion.div(this, this, bX.i, bY.i)
    infix fun div_(b: Number) = glm.vec2.Vec2b.Companion.div(this, this, b.i, b.i)
    infix fun div_(b: glm.vec2.Vec2t<out Number>) = glm.vec2.Vec2b.Companion.div(this, this, b.x.i, b.y.i)


    infix operator fun rem(b: Number) = glm.vec2.Vec2b.Companion.rem(Vec2b(), this, b.i, b.i)
    infix operator fun rem(b: glm.vec2.Vec2t<out Number>) = glm.vec2.Vec2b.Companion.rem(Vec2b(), this, b.x.i, b.y.i)

    @JvmOverloads fun rem(bX: Number, bY: Number, res: glm.vec2.Vec2b = glm.vec2.Vec2b()) = glm.vec2.Vec2b.Companion.rem(res, this, bX.i, bY.i)
    fun rem(b: Number, res: glm.vec2.Vec2b) = glm.vec2.Vec2b.Companion.rem(res, this, b.i, b.i)
    fun rem(b: glm.vec2.Vec2t<out Number>, res: glm.vec2.Vec2b) = glm.vec2.Vec2b.Companion.rem(res, this, b.x.i, b.y.i)

    fun rem_(bX: Number, bY: Number) = glm.vec2.Vec2b.Companion.rem(this, this, bX.i, bY.i)
    infix fun rem_(b: Number) = glm.vec2.Vec2b.Companion.rem(this, this, b.i, b.i)
    infix fun rem_(b: glm.vec2.Vec2t<out Number>) = glm.vec2.Vec2b.Companion.rem(this, this, b.x.i, b.y.i)


    // -- Specific bitwise operators --

    infix fun and(b: Byte) = glm.vec2.Vec2b.Companion.and(Vec2b(), this, b, b)
    infix fun and(b: Int) = glm.vec2.Vec2b.Companion.and(Vec2b(), this, b, b)
    infix fun and(b: glm.vec2.Vec2b) = glm.vec2.Vec2b.Companion.and(Vec2b(), this, b.x, b.y)

    fun and(b: Byte, res: glm.vec2.Vec2b) = glm.vec2.Vec2b.Companion.and(res, this, b, b)
    fun and(b: Int, res: glm.vec2.Vec2b) = glm.vec2.Vec2b.Companion.and(res, this, b, b)
    fun and(b: glm.vec2.Vec2b, res: glm.vec2.Vec2b) = glm.vec2.Vec2b.Companion.and(res, this, b.x, b.y)
    @JvmOverloads fun and(bX: Byte, bY: Byte, res: glm.vec2.Vec2b = glm.vec2.Vec2b()) = glm.vec2.Vec2b.Companion.and(res, this, bX, bY)
    @JvmOverloads fun and(bX: Int, bY: Int, res: glm.vec2.Vec2b = glm.vec2.Vec2b()) = glm.vec2.Vec2b.Companion.and(res, this, bX, bY)

    infix fun and_(b: Byte) = glm.vec2.Vec2b.Companion.and(this, this, b, b)
    infix fun and_(b: Int) = glm.vec2.Vec2b.Companion.and(this, this, b, b)
    infix fun and_(b: glm.vec2.Vec2b) = glm.vec2.Vec2b.Companion.and(this, this, b.x, b.y)
    fun and_(bX: Byte, bY: Byte) = glm.vec2.Vec2b.Companion.and(this, this, bX, bY)
    fun and_(bX: Int, bY: Int) = glm.vec2.Vec2b.Companion.and(this, this, bX, bY)


    infix fun or(b: Byte) = glm.vec2.Vec2b.Companion.or(Vec2b(), this, b, b)
    infix fun or(b: Int) = glm.vec2.Vec2b.Companion.or(Vec2b(), this, b, b)
    infix fun or(b: glm.vec2.Vec2b) = glm.vec2.Vec2b.Companion.or(Vec2b(), this, b.x, b.y)

    fun or(b: Byte, res: glm.vec2.Vec2b) = glm.vec2.Vec2b.Companion.or(res, this, b, b)
    fun or(b: Int, res: glm.vec2.Vec2b) = glm.vec2.Vec2b.Companion.or(res, this, b, b)
    fun or(b: glm.vec2.Vec2b, res: glm.vec2.Vec2b) = glm.vec2.Vec2b.Companion.or(res, this, b.x, b.y)
    @JvmOverloads fun or(bX: Byte, bY: Byte, res: glm.vec2.Vec2b = glm.vec2.Vec2b()) = glm.vec2.Vec2b.Companion.or(res, this, bX, bY)
    @JvmOverloads fun or(bX: Int, bY: Int, res: glm.vec2.Vec2b = glm.vec2.Vec2b()) = glm.vec2.Vec2b.Companion.or(res, this, bX, bY)

    infix fun or_(b: Byte) = glm.vec2.Vec2b.Companion.or(this, this, b, b)
    infix fun or_(b: Int) = glm.vec2.Vec2b.Companion.or(this, this, b, b)
    infix fun or_(b: glm.vec2.Vec2b) = glm.vec2.Vec2b.Companion.or(this, this, b.x, b.y)
    fun or_(bX: Byte, bY: Byte) = glm.vec2.Vec2b.Companion.or(this, this, bX, bY)
    fun or_(bX: Int, bY: Int) = glm.vec2.Vec2b.Companion.or(this, this, bX, bY)


    infix fun xor(b: Byte) = glm.vec2.Vec2b.Companion.xor(Vec2b(), this, b, b)
    infix fun xor(b: Int) = glm.vec2.Vec2b.Companion.xor(Vec2b(), this, b, b)
    infix fun xor(b: glm.vec2.Vec2b) = glm.vec2.Vec2b.Companion.xor(Vec2b(), this, b.x, b.y)

    fun xor(b: Byte, res: glm.vec2.Vec2b) = glm.vec2.Vec2b.Companion.xor(res, this, b, b)
    fun xor(b: Int, res: glm.vec2.Vec2b) = glm.vec2.Vec2b.Companion.xor(res, this, b, b)
    fun xor(b: glm.vec2.Vec2b, res: glm.vec2.Vec2b) = glm.vec2.Vec2b.Companion.xor(res, this, b.x, b.y)
    @JvmOverloads fun xor(bX: Byte, bY: Byte, res: glm.vec2.Vec2b = glm.vec2.Vec2b()) = glm.vec2.Vec2b.Companion.xor(res, this, bX, bY)
    @JvmOverloads fun xor(bX: Int, bY: Int, res: glm.vec2.Vec2b = glm.vec2.Vec2b()) = glm.vec2.Vec2b.Companion.xor(res, this, bX, bY)

    infix fun xor_(b: Byte) = glm.vec2.Vec2b.Companion.xor(this, this, b, b)
    infix fun xor_(b: Int) = glm.vec2.Vec2b.Companion.xor(this, this, b, b)
    infix fun xor_(b: glm.vec2.Vec2b) = glm.vec2.Vec2b.Companion.xor(this, this, b.x, b.y)
    fun xor_(bX: Byte, bY: Byte) = glm.vec2.Vec2b.Companion.xor(this, this, bX, bY)
    fun xor_(bX: Int, bY: Int) = glm.vec2.Vec2b.Companion.xor(this, this, bX, bY)


    infix fun shl(b: Byte) = glm.vec2.Vec2b.Companion.shl(Vec2b(), this, b, b)
    infix fun shl(b: Int) = glm.vec2.Vec2b.Companion.shl(Vec2b(), this, b, b)
    infix fun shl(b: glm.vec2.Vec2b) = glm.vec2.Vec2b.Companion.shl(Vec2b(), this, b.x, b.y)

    fun shl(b: Byte, res: glm.vec2.Vec2b) = glm.vec2.Vec2b.Companion.shl(res, this, b, b)
    fun shl(b: Int, res: glm.vec2.Vec2b) = glm.vec2.Vec2b.Companion.shl(res, this, b, b)
    fun shl(b: glm.vec2.Vec2b, res: glm.vec2.Vec2b) = glm.vec2.Vec2b.Companion.shl(res, this, b.x, b.y)
    @JvmOverloads fun shl(bX: Byte, bY: Byte, res: glm.vec2.Vec2b = glm.vec2.Vec2b()) = glm.vec2.Vec2b.Companion.shl(res, this, bX, bY)
    @JvmOverloads fun shl(bX: Int, bY: Int, res: glm.vec2.Vec2b = glm.vec2.Vec2b()) = glm.vec2.Vec2b.Companion.shl(res, this, bX, bY)

    infix fun shl_(b: Byte) = glm.vec2.Vec2b.Companion.shl(this, this, b, b)
    infix fun shl_(b: Int) = glm.vec2.Vec2b.Companion.shl(this, this, b, b)
    infix fun shl_(b: glm.vec2.Vec2b) = glm.vec2.Vec2b.Companion.shl(this, this, b.x, b.y)
    fun shl_(bX: Byte, bY: Byte) = glm.vec2.Vec2b.Companion.shl(this, this, bX, bY)
    fun shl_(bX: Int, bY: Int) = glm.vec2.Vec2b.Companion.shl(this, this, bX, bY)


    infix fun shr(b: Byte) = glm.vec2.Vec2b.Companion.shr(Vec2b(), this, b, b)
    infix fun shr(b: Int) = glm.vec2.Vec2b.Companion.shr(Vec2b(), this, b, b)
    infix fun shr(b: glm.vec2.Vec2b) = glm.vec2.Vec2b.Companion.shr(Vec2b(), this, b.x, b.y)

    fun shr(b: Byte, res: glm.vec2.Vec2b) = glm.vec2.Vec2b.Companion.shr(res, this, b, b)
    fun shr(b: Int, res: glm.vec2.Vec2b) = glm.vec2.Vec2b.Companion.shr(res, this, b, b)
    fun shr(b: glm.vec2.Vec2b, res: glm.vec2.Vec2b) = glm.vec2.Vec2b.Companion.shr(res, this, b.x, b.y)
    @JvmOverloads fun shr(bX: Byte, bY: Byte, res: glm.vec2.Vec2b = glm.vec2.Vec2b()) = glm.vec2.Vec2b.Companion.shr(res, this, bX, bY)
    @JvmOverloads fun shr(bX: Int, bY: Int, res: glm.vec2.Vec2b = glm.vec2.Vec2b()) = glm.vec2.Vec2b.Companion.shr(res, this, bX, bY)

    infix fun shr_(b: Byte) = glm.vec2.Vec2b.Companion.shr(this, this, b, b)
    infix fun shr_(b: Int) = glm.vec2.Vec2b.Companion.shr(this, this, b, b)
    infix fun shr_(b: glm.vec2.Vec2b) = glm.vec2.Vec2b.Companion.shr(this, this, b.x, b.y)
    fun shr_(bX: Byte, bY: Byte) = glm.vec2.Vec2b.Companion.shr(this, this, bX, bY)
    fun shr_(bX: Int, bY: Int) = glm.vec2.Vec2b.Companion.shr(this, this, bX, bY)


    @JvmOverloads fun inv(res: glm.vec2.Vec2b = glm.vec2.Vec2b()) = glm.vec2.Vec2b.Companion.inv(res, this)
    fun inv_() = glm.vec2.Vec2b.Companion.inv(this, this)


    // -- Generic bitwise operators --

    infix fun and(b: Number) = glm.vec2.Vec2b.Companion.and(Vec2b(), this, b.b, b.b)
    infix fun and(b: glm.vec2.Vec2t<out Number>) = glm.vec2.Vec2b.Companion.and(Vec2b(), this, b.x.b, b.y.b)

    fun and(b: Number, res: glm.vec2.Vec2b) = glm.vec2.Vec2b.Companion.and(res, this, b.b, b.b)
    fun and(b: glm.vec2.Vec2t<out Number>, res: glm.vec2.Vec2b) = glm.vec2.Vec2b.Companion.and(res, this, b.x.b, b.y.b)
    @JvmOverloads fun and(bX: Number, bY: Number, res: glm.vec2.Vec2b = glm.vec2.Vec2b()) = glm.vec2.Vec2b.Companion.and(res, this, bX.b, bY.b)

    infix fun and_(b: Number) = glm.vec2.Vec2b.Companion.and(this, this, b.b, b.b)
    infix fun and_(b: glm.vec2.Vec2t<out Number>) = glm.vec2.Vec2b.Companion.and(this, this, b.x.b, b.y.b)
    fun and_(bX: Number, bY: Number) = glm.vec2.Vec2b.Companion.and(this, this, bX.b, bY.b)


    infix fun or(b: Number) = glm.vec2.Vec2b.Companion.or(Vec2b(), this, b.b, b.b)
    infix fun or(b: glm.vec2.Vec2t<out Number>) = glm.vec2.Vec2b.Companion.or(Vec2b(), this, b.x.b, b.y.b)

    fun or(b: Number, res: glm.vec2.Vec2b) = glm.vec2.Vec2b.Companion.or(res, this, b.b, b.b)
    fun or(b: glm.vec2.Vec2t<out Number>, res: glm.vec2.Vec2b) = glm.vec2.Vec2b.Companion.or(res, this, b.x.b, b.y.b)
    @JvmOverloads fun or(bX: Number, bY: Number, res: glm.vec2.Vec2b = glm.vec2.Vec2b()) = glm.vec2.Vec2b.Companion.or(res, this, bX.b, bY.b)

    infix fun or_(b: Number) = glm.vec2.Vec2b.Companion.or(this, this, b.b, b.b)
    infix fun or_(b: glm.vec2.Vec2t<out Number>) = glm.vec2.Vec2b.Companion.or(this, this, b.x.b, b.y.b)
    fun or_(bX: Number, bY: Number) = glm.vec2.Vec2b.Companion.or(this, this, bX.b, bY.b)


    infix fun xor(b: Number) = glm.vec2.Vec2b.Companion.xor(Vec2b(), this, b.b, b.b)
    infix fun xor(b: glm.vec2.Vec2t<out Number>) = glm.vec2.Vec2b.Companion.xor(Vec2b(), this, b.x.b, b.y.b)

    fun xor(b: Number, res: glm.vec2.Vec2b) = glm.vec2.Vec2b.Companion.xor(res, this, b.b, b.b)
    fun xor(b: glm.vec2.Vec2t<out Number>, res: glm.vec2.Vec2b) = glm.vec2.Vec2b.Companion.xor(res, this, b.x.b, b.y.b)
    @JvmOverloads fun xor(bX: Number, bY: Number, res: glm.vec2.Vec2b = glm.vec2.Vec2b()) = glm.vec2.Vec2b.Companion.xor(res, this, bX.b, bY.b)

    infix fun xor_(b: Number) = glm.vec2.Vec2b.Companion.xor(this, this, b.b, b.b)
    infix fun xor_(b: glm.vec2.Vec2t<out Number>) = glm.vec2.Vec2b.Companion.xor(this, this, b.x.b, b.y.b)
    fun xor_(bX: Number, bY: Number) = glm.vec2.Vec2b.Companion.xor(this, this, bX.b, bY.b)


    infix fun shl(b: Number) = glm.vec2.Vec2b.Companion.shl(Vec2b(), this, b.b, b.b)
    infix fun shl(b: glm.vec2.Vec2t<out Number>) = glm.vec2.Vec2b.Companion.shl(Vec2b(), this, b.x.b, b.y.b)

    fun shl(b: Number, res: glm.vec2.Vec2b) = glm.vec2.Vec2b.Companion.shl(res, this, b.b, b.b)
    fun shl(b: glm.vec2.Vec2t<out Number>, res: glm.vec2.Vec2b) = glm.vec2.Vec2b.Companion.shl(res, this, b.x.b, b.y.b)
    @JvmOverloads fun shl(bX: Number, bY: Number, res: glm.vec2.Vec2b = glm.vec2.Vec2b()) = glm.vec2.Vec2b.Companion.shl(res, this, bX.b, bY.b)

    infix fun shl_(b: Number) = glm.vec2.Vec2b.Companion.shl(this, this, b.b, b.b)
    infix fun shl_(b: glm.vec2.Vec2t<out Number>) = glm.vec2.Vec2b.Companion.shl(this, this, b.x.b, b.y.b)
    fun shl_(bX: Number, bY: Number) = glm.vec2.Vec2b.Companion.shl(this, this, bX.b, bY.b)


    infix fun shr(b: Number) = glm.vec2.Vec2b.Companion.shr(Vec2b(), this, b.b, b.b)
    infix fun shr(b: glm.vec2.Vec2t<out Number>) = glm.vec2.Vec2b.Companion.shr(Vec2b(), this, b.x.b, b.y.b)

    fun shr(b: Number, res: glm.vec2.Vec2b) = glm.vec2.Vec2b.Companion.shr(res, this, b.b, b.b)
    fun shr(b: glm.vec2.Vec2t<out Number>, res: glm.vec2.Vec2b) = glm.vec2.Vec2b.Companion.shr(res, this, b.x.b, b.y.b)
    @JvmOverloads fun shr(bX: Number, bY: Number, res: glm.vec2.Vec2b = glm.vec2.Vec2b()) = glm.vec2.Vec2b.Companion.shr(res, this, bX.b, bY.b)

    infix fun shr_(b: Number) = glm.vec2.Vec2b.Companion.shr(this, this, b.b, b.b)
    infix fun shr_(b: glm.vec2.Vec2t<out Number>) = glm.vec2.Vec2b.Companion.shr(this, this, b.x.b, b.y.b)
    fun shr_(bX: Number, bY: Number) = glm.vec2.Vec2b.Companion.shr(this, this, bX.b, bY.b)


    override fun equals(other: Any?) =
            if (other is glm.vec2.Vec2b)
                this[0] == other[0] && this[1] == other[1]
            else false
}