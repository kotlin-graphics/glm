package vec._4

import BYTES
import f
import getFloat
import vec.Vec2t
import vec.Vec3t
import vec.Vec4t
import vec._4.operators.vec4_operators
import vec.bool.Vec2bool
import vec.bool.Vec3bool
import vec.bool.Vec4bool
import java.nio.*

/**
 * Created by elect on 09/10/16.
 */

data class Vec4(override var x: Float, override var y: Float, override var z: Float, override var w: Float) : Vec4t<Float>() {

    // -- Explicit basic, conversion other and conversion vector constructors --

    constructor() : this(0)

    constructor(v: Vec2t<out Number>) : this(v.x, v.y, 0, 1)
    constructor(v: Vec2t<out Number>, z: Number, w: Number) : this(v.x, v.y, z, w)
    constructor(v: Vec3t<out Number>) : this(v, 1)
    constructor(v: Vec3t<out Number>, w: Number) : this(v.x, v.y, v.z, w)
    constructor(x: Number, v: Vec3t<out Number>) : this(x, v.x, v.y, v.z)
    constructor(v: Vec4t<out Number>) : this(v.x, v.y, v.z, v.w)

    constructor(v: Vec2bool) : this(v.x.f, v.y.f, 0, 1) // TODO scalar to f
    constructor(v: Vec3bool) : this(v.x.f, v.y.f, v.z.f, 1)
    constructor(v: Vec4bool) : this(v.x.f, v.y.f, v.z.f, v.w.f)

    constructor(bytes: ByteArray, index: Int = 0, oneByteOneFloat: Boolean = true, bigEndianess: Boolean = true) : this(
            if (oneByteOneFloat) bytes[index].f else bytes.getFloat(index, bigEndianess),
            if (oneByteOneFloat) bytes[index + 1].f else bytes.getFloat(index + Float.BYTES, bigEndianess),
            if (oneByteOneFloat) bytes[index + 2].f else bytes.getFloat(index + Float.BYTES * 2, bigEndianess),
            if (oneByteOneFloat) bytes[index + 3].f else bytes.getFloat(index + Float.BYTES * 3, bigEndianess))

    constructor(chars: CharArray, index: Int = 0) : this(chars[index].f, chars[index + 1].f, chars[index + 2].f, chars[index + 3].f)
    constructor(shorts: ShortArray, index: Int = 0) : this(shorts[index], shorts[index + 1], shorts[index + 2], shorts[index + 3])
    constructor(ints: IntArray, index: Int = 0) : this(ints[index], ints[index + 1], ints[index + 2], ints[index + 3])
    constructor(longs: LongArray, index: Int = 0) : this(longs[index], longs[index + 1], longs[index + 2], longs[index + 3])
    constructor(floats: FloatArray, index: Int = 0) : this(floats[index], floats[index + 1], floats[index + 2], floats[index + 3])
    constructor(doubles: DoubleArray, index: Int = 0) : this(doubles[index], doubles[index + 1], doubles[index + 2], doubles[index + 3])
    constructor(booleans: BooleanArray, index: Int = 0) : this(booleans[index].f, booleans[index + 1].f, booleans[index + 2].f, booleans[index + 3].f)

    constructor(numbers: Array<out Number>, index: Int = 0) : this(numbers[index], numbers[index + 1], numbers[index + 2], numbers[index + 3])
    constructor(chars: Array<Char>, index: Int = 0) : this(chars[index].f, chars[index + 1].f, chars[index + 2].f, chars[index + 3].f)
    constructor(booleans: Array<Boolean>, index: Int = 0) : this(booleans[index].f, booleans[index + 1].f, booleans[index + 2].f, booleans[index + 3].f)

    constructor(list: List<Any>, index: Int = 0) : this() {
        Set(list, index)
    }

    constructor(bytes: ByteBuffer, index: Int = bytes.position(), oneByteOneFloat: Boolean = true) : this(
            if (oneByteOneFloat) bytes[index].f else bytes.getFloat(index),
            if (oneByteOneFloat) bytes[index + 1].f else bytes.getFloat(index + Float.BYTES),
            if (oneByteOneFloat) bytes[index + 2].f else bytes.getFloat(index + Float.BYTES * 2),
            if (oneByteOneFloat) bytes[index + 3].f else bytes.getFloat(index + Float.BYTES * 3))

