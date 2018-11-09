package glm_.gtc.matrixTransform

import glm_.detail.GLM_COORDINATE_SYSTEM
import glm_.detail.GLM_DEPTH_CLIP_SPACE
import glm_.detail.GlmCoordinateSystem
import glm_.detail.GlmDepthClipSpace
import glm_.mat4x4.Mat4
import glm_.mat4x4.Mat4d


interface gtcMatrixFrustum {

    /** Creates a left handed frustum matrix.
     *  The near and far clip planes correspond to z normalized device coordinates of 0 and +1 respectively. (Direct3D clip volume definition)
     *
     *  @see gtc_matrix_transform
     */
    fun frustumLhZo(res: Mat4, left: Float, right: Float, bottom: Float, top: Float, near: Float, far: Float): Mat4 {
        res put 0f
        res[0, 0] = (2f * near) / (right - left)
        res[1, 1] = (2f * near) / (top - bottom)
        res[2, 0] = (right + left) / (right - left)
        res[2, 1] = (top + bottom) / (top - bottom)
        res[2, 2] = far / (far - near)
        res[2, 3] = 1f
        res[3, 2] = -(far * near) / (far - near)
        return res
    }

    /** Creates a left handed frustum matrix.
     *  The near and far clip planes correspond to z normalized device coordinates of 0 and +1 respectively. (Direct3D clip volume definition)
     *
     *  @see gtc_matrix_transform
     */
    fun frustumLhZo(left: Float, right: Float, bottom: Float, top: Float, near: Float, far: Float): Mat4 = frustumLhZo(Mat4(), left, right, bottom, top, near, far)

    /** Creates a left handed frustum matrix.
     *  The near and far clip planes correspond to z normalized device coordinates of -1 and +1 respectively. (OpenGL clip volume definition)
     *
     *  @see gtc_matrix_transform
     */
    fun frustumLhNo(res: Mat4, left: Float, right: Float, bottom: Float, top: Float, near: Float, far: Float): Mat4 {
        res put 0f
        res[0, 0] = (2f * near) / (right - left)
        res[1, 1] = (2f * near) / (top - bottom)
        res[2, 0] = (right + left) / (right - left)
        res[2, 1] = (top + bottom) / (top - bottom)
        res[2, 2] = (far + near) / (far - near)
        res[2, 3] = 1f
        res[3, 2] = -(2f * far * near) / (far - near)
        return res
    }

    /** Creates a left handed frustum matrix.
     *  The near and far clip planes correspond to z normalized device coordinates of -1 and +1 respectively. (OpenGL clip volume definition)
     *
     *  @see gtc_matrix_transform
     */
    fun frustumLhNo(left: Float, right: Float, bottom: Float, top: Float, near: Float, far: Float): Mat4 = frustumLhNo(Mat4(), left, right, bottom, top, near, far)

    /** Creates a right handed frustum matrix.
     *  The near and far clip planes correspond to z normalized device coordinates of 0 and +1 respectively. (Direct3D clip volume definition)
     *
     *  @see gtc_matrix_transform
     */
    fun frustumRhZo(res: Mat4, left: Float, right: Float, bottom: Float, top: Float, near: Float, far: Float): Mat4 {
        res put 0f
        res[0, 0] = (2f * near) / (right - left)
        res[1, 1] = (2f * near) / (top - bottom)
        res[2, 0] = (right + left) / (right - left)
        res[2, 1] = (top + bottom) / (top - bottom)
        res[2, 2] = far / (near - far)
        res[2, 3] = -1f
        res[3, 2] = -(far * near) / (far - near)
        return res
    }

    /** Creates a right handed frustum matrix.
     *  The near and far clip planes correspond to z normalized device coordinates of 0 and +1 respectively. (Direct3D clip volume definition)
     *
     *  @see gtc_matrix_transform
     */
    fun frustumRhZo(left: Float, right: Float, bottom: Float, top: Float, near: Float, far: Float): Mat4 = frustumRhZo(Mat4(), left, right, bottom, top, near, far)

