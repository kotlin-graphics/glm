package glm_.vec3

import glm_.*
import glm_.vec1.Vec1bool
import glm_.vec1.Vec1t
import glm_.vec2.Vec2bool
import glm_.vec2.Vec2t
import glm_.vec2.Vec2us
import glm_.vec3.operators.vec3us_operators
import glm_.vec4.Vec4bool
import glm_.vec4.Vec4t
import kool.*
import org.lwjgl.system.MemoryStack
import unsigned.Ushort
import unsigned.UshortArray
import unsigned.toUshort
import java.io.PrintStream
import java.nio.*

/**
 * Created by elect on 09/10/16.
 */

class Vec3us(@JvmField var ofs: Int, var array: UshortArray) : Vec3t<Ushort>, ToBuffer {

    inline var x: Ushort
        get() = array[ofs]
        set(value) = array.set(ofs, value)
    inline var y: Ushort
        get() = array[ofs + 1]
        set(value) = array.set(ofs + 1, value)
    inline var z: Ushort
        get() = array[ofs + 2]
        set(value) = array.set(ofs + 2, value)

    inline var vX: Short
        get() = array[ofs].toShort()
        set(value) = array.set(ofs, value.toUshort())
    inline var vY: Short
        get() = array[ofs + 1].toShort()
        set(value) = array.set(ofs + 1, value.toUshort())
    inline var vZ: Short
        get() = array[ofs + 2].toShort()
        set(value) = array.set(ofs + 2, value.toUshort())

    // -- Implicit basic constructors --

    constructor() : this(0, 0, 0)
    constructor(v: Vec3us) : this(v.x, v.y, v.z)
    constructor(v: Vec2us) : this(v.x, v.y, Ushort(0))

    // -- Explicit basic constructors --

    @JvmOverloads
    constructor(x: Ushort, y: Ushort = x, z: Ushort = x) : this(0, UshortArray(shortArrayOf(x.v, y.v, z.v)))

    @JvmOverloads
    constructor(x: Int, y: Int = x, z: Int = x) : this(0, UshortArray(shortArrayOf(x.s, y.s, z.s)))

    // -- Conversion scalar constructors --

    constructor(v: Vec1t<out Number>) : this(v._x)

    // Explicit conversions (From section 5.4.1 Conversion and scalar constructors of GLSL 1.30.08 specification)

    constructor(v: Number) : this(v.us)
    constructor(x: Number, y: Number, z: Number) : this(x.us, y.us, z.us)

    constructor(x: Vec1t<out Number>, y: Number, z: Number) : this(x._x, y, z)
    constructor(x: Number, y: Vec1t<out Number>, z: Number) : this(x, y._x, z)
    constructor(x: Vec1t<out Number>, y: Vec1t<out Number>, z: Number) : this(x._x, y._x, z)
    constructor(x: Number, y: Number, z: Vec1t<out Number>) : this(x, y, z._x)
    constructor(x: Vec1t<out Number>, y: Number, z: Vec1t<out Number>) : this(x._x, y, z._x)
    constructor(x: Number, y: Vec1t<out Number>, z: Vec1t<out Number>) : this(x, y._x, z._x)
    constructor(x: Vec1t<out Number>, y: Vec1t<out Number>, z: Vec1t<out Number>) : this(x._x, y._x, z._x)

    // -- Conversion vector constructors --

    // Explicit conversions (From section 5.4.1 Conversion and scalar constructors of GLSL 1.30.08 specification)

    @JvmOverloads
    constructor(xy: Vec2t<out Number>, z: Number = 0) : this(xy._x, xy._y, z)

    constructor(xy: Vec2t<out Number>, z: Vec1t<out Number>) : this(xy._x, xy._y, z._x)
    constructor(x: Number, yz: Vec2t<out Number>) : this(x, yz._x, yz._y)
    constructor(x: Vec1t<out Number>, yz: Vec2t<out Number>) : this(x._x, yz._x, yz._y)
    constructor(v: Vec3t<out Number>) : this(v._x, v._y, v._z)
    constructor(v: Vec4t<out Number>) : this(v._x, v._y, v._z)

    constructor(v: Vec1bool) : this(v.x.ub, 0, 0)
    constructor(v: Vec2bool) : this(v.x.us, v.y.us, 0)
    constructor(v: Vec3bool) : this(v.x.us, v.y.us, v.z.us)
    constructor(v: Vec4bool) : this(v.x.us, v.y.us, v.z.us)

    constructor(bytes: ByteArray, index: Int = 0, oneByteOneUshort: Boolean = false, bigEndian: Boolean = true) : this(
            if (oneByteOneUshort) bytes[index].us else bytes.getUshort(index, bigEndian),
            if (oneByteOneUshort) bytes[index + 1].us else bytes.getUshort(index + Ushort.BYTES, bigEndian),
            if (oneByteOneUshort) bytes[index + 2].us else bytes.getUshort(index + Ushort.BYTES * 2, bigEndian))

    constructor(chars: CharArray, index: Int = 0) : this(chars[index].us, chars[index + 1].us, chars[index + 2].us)
    constructor(shorts: ShortArray, index: Int = 0) : this(shorts[index], shorts[index + 1], shorts[index + 2])
    constructor(ints: IntArray, index: Int = 0) : this(ints[index], ints[index + 1], ints[index + 2])
    constructor(longs: LongArray, index: Int = 0) : this(longs[index], longs[index + 1], longs[index + 2])
    constructor(floats: FloatArray, index: Int = 0) : this(floats[index], floats[index + 1], floats[index + 2])
    constructor(doubles: DoubleArray, index: Int = 0) : this(doubles[index], doubles[index + 1], doubles[index + 2])
    constructor(booleans: BooleanArray, index: Int = 0) : this(booleans[index].us, booleans[index + 1].us, booleans[index + 2].us)

    constructor(numbers: Array<out Number>, index: Int = 0) : this(numbers[index], numbers[index + 1], numbers[index + 2])
    constructor(chars: Array<Char>, index: Int = 0) : this(chars[index].us, chars[index + 1].us, chars[index + 2].us)
    constructor(booleans: Array<Boolean>, index: Int = 0) : this(booleans[index].us, booleans[index + 1].us, booleans[index + 2].us)

