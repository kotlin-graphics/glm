package glm_.vec3

import glm_.*
import glm_.vec1.Vec1bool
import glm_.vec1.Vec1t
import glm_.vec2.Vec2bool
import glm_.vec2.Vec2i
import glm_.vec2.Vec2t
import glm_.vec3.operators.vec3i_operators
import glm_.vec4.Vec4bool
import glm_.vec4.Vec4t
import kool.Ptr
import kool.IntBuffer
import kool.pos
import kool.set
import org.lwjgl.system.MemoryStack
import org.lwjgl.system.MemoryUtil.memGetInt
import org.lwjgl.system.MemoryUtil.memPutInt
import java.io.PrintStream
import java.nio.*

/**
 * Created by elect on 08/10/16.
 */

class Vec3i(var ofs: Int, var array: IntArray) : Vec3t<Int>(), ToBuffer {

    override var x: Int
        get() = array[ofs]
        set(value) = array.set(ofs, value)
    override var y: Int
        get() = array[ofs + 1]
        set(value) = array.set(ofs + 1, value)
    override var z: Int
        get() = array[ofs + 2]
        set(value) = array.set(ofs + 2, value)

    // -- Implicit basic constructors --

    constructor() : this(0, 0, 0)
    constructor(v: Vec3i) : this(v.x, v.y, v.z)

    // -- Explicit basic constructors --

    @JvmOverloads
    constructor(x: Int, y: Int = x, z: Int = x) : this(0, intArrayOf(x.i, y.i, z.i))

    // -- Conversion constructors --

    @JvmOverloads
    constructor(x: Number, y: Number = x, z: Number = x) : this(x.i, y.i, z.i)

    @JvmOverloads
    constructor(xy: Vec2t<out Number>, z: Number = 0) : this(xy.x, xy.y, z)
    constructor(xy: Vec2t<out Number>, z: Vec1t<out Number>) : this(xy.x, xy.y, z.x)
    constructor(x: Number, yz: Vec2t<out Number>) : this(x, yz.x, yz.y)
    constructor(x: Vec1t<out Number>, yz: Vec2t<out Number>) : this(x.x, yz.x, yz.y)
    constructor(v: Vec3t<out Number>) : this(v.x, v.y, v.z)
    constructor(v: Vec4t<out Number>) : this(v.x, v.y, v.z)

    constructor(v: Vec1bool) : this(v.x.i, 0, 0)
    constructor(v: Vec2bool) : this(v.x.i, v.y.i, 0)
    constructor(v: Vec3bool) : this(v.x.i, v.y.i, v.z.i)
    constructor(v: Vec4bool) : this(v.x.i, v.y.i, v.z.i)

    constructor(bytes: ByteArray, index: Int = 0, oneByteOneInt: Boolean = false, bigEndian: Boolean = true) : this(
            if (oneByteOneInt) bytes[index].i else bytes.getInt(index, bigEndian),
            if (oneByteOneInt) bytes[index + 1].i else bytes.getInt(index + Int.BYTES, bigEndian),
            if (oneByteOneInt) bytes[index + 2].i else bytes.getInt(index + Int.BYTES * 2, bigEndian))

    constructor(chars: CharArray, index: Int = 0) : this(chars[index].i, chars[index + 1].i, chars[index + 2].i)
    constructor(shorts: ShortArray, index: Int = 0) : this(shorts[index], shorts[index + 1], shorts[index + 2])
    constructor(ints: IntArray, index: Int = 0) : this(ints[index], ints[index + 1], ints[index + 2])
    constructor(longs: LongArray, index: Int = 0) : this(longs[index], longs[index + 1], longs[index + 2])
    constructor(floats: FloatArray, index: Int = 0) : this(floats[index], floats[index + 1], floats[index + 2])
    constructor(doubles: DoubleArray, index: Int = 0) : this(doubles[index], doubles[index + 1], doubles[index + 2])
    constructor(booleans: BooleanArray, index: Int = 0) : this(booleans[index].i, booleans[index + 1].i, booleans[index + 2].i)

    constructor(numbers: Array<out Number>, index: Int = 0) : this(numbers[index], numbers[index + 1], numbers[index + 2])
    constructor(chars: Array<Char>, index: Int = 0) : this(chars[index].i, chars[index + 1].i, chars[index + 2].i)
    constructor(booleans: Array<Boolean>, index: Int = 0) : this(booleans[index].i, booleans[index + 1].i, booleans[index + 2].i)

