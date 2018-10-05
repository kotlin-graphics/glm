package glm_.vec3

import glm_.*
import glm_.vec2.Vec2
import glm_.vec2.Vec2bool
import glm_.vec2.Vec2t
import glm_.vec3.operators.vec3_operators
import glm_.vec4.Vec4bool
import glm_.vec4.Vec4t
import kool.floatBufferBig
import kool.pos
import org.lwjgl.system.MemoryStack
import java.awt.Color
import java.io.InputStream
import java.nio.*

/**
 * Created bY GBarbieri on 05.10.2016.
 */

class Vec3(var ofs: Int, var array: FloatArray) : Vec3t<Float>(), ToBuffer {

    constructor(x: Float, y: Float, z: Float) : this(0, floatArrayOf(x, y, z))

    override var x: Float
        get() = array[ofs]
        set(value) = array.set(ofs, value)
    override var y: Float
        get() = array[ofs + 1]
        set(value) = array.set(ofs + 1, value)
    override var z: Float
        get() = array[ofs + 2]
        set(value) = array.set(ofs + 2, value)

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

    constructor(bytes: ByteArray, index: Int = 0, oneByteOneFloat: Boolean = false, bigEndian: Boolean = true) : this(
            if (oneByteOneFloat) bytes[index].f else bytes.getFloat(index, bigEndian),
            if (oneByteOneFloat) bytes[index + 1].f else bytes.getFloat(index + Float.BYTES, bigEndian),
            if (oneByteOneFloat) bytes[index + 2].f else bytes.getFloat(index + Float.BYTES * 2, bigEndian))

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

    constructor(list: Iterable<*>, index: Int = 0) : this(list.elementAt(index)!!.toFloat, list.elementAt(index + 1)!!.toFloat,
            list.elementAt(index + 2)!!.toFloat)

    constructor(bytes: ByteBuffer, index: Int = bytes.pos, oneByteOneFloat: Boolean = false) : this(
            if (oneByteOneFloat) bytes[index].f else bytes.getFloat(index),
            if (oneByteOneFloat) bytes[index + 1].f else bytes.getFloat(index + Float.BYTES),
            if (oneByteOneFloat) bytes[index + 2].f else bytes.getFloat(index + Float.BYTES * 2))

    constructor(chars: CharBuffer, index: Int = chars.pos) : this(chars[index].f, chars[index + 1].f, chars[index + 2].f)
    constructor(shorts: ShortBuffer, index: Int = shorts.pos) : this(shorts[index], shorts[index + 1], shorts[index + 2])
    constructor(ints: IntBuffer, index: Int = ints.pos) : this(ints[index], ints[index + 1], ints[index + 2])
    constructor(longs: LongBuffer, index: Int = longs.pos) : this(longs[index], longs[index + 1], longs[index + 2])
    constructor(floats: FloatBuffer, index: Int = floats.pos) : this(floats[index], floats[index + 1], floats[index + 2])
    constructor(doubles: DoubleBuffer, index: Int = doubles.pos) : this(doubles[index], doubles[index + 1], doubles[index + 2])

    constructor(block: (Int) -> Float) : this(block(0), block(1), block(2))

    constructor(s: Number) : this(s, s, s)
    constructor(x: Number, y: Number, z: Number) : this(x.f, y.f, z.f)


    constructor(inputStream: InputStream, bigEndian: Boolean = true) :
            this(inputStream.float(bigEndian), inputStream.float(bigEndian), inputStream.float(bigEndian))

    constructor(color: Color) : this (color.red / 255f, color.green / 255f, color.blue / 255f)

    fun set(bytes: ByteArray, index: Int = 0, oneByteOneFloat: Boolean = false, bigEndian: Boolean = true) {
        x = if (oneByteOneFloat) bytes[index].f else bytes.getFloat(index, bigEndian)
        y = if (oneByteOneFloat) bytes[index + 1].f else bytes.getFloat(index + Float.BYTES, bigEndian)
        z = if (oneByteOneFloat) bytes[index + 2].f else bytes.getFloat(index + Float.BYTES * 2, bigEndian)
    }

