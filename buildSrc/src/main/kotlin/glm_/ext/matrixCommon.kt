package glm_.ext

import glm_.gen.Generator

fun Generator.matrixCommon(width: Int, height: Int, type: String, extension: String, id: String, part: Generator.Part) {

    when(part) {
        Generator.Part.Class -> {}
        Generator.Part.CompanionObject -> {
//            template<length_t C, length_t R, typename T, typename U, qualifier Q>
//            GLM_FUNC_DECL mat<C, R, T, Q> mix(mat<C, R, T, Q> const& x, mat<C, R, T, Q> const& y, mat<C, R, U, Q> const& a);
//
//            template<length_t C, length_t R, typename T, typename U, qualifier Q>
//            GLM_FUNC_DECL mat<C, R, T, Q> mix(mat<C, R, T, Q> const& x, mat<C, R, T, Q> const& y, U a);
        }
        else -> Unit
    }
}