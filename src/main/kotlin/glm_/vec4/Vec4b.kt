package glm_.vec4

import glm_.*
import glm_.vec2.Vec2bool
import glm_.vec2.Vec2t
import glm_.vec3.Vec3bool
import glm_.vec3.Vec3t
import glm_.vec4.operators.vec4b_operators
import java.nio.*

/**
 * Created by elect on 09/10/16.
 */

class Vec4b(x: Byte, y: Byte, z: Byte, w: Byte) : Vec4t<Byte>(x, y, z, w) {


    // -- Explicit basic, conversion other main.and conversion vector constructors --

    constructor() : this(0)

    constructor(v: Vec2t<out Number>) : this(v.x, v.y, 0, 1)
    constructor(v: Vec2t<out Number>, z: Number, w: Number) : this(v.x, v.y, z, w)
    constructor(v: Vec3t<out Number>) : this(v, 1)
    constructor(v: Vec3t<out Number>, w: Number) : this(v.x, v.y, v.z, w)
    constructor(x: Number, v: Vec3t<out Number>) : this(x, v.x, v.y, v.z)
    constructor(v: Vec4t<out Number>) : this(v.x, v.y, v.z, v.w)

    constructor(v: Vec2bool) : this(v.x.b, v.y.b, 0, 1)
    constructor(v: Vec3bool) : this(v.x.b, v.y.b, v.z.b, 1)
    constructor(v: Vec4bool) : this(v.x.b, v.y.b, v.z.b, v.w.b)

    constructor(bytes: ByteArray, index: Int = 0) : this(bytes[index], bytes[index + 1], bytes[index + 2], bytes[index + 3])
    constructor(chars: CharArray, index: Int = 0) : this(chars[index].b, chars[index + 1].b, chars[index + 2].b, chars[index + 3].b)
    constructor(shorts: ShortArray, index: Int = 0) : this(shorts[index], shorts[index + 1], shorts[index + 2], shorts[index + 3])
    constructor(ints: IntArray, index: Int = 0) : this(ints[index], ints[index + 1], ints[index + 2], ints[index + 3])
    constructor(longs: LongArray, index: Int = 0) : this(longs[index], longs[index + 1], longs[index + 2], longs[index + 3])
    constructor(floats: FloatArray, index: Int = 0) : this(floats[index], floats[index + 1], floats[index + 2], floats[index + 3])
    constructor(doubles: DoubleArray, index: Int = 0) : this(doubles[index], doubles[index + 1], doubles[index + 2], doubles[index + 3])
    constructor(booleans: BooleanArray, index: Int = 0) : this(booleans[index].b, booleans[index + 1].b, booleans[index + 2].b, booleans[index + 3].b)

    constructor(numbers: Array<out Number>, index: Int = 0) : this(numbers[index], numbers[index + 1], numbers[index + 2], numbers[index + 3])
    constructor(chars: Array<Char>, index: Int = 0) : this(chars[index].b, chars[index + 1].b, chars[index + 2].b, chars[index + 3].b)
    constructor(booleans: Array<Boolean>, index: Int = 0) : this(booleans[index].b, booleans[index + 1].b, booleans[index + 2].b, booleans[index + 3].b)

    constructor(list: Iterable<*>, index: Int = 0) : this(list.elementAt(index)!!.toByte, list.elementAt(index + 1)!!.toByte,
            list.elementAt(index + 2)!!.toByte, list.elementAt(index + 3)!!.toByte)

    constructor(bytes: ByteBuffer, index: Int = bytes.position()) : this(bytes[index], bytes[index + 1], bytes[index + 2], bytes[index + 3])
    constructor(chars: CharBuffer, index: Int = chars.position()) : this(chars[index].b, chars[index + 1].b, chars[index + 2].b, chars[index + 3].b)
    constructor(shorts: ShortBuffer, index: Int = shorts.position()) : this(shorts[index], shorts[index + 1], shorts[index + 2], shorts[index + 3])
    constructor(ints: IntBuffer, index: Int = ints.position()) : this(ints[index], ints[index + 1], ints[index + 2], ints[index + 3])
    constructor(longs: LongBuffer, index: Int = longs.position()) : this(longs[index], longs[index + 1], longs[index + 2], longs[index + 3])
    constructor(floats: FloatBuffer, index: Int = floats.position()) : this(floats[index], floats[index + 1], floats[index + 2], floats[index + 3])
    constructor(doubles: DoubleBuffer, index: Int = doubles.position()) : this(doubles[index], doubles[index + 1], doubles[index + 2], doubles[index + 3])

