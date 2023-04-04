
package glm_.vec2

import glm_.*
import glm_.vec1.Vec1bool
import glm_.vec1.Vec1t
import glm_.vec2.operators.opVec2ub
import glm_.vec3.Vec3bool
import glm_.vec3.Vec3t
import glm_.vec4.Vec4bool
import glm_.vec4.Vec4t
import kool.*
import org.lwjgl.system.MemoryUtil.memGetByte
import org.lwjgl.system.MemoryUtil.memPutByte
import unsigned.Ubyte
import java.io.PrintStream
import java.nio.*
import kotlin.math.abs

/**
 * Created by elect on 07/10/16.
 */

class Vec2ub(var ofs: Int, var array: ByteArray) : Vec2t<Ubyte>(), ToBuffer {

    override var x: Ubyte
        get() = Ubyte(array[ofs])
        set(value) = array.set(ofs, value.v)
    override var y: Ubyte
        get() = Ubyte(array[ofs + 1])
        set(value) = array.set(ofs + 1, value.v)

    inline var vX: Byte
        get() = array[ofs]
        set(value) = array.set(ofs, value)
    inline var vY: Byte
        get() = array[ofs + 1]
        set(value) = array.set(ofs + 1, value)

    // -- Implicit basic constructors --

    constructor() : this(0)
    constructor(v: Vec2ub) : this(v.x, v.y)

    // -- Explicit basic constructors --

    @JvmOverloads
    constructor(x: Byte, y: Byte = x) : this(x.ub, y.ub)

    @JvmOverloads
    constructor(x: Ubyte, y: Ubyte = x) : this(0, byteArrayOf(x.v, y.v))

    // -- Conversion constructors --

    @JvmOverloads
    constructor(x: Number, y: Number = x) : this(x.ub, y.ub)

    constructor(x: Number, v: Vec1t<out Number>) : this(x, v.x)
    @JvmOverloads
    constructor(v: Vec1t<out Number>, y: Number = v.x) : this(v.x, y)

    constructor(x: Vec1t<out Number>, y: Vec1t<out Number>) : this(x.x, y.x)

    constructor(v: Vec2t<out Number>) : this(v.x, v.y)
    constructor(v: Vec3t<out Number>) : this(v.x, v.y)
    constructor(v: Vec4t<out Number>) : this(v.x, v.y)

    @JvmOverloads
    constructor(x: Boolean, y: Boolean = x) : this(x.ub, y.ub)

    constructor(x: Boolean, v: Vec1bool) : this(x.ub, v.x.ub)
    @JvmOverloads
    constructor(v: Vec1bool, y: Boolean = v.x) : this(v.x.ub, y.ub)

    constructor(x: Vec1bool, y: Vec1bool) : this(x.x.ub, y.x.ub)

    constructor(v: Vec2bool) : this(v.x.ub, v.y.ub)
    constructor(v: Vec3bool) : this(v.x.ub, v.y.ub)
    constructor(v: Vec4bool) : this(v.x.ub, v.y.ub)

    constructor(bytes: ByteArray, index: Int = 0) : this(bytes[index], bytes[index + 1])
    constructor(chars: CharArray, index: Int = 0) : this(chars[index].ub, chars[index + 1].ub)
    constructor(shorts: ShortArray, index: Int = 0) : this(shorts[index], shorts[index + 1])
    constructor(ints: IntArray, index: Int = 0) : this(ints[index], ints[index + 1])
    constructor(longs: LongArray, index: Int = 0) : this(longs[index], longs[index + 1])
    constructor(floats: FloatArray, index: Int = 0) : this(floats[index], floats[index + 1])
    constructor(doubles: DoubleArray, index: Int = 0) : this(doubles[index], doubles[index + 1])
    constructor(booleans: BooleanArray, index: Int = 0) : this(booleans[index].ub, booleans[index + 1].ub)

    constructor(numbers: Array<out Number>, index: Int = 0) : this(numbers[index], numbers[index + 1])
    constructor(chars: Array<Char>, index: Int = 0) : this(chars[index].ub, chars[index + 1].ub)
    constructor(booleans: Array<Boolean>, index: Int = 0) : this(booleans[index].ub, booleans[index + 1].ub)

    constructor(list: Iterable<*>, index: Int = 0) : this(list.elementAt(index)!!.toByte, list.elementAt(index + 1)!!.toByte) // TODO ub kuns

    constructor(bytes: ByteBuffer, index: Int = bytes.pos) : this(bytes[index], bytes[index + 1])
    constructor(chars: CharBuffer, index: Int = chars.pos) : this(chars[index].ub, chars[index + 1].ub)
    constructor(shorts: ShortBuffer, index: Int = shorts.pos) : this(shorts[index], shorts[index + 1])
    constructor(ints: IntBuffer, index: Int = ints.pos) : this(ints[index], ints[index + 1])
    constructor(longs: LongBuffer, index: Int = longs.pos) : this(longs[index], longs[index + 1])
    constructor(floats: FloatBuffer, index: Int = floats.pos) : this(floats[index], floats[index + 1])
    constructor(doubles: DoubleBuffer, index: Int = doubles.pos) : this(doubles[index], doubles[index + 1])

