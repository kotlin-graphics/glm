package glm_.ext.matrixTransform

import glm_.d
import glm_.detail.GLM_COORDINATE_SYSTEM
import glm_.detail.GLM_DEPTH_CLIP_SPACE
import glm_.detail.GlmCoordinateSystem
import glm_.detail.GlmDepthClipSpace
import glm_.f
import glm_.glm
import glm_.mat4x4.Mat4
import glm_.mat4x4.Mat4d
import glm_.vec2.Vec2t
import kotlin.math.abs
import kotlin.math.cos
import kotlin.math.sin
import kotlin.math.tan


interface ext_matrixTransform_perspective {

    /** Creates a matrix for a right handed, symetric perspective-view frustum.
     *  The near and far clip planes correspond to z normalized device coordinates of 0 and +1 respectively. (Direct3D clip volume definition)
     *
     *  @param res the resulting matrix
     *  @param fovY Specifies the field of view angle, in degrees, in the y direction. Expressed in radians.
     *  @param aspect Specifies the aspect ratio that determines the field of view in the x direction. The aspect ratio is the ratio of x (width) to y (height).
     *  @param near Specifies the distance from the viewer to the near clipping plane (always positive).
     *  @param far Specifies the distance from the viewer to the far clipping plane (always positive).
     *
     *  @see gtc_matrix_transform
     */
    fun perspectiveRhZo(fovY: Float, aspect: Float, near: Float, far: Float, res: Mat4): Mat4 {

        assert(abs(aspect - Float.MIN_VALUE) > 0f)

        val tanHalfFovY = tan(fovY / 2f)

        res put 0f
        res[0, 0] = 1f / (aspect * tanHalfFovY)
        res[1, 1] = 1f / (tanHalfFovY)
        res[2, 2] = far / (near - far)
        res[2, 3] = -1f
        res[3, 2] = -(far * near) / (far - near)
        return res
    }

    /** Creates a matrix for a right handed, symetric perspective-view frustum.
     *  The near and far clip planes correspond to z normalized device coordinates of 0 and +1 respectively. (Direct3D clip volume definition)
     *
     *  @param fovY Specifies the field of view angle, in degrees, in the y direction. Expressed in radians.
     *  @param aspect Specifies the aspect ratio that determines the field of view in the x direction. The aspect ratio is the ratio of x (width) to y (height).
     *  @param near Specifies the distance from the viewer to the near clipping plane (always positive).
     *  @param far Specifies the distance from the viewer to the far clipping plane (always positive).
     *
     *  @see gtc_matrix_transform
     */
    fun perspectiveRhZo(fovY: Float, aspect: Float, near: Float, far: Float): Mat4 =
            perspectiveRhZo(fovY, aspect, near, far, Mat4())

    /** Creates a matrix for a right handed, symetric perspective-view frustum.
     *  The near and far clip planes correspond to z normalized device coordinates of -1 and +1 respectively. (OpenGL clip volume definition)
     *
     *  @param res the resulting matrix
     *  @param fovY Specifies the field of view angle, in degrees, in the y direction. Expressed in radians.
     *  @param aspect Specifies the aspect ratio that determines the field of view in the x direction. The aspect ratio is the ratio of x (width) to y (height).
     *  @param near Specifies the distance from the viewer to the near clipping plane (always positive).
     *  @param far Specifies the distance from the viewer to the far clipping plane (always positive).
     *
     *  @see gtc_matrix_transform
     */
    fun perspectiveRhNo(res: Mat4, fovY: Float, aspect: Float, near: Float, far: Float): Mat4 {

        assert(abs(aspect - Float.MIN_VALUE) > 0f)

        val tanHalfFovy = tan(fovY / 2f)

        res put 0f
        res[0, 0] = 1f / (aspect * tanHalfFovy)
        res[1, 1] = 1f / (tanHalfFovy)
        res[2, 2] = -(far + near) / (far - near)
        res[2, 3] = -1f
        res[3, 2] = -(2f * far * near) / (far - near)
        return res
    }

    /** Creates a matrix for a right handed, symetric perspective-view frustum.
     *  The near and far clip planes correspond to z normalized device coordinates of -1 and +1 respectively. (OpenGL clip volume definition)
     *
     *  @param fovY Specifies the field of view angle, in degrees, in the y direction. Expressed in radians.
     *  @param aspect Specifies the aspect ratio that determines the field of view in the x direction. The aspect ratio is the ratio of x (width) to y (height).
     *  @param near Specifies the distance from the viewer to the near clipping plane (always positive).
     *  @param far Specifies the distance from the viewer to the far clipping plane (always positive).
     *
     *  @see gtc_matrix_transform
     */
    fun perspectiveRhNo(fovY: Float, aspect: Float, near: Float, far: Float): Mat4 =
            perspectiveRhNo(Mat4(), fovY, aspect, near, far)

    /** Creates a matrix for a left handed, symetric perspective-view frustum.
     *  The near and far clip planes correspond to z normalized device coordinates of 0 and +1 respectively. (Direct3D clip volume definition)
     *
     *  @param res the resulting matrix
     *  @param fovY Specifies the field of view angle, in degrees, in the y direction. Expressed in radians.
     *  @param aspect Specifies the aspect ratio that determines the field of view in the x direction. The aspect ratio is the ratio of x (width) to y (height).
     *  @param near Specifies the distance from the viewer to the near clipping plane (always positive).
     *  @param far Specifies the distance from the viewer to the far clipping plane (always positive).
     *
     *  @see gtc_matrix_transform
     */
    fun perspectiveLhZo(fovY: Float, aspect: Float, near: Float, far: Float, res: Mat4): Mat4 {

        assert(abs(aspect - Float.MIN_VALUE) > 0f)

        val tanHalfFovy = tan(fovY / 2f)

        res put 0f
        res[0, 0] = 1f / (aspect * tanHalfFovy)
        res[1, 1] = 1f / (tanHalfFovy)
        res[2, 2] = far / (far - near)
        res[2, 3] = 1f
        res[3, 2] = -(far * near) / (far - near)
        return res
    }

    /** Creates a matrix for a left handed, symetric perspective-view frustum.
     *  The near and far clip planes correspond to z normalized device coordinates of 0 and +1 respectively. (Direct3D clip volume definition)
     *
     *  @param fovY Specifies the field of view angle, in degrees, in the y direction. Expressed in radians.
     *  @param aspect Specifies the aspect ratio that determines the field of view in the x direction. The aspect ratio is the ratio of x (width) to y (height).
     *  @param near Specifies the distance from the viewer to the near clipping plane (always positive).
     *  @param far Specifies the distance from the viewer to the far clipping plane (always positive).
     *
     *  @see gtc_matrix_transform
     */
    fun perspectiveLhZo(fovY: Float, aspect: Float, near: Float, far: Float): Mat4 =
            perspectiveLhZo(fovY, aspect, near, far, Mat4())

    /** Creates a matrix for a left handed, symetric perspective-view frustum.
     *  The near and far clip planes correspond to z normalized device coordinates of -1 and +1 respectively. (OpenGL clip volume definition)
     *
     * @param res the resulting matrix
     *  @param fovY Specifies the field of view angle, in degrees, in the y direction. Expressed in radians.
     *  @param aspect Specifies the aspect ratio that determines the field of view in the x direction. The aspect ratio is the ratio of x (width) to y (height).
     *  @param near Specifies the distance from the viewer to the near clipping plane (always positive).
     *  @param far Specifies the distance from the viewer to the far clipping plane (always positive).
     *
     *  @see gtc_matrix_transform
     */
    fun perspectiveLhNo(fovY: Float, aspect: Float, near: Float, far: Float, res: Mat4): Mat4 {

        assert(abs(aspect - Float.MIN_VALUE) > 0f)

        val tanHalfFovy = tan(fovY / 2f)

        res put 0f
        res[0, 0] = 1f / (aspect * tanHalfFovy)
        res[1, 1] = 1f / (tanHalfFovy)
        res[2, 2] = (far + near) / (far - near)
        res[2, 3] = 1f
        res[3, 2] = -(2f * far * near) / (far - near)
        return res
    }

    /** Creates a matrix for a left handed, symetric perspective-view frustum.
     *  The near and far clip planes correspond to z normalized device coordinates of -1 and +1 respectively. (OpenGL clip volume definition)
     *
     *  @param fovY Specifies the field of view angle, in degrees, in the y direction. Expressed in radians.
     *  @param aspect Specifies the aspect ratio that determines the field of view in the x direction. The aspect ratio is the ratio of x (width) to y (height).
     *  @param near Specifies the distance from the viewer to the near clipping plane (always positive).
     *  @param far Specifies the distance from the viewer to the far clipping plane (always positive).
     *
     *  @see gtc_matrix_transform
     */
    fun perspectiveLhNo(fovY: Float, aspect: Float, near: Float, far: Float): Mat4 =
            perspectiveLhNo(fovY, aspect, near, far, Mat4())

    /** Creates a matrix for a symetric perspective-view frustum using left-handed coordinates if GLM_COORDINATE_SYSTEM is LEFT_HANDED or right-handed coordinates otherwise.
     *  The near and far clip planes correspond to z normalized device coordinates of 0 and +1 respectively. (Direct3D clip volume definition)
     *
     *  @param res the resulting matrix
     *  @param fovY Specifies the field of view angle, in degrees, in the y direction. Expressed in radians.
     *  @param aspect Specifies the aspect ratio that determines the field of view in the x direction. The aspect ratio is the ratio of x (width) to y (height).
     *  @param near Specifies the distance from the viewer to the near clipping plane (always positive).
     *  @param far Specifies the distance from the viewer to the far clipping plane (always positive).
     *
     *  @see gtc_matrix_transform
     */
    fun perspectiveZo(fovY: Float, aspect: Float, near: Float, far: Float, res: Mat4): Mat4 =
            when (GLM_COORDINATE_SYSTEM) {
                GlmCoordinateSystem.LEFT_HANDED -> perspectiveLhZo(fovY, aspect, near, far, res)
                else -> perspectiveRhZo(fovY, aspect, near, far, res)
            }

    /** Creates a matrix for a symetric perspective-view frustum using left-handed coordinates if GLM_COORDINATE_SYSTEM is LEFT_HANDED or right-handed coordinates otherwise.
     *  The near and far clip planes correspond to z normalized device coordinates of 0 and +1 respectively. (Direct3D clip volume definition)
     *
     *  @param fovY Specifies the field of view angle, in degrees, in the y direction. Expressed in radians.
     *  @param aspect Specifies the aspect ratio that determines the field of view in the x direction. The aspect ratio is the ratio of x (width) to y (height).
     *  @param near Specifies the distance from the viewer to the near clipping plane (always positive).
     *  @param far Specifies the distance from the viewer to the far clipping plane (always positive).
     *
     *  @see gtc_matrix_transform
     */
    fun perspectiveZo(fovY: Float, aspect: Float, near: Float, far: Float): Mat4 =
            when (GLM_COORDINATE_SYSTEM) {
                GlmCoordinateSystem.LEFT_HANDED -> perspectiveLhZo(fovY, aspect, near, far, Mat4())
                else -> perspectiveRhZo(fovY, aspect, near, far, Mat4())
            }

    /** Creates a matrix for a symetric perspective-view frustum using left-handed coordinates if GLM_COORDINATE_SYSTEM is LEFT_HANDED or right-handed coordinates otherwise.
     *  The near and far clip planes correspond to z normalized device coordinates of -1 and +1 respectively. (OpenGL clip volume definition)
     *
     *  @param res the resulting matrix
     *  @param fovY Specifies the field of view angle, in degrees, in the y direction. Expressed in radians.
     *  @param aspect Specifies the aspect ratio that determines the field of view in the x direction. The aspect ratio is the ratio of x (width) to y (height).
     *  @param near Specifies the distance from the viewer to the near clipping plane (always positive).
     *  @param far Specifies the distance from the viewer to the far clipping plane (always positive).
     *
     *  @see gtc_matrix_transform
     */
    fun perspectiveNo(fovY: Float, aspect: Float, near: Float, far: Float, res: Mat4): Mat4 =
            when (GLM_COORDINATE_SYSTEM) {
                GlmCoordinateSystem.LEFT_HANDED -> perspectiveLhNo(fovY, aspect, near, far, res)
                else -> perspectiveRhNo(res, fovY, aspect, near, far)
            }

    /** Creates a matrix for a symetric perspective-view frustum using left-handed coordinates if GLM_COORDINATE_SYSTEM is LEFT_HANDED or right-handed coordinates otherwise.
     *  The near and far clip planes correspond to z normalized device coordinates of -1 and +1 respectively. (OpenGL clip volume definition)
     *
     *  @param fovY Specifies the field of view angle, in degrees, in the y direction. Expressed in radians.
     *  @param aspect Specifies the aspect ratio that determines the field of view in the x direction. The aspect ratio is the ratio of x (width) to y (height).
     *  @param near Specifies the distance from the viewer to the near clipping plane (always positive).
     *  @param far Specifies the distance from the viewer to the far clipping plane (always positive).
     *
     *  @see gtc_matrix_transform
     */
    fun perspectiveNo(fovY: Float, aspect: Float, near: Float, far: Float): Mat4 =
            when (GLM_COORDINATE_SYSTEM) {
                GlmCoordinateSystem.LEFT_HANDED -> perspectiveLhNo(fovY, aspect, near, far, Mat4())
                else -> perspectiveRhNo(Mat4(), fovY, aspect, near, far)
            }

    /** Creates a matrix for a right handed, symetric perspective-view frustum.
     *  If GLM_DEPTH_CLIP_SPACE is ZERO_TO_ONE, the near and far clip planes correspond to z normalized device coordinates of 0 and +1 respectively. (Direct3D clip volume definition)
     *  Otherwise, the near and far clip planes correspond to z normalized device coordinates of -1 and +1 respectively. (OpenGL clip volume definition)
     *
     *  @param res the resulting matrix
     *  @param fovY Specifies the field of view angle, in degrees, in the y direction. Expressed in radians.
     *  @param aspect Specifies the aspect ratio that determines the field of view in the x direction. The aspect ratio is the ratio of x (width) to y (height).
     *  @param near Specifies the distance from the viewer to the near clipping plane (always positive).
     *  @param far Specifies the distance from the viewer to the far clipping plane (always positive).
     *
     *  @see gtc_matrix_transform
     */
    fun perspectiveRh(fovY: Float, aspect: Float, near: Float, far: Float, res: Mat4): Mat4 =
            when (GLM_DEPTH_CLIP_SPACE) {
                GlmDepthClipSpace.ZERO_TO_ONE -> perspectiveRhZo(fovY, aspect, near, far, res)
                else -> perspectiveRhNo(res, fovY, aspect, near, far)
            }

    /** Creates a matrix for a right handed, symetric perspective-view frustum.
     *  If GLM_DEPTH_CLIP_SPACE is ZERO_TO_ONE, the near and far clip planes correspond to z normalized device coordinates of 0 and +1 respectively. (Direct3D clip volume definition)
     *  Otherwise, the near and far clip planes correspond to z normalized device coordinates of -1 and +1 respectively. (OpenGL clip volume definition)
     *
     *  @param fovY Specifies the field of view angle, in degrees, in the y direction. Expressed in radians.
     *  @param aspect Specifies the aspect ratio that determines the field of view in the x direction. The aspect ratio is the ratio of x (width) to y (height).
     *  @param near Specifies the distance from the viewer to the near clipping plane (always positive).
     *  @param far Specifies the distance from the viewer to the far clipping plane (always positive).
     *
     *  @see gtc_matrix_transform
     */
    fun perspectiveRh(fovY: Float, aspect: Float, near: Float, far: Float): Mat4 =
            when (GLM_DEPTH_CLIP_SPACE) {
                GlmDepthClipSpace.ZERO_TO_ONE -> perspectiveRhZo(fovY, aspect, near, far, Mat4())
                else -> perspectiveRhNo(Mat4(), fovY, aspect, near, far)
            }

    /** Creates a matrix for a left handed, symetric perspective-view frustum.
     *  If GLM_DEPTH_CLIP_SPACE is ZERO_TO_ONE, the near and far clip planes correspond to z normalized device coordinates of 0 and +1 respectively. (Direct3D clip volume definition)
     *  Otherwise, the near and far clip planes correspond to z normalized device coordinates of -1 and +1 respectively. (OpenGL clip volume definition)
     *
     *  @param res the resulting matrix
     *  @param fovY Specifies the field of view angle, in degrees, in the y direction. Expressed in radians.
     *  @param aspect Specifies the aspect ratio that determines the field of view in the x direction. The aspect ratio is the ratio of x (width) to y (height).
     *  @param near Specifies the distance from the viewer to the near clipping plane (always positive).
     *  @param far Specifies the distance from the viewer to the far clipping plane (always positive).
     *
     *  @see gtc_matrix_transform
     */
    fun perspectiveLh(fovY: Float, aspect: Float, near: Float, far: Float, res: Mat4): Mat4 =
            when (GLM_DEPTH_CLIP_SPACE) {
                GlmDepthClipSpace.ZERO_TO_ONE -> perspectiveLhZo(fovY, aspect, near, far, res)
                else -> perspectiveLhNo(fovY, aspect, near, far, res)
            }

