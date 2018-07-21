package glm_.gtc.matrixTransform

import glm_.detail.GLM_COORDINATE_SYSTEM
import glm_.detail.GLM_DEPTH_CLIP_SPACE
import glm_.detail.GlmCoordinateSystem
import glm_.detail.GlmDepthClipSpace
import glm_.mat4x4.Mat4
import glm_.mat4x4.Mat4d

interface gtcMatrixOrtho {

    /** Creates a matrix for projecting two-dimensional coordinates onto the screen.
     *
     *  @see gtc_matrix_transform
     *  @see - glm.ortho(left: Float, right: Float, bottom: Float, top: Float, zNear: Float, zFar: Float)
     *  @see <a href="https://www.khronos.org/registry/OpenGL-Refpages/gl2.1/xhtml/gluOrtho2D.xml">gluOrtho2D man page</a>
     */
    fun ortho(res: Mat4, left: Float, right: Float, bottom: Float, top: Float): Mat4 {
        res put 1f
        res[0, 0] = 2f / (right - left)
        res[1, 1] = 2f / (top - bottom)
        res[2, 2] = - 1f
        res[3, 0] = -(right + left) / (right - left)
        res[3, 1] = -(top + bottom) / (top - bottom)
        return res
    }

    /** Creates a matrix for projecting two-dimensional coordinates onto the screen.
     *
     *  @see gtc_matrix_transform
     *  @see - glm.ortho(left: Float, right: Float, bottom: Float, top: Float, zNear: Float, zFar: Float)
     *  @see <a href="https://www.khronos.org/registry/OpenGL-Refpages/gl2.1/xhtml/gluOrtho2D.xml">gluOrtho2D man page</a>
     */
    fun ortho(left: Float, right: Float, bottom: Float, top: Float): Mat4 = ortho(Mat4(), left, right, bottom, top)

    /** Creates a matrix for an orthographic parallel viewing volume, using left-handed coordinates.
     *  The near and far clip planes correspond to z normalized device coordinates of 0 and +1 respectively. (Direct3D clip volume definition)
     *
     *  @see gtc_matrix_transform
     *  @see - glm.ortho(left: Float, right: Float, bottom: Float, top: Float)
     */
    fun orthoLhZo(res: Mat4, left: Float, right: Float, bottom: Float, top: Float, zNear: Float, zFar: Float): Mat4 {
        res put 1f
        res[0, 0] = 2f / (right - left)
        res[1, 1] = 2f / (top - bottom)
        res[2, 2] = 1f / (zFar - zNear)
        res[3, 0] = -(right + left) / (right - left)
        res[3, 1] = -(top + bottom) / (top - bottom)
        res[3, 2] = -zNear / (zFar - zNear)
        return res
    }

    /** Creates a matrix for an orthographic parallel viewing volume, using left-handed coordinates.
     *  The near and far clip planes correspond to z normalized device coordinates of 0 and +1 respectively. (Direct3D clip volume definition)
     *
     *  @see gtc_matrix_transform
     *  @see - glm.ortho(left: Float, right: Float, bottom: Float, top: Float)
     */
    fun orthoLhZo(left: Float, right: Float, bottom: Float, top: Float, zNear: Float, zFar: Float): Mat4 = orthoLhZo(Mat4(), left, right, bottom, top, zNear, zFar)

    /** Creates a matrix for an orthographic parallel viewing volume using right-handed coordinates.
     *  The near and far clip planes correspond to z normalized device coordinates of -1 and +1 respectively. (OpenGL clip volume definition)
     *
     *  @see gtc_matrix_transform
     *  @see - glm.ortho(left: Float, right: Float, bottom: Float, top: Float)
     */
    fun orthoLhNo(res: Mat4, left: Float, right: Float, bottom: Float, top: Float, zNear: Float, zFar: Float): Mat4 {
        res put 1f
        res[0, 0] = 2f / (right - left)
        res[1, 1] = 2f / (top - bottom)
        res[2, 2] = 2f / (zFar - zNear)
        res[3, 0] = -(right + left) / (right - left)
        res[3, 1] = -(top + bottom) / (top - bottom)
        res[3, 2] = -(zFar + zNear) / (zFar - zNear)
        return res
    }