    constructor(block: (Int) -> Byte) : this(block(0), block(1), block(2), block(3))

    constructor(s: Number) : this(s, s, s, s)
    constructor(x: Number, y: Number, z: Number, w: Number) : this(x.b, y.b, z.b, w.b)


    override fun put(x: Number, y: Number, z: Number, w: Number): Vec4b {
        this.x = x.b
        this.y = y.b
        this.z = z.b
        this.w = w.b
        return this
    }


    infix fun to(bytes: ByteArray) = to(bytes, 0)
    fun to(bytes: ByteArray, index: Int): ByteArray {
        bytes[index] = x
        bytes[index + 1] = y
        bytes[index + 2] = z
        return bytes
    }

    override infix fun to(bytes: ByteBuffer) = to(bytes, bytes.position())
    override fun to(bytes: ByteBuffer, index: Int): ByteBuffer {
        bytes.put(index, x)
        bytes.put(index + Byte.BYTES, y)
        bytes.put(index + Byte.BYTES * 2, z)
        bytes.put(index + Byte.BYTES * 3, w)
        return bytes
    }


    // -- Component accesses --

    override operator fun set(index: Int, value: Number) = when (index) {
        0 -> x = value.b
        1 -> y = value.b
        2 -> z = value.b
        3 -> w = value.b
        else -> throw ArrayIndexOutOfBoundsException()
    }


    companion object : vec4b_operators() {
        @JvmField
        val length = 4
        @JvmField
        val size = length * Byte.BYTES
    }

    override fun size() = size


    // -- Unary arithmetic operators --

    operator fun unaryPlus() = this

    operator fun unaryMinus() = Vec4b(-x.b, -y.b, -z.b, -w.b)

    // -- Increment main.and decrement operators --

    operator fun inc(res: Vec4b = Vec4b()) = plus(res, this, 1, 1, 1, 1)
    fun incAssign() = plus(this, this, 1, 1, 1, 1)


    operator fun dec(res: Vec4b = Vec4b()) = minus(res, this, 1, 1, 1, 1)
    fun decAssign() = minus(this, this, 1, 1, 1, 1)


    // -- Specific binary arithmetic operators --

    operator fun plus(b: Byte) = plus(Vec4b(), this, b, b, b, b)
    operator fun plus(b: Int) = plus(Vec4b(), this, b, b, b, b)
    operator fun plus(b: Vec4b) = plus(Vec4b(), this, b.x, b.y, b.z, b.w)

    fun plus(bX: Byte, bY: Byte, bZ: Byte, bW: Byte, res: Vec4b = Vec4b()) = plus(res, this, bX, bY, bZ, bW)
    fun plus(bX: Int, bY: Int, bZ: Int, bW: Int, res: Vec4b = Vec4b()) = plus(res, this, bX, bY, bZ, bW)
    fun plus(b: Byte, res: Vec4b = Vec4b()) = plus(res, this, b, b, b, b)
    fun plus(b: Int, res: Vec4b = Vec4b()) = plus(res, this, b, b, b, b)
    fun plus(b: Vec4b, res: Vec4b = Vec4b()) = plus(res, this, b.x, b.y, b.z, b.w)

    fun plusAssign(bX: Byte, bY: Byte, bZ: Byte, bW: Byte) = plus(this, this, bX, bY, bZ, bW)
    fun plusAssign(bX: Int, bY: Int, bZ: Int, bW: Int) = plus(this, this, bX, bY, bZ, bW)
    infix operator fun plusAssign(b: Byte) {
        plus(this, this, b, b, b, b)
    }
    infix operator fun plusAssign(b: Int) {
        plus(this, this, b, b, b, b)
    }
    infix operator fun plusAssign(b: Vec4b) {
        plus(this, this, b.x, b.y, b.z, b.w)
    }


