package glm_.vec3

import glm_.*
import glm_.vec1.Vec1bool
import glm_.vec1.Vec1t
import glm_.vec2.Vec2bool
import glm_.vec2.Vec2s
import glm_.vec2.Vec2t
import glm_.vec3.operators.vec3s_operators
import glm_.vec4.Vec4bool
import glm_.vec4.Vec4t
import kool.Ptr
import kool.pos
import kool.ShortBuffer
import kool.set
import org.lwjgl.system.MemoryStack
import org.lwjgl.system.MemoryUtil.memGetShort
import org.lwjgl.system.MemoryUtil.memPutShort
import java.io.PrintStream
import java.nio.*

/**
 * Created by elect on 09/10/16.
 */

class Vec3s(var ofs: Int, var array: ShortArray) : Vec3t<Short>(), ToBuffer {

    override var x: Short
        get() = array[ofs]
        set(value) = array.set(ofs, value)
    override var y: Short
        get() = array[ofs + 1]
        set(value) = array.set(ofs + 1, value)
    override var z: Short
        get() = array[ofs + 2]
        set(value) = array.set(ofs + 2, value)

    // -- Implicit basic constructors --

    constructor() : this(0, 0, 0)
    constructor(v: Vec3s) : this(v.x, v.y, v.z)

    // -- Explicit basic constructors --

    @JvmOverloads
    constructor(x: Short, y: Short = x, z: Short = x) : this(0, shortArrayOf(x, y, z))
    @JvmOverloads
    constructor(x: Int, y: Int = x, z: Int = x) : this(0, shortArrayOf(x.s, y.s, z.s))

    // -- Conversion scalar constructors --

    constructor(v: Vec1t<out Number>) : this(v.x, v.x, v.x)

    // Explicit converions (From section 5.4.1 Conversion and scalar constructors of GLSL 1.30.08 specification)

    @JvmOverloads
    constructor(x: Number, y: Number = x, z: Number = x) : this(x.s, y.s, z.s)

    constructor(x: Vec1t<out Number>, y: Number, z: Number) : this(x.x, y, z)
    constructor(x: Number, y: Vec1t<out Number>, z: Number) : this(x, y.x, z)
    constructor(x: Vec1t<out Number>, y: Vec1t<out Number>, z: Number) : this(x.x, y.x, z)
    constructor(x: Number, y: Number, z: Vec1t<out Number>) : this(x, y, z.x)
    constructor(x: Vec1t<out Number>, y: Number, z: Vec1t<out Number>) : this(x.x, y, z.x)
    constructor(x: Number, y: Vec1t<out Number>, z: Vec1t<out Number>) : this(x, y.x, z.x)
    constructor(x: Vec1t<out Number>, y: Vec1t<out Number>, z: Vec1t<out Number>) : this(x.x, y.x, z.x)

    // -- Conversion vector constructors --

    // Explicit conversions (From section 5.4.1 Conversion and scalar constructors of GLSL 1.30.08 specification)

    @JvmOverloads
    constructor(xy: Vec2t<out Number>, z: Number = 0) : this(xy.x, xy.y, z)
    constructor(xy: Vec2t<out Number>, z: Vec1t<out Number>) : this(xy.x, xy.y, z.x)
    constructor(x: Number, yz: Vec2t<out Number>) : this(x, yz.x, yz.y)
    constructor(x: Vec1t<out Number>, yz: Vec2t<out Number>) : this(x.x, yz.x, yz.y)
    constructor(v: Vec3t<out Number>) : this(v.x, v.y, v.z)
    constructor(v: Vec4t<out Number>) : this(v.x, v.y, v.z)

    constructor(v: Vec1bool) : this(v.x.s, 0, 0)
    constructor(v: Vec2bool) : this(v.x.s, v.y.s, 0)
    constructor(v: Vec3bool) : this(v.x.s, v.y.s, v.z.s)
    constructor(v: Vec4bool) : this(v.x.s, v.y.s, v.z.s)

    constructor(bytes: ByteArray, index: Int = 0, oneByteOneShort: Boolean = false, bigEndian: Boolean = true) : this(
            if (oneByteOneShort) bytes[index].s else bytes.getShort(index, bigEndian),
            if (oneByteOneShort) bytes[index + 1].s else bytes.getShort(index + Int.BYTES, bigEndian),
            if (oneByteOneShort) bytes[index + 2].s else bytes.getShort(index + Int.BYTES * 2, bigEndian))