    constructor(list: Iterable<*>, index: Int = 0) : this(list.elementAt(index)!!.toInt, list.elementAt(index + 1)!!.toInt,
            list.elementAt(index + 2)!!.toInt)

    constructor(bytes: ByteBuffer, index: Int = bytes.pos, oneByteOneInt: Boolean = false) : this(
            if (oneByteOneInt) bytes[index].i else bytes.getInt(index),
            if (oneByteOneInt) bytes[index + 1].i else bytes.getInt(index + Int.BYTES),
            if (oneByteOneInt) bytes[index + 2].i else bytes.getInt(index + Int.BYTES * 2))

    constructor(chars: CharBuffer, index: Int = chars.pos) : this(chars[index].i, chars[index + 1].i, chars[index + 2].i)
    constructor(shorts: ShortBuffer, index: Int = shorts.pos) : this(shorts[index], shorts[index + 1], shorts[index + 2])
    constructor(ints: IntBuffer, index: Int = ints.pos) : this(ints[index], ints[index + 1], ints[index + 2])
    constructor(longs: LongBuffer, index: Int = longs.pos) : this(longs[index], longs[index + 1], longs[index + 2])
    constructor(floats: FloatBuffer, index: Int = floats.pos) : this(floats[index], floats[index + 1], floats[index + 2])
    constructor(doubles: DoubleBuffer, index: Int = doubles.pos) : this(doubles[index], doubles[index + 1], doubles[index + 2])

    constructor(block: (Int) -> Int) : this(block(0), block(1), block(2))


    fun set(bytes: ByteArray, index: Int = 0, oneByteOneInt: Boolean = false, bigEndian: Boolean = true) {
        x = if (oneByteOneInt) bytes[index].i else bytes.getInt(index, bigEndian)
        y = if (oneByteOneInt) bytes[index + 1].i else bytes.getInt(index + Int.BYTES, bigEndian)
        z = if (oneByteOneInt) bytes[index + 2].i else bytes.getInt(index + Int.BYTES * 2, bigEndian)
    }

    fun set(bytes: ByteBuffer, index: Int = bytes.pos, oneByteOneInt: Boolean = false) {
        x = if (oneByteOneInt) bytes[index].i else bytes.getInt(index)
        y = if (oneByteOneInt) bytes[index + 1].i else bytes.getInt(index + Int.BYTES)
        z = if (oneByteOneInt) bytes[index + 2].i else bytes.getInt(index + Int.BYTES * 2)
    }


    fun put(x: Int, y: Int, z: Int) {
        this.x = x
        this.y = y
        this.z = z
    }

    operator fun invoke(x: Int, y: Int, z: Int): Vec3i {
        this.x = x
        this.y = y
        this.z = z
        return this
    }

    override fun put(x: Number, y: Number, z: Number) {
        this.x = x.i
        this.y = y.i
        this.z = z.i
    }

    override operator fun invoke(x: Number, y: Number, z: Number): Vec3i {
        this.x = x.i
        this.y = y.i
        this.z = z.i
        return this
    }

    fun to(bytes: ByteArray, index: Int): ByteArray = to(bytes, index, true)
    override fun to(bytes: ByteArray, index: Int, bigEndian: Boolean): ByteArray {
        bytes.putInt(index, x)
        bytes.putInt(index + Int.BYTES, y)
        bytes.putInt(index + Int.BYTES * 2, z)
        return bytes
    }

    fun toIntArray(): IntArray = to(IntArray(length), 0)
    infix fun to(ints: IntArray): IntArray = to(ints, 0)
    fun to(ints: IntArray, index: Int): IntArray {
        System.arraycopy(array, ofs, ints, index, length)
        return ints
    }

    override fun to(buf: ByteBuffer, offset: Int): ByteBuffer {
        buf.putInt(offset, x)
        buf.putInt(offset + Int.BYTES, y)
        buf.putInt(offset + Int.BYTES * 2, z)
        return buf
    }

