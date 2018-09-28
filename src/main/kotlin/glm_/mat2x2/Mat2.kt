package glm_.mat2x2

import glm_.*
import glm_.mat2x2.operators.mat2x2_operators
import glm_.mat2x3.Mat2x3t
import glm_.mat2x4.Mat2x4t
import glm_.mat3x2.Mat3x2
import glm_.mat3x2.Mat3x2t
import glm_.mat3x3.Mat3
import glm_.mat3x3.Mat3d
import glm_.mat4x2.Mat4x2
import glm_.mat4x2.Mat4x2t
import glm_.mat4x4.Mat4
import glm_.mat4x4.Mat4d
import glm_.vec2.Vec2
import glm_.vec2.Vec2t
import glm_.vec3.Vec3
import glm_.vec4.Vec4
import kool.bufferBig
import kool.floatBufferBig
import org.lwjgl.system.MemoryStack
import java.nio.ByteBuffer
import java.nio.FloatBuffer
import java.util.*

/**
 * Created by GBarbieri on 10.11.2016.
 *
 * GLSL, column major
 */
class Mat2(dummy: Int, var array: FloatArray) : Mat2x2t<Float>() {

    // -- Constructors --

    constructor() : this(
            1, 0,
            0, 1)

    constructor(scalar: Number) : this(
            scalar, 0,
            0, scalar)

    constructor(x0: Number, y0: Number,
                x1: Number, y1: Number) : this(0, floatArrayOf(
            x0.f, y0.f,
            x1.f, y1.f))

    constructor(v0: Vec2t<out Number>, v1: Vec2t<out Number>) : this(
            v0.x, v0.y,
            v1.x, v1.y)

    constructor(block: (Int) -> Number) : this(
            block(0).f, block(1).f,
            block(2).f, block(3).f)

    constructor(block: (Int, Int) -> Number) : this(
            block(0, 0).f, block(0, 1).f,
            block(1, 0).f, block(1, 1).f)

    constructor(list: Iterable<*>, index: Int = 0) : this(
            list.elementAt(index)!!.toFloat, list.elementAt(index + 1)!!.toFloat,
            list.elementAt(index + 2)!!.toFloat, list.elementAt(index + 3)!!.toFloat)

    // -- Matrix conversions --

    constructor(mat2: Mat2) : this(0, mat2.array.clone())
    constructor(mat2: Mat2d) : this(0, FloatArray(length) { mat2.array[it].f })

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
//    fun to(mat2x2: Mat2x2t<*>) { TODO
//        value = mutableListOf(
//                Vec2(mat2x2.value[0]),
//                Vec2(mat2x2.value[1]))
//    }
//
//    fun to(scalar: Number) {
//        value = mutableListOf(
//                Vec2(scalar.f, 0),
//                Vec2(0, scalar.f))
//    }
//
//    fun to(x0: Number, x1: Number, y0: Number, y1: Number) {
//        value = mutableListOf(
//                Vec2(x0.f, y0.f),
//                Vec2(x1.f, y1.f))
//    }
//
//    fun to(v0: Vec2t<*>, v1: Vec2t<*>) {
//        value = mutableListOf(
//                Vec2(v0),
//                Vec2(v1))
//    }

    // -- Accesses --

    override operator fun get(index: Int) = Vec2(index * 2, array)
    override operator fun get(column: Int, row: Int) = array[column * 2 + row]

    override operator fun set(column: Int, row: Int, value: Float) = array.set(column * 2 + row, value)
    override operator fun set(index: Int, value: Vec2t<out Number>) {
        array[index * 2] = value.x.f
        array[index * 2 + 1] = value.y.f
    }

    operator fun set(index: Int, value: Vec2) {
        value.to(array, index * 2)
    }


    infix operator fun invoke(s: Float) = invoke(s, s)

    infix operator fun invoke(v: Vec2) = invoke(v.x, v.y)
    infix operator fun invoke(v: Vec3) = invoke(v.x, v.y)
    infix operator fun invoke(v: Vec4) = invoke(v.x, v.y)

