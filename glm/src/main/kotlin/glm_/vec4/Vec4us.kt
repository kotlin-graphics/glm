package glm_.vec4

import glm_.*
import glm_.vec2.Vec2bool
import glm_.vec2.Vec2t
import glm_.vec2.Vec2us
import glm_.vec3.Vec3bool
import glm_.vec3.Vec3t
import glm_.vec3.Vec3us
import glm_.vec4.operators.vec4us_operators
import kool.Ptr
import kool.pos
import kool.ShortBuffer
import kool.set
import org.lwjgl.system.MemoryStack
import org.lwjgl.system.MemoryUtil.memGetShort
import unsigned.Ushort
import java.io.PrintStream
import java.nio.*

/**
 * Created by elect on 09/10/16.
 */

class Vec4us(var ofs: Int, var array: ShortArray) : Vec4t<Ushort>(), ToBuffer {

    constructor(x: Ushort, y: Ushort, z: Ushort, w: Ushort) : this(0, shortArrayOf(x.v, y.v, z.v, w.v))
    constructor(x: Short, y: Short, z: Short, w: Short) : this(0, shortArrayOf(x, y, z, w))

    override var x: Ushort
        get() = Ushort(array[ofs])
        set(value) = array.set(ofs, value.v)
    override var y: Ushort
        get() = Ushort(array[ofs + 1])
        set(value) = array.set(ofs + 1, value.v)
    override var z: Ushort
        get() = Ushort(array[ofs + 2])
        set(value) = array.set(ofs + 2, value.v)
    override var w: Ushort
        get() = Ushort(array[ofs + 3])
        set(value) = array.set(ofs + 3, value.v)

    inline var vX: Short
        get() = array[ofs]
        set(value) = array.set(ofs, value)
    inline var vY: Short
        get() = array[ofs + 1]
        set(value) = array.set(ofs + 1, value)
    inline var vZ: Short
        get() = array[ofs + 2]
        set(value) = array.set(ofs + 2, value)
    inline var vW: Short
        get() = array[ofs + 3]
        set(value) = array.set(ofs + 3, value)

    // -- Explicit basic, conversion other main.and conversion vector constructors --

    constructor() : this(0)

    constructor(v: Vec2t<out Number>) : this(v.x, v.y, 0, 1)
    constructor(v: Vec2t<out Number>, z: Number, w: Number) : this(v.x, v.y, z, w)
    constructor(v: Vec3t<out Number>) : this(v, 1)
    constructor(v: Vec3t<out Number>, w: Number) : this(v.x, v.y, v.z, w)
    constructor(x: Number, v: Vec3t<out Number>) : this(x, v.x, v.y, v.z)
    constructor(v: Vec4t<out Number>) : this(v.x, v.y, v.z, v.w)

    constructor(v: Vec2bool) : this(v.x.us, v.y.us, 0, 1)
    constructor(v: Vec3bool) : this(v.x.us, v.y.us, v.z.us, 1)
    constructor(v: Vec4bool) : this(v.x.us, v.y.us, v.z.us, v.w.us)

    constructor(bytes: ByteArray, index: Int = 0, oneByteOneUshort: Boolean = false, bigEndian: Boolean = true) : this(
            if (oneByteOneUshort) bytes[index].us else bytes.getUshort(index, bigEndian),
            if (oneByteOneUshort) bytes[index + 1].us else bytes.getUshort(index + Ushort.BYTES, bigEndian),
            if (oneByteOneUshort) bytes[index + 2].us else bytes.getUshort(index + Ushort.BYTES * 2, bigEndian),
            if (oneByteOneUshort) bytes[index + 3].us else bytes.getUshort(index + Ushort.BYTES * 3, bigEndian))

    constructor(chars: CharArray, index: Int = 0) : this(chars[index].us, chars[index + 1].us, chars[index + 2].us, chars[index + 3].us)
    constructor(shorts: ShortArray, index: Int = 0) : this(shorts[index], shorts[index + 1], shorts[index + 2], shorts[index + 3])
    constructor(ints: IntArray, index: Int = 0) : this(ints[index], ints[index + 1], ints[index + 2], ints[index + 3])
    constructor(longs: LongArray, index: Int = 0) : this(longs[index], longs[index + 1], longs[index + 2], longs[index + 3])
    constructor(floats: FloatArray, index: Int = 0) : this(floats[index], floats[index + 1], floats[index + 2], floats[index + 3])
    constructor(doubles: DoubleArray, index: Int = 0) : this(doubles[index], doubles[index + 1], doubles[index + 2], doubles[index + 3])
    constructor(booleans: BooleanArray, index: Int = 0) : this(booleans[index].us, booleans[index + 1].us, booleans[index + 2].us, booleans[index + 3].us)

    constructor(numbers: Array<out Number>, index: Int = 0) : this(numbers[index], numbers[index + 1], numbers[index + 2], numbers[index + 3])
    constructor(chars: Array<Char>, index: Int = 0) : this(chars[index].us, chars[index + 1].us, chars[index + 2].us, chars[index + 3].us)
    constructor(booleans: Array<Boolean>, index: Int = 0) : this(booleans[index].us, booleans[index + 1].us, booleans[index + 2].us, booleans[index + 3].us)

    constructor(list: Iterable<*>, index: Int = 0) : this(list.elementAt(index)!!.toShort, list.elementAt(index + 1)!!.toShort,
            list.elementAt(index + 2)!!.toShort, list.elementAt(index + 3)!!.toShort)

    constructor(bytes: ByteBuffer, index: Int = bytes.pos, oneByteOneUshort: Boolean = false) : this(
            if (oneByteOneUshort) bytes[index].us else bytes.getShort(index).us,
            if (oneByteOneUshort) bytes[index + 1].us else bytes.getShort(index + Ushort.BYTES).us,
            if (oneByteOneUshort) bytes[index + 2].us else bytes.getShort(index + Ushort.BYTES * 2).us,
            if (oneByteOneUshort) bytes[index + 3].us else bytes.getShort(index + Ushort.BYTES * 3).us)

