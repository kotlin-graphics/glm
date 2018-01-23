package  glm_.mat3x3

import glm_.*
import glm_.glm.inverse
import glm_.glm.transpose
import glm_.mat2x2.Mat2x2t
import glm_.mat2x3.Mat2x3t
import glm_.mat2x4.Mat2x4t
import glm_.mat3x2.Mat3x2t
import glm_.mat3x3.operators.mat3d_operators
import glm_.mat3x4.Mat3x4t
import glm_.mat4x2.Mat4x2t
import glm_.mat4x3.Mat4x3t
import glm_.mat4x4.Mat4
import glm_.mat4x4.Mat4d
import glm_.quat.QuatD
import glm_.vec2.Vec2t
import glm_.vec3.Vec3d
import glm_.vec3.Vec3t
import glm_.vec4.Vec4t
import java.nio.DoubleBuffer

/**
 * Created by GBarbieri on 10.11.2016.
 */

data class Mat3d(override var value: MutableList<Vec3d>) : Mat3x3t<Vec3d>(value) {

    // -- Constructors --

    constructor() : this(1)

    constructor(s: Number) : this(s, s, s)

    constructor(x: Number, y: Number, z: Number) : this(mutableListOf(
            Vec3d(x, 0, 0),
            Vec3d(0, y, 0),
            Vec3d(0, 0, z)))

    constructor(v: Vec2t<*>) : this(v.x, v.y, 0)
    constructor(v: Vec2t<*>, z: Number) : this(v.x, v.y, z)
    constructor(v: Vec3t<*>) : this(v.x, v.y, v.z)
    constructor(v: Vec4t<*>) : this(v.x, v.y, v.z)

    constructor(x0: Number, y0: Number, z0: Number,
                x1: Number, y1: Number, z1: Number,
                x2: Number, y2: Number, z2: Number) : this(mutableListOf(
            Vec3d(x0, y0, z0),
            Vec3d(x1, y1, z1),
            Vec3d(x2, y2, z2)))

    constructor(v0: Vec3t<out Number>, v1: Vec3t<out Number>, v2: Vec3t<out Number>) : this(mutableListOf(
            Vec3d(v0),
            Vec3d(v1),
            Vec3d(v2)))

    constructor(block: (Int) -> Number): this(block(0).d, block(1).d, block(2).d, block(3).d, block(4).d,
            block(5).d, block(6).d, block(7).d, block(8).d)

    constructor(list: Iterable<*>, index: Int = 0) : this(list.elementAt(index)!!.toDouble, list.elementAt(index + 1)!!.toDouble,
            list.elementAt(index + 2)!!.toDouble, list.elementAt(index + 3)!!.toDouble, list.elementAt(index + 4)!!.toDouble,
            list.elementAt(index + 5)!!.toDouble, list.elementAt(index + 6)!!.toDouble, list.elementAt(index + 7)!!.toDouble,
            list.elementAt(index + 8)!!.toDouble)

    // -- Matrix conversions --

    constructor(mat2x2: Mat2x2t<*>) : this(mutableListOf(
            Vec3d(mat2x2[0], 0),
            Vec3d(mat2x2[1], 0),
            Vec3d(0, 0, 1)))

    constructor(mat3: Mat3) : this(mutableListOf(
            Vec3d(mat3[0]),
            Vec3d(mat3[1]),
            Vec3d(mat3[2])))

    constructor(mat4: Mat4) : this(mutableListOf(
            Vec3d(mat4[0]),
            Vec3d(mat4[1]),
            Vec3d(mat4[2])))

    constructor(mat2x3: Mat2x3t<*>) : this(mutableListOf(
            Vec3d(mat2x3[0]),
            Vec3d(mat2x3[1]),
            Vec3d(0, 0, 1)))

    constructor(mat3x2: Mat3x2t<*>) : this(mutableListOf(
            Vec3d(mat3x2[0], 0),
            Vec3d(mat3x2[1], 0),
            Vec3d(mat3x2[2], 1)))

    constructor(mat2x4: Mat2x4t<*>) : this(mutableListOf(
            Vec3d(mat2x4[0]),
            Vec3d(mat2x4[1]),
            Vec3d(0, 0, 1)))

    constructor(mat4x2: Mat4x2t<*>) : this(mutableListOf(
            Vec3d(mat4x2[0], 0),
            Vec3d(mat4x2[1], 0),
            Vec3d(mat4x2[2], 1)))

    constructor(mat3x4: Mat3x4t<*>) : this(mutableListOf(
            Vec3d(mat3x4[0]),
            Vec3d(mat3x4[1]),
            Vec3d(mat3x4[2])))

    constructor(mat4x3: Mat4x3t<*>) : this(mutableListOf(
            Vec3d(mat4x3[0]),
            Vec3d(mat4x3[1]),
            Vec3d(mat4x3[2])))

    @JvmOverloads constructor(floats: DoubleArray, transpose: Boolean = false) : this(
            if (transpose) mutableListOf(
                    Vec3d(floats[0], floats[4], floats[8]),
                    Vec3d(floats[1], floats[5], floats[9]),
                    Vec3d(floats[2], floats[6], floats[10]))
            else mutableListOf(
                    Vec3d(floats, 0),
                    Vec3d(floats, 4),
                    Vec3d(floats, 8)))

