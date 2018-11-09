package glm_.gtc.matrixTransform

import glm_.mat4x4.Mat4
import glm_.mat4x4.Mat4d
import glm_.vec3.Vec3
import glm_.vec3.Vec3d


interface gtcMatrixTranslate {

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
    fun translate(res: Mat4, m: Mat4, vX: Float, vY: Float, vZ: Float): Mat4 {
        res put m
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
    fun translate(res: Mat4, m: Mat4, v: Vec3): Mat4 = translate(res, m, v.x, v.y, v.z)

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
    fun translate(m: Mat4, vX: Float, vY: Float, vZ: Float): Mat4 = translate(Mat4(), m, vX, vY, vZ)

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
    fun translate(m: Mat4, v: Vec3): Mat4 = translate(Mat4(), m, v.x, v.y, v.z)

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
    fun translate(res: Mat4d, m: Mat4d, vX: Double, vY: Double, vZ: Double): Mat4d {
        res put m
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
    fun translate(res: Mat4d, m: Mat4d, v: Vec3d): Mat4d = translate(res, m, v.x, v.y, v.z)

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
    fun translate(m: Mat4d, vX: Double, vY: Double, vZ: Double): Mat4d = translate(Mat4d(), m, vX, vY, vZ)

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
    fun translate(m: Mat4d, v: Vec3d): Mat4d = translate(Mat4d(), m, v.x, v.y, v.z)
}