    constructor(chars: CharBuffer, index: Int = chars.pos) : this(chars[index].us, chars[index + 1].us, chars[index + 2].us, chars[index + 3].us)
    constructor(shorts: ShortBuffer, index: Int = shorts.pos) : this(shorts[index], shorts[index + 1], shorts[index + 2], shorts[index + 3])
    constructor(ints: IntBuffer, index: Int = ints.pos) : this(ints[index], ints[index + 1], ints[index + 2], ints[index + 3])
    constructor(longs: LongBuffer, index: Int = longs.pos) : this(longs[index], longs[index + 1], longs[index + 2], longs[index + 3])
    constructor(floats: FloatBuffer, index: Int = floats.pos) : this(floats[index], floats[index + 1], floats[index + 2], floats[index + 3])
    constructor(doubles: DoubleBuffer, index: Int = doubles.pos) : this(doubles[index], doubles[index + 1], doubles[index + 2], doubles[index + 3])

    constructor(block: (Int) -> Ushort) : this(block(0), block(1), block(2), block(3))

    constructor(s: Number) : this(s, s, s, s)
    constructor(x: Number, y: Number, z: Number, w: Number) : this(x.us, y.us, z.us, w.us)


    fun set(bytes: ByteArray, index: Int = 0, oneByteOneShort: Boolean = false, bigEndian: Boolean = true) {
        x.v = if (oneByteOneShort) bytes[index].s else bytes.getShort(index, bigEndian)
        y.v = if (oneByteOneShort) bytes[index + 1].s else bytes.getShort(index + Ushort.BYTES, bigEndian)
        z.v = if (oneByteOneShort) bytes[index + 2].s else bytes.getShort(index + Ushort.BYTES * 2, bigEndian)
        w.v = if (oneByteOneShort) bytes[index + 3].s else bytes.getShort(index + Ushort.BYTES * 3, bigEndian)
    }

    fun set(bytes: ByteBuffer, index: Int = bytes.pos, oneByteOneShort: Boolean = false) {
        x.v = if (oneByteOneShort) bytes[index].s else bytes.getShort(index)
        y.v = if (oneByteOneShort) bytes[index + 1].s else bytes.getShort(index + Ushort.BYTES)
        z.v = if (oneByteOneShort) bytes[index + 2].s else bytes.getShort(index + Ushort.BYTES * 2)
        w.v = if (oneByteOneShort) bytes[index + 3].s else bytes.getShort(index + Ushort.BYTES * 3)
    }


    fun put(x: Ushort, y: Ushort, z: Ushort, w: Ushort) {
        this.x = x
        this.y = y
        this.z = z
        this.w = w
    }

    fun put(x: Short, y: Short, z: Short, w: Short) {
        this.x.v = x
        this.y.v = y
        this.z.v = z
        this.w.v = w
    }

    fun invoke(x: Ushort, y: Ushort, z: Ushort, w: Ushort): Vec4us {
        this.x = x
        this.y = y
        this.z = z
        this.w = w
        return this
    }

    fun invoke(x: Short, y: Short, z: Short, w: Short): Vec4us {
        this.x.v = x
        this.y.v = y
        this.z.v = z
        this.w.v = w
        return this
    }

    override fun put(x: Number, y: Number, z: Number, w: Number) {
        this.x = x.us
        this.y = y.us
        this.z = z.us
        this.w = w.us
    }

    override fun invoke(x: Number, y: Number, z: Number, w: Number): Vec4us {
        this.x = x.us
        this.y = y.us
        this.z = z.us
        this.w = w.us
        return this
    }

    fun to(bytes: ByteArray, index: Int): ByteArray = to(bytes, index, true)
    override fun to(bytes: ByteArray, index: Int, bigEndian: Boolean): ByteArray {
        bytes.putShort(index, x.v, bigEndian)
        bytes.putShort(index + Short.BYTES, y.v, bigEndian)
        bytes.putShort(index + Short.BYTES * 2, z.v, bigEndian)
        bytes.putShort(index + Short.BYTES * 3, w.v, bigEndian)
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
        buf.putShort(offset + Short.BYTES * 3, w.v)
        return buf
    }

    fun toShortBufferStack(): ShortBuffer = to(MemoryStack.stackPush().mallocShort(length), 0)
    infix fun toShortBuffer(stack: MemoryStack): ShortBuffer = to(stack.mallocShort(length), 0)
    fun toShortBuffer(): ShortBuffer = to(ShortBuffer(length), 0)
    infix fun to(shorts: ShortBuffer): ShortBuffer = to(shorts, shorts.pos)
    fun to(shorts: ShortBuffer, index: Int): ShortBuffer {
        shorts[index] = x.v
        shorts[index + 1] = y.v
        shorts[index + 2] = z.v
        shorts[index + 3] = w.v
        return shorts
    }

    // -- Component accesses --

    operator fun set(index: Int, value: Ushort) = when (index) {
        0 -> x = value
        1 -> y = value
        2 -> z = value
        3 -> w = value
        else -> throw ArrayIndexOutOfBoundsException()
    }

    operator fun set(index: Int, value: Short) = when (index) {
        0 -> x.v = value
        1 -> y.v = value
        2 -> z.v = value
        3 -> w.v = value
        else -> throw ArrayIndexOutOfBoundsException()
    }

    override operator fun set(index: Int, value: Number) = when (index) {
        0 -> x = value.us
        1 -> y = value.us
        2 -> z = value.us
        3 -> w = value.us
        else -> throw ArrayIndexOutOfBoundsException()
    }


    // -- Unary arithmetic operators --

    operator fun unaryPlus() = this

    // no unaryMinus operator, only signed

    // -- Increment main.and decrement operators --

    operator fun inc(res: Vec4us = Vec4us()) = plus(res, this, 1, 1, 1, 1)
    fun incAssign() = plus(this, this, 1, 1, 1, 1)


    operator fun dec(res: Vec4us = Vec4us()) = minus(res, this, 1, 1, 1, 1)
    fun decAssign() = minus(this, this, 1, 1, 1, 1)


