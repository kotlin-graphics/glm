package glm_.ext.quaternion

import glm_.glm
import glm_.quat.Quat
import glm_.quat.QuatD

interface ext_quaternionCommon {

    /** Spherical linear interpolation of two quaternions.
     * The interpolation is oriented main.and the rotation is performed at constant speed.
     * For short path spherical linear interpolation, use the slerp function.     */
    fun mix(a: Quat, b: Quat, interp: Float, res: Quat): Quat {

        val cosTheta = glm.dot(a, b)

        // Perform a linear interpolation when cosTheta is close to 1 to avoid side effect of sin(angle) becoming a zero denominator
        if (cosTheta > 1f - glm.epsilonF) {
            // Linear interpolation
            res.w = glm.mix(a.w, b.w, interp)
            res.x = glm.mix(a.x, b.x, interp)
            res.y = glm.mix(a.y, b.y, interp)
            res.z = glm.mix(a.z, b.z, interp)
            return res
        } else {
            // Essential Mathematics, page 467
            val angle = glm.acos(cosTheta)
            val s0 = glm.sin((1f - interp) * angle)
            val s1 = glm.sin(interp * angle)
            val s2 = glm.sin(angle)
            res.w = (s0 * a.w + s1 * b.w) / s2
            res.x = (s0 * a.x + s1 * b.x) / s2
            res.y = (s0 * a.y + s1 * b.y) / s2
            res.z = (s0 * a.z + s1 * b.z) / s2
            return res
        }
    }

    fun mix(a: Quat, b: Quat, interp: Float): Quat =
            mix(a, b, interp, Quat())

    /** Spherical linear interpolation of two quaternions.
     * The interpolation is oriented main.and the rotation is performed at constant speed.
     * For short path spherical linear interpolation, use the slerp function.     */
    fun mix(a: QuatD, b: QuatD, interp: Double, res: QuatD): QuatD {

        val cosTheta = glm.dot(a, b)

        // Perform a linear interpolation when cosTheta is close to 1 to avoid side effect of sin(angle) becoming a zero denominator
        if (cosTheta > 1.0 - glm.epsilon) {
            // Linear interpolation
            res.w = glm.mix(a.w, b.w, interp)
            res.x = glm.mix(a.x, b.x, interp)
            res.y = glm.mix(a.y, b.y, interp)
            res.z = glm.mix(a.z, b.z, interp)
            return res
        } else {
            // Essential Mathematics, page 467
            val angle = glm.acos(cosTheta)
            val s0 = glm.sin((1.0 - interp) * angle)
            val s1 = glm.sin(interp * angle)
            val s2 = glm.sin(angle)
            res.w = (s0 * a.w + s1 * b.w) / s2
            res.x = (s0 * a.x + s1 * b.x) / s2
            res.y = (s0 * a.y + s1 * b.y) / s2
            res.z = (s0 * a.z + s1 * b.z) / s2
            return res
        }
    }

    fun mix(a: QuatD, b: QuatD, interp: Double): QuatD =
            mix(a, b, interp, QuatD())


    /** Linear interpolation of two quaternions.
     * The interpolation is oriented.     */
    fun lerp(a: Quat, b: Quat, interp: Float, res: Quat): Quat {
        // Lerp is only defined in [0, 1]
        if (interp < 0f || interp > 1f)
            throw ArithmeticException("interp outside [0, 1]")

        res.w = a.w * (1f - interp) + b.w * interp
        res.x = a.x * (1f - interp) + b.x * interp
        res.y = a.y * (1f - interp) + b.y * interp
        res.z = a.z * (1f - interp) + b.z * interp
        return res
    }

    fun lerp(a: Quat, b: Quat, interp: Float): Quat =
            lerp(a, b, interp, Quat())

    /** Linear interpolation of two quaternions.
     * The interpolation is oriented.     */
    fun lerp(a: QuatD, b: QuatD, interp: Double, res: QuatD): QuatD {
        // Lerp is only defined in [0, 1]
        if (interp < 0.0 || interp > 1.0)
            throw ArithmeticException("interp outside [0, 1]")

        res.w = a.w * (1.0 - interp) + b.w * interp
        res.x = a.x * (1.0 - interp) + b.x * interp
        res.y = a.y * (1.0 - interp) + b.y * interp
        res.z = a.z * (1.0 - interp) + b.z * interp
        return res
    }

    fun lerp(a: QuatD, b: QuatD, interp: Double): QuatD =
            lerp(a, b, interp, QuatD())