    /** Creates a right handed frustum matrix.
     *  The near and far clip planes correspond to z normalized device coordinates of -1 and +1 respectively. (OpenGL clip volume definition)
     *
     *  @see gtc_matrix_transform
     */
    fun frustumRhNo(res: Mat4, left: Float, right: Float, bottom: Float, top: Float, near: Float, far: Float): Mat4 {
        res put 0f
        res[0, 0] = (2f * near) / (right - left)
        res[1, 1] = (2f * near) / (top - bottom)
        res[2, 0] = (right + left) / (right - left)
        res[2, 1] = (top + bottom) / (top - bottom)
        res[2, 2] = -(far + near) / (far - near)
        res[2, 3] = -1f
        res[3, 2] = -(2f * far * near) / (far - near)
        return res
    }

    /** Creates a right handed frustum matrix.
     *  The near and far clip planes correspond to z normalized device coordinates of -1 and +1 respectively. (OpenGL clip volume definition)
     *
     *  @see gtc_matrix_transform
     */
    fun frustumRhNo(left: Float, right: Float, bottom: Float, top: Float, near: Float, far: Float): Mat4 = frustumRhNo(Mat4(), left, right, bottom, top, near, far)

    /** Creates a frustum matrix using left-handed coordinates if GLM_COORDINATE_SYSTEM is LEFT_HANDED or right-handed coordinates otherwise.
     *  The near and far clip planes correspond to z normalized device coordinates of 0 and +1 respectively. (Direct3D clip volume definition)
     *
     *  @see gtc_matrix_transform
     */
    fun frustumZo(res: Mat4, left: Float, right: Float, bottom: Float, top: Float, near: Float, far: Float): Mat4 = when (GLM_COORDINATE_SYSTEM) {
        GlmCoordinateSystem.LEFT_HANDED -> frustumLhZo(res, left, right, bottom, top, near, far)
        else -> frustumRhZo(res, left, right, bottom, top, near, far)
    }

    /** Creates a frustum matrix using left-handed coordinates if GLM_COORDINATE_SYSTEM is LEFT_HANDED or right-handed coordinates otherwise.
     *  The near and far clip planes correspond to z normalized device coordinates of 0 and +1 respectively. (Direct3D clip volume definition)
     *
     *  @see gtc_matrix_transform
     */
    fun frustumZo(left: Float, right: Float, bottom: Float, top: Float, near: Float, far: Float): Mat4 = when (GLM_COORDINATE_SYSTEM) {
        GlmCoordinateSystem.LEFT_HANDED -> frustumLhZo(Mat4(), left, right, bottom, top, near, far)
        else -> frustumRhZo(Mat4(), left, right, bottom, top, near, far)
    }

    /** Creates a frustum matrix using left-handed coordinates if GLM_COORDINATE_SYSTEM is LEFT_HANDED or right-handed coordinates otherwise.
     *  The near and far clip planes correspond to z normalized device coordinates of -1 and +1 respectively. (OpenGL clip volume definition)
     *
     *  @see gtc_matrix_transform
     */
    fun frustumNo(res: Mat4, left: Float, right: Float, bottom: Float, top: Float, near: Float, far: Float): Mat4 = when (GLM_COORDINATE_SYSTEM) {
        GlmCoordinateSystem.LEFT_HANDED -> frustumLhNo(res, left, right, bottom, top, near, far)
        else -> frustumRhNo(res, left, right, bottom, top, near, far)
    }

    /** Creates a frustum matrix using left-handed coordinates if GLM_COORDINATE_SYSTEM is LEFT_HANDED or right-handed coordinates otherwise.
     *  The near and far clip planes correspond to z normalized device coordinates of -1 and +1 respectively. (OpenGL clip volume definition)
     *
     *  @see gtc_matrix_transform
     */
    fun frustumNo(left: Float, right: Float, bottom: Float, top: Float, near: Float, far: Float): Mat4 = when (GLM_COORDINATE_SYSTEM) {
        GlmCoordinateSystem.LEFT_HANDED -> frustumLhNo(Mat4(), left, right, bottom, top, near, far)
        else -> frustumRhNo(Mat4(), left, right, bottom, top, near, far)
    }

