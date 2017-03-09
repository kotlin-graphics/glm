package glm

import glm.Glm.abs
import glm.Glm.cos
import glm.Glm.inverseSqrt
import glm.Glm.sin
import glm.Glm.tan
import glm.detail.GLM_COORDINATE_SYSTEM
import glm.detail.GLM_DEPTH_CLIP_SPACE
import glm.detail.GLM_DEPTH_ZERO_TO_ONE
import glm.detail.GLM_LEFT_HANDED
import glm.mat.Mat4x4
import glm.vec._2.Vec2
import glm.vec._3.Vec3
import glm.vec._4.Vec4i

/**
 * Created by GBarbieri on 12.12.2016.
 */

interface matrix_transform {

    /**
     * Builds a translation 4 * 4 matrix created from a vector of 3 components.
     * @param m Input matrix multiplied by this translation matrix.
     * @param v Coordinates of a translation vector.
     * @param res the resulting matrix
     * @return see [res]
     */
    fun translate(res: Mat4x4, m: Mat4x4, vX: Float, vY: Float, vZ: Float): Mat4x4 {
        res put m
        res[3].x = m[0].x * vX + m[1].x * vY + m[2].x * vZ + m[3].x
        res[3].y = m[0].y * vX + m[1].y * vY + m[2].y * vZ + m[3].y
        res[3].z = m[0].z * vX + m[1].z * vY + m[2].z * vZ + m[3].z
        res[3].w = m[0].w * vX + m[1].w * vY + m[2].w * vZ + m[3].w
        return res
    }

    fun translate(m: Mat4x4, v: Vec3) = translate(Mat4x4(), m, v.x, v.y, v.z)
    fun translate(res: Mat4x4, m: Mat4x4, v: Vec3) = translate(res, m, v.x, v.y, v.z)
    fun translate(m: Mat4x4, vX: Float, vY: Float, vZ: Float) = translate(Mat4x4(), m, vX, vY, vZ)

    /**
     * Builds a rotation 4 * 4 matrix created from an axis vector main.and an angle.
     * @param m Input matrix multiplied by this rotation matrix.
     * @param angle Rotation angle expressed in radians.
     * @param v Rotation axis, recommended to be normalized.
     * @param res the resulting matrix
     * @return see [res]
     */
    fun rotate(res: Mat4x4, m: Mat4x4, angle: Float, vX: Float, vY: Float, vZ: Float): Mat4x4 {

        val c = cos(angle)
        val s = sin(angle)

        val dot = vX * vX + vY * vY + vZ * vZ
        val inv = inverseSqrt(dot)

        val axisX = vX * inv
        val axisY = vY * inv
        val axisZ = vZ * inv

        val tempX = (1f - c) * axisX
        val tempY = (1f - c) * axisY
        val tempZ = (1f - c) * axisZ

        val rotate00 = c + tempX * axisX
        val rotate01 = tempX * axisY + s * axisZ
        val rotate02 = tempX * axisZ - s * axisY

        val rotate10 = tempY * axisX - s * axisZ
        val rotate11 = c + tempY * axisY
        val rotate12 = tempY * axisZ + s * axisX

        val rotate20 = tempZ * axisX + s * axisY
        val rotate21 = tempZ * axisY - s * axisX
        val rotate22 = c + tempZ * axisZ

        val res0x = m[0].x * rotate00 + m[1].x * rotate01 + m[2].x * rotate02
        val res0y = m[0].y * rotate00 + m[1].y * rotate01 + m[2].y * rotate02
        val res0z = m[0].z * rotate00 + m[1].z * rotate01 + m[2].z * rotate02
        val res0w = m[0].w * rotate00 + m[1].w * rotate01 + m[2].w * rotate02

        val res1x = m[0].x * rotate10 + m[1].x * rotate11 + m[2].x * rotate12
        val res1y = m[0].y * rotate10 + m[1].y * rotate11 + m[2].y * rotate12
        val res1z = m[0].z * rotate10 + m[1].z * rotate11 + m[2].z * rotate12
        val res1w = m[0].w * rotate10 + m[1].w * rotate11 + m[2].w * rotate12

        val res2x = m[0].x * rotate20 + m[1].x * rotate21 + m[2].x * rotate22
        val res2y = m[0].y * rotate20 + m[1].y * rotate21 + m[2].y * rotate22
        val res2z = m[0].z * rotate20 + m[1].z * rotate21 + m[2].z * rotate22
        val res2w = m[0].w * rotate20 + m[1].w * rotate21 + m[2].w * rotate22

        res[0].x = res0x
        res[0].y = res0y
        res[0].z = res0z
        res[0].w = res0w

        res[1].x = res1x
        res[1].y = res1y
        res[1].z = res1z
        res[1].w = res1w

        res[2].x = res2x
        res[2].y = res2y
        res[2].z = res2z
        res[2].w = res2w

        res[3].x = m[3].x
        res[3].y = m[3].y
        res[3].z = m[3].z
        res[3].w = m[3].w

        return res
    }

