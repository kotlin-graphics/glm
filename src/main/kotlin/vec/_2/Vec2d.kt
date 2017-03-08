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

    operator fun get(i: Int) = when (i) {
        0 -> x
        1 -> y
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

    operator fun inc(res: Vec2d = Vec2d()) = add(res, this, 1.0, 1.0)
    fun inc_() = add(this, this, 1.0, 1.0)


    operator fun dec(res: Vec2d = Vec2d()) = sub(res, this, 1.0, 1.0)
    fun dec_() = sub(this, this, 1.0, 1.0)


    // -- Specific binary arithmetic operators --

    operator fun plus(b: Double) = add(Vec2d(), this, b, b)
    operator fun plus(b: Vec2d) = add(Vec2d(), this, b.x, b.y)

    fun add(bX: Double, bY: Double, res: Vec2d = Vec2d()) = add(res, this, bX, bY)
    fun add(b: Double, res: Vec2d = Vec2d()) = add(res, this, b, b)
    fun add(b: Vec2d, res: Vec2d = Vec2d()) = add(res, this, b.x, b.y)

    fun add_(bX: Double, bY: Double) = add(this, this, bX, bY)
    infix fun add_(b: Double) = add(this, this, b, b)
    infix fun add_(b: Vec2d) = add(this, this, b.x, b.y)


    operator fun minus(b: Double) = sub(Vec2d(), this, b, b)
    operator fun minus(b: Vec2d) = sub(Vec2d(), this, b.x, b.y)

    fun sub(bX: Double, bY: Double, res: Vec2d = Vec2d()) = sub(res, this, bX, bY)
    fun sub(b: Double, res: Vec2d = Vec2d()) = sub(res, this, b, b)
    fun sub(b: Vec2d, res: Vec2d = Vec2d()) = sub(res, this, b.x, b.y)

    fun sub_(bX: Double, bY: Double) = sub(this, this, bX, bY)
    infix fun sub_(b: Double) = sub(this, this, b, b)
    infix fun sub_(b: Vec2d) = sub(this, this, b.x, b.y)


    operator fun times(b: Double) = mul(Vec2d(), this, b, b)
    operator fun times(b: Vec2d) = mul(Vec2d(), this, b.x, b.y)

    fun mul(bX: Double, bY: Double, res: Vec2d = Vec2d()) = mul(res, this, bX, bY)
    fun mul(b: Double, res: Vec2d = Vec2d()) = mul(res, this, b, b)
    fun mul(b: Vec2d, res: Vec2d = Vec2d()) = mul(res, this, b.x, b.y)

    fun mul_(bX: Double, bY: Double) = mul(this, this, bX, bY)
    infix fun mul_(b: Double) = mul(this, this, b, b)
    infix fun mul_(b: Vec2d) = mul(this, this, b.x, b.y)


    operator fun div(b: Double) = div(Vec2d(), this, b, b)
    operator fun div(b: Vec2d) = div(Vec2d(), this, b.x, b.y)

    fun div(bX: Double, bY: Double, res: Vec2d = Vec2d()) = div(res, this, bX, bY)
    fun div(b: Double, res: Vec2d = Vec2d()) = div(res, this, b, b)
    fun div(b: Vec2d, res: Vec2d = Vec2d()) = div(res, this, b.x, b.y)

    fun div_(bX: Double, bY: Double) = div(this, this, bX, bY)
    infix fun div_(b: Double) = div(this, this, b, b)
    infix fun div_(b: Vec2d) = div(this, this, b.x, b.y)


    operator fun rem(b: Double) = rem(Vec2d(), this, b, b)
    operator fun rem(b: Vec2d) = rem(Vec2d(), this, b.x, b.y)

    fun rem(bX: Double, bY: Double, res: Vec2d = Vec2d()) = rem(res, this, bX, bY)
    fun rem(b: Double, res: Vec2d = Vec2d()) = rem(res, this, b, b)
    fun rem(b: Vec2d, res: Vec2d = Vec2d()) = rem(res, this, b.x, b.y)

    fun rem_(bX: Double, bY: Double) = rem(this, this, bX, bY)
    infix fun rem_(b: Double) = rem(this, this, b, b)
    infix fun rem_(b: Vec2d) = rem(this, this, b.x, b.y)


    // -- Generic binary arithmetic operators --

    operator fun plus(b: Number) = add(Vec2d(), this, b.d, b.d)
    operator fun plus(b: Vec2t<Number>) = add(Vec2d(), this, b.x.d, b.y.d)

    fun add(bX: Number, bY: Number, res: Vec2d = Vec2d()) = add(res, this, bX.d, bY.d)
    fun add(b: Number, res: Vec2d = Vec2d()) = add(res, this, b.d, b.d)
    fun add(b: Vec2t<Number>, res: Vec2d = Vec2d()) = add(res, this, b.x.d, b.y.d)

    fun add_(bX: Number, bY: Number) = add(this, this, bX.d, bY.d)
    infix fun add_(b: Number) = add(this, this, b.d, b.d)
    infix fun add_(b: Vec2t<Number>) = add(this, this, b.x.d, b.y.d)


    operator fun minus(b: Number) = sub(Vec2d(), this, b.d, b.d)
    operator fun minus(b: Vec2t<Number>) = sub(Vec2d(), this, b.x.d, b.y.d)

    fun sub(bX: Number, bY: Number, res: Vec2d = Vec2d()) = sub(res, this, bX.d, bY.d)
    fun sub(b: Number, res: Vec2d = Vec2d()) = sub(res, this, b.d, b.d)
    fun sub(b: Vec2t<Number>, res: Vec2d = Vec2d()) = sub(res, this, b.x.d, b.y.d)

    fun sub_(bX: Number, bY: Number) = sub(this, this, bX.d, bY.d)
    infix fun sub_(b: Number) = sub(this, this, b.d, b.d)
    infix fun sub_(b: Vec2t<Number>) = sub(this, this, b.x.d, b.y.d)


    operator fun times(b: Number) = mul(Vec2d(), this, b.d, b.d)
    operator fun times(b: Vec2t<Number>) = mul(Vec2d(), this, b.x.d, b.y.d)

    fun mul(bX: Number, bY: Number, res: Vec2d = Vec2d()) = mul(res, this, bX.d, bY.d)
    fun mul(b: Number, res: Vec2d = Vec2d()) = mul(res, this, b.d, b.d)
    fun mul(b: Vec2t<Number>, res: Vec2d = Vec2d()) = mul(res, this, b.x.d, b.y.d)

    fun mul_(bX: Number, bY: Number) = mul(this, this, bX.d, bY.d)
    infix fun mul_(b: Number) = mul(this, this, b.d, b.d)
    infix fun mul_(b: Vec2t<Number>) = mul(this, this, b.x.d, b.y.d)


    operator fun div(b: Number) = div(Vec2d(), this, b.d, b.d)
    operator fun div(b: Vec2t<Number>) = div(Vec2d(), this, b.x.d, b.y.d)

    fun div(bX: Number, bY: Number, res: Vec2d = Vec2d()) = div(res, this, bX.d, bY.d)
    fun div(b: Number, res: Vec2d = Vec2d()) = div(res, this, b.d, b.d)
    fun div(b: Vec2t<Number>, res: Vec2d = Vec2d()) = div(res, this, b.x.d, b.y.d)

    fun div_(bX: Number, bY: Number) = div(this, this, bX.d, bY.d)
    infix fun div_(b: Number) = div(this, this, b.d, b.d)
    infix fun div_(b: Vec2t<Number>) = div(this, this, b.x.d, b.y.d)


    operator fun rem(b: Number) = rem(Vec2d(), this, b.d, b.d)
    operator fun rem(b: Vec2t<Number>) = rem(Vec2d(), this, b.x.d, b.y.d)

    fun rem(bX: Number, bY: Number, res: Vec2d = Vec2d()) = rem(res, this, bX.d, bY.d)
    fun rem(b: Number, res: Vec2d = Vec2d()) = rem(res, this, b.d, b.d)
    fun rem(b: Vec2t<Number>, res: Vec2d = Vec2d()) = rem(res, this, b.x.d, b.y.d)

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