package  glm_.mat4x4

import glm_.*
import glm_.glm.inverse
import glm_.glm.transpose
import glm_.mat2x2.Mat2
import glm_.mat2x2.Mat2d
import glm_.mat2x2.Mat2x2t
import glm_.mat2x3.Mat2x3t
import glm_.mat2x4.Mat2x4t
import glm_.mat3x2.Mat3x2t
import glm_.mat3x3.Mat3
import glm_.mat3x3.Mat3d
import glm_.mat3x4.Mat3x4t
import glm_.mat4x2.Mat4x2t
import glm_.mat4x3.Mat4x3t
import glm_.mat4x4.operators.mat4d_operators
import glm_.quat.QuatD
import glm_.vec2.Vec2d
import glm_.vec2.Vec2t
import glm_.vec3.Vec3d
import glm_.vec3.Vec3t
import glm_.vec4.Vec4bool
import glm_.vec4.Vec4d
import glm_.vec4.Vec4t
import kool.*
import java.nio.ByteBuffer
import java.nio.DoubleBuffer

/**
 * Created by GBarbieri on 10.11.2016.
 */
class Mat4d private constructor(@Suppress("UNUSED_PARAMETER") dummy: Int, @JvmField var array: DoubleArray) : Mat4x4t<Double>(), ToDoubleBuffer {

    // -- Constructors --

    constructor() : this(1)

    constructor(s: Number) : this(s, s, s, s)

    constructor(x: Number, y: Number, z: Number, w: Number) : this(
        x, 0, 0, 0,
        0, y, 0, 0,
        0, 0, z, 0,
        0, 0, 0, w)

    // TODO others

    constructor(v: Vec2t<*>) : this(v._x, v._y, 0, 1)
    constructor(v: Vec2t<*>, z: Number) : this(v._x, v._y, z, 1)
    constructor(v: Vec2t<*>, z: Number, w: Number) : this(v._x, v._y, z, w)
    constructor(v: Vec3t<*>) : this(v._x, v._y, v._z, 1)
    constructor(v: Vec3t<*>, w: Number) : this(v._x, v._y, v._z, w)
    constructor(v: Vec4t<*>) : this(v._x, v._y, v._z, v._w)

    constructor(x0: Number, y0: Number, z0: Number, w0: Number,
                x1: Number, y1: Number, z1: Number, w1: Number,
                x2: Number, y2: Number, z2: Number, w2: Number,
                x3: Number, y3: Number, z3: Number, w3: Number) : this(0, doubleArrayOf(
            x0.d, y0.d, z0.d, w0.d,
            x1.d, y1.d, z1.d, w1.d,
            x2.d, y2.d, z2.d, w2.d,
            x3.d, y3.d, z3.d, w3.d))

    constructor(v0: Vec4t<out Number>, v1: Vec4t<out Number>, v2: Vec4t<out Number>, v3: Vec4t<out Number>) : this(
            v0._x, v0._y, v0._z, v0._w,
            v1._x, v1._y, v1._z, v1._w,
            v2._x, v2._y, v2._z, v2._w,
            v3._x, v3._y, v3._z, v3._w)

    constructor(block: (Int) -> Number) : this(
            block(0).d, block(1).d, block(2).d, block(3).d,
            block(4).d, block(5).d, block(6).d, block(7).d,
            block(8).d, block(9).d, block(10).d, block(11).d,
            block(12).d, block(13).d, block(14).d, block(15).d)

    constructor(block: (Int, Int) -> Number) : this(
            block(0, 0).d, block(0, 1).d, block(0, 2).d, block(0, 3).d,
            block(1, 0).d, block(1, 1).d, block(1, 2).d, block(1, 3).d,
            block(2, 0).d, block(2, 1).d, block(2, 2).d, block(2, 3).d,
            block(3, 0).d, block(3, 1).d, block(3, 2).d, block(3, 3).d)

