package glm.vec3

import glm.*
import glm.vec3.operators.vec3d_operators
import glm.vec2.Vec2bool
import glm.vec2.Vec2t
import glm.vec4.Vec4bool
import glm.vec4.Vec4t
import java.nio.*

/**
 * Created by elect on 08/10/16.
 */

class Vec3d(x: Double, y: Double, z: Double) : Vec3t<Double>(x, y, z) {

    // -- Explicit basic, conversion other main.and conversion vector constructors --

    constructor() : this(0)

    constructor(v: Vec2t<out Number>) : this(v.x, v.y, 0)
    constructor(v: Vec2t<out Number>, z: Number) : this(v.x, v.y, z)
    constructor(x: Number, v: Vec2t<out Number>) : this(x, v.x, v.y)
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
        @JvmField val length = 3
        @JvmField val size = length * Double.BYTES
    }


    // -- Unary arithmetic operators --

    operator fun unaryPlus() = this

    operator fun unaryMinus() = Vec3d(-x, -y, -z)

    // -- Increment main.and decrement operators --

    operator fun inc(res: Vec3d = Vec3d()) = plus(res, this, 1.0, 1.0, 1.0)
    fun inc_() = plus(this, this, 1.0, 1.0, 1.0)


    operator fun dec(res: Vec3d = Vec3d()) = minus(res, this, 1.0, 1.0, 1.0)
    fun dec_() = minus(this, this, 1.0, 1.0, 1.0)


    // -- Specific binary arithmetic operators --

    operator fun plus(b: Double) = plus(Vec3d(), this, b, b, b)
    operator fun plus(b: Vec3d) = plus(Vec3d(), this, b.x, b.y, b.z)

    fun plus(bX: Double, bY: Double, bZ: Double, res: Vec3d = Vec3d()) = plus(res, this, bX, bY, bZ)
    fun plus(b: Double, res: Vec3d = Vec3d()) = plus(res, this, b, b, b)
    fun plus(b: Vec3d, res: Vec3d = Vec3d()) = plus(res, this, b.x, b.y, b.z)

    fun plus_(bX: Double, bY: Double, bZ: Double) = plus(this, this, bX, bY, bZ)
    infix fun plus_(b: Double) = plus(this, this, b, b, b)
    infix fun plus_(b: Vec3d) = plus(this, this, b.x, b.y, b.z)


    operator fun minus(b: Double) = minus(Vec3d(), this, b, b, b)
    operator fun minus(b: Vec3d) = minus(Vec3d(), this, b.x, b.y, b.z)

    fun minus(bX: Double, bY: Double, bZ: Double, res: Vec3d = Vec3d()) = minus(res, this, bX, bY, bZ)
    fun minus(b: Double, res: Vec3d = Vec3d()) = minus(res, this, b, b, b)
    fun minus(b: Vec3d, res: Vec3d = Vec3d()) = minus(res, this, b.x, b.y, b.z)

    fun minus_(bX: Double, bY: Double, bZ: Double) = minus(this, this, bX, bY, bZ)
    infix fun minus_(b: Double) = minus(this, this, b, b, b)
    infix fun minus_(b: Vec3d) = minus(this, this, b.x, b.y, b.z)


    operator fun times(b: Double) = times(Vec3d(), this, b, b, b)
    operator fun times(b: Vec3d) = times(Vec3d(), this, b.x, b.y, b.z)

    fun times(bX: Double, bY: Double, bZ: Double, res: Vec3d = Vec3d()) = times(res, this, bX, bY, bZ)
    fun times(b: Double, res: Vec3d = Vec3d()) = times(res, this, b, b, b)
    fun times(b: Vec3d, res: Vec3d = Vec3d()) = times(res, this, b.x, b.y, b.z)

    fun times_(bX: Double, bY: Double, bZ: Double) = times(this, this, bX, bY, bZ)
    infix fun times_(b: Double) = times(this, this, b, b, b)
    infix fun times_(b: Vec3d) = times(this, this, b.x, b.y, b.z)


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

    operator fun plus(b: Number) = plus(Vec3d(), this, b.d, b.d, b.d)
    operator fun plus(b: Vec3t<out Number>) = plus(Vec3d(), this, b.x.d, b.y.d, b.z.d)

    fun plus(bX: Number, bY: Number, bZ: Number, res: Vec3d = Vec3d()) = plus(res, this, bX.d, bY.d, bZ.d)
    fun plus(b: Number, res: Vec3d = Vec3d()) = plus(res, this, b.d, b.d, b.d)
    fun plus(b: Vec3t<out Number>, res: Vec3d = Vec3d()) = plus(res, this, b.x.d, b.y.d, b.z.d)

    fun plus_(bX: Number, bY: Number, bZ: Number) = plus(this, this, bX.d, bY.d, bZ.d)
    infix fun plus_(b: Number) = plus(this, this, b.d, b.d, b.d)
    infix fun plus_(b: Vec3t<out Number>) = plus(this, this, b.x.d, b.y.d, b.z.d)


    operator fun minus(b: Number) = minus(Vec3d(), this, b.d, b.d, b.d)
    operator fun minus(b: Vec3t<out Number>) = minus(Vec3d(), this, b.x.d, b.y.d, b.z.d)

    fun minus(bX: Number, bY: Number, bZ: Number, res: Vec3d = Vec3d()) = minus(res, this, bX.d, bY.d, bZ.d)
    fun minus(b: Number, res: Vec3d = Vec3d()) = minus(res, this, b.d, b.d, b.d)
    fun minus(b: Vec3t<out Number>, res: Vec3d = Vec3d()) = minus(res, this, b.x.d, b.y.d, b.z.d)

    fun minus_(bX: Number, bY: Number, bZ: Number) = minus(this, this, bX.d, bY.d, bZ.d)
    infix fun minus_(b: Number) = minus(this, this, b.d, b.d, b.d)
    infix fun minus_(b: Vec3t<out Number>) = minus(this, this, b.x.d, b.y.d, b.z.d)


    operator fun times(b: Number) = times(Vec3d(), this, b.d, b.d, b.d)
    operator fun times(b: Vec3t<out Number>) = times(Vec3d(), this, b.x.d, b.y.d, b.z.d)

    fun times(bX: Number, bY: Number, bZ: Number, res: Vec3d = Vec3d()) = times(res, this, bX.d, bY.d, bZ.d)
    fun times(b: Number, res: Vec3d = Vec3d()) = times(res, this, b.d, b.d, b.d)
    fun times(b: Vec3t<out Number>, res: Vec3d = Vec3d()) = times(res, this, b.x.d, b.y.d, b.z.d)

    fun times_(bX: Number, bY: Number, bZ: Number) = times(this, this, bX.d, bY.d, bZ.d)
    infix fun times_(b: Number) = times(this, this, b.d, b.d, b.d)
    infix fun times_(b: Vec3t<out Number>) = times(this, this, b.x.d, b.y.d, b.z.d)


    operator fun div(b: Number) = div(Vec3d(), this, b.d, b.d, b.d)
    operator fun div(b: Vec3t<out Number>) = div(Vec3d(), this, b.x.d, b.y.d, b.z.d)

    fun div(bX: Number, bY: Number, bZ: Number, res: Vec3d = Vec3d()) = div(res, this, bX.d, bY.d, bZ.d)
    fun div(b: Number, res: Vec3d = Vec3d()) = div(res, this, b.d, b.d, b.d)
    fun div(b: Vec3t<out Number>, res: Vec3d = Vec3d()) = div(res, this, b.x.d, b.y.d, b.z.d)

    fun div_(bX: Number, bY: Number, bZ: Number) = div(this, this, bX.d, bY.d, bZ.d)
    infix fun div_(b: Number) = div(this, this, b.d, b.d, b.d)
    infix fun div_(b: Vec3t<out Number>) = div(this, this, b.x.d, b.y.d, b.z.d)


    operator fun rem(b: Number) = rem(Vec3d(), this, b.d, b.d, b.d)
    operator fun rem(b: Vec3t<out Number>) = rem(Vec3d(), this, b.x.d, b.y.d, b.z.d)

    fun rem(bX: Number, bY: Number, bZ: Number, res: Vec3d = Vec3d()) = rem(res, this, bX.d, bY.d, bZ.d)
    fun rem(b: Number, res: Vec3d = Vec3d()) = rem(res, this, b.d, b.d, b.d)
    fun rem(b: Vec3t<out Number>, res: Vec3d = Vec3d()) = rem(res, this, b.x.d, b.y.d, b.z.d)

    fun rem_(bX: Number, bY: Number, bZ: Number) = rem(this, this, bX.d, bY.d, bZ.d)
    infix fun rem_(b: Number) = rem(this, this, b.d, b.d, b.d)
    infix fun rem_(b: Vec3t<out Number>) = rem(this, this, b.x.d, b.y.d, b.z.d)


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


    override fun equals(other: Any?) =
            if (other is Vec3d)
                this[0] == other[0] && this[1] == other[1] && this[2] == other[2]
            else false
}