    /** Creates a matrix for a left handed, symetric perspective-view frustum.
     *  If GLM_DEPTH_CLIP_SPACE is ZERO_TO_ONE, the near and far clip planes correspond to z normalized device coordinates of 0 and +1 respectively. (Direct3D clip volume definition)
     *  Otherwise, the near and far clip planes correspond to z normalized device coordinates of -1 and +1 respectively. (OpenGL clip volume definition)
     *
     *  @param fovY Specifies the field of view angle, in degrees, in the y direction. Expressed in radians.
     *  @param aspect Specifies the aspect ratio that determines the field of view in the x direction. The aspect ratio is the ratio of x (width) to y (height).
     *  @param near Specifies the distance from the viewer to the near clipping plane (always positive).
     *  @param far Specifies the distance from the viewer to the far clipping plane (always positive).
     *
     *  @see gtc_matrix_transform
     */
    fun perspectiveLh(fovY: Float, aspect: Float, near: Float, far: Float): Mat4 =
            when (GLM_DEPTH_CLIP_SPACE) {
                GlmDepthClipSpace.ZERO_TO_ONE -> perspectiveLhZo(fovY, aspect, near, far, Mat4())
                else -> perspectiveLhNo(fovY, aspect, near, far, Mat4())
            }

    /** Creates a matrix for a symetric perspective-view frustum based on the default handedness and default near and far clip planes definition.
     *  To change default handedness use LEFT_HANDED. To change default near and far clip planes definition use ZERO_TO_ONE.
     *
     *  @param res the resulting matrix
     *  @param fovY Specifies the field of view angle in the y direction. Expressed in radians.
     *  @param aspect Specifies the aspect ratio that determines the field of view in the x direction. The aspect ratio is the ratio of x (width) to y (height).
     *  @param near Specifies the distance from the viewer to the near clipping plane (always positive).
     *  @param far Specifies the distance from the viewer to the far clipping plane (always positive).
     *
     *  @see gtc_matrix_transform
     *  @see <a href="https://www.khronos.org/registry/OpenGL-Refpages/gl2.1/xhtml/gluPerspective.xml">gluPerspective man page</a>
     */
    fun perspective(fovY: Float, aspect: Float, near: Float, far: Float, res: Mat4): Mat4 =
            when (GLM_COORDINATE_SYSTEM) {
                GlmCoordinateSystem.LEFT_HANDED -> when (GLM_DEPTH_CLIP_SPACE) {
                    GlmDepthClipSpace.ZERO_TO_ONE -> perspectiveLhZo(fovY, aspect, near, far, res)
                    else -> perspectiveLhNo(fovY, aspect, near, far, res)
                }
                else -> when (GLM_DEPTH_CLIP_SPACE) {
                    GlmDepthClipSpace.ZERO_TO_ONE -> perspectiveRhZo(fovY, aspect, near, far, res)
                    else -> perspectiveRhNo(res, fovY, aspect, near, far)
                }
            }

    /** Creates a matrix for a symetric perspective-view frustum based on the default handedness and default near and far clip planes definition.
     *  To change default handedness use LEFT_HANDED. To change default near and far clip planes definition use ZERO_TO_ONE.
     *
     *  @param fovY Specifies the field of view angle in the y direction. Expressed in radians.
     *  @param aspect Specifies the aspect ratio that determines the field of view in the x direction. The aspect ratio is the ratio of x (width) to y (height).
     *  @param near Specifies the distance from the viewer to the near clipping plane (always positive).
     *  @param far Specifies the distance from the viewer to the far clipping plane (always positive).
     *
     *  @see gtc_matrix_transform
     *  @see <a href="https://www.khronos.org/registry/OpenGL-Refpages/gl2.1/xhtml/gluPerspective.xml">gluPerspective man page</a>
     */
    fun perspective(fovY: Float, aspect: Float, near: Float, far: Float): Mat4 =
            when (GLM_COORDINATE_SYSTEM) {
                GlmCoordinateSystem.LEFT_HANDED -> when (GLM_DEPTH_CLIP_SPACE) {
                    GlmDepthClipSpace.ZERO_TO_ONE -> perspectiveLhZo(fovY, aspect, near, far, Mat4())
                    else -> perspectiveLhNo(fovY, aspect, near, far, Mat4())
                }
                else -> when (GLM_DEPTH_CLIP_SPACE) {
                    GlmDepthClipSpace.ZERO_TO_ONE -> perspectiveRhZo(fovY, aspect, near, far, Mat4())
                    else -> perspectiveRhNo(Mat4(), fovY, aspect, near, far)
                }
            }

    /** Builds a perspective projection matrix based on a field of view using right-handed coordinates.
     *  The near and far clip planes correspond to z normalized device coordinates of 0 and +1 respectively. (Direct3D clip volume definition)
     *
     *  @param res the resulting matrix
     *  @param fov Expressed in radians.
     *  @param width Width of the viewport
     *  @param height Height of the viewport
     *  @param near Specifies the distance from the viewer to the near clipping plane (always positive).
     *  @param far Specifies the distance from the viewer to the far clipping plane (always positive).
     *
     *  @see gtc_matrix_transform
     */
    fun perspectiveFovRhZo(fov: Float, width: Float, height: Float, near: Float, far: Float, res: Mat4): Mat4 {

        assert(width > 0f && height > 0f && fov > 0f)

        val h = cos(0.5f * fov) / sin(0.5f * fov)
        val w = h * height / width ///todo max(width , Height) / min(width , Height)?

        res put 0f
        res[0, 0] = w
        res[1, 1] = h
        res[2, 2] = far / (near - far)
        res[2, 3] = -1f
        res[3, 2] = -(far * near) / (far - near)
        return res
    }

    /** Builds a perspective projection matrix based on a field of view using right-handed coordinates.
     *  The near and far clip planes correspond to z normalized device coordinates of 0 and +1 respectively. (Direct3D clip volume definition)
     *
     *  @param fov Expressed in radians.
     *  @param width Width of the viewport
     *  @param height Height of the viewport
     *  @param near Specifies the distance from the viewer to the near clipping plane (always positive).
     *  @param far Specifies the distance from the viewer to the far clipping plane (always positive).
     *
     *  @see gtc_matrix_transform
     */
    fun perspectiveFovRhZo(fov: Float, width: Float, height: Float, near: Float, far: Float): Mat4 =
            perspectiveFovRhZo(fov, width, height, near, far, Mat4())

    /** Builds a perspective projection matrix based on a field of view using right-handed coordinates.
     *  The near and far clip planes correspond to z normalized device coordinates of 0 and +1 respectively. (Direct3D clip volume definition)
     *
     *  @param res the resulting matrix
     *  @param fov Expressed in radians.
     *  @param size viewport dimensions
     *  @param near Specifies the distance from the viewer to the near clipping plane (always positive).
     *  @param far Specifies the distance from the viewer to the far clipping plane (always positive).
     *
     *  @see gtc_matrix_transform
     */
    fun perspectiveFovRhZo(fov: Float, size: Vec2t<*>, near: Float, far: Float, res: Mat4): Mat4 =
            perspectiveFovRhZo(fov, size.x.f, size.y.f, near, far, res)

    /** Builds a perspective projection matrix based on a field of view using right-handed coordinates.
     *  The near and far clip planes correspond to z normalized device coordinates of 0 and +1 respectively. (Direct3D clip volume definition)
     *
     *  @param fov Expressed in radians.
     *  @param size viewport dimensions
     *  @param near Specifies the distance from the viewer to the near clipping plane (always positive).
     *  @param far Specifies the distance from the viewer to the far clipping plane (always positive).
     *
     *  @see gtc_matrix_transform
     */
    fun perspectiveFovRhZo(fov: Float, size: Vec2t<*>, near: Float, far: Float): Mat4 =
            perspectiveFovRhZo(fov, size.x.f, size.y.f, near, far, Mat4())

    /** Builds a perspective projection matrix based on a field of view using right-handed coordinates.
     *  The near and far clip planes correspond to z normalized device coordinates of -1 and +1 respectively. (OpenGL clip volume definition)
     *
     *  @param res the resulting matrix
     *  @param fov Expressed in radians.
     *  @param width Width of the viewport
     *  @param height Height of the viewport
     *  @param near Specifies the distance from the viewer to the near clipping plane (always positive).
     *  @param far Specifies the distance from the viewer to the far clipping plane (always positive).
     *
     *  @see gtc_matrix_transform
     */
    fun perspectiveFovRhNo(fov: Float, width: Float, height: Float, near: Float, far: Float, res: Mat4): Mat4 {

        assert(width > 0f && height > 0f && fov > 0f)

        val h = cos(0.5f * fov) / sin(0.5f * fov)
        val w = h * height / width ///todo max(width , Height) / min(width , Height)?

        res put 0f
        res[0, 0] = w
        res[1, 1] = h
        res[2, 2] = -(far + near) / (far - near)
        res[2, 3] = -1f
        res[3, 2] = -(2f * far * near) / (far - near)
        return res
    }

    /** Builds a perspective projection matrix based on a field of view using right-handed coordinates.
     *  The near and far clip planes correspond to z normalized device coordinates of -1 and +1 respectively. (OpenGL clip volume definition)
     *
     *  @param fov Expressed in radians.
     *  @param width Width of the viewport
     *  @param height Height of the viewport
     *  @param near Specifies the distance from the viewer to the near clipping plane (always positive).
     *  @param far Specifies the distance from the viewer to the far clipping plane (always positive).
     *
     *  @see gtc_matrix_transform
     */
    fun perspectiveFovRhNo(fov: Float, width: Float, height: Float, near: Float, far: Float): Mat4 =
            perspectiveFovRhNo(fov, width, height, near, far, Mat4())

    /** Builds a perspective projection matrix based on a field of view using right-handed coordinates.
     *  The near and far clip planes correspond to z normalized device coordinates of -1 and +1 respectively. (OpenGL clip volume definition)
     *
     *  @param res the resulting matrix
     *  @param fov Expressed in radians.
     *  @param size viewport dimensions
     *  @param near Specifies the distance from the viewer to the near clipping plane (always positive).
     *  @param far Specifies the distance from the viewer to the far clipping plane (always positive).
     *
     *  @see gtc_matrix_transform
     */
    fun perspectiveFovRhNo(fov: Float, size: Vec2t<*>, near: Float, far: Float, res: Mat4): Mat4 =
            perspectiveFovRhNo(fov, size.x.f, size.y.f, near, far, res)

    /** Builds a perspective projection matrix based on a field of view using right-handed coordinates.
     *  The near and far clip planes correspond to z normalized device coordinates of -1 and +1 respectively. (OpenGL clip volume definition)
     *
     *  @param fov Expressed in radians.
     *  @param size viewport dimensions
     *  @param near Specifies the distance from the viewer to the near clipping plane (always positive).
     *  @param far Specifies the distance from the viewer to the far clipping plane (always positive).
     *
     *  @see gtc_matrix_transform
     */
    fun perspectiveFovRhNo(fov: Float, size: Vec2t<*>, near: Float, far: Float): Mat4 =
            perspectiveFovRhNo(fov, size.x.f, size.y.f, near, far, Mat4())

    /** Builds a perspective projection matrix based on a field of view using left-handed coordinates.
     *  The near and far clip planes correspond to z normalized device coordinates of 0 and +1 respectively. (Direct3D clip volume definition)
     *
     *  @param res the resulting matrix
     *  @param fov Expressed in radians.
     *  @param width Width of the viewport
     *  @param height Height of the viewport
     *  @param near Specifies the distance from the viewer to the near clipping plane (always positive).
     *  @param far Specifies the distance from the viewer to the far clipping plane (always positive).
     *
     *  @see gtc_matrix_transform
     */
    fun perspectiveFovLhZo(fov: Float, width: Float, height: Float, near: Float, far: Float, res: Mat4): Mat4 {

        assert(width > 0f && height > 0f && fov > 0f)

        val h = cos(0.5f * fov) / sin(0.5f * fov)
        val w = h * height / width ///todo max(width , Height) / min(width , Height)?

        res put 0f
        res[0, 0] = w
        res[1, 1] = h
        res[2, 2] = far / (far - near)
        res[2, 3] = 1f
        res[3, 2] = -(far * near) / (far - near)
        return res
    }

    /** Builds a perspective projection matrix based on a field of view using left-handed coordinates.
     *  The near and far clip planes correspond to z normalized device coordinates of 0 and +1 respectively. (Direct3D clip volume definition)
     *
     *  @param fov Expressed in radians.
     *  @param width Width of the viewport
     *  @param height Height of the viewport
     *  @param near Specifies the distance from the viewer to the near clipping plane (always positive).
     *  @param far Specifies the distance from the viewer to the far clipping plane (always positive).
     *
     *  @see gtc_matrix_transform
     */
    fun perspectiveFovLhZo(fov: Float, width: Float, height: Float, near: Float, far: Float): Mat4 =
            perspectiveFovLhZo(fov, width, height, near, far, Mat4())

    /** Builds a perspective projection matrix based on a field of view using left-handed coordinates.
     *  The near and far clip planes correspond to z normalized device coordinates of 0 and +1 respectively. (Direct3D clip volume definition)
     *
     *  @param res the resulting matrix
     *  @param fov Expressed in radians.
     *  @param size viewport dimensions
     *  @param near Specifies the distance from the viewer to the near clipping plane (always positive).
     *  @param far Specifies the distance from the viewer to the far clipping plane (always positive).
     *
     *  @see gtc_matrix_transform
     */
    fun perspectiveFovLhZo(fov: Float, size: Vec2t<*>, near: Float, far: Float, res: Mat4): Mat4 =
            perspectiveFovLhZo(fov, size.x.f, size.y.f, near, far, res)

    /** Builds a perspective projection matrix based on a field of view using left-handed coordinates.
     *  The near and far clip planes correspond to z normalized device coordinates of 0 and +1 respectively. (Direct3D clip volume definition)
     *
     *  @param fov Expressed in radians.
     *  @param size viewport dimensions
     *  @param near Specifies the distance from the viewer to the near clipping plane (always positive).
     *  @param far Specifies the distance from the viewer to the far clipping plane (always positive).
     *
     *  @see gtc_matrix_transform
     */
    fun perspectiveFovLhZo(fov: Float, size: Vec2t<*>, near: Float, far: Float): Mat4 =
            perspectiveFovLhZo(fov, size.x.f, size.y.f, near, far, Mat4())

    /** Builds a perspective projection matrix based on a field of view using left-handed coordinates.
     *  The near and far clip planes correspond to z normalized device coordinates of -1 and +1 respectively. (OpenGL clip volume definition)
     *
     *  @param res the resulting matrix
     *  @param fov Expressed in radians.
     *  @param width Width of the viewport
     *  @param height Height of the viewport
     *  @param near Specifies the distance from the viewer to the near clipping plane (always positive).
     *  @param far Specifies the distance from the viewer to the far clipping plane (always positive).
     *
     *  @see gtc_matrix_transform
     */
    fun perspectiveFovLhNo(fov: Float, width: Float, height: Float, near: Float, far: Float, res: Mat4): Mat4 {

        assert(width > 0f && height > 0f && fov > 0f)

        val h = cos(0.5f * fov) / sin(0.5f * fov)
        val w = h * height / width ///todo max(width , Height) / min(width , Height)?

        res put 0f
        res[0, 0] = w
        res[1, 1] = h
        res[2, 2] = (far + near) / (far - near)
        res[2, 3] = 1f
        res[3, 2] = -(2f * far * near) / (far - near)
        return res
    }

    /** Builds a perspective projection matrix based on a field of view using left-handed coordinates.
     *  The near and far clip planes correspond to z normalized device coordinates of -1 and +1 respectively. (OpenGL clip volume definition)
     *
     *  @param fov Expressed in radians.
     *  @param width Width of the viewport
     *  @param height Height of the viewport
     *  @param near Specifies the distance from the viewer to the near clipping plane (always positive).
     *  @param far Specifies the distance from the viewer to the far clipping plane (always positive).
     *
     *  @see gtc_matrix_transform
     */
    fun perspectiveFovLhNo(fov: Float, width: Float, height: Float, near: Float, far: Float): Mat4 =
            perspectiveFovLhNo(fov, width, height, near, far, Mat4())