    constructor(list: Iterable<*>, index: Int = 0) : this(
            list.elementAt(index)!!.toDouble, list.elementAt(index + 1)!!.toDouble, list.elementAt(index + 2)!!.toDouble, list.elementAt(index + 3)!!.toDouble,
            list.elementAt(index + 4)!!.toDouble, list.elementAt(index + 5)!!.toDouble, list.elementAt(index + 6)!!.toDouble, list.elementAt(index + 7)!!.toDouble,
            list.elementAt(index + 8)!!.toDouble, list.elementAt(index + 9)!!.toDouble, list.elementAt(index + 10)!!.toDouble, list.elementAt(index + 11)!!.toDouble,
            list.elementAt(index + 12)!!.toDouble, list.elementAt(index + 13)!!.toDouble, list.elementAt(index + 14)!!.toDouble, list.elementAt(index + 15)!!.toDouble)

    constructor(buffer: DoubleBuffer, index: Int = buffer.pos) : this(
            buffer[index], buffer[index + 1], buffer[index + 2], buffer[index + 3],
            buffer[index + 4], buffer[index + 5], buffer[index + 6], buffer[index + 7],
            buffer[index + 8], buffer[index + 9], buffer[index + 10], buffer[index + 11],
            buffer[index + 12], buffer[index + 13], buffer[index + 14], buffer[index + 15])

    constructor(ptr: Ptr<Double>) : this(block = { i -> ptr[i] })

    // -- Matrix conversions --

    constructor(mat2: Mat2) : this(
            mat2[0, 0], mat2[0, 1], 0f, 0f,
            mat2[1, 0], mat2[1, 1], 0f, 0f,
            0f, 0f, 1f, 0f,
            0f, 0f, 0f, 1f)

    constructor(mat2: Mat2d) : this(
            mat2[0, 0], mat2[0, 1], 0.0, 0.0,
            mat2[1, 0], mat2[1, 1], 0.0, 0.0,
            0.0, 0.0, 1.0, 0.0,
            0.0, 0.0, 0.0, 1.0)

    constructor(mat3: Mat3) : this(
            mat3[0, 0], mat3[0, 1], mat3[0, 2], 0,
            mat3[1, 0], mat3[1, 1], mat3[1, 2], 0,
            mat3[2, 0], mat3[2, 1], mat3[2, 2], 0,
            0, 0, 0, 1)

    constructor(mat3: Mat3d) : this(
            mat3[0, 0], mat3[0, 1], mat3[0, 2], 0,
            mat3[1, 0], mat3[1, 1], mat3[1, 2], 0,
            mat3[2, 0], mat3[2, 1], mat3[2, 2], 0,
            0, 0, 0, 1)

    constructor(mat4: Mat4) : this(0, DoubleArray(length) { mat4.array[it].d })
    constructor(mat4: Mat4d) : this(0, mat4.array.clone())

    constructor(mat2x3: Mat2x3t<*>) : this(
            mat2x3[0, 0], mat2x3[0, 1], mat2x3[0, 2], 0,
            mat2x3[1, 0], mat2x3[1, 1], mat2x3[1, 2], 0,
            0, 0, 0, 1,
            0, 0, 0, 1)

    constructor(mat3x2: Mat3x2t<*>) : this(
            mat3x2[0, 0], mat3x2[0, 1], 0, 0,
            mat3x2[1, 0], mat3x2[1, 1], 0, 0,
            mat3x2[2, 0], mat3x2[2, 1], 1, 0,
            0, 0, 0, 1)

    constructor(mat2x4: Mat2x4t<*>) : this(
            mat2x4[0, 0], mat2x4[0, 1], mat2x4[0, 2], mat2x4[0, 3],
            mat2x4[1, 0], mat2x4[1, 1], mat2x4[1, 2], mat2x4[1, 3],
            0, 0, 1, 0,
            0, 0, 0, 1)

    constructor(mat4x2: Mat4x2t<*>) : this(
            mat4x2[0, 0], mat4x2[0, 1], 0, 0,
            mat4x2[1, 0], mat4x2[1, 1], 0, 0,
            mat4x2[2, 0], mat4x2[2, 1], 1, 0,
            mat4x2[3, 0], mat4x2[3, 1], 0, 1)

    constructor(mat3x4: Mat3x4t<*>) : this(
            mat3x4[0, 0], mat3x4[0, 1], mat3x4[0, 2], mat3x4[0, 3],
            mat3x4[1, 0], mat3x4[1, 1], mat3x4[1, 2], mat3x4[1, 3],
            mat3x4[2, 0], mat3x4[2, 1], mat3x4[2, 2], mat3x4[2, 3],
            0, 0, 0, 1)

