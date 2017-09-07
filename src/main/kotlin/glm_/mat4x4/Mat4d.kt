package  glm_.mat4x4

import glm_.BYTES
import glm_.glm
import glm_.glm.determinant
import glm_.glm.inverse
import glm_.glm.transpose
import glm_.mat2x2.Mat2x2t
import glm_.mat2x3.Mat2x3t
import glm_.mat2x4.Mat2x4t
import glm_.mat3x2.Mat3x2t
import glm_.mat3x3.Mat3d
import glm_.mat3x4.Mat3x4t
import glm_.mat4x2.Mat4x2t
import glm_.mat4x3.Mat4x3t
import glm_.mat4x4.operators.mat4d_operators
import glm_.quat.QuatD
import glm_.set
import glm_.vec2.Vec2t
import glm_.vec3.Vec3d
import glm_.vec3.Vec3t
import glm_.vec4.Vec4d
import glm_.vec4.Vec4t
import java.nio.ByteBuffer
import java.nio.DoubleBuffer

/**
 * Created by GBarbieri on 10.11.2016.
 */
data class Mat4d(override var value: MutableList<Vec4d>) : Mat4x4t<Vec4d>(value) {

    // -- Constructors --

    constructor() : this(1)

    constructor(s: Number) : this(s, s, s, s)