    /** Creates a matrix for an orthographic parallel viewing volume using right-handed coordinates.
     *  The near and far clip planes correspond to z normalized device coordinates of -1 and +1 respectively. (OpenGL clip volume definition)
     *
     *  @see gtc_matrix_transform
     *  @see - glm.ortho(left: Float, right: Float, bottom: Float, top: Float)
     */
    fun orthoLhNo(left: Float, right: Float, bottom: Float, top: Float, zNear: Float, zFar: Float): Mat4 = orthoLhNo(Mat4(), left, right, bottom, top, zNear, zFar)

    /** Creates a matrix for an orthographic parallel viewing volume, using left-handed coordinates.
     *  The near and far clip planes correspond to z normalized device coordinates of 0 and +1 respectively. (Direct3D clip volume definition)
     *
     *  @see gtc_matrix_transform
     *  @see - glm.ortho(left: Float, right: Float, bottom: Float, top: Float)
     */
    fun orthoRhZo(res: Mat4, left: Float, right: Float, bottom: Float, top: Float, zNear: Float, zFar: Float): Mat4 {
        res put 1f
        res[0, 0] = 2f / (right - left)
        res[1, 1] = 2f / (top - bottom)
        res[2, 2] = -2f / (zFar - zNear)
        res[3, 0] = -(right + left) / (right - left)
        res[3, 1] = -(top + bottom) / (top - bottom)
        res[3, 2] = -(zFar + zNear) / (zFar - zNear)
        return res
    }

    /** Creates a matrix for an orthographic parallel viewing volume, using left-handed coordinates.
     *  The near and far clip planes correspond to z normalized device coordinates of 0 and +1 respectively. (Direct3D clip volume definition)
     *
     *  @see gtc_matrix_transform
     *  @see - glm.ortho(left: Float, right: Float, bottom: Float, top: Float)
     */
    fun orthoRhZo(left: Float, right: Float, bottom: Float, top: Float, zNear: Float, zFar: Float): Mat4 = orthoRhZo(Mat4(), left, right, bottom, top, zNear, zFar)

    /** Creates a matrix for an orthographic parallel viewing volume, using right-handed coordinates.
     *  The near and far clip planes correspond to z normalized device coordinates of -1 and +1 respectively. (OpenGL clip volume definition)
     *
     *  @see gtc_matrix_transform
     *  @see - glm.ortho(left: Float, right: Float, bottom: Float, top: Float)
     */
    fun orthoRhNo(res: Mat4, left: Float, right: Float, bottom: Float, top: Float, zNear: Float, zFar: Float): Mat4 {
        res put 1f
        res[0, 0] = 2f / (right - left)
        res[1, 1] = 2f / (top - bottom)
        res[2, 2] = -2f / (zFar - zNear)
        res[3, 0] = -(right + left) / (right - left)
        res[3, 1] = -(top + bottom) / (top - bottom)
        res[3, 2] = -(zFar + zNear) / (zFar - zNear)
        return res
    }

    /** Creates a matrix for an orthographic parallel viewing volume, using right-handed coordinates.
     *  The near and far clip planes correspond to z normalized device coordinates of -1 and +1 respectively. (OpenGL clip volume definition)
     *
     *  @see gtc_matrix_transform
     *  @see - glm.ortho(left: Float, right: Float, bottom: Float, top: Float)
     */
    fun orthoRhNo(left: Float, right: Float, bottom: Float, top: Float, zNear: Float, zFar: Float): Mat4 = orthoRhNo(Mat4(), left, right, bottom, top, zNear, zFar)

    /** Creates a matrix for an orthographic parallel viewing volume, using left-handed coordinates.
     *  The near and far clip planes correspond to z normalized device coordinates of 0 and +1 respectively. (Direct3D clip volume definition)
     *
     *  @see gtc_matrix_transform
     *  @see - glm.ortho(left: Float, right: Float, bottom: Float, top: Float)
     */
    fun orthoZo(res: Mat4, left: Float, right: Float, bottom: Float, top: Float, zNear: Float, zFar: Float): Mat4 = when (GLM_COORDINATE_SYSTEM) {
        GlmCoordinateSystem.LEFT_HANDED -> orthoLhZo(res, left, right, bottom, top, zNear, zFar)
        else -> orthoRhZo(res, left, right, bottom, top, zNear, zFar)
    }

    /** Creates a matrix for an orthographic parallel viewing volume, using left-handed coordinates.
     *  The near and far clip planes correspond to z normalized device coordinates of 0 and +1 respectively. (Direct3D clip volume definition)
     *
     *  @see gtc_matrix_transform
     *  @see - glm.ortho(left: Float, right: Float, bottom: Float, top: Float)
     */
    fun orthoZo(left: Float, right: Float, bottom: Float, top: Float, zNear: Float, zFar: Float): Mat4 = when (GLM_COORDINATE_SYSTEM) {
        GlmCoordinateSystem.LEFT_HANDED -> orthoLhZo(Mat4(), left, right, bottom, top, zNear, zFar)
        else -> orthoRhZo(Mat4(), left, right, bottom, top, zNear, zFar)
    }

