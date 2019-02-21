package glm_.gtc.matrixTransform

import glm_.glm
import glm_.mat3x3.Mat3
import glm_.mat3x3.Mat3d
import glm_.mat4x4.Mat4
import glm_.mat4x4.Mat4d
import glm_.vec3.Vec3
import glm_.vec3.Vec3d
import kotlin.math.cos
import kotlin.math.sin

interface gtcMatrixRotate {

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
    fun rotate(res: Mat4, m: Mat4, angle: Float, axisX: Float, axisY: Float, axisZ: Float): Mat4 {

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
    fun rotate(res: Mat4, m: Mat4, angle: Float, axis: Vec3): Mat4 = rotate(res, m, angle, axis.x, axis.y, axis.z)

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
    fun rotate(m: Mat4, angle: Float, axisX: Float, axisY: Float, axisZ: Float): Mat4 = rotate(Mat4(), m, angle, axisX, axisY, axisZ)

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
    fun rotate(m: Mat4, angle: Float, axis: Vec3): Mat4 = rotate(Mat4(), m, angle, axis.x, axis.y, axis.z)

    fun rotateX(res: Mat3, mat: Mat3, angle: Float): Mat3 {
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

    fun rotateX(mat: Mat3, angle: Float): Mat3 = rotateX(Mat3(), mat, angle)

    fun rotateY(res: Mat3, mat: Mat3, angle: Float): Mat3 {
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

    fun rotateY(mat: Mat3, angle: Float): Mat3 = rotateY(Mat3(), mat, angle)

    fun rotateZ(res: Mat3, mat: Mat3, angle: Float): Mat3 {
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

    fun rotateZ(mat: Mat3, angle: Float): Mat3 = rotateZ(Mat3(), mat, angle)

    fun rotateXYZ(res: Mat3, mat: Mat3, angleX: Float, angleY: Float, angleZ: Float): Mat3 {
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

    fun rotateXYZ(mat: Mat3, angleX: Float, angleY: Float, angleZ: Float): Mat3 = rotateXYZ(Mat3(), mat, angleX, angleY, angleZ)

    fun rotateX(res: Mat4, mat: Mat4, angle: Float): Mat4 {
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

    fun rotateX(mat: Mat4, angle: Float): Mat4 = rotateX(Mat4(), mat, angle)

    fun rotateY(res: Mat4, mat: Mat4, angle: Float): Mat4 {
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

    fun rotateY(mat: Mat4, angle: Float): Mat4 = rotateY(Mat4(), mat, angle)

    fun rotateZ(res: Mat4, mat: Mat4, angle: Float): Mat4 {
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

    fun rotateZ(mat: Mat4, angle: Float): Mat4 = rotateZ(Mat4(), mat, angle)

    fun rotateXYZ(res: Mat4, mat: Mat4, angleX: Float, angleY: Float, angleZ: Float): Mat4 {
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

    fun rotateXYZ(mat: Mat4, angleX: Float, angleY: Float, angleZ: Float): Mat4 = rotateXYZ(Mat4(), mat, angleX, angleY, angleZ)


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
    fun rotate(res: Mat4d, m: Mat4d, angle: Double, axisX: Double, axisY: Double, axisZ: Double): Mat4d {

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
    fun rotate(res: Mat4d, m: Mat4d, angle: Double, axis: Vec3d): Mat4d = rotate(res, m, angle, axis.x, axis.y, axis.z)

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
    fun rotate(m: Mat4d, angle: Double, axisX: Double, axisY: Double, axisZ: Double): Mat4d = rotate(Mat4d(), m, angle, axisX, axisY, axisZ)

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
    fun rotate(m: Mat4d, angle: Double, axis: Vec3d): Mat4d = rotate(Mat4d(), m, angle, axis.x, axis.y, axis.z)

    fun rotateX(res: Mat3d, mat: Mat3d, angle: Double): Mat3d {
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

    fun rotateX(mat: Mat3d, angle: Double): Mat3d = rotateX(Mat3d(), mat, angle)

    fun rotateY(res: Mat3d, mat: Mat3d, angle: Double): Mat3d {
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

    fun rotateY(mat: Mat3d, angle: Double): Mat3d = rotateY(Mat3d(), mat, angle)

    fun rotateZ(res: Mat3d, mat: Mat3d, angle: Double): Mat3d {
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

    fun rotateZ(mat: Mat3d, angle: Double): Mat3d = rotateZ(Mat3d(), mat, angle)

    fun rotateXYZ(res: Mat3d, mat: Mat3d, angleX: Double, angleY: Double, angleZ: Double): Mat3d {
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

    fun rotateXYZ(mat: Mat3d, angleX: Double, angleY: Double, angleZ: Double): Mat3d = rotateXYZ(Mat3d(), mat, angleX, angleY, angleZ)

    fun rotateX(res: Mat4d, mat: Mat4d, angle: Double): Mat4d {
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

    fun rotateX(mat: Mat4d, angle: Double): Mat4d = rotateX(Mat4d(), mat, angle)

    fun rotateY(res: Mat4d, mat: Mat4d, angle: Double): Mat4d {
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

    fun rotateY(mat: Mat4d, angle: Double): Mat4d = rotateY(Mat4d(), mat, angle)

    fun rotateZ(res: Mat4d, mat: Mat4d, angle: Double): Mat4d {
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

    fun rotateZ(mat: Mat4d, angle: Double): Mat4d = rotateZ(Mat4d(), mat, angle)

    fun rotateXYZ(res: Mat4d, mat: Mat4d, angleX: Double, angleY: Double, angleZ: Double): Mat4d {
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

    fun rotateXYZ(mat: Mat4d, angleX: Double, angleY: Double, angleZ: Double): Mat4d = rotateXYZ(Mat4d(), mat, angleX, angleY, angleZ)

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
}