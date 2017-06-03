package glm_

/**
 * Created by GBarbieri on 08.02.2017.
 */

import glm_.glm.floor
import glm_.vec2.Vec2
import glm_.vec2.Vec2d
import glm_.vec2.operators.minus
import glm_.vec3.operators.minus
import glm_.vec4.operators.minus
import glm_.vec2.operators.times
import glm_.vec3.operators.times
import glm_.vec4.operators.times
import glm_.vec3.Vec3
import glm_.vec3.Vec3d
import glm_.vec4.Vec4
import glm_.vec4.Vec4d

interface noise {

    fun mod289(a: Float) = a - floor(a * (1f / 289f)) * 289f
    fun mod289(a: Vec2) = a - floor(a * (1f / 289f)) * 289f
    fun mod289(a: Vec3) = a - floor(a * (1f / 289f)) * 289f
    fun mod289(a: Vec4) = a - floor(a * (1f / 289f)) * 289f

    fun mod289(a: Double) = a - floor(a * (1.0 / 289.0)) * 289.0
    fun mod289(a: Vec2d) = a - floor(a * (1.0 / 289.0)) * 289.0
    fun mod289(a: Vec3d) = a - floor(a * (1.0 / 289.0)) * 289.0
    fun mod289(a: Vec4d) = a - floor(a * (1.0 / 289.0)) * 289.0


    fun permute(a: Float) = mod289((a * 34f + 1f) * a)
    fun permute(a: Vec2) = mod289((a * 34f + 1f) * a)
    fun permute(a: Vec3) = mod289((a * 34f + 1f) * a)
    fun permute(a: Vec4) = mod289((a * 34f + 1f) * a)

    fun permute(a: Double) = mod289((a * 34.0 + 1.0) * a)
    fun permute(a: Vec2d) = mod289((a * 34.0 + 1.0) * a)
    fun permute(a: Vec3d) = mod289((a * 34.0 + 1.0) * a)
    fun permute(a: Vec4d) = mod289((a * 34.0 + 1.0) * a)


    fun taylorInvSqrt(a: Float) = 1.79284291400159f - 0.85373472095314f * a
    fun taylorInvSqrt(a: Vec2) = 1.79284291400159f - 0.85373472095314f * a
    fun taylorInvSqrt(a: Vec3) = 1.79284291400159f - 0.85373472095314f * a
    fun taylorInvSqrt(a: Vec4) = 1.79284291400159f - 0.85373472095314f * a

    fun taylorInvSqrt(a: Double) = 1.79284291400159 - 0.85373472095314 * a
    fun taylorInvSqrt(a: Vec2d) = 1.79284291400159 - 0.85373472095314 * a
    fun taylorInvSqrt(a: Vec3d) = 1.79284291400159 - 0.85373472095314 * a
    fun taylorInvSqrt(a: Vec4d) = 1.79284291400159 - 0.85373472095314 * a

    fun fade(a: Vec2) = (a * a * a) * (a * (a * 6f - 15f) + 10f)
    fun fade(a: Vec3) = (a * a * a) * (a * (a * 6f - 15f) + 10f)
    fun fade(a: Vec4) = (a * a * a) * (a * (a * 6f - 15f) + 10f)

    fun fade(a: Vec2d) = (a * a * a) * (a * (a * 6.0 - 15.0) + 10.0)
    fun fade(a: Vec3d) = (a * a * a) * (a * (a * 6.0 - 15.0) + 10.0)
    fun fade(a: Vec4d) = (a * a * a) * (a * (a * 6.0 - 15.0) + 10.0)
}