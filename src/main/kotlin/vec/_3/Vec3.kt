package vec._3

import main.BYTES
import main.f
import main.getFloat
import vec.Vec2t
import vec.Vec3t
import vec.Vec4t
import vec._3.operators.vec3_operators
import vec.bool.Vec2bool
import vec.bool.Vec3bool
import vec.bool.Vec4bool
import java.nio.*
import main.Glm.normalize
import main.Glm.cross

/**
 * Created bY GBarbieri on 05.10.2016.
 */

data class Vec3(override var x: Float, override var y: Float, override var z: Float) : Vec3t<Float>() {


    // -- Explicit basic, conversion other main.and conversion vector constructors --

    constructor() : this(0)

    constructor(v: Vec2t<out Number>) : this(v, 0)
    constructor(v: Vec2t<out Number>, z: Number) : this(v.x, v.y, z) // TODO
    constructor(x: Number, v: Vec2t<out Number>) : this(x, v.x, v.y) // TODO
    constructor(v: Vec3t<out Number>) : this(v.x, v.y, v.z)
    constructor(v: Vec4t<out Number>) : this(v.x, v.y, v.z)

    constructor(v: Vec2bool) : this(v.x.f, v.y.f, 0)
    constructor(v: Vec3bool) : this(v.x.f, v.y.f, v.z.f)
    constructor(v: Vec4bool) : this(v.x.f, v.y.f, v.z.f)

    constructor(bytes: ByteArray, index: Int = 0, oneByteOneFloat: Boolean = false, bigEndianess: Boolean = true) : this(
            if (oneByteOneFloat) bytes[index].f else bytes.getFloat(index, bigEndianess),
            if (oneByteOneFloat) bytes[index + 1].f else bytes.getFloat(index + Float.BYTES, bigEndianess),
            if (oneByteOneFloat) bytes[index + 2].f else bytes.getFloat(index + Float.BYTES * 2, bigEndianess))

    constructor(chars: CharArray, index: Int = 0) : this(chars[index].f, chars[index + 1].f, chars[index + 2].f)
    constructor(shorts: ShortArray, index: Int = 0) : this(shorts[index], shorts[index + 1], shorts[index + 2])
    constructor(ints: IntArray, index: Int = 0) : this(ints[index], ints[index + 1], ints[index + 2])
    constructor(longs: LongArray, index: Int = 0) : this(longs[index], longs[index + 1], longs[index + 2])
    constructor(floats: FloatArray, index: Int = 0) : this(floats[index], floats[index + 1], floats[index + 2])
    constructor(doubles: DoubleArray, index: Int = 0) : this(doubles[index], doubles[index + 1], doubles[index + 2])
    constructor(booleans: BooleanArray, index: Int = 0) : this(booleans[index].f, booleans[index + 1].f, booleans[index + 2].f)

    constructor(numbers: Array<out Number>, index: Int = 0) : this(numbers[index], numbers[index + 1], numbers[index + 2])
    constructor(chars: Array<Char>, index: Int = 0) : this(chars[index].f, chars[index + 1].f, chars[index + 2].f)
    constructor(booleans: Array<Boolean>, index: Int = 0) : this(booleans[index].f, booleans[index + 1].f, booleans[index + 2].f)

    constructor(list: List<Any>, index: Int = 0) : this() {
        put(list, index)
    }

    constructor(bytes: ByteBuffer, index: Int = bytes.position(), oneByteOneFloat: Boolean = false) : this(
            if (oneByteOneFloat) bytes[index].f else bytes.getFloat(index),
            if (oneByteOneFloat) bytes[index + 1].f else bytes.getFloat(index + Float.BYTES),
            if (oneByteOneFloat) bytes[index + 2].f else bytes.getFloat(index + Float.BYTES * 2))