    /** Creates a matrix for an orthographic parallel viewing volume, using left-handed coordinates if GLM_COORDINATE_SYSTEM
     *  is LEFT_HANDED or right-handed coordinates otherwise.
     *  The near and far clip planes correspond to z normalized device coordinates of -1 and +1 respectively. (OpenGL clip volume definition)
     *
     *  @see gtc_matrix_transform
     *  @see - glm.ortho(left: Float, right: Float, bottom: Float, top: Float)
     */
    fun orthoNo(res: Mat4, left: Float, right: Float, bottom: Float, top: Float, zNear: Float, zFar: Float): Mat4 = when (GLM_COORDINATE_SYSTEM) {
        GlmCoordinateSystem.LEFT_HANDED -> orthoLhNo(res, left, right, bottom, top, zNear, zFar)
        else -> orthoRhNo(res, left, right, bottom, top, zNear, zFar)
    }

    /** Creates a matrix for an orthographic parallel viewing volume, using left-handed coordinates if GLM_COORDINATE_SYSTEM
     *  is LEFT_HANDED or right-handed coordinates otherwise.
     *  The near and far clip planes correspond to z normalized device coordinates of -1 and +1 respectively. (OpenGL clip volume definition)
     *
     *  @see gtc_matrix_transform
     *  @see - glm.ortho(left: Float, right: Float, bottom: Float, top: Float)
     */
    fun orthoNo(left: Float, right: Float, bottom: Float, top: Float, zNear: Float, zFar: Float): Mat4 = when (GLM_COORDINATE_SYSTEM) {
        GlmCoordinateSystem.LEFT_HANDED -> orthoLhNo(Mat4(), left, right, bottom, top, zNear, zFar)
        else -> orthoRhNo(Mat4(), left, right, bottom, top, zNear, zFar)
    }

    /** Creates a matrix for an orthographic parallel viewing volume, using left-handed coordinates.
     *  If GLM_DEPTH_CLIP_SPACE is ZERO_TO_ONE, the near and far clip planes correspond to z normalized device coordinates of 0 and +1 respectively. (Direct3D clip volume definition)
     *  Otherwise, the near and far clip planes correspond to z normalized device coordinates of -1 and +1 respectively. (OpenGL clip volume definition)
     *
     *  @see gtc_matrix_transform
     *  @see - glm.ortho(left: Float, right: Float, bottom: Float, top: Float)
     */
    fun orthoLh(res: Mat4, left: Float, right: Float, bottom: Float, top: Float, zNear: Float, zFar: Float): Mat4 = when (GLM_DEPTH_CLIP_SPACE) {
        GlmDepthClipSpace.ZERO_TO_ONE -> orthoLhZo(res, left, right, bottom, top, zNear, zFar)
        else -> orthoLhNo(res, left, right, bottom, top, zNear, zFar)
    }

    /** Creates a matrix for an orthographic parallel viewing volume, using left-handed coordinates.
     *  If GLM_DEPTH_CLIP_SPACE is ZERO_TO_ONE, the near and far clip planes correspond to z normalized device coordinates of 0 and +1 respectively. (Direct3D clip volume definition)
     *  Otherwise, the near and far clip planes correspond to z normalized device coordinates of -1 and +1 respectively. (OpenGL clip volume definition)
     *
     *  @see gtc_matrix_transform
     *  @see - glm.ortho(left: Float, right: Float, bottom: Float, top: Float)
     */
    fun orthoLh(left: Float, right: Float, bottom: Float, top: Float, zNear: Float, zFar: Float): Mat4 = when (GLM_DEPTH_CLIP_SPACE) {
        GlmDepthClipSpace.ZERO_TO_ONE -> orthoLhZo(Mat4(), left, right, bottom, top, zNear, zFar)
        else -> orthoLhNo(Mat4(), left, right, bottom, top, zNear, zFar)
    }