    constructor(chars: CharArray, index: Int = 0) : this(chars[index].s, chars[index + 1].s, chars[index + 2].s)
    constructor(shorts: ShortArray, index: Int = 0) : this(shorts[index], shorts[index + 1], shorts[index + 2])
    constructor(ints: IntArray, index: Int = 0) : this(ints[index], ints[index + 1], ints[index + 2])
    constructor(longs: LongArray, index: Int = 0) : this(longs[index], longs[index + 1], longs[index + 2])
    constructor(floats: FloatArray, index: Int = 0) : this(floats[index], floats[index + 1], floats[index + 2])
    constructor(doubles: DoubleArray, index: Int = 0) : this(doubles[index], doubles[index + 1], doubles[index + 2])
    constructor(booleans: BooleanArray, index: Int = 0) : this(booleans[index].s, booleans[index + 1].s, booleans[index + 2].s)

    constructor(numbers: Array<out Number>, index: Int = 0) : this(numbers[index], numbers[index + 1], numbers[index + 2])
    constructor(chars: Array<Char>, index: Int = 0) : this(chars[index].s, chars[index + 1].s, chars[index + 2].s)
    constructor(booleans: Array<Boolean>, index: Int = 0) : this(booleans[index].s, booleans[index + 1].s, booleans[index + 2].s)

    constructor(list: Iterable<*>, index: Int = 0) : this(list.elementAt(index)!!.toShort, list.elementAt(index + 1)!!.toShort,
            list.elementAt(index + 2)!!.toShort)

    constructor(bytes: ByteBuffer, index: Int = bytes.pos, oneByteOneShort: Boolean = false) : this(
            if (oneByteOneShort) bytes[index].s else bytes.getShort(index),
            if (oneByteOneShort) bytes[index + 1].s else bytes.getShort(index + Int.BYTES),
            if (oneByteOneShort) bytes[index + 2].s else bytes.getShort(index + Int.BYTES * 2))

    constructor(chars: CharBuffer, index: Int = chars.pos) : this(chars[index].s, chars[index + 1].s, chars[index + 2].s)
    constructor(shorts: ShortBuffer, index: Int = shorts.pos) : this(shorts[index], shorts[index + 1], shorts[index + 2])
    constructor(ints: IntBuffer, index: Int = ints.pos) : this(ints[index], ints[index + 1], ints[index + 2])
    constructor(longs: LongBuffer, index: Int = longs.pos) : this(longs[index], longs[index + 1], longs[index + 2])
    constructor(floats: FloatBuffer, index: Int = floats.pos) : this(floats[index], floats[index + 1], floats[index + 2])
    constructor(doubles: DoubleBuffer, index: Int = doubles.pos) : this(doubles[index], doubles[index + 1], doubles[index + 2])

    constructor(block: (Int) -> Short) : this(block(0), block(1), block(2))


    fun set(bytes: ByteArray, index: Int = 0, oneByteOneShort: Boolean = false, bigEndian: Boolean = true) {
        x = if (oneByteOneShort) bytes[index].s else bytes.getShort(index, bigEndian)
        y = if (oneByteOneShort) bytes[index + 1].s else bytes.getShort(index + Short.BYTES, bigEndian)
        z = if (oneByteOneShort) bytes[index + 2].s else bytes.getShort(index + Short.BYTES * 2, bigEndian)
    }

    fun set(bytes: ByteBuffer, index: Int = bytes.pos, oneByteOneShort: Boolean = false) {
        x = if (oneByteOneShort) bytes[index].s else bytes.getShort(index)
        y = if (oneByteOneShort) bytes[index + 1].s else bytes.getShort(index + Short.BYTES)
        z = if (oneByteOneShort) bytes[index + 2].s else bytes.getShort(index + Short.BYTES * 2)
    }


    fun put(x: Short, y: Short, z: Short) {
        this.x = x
        this.y = y
        this.z = z
    }

    operator fun invoke(x: Short, y: Short, z: Short): Vec3s {
        this.x = x
        this.y = y
        this.z = z
        return this
    }

    override fun put(x: Number, y: Number, z: Number) {
        this.x = x.s
        this.y = y.s
        this.z = z.s
    }

    override operator fun invoke(x: Number, y: Number, z: Number): Vec3s {
        this.x = x.s
        this.y = y.s
        this.z = z.s
        return this
    }

    fun to(bytes: ByteArray, index: Int): ByteArray = to(bytes, index, true)
    override fun to(bytes: ByteArray, index: Int, bigEndian: Boolean): ByteArray {
        bytes.putShort(index, x, bigEndian)
        bytes.putShort(index + Short.BYTES, y, bigEndian)
        bytes.putShort(index + Short.BYTES * 2, z, bigEndian)
        return bytes
    }