    constructor(list: Iterable<*>, index: Int = 0) : this(list.elementAt(index)!!.toShort, list.elementAt(index + 1)!!.toShort,
            list.elementAt(index + 2)!!.toShort)

    constructor(bytes: ByteBuffer, index: Int = bytes.pos, oneByteOneUshort: Boolean = false) : this(
            if (oneByteOneUshort) bytes[index].us else bytes.getShort(index).us,
            if (oneByteOneUshort) bytes[index + 1].us else bytes.getShort(index + Ushort.BYTES).us,
            if (oneByteOneUshort) bytes[index + 2].us else bytes.getShort(index + Ushort.BYTES * 2).us)

    constructor(chars: CharBuffer, index: Int = chars.pos) : this(chars[index].us, chars[index + 1].us, chars[index + 2].us)
    constructor(shorts: ShortBuffer, index: Int = shorts.pos) : this(shorts[index], shorts[index + 1], shorts[index + 2])
    constructor(ints: IntBuffer, index: Int = ints.pos) : this(ints[index], ints[index + 1], ints[index + 2])
    constructor(longs: LongBuffer, index: Int = longs.pos) : this(longs[index], longs[index + 1], longs[index + 2])
    constructor(floats: FloatBuffer, index: Int = floats.pos) : this(floats[index], floats[index + 1], floats[index + 2])
    constructor(doubles: DoubleBuffer, index: Int = doubles.pos) : this(doubles[index], doubles[index + 1], doubles[index + 2])

    constructor(block: (Int) -> Ushort) : this(block(0), block(1), block(2))
    constructor(ptr: Ptr<Ushort>) : this() {
        val p = ptr.toPtr<Short>()
        x.v = p[0]
        y.v = p[1]
        z.v = p[2]
    }


    fun set(bytes: ByteArray, index: Int = 0, oneByteOneShort: Boolean = false, bigEndian: Boolean = true) {
        x.v = if (oneByteOneShort) bytes[index].s else bytes.getShort(index, bigEndian)
        y.v = if (oneByteOneShort) bytes[index + 1].s else bytes.getShort(index + Ushort.BYTES, bigEndian)
        z.v = if (oneByteOneShort) bytes[index + 2].s else bytes.getShort(index + Ushort.BYTES * 2, bigEndian)
    }

    fun set(bytes: ByteBuffer, index: Int = bytes.pos, oneByteOneShort: Boolean = false) {
        x.v = if (oneByteOneShort) bytes[index].s else bytes.getShort(index)
        y.v = if (oneByteOneShort) bytes[index + 1].s else bytes.getShort(index + Ushort.BYTES)
        z.v = if (oneByteOneShort) bytes[index + 2].s else bytes.getShort(index + Ushort.BYTES * 2)
    }


    fun put(x: Ushort, y: Ushort, z: Ushort) {
        this.x = x
        this.y = y
        this.z = z
    }

    operator fun invoke(x: Ushort, y: Ushort, z: Ushort): Vec3us {
        this.x = x
        this.y = y
        this.z = z
        return this
    }

    fun put(x: Short, y: Short, z: Short) {
        this.x.v = x
        this.y.v = y
        this.z.v = z
    }

    operator fun invoke(x: Short, y: Short, z: Short): Vec3us {
        this.x.v = x
        this.y.v = y
        this.z.v = z
        return this
    }

    override fun put(x: Number, y: Number, z: Number) {
        this.x = x.us
        this.y = y.us
        this.z = z.us
    }

    override operator fun invoke(x: Number, y: Number, z: Number): Vec3us {
        this.x = x.us
        this.y = y.us
        this.z = z.us
        return this
    }

    fun to(bytes: ByteArray, index: Int): ByteArray = to(bytes, index, true)
    override fun to(bytes: ByteArray, index: Int, bigEndian: Boolean): ByteArray {
        bytes.putShort(index, x.v, bigEndian)
        bytes.putShort(index + Short.BYTES, y.v, bigEndian)
        bytes.putShort(index + Short.BYTES * 2, z.v, bigEndian)
        return bytes
    }

    fun toShortArray(): ShortArray = to(ShortArray(length), 0)
    infix fun to(shorts: ShortArray): ShortArray = to(shorts, 0)
    fun to(shorts: ShortArray, index: Int): ShortArray {
        System.arraycopy(array, ofs, shorts, index, length)
        return shorts
    }

    override fun to(buf: ByteBuffer, offset: Int): ByteBuffer {
        buf.putShort(offset, x.v)
        buf.putShort(offset + Short.BYTES, y.v)
        buf.putShort(offset + Short.BYTES * 2, z.v)
        return buf
    }

    fun toShortBufferStack(): ShortBuffer = to(MemoryStack.stackGet().mallocShort(length), 0)
    infix fun toShortBuffer(stack: MemoryStack): ShortBuffer = to(stack.mallocShort(length), 0)
    fun toShortBuffer(): ShortBuffer = to(ShortBuffer(length), 0)
    infix fun to(buf: ShortBuffer): ShortBuffer = to(buf, buf.pos)
    fun to(buf: ShortBuffer, index: Int): ShortBuffer {
        buf[index] = x.v
        buf[index + 1] = y.v
        buf[index + 2] = z.v
        return buf
    }

    infix fun to(ptr: Ptr<Ushort>) {
        val p = ptr.toPtr<Short>()
        p[0] = x.v
        p[1] = y.v
        p[2] = z.v
    }

    // -- Component accesses --

    override operator fun set(index: Int, value: Number) = when (index) {
        0 -> x = value.us
        1 -> y = value.us
        2 -> z = value.us
        else -> throw ArrayIndexOutOfBoundsException()
    }


    // -- Unary arithmetic operators --

    operator fun unaryPlus() = this

    // no unaryMinus operator, only signed

    // -- Increment main.and decrement operators --

    operator fun inc(res: Vec3us = Vec3us()) = plus(res, this, 1, 1, 1)
    fun incAssign() = plus(this, this, 1, 1, 1)


    operator fun dec(res: Vec3us = Vec3us()) = minus(res, this, 1, 1, 1)
    fun decAssign() = minus(this, this, 1, 1, 1)