    fun set(bytes: ByteBuffer, index: Int = bytes.pos, oneByteOneFloat: Boolean = false) {
        x = if (oneByteOneFloat) bytes[index].f else bytes.getFloat(index)
        y = if (oneByteOneFloat) bytes[index + 1].f else bytes.getFloat(index + Float.BYTES)
        z = if (oneByteOneFloat) bytes[index + 2].f else bytes.getFloat(index + Float.BYTES * 2)
    }


    fun put(x: Float, y: Float, z: Float) {
        this.x = x
        this.y = y
        this.z = z
    }

    fun invoke(x: Float, y: Float, z: Float): Vec3 {
        this.x = x
        this.y = y
        this.z = z
        return this
    }

    override fun put(x: Number, y: Number, z: Number) {
        this.x = x.f
        this.y = y.f
        this.z = z.f
    }

    override fun invoke(x: Number, y: Number, z: Number): Vec3 {
        this.x = x.f
        this.y = y.f
        this.z = z.f
        return this
    }

    fun to(bytes: ByteArray, index: Int): ByteArray = to(bytes, index, true)
    override fun to(bytes: ByteArray, index: Int, bigEndian: Boolean): ByteArray {
        bytes.putFloat(index, x, bigEndian)
        bytes.putFloat(index + Float.BYTES, y, bigEndian)
        bytes.putFloat(index + Float.BYTES * 2, z, bigEndian)
        return bytes
    }

    fun toFloatArray(): FloatArray = to(FloatArray(length), 0)
    infix fun to(floats: FloatArray): FloatArray = to(floats, 0)
    fun to(floats: FloatArray, index: Int): FloatArray {
        System.arraycopy(array, ofs, floats, index, length)
        return floats
    }

    override fun to(buf: ByteBuffer, offset: Int): ByteBuffer {
        buf.putFloat(offset, x)
        buf.putFloat(offset + Float.BYTES, y)
        buf.putFloat(offset + Float.BYTES * 2, z)
        return buf
    }

    fun toFloatBufferStack(): FloatBuffer = to(MemoryStack.stackPush().mallocFloat(length), 0)
    infix fun toFloatBuffer(stack: MemoryStack): FloatBuffer = to(stack.mallocFloat(length), 0)
    fun toFloatBuffer(): FloatBuffer = to(floatBufferBig(length), 0)
    infix fun to(buf: FloatBuffer): FloatBuffer = to(buf, buf.pos)
    fun to(buf: FloatBuffer, index: Int): FloatBuffer {
        buf[index] = x
        buf[index + 1] = y
        buf[index + 2] = z
        return buf
    }

    // -- Component accesses --

    operator fun set(index: Int, value: Float) = when (index) {
        0 -> x = value
        1 -> y = value
        2 -> z = value
        else -> throw ArrayIndexOutOfBoundsException()
    }

    override operator fun set(index: Int, value: Number) = when (index) {
        0 -> x = value.f
        1 -> y = value.f
        2 -> z = value.f
        else -> throw ArrayIndexOutOfBoundsException()
    }

    // -- Unary arithmetic operators --

    operator fun unaryPlus() = this

    operator fun unaryMinus() = Vec3(-x, -y, -z)

    // -- Increment main.and decrement operators --

    operator fun inc(res: Vec3 = Vec3()) = plus(res, this, 1f, 1f, 1f)
    fun incAssign() = plus(this, this, 1f, 1f, 1f)


    operator fun dec(res: Vec3 = Vec3()) = minus(res, this, 1f, 1f, 1f)
    fun decAssign() = minus(this, this, 1f, 1f, 1f)


    // -- Specific binary arithmetic operators --

    infix operator fun plus(b: Float) = plus(Vec3(), this, b, b, b)
    infix operator fun plus(b: Vec3) = plus(Vec3(), this, b.x, b.y, b.z)

