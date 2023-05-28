package  glm_.mat3x3

import glm_.ToDoubleBuffer
import glm_.d
import glm_.glm
import glm_.glm.inverse
import glm_.glm.transpose
import glm_.mat2x2.Mat2
import glm_.mat2x2.Mat2d
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
import glm_.toDouble
import glm_.vec2.Vec2d
import glm_.vec2.Vec2t
import glm_.vec3.Vec3bool
import glm_.vec3.Vec3d
import glm_.vec3.Vec3t
import glm_.vec4.Vec4d
import glm_.vec4.Vec4t
import kool.*
import java.nio.ByteBuffer
import java.nio.DoubleBuffer

/**
 * Created by GBarbieri on 10.11.2016.
 */

class Mat3d private constructor(@Suppress("UNUSED_PARAMETER") dummy: Int, @JvmField var array: DoubleArray) : Mat3x3t<Double>(), ToDoubleBuffer {

    // -- Constructors --

    constructor() : this(1)

    constructor(s: Number) : this(s, s, s)

    constructor(x: Number, y: Number, z: Number) : this(
       x, 0, 0,
       0, y, 0,
       0, 0, z)

    constructor(v: Vec2t<*>) : this(v._x, v._y, 0)
    constructor(v: Vec2t<*>, z: Number) : this(v._x, v._y, z)
    constructor(v: Vec3t<*>) : this(v._x, v._y, v._z)
    constructor(v: Vec4t<*>) : this(v._x, v._y, v._z)

    constructor(x0: Number, y0: Number, z0: Number,
                x1: Number, y1: Number, z1: Number,
                x2: Number, y2: Number, z2: Number) : this(0, doubleArrayOf(
        x0.d, y0.d, z0.d,
        x1.d, y1.d, z1.d,
        x2.d, y2.d, z2.d))

    constructor(v0: Vec3t<out Number>, v1: Vec3t<out Number>, v2: Vec3t<out Number>) : this(
        v0._x, v0._y, v0._z,
        v1._x, v1._y, v1._z,
        v2._x, v2._y, v2._z)

    constructor(block: (Int) -> Number) : this(
        block(0).d, block(1).d, block(2).d,
        block(3).d, block(4).d, block(5).d,
        block(6).d, block(7).d, block(8).d)

    constructor(block: (Int, Int) -> Number) : this(
        block(0, 0).d, block(0, 1).d, block(0, 2).d,
        block(1, 0).d, block(1, 1).d, block(1, 2).d,
        block(2, 0).d, block(2, 1).d, block(2, 2).d)

    constructor(list: Iterable<*>, index: Int = 0) : this(
        list.elementAt(index)!!.toDouble, list.elementAt(index + 1)!!.toDouble, list.elementAt(index + 2)!!.toDouble,
        list.elementAt(index + 3)!!.toDouble, list.elementAt(index + 4)!!.toDouble, list.elementAt(index + 5)!!.toDouble,
        list.elementAt(index + 6)!!.toDouble, list.elementAt(index + 7)!!.toDouble, list.elementAt(index + 8)!!.toDouble)

    constructor(buffer: DoubleBuffer, index: Int = buffer.pos) : this(
        buffer[index], buffer[index + 1], buffer[index + 2],
        buffer[index + 3], buffer[index + 4], buffer[index + 5],
        buffer[index + 6], buffer[index + 7], buffer[index + 8])

    constructor(ptr: Ptr<Double>) : this(block = { i -> ptr[i] })

    // -- Matrix conversions --


    constructor(mat2: Mat2) : this(
        mat2[0, 0], mat2[0, 1], 0f,
        mat2[1, 0], mat2[1, 1], 0f,
        0f, 0f, 1f)

    constructor(mat2: Mat2d) : this(
        mat2[0, 0], mat2[0, 1], 0.0,
        mat2[1, 0], mat2[1, 1], 0.0,
        0.0, 0.0, 1.0)

    constructor(mat3: Mat3) : this(0, DoubleArray(length) { mat3.array[it].d })
    constructor(mat3: Mat3d) : this(0, mat3.array.clone())