    /** Creates a matrix for an orthographic parallel viewing volume, using right-handed coordinates.
     *  If GLM_DEPTH_CLIP_SPACE is ZERO_TO_ONE, the near and far clip planes correspond to z normalized device coordinates of 0 and +1 respectively. (Direct3D clip volume definition)
     *  Otherwise, the near and far clip planes correspond to z normalized device coordinates of -1 and +1 respectively. (OpenGL clip volume definition)
     *
     *  @see gtc_matrix_transform
     *  @see - glm:ortho(left. Float, right: Float, bottom: Float, top: Float)
     */
    fun orthoRh(res: Mat4, left: Float, right: Float, bottom: Float, top: Float, zNear: Float, zFar: Float): Mat4 = when (GLM_DEPTH_CLIP_SPACE) {
        GlmDepthClipSpace.ZERO_TO_ONE -> orthoRhZo(res, left, right, bottom, top, zNear, zFar)
        else -> orthoRhNo(res, left, right, bottom, top, zNear, zFar)
    }

    /** Creates a matrix for an orthographic parallel viewing volume, using right-handed coordinates.
     *  If GLM_DEPTH_CLIP_SPACE is ZERO_TO_ONE, the near and far clip planes correspond to z normalized device coordinates of 0 and +1 respectively. (Direct3D clip volume definition)
     *  Otherwise, the near and far clip planes correspond to z normalized device coordinates of -1 and +1 respectively. (OpenGL clip volume definition)
     *
     *  @see gtc_matrix_transform
     *  @see - glm:ortho(left. Float, right: Float, bottom: Float, top: Float)
     */
    fun orthoRh(left: Float, right: Float, bottom: Float, top: Float, zNear: Float, zFar: Float): Mat4 = when (GLM_DEPTH_CLIP_SPACE) {
        GlmDepthClipSpace.ZERO_TO_ONE -> orthoRhZo(Mat4(), left, right, bottom, top, zNear, zFar)
        else -> orthoRhNo(Mat4(), left, right, bottom, top, zNear, zFar)
    }

    /** Creates a matrix for an orthographic parallel viewing volume, using the default handedness and default near and far clip planes definition.
     *  To change default handedness use LEFT_HANDED. To change default near and far clip planes definition use ZERO_TO_ONE.
     *
     *  @see gtc_matrix_transform
     *  @see - glm.ortho(left: Float, right: Float, bottom: Float, top: Float)
     *  @see <a href="https://www.khronos.org/registry/OpenGL-Refpages/gl2.1/xhtml/glOrtho.xml">glOrtho man page</a>
     */
    fun ortho(res: Mat4, left: Float, right: Float, bottom: Float, top: Float, zNear: Float, zFar: Float): Mat4 = when (GLM_COORDINATE_SYSTEM) {
        GlmCoordinateSystem.LEFT_HANDED -> when (GLM_DEPTH_CLIP_SPACE) {
            GlmDepthClipSpace.ZERO_TO_ONE -> orthoLhZo(res, left, right, bottom, top, zNear, zFar)
            else -> orthoLhNo(res, left, right, bottom, top, zNear, zFar)
        }
        else -> when (GLM_DEPTH_CLIP_SPACE) {
            GlmDepthClipSpace.ZERO_TO_ONE -> orthoRhZo(res, left, right, bottom, top, zNear, zFar)
            else -> orthoRhNo(res, left, right, bottom, top, zNear, zFar)
        }
    }
    
    /** Creates a matrix for an orthographic parallel viewing volume, using the default handedness and default near and far clip planes definition.
     *  To change default handedness use LEFT_HANDED. To change default near and far clip planes definition use ZERO_TO_ONE.
     *
     *  @see gtc_matrix_transform
     *  @see - glm.ortho(left: Float, right: Float, bottom: Float, top: Float)
     *  @see <a href="https://www.khronos.org/registry/OpenGL-Refpages/gl2.1/xhtml/glOrtho.xml">glOrtho man page</a>
     */
    fun ortho(left: Float, right: Float, bottom: Float, top: Float, zNear: Float, zFar: Float): Mat4 = when (GLM_COORDINATE_SYSTEM) {
        GlmCoordinateSystem.LEFT_HANDED -> when (GLM_DEPTH_CLIP_SPACE) {
            GlmDepthClipSpace.ZERO_TO_ONE -> orthoLhZo(Mat4(), left, right, bottom, top, zNear, zFar)
            else -> orthoLhNo(Mat4(), left, right, bottom, top, zNear, zFar)
        }
        else -> when (GLM_DEPTH_CLIP_SPACE) {
            GlmDepthClipSpace.ZERO_TO_ONE -> orthoRhZo(Mat4(), left, right, bottom, top, zNear, zFar)
            else -> orthoRhNo(Mat4(), left, right, bottom, top, zNear, zFar)
        }
    }
    