    /** Builds a perspective projection matrix based on a field of view using left-handed coordinates.
     *  The near and far clip planes correspond to z normalized device coordinates of -1 and +1 respectively. (OpenGL clip volume definition)
     *
     *  @param res the resulting matrix
     *  @param fov Expressed in radians.
     *  @param size viewport dimensions
     *  @param near Specifies the distance from the viewer to the near clipping plane (always positive).
     *  @param far Specifies the distance from the viewer to the far clipping plane (always positive).
     *
     *  @see gtc_matrix_transform
     */
    fun perspectiveFovLhNo(fov: Float, size: Vec2t<*>, near: Float, far: Float, res: Mat4): Mat4 =
            perspectiveFovLhNo(fov, size.x.f, size.y.f, near, far, res)

    /** Builds a perspective projection matrix based on a field of view using left-handed coordinates.
     *  The near and far clip planes correspond to z normalized device coordinates of -1 and +1 respectively. (OpenGL clip volume definition)
     *
     *  @param fov Expressed in radians.
     *  @param size viewport dimensions
     *  @param near Specifies the distance from the viewer to the near clipping plane (always positive).
     *  @param far Specifies the distance from the viewer to the far clipping plane (always positive).
     *
     *  @see gtc_matrix_transform
     */
    fun perspectiveFovLhNo(fov: Float, size: Vec2t<*>, near: Float, far: Float): Mat4 =
            perspectiveFovLhNo(fov, size.x.f, size.y.f, near, far, Mat4())

    /** Builds a perspective projection matrix based on a field of view using left-handed coordinates if GLM_COORDINATE_SYSTEM is LEFT_HANDED or right-handed coordinates otherwise.
     *  The near and far clip planes correspond to z normalized device coordinates of 0 and +1 respectively. (Direct3D clip volume definition)
     *
     *  @param res the resulting matrix
     *  @param fov Expressed in radians.
     *  @param width Width of the viewport
     *  @param height Height of the viewport
     *  @param near Specifies the distance from the viewer to the near clipping plane (always positive).
     *  @param far Specifies the distance from the viewer to the far clipping plane (always positive).
     *
     *  @see gtc_matrix_transform
     */
    fun perspectiveFovZo(fov: Float, width: Float, height: Float, near: Float, far: Float, res: Mat4): Mat4 =
            when (GLM_COORDINATE_SYSTEM) {
                GlmCoordinateSystem.LEFT_HANDED -> perspectiveFovLhZo(fov, width, height, near, far, res)
                else -> perspectiveFovRhZo(fov, width, height, near, far, res)
            }

    /** Builds a perspective projection matrix based on a field of view using left-handed coordinates if GLM_COORDINATE_SYSTEM is LEFT_HANDED or right-handed coordinates otherwise.
     *  The near and far clip planes correspond to z normalized device coordinates of 0 and +1 respectively. (Direct3D clip volume definition)
     *
     *  @param fov Expressed in radians.
     *  @param width Width of the viewport
     *  @param height Height of the viewport
     *  @param near Specifies the distance from the viewer to the near clipping plane (always positive).
     *  @param far Specifies the distance from the viewer to the far clipping plane (always positive).
     *
     *  @see gtc_matrix_transform
     */
    fun perspectiveFovZo(fov: Float, width: Float, height: Float, near: Float, far: Float): Mat4 =
            when (GLM_COORDINATE_SYSTEM) {
                GlmCoordinateSystem.LEFT_HANDED -> perspectiveFovLhZo(fov, width, height, near, far, Mat4())
                else -> perspectiveFovRhZo(fov, width, height, near, far, Mat4())
            }

    /** Builds a perspective projection matrix based on a field of view using left-handed coordinates if GLM_COORDINATE_SYSTEM is LEFT_HANDED or right-handed coordinates otherwise.
     *  The near and far clip planes correspond to z normalized device coordinates of 0 and +1 respectively. (Direct3D clip volume definition)
     *
     *  @param res the resulting matrix
     *  @param fov Expressed in radians.
     *  @param size viewport dimensions
     *  @param near Specifies the distance from the viewer to the near clipping plane (always positive).
     *  @param far Specifies the distance from the viewer to the far clipping plane (always positive).
     *
     *  @see gtc_matrix_transform
     */
    fun perspectiveFovZo(fov: Float, size: Vec2t<*>, near: Float, far: Float, res: Mat4): Mat4 =
            when (GLM_COORDINATE_SYSTEM) {
                GlmCoordinateSystem.LEFT_HANDED -> perspectiveFovLhZo(fov, size.x.f, size.y.f, near, far, res)
                else -> perspectiveFovRhZo(fov, size.x.f, size.y.f, near, far, res)
            }

    /** Builds a perspective projection matrix based on a field of view using left-handed coordinates if GLM_COORDINATE_SYSTEM is LEFT_HANDED or right-handed coordinates otherwise.
     *  The near and far clip planes correspond to z normalized device coordinates of 0 and +1 respectively. (Direct3D clip volume definition)
     *
     *  @param fov Expressed in radians.
     *  @param size viewport dimensions
     *  @param near Specifies the distance from the viewer to the near clipping plane (always positive).
     *  @param far Specifies the distance from the viewer to the far clipping plane (always positive).
     *
     *  @see gtc_matrix_transform
     */
    fun perspectiveFovZo(fov: Float, size: Vec2t<*>, near: Float, far: Float): Mat4 =
            when (GLM_COORDINATE_SYSTEM) {
                GlmCoordinateSystem.LEFT_HANDED -> perspectiveFovLhZo(fov, size.x.f, size.y.f, near, far, Mat4())
                else -> perspectiveFovRhZo(fov, size.x.f, size.y.f, near, far, Mat4())
            }

    /** Builds a perspective projection matrix based on a field of view using left-handed coordinates if GLM_COORDINATE_SYSTEM is LEFT_HANDED or right-handed coordinates otherwise.
     *  The near and far clip planes correspond to z normalized device coordinates of -1 and +1 respectively. (OpenGL clip volume definition)
     *
     *  @param res the resulting matrix
     *  @param fov Expressed in radians.
     *  @param width Width of the viewport
     *  @param height Height of the viewport
     *  @param near Specifies the distance from the viewer to the near clipping plane (always positive).
     *  @param far Specifies the distance from the viewer to the far clipping plane (always positive).
     *
     *  @see gtc_matrix_transform
     */
    fun perspectiveFovNo(fov: Float, width: Float, height: Float, near: Float, far: Float, res: Mat4): Mat4 =
            when (GLM_COORDINATE_SYSTEM) {
                GlmCoordinateSystem.LEFT_HANDED -> perspectiveFovLhNo(fov, width, height, near, far, res)
                else -> perspectiveFovRhNo(fov, width, height, near, far, res)
            }

    /** Builds a perspective projection matrix based on a field of view using left-handed coordinates if GLM_COORDINATE_SYSTEM is LEFT_HANDED or right-handed coordinates otherwise.
     *  The near and far clip planes correspond to z normalized device coordinates of -1 and +1 respectively. (OpenGL clip volume definition)
     *
     *  @param fov Expressed in radians.
     *  @param width Width of the viewport
     *  @param height Height of the viewport
     *  @param near Specifies the distance from the viewer to the near clipping plane (always positive).
     *  @param far Specifies the distance from the viewer to the far clipping plane (always positive).
     *
     *  @see gtc_matrix_transform
     */
    fun perspectiveFovNo(fov: Float, width: Float, height: Float, near: Float, far: Float): Mat4 =
            when (GLM_COORDINATE_SYSTEM) {
                GlmCoordinateSystem.LEFT_HANDED -> perspectiveFovLhNo(fov, width, height, near, far, Mat4())
                else -> perspectiveFovRhNo(fov, width, height, near, far, Mat4())
            }

    /** Builds a perspective projection matrix based on a field of view using left-handed coordinates if GLM_COORDINATE_SYSTEM is LEFT_HANDED or right-handed coordinates otherwise.
     *  The near and far clip planes correspond to z normalized device coordinates of -1 and +1 respectively. (OpenGL clip volume definition)
     *
     *  @param res the resulting matrix
     *  @param fov Expressed in radians.
     *  @param size viewport dimensions
     *  @param near Specifies the distance from the viewer to the near clipping plane (always positive).
     *  @param far Specifies the distance from the viewer to the far clipping plane (always positive).
     *
     *  @see gtc_matrix_transform
     */
    fun perspectiveFovNo(fov: Float, size: Vec2t<*>, near: Float, far: Float, res: Mat4): Mat4 =
            when (GLM_COORDINATE_SYSTEM) {
                GlmCoordinateSystem.LEFT_HANDED -> perspectiveFovLhNo(fov, size.x.f, size.y.f, near, far, res)
                else -> perspectiveFovRhNo(fov, size.x.f, size.y.f, near, far, res)
            }

    /** Builds a perspective projection matrix based on a field of view using left-handed coordinates if GLM_COORDINATE_SYSTEM is LEFT_HANDED or right-handed coordinates otherwise.
     *  The near and far clip planes correspond to z normalized device coordinates of -1 and +1 respectively. (OpenGL clip volume definition)
     *
     *  @param fov Expressed in radians.
     *  @param size viewport dimensions
     *  @param near Specifies the distance from the viewer to the near clipping plane (always positive).
     *  @param far Specifies the distance from the viewer to the far clipping plane (always positive).
     *
     *  @see gtc_matrix_transform
     */
    fun perspectiveFovNo(fov: Float, size: Vec2t<*>, near: Float, far: Float): Mat4 =
            when (GLM_COORDINATE_SYSTEM) {
                GlmCoordinateSystem.LEFT_HANDED -> perspectiveFovLhNo(fov, size.x.f, size.y.f, near, far, Mat4())
                else -> perspectiveFovRhNo(fov, size.x.f, size.y.f, near, far, Mat4())
            }

    /** Builds a right handed perspective projection matrix based on a field of view.
     *  If GLM_DEPTH_CLIP_SPACE is ZERO_TO_ONE, the near and far clip planes correspond to z normalized device coordinates of 0 and +1 respectively. (Direct3D clip volume definition)
     *  Otherwise, the near and far clip planes correspond to z normalized device coordinates of -1 and +1 respectively. (OpenGL clip volume definition)
     *
     *  @param res the resulting matrix
     *  @param fov Expressed in radians.
     *  @param width Width of the viewport
     *  @param height Height of the viewport
     *  @param near Specifies the distance from the viewer to the near clipping plane (always positive).
     *  @param far Specifies the distance from the viewer to the far clipping plane (always positive).
     *
     *  @see gtc_matrix_transform
     */
    fun perspectiveFovRh(fov: Float, width: Float, height: Float, near: Float, far: Float, res: Mat4): Mat4 =
            when (GLM_DEPTH_CLIP_SPACE) {
                GlmDepthClipSpace.ZERO_TO_ONE -> perspectiveFovRhZo(fov, width, height, near, far, res)
                else -> perspectiveFovRhNo(fov, width, height, near, far, res)
            }

    /** Builds a right handed perspective projection matrix based on a field of view.
     *  If GLM_DEPTH_CLIP_SPACE is ZERO_TO_ONE, the near and far clip planes correspond to z normalized device coordinates of 0 and +1 respectively. (Direct3D clip volume definition)
     *  Otherwise, the near and far clip planes correspond to z normalized device coordinates of -1 and +1 respectively. (OpenGL clip volume definition)
     *
     *  @param fov Expressed in radians.
     *  @param width Width of the viewport
     *  @param height Height of the viewport
     *  @param near Specifies the distance from the viewer to the near clipping plane (always positive).
     *  @param far Specifies the distance from the viewer to the far clipping plane (always positive).
     *
     *  @see gtc_matrix_transform
     */
    fun perspectiveFovRh(fov: Float, width: Float, height: Float, near: Float, far: Float): Mat4 =
            when (GLM_DEPTH_CLIP_SPACE) {
                GlmDepthClipSpace.ZERO_TO_ONE -> perspectiveFovRhZo(fov, width, height, near, far, Mat4())
                else -> perspectiveFovRhNo(fov, width, height, near, far, Mat4())
            }

    /** Builds a right handed perspective projection matrix based on a field of view.
     *  If GLM_DEPTH_CLIP_SPACE is ZERO_TO_ONE, the near and far clip planes correspond to z normalized device coordinates of 0 and +1 respectively. (Direct3D clip volume definition)
     *  Otherwise, the near and far clip planes correspond to z normalized device coordinates of -1 and +1 respectively. (OpenGL clip volume definition)
     *
     *  @param res the resulting matrix
     *  @param fov Expressed in radians.
     *  @param size viewport dimensions
     *  @param near Specifies the distance from the viewer to the near clipping plane (always positive).
     *  @param far Specifies the distance from the viewer to the far clipping plane (always positive).
     *
     *  @see gtc_matrix_transform
     */
    fun perspectiveFovRh(fov: Float, size: Vec2t<*>, near: Float, far: Float, res: Mat4): Mat4 =
            when (GLM_DEPTH_CLIP_SPACE) {
                GlmDepthClipSpace.ZERO_TO_ONE -> perspectiveFovRhZo(fov, size.x.f, size.y.f, near, far, res)
                else -> perspectiveFovRhNo(fov, size.x.f, size.y.f, near, far, res)
            }

    /** Builds a right handed perspective projection matrix based on a field of view.
     *  If GLM_DEPTH_CLIP_SPACE is ZERO_TO_ONE, the near and far clip planes correspond to z normalized device coordinates of 0 and +1 respectively. (Direct3D clip volume definition)
     *  Otherwise, the near and far clip planes correspond to z normalized device coordinates of -1 and +1 respectively. (OpenGL clip volume definition)
     *
     *  @param fov Expressed in radians.
     *  @param size viewport dimensions
     *  @param near Specifies the distance from the viewer to the near clipping plane (always positive).
     *  @param far Specifies the distance from the viewer to the far clipping plane (always positive).
     *
     *  @see gtc_matrix_transform
     */
    fun perspectiveFovRh(fov: Float, size: Vec2t<*>, near: Float, far: Float): Mat4 =
            when (GLM_DEPTH_CLIP_SPACE) {
                GlmDepthClipSpace.ZERO_TO_ONE -> perspectiveFovRhZo(fov, size.x.f, size.y.f, near, far, Mat4())
                else -> perspectiveFovRhNo(fov, size.x.f, size.y.f, near, far, Mat4())
            }

    /** Builds a left handed perspective projection matrix based on a field of view.
     *  If GLM_DEPTH_CLIP_SPACE is ZERO_TO_ONE, the near and far clip planes correspond to z normalized device coordinates of 0 and +1 respectively. (Direct3D clip volume definition)
     *  Otherwise, the near and far clip planes correspond to z normalized device coordinates of -1 and +1 respectively. (OpenGL clip volume definition)
     *
     *  @param res the resulting matrix
     *  @param fov Expressed in radians.
     *  @param width Width of the viewport
     *  @param height Height of the viewport
     *  @param near Specifies the distance from the viewer to the near clipping plane (always positive).
     *  @param far Specifies the distance from the viewer to the far clipping plane (always positive).
     *
     *  @see gtc_matrix_transform
     */
    fun perspectiveFovLh(fov: Float, width: Float, height: Float, near: Float, far: Float, res: Mat4): Mat4 =
            when (GLM_DEPTH_CLIP_SPACE) {
                GlmDepthClipSpace.ZERO_TO_ONE -> perspectiveFovLhZo(fov, width, height, near, far, res)
                else -> perspectiveFovLhNo(fov, width, height, near, far, res)
            }

    /** Builds a left handed perspective projection matrix based on a field of view.
     *  If GLM_DEPTH_CLIP_SPACE is ZERO_TO_ONE, the near and far clip planes correspond to z normalized device coordinates of 0 and +1 respectively. (Direct3D clip volume definition)
     *  Otherwise, the near and far clip planes correspond to z normalized device coordinates of -1 and +1 respectively. (OpenGL clip volume definition)
     *
     *  @param fov Expressed in radians.
     *  @param width Width of the viewport
     *  @param height Height of the viewport
     *  @param near Specifies the distance from the viewer to the near clipping plane (always positive).
     *  @param far Specifies the distance from the viewer to the far clipping plane (always positive).
     *
     *  @see gtc_matrix_transform
     */
    fun perspectiveFovLh(fov: Float, width: Float, height: Float, near: Float, far: Float): Mat4 = when (GLM_DEPTH_CLIP_SPACE) {
        GlmDepthClipSpace.ZERO_TO_ONE -> perspectiveFovLhZo(fov, width, height, near, far, Mat4())
        else -> perspectiveFovLhNo(fov, width, height, near, far, Mat4())
    }