    // -- Specific binary arithmetic operators --

    operator fun plus(b: Ushort) = plus(Vec3us(), this, b, b, b)
    operator fun plus(b: Short) = plus(Vec3us(), this, b, b, b)
    operator fun plus(b: Int) = plus(Vec3us(), this, b, b, b)
    operator fun plus(b: Vec3us) = plus(Vec3us(), this, b.x, b.y, b.z)

    fun plus(bX: Ushort, bY: Ushort, bZ: Ushort, res: Vec3us = Vec3us()) = plus(res, this, bX, bY, bZ)
    fun plus(bX: Short, bY: Short, bZ: Short, res: Vec3us = Vec3us()) = plus(res, this, bX, bY, bZ)
    fun plus(bX: Int, bY: Int, bZ: Int, res: Vec3us = Vec3us()) = plus(res, this, bX, bY, bZ)
    fun plus(b: Ushort, res: Vec3us = Vec3us()) = plus(res, this, b, b, b)
    fun plus(b: Short, res: Vec3us = Vec3us()) = plus(res, this, b, b, b)
    fun plus(b: Int, res: Vec3us = Vec3us()) = plus(res, this, b, b, b)
    fun plus(b: Vec3us, res: Vec3us = Vec3us()) = plus(res, this, b.x, b.y, b.z)

    fun plusAssign(bX: Ushort, bY: Ushort, bZ: Ushort) = plus(this, this, bX, bY, bZ)
    fun plusAssign(bX: Short, bY: Short, bZ: Short) = plus(this, this, bX, bY, bZ)
    fun plusAssign(bX: Int, bY: Int, bZ: Int) = plus(this, this, bX, bY, bZ)
    infix operator fun plusAssign(b: Ushort) {
        plus(this, this, b, b, b)
    }

    infix operator fun plusAssign(b: Short) {
        plus(this, this, b, b, b)
    }

    infix operator fun plusAssign(b: Int) {
        plus(this, this, b, b, b)
    }

    infix operator fun plusAssign(b: Vec3us) {
        plus(this, this, b.x, b.y, b.z)
    }


    operator fun minus(b: Ushort) = minus(Vec3us(), this, b, b, b)
    operator fun minus(b: Short) = minus(Vec3us(), this, b, b, b)
    operator fun minus(b: Int) = minus(Vec3us(), this, b, b, b)
    operator fun minus(b: Vec3us) = minus(Vec3us(), this, b.x, b.y, b.z)

    fun minus(bX: Ushort, bY: Ushort, bZ: Ushort, res: Vec3us = Vec3us()) = minus(res, this, bX, bY, bZ)
    fun minus(bX: Short, bY: Short, bZ: Short, res: Vec3us = Vec3us()) = minus(res, this, bX, bY, bZ)
    fun minus(bX: Int, bY: Int, bZ: Int, res: Vec3us = Vec3us()) = minus(res, this, bX, bY, bZ)
    fun minus(b: Ushort, res: Vec3us = Vec3us()) = minus(res, this, b, b, b)
    fun minus(b: Short, res: Vec3us = Vec3us()) = minus(res, this, b, b, b)
    fun minus(b: Int, res: Vec3us = Vec3us()) = minus(res, this, b, b, b)
    fun minus(b: Vec3us, res: Vec3us = Vec3us()) = minus(res, this, b.x, b.y, b.z)

    fun minusAssign(bX: Ushort, bY: Ushort, bZ: Ushort) = minus(this, this, bX, bY, bZ)
    fun minusAssign(bX: Short, bY: Short, bZ: Short) = minus(this, this, bX, bY, bZ)
    fun minusAssign(bX: Int, bY: Int, bZ: Int) = minus(this, this, bX, bY, bZ)
    infix operator fun minusAssign(b: Ushort) {
        minus(this, this, b, b, b)
    }

    infix operator fun minusAssign(b: Short) {
        minus(this, this, b, b, b)
    }

    infix operator fun minusAssign(b: Int) {
        minus(this, this, b, b, b)
    }

    infix operator fun minusAssign(b: Vec3us) {
        minus(this, this, b.x, b.y, b.z)
    }


    operator fun times(b: Ushort) = times(Vec3us(), this, b, b, b)
    operator fun times(b: Short) = times(Vec3us(), this, b, b, b)
    operator fun times(b: Int) = times(Vec3us(), this, b, b, b)
    operator fun times(b: Vec3us) = times(Vec3us(), this, b.x, b.y, b.z)

    fun times(bX: Ushort, bY: Ushort, bZ: Ushort, res: Vec3us = Vec3us()) = times(res, this, bX, bY, bZ)
    fun times(bX: Short, bY: Short, bZ: Short, res: Vec3us = Vec3us()) = times(res, this, bX, bY, bZ)
    fun times(bX: Int, bY: Int, bZ: Int, res: Vec3us = Vec3us()) = times(res, this, bX, bY, bZ)
    fun times(b: Ushort, res: Vec3us = Vec3us()) = times(res, this, b, b, b)
    fun times(b: Short, res: Vec3us = Vec3us()) = times(res, this, b, b, b)
    fun times(b: Int, res: Vec3us = Vec3us()) = times(res, this, b, b, b)
    fun times(b: Vec3us, res: Vec3us = Vec3us()) = times(res, this, b.x, b.y, b.z)

    fun timesAssign(bX: Ushort, bY: Ushort, bZ: Ushort) = times(this, this, bX, bY, bZ)
    fun timesAssign(bX: Short, bY: Short, bZ: Short) = times(this, this, bX, bY, bZ)
    fun timesAssign(bX: Int, bY: Int, bZ: Int) = times(this, this, bX, bY, bZ)
    infix operator fun timesAssign(b: Ushort) {
        times(this, this, b, b, b)
    }

    infix operator fun timesAssign(b: Short) {
        times(this, this, b, b, b)
    }

    infix operator fun timesAssign(b: Int) {
        times(this, this, b, b, b)
    }

    infix operator fun timesAssign(b: Vec3us) {
        times(this, this, b.x, b.y, b.z)
    }


