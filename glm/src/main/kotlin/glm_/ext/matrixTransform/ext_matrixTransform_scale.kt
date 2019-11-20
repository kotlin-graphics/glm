package glm_.ext.matrixTransform

import glm_.mat4x4.Mat4
import glm_.mat4x4.Mat4d
import glm_.mat3x3.Mat3
import glm_.mat3x3.Mat3d
import glm_.vec3.Vec3
import glm_.vec3.Vec3d

interface ext_matrixTransform_scale {

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
}