    constructor(block: (Int) -> Ubyte) : this(block(0), block(1))
    constructor(ptr: Ptr<Ubyte>) : this() {
        val p = ptr.toPtr<Byte>()
        x.v = p[0]
        y.v = p[1]
    }


    fun put(x: Ubyte, y: Ubyte) {
        this.x = x
        this.y = y
    }

    operator fun invoke(x: Ubyte, y: Ubyte): Vec2ub {
        this.x = x
        this.y = y
        return this
    }

    fun put(x: Byte, y: Byte) {
        this.x.v = x
        this.y.v = y
    }

    operator fun invoke(x: Byte, y: Byte): Vec2ub {
        this.x.v = x
        this.y.v = y
        return this
    }

    override fun put(x: Number, y: Number) {
        this.x = x.ub
        this.y = y.ub
    }

    override operator fun invoke(x: Number, y: Number): Vec2ub {
        this.x = x.ub
        this.y = y.ub
        return this
    }

    fun to(bytes: ByteArray, index: Int) = to(bytes, index, true)
    override fun to(bytes: ByteArray, index: Int, bigEndian: Boolean): ByteArray {
        System.arraycopy(array, ofs, bytes, index, length)
        return bytes
    }

    override fun to(buf: ByteBuffer, offset: Int): ByteBuffer {
        return buf
                .put(offset + 0, array[0])
                .put(offset + 1, array[1])
    }

    infix fun to(ptr: Ptr<Ubyte>) {
        val p = ptr.toPtr<Byte>()
        p[0] = x.v
        p[1] = y.v
    }

    // -- Component accesses --

    operator fun set(index: Int, value: Ubyte) = when (index) {
        0 -> x = value
        1 -> y = value
        else -> throw ArrayIndexOutOfBoundsException()
    }

    override operator fun set(index: Int, value: Number) = when (index) {
        0 -> x = value.ub
        1 -> y = value.ub
        else -> throw ArrayIndexOutOfBoundsException()
    }


    // -- Unary arithmetic operators --

    operator fun unaryPlus() = this

    // no unaryMinus operator, only signed

    // -- Increment main.and decrement operators --

    operator fun inc() = plus(Vec2ub(), this, 1, 1)
    infix fun inc(res: Vec2ub) = plus(res, this, 1, 1)
    fun incAssign() = plus(this, this, 1, 1)


    operator fun dec() = minus(Vec2ub(), this, 1, 1)
    infix fun dec(res: Vec2ub) = minus(res, this, 1, 1)
    fun decAssign() = minus(this, this, 1, 1)


    // -- Specific binary arithmetic operators --

    infix operator fun plus(b: Ubyte) = plus(Vec2ub(), this, b, b)
    infix operator fun plus(b: Byte) = plus(Vec2ub(), this, b, b)
    infix operator fun plus(b: Int) = plus(Vec2ub(), this, b, b)
    infix operator fun plus(b: Vec2ub) = plus(Vec2ub(), this, b.x, b.y)

    @JvmOverloads
    fun plus(bX: Ubyte, bY: Ubyte, res: Vec2ub = Vec2ub()) = plus(res, this, bX, bY)

    @JvmOverloads
    fun plus(bX: Byte, bY: Byte, res: Vec2ub = Vec2ub()) = plus(res, this, bX, bY)

    @JvmOverloads
    fun plus(bX: Int, bY: Int, res: Vec2ub = Vec2ub()) = plus(res, this, bX, bY)

    fun plus(b: Ubyte, res: Vec2ub) = plus(res, this, b, b)
    fun plus(b: Byte, res: Vec2ub) = plus(res, this, b, b)
    fun plus(b: Int, res: Vec2ub) = plus(res, this, b, b)
    fun plus(b: Vec2ub, res: Vec2ub) = plus(res, this, b.x, b.y)

    fun plusAssign(bX: Ubyte, bY: Ubyte) = plus(this, this, bX, bY)
    fun plusAssign(bX: Byte, bY: Byte) = plus(this, this, bX, bY)
    fun plusAssign(bX: Int, bY: Int) = plus(this, this, bX, bY)
    infix operator fun plusAssign(b: Ubyte) {
        plus(this, this, b, b)
    }

    infix operator fun plusAssign(b: Byte) {
        plus(this, this, b, b)
    }

    infix operator fun plusAssign(b: Int) {
        plus(this, this, b, b)
    }

    infix operator fun plusAssign(b: Vec2ub) {
        plus(this, this, b.x, b.y)
    }


    infix operator fun minus(b: Ubyte) = minus(Vec2ub(), this, b, b)
    infix operator fun minus(b: Byte) = minus(Vec2ub(), this, b, b)
    infix operator fun minus(b: Int) = minus(Vec2ub(), this, b, b)
    infix operator fun minus(b: Vec2ub) = minus(Vec2ub(), this, b.x, b.y)