    operator fun div(b: Ushort) = div(Vec3us(), this, b, b, b)
    operator fun div(b: Short) = div(Vec3us(), this, b, b, b)
    operator fun div(b: Int) = div(Vec3us(), this, b, b, b)
    operator fun div(b: Vec3us) = div(Vec3us(), this, b.x, b.y, b.z)

    fun div(bX: Ushort, bY: Ushort, bZ: Ushort, res: Vec3us = Vec3us()) = div(res, this, bX, bY, bZ)
    fun div(bX: Short, bY: Short, bZ: Short, res: Vec3us = Vec3us()) = div(res, this, bX, bY, bZ)
    fun div(bX: Int, bY: Int, bZ: Int, res: Vec3us = Vec3us()) = div(res, this, bX, bY, bZ)
    fun div(b: Ushort, res: Vec3us = Vec3us()) = div(res, this, b, b, b)
    fun div(b: Short, res: Vec3us = Vec3us()) = div(res, this, b, b, b)
    fun div(b: Int, res: Vec3us = Vec3us()) = div(res, this, b, b, b)
    fun div(b: Vec3us, res: Vec3us = Vec3us()) = div(res, this, b.x, b.y, b.z)

    fun divAssign(bX: Ushort, bY: Ushort, bZ: Ushort) = div(this, this, bX, bY, bZ)
    fun divAssign(bX: Short, bY: Short, bZ: Short) = div(this, this, bX, bY, bZ)
    fun divAssign(bX: Int, bY: Int, bZ: Int) = div(this, this, bX, bY, bZ)
    infix operator fun divAssign(b: Ushort) {
        div(this, this, b, b, b)
    }

    infix operator fun divAssign(b: Short) {
        div(this, this, b, b, b)
    }

    infix operator fun divAssign(b: Int) {
        div(this, this, b, b, b)
    }

    infix operator fun divAssign(b: Vec3us) {
        div(this, this, b.x, b.y, b.z)
    }


    operator fun rem(b: Ushort) = rem(Vec3us(), this, b, b, b)
    operator fun rem(b: Short) = rem(Vec3us(), this, b, b, b)
    operator fun rem(b: Int) = rem(Vec3us(), this, b, b, b)
    operator fun rem(b: Vec3us) = rem(Vec3us(), this, b.x, b.y, b.z)

    fun rem(bX: Ushort, bY: Ushort, bZ: Ushort, res: Vec3us = Vec3us()) = rem(res, this, bX, bY, bZ)
    fun rem(bX: Short, bY: Short, bZ: Short, res: Vec3us = Vec3us()) = rem(res, this, bX, bY, bZ)
    fun rem(bX: Int, bY: Int, bZ: Int, res: Vec3us = Vec3us()) = rem(res, this, bX, bY, bZ)
    fun rem(b: Ushort, res: Vec3us = Vec3us()) = rem(res, this, b, b, b)
    fun rem(b: Short, res: Vec3us = Vec3us()) = rem(res, this, b, b, b)
    fun rem(b: Int, res: Vec3us = Vec3us()) = rem(res, this, b, b, b)
    fun rem(b: Vec3us, res: Vec3us = Vec3us()) = rem(res, this, b.x, b.y, b.z)

    fun remAssign(bX: Ushort, bY: Ushort, bZ: Ushort) = rem(this, this, bX, bY, bZ)
    fun remAssign(bX: Short, bY: Short, bZ: Short) = rem(this, this, bX, bY, bZ)
    fun remAssign(bX: Int, bY: Int, bZ: Int) = rem(this, this, bX, bY, bZ)
    infix operator fun remAssign(b: Ushort) {
        rem(this, this, b, b, b)
    }

    infix operator fun remAssign(b: Short) {
        rem(this, this, b, b, b)
    }

    infix operator fun remAssign(b: Int) {
        rem(this, this, b, b, b)
    }

    infix operator fun remAssign(b: Vec3us) {
        rem(this, this, b.x, b.y, b.z)
    }


    // -- Generic binary arithmetic operators --

    operator fun plus(b: Number) = plus(Vec3us(), this, b.i, b.i, b.i)
    operator fun plus(b: Vec3t<out Number>) = plus(Vec3us(), this, b._x.i, b._y.i, b._z.i)

    fun plus(bX: Number, bY: Number, bZ: Number, res: Vec3us = Vec3us()) = plus(res, this, bX.i, bY.i, bZ.i)
    fun plus(b: Number, res: Vec3us = Vec3us()) = plus(res, this, b.i, b.i, b.i)
    fun plus(b: Vec3t<out Number>, res: Vec3us = Vec3us()) = plus(res, this, b._x.i, b._y.i, b._z.i)

    fun plusAssign(bX: Number, bY: Number, bZ: Number) = plus(this, this, bX.i, bY.i, bZ.i)
    infix operator fun plusAssign(b: Number) {
        plus(this, this, b.i, b.i, b.i)
    }

    infix operator fun plusAssign(b: Vec3t<out Number>) {
        plus(this, this, b._x.i, b._y.i, b._z.i)
    }


    operator fun minus(b: Number) = minus(Vec3us(), this, b.i, b.i, b.i)
    operator fun minus(b: Vec3t<out Number>) = minus(Vec3us(), this, b._x.i, b._y.i, b._z.i)

    fun minus(bX: Number, bY: Number, bZ: Number, res: Vec3us = Vec3us()) = minus(res, this, bX.i, bY.i, bZ.i)
    fun minus(b: Number, res: Vec3us = Vec3us()) = minus(res, this, b.i, b.i, b.i)
    fun minus(b: Vec3t<out Number>, res: Vec3us = Vec3us()) = minus(res, this, b._x.i, b._y.i, b._z.i)

    fun minusAssign(bX: Number, bY: Number, bZ: Number) = minus(this, this, bX.i, bY.i, bZ.i)
    infix operator fun minusAssign(b: Number) {
        minus(this, this, b.i, b.i, b.i)
    }

    infix operator fun minusAssign(b: Vec3t<out Number>) {
        minus(this, this, b._x.i, b._y.i, b._z.i)
    }


    operator fun times(b: Number) = times(Vec3us(), this, b.i, b.i, b.i)
    operator fun times(b: Vec3t<out Number>) = times(Vec3us(), this, b._x.i, b._y.i, b._z.i)