    infix operator fun invoke(floats: FloatArray) = invoke(floats[0], floats[1], floats[2], floats[3])

    infix operator fun invoke(mat2: Mat2) = invoke(mat2.array.clone())
    infix operator fun invoke(mat2: Mat2d) = invoke(FloatArray(length) { mat2.array[it].f })

    infix operator fun invoke(mat3: Mat3) = invoke(
            mat3[0, 0], mat3[0, 1],
            mat3[1, 0], mat3[1, 1])

    infix operator fun invoke(mat3: Mat3d) = invoke(
            mat3[0, 0].f, mat3[0, 1].f,
            mat3[1, 0].f, mat3[1, 1].f)

    infix operator fun invoke(mat4: Mat4) = invoke(
            mat4[0, 0], mat4[0, 1],
            mat4[1, 0], mat4[1, 1])

    infix operator fun invoke(mat4: Mat4d) = invoke(
            mat4[0, 0].f, mat4[0, 1].f,
            mat4[1, 0].f, mat4[1, 1].f)

    operator fun invoke(x: Float, y: Float) = invoke(
            x, 0f,
            0f, y)

    operator fun invoke(x: Number, y: Number) = invoke(
            x.f, 0f,
            0f, y.f)

    operator fun invoke(a0: Float, a1: Float,
                        b0: Float, b1: Float): Mat2 {

        put(a0, a1, b0, b1)
        return this
    }

    operator fun invoke(a0: Number, a1: Number,
                        b0: Number, b1: Number): Mat2 {

        put(a0.f, a1.f, b0.f, b1.f)
        return this
    }


    infix fun put(mat2: Mat2) = System.arraycopy(mat2.array.clone(), 0, array, 0, length)

    fun identity() = put(1f)
    infix fun put(s: Float) = put(s, s)
    infix fun put(v: Vec2) = put(v.x, v.y)
    infix fun put(v: Vec3) = put(v.x, v.y)
    infix fun put(v: Vec4) = put(v.x, v.y)

    infix fun put(floats: FloatArray) = put(floats[0], floats[1], floats[2], floats[3])

    fun put(x: Float, y: Float) = put(
            x, 0f,
            0f, y)

    fun put(a0: Float, a1: Float,
            b0: Float, b1: Float) {

        array[0] = a0
        array[1] = a1

        array[4] = b0
        array[5] = b1
    }


    // -- Matrix functions --

    val det get() = glm.determinant(this)

    fun inverse(res: Mat2 = Mat2()) = glm.inverse(res, this)
    fun inverseAssign() = glm.inverse(this, this)

    fun transpose(res: Mat2 = Mat2()) = glm.transpose(res, this)
    fun transposeAssign() = glm.transpose(this, this)

    // TODO inc


    fun toFloatArray(): FloatArray = to(FloatArray(length), 0)
    infix fun to(floats: FloatArray): FloatArray = to(floats, 0)
    fun to(floats: FloatArray, index: Int): FloatArray {
        System.arraycopy(array, 0, floats, index, length)
        return floats
    }


    infix fun toBuffer(stack: MemoryStack): ByteBuffer = to(stack.malloc(size), 0)
    fun toBuffer(): ByteBuffer = to(bufferBig(size), 0)
    infix fun to(buf: ByteBuffer) = to(buf, 0)

    fun to(buf: ByteBuffer, offset: Int): ByteBuffer {
        buf
                .putFloat(offset + 0 * Float.BYTES, array[0])
                .putFloat(offset + 1 * Float.BYTES, array[1])
                .putFloat(offset + 2 * Float.BYTES, array[2])
                .putFloat(offset + 3 * Float.BYTES, array[3])
        return buf
    }

    infix fun toFloatBuffer(stack: MemoryStack): FloatBuffer = to(stack.mallocFloat(length), 0)
    fun toFloatBuffer(): FloatBuffer = to(floatBufferBig(length), 0)
    infix fun to(buf: FloatBuffer): FloatBuffer = to(buf, 0)