    /** Builds a left handed perspective projection matrix based on a field of view.
     *  If GLM_DEPTH_CLIP_SPACE is ZERO_TO_ONE, the near and far clip planes correspond to z normalized device coordinates of 0 and +1 respectively. (Direct3D clip volume definition)
     *  Otherwise, the near and far clip planes correspond to z normalized device coordinates of -1 and +1 respectively. (OpenGL clip volume definition)
     *
     *  @param res the resulting matrix
     *  @param fov Expressed in radians.
     *  @param size viewport dimensions
     *  @param near Specifies the distance from the viewer to the near clipping plane (always positive).
     *  @param far Specifies the distance from the viewer to the far clipping plane (always positive).
     *
     *  @see gtc_matrix_transform
     */
    fun perspectiveFovLh(fov: Float, size: Vec2t<*>, near: Float, far: Float, res: Mat4): Mat4 =
            when (GLM_DEPTH_CLIP_SPACE) {
                GlmDepthClipSpace.ZERO_TO_ONE -> perspectiveFovLhZo(fov, size.x.f, size.y.f, near, far, res)
                else -> perspectiveFovLhNo(fov, size.x.f, size.y.f, near, far, res)
            }

    /** Builds a left handed perspective projection matrix based on a field of view.
     *  If GLM_DEPTH_CLIP_SPACE is ZERO_TO_ONE, the near and far clip planes correspond to z normalized device coordinates of 0 and +1 respectively. (Direct3D clip volume definition)
     *  Otherwise, the near and far clip planes correspond to z normalized device coordinates of -1 and +1 respectively. (OpenGL clip volume definition)
     *
     *  @param fov Expressed in radians.
     *  @param size viewport dimensions
     *  @param near Specifies the distance from the viewer to the near clipping plane (always positive).
     *  @param far Specifies the distance from the viewer to the far clipping plane (always positive).
     *
     *  @see gtc_matrix_transform
     */
    fun perspectiveFovLh(fov: Float, size: Vec2t<*>, near: Float, far: Float): Mat4 =
            when (GLM_DEPTH_CLIP_SPACE) {
                GlmDepthClipSpace.ZERO_TO_ONE -> perspectiveFovLhZo(fov, size.x.f, size.y.f, near, far, Mat4())
                else -> perspectiveFovLhNo(fov, size.x.f, size.y.f, near, far, Mat4())
            }

    /** Builds a perspective projection matrix based on a field of view and the default handedness and default near and far clip planes definition.
     *  To change default handedness use LEFT_HANDED. To change default near and far clip planes definition use ZERO_TO_ONE.
     *
     *  @param res the resulting matrix
     *  @param fov Expressed in radians.
     *  @param width Width of the viewport
     *  @param height Height of the viewport
     *  @param near Specifies the distance from the viewer to the near clipping plane (always positive).
     *  @param far Specifies the distance from the viewer to the far clipping plane (always positive).
     *
     *  @see gtc_matrix_transform
     */
    fun perspectiveFov(fov: Float, width: Float, height: Float, near: Float, far: Float, res: Mat4): Mat4 =
            when (GLM_COORDINATE_SYSTEM) {
                GlmCoordinateSystem.LEFT_HANDED -> when (GLM_DEPTH_CLIP_SPACE) {
                    GlmDepthClipSpace.ZERO_TO_ONE -> perspectiveFovLhZo(fov, width, height, near, far, res)
                    else -> perspectiveFovLhNo(fov, width, height, near, far, res)
                }
                else -> when (GLM_DEPTH_CLIP_SPACE) {
                    GlmDepthClipSpace.ZERO_TO_ONE -> perspectiveFovRhZo(fov, width, height, near, far, res)
                    else -> perspectiveFovRhNo(fov, width, height, near, far, res)
                }
            }

    /** Builds a perspective projection matrix based on a field of view and the default handedness and default near and far clip planes definition.
     *  To change default handedness use LEFT_HANDED. To change default near and far clip planes definition use ZERO_TO_ONE.
     *
     *  @param fov Expressed in radians.
     *  @param width Width of the viewport
     *  @param height Height of the viewport
     *  @param near Specifies the distance from the viewer to the near clipping plane (always positive).
     *  @param far Specifies the distance from the viewer to the far clipping plane (always positive).
     *
     *  @see gtc_matrix_transform
     */
    fun perspectiveFov(fov: Float, width: Float, height: Float, near: Float, far: Float): Mat4 =
            when (GLM_COORDINATE_SYSTEM) {
                GlmCoordinateSystem.LEFT_HANDED -> when (GLM_DEPTH_CLIP_SPACE) {
                    GlmDepthClipSpace.ZERO_TO_ONE -> perspectiveFovLhZo(fov, width, height, near, far, Mat4())
                    else -> perspectiveFovLhNo(fov, width, height, near, far, Mat4())
                }
                else -> when (GLM_DEPTH_CLIP_SPACE) {
                    GlmDepthClipSpace.ZERO_TO_ONE -> perspectiveFovRhZo(fov, width, height, near, far, Mat4())
                    else -> perspectiveFovRhNo(fov, width, height, near, far, Mat4())
                }
            }

    /** Builds a perspective projection matrix based on a field of view and the default handedness and default near and far clip planes definition.
     *  To change default handedness use LEFT_HANDED. To change default near and far clip planes definition use ZERO_TO_ONE.
     *
     *  @param res the resulting matrix
     *  @param fov Expressed in radians.
     *  @param size viewport dimensions
     *  @param near Specifies the distance from the viewer to the near clipping plane (always positive).
     *  @param far Specifies the distance from the viewer to the far clipping plane (always positive).
     *
     *  @see gtc_matrix_transform
     */
    fun perspectiveFov(fov: Float, size: Vec2t<*>, near: Float, far: Float, res: Mat4): Mat4 =
            when (GLM_COORDINATE_SYSTEM) {
                GlmCoordinateSystem.LEFT_HANDED -> when (GLM_DEPTH_CLIP_SPACE) {
                    GlmDepthClipSpace.ZERO_TO_ONE -> perspectiveFovLhZo(fov, size.x.f, size.y.f, near, far, res)
                    else -> perspectiveFovLhNo(fov, size.x.f, size.y.f, near, far, res)
                }
                else -> when (GLM_DEPTH_CLIP_SPACE) {
                    GlmDepthClipSpace.ZERO_TO_ONE -> perspectiveFovRhZo(fov, size.x.f, size.y.f, near, far, res)
                    else -> perspectiveFovRhNo(fov, size.x.f, size.y.f, near, far, res)
                }
            }

    /** Builds a perspective projection matrix based on a field of view and the default handedness and default near and far clip planes definition.
     *  To change default handedness use LEFT_HANDED. To change default near and far clip planes definition use ZERO_TO_ONE.
     *
     *  @param fov Expressed in radians.
     *  @param size viewport dimensions
     *  @param near Specifies the distance from the viewer to the near clipping plane (always positive).
     *  @param far Specifies the distance from the viewer to the far clipping plane (always positive).
     *
     *  @see gtc_matrix_transform
     */
    fun perspectiveFov(fov: Float, size: Vec2t<*>, near: Float, far: Float): Mat4 =
            when (GLM_COORDINATE_SYSTEM) {
                GlmCoordinateSystem.LEFT_HANDED -> when (GLM_DEPTH_CLIP_SPACE) {
                    GlmDepthClipSpace.ZERO_TO_ONE -> perspectiveFovLhZo(fov, size.x.f, size.y.f, near, far, Mat4())
                    else -> perspectiveFovLhNo(fov, size.x.f, size.y.f, near, far, Mat4())
                }
                else -> when (GLM_DEPTH_CLIP_SPACE) {
                    GlmDepthClipSpace.ZERO_TO_ONE -> perspectiveFovRhZo(fov, size.x.f, size.y.f, near, far, Mat4())
                    else -> perspectiveFovRhNo(fov, size.x.f, size.y.f, near, far, Mat4())
                }
            }

    /** Creates a matrix for a left handed, symmetric perspective-view frustum with far plane at infinite.
     *
     * @param res the resulting matrix
     * @param fovY Specifies the field of view angle, in degrees, in the y direction. Expressed in radians.
     * @param aspect Specifies the aspect ratio that determines the field of view in the x direction. The aspect ratio is the ratio of x (width) to y (height).
     * @param near Specifies the distance from the viewer to the near clipping plane (always positive).
     *
     * @see gtc_matrix_transform
     */
    fun infinitePerspectiveLh(fovY: Float, aspect: Float, near: Float, res: Mat4): Mat4 {

        val range = tan(fovY / 2f) * near
        val left = -range * aspect
        val right = range * aspect
        val bottom = -range
        val top = range

        res to 0f
        res[0, 0] = (2f * near) / (right - left)
        res[1, 1] = (2f * near) / (top - bottom)
        res[2, 2] = 1f
        res[2, 3] = 1f
        res[3, 2] = -2f * near
        return res
    }

    /** Creates a matrix for a left handed, symmetric perspective-view frustum with far plane at infinite.
     *
     * @param fovY Specifies the field of view angle, in degrees, in the y direction. Expressed in radians.
     * @param aspect Specifies the aspect ratio that determines the field of view in the x direction. The aspect ratio is the ratio of x (width) to y (height).
     * @param near Specifies the distance from the viewer to the near clipping plane (always positive).
     *
     * @see gtc_matrix_transform
     */
    fun infinitePerspectiveLh(fovY: Float, aspect: Float, near: Float): Mat4 =
            infinitePerspectiveLh(fovY, aspect, near, Mat4())

    /** Creates a matrix for a right handed, symmetric perspective-view frustum with far plane at infinite.
     *
     *  @param res the resulting matrix
     *  @param fovY Specifies the field of view angle, in degrees, in the y direction. Expressed in radians.
     *  @param aspect Specifies the aspect ratio that determines the field of view in the x direction. The aspect ratio is the ratio of x (width) to y (height).
     *  @param near Specifies the distance from the viewer to the near clipping plane (always positive).
     *
     *  @see gtc_matrix_transform
     */
    fun infinitePerspectiveRh(fovY: Float, aspect: Float, near: Float, res: Mat4): Mat4 {

        val range = tan(fovY / 2f) * near
        val left = -range * aspect
        val right = range * aspect
        val bottom = -range
        val top = range

        res put 0f
        res[0, 0] = (2f * near) / (right - left)
        res[1, 1] = (2f * near) / (top - bottom)
        res[2, 2] = -1f
        res[2, 3] = -1f
        res[3, 2] = -2f * near
        return res
    }

    /** Creates a matrix for a right handed, symmetric perspective-view frustum with far plane at infinite.
     *
     *  @param fovY Specifies the field of view angle, in degrees, in the y direction. Expressed in radians.
     *  @param aspect Specifies the aspect ratio that determines the field of view in the x direction. The aspect ratio is the ratio of x (width) to y (height).
     *  @param near Specifies the distance from the viewer to the near clipping plane (always positive).
     *
     *  @see gtc_matrix_transform
     */
    fun infinitePerspectiveRh(fovY: Float, aspect: Float, near: Float): Mat4 =
            infinitePerspectiveRh(fovY, aspect, near, Mat4())

    /** Creates a matrix for a symmetric perspective-view frustum with far plane at infinite with default handedness.
     *
     *  @param res the resulting matrix
     *  @param fovY Specifies the field of view angle, in degrees, in the y direction. Expressed in radians.
     *  @param aspect Specifies the aspect ratio that determines the field of view in the x direction. The aspect ratio is the ratio of x (width) to y (height).
     *  @param near Specifies the distance from the viewer to the near clipping plane (always positive).
     *
     *  @see gtc_matrix_transform
     */
    fun infinitePerspective(fovY: Float, aspect: Float, near: Float, res: Mat4): Mat4 =
            when (GLM_COORDINATE_SYSTEM) {
                GlmCoordinateSystem.LEFT_HANDED -> infinitePerspectiveLh(fovY, aspect, near, res)
                else -> infinitePerspectiveRh(fovY, aspect, near, res)
            }

    /** Creates a matrix for a symmetric perspective-view frustum with far plane at infinite with default handedness.
     *
     *  @param res the resulting matrix
     *  @param fovY Specifies the field of view angle, in degrees, in the y direction. Expressed in radians.
     *  @param aspect Specifies the aspect ratio that determines the field of view in the x direction. The aspect ratio is the ratio of x (width) to y (height).
     *  @param near Specifies the distance from the viewer to the near clipping plane (always positive).
     *
     *  @see gtc_matrix_transform
     */
    fun infinitePerspective(fovY: Float, aspect: Float, near: Float): Mat4 =
            when (GLM_COORDINATE_SYSTEM) {
                GlmCoordinateSystem.LEFT_HANDED -> infinitePerspectiveLh(fovY, aspect, near, Mat4())
                else -> infinitePerspectiveRh(fovY, aspect, near, Mat4())
            }

    /** Creates a matrix for a symmetric perspective-view frustum with far plane at infinite for graphics hardware that doesn't support depth clamping.
     *
     *  Infinite projection matrix: http://www.terathon.com/gdc07_lengyel.pdf
     *
     *  @param res the resulting matrix
     *  @param fovY Specifies the field of view angle, in degrees, in the y direction. Expressed in radians.
     *  param aspect Specifies the aspect ratio that determines the field of view in the x direction. The aspect ratio is the ratio of x (width) to y (height).
     *  @param near Specifies the distance from the viewer to the near clipping plane (always positive).
     *
     *  @see gtc_matrix_transform
     */
    fun tweakedInfinitePerspective(fovY: Float, aspect: Float, near: Float, res: Mat4): Mat4 =
            tweakedInfinitePerspective(fovY, aspect, near, glm.epsilonF, res)

    /** Creates a matrix for a symmetric perspective-view frustum with far plane at infinite for graphics hardware that doesn't support depth clamping.
     *
     *  @param res the resulting matrix
     *  @param fovY Specifies the field of view angle, in degrees, in the y direction. Expressed in radians.
     *  @param aspect Specifies the aspect ratio that determines the field of view in the x direction. The aspect ratio is the ratio of x (width) to y (height).
     *  @param near Specifies the distance from the viewer to the near clipping plane (always positive).
     *  @param ep Epsilon
     *
     *  @see gtc_matrix_transform
     */
    fun tweakedInfinitePerspective(fovY: Float, aspect: Float, near: Float, ep: Float, res: Mat4): Mat4 {

        val range = tan(fovY / 2f) * near
        val left = -range * aspect
        val right = range * aspect
        val bottom = -range
        val top = range

        res put 0f
        res[0][0] = (2f * near) / (right - left)
        res[1][1] = (2f * near) / (top - bottom)
        res[2][2] = ep - 1f
        res[2][3] = -1f
        res[3][2] = (ep - 2f) * near
        return res
    }

    /** Creates a matrix for a symmetric perspective-view frustum with far plane at infinite for graphics hardware that doesn't support depth clamping.
     *
     *  Infinite projection matrix: http://www.terathon.com/gdc07_lengyel.pdf
     *
     *  @param fovY Specifies the field of view angle, in degrees, in the y direction. Expressed in radians.
     *  param aspect Specifies the aspect ratio that determines the field of view in the x direction. The aspect ratio is the ratio of x (width) to y (height).
     *  @param near Specifies the distance from the viewer to the near clipping plane (always positive).
     *
     *  @see gtc_matrix_transform
     */
    fun tweakedInfinitePerspective(fovY: Float, aspect: Float, near: Float): Mat4 =
            tweakedInfinitePerspective(fovY, aspect, near, glm.epsilonF, Mat4())

    /** Creates a matrix for a symmetric perspective-view frustum with far plane at infinite for graphics hardware that doesn't support depth clamping.
     *
     *  @param res the resulting matrix
     *  @param fovY Specifies the field of view angle, in degrees, in the y direction. Expressed in radians.
     *  @param aspect Specifies the aspect ratio that determines the field of view in the x direction. The aspect ratio is the ratio of x (width) to y (height).
     *  @param near Specifies the distance from the viewer to the near clipping plane (always positive).
     *  @param ep Epsilon
     *
     *  @see gtc_matrix_transform
     */
    fun tweakedInfinitePerspective(fovY: Float, aspect: Float, near: Float, ep: Float): Mat4 =
            tweakedInfinitePerspective(fovY, aspect, near, ep, Mat4())


