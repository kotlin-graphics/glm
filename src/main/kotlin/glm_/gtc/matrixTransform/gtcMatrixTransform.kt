package glm_.gtc.matrixTransform

import glm_.detail.GLM_COORDINATE_SYSTEM
import glm_.detail.GlmCoordinateSystem
import glm_.mat4x4.Mat4
import glm_.mat4x4.Mat4d
import glm_.vec2.Vec2
import glm_.vec2.Vec2d
import glm_.vec3.Vec3
import glm_.vec3.Vec3d
import glm_.vec4.Vec4
import glm_.vec4.Vec4d
import glm_.vec4.Vec4i
import kotlin.math.sqrt


interface gtcMatrixTransform {

    /** Define a picking region
     *
     *  @param res the pick matrix
     *  @param center Specify the center of a picking region in window coordinates.
     *  @param delta Specify the width and height, respectively, of the picking region in window coordinates.
     *  @param viewport Rendering viewport
     *
     *  @see gtc_matrix_transform
     *  @see <a href="https://www.khronos.org/registry/OpenGL-Refpages/gl2.1/xhtml/gluPickMatrix.xml">gluPickMatrix man page</a>
     */
    fun pickMatrix(res: Mat4, center: Vec2, delta: Vec2, viewport: Vec4i): Mat4 {

        assert(delta.x > 0f && delta.y > 0f)
        res put 1f

        if (!(delta.x > 0f && delta.y > 0f))
            throw Error()

        val tmpX = (viewport[2] - 2f * (center.x - viewport[0])) / delta.x
        val tmpY = (viewport[3] - 2f * (center.y - viewport[1])) / delta.y
        val tmpZ = 0f

        // Translate and scale the picked region to the entire window
        //Result = translate(Result, Temp)
        val x = res[0, 0] * tmpX + res[1, 0] * tmpY + res[3, 0]
        val y = res[0, 1] * tmpX + res[1, 1] * tmpY + res[3, 1]
        val z = res[0, 2] * tmpX + res[1, 2] * tmpY + res[3, 2]
        val w = res[0, 3] * tmpX + res[1, 3] * tmpY + res[3, 3]
        res[3, 0] = x
        res[3, 1] = y
        res[3, 2] = z
        res[3, 3] = w
        //return scale(res, Vec3(viewport[2] / delta.x, viewport[3] / delta.y, 1f))
        val vX = viewport[2] / delta.x
        val vY = viewport[3] / delta.y
        res[0, 0] *= vX
        res[0, 1] *= vX
        res[0, 2] *= vX
        res[0, 3] *= vX
        res[1, 0] *= vY
        res[1, 1] *= vY
        res[1, 2] *= vY
        res[1, 3] *= vY
        return res
    }

    /** Define a picking region
     *
     *  @param center Specify the center of a picking region in window coordinates.
     *  @param delta Specify the width and height, respectively, of the picking region in window coordinates.
     *  @param viewport Rendering viewport
     *
     *  @see gtc_matrix_transform
     *  @see <a href="https://www.khronos.org/registry/OpenGL-Refpages/gl2.1/xhtml/gluPickMatrix.xml">gluPickMatrix man page</a>
     */
    fun pickMatrix(center: Vec2, delta: Vec2, viewport: Vec4i): Mat4 = pickMatrix(Mat4(), center, delta, viewport)

