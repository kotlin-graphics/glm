package glm_.ext

import glm_.Mat4

/** Creates a matrix for projecting two-dimensional coordinates onto the screen.
 *
 *  @see gtc_matrix_transform
 *  @see - glm.ortho(left: Float, right: Float, bottom: Float, top: Float, zNear: Float, zFar: Float)
 *  @see <a href="https://www.khronos.org/registry/OpenGL-Refpages/gl2.1/xhtml/gluOrtho2D.xml">gluOrtho2D man page</a>
 */
fun ortho(left: Float, right: Float, bottom: Float, top: Float, res: Mat4): Mat4 {
//    res put 1f
//    res[0, 0] = 2f / (right - left)
//    res[1, 1] = 2f / (top - bottom)
//    res[2, 2] = -1f
//    res[3, 0] = -(right + left) / (right - left)
//    res[3, 1] = -(top + bottom) / (top - bottom)
    return res
}