package glm_.vec3

import glm_.*
import glm_.vec2.Vec2bool
import glm_.vec2.Vec2t
import glm_.vec3.operators.vec3ub_operators
import glm_.vec4.Vec4bool
import glm_.vec4.Vec4t
import unsigned.Ubyte
import java.nio.*

/**
 * Created by elect on 09/10/16.
 */

class Vec3ub(x: Ubyte, y: Ubyte, z: Ubyte) : Vec3t<Ubyte>(x, y, z) {

    // -- Explicit basic, conversion main.getB main.and conversion vector constructors --

    constructor() : this(0)

    constructor(v: Vec2t<out Number>) : this(v.x, v.y, 0)
    constructor(v: Vec2t<out Number>, z: Number) : this(v.x, v.y, z)
    constructor(x: Number, v: Vec2t<out Number>) : this(x, v.x, v.y)
    constructor(v: Vec3t<out Number>) : this(v.x, v.y, v.z)
    constructor(v: Vec4t<out Number>) : this(v.x, v.y, v.z)

    constructor(v: Vec2bool) : this(v.x.ub, v.y.ub, 0)
    constructor(v: Vec3bool) : this(v.x.ub, v.y.ub, v.z.ub)
    constructor(v: Vec4bool) : this(v.x.ub, v.y.ub, v.z.ub)

    constructor(bytes: ByteArray, index: Int = 0) : this(bytes[index], bytes[index + 1], bytes[index + 2])
    constructor(chars: CharArray, index: Int = 0) : this(chars[index].ub, chars[index + 1].ub, chars[index + 2].ub)
    constructor(shorts: ShortArray, index: Int = 0) : this(shorts[index], shorts[index + 1], shorts[index + 2])
    constructor(ints: IntArray, index: Int = 0) : this(ints[index], ints[index + 1], ints[index + 2])
    constructor(longs: LongArray, index: Int = 0) : this(longs[index], longs[index + 1], longs[index + 2])
    constructor(floats: FloatArray, index: Int = 0) : this(floats[index], floats[index + 1], floats[index + 2])
    constructor(doubles: DoubleArray, index: Int = 0) : this(doubles[index], doubles[index + 1], doubles[index + 2])
    constructor(booleans: BooleanArray, index: Int = 0) : this(booleans[index].ub, booleans[index + 1].ub, booleans[index + 2].ub)

    constructor(numbers: Array<out Number>, index: Int = 0) : this(numbers[index], numbers[index + 1], numbers[index + 2])
    constructor(chars: Array<Char>, index: Int = 0) : this(chars[index].ub, chars[index + 1].ub, chars[index + 2].ub)
    constructor(booleans: Array<Boolean>, index: Int = 0) : this(booleans[index].ub, booleans[index + 1].ub, booleans[index + 2].ub)

    constructor(list: Iterable<*>, index: Int = 0) : this(list.elementAt(index)!!.toByte, list.elementAt(index + 1)!!.toByte,
            list.elementAt(index + 2)!!.toByte)

    constructor(bytes: ByteBuffer, index: Int = bytes.position()) : this(bytes[index], bytes[index + 1], bytes[index + 2])
    constructor(chars: CharBuffer, index: Int = chars.position()) : this(chars[index].ub, chars[index + 1].ub, chars[index + 2].ub)
    constructor(shorts: ShortBuffer, index: Int = shorts.position()) : this(shorts[index], shorts[index + 1], shorts[index + 2])
    constructor(ints: IntBuffer, index: Int = ints.position()) : this(ints[index], ints[index + 1], ints[index + 2])
    constructor(longs: LongBuffer, index: Int = longs.position()) : this(longs[index], longs[index + 1], longs[index + 2])
    constructor(floats: FloatBuffer, index: Int = floats.position()) : this(floats[index], floats[index + 1], floats[index + 2])
    constructor(doubles: DoubleBuffer, index: Int = doubles.position()) : this(doubles[index], doubles[index + 1], doubles[index + 2])

    constructor(block: (Int) -> Ubyte) : this(block(0), block(1), block(2))

    constructor(s: Number) : this(s, s, s)
    constructor(x: Number, y: Number, z: Number) : this(x.ub, y.ub, z.ub)


    fun put(x: Ubyte, y: Ubyte, z: Ubyte) {
        this.x = x
        this.y = y
        this.z = z
    }

    fun invoke(x: Ubyte, y: Ubyte, z: Ubyte): Vec3ub {
        this.x = x
        this.y = y
        this.z = z
        return this
    }

    fun put(x: Byte, y: Byte, z: Byte) {
        this.x.v = x
        this.y.v = y
        this.z.v = z
    }