    fun rotate(res: Mat4x4, m: Mat4x4, angle: Float, v: Vec3) = rotate(res, m, angle, v.x, v.y, v.z)
    fun rotate(m: Mat4x4, angle: Float, v: Vec3) = rotate(Mat4x4(), m, angle, v.x, v.y, v.z)
    fun rotate(m: Mat4x4, angle: Float, vX: Float, vY: Float, vZ: Float) = rotate(Mat4x4(), m, angle, vX, vY, vZ)

    /**
     * Builds a scale 4 * 4 matrix created from 3 scalars.
     *
     * @param m Input matrix multiplied by this scale matrix.
     * @param v Ratio of scaling for each axis.
     * @param res the resulting matrix
     * @return see [res]
     */
    fun scale(res: Mat4x4, m: Mat4x4, vX: Float, vY: Float, vZ: Float): Mat4x4 {

        res[0].x = m[0].x * vX
        res[0].y = m[0].y * vX
        res[0].z = m[0].z * vX
        res[0].w = m[0].w * vX

        res[1].x = m[1].x * vY
        res[1].y = m[1].y * vY
        res[1].z = m[1].z * vY
        res[1].w = m[1].w * vY

        res[2].x = m[2].x * vZ
        res[2].y = m[2].y * vZ
        res[2].z = m[2].z * vZ
        res[2].w = m[2].w * vZ

        res[3].x = m[3].x
        res[3].y = m[3].y
        res[3].z = m[3].z
        res[3].w = m[3].w

        return res
    }

    fun scale(res: Mat4x4, m: Mat4x4, v: Vec3) = scale(res, m, v.x, v.y, v.z)
    fun scale(m: Mat4x4, v: Vec3) = scale(Mat4x4(), m, v.x, v.y, v.z)
    fun scale(m: Mat4x4, vX: Float, vY: Float, vZ: Float) = scale(Mat4x4(), m, vX, vY, vZ)

    /**
     * Creates a matrix for an orthographic parallel viewing volume, using the default handedness.
     *
     *  @param left
     *  @param right
     *  @param bottom
     *  @param top
     *  @param zNear
     *  @param zFar
     *  @param res the resulting matrix
     *  @return see [res]
     */
    fun ortho(res: Mat4x4, left: Float, right: Float, bottom: Float, top: Float, zNear: Float, zFar: Float) =
            if (GLM_COORDINATE_SYSTEM == GLM_LEFT_HANDED)
                orthoLH(res, left, right, bottom, top, zNear, zFar)
            else
                orthoRH(res, left, right, bottom, top, zNear, zFar)

    fun ortho(left: Float, right: Float, bottom: Float, top: Float, zNear: Float, zFar: Float) = ortho(Mat4x4(), left, right, bottom, top, zNear, zFar)

    /**
     * Creates a matrix for an orthographic parallel viewing volume, using left-handedness.
     *
     *  @param left
     *  @param right
     *  @param bottom
     *  @param top
     *  @param zNear
     *  @param zFar
     *  @param res the resulting matrix
     *  @return see [res]
     */
    fun orthoLH(res: Mat4x4, left: Float, right: Float, bottom: Float, top: Float, zNear: Float, zFar: Float): Mat4x4 {

        res put 1f

        res[0][0] = 2f / (right - left)
        res[1][1] = 2f / (top - bottom)
        res[3][0] = -(right + left) / (right - left)
        res[3][1] = -(top + bottom) / (top - bottom)

        if (GLM_DEPTH_CLIP_SPACE == GLM_DEPTH_ZERO_TO_ONE) {
            res[2][2] = 1f / (zFar - zNear)
            res[3][2] = -zNear / (zFar - zNear)
        } else {
            res[2][2] = 2f / (zFar - zNear)
            res[3][2] = -(zFar + zNear) / (zFar - zNear)
        }

        return res
    }

    /**
     * Creates a matrix for an orthographic parallel viewing volume, using right-handedness.
     *
     *  @param left
     *  @param right
     *  @param bottom
     *  @param top
     *  @param zNear
     *  @param zFar
     *  @param res the resulting matrix
     *  @return see [res]
     */
    fun orthoRH(res: Mat4x4, left: Float, right: Float, bottom: Float, top: Float, zNear: Float, zFar: Float): Mat4x4 {

        res put 1f

        res[0][0] = 2f / (right - left)
        res[1][1] = 2f / (top - bottom)
        res[3][0] = -(right + left) / (right - left)
        res[3][1] = -(top + bottom) / (top - bottom)

        if (GLM_DEPTH_CLIP_SPACE == GLM_DEPTH_ZERO_TO_ONE) {
            res[2][2] = -1f / (zFar - zNear)
            res[3][2] = -zNear / (zFar - zNear)
        } else {
            res[2][2] = -2f / (zFar - zNear)
            res[3][2] = -(zFar + zNear) / (zFar - zNear)
        }

        return res
    }

    /**
     * Creates a matrix for projecting two-dimensional coordinates onto the screen.
     *
     *  @param left
     *  @param right
     *  @param bottom
     *  @param top
     *  @param res the resulting matrix
     *  @return see [res]
     */
    fun ortho(res: Mat4x4, left: Float, right: Float, bottom: Float, top: Float): Mat4x4 {

        res put 1f

        res[0][0] = 2f / (right - left)
        res[1][1] = 2f / (top - bottom)
        res[2][2] = -1f
        res[3][0] = -(right + left) / (right - left)
        res[3][1] = -(top + bottom) / (top - bottom)

        return res
    }