    fun to(buf: FloatBuffer, offset: Int): FloatBuffer {
        buf[offset + 0] = array[0]
        buf[offset + 1] = array[1]
        buf[offset + 2] = array[2]
        buf[offset + 3] = array[3]
        return buf
    }

    // -- Unary arithmetic operators --

    operator fun unaryPlus() = this

    operator fun unaryMinus() = Mat2(
            -array[0], -array[1],
            -array[3], -array[4])

    // -- operators --

    infix operator fun plus(b: Mat2) = plus(Mat2(), this, b)
    infix operator fun plus(b: Float) = plus(Mat2(), this, b)

    fun plus(b: Mat2, res: Mat2) = plus(res, this, b)
    fun plus(b: Float, res: Mat2) = plus(res, this, b)

    infix operator fun plusAssign(b: Mat2) {
        plus(this, this, b)
    }

    infix operator fun plusAssign(b: Float) {
        plus(this, this, b)
    }


    infix operator fun minus(b: Mat2) = minus(Mat2(), this, b)
    infix operator fun minus(b: Float) = minus(Mat2(), this, b)

    fun minus(b: Mat2, res: Mat2) = minus(res, this, b)
    fun minus(b: Float, res: Mat2) = minus(res, this, b)

    infix operator fun minusAssign(b: Mat2) {
        minus(this, this, b)
    }

    infix operator fun minusAssign(b: Float) {
        minus(this, this, b)
    }


    infix operator fun times(b: Mat2) = times(Mat2(), this, b)
    infix operator fun times(b: Mat3x2): Nothing = TODO()//times(TODO(), this, b)
    infix operator fun times(b: Mat4x2): Nothing = TODO()//times(TODO(), this, b)

    infix operator fun times(b: Vec2) = times(Vec2(), this, b)
    infix operator fun times(b: Float) = times(Mat2(), this, b)

    fun times(b: Mat2, res: Mat2) = times(res, this, b)
    fun times(b: Float, res: Mat2) = times(res, this, b)

    fun times(b: Vec2, res: Vec2 = Vec2()) = times(res, this, b)

    infix operator fun timesAssign(b: Mat2) {
        times(this, this, b)
    } // TODO

    infix operator fun timesAssign(b: Float) {
        times(this, this, b)
    }


    infix operator fun timesAssign(b: Vec2) {
        times(b, this, b)
    }

    infix operator fun div(b: Mat2) = div(Mat2(), this, b)
    infix operator fun div(b: Float) = div(Mat2(), this, b)

    fun div(b: Mat2, res: Mat2) = div(res, this, b)
    fun div(b: Float, res: Mat2) = div(res, this, b)

    infix operator fun divAssign(b: Mat2) {
        div(this, this, b)
    }

    infix operator fun divAssign(b: Float) {
        div(this, this, b)
    }

    infix fun isEqual(b: Mat2) = this[0].isEqual(b[0]) && this[1].isEqual(b[1])

    // TODO others
    override var a0: Float
        get() = array[0]
        set(v) = array.set(0, v)
    override var a1: Float
        get() = array[1]
        set(v) = array.set(1, v)

    override var b0: Float
        get() = array[2]
        set(v) = array.set(2, v)
    override var b1: Float
        get() = array[3]
        set(v) = array.set(3, v)


    override val isIdentity
        get() = this[0, 0] == 1f && this[1, 0] == 0f &&
                this[0, 1] == 0f && this[1, 1] == 1f

    companion object : mat2x2_operators {
        const val length = Mat2x2t.length
        @JvmField
        val size = length * Float.BYTES
    }

    override fun size() = size

    override fun equals(other: Any?) = other is Mat2 && Arrays.equals(array, other.array)

    override fun hashCode() = 31 * this[0].hashCode() + this[1].hashCode()
}