    fun toShortArray(): ShortArray = to(ShortArray(length), 0)
    infix fun to(shorts: ShortArray): ShortArray = to(shorts, 0)
    fun to(shorts: ShortArray, index: Int): ShortArray {
        System.arraycopy(array, ofs, shorts, index, length)
        return shorts
    }

    override fun to(buf: ByteBuffer, offset: Int): ByteBuffer {
        buf.putShort(offset, x)
        buf.putShort(offset + Short.BYTES, y)
        buf.putShort(offset + Short.BYTES * 2, z)
        return buf
    }

    fun toShortBufferStack(): ShortBuffer = to(MemoryStack.stackPush().mallocShort(length), 0)
    infix fun toShortBuffer(stack: MemoryStack): ShortBuffer = to(stack.mallocShort(length), 0)
    fun toShortBuffer(): ShortBuffer = to(ShortBuffer(length), 0)
    infix fun to(shorts: ShortBuffer): ShortBuffer = to(shorts, shorts.pos)
    fun to(shorts: ShortBuffer, index: Int): ShortBuffer {
        shorts[index] = x
        shorts[index + 1] = y
        shorts[index + 2] = z
        return shorts
    }

    infix fun to(ptr: Ptr) {
        memPutShort(ptr, x)
        memPutShort(ptr + Short.BYTES, y)
        memPutShort(ptr + Short.BYTES * 2, z)
    }

    // -- Component accesses --

    operator fun set(index: Int, value: Short) = when (index) {
        0 -> x = value
        1 -> y = value
        2 -> z = value
        else -> throw ArrayIndexOutOfBoundsException()
    }

    override operator fun set(index: Int, value: Number) = when (index) {
        0 -> x = value.s
        1 -> y = value.s
        2 -> z = value.s
        else -> throw ArrayIndexOutOfBoundsException()
    }


    // -- Unary arithmetic operators --

    operator fun unaryPlus() = this

    operator fun unaryMinus() = Vec3s(-x, -y, -z)


    // -- Increment main.and decrement operators --

    operator fun inc(res: Vec3s = Vec3s()) = plus(res, this, 1, 1, 1)
    fun incAssign() = plus(this, this, 1, 1, 1)


    operator fun dec(res: Vec3s = Vec3s()) = minus(res, this, 1, 1, 1)
    fun decAssign() = minus(this, this, 1, 1, 1)


    // -- Specific binary arithmetic operators --

    operator fun plus(b: Short) = plus(Vec3s(), this, b, b, b)
    operator fun plus(b: Int) = plus(Vec3s(), this, b, b, b)
    operator fun plus(b: Vec3s) = plus(Vec3s(), this, b.x, b.y, b.z)

    fun plus(bX: Short, bY: Short, bZ: Short, res: Vec3s = Vec3s()) = plus(res, this, bX, bY, bZ)
    fun plus(bX: Int, bY: Int, bZ: Int, res: Vec3s = Vec3s()) = plus(res, this, bX, bY, bZ)
    fun plus(b: Short, res: Vec3s = Vec3s()) = plus(res, this, b, b, b)
    fun plus(b: Int, res: Vec3s = Vec3s()) = plus(res, this, b, b, b)
    fun plus(b: Vec3s, res: Vec3s = Vec3s()) = plus(res, this, b.x, b.y, b.z)

    fun plusAssign(bX: Short, bY: Short, bZ: Short) = plus(this, this, bX, bY, bZ)
    fun plusAssign(bX: Int, bY: Int, bZ: Int) = plus(this, this, bX, bY, bZ)
    infix fun plusAssign(b: Short) = plus(this, this, b, b, b)
    infix fun plusAssign(b: Int) = plus(this, this, b, b, b)
    infix fun plusAssign(b: Vec3s) = plus(this, this, b.x, b.y, b.z)


    operator fun minus(b: Short) = minus(Vec3s(), this, b, b, b)
    operator fun minus(b: Int) = minus(Vec3s(), this, b, b, b)
    operator fun minus(b: Vec3s) = minus(Vec3s(), this, b.x, b.y, b.z)

