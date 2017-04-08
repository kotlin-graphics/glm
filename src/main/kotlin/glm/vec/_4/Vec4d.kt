package glm.vec._4

import glm.BYTES
import glm.d
import glm.getDouble
import glm.vec.Vec2t
import glm.vec.Vec3t
import glm.vec.Vec4t
import glm.vec._4.operators.vec4d_operators
import glm.vec.bool.Vec2bool
import glm.vec.bool.Vec3bool
import glm.vec.bool.Vec4bool
import java.nio.*

/**
 * Created by elect on 09/10/16.
 */

class Vec4d(x: Double, y: Double, z: Double, w: Double) : Vec4t<Double>(x, y, z, w) {

    // -- Explicit basic, conversion other main.and conversion vector constructors --

    constructor() : this(0)

    constructor(v: Vec2t<out Number>) : this(v.x, v.y, 0, 1)
    constructor(v: Vec3t<out Number>) : this(v.x, v.y, v.z, 1)
    constructor(v: Vec4t<out Number>) : this(v.x, v.y, v.z, v.w)

    constructor(v: Vec2bool) : this(v.x.d, v.y.d, 0, 1)
    constructor(v: Vec3bool) : this(v.x.d, v.y.d, v.z.d, 1)
    constructor(v: Vec4bool) : this(v.x.d, v.y.d, v.z.d, v.w.d)

    constructor(bytes: ByteArray, index: Int = 0, oneByteOneDouble: Boolean = true, bigEndianess: Boolean = true) : this(
            if (oneByteOneDouble) bytes[index].d else bytes.getDouble(index, bigEndianess),
            if (oneByteOneDouble) bytes[index + 1].d else bytes.getDouble(index + Double.BYTES, bigEndianess),
            if (oneByteOneDouble) bytes[index + 2].d else bytes.getDouble(index + Double.BYTES * 2, bigEndianess),
            if (oneByteOneDouble) bytes[index + 3].d else bytes.getDouble(index + Double.BYTES * 3, bigEndianess))

    constructor(chars: CharArray, index: Int = 0) : this(chars[index].d, chars[index + 1].d, chars[index + 2].d, chars[index + 3].d)
    constructor(shorts: ShortArray, index: Int = 0) : this(shorts[index], shorts[index + 1], shorts[index + 2], shorts[index + 3])
    constructor(ints: IntArray, index: Int = 0) : this(ints[index], ints[index + 1], ints[index + 2], ints[index + 3])
    constructor(longs: LongArray, index: Int = 0) : this(longs[index], longs[index + 1], longs[index + 2], longs[index + 3])
    constructor(floats: FloatArray, index: Int = 0) : this(floats[index], floats[index + 1], floats[index + 2], floats[index + 3])
    constructor(doubles: DoubleArray, index: Int = 0) : this(doubles[index], doubles[index + 1], doubles[index + 2], doubles[index + 3])
    constructor(booleans: BooleanArray, index: Int = 0) : this(booleans[index].d, booleans[index + 1].d, booleans[index + 2].d, booleans[index + 3].d)

    constructor(numbers: Array<out Number>, index: Int = 0) : this(numbers[index], numbers[index + 1], numbers[index + 2], numbers[index + 3])
    constructor(chars: Array<Char>, index: Int = 0) : this(chars[index].d, chars[index + 1].d, chars[index + 2].d, chars[index + 3].d)
    constructor(booleans: Array<Boolean>, index: Int = 0) : this(booleans[index].d, booleans[index + 1].d, booleans[index + 2].d, booleans[index + 3].d)

    constructor(list: List<Any>, index: Int = 0) : this() {
        put(list, index)
    }

    constructor(bytes: ByteBuffer, index: Int = bytes.position(), oneByteOneDouble: Boolean = true) : this(
            if (oneByteOneDouble) bytes[index].d else bytes.getDouble(index),
            if (oneByteOneDouble) bytes[index + 1].d else bytes.getDouble(index + Double.BYTES),
            if (oneByteOneDouble) bytes[index + 2].d else bytes.getDouble(index + Double.BYTES * 2),
            if (oneByteOneDouble) bytes[index + 3].d else bytes.getDouble(index + Double.BYTES * 3))

