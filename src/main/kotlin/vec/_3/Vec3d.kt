package vec._3

import main.*
import vec.Vec2t
import vec.Vec3t
import vec.Vec4t
import vec._3.operators.vec3d_operators
import vec.bool.Vec2bool
import vec.bool.Vec3bool
import vec.bool.Vec4bool
import java.nio.*

/**
 * Created by elect on 08/10/16.
 */

data class Vec3d(override var x: Double, override var y: Double, override var z: Double) : Vec3t<Double>() {

    // -- Explicit basic, conversion other main.and conversion vector constructors --

    constructor() : this(0)

    constructor(v: Vec2t<out Number>) : this(v.x, v.y, 0)
    constructor(v: Vec3t<out Number>) : this(v.x, v.y, v.z)
    constructor(v: Vec4t<out Number>) : this(v.x, v.y, v.z)

    constructor(v: Vec2bool) : this(v.x.d, v.y.d, 0)
    constructor(v: Vec3bool) : this(v.x.d, v.y.d, v.z.d)
    constructor(v: Vec4bool) : this(v.x.d, v.y.d, v.z.d)

    constructor(bytes: ByteArray, index: Int = 0, oneByteOneDouble: Boolean = true, bigEndianess: Boolean = true) : this(
            if (oneByteOneDouble) bytes[index].d else bytes.getDouble(index, bigEndianess),
            if (oneByteOneDouble) bytes[index + 1].d else bytes.getDouble(index + Double.BYTES, bigEndianess),
            if (oneByteOneDouble) bytes[index + 2].d else bytes.getDouble(index + Double.BYTES * 2, bigEndianess))

    constructor(chars: CharArray, index: Int = 0) : this(chars[index].d, chars[index + 1].d, chars[index + 2].d)
    constructor(shorts: ShortArray, index: Int = 0) : this(shorts[index], shorts[index + 1], shorts[index + 2])
    constructor(ints: IntArray, index: Int = 0) : this(ints[index], ints[index + 1], ints[index + 2])
    constructor(longs: LongArray, index: Int = 0) : this(longs[index], longs[index + 1], longs[index + 2])
    constructor(floats: FloatArray, index: Int = 0) : this(floats[index], floats[index + 1], floats[index + 2])
    constructor(doubles: DoubleArray, index: Int = 0) : this(doubles[index], doubles[index + 1], doubles[index + 2])
    constructor(booleans: BooleanArray, index: Int = 0) : this(booleans[index].d, booleans[index + 1].d, booleans[index + 2].d)

    constructor(numbers: Array<out Number>, index: Int = 0) : this(numbers[index], numbers[index + 1], numbers[index + 2])
    constructor(chars: Array<Char>, index: Int = 0) : this(chars[index].d, chars[index + 1].d, chars[index + 2].d)
    constructor(booleans: Array<Boolean>, index: Int = 0) : this(booleans[index].d, booleans[index + 1].d, booleans[index + 2].d)

    constructor(list: List<Any>, index: Int = 0) : this() {
        put(list, index)
    }

    constructor(bytes: ByteBuffer, index: Int = bytes.position(), oneByteOneDouble: Boolean = true) : this(
            if (oneByteOneDouble) bytes[index].d else bytes.getDouble(index),
            if (oneByteOneDouble) bytes[index + 1].d else bytes.getDouble(index + Double.BYTES),
            if (oneByteOneDouble) bytes[index + 2].d else bytes.getDouble(index + Double.BYTES * 2))

    constructor(chars: CharBuffer, index: Int = chars.position()) : this(chars[index].d, chars[index + 1].d, chars[index + 2].d)
    constructor(shorts: ShortBuffer, index: Int = shorts.position()) : this(shorts[index], shorts[index + 1], shorts[index + 2])
    constructor(ints: IntBuffer, index: Int = ints.position()) : this(ints[index], ints[index + 1], ints[index + 2])
    constructor(longs: LongBuffer, index: Int = longs.position()) : this(longs[index], longs[index + 1], longs[index + 2])
    constructor(floats: FloatBuffer, index: Int = floats.position()) : this(floats[index], floats[index + 1], floats[index + 2])
    constructor(doubles: DoubleBuffer, index: Int = doubles.position()) : this(doubles[index], doubles[index + 1], doubles[index + 2])

