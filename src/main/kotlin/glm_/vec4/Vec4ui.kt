package glm_.vec4

import glm_.*
import glm_.vec1.Vec1bool
import glm_.vec1.Vec1t
import glm_.vec2.Vec2bool
import glm_.vec2.Vec2t
import glm_.vec2.Vec2ui
import glm_.vec3.Vec3bool
import glm_.vec3.Vec3t
import glm_.vec3.Vec3ui
import glm_.vec4.operators.vec4ui_operators
import kool.*
import org.lwjgl.system.MemoryStack
import unsigned.Uint
import unsigned.UintArray
import unsigned.toUint
import java.io.PrintStream
import java.nio.*

/**
 * Created by elect on 09/10/16.
 */

class Vec4ui(@JvmField var ofs: Int, var array: UintArray) : Vec4t<Uint>, ToBuffer {

    inline var x: Uint
        get() = array[ofs]
        set(value) = array.set(ofs, value)
    inline var y: Uint
        get() = array[ofs + 1]
        set(value) = array.set(ofs + 1, value)
    inline var z: Uint
        get() = array[ofs + 2]
        set(value) = array.set(ofs + 2, value)
    inline var w: Uint
        get() = array[ofs + 3]
        set(value) = array.set(ofs + 3, value)

    inline var vX: Int
        get() = array[ofs].toInt()
        set(value) = array.set(ofs, value.toUint())
    inline var vY: Int
        get() = array[ofs + 1].toInt()
        set(value) = array.set(ofs + 1, value.toUint())
    inline var vZ: Int
        get() = array[ofs + 2].toInt()
        set(value) = array.set(ofs + 2, value.toUint())
    inline var vW: Int
        get() = array[ofs + 3].toInt()
        set(value) = array.set(ofs + 3, value.toUint())

    // -- Implicit basic constructors --

    constructor() : this(0)
    constructor(v: Vec4ui) : this(v.x, v.y, v.z, v.w)
    constructor(v: Vec3ui) : this(v.x, v.y, v.z, Uint(0))
    constructor(v: Vec2ui) : this(v.x, v.y, Uint(0), Uint(0))

    // -- Explicit basic constructors --

    constructor(x: Uint) : this(x, x, x, x)
    constructor(x: Uint, y: Uint, z: Uint, w: Uint) : this(0, UintArray(intArrayOf(x.v, y.v, z.v, w.v)))
    constructor(x: Int) : this(x, x, x, x)
    constructor(x: Int, y: Int, z: Int, w: Int) : this(0, UintArray(intArrayOf(x, y, z, w)))

    // -- Conversion scalar constructors --

    constructor(v: Vec1t<out Number>) : this(v._x)

    // Explicit conversions (From section 5.4.1 Conversion and scalar constructors of GLSL 1.30.08 specification)

    constructor(v: Number) : this(v.ui)
    constructor(x: Number, y: Number, z: Number, w: Number) : this(x.ui, y.ui, z.ui, w.ui)

    constructor(x: Vec1t<out Number>, y: Number, z: Number, w: Number) : this(x._x, y, z, w)
    constructor(x: Number, y: Vec1t<out Number>, z: Number, w: Number) : this(x, y._x, z, w)
    constructor(x: Vec1t<out Number>, y: Vec1t<out Number>, z: Number, w: Number) : this(x._x, y._x, z, w)
    constructor(x: Number, y: Number, z: Vec1t<out Number>, w: Number) : this(x, y, z._x, w)
    constructor(x: Vec1t<out Number>, y: Number, z: Vec1t<out Number>, w: Number) : this(x._x, y, z._x, w)
    constructor(x: Number, y: Vec1t<out Number>, z: Vec1t<out Number>, w: Number) : this(x, y._x, z._x, w)
    constructor(x: Vec1t<out Number>, y: Vec1t<out Number>, z: Vec1t<out Number>, w: Number) : this(x._x, y._x, z._x, w)
    constructor(x: Vec1t<out Number>, y: Number, z: Number, w: Vec1t<out Number>) : this(x._x, y, z, w._x)
    constructor(x: Number, y: Vec1t<out Number>, z: Number, w: Vec1t<out Number>) : this(x, y._x, z, w._x)
    constructor(x: Vec1t<out Number>, y: Vec1t<out Number>, z: Number, w: Vec1t<out Number>) : this(x._x, y._x, z, w._x)
    constructor(x: Number, y: Number, z: Vec1t<out Number>, w: Vec1t<out Number>) : this(x, y, z._x, w._x)
    constructor(x: Vec1t<out Number>, y: Number, z: Vec1t<out Number>, w: Vec1t<out Number>) : this(x._x, y, z._x, w._x)
    constructor(x: Number, y: Vec1t<out Number>, z: Vec1t<out Number>, w: Vec1t<out Number>) : this(x, y._x, z._x, w._x)
    constructor(x: Vec1t<out Number>, y: Vec1t<out Number>, z: Vec1t<out Number>, w: Vec1t<out Number>) : this(x._x, y._x, z._x, w._x)