    /** Build a right handed look at view matrix.
     *
     *  @param res the resulting matrix
     *  @param eye Position of the camera
     *  @param center Position where the camera is looking at
     *  @param up Normalized up vector, how the camera is oriented. Typically (0, 0, 1)
     *  @see gtc_matrix_transform
     *  @see - frustum(left: Float, right: Float, bottom: Float, top: Float, near: Float, far: Float)
     *  frustum(left: Float, right: Float, bottom: Float, top: Float, near: Float, far: Float)
     */
    fun lookAtRh(res: Mat4, eye: Vec3, center: Vec3, up: Vec3): Mat4 {
        // f = normalize(center - eye)
        var fX = center.x - eye.x
        var fY = center.y - eye.y
        var fZ = center.z - eye.z
        var inv = 1f / sqrt(fX * fX + fY * fY + fZ * fZ)
        fX *= inv
        fY *= inv
        fZ *= inv
        // s = normalize(cross(f, up))
        var sX = fY * up.z - up.y * fZ
        var sY = fZ * up.x - up.z * fX
        var sZ = fX * up.y - up.x * fY
        inv = 1f / sqrt(sX * sX + sY * sY + sZ * sZ)
        sX *= inv
        sY *= inv
        sZ *= inv
        // u = cross(s, f)
        val uX = sY * fZ - fY * sZ
        val uY = sZ * fX - fZ * sX
        val uZ = sX * fY - fX * sY

        res put 1f
        res[0, 0] = sX
        res[1, 0] = sY
        res[2, 0] = sZ
        res[0, 1] = uX
        res[1, 1] = uY
        res[2, 1] = uZ
        res[0, 2] = -fX
        res[1, 2] = -fY
        res[2, 2] = -fZ
//        res[3,0] =-dot(s, eye)
        res[3, 0] = -(sX * eye.x + sY * eye.y + sZ * eye.z)
//        res[3,1] =-dot(u, eye)
        res[3, 1] = -(uX * eye.x + uY * eye.y + uZ * eye.z)
//        res[3,2] = dot(f, eye)
        res[3, 2] = fX * eye.x + fY * eye.y + fZ * eye.z
        return res
    }

    /** Build a right handed look at view matrix.
     *
     *  @param eye Position of the camera
     *  @param center Position where the camera is looking at
     *  @param up Normalized up vector, how the camera is oriented. Typically (0, 0, 1)
     *  @see gtc_matrix_transform
     *  @see - frustum(left: Float, right: Float, bottom: Float, top: Float, near: Float, far: Float)
     *  frustum(left: Float, right: Float, bottom: Float, top: Float, near: Float, far: Float)
     */
    fun lookAtRh(eye: Vec3, center: Vec3, up: Vec3): Mat4 = lookAtRh(Mat4(), eye, center, up)

    /** Build a left handed look at view matrix.
     *
     *  @param res the resulting matrix
     *  @param eye Position of the camera
     *  @param center Position where the camera is looking at
     *  @param up Normalized up vector, how the camera is oriented. Typically (0, 0, 1)
     *  @see gtc_matrix_transform
     *  @see - frustum(left: Float, right: Float, bottom: Float, top: Float, near: Float, far: Float)
     *  frustum(left: Float, right: Float, bottom: Float, top: Float, near: Float, far: Float)
     */
    fun lookAtLh(res: Mat4, eye: Vec3, center: Vec3, up: Vec3): Mat4 {

        // f = normalize(center - eye)
        var fX = center.x - eye.x
        var fY = center.y - eye.y
        var fZ = center.z - eye.z
        var inv = 1f / sqrt(fX * fX + fY * fY + fZ * fZ)
        fX *= inv
        fY *= inv
        fZ *= inv
        // s = normalize(cross(up, f))
        var sX = up.y * fZ - fY * up.z
        var sY = up.z * fX - fZ * up.x
        var sZ = up.x * fY - fX * up.y
        inv = 1f / sqrt(sX * sX + sY * sY + sZ * sZ)
        sX *= inv
        sY *= inv
        sZ *= inv
        // u = cross(f, s)
        val uX = fY * sZ - sY * fZ
        val uY = fZ * sX - sZ * fX
        val uZ = fX * sY - sX * fY

        res put 1f
        res[0, 0] = sX
        res[1, 0] = sY
        res[2, 0] = sZ
        res[0, 1] = uX
        res[1, 1] = uY
        res[2, 1] = uZ
        res[0, 2] = fX
        res[1, 2] = fY
        res[2, 2] = fZ
//        res[3,0] = -dot(s, eye)
        res[3, 0] = -(sX * eye.x + sY * eye.y + sZ * eye.z)
//        res[3,1] = -dot(u, eye)
        res[3, 1] = -(uX * eye.x + uY * eye.y + uZ * eye.z)
//        res[3,2] = -dot(f, eye)
        res[3, 2] = -(fX * eye.x + fY * eye.y + fZ * eye.z)
        return res
    }

