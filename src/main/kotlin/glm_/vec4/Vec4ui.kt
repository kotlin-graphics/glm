package glm_.vec4

import glm_.*
import glm_.vec2.Vec2bool
import glm_.vec2.Vec2t
import glm_.vec3.Vec3bool
import glm_.vec3.Vec3t
import glm_.vec4.operators.vec4ui_operators
import unsigned.Uint
import java.nio.*

/**
 * Created by elect on 09/10/16.
 */

class Vec4ui(x: Uint, y: Uint, z: Uint, w: Uint) : Vec4t<Uint>(x, y, z, w) {

    // -- Explicit basic, conversion other main.and conversion vector constructors --

    constructor() : this(0)

    constructor(v: Vec2t<out Number>) : this(v.x, v.y, 0, 1)
    constructor(v: Vec2t<out Number>, z: Number, w: Number) : this(v.x, v.y, z, w)
    constructor(v: Vec3t<out Number>) : this(v, 1)
    constructor(v: Vec3t<out Number>, w: Number) : this(v.x, v.y, v.z, w)
    constructor(x: Number, v: Vec3t<out Number>) : this(x, v.x, v.y, v.z)
    constructor(v: Vec4t<out Number>) : this(v.x, v.y, v.z, v.w)

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

    constructor(bytes: ByteBuffer, index: Int = bytes.position(), oneByteOneUint: Boolean = false) : this(
            if (oneByteOneUint) bytes[index].ui else bytes.getInt(index).ui,
            if (oneByteOneUint) bytes[index + 1].ui else bytes.getInt(index + Uint.BYTES).ui,
            if (oneByteOneUint) bytes[index + 2].ui else bytes.getInt(index + Uint.BYTES * 2).ui,
            if (oneByteOneUint) bytes[index + 3].ui else bytes.getInt(index + Uint.BYTES * 3).ui)

    constructor(chars: CharBuffer, index: Int = chars.position()) : this(chars[index].ui, chars[index + 1].ui, chars[index + 2].ui, chars[index + 3].ui)
    constructor(shorts: ShortBuffer, index: Int = shorts.position()) : this(shorts[index], shorts[index + 1], shorts[index + 2], shorts[index + 3])
    constructor(ints: IntBuffer, index: Int = ints.position()) : this(ints[index], ints[index + 1], ints[index + 2], ints[index + 3])
    constructor(longs: LongBuffer, index: Int = longs.position()) : this(longs[index], longs[index + 1], longs[index + 2], longs[index + 3])
    constructor(floats: FloatBuffer, index: Int = floats.position()) : this(floats[index], floats[index + 1], floats[index + 2], floats[index + 3])
    constructor(doubles: DoubleBuffer, index: Int = doubles.position()) : this(doubles[index], doubles[index + 1], doubles[index + 2], doubles[index + 3])

    constructor(block: (Int) -> Uint) : this(block(0), block(1), block(2), block(3))

    constructor(s: Number) : this(s, s, s, s)
    constructor(x: Number, y: Number, z: Number, w: Number) : this(x.ui, y.ui, z.ui, w.ui)


    fun set(bytes: ByteArray, index: Int = 0, oneByteOneUint: Boolean = false, bigEndian: Boolean = true) {
        x.v = if (oneByteOneUint) bytes[index].i else bytes.getInt(index, bigEndian)
        y.v = if (oneByteOneUint) bytes[index + 1].i else bytes.getInt(index + Uint.BYTES, bigEndian)
        z.v = if (oneByteOneUint) bytes[index + 2].i else bytes.getInt(index + Uint.BYTES * 2, bigEndian)
        w.v = if (oneByteOneUint) bytes[index + 3].i else bytes.getInt(index + Uint.BYTES * 3, bigEndian)
    }

    fun set(bytes: ByteBuffer, index: Int = bytes.position(), oneByteOneUint: Boolean = false) {
        x.v = if (oneByteOneUint) bytes[index].i else bytes.getInt(index)
        y.v = if (oneByteOneUint) bytes[index + 1].i else bytes.getInt(index + Uint.BYTES)
        z.v = if (oneByteOneUint) bytes[index + 2].i else bytes.getInt(index + Uint.BYTES * 2)
        w.v = if (oneByteOneUint) bytes[index + 3].i else bytes.getInt(index + Uint.BYTES * 3)
    }


