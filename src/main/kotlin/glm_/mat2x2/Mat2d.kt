package glm_.mat2x2

import glm_.*
import glm_.mat2x2.operators.mat2x2d_operators
import glm_.mat2x3.Mat2x3t
import glm_.mat2x4.Mat2x4t
import glm_.mat3x2.Mat3x2d
import glm_.mat3x2.Mat3x2t
import glm_.mat3x3.Mat3
import glm_.mat3x3.Mat3d
import glm_.mat4x2.Mat4x2d
import glm_.mat4x2.Mat4x2t
import glm_.mat4x4.Mat4
import glm_.mat4x4.Mat4d
import glm_.vec2.Vec2d
import glm_.vec2.Vec2t
import glm_.vec3.Vec3d
import glm_.vec4.Vec4d
import kool.Ptr
import kool.bufferBig
import kool.doubleBufferBig
import kool.pos
import org.lwjgl.system.MemoryStack
import org.lwjgl.system.MemoryUtil.memGetDouble
import java.io.PrintStream
import java.nio.ByteBuffer
import java.nio.DoubleBuffer
import java.util.*

/**
 * Created by GBarbieri on 10.11.2016.
 */
class Mat2d(dummy: Int, var array: DoubleArray) : Mat2x2t<Double>() {

    // -- Constructors --

    constructor() : this(
            1, 0,
            0, 1)

    constructor(scalar: Number) : this(
            scalar, 0,
            0, scalar)

    constructor(x0: Number, y0: Number,
                x1: Number, y1: Number) : this(0, doubleArrayOf(
            x0.d, y0.d,
            x1.d, y1.d))

    constructor(v0: Vec2t<out Number>, v1: Vec2t<out Number>) : this(
            v0.x, v0.y,
            v1.x, v1.y)

    constructor(block: (Int) -> Number) : this(
            block(0).d, block(1).d,
            block(2).d, block(3).d)

    constructor(block: (Int, Int) -> Number) : this(
            block(0, 0).f, block(0, 1).f,
            block(1, 0).f, block(1, 1).f)

    constructor(list: Iterable<*>, index: Int = 0) : this(
            list.elementAt(index)!!.toDouble, list.elementAt(index + 1)!!.toDouble,
            list.elementAt(index + 2)!!.toDouble, list.elementAt(index + 3)!!.toDouble)

    // -- Matrix conversions --

    constructor(mat2: Mat2) : this(0, DoubleArray(length) { mat2.array[it].d })
    constructor(mat2: Mat2d) : this(0, mat2.array.clone())

    constructor(mat3: Mat3) : this(
            mat3[0, 0], mat3[0, 1],
            mat3[1, 0], mat3[1, 1])

    constructor(mat4: Mat4) : this(
            mat4[0, 0], mat4[0, 1],
            mat4[1, 0], mat4[1, 1])

    constructor(mat2x3: Mat2x3t<*>) : this(
            mat2x3[0, 0], mat2x3[0, 1],
            mat2x3[1, 0], mat2x3[1, 1])

    constructor(mat3x2: Mat3x2t<*>) : this(
            mat3x2[0, 0], mat3x2[0, 1],
            mat3x2[1, 0], mat3x2[1, 1])

    constructor(mat2x4: Mat2x4t<*>) : this(
            mat2x4[0, 0], mat2x4[0, 1],
            mat2x4[1, 0], mat2x4[1, 1])

    constructor(mat4x2: Mat4x2t<*>) : this(
            mat4x2[0, 0], mat4x2[0, 1],
            mat4x2[1, 0], mat4x2[1, 1])

    // to
//    fun to(mat2x2: Mat2x2t<*>) {
//        value = mutableListOf(
//                Vec2d(mat2x2.value[0]),
//                Vec2d(mat2x2.value[1]))
//    }
//
//    fun to(scalar: Number) {
//        value = mutableListOf(
//                Vec2d(scalar.d, 0),
//                Vec2d(0, scalar.d))
//    }
//
//    fun to(x0: Number, x1: Number, y0: Number, y1: Number) {
//        value = mutableListOf(
//                Vec2d(x0.d, y0.d),
//                Vec2d(x1.d, y1.d))
//    }
//
//    fun to(v0: Vec2t<*>, v1: Vec2t<*>) {
//        value = mutableListOf(
//                Vec2d(v0),
//                Vec2d(v1))
//    }

    // -- Accesses --

    override operator fun get(index: Int) = Vec2d(index * 2, array)
    override operator fun get(column: Int, row: Int) = array[column * 2 + row]

