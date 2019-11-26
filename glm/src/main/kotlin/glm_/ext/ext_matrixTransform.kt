package glm_.ext

import glm_.detail.GLM_COORDINATE_SYSTEM
import glm_.detail.GlmCoordinateSystem
import glm_.glm
import glm_.mat3x3.Mat3
import glm_.mat3x3.Mat3d
import glm_.mat4x4.Mat4
import glm_.mat4x4.Mat4d
import glm_.vec2.Vec2
import glm_.vec2.Vec2d
import glm_.vec3.Vec3
import glm_.vec3.Vec3d
import glm_.vec4.Vec4i
import kotlin.math.cos
import kotlin.math.sin
import kotlin.math.sqrt


interface ext_matrixTransform {

    /** Builds a translation 4 * 4 matrix created from a vector of 3 components.
     *
     *  @param res resulting matrix.
     *  @param m Input matrix multiplied by this translation matrix.
     *  @param vX X Coordinate of a translation vector.
     *  @param vY Y Coordinate of a translation vector.
     *  @param vZ Z Coordinate of a translation vector.
     *
     *  val m = glm.translate(Mat4(1f), Vec3(1f))
     *
     *  where m is
     *
     *      1  0  0  0
     *      0  1  0  0
     *      0  0  1  0
     *      1  1  1  1
     *
     *  @see gtc_matrix_transform
     *  @see - translate(m: Mat4, x: Float, y: Float, z: Float)
     *  @see - translate(v: Vec3)
     *  @see <a href="https://www.khronos.org/registry/OpenGL-Refpages/gl2.1/xhtml/glTranslate.xml">glTranslate man page</a>
     */
    fun translate(m: Mat4, vX: Float, vY: Float, vZ: Float, res: Mat4): Mat4 {
        if (res !== m) res put m
        val x = m[0, 0] * vX + m[1, 0] * vY + m[2, 0] * vZ + m[3, 0]
        val y = m[0, 1] * vX + m[1, 1] * vY + m[2, 1] * vZ + m[3, 1]
        val z = m[0, 2] * vX + m[1, 2] * vY + m[2, 2] * vZ + m[3, 2]
        val w = m[0, 3] * vX + m[1, 3] * vY + m[2, 3] * vZ + m[3, 3]
        res[3, 0] = x
        res[3, 1] = y
        res[3, 2] = z
        res[3, 3] = w
        return res
    }

    /** Builds a translation 4 * 4 matrix created from a vector of 3 components.
     *
     *  @param res resulting matrix.
     *  @param m Input matrix multiplied by this translation matrix.
     *  @param v Coordinates of a translation vector.
     *
     *  val m = glm.translate(Mat4(1f), Vec3(1f))
     *
     *  where m is
     *
     *      1  0  0  0
     *      0  1  0  0
     *      0  0  1  0
     *      1  1  1  1
     *
     *  @see gtc_matrix_transform
     *  @see - translate(m: Mat4, x: Float, y: Float, z: Float)
     *  @see - translate(v: Vec3)
     *  @see <a href="https://www.khronos.org/registry/OpenGL-Refpages/gl2.1/xhtml/glTranslate.xml">glTranslate man page</a>
     */
    fun translate(m: Mat4, v: Vec3, res: Mat4): Mat4 =
            translate(m, v.x, v.y, v.z, res)

    /** Builds a translation 4 * 4 matrix created from a vector of 3 components.
     *
     *  @param m Input matrix multiplied by this translation matrix.
     *  @param vX X Coordinate of a translation vector.
     *  @param vY Y Coordinate of a translation vector.
     *  @param vZ Z Coordinate of a translation vector.
     *
     *  val m = glm.translate(Mat4(1f), Vec3(1f))
     *
     *  where m is
     *
     *      1  0  0  0
     *      0  1  0  0
     *      0  0  1  0
     *      1  1  1  1
     *
     *  @see gtc_matrix_transform
     *  @see - translate(m: Mat4, x: Float, y: Float, z: Float)
     *  @see - translate(v: Vec3)
     *  @see <a href="https://www.khronos.org/registry/OpenGL-Refpages/gl2.1/xhtml/glTranslate.xml">glTranslate man page</a>
     */
    fun translate(m: Mat4, vX: Float, vY: Float, vZ: Float): Mat4 =
            translate(m, vX, vY, vZ, Mat4())

    /** Builds a translation 4 * 4 matrix created from a vector of 3 components.
     *
     *  @param m Input matrix multiplied by this translation matrix.
     *  @param v Coordinates of a translation vector.
     *
     *  val m = glm.translate(Mat4(1f), Vec3(1f))
     *
     *  where m is
     *
     *      1  0  0  0
     *      0  1  0  0
     *      0  0  1  0
     *      1  1  1  1
     *
     *  @see gtc_matrix_transform
     *  @see - translate(m: Mat4, x: Float, y: Float, z: Float)
     *  @see - translate(v: Vec3)
     *  @see <a href="https://www.khronos.org/registry/OpenGL-Refpages/gl2.1/xhtml/glTranslate.xml">glTranslate man page</a>
     */
    fun translate(m: Mat4, v: Vec3): Mat4 =
            translate(m, v.x, v.y, v.z, Mat4())

    /** Builds a translation 4 * 4 matrix created from a vector of 3 components.
     *
     *  @param res resulting matrix.
     *  @param m Input matrix multiplied by this translation matrix.
     *  @param vX X Coordinate of a translation vector.
     *  @param vY Y Coordinate of a translation vector.
     *  @param vZ Z Coordinate of a translation vector.
     *
     *  val m = glm.translate(Mat4(1f), Vec3(1f))
     *
     *  where m is
     *
     *      1  0  0  0
     *      0  1  0  0
     *      0  0  1  0
     *      1  1  1  1
     *
     *  @see gtc_matrix_transform
     *  @see - translate(m: Mat4, x: Float, y: Float, z: Float)
     *  @see - translate(v: Vec3)
     *  @see <a href="https://www.khronos.org/registry/OpenGL-Refpages/gl2.1/xhtml/glTranslate.xml">glTranslate man page</a>
     */
    fun translate(m: Mat4d, vX: Double, vY: Double, vZ: Double, res: Mat4d): Mat4d {
        if (res !== m) res put m
        val x = m[0].x * vX + m[1].x * vY + m[2].x * vZ + m[3].x
        val y = m[0].y * vX + m[1].y * vY + m[2].y * vZ + m[3].y
        val z = m[0].z * vX + m[1].z * vY + m[2].z * vZ + m[3].z
        val w = m[0].w * vX + m[1].w * vY + m[2].w * vZ + m[3].w
        res[3].x = x
        res[3].y = y
        res[3].z = z
        res[3].w = w
        return res
    }

    /** Builds a translation 4 * 4 matrix created from a vector of 3 components.
     *
     *  @param res resulting matrix.
     *  @param m Input matrix multiplied by this translation matrix.
     *  @param v Coordinates of a translation vector.
     *
     *  val m = glm.translate(Mat4(1f), Vec3(1f))
     *
     *  where m is
     *
     *      1  0  0  0
     *      0  1  0  0
     *      0  0  1  0
     *      1  1  1  1
     *
     *  @see gtc_matrix_transform
     *  @see - translate(m: Mat4, x: Float, y: Float, z: Float)
     *  @see - translate(v: Vec3)
     *  @see <a href="https://www.khronos.org/registry/OpenGL-Refpages/gl2.1/xhtml/glTranslate.xml">glTranslate man page</a>
     */
    fun translate(m: Mat4d, v: Vec3d, res: Mat4d): Mat4d =
            translate(m, v.x, v.y, v.z, res)

    /** Builds a translation 4 * 4 matrix created from a vector of 3 components.
     *
     *  @param m Input matrix multiplied by this translation matrix.
     *  @param vX X Coordinate of a translation vector.
     *  @param vY Y Coordinate of a translation vector.
     *  @param vZ Z Coordinate of a translation vector.
     *
     *  val m = glm.translate(Mat4(1f), Vec3(1f))
     *
     *  where m is
     *
     *      1  0  0  0
     *      0  1  0  0
     *      0  0  1  0
     *      1  1  1  1
     *
     *  @see gtc_matrix_transform
     *  @see - translate(m: Mat4, x: Float, y: Float, z: Float)
     *  @see - translate(v: Vec3)
     *  @see <a href="https://www.khronos.org/registry/OpenGL-Refpages/gl2.1/xhtml/glTranslate.xml">glTranslate man page</a>
     */
    fun translate(m: Mat4d, vX: Double, vY: Double, vZ: Double): Mat4d =
            translate(m, vX, vY, vZ, Mat4d())