    constructor(xy: Vec2t<out Number>, z: Number, w: Number) : this(xy._x, xy._y, z, w)
    constructor(xy: Vec2t<out Number>, z: Vec1t<out Number>, w: Number) : this(xy._x, xy._y, z._x, w)
    constructor(xy: Vec2t<out Number>, z: Number, w: Vec1t<out Number>) : this(xy._x, xy._y, z, w._x)
    constructor(xy: Vec2t<out Number>, z: Vec1t<out Number>, w: Vec1t<out Number>) : this(xy._x, xy._y, z._x, w._x)
    constructor(x: Number, yz: Vec2t<out Number>, w: Number) : this(x, yz._x, yz._y, w)
    constructor(x: Vec1t<out Number>, yz: Vec2t<out Number>, w: Number) : this(x._x, yz._x, yz._y, w)
    constructor(x: Number, yz: Vec2t<out Number>, w: Vec1t<out Number>) : this(x, yz._x, yz._y, w._x)
    constructor(x: Vec1t<out Number>, yz: Vec2t<out Number>, w: Vec1t<out Number>) : this(x._x, yz._x, yz._y, w._x)
    constructor(x: Number, y: Number, zw: Vec2t<out Number>) : this(x, y, zw._x, zw._y)
    constructor(x: Vec1t<out Number>, y: Number, zw: Vec2t<out Number>) : this(x._x, y, zw._x, zw._y)
    constructor(x: Number, y: Vec1t<out Number>, zw: Vec2t<out Number>) : this(x, y, zw._x, zw._y)
    constructor(x: Vec1t<out Number>, y: Vec1t<out Number>, zw: Vec2t<out Number>) : this(x._x, y._x, zw._x, zw._y)
    constructor(xyz: Vec3t<out Number>, w: Number) : this(xyz._x, xyz._y, xyz._z, w)
    constructor(xyz: Vec3t<out Number>, w: Vec1t<out Number>) : this(xyz._x, xyz._y, xyz._z, w._x)
    constructor(x: Number, yzw: Vec3t<out Number>) : this(x, yzw._x, yzw._y, yzw._z)
    constructor(x: Vec1t<out Number>, yzw: Vec3t<out Number>) : this(x._x, yzw._x, yzw._y, yzw._z)
    constructor(xy: Vec2t<out Number>, zw: Vec2t<out Number>) : this(xy._x, xy._y, zw._x, zw._y)
    constructor(v: Vec4t<out Number>) : this(v._x, v._y, v._z, v._w)

    constructor(v: Vec1bool) : this(v.x.ui, 0, 0, 1)
    constructor(v: Vec2bool) : this(v.x.ui, v.y.ui, 0, 1)
    constructor(v: Vec3bool) : this(v.x.ui, v.y.ui, v.z.ui, 1)
    constructor(v: Vec4bool) : this(v.x.ui, v.y.ui, v.z.ui, v.w.ui)

    constructor(bytes: ByteArray, index: Int = 0, oneByteOneUint: Boolean = false, bigEndian: Boolean = true) : this(
            if (oneByteOneUint) bytes[index].ui else bytes.getUint(index, bigEndian),
            if (oneByteOneUint) bytes[index + 1].ui else bytes.getUint(index + Uint.BYTES, bigEndian),
            if (oneByteOneUint) bytes[index + 2].ui else bytes.getUint(index + Uint.BYTES * 2, bigEndian),
            if (oneByteOneUint) bytes[index + 3].ui else bytes.getUint(index + Uint.BYTES * 3, bigEndian))

    constructor(chars: CharArray, index: Int = 0) : this(chars[index].ui, chars[index + 1].ui, chars[index + 2].ui, chars[index + 3].ui)
    constructor(shorts: ShortArray, index: Int = 0) : this(shorts[index], shorts[index + 1], shorts[index + 2], shorts[index + 3])
    constructor(ints: IntArray, index: Int = 0) : this(ints[index], ints[index + 1], ints[index + 2], ints[index + 3])
    constructor(longs: LongArray, index: Int = 0) : this(longs[index], longs[index + 1], longs[index + 2], longs[index + 3])
    constructor(floats: FloatArray, index: Int = 0) : this(floats[index], floats[index + 1], floats[index + 2], floats[index + 3])
    constructor(doubles: DoubleArray, index: Int = 0) : this(doubles[index], doubles[index + 1], doubles[index + 2], doubles[index + 3])
    constructor(booleans: BooleanArray, index: Int = 0) : this(booleans[index].ui, booleans[index + 1].ui, booleans[index + 2].ui, booleans[index + 3].ui)

    constructor(numbers: Array<out Number>, index: Int = 0) : this(numbers[index], numbers[index + 1], numbers[index + 2], numbers[index + 3])
    constructor(chars: Array<Char>, index: Int = 0) : this(chars[index].ui, chars[index + 1].ui, chars[index + 2].ui, chars[index + 3].ui)
    constructor(booleans: Array<Boolean>, index: Int = 0) : this(booleans[index].ui, booleans[index + 1].ui, booleans[index + 2].ui, booleans[index + 3].ui)

    constructor(list: Iterable<*>, index: Int = 0) : this(list.elementAt(index)!!.toInt, list.elementAt(index + 1)!!.toInt,
            list.elementAt(index + 2)!!.toInt, list.elementAt(index + 3)!!.toInt)

    constructor(bytes: ByteBuffer, index: Int = bytes.pos, oneByteOneUint: Boolean = false) : this(
            if (oneByteOneUint) bytes[index].ui else bytes.getInt(index).ui,
            if (oneByteOneUint) bytes[index + 1].ui else bytes.getInt(index + Uint.BYTES).ui,
            if (oneByteOneUint) bytes[index + 2].ui else bytes.getInt(index + Uint.BYTES * 2).ui,
            if (oneByteOneUint) bytes[index + 3].ui else bytes.getInt(index + Uint.BYTES * 3).ui)

    constructor(chars: CharBuffer, index: Int = chars.pos) : this(chars[index].ui, chars[index + 1].ui, chars[index + 2].ui, chars[index + 3].ui)
    constructor(shorts: ShortBuffer, index: Int = shorts.pos) : this(shorts[index], shorts[index + 1], shorts[index + 2], shorts[index + 3])
    constructor(ints: IntBuffer, index: Int = ints.pos) : this(ints[index], ints[index + 1], ints[index + 2], ints[index + 3])
    constructor(longs: LongBuffer, index: Int = longs.pos) : this(longs[index], longs[index + 1], longs[index + 2], longs[index + 3])
    constructor(floats: FloatBuffer, index: Int = floats.pos) : this(floats[index], floats[index + 1], floats[index + 2], floats[index + 3])
    constructor(doubles: DoubleBuffer, index: Int = doubles.pos) : this(doubles[index], doubles[index + 1], doubles[index + 2], doubles[index + 3])

    constructor(block: (Int) -> Uint) : this(block(0), block(1), block(2), block(3))
    constructor(ptr: Ptr<Uint>) : this() {
        val p = ptr.toPtr<Int>()
        x.v = p[0]
        y.v = p[1]
        z.v = p[2]
        w.v = p[3]
    }