    fun ortho(left: Float, right: Float, bottom: Float, top: Float) = ortho(Mat4x4(), left, right, bottom, top)

    /**
     * Creates a frustum matrix with default handedness.
     *
     *  @param left
     *  @param right
     *  @param bottom
     *  @param top
     *  @param near
     *  @param far
     *  @param res the resulting matrix
     *  @return [res]
     */
    fun frustum(res: Mat4x4, left: Float, right: Float, bottom: Float, top: Float, near: Float, far: Float) =
            if (GLM_COORDINATE_SYSTEM == GLM_LEFT_HANDED)
                frustumLH(res, left, right, bottom, top, near, far)
            else
                frustumRH(res, left, right, bottom, top, near, far)

    fun frustum(left: Float, right: Float, bottom: Float, top: Float, near: Float, far: Float) = frustum(Mat4x4(), left, right, bottom, top, near, far)

    /**
     * Creates a left handed frustum matrix.
     *
     *  @param left
     *  @param right
     *  @param bottom
     *  @param top
     *  @param near
     *  @param far
     *  @param res the resulting matrix
     *  @return [res]
     */
    fun frustumLH(res: Mat4x4, left: Float, right: Float, bottom: Float, top: Float, near: Float, far: Float): Mat4x4 {

        res put 0f

        res[0][0] = (2f * near) / (right - left)
        res[1][1] = (2f * near) / (top - bottom)
        res[2][0] = (right + left) / (right - left)
        res[2][1] = (top + bottom) / (top - bottom)
        res[2][3] = 1f

        if (GLM_DEPTH_CLIP_SPACE == GLM_DEPTH_ZERO_TO_ONE) {
            res[2][2] = far / (far - near)
            res[3][2] = -(far * near) / (far - near)
        } else {
            res[2][2] = (far + near) / (far - near)
            res[3][2] = -(2f * far * near) / (far - near)
        }

        return res
    }

    /**
     * Creates a right handed frustum matrix.
     *
     *  @param left
     *  @param right
     *  @param bottom
     *  @param top
     *  @param near
     *  @param far
     *  @param res the resulting matrix
     *  @return [res]
     */
    fun frustumRH(res: Mat4x4, left: Float, right: Float, bottom: Float, top: Float, near: Float, far: Float): Mat4x4 {

        res put 0f

        res[0][0] = (2f * near) / (right - left)
        res[1][1] = (2f * near) / (top - bottom)
        res[2][0] = (right + left) / (right - left)
        res[2][1] = (top + bottom) / (top - bottom)
        res[2][3] = -1f

        if (GLM_DEPTH_CLIP_SPACE == GLM_DEPTH_ZERO_TO_ONE) {
            res[2][2] = far / (near - far)
            res[3][2] = -(far * near) / (far - near)
        } else {
            res[2][2] = -(far + near) / (far - near)
            res[3][2] = -(2f * far * near) / (far - near)
        }

        return res
    }


    /**
     * Creates a matrix for a symetric perspective-view frustum based on the default handedness.
     *
     *  @param fovy Specifies the field of view angle in the y direction. Expressed in radians.
     *  @param aspect Specifies the aspect ratio that determines the field of view in the x direction. The aspect ratio
     *                      is the ratio of x (width) to y (height).
     *  @param zNear Specifies the distance from the viewer to the near clipping plane (always positive).
     *  @param zFar Specifies the distance from the viewer to the far clipping plane (always positive).
     *  @param res the resulting matrix
     *  @return [res]
     */
    fun perspective(res: Mat4x4, fovy: Float, aspect: Float, zNear: Float, zFar: Float) =
            if (GLM_COORDINATE_SYSTEM == GLM_LEFT_HANDED)
                perspectiveLH(res, fovy, aspect, zNear, zFar)
            else
                perspectiveRH(res, fovy, aspect, zNear, zFar)

    fun perspective(fovy: Float, aspect: Float, zNear: Float, zFar: Float) = perspective(Mat4x4(), fovy, aspect, zNear, zFar)

    /**
     * Creates a left handed frustum matrix.
     *
     *  @param fovy Specifies the field of view angle in the y direction. Expressed in radians.
     *  @param aspect Specifies the aspect ratio that determines the field of view in the x direction. The aspect ratio
     *                      is the ratio of x (width) to y (height).
     *  @param zNear Specifies the distance from the viewer to the near clipping plane (always positive).
     *  @param zFar Specifies the distance from the viewer to the far clipping plane (always positive).
     *  @param res the resulting matrix
     *  @return [res]
     */
    fun perspectiveRH(res: Mat4x4, fovy: Float, aspect: Float, zNear: Float, zFar: Float): Mat4x4 {

        assert(abs(aspect - glm.epsilonF) > 0f)

        val tanHalfFovy = tan(fovy / 2f)

        res put 0f

        res[0][0] = 1f / (aspect * tanHalfFovy)
        res[1][1] = 1f / tanHalfFovy
        res[2][3] = -1f

        if (GLM_DEPTH_CLIP_SPACE == GLM_DEPTH_ZERO_TO_ONE) {
            res[2][2] = zFar / (zNear - zFar)
            res[3][2] = -(zFar * zNear) / (zFar - zNear)
        } else {
            res[2][2] = -(zFar + zNear) / (zFar - zNear)
            res[3][2] = -(2f * zFar * zNear) / (zFar - zNear)
        }

        return res
    }

