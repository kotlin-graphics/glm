package glm_.func

import glm_.d
import glm_.f
import glm_.vec2.Vec2
import glm_.vec2.Vec2d
import glm_.vec3.Vec3
import glm_.vec3.Vec3d
import glm_.vec4.Vec4
import glm_.vec4.Vec4d

/**
 * Created by GBarbieri on 12.12.2016.
 */

interface func_exponential {

    fun pow(base: Double, exponent: Double) = Math.pow(base, exponent)
    fun pow(base: Float, exponent: Float) = Math.pow(base.d, exponent.d).f

    fun pow(base: Vec2, exponent: Float, res: Vec2 = Vec2()) {
        res.x = pow(base.x, exponent)
        res.y = pow(base.y, exponent)
    }

    fun pow(base: Vec2, exponent: Vec2, res: Vec2 = Vec2()) {
        res.x = pow(base.x, exponent.x)
        res.y = pow(base.y, exponent.y)
    }

    fun pow(base: Vec2d, exponent: Double, res: Vec2d = Vec2d()) {
        res.x = pow(base.x, exponent)
        res.y = pow(base.y, exponent)
    }

    fun pow(base: Vec2d, exponent: Vec2d, res: Vec2d = Vec2d()) {
        res.x = pow(base.x, exponent.x)
        res.y = pow(base.y, exponent.y)
    }

    fun pow(base: Vec3, exponent: Float, res: Vec3 = Vec3()) {
        res.x = pow(base.x, exponent)
        res.y = pow(base.y, exponent)
        res.z = pow(base.z, exponent)
    }

    fun pow(base: Vec3, exponent: Vec3, res: Vec3 = Vec3()) {
        res.x = pow(base.x, exponent.x)
        res.y = pow(base.y, exponent.y)
        res.z = pow(base.z, exponent.z)
    }

    fun pow(base: Vec3d, exponent: Double, res: Vec3d = Vec3d()) {
        res.x = pow(base.x, exponent)
        res.y = pow(base.y, exponent)
        res.z = pow(base.z, exponent)
    }

    fun pow(base: Vec3d, exponent: Vec3d, res: Vec3d = Vec3d()) {
        res.x = pow(base.x, exponent.x)
        res.y = pow(base.y, exponent.y)
        res.z = pow(base.z, exponent.z)
    }

    fun pow(base: Vec4, exponent: Float, res: Vec4 = Vec4()) {
        res.x = pow(base.x, exponent)
        res.y = pow(base.y, exponent)
        res.z = pow(base.z, exponent)
        res.w = pow(base.w, exponent)
    }

    fun pow(base: Vec4, exponent: Vec4, res: Vec4 = Vec4()) {
        res.x = pow(base.x, exponent.x)
        res.y = pow(base.y, exponent.y)
        res.z = pow(base.z, exponent.z)
        res.w = pow(base.w, exponent.w)
    }

    fun pow(base: Vec4d, exponent: Double, res: Vec4d = Vec4d()) {
        res.x = pow(base.x, exponent)
        res.y = pow(base.y, exponent)
        res.z = pow(base.z, exponent)
        res.w = pow(base.w, exponent)
    }

    fun pow(base: Vec4d, exponent: Vec4d, res: Vec4d = Vec4d()) {
        res.x = pow(base.x, exponent.x)
        res.y = pow(base.y, exponent.y)
        res.z = pow(base.z, exponent.z)
        res.w = pow(base.w, exponent.w)
    }

    fun exp(a: Double) = Math.exp(a)
    fun exp(a: Float) = Math.exp(a.d).f

    fun exp(a: Vec2, res: Vec2 = Vec2()) {
        res.x = exp(a.x)
        res.y = exp(a.y)
    }

    fun exp(a: Vec2d, res: Vec2d = Vec2d()) {
        res.x = exp(a.x)
        res.y = exp(a.y)
    }

    fun exp(a: Vec3, res: Vec3 = Vec3()) {
        res.x = exp(a.x)
        res.y = exp(a.y)
        res.z = exp(a.z)
    }
    
    fun exp(a: Vec3d, res: Vec3d = Vec3d()) {
        res.x = exp(a.x)
        res.y = exp(a.y)
        res.z = exp(a.z)
    }

    fun exp(a: Vec4, res: Vec4 = Vec4()) {
        res.x = exp(a.x)
        res.y = exp(a.y)
        res.z = exp(a.z)
        res.w = exp(a.w)
    }

    fun exp(a: Vec4d, res: Vec4d = Vec4d()) {
        res.x = exp(a.x)
        res.y = exp(a.y)
        res.w = exp(a.w)
    }
    
    
    fun log(a: Double) = Math.log(a)
    fun log(a: Float) = Math.log(a.d).f

    fun log(a: Vec2, res: Vec2 = Vec2()) {
        res.x = log(a.x)
        res.y = log(a.y)
    }

    fun log(a: Vec2d, res: Vec2d = Vec2d()) {
        res.x = log(a.x)
        res.y = log(a.y)
    }

    fun log(a: Vec3, res: Vec3 = Vec3()) {
        res.x = log(a.x)
        res.y = log(a.y)
        res.z = log(a.z)
    }

    fun log(a: Vec3d, res: Vec3d = Vec3d()) {
        res.x = log(a.x)
        res.y = log(a.y)
        res.z = log(a.z)
    }

    fun log(a: Vec4, res: Vec4 = Vec4()) {
        res.x = log(a.x)
        res.y = log(a.y)
        res.z = log(a.z)
        res.w = log(a.w)
    }

