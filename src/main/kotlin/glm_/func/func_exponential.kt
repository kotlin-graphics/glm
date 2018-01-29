package glm_.func

import glm_.d
import glm_.i
import glm_.vec1.Vec1
import glm_.vec1.Vec1d
import glm_.vec2.Vec2
import glm_.vec2.Vec2d
import glm_.vec3.Vec3
import glm_.vec3.Vec3d
import glm_.vec4.Vec4
import glm_.vec4.Vec4d
import kotlin.math.ln
import kotlin.math.pow
import kotlin.math.exp as _exp
import kotlin.math.log2 as _log2
import kotlin.math.sqrt as _sqrt

/**
 * Created by GBarbieri on 12.12.2016.
 */

interface func_exponential {

    fun pow(base: Double, exponent: Double) = base.pow(exponent)
    fun pow(base: Float, exponent: Float) = base.pow(exponent)


    fun pow(base: Vec1, exponent: Float, res: Vec1 = Vec1()): Vec1 {
        res.x = pow(base.x, exponent)
        return res
    }

    fun pow(base: Vec1, exponent: Vec1, res: Vec1 = Vec1()): Vec1 {
        res.x = pow(base.x, exponent.x)
        return res
    }

    fun pow(base: Vec1d, exponent: Double, res: Vec1d = Vec1d()): Vec1d {
        res.x = pow(base.x, exponent)
        return res
    }

    fun pow(base: Vec1d, exponent: Vec1d, res: Vec1d = Vec1d()): Vec1d {
        res.x = pow(base.x, exponent.x)
        return res
    }


    fun pow(base: Vec2, exponent: Float, res: Vec2 = Vec2()): Vec2 {
        res.x = pow(base.x, exponent)
        res.y = pow(base.y, exponent)
        return res
    }

    fun pow(base: Vec2, exponent: Vec2, res: Vec2 = Vec2()): Vec2 {
        res.x = pow(base.x, exponent.x)
        res.y = pow(base.y, exponent.y)
        return res
    }

    fun pow(base: Vec2d, exponent: Double, res: Vec2d = Vec2d()): Vec2d {
        res.x = pow(base.x, exponent)
        res.y = pow(base.y, exponent)
        return res
    }

    fun pow(base: Vec2d, exponent: Vec2d, res: Vec2d = Vec2d()): Vec2d {
        res.x = pow(base.x, exponent.x)
        res.y = pow(base.y, exponent.y)
        return res
    }


    fun pow(base: Vec3, exponent: Float, res: Vec3 = Vec3()): Vec3 {
        res.x = pow(base.x, exponent)
        res.y = pow(base.y, exponent)
        res.z = pow(base.z, exponent)
        return res
    }

    fun pow(base: Vec3, exponent: Vec3, res: Vec3 = Vec3()): Vec3 {
        res.x = pow(base.x, exponent.x)
        res.y = pow(base.y, exponent.y)
        res.z = pow(base.z, exponent.z)
        return res
    }

    fun pow(base: Vec3d, exponent: Double, res: Vec3d = Vec3d()): Vec3d {
        res.x = pow(base.x, exponent)
        res.y = pow(base.y, exponent)
        res.z = pow(base.z, exponent)
        return res
    }

    fun pow(base: Vec3d, exponent: Vec3d, res: Vec3d = Vec3d()): Vec3d {
        res.x = pow(base.x, exponent.x)
        res.y = pow(base.y, exponent.y)
        res.z = pow(base.z, exponent.z)
        return res
    }

    
    fun pow(base: Vec4, exponent: Float, res: Vec4 = Vec4()): Vec4 {
        res.x = pow(base.x, exponent)
        res.y = pow(base.y, exponent)
        res.z = pow(base.z, exponent)
        res.w = pow(base.w, exponent)
        return res
    }

    fun pow(base: Vec4, exponent: Vec4, res: Vec4 = Vec4()): Vec4 {
        res.x = pow(base.x, exponent.x)
        res.y = pow(base.y, exponent.y)
        res.z = pow(base.z, exponent.z)
        res.w = pow(base.w, exponent.w)
        return res
    }

    fun pow(base: Vec4d, exponent: Double, res: Vec4d = Vec4d()): Vec4d {
        res.x = pow(base.x, exponent)
        res.y = pow(base.y, exponent)
        res.z = pow(base.z, exponent)
        res.w = pow(base.w, exponent)
        return res
    }

    fun pow(base: Vec4d, exponent: Vec4d, res: Vec4d = Vec4d()): Vec4d {
        res.x = pow(base.x, exponent.x)
        res.y = pow(base.y, exponent.y)
        res.z = pow(base.z, exponent.z)
        res.w = pow(base.w, exponent.w)
        return res
    }

    fun exp(a: Double) = _exp(a)
    fun exp(a: Float) = _exp(a)
    
    fun exp(a: Vec1, res: Vec1 = Vec1()): Vec1 {
        res.x = exp(a.x)
        return res
    }