    @JvmOverloads
    fun minus(bX: Ubyte, bY: Ubyte, res: Vec2ub = Vec2ub()) = minus(res, this, bX, bY)

    @JvmOverloads
    fun minus(bX: Byte, bY: Byte, res: Vec2ub = Vec2ub()) = minus(res, this, bX, bY)

    @JvmOverloads
    fun minus(bX: Int, bY: Int, res: Vec2ub = Vec2ub()) = minus(res, this, bX, bY)

    fun minus(b: Ubyte, res: Vec2ub) = minus(res, this, b, b)
    fun minus(b: Byte, res: Vec2ub) = minus(res, this, b, b)
    fun minus(b: Int, res: Vec2ub) = minus(res, this, b, b)
    fun minus(b: Vec2ub, res: Vec2ub) = minus(res, this, b.x, b.y)

    fun minusAssign(bX: Ubyte, bY: Ubyte) = minus(this, this, bX, bY)
    fun minusAssign(bX: Byte, bY: Byte) = minus(this, this, bX, bY)
    fun minusAssign(bX: Int, bY: Int) = minus(this, this, bX, bY)
    infix operator fun minusAssign(b: Ubyte) {
        minus(this, this, b, b)
    }

    infix operator fun minusAssign(b: Byte) {
        minus(this, this, b, b)
    }

    infix operator fun minusAssign(b: Int) {
        minus(this, this, b, b)
    }

    infix operator fun minusAssign(b: Vec2ub) {
        minus(this, this, b.x, b.y)
    }


    infix operator fun times(b: Ubyte) = times(Vec2ub(), this, b, b)
    infix operator fun times(b: Byte) = times(Vec2ub(), this, b, b)
    infix operator fun times(b: Int) = times(Vec2ub(), this, b, b)
    infix operator fun times(b: Vec2ub) = times(Vec2ub(), this, b.x, b.y)

    @JvmOverloads
    fun times(bX: Ubyte, bY: Ubyte, res: Vec2ub = Vec2ub()) = times(res, this, bX, bY)

    @JvmOverloads
    fun times(bX: Byte, bY: Byte, res: Vec2ub = Vec2ub()) = times(res, this, bX, bY)

    @JvmOverloads
    fun times(bX: Int, bY: Int, res: Vec2ub = Vec2ub()) = times(res, this, bX, bY)

    fun times(b: Ubyte, res: Vec2ub) = times(res, this, b, b)
    fun times(b: Byte, res: Vec2ub) = times(res, this, b, b)
    fun times(b: Int, res: Vec2ub) = times(res, this, b, b)
    fun times(b: Vec2ub, res: Vec2ub) = times(res, this, b.x, b.y)

    fun timesAssign(bX: Ubyte, bY: Ubyte) = times(this, this, bX, bY)
    fun timesAssign(bX: Byte, bY: Byte) = times(this, this, bX, bY)
    fun timesAssign(bX: Int, bY: Int) = times(this, this, bX, bY)
    infix operator fun timesAssign(b: Ubyte) {
        times(this, this, b, b)
    }

    infix operator fun timesAssign(b: Byte) {
        times(this, this, b, b)
    }

    infix operator fun timesAssign(b: Int) {
        times(this, this, b, b)
    }

    infix operator fun timesAssign(b: Vec2ub) {
        times(this, this, b.x, b.y)
    }


    infix operator fun div(b: Ubyte) = div(Vec2ub(), this, b, b)
    infix operator fun div(b: Byte) = div(Vec2ub(), this, b, b)
    infix operator fun div(b: Int) = div(Vec2ub(), this, b, b)
    infix operator fun div(b: Vec2ub) = div(Vec2ub(), this, b.x, b.y)

    @JvmOverloads
    fun div(bX: Ubyte, bY: Ubyte, res: Vec2ub = Vec2ub()) = div(res, this, bX, bY)

    @JvmOverloads
    fun div(bX: Byte, bY: Byte, res: Vec2ub = Vec2ub()) = div(res, this, bX, bY)

    @JvmOverloads
    fun div(bX: Int, bY: Int, res: Vec2ub = Vec2ub()) = div(res, this, bX, bY)

    fun div(b: Ubyte, res: Vec2ub) = div(res, this, b, b)
    fun div(b: Byte, res: Vec2ub) = div(res, this, b, b)
    fun div(b: Int, res: Vec2ub) = div(res, this, b, b)
    fun div(b: Vec2ub, res: Vec2ub) = div(res, this, b.x, b.y)

    fun divAssign(bX: Ubyte, bY: Ubyte) = div(this, this, bX, bY)
    fun divAssign(bX: Byte, bY: Byte) = div(this, this, bX, bY)
    fun divAssign(bX: Int, bY: Int) = div(this, this, bX, bY)
    infix operator fun divAssign(b: Ubyte) {
        div(this, this, b, b)
    }

