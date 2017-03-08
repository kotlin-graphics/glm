package vec._2

import glm.BYTES
import glm.d
import glm.getDouble
import glm.glm
import vec.Vec2t
import vec.Vec3t
import vec.Vec4t
import vec._2.operators.vec2d_operators
import vec.bool.Vec2bool
import vec.bool.Vec3bool
import vec.bool.Vec4bool
import java.nio.*

/**
 * Created bY GBarbieri on 06.10.2016.
 */

class Vec2d(x: Double, y: Double) : Vec2t<Double>(x, y) {

    // -- Explicit basic, conversion other main.and conversion vector constructors --

    constructor() : this(0)

    constructor(v: Vec2t<out Number>) : this(v.x, v.y)
    constructor(v: Vec3t<out Number>) : this(v.x, v.y)
    constructor(v: Vec4t<out Number>) : this(v.x, v.y)

    constructor(v: Vec2bool) : this(v.x.d, v.y.d)
    constructor(v: Vec3bool) : this(v.x.d, v.y.d)
    constructor(v: Vec4bool) : this(v.x.d, v.y.d)

    constructor(bytes: ByteArray, index: Int = 0, oneByteOneDouble: Boolean = true, bigEndianess: Boolean = true) : this(
            if (oneByteOneDouble) bytes[index].d else bytes.getDouble(index, bigEndianess),
            if (oneByteOneDouble) bytes[index + 1].d else bytes.getDouble(index + Double.BYTES, bigEndianess))

    constructor(chars: CharArray, index: Int = 0) : this(chars[index].d, chars[index + 1].d)
    constructor(shorts: ShortArray, index: Int = 0) : this(shorts[index], shorts[index + 1])
    constructor(ints: IntArray, index: Int = 0) : this(ints[index], ints[index + 1])
    constructor(longs: LongArray, index: Int = 0) : this(longs[index], longs[index + 1])
    constructor(floats: FloatArray, index: Int = 0) : this(floats[index], floats[index + 1])
    constructor(doubles: DoubleArray, index: Int = 0) : this(doubles[index], doubles[index + 1])
    constructor(booleans: BooleanArray, index: Int = 0) : this(booleans[index].d, booleans[index + 1].d)

    constructor(numbers: Array<out Number>, index: Int = 0) : this(numbers[index], numbers[index + 1])
    constructor(chars: Array<Char>, index: Int = 0) : this(chars[index].d, chars[index + 1].d)
    constructor(booleans: Array<Boolean>, index: Int = 0) : this(booleans[index].d, booleans[index + 1].d)

    constructor(list: List<Any>, index: Int = 0) : this() {
        put(list, index)
    }

    constructor(bytes: ByteBuffer, index: Int = bytes.position(), oneByteOneDouble: Boolean = true) : this(
            if (oneByteOneDouble) bytes[index].d else bytes.getDouble(index),
            if (oneByteOneDouble) bytes[index + 1].d else bytes.getDouble(index + Double.BYTES))

    constructor(chars: CharBuffer, index: Int = chars.position()) : this(chars[index].d, chars[index + 1].d)
    constructor(shorts: ShortBuffer, index: Int = shorts.position()) : this(shorts[index], shorts[index + 1])
    constructor(ints: IntBuffer, index: Int = ints.position()) : this(ints[index], ints[index + 1])
    constructor(longs: LongBuffer, index: Int = longs.position()) : this(longs[index], longs[index + 1])
    constructor(floats: FloatBuffer, index: Int = floats.position()) : this(floats[index], floats[index + 1])
    constructor(doubles: DoubleBuffer, index: Int = doubles.position()) : this(doubles[index], doubles[index + 1])

    constructor(s: Number) : this(s, s)
    constructor(x: Number, y: Number) : this(x.d, y.d)


    fun set(bytes: ByteArray, index: Int = 0, oneByteOneDouble: Boolean = true, bigEndianess: Boolean = true) {
        x = if (oneByteOneDouble) bytes[index].d else bytes.getDouble(index, bigEndianess)
        y = if (oneByteOneDouble) bytes[index + 1].d else bytes.getDouble(index + Double.BYTES, bigEndianess)
    }

    fun set(bytes: ByteBuffer, index: Int = bytes.position(), oneByteOneDouble: Boolean = true) {
        x = if (oneByteOneDouble) bytes[index].d else bytes.getDouble(index)
        y = if (oneByteOneDouble) bytes[index + 1].d else bytes.getDouble(index + Double.BYTES)
    }


    override fun put(x: Number, y: Number): Vec2d {
        this.x = x.d
        this.y = y.d
        return this
    }


    // -- Component accesses --