    fun exp(a: Vec1d, res: Vec1d = Vec1d()): Vec1d {
        res.x = exp(a.x)
        return res
    }
    
    fun exp(a: Vec2, res: Vec2 = Vec2()): Vec2 {
        res.x = exp(a.x)
        res.y = exp(a.y)
        return res
    }

    fun exp(a: Vec2d, res: Vec2d = Vec2d()): Vec2d {
        res.x = exp(a.x)
        res.y = exp(a.y)
        return res
    }

    fun exp(a: Vec3, res: Vec3 = Vec3()): Vec3 {
        res.x = exp(a.x)
        res.y = exp(a.y)
        res.z = exp(a.z)
        return res
    }

    fun exp(a: Vec3d, res: Vec3d = Vec3d()): Vec3d {
        res.x = exp(a.x)
        res.y = exp(a.y)
        res.z = exp(a.z)
        return res
    }

    fun exp(a: Vec4, res: Vec4 = Vec4()): Vec4 {
        res.x = exp(a.x)
        res.y = exp(a.y)
        res.z = exp(a.z)
        res.w = exp(a.w)
        return res
    }

    fun exp(a: Vec4d, res: Vec4d = Vec4d()): Vec4d {
        res.x = exp(a.x)
        res.y = exp(a.y)
        res.z = exp(a.z)
        res.w = exp(a.w)
        return res
    }


    fun log(a: Double) = ln(a)
    fun log(a: Float) = ln(a)

    fun log(a: Vec1, res: Vec1 = Vec1()): Vec1 {
        res.x = log(a.x)
        return res
    }

    fun log(a: Vec1d, res: Vec1d = Vec1d()): Vec1d {
        res.x = log(a.x)
        return res
    }
    
    fun log(a: Vec2, res: Vec2 = Vec2()): Vec2 {
        res.x = log(a.x)
        res.y = log(a.y)
        return res
    }

    fun log(a: Vec2d, res: Vec2d = Vec2d()): Vec2d {
        res.x = log(a.x)
        res.y = log(a.y)
        return res
    }

    fun log(a: Vec3, res: Vec3 = Vec3()): Vec3 {
        res.x = log(a.x)
        res.y = log(a.y)
        res.z = log(a.z)
        return res
    }

    fun log(a: Vec3d, res: Vec3d = Vec3d()): Vec3d {
        res.x = log(a.x)
        res.y = log(a.y)
        res.z = log(a.z)
        return res
    }

    fun log(a: Vec4, res: Vec4 = Vec4()): Vec4 {
        res.x = log(a.x)
        res.y = log(a.y)
        res.z = log(a.z)
        res.w = log(a.w)
        return res
    }

    fun log(a: Vec4d, res: Vec4d = Vec4d()): Vec4d {
        res.x = log(a.x)
        res.y = log(a.y)
        res.z = log(a.z)
        res.w = log(a.w)
        return res
    }


    fun exp2(a: Double) = 2.0.pow(a)
    fun exp2(a: Float) = 2f.pow(a)

    fun exp2(a: Vec1, res: Vec1 = Vec1()): Vec1 {
        res.x = exp2(a.x)
        return res
    }

    fun exp2(a: Vec1d, res: Vec1d = Vec1d()): Vec1d {
        res.x = exp2(a.x)
        return res
    }
    
    fun exp2(a: Vec2, res: Vec2 = Vec2()): Vec2 {
        res.x = exp2(a.x)
        res.y = exp2(a.y)
        return res
    }

    fun exp2(a: Vec2d, res: Vec2d = Vec2d()): Vec2d {
        res.x = exp2(a.x)
        res.y = exp2(a.y)
        return res
    }

    fun exp2(a: Vec3, res: Vec3 = Vec3()): Vec3 {
        res.x = exp2(a.x)
        res.y = exp2(a.y)
        res.z = exp2(a.z)
        return res
    }

    fun exp2(a: Vec3d, res: Vec3d = Vec3d()): Vec3d {
        res.x = exp2(a.x)
        res.y = exp2(a.y)
        res.z = exp2(a.z)
        return res
    }

    fun exp2(a: Vec4, res: Vec4 = Vec4()): Vec4 {
        res.x = exp2(a.x)
        res.y = exp2(a.y)
        res.z = exp2(a.z)
        res.w = exp2(a.w)
        return res
    }

    fun exp2(a: Vec4d, res: Vec4d = Vec4d()): Vec4d {
        res.x = exp2(a.x)
        res.y = exp2(a.y)
        res.z = exp2(a.z)
        res.w = exp2(a.w)
        return res
    }


    fun log2(a: Double) = _log2(a)
    fun log2(a: Float) = _log2(a)
    fun log2(a: Int) = _log2(a.d).i

    fun log2(a: Vec1, res: Vec1 = Vec1()): Vec1 {
        res.x = log2(a.x)
        return res
    }

    fun log2(a: Vec1d, res: Vec1d = Vec1d()): Vec1d {
        res.x = log2(a.x)
        return res
    }
    