    operator fun minus(b: Byte) = minus(Vec4b(), this, b, b, b, b)
    operator fun minus(b: Int) = minus(Vec4b(), this, b, b, b, b)
    operator fun minus(b: Vec4b) = minus(Vec4b(), this, b.x, b.y, b.z, b.w)

    fun minus(bX: Byte, bY: Byte, bZ: Byte, bW: Byte, res: Vec4b = Vec4b()) = minus(res, this, bX, bY, bZ, bW)
    fun minus(bX: Int, bY: Int, bZ: Int, bW: Int, res: Vec4b = Vec4b()) = minus(res, this, bX, bY, bZ, bW)
    fun minus(b: Byte, res: Vec4b = Vec4b()) = minus(res, this, b, b, b, b)
    fun minus(b: Int, res: Vec4b = Vec4b()) = minus(res, this, b, b, b, b)
    fun minus(b: Vec4b, res: Vec4b = Vec4b()) = minus(res, this, b.x, b.y, b.z, b.w)

    fun minusAssign(bX: Byte, bY: Byte, bZ: Byte, bW: Byte) = minus(this, this, bX, bY, bZ, bW)
    fun minusAssign(bX: Int, bY: Int, bZ: Int, bW: Int) = minus(this, this, bX, bY, bZ, bW)
    infix operator fun minusAssign(b: Byte) {
        minus(this, this, b, b, b, b)
    }
    infix operator fun minusAssign(b: Int) {
        minus(this, this, b, b, b, b)
    }
    infix operator fun minusAssign(b: Vec4b) {
        minus(this, this, b.x, b.y, b.z, b.w)
    }


    operator fun times(b: Byte) = times(Vec4b(), this, b, b, b, b)
    operator fun times(b: Int) = times(Vec4b(), this, b, b, b, b)
    operator fun times(b: Vec4b) = times(Vec4b(), this, b.x, b.y, b.z, b.w)

    fun times(bX: Byte, bY: Byte, bZ: Byte, bW: Byte, res: Vec4b = Vec4b()) = times(res, this, bX, bY, bZ, bW)
    fun times(bX: Int, bY: Int, bZ: Int, bW: Int, res: Vec4b = Vec4b()) = times(res, this, bX, bY, bZ, bW)
    fun times(b: Byte, res: Vec4b = Vec4b()) = times(res, this, b, b, b, b)
    fun times(b: Int, res: Vec4b = Vec4b()) = times(res, this, b, b, b, b)
    fun times(b: Vec4b, res: Vec4b = Vec4b()) = times(res, this, b.x, b.y, b.z, b.w)

    fun timesAssign(bX: Byte, bY: Byte, bZ: Byte, bW: Byte) = times(this, this, bX, bY, bZ, bW)
    fun timesAssign(bX: Int, bY: Int, bZ: Int, bW: Int) = times(this, this, bX, bY, bZ, bW)
    infix operator fun timesAssign(b: Byte) {
        times(this, this, b, b, b, b)
    }
    infix operator fun timesAssign(b: Int) {
        times(this, this, b, b, b, b)
    }
    infix operator fun timesAssign(b: Vec4b) {
        times(this, this, b.x, b.y, b.z, b.w)
    }


    operator fun div(b: Byte) = div(Vec4b(), this, b, b, b, b)
    operator fun div(b: Int) = div(Vec4b(), this, b, b, b, b)
    operator fun div(b: Vec4b) = div(Vec4b(), this, b.x, b.y, b.z, b.w)

    fun div(bX: Byte, bY: Byte, bZ: Byte, bW: Byte, res: Vec4b = Vec4b()) = div(res, this, bX, bY, bZ, bW)
    fun div(bX: Int, bY: Int, bZ: Int, bW: Int, res: Vec4b = Vec4b()) = div(res, this, bX, bY, bZ, bW)
    fun div(b: Byte, res: Vec4b) = div(res, this, b, b, b, b)
    fun div(b: Int, res: Vec4b) = div(res, this, b, b, b, b)
    fun div(b: Vec4b, res: Vec4b) = div(res, this, b.x, b.y, b.z, b.w)