    fun invoke(x: Byte, y: Byte, z: Byte): Vec3ub {
        this.x.v = x
        this.y.v = y
        this.z.v = z
        return this
    }

    override fun put(x: Number, y: Number, z: Number) {
        this.x = x.ub
        this.y = y.ub
        this.z = z.ub
    }

    override fun invoke(x: Number, y: Number, z: Number): Vec3ub {
        this.x = x.ub
        this.y = y.ub
        this.z = z.ub
        return this
    }

    fun to(bytes: ByteArray, index: Int) = to(bytes, index, true)
    override fun to(bytes: ByteArray, index: Int, bigEndian: Boolean): ByteArray {
        bytes[index] = x.v
        bytes[index + Byte.BYTES] = y.v
        bytes[index + Byte.BYTES * 2] = z.v
        return bytes
    }

    override fun to(bytes: ByteBuffer, index: Int): ByteBuffer {
        bytes[index] = x.v
        bytes[index + Byte.BYTES] = y.v
        bytes[index + Byte.BYTES * 2] = z.v
        return bytes
    }

    // -- Component accesses --

    operator fun set(index: Int, value: Ubyte) = when (index) {
        0 -> x = value
        1 -> y = value
        2 -> z = value
        else -> throw ArrayIndexOutOfBoundsException()
    }

    override operator fun set(index: Int, value: Number) = when (index) {
        0 -> x = value.ub
        1 -> y = value.ub
        2 -> z = value.ub
        else -> throw ArrayIndexOutOfBoundsException()
    }


    // -- Unary arithmetic operators --

    operator fun unaryPlus() = this

    // no unaryMinus operator, only signed

    // -- Increment main.and decrement operators --

    operator fun inc(res: Vec3ub = Vec3ub()) = plus(res, this, 1, 1, 1)
    fun incAssign() = plus(this, this, 1, 1, 1)


    operator fun dec(res: Vec3ub = Vec3ub()) = minus(res, this, 1, 1, 1)
    fun decAssign() = minus(this, this, 1, 1, 1)


    // -- Specific binary arithmetic operators --

    operator fun plus(b: Ubyte) = plus(Vec3ub(), this, b, b, b)
    operator fun plus(b: Byte) = plus(Vec3ub(), this, b, b, b)
    operator fun plus(b: Int) = plus(Vec3ub(), this, b, b, b)
    operator fun plus(b: Vec3ub) = plus(Vec3ub(), this, b.x, b.y, b.z)

    fun plus(bX: Ubyte, bY: Ubyte, bZ: Ubyte, res: Vec3ub = Vec3ub()) = plus(res, this, bX, bY, bZ)
    fun plus(bX: Byte, bY: Byte, bZ: Byte, res: Vec3ub = Vec3ub()) = plus(res, this, bX, bY, bZ)
    fun plus(bX: Int, bY: Int, bZ: Int, res: Vec3ub = Vec3ub()) = plus(res, this, bX, bY, bZ)
    fun plus(b: Ubyte, res: Vec3ub = Vec3ub()) = plus(res, this, b, b, b)
    fun plus(b: Byte, res: Vec3ub = Vec3ub()) = plus(res, this, b, b, b)
    fun plus(b: Int, res: Vec3ub = Vec3ub()) = plus(res, this, b, b, b)
    fun plus(b: Vec3ub, res: Vec3ub = Vec3ub()) = plus(res, this, b.x, b.y, b.z)

    fun plusAssign(bX: Ubyte, bY: Ubyte, bZ: Ubyte) = plus(this, this, bX, bY, bZ)
    fun plusAssign(bX: Byte, bY: Byte, bZ: Byte) = plus(this, this, bX, bY, bZ)
    fun plusAssign(bX: Int, bY: Int, bZ: Int) = plus(this, this, bX, bY, bZ)
    infix operator fun plusAssign(b: Ubyte) {
        plus(this, this, b, b, b)
    }

    infix operator fun plusAssign(b: Byte) {
        plus(this, this, b, b, b)
    }

    infix operator fun plusAssign(b: Int) {
        plus(this, this, b, b, b)
    }

    infix operator fun plusAssign(b: Vec3ub) {
        plus(this, this, b.x, b.y, b.z)
    }


    operator fun minus(b: Ubyte) = minus(Vec3ub(), this, b, b, b)
    operator fun minus(b: Byte) = minus(Vec3ub(), this, b, b, b)
    operator fun minus(b: Int) = minus(Vec3ub(), this, b, b, b)
    operator fun minus(b: Vec3ub) = minus(Vec3ub(), this, b.x, b.y, b.z)