    infix operator fun divAssign(b: Byte) {
        div(this, this, b, b)
    }

    infix operator fun divAssign(b: Int) {
        div(this, this, b, b)
    }

    infix operator fun divAssign(b: Vec2ub) {
        div(this, this, b.x, b.y)
    }


    infix operator fun rem(b: Ubyte) = rem(Vec2ub(), this, b, b)
    infix operator fun rem(b: Byte) = rem(Vec2ub(), this, b, b)
    infix operator fun rem(b: Int) = rem(Vec2ub(), this, b, b)
    infix operator fun rem(b: Vec2ub) = rem(Vec2ub(), this, b.x, b.y)

    @JvmOverloads
    fun rem(bX: Ubyte, bY: Ubyte, res: Vec2ub = Vec2ub()) = rem(res, this, bX, bY)

    @JvmOverloads
    fun rem(bX: Byte, bY: Byte, res: Vec2ub = Vec2ub()) = rem(res, this, bX, bY)

    @JvmOverloads
    fun rem(bX: Int, bY: Int, res: Vec2ub = Vec2ub()) = rem(res, this, bX, bY)

    fun rem(b: Ubyte, res: Vec2ub) = rem(res, this, b, b)
    fun rem(b: Byte, res: Vec2ub) = rem(res, this, b, b)
    fun rem(b: Int, res: Vec2ub) = rem(res, this, b, b)
    fun rem(b: Vec2ub, res: Vec2ub) = rem(res, this, b.x, b.y)

    fun remAssign(bX: Ubyte, bY: Ubyte) = rem(this, this, bX, bY)
    fun remAssign(bX: Byte, bY: Byte) = rem(this, this, bX, bY)
    fun remAssign(bX: Int, bY: Int) = rem(this, this, bX, bY)
    infix operator fun remAssign(b: Ubyte) {
        rem(this, this, b, b)
    }

    infix operator fun remAssign(b: Byte) {
        rem(this, this, b, b)
    }

    infix operator fun remAssign(b: Int) {
        rem(this, this, b, b)
    }

    infix operator fun remAssign(b: Vec2ub) {
        rem(this, this, b.x, b.y)
    }


    // -- Generic binary arithmetic operators --

    infix operator fun plus(b: Number) = plus(Vec2ub(), this, b.i, b.i)
    infix operator fun plus(b: Vec2t<out Number>) = plus(Vec2ub(), this, b.x.i, b.y.i)

    @JvmOverloads
    fun plus(bX: Number, bY: Number, res: Vec2ub = Vec2ub()) = plus(res, this, bX.i, bY.i)

    fun plus(b: Number, res: Vec2ub) = plus(res, this, b.i, b.i)
    fun plus(b: Vec2t<out Number>, res: Vec2ub) = plus(res, this, b.x.i, b.y.i)

    fun plusAssign(bX: Number, bY: Number) = plus(this, this, bX.i, bY.i)
    infix operator fun plusAssign(b: Number) {
        plus(this, this, b.i, b.i)
    }

    infix operator fun plusAssign(b: Vec2t<out Number>) {
        plus(this, this, b.x.i, b.y.i)
    }


    infix operator fun minus(b: Number) = minus(Vec2ub(), this, b.i, b.i)
    infix operator fun minus(b: Vec2t<out Number>) = minus(Vec2ub(), this, b.x.i, b.y.i)

    @JvmOverloads
    fun minus(bX: Number, bY: Number, res: Vec2ub = Vec2ub()) = minus(res, this, bX.i, bY.i)

    fun minus(b: Number, res: Vec2ub) = minus(res, this, b.i, b.i)
    fun minus(b: Vec2t<out Number>, res: Vec2ub) = minus(res, this, b.x.i, b.y.i)

    fun minusAssign(bX: Number, bY: Number) = minus(this, this, bX.i, bY.i)
    infix operator fun minusAssign(b: Number) {
        minus(this, this, b.i, b.i)
    }

    infix operator fun minusAssign(b: Vec2t<out Number>) {
        minus(this, this, b.x.i, b.y.i)
    }


    infix operator fun times(b: Number) = times(Vec2ub(), this, b.i, b.i)
    infix operator fun times(b: Vec2t<out Number>) = times(Vec2ub(), this, b.x.i, b.y.i)

    @JvmOverloads
    fun times(bX: Number, bY: Number, res: Vec2ub = Vec2ub()) = times(res, this, bX.i, bY.i)

    fun times(b: Number, res: Vec2ub) = times(res, this, b.i, b.i)
    fun times(b: Vec2t<out Number>, res: Vec2ub) = times(res, this, b.x.i, b.y.i)

    fun timesAssign(bX: Number, bY: Number) = times(this, this, bX.i, bY.i)
    infix operator fun timesAssign(b: Number) {
        times(this, this, b.i, b.i)
    }

    infix operator fun timesAssign(b: Vec2t<out Number>) {
        times(this, this, b.x.i, b.y.i)
    }