    /** Builds a translation 4 * 4 matrix created from a vector of 3 components.
     *
     *  @param m Input matrix multiplied by this translation matrix.
     *  @param v Coordinates of a translation vector.
     *
     *  val m = glm.translate(Mat4(1f), Vec3(1f))
     *
     *  where m is
     *
     *      1  0  0  0
     *      0  1  0  0
     *      0  0  1  0
     *      1  1  1  1
     *
     *  @see gtc_matrix_transform
     *  @see - translate(m: Mat4, x: Float, y: Float, z: Float)
     *  @see - translate(v: Vec3)
     *  @see <a href="https://www.khronos.org/registry/OpenGL-Refpages/gl2.1/xhtml/glTranslate.xml">glTranslate man page</a>
     */
    fun translate(m: Mat4d, v: Vec3d): Mat4d =
            translate(m, v.x, v.y, v.z, Mat4d())


    /** Builds a rotation 4 * 4 matrix created from an axis vector and an angle.
     *
     *  @param res resulting rotation matrix.
     *  @param m Input matrix multiplied by this rotation matrix.
     *  @param angle Rotation angle expressed in radians.
     *  @param axisX X Coordinate of rotation axis, recommended to be normalized.
     *  @param axisY Y Coordinate of rotation axis, recommended to be normalized.
     *  @param axisZ Z Coordinate of rotation axis, recommended to be normalized.
     *
     *  @see gtc_matrix_transform
     *  @see - rotate(mat<4, 4, T, Q> const& m, T angle, T x, T y, T z)
     *  @see - rotate(T angle, vec<3, T, Q> const& v)
     *  @see <a href="https://www.khronos.org/registry/OpenGL-Refpages/gl2.1/xhtml/glRotate.xml">glRotate man page</a>
     */
    fun rotate(m: Mat4, angle: Float, axisX: Float, axisY: Float, axisZ: Float, res: Mat4): Mat4 {

        val c = glm.cos(angle)
        val s = glm.sin(angle)

        val dot = axisX * axisX + axisY * axisY + axisZ * axisZ
        val inv = glm.inverseSqrt(dot)

        val aX = axisX * inv
        val aY = axisY * inv
        val aZ = axisZ * inv

        val tempX = (1f - c) * aX
        val tempY = (1f - c) * aY
        val tempZ = (1f - c) * aZ

        val rotate00 = c + tempX * aX
        val rotate01 = tempX * aY + s * aZ
        val rotate02 = tempX * aZ - s * aY

        val rotate10 = tempY * aX - s * aZ
        val rotate11 = c + tempY * aY
        val rotate12 = tempY * aZ + s * aX

        val rotate20 = tempZ * aX + s * aY
        val rotate21 = tempZ * aY - s * aX
        val rotate22 = c + tempZ * aZ

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

    /** Builds a rotation 4 * 4 matrix created from an axis vector and an angle.
     *
     *  @param res resulting rotation matrix.
     *  @param m Input matrix multiplied by this rotation matrix.
     *  @param angle Rotation angle expressed in radians.
     *  @param axis Rotation axis, recommended to be normalized.
     *
     *  @see gtc_matrix_transform
     *  @see - rotate(mat<4, 4, T, Q> const& m, T angle, T x, T y, T z)
     *  @see - rotate(T angle, vec<3, T, Q> const& v)
     *  @see <a href="https://www.khronos.org/registry/OpenGL-Refpages/gl2.1/xhtml/glRotate.xml">glRotate man page</a>
     */
    fun rotate(m: Mat4, angle: Float, axis: Vec3, res: Mat4): Mat4 =
            rotate(m, angle, axis.x, axis.y, axis.z, res)

    /** Builds a rotation 4 * 4 matrix created from an axis vector and an angle.
     *
     *  @param m Input matrix multiplied by this rotation matrix.
     *  @param angle Rotation angle expressed in radians.
     *  @param axisX X Coordinate of rotation axis, recommended to be normalized.
     *  @param axisY Y Coordinate of rotation axis, recommended to be normalized.
     *  @param axisZ Z Coordinate of rotation axis, recommended to be normalized.
     *
     *  @see gtc_matrix_transform
     *  @see - rotate(mat<4, 4, T, Q> const& m, T angle, T x, T y, T z)
     *  @see - rotate(T angle, vec<3, T, Q> const& v)
     *  @see <a href="https://www.khronos.org/registry/OpenGL-Refpages/gl2.1/xhtml/glRotate.xml">glRotate man page</a>
     */
    fun rotate(m: Mat4, angle: Float, axisX: Float, axisY: Float, axisZ: Float): Mat4 =
            rotate(m, angle, axisX, axisY, axisZ, Mat4())

    /** Builds a rotation 4 * 4 matrix created from an axis vector and an angle.
     *
     *  @param m Input matrix multiplied by this rotation matrix.
     *  @param angle Rotation angle expressed in radians.
     *  @param axis Rotation axis, recommended to be normalized.
     *
     *  @see gtc_matrix_transform
     *  @see - rotate(mat<4, 4, T, Q> const& m, T angle, T x, T y, T z)
     *  @see - rotate(T angle, vec<3, T, Q> const& v)
     *  @see <a href="https://www.khronos.org/registry/OpenGL-Refpages/gl2.1/xhtml/glRotate.xml">glRotate man page</a>
     */
    fun rotate(m: Mat4, angle: Float, axis: Vec3): Mat4 =
            rotate(m, angle, axis.x, axis.y, axis.z, Mat4())

    fun rotateX(mat: Mat3, angle: Float, res: Mat3): Mat3 {
        val sin: Float
        val cos: Float
        if (angle == glm.PIf || angle == -glm.PIf) {
            cos = -1f
            sin = 0f
        } else if (angle == glm.PIf * 0.5f || angle == -glm.PIf * 1.5f) {
            cos = 0f
            sin = 1f
        } else if (angle == -glm.PIf * 0.5f || angle == glm.PIf * 1.5f) {
            cos = 0f
            sin = -1f
        } else {
            sin = sin(angle)
            cos = cos(angle)
        }
        val rm11 = cos
        val rm21 = -sin
        val rm12 = sin
        val rm22 = cos

        // add temporaries for dependent values
        val nm10 = mat[1, 0] * rm11 + mat[2, 0] * rm12
        val nm11 = mat[1, 1] * rm11 + mat[2, 1] * rm12
        val nm12 = mat[1, 2] * rm11 + mat[2, 2] * rm12
        // set non-dependent values directly
        res[2, 0] = mat[1, 0] * rm21 + mat[2, 0] * rm22
        res[2, 1] = mat[1, 1] * rm21 + mat[2, 1] * rm22
        res[2, 2] = mat[1, 2] * rm21 + mat[2, 2] * rm22
        // set other values
        res[1, 0] = nm10
        res[1, 1] = nm11
        res[1, 2] = nm12
        res[0, 0] = mat[0, 0]
        res[0, 1] = mat[0, 1]
        res[0, 2] = mat[0, 2]

        return res
    }

    fun rotateX(mat: Mat3, angle: Float): Mat3 =
            rotateX(mat, angle, Mat3())

    fun rotateY(mat: Mat3, angle: Float, res: Mat3): Mat3 {
        val sin: Float
        val cos: Float
        if (angle == glm.PIf || angle == -glm.PIf) {
            cos = -1f
            sin = 0f
        } else if (angle == glm.PIf * 0.5f || angle == -glm.PIf * 1.5f) {
            cos = 0f
            sin = 1f
        } else if (angle == -glm.PIf * 0.5f || angle == glm.PIf * 1.5f) {
            cos = 0f
            sin = -1f
        } else {
            sin = sin(angle)
            cos = cos(angle)
        }
        val rm00 = cos
        val rm20 = sin
        val rm02 = -sin
        val rm22 = cos

        // add temporaries for dependent values
        val nm00 = mat[0, 0] * rm00 + mat[2, 0] * rm02
        val nm01 = mat[0, 1] * rm00 + mat[2, 1] * rm02
        val nm02 = mat[0, 2] * rm00 + mat[2, 2] * rm02
        // set non-dependent values directly
        res[2, 0] = mat[0, 0] * rm20 + mat[2, 0] * rm22
        res[2, 1] = mat[0, 1] * rm20 + mat[2, 1] * rm22
        res[2, 2] = mat[0, 2] * rm20 + mat[2, 2] * rm22
        // set other values
        res[0, 0] = nm00
        res[0, 1] = nm01
        res[0, 2] = nm02
        res[1, 0] = mat[1, 0]
        res[1, 1] = mat[1, 1]
        res[1, 2] = mat[1, 2]

        return res
    }

    fun rotateY(mat: Mat3, angle: Float): Mat3 =
            rotateY(mat, angle, Mat3())

    fun rotateZ(mat: Mat3, angle: Float, res: Mat3): Mat3 {
        val sin: Float
        val cos: Float
        if (angle == glm.PIf || angle == -glm.PIf) {
            cos = -1f
            sin = 0f
        } else if (angle == glm.PIf * 0.5f || angle == -glm.PIf * 1.5f) {
            cos = 0f
            sin = 1f
        } else if (angle == -glm.PIf * 0.5f || angle == glm.PIf * 1.5f) {
            cos = 0f
            sin = -1f
        } else {
            sin = sin(angle)
            cos = cos(angle)
        }
        val rm00 = cos
        val rm10 = -sin
        val rm01 = sin
        val rm11 = cos

        // add temporaries for dependent values
        val nm00 = mat[0, 0] * rm00 + mat[1, 0] * rm01
        val nm01 = mat[0, 1] * rm00 + mat[1, 1] * rm01
        val nm02 = mat[0, 2] * rm00 + mat[1, 2] * rm01
        // set non-dependent values directly
        res[1, 0] = mat[0, 0] * rm10 + mat[1, 0] * rm11
        res[1, 1] = mat[0, 1] * rm10 + mat[1, 1] * rm11
        res[1, 2] = mat[0, 2] * rm10 + mat[1, 2] * rm11
        // set other values
        res[0, 0] = nm00
        res[0, 1] = nm01
        res[0, 2] = nm02
        res[2, 0] = mat[2, 0]
        res[2, 1] = mat[2, 1]
        res[2, 2] = mat[2, 2]

        return res
    }

    fun rotateZ(mat: Mat3, angle: Float): Mat3 =
            rotateZ(mat, angle, Mat3())

    fun rotateXYZ(mat: Mat3, angleX: Float, angleY: Float, angleZ: Float, res: Mat3): Mat3 {
        val sinX = sin(angleX)
        val cosX = cos(angleX)
        val sinY = sin(angleY)
        val cosY = cos(angleY)
        val sinZ = sin(angleZ)
        val cosZ = cos(angleZ)
        val m_sinX = -sinX
        val m_sinY = -sinY
        val m_sinZ = -sinZ

        // rotateX
        val nm10 = mat[1, 0] * cosX + mat[2, 0] * sinX
        val nm11 = mat[1, 1] * cosX + mat[2, 1] * sinX
        val nm12 = mat[1, 2] * cosX + mat[2, 2] * sinX
        val nm20 = mat[1, 0] * m_sinX + mat[2, 0] * cosX
        val nm21 = mat[1, 1] * m_sinX + mat[2, 1] * cosX
        val nm22 = mat[1, 2] * m_sinX + mat[2, 2] * cosX
        // rotateY
        val nm00 = mat[0, 0] * cosY + nm20 * m_sinY
        val nm01 = mat[0, 1] * cosY + nm21 * m_sinY
        val nm02 = mat[0, 2] * cosY + nm22 * m_sinY
        res[2, 0] = mat[0, 0] * sinY + nm20 * cosY
        res[2, 1] = mat[0, 1] * sinY + nm21 * cosY
        res[2, 2] = mat[0, 2] * sinY + nm22 * cosY
        // rotateZ
        res[0, 0] = nm00 * cosZ + nm10 * sinZ
        res[0, 1] = nm01 * cosZ + nm11 * sinZ
        res[0, 2] = nm02 * cosZ + nm12 * sinZ
        res[1, 0] = nm00 * m_sinZ + nm10 * cosZ
        res[1, 1] = nm01 * m_sinZ + nm11 * cosZ
        res[1, 2] = nm02 * m_sinZ + nm12 * cosZ
        return res
    }

    fun rotateXYZ(mat: Mat3, angleX: Float, angleY: Float, angleZ: Float): Mat3 =
            rotateXYZ(mat, angleX, angleY, angleZ, Mat3())

    fun rotateX(mat: Mat4, angle: Float, res: Mat4): Mat4 {
        val sin: Float
        val cos: Float
        if (angle == glm.PIf || angle == -glm.PIf) {
            cos = -1f
            sin = 0f
        } else if (angle == glm.PIf * 0.5f || angle == -glm.PIf * 1.5f) {
            cos = 0f
            sin = 1f
        } else if (angle == -glm.PIf * 0.5f || angle == glm.PIf * 1.5f) {
            cos = 0f
            sin = -1f
        } else {
            sin = sin(angle)
            cos = cos(angle)
        }
        val rm11 = cos
        val rm12 = sin
        val rm21 = -sin
        val rm22 = cos

        // add temporaries for dependent values
        val nm10 = mat[1, 0] * rm11 + mat[2, 0] * rm12
        val nm11 = mat[1, 1] * rm11 + mat[2, 1] * rm12
        val nm12 = mat[1, 2] * rm11 + mat[2, 2] * rm12
        val nm13 = mat[1, 3] * rm11 + mat[2, 3] * rm12
        // set non-dependent values directly
        res[2, 0] = mat[1, 0] * rm21 + mat[2, 0] * rm22
        res[2, 1] = mat[1, 1] * rm21 + mat[2, 1] * rm22
        res[2, 2] = mat[1, 2] * rm21 + mat[2, 2] * rm22
        res[2, 3] = mat[1, 3] * rm21 + mat[2, 3] * rm22
        // set other values
        res[1, 0] = nm10
        res[1, 1] = nm11
        res[1, 2] = nm12
        res[1, 3] = nm13
        res[0, 0] = mat[0, 0]
        res[0, 1] = mat[0, 1]
        res[0, 2] = mat[0, 2]
        res[0, 3] = mat[0, 3]
        res[3, 0] = mat[3, 0]
        res[3, 1] = mat[3, 1]
        res[3, 2] = mat[3, 2]
        res[3, 3] = mat[3, 3]
        return res
    }

    fun rotateX(mat: Mat4, angle: Float): Mat4 =
            rotateX(mat, angle, Mat4())

    fun rotateY(mat: Mat4, angle: Float, res: Mat4): Mat4 {
        val sin: Float
        val cos: Float
        if (angle == glm.PIf || angle == -glm.PIf) {
            cos = -1f
            sin = 0f
        } else if (angle == glm.PIf * 0.5f || angle == -glm.PIf * 1.5f) {
            cos = 0f
            sin = 1f
        } else if (angle == -glm.PIf * 0.5f || angle == glm.PIf * 1.5f) {
            cos = 0f
            sin = -1f
        } else {
            sin = sin(angle)
            cos = cos(angle)
        }
        val rm00 = cos
        val rm02 = -sin
        val rm20 = sin
        val rm22 = cos

        // add temporaries for dependent values
        val nm00 = mat[0, 0] * rm00 + mat[2, 0] * rm02
        val nm01 = mat[0, 1] * rm00 + mat[2, 1] * rm02
        val nm02 = mat[0, 2] * rm00 + mat[2, 2] * rm02
        val nm03 = mat[0, 3] * rm00 + mat[2, 3] * rm02
        // set non-dependent values directly
        res[2, 0] = mat[0, 0] * rm20 + mat[2, 0] * rm22
        res[2, 1] = mat[0, 1] * rm20 + mat[2, 1] * rm22
        res[2, 2] = mat[0, 2] * rm20 + mat[2, 2] * rm22
        res[2, 3] = mat[0, 3] * rm20 + mat[2, 3] * rm22
        // set other values
        res[0, 0] = nm00
        res[0, 1] = nm01
        res[0, 2] = nm02
        res[0, 3] = nm03
        res[1, 0] = mat[1, 0]
        res[1, 1] = mat[1, 1]
        res[1, 2] = mat[1, 2]
        res[1, 3] = mat[1, 3]
        res[3, 0] = mat[3, 0]
        res[3, 1] = mat[3, 1]
        res[3, 2] = mat[3, 2]
        res[3, 3] = mat[3, 3]
        return res
    }

    fun rotateY(mat: Mat4, angle: Float): Mat4 =
            rotateY(mat, angle, Mat4())

    fun rotateZ(mat: Mat4, angle: Float, res: Mat4): Mat4 {
        val sin: Float
        val cos: Float
        if (angle == glm.PIf || angle == -glm.PIf) {
            cos = -1f
            sin = 0f
        } else if (angle == glm.PIf * 0.5f || angle == -glm.PIf * 1.5f) {
            cos = 0f
            sin = 1f
        } else if (angle == -glm.PIf * 0.5f || angle == glm.PIf * 1.5f) {
            cos = 0f
            sin = -1f
        } else {
            sin = sin(angle)
            cos = cos(angle)
        }
        val rm00 = cos
        val rm01 = sin
        val rm10 = -sin
        val rm11 = cos
        // add temporaries for dependent values
        val nm00 = mat[0, 0] * rm00 + mat[1, 0] * rm01
        val nm01 = mat[0, 1] * rm00 + mat[1, 1] * rm01
        val nm02 = mat[0, 2] * rm00 + mat[1, 2] * rm01
        val nm03 = mat[0, 3] * rm00 + mat[1, 3] * rm01
        // set non-dependent values directly
        res[1, 0] = mat[0, 0] * rm10 + mat[1, 0] * rm11
        res[1, 1] = mat[0, 1] * rm10 + mat[1, 1] * rm11
        res[1, 2] = mat[0, 2] * rm10 + mat[1, 2] * rm11
        res[1, 3] = mat[0, 3] * rm10 + mat[1, 3] * rm11
        // set other values
        res[0, 0] = nm00
        res[0, 1] = nm01
        res[0, 2] = nm02
        res[0, 3] = nm03
        res[2, 0] = mat[2, 0]
        res[2, 1] = mat[2, 1]
        res[2, 2] = mat[2, 2]
        res[2, 3] = mat[2, 3]
        res[3, 0] = mat[3, 0]
        res[3, 1] = mat[3, 1]
        res[3, 2] = mat[3, 2]
        res[3, 3] = mat[3, 3]
        return res
    }

    fun rotateZ(mat: Mat4, angle: Float): Mat4 =
            rotateZ(mat, angle, Mat4())

    fun rotateXYZ(mat: Mat4, angleX: Float, angleY: Float, angleZ: Float, res: Mat4): Mat4 {
        val sinX = sin(angleX)
        val cosX = cos(angleX)
        val sinY = sin(angleY)
        val cosY = cos(angleY)
        val sinZ = sin(angleZ)
        val cosZ = cos(angleZ)
        val m_sinX = -sinX
        val m_sinY = -sinY
        val m_sinZ = -sinZ

        // rotateX
        val nm10 = mat[1, 0] * cosX + mat[2, 0] * sinX
        val nm11 = mat[1, 1] * cosX + mat[2, 1] * sinX
        val nm12 = mat[1, 2] * cosX + mat[2, 2] * sinX
        val nm13 = mat[1, 3] * cosX + mat[2, 3] * sinX
        val nm20 = mat[1, 0] * m_sinX + mat[2, 0] * cosX
        val nm21 = mat[1, 1] * m_sinX + mat[2, 1] * cosX
        val nm22 = mat[1, 2] * m_sinX + mat[2, 2] * cosX
        val nm23 = mat[1, 3] * m_sinX + mat[2, 3] * cosX
        // rotateY
        val nm00 = mat[0, 0] * cosY + nm20 * m_sinY
        val nm01 = mat[0, 1] * cosY + nm21 * m_sinY
        val nm02 = mat[0, 2] * cosY + nm22 * m_sinY
        val nm03 = mat[0, 3] * cosY + nm23 * m_sinY
        res[2, 0] = mat[0, 0] * sinY + nm20 * cosY
        res[2, 1] = mat[0, 1] * sinY + nm21 * cosY
        res[2, 2] = mat[0, 2] * sinY + nm22 * cosY
        res[2, 3] = mat[0, 3] * sinY + nm23 * cosY
        // rotateZ
        res[0, 0] = nm00 * cosZ + nm10 * sinZ
        res[0, 1] = nm01 * cosZ + nm11 * sinZ
        res[0, 2] = nm02 * cosZ + nm12 * sinZ
        res[0, 3] = nm03 * cosZ + nm13 * sinZ
        res[1, 0] = nm00 * m_sinZ + nm10 * cosZ
        res[1, 1] = nm01 * m_sinZ + nm11 * cosZ
        res[1, 2] = nm02 * m_sinZ + nm12 * cosZ
        res[1, 3] = nm03 * m_sinZ + nm13 * cosZ
        // copy last column from 'this'
        res[3, 0] = mat[3, 0]
        res[3, 1] = mat[3, 1]
        res[3, 2] = mat[3, 2]
        res[3, 3] = mat[3, 3]
        return res
    }

    fun rotateXYZ(mat: Mat4, angleX: Float, angleY: Float, angleZ: Float): Mat4 =
            rotateXYZ(mat, angleX, angleY, angleZ, Mat4())


    // -----------------------------------------------------------------------------------------------------------------
    // Double version
    // -----------------------------------------------------------------------------------------------------------------


    /** Builds a rotation 4 * 4 matrix created from an axis vector and an angle.
     *
     *  @param res resulting rotation matrix.
     *  @param m Input matrix multiplied by this rotation matrix.
     *  @param angle Rotation angle expressed in radians.
     *  @param axisX X Coordinate of rotation axis, recommended to be normalized.
     *  @param axisY Y Coordinate of rotation axis, recommended to be normalized.
     *  @param axisZ Z Coordinate of rotation axis, recommended to be normalized.
     *
     *  @see gtc_matrix_transform
     *  @see - rotate(mat<4, 4, T, Q> const& m, T angle, T x, T y, T z)
     *  @see - rotate(T angle, vec<3, T, Q> const& v)
     *  @see <a href="https://www.khronos.org/registry/OpenGL-Refpages/gl2.1/xhtml/glRotate.xml">glRotate man page</a>
     */
    fun rotate(m: Mat4d, angle: Double, axisX: Double, axisY: Double, axisZ: Double, res: Mat4d): Mat4d {

        val c = glm.cos(angle)
        val s = glm.sin(angle)

        val dot = axisX * axisX + axisY * axisY + axisZ * axisZ
        val inv = glm.inverseSqrt(dot)

        val aX = axisX * inv
        val aY = axisY * inv
        val aZ = axisZ * inv

        val tempX = (1f - c) * aX
        val tempY = (1f - c) * aY
        val tempZ = (1f - c) * aZ

        val rotate00 = c + tempX * aX
        val rotate01 = tempX * aY + s * aZ
        val rotate02 = tempX * aZ - s * aY

        val rotate10 = tempY * aX - s * aZ
        val rotate11 = c + tempY * aY
        val rotate12 = tempY * aZ + s * aX

        val rotate20 = tempZ * aX + s * aY
        val rotate21 = tempZ * aY - s * aX
        val rotate22 = c + tempZ * aZ

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

    /** Builds a rotation 4 * 4 matrix created from an axis vector and an angle.
     *
     *  @param res resulting rotation matrix.
     *  @param m Input matrix multiplied by this rotation matrix.
     *  @param angle Rotation angle expressed in radians.
     *  @param axis Rotation axis, recommended to be normalized.
     *
     *  @see gtc_matrix_transform
     *  @see - rotate(mat<4, 4, T, Q> const& m, T angle, T x, T y, T z)
     *  @see - rotate(T angle, vec<3, T, Q> const& v)
     *  @see <a href="https://www.khronos.org/registry/OpenGL-Refpages/gl2.1/xhtml/glRotate.xml">glRotate man page</a>
     */
    fun rotate(m: Mat4d, angle: Double, axis: Vec3d, res: Mat4d): Mat4d =
            rotate(m, angle, axis.x, axis.y, axis.z, res)

    /** Builds a rotation 4 * 4 matrix created from an axis vector and an angle.
     *
     *  @param m Input matrix multiplied by this rotation matrix.
     *  @param angle Rotation angle expressed in radians.
     *  @param axisX X Coordinate of rotation axis, recommended to be normalized.
     *  @param axisY Y Coordinate of rotation axis, recommended to be normalized.
     *  @param axisZ Z Coordinate of rotation axis, recommended to be normalized.
     *
     *  @see gtc_matrix_transform
     *  @see - rotate(mat<4, 4, T, Q> const& m, T angle, T x, T y, T z)
     *  @see - rotate(T angle, vec<3, T, Q> const& v)
     *  @see <a href="https://www.khronos.org/registry/OpenGL-Refpages/gl2.1/xhtml/glRotate.xml">glRotate man page</a>
     */
    fun rotate(m: Mat4d, angle: Double, axisX: Double, axisY: Double, axisZ: Double): Mat4d =
            rotate(m, angle, axisX, axisY, axisZ, Mat4d())

    /** Builds a rotation 4 * 4 matrix created from an axis vector and an angle.
     *
     *  @param m Input matrix multiplied by this rotation matrix.
     *  @param angle Rotation angle expressed in radians.
     *  @param axis Rotation axis, recommended to be normalized.
     *
     *  @see gtc_matrix_transform
     *  @see - rotate(mat<4, 4, T, Q> const& m, T angle, T x, T y, T z)
     *  @see - rotate(T angle, vec<3, T, Q> const& v)
     *  @see <a href="https://www.khronos.org/registry/OpenGL-Refpages/gl2.1/xhtml/glRotate.xml">glRotate man page</a>
     */
    fun rotate(m: Mat4d, angle: Double, axis: Vec3d): Mat4d =
            rotate(m, angle, axis.x, axis.y, axis.z, Mat4d())

    fun rotateX(mat: Mat3d, angle: Double, res: Mat3d): Mat3d {
        val sin: Double
        val cos: Double
        if (angle == glm.PI || angle == -glm.PI) {
            cos = -1.0
            sin = 0.0
        } else if (angle == glm.PI * 0.5 || angle == -glm.PI * 1.5) {
            cos = 0.0
            sin = 1.0
        } else if (angle == -glm.PI * 0.5 || angle == glm.PI * 1.5) {
            cos = 0.0
            sin = -1.0
        } else {
            sin = sin(angle)
            cos = cos(angle)
        }
        val rm11 = cos
        val rm21 = -sin
        val rm12 = sin
        val rm22 = cos

        // add temporaries for dependent values
        val nm10 = mat[1, 0] * rm11 + mat[2, 0] * rm12
        val nm11 = mat[1, 1] * rm11 + mat[2, 1] * rm12
        val nm12 = mat[1, 2] * rm11 + mat[2, 2] * rm12
        // set non-dependent values directly
        res[2, 0] = mat[1, 0] * rm21 + mat[2, 0] * rm22
        res[2, 1] = mat[1, 1] * rm21 + mat[2, 1] * rm22
        res[2, 2] = mat[1, 2] * rm21 + mat[2, 2] * rm22
        // set other values
        res[1, 0] = nm10
        res[1, 1] = nm11
        res[1, 2] = nm12
        res[0, 0] = mat[0, 0]
        res[0, 1] = mat[0, 1]
        res[0, 2] = mat[0, 2]

        return res
    }

    fun rotateX(mat: Mat3d, angle: Double): Mat3d =
            rotateX(mat, angle, Mat3d())

    fun rotateY(mat: Mat3d, angle: Double, res: Mat3d): Mat3d {
        val sin: Double
        val cos: Double
        if (angle == glm.PI || angle == -glm.PI) {
            cos = -1.0
            sin = 0.0
        } else if (angle == glm.PI * 0.5 || angle == -glm.PI * 1.5) {
            cos = 0.0
            sin = 1.0
        } else if (angle == -glm.PI * 0.5 || angle == glm.PI * 1.5) {
            cos = 0.0
            sin = -1.0
        } else {
            sin = sin(angle)
            cos = cos(angle)
        }
        val rm00 = cos
        val rm20 = sin
        val rm02 = -sin
        val rm22 = cos

        // add temporaries for dependent values
        val nm00 = mat[0, 0] * rm00 + mat[2, 0] * rm02
        val nm01 = mat[0, 1] * rm00 + mat[2, 1] * rm02
        val nm02 = mat[0, 2] * rm00 + mat[2, 2] * rm02
        // set non-dependent values directly
        res[2, 0] = mat[0, 0] * rm20 + mat[2, 0] * rm22
        res[2, 1] = mat[0, 1] * rm20 + mat[2, 1] * rm22
        res[2, 2] = mat[0, 2] * rm20 + mat[2, 2] * rm22
        // set other values
        res[0, 0] = nm00
        res[0, 1] = nm01
        res[0, 2] = nm02
        res[1, 0] = mat[1, 0]
        res[1, 1] = mat[1, 1]
        res[1, 2] = mat[1, 2]

        return res
    }

    fun rotateY(mat: Mat3d, angle: Double): Mat3d =
            rotateY(mat, angle, Mat3d())

    fun rotateZ(mat: Mat3d, angle: Double, res: Mat3d): Mat3d {
        val sin: Double
        val cos: Double
        if (angle == glm.PI || angle == -glm.PI) {
            cos = -1.0
            sin = 0.0
        } else if (angle == glm.PI * 0.5 || angle == -glm.PI * 1.5) {
            cos = 0.0
            sin = 1.0
        } else if (angle == -glm.PI * 0.5 || angle == glm.PI * 1.5) {
            cos = 0.0
            sin = -1.0
        } else {
            sin = sin(angle)
            cos = cos(angle)
        }
        val rm00 = cos
        val rm10 = -sin
        val rm01 = sin
        val rm11 = cos

        // add temporaries for dependent values
        val nm00 = mat[0, 0] * rm00 + mat[1, 0] * rm01
        val nm01 = mat[0, 1] * rm00 + mat[1, 1] * rm01
        val nm02 = mat[0, 2] * rm00 + mat[1, 2] * rm01
        // set non-dependent values directly
        res[1, 0] = mat[0, 0] * rm10 + mat[1, 0] * rm11
        res[1, 1] = mat[0, 1] * rm10 + mat[1, 1] * rm11
        res[1, 2] = mat[0, 2] * rm10 + mat[1, 2] * rm11
        // set other values
        res[0, 0] = nm00
        res[0, 1] = nm01
        res[0, 2] = nm02
        res[2, 0] = mat[2, 0]
        res[2, 1] = mat[2, 1]
        res[2, 2] = mat[2, 2]

        return res
    }

    fun rotateZ(mat: Mat3d, angle: Double): Mat3d =
            rotateZ(mat, angle, Mat3d())

    fun rotateXYZ(mat: Mat3d, angleX: Double, angleY: Double, angleZ: Double, res: Mat3d): Mat3d {
        val sinX = sin(angleX)
        val cosX = cos(angleX)
        val sinY = sin(angleY)
        val cosY = cos(angleY)
        val sinZ = sin(angleZ)
        val cosZ = cos(angleZ)
        val m_sinX = -sinX
        val m_sinY = -sinY
        val m_sinZ = -sinZ

        // rotateX
        val nm10 = mat[1, 0] * cosX + mat[2, 0] * sinX
        val nm11 = mat[1, 1] * cosX + mat[2, 1] * sinX
        val nm12 = mat[1, 2] * cosX + mat[2, 2] * sinX
        val nm20 = mat[1, 0] * m_sinX + mat[2, 0] * cosX
        val nm21 = mat[1, 1] * m_sinX + mat[2, 1] * cosX
        val nm22 = mat[1, 2] * m_sinX + mat[2, 2] * cosX
        // rotateY
        val nm00 = mat[0, 0] * cosY + nm20 * m_sinY
        val nm01 = mat[0, 1] * cosY + nm21 * m_sinY
        val nm02 = mat[0, 2] * cosY + nm22 * m_sinY
        res[2, 0] = mat[0, 0] * sinY + nm20 * cosY
        res[2, 1] = mat[0, 1] * sinY + nm21 * cosY
        res[2, 2] = mat[0, 2] * sinY + nm22 * cosY
        // rotateZ
        res[0, 0] = nm00 * cosZ + nm10 * sinZ
        res[0, 1] = nm01 * cosZ + nm11 * sinZ
        res[0, 2] = nm02 * cosZ + nm12 * sinZ
        res[1, 0] = nm00 * m_sinZ + nm10 * cosZ
        res[1, 1] = nm01 * m_sinZ + nm11 * cosZ
        res[1, 2] = nm02 * m_sinZ + nm12 * cosZ
        return res
    }

    fun rotateXYZ(mat: Mat3d, angleX: Double, angleY: Double, angleZ: Double): Mat3d =
            rotateXYZ(mat, angleX, angleY, angleZ, Mat3d())

    fun rotateX(mat: Mat4d, angle: Double, res: Mat4d): Mat4d {
        val sin = sin(angle)
        val cos = cos(sin)
        val rm11 = cos
        val rm12 = sin
        val rm21 = -sin
        val rm22 = cos

        // add temporaries for dependent values
        val nm10 = mat[1, 0] * rm11 + mat[2, 0] * rm12
        val nm11 = mat[1, 1] * rm11 + mat[2, 1] * rm12
        val nm12 = mat[1, 2] * rm11 + mat[2, 2] * rm12
        val nm13 = mat[1, 3] * rm11 + mat[2, 3] * rm12
        // set non-dependent values directly
        res[2, 0] = mat[1, 0] * rm21 + mat[2, 0] * rm22
        res[2, 1] = mat[1, 1] * rm21 + mat[2, 1] * rm22
        res[2, 2] = mat[1, 2] * rm21 + mat[2, 2] * rm22
        res[2, 3] = mat[1, 3] * rm21 + mat[2, 3] * rm22
        // set other values
        res[1, 0] = nm10
        res[1, 1] = nm11
        res[1, 2] = nm12
        res[1, 3] = nm13
        res[0, 0] = mat[0, 0]
        res[0, 1] = mat[0, 1]
        res[0, 2] = mat[0, 2]
        res[0, 3] = mat[0, 3]
        res[3, 0] = mat[3, 0]
        res[3, 1] = mat[3, 1]
        res[3, 2] = mat[3, 2]
        res[3, 3] = mat[3, 3]
        return res
    }

    fun rotateX(mat: Mat4d, angle: Double): Mat4d =
            rotateX(mat, angle, Mat4d())

    fun rotateY(mat: Mat4d, angle: Double, res: Mat4d): Mat4d {
        val cos = cos(angle)
        val sin = sin(angle)
        val rm00 = cos
        val rm02 = -sin
        val rm20 = sin
        val rm22 = cos

        // add temporaries for dependent values
        val nm00 = mat[0, 0] * rm00 + mat[2, 0] * rm02
        val nm01 = mat[0, 1] * rm00 + mat[2, 1] * rm02
        val nm02 = mat[0, 2] * rm00 + mat[2, 2] * rm02
        val nm03 = mat[0, 3] * rm00 + mat[2, 3] * rm02
        // set non-dependent values directly
        res[2, 0] = mat[0, 0] * rm20 + mat[2, 0] * rm22
        res[2, 1] = mat[0, 1] * rm20 + mat[2, 1] * rm22
        res[2, 2] = mat[0, 2] * rm20 + mat[2, 2] * rm22
        res[2, 3] = mat[0, 3] * rm20 + mat[2, 3] * rm22
        // set other values
        res[0, 0] = nm00
        res[0, 1] = nm01
        res[0, 2] = nm02
        res[0, 3] = nm03
        res[1, 0] = mat[1, 0]
        res[1, 1] = mat[1, 1]
        res[1, 2] = mat[1, 2]
        res[1, 3] = mat[1, 3]
        res[3, 0] = mat[3, 0]
        res[3, 1] = mat[3, 1]
        res[3, 2] = mat[3, 2]
        res[3, 3] = mat[3, 3]
        return res
    }

    fun rotateY(mat: Mat4d, angle: Double): Mat4d =
            rotateY(mat, angle, Mat4d())

    fun rotateZ(mat: Mat4d, angle: Double, res: Mat4d): Mat4d {
        val sin = sin(angle)
        val cos = cos(angle)
        val rm00 = cos
        val rm01 = sin
        val rm10 = -sin
        val rm11 = cos
        // add temporaries for dependent values
        val nm00 = mat[0, 0] * rm00 + mat[1, 0] * rm01
        val nm01 = mat[0, 1] * rm00 + mat[1, 1] * rm01
        val nm02 = mat[0, 2] * rm00 + mat[1, 2] * rm01
        val nm03 = mat[0, 3] * rm00 + mat[1, 3] * rm01
        // set non-dependent values directly
        res[1, 0] = mat[0, 0] * rm10 + mat[1, 0] * rm11
        res[1, 1] = mat[0, 1] * rm10 + mat[1, 1] * rm11
        res[1, 2] = mat[0, 2] * rm10 + mat[1, 2] * rm11
        res[1, 3] = mat[0, 3] * rm10 + mat[1, 3] * rm11
        // set other values
        res[0, 0] = nm00
        res[0, 1] = nm01
        res[0, 2] = nm02
        res[0, 3] = nm03
        res[2, 0] = mat[2, 0]
        res[2, 1] = mat[2, 1]
        res[2, 2] = mat[2, 2]
        res[2, 3] = mat[2, 3]
        res[3, 0] = mat[3, 0]
        res[3, 1] = mat[3, 1]
        res[3, 2] = mat[3, 2]
        res[3, 3] = mat[3, 3]
        return res
    }

    fun rotateZ(mat: Mat4d, angle: Double): Mat4d =
            rotateZ(mat, angle, Mat4d())

    fun rotateXYZ(mat: Mat4d, angleX: Double, angleY: Double, angleZ: Double, res: Mat4d): Mat4d {
        val sinX = sin(angleX)
        val cosX = cos(angleX)
        val sinY = sin(angleY)
        val cosY = cos(angleY)
        val sinZ = sin(angleZ)
        val cosZ = cos(angleZ)
        val m_sinX = -sinX
        val m_sinY = -sinY
        val m_sinZ = -sinZ

        // rotateX
        val nm10 = mat[1, 0] * cosX + mat[2, 0] * sinX
        val nm11 = mat[1, 1] * cosX + mat[2, 1] * sinX
        val nm12 = mat[1, 2] * cosX + mat[2, 2] * sinX
        val nm13 = mat[1, 3] * cosX + mat[2, 3] * sinX
        val nm20 = mat[1, 0] * m_sinX + mat[2, 0] * cosX
        val nm21 = mat[1, 1] * m_sinX + mat[2, 1] * cosX
        val nm22 = mat[1, 2] * m_sinX + mat[2, 2] * cosX
        val nm23 = mat[1, 3] * m_sinX + mat[2, 3] * cosX
        // rotateY
        val nm00 = mat[0, 0] * cosY + nm20 * m_sinY
        val nm01 = mat[0, 1] * cosY + nm21 * m_sinY
        val nm02 = mat[0, 2] * cosY + nm22 * m_sinY
        val nm03 = mat[0, 3] * cosY + nm23 * m_sinY
        res[2, 0] = mat[0, 0] * sinY + nm20 * cosY
        res[2, 1] = mat[0, 1] * sinY + nm21 * cosY
        res[2, 2] = mat[0, 2] * sinY + nm22 * cosY
        res[2, 3] = mat[0, 3] * sinY + nm23 * cosY
        // rotateZ
        res[0, 0] = nm00 * cosZ + nm10 * sinZ
        res[0, 1] = nm01 * cosZ + nm11 * sinZ
        res[0, 2] = nm02 * cosZ + nm12 * sinZ
        res[0, 3] = nm03 * cosZ + nm13 * sinZ
        res[1, 0] = nm00 * m_sinZ + nm10 * cosZ
        res[1, 1] = nm01 * m_sinZ + nm11 * cosZ
        res[1, 2] = nm02 * m_sinZ + nm12 * cosZ
        res[1, 3] = nm03 * m_sinZ + nm13 * cosZ
        // copy last column from 'this'
        res[3, 0] = mat[3, 0]
        res[3, 1] = mat[3, 1]
        res[3, 2] = mat[3, 2]
        res[3, 3] = mat[3, 3]
        return res
    }

    fun rotateXYZ(mat: Mat4d, angleX: Double, angleY: Double, angleZ: Double): Mat4d =
            rotateXYZ(mat, angleX, angleY, angleZ, Mat4d())

//    fun rotateXYZ(angleX: Float, angleY: Float, angleZ: Float, res: Mat3): Mat3 { TODO?
//        val sinX = sin(angleX)
//        val cosX = cos(angleX)
//        val sinY = sin(angleY)
//        val cosY = cos(angleY)
//        val sinZ = sin(angleZ)
//        val cosZ = cos(angleZ)
//        val m_sinX = -sinX
//        val m_sinY = -sinY
//        val m_sinZ = -sinZ
//
//        // rotateX
//        // rotateY
//        val nm00 = cosY
//        val nm01 = m_sinX * m_sinY
//        val nm02 = cosX * m_sinY
//        res[2, 0] = 0f
//        res[2, 1] = m_sinX * cosY
//        res[2, 2] = cosX * cosY
//        // rotateZ
//        res[0, 0] = nm00 * cosZ
//        res[0, 1] = nm01 * cosZ + cosX * sinZ
//        res[0, 2] = nm02 * cosZ + sinX * sinZ
//        res[1, 0] = nm00 * m_sinZ
//        res[1, 1] = nm01 * m_sinZ + cosX * cosZ
//        res[1, 2] = nm02 * m_sinZ + sinX * cosZ
//        res[1, 1] = 1f
//        return res
//    }
//
//    fun rotateXYZ(angleX: Float, angleY: Float, angleZ: Float): Mat3 = rotateXYZ(angleX, angleY, angleZ, Mat3())


    /** Builds a scale 4 * 4 matrix created from 3 scalars.
     *
     *  @param res resulting scale matrix.
     *  @param m Input matrix multiplied by this scale matrix.
     *  @param vX Ratio of scaling for X axis.
     *  @param vY Ratio of scaling for Y axis.
     *  @param vZ Ratio of scaling for Z axis.
     *
     *  @see gtc_matrix_transform
     *  @see - scale(mat<4, 4, T, Q> const& m, T x, T y, T z)
     *  @see - scale(vec<3, T, Q> const& v)
     *  @see <a href="https://www.khronos.org/registry/OpenGL-Refpages/gl2.1/xhtml/glScale.xml">glScale man page</a>
     */
    fun scale(m: Mat4, vX: Float, vY: Float, vZ: Float, res: Mat4): Mat4 {

        res[0, 0] = m[0, 0] * vX
        res[0, 1] = m[0, 1] * vX
        res[0, 2] = m[0, 2] * vX
        res[0, 3] = m[0, 3] * vX

        res[1, 0] = m[1, 0] * vY
        res[1, 1] = m[1, 1] * vY
        res[1, 2] = m[1, 2] * vY
        res[1, 3] = m[1, 3] * vY

        res[2, 0] = m[2, 0] * vZ
        res[2, 1] = m[2, 1] * vZ
        res[2, 2] = m[2, 2] * vZ
        res[2, 3] = m[2, 3] * vZ

        res[3, 0] = m[3, 0]
        res[3, 1] = m[3, 1]
        res[3, 2] = m[3, 2]
        res[3, 3] = m[3, 3]

        return res
    }

    /** Builds a scale 4 * 4 matrix created from 3 scalars.
     *
     *  @param res resulting scale matrix.
     *  @param m Input matrix multiplied by this scale matrix.
     *  @param v Ratio of scaling for this axis.
     *
     *  @see gtc_matrix_transform
     *  @see - scale(mat<4, 4, T, Q> const& m, T x, T y, T z)
     *  @see - scale(vec<3, T, Q> const& v)
     *  @see <a href="https://www.khronos.org/registry/OpenGL-Refpages/gl2.1/xhtml/glScale.xml">glScale man page</a>
     */
    fun scale(m: Mat4, v: Vec3, res: Mat4): Mat4 =
            scale(m, v.x, v.y, v.z, res)

    /** Builds a scale 4 * 4 matrix created from 3 scalars.
     *
     *  @param m Input matrix multiplied by this scale matrix.
     *  @param vX Ratio of scaling for X axis.
     *  @param vY Ratio of scaling for Y axis.
     *  @param vZ Ratio of scaling for Z axis.
     *
     *  @see gtc_matrix_transform
     *  @see - scale(mat<4, 4, T, Q> const& m, T x, T y, T z)
     *  @see - scale(vec<3, T, Q> const& v)
     *  @see <a href="https://www.khronos.org/registry/OpenGL-Refpages/gl2.1/xhtml/glScale.xml">glScale man page</a>
     */
    fun scale(m: Mat4, vX: Float, vY: Float, vZ: Float): Mat4 =
            scale(m, vX, vY, vZ, Mat4())

    /** Builds a scale 4 * 4 matrix created from 3 scalars.
     *
     *  @param m Input matrix multiplied by this scale matrix.
     *  @param v Ratio of scaling for this axis.
     *
     *  @see gtc_matrix_transform
     *  @see - scale(mat<4, 4, T, Q> const& m, T x, T y, T z)
     *  @see - scale(vec<3, T, Q> const& v)
     *  @see <a href="https://www.khronos.org/registry/OpenGL-Refpages/gl2.1/xhtml/glScale.xml">glScale man page</a>
     */
    fun scale(m: Mat4, v: Vec3): Mat4 =
            scale(m, v.x, v.y, v.z, Mat4())

    /** Builds a scale 4 * 4 matrix created from 3 scalars.
     *
     *  @param res resulting scale matrix.
     *  @param m Input matrix multiplied by this scale matrix.
     *  @param vX Ratio of scaling for X axis.
     *  @param vY Ratio of scaling for Y axis.
     *  @param vZ Ratio of scaling for Z axis.
     *
     *  @see gtc_matrix_transform
     *  @see - scale(mat<4, 4, T, Q> const& m, T x, T y, T z)
     *  @see - scale(vec<3, T, Q> const& v)
     *  @see <a href="https://www.khronos.org/registry/OpenGL-Refpages/gl2.1/xhtml/glScale.xml">glScale man page</a>
     */
    fun scale(m: Mat4d, vX: Double, vY: Double, vZ: Double, res: Mat4d): Mat4d {

        res[0, 0] = m[0, 0] * vX
        res[0, 1] = m[0, 1] * vX
        res[0, 2] = m[0, 2] * vX
        res[0, 3] = m[0, 3] * vX

        res[1, 0] = m[1, 0] * vY
        res[1, 1] = m[1, 1] * vY
        res[1, 2] = m[1, 2] * vY
        res[1, 3] = m[1, 3] * vY

        res[2, 0] = m[2, 0] * vZ
        res[2, 1] = m[2, 1] * vZ
        res[2, 2] = m[2, 2] * vZ
        res[2, 3] = m[2, 3] * vZ

        res[3, 0] = m[3, 0]
        res[3, 1] = m[3, 1]
        res[3, 2] = m[3, 2]
        res[3, 3] = m[3, 3]

        return res
    }

    /** Builds a scale 4 * 4 matrix created from 3 scalars.
     *
     *  @param res resulting scale matrix.
     *  @param m Input matrix multiplied by this scale matrix.
     *  @param v Ratio of scaling for this axis.
     *
     *  @see gtc_matrix_transform
     *  @see - scale(mat<4, 4, T, Q> const& m, T x, T y, T z)
     *  @see - scale(vec<3, T, Q> const& v)
     *  @see <a href="https://www.khronos.org/registry/OpenGL-Refpages/gl2.1/xhtml/glScale.xml">glScale man page</a>
     */
    fun scale(m: Mat4d, v: Vec3d, res: Mat4d): Mat4d =
            scale(m, v.x, v.y, v.z, res)

    /** Builds a scale 4 * 4 matrix created from 3 scalars.
     *
     *  @param m Input matrix multiplied by this scale matrix.
     *  @param vX Ratio of scaling for X axis.
     *  @param vY Ratio of scaling for Y axis.
     *  @param vZ Ratio of scaling for Z axis.
     *
     *  @see gtc_matrix_transform
     *  @see - scale(mat<4, 4, T, Q> const& m, T x, T y, T z)
     *  @see - scale(vec<3, T, Q> const& v)
     *  @see <a href="https://www.khronos.org/registry/OpenGL-Refpages/gl2.1/xhtml/glScale.xml">glScale man page</a>
     */
    fun scale(m: Mat4d, vX: Double, vY: Double, vZ: Double): Mat4d =
            scale(m, vX, vY, vZ, Mat4d())

    /** Builds a scale 4 * 4 matrix created from 3 scalars.
     *
     *  @param m Input matrix multiplied by this scale matrix.
     *  @param v Ratio of scaling for this axis.
     *
     *  @see gtc_matrix_transform
     *  @see - scale(mat<4, 4, T, Q> const& m, T x, T y, T z)
     *  @see - scale(vec<3, T, Q> const& v)
     *  @see <a href="https://www.khronos.org/registry/OpenGL-Refpages/gl2.1/xhtml/glScale.xml">glScale man page</a>
     */
    fun scale(m: Mat4d, v: Vec3d): Mat4d =
            scale(m, v.x, v.y, v.z, Mat4d())

    /** Builds a scale 3 * 3 matrix created from 3 scalars.
     *
     *  @param res resulting scale matrix.
     *  @param m Input matrix multiplied by this scale matrix.
     *  @param vX Ratio of scaling for X axis.
     *  @param vY Ratio of scaling for Y axis.
     *  @param vZ Ratio of scaling for Z axis.
     *
     *  @see gtc_matrix_transform
     *  @see - scale(mat<3, 3, T, Q> const& m, T x, T y, T z)
     *  @see - scale(vec<3, T, Q> const& v)
     *  @see <a href="https://www.khronos.org/registry/OpenGL-Refpages/gl2.1/xhtml/glScale.xml">glScale man page</a>
     */
    fun scale(m: Mat3, vX: Float, vY: Float, vZ: Float, res: Mat3): Mat3 {

        res[0, 0] = m[0, 0] * vX
        res[0, 1] = m[0, 1] * vX
        res[0, 2] = m[0, 2] * vX

        res[1, 0] = m[1, 0] * vY
        res[1, 1] = m[1, 1] * vY
        res[1, 2] = m[1, 2] * vY

        res[2, 0] = m[2, 0] * vZ
        res[2, 1] = m[2, 1] * vZ
        res[2, 2] = m[2, 2] * vZ

        return res
    }

    /** Builds a scale 3 * 3 matrix created from 3 scalars.
     *
     *  @param res resulting scale matrix.
     *  @param m Input matrix multiplied by this scale matrix.
     *  @param v Ratio of scaling for this axis.
     *
     *  @see gtc_matrix_transform
     *  @see - scale(mat<3, 3, T, Q> const& m, T x, T y, T z)
     *  @see - scale(vec<3, T, Q> const& v)
     *  @see <a href="https://www.khronos.org/registry/OpenGL-Refpages/gl2.1/xhtml/glScale.xml">glScale man page</a>
     */
    fun scale(m: Mat3, v: Vec3, res: Mat3): Mat3 =
            scale(m, v.x, v.y, v.z, res)

    /** Builds a scale 3 * 3 matrix created from 3 scalars.
     *
     *  @param m Input matrix multiplied by this scale matrix.
     *  @param vX Ratio of scaling for X axis.
     *  @param vY Ratio of scaling for Y axis.
     *  @param vZ Ratio of scaling for Z axis.
     *
     *  @see gtc_matrix_transform
     *  @see - scale(mat<3, 3, T, Q> const& m, T x, T y, T z)
     *  @see - scale(vec<3, T, Q> const& v)
     *  @see <a href="https://www.khronos.org/registry/OpenGL-Refpages/gl2.1/xhtml/glScale.xml">glScale man page</a>
     */
    fun scale(m: Mat3, vX: Float, vY: Float, vZ: Float): Mat3 =
            scale(m, vX, vY, vZ, Mat3())

    /** Builds a scale 3 * 3 matrix created from 3 scalars.
     *
     *  @param m Input matrix multiplied by this scale matrix.
     *  @param v Ratio of scaling for this axis.
     *
     *  @see gtc_matrix_transform
     *  @see - scale(mat<3, 3, T, Q> const& m, T x, T y, T z)
     *  @see - scale(vec<3, T, Q> const& v)
     *  @see <a href="https://www.khronos.org/registry/OpenGL-Refpages/gl2.1/xhtml/glScale.xml">glScale man page</a>
     */
    fun scale(m: Mat3, v: Vec3): Mat3 =
            scale(m, v.x, v.y, v.z, Mat3())

    /** Builds a scale 3 * 3 matrix created from 3 scalars.
     *
     *  @param res resulting scale matrix.
     *  @param m Input matrix multiplied by this scale matrix.
     *  @param vX Ratio of scaling for X axis.
     *  @param vY Ratio of scaling for Y axis.
     *  @param vZ Ratio of scaling for Z axis.
     *
     *  @see gtc_matrix_transform
     *  @see - scale(mat<3, 3, T, Q> const& m, T x, T y, T z)
     *  @see - scale(vec<3, T, Q> const& v)
     *  @see <a href="https://www.khronos.org/registry/OpenGL-Refpages/gl2.1/xhtml/glScale.xml">glScale man page</a>
     */
    fun scale(m: Mat3d, vX: Double, vY: Double, vZ: Double, res: Mat3d): Mat3d {

        res[0, 0] = m[0, 0] * vX
        res[0, 1] = m[0, 1] * vX
        res[0, 2] = m[0, 2] * vX

        res[1, 0] = m[1, 0] * vY
        res[1, 1] = m[1, 1] * vY
        res[1, 2] = m[1, 2] * vY

        res[2, 0] = m[2, 0] * vZ
        res[2, 1] = m[2, 1] * vZ
        res[2, 2] = m[2, 2] * vZ

        return res
    }

    /** Builds a scale 3 * 3 matrix created from 3 scalars.
     *
     *  @param res resulting scale matrix.
     *  @param m Input matrix multiplied by this scale matrix.
     *  @param v Ratio of scaling for this axis.
     *
     *  @see gtc_matrix_transform
     *  @see - scale(mat<3, 3, T, Q> const& m, T x, T y, T z)
     *  @see - scale(vec<3, T, Q> const& v)
     *  @see <a href="https://www.khronos.org/registry/OpenGL-Refpages/gl2.1/xhtml/glScale.xml">glScale man page</a>
     */
    fun scale(m: Mat3d, v: Vec3d, res: Mat3d): Mat3d =
            scale(m, v.x, v.y, v.z, res)

    /** Builds a scale 3 * 3 matrix created from 3 scalars.
     *
     *  @param m Input matrix multiplied by this scale matrix.
     *  @param vX Ratio of scaling for X axis.
     *  @param vY Ratio of scaling for Y axis.
     *  @param vZ Ratio of scaling for Z axis.
     *
     *  @see gtc_matrix_transform
     *  @see - scale(mat<3, 3, T, Q> const& m, T x, T y, T z)
     *  @see - scale(vec<3, T, Q> const& v)
     *  @see <a href="https://www.khronos.org/registry/OpenGL-Refpages/gl2.1/xhtml/glScale.xml">glScale man page</a>
     */
    fun scale(m: Mat3d, vX: Double, vY: Double, vZ: Double): Mat3d =
            scale(m, vX, vY, vZ, Mat3d())

    /** Builds a scale 3 * 3 matrix created from 3 scalars.
     *
     *  @param m Input matrix multiplied by this scale matrix.
     *  @param v Ratio of scaling for this axis.
     *
     *  @see gtc_matrix_transform
     *  @see - scale(mat<3, 3, T, Q> const& m, T x, T y, T z)
     *  @see - scale(vec<3, T, Q> const& v)
     *  @see <a href="https://www.khronos.org/registry/OpenGL-Refpages/gl2.1/xhtml/glScale.xml">glScale man page</a>
     */
    fun scale(m: Mat3d, v: Vec3d): Mat3d =
            scale(m, v.x, v.y, v.z, Mat3d())


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
    fun lookAtRh(eye: Vec3, center: Vec3, up: Vec3, res: Mat4): Mat4 {
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
    fun lookAtRh(eye: Vec3, center: Vec3, up: Vec3): Mat4 =
            lookAtRh(eye, center, up, Mat4())

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
    fun lookAtLh(eye: Vec3, center: Vec3, up: Vec3, res: Mat4): Mat4 {

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
    fun lookAtLh(eye: Vec3, center: Vec3, up: Vec3): Mat4 =
            lookAtLh(eye, center, up, Mat4())

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
    fun lookAt(eye: Vec3, center: Vec3, up: Vec3, res: Mat4): Mat4 =
            when (GLM_COORDINATE_SYSTEM) {
                GlmCoordinateSystem.LEFT_HANDED -> lookAtLh(eye, center, up, res)
                else -> lookAtRh(eye, center, up, res)
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
    fun lookAt(eye: Vec3, center: Vec3, up: Vec3): Mat4 =
            when (GLM_COORDINATE_SYSTEM) {
                GlmCoordinateSystem.LEFT_HANDED -> lookAtLh(eye, center, up, Mat4())
                else -> lookAtRh(eye, center, up, Mat4())
            }


    // -----------------------------------------------------------------------------------------------------------------
    // Mat4d version
    // -----------------------------------------------------------------------------------------------------------------


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
    fun lookAtRh(eye: Vec3d, center: Vec3d, up: Vec3d, res: Mat4d): Mat4d {
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
    fun lookAtRh(eye: Vec3d, center: Vec3d, up: Vec3d): Mat4d =
            lookAtRh(eye, center, up, Mat4d())

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
    fun lookAtLh(eye: Vec3d, center: Vec3d, up: Vec3d, res: Mat4d): Mat4d {

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
    fun lookAtLh(eye: Vec3d, center: Vec3d, up: Vec3d): Mat4d =
            lookAtLh(eye, center, up, Mat4d())

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
    fun lookAt(eye: Vec3d, center: Vec3d, up: Vec3d, res: Mat4d): Mat4d =
            when (GLM_COORDINATE_SYSTEM) {
                GlmCoordinateSystem.LEFT_HANDED -> lookAtLh(eye, center, up, res)
                else -> lookAtRh(eye, center, up, res)
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
    fun lookAt(eye: Vec3d, center: Vec3d, up: Vec3d): Mat4d =
            when (GLM_COORDINATE_SYSTEM) {
                GlmCoordinateSystem.LEFT_HANDED -> lookAtLh(eye, center, up, Mat4d())
                else -> lookAtRh(eye, center, up, Mat4d())
            }
}