    fun toIntBufferStack(): IntBuffer = to(MemoryStack.stackPush().mallocInt(length), 0)
    infix fun toIntBuffer(stack: MemoryStack): IntBuffer = to(stack.mallocInt(length), 0)
    fun toIntBuffer(): IntBuffer = to(IntBuffer(length), 0)
    infix fun to(buf: IntBuffer): IntBuffer = to(buf, buf.pos)
    fun to(buf: IntBuffer, index: Int): IntBuffer {
        buf[index] = x
        buf[index + 1] = y
        buf[index + 2] = z
        return buf
    }

    infix fun to(ptr: Ptr) {
        memPutInt(ptr, x)
        memPutInt(ptr + Int.BYTES, y)
        memPutInt(ptr + Int.BYTES * 2, z)
    }

    // -- Component accesses --

    operator fun set(index: Int, value: Int) = when (index) {
        0 -> x = value
        1 -> y = value
        2 -> z = value
        else -> throw ArrayIndexOutOfBoundsException()
    }

    override operator fun set(index: Int, value: Number) = when (index) {
        0 -> x = value.i
        1 -> y = value.i
        2 -> z = value.i
        else -> throw ArrayIndexOutOfBoundsException()
    }


    // -- Unary arithmetic operators --

    operator fun unaryPlus() = this

    operator fun unaryMinus() = Vec3i(-x, -y, -z)

    // -- Increment main.and decrement operators --

    operator fun inc(res: Vec3i = Vec3i()) = plus(res, this, 1, 1, 1)
    fun incAssign() = plus(this, this, 1, 1, 1)


    operator fun dec(res: Vec3i = Vec3i()) = minus(res, this, 1, 1, 1)
    fun decAssign() = minus(this, this, 1, 1, 1)


    // -- Specific binary arithmetic operators --

    operator fun plus(b: Int) = plus(Vec3i(), this, b, b, b)
    operator fun plus(b: Vec3i) = plus(Vec3i(), this, b.x, b.y, b.z)

    fun plus(bX: Int, bY: Int, bZ: Int, res: Vec3i = Vec3i()) = plus(res, this, bX, bY, bZ)
    fun plus(b: Int, res: Vec3i = Vec3i()) = plus(res, this, b, b, b)
    fun plus(b: Vec3i, res: Vec3i = Vec3i()) = plus(res, this, b.x, b.y, b.z)

    fun plusAssign(bX: Int, bY: Int, bZ: Int) = plus(this, this, bX, bY, bZ)
    infix operator fun plusAssign(b: Int) {
        plus(this, this, b, b, b)
    }

    infix operator fun plusAssign(b: Vec3i) {
        plus(this, this, b.x, b.y, b.z)
    }


    operator fun minus(b: Int) = minus(Vec3i(), this, b, b, b)
    operator fun minus(b: Vec3i) = minus(Vec3i(), this, b.x, b.y, b.z)

    fun minus(bX: Int, bY: Int, bZ: Int, res: Vec3i = Vec3i()) = minus(res, this, bX, bY, bZ)
    fun minus(b: Int, res: Vec3i = Vec3i()) = minus(res, this, b, b, b)
    fun minus(b: Vec3i, res: Vec3i = Vec3i()) = minus(res, this, b.x, b.y, b.z)

    fun minusAssign(bX: Int, bY: Int, bZ: Int) = minus(this, this, bX, bY, bZ)
    infix operator fun minusAssign(b: Int) {
        minus(this, this, b, b, b)
    }

    infix operator fun minusAssign(b: Vec3i) {
        minus(this, this, b.x, b.y, b.z)
    }


    operator fun times(b: Int) = times(Vec3i(), this, b, b, b)
    operator fun times(b: Vec3i) = times(Vec3i(), this, b.x, b.y, b.z)

    fun times(bX: Int, bY: Int, bZ: Int, res: Vec3i = Vec3i()) = times(res, this, bX, bY, bZ)
    fun times(b: Int, res: Vec3i = Vec3i()) = times(res, this, b, b, b)
    fun times(b: Vec3i, res: Vec3i = Vec3i()) = times(res, this, b.x, b.y, b.z)

    fun timesAssign(bX: Int, bY: Int, bZ: Int) = times(this, this, bX, bY, bZ)
    infix operator fun timesAssign(b: Int) {
        times(this, this, b, b, b)
    }

    infix operator fun timesAssign(b: Vec3i) {
        times(this, this, b.x, b.y, b.z)
    }