    fun divAssign(bX: Byte, bY: Byte, bZ: Byte, bW: Byte) = div(this, this, bX, bY, bZ, bW)
    fun divAssign(bX: Int, bY: Int, bZ: Int, bW: Int) = div(this, this, bX, bY, bZ, bW)
    infix operator fun divAssign(b: Byte) {
        div(this, this, b, b, b, b)
    }
    infix operator fun divAssign(b: Int) {
        div(this, this, b, b, b, b)
    }
    infix operator fun divAssign(b: Vec4b) {
        div(this, this, b.x, b.y, b.z, b.w)
    }


    operator fun rem(b: Byte) = rem(Vec4b(), this, b, b, b, b)
    operator fun rem(b: Int) = rem(Vec4b(), this, b, b, b, b)
    operator fun rem(b: Vec4b) = rem(Vec4b(), this, b.x, b.y, b.z, b.w)

    fun rem(bX: Byte, bY: Byte, bZ: Byte, bW: Byte, res: Vec4b = Vec4b()) = rem(res, this, bX, bY, bZ, bW)
    fun rem(bX: Int, bY: Int, bZ: Int, bW: Int, res: Vec4b = Vec4b()) = rem(res, this, bX, bY, bZ, bW)
    fun rem(b: Byte, res: Vec4b) = rem(res, this, b, b, b, b)
    fun rem(b: Int, res: Vec4b) = rem(res, this, b, b, b, b)
    fun rem(b: Vec4b, res: Vec4b) = rem(res, this, b.x, b.y, b.z, b.w)

    fun remAssign(bX: Byte, bY: Byte, bZ: Byte, bW: Byte) = rem(this, this, bX, bY, bZ, bW)
    fun remAssign(bX: Int, bY: Int, bZ: Int, bW: Int) = rem(this, this, bX, bY, bZ, bW)
    infix operator fun remAssign(b: Byte) {
        rem(this, this, b, b, b, b)
    }
    infix operator fun remAssign(b: Int) {
        rem(this, this, b, b, b, b)
    }
    infix operator fun remAssign(b: Vec4b) {
        rem(this, this, b.x, b.y, b.z, b.w)
    }


    // -- Generic binary arithmetic operators --

    operator fun plus(b: Number) = plus(Vec4b(), this, b.i, b.i, b.i, b.i)
    operator fun plus(b: Vec4t<out Number>) = plus(Vec4b(), this, b.x.i, b.y.i, b.z.i, b.w.i)

    fun plus(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4b = Vec4b()) = plus(res, this, bX.i, bY.i, bZ.i, bW.i)
    fun plus(b: Number, res: Vec4b = Vec4b()) = plus(res, this, b.i, b.i, b.i, b.i)
    fun plus(b: Vec4t<out Number>, res: Vec4b = Vec4b()) = plus(res, this, b.x.i, b.y.i, b.z.i, b.w.i)

    fun plusAssign(bX: Number, bY: Number, bZ: Number, bW: Number) = plus(this, this, bX.i, bY.i, bZ.i, bW.i)
    infix operator fun plusAssign(b: Number) {
        plus(this, this, b.i, b.i, b.i, b.i)
    }
    infix operator fun plusAssign(b: Vec4t<out Number>) {
        plus(this, this, b.x.i, b.y.i, b.z.i, b.w.i)
    }


    operator fun minus(b: Number) = minus(Vec4b(), this, b.i, b.i, b.i, b.i)
    operator fun minus(b: Vec4t<out Number>) = minus(Vec4b(), this, b.x.i, b.y.i, b.z.i, b.w.i)

    fun minus(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4b = Vec4b()) = minus(res, this, bX.i, bY.i, bZ.i, bW.i)
    fun minus(b: Number, res: Vec4b = Vec4b()) = minus(res, this, b.i, b.i, b.i, b.i)
    fun minus(b: Vec4t<out Number>, res: Vec4b = Vec4b()) = minus(res, this, b.x.i, b.y.i, b.z.i, b.w.i)

    fun minusAssign(bX: Number, bY: Number, bZ: Number, bW: Number) = minus(this, this, bX.i, bY.i, bZ.i, bW.i)
    infix operator fun minusAssign(b: Number) {
        minus(this, this, b.i, b.i, b.i, b.i)
    }
    infix operator fun minusAssign(b: Vec4t<out Number>) {
        minus(this, this, b.x.i, b.y.i, b.z.i, b.w.i)
    }


