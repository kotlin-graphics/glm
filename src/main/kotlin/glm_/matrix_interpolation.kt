package glm_

import glm_.mat4x4.Mat4
import glm_.vec3.Vec3
import kotlin.math.*

interface matrix_interpolation {

    /** @return angle */
    fun axisAngle(mat: Mat4, axis: Vec3): Float {

        val epsilon = 0.01f
        val epsilon2 = 0.1

        if (abs(mat[1, 0] - mat[0, 1]) < epsilon && abs(mat[2, 0] - mat[0, 2]) < epsilon && abs(mat[2, 1] - mat[1, 2]) < epsilon) {
            if (abs(mat[1, 0] + mat[0, 1]) < epsilon2 && abs(mat[2, 0] + mat[0, 2]) < epsilon2 && abs(mat[2, 1] + mat[1, 2]) < epsilon2 && abs(mat[0, 0] + mat[1, 1] + mat[2, 2] - 3f) < epsilon2) {
                axis.put(1f, 0f, 0f)
                return 0f
            }
            val xx = (mat[0, 0] + 1f) * 0.5f
            val yy = (mat[1, 1] + 1f) * 0.5f
            val zz = (mat[2, 2] + 1f) * 0.5f
            val xy = (mat[1, 0] + mat[0, 1]) * 0.25f
            val xz = (mat[2, 0] + mat[0, 2]) * 0.25f
            val yz = (mat[2, 1] + mat[1, 2]) * 0.25f
            if (xx > yy && xx > zz)
                if (xx < epsilon)
                    axis.put(0f, 0.7071f, 0.7071)
                else {
                    axis.x = sqrt(xx)
                    axis.y = xy / axis.x
                    axis.z = xz / axis.x
                }
            else if (yy > zz) {
                if (yy < epsilon)
                    axis.put(0.7071f, 0f, 0.7071)
                else {
                    axis.y = sqrt(yy)
                    axis.x = xy / axis.y
                    axis.z = yz / axis.y
                }
            } else
                if (zz < epsilon)
                    axis.put(0.7071f, 0.7071, 0f)
                else {
                    axis.z = sqrt(zz)
                    axis.x = xz / axis.z
                    axis.y = yz / axis.z
                }
            return glm.PIf
        }
        var s = sqrt((mat[2, 1] - mat[1, 2]) * (mat[2, 1] - mat[1, 2]) + (mat[2, 0] - mat[0, 2]) * (mat[2, 0] - mat[0, 2]) + (mat[1, 0] - mat[0, 1]) * (mat[1, 0] - mat[0, 1]))
        if (abs(s) < 0.001f) s = 1f
        val angleCos = (mat[0, 0] + mat[1, 1] + mat[2, 2] - 1f) * 0.5f
        axis.put((mat[1, 2] - mat[2, 1]) / s, (mat[2, 0] - mat[0, 2]) / s, (mat[0, 1] - mat[1, 0]) / s)
        return if (angleCos - 1f < epsilon) glm.PIf * 0.25f else acos(angleCos)
    }

    fun axisAngleMatrix(axis: Vec3, angle: Float): Mat4 {

        val c = cos(angle)
        val s = sin(angle)
        val t = 1f - c
        val n = axis.normalize()

        return Mat4(
                t * n.x * n.x + c, t * n.x * n.y + n.z * s, t * n.x * n.z - n.y * s, 0f,
                t * n.x * n.y - n.z * s, t * n.y * n.y + c, t * n.y * n.z + n.x * s, 0f,
                t * n.x * n.z + n.y * s, t * n.y * n.z - n.x * s, t * n.z * n.z + c, 0f,
                0f, 0f, 0f, 1f)
    }

    fun extractMatrixRotation(m: Mat4) = Mat4(
            m[0, 0], m[0, 1], m[0, 2], 0f,
            m[1, 0], m[1, 1], m[1, 2], 0f,
            m[2, 0], m[2, 1], m[2, 2], 0f,
            0f, 0f, 0f, 1f)

    fun interpolate(m1: Mat4, m2: Mat4, delta: Float):Mat4    {

        val m1rot = extractMatrixRotation(m1)
        val dltRotation = m2 * m1rot.transpose()
        val dltAxis = Vec3()
        val dltAngle = axisAngle(dltRotation, dltAxis)
        val out = axisAngleMatrix(dltAxis, dltAngle * delta) * m1rot
        out[3, 0] = m1[3, 0] + delta * (m2[3, 0] - m1[3, 0])
        out[3, 1] = m1[3, 1] + delta * (m2[3, 1] - m1[3, 1])
        out[3, 2] = m1[3, 2] + delta * (m2[3, 2] - m1[3, 2])
        return out
    }
}