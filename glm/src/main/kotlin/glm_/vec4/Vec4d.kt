package glm_.vec4

import glm_.*
import glm_.vec2.Vec2bool
import glm_.vec2.Vec2d
import glm_.vec2.Vec2t
import glm_.vec3.Vec3bool
import glm_.vec3.Vec3d
import glm_.vec3.Vec3t
import glm_.vec4.operators.vec4d_operators
import kool.Ptr
import kool.pos
import kool.set
import org.lwjgl.system.MemoryUtil.memGetDouble
import org.lwjgl.system.MemoryUtil.memPutDouble
import java.awt.Color
import java.io.InputStream
import java.io.PrintStream
import java.nio.*

/**
 * Created by elect on 09/10/16.
 */

class Vec4d(var ofs: Int, var array: DoubleArray) : Vec4t<Double>(), ToDoubleBuffer {

    constructor(x: Double, y: Double, z: Double, w: Double) : this(0, doubleArrayOf(x, y, z, w))

    override var x: Double
        get() = array[ofs]
        set(value) = array.set(ofs, value)
    override var y: Double
        get() = array[ofs + 1]
        set(value) = array.set(ofs + 1, value)
    override var z: Double
        get() = array[ofs + 2]
        set(value) = array.set(ofs + 2, value)
    override var w: Double
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

    constructor(v: Vec2bool) : this(v.x.d, v.y.d, 0, 1)
    constructor(v: Vec3bool) : this(v.x.d, v.y.d, v.z.d, 1)
    constructor(v: Vec4bool) : this(v.x.d, v.y.d, v.z.d, v.w.d)

    constructor(bytes: ByteArray, index: Int = 0, oneByteOneDouble: Boolean = false, bigEndian: Boolean = true) : this(
            if (oneByteOneDouble) bytes[index].d else bytes.getDouble(index, bigEndian),
            if (oneByteOneDouble) bytes[index + 1].d else bytes.getDouble(index + Double.BYTES, bigEndian),
            if (oneByteOneDouble) bytes[index + 2].d else bytes.getDouble(index + Double.BYTES * 2, bigEndian),
            if (oneByteOneDouble) bytes[index + 3].d else bytes.getDouble(index + Double.BYTES * 3, bigEndian))

    constructor(chars: CharArray, index: Int = 0) : this(chars[index].d, chars[index + 1].d, chars[index + 2].d, chars[index + 3].d)
    constructor(shorts: ShortArray, index: Int = 0) : this(shorts[index], shorts[index + 1], shorts[index + 2], shorts[index + 3])
    constructor(ints: IntArray, index: Int = 0) : this(ints[index], ints[index + 1], ints[index + 2], ints[index + 3])
    constructor(longs: LongArray, index: Int = 0) : this(longs[index], longs[index + 1], longs[index + 2], longs[index + 3])
    constructor(floats: FloatArray, index: Int = 0) : this(floats[index], floats[index + 1], floats[index + 2], floats[index + 3])
    constructor(doubles: DoubleArray, index: Int = 0) : this(doubles[index], doubles[index + 1], doubles[index + 2], doubles[index + 3])
    constructor(booleans: BooleanArray, index: Int = 0) : this(booleans[index].d, booleans[index + 1].d, booleans[index + 2].d, booleans[index + 3].d)

    constructor(numbers: Array<out Number>, index: Int = 0) : this(numbers[index], numbers[index + 1], numbers[index + 2], numbers[index + 3])
    constructor(chars: Array<Char>, index: Int = 0) : this(chars[index].d, chars[index + 1].d, chars[index + 2].d, chars[index + 3].d)
    constructor(booleans: Array<Boolean>, index: Int = 0) : this(booleans[index].d, booleans[index + 1].d, booleans[index + 2].d, booleans[index + 3].d)

    constructor(list: Iterable<*>, index: Int = 0) : this(list.elementAt(index)!!.toDouble, list.elementAt(index + 1)!!.toDouble,
            list.elementAt(index + 2)!!.toDouble, list.elementAt(index + 3)!!.toDouble)

    constructor(bytes: ByteBuffer, index: Int = bytes.pos, oneByteOneDouble: Boolean = false) : this(
            if (oneByteOneDouble) bytes[index].d else bytes.getDouble(index),
            if (oneByteOneDouble) bytes[index + 1].d else bytes.getDouble(index + Double.BYTES),
            if (oneByteOneDouble) bytes[index + 2].d else bytes.getDouble(index + Double.BYTES * 2),
            if (oneByteOneDouble) bytes[index + 3].d else bytes.getDouble(index + Double.BYTES * 3))