    infix operator fun div(b: Number) = div(Vec2ub(), this, b.i, b.i)
    infix operator fun div(b: Vec2t<out Number>) = div(Vec2ub(), this, b.x.i, b.y.i)

    @JvmOverloads
    fun div(bX: Number, bY: Number, res: Vec2ub = Vec2ub()) = div(res, this, bX.i, bY.i)

    fun div(b: Number, res: Vec2ub) = div(res, this, b.i, b.i)
    fun div(b: Vec2t<out Number>, res: Vec2ub) = div(res, this, b.x.i, b.y.i)

    fun divAssign(bX: Number, bY: Number) = div(this, this, bX.i, bY.i)
    infix operator fun divAssign(b: Number) {
        div(this, this, b.i, b.i)
    }

    infix operator fun divAssign(b: Vec2t<out Number>) {
        div(this, this, b.x.i, b.y.i)
    }


    infix operator fun rem(b: Number) = rem(Vec2ub(), this, b.i, b.i)
    infix operator fun rem(b: Vec2t<out Number>) = rem(Vec2ub(), this, b.x.i, b.y.i)

    @JvmOverloads
    fun rem(bX: Number, bY: Number, res: Vec2ub = Vec2ub()) = rem(res, this, bX.i, bY.i)

    fun rem(b: Number, res: Vec2ub) = rem(res, this, b.i, b.i)
    fun rem(b: Vec2t<out Number>, res: Vec2ub) = rem(res, this, b.x.i, b.y.i)

    fun remAssign(bX: Number, bY: Number) = rem(this, this, bX.i, bY.i)
    infix operator fun remAssign(b: Number) {
        rem(this, this, b.i, b.i)
    }

    infix operator fun remAssign(b: Vec2t<out Number>) {
        rem(this, this, b.x.i, b.y.i)
    }


    // -- Specific bitwise operators --

    infix fun and(b: Ubyte) = and(Vec2ub(), this, b, b)
    infix fun and(b: Byte) = and(Vec2ub(), this, b, b)
    infix fun and(b: Int) = and(Vec2ub(), this, b, b)
    infix fun and(b: Vec2ub) = and(Vec2ub(), this, b.x, b.y)

    fun and(b: Ubyte, res: Vec2ub) = and(res, this, b, b)
    fun and(b: Byte, res: Vec2ub) = and(res, this, b, b)
    fun and(b: Int, res: Vec2ub) = and(res, this, b, b)
    fun and(b: Vec2ub, res: Vec2ub) = and(res, this, b.x, b.y)
    @JvmOverloads
    fun and(bX: Ubyte, bY: Ubyte, res: Vec2ub = Vec2ub()) = and(res, this, bX, bY)

    @JvmOverloads
    fun and(bX: Byte, bY: Byte, res: Vec2ub = Vec2ub()) = and(res, this, bX, bY)

    @JvmOverloads
    fun and(bX: Int, bY: Int, res: Vec2ub = Vec2ub()) = and(res, this, bX, bY)

    infix fun andAssign(b: Ubyte) = and(this, this, b, b)
    infix fun andAssign(b: Byte) = and(this, this, b, b)
    infix fun andAssign(b: Int) = and(this, this, b, b)
    infix fun andAssign(b: Vec2ub) = and(this, this, b.x, b.y)
    fun andAssign(bX: Ubyte, bY: Ubyte) = and(this, this, bX, bY)
    fun andAssign(bX: Byte, bY: Byte) = and(this, this, bX, bY)
    fun andAssign(bX: Int, bY: Int) = and(this, this, bX, bY)


    infix fun or(b: Ubyte) = or(Vec2ub(), this, b, b)
    infix fun or(b: Byte) = or(Vec2ub(), this, b, b)
    infix fun or(b: Int) = or(Vec2ub(), this, b, b)
    infix fun or(b: Vec2ub) = or(Vec2ub(), this, b.x, b.y)

    fun or(b: Ubyte, res: Vec2ub) = or(res, this, b, b)
    fun or(b: Byte, res: Vec2ub) = or(res, this, b, b)
    fun or(b: Int, res: Vec2ub) = or(res, this, b, b)
    fun or(b: Vec2ub, res: Vec2ub) = or(res, this, b.x, b.y)
    @JvmOverloads
    fun or(bX: Ubyte, bY: Ubyte, res: Vec2ub = Vec2ub()) = or(res, this, bX, bY)

    @JvmOverloads
    fun or(bX: Byte, bY: Byte, res: Vec2ub = Vec2ub()) = or(res, this, bX, bY)

    @JvmOverloads
    fun or(bX: Int, bY: Int, res: Vec2ub = Vec2ub()) = or(res, this, bX, bY)

    infix fun orAssign(b: Ubyte) = or(this, this, b, b)
    infix fun orAssign(b: Byte) = or(this, this, b, b)
    infix fun orAssign(b: Int) = or(this, this, b, b)
    infix fun orAssign(b: Vec2ub) = or(this, this, b.x, b.y)
    fun orAssign(bX: Ubyte, bY: Ubyte) = or(this, this, bX, bY)
    fun orAssign(bX: Byte, bY: Byte) = or(this, this, bX, bY)
    fun orAssign(bX: Int, bY: Int) = or(this, this, bX, bY)