    fun minus(bX: Ubyte, bY: Ubyte, bZ: Ubyte, res: Vec3ub = Vec3ub()) = minus(res, this, bX, bY, bZ)
    fun minus(bX: Byte, bY: Byte, bZ: Byte, res: Vec3ub = Vec3ub()) = minus(res, this, bX, bY, bZ)
    fun minus(bX: Int, bY: Int, bZ: Int, res: Vec3ub = Vec3ub()) = minus(res, this, bX, bY, bZ)
    fun minus(b: Ubyte, res: Vec3ub = Vec3ub()) = minus(res, this, b, b, b)
    fun minus(b: Byte, res: Vec3ub = Vec3ub()) = minus(res, this, b, b, b)
    fun minus(b: Int, res: Vec3ub = Vec3ub()) = minus(res, this, b, b, b)
    fun minus(b: Vec3ub, res: Vec3ub = Vec3ub()) = minus(res, this, b.x, b.y, b.z)

    fun minusAssign(bX: Ubyte, bY: Ubyte, bZ: Ubyte) = minus(this, this, bX, bY, bZ)
    fun minusAssign(bX: Byte, bY: Byte, bZ: Byte) = minus(this, this, bX, bY, bZ)
    fun minusAssign(bX: Int, bY: Int, bZ: Int) = minus(this, this, bX, bY, bZ)
    infix operator fun minusAssign(b: Ubyte) {
        minus(this, this, b, b, b)
    }

    infix operator fun minusAssign(b: Byte) {
        minus(this, this, b, b, b)
    }

    infix operator fun minusAssign(b: Int) {
        minus(this, this, b, b, b)
    }

    infix operator fun minusAssign(b: Vec3ub) {
        minus(this, this, b.x, b.y, b.z)
    }


    operator fun times(b: Ubyte) = times(Vec3ub(), this, b, b, b)
    operator fun times(b: Byte) = times(Vec3ub(), this, b, b, b)
    operator fun times(b: Int) = times(Vec3ub(), this, b, b, b)
    operator fun times(b: Vec3ub) = times(Vec3ub(), this, b.x, b.y, b.z)

    fun times(bX: Ubyte, bY: Ubyte, bZ: Ubyte, res: Vec3ub = Vec3ub()) = times(res, this, bX, bY, bZ)
    fun times(bX: Byte, bY: Byte, bZ: Byte, res: Vec3ub = Vec3ub()) = times(res, this, bX, bY, bZ)
    fun times(bX: Int, bY: Int, bZ: Int, res: Vec3ub = Vec3ub()) = times(res, this, bX, bY, bZ)
    fun times(b: Ubyte, res: Vec3ub = Vec3ub()) = times(res, this, b, b, b)
    fun times(b: Byte, res: Vec3ub = Vec3ub()) = times(res, this, b, b, b)
    fun times(b: Int, res: Vec3ub = Vec3ub()) = times(res, this, b, b, b)
    fun times(b: Vec3ub, res: Vec3ub = Vec3ub()) = times(res, this, b.x, b.y, b.z)

    fun timesAssign(bX: Ubyte, bY: Ubyte, bZ: Ubyte) = times(this, this, bX, bY, bZ)
    fun timesAssign(bX: Byte, bY: Byte, bZ: Byte) = times(this, this, bX, bY, bZ)
    fun timesAssign(bX: Int, bY: Int, bZ: Int) = times(this, this, bX, bY, bZ)
    infix operator fun timesAssign(b: Ubyte) {
        times(this, this, b, b, b)
    }

    infix operator fun timesAssign(b: Byte) {
        times(this, this, b, b, b)
    }

    infix operator fun timesAssign(b: Int) {
        times(this, this, b, b, b)
    }

    infix operator fun timesAssign(b: Vec3ub) {
        times(this, this, b.x, b.y, b.z)
    }


    operator fun div(b: Ubyte) = div(Vec3ub(), this, b, b, b)
    operator fun div(b: Byte) = div(Vec3ub(), this, b, b, b)
    operator fun div(b: Int) = div(Vec3ub(), this, b, b, b)
    operator fun div(b: Vec3ub) = div(Vec3ub(), this, b.x, b.y, b.z)

    fun div(bX: Ubyte, bY: Ubyte, bZ: Ubyte, res: Vec3ub = Vec3ub()) = div(res, this, bX, bY, bZ)
    fun div(bX: Byte, bY: Byte, bZ: Byte, res: Vec3ub = Vec3ub()) = div(res, this, bX, bY, bZ)
    fun div(bX: Int, bY: Int, bZ: Int, res: Vec3ub = Vec3ub()) = div(res, this, bX, bY, bZ)
    fun div(b: Ubyte, res: Vec3ub) = div(res, this, b, b, b)
    fun div(b: Byte, res: Vec3ub) = div(res, this, b, b, b)
    fun div(b: Int, res: Vec3ub) = div(res, this, b, b, b)
    fun div(b: Vec3ub, res: Vec3ub) = div(res, this, b.x, b.y, b.z)

