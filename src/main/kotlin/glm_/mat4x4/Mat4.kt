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
import glm_.mat4x4.operators.mat4x4_operators
import glm_.quat.Quat
import glm_.vec2.Vec2t
import glm_.vec3.Vec3
import glm_.vec3.Vec3t
import glm_.vec4.Vec4
import glm_.vec4.Vec4t
import java.io.InputStream
import java.nio.ByteBuffer
import java.nio.FloatBuffer
import java.util.*

/**
 * Created by GBarbieri on 10.11.2016.
 */
class Mat4(dummy: Int, var array: FloatArray) : Mat4x4t<Float>() {

    // -- Constructors --

    constructor() : this(1)

    constructor(s: Number) : this(s, s, s, s)

    constructor(x: Number, y: Number, z: Number) : this(x, y, z, 1f)    // TODO others
    constructor(x: Number, y: Number, z: Number, w: Number) : this(
            x, 0, 0, 0,
            0, y, 0, 0,
            0, 0, z, 0,
            0, 0, 0, w)

    // TODO others

    constructor(v: Vec2t<*>) : this(v.x, v.y, 0, 1)
    constructor(v: Vec2t<*>, z: Number) : this(v.x, v.y, z, 1)
    constructor(v: Vec2t<*>, z: Number, w: Number) : this(v.x, v.y, z, w)
    constructor(v: Vec3t<*>) : this(v.x, v.y, v.z, 1)
    constructor(v: Vec3t<*>, w: Number) : this(v.x, v.y, v.z, w)
    constructor(a: Vec3t<*>, aW: Number, b: Vec3t<*>, bW: Number, c: Vec3t<*>, cW: Number, d: Vec3t<*>, dW: Number) : this(
            a.x, a.y, a.z, aW, b.x, b.y, b.z, bW, c.x, c.y, c.z, cW, d.x, d.y, d.z, dW)

    constructor(v: Vec4t<*>) : this(v.x, v.y, v.z, v.w)

    constructor(x0: Number, y0: Number, z0: Number, w0: Number,
                x1: Number, y1: Number, z1: Number, w1: Number,
                x2: Number, y2: Number, z2: Number, w2: Number,
                x3: Number, y3: Number, z3: Number, w3: Number) : this(0, floatArrayOf(
            x0.f, y0.f, z0.f, w0.f,
            x1.f, y1.f, z1.f, w1.f,
            x2.f, y2.f, z2.f, w2.f,
            x3.f, y3.f, z3.f, w3.f))

    constructor(v0: Vec4t<out Number>, v1: Vec4t<out Number>, v2: Vec4t<out Number>, v3: Vec4t<out Number>) : this(
            v0.x, v0.y, v0.z, v0.w,
            v1.x, v1.y, v1.z, v1.w,
            v2.x, v2.y, v2.z, v2.w,
            v3.x, v3.y, v3.z, v3.w)

    constructor(block: (Int) -> Number) : this(
            block(0).f, block(1).f, block(2).f, block(3).f,
            block(4).f, block(5).f, block(6).f, block(7).f,
            block(8).f, block(9).f, block(10).f, block(11).f,
            block(12).f, block(13).f, block(14).f, block(15).f)

    constructor(list: Iterable<*>, index: Int = 0) : this(
            list.elementAt(index)!!.toFloat, list.elementAt(index + 1)!!.toFloat, list.elementAt(index + 2)!!.toFloat, list.elementAt(index + 3)!!.toFloat,
            list.elementAt(index + 4)!!.toFloat, list.elementAt(index + 5)!!.toFloat, list.elementAt(index + 6)!!.toFloat, list.elementAt(index + 7)!!.toFloat,
            list.elementAt(index + 8)!!.toFloat, list.elementAt(index + 9)!!.toFloat, list.elementAt(index + 10)!!.toFloat, list.elementAt(index + 11)!!.toFloat,
            list.elementAt(index + 12)!!.toFloat, list.elementAt(index + 13)!!.toFloat, list.elementAt(index + 14)!!.toFloat, list.elementAt(index + 15)!!.toFloat)