    fun set(bytes: ByteArray, index: Int = 0, oneByteOneUint: Boolean = false, bigEndian: Boolean = true) {
        x.v = if (oneByteOneUint) bytes[index].i else bytes.getInt(index, bigEndian)
        y.v = if (oneByteOneUint) bytes[index + 1].i else bytes.getInt(index + Uint.BYTES, bigEndian)
        z.v = if (oneByteOneUint) bytes[index + 2].i else bytes.getInt(index + Uint.BYTES * 2, bigEndian)
        w.v = if (oneByteOneUint) bytes[index + 3].i else bytes.getInt(index + Uint.BYTES * 3, bigEndian)
    }

    fun set(bytes: ByteBuffer, index: Int = bytes.pos, oneByteOneUint: Boolean = false) {
        x.v = if (oneByteOneUint) bytes[index].i else bytes.getInt(index)
        y.v = if (oneByteOneUint) bytes[index + 1].i else bytes.getInt(index + Uint.BYTES)
        z.v = if (oneByteOneUint) bytes[index + 2].i else bytes.getInt(index + Uint.BYTES * 2)
        w.v = if (oneByteOneUint) bytes[index + 3].i else bytes.getInt(index + Uint.BYTES * 3)
    }


    fun put(x: Uint, y: Uint, z: Uint, w: Uint) {
        this.x = x
        this.y = y
        this.z = z
        this.w = w
    }

    fun put(x: Int, y: Int, z: Int, w: Int) {
        this.x.v = x
        this.y.v = y
        this.z.v = z
        this.w.v = w
    }

    operator fun invoke(x: Uint, y: Uint, z: Uint, w: Uint): Vec4ui {
        this.x = x
        this.y = y
        this.z = z
        this.w = w
        return this
    }

    operator fun invoke(x: Int, y: Int, z: Int, w: Int): Vec4ui {
        this.x.v = x
        this.y.v = y
        this.z.v = z
        this.w.v = w
        return this
    }

    override fun put(x: Number, y: Number, z: Number, w: Number) {
        this.x = x.ui
        this.y = y.ui
        this.z = z.ui
        this.w = w.ui
    }

    override operator fun invoke(x: Number, y: Number, z: Number, w: Number): Vec4ui {
        this.x = x.ui
        this.y = y.ui
        this.z = z.ui
        this.w = w.ui
        return this
    }

    fun to(bytes: ByteArray, index: Int): ByteArray = to(bytes, index, true)
    override fun to(bytes: ByteArray, index: Int, bigEndian: Boolean): ByteArray {
        bytes.putInt(index, x.v, bigEndian)
        bytes.putInt(index + Uint.BYTES, y.v, bigEndian)
        bytes.putInt(index + Uint.BYTES * 2, z.v, bigEndian)
        bytes.putInt(index + Uint.BYTES * 3, w.v, bigEndian)
        return bytes
    }

    fun toIntArray(): IntArray = to(IntArray(length), 0)
    infix fun to(ints: IntArray): IntArray = to(ints, 0)
    fun to(ints: IntArray, index: Int): IntArray {
        System.arraycopy(array, ofs, ints, index, length)
        return ints
    }

    override fun to(buf: ByteBuffer, offset: Int): ByteBuffer {
        buf.putInt(offset, x.v)
        buf.putInt(offset + Uint.BYTES, y.v)
        buf.putInt(offset + Uint.BYTES * 2, z.v)
        buf.putInt(offset + Uint.BYTES * 3, w.v)
        return buf
    }

    fun toIntBufferStack(): IntBuffer = to(MemoryStack.stackGet().mallocInt(length), 0)
    infix fun toIntBuffer(stack: MemoryStack): IntBuffer = to(stack.mallocInt(length), 0)
    fun toIntBuffer(): IntBuffer = to(IntBuffer(length), 0)
    infix fun to(buf: IntBuffer): IntBuffer = to(buf, buf.pos)
    fun to(buf: IntBuffer, index: Int): IntBuffer {
        buf[index] = x.v
        buf[index + 1] = y.v
        buf[index + 2] = z.v
        buf[index + 3] = w.v
        return buf
    }

    // -- Component accesses --

    operator fun set(index: Int, value: Int) = when (index) {
        0 -> x.v = value
        1 -> y.v = value
        2 -> z.v = value
        3 -> w.v = value
        else -> throw ArrayIndexOutOfBoundsException()
    }

    override operator fun set(index: Int, value: Number) = when (index) {
        0 -> x = value.ui
        1 -> y = value.ui
        2 -> z = value.ui
        3 -> w = value.ui
        else -> throw ArrayIndexOutOfBoundsException()
    }


    // -- Unary arithmetic operators --

    operator fun unaryPlus() = this

    // no unaryMinus operator, only signed

    // -- Increment main.and decrement operators --

    operator fun inc(res: Vec4ui = Vec4ui()) = plus(res, this, 1, 1, 1, 1)
    fun incAssign() = plus(this, this, 1, 1, 1, 1)


    operator fun dec(res: Vec4ui = Vec4ui()) = minus(res, this, 1, 1, 1, 1)
    fun decAssign() = minus(this, this, 1, 1, 1, 1)


    // -- Specific binary arithmetic operators --

    operator fun plus(b: Uint) = plus(Vec4ui(), this, b, b, b, b)
    operator fun plus(b: Int) = plus(Vec4ui(), this, b, b, b, b)
    operator fun plus(b: Vec4ui) = plus(Vec4ui(), this, b.x, b.y, b.z, b.w)

    fun plus(bX: Uint, bY: Uint, bZ: Uint, bW: Uint, res: Vec4ui = Vec4ui()) = plus(res, this, bX, bY, bZ, bW)
    fun plus(bX: Int, bY: Int, bZ: Int, bW: Int, res: Vec4ui = Vec4ui()) = plus(res, this, bX, bY, bZ, bW)
    fun plus(b: Uint, res: Vec4ui = Vec4ui()) = plus(res, this, b, b, b, b)
    fun plus(b: Int, res: Vec4ui = Vec4ui()) = plus(res, this, b, b, b, b)
    fun plus(b: Vec4ui, res: Vec4ui = Vec4ui()) = plus(res, this, b.x, b.y, b.z, b.w)