    // -----------------------------------------------------------------------------------------------------------------
    // Mat4d version
    // -----------------------------------------------------------------------------------------------------------------


    /** Creates a matrix for a right handed, symetric perspective-view frustum.
     *  The near and far clip planes correspond to z normalized device coordinates of 0 and +1 respectively. (Direct3D clip volume definition)
     *
     *  @param res the resulting matrix
     *  @param fovY Specifies the field of view angle, in degrees, in the y direction. Expressed in radians.
     *  @param aspect Specifies the aspect ratio that determines the field of view in the x direction. The aspect ratio is the ratio of x (width) to y (height).
     *  @param near Specifies the distance from the viewer to the near clipping plane (always positive).
     *  @param far Specifies the distance from the viewer to the far clipping plane (always positive).
     *
     *  @see gtc_matrix_transform
     */
    fun perspectiveRhZo(fovY: Double, aspect: Double, near: Double, far: Double, res: Mat4d): Mat4d {

        assert(abs(aspect - Double.MIN_VALUE) > 0.0)

        val tanHalfFovY = tan(fovY / 2.0)

        res put 0.0
        res[0, 0] = 1.0 / (aspect * tanHalfFovY)
        res[1, 1] = 1.0 / (tanHalfFovY)
        res[2, 2] = far / (near - far)
        res[2, 3] = -1.0
        res[3, 2] = -(far * near) / (far - near)
        return res
    }

    /** Creates a matrix for a right handed, symetric perspective-view frustum.
     *  The near and far clip planes correspond to z normalized device coordinates of 0 and +1 respectively. (Direct3D clip volume definition)
     *
     *  @param fovY Specifies the field of view angle, in degrees, in the y direction. Expressed in radians.
     *  @param aspect Specifies the aspect ratio that determines the field of view in the x direction. The aspect ratio is the ratio of x (width) to y (height).
     *  @param near Specifies the distance from the viewer to the near clipping plane (always positive).
     *  @param far Specifies the distance from the viewer to the far clipping plane (always positive).
     *
     *  @see gtc_matrix_transform
     */
    fun perspectiveRhZo(fovY: Double, aspect: Double, near: Double, far: Double): Mat4d =
            perspectiveRhZo(fovY, aspect, near, far, Mat4d())

    /** Creates a matrix for a right handed, symetric perspective-view frustum.
     *  The near and far clip planes correspond to z normalized device coordinates of -1 and +1 respectively. (OpenGL clip volume definition)
     *
     *  @param res the resulting matrix
     *  @param fovY Specifies the field of view angle, in degrees, in the y direction. Expressed in radians.
     *  @param aspect Specifies the aspect ratio that determines the field of view in the x direction. The aspect ratio is the ratio of x (width) to y (height).
     *  @param near Specifies the distance from the viewer to the near clipping plane (always positive).
     *  @param far Specifies the distance from the viewer to the far clipping plane (always positive).
     *
     *  @see gtc_matrix_transform
     */
    fun perspectiveRhNo(fovY: Double, aspect: Double, near: Double, far: Double, res: Mat4d): Mat4d {

        assert(abs(aspect - Double.MIN_VALUE) > 0.0)

        val tanHalfFovy = tan(fovY / 2.0)

        res put 0.0
        res[0, 0] = 1.0 / (aspect * tanHalfFovy)
        res[1, 1] = 1.0 / (tanHalfFovy)
        res[2, 2] = -(far + near) / (far - near)
        res[2, 3] = -1.0
        res[3, 2] = -(2.0 * far * near) / (far - near)
        return res
    }

    /** Creates a matrix for a right handed, symetric perspective-view frustum.
     *  The near and far clip planes correspond to z normalized device coordinates of -1 and +1 respectively. (OpenGL clip volume definition)
     *
     *  @param fovY Specifies the field of view angle, in degrees, in the y direction. Expressed in radians.
     *  @param aspect Specifies the aspect ratio that determines the field of view in the x direction. The aspect ratio is the ratio of x (width) to y (height).
     *  @param near Specifies the distance from the viewer to the near clipping plane (always positive).
     *  @param far Specifies the distance from the viewer to the far clipping plane (always positive).
     *
     *  @see gtc_matrix_transform
     */
    fun perspectiveRhNo(fovY: Double, aspect: Double, near: Double, far: Double): Mat4d =
            perspectiveRhNo(fovY, aspect, near, far, Mat4d())

    /** Creates a matrix for a left handed, symetric perspective-view frustum.
     *  The near and far clip planes correspond to z normalized device coordinates of 0 and +1 respectively. (Direct3D clip volume definition)
     *
     *  @param res the resulting matrix
     *  @param fovY Specifies the field of view angle, in degrees, in the y direction. Expressed in radians.
     *  @param aspect Specifies the aspect ratio that determines the field of view in the x direction. The aspect ratio is the ratio of x (width) to y (height).
     *  @param near Specifies the distance from the viewer to the near clipping plane (always positive).
     *  @param far Specifies the distance from the viewer to the far clipping plane (always positive).
     *
     *  @see gtc_matrix_transform
     */
    fun perspectiveLhZo(fovY: Double, aspect: Double, near: Double, far: Double, res: Mat4d): Mat4d {

        assert(abs(aspect - Double.MIN_VALUE) > 0.0)

        val tanHalfFovy = tan(fovY / 2.0)

        res put 0.0
        res[0, 0] = 1.0 / (aspect * tanHalfFovy)
        res[1, 1] = 1.0 / (tanHalfFovy)
        res[2, 2] = far / (far - near)
        res[2, 3] = 1.0
        res[3, 2] = -(far * near) / (far - near)
        return res
    }

    /** Creates a matrix for a left handed, symetric perspective-view frustum.
     *  The near and far clip planes correspond to z normalized device coordinates of 0 and +1 respectively. (Direct3D clip volume definition)
     *
     *  @param fovY Specifies the field of view angle, in degrees, in the y direction. Expressed in radians.
     *  @param aspect Specifies the aspect ratio that determines the field of view in the x direction. The aspect ratio is the ratio of x (width) to y (height).
     *  @param near Specifies the distance from the viewer to the near clipping plane (always positive).
     *  @param far Specifies the distance from the viewer to the far clipping plane (always positive).
     *
     *  @see gtc_matrix_transform
     */
    fun perspectiveLhZo(fovY: Double, aspect: Double, near: Double, far: Double): Mat4d =
            perspectiveLhZo(fovY, aspect, near, far, Mat4d())

    /** Creates a matrix for a left handed, symetric perspective-view frustum.
     *  The near and far clip planes correspond to z normalized device coordinates of -1 and +1 respectively. (OpenGL clip volume definition)
     *
     * @param res the resulting matrix
     *  @param fovY Specifies the field of view angle, in degrees, in the y direction. Expressed in radians.
     *  @param aspect Specifies the aspect ratio that determines the field of view in the x direction. The aspect ratio is the ratio of x (width) to y (height).
     *  @param near Specifies the distance from the viewer to the near clipping plane (always positive).
     *  @param far Specifies the distance from the viewer to the far clipping plane (always positive).
     *
     *  @see gtc_matrix_transform
     */
    fun perspectiveLhNo(fovY: Double, aspect: Double, near: Double, far: Double, res: Mat4d): Mat4d {

        assert(abs(aspect - Double.MIN_VALUE) > 0.0)

        val tanHalfFovy = tan(fovY / 2.0)

        res put 0.0
        res[0, 0] = 1.0 / (aspect * tanHalfFovy)
        res[1, 1] = 1.0 / (tanHalfFovy)
        res[2, 2] = (far + near) / (far - near)
        res[2, 3] = 1.0
        res[3, 2] = -(2.0 * far * near) / (far - near)
        return res
    }

    /** Creates a matrix for a left handed, symetric perspective-view frustum.
     *  The near and far clip planes correspond to z normalized device coordinates of -1 and +1 respectively. (OpenGL clip volume definition)
     *
     *  @param fovY Specifies the field of view angle, in degrees, in the y direction. Expressed in radians.
     *  @param aspect Specifies the aspect ratio that determines the field of view in the x direction. The aspect ratio is the ratio of x (width) to y (height).
     *  @param near Specifies the distance from the viewer to the near clipping plane (always positive).
     *  @param far Specifies the distance from the viewer to the far clipping plane (always positive).
     *
     *  @see gtc_matrix_transform
     */
    fun perspectiveLhNo(fovY: Double, aspect: Double, near: Double, far: Double): Mat4d =
            perspectiveLhNo(fovY, aspect, near, far, Mat4d())

    /** Creates a matrix for a symetric perspective-view frustum using left-handed coordinates if GLM_COORDINATE_SYSTEM is LEFT_HANDED or right-handed coordinates otherwise.
     *  The near and far clip planes correspond to z normalized device coordinates of 0 and +1 respectively. (Direct3D clip volume definition)
     *
     *  @param res the resulting matrix
     *  @param fovY Specifies the field of view angle, in degrees, in the y direction. Expressed in radians.
     *  @param aspect Specifies the aspect ratio that determines the field of view in the x direction. The aspect ratio is the ratio of x (width) to y (height).
     *  @param near Specifies the distance from the viewer to the near clipping plane (always positive).
     *  @param far Specifies the distance from the viewer to the far clipping plane (always positive).
     *
     *  @see gtc_matrix_transform
     */
    fun perspectiveZo(fovY: Double, aspect: Double, near: Double, far: Double, res: Mat4d): Mat4d =
            when (GLM_COORDINATE_SYSTEM) {
                GlmCoordinateSystem.LEFT_HANDED -> perspectiveLhZo(fovY, aspect, near, far, res)
                else -> perspectiveRhZo(fovY, aspect, near, far, res)
            }

    /** Creates a matrix for a symetric perspective-view frustum using left-handed coordinates if GLM_COORDINATE_SYSTEM is LEFT_HANDED or right-handed coordinates otherwise.
     *  The near and far clip planes correspond to z normalized device coordinates of 0 and +1 respectively. (Direct3D clip volume definition)
     *
     *  @param fovY Specifies the field of view angle, in degrees, in the y direction. Expressed in radians.
     *  @param aspect Specifies the aspect ratio that determines the field of view in the x direction. The aspect ratio is the ratio of x (width) to y (height).
     *  @param near Specifies the distance from the viewer to the near clipping plane (always positive).
     *  @param far Specifies the distance from the viewer to the far clipping plane (always positive).
     *
     *  @see gtc_matrix_transform
     */
    fun perspectiveZo(fovY: Double, aspect: Double, near: Double, far: Double): Mat4d =
            when (GLM_COORDINATE_SYSTEM) {
                GlmCoordinateSystem.LEFT_HANDED -> perspectiveLhZo(fovY, aspect, near, far, Mat4d())
                else -> perspectiveRhZo(fovY, aspect, near, far, Mat4d())
            }

    /** Creates a matrix for a symetric perspective-view frustum using left-handed coordinates if GLM_COORDINATE_SYSTEM is LEFT_HANDED or right-handed coordinates otherwise.
     *  The near and far clip planes correspond to z normalized device coordinates of -1 and +1 respectively. (OpenGL clip volume definition)
     *
     *  @param res the resulting matrix
     *  @param fovY Specifies the field of view angle, in degrees, in the y direction. Expressed in radians.
     *  @param aspect Specifies the aspect ratio that determines the field of view in the x direction. The aspect ratio is the ratio of x (width) to y (height).
     *  @param near Specifies the distance from the viewer to the near clipping plane (always positive).
     *  @param far Specifies the distance from the viewer to the far clipping plane (always positive).
     *
     *  @see gtc_matrix_transform
     */
    fun perspectiveNo(fovY: Double, aspect: Double, near: Double, far: Double, res: Mat4d): Mat4d =
            when (GLM_COORDINATE_SYSTEM) {
                GlmCoordinateSystem.LEFT_HANDED -> perspectiveLhNo(fovY, aspect, near, far, res)
                else -> perspectiveRhNo(fovY, aspect, near, far, res)
            }

    /** Creates a matrix for a symetric perspective-view frustum using left-handed coordinates if GLM_COORDINATE_SYSTEM is LEFT_HANDED or right-handed coordinates otherwise.
     *  The near and far clip planes correspond to z normalized device coordinates of -1 and +1 respectively. (OpenGL clip volume definition)
     *
     *  @param fovY Specifies the field of view angle, in degrees, in the y direction. Expressed in radians.
     *  @param aspect Specifies the aspect ratio that determines the field of view in the x direction. The aspect ratio is the ratio of x (width) to y (height).
     *  @param near Specifies the distance from the viewer to the near clipping plane (always positive).
     *  @param far Specifies the distance from the viewer to the far clipping plane (always positive).
     *
     *  @see gtc_matrix_transform
     */
    fun perspectiveNo(fovY: Double, aspect: Double, near: Double, far: Double): Mat4d =
            when (GLM_COORDINATE_SYSTEM) {
                GlmCoordinateSystem.LEFT_HANDED -> perspectiveLhNo(fovY, aspect, near, far, Mat4d())
                else -> perspectiveRhNo(fovY, aspect, near, far, Mat4d())
            }

    /** Creates a matrix for a right handed, symetric perspective-view frustum.
     *  If GLM_DEPTH_CLIP_SPACE is ZERO_TO_ONE, the near and far clip planes correspond to z normalized device coordinates of 0 and +1 respectively. (Direct3D clip volume definition)
     *  Otherwise, the near and far clip planes correspond to z normalized device coordinates of -1 and +1 respectively. (OpenGL clip volume definition)
     *
     *  @param res the resulting matrix
     *  @param fovY Specifies the field of view angle, in degrees, in the y direction. Expressed in radians.
     *  @param aspect Specifies the aspect ratio that determines the field of view in the x direction. The aspect ratio is the ratio of x (width) to y (height).
     *  @param near Specifies the distance from the viewer to the near clipping plane (always positive).
     *  @param far Specifies the distance from the viewer to the far clipping plane (always positive).
     *
     *  @see gtc_matrix_transform
     */
    fun perspectiveRh(fovY: Double, aspect: Double, near: Double, far: Double, res: Mat4d): Mat4d =
            when (GLM_DEPTH_CLIP_SPACE) {
                GlmDepthClipSpace.ZERO_TO_ONE -> perspectiveRhZo(fovY, aspect, near, far, res)
                else -> perspectiveRhNo(fovY, aspect, near, far, res)
            }

    /** Creates a matrix for a right handed, symetric perspective-view frustum.
     *  If GLM_DEPTH_CLIP_SPACE is ZERO_TO_ONE, the near and far clip planes correspond to z normalized device coordinates of 0 and +1 respectively. (Direct3D clip volume definition)
     *  Otherwise, the near and far clip planes correspond to z normalized device coordinates of -1 and +1 respectively. (OpenGL clip volume definition)
     *
     *  @param fovY Specifies the field of view angle, in degrees, in the y direction. Expressed in radians.
     *  @param aspect Specifies the aspect ratio that determines the field of view in the x direction. The aspect ratio is the ratio of x (width) to y (height).
     *  @param near Specifies the distance from the viewer to the near clipping plane (always positive).
     *  @param far Specifies the distance from the viewer to the far clipping plane (always positive).
     *
     *  @see gtc_matrix_transform
     */
    fun perspectiveRh(fovY: Double, aspect: Double, near: Double, far: Double): Mat4d =
            when (GLM_DEPTH_CLIP_SPACE) {
                GlmDepthClipSpace.ZERO_TO_ONE -> perspectiveRhZo(fovY, aspect, near, far, Mat4d())
                else -> perspectiveRhNo(fovY, aspect, near, far, Mat4d())
            }

    /** Creates a matrix for a left handed, symetric perspective-view frustum.
     *  If GLM_DEPTH_CLIP_SPACE is ZERO_TO_ONE, the near and far clip planes correspond to z normalized device coordinates of 0 and +1 respectively. (Direct3D clip volume definition)
     *  Otherwise, the near and far clip planes correspond to z normalized device coordinates of -1 and +1 respectively. (OpenGL clip volume definition)
     *
     *  @param res the resulting matrix
     *  @param fovY Specifies the field of view angle, in degrees, in the y direction. Expressed in radians.
     *  @param aspect Specifies the aspect ratio that determines the field of view in the x direction. The aspect ratio is the ratio of x (width) to y (height).
     *  @param near Specifies the distance from the viewer to the near clipping plane (always positive).
     *  @param far Specifies the distance from the viewer to the far clipping plane (always positive).
     *
     *  @see gtc_matrix_transform
     */
    fun perspectiveLh(fovY: Double, aspect: Double, near: Double, far: Double, res: Mat4d): Mat4d =
            when (GLM_DEPTH_CLIP_SPACE) {
                GlmDepthClipSpace.ZERO_TO_ONE -> perspectiveLhZo(fovY, aspect, near, far, res)
                else -> perspectiveLhNo(fovY, aspect, near, far, res)
            }