    constructor(chars: CharBuffer, index: Int = chars.position()) : this(chars[index].f, chars[index + 1].f, chars[index + 2].f, chars[index + 3].f)
    constructor(shorts: ShortBuffer, index: Int = shorts.position()) : this(shorts[index], shorts[index + 1], shorts[index + 2], shorts[index + 3])
    constructor(ints: IntBuffer, index: Int = ints.position()) : this(ints[index], ints[index + 1], ints[index + 2], ints[index + 3])
    constructor(longs: LongBuffer, index: Int = longs.position()) : this(longs[index], longs[index + 1], longs[index + 2], longs[index + 3])
    constructor(floats: FloatBuffer, index: Int = floats.position()) : this(floats[index], floats[index + 1], floats[index + 2], floats[index + 3])
    constructor(doubles: DoubleBuffer, index: Int = doubles.position()) : this(doubles[index], doubles[index + 1], doubles[index + 2], doubles[index + 3])

    constructor(s: Number) : this(s, s, s, s)
    constructor(x: Number, y: Number, z: Number, w: Number) : this(x.f, y.f, z.f, w.f)


    fun set(bytes: ByteArray, index: Int = 0, oneByteOneFloat: Boolean = true, bigEndianess: Boolean = true) {
        x = if (oneByteOneFloat) bytes[index].f else bytes.getFloat(index, bigEndianess)
        y = if (oneByteOneFloat) bytes[index + 1].f else bytes.getFloat(index + Float.BYTES, bigEndianess)
        z = if (oneByteOneFloat) bytes[index + 2].f else bytes.getFloat(index + Float.BYTES * 2, bigEndianess)
        w = if (oneByteOneFloat) bytes[index + 3].f else bytes.getFloat(index + Float.BYTES * 3, bigEndianess)
    }

    fun set(bytes: ByteBuffer, index: Int = bytes.position(), oneByteOneFloat: Boolean = true) {
        x = if (oneByteOneFloat) bytes[index].f else bytes.getFloat(index)
        y = if (oneByteOneFloat) bytes[index + 1].f else bytes.getFloat(index + Float.BYTES)
        z = if (oneByteOneFloat) bytes[index + 2].f else bytes.getFloat(index + Float.BYTES * 2)
        w = if (oneByteOneFloat) bytes[index + 3].f else bytes.getFloat(index + Float.BYTES * 3)
    }


    override fun Set(x: Number, y: Number, z: Number, w: Number): Vec4 {
        this.x = x.f
        this.y = y.f
        this.z = z.f
        this.w = w.f
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
        0 -> x = s.f
        1 -> y = s.f
        2 -> z = s.f
        3 -> w = s.f
        else -> throw ArrayIndexOutOfBoundsException()
    }


    companion object : vec4_operators {
        @JvmField val SIZE = 4 * Float.BYTES
    }


    // -- Unary arithmetic operators --

    operator fun unaryPlus() = this

    operator fun unaryMinus() = Vec4(-x, -y, -z, -w)

    // -- Increment and decrement operators --

    operator fun inc(res: Vec4 = Vec4()) = add(res, this, 1f, 1f, 1f, 1f)
    fun inc_() = add(this, this, 1f, 1f, 1f, 1f)


    operator fun dec(res: Vec4 = Vec4()) = sub(res, this, 1f, 1f, 1f, 1f)
    fun dec_() = sub(this, this, 1f, 1f, 1f, 1f)


    // -- Specific binary arithmetic operators --

    operator fun plus(b: Float) = add(Vec4(), this, b, b, b, b)
    operator fun plus(b: Vec4) = add(Vec4(), this, b.x, b.y, b.z, b.w)

    fun add(bX: Float, bY: Float, bZ: Float, bW: Float, res: Vec4 = Vec4()) = add(res, this, bX, bY, bZ, bW)
    fun add(b: Float, res: Vec4 = Vec4()) = add(res, this, b, b, b, b)
    fun add(b: Vec4, res: Vec4 = Vec4()) = add(res, this, b.x, b.y, b.z, b.w)

    fun add_(bX: Float, bY: Float, bZ: Float, bW: Float) = add(this, this, bX, bY, bZ, bW)
    infix fun add_(b: Float) = add(this, this, b, b, b, b)
    infix fun add_(b: Vec4) = add(this, this, b.x, b.y, b.z, b.w)


