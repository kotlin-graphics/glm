package glm_.dualQuat

import glm_.mat2x4.Mat2x4d
import glm_.mat3x4.Mat3x4d
import glm_.quat.QuatD
import glm_.vec3.Vec3d
import glm_.vec4.Vec4d
import kotlin.math.sqrt


class DualQuatD(var real: QuatD, var dual: QuatD) {

    // -- Component accesses --

    /** Return the count of components of a dual quaternion */
    val length = 2

    operator fun get(index: Int) = when (index) {
        0 -> real
        1 -> dual
        else -> throw Error()
    }

    operator fun set(index: Int, quat: QuatD) = when (index) {
        0 -> real put quat
        1 -> dual put quat
        else -> throw Error()
    }

    // -- Implicit basic constructors --

    constructor() : this(QuatD(), QuatD(0.0))

    constructor(dualQuat: DualQuatD) : this(dualQuat.real, dualQuat.dual)

    constructor(realW: Double, realX: Double, realY: Double, realZ: Double,
                dualW: Double, dualX: Double, dualY: Double, dualZ: Double) : this(
            QuatD(realW, realX, realY, realZ), QuatD(dualW, dualX, dualY, dualZ))


    // -- Explicit basic constructors --

    constructor(real: QuatD) : this(real, QuatD(0.0))

    constructor(orientation: QuatD, translation: Vec3d) : this(orientation, QuatD(
            -0.5f * (translation.x * orientation.x + translation.y * orientation.y + translation.z * orientation.z),
            +0.5f * (translation.x * orientation.w + translation.y * orientation.z - translation.z * orientation.y),
            +0.5f * (-translation.x * orientation.z + translation.y * orientation.w + translation.z * orientation.x),
            +0.5f * (translation.x * orientation.y - translation.y * orientation.x + translation.z * orientation.w)))

    // -- Conversion constructors --

    constructor(m: Mat2x4d) : this() {
        dualquat_cast(m, this)
    }

    constructor(m: Mat3x4d) : this() {
        dualquat_cast(m, this)
    }

    // -- Lambda constructors --

    constructor(block: (Int) -> Double) : this(
            block(0), block(1), block(2), block(3),
            block(4), block(5), block(6), block(7))

    // -- Unary bit operators --

    operator fun unaryPlus() = this
    operator fun unaryMinus() = DualQuatD(-real, -dual)


    fun put(real: QuatD, dual: QuatD) {
        real.put(real.w, real.x, real.y, real.z)
        dual.put(dual.w, dual.x, dual.y, dual.z)
    }

    fun put(realW: Double, realX: Double, realY: Double, realZ: Double,
            dualW: Double, dualX: Double, dualY: Double, dualZ: Double) {
        real.put(realW, realX, realY, realZ)
        dual.put(dualW, dualX, dualY, dualZ)
    }

    operator fun invoke(realW: Double, realX: Double, realY: Double, realZ: Double,
                        dualW: Double, dualX: Double, dualY: Double, dualZ: Double): DualQuatD {
        put(realW, realX, realY, realZ, dualW, dualX, dualY, dualZ)
        return this
    }

    operator fun invoke(real: QuatD, dual: QuatD): DualQuatD {
        put(real, dual)
        return this
    }

    // -- Specific binary arithmetic operators --

    infix operator fun plus(b: DualQuatD) = plus(DualQuatD(), this, b)
    fun plus(b: DualQuatD, res: DualQuatD) = plus(res, this, b)
    infix operator fun plusAssign(b: DualQuatD) {
        plus(this, this, b)
    }

    infix operator fun times(b: DualQuatD) = times(DualQuatD(), this, b)
    infix operator fun times(b: Double) = times(DualQuatD(), this, b)
    infix operator fun times(b: Vec3d) = times(Vec3d(), this, b)
    infix operator fun times(b: Vec4d) = times(Vec4d(), this, b)
    fun times(b: DualQuatD, res: DualQuatD) = times(res, this, b)
    fun times(b: Double, res: DualQuatD) = times(res, this, b)
    fun times(b: Vec3d, res: Vec3d) = times(res, this, b)
    fun times(b: Vec4d, res: Vec4d) = times(res, this, b)
    infix operator fun timesAssign(b: DualQuatD) {
        times(this, this, b)
    }

    infix operator fun timesAssign(b: Double) {
        times(this, this, b)
    }

    infix operator fun timesAssign(b: Vec3d) {
        times(b, this, b)
    }

    infix operator fun timesAssign(b: Vec4d) {
        times(b, this, b)
    }


    infix operator fun div(b: Double) = div(DualQuatD(), this, b)
    fun div(b: Double, res: DualQuatD) = div(res, this, b)
    infix operator fun divAssign(b: Double) {
        div(this, this, b)
    }


