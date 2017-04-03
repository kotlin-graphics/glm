package glm.func.common

import glm.vec._3.*
import glm.vec.bool.Vec3bool
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
interface func_vector3_common {


    fun abs(a: Vec3) = abs(a, Vec3())
    fun abs(a: Vec3, res: Vec3): Vec3 {
        res.x = abs(a.x)
        res.y = abs(a.y)
        res.z = abs(a.z)
        return res
    }

    fun abs(a: Vec3b) = abs(a, Vec3b())
    fun abs(a: Vec3b, res: Vec3b): Vec3b {
        res.x = abs(a.x)
        res.y = abs(a.y)
        res.z = abs(a.z)
        return res
    }

    fun abs(a: Vec3d) = abs(a, Vec3d())
    fun abs(a: Vec3d, res: Vec3d): Vec3d {
        res.x = abs(a.x)
        res.y = abs(a.y)
        res.z = abs(a.z)
        return res
    }

    fun abs(a: Vec3i) = abs(a, Vec3i())
    fun abs(a: Vec3i, res: Vec3i): Vec3i {
        res.x = abs(a.x)
        res.y = abs(a.y)
        res.z = abs(a.z)
        return res
    }

    fun abs(a: Vec3l) = abs(a, Vec3l())
    fun abs(a: Vec3l, res: Vec3l): Vec3l {
        res.x = abs(a.x)
        res.y = abs(a.y)
        res.z = abs(a.z)
        return res
    }

    fun abs(a: Vec3s) = abs(a, Vec3s())
    fun abs(a: Vec3s, res: Vec3s): Vec3s {
        res.x = abs(a.x)
        res.y = abs(a.y)
        res.z = abs(a.z)
        return res
    }


    fun sign(a: Vec3) = sign(a, Vec3())
    fun sign(a: Vec3, res: Vec3): Vec3 {
        res.x = sign(a.x)
        res.y = sign(a.y)
        res.z = sign(a.z)
        return res
    }

    fun sign(a: Vec3b) = sign(a, Vec3b())
    fun sign(a: Vec3b, res: Vec3b): Vec3b {
        res.x = sign(a.x)
        res.y = sign(a.y)
        res.z = sign(a.z)
        return res
    }

    fun sign(a: Vec3d) = sign(a, Vec3d())
    fun sign(a: Vec3d, res: Vec3d): Vec3d {
        res.x = sign(a.x)
        res.y = sign(a.y)
        res.z = sign(a.z)
        return res
    }

    fun sign(a: Vec3i) = sign(a, Vec3i())
    fun sign(a: Vec3i, res: Vec3i): Vec3i {
        res.x = sign(a.x)
        res.y = sign(a.y)
        res.z = sign(a.z)
        return res
    }

    fun sign(a: Vec3l) = sign(a, Vec3l())
    fun sign(a: Vec3l, res: Vec3l): Vec3l {
        res.x = sign(a.x)
        res.y = sign(a.y)
        res.z = sign(a.z)
        return res
    }

    fun sign(a: Vec3s) = sign(a, Vec3s())
    fun sign(a: Vec3s, res: Vec3s): Vec3s {
        res.x = sign(a.x)
        res.y = sign(a.y)
        res.z = sign(a.z)
        return res
    }


    fun floor(a: Vec3) = floor(a, Vec3())
    fun floor(a: Vec3, res: Vec3): Vec3 {
        res.x = floor(a.x)
        res.y = floor(a.y)
        res.z = floor(a.z)
        return res
    }

    fun floor(a: Vec3d) = floor(a, Vec3d())
    fun floor(a: Vec3d, res: Vec3d): Vec3d {
        res.x = floor(a.x)
        res.y = floor(a.y)
        res.z = floor(a.z)
        return res
    }


    fun trunc(a: Vec3) = trunc(a, Vec3())
    fun trunc(a: Vec3, res: Vec3): Vec3 {
        res.x = trunc(a.x)
        res.y = trunc(a.y)
        res.z = trunc(a.z)
        return res
    }

    fun trunc(a: Vec3d) = trunc(a, Vec3d())
    fun trunc(a: Vec3d, res: Vec3d): Vec3d {
        res.x = trunc(a.x)
        res.y = trunc(a.y)
        res.z = trunc(a.z)
        return res
    }


