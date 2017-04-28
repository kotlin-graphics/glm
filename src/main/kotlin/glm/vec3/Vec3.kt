package glm.vec3

import glm.*
import glm.vec2.Vec2t
import glm.vec3.Vec3t
import glm.vec4.Vec4t
import glm.vec2.Vec2bool
import glm.vec3.Vec3bool
import glm.vec4.Vec4bool
import glm.vec3.operators.vec3_operators
import java.nio.*

/**
 * Created bY GBarbieri on 05.10.2016.
 */

class Vec3(x: Float, y: Float, z: Float) : Vec3t<Float>(x, y, z) {


    // -- Explicit basic, conversion other main.and conversion vector constructors --

    constructor() : this(0)

    constructor(v: Vec2t<out Number>) : this(v, 0)
    constructor(v: Vec2t<out Number>, z: Number) : this(v.x, v.y, z)
    constructor(x: Number, v: Vec2t<out Number>) : this(x, v.x, v.y)
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


    override infix fun put(s: Number) = put(s, s, s)
    override fun put(x: Number, y: Number, z: Number): Vec3 {
        this.x = x.f
        this.y = y.f
        this.z = z.f
        return this
    }

    // TODO others
    infix fun put(s: Float) = put(s, s, s)
    infix fun put(v: Vec3) = put(v.x, v.y, v.z)
    fun put(x: Float, y: Float, z: Float): Vec3 {
        this.x = x
        this.y = y
        this.z = z
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
        @JvmField val length = 3
        @JvmField val size = length * Float.BYTES
    }


    // TODO others
    infix fun to(floats: FloatArray) = to(floats, 0)

    fun to(floats: FloatArray, index: Int): FloatArray {
        floats[index] = x
        floats[index + 1] = y
        floats[index + 2] = z
        return floats
    }

    infix fun to(floats: FloatBuffer) = to(floats, floats.position())

    fun to(floats: FloatBuffer, index: Int): FloatBuffer {
        floats[index] = x
        floats[index + 1] = y
        floats[index + 2] = z
        return floats
    }

    infix fun to(bytes: ByteBuffer) = to(bytes, bytes.position())

    fun to(bytes: ByteBuffer, offset: Int): ByteBuffer = bytes.putFloat(offset, x).putFloat(offset + Float.BYTES, y).putFloat(offset + Float.BYTES * 2, z)


    // -- Unary arithmetic operators --

    operator fun unaryPlus() = this

    operator fun unaryMinus() = Vec3(-x, -y, -z)

    // -- Increment main.and decrement operators --

    operator fun inc(res: Vec3 = Vec3()) = plus(res, this, 1f, 1f, 1f)
    fun inc_() = plus(this, this, 1f, 1f, 1f)


    operator fun dec(res: Vec3 = Vec3()) = minus(res, this, 1f, 1f, 1f)
    fun dec_() = minus(this, this, 1f, 1f, 1f)


    // -- Specific binary arithmetic operators --

    infix operator fun plus(b: Float) = plus(Vec3(), this, b, b, b)
    infix operator fun plus(b: Vec3) = plus(Vec3(), this, b.x, b.y, b.z)

    @JvmOverloads fun plus(bX: Float, bY: Float, bZ: Float, res: Vec3 = Vec3()) = plus(res, this, bX, bY, bZ)
    fun plus(b: Float, res: Vec3 = Vec3()) = plus(res, this, b, b, b)
    fun plus(b: Vec3, res: Vec3 = Vec3()) = plus(res, this, b.x, b.y, b.z)

    fun plus_(bX: Float, bY: Float, bZ: Float) = plus(this, this, bX, bY, bZ)
    infix fun plus_(b: Float) = plus(this, this, b, b, b)
    infix fun plus_(b: Vec3) = plus(this, this, b.x, b.y, b.z)


    infix operator fun minus(b: Float) = minus(Vec3(), this, b, b, b)
    infix operator fun minus(b: Vec3) = minus(Vec3(), this, b.x, b.y, b.z)

    @JvmOverloads fun minus(bX: Float, bY: Float, bZ: Float, res: Vec3 = Vec3()) = minus(res, this, bX, bY, bZ)
    fun minus(b: Float, res: Vec3 = Vec3()) = minus(res, this, b, b, b)
    fun minus(b: Vec3, res: Vec3 = Vec3()) = minus(res, this, b.x, b.y, b.z) // TODO overload others