    operator fun minus(b: Float) = sub(Vec4(), this, b, b, b, b)
    operator fun minus(b: Vec4) = sub(Vec4(), this, b.x, b.y, b.z, b.w)

    fun sub(bX: Float, bY: Float, bZ: Float, bW: Float, res: Vec4 = Vec4()) = sub(res, this, bX, bY, bZ, bW)
    fun sub(b: Float, res: Vec4 = Vec4()) = sub(res, this, b, b, b, b)
    fun sub(b: Vec4, res: Vec4 = Vec4()) = sub(res, this, b.x, b.y, b.z, b.w)

    fun sub_(bX: Float, bY: Float, bZ: Float, bW: Float) = sub(this, this, bX, bY, bZ, bW)
    infix fun sub_(b: Float) = sub(this, this, b, b, b, b)
    infix fun sub_(b: Vec4) = sub(this, this, b.x, b.y, b.z, b.w)


    operator fun times(b: Float) = mul(Vec4(), this, b, b, b, b)
    operator fun times(b: Vec4) = mul(Vec4(), this, b.x, b.y, b.z, b.w)

    fun mul(bX: Float, bY: Float, bZ: Float, bW: Float, res: Vec4 = Vec4()) = mul(res, this, bX, bY, bZ, bW)
    fun mul(b: Float, res: Vec4 = Vec4()) = mul(res, this, b, b, b, b)
    fun mul(b: Vec4, res: Vec4 = Vec4()) = mul(res, this, b.x, b.y, b.z, b.w)

    fun mul_(bX: Float, bY: Float, bZ: Float, bW: Float) = mul(this, this, bX, bY, bZ, bW)
    infix fun mul_(b: Float) = mul(this, this, b, b, b, b)
    infix fun mul_(b: Vec4) = mul(this, this, b.x, b.y, b.z, b.w)


    operator fun div(b: Float) = div(Vec4(), this, b, b, b, b)
    operator fun div(b: Vec4) = div(Vec4(), this, b.x, b.y, b.z, b.w)

    fun div(bX: Float, bY: Float, bZ: Float, bW: Float, res: Vec4 = Vec4()) = div(res, this, bX, bY, bZ, bW)
    fun div(b: Float, res: Vec4 = Vec4()) = div(res, this, b, b, b, b)
    fun div(b: Vec4, res: Vec4 = Vec4()) = div(res, this, b.x, b.y, b.z, b.w)

    fun div_(bX: Float, bY: Float, bZ: Float, bW: Float) = div(this, this, bX, bY, bZ, bW)
    infix fun div_(b: Float) = div(this, this, b, b, b, b)
    infix fun div_(b: Vec4) = div(this, this, b.x, b.y, b.z, b.w)


    operator fun rem(b: Float) = rem(Vec4(), this, b, b, b, b)
    operator fun rem(b: Vec4) = rem(Vec4(), this, b.x, b.y, b.z, b.w)

    fun rem(bX: Float, bY: Float, bZ: Float, bW: Float, res: Vec4 = Vec4()) = rem(res, this, bX, bY, bZ, bW)
    fun rem(b: Float, res: Vec4 = Vec4()) = rem(res, this, b, b, b, b)
    fun rem(b: Vec4, res: Vec4 = Vec4()) = rem(res, this, b.x, b.y, b.z, b.w)

    fun rem_(bX: Float, bY: Float, bZ: Float, bW: Float) = rem(this, this, bX, bY, bZ, bW)
    infix fun rem_(b: Float) = rem(this, this, b, b, b, b)
    infix fun rem_(b: Vec4) = rem(this, this, b.x, b.y, b.z, b.w)


    // -- Generic binary arithmetic operators --

    operator fun plus(b: Number) = add(Vec4(), this, b.f, b.f, b.f, b.f)
    operator fun plus(b: Vec4t<Number>) = add(Vec4(), this, b.x.f, b.y.f, b.z.f, b.w.f)

    fun add(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4 = Vec4()) = add(res, this, bX.f, bY.f, bZ.f, bW.f)
    fun add(b: Number, res: Vec4 = Vec4()) = add(res, this, b.f, b.f, b.f, b.f)
    fun add(b: Vec4t<Number>, res: Vec4 = Vec4()) = add(res, this, b.x.f, b.y.f, b.z.f, b.w.f)