    fun times(bX: Number, bY: Number, bZ: Number, res: Vec3us = Vec3us()) = times(res, this, bX.i, bY.i, bZ.i)
    fun times(b: Number, res: Vec3us = Vec3us()) = times(res, this, b.i, b.i, b.i)
    fun times(b: Vec3t<out Number>, res: Vec3us = Vec3us()) = times(res, this, b._x.i, b._y.i, b._z.i)

    fun timesAssign(bX: Number, bY: Number, bZ: Number) = times(this, this, bX.i, bY.i, bZ.i)
    infix operator fun timesAssign(b: Number) {
        times(this, this, b.i, b.i, b.i)
    }

    infix operator fun timesAssign(b: Vec3t<out Number>) {
        times(this, this, b._x.i, b._y.i, b._z.i)
    }


    operator fun div(b: Number) = div(Vec3us(), this, b.i, b.i, b.i)
    operator fun div(b: Vec3t<out Number>) = div(Vec3us(), this, b._x.i, b._y.i, b._z.i)

    fun div(bX: Number, bY: Number, bZ: Number, res: Vec3us = Vec3us()) = div(res, this, bX.i, bY.i, bZ.i)
    fun div(b: Number, res: Vec3us = Vec3us()) = div(res, this, b.i, b.i, b.i)
    fun div(b: Vec3t<out Number>, res: Vec3us = Vec3us()) = div(res, this, b._x.i, b._y.i, b._z.i)

    fun divAssign(bX: Number, bY: Number, bZ: Number) = div(this, this, bX.i, bY.i, bZ.i)
    infix operator fun divAssign(b: Number) {
        div(this, this, b.i, b.i, b.i)
    }

    infix operator fun divAssign(b: Vec3t<out Number>) {
        div(this, this, b._x.i, b._y.i, b._z.i)
    }


    operator fun rem(b: Number) = rem(Vec3us(), this, b.i, b.i, b.i)
    operator fun rem(b: Vec3t<out Number>) = rem(Vec3us(), this, b._x.i, b._y.i, b._z.i)

    fun rem(bX: Number, bY: Number, bZ: Number, res: Vec3us = Vec3us()) = rem(res, this, bX.i, bY.i, bZ.i)
    fun rem(b: Number, res: Vec3us = Vec3us()) = rem(res, this, b.i, b.i, b.i)
    fun rem(b: Vec3t<out Number>, res: Vec3us = Vec3us()) = rem(res, this, b._x.i, b._y.i, b._z.i)

    fun remAssign(bX: Number, bY: Number, bZ: Number) = rem(this, this, bX.i, bY.i, bZ.i)
    infix operator fun remAssign(b: Number) {
        rem(this, this, b.i, b.i, b.i)
    }

    infix operator fun remAssign(b: Vec3t<out Number>) {
        rem(this, this, b._x.i, b._y.i, b._z.i)
    }


    // -- Specific bitwise operators --

    infix fun and(b: Ushort) = and(Vec3us(), this, b, b, b)
    infix fun and(b: Short) = and(Vec3us(), this, b, b, b)
    infix fun and(b: Int) = and(Vec3us(), this, b, b, b)
    fun and(bX: Ushort, bY: Ushort, bZ: Ushort) = and(Vec3us(), this, bX, bY, bZ)
    fun and(bX: Short, bY: Short, bZ: Short) = and(Vec3us(), this, bX, bY, bZ)
    fun and(bX: Int, bY: Int, bZ: Int) = and(Vec3us(), this, bX, bY, bZ)
    fun and(b: Vec3us) = and(Vec3us(), this, b.x, b.y, b.z)

    infix fun andAssign(b: Ushort) = and(this, this, b, b, b)
    infix fun andAssign(b: Short) = and(this, this, b, b, b)
    infix fun andAssign(b: Int) = and(this, this, b, b, b)
    fun andAssign(bX: Ushort, bY: Ushort, bZ: Ushort) = and(this, this, bX, bY, bZ)
    fun andAssign(bX: Short, bY: Short, bZ: Short) = and(this, this, bX, bY, bZ)
    fun andAssign(bX: Int, bY: Int, bZ: Int) = and(this, this, bX, bY, bZ)
    infix fun andAssign(b: Vec3us) = and(this, this, b.x, b.y, b.z)

    fun and(b: Ushort, res: Vec3us) = and(res, this, b, b, b)
    fun and(b: Short, res: Vec3us) = and(res, this, b, b, b)
    fun and(b: Int, res: Vec3us) = and(res, this, b, b, b)
    fun and(bX: Ushort, bY: Ushort, bZ: Ushort, res: Vec3us) = and(res, this, bX, bY, bZ)
    fun and(bX: Short, bY: Short, bZ: Short, res: Vec3us) = and(res, this, bX, bY, bZ)
    fun and(bX: Int, bY: Int, bZ: Int, res: Vec3us) = and(res, this, bX, bY, bZ)
    fun and(b: Vec3us, res: Vec3us) = and(res, this, b.x, b.y, b.z)


    infix fun or(b: Ushort) = or(Vec3us(), this, b, b, b)
    infix fun or(b: Short) = or(Vec3us(), this, b, b, b)
    infix fun or(b: Int) = or(Vec3us(), this, b, b, b)
    fun or(bX: Ushort, bY: Ushort, bZ: Ushort) = or(Vec3us(), this, bX, bY, bZ)
    fun or(bX: Short, bY: Short, bZ: Short) = or(Vec3us(), this, bX, bY, bZ)
    fun or(bX: Int, bY: Int, bZ: Int) = or(Vec3us(), this, bX, bY, bZ)
    fun or(b: Vec3us) = or(Vec3us(), this, b.x, b.y, b.z)

    infix fun orAssign(b: Ushort) = or(this, this, b, b, b)
    infix fun orAssign(b: Short) = or(this, this, b, b, b)
    infix fun orAssign(b: Int) = or(this, this, b, b, b)
    fun orAssign(bX: Ushort, bY: Ushort, bZ: Ushort) = or(this, this, bX, bY, bZ)
    fun orAssign(bX: Short, bY: Short, bZ: Short) = or(this, this, bX, bY, bZ)
    fun orAssign(bX: Int, bY: Int, bZ: Int) = or(this, this, bX, bY, bZ)
    infix fun orAssign(b: Vec3us) = or(this, this, b.x, b.y, b.z)