    // -- Specific binary arithmetic operators --

    operator fun plus(b: Ushort) = plus(Vec4us(), this, b, b, b, b)
    operator fun plus(b: Short) = plus(Vec4us(), this, b, b, b, b)
    operator fun plus(b: Int) = plus(Vec4us(), this, b, b, b, b)
    operator fun plus(b: Vec4us) = plus(Vec4us(), this, b.x, b.y, b.z, b.w)

    fun plus(bX: Ushort, bY: Ushort, bZ: Ushort, bW: Ushort, res: Vec4us = Vec4us()) = plus(res, this, bX, bY, bZ, bW)
    fun plus(bX: Short, bY: Short, bZ: Short, bW: Short, res: Vec4us = Vec4us()) = plus(res, this, bX, bY, bZ, bW)
    fun plus(bX: Int, bY: Int, bZ: Int, bW: Int, res: Vec4us = Vec4us()) = plus(res, this, bX, bY, bZ, bW)
    fun plus(b: Ushort, res: Vec4us = Vec4us()) = plus(res, this, b, b, b, b)
    fun plus(b: Short, res: Vec4us = Vec4us()) = plus(res, this, b, b, b, b)
    fun plus(b: Int, res: Vec4us = Vec4us()) = plus(res, this, b, b, b, b)
    fun plus(b: Vec4us, res: Vec4us = Vec4us()) = plus(res, this, b.x, b.y, b.z, b.w)

    fun plusAssign(bX: Ushort, bY: Ushort, bZ: Ushort, bW: Ushort) = plus(this, this, bX, bY, bZ, bW)
    fun plusAssign(bX: Short, bY: Short, bZ: Short, bW: Short) = plus(this, this, bX, bY, bZ, bW)
    fun plusAssign(bX: Int, bY: Int, bZ: Int, bW: Int) = plus(this, this, bX, bY, bZ, bW)
    infix operator fun plusAssign(b: Ushort) {
        plus(this, this, b, b, b, b)
    }

    infix operator fun plusAssign(b: Short) {
        plus(this, this, b, b, b, b)
    }

    infix operator fun plusAssign(b: Int) {
        plus(this, this, b, b, b, b)
    }

    infix operator fun plusAssign(b: Vec4us) {
        plus(this, this, b.x, b.y, b.z, b.w)
    }


    operator fun minus(b: Ushort) = minus(Vec4us(), this, b, b, b, b)
    operator fun minus(b: Short) = minus(Vec4us(), this, b, b, b, b)
    operator fun minus(b: Int) = minus(Vec4us(), this, b, b, b, b)
    operator fun minus(b: Vec4us) = minus(Vec4us(), this, b.x, b.y, b.z, b.w)

    fun minus(bX: Ushort, bY: Ushort, bZ: Ushort, bW: Ushort, res: Vec4us = Vec4us()) = minus(res, this, bX, bY, bZ, bW)
    fun minus(bX: Short, bY: Short, bZ: Short, bW: Short, res: Vec4us = Vec4us()) = minus(res, this, bX, bY, bZ, bW)
    fun minus(bX: Int, bY: Int, bZ: Int, bW: Int, res: Vec4us = Vec4us()) = minus(res, this, bX, bY, bZ, bW)
    fun minus(b: Ushort, res: Vec4us = Vec4us()) = minus(res, this, b, b, b, b)
    fun minus(b: Short, res: Vec4us = Vec4us()) = minus(res, this, b, b, b, b)
    fun minus(b: Int, res: Vec4us = Vec4us()) = minus(res, this, b, b, b, b)
    fun minus(b: Vec4us, res: Vec4us = Vec4us()) = minus(res, this, b.x, b.y, b.z, b.w)

    fun minusAssign(bX: Ushort, bY: Ushort, bZ: Ushort, bW: Ushort) = minus(this, this, bX, bY, bZ, bW)
    fun minusAssign(bX: Short, bY: Short, bZ: Short, bW: Short) = minus(this, this, bX, bY, bZ, bW)
    fun minusAssign(bX: Int, bY: Int, bZ: Int, bW: Int) = minus(this, this, bX, bY, bZ, bW)
    infix operator fun minusAssign(b: Ushort) {
        minus(this, this, b, b, b, b)
    }

    infix operator fun minusAssign(b: Short) {
        minus(this, this, b, b, b, b)
    }

    infix operator fun minusAssign(b: Int) {
        minus(this, this, b, b, b, b)
    }

    infix operator fun minusAssign(b: Vec4us) {
        minus(this, this, b.x, b.y, b.z, b.w)
    }


    operator fun times(b: Ushort) = times(Vec4us(), this, b, b, b, b)
    operator fun times(b: Short) = times(Vec4us(), this, b, b, b, b)
    operator fun times(b: Int) = times(Vec4us(), this, b, b, b, b)
    operator fun times(b: Vec4us) = times(Vec4us(), this, b.x, b.y, b.z, b.w)

    fun times(bX: Ushort, bY: Ushort, bZ: Ushort, bW: Ushort, res: Vec4us = Vec4us()) = times(res, this, bX, bY, bZ, bW)
    fun times(bX: Short, bY: Short, bZ: Short, bW: Short, res: Vec4us = Vec4us()) = times(res, this, bX, bY, bZ, bW)
    fun times(bX: Int, bY: Int, bZ: Int, bW: Int, res: Vec4us = Vec4us()) = times(res, this, bX, bY, bZ, bW)
    fun times(b: Ushort, res: Vec4us = Vec4us()) = times(res, this, b, b, b, b)
    fun times(b: Short, res: Vec4us = Vec4us()) = times(res, this, b, b, b, b)
    fun times(b: Int, res: Vec4us = Vec4us()) = times(res, this, b, b, b, b)
    fun times(b: Vec4us, res: Vec4us = Vec4us()) = times(res, this, b.x, b.y, b.z, b.w)