    constructor(chars: CharBuffer, index: Int = chars.position()) : this(chars[index].f, chars[index + 1].f, chars[index + 2].f)
    constructor(shorts: ShortBuffer, index: Int = shorts.position()) : this(shorts[index], shorts[index + 1], shorts[index + 2])
    constructor(ints: IntBuffer, index: Int = ints.position()) : this(ints[index], ints[index + 1], ints[index + 2])
    constructor(longs: LongBuffer, index: Int = longs.position()) : this(longs[index], longs[index + 1], longs[index + 2])
    constructor(floats: FloatBuffer, index: Int = floats.position()) : this(floats[index], floats[index + 1], floats[index + 2])
    constructor(doubles: DoubleBuffer, index: Int = doubles.position()) : this(doubles[index], doubles[index + 1], doubles[index + 2])

    constructor(s: Number) : this(s, s, s)
    constructor(x: Number, y: Number, z: Number) : this(x.f, y.f, z.f)


    fun set(bytes: ByteArray, index: Int = 0, oneByteOneFloat: Boolean = false, bigEndianess: Boolean = true) {
        x = if (oneByteOneFloat) bytes[index].f else bytes.getFloat(index, bigEndianess)
        y = if (oneByteOneFloat) bytes[index + 1].f else bytes.getFloat(index + Float.BYTES, bigEndianess)
        z = if (oneByteOneFloat) bytes[index + 2].f else bytes.getFloat(index + Float.BYTES * 2, bigEndianess)
    }

    fun set(bytes: ByteBuffer, index: Int = bytes.position(), oneByteOneFloat: Boolean = false) {
        x = if (oneByteOneFloat) bytes[index].f else bytes.getFloat(index)
        y = if (oneByteOneFloat) bytes[index + 1].f else bytes.getFloat(index + Float.BYTES)
        z = if (oneByteOneFloat) bytes[index + 2].f else bytes.getFloat(index + Float.BYTES * 2)
    }


    override fun put(x: Number, y: Number, z: Number): Vec3 {
        this.x = x.f
        this.y = y.f
        this.z = z.f
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
        0 -> x = s.f
        1 -> y = s.f
        2 -> z = s.f
        else -> throw ArrayIndexOutOfBoundsException()
    }


    companion object : vec3_operators {
        @JvmField val SIZE = 3 * Float.BYTES
    }


    // TODO others
    infix fun to(floats: FloatArray) = to(floats, 0)

    fun to(floats: FloatArray, index: Int): FloatArray {
        floats[0] = x
        floats[1] = y
        floats[2] = z
        return floats
    }


    // -- Unary arithmetic operators --

    operator fun unaryPlus() = this

    operator fun unaryMinus() = Vec3(-x, -y, -z)

    // -- Increment main.and decrement operators --

    operator fun inc(res: Vec3 = Vec3()) = add(res, this, 1f, 1f, 1f)
    fun inc_() = add(this, this, 1f, 1f, 1f)


    operator fun dec(res: Vec3 = Vec3()) = sub(res, this, 1f, 1f, 1f)
    fun dec_() = sub(this, this, 1f, 1f, 1f)


    // -- Specific binary arithmetic operators --

    operator fun plus(b: Float) = add(Vec3(), this, b, b, b)
    operator fun plus(b: Vec3) = add(Vec3(), this, b.x, b.y, b.z)

    fun add(bX: Float, bY: Float, bZ: Float, res: Vec3 = Vec3()) = add(res, this, bX, bY, bZ)
    fun add(b: Float, res: Vec3 = Vec3()) = add(res, this, b, b, b)
    fun add(b: Vec3, res: Vec3 = Vec3()) = add(res, this, b.x, b.y, b.z)

    fun add_(bX: Float, bY: Float, bZ: Float) = add(this, this, bX, bY, bZ)
    infix fun add_(b: Float) = add(this, this, b, b, b)
    infix fun add_(b: Vec3) = add(this, this, b.x, b.y, b.z)


    operator fun minus(b: Float) = sub(Vec3(), this, b, b, b)
    operator fun minus(b: Vec3) = sub(Vec3(), this, b.x, b.y, b.z)