    /** Build a left handed look at view matrix.
     *
     *  @param eye Position of the camera
     *  @param center Position where the camera is looking at
     *  @param up Normalized up vector, how the camera is oriented. Typically (0, 0, 1)
     *  @see gtc_matrix_transform
     *  @see - frustum(left: Float, right: Float, bottom: Float, top: Float, near: Float, far: Float)
     *  frustum(left: Float, right: Float, bottom: Float, top: Float, near: Float, far: Float)
     */
    fun lookAtLh(eye: Vec3, center: Vec3, up: Vec3): Mat4 = lookAtLh(Mat4(), eye, center, up)

    /** Build a look at view matrix based on the default handedness.
     *
     *  @param res the resulting matrix
     *  @param eye Position of the camera
     *  @param center Position where the camera is looking at
     *  @param up Normalized up vector, how the camera is oriented. Typically (0, 0, 1)
     *  @see gtc_matrix_transform
     *  @see - frustum(left: Float, right: Float, bottom: Float, top: Float, near: Float, far: Float)
     *  frustum(left: Float, right: Float, bottom: Float, top: Float, near: Float, far: Float)
     *  @see <a href="https://www.khronos.org/registry/OpenGL-Refpages/gl2.1/xhtml/gluLookAt.xml">gluLookAt man page</a>
     */
    fun lookAt(res: Mat4, eye: Vec3, center: Vec3, up: Vec3): Mat4 = when (GLM_COORDINATE_SYSTEM) {
        GlmCoordinateSystem.LEFT_HANDED -> lookAtLh(res, eye, center, up)
        else -> lookAtRh(res, eye, center, up)
    }

    /** Build a look at view matrix based on the default handedness.
     *
     *  @param res the resulting matrix
     *  @param eye Position of the camera
     *  @param center Position where the camera is looking at
     *  @param up Normalized up vector, how the camera is oriented. Typically (0, 0, 1)
     *  @see gtc_matrix_transform
     *  @see - frustum(left: Float, right: Float, bottom: Float, top: Float, near: Float, far: Float)
     *  frustum(left: Float, right: Float, bottom: Float, top: Float, near: Float, far: Float)
     *  @see <a href="https://www.khronos.org/registry/OpenGL-Refpages/gl2.1/xhtml/gluLookAt.xml">gluLookAt man page</a>
     */
    fun lookAt(eye: Vec3, center: Vec3, up: Vec3): Mat4 = when (GLM_COORDINATE_SYSTEM) {
        GlmCoordinateSystem.LEFT_HANDED -> lookAtLh(Mat4(), eye, center, up)
        else -> lookAtRh(Mat4(), eye, center, up)
    }

    
    // -----------------------------------------------------------------------------------------------------------------
    // Mat4d version
    // -----------------------------------------------------------------------------------------------------------------

    
    /** Define a picking region
     *
     *  @param res the pick matrix
     *  @param center Specify the center of a picking region in window coordinates.
     *  @param delta Specify the width and height, respectively, of the picking region in window coordinates.
     *  @param viewport Rendering viewport
     *
     *  @see gtc_matrix_transform
     *  @see <a href="https://www.khronos.org/registry/OpenGL-Refpages/gl2.1/xhtml/gluPickMatrix.xml">gluPickMatrix man page</a>
     */
    fun pickMatrix(res: Mat4d, center: Vec2d, delta: Vec2d, viewport: Vec4i): Mat4d {

        assert(delta.x > 0.0 && delta.y > 0.0)
        res put 1.0

        if (!(delta.x > 0.0 && delta.y > 0.0))
            throw Error()

        val tmpX = (viewport[2] - 2.0 * (center.x - viewport[0])) / delta.x
        val tmpY = (viewport[3] - 2.0 * (center.y - viewport[1])) / delta.y
        val tmpZ = 0.0

        // Translate and scale the picked region to the entire window
        //Result = translate(Result, Temp)
        val x = res[0, 0] * tmpX + res[1, 0] * tmpY + res[3, 0]
        val y = res[0, 1] * tmpX + res[1, 1] * tmpY + res[3, 1]
        val z = res[0, 2] * tmpX + res[1, 2] * tmpY + res[3, 2]
        val w = res[0, 3] * tmpX + res[1, 3] * tmpY + res[3, 3]
        res[3, 0] = x
        res[3, 1] = y
        res[3, 2] = z
        res[3, 3] = w
        //return scale(res, Vec3(viewport[2] / delta.x, viewport[3] / delta.y, 1.0))
        val vX = viewport[2] / delta.x
        val vY = viewport[3] / delta.y
        res[0, 0] *= vX
        res[0, 1] *= vX
        res[0, 2] *= vX
        res[0, 3] *= vX
        res[1, 0] *= vY
        res[1, 1] *= vY
        res[1, 2] *= vY
        res[1, 3] *= vY
        return res
    }

