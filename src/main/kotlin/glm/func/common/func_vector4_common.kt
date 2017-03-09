package glm.func.common

import glm.vec._4.*
import glm.vec.bool.Vec4bool
import glm.Glm.abs
import glm.Glm.sign
import glm.Glm.floor
import glm.Glm.trunc
import glm.Glm.round
import glm.Glm.ceil
import glm.Glm.fract
import glm.Glm.mod
import glm.Glm.min
import glm.Glm.max
import glm.Glm.mix
import glm.Glm.clamp
import glm.Glm.step
import glm.Glm.smoothStep
import glm.Glm.isInf
import glm.Glm.isNan
import glm.Glm.floatBitsToInt
import glm.Glm.floatBitsToUint
import glm.Glm.intBitsToFloat
import glm.Glm.uintBitsToFloat
import glm.Glm.fma

/**
 * Created by GBarbieri on 11.11.2016.
 */
interface func_vector4_common {


    fun abs(a: Vec4, res: Vec4 = Vec4()): Vec4 {
        res.x = abs(a.x)
        res.y = abs(a.y)
        res.z = abs(a.z)
        res.w = abs(a.w)
        return res
    }

    fun abs(a: Vec4b, res: Vec4b = Vec4b()): Vec4b {
        res.x = abs(a.x)
        res.y = abs(a.y)
        res.z = abs(a.z)
        res.w = abs(a.w)
        return res
    }

    fun abs(a: Vec4d, res: Vec4d = Vec4d()): Vec4d {
        res.x = abs(a.x)
        res.y = abs(a.y)
        res.z = abs(a.z)
        res.w = abs(a.w)
        return res
    }

    fun abs(a: Vec4i, res: Vec4i = Vec4i()): Vec4i {
        res.x = abs(a.x)
        res.y = abs(a.y)
        res.z = abs(a.z)
        res.w = abs(a.w)
        return res
    }

    fun abs(a: Vec4l, res: Vec4l = Vec4l()): Vec4l {
        res.x = abs(a.x)
        res.y = abs(a.y)
        res.z = abs(a.z)
        res.w = abs(a.w)
        return res
    }

    fun abs(a: Vec4s, res: Vec4s = Vec4s()): Vec4s {
        res.x = abs(a.x)
        res.y = abs(a.y)
        res.z = abs(a.z)
        res.w = abs(a.w)
        return res
    }


    fun sign(a: Vec4, res: Vec4 = Vec4()): Vec4 {
        res.x = sign(a.x)
        res.y = sign(a.y)
        res.z = sign(a.z)
        res.w = sign(a.w)
        return res
    }

    fun sign(a: Vec4b, res: Vec4b = Vec4b()): Vec4b {
        res.x = sign(a.x)
        res.y = sign(a.y)
        res.z = sign(a.z)
        res.w = sign(a.w)
        return res
    }

    fun sign(a: Vec4d, res: Vec4d = Vec4d()): Vec4d {
        res.x = sign(a.x)
        res.y = sign(a.y)
        res.z = sign(a.z)
        res.w = sign(a.w)
        return res
    }

    fun sign(a: Vec4i, res: Vec4i = Vec4i()): Vec4i {
        res.x = sign(a.x)
        res.y = sign(a.y)
        res.z = sign(a.z)
        res.w = sign(a.w)
        return res
    }

    fun sign(a: Vec4l, res: Vec4l = Vec4l()): Vec4l {
        res.x = sign(a.x)
        res.y = sign(a.y)
        res.z = sign(a.z)
        res.w = sign(a.w)
        return res
    }

    fun sign(a: Vec4s, res: Vec4s = Vec4s()): Vec4s {
        res.x = sign(a.x)
        res.y = sign(a.y)
        res.z = sign(a.z)
        res.w = sign(a.w)
        return res
    }