    // -----------------------------------------------------------------------------------------------------------------
    // Mat4d version
    // -----------------------------------------------------------------------------------------------------------------
    
    /** Creates a matrix for projecting two-dimensional coordinates onto the screen.
     *
     *  @see gtc_matrix_transform
     *  @see - glm.ortho(left: Float, right: Float, bottom: Float, top: Float, zNear: Float, zFar: Float)
     *  @see <a href="https://www.khronos.org/registry/OpenGL-Refpages/gl2.1/xhtml/gluOrtho2D.xml">gluOrtho2D man page</a>
     */
    fun ortho(res: Mat4d, left: Double, right: Double, bottom: Double, top: Double): Mat4d {
        res put 1.0
        res[0, 0] = 2.0 / (right - left)
        res[1, 1] = 2.0 / (top - bottom)
        res[3, 0] = -(right + left) / (right - left)
        res[3, 1] = -(top + bottom) / (top - bottom)
        return res
    }

    /** Creates a matrix for projecting two-dimensional coordinates onto the screen.
     *
     *  @see gtc_matrix_transform
     *  @see - glm.ortho(left: Float, right: Float, bottom: Float, top: Float, zNear: Float, zFar: Float)
     *  @see <a href="https://www.khronos.org/registry/OpenGL-Refpages/gl2.1/xhtml/gluOrtho2D.xml">gluOrtho2D man page</a>
     */
    fun ortho(left: Double, right: Double, bottom: Double, top: Double): Mat4d = ortho(Mat4d(), left, right, bottom, top)

    /** Creates a matrix for an orthographic parallel viewing volume, using left-handed coordinates.
     *  The near and far clip planes correspond to z normalized device coordinates of 0 and +1 respectively. (Direct3D clip volume definition)
     *
     *  @see gtc_matrix_transform
     *  @see - glm.ortho(left: Double, right: Double, bottom: Double, top: Double)
     */
    fun orthoLhZo(res: Mat4d, left: Double, right: Double, bottom: Double, top: Double, zNear: Double, zFar: Double): Mat4d {
        res put 1.0
        res[0, 0] = 2.0 / (right - left)
        res[1, 1] = 2.0 / (top - bottom)
        res[2, 2] = 1.0 / (zFar - zNear)
        res[3, 0] = -(right + left) / (right - left)
        res[3, 1] = -(top + bottom) / (top - bottom)
        res[3, 2] = -zNear / (zFar - zNear)
        return res
    }

    /** Creates a matrix for an orthographic parallel viewing volume, using left-handed coordinates.
     *  The near and far clip planes correspond to z normalized device coordinates of 0 and +1 respectively. (Direct3D clip volume definition)
     *
     *  @see gtc_matrix_transform
     *  @see - glm.ortho(left: Double, right: Double, bottom: Double, top: Double)
     */
    fun orthoLhZo(left: Double, right: Double, bottom: Double, top: Double, zNear: Double, zFar: Double): Mat4d = orthoLhZo(Mat4d(), left, right, bottom, top, zNear, zFar)

    /** Creates a matrix for an orthographic parallel viewing volume using right-handed coordinates.
     *  The near and far clip planes correspond to z normalized device coordinates of -1 and +1 respectively. (OpenGL clip volume definition)
     *
     *  @see gtc_matrix_transform
     *  @see - glm.ortho(left: Double, right: Double, bottom: Double, top: Double)
     */
    fun orthoLhNo(res: Mat4d, left: Double, right: Double, bottom: Double, top: Double, zNear: Double, zFar: Double): Mat4d {
        res put 1.0
        res[0, 0] = 2.0 / (right - left)
        res[1, 1] = 2.0 / (top - bottom)
        res[2, 2] = 2.0 / (zFar - zNear)
        res[3, 0] = -(right + left) / (right - left)
        res[3, 1] = -(top + bottom) / (top - bottom)
        res[3, 2] = -(zFar + zNear) / (zFar - zNear)
        return res
    }

    /** Creates a matrix for an orthographic parallel viewing volume using right-handed coordinates.
     *  The near and far clip planes correspond to z normalized device coordinates of -1 and +1 respectively. (OpenGL clip volume definition)
     *
     *  @see gtc_matrix_transform
     *  @see - glm.ortho(left: Double, right: Double, bottom: Double, top: Double)
     */
    fun orthoLhNo(left: Double, right: Double, bottom: Double, top: Double, zNear: Double, zFar: Double): Mat4d = orthoLhNo(Mat4d(), left, right, bottom, top, zNear, zFar)