    fun plusAssign(bX: Uint, bY: Uint, bZ: Uint, bW: Uint) = plus(this, this, bX, bY, bZ, bW)
    fun plusAssign(bX: Int, bY: Int, bZ: Int, bW: Int) = plus(this, this, bX, bY, bZ, bW)
    infix operator fun plusAssign(b: Uint) {
        plus(this, this, b, b, b, b)
    }

    infix operator fun plusAssign(b: Int) {
        plus(this, this, b, b, b, b)
    }

    infix operator fun plusAssign(b: Vec4ui) {
        plus(this, this, b.x, b.y, b.z, b.w)
    }


    operator fun minus(b: Uint) = minus(Vec4ui(), this, b, b, b, b)
    operator fun minus(b: Int) = minus(Vec4ui(), this, b, b, b, b)
    operator fun minus(b: Vec4ui) = minus(Vec4ui(), this, b.x, b.y, b.z, b.w)

    fun minus(bX: Uint, bY: Uint, bZ: Uint, bW: Uint, res: Vec4ui = Vec4ui()) = minus(res, this, bX, bY, bZ, bW)
    fun minus(bX: Int, bY: Int, bZ: Int, bW: Int, res: Vec4ui = Vec4ui()) = minus(res, this, bX, bY, bZ, bW)
    fun minus(b: Uint, res: Vec4ui = Vec4ui()) = minus(res, this, b, b, b, b)
    fun minus(b: Int, res: Vec4ui = Vec4ui()) = minus(res, this, b, b, b, b)
    fun minus(b: Vec4ui, res: Vec4ui = Vec4ui()) = minus(res, this, b.x, b.y, b.z, b.w)

    fun minusAssign(bX: Uint, bY: Uint, bZ: Uint, bW: Uint) = minus(this, this, bX, bY, bZ, bW)
    fun minusAssign(bX: Int, bY: Int, bZ: Int, bW: Int) = minus(this, this, bX, bY, bZ, bW)
    infix operator fun minusAssign(b: Uint) {
        minus(this, this, b, b, b, b)
    }

    infix operator fun minusAssign(b: Int) {
        minus(this, this, b, b, b, b)
    }

    infix operator fun minusAssign(b: Vec4ui) {
        minus(this, this, b.x, b.y, b.z, b.w)
    }


    operator fun times(b: Uint) = times(Vec4ui(), this, b, b, b, b)
    operator fun times(b: Int) = times(Vec4ui(), this, b, b, b, b)
    operator fun times(b: Vec4ui) = times(Vec4ui(), this, b.x, b.y, b.z, b.w)

    fun times(bX: Uint, bY: Uint, bZ: Uint, bW: Uint, res: Vec4ui = Vec4ui()) = times(res, this, bX, bY, bZ, bW)
    fun times(bX: Int, bY: Int, bZ: Int, bW: Int, res: Vec4ui = Vec4ui()) = times(res, this, bX, bY, bZ, bW)
    fun times(b: Uint, res: Vec4ui = Vec4ui()) = times(res, this, b, b, b, b)
    fun times(b: Int, res: Vec4ui = Vec4ui()) = times(res, this, b, b, b, b)
    fun times(b: Vec4ui, res: Vec4ui = Vec4ui()) = times(res, this, b.x, b.y, b.z, b.w)

    fun timesAssign(bX: Uint, bY: Uint, bZ: Uint, bW: Uint) = times(this, this, bX, bY, bZ, bW)
    fun timesAssign(bX: Int, bY: Int, bZ: Int, bW: Int) = times(this, this, bX, bY, bZ, bW)
    infix operator fun timesAssign(b: Uint) {
        times(this, this, b, b, b, b)
    }

    infix operator fun timesAssign(b: Int) {
        times(this, this, b, b, b, b)
    }

    infix operator fun timesAssign(b: Vec4ui) {
        times(this, this, b.x, b.y, b.z, b.w)
    }


    operator fun div(b: Uint) = div(Vec4ui(), this, b, b, b, b)
    operator fun div(b: Int) = div(Vec4ui(), this, b, b, b, b)
    operator fun div(b: Vec4ui) = div(Vec4ui(), this, b.x, b.y, b.z, b.w)

    fun div(bX: Uint, bY: Uint, bZ: Uint, bW: Uint, res: Vec4ui = Vec4ui()) = div(res, this, bX, bY, bZ, bW)
    fun div(bX: Int, bY: Int, bZ: Int, bW: Int, res: Vec4ui = Vec4ui()) = div(res, this, bX, bY, bZ, bW)
    fun div(b: Uint, res: Vec4ui) = div(res, this, b, b, b, b)
    fun div(b: Int, res: Vec4ui) = div(res, this, b, b, b, b)
    fun div(b: Vec4ui, res: Vec4ui) = div(res, this, b.x, b.y, b.z, b.w)

    fun divAssign(bX: Uint, bY: Uint, bZ: Uint, bW: Uint) = div(this, this, bX, bY, bZ, bW)
    fun divAssign(bX: Int, bY: Int, bZ: Int, bW: Int) = div(this, this, bX, bY, bZ, bW)
    infix operator fun divAssign(b: Uint) {
        div(this, this, b, b, b, b)
    }

    infix operator fun divAssign(b: Int) {
        div(this, this, b, b, b, b)
    }

    infix operator fun divAssign(b: Vec4ui) {
        div(this, this, b.x, b.y, b.z, b.w)
    }


    operator fun rem(b: Uint) = rem(Vec4ui(), this, b, b, b, b)
    operator fun rem(b: Int) = rem(Vec4ui(), this, b, b, b, b)
    operator fun rem(b: Vec4ui) = rem(Vec4ui(), this, b.x, b.y, b.z, b.w)

    fun rem(bX: Uint, bY: Uint, bZ: Uint, bW: Uint, res: Vec4ui = Vec4ui()) = rem(res, this, bX, bY, bZ, bW)
    fun rem(bX: Int, bY: Int, bZ: Int, bW: Int, res: Vec4ui = Vec4ui()) = rem(res, this, bX, bY, bZ, bW)
    fun rem(b: Uint, res: Vec4ui) = rem(res, this, b, b, b, b)
    fun rem(b: Int, res: Vec4ui) = rem(res, this, b, b, b, b)
    fun rem(b: Vec4ui, res: Vec4ui) = rem(res, this, b.x, b.y, b.z, b.w)