    @JvmOverloads
    fun plus(bX: Float, bY: Float, bZ: Float, res: Vec3 = Vec3()) = plus(res, this, bX, bY, bZ)

    fun plus(b: Float, res: Vec3 = Vec3()) = plus(res, this, b, b, b)
    fun plus(b: Vec3, res: Vec3 = Vec3()) = plus(res, this, b.x, b.y, b.z)

    fun plusAssign(bX: Float, bY: Float, bZ: Float) = plus(this, this, bX, bY, bZ)
    infix operator fun plusAssign(b: Float) {
        plus(this, this, b, b, b)
    }

    infix operator fun plusAssign(b: Vec3) {
        plus(this, this, b.x, b.y, b.z)
    }


    infix operator fun minus(b: Float) = minus(Vec3(), this, b, b, b)
    infix operator fun minus(b: Vec3) = minus(Vec3(), this, b.x, b.y, b.z)

    @JvmOverloads
    fun minus(bX: Float, bY: Float, bZ: Float, res: Vec3 = Vec3()) = minus(res, this, bX, bY, bZ)

    fun minus(b: Float, res: Vec3 = Vec3()) = minus(res, this, b, b, b)
    fun minus(b: Vec3, res: Vec3 = Vec3()) = minus(res, this, b.x, b.y, b.z) // TODO overload others

    fun minusAssign(bX: Float, bY: Float, bZ: Float) = minus(this, this, bX, bY, bZ)
    infix operator fun minusAssign(b: Float) {
        minus(this, this, b, b, b)
    }

    infix operator fun minusAssign(b: Vec3) {
        minus(this, this, b.x, b.y, b.z)
    }


    infix operator fun times(b: Float) = times(Vec3(), this, b, b, b)
    infix operator fun times(b: Vec3) = times(Vec3(), this, b.x, b.y, b.z)

    @JvmOverloads
    fun times(bX: Float, bY: Float, bZ: Float, res: Vec3 = Vec3()) = times(res, this, bX, bY, bZ)

    fun times(b: Float, res: Vec3 = Vec3()) = times(res, this, b, b, b)
    fun times(b: Vec3, res: Vec3 = Vec3()) = times(res, this, b.x, b.y, b.z)

    fun timesAssign(bX: Float, bY: Float, bZ: Float) = times(this, this, bX, bY, bZ)
    infix operator fun timesAssign(b: Float) {
        times(this, this, b, b, b)
    }

    infix operator fun timesAssign(b: Vec3) {
        times(this, this, b.x, b.y, b.z)
    }


    operator fun div(b: Float) = div(Vec3(), this, b, b, b)
    operator fun div(b: Vec3) = div(Vec3(), this, b.x, b.y, b.z)

    @JvmOverloads
    fun div(bX: Float, bY: Float, bZ: Float, res: Vec3 = Vec3()) = div(res, this, bX, bY, bZ)

    fun div(b: Float, res: Vec3 = Vec3()) = div(res, this, b, b, b)
    fun div(b: Vec3, res: Vec3 = Vec3()) = div(res, this, b.x, b.y, b.z)

    fun divAssign(bX: Float, bY: Float, bZ: Float) = div(this, this, bX, bY, bZ)
    infix operator fun divAssign(b: Float) {
        div(this, this, b, b, b)
    }

    infix operator fun divAssign(b: Vec3) {
        div(this, this, b.x, b.y, b.z)
    }


    infix operator fun rem(b: Float) = rem(Vec3(), this, b, b, b)
    infix operator fun rem(b: Vec3) = rem(Vec3(), this, b.x, b.y, b.z)

    @JvmOverloads
    fun rem(bX: Float, bY: Float, bZ: Float, res: Vec3 = Vec3()) = rem(res, this, bX, bY, bZ)

    fun rem(b: Float, res: Vec3 = Vec3()) = rem(res, this, b, b, b)
    fun rem(b: Vec3, res: Vec3 = Vec3()) = rem(res, this, b.x, b.y, b.z)