    constructor(mat4x3: Mat4x3t<*>) : this(
            mat4x3[0, 0], mat4x3[0, 1], mat4x3[0, 2], 0,
            mat4x3[1, 0], mat4x3[1, 1], mat4x3[1, 2], 0,
            mat4x3[2, 0], mat4x3[2, 1], mat4x3[2, 2], 0,
            mat4x3[3, 0], mat4x3[3, 1], mat4x3[3, 2], 1)

    // TODO others
    @JvmOverloads
    constructor(doubles: DoubleArray, transpose: Boolean = false) : this(0,
            if (transpose) doubleArrayOf(
                    doubles[0], doubles[4], doubles[8], doubles[12],
                    doubles[1], doubles[5], doubles[9], doubles[13],
                    doubles[2], doubles[6], doubles[10], doubles[14],
                    doubles[3], doubles[7], doubles[11], doubles[15])
            else doubles.clone())


    fun put(v0: Vec4d, v1: Vec4d, v2: Vec4d, v3: Vec4d) {
        v0.to(array, 0)
        v1.to(array, 4)
        v2.to(array, 8)
        v3.to(array, 12)
    }

    // TODO others
    infix operator fun invoke(s: Double) = invoke(s, s, s, s)

    infix operator fun invoke(v: Vec2d) = invoke(v.x, v.y, 1.0, 1.0)
    infix operator fun invoke(v: Vec3d) = invoke(v.x, v.y, v.z, 1.0)
    infix operator fun invoke(v: Vec4d) = invoke(v.x, v.y, v.z, v.w)

    infix operator fun invoke(doubles: DoubleArray) = invoke(
            doubles[0], doubles[1], doubles[2], doubles[3],
            doubles[4], doubles[5], doubles[6], doubles[7],
            doubles[8], doubles[9], doubles[10], doubles[11],
            doubles[12], doubles[13], doubles[14], doubles[15])

    infix operator fun invoke(mat2: Mat2) = invoke(
            mat2[0, 0].d, mat2[0, 1].d, 0.0, 0.0,
            mat2[1, 0].d, mat2[1, 1].d, 0.0, 0.0,
            0.0, 0.0, 1.0, 0.0,
            0.0, 0.0, 0.0, 1.0)

    infix operator fun invoke(mat2: Mat2d) = invoke(
            mat2[0, 0], mat2[0, 1], 0.0, 0.0,
            mat2[1, 0], mat2[1, 1], 0.0, 0.0,
            0.0, 0.0, 1.0, 0.0,
            0.0, 0.0, 0.0, 1.0)

    infix operator fun invoke(mat3: Mat3) = invoke(
            mat3[0, 0].d, mat3[0, 1].d, mat3[0, 2].d, 0.0,
            mat3[1, 0].d, mat3[1, 1].d, mat3[1, 2].d, 0.0,
            mat3[2, 0].d, mat3[2, 1].d, mat3[2, 2].d, 0.0,
            0.0, 0.0, 0.0, 1.0)

    infix operator fun invoke(mat3: Mat3d) = invoke(
            mat3[0, 0], mat3[0, 1], mat3[0, 2], 0.0,
            mat3[1, 0], mat3[1, 1], mat3[1, 2], 0.0,
            mat3[2, 0], mat3[2, 1], mat3[2, 2], 0.0,
            0.0, 0.0, 0.0, 1.0)

    infix operator fun invoke(mat4: Mat4) = invoke(DoubleArray(length) { mat4.array[it].d })
    infix operator fun invoke(mat4: Mat4d) = invoke(mat4.array.clone())

    operator fun invoke(x: Double, y: Double, z: Double, w: Double) = invoke(
            x, 0.0, 0.0, 0.0,
            0.0, y, 0.0, 0.0,
            0.0, 0.0, z, 0.0,
            0.0, 0.0, 0.0, w)

    operator fun invoke(x: Number, y: Number, z: Number, w: Number) = invoke(
            x.d, 0.0, 0.0, 0.0,
            0.0, y.d, 0.0, 0.0,
            0.0, 0.0, z.d, 0.0,
            0.0, 0.0, 0.0, w.d)