    fun round(a: Vec3) = round(a, Vec3())
    fun round(a: Vec3, res: Vec3): Vec3 {
        res.x = round(a.x)
        res.y = round(a.y)
        res.z = round(a.z)
        return res
    }

    fun round(a: Vec3d) = round(a, Vec3d())
    fun round(a: Vec3d, res: Vec3d): Vec3d {
        res.x = round(a.x)
        res.y = round(a.y)
        res.z = round(a.z)
        return res
    }


    // TODO roundEven


    fun ceil(a: Vec3) = ceil(a, Vec3())
    fun ceil(a: Vec3, res: Vec3): Vec3 {
        res.x = ceil(a.x)
        res.y = ceil(a.y)
        res.z = ceil(a.z)
        return res
    }

    fun ceil(a: Vec3d) = ceil(a, Vec3d())
    fun ceil(a: Vec3d, res: Vec3d): Vec3d {
        res.x = ceil(a.x)
        res.y = ceil(a.y)
        res.z = ceil(a.z)
        return res
    }


    fun fract(a: Vec3) = fract(a, Vec3())
    fun fract(a: Vec3, res: Vec3): Vec3 {
        res.x = fract(a.x)
        res.y = fract(a.y)
        res.z = fract(a.z)
        return res
    }

    fun fract(a: Vec3d) = fract(a, Vec3d())
    fun fract(a: Vec3d, res: Vec3d): Vec3d {
        res.x = fract(a.x)
        res.y = fract(a.y)
        res.z = fract(a.z)
        return res
    }


    fun mod(a: Vec3, b: Float) = mod(a, b, Vec3())
    fun mod(a: Vec3, b: Float, res: Vec3): Vec3 {
        res.x = mod(a.x, b)
        res.y = mod(a.y, b)
        res.z = mod(a.z, b)
        return res
    }

    fun mod(a: Vec3d, b: Double) = mod(a, b, Vec3d())
    fun mod(a: Vec3d, b: Double, res: Vec3d): Vec3d {
        res.x = mod(a.x, b)
        res.y = mod(a.y, b)
        res.z = mod(a.z, b)
        return res
    }

    fun mod(a: Vec3, b: Vec3) = mod(a, b, Vec3())
    fun mod(a: Vec3, b: Vec3, res: Vec3): Vec3 {
        res.x = mod(a.x, b.x)
        res.y = mod(a.y, b.y)
        res.z = mod(a.z, b.z)
        return res
    }

    fun mod(a: Vec3d, b: Vec3d) = mod(a, b, Vec3d())
    fun mod(a: Vec3d, b: Vec3d, res: Vec3d): Vec3d {
        res.x = mod(a.x, b.x)
        res.y = mod(a.y, b.y)
        res.z = mod(a.z, b.z)
        return res
    }


    // TODO modf


    fun min(a: Vec3, b: Float) = min(a, b, Vec3())
    fun min(a: Vec3, b: Float, res: Vec3): Vec3 {
        res.x = min(a.x, b)
        res.y = min(a.y, b)
        res.z = min(a.z, b)
        return res
    }

    fun min(a: Vec3d, b: Double) = min(a, b, Vec3d())
    fun min(a: Vec3d, b: Double, res: Vec3d): Vec3d {
        res.x = min(a.x, b)
        res.y = min(a.y, b)
        res.z = min(a.z, b)
        return res
    }

    fun min(a: Vec3, b: Vec3) = min(a, b, Vec3())
    fun min(a: Vec3, b: Vec3, res: Vec3): Vec3 {
        res.x = min(a.x, b.x)
        res.y = min(a.y, b.y)
        res.z = min(a.z, b.z)
        return res
    }

    fun min(a: Vec3d, b: Vec3d) = min(a, b, Vec3d())
    fun min(a: Vec3d, b: Vec3d, res: Vec3d): Vec3d {
        res.x = min(a.x, b.x)
        res.y = min(a.y, b.y)
        res.z = min(a.z, b.z)
        return res
    }


    fun max(a: Vec3, b: Float) = max(a, b, Vec3())
    fun max(a: Vec3, b: Float, res: Vec3): Vec3 {
        res.x = max(a.x, b)
        res.y = max(a.y, b)
        res.z = max(a.z, b)
        return res
    }