    fun or(b: Ushort, res: Vec3us) = or(res, this, b, b, b)
    fun or(b: Short, res: Vec3us) = or(res, this, b, b, b)
    fun or(b: Int, res: Vec3us) = or(res, this, b, b, b)
    fun or(bX: Ushort, bY: Ushort, bZ: Ushort, res: Vec3us) = or(res, this, bX, bY, bZ)
    fun or(bX: Short, bY: Short, bZ: Short, res: Vec3us) = or(res, this, bX, bY, bZ)
    fun or(bX: Int, bY: Int, bZ: Int, res: Vec3us) = or(res, this, bX, bY, bZ)
    fun or(b: Vec3us, res: Vec3us) = or(res, this, b.x, b.y, b.z)


    infix fun xor(b: Ushort) = xor(Vec3us(), this, b, b, b)
    infix fun xor(b: Short) = xor(Vec3us(), this, b, b, b)
    infix fun xor(b: Int) = xor(Vec3us(), this, b, b, b)
    fun xor(bX: Ushort, bY: Ushort, bZ: Ushort) = xor(Vec3us(), this, bX, bY, bZ)
    fun xor(bX: Short, bY: Short, bZ: Short) = xor(Vec3us(), this, bX, bY, bZ)
    fun xor(bX: Int, bY: Int, bZ: Int) = xor(Vec3us(), this, bX, bY, bZ)
    fun xor(b: Vec3us) = xor(Vec3us(), this, b.x, b.y, b.z)

    infix fun xorAssign(b: Ushort) = xor(this, this, b, b, b)
    infix fun xorAssign(b: Short) = xor(this, this, b, b, b)
    infix fun xorAssign(b: Int) = xor(this, this, b, b, b)
    fun xorAssign(bX: Ushort, bY: Ushort, bZ: Ushort) = xor(this, this, bX, bY, bZ)
    fun xorAssign(bX: Short, bY: Short, bZ: Short) = xor(this, this, bX, bY, bZ)
    fun xorAssign(bX: Int, bY: Int, bZ: Int) = xor(this, this, bX, bY, bZ)
    infix fun xorAssign(b: Vec3us) = xor(this, this, b.x, b.y, b.z)

    fun xor(b: Ushort, res: Vec3us) = xor(res, this, b, b, b)
    fun xor(b: Short, res: Vec3us) = xor(res, this, b, b, b)
    fun xor(b: Int, res: Vec3us) = xor(res, this, b, b, b)
    fun xor(bX: Ushort, bY: Ushort, bZ: Ushort, res: Vec3us) = xor(res, this, bX, bY, bZ)
    fun xor(bX: Short, bY: Short, bZ: Short, res: Vec3us) = xor(res, this, bX, bY, bZ)
    fun xor(bX: Int, bY: Int, bZ: Int, res: Vec3us) = xor(res, this, bX, bY, bZ)
    fun xor(b: Vec3us, res: Vec3us) = xor(res, this, b.x, b.y, b.z)


    infix fun shl(b: Ushort) = shl(Vec3us(), this, b, b, b)
    infix fun shl(b: Short) = shl(Vec3us(), this, b, b, b)
    infix fun shl(b: Int) = shl(Vec3us(), this, b, b, b)
    fun shl(bX: Ushort, bY: Ushort, bZ: Ushort) = shl(Vec3us(), this, bX, bY, bZ)
    fun shl(bX: Short, bY: Short, bZ: Short) = shl(Vec3us(), this, bX, bY, bZ)
    fun shl(bX: Int, bY: Int, bZ: Int) = shl(Vec3us(), this, bX, bY, bZ)
    fun shl(b: Vec3us) = shl(Vec3us(), this, b.x, b.y, b.z)

    infix fun shlAssign(b: Ushort) = shl(this, this, b, b, b)
    infix fun shlAssign(b: Short) = shl(this, this, b, b, b)
    infix fun shlAssign(b: Int) = shl(this, this, b, b, b)
    fun shlAssign(bX: Ushort, bY: Ushort, bZ: Ushort) = shl(this, this, bX, bY, bZ)
    fun shlAssign(bX: Short, bY: Short, bZ: Short) = shl(this, this, bX, bY, bZ)
    fun shlAssign(bX: Int, bY: Int, bZ: Int) = shl(this, this, bX, bY, bZ)
    infix fun shlAssign(b: Vec3us) = shl(this, this, b.x, b.y, b.z)

    fun shl(b: Ushort, res: Vec3us) = shl(res, this, b, b, b)
    fun shl(b: Short, res: Vec3us) = shl(res, this, b, b, b)
    fun shl(b: Int, res: Vec3us) = shl(res, this, b, b, b)
    fun shl(bX: Ushort, bY: Ushort, bZ: Ushort, res: Vec3us) = shl(res, this, bX, bY, bZ)
    fun shl(bX: Short, bY: Short, bZ: Short, res: Vec3us) = shl(res, this, bX, bY, bZ)
    fun shl(bX: Int, bY: Int, bZ: Int, res: Vec3us) = shl(res, this, bX, bY, bZ)
    fun shl(b: Vec3us, res: Vec3us) = shl(res, this, b.x, b.y, b.z)


    infix fun shr(b: Ushort) = shr(Vec3us(), this, b, b, b)
    infix fun shr(b: Short) = shr(Vec3us(), this, b, b, b)
    infix fun shr(b: Int) = shr(Vec3us(), this, b, b, b)
    fun shr(bX: Ushort, bY: Ushort, bZ: Ushort) = shr(Vec3us(), this, bX, bY, bZ)
    fun shr(bX: Short, bY: Short, bZ: Short) = shr(Vec3us(), this, bX, bY, bZ)
    fun shr(bX: Int, bY: Int, bZ: Int) = shr(Vec3us(), this, bX, bY, bZ)
    fun shr(b: Vec3us) = shr(Vec3us(), this, b.x, b.y, b.z)