    operator fun times(b: Number) = times(Vec4b(), this, b.i, b.i, b.i, b.i)
    operator fun times(b: Vec4t<out Number>) = times(Vec4b(), this, b.x.i, b.y.i, b.z.i, b.w.i)

    fun times(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4b = Vec4b()) = times(res, this, bX.i, bY.i, bZ.i, bW.i)
    fun times(b: Number, res: Vec4b = Vec4b()) = times(res, this, b.i, b.i, b.i, b.i)
    fun times(b: Vec4t<out Number>, res: Vec4b = Vec4b()) = times(res, this, b.x.i, b.y.i, b.z.i, b.w.i)

    fun timesAssign(bX: Number, bY: Number, bZ: Number, bW: Number) = times(this, this, bX.i, bY.i, bZ.i, bW.i)
    infix operator fun timesAssign(b: Number) {
        times(this, this, b.i, b.i, b.i, b.i)
    }
    infix operator fun timesAssign(b: Vec4t<out Number>) {
        times(this, this, b.x.i, b.y.i, b.z.i, b.w.i)
    }


    operator fun div(b: Number) = div(Vec4b(), this, b.i, b.i, b.i, b.i)
    operator fun div(b: Vec4t<out Number>) = div(Vec4b(), this, b.x.i, b.y.i, b.z.i, b.w.i)

    fun div(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4b = Vec4b()) = div(res, this, bX.i, bY.i, bZ.i, bW.i)
    fun div(b: Number, res: Vec4b = Vec4b()) = div(res, this, b.i, b.i, b.i, b.i)
    fun div(b: Vec4t<out Number>, res: Vec4b = Vec4b()) = div(res, this, b.x.i, b.y.i, b.z.i, b.w.i)

    fun divAssign(bX: Number, bY: Number, bZ: Number, bW: Number) = div(this, this, bX.i, bY.i, bZ.i, bW.i)
    infix operator fun divAssign(b: Number) {
        div(this, this, b.i, b.i, b.i, b.i)
    }
    infix operator fun divAssign(b: Vec4t<out Number>) {
        div(this, this, b.x.i, b.y.i, b.z.i, b.w.i)
    }


    operator fun rem(b: Number) = rem(Vec4b(), this, b.i, b.i, b.i, b.i)
    operator fun rem(b: Vec4t<out Number>) = rem(Vec4b(), this, b.x.i, b.y.i, b.z.i, b.w.i)

    fun rem(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4b = Vec4b()) = rem(res, this, bX.i, bY.i, bZ.i, bW.i)
    fun rem(b: Number, res: Vec4b = Vec4b()) = rem(res, this, b.i, b.i, b.i, b.i)
    fun rem(b: Vec4t<out Number>, res: Vec4b = Vec4b()) = rem(res, this, b.x.i, b.y.i, b.z.i, b.w.i)

    fun remAssign(bX: Number, bY: Number, bZ: Number, bW: Number) = rem(this, this, bX.i, bY.i, bZ.i, bW.i)
    infix operator fun remAssign(b: Number) {
        rem(this, this, b.i, b.i, b.i, b.i)
    }
    infix operator fun remAssign(b: Vec4t<out Number>) {
        rem(this, this, b.x.i, b.y.i, b.z.i, b.w.i)
    }


    // -- Specific bitwise operators --

    infix fun and(b: Byte) = and(Vec4b(), this, b, b, b, b)
    infix fun and(b: Int) = and(Vec4b(), this, b, b, b, b)
    infix fun and(b: Vec4b) = and(Vec4b(), this, b.x, b.y, b.z, b.w)

    infix fun andAssign(b: Byte) = and(this, this, b, b, b, b)
    infix fun andAssign(b: Int) = and(this, this, b, b, b, b)
    infix fun andAssign(b: Vec4b) = and(this, this, b.x, b.y, b.z, b.w)

    fun and(b: Byte, res: Vec4b) = and(res, this, b, b, b, b)
    fun and(b: Int, res: Vec4b) = and(res, this, b, b, b, b)
    fun and(b: Vec4b, res: Vec4b) = and(res, this, b.x, b.y, b.z, b.w)