    constructor(mat4: Mat4) : this(
        mat4[0, 0], mat4[0, 1], mat4[0, 2],
        mat4[1, 0], mat4[1, 1], mat4[1, 2],
        mat4[2, 0], mat4[2, 1], mat4[2, 2])

    constructor(mat4: Mat4d) : this(
        mat4[0, 0], mat4[0, 1], mat4[0, 2],
        mat4[1, 0], mat4[1, 1], mat4[1, 2],
        mat4[2, 0], mat4[2, 1], mat4[2, 2])

    constructor(mat2x3: Mat2x3t<*>) : this(
        mat2x3[0, 0], mat2x3[0, 1], mat2x3[0, 2],
        mat2x3[1, 0], mat2x3[1, 1], mat2x3[1, 2],
        0, 0, 1)

    constructor(mat3x2: Mat3x2t<*>) : this(
        mat3x2[0, 0], mat3x2[0, 1], 0,
        mat3x2[1, 0], mat3x2[1, 1], 0,
        mat3x2[2, 0], mat3x2[2, 1], 1)

    constructor(mat2x4: Mat2x4t<*>) : this(
        mat2x4[0, 0], mat2x4[0, 1], mat2x4[0, 2],
        mat2x4[1, 0], mat2x4[1, 1], mat2x4[1, 2],
        0, 0, 1)

    constructor(mat4x2: Mat4x2t<*>) : this(
        mat4x2[0, 0], mat4x2[0, 1], 0,
        mat4x2[1, 0], mat4x2[1, 1], 0,
        mat4x2[2, 0], mat4x2[2, 1], 1)

    constructor(mat3x4: Mat3x4t<*>) : this(
        mat3x4[0, 0], mat3x4[0, 1], mat3x4[0, 2],
        mat3x4[1, 0], mat3x4[1, 1], mat3x4[1, 2],
        mat3x4[2, 0], mat3x4[2, 1], mat3x4[2, 2])

    constructor(mat4x3: Mat4x3t<*>) : this(
        mat4x3[0, 0], mat4x3[0, 1], mat4x3[0, 2],
        mat4x3[1, 0], mat4x3[1, 1], mat4x3[1, 2],
        mat4x3[2, 0], mat4x3[2, 1], mat4x3[2, 2])

    @JvmOverloads
    constructor(doubles: DoubleArray, transpose: Boolean = false) : this(0,
                                                                         if (transpose) doubleArrayOf(
                                                                             doubles[0], doubles[3], doubles[6],
                                                                             doubles[1], doubles[4], doubles[7],
                                                                             doubles[2], doubles[5], doubles[8])
                                                                         else doubles.clone())

    // to
//    fun to(mat2x2: Mat2x2t<*>) {
//        mat2x2[0, 0] = array[0]; mat2x2[0, 1] = array[1]
//        mat2x2[1, 0] = array[3]; mat2x2[1, 1] = array[4]
//    }

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

    override operator fun get(index: Int) = Vec3d(index * 3, array)
    override operator fun get(column: Int, row: Int) = array[column * 3 + row]

    override operator fun set(column: Int, row: Int, value: Double) = array.set(column * 3 + row, value)
    override operator fun set(index: Int, value: Vec3t<out Number>) {
        array[index * 3] = value._x.d
        array[index * 3 + 1] = value._y.d
        array[index * 3 + 2] = value._z.d
    }

    operator fun set(i: Int, v: Vec3d) {
        v.to(array, i * 3)
    }


    // -- Matrix functions --

    val det get() = glm.determinant(this)

    @JvmOverloads
    fun inverse(res: Mat3d = Mat3d()) = inverse(res, this)

    fun inverseAssign() = inverse(this, this)

    @JvmOverloads
    fun transpose(res: Mat3d = Mat3d()) = transpose(res, this)

    fun transposeAssign() = transpose(this, this)

    @JvmOverloads
    fun inverseTranspose(res: Mat3d = Mat3d()) = glm.inverseTranspose(res, this)