    /**
     * Creates a right handed frustum matrix.
     *
     *  @param fovy Specifies the field of view angle in the y direction. Expressed in radians.
     *  @param aspect Specifies the aspect ratio that determines the field of view in the x direction. The aspect ratio
     *                      is the ratio of x (width) to y (height).
     *  @param zNear Specifies the distance from the viewer to the near clipping plane (always positive).
     *  @param zFar Specifies the distance from the viewer to the far clipping plane (always positive).
     *  @param res the resulting matrix
     *  @return [res]
     */
    fun perspectiveLH(res: Mat4x4, fovy: Float, aspect: Float, zNear: Float, zFar: Float): Mat4x4 {

        assert(abs(aspect - glm.epsilonF) > 0f)

        val tanHalfFovy = tan(fovy / 2f)

        res put 0f

        res[0][0] = 1f / (aspect * tanHalfFovy)
        res[1][1] = 1f / tanHalfFovy
        res[2][3] = 1f

        if (GLM_DEPTH_CLIP_SPACE == GLM_DEPTH_ZERO_TO_ONE) {
            res[2][2] = zFar / (zFar - zNear)
            res[3][2] = -(zFar * zNear) / (zFar - zNear)
        } else {
            res[2][2] = (zFar + zNear) / (zFar - zNear)
            res[3][2] = -(2f * zFar * zNear) / (zFar - zNear)
        }

        return res
    }

    /**
     * Builds a perspective projection matrix based on a field of view main.and the default handedness.
     *
     *  @param fov Expressed in radians.
     *  @param width
     *  @param height
     *  @param zNear Specifies the distance from the viewer to the near clipping plane (always positive).
     *  @param zFar Specifies the distance from the viewer to the far clipping plane (always positive).
     *  @param res the resulting matrix
     *  @return [res]
     */
    fun perspectiveFov(res: Mat4x4, fov: Float, width: Float, height: Float, zNear: Float, zFar: Float) =
            if (GLM_COORDINATE_SYSTEM == GLM_LEFT_HANDED)
                perspectiveFovLH(res, fov, width, height, zNear, zFar)
            else
                perspectiveFovRH(res, fov, width, height, zNear, zFar)

    fun perspectiveFov(fov: Float, width: Float, height: Float, zNear: Float, zFar: Float) = perspectiveFov(Mat4x4(), fov, width, height, zNear, zFar)

    /**
     * Builds a right handed perspective projection matrix based on a field of view.
     *
     *  @param fov Expressed in radians.
     *  @param width
     *  @param height
     *  @param zNear Specifies the distance from the viewer to the near clipping plane (always positive).
     *  @param zFar Specifies the distance from the viewer to the far clipping plane (always positive).
     *  @param res the resulting matrix
     *  @return [res]
     */
    fun perspectiveFovRH(res: Mat4x4, fov: Float, width: Float, height: Float, zNear: Float, zFar: Float): Mat4x4 {

        assert(width > 0f && height > 0f && fov > 0f)

        val h = cos(0.5f * fov) / sin(0.5f * fov)
        val w = h * height / width  //TODO max(width , Height) / min(width , Height)?

        res put 0f

        res[0][0] = w
        res[1][1] = h
        res[2][3] = -1f

        if (GLM_DEPTH_CLIP_SPACE == GLM_DEPTH_ZERO_TO_ONE) {
            res[2][2] = zFar / (zNear - zFar)
            res[3][2] = -(zFar * zNear) / (zFar - zNear)
        } else {
            res[2][2] = -(zFar + zNear) / (zFar - zNear)
            res[3][2] = -(2f * zFar * zNear) / (zFar - zNear)
        }

        return res
    }

    /**
     * Builds a left handed perspective projection matrix based on a field of view.
     *
     *  @param fov Expressed in radians.
     *  @param width
     *  @param height
     *  @param zNear Specifies the distance from the viewer to the near clipping plane (always positive).
     *  @param zFar Specifies the distance from the viewer to the far clipping plane (always positive).
     *  @param res the resulting matrix
     *  @return [res]
     */
    fun perspectiveFovLH(res: Mat4x4, fov: Float, width: Float, height: Float, zNear: Float, zFar: Float): Mat4x4 {

        assert(width > 0f && height > 0f && fov > 0f)

        val h = cos(0.5f * fov) / sin(0.5f * fov)
        val w = h * height / width  //TODO max(width , Height) / min(width , Height)?

        res put 0f

        res[0][0] = w
        res[1][1] = h
        res[2][3] = 1f

        if (GLM_DEPTH_CLIP_SPACE == GLM_DEPTH_ZERO_TO_ONE) {
            res[2][2] = zFar / (zFar - zNear)
            res[3][2] = -(zFar * zNear) / (zFar - zNear)
        } else {
            res[2][2] = (zFar + zNear) / (zFar - zNear)
            res[3][2] = -(2f * zFar * zNear) / (zFar - zNear)
        }

        return res
    }

