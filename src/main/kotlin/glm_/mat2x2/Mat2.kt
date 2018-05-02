package glm_.mat2x2

import glm_.*
import glm_.mat2x2.operators.mat2x2_operators
import glm_.mat2x3.Mat2x3t
import glm_.mat2x4.Mat2x4t
import glm_.mat3x2.Mat3x2
import glm_.mat3x2.Mat3x2t
import glm_.mat3x3.Mat3
import glm_.mat4x2.Mat4x2
import glm_.mat4x2.Mat4x2t
import glm_.mat4x4.Mat4
import glm_.vec2.Vec2
import glm_.vec2.Vec2t
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

    override inline operator fun get(index: Int) = Vec2(index * 2, array)
    override inline operator fun get(c: Int, r: Int) = array[c * 2 + r]

    override inline operator fun set(c: Int, r: Int, s: Float) = array.set(c * 2 + r, s)
    override inline operator fun set(i: Int, v: Vec2t<out Number>) {
        array[i * 2] = v.x.f
        array[i * 2 + 1] = v.y.f
    }

    inline operator fun set(i: Int, v: Vec2) {
        v.to(array, i * 2)
    }


    // -- Matrix functions --

    val det get() = glm.determinant(this)

    fun inverse(res: Mat2 = Mat2()) = glm.inverse(res, this)
    fun inverseAssign() = glm.inverse(this, this)

    fun transpose(res: Mat2 = Mat2()) = glm.transpose(res, this)
    fun transposeAssign() = glm.transpose(this, this)

    // TODO inc


    infix fun to(dfb: FloatBuffer) = to(dfb, 0)

    fun to(dfb: FloatBuffer, offset: Int): FloatBuffer {
        dfb[offset + 0] = array[0]
        dfb[offset + 1] = array[1]
        dfb[offset + 2] = array[2]
        dfb[offset + 3] = array[3]
        return dfb
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

    companion object : mat2x2_operators() {
        const val length = Mat2x2t.length
        @JvmField
        val size = length * Float.BYTES
    }

    override fun size() = size

    override fun equals(other: Any?) = other is Mat2 && Arrays.equals(array, other.array)

    override fun hashCode() = 31 * this[0].hashCode() + this[1].hashCode()
}