    fun minus_(bX: Float, bY: Float, bZ: Float) = minus(this, this, bX, bY, bZ)
    infix fun minus_(b: Float) = minus(this, this, b, b, b)
    infix fun minus_(b: Vec3) = minus(this, this, b.x, b.y, b.z)


    infix operator fun times(b: Float) = times(Vec3(), this, b, b, b)
    infix operator fun times(b: Vec3) = times(Vec3(), this, b.x, b.y, b.z)

    @JvmOverloads fun times(bX: Float, bY: Float, bZ: Float, res: Vec3 = Vec3()) = times(res, this, bX, bY, bZ)
    fun times(b: Float, res: Vec3 = Vec3()) = times(res, this, b, b, b)
    fun times(b: Vec3, res: Vec3 = Vec3()) = times(res, this, b.x, b.y, b.z)

    fun times_(bX: Float, bY: Float, bZ: Float) = times(this, this, bX, bY, bZ)
    infix fun times_(b: Float) = times(this, this, b, b, b)
    infix fun times_(b: Vec3) = times(this, this, b.x, b.y, b.z)


    operator fun div(b: Float) = div(Vec3(), this, b, b, b)
    operator fun div(b: Vec3) = div(Vec3(), this, b.x, b.y, b.z)

    @JvmOverloads fun div(bX: Float, bY: Float, bZ: Float, res: Vec3 = Vec3()) = div(res, this, bX, bY, bZ)
    fun div(b: Float, res: Vec3 = Vec3()) = div(res, this, b, b, b)
    fun div(b: Vec3, res: Vec3 = Vec3()) = div(res, this, b.x, b.y, b.z)

    fun div_(bX: Float, bY: Float, bZ: Float) = div(this, this, bX, bY, bZ)
    infix fun div_(b: Float) = div(this, this, b, b, b)
    infix fun div_(b: Vec3) = div(this, this, b.x, b.y, b.z)


    infix operator fun rem(b: Float) = rem(Vec3(), this, b, b, b)
    infix operator fun rem(b: Vec3) = rem(Vec3(), this, b.x, b.y, b.z)

    @JvmOverloads fun rem(bX: Float, bY: Float, bZ: Float, res: Vec3 = Vec3()) = rem(res, this, bX, bY, bZ)
    fun rem(b: Float, res: Vec3 = Vec3()) = rem(res, this, b, b, b)
    fun rem(b: Vec3, res: Vec3 = Vec3()) = rem(res, this, b.x, b.y, b.z)

    fun rem_(bX: Float, bY: Float, bZ: Float) = rem(this, this, bX, bY, bZ)
    infix fun rem_(b: Float) = rem(this, this, b, b, b)
    infix fun rem_(b: Vec3) = rem(this, this, b.x, b.y, b.z)


    // -- Generic binary arithmetic operators --

    infix operator fun plus(b: Number) = plus(Vec3(), this, b.f, b.f, b.f)
    infix operator fun plus(b: Vec3t<out Number>) = plus(Vec3(), this, b.x.f, b.y.f, b.z.f)

    @JvmOverloads fun plus(bX: Number, bY: Number, bZ: Number, res: Vec3 = Vec3()) = plus(res, this, bX.f, bY.f, bZ.f)
    fun plus(b: Number, res: Vec3) = plus(res, this, b.f, b.f, b.f)
    fun plus(b: Vec3t<out Number>, res: Vec3 = Vec3()) = plus(res, this, b.x.f, b.y.f, b.z.f)

    fun plus_(bX: Number, bY: Number, bZ: Number) = plus(this, this, bX.f, bY.f, bZ.f)
    infix fun plus_(b: Number) = plus(this, this, b.f, b.f, b.f)
    infix fun plus_(b: Vec3t<out Number>) = plus(this, this, b.x.f, b.y.f, b.z.f)


    infix operator fun minus(b: Number) = minus(Vec3(), this, b.f, b.f, b.f)
    infix operator fun minus(b: Vec3t<out Number>) = minus(Vec3(), this, b.x.f, b.y.f, b.z.f)