    /**
     * Creates a matrix for a symmetric perspective-view frustum with far plane at infinite with default handedness.
     *
     * @param fovy Specifies the field of view angle, in degrees, in the y direction. Expressed in radians.
     * @param aspect Specifies the aspect ratio that determines the field of view in the x direction. The aspect ratio is the ratio of x (width) to y (height).
     * @param zNear Specifies the distance from the viewer to the near clipping plane (always positive).
     * @param res the resulting matrix
     * @return [res]
     */
    fun infinitePerspective(res: Mat4x4, fovy: Float, aspect: Float, zNear: Float) =
            if (GLM_COORDINATE_SYSTEM == GLM_LEFT_HANDED)
                infinitePerspectiveLH(res, fovy, aspect, zNear)
            else
                infinitePerspectiveRH(res, fovy, aspect, zNear)

    fun infinitePerspective(fovy: Float, aspect: Float, zNear: Float) = infinitePerspective(Mat4x4(), fovy, aspect, zNear)

    /**
     * Builds a right handed perspective projection matrix based on a field of view.
     *
     * @param fovy Specifies the field of view angle, in degrees, in the y direction. Expressed in radians.
     * @param aspect Specifies the aspect ratio that determines the field of view in the x direction. The aspect ratio is the ratio of x (width) to y (height).
     * @param zNear Specifies the distance from the viewer to the near clipping plane (always positive).
     * @param res the resulting matrix
     * @return [res]
     */
    fun infinitePerspectiveRH(res: Mat4x4, fovy: Float, aspect: Float, zNear: Float): Mat4x4 {

        val range = tan(fovy / 2f) * zNear
        val left = -range * aspect
        val right = range * aspect
        val bottom = -range
        val top = range

        res put 0f
        res[0][0] = (2f * zNear) / (right - left)
        res[1][1] = (2f * zNear) / (top - bottom)
        res[2][2] = -1f
        res[2][3] = -1f
        res[3][2] = -2f * zNear

        return res
    }

    /**
     * Builds a left handed perspective projection matrix based on a field of view.
     *
     * @param fovy Specifies the field of view angle, in degrees, in the y direction. Expressed in radians.
     * @param aspect Specifies the aspect ratio that determines the field of view in the x direction. The aspect ratio is the ratio of x (width) to y (height).
     * @param zNear Specifies the distance from the viewer to the near clipping plane (always positive).
     * @param res the resulting matrix
     * @return [res]
     */
    fun infinitePerspectiveLH(res: Mat4x4, fovy: Float, aspect: Float, zNear: Float): Mat4x4 {

        val range = tan(fovy / 2f) * zNear
        val left = -range * aspect
        val right = range * aspect
        val bottom = -range
        val top = range

        res put 0f
        res[0][0] = (2f * zNear) / (right - left)
        res[1][1] = (2f * zNear) / (top - bottom)
        res[2][2] = 1f
        res[2][3] = 1f
        res[3][2] = -2f * zNear

        return res
    }

    /**
     * Creates a matrix for a symmetric perspective-view frustum with far plane at infinite for graphics hardware that doesn't support depth clamping.
     *
     * @param fovy Specifies the field of view angle, in degrees, in the y direction. Expressed in radians.
     * @param aspect Specifies the aspect ratio that determines the field of view in the x direction. The aspect ratio is the ratio of x (width) to y (height).
     * @param zNear Specifies the distance from the viewer to the near clipping plane (always positive).
     * @param res the resulting matrix
     * @return [res]
     */
    fun tweakedInfinitePerspective(res: Mat4x4, fovy: Float, aspect: Float, zNear: Float) = tweakedInfinitePerspective(res, fovy, aspect, zNear, glm.epsilonF)

    fun tweakedInfinitePerspective(fovy: Float, aspect: Float, zNear: Float) = tweakedInfinitePerspective(Mat4x4(), fovy, aspect, zNear, glm.epsilonF)

    /**
     * Creates a matrix for a symmetric perspective-view frustum with far plane at infinite for graphics hardware that doesn't support depth clamping.
     *
     * @param fovy Specifies the field of view angle, in degrees, in the y direction. Expressed in radians.
     * @param aspect Specifies the aspect ratio that determines the field of view in the x direction. The aspect ratio is the ratio of x (width) to y (height).
     * @param zNear Specifies the distance from the viewer to the near clipping plane (always positive).#
     * @param ep
     * @param res the resulting matrix
     * @return [res]
     */
    fun tweakedInfinitePerspective(res: Mat4x4, fovy: Float, aspect: Float, zNear: Float, ep: Float): Mat4x4 {

        val range = tan(fovy / 2f) * zNear
        val left = -range * aspect
        val right = range * aspect
        val bottom = -range
        val top = range

        res put 0f
        res[0][0] = (2f * zNear) / (right - left)
        res[1][1] = (2f * zNear) / (top - bottom)
        res[2][2] = ep - 1f
        res[2][3] = -1f
        res[3][2] = (ep - 2f) * zNear
        return res
    }

    fun tweakedInfinitePerspective(fovy: Float, aspect: Float, zNear: Float, ep: Float) = tweakedInfinitePerspective(Mat4x4(), fovy, aspect, zNear, ep)