    /** Creates a matrix for a left handed, symetric perspective-view frustum.
     *  If GLM_DEPTH_CLIP_SPACE is ZERO_TO_ONE, the near and far clip planes correspond to z normalized device coordinates of 0 and +1 respectively. (Direct3D clip volume definition)
     *  Otherwise, the near and far clip planes correspond to z normalized device coordinates of -1 and +1 respectively. (OpenGL clip volume definition)
     *
     *  @param fovY Specifies the field of view angle, in degrees, in the y direction. Expressed in radians.
     *  @param aspect Specifies the aspect ratio that determines the field of view in the x direction. The aspect ratio is the ratio of x (width) to y (height).
     *  @param near Specifies the distance from the viewer to the near clipping plane (always positive).
     *  @param far Specifies the distance from the viewer to the far clipping plane (always positive).
     *
     *  @see gtc_matrix_transform
     */
    fun perspectiveLh(fovY: Double, aspect: Double, near: Double, far: Double): Mat4d =
            when (GLM_DEPTH_CLIP_SPACE) {
                GlmDepthClipSpace.ZERO_TO_ONE -> perspectiveLhZo(fovY, aspect, near, far, Mat4d())
                else -> perspectiveLhNo(fovY, aspect, near, far, Mat4d())
            }

    /** Creates a matrix for a symetric perspective-view frustum based on the default handedness and default near and far clip planes definition.
     *  To change default handedness use LEFT_HANDED. To change default near and far clip planes definition use ZERO_TO_ONE.
     *
     *  @param res the resulting matrix
     *  @param fovY Specifies the field of view angle in the y direction. Expressed in radians.
     *  @param aspect Specifies the aspect ratio that determines the field of view in the x direction. The aspect ratio is the ratio of x (width) to y (height).
     *  @param near Specifies the distance from the viewer to the near clipping plane (always positive).
     *  @param far Specifies the distance from the viewer to the far clipping plane (always positive).
     *
     *  @see gtc_matrix_transform
     *  @see <a href="https://www.khronos.org/registry/OpenGL-Refpages/gl2.1/xhtml/gluPerspective.xml">gluPerspective man page</a>
     */
    fun perspective(fovY: Double, aspect: Double, near: Double, far: Double, res: Mat4d): Mat4d =
            when (GLM_COORDINATE_SYSTEM) {
                GlmCoordinateSystem.LEFT_HANDED -> when (GLM_DEPTH_CLIP_SPACE) {
                    GlmDepthClipSpace.ZERO_TO_ONE -> perspectiveLhZo(fovY, aspect, near, far, res)
                    else -> perspectiveLhNo(fovY, aspect, near, far, res)
                }
                else -> when (GLM_DEPTH_CLIP_SPACE) {
                    GlmDepthClipSpace.ZERO_TO_ONE -> perspectiveRhZo(fovY, aspect, near, far, res)
                    else -> perspectiveRhNo(fovY, aspect, near, far, res)
                }
            }

    /** Creates a matrix for a symetric perspective-view frustum based on the default handedness and default near and far clip planes definition.
     *  To change default handedness use LEFT_HANDED. To change default near and far clip planes definition use ZERO_TO_ONE.
     *
     *  @param fovY Specifies the field of view angle in the y direction. Expressed in radians.
     *  @param aspect Specifies the aspect ratio that determines the field of view in the x direction. The aspect ratio is the ratio of x (width) to y (height).
     *  @param near Specifies the distance from the viewer to the near clipping plane (always positive).
     *  @param far Specifies the distance from the viewer to the far clipping plane (always positive).
     *
     *  @see gtc_matrix_transform
     *  @see <a href="https://www.khronos.org/registry/OpenGL-Refpages/gl2.1/xhtml/gluPerspective.xml">gluPerspective man page</a>
     */
    fun perspective(fovY: Double, aspect: Double, near: Double, far: Double): Mat4d =
            when (GLM_COORDINATE_SYSTEM) {
                GlmCoordinateSystem.LEFT_HANDED -> when (GLM_DEPTH_CLIP_SPACE) {
                    GlmDepthClipSpace.ZERO_TO_ONE -> perspectiveLhZo(fovY, aspect, near, far, Mat4d())
                    else -> perspectiveLhNo(fovY, aspect, near, far, Mat4d())
                }
                else -> when (GLM_DEPTH_CLIP_SPACE) {
                    GlmDepthClipSpace.ZERO_TO_ONE -> perspectiveRhZo(fovY, aspect, near, far, Mat4d())
                    else -> perspectiveRhNo(fovY, aspect, near, far, Mat4d())
                }
            }

    /** Builds a perspective projection matrix based on a field of view using right-handed coordinates.
     *  The near and far clip planes correspond to z normalized device coordinates of 0 and +1 respectively. (Direct3D clip volume definition)
     *
     *  @param res the resulting matrix
     *  @param fov Expressed in radians.
     *  @param width Width of the viewport
     *  @param height Height of the viewport
     *  @param near Specifies the distance from the viewer to the near clipping plane (always positive).
     *  @param far Specifies the distance from the viewer to the far clipping plane (always positive).
     *
     *  @see gtc_matrix_transform
     */
    fun perspectiveFovRhZo(fov: Double, width: Double, height: Double, near: Double, far: Double, res: Mat4d): Mat4d {

        assert(width > 0.0 && height > 0.0 && fov > 0.0)

        val h = cos(0.5f * fov) / sin(0.5f * fov)
        val w = h * height / width ///todo max(width , Height) / min(width , Height)?

        res put 0.0
        res[0, 0] = w
        res[1, 1] = h
        res[2, 2] = far / (near - far)
        res[2, 3] = -1.0
        res[3, 2] = -(far * near) / (far - near)
        return res
    }

    /** Builds a perspective projection matrix based on a field of view using right-handed coordinates.
     *  The near and far clip planes correspond to z normalized device coordinates of 0 and +1 respectively. (Direct3D clip volume definition)
     *
     *  @param fov Expressed in radians.
     *  @param width Width of the viewport
     *  @param height Height of the viewport
     *  @param near Specifies the distance from the viewer to the near clipping plane (always positive).
     *  @param far Specifies the distance from the viewer to the far clipping plane (always positive).
     *
     *  @see gtc_matrix_transform
     */
    fun perspectiveFovRhZo(fov: Double, width: Double, height: Double, near: Double, far: Double): Mat4d =
            perspectiveFovRhZo(fov, width, height, near, far, Mat4d())

    /** Builds a perspective projection matrix based on a field of view using right-handed coordinates.
     *  The near and far clip planes correspond to z normalized device coordinates of 0 and +1 respectively. (Direct3D clip volume definition)
     *
     *  @param res the resulting matrix
     *  @param fov Expressed in radians.
     *  @param size viewport dimensions
     *  @param near Specifies the distance from the viewer to the near clipping plane (always positive).
     *  @param far Specifies the distance from the viewer to the far clipping plane (always positive).
     *
     *  @see gtc_matrix_transform
     */
    fun perspectiveFovRhZo(fov: Double, size: Vec2t<*>, near: Double, far: Double, res: Mat4d): Mat4d =
            perspectiveFovRhZo(fov, size.x.d, size.y.d, near, far, res)

    /** Builds a perspective projection matrix based on a field of view using right-handed coordinates.
     *  The near and far clip planes correspond to z normalized device coordinates of 0 and +1 respectively. (Direct3D clip volume definition)
     *
     *  @param fov Expressed in radians.
     *  @param size viewport dimensions
     *  @param near Specifies the distance from the viewer to the near clipping plane (always positive).
     *  @param far Specifies the distance from the viewer to the far clipping plane (always positive).
     *
     *  @see gtc_matrix_transform
     */
    fun perspectiveFovRhZo(fov: Double, size: Vec2t<*>, near: Double, far: Double): Mat4d =
            perspectiveFovRhZo(fov, size.x.d, size.y.d, near, far, Mat4d())

    /** Builds a perspective projection matrix based on a field of view using right-handed coordinates.
     *  The near and far clip planes correspond to z normalized device coordinates of -1 and +1 respectively. (OpenGL clip volume definition)
     *
     *  @param res the resulting matrix
     *  @param fov Expressed in radians.
     *  @param width Width of the viewport
     *  @param height Height of the viewport
     *  @param near Specifies the distance from the viewer to the near clipping plane (always positive).
     *  @param far Specifies the distance from the viewer to the far clipping plane (always positive).
     *
     *  @see gtc_matrix_transform
     */
    fun perspectiveFovRhNo(fov: Double, width: Double, height: Double, near: Double, far: Double, res: Mat4d): Mat4d {

        assert(width > 0.0 && height > 0.0 && fov > 0.0)

        val h = cos(0.5f * fov) / sin(0.5f * fov)
        val w = h * height / width ///todo max(width , Height) / min(width , Height)?

        res put 0.0
        res[0, 0] = w
        res[1, 1] = h
        res[2, 2] = -(far + near) / (far - near)
        res[2, 3] = -1.0
        res[3, 2] = -(2.0 * far * near) / (far - near)
        return res
    }

    /** Builds a perspective projection matrix based on a field of view using right-handed coordinates.
     *  The near and far clip planes correspond to z normalized device coordinates of -1 and +1 respectively. (OpenGL clip volume definition)
     *
     *  @param fov Expressed in radians.
     *  @param width Width of the viewport
     *  @param height Height of the viewport
     *  @param near Specifies the distance from the viewer to the near clipping plane (always positive).
     *  @param far Specifies the distance from the viewer to the far clipping plane (always positive).
     *
     *  @see gtc_matrix_transform
     */
    fun perspectiveFovRhNo(fov: Double, width: Double, height: Double, near: Double, far: Double): Mat4d =
            perspectiveFovRhNo(fov, width, height, near, far, Mat4d())

    /** Builds a perspective projection matrix based on a field of view using right-handed coordinates.
     *  The near and far clip planes correspond to z normalized device coordinates of -1 and +1 respectively. (OpenGL clip volume definition)
     *
     *  @param res the resulting matrix
     *  @param fov Expressed in radians.
     *  @param size viewport dimensions
     *  @param near Specifies the distance from the viewer to the near clipping plane (always positive).
     *  @param far Specifies the distance from the viewer to the far clipping plane (always positive).
     *
     *  @see gtc_matrix_transform
     */
    fun perspectiveFovRhNo(fov: Double, size: Vec2t<*>, near: Double, far: Double, res: Mat4d): Mat4d =
            perspectiveFovRhNo(fov, size.x.d, size.y.d, near, far, res)

    /** Builds a perspective projection matrix based on a field of view using right-handed coordinates.
     *  The near and far clip planes correspond to z normalized device coordinates of -1 and +1 respectively. (OpenGL clip volume definition)
     *
     *  @param fov Expressed in radians.
     *  @param size viewport dimensions
     *  @param near Specifies the distance from the viewer to the near clipping plane (always positive).
     *  @param far Specifies the distance from the viewer to the far clipping plane (always positive).
     *
     *  @see gtc_matrix_transform
     */
    fun perspectiveFovRhNo(fov: Double, size: Vec2t<*>, near: Double, far: Double): Mat4d =
            perspectiveFovRhNo(fov, size.x.d, size.y.d, near, far, Mat4d())

    /** Builds a perspective projection matrix based on a field of view using left-handed coordinates.
     *  The near and far clip planes correspond to z normalized device coordinates of 0 and +1 respectively. (Direct3D clip volume definition)
     *
     *  @param res the resulting matrix
     *  @param fov Expressed in radians.
     *  @param width Width of the viewport
     *  @param height Height of the viewport
     *  @param near Specifies the distance from the viewer to the near clipping plane (always positive).
     *  @param far Specifies the distance from the viewer to the far clipping plane (always positive).
     *
     *  @see gtc_matrix_transform
     */
    fun perspectiveFovLhZo(fov: Double, width: Double, height: Double, near: Double, far: Double, res: Mat4d): Mat4d {

        assert(width > 0.0 && height > 0.0 && fov > 0.0)

        val h = cos(0.5f * fov) / sin(0.5f * fov)
        val w = h * height / width ///todo max(width , Height) / min(width , Height)?

        res put 0.0
        res[0, 0] = w
        res[1, 1] = h
        res[2, 2] = far / (far - near)
        res[2, 3] = 1.0
        res[3, 2] = -(far * near) / (far - near)
        return res
    }

    /** Builds a perspective projection matrix based on a field of view using left-handed coordinates.
     *  The near and far clip planes correspond to z normalized device coordinates of 0 and +1 respectively. (Direct3D clip volume definition)
     *
     *  @param fov Expressed in radians.
     *  @param width Width of the viewport
     *  @param height Height of the viewport
     *  @param near Specifies the distance from the viewer to the near clipping plane (always positive).
     *  @param far Specifies the distance from the viewer to the far clipping plane (always positive).
     *
     *  @see gtc_matrix_transform
     */
    fun perspectiveFovLhZo(fov: Double, width: Double, height: Double, near: Double, far: Double): Mat4d =
            perspectiveFovLhZo(fov, width, height, near, far, Mat4d())

    /** Builds a perspective projection matrix based on a field of view using left-handed coordinates.
     *  The near and far clip planes correspond to z normalized device coordinates of 0 and +1 respectively. (Direct3D clip volume definition)
     *
     *  @param res the resulting matrix
     *  @param fov Expressed in radians.
     *  @param size viewport dimensions
     *  @param near Specifies the distance from the viewer to the near clipping plane (always positive).
     *  @param far Specifies the distance from the viewer to the far clipping plane (always positive).
     *
     *  @see gtc_matrix_transform
     */
    fun perspectiveFovLhZo(fov: Double, size: Vec2t<*>, near: Double, far: Double, res: Mat4d): Mat4d =
            perspectiveFovLhZo(fov, size.x.d, size.y.d, near, far, res)

    /** Builds a perspective projection matrix based on a field of view using left-handed coordinates.
     *  The near and far clip planes correspond to z normalized device coordinates of 0 and +1 respectively. (Direct3D clip volume definition)
     *
     *  @param fov Expressed in radians.
     *  @param size viewport dimensions
     *  @param near Specifies the distance from the viewer to the near clipping plane (always positive).
     *  @param far Specifies the distance from the viewer to the far clipping plane (always positive).
     *
     *  @see gtc_matrix_transform
     */
    fun perspectiveFovLhZo(fov: Double, size: Vec2t<*>, near: Double, far: Double): Mat4d =
            perspectiveFovLhZo(fov, size.x.d, size.y.d, near, far, Mat4d())

    /** Builds a perspective projection matrix based on a field of view using left-handed coordinates.
     *  The near and far clip planes correspond to z normalized device coordinates of -1 and +1 respectively. (OpenGL clip volume definition)
     *
     *  @param res the resulting matrix
     *  @param fov Expressed in radians.
     *  @param width Width of the viewport
     *  @param height Height of the viewport
     *  @param near Specifies the distance from the viewer to the near clipping plane (always positive).
     *  @param far Specifies the distance from the viewer to the far clipping plane (always positive).
     *
     *  @see gtc_matrix_transform
     */
    fun perspectiveFovLhNo(fov: Double, width: Double, height: Double, near: Double, far: Double, res: Mat4d): Mat4d {

        assert(width > 0.0 && height > 0.0 && fov > 0.0)

        val h = cos(0.5f * fov) / sin(0.5f * fov)
        val w = h * height / width ///todo max(width , Height) / min(width , Height)?

        res put 0.0
        res[0, 0] = w
        res[1, 1] = h
        res[2, 2] = (far + near) / (far - near)
        res[2, 3] = 1.0
        res[3, 2] = -(2.0 * far * near) / (far - near)
        return res
    }

    /** Builds a perspective projection matrix based on a field of view using left-handed coordinates.
     *  The near and far clip planes correspond to z normalized device coordinates of -1 and +1 respectively. (OpenGL clip volume definition)
     *
     *  @param fov Expressed in radians.
     *  @param width Width of the viewport
     *  @param height Height of the viewport
     *  @param near Specifies the distance from the viewer to the near clipping plane (always positive).
     *  @param far Specifies the distance from the viewer to the far clipping plane (always positive).
     *
     *  @see gtc_matrix_transform
     */
    fun perspectiveFovLhNo(fov: Double, width: Double, height: Double, near: Double, far: Double): Mat4d =
            perspectiveFovLhNo(fov, width, height, near, far, Mat4d())