    fun timesAssign(bX: Ushort, bY: Ushort, bZ: Ushort, bW: Ushort) = times(this, this, bX, bY, bZ, bW)
    fun timesAssign(bX: Short, bY: Short, bZ: Short, bW: Short) = times(this, this, bX, bY, bZ, bW)
    fun timesAssign(bX: Int, bY: Int, bZ: Int, bW: Int) = times(this, this, bX, bY, bZ, bW)
    infix operator fun timesAssign(b: Ushort) {
        times(this, this, b, b, b, b)
    }

    infix operator fun timesAssign(b: Short) {
        times(this, this, b, b, b, b)
    }

    infix operator fun timesAssign(b: Int) {
        times(this, this, b, b, b, b)
    }

    infix operator fun timesAssign(b: Vec4us) {
        times(this, this, b.x, b.y, b.z, b.w)
    }


    operator fun div(b: Ushort) = div(Vec4us(), this, b, b, b, b)
    operator fun div(b: Short) = div(Vec4us(), this, b, b, b, b)
    operator fun div(b: Int) = div(Vec4us(), this, b, b, b, b)
    operator fun div(b: Vec4us) = div(Vec4us(), this, b.x, b.y, b.z, b.w)

    fun div(bX: Ushort, bY: Ushort, bZ: Ushort, bW: Ushort, res: Vec4us = Vec4us()) = div(res, this, bX, bY, bZ, bW)
    fun div(bX: Short, bY: Short, bZ: Short, bW: Short, res: Vec4us = Vec4us()) = div(res, this, bX, bY, bZ, bW)
    fun div(bX: Int, bY: Int, bZ: Int, bW: Int, res: Vec4us = Vec4us()) = div(res, this, bX, bY, bZ, bW)
    fun div(b: Ushort, res: Vec4us = Vec4us()) = div(res, this, b, b, b, b)
    fun div(b: Short, res: Vec4us = Vec4us()) = div(res, this, b, b, b, b)
    fun div(b: Int, res: Vec4us = Vec4us()) = div(res, this, b, b, b, b)
    fun div(b: Vec4us, res: Vec4us = Vec4us()) = div(res, this, b.x, b.y, b.z, b.w)

    fun divAssign(bX: Ushort, bY: Ushort, bZ: Ushort, bW: Ushort) = div(this, this, bX, bY, bZ, bW)
    fun divAssign(bX: Short, bY: Short, bZ: Short, bW: Short) = div(this, this, bX, bY, bZ, bW)
    fun divAssign(bX: Int, bY: Int, bZ: Int, bW: Int) = div(this, this, bX, bY, bZ, bW)
    infix operator fun divAssign(b: Ushort) {
        div(this, this, b, b, b, b)
    }

    infix operator fun divAssign(b: Short) {
        div(this, this, b, b, b, b)
    }

    infix operator fun divAssign(b: Int) {
        div(this, this, b, b, b, b)
    }

    infix operator fun divAssign(b: Vec4us) {
        div(this, this, b.x, b.y, b.z, b.w)
    }


    operator fun rem(b: Ushort) = rem(Vec4us(), this, b, b, b, b)
    operator fun rem(b: Short) = rem(Vec4us(), this, b, b, b, b)
    operator fun rem(b: Int) = rem(Vec4us(), this, b, b, b, b)
    operator fun rem(b: Vec4us) = rem(Vec4us(), this, b.x, b.y, b.z, b.w)

    fun rem(bX: Ushort, bY: Ushort, bZ: Ushort, bW: Ushort, res: Vec4us = Vec4us()) = rem(res, this, bX, bY, bZ, bW)
    fun rem(bX: Short, bY: Short, bZ: Short, bW: Short, res: Vec4us = Vec4us()) = rem(res, this, bX, bY, bZ, bW)
    fun rem(bX: Int, bY: Int, bZ: Int, bW: Int, res: Vec4us = Vec4us()) = rem(res, this, bX, bY, bZ, bW)
    fun rem(b: Ushort, res: Vec4us = Vec4us()) = rem(res, this, b, b, b, b)
    fun rem(b: Short, res: Vec4us = Vec4us()) = rem(res, this, b, b, b, b)
    fun rem(b: Int, res: Vec4us = Vec4us()) = rem(res, this, b, b, b, b)
    fun rem(b: Vec4us, res: Vec4us = Vec4us()) = rem(res, this, b.x, b.y, b.z, b.w)

    fun remAssign(bX: Ushort, bY: Ushort, bZ: Ushort, bW: Ushort) = rem(this, this, bX, bY, bZ, bW)
    fun remAssign(bX: Short, bY: Short, bZ: Short, bW: Short) = rem(this, this, bX, bY, bZ, bW)
    fun remAssign(bX: Int, bY: Int, bZ: Int, bW: Int) = rem(this, this, bX, bY, bZ, bW)
    infix operator fun remAssign(b: Ushort) {
        rem(this, this, b, b, b, b)
    }

    infix operator fun remAssign(b: Short) {
        rem(this, this, b, b, b, b)
    }

    infix operator fun remAssign(b: Int) {
        rem(this, this, b, b, b, b)
    }

    infix operator fun remAssign(b: Vec4us) {
        rem(this, this, b.x, b.y, b.z, b.w)
    }


    // -- Generic binary arithmetic operators --

    operator fun plus(b: Number) = plus(Vec4us(), this, b.i, b.i, b.i, b.i)
    operator fun plus(b: Vec4t<out Number>) = plus(Vec4us(), this, b.x.i, b.y.i, b.z.i, b.w.i)

    fun plus(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4us = Vec4us()) = plus(res, this, bX.i, bY.i, bZ.i, bW.i)
    fun plus(b: Number, res: Vec4us = Vec4us()) = plus(res, this, b.i, b.i, b.i, b.i)
    fun plus(b: Vec4t<out Number>, res: Vec4us = Vec4us()) = plus(res, this, b.x.i, b.y.i, b.z.i, b.w.i)

    fun plusAssign(bX: Number, bY: Number, bZ: Number, bW: Number) = plus(this, this, bX.i, bY.i, bZ.i, bW.i)
    infix operator fun plusAssign(b: Number) {
        plus(this, this, b.i, b.i, b.i, b.i)
    }