    /** Creates a left handed frustum matrix.
     *  If GLM_DEPTH_CLIP_SPACE is ZERO_TO_ONE, the near and far clip planes correspond to z normalized device coordinates of 0 and +1 respectively. (Direct3D clip volume definition)
     *  Otherwise, the near and far clip planes correspond to z normalized device coordinates of -1 and +1 respectively. (OpenGL clip volume definition)
     *
     *  @see gtc_matrix_transform
     */
    fun frustumLh(res: Mat4, left: Float, right: Float, bottom: Float, top: Float, near: Float, far: Float): Mat4 = when (GLM_DEPTH_CLIP_SPACE) {
        GlmDepthClipSpace.ZERO_TO_ONE -> frustumLhZo(res, left, right, bottom, top, near, far)
        else -> frustumLhNo(res, left, right, bottom, top, near, far)
    }

    /** Creates a left handed frustum matrix.
     *  If GLM_DEPTH_CLIP_SPACE is ZERO_TO_ONE, the near and far clip planes correspond to z normalized device coordinates of 0 and +1 respectively. (Direct3D clip volume definition)
     *  Otherwise, the near and far clip planes correspond to z normalized device coordinates of -1 and +1 respectively. (OpenGL clip volume definition)
     *
     *  @see gtc_matrix_transform
     */
    fun frustumLh(left: Float, right: Float, bottom: Float, top: Float, near: Float, far: Float): Mat4 = when (GLM_DEPTH_CLIP_SPACE) {
        GlmDepthClipSpace.ZERO_TO_ONE -> frustumLhZo(Mat4(), left, right, bottom, top, near, far)
        else -> frustumLhNo(Mat4(), left, right, bottom, top, near, far)
    }

    /** Creates a right handed frustum matrix.
     *  GLM_DEPTH_CLIP_SPACE is ZERO_TO_ONE, the near and far clip planes correspond to z normalized device coordinates of 0 and +1 respectively. (Direct3D clip volume definition)
     *  Otherwise, the near and far clip planes correspond to z normalized device coordinates of -1 and +1 respectively. (OpenGL clip volume definition)
     *
     *  @see gtc_matrix_transform
     */
    fun frustumRh(res: Mat4, left: Float, right: Float, bottom: Float, top: Float, near: Float, far: Float): Mat4 = when (GLM_DEPTH_CLIP_SPACE) {
        GlmDepthClipSpace.ZERO_TO_ONE -> frustumRhZo(res, left, right, bottom, top, near, far)
        else -> frustumRhNo(res, left, right, bottom, top, near, far)
    }

    /** Creates a right handed frustum matrix.
     *  GLM_DEPTH_CLIP_SPACE is ZERO_TO_ONE, the near and far clip planes correspond to z normalized device coordinates of 0 and +1 respectively. (Direct3D clip volume definition)
     *  Otherwise, the near and far clip planes correspond to z normalized device coordinates of -1 and +1 respectively. (OpenGL clip volume definition)
     *
     *  @see gtc_matrix_transform
     */
    fun frustumRh(left: Float, right: Float, bottom: Float, top: Float, near: Float, far: Float): Mat4 = when (GLM_DEPTH_CLIP_SPACE) {
        GlmDepthClipSpace.ZERO_TO_ONE -> frustumRhZo(Mat4(), left, right, bottom, top, near, far)
        else -> frustumRhNo(Mat4(), left, right, bottom, top, near, far)
    }