    constructor(s: Number) : this(s, s, s)
    constructor(x: Number, y: Number, z: Number) : this(x.d, y.d, z.d)


    fun set(bytes: ByteArray, index: Int = 0, oneByteOneDouble: Boolean = true, bigEndianess: Boolean = true) {
        x = if (oneByteOneDouble) bytes[index].d else bytes.getDouble(index, bigEndianess)
        y = if (oneByteOneDouble) bytes[index + 1].d else bytes.getDouble(index + Double.BYTES, bigEndianess)
        z = if (oneByteOneDouble) bytes[index + 2].d else bytes.getDouble(index + Double.BYTES * 2, bigEndianess)
    }

    fun set(bytes: ByteBuffer, index: Int = bytes.position(), oneByteOneDouble: Boolean = true) {
        x = if (oneByteOneDouble) bytes[index].d else bytes.getDouble(index)
        y = if (oneByteOneDouble) bytes[index + 1].d else bytes.getDouble(index + Double.BYTES)
        z = if (oneByteOneDouble) bytes[index + 2].d else bytes.getDouble(index + Double.BYTES * 2)
    }


    override fun put(x: Number, y: Number, z: Number): Vec3d {
        this.x = x.d
        this.y = y.d
        this.z = z.d
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
        0 -> x = s.d
        1 -> y = s.d
        2 -> z = s.d
        else -> throw ArrayIndexOutOfBoundsException()
    }


    companion object : vec3d_operators {
        @JvmField val SIZE = 3 * Double.BYTES
    }


    // -- Unary arithmetic operators --

    operator fun unaryPlus() = this

    operator fun unaryMinus() = Vec3d(-x, -y, -z)

    // -- Increment main.and decrement operators --

    operator fun inc(res: Vec3d = Vec3d()) = add(res, this, 1.0, 1.0, 1.0)
    fun inc_() = add(this, this, 1.0, 1.0, 1.0)


    operator fun dec(res: Vec3d = Vec3d()) = sub(res, this, 1.0, 1.0, 1.0)
    fun dec_() = sub(this, this, 1.0, 1.0, 1.0)


    // -- Specific binary arithmetic operators --

    operator fun plus(b: Double) = add(Vec3d(), this, b, b, b)
    operator fun plus(b: Vec3d) = add(Vec3d(), this, b.x, b.y, b.z)

    fun add(bX: Double, bY: Double, bZ: Double, res: Vec3d = Vec3d()) = add(res, this, bX, bY, bZ)
    fun add(b: Double, res: Vec3d = Vec3d()) = add(res, this, b, b, b)
    fun add(b: Vec3d, res: Vec3d = Vec3d()) = add(res, this, b.x, b.y, b.z)

    fun add_(bX: Double, bY: Double, bZ: Double) = add(this, this, bX, bY, bZ)
    infix fun add_(b: Double) = add(this, this, b, b, b)
    infix fun add_(b: Vec3d) = add(this, this, b.x, b.y, b.z)


    operator fun minus(b: Double) = sub(Vec3d(), this, b, b, b)
    operator fun minus(b: Vec3d) = sub(Vec3d(), this, b.x, b.y, b.z)

    fun sub(bX: Double, bY: Double, bZ: Double, res: Vec3d = Vec3d()) = sub(res, this, bX, bY, bZ)
    fun sub(b: Double, res: Vec3d = Vec3d()) = sub(res, this, b, b, b)
    fun sub(b: Vec3d, res: Vec3d = Vec3d()) = sub(res, this, b.x, b.y, b.z)

    fun sub_(bX: Double, bY: Double, bZ: Double) = sub(this, this, bX, bY, bZ)
    infix fun sub_(b: Double) = sub(this, this, b, b, b)
    infix fun sub_(b: Vec3d) = sub(this, this, b.x, b.y, b.z)