    fun divAssign(bX: Ubyte, bY: Ubyte, bZ: Ubyte) = div(this, this, bX, bY, bZ)
    fun divAssign(bX: Byte, bY: Byte, bZ: Byte) = div(this, this, bX, bY, bZ)
    fun divAssign(bX: Int, bY: Int, bZ: Int) = div(this, this, bX, bY, bZ)
    infix operator fun divAssign(b: Ubyte) {
        div(this, this, b, b, b)
    }

    infix operator fun divAssign(b: Byte) {
        div(this, this, b, b, b)
    }

    infix operator fun divAssign(b: Int) {
        div(this, this, b, b, b)
    }

    infix operator fun divAssign(b: Vec3ub) {
        div(this, this, b.x, b.y, b.z)
    }


    operator fun rem(b: Ubyte) = rem(Vec3ub(), this, b, b, b)
    operator fun rem(b: Byte) = rem(Vec3ub(), this, b, b, b)
    operator fun rem(b: Int) = rem(Vec3ub(), this, b, b, b)
    operator fun rem(b: Vec3ub) = rem(Vec3ub(), this, b.x, b.y, b.z)

    fun rem(bX: Ubyte, bY: Ubyte, bZ: Ubyte, res: Vec3ub = Vec3ub()) = rem(res, this, bX, bY, bZ)
    fun rem(bX: Byte, bY: Byte, bZ: Byte, res: Vec3ub = Vec3ub()) = rem(res, this, bX, bY, bZ)
    fun rem(bX: Int, bY: Int, bZ: Int, res: Vec3ub = Vec3ub()) = rem(res, this, bX, bY, bZ)
    fun rem(b: Ubyte, res: Vec3ub) = rem(res, this, b, b, b)
    fun rem(b: Byte, res: Vec3ub) = rem(res, this, b, b, b)
    fun rem(b: Int, res: Vec3ub) = rem(res, this, b, b, b)
    fun rem(b: Vec3ub, res: Vec3ub) = rem(res, this, b.x, b.y, b.z)

    fun remAssign(bX: Ubyte, bY: Ubyte, bZ: Ubyte) = rem(this, this, bX, bY, bZ)
    fun remAssign(bX: Byte, bY: Byte, bZ: Byte) = rem(this, this, bX, bY, bZ)
    fun remAssign(bX: Int, bY: Int, bZ: Int) = rem(this, this, bX, bY, bZ)
    infix operator fun remAssign(b: Ubyte) {
        rem(this, this, b, b, b)
    }

    infix operator fun remAssign(b: Byte) {
        rem(this, this, b, b, b)
    }

    infix operator fun remAssign(b: Int) {
        rem(this, this, b, b, b)
    }

    infix operator fun remAssign(b: Vec3ub) {
        rem(this, this, b.x, b.y, b.z)
    }


    // -- Generic binary arithmetic operators --

    operator fun plus(b: Number) = plus(Vec3ub(), this, b.i, b.i, b.i)
    operator fun plus(b: Vec3t<out Number>) = plus(Vec3ub(), this, b.x.i, b.y.i, b.z.i)

    fun plus(bX: Number, bY: Number, bZ: Number, res: Vec3ub = Vec3ub()) = plus(res, this, bX.i, bY.i, bZ.i)
    fun plus(b: Number, res: Vec3ub = Vec3ub()) = plus(res, this, b.i, b.i, b.i)
    fun plus(b: Vec3t<out Number>, res: Vec3ub = Vec3ub()) = plus(res, this, b.x.i, b.y.i, b.z.i)

    fun plusAssign(bX: Number, bY: Number, bZ: Number) = plus(this, this, bX.i, bY.i, bZ.i)
    infix operator fun plusAssign(b: Number) {
        plus(this, this, b.i, b.i, b.i)
    }

    infix operator fun plusAssign(b: Vec3t<out Number>) {
        plus(this, this, b.x.i, b.y.i, b.z.i)
    }


    operator fun minus(b: Number) = minus(Vec3ub(), this, b.i, b.i, b.i)
    operator fun minus(b: Vec3t<out Number>) = minus(Vec3ub(), this, b.x.i, b.y.i, b.z.i)

    fun minus(bX: Number, bY: Number, bZ: Number, res: Vec3ub = Vec3ub()) = minus(res, this, bX.i, bY.i, bZ.i)
    fun minus(b: Number, res: Vec3ub = Vec3ub()) = minus(res, this, b.i, b.i, b.i)
    fun minus(b: Vec3t<out Number>, res: Vec3ub = Vec3ub()) = minus(res, this, b.x.i, b.y.i, b.z.i)