    fun minus(bX: Short, bY: Short, bZ: Short, res: Vec3s = Vec3s()) = minus(res, this, bX, bY, bZ)
    fun minus(bX: Int, bY: Int, bZ: Int, res: Vec3s = Vec3s()) = minus(res, this, bX, bY, bZ)
    fun minus(b: Short, res: Vec3s = Vec3s()) = minus(res, this, b, b, b)
    fun minus(b: Int, res: Vec3s = Vec3s()) = minus(res, this, b, b, b)
    fun minus(b: Vec3s, res: Vec3s = Vec3s()) = minus(res, this, b.x, b.y, b.z)

    fun minusAssign(bX: Short, bY: Short, bZ: Short) = minus(this, this, bX, bY, bZ)
    fun minusAssign(bX: Int, bY: Int, bZ: Int) = minus(this, this, bX, bY, bZ)
    infix fun minusAssign(b: Short) = minus(this, this, b, b, b)
    infix fun minusAssign(b: Int) = minus(this, this, b, b, b)
    infix fun minusAssign(b: Vec3s) = minus(this, this, b.x, b.y, b.z)


    operator fun times(b: Short) = times(Vec3s(), this, b, b, b)
    operator fun times(b: Int) = times(Vec3s(), this, b, b, b)
    operator fun times(b: Vec3s) = times(Vec3s(), this, b.x, b.y, b.z)

    fun times(bX: Short, bY: Short, bZ: Short, res: Vec3s = Vec3s()) = times(res, this, bX, bY, bZ)
    fun times(bX: Int, bY: Int, bZ: Int, res: Vec3s = Vec3s()) = times(res, this, bX, bY, bZ)
    fun times(b: Short, res: Vec3s = Vec3s()) = times(res, this, b, b, b)
    fun times(b: Int, res: Vec3s = Vec3s()) = times(res, this, b, b, b)
    fun times(b: Vec3s, res: Vec3s = Vec3s()) = times(res, this, b.x, b.y, b.z)

    fun timesAssign(bX: Short, bY: Short, bZ: Short) = times(this, this, bX, bY, bZ)
    fun timesAssign(bX: Int, bY: Int, bZ: Int) = times(this, this, bX, bY, bZ)
    infix fun timesAssign(b: Short) = times(this, this, b, b, b)
    infix fun timesAssign(b: Int) = times(this, this, b, b, b)
    infix fun timesAssign(b: Vec3s) = times(this, this, b.x, b.y, b.z)


    operator fun div(b: Short) = div(Vec3s(), this, b, b, b)
    operator fun div(b: Int) = div(Vec3s(), this, b, b, b)
    operator fun div(b: Vec3s) = div(Vec3s(), this, b.x, b.y, b.z)

    fun div(bX: Short, bY: Short, bZ: Short, res: Vec3s = Vec3s()) = div(res, this, bX, bY, bZ)
    fun div(bX: Int, bY: Int, bZ: Int, res: Vec3s = Vec3s()) = div(res, this, bX, bY, bZ)
    fun div(b: Short, res: Vec3s) = div(res, this, b, b, b)
    fun div(b: Int, res: Vec3s) = div(res, this, b, b, b)
    fun div(b: Vec3s, res: Vec3s) = div(res, this, b.x, b.y, b.z)

    fun divAssign(bX: Short, bY: Short, bZ: Short) = div(this, this, bX, bY, bZ)
    fun divAssign(bX: Int, bY: Int, bZ: Int) = div(this, this, bX, bY, bZ)
    infix fun divAssign(b: Short) = div(this, this, b, b, b)
    infix fun divAssign(b: Int) = div(this, this, b, b, b)
    infix fun divAssign(b: Vec3s) = div(this, this, b.x, b.y, b.z)


    operator fun rem(b: Short) = rem(Vec3s(), this, b, b, b)
    operator fun rem(b: Int) = rem(Vec3s(), this, b, b, b)
    operator fun rem(b: Vec3s) = rem(Vec3s(), this, b.x, b.y, b.z)

    fun rem(bX: Short, bY: Short, bZ: Short, res: Vec3s = Vec3s()) = rem(res, this, bX, bY, bZ)
    fun rem(bX: Int, bY: Int, bZ: Int, res: Vec3s = Vec3s()) = rem(res, this, bX, bY, bZ)
    fun rem(b: Short, res: Vec3s) = rem(res, this, b, b, b)
    fun rem(b: Int, res: Vec3s) = rem(res, this, b, b, b)
    fun rem(b: Vec3s, res: Vec3s) = rem(res, this, b.x, b.y, b.z)