    override operator fun set(column: Int, row: Int, value: Double) = array.set(column * 2 + row, value)
    override operator fun set(index: Int, value: Vec2t<out Number>) {
        array[index * 2] = value.x.d
        array[index * 2 + 1] = value.y.d
    }

    operator fun set(i: Int, v: Vec2d) {
        v.to(array, i * 2)
    }

    // -- Matrix functions --

    val det get() = glm.determinant(this)

    fun inverse(res: Mat2d = Mat2d()) = glm.inverse(res, this)
    fun inverseAssign() = glm.inverse(this, this)

    fun transpose(res: Mat2d = Mat2d()) = glm.transpose(res, this)
    fun transposeAssign() = glm.transpose(this, this)


    infix operator fun invoke(s: Double) = invoke(s, s)

    infix operator fun invoke(v: Vec2d) = invoke(v.x, v.y)
    infix operator fun invoke(v: Vec3d) = invoke(v.x, v.y)
    infix operator fun invoke(v: Vec4d) = invoke(v.x, v.y)

    infix operator fun invoke(doubles: DoubleArray) = invoke(doubles[0], doubles[1], doubles[2], doubles[3])

    infix operator fun invoke(mat2: Mat2) = invoke(DoubleArray(length) { mat2.array[it].d })
    infix operator fun invoke(mat2: Mat2d) = invoke(mat2.array.clone())

    infix operator fun invoke(mat3: Mat3) = invoke(
            mat3[0, 0].d, mat3[0, 1].d,
            mat3[1, 0].d, mat3[1, 1].d)

    infix operator fun invoke(mat3: Mat3d) = invoke(
            mat3[0, 0], mat3[0, 1],
            mat3[1, 0], mat3[1, 1])

    infix operator fun invoke(mat4: Mat4) = invoke(
            mat4[0, 0].d, mat4[0, 1].d,
            mat4[1, 0].d, mat4[1, 1].d)

    infix operator fun invoke(mat4: Mat4d) = invoke(
            mat4[0, 0], mat4[0, 1],
            mat4[1, 0], mat4[1, 1])

    operator fun invoke(x: Double, y: Double) = invoke(
            x, 0.0,
            0.0, y)

    operator fun invoke(x: Number, y: Number) = invoke(
            x.d, 0.0,
            0.0, y.d)

    fun invoke(a0: Double, a1: Double,
               b0: Double, b1: Double): Mat2d {

        put(a0, a1, b0, b1)
        return this
    }

    fun invoke(a0: Number, a1: Number,
               b0: Number, b1: Number): Mat2d {

        put(a0.d, a1.d, b0.d, b1.d)
        return this
    }


    infix fun put(mat2: Mat2d) = System.arraycopy(mat2.array.clone(), 0, array, 0, length)

    fun identity() = put(1.0)
    infix fun put(s: Double) = put(s, s)
    infix fun put(v: Vec2d) = put(v.x, v.y)
    infix fun put(v: Vec3d) = put(v.x, v.y)
    infix fun put(v: Vec4d) = put(v.x, v.y)

    infix fun put(doubles: DoubleArray) = put(doubles[0], doubles[1], doubles[2], doubles[3])

    fun put(x: Double, y: Double) = put(
            x, 0.0,
            0.0, y)

    fun put(a0: Double, a1: Double,
            b0: Double, b1: Double) {

        array[0] = a0
        array[1] = a1

        array[4] = b0
        array[5] = b1
    }


    // TODO inc

    fun toDoubleArray(): DoubleArray = to(DoubleArray(length), 0)
    infix fun to(doubles: DoubleArray): DoubleArray = to(doubles, 0)
    fun to(doubles: DoubleArray, index: Int): DoubleArray {
        System.arraycopy(array, 0, doubles, index, length)
        return doubles
    }

    override fun to(buf: ByteBuffer, offset: Int): ByteBuffer {
        return buf
                .putDouble(offset + 0 * Double.BYTES, array[0])
                .putDouble(offset + 1 * Double.BYTES, array[1])
                .putDouble(offset + 2 * Double.BYTES, array[2])
                .putDouble(offset + 3 * Double.BYTES, array[3])
    }

    fun toFloatBufferStack(): DoubleBuffer = to(MemoryStack.stackGet().mallocDouble(length), 0)
    infix fun toFloatBuffer(stack: MemoryStack): DoubleBuffer = to(stack.mallocDouble(length), 0)
    fun toFloatBuffer(): DoubleBuffer = to(doubleBufferBig(length), 0)
    infix fun to(buf: DoubleBuffer): DoubleBuffer = to(buf, buf.pos)

