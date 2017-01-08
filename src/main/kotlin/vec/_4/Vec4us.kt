package vec._4

import BYTES
import Ushort
import getShort
import getUshort
import i
import s
import us
import vec.Vec2t
import vec.Vec3t
import vec.Vec4t
import vec._4.operators.vec4us_operators
import vec.bool.Vec2bool
import vec.bool.Vec3bool
import vec.bool.Vec4bool
import java.nio.*

/**
 * Created by elect on 09/10/16.
 */

data class Vec4us(override var x: Ushort, override var y: Ushort, override var z: Ushort, override var w: Ushort) : Vec4t<Ushort>() {

    // -- Explicit basic, conversion other and conversion vector constructors --

    constructor() : this(0)

    constructor(v: Vec2t<out Number>) : this(v.x, v.y, 0, 1)
    constructor(v: Vec3t<out Number>) : this(v.x, v.y, v.z, 1)
    constructor(v: Vec4t<out Number>) : this(v.x, v.y, v.z, v.w)

    constructor(v: Vec2bool) : this(v.x.us, v.y.us, 0, 1)
    constructor(v: Vec3bool) : this(v.x.us, v.y.us, v.z.us, 1)
    constructor(v: Vec4bool) : this(v.x.us, v.y.us, v.z.us, v.w.us)

    constructor(bytes: ByteArray, index: Int = 0, oneByteOneUshort: Boolean = true, bigEndianess: Boolean = true) : this(
            if (oneByteOneUshort) bytes[index].us else bytes.getUshort(index, bigEndianess),
            if (oneByteOneUshort) bytes[index + 1].us else bytes.getUshort(index + Ushort.BYTES, bigEndianess),
            if (oneByteOneUshort) bytes[index + 2].us else bytes.getUshort(index + Ushort.BYTES * 2, bigEndianess),
            if (oneByteOneUshort) bytes[index + 3].us else bytes.getUshort(index + Ushort.BYTES * 3, bigEndianess))

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

    constructor(list: List<Any>, index: Int = 0) : this() {
        Set(list, index)
    }

    constructor(bytes: ByteBuffer, index: Int = bytes.position(), oneByteOneUshort: Boolean = true) : this(
            if (oneByteOneUshort) bytes[index].us else bytes.getShort(index).us,
            if (oneByteOneUshort) bytes[index + 1].us else bytes.getShort(index + Ushort.BYTES).us,
            if (oneByteOneUshort) bytes[index + 2].us else bytes.getShort(index + Ushort.BYTES * 2).us,
            if (oneByteOneUshort) bytes[index + 3].us else bytes.getShort(index + Ushort.BYTES * 3).us)

    constructor(chars: CharBuffer, index: Int = chars.position()) : this(chars[index].us, chars[index + 1].us, chars[index + 2].us, chars[index + 3].us)
    constructor(shorts: ShortBuffer, index: Int = shorts.position()) : this(shorts[index], shorts[index + 1], shorts[index + 2], shorts[index + 3])
    constructor(ints: IntBuffer, index: Int = ints.position()) : this(ints[index], ints[index + 1], ints[index + 2], ints[index + 3])
    constructor(longs: LongBuffer, index: Int = longs.position()) : this(longs[index], longs[index + 1], longs[index + 2], longs[index + 3])
    constructor(floats: FloatBuffer, index: Int = floats.position()) : this(floats[index], floats[index + 1], floats[index + 2], floats[index + 3])
    constructor(doubles: DoubleBuffer, index: Int = doubles.position()) : this(doubles[index], doubles[index + 1], doubles[index + 2], doubles[index + 3])

    constructor(s: Number) : this(s, s, s, s)
    constructor(x: Number, y: Number, z: Number, w: Number) : this(x.us, y.us, z.us, w.us)


    fun set(bytes: ByteArray, index: Int = 0, oneByteOneShort: Boolean = true, bigEndianess: Boolean = true) {
        x.v = if (oneByteOneShort) bytes[index].s else bytes.getShort(index, bigEndianess)
        y.v = if (oneByteOneShort) bytes[index + 1].s else bytes.getShort(index + Ushort.BYTES, bigEndianess)
        z.v = if (oneByteOneShort) bytes[index + 2].s else bytes.getShort(index + Ushort.BYTES * 2, bigEndianess)
        w.v = if (oneByteOneShort) bytes[index + 3].s else bytes.getShort(index + Ushort.BYTES * 3, bigEndianess)
    }