    fun minusAssign(bX: Number, bY: Number, bZ: Number) = minus(this, this, bX.i, bY.i, bZ.i)
    infix operator fun minusAssign(b: Number) {
        minus(this, this, b.i, b.i, b.i)
    }

    infix operator fun minusAssign(b: Vec3t<out Number>) {
        minus(this, this, b.x.i, b.y.i, b.z.i)
    }


    operator fun times(b: Number) = times(Vec3ub(), this, b.i, b.i, b.i)
    operator fun times(b: Vec3t<out Number>) = times(Vec3ub(), this, b.x.i, b.y.i, b.z.i)

    fun times(bX: Number, bY: Number, bZ: Number, res: Vec3ub = Vec3ub()) = times(res, this, bX.i, bY.i, bZ.i)
    fun times(b: Number, res: Vec3ub = Vec3ub()) = times(res, this, b.i, b.i, b.i)
    fun times(b: Vec3t<out Number>, res: Vec3ub = Vec3ub()) = times(res, this, b.x.i, b.y.i, b.z.i)

    fun timesAssign(bX: Number, bY: Number, bZ: Number) = times(this, this, bX.i, bY.i, bZ.i)
    infix operator fun timesAssign(b: Number) {
        times(this, this, b.i, b.i, b.i)
    }

    infix operator fun timesAssign(b: Vec3t<out Number>) {
        times(this, this, b.x.i, b.y.i, b.z.i)
    }


    operator fun div(b: Number) = div(Vec3ub(), this, b.i, b.i, b.i)
    operator fun div(b: Vec3t<out Number>) = div(Vec3ub(), this, b.x.i, b.y.i, b.z.i)

    fun div(bX: Number, bY: Number, bZ: Number, res: Vec3ub = Vec3ub()) = div(res, this, bX.i, bY.i, bZ.i)
    fun div(b: Number, res: Vec3ub) = div(res, this, b.i, b.i, b.i)
    fun div(b: Vec3t<out Number>, res: Vec3ub) = div(res, this, b.x.i, b.y.i, b.z.i)

    fun divAssign(bX: Number, bY: Number, bZ: Number) = div(this, this, bX.i, bY.i, bZ.i)
    infix operator fun divAssign(b: Number) {
        div(this, this, b.i, b.i, b.i)
    }

    infix operator fun divAssign(b: Vec3t<out Number>) {
        div(this, this, b.x.i, b.y.i, b.z.i)
    }


    operator fun rem(b: Number) = rem(Vec3ub(), this, b.i, b.i, b.i)
    operator fun rem(b: Vec3t<out Number>) = rem(Vec3ub(), this, b.x.i, b.y.i, b.z.i)

    fun rem(bX: Number, bY: Number, bZ: Number, res: Vec3ub = Vec3ub()) = rem(res, this, bX.i, bY.i, bZ.i)
    fun rem(b: Number, res: Vec3ub) = rem(res, this, b.i, b.i, b.i)
    fun rem(b: Vec3t<out Number>, res: Vec3ub) = rem(res, this, b.x.i, b.y.i, b.z.i)

    fun remAssign(bX: Number, bY: Number, bZ: Number) = rem(this, this, bX.i, bY.i, bZ.i)
    infix operator fun remAssign(b: Number) {
        rem(this, this, b.i, b.i, b.i)
    }

    infix operator fun remAssign(b: Vec3t<out Number>) {
        rem(this, this, b.x.i, b.y.i, b.z.i)
    }


    // -- Specific bitwise operators --

    infix fun and(b: Ubyte) = and(Vec3ub(), this, b, b, b)
    infix fun and(b: Byte) = and(Vec3ub(), this, b, b, b)
    infix fun and(b: Int) = and(Vec3ub(), this, b, b, b)
    infix fun and(b: Vec3ub) = and(Vec3ub(), this, b.x, b.y, b.z)

    infix fun andAssign(b: Ubyte) = and(this, this, b, b, b)
    infix fun andAssign(b: Byte) = and(this, this, b, b, b)
    infix fun andAssign(b: Int) = and(this, this, b, b, b)
    infix fun andAssign(b: Vec3ub) = and(this, this, b.x, b.y, b.z)

    fun and(b: Ubyte, res: Vec3ub) = and(res, this, b, b, b)
    fun and(b: Byte, res: Vec3ub) = and(res, this, b, b, b)
    fun and(b: Int, res: Vec3ub) = and(res, this, b, b, b)
    fun and(b: Vec3ub, res: Vec3ub) = and(res, this, b.x, b.y, b.z)