    fun invoke(a0: Double, a1: Double, a2: Double, a3: Double,
               b0: Double, b1: Double, b2: Double, b3: Double,
               c0: Double, c1: Double, c2: Double, c3: Double,
               d0: Double, d1: Double, d2: Double, d3: Double): Mat4d {

        put(a0, a1, a2, a3, b0, b1, b2, b3, c0, c1, c2, c3, d0, d1, d2, d3)
        return this
    }

    fun invoke(a0: Number, a1: Number, a2: Number, a3: Number,
               b0: Number, b1: Number, b2: Number, b3: Number,
               c0: Number, c1: Number, c2: Number, c3: Number,
               d0: Number, d1: Number, d2: Number, d3: Number): Mat4d {

        put(a0.d, a1.d, a2.d, a3.d, b0.d, b1.d, b2.d, b3.d, c0.d, c1.d, c2.d, c3.d, d0.d, d1.d, d2.d, d3.d)
        return this
    }

    infix fun put(mat4: Mat4d) = System.arraycopy(mat4.array.clone(), 0, array, 0, 16)

    fun identity() = invoke(1.0)
    infix fun put(s: Double) = put(s, s, s, s)
    infix fun put(v: Vec2d) = put(v.x, v.y, 1.0, 1.0)
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
            d0: Double, d1: Double, d2: Double, d3: Double) {

        array[0] = a0
        array[1] = a1
        array[2] = a2
        array[3] = a3

        array[4] = b0
        array[5] = b1
        array[6] = b2
        array[7] = b3

        array[8] = c0
        array[9] = c1
        array[10] = c2
        array[11] = c3

        array[12] = d0
        array[13] = d1
        array[14] = d2
        array[15] = d3
    }

    // TODO others
    fun toMat3() = to(Mat3d())

    infix fun to(res: Mat3d): Mat3d {

        res[0, 0] = this[0, 0]
        res[0, 1] = this[0, 1]
        res[0, 2] = this[0, 2]

        res[1, 0] = this[1, 0]
        res[1, 1] = this[1, 1]
        res[1, 2] = this[1, 2]

        res[2, 0] = this[2, 0]
        res[2, 1] = this[2, 1]
        res[2, 2] = this[2, 2]

        return res
    }

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
                .putDouble(offset + 9 * Double.BYTES, array[9])
                .putDouble(offset + 10 * Double.BYTES, array[10])
                .putDouble(offset + 11 * Double.BYTES, array[11])
                .putDouble(offset + 12 * Double.BYTES, array[12])
                .putDouble(offset + 13 * Double.BYTES, array[13])
                .putDouble(offset + 14 * Double.BYTES, array[14])
                .putDouble(offset + 15 * Double.BYTES, array[15])
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
        buf[offset + 9] = array[9]
        buf[offset + 10] = array[10]
        buf[offset + 11] = array[11]
        buf[offset + 12] = array[12]
        buf[offset + 13] = array[13]
        buf[offset + 14] = array[14]
        buf[offset + 15] = array[15]
        return buf
    }

    infix fun to(res: QuatD) = glm.quatD_cast(this, res)
    fun toQuatD() = glm.quatD_cast(this, QuatD())

    fun to(ptr: Ptr<Double>, transpose: Boolean = false) {
        when {
            transpose -> {
                ptr[0] = get(0, 0); ptr[1] = get(1, 0); ptr[2] = get(2, 0); ptr[3] = get(3, 0)
                ptr[4] = get(0, 1); ptr[5] = get(1, 1); ptr[6] = get(2, 1); ptr[7] = get(3, 1)
                ptr[8] = get(0, 2); ptr[9] = get(1, 2); ptr[10] = get(2, 2); ptr[11] = get(3, 2)
                ptr[12] = get(0, 3); ptr[13] = get(1, 3); ptr[14] = get(2, 3); ptr[15] = get(3, 3)
            }

            else -> {
                ptr[0] = get(0, 0); ptr[1] = get(0, 1); ptr[2] = get(0, 2); ptr[3] = get(0, 3)
                ptr[4] = get(1, 0); ptr[5] = get(1, 1); ptr[6] = get(1, 2); ptr[7] = get(1, 3)
                ptr[8] = get(2, 0); ptr[9] = get(2, 1); ptr[10] = get(2, 2); ptr[11] = get(2, 3)
                ptr[12] = get(3, 0); ptr[13] = get(3, 1); ptr[14] = get(3, 2); ptr[15] = get(3, 3)
            }
        }
    }
    
    // -- put --

    fun put(mat2x2: Mat2x2t<*>) {
        array[0] = mat2x2[0, 0].d
        array[1] = mat2x2[0, 1].d
        array[2] = 0.0
        array[3] = 0.0

        array[4] = mat2x2[1, 0].d
        array[5] = mat2x2[1, 1].d
        array[6] = 0.0
        array[7] = 0.0

        array[8] = 0.0
        array[9] = 0.0
        array[10] = 0.0
        array[11] = 0.0

        array[12] = 0.0
        array[13] = 0.0
        array[14] = 0.0
        array[15] = 0.0
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

    override operator fun get(index: Int) = Vec4d(index * 4, array)
    override operator fun get(column: Int, row: Int) = array[column * 4 + row]

    override operator fun set(column: Int, row: Int, value: Double) = array.set(column * 4 + row, value)

    override operator fun set(index: Int, value: Vec4t<out Number>) {
        array[index * 4] = value._x.d
        array[index * 4 + 1] = value._y.d
        array[index * 4 + 2] = value._z.d
        array[index * 4 + 3] = value._w.d
    }

    operator fun set(i: Int, v: Vec4d) {
        v.to(array, i * 4)
    }

    // TODO other cases
    fun set(i: Int, v: Vec3d, s: Double) {
        v.to(array, i * 4)
        array[i * 4 + 3] = s
    }


    // -- Unary arithmetic operators --

    operator fun unaryPlus() = this

    operator fun unaryMinus() = Mat4d(
            -array[0], -array[1], -array[2], -array[3],
            -array[4], -array[5], -array[6], -array[7],
            -array[8], -array[9], -array[10], -array[11],
            -array[12], -array[13], -array[14], -array[15])


    // -- Increment main.and decrement operators --

    operator fun inc(res: Mat4d = Mat4d()): Mat4d = plus(res, this, 1.0)
    fun incAssign() = plus(this, this, 1.0)

    operator fun dec(res: Mat4d = Mat4d()): Mat4d = minus(res, this, 1.0)
    fun decAssign() = minus(this, this, 1.0)


    // -- Specific binary arithmetic operators --

    infix operator fun plus(b: Double) = plus(Mat4d(), this, b)
    infix operator fun plus(b: Mat4d) = plus(Mat4d(), this, b)

    fun plus(b: Double, res: Mat4d) = plus(res, this, b)
    fun plus(b: Mat4d, res: Mat4d) = plus(res, this, b)

    infix operator fun plusAssign(b: Double) {
        plus(this, this, b)
    }

    infix operator fun plusAssign(b: Mat4d) {
        plus(this, this, b)
    }


    infix operator fun minus(b: Double) = minus(Mat4d(), this, b)
    infix operator fun minus(b: Mat4d) = minus(Mat4d(), this, b)

    fun minus(b: Double, res: Mat4d) = minus(res, this, b)
    fun minus(b: Mat4d, res: Mat4d) = minus(res, this, b)

    infix operator fun minusAssign(b: Double) {
        minus(this, this, b)
    }

    infix operator fun minusAssign(b: Mat4d) {
        minus(this, this, b)
    }


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

    infix operator fun timesAssign(b: Double) {
        times(this, this, b)
    }

    infix operator fun timesAssign(b: Vec4d) {
        times(b, this, b)
    }

    infix operator fun timesAssign(b: Mat4d) {
        times(this, this, b)
    }


    infix operator fun div(b: Double) = div(Mat4d(), this, b)
    infix operator fun div(b: Mat4d) = div(Mat4d(), this, b)

    fun div(b: Double, res: Mat4d) = div(res, this, b)
    fun div(b: Mat4d, res: Mat4d) = div(res, this, b)

    infix operator fun divAssign(b: Double) {
        div(this, this, b)
    }

    infix operator fun divAssign(b: Mat4d) {
        div(this, this, b)
    }


    // -- Matrix functions --

    val det get() = glm.determinant(this)

    @JvmOverloads
    fun inverse(res: Mat4d = Mat4d()) = glm.inverse(res, this)

    fun inverseAssign() = inverse(this, this)

    @JvmOverloads
    fun transpose(res: Mat4d = Mat4d()) = glm.transpose(res, this)

    fun transposeAssign() = transpose(this, this)

    @JvmOverloads
    fun inverseTranspose(res: Mat4d = Mat4d()) = glm.inverseTranspose(res, this)

    fun inverseTransposeAssign() = glm.inverseTranspose(this, this)


    // TODO others
    infix fun scale(scale: Vec3d) = scale(scale.x, scale.y, scale.z, Mat4d())

    fun scale(scale: Vec3d, res: Mat4d) = scale(scale.x, scale.y, scale.z, res)

    infix fun scale(scale: Double) = scale(scale, scale, scale, Mat4d())
    fun scale(scale: Double, res: Mat4d) = scale(scale, scale, scale, res)

    @JvmOverloads
    fun scale(scaleX: Double, scaleY: Double, scaleZ: Double, res: Mat4d = Mat4d()) = glm.scale(this, scaleX, scaleY, scaleZ, res)

    infix fun scaleAssign(scale: Vec3d) = scaleAssign(scale.x, scale.y, scale.z)
    infix fun scaleAssign(scale: Double) = scaleAssign(scale, scale, scale)
    fun scaleAssign(scaleX: Double, scaleY: Double, scaleZ: Double) = glm.scale(this, scaleX, scaleY, scaleZ, this)


    infix fun translate(translate: Vec3d) = translate(translate.x, translate.y, translate.z, Mat4d())
    fun translate(translate: Vec3d, res: Mat4d) = translate(translate.x, translate.y, translate.z, res)

    infix fun translate(translate: Double) = translate(translate, translate, translate, Mat4d())
    fun translate(translate: Double, res: Mat4d) = translate(translate, translate, translate, res)

    @JvmOverloads
    fun translate(translateX: Double, translateY: Double, translateZ: Double, res: Mat4d = Mat4d()) =
            glm.translate(this, translateX, translateY, translateZ, res)

    infix fun translateAssign(translate: Vec3d) = translateAssign(translate.x, translate.y, translate.z)
    infix fun translateAssign(translate: Double) = translateAssign(translate, translate, translate)
    fun translateAssign(translateX: Double, translateY: Double, translateZ: Double) = glm.translate(this, translateX, translateY, translateZ, this)


//    infix fun isEqual(b: Mat4d) = this[0].isEqual(b[0]) && this[1].isEqual(b[1]) && this[2].isEqual(b[2]) && this[3].isEqual(b[3])

    @JvmOverloads
    fun rotate(angle: Double, vX: Double, vY: Double, vZ: Double, res: Mat4d = Mat4d()) = glm.rotate(this, angle, vX, vY, vZ, res)

    @JvmOverloads
    fun rotate(angle: Double, v: Vec3d, res: Mat4d = Mat4d()) = glm.rotate(this, angle, v, res)

    fun rotateAssign(angle: Double, vX: Double, vY: Double, vZ: Double) = glm.rotate(this, angle, vX, vY, vZ, this)
    fun rotateAssign(angle: Double, v: Vec3d) = glm.rotate(this, angle, v, this)

    @JvmOverloads
    fun rotateX(angle: Double, res: Mat4d = Mat4d()) = glm.rotateX(this, angle, res)
    @JvmOverloads
    fun rotateY(angle: Double, res: Mat4d = Mat4d()) = glm.rotateY(this, angle, res)
    @JvmOverloads
    fun rotateZ(angle: Double, res: Mat4d = Mat4d()) = glm.rotateZ(this, angle, res)
    @JvmOverloads
    fun rotateXYZ(angle: Vec3d, res: Mat4d = Mat4d()) = glm.rotateXYZ(this, angle.x, angle.y, angle.z, res)
    @JvmOverloads
    fun rotateXYZ(angleX: Double, angleY: Double, angleZ: Double, res: Mat4d = Mat4d()) = glm.rotateXYZ(this, angleX, angleY, angleZ, res)

    fun rotateXassign(angle: Double) = glm.rotateX(this, angle, this)
    fun rotateYassign(angle: Double) = glm.rotateY(this, angle, this)
    fun rotateZassign(angle: Double) = glm.rotateZ(this, angle, this)
    fun rotateXYZassign(angle: Vec3d) = glm.rotateXYZ(this, angle.x, angle.y, angle.z, this)
    fun rotateXYZassign(angleX: Double, angleY: Double, angleZ: Double) = glm.rotateXYZ(this, angleX, angleY, angleZ, this)


    override var a0: Double
        get() = array[0]
        set(v) = array.set(0, v)
    override var a1: Double
        get() = array[1]
        set(v) = array.set(1, v)
    override var a2: Double
        get() = array[2]
        set(v) = array.set(2, v)
    override var a3: Double
        get() = array[3]
        set(v) = array.set(3, v)

    override var b0: Double
        get() = array[4]
        set(v) = array.set(4, v)
    override var b1: Double
        get() = array[5]
        set(v) = array.set(5, v)
    override var b2: Double
        get() = array[6]
        set(v) = array.set(6, v)
    override var b3: Double
        get() = array[7]
        set(v) = array.set(7, v)

    override var c0: Double
        get() = array[8]
        set(v) = array.set(8, v)
    override var c1: Double
        get() = array[9]
        set(v) = array.set(9, v)
    override var c2: Double
        get() = array[10]
        set(v) = array.set(10, v)
    override var c3: Double
        get() = array[11]
        set(v) = array.set(11, v)

    override var d0: Double
        get() = array[12]
        set(v) = array.set(12, v)
    override var d1: Double
        get() = array[13]
        set(v) = array.set(13, v)
    override var d2: Double
        get() = array[14]
        set(v) = array.set(14, v)
    override var d3: Double
        get() = array[15]
        set(v) = array.set(15, v)


    override val isIdentity
        get() = this[0, 0] == 1.0 && this[1, 0] == 0.0 && this[2, 0] == 0.0 && this[3, 0] == 0.0 &&
                this[0, 1] == 0.0 && this[1, 1] == 1.0 && this[2, 1] == 0.0 && this[3, 1] == 0.0 &&
                this[0, 2] == 0.0 && this[1, 2] == 0.0 && this[2, 2] == 1.0 && this[3, 2] == 0.0 &&
                this[0, 3] == 0.0 && this[1, 3] == 0.0 && this[2, 3] == 0.0 && this[3, 3] == 1.0

    companion object : mat4d_operators {
        const val length = Mat4x4t.length
        @JvmField
        val size = length * Double.BYTES

        @JvmStatic
        fun fromPointer(ptr: Ptr<Double>, transpose: Boolean = false): Mat4d = when {
            transpose -> Mat4d(ptr[0], ptr[4], ptr[8], ptr[12],
                              ptr[1], ptr[5], ptr[9], ptr[13],
                              ptr[2], ptr[6], ptr[10], ptr[14],
                              ptr[3], ptr[7], ptr[11], ptr[15])

            else -> Mat4d(ptr)
        }

        val identity: Mat4d
            get() = Mat4d(1.0)
    }

    override fun size() = size

    override fun elementCount() = length

    override fun equals(other: Any?) = other is Mat4d && array.contentEquals(other.array)
    override fun hashCode() = 31 * (31 * (31 * this[0].hashCode() + this[1].hashCode()) + this[2].hashCode()) + this[3].hashCode()

    fun equal(b: Mat4d, epsilon: Double, res: Vec4bool = Vec4bool()): Vec4bool = glm.equal(this, b, epsilon, res)
    fun equal(b: Mat4d, epsilon: Vec4d, res: Vec4bool = Vec4bool()): Vec4bool = glm.equal(this, b, epsilon, res)
    fun notEqual(b: Mat4d, epsilon: Double, res: Vec4bool = Vec4bool()): Vec4bool = glm.notEqual(this, b, epsilon, res)
    fun notEqual(b: Mat4d, epsilon: Vec4d, res: Vec4bool = Vec4bool()): Vec4bool = glm.notEqual(this, b, epsilon, res)
    fun allEqual(b: Mat4d, epsilon: Double = glm.ε): Boolean = glm.allEqual(this, b, epsilon)
    fun anyNotEqual(b: Mat4d, epsilon: Double = glm.ε): Boolean = glm.anyNotEqual(this, b, epsilon)
}