    fun and(bX: Byte, bY: Byte, bZ: Byte, bW: Byte, res: Vec4b = Vec4b()) = and(res, this, bX, bY, bZ, bW)
    fun and(bX: Int, bY: Int, bZ: Int, bW: Int, res: Vec4b = Vec4b()) = and(res, this, bX, bY, bZ, bW)

    fun andAssign(bX: Byte, bY: Byte, bZ: Byte, bW: Byte) = and(this, this, bX, bY, bZ, bW)
    fun andAssign(bX: Int, bY: Int, bZ: Int, bW: Int) = and(this, this, bX, bY, bZ, bW)


    infix fun or(b: Byte) = or(Vec4b(), this, b, b, b, b)
    infix fun or(b: Int) = or(Vec4b(), this, b, b, b, b)
    infix fun or(b: Vec4b) = or(Vec4b(), this, b.x, b.y, b.z, b.w)

    infix fun orAssign(b: Byte) = or(this, this, b, b, b, b)
    infix fun orAssign(b: Int) = or(this, this, b, b, b, b)
    infix fun orAssign(b: Vec4b) = or(this, this, b.x, b.y, b.z, b.w)

    fun or(b: Byte, res: Vec4b) = or(res, this, b, b, b, b)
    fun or(b: Int, res: Vec4b) = or(res, this, b, b, b, b)
    fun or(b: Vec4b, res: Vec4b) = or(res, this, b.x, b.y, b.z, b.w)

    fun or(bX: Byte, bY: Byte, bZ: Byte, bW: Byte, res: Vec4b = Vec4b()) = or(res, this, bX, bY, bZ, bW)
    fun or(bX: Int, bY: Int, bZ: Int, bW: Int, res: Vec4b = Vec4b()) = or(res, this, bX, bY, bZ, bW)

    fun orAssign(bX: Byte, bY: Byte, bZ: Byte, bW: Byte) = or(this, this, bX, bY, bZ, bW)
    fun orAssign(bX: Int, bY: Int, bZ: Int, bW: Int) = or(this, this, bX, bY, bZ, bW)


    infix fun xor(b: Byte) = xor(Vec4b(), this, b, b, b, b)
    infix fun xor(b: Int) = xor(Vec4b(), this, b, b, b, b)
    infix fun xor(b: Vec4b) = xor(Vec4b(), this, b.x, b.y, b.z, b.w)

    infix fun xorAssign(b: Byte) = xor(this, this, b, b, b, b)
    infix fun xorAssign(b: Int) = xor(this, this, b, b, b, b)
    infix fun xorAssign(b: Vec4b) = xor(this, this, b.x, b.y, b.z, b.w)

    fun xor(b: Byte, res: Vec4b) = xor(res, this, b, b, b, b)
    fun xor(b: Int, res: Vec4b) = xor(res, this, b, b, b, b)
    fun xor(b: Vec4b, res: Vec4b) = xor(res, this, b.x, b.y, b.z, b.w)

    fun xor(bX: Byte, bY: Byte, bZ: Byte, bW: Byte, res: Vec4b = Vec4b()) = xor(res, this, bX, bY, bZ, bW)
    fun xor(bX: Int, bY: Int, bZ: Int, bW: Int, res: Vec4b = Vec4b()) = xor(res, this, bX, bY, bZ, bW)

    fun xorAssign(bX: Byte, bY: Byte, bZ: Byte, bW: Byte) = xor(this, this, bX, bY, bZ, bW)
    fun xorAssign(bX: Int, bY: Int, bZ: Int, bW: Int) = xor(this, this, bX, bY, bZ, bW)


    infix fun shl(b: Byte) = shl(Vec4b(), this, b, b, b, b)
    infix fun shl(b: Int) = shl(Vec4b(), this, b, b, b, b)
    infix fun shl(b: Vec4b) = shl(Vec4b(), this, b.x, b.y, b.z, b.w)

    infix fun shlAssign(b: Byte) = shl(this, this, b, b, b, b)
    infix fun shlAssign(b: Int) = shl(this, this, b, b, b, b)
    infix fun shlAssign(b: Vec4b) = shl(this, this, b.x, b.y, b.z, b.w)