    fun and(bX: Ubyte, bY: Ubyte, bZ: Ubyte, res: Vec3ub = Vec3ub()) = and(res, this, bX, bY, bZ)
    fun and(bX: Byte, bY: Byte, bZ: Byte, res: Vec3ub = Vec3ub()) = and(res, this, bX, bY, bZ)
    fun and(bX: Int, bY: Int, bZ: Int, res: Vec3ub = Vec3ub()) = and(res, this, bX, bY, bZ)

    fun andAssign(bX: Ubyte, bY: Ubyte, bZ: Ubyte) = and(this, this, bX, bY, bZ)
    fun andAssign(bX: Byte, bY: Byte, bZ: Byte) = and(this, this, bX, bY, bZ)
    fun andAssign(bX: Int, bY: Int, bZ: Int) = and(this, this, bX, bY, bZ)


    infix fun or(b: Ubyte) = or(Vec3ub(), this, b, b, b)
    infix fun or(b: Byte) = or(Vec3ub(), this, b, b, b)
    infix fun or(b: Int) = or(Vec3ub(), this, b, b, b)
    infix fun or(b: Vec3ub) = or(Vec3ub(), this, b.x, b.y, b.z)

    infix fun orAssign(b: Ubyte) = or(this, this, b, b, b)
    infix fun orAssign(b: Byte) = or(this, this, b, b, b)
    infix fun orAssign(b: Int) = or(this, this, b, b, b)
    infix fun orAssign(b: Vec3ub) = or(this, this, b.x, b.y, b.z)

    fun or(b: Ubyte, res: Vec3ub) = or(res, this, b, b, b)
    fun or(b: Byte, res: Vec3ub) = or(res, this, b, b, b)
    fun or(b: Int, res: Vec3ub) = or(res, this, b, b, b)
    fun or(b: Vec3ub, res: Vec3ub) = or(res, this, b.x, b.y, b.z)

    fun or(bX: Ubyte, bY: Ubyte, bZ: Ubyte, res: Vec3ub = Vec3ub()) = or(res, this, bX, bY, bZ)
    fun or(bX: Byte, bY: Byte, bZ: Byte, res: Vec3ub = Vec3ub()) = or(res, this, bX, bY, bZ)
    fun or(bX: Int, bY: Int, bZ: Int, res: Vec3ub = Vec3ub()) = or(res, this, bX, bY, bZ)

    fun orAssign(bX: Ubyte, bY: Ubyte, bZ: Ubyte) = or(this, this, bX, bY, bZ)
    fun orAssign(bX: Byte, bY: Byte, bZ: Byte) = or(this, this, bX, bY, bZ)
    fun orAssign(bX: Int, bY: Int, bZ: Int) = or(this, this, bX, bY, bZ)


    infix fun xor(b: Ubyte) = xor(Vec3ub(), this, b, b, b)
    infix fun xor(b: Byte) = xor(Vec3ub(), this, b, b, b)
    infix fun xor(b: Int) = xor(Vec3ub(), this, b, b, b)
    infix fun xor(b: Vec3ub) = xor(Vec3ub(), this, b.x, b.y, b.z)

    infix fun xorAssign(b: Ubyte) = xor(this, this, b, b, b)
    infix fun xorAssign(b: Byte) = xor(this, this, b, b, b)
    infix fun xorAssign(b: Int) = xor(this, this, b, b, b)
    infix fun xorAssign(b: Vec3ub) = xor(this, this, b.x, b.y, b.z)

    fun xor(b: Ubyte, res: Vec3ub) = xor(res, this, b, b, b)
    fun xor(b: Byte, res: Vec3ub) = xor(res, this, b, b, b)
    fun xor(b: Int, res: Vec3ub) = xor(res, this, b, b, b)
    fun xor(b: Vec3ub, res: Vec3ub) = xor(res, this, b.x, b.y, b.z)

    fun xor(bX: Ubyte, bY: Ubyte, bZ: Ubyte, res: Vec3ub = Vec3ub()) = xor(res, this, bX, bY, bZ)
    fun xor(bX: Byte, bY: Byte, bZ: Byte, res: Vec3ub = Vec3ub()) = xor(res, this, bX, bY, bZ)
    fun xor(bX: Int, bY: Int, bZ: Int, res: Vec3ub = Vec3ub()) = xor(res, this, bX, bY, bZ)

    fun xorAssign(bX: Ubyte, bY: Ubyte, bZ: Ubyte) = xor(this, this, bX, bY, bZ)
    fun xorAssign(bX: Byte, bY: Byte, bZ: Byte) = xor(this, this, bX, bY, bZ)
    fun xorAssign(bX: Int, bY: Int, bZ: Int) = xor(this, this, bX, bY, bZ)