    constructor(chars: CharBuffer, index: Int = chars.position()) : this(chars[index].d, chars[index + 1].d, chars[index + 2].d, chars[index + 3].d)
    constructor(shorts: ShortBuffer, index: Int = shorts.position()) : this(shorts[index], shorts[index + 1], shorts[index + 2], shorts[index + 3])
    constructor(ints: IntBuffer, index: Int = ints.position()) : this(ints[index], ints[index + 1], ints[index + 2], ints[index + 3])
    constructor(longs: LongBuffer, index: Int = longs.position()) : this(longs[index], longs[index + 1], longs[index + 2], longs[index + 3])
    constructor(floats: FloatBuffer, index: Int = floats.position()) : this(floats[index], floats[index + 1], floats[index + 2], floats[index + 3])
    constructor(doubles: DoubleBuffer, index: Int = doubles.position()) : this(doubles[index], doubles[index + 1], doubles[index + 2], doubles[index + 3])

    constructor(s: Number) : this(s, s, s, s)
    constructor(x: Number, y: Number, z: Number, w: Number) : this(x.d, y.d, z.d, w.d)


    fun set(bytes: ByteArray, index: Int = 0, oneByteOneDouble: Boolean = true, bigEndianess: Boolean = true) {
        x = if (oneByteOneDouble) bytes[index].d else bytes.getDouble(index, bigEndianess)
        y = if (oneByteOneDouble) bytes[index + 1].d else bytes.getDouble(index + Double.BYTES, bigEndianess)
        z = if (oneByteOneDouble) bytes[index + 2].d else bytes.getDouble(index + Double.BYTES * 2, bigEndianess)
        w = if (oneByteOneDouble) bytes[index + 3].d else bytes.getDouble(index + Double.BYTES * 3, bigEndianess)
    }

    fun set(bytes: ByteBuffer, index: Int = bytes.position(), oneByteOneDouble: Boolean = true) {
        x = if (oneByteOneDouble) bytes[index].d else bytes.getDouble(index)
        y = if (oneByteOneDouble) bytes[index + 1].d else bytes.getDouble(index + Double.BYTES)
        z = if (oneByteOneDouble) bytes[index + 2].d else bytes.getDouble(index + Double.BYTES * 2)
        w = if (oneByteOneDouble) bytes[index + 3].d else bytes.getDouble(index + Double.BYTES * 3)
    }


    override fun put(x: Number, y: Number, z: Number, w: Number): Vec4d {
        this.x = x.d
        this.y = y.d
        this.z = z.d
        this.w = w.d
        return this
    }


    // -- Component accesses --

    operator fun Vec4d.get(i: Int) = when (i) {
        0 -> x
        1 -> y
        2 -> z
        3 -> w
        else -> throw ArrayIndexOutOfBoundsException()
    }

    operator fun Vec4d.set(i: Int, s: Number) = when (i) {
        0 -> x = s.d
        1 -> y = s.d
        2 -> z = s.d
        3 -> w = s.d
        else -> throw ArrayIndexOutOfBoundsException()
    }


    companion object : vec4d_operators {
        @JvmField val length = 4
        @JvmField val SIZE = length * Double.BYTES
    }
    override fun instanceSIZE() = SIZE

    override infix fun to(bytes: ByteBuffer) = to(bytes, bytes.position())

    override fun to(bytes: ByteBuffer, index: Int): ByteBuffer {
        bytes.putDouble(index, x)
        bytes.putDouble(index + Double.BYTES, y)
        bytes.putDouble(index + Double.BYTES * 2, z)
        bytes.putDouble(index + Double.BYTES * 3, w)
        return bytes
    }

    // -- Unary arithmetic operators --

    operator fun unaryPlus() = this

    operator fun unaryMinus() = Vec4d(-x, -y, -z, -w)

    // -- Increment main.and decrement operators --

    operator fun inc(res: Vec4d = Vec4d()) = plus(res, this, 1.0, 1.0, 1.0, 1.0)
    fun inc_() = plus(this, this, 1.0, 1.0, 1.0, 1.0)


    operator fun dec(res: Vec4d = Vec4d()) = minus(res, this, 1.0, 1.0, 1.0, 1.0)
    fun dec_() = minus(this, this, 1.0, 1.0, 1.0, 1.0)


    // -- Specific binary arithmetic operators --

    operator fun plus(b: Double) = plus(Vec4d(), this, b, b, b, b)
    operator fun plus(b: Vec4d) = plus(Vec4d(), this, b.x, b.y, b.z, b.w)

    fun plus(bX: Double, bY: Double, bZ: Double, bW: Double, res: Vec4d = Vec4d()) = plus(res, this, bX, bY, bZ, bW)
    fun plus(b: Double, res: Vec4d = Vec4d()) = plus(res, this, b, b, b, b)
    fun plus(b: Vec4d, res: Vec4d = Vec4d()) = plus(res, this, b.x, b.y, b.z, b.w)

    fun plus_(bX: Double, bY: Double, bZ: Double, bW: Double) = plus(this, this, bX, bY, bZ, bW)
    infix fun plus_(b: Double) = plus(this, this, b, b, b, b)
    infix fun plus_(b: Vec4d) = plus(this, this, b.x, b.y, b.z, b.w)