    override fun put(x: Number, y: Number, z: Number, w: Number): Vec4ui {
        this.x = x.ui
        this.y = y.ui
        this.z = z.ui
        this.w = w.ui
        return this
    }


    infix fun to(ints: IntArray) = to(ints, 0)
    fun to(ints: IntArray, index: Int): IntArray {
        ints[index] = x.v
        ints[index + 1] = y.v
        ints[index + 2] = z.v
        ints[index + 3] = w.v
        return ints
    }

    infix fun to(ints: IntBuffer) = to(ints, 0)
    fun to(ints: IntBuffer, index: Int): IntBuffer {
        ints[index] = x.v
        ints[index + 1] = y.v
        ints[index + 2] = z.v
        ints[index + 3] = w.v
        return ints
    }


    override infix fun to(bytes: ByteBuffer) = to(bytes, bytes.position())
    override fun to(bytes: ByteBuffer, index: Int): ByteBuffer {
        bytes.putInt(index, x.v)
        bytes.putInt(index + Int.BYTES, y.v)
        bytes.putInt(index + Int.BYTES * 2, z.v)
        bytes.putInt(index + Int.BYTES * 3, w.v)
        return bytes
    }


    // -- Component accesses --

    override operator fun get(i: Int) = when (i) {
        0 -> x
        1 -> y
        2 -> z
        3 -> w
        else -> throw ArrayIndexOutOfBoundsException()
    }

    operator fun set(i: Int, s: Number) = when (i) {
        0 -> x = s.ui
        1 -> y = s.ui
        2 -> z = s.ui
        3 -> w = s.ui
        else -> throw ArrayIndexOutOfBoundsException()
    }


    companion object : vec4ui_operators() {
        @JvmField
        val length = 4
        @JvmField
        val size = length * Uint.BYTES
    }

    override fun size() = size


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
    operator fun plus(b: Vec4t<out Number>) = plus(Vec4ui(), this, b.x.i, b.y.i, b.z.i, b.w.i)

    fun plus(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4ui = Vec4ui()) = plus(res, this, bX.i, bY.i, bZ.i, bW.i)
    fun plus(b: Number, res: Vec4ui = Vec4ui()) = plus(res, this, b.i, b.i, b.i, b.i)
    fun plus(b: Vec4t<out Number>, res: Vec4ui = Vec4ui()) = plus(res, this, b.x.i, b.y.i, b.z.i, b.w.i)

    fun plusAssign(bX: Number, bY: Number, bZ: Number, bW: Number) = plus(this, this, bX.i, bY.i, bZ.i, bW.i)
    infix operator fun plusAssign(b: Number) {
        plus(this, this, b.i, b.i, b.i, b.i)
    }
    infix operator fun plusAssign(b: Vec4t<out Number>) {
        plus(this, this, b.x.i, b.y.i, b.z.i, b.w.i)
    }


    operator fun minus(b: Number) = minus(Vec4ui(), this, b.i, b.i, b.i, b.i)
    operator fun minus(b: Vec4t<out Number>) = minus(Vec4ui(), this, b.x.i, b.y.i, b.z.i, b.w.i)

    fun minus(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4ui = Vec4ui()) = minus(res, this, bX.i, bY.i, bZ.i, bW.i)
    fun minus(b: Number, res: Vec4ui = Vec4ui()) = minus(res, this, b.i, b.i, b.i, b.i)
    fun minus(b: Vec4t<out Number>, res: Vec4ui = Vec4ui()) = minus(res, this, b.x.i, b.y.i, b.z.i, b.w.i)

    fun minusAssign(bX: Number, bY: Number, bZ: Number, bW: Number) = minus(this, this, bX.i, bY.i, bZ.i, bW.i)
    infix operator fun minusAssign(b: Number) {
        minus(this, this, b.i, b.i, b.i, b.i)
    }
    infix operator fun minusAssign(b: Vec4t<out Number>) {
        minus(this, this, b.x.i, b.y.i, b.z.i, b.w.i)
    }


    operator fun times(b: Number) = times(Vec4ui(), this, b.i, b.i, b.i, b.i)
    operator fun times(b: Vec4t<out Number>) = times(Vec4ui(), this, b.x.i, b.y.i, b.z.i, b.w.i)

