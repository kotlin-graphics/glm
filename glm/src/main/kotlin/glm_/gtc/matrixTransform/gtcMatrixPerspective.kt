package glm_.gtc.matrixTransform

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


interface gtcMatrixPerspective {

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
    fun perspectiveRhZo(res: Mat4, fovY: Float, aspect: Float, near: Float, far: Float): Mat4 {

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
    fun perspectiveRhZo(fovY: Float, aspect: Float, near: Float, far: Float): Mat4 = perspectiveRhZo(Mat4(), fovY, aspect, near, far)

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
    fun perspectiveRhNo(fovY: Float, aspect: Float, near: Float, far: Float): Mat4 = perspectiveRhNo(Mat4(), fovY, aspect, near, far)

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
    fun perspectiveLhZo(res: Mat4, fovY: Float, aspect: Float, near: Float, far: Float): Mat4 {

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
    fun perspectiveLhZo(fovY: Float, aspect: Float, near: Float, far: Float): Mat4 = perspectiveLhZo(Mat4(), fovY, aspect, near, far)

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
    fun perspectiveLhNo(res: Mat4, fovY: Float, aspect: Float, near: Float, far: Float): Mat4 {

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
    fun perspectiveLhNo(fovY: Float, aspect: Float, near: Float, far: Float): Mat4 = perspectiveLhNo(Mat4(), fovY, aspect, near, far)

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
    fun perspectiveZo(res: Mat4, fovY: Float, aspect: Float, near: Float, far: Float): Mat4 = when (GLM_COORDINATE_SYSTEM) {
        GlmCoordinateSystem.LEFT_HANDED -> perspectiveLhZo(res, fovY, aspect, near, far)
        else -> perspectiveRhZo(res, fovY, aspect, near, far)
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
    fun perspectiveZo(fovY: Float, aspect: Float, near: Float, far: Float): Mat4 = when (GLM_COORDINATE_SYSTEM) {
        GlmCoordinateSystem.LEFT_HANDED -> perspectiveLhZo(Mat4(), fovY, aspect, near, far)
        else -> perspectiveRhZo(Mat4(), fovY, aspect, near, far)
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
    fun perspectiveNo(res: Mat4, fovY: Float, aspect: Float, near: Float, far: Float): Mat4 = when (GLM_COORDINATE_SYSTEM) {
        GlmCoordinateSystem.LEFT_HANDED -> perspectiveLhNo(res, fovY, aspect, near, far)
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
    fun perspectiveNo(fovY: Float, aspect: Float, near: Float, far: Float): Mat4 = when (GLM_COORDINATE_SYSTEM) {
        GlmCoordinateSystem.LEFT_HANDED -> perspectiveLhNo(Mat4(), fovY, aspect, near, far)
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
    fun perspectiveRh(res: Mat4, fovY: Float, aspect: Float, near: Float, far: Float): Mat4 = when (GLM_DEPTH_CLIP_SPACE) {
        GlmDepthClipSpace.ZERO_TO_ONE -> perspectiveRhZo(res, fovY, aspect, near, far)
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
    fun perspectiveRh(fovY: Float, aspect: Float, near: Float, far: Float): Mat4 = when (GLM_DEPTH_CLIP_SPACE) {
        GlmDepthClipSpace.ZERO_TO_ONE -> perspectiveRhZo(Mat4(), fovY, aspect, near, far)
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
    fun perspectiveLh(res: Mat4, fovY: Float, aspect: Float, near: Float, far: Float): Mat4 = when (GLM_DEPTH_CLIP_SPACE) {
        GlmDepthClipSpace.ZERO_TO_ONE -> perspectiveLhZo(res, fovY, aspect, near, far)
        else -> perspectiveLhNo(res, fovY, aspect, near, far)
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
    fun perspectiveLh(fovY: Float, aspect: Float, near: Float, far: Float): Mat4 = when (GLM_DEPTH_CLIP_SPACE) {
        GlmDepthClipSpace.ZERO_TO_ONE -> perspectiveLhZo(Mat4(), fovY, aspect, near, far)
        else -> perspectiveLhNo(Mat4(), fovY, aspect, near, far)
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
    fun perspective(res: Mat4, fovY: Float, aspect: Float, near: Float, far: Float): Mat4 = when (GLM_COORDINATE_SYSTEM) {
        GlmCoordinateSystem.LEFT_HANDED -> when (GLM_DEPTH_CLIP_SPACE) {
            GlmDepthClipSpace.ZERO_TO_ONE -> perspectiveLhZo(res, fovY, aspect, near, far)
            else -> perspectiveLhNo(res, fovY, aspect, near, far)
        }
        else -> when (GLM_DEPTH_CLIP_SPACE) {
            GlmDepthClipSpace.ZERO_TO_ONE -> perspectiveRhZo(res, fovY, aspect, near, far)
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
    fun perspective(fovY: Float, aspect: Float, near: Float, far: Float): Mat4 = when (GLM_COORDINATE_SYSTEM) {
        GlmCoordinateSystem.LEFT_HANDED -> when (GLM_DEPTH_CLIP_SPACE) {
            GlmDepthClipSpace.ZERO_TO_ONE -> perspectiveLhZo(Mat4(), fovY, aspect, near, far)
            else -> perspectiveLhNo(Mat4(), fovY, aspect, near, far)
        }
        else -> when (GLM_DEPTH_CLIP_SPACE) {
            GlmDepthClipSpace.ZERO_TO_ONE -> perspectiveRhZo(Mat4(), fovY, aspect, near, far)
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
    fun perspectiveFovRhZo(res: Mat4, fov: Float, width: Float, height: Float, near: Float, far: Float): Mat4 {

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
    fun perspectiveFovRhZo(fov: Float, width: Float, height: Float, near: Float, far: Float): Mat4 = perspectiveFovRhZo(Mat4(), fov, width, height, near, far)

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
    fun perspectiveFovRhZo(res: Mat4, fov: Float, size: Vec2t<*>, near: Float, far: Float): Mat4 = perspectiveFovRhZo(res, fov, size.x.f, size.y.f, near, far)

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
    fun perspectiveFovRhZo(fov: Float, size: Vec2t<*>, near: Float, far: Float): Mat4 = perspectiveFovRhZo(Mat4(), fov, size.x.f, size.y.f, near, far)

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
    fun perspectiveFovRhNo(res: Mat4, fov: Float, width: Float, height: Float, near: Float, far: Float): Mat4 {

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
    fun perspectiveFovRhNo(fov: Float, width: Float, height: Float, near: Float, far: Float): Mat4 = perspectiveFovRhNo(Mat4(), fov, width, height, near, far)

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
    fun perspectiveFovRhNo(res: Mat4, fov: Float, size: Vec2t<*>, near: Float, far: Float): Mat4 = perspectiveFovRhNo(res, fov, size.x.f, size.y.f, near, far)

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
    fun perspectiveFovRhNo(fov: Float, size: Vec2t<*>, near: Float, far: Float): Mat4 = perspectiveFovRhNo(Mat4(), fov, size.x.f, size.y.f, near, far)

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
    fun perspectiveFovLhZo(res: Mat4, fov: Float, width: Float, height: Float, near: Float, far: Float): Mat4 {

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
    fun perspectiveFovLhZo(fov: Float, width: Float, height: Float, near: Float, far: Float): Mat4 = perspectiveFovLhZo(Mat4(), fov, width, height, near, far)

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
    fun perspectiveFovLhZo(res: Mat4, fov: Float, size: Vec2t<*>, near: Float, far: Float): Mat4 = perspectiveFovLhZo(res, fov, size.x.f, size.y.f, near, far)

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
    fun perspectiveFovLhZo(fov: Float, size: Vec2t<*>, near: Float, far: Float): Mat4 = perspectiveFovLhZo(Mat4(), fov, size.x.f, size.y.f, near, far)

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
    fun perspectiveFovLhNo(res: Mat4, fov: Float, width: Float, height: Float, near: Float, far: Float): Mat4 {

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
    fun perspectiveFovLhNo(fov: Float, width: Float, height: Float, near: Float, far: Float): Mat4 = perspectiveFovLhNo(Mat4(), fov, width, height, near, far)

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
    fun perspectiveFovLhNo(res: Mat4, fov: Float, size: Vec2t<*>, near: Float, far: Float): Mat4 = perspectiveFovLhNo(res, fov, size.x.f, size.y.f, near, far)

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
    fun perspectiveFovLhNo(fov: Float, size: Vec2t<*>, near: Float, far: Float): Mat4 = perspectiveFovLhNo(Mat4(), fov, size.x.f, size.y.f, near, far)

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
    fun perspectiveFovZo(res: Mat4, fov: Float, width: Float, height: Float, near: Float, far: Float): Mat4 = when (GLM_COORDINATE_SYSTEM) {
        GlmCoordinateSystem.LEFT_HANDED -> perspectiveFovLhZo(res, fov, width, height, near, far)
        else -> perspectiveFovRhZo(res, fov, width, height, near, far)
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
    fun perspectiveFovZo(fov: Float, width: Float, height: Float, near: Float, far: Float): Mat4 = when (GLM_COORDINATE_SYSTEM) {
        GlmCoordinateSystem.LEFT_HANDED -> perspectiveFovLhZo(Mat4(), fov, width, height, near, far)
        else -> perspectiveFovRhZo(Mat4(), fov, width, height, near, far)
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
    fun perspectiveFovZo(res: Mat4, fov: Float, size: Vec2t<*>, near: Float, far: Float): Mat4 = when (GLM_COORDINATE_SYSTEM) {
        GlmCoordinateSystem.LEFT_HANDED -> perspectiveFovLhZo(res, fov, size.x.f, size.y.f, near, far)
        else -> perspectiveFovRhZo(res, fov, size.x.f, size.y.f, near, far)
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
    fun perspectiveFovZo(fov: Float, size: Vec2t<*>, near: Float, far: Float): Mat4 = when (GLM_COORDINATE_SYSTEM) {
        GlmCoordinateSystem.LEFT_HANDED -> perspectiveFovLhZo(Mat4(), fov, size.x.f, size.y.f, near, far)
        else -> perspectiveFovRhZo(Mat4(), fov, size.x.f, size.y.f, near, far)
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
    fun perspectiveFovNo(res: Mat4, fov: Float, width: Float, height: Float, near: Float, far: Float): Mat4 = when (GLM_COORDINATE_SYSTEM) {
        GlmCoordinateSystem.LEFT_HANDED -> perspectiveFovLhNo(res, fov, width, height, near, far)
        else -> perspectiveFovRhNo(res, fov, width, height, near, far)
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
    fun perspectiveFovNo(fov: Float, width: Float, height: Float, near: Float, far: Float): Mat4 = when (GLM_COORDINATE_SYSTEM) {
        GlmCoordinateSystem.LEFT_HANDED -> perspectiveFovLhNo(Mat4(), fov, width, height, near, far)
        else -> perspectiveFovRhNo(Mat4(), fov, width, height, near, far)
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
    fun perspectiveFovNo(res: Mat4, fov: Float, size: Vec2t<*>, near: Float, far: Float): Mat4 = when (GLM_COORDINATE_SYSTEM) {
        GlmCoordinateSystem.LEFT_HANDED -> perspectiveFovLhNo(res, fov, size.x.f, size.y.f, near, far)
        else -> perspectiveFovRhNo(res, fov, size.x.f, size.y.f, near, far)
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
    fun perspectiveFovNo(fov: Float, size: Vec2t<*>, near: Float, far: Float): Mat4 = when (GLM_COORDINATE_SYSTEM) {
        GlmCoordinateSystem.LEFT_HANDED -> perspectiveFovLhNo(Mat4(), fov, size.x.f, size.y.f, near, far)
        else -> perspectiveFovRhNo(Mat4(), fov, size.x.f, size.y.f, near, far)
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
    fun perspectiveFovRh(res: Mat4, fov: Float, width: Float, height: Float, near: Float, far: Float): Mat4 = when (GLM_DEPTH_CLIP_SPACE) {
        GlmDepthClipSpace.ZERO_TO_ONE -> perspectiveFovRhZo(res, fov, width, height, near, far)
        else -> perspectiveFovRhNo(res, fov, width, height, near, far)
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
    fun perspectiveFovRh(fov: Float, width: Float, height: Float, near: Float, far: Float): Mat4 = when (GLM_DEPTH_CLIP_SPACE) {
        GlmDepthClipSpace.ZERO_TO_ONE -> perspectiveFovRhZo(Mat4(), fov, width, height, near, far)
        else -> perspectiveFovRhNo(Mat4(), fov, width, height, near, far)
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
    fun perspectiveFovRh(res: Mat4, fov: Float, size: Vec2t<*>, near: Float, far: Float): Mat4 = when (GLM_DEPTH_CLIP_SPACE) {
        GlmDepthClipSpace.ZERO_TO_ONE -> perspectiveFovRhZo(res, fov, size.x.f, size.y.f, near, far)
        else -> perspectiveFovRhNo(res, fov, size.x.f, size.y.f, near, far)
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
    fun perspectiveFovRh(fov: Float, size: Vec2t<*>, near: Float, far: Float): Mat4 = when (GLM_DEPTH_CLIP_SPACE) {
        GlmDepthClipSpace.ZERO_TO_ONE -> perspectiveFovRhZo(Mat4(), fov, size.x.f, size.y.f, near, far)
        else -> perspectiveFovRhNo(Mat4(), fov, size.x.f, size.y.f, near, far)
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
    fun perspectiveFovLh(res: Mat4, fov: Float, width: Float, height: Float, near: Float, far: Float): Mat4 = when (GLM_DEPTH_CLIP_SPACE) {
        GlmDepthClipSpace.ZERO_TO_ONE -> perspectiveFovLhZo(res, fov, width, height, near, far)
        else -> perspectiveFovLhNo(res, fov, width, height, near, far)
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
        GlmDepthClipSpace.ZERO_TO_ONE -> perspectiveFovLhZo(Mat4(), fov, width, height, near, far)
        else -> perspectiveFovLhNo(Mat4(), fov, width, height, near, far)
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
    fun perspectiveFovLh(res: Mat4, fov: Float, size: Vec2t<*>, near: Float, far: Float): Mat4 = when (GLM_DEPTH_CLIP_SPACE) {
        GlmDepthClipSpace.ZERO_TO_ONE -> perspectiveFovLhZo(res, fov, size.x.f, size.y.f, near, far)
        else -> perspectiveFovLhNo(res, fov, size.x.f, size.y.f, near, far)
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
    fun perspectiveFovLh(fov: Float, size: Vec2t<*>, near: Float, far: Float): Mat4 = when (GLM_DEPTH_CLIP_SPACE) {
        GlmDepthClipSpace.ZERO_TO_ONE -> perspectiveFovLhZo(Mat4(), fov, size.x.f, size.y.f, near, far)
        else -> perspectiveFovLhNo(Mat4(), fov, size.x.f, size.y.f, near, far)
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
    fun perspectiveFov(res: Mat4, fov: Float, width: Float, height: Float, near: Float, far: Float): Mat4 = when (GLM_COORDINATE_SYSTEM) {
        GlmCoordinateSystem.LEFT_HANDED -> when (GLM_DEPTH_CLIP_SPACE) {
            GlmDepthClipSpace.ZERO_TO_ONE -> perspectiveFovLhZo(res, fov, width, height, near, far)
            else -> perspectiveFovLhNo(res, fov, width, height, near, far)
        }
        else -> when (GLM_DEPTH_CLIP_SPACE) {
            GlmDepthClipSpace.ZERO_TO_ONE -> perspectiveFovRhZo(res, fov, width, height, near, far)
            else -> perspectiveFovRhNo(res, fov, width, height, near, far)
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
    fun perspectiveFov(fov: Float, width: Float, height: Float, near: Float, far: Float): Mat4 = when (GLM_COORDINATE_SYSTEM) {
        GlmCoordinateSystem.LEFT_HANDED -> when (GLM_DEPTH_CLIP_SPACE) {
            GlmDepthClipSpace.ZERO_TO_ONE -> perspectiveFovLhZo(Mat4(), fov, width, height, near, far)
            else -> perspectiveFovLhNo(Mat4(), fov, width, height, near, far)
        }
        else -> when (GLM_DEPTH_CLIP_SPACE) {
            GlmDepthClipSpace.ZERO_TO_ONE -> perspectiveFovRhZo(Mat4(), fov, width, height, near, far)
            else -> perspectiveFovRhNo(Mat4(), fov, width, height, near, far)
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
    fun perspectiveFov(res: Mat4, fov: Float, size: Vec2t<*>, near: Float, far: Float): Mat4 = when (GLM_COORDINATE_SYSTEM) {
        GlmCoordinateSystem.LEFT_HANDED -> when (GLM_DEPTH_CLIP_SPACE) {
            GlmDepthClipSpace.ZERO_TO_ONE -> perspectiveFovLhZo(res, fov, size.x.f, size.y.f, near, far)
            else -> perspectiveFovLhNo(res, fov, size.x.f, size.y.f, near, far)
        }
        else -> when (GLM_DEPTH_CLIP_SPACE) {
            GlmDepthClipSpace.ZERO_TO_ONE -> perspectiveFovRhZo(res, fov, size.x.f, size.y.f, near, far)
            else -> perspectiveFovRhNo(res, fov, size.x.f, size.y.f, near, far)
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
    fun perspectiveFov(fov: Float, size: Vec2t<*>, near: Float, far: Float): Mat4 = when (GLM_COORDINATE_SYSTEM) {
        GlmCoordinateSystem.LEFT_HANDED -> when (GLM_DEPTH_CLIP_SPACE) {
            GlmDepthClipSpace.ZERO_TO_ONE -> perspectiveFovLhZo(Mat4(), fov, size.x.f, size.y.f, near, far)
            else -> perspectiveFovLhNo(Mat4(), fov, size.x.f, size.y.f, near, far)
        }
        else -> when (GLM_DEPTH_CLIP_SPACE) {
            GlmDepthClipSpace.ZERO_TO_ONE -> perspectiveFovRhZo(Mat4(), fov, size.x.f, size.y.f, near, far)
            else -> perspectiveFovRhNo(Mat4(), fov, size.x.f, size.y.f, near, far)
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
    fun infinitePerspectiveLh(res: Mat4, fovY: Float, aspect: Float, near: Float): Mat4 {

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
    fun infinitePerspectiveLh(fovY: Float, aspect: Float, near: Float): Mat4 = infinitePerspectiveLh(Mat4(), fovY, aspect, near)

    /** Creates a matrix for a right handed, symmetric perspective-view frustum with far plane at infinite.
     *
     *  @param res the resulting matrix
     *  @param fovY Specifies the field of view angle, in degrees, in the y direction. Expressed in radians.
     *  @param aspect Specifies the aspect ratio that determines the field of view in the x direction. The aspect ratio is the ratio of x (width) to y (height).
     *  @param near Specifies the distance from the viewer to the near clipping plane (always positive).
     *
     *  @see gtc_matrix_transform
     */
    fun infinitePerspectiveRh(res: Mat4, fovY: Float, aspect: Float, near: Float): Mat4 {

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
    fun infinitePerspectiveRh(fovY: Float, aspect: Float, near: Float): Mat4 = infinitePerspectiveRh(Mat4(), fovY, aspect, near)

    /** Creates a matrix for a symmetric perspective-view frustum with far plane at infinite with default handedness.
     *
     *  @param res the resulting matrix
     *  @param fovY Specifies the field of view angle, in degrees, in the y direction. Expressed in radians.
     *  @param aspect Specifies the aspect ratio that determines the field of view in the x direction. The aspect ratio is the ratio of x (width) to y (height).
     *  @param near Specifies the distance from the viewer to the near clipping plane (always positive).
     *
     *  @see gtc_matrix_transform
     */
    fun infinitePerspective(res: Mat4, fovY: Float, aspect: Float, near: Float): Mat4 = when (GLM_COORDINATE_SYSTEM) {
        GlmCoordinateSystem.LEFT_HANDED -> infinitePerspectiveLh(res, fovY, aspect, near)
        else -> infinitePerspectiveRh(res, fovY, aspect, near)
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
    fun infinitePerspective(fovY: Float, aspect: Float, near: Float): Mat4 = when (GLM_COORDINATE_SYSTEM) {
        GlmCoordinateSystem.LEFT_HANDED -> infinitePerspectiveLh(Mat4(), fovY, aspect, near)
        else -> infinitePerspectiveRh(Mat4(), fovY, aspect, near)
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
    fun tweakedInfinitePerspective(res: Mat4, fovY: Float, aspect: Float, near: Float): Mat4 = tweakedInfinitePerspective(res, fovY, aspect, near, glm.epsilonF)

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
    fun tweakedInfinitePerspective(res: Mat4, fovY: Float, aspect: Float, near: Float, ep: Float): Mat4 {

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
    fun tweakedInfinitePerspective(fovY: Float, aspect: Float, near: Float): Mat4 = tweakedInfinitePerspective(Mat4(), fovY, aspect, near, glm.epsilonF)

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
    fun tweakedInfinitePerspective(fovY: Float, aspect: Float, near: Float, ep: Float): Mat4 = tweakedInfinitePerspective(Mat4(), fovY, aspect, near, ep)


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
    fun perspectiveRhZo(res: Mat4d, fovY: Double, aspect: Double, near: Double, far: Double): Mat4d {

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
    fun perspectiveRhZo(fovY: Double, aspect: Double, near: Double, far: Double): Mat4d = perspectiveRhZo(Mat4d(), fovY, aspect, near, far)

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
    fun perspectiveRhNo(res: Mat4d, fovY: Double, aspect: Double, near: Double, far: Double): Mat4d {

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
    fun perspectiveRhNo(fovY: Double, aspect: Double, near: Double, far: Double): Mat4d = perspectiveRhNo(Mat4d(), fovY, aspect, near, far)

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
    fun perspectiveLhZo(res: Mat4d, fovY: Double, aspect: Double, near: Double, far: Double): Mat4d {

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
    fun perspectiveLhZo(fovY: Double, aspect: Double, near: Double, far: Double): Mat4d = perspectiveLhZo(Mat4d(), fovY, aspect, near, far)

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
    fun perspectiveLhNo(res: Mat4d, fovY: Double, aspect: Double, near: Double, far: Double): Mat4d {

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
    fun perspectiveLhNo(fovY: Double, aspect: Double, near: Double, far: Double): Mat4d = perspectiveLhNo(Mat4d(), fovY, aspect, near, far)

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
    fun perspectiveZo(res: Mat4d, fovY: Double, aspect: Double, near: Double, far: Double): Mat4d = when (GLM_COORDINATE_SYSTEM) {
        GlmCoordinateSystem.LEFT_HANDED -> perspectiveLhZo(res, fovY, aspect, near, far)
        else -> perspectiveRhZo(res, fovY, aspect, near, far)
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
    fun perspectiveZo(fovY: Double, aspect: Double, near: Double, far: Double): Mat4d = when (GLM_COORDINATE_SYSTEM) {
        GlmCoordinateSystem.LEFT_HANDED -> perspectiveLhZo(Mat4d(), fovY, aspect, near, far)
        else -> perspectiveRhZo(Mat4d(), fovY, aspect, near, far)
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
    fun perspectiveNo(res: Mat4d, fovY: Double, aspect: Double, near: Double, far: Double): Mat4d = when (GLM_COORDINATE_SYSTEM) {
        GlmCoordinateSystem.LEFT_HANDED -> perspectiveLhNo(res, fovY, aspect, near, far)
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
    fun perspectiveNo(fovY: Double, aspect: Double, near: Double, far: Double): Mat4d = when (GLM_COORDINATE_SYSTEM) {
        GlmCoordinateSystem.LEFT_HANDED -> perspectiveLhNo(Mat4d(), fovY, aspect, near, far)
        else -> perspectiveRhNo(Mat4d(), fovY, aspect, near, far)
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
    fun perspectiveRh(res: Mat4d, fovY: Double, aspect: Double, near: Double, far: Double): Mat4d = when (GLM_DEPTH_CLIP_SPACE) {
        GlmDepthClipSpace.ZERO_TO_ONE -> perspectiveRhZo(res, fovY, aspect, near, far)
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
    fun perspectiveRh(fovY: Double, aspect: Double, near: Double, far: Double): Mat4d = when (GLM_DEPTH_CLIP_SPACE) {
        GlmDepthClipSpace.ZERO_TO_ONE -> perspectiveRhZo(Mat4d(), fovY, aspect, near, far)
        else -> perspectiveRhNo(Mat4d(), fovY, aspect, near, far)
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
    fun perspectiveLh(res: Mat4d, fovY: Double, aspect: Double, near: Double, far: Double): Mat4d = when (GLM_DEPTH_CLIP_SPACE) {
        GlmDepthClipSpace.ZERO_TO_ONE -> perspectiveLhZo(res, fovY, aspect, near, far)
        else -> perspectiveLhNo(res, fovY, aspect, near, far)
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
    fun perspectiveLh(fovY: Double, aspect: Double, near: Double, far: Double): Mat4d = when (GLM_DEPTH_CLIP_SPACE) {
        GlmDepthClipSpace.ZERO_TO_ONE -> perspectiveLhZo(Mat4d(), fovY, aspect, near, far)
        else -> perspectiveLhNo(Mat4d(), fovY, aspect, near, far)
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
    fun perspective(res: Mat4d, fovY: Double, aspect: Double, near: Double, far: Double): Mat4d = when (GLM_COORDINATE_SYSTEM) {
        GlmCoordinateSystem.LEFT_HANDED -> when (GLM_DEPTH_CLIP_SPACE) {
            GlmDepthClipSpace.ZERO_TO_ONE -> perspectiveLhZo(res, fovY, aspect, near, far)
            else -> perspectiveLhNo(res, fovY, aspect, near, far)
        }
        else -> when (GLM_DEPTH_CLIP_SPACE) {
            GlmDepthClipSpace.ZERO_TO_ONE -> perspectiveRhZo(res, fovY, aspect, near, far)
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
    fun perspective(fovY: Double, aspect: Double, near: Double, far: Double): Mat4d = when (GLM_COORDINATE_SYSTEM) {
        GlmCoordinateSystem.LEFT_HANDED -> when (GLM_DEPTH_CLIP_SPACE) {
            GlmDepthClipSpace.ZERO_TO_ONE -> perspectiveLhZo(Mat4d(), fovY, aspect, near, far)
            else -> perspectiveLhNo(Mat4d(), fovY, aspect, near, far)
        }
        else -> when (GLM_DEPTH_CLIP_SPACE) {
            GlmDepthClipSpace.ZERO_TO_ONE -> perspectiveRhZo(Mat4d(), fovY, aspect, near, far)
            else -> perspectiveRhNo(Mat4d(), fovY, aspect, near, far)
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
    fun perspectiveFovRhZo(res: Mat4d, fov: Double, width: Double, height: Double, near: Double, far: Double): Mat4d {

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
    fun perspectiveFovRhZo(fov: Double, width: Double, height: Double, near: Double, far: Double): Mat4d = perspectiveFovRhZo(Mat4d(), fov, width, height, near, far)

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
    fun perspectiveFovRhZo(res: Mat4d, fov: Double, size: Vec2t<*>, near: Double, far: Double): Mat4d = perspectiveFovRhZo(res, fov, size.x.d, size.y.d, near, far)

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
    fun perspectiveFovRhZo(fov: Double, size: Vec2t<*>, near: Double, far: Double): Mat4d = perspectiveFovRhZo(Mat4d(), fov, size.x.d, size.y.d, near, far)

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
    fun perspectiveFovRhNo(res: Mat4d, fov: Double, width: Double, height: Double, near: Double, far: Double): Mat4d {

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
    fun perspectiveFovRhNo(fov: Double, width: Double, height: Double, near: Double, far: Double): Mat4d = perspectiveFovRhNo(Mat4d(), fov, width, height, near, far)

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
    fun perspectiveFovRhNo(res: Mat4d, fov: Double, size: Vec2t<*>, near: Double, far: Double): Mat4d = perspectiveFovRhNo(res, fov, size.x.d, size.y.d, near, far)

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
    fun perspectiveFovRhNo(fov: Double, size: Vec2t<*>, near: Double, far: Double): Mat4d = perspectiveFovRhNo(Mat4d(), fov, size.x.d, size.y.d, near, far)

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
    fun perspectiveFovLhZo(res: Mat4d, fov: Double, width: Double, height: Double, near: Double, far: Double): Mat4d {

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
    fun perspectiveFovLhZo(fov: Double, width: Double, height: Double, near: Double, far: Double): Mat4d = perspectiveFovLhZo(Mat4d(), fov, width, height, near, far)

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
    fun perspectiveFovLhZo(res: Mat4d, fov: Double, size: Vec2t<*>, near: Double, far: Double): Mat4d = perspectiveFovLhZo(res, fov, size.x.d, size.y.d, near, far)

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
    fun perspectiveFovLhZo(fov: Double, size: Vec2t<*>, near: Double, far: Double): Mat4d = perspectiveFovLhZo(Mat4d(), fov, size.x.d, size.y.d, near, far)

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
    fun perspectiveFovLhNo(res: Mat4d, fov: Double, width: Double, height: Double, near: Double, far: Double): Mat4d {

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
    fun perspectiveFovLhNo(fov: Double, width: Double, height: Double, near: Double, far: Double): Mat4d = perspectiveFovLhNo(Mat4d(), fov, width, height, near, far)

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
    fun perspectiveFovLhNo(res: Mat4d, fov: Double, size: Vec2t<*>, near: Double, far: Double): Mat4d = perspectiveFovLhNo(res, fov, size.x.d, size.y.d, near, far)

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
    fun perspectiveFovLhNo(fov: Double, size: Vec2t<*>, near: Double, far: Double): Mat4d = perspectiveFovLhNo(Mat4d(), fov, size.x.d, size.y.d, near, far)

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
    fun perspectiveFovZo(res: Mat4d, fov: Double, width: Double, height: Double, near: Double, far: Double): Mat4d = when (GLM_COORDINATE_SYSTEM) {
        GlmCoordinateSystem.LEFT_HANDED -> perspectiveFovLhZo(res, fov, width, height, near, far)
        else -> perspectiveFovRhZo(res, fov, width, height, near, far)
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
    fun perspectiveFovZo(fov: Double, width: Double, height: Double, near: Double, far: Double): Mat4d = when (GLM_COORDINATE_SYSTEM) {
        GlmCoordinateSystem.LEFT_HANDED -> perspectiveFovLhZo(Mat4d(), fov, width, height, near, far)
        else -> perspectiveFovRhZo(Mat4d(), fov, width, height, near, far)
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
    fun perspectiveFovZo(res: Mat4d, fov: Double, size: Vec2t<*>, near: Double, far: Double): Mat4d = when (GLM_COORDINATE_SYSTEM) {
        GlmCoordinateSystem.LEFT_HANDED -> perspectiveFovLhZo(res, fov, size.x.d, size.y.d, near, far)
        else -> perspectiveFovRhZo(res, fov, size.x.d, size.y.d, near, far)
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
    fun perspectiveFovZo(fov: Double, size: Vec2t<*>, near: Double, far: Double): Mat4d = when (GLM_COORDINATE_SYSTEM) {
        GlmCoordinateSystem.LEFT_HANDED -> perspectiveFovLhZo(Mat4d(), fov, size.x.d, size.y.d, near, far)
        else -> perspectiveFovRhZo(Mat4d(), fov, size.x.d, size.y.d, near, far)
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
    fun perspectiveFovNo(res: Mat4d, fov: Double, width: Double, height: Double, near: Double, far: Double): Mat4d = when (GLM_COORDINATE_SYSTEM) {
        GlmCoordinateSystem.LEFT_HANDED -> perspectiveFovLhNo(res, fov, width, height, near, far)
        else -> perspectiveFovRhNo(res, fov, width, height, near, far)
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
    fun perspectiveFovNo(fov: Double, width: Double, height: Double, near: Double, far: Double): Mat4d = when (GLM_COORDINATE_SYSTEM) {
        GlmCoordinateSystem.LEFT_HANDED -> perspectiveFovLhNo(Mat4d(), fov, width, height, near, far)
        else -> perspectiveFovRhNo(Mat4d(), fov, width, height, near, far)
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
    fun perspectiveFovNo(res: Mat4d, fov: Double, size: Vec2t<*>, near: Double, far: Double): Mat4d = when (GLM_COORDINATE_SYSTEM) {
        GlmCoordinateSystem.LEFT_HANDED -> perspectiveFovLhNo(res, fov, size.x.d, size.y.d, near, far)
        else -> perspectiveFovRhNo(res, fov, size.x.d, size.y.d, near, far)
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
    fun perspectiveFovNo(fov: Double, size: Vec2t<*>, near: Double, far: Double): Mat4d = when (GLM_COORDINATE_SYSTEM) {
        GlmCoordinateSystem.LEFT_HANDED -> perspectiveFovLhNo(Mat4d(), fov, size.x.d, size.y.d, near, far)
        else -> perspectiveFovRhNo(Mat4d(), fov, size.x.d, size.y.d, near, far)
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
    fun perspectiveFovRh(res: Mat4d, fov: Double, width: Double, height: Double, near: Double, far: Double): Mat4d = when (GLM_DEPTH_CLIP_SPACE) {
        GlmDepthClipSpace.ZERO_TO_ONE -> perspectiveFovRhZo(res, fov, width, height, near, far)
        else -> perspectiveFovRhNo(res, fov, width, height, near, far)
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
    fun perspectiveFovRh(fov: Double, width: Double, height: Double, near: Double, far: Double): Mat4d = when (GLM_DEPTH_CLIP_SPACE) {
        GlmDepthClipSpace.ZERO_TO_ONE -> perspectiveFovRhZo(Mat4d(), fov, width, height, near, far)
        else -> perspectiveFovRhNo(Mat4d(), fov, width, height, near, far)
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
    fun perspectiveFovRh(res: Mat4d, fov: Double, size: Vec2t<*>, near: Double, far: Double): Mat4d = when (GLM_DEPTH_CLIP_SPACE) {
        GlmDepthClipSpace.ZERO_TO_ONE -> perspectiveFovRhZo(res, fov, size.x.d, size.y.d, near, far)
        else -> perspectiveFovRhNo(res, fov, size.x.d, size.y.d, near, far)
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
    fun perspectiveFovRh(fov: Double, size: Vec2t<*>, near: Double, far: Double): Mat4d = when (GLM_DEPTH_CLIP_SPACE) {
        GlmDepthClipSpace.ZERO_TO_ONE -> perspectiveFovRhZo(Mat4d(), fov, size.x.d, size.y.d, near, far)
        else -> perspectiveFovRhNo(Mat4d(), fov, size.x.d, size.y.d, near, far)
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
    fun perspectiveFovLh(res: Mat4d, fov: Double, width: Double, height: Double, near: Double, far: Double): Mat4d = when (GLM_DEPTH_CLIP_SPACE) {
        GlmDepthClipSpace.ZERO_TO_ONE -> perspectiveFovLhZo(res, fov, width, height, near, far)
        else -> perspectiveFovLhNo(res, fov, width, height, near, far)
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
    fun perspectiveFovLh(fov: Double, width: Double, height: Double, near: Double, far: Double): Mat4d = when (GLM_DEPTH_CLIP_SPACE) {
        GlmDepthClipSpace.ZERO_TO_ONE -> perspectiveFovLhZo(Mat4d(), fov, width, height, near, far)
        else -> perspectiveFovLhNo(Mat4d(), fov, width, height, near, far)
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
    fun perspectiveFovLh(res: Mat4d, fov: Double, size: Vec2t<*>, near: Double, far: Double): Mat4d = when (GLM_DEPTH_CLIP_SPACE) {
        GlmDepthClipSpace.ZERO_TO_ONE -> perspectiveFovLhZo(res, fov, size.x.d, size.y.d, near, far)
        else -> perspectiveFovLhNo(res, fov, size.x.d, size.y.d, near, far)
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
    fun perspectiveFovLh(fov: Double, size: Vec2t<*>, near: Double, far: Double): Mat4d = when (GLM_DEPTH_CLIP_SPACE) {
        GlmDepthClipSpace.ZERO_TO_ONE -> perspectiveFovLhZo(Mat4d(), fov, size.x.d, size.y.d, near, far)
        else -> perspectiveFovLhNo(Mat4d(), fov, size.x.d, size.y.d, near, far)
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
    fun perspectiveFov(res: Mat4d, fov: Double, width: Double, height: Double, near: Double, far: Double): Mat4d = when (GLM_COORDINATE_SYSTEM) {
        GlmCoordinateSystem.LEFT_HANDED -> when (GLM_DEPTH_CLIP_SPACE) {
            GlmDepthClipSpace.ZERO_TO_ONE -> perspectiveFovLhZo(res, fov, width, height, near, far)
            else -> perspectiveFovLhNo(res, fov, width, height, near, far)
        }
        else -> when (GLM_DEPTH_CLIP_SPACE) {
            GlmDepthClipSpace.ZERO_TO_ONE -> perspectiveFovRhZo(res, fov, width, height, near, far)
            else -> perspectiveFovRhNo(res, fov, width, height, near, far)
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
    fun perspectiveFov(fov: Double, width: Double, height: Double, near: Double, far: Double): Mat4d = when (GLM_COORDINATE_SYSTEM) {
        GlmCoordinateSystem.LEFT_HANDED -> when (GLM_DEPTH_CLIP_SPACE) {
            GlmDepthClipSpace.ZERO_TO_ONE -> perspectiveFovLhZo(Mat4d(), fov, width, height, near, far)
            else -> perspectiveFovLhNo(Mat4d(), fov, width, height, near, far)
        }
        else -> when (GLM_DEPTH_CLIP_SPACE) {
            GlmDepthClipSpace.ZERO_TO_ONE -> perspectiveFovRhZo(Mat4d(), fov, width, height, near, far)
            else -> perspectiveFovRhNo(Mat4d(), fov, width, height, near, far)
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
    fun perspectiveFov(res: Mat4d, fov: Double, size: Vec2t<*>, near: Double, far: Double): Mat4d = when (GLM_COORDINATE_SYSTEM) {
        GlmCoordinateSystem.LEFT_HANDED -> when (GLM_DEPTH_CLIP_SPACE) {
            GlmDepthClipSpace.ZERO_TO_ONE -> perspectiveFovLhZo(res, fov, size.x.d, size.y.d, near, far)
            else -> perspectiveFovLhNo(res, fov, size.x.d, size.y.d, near, far)
        }
        else -> when (GLM_DEPTH_CLIP_SPACE) {
            GlmDepthClipSpace.ZERO_TO_ONE -> perspectiveFovRhZo(res, fov, size.x.d, size.y.d, near, far)
            else -> perspectiveFovRhNo(res, fov, size.x.d, size.y.d, near, far)
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
    fun perspectiveFov(fov: Double, size: Vec2t<*>, near: Double, far: Double): Mat4d = when (GLM_COORDINATE_SYSTEM) {
        GlmCoordinateSystem.LEFT_HANDED -> when (GLM_DEPTH_CLIP_SPACE) {
            GlmDepthClipSpace.ZERO_TO_ONE -> perspectiveFovLhZo(Mat4d(), fov, size.x.d, size.y.d, near, far)
            else -> perspectiveFovLhNo(Mat4d(), fov, size.x.d, size.y.d, near, far)
        }
        else -> when (GLM_DEPTH_CLIP_SPACE) {
            GlmDepthClipSpace.ZERO_TO_ONE -> perspectiveFovRhZo(Mat4d(), fov, size.x.d, size.y.d, near, far)
            else -> perspectiveFovRhNo(Mat4d(), fov, size.x.d, size.y.d, near, far)
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
    fun infinitePerspectiveLh(res: Mat4d, fovY: Double, aspect: Double, near: Double): Mat4d {

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
    fun infinitePerspectiveLh(fovY: Double, aspect: Double, near: Double): Mat4d = infinitePerspectiveLh(Mat4d(), fovY, aspect, near)

    /** Creates a matrix for a right handed, symmetric perspective-view frustum with far plane at infinite.
     *
     *  @param res the resulting matrix
     *  @param fovY Specifies the field of view angle, in degrees, in the y direction. Expressed in radians.
     *  @param aspect Specifies the aspect ratio that determines the field of view in the x direction. The aspect ratio is the ratio of x (width) to y (height).
     *  @param near Specifies the distance from the viewer to the near clipping plane (always positive).
     *
     *  @see gtc_matrix_transform
     */
    fun infinitePerspectiveRh(res: Mat4d, fovY: Double, aspect: Double, near: Double): Mat4d {

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
    fun infinitePerspectiveRh(fovY: Double, aspect: Double, near: Double): Mat4d = infinitePerspectiveRh(Mat4d(), fovY, aspect, near)

    /** Creates a matrix for a symmetric perspective-view frustum with far plane at infinite with default handedness.
     *
     *  @param res the resulting matrix
     *  @param fovY Specifies the field of view angle, in degrees, in the y direction. Expressed in radians.
     *  @param aspect Specifies the aspect ratio that determines the field of view in the x direction. The aspect ratio is the ratio of x (width) to y (height).
     *  @param near Specifies the distance from the viewer to the near clipping plane (always positive).
     *
     *  @see gtc_matrix_transform
     */
    fun infinitePerspective(res: Mat4d, fovY: Double, aspect: Double, near: Double): Mat4d = when (GLM_COORDINATE_SYSTEM) {
        GlmCoordinateSystem.LEFT_HANDED -> infinitePerspectiveLh(res, fovY, aspect, near)
        else -> infinitePerspectiveRh(res, fovY, aspect, near)
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
    fun infinitePerspective(fovY: Double, aspect: Double, near: Double): Mat4d = when (GLM_COORDINATE_SYSTEM) {
        GlmCoordinateSystem.LEFT_HANDED -> infinitePerspectiveLh(Mat4d(), fovY, aspect, near)
        else -> infinitePerspectiveRh(Mat4d(), fovY, aspect, near)
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
    fun tweakedInfinitePerspective(res: Mat4d, fovY: Double, aspect: Double, near: Double): Mat4d = tweakedInfinitePerspective(res, fovY, aspect, near, glm.epsilon)

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
    fun tweakedInfinitePerspective(res: Mat4d, fovY: Double, aspect: Double, near: Double, ep: Double): Mat4d {

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
    fun tweakedInfinitePerspective(fovY: Double, aspect: Double, near: Double): Mat4d = tweakedInfinitePerspective(Mat4d(), fovY, aspect, near, glm.epsilon)

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
    fun tweakedInfinitePerspective(fovY: Double, aspect: Double, near: Double, ep: Double): Mat4d = tweakedInfinitePerspective(Mat4d(), fovY, aspect, near, ep)
}