    operator fun div(b: Int) = div(Vec3i(), this, b, b, b)
    operator fun div(b: Vec3i) = div(Vec3i(), this, b.x, b.y, b.z)

    fun div(bX: Int, bY: Int, bZ: Int, res: Vec3i = Vec3i()) = div(res, this, bX, bY, bZ)
    fun div(b: Int, res: Vec3i) = div(res, this, b, b, b)
    fun div(b: Vec3i, res: Vec3i) = div(res, this, b.x, b.y, b.z)

    fun divAssign(bX: Int, bY: Int, bZ: Int) = div(this, this, bX, bY, bZ)
    infix operator fun divAssign(b: Int) {
        div(this, this, b, b, b)
    }

    infix operator fun divAssign(b: Vec3i) {
        div(this, this, b.x, b.y, b.z)
    }


    operator fun rem(b: Int) = rem(Vec3i(), this, b, b, b)
    operator fun rem(b: Vec3i) = rem(Vec3i(), this, b.x, b.y, b.z)

    fun rem(bX: Int, bY: Int, bZ: Int, res: Vec3i = Vec3i()) = rem(res, this, bX, bY, bZ)
    fun rem(b: Int, res: Vec3i) = rem(res, this, b, b, b)
    fun rem(b: Vec3i, res: Vec3i) = rem(res, this, b.x, b.y, b.z)

    fun remAssign(bX: Int, bY: Int, bZ: Int) = rem(this, this, bX, bY, bZ)
    infix operator fun remAssign(b: Int) {
        rem(this, this, b, b, b)
    }

    infix operator fun remAssign(b: Vec3i) {
        rem(this, this, b.x, b.y, b.z)
    }


    // -- Generic binary arithmetic operators --

    operator fun plus(b: Number) = plus(Vec3i(), this, b.i, b.i, b.i)
    operator fun plus(b: Vec3t<out Number>) = plus(Vec3i(), this, b.x.i, b.y.i, b.z.i)

    fun plus(bX: Number, bY: Number, bZ: Number, res: Vec3i = Vec3i()) = plus(res, this, bX.i, bY.i, bZ.i)
    fun plus(b: Number, res: Vec3i = Vec3i()) = plus(res, this, b.i, b.i, b.i)
    fun plus(b: Vec3t<out Number>, res: Vec3i = Vec3i()) = plus(res, this, b.x.i, b.y.i, b.z.i)

    fun plusAssign(bX: Number, bY: Number, bZ: Number) = plus(this, this, bX.i, bY.i, bZ.i)
    infix operator fun plusAssign(b: Number) {
        plus(this, this, b.i, b.i, b.i)
    }

    infix operator fun plusAssign(b: Vec3t<out Number>) {
        plus(this, this, b.x.i, b.y.i, b.z.i)
    }


    operator fun minus(b: Number) = minus(Vec3i(), this, b.i, b.i, b.i)
    operator fun minus(b: Vec3t<out Number>) = minus(Vec3i(), this, b.x.i, b.y.i, b.z.i)

    fun minus(bX: Number, bY: Number, bZ: Number, res: Vec3i = Vec3i()) = minus(res, this, bX.i, bY.i, bZ.i)
    fun minus(b: Number, res: Vec3i = Vec3i()) = minus(res, this, b.i, b.i, b.i)
    fun minus(b: Vec3t<out Number>, res: Vec3i = Vec3i()) = minus(res, this, b.x.i, b.y.i, b.z.i)

    fun minusAssign(bX: Number, bY: Number, bZ: Number) = minus(this, this, bX.i, bY.i, bZ.i)
    infix operator fun minusAssign(b: Number) {
        minus(this, this, b.i, b.i, b.i)
    }

    infix operator fun minusAssign(b: Vec3t<out Number>) {
        minus(this, this, b.x.i, b.y.i, b.z.i)
    }


    operator fun times(b: Number) = times(Vec3i(), this, b.i, b.i, b.i)
    operator fun times(b: Vec3t<out Number>) = times(Vec3i(), this, b.x.i, b.y.i, b.z.i)

    fun times(bX: Number, bY: Number, bZ: Number, res: Vec3i = Vec3i()) = times(res, this, bX.i, bY.i, bZ.i)
    fun times(b: Number, res: Vec3i = Vec3i()) = times(res, this, b.i, b.i, b.i)
    fun times(b: Vec3t<out Number>, res: Vec3i = Vec3i()) = times(res, this, b.x.i, b.y.i, b.z.i)