    fun remAssign(bX: Uint, bY: Uint, bZ: Uint, bW: Uint) = rem(this, this, bX, bY, bZ, bW)
    fun remAssign(bX: Int, bY: Int, bZ: Int, bW: Int) = rem(this, this, bX, bY, bZ, bW)
    infix operator fun remAssign(b: Uint) {
        rem(this, this, b, b, b, b)
    }

    infix operator fun remAssign(b: Int) {
        rem(this, this, b, b, b, b)
    }

    infix operator fun remAssign(b: Vec4ui) {
        rem(this, this, b.x, b.y, b.z, b.w)
    }


    // -- Generic binary arithmetic operators --

    operator fun plus(b: Number) = plus(Vec4ui(), this, b.i, b.i, b.i, b.i)
    operator fun plus(b: Vec4t<out Number>) = plus(Vec4ui(), this, b._x.i, b._y.i, b._z.i, b._w.i)

    fun plus(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4ui = Vec4ui()) = plus(res, this, bX.i, bY.i, bZ.i, bW.i)
    fun plus(b: Number, res: Vec4ui = Vec4ui()) = plus(res, this, b.i, b.i, b.i, b.i)
    fun plus(b: Vec4t<out Number>, res: Vec4ui = Vec4ui()) = plus(res, this, b._x.i, b._y.i, b._z.i, b._w.i)

    fun plusAssign(bX: Number, bY: Number, bZ: Number, bW: Number) = plus(this, this, bX.i, bY.i, bZ.i, bW.i)
    infix operator fun plusAssign(b: Number) {
        plus(this, this, b.i, b.i, b.i, b.i)
    }

    infix operator fun plusAssign(b: Vec4t<out Number>) {
        plus(this, this, b._x.i, b._y.i, b._z.i, b._w.i)
    }


    operator fun minus(b: Number) = minus(Vec4ui(), this, b.i, b.i, b.i, b.i)
    operator fun minus(b: Vec4t<out Number>) = minus(Vec4ui(), this, b._x.i, b._y.i, b._z.i, b._w.i)

    fun minus(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4ui = Vec4ui()) = minus(res, this, bX.i, bY.i, bZ.i, bW.i)
    fun minus(b: Number, res: Vec4ui = Vec4ui()) = minus(res, this, b.i, b.i, b.i, b.i)
    fun minus(b: Vec4t<out Number>, res: Vec4ui = Vec4ui()) = minus(res, this, b._x.i, b._y.i, b._z.i, b._w.i)

    fun minusAssign(bX: Number, bY: Number, bZ: Number, bW: Number) = minus(this, this, bX.i, bY.i, bZ.i, bW.i)
    infix operator fun minusAssign(b: Number) {
        minus(this, this, b.i, b.i, b.i, b.i)
    }

    infix operator fun minusAssign(b: Vec4t<out Number>) {
        minus(this, this, b._x.i, b._y.i, b._z.i, b._w.i)
    }


    operator fun times(b: Number) = times(Vec4ui(), this, b.i, b.i, b.i, b.i)
    operator fun times(b: Vec4t<out Number>) = times(Vec4ui(), this, b._x.i, b._y.i, b._z.i, b._w.i)

    fun times(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4ui = Vec4ui()) = times(res, this, bX.i, bY.i, bZ.i, bW.i)
    fun times(b: Number, res: Vec4ui = Vec4ui()) = times(res, this, b.i, b.i, b.i, b.i)
    fun times(b: Vec4t<out Number>, res: Vec4ui = Vec4ui()) = times(res, this, b._x.i, b._y.i, b._z.i, b._w.i)

    fun timesAssign(bX: Number, bY: Number, bZ: Number, bW: Number) = times(this, this, bX.i, bY.i, bZ.i, bW.i)
    infix operator fun timesAssign(b: Number) {
        times(this, this, b.i, b.i, b.i, b.i)
    }

    infix operator fun timesAssign(b: Vec4t<out Number>) {
        times(this, this, b._x.i, b._y.i, b._z.i, b._w.i)
    }


    operator fun div(b: Number) = div(Vec4ui(), this, b.i, b.i, b.i, b.i)
    operator fun div(b: Vec4t<out Number>) = div(Vec4ui(), this, b._x.i, b._y.i, b._z.i, b._w.i)

    fun div(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4ui = Vec4ui()) = div(res, this, bX.i, bY.i, bZ.i, bW.i)
    fun div(b: Number, res: Vec4ui) = div(res, this, b.i, b.i, b.i, b.i)
    fun div(b: Vec4t<out Number>, res: Vec4ui) = div(res, this, b._x.i, b._y.i, b._z.i, b._w.i)

    fun divAssign(bX: Number, bY: Number, bZ: Number, bW: Number) = div(this, this, bX.i, bY.i, bZ.i, bW.i)
    infix operator fun divAssign(b: Number) {
        div(this, this, b.i, b.i, b.i, b.i)
    }

    infix operator fun divAssign(b: Vec4t<out Number>) {
        div(this, this, b._x.i, b._y.i, b._z.i, b._w.i)
    }


    operator fun rem(b: Number) = rem(Vec4ui(), this, b.i, b.i, b.i, b.i)
    operator fun rem(b: Vec4t<out Number>) = rem(Vec4ui(), this, b._x.i, b._y.i, b._z.i, b._w.i)

    fun rem(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4ui = Vec4ui()) = rem(res, this, bX.i, bY.i, bZ.i, bW.i)
    fun rem(b: Number, res: Vec4ui) = rem(res, this, b.i, b.i, b.i, b.i)
    fun rem(b: Vec4t<out Number>, res: Vec4ui) = rem(res, this, b._x.i, b._y.i, b._z.i, b._w.i)

    fun remAssign(bX: Number, bY: Number, bZ: Number, bW: Number) = rem(this, this, bX.i, bY.i, bZ.i, bW.i)
    infix operator fun remAssign(b: Number) {
        rem(this, this, b.i, b.i, b.i, b.i)
    }