    fun log2(a: Vec2, res: Vec2 = Vec2()): Vec2 {
        res.x = log2(a.x)
        res.y = log2(a.y)
        return res
    }

    fun log2(a: Vec2d, res: Vec2d = Vec2d()): Vec2d {
        res.x = log2(a.x)
        res.y = log2(a.y)
        return res
    }

    fun log2(a: Vec3, res: Vec3 = Vec3()): Vec3 {
        res.x = log2(a.x)
        res.y = log2(a.y)
        res.z = log2(a.z)
        return res
    }

    fun log2(a: Vec3d, res: Vec3d = Vec3d()): Vec3d {
        res.x = log2(a.x)
        res.y = log2(a.y)
        res.z = log2(a.z)
        return res
    }

    fun log2(a: Vec4, res: Vec4 = Vec4()): Vec4 {
        res.x = log2(a.x)
        res.y = log2(a.y)
        res.z = log2(a.z)
        res.w = log2(a.w)
        return res
    }

    fun log2(a: Vec4d, res: Vec4d = Vec4d()): Vec4d {
        res.x = log2(a.x)
        res.y = log2(a.y)
        res.z = log2(a.z)
        res.w = log2(a.w)
        return res
    }


    fun sqrt(a: Double) = _sqrt(a)
    fun sqrt(a: Float) = _sqrt(a)

    fun sqrt(a: Vec1, res: Vec1 = Vec1()): Vec1 {
        res.x = sqrt(a.x)
        return res
    }

    fun sqrt(a: Vec1d, res: Vec1d = Vec1d()): Vec1d {
        res.x = sqrt(a.x)
        return res
    }
    
    fun sqrt(a: Vec2, res: Vec2 = Vec2()): Vec2 {
        res.x = sqrt(a.x)
        res.y = sqrt(a.y)
        return res
    }

    fun sqrt(a: Vec2d, res: Vec2d = Vec2d()): Vec2d {
        res.x = sqrt(a.x)
        res.y = sqrt(a.y)
        return res
    }

    fun sqrt(a: Vec3, res: Vec3 = Vec3()): Vec3 {
        res.x = sqrt(a.x)
        res.y = sqrt(a.y)
        res.z = sqrt(a.z)
        return res
    }

    fun sqrt(a: Vec3d, res: Vec3d = Vec3d()): Vec3d {
        res.x = sqrt(a.x)
        res.y = sqrt(a.y)
        res.z = sqrt(a.z)
        return res
    }

    fun sqrt(a: Vec4, res: Vec4 = Vec4()): Vec4 {
        res.x = sqrt(a.x)
        res.y = sqrt(a.y)
        res.z = sqrt(a.z)
        res.w = sqrt(a.w)
        return res
    }

    fun sqrt(a: Vec4d, res: Vec4d = Vec4d()): Vec4d {
        res.x = sqrt(a.x)
        res.y = sqrt(a.y)
        res.z = sqrt(a.z)
        res.w = sqrt(a.w)
        return res
    }


    fun inverseSqrt(a: Double) = 1.0 / _sqrt(a)
    fun inverseSqrt(a: Float) = 1f / _sqrt(a)

    fun inverseSqrt(a: Vec1, res: Vec1 = Vec1()): Vec1 {
        res.x = inverseSqrt(a.x)
        return res
    }

    fun inverseSqrt(a: Vec1d, res: Vec1d = Vec1d()): Vec1d {
        res.x = inverseSqrt(a.x)
        return res
    }
    
    fun inverseSqrt(a: Vec2, res: Vec2 = Vec2()): Vec2 {
        res.x = inverseSqrt(a.x)
        res.y = inverseSqrt(a.y)
        return res
    }

    fun inverseSqrt(a: Vec2d, res: Vec2d = Vec2d()): Vec2d {
        res.x = inverseSqrt(a.x)
        res.y = inverseSqrt(a.y)
        return res
    }

    fun inverseSqrt(a: Vec3, res: Vec3 = Vec3()): Vec3 {
        res.x = inverseSqrt(a.x)
        res.y = inverseSqrt(a.y)
        res.z = inverseSqrt(a.z)
        return res
    }

    fun inverseSqrt(a: Vec3d, res: Vec3d = Vec3d()): Vec3d {
        res.x = inverseSqrt(a.x)
        res.y = inverseSqrt(a.y)
        res.z = inverseSqrt(a.z)
        return res
    }

    fun inverseSqrt(a: Vec4, res: Vec4 = Vec4()): Vec4 {
        res.x = inverseSqrt(a.x)
        res.y = inverseSqrt(a.y)
        res.z = inverseSqrt(a.z)
        res.w = inverseSqrt(a.w)
        return res
    }

    fun inverseSqrt(a: Vec4d, res: Vec4d = Vec4d()): Vec4d {
        res.x = inverseSqrt(a.x)
        res.y = inverseSqrt(a.y)
        res.z = inverseSqrt(a.z)
        res.w = inverseSqrt(a.w)
        return res
    }
}