    fun floor(a: Vec4, res: Vec4 = Vec4()): Vec4 {
        res.x = floor(a.x)
        res.y = floor(a.y)
        res.z = floor(a.z)
        res.w = floor(a.w)
        return res
    }

    fun floor(a: Vec4d, res: Vec4d = Vec4d()): Vec4d {
        res.x = floor(a.x)
        res.y = floor(a.y)
        res.z = floor(a.z)
        res.w = floor(a.w)
        return res
    }


    fun trunc(a: Vec4, res: Vec4 = Vec4()): Vec4 {
        res.x = trunc(a.x)
        res.y = trunc(a.y)
        res.z = trunc(a.z)
        res.w = trunc(a.w)
        return res
    }

    fun trunc(a: Vec4d, res: Vec4d = Vec4d()): Vec4d {
        res.x = trunc(a.x)
        res.y = trunc(a.y)
        res.z = trunc(a.z)
        res.w = trunc(a.w)
        return res
    }


    fun round(a: Vec4, res: Vec4 = Vec4()): Vec4 {
        res.x = round(a.x)
        res.y = round(a.y)
        res.z = round(a.z)
        res.w = round(a.w)
        return res
    }

    fun round(a: Vec4d, res: Vec4d = Vec4d()): Vec4d {
        res.x = round(a.x)
        res.y = round(a.y)
        res.z = round(a.z)
        res.w = round(a.w)
        return res
    }


    // TODO roundEven


    fun ceil(a: Vec4, res: Vec4 = Vec4()): Vec4 {
        res.x = ceil(a.x)
        res.y = ceil(a.y)
        res.z = ceil(a.z)
        res.w = ceil(a.w)
        return res
    }

    fun ceil(a: Vec4d, res: Vec4d = Vec4d()): Vec4d {
        res.x = ceil(a.x)
        res.y = ceil(a.y)
        res.z = ceil(a.z)
        res.w = ceil(a.w)
        return res
    }


    fun fract(a: Vec4, res: Vec4 = Vec4()): Vec4 {
        res.x = fract(a.x)
        res.y = fract(a.y)
        res.z = fract(a.z)
        res.w = fract(a.w)
        return res
    }

    fun fract(a: Vec4d, res: Vec4d = Vec4d()): Vec4d {
        res.x = fract(a.x)
        res.y = fract(a.y)
        res.z = fract(a.z)
        res.w = fract(a.w)
        return res
    }


    fun mod(a: Vec4, b: Float, res: Vec4 = Vec4()): Vec4 {
        res.x = mod(a.x, b)
        res.y = mod(a.y, b)
        res.z = mod(a.z, b)
        res.w = mod(a.w, b)
        return res
    }

    fun mod(a: Vec4d, b: Double, res: Vec4d = Vec4d()): Vec4d {
        res.x = mod(a.x, b)
        res.y = mod(a.y, b)
        res.z = mod(a.z, b)
        res.w = mod(a.w, b)
        return res
    }

    fun mod(a: Vec4, b: Vec4, res: Vec4 = Vec4()): Vec4 {
        res.x = mod(a.x, b.x)
        res.y = mod(a.y, b.y)
        res.z = mod(a.z, b.z)
        res.w = mod(a.w, b.w)
        return res
    }

    fun mod(a: Vec4d, b: Vec4d, res: Vec4d = Vec4d()): Vec4d {
        res.x = mod(a.x, b.x)
        res.y = mod(a.y, b.y)
        res.z = mod(a.z, b.z)
        res.w = mod(a.w, b.w)
        return res
    }


    // TODO modf


    fun min(a: Vec4, b: Float, res: Vec4 = Vec4()): Vec4 {
        res.x = min(a.x, b)
        res.y = min(a.y, b)
        res.z = min(a.z, b)
        res.w = min(a.w, b)
        return res
    }

    fun min(a: Vec4d, b: Double, res: Vec4d = Vec4d()): Vec4d {
        res.x = min(a.x, b)
        res.y = min(a.y, b)
        res.z = min(a.z, b)
        res.w = min(a.w, b)
        return res
    }