    fun remAssign(bX: Short, bY: Short, bZ: Short) = rem(this, this, bX, bY, bZ)
    fun remAssign(bX: Int, bY: Int, bZ: Int) = rem(this, this, bX, bY, bZ)
    infix fun remAssign(b: Short) = rem(this, this, b, b, b)
    infix fun remAssign(b: Int) = rem(this, this, b, b, b)
    infix fun remAssign(b: Vec3s) = rem(this, this, b.x, b.y, b.z)


    // -- Generic binary arithmetic operators --

    operator fun plus(b: Number) = plus(Vec3s(), this, b.s, b.s, b.s)
    operator fun plus(b: Vec3t<out Number>) = plus(Vec3s(), this, b.x.s, b.y.s, b.z.s)

    fun plus(bX: Number, bY: Number, bZ: Number, res: Vec3s = Vec3s()) = plus(res, this, bX.s, bY.s, bZ.s)
    fun plus(b: Number, res: Vec3s = Vec3s()) = plus(res, this, b.s, b.s, b.s)
    fun plus(b: Vec3t<out Number>, res: Vec3s = Vec3s()) = plus(res, this, b.x.s, b.y.s, b.z.s)

    fun plusAssign(bX: Number, bY: Number, bZ: Number) = plus(this, this, bX.s, bY.s, bZ.s)
    infix fun plusAssign(b: Number) = plus(this, this, b.s, b.s, b.s)
    infix fun plusAssign(b: Vec3t<out Number>) = plus(this, this, b.x.s, b.y.s, b.z.s)


    operator fun minus(b: Number) = minus(Vec3s(), this, b.s, b.s, b.s)
    operator fun minus(b: Vec3t<out Number>) = minus(Vec3s(), this, b.x.s, b.y.s, b.z.s)

    fun minus(bX: Number, bY: Number, bZ: Number, res: Vec3s = Vec3s()) = minus(res, this, bX.s, bY.s, bZ.s)
    fun minus(b: Number, res: Vec3s = Vec3s()) = minus(res, this, b.s, b.s, b.s)
    fun minus(b: Vec3t<out Number>, res: Vec3s = Vec3s()) = minus(res, this, b.x.s, b.y.s, b.z.s)

    fun minusAssign(bX: Number, bY: Number, bZ: Number) = minus(this, this, bX.s, bY.s, bZ.s)
    infix fun minusAssign(b: Number) = minus(this, this, b.s, b.s, b.s)
    infix fun minusAssign(b: Vec3t<out Number>) = minus(this, this, b.x.s, b.y.s, b.z.s)


    operator fun times(b: Number) = times(Vec3s(), this, b.s, b.s, b.s)
    operator fun times(b: Vec3t<out Number>) = times(Vec3s(), this, b.x.s, b.y.s, b.z.s)

    fun times(bX: Number, bY: Number, bZ: Number, res: Vec3s = Vec3s()) = times(res, this, bX.s, bY.s, bZ.s)
    fun times(b: Number, res: Vec3s = Vec3s()) = times(res, this, b.s, b.s, b.s)
    fun times(b: Vec3t<out Number>, res: Vec3s = Vec3s()) = times(res, this, b.x.s, b.y.s, b.z.s)

    fun timesAssign(bX: Number, bY: Number, bZ: Number) = times(this, this, bX.s, bY.s, bZ.s)
    infix fun timesAssign(b: Number) = times(this, this, b.s, b.s, b.s)
    infix fun timesAssign(b: Vec3t<out Number>) = times(this, this, b.x.s, b.y.s, b.z.s)


    operator fun div(b: Number) = div(Vec3s(), this, b.s, b.s, b.s)
    operator fun div(b: Vec3t<out Number>) = div(Vec3s(), this, b.x.s, b.y.s, b.z.s)

    fun div(bX: Number, bY: Number, bZ: Number, res: Vec3s = Vec3s()) = div(res, this, bX.s, bY.s, bZ.s)
    fun div(b: Number, res: Vec3s) = div(res, this, b.s, b.s, b.s)
    fun div(b: Vec3t<out Number>, res: Vec3s) = div(res, this, b.x.s, b.y.s, b.z.s)

    fun divAssign(bX: Number, bY: Number, bZ: Number) = div(this, this, bX.s, bY.s, bZ.s)
    infix fun divAssign(b: Number) = div(this, this, b.s, b.s, b.s)
    infix fun divAssign(b: Vec3t<out Number>) = div(this, this, b.x.s, b.y.s, b.z.s)


    operator fun rem(b: Number) = rem(Vec3s(), this, b.s, b.s, b.s)
    operator fun rem(b: Vec3t<out Number>) = rem(Vec3s(), this, b.x.s, b.y.s, b.z.s)

