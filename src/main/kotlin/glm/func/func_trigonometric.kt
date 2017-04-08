package glm.func

import glm.d
import glm.f
import glm.vec._2.Vec2
import glm.vec._2.Vec2d
import glm.vec._3.Vec3
import glm.vec._3.Vec3d
import glm.vec._4.Vec4
import glm.vec._4.Vec4d

/**
 * Created by GBarbieri on 12.12.2016.
 */

interface func_trigonometric {

    fun cos(angle: Double) = Math.cos(angle)
    fun cos(angle: Float) = Math.cos(angle.d).f

    fun sin(angle: Double) = Math.sin(angle)
    fun sin(angle: Float) = Math.sin(angle.d).f

    fun tan(angle: Double) = Math.tan(angle)
    fun tan(angle: Float) = Math.tan(angle.d).f


    fun acos(angle: Double) = Math.acos(angle)
    fun acos(angle: Float) = Math.acos(angle.d).f

    fun asin(angle: Double) = Math.asin(angle)
    fun asin(angle: Float) = Math.asin(angle.d).f

    fun atan(angle: Double) = Math.atan(angle)
    fun atan(angle: Float) = Math.atan(angle.d).f

    fun atan(y: Double, x: Double) = Math.atan2(y, x)
    fun atan(y: Float, x: Float) = Math.atan2(y.d, x.d).f


    fun degrees(rad: Float) = Math.toDegrees(rad.d).f
    fun degrees(rad: Double) = Math.toDegrees(rad)

    fun degrees(rad: Vec2) = degrees(rad, Vec2())
    fun degrees(rad: Vec2d) = degrees(rad, Vec2d())
    fun degrees(rad: Vec3) = degrees(rad, Vec3())
    fun degrees(rad: Vec3d) = degrees(rad, Vec3d())
    fun degrees(rad: Vec4) = degrees(rad, Vec4())
    fun degrees(rad: Vec4d) = degrees(rad, Vec4d())
    
    fun degrees(rad: Vec2, res: Vec2): Vec2 {
        res.x = Math.toDegrees(rad.x.d).f
        res.y = Math.toDegrees(rad.y.d).f
        return res
    }

    fun degrees(rad: Vec2d, res: Vec2d): Vec2d {
        res.x = Math.toDegrees(rad.x)
        res.y = Math.toDegrees(rad.y)
        return res
    }

    fun degrees(rad: Vec3, res: Vec3): Vec3 {
        res.x = Math.toDegrees(rad.x.d).f
        res.y = Math.toDegrees(rad.y.d).f
        res.z = Math.toDegrees(rad.z.d).f
        return res
    }

    fun degrees(rad: Vec3d, res: Vec3d): Vec3d {
        res.x = Math.toDegrees(rad.x)
        res.y = Math.toDegrees(rad.y)
        res.z = Math.toDegrees(rad.z)
        return res
    }

    fun degrees(rad: Vec4, res: Vec4): Vec4 {
        res.x = Math.toDegrees(rad.x.d).f
        res.y = Math.toDegrees(rad.y.d).f
        res.z = Math.toDegrees(rad.z.d).f
        return res
    }

    fun degrees(rad: Vec4d, res: Vec4d): Vec4d {
        res.x = Math.toDegrees(rad.x)
        res.y = Math.toDegrees(rad.y)
        res.z = Math.toDegrees(rad.z)
        return res
    }

    fun radians(deg: Float) = Math.toRadians(deg.d).f
    fun radians(deg: Double) = Math.toRadians(deg)

    fun radians(rad: Vec2) = radians(rad, Vec2())
    fun radians(rad: Vec2d) = radians(rad, Vec2d())
    fun radians(rad: Vec3) = radians(rad, Vec3())
    fun radians(rad: Vec3d) = radians(rad, Vec3d())
    fun radians(rad: Vec4) = radians(rad, Vec4())
    fun radians(rad: Vec4d) = radians(rad, Vec4d())

    fun radians(deg: Vec2, res: Vec2): Vec2 {
        res.x = Math.toRadians(deg.x.d).f
        res.y = Math.toRadians(deg.y.d).f
        return res
    }

    fun radians(deg: Vec2d, res: Vec2d): Vec2d {
        res.x = Math.toRadians(deg.x)
        res.y = Math.toRadians(deg.y)
        return res
    }

    fun radians(deg: Vec3, res: Vec3): Vec3 {
        res.x = Math.toRadians(deg.x.d).f
        res.y = Math.toRadians(deg.y.d).f
        res.z = Math.toRadians(deg.z.d).f
        return res
    }

    fun radians(deg: Vec3d, res: Vec3d): Vec3d {
        res.x = Math.toRadians(deg.x)
        res.y = Math.toRadians(deg.y)
        res.z = Math.toRadians(deg.z)
        return res
    }

    fun radians(deg: Vec4, res: Vec4): Vec4 {
        res.x = Math.toRadians(deg.x.d).f
        res.y = Math.toRadians(deg.y.d).f
        res.z = Math.toRadians(deg.z.d).f
        return res
    }

    fun radians(deg: Vec4d, res: Vec4d): Vec4d {
        res.x = Math.toRadians(deg.x)
        res.y = Math.toRadians(deg.y)
        res.z = Math.toRadians(deg.z)
        return res
    }
}