    fun inverseTransposeAssign() = glm.inverseTranspose(this, this)


    infix operator fun invoke(s: Double) = invoke(s, s, s)

    infix operator fun invoke(v: Vec2d) = invoke(v.x, v.y, 1.0)
    infix operator fun invoke(v: Vec3d) = invoke(v.x, v.y, v.z)
    infix operator fun invoke(v: Vec4d) = invoke(v.x, v.y, v.z)

    infix operator fun invoke(doubles: DoubleArray) = invoke(doubles[0], doubles[1], doubles[2], doubles[3], doubles[4], doubles[5], doubles[6], doubles[7], doubles[8])

    infix operator fun invoke(mat2: Mat2) = invoke(
        mat2[0, 0].d, mat2[0, 1].d, 0.0,
        mat2[1, 0].d, mat2[1, 1].d, 0.0,
        0.0, 0.0, 1.0)

    infix operator fun invoke(mat2: Mat2d) = invoke(
        mat2[0, 0], mat2[0, 1], 0.0,
        mat2[1, 0], mat2[1, 1], 0.0,
        0.0, 0.0, 1.0)

    infix operator fun invoke(mat3: Mat3) = invoke(DoubleArray(length) { mat3.array[it].d })
    infix operator fun invoke(mat3: Mat3d) = invoke(mat3.array.clone())

    infix operator fun invoke(mat4: Mat4) = invoke(
        mat4[0, 0].d, mat4[0, 1].d, mat4[0, 2].d,
        mat4[1, 0].d, mat4[1, 1].d, mat4[1, 2].d,
        mat4[2, 0].d, mat4[2, 1].d, mat4[2, 2].d)

    infix operator fun invoke(mat4: Mat4d) = invoke(
        mat4[0, 0], mat4[0, 1], mat4[0, 2],
        mat4[1, 0], mat4[1, 1], mat4[1, 2],
        mat4[2, 0], mat4[2, 1], mat4[2, 2])

    operator fun invoke(x: Double, y: Double, z: Double) = invoke(
        x, 0.0, 0.0,
        0.0, y, 0.0,
        0.0, 0.0, z)

    operator fun invoke(x: Number, y: Number, z: Number) = invoke(
        x.d, 0.0, 0.0,
        0.0, y.d, 0.0,
        0.0, 0.0, z.d)

    operator fun invoke(a0: Double, a1: Double, a2: Double,
                        b0: Double, b1: Double, b2: Double,
                        c0: Double, c1: Double, c2: Double): Mat3d {

        put(a0, a1, a2, b0, b1, b2, c0, c1, c2)
        return this
    }

    operator fun invoke(a0: Number, a1: Number, a2: Number,
                        b0: Number, b1: Number, b2: Number,
                        c0: Number, c1: Number, c2: Number): Mat3d {

        put(a0.d, a1.d, a2.d, b0.d, b1.d, b2.d, c0.d, c1.d, c2.d)
        return this
    }


    infix fun put(mat3: Mat3d) = System.arraycopy(mat3.array.clone(), 0, array, 0, length)

    fun identity() = invoke(1.0)
    infix fun put(s: Double) = put(s, s, s)
    infix fun put(v: Vec2d) = put(v.x, v.y, 1.0)
    infix fun put(v: Vec3d) = put(v.x, v.y, v.z)
    infix fun put(v: Vec4d) = put(v.x, v.y, v.z)

    infix fun put(doubles: DoubleArray) = put(doubles[0], doubles[1], doubles[2], doubles[3], doubles[4], doubles[5], doubles[6], doubles[7], doubles[8])

    fun put(x: Double, y: Double, z: Double) = put(
        x, 0.0, 0.0,
        0.0, y, 0.0,
        0.0, 0.0, z)

    fun put(a0: Double, a1: Double, a2: Double,
            b0: Double, b1: Double, b2: Double,
            c0: Double, c1: Double, c2: Double) {

        array[0] = a0
        array[1] = a1
        array[2] = a2

        array[3] = b0
        array[4] = b1
        array[5] = b2

        array[6] = c0
        array[7] = c1
        array[8] = c2
    }