    infix operator fun plusAssign(b: Vec4t<out Number>) {
        plus(this, this, b.x.i, b.y.i, b.z.i, b.w.i)
    }


    operator fun minus(b: Number) = minus(Vec4us(), this, b.i, b.i, b.i, b.i)
    operator fun minus(b: Vec4t<out Number>) = minus(Vec4us(), this, b.x.i, b.y.i, b.z.i, b.w.i)

    fun minus(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4us = Vec4us()) = minus(res, this, bX.i, bY.i, bZ.i, bW.i)
    fun minus(b: Number, res: Vec4us = Vec4us()) = minus(res, this, b.i, b.i, b.i, b.i)
    fun minus(b: Vec4t<out Number>, res: Vec4us = Vec4us()) = minus(res, this, b.x.i, b.y.i, b.z.i, b.w.i)

    fun minusAssign(bX: Number, bY: Number, bZ: Number, bW: Number) = minus(this, this, bX.i, bY.i, bZ.i, bW.i)
    infix operator fun minusAssign(b: Number) {
        minus(this, this, b.i, b.i, b.i, b.i)
    }

    infix operator fun minusAssign(b: Vec4t<out Number>) {
        minus(this, this, b.x.i, b.y.i, b.z.i, b.w.i)
    }


    operator fun times(b: Number) = times(Vec4us(), this, b.i, b.i, b.i, b.i)
    operator fun times(b: Vec4t<out Number>) = times(Vec4us(), this, b.x.i, b.y.i, b.z.i, b.w.i)

    fun times(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4us = Vec4us()) = times(res, this, bX.i, bY.i, bZ.i, bW.i)
    fun times(b: Number, res: Vec4us = Vec4us()) = times(res, this, b.i, b.i, b.i, b.i)
    fun times(b: Vec4t<out Number>, res: Vec4us = Vec4us()) = times(res, this, b.x.i, b.y.i, b.z.i, b.w.i)

    fun timesAssign(bX: Number, bY: Number, bZ: Number, bW: Number) = times(this, this, bX.i, bY.i, bZ.i, bW.i)
    infix operator fun timesAssign(b: Number) {
        times(this, this, b.i, b.i, b.i, b.i)
    }

    infix operator fun timesAssign(b: Vec4t<out Number>) {
        times(this, this, b.x.i, b.y.i, b.z.i, b.w.i)
    }


    operator fun div(b: Number) = div(Vec4us(), this, b.i, b.i, b.i, b.i)
    operator fun div(b: Vec4t<out Number>) = div(Vec4us(), this, b.x.i, b.y.i, b.z.i, b.w.i)

    fun div(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4us = Vec4us()) = div(res, this, bX.i, bY.i, bZ.i, bW.i)
    fun div(b: Number, res: Vec4us = Vec4us()) = div(res, this, b.i, b.i, b.i, b.i)
    fun div(b: Vec4t<out Number>, res: Vec4us = Vec4us()) = div(res, this, b.x.i, b.y.i, b.z.i, b.w.i)

    fun divAssign(bX: Number, bY: Number, bZ: Number, bW: Number) = div(this, this, bX.i, bY.i, bZ.i, bW.i)
    infix operator fun divAssign(b: Number) {
        div(this, this, b.i, b.i, b.i, b.i)
    }

    infix operator fun divAssign(b: Vec4t<out Number>) {
        div(this, this, b.x.i, b.y.i, b.z.i, b.w.i)
    }


    operator fun rem(b: Number) = rem(Vec4us(), this, b.i, b.i, b.i, b.i)
    operator fun rem(b: Vec4t<out Number>) = rem(Vec4us(), this, b.x.i, b.y.i, b.z.i, b.w.i)

    fun rem(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4us = Vec4us()) = rem(res, this, bX.i, bY.i, bZ.i, bW.i)
    fun rem(b: Number, res: Vec4us = Vec4us()) = rem(res, this, b.i, b.i, b.i, b.i)
    fun rem(b: Vec4t<out Number>, res: Vec4us = Vec4us()) = rem(res, this, b.x.i, b.y.i, b.z.i, b.w.i)

    fun remAssign(bX: Number, bY: Number, bZ: Number, bW: Number) = rem(this, this, bX.i, bY.i, bZ.i, bW.i)
    infix operator fun remAssign(b: Number) {
        rem(this, this, b.i, b.i, b.i, b.i)
    }

    infix operator fun remAssign(b: Vec4t<out Number>) {
        rem(this, this, b.x.i, b.y.i, b.z.i, b.w.i)
    }


    // -- Specific bitwise operators --

    infix fun and(b: Ushort) = and(Vec4us(), this, b, b, b, b)
    infix fun and(b: Short) = and(Vec4us(), this, b, b, b, b)
    infix fun and(b: Int) = and(Vec4us(), this, b, b, b, b)
    fun and(bX: Ushort, bY: Ushort, bZ: Ushort, bW: Ushort) = and(Vec4us(), this, bX, bY, bZ, bW)
    fun and(bX: Short, bY: Short, bZ: Short, bW: Short) = and(Vec4us(), this, bX, bY, bZ, bW)
    fun and(bX: Int, bY: Int, bZ: Int, bW: Int) = and(Vec4us(), this, bX, bY, bZ, bW)
    fun and(b: Vec4us) = and(Vec4us(), this, b.x, b.y, b.z, b.w)

    infix fun andAssign(b: Ushort) = and(this, this, b, b, b, b)
    infix fun andAssign(b: Short) = and(this, this, b, b, b, b)
    infix fun andAssign(b: Int) = and(this, this, b, b, b, b)
    fun andAssign(bX: Ushort, bY: Ushort, bZ: Ushort, bW: Ushort) = and(this, this, bX, bY, bZ, bW)
    fun andAssign(bX: Short, bY: Short, bZ: Short, bW: Short) = and(this, this, bX, bY, bZ, bW)
    fun andAssign(bX: Int, bY: Int, bZ: Int, bW: Int) = and(this, this, bX, bY, bZ, bW)
    infix fun andAssign(b: Vec4us) = and(this, this, b.x, b.y, b.z, b.w)

