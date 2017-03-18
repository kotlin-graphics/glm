package  glm.mat

import glm.BYTES
import glm.Glm.inverse
import glm.Glm.transpose
import glm.glm
import glm.mat.operators.mat3x3_operators
import glm.quat.Quat
import glm.vec.Vec3t
import glm.vec._3.Vec3

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
//                Vec3(scalar.main.getF, 0),
//                Vec3(0, scalar.main.getF))
//    }
//
//    fun to(x0: Number, x1: Number, y0: Number, y1: Number) {
//        value = mutableListOf(
//                Vec3(x0.main.getF, y0.main.getF),
//                Vec3(x1.main.getF, y1.main.getF))
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


    infix fun put(s: Float) = put(s, s, s)
    infix fun put(v: Vec3) = put(v.x, v.y, v.z)

    fun put(x: Float, y: Float, z: Float): Mat3 {

        value[0][0] = x
        value[0][1] = 0f
        value[0][2] = 0f

        value[1][0] = 0f
        value[1][1] = y
        value[1][2] = 0f

        value[2][0] = 0f
        value[2][1] = 0f
        value[2][2] = z

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

    infix fun to(res: Quat) = glm.quat_cast(this, res)
    fun toQuat() = glm.quat_cast(this, Quat())


    companion object : mat3x3_operators {
        @JvmField val SIZE = 3 * 3 * Float.BYTES
    }


    // -- Unary arithmetic operators --

    operator fun unaryPlus() = this

    operator fun unaryMinus() = Mat3x3(-value[0], -value[1], -value[2])


// -- Increment main.and decrement operators --

    operator fun inc(res: Mat3x3 = Mat3x3()): Mat3x3 = plus(res, this, 1f)
    fun inc_() = plus(this, this, 1f)

    operator fun dec(res: Mat3x3 = Mat3x3()): Mat3x3 = minus(res, this, 1f)
    fun dec_() = minus(this, this, 1f)


// -- Specific binary arithmetic operators --

    infix operator fun plus(b: Float) = plus(Mat3x3(), this, b)
    infix operator fun plus(b: Mat3x3) = plus(Mat3x3(), this, b)

    fun plus(b: Float, res: Mat3x3) = plus(res, this, b)
    fun plus(b: Mat3x3, res: Mat3x3) = plus(res, this, b)

    infix fun plus_(b: Float) = plus(this, this, b)
    infix fun plus_(b: Mat3x3) = plus(this, this, b)


    infix operator fun minus(b: Float) = minus(Mat3x3(), this, b)
    infix operator fun minus(b: Mat3x3) = minus(Mat3x3(), this, b)

    fun minus(b: Float, res: Mat3x3) = minus(res, this, b)
    fun minus(b: Mat3x3, res: Mat3x3) = minus(res, this, b)

    infix fun minus_(b: Float) = minus(this, this, b)
    infix fun minus_(b: Mat3x3) = minus(this, this, b)


    infix operator fun times(b: Float) = times(Mat3x3(), this, b)
    infix operator fun times(b: Vec3) = times(Vec3(), this, b)
    infix operator fun times(b: Mat3x3) = times(Mat3x3(), this, b)

    fun times(b: Float, res: Mat3x3) = times(res, this, b)
    fun times(b: Vec3, res: Vec3) = times(res, this, b)
    fun times(b: Mat3x3, res: Mat3x3) = times(res, this, b)

    infix fun times_(b: Float) = times(this, this, b)
    infix fun times_(b: Vec3) = times(b, this, b)
    infix fun times_(b: Mat3x3) = times(this, this, b)


    infix operator fun div(b: Float) = div(Mat3x3(), this, b)
    infix operator fun div(b: Mat3x3) = div(Mat3x3(), this, b)

    fun div(b: Float, res: Mat3x3) = div(res, this, b)
    fun div(b: Mat3x3, res: Mat3x3) = div(res, this, b)

    infix fun div_(b: Float) = div(this, this, b)
    infix fun div_(b: Mat3x3) = div(this, this, b)


    infix fun isEqual(b: Mat3x3): Boolean {
        return (this[0].isEqual(b[0])
                && this[1].isEqual(b[1])
                && this[2].isEqual(b[2]))
    }

    // TODO others
    var a0: Float
        @JvmName("v00") get() = value[0][0]
        @JvmName("v00") set(v) {
            value[0][0] = v
        }
    var a1: Float
        @JvmName("v01") get() = value[0][1]
        @JvmName("v01") set(v) {
            value[0][1] = v
        }
    var a2: Float
        @JvmName("v02") get() = value[0][2]
        @JvmName("v02") set(v) {
            value[0][2] = v
        }

    var b0: Float
        @JvmName("v10") get() = value[1][0]
        @JvmName("v10") set(v) {
            value[1][0] = v
        }
    var b1: Float
        @JvmName("v11") get() = value[1][1]
        @JvmName("v11") set(v) {
            value[1][1] = v
        }
    var b2: Float
        @JvmName("v12") get() = value[1][2]
        @JvmName("v12") set(v) {
            value[1][2] = v
        }

    var c0: Float
        @JvmName("v20") get() = value[2][0]
        @JvmName("v20") set(v) {
            value[2][0] = v
        }
    var c1: Float
        @JvmName("v21") get() = value[2][1]
        @JvmName("v21") set(v) {
            value[2][1] = v
        }
    var c2: Float
        @JvmName("v22") get() = value[2][2]
        @JvmName("v22") set(v) {
            value[2][2] = v
        }


    fun isIdentity() = this[0][0] == 1f && this[1][0] == 0f && this[2][0] == 0f &&
            this[0][1] == 0f && this[1][1] == 1f && this[2][1] == 0f &&
            this[0][2] == 0f && this[1][2] == 0f && this[2][2] == 1f


    override fun equals(other: Any?) =
            if (other is Mat3x3)
                this[0] == other[0] && this[1] == other[1] && this[2] == other[2]
            else false
}