    // -- Operations --

    /** Set the dual quaternion as identity.
     *  @see gtx_dual_quaternion */
    fun identity() {
        real.put(1.0, 0.0, 0.0, 0.0)
        dual.put(0.0, 0.0, 0.0, 0.0)
    }

    /** Returns a new normalized quaternion.
     *  @see gtx_dual_quaternion */
    fun normalize(): DualQuatD = div(real.length(), DualQuatD())

    /** Normalize the quaternion itself.
     *  @see gtx_dual_quaternion */
    fun normalizeAssign(): DualQuatD {
        divAssign(real.length())
        return this
    }

    /** Returns the linear interpolation of two dual quaternion.
     *  @see gtc_dual_quaternion */
    fun lerp(b: DualQuatD, a: Double, res: DualQuatD = DualQuatD()): DualQuatD {
        // Dual Quaternion Linear blend aka DLB:
        // Lerp is only defined in [0, 1]
        assert(a in 0.0..1.0)
        val k = if (real dot b.real < 0.0) -a else a
        val j = 1.0 - a
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
    fun inverse(res: DualQuatD = DualQuatD()): DualQuatD {
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
        val w = dualW + realW * (-2.0 * dot)
        val x = dualX + realX * (-2.0 * dot)
        val y = dualY + realY * (-2.0 * dot)
        val z = dualZ + realZ * (-2.0 * dot)
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

    /** Converts a 2 * 4 matrix (matrix which holds real and dual parts) to a quaternion. TODO move, no reason to be in class
     *  @see gtx_dual_quaternion */
    fun dualquat_cast(x: Mat2x4d, res: DualQuatD = DualQuatD()): DualQuatD = res(x[0].w, x[0].x, x[0].y, x[0].z, x[1].w, x[1].x, x[1].y, x[1].z)

    /** Converts a 3 * 4 matrix (augmented matrix rotation + translation) to a quaternion.
     *  @see gtx_dual_quaternion */
    fun dualquat_cast(m: Mat3x4d, res: DualQuatD = DualQuatD()): DualQuatD {

        val real = QuatD()

        val trace = m[0, 0] + m[1, 1] + m[2, 2]
        when {
            trace > 0f -> {
                val r = sqrt(1.0 + trace)
                val invR = 0.5 / r
                real.w = 0.5 * r
                real.x = (m[2, 1] - m[1, 2]) * invR
                real.y = (m[0, 2] - m[2, 0]) * invR
                real.z = (m[1, 0] - m[0, 1]) * invR
            }
            m[0, 0] > m[1, 1] && m[0, 0] > m[2, 2] -> {
                val r = sqrt(1.0 + m[0, 0] - m[1, 1] - m[2, 2])
                val invR = 0.5 / r
                real.x = 0.5 * r
                real.y = (m[1, 0] + m[0, 1]) * invR
                real.z = (m[0, 2] + m[2, 0]) * invR
                real.w = (m[2, 1] - m[1, 2]) * invR
            }
            m[1, 1] > m[2, 2] -> {
                val r = sqrt(1.0 + m[1, 1] - m[0, 0] - m[2, 2])
                val invR = 0.5 / r
                real.x = (m[1, 0] + m[0, 1]) * invR
                real.y = 0.5 * r
                real.z = (m[2, 1] + m[1, 2]) * invR
                real.w = (m[0, 2] - m[2, 0]) * invR
            }
            else -> {
                val r = sqrt(1.0 + m[2, 2] - m[0, 0] - m[1, 1])
                val invR = 0.5 / r
                real.x = (m[0, 2] + m[2, 0]) * invR
                real.y = (m[2, 1] + m[1, 2]) * invR
                real.z = 0.5 * r
                real.w = (m[1, 0] - m[0, 1]) * invR
            }
        }

        val dual = QuatD(
                -0.5 * (m[0, 3] * real.x + m[1, 3] * real.y + m[2, 3] * real.z),
                0.5 * (m[0, 3] * real.w + m[1, 3] * real.z - m[2, 3] * real.y),
                0.5 * (-m[0, 3] * real.z + m[1, 3] * real.w + m[2, 3] * real.x),
                0.5 * (m[0, 3] * real.y - m[1, 3] * real.x + m[2, 3] * real.w))
        return res(real, dual)
    }

    companion object : dualQuatD_operators {
        @JvmField
        val size = QuatD.size * 2

        /** Creates an identity dual quaternion.
         *  @see gtx_dual_quaternion */
        fun identity() = DualQuatD()
    }

    override fun equals(other: Any?) = other is DualQuatD && real == other.real && dual == other.dual
    override fun hashCode() = 31 * real.hashCode() + dual.hashCode()
}