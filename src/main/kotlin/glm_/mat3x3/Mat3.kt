package  glm_.mat3x3

import glm_.*
import glm_.glm.inverse
import glm_.glm.transpose
import glm_.mat2x2.Mat2
import glm_.mat2x2.Mat2d
import glm_.mat2x3.Mat2x3t
import glm_.mat2x4.Mat2x4t
import glm_.mat3x2.Mat3x2t
import glm_.mat3x3.operators.mat3x3_operators
import glm_.mat3x4.Mat3x4t
import glm_.mat4x2.Mat4x2t
import glm_.mat4x3.Mat4x3t
import glm_.mat4x4.Mat4
import glm_.mat4x4.Mat4d
import glm_.quat.Quat
import glm_.vec2.Vec2
import glm_.vec2.Vec2t
import glm_.vec3.Vec3
import glm_.vec3.Vec3t
import glm_.vec4.Vec4
import glm_.vec4.Vec4t
import kool.bufferBig
import kool.floatBufferBig
import org.lwjgl.system.MemoryStack
import java.nio.ByteBuffer
import java.nio.FloatBuffer
import java.util.*

/**
 * Created by GBarbieri on 10.11.2016.
 */

class Mat3(dummy: Int, var array: FloatArray) : Mat3x3t<Float>() {

    // -- Constructors --

    constructor() : this(1)

    constructor(s: Number) : this(s, s, s)

    constructor(x: Number, y: Number, z: Number) : this(
            x, 0, 0,
            0, y, 0,
            0, 0, z)

    constructor(v: Vec2t<*>) : this(v.x, v.y, 0)
    constructor(v: Vec2t<*>, z: Number) : this(v.x, v.y, z)
    constructor(v: Vec3t<*>) : this(v.x, v.y, v.z)
    constructor(v: Vec4t<*>) : this(v.x, v.y, v.z)

    constructor(x0: Number, y0: Number, z0: Number,
                x1: Number, y1: Number, z1: Number,
                x2: Number, y2: Number, z2: Number) : this(0, floatArrayOf(
            x0.f, y0.f, z0.f,
            x1.f, y1.f, z1.f,
            x2.f, y2.f, z2.f))

    constructor(v0: Vec3t<out Number>, v1: Vec3t<out Number>, v2: Vec3t<out Number>) : this(
            v0.x, v0.y, v0.z,
            v1.x, v1.y, v1.z,
            v2.x, v2.y, v2.z)

    constructor(block: (Int) -> Number) : this(
            block(0).f, block(1).f, block(2).f,
            block(3).f, block(4).f, block(5).f,
            block(6).f, block(7).f, block(8).f)

    constructor(block: (Int, Int) -> Number) : this(
            block(0, 0).f, block(0, 1).f, block(0, 2).f,
            block(1, 0).f, block(1, 1).f, block(1, 2).f,
            block(2, 0).f, block(2, 1).f, block(2, 2).f)

    constructor(list: Iterable<*>, index: Int = 0) : this(
            list.elementAt(index)!!.toFloat, list.elementAt(index + 1)!!.toFloat, list.elementAt(index + 2)!!.toFloat,
            list.elementAt(index + 3)!!.toFloat, list.elementAt(index + 4)!!.toFloat, list.elementAt(index + 5)!!.toFloat,
            list.elementAt(index + 6)!!.toFloat, list.elementAt(index + 7)!!.toFloat, list.elementAt(index + 8)!!.toFloat)

    // -- Matrix conversions --

    constructor(mat2: Mat2) : this(
            mat2[0, 0], mat2[0, 1], 0f,
            mat2[1, 0], mat2[1, 1], 0f,
            0f, 0f, 1f)

    constructor(mat2: Mat2d) : this(
            mat2[0, 0], mat2[0, 1], 0.0,
            mat2[1, 0], mat2[1, 1], 0.0,
            0.0, 0.0, 1.0)

    constructor(mat3: Mat3) : this(0, mat3.array.clone())
    constructor(mat3: Mat3d) : this(0, FloatArray(length) { mat3.array[it].f })

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

    constructor(floats: FloatArray, transpose: Boolean = false) : this(0,
            if (transpose) floatArrayOf(
                    floats[0], floats[3], floats[6],
                    floats[1], floats[4], floats[7],
                    floats[2], floats[5], floats[8])
            else floats.clone())

