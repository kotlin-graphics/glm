package glm_.detail

import glm_.glm.floor
import glm_.vec2.Vec2
import glm_.vec2.Vec2d
import glm_.vec2.Vec2t
import glm_.vec1.operators.times
import glm_.vec3.Vec3
import glm_.vec3.Vec3d
import glm_.vec3.Vec3t
import glm_.vec3.operators.minus
import glm_.vec3.operators.times
import glm_.vec4.Vec4
import glm_.vec4.Vec4d
import glm_.vec4.Vec4t
import glm_.vec4.operators.minus
import glm_.vec4.operators.times

/**
 * Created by GBarbieri on 13.12.2016.
 */


interface noise {

    fun mod289(a: Number): Number = when (a) {
        is Float -> a - floor(a * 1f / 289f) * 289f
        is Double -> a - floor(a * 1.0 / 289.0) * 289.0
        else -> throw ArithmeticException("mod289 only accepts floating-point inputs")
    }

    fun mod289(a: Vec2t<out Number>): Vec2t<out Number> = when (a) {
        is Vec2 -> a - floor(a * 1f / 289f) * 289f
        is Vec2d -> a - floor(a * 1.0 / 289.0) * 289.0
        else -> throw ArithmeticException("mod289 only accepts floating-point inputs")
    }

    fun mod289(a: Vec3t<out Number>): Vec3t<out Number> = when (a) {
        is Vec3 -> a - floor(a * 1f / 289f) * 289f
        is Vec3d -> a - floor(a * 1.0 / 289.0) * 289.0
        else -> throw ArithmeticException("mod289 only accepts floating-point inputs")
    }

    fun mod289(a: Vec4t<out Number>): Vec4t<out Number> = when (a) {
        is Vec4 -> a - floor(a * 1f / 289f) * 289f
        is Vec4d -> a - floor(a * 1.0 / 289.0) * 289.0
        else -> throw ArithmeticException("mod289 only accepts floating-point inputs")
    }


    fun permute(a: Number): Number = when (a) {
        is Float -> mod289(((a * 34f) + 1f) * a)
        is Double -> mod289(((a * 34.0) + 1.0) * a)
        else -> throw ArithmeticException("permute only accepts floating-point inputs")
    }

    fun permute(a: Vec2t<out Number>): Vec2t<out Number> = when (a) {
        is Vec2 -> mod289(((a * 34f) + 1f) * a)
        is Vec2d -> mod289(((a * 34.0) + 1.0) * a)
        else -> throw ArithmeticException("permute only accepts floating-point inputs")
    }

    fun permute(a: Vec3t<out Number>): Vec3t<out Number> = when (a) {
        is Vec3 -> mod289(((a * 34f) + 1f) * a)
        is Vec3d -> mod289(((a * 34.0) + 1.0) * a)
        else -> throw ArithmeticException("permute only accepts floating-point inputs")
    }

    fun permute(a: Vec4t<out Number>): Vec4t<out Number> = when (a) {
        is Vec4 -> mod289(((a * 34f) + 1f) * a)
        is Vec4d -> mod289(((a * 34.0) + 1.0) * a)
        else -> throw ArithmeticException("permute only accepts floating-point inputs")
    }


    fun taylorInvSqrt(a: Number): Number = when (a) {
        is Float -> 1.79284291400159f - 0.85373472095314f * a
        is Double -> 1.79284291400159 - 0.85373472095314 * a
        else -> throw ArithmeticException("permute only accepts floating-point inputs")
    }

    fun taylorInvSqrt(a: Vec2t<out Number>): Vec2t<out Number> = when (a) {
        is Vec2 -> 1.79284291400159f - 0.85373472095314f * a
        is Vec2d -> 1.79284291400159 - 0.85373472095314 * a
        else -> throw ArithmeticException("permute only accepts floating-point inputs")
    }

    fun taylorInvSqrt(a: Vec3t<out Number>): Vec3t<out Number> = when (a) {
        is Vec3 -> 1.79284291400159f - 0.85373472095314f * a
        is Vec3d -> 1.79284291400159 - 0.85373472095314 * a
        else -> throw ArithmeticException("permute only accepts floating-point inputs")
    }

    fun taylorInvSqrt(a: Vec4t<out Number>): Vec4t<out Number> = when (a) {
        is Vec4 -> 1.79284291400159f - 0.85373472095314f * a
        is Vec4d -> 1.79284291400159 - 0.85373472095314 * a
        else -> throw ArithmeticException("permute only accepts floating-point inputs")
    }


    fun fade(a: Vec2t<out Number>): Vec2t<out Number> = when (a) {
        is Vec2 -> (a * a * a) * (a * (a * 6f - 15f) + 10f)
        is Vec2d -> (a * a * a) * (a * (a * 6.0 - 15.0) + 10.0)
        else -> throw ArithmeticException("permute only accepts floating-point inputs")
    }

    fun fade(a: Vec3t<out Number>): Vec3t<out Number> = when (a) {
        is Vec3 -> (a * a * a) * (a * (a * 6f - 15f) + 10f)
        is Vec3d -> (a * a * a) * (a * (a * 6.0 - 15.0) + 10.0)
        else -> throw ArithmeticException("permute only accepts floating-point inputs")
    }

    fun fade(a: Vec4t<out Number>): Vec4t<out Number> = when (a) {
        is Vec4 -> (a * a * a) * (a * (a * 6f - 15f) + 10f)
        is Vec4d -> (a * a * a) * (a * (a * 6.0 - 15.0) + 10.0)
        else -> throw ArithmeticException("permute only accepts floating-point inputs")
    }
}