    constructor(chars: CharBuffer, index: Int = chars.pos) : this(chars[index].d, chars[index + 1].d, chars[index + 2].d, chars[index + 3].d)
    constructor(shorts: ShortBuffer, index: Int = shorts.pos) : this(shorts[index], shorts[index + 1], shorts[index + 2], shorts[index + 3])
    constructor(ints: IntBuffer, index: Int = ints.pos) : this(ints[index], ints[index + 1], ints[index + 2], ints[index + 3])
    constructor(longs: LongBuffer, index: Int = longs.pos) : this(longs[index], longs[index + 1], longs[index + 2], longs[index + 3])
    constructor(floats: FloatBuffer, index: Int = floats.pos) : this(floats[index], floats[index + 1], floats[index + 2], floats[index + 3])
    constructor(doubles: DoubleBuffer, index: Int = doubles.pos) : this(doubles[index], doubles[index + 1], doubles[index + 2], doubles[index + 3])

    constructor(block: (Int) -> Double) : this(block(0), block(1), block(2), block(3))

    constructor(s: Number) : this(s, s, s, s)
    constructor(x: Number, y: Number, z: Number, w: Number) : this(x.d, y.d, z.d, w.d)

    constructor(inputStream: InputStream, bigEndian: Boolean = true) :
            this(inputStream.double(bigEndian), inputStream.double(bigEndian), inputStream.double(bigEndian), inputStream.double(bigEndian))

    constructor(color: Color) : this(color.red / 255.0, color.green / 255.0, color.blue / 255.0, color.alpha / 255.0)

    fun set(bytes: ByteArray, index: Int = 0, oneByteOneDouble: Boolean = false, bigEndian: Boolean = true) {
        x = if (oneByteOneDouble) bytes[index].d else bytes.getDouble(index, bigEndian)
        y = if (oneByteOneDouble) bytes[index + 1].d else bytes.getDouble(index + Double.BYTES, bigEndian)
        z = if (oneByteOneDouble) bytes[index + 2].d else bytes.getDouble(index + Double.BYTES * 2, bigEndian)
        w = if (oneByteOneDouble) bytes[index + 3].d else bytes.getDouble(index + Double.BYTES * 3, bigEndian)
    }

    fun set(bytes: ByteBuffer, index: Int = bytes.pos, oneByteOneDouble: Boolean = false) {
        x = if (oneByteOneDouble) bytes[index].d else bytes.getDouble(index)
        y = if (oneByteOneDouble) bytes[index + 1].d else bytes.getDouble(index + Double.BYTES)
        z = if (oneByteOneDouble) bytes[index + 2].d else bytes.getDouble(index + Double.BYTES * 2)
        w = if (oneByteOneDouble) bytes[index + 3].d else bytes.getDouble(index + Double.BYTES * 3)
    }


    fun put(x: Double, y: Double, z: Double, w: Double) {
        this.x = x
        this.y = y
        this.z = z
        this.w = w
    }

    operator fun invoke(x: Double, y: Double, z: Double, w: Double): Vec4d {
        this.x = x
        this.y = y
        this.z = z
        this.w = w
        return this
    }

    override fun put(x: Number, y: Number, z: Number, w: Number) {
        this.x = x.d
        this.y = y.d
        this.z = z.d
        this.w = w.d
    }

    override operator fun invoke(x: Number, y: Number, z: Number, w: Number): Vec4d {
        this.x = x.d
        this.y = y.d
        this.z = z.d
        this.w = w.d
        return this
    }

    fun to(bytes: ByteArray, index: Int): ByteArray = to(bytes, index, true)
    override fun to(bytes: ByteArray, index: Int, bigEndian: Boolean): ByteArray {
        bytes.putDouble(index, x, bigEndian)
        bytes.putDouble(index + Double.BYTES, y, bigEndian)
        bytes.putDouble(index + Double.BYTES * 2, z, bigEndian)
        bytes.putDouble(index + Double.BYTES * 3, w, bigEndian)
        return bytes
    }

    fun toDoubleArray(): DoubleArray = to(DoubleArray(length), 0)
    infix fun to(doubles: DoubleArray): DoubleArray = to(doubles, 0)
    fun to(doubles: DoubleArray, index: Int): DoubleArray {
        System.arraycopy(array, ofs, doubles, index, length)
        return doubles
    }

    override fun to(buf: ByteBuffer, offset: Int): ByteBuffer {
        buf.putDouble(offset, x)
        buf.putDouble(offset + Double.BYTES, y)
        buf.putDouble(offset + Double.BYTES * 2, z)
        buf.putDouble(offset + Double.BYTES * 3, w)
        return buf
    }