    infix fun xor(b: Ubyte) = xor(Vec2ub(), this, b, b)
    infix fun xor(b: Byte) = xor(Vec2ub(), this, b, b)
    infix fun xor(b: Int) = xor(Vec2ub(), this, b, b)
    infix fun xor(b: Vec2ub) = xor(Vec2ub(), this, b.x, b.y)

    fun xor(b: Ubyte, res: Vec2ub) = xor(res, this, b, b)
    fun xor(b: Byte, res: Vec2ub) = xor(res, this, b, b)
    fun xor(b: Int, res: Vec2ub) = xor(res, this, b, b)
    fun xor(b: Vec2ub, res: Vec2ub) = xor(res, this, b.x, b.y)
    @JvmOverloads
    fun xor(bX: Ubyte, bY: Ubyte, res: Vec2ub = Vec2ub()) = xor(res, this, bX, bY)

    @JvmOverloads
    fun xor(bX: Byte, bY: Byte, res: Vec2ub = Vec2ub()) = xor(res, this, bX, bY)

    @JvmOverloads
    fun xor(bX: Int, bY: Int, res: Vec2ub = Vec2ub()) = xor(res, this, bX, bY)

    infix fun xorAssign(b: Ubyte) = xor(this, this, b, b)
    infix fun xorAssign(b: Byte) = xor(this, this, b, b)
    infix fun xorAssign(b: Int) = xor(this, this, b, b)
    infix fun xorAssign(b: Vec2ub) = xor(this, this, b.x, b.y)
    fun xorAssign(bX: Ubyte, bY: Ubyte) = xor(this, this, bX, bY)
    fun xorAssign(bX: Byte, bY: Byte) = xor(this, this, bX, bY)
    fun xorAssign(bX: Int, bY: Int) = xor(this, this, bX, bY)


    infix fun shl(b: Ubyte) = shl(Vec2ub(), this, b, b)
    infix fun shl(b: Byte) = shl(Vec2ub(), this, b, b)
    infix fun shl(b: Int) = shl(Vec2ub(), this, b, b)
    infix fun shl(b: Vec2ub) = shl(Vec2ub(), this, b.x, b.y)

    fun shl(b: Ubyte, res: Vec2ub) = shl(res, this, b, b)
    fun shl(b: Byte, res: Vec2ub) = shl(res, this, b, b)
    fun shl(b: Int, res: Vec2ub) = shl(res, this, b, b)
    fun shl(b: Vec2ub, res: Vec2ub) = shl(res, this, b.x, b.y)
    @JvmOverloads
    fun shl(bX: Ubyte, bY: Ubyte, res: Vec2ub = Vec2ub()) = shl(res, this, bX, bY)

    @JvmOverloads
    fun shl(bX: Byte, bY: Byte, res: Vec2ub = Vec2ub()) = shl(res, this, bX, bY)

    @JvmOverloads
    fun shl(bX: Int, bY: Int, res: Vec2ub = Vec2ub()) = shl(res, this, bX, bY)

    infix fun shlAssign(b: Ubyte) = shl(this, this, b, b)
    infix fun shlAssign(b: Byte) = shl(this, this, b, b)
    infix fun shlAssign(b: Int) = shl(this, this, b, b)
    infix fun shlAssign(b: Vec2ub) = shl(this, this, b.x, b.y)
    fun shlAssign(bX: Ubyte, bY: Ubyte) = shl(this, this, bX, bY)
    fun shlAssign(bX: Byte, bY: Byte) = shl(this, this, bX, bY)
    fun shlAssign(bX: Int, bY: Int) = shl(this, this, bX, bY)


    infix fun shr(b: Ubyte) = shr(Vec2ub(), this, b, b)
    infix fun shr(b: Byte) = shr(Vec2ub(), this, b, b)
    infix fun shr(b: Int) = shr(Vec2ub(), this, b, b)
    infix fun shr(b: Vec2ub) = shr(Vec2ub(), this, b.x, b.y)

    fun shr(b: Ubyte, res: Vec2ub) = shr(res, this, b, b)
    fun shr(b: Byte, res: Vec2ub) = shr(res, this, b, b)
    fun shr(b: Int, res: Vec2ub) = shr(res, this, b, b)
    fun shr(b: Vec2ub, res: Vec2ub) = shr(res, this, b.x, b.y)
    @JvmOverloads
    fun shr(bX: Ubyte, bY: Ubyte, res: Vec2ub = Vec2ub()) = shr(res, this, bX, bY)

    @JvmOverloads
    fun shr(bX: Byte, bY: Byte, res: Vec2ub = Vec2ub()) = shr(res, this, bX, bY)