    fun min(a: Vec4, b: Vec4, res: Vec4 = Vec4()): Vec4 {
        res.x = min(a.x, b.x)
        res.y = min(a.y, b.y)
        res.z = min(a.z, b.z)
        res.w = min(a.w, b.w)
        return res
    }

    fun min(a: Vec4d, b: Vec4d, res: Vec4d = Vec4d()): Vec4d {
        res.x = min(a.x, b.x)
        res.y = min(a.y, b.y)
        res.z = min(a.z, b.z)
        res.w = min(a.w, b.w)
        return res
    }

    fun max(a: Vec4, b: Float, res: Vec4 = Vec4()): Vec4 {
        res.x = max(a.x, b)
        res.y = max(a.y, b)
        res.z = max(a.z, b)
        res.w = max(a.w, b)
        return res
    }

    fun max(a: Vec4d, b: Double, res: Vec4d = Vec4d()): Vec4d {
        res.x = max(a.x, b)
        res.y = max(a.y, b)
        res.z = max(a.z, b)
        res.w = max(a.w, b)
        return res
    }

    fun max(a: Vec4, b: Vec4, res: Vec4 = Vec4()): Vec4 {
        res.x = max(a.x, b.x)
        res.y = max(a.y, b.y)
        res.z = max(a.z, b.z)
        res.w = max(a.w, b.w)
        return res
    }

    fun max(a: Vec4d, b: Vec4d, res: Vec4d = Vec4d()): Vec4d {
        res.x = max(a.x, b.x)
        res.y = max(a.y, b.y)
        res.z = max(a.z, b.z)
        res.w = max(a.w, b.w)
        return res
    }


    fun clamp(a: Vec4, min: Float, max: Float, res: Vec4 = Vec4()): Vec4 {
        res.x = clamp(a.x, min, max)
        res.y = clamp(a.y, min, max)
        res.z = clamp(a.z, min, max)
        res.w = clamp(a.w, min, max)
        return res
    }

    fun clamp(a: Vec4d, min: Double, max: Double, res: Vec4d = Vec4d()): Vec4d {
        res.x = clamp(a.x, min, max)
        res.y = clamp(a.y, min, max)
        res.z = clamp(a.z, min, max)
        res.w = clamp(a.w, min, max)
        return res
    }

    fun clamp(a: Vec4, min: Vec4, max: Vec4, res: Vec4 = Vec4()): Vec4 {
        res.x = clamp(a.x, min.x, max.x)
        res.y = clamp(a.y, min.y, max.y)
        res.z = clamp(a.z, min.z, max.z)
        res.w = clamp(a.w, min.w, max.w)
        return res
    }

    fun clamp(a: Vec4d, min: Vec4d, max: Vec4d, res: Vec4d = Vec4d()): Vec4d {
        res.x = clamp(a.x, min.x, max.x)
        res.y = clamp(a.y, min.y, max.y)
        res.z = clamp(a.z, min.z, max.z)
        res.w = clamp(a.w, min.w, max.w)
        return res
    }


    fun mix(a: Vec4, b: Float, interp: Float, res: Vec4 = Vec4()): Vec4 {
        res.x = mix(a.x, b, interp)
        res.y = mix(a.y, b, interp)
        res.z = mix(a.z, b, interp)
        res.w = mix(a.w, b, interp)
        return res
    }

    fun mix(a: Vec4d, b: Double, interp: Double, res: Vec4d = Vec4d()): Vec4d {
        res.x = mix(a.x, b, interp)
        res.y = mix(a.y, b, interp)
        res.z = mix(a.z, b, interp)
        res.w = mix(a.w, b, interp)
        return res
    }

    fun mix(a: Vec4, b: Vec4, interp: Boolean, res: Vec4 = Vec4()): Vec4 {
        res.x = mix(a.x, b.x, interp)
        res.y = mix(a.y, b.y, interp)
        res.z = mix(a.z, b.z, interp)
        res.w = mix(a.w, b.w, interp)
        return res
    }