    fun set(bytes: ByteBuffer, index: Int = bytes.position(), oneByteOneShort: Boolean = true) {
        x.v = if (oneByteOneShort) bytes[index].s else bytes.getShort(index)
        y.v = if (oneByteOneShort) bytes[index + 1].s else bytes.getShort(index + Ushort.BYTES)
        z.v = if (oneByteOneShort) bytes[index + 2].s else bytes.getShort(index + Ushort.BYTES * 2)
        w.v = if (oneByteOneShort) bytes[index + 3].s else bytes.getShort(index + Ushort.BYTES * 3)
    }


    override fun Set(x: Number, y: Number, z: Number, w: Number): Vec4us {
        this.x = x.us
        this.y = y.us
        this.z = z.us
        this.w = w.us
        return this
    }


    // -- Component accesses --

    operator fun get(i: Int) = when (i) {
        0 -> x
        1 -> y
        2 -> z
        3 -> w
        else -> throw ArrayIndexOutOfBoundsException()
    }

    operator fun set(i: Int, s: Number) = when (i) {
        0 -> x = s.us
        1 -> y = s.us
        2 -> z = s.us
        3 -> w = s.us
        else -> throw ArrayIndexOutOfBoundsException()
    }


    companion object : vec4us_operators


    // -- Unary arithmetic operators --

    operator fun unaryPlus() = this

    // no unaryMinus operator, only signed

    // -- Increment and decrement operators --

    operator fun inc(res: Vec4us = Vec4us()) = add(res, this, 1, 1, 1, 1)
    fun inc_() = add(this, this, 1, 1, 1, 1)


    operator fun dec(res: Vec4us = Vec4us()) = sub(res, this, 1, 1, 1, 1)
    fun dec_() = sub(this, this, 1, 1, 1, 1)


    // -- Specific binary arithmetic operators --

    operator fun plus(b: Ushort) = add(Vec4us(), this, b, b, b, b)
    operator fun plus(b: Short) = add(Vec4us(), this, b, b, b, b)
    operator fun plus(b: Int) = add(Vec4us(), this, b, b, b, b)
    operator fun plus(b: Vec4us) = add(Vec4us(), this, b.x, b.y, b.z, b.w)

    fun add(bX: Ushort, bY: Ushort, bZ: Ushort, bW: Ushort, res: Vec4us = Vec4us()) = add(res, this, bX, bY, bZ, bW)
    fun add(bX: Short, bY: Short, bZ: Short, bW: Short, res: Vec4us = Vec4us()) = add(res, this, bX, bY, bZ, bW)
    fun add(bX: Int, bY: Int, bZ: Int, bW: Int, res: Vec4us = Vec4us()) = add(res, this, bX, bY, bZ, bW)
    fun add(b: Ushort, res: Vec4us = Vec4us()) = add(res, this, b, b, b, b)
    fun add(b: Short, res: Vec4us = Vec4us()) = add(res, this, b, b, b, b)
    fun add(b: Int, res: Vec4us = Vec4us()) = add(res, this, b, b, b, b)
    fun add(b: Vec4us, res: Vec4us = Vec4us()) = add(res, this, b.x, b.y, b.z, b.w)

    fun add_(bX: Ushort, bY: Ushort, bZ: Ushort, bW: Ushort) = add(this, this, bX, bY, bZ, bW)
    fun add_(bX: Short, bY: Short, bZ: Short, bW: Short) = add(this, this, bX, bY, bZ, bW)
    fun add_(bX: Int, bY: Int, bZ: Int, bW: Int) = add(this, this, bX, bY, bZ, bW)
    infix fun add_(b: Ushort) = add(this, this, b, b, b, b)
    infix fun add_(b: Short) = add(this, this, b, b, b, b)
    infix fun add_(b: Int) = add(this, this, b, b, b, b)
    infix fun add_(b: Vec4us) = add(this, this, b.x, b.y, b.z, b.w)


    operator fun minus(b: Ushort) = sub(Vec4us(), this, b, b, b, b)
    operator fun minus(b: Short) = sub(Vec4us(), this, b, b, b, b)
    operator fun minus(b: Int) = sub(Vec4us(), this, b, b, b, b)
    operator fun minus(b: Vec4us) = sub(Vec4us(), this, b.x, b.y, b.z, b.w)