    @JvmOverloads
    fun shr(bX: Int, bY: Int, res: Vec2ub = Vec2ub()) = shr(res, this, bX, bY)

    infix fun shrAssign(b: Ubyte) = shr(this, this, b, b)
    infix fun shrAssign(b: Byte) = shr(this, this, b, b)
    infix fun shrAssign(b: Int) = shr(this, this, b, b)
    infix fun shrAssign(b: Vec2ub) = shr(this, this, b.x, b.y)
    fun shrAssign(bX: Ubyte, bY: Ubyte) = shr(this, this, bX, bY)
    fun shrAssign(bX: Byte, bY: Byte) = shr(this, this, bX, bY)
    fun shrAssign(bX: Int, bY: Int) = shr(this, this, bX, bY)


    @JvmOverloads
    fun inv(res: Vec2ub = Vec2ub()) = inv(res, this)

    fun invAssign() = inv(this, this)


    // -- Generic bitwise operators --

    infix fun and(b: Number) = and(Vec2ub(), this, b.b, b.b)
    infix fun and(b: Vec2t<out Number>) = and(Vec2ub(), this, b.x.b, b.y.b)

    fun and(b: Number, res: Vec2ub) = and(res, this, b.i, b.i)
    fun and(b: Vec2t<out Number>, res: Vec2ub) = and(res, this, b.x.i, b.y.i)
    @JvmOverloads
    fun and(bX: Number, bY: Number, res: Vec2ub = Vec2ub()) = and(res, this, bX.i, bY.i)

    infix fun andAssign(b: Number) = and(this, this, b.i, b.i)
    infix fun andAssign(b: Vec2t<out Number>) = and(this, this, b.x.i, b.y.i)
    fun andAssign(bX: Number, bY: Number) = and(this, this, bX.i, bY.i)


    infix fun or(b: Number) = or(Vec2ub(), this, b.i, b.i)
    infix fun or(b: Vec2t<out Number>) = or(Vec2ub(), this, b.x.i, b.y.i)

    fun or(b: Number, res: Vec2ub) = or(res, this, b.i, b.i)
    fun or(b: Vec2t<out Number>, res: Vec2ub) = or(res, this, b.x.i, b.y.i)
    @JvmOverloads
    fun or(bX: Number, bY: Number, res: Vec2ub = Vec2ub()) = or(res, this, bX.i, bY.i)

    infix fun orAssign(b: Number) = or(this, this, b.i, b.i)
    infix fun orAssign(b: Vec2t<out Number>) = or(this, this, b.x.i, b.y.i)
    fun orAssign(bX: Number, bY: Number) = or(this, this, bX.i, bY.i)


    infix fun xor(b: Number) = xor(Vec2ub(), this, b.i, b.i)
    infix fun xor(b: Vec2t<out Number>) = xor(Vec2ub(), this, b.x.i, b.y.i)

    fun xor(b: Number, res: Vec2ub) = xor(res, this, b.i, b.i)
    fun xor(b: Vec2t<out Number>, res: Vec2ub) = xor(res, this, b.x.i, b.y.i)
    @JvmOverloads
    fun xor(bX: Number, bY: Number, res: Vec2ub = Vec2ub()) = xor(res, this, bX.i, bY.i)

    infix fun xorAssign(b: Number) = xor(this, this, b.i, b.i)
    infix fun xorAssign(b: Vec2t<out Number>) = xor(this, this, b.x.i, b.y.i)
    fun xorAssign(bX: Number, bY: Number) = xor(this, this, bX.i, bY.i)


    infix fun shl(b: Number) = shl(Vec2ub(), this, b.i, b.i)
    infix fun shl(b: Vec2t<out Number>) = shl(Vec2ub(), this, b.x.i, b.y.i)

    fun shl(b: Number, res: Vec2ub) = shl(res, this, b.i, b.i)
    fun shl(b: Vec2t<out Number>, res: Vec2ub) = shl(res, this, b.x.i, b.y.i)
    @JvmOverloads
    fun shl(bX: Number, bY: Number, res: Vec2ub = Vec2ub()) = shl(res, this, bX.i, bY.i)

    infix fun shlAssign(b: Number) = shl(this, this, b.i, b.i)
    infix fun shlAssign(b: Vec2t<out Number>) = shl(this, this, b.x.i, b.y.i)
    fun shlAssign(bX: Number, bY: Number) = shl(this, this, bX.i, bY.i)


    infix fun shr(b: Number) = shr(Vec2ub(), this, b.i, b.i)
    infix fun shr(b: Vec2t<out Number>) = shr(Vec2ub(), this, b.x.i, b.y.i)

    fun shr(b: Number, res: Vec2ub) = shr(res, this, b.i, b.i)
    fun shr(b: Vec2t<out Number>, res: Vec2ub) = shr(res, this, b.x.i, b.y.i)
    @JvmOverloads
    fun shr(bX: Number, bY: Number, res: Vec2ub = Vec2ub()) = shr(res, this, bX.i, bY.i)