    // to
//    fun to(mat2x2: Mat2x2t<Number>) {
//        mat2x2[0, 0] = array[0]; mat2x2[0, 1] = array[1]
//        mat2x2[1, 0] = array[3]; mat2x2[1, 1] = array[4]
//    }

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

    override operator fun get(index: Int) = Vec3(index * 3, array)
    override operator fun get(column: Int, row: Int) = array[column * 3 + row]

    override operator fun set(column: Int, row: Int, value: Float) = array.set(column * 3 + row, value)
    override operator fun set(index: Int, value: Vec3t<out Number>) {
        array[index * 3] = value.x.f
        array[index * 3 + 1] = value.y.f
        array[index * 3 + 2] = value.z.f
    }

    operator fun set(i: Int, v: Vec3) {
        v.to(array, i * 3)
    }

    // -- Matrix functions --

    val det get() = glm.determinant(this)

    @JvmOverloads
    fun inverse(res: Mat3 = Mat3()) = inverse(res, this)

    fun inverseAssign() = inverse(this, this)

    @JvmOverloads
    fun transpose(res: Mat3 = Mat3()) = transpose(res, this)

    fun transposeAssign() = transpose(this, this)


    infix operator fun invoke(s: Float) = invoke(s, s, s)

    infix operator fun invoke(v: Vec2) = invoke(v.x, v.y, 1f)
    infix operator fun invoke(v: Vec3) = invoke(v.x, v.y, v.z)
    infix operator fun invoke(v: Vec4) = invoke(v.x, v.y, v.z)

    infix operator fun invoke(floats: FloatArray) = invoke(floats[0], floats[1], floats[2], floats[3], floats[4], floats[5], floats[6], floats[7], floats[8])

    infix operator fun invoke(mat2: Mat2) = invoke(
            mat2[0, 0], mat2[0, 1], 0f,
            mat2[1, 0], mat2[1, 1], 0f,
            0f, 0f, 1f)

    infix operator fun invoke(mat2: Mat2d) = invoke(
            mat2[0, 0].f, mat2[0, 1].f, 0f,
            mat2[1, 0].f, mat2[1, 1].f, 0f,
            0f, 0f, 1f)

    infix operator fun invoke(mat3: Mat3) = invoke(mat3.array.clone())
    infix operator fun invoke(mat3: Mat3d) = invoke(FloatArray(length) { mat3.array[it].f })

    infix operator fun invoke(mat4: Mat4) = invoke(
            mat4[0, 0], mat4[0, 1], mat4[0, 2],
            mat4[1, 0], mat4[1, 1], mat4[1, 2],
            mat4[2, 0], mat4[2, 1], mat4[2, 2])

    infix operator fun invoke(mat4: Mat4d) = invoke(
            mat4[0, 0].f, mat4[0, 1].f, mat4[0, 2].f,
            mat4[1, 0].f, mat4[1, 1].f, mat4[1, 2].f,
            mat4[2, 0].f, mat4[2, 1].f, mat4[2, 2].f)

    operator fun invoke(x: Float, y: Float, z: Float) = invoke(
            x, 0f, 0f,
            0f, y, 0f,
            0f, 0f, z)

    operator fun invoke(x: Number, y: Number, z: Number) = invoke(
            x.f, 0f, 0f,
            0f, y.f, 0f,
            0f, 0f, z.f)

    operator fun invoke(a0: Float, a1: Float, a2: Float,
                        b0: Float, b1: Float, b2: Float,
                        c0: Float, c1: Float, c2: Float): Mat3 {

        put(a0, a1, a2, b0, b1, b2, c0, c1, c2)
        return this
    }

    operator fun invoke(a0: Number, a1: Number, a2: Number,
                        b0: Number, b1: Number, b2: Number,
                        c0: Number, c1: Number, c2: Number): Mat3 {

        put(a0.f, a1.f, a2.f, b0.f, b1.f, b2.f, c0.f, c1.f, c2.f)
        return this
    }


    infix fun put(mat3: Mat3) = System.arraycopy(mat3.array.clone(), 0, array, 0, length)

    fun identity() = put(1f)
    infix fun put(s: Float) = put(s, s, s)
    infix fun put(v: Vec2) = put(v.x, v.y, 1f)
    infix fun put(v: Vec3) = put(v.x, v.y, v.z)
    infix fun put(v: Vec4) = put(v.x, v.y, v.z)