    fun and(b: Ushort, res: Vec4us) = and(res, this, b, b, b, b)
    fun and(b: Short, res: Vec4us) = and(res, this, b, b, b, b)
    fun and(b: Int, res: Vec4us) = and(res, this, b, b, b, b)
    fun and(bX: Ushort, bY: Ushort, bZ: Ushort, bW: Ushort, res: Vec4us) = and(res, this, bX, bY, bZ, bW)
    fun and(bX: Short, bY: Short, bZ: Short, bW: Short, res: Vec4us) = and(res, this, bX, bY, bZ, bW)
    fun and(bX: Int, bY: Int, bZ: Int, bW: Int, res: Vec4us) = and(res, this, bX, bY, bZ, bW)
    fun and(b: Vec4us, res: Vec4us) = and(res, this, b.x, b.y, b.z, b.w)


    infix fun or(b: Ushort) = or(Vec4us(), this, b, b, b, b)
    infix fun or(b: Short) = or(Vec4us(), this, b, b, b, b)
    infix fun or(b: Int) = or(Vec4us(), this, b, b, b, b)
    fun or(bX: Ushort, bY: Ushort, bZ: Ushort, bW: Ushort) = or(Vec4us(), this, bX, bY, bZ, bW)
    fun or(bX: Short, bY: Short, bZ: Short, bW: Short) = or(Vec4us(), this, bX, bY, bZ, bW)
    fun or(bX: Int, bY: Int, bZ: Int, bW: Int) = or(Vec4us(), this, bX, bY, bZ, bW)
    fun or(b: Vec4us) = or(Vec4us(), this, b.x, b.y, b.z, b.w)

    infix fun orAssign(b: Ushort) = or(this, this, b, b, b, b)
    infix fun orAssign(b: Short) = or(this, this, b, b, b, b)
    infix fun orAssign(b: Int) = or(this, this, b, b, b, b)
    fun orAssign(bX: Ushort, bY: Ushort, bZ: Ushort, bW: Ushort) = or(this, this, bX, bY, bZ, bW)
    fun orAssign(bX: Short, bY: Short, bZ: Short, bW: Short) = or(this, this, bX, bY, bZ, bW)
    fun orAssign(bX: Int, bY: Int, bZ: Int, bW: Int) = or(this, this, bX, bY, bZ, bW)
    infix fun orAssign(b: Vec4us) = or(this, this, b.x, b.y, b.z, b.w)

    fun or(b: Ushort, res: Vec4us) = or(res, this, b, b, b, b)
    fun or(b: Short, res: Vec4us) = or(res, this, b, b, b, b)
    fun or(b: Int, res: Vec4us) = or(res, this, b, b, b, b)
    fun or(bX: Ushort, bY: Ushort, bZ: Ushort, bW: Ushort, res: Vec4us) = or(res, this, bX, bY, bZ, bW)
    fun or(bX: Short, bY: Short, bZ: Short, bW: Short, res: Vec4us) = or(res, this, bX, bY, bZ, bW)
    fun or(bX: Int, bY: Int, bZ: Int, bW: Int, res: Vec4us) = or(res, this, bX, bY, bZ, bW)
    fun or(b: Vec4us, res: Vec4us) = or(res, this, b.x, b.y, b.z, b.w)


    infix fun xor(b: Ushort) = xor(Vec4us(), this, b, b, b, b)
    infix fun xor(b: Short) = xor(Vec4us(), this, b, b, b, b)
    infix fun xor(b: Int) = xor(Vec4us(), this, b, b, b, b)
    fun xor(bX: Ushort, bY: Ushort, bZ: Ushort, bW: Ushort) = xor(Vec4us(), this, bX, bY, bZ, bW)
    fun xor(bX: Short, bY: Short, bZ: Short, bW: Short) = xor(Vec4us(), this, bX, bY, bZ, bW)
    fun xor(bX: Int, bY: Int, bZ: Int, bW: Int) = xor(Vec4us(), this, bX, bY, bZ, bW)
    fun xor(b: Vec4us) = xor(Vec4us(), this, b.x, b.y, b.z, b.w)

    infix fun xorAssign(b: Ushort) = xor(this, this, b, b, b, b)
    infix fun xorAssign(b: Short) = xor(this, this, b, b, b, b)
    infix fun xorAssign(b: Int) = xor(this, this, b, b, b, b)
    fun xorAssign(bX: Ushort, bY: Ushort, bZ: Ushort, bW: Ushort) = xor(this, this, bX, bY, bZ, bW)
    fun xorAssign(bX: Short, bY: Short, bZ: Short, bW: Short) = xor(this, this, bX, bY, bZ, bW)
    fun xorAssign(bX: Int, bY: Int, bZ: Int, bW: Int) = xor(this, this, bX, bY, bZ, bW)
    infix fun xorAssign(b: Vec4us) = xor(this, this, b.x, b.y, b.z, b.w)

    fun xor(b: Ushort, res: Vec4us) = xor(res, this, b, b, b, b)
    fun xor(b: Short, res: Vec4us) = xor(res, this, b, b, b, b)
    fun xor(b: Int, res: Vec4us) = xor(res, this, b, b, b, b)
    fun xor(bX: Ushort, bY: Ushort, bZ: Ushort, bW: Ushort, res: Vec4us) = xor(res, this, bX, bY, bZ, bW)
    fun xor(bX: Short, bY: Short, bZ: Short, bW: Short, res: Vec4us) = xor(res, this, bX, bY, bZ, bW)
    fun xor(bX: Int, bY: Int, bZ: Int, bW: Int, res: Vec4us) = xor(res, this, bX, bY, bZ, bW)
    fun xor(b: Vec4us, res: Vec4us) = xor(res, this, b.x, b.y, b.z, b.w)