    /** Spherical linear interpolation of two quaternions.
     * The interpolation always take the short path main.and the rotation is performed at constant speed.     */
    fun slerp(a: Quat, b: Quat, interp: Float, res: Quat): Quat {

        var zW = b.w
        var zX = b.x
        var zY = b.y
        var zZ = b.z

        var cosTheta = glm.dot(a, b)

        // If cosTheta < 0, the interpolation will take the long way around the sphere.
        // To fix this, one quat must be negated.
        if (cosTheta < 0f) {
            zW = -b.w
            zX = -b.x
            zY = -b.y
            zZ = -b.z
            cosTheta = -cosTheta
        }

        // Perform a linear interpolation when cosTheta is close to 1 to avoid side effect of sin(angle) becoming a zero denominator
        if (cosTheta > 1f - glm._epsilonF) {
            // Linear interpolation
            res.w = glm.mix(a.w, zW, interp)
            res.x = glm.mix(a.x, zX, interp)
            res.y = glm.mix(a.y, zY, interp)
            res.z = glm.mix(a.z, zZ, interp)
            return res
        } else {
            // Essential Mathematics, page 467
            val angle = glm.acos(cosTheta)
            val s0 = glm.sin((1f - interp) * angle)
            val s1 = glm.sin(interp * angle)
            val s2 = glm.sin(angle)
            res.w = (s0 * a.w + s1 * zW) / s2
            res.x = (s0 * a.x + s1 * zX) / s2
            res.y = (s0 * a.y + s1 * zY) / s2
            res.z = (s0 * a.z + s1 * zZ) / s2
            return res
        }
    }

    fun slerp(a: Quat, b: Quat, interp: Float): Quat =
            slerp(a, b, interp, Quat())

    /** Spherical linear interpolation of two quaternions.
     * The interpolation always take the short path main.and the rotation is performed at constant speed.     */
    fun slerp(a: QuatD, b: QuatD, interp: Double, res: QuatD): QuatD {

        var zW = b.w
        var zX = b.x
        var zY = b.y
        var zZ = b.z

        var cosTheta = glm.dot(a, b)

        // If cosTheta < 0, the interpolation will take the long way around the sphere.
        // To fix this, one quat must be negated.
        if (cosTheta < 0.0) {
            zW = -b.w
            zX = -b.x
            zY = -b.y
            zZ = -b.z
            cosTheta = -cosTheta
        }

        // Perform a linear interpolation when cosTheta is close to 1 to avoid side effect of sin(angle) becoming a zero denominator
        if (cosTheta > 1.0 - glm.epsilon) {
            // Linear interpolation
            res.w = glm.mix(a.w, zW, interp)
            res.x = glm.mix(a.x, zX, interp)
            res.y = glm.mix(a.y, zY, interp)
            res.z = glm.mix(a.z, zZ, interp)
            return res
        } else {
            // Essential Mathematics, page 467
            val angle = glm.acos(cosTheta)
            val s0 = glm.sin((1.0 - interp) * angle)
            val s1 = glm.sin(interp * angle)
            val s2 = glm.sin(angle)
            res.w = (s0 * a.w + s1 * b.w) / s2
            res.x = (s0 * a.x + s1 * b.x) / s2
            res.y = (s0 * a.y + s1 * b.y) / s2
            res.z = (s0 * a.z + s1 * b.z) / s2
            return res
        }
    }

    fun slerp(a: QuatD, b: QuatD, interp: Double): QuatD =
            slerp(a, b, interp, QuatD())


    /** Returns the q conjugate.    */
    fun conjugate(a: Quat, res: Quat): Quat {
        res.w = a.w
        res.x = -a.x
        res.y = -a.y
        res.z = -a.z
        return res
    }

    infix fun conjugate(a: Quat): Quat =
            conjugate(a, Quat())

    /** Returns the q conjugate.    */
    fun conjugate(a: QuatD, res: QuatD): QuatD {
        res.w = a.w
        res.x = -a.x
        res.y = -a.y
        res.z = -a.z
        return res
    }

    infix fun conjugate(a: QuatD): QuatD =
            conjugate(a, QuatD())


    /** Returns the q inverse.  */
    fun inverse(a: Quat, res: Quat): Quat {
        val dot = glm.dot(a, a)
        res.w = a.w / dot
        res.x = -a.x / dot
        res.y = -a.y / dot
        res.z = -a.z / dot
        return res
    }

    infix fun inverse(a: Quat): Quat =
            inverse(a, Quat())

    /** Returns the q inverse.  */
    fun inverse(a: QuatD, res: QuatD): QuatD {
        val dot = glm.dot(a, a)
        res.w = a.w / dot
        res.x = -a.x / dot
        res.y = -a.y / dot
        res.z = -a.z / dot
        return res
    }

    infix fun inverse(a: QuatD): QuatD =
            inverse(a, QuatD())

    /// Returns true if x holds a NaN (not a number)
    /// representation in the underlying implementation's set of
    /// floating point representations. Returns false otherwise,
    /// including for implementations with no NaN
    /// representations.
    ///
    /// /!\ When using compiler fast math, this function may fail.
    ///
    /// @tparam T Floating-point scalar types.
    ///
    /// @see ext_quaternion_common
//    template<typename T, qualifier Q>
//    GLM_FUNC_DECL vec<4, bool, Q> isnan(qua<T, Q> const & x);
//
//    /// Returns true if x holds a positive infinity or negative
//    /// infinity representation in the underlying implementation's
//    /// set of floating point representations. Returns false
//    /// otherwise, including for implementations with no infinity
//    /// representations.
//    ///
//    /// @tparam T Floating-point scalar types.
//    ///
//    /// @see ext_quaternion_common
//    template<typename T, qualifier Q>
//    GLM_FUNC_DECL vec<4, bool, Q> isinf(qua<T, Q> const & x);
}