    infix fun shrAssign(b: Ushort) = shr(this, this, b, b, b)
    infix fun shrAssign(b: Short) = shr(this, this, b, b, b)
    infix fun shrAssign(b: Int) = shr(this, this, b, b, b)
    fun shrAssign(bX: Ushort, bY: Ushort, bZ: Ushort) = shr(this, this, bX, bY, bZ)
    fun shrAssign(bX: Short, bY: Short, bZ: Short) = shr(this, this, bX, bY, bZ)
    fun shrAssign(bX: Int, bY: Int, bZ: Int) = shr(this, this, bX, bY, bZ)
    infix fun shrAssign(b: Vec3us) = shr(this, this, b.x, b.y, b.z)

    fun shr(b: Ushort, res: Vec3us) = shr(res, this, b, b, b)
    fun shr(b: Short, res: Vec3us) = shr(res, this, b, b, b)
    fun shr(b: Int, res: Vec3us) = shr(res, this, b, b, b)
    fun shr(bX: Ushort, bY: Ushort, bZ: Ushort, res: Vec3us) = shr(res, this, bX, bY, bZ)
    fun shr(bX: Short, bY: Short, bZ: Short, res: Vec3us) = shr(res, this, bX, bY, bZ)
    fun shr(bX: Int, bY: Int, bZ: Int, res: Vec3us) = shr(res, this, bX, bY, bZ)
    fun shr(b: Vec3us, res: Vec3us) = shr(res, this, b.x, b.y, b.z)


    fun inv(res: Vec3us = Vec3us()) = inv(res, this)
    fun invAssign() = inv(this, this)


    // -- Generic bitwise operators --

    infix fun and(b: Number) = and(Vec3us(), this, b.i, b.i, b.i)
    fun and(bX: Number, bY: Number, bZ: Number) = and(Vec3us(), this, bX.i, bY.i, bZ.i)
    fun and(b: Vec3t<out Number>) = and(Vec3us(), this, b._x.i, b._y.i, b._z.i)

    infix fun andAssign(b: Number) = and(this, this, b.i, b.i, b.i)
    fun andAssign(bX: Number, bY: Number, bZ: Number) = and(this, this, bX.i, bY.i, bZ.i)
    infix fun andAssign(b: Vec3t<out Number>) = and(this, this, b._x.i, b._y.i, b._z.i)

    fun and(b: Number, res: Vec3us) = and(res, this, b.i, b.i, b.i)
    fun and(bX: Number, bY: Number, bZ: Number, res: Vec3us) = and(res, this, bX.i, bY.i, bZ.i)
    fun and(b: Vec3t<out Number>, res: Vec3us) = and(res, this, b._x.i, b._y.i, b._z.i)


    infix fun or(b: Number) = or(Vec3us(), this, b.i, b.i, b.i)
    fun or(bX: Number, bY: Number, bZ: Number) = or(Vec3us(), this, bX.i, bY.i, bZ.i)
    fun or(b: Vec3t<out Number>) = or(Vec3us(), this, b._x.i, b._y.i, b._z.i)

    infix fun orAssign(b: Number) = or(this, this, b.i, b.i, b.i)
    fun orAssign(bX: Number, bY: Number, bZ: Number) = or(this, this, bX.i, bY.i, bZ.i)
    infix fun orAssign(b: Vec3t<out Number>) = or(this, this, b._x.i, b._y.i, b._z.i)

    fun or(b: Number, res: Vec3us) = or(res, this, b.i, b.i, b.i)
    fun or(bX: Number, bY: Number, bZ: Number, res: Vec3us) = or(res, this, bX.i, bY.i, bZ.i)
    fun or(b: Vec3t<out Number>, res: Vec3us) = or(res, this, b._x.i, b._y.i, b._z.i)


    infix fun xor(b: Number) = xor(Vec3us(), this, b.i, b.i, b.i)
    fun xor(bX: Number, bY: Number, bZ: Number) = xor(Vec3us(), this, bX.i, bY.i, bZ.i)
    fun xor(b: Vec3t<out Number>) = xor(Vec3us(), this, b._x.i, b._y.i, b._z.i)

    infix fun xorAssign(b: Number) = xor(this, this, b.i, b.i, b.i)
    fun xorAssign(bX: Number, bY: Number, bZ: Number) = xor(this, this, bX.i, bY.i, bZ.i)
    infix fun xorAssign(b: Vec3t<out Number>) = xor(this, this, b._x.i, b._y.i, b._z.i)

    fun xor(b: Number, res: Vec3us) = xor(res, this, b.i, b.i, b.i)
    fun xor(bX: Number, bY: Number, bZ: Number, res: Vec3us) = xor(res, this, bX.i, bY.i, bZ.i)
    fun xor(b: Vec3t<out Number>, res: Vec3us) = xor(res, this, b._x.i, b._y.i, b._z.i)


    infix fun shl(b: Number) = shl(Vec3us(), this, b.i, b.i, b.i)
    fun shl(bX: Number, bY: Number, bZ: Number) = shl(Vec3us(), this, bX.i, bY.i, bZ.i)
    fun shl(b: Vec3t<out Number>) = shl(Vec3us(), this, b._x.i, b._y.i, b._z.i)

    infix fun shlAssign(b: Number) = shl(this, this, b.i, b.i, b.i)
    fun shlAssign(bX: Number, bY: Number, bZ: Number) = shl(this, this, bX.i, bY.i, bZ.i)
    infix fun shlAssign(b: Vec3t<out Number>) = shl(this, this, b._x.i, b._y.i, b._z.i)

    fun shl(b: Number, res: Vec3us) = shl(res, this, b.i, b.i, b.i)
    fun shl(bX: Number, bY: Number, bZ: Number, res: Vec3us) = shl(res, this, bX.i, bY.i, bZ.i)
    fun shl(b: Vec3t<out Number>, res: Vec3us) = shl(res, this, b._x.i, b._y.i, b._z.i)


    infix fun shr(b: Number) = shr(Vec3us(), this, b.i, b.i, b.i)
    fun shr(bX: Number, bY: Number, bZ: Number) = shr(Vec3us(), this, bX.i, bY.i, bZ.i)
    fun shr(b: Vec3t<out Number>) = shr(Vec3us(), this, b._x.i, b._y.i, b._z.i)