    fun sub(bX: Ushort, bY: Ushort, bZ: Ushort, bW: Ushort, res: Vec4us = Vec4us()) = sub(res, this, bX, bY, bZ, bW)
    fun sub(bX: Short, bY: Short, bZ: Short, bW: Short, res: Vec4us = Vec4us()) = sub(res, this, bX, bY, bZ, bW)
    fun sub(bX: Int, bY: Int, bZ: Int, bW: Int, res: Vec4us = Vec4us()) = sub(res, this, bX, bY, bZ, bW)
    fun sub(b: Ushort, res: Vec4us = Vec4us()) = sub(res, this, b, b, b, b)
    fun sub(b: Short, res: Vec4us = Vec4us()) = sub(res, this, b, b, b, b)
    fun sub(b: Int, res: Vec4us = Vec4us()) = sub(res, this, b, b, b, b)
    fun sub(b: Vec4us, res: Vec4us = Vec4us()) = sub(res, this, b.x, b.y, b.z, b.w)

    fun sub_(bX: Ushort, bY: Ushort, bZ: Ushort, bW: Ushort) = sub(this, this, bX, bY, bZ, bW)
    fun sub_(bX: Short, bY: Short, bZ: Short, bW: Short) = sub(this, this, bX, bY, bZ, bW)
    fun sub_(bX: Int, bY: Int, bZ: Int, bW: Int) = sub(this, this, bX, bY, bZ, bW)
    infix fun sub_(b: Ushort) = sub(this, this, b, b, b, b)
    infix fun sub_(b: Short) = sub(this, this, b, b, b, b)
    infix fun sub_(b: Int) = sub(this, this, b, b, b, b)
    infix fun sub_(b: Vec4us) = sub(this, this, b.x, b.y, b.z, b.w)


    operator fun times(b: Ushort) = mul(Vec4us(), this, b, b, b, b)
    operator fun times(b: Short) = mul(Vec4us(), this, b, b, b, b)
    operator fun times(b: Int) = mul(Vec4us(), this, b, b, b, b)
    operator fun times(b: Vec4us) = mul(Vec4us(), this, b.x, b.y, b.z, b.w)

    fun mul(bX: Ushort, bY: Ushort, bZ: Ushort, bW: Ushort, res: Vec4us = Vec4us()) = mul(res, this, bX, bY, bZ, bW)
    fun mul(bX: Short, bY: Short, bZ: Short, bW: Short, res: Vec4us = Vec4us()) = mul(res, this, bX, bY, bZ, bW)
    fun mul(bX: Int, bY: Int, bZ: Int, bW: Int, res: Vec4us = Vec4us()) = mul(res, this, bX, bY, bZ, bW)
    fun mul(b: Ushort, res: Vec4us = Vec4us()) = mul(res, this, b, b, b, b)
    fun mul(b: Short, res: Vec4us = Vec4us()) = mul(res, this, b, b, b, b)
    fun mul(b: Int, res: Vec4us = Vec4us()) = mul(res, this, b, b, b, b)
    fun mul(b: Vec4us, res: Vec4us = Vec4us()) = mul(res, this, b.x, b.y, b.z, b.w)

    fun mul_(bX: Ushort, bY: Ushort, bZ: Ushort, bW: Ushort) = mul(this, this, bX, bY, bZ, bW)
    fun mul_(bX: Short, bY: Short, bZ: Short, bW: Short) = mul(this, this, bX, bY, bZ, bW)
    fun mul_(bX: Int, bY: Int, bZ: Int, bW: Int) = mul(this, this, bX, bY, bZ, bW)
    infix fun mul_(b: Ushort) = mul(this, this, b, b, b, b)
    infix fun mul_(b: Short) = mul(this, this, b, b, b, b)
    infix fun mul_(b: Int) = mul(this, this, b, b, b, b)
    infix fun mul_(b: Vec4us) = mul(this, this, b.x, b.y, b.z, b.w)


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

    fun div_(bX: Ushort, bY: Ushort, bZ: Ushort, bW: Ushort) = div(this, this, bX, bY, bZ, bW)
    fun div_(bX: Short, bY: Short, bZ: Short, bW: Short) = div(this, this, bX, bY, bZ, bW)
    fun div_(bX: Int, bY: Int, bZ: Int, bW: Int) = div(this, this, bX, bY, bZ, bW)
    infix fun div_(b: Ushort) = div(this, this, b, b, b, b)
    infix fun div_(b: Short) = div(this, this, b, b, b, b)
    infix fun div_(b: Int) = div(this, this, b, b, b, b)
    infix fun div_(b: Vec4us) = div(this, this, b.x, b.y, b.z, b.w)


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