    // TODO others int
    fun max(a: Vec3i, b: Int) = max(a, b, Vec3i())
    fun max(a: Vec3i, b: Int, res: Vec3i): Vec3i {
        res.x = max(a.x, b)
        res.y = max(a.y, b)
        res.z = max(a.z, b)
        return res
    }

    fun max(a: Vec3d, b: Double) = max(a, b, Vec3d())
    fun max(a: Vec3d, b: Double, res: Vec3d): Vec3d {
        res.x = max(a.x, b)
        res.y = max(a.y, b)
        res.z = max(a.z, b)
        return res
    }

    fun max(a: Vec3, b: Vec3) = max(a, b, Vec3())
    fun max(a: Vec3, b: Vec3, res: Vec3): Vec3 {
        res.x = max(a.x, b.x)
        res.y = max(a.y, b.y)
        res.z = max(a.z, b.z)
        return res
    }

    fun max(a: Vec3d, b: Vec3d) = max(a, b, Vec3d())
    fun max(a: Vec3d, b: Vec3d, res: Vec3d): Vec3d {
        res.x = max(a.x, b.x)
        res.y = max(a.y, b.y)
        res.z = max(a.z, b.z)
        return res
    }


    fun clamp(a: Vec3, min: Float, max: Float) = clamp(a, min, max, Vec3())
    fun clamp(a: Vec3, min: Float, max: Float, res: Vec3): Vec3 {
        res.x = clamp(a.x, min, max)
        res.y = clamp(a.y, min, max)
        res.z = clamp(a.z, min, max)
        return res
    }

    fun clamp(a: Vec3d, min: Double, max: Double) = clamp(a, min, max, Vec3d())
    fun clamp(a: Vec3d, min: Double, max: Double, res: Vec3d): Vec3d {
        res.x = clamp(a.x, min, max)
        res.y = clamp(a.y, min, max)
        res.z = clamp(a.z, min, max)
        return res
    }

    fun clamp(a: Vec3, min: Vec3, max: Vec3) = clamp(a, min, max, Vec3())
    fun clamp(a: Vec3, min: Vec3, max: Vec3, res: Vec3): Vec3 {
        res.x = clamp(a.x, min.x, max.x)
        res.y = clamp(a.y, min.y, max.y)
        res.z = clamp(a.z, min.z, max.z)
        return res
    }

    fun clamp(a: Vec3d, min: Vec3d, max: Vec3d) = clamp(a, min, max, Vec3d())
    fun clamp(a: Vec3d, min: Vec3d, max: Vec3d, res: Vec3d): Vec3d {
        res.x = clamp(a.x, min.x, max.x)
        res.y = clamp(a.y, min.y, max.y)
        res.z = clamp(a.z, min.z, max.z)
        return res
    }


    fun mix(a: Vec3, b: Vec3, interp: Float) = mix(a, b, interp, Vec3())
    fun mix(a: Vec3, b: Vec3, interp: Float, res: Vec3): Vec3 {
        res.x = mix(a.x, b.x, interp)
        res.y = mix(a.y, b.y, interp)
        res.z = mix(a.z, b.z, interp)
        return res
    }

    fun mix(a: Vec3d, b: Vec3d, interp: Double) = mix(a, b, interp, Vec3d())
    fun mix(a: Vec3d, b: Vec3d, interp: Double, res: Vec3d): Vec3d {
        res.x = mix(a.x, b.x, interp)
        res.y = mix(a.y, b.y, interp)
        res.z = mix(a.z, b.z, interp)
        return res
    }

    fun mix(a: Vec3, b: Vec3, interp: Boolean) = mix(a, b, interp, Vec3())
    fun mix(a: Vec3, b: Vec3, interp: Boolean, res: Vec3): Vec3 {
        res.x = mix(a.x, b.x, interp)
        res.y = mix(a.y, b.y, interp)
        res.z = mix(a.z, b.z, interp)
        return res
    }

