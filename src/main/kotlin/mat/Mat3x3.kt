package  mat

import BYTES
import mat.operators.mat3x3_operators
import vec.Vec3t
import vec._3.Vec3
import glm.Companion.inverse
import glm.Companion.transpose

/**
 * Created by GBarbieri on 10.11.2016.
 */

class Mat3x3(override var value: MutableList<Vec3>) : Mat3x3t<Vec3> {

    // -- Constructors --

    constructor() : this(mutableListOf(
            Vec3(1, 0, 0),
            Vec3(0, 1, 0),
            Vec3(0, 0, 1)))

    constructor(scalar: Number) : this(mutableListOf(
            Vec3(scalar, 0, 0),
            Vec3(0, scalar, 0),
            Vec3(0, 0, scalar)))

    constructor(x0: Number, y0: Number, z0: Number,
                x1: Number, y1: Number, z1: Number,
                x2: Number, y2: Number, z2: Number) : this(mutableListOf(
            Vec3(x0, y0, z0),
            Vec3(x1, y1, z1),
            Vec3(x2, y2, z2)))

    constructor(v0: Vec3t<out Number>, v1: Vec3t<out Number>, v2: Vec3t<out Number>) : this(mutableListOf(
            Vec3(v0),
            Vec3(v1),
            Vec3(v2)))

    // -- Matrix conversions --

    constructor(mat2x2: Mat2x2t<*>) : this(mutableListOf(
            Vec3(mat2x2[0], 0),
            Vec3(mat2x2[1], 0),
            Vec3(0, 0, 1)))

    constructor(mat3: Mat3x3) : this(mutableListOf(
            Vec3(mat3[0]),
            Vec3(mat3[1]),
            Vec3(mat3[2])))

    constructor(mat4: Mat4x4) : this(mutableListOf(
            Vec3(mat4[0]),
            Vec3(mat4[1]),
            Vec3(mat4[2])))

    constructor(mat2x3: Mat2x3t<*>) : this(mutableListOf(
            Vec3(mat2x3[0]),
            Vec3(mat2x3[1]),
            Vec3(0, 0, 1)))

    constructor(mat3x2: Mat3x2t<*>) : this(mutableListOf(
            Vec3(mat3x2[0], 0),
            Vec3(mat3x2[1], 0),
            Vec3(mat3x2[2], 1)))

    constructor(mat2x4: Mat2x4t<*>) : this(mutableListOf(
            Vec3(mat2x4[0]),
            Vec3(mat2x4[1]),
            Vec3(0, 0, 1)))

    constructor(mat4x2: Mat4x2t<*>) : this(mutableListOf(
            Vec3(mat4x2[0], 0),
            Vec3(mat4x2[1], 0),
            Vec3(mat4x2[2], 1)))

    constructor(mat3x4: Mat3x4t<*>) : this(mutableListOf(
            Vec3(mat3x4[0]),
            Vec3(mat3x4[1]),
            Vec3(mat3x4[2])))

    constructor(mat4x3: Mat4x3t<*>) : this(mutableListOf(
            Vec3(mat4x3[0]),
            Vec3(mat4x3[1]),
            Vec3(mat4x3[2])))

    // to
    fun to(mat2x2: Mat2x2t<*>) {
        value = mutableListOf(
                Vec3(mat2x2[0]),
                Vec3(mat2x2[1]))
    }

//    fun to(scalar: Number) {
//        value = mutableListOf(
//                Vec3(scalar.f, 0),
//                Vec3(0, scalar.f))
//    }
//
//    fun to(x0: Number, x1: Number, y0: Number, y1: Number) {
//        value = mutableListOf(
//                Vec3(x0.f, y0.f),
//                Vec3(x1.f, y1.f))
//    }
//
//    fun to(v0: Vec3t<*>, v1: Vec3t<*>) {
//        value = mutableListOf(
//                Vec3(v0),
//                Vec3(v1))
//    }

    // -- Accesses --

    operator fun get(i: Int) = value[i]

    operator fun set(i: Int, v: Vec3) {
        value[i] = v
    }

    // -- Matrix functions --

    fun det() = +value[0][0] * (value[1][1] * value[2][2] - value[2][1] * value[1][2]) -
            value[1][0] * (value[0][1] * value[2][2] - value[2][1] * value[0][2]) +
            value[2][0] * (value[0][1] * value[1][2] - value[1][1] * value[0][2])