    /** Creates a matrix for an orthographic parallel viewing volume, using left-handed coordinates.
     *  The near and far clip planes correspond to z normalized device coordinates of 0 and +1 respectively. (Direct3D clip volume definition)
     *
     *  @see gtc_matrix_transform
     *  @see - glm.ortho(left: Double, right: Double, bottom: Double, top: Double)
     */
    fun orthoRhZo(res: Mat4d, left: Double, right: Double, bottom: Double, top: Double, zNear: Double, zFar: Double): Mat4d {
        res put 1.0
        res[0, 0] = 2.0 / (right - left)
        res[1, 1] = 2.0 / (top - bottom)
        res[2, 2] = -2.0 / (zFar - zNear)
        res[3, 0] = -(right + left) / (right - left)
        res[3, 1] = -(top + bottom) / (top - bottom)
        res[3, 2] = -(zFar + zNear) / (zFar - zNear)
        return res
    }

    /** Creates a matrix for an orthographic parallel viewing volume, using left-handed coordinates.
     *  The near and far clip planes correspond to z normalized device coordinates of 0 and +1 respectively. (Direct3D clip volume definition)
     *
     *  @see gtc_matrix_transform
     *  @see - glm.ortho(left: Double, right: Double, bottom: Double, top: Double)
     */
    fun orthoRhZo(left: Double, right: Double, bottom: Double, top: Double, zNear: Double, zFar: Double): Mat4d = orthoRhZo(Mat4d(), left, right, bottom, top, zNear, zFar)

    /** Creates a matrix for an orthographic parallel viewing volume, using right-handed coordinates.
     *  The near and far clip planes correspond to z normalized device coordinates of -1 and +1 respectively. (OpenGL clip volume definition)
     *
     *  @see gtc_matrix_transform
     *  @see - glm.ortho(left: Double, right: Double, bottom: Double, top: Double)
     */
    fun orthoRhNo(res: Mat4d, left: Double, right: Double, bottom: Double, top: Double, zNear: Double, zFar: Double): Mat4d {
        res put 1.0
        res[0, 0] = 2.0 / (right - left)
        res[1, 1] = 2.0 / (top - bottom)
        res[2, 2] = -2.0 / (zFar - zNear)
        res[3, 0] = -(right + left) / (right - left)
        res[3, 1] = -(top + bottom) / (top - bottom)
        res[3, 2] = -(zFar + zNear) / (zFar - zNear)
        return res
    }

    /** Creates a matrix for an orthographic parallel viewing volume, using right-handed coordinates.
     *  The near and far clip planes correspond to z normalized device coordinates of -1 and +1 respectively. (OpenGL clip volume definition)
     *
     *  @see gtc_matrix_transform
     *  @see - glm.ortho(left: Double, right: Double, bottom: Double, top: Double)
     */
    fun orthoRhNo(left: Double, right: Double, bottom: Double, top: Double, zNear: Double, zFar: Double): Mat4d = orthoRhNo(Mat4d(), left, right, bottom, top, zNear, zFar)

    /** Creates a matrix for an orthographic parallel viewing volume, using left-handed coordinates.
     *  The near and far clip planes correspond to z normalized device coordinates of 0 and +1 respectively. (Direct3D clip volume definition)
     *
     *  @see gtc_matrix_transform
     *  @see - glm.ortho(left: Double, right: Double, bottom: Double, top: Double)
     */
    fun orthoZo(res: Mat4d, left: Double, right: Double, bottom: Double, top: Double, zNear: Double, zFar: Double): Mat4d = when (GLM_COORDINATE_SYSTEM) {
        GlmCoordinateSystem.LEFT_HANDED -> orthoLhZo(res, left, right, bottom, top, zNear, zFar)
        else -> orthoRhZo(res, left, right, bottom, top, zNear, zFar)
    }

    /** Creates a matrix for an orthographic parallel viewing volume, using left-handed coordinates.
     *  The near and far clip planes correspond to z normalized device coordinates of 0 and +1 respectively. (Direct3D clip volume definition)
     *
     *  @see gtc_matrix_transform
     *  @see - glm.ortho(left: Double, right: Double, bottom: Double, top: Double)
     */
    fun orthoZo(left: Double, right: Double, bottom: Double, top: Double, zNear: Double, zFar: Double): Mat4d = when (GLM_COORDINATE_SYSTEM) {
        GlmCoordinateSystem.LEFT_HANDED -> orthoLhZo(Mat4d(), left, right, bottom, top, zNear, zFar)
        else -> orthoRhZo(Mat4d(), left, right, bottom, top, zNear, zFar)
    }