    /** Creates a frustum matrix with default handedness, using the default handedness and default near and far clip planes definition.
     *  To change default handedness use LEFT_HANDED. To change default near and far clip planes definition use ZERO_TO_ONE.
     *
     *  @see gtc_matrix_transform
     *  @see <a href="https://www.khronos.org/registry/OpenGL-Refpages/gl2.1/xhtml/glFrustum.xml">glFrustum man page</a>
     */
    fun frustum(res: Mat4, left: Float, right: Float, bottom: Float, top: Float, near: Float, far: Float): Mat4 = when (GLM_COORDINATE_SYSTEM) {
        GlmCoordinateSystem.LEFT_HANDED -> when (GLM_DEPTH_CLIP_SPACE) {
            GlmDepthClipSpace.ZERO_TO_ONE -> frustumLhZo(res, left, right, bottom, top, near, far)
            else -> frustumLhNo(res, left, right, bottom, top, near, far)
        }
        else -> when (GLM_DEPTH_CLIP_SPACE) {
            GlmDepthClipSpace.ZERO_TO_ONE -> frustumRhZo(res, left, right, bottom, top, near, far)
            else -> frustumRhNo(res, left, right, bottom, top, near, far)
        }
    }

    /** Creates a frustum matrix with default handedness, using the default handedness and default near and far clip planes definition.
     *  To change default handedness use LEFT_HANDED. To change default near and far clip planes definition use ZERO_TO_ONE.
     *
     *  @see gtc_matrix_transform
     *  @see <a href="https://www.khronos.org/registry/OpenGL-Refpages/gl2.1/xhtml/glFrustum.xml">glFrustum man page</a>
     */
    fun frustum(left: Float, right: Float, bottom: Float, top: Float, near: Float, far: Float): Mat4 = when (GLM_COORDINATE_SYSTEM) {
        GlmCoordinateSystem.LEFT_HANDED -> when (GLM_DEPTH_CLIP_SPACE) {
            GlmDepthClipSpace.ZERO_TO_ONE -> frustumLhZo(Mat4(), left, right, bottom, top, near, far)
            else -> frustumLhNo(Mat4(), left, right, bottom, top, near, far)
        }
        else -> when (GLM_DEPTH_CLIP_SPACE) {
            GlmDepthClipSpace.ZERO_TO_ONE -> frustumRhZo(Mat4(), left, right, bottom, top, near, far)
            else -> frustumRhNo(Mat4(), left, right, bottom, top, near, far)
        }
    }


    // -----------------------------------------------------------------------------------------------------------------
    // Mat4d version
    // -----------------------------------------------------------------------------------------------------------------


    /** Creates a left handed frustum matrix.
     *  The near and far clip planes correspond to z normalized device coordinates of 0 and +1 respectively. (Direct3D clip volume definition)
     *
     *  @see gtc_matrix_transform
     */
    fun frustumLhZo(res: Mat4d, left: Double, right: Double, bottom: Double, top: Double, near: Double, far: Double): Mat4d {
        res put 0.0
        res[0, 0] = (2.0 * near) / (right - left)
        res[1, 1] = (2.0 * near) / (top - bottom)
        res[2, 0] = (right + left) / (right - left)
        res[2, 1] = (top + bottom) / (top - bottom)
        res[2, 2] = far / (far - near)
        res[2, 3] = 1.0
        res[3, 2] = -(far * near) / (far - near)
        return res
    }

    /** Creates a left handed frustum matrix.
     *  The near and far clip planes correspond to z normalized device coordinates of 0 and +1 respectively. (Direct3D clip volume definition)
     *
     *  @see gtc_matrix_transform
     */
    fun frustumLhZo(left: Double, right: Double, bottom: Double, top: Double, near: Double, far: Double): Mat4d = frustumLhZo(Mat4d(), left, right, bottom, top, near, far)

    /** Creates a left handed frustum matrix.
     *  The near and far clip planes correspond to z normalized device coordinates of -1 and +1 respectively. (OpenGL clip volume definition)
     *
     *  @see gtc_matrix_transform
     */
    fun frustumLhNo(res: Mat4d, left: Double, right: Double, bottom: Double, top: Double, near: Double, far: Double): Mat4d {
        res put 0.0
        res[0, 0] = (2.0 * near) / (right - left)
        res[1, 1] = (2.0 * near) / (top - bottom)
        res[2, 0] = (right + left) / (right - left)
        res[2, 1] = (top + bottom) / (top - bottom)
        res[2, 2] = (far + near) / (far - near)
        res[2, 3] = 1.0
        res[3, 2] = -(2.0 * far * near) / (far - near)
        return res
    }