    // TODO others
    infix fun to(res: Mat4d): Mat4d {

        res[0, 0] = this[0, 0]
        res[0, 1] = this[0, 1]
        res[0, 2] = this[0, 2]
        res[0, 3] = 0.0

        res[1, 0] = this[1, 0]
        res[1, 1] = this[1, 1]
        res[1, 2] = this[1, 2]
        res[1, 3] = 0.0

        res[2, 0] = this[2, 0]
        res[2, 1] = this[2, 1]
        res[2, 2] = this[2, 2]
        res[2, 3] = 0.0

        res[3, 0] = 0.0
        res[3, 1] = 0.0
        res[3, 2] = 0.0
        res[3, 3] = 1.0

        return res
    }

    fun toMat4(): Mat4d = to(Mat4d())

    infix fun to(res: QuatD): QuatD = glm.quatD_cast(this, res)
    fun toQuatD(): QuatD = glm.quatD_cast(this, QuatD())

    fun toDoubleArray(): DoubleArray = to(DoubleArray(length), 0)
    infix fun to(doubles: DoubleArray): DoubleArray = to(doubles, 0)
    fun to(doubles: DoubleArray, index: Int): DoubleArray {
        System.arraycopy(array, 0, doubles, index, length)
        return doubles
    }

    override fun to(buf: ByteBuffer, offset: Int): ByteBuffer {
        return buf
            .putDouble(offset + 0 * Double.BYTES, array[0])
            .putDouble(offset + 1 * Double.BYTES, array[1])
            .putDouble(offset + 2 * Double.BYTES, array[2])
            .putDouble(offset + 3 * Double.BYTES, array[3])
            .putDouble(offset + 4 * Double.BYTES, array[4])
            .putDouble(offset + 5 * Double.BYTES, array[5])
            .putDouble(offset + 6 * Double.BYTES, array[6])
            .putDouble(offset + 7 * Double.BYTES, array[7])
            .putDouble(offset + 8 * Double.BYTES, array[8])
    }

    override fun to(buf: DoubleBuffer, offset: Int): DoubleBuffer {
        buf[offset + 0] = array[0]
        buf[offset + 1] = array[1]
        buf[offset + 2] = array[2]
        buf[offset + 3] = array[3]
        buf[offset + 4] = array[4]
        buf[offset + 5] = array[5]
        buf[offset + 6] = array[6]
        buf[offset + 7] = array[7]
        buf[offset + 8] = array[8]
        return buf
    }

    fun to(ptr: Ptr<Double>, transpose: Boolean = false) {
        when {
            transpose -> {
                ptr[0] = get(0, 0); ptr[1] = get(1, 0); ptr[2] = get(2, 0)
                ptr[3] = get(0, 1); ptr[4] = get(1, 1); ptr[5] = get(2, 1)
                ptr[6] = get(0, 2); ptr[7] = get(1, 2); ptr[8] = get(2, 2)
            }

            else -> {
                ptr[0] = get(0, 0); ptr[1] = get(0, 1); ptr[2] = get(0, 2)
                ptr[3] = get(1, 0); ptr[4] = get(1, 1); ptr[5] = get(1, 2)
                ptr[6] = get(2, 0); ptr[7] = get(2, 1); ptr[8] = get(2, 2)
            }
        }
    }

    // -- Unary arithmetic operators --

    operator fun unaryPlus() = this

    operator fun unaryMinus() = Mat3d(-array[0], -array[1], -array[2],
                                      -array[3], -array[4], -array[5],
                                      -array[6], -array[7], -array[8])


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

    @JvmOverloads
    fun rotateX(angle: Double, res: Mat3d = Mat3d()) = glm.rotateX(this, angle, res)

    @JvmOverloads
    fun rotateY(angle: Double, res: Mat3d = Mat3d()) = glm.rotateY(this, angle, res)

    @JvmOverloads
    fun rotateZ(angle: Double, res: Mat3d = Mat3d()) = glm.rotateZ(this, angle, res)