    fun rem_(bX: Ushort, bY: Ushort, bZ: Ushort, bW: Ushort) = rem(this, this, bX, bY, bZ, bW)
    fun rem_(bX: Short, bY: Short, bZ: Short, bW: Short) = rem(this, this, bX, bY, bZ, bW)
    fun rem_(bX: Int, bY: Int, bZ: Int, bW: Int) = rem(this, this, bX, bY, bZ, bW)
    infix fun rem_(b: Ushort) = rem(this, this, b, b, b, b)
    infix fun rem_(b: Short) = rem(this, this, b, b, b, b)
    infix fun rem_(b: Int) = rem(this, this, b, b, b, b)
    infix fun rem_(b: Vec4us) = rem(this, this, b.x, b.y, b.z, b.w)


    // -- Generic binary arithmetic operators --

    operator fun plus(b: Number) = add(Vec4us(), this, b.i, b.i, b.i, b.i)
    operator fun plus(b: Vec4t<Number>) = add(Vec4us(), this, b.x.i, b.y.i, b.z.i, b.w.i)

    fun add(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4us = Vec4us()) = add(res, this, bX.i, bY.i, bZ.i, bW.i)
    fun add(b: Number, res: Vec4us = Vec4us()) = add(res, this, b.i, b.i, b.i, b.i)
    fun add(b: Vec4t<Number>, res: Vec4us = Vec4us()) = add(res, this, b.x.i, b.y.i, b.z.i, b.w.i)

    fun add_(bX: Number, bY: Number, bZ: Number, bW: Number) = add(this, this, bX.i, bY.i, bZ.i, bW.i)
    infix fun add_(b: Number) = add(this, this, b.i, b.i, b.i, b.i)
    infix fun add_(b: Vec4t<Number>) = add(this, this, b.x.i, b.y.i, b.z.i, b.w.i)


    operator fun minus(b: Number) = sub(Vec4us(), this, b.i, b.i, b.i, b.i)
    operator fun minus(b: Vec4t<Number>) = sub(Vec4us(), this, b.x.i, b.y.i, b.z.i, b.w.i)

    fun sub(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4us = Vec4us()) = sub(res, this, bX.i, bY.i, bZ.i, bW.i)
    fun sub(b: Number, res: Vec4us = Vec4us()) = sub(res, this, b.i, b.i, b.i, b.i)
    fun sub(b: Vec4t<Number>, res: Vec4us = Vec4us()) = sub(res, this, b.x.i, b.y.i, b.z.i, b.w.i)

    fun sub_(bX: Number, bY: Number, bZ: Number, bW: Number) = sub(this, this, bX.i, bY.i, bZ.i, bW.i)
    infix fun sub_(b: Number) = sub(this, this, b.i, b.i, b.i, b.i)
    infix fun sub_(b: Vec4t<Number>) = sub(this, this, b.x.i, b.y.i, b.z.i, b.w.i)


    operator fun times(b: Number) = mul(Vec4us(), this, b.i, b.i, b.i, b.i)
    operator fun times(b: Vec4t<Number>) = mul(Vec4us(), this, b.x.i, b.y.i, b.z.i, b.w.i)

    fun mul(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4us = Vec4us()) = mul(res, this, bX.i, bY.i, bZ.i, bW.i)
    fun mul(b: Number, res: Vec4us = Vec4us()) = mul(res, this, b.i, b.i, b.i, b.i)
    fun mul(b: Vec4t<Number>, res: Vec4us = Vec4us()) = mul(res, this, b.x.i, b.y.i, b.z.i, b.w.i)

    fun mul_(bX: Number, bY: Number, bZ: Number, bW: Number) = mul(this, this, bX.i, bY.i, bZ.i, bW.i)
    infix fun mul_(b: Number) = mul(this, this, b.i, b.i, b.i, b.i)
    infix fun mul_(b: Vec4t<Number>) = mul(this, this, b.x.i, b.y.i, b.z.i, b.w.i)


    operator fun div(b: Number) = div(Vec4us(), this, b.i, b.i, b.i, b.i)
    operator fun div(b: Vec4t<Number>) = div(Vec4us(), this, b.x.i, b.y.i, b.z.i, b.w.i)

