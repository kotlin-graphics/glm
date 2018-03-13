package glm_.quat

import glm_.BYTES
import glm_.Quaternion
import glm_.d
import glm_.glm
import glm_.vec3.Vec3
import glm_.vec3.Vec3d
import glm_.vec4.Vec4d
import glm_.vec4.Vec4t


/**
 * Created by GBarbieri on 15.11.2016.
 */
class QuatD(w: Double, x: Double, y: Double, z: Double) : QuatT<Double>(w, x, y, z), Quaternion<Double> {

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
        val cX = glm.cos(eX)
        val cY = glm.cos(eY)
        val cZ = glm.cos(eZ)
        val sX = glm.sin(eX)
        val sY = glm.sin(eY)
        val sZ = glm.sin(eZ)
        w = cX * cY * cZ + sX * sY * sZ
        x = sX * cY * cZ - cX * sY * sZ
        y = cX * sY * cZ + sX * cY * sZ
        z = cX * cY * sZ - sX * sY * cZ
    }

    constructor(vec4: Vec4d) : this(vec4.w, vec4.x, vec4.y, vec4.z)
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

    constructor(q: QuatD) : this(q.w.d, q.x.d, q.y.d, q.z.d)
    constructor(w: Number, x: Number, y: Number, z: Number) : this(w.d, x.d, y.d, z.d)
    constructor(vec4: Vec4t<*>) : this(vec4.w.d, vec4.x.d, vec4.y.d, vec4.z.d)


    fun put(w: Double, x: Double, y: Double, z: Double): QuatD {
        this.w = w
        this.x = x
        this.y = y
        this.z = z
        return this
    }

    infix fun put(quat: QuatD) = put(quat.w, quat.x, quat.y, quat.z)

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


    companion object : quatD_operators(), quat_func {

        @JvmField
        val size = 4 * Float.BYTES
    }


    // -- Unary arithmetic operators --

    operator fun unaryPlus() = this

    operator fun unaryMinus() = QuatD(-w, -x, -y, -z)


    // -- Specific binary arithmetic operators --

    infix operator fun plus(b: QuatD) = plus(QuatD(), this, b)
    fun plus(b: QuatD, res: QuatD) = plus(res, this, b)
    infix operator fun plusAssign(b: QuatD) {
        plus(this, this, b)
    }


    operator fun minus(b: QuatD) = minus(QuatD(), this, b)
    fun minus(b: QuatD, res: QuatD) = minus(res, this, b)
    infix operator fun minusAssign(b: QuatD) {
        minus(this, this, b)
    }


    infix operator fun times(b: QuatD) = times(QuatD(), this, b)
    infix operator fun times(b: Double) = times(QuatD(), this, b)
    infix operator fun times(b: Vec3d) = times(Vec3d(), this, b)
    infix operator fun times(b: Vec4d) = times(QuatD(), this, b)
    fun times(b: QuatD, res: QuatD) = times(res, this, b)
    fun times(b: Double, res: QuatD) = times(res, this, b)
    fun times(b: Vec3d, res: Vec3d) = times(res, this, b)
    fun times(b: Vec4d, res: QuatD) = times(res, this, b)
    infix fun timesAssign(b: QuatD) = times(this, this, b)
    infix fun timesAssign(b: Double) = times(this, this, b)
    infix fun timesAssign(b: Vec3d) = times(b, this, b)
    infix fun timesAssign(b: Vec4d) = times(this, this, b)


    infix operator fun div(b: Double) = div(QuatD(), this, b)
    fun div(b: Double, res: QuatD) = div(res, this, b)
    infix operator fun divAssign(b: Double) {
        div(this, this, b)
    }


    // -- Quat func --

    fun length() = glm.length(this)

    @JvmOverloads
    fun normalize(res: QuatD = QuatD()) = glm.normalize(this, res)

    fun normalizeAssign() = glm.normalize(this, this)

    infix fun dot(b: QuatD) = glm.dot(this, b)

    @JvmOverloads
    fun angleAxis(angle: Double, axis: Vec3d, res: QuatD = QuatD()) = glm.angleAxis(angle, axis, res)

    fun angleAxisAssign(angle: Double, axis: Vec3d) = glm.angleAxis(angle, axis, this)

    @JvmOverloads
    fun conjugate(res: QuatD = QuatD()) = glm.conjugate(this, res)

    fun conjugateAssign() = glm.conjugate(this, this)

    @JvmOverloads
    fun inverse(res: QuatD = QuatD()) = glm.inverse(this, res)

    fun inverseAssign() = glm.inverse(this, this)

    fun angle() = glm.angle(this)

    @JvmOverloads
    fun eulerAngles(res: Vec3d = Vec3d()) = glm.eulerAngles(this, res)

    @JvmOverloads
    fun slerp(b: QuatD, interp: Double, res: QuatD = QuatD()) = glm.slerp(this, b, interp, res)

    fun slerpAssign(b: QuatD, interp: Double) = glm.slerp(this, b, interp, this)


    override fun toString() = "($x, $y, $z), $w"

    override fun equals(other: Any?) = other is QuatD && this[0] == other[0] && this[1] == other[1] && this[2] == other[2] && this[3] == other[3]
    override fun hashCode() = 31 * (31 * (31 * w.hashCode() + x.hashCode()) + y.hashCode()) + z.hashCode()

    @JvmOverloads
    fun vectorize(res: Vec4d = Vec4d()) = res.put(x, y, z, w)

    override fun component1() = x
    override fun component2() = y
    override fun component3() = z
    override fun component4() = w
}