    fun remAssign(bX: Float, bY: Float, bZ: Float) = rem(this, this, bX, bY, bZ)
    infix operator fun remAssign(b: Float) {
        rem(this, this, b, b, b)
    }

    infix operator fun remAssign(b: Vec3) {
        rem(this, this, b.x, b.y, b.z)
    }


    // -- Generic binary arithmetic operators --

    infix operator fun plus(b: Number) = plus(Vec3(), this, b.f, b.f, b.f)

    @JvmOverloads
    fun plus(bX: Number, bY: Number, bZ: Number, res: Vec3 = Vec3()) = plus(res, this, bX.f, bY.f, bZ.f)

    fun plus(b: Number, res: Vec3) = plus(res, this, b.f, b.f, b.f)
    fun plus(b: Vec3t<out Number>, res: Vec3 = Vec3()) = plus(res, this, b.x.f, b.y.f, b.z.f)

    fun plusAssign(bX: Number, bY: Number, bZ: Number) = plus(this, this, bX.f, bY.f, bZ.f)
    infix operator fun plusAssign(b: Number) {
        plus(this, this, b.f, b.f, b.f)
    }

    infix operator fun plusAssign(b: Vec3t<out Number>) {
        plus(this, this, b.x.f, b.y.f, b.z.f)
    }


    infix operator fun minus(b: Number) = minus(Vec3(), this, b.f, b.f, b.f)

    fun minus(bX: Number, bY: Number, bZ: Number, res: Vec3 = Vec3()) = minus(res, this, bX.f, bY.f, bZ.f)
    fun minus(b: Number, res: Vec3 = Vec3()) = minus(res, this, b.f, b.f, b.f)
    fun minus(b: Vec3t<out Number>, res: Vec3 = Vec3()) = minus(res, this, b.x.f, b.y.f, b.z.f)

    fun minusAssign(bX: Number, bY: Number, bZ: Number) = minus(this, this, bX.f, bY.f, bZ.f)
    infix operator fun minusAssign(b: Number) {
        minus(this, this, b.f, b.f, b.f)
    }

    infix operator fun minusAssign(b: Vec3t<out Number>) {
        minus(this, this, b.x.f, b.y.f, b.z.f)
    }


    infix operator fun times(b: Number) = times(Vec3(), this, b.f, b.f, b.f)
    infix operator fun times(b: Vec3t<out Number>) = times(Vec3(), this, b.x.f, b.y.f, b.z.f)

    fun times(bX: Number, bY: Number, bZ: Number, res: Vec3 = Vec3()) = times(res, this, bX.f, bY.f, bZ.f)
    fun times(b: Number, res: Vec3 = Vec3()) = times(res, this, b.f, b.f, b.f)
    fun times(b: Vec3t<out Number>, res: Vec3 = Vec3()) = times(res, this, b.x.f, b.y.f, b.z.f)

    fun timesAssign(bX: Number, bY: Number, bZ: Number) = times(this, this, bX.f, bY.f, bZ.f)
    infix operator fun timesAssign(b: Number) {
        times(this, this, b.f, b.f, b.f)
    }

    infix operator fun timesAssign(b: Vec3t<out Number>) {
        times(this, this, b.x.f, b.y.f, b.z.f)
    }


    infix operator fun div(b: Number) = div(Vec3(), this, b.f, b.f, b.f)
    infix operator fun div(b: Vec3t<out Number>) = div(Vec3(), this, b.x.f, b.y.f, b.z.f)

    fun div(bX: Number, bY: Number, bZ: Number, res: Vec3 = Vec3()) = div(res, this, bX.f, bY.f, bZ.f)
    fun div(b: Number, res: Vec3 = Vec3()) = div(res, this, b.f, b.f, b.f)
    fun div(b: Vec3t<out Number>, res: Vec3 = Vec3()) = div(res, this, b.x.f, b.y.f, b.z.f)

    fun divAssign(bX: Number, bY: Number, bZ: Number) = div(this, this, bX.f, bY.f, bZ.f)
    infix operator fun divAssign(b: Number) {
        div(this, this, b.f, b.f, b.f)
    }

