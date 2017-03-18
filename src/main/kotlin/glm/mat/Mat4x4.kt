package  glm.mat

import glm.BYTES
import glm.Glm.determinant
import glm.Glm.inverse
import glm.Glm.transpose
import glm.glm
import glm.set
import glm.mat.operators.mat4x4_operators
import glm.quat.Quat
import glm.vec.Vec2t
import glm.vec.Vec3t
import glm.vec.Vec4t
import glm.vec._3.Vec3
import glm.vec._4.Vec4
import java.nio.ByteBuffer
import java.nio.FloatBuffer

/**
 * Created by GBarbieri on 10.11.2016.
 */
data class Mat4x4(override var value: MutableList<Vec4>) : Mat4x4t<Vec4> {

    // -- Constructors --

    constructor() : this(1)

    constructor(s: Number) : this(s, s, s, s)

    constructor(x: Number, y: Number, z: Number, w: Number) : this(mutableListOf(
            Vec4(x, 0, 0, 0),
            Vec4(0, y, 0, 0),
            Vec4(0, 0, z, 0),
            Vec4(0, 0, 0, w)))

    // TODO others

    constructor(v: Vec2t<*>) : this(v.x, v.y, 0, 1)
    constructor(v: Vec2t<*>, z: Number) : this(v.x, v.y, z, 1)
    constructor(v: Vec2t<*>, z: Number, w: Number) : this(v.x, v.y, z, w)
    constructor(v: Vec3t<*>) : this(v.x, v.y, v.z, 1)
    constructor(v: Vec3t<*>, w: Number) : this(v.x, v.y, v.z, w)
    constructor(v: Vec4t<*>) : this(v.x, v.y, v.z, v.w)

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

    // TODO others
    @JvmOverloads constructor(floats: FloatArray, transpose: Boolean = false) : this(
            if (transpose) mutableListOf(
                    Vec4(floats[0], floats[4], floats[8], floats[12]),
                    Vec4(floats[1], floats[5], floats[9], floats[13]),
                    Vec4(floats[2], floats[6], floats[10], floats[14]),
                    Vec4(floats[3], floats[7], floats[11], floats[15]))
            else mutableListOf(
                    Vec4(floats, 0),
                    Vec4(floats, 4),
                    Vec4(floats, 8),
                    Vec4(floats, 12)))

    // set

    fun put(v0: Vec4, v1: Vec4, v2: Vec4, v3: Vec4) {
        value[0] to v0
    }

    // TODO others
    infix fun put(mat4x4: Mat4x4) {
        value = mutableListOf(
                Vec4(mat4x4[0]), Vec4(mat4x4[1]),
                Vec4(mat4x4[2]), Vec4(mat4x4[3]))
    }

//    fun to(mat2x2: Mat2x2t<*>) {
//        value = mutableListOf(
//                Vec4(mat2x2[0]),
//                Vec4(mat2x2[1]))
//    }

//    fun to(scalar: Number) {
//        value = mutableListOf(
//                Vec4(scalar.main.getF, 0),
//                Vec4(0, scalar.main.getF))
//    }
//
//    fun to(x0: Number, x1: Number, y0: Number, y1: Number) {
//        value = mutableListOf(
//                Vec4(x0.main.getF, y0.main.getF),
//                Vec4(x1.main.getF, y1.main.getF))
//    }
//
//    fun to(v0: Vec4t<*>, v1: Vec4t<*>) {
//        value = mutableListOf(
//                Vec4(v0),
//                Vec4(v1))
//    }

    infix fun put(s: Float) = put(s, s, s, s)
    infix fun put(v: Vec3) = put(v.x, v.y, v.z, 1f)
    infix fun put(v: Vec4) = put(v.x, v.y, v.z, v.w)

    fun put(x: Float, y: Float, z: Float, w: Float): Mat4x4 {

        value[0][0] = x
        value[0][1] = 0f
        value[0][2] = 0f
        value[0][3] = 0f

        value[1][0] = 0f
        value[1][1] = y
        value[1][2] = 0f
        value[1][3] = 0f

        value[2][0] = 0f
        value[2][1] = 0f
        value[2][2] = z
        value[2][3] = 0f

        value[3][0] = 0f
        value[3][1] = 0f
        value[3][2] = 0f
        value[3][3] = w

        return this
    }

    // TODO others
    fun toMat3() = to(Mat3x3())

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

    // TODO others
    infix fun to(dbb: ByteBuffer): ByteBuffer = to(dbb, 0)