    infix fun put(floats: FloatArray) = put(floats[0], floats[1], floats[2], floats[3], floats[4], floats[5], floats[6], floats[7], floats[8])

    fun put(x: Float, y: Float, z: Float) = put(
            x, 0f, 0f,
            0f, y, 0f,
            0f, 0f, z)

    fun put(a0: Float, a1: Float, a2: Float,
            b0: Float, b1: Float, b2: Float,
            c0: Float, c1: Float, c2: Float) {

        array[0] = a0
        array[1] = a1
        array[2] = a2

        array[4] = b0
        array[5] = b1
        array[6] = b2

        array[8] = c0
        array[9] = c1
        array[10] = c2
    }

    // TODO others
    infix fun to(res: Mat4): Mat4 {

        res[0, 0] = this[0, 0]
        res[0, 1] = this[0, 1]
        res[0, 2] = this[0, 2]
        res[0, 3] = 0f

        res[1, 0] = this[1, 0]
        res[1, 1] = this[1, 1]
        res[1, 2] = this[1, 2]
        res[1, 3] = 0f

        res[2, 0] = this[2, 0]
        res[2, 1] = this[2, 1]
        res[2, 2] = this[2, 2]
        res[2, 3] = 0f

        res[3, 0] = 0f
        res[3, 1] = 0f
        res[3, 2] = 0f
        res[3, 3] = 1f

        return res
    }

    fun toMat4() = to(Mat4())

    infix fun to(res: Quat) = glm.quat_cast(this, res)
    fun toQuat() = glm.quat_cast(this, Quat())

    fun toFloatArray(): FloatArray = to(FloatArray(length), 0)
    infix fun to(floats: FloatArray): FloatArray = to(floats, 0)
    fun to(floats: FloatArray, index: Int): FloatArray {
        System.arraycopy(array, 0, floats, index, length)
        return floats
    }


    override fun to(buf: ByteBuffer, offset: Int): ByteBuffer = buf
                .putFloat(offset + 0 * Float.BYTES, array[0])
                .putFloat(offset + 1 * Float.BYTES, array[1])
                .putFloat(offset + 2 * Float.BYTES, array[2])
                .putFloat(offset + 3 * Float.BYTES, array[3])
                .putFloat(offset + 4 * Float.BYTES, array[4])
                .putFloat(offset + 5 * Float.BYTES, array[5])
                .putFloat(offset + 6 * Float.BYTES, array[6])
                .putFloat(offset + 7 * Float.BYTES, array[7])
                .putFloat(offset + 8 * Float.BYTES, array[8])


    fun toFloatBufferStack(): FloatBuffer = to(MemoryStack.stackGet().mallocFloat(length), 0)
    infix fun toFloatBuffer(stack: MemoryStack): FloatBuffer = to(stack.mallocFloat(length), 0)
    fun toFloatBuffer(): FloatBuffer = to(floatBufferBig(length), 0)
    infix fun to(buf: FloatBuffer): FloatBuffer = to(buf, 0)