    fun shl(b: Byte, res: Vec4b) = shl(res, this, b, b, b, b)
    fun shl(b: Int, res: Vec4b) = shl(res, this, b, b, b, b)
    fun shl(b: Vec4b, res: Vec4b) = shl(res, this, b.x, b.y, b.z, b.w)

    fun shl(bX: Byte, bY: Byte, bZ: Byte, bW: Byte, res: Vec4b = Vec4b()) = shl(res, this, bX, bY, bZ, bW)
    fun shl(bX: Int, bY: Int, bZ: Int, bW: Int, res: Vec4b = Vec4b()) = shl(res, this, bX, bY, bZ, bW)

    fun shlAssign(bX: Byte, bY: Byte, bZ: Byte, bW: Byte) = shl(this, this, bX, bY, bZ, bW)
    fun shlAssign(bX: Int, bY: Int, bZ: Int, bW: Int) = shl(this, this, bX, bY, bZ, bW)


    infix fun shr(b: Byte) = shr(Vec4b(), this, b, b, b, b)
    infix fun shr(b: Int) = shr(Vec4b(), this, b, b, b, b)
    infix fun shr(b: Vec4b) = shr(Vec4b(), this, b.x, b.y, b.z, b.w)

    infix fun shrAssign(b: Byte) = shr(this, this, b, b, b, b)
    infix fun shrAssign(b: Int) = shr(this, this, b, b, b, b)
    infix fun shrAssign(b: Vec4b) = shr(this, this, b.x, b.y, b.z, b.w)

    fun shr(b: Byte, res: Vec4b) = shr(res, this, b, b, b, b)
    fun shr(b: Int, res: Vec4b) = shr(res, this, b, b, b, b)
    fun shr(b: Vec4b, res: Vec4b) = shr(res, this, b.x, b.y, b.z, b.w)

    fun shr(bX: Byte, bY: Byte, bZ: Byte, bW: Byte, res: Vec4b = Vec4b()) = shr(res, this, bX, bY, bZ, bW)
    fun shr(bX: Int, bY: Int, bZ: Int, bW: Int, res: Vec4b = Vec4b()) = shr(res, this, bX, bY, bZ, bW)

    fun shrAssign(bX: Byte, bY: Byte, bZ: Byte, bW: Byte) = shr(this, this, bX, bY, bZ, bW)
    fun shrAssign(bX: Int, bY: Int, bZ: Int, bW: Int) = shr(this, this, bX, bY, bZ, bW)


    fun inv(res: Vec4b = Vec4b()) = inv(res, this)
    fun invAssign() = inv(this, this)


    // -- Generic bitwise operators --

    infix fun and(b: Number) = and(Vec4b(), this, b.b, b.b, b.b, b.b)
    infix fun and(b: Vec4t<out Number>) = and(Vec4b(), this, b.x.b, b.y.b, b.z.b, b.w.b)

    infix fun andAssign(b: Number) = and(this, this, b.b, b.b, b.b, b.b)
    infix fun andAssign(b: Vec4t<out Number>) = and(this, this, b.x.b, b.y.b, b.z.b, b.w.b)

    fun and(b: Number, res: Vec4b = Vec4b()) = and(res, this, b.b, b.b, b.b, b.b)
    fun and(b: Vec4t<out Number>, res: Vec4b = Vec4b()) = and(res, this, b.x.b, b.y.b, b.z.b, b.w.b)

    fun and(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4b = Vec4b()) = and(res, this, bX.b, bY.b, bZ.b, bW.b)

    fun andAssign(bX: Number, bY: Number, bZ: Number, bW: Number) = and(this, this, bX.b, bY.b, bZ.b, bW.b)


    infix fun or(b: Number) = or(Vec4b(), this, b.b, b.b, b.b, b.b)
    infix fun or(b: Vec4t<out Number>) = or(Vec4b(), this, b.x.b, b.y.b, b.z.b, b.w.b)

    infix fun orAssign(b: Number) = or(this, this, b.b, b.b, b.b, b.b)
    infix fun orAssign(b: Vec4t<out Number>) = or(this, this, b.x.b, b.y.b, b.z.b, b.w.b)