    infix operator fun remAssign(b: Vec4t<out Number>) {
        rem(this, this, b._x.i, b._y.i, b._z.i, b._w.i)
    }


    // -- Specific bitwise operators --

    infix fun and(b: Uint) = and(Vec4ui(), this, b, b, b, b)
    infix fun and(b: Int) = and(Vec4ui(), this, b, b, b, b)
    infix fun and(b: Vec4ui) = and(Vec4ui(), this, b.x, b.y, b.z, b.w)

    infix fun andAssign(b: Uint) = and(this, this, b, b, b, b)
    infix fun andAssign(b: Int) = and(this, this, b, b, b, b)
    infix fun andAssign(b: Vec4ui) = and(this, this, b.x, b.y, b.z, b.w)

    fun and(b: Uint, res: Vec4ui) = and(res, this, b, b, b, b)
    fun and(b: Int, res: Vec4ui) = and(res, this, b, b, b, b)
    fun and(b: Vec4ui, res: Vec4ui) = and(res, this, b.x, b.y, b.z, b.w)

    fun and(bX: Uint, bY: Uint, bZ: Uint, bW: Uint, res: Vec4ui = Vec4ui()) = and(res, this, bX, bY, bZ, bW)
    fun and(bX: Int, bY: Int, bZ: Int, bW: Int, res: Vec4ui = Vec4ui()) = and(res, this, bX, bY, bZ, bW)

    fun andAssign(bX: Uint, bY: Uint, bZ: Uint, bW: Uint) = and(this, this, bX, bY, bZ, bW)
    fun andAssign(bX: Int, bY: Int, bZ: Int, bW: Int) = and(this, this, bX, bY, bZ, bW)


    infix fun or(b: Uint) = or(Vec4ui(), this, b, b, b, b)
    infix fun or(b: Int) = or(Vec4ui(), this, b, b, b, b)
    infix fun or(b: Vec4ui) = or(Vec4ui(), this, b.x, b.y, b.z, b.w)

    infix fun orAssign(b: Uint) = or(this, this, b, b, b, b)
    infix fun orAssign(b: Int) = or(this, this, b, b, b, b)
    infix fun orAssign(b: Vec4ui) = or(this, this, b.x, b.y, b.z, b.w)

    fun or(b: Uint, res: Vec4ui) = or(res, this, b, b, b, b)
    fun or(b: Int, res: Vec4ui) = or(res, this, b, b, b, b)
    fun or(b: Vec4ui, res: Vec4ui) = or(res, this, b.x, b.y, b.z, b.w)

    fun or(bX: Uint, bY: Uint, bZ: Uint, bW: Uint, res: Vec4ui = Vec4ui()) = or(res, this, bX, bY, bZ, bW)
    fun or(bX: Int, bY: Int, bZ: Int, bW: Int, res: Vec4ui = Vec4ui()) = or(res, this, bX, bY, bZ, bW)

    fun orAssign(bX: Uint, bY: Uint, bZ: Uint, bW: Uint) = or(this, this, bX, bY, bZ, bW)
    fun orAssign(bX: Int, bY: Int, bZ: Int, bW: Int) = or(this, this, bX, bY, bZ, bW)


    infix fun xor(b: Uint) = xor(Vec4ui(), this, b, b, b, b)
    infix fun xor(b: Int) = xor(Vec4ui(), this, b, b, b, b)
    infix fun xor(b: Vec4ui) = xor(Vec4ui(), this, b.x, b.y, b.z, b.w)

    infix fun xorAssign(b: Uint) = xor(this, this, b, b, b, b)
    infix fun xorAssign(b: Int) = xor(this, this, b, b, b, b)
    infix fun xorAssign(b: Vec4ui) = xor(this, this, b.x, b.y, b.z, b.w)

    fun xor(b: Uint, res: Vec4ui) = xor(res, this, b, b, b, b)
    fun xor(b: Int, res: Vec4ui) = xor(res, this, b, b, b, b)
    fun xor(b: Vec4ui, res: Vec4ui) = xor(res, this, b.x, b.y, b.z, b.w)

    fun xor(bX: Uint, bY: Uint, bZ: Uint, bW: Uint, res: Vec4ui = Vec4ui()) = xor(res, this, bX, bY, bZ, bW)
    fun xor(bX: Int, bY: Int, bZ: Int, bW: Int, res: Vec4ui = Vec4ui()) = xor(res, this, bX, bY, bZ, bW)

    fun xorAssign(bX: Uint, bY: Uint, bZ: Uint, bW: Uint) = xor(this, this, bX, bY, bZ, bW)
    fun xorAssign(bX: Int, bY: Int, bZ: Int, bW: Int) = xor(this, this, bX, bY, bZ, bW)


    infix fun shl(b: Uint) = shl(Vec4ui(), this, b, b, b, b)
    infix fun shl(b: Int) = shl(Vec4ui(), this, b, b, b, b)
    infix fun shl(b: Vec4ui) = shl(Vec4ui(), this, b.x, b.y, b.z, b.w)

    infix fun shlAssign(b: Uint) = shl(this, this, b, b, b, b)
    infix fun shlAssign(b: Int) = shl(this, this, b, b, b, b)
    infix fun shlAssign(b: Vec4ui) = shl(this, this, b.x, b.y, b.z, b.w)

    fun shl(b: Uint, res: Vec4ui) = shl(res, this, b, b, b, b)
    fun shl(b: Int, res: Vec4ui) = shl(res, this, b, b, b, b)
    fun shl(b: Vec4ui, res: Vec4ui) = shl(res, this, b.x, b.y, b.z, b.w)

    fun shl(bX: Uint, bY: Uint, bZ: Uint, bW: Uint, res: Vec4ui = Vec4ui()) = shl(res, this, bX, bY, bZ, bW)
    fun shl(bX: Int, bY: Int, bZ: Int, bW: Int, res: Vec4ui = Vec4ui()) = shl(res, this, bX, bY, bZ, bW)

    fun shlAssign(bX: Uint, bY: Uint, bZ: Uint, bW: Uint) = shl(this, this, bX, bY, bZ, bW)
    fun shlAssign(bX: Int, bY: Int, bZ: Int, bW: Int) = shl(this, this, bX, bY, bZ, bW)


