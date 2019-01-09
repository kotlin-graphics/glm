package glm_.dualQuat

import glm_.mat2x4.Mat2x4
import glm_.mat3x4.Mat3x4
import glm_.quat.Quat
import glm_.vec3.Vec3
import glm_.vec4.Vec4
import kotlin.math.sqrt


class DualQuat(var real: Quat, var dual: Quat) {

    // -- Component accesses --

    /** Return the count of components of a dual quaternion */
    val length = 2

    operator fun get(index: Int) = when (index) {
        0 -> real
        1 -> dual
        else -> throw Error()
    }

    operator fun set(index: Int, quat: Quat) = when (index) {
        0 -> real put quat
        1 -> dual put quat
        else -> throw Error()
    }

    // -- Implicit basic constructors --

    constructor() : this(Quat(), Quat(0f))

    constructor(dualQuat: DualQuat) : this(Quat(dualQuat.real), Quat(dualQuat.dual))

    constructor(realW: Float, realX: Float, realY: Float, realZ: Float,
                dualW: Float, dualX: Float, dualY: Float, dualZ: Float) : this(
            Quat(realW, realX, realY, realZ), Quat(dualW, dualX, dualY, dualZ))


    // -- Explicit basic constructors --

    constructor(real: Quat) : this(real, Quat(0f))

    constructor(orientation: Quat, translation: Vec3) : this(orientation, Quat(
            -0.5f * (translation.x * orientation.x + translation.y * orientation.y + translation.z * orientation.z),
            +0.5f * (translation.x * orientation.w + translation.y * orientation.z - translation.z * orientation.y),
            +0.5f * (-translation.x * orientation.z + translation.y * orientation.w + translation.z * orientation.x),
            +0.5f * (translation.x * orientation.y - translation.y * orientation.x + translation.z * orientation.w)))

    // -- Conversion constructors --

    constructor(m: Mat2x4) : this() {
        dualquat_cast(m, this)
    }

    constructor(m: Mat3x4) : this() {
        dualquat_cast(m, this)
    }

    // -- Lambda constructors --

    constructor(block: (Int) -> Float) : this(
            block(0), block(1), block(2), block(3),
            block(4), block(5), block(6), block(7))

    // -- Unary bit operators --

    operator fun unaryPlus() = this
    operator fun unaryMinus() = DualQuat(-real, -dual)


    fun put(real: Quat, dual: Quat) {
        real.put(real.w, real.x, real.y, real.z)
        dual.put(dual.w, dual.x, dual.y, dual.z)
    }

    fun put(realW: Float, realX: Float, realY: Float, realZ: Float,
            dualW: Float, dualX: Float, dualY: Float, dualZ: Float) {
        real.put(realW, realX, realY, realZ)
        dual.put(dualW, dualX, dualY, dualZ)
    }

    operator fun invoke(realW: Float, realX: Float, realY: Float, realZ: Float,
                        dualW: Float, dualX: Float, dualY: Float, dualZ: Float): DualQuat {
        put(realW, realX, realY, realZ, dualW, dualX, dualY, dualZ)
        return this
    }

    operator fun invoke(real: Quat, dual: Quat): DualQuat {
        put(real, dual)
        return this
    }

    // -- Specific binary arithmetic operators --

    infix operator fun plus(b: DualQuat) = plus(DualQuat(), this, b)
    fun plus(b: DualQuat, res: DualQuat) = plus(res, this, b)
    infix operator fun plusAssign(b: DualQuat) {
        plus(this, this, b)
    }

    infix operator fun times(b: DualQuat) = times(DualQuat(), this, b)
    infix operator fun times(b: Float) = times(DualQuat(), this, b)
    infix operator fun times(b: Vec3) = times(Vec3(), this, b)
    infix operator fun times(b: Vec4) = times(Vec4(), this, b)
    fun times(b: DualQuat, res: DualQuat) = times(res, this, b)
    fun times(b: Float, res: DualQuat) = times(res, this, b)
    fun times(b: Vec3, res: Vec3) = times(res, this, b)
    fun times(b: Vec4, res: Vec4) = times(res, this, b)
    infix operator fun timesAssign(b: DualQuat) {
        times(this, this, b)
    }

    infix operator fun timesAssign(b: Float) {
        times(this, this, b)
    }

    infix operator fun timesAssign(b: Vec3) {
        times(b, this, b)
    }

    infix operator fun timesAssign(b: Vec4) {
        times(b, this, b)
    }


    infix operator fun div(b: Float) = div(DualQuat(), this, b)
    fun div(b: Float, res: DualQuat) = div(res, this, b)
    infix operator fun divAssign(b: Float) {
        div(this, this, b)
    }


    // -- Operations --

    /** Set the dual quaternion as identity.
     *  @see gtx_dual_quaternion */
    fun identity(): DualQuat {
        real.put(1f, 0f, 0f, 0f)
        dual.put(0f, 0f, 0f, 0f)
        return this
    }

    /** Returns a new normalized quaternion.
     *  @see gtx_dual_quaternion */
    fun normalize(): DualQuat = div(real.length(), DualQuat())

    /** Normalize the quaternion itself.
     *  @see gtx_dual_quaternion */
    fun normalizeAssign(): DualQuat {
        divAssign(real.length())
        return this
    }