    operator fun minus(b: Double) = minus(Vec4d(), this, b, b, b, b)
    operator fun minus(b: Vec4d) = minus(Vec4d(), this, b.x, b.y, b.z, b.w)

    fun minus(bX: Double, bY: Double, bZ: Double, bW: Double, res: Vec4d = Vec4d()) = minus(res, this, bX, bY, bZ, bW)
    fun minus(b: Double, res: Vec4d = Vec4d()) = minus(res, this, b, b, b, b)
    fun minus(b: Vec4d, res: Vec4d = Vec4d()) = minus(res, this, b.x, b.y, b.z, b.w)

    fun minus_(bX: Double, bY: Double, bZ: Double, bW: Double) = minus(this, this, bX, bY, bZ, bW)
    infix fun minus_(b: Double) = minus(this, this, b, b, b, b)
    infix fun minus_(b: Vec4d) = minus(this, this, b.x, b.y, b.z, b.w)


    operator fun times(b: Double) = times(Vec4d(), this, b, b, b, b)
    operator fun times(b: Vec4d) = times(Vec4d(), this, b.x, b.y, b.z, b.w)

    fun times(bX: Double, bY: Double, bZ: Double, bW: Double, res: Vec4d = Vec4d()) = times(res, this, bX, bY, bZ, bW)
    fun times(b: Double, res: Vec4d = Vec4d()) = times(res, this, b, b, b, b)
    fun times(b: Vec4d, res: Vec4d = Vec4d()) = times(res, this, b.x, b.y, b.z, b.w)

    fun times_(bX: Double, bY: Double, bZ: Double, bW: Double) = times(this, this, bX, bY, bZ, bW)
    infix fun times_(b: Double) = times(this, this, b, b, b, b)
    infix fun times_(b: Vec4d) = times(this, this, b.x, b.y, b.z, b.w)


    operator fun div(b: Double) = div(Vec4d(), this, b, b, b, b)
    operator fun div(b: Vec4d) = div(Vec4d(), this, b.x, b.y, b.z, b.w)

    fun div(bX: Double, bY: Double, bZ: Double, bW: Double, res: Vec4d = Vec4d()) = div(res, this, bX, bY, bZ, bW)
    fun div(b: Double, res: Vec4d = Vec4d()) = div(res, this, b, b, b, b)
    fun div(b: Vec4d, res: Vec4d = Vec4d()) = div(res, this, b.x, b.y, b.z, b.w)

    fun div_(bX: Double, bY: Double, bZ: Double, bW: Double) = div(this, this, bX, bY, bZ, bW)
    infix fun div_(b: Double) = div(this, this, b, b, b, b)
    infix fun div_(b: Vec4d) = div(this, this, b.x, b.y, b.z, b.w)


    operator fun rem(b: Double) = rem(Vec4d(), this, b, b, b, b)
    operator fun rem(b: Vec4d) = rem(Vec4d(), this, b.x, b.y, b.z, b.w)

    fun rem(bX: Double, bY: Double, bZ: Double, bW: Double, res: Vec4d = Vec4d()) = rem(res, this, bX, bY, bZ, bW)
    fun rem(b: Double, res: Vec4d = Vec4d()) = rem(res, this, b, b, b, b)
    fun rem(b: Vec4d, res: Vec4d = Vec4d()) = rem(res, this, b.x, b.y, b.z, b.w)

    fun rem_(bX: Double, bY: Double, bZ: Double, bW: Double) = rem(this, this, bX, bY, bZ, bW)
    infix fun rem_(b: Double) = rem(this, this, b, b, b, b)
    infix fun rem_(b: Vec4d) = rem(this, this, b.x, b.y, b.z, b.w)


    // -- Generic binary arithmetic operators --

    operator fun plus(b: Number) = plus(Vec4d(), this, b.d, b.d, b.d, b.d)
    operator fun plus(b: Vec4t<out Number>) = plus(Vec4d(), this, b.x.d, b.y.d, b.z.d, b.w.d)

    fun plus(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4d = Vec4d()) = plus(res, this, bX.d, bY.d, bZ.d, bW.d)
    fun plus(b: Number, res: Vec4d = Vec4d()) = plus(res, this, b.d, b.d, b.d, b.d)
    fun plus(b: Vec4t<out Number>, res: Vec4d = Vec4d()) = plus(res, this, b.x.d, b.y.d, b.z.d, b.w.d)

