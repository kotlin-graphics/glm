package vec._4

import BYTES
import d
import getDouble
import vec.Vec2t
import vec.Vec3t
import vec.Vec4t
import vec._4.operators.vec4d_operators
import vec.bool.Vec2bool
import vec.bool.Vec3bool
import vec.bool.Vec4bool
import java.nio.*

/**
 * Created by elect on 09/10/16.
 */

data class Vec4d(override var x: Double, override var y: Double, override var z: Double, override var w: Double) : Vec4t<Double>() {

    // -- Explicit basic, conversion other and conversion vector constructors --

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
        Set(list, index)
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


    override fun Set(x: Number, y: Number, z: Number, w: Number): Vec4d {
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


    companion object : vec4d_operators


    // -- Unary arithmetic operators --

    operator fun unaryPlus() = this

    operator fun unaryMinus() = Vec4d(-x, -y, -z, -w)

    // -- Increment and decrement operators --

    operator fun inc(res: Vec4d = Vec4d()) = add(res, this, 1.0, 1.0, 1.0, 1.0)
    fun inc_() = add(this, this, 1.0, 1.0, 1.0, 1.0)


    operator fun dec(res: Vec4d = Vec4d()) = sub(res, this, 1.0, 1.0, 1.0, 1.0)
    fun dec_() = sub(this, this, 1.0, 1.0, 1.0, 1.0)


    // -- Specific binary arithmetic operators --

    operator fun plus(b: Double) = add(Vec4d(), this, b, b, b, b)
    operator fun plus(b: Vec4d) = add(Vec4d(), this, b.x, b.y, b.z, b.w)

    fun add(bX: Double, bY: Double, bZ: Double, bW: Double, res: Vec4d = Vec4d()) = add(res, this, bX, bY, bZ, bW)
    fun add(b: Double, res: Vec4d = Vec4d()) = add(res, this, b, b, b, b)
    fun add(b: Vec4d, res: Vec4d = Vec4d()) = add(res, this, b.x, b.y, b.z, b.w)

    fun add_(bX: Double, bY: Double, bZ: Double, bW: Double) = add(this, this, bX, bY, bZ, bW)
    infix fun add_(b: Double) = add(this, this, b, b, b, b)
    infix fun add_(b: Vec4d) = add(this, this, b.x, b.y, b.z, b.w)


    operator fun minus(b: Double) = sub(Vec4d(), this, b, b, b, b)
    operator fun minus(b: Vec4d) = sub(Vec4d(), this, b.x, b.y, b.z, b.w)

    fun sub(bX: Double, bY: Double, bZ: Double, bW: Double, res: Vec4d = Vec4d()) = sub(res, this, bX, bY, bZ, bW)
    fun sub(b: Double, res: Vec4d = Vec4d()) = sub(res, this, b, b, b, b)
    fun sub(b: Vec4d, res: Vec4d = Vec4d()) = sub(res, this, b.x, b.y, b.z, b.w)

    fun sub_(bX: Double, bY: Double, bZ: Double, bW: Double) = sub(this, this, bX, bY, bZ, bW)
    infix fun sub_(b: Double) = sub(this, this, b, b, b, b)
    infix fun sub_(b: Vec4d) = sub(this, this, b.x, b.y, b.z, b.w)


    operator fun times(b: Double) = mul(Vec4d(), this, b, b, b, b)
    operator fun times(b: Vec4d) = mul(Vec4d(), this, b.x, b.y, b.z, b.w)

    fun mul(bX: Double, bY: Double, bZ: Double, bW: Double, res: Vec4d = Vec4d()) = mul(res, this, bX, bY, bZ, bW)
    fun mul(b: Double, res: Vec4d = Vec4d()) = mul(res, this, b, b, b, b)
    fun mul(b: Vec4d, res: Vec4d = Vec4d()) = mul(res, this, b.x, b.y, b.z, b.w)

    fun mul_(bX: Double, bY: Double, bZ: Double, bW: Double) = mul(this, this, bX, bY, bZ, bW)
    infix fun mul_(b: Double) = mul(this, this, b, b, b, b)
    infix fun mul_(b: Vec4d) = mul(this, this, b.x, b.y, b.z, b.w)


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

    operator fun plus(b: Number) = add(Vec4d(), this, b.d, b.d, b.d, b.d)
    operator fun plus(b: Vec4t<Number>) = add(Vec4d(), this, b.x.d, b.y.d, b.z.d, b.w.d)

    fun add(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4d = Vec4d()) = add(res, this, bX.d, bY.d, bZ.d, bW.d)
    fun add(b: Number, res: Vec4d = Vec4d()) = add(res, this, b.d, b.d, b.d, b.d)
    fun add(b: Vec4t<Number>, res: Vec4d = Vec4d()) = add(res, this, b.x.d, b.y.d, b.z.d, b.w.d)

    fun add_(bX: Number, bY: Number, bZ: Number, bW: Number) = add(this, this, bX.d, bY.d, bZ.d, bW.d)
    infix fun add_(b: Number) = add(this, this, b.d, b.d, b.d, b.d)
    infix fun add_(b: Vec4t<Number>) = add(this, this, b.x.d, b.y.d, b.z.d, b.w.d)


    operator fun minus(b: Number) = sub(Vec4d(), this, b.d, b.d, b.d, b.d)
    operator fun minus(b: Vec4t<Number>) = sub(Vec4d(), this, b.x.d, b.y.d, b.z.d, b.w.d)

    fun sub(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4d = Vec4d()) = sub(res, this, bX.d, bY.d, bZ.d, bW.d)
    fun sub(b: Number, res: Vec4d = Vec4d()) = sub(res, this, b.d, b.d, b.d, b.d)
    fun sub(b: Vec4t<Number>, res: Vec4d = Vec4d()) = sub(res, this, b.x.d, b.y.d, b.z.d, b.w.d)

    fun sub_(bX: Number, bY: Number, bZ: Number, bW: Number) = sub(this, this, bX.d, bY.d, bZ.d, bW.d)
    infix fun sub_(b: Number) = sub(this, this, b.d, b.d, b.d, b.d)
    infix fun sub_(b: Vec4t<Number>) = sub(this, this, b.x.d, b.y.d, b.z.d, b.w.d)


    operator fun times(b: Number) = mul(Vec4d(), this, b.d, b.d, b.d, b.d)
    operator fun times(b: Vec4t<Number>) = mul(Vec4d(), this, b.x.d, b.y.d, b.z.d, b.w.d)

    fun mul(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4d = Vec4d()) = mul(res, this, bX.d, bY.d, bZ.d, bW.d)
    fun mul(b: Number, res: Vec4d = Vec4d()) = mul(res, this, b.d, b.d, b.d, b.d)
    fun mul(b: Vec4t<Number>, res: Vec4d = Vec4d()) = mul(res, this, b.x.d, b.y.d, b.z.d, b.w.d)

    fun mul_(bX: Number, bY: Number, bZ: Number, bW: Number) = mul(this, this, bX.d, bY.d, bZ.d, bW.d)
    infix fun mul_(b: Number) = mul(this, this, b.d, b.d, b.d, b.d)
    infix fun mul_(b: Vec4t<Number>) = mul(this, this, b.x.d, b.y.d, b.z.d, b.w.d)


    operator fun div(b: Number) = div(Vec4d(), this, b.d, b.d, b.d, b.d)
    operator fun div(b: Vec4t<Number>) = div(Vec4d(), this, b.x.d, b.y.d, b.z.d, b.w.d)

    fun div(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4d = Vec4d()) = div(res, this, bX.d, bY.d, bZ.d, bW.d)
    fun div(b: Number, res: Vec4d = Vec4d()) = div(res, this, b.d, b.d, b.d, b.d)
    fun div(b: Vec4t<Number>, res: Vec4d = Vec4d()) = div(res, this, b.x.d, b.y.d, b.z.d, b.w.d)

    fun div_(bX: Number, bY: Number, bZ: Number, bW: Number) = div(this, this, bX.d, bY.d, bZ.d, bW.d)
    infix fun div_(b: Number) = div(this, this, b.d, b.d, b.d, b.d)
    infix fun div_(b: Vec4t<Number>) = div(this, this, b.x.d, b.y.d, b.z.d, b.w.d)


    operator fun rem(b: Number) = rem(Vec4d(), this, b.d, b.d, b.d, b.d)
    operator fun rem(b: Vec4t<Number>) = rem(Vec4d(), this, b.x.d, b.y.d, b.z.d, b.w.d)

    fun rem(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4d = Vec4d()) = rem(res, this, bX.d, bY.d, bZ.d, bW.d)
    fun rem(b: Number, res: Vec4d = Vec4d()) = rem(res, this, b.d, b.d, b.d, b.d)
    fun rem(b: Vec4t<Number>, res: Vec4d = Vec4d()) = rem(res, this, b.x.d, b.y.d, b.z.d, b.w.d)

    fun rem_(bX: Number, bY: Number, bZ: Number, bW: Number) = rem(this, this, bX.d, bY.d, bZ.d, bW.d)
    infix fun rem_(b: Number) = rem(this, this, b.d, b.d, b.d, b.d)
    infix fun rem_(b: Vec4t<Number>) = rem(this, this, b.x.d, b.y.d, b.z.d, b.w.d)
}