    constructor(x: Number, y: Number, z: Number, w: Number) : this(mutableListOf(
            Vec4d(x, 0, 0, 0),
            Vec4d(0, y, 0, 0),
            Vec4d(0, 0, z, 0),
            Vec4d(0, 0, 0, w)))

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
            Vec4d(x0, y0, z0, w0),
            Vec4d(x1, y1, z1, w1),
            Vec4d(x2, y2, z2, w2),
            Vec4d(x3, y3, z3, w3)))

    constructor(v0: Vec4t<out Number>, v1: Vec4t<out Number>, v2: Vec4t<out Number>, v3: Vec4t<out Number>) : this(mutableListOf(
            Vec4d(v0),
            Vec4d(v1),
            Vec4d(v2),
            Vec4d(v3)))

    // -- Matrix conversions --

    constructor(mat2x2: Mat2x2t<*>) : this(mutableListOf(
            Vec4d(mat2x2[0], 0, 0),
            Vec4d(mat2x2[1], 0, 0),
            Vec4d(0, 0, 1, 0),
            Vec4d(0, 0, 0, 1)))

    constructor(mat3: Mat3d) : this(mutableListOf(
            Vec4d(mat3[0], 0),
            Vec4d(mat3[1], 0),
            Vec4d(mat3[2], 0),
            Vec4d(0, 0, 0, 1)))

    constructor(mat4: Mat4) : this(mutableListOf(
            Vec4d(mat4[0]),
            Vec4d(mat4[1]),
            Vec4d(mat4[2]),
            Vec4d(mat4[3])))

    constructor(mat2x3: Mat2x3t<*>) : this(mutableListOf(
            Vec4d(mat2x3[0], 0),
            Vec4d(mat2x3[1], 0),
            Vec4d(0, 0, 0, 1),
            Vec4d(0, 0, 0, 1)))

    constructor(mat3x2: Mat3x2t<*>) : this(mutableListOf(
            Vec4d(mat3x2[0], 0, 0),
            Vec4d(mat3x2[1], 0, 0),
            Vec4d(mat3x2[2], 1, 0),
            Vec4d(0, 0, 0, 1)))

    constructor(mat2x4: Mat2x4t<*>) : this(mutableListOf(
            Vec4d(mat2x4[0]),
            Vec4d(mat2x4[1]),
            Vec4d(0, 0, 1, 0),
            Vec4d(0, 0, 0, 1)))

    constructor(mat4x2: Mat4x2t<*>) : this(mutableListOf(
            Vec4d(mat4x2[0], 0, 0),
            Vec4d(mat4x2[1], 0, 0),
            Vec4d(mat4x2[2], 1, 0),
            Vec4d(mat4x2[3], 0, 1)))

    constructor(mat3x4: Mat3x4t<*>) : this(mutableListOf(
            Vec4d(mat3x4[0]),
            Vec4d(mat3x4[1]),
            Vec4d(mat3x4[2]),
            Vec4d(0, 0, 0, 1)))

    constructor(mat4x3: Mat4x3t<*>) : this(mutableListOf(
            Vec4d(mat4x3[0], 0),
            Vec4d(mat4x3[1], 0),
            Vec4d(mat4x3[2], 0),
            Vec4d(mat4x3[3], 1)))

    // TODO others
    @JvmOverloads constructor(floats: DoubleArray, transpose: Boolean = false) : this(
            if (transpose) mutableListOf(
                    Vec4d(floats[0], floats[4], floats[8], floats[12]),
                    Vec4d(floats[1], floats[5], floats[9], floats[13]),
                    Vec4d(floats[2], floats[6], floats[10], floats[14]),
                    Vec4d(floats[3], floats[7], floats[11], floats[15]))
            else mutableListOf(
                    Vec4d(floats, 0),
                    Vec4d(floats, 4),
                    Vec4d(floats, 8),
                    Vec4d(floats, 12)))


    fun put(v0: Vec4d, v1: Vec4d, v2: Vec4d, v3: Vec4d) {
        value[0] to v0
        value[1] to v1
        value[2] to v2
        value[3] to v3
    }

    // TODO others
    infix fun put(mat4: Mat4d) {
        value = mutableListOf(
                Vec4d(mat4[0]), Vec4d(mat4[1]),
                Vec4d(mat4[2]), Vec4d(mat4[3]))
    }

    infix fun put(s: Double) = put(s, s, s, s)
    infix fun put(v: Vec3d) = put(v.x, v.y, v.z, 1.0)
    infix fun put(v: Vec4d) = put(v.x, v.y, v.z, v.w)

    infix fun put(floats: DoubleArray) = put(floats[0], floats[1], floats[2], floats[3], floats[4], floats[5], floats[6],
            floats[7], floats[8], floats[9], floats[10], floats[11], floats[12], floats[13], floats[14], floats[15])

    fun put(x: Double, y: Double, z: Double, w: Double) = put(
            x, 0.0, 0.0, 0.0,
            0.0, y, 0.0, 0.0,
            0.0, 0.0, z, 0.0,
            0.0, 0.0, 0.0, w)

    fun put(a0: Double, a1: Double, a2: Double, a3: Double,
            b0: Double, b1: Double, b2: Double, b3: Double,
            c0: Double, c1: Double, c2: Double, c3: Double,
            d0: Double, d1: Double, d2: Double, d3: Double): Mat4d {

        value[0][0] = a0
        value[0][1] = a1
        value[0][2] = a2
        value[0][3] = a3

        value[1][0] = b0
        value[1][1] = b1
        value[1][2] = b2
        value[1][3] = b3

        value[2][0] = c0
        value[2][1] = c1
        value[2][2] = c2
        value[2][3] = c3

        value[3][0] = d0
        value[3][1] = d1
        value[3][2] = d2
        value[3][3] = d3

        return this
    }

    // TODO others
    fun toMat3() = to(Mat3d())

    infix fun to(res: Mat3d): Mat3d {

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
        dbb.putDouble(offset + 0 * Double.BYTES, value[0][0])
        dbb.putDouble(offset + 1 * Double.BYTES, value[0][1])
        dbb.putDouble(offset + 2 * Double.BYTES, value[0][2])
        dbb.putDouble(offset + 3 * Double.BYTES, value[0][3])
        dbb.putDouble(offset + 4 * Double.BYTES, value[1][0])
        dbb.putDouble(offset + 5 * Double.BYTES, value[1][1])
        dbb.putDouble(offset + 6 * Double.BYTES, value[1][2])
        dbb.putDouble(offset + 7 * Double.BYTES, value[1][3])
        dbb.putDouble(offset + 8 * Double.BYTES, value[2][0])
        dbb.putDouble(offset + 9 * Double.BYTES, value[2][1])
        dbb.putDouble(offset + 10 * Double.BYTES, value[2][2])
        dbb.putDouble(offset + 11 * Double.BYTES, value[2][3])
        dbb.putDouble(offset + 12 * Double.BYTES, value[3][0])
        dbb.putDouble(offset + 13 * Double.BYTES, value[3][1])
        dbb.putDouble(offset + 14 * Double.BYTES, value[3][2])
        dbb.putDouble(offset + 15 * Double.BYTES, value[3][3])
        return dbb
    }

    // TODO others
    infix fun to(dfb: DoubleBuffer) = to(dfb, 0)

    fun to(dfb: DoubleBuffer, offset: Int): DoubleBuffer {
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

    infix fun to(res: QuatD) = glm.quatD_cast(this, res)
    fun toQuatD() = glm.quatD_cast(this, QuatD())

    // -- put --

    fun to(mat2x2: Mat2x2t<*>) {
        value = mutableListOf(
                Vec4d(mat2x2[0]),
                Vec4d(mat2x2[1]))
    }

//    fun to(scalar: Number) {
//        value = mutableListOf(
//                Vec4d(scalar.main.getF, 0),
//                Vec4d(0, scalar.main.getF))
//    }
//
//    fun to(x0: Number, x1: Number, y0: Number, y1: Number) {
//        value = mutableListOf(
//                Vec4d(x0.main.getF, y0.main.getF),
//                Vec4d(x1.main.getF, y1.main.getF))
//    }
//
//    fun to(v0: Vec4dt<*>, v1: Vec4dt<*>) {
//        value = mutableListOf(
//                Vec4d(v0),
//                Vec4d(v1))
//    }


    // -- Accesses --

    operator fun set(i: Int, v: Vec4d) = value[i] put v

    fun set(i: Int, v: Vec3d, s: Double) = value[i].put(v, s) // TODO other cases

    companion object : mat4d_operators {
        @JvmField
        val length = 4    // TODO others
        @JvmField
        val size = length * Vec4d.size
    }


    // -- Unary arithmetic operators --

    operator fun unaryPlus() = this

    operator fun unaryMinus() = Mat4d(-value[0], -value[1], -value[2], -value[3])


    // -- Increment main.and decrement operators --

    operator fun inc(res: Mat4d = Mat4d()): Mat4d = plus(res, this, 1.0)
    fun inc_() = plus(this, this, 1.0)

    operator fun dec(res: Mat4d = Mat4d()): Mat4d = minus(res, this, 1.0)
    fun dec_() = minus(this, this, 1.0)


    // -- Specific binary arithmetic operators --

    infix operator fun plus(b: Double) = plus(Mat4d(), this, b)
    infix operator fun plus(b: Mat4d) = plus(Mat4d(), this, b)

    fun plus(b: Double, res: Mat4d) = plus(res, this, b)
    fun plus(b: Mat4d, res: Mat4d) = plus(res, this, b)

    infix fun plus_(b: Double) = plus(this, this, b)
    infix fun plus_(b: Mat4d) = plus(this, this, b)


    infix operator fun minus(b: Double) = minus(Mat4d(), this, b)
    infix operator fun minus(b: Mat4d) = minus(Mat4d(), this, b)

    fun minus(b: Double, res: Mat4d) = minus(res, this, b)
    fun minus(b: Mat4d, res: Mat4d) = minus(res, this, b)

    infix fun minus_(b: Double) = minus(this, this, b)
    infix fun minus_(b: Mat4d) = minus(this, this, b)


    /**
     * @return = [b] * @this
     */
    infix operator fun times(b: Double) = times(Mat4d(), this, b)

    infix operator fun times(b: Vec4d) = times(Vec4d(), this, b)
    infix operator fun times(b: Mat4d) = times(Mat4d(), this, b)

    /**
     * [res] = [b] * @this
     */
    fun times(b: Double, res: Mat4d) = times(res, this, b)

    fun times(b: Vec4d, res: Vec4d) = times(res, this, b)
    fun times(b: Mat4d, res: Mat4d) = times(res, this, b)

    infix fun times_(b: Double) = times(this, this, b)
    infix fun times_(b: Vec4d) = times(b, this, b)
    infix fun times_(b: Mat4d) = times(this, this, b)


    infix operator fun div(b: Double) = div(Mat4d(), this, b)
    infix operator fun div(b: Mat4d) = div(Mat4d(), this, b)

    fun div(b: Double, res: Mat4d) = div(res, this, b)
    fun div(b: Mat4d, res: Mat4d) = div(res, this, b)

    infix fun div_(b: Double) = div(this, this, b)
    infix fun div_(b: Mat4d) = div(this, this, b)


    // -- Matrix functions --

    fun det() = determinant(this)

    @JvmOverloads
    fun inverse(res: Mat4d = Mat4d()) = glm.inverse(res, this)

    fun inverse_() = inverse(this, this)

    @JvmOverloads
    fun transpose(res: Mat4d = Mat4d()) = glm.transpose(res, this)

    fun transpose_() = transpose(this, this)


    // TODO others
    @JvmOverloads
    fun scale(scale: Vec3d, res: Mat4d = Mat4d()) = scale(scale.x, scale.y, scale.z, res)

    @JvmOverloads
    fun scale(scale: Double, res: Mat4d = Mat4d()) = scale(scale, scale, scale, res)

    @JvmOverloads
    fun scale(scaleX: Double, scaleY: Double, scaleZ: Double, res: Mat4d = Mat4d()) = glm.scale(res, this, scaleX, scaleY, scaleZ)

    infix fun scale_(scale: Vec3d) = scale_(scale.x, scale.y, scale.z)
    infix fun scale_(scale: Double) = scale_(scale, scale, scale)
    fun scale_(scaleX: Double, scaleY: Double, scaleZ: Double) = glm.scale(this, this, scaleX, scaleY, scaleZ)


    @JvmOverloads
    fun translate(translate: Vec3d, res: Mat4d = Mat4d()) = translate(translate.x, translate.y, translate.z, res)

    @JvmOverloads
    fun translate(translate: Double, res: Mat4d = Mat4d()) = translate(translate, translate, translate, res)

    @JvmOverloads
    fun translate(translateX: Double, translateY: Double, translateZ: Double, res: Mat4d = Mat4d()) =
            glm.translate(res, this, translateX, translateY, translateZ)

    infix fun translate_(translate: Vec3d) = translate_(translate.x, translate.y, translate.z)
    infix fun translate_(translate: Double) = translate_(translate, translate, translate)
    fun translate_(translateX: Double, translateY: Double, translateZ: Double) = glm.translate(this, this, translateX, translateY, translateZ)


    infix fun isEqual(b: Mat4d): Boolean {
        return (this[0].isEqual(b[0])
                && this[1].isEqual(b[1])
                && this[2].isEqual(b[2])
                && this[3].isEqual(b[3]))
    }

    @JvmOverloads
    fun rotate(angle: Double, vX: Double, vY: Double, vZ: Double, res: Mat4d = Mat4d()) = glm.rotate(res, this, angle, vX, vY, vZ)

    @JvmOverloads
    fun rotate(angle: Double, v: Vec3d, res: Mat4d = Mat4d()) = glm.rotate(res, this, angle, v)

    fun rotate_(angle: Double, vX: Double, vY: Double, vZ: Double) = glm.rotate(this, this, angle, vX, vY, vZ)
    fun rotate_(angle: Double, v: Vec3d) = glm.rotate(this, this, angle, v)


    // TODO others
    var a0: Double
        @JvmName("v00") get() = value[0][0]
        @JvmName("v00") set(v) {
            value[0][0] = v
        }
    var a1: Double
        @JvmName("v01") get() = value[0][1]
        @JvmName("v01") set(v) {
            value[0][1] = v
        }
    var a2: Double
        @JvmName("v02") get() = value[0][2]
        @JvmName("v02") set(v) {
            value[0][2] = v
        }
    var a3: Double
        @JvmName("v03") get() = value[0][3]
        @JvmName("v03") set(v) {
            value[0][3] = v
        }

    var b0: Double
        @JvmName("v10") get() = value[1][0]
        @JvmName("v10") set(v) {
            value[1][0] = v
        }
    var b1: Double
        @JvmName("v11") get() = value[1][1]
        @JvmName("v11") set(v) {
            value[1][1] = v
        }
    var b2: Double
        @JvmName("v12") get() = value[1][2]
        @JvmName("v12") set(v) {
            value[1][2] = v
        }
    var b3: Double
        @JvmName("v13") get() = value[1][3]
        @JvmName("v13") set(v) {
            value[1][3] = v
        }

    var c0: Double
        @JvmName("v20") get() = value[2][0]
        @JvmName("v20") set(v) {
            value[2][0] = v
        }
    var c1: Double
        @JvmName("v21") get() = value[2][1]
        @JvmName("v21") set(v) {
            value[2][1] = v
        }
    var c2: Double
        @JvmName("v22") get() = value[2][2]
        @JvmName("v22") set(v) {
            value[2][2] = v
        }
    var c3: Double
        @JvmName("v23") get() = value[2][3]
        @JvmName("v23") set(v) {
            value[2][3] = v
        }

    var d0: Double
        @JvmName("v30") get() = value[3][0]
        @JvmName("v30") set(v) {
            value[3][0] = v
        }
    var d1: Double
        @JvmName("v31") get() = value[3][1]
        @JvmName("v31") set(v) {
            value[3][1] = v
        }
    var d2: Double
        @JvmName("v32") get() = value[3][2]
        @JvmName("v32") set(v) {
            value[3][2] = v
        }
    var d3: Double
        @JvmName("v33") get() = value[3][3]
        @JvmName("v33") set(v) {
            value[3][3] = v
        }


    fun isIdentity() = this[0][0] == 1.0 && this[1][0] == 0.0 && this[2][0] == 0.0 && this[3][0] == 0.0 &&
            this[0][1] == 0.0 && this[1][1] == 1.0 && this[2][1] == 0.0 && this[3][1] == 0.0 &&
            this[0][2] == 0.0 && this[1][2] == 0.0 && this[2][2] == 1.0 && this[3][2] == 0.0 &&
            this[0][3] == 0.0 && this[1][3] == 0.0 && this[2][3] == 0.0 && this[3][3] == 1.0


    override fun toString() = super.toString()
}