    /** Define a picking region
     *
     *  @param center Specify the center of a picking region in window coordinates.
     *  @param delta Specify the width and height, respectively, of the picking region in window coordinates.
     *  @param viewport Rendering viewport
     *
     *  @see gtc_matrix_transform
     *  @see <a href="https://www.khronos.org/registry/OpenGL-Refpages/gl2.1/xhtml/gluPickMatrix.xml">gluPickMatrix man page</a>
     */
    fun pickMatrix(center: Vec2d, delta: Vec2d, viewport: Vec4i): Mat4d = pickMatrix(Mat4d(), center, delta, viewport)

    /** Build a right handed look at view matrix.
     *
     *  @param res the resulting matrix
     *  @param eye Position of the camera
     *  @param center Position where the camera is looking at
     *  @param up Normalized up vector, how the camera is oriented. Typically (0, 0, 1)
     *  @see gtc_matrix_transform
     *  @see - frustum(left: Float, right: Float, bottom: Float, top: Float, near: Float, far: Float)
     *  frustum(left: Float, right: Float, bottom: Float, top: Float, near: Float, far: Float)
     */
    fun lookAtRh(res: Mat4d, eye: Vec3d, center: Vec3d, up: Vec3d): Mat4d {
        // f = normalize(center - eye)
        var fX = center.x - eye.x
        var fY = center.y - eye.y
        var fZ = center.z - eye.z
        var inv = 1.0 / sqrt(fX * fX + fY * fY + fZ * fZ)
        fX *= inv
        fY *= inv
        fZ *= inv
        // s = normalize(cross(f, up))
        var sX = fY * up.z - up.y * fZ
        var sY = fZ * up.x - up.z * fX
        var sZ = fX * up.y - up.x * fY
        inv = 1.0 / sqrt(sX * sX + sY * sY + sZ * sZ)
        sX *= inv
        sY *= inv
        sZ *= inv
        // u = cross(s, f)
        val uX = sY * fZ - fY * sZ
        val uY = sZ * fX - fZ * sX
        val uZ = sX * fY - fX * sY

        res put 1.0
        res[0, 0] = sX
        res[1, 0] = sY
        res[2, 0] = sZ
        res[0, 1] = uX
        res[1, 1] = uY
        res[2, 1] = uZ
        res[0, 2] = -fX
        res[1, 2] = -fY
        res[2, 2] = -fZ
//        res[3,0] =-dot(s, eye)
        res[3, 0] = -(sX * eye.x + sY * eye.y + sZ * eye.z)
//        res[3,1] =-dot(u, eye)
        res[3, 1] = -(uX * eye.x + uY * eye.y + uZ * eye.z)
//        res[3,2] = dot(f, eye)
        res[3, 2] = fX * eye.x + fY * eye.y + fZ * eye.z
        return res
    }

    /** Build a right handed look at view matrix.
     *
     *  @param eye Position of the camera
     *  @param center Position where the camera is looking at
     *  @param up Normalized up vector, how the camera is oriented. Typically (0, 0, 1)
     *  @see gtc_matrix_transform
     *  @see - frustum(left: Float, right: Float, bottom: Float, top: Float, near: Float, far: Float)
     *  frustum(left: Float, right: Float, bottom: Float, top: Float, near: Float, far: Float)
     */
    fun lookAtRh(eye: Vec3d, center: Vec3d, up: Vec3d): Mat4d = lookAtRh(Mat4d(), eye, center, up)