    override fun to(buf: DoubleBuffer, offset: Int): DoubleBuffer {
        buf[offset] = x
        buf[offset + 1] = y
        buf[offset + 2] = z
        buf[offset + 3] = w
        return buf
    }

    infix fun to(ptr: Ptr) {
        memPutDouble(ptr, x)
        memPutDouble(ptr + Double.BYTES, y)
        memPutDouble(ptr + Double.BYTES * 2, z)
        memPutDouble(ptr + Double.BYTES * 3, w)
    }

    // -- Component accesses --

    operator fun set(index: Int, value: Double) = when (index) {
        0 -> x = value
        1 -> y = value
        2 -> z = value
        3 -> w = value
        else -> throw ArrayIndexOutOfBoundsException()
    }

    override operator fun set(index: Int, value: Number) = when (index) {
        0 -> x = value.d
        1 -> y = value.d
        2 -> z = value.d
        3 -> w = value.d
        else -> throw ArrayIndexOutOfBoundsException()
    }


    // -- Unary arithmetic operators --

    operator fun unaryPlus() = this

    operator fun unaryMinus() = Vec4d(-x, -y, -z, -w)

    // -- Increment main.and decrement operators --

    operator fun inc(res: Vec4d = Vec4d()) = plus(res, this, 1.0, 1.0, 1.0, 1.0)
    fun incAssign() = plus(this, this, 1.0, 1.0, 1.0, 1.0)


    operator fun dec(res: Vec4d = Vec4d()) = minus(res, this, 1.0, 1.0, 1.0, 1.0)
    fun decAssign() = minus(this, this, 1.0, 1.0, 1.0, 1.0)


    // -- Specific binary arithmetic operators --

    operator fun plus(b: Double) = plus(Vec4d(), this, b, b, b, b)
    operator fun plus(b: Vec4d) = plus(Vec4d(), this, b.x, b.y, b.z, b.w)

    fun plus(bX: Double, bY: Double, bZ: Double, bW: Double, res: Vec4d = Vec4d()) = plus(res, this, bX, bY, bZ, bW)
    fun plus(b: Double, res: Vec4d = Vec4d()) = plus(res, this, b, b, b, b)
    fun plus(b: Vec4d, res: Vec4d = Vec4d()) = plus(res, this, b.x, b.y, b.z, b.w)

    fun plusAssign(bX: Double, bY: Double, bZ: Double, bW: Double) = plus(this, this, bX, bY, bZ, bW)
    infix operator fun plusAssign(b: Double) {
        plus(this, this, b, b, b, b)
    }

    infix operator fun plusAssign(b: Vec4d) {
        plus(this, this, b.x, b.y, b.z, b.w)
    }


    operator fun minus(b: Double) = minus(Vec4d(), this, b, b, b, b)
    operator fun minus(b: Vec4d) = minus(Vec4d(), this, b.x, b.y, b.z, b.w)

    fun minus(bX: Double, bY: Double, bZ: Double, bW: Double, res: Vec4d = Vec4d()) = minus(res, this, bX, bY, bZ, bW)
    fun minus(b: Double, res: Vec4d = Vec4d()) = minus(res, this, b, b, b, b)
    fun minus(b: Vec4d, res: Vec4d = Vec4d()) = minus(res, this, b.x, b.y, b.z, b.w)

    fun minusAssign(bX: Double, bY: Double, bZ: Double, bW: Double) = minus(this, this, bX, bY, bZ, bW)
    infix operator fun minusAssign(b: Double) {
        minus(this, this, b, b, b, b)
    }

    infix operator fun minusAssign(b: Vec4d) {
        minus(this, this, b.x, b.y, b.z, b.w)
    }


    operator fun times(b: Double) = times(Vec4d(), this, b, b, b, b)
    operator fun times(b: Vec4d) = times(Vec4d(), this, b.x, b.y, b.z, b.w)

    fun times(bX: Double, bY: Double, bZ: Double, bW: Double, res: Vec4d = Vec4d()) = times(res, this, bX, bY, bZ, bW)
    fun times(b: Double, res: Vec4d = Vec4d()) = times(res, this, b, b, b, b)
    fun times(b: Vec4d, res: Vec4d = Vec4d()) = times(res, this, b.x, b.y, b.z, b.w)

    fun timesAssign(bX: Double, bY: Double, bZ: Double, bW: Double) = times(this, this, bX, bY, bZ, bW)
    infix operator fun timesAssign(b: Double) {
        times(this, this, b, b, b, b)
    }