    infix fun shl(b: Ushort) = shl(Vec4us(), this, b, b, b, b)
    infix fun shl(b: Short) = shl(Vec4us(), this, b, b, b, b)
    infix fun shl(b: Int) = shl(Vec4us(), this, b, b, b, b)
    fun shl(bX: Ushort, bY: Ushort, bZ: Ushort, bW: Ushort) = shl(Vec4us(), this, bX, bY, bZ, bW)
    fun shl(bX: Short, bY: Short, bZ: Short, bW: Short) = shl(Vec4us(), this, bX, bY, bZ, bW)
    fun shl(bX: Int, bY: Int, bZ: Int, bW: Int) = shl(Vec4us(), this, bX, bY, bZ, bW)
    fun shl(b: Vec4us) = shl(Vec4us(), this, b.x, b.y, b.z, b.w)

    infix fun shlAssign(b: Ushort) = shl(this, this, b, b, b, b)
    infix fun shlAssign(b: Short) = shl(this, this, b, b, b, b)
    infix fun shlAssign(b: Int) = shl(this, this, b, b, b, b)
    fun shlAssign(bX: Ushort, bY: Ushort, bZ: Ushort, bW: Ushort) = shl(this, this, bX, bY, bZ, bW)
    fun shlAssign(bX: Short, bY: Short, bZ: Short, bW: Short) = shl(this, this, bX, bY, bZ, bW)
    fun shlAssign(bX: Int, bY: Int, bZ: Int, bW: Int) = shl(this, this, bX, bY, bZ, bW)
    infix fun shlAssign(b: Vec4us) = shl(this, this, b.x, b.y, b.z, b.w)

    fun shl(b: Ushort, res: Vec4us) = shl(res, this, b, b, b, b)
    fun shl(b: Short, res: Vec4us) = shl(res, this, b, b, b, b)
    fun shl(b: Int, res: Vec4us) = shl(res, this, b, b, b, b)
    fun shl(bX: Ushort, bY: Ushort, bZ: Ushort, bW: Ushort, res: Vec4us) = shl(res, this, bX, bY, bZ, bW)
    fun shl(bX: Short, bY: Short, bZ: Short, bW: Short, res: Vec4us) = shl(res, this, bX, bY, bZ, bW)
    fun shl(bX: Int, bY: Int, bZ: Int, bW: Int, res: Vec4us) = shl(res, this, bX, bY, bZ, bW)
    fun shl(b: Vec4us, res: Vec4us) = shl(res, this, b.x, b.y, b.z, b.w)


    infix fun shr(b: Ushort) = shr(Vec4us(), this, b, b, b, b)
    infix fun shr(b: Short) = shr(Vec4us(), this, b, b, b, b)
    infix fun shr(b: Int) = shr(Vec4us(), this, b, b, b, b)
    fun shr(bX: Ushort, bY: Ushort, bZ: Ushort, bW: Ushort) = shr(Vec4us(), this, bX, bY, bZ, bW)
    fun shr(bX: Short, bY: Short, bZ: Short, bW: Short) = shr(Vec4us(), this, bX, bY, bZ, bW)
    fun shr(bX: Int, bY: Int, bZ: Int, bW: Int) = shr(Vec4us(), this, bX, bY, bZ, bW)
    fun shr(b: Vec4us) = shr(Vec4us(), this, b.x, b.y, b.z, b.w)

    infix fun shrAssign(b: Ushort) = shr(this, this, b, b, b, b)
    infix fun shrAssign(b: Short) = shr(this, this, b, b, b, b)
    infix fun shrAssign(b: Int) = shr(this, this, b, b, b, b)
    fun shrAssign(bX: Ushort, bY: Ushort, bZ: Ushort, bW: Ushort) = shr(this, this, bX, bY, bZ, bW)
    fun shrAssign(bX: Short, bY: Short, bZ: Short, bW: Short) = shr(this, this, bX, bY, bZ, bW)
    fun shrAssign(bX: Int, bY: Int, bZ: Int, bW: Int) = shr(this, this, bX, bY, bZ, bW)
    infix fun shrAssign(b: Vec4us) = shr(this, this, b.x, b.y, b.z, b.w)

    fun shr(b: Ushort, res: Vec4us) = shr(res, this, b, b, b, b)
    fun shr(b: Short, res: Vec4us) = shr(res, this, b, b, b, b)
    fun shr(b: Int, res: Vec4us) = shr(res, this, b, b, b, b)
    fun shr(bX: Ushort, bY: Ushort, bZ: Ushort, bW: Ushort, res: Vec4us) = shr(res, this, bX, bY, bZ, bW)
    fun shr(bX: Short, bY: Short, bZ: Short, bW: Short, res: Vec4us) = shr(res, this, bX, bY, bZ, bW)
    fun shr(bX: Int, bY: Int, bZ: Int, bW: Int, res: Vec4us) = shr(res, this, bX, bY, bZ, bW)
    fun shr(b: Vec4us, res: Vec4us) = shr(res, this, b.x, b.y, b.z, b.w)


    fun inv(res: Vec4us = Vec4us()) = inv(res, this)
    fun invAssign() = inv(this, this)


    // -- Generic bitwise operators --

    infix fun and(b: Number) = and(Vec4us(), this, b.i, b.i, b.i, b.i)
    fun and(bX: Number, bY: Number, bZ: Number, bW: Number) = and(Vec4us(), this, bX.i, bY.i, bZ.i, bW.i)
    fun and(b: Vec4t<out Number>) = and(Vec4us(), this, b.x.i, b.y.i, b.z.i, b.w.i)

    infix fun andAssign(b: Number) = and(this, this, b.i, b.i, b.i, b.i)
    fun andAssign(bX: Number, bY: Number, bZ: Number, bW: Number) = and(this, this, bX.i, bY.i, bZ.i, bW.i)
    infix fun andAssign(b: Vec4t<out Number>) = and(this, this, b.x.i, b.y.i, b.z.i, b.w.i)

    fun and(b: Number, res: Vec4us) = and(res, this, b.i, b.i, b.i, b.i)
    fun and(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4us) = and(res, this, bX.i, bY.i, bZ.i, bW.i)
    fun and(b: Vec4t<out Number>, res: Vec4us) = and(res, this, b.x.i, b.y.i, b.z.i, b.w.i)