    infix operator fun divAssign(b: Vec3t<out Number>) {
        div(this, this, b.x.f, b.y.f, b.z.f)
    }


    infix operator fun rem(b: Number) = rem(Vec3(), this, b.f, b.f, b.f)
    infix operator fun rem(b: Vec3t<out Number>) = rem(Vec3(), this, b.x.f, b.y.f, b.z.f)

    fun rem(bX: Number, bY: Number, bZ: Number, res: Vec3 = Vec3()) = rem(res, this, bX.f, bY.f, bZ.f)
    fun rem(b: Number, res: Vec3 = Vec3()) = rem(res, this, b.f, b.f, b.f)
    fun rem(b: Vec3t<out Number>, res: Vec3 = Vec3()) = rem(res, this, b.x.f, b.y.f, b.z.f)

    fun remAssign(bX: Number, bY: Number, bZ: Number) = rem(this, this, bX.f, bY.f, bZ.f)
    infix operator fun remAssign(b: Number) {
        rem(this, this, b.f, b.f, b.f)
    }

    infix operator fun remAssign(b: Vec3t<out Number>) {
        rem(this, this, b.x.f, b.y.f, b.z.f)
    }


    // -- functions --

    infix fun dot(b: Vec3) = glm.dot(this, b)   // TODO others
    infix fun dot(b: Vec3t<out Number>) = glm.dot(this, b)   // TODO others

    fun length() = glm.length(this)
    fun length2() = glm.length2(this)

    @JvmOverloads
    fun normalize(res: Vec3 = Vec3()) = glm.normalize(this, res) // TODO others

    fun normalizeAssign() = glm.normalize(this, this)

    infix fun cross(b: Vec3) = glm.cross(this, b, Vec3())
    infix fun crossAssign(b: Vec3) = glm.cross(this, b, this)

    @JvmOverloads
    fun negate(res: Vec3 = Vec3()): Vec3 {
        res.x = -x
        res.y = -y
        res.z = -z
        return res
    }

    fun negateAssign() = negate(this)


    infix fun allLessThan(f: Float) = x < f && y < f && z < f
    infix fun anyLessThan(f: Float) = x < f || y < f || z < f

    infix fun allLessThanEqual(f: Float) = x <= f && y <= f && z <= f
    infix fun anyLessThanEqual(f: Float) = x <= f || y <= f || z <= f

    infix fun allEqual(f: Float) = x == f && y == f && z == f
    infix fun anyEqual(f: Float) = x == f || y == f || z == f

    infix fun allNotEqual(f: Float) = x != f && y != f && z != f
    infix fun anyNotEqual(f: Float) = x != f || y != f || z != f

    infix fun allGreaterThan(f: Float) = x > f && y > f && z > f
    infix fun anyGreaterThan(f: Float) = x > f || y > f || z > f

    infix fun allGreaterThanEqual(f: Float) = x >= f && y >= f && z >= f
    infix fun anyGreaterThanEqual(f: Float) = x >= f || y >= f || z >= f


    override fun createInstance(x: Float, y: Float) = Vec2(x, y)
    override fun createInstance(x: Float, y: Float, z: Float) = Vec3(x, y, z)


    companion object : vec3_operators {
        const val length = Vec3t.length
        @JvmField
        val size = length * Float.BYTES

        fun fromColor(n: Number) = Vec3(n.f / 255, n.f / 255, n.f / 255f)
        fun fromColor(r: Number, g: Number, b: Number) = Vec3(r.f / 255, g.f / 255, b.f / 255f)
    }

    fun toColor(alpha: Float = 1f) = Color(r * 255, g * 255, b * 255, alpha * 255)

    override fun size() = size

    override fun equals(other: Any?) = other is Vec3 && this[0] == other[0] && this[1] == other[1] && this[2] == other[2]
    override fun hashCode() = 31 * (31 * x.hashCode() + y.hashCode()) + z.hashCode()
}