    /**
     * Map the specified object coordinates (obj.x, obj.y, obj.z) into window coordinates.
     *
     * @param obj Specify the object coordinates.
     * @param model Specifies the current modelview matrix
     * @param proj Specifies the current projection matrix
     * @param viewport Specifies the current viewport
     * @param res the computed window coordinates.
     * @return [res]
     */
    fun project(res: Vec3, obj: Vec3, model: Mat4x4, proj: Mat4x4, viewport: Vec4i): Vec3 {

        // tmp = model * obj
        val tmpX = model[0][0] * obj.x + model[1][0] * obj.y + model[2][0] * obj.z + model[3][0]
        val tmpY = model[0][1] * obj.x + model[1][1] * obj.y + model[2][1] * obj.z + model[3][1]
        val tmpZ = model[0][2] * obj.x + model[1][2] * obj.y + model[2][2] * obj.z + model[3][2]
        val tmpW = model[0][3] * obj.x + model[1][3] * obj.y + model[2][3] * obj.z + model[3][3]
        // res = proj * tmp
        res.x = proj[0][0] * tmpX + proj[1][0] * tmpY + proj[2][0] * tmpZ + proj[3][0] * tmpW
        res.y = proj[0][1] * tmpX + proj[1][1] * tmpY + proj[2][1] * tmpZ + proj[3][1] * tmpW
        res.z = proj[0][2] * tmpX + proj[1][2] * tmpY + proj[2][2] * tmpZ + proj[3][2] * tmpW
        //val tmpW = proj[0][3] * tmpX + proj[1][3] * tmpY + proj[2][3] * tmpZ + proj[3][3] * tmpW

        res div_ tmpW

        res.x = res.x * 0.5f + 0.5f
        res.y = res.y * 0.5f + 0.5f

        if (GLM_DEPTH_CLIP_SPACE != GLM_DEPTH_ZERO_TO_ONE)
            res.z = res.z * 0.5f + 0.5f

        res[0] = res[0] * viewport[2] + viewport[0]
        res[1] = res[1] * viewport[3] + viewport[1]

        return res
    }

    fun project(obj: Vec3, model: Mat4x4, proj: Mat4x4, viewport: Vec4i) = project(Vec3(), obj, model, proj, viewport)