    fun times(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4ui = Vec4ui()) = times(res, this, bX.i, bY.i, bZ.i, bW.i)
    fun times(b: Number, res: Vec4ui = Vec4ui()) = times(res, this, b.i, b.i, b.i, b.i)
    fun times(b: Vec4t<out Number>, res: Vec4ui = Vec4ui()) = times(res, this, b.x.i, b.y.i, b.z.i, b.w.i)

    fun timesAssign(bX: Number, bY: Number, bZ: Number, bW: Number) = times(this, this, bX.i, bY.i, bZ.i, bW.i)
    infix operator fun timesAssign(b: Number) {
        times(this, this, b.i, b.i, b.i, b.i)
    }
    infix operator fun timesAssign(b: Vec4t<out Number>) {
        times(this, this, b.x.i, b.y.i, b.z.i, b.w.i)
    }


    operator fun div(b: Number) = div(Vec4ui(), this, b.i, b.i, b.i, b.i)
    operator fun div(b: Vec4t<out Number>) = div(Vec4ui(), this, b.x.i, b.y.i, b.z.i, b.w.i)

    fun div(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4ui = Vec4ui()) = div(res, this, bX.i, bY.i, bZ.i, bW.i)
    fun div(b: Number, res: Vec4ui) = div(res, this, b.i, b.i, b.i, b.i)
    fun div(b: Vec4t<out Number>, res: Vec4ui) = div(res, this, b.x.i, b.y.i, b.z.i, b.w.i)

    fun divAssign(bX: Number, bY: Number, bZ: Number, bW: Number) = div(this, this, bX.i, bY.i, bZ.i, bW.i)
    infix operator fun divAssign(b: Number) {
        div(this, this, b.i, b.i, b.i, b.i)
    }
    infix operator fun divAssign(b: Vec4t<out Number>) {
        div(this, this, b.x.i, b.y.i, b.z.i, b.w.i)
    }


    operator fun rem(b: Number) = rem(Vec4ui(), this, b.i, b.i, b.i, b.i)
    operator fun rem(b: Vec4t<out Number>) = rem(Vec4ui(), this, b.x.i, b.y.i, b.z.i, b.w.i)

    fun rem(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4ui = Vec4ui()) = rem(res, this, bX.i, bY.i, bZ.i, bW.i)
    fun rem(b: Number, res: Vec4ui) = rem(res, this, b.i, b.i, b.i, b.i)
    fun rem(b: Vec4t<out Number>, res: Vec4ui) = rem(res, this, b.x.i, b.y.i, b.z.i, b.w.i)