    fun rem(bX: Number, bY: Number, bZ: Number, res: Vec3s = Vec3s()) = rem(res, this, bX.s, bY.s, bZ.s)
    fun rem(b: Number, res: Vec3s) = rem(res, this, b.s, b.s, b.s)
    fun rem(b: Vec3t<out Number>, res: Vec3s) = rem(res, this, b.x.s, b.y.s, b.z.s)

    fun remAssign(bX: Number, bY: Number, bZ: Number) = rem(this, this, bX.s, bY.s, bZ.s)
    infix fun remAssign(b: Number) = rem(this, this, b.s, b.s, b.s)
    infix fun remAssign(b: Vec3t<out Number>) = rem(this, this, b.x.s, b.y.s, b.z.s)


    // -- Specific bitwise operators --

    infix fun and(b: Short) = and(Vec3s(), this, b, b, b)
    infix fun and(b: Int) = and(Vec3s(), this, b, b, b)
    infix fun and(b: Vec3s) = and(Vec3s(), this, b.x, b.y, b.z)

    infix fun andAssign(b: Short) = and(this, this, b, b, b)
    infix fun andAssign(b: Int) = and(this, this, b, b, b)
    infix fun andAssign(b: Vec3s) = and(this, this, b.x, b.y, b.z)

    fun and(b: Short, res: Vec3s) = and(res, this, b, b, b)
    fun and(b: Int, res: Vec3s) = and(res, this, b, b, b)
    fun and(b: Vec3s, res: Vec3s) = and(res, this, b.x, b.y, b.z)

    fun and(bX: Short, bY: Short, bZ: Short, res: Vec3s = Vec3s()) = and(res, this, bX, bY, bZ)
    fun and(bX: Int, bY: Int, bZ: Int, res: Vec3s = Vec3s()) = and(res, this, bX, bY, bZ)

    fun andAssign(bX: Short, bY: Short, bZ: Short) = and(this, this, bX, bY, bZ)
    fun andAssign(bX: Int, bY: Int, bZ: Int) = and(this, this, bX, bY, bZ)


    infix fun or(b: Short) = or(Vec3s(), this, b, b, b)
    infix fun or(b: Int) = or(Vec3s(), this, b, b, b)
    infix fun or(b: Vec3s) = or(Vec3s(), this, b.x, b.y, b.z)

    infix fun orAssign(b: Short) = or(this, this, b, b, b)
    infix fun orAssign(b: Int) = or(this, this, b, b, b)
    infix fun orAssign(b: Vec3s) = or(this, this, b.x, b.y, b.z)

    fun or(b: Short, res: Vec3s) = or(res, this, b, b, b)
    fun or(b: Int, res: Vec3s) = or(res, this, b, b, b)
    fun or(b: Vec3s, res: Vec3s) = or(res, this, b.x, b.y, b.z)

    fun or(bX: Short, bY: Short, bZ: Short, res: Vec3s = Vec3s()) = or(res, this, bX, bY, bZ)
    fun or(bX: Int, bY: Int, bZ: Int, res: Vec3s = Vec3s()) = or(res, this, bX, bY, bZ)

    fun orAssign(bX: Short, bY: Short, bZ: Short) = or(this, this, bX, bY, bZ)
    fun orAssign(bX: Int, bY: Int, bZ: Int) = or(this, this, bX, bY, bZ)


    infix fun xor(b: Short) = xor(Vec3s(), this, b, b, b)
    infix fun xor(b: Int) = xor(Vec3s(), this, b, b, b)
    infix fun xor(b: Vec3s) = xor(Vec3s(), this, b.x, b.y, b.z)

    infix fun xorAssign(b: Short) = xor(this, this, b, b, b)
    infix fun xorAssign(b: Int) = xor(this, this, b, b, b)
    infix fun xorAssign(b: Vec3s) = xor(this, this, b.x, b.y, b.z)

    fun xor(b: Short, res: Vec3s) = xor(res, this, b, b, b)
    fun xor(b: Int, res: Vec3s) = xor(res, this, b, b, b)
    fun xor(b: Vec3s, res: Vec3s) = xor(res, this, b.x, b.y, b.z)

    fun xor(bX: Short, bY: Short, bZ: Short, res: Vec3s = Vec3s()) = xor(res, this, bX, bY, bZ)
    fun xor(bX: Int, bY: Int, bZ: Int, res: Vec3s = Vec3s()) = xor(res, this, bX, bY, bZ)