    fun plus_(bX: Number, bY: Number, bZ: Number, bW: Number) = plus(this, this, bX.d, bY.d, bZ.d, bW.d)
    infix fun plus_(b: Number) = plus(this, this, b.d, b.d, b.d, b.d)
    infix fun plus_(b: Vec4t<out Number>) = plus(this, this, b.x.d, b.y.d, b.z.d, b.w.d)


    operator fun minus(b: Number) = minus(Vec4d(), this, b.d, b.d, b.d, b.d)
    operator fun minus(b: Vec4t<out Number>) = minus(Vec4d(), this, b.x.d, b.y.d, b.z.d, b.w.d)

    fun minus(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4d = Vec4d()) = minus(res, this, bX.d, bY.d, bZ.d, bW.d)
    fun minus(b: Number, res: Vec4d = Vec4d()) = minus(res, this, b.d, b.d, b.d, b.d)
    fun minus(b: Vec4t<out Number>, res: Vec4d = Vec4d()) = minus(res, this, b.x.d, b.y.d, b.z.d, b.w.d)

    fun minus_(bX: Number, bY: Number, bZ: Number, bW: Number) = minus(this, this, bX.d, bY.d, bZ.d, bW.d)
    infix fun minus_(b: Number) = minus(this, this, b.d, b.d, b.d, b.d)
    infix fun minus_(b: Vec4t<out Number>) = minus(this, this, b.x.d, b.y.d, b.z.d, b.w.d)


    operator fun times(b: Number) = times(Vec4d(), this, b.d, b.d, b.d, b.d)
    operator fun times(b: Vec4t<out Number>) = times(Vec4d(), this, b.x.d, b.y.d, b.z.d, b.w.d)

    fun times(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4d = Vec4d()) = times(res, this, bX.d, bY.d, bZ.d, bW.d)
    fun times(b: Number, res: Vec4d = Vec4d()) = times(res, this, b.d, b.d, b.d, b.d)
    fun times(b: Vec4t<out Number>, res: Vec4d = Vec4d()) = times(res, this, b.x.d, b.y.d, b.z.d, b.w.d)

    fun times_(bX: Number, bY: Number, bZ: Number, bW: Number) = times(this, this, bX.d, bY.d, bZ.d, bW.d)
    infix fun times_(b: Number) = times(this, this, b.d, b.d, b.d, b.d)
    infix fun times_(b: Vec4t<out Number>) = times(this, this, b.x.d, b.y.d, b.z.d, b.w.d)


    operator fun div(b: Number) = div(Vec4d(), this, b.d, b.d, b.d, b.d)
    operator fun div(b: Vec4t<out Number>) = div(Vec4d(), this, b.x.d, b.y.d, b.z.d, b.w.d)

    fun div(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4d = Vec4d()) = div(res, this, bX.d, bY.d, bZ.d, bW.d)
    fun div(b: Number, res: Vec4d = Vec4d()) = div(res, this, b.d, b.d, b.d, b.d)
    fun div(b: Vec4t<out Number>, res: Vec4d = Vec4d()) = div(res, this, b.x.d, b.y.d, b.z.d, b.w.d)

    fun div_(bX: Number, bY: Number, bZ: Number, bW: Number) = div(this, this, bX.d, bY.d, bZ.d, bW.d)
    infix fun div_(b: Number) = div(this, this, b.d, b.d, b.d, b.d)
    infix fun div_(b: Vec4t<out Number>) = div(this, this, b.x.d, b.y.d, b.z.d, b.w.d)


    operator fun rem(b: Number) = rem(Vec4d(), this, b.d, b.d, b.d, b.d)
    operator fun rem(b: Vec4t<out Number>) = rem(Vec4d(), this, b.x.d, b.y.d, b.z.d, b.w.d)

    fun rem(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4d = Vec4d()) = rem(res, this, bX.d, bY.d, bZ.d, bW.d)
    fun rem(b: Number, res: Vec4d = Vec4d()) = rem(res, this, b.d, b.d, b.d, b.d)
    fun rem(b: Vec4t<out Number>, res: Vec4d = Vec4d()) = rem(res, this, b.x.d, b.y.d, b.z.d, b.w.d)

    fun rem_(bX: Number, bY: Number, bZ: Number, bW: Number) = rem(this, this, bX.d, bY.d, bZ.d, bW.d)
    infix fun rem_(b: Number) = rem(this, this, b.d, b.d, b.d, b.d)
    infix fun rem_(b: Vec4t<out Number>) = rem(this, this, b.x.d, b.y.d, b.z.d, b.w.d)


    override fun equals(other: Any?) =
            if (other is Vec4d)
                this[0] == other[0] && this[1] == other[1] && this[2] == other[2] && this[3] == other[3]
            else false
}