    @JvmOverloads
    fun rotateXYZ(angle: Vec3d, res: Mat3d = Mat3d()) = glm.rotateXYZ(this, angle.x, angle.y, angle.z, res)

    @JvmOverloads
    fun rotateXYZ(angleX: Double, angleY: Double, angleZ: Double, res: Mat3d = Mat3d()) = glm.rotateXYZ(this, angleX, angleY, angleZ, res)

    fun rotateXassign(angle: Double) = glm.rotateX(this, angle, this)
    fun rotateYassign(angle: Double) = glm.rotateY(this, angle, this)
    fun rotateZassign(angle: Double) = glm.rotateZ(this, angle, this)
    fun rotateXYZassign(angle: Vec3d) = glm.rotateXYZ(this, angle.x, angle.y, angle.z, this)
    fun rotateXYZassign(angleX: Double, angleY: Double, angleZ: Double) = glm.rotateXYZ(this, angleX, angleY, angleZ, this)


//    infix fun isEqual(b: Mat3d) = this[0].isEqual(b[0]) && this[1].isEqual(b[1]) && this[2].isEqual(b[2])

    // TODO others
    override var a0: Double
        get() = array[0]
        set(v) = array.set(0, v)
    override var a1: Double
        get() = array[1]
        set(v) = array.set(1, v)
    override var a2: Double
        get() = array[2]
        set(v) = array.set(2, v)

    override var b0: Double
        get() = array[3]
        set(v) = array.set(3, v)
    override var b1: Double
        get() = array[4]
        set(v) = array.set(4, v)
    override var b2: Double
        get() = array[5]
        set(v) = array.set(5, v)

    override var c0: Double
        get() = array[6]
        set(v) = array.set(6, v)
    override var c1: Double
        get() = array[7]
        set(v) = array.set(7, v)
    override var c2: Double
        get() = array[8]
        set(v) = array.set(8, v)


    override val isIdentity
        get() = this[0, 0] == 1.0 && this[1, 0] == 0.0 && this[2, 0] == 0.0 &&
                this[0, 1] == 0.0 && this[1, 1] == 1.0 && this[2, 1] == 0.0 &&
                this[0, 2] == 0.0 && this[1, 2] == 0.0 && this[2, 2] == 1.0

    companion object : mat3d_operators {
        const val length = Mat3x3t.length

        @JvmField
        val size = length * Double.BYTES

        @JvmStatic
        fun fromPointer(ptr: Ptr<Double>, transpose: Boolean = false): Mat3d = when {
            transpose -> Mat3d(ptr[0], ptr[3], ptr[6],
                               ptr[1], ptr[4], ptr[7],
                               ptr[2], ptr[5], ptr[8])

            else -> Mat3d(ptr)
        }

        val identity: Mat3d
            get() = Mat3d(1.0)
    }

    override fun size() = size

    override fun elementCount() = length

    override fun equals(other: Any?) = other is Mat3d && array.contentEquals(other.array)
    override fun hashCode() = 31 * (31 * this[0].hashCode() + this[1].hashCode()) + this[2].hashCode()

    fun equal(b: Mat3d, epsilon: Double, res: Vec3bool = Vec3bool()): Vec3bool = glm.equal(this, b, epsilon, res)
    fun equal(b: Mat3d, epsilon: Vec3d, res: Vec3bool = Vec3bool()): Vec3bool = glm.equal(this, b, epsilon, res)
    fun notEqual(b: Mat3d, epsilon: Double, res: Vec3bool = Vec3bool()): Vec3bool = glm.notEqual(this, b, epsilon, res)
    fun notEqual(b: Mat3d, epsilon: Vec3d, res: Vec3bool = Vec3bool()): Vec3bool = glm.notEqual(this, b, epsilon, res)
    fun allEqual(b: Mat3d, epsilon: Double = glm.ε): Boolean = glm.allEqual(this, b, epsilon)
    fun anyNotEqual(b: Mat3d, epsilon: Double = glm.ε): Boolean = glm.anyNotEqual(this, b, epsilon)
}