    fun log(a: Vec4d, res: Vec4d = Vec4d()) {
        res.x = log(a.x)
        res.y = log(a.y)
        res.w = log(a.w)
    }
    
    
    fun exp2(a: Double) = Math.pow(2.d, a)
    fun exp2(a: Float) = Math.pow(2.d, a.d).f

    fun exp2(a: Vec2, res: Vec2 = Vec2()) {
        res.x = exp2(a.x)
        res.y = exp2(a.y)
    }

    fun exp2(a: Vec2d, res: Vec2d = Vec2d()) {
        res.x = exp2(a.x)
        res.y = exp2(a.y)
    }

    fun exp2(a: Vec3, res: Vec3 = Vec3()) {
        res.x = exp2(a.x)
        res.y = exp2(a.y)
        res.z = exp2(a.z)
    }

    fun exp2(a: Vec3d, res: Vec3d = Vec3d()) {
        res.x = exp2(a.x)
        res.y = exp2(a.y)
        res.z = exp2(a.z)
    }

    fun exp2(a: Vec4, res: Vec4 = Vec4()) {
        res.x = exp2(a.x)
        res.y = exp2(a.y)
        res.z = exp2(a.z)
        res.w = exp2(a.w)
    }

    fun exp2(a: Vec4d, res: Vec4d = Vec4d()) {
        res.x = exp2(a.x)
        res.y = exp2(a.y)
        res.w = exp2(a.w)
    }

    
    fun log2(a: Double) = Math.log(a) / Math.log(2.d)
    fun log2(a: Float) = (Math.log(a.d) / Math.log(2.d)).f

    fun log2(a: Vec2, res: Vec2 = Vec2()) {
        res.x = log2(a.x)
        res.y = log2(a.y)
    }

    fun log2(a: Vec2d, res: Vec2d = Vec2d()) {
        res.x = log2(a.x)
        res.y = log2(a.y)
    }

    fun log2(a: Vec3, res: Vec3 = Vec3()) {
        res.x = log2(a.x)
        res.y = log2(a.y)
        res.z = log2(a.z)
    }

    fun log2(a: Vec3d, res: Vec3d = Vec3d()) {
        res.x = log2(a.x)
        res.y = log2(a.y)
        res.z = log2(a.z)
    }

    fun log2(a: Vec4, res: Vec4 = Vec4()) {
        res.x = log2(a.x)
        res.y = log2(a.y)
        res.z = log2(a.z)
        res.w = log2(a.w)
    }

    fun log2(a: Vec4d, res: Vec4d = Vec4d()) {
        res.x = log2(a.x)
        res.y = log2(a.y)
        res.w = log2(a.w)
    }
    
    
    fun sqrt(a: Double) = Math.sqrt(a)
    fun sqrt(a: Float) = Math.sqrt(a.d).f

    fun sqrt(a: Vec2, res: Vec2 = Vec2()) {
        res.x = sqrt(a.x)
        res.y = sqrt(a.y)
    }

    fun sqrt(a: Vec2d, res: Vec2d = Vec2d()) {
        res.x = sqrt(a.x)
        res.y = sqrt(a.y)
    }

    fun sqrt(a: Vec3, res: Vec3 = Vec3()) {
        res.x = sqrt(a.x)
        res.y = sqrt(a.y)
        res.z = sqrt(a.z)
    }

    fun sqrt(a: Vec3d, res: Vec3d = Vec3d()) {
        res.x = sqrt(a.x)
        res.y = sqrt(a.y)
        res.z = sqrt(a.z)
    }

    fun sqrt(a: Vec4, res: Vec4 = Vec4()) {
        res.x = sqrt(a.x)
        res.y = sqrt(a.y)
        res.z = sqrt(a.z)
        res.w = sqrt(a.w)
    }

    fun sqrt(a: Vec4d, res: Vec4d = Vec4d()) {
        res.x = sqrt(a.x)
        res.y = sqrt(a.y)
        res.w = sqrt(a.w)
    }
    
    
    fun inverseSqrt(a: Double) = 1.0 / Math.sqrt(a)
    fun inverseSqrt(a: Float) = (1.0 / Math.sqrt(a.d)).f

    fun inverseSqrt(a: Vec2, res: Vec2 = Vec2()) {
        res.x = inverseSqrt(a.x)
        res.y = inverseSqrt(a.y)
    }

    fun inverseSqrt(a: Vec2d, res: Vec2d = Vec2d()) {
        res.x = inverseSqrt(a.x)
        res.y = inverseSqrt(a.y)
    }

    fun inverseSqrt(a: Vec3, res: Vec3 = Vec3()) {
        res.x = inverseSqrt(a.x)
        res.y = inverseSqrt(a.y)
        res.z = inverseSqrt(a.z)
    }

    fun inverseSqrt(a: Vec3d, res: Vec3d = Vec3d()) {
        res.x = inverseSqrt(a.x)
        res.y = inverseSqrt(a.y)
        res.z = inverseSqrt(a.z)
    }

    fun inverseSqrt(a: Vec4, res: Vec4 = Vec4()) {
        res.x = inverseSqrt(a.x)
        res.y = inverseSqrt(a.y)
        res.z = inverseSqrt(a.z)
        res.w = inverseSqrt(a.w)
    }

    fun inverseSqrt(a: Vec4d, res: Vec4d = Vec4d()) {
        res.x = inverseSqrt(a.x)
        res.y = inverseSqrt(a.y)
        res.w = inverseSqrt(a.w)
    }
}