    fun to(buf: FloatBuffer, offset: Int): FloatBuffer {
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


    // -- Unary arithmetic operators --

    operator fun unaryPlus() = this

    operator fun unaryMinus() = Mat3(
            -array[0], -array[1], -array[2],
            -array[3], -array[4], -array[5],
            -array[6], -array[7], -array[8])


// -- Increment main.and decrement operators --

    operator fun inc(res: Mat3 = Mat3()): Mat3 = plus(res, this, 1f)
    fun incAssign() = plus(this, this, 1f)

    operator fun dec(res: Mat3 = Mat3()): Mat3 = minus(res, this, 1f)
    fun decAssign() = minus(this, this, 1f)


// -- Specific binary arithmetic operators --

    infix operator fun plus(b: Float) = plus(Mat3(), this, b)
    infix operator fun plus(b: Mat3) = plus(Mat3(), this, b)

    fun plus(b: Float, res: Mat3) = plus(res, this, b)
    fun plus(b: Mat3, res: Mat3) = plus(res, this, b)

    infix operator fun plusAssign(b: Float) {
        plus(this, this, b)
    }

    infix operator fun plusAssign(b: Mat3) {
        plus(this, this, b)
    }


    infix operator fun minus(b: Float) = minus(Mat3(), this, b)
    infix operator fun minus(b: Mat3) = minus(Mat3(), this, b)

    fun minus(b: Float, res: Mat3) = minus(res, this, b)
    fun minus(b: Mat3, res: Mat3) = minus(res, this, b)

    infix operator fun minusAssign(b: Float) {
        minus(this, this, b)
    }

    infix operator fun minusAssign(b: Mat3) {
        minus(this, this, b)
    }


    infix operator fun times(b: Float) = times(Mat3(), this, b)
    infix operator fun times(b: Vec3) = times(Vec3(), this, b)
    infix operator fun times(b: Mat3) = times(Mat3(), this, b)

    fun times(b: Float, res: Mat3) = times(res, this, b)
    fun times(b: Vec3, res: Vec3) = times(res, this, b)
    fun times(b: Mat3, res: Mat3) = times(res, this, b)

    infix operator fun timesAssign(b: Float) {
        times(this, this, b)
    }

    infix operator fun timesAssign(b: Vec3) {
        times(b, this, b)
    }

    infix operator fun timesAssign(b: Mat3) {
        times(this, this, b)
    }


    infix operator fun div(b: Float) = div(Mat3(), this, b)
    infix operator fun div(b: Mat3) = div(Mat3(), this, b)

    fun div(b: Float, res: Mat3) = div(res, this, b)
    fun div(b: Mat3, res: Mat3) = div(res, this, b)

    infix operator fun divAssign(b: Float) {
        div(this, this, b)
    }

    infix operator fun divAssign(b: Mat3) {
        div(this, this, b)
    }


    fun rotateX(angle: Float, res: Mat3 = Mat3()) = glm.rotateX(res, this, angle)
    fun rotateY(angle: Float, res: Mat3 = Mat3()) = glm.rotateY(res, this, angle)
    fun rotateZ(angle: Float, res: Mat3 = Mat3()) = glm.rotateZ(res, this, angle)
    fun rotateXYZ(angle: Vec3, res: Mat3 = Mat3()) = glm.rotateXYZ(res, this, angle.x, angle.y, angle.z)
    fun rotateXYZ(angleX: Float, angleY: Float, angleZ: Float, res: Mat3 = Mat3()) = glm.rotateXYZ(res, this, angleX, angleY, angleZ)

    fun rotateXassign(angle: Float) = glm.rotateX(this, this, angle)
    fun rotateYassign(angle: Float) = glm.rotateY(this, this, angle)
    fun rotateZassign(angle: Float) = glm.rotateZ(this, this, angle)
    fun rotateXYZassign(angle: Vec3) = glm.rotateXYZ(this, this, angle.x, angle.y, angle.z)
    fun rotateXYZassign(angleX: Float, angleY: Float, angleZ: Float) = glm.rotateXYZ(this, this, angleX, angleY, angleZ)


    infix fun isEqual(b: Mat3) = this[0].isEqual(b[0]) && this[1].isEqual(b[1]) && this[2].isEqual(b[2])

    override var a0: Float
        get() = array[0]
        set(v) = array.set(0, v)
    override var a1: Float
        get() = array[1]
        set(v) = array.set(1, v)
    override var a2: Float
        get() = array[2]
        set(v) = array.set(2, v)

    override var b0: Float
        get() = array[3]
        set(v) = array.set(3, v)
    override var b1: Float
        get() = array[4]
        set(v) = array.set(4, v)
    override var b2: Float
        get() = array[5]
        set(v) = array.set(5, v)

    override var c0: Float
        get() = array[6]
        set(v) = array.set(6, v)
    override var c1: Float
        get() = array[7]
        set(v) = array.set(7, v)
    override var c2: Float
        get() = array[8]
        set(v) = array.set(8, v)


    override val isIdentity
        get() = this[0, 0] == 1f && this[1, 0] == 0f && this[2, 0] == 0f &&
                this[0, 1] == 0f && this[1, 1] == 1f && this[2, 1] == 0f &&
                this[0, 2] == 0f && this[1, 2] == 0f && this[2, 2] == 1f

    companion object : mat3x3_operators {
        const val length = Mat3x3t.length
        @JvmField
        val size = length * Float.BYTES
    }

    override fun size() = size

    override fun equals(other: Any?) = other is Mat3 && Arrays.equals(array, other.array)

    override fun hashCode() = 31 * (31 * this[0].hashCode() + this[1].hashCode()) + this[2].hashCode()
}