    fun mix(a: Vec4d, b: Vec4d, interp: Boolean, res: Vec4d = Vec4d()): Vec4d {
        res.x = mix(a.x, b.x, interp)
        res.y = mix(a.y, b.y, interp)
        res.z = mix(a.z, b.z, interp)
        res.w = mix(a.w, b.w, interp)
        return res
    }

    fun mix(a: Vec4, b: Vec4, interp: Vec4, res: Vec4 = Vec4()): Vec4 {
        res.x = mix(a.x, b.x, interp.x)
        res.y = mix(a.y, b.y, interp.y)
        res.z = mix(a.z, b.z, interp.z)
        res.w = mix(a.w, b.w, interp.w)
        return res
    }

    fun mix(a: Vec4d, b: Vec4d, interp: Vec4d, res: Vec4d = Vec4d()): Vec4d {
        res.x = mix(a.x, b.x, interp.x)
        res.y = mix(a.y, b.y, interp.y)
        res.z = mix(a.z, b.z, interp.z)
        res.w = mix(a.w, b.w, interp.w)
        return res
    }

    fun mix(a: Vec4, b: Vec4, interp: Vec4bool, res: Vec4 = Vec4()): Vec4 {
        res.x = mix(a.x, b.x, interp.x)
        res.y = mix(a.y, b.y, interp.y)
        res.z = mix(a.z, b.z, interp.z)
        res.w = mix(a.w, b.w, interp.w)
        return res
    }

    fun mix(a: Vec4d, b: Vec4d, interp: Vec4bool, res: Vec4d = Vec4d()): Vec4d {
        res.x = mix(a.x, b.x, interp.x)
        res.y = mix(a.y, b.y, interp.y)
        res.z = mix(a.z, b.z, interp.z)
        res.w = mix(a.w, b.w, interp.w)
        return res
    }


    fun step(edge: Float, a: Vec4, res: Vec4 = Vec4()): Vec4 {
        res.x = step(edge, a.x)
        res.y = step(edge, a.y)
        res.z = step(edge, a.z)
        res.w = step(edge, a.w)
        return res
    }

    fun step(edge: Double, a: Vec4d, res: Vec4d = Vec4d()): Vec4d {
        res.x = step(edge, a.x)
        res.y = step(edge, a.y)
        res.z = step(edge, a.z)
        res.w = step(edge, a.w)
        return res
    }

    fun step(edge: Vec4, a: Vec4, res: Vec4 = Vec4()): Vec4 {
        res.x = step(edge.x, a.x)
        res.y = step(edge.y, a.y)
        res.z = step(edge.z, a.z)
        res.w = step(edge.w, a.w)
        return res
    }

    fun step(edge: Vec4d, a: Vec4d, res: Vec4d = Vec4d()): Vec4d {
        res.x = step(edge.x, a.x)
        res.y = step(edge.y, a.y)
        res.z = step(edge.z, a.z)
        res.w = step(edge.w, a.w)
        return res
    }


    fun smoothStep(edge0: Float, edge1: Float, a: Vec4, res: Vec4 = Vec4()): Vec4 {
        res.x = smoothStep(edge0, edge1, a.x)
        res.y = smoothStep(edge0, edge1, a.y)
        res.z = smoothStep(edge0, edge1, a.z)
        res.w = smoothStep(edge0, edge1, a.w)
        return res
    }

    fun smoothStep(edge0: Double, edge1: Double, a: Vec4d, res: Vec4d = Vec4d()): Vec4d {
        res.x = smoothStep(edge0, edge1, a.x)
        res.y = smoothStep(edge0, edge1, a.y)
        res.z = smoothStep(edge0, edge1, a.z)
        res.w = smoothStep(edge0, edge1, a.w)
        return res
    }