    fun to(dbb: ByteBuffer, offset: Int): ByteBuffer {
        dbb.putFloat(offset + 0 * Float.BYTES, value[0][0])
        dbb.putFloat(offset + 1 * Float.BYTES, value[0][1])
        dbb.putFloat(offset + 2 * Float.BYTES, value[0][2])
        dbb.putFloat(offset + 3 * Float.BYTES, value[0][3])
        dbb.putFloat(offset + 4 * Float.BYTES, value[1][0])
        dbb.putFloat(offset + 5 * Float.BYTES, value[1][1])
        dbb.putFloat(offset + 6 * Float.BYTES, value[1][2])
        dbb.putFloat(offset + 7 * Float.BYTES, value[1][3])
        dbb.putFloat(offset + 8 * Float.BYTES, value[2][0])
        dbb.putFloat(offset + 9 * Float.BYTES, value[2][1])
        dbb.putFloat(offset + 10 * Float.BYTES, value[2][2])
        dbb.putFloat(offset + 11 * Float.BYTES, value[2][3])
        dbb.putFloat(offset + 12 * Float.BYTES, value[3][0])
        dbb.putFloat(offset + 13 * Float.BYTES, value[3][1])
        dbb.putFloat(offset + 14 * Float.BYTES, value[3][2])
        dbb.putFloat(offset + 15 * Float.BYTES, value[3][3])
        return dbb
    }

    // TODO others
    infix fun to(dfb: FloatBuffer) = to(dfb, 0)

    fun to(dfb: FloatBuffer, offset: Int): FloatBuffer {
        dfb[offset + 0] = value[0][0]
        dfb[offset + 1] = value[0][1]
        dfb[offset + 2] = value[0][2]
        dfb[offset + 3] = value[0][3]
        dfb[offset + 4] = value[1][0]
        dfb[offset + 5] = value[1][1]
        dfb[offset + 6] = value[1][2]
        dfb[offset + 7] = value[1][3]
        dfb[offset + 8] = value[2][0]
        dfb[offset + 9] = value[2][1]
        dfb[offset + 10] = value[2][2]
        dfb[offset + 11] = value[2][3]
        dfb[offset + 12] = value[3][0]
        dfb[offset + 13] = value[3][1]
        dfb[offset + 14] = value[3][2]
        dfb[offset + 15] = value[3][3]
        return dfb
    }

    infix fun to(res: Quat) = glm.quat_cast(this, res)
    fun toQuat() = glm.quat_cast(this, Quat())

    // -- Accesses --

    operator fun get(i: Int) = value[i]

    operator fun set(i: Int, v: Vec4) = value[i] put v

    fun set(i: Int, v: Vec3, s: Float) = value[i].put(v, s) // TODO other cases

    companion object : mat4x4_operators {
        @JvmField val length = 4    // TODO others
        @JvmField val SIZE = length * Vec4.SIZE
    }


    // -- Unary arithmetic operators --

    operator fun unaryPlus() = this

    operator fun unaryMinus() = Mat4x4(-value[0], -value[1], -value[2], -value[3])


    // -- Increment main.and decrement operators --

    operator fun inc(res: Mat4x4 = Mat4x4()): Mat4x4 = plus(res, this, 1f)
    fun inc_() = plus(this, this, 1f)

    operator fun dec(res: Mat4x4 = Mat4x4()): Mat4x4 = minus(res, this, 1f)
    fun dec_() = minus(this, this, 1f)


    // -- Specific binary arithmetic operators --

    infix operator fun plus(b: Float) = plus(Mat4x4(), this, b)
    infix operator fun plus(b: Mat4x4) = plus(Mat4x4(), this, b)

    fun plus(b: Float, res: Mat4x4) = plus(res, this, b)
    fun plus(b: Mat4x4, res: Mat4x4) = plus(res, this, b)

    infix fun plus_(b: Float) = plus(this, this, b)
    infix fun plus_(b: Mat4x4) = plus(this, this, b)


    infix operator fun minus(b: Float) = minus(Mat4x4(), this, b)
    infix operator fun minus(b: Mat4x4) = minus(Mat4x4(), this, b)

    fun minus(b: Float, res: Mat4x4) = minus(res, this, b)
    fun minus(b: Mat4x4, res: Mat4x4) = minus(res, this, b)

    infix fun minus_(b: Float) = minus(this, this, b)
    infix fun minus_(b: Mat4x4) = minus(this, this, b)


    /**
     * @return = [b] * @this
     */
    infix operator fun times(b: Float) = times(Mat4x4(), this, b)

    infix operator fun times(b: Vec4) = times(Vec4(), this, b)
    infix operator fun times(b: Mat4x4) = times(Mat4x4(), this, b)

    /**
     * [res] = [b] * @this
     */
    fun times(b: Float, res: Mat4x4) = times(res, this, b)

    fun times(b: Vec4, res: Vec4) = times(res, this, b)
    fun times(b: Mat4x4, res: Mat4x4) = times(res, this, b)

    infix fun times_(b: Float) = times(this, this, b)
    infix fun times_(b: Vec4) = times(b, this, b)
    infix fun times_(b: Mat4x4) = times(this, this, b)


    infix operator fun div(b: Float) = div(Mat4x4(), this, b)
    infix operator fun div(b: Mat4x4) = div(Mat4x4(), this, b)