    infix fun or(b: Number) = or(Vec4us(), this, b.i, b.i, b.i, b.i)
    fun or(bX: Number, bY: Number, bZ: Number, bW: Number) = or(Vec4us(), this, bX.i, bY.i, bZ.i, bW.i)
    fun or(b: Vec4t<out Number>) = or(Vec4us(), this, b.x.i, b.y.i, b.z.i, b.w.i)

    infix fun orAssign(b: Number) = or(this, this, b.i, b.i, b.i, b.i)
    fun orAssign(bX: Number, bY: Number, bZ: Number, bW: Number) = or(this, this, bX.i, bY.i, bZ.i, bW.i)
    infix fun orAssign(b: Vec4t<out Number>) = or(this, this, b.x.i, b.y.i, b.z.i, b.w.i)

    fun or(b: Number, res: Vec4us) = or(res, this, b.i, b.i, b.i, b.i)
    fun or(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4us) = or(res, this, bX.i, bY.i, bZ.i, bW.i)
    fun or(b: Vec4t<out Number>, res: Vec4us) = or(res, this, b.x.i, b.y.i, b.z.i, b.w.i)


    infix fun xor(b: Number) = xor(Vec4us(), this, b.i, b.i, b.i, b.i)
    fun xor(bX: Number, bY: Number, bZ: Number, bW: Number) = xor(Vec4us(), this, bX.i, bY.i, bZ.i, bW.i)
    fun xor(b: Vec4t<out Number>) = xor(Vec4us(), this, b.x.i, b.y.i, b.z.i, b.w.i)

    infix fun xorAssign(b: Number) = xor(this, this, b.i, b.i, b.i, b.i)
    fun xorAssign(bX: Number, bY: Number, bZ: Number, bW: Number) = xor(this, this, bX.i, bY.i, bZ.i, bW.i)
    infix fun xorAssign(b: Vec4t<out Number>) = xor(this, this, b.x.i, b.y.i, b.z.i, b.w.i)

    fun xor(b: Number, res: Vec4us) = xor(res, this, b.i, b.i, b.i, b.i)
    fun xor(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4us) = xor(res, this, bX.i, bY.i, bZ.i, bW.i)
    fun xor(b: Vec4t<out Number>, res: Vec4us) = xor(res, this, b.x.i, b.y.i, b.z.i, b.w.i)


    infix fun shl(b: Number) = shl(Vec4us(), this, b.i, b.i, b.i, b.i)
    fun shl(bX: Number, bY: Number, bZ: Number, bW: Number) = shl(Vec4us(), this, bX.i, bY.i, bZ.i, bW.i)
    fun shl(b: Vec4t<out Number>) = shl(Vec4us(), this, b.x.i, b.y.i, b.z.i, b.w.i)

    infix fun shlAssign(b: Number) = shl(this, this, b.i, b.i, b.i, b.i)
    fun shlAssign(bX: Number, bY: Number, bZ: Number, bW: Number) = shl(this, this, bX.i, bY.i, bZ.i, bW.i)
    infix fun shlAssign(b: Vec4t<out Number>) = shl(this, this, b.x.i, b.y.i, b.z.i, b.w.i)

    fun shl(b: Number, res: Vec4us) = shl(res, this, b.i, b.i, b.i, b.i)
    fun shl(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4us) = shl(res, this, bX.i, bY.i, bZ.i, bW.i)
    fun shl(b: Vec4t<out Number>, res: Vec4us) = shl(res, this, b.x.i, b.y.i, b.z.i, b.w.i)


    infix fun shr(b: Number) = shr(Vec4us(), this, b.i, b.i, b.i, b.i)
    fun shr(bX: Number, bY: Number, bZ: Number, bW: Number) = shr(Vec4us(), this, bX.i, bY.i, bZ.i, bW.i)
    fun shr(b: Vec4t<out Number>) = shr(Vec4us(), this, b.x.i, b.y.i, b.z.i, b.w.i)

    infix fun shrAssign(b: Number) = shr(this, this, b.i, b.i, b.i, b.i)
    fun shrAssign(bX: Number, bY: Number, bZ: Number, bW: Number) = shr(this, this, bX.i, bY.i, bZ.i, bW.i)
    infix fun shrAssign(b: Vec4t<out Number>) = shr(this, this, b.x.i, b.y.i, b.z.i, b.w.i)

    fun shr(b: Number, res: Vec4us) = shr(res, this, b.i, b.i, b.i, b.i)
    fun shr(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4us) = shr(res, this, bX.i, bY.i, bZ.i, bW.i)
    fun shr(b: Vec4t<out Number>, res: Vec4us) = shr(res, this, b.x.i, b.y.i, b.z.i, b.w.i)


    override fun createInstance(x: Ushort, y: Ushort) = Vec2us(x, y)
    override fun createInstance(x: Ushort, y: Ushort, z: Ushort) = Vec3us(x, y, z)
    override fun createInstance(x: Ushort, y: Ushort, z: Ushort, w: Ushort) = Vec4us(x, y, z, w)


    companion object : vec4us_operators {
        const val length = Vec4t.length
        @JvmField
        val size = length * Ushort.BYTES

        @JvmStatic
        fun fromPointer(ptr: Ptr) = Vec4us(memGetShort(ptr), memGetShort(ptr + Short.BYTES), memGetShort(ptr + Short.BYTES * 2), memGetShort(ptr + Short.BYTES * 3))
    }

    override fun size() = size


    override fun equals(other: Any?) = other is Vec4us && this[0] == other[0] && this[1] == other[1] && this[2] == other[2] && this[3] == other[3]
    override fun hashCode() = 31 * (31 * (31 * x.v.hashCode() + y.v.hashCode()) + z.v.hashCode()) + w.v.hashCode()

    fun print(name: String = "", stream: PrintStream = System.out) = stream.println("$name [${x.v}, ${y.v}, ${z.v}, ${w.v}]")
    override fun toString(): String = "Vec4us [${x.v}, ${y.v}, ${z.v}, ${w.v}]"
}