    /** Creates a matrix for an orthographic parallel viewing volume, using left-handed coordinates if GLM_COORDINATE_SYSTEM
     *  is LEFT_HANDED or right-handed coordinates otherwise.
     *  The near and far clip planes correspond to z normalized device coordinates of -1 and +1 respectively. (OpenGL clip volume definition)
     *
     *  @see gtc_matrix_transform
     *  @see - glm.ortho(left: Double, right: Double, bottom: Double, top: Double)
     */
    fun orthoNo(res: Mat4d, left: Double, right: Double, bottom: Double, top: Double, zNear: Double, zFar: Double): Mat4d = when (GLM_COORDINATE_SYSTEM) {
        GlmCoordinateSystem.LEFT_HANDED -> orthoLhNo(res, left, right, bottom, top, zNear, zFar)
        else -> orthoRhNo(res, left, right, bottom, top, zNear, zFar)
    }

    /** Creates a matrix for an orthographic parallel viewing volume, using left-handed coordinates if GLM_COORDINATE_SYSTEM
     *  is LEFT_HANDED or right-handed coordinates otherwise.
     *  The near and far clip planes correspond to z normalized device coordinates of -1 and +1 respectively. (OpenGL clip volume definition)
     *
     *  @see gtc_matrix_transform
     *  @see - glm.ortho(left: Double, right: Double, bottom: Double, top: Double)
     */
    fun orthoNo(left: Double, right: Double, bottom: Double, top: Double, zNear: Double, zFar: Double): Mat4d = when (GLM_COORDINATE_SYSTEM) {
        GlmCoordinateSystem.LEFT_HANDED -> orthoLhNo(Mat4d(), left, right, bottom, top, zNear, zFar)
        else -> orthoRhNo(Mat4d(), left, right, bottom, top, zNear, zFar)
    }

    /** Creates a matrix for an orthographic parallel viewing volume, using left-handed coordinates.
     *  If GLM_DEPTH_CLIP_SPACE is ZERO_TO_ONE, the near and far clip planes correspond to z normalized device coordinates of 0 and +1 respectively. (Direct3D clip volume definition)
     *  Otherwise, the near and far clip planes correspond to z normalized device coordinates of -1 and +1 respectively. (OpenGL clip volume definition)
     *
     *  @see gtc_matrix_transform
     *  @see - glm.ortho(left: Double, right: Double, bottom: Double, top: Double)
     */
    fun orthoLh(res: Mat4d, left: Double, right: Double, bottom: Double, top: Double, zNear: Double, zFar: Double): Mat4d = when (GLM_DEPTH_CLIP_SPACE) {
        GlmDepthClipSpace.ZERO_TO_ONE -> orthoLhZo(res, left, right, bottom, top, zNear, zFar)
        else -> orthoLhNo(res, left, right, bottom, top, zNear, zFar)
    }

    /** Creates a matrix for an orthographic parallel viewing volume, using left-handed coordinates.
     *  If GLM_DEPTH_CLIP_SPACE is ZERO_TO_ONE, the near and far clip planes correspond to z normalized device coordinates of 0 and +1 respectively. (Direct3D clip volume definition)
     *  Otherwise, the near and far clip planes correspond to z normalized device coordinates of -1 and +1 respectively. (OpenGL clip volume definition)
     *
     *  @see gtc_matrix_transform
     *  @see - glm.ortho(left: Double, right: Double, bottom: Double, top: Double)
     */
    fun orthoLh(left: Double, right: Double, bottom: Double, top: Double, zNear: Double, zFar: Double): Mat4d = when (GLM_DEPTH_CLIP_SPACE) {
        GlmDepthClipSpace.ZERO_TO_ONE -> orthoLhZo(Mat4d(), left, right, bottom, top, zNear, zFar)
        else -> orthoLhNo(Mat4d(), left, right, bottom, top, zNear, zFar)
    }