    fun timesAssign(bX: Number, bY: Number, bZ: Number) = times(this, this, bX.i, bY.i, bZ.i)
    infix operator fun timesAssign(b: Number) {
        times(this, this, b.i, b.i, b.i)
    }

    infix operator fun timesAssign(b: Vec3t<out Number>) {
        times(this, this, b.x.i, b.y.i, b.z.i)
    }


    operator fun div(b: Number) = div(Vec3i(), this, b.i, b.i, b.i)
    operator fun div(b: Vec3t<out Number>) = div(Vec3i(), this, b.x.i, b.y.i, b.z.i)

    fun div(bX: Number, bY: Number, bZ: Number, res: Vec3i = Vec3i()) = div(res, this, bX.i, bY.i, bZ.i)
    fun div(b: Number, res: Vec3i) = div(res, this, b.i, b.i, b.i)
    fun div(b: Vec3t<out Number>, res: Vec3i) = div(res, this, b.x.i, b.y.i, b.z.i)

    fun divAssign(bX: Number, bY: Number, bZ: Number) = div(this, this, bX.i, bY.i, bZ.i)
    infix operator fun divAssign(b: Number) {
        div(this, this, b.i, b.i, b.i)
    }

    infix operator fun divAssign(b: Vec3t<out Number>) {
        div(this, this, b.x.i, b.y.i, b.z.i)
    }


    operator fun rem(b: Number) = rem(Vec3i(), this, b.i, b.i, b.i)
    operator fun rem(b: Vec3t<out Number>) = rem(Vec3i(), this, b.x.i, b.y.i, b.z.i)

    fun rem(bX: Number, bY: Number, bZ: Number, res: Vec3i = Vec3i()) = rem(res, this, bX.i, bY.i, bZ.i)
    fun rem(b: Number, res: Vec3i) = rem(res, this, b.i, b.i, b.i)
    fun rem(b: Vec3t<out Number>, res: Vec3i) = rem(res, this, b.x.i, b.y.i, b.z.i)

    fun remAssign(bX: Number, bY: Number, bZ: Number) = rem(this, this, bX.i, bY.i, bZ.i)
    infix operator fun remAssign(b: Number) {
        rem(this, this, b.i, b.i, b.i)
    }

    infix operator fun remAssign(b: Vec3t<out Number>) {
        rem(this, this, b.x.i, b.y.i, b.z.i)
    }


    // -- Specific bitwise operators --

    infix fun and(b: Int) = and(Vec3i(), this, b, b, b)
    infix fun and(b: Vec3i) = and(Vec3i(), this, b.x, b.y, b.z)

    infix fun andAssign(b: Int) = and(this, this, b, b, b)
    infix fun andAssign(b: Vec3i) = and(this, this, b.x, b.y, b.z)

    fun and(b: Int, res: Vec3i) = and(res, this, b, b, b)
    fun and(b: Vec3i, res: Vec3i) = and(res, this, b.x, b.y, b.z)

    fun and(bX: Int, bY: Int, bZ: Int, res: Vec3i = Vec3i()) = and(res, this, bX, bY, bZ)

    fun andAssign(bX: Int, bY: Int, bZ: Int) = and(this, this, bX, bY, bZ)


    infix fun or(b: Int) = or(Vec3i(), this, b, b, b)
    infix fun or(b: Vec3i) = or(Vec3i(), this, b.x, b.y, b.z)

    infix fun orAssign(b: Int) = or(this, this, b, b, b)
    infix fun orAssign(b: Vec3i) = or(this, this, b.x, b.y, b.z)

    fun or(b: Int, res: Vec3i) = or(res, this, b, b, b)
    fun or(b: Vec3i, res: Vec3i) = or(res, this, b.x, b.y, b.z)

    fun or(bX: Int, bY: Int, bZ: Int, res: Vec3i = Vec3i()) = or(res, this, bX, bY, bZ)

    fun orAssign(bX: Int, bY: Int, bZ: Int) = or(this, this, bX, bY, bZ)


    infix fun xor(b: Int) = xor(Vec3i(), this, b, b, b)
    infix fun xor(b: Vec3i) = xor(Vec3i(), this, b.x, b.y, b.z)

