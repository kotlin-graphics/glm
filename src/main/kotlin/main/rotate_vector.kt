package main

import vec._3.Vec3
import main.Glm.dot
import main.Glm.acos
import main.Glm.sin
import main.Glm.cos
import main.Glm.cross
import mat.Mat4
import vec._2.Vec2
import vec._4.Vec4

/**
 * Created by GBarbieri on 09.02.2017.
 */


interface rotate_vector {

    /** Returns Spherical interpolation between two vectors
     *
     *  @param res the result
     *  @param a first vector
     *  @param b second vector
     *  @param factor the interpolation factor, defined in [0, 1]
     * */
    fun slerp(res: Vec3, a: Vec3, b: Vec3, factor: Float): Vec3 {

        // get cosine of angle between vectors (-1 -> 1)
        val cosAlpha = dot(a, b)
        // get angle (0 -> pi)
        val alpha = acos(cosAlpha)
        // get sine of angle between vectors (0 -> 1)
        val sinAlpha = sin(alpha)
        // this breaks down when SinAlpha = 0, i.e. Alpha = 0 or pi
        val t1X = sin((1f - a.x) * alpha) / sinAlpha
        val t1Y = sin((1f - a.y) * alpha) / sinAlpha
        val t1Z = sin((1f - a.z) * alpha) / sinAlpha
        val t2X = sin(a.x * alpha) / sinAlpha
        val t2Y = sin(a.x * alpha) / sinAlpha
        val t2Z = sin(a.z * alpha) / sinAlpha

        // interpolate src vectors
        res.x = a.x * t1X + b.x * t2X
        res.y = a.y * t1Y + b.y * t2Y
        res.z = a.z * t1Z + b.z * t2Z
        return res
    }

    /**
     * Rotate a two dimensional vector.
     */
    fun rotate(res: Vec2, v: Vec2, angle: Float): Vec2 {

        val cos = cos(angle)
        val sin = sin(angle)

        res.x = v.x * cos - v.y * sin
        res.y = v.x * sin + v.y * cos
        return res
    }

    /**
     * Rotate a three dimensional vector around an axis.
     */
    fun rotate(res: Vec3, v: Vec3, angle: Float, normal: Vec3, tmp: Mat4 = Mat4()): Vec3 {
        glm.rotate(tmp, angle, normal)
        res[0] = tmp[0][0] * v.x + tmp[1][0] * v.y + tmp[2][0] * v.z
        res[1] = tmp[0][1] * v.x + tmp[1][1] * v.y + tmp[2][1] * v.z
        res[2] = tmp[0][2] * v.x + tmp[1][2] * v.y + tmp[2][2] * v.z
        return res
    }

    /**
     * Rotate a four dimensional vector around an axis.
     */
    fun rotate(res: Vec4, v: Vec4, angle: Float, normal: Vec3, tmp: Mat4 = Mat4()): Vec4 {
        glm.rotate(tmp, angle, normal)
        res[0] = tmp[0][0] * v.x + tmp[1][0] * v.y + tmp[2][0] * v.z + tmp[3][0] * v.w
        res[1] = tmp[0][1] * v.x + tmp[1][1] * v.y + tmp[2][1] * v.z + tmp[3][1] * v.w
        res[2] = tmp[0][2] * v.x + tmp[1][2] * v.y + tmp[2][2] * v.z + tmp[3][2] * v.w
        res[3] = tmp[0][3] * v.x + tmp[1][3] * v.y + tmp[2][3] * v.z + tmp[3][3] * v.w
        return res
    }

    /**
     * Rotate a three dimensional vector around the X axis.
     */
    fun rotateX(res: Vec3, v: Vec3, angle: Float): Vec3 {

        res put v
        val cos = cos(angle)
        val sin = sin(angle)

        res.y = v.y * cos - v.z * sin
        res.z = v.y * sin + v.z * cos
        return res
    }

    /**
     * Rotate a three dimensional vector around the Y axis.
     */
    fun rotateY(res: Vec3, v: Vec3, angle: Float): Vec3 {

        res put v
        val cos = cos(angle)
        val sin = sin(angle)

        res.x = v.x * cos + v.z * sin
        res.z = -v.x * sin + v.z * cos
        return res
    }

    /**
     * Rotate a three dimensional vector around the Z axis.
     */
    fun rotateZ(res: Vec3, v: Vec3, angle: Float): Vec3 {

        res put v
        val cos = cos(angle)
        val sin = sin(angle)

        res.x = v.x * cos - v.y * sin
        res.y = v.x * sin + v.y * cos
        return res
    }

    /**
     * Rotate a four dimensional vector around the X axis.
     */
    fun rotateX(res: Vec4, v: Vec4, angle: Float): Vec4 {

        res put v
        val cos = cos(angle)
        val sin = sin(angle)

        res.y = v.y * cos - v.z * sin
        res.z = v.y * sin + v.z * cos
        return res
    }

    /**
     * Rotate a four dimensional vector around the Y axis.
     */
    fun rotateY(res: Vec4, v: Vec4, angle: Float): Vec4 {

        res put v
        val cos = cos(angle)
        val sin = sin(angle)

        res.x = v.x * cos + v.z * sin
        res.z = -v.x * sin + v.z * cos
        return res
    }

    /**
     * Rotate a four dimensional vector around the Z axis.
     */
    fun rotateZ(res: Vec4, v: Vec4, angle: Float): Vec4 {

        res put v
        val cos = cos(angle)
        val sin = sin(angle)

        res.x = v.x * cos - v.y * sin
        res.y = v.x * sin + v.y * cos
        return res
    }

    /**
     * Build a rotation matrix from a normal and a up vector.
     */
    fun orientation(res: Mat4, normal: Vec3, up: Vec3, tmp: Vec3 = Vec3()): Mat4 {

        if(normal.x == up.x && normal.y == up.y && normal.z == up.z)
            return res put 1f

        val rotationAxis = cross(tmp, up, normal)
        val angle = acos(dot(normal, up))

        return glm.rotate(res, angle, rotationAxis)
    }
}