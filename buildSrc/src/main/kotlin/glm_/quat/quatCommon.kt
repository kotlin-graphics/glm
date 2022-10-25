package glm_.quat

import glm_.WxyzJoint
import glm_.XyzwJoint
import glm_.gen.Generator
import glm_.wxyzJoint
import glm_.xyzwJoint

fun Generator.quatCommon(type: String, extension: String, conversion: String, id: String, part: Generator.Part) {

    +"// quaternion common"

    val `wxyz type` = wxyzJoint { "$it: $type" }
    val xyz = xyzwJoint(3)
    val xyzw = xyzwJoint(4)
    val `xyz type` = xyzwJoint(3) { "$it: $type" }
    val `xyzw type` = xyzwJoint(4) { "$it: $type" }
    val `v,xyz` = xyzwJoint(3) { "v.$it" }
    val `v,xyzw` = xyzwJoint(4) { "v.$it" }
    val vXyz = XyzwJoint(3) { "v$it" }
    val vXyzw = XyzwJoint(4) { "v$it" }
    val `vXyz type` = XyzwJoint(3) { "v$it: $type" }
    val `vXyzw type` = XyzwJoint(4) { "v$it: $type" }
    val wxyz = wxyzJoint()
    val `q,wxyz` = wxyzJoint { "q.$it" }
    val `qWxyz type` = WxyzJoint { "q$it: $type" }
    val qWxyz = WxyzJoint { "q$it" }
    val `p,wxyz` = wxyzJoint { "p.$it" }
    val `pWxyz type` = WxyzJoint { "p$it: $type" }
    val pWxyz = WxyzJoint { "p$it" }
//    val `2` = type.`2`

    fun mix(x: String, y: String, a: String) = docs("""
        |Spherical linear interpolation of two quaternions.
        |The interpolation is oriented and the rotation is performed at constant speed.
        |For short path spherical linear interpolation, use the slerp function.
        |
        |@param $x A quaternion
        |@param $y A quaternion
        |@param $a Interpolation factor. The interpolation is defined beyond the range `[0, 1]`.
        |
        |@see - slerp(qua<T, Q> const& x, qua<T, Q> const& y, T const& a)""")
    when(part) {
        Generator.Part.Class -> {}
        Generator.Part.CompanionObject -> {
//            mix()
//            +"""
//                inline fun <R> mix($`qWxyz type`, $`pWxyz type`, a: $type, res: ($`wxyz type`) -> R): R {
//                    val cosTheta = dot(x, y);
//
//                    // Perform a linear interpolation when cosTheta is close to 1 to avoid side effect of sin(angle) becoming a zero denominator
//                    if(cosTheta > static_cast<T>(1) - epsilon<T>())
//                    {
//                        // Linear interpolation
//                        return qua<T, Q>(
//                            mix(x.w, y.w, a),
//                            mix(x.x, y.x, a),
//                            mix(x.y, y.y, a),
//                            mix(x.z, y.z, a));
//                    }
//                    else
//                    {
//                        // Essential Mathematics, page 467
//                        T angle = acos(cosTheta);
//                        return (sin((static_cast<T>(1) - a) * angle) * x + sin(a * angle) * y) / sin(angle);
//                    }
//                }"""
        }
    }
//    /// Linear interpolation of two quaternions.
//    /// The interpolation is oriented.
//    ///
//    /// @param x A quaternion
//    /// @param y A quaternion
//    /// @param a Interpolation factor. The interpolation is defined in the range [0, 1].
//    ///
//    /// @tparam T A floating-point scalar type
//    /// @tparam Q A value from qualifier enum
//    template<typename T, qualifier Q>
//    GLM_FUNC_DECL qua<T, Q> lerp(qua<T, Q> const& x, qua<T, Q> const& y, T a);
//
//    /// Spherical linear interpolation of two quaternions.
//    /// The interpolation always take the short path and the rotation is performed at constant speed.
//    ///
//    /// @param x A quaternion
//    /// @param y A quaternion
//    /// @param a Interpolation factor. The interpolation is defined beyond the range [0, 1].
//    ///
//    /// @tparam T A floating-point scalar type
//    /// @tparam Q A value from qualifier enum
//    template<typename T, qualifier Q>
//    GLM_FUNC_DECL qua<T, Q> slerp(qua<T, Q> const& x, qua<T, Q> const& y, T a);
//
//    /// Spherical linear interpolation of two quaternions with multiple spins over rotation axis.
//    /// The interpolation always take the short path when the spin count is positive and long path
//    /// when count is negative. Rotation is performed at constant speed.
//    ///
//    /// @param x A quaternion
//    /// @param y A quaternion
//    /// @param a Interpolation factor. The interpolation is defined beyond the range [0, 1].
//    /// @param k Additional spin count. If Value is negative interpolation will be on "long" path.
//    ///
//    /// @tparam T A floating-point scalar type
//    /// @tparam S An integer scalar type
//    /// @tparam Q A value from qualifier enum
//    template<typename T, typename S, qualifier Q>
//    GLM_FUNC_DECL qua<T, Q> slerp(qua<T, Q> const& x, qua<T, Q> const& y, T a, S k);
//
//    /// Returns the q conjugate.
//    ///
//    /// @tparam T A floating-point scalar type
//    /// @tparam Q A value from qualifier enum
//    template<typename T, qualifier Q>
//    GLM_FUNC_DECL qua<T, Q> conjugate(qua<T, Q> const& q);
//
//    /// Returns the q inverse.
//    ///
//    /// @tparam T A floating-point scalar type
//    /// @tparam Q A value from qualifier enum
//    template<typename T, qualifier Q>
//    GLM_FUNC_DECL qua<T, Q> inverse(qua<T, Q> const& q);
//
//    /// Returns true if x holds a NaN (not a number)
//    /// representation in the underlying implementation's set of
//    /// floating point representations. Returns false otherwise,
//    /// including for implementations with no NaN
//    /// representations.
//    ///
//    /// /!\ When using compiler fast math, this function may fail.
//    ///
//    /// @tparam T A floating-point scalar type
//    /// @tparam Q A value from qualifier enum
//    template<typename T, qualifier Q>
//    GLM_FUNC_DECL vec<4, bool, Q> isnan(qua<T, Q> const& x);
//
//    /// Returns true if x holds a positive infinity or negative
//    /// infinity representation in the underlying implementation's
//    /// set of floating point representations. Returns false
//    /// otherwise, including for implementations with no infinity
//    /// representations.
//    ///
//    /// @tparam T A floating-point scalar type
//    /// @tparam Q A value from qualifier enum
//    template<typename T, qualifier Q>
//    GLM_FUNC_DECL vec<4, bool, Q> isinf(qua<T, Q> const& x);
}