    constructor(buffer: ByteBuffer, offset: Int) : this(
            buffer.getFloat(offset),
            buffer.getFloat(offset + Float.BYTES),
            buffer.getFloat(offset + Float.BYTES * 2),
            buffer.getFloat(offset + Float.BYTES * 3),
            buffer.getFloat(offset + Float.BYTES * 4),
            buffer.getFloat(offset + Float.BYTES * 5),
            buffer.getFloat(offset + Float.BYTES * 6),
            buffer.getFloat(offset + Float.BYTES * 7),
            buffer.getFloat(offset + Float.BYTES * 8),
            buffer.getFloat(offset + Float.BYTES * 9),
            buffer.getFloat(offset + Float.BYTES * 10),
            buffer.getFloat(offset + Float.BYTES * 11),
            buffer.getFloat(offset + Float.BYTES * 12),
            buffer.getFloat(offset + Float.BYTES * 13),
            buffer.getFloat(offset + Float.BYTES * 14),
            buffer.getFloat(offset + Float.BYTES * 15))

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
            mat3[0, 0], mat3[0, 1], mat3[0, 3], 0,
            mat3[1, 0], mat3[1, 1], mat3[1, 3], 0,
            mat3[2, 0], mat3[2, 1], mat3[2, 3], 0,
            0, 0, 0, 1)

    constructor(mat3: Mat3d) : this(
            mat3[0, 0], mat3[0, 1], mat3[0, 3], 0,
            mat3[1, 0], mat3[1, 1], mat3[1, 3], 0,
            mat3[2, 0], mat3[2, 1], mat3[2, 3], 0,
            0, 0, 0, 1)

    constructor(mat4: Mat4) : this(0, mat4.array.clone())
    constructor(mat4: Mat4d) : this(0, FloatArray(length) { mat4.array[it].f })

    constructor(mat2x3: Mat2x3t<*>) : this(
            mat2x3[0, 0], mat2x3[0, 1], mat2x3[0, 2], 0,
            mat2x3[1, 0], mat2x3[1, 1], mat2x3[1, 2], 0,
            0, 0, 1, 0,
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
    constructor(floats: FloatArray, transpose: Boolean = false) : this(0,
            if (transpose) floatArrayOf(
                    floats[0], floats[4], floats[8], floats[12],
                    floats[1], floats[5], floats[9], floats[13],
                    floats[2], floats[6], floats[10], floats[14],
                    floats[3], floats[7], floats[11], floats[15])
            else floats.clone())

    // TODO others
    constructor(inputStream: InputStream, bigEndian: Boolean = true) : this(
            inputStream.float(bigEndian), inputStream.float(bigEndian), inputStream.float(bigEndian), inputStream.float(bigEndian),
            inputStream.float(bigEndian), inputStream.float(bigEndian), inputStream.float(bigEndian), inputStream.float(bigEndian),
            inputStream.float(bigEndian), inputStream.float(bigEndian), inputStream.float(bigEndian), inputStream.float(bigEndian),
            inputStream.float(bigEndian), inputStream.float(bigEndian), inputStream.float(bigEndian), inputStream.float(bigEndian))

    fun put(v0: Vec4, v1: Vec4, v2: Vec4, v3: Vec4) {
        v0.to(array, 0)
        v1.to(array, 4)
        v2.to(array, 8)
        v3.to(array, 12)
    }

    // TODO others
    infix operator fun invoke(s: Float) = invoke(s, s, s, s)

    infix operator fun invoke(v: Vec3) = invoke(v.x, v.y, v.z, 1f)
    infix operator fun invoke(v: Vec4) = invoke(v.x, v.y, v.z, v.w)

    infix operator fun invoke(floats: FloatArray) = invoke(floats[0], floats[1], floats[2], floats[3], floats[4], floats[5], floats[6],
            floats[7], floats[8], floats[9], floats[10], floats[11], floats[12], floats[13], floats[14], floats[15])

    operator fun invoke(x: Float, y: Float, z: Float, w: Float) = invoke(
            x, 0f, 0f, 0f,
            0f, y, 0f, 0f,
            0f, 0f, z, 0f,
            0f, 0f, 0f, w)

    inline fun invoke(a0: Float, a1: Float, a2: Float, a3: Float,
                      b0: Float, b1: Float, b2: Float, b3: Float,
                      c0: Float, c1: Float, c2: Float, c3: Float,
                      d0: Float, d1: Float, d2: Float, d3: Float): Mat4 {

        put(a0, a1, a2, a3, b0, b1, b2, b3, c0, c1, c2, c3, d0, d1, d2, d3)
        return this
    }

    infix fun put(mat4: Mat4) = System.arraycopy(mat4.array.clone(), 0, array, 0, 16)

    infix fun put(s: Float) = put(s, s, s, s)
    infix fun put(v: Vec3) = put(v.x, v.y, v.z, 1f)
    infix fun put(v: Vec4) = put(v.x, v.y, v.z, v.w)

    infix fun put(floats: FloatArray) = put(floats[0], floats[1], floats[2], floats[3], floats[4], floats[5], floats[6],
            floats[7], floats[8], floats[9], floats[10], floats[11], floats[12], floats[13], floats[14], floats[15])

    fun put(x: Float, y: Float, z: Float, w: Float) = put(
            x, 0f, 0f, 0f,
            0f, y, 0f, 0f,
            0f, 0f, z, 0f,
            0f, 0f, 0f, w)

    fun put(a0: Float, a1: Float, a2: Float, a3: Float,
            b0: Float, b1: Float, b2: Float, b3: Float,
            c0: Float, c1: Float, c2: Float, c3: Float,
            d0: Float, d1: Float, d2: Float, d3: Float) {

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
    fun toMat3() = to(Mat3())

    infix fun to(res: Mat3): Mat3 {

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

    // TODO others
    infix fun to(dbb: ByteBuffer): ByteBuffer = to(dbb, 0)

    fun to(dbb: ByteBuffer, offset: Int): ByteBuffer {
        dbb.putFloat(offset + 0 * Float.BYTES, array[0])
        dbb.putFloat(offset + 1 * Float.BYTES, array[1])
        dbb.putFloat(offset + 2 * Float.BYTES, array[2])
        dbb.putFloat(offset + 3 * Float.BYTES, array[3])
        dbb.putFloat(offset + 4 * Float.BYTES, array[4])
        dbb.putFloat(offset + 5 * Float.BYTES, array[5])
        dbb.putFloat(offset + 6 * Float.BYTES, array[6])
        dbb.putFloat(offset + 7 * Float.BYTES, array[7])
        dbb.putFloat(offset + 8 * Float.BYTES, array[8])
        dbb.putFloat(offset + 9 * Float.BYTES, array[9])
        dbb.putFloat(offset + 10 * Float.BYTES, array[10])
        dbb.putFloat(offset + 11 * Float.BYTES, array[11])
        dbb.putFloat(offset + 12 * Float.BYTES, array[12])
        dbb.putFloat(offset + 13 * Float.BYTES, array[13])
        dbb.putFloat(offset + 14 * Float.BYTES, array[14])
        dbb.putFloat(offset + 15 * Float.BYTES, array[15])
        return dbb
    }

    // TODO others
    infix fun to(dfb: FloatBuffer) = to(dfb, 0)

    fun to(dfb: FloatBuffer, offset: Int): FloatBuffer {
        dfb[offset + 0] = array[0]
        dfb[offset + 1] = array[1]
        dfb[offset + 2] = array[2]
        dfb[offset + 3] = array[3]
        dfb[offset + 4] = array[4]
        dfb[offset + 5] = array[5]
        dfb[offset + 6] = array[6]
        dfb[offset + 7] = array[7]
        dfb[offset + 8] = array[8]
        dfb[offset + 9] = array[9]
        dfb[offset + 10] = array[10]
        dfb[offset + 11] = array[11]
        dfb[offset + 12] = array[12]
        dfb[offset + 13] = array[13]
        dfb[offset + 14] = array[14]
        dfb[offset + 15] = array[15]
        return dfb
    }

    infix fun to(res: Quat) = glm.quat_cast(this, res)
    fun toQuat() = glm.quat_cast(this, Quat())

    // -- put --

    fun put(mat2x2: Mat2x2t<Number>) {
        array[0] = mat2x2[0, 0].f
        array[1] = mat2x2[0, 1].f
        array[2] = 0f
        array[3] = 0f

        array[4] = mat2x2[1, 0].f
        array[5] = mat2x2[1, 1].f
        array[6] = 0f
        array[7] = 0f

        array[8] = 0f
        array[9] = 0f
        array[10] = 0f
        array[11] = 0f

        array[12] = 0f
        array[13] = 0f
        array[14] = 0f
        array[15] = 0f
    }

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


    // -- Accesses --

    override inline operator fun get(index: Int) = Vec4(index * 4, array)
    override inline operator fun get(c: Int, r: Int) = array[c * 4 + r]

    override inline operator fun set(c: Int, r: Int, s: Float) = array.set(c * 4 + r, s)

    override inline operator fun set(i: Int, v: Vec4t<out Number>) {
        array[i * 4] = v.x.f
        array[i * 4 + 1] = v.y.f
        array[i * 4 + 2] = v.z.f
        array[i * 4 + 3] = v.w.f
    }

    inline operator fun set(i: Int, v: Vec4) {
        v.to(array, i * 4)
    }

    // TODO other cases
    fun set(i: Int, v: Vec3, s: Float) {
        v.to(array, i * 4)
        array[i * 4 + 3] = s
    }


    // -- Unary arithmetic operators --

    operator fun unaryPlus() = this

    operator fun unaryMinus() = Mat4(
            -array[0], -array[1], -array[2], -array[3],
            -array[4], -array[5], -array[6], -array[7],
            -array[8], -array[9], -array[10], -array[11],
            -array[12], -array[13], -array[14], -array[15])


    // -- Increment main.and decrement operators --

    operator fun inc(res: Mat4 = Mat4()): Mat4 = plus(res, this, 1f)
    fun incAssign() = plus(this, this, 1f)

    operator fun dec(res: Mat4 = Mat4()): Mat4 = minus(res, this, 1f)
    fun decAssign() = minus(this, this, 1f)


    // -- Specific binary arithmetic operators --

    infix operator fun plus(b: Float) = plus(Mat4(), this, b)
    infix operator fun plus(b: Mat4) = plus(Mat4(), this, b)

    fun plus(b: Float, res: Mat4) = plus(res, this, b)
    fun plus(b: Mat4, res: Mat4) = plus(res, this, b)

    infix operator fun plusAssign(b: Float) {
        plus(this, this, b)
    }

    infix operator fun plusAssign(b: Mat4) {
        plus(this, this, b)
    }


    infix operator fun minus(b: Float) = minus(Mat4(), this, b)
    infix operator fun minus(b: Mat4) = minus(Mat4(), this, b)

    fun minus(b: Float, res: Mat4) = minus(res, this, b)
    fun minus(b: Mat4, res: Mat4) = minus(res, this, b)

    infix operator fun minusAssign(b: Float) {
        minus(this, this, b)
    }

    infix operator fun minusAssign(b: Mat4) {
        minus(this, this, b)
    }


    /**
     * @return = [b] * @this
     */
    infix operator fun times(b: Float) = times(Mat4(), this, b)

    infix operator fun times(b: Vec4) = times(Vec4(), this, b)
    infix operator fun times(b: Mat4) = times(Mat4(), this, b)

    /**
     * [res] = [b] * @this
     */
    fun times(b: Float, res: Mat4) = times(res, this, b)

    fun times(b: Vec4, res: Vec4) = times(res, this, b)
    fun times(b: Mat4, res: Mat4) = times(res, this, b)

    infix operator fun timesAssign(b: Float) {
        times(this, this, b)
    }

    infix operator fun timesAssign(b: Vec4) {
        times(b, this, b)
    }

    infix operator fun timesAssign(b: Mat4) {
        times(this, this, b)
    }


    infix operator fun div(b: Float) = div(Mat4(), this, b)
    infix operator fun div(b: Mat4) = div(Mat4(), this, b)

    fun div(b: Float, res: Mat4) = div(res, this, b)
    fun div(b: Mat4, res: Mat4) = div(res, this, b)

    infix operator fun divAssign(b: Float) {
        div(this, this, b)
    }

    infix operator fun divAssign(b: Mat4) {
        div(this, this, b)
    }


    // -- Matrix functions --

    val det get() = glm.determinant(this)

    inline fun inverse() = inverse(Mat4())  // TODO check style: inline + overload
    inline infix fun inverse(res: Mat4) = inverse(res, this)

    fun inverseAssign() = inverse(this, this)

    @JvmOverloads
    fun transpose(res: Mat4 = Mat4()) = transpose(res, this)

    fun transposeAssign() = transpose(this, this)


    // TODO others
    infix fun scale(scale: Vec3) = scale(scale.x, scale.y, scale.z, Mat4())

    fun scale(scale: Vec3, res: Mat4) = scale(scale.x, scale.y, scale.z, res)

    infix fun scale(scale: Float) = scale(scale, scale, scale, Mat4())
    fun scale(scale: Float, res: Mat4) = scale(scale, scale, scale, res)

    @JvmOverloads
    fun scale(scaleX: Float, scaleY: Float, scaleZ: Float, res: Mat4 = Mat4()) = glm.scale(res, this, scaleX, scaleY, scaleZ)

    infix fun scaleAssign(scale: Vec3) = scaleAssign(scale.x, scale.y, scale.z)
    infix fun scaleAssign(scale: Float) = scaleAssign(scale, scale, scale)
    fun scaleAssign(scaleX: Float, scaleY: Float, scaleZ: Float) = glm.scale(this, this, scaleX, scaleY, scaleZ)


    infix fun translate(translate: Vec3) = translate(translate.x, translate.y, translate.z, Mat4())
    fun translate(translate: Vec3, res: Mat4) = translate(translate.x, translate.y, translate.z, res)

    infix fun translate(translate: Float) = translate(translate, translate, translate, Mat4())
    fun translate(translate: Float, res: Mat4) = translate(translate, translate, translate, res)

    @JvmOverloads
    fun translate(translateX: Float, translateY: Float, translateZ: Float, res: Mat4 = Mat4()) =
            glm.translate(res, this, translateX, translateY, translateZ)

    infix fun translateAssign(translate: Vec3) = translateAssign(translate.x, translate.y, translate.z)
    infix fun translateAssign(translate: Float) = translateAssign(translate, translate, translate)
    fun translateAssign(translateX: Float, translateY: Float, translateZ: Float) = glm.translate(this, this, translateX, translateY, translateZ)


    infix fun isEqual(b: Mat4) = this[0].isEqual(b[0]) && this[1].isEqual(b[1]) && this[2].isEqual(b[2]) && this[3].isEqual(b[3])

    @JvmOverloads
    fun rotate(angle: Float, vX: Float, vY: Float, vZ: Float, res: Mat4 = Mat4()) = glm.rotate(res, this, angle, vX, vY, vZ)

    @JvmOverloads
    fun rotate(angle: Float, v: Vec3, res: Mat4 = Mat4()) = glm.rotate(res, this, angle, v)

    fun rotateAssign(angle: Float, vX: Float, vY: Float, vZ: Float) = glm.rotate(this, this, angle, vX, vY, vZ)
    fun rotateAssign(angle: Float, v: Vec3) = glm.rotate(this, this, angle, v)


    override var a0: Float
        get() = array[0]
        set(v) = array.set(0, v)
    override var a1: Float
        get() = array[1]
        set(v) = array.set(1, v)
    override var a2: Float
        get() = array[2]
        set(v) = array.set(2, v)
    override var a3: Float
        get() = array[3]
        set(v) = array.set(3, v)

    override var b0: Float
        get() = array[4]
        set(v) = array.set(4, v)
    override var b1: Float
        get() = array[5]
        set(v) = array.set(5, v)
    override var b2: Float
        get() = array[6]
        set(v) = array.set(6, v)
    override var b3: Float
        get() = array[7]
        set(v) = array.set(7, v)

    override var c0: Float
        get() = array[8]
        set(v) = array.set(8, v)
    override var c1: Float
        get() = array[9]
        set(v) = array.set(9, v)
    override var c2: Float
        get() = array[10]
        set(v) = array.set(10, v)
    override var c3: Float
        get() = array[11]
        set(v) = array.set(11, v)

    override var d0: Float
        get() = array[12]
        set(v) = array.set(12, v)
    override var d1: Float
        get() = array[13]
        set(v) = array.set(13, v)
    override var d2: Float
        get() = array[14]
        set(v) = array.set(14, v)
    override var d3: Float
        get() = array[15]
        set(v) = array.set(15, v)


    override val isIdentity
        get() = this[0, 0] == 1f && this[1, 0] == 0f && this[2, 0] == 0f && this[3, 0] == 0f &&
                this[0, 1] == 0f && this[1, 1] == 1f && this[2, 1] == 0f && this[3, 1] == 0f &&
                this[0, 2] == 0f && this[1, 2] == 0f && this[2, 2] == 1f && this[3, 2] == 0f &&
                this[0, 3] == 0f && this[1, 3] == 0f && this[2, 3] == 0f && this[3, 3] == 1f

    companion object : mat4x4_operators() {
        const val length = Mat4x4t.length
        @JvmField
        val size = length * Float.BYTES
    }

    override fun size() = size

    override fun equals(other: Any?) = other is Mat4 && Arrays.equals(array, other.array)

    override fun hashCode() = 31 * (31 * (31 * this[0].hashCode() + this[1].hashCode()) + this[2].hashCode()) + this[3].hashCode()
}