    fun or(b: Number, res: Vec4b = Vec4b()) = or(res, this, b.b, b.b, b.b, b.b)
    fun or(b: Vec4t<out Number>, res: Vec4b = Vec4b()) = or(res, this, b.x.b, b.y.b, b.z.b, b.w.b)

    fun or(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4b = Vec4b()) = or(res, this, bX.b, bY.b, bZ.b, bW.b)

    fun orAssign(bX: Number, bY: Number, bZ: Number, bW: Number) = or(this, this, bX.b, bY.b, bZ.b, bW.b)


    infix fun xor(b: Number) = xor(Vec4b(), this, b.b, b.b, b.b, b.b)
    infix fun xor(b: Vec4t<out Number>) = xor(Vec4b(), this, b.x.b, b.y.b, b.z.b, b.w.b)

    infix fun xorAssign(b: Number) = xor(this, this, b.b, b.b, b.b, b.b)
    infix fun xorAssign(b: Vec4t<out Number>) = xor(this, this, b.x.b, b.y.b, b.z.b, b.w.b)

    fun xor(b: Number, res: Vec4b = Vec4b()) = xor(res, this, b.b, b.b, b.b, b.b)
    fun xor(b: Vec4t<out Number>, res: Vec4b = Vec4b()) = xor(res, this, b.x.b, b.y.b, b.z.b, b.w.b)

    fun xor(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4b = Vec4b()) = xor(res, this, bX.b, bY.b, bZ.b, bW.b)

    fun xorAssign(bX: Number, bY: Number, bZ: Number, bW: Number) = xor(this, this, bX.b, bY.b, bZ.b, bW.b)


    infix fun shl(b: Number) = shl(Vec4b(), this, b.b, b.b, b.b, b.b)
    infix fun shl(b: Vec4t<out Number>) = shl(Vec4b(), this, b.x.b, b.y.b, b.z.b, b.w.b)

    infix fun shlAssign(b: Number) = shl(this, this, b.b, b.b, b.b, b.b)
    infix fun shlAssign(b: Vec4t<out Number>) = shl(this, this, b.x.b, b.y.b, b.z.b, b.w.b)

    fun shl(b: Number, res: Vec4b = Vec4b()) = shl(res, this, b.b, b.b, b.b, b.b)
    fun shl(b: Vec4t<out Number>, res: Vec4b = Vec4b()) = shl(res, this, b.x.b, b.y.b, b.z.b, b.w.b)

    fun shl(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4b = Vec4b()) = shl(res, this, bX.b, bY.b, bZ.b, bW.b)

    fun shlAssign(bX: Number, bY: Number, bZ: Number, bW: Number) = shl(this, this, bX.b, bY.b, bZ.b, bW.b)


    infix fun shr(b: Number) = shr(Vec4b(), this, b.b, b.b, b.b, b.b)
    infix fun shr(b: Vec4t<out Number>) = shr(Vec4b(), this, b.x.b, b.y.b, b.z.b, b.w.b)

    infix fun shrAssign(b: Number) = shr(this, this, b.b, b.b, b.b, b.b)
    infix fun shrAssign(b: Vec4t<out Number>) = shr(this, this, b.x.b, b.y.b, b.z.b, b.w.b)

    fun shr(b: Number, res: Vec4b = Vec4b()) = shr(res, this, b.b, b.b, b.b, b.b)
    fun shr(b: Vec4t<out Number>, res: Vec4b = Vec4b()) = shr(res, this, b.x.b, b.y.b, b.z.b, b.w.b)

    fun shr(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4b = Vec4b()) = shr(res, this, bX.b, bY.b, bZ.b, bW.b)

    fun shrAssign(bX: Number, bY: Number, bZ: Number, bW: Number) = shr(this, this, bX.b, bY.b, bZ.b, bW.b)


    override fun equals(other: Any?) = other is Vec4b && this[0] == other[0] && this[1] == other[1] && this[2] == other[2] && this[3] == other[3]
    override fun hashCode() = 31 * (31 * (31 * x.hashCode() + y.hashCode()) + z.hashCode()) + w.hashCode()
}