    operator fun times(b: Double) = mul(Vec3d(), this, b, b, b)
    operator fun times(b: Vec3d) = mul(Vec3d(), this, b.x, b.y, b.z)

    fun mul(bX: Double, bY: Double, bZ: Double, res: Vec3d = Vec3d()) = mul(res, this, bX, bY, bZ)
    fun mul(b: Double, res: Vec3d = Vec3d()) = mul(res, this, b, b, b)
    fun mul(b: Vec3d, res: Vec3d = Vec3d()) = mul(res, this, b.x, b.y, b.z)

    fun mul_(bX: Double, bY: Double, bZ: Double) = mul(this, this, bX, bY, bZ)
    infix fun mul_(b: Double) = mul(this, this, b, b, b)
    infix fun mul_(b: Vec3d) = mul(this, this, b.x, b.y, b.z)


    operator fun div(b: Double) = div(Vec3d(), this, b, b, b)
    operator fun div(b: Vec3d) = div(Vec3d(), this, b.x, b.y, b.z)

    fun div(bX: Double, bY: Double, bZ: Double, res: Vec3d = Vec3d()) = div(res, this, bX, bY, bZ)
    fun div(b: Double, res: Vec3d = Vec3d()) = div(res, this, b, b, b)
    fun div(b: Vec3d, res: Vec3d = Vec3d()) = div(res, this, b.x, b.y, b.z)

    fun div_(bX: Double, bY: Double, bZ: Double) = div(this, this, bX, bY, bZ)
    infix fun div_(b: Double) = div(this, this, b, b, b)
    infix fun div_(b: Vec3d) = div(this, this, b.x, b.y, b.z)


    operator fun rem(b: Double) = rem(Vec3d(), this, b, b, b)
    operator fun rem(b: Vec3d) = rem(Vec3d(), this, b.x, b.y, b.z)

    fun rem(bX: Double, bY: Double, bZ: Double, res: Vec3d = Vec3d()) = rem(res, this, bX, bY, bZ)
    fun rem(b: Double, res: Vec3d = Vec3d()) = rem(res, this, b, b, b)
    fun rem(b: Vec3d, res: Vec3d = Vec3d()) = rem(res, this, b.x, b.y, b.z)

    fun rem_(bX: Double, bY: Double, bZ: Double) = rem(this, this, bX, bY, bZ)
    infix fun rem_(b: Double) = rem(this, this, b, b, b)
    infix fun rem_(b: Vec3d) = rem(this, this, b.x, b.y, b.z)


    // -- Generic binary arithmetic operators --

    operator fun plus(b: Number) = add(Vec3d(), this, b.d, b.d, b.d)
    operator fun plus(b: Vec3t<Number>) = add(Vec3d(), this, b.x.d, b.y.d, b.z.d)

    fun add(bX: Number, bY: Number, bZ: Number, res: Vec3d = Vec3d()) = add(res, this, bX.d, bY.d, bZ.d)
    fun add(b: Number, res: Vec3d = Vec3d()) = add(res, this, b.d, b.d, b.d)
    fun add(b: Vec3t<Number>, res: Vec3d = Vec3d()) = add(res, this, b.x.d, b.y.d, b.z.d)

    fun add_(bX: Number, bY: Number, bZ: Number) = add(this, this, bX.d, bY.d, bZ.d)
    infix fun add_(b: Number) = add(this, this, b.d, b.d, b.d)
    infix fun add_(b: Vec3t<Number>) = add(this, this, b.x.d, b.y.d, b.z.d)


    operator fun minus(b: Number) = sub(Vec3d(), this, b.d, b.d, b.d)
    operator fun minus(b: Vec3t<Number>) = sub(Vec3d(), this, b.x.d, b.y.d, b.z.d)

    fun sub(bX: Number, bY: Number, bZ: Number, res: Vec3d = Vec3d()) = sub(res, this, bX.d, bY.d, bZ.d)
    fun sub(b: Number, res: Vec3d = Vec3d()) = sub(res, this, b.d, b.d, b.d)
    fun sub(b: Vec3t<Number>, res: Vec3d = Vec3d()) = sub(res, this, b.x.d, b.y.d, b.z.d)

