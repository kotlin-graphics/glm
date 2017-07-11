package  glm_.mat3x3

import glm_.BYTES
import glm_.glm
import glm_.glm.inverse
import glm_.glm.transpose
import glm_.mat2x2.Mat2x2t
import glm_.mat2x3.Mat2x3t
import glm_.mat2x4.Mat2x4t
import glm_.mat3x2.Mat3x2t
import glm_.mat3x3.operators.mat3x3_operators
import glm_.mat3x4.Mat3x4t
import glm_.mat4x2.Mat4x2t
import glm_.mat4x3.Mat4x3t
import glm_.mat4x4.Mat4
import glm_.quat.Quat
import glm_.set
import glm_.vec2.Vec2t
import glm_.vec3.Vec3
import glm_.vec3.Vec3t
import glm_.vec4.Vec4t
import java.nio.ByteBuffer
import java.nio.FloatBuffer

/**
 * Created by GBarbieri on 10.11.2016.
 */

data class Mat3(override var value: MutableList<Vec3>) : Mat3x3t<Vec3>(value) {

    // -- Constructors --

    constructor() : this(1)

    constructor(s: Number) : this(s, s, s)

    constructor(x: Number, y: Number, z: Number) : this(mutableListOf(
            Vec3(x, 0, 0),
            Vec3(0, y, 0),
            Vec3(0, 0, z)))

    constructor(v: Vec2t<*>) : this(v.x, v.y, 0)
    constructor(v: Vec2t<*>, z: Number) : this(v.x, v.y, z)
    constructor(v: Vec2t<*>, z: Number, w: Number) : this(v.x, v.y, z)
    constructor(v: Vec3t<*>) : this(v.x, v.y, v.z)
    constructor(v: Vec3t<*>, w: Number) : this(v.x, v.y, v.z)
    constructor(v: Vec4t<*>) : this(v.x, v.y, v.z)

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

    constructor(mat3: Mat3) : this(mutableListOf(
            Vec3(mat3[0]),
            Vec3(mat3[1]),
            Vec3(mat3[2])))

    constructor(mat4: Mat4) : this(mutableListOf(
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

    @JvmOverloads constructor(floats: FloatArray, transpose: Boolean = false) : this(
            if (transpose) mutableListOf(
                    Vec3(floats[0], floats[4], floats[8]),
                    Vec3(floats[1], floats[5], floats[9]),
                    Vec3(floats[2], floats[6], floats[10]))
            else mutableListOf(
                    Vec3(floats, 0),
                    Vec3(floats, 4),
                    Vec3(floats, 8)))

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

    operator fun set(i: Int, v: Vec3) {
        value[i] = v
    }

    // -- Matrix functions --

    fun det() = +value[0][0] * (value[1][1] * value[2][2] - value[2][1] * value[1][2]) -
            value[1][0] * (value[0][1] * value[2][2] - value[2][1] * value[0][2]) +
            value[2][0] * (value[0][1] * value[1][2] - value[1][1] * value[0][2])

    @JvmOverloads fun inverse(res: Mat3 = Mat3()) = inverse(res, this)
    fun inverse_() = inverse(this, this)

    @JvmOverloads fun transpose(res: Mat3 = Mat3()) = transpose(res, this)
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
    infix fun to(res: Mat4): Mat4 {

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

    fun toMat4() = to(Mat4())

    infix fun to(res: Quat) = glm.quat_cast(this, res)
    fun toQuat() = glm.quat_cast(this, Quat())


    infix fun to(dbb: ByteBuffer): ByteBuffer = to(dbb, 0)

    fun to(dbb: ByteBuffer, offset: Int): ByteBuffer {
        dbb.putFloat(offset + 0 * Float.BYTES, value[0][0])
        dbb.putFloat(offset + 1 * Float.BYTES, value[0][1])
        dbb.putFloat(offset + 2 * Float.BYTES, value[0][2])
        dbb.putFloat(offset + 3 * Float.BYTES, value[1][0])
        dbb.putFloat(offset + 4 * Float.BYTES, value[1][1])
        dbb.putFloat(offset + 5 * Float.BYTES, value[1][2])
        dbb.putFloat(offset + 6 * Float.BYTES, value[2][0])
        dbb.putFloat(offset + 7 * Float.BYTES, value[2][1])
        dbb.putFloat(offset + 8 * Float.BYTES, value[2][2])
        return dbb
    }


    infix fun to(dfb: FloatBuffer) = to(dfb, 0)

    fun to(dfb: FloatBuffer, offset: Int): FloatBuffer {
        dfb[offset + 0] = value[0][0]
        dfb[offset + 1] = value[0][1]
        dfb[offset + 2] = value[0][2]
        dfb[offset + 3] = value[1][0]
        dfb[offset + 4] = value[1][1]
        dfb[offset + 5] = value[1][2]
        dfb[offset + 6] = value[2][0]
        dfb[offset + 7] = value[2][1]
        dfb[offset + 8] = value[2][2]
        return dfb
    }


    companion object : mat3x3_operators {
        @JvmField val size = 3 * 3 * Float.BYTES
    }


    // -- Unary arithmetic operators --

    operator fun unaryPlus() = this

    operator fun unaryMinus() = Mat3(-value[0], -value[1], -value[2])


// -- Increment main.and decrement operators --

    operator fun inc(res: Mat3 = Mat3()): Mat3 = plus(res, this, 1f)
    fun inc_() = plus(this, this, 1f)

    operator fun dec(res: Mat3 = Mat3()): Mat3 = minus(res, this, 1f)
    fun dec_() = minus(this, this, 1f)


// -- Specific binary arithmetic operators --

    infix operator fun plus(b: Float) = plus(Mat3(), this, b)
    infix operator fun plus(b: Mat3) = plus(Mat3(), this, b)

    fun plus(b: Float, res: Mat3) = plus(res, this, b)
    fun plus(b: Mat3, res: Mat3) = plus(res, this, b)

    infix fun plus_(b: Float) = plus(this, this, b)
    infix fun plus_(b: Mat3) = plus(this, this, b)


    infix operator fun minus(b: Float) = minus(Mat3(), this, b)
    infix operator fun minus(b: Mat3) = minus(Mat3(), this, b)

    fun minus(b: Float, res: Mat3) = minus(res, this, b)
    fun minus(b: Mat3, res: Mat3) = minus(res, this, b)

    infix fun minus_(b: Float) = minus(this, this, b)
    infix fun minus_(b: Mat3) = minus(this, this, b)


    infix operator fun times(b: Float) = times(Mat3(), this, b)
    infix operator fun times(b: Vec3) = times(Vec3(), this, b)
    infix operator fun times(b: Mat3) = times(Mat3(), this, b)

    fun times(b: Float, res: Mat3) = times(res, this, b)
    fun times(b: Vec3, res: Vec3) = times(res, this, b)
    fun times(b: Mat3, res: Mat3) = times(res, this, b)

    infix fun times_(b: Float) = times(this, this, b)
    infix fun times_(b: Vec3) = times(b, this, b)
    infix fun times_(b: Mat3) = times(this, this, b)


    infix operator fun div(b: Float) = div(Mat3(), this, b)
    infix operator fun div(b: Mat3) = div(Mat3(), this, b)

    fun div(b: Float, res: Mat3) = div(res, this, b)
    fun div(b: Mat3, res: Mat3) = div(res, this, b)

    infix fun div_(b: Float) = div(this, this, b)
    infix fun div_(b: Mat3) = div(this, this, b)


    infix fun isEqual(b: Mat3): Boolean {
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


    override fun toString() = super.toString()
}