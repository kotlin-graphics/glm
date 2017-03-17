package glm.quat

import glm.BYTES
import glm.Glm.cos
import glm.Glm.dot
import glm.Glm.sin
import glm.f
import glm.glm
import glm.mat.Mat3
import glm.mat.Mat4
import glm.mat.QuatT
import glm.vec.Vec4t
import glm.vec._3.Vec3
import glm.vec._4.Vec4

/**
 * Created by GBarbieri on 15.11.2016.
 */
class Quat(w: Float, x: Float, y: Float, z: Float) : QuatT<Float>(w, x, y, z) {


    // -- Implicit basic constructors --

    constructor() : this(1f, 0f, 0f, 0f)
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

    constructor(vec4: Vec4) : this(vec4.w, vec4.x, vec4.y, vec4.z)

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
    constructor(vec4: Vec4t<*>) : this(vec4.w.f, vec4.x.f, vec4.y.f, vec4.z.f)


    fun put(w: Float, x: Float, y: Float, z: Float): Quat {
        this.w = w
        this.x = x
        this.y = y
        this.z = z
        return this
    }

    fun put(quat: Quat) = put(quat.w, quat.x, quat.y, quat.z)

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

        @JvmField val SIZE = 4 * Float.BYTES
    }


    // -- Unary arithmetic operators --

    operator fun unaryPlus() = this

    operator fun unaryMinus() = Quat(-w, -x, -y, -z)


    // -- Specific binary arithmetic operators --

    infix operator fun plus(b: Quat) = plus(Quat(), this, b)
    fun plus(b: Quat, res: Quat) = plus(res, this, b)
    infix fun plus_(b: Quat) = plus(this, this, b)

    infix operator fun minus(b: Quat) = minus(Quat(), this, b)
    fun minus(b: Quat, res: Quat) = minus(res, this, b)
    infix fun minus_(b: Quat) = minus(this, this, b)

    
    infix operator fun times(b: Quat) = times(Quat(), this, b)
    infix operator fun times(b: Float) = times(Quat(), this, b)
    infix operator fun times(b: Vec3) = times(Vec3(), this, b)
    infix operator fun times(b: Vec4) = times(Quat(), this, b)
    fun times(b: Quat, res: Quat) = times(res, this, b)
    fun times(b: Float, res: Quat) = times(res, this, b)
    fun times(b: Vec3, res: Vec3) = times(res, this, b)
    fun times(b: Vec4, res: Quat) = times(res, this, b)
    infix fun times_(b: Quat) = times(this, this, b)
    infix fun times_(b: Float) = times(this, this, b)
    infix fun times_(b: Vec3) = times(b, this, b)
    infix fun times_(b: Vec4) = times(this, this, b)


    infix operator fun div(b: Float) = div(Quat(), this, b)
    fun div(b: Float, res: Quat) = div(res, this, b)
    infix fun div_(b: Float) = div(this, this, b)


    // -- Quat func --

    fun length() = glm.length(this)

    @JvmOverloads fun normalize(res: Quat = Quat()) = glm.normalize(res, this)
    fun normalize_() = glm.normalize(this, this)

    infix fun dot(b: Quat) = glm.dot(this, b)

    @JvmOverloads fun angleAxis(angle: Float, axis: Vec3, res: Quat = Quat()) = glm.angleAxis(res, angle, axis)
    fun angleAxis_(angle: Float, axis: Vec3) = glm.angleAxis(this, angle, axis)

    @JvmOverloads fun conjugate(res: Quat = Quat()) = glm.conjugate(res, this)
    fun conjugate_() = glm.conjugate(this, this)

    @JvmOverloads fun inverse(res: Quat = Quat()) = glm.inverse(res, this)
    fun inverse_() = glm.inverse(this, this)

    fun angle() = glm.angle(this)

    @JvmOverloads fun eulerAngles(res: Vec3 = Vec3()) = glm.eulerAngles(res, this)

    @JvmOverloads fun slerp(b: Quat, interp: Float, res: Quat = Quat()) = glm.slerp(res, this, b, interp)
    fun slerp_(b: Quat, interp: Float) = glm.slerp(this, this, b, interp)


    override fun toString() = "($x, $y, $z), $w"

    override fun equals(other: Any?) =
            if (other is Quat)
                this[0] == other[0] && this[1] == other[1] && this[2] == other[2] && this[3] == other[3]
            else false

    @JvmOverloads fun vectorize(res: Vec4 = Vec4()) = res.put(x, y, z, w)
}