    fun div(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4us = Vec4us()) = div(res, this, bX.i, bY.i, bZ.i, bW.i)
    fun div(b: Number, res: Vec4us = Vec4us()) = div(res, this, b.i, b.i, b.i, b.i)
    fun div(b: Vec4t<Number>, res: Vec4us = Vec4us()) = div(res, this, b.x.i, b.y.i, b.z.i, b.w.i)

    fun div_(bX: Number, bY: Number, bZ: Number, bW: Number) = div(this, this, bX.i, bY.i, bZ.i, bW.i)
    infix fun div_(b: Number) = div(this, this, b.i, b.i, b.i, b.i)
    infix fun div_(b: Vec4t<Number>) = div(this, this, b.x.i, b.y.i, b.z.i, b.w.i)


    operator fun rem(b: Number) = rem(Vec4us(), this, b.i, b.i, b.i, b.i)
    operator fun rem(b: Vec4t<Number>) = rem(Vec4us(), this, b.x.i, b.y.i, b.z.i, b.w.i)

    fun rem(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4us = Vec4us()) = rem(res, this, bX.i, bY.i, bZ.i, bW.i)
    fun rem(b: Number, res: Vec4us = Vec4us()) = rem(res, this, b.i, b.i, b.i, b.i)
    fun rem(b: Vec4t<Number>, res: Vec4us = Vec4us()) = rem(res, this, b.x.i, b.y.i, b.z.i, b.w.i)

    fun rem_(bX: Number, bY: Number, bZ: Number, bW: Number) = rem(this, this, bX.i, bY.i, bZ.i, bW.i)
    infix fun rem_(b: Number) = rem(this, this, b.i, b.i, b.i, b.i)
    infix fun rem_(b: Vec4t<Number>) = rem(this, this, b.x.i, b.y.i, b.z.i, b.w.i)


    // -- Specific bitwise operators --

    infix fun and(b: Ushort) = and(Vec4us(), this, b, b, b, b)
    infix fun and(b: Short) = and(Vec4us(), this, b, b, b, b)
    infix fun and(b: Int) = and(Vec4us(), this, b, b, b, b)
    fun and(bX: Ushort, bY: Ushort, bZ: Ushort, bW: Ushort) = and(Vec4us(), this, bX, bY, bZ, bW)
    fun and(bX: Short, bY: Short, bZ: Short, bW: Short) = and(Vec4us(), this, bX, bY, bZ, bW)
    fun and(bX: Int, bY: Int, bZ: Int, bW: Int) = and(Vec4us(), this, bX, bY, bZ, bW)
    fun and(b: Vec4us) = and(Vec4us(), this, b.x, b.y, b.z, b.w)

    infix fun and_(b: Ushort) = and(this, this, b, b, b, b)
    infix fun and_(b: Short) = and(this, this, b, b, b, b)
    infix fun and_(b: Int) = and(this, this, b, b, b, b)
    fun and_(bX: Ushort, bY: Ushort, bZ: Ushort, bW: Ushort) = and(this, this, bX, bY, bZ, bW)
    fun and_(bX: Short, bY: Short, bZ: Short, bW: Short) = and(this, this, bX, bY, bZ, bW)
    fun and_(bX: Int, bY: Int, bZ: Int, bW: Int) = and(this, this, bX, bY, bZ, bW)
    infix fun and_(b: Vec4us) = and(this, this, b.x, b.y, b.z, b.w)

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

    infix fun or_(b: Ushort) = or(this, this, b, b, b, b)
    infix fun or_(b: Short) = or(this, this, b, b, b, b)
    infix fun or_(b: Int) = or(this, this, b, b, b, b)
    fun or_(bX: Ushort, bY: Ushort, bZ: Ushort, bW: Ushort) = or(this, this, bX, bY, bZ, bW)
    fun or_(bX: Short, bY: Short, bZ: Short, bW: Short) = or(this, this, bX, bY, bZ, bW)
    fun or_(bX: Int, bY: Int, bZ: Int, bW: Int) = or(this, this, bX, bY, bZ, bW)
    infix fun or_(b: Vec4us) = or(this, this, b.x, b.y, b.z, b.w)

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