    fun xorAssign(bX: Short, bY: Short, bZ: Short) = xor(this, this, bX, bY, bZ)
    fun xorAssign(bX: Int, bY: Int, bZ: Int) = xor(this, this, bX, bY, bZ)


    infix fun shl(b: Short) = shl(Vec3s(), this, b, b, b)
    infix fun shl(b: Int) = shl(Vec3s(), this, b, b, b)
    infix fun shl(b: Vec3s) = shl(Vec3s(), this, b.x, b.y, b.z)

    infix fun shlAssign(b: Short) = shl(this, this, b, b, b)
    infix fun shlAssign(b: Int) = shl(this, this, b, b, b)
    infix fun shlAssign(b: Vec3s) = shl(this, this, b.x, b.y, b.z)

    fun shl(b: Short, res: Vec3s) = shl(res, this, b, b, b)
    fun shl(b: Int, res: Vec3s) = shl(res, this, b, b, b)
    fun shl(b: Vec3s, res: Vec3s) = shl(res, this, b.x, b.y, b.z)

    fun shl(bX: Short, bY: Short, bZ: Short, res: Vec3s = Vec3s()) = shl(res, this, bX, bY, bZ)
    fun shl(bX: Int, bY: Int, bZ: Int, res: Vec3s = Vec3s()) = shl(res, this, bX, bY, bZ)

    fun shlAssign(bX: Short, bY: Short, bZ: Short) = shl(this, this, bX, bY, bZ)
    fun shlAssign(bX: Int, bY: Int, bZ: Int) = shl(this, this, bX, bY, bZ)


    infix fun shr(b: Short) = shr(Vec3s(), this, b, b, b)
    infix fun shr(b: Int) = shr(Vec3s(), this, b, b, b)
    infix fun shr(b: Vec3s) = shr(Vec3s(), this, b.x, b.y, b.z)

    infix fun shrAssign(b: Short) = shr(this, this, b, b, b)
    infix fun shrAssign(b: Int) = shr(this, this, b, b, b)
    infix fun shrAssign(b: Vec3s) = shr(this, this, b.x, b.y, b.z)

    fun shr(b: Short, res: Vec3s) = shr(res, this, b, b, b)
    fun shr(b: Int, res: Vec3s) = shr(res, this, b, b, b)
    fun shr(b: Vec3s, res: Vec3s) = shr(res, this, b.x, b.y, b.z)

    fun shr(bX: Short, bY: Short, bZ: Short, res: Vec3s = Vec3s()) = shr(res, this, bX, bY, bZ)
    fun shr(bX: Int, bY: Int, bZ: Int, res: Vec3s = Vec3s()) = shr(res, this, bX, bY, bZ)

    fun shrAssign(bX: Short, bY: Short, bZ: Short) = shr(this, this, bX, bY, bZ)
    fun shrAssign(bX: Int, bY: Int, bZ: Int) = shr(this, this, bX, bY, bZ)


    fun inv(res: Vec3s = Vec3s()) = inv(res, this)
    fun invAssign() = inv(this, this)


    // -- Generic bitwise operators --

    infix fun and(b: Number) = and(Vec3s(), this, b.s, b.s, b.s)
    infix fun and(b: Vec3t<out Number>) = and(Vec3s(), this, b.x.s, b.y.s, b.z.s)

    infix fun andAssign(b: Number) = and(this, this, b.s, b.s, b.s)
    infix fun andAssign(b: Vec3t<out Number>) = and(this, this, b.x.s, b.y.s, b.z.s)

    fun and(b: Number, res: Vec3s) = and(res, this, b.s, b.s, b.s)
    fun and(b: Vec3t<out Number>, res: Vec3s) = and(res, this, b.x.s, b.y.s, b.z.s)

    fun and(bX: Number, bY: Number, bZ: Number, res: Vec3s = Vec3s()) = and(res, this, bX.s, bY.s, bZ.s)

    fun andAssign(bX: Number, bY: Number, bZ: Number) = and(this, this, bX.s, bY.s, bZ.s)


    infix fun or(b: Number) = or(Vec3s(), this, b.s, b.s, b.s)
    infix fun or(b: Vec3t<out Number>) = or(Vec3s(), this, b.x.s, b.y.s, b.z.s)

    infix fun orAssign(b: Number) = or(this, this, b.s, b.s, b.s)
    infix fun orAssign(b: Vec3t<out Number>) = or(this, this, b.x.s, b.y.s, b.z.s)