    /** Creates a left handed frustum matrix.
     *  The near and far clip planes correspond to z normalized device coordinates of -1 and +1 respectively. (OpenGL clip volume definition)
     *
     *  @see gtc_matrix_transform
     */
    fun frustumLhNo(left: Double, right: Double, bottom: Double, top: Double, near: Double, far: Double): Mat4d = frustumLhNo(Mat4d(), left, right, bottom, top, near, far)

    /** Creates a right handed frustum matrix.
     *  The near and far clip planes correspond to z normalized device coordinates of 0 and +1 respectively. (Direct3D clip volume definition)
     *
     *  @see gtc_matrix_transform
     */
    fun frustumRhZo(res: Mat4d, left: Double, right: Double, bottom: Double, top: Double, near: Double, far: Double): Mat4d {
        res put 0.0
        res[0, 0] = (2.0 * near) / (right - left)
        res[1, 1] = (2.0 * near) / (top - bottom)
        res[2, 0] = (right + left) / (right - left)
        res[2, 1] = (top + bottom) / (top - bottom)
        res[2, 2] = far / (near - far)
        res[2, 3] = -1.0
        res[3, 2] = -(far * near) / (far - near)
        return res
    }

    /** Creates a right handed frustum matrix.
     *  The near and far clip planes correspond to z normalized device coordinates of 0 and +1 respectively. (Direct3D clip volume definition)
     *
     *  @see gtc_matrix_transform
     */
    fun frustumRhZo(left: Double, right: Double, bottom: Double, top: Double, near: Double, far: Double): Mat4d = frustumRhZo(Mat4d(), left, right, bottom, top, near, far)

    /** Creates a right handed frustum matrix.
     *  The near and far clip planes correspond to z normalized device coordinates of -1 and +1 respectively. (OpenGL clip volume definition)
     *
     *  @see gtc_matrix_transform
     */
    fun frustumRhNo(res: Mat4d, left: Double, right: Double, bottom: Double, top: Double, near: Double, far: Double): Mat4d {
        res put 0.0
        res[0, 0] = (2.0 * near) / (right - left)
        res[1, 1] = (2.0 * near) / (top - bottom)
        res[2, 0] = (right + left) / (right - left)
        res[2, 1] = (top + bottom) / (top - bottom)
        res[2, 2] = -(far + near) / (far - near)
        res[2, 3] = -1.0
        res[3, 2] = -(2.0 * far * near) / (far - near)
        return res
    }

    /** Creates a right handed frustum matrix.
     *  The near and far clip planes correspond to z normalized device coordinates of -1 and +1 respectively. (OpenGL clip volume definition)
     *
     *  @see gtc_matrix_transform
     */
    fun frustumRhNo(left: Double, right: Double, bottom: Double, top: Double, near: Double, far: Double): Mat4d = frustumRhNo(Mat4d(), left, right, bottom, top, near, far)

    /** Creates a frustum matrix using left-handed coordinates if GLM_COORDINATE_SYSTEM is LEFT_HANDED or right-handed coordinates otherwise.
     *  The near and far clip planes correspond to z normalized device coordinates of 0 and +1 respectively. (Direct3D clip volume definition)
     *
     *  @see gtc_matrix_transform
     */
    fun frustumZo(res: Mat4d, left: Double, right: Double, bottom: Double, top: Double, near: Double, far: Double): Mat4d = when (GLM_COORDINATE_SYSTEM) {
        GlmCoordinateSystem.LEFT_HANDED -> frustumLhZo(res, left, right, bottom, top, near, far)
        else -> frustumRhZo(res, left, right, bottom, top, near, far)
    }

