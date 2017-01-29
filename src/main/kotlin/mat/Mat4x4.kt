package  mat

import BYTES
import mat.operators.mat4x4_operators
import vec.Vec4t
import vec._4.Vec4
import glm.Companion.inverse
import glm.Companion.transpose
import glm.Companion.determinant

/**
 * Created by GBarbieri on 10.11.2016.
 */
data class Mat4x4(override var value: MutableList<Vec4>) : Mat4x4t<Vec4> {

    // -- Constructors --

    constructor() : this(mutableListOf(
            Vec4(1, 0, 0, 0),
            Vec4(0, 1, 0, 0),
            Vec4(0, 0, 1, 0),
            Vec4(0, 0, 0, 1)))

    constructor(scalar: Number) : this(mutableListOf(
            Vec4(scalar, 0, 0, 0),
            Vec4(0, scalar, 0, 0),
            Vec4(0, 0, scalar, 0),
            Vec4(0, 0, 0, scalar)))

    constructor(x0: Number, y0: Number, z0: Number, w0: Number,
                x1: Number, y1: Number, z1: Number, w1: Number,
                x2: Number, y2: Number, z2: Number, w2: Number,
                x3: Number, y3: Number, z3: Number, w3: Number) : this(mutableListOf(
            Vec4(x0, y0, z0, w0),
            Vec4(x1, y1, z1, w1),
            Vec4(x2, y2, z2, w2),
            Vec4(x3, y3, z3, w3)))

    constructor(v0: Vec4t<out Number>, v1: Vec4t<out Number>, v2: Vec4t<out Number>, v3: Vec4t<out Number>) : this(mutableListOf(
            Vec4(v0),
            Vec4(v1),
            Vec4(v2),
            Vec4(v3)))

    // -- Matrix conversions --

    constructor(mat2x2: Mat2x2t<*>) : this(mutableListOf(
            Vec4(mat2x2[0], 0, 0),
            Vec4(mat2x2[1], 0, 0),
            Vec4(0, 0, 1, 0),
            Vec4(0, 0, 0, 1)))

    constructor(mat3: Mat3x3) : this(mutableListOf(
            Vec4(mat3[0], 0),
            Vec4(mat3[1], 0),
            Vec4(mat3[2], 0),
            Vec4(0, 0, 0, 1)))

    constructor(mat4: Mat4x4) : this(mutableListOf(
            Vec4(mat4[0]),
            Vec4(mat4[1]),
            Vec4(mat4[2]),
            Vec4(mat4[3])))

    constructor(mat2x3: Mat2x3t<*>) : this(mutableListOf(
            Vec4(mat2x3[0], 0),
            Vec4(mat2x3[1], 0),
            Vec4(0, 0, 0, 1),
            Vec4(0, 0, 0, 1)))

    constructor(mat3x2: Mat3x2t<*>) : this(mutableListOf(
            Vec4(mat3x2[0], 0, 0),
            Vec4(mat3x2[1], 0, 0),
            Vec4(mat3x2[2], 1, 0),
            Vec4(0, 0, 0, 1)))

    constructor(mat2x4: Mat2x4t<*>) : this(mutableListOf(
            Vec4(mat2x4[0]),
            Vec4(mat2x4[1]),
            Vec4(0, 0, 1, 0),
            Vec4(0, 0, 0, 1)))

    constructor(mat4x2: Mat4x2t<*>) : this(mutableListOf(
            Vec4(mat4x2[0], 0, 0),
            Vec4(mat4x2[1], 0, 0),
            Vec4(mat4x2[2], 1, 0),
            Vec4(mat4x2[3], 0, 1)))

    constructor(mat3x4: Mat3x4t<*>) : this(mutableListOf(
            Vec4(mat3x4[0]),
            Vec4(mat3x4[1]),
            Vec4(mat3x4[2]),
            Vec4(0, 0, 0, 1)))

    constructor(mat4x3: Mat4x3t<*>) : this(mutableListOf(
            Vec4(mat4x3[0], 0),
            Vec4(mat4x3[1], 0),
            Vec4(mat4x3[2], 0),
            Vec4(mat4x3[3], 1)))

    // set

    fun set(v0: Vec4, v1: Vec4, v2: Vec4, v3: Vec4) {
        value[0] to v0
    }

//    fun to(mat2x2: Mat2x2t<*>) {
//        value = mutableListOf(
//                Vec4(mat2x2[0]),
//                Vec4(mat2x2[1]))
//    }

//    fun to(scalar: Number) {
//        value = mutableListOf(
//                Vec4(scalar.f, 0),
//                Vec4(0, scalar.f))
//    }
//
//    fun to(x0: Number, x1: Number, y0: Number, y1: Number) {
//        value = mutableListOf(
//                Vec4(x0.f, y0.f),
//                Vec4(x1.f, y1.f))
//    }
//
//    fun to(v0: Vec4t<*>, v1: Vec4t<*>) {
//        value = mutableListOf(
//                Vec4(v0),
//                Vec4(v1))
//    }