    // to
    fun to(mat2x2: Mat2x2t<*>) {
        value = mutableListOf(
                Vec3d(mat2x2[0]),
                Vec3d(mat2x2[1]))
    }

//    fun to(scalar: Number) {
//        value = mutableListOf(
//                Vec3d(scalar.main.getF, 0),
//                Vec3d(0, scalar.main.getF))
//    }
//
//    fun to(x0: Number, x1: Number, y0: Number, y1: Number) {
//        value = mutableListOf(
//                Vec3d(x0.main.getF, y0.main.getF),
//                Vec3d(x1.main.getF, y1.main.getF))
//    }
//
//    fun to(v0: Vec3dt<*>, v1: Vec3dt<*>) {
//        value = mutableListOf(
//                Vec3d(v0),
//                Vec3d(v1))
//    }

    // -- Accesses --

    operator fun set(i: Int, v: Vec3d) = value[i] put v
    operator fun set(c: Int, r: Int, v: Double) {
        value[c][r] = v
    }
    operator fun get(c: Int, r: Int) = value[c][r]

    // -- Matrix functions --

    val det get() = glm.determinant(this)

    @JvmOverloads
    fun inverse(res: Mat3d = Mat3d()) = inverse(res, this)

    fun inverseAssign() = inverse(this, this)

    @JvmOverloads
    fun transpose(res: Mat3d = Mat3d()) = transpose(res, this)

    fun transposeAssign() = transpose(this, this)


    infix fun put(s: Double) = put(s, s, s)
    infix fun put(v: Vec3d) = put(v.x, v.y, v.z)

    fun put(x: Double, y: Double, z: Double): Mat3d {

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
    infix fun to(res: Mat4d): Mat4d {

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

    infix fun to(res: QuatD) = glm.quatD_cast(this, res)
    fun toQuatD() = glm.quatD_cast(this, QuatD())


    infix fun to(dfb: DoubleBuffer) = to(dfb, 0)

    fun to(dfb: DoubleBuffer, offset: Int): DoubleBuffer {
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


    companion object : mat3d_operators() {
        @JvmField
        val size = 3 * 3 * Double.BYTES
    }


    // -- Unary arithmetic operators --

    operator fun unaryPlus() = this

    operator fun unaryMinus() = Mat3d(-value[0], -value[1], -value[2])


// -- Increment main.and decrement operators --

    operator fun inc(res: Mat3d = Mat3d()): Mat3d = plus(res, this, 1.0)
    fun incAssign() = plus(this, this, 1.0)

    operator fun dec(res: Mat3d = Mat3d()): Mat3d = minus(res, this, 1.0)
    fun decAssign() = minus(this, this, 1.0)


// -- Specific binary arithmetic operators --

    infix operator fun plus(b: Double) = plus(Mat3d(), this, b)
    infix operator fun plus(b: Mat3d) = plus(Mat3d(), this, b)

    fun plus(b: Double, res: Mat3d) = plus(res, this, b)
    fun plus(b: Mat3d, res: Mat3d) = plus(res, this, b)

    infix operator fun plusAssign(b: Double) {
        plus(this, this, b)
    }
    infix operator fun plusAssign(b: Mat3d) {
        plus(this, this, b)
    }


    infix operator fun minus(b: Double) = minus(Mat3d(), this, b)
    infix operator fun minus(b: Mat3d) = minus(Mat3d(), this, b)

    fun minus(b: Double, res: Mat3d) = minus(res, this, b)
    fun minus(b: Mat3d, res: Mat3d) = minus(res, this, b)

    infix operator fun minusAssign(b: Double) {
        minus(this, this, b)
    }
    infix operator fun minusAssign(b: Mat3d) {
        minus(this, this, b)
    }


    infix operator fun times(b: Double) = times(Mat3d(), this, b)
    infix operator fun times(b: Vec3d) = times(Vec3d(), this, b)
    infix operator fun times(b: Mat3d) = times(Mat3d(), this, b)

    fun times(b: Double, res: Mat3d) = times(res, this, b)
    fun times(b: Vec3d, res: Vec3d) = times(res, this, b)
    fun times(b: Mat3d, res: Mat3d) = times(res, this, b)

    infix operator fun timesAssign(b: Double) {
        times(this, this, b)
    }
    infix operator fun timesAssign(b: Vec3d) {
        times(b, this, b)
    }
    infix operator fun timesAssign(b: Mat3d) {
        times(this, this, b)
    }


    infix operator fun div(b: Double) = div(Mat3d(), this, b)
    infix operator fun div(b: Mat3d) = div(Mat3d(), this, b)

    fun div(b: Double, res: Mat3d) = div(res, this, b)
    fun div(b: Mat3d, res: Mat3d) = div(res, this, b)

    infix operator fun divAssign(b: Double) {
        div(this, this, b)
    }
    infix operator fun divAssign(b: Mat3d) {
        div(this, this, b)
    }


    infix fun isEqual(b: Mat3d) = this[0].isEqual(b[0]) && this[1].isEqual(b[1]) && this[2].isEqual(b[2])

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


    val isIdentity get() = this[0][0] == 1.0 && this[1][0] == 0.0 && this[2][0] == 0.0 &&
            this[0][1] == 0.0 && this[1][1] == 1.0 && this[2][1] == 0.0 &&
            this[0][2] == 0.0 && this[1][2] == 0.0 && this[2][2] == 1.0


    override fun toString() = super.toString()

    override fun equals(other: Any?) = other is Mat3d &&
            this[0, 0] == other[0, 0] && this[0, 1] == other[0, 1] && this[0, 2] == other[0, 2] &&
            this[1, 0] == other[1, 0] && this[1, 1] == other[1, 1] && this[1, 2] == other[1, 2] &&
            this[2, 0] == other[2, 0] && this[2, 1] == other[2, 1] && this[2, 2] == other[2, 2]
    override fun hashCode() = 31 * (31 * value[0].hashCode() + value[1].hashCode()) + value[2].hashCode()
}