    infix fun xor_(b: Ushort) = xor(this, this, b, b, b, b)
    infix fun xor_(b: Short) = xor(this, this, b, b, b, b)
    infix fun xor_(b: Int) = xor(this, this, b, b, b, b)
    fun xor_(bX: Ushort, bY: Ushort, bZ: Ushort, bW: Ushort) = xor(this, this, bX, bY, bZ, bW)
    fun xor_(bX: Short, bY: Short, bZ: Short, bW: Short) = xor(this, this, bX, bY, bZ, bW)
    fun xor_(bX: Int, bY: Int, bZ: Int, bW: Int) = xor(this, this, bX, bY, bZ, bW)
    infix fun xor_(b: Vec4us) = xor(this, this, b.x, b.y, b.z, b.w)

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

    infix fun shl_(b: Ushort) = shl(this, this, b, b, b, b)
    infix fun shl_(b: Short) = shl(this, this, b, b, b, b)
    infix fun shl_(b: Int) = shl(this, this, b, b, b, b)
    fun shl_(bX: Ushort, bY: Ushort, bZ: Ushort, bW: Ushort) = shl(this, this, bX, bY, bZ, bW)
    fun shl_(bX: Short, bY: Short, bZ: Short, bW: Short) = shl(this, this, bX, bY, bZ, bW)
    fun shl_(bX: Int, bY: Int, bZ: Int, bW: Int) = shl(this, this, bX, bY, bZ, bW)
    infix fun shl_(b: Vec4us) = shl(this, this, b.x, b.y, b.z, b.w)

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

    infix fun shr_(b: Ushort) = shr(this, this, b, b, b, b)
    infix fun shr_(b: Short) = shr(this, this, b, b, b, b)
    infix fun shr_(b: Int) = shr(this, this, b, b, b, b)
    fun shr_(bX: Ushort, bY: Ushort, bZ: Ushort, bW: Ushort) = shr(this, this, bX, bY, bZ, bW)
    fun shr_(bX: Short, bY: Short, bZ: Short, bW: Short) = shr(this, this, bX, bY, bZ, bW)
    fun shr_(bX: Int, bY: Int, bZ: Int, bW: Int) = shr(this, this, bX, bY, bZ, bW)
    infix fun shr_(b: Vec4us) = shr(this, this, b.x, b.y, b.z, b.w)

    fun shr(b: Ushort, res: Vec4us) = shr(res, this, b, b, b, b)
    fun shr(b: Short, res: Vec4us) = shr(res, this, b, b, b, b)
    fun shr(b: Int, res: Vec4us) = shr(res, this, b, b, b, b)
    fun shr(bX: Ushort, bY: Ushort, bZ: Ushort, bW: Ushort, res: Vec4us) = shr(res, this, bX, bY, bZ, bW)
    fun shr(bX: Short, bY: Short, bZ: Short, bW: Short, res: Vec4us) = shr(res, this, bX, bY, bZ, bW)
    fun shr(bX: Int, bY: Int, bZ: Int, bW: Int, res: Vec4us) = shr(res, this, bX, bY, bZ, bW)
    fun shr(b: Vec4us, res: Vec4us) = shr(res, this, b.x, b.y, b.z, b.w)


    fun inv(res: Vec4us = Vec4us()) = inv(res, this)
    fun inv_() = inv(this, this)


    // -- Generic bitwise operators --

    infix fun and(b: Number) = and(Vec4us(), this, b.i, b.i, b.i, b.i)
    fun and(bX: Number, bY: Number, bZ: Number, bW: Number) = and(Vec4us(), this, bX.i, bY.i, bZ.i, bW.i)
    fun and(b: Vec4t<Number>) = and(Vec4us(), this, b.x.i, b.y.i, b.z.i, b.w.i)

    infix fun and_(b: Number) = and(this, this, b.i, b.i, b.i, b.i)
    fun and_(bX: Number, bY: Number, bZ: Number, bW: Number) = and(this, this, bX.i, bY.i, bZ.i, bW.i)
    infix fun and_(b: Vec4t<Number>) = and(this, this, b.x.i, b.y.i, b.z.i, b.w.i)

    fun and(b: Number, res: Vec4us) = and(res, this, b.i, b.i, b.i, b.i)
    fun and(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4us) = and(res, this, bX.i, bY.i, bZ.i, bW.i)
    fun and(b: Vec4t<Number>, res: Vec4us) = and(res, this, b.x.i, b.y.i, b.z.i, b.w.i)


    infix fun or(b: Number) = or(Vec4us(), this, b.i, b.i, b.i, b.i)
    fun or(bX: Number, bY: Number, bZ: Number, bW: Number) = or(Vec4us(), this, bX.i, bY.i, bZ.i, bW.i)
    fun or(b: Vec4t<Number>) = or(Vec4us(), this, b.x.i, b.y.i, b.z.i, b.w.i)

