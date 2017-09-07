package glm_.func

import glm_.d
import glm_.f
import glm_.vec2.Vec2
import glm_.vec2.Vec2d
import glm_.vec3.Vec3
import glm_.vec3.Vec3d
import glm_.vec4.Vec4
import glm_.vec4.Vec4d
import kotlin.math.atan2
import kotlin.math.acos as _acos
import kotlin.math.asin as _asin
import kotlin.math.atan as _atan
import kotlin.math.cos as _cos
import kotlin.math.sin as _sin
import kotlin.math.tan as _tan

/**
 * Created by GBarbieri on 12.12.2016.
 */

interface func_trigonometric {

    fun cos(angle: Double) = _cos(angle)
    fun cos(angle: Float) = _cos(angle.d).f

    fun sin(angle: Double) = _sin(angle)
    fun sin(angle: Float) = _sin(angle.d).f

    fun tan(angle: Double) = _tan(angle)
    fun tan(angle: Float) = _tan(angle.d).f


    fun acos(angle: Double) = _acos(angle)
    fun acos(angle: Float) = _acos(angle.d).f

    fun asin(angle: Double) = _asin(angle)
    fun asin(angle: Float) = _asin(angle.d).f

    fun atan(angle: Double) = _atan(angle)
    fun atan(angle: Float) = _atan(angle.d).f

    fun atan(y: Double, x: Double) = atan2(y, x)
    fun atan(y: Float, x: Float) = atan2(y.d, x.d).f


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

val Float.deg get() = Math.toDegrees(this.d).f
val Double.deg get() = Math.toDegrees(this)
val Float.rad get() = Math.toRadians(this.d).f
val Double.rad get() = Math.toRadians(this)

val Float.cos get() = _cos(this)
val Double.cos get() = _cos(this)
val Float.sin get() = _sin(this)
val Double.sin get() = _sin(this)