    fun or(b: Number, res: Vec3s) = or(res, this, b.s, b.s, b.s)
    fun or(b: Vec3t<out Number>, res: Vec3s) = or(res, this, b.x.s, b.y.s, b.z.s)

    fun or(bX: Number, bY: Number, bZ: Number, res: Vec3s = Vec3s()) = or(res, this, bX.s, bY.s, bZ.s)

    fun orAssign(bX: Number, bY: Number, bZ: Number) = or(this, this, bX.s, bY.s, bZ.s)


    infix fun xor(b: Number) = xor(Vec3s(), this, b.s, b.s, b.s)
    infix fun xor(b: Vec3t<out Number>) = xor(Vec3s(), this, b.x.s, b.y.s, b.z.s)

    infix fun xorAssign(b: Number) = xor(this, this, b.s, b.s, b.s)
    infix fun xorAssign(b: Vec3t<out Number>) = xor(this, this, b.x.s, b.y.s, b.z.s)

    fun xor(b: Number, res: Vec3s) = xor(res, this, b.s, b.s, b.s)
    fun xor(b: Vec3t<out Number>, res: Vec3s) = xor(res, this, b.x.s, b.y.s, b.z.s)

    fun xor(bX: Number, bY: Number, bZ: Number, res: Vec3s = Vec3s()) = xor(res, this, bX.s, bY.s, bZ.s)

    fun xorAssign(bX: Number, bY: Number, bZ: Number) = xor(this, this, bX.s, bY.s, bZ.s)


    infix fun shl(b: Number) = shl(Vec3s(), this, b.s, b.s, b.s)
    infix fun shl(b: Vec3t<out Number>) = shl(Vec3s(), this, b.x.s, b.y.s, b.z.s)

    infix fun shlAssign(b: Number) = shl(this, this, b.s, b.s, b.s)
    infix fun shlAssign(b: Vec3t<out Number>) = shl(this, this, b.x.s, b.y.s, b.z.s)

    fun shl(b: Number, res: Vec3s) = shl(res, this, b.s, b.s, b.s)
    fun shl(b: Vec3t<out Number>, res: Vec3s) = shl(res, this, b.x.s, b.y.s, b.z.s)

    fun shl(bX: Number, bY: Number, bZ: Number, res: Vec3s = Vec3s()) = shl(res, this, bX.s, bY.s, bZ.s)

    fun shlAssign(bX: Number, bY: Number, bZ: Number) = shl(this, this, bX.s, bY.s, bZ.s)


    infix fun shr(b: Number) = shr(Vec3s(), this, b.s, b.s, b.s)
    infix fun shr(b: Vec3t<out Number>) = shr(Vec3s(), this, b.x.s, b.y.s, b.z.s)

    infix fun shrAssign(b: Number) = shr(this, this, b.s, b.s, b.s)
    infix fun shrAssign(b: Vec3t<out Number>) = shr(this, this, b.x.s, b.y.s, b.z.s)

    fun shr(b: Number, res: Vec3s) = shr(res, this, b.s, b.s, b.s)
    fun shr(b: Vec3t<out Number>, res: Vec3s) = shr(res, this, b.x.s, b.y.s, b.z.s)

    fun shr(bX: Number, bY: Number, bZ: Number, res: Vec3s = Vec3s()) = shr(res, this, bX.s, bY.s, bZ.s)

    fun shrAssign(bX: Number, bY: Number, bZ: Number) = shr(this, this, bX.s, bY.s, bZ.s)


    override fun createInstance(x: Short, y: Short) = Vec2s(x, y)
    override fun createInstance(x: Short, y: Short, z: Short) = Vec3s(x, y, z)


    companion object : vec3s_operators {
        const val length = Vec3t.length
        @JvmField
        val size = length * Short.BYTES

        @JvmStatic
        fun fromPointer(ptr: Ptr) = Vec3s(memGetShort(ptr), memGetShort(ptr + Short.BYTES), memGetShort(ptr + Short.BYTES * 2))
    }

    override fun size() = size

    override fun equals(other: Any?) = other is Vec3s && this[0] == other[0] && this[1] == other[1] && this[2] == other[2]
    override fun hashCode() = 31 * (31 * x.hashCode() + y.hashCode()) + z.hashCode()

    @JvmOverloads
    fun print(name: String = "", stream: PrintStream = System.out) = stream.print("$name$this")

    @JvmOverloads
    fun println(name: String = "", stream: PrintStream = System.out) = stream.println("$name$this")

    override fun toString(): String = "($x, $y, $z)"
}