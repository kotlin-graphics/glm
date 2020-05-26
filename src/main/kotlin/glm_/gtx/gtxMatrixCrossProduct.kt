package glm_.gtx

import glm_.mat3x3.Mat3
import glm_.mat4x4.Mat4
import glm_.vec3.Vec3

interface gtxMatrixCrossProduct {

    /** Build a cross product matrix.
     *  From GLM_GTX_matrix_cross_product extension. */
    fun matrixCross3(res: Mat3, x: Vec3): Mat3 {
        res[0, 1] = x.z
        res[1, 0] = -x.z
        res[0, 2] = -x.y
        res[2, 0] = x.y
        res[1, 2] = x.x
        res[2, 1] = -x.x
        res[0, 0] = 0f
        res[1, 1] = 0f
        res[2, 2] = 0f
        return res
    }

    /** Build a cross product matrix.
     *  From GLM_GTX_matrix_cross_product extension. */
    infix fun matrixCross3(x: Vec3): Mat3 = matrixCross3(Mat3(), x)

    /** Build a cross product matrix.
     *  From GLM_GTX_matrix_cross_product extension. */
    fun matrixCross4(res: Mat4, x: Vec3): Mat4 {
        res[0, 1] = x.z
        res[1, 0] = -x.z
        res[0, 2] = -x.y
        res[2, 0] = x.y
        res[1, 2] = x.x
        res[2, 1] = -x.x
        res[0, 0] = 0f
        res[0, 3] = 0f
        res[1, 1] = 0f
        res[1, 3] = 0f
        res[2, 2] = 0f
        res[2, 3] = 0f
        res[3, 0] = 0f
        res[3, 1] = 0f
        res[3, 2] = 0f
        res[3, 3] = 0f
        return res
    }

    /** Build a cross product matrix.
     *  From GLM_GTX_matrix_cross_product extension. */
    infix fun matrixCross4(x: Vec3): Mat4 = matrixCross4(Mat4(), x)
}