    /** Creates a frustum matrix using left-handed coordinates if GLM_COORDINATE_SYSTEM is LEFT_HANDED or right-handed coordinates otherwise.
     *  The near and far clip planes correspond to z normalized device coordinates of 0 and +1 respectively. (Direct3D clip volume definition)
     *
     *  @see gtc_matrix_transform
     */
    fun frustumZo(left: Double, right: Double, bottom: Double, top: Double, near: Double, far: Double): Mat4d = when (GLM_COORDINATE_SYSTEM) {
        GlmCoordinateSystem.LEFT_HANDED -> frustumLhZo(Mat4d(), left, right, bottom, top, near, far)
        else -> frustumRhZo(Mat4d(), left, right, bottom, top, near, far)
    }

    /** Creates a frustum matrix using left-handed coordinates if GLM_COORDINATE_SYSTEM is LEFT_HANDED or right-handed coordinates otherwise.
     *  The near and far clip planes correspond to z normalized device coordinates of -1 and +1 respectively. (OpenGL clip volume definition)
     *
     *  @see gtc_matrix_transform
     */
    fun frustumNo(res: Mat4d, left: Double, right: Double, bottom: Double, top: Double, near: Double, far: Double): Mat4d = when (GLM_COORDINATE_SYSTEM) {
        GlmCoordinateSystem.LEFT_HANDED -> frustumLhNo(res, left, right, bottom, top, near, far)
        else -> frustumRhNo(res, left, right, bottom, top, near, far)
    }

    /** Creates a frustum matrix using left-handed coordinates if GLM_COORDINATE_SYSTEM is LEFT_HANDED or right-handed coordinates otherwise.
     *  The near and far clip planes correspond to z normalized device coordinates of -1 and +1 respectively. (OpenGL clip volume definition)
     *
     *  @see gtc_matrix_transform
     */
    fun frustumNo(left: Double, right: Double, bottom: Double, top: Double, near: Double, far: Double): Mat4d = when (GLM_COORDINATE_SYSTEM) {
        GlmCoordinateSystem.LEFT_HANDED -> frustumLhNo(Mat4d(), left, right, bottom, top, near, far)
        else -> frustumRhNo(Mat4d(), left, right, bottom, top, near, far)
    }

    /** Creates a left handed frustum matrix.
     *  If GLM_DEPTH_CLIP_SPACE is ZERO_TO_ONE, the near and far clip planes correspond to z normalized device coordinates of 0 and +1 respectively. (Direct3D clip volume definition)
     *  Otherwise, the near and far clip planes correspond to z normalized device coordinates of -1 and +1 respectively. (OpenGL clip volume definition)
     *
     *  @see gtc_matrix_transform
     */
    fun frustumLh(res: Mat4d, left: Double, right: Double, bottom: Double, top: Double, near: Double, far: Double): Mat4d = when (GLM_DEPTH_CLIP_SPACE) {
        GlmDepthClipSpace.ZERO_TO_ONE -> frustumLhZo(res, left, right, bottom, top, near, far)
        else -> frustumLhNo(res, left, right, bottom, top, near, far)
    }

    /** Creates a left handed frustum matrix.
     *  If GLM_DEPTH_CLIP_SPACE is ZERO_TO_ONE, the near and far clip planes correspond to z normalized device coordinates of 0 and +1 respectively. (Direct3D clip volume definition)
     *  Otherwise, the near and far clip planes correspond to z normalized device coordinates of -1 and +1 respectively. (OpenGL clip volume definition)
     *
     *  @see gtc_matrix_transform
     */
    fun frustumLh(left: Double, right: Double, bottom: Double, top: Double, near: Double, far: Double): Mat4d = when (GLM_DEPTH_CLIP_SPACE) {
        GlmDepthClipSpace.ZERO_TO_ONE -> frustumLhZo(Mat4d(), left, right, bottom, top, near, far)
        else -> frustumLhNo(Mat4d(), left, right, bottom, top, near, far)
    }