    infix operator fun get(i: Int) = when (i) {
        0 -> x
        1 -> y
        else -> throw ArrayIndexOutOfBoundsException()
    }

    operator fun set(i: Int, s: Double) = when (i) {
        0 -> x = s
        1 -> y = s
        else -> throw ArrayIndexOutOfBoundsException()
    }

    operator fun set(i: Int, s: Number) = when (i) {
        0 -> x = s.d
        1 -> y = s.d
        else -> throw ArrayIndexOutOfBoundsException()
    }


    companion object : vec2d_operators {
        @JvmField val length = 2
        @JvmField val SIZE = length * Double.BYTES
    }


    // -- Unary arithmetic operators --

    operator fun unaryPlus() = this

    operator fun unaryMinus() = Vec2d(-x, -y)

    // -- Increment main.and decrement operators --

    @JvmOverloads operator fun inc(res: Vec2d = Vec2d()) = plus(res, this, 1.0, 1.0)
    fun inc_() = plus(this, this, 1.0, 1.0)


    @JvmOverloads operator fun dec(res: Vec2d = Vec2d()) = minus(res, this, 1.0, 1.0)
    fun dec_() = minus(this, this, 1.0, 1.0)


    // -- Specific binary arithmetic operators --

    infix operator fun plus(b: Double) = plus(Vec2d(), this, b, b)
    infix operator fun plus(b: Vec2d) = plus(Vec2d(), this, b.x, b.y)

    fun plus(bX: Double, bY: Double, res: Vec2d = Vec2d()) = plus(res, this, bX, bY)
    fun plus(b: Double, res: Vec2d) = plus(res, this, b, b)
    fun plus(b: Vec2d, res: Vec2d) = plus(res, this, b.x, b.y)

    fun plus_(bX: Double, bY: Double) = plus(this, this, bX, bY)
    infix fun plus_(b: Double) = plus(this, this, b, b)
    infix fun plus_(b: Vec2d) = plus(this, this, b.x, b.y)


    infix operator fun minus(b: Double) = minus(Vec2d(), this, b, b)
    infix operator fun minus(b: Vec2d) = minus(Vec2d(), this, b.x, b.y)

    fun minus(bX: Double, bY: Double, res: Vec2d = Vec2d()) = minus(res, this, bX, bY)
    fun minus(b: Double, res: Vec2d) = minus(res, this, b, b)
    fun minus(b: Vec2d, res: Vec2d) = minus(res, this, b.x, b.y)

    fun minus_(bX: Double, bY: Double) = minus(this, this, bX, bY)
    infix fun minus_(b: Double) = minus(this, this, b, b)
    infix fun minus_(b: Vec2d) = minus(this, this, b.x, b.y)


    infix operator fun times(b: Double) = times(Vec2d(), this, b, b)
    infix operator fun times(b: Vec2d) = times(Vec2d(), this, b.x, b.y)

    fun times(bX: Double, bY: Double, res: Vec2d = Vec2d()) = times(res, this, bX, bY)
    fun times(b: Double, res: Vec2d) = times(res, this, b, b)
    fun times(b: Vec2d, res: Vec2d) = times(res, this, b.x, b.y)

    fun times_(bX: Double, bY: Double) = times(this, this, bX, bY)
    infix fun times_(b: Double) = times(this, this, b, b)
    infix fun times_(b: Vec2d) = times(this, this, b.x, b.y)


    infix operator fun div(b: Double) = div(Vec2d(), this, b, b)
    infix operator fun div(b: Vec2d) = div(Vec2d(), this, b.x, b.y)

    fun div(bX: Double, bY: Double, res: Vec2d = Vec2d()) = div(res, this, bX, bY)
    fun div(b: Double, res: Vec2d) = div(res, this, b, b)
    fun div(b: Vec2d, res: Vec2d) = div(res, this, b.x, b.y)

    fun div_(bX: Double, bY: Double) = div(this, this, bX, bY)
    infix fun div_(b: Double) = div(this, this, b, b)
    infix fun div_(b: Vec2d) = div(this, this, b.x, b.y)


    infix operator fun rem(b: Double) = rem(Vec2d(), this, b, b)
    infix operator fun rem(b: Vec2d) = rem(Vec2d(), this, b.x, b.y)

    fun rem(bX: Double, bY: Double, res: Vec2d = Vec2d()) = rem(res, this, bX, bY)
    fun rem(b: Double, res: Vec2d) = rem(res, this, b, b)
    fun rem(b: Vec2d, res: Vec2d) = rem(res, this, b.x, b.y)

    fun rem_(bX: Double, bY: Double) = rem(this, this, bX, bY)
    infix fun rem_(b: Double) = rem(this, this, b, b)
    infix fun rem_(b: Vec2d) = rem(this, this, b.x, b.y)