    fun mix(a: Vec3d, b: Vec3d, interp: Boolean) = mix(a, b, interp, Vec3d())
    fun mix(a: Vec3d, b: Vec3d, interp: Boolean, res: Vec3d): Vec3d {
        res.x = mix(a.x, b.x, interp)
        res.y = mix(a.y, b.y, interp)
        res.z = mix(a.z, b.z, interp)
        return res
    }

    fun mix(a: Vec3, b: Vec3, interp: Vec3) = mix(a, b, interp, Vec3())
    fun mix(a: Vec3, b: Vec3, interp: Vec3, res: Vec3): Vec3 {
        res.x = mix(a.x, b.x, interp.x)
        res.y = mix(a.y, b.y, interp.y)
        res.z = mix(a.z, b.z, interp.z)
        return res
    }

    fun mix(a: Vec3d, b: Vec3d, interp: Vec3d) = mix(a, b, interp, Vec3d())
    fun mix(a: Vec3d, b: Vec3d, interp: Vec3d, res: Vec3d): Vec3d {
        res.x = mix(a.x, b.x, interp.x)
        res.y = mix(a.y, b.y, interp.y)
        res.z = mix(a.z, b.z, interp.z)
        return res
    }

    fun mix(a: Vec3, b: Vec3, interp: Vec3bool) = mix(a, b, interp, Vec3())
    fun mix(a: Vec3, b: Vec3, interp: Vec3bool, res: Vec3): Vec3 {
        res.x = mix(a.x, b.x, interp.x)
        res.y = mix(a.y, b.y, interp.y)
        res.z = mix(a.z, b.z, interp.z)
        return res
    }

    fun mix(a: Vec3d, b: Vec3d, interp: Vec3bool) = mix(a, b, interp, Vec3d())
    fun mix(a: Vec3d, b: Vec3d, interp: Vec3bool, res: Vec3d): Vec3d {
        res.x = mix(a.x, b.x, interp.x)
        res.y = mix(a.y, b.y, interp.y)
        res.z = mix(a.z, b.z, interp.z)
        return res
    }


    fun step(edge: Float, a: Vec3) = step(edge, a, Vec3())
    fun step(edge: Float, a: Vec3, res: Vec3): Vec3 {
        res.x = step(edge, a.x)
        res.y = step(edge, a.y)
        res.z = step(edge, a.z)
        return res
    }

    fun step(edge: Double, a: Vec3d) = step(edge, a, Vec3d())
    fun step(edge: Double, a: Vec3d, res: Vec3d): Vec3d {
        res.x = step(edge, a.x)
        res.y = step(edge, a.y)
        res.z = step(edge, a.z)
        return res
    }

    fun step(edge: Vec3, a: Vec3) = step(edge, a, Vec3())
    fun step(edge: Vec3, a: Vec3, res: Vec3): Vec3 {
        res.x = step(edge.x, a.x)
        res.y = step(edge.y, a.y)
        res.z = step(edge.z, a.z)
        return res
    }

    fun step(edge: Vec3d, a: Vec3d) = step(edge, a, Vec3d())
    fun step(edge: Vec3d, a: Vec3d, res: Vec3d): Vec3d {
        res.x = step(edge.x, a.x)
        res.y = step(edge.y, a.y)
        res.z = step(edge.z, a.z)
        return res
    }


    fun smoothStep(edge0: Float, edge1: Float, a: Vec3) = smoothStep(edge0, edge1, a, Vec3())
    fun smoothStep(edge0: Float, edge1: Float, a: Vec3, res: Vec3): Vec3 {
        res.x = smoothStep(edge0, edge1, a.x)
        res.y = smoothStep(edge0, edge1, a.y)
        res.z = smoothStep(edge0, edge1, a.z)
        return res
    }

    fun smoothStep(edge0: Double, edge1: Double, a: Vec3d) = smoothStep(edge0, edge1, a, Vec3d())
    fun smoothStep(edge0: Double, edge1: Double, a: Vec3d, res: Vec3d): Vec3d {
        res.x = smoothStep(edge0, edge1, a.x)
        res.y = smoothStep(edge0, edge1, a.y)
        res.z = smoothStep(edge0, edge1, a.z)
        return res
    }