    fun sub_(bX: Number, bY: Number, bZ: Number) = sub(this, this, bX.d, bY.d, bZ.d)
    infix fun sub_(b: Number) = sub(this, this, b.d, b.d, b.d)
    infix fun sub_(b: Vec3t<Number>) = sub(this, this, b.x.d, b.y.d, b.z.d)


    operator fun times(b: Number) = mul(Vec3d(), this, b.d, b.d, b.d)
    operator fun times(b: Vec3t<Number>) = mul(Vec3d(), this, b.x.d, b.y.d, b.z.d)

    fun mul(bX: Number, bY: Number, bZ: Number, res: Vec3d = Vec3d()) = mul(res, this, bX.d, bY.d, bZ.d)
    fun mul(b: Number, res: Vec3d = Vec3d()) = mul(res, this, b.d, b.d, b.d)
    fun mul(b: Vec3t<Number>, res: Vec3d = Vec3d()) = mul(res, this, b.x.d, b.y.d, b.z.d)

    fun mul_(bX: Number, bY: Number, bZ: Number) = mul(this, this, bX.d, bY.d, bZ.d)
    infix fun mul_(b: Number) = mul(this, this, b.d, b.d, b.d)
    infix fun mul_(b: Vec3t<Number>) = mul(this, this, b.x.d, b.y.d, b.z.d)


    operator fun div(b: Number) = div(Vec3d(), this, b.d, b.d, b.d)
    operator fun div(b: Vec3t<Number>) = div(Vec3d(), this, b.x.d, b.y.d, b.z.d)

    fun div(bX: Number, bY: Number, bZ: Number, res: Vec3d = Vec3d()) = div(res, this, bX.d, bY.d, bZ.d)
    fun div(b: Number, res: Vec3d = Vec3d()) = div(res, this, b.d, b.d, b.d)
    fun div(b: Vec3t<Number>, res: Vec3d = Vec3d()) = div(res, this, b.x.d, b.y.d, b.z.d)

    fun div_(bX: Number, bY: Number, bZ: Number) = div(this, this, bX.d, bY.d, bZ.d)
    infix fun div_(b: Number) = div(this, this, b.d, b.d, b.d)
    infix fun div_(b: Vec3t<Number>) = div(this, this, b.x.d, b.y.d, b.z.d)


    operator fun rem(b: Number) = rem(Vec3d(), this, b.d, b.d, b.d)
    operator fun rem(b: Vec3t<Number>) = rem(Vec3d(), this, b.x.d, b.y.d, b.z.d)

    fun rem(bX: Number, bY: Number, bZ: Number, res: Vec3d = Vec3d()) = rem(res, this, bX.d, bY.d, bZ.d)
    fun rem(b: Number, res: Vec3d = Vec3d()) = rem(res, this, b.d, b.d, b.d)
    fun rem(b: Vec3t<Number>, res: Vec3d = Vec3d()) = rem(res, this, b.x.d, b.y.d, b.z.d)

    fun rem_(bX: Number, bY: Number, bZ: Number) = rem(this, this, bX.d, bY.d, bZ.d)
    infix fun rem_(b: Number) = rem(this, this, b.d, b.d, b.d)
    infix fun rem_(b: Vec3t<Number>) = rem(this, this, b.x.d, b.y.d, b.z.d)


    // -- functions --

    fun length() = glm.length(this)

    @JvmOverloads fun normalize(res: Vec3d = Vec3d()) = glm.normalize(this, res) // TODO others
    fun normalize_() = glm.normalize(this, this)

    infix fun cross(b: Vec3d) = glm.cross(this, b)
    fun cross_(b: Vec3d) = glm.cross(this, b, this)

    @JvmOverloads fun negate(res: Vec3d = Vec3d()): Vec3d {
        x = -x
        y = -y
        z = -z
        return this
    }
    fun negate_() = negate(this)
}