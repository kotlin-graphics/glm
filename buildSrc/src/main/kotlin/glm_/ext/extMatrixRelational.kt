package glm_.ext

import glm_.XyzwJoint
import glm_.floatingPointTypes
import glm_.gen.Generator
import glm_.xyzwJoint

fun Generator.extMatrixRelational(width: Int, height: Int, type: String, extension: String, id: String, part: Generator.Part) {

    val MatID = "Mat$matrixSize$id"

//    imports += listOf("glm_.scalar.sin",
//                      "glm_.scalar.cos",
//                      "glm_.detail.GlmCoordinateSystem",
//                      "glm_.detail.GLM_COORDINATE_SYSTEM")
//    val `0` = type.`0`
//    val `1` = type.`1`

    val abcdN = abcdJoint { "$it" }
    val `resXYZW type` = XyzwJoint(4) { "res$it: $type" }
    val resXYZW = XyzwJoint(4) { "res$it" }
    val `abc4 type` = abcdJoint(3, 4, ",\n") { "$it: $type" }
    val `abcd type` = abcdJoint(4, 4, ",\n") { "$it: $type" }
    val `v,xyz` = xyzwJoint(3) { "v.$it" }
    val `axis,xyz` = xyzwJoint(3) { "axis.$it" }
    val `axisXYZ` = XyzwJoint(3) { "axis$it" }
    val `axisXYZ type` = XyzwJoint(3) { "axis$it: $type" }
    val `vXYZ type` = XyzwJoint(3) { "v$it: $type" }
    val vXYZ = XyzwJoint(3) { "v$it" }
    val `xyz type` = xyzwJoint(3) { "$it: $type" }
    val `xyzw Boolean` = xyzwJoint(width) { "$it: Boolean" }
    val xyz = xyzwJoint(3) { "$it" }
    val scalarJoint = xyzwJoint(3) { "scalar" }
    val `eyeXYZ type` = XyzwJoint(3) { "eye$it: $type" }
    val eyeXYZ = XyzwJoint(3) { "eye$it" }
    val `eye,xyz` = xyzwJoint(3) { "eye.$it" }
    val `centerXYZ type` = XyzwJoint(3) { "center$it: $type" }
    val centerXYZ = XyzwJoint(3) { "center$it" }
    val `center,xyz` = xyzwJoint(3) { "center.$it" }
    val `upXYZ type` = XyzwJoint(3) { "up$it: $type" }
    val upXYZ = XyzwJoint(3) { "up$it" }
    val `up,xyz` = xyzwJoint(3) { "up.$it" }
    val a0123 = xyzwJointIndexed(4) { i, _ -> "a$i" }
    val b0123 = xyzwJointIndexed(4) { i, _ -> "b$i" }
    val c0123 = xyzwJointIndexed(4) { i, _ -> "c$i" }
    val d0123 = xyzwJointIndexed(4) { i, _ -> "d$i" }

    if (type !in floatingPointTypes)
        return

    val VecCid = "Vec$height$id"

    fun equal() = docs("""
        |Perform a component-wise equal-to comparison of two matrices.
        |Return a boolean vector which components value is True if this expression is satisfied per column of the matrices.""")
    when(part) {
        Generator.Part.Class -> {}
        Generator.Part.CompanionObject -> {
//            +"""
//                inline fun <R> equal (m: $MatID, n: $MatID, res: ($`xyzw Boolean`) -> R): R {
//                    $contract
//                    return res($
//                }"""
        }
    }
//    /// Perform a component-wise not-equal-to comparison of two matrices.
//    /// Return a boolean vector which components value is True if this expression is satisfied per column of the matrices.
//    ///
//    /// @tparam C Integer between 1 and 4 included that qualify the number of columns of the matrix
//    /// @tparam R Integer between 1 and 4 included that qualify the number of rows of the matrix
//    /// @tparam T Floating-point or integer scalar types
//    /// @tparam Q Value from qualifier enum
//    template<length_t C, length_t R, typename T, qualifier Q>
//    GLM_FUNC_DECL GLM_CONSTEXPR vec<C, bool, Q> notEqual(mat<C, R, T, Q> const& x, mat<C, R, T, Q> const& y);
//
//    /// Returns the component-wise comparison of |x - y| < epsilon.
//    /// True if this expression is satisfied.
//    ///
//    /// @tparam C Integer between 1 and 4 included that qualify the number of columns of the matrix
//    /// @tparam R Integer between 1 and 4 included that qualify the number of rows of the matrix
//    /// @tparam T Floating-point or integer scalar types
//    /// @tparam Q Value from qualifier enum
//    template<length_t C, length_t R, typename T, qualifier Q>
//    GLM_FUNC_DECL GLM_CONSTEXPR vec<C, bool, Q> equal(mat<C, R, T, Q> const& x, mat<C, R, T, Q> const& y, T epsilon);
//
//    /// Returns the component-wise comparison of |x - y| < epsilon.
//    /// True if this expression is satisfied.
//    ///
//    /// @tparam C Integer between 1 and 4 included that qualify the number of columns of the matrix
//    /// @tparam R Integer between 1 and 4 included that qualify the number of rows of the matrix
//    /// @tparam T Floating-point or integer scalar types
//    /// @tparam Q Value from qualifier enum
//    template<length_t C, length_t R, typename T, qualifier Q>
//    GLM_FUNC_DECL GLM_CONSTEXPR vec<C, bool, Q> equal(mat<C, R, T, Q> const& x, mat<C, R, T, Q> const& y, vec<C, T, Q> const& epsilon);
//
//    /// Returns the component-wise comparison of |x - y| < epsilon.
//    /// True if this expression is not satisfied.
//    ///
//    /// @tparam C Integer between 1 and 4 included that qualify the number of columns of the matrix
//    /// @tparam R Integer between 1 and 4 included that qualify the number of rows of the matrix
//    /// @tparam T Floating-point or integer scalar types
//    /// @tparam Q Value from qualifier enum
//    template<length_t C, length_t R, typename T, qualifier Q>
//    GLM_FUNC_DECL GLM_CONSTEXPR vec<C, bool, Q> notEqual(mat<C, R, T, Q> const& x, mat<C, R, T, Q> const& y, T epsilon);
//
//    /// Returns the component-wise comparison of |x - y| >= epsilon.
//    /// True if this expression is not satisfied.
//    ///
//    /// @tparam C Integer between 1 and 4 included that qualify the number of columns of the matrix
//    /// @tparam R Integer between 1 and 4 included that qualify the number of rows of the matrix
//    /// @tparam T Floating-point or integer scalar types
//    /// @tparam Q Value from qualifier enum
//    template<length_t C, length_t R, typename T, qualifier Q>
//    GLM_FUNC_DECL GLM_CONSTEXPR vec<C, bool, Q> notEqual(mat<C, R, T, Q> const& x, mat<C, R, T, Q> const& y, vec<C, T, Q> const& epsilon);
//
//    /// Returns the component-wise comparison between two vectors in term of ULPs.
//    /// True if this expression is satisfied.
//    ///
//    /// @tparam C Integer between 1 and 4 included that qualify the number of columns of the matrix
//    /// @tparam R Integer between 1 and 4 included that qualify the number of rows of the matrix
//    /// @tparam T Floating-point
//    /// @tparam Q Value from qualifier enum
//    template<length_t C, length_t R, typename T, qualifier Q>
//    GLM_FUNC_DECL GLM_CONSTEXPR vec<C, bool, Q> equal(mat<C, R, T, Q> const& x, mat<C, R, T, Q> const& y, int ULPs);
//
//    /// Returns the component-wise comparison between two vectors in term of ULPs.
//    /// True if this expression is satisfied.
//    ///
//    /// @tparam C Integer between 1 and 4 included that qualify the number of columns of the matrix
//    /// @tparam R Integer between 1 and 4 included that qualify the number of rows of the matrix
//    /// @tparam T Floating-point
//    /// @tparam Q Value from qualifier enum
//    template<length_t C, length_t R, typename T, qualifier Q>
//    GLM_FUNC_DECL GLM_CONSTEXPR vec<C, bool, Q> equal(mat<C, R, T, Q> const& x, mat<C, R, T, Q> const& y, vec<C, int, Q> const& ULPs);
//
//    /// Returns the component-wise comparison between two vectors in term of ULPs.
//    /// True if this expression is not satisfied.
//    ///
//    /// @tparam C Integer between 1 and 4 included that qualify the number of columns of the matrix
//    /// @tparam R Integer between 1 and 4 included that qualify the number of rows of the matrix
//    /// @tparam T Floating-point
//    /// @tparam Q Value from qualifier enum
//    template<length_t C, length_t R, typename T, qualifier Q>
//    GLM_FUNC_DECL GLM_CONSTEXPR vec<C, bool, Q> notEqual(mat<C, R, T, Q> const& x, mat<C, R, T, Q> const& y, int ULPs);
//
//    /// Returns the component-wise comparison between two vectors in term of ULPs.
//    /// True if this expression is not satisfied.
//    ///
//    /// @tparam C Integer between 1 and 4 included that qualify the number of columns of the matrix
//    /// @tparam R Integer between 1 and 4 included that qualify the number of rows of the matrix
//    /// @tparam T Floating-point
//    /// @tparam Q Value from qualifier enum
//    template<length_t C, length_t R, typename T, qualifier Q>
//    GLM_FUNC_DECL GLM_CONSTEXPR vec<C, bool, Q> notEqual(mat<C, R, T, Q> const& x, mat<C, R, T, Q> const& y, vec<C, int, Q> const& ULPs);
}