    fun smoothStep(edge0: Vec3, edge1: Vec3, a: Vec3) = smoothStep(edge0, edge1, a, Vec3())
    fun smoothStep(edge0: Vec3, edge1: Vec3, a: Vec3, res: Vec3): Vec3 {
        res.x = smoothStep(edge0.x, edge1.x, a.x)
        res.y = smoothStep(edge0.y, edge1.y, a.y)
        res.z = smoothStep(edge0.z, edge1.z, a.z)
        return res
    }

    fun smoothStep(edge0: Vec3d, edge1: Vec3d, a: Vec3d) = smoothStep(edge0, edge1, a, Vec3d())
    fun smoothStep(edge0: Vec3d, edge1: Vec3d, a: Vec3d, res: Vec3d): Vec3d {
        res.x = smoothStep(edge0.x, edge1.x, a.x)
        res.y = smoothStep(edge0.y, edge1.y, a.y)
        res.z = smoothStep(edge0.z, edge1.z, a.z)
        return res
    }


    fun isNan(a: Vec3) = isNan(a, Vec3bool())
    fun isNan(a: Vec3, res: Vec3bool): Vec3bool {
        res.x = isNan(a.x)
        res.y = isNan(a.y)
        res.z = isNan(a.z)
        return res
    }

    fun isNan(a: Vec3d) = isNan(a, Vec3bool())
    fun isNan(a: Vec3d, res: Vec3bool): Vec3bool {
        res.x = isNan(a.x)
        res.y = isNan(a.y)
        res.z = isNan(a.z)
        return res
    }


    fun isInf(a: Vec3) = isInf(a, Vec3bool())
    fun isInf(a: Vec3, res: Vec3bool): Vec3bool {
        res.x = isInf(a.x)
        res.y = isInf(a.y)
        res.z = isInf(a.z)
        return res
    }

    fun isInf(a: Vec3d) = isInf(a, Vec3bool())
    fun isInf(a: Vec3d, res: Vec3bool): Vec3bool {
        res.x = isInf(a.x)
        res.y = isInf(a.y)
        res.z = isInf(a.z)
        return res
    }


    fun floatBitsToInt(a: Vec3) = floatBitsToInt(a, Vec3i())
    fun floatBitsToInt(a: Vec3, res: Vec3i): Vec3i {
        res.x = floatBitsToInt(a.x)
        res.y = floatBitsToInt(a.y)
        res.z = floatBitsToInt(a.z)
        return res
    }


    fun floatBitsToUint(a: Vec3) = floatBitsToUint(a, Vec3ui())
    fun floatBitsToUint(a: Vec3, res: Vec3ui): Vec3ui {
        res.x = floatBitsToUint(a.x)    // TODO directly .v?
        res.y = floatBitsToUint(a.y)
        res.z = floatBitsToUint(a.z)
        return res
    }


    fun intBitsToFloat(a: Vec3i) = intBitsToFloat(a, Vec3())
    fun intBitsToFloat(a: Vec3i, res: Vec3): Vec3 {
        res.x = intBitsToFloat(a.x)
        res.y = intBitsToFloat(a.y)
        res.z = intBitsToFloat(a.z)
        return res
    }


    fun uintBitsToFloat(a: Vec3ui) = uintBitsToFloat(a, Vec3())
    fun uintBitsToFloat(a: Vec3ui, res: Vec3): Vec3 {
        res.x = uintBitsToFloat(a.x)
        res.y = uintBitsToFloat(a.y)
        res.z = uintBitsToFloat(a.z)
        return res
    }


    fun fma(a: Vec3, b: Vec3, c: Vec3) = fma(a, b, c, Vec3())
    fun fma(a: Vec3, b: Vec3, c: Vec3, res: Vec3): Vec3 {
        res.x = fma(a.x, b.x, c.x)
        res.y = fma(a.y, b.y, c.y)
        res.z = fma(a.z, b.z, c.z)
        return res
    }

    fun fma(a: Vec3d, b: Vec3d, c: Vec3d) = fma(a, b, c, Vec3d())
    fun fma(a: Vec3d, b: Vec3d, c: Vec3d, res: Vec3d): Vec3d {
        res.x = fma(a.x, b.x, c.x)
        res.y = fma(a.y, b.y, c.y)
        res.z = fma(a.z, b.z, c.z)
        return res
    }


    // TODO frexp, ldexp
}