    /** Builds a perspective projection matrix based on a field of view using left-handed coordinates.
     *  The near and far clip planes correspond to z normalized device coordinates of -1 and +1 respectively. (OpenGL clip volume definition)
     *
     *  @param res the resulting matrix
     *  @param fov Expressed in radians.
     *  @param size viewport dimensions
     *  @param near Specifies the distance from the viewer to the near clipping plane (always positive).
     *  @param far Specifies the distance from the viewer to the far clipping plane (always positive).
     *
     *  @see gtc_matrix_transform
     */
    fun perspectiveFovLhNo(fov: Double, size: Vec2t<*>, near: Double, far: Double, res: Mat4d): Mat4d =
            perspectiveFovLhNo(fov, size.x.d, size.y.d, near, far, res)

    /** Builds a perspective projection matrix based on a field of view using left-handed coordinates.
     *  The near and far clip planes correspond to z normalized device coordinates of -1 and +1 respectively. (OpenGL clip volume definition)
     *
     *  @param fov Expressed in radians.
     *  @param size viewport dimensions
     *  @param near Specifies the distance from the viewer to the near clipping plane (always positive).
     *  @param far Specifies the distance from the viewer to the far clipping plane (always positive).
     *
     *  @see gtc_matrix_transform
     */
    fun perspectiveFovLhNo(fov: Double, size: Vec2t<*>, near: Double, far: Double): Mat4d =
            perspectiveFovLhNo(fov, size.x.d, size.y.d, near, far, Mat4d())

    /** Builds a perspective projection matrix based on a field of view using left-handed coordinates if GLM_COORDINATE_SYSTEM is LEFT_HANDED or right-handed coordinates otherwise.
     *  The near and far clip planes correspond to z normalized device coordinates of 0 and +1 respectively. (Direct3D clip volume definition)
     *
     *  @param res the resulting matrix
     *  @param fov Expressed in radians.
     *  @param width Width of the viewport
     *  @param height Height of the viewport
     *  @param near Specifies the distance from the viewer to the near clipping plane (always positive).
     *  @param far Specifies the distance from the viewer to the far clipping plane (always positive).
     *
     *  @see gtc_matrix_transform
     */
    fun perspectiveFovZo(fov: Double, width: Double, height: Double, near: Double, far: Double, res: Mat4d): Mat4d =
            when (GLM_COORDINATE_SYSTEM) {
                GlmCoordinateSystem.LEFT_HANDED -> perspectiveFovLhZo(fov, width, height, near, far, res)
                else -> perspectiveFovRhZo(fov, width, height, near, far, res)
            }

    /** Builds a perspective projection matrix based on a field of view using left-handed coordinates if GLM_COORDINATE_SYSTEM is LEFT_HANDED or right-handed coordinates otherwise.
     *  The near and far clip planes correspond to z normalized device coordinates of 0 and +1 respectively. (Direct3D clip volume definition)
     *
     *  @param fov Expressed in radians.
     *  @param width Width of the viewport
     *  @param height Height of the viewport
     *  @param near Specifies the distance from the viewer to the near clipping plane (always positive).
     *  @param far Specifies the distance from the viewer to the far clipping plane (always positive).
     *
     *  @see gtc_matrix_transform
     */
    fun perspectiveFovZo(fov: Double, width: Double, height: Double, near: Double, far: Double): Mat4d =
            when (GLM_COORDINATE_SYSTEM) {
                GlmCoordinateSystem.LEFT_HANDED -> perspectiveFovLhZo(fov, width, height, near, far, Mat4d())
                else -> perspectiveFovRhZo(fov, width, height, near, far, Mat4d())
            }

    /** Builds a perspective projection matrix based on a field of view using left-handed coordinates if GLM_COORDINATE_SYSTEM is LEFT_HANDED or right-handed coordinates otherwise.
     *  The near and far clip planes correspond to z normalized device coordinates of 0 and +1 respectively. (Direct3D clip volume definition)
     *
     *  @param res the resulting matrix
     *  @param fov Expressed in radians.
     *  @param size viewport dimensions
     *  @param near Specifies the distance from the viewer to the near clipping plane (always positive).
     *  @param far Specifies the distance from the viewer to the far clipping plane (always positive).
     *
     *  @see gtc_matrix_transform
     */
    fun perspectiveFovZo(fov: Double, size: Vec2t<*>, near: Double, far: Double, res: Mat4d): Mat4d =
            when (GLM_COORDINATE_SYSTEM) {
                GlmCoordinateSystem.LEFT_HANDED -> perspectiveFovLhZo(fov, size.x.d, size.y.d, near, far, res)
                else -> perspectiveFovRhZo(fov, size.x.d, size.y.d, near, far, res)
            }

    /** Builds a perspective projection matrix based on a field of view using left-handed coordinates if GLM_COORDINATE_SYSTEM is LEFT_HANDED or right-handed coordinates otherwise.
     *  The near and far clip planes correspond to z normalized device coordinates of 0 and +1 respectively. (Direct3D clip volume definition)
     *
     *  @param fov Expressed in radians.
     *  @param size viewport dimensions
     *  @param near Specifies the distance from the viewer to the near clipping plane (always positive).
     *  @param far Specifies the distance from the viewer to the far clipping plane (always positive).
     *
     *  @see gtc_matrix_transform
     */
    fun perspectiveFovZo(fov: Double, size: Vec2t<*>, near: Double, far: Double): Mat4d =
            when (GLM_COORDINATE_SYSTEM) {
                GlmCoordinateSystem.LEFT_HANDED -> perspectiveFovLhZo(fov, size.x.d, size.y.d, near, far, Mat4d())
                else -> perspectiveFovRhZo(fov, size.x.d, size.y.d, near, far, Mat4d())
            }

    /** Builds a perspective projection matrix based on a field of view using left-handed coordinates if GLM_COORDINATE_SYSTEM is LEFT_HANDED or right-handed coordinates otherwise.
     *  The near and far clip planes correspond to z normalized device coordinates of -1 and +1 respectively. (OpenGL clip volume definition)
     *
     *  @param res the resulting matrix
     *  @param fov Expressed in radians.
     *  @param width Width of the viewport
     *  @param height Height of the viewport
     *  @param near Specifies the distance from the viewer to the near clipping plane (always positive).
     *  @param far Specifies the distance from the viewer to the far clipping plane (always positive).
     *
     *  @see gtc_matrix_transform
     */
    fun perspectiveFovNo(fov: Double, width: Double, height: Double, near: Double, far: Double, res: Mat4d): Mat4d =
            when (GLM_COORDINATE_SYSTEM) {
                GlmCoordinateSystem.LEFT_HANDED -> perspectiveFovLhNo(fov, width, height, near, far, res)
                else -> perspectiveFovRhNo(fov, width, height, near, far, res)
            }

    /** Builds a perspective projection matrix based on a field of view using left-handed coordinates if GLM_COORDINATE_SYSTEM is LEFT_HANDED or right-handed coordinates otherwise.
     *  The near and far clip planes correspond to z normalized device coordinates of -1 and +1 respectively. (OpenGL clip volume definition)
     *
     *  @param fov Expressed in radians.
     *  @param width Width of the viewport
     *  @param height Height of the viewport
     *  @param near Specifies the distance from the viewer to the near clipping plane (always positive).
     *  @param far Specifies the distance from the viewer to the far clipping plane (always positive).
     *
     *  @see gtc_matrix_transform
     */
    fun perspectiveFovNo(fov: Double, width: Double, height: Double, near: Double, far: Double): Mat4d =
            when (GLM_COORDINATE_SYSTEM) {
                GlmCoordinateSystem.LEFT_HANDED -> perspectiveFovLhNo(fov, width, height, near, far, Mat4d())
                else -> perspectiveFovRhNo(fov, width, height, near, far, Mat4d())
            }

    /** Builds a perspective projection matrix based on a field of view using left-handed coordinates if GLM_COORDINATE_SYSTEM is LEFT_HANDED or right-handed coordinates otherwise.
     *  The near and far clip planes correspond to z normalized device coordinates of -1 and +1 respectively. (OpenGL clip volume definition)
     *
     *  @param res the resulting matrix
     *  @param fov Expressed in radians.
     *  @param size viewport dimensions
     *  @param near Specifies the distance from the viewer to the near clipping plane (always positive).
     *  @param far Specifies the distance from the viewer to the far clipping plane (always positive).
     *
     *  @see gtc_matrix_transform
     */
    fun perspectiveFovNo(fov: Double, size: Vec2t<*>, near: Double, far: Double, res: Mat4d): Mat4d =
            when (GLM_COORDINATE_SYSTEM) {
                GlmCoordinateSystem.LEFT_HANDED -> perspectiveFovLhNo(fov, size.x.d, size.y.d, near, far, res)
                else -> perspectiveFovRhNo(fov, size.x.d, size.y.d, near, far, res)
            }

    /** Builds a perspective projection matrix based on a field of view using left-handed coordinates if GLM_COORDINATE_SYSTEM is LEFT_HANDED or right-handed coordinates otherwise.
     *  The near and far clip planes correspond to z normalized device coordinates of -1 and +1 respectively. (OpenGL clip volume definition)
     *
     *  @param fov Expressed in radians.
     *  @param size viewport dimensions
     *  @param near Specifies the distance from the viewer to the near clipping plane (always positive).
     *  @param far Specifies the distance from the viewer to the far clipping plane (always positive).
     *
     *  @see gtc_matrix_transform
     */
    fun perspectiveFovNo(fov: Double, size: Vec2t<*>, near: Double, far: Double): Mat4d =
            when (GLM_COORDINATE_SYSTEM) {
                GlmCoordinateSystem.LEFT_HANDED -> perspectiveFovLhNo(fov, size.x.d, size.y.d, near, far, Mat4d())
                else -> perspectiveFovRhNo(fov, size.x.d, size.y.d, near, far, Mat4d())
            }

    /** Builds a right handed perspective projection matrix based on a field of view.
     *  If GLM_DEPTH_CLIP_SPACE is ZERO_TO_ONE, the near and far clip planes correspond to z normalized device coordinates of 0 and +1 respectively. (Direct3D clip volume definition)
     *  Otherwise, the near and far clip planes correspond to z normalized device coordinates of -1 and +1 respectively. (OpenGL clip volume definition)
     *
     *  @param res the resulting matrix
     *  @param fov Expressed in radians.
     *  @param width Width of the viewport
     *  @param height Height of the viewport
     *  @param near Specifies the distance from the viewer to the near clipping plane (always positive).
     *  @param far Specifies the distance from the viewer to the far clipping plane (always positive).
     *
     *  @see gtc_matrix_transform
     */
    fun perspectiveFovRh(fov: Double, width: Double, height: Double, near: Double, far: Double, res: Mat4d): Mat4d =
            when (GLM_DEPTH_CLIP_SPACE) {
                GlmDepthClipSpace.ZERO_TO_ONE -> perspectiveFovRhZo(fov, width, height, near, far, res)
                else -> perspectiveFovRhNo(fov, width, height, near, far, res)
            }

    /** Builds a right handed perspective projection matrix based on a field of view.
     *  If GLM_DEPTH_CLIP_SPACE is ZERO_TO_ONE, the near and far clip planes correspond to z normalized device coordinates of 0 and +1 respectively. (Direct3D clip volume definition)
     *  Otherwise, the near and far clip planes correspond to z normalized device coordinates of -1 and +1 respectively. (OpenGL clip volume definition)
     *
     *  @param fov Expressed in radians.
     *  @param width Width of the viewport
     *  @param height Height of the viewport
     *  @param near Specifies the distance from the viewer to the near clipping plane (always positive).
     *  @param far Specifies the distance from the viewer to the far clipping plane (always positive).
     *
     *  @see gtc_matrix_transform
     */
    fun perspectiveFovRh(fov: Double, width: Double, height: Double, near: Double, far: Double): Mat4d =
            when (GLM_DEPTH_CLIP_SPACE) {
                GlmDepthClipSpace.ZERO_TO_ONE -> perspectiveFovRhZo(fov, width, height, near, far, Mat4d())
                else -> perspectiveFovRhNo(fov, width, height, near, far, Mat4d())
            }

    /** Builds a right handed perspective projection matrix based on a field of view.
     *  If GLM_DEPTH_CLIP_SPACE is ZERO_TO_ONE, the near and far clip planes correspond to z normalized device coordinates of 0 and +1 respectively. (Direct3D clip volume definition)
     *  Otherwise, the near and far clip planes correspond to z normalized device coordinates of -1 and +1 respectively. (OpenGL clip volume definition)
     *
     *  @param res the resulting matrix
     *  @param fov Expressed in radians.
     *  @param size viewport dimensions
     *  @param near Specifies the distance from the viewer to the near clipping plane (always positive).
     *  @param far Specifies the distance from the viewer to the far clipping plane (always positive).
     *
     *  @see gtc_matrix_transform
     */
    fun perspectiveFovRh(fov: Double, size: Vec2t<*>, near: Double, far: Double, res: Mat4d): Mat4d =
            when (GLM_DEPTH_CLIP_SPACE) {
                GlmDepthClipSpace.ZERO_TO_ONE -> perspectiveFovRhZo(fov, size.x.d, size.y.d, near, far, res)
                else -> perspectiveFovRhNo(fov, size.x.d, size.y.d, near, far, res)
            }

    /** Builds a right handed perspective projection matrix based on a field of view.
     *  If GLM_DEPTH_CLIP_SPACE is ZERO_TO_ONE, the near and far clip planes correspond to z normalized device coordinates of 0 and +1 respectively. (Direct3D clip volume definition)
     *  Otherwise, the near and far clip planes correspond to z normalized device coordinates of -1 and +1 respectively. (OpenGL clip volume definition)
     *
     *  @param fov Expressed in radians.
     *  @param size viewport dimensions
     *  @param near Specifies the distance from the viewer to the near clipping plane (always positive).
     *  @param far Specifies the distance from the viewer to the far clipping plane (always positive).
     *
     *  @see gtc_matrix_transform
     */
    fun perspectiveFovRh(fov: Double, size: Vec2t<*>, near: Double, far: Double): Mat4d =
            when (GLM_DEPTH_CLIP_SPACE) {
                GlmDepthClipSpace.ZERO_TO_ONE -> perspectiveFovRhZo(fov, size.x.d, size.y.d, near, far, Mat4d())
                else -> perspectiveFovRhNo(fov, size.x.d, size.y.d, near, far, Mat4d())
            }

    /** Builds a left handed perspective projection matrix based on a field of view.
     *  If GLM_DEPTH_CLIP_SPACE is ZERO_TO_ONE, the near and far clip planes correspond to z normalized device coordinates of 0 and +1 respectively. (Direct3D clip volume definition)
     *  Otherwise, the near and far clip planes correspond to z normalized device coordinates of -1 and +1 respectively. (OpenGL clip volume definition)
     *
     *  @param res the resulting matrix
     *  @param fov Expressed in radians.
     *  @param width Width of the viewport
     *  @param height Height of the viewport
     *  @param near Specifies the distance from the viewer to the near clipping plane (always positive).
     *  @param far Specifies the distance from the viewer to the far clipping plane (always positive).
     *
     *  @see gtc_matrix_transform
     */
    fun perspectiveFovLh(fov: Double, width: Double, height: Double, near: Double, far: Double, res: Mat4d): Mat4d =
            when (GLM_DEPTH_CLIP_SPACE) {
                GlmDepthClipSpace.ZERO_TO_ONE -> perspectiveFovLhZo(fov, width, height, near, far, res)
                else -> perspectiveFovLhNo(fov, width, height, near, far, res)
            }

    /** Builds a left handed perspective projection matrix based on a field of view.
     *  If GLM_DEPTH_CLIP_SPACE is ZERO_TO_ONE, the near and far clip planes correspond to z normalized device coordinates of 0 and +1 respectively. (Direct3D clip volume definition)
     *  Otherwise, the near and far clip planes correspond to z normalized device coordinates of -1 and +1 respectively. (OpenGL clip volume definition)
     *
     *  @param fov Expressed in radians.
     *  @param width Width of the viewport
     *  @param height Height of the viewport
     *  @param near Specifies the distance from the viewer to the near clipping plane (always positive).
     *  @param far Specifies the distance from the viewer to the far clipping plane (always positive).
     *
     *  @see gtc_matrix_transform
     */
    fun perspectiveFovLh(fov: Double, width: Double, height: Double, near: Double, far: Double): Mat4d =
            when (GLM_DEPTH_CLIP_SPACE) {
                GlmDepthClipSpace.ZERO_TO_ONE -> perspectiveFovLhZo(fov, width, height, near, far, Mat4d())
                else -> perspectiveFovLhNo(fov, width, height, near, far, Mat4d())
            }