    infix fun or_(b: Number) = or(this, this, b.i, b.i, b.i, b.i)
    fun or_(bX: Number, bY: Number, bZ: Number, bW: Number) = or(this, this, bX.i, bY.i, bZ.i, bW.i)
    infix fun or_(b: Vec4t<Number>) = or(this, this, b.x.i, b.y.i, b.z.i, b.w.i)

    fun or(b: Number, res: Vec4us) = or(res, this, b.i, b.i, b.i, b.i)
    fun or(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4us) = or(res, this, bX.i, bY.i, bZ.i, bW.i)
    fun or(b: Vec4t<Number>, res: Vec4us) = or(res, this, b.x.i, b.y.i, b.z.i, b.w.i)


    infix fun xor(b: Number) = xor(Vec4us(), this, b.i, b.i, b.i, b.i)
    fun xor(bX: Number, bY: Number, bZ: Number, bW: Number) = xor(Vec4us(), this, bX.i, bY.i, bZ.i, bW.i)
    fun xor(b: Vec4t<Number>) = xor(Vec4us(), this, b.x.i, b.y.i, b.z.i, b.w.i)

    infix fun xor_(b: Number) = xor(this, this, b.i, b.i, b.i, b.i)
    fun xor_(bX: Number, bY: Number, bZ: Number, bW: Number) = xor(this, this, bX.i, bY.i, bZ.i, bW.i)
    infix fun xor_(b: Vec4t<Number>) = xor(this, this, b.x.i, b.y.i, b.z.i, b.w.i)

    fun xor(b: Number, res: Vec4us) = xor(res, this, b.i, b.i, b.i, b.i)
    fun xor(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4us) = xor(res, this, bX.i, bY.i, bZ.i, bW.i)
    fun xor(b: Vec4t<Number>, res: Vec4us) = xor(res, this, b.x.i, b.y.i, b.z.i, b.w.i)


    infix fun shl(b: Number) = shl(Vec4us(), this, b.i, b.i, b.i, b.i)
    fun shl(bX: Number, bY: Number, bZ: Number, bW: Number) = shl(Vec4us(), this, bX.i, bY.i, bZ.i, bW.i)
    fun shl(b: Vec4t<Number>) = shl(Vec4us(), this, b.x.i, b.y.i, b.z.i, b.w.i)

    infix fun shl_(b: Number) = shl(this, this, b.i, b.i, b.i, b.i)
    fun shl_(bX: Number, bY: Number, bZ: Number, bW: Number) = shl(this, this, bX.i, bY.i, bZ.i, bW.i)
    infix fun shl_(b: Vec4t<Number>) = shl(this, this, b.x.i, b.y.i, b.z.i, b.w.i)

    fun shl(b: Number, res: Vec4us) = shl(res, this, b.i, b.i, b.i, b.i)
    fun shl(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4us) = shl(res, this, bX.i, bY.i, bZ.i, bW.i)
    fun shl(b: Vec4t<Number>, res: Vec4us) = shl(res, this, b.x.i, b.y.i, b.z.i, b.w.i)


    infix fun shr(b: Number) = shr(Vec4us(), this, b.i, b.i, b.i, b.i)
    fun shr(bX: Number, bY: Number, bZ: Number, bW: Number) = shr(Vec4us(), this, bX.i, bY.i, bZ.i, bW.i)
    fun shr(b: Vec4t<Number>) = shr(Vec4us(), this, b.x.i, b.y.i, b.z.i, b.w.i)

    infix fun shr_(b: Number) = shr(this, this, b.i, b.i, b.i, b.i)
    fun shr_(bX: Number, bY: Number, bZ: Number, bW: Number) = shr(this, this, bX.i, bY.i, bZ.i, bW.i)
    infix fun shr_(b: Vec4t<Number>) = shr(this, this, b.x.i, b.y.i, b.z.i, b.w.i)

    fun shr(b: Number, res: Vec4us) = shr(res, this, b.i, b.i, b.i, b.i)
    fun shr(bX: Number, bY: Number, bZ: Number, bW: Number, res: Vec4us) = shr(res, this, bX.i, bY.i, bZ.i, bW.i)
    fun shr(b: Vec4t<Number>, res: Vec4us) = shr(res, this, b.x.i, b.y.i, b.z.i, b.w.i)
}