    /**
     * Map the specified window coordinates (win.x, win.y, win.z) into object coordinates.
     *
     * @param win Specify the window coordinates to be mapped.
     * @param model Specifies the modelview matrix
     * @param proj Specifies the projection matrix
     * @param viewport Specifies the viewport
     * @param res the computed object coordinates.
     * @return [res]
     */
    fun unProject(res: Vec3, win: Vec3, model: Mat4x4, proj: Mat4x4, viewport: Vec4i): Vec3 {

        // pm = proj * model
        val pm00 = proj[0][0] * model[0][0] + proj[1][0] * model[0][1] + proj[2][0] * model[0][2] + proj[3][0] * model[0][3]
        val pm01 = proj[0][1] * model[0][0] + proj[1][1] * model[0][1] + proj[2][1] * model[0][2] + proj[3][1] * model[0][3]
        val pm02 = proj[0][2] * model[0][0] + proj[1][2] * model[0][1] + proj[2][2] * model[0][2] + proj[3][2] * model[0][3]
        val pm03 = proj[0][3] * model[0][0] + proj[1][3] * model[0][1] + proj[2][3] * model[0][2] + proj[3][3] * model[0][3]
        val pm10 = proj[0][0] * model[1][0] + proj[1][0] * model[1][1] + proj[2][0] * model[1][2] + proj[3][0] * model[1][3]
        val pm11 = proj[0][1] * model[1][0] + proj[1][1] * model[1][1] + proj[2][1] * model[1][2] + proj[3][1] * model[1][3]
        val pm12 = proj[0][2] * model[1][0] + proj[1][2] * model[1][1] + proj[2][2] * model[1][2] + proj[3][2] * model[1][3]
        val pm13 = proj[0][3] * model[1][0] + proj[1][3] * model[1][1] + proj[2][3] * model[1][2] + proj[3][3] * model[1][3]
        val pm20 = proj[0][0] * model[2][0] + proj[1][0] * model[2][1] + proj[2][0] * model[2][2] + proj[3][0] * model[2][3]
        val pm21 = proj[0][1] * model[2][0] + proj[1][1] * model[2][1] + proj[2][1] * model[2][2] + proj[3][1] * model[2][3]
        val pm22 = proj[0][2] * model[2][0] + proj[1][2] * model[2][1] + proj[2][2] * model[2][2] + proj[3][2] * model[2][3]
        val pm23 = proj[0][3] * model[2][0] + proj[1][3] * model[2][1] + proj[2][3] * model[2][2] + proj[3][3] * model[2][3]
        val pm30 = proj[0][0] * model[3][0] + proj[1][0] * model[3][1] + proj[2][0] * model[3][2] + proj[3][0] * model[3][3]
        val pm31 = proj[0][1] * model[3][0] + proj[1][1] * model[3][1] + proj[2][1] * model[3][2] + proj[3][1] * model[3][3]
        val pm32 = proj[0][2] * model[3][0] + proj[1][2] * model[3][1] + proj[2][2] * model[3][2] + proj[3][2] * model[3][3]
        val pm33 = proj[0][3] * model[3][0] + proj[1][3] * model[3][1] + proj[2][3] * model[3][2] + proj[3][3] * model[3][3]

        // inverse(pm)
        val c00 = pm22 * pm33 - pm32 * pm23
        val c02 = pm12 * pm33 - pm32 * pm13
        val c03 = pm12 * pm23 - pm22 * pm13

        val c04 = pm21 * pm33 - pm31 * pm23
        val c06 = pm11 * pm33 - pm31 * pm13
        val c07 = pm11 * pm23 - pm21 * pm13

        val c08 = pm21 * pm32 - pm31 * pm22
        val c10 = pm11 * pm32 - pm31 * pm12
        val c11 = pm11 * pm22 - pm21 * pm12

        val c12 = pm20 * pm33 - pm30 * pm23
        val c14 = pm10 * pm33 - pm30 * pm13
        val c15 = pm10 * pm23 - pm20 * pm13

        val c16 = pm20 * pm32 - pm30 * pm22
        val c18 = pm10 * pm32 - pm30 * pm12
        val c19 = pm10 * pm22 - pm20 * pm12

        val c20 = pm20 * pm31 - pm30 * pm21
        val c22 = pm10 * pm31 - pm30 * pm11
        val c23 = pm10 * pm21 - pm20 * pm11

        var i00 = +(pm11 * c00 - pm12 * c04 + pm13 * c08)
        var i01 = -(pm01 * c00 - pm02 * c04 + pm03 * c08)
        var i02 = +(pm01 * c02 - pm02 * c06 + pm03 * c10)
        var i03 = -(pm01 * c03 - pm02 * c07 + pm03 * c11)

        var i10 = -(pm10 * c00 - pm12 * c12 + pm13 * c16)
        var i11 = +(pm00 * c00 - pm02 * c12 + pm03 * c16)
        var i12 = -(pm00 * c02 - pm02 * c14 + pm03 * c18)
        var i13 = +(pm00 * c03 - pm02 * c15 + pm03 * c19)

        var i20 = +(pm10 * c04 - pm11 * c12 + pm13 * c20)
        var i21 = -(pm00 * c04 - pm01 * c12 + pm03 * c20)
        var i22 = +(pm00 * c06 - pm01 * c14 + pm03 * c22)
        var i23 = -(pm00 * c07 - pm01 * c15 + pm03 * c23)

        var i30 = -(pm10 * c08 - pm11 * c16 + pm12 * c20)
        var i31 = +(pm00 * c08 - pm01 * c16 + pm02 * c20)
        var i32 = -(pm00 * c10 - pm01 * c18 + pm02 * c22)
        var i33 = +(pm00 * c11 - pm01 * c19 + pm02 * c23)

        val oneOverDet = 1 / (pm00 * i00 + pm01 * i10 + pm02 * i20 + pm03 * i30)

        i00 *= oneOverDet
        i01 *= oneOverDet
        i02 *= oneOverDet
        i03 *= oneOverDet

        i10 *= oneOverDet
        i11 *= oneOverDet
        i12 *= oneOverDet
        i13 *= oneOverDet

        i20 *= oneOverDet
        i21 *= oneOverDet
        i22 *= oneOverDet
        i23 *= oneOverDet

        i30 *= oneOverDet
        i31 *= oneOverDet
        i32 *= oneOverDet
        i33 *= oneOverDet

        var tmpX = win.x
        var tmpY = win.y
        var tmpZ = win.z
        val tmpW = 1f

        tmpX = (tmpX - viewport[0]) / viewport[2]
        tmpY = (tmpY - viewport[1]) / viewport[3]

        tmpX = tmpX * 2f - 1f
        tmpY = tmpY * 2f - 1f

        if (GLM_DEPTH_CLIP_SPACE != GLM_DEPTH_ZERO_TO_ONE)
            tmpZ = tmpZ * 2f - 1f

        // obj = inverse * tmp
        val objX = i00 * tmpX + i10 * tmpY + i20 * tmpZ + i30 * tmpW
        val objY = i01 * tmpX + i11 * tmpY + i21 * tmpZ + i31 * tmpW
        val objZ = i02 * tmpX + i12 * tmpY + i22 * tmpZ + i32 * tmpW
        val objW = i03 * tmpX + i13 * tmpY + i23 * tmpZ + i33 * tmpW

        res.put(objX, objY, objZ)

        return res div_ objW
    }

    fun unProject(win: Vec3, model: Mat4x4, proj: Mat4x4, viewport: Vec4i) = unProject(Vec3(), win, model, proj, viewport)

    /**
     * Define a picking region
     *
     * @param center
     * @param delta
     * @param viewport
     * @param res the resulting matrix.
     * @return [res]
     */
    fun pickMatrix(res: Mat4x4, center: Vec2, delta: Vec2, viewport: Vec4i): Mat4x4 {

        res put 1f

        if (!(delta.x > 0f && delta.y > 0f))
            throw ArithmeticException()

        val tempX = (viewport[2] - 2f * (center.x - viewport[0])) / delta.x
        val tempY = (viewport[3] - 2f * (center.y - viewport[1])) / delta.y
        val tempZ = 0f

        // Translate main.and scale the picked region to the entire window
        res.translate_(tempX, tempY, tempZ)
        return res.scale_(viewport[2] / delta.x, viewport[3] / delta.y, 1f)
    }