    infix fun shr(b: Uint) = shr(Vec4ui(), this, b, b, b, b)
    infix fun shr(b: Int) = shr(Vec4ui(), this, b, b, b, b)
    infix fun shr(b: Vec4ui) = shr(Vec4ui(), this, b.x, b.y, b.z, b.w)

    infix fun shrAssign(b: Uint) = shr(this, this, b, b, b, b)
    infix fun shrAssign(b: Int) = shr(this, this, b, b, b, b)
    infix fun shrAssign(b: Vec4ui) = shr(this, this, b.x, b.y, b.z, b.w)

    fun shr(b: Uint, res: Vec4ui) = shr(res, this, b, b, b, b)
    fun shr(b: Int, res: Vec4ui) = shr(res, this, b, b, b, b)
    fun shr(b: Vec4ui, res: Vec4ui) = shr(res, this, b.x, b.y, b.z, b.w)

    fun shr(bX: Uint, bY: Uint, bZ: Uint, bW: Uint, res: Vec4ui = Vec4ui()) = shr(res, this, bX, bY, bZ, bW)
    fun shr(bX: Int, bY: Int, bZ: Int, bW: Int, res: Vec4ui = Vec4ui()) = shr(res, this, bX, bY, bZ, bW)

    fun shrAssign(bX: Uint, bY: Uint, bZ: Uint, bW: Uint) = shr(this, this, bX, bY, bZ, bW)
    fun shrAssign(bX: Int, bY: Int, bZ: Int, bW: Int) = shr(this, this, bX, bY, bZ, bW)


    fun inv(res: Vec4ui = Vec4ui()) = inv(res, this)
    fun invAssign() = inv(this, this)


    // -- Generic bitwise operators --

    infix fun and(b: Number) = and(Vec4ui(), this, b.i, b.i, b.i, b.i)
    infix fun and(b: Vec4t<out Number>) = and(Vec4ui(), this, b._x.i, b._y.i, b._z.i, b._w.i)

    infix fun andAssign(b: Number) = and(this, this, b.i, b.i, b.i, b.i)
    infix fun andAssign(b: Vec4t<out Number>) = and(this, this, b._x.i, b._y.i, b._z.i, b._w.i)

    fun and(b: Number, res: Vec4ui) = and(res, this, b.i, b.i, b.i, b.i)
    fun and(b: Vec4t<out Number>, res: Vec4ui) = and(res, this, b._x.i, b._y.i, b._z.i, b._w.i)

    fun and(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4ui = Vec4ui()) = and(res, this, bX.i, bY.i, bZ.i, bW.i)

    fun andAssign(bX: Number, bY: Number, bZ: Number, bW: Number) = and(this, this, bX.i, bY.i, bZ.i, bW.i)


    infix fun or(b: Number) = or(Vec4ui(), this, b.i, b.i, b.i, b.i)
    infix fun or(b: Vec4t<out Number>) = or(Vec4ui(), this, b._x.i, b._y.i, b._z.i, b._w.i)

    infix fun orAssign(b: Number) = or(this, this, b.i, b.i, b.i, b.i)
    infix fun orAssign(b: Vec4t<out Number>) = or(this, this, b._x.i, b._y.i, b._z.i, b._w.i)

    fun or(b: Number, res: Vec4ui) = or(res, this, b.i, b.i, b.i, b.i)
    fun or(b: Vec4t<out Number>, res: Vec4ui) = or(res, this, b._x.i, b._y.i, b._z.i, b._w.i)

    fun or(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4ui = Vec4ui()) = or(res, this, bX.i, bY.i, bZ.i, bW.i)

    fun orAssign(bX: Number, bY: Number, bZ: Number, bW: Number) = or(this, this, bX.i, bY.i, bZ.i, bW.i)


    infix fun xor(b: Number) = xor(Vec4ui(), this, b.i, b.i, b.i, b.i)
    infix fun xor(b: Vec4t<out Number>) = xor(Vec4ui(), this, b._x.i, b._y.i, b._z.i, b._w.i)

    infix fun xorAssign(b: Number) = xor(this, this, b.i, b.i, b.i, b.i)
    infix fun xorAssign(b: Vec4t<out Number>) = xor(this, this, b._x.i, b._y.i, b._z.i, b._w.i)

    fun xor(b: Number, res: Vec4ui) = xor(res, this, b.i, b.i, b.i, b.i)
    fun xor(b: Vec4t<out Number>, res: Vec4ui) = xor(res, this, b._x.i, b._y.i, b._z.i, b._w.i)

    fun xor(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4ui = Vec4ui()) = xor(res, this, bX.i, bY.i, bZ.i, bW.i)

    fun xorAssign(bX: Number, bY: Number, bZ: Number, bW: Number) = xor(this, this, bX.i, bY.i, bZ.i, bW.i)


    infix fun shl(b: Number) = shl(Vec4ui(), this, b.i, b.i, b.i, b.i)
    infix fun shl(b: Vec4t<out Number>) = shl(Vec4ui(), this, b._x.i, b._y.i, b._z.i, b._w.i)

    infix fun shlAssign(b: Number) = shl(this, this, b.i, b.i, b.i, b.i)
    infix fun shlAssign(b: Vec4t<out Number>) = shl(this, this, b._x.i, b._y.i, b._z.i, b._w.i)

    fun shl(b: Number, res: Vec4ui) = shl(res, this, b.i, b.i, b.i, b.i)
    fun shl(b: Vec4t<out Number>, res: Vec4ui) = shl(res, this, b._x.i, b._y.i, b._z.i, b._w.i)

    fun shl(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4ui = Vec4ui()) = shl(res, this, bX.i, bY.i, bZ.i, bW.i)

    fun shlAssign(bX: Number, bY: Number, bZ: Number, bW: Number) = shl(this, this, bX.i, bY.i, bZ.i, bW.i)


    infix fun shr(b: Number) = shr(Vec4ui(), this, b.i, b.i, b.i, b.i)
    infix fun shr(b: Vec4t<out Number>) = shr(Vec4ui(), this, b._x.i, b._y.i, b._z.i, b._w.i)