    infix fun shrAssign(b: Number) = shr(this, this, b.i, b.i, b.i)
    fun shrAssign(bX: Number, bY: Number, bZ: Number) = shr(this, this, bX.i, bY.i, bZ.i)
    infix fun shrAssign(b: Vec3t<out Number>) = shr(this, this, b._x.i, b._y.i, b._z.i)

    fun shr(b: Number, res: Vec3us) = shr(res, this, b.i, b.i, b.i)
    fun shr(bX: Number, bY: Number, bZ: Number, res: Vec3us) = shr(res, this, bX.i, bY.i, bZ.i)
    fun shr(b: Vec3t<out Number>, res: Vec3us) = shr(res, this, b._x.i, b._y.i, b._z.i)


    infix fun allLessThan(us: Ushort): Boolean = x < us && y < us && z < us
    infix fun anyLessThan(us: Ushort): Boolean = x < us || y < us || z < us
    infix fun lessThan(us: Ushort): Vec3bool = Vec3bool { get(it) < us }

    infix fun allLessThanEqual(us: Ushort): Boolean = x <= us && y <= us && z <= us
    infix fun anyLessThanEqual(us: Ushort): Boolean = x <= us || y <= us || z <= us
    infix fun lessThanEqual(us: Ushort): Vec3bool = Vec3bool { get(it) <= us }

    infix fun allEqual(us: Ushort): Boolean = x == us && y == us && z == us
    infix fun anyEqual(us: Ushort): Boolean = x == us || y == us || z == us
    infix fun equal(us: Ushort): Vec3bool = Vec3bool { get(it) == us }

    infix fun allNotEqual(us: Ushort): Boolean = x != us && y != us && z != us
    infix fun anyNotEqual(us: Ushort): Boolean = x != us || y != us || z != us
    infix fun notEqual(us: Ushort): Vec3bool = Vec3bool { get(it) != us }

    infix fun allGreaterThan(us: Ushort): Boolean = x > us && y > us && z > us
    infix fun anyGreaterThan(us: Ushort): Boolean = x > us || y > us || z > us
    infix fun greaterThan(us: Ushort): Vec3bool = Vec3bool { get(it) > us }

    infix fun allGreaterThanEqual(us: Ushort): Boolean = x >= us && y >= us && z >= us
    infix fun anyGreaterThanEqual(us: Ushort): Boolean = x >= us || y >= us || z >= us
    infix fun greaterThanEqual(us: Ushort): Vec3bool = Vec3bool { get(it) >= us }


    infix fun allLessThan(v: Vec3us): Boolean = x < v.x && y < v.y && z < v.z
    infix fun anyLessThan(v: Vec3us): Boolean = x < v.x || y < v.y || z < v.z
    infix fun lessThan(v: Vec3us): Vec3bool = Vec3bool { get(it) < v[it] }

    infix fun allLessThanEqual(v: Vec3us): Boolean = x <= v.x && y <= v.y && z <= v.z
    infix fun anyLessThanEqual(v: Vec3us): Boolean = x <= v.x || y <= v.y || z <= v.z
    infix fun lessThanEqual(v: Vec3us): Vec3bool = Vec3bool { get(it) <= v[it] }

    infix fun allEqual(v: Vec3us): Boolean = x == v.x && y == v.y && z == v.z
    infix fun anyEqual(v: Vec3us): Boolean = x == v.x || y == v.y || z == v.z
    infix fun equal(v: Vec3us): Vec3bool = Vec3bool { get(it) == v[it] }

    infix fun allNotEqual(v: Vec3us): Boolean = x != v.x && y != v.y && z != v.z
    infix fun anyNotEqual(v: Vec3us): Boolean = x != v.x || y != v.y || z != v.z
    infix fun notEqual(v: Vec3us): Vec3bool = Vec3bool { get(it) != v[it] }

    infix fun allGreaterThan(v: Vec3us): Boolean = x > v.x && y > v.y && z > v.z
    infix fun anyGreaterThan(v: Vec3us): Boolean = x > v.x || y > v.y || z > v.z
    infix fun greaterThan(v: Vec3us): Vec3bool = Vec3bool { get(it) > v[it] }

    infix fun allGreaterThanEqual(v: Vec3us): Boolean = x >= v.x && y >= v.y && z >= v.z
    infix fun anyGreaterThanEqual(v: Vec3us): Boolean = x >= v.x || y >= v.y || z >= v.z
    infix fun greaterThanEqual(v: Vec3us): Vec3bool = Vec3bool { get(it) >= v[it] }


    companion object : vec3us_operators {
        const val length = Vec3t.LENGTH

        @JvmField
        val size = length * Ushort.BYTES

        @JvmStatic
        fun fromPointer(ptr: Ptr<Ushort>) = Vec3us(ptr)
    }

    override fun size() = size

    override fun equals(other: Any?) = other is Vec3us && this[0] == other[0] && this[1] == other[1] && this[2] == other[2]
    override fun hashCode() = 31 * (31 * x.v.hashCode() + y.v.hashCode()) + z.v.hashCode()

    @JvmOverloads
    fun print(name: String = "", stream: PrintStream = System.out) = stream.print("$name$this")

    @JvmOverloads
    fun println(name: String = "", stream: PrintStream = System.out) = stream.println("$name$this")


    //@formatter:off
    override inline var _x get() = x; set(value) { x = value }
    override inline var r get() = x; set(value) { x = value }
    override inline var s get() = x; set(value) { x = value }

    override inline var _y get() = y; set(value) { y = value }
    override inline var g get() = y; set(value) { y = value }
    override inline var t get() = y; set(value) { y = value }

    override inline var _z get() = z; set(value) { z = value }
    override inline var b get() = z; set(value) { z = value }
    override inline var p get() = z; set(value) { z = value }
    //@formatter:on

    override inline operator fun get(index: Int) = array[ofs + index]

    inline operator fun set(index: Int, value: Ushort) {
        array[ofs + index] = value
    }

    override inline operator fun component1() = x
    override inline operator fun component2() = y
    override inline operator fun component3() = z

    override fun toString(): String = "($x, $y, $z)"
}