    /** Builds a left handed perspective projection matrix based on a field of view.
     *  If GLM_DEPTH_CLIP_SPACE is ZERO_TO_ONE, the near and far clip planes correspond to z normalized device coordinates of 0 and +1 respectively. (Direct3D clip volume definition)
     *  Otherwise, the near and far clip planes correspond to z normalized device coordinates of -1 and +1 respectively. (OpenGL clip volume definition)
     *
     *  @param res the resulting matrix
     *  @param fov Expressed in radians.
     *  @param size viewport dimensions
     *  @param near Specifies the distance from the viewer to the near clipping plane (always positive).
     *  @param far Specifies the distance from the viewer to the far clipping plane (always positive).
     *
     *  @see gtc_matrix_transform
     */
    fun perspectiveFovLh(fov: Double, size: Vec2t<*>, near: Double, far: Double, res: Mat4d): Mat4d =
            when (GLM_DEPTH_CLIP_SPACE) {
                GlmDepthClipSpace.ZERO_TO_ONE -> perspectiveFovLhZo(fov, size.x.d, size.y.d, near, far, res)
                else -> perspectiveFovLhNo(fov, size.x.d, size.y.d, near, far, res)
            }

    /** Builds a left handed perspective projection matrix based on a field of view.
     *  If GLM_DEPTH_CLIP_SPACE is ZERO_TO_ONE, the near and far clip planes correspond to z normalized device coordinates of 0 and +1 respectively. (Direct3D clip volume definition)
     *  Otherwise, the near and far clip planes correspond to z normalized device coordinates of -1 and +1 respectively. (OpenGL clip volume definition)
     *
     *  @param fov Expressed in radians.
     *  @param size viewport dimensions
     *  @param near Specifies the distance from the viewer to the near clipping plane (always positive).
     *  @param far Specifies the distance from the viewer to the far clipping plane (always positive).
     *
     *  @see gtc_matrix_transform
     */
    fun perspectiveFovLh(fov: Double, size: Vec2t<*>, near: Double, far: Double): Mat4d =
            when (GLM_DEPTH_CLIP_SPACE) {
                GlmDepthClipSpace.ZERO_TO_ONE -> perspectiveFovLhZo(fov, size.x.d, size.y.d, near, far, Mat4d())
                else -> perspectiveFovLhNo(fov, size.x.d, size.y.d, near, far, Mat4d())
            }

    /** Builds a perspective projection matrix based on a field of view and the default handedness and default near and far clip planes definition.
     *  To change default handedness use LEFT_HANDED. To change default near and far clip planes definition use ZERO_TO_ONE.
     *
     *  @param res the resulting matrix
     *  @param fov Expressed in radians.
     *  @param width Width of the viewport
     *  @param height Height of the viewport
     *  @param near Specifies the distance from the viewer to the near clipping plane (always positive).
     *  @param far Specifies the distance from the viewer to the far clipping plane (always positive).
     *
     *  @see gtc_matrix_transform
     */
    fun perspectiveFov(fov: Double, width: Double, height: Double, near: Double, far: Double, res: Mat4d): Mat4d =
            when (GLM_COORDINATE_SYSTEM) {
                GlmCoordinateSystem.LEFT_HANDED -> when (GLM_DEPTH_CLIP_SPACE) {
                    GlmDepthClipSpace.ZERO_TO_ONE -> perspectiveFovLhZo(fov, width, height, near, far, res)
                    else -> perspectiveFovLhNo(fov, width, height, near, far, res)
                }
                else -> when (GLM_DEPTH_CLIP_SPACE) {
                    GlmDepthClipSpace.ZERO_TO_ONE -> perspectiveFovRhZo(fov, width, height, near, far, res)
                    else -> perspectiveFovRhNo(fov, width, height, near, far, res)
                }
            }

    /** Builds a perspective projection matrix based on a field of view and the default handedness and default near and far clip planes definition.
     *  To change default handedness use LEFT_HANDED. To change default near and far clip planes definition use ZERO_TO_ONE.
     *
     *  @param fov Expressed in radians.
     *  @param width Width of the viewport
     *  @param height Height of the viewport
     *  @param near Specifies the distance from the viewer to the near clipping plane (always positive).
     *  @param far Specifies the distance from the viewer to the far clipping plane (always positive).
     *
     *  @see gtc_matrix_transform
     */
    fun perspectiveFov(fov: Double, width: Double, height: Double, near: Double, far: Double): Mat4d =
            when (GLM_COORDINATE_SYSTEM) {
                GlmCoordinateSystem.LEFT_HANDED -> when (GLM_DEPTH_CLIP_SPACE) {
                    GlmDepthClipSpace.ZERO_TO_ONE -> perspectiveFovLhZo(fov, width, height, near, far, Mat4d())
                    else -> perspectiveFovLhNo(fov, width, height, near, far, Mat4d())
                }
                else -> when (GLM_DEPTH_CLIP_SPACE) {
                    GlmDepthClipSpace.ZERO_TO_ONE -> perspectiveFovRhZo(fov, width, height, near, far, Mat4d())
                    else -> perspectiveFovRhNo(fov, width, height, near, far, Mat4d())
                }
            }

    /** Builds a perspective projection matrix based on a field of view and the default handedness and default near and far clip planes definition.
     *  To change default handedness use LEFT_HANDED. To change default near and far clip planes definition use ZERO_TO_ONE.
     *
     *  @param res the resulting matrix
     *  @param fov Expressed in radians.
     *  @param size viewport dimensions
     *  @param near Specifies the distance from the viewer to the near clipping plane (always positive).
     *  @param far Specifies the distance from the viewer to the far clipping plane (always positive).
     *
     *  @see gtc_matrix_transform
     */
    fun perspectiveFov(fov: Double, size: Vec2t<*>, near: Double, far: Double, res: Mat4d): Mat4d =
            when (GLM_COORDINATE_SYSTEM) {
                GlmCoordinateSystem.LEFT_HANDED -> when (GLM_DEPTH_CLIP_SPACE) {
                    GlmDepthClipSpace.ZERO_TO_ONE -> perspectiveFovLhZo(fov, size.x.d, size.y.d, near, far, res)
                    else -> perspectiveFovLhNo(fov, size.x.d, size.y.d, near, far, res)
                }
                else -> when (GLM_DEPTH_CLIP_SPACE) {
                    GlmDepthClipSpace.ZERO_TO_ONE -> perspectiveFovRhZo(fov, size.x.d, size.y.d, near, far, res)
                    else -> perspectiveFovRhNo(fov, size.x.d, size.y.d, near, far, res)
                }
            }

    /** Builds a perspective projection matrix based on a field of view and the default handedness and default near and far clip planes definition.
     *  To change default handedness use LEFT_HANDED. To change default near and far clip planes definition use ZERO_TO_ONE.
     *
     *  @param fov Expressed in radians.
     *  @param size viewport dimensions
     *  @param near Specifies the distance from the viewer to the near clipping plane (always positive).
     *  @param far Specifies the distance from the viewer to the far clipping plane (always positive).
     *
     *  @see gtc_matrix_transform
     */
    fun perspectiveFov(fov: Double, size: Vec2t<*>, near: Double, far: Double): Mat4d =
            when (GLM_COORDINATE_SYSTEM) {
                GlmCoordinateSystem.LEFT_HANDED -> when (GLM_DEPTH_CLIP_SPACE) {
                    GlmDepthClipSpace.ZERO_TO_ONE -> perspectiveFovLhZo(fov, size.x.d, size.y.d, near, far, Mat4d())
                    else -> perspectiveFovLhNo(fov, size.x.d, size.y.d, near, far, Mat4d())
                }
                else -> when (GLM_DEPTH_CLIP_SPACE) {
                    GlmDepthClipSpace.ZERO_TO_ONE -> perspectiveFovRhZo(fov, size.x.d, size.y.d, near, far, Mat4d())
                    else -> perspectiveFovRhNo(fov, size.x.d, size.y.d, near, far, Mat4d())
                }
            }

    /** Creates a matrix for a left handed, symmetric perspective-view frustum with far plane at infinite.
     *
     * @param res the resulting matrix
     * @param fovY Specifies the field of view angle, in degrees, in the y direction. Expressed in radians.
     * @param aspect Specifies the aspect ratio that determines the field of view in the x direction. The aspect ratio is the ratio of x (width) to y (height).
     * @param near Specifies the distance from the viewer to the near clipping plane (always positive).
     *
     * @see gtc_matrix_transform
     */
    fun infinitePerspectiveLh(fovY: Double, aspect: Double, near: Double, res: Mat4d): Mat4d {

        val range = tan(fovY / 2.0) * near
        val left = -range * aspect
        val right = range * aspect
        val bottom = -range
        val top = range

        res to 0.0
        res[0, 0] = (2.0 * near) / (right - left)
        res[1, 1] = (2.0 * near) / (top - bottom)
        res[2, 2] = 1.0
        res[2, 3] = 1.0
        res[3, 2] = -2.0 * near
        return res
    }

    /** Creates a matrix for a left handed, symmetric perspective-view frustum with far plane at infinite.
     *
     * @param fovY Specifies the field of view angle, in degrees, in the y direction. Expressed in radians.
     * @param aspect Specifies the aspect ratio that determines the field of view in the x direction. The aspect ratio is the ratio of x (width) to y (height).
     * @param near Specifies the distance from the viewer to the near clipping plane (always positive).
     *
     * @see gtc_matrix_transform
     */
    fun infinitePerspectiveLh(fovY: Double, aspect: Double, near: Double): Mat4d =
            infinitePerspectiveLh(fovY, aspect, near, Mat4d())

    /** Creates a matrix for a right handed, symmetric perspective-view frustum with far plane at infinite.
     *
     *  @param res the resulting matrix
     *  @param fovY Specifies the field of view angle, in degrees, in the y direction. Expressed in radians.
     *  @param aspect Specifies the aspect ratio that determines the field of view in the x direction. The aspect ratio is the ratio of x (width) to y (height).
     *  @param near Specifies the distance from the viewer to the near clipping plane (always positive).
     *
     *  @see gtc_matrix_transform
     */
    fun infinitePerspectiveRh(fovY: Double, aspect: Double, near: Double, res: Mat4d): Mat4d {

        val range = tan(fovY / 2.0) * near
        val left = -range * aspect
        val right = range * aspect
        val bottom = -range
        val top = range

        res put 0.0
        res[0, 0] = (2.0 * near) / (right - left)
        res[1, 1] = (2.0 * near) / (top - bottom)
        res[2, 2] = -1.0
        res[2, 3] = -1.0
        res[3, 2] = -2.0 * near
        return res
    }

    /** Creates a matrix for a right handed, symmetric perspective-view frustum with far plane at infinite.
     *
     *  @param fovY Specifies the field of view angle, in degrees, in the y direction. Expressed in radians.
     *  @param aspect Specifies the aspect ratio that determines the field of view in the x direction. The aspect ratio is the ratio of x (width) to y (height).
     *  @param near Specifies the distance from the viewer to the near clipping plane (always positive).
     *
     *  @see gtc_matrix_transform
     */
    fun infinitePerspectiveRh(fovY: Double, aspect: Double, near: Double): Mat4d =
            infinitePerspectiveRh(fovY, aspect, near, Mat4d())

    /** Creates a matrix for a symmetric perspective-view frustum with far plane at infinite with default handedness.
     *
     *  @param res the resulting matrix
     *  @param fovY Specifies the field of view angle, in degrees, in the y direction. Expressed in radians.
     *  @param aspect Specifies the aspect ratio that determines the field of view in the x direction. The aspect ratio is the ratio of x (width) to y (height).
     *  @param near Specifies the distance from the viewer to the near clipping plane (always positive).
     *
     *  @see gtc_matrix_transform
     */
    fun infinitePerspective(fovY: Double, aspect: Double, near: Double, res: Mat4d): Mat4d =
            when (GLM_COORDINATE_SYSTEM) {
                GlmCoordinateSystem.LEFT_HANDED -> infinitePerspectiveLh(fovY, aspect, near, res)
                else -> infinitePerspectiveRh(fovY, aspect, near, res)
            }

    /** Creates a matrix for a symmetric perspective-view frustum with far plane at infinite with default handedness.
     *
     *  @param res the resulting matrix
     *  @param fovY Specifies the field of view angle, in degrees, in the y direction. Expressed in radians.
     *  @param aspect Specifies the aspect ratio that determines the field of view in the x direction. The aspect ratio is the ratio of x (width) to y (height).
     *  @param near Specifies the distance from the viewer to the near clipping plane (always positive).
     *
     *  @see gtc_matrix_transform
     */
    fun infinitePerspective(fovY: Double, aspect: Double, near: Double): Mat4d =
            when (GLM_COORDINATE_SYSTEM) {
                GlmCoordinateSystem.LEFT_HANDED -> infinitePerspectiveLh(fovY, aspect, near, Mat4d())
                else -> infinitePerspectiveRh(fovY, aspect, near, Mat4d())
            }

    /** Creates a matrix for a symmetric perspective-view frustum with far plane at infinite for graphics hardware that doesn't support depth clamping.
     *
     *  Infinite projection matrix: http://www.terathon.com/gdc07_lengyel.pdf
     *
     *  @param res the resulting matrix
     *  @param fovY Specifies the field of view angle, in degrees, in the y direction. Expressed in radians.
     *  param aspect Specifies the aspect ratio that determines the field of view in the x direction. The aspect ratio is the ratio of x (width) to y (height).
     *  @param near Specifies the distance from the viewer to the near clipping plane (always positive).
     *
     *  @see gtc_matrix_transform
     */
    fun tweakedInfinitePerspective(fovY: Double, aspect: Double, near: Double, res: Mat4d): Mat4d =
            tweakedInfinitePerspective(fovY, aspect, near, glm.epsilon, res)

    /** Creates a matrix for a symmetric perspective-view frustum with far plane at infinite for graphics hardware that doesn't support depth clamping.
     *
     *  @param res the resulting matrix
     *  @param fovY Specifies the field of view angle, in degrees, in the y direction. Expressed in radians.
     *  @param aspect Specifies the aspect ratio that determines the field of view in the x direction. The aspect ratio is the ratio of x (width) to y (height).
     *  @param near Specifies the distance from the viewer to the near clipping plane (always positive).
     *  @param ep Epsilon
     *
     *  @see gtc_matrix_transform
     */
    fun tweakedInfinitePerspective(fovY: Double, aspect: Double, near: Double, ep: Double, res: Mat4d): Mat4d {

        val range = tan(fovY / 2.0) * near
        val left = -range * aspect
        val right = range * aspect
        val bottom = -range
        val top = range

        res put 0.0
        res[0][0] = (2.0 * near) / (right - left)
        res[1][1] = (2.0 * near) / (top - bottom)
        res[2][2] = ep - 1.0
        res[2][3] = -1.0
        res[3][2] = (ep - 2.0) * near
        return res
    }

    /** Creates a matrix for a symmetric perspective-view frustum with far plane at infinite for graphics hardware that doesn't support depth clamping.
     *
     *  Infinite projection matrix: http://www.terathon.com/gdc07_lengyel.pdf
     *
     *  @param fovY Specifies the field of view angle, in degrees, in the y direction. Expressed in radians.
     *  param aspect Specifies the aspect ratio that determines the field of view in the x direction. The aspect ratio is the ratio of x (width) to y (height).
     *  @param near Specifies the distance from the viewer to the near clipping plane (always positive).
     *
     *  @see gtc_matrix_transform
     */
    fun tweakedInfinitePerspective(fovY: Double, aspect: Double, near: Double): Mat4d =
            tweakedInfinitePerspective(fovY, aspect, near, glm.epsilon, Mat4d())

    /** Creates a matrix for a symmetric perspective-view frustum with far plane at infinite for graphics hardware that doesn't support depth clamping.
     *
     *  @param res the resulting matrix
     *  @param fovY Specifies the field of view angle, in degrees, in the y direction. Expressed in radians.
     *  @param aspect Specifies the aspect ratio that determines the field of view in the x direction. The aspect ratio is the ratio of x (width) to y (height).
     *  @param near Specifies the distance from the viewer to the near clipping plane (always positive).
     *  @param ep Epsilon
     *
     *  @see gtc_matrix_transform
     */
    fun tweakedInfinitePerspective(fovY: Double, aspect: Double, near: Double, ep: Double): Mat4d =
            tweakedInfinitePerspective(fovY, aspect, near, ep, Mat4d())
}