    fun remAssign(bX: Number, bY: Number, bZ: Number, bW: Number) = rem(this, this, bX.i, bY.i, bZ.i, bW.i)
    infix operator fun remAssign(b: Number) {
        rem(this, this, b.i, b.i, b.i, b.i)
    }
    infix operator fun remAssign(b: Vec4t<out Number>) {
        rem(this, this, b.x.i, b.y.i, b.z.i, b.w.i)
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
    infix fun and(b: Vec4t<out Number>) = and(Vec4ui(), this, b.x.i, b.y.i, b.z.i, b.w.i)

    infix fun andAssign(b: Number) = and(this, this, b.i, b.i, b.i, b.i)
    infix fun andAssign(b: Vec4t<out Number>) = and(this, this, b.x.i, b.y.i, b.z.i, b.w.i)

    fun and(b: Number, res: Vec4ui) = and(res, this, b.i, b.i, b.i, b.i)
    fun and(b: Vec4t<out Number>, res: Vec4ui) = and(res, this, b.x.i, b.y.i, b.z.i, b.w.i)

    fun and(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4ui = Vec4ui()) = and(res, this, bX.i, bY.i, bZ.i, bW.i)

    fun andAssign(bX: Number, bY: Number, bZ: Number, bW: Number) = and(this, this, bX.i, bY.i, bZ.i, bW.i)


    infix fun or(b: Number) = or(Vec4ui(), this, b.i, b.i, b.i, b.i)
    infix fun or(b: Vec4t<out Number>) = or(Vec4ui(), this, b.x.i, b.y.i, b.z.i, b.w.i)

    infix fun orAssign(b: Number) = or(this, this, b.i, b.i, b.i, b.i)
    infix fun orAssign(b: Vec4t<out Number>) = or(this, this, b.x.i, b.y.i, b.z.i, b.w.i)

    fun or(b: Number, res: Vec4ui) = or(res, this, b.i, b.i, b.i, b.i)
    fun or(b: Vec4t<out Number>, res: Vec4ui) = or(res, this, b.x.i, b.y.i, b.z.i, b.w.i)

    fun or(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4ui = Vec4ui()) = or(res, this, bX.i, bY.i, bZ.i, bW.i)

    fun orAssign(bX: Number, bY: Number, bZ: Number, bW: Number) = or(this, this, bX.i, bY.i, bZ.i, bW.i)


    infix fun xor(b: Number) = xor(Vec4ui(), this, b.i, b.i, b.i, b.i)
    infix fun xor(b: Vec4t<out Number>) = xor(Vec4ui(), this, b.x.i, b.y.i, b.z.i, b.w.i)

    infix fun xorAssign(b: Number) = xor(this, this, b.i, b.i, b.i, b.i)
    infix fun xorAssign(b: Vec4t<out Number>) = xor(this, this, b.x.i, b.y.i, b.z.i, b.w.i)

    fun xor(b: Number, res: Vec4ui) = xor(res, this, b.i, b.i, b.i, b.i)
    fun xor(b: Vec4t<out Number>, res: Vec4ui) = xor(res, this, b.x.i, b.y.i, b.z.i, b.w.i)

    fun xor(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4ui = Vec4ui()) = xor(res, this, bX.i, bY.i, bZ.i, bW.i)

    fun xorAssign(bX: Number, bY: Number, bZ: Number, bW: Number) = xor(this, this, bX.i, bY.i, bZ.i, bW.i)


    infix fun shl(b: Number) = shl(Vec4ui(), this, b.i, b.i, b.i, b.i)
    infix fun shl(b: Vec4t<out Number>) = shl(Vec4ui(), this, b.x.i, b.y.i, b.z.i, b.w.i)

    infix fun shlAssign(b: Number) = shl(this, this, b.i, b.i, b.i, b.i)
    infix fun shlAssign(b: Vec4t<out Number>) = shl(this, this, b.x.i, b.y.i, b.z.i, b.w.i)

    fun shl(b: Number, res: Vec4ui) = shl(res, this, b.i, b.i, b.i, b.i)
    fun shl(b: Vec4t<out Number>, res: Vec4ui) = shl(res, this, b.x.i, b.y.i, b.z.i, b.w.i)

    fun shl(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4ui = Vec4ui()) = shl(res, this, bX.i, bY.i, bZ.i, bW.i)

    fun shlAssign(bX: Number, bY: Number, bZ: Number, bW: Number) = shl(this, this, bX.i, bY.i, bZ.i, bW.i)


    infix fun shr(b: Number) = shr(Vec4ui(), this, b.i, b.i, b.i, b.i)
    infix fun shr(b: Vec4t<out Number>) = shr(Vec4ui(), this, b.x.i, b.y.i, b.z.i, b.w.i)

    infix fun shrAssign(b: Number) = shr(this, this, b.i, b.i, b.i, b.i)
    infix fun shrAssign(b: Vec4t<out Number>) = shr(this, this, b.x.i, b.y.i, b.z.i, b.w.i)

    fun shr(b: Number, res: Vec4ui) = shr(res, this, b.i, b.i, b.i, b.i)
    fun shr(b: Vec4t<out Number>, res: Vec4ui) = shr(res, this, b.x.i, b.y.i, b.z.i, b.w.i)

    fun shr(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4ui = Vec4ui()) = shr(res, this, bX.i, bY.i, bZ.i, bW.i)

    fun shrAssign(bX: Number, bY: Number, bZ: Number, bW: Number) = shr(this, this, bX.i, bY.i, bZ.i, bW.i)


    override fun equals(other: Any?) = other is Vec4ui && this[0] == other[0] && this[1] == other[1] && this[2] == other[2] && this[3] == other[3]
    override fun hashCode() = 31 * (31 * (31 * x.v.hashCode() + y.v.hashCode()) + z.v.hashCode()) + w.v.hashCode()
}