    /** Creates a right handed frustum matrix.
     *  GLM_DEPTH_CLIP_SPACE is ZERO_TO_ONE, the near and far clip planes correspond to z normalized device coordinates of 0 and +1 respectively. (Direct3D clip volume definition)
     *  Otherwise, the near and far clip planes correspond to z normalized device coordinates of -1 and +1 respectively. (OpenGL clip volume definition)
     *
     *  @see gtc_matrix_transform
     */
    fun frustumRh(res: Mat4d, left: Double, right: Double, bottom: Double, top: Double, near: Double, far: Double): Mat4d = when (GLM_DEPTH_CLIP_SPACE) {
        GlmDepthClipSpace.ZERO_TO_ONE -> frustumRhZo(res, left, right, bottom, top, near, far)
        else -> frustumRhNo(res, left, right, bottom, top, near, far)
    }

    /** Creates a right handed frustum matrix.
     *  GLM_DEPTH_CLIP_SPACE is ZERO_TO_ONE, the near and far clip planes correspond to z normalized device coordinates of 0 and +1 respectively. (Direct3D clip volume definition)
     *  Otherwise, the near and far clip planes correspond to z normalized device coordinates of -1 and +1 respectively. (OpenGL clip volume definition)
     *
     *  @see gtc_matrix_transform
     */
    fun frustumRh(left: Double, right: Double, bottom: Double, top: Double, near: Double, far: Double): Mat4d = when (GLM_DEPTH_CLIP_SPACE) {
        GlmDepthClipSpace.ZERO_TO_ONE -> frustumRhZo(Mat4d(), left, right, bottom, top, near, far)
        else -> frustumRhNo(Mat4d(), left, right, bottom, top, near, far)
    }

    /** Creates a frustum matrix with default handedness, using the default handedness and default near and far clip planes definition.
     *  To change default handedness use LEFT_HANDED. To change default near and far clip planes definition use ZERO_TO_ONE.
     *
     *  @see gtc_matrix_transform
     *  @see <a href="https://www.khronos.org/registry/OpenGL-Refpages/gl2.1/xhtml/glFrustum.xml">glFrustum man page</a>
     */
    fun frustum(res: Mat4d, left: Double, right: Double, bottom: Double, top: Double, near: Double, far: Double): Mat4d = when (GLM_COORDINATE_SYSTEM) {
        GlmCoordinateSystem.LEFT_HANDED -> when (GLM_DEPTH_CLIP_SPACE) {
            GlmDepthClipSpace.ZERO_TO_ONE -> frustumLhZo(res, left, right, bottom, top, near, far)
            else -> frustumLhNo(res, left, right, bottom, top, near, far)
        }
        else -> when (GLM_DEPTH_CLIP_SPACE) {
            GlmDepthClipSpace.ZERO_TO_ONE -> frustumRhZo(res, left, right, bottom, top, near, far)
            else -> frustumRhNo(res, left, right, bottom, top, near, far)
        }
    }

    /** Creates a frustum matrix with default handedness, using the default handedness and default near and far clip planes definition.
     *  To change default handedness use LEFT_HANDED. To change default near and far clip planes definition use ZERO_TO_ONE.
     *
     *  @see gtc_matrix_transform
     *  @see <a href="https://www.khronos.org/registry/OpenGL-Refpages/gl2.1/xhtml/glFrustum.xml">glFrustum man page</a>
     */
    fun frustum(left: Double, right: Double, bottom: Double, top: Double, near: Double, far: Double): Mat4d = when (GLM_COORDINATE_SYSTEM) {
        GlmCoordinateSystem.LEFT_HANDED -> when (GLM_DEPTH_CLIP_SPACE) {
            GlmDepthClipSpace.ZERO_TO_ONE -> frustumLhZo(Mat4d(), left, right, bottom, top, near, far)
            else -> frustumLhNo(Mat4d(), left, right, bottom, top, near, far)
        }
        else -> when (GLM_DEPTH_CLIP_SPACE) {
            GlmDepthClipSpace.ZERO_TO_ONE -> frustumRhZo(Mat4d(), left, right, bottom, top, near, far)
            else -> frustumRhNo(Mat4d(), left, right, bottom, top, near, far)
        }
    }
}