    // -- Generic binary arithmetic operators --

    infix operator fun plus(b: Number) = plus(Vec2d(), this, b.d, b.d)
    infix operator fun plus(b: Vec2t<Number>) = plus(Vec2d(), this, b.x.d, b.y.d)

    fun plus(bX: Number, bY: Number, res: Vec2d = Vec2d()) = plus(res, this, bX.d, bY.d)
    fun plus(b: Number, res: Vec2d) = plus(res, this, b.d, b.d)
    fun plus(b: Vec2t<Number>, res: Vec2d) = plus(res, this, b.x.d, b.y.d)

    fun plus_(bX: Number, bY: Number) = plus(this, this, bX.d, bY.d)
    infix fun plus_(b: Number) = plus(this, this, b.d, b.d)
    infix fun plus_(b: Vec2t<Number>) = plus(this, this, b.x.d, b.y.d)


    infix operator fun minus(b: Number) = minus(Vec2d(), this, b.d, b.d)
    infix operator fun minus(b: Vec2t<Number>) = minus(Vec2d(), this, b.x.d, b.y.d)

    fun minus(bX: Number, bY: Number, res: Vec2d = Vec2d()) = minus(res, this, bX.d, bY.d)
    fun minus(b: Number, res: Vec2d) = minus(res, this, b.d, b.d)
    fun minus(b: Vec2t<Number>, res: Vec2d) = minus(res, this, b.x.d, b.y.d)

    fun minus_(bX: Number, bY: Number) = minus(this, this, bX.d, bY.d)
    infix fun minus_(b: Number) = minus(this, this, b.d, b.d)
    infix fun minus_(b: Vec2t<Number>) = minus(this, this, b.x.d, b.y.d)


    infix operator fun times(b: Number) = times(Vec2d(), this, b.d, b.d)
    infix operator fun times(b: Vec2t<Number>) = times(Vec2d(), this, b.x.d, b.y.d)

    fun times(bX: Number, bY: Number, res: Vec2d = Vec2d()) = times(res, this, bX.d, bY.d)
    fun times(b: Number, res: Vec2d) = times(res, this, b.d, b.d)
    fun times(b: Vec2t<Number>, res: Vec2d) = times(res, this, b.x.d, b.y.d)

    fun times_(bX: Number, bY: Number) = times(this, this, bX.d, bY.d)
    infix fun times_(b: Number) = times(this, this, b.d, b.d)
    infix fun times_(b: Vec2t<Number>) = times(this, this, b.x.d, b.y.d)


    infix operator fun div(b: Number) = div(Vec2d(), this, b.d, b.d)
    infix operator fun div(b: Vec2t<Number>) = div(Vec2d(), this, b.x.d, b.y.d)

    fun div(bX: Number, bY: Number, res: Vec2d = Vec2d()) = div(res, this, bX.d, bY.d)
    fun div(b: Number, res: Vec2d) = div(res, this, b.d, b.d)
    fun div(b: Vec2t<Number>, res: Vec2d) = div(res, this, b.x.d, b.y.d)

    fun div_(bX: Number, bY: Number) = div(this, this, bX.d, bY.d)
    infix fun div_(b: Number) = div(this, this, b.d, b.d)
    infix fun div_(b: Vec2t<Number>) = div(this, this, b.x.d, b.y.d)


    infix operator fun rem(b: Number) = rem(Vec2d(), this, b.d, b.d)
    infix operator fun rem(b: Vec2t<Number>) = rem(Vec2d(), this, b.x.d, b.y.d)

    fun rem(bX: Number, bY: Number, res: Vec2d = Vec2d()) = rem(res, this, bX.d, bY.d)
    fun rem(b: Number, res: Vec2d) = rem(res, this, b.d, b.d)
    fun rem(b: Vec2t<Number>, res: Vec2d) = rem(res, this, b.x.d, b.y.d)

    fun rem_(bX: Number, bY: Number) = rem(this, this, bX.d, bY.d)
    infix fun rem_(b: Number) = rem(this, this, b.d, b.d)
    infix fun rem_(b: Vec2t<Number>) = rem(this, this, b.x.d, b.y.d)


    // -- functions --

    fun length() = glm.length(this)

    @JvmOverloads fun normalize(res: Vec2d = Vec2d()) = glm.normalize(this, res) // TODO others
    fun normalize_() = glm.normalize(this, this)

    @JvmOverloads fun negate(res: Vec2d = Vec2d()): Vec2d {
        x = -x
        y = -y
        return this
    }
    fun negate_() = negate(this)


    override fun equals(other: Any?) =
            if (other is Vec2d)
                this[0] == other[0] && this[1] == other[1]
            else false
}