    infix fun shrAssign(b: Number) = shr(this, this, b.i, b.i)
    infix fun shrAssign(b: Vec2t<out Number>) = shr(this, this, b.x.i, b.y.i)
    fun shrAssign(bX: Number, bY: Number) = shr(this, this, bX.i, bY.i)


    infix fun allLessThan(ub: Ubyte): Boolean = x < ub && y < ub
    infix fun anyLessThan(ub: Ubyte): Boolean = x < ub || y < ub
    infix fun lessThan(ub: Ubyte): Vec2bool = Vec2bool { get(it) < ub }

    infix fun allLessThanEqual(ub: Ubyte): Boolean = x <= ub && y <= ub
    infix fun anyLessThanEqual(ub: Ubyte): Boolean = x <= ub || y <= ub
    infix fun lessThanEqual(ub: Ubyte): Vec2bool = Vec2bool { get(it) <= ub }

    infix fun allEqual(ub: Ubyte): Boolean = x == ub && y == ub
    infix fun anyEqual(ub: Ubyte): Boolean = x == ub || y == ub
    infix fun equal(ub: Ubyte): Vec2bool = Vec2bool { get(it) == ub }

    infix fun allNotEqual(ub: Ubyte): Boolean = x != ub && y != ub
    infix fun anyNotEqual(ub: Ubyte): Boolean = x != ub || y != ub
    infix fun notEqual(ub: Ubyte): Vec2bool = Vec2bool { get(it) != ub }

    infix fun allGreaterThan(ub: Ubyte): Boolean = x > ub && y > ub
    infix fun anyGreaterThan(ub: Ubyte): Boolean = x > ub || y > ub
    infix fun greaterThan(ub: Ubyte): Vec2bool = Vec2bool { get(it) > ub }

    infix fun allGreaterThanEqual(ub: Ubyte): Boolean = x >= ub && y >= ub
    infix fun anyGreaterThanEqual(ub: Ubyte): Boolean = x >= ub || y >= ub
    infix fun greaterThanEqual(ub: Ubyte): Vec2bool = Vec2bool { get(it) >= ub }


    infix fun allLessThan(v: Vec2ub): Boolean = x < v.x && y < v.y
    infix fun anyLessThan(v: Vec2ub): Boolean = x < v.x || y < v.y
    infix fun lessThan(v: Vec2ub): Vec2bool = Vec2bool { get(it) < v[it] }

    infix fun allLessThanEqual(v: Vec2ub): Boolean = x <= v.x && y <= v.y
    infix fun anyLessThanEqual(v: Vec2ub): Boolean = x <= v.x || y <= v.y
    infix fun lessThanEqual(v: Vec2ub): Vec2bool = Vec2bool { get(it) <= v[it] }

    infix fun allEqual(v: Vec2ub): Boolean = x == v.x && y == v.y
    infix fun anyEqual(v: Vec2ub): Boolean = x == v.x || y == v.y
    infix fun equal(v: Vec2ub): Vec2bool = Vec2bool { get(it) == v[it] }

    infix fun allNotEqual(v: Vec2ub): Boolean = x != v.x && y != v.y
    infix fun anyNotEqual(v: Vec2ub): Boolean = x != v.x || y != v.y
    infix fun notEqual(v: Vec2ub): Vec2bool = Vec2bool { get(it) != v[it] }

    infix fun allGreaterThan(v: Vec2ub): Boolean = x > v.x && y > v.y
    infix fun anyGreaterThan(v: Vec2ub): Boolean = x > v.x || y > v.y
    infix fun greaterThan(v: Vec2ub): Vec2bool = Vec2bool { get(it) > v[it] }

    infix fun allGreaterThanEqual(v: Vec2ub): Boolean = x >= v.x && y >= v.y
    infix fun anyGreaterThanEqual(v: Vec2ub): Boolean = x >= v.x || y >= v.y
    infix fun greaterThanEqual(v: Vec2ub): Vec2bool = Vec2bool { get(it) >= v[it] }


    companion object : opVec2ub {
        const val length = Vec2t.length
        @JvmField
        val size = length * Ubyte.BYTES

        @JvmStatic
        fun fromPointer(ptr: Ptr<Ubyte>) = Vec2ub(ptr)
    }

    override fun size() = size

    override fun equals(other: Any?) = other is Vec2ub && this[0] == other[0] && this[1] == other[1]
    fun equal(b: Vec2ub, epsilon: Byte = 0): Boolean = abs(x.v - b.x.v) <= epsilon && abs(y.v - b.y.v) <= epsilon // TODO check
    fun notEqual(b: Vec2ub, epsilon: Byte = 0): Boolean = !equal(b, epsilon)

    override fun hashCode() = 31 * x.v.hashCode() + y.v.hashCode()

    @JvmOverloads
    fun print(name: String = "", stream: PrintStream = System.out) = stream.print("$name$this")

    @JvmOverloads
    fun println(name: String = "", stream: PrintStream = System.out) = stream.println("$name$this")
}