    /** Build a left handed look at view matrix.
     *
     *  @param res the resulting matrix
     *  @param eye Position of the camera
     *  @param center Position where the camera is looking at
     *  @param up Normalized up vector, how the camera is oriented. Typically (0, 0, 1)
     *  @see gtc_matrix_transform
     *  @see - frustum(left: Float, right: Float, bottom: Float, top: Float, near: Float, far: Float)
     *  frustum(left: Float, right: Float, bottom: Float, top: Float, near: Float, far: Float)
     */
    fun lookAtLh(res: Mat4d, eye: Vec3d, center: Vec3d, up: Vec3d): Mat4d {

        // f = normalize(center - eye)
        var fX = center.x - eye.x
        var fY = center.y - eye.y
        var fZ = center.z - eye.z
        var inv = 1.0 / sqrt(fX * fX + fY * fY + fZ * fZ)
        fX *= inv
        fY *= inv
        fZ *= inv
        // s = normalize(cross(up, f))
        var sX = up.y * fZ - fY * up.z
        var sY = up.z * fX - fZ * up.x
        var sZ = up.x * fY - fX * up.y
        inv = 1.0 / sqrt(sX * sX + sY * sY + sZ * sZ)
        sX *= inv
        sY *= inv
        sZ *= inv
        // u = cross(f, s)
        val uX = fY * sZ - sY * fZ
        val uY = fZ * sX - sZ * fX
        val uZ = fX * sY - sX * fY

        res put 1.0
        res[0, 0] = sX
        res[1, 0] = sY
        res[2, 0] = sZ
        res[0, 1] = uX
        res[1, 1] = uY
        res[2, 1] = uZ
        res[0, 2] = fX
        res[1, 2] = fY
        res[2, 2] = fZ
//        res[3,0] = -dot(s, eye)
        res[3, 0] = -(sX * eye.x + sY * eye.y + sZ * eye.z)
//        res[3,1] = -dot(u, eye)
        res[3, 1] = -(uX * eye.x + uY * eye.y + uZ * eye.z)
//        res[3,2] = -dot(f, eye)
        res[3, 2] = -(fX * eye.x + fY * eye.y + fZ * eye.z)
        return res
    }

    /** Build a left handed look at view matrix.
     *
     *  @param eye Position of the camera
     *  @param center Position where the camera is looking at
     *  @param up Normalized up vector, how the camera is oriented. Typically (0, 0, 1)
     *  @see gtc_matrix_transform
     *  @see - frustum(left: Float, right: Float, bottom: Float, top: Float, near: Float, far: Float)
     *  frustum(left: Float, right: Float, bottom: Float, top: Float, near: Float, far: Float)
     */
    fun lookAtLh(eye: Vec3d, center: Vec3d, up: Vec3d): Mat4d = lookAtLh(Mat4d(), eye, center, up)

    /** Build a look at view matrix based on the default handedness.
     *
     *  @param res the resulting matrix
     *  @param eye Position of the camera
     *  @param center Position where the camera is looking at
     *  @param up Normalized up vector, how the camera is oriented. Typically (0, 0, 1)
     *  @see gtc_matrix_transform
     *  @see - frustum(left: Float, right: Float, bottom: Float, top: Float, near: Float, far: Float)
     *  frustum(left: Float, right: Float, bottom: Float, top: Float, near: Float, far: Float)
     *  @see <a href="https://www.khronos.org/registry/OpenGL-Refpages/gl2.1/xhtml/gluLookAt.xml">gluLookAt man page</a>
     */
    fun lookAt(res: Mat4d, eye: Vec3d, center: Vec3d, up: Vec3d): Mat4d = when (GLM_COORDINATE_SYSTEM) {
        GlmCoordinateSystem.LEFT_HANDED -> lookAtLh(res, eye, center, up)
        else -> lookAtRh(res, eye, center, up)
    }

    /** Build a look at view matrix based on the default handedness.
     *
     *  @param res the resulting matrix
     *  @param eye Position of the camera
     *  @param center Position where the camera is looking at
     *  @param up Normalized up vector, how the camera is oriented. Typically (0, 0, 1)
     *  @see gtc_matrix_transform
     *  @see - frustum(left: Float, right: Float, bottom: Float, top: Float, near: Float, far: Float)
     *  frustum(left: Float, right: Float, bottom: Float, top: Float, near: Float, far: Float)
     *  @see <a href="https://www.khronos.org/registry/OpenGL-Refpages/gl2.1/xhtml/gluLookAt.xml">gluLookAt man page</a>
     */
    fun lookAt(eye: Vec3d, center: Vec3d, up: Vec3d): Mat4d = when (GLM_COORDINATE_SYSTEM) {
        GlmCoordinateSystem.LEFT_HANDED -> lookAtLh(Mat4d(), eye, center, up)
        else -> lookAtRh(Mat4d(), eye, center, up)
    }
}