    fun sub(bX: Float, bY: Float, bZ: Float, res: Vec3 = Vec3()) = sub(res, this, bX, bY, bZ)
    fun sub(b: Float, res: Vec3 = Vec3()) = sub(res, this, b, b, b)
    fun sub(b: Vec3, res: Vec3 = Vec3()) = sub(res, this, b.x, b.y, b.z)

    fun sub_(bX: Float, bY: Float, bZ: Float) = sub(this, this, bX, bY, bZ)
    infix fun sub_(b: Float) = sub(this, this, b, b, b)
    infix fun sub_(b: Vec3) = sub(this, this, b.x, b.y, b.z)


    operator fun times(b: Float) = mul(Vec3(), this, b, b, b)
    operator fun times(b: Vec3) = mul(Vec3(), this, b.x, b.y, b.z)

    fun mul(bX: Float, bY: Float, bZ: Float, res: Vec3 = Vec3()) = mul(res, this, bX, bY, bZ)
    fun mul(b: Float, res: Vec3 = Vec3()) = mul(res, this, b, b, b)
    fun mul(b: Vec3, res: Vec3 = Vec3()) = mul(res, this, b.x, b.y, b.z)

    fun mul_(bX: Float, bY: Float, bZ: Float) = mul(this, this, bX, bY, bZ)
    infix fun mul_(b: Float) = mul(this, this, b, b, b)
    infix fun mul_(b: Vec3) = mul(this, this, b.x, b.y, b.z)


    operator fun div(b: Float) = div(Vec3(), this, b, b, b)
    operator fun div(b: Vec3) = div(Vec3(), this, b.x, b.y, b.z)

    fun div(bX: Float, bY: Float, bZ: Float, res: Vec3 = Vec3()) = div(res, this, bX, bY, bZ)
    fun div(b: Float, res: Vec3 = Vec3()) = div(res, this, b, b, b)
    fun div(b: Vec3, res: Vec3 = Vec3()) = div(res, this, b.x, b.y, b.z)

    fun div_(bX: Float, bY: Float, bZ: Float) = div(this, this, bX, bY, bZ)
    infix fun div_(b: Float) = div(this, this, b, b, b)
    infix fun div_(b: Vec3) = div(this, this, b.x, b.y, b.z)


    operator fun rem(b: Float) = rem(Vec3(), this, b, b, b)
    operator fun rem(b: Vec3) = rem(Vec3(), this, b.x, b.y, b.z)

    fun rem(bX: Float, bY: Float, bZ: Float, res: Vec3 = Vec3()) = rem(res, this, bX, bY, bZ)
    fun rem(b: Float, res: Vec3 = Vec3()) = rem(res, this, b, b, b)
    fun rem(b: Vec3, res: Vec3 = Vec3()) = rem(res, this, b.x, b.y, b.z)

    fun rem_(bX: Float, bY: Float, bZ: Float) = rem(this, this, bX, bY, bZ)
    infix fun rem_(b: Float) = rem(this, this, b, b, b)
    infix fun rem_(b: Vec3) = rem(this, this, b.x, b.y, b.z)


    // -- Generic binary arithmetic operators --

    operator fun plus(b: Number) = add(Vec3(), this, b.f, b.f, b.f)
    operator fun plus(b: Vec3t<Number>) = add(Vec3(), this, b.x.f, b.y.f, b.z.f)

    fun add(bX: Number, bY: Number, bZ: Number, res: Vec3 = Vec3()) = add(res, this, bX.f, bY.f, bZ.f)
    fun add(b: Number, res: Vec3 = Vec3()) = add(res, this, b.f, b.f, b.f)
    fun add(b: Vec3t<Number>, res: Vec3 = Vec3()) = add(res, this, b.x.f, b.y.f, b.z.f)

    fun add_(bX: Number, bY: Number, bZ: Number) = add(this, this, bX.f, bY.f, bZ.f)
    infix fun add_(b: Number) = add(this, this, b.f, b.f, b.f)
    infix fun add_(b: Vec3t<Number>) = add(this, this, b.x.f, b.y.f, b.z.f)


