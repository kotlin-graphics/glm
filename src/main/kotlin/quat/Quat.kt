package quat

import main.BYTES
import main.Glm.cos
import main.Glm.dot
import main.Glm.sin
import main.f
import main.glm
import mat.Mat3
import mat.Mat4
import mat.QuatT
import vec._3.Vec3
import vec._4.Vec4

/**
 * Created by GBarbieri on 15.11.2016.
 */
data class Quat(var w: Float, var x: Float, var y: Float, var z: Float) : QuatT<Float> {


    // -- Implicit basic constructors --

    constructor() : this(0f, 0f, 0f, 1f)
    constructor(q: Quat) : this(q.w, q.x, q.y, q.z)
    constructor(s: Float, v: Vec3) : this(s, v.x, v.y, v.z)
    constructor(a: Vec3, b: Vec3) : this() {
        val cX = a.y * b.z - b.y * a.z
        val cY = a.z * b.x - b.z * a.x
        val cZ = a.x * b.y - b.x * a.y
        val dot = dot(a, b)
        put(1f + dot, cX, cY, cZ)
        normalize(this, this)
    }

    constructor(eulerAngle: Vec3) : this() {
        val eX = eulerAngle.x * .5f
        val eY = eulerAngle.y * .5f
        val eZ = eulerAngle.z * .5f
        val cX = cos(eX)
        val cY = cos(eY)
        val cZ = cos(eZ)
        val sX = sin(eX)
        val sY = sin(eY)
        val sZ = sin(eZ)
        w = cX * cY * cZ + sX * sY * sZ
        x = sX * cY * cZ - cX * sY * sZ
        y = cX * sY * cZ + sX * cY * sZ
        z = cX * cY * sZ - sX * sY * cZ
    }
//    constructor(m: Mat3x3) : this() {
//        quat_cast(m, this)
//    }
//    constructor(m: Mat4x4) : this() {
//        quat_cast(m, this)
//    }

    infix fun to(res: Mat3) = glm.mat3_cast(res, this)
    fun toMat3() = glm.mat3_cast(Mat3(), this)

    infix fun to(res: Mat4) = glm.mat4_cast(res, this)
    fun toMat4() = glm.mat4_cast(Mat4(), this)

    // -- Explicit basic constructors --

    constructor(q: QuatD) : this(q.w.f, q.x.f, q.y.f, q.z.f)
    constructor(w: Number, x: Number, y: Number, z: Number) : this(w.f, x.f, y.f, z.f)


    fun put(w: Float, x: Float, y: Float, z: Float): Quat {
        this.w = w
        this.x = x
        this.y = y
        this.z = z
        return this
    }

    // -- Component accesses --

    operator fun get(i: Int) = when (i) {
        0 -> x
        1 -> y
        2 -> z
        3 -> w
        else -> throw ArrayIndexOutOfBoundsException()
    }

    operator fun set(i: Int, s: Float) = when (i) {
        0 -> x = s
        1 -> y = s
        2 -> z = s
        3 -> w = s
        else -> throw ArrayIndexOutOfBoundsException()
    }


    companion object : quat_operators, quat_func {
        @JvmStatic val SIZE = 4 * Float.BYTES
    }


    // -- Unary arithmetic operators --

    operator fun Quat.unaryPlus() = this

    operator fun Quat.unaryMinus() = Quat(-w, -x, -y, -z)


    // -- Specific binary arithmetic operators --

    operator fun plus(b: Quat) = add(Quat(), this, b)

    fun add(b: Quat, res: Quat = Quat()) = add(res, this, b)

    infix fun add(b: Quat) = add(Quat(), this, b)
    infix fun add_(b: Quat) = add(this, this, b)


    operator fun minus(b: Quat) = sub(Quat(), this, b)

    fun sub(b: Quat, res: Quat = Quat()) = sub(res, this, b)

    infix fun sub(b: Quat) = sub(Quat(), this, b)
    infix fun sub_(b: Quat) = sub(this, this, b)


    operator fun times(b: Quat) = mul(Quat(), this, b)
    operator fun times(b: Float) = mul(Quat(), this, b)
    operator fun times(b: Vec3) = mul(Vec3(), this, b)
    operator fun times(b: Vec4) = mul(Quat(), this, b)

    fun mul(b: Quat, res: Quat = Quat()) = mul(res, this, b)
    fun mul(b: Float, res: Quat = Quat()) = mul(res, this, b)
    fun mul(b: Vec3, res: Vec3 = Vec3()) = mul(res, this, b)
    fun mul(b: Vec4, res: Quat = Quat()) = mul(res, this, b)

    infix fun mul(b: Quat) = mul(Quat(), this, b)
    infix fun mul(b: Float) = mul(Quat(), this, b)
    infix fun mul(b: Vec3) = mul(Vec3(), this, b)
    infix fun mul(b: Vec4) = mul(Quat(), this, b)
    infix fun mul_(b: Quat) = mul(this, this, b)
    infix fun mul_(b: Float) = mul(this, this, b)
    infix fun mul_(b: Vec3) = mul(b, this, b)
    infix fun mul_(b: Vec4) = mul(this, this, b)


    operator fun div(b: Float) = div(Quat(), this, b)

    fun div(b: Float, res: Quat = Quat()) = div(res, this, b)

    infix fun div_(b: Float) = div(this, this, b)
}