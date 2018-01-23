package glm_.mat2x2

import glm_.*
import glm_.mat2x2.operators.mat2d_operators
import glm_.mat2x3.Mat2x3t
import glm_.mat2x4.Mat2x4t
import glm_.mat3x2.Mat3x2d
import glm_.mat3x2.Mat3x2t
import glm_.mat3x3.Mat3
import glm_.mat4x2.Mat4x2d
import glm_.mat4x2.Mat4x2t
import glm_.mat4x4.Mat4
import glm_.vec2.Vec2d
import glm_.vec2.Vec2t
import java.nio.DoubleBuffer

/**
 * Created by GBarbieri on 10.11.2016.
 */
data class Mat2d(override var value: MutableList<Vec2d>) : Mat2x2t<Vec2d>(value) {

    // -- Constructors --

    constructor() : this(mutableListOf(
            Vec2d(1, 0),
            Vec2d(0, 1)))

    constructor(scalar: Number) : this(mutableListOf(
            Vec2d(scalar, 0),
            Vec2d(0, scalar)))

    constructor(x0: Number, y0: Number,
                x1: Number, y1: Number) : this(mutableListOf(
            Vec2d(x0, y0),
            Vec2d(x1, y1)))

    constructor(v0: Vec2t<out Number>, v1: Vec2t<out Number>) : this(mutableListOf(
            Vec2d(v0),
            Vec2d(v1)))

    constructor(block: (Int) -> Number): this(block(0).d, block(1).d, block(2).d, block(3).d)

    constructor(list: Iterable<*>, index: Int = 0) : this(list.elementAt(index)!!.toDouble, list.elementAt(index + 1)!!.toDouble,
            list.elementAt(index + 2)!!.toDouble, list.elementAt(index + 3)!!.toDouble)

    // -- Matrix conversions --

    constructor(mat2x2: Mat2x2t<*>) : this(mutableListOf(
            Vec2d(mat2x2[0]),
            Vec2d(mat2x2[1])))

    constructor(mat3: Mat3) : this(mutableListOf(
            Vec2d(mat3[0]),
            Vec2d(mat3[1])))

    constructor(mat4: Mat4) : this(mutableListOf(
            Vec2d(mat4[0]),
            Vec2d(mat4[1])))

    constructor(mat2x3: Mat2x3t<*>) : this(mutableListOf(
            Vec2d(mat2x3[0]),
            Vec2d(mat2x3[1])))

    constructor(mat3x2: Mat3x2t<*>) : this(mutableListOf(
            Vec2d(mat3x2[0]),
            Vec2d(mat3x2[1])))

    constructor(mat2x4: Mat2x4t<*>) : this(mutableListOf(
            Vec2d(mat2x4[0]),
            Vec2d(mat2x4[1])))

    constructor(mat4x2: Mat4x2t<*>) : this(mutableListOf(
            Vec2d(mat4x2[0]),
            Vec2d(mat4x2[1])))

    // to
    fun to(mat2x2: Mat2x2t<*>) {
        value = mutableListOf(
                Vec2d(mat2x2.value[0]),
                Vec2d(mat2x2.value[1]))
    }

    fun to(scalar: Number) {
        value = mutableListOf(
                Vec2d(scalar.d, 0),
                Vec2d(0, scalar.d))
    }

    fun to(x0: Number, x1: Number, y0: Number, y1: Number) {
        value = mutableListOf(
                Vec2d(x0.d, y0.d),
                Vec2d(x1.d, y1.d))
    }

    fun to(v0: Vec2t<*>, v1: Vec2t<*>) {
        value = mutableListOf(
                Vec2d(v0),
                Vec2d(v1))
    }

    // -- Accesses --

    operator fun set(i: Int, v: Vec2d) = value[i] put v
    operator fun set(c: Int, r: Int, v: Double) {
        value[c][r] = v
    }
    operator fun get(c: Int, r: Int) = value[c][r]

    // -- Matrix functions --

    val det get() = glm.determinant(this)

    fun inverse(res: Mat2d = Mat2d()) = glm.inverse(res, this)
    fun inverseAssign() = glm.inverse(this, this)

    fun transpose(res: Mat2d = Mat2d()) = glm.transpose(res, this)
    fun transposeAssign() = glm.transpose(this, this)

    // TODO inc


    fun identity(): Mat2d {
        value[0][0] = 1f; value[1][0] = 0f
        value[0][1] = 0f; value[1][1] = 1f
        return this
    }

    infix fun to(dfb: DoubleBuffer) = to(dfb, 0)

    fun to(dfb: DoubleBuffer, offset: Int): DoubleBuffer {
        dfb[offset + 0] = value[0][0]
        dfb[offset + 1] = value[0][1]
        dfb[offset + 2] = value[1][0]
        dfb[offset + 3] = value[1][1]
        return dfb
    }


    companion object : mat2d_operators() {
        @JvmField
        val size = 2 * 2 * Double.BYTES
    }


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


    val isIdentity get() = this[0][0] == 1.0 && this[1][0] == 0.0 && this[0][1] == 0.0 && this[1][1] == 1.0


    override fun toString() = super.toString()

    override fun equals(other: Any?) = other is Mat2d &&
            this[0, 0] == other[0, 0] && this[0, 1] == other[0, 1] &&
            this[1, 0] == other[1, 0] && this[1, 1] == other[1, 1]
    override fun hashCode() = 31 * value[0].hashCode() + value[1].hashCode()
}