    infix fun xorAssign(b: Int) = xor(this, this, b, b, b)
    infix fun xorAssign(b: Vec3i) = xor(this, this, b.x, b.y, b.z)

    fun xor(b: Int, res: Vec3i) = xor(res, this, b, b, b)
    fun xor(b: Vec3i, res: Vec3i) = xor(res, this, b.x, b.y, b.z)

    fun xor(bX: Int, bY: Int, bZ: Int, res: Vec3i = Vec3i()) = xor(res, this, bX, bY, bZ)

    fun xorAssign(bX: Int, bY: Int, bZ: Int) = xor(this, this, bX, bY, bZ)


    infix fun shl(b: Int) = shl(Vec3i(), this, b, b, b)
    infix fun shl(b: Vec3i) = shl(Vec3i(), this, b.x, b.y, b.z)

    infix fun shlAssign(b: Int) = shl(this, this, b, b, b)
    infix fun shlAssign(b: Vec3i) = shl(this, this, b.x, b.y, b.z)

    fun shl(b: Int, res: Vec3i) = shl(res, this, b, b, b)
    fun shl(b: Vec3i, res: Vec3i) = shl(res, this, b.x, b.y, b.z)

    fun shl(bX: Int, bY: Int, bZ: Int, res: Vec3i = Vec3i()) = shl(res, this, bX, bY, bZ)

    fun shlAssign(bX: Int, bY: Int, bZ: Int) = shl(this, this, bX, bY, bZ)


    infix fun shr(b: Int) = shr(Vec3i(), this, b, b, b)
    infix fun shr(b: Vec3i) = shr(Vec3i(), this, b.x, b.y, b.z)

    infix fun shrAssign(b: Int) = shr(this, this, b, b, b)
    infix fun shrAssign(b: Vec3i) = shr(this, this, b.x, b.y, b.z)

    fun shr(b: Int, res: Vec3i) = shr(res, this, b, b, b)
    fun shr(b: Vec3i, res: Vec3i) = shr(res, this, b.x, b.y, b.z)

    fun shr(bX: Int, bY: Int, bZ: Int, res: Vec3i = Vec3i()) = shr(res, this, bX, bY, bZ)

    fun shrAssign(bX: Int, bY: Int, bZ: Int) = shr(this, this, bX, bY, bZ)


    fun inv(res: Vec3i = Vec3i()) = inv(res, this)
    fun invAssign() = inv(this, this)


    // TODO others
    infix fun ushr(b: Int) = ushr(Vec3i(), this, b, b, b)


    // -- Generic bitwise operators --

    infix fun and(b: Number) = and(Vec3i(), this, b.i, b.i, b.i)
    infix fun and(b: Vec3t<out Number>) = and(Vec3i(), this, b.x.i, b.y.i, b.z.i)

    infix fun andAssign(b: Number) = and(this, this, b.i, b.i, b.i)
    infix fun andAssign(b: Vec3t<out Number>) = and(this, this, b.x.i, b.y.i, b.z.i)

    fun and(b: Number, res: Vec3i) = and(res, this, b.i, b.i, b.i)
    fun and(b: Vec3t<out Number>, res: Vec3i) = and(res, this, b.x.i, b.y.i, b.z.i)

    fun and(bX: Number, bY: Number, bZ: Number, res: Vec3i = Vec3i()) = and(res, this, bX.i, bY.i, bZ.i)

    fun andAssign(bX: Number, bY: Number, bZ: Number) = and(this, this, bX.i, bY.i, bZ.i)


    infix fun or(b: Number) = or(Vec3i(), this, b.i, b.i, b.i)
    infix fun or(b: Vec3t<out Number>) = or(Vec3i(), this, b.x.i, b.y.i, b.z.i)

    infix fun orAssign(b: Number) = or(this, this, b.i, b.i, b.i)
    infix fun orAssign(b: Vec3t<out Number>) = or(this, this, b.x.i, b.y.i, b.z.i)

    fun or(b: Number, res: Vec3i) = or(res, this, b.i, b.i, b.i)
    fun or(b: Vec3t<out Number>, res: Vec3i) = or(res, this, b.x.i, b.y.i, b.z.i)