    fun pickMatrix(center: Vec2, delta: Vec2, viewport: Vec4i) = pickMatrix(Mat4x4(), center, delta, viewport)


    /** Build a look at view matrix based on the default handedness.
     *
     * @param eye Position of the camera
     * @param center Position where the camera is looking at
     * @param up Normalized up vector, how the camera is oriented. Typically (0, 0, 1)
     * @see gtc_matrix_transform
     * @see - frustum(left, right, bottom, top, nearVal, farVal) frustum(left, right, bottom, top, nearVal, farVal) */
    fun lookAt(res: Mat4x4, eye: Vec3, center: Vec3, up: Vec3) =
            if(GLM_COORDINATE_SYSTEM == GLM_LEFT_HANDED)
                lookAtLH(res, eye, center, up)
            else
                lookAtRH(res, eye, center, up)

    fun lookAt(eye: Vec3, center: Vec3, up: Vec3) = lookAt(Mat4x4(), eye, center, up)

    /** Build a right handed look at view matrix.
     *
     * @param eye Position of the camera
     * @param center Position where the camera is looking at
     * @param up Normalized up vector, how the camera is oriented. Typically (0, 0, 1)
     * @see gtc_matrix_transform
     * @see - frustum(left, right, bottom, top, nearVal, farVal) frustum(left, right, bottom, top, nearVal, farVal) */
    fun lookAtRH(res: Mat4x4, eye: Vec3, center: Vec3, up: Vec3): Mat4x4 {

        val ceX = center.x - eye.x
        val ceY = center.y - eye.y
        val ceZ = center.z - eye.z

        var dot = ceX * ceX + ceY * ceY + ceZ * ceZ
        var invSpqr = glm.inverseSqrt(dot)
        val fX = ceX * invSpqr
        val fY = ceY * invSpqr
        val fZ = ceZ * invSpqr

        val fuX = fY * up.z - up.y * fZ
        val fuY = fZ * up.x - up.z * fX
        val fuZ = fX * up.y - up.x * fY
        dot = fuX * fuX + fuY * fuY + fuZ * fuZ
        invSpqr = glm.inverseSqrt(dot)
        val sX = fuX * invSpqr
        val sY = fuY * invSpqr
        val sZ = fuZ * invSpqr

        val uX = sY * fZ - fY * sZ
        val uY = sZ * fX - fZ * sX
        val uZ = sX * fY - fX * sY

        res put 1f

        res[0][0] = sX
        res[1][0] = sY
        res[2][0] = sZ
        res[0][1] = uX
        res[1][1] = uY
        res[2][1] = uZ
        res[0][2] = -fX
        res[1][2] = -fY
        res[2][2] = -fZ
        res[3][0] = -(sX * eye.x + sY * eye.y + sZ * eye.z)
        res[3][1] = -(uX * eye.x + uY * eye.y + uZ * eye.z)
        res[3][2] = fX * eye.x + fY * eye.y + fZ * eye.z

        return res
    }

    /** Build a left handed look at view matrix.
     *
     * @param eye Position of the camera
     * @param center Position where the camera is looking at
     * @param up Normalized up vector, how the camera is oriented. Typically (0, 0, 1)
     * @see gtc_matrix_transform
     * @see - frustum(left, right, bottom, top, nearVal, farVal) frustum(left, right, bottom, top, nearVal, farVal) */
    fun lookAtLH(res: Mat4x4, eye: Vec3, center: Vec3, up: Vec3): Mat4x4 {

        val ceX = center.x - eye.x
        val ceY = center.y - eye.y
        val ceZ = center.z - eye.z

        var dot = ceX * ceX + ceY * ceY + ceZ * ceZ
        var invSpqr = glm.inverseSqrt(dot)
        val fX = ceX * invSpqr
        val fY = ceY * invSpqr
        val fZ = ceZ * invSpqr

        val ufX = up.y * fZ - fY * up.z
        val ufY = up.z * fX - fZ * up.x
        val ufZ = up.x * fY - fX * up.y
        dot = ufX * ufX + ufY * ufY + ufZ * ufZ
        invSpqr = glm.inverseSqrt(dot)
        val sX = ufX * invSpqr
        val sY = ufY * invSpqr
        val sZ = ufZ * invSpqr

        val uX = fY * sZ - sY * fZ
        val uY = fZ * sX - sZ * fX
        val uZ = fX * sY - sX * fY

        res put 1f

        res[0][0] = sX
        res[1][0] = sY
        res[2][0] = sZ
        res[0][1] = uX
        res[1][1] = uY
        res[2][1] = uZ
        res[0][2] = fX
        res[1][2] = fY
        res[2][2] = fZ
        res[3][0] = -(sX * eye.x + sY * eye.y + sZ * eye.z)
        res[3][1] = -(uX * eye.x + uY * eye.y + uZ * eye.z)
        res[3][2] = -(fX * eye.x + fY * eye.y + fZ * eye.z)

        return res
    }
}