    infix fun shl(b: Ubyte) = shl(Vec3ub(), this, b, b, b)
    infix fun shl(b: Byte) = shl(Vec3ub(), this, b, b, b)
    infix fun shl(b: Int) = shl(Vec3ub(), this, b, b, b)
    infix fun shl(b: Vec3ub) = shl(Vec3ub(), this, b.x, b.y, b.z)

    infix fun shlAssign(b: Ubyte) = shl(this, this, b, b, b)
    infix fun shlAssign(b: Byte) = shl(this, this, b, b, b)
    infix fun shlAssign(b: Int) = shl(this, this, b, b, b)
    infix fun shlAssign(b: Vec3ub) = shl(this, this, b.x, b.y, b.z)

    fun shl(b: Ubyte, res: Vec3ub) = shl(res, this, b, b, b)
    fun shl(b: Byte, res: Vec3ub) = shl(res, this, b, b, b)
    fun shl(b: Int, res: Vec3ub) = shl(res, this, b, b, b)
    fun shl(b: Vec3ub, res: Vec3ub) = shl(res, this, b.x, b.y, b.z)

    fun shl(bX: Ubyte, bY: Ubyte, bZ: Ubyte, res: Vec3ub = Vec3ub()) = shl(res, this, bX, bY, bZ)
    fun shl(bX: Byte, bY: Byte, bZ: Byte, res: Vec3ub = Vec3ub()) = shl(res, this, bX, bY, bZ)
    fun shl(bX: Int, bY: Int, bZ: Int, res: Vec3ub = Vec3ub()) = shl(res, this, bX, bY, bZ)

    fun shlAssign(bX: Ubyte, bY: Ubyte, bZ: Ubyte) = shl(this, this, bX, bY, bZ)
    fun shlAssign(bX: Byte, bY: Byte, bZ: Byte) = shl(this, this, bX, bY, bZ)
    fun shlAssign(bX: Int, bY: Int, bZ: Int) = shl(this, this, bX, bY, bZ)


    infix fun shr(b: Ubyte) = shr(Vec3ub(), this, b, b, b)
    infix fun shr(b: Byte) = shr(Vec3ub(), this, b, b, b)
    infix fun shr(b: Int) = shr(Vec3ub(), this, b, b, b)
    infix fun shr(b: Vec3ub) = shr(Vec3ub(), this, b.x, b.y, b.z)

    infix fun shrAssign(b: Ubyte) = shr(this, this, b, b, b)
    infix fun shrAssign(b: Byte) = shr(this, this, b, b, b)
    infix fun shrAssign(b: Int) = shr(this, this, b, b, b)
    infix fun shrAssign(b: Vec3ub) = shr(this, this, b.x, b.y, b.z)

    fun shr(b: Ubyte, res: Vec3ub) = shr(res, this, b, b, b)
    fun shr(b: Byte, res: Vec3ub) = shr(res, this, b, b, b)
    fun shr(b: Int, res: Vec3ub) = shr(res, this, b, b, b)
    fun shr(b: Vec3ub, res: Vec3ub) = shr(res, this, b.x, b.y, b.z)

    fun shr(bX: Ubyte, bY: Ubyte, bZ: Ubyte, res: Vec3ub = Vec3ub()) = shr(res, this, bX, bY, bZ)
    fun shr(bX: Byte, bY: Byte, bZ: Byte, res: Vec3ub = Vec3ub()) = shr(res, this, bX, bY, bZ)
    fun shr(bX: Int, bY: Int, bZ: Int, res: Vec3ub = Vec3ub()) = shr(res, this, bX, bY, bZ)

    fun shrAssign(bX: Ubyte, bY: Ubyte, bZ: Ubyte) = shr(this, this, bX, bY, bZ)
    fun shrAssign(bX: Byte, bY: Byte, bZ: Byte) = shr(this, this, bX, bY, bZ)
    fun shrAssign(bX: Int, bY: Int, bZ: Int) = shr(this, this, bX, bY, bZ)


    fun inv(res: Vec3ub = Vec3ub()) = inv(res, this)
    fun invAssign() = inv(this, this)


    // -- Generic bitwise operators --

    infix fun and(b: Number) = and(Vec3ub(), this, b.i, b.i, b.i)
    infix fun and(b: Vec3t<out Number>) = and(Vec3ub(), this, b.x.i, b.y.i, b.z.i)

    infix fun andAssign(b: Number) = and(this, this, b.i, b.i, b.i)
    infix fun andAssign(b: Vec3t<out Number>) = and(this, this, b.x.i, b.y.i, b.z.i)

    fun and(b: Number, res: Vec3ub) = and(res, this, b.i, b.i, b.i)
    fun and(b: Vec3t<out Number>, res: Vec3ub) = and(res, this, b.x.i, b.y.i, b.z.i)