    /** Creates a matrix for an orthographic parallel viewing volume, using right-handed coordinates.
     *  If GLM_DEPTH_CLIP_SPACE is ZERO_TO_ONE, the near and far clip planes correspond to z normalized device coordinates of 0 and +1 respectively. (Direct3D clip volume definition)
     *  Otherwise, the near and far clip planes correspond to z normalized device coordinates of -1 and +1 respectively. (OpenGL clip volume definition)
     *
     *  @see gtc_matrix_transform
     *  @see - glm:ortho(left. Double, right: Double, bottom: Double, top: Double)
     */
    fun orthoRh(res: Mat4d, left: Double, right: Double, bottom: Double, top: Double, zNear: Double, zFar: Double): Mat4d = when (GLM_DEPTH_CLIP_SPACE) {
        GlmDepthClipSpace.ZERO_TO_ONE -> orthoRhZo(res, left, right, bottom, top, zNear, zFar)
        else -> orthoRhNo(res, left, right, bottom, top, zNear, zFar)
    }

    /** Creates a matrix for an orthographic parallel viewing volume, using right-handed coordinates.
     *  If GLM_DEPTH_CLIP_SPACE is ZERO_TO_ONE, the near and far clip planes correspond to z normalized device coordinates of 0 and +1 respectively. (Direct3D clip volume definition)
     *  Otherwise, the near and far clip planes correspond to z normalized device coordinates of -1 and +1 respectively. (OpenGL clip volume definition)
     *
     *  @see gtc_matrix_transform
     *  @see - glm:ortho(left. Double, right: Double, bottom: Double, top: Double)
     */
    fun orthoRh(left: Double, right: Double, bottom: Double, top: Double, zNear: Double, zFar: Double): Mat4d = when (GLM_DEPTH_CLIP_SPACE) {
        GlmDepthClipSpace.ZERO_TO_ONE -> orthoRhZo(Mat4d(), left, right, bottom, top, zNear, zFar)
        else -> orthoRhNo(Mat4d(), left, right, bottom, top, zNear, zFar)
    }

    /** Creates a matrix for an orthographic parallel viewing volume, using the default handedness and default near and far clip planes definition.
     *  To change default handedness use LEFT_HANDED. To change default near and far clip planes definition use ZERO_TO_ONE.
     *
     *  @see gtc_matrix_transform
     *  @see - glm.ortho(left: Double, right: Double, bottom: Double, top: Double)
     *  @see <a href="https://www.khronos.org/registry/OpenGL-Refpages/gl2.1/xhtml/glOrtho.xml">glOrtho man page</a>
     */
    fun ortho(res: Mat4d, left: Double, right: Double, bottom: Double, top: Double, zNear: Double, zFar: Double): Mat4d = when (GLM_COORDINATE_SYSTEM) {
        GlmCoordinateSystem.LEFT_HANDED -> when (GLM_DEPTH_CLIP_SPACE) {
            GlmDepthClipSpace.ZERO_TO_ONE -> orthoLhZo(res, left, right, bottom, top, zNear, zFar)
            else -> orthoLhNo(res, left, right, bottom, top, zNear, zFar)
        }
        else -> when (GLM_DEPTH_CLIP_SPACE) {
            GlmDepthClipSpace.ZERO_TO_ONE -> orthoRhZo(res, left, right, bottom, top, zNear, zFar)
            else -> orthoRhNo(res, left, right, bottom, top, zNear, zFar)
        }
    }
    
    /** Creates a matrix for an orthographic parallel viewing volume, using the default handedness and default near and far clip planes definition.
     *  To change default handedness use LEFT_HANDED. To change default near and far clip planes definition use ZERO_TO_ONE.
     *
     *  @see gtc_matrix_transform
     *  @see - glm.ortho(left: Double, right: Double, bottom: Double, top: Double)
     *  @see <a href="https://www.khronos.org/registry/OpenGL-Refpages/gl2.1/xhtml/glOrtho.xml">glOrtho man page</a>
     */
    fun ortho(left: Double, right: Double, bottom: Double, top: Double, zNear: Double, zFar: Double): Mat4d = when (GLM_COORDINATE_SYSTEM) {
        GlmCoordinateSystem.LEFT_HANDED -> when (GLM_DEPTH_CLIP_SPACE) {
            GlmDepthClipSpace.ZERO_TO_ONE -> orthoLhZo(Mat4d(), left, right, bottom, top, zNear, zFar)
            else -> orthoLhNo(Mat4d(), left, right, bottom, top, zNear, zFar)
        }
        else -> when (GLM_DEPTH_CLIP_SPACE) {
            GlmDepthClipSpace.ZERO_TO_ONE -> orthoRhZo(Mat4d(), left, right, bottom, top, zNear, zFar)
            else -> orthoRhNo(Mat4d(), left, right, bottom, top, zNear, zFar)
        }
    }
}