    operator fun minus(b: Number) = sub(Vec3(), this, b.f, b.f, b.f)
    operator fun minus(b: Vec3t<Number>) = sub(Vec3(), this, b.x.f, b.y.f, b.z.f)

    fun sub(bX: Number, bY: Number, bZ: Number, res: Vec3 = Vec3()) = sub(res, this, bX.f, bY.f, bZ.f)
    fun sub(b: Number, res: Vec3 = Vec3()) = sub(res, this, b.f, b.f, b.f)
    fun sub(b: Vec3t<Number>, res: Vec3 = Vec3()) = sub(res, this, b.x.f, b.y.f, b.z.f)

    fun sub_(bX: Number, bY: Number, bZ: Number) = sub(this, this, bX.f, bY.f, bZ.f)
    infix fun sub_(b: Number) = sub(this, this, b.f, b.f, b.f)
    infix fun sub_(b: Vec3t<Number>) = sub(this, this, b.x.f, b.y.f, b.z.f)


    operator fun times(b: Number) = mul(Vec3(), this, b.f, b.f, b.f)
    operator fun times(b: Vec3t<Number>) = mul(Vec3(), this, b.x.f, b.y.f, b.z.f)

    fun mul(bX: Number, bY: Number, bZ: Number, res: Vec3 = Vec3()) = mul(res, this, bX.f, bY.f, bZ.f)
    fun mul(b: Number, res: Vec3 = Vec3()) = mul(res, this, b.f, b.f, b.f)
    fun mul(b: Vec3t<Number>, res: Vec3 = Vec3()) = mul(res, this, b.x.f, b.y.f, b.z.f)

    fun mul_(bX: Number, bY: Number, bZ: Number) = mul(this, this, bX.f, bY.f, bZ.f)
    infix fun mul_(b: Number) = mul(this, this, b.f, b.f, b.f)
    infix fun mul_(b: Vec3t<Number>) = mul(this, this, b.x.f, b.y.f, b.z.f)


    operator fun div(b: Number) = div(Vec3(), this, b.f, b.f, b.f)
    operator fun div(b: Vec3t<Number>) = div(Vec3(), this, b.x.f, b.y.f, b.z.f)

    fun div(bX: Number, bY: Number, bZ: Number, res: Vec3 = Vec3()) = div(res, this, bX.f, bY.f, bZ.f)
    fun div(b: Number, res: Vec3 = Vec3()) = div(res, this, b.f, b.f, b.f)
    fun div(b: Vec3t<Number>, res: Vec3 = Vec3()) = div(res, this, b.x.f, b.y.f, b.z.f)

    fun div_(bX: Number, bY: Number, bZ: Number) = div(this, this, bX.f, bY.f, bZ.f)
    infix fun div_(b: Number) = div(this, this, b.f, b.f, b.f)
    infix fun div_(b: Vec3t<Number>) = div(this, this, b.x.f, b.y.f, b.z.f)


    operator fun rem(b: Number) = rem(Vec3(), this, b.f, b.f, b.f)
    operator fun rem(b: Vec3t<Number>) = rem(Vec3(), this, b.x.f, b.y.f, b.z.f)

    fun rem(bX: Number, bY: Number, bZ: Number, res: Vec3 = Vec3()) = rem(res, this, bX.f, bY.f, bZ.f)
    fun rem(b: Number, res: Vec3 = Vec3()) = rem(res, this, b.f, b.f, b.f)
    fun rem(b: Vec3t<Number>, res: Vec3 = Vec3()) = rem(res, this, b.x.f, b.y.f, b.z.f)

    fun rem_(bX: Number, bY: Number, bZ: Number) = rem(this, this, bX.f, bY.f, bZ.f)
    infix fun rem_(b: Number) = rem(this, this, b.f, b.f, b.f)
    infix fun rem_(b: Vec3t<Number>) = rem(this, this, b.x.f, b.y.f, b.z.f)


    fun normalize(res: Vec3) = normalize(this, res) // TODO others
    fun normalize_() = normalize(this, this)
    infix fun cross(b: Vec3) = cross(this, b)
}