    fun to(buf: DoubleBuffer, offset: Int): DoubleBuffer {
        buf[offset + 0] = array[0]
        buf[offset + 1] = array[1]
        buf[offset + 2] = array[2]
        buf[offset + 3] = array[3]
        return buf
    }


    // -- Unary arithmetic operators --

    operator fun unaryPlus() = this

    operator fun unaryMinus() = Mat2d(
            -array[0], -array[1],
            -array[3], -array[4])

    // -- operators --

    infix operator fun plus(b: Mat2d) = plus(Mat2d(), this, b)
    infix operator fun plus(b: Double) = plus(Mat2d(), this, b)

    fun plus(b: Mat2d, res: Mat2d) = plus(res, this, b)
    fun plus(b: Double, res: Mat2d) = plus(res, this, b)

    infix operator fun plusAssign(b: Mat2d) {
        plus(this, this, b)
    }

    infix operator fun plusAssign(b: Double) {
        plus(this, this, b)
    }


    infix operator fun minus(b: Mat2d) = minus(Mat2d(), this, b)
    infix operator fun minus(b: Double) = minus(Mat2d(), this, b)

    fun minus(b: Mat2d, res: Mat2d) = minus(res, this, b)
    fun minus(b: Double, res: Mat2d) = minus(res, this, b)

    infix operator fun minusAssign(b: Mat2d) {
        minus(this, this, b)
    }

    infix operator fun minusAssign(b: Double) {
        minus(this, this, b)
    }


    infix operator fun times(b: Mat2d) = times(Mat2d(), this, b)
    infix operator fun times(b: Mat3x2d) = times(TODO(), this, b)
    infix operator fun times(b: Mat4x2d) = times(TODO(), this, b)

    infix operator fun times(b: Vec2d) = times(Vec2d(), this, b)
    infix operator fun times(b: Double) = times(Mat2d(), this, b)

    fun times(b: Mat2d, res: Mat2d) = times(res, this, b)
    fun times(b: Double, res: Mat2d) = times(res, this, b)


    fun times(b: Vec2d, res: Vec2d = Vec2d()) = times(res, this, b)

    infix operator fun timesAssign(b: Mat2d) {
        times(this, this, b)
    } // TODO

    infix operator fun timesAssign(b: Double) {
        times(this, this, b)
    }


    infix operator fun timesAssign(b: Vec2d) {
        times(b, this, b)
    }

    infix operator fun div(b: Mat2d) = div(Mat2d(), this, b)
    infix operator fun div(b: Double) = div(Mat2d(), this, b)

    fun div(b: Mat2d, res: Mat2d) = div(res, this, b)
    fun div(b: Double, res: Mat2d) = div(res, this, b)

    infix operator fun divAssign(b: Mat2d) {
        div(this, this, b)
    }

    infix operator fun divAssign(b: Double) {
        div(this, this, b)
    }


    infix fun isEqual(b: Mat2d) = this[0].isEqual(b[0]) && this[1].isEqual(b[1])


    override var a0: Double
        get() = array[0]
        set(v) = array.set(0, v)
    override var a1: Double
        get() = array[1]
        set(v) = array.set(1, v)

    override var b0: Double
        get() = array[2]
        set(v) = array.set(2, v)
    override var b1: Double
        get() = array[3]
        set(v) = array.set(3, v)


    override val isIdentity
        get() = this[0, 0] == 1.0 && this[1, 0] == 0.0 &&
                this[0, 1] == 0.0 && this[1, 1] == 1.0

    companion object : mat2x2d_operators {
        const val length = Mat2x2t.length
        @JvmField
        val size = length * Double.BYTES

        @JvmStatic
        fun fromPointer(ptr: Ptr, transpose: Boolean = false): Mat2d {
            return when {
                transpose -> Mat2d(
                        memGetDouble(ptr), memGetDouble(ptr + Double.BYTES * 2),
                        memGetDouble(ptr + Double.BYTES), memGetDouble(ptr + Double.BYTES * 3))
                else -> Mat2d(
                        memGetDouble(ptr), memGetDouble(ptr + Double.BYTES),
                        memGetDouble(ptr + Double.BYTES * 2), memGetDouble(ptr + Double.BYTES * 3))
            }
        }
    }

    override fun size() = size

    override fun equals(other: Any?) = other is Mat2d && Arrays.equals(array, other.array)

    override fun hashCode() = 31 * this[0].hashCode() + this[1].hashCode()

    fun print(name: String = "", stream: PrintStream = System.out) = stream.println("""$name:
        $v00 $v10
        $v01 $v11""")

    override fun toString() = """
        $v00 $v10
        $v01 $v11"""
}