    fun or(bX: Number, bY: Number, bZ: Number, res: Vec3i = Vec3i()) = or(res, this, bX.i, bY.i, bZ.i)

    fun orAssign(bX: Number, bY: Number, bZ: Number) = or(this, this, bX.i, bY.i, bZ.i)


    infix fun xor(b: Number) = xor(Vec3i(), this, b.i, b.i, b.i)
    infix fun xor(b: Vec3t<out Number>) = xor(Vec3i(), this, b.x.i, b.y.i, b.z.i)

    infix fun xorAssign(b: Number) = xor(this, this, b.i, b.i, b.i)
    infix fun xorAssign(b: Vec3t<out Number>) = xor(this, this, b.x.i, b.y.i, b.z.i)

    fun xor(b: Number, res: Vec3i) = xor(res, this, b.i, b.i, b.i)
    fun xor(b: Vec3t<out Number>, res: Vec3i) = xor(res, this, b.x.i, b.y.i, b.z.i)

    fun xor(bX: Number, bY: Number, bZ: Number, res: Vec3i = Vec3i()) = xor(res, this, bX.i, bY.i, bZ.i)

    fun xorAssign(bX: Number, bY: Number, bZ: Number) = xor(this, this, bX.i, bY.i, bZ.i)


    infix fun shl(b: Number) = shl(Vec3i(), this, b.i, b.i, b.i)
    infix fun shl(b: Vec3t<out Number>) = shl(Vec3i(), this, b.x.i, b.y.i, b.z.i)

    infix fun shlAssign(b: Number) = shl(this, this, b.i, b.i, b.i)
    infix fun shlAssign(b: Vec3t<out Number>) = shl(this, this, b.x.i, b.y.i, b.z.i)

    fun shl(b: Number, res: Vec3i) = shl(res, this, b.i, b.i, b.i)
    fun shl(b: Vec3t<out Number>, res: Vec3i) = shl(res, this, b.x.i, b.y.i, b.z.i)

    fun shl(bX: Number, bY: Number, bZ: Number, res: Vec3i = Vec3i()) = shl(res, this, bX.i, bY.i, bZ.i)

    fun shlAssign(bX: Number, bY: Number, bZ: Number) = shl(this, this, bX.i, bY.i, bZ.i)


    infix fun shr(b: Number) = shr(Vec3i(), this, b.i, b.i, b.i)
    infix fun shr(b: Vec3t<out Number>) = shr(Vec3i(), this, b.x.i, b.y.i, b.z.i)

    infix fun shrAssign(b: Number) = shr(this, this, b.i, b.i, b.i)
    infix fun shrAssign(b: Vec3t<out Number>) = shr(this, this, b.x.i, b.y.i, b.z.i)

    fun shr(b: Number, res: Vec3i) = shr(res, this, b.i, b.i, b.i)
    fun shr(b: Vec3t<out Number>, res: Vec3i) = shr(res, this, b.x.i, b.y.i, b.z.i)

    fun shr(bX: Number, bY: Number, bZ: Number, res: Vec3i = Vec3i()) = shr(res, this, bX.i, bY.i, bZ.i)

    fun shrAssign(bX: Number, bY: Number, bZ: Number) = shr(this, this, bX.i, bY.i, bZ.i)


    override fun createInstance(x: Int, y: Int) = Vec2i(x, y)
    override fun createInstance(x: Int, y: Int, z: Int) = Vec3i(x, y, z)


    companion object : vec3i_operators {
        const val length = Vec3t.length
        @JvmField
        val size = Vec3i.Companion.length * Int.BYTES

        @JvmStatic
        fun fromPointer(ptr: Ptr) = Vec3i(memGetInt(ptr), memGetInt(ptr + Int.BYTES), memGetInt(ptr + Int.BYTES * 2))
    }

    override fun size() = size

    override fun equals(other: Any?) = other is Vec3i && this[0] == other[0] && this[1] == other[1] && this[2] == other[2]
    override fun hashCode() = 31 * (31 * x.hashCode() + y.hashCode()) + z.hashCode()

    @JvmOverloads
    fun print(name: String = "", stream: PrintStream = System.out) = stream.print("$name$this")

    @JvmOverloads
    fun println(name: String = "", stream: PrintStream = System.out) = stream.println("$name$this")

    override fun toString(): String = "($x, $y, $z)"
}