    fun div(b: Float, res: Mat4x4) = div(res, this, b)
    fun div(b: Mat4x4, res: Mat4x4) = div(res, this, b)

    infix fun div_(b: Float) = div(this, this, b)
    infix fun div_(b: Mat4x4) = div(this, this, b)


    // -- Matrix functions --

    fun det() = determinant(this)

    fun inverse(res: Mat4x4 = Mat4x4()) = inverse(res, this)
    fun inverse_() = inverse(this, this)

    fun transpose(res: Mat4x4 = Mat4x4()) = transpose(res, this)
    fun transpose_() = transpose(this, this)


    // TODO others
    @JvmOverloads fun scale(scale: Vec3, res: Mat4x4 = Mat4()) = scale(scale.x, scale.y, scale.z, res)

    @JvmOverloads fun scale(scale: Float, res: Mat4x4 = Mat4x4()) = scale(scale, scale, scale, res)
    @JvmOverloads fun scale(scaleX: Float, scaleY: Float, scaleZ: Float, res: Mat4 = Mat4()) = glm.scale(res, this, scaleX, scaleY, scaleZ)

    fun scale_(scale: Vec3) = scale_(scale.x, scale.y, scale.z)
    fun scale_(scale: Float) = scale_(scale, scale, scale)
    fun scale_(scaleX: Float, scaleY: Float, scaleZ: Float) = glm.scale(this, this, scaleX, scaleY, scaleZ)


    @JvmOverloads fun translate(translate: Vec3, res: Mat4x4 = Mat4x4()) = translate(translate.x, translate.y, translate.z, res)
    @JvmOverloads fun translate(translate: Float, res: Mat4x4 = Mat4x4()) = translate(translate, translate, translate, res)
    @JvmOverloads fun translate(translateX: Float, translateY: Float, translateZ: Float, res: Mat4x4 = Mat4x4()) =
            glm.translate(res, this, translateX, translateY, translateZ)

    fun translate_(translate: Vec3) = translate_(translate.x, translate.y, translate.z)
    fun translate_(translate: Float) = translate_(translate, translate, translate)
    fun translate_(translateX: Float, translateY: Float, translateZ: Float) = glm.translate(this, this, translateX, translateY, translateZ)


    infix fun isEqual(b: Mat4x4): Boolean {
        return (this[0].isEqual(b[0])
                && this[1].isEqual(b[1])
                && this[2].isEqual(b[2])
                && this[3].isEqual(b[3]))
    }

    @JvmOverloads fun rotate(angle: Float, vX: Float, vY: Float, vZ: Float, res: Mat4x4 = Mat4x4()) = glm.rotate(res, this, angle, vX, vY, vZ)
    @JvmOverloads fun rotate(angle: Float, v: Vec3, res: Mat4x4 = Mat4x4()) = glm.rotate(res, this, angle, v)
    fun rotate_(angle: Float, vX: Float, vY: Float, vZ: Float) = glm.rotate(this, this, angle, vX, vY, vZ)
    fun rotate_(angle: Float, v: Vec3) = glm.rotate(this, this, angle, v)


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
    var a3: Float
        @JvmName("v03") get() = value[0][3]
        @JvmName("v03") set(v) {
            value[0][3] = v
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
    var b3: Float
        @JvmName("v13") get() = value[1][3]
        @JvmName("v13") set(v) {
            value[1][3] = v
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
    var c3: Float
        @JvmName("v23") get() = value[2][3]
        @JvmName("v23") set(v) {
            value[2][3] = v
        }

    var d0: Float
        @JvmName("v30") get() = value[3][0]
        @JvmName("v30") set(v) {
            value[3][0] = v
        }
    var d1: Float
        @JvmName("v31") get() = value[3][1]
        @JvmName("v31") set(v) {
            value[3][1] = v
        }
    var d2: Float
        @JvmName("v32") get() = value[3][2]
        @JvmName("v32") set(v) {
            value[3][2] = v
        }
    var d3: Float
        @JvmName("v33") get() = value[3][3]
        @JvmName("v33") set(v) {
            value[3][3] = v
        }


    fun isIdentity() = this[0][0] == 1f && this[1][0] == 0f && this[2][0] == 0f && this[3][0] == 0f &&
            this[0][1] == 0f && this[1][1] == 1f && this[2][1] == 0f && this[3][1] == 0f &&
            this[0][2] == 0f && this[1][2] == 0f && this[2][2] == 1f && this[3][2] == 0f &&
            this[0][3] == 0f && this[1][3] == 0f && this[2][3] == 0f && this[3][3] == 1f


    override fun equals(other: Any?) =
            if (other is Mat4)
                this[0] == other[0] && this[1] == other[1] && this[2] == other[2] && this[3] == other[3]
            else false

//    override fun toString() = "$a0 $b0 $c0 $d0\n$a1 $b1 $c1 $d1\n$a2 $b2 $c2 $d2\n$a3 $b3 $c3 $d3"
}