    infix operator fun timesAssign(b: Vec4d) {
        times(this, this, b.x, b.y, b.z, b.w)
    }


    operator fun div(b: Double) = div(Vec4d(), this, b, b, b, b)
    operator fun div(b: Vec4d) = div(Vec4d(), this, b.x, b.y, b.z, b.w)

    fun div(bX: Double, bY: Double, bZ: Double, bW: Double, res: Vec4d = Vec4d()) = div(res, this, bX, bY, bZ, bW)
    fun div(b: Double, res: Vec4d = Vec4d()) = div(res, this, b, b, b, b)
    fun div(b: Vec4d, res: Vec4d = Vec4d()) = div(res, this, b.x, b.y, b.z, b.w)

    fun divAssign(bX: Double, bY: Double, bZ: Double, bW: Double) = div(this, this, bX, bY, bZ, bW)
    infix operator fun divAssign(b: Double) {
        div(this, this, b, b, b, b)
    }

    infix operator fun divAssign(b: Vec4d) {
        div(this, this, b.x, b.y, b.z, b.w)
    }


    operator fun rem(b: Double) = rem(Vec4d(), this, b, b, b, b)
    operator fun rem(b: Vec4d) = rem(Vec4d(), this, b.x, b.y, b.z, b.w)

    fun rem(bX: Double, bY: Double, bZ: Double, bW: Double, res: Vec4d = Vec4d()) = rem(res, this, bX, bY, bZ, bW)
    fun rem(b: Double, res: Vec4d = Vec4d()) = rem(res, this, b, b, b, b)
    fun rem(b: Vec4d, res: Vec4d = Vec4d()) = rem(res, this, b.x, b.y, b.z, b.w)

    fun remAssign(bX: Double, bY: Double, bZ: Double, bW: Double) = rem(this, this, bX, bY, bZ, bW)
    infix operator fun remAssign(b: Double) {
        rem(this, this, b, b, b, b)
    }

    infix operator fun remAssign(b: Vec4d) {
        rem(this, this, b.x, b.y, b.z, b.w)
    }


    // -- Generic binary arithmetic operators --

    operator fun plus(b: Number) = plus(Vec4d(), this, b.d, b.d, b.d, b.d)
    operator fun plus(b: Vec4t<out Number>) = plus(Vec4d(), this, b.x.d, b.y.d, b.z.d, b.w.d)

    fun plus(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4d = Vec4d()) = plus(res, this, bX.d, bY.d, bZ.d, bW.d)
    fun plus(b: Number, res: Vec4d = Vec4d()) = plus(res, this, b.d, b.d, b.d, b.d)
    fun plus(b: Vec4t<out Number>, res: Vec4d = Vec4d()) = plus(res, this, b.x.d, b.y.d, b.z.d, b.w.d)

    fun plusAssign(bX: Number, bY: Number, bZ: Number, bW: Number) = plus(this, this, bX.d, bY.d, bZ.d, bW.d)
    infix operator fun plusAssign(b: Number) {
        plus(this, this, b.d, b.d, b.d, b.d)
    }

    infix operator fun plusAssign(b: Vec4t<out Number>) {
        plus(this, this, b.x.d, b.y.d, b.z.d, b.w.d)
    }


    operator fun minus(b: Number) = minus(Vec4d(), this, b.d, b.d, b.d, b.d)
    operator fun minus(b: Vec4t<out Number>) = minus(Vec4d(), this, b.x.d, b.y.d, b.z.d, b.w.d)

    fun minus(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4d = Vec4d()) = minus(res, this, bX.d, bY.d, bZ.d, bW.d)
    fun minus(b: Number, res: Vec4d = Vec4d()) = minus(res, this, b.d, b.d, b.d, b.d)
    fun minus(b: Vec4t<out Number>, res: Vec4d = Vec4d()) = minus(res, this, b.x.d, b.y.d, b.z.d, b.w.d)

    fun minusAssign(bX: Number, bY: Number, bZ: Number, bW: Number) = minus(this, this, bX.d, bY.d, bZ.d, bW.d)
    infix operator fun minusAssign(b: Number) {
        minus(this, this, b.d, b.d, b.d, b.d)
    }

    infix operator fun minusAssign(b: Vec4t<out Number>) {
        minus(this, this, b.x.d, b.y.d, b.z.d, b.w.d)
    }


    operator fun times(b: Number) = times(Vec4d(), this, b.d, b.d, b.d, b.d)
    operator fun times(b: Vec4t<out Number>) = times(Vec4d(), this, b.x.d, b.y.d, b.z.d, b.w.d)

