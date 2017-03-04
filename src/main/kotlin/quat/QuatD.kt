package quat

import main.*
import mat.QuatT
import vec._3.Vec3
import vec._3.Vec3d
import vec._4.Vec4
import vec._4.Vec4d


/**
 * Created by GBarbieri on 15.11.2016.
 */
data class QuatD(var w: Double, var x: Double, var y: Double, var z: Double) : QuatT<Double> {

    // -- Implicit basic constructors --

    constructor() : this(1.0, 0.0, 0.0, 0.0)
    constructor(q: Quat) : this(q.w, q.x, q.y, q.z)
    constructor(s: Double, v: Vec3d) : this(s, v.x, v.y, v.z)
    constructor(a: Vec3d, b: Vec3d) : this() {
        val cX = a.y * b.z - b.y * a.z
        val cY = a.z * b.x - b.z * a.x
        val cZ = a.x * b.y - b.x * a.y
        val dot = glm.dot(a, b)
        put(1.0 + dot, cX, cY, cZ)
        normalize(this, this)
    }

    constructor(eulerAngle: Vec3) : this() {
        val eX = eulerAngle.x * .5
        val eY = eulerAngle.y * .5
        val eZ = eulerAngle.z * .5
        val cX = Glm.cos(eX)
        val cY = Glm.cos(eY)
        val cZ = Glm.cos(eZ)
        val sX = Glm.sin(eX)
        val sY = Glm.sin(eY)
        val sZ = Glm.sin(eZ)
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

    // TODO
//    infix fun to(res: Mat3) = glm.mat3_cast(res, this)
//    fun toMat3() = glm.mat3_cast(Mat3(), this)
//
//    infix fun to(res: Mat4) = glm.mat4_cast(res, this)
//    fun toMat4() = glm.mat4_cast(Mat4(), this)

    // -- Explicit basic constructors --

    constructor(q: QuatD) : this(q.w.f, q.x.f, q.y.f, q.z.f)
    constructor(w: Number, x: Number, y: Number, z: Number) : this(w.d, x.d, y.d, z.d)


    fun put(w: Double, x: Double, y: Double, z: Double): QuatD {
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

    operator fun set(i: Int, s: Double) = when (i) {
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

    operator fun unaryPlus() = this

    operator fun unaryMinus() = QuatD(-w, -x, -y, -z)


    // -- Specific binary arithmetic operators --

    operator fun plus(b: QuatD) = add(QuatD(), this, b)

    fun add(b: QuatD, res: QuatD = QuatD()) = add(res, this, b)

    infix fun add(b: QuatD) = add(QuatD(), this, b)
    infix fun add_(b: QuatD) = add(this, this, b)


    operator fun minus(b: QuatD) = sub(QuatD(), this, b)

    fun sub(b: QuatD, res: QuatD = QuatD()) = sub(res, this, b)

    infix fun sub(b: QuatD) = sub(QuatD(), this, b)
    infix fun sub_(b: QuatD) = sub(this, this, b)


    operator fun times(b: QuatD) = mul(QuatD(), this, b)
    operator fun times(b: Double) = mul(QuatD(), this, b)
    operator fun times(b: Vec3d) = mul(Vec3d(), this, b)
    operator fun times(b: Vec4d) = mul(QuatD(), this, b)

    fun mul(b: QuatD, res: QuatD = QuatD()) = mul(res, this, b)
    fun mul(b: Double, res: QuatD = QuatD()) = mul(res, this, b)
    fun mul(b: Vec3d, res: Vec3d = Vec3d()) = mul(res, this, b)
    fun mul(b: Vec4d, res: QuatD = QuatD()) = mul(res, this, b)

    infix fun mul(b: QuatD) = mul(QuatD(), this, b)
    infix fun mul(b: Double) = mul(QuatD(), this, b)
    infix fun mul(b: Vec3d) = mul(Vec3d(), this, b)
    infix fun mul(b: Vec4d) = mul(QuatD(), this, b)
    infix fun mul_(b: QuatD) = mul(this, this, b)
    infix fun mul_(b: Double) = mul(this, this, b)
    infix fun mul_(b: Vec3d) = mul(b, this, b)
    infix fun mul_(b: Vec4d) = mul(this, this, b)


    operator fun div(b: Double) = div(QuatD(), this, b)

    fun div(b: Double, res: QuatD = QuatD()) = div(res, this, b)

    infix fun div_(b: Double) = div(this, this, b)


    // -- Quat func --

    @JvmOverloads fun angleAxis(angle: Double, axis: Vec3d, res: QuatD = QuatD()) = glm.angleAxis(res, angle, axis)
    fun angleAxis_(angle: Double, axis: Vec3d) = glm.angleAxis(this, angle, axis)

    @JvmOverloads fun conjugate(res: QuatD = QuatD()) = glm.conjugate(res, this)
    fun conjugate_() = glm.conjugate(this, this)

    @JvmOverloads fun normalize(res: QuatD = QuatD()) = glm.normalize(res, this)
    fun normalize_() = glm.normalize(this, this)

    fun length() = glm.length(this)

    fun angle() = glm.angle(this)

    @JvmOverloads fun eulerAngles(res: Vec3d = Vec3d()) = glm.eulerAngles(res, this)

    @JvmOverloads fun slerp(b: QuatD, interp: Double, res: QuatD = QuatD()) = glm.slerp(res, this, b, interp)
    fun slerp_(b: QuatD, interp: Double) = glm.slerp(this, this, b, interp)
}