    /** Returns the linear interpolation of two dual quaternion.
     *  @see gtc_dual_quaternion */
    fun lerp(b: DualQuat, a: Float, res: DualQuat = DualQuat()): DualQuat {
        // Dual Quaternion Linear blend aka DLB:
        // Lerp is only defined in [0, 1]
        assert(a in 0f..1f)
        val k = if (real dot b.real < 0f) -a else a
        val j = 1f - a
        return res(
                real.w * j + b.real.w * k,
                real.x * j + b.real.x * k,
                real.y * j + b.real.y * k,
                real.z * j + b.real.z * k,
                dual.z * j + b.dual.z * k,
                dual.z * j + b.dual.z * k,
                dual.z * j + b.dual.z * k,
                dual.z * j + b.dual.z * k)
    }

    /** Returns the q inverse.
     *  @see gtx_dual_quaternion */
    fun inverse(res: DualQuat = DualQuat()): DualQuat {
        // conjugate
        val realW = real.w
        val realX = -real.x
        val realY = -real.y
        val realZ = -real.z
        // conjugate
        val dualW = dual.w
        val dualX = -dual.x
        val dualY = -dual.y
        val dualZ = -dual.z

        val dot = realX * dualX + realY * dualY + realZ * dualZ + realW * dualW
        val w = dualW + realW * (-2f * dot)
        val x = dualX + realX * (-2f * dot)
        val y = dualY + realY * (-2f * dot)
        val z = dualZ + realZ * (-2f * dot)
        return res(realW, realX, realY, realZ, w, x, y, z)
    }

    /// Converts a quaternion to a 2 * 4 matrix.
    ///
    /// @see gtx_dual_quaternion
//    template<typename T, qualifier Q>
//    GLM_FUNC_DECL mat<2, 4, T, Q> mat2x4_cast(tdualquat<T, Q> const& x);

    /// Converts a quaternion to a 3 * 4 matrix.
    ///
    /// @see gtx_dual_quaternion
//    template<typename T, qualifier Q>
//    GLM_FUNC_DECL mat<3, 4, T, Q> mat3x4_cast(tdualquat<T, Q> const& x);

    /** Converts a 2 * 4 matrix (matrix which holds real and dual parts) to a quaternion.
     *  @see gtx_dual_quaternion */
    fun dualquat_cast(x: Mat2x4, res: DualQuat = DualQuat()): DualQuat = res(x[0].w, x[0].x, x[0].y, x[0].z, x[1].w, x[1].x, x[1].y, x[1].z)

    /** Converts a 3 * 4 matrix (augmented matrix rotation + translation) to a quaternion.
     *  @see gtx_dual_quaternion */
    fun dualquat_cast(m: Mat3x4, res: DualQuat = DualQuat()): DualQuat {

        val real = Quat()

        val trace = m[0, 0] + m[1, 1] + m[2, 2]
        when {
            trace > 0f -> {
                val r = sqrt(1f + trace)
                val invR = 0.5f / r
                real.w = 0.5f * r
                real.x = (m[2, 1] - m[1, 2]) * invR
                real.y = (m[0, 2] - m[2, 0]) * invR
                real.z = (m[1, 0] - m[0, 1]) * invR
            }
            m[0, 0] > m[1, 1] && m[0, 0] > m[2, 2] -> {
                val r = sqrt(1f + m[0, 0] - m[1, 1] - m[2, 2])
                val invR = 0.5f / r
                real.x = 0.5f * r
                real.y = (m[1, 0] + m[0, 1]) * invR
                real.z = (m[0, 2] + m[2, 0]) * invR
                real.w = (m[2, 1] - m[1, 2]) * invR
            }
            m[1, 1] > m[2, 2] -> {
                val r = sqrt(1f + m[1, 1] - m[0, 0] - m[2, 2])
                val invR = 0.5f / r
                real.x = (m[1, 0] + m[0, 1]) * invR
                real.y = 0.5f * r
                real.z = (m[2, 1] + m[1, 2]) * invR
                real.w = (m[0, 2] - m[2, 0]) * invR
            }
            else -> {
                val r = sqrt(1f + m[2, 2] - m[0, 0] - m[1, 1])
                val invR = 0.5f / r
                real.x = (m[0, 2] + m[2, 0]) * invR
                real.y = (m[2, 1] + m[1, 2]) * invR
                real.z = 0.5f * r
                real.w = (m[1, 0] - m[0, 1]) * invR
            }
        }

        val dual = Quat(
                -0.5f * (m[0, 3] * real.x + m[1, 3] * real.y + m[2, 3] * real.z),
                0.5f * (m[0, 3] * real.w + m[1, 3] * real.z - m[2, 3] * real.y),
                0.5f * (-m[0, 3] * real.z + m[1, 3] * real.w + m[2, 3] * real.x),
                0.5f * (m[0, 3] * real.y - m[1, 3] * real.x + m[2, 3] * real.w))
        return res(real, dual)
    }

    companion object : dualQuat_operators {
        @JvmField
        val size = Quat.size * 2

        /** Creates an identity dual quaternion.
         *  @see gtx_dual_quaternion */
        fun identity() = DualQuat()
    }

    override fun equals(other: Any?) = other is DualQuat && real == other.real && dual == other.dual
    override fun hashCode() = 31 * real.hashCode() + dual.hashCode()
}