    fun times(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4d = Vec4d()) = times(res, this, bX.d, bY.d, bZ.d, bW.d)
    fun times(b: Number, res: Vec4d = Vec4d()) = times(res, this, b.d, b.d, b.d, b.d)
    fun times(b: Vec4t<out Number>, res: Vec4d = Vec4d()) = times(res, this, b.x.d, b.y.d, b.z.d, b.w.d)

    fun timesAssign(bX: Number, bY: Number, bZ: Number, bW: Number) = times(this, this, bX.d, bY.d, bZ.d, bW.d)
    infix operator fun timesAssign(b: Number) {
        times(this, this, b.d, b.d, b.d, b.d)
    }

    infix operator fun timesAssign(b: Vec4t<out Number>) {
        times(this, this, b.x.d, b.y.d, b.z.d, b.w.d)
    }


    operator fun div(b: Number) = div(Vec4d(), this, b.d, b.d, b.d, b.d)
    operator fun div(b: Vec4t<out Number>) = div(Vec4d(), this, b.x.d, b.y.d, b.z.d, b.w.d)

    fun div(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4d = Vec4d()) = div(res, this, bX.d, bY.d, bZ.d, bW.d)
    fun div(b: Number, res: Vec4d = Vec4d()) = div(res, this, b.d, b.d, b.d, b.d)
    fun div(b: Vec4t<out Number>, res: Vec4d = Vec4d()) = div(res, this, b.x.d, b.y.d, b.z.d, b.w.d)

    fun divAssign(bX: Number, bY: Number, bZ: Number, bW: Number) = div(this, this, bX.d, bY.d, bZ.d, bW.d)
    infix operator fun divAssign(b: Number) {
        div(this, this, b.d, b.d, b.d, b.d)
    }

    infix operator fun divAssign(b: Vec4t<out Number>) {
        div(this, this, b.x.d, b.y.d, b.z.d, b.w.d)
    }


    operator fun rem(b: Number) = rem(Vec4d(), this, b.d, b.d, b.d, b.d)
    operator fun rem(b: Vec4t<out Number>) = rem(Vec4d(), this, b.x.d, b.y.d, b.z.d, b.w.d)

    fun rem(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4d = Vec4d()) = rem(res, this, bX.d, bY.d, bZ.d, bW.d)
    fun rem(b: Number, res: Vec4d = Vec4d()) = rem(res, this, b.d, b.d, b.d, b.d)
    fun rem(b: Vec4t<out Number>, res: Vec4d = Vec4d()) = rem(res, this, b.x.d, b.y.d, b.z.d, b.w.d)

    fun remAssign(bX: Number, bY: Number, bZ: Number, bW: Number) = rem(this, this, bX.d, bY.d, bZ.d, bW.d)
    infix operator fun remAssign(b: Number) {
        rem(this, this, b.d, b.d, b.d, b.d)
    }

    infix operator fun remAssign(b: Vec4t<out Number>) {
        rem(this, this, b.x.d, b.y.d, b.z.d, b.w.d)
    }


    infix fun dot(b: Vec4d) = glm.dot(this, b)   // TODO others

    fun length() = glm.length(this)
    fun length2() = glm.length2(this)


    override fun createInstance(x: Double, y: Double) = Vec2d(x, y)
    override fun createInstance(x: Double, y: Double, z: Double) = Vec3d(x, y, z)
    override fun createInstance(x: Double, y: Double, z: Double, w: Double) = Vec4d(x, y, z, w)


    companion object : vec4d_operators {
        const val length = Vec4t.length
        @JvmField
        val size = length * Double.BYTES

        @JvmStatic
        fun fromPointer(ptr: Ptr) = Vec4d(memGetDouble(ptr), memGetDouble(ptr + Double.BYTES), memGetDouble(ptr + Double.BYTES * 2), memGetDouble(ptr + Double.BYTES * 3))
    }

    override fun size() = size

    override fun elementCount() = length

    override fun equals(other: Any?) = other is Vec4d && this[0] == other[0] && this[1] == other[1] && this[2] == other[2] && this[3] == other[3]
    override fun hashCode() = 31 * (31 * (31 * x.hashCode() + y.hashCode()) + z.hashCode()) + w.hashCode()

    @JvmOverloads
    fun print(name: String = "", stream: PrintStream = System.out) = stream.print("$name$this")

    @JvmOverloads
    fun println(name: String = "", stream: PrintStream = System.out) = stream.println("$name$this")

    override fun toString(): String = "[$x, $y, $z, $w]"
}