    infix fun set(s: Float): Mat4x4 {

        value[0][0] = s
        value[0][1] = 0f
        value[0][2] = 0f
        value[0][3] = 0f

        value[1][0] = 0f
        value[1][1] = s
        value[1][2] = 0f
        value[1][3] = 0f

        value[2][0] = 0f
        value[2][1] = 0f
        value[2][2] = s
        value[2][3] = 0f

        value[3][0] = 0f
        value[3][1] = 0f
        value[3][2] = 0f
        value[3][3] = s

        return this
    }

    // TODO others
    infix fun to(res: Mat3x3): Mat3x3 {

        res[0][0] = this[0][0]
        res[0][1] = this[0][1]
        res[0][2] = this[0][2]

        res[1][0] = this[1][0]
        res[1][1] = this[1][1]
        res[1][2] = this[1][2]

        res[2][0] = this[2][0]
        res[2][1] = this[2][1]
        res[2][2] = this[2][2]

        return res
    }

    fun toMat3() = to(Mat3x3())


    // -- Accesses --

    operator fun get(i: Int) = value[i]

    operator fun set(i: Int, v: Vec4) {
        value[i] = v
    }


    companion object : mat4x4_operators {
        @JvmStatic val SIZE = 4 * 4 * Float.BYTES
    }


    // -- Unary arithmetic operators --

    operator fun unaryPlus() = this

    operator fun unaryMinus() = Mat4x4(-value[0], -value[1], -value[2], -value[3])


    // -- Increment and decrement operators --

    operator fun inc(res: Mat4x4 = Mat4x4()): Mat4x4 = add(res, this, 1f)
    fun inc_() = add(this, this, 1f)

    operator fun dec(res: Mat4x4 = Mat4x4()): Mat4x4 = sub(res, this, 1f)
    fun dec_() = sub(this, this, 1f)


    // -- Specific binary arithmetic operators --

    operator fun plus(b: Float) = add(Mat4x4(), this, b)
    operator fun plus(b: Mat4x4) = add(Mat4x4(), this, b)

    fun add(b: Float, res: Mat4x4 = Mat4x4()) = add(res, this, b)
    fun add(b: Mat4x4, res: Mat4x4 = Mat4x4()) = add(res, this, b)

    infix fun add_(b: Float) = add(this, this, b)
    infix fun add_(b: Mat4x4) = add(this, this, b)


    operator fun minus(b: Float) = sub(Mat4x4(), this, b)
    operator fun minus(b: Mat4x4) = sub(Mat4x4(), this, b)

    fun sub(b: Float, res: Mat4x4 = Mat4x4()) = sub(res, this, b)
    fun sub(b: Mat4x4, res: Mat4x4 = Mat4x4()) = sub(res, this, b)

    infix fun sub_(b: Float) = sub(this, this, b)
    infix fun sub_(b: Mat4x4) = sub(this, this, b)


    /**
     * @return = [b] * @this
     */
    operator fun times(b: Float) = mul(Mat4x4(), this, b)

    operator fun times(b: Vec4) = mul(Vec4(), this, b)
    operator fun times(b: Mat4x4) = mul(Mat4x4(), this, b)

    /**
     * [res] = [b] * @this
     */
    @JvmOverloads fun mul(b: Float, res: Mat4x4 = Mat4x4()) = mul(res, this, b)

    fun mul(b: Vec4, res: Vec4 = Vec4()) = mul(res, this, b)
    fun mul(b: Mat4x4, res: Mat4x4 = Mat4x4()) = mul(res, this, b)

    infix fun mul_(b: Float) = mul(this, this, b)
    infix fun mul_(b: Vec4) = mul(b, this, b)
    infix fun mul_(b: Mat4x4) = mul(this, this, b)


    operator fun div(b: Float) = div(Mat4x4(), this, b)
    operator fun div(b: Mat4x4) = div(Mat4x4(), this, b)

    fun div(b: Float, res: Mat4x4 = Mat4x4()) = div(res, this, b)
    fun div(b: Mat4x4, res: Mat4x4 = Mat4x4()) = div(res, this, b)

    infix fun div_(b: Float) = div(this, this, b)
    infix fun div_(b: Mat4x4) = div(this, this, b)


    // -- Matrix functions --

    fun det() = determinant(this)

    fun inverse(res: Mat4x4 = Mat4x4()) = inverse(res, this)
    fun inverse_() = inverse(this, this)

    fun transpose(res: Mat4x4 = Mat4x4()) = transpose(res, this)
    fun transpose_() = transpose(this, this)

    val a0: Float
        get() = value[0][0]
    val a1: Float
        get() = value[0][1]
    val a2: Float
        get() = value[0][2]
    val a3: Float
        get() = value[0][3]

    val b0: Float
        get() = value[1][0]
    val b1: Float
        get() = value[1][1]
    val b2: Float
        get() = value[1][2]
    val b3: Float
        get() = value[1][3]

    val c0: Float
        get() = value[2][0]
    val c1: Float
        get() = value[2][1]
    val c2: Float
        get() = value[2][2]
    val c3: Float
        get() = value[2][3]

    val d0: Float
        get() = value[3][0]
    val d1: Float
        get() = value[3][1]
    val d2: Float
        get() = value[3][2]
    val d3: Float
        get() = value[3][3]
}