    fun add_(bX: Number, bY: Number, bZ: Number, bW: Number) = add(this, this, bX.f, bY.f, bZ.f, bW.f)
    infix fun add_(b: Number) = add(this, this, b.f, b.f, b.f, b.f)
    infix fun add_(b: Vec4t<Number>) = add(this, this, b.x.f, b.y.f, b.z.f, b.w.f)


    operator fun minus(b: Number) = sub(Vec4(), this, b.f, b.f, b.f, b.f)
    operator fun minus(b: Vec4t<Number>) = sub(Vec4(), this, b.x.f, b.y.f, b.z.f, b.w.f)

    fun sub(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4 = Vec4()) = sub(res, this, bX.f, bY.f, bZ.f, bW.f)
    fun sub(b: Number, res: Vec4 = Vec4()) = sub(res, this, b.f, b.f, b.f, b.f)
    fun sub(b: Vec4t<Number>, res: Vec4 = Vec4()) = sub(res, this, b.x.f, b.y.f, b.z.f, b.w.f)

    fun sub_(bX: Number, bY: Number, bZ: Number, bW: Number) = sub(this, this, bX.f, bY.f, bZ.f, bW.f)
    infix fun sub_(b: Number) = sub(this, this, b.f, b.f, b.f, b.f)
    infix fun sub_(b: Vec4t<Number>) = sub(this, this, b.x.f, b.y.f, b.z.f, b.w.f)


    operator fun times(b: Number) = mul(Vec4(), this, b.f, b.f, b.f, b.f)
    operator fun times(b: Vec4t<Number>) = mul(Vec4(), this, b.x.f, b.y.f, b.z.f, b.w.f)

    fun mul(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4 = Vec4()) = mul(res, this, bX.f, bY.f, bZ.f, bW.f)
    fun mul(b: Number, res: Vec4 = Vec4()) = mul(res, this, b.f, b.f, b.f, b.f)
    fun mul(b: Vec4t<Number>, res: Vec4 = Vec4()) = mul(res, this, b.x.f, b.y.f, b.z.f, b.w.f)

    fun mul_(bX: Number, bY: Number, bZ: Number, bW: Number) = mul(this, this, bX.f, bY.f, bZ.f, bW.f)
    infix fun mul_(b: Number) = mul(this, this, b.f, b.f, b.f, b.f)
    infix fun mul_(b: Vec4t<Number>) = mul(this, this, b.x.f, b.y.f, b.z.f, b.w.f)


    operator fun div(b: Number) = div(Vec4(), this, b.f, b.f, b.f, b.f)
    operator fun div(b: Vec4t<Number>) = div(Vec4(), this, b.x.f, b.y.f, b.z.f, b.w.f)

    fun div(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4 = Vec4()) = div(res, this, bX.f, bY.f, bZ.f, bW.f)
    fun div(b: Number, res: Vec4 = Vec4()) = div(res, this, b.f, b.f, b.f, b.f)
    fun div(b: Vec4t<Number>, res: Vec4 = Vec4()) = div(res, this, b.x.f, b.y.f, b.z.f, b.w.f)

    fun div_(bX: Number, bY: Number, bZ: Number, bW: Number) = div(this, this, bX.f, bY.f, bZ.f, bW.f)
    infix fun div_(b: Number) = div(this, this, b.f, b.f, b.f, b.f)
    infix fun div_(b: Vec4t<Number>) = div(this, this, b.x.f, b.y.f, b.z.f, b.w.f)


    operator fun rem(b: Number) = rem(Vec4(), this, b.f, b.f, b.f, b.f)
    operator fun rem(b: Vec4t<Number>) = rem(Vec4(), this, b.x.f, b.y.f, b.z.f, b.w.f)

    fun rem(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4 = Vec4()) = rem(res, this, bX.f, bY.f, bZ.f, bW.f)
    fun rem(b: Number, res: Vec4 = Vec4()) = rem(res, this, b.f, b.f, b.f, b.f)
    fun rem(b: Vec4t<Number>, res: Vec4 = Vec4()) = rem(res, this, b.x.f, b.y.f, b.z.f, b.w.f)

    fun rem_(bX: Number, bY: Number, bZ: Number, bW: Number) = rem(this, this, bX.f, bY.f, bZ.f, bW.f)
    infix fun rem_(b: Number) = rem(this, this, b.f, b.f, b.f, b.f)
    infix fun rem_(b: Vec4t<Number>) = rem(this, this, b.x.f, b.y.f, b.z.f, b.w.f)
}