    fun smoothStep(edge0: Vec4, edge1: Vec4, a: Vec4, res: Vec4 = Vec4()): Vec4 {
        res.x = smoothStep(edge0.x, edge1.x, a.x)
        res.y = smoothStep(edge0.y, edge1.y, a.y)
        res.z = smoothStep(edge0.z, edge1.z, a.z)
        res.w = smoothStep(edge0.w, edge1.w, a.w)
        return res
    }

    fun smoothStep(edge0: Vec4d, edge1: Vec4d, a: Vec4d, res: Vec4d = Vec4d()): Vec4d {
        res.x = smoothStep(edge0.x, edge1.x, a.x)
        res.y = smoothStep(edge0.y, edge1.y, a.y)
        res.z = smoothStep(edge0.z, edge1.z, a.z)
        res.w = smoothStep(edge0.w, edge1.w, a.w)
        return res
    }


    fun isNan(a: Vec4, res: Vec4bool = Vec4bool()): Vec4bool {
        res.x = isNan(a.x)
        res.y = isNan(a.y)
        res.z = isNan(a.z)
        res.w = isNan(a.w)
        return res
    }

    fun isNan(a: Vec4d, res: Vec4bool = Vec4bool()): Vec4bool {
        res.x = isNan(a.x)
        res.y = isNan(a.y)
        res.z = isNan(a.z)
        res.w = isNan(a.w)
        return res
    }


    fun isInf(a: Vec4, res: Vec4bool = Vec4bool()): Vec4bool {
        res.x = isInf(a.x)
        res.y = isInf(a.y)
        res.z = isInf(a.z)
        res.w = isInf(a.w)
        return res
    }

    fun isInf(a: Vec4d, res: Vec4bool = Vec4bool()): Vec4bool {
        res.x = isInf(a.x)
        res.y = isInf(a.y)
        res.z = isInf(a.z)
        res.w = isInf(a.w)
        return res
    }


    fun floatBitsToInt(a: Vec4, res: Vec4i = Vec4i()): Vec4i {
        res.x = floatBitsToInt(a.x)
        res.y = floatBitsToInt(a.y)
        res.z = floatBitsToInt(a.z)
        res.w = floatBitsToInt(a.w)
        return res
    }


    fun floatBitsToUint(a: Vec4, res: Vec4ui = Vec4ui()): Vec4ui {
        res.x = floatBitsToUint(a.x)    // TODO directly .v?
        res.y = floatBitsToUint(a.y)
        res.z = floatBitsToUint(a.z)
        res.w = floatBitsToUint(a.w)
        return res
    }


    fun intBitsToFloat(a: Vec4i, res: Vec4 = Vec4()): Vec4 {
        res.x = intBitsToFloat(a.x)
        res.y = intBitsToFloat(a.y)
        res.z = intBitsToFloat(a.z)
        res.w = intBitsToFloat(a.w)
        return res
    }


    fun uintBitsToFloat(a: Vec4ui, res: Vec4 = Vec4()): Vec4 {
        res.x = uintBitsToFloat(a.x)
        res.y = uintBitsToFloat(a.y)
        res.z = uintBitsToFloat(a.z)
        res.w = uintBitsToFloat(a.w)
        return res
    }


    fun fma(a: Vec4, b: Vec4, c: Vec4, res: Vec4 = Vec4()): Vec4 {
        res.x = fma(a.x, b.x, c.x)
        res.y = fma(a.y, b.y, c.y)
        res.z = fma(a.z, b.z, c.z)
        res.w = fma(a.w, b.w, c.w)
        return res
    }

    fun fma(a: Vec4d, b: Vec4d, c: Vec4d, res: Vec4d = Vec4d()): Vec4d {
        res.x = fma(a.x, b.x, c.x)
        res.y = fma(a.y, b.y, c.y)
        res.z = fma(a.z, b.z, c.z)
        res.w = fma(a.w, b.w, c.w)
        return res
    }


    // TODO frexp, ldexp
}