    fun inverse(res: Mat3x3 = Mat3x3()) = inverse(res, this)
    fun inverse_() = inverse(this, this)

    fun transpose(res: Mat3x3 = Mat3x3()) = transpose(res, this)
    fun transpose_() = transpose(this, this)


    fun set(s: Float): Mat3x3 {

        value[0][0] = s
        value[0][1] = 0f
        value[0][2] = 0f

        value[1][0] = 0f
        value[1][1] = s
        value[1][2] = 0f

        value[2][0] = 0f
        value[2][1] = 0f
        value[2][2] = s

        return this
    }

    // TODO others
    infix fun to(res: Mat4x4): Mat4x4 {

        res[0][0] = this[0][0]
        res[0][1] = this[0][1]
        res[0][2] = this[0][2]
        res[0][3] = 0f

        res[1][0] = this[1][0]
        res[1][1] = this[1][1]
        res[1][2] = this[1][2]
        res[1][3] = 0f

        res[2][0] = this[2][0]
        res[2][1] = this[2][1]
        res[2][2] = this[2][2]
        res[2][3] = 0f

        res[3][0] = 0f
        res[3][1] = 0f
        res[3][2] = 0f
        res[3][3] = 1f

        return res
    }

    fun toMat4() = to(Mat4x4())


    companion object : mat3x3_operators {
        @JvmStatic val SIZE = 3 * 3 * Float.BYTES
    }


    // -- Unary arithmetic operators --

    operator fun unaryPlus() = this

    operator fun unaryMinus() = Mat3x3(-value[0], -value[1], -value[2])


// -- Increment and decrement operators --

    operator fun inc(res: Mat3x3 = Mat3x3()): Mat3x3 = add(res, this, 1f)
    fun inc_() = add(this, this, 1f)

    operator fun dec(res: Mat3x3 = Mat3x3()): Mat3x3 = sub(res, this, 1f)
    fun dec_() = sub(this, this, 1f)


// -- Specific binary arithmetic operators --

    operator fun plus(b: Float) = add(Mat3x3(), this, b)
    operator fun plus(b: Mat3x3) = add(Mat3x3(), this, b)

    fun add(b: Float, res: Mat3x3 = Mat3x3()) = add(res, this, b)
    fun add(b: Mat3x3, res: Mat3x3 = Mat3x3()) = add(res, this, b)

    infix fun add_(b: Float) = add(this, this, b)
    infix fun add_(b: Mat3x3) = add(this, this, b)


    operator fun minus(b: Float) = sub(Mat3x3(), this, b)
    operator fun minus(b: Mat3x3) = sub(Mat3x3(), this, b)

    fun sub(b: Float, res: Mat3x3 = Mat3x3()) = sub(res, this, b)
    fun sub(b: Mat3x3, res: Mat3x3 = Mat3x3()) = sub(res, this, b)

    infix fun sub_(b: Float) = sub(this, this, b)
    infix fun sub_(b: Mat3x3) = sub(this, this, b)


    operator fun times(b: Float) = mul(Mat3x3(), this, b)
    operator fun times(b: Vec3) = mul(Vec3(), this, b)
    operator fun times(b: Mat3x3) = mul(Mat3x3(), this, b)

    fun mul(b: Float, res: Mat3x3 = Mat3x3()) = mul(res, this, b)
    fun mul(b: Vec3, res: Vec3 = Vec3()) = mul(res, this, b)
    fun mul(b: Mat3x3, res: Mat3x3 = Mat3x3()) = mul(res, this, b)

    infix fun mul_(b: Float) = mul(this, this, b)
    infix fun mul_(b: Vec3) = mul(b, this, b)
    infix fun mul_(b: Mat3x3) = mul(this, this, b)


    operator fun div(b: Float) = div(Mat3x3(), this, b)
    operator fun div(b: Mat3x3) = div(Mat3x3(), this, b)

    fun div(b: Float, res: Mat3x3 = Mat3x3()) = div(res, this, b)
    fun div(b: Mat3x3, res: Mat3x3 = Mat3x3()) = div(res, this, b)

    infix fun div_(b: Float) = div(this, this, b)
    infix fun div_(b: Mat3x3) = div(this, this, b)
}