    fun and(bX: Number, bY: Number, bZ: Number, res: Vec3ub = Vec3ub()) = and(res, this, bX.i, bY.i, bZ.i)

    fun andAssign(bX: Number, bY: Number, bZ: Number) = and(this, this, bX.i, bY.i, bZ.i)


    infix fun or(b: Number) = or(Vec3ub(), this, b.i, b.i, b.i)
    infix fun or(b: Vec3t<out Number>) = or(Vec3ub(), this, b.x.i, b.y.i, b.z.i)

    infix fun orAssign(b: Number) = or(this, this, b.i, b.i, b.i)
    infix fun orAssign(b: Vec3t<out Number>) = or(this, this, b.x.i, b.y.i, b.z.i)

    fun or(b: Number, res: Vec3ub) = or(res, this, b.i, b.i, b.i)
    fun or(b: Vec3t<out Number>, res: Vec3ub) = or(res, this, b.x.i, b.y.i, b.z.i)

    fun or(bX: Number, bY: Number, bZ: Number, res: Vec3ub = Vec3ub()) = or(res, this, bX.i, bY.i, bZ.i)

    fun orAssign(bX: Number, bY: Number, bZ: Number) = or(this, this, bX.i, bY.i, bZ.i)


    infix fun xor(b: Number) = xor(Vec3ub(), this, b.i, b.i, b.i)
    infix fun xor(b: Vec3t<out Number>) = xor(Vec3ub(), this, b.x.i, b.y.i, b.z.i)

    infix fun xorAssign(b: Number) = xor(this, this, b.i, b.i, b.i)
    infix fun xorAssign(b: Vec3t<out Number>) = xor(this, this, b.x.i, b.y.i, b.z.i)

    fun xor(b: Number, res: Vec3ub) = xor(res, this, b.i, b.i, b.i)
    fun xor(b: Vec3t<out Number>, res: Vec3ub) = xor(res, this, b.x.i, b.y.i, b.z.i)

    fun xor(bX: Number, bY: Number, bZ: Number, res: Vec3ub = Vec3ub()) = xor(res, this, bX.i, bY.i, bZ.i)

    fun xorAssign(bX: Number, bY: Number, bZ: Number) = xor(this, this, bX.i, bY.i, bZ.i)


    infix fun shl(b: Number) = shl(Vec3ub(), this, b.i, b.i, b.i)
    infix fun shl(b: Vec3t<out Number>) = shl(Vec3ub(), this, b.x.i, b.y.i, b.z.i)

    infix fun shlAssign(b: Number) = shl(this, this, b.i, b.i, b.i)
    infix fun shlAssign(b: Vec3t<out Number>) = shl(this, this, b.x.i, b.y.i, b.z.i)

    fun shl(b: Number, res: Vec3ub) = shl(res, this, b.i, b.i, b.i)
    fun shl(b: Vec3t<out Number>, res: Vec3ub) = shl(res, this, b.x.i, b.y.i, b.z.i)

    fun shl(bX: Number, bY: Number, bZ: Number, res: Vec3ub = Vec3ub()) = shl(res, this, bX.i, bY.i, bZ.i)

    fun shlAssign(bX: Number, bY: Number, bZ: Number) = shl(this, this, bX.i, bY.i, bZ.i)


    infix fun shr(b: Number) = shr(Vec3ub(), this, b.i, b.i, b.i)
    infix fun shr(b: Vec3t<out Number>) = shr(Vec3ub(), this, b.x.i, b.y.i, b.z.i)

    infix fun shrAssign(b: Number) = shr(this, this, b.i, b.i, b.i)
    infix fun shrAssign(b: Vec3t<out Number>) = shr(this, this, b.x.i, b.y.i, b.z.i)

    fun shr(b: Number, res: Vec3ub) = shr(res, this, b.i, b.i, b.i)
    fun shr(b: Vec3t<out Number>, res: Vec3ub) = shr(res, this, b.x.i, b.y.i, b.z.i)

    fun shr(bX: Number, bY: Number, bZ: Number, res: Vec3ub = Vec3ub()) = shr(res, this, bX.i, bY.i, bZ.i)

    fun shrAssign(bX: Number, bY: Number, bZ: Number) = shr(this, this, bX.i, bY.i, bZ.i)


    companion object : vec3ub_operators() {
        const val length = Vec3t.length
        @JvmField
        val size = length * Ubyte.BYTES
    }

    override fun size() = size

    override fun equals(other: Any?) = other is Vec3ub && this[0] == other[0] && this[1] == other[1] && this[2] == other[2]
    override fun hashCode() = 31 * (31 * x.v.hashCode() + y.v.hashCode()) + z.v.hashCode()
}