    fun minus(bX: Number, bY: Number, bZ: Number, res: Vec3 = Vec3()) = minus(res, this, bX.f, bY.f, bZ.f)
    fun minus(b: Number, res: Vec3 = Vec3()) = minus(res, this, b.f, b.f, b.f)
    fun minus(b: Vec3t<out Number>, res: Vec3 = Vec3()) = minus(res, this, b.x.f, b.y.f, b.z.f)

    fun minus_(bX: Number, bY: Number, bZ: Number) = minus(this, this, bX.f, bY.f, bZ.f)
    infix fun minus_(b: Number) = minus(this, this, b.f, b.f, b.f)
    infix fun minus_(b: Vec3t<out Number>) = minus(this, this, b.x.f, b.y.f, b.z.f)


    infix operator fun times(b: Number) = times(Vec3(), this, b.f, b.f, b.f)
    infix operator fun times(b: Vec3t<out Number>) = times(Vec3(), this, b.x.f, b.y.f, b.z.f)

    fun times(bX: Number, bY: Number, bZ: Number, res: Vec3 = Vec3()) = times(res, this, bX.f, bY.f, bZ.f)
    fun times(b: Number, res: Vec3 = Vec3()) = times(res, this, b.f, b.f, b.f)
    fun times(b: Vec3t<out Number>, res: Vec3 = Vec3()) = times(res, this, b.x.f, b.y.f, b.z.f)

    fun times_(bX: Number, bY: Number, bZ: Number) = times(this, this, bX.f, bY.f, bZ.f)
    infix fun times_(b: Number) = times(this, this, b.f, b.f, b.f)
    infix fun times_(b: Vec3t<out Number>) = times(this, this, b.x.f, b.y.f, b.z.f)


    infix operator fun div(b: Number) = div(Vec3(), this, b.f, b.f, b.f)
    infix operator fun div(b: Vec3t<out Number>) = div(Vec3(), this, b.x.f, b.y.f, b.z.f)

    fun div(bX: Number, bY: Number, bZ: Number, res: Vec3 = Vec3()) = div(res, this, bX.f, bY.f, bZ.f)
    fun div(b: Number, res: Vec3 = Vec3()) = div(res, this, b.f, b.f, b.f)
    fun div(b: Vec3t<out Number>, res: Vec3 = Vec3()) = div(res, this, b.x.f, b.y.f, b.z.f)

    fun div_(bX: Number, bY: Number, bZ: Number) = div(this, this, bX.f, bY.f, bZ.f)
    infix fun div_(b: Number) = div(this, this, b.f, b.f, b.f)
    infix fun div_(b: Vec3t<out Number>) = div(this, this, b.x.f, b.y.f, b.z.f)


    infix operator fun rem(b: Number) = rem(Vec3(), this, b.f, b.f, b.f)
    infix operator fun rem(b: Vec3t<out Number>) = rem(Vec3(), this, b.x.f, b.y.f, b.z.f)

    fun rem(bX: Number, bY: Number, bZ: Number, res: Vec3 = Vec3()) = rem(res, this, bX.f, bY.f, bZ.f)
    fun rem(b: Number, res: Vec3 = Vec3()) = rem(res, this, b.f, b.f, b.f)
    fun rem(b: Vec3t<out Number>, res: Vec3 = Vec3()) = rem(res, this, b.x.f, b.y.f, b.z.f)

    fun rem_(bX: Number, bY: Number, bZ: Number) = rem(this, this, bX.f, bY.f, bZ.f)
    infix fun rem_(b: Number) = rem(this, this, b.f, b.f, b.f)
    infix fun rem_(b: Vec3t<out Number>) = rem(this, this, b.x.f, b.y.f, b.z.f)


    // -- functions --

    fun length() = glm.length(this)

    @JvmOverloads fun normalize(res: Vec3 = Vec3()) = glm.normalize(this, res) // TODO others
    fun normalize_() = glm.normalize(this, this)

    infix fun cross(b: Vec3) = glm.cross(this, b, Vec3())
    infix fun cross_(b: Vec3) = glm.cross(this, b, this)

    @JvmOverloads fun negate(res: Vec3 = Vec3()): Vec3 {
        x = -x
        y = -y
        z = -z
        return this
    }

    fun negate_() = negate(this)


    override fun equals(other: Any?) =
            if (other is Vec3)
                this[0] == other[0] && this[1] == other[1] && this[2] == other[2]
            else false
}