    infix fun shrAssign(b: Number) = shr(this, this, b.i, b.i, b.i, b.i)
    infix fun shrAssign(b: Vec4t<out Number>) = shr(this, this, b._x.i, b._y.i, b._z.i, b._w.i)

    fun shr(b: Number, res: Vec4ui) = shr(res, this, b.i, b.i, b.i, b.i)
    fun shr(b: Vec4t<out Number>, res: Vec4ui) = shr(res, this, b._x.i, b._y.i, b._z.i, b._w.i)

    fun shr(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4ui = Vec4ui()) = shr(res, this, bX.i, bY.i, bZ.i, bW.i)

    fun shrAssign(bX: Number, bY: Number, bZ: Number, bW: Number) = shr(this, this, bX.i, bY.i, bZ.i, bW.i)


    infix fun allLessThan(ui: Uint): Boolean = x < ui && y < ui && z < ui && w < ui
    infix fun anyLessThan(ui: Uint): Boolean = x < ui || y < ui || z < ui || w < ui
    infix fun lessThan(ui: Uint): Vec4bool = Vec4bool { get(it) < ui }

    infix fun allLessThanEqual(ui: Uint): Boolean = x <= ui && y <= ui && z <= ui && w <= ui
    infix fun anyLessThanEqual(ui: Uint): Boolean = x <= ui || y <= ui || z <= ui || w <= ui
    infix fun lessThanEqual(ui: Uint): Vec4bool = Vec4bool { get(it) <= ui }

    infix fun allEqual(ui: Uint): Boolean = x == ui && y == ui && z == ui && w == ui
    infix fun anyEqual(ui: Uint): Boolean = x == ui || y == ui || z == ui || w == ui
    infix fun equal(ui: Uint): Vec4bool = Vec4bool { get(it) == ui }

    infix fun allNotEqual(ui: Uint): Boolean = x != ui && y != ui && z != ui && w != ui
    infix fun anyNotEqual(ui: Uint): Boolean = x != ui || y != ui || z != ui || w != ui
    infix fun notEqual(ui: Uint): Vec4bool = Vec4bool { get(it) != ui }

    infix fun allGreaterThan(ui: Uint): Boolean = x > ui && y > ui && z > ui && w > ui
    infix fun anyGreaterThan(ui: Uint): Boolean = x > ui || y > ui || z > ui || w > ui
    infix fun greaterThan(ui: Uint): Vec4bool = Vec4bool { get(it) > ui }

    infix fun allGreaterThanEqual(ui: Uint): Boolean = x >= ui && y >= ui && z >= ui && w >= ui
    infix fun anyGreaterThanEqual(ui: Uint): Boolean = x >= ui || y >= ui || z >= ui || w >= ui
    infix fun greaterThanEqual(ui: Uint): Vec4bool = Vec4bool { get(it) >= ui }


    infix fun allLessThan(v: Vec4ui): Boolean = x < v.x && y < v.y && z < v.z && w < v.w
    infix fun anyLessThan(v: Vec4ui): Boolean = x < v.x || y < v.y || z < v.z || w < v.w
    infix fun lessThan(v: Vec4ui): Vec4bool = Vec4bool { get(it) < v[it] }

    infix fun allLessThanEqual(v: Vec4ui): Boolean = x <= v.x && y <= v.y && z <= v.z && w <= v.w
    infix fun anyLessThanEqual(v: Vec4ui): Boolean = x <= v.x || y <= v.y || z <= v.z || w <= v.w
    infix fun lessThanEqual(v: Vec4ui): Vec4bool = Vec4bool { get(it) <= v[it] }

    infix fun allEqual(v: Vec4ui): Boolean = x == v.x && y == v.y && z == v.z && w == v.w
    infix fun anyEqual(v: Vec4ui): Boolean = x == v.x || y == v.y || z == v.z || w == v.w
    infix fun equal(v: Vec4ui): Vec4bool = Vec4bool { get(it) == v[it] }

    infix fun allNotEqual(v: Vec4ui): Boolean = x != v.x && y != v.y && z != v.z && w != v.w
    infix fun anyNotEqual(v: Vec4ui): Boolean = x != v.x || y != v.y || z != v.z || w != v.w
    infix fun notEqual(v: Vec4ui): Vec4bool = Vec4bool { get(it) != v[it] }

    infix fun allGreaterThan(v: Vec4ui): Boolean = x > v.x && y > v.y && z > v.z && w > v.w
    infix fun anyGreaterThan(v: Vec4ui): Boolean = x > v.x || y > v.y || z > v.z || w > v.w
    infix fun greaterThan(v: Vec4ui): Vec4bool = Vec4bool { get(it) > v[it] }

    infix fun allGreaterThanEqual(v: Vec4ui): Boolean = x >= v.x && y >= v.y && z >= v.z && w >= v.w
    infix fun anyGreaterThanEqual(v: Vec4ui): Boolean = x >= v.x || y >= v.y || z >= v.z || w >= v.w
    infix fun greaterThanEqual(v: Vec4ui): Vec4bool = Vec4bool { get(it) >= v[it] }


    companion object : vec4ui_operators {
        const val length = Vec4t.LENGTH

        @JvmField
        val size = length * Uint.BYTES

        @JvmStatic
        fun fromPointer(ptr: Ptr<Uint>) = Vec4ui(ptr)
    }

    override fun size() = size


    override fun equals(other: Any?) = other is Vec4ui && this[0] == other[0] && this[1] == other[1] && this[2] == other[2] && this[3] == other[3]
    override fun hashCode() = 31 * (31 * (31 * x.v.hashCode() + y.v.hashCode()) + z.v.hashCode()) + w.v.hashCode()

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

    override inline var _w get() = w; set(value) { w = value }
    override inline var a get() = w; set(value) { w = value }
    override inline var q get() = w; set(value) { w = value }
    //@formatter:on

    override inline operator fun get(index: Int) = array[ofs + index]

    inline operator fun set(index: Int, value: Uint) {
        array[ofs + index] = value
    }

    override inline operator fun component1() = x
    override inline operator fun component2() = y
    override inline operator fun component3() = z
    override inline operator fun component4() = w

    override fun toString(): String = "($x, $y, $z, $w)"
}
