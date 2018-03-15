package glm_.quat

import glm_.*
import glm_.glm.cos
import glm_.glm.sin
import glm_.mat3x3.Mat3
import glm_.mat4x4.Mat4
import glm_.vec3.Vec3
import glm_.vec4.Vec4
import glm_.vec4.Vec4t
import java.io.InputStream
import kotlin.math.abs
import kotlin.math.sqrt

/**
 * Created by GBarbieri on 15.11.2016.
 */
class Quat(w: Float, x: Float, y: Float, z: Float) : QuatT<Float>(w, x, y, z), Quaternion<Float> {


    // -- Implicit basic constructors --

    constructor() : this(1f, 0f, 0f, 0f)
    constructor(q: Quat) : this(q.w, q.x, q.y, q.z)
    constructor(q: Quaternion<Number>) : this(q[3], q[0], q[1], q[2])
    constructor(s: Float, v: Vec3) : this(s, v.x, v.y, v.z)
    constructor(u: Vec3, v: Vec3) : this() {
        val normUnormV = sqrt((u dot u) * (v dot v))
        var realPart = normUnormV + (u dot v)
        val w: Vec3

        w = if (realPart < 1e-6f * normUnormV) {
            /*  If u and v are exactly opposite, rotate 180 degrees around an arbitrary orthogonal axis.
                Axis normalisation can happen later, when we normalise the quaternion. */
            realPart = 0f
            if (abs(u.x) > abs(u.z)) Vec3(-u.y, u.x, 0f) else Vec3(0f, -u.z, u.y)
        } else // Otherwise, build quaternion the standard way.
            u cross v

        put(Quat(realPart, w.x, w.y, w.z).normalizeAssign())
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

    constructor(vec4: Vec4) : this(vec4.w, vec4.x, vec4.y, vec4.z)

//    constructor(m: Mat3x3) : this() {
//        quat_cast(m, this)
//    }
//    constructor(m: Mat4x4) : this() {
//        quat_cast(m, this)
//    }

    constructor(inputStream: InputStream, bigEndian: Boolean = true) :
            this(inputStream.float(bigEndian), inputStream.float(bigEndian), inputStream.float(bigEndian), inputStream.float(bigEndian))

    infix fun to(res: Mat3) = glm.mat3_cast(this, res)
    fun toMat3() = glm.mat3_cast(this, Mat3())

    infix fun to(res: Mat4) = glm.mat4_cast(this, res)
    fun toMat4() = glm.mat4_cast(this, Mat4())

    // -- Explicit basic constructors --

    constructor(q: QuatD) : this(q.w.f, q.x.f, q.y.f, q.z.f)
    constructor(w: Number, x: Number, y: Number, z: Number) : this(w.f, x.f, y.f, z.f)
    constructor(vec4: Vec4t<*>) : this(vec4.w.f, vec4.x.f, vec4.y.f, vec4.z.f)


    fun put(w: Float, x: Float, y: Float, z: Float): Quat {
        this.w = w
        this.x = x
        this.y = y
        this.z = z
        return this
    }

    infix fun put(quat: Quat) = put(quat.w, quat.x, quat.y, quat.z)

    // -- Component accesses --

    override operator fun get(index: Int) = when (index) {
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


    companion object : quat_operators(), quat_func {

        @JvmField
        val size = 4 * Float.BYTES
    }


    // -- Unary arithmetic operators --

    operator fun unaryPlus() = this

    operator fun unaryMinus() = Quat(-w, -x, -y, -z)


    // -- Specific binary arithmetic operators --

    infix operator fun plus(b: Quat) = plus(Quat(), this, b)
    fun plus(b: Quat, res: Quat) = plus(res, this, b)
    infix operator fun plusAssign(b: Quat) {
        plus(this, this, b)
    }

    infix operator fun minus(b: Quat) = minus(Quat(), this, b)
    fun minus(b: Quat, res: Quat) = minus(res, this, b)
    infix operator fun minusAssign(b: Quat) {
        minus(this, this, b)
    }


    infix operator fun times(b: Quat) = times(Quat(), this, b)
    infix operator fun times(b: Float) = times(Quat(), this, b)
    infix operator fun times(b: Vec3) = times(Vec3(), this, b)
    infix operator fun times(b: Vec4) = times(Quat(), this, b)
    fun times(b: Quat, res: Quat) = times(res, this, b)
    fun times(b: Float, res: Quat) = times(res, this, b)
    fun times(b: Vec3, res: Vec3) = times(res, this, b)
    fun times(b: Vec4, res: Quat) = times(res, this, b)
    infix operator fun timesAssign(b: Quat) {
        times(this, this, b)
    }

    infix operator fun timesAssign(b: Float) {
        times(this, this, b)
    }

    infix operator fun timesAssign(b: Vec3) {
        times(b, this, b)
    }

    infix operator fun timesAssign(b: Vec4) {
        times(this, this, b)
    }


    infix operator fun div(b: Float) = div(Quat(), this, b)
    fun div(b: Float, res: Quat) = div(res, this, b)
    infix operator fun divAssign(b: Float) {
        div(this, this, b)
    }


    // -- Quat func --

    fun length() = glm.length(this)

    @JvmOverloads
    fun normalize(res: Quat = Quat()) = glm.normalize(this, res)

    fun normalizeAssign() = glm.normalize(this, this)

    infix fun dot(b: Quat) = glm.dot(this, b)

    @JvmOverloads
    fun angleAxis(angle: Float, axis: Vec3, res: Quat = Quat()) = glm.angleAxis(angle, axis, res)

    fun angleAxisAssign(angle: Float, axis: Vec3) = glm.angleAxis(angle, axis, this)

    @JvmOverloads
    fun conjugate(res: Quat = Quat()) = glm.conjugate(this, res)

    fun conjugateAssign() = glm.conjugate(this, this)

    @JvmOverloads
    fun inverse(res: Quat = Quat()) = glm.inverse(this, res)

    fun inverseAssign() = glm.inverse(this, this)

    fun angle() = glm.angle(this)

    @JvmOverloads
    fun eulerAngles(res: Vec3 = Vec3()) = glm.eulerAngles(this, res)

    @JvmOverloads
    fun slerp(b: Quat, interp: Float, res: Quat = Quat()) = glm.slerp(this, b, interp, res)

    fun slerpAssign(b: Quat, interp: Float) = glm.slerp(this, b, interp, this)


    @JvmOverloads
    fun vectorize(res: Vec4 = Vec4()) = res.put(x, y, z, w)


    override fun toString() = "($w | $x, $y, $z)"
    override fun equals(other: Any?) = other is Quat && this[0] == other[0] && this[1] == other[1] && this[2] == other[2] && this[3] == other[3]

    override fun hashCode() = 31 * (31 * (31 * w.hashCode() + x.hashCode()) + y.hashCode()) + z.hashCode()

    override fun component1() = x
    override fun component2() = y
    override fun component3() = z
    override fun component4() = w
}