package glm.func.common

import glm.Glm.abs
import glm.Glm.ceil
import glm.Glm.clamp
import glm.Glm.floatBitsToInt
import glm.Glm.floatBitsToUint
import glm.Glm.floor
import glm.Glm.fma
import glm.Glm.fract
import glm.Glm.intBitsToFloat
import glm.Glm.isInf
import glm.Glm.isNan
import glm.Glm.max
import glm.Glm.min
import glm.Glm.mix
import glm.Glm.mod
import glm.Glm.round
import glm.Glm.sign
import glm.Glm.smoothStep
import glm.Glm.step
import glm.Glm.trunc
import glm.Glm.uintBitsToFloat
import vec._2.*
import vec.bool.Vec2bool

/**
 * Created by GBarbieri on 11.11.2016.
 */
interface func_vector2_common {


    fun abs(a: Vec2, res: Vec2 = Vec2()): Vec2 {
        res.x = abs(a.x)
        res.y = abs(a.y)
        return res
    }

    fun abs(a: Vec2b, res: Vec2b = Vec2b()): Vec2b {
        res.x = abs(a.x)
        res.y = abs(a.y)
        return res
    }

    fun abs(a: Vec2d, res: Vec2d = Vec2d()): Vec2d {
        res.x = abs(a.x)
        res.y = abs(a.y)
        return res
    }

    fun abs(a: Vec2i, res: Vec2i = Vec2i()): Vec2i {
        res.x = abs(a.x)
        res.y = abs(a.y)
        return res
    }

    fun abs(a: Vec2l, res: Vec2l = Vec2l()): Vec2l {
        res.x = abs(a.x)
        res.y = abs(a.y)
        return res
    }

    fun abs(a: Vec2s, res: Vec2s = Vec2s()): Vec2s {
        res.x = abs(a.x)
        res.y = abs(a.y)
        return res
    }


    fun sign(a: Vec2, res: Vec2 = Vec2()): Vec2 {
        res.x = sign(a.x)
        res.y = sign(a.y)
        return res
    }

    fun sign(a: Vec2b, res: Vec2b = Vec2b()): Vec2b {
        res.x = sign(a.x)
        res.y = sign(a.y)
        return res
    }

    fun sign(a: Vec2d, res: Vec2d = Vec2d()): Vec2d {
        res.x = sign(a.x)
        res.y = sign(a.y)
        return res
    }

    fun sign(a: Vec2i, res: Vec2i = Vec2i()): Vec2i {
        res.x = sign(a.x)
        res.y = sign(a.y)
        return res
    }

    fun sign(a: Vec2l, res: Vec2l = Vec2l()): Vec2l {
        res.x = sign(a.x)
        res.y = sign(a.y)
        return res
    }

    fun sign(a: Vec2s, res: Vec2s = Vec2s()): Vec2s {
        res.x = sign(a.x)
        res.y = sign(a.y)
        return res
    }


    fun floor(a: Vec2, res: Vec2 = Vec2()): Vec2 {
        res.x = floor(a.x)
        res.y = floor(a.y)
        return res
    }

    fun floor(a: Vec2d, res: Vec2d = Vec2d()): Vec2d {
        res.x = floor(a.x)
        res.y = floor(a.y)
        return res
    }


    fun trunc(a: Vec2, res: Vec2 = Vec2()): Vec2 {
        res.x = trunc(a.x)
        res.y = trunc(a.y)
        return res
    }

    fun trunc(a: Vec2d, res: Vec2d = Vec2d()): Vec2d {
        res.x = trunc(a.x)
        res.y = trunc(a.y)
        return res
    }


    fun round(a: Vec2, res: Vec2 = Vec2()): Vec2 {
        res.x = round(a.x)
        res.y = round(a.y)
        return res
    }

    fun round(a: Vec2d, res: Vec2d = Vec2d()): Vec2d {
        res.x = round(a.x)
        res.y = round(a.y)
        return res
    }


    // TODO roundEven


    fun ceil(a: Vec2, res: Vec2 = Vec2()): Vec2 {
        res.x = ceil(a.x)
        res.y = ceil(a.y)
        return res
    }

    fun ceil(a: Vec2d, res: Vec2d = Vec2d()): Vec2d {
        res.x = ceil(a.x)
        res.y = ceil(a.y)
        return res
    }


    fun fract(a: Vec2, res: Vec2 = Vec2()): Vec2 {
        res.x = fract(a.x)
        res.y = fract(a.y)
        return res
    }

    fun fract(a: Vec2d, res: Vec2d = Vec2d()): Vec2d {
        res.x = fract(a.x)
        res.y = fract(a.y)
        return res
    }


    fun mod(a: Vec2, b: Float, res: Vec2 = Vec2()): Vec2 {
        res.x = mod(a.x, b)
        res.y = mod(a.y, b)
        return res
    }

    fun mod(a: Vec2d, b: Double, res: Vec2d = Vec2d()): Vec2d {
        res.x = mod(a.x, b)
        res.y = mod(a.y, b)
        return res
    }

    fun mod(a: Vec2, b: Vec2, res: Vec2 = Vec2()): Vec2 {
        res.x = mod(a.x, b.x)
        res.y = mod(a.y, b.y)
        return res
    }

    fun mod(a: Vec2d, b: Vec2d, res: Vec2d = Vec2d()): Vec2d {
        res.x = mod(a.x, b.x)
        res.y = mod(a.y, b.y)
        return res
    }


    // TODO modf


    fun min(a: Vec2, b: Float, res: Vec2 = Vec2()): Vec2 {
        res.x = min(a.x, b)
        res.y = min(a.y, b)
        return res
    }

    fun min(a: Vec2d, b: Double, res: Vec2d = Vec2d()): Vec2d {
        res.x = min(a.x, b)
        res.y = min(a.y, b)
        return res
    }

    fun min(a: Vec2, b: Vec2, res: Vec2 = Vec2()): Vec2 {
        res.x = min(a.x, b.x)
        res.y = min(a.y, b.y)
        return res
    }

    fun min(a: Vec2d, b: Vec2d, res: Vec2d = Vec2d()): Vec2d {
        res.x = min(a.x, b.x)
        res.y = min(a.y, b.y)
        return res
    }

    fun max(a: Vec2, b: Float, res: Vec2 = Vec2()): Vec2 {
        res.x = max(a.x, b)
        res.y = max(a.y, b)
        return res
    }

    fun max(a: Vec2d, b: Double, res: Vec2d = Vec2d()): Vec2d {
        res.x = max(a.x, b)
        res.y = max(a.y, b)
        return res
    }

    fun max(a: Vec2, b: Vec2, res: Vec2 = Vec2()): Vec2 {
        res.x = max(a.x, b.x)
        res.y = max(a.y, b.y)
        return res
    }

    fun max(a: Vec2d, b: Vec2d, res: Vec2d = Vec2d()): Vec2d {
        res.x = max(a.x, b.x)
        res.y = max(a.y, b.y)
        return res
    }


    fun clamp(a: Vec2, min: Float, max: Float, res: Vec2 = Vec2()): Vec2 {
        res.x = clamp(a.x, min, max)
        res.y = clamp(a.y, min, max)
        return res
    }

    fun clamp(a: Vec2d, min: Double, max: Double, res: Vec2d = Vec2d()): Vec2d {
        res.x = clamp(a.x, min, max)
        res.y = clamp(a.y, min, max)
        return res
    }

    fun clamp(a: Vec2, min: Vec2, max: Vec2, res: Vec2 = Vec2()): Vec2 {
        res.x = clamp(a.x, min.x, max.x)
        res.y = clamp(a.y, min.y, max.y)
        return res
    }

    fun clamp(a: Vec2d, min: Vec2d, max: Vec2d, res: Vec2d = Vec2d()): Vec2d {
        res.x = clamp(a.x, min.x, max.x)
        res.y = clamp(a.y, min.y, max.y)
        return res
    }


    fun mix(a: Vec2, b: Float, interp: Float, res: Vec2 = Vec2()): Vec2 {
        res.x = mix(a.x, b, interp)
        res.y = mix(a.y, b, interp)
        return res
    }

    fun mix(a: Vec2d, b: Double, interp: Double, res: Vec2d = Vec2d()): Vec2d {
        res.x = mix(a.x, b, interp)
        res.y = mix(a.y, b, interp)
        return res
    }

    fun mix(a: Vec2, b: Vec2, interp: Boolean, res: Vec2 = Vec2()): Vec2 {
        res.x = mix(a.x, b.x, interp)
        res.y = mix(a.y, b.y, interp)
        return res
    }

    fun mix(a: Vec2d, b: Vec2d, interp: Boolean, res: Vec2d = Vec2d()): Vec2d {
        res.x = mix(a.x, b.x, interp)
        res.y = mix(a.y, b.y, interp)
        return res
    }

    fun mix(a: Vec2, b: Vec2, interp: Vec2, res: Vec2 = Vec2()): Vec2 {
        res.x = mix(a.x, b.x, interp.x)
        res.y = mix(a.y, b.y, interp.y)
        return res
    }

    fun mix(a: Vec2d, b: Vec2d, interp: Vec2d, res: Vec2d = Vec2d()): Vec2d {
        res.x = mix(a.x, b.x, interp.x)
        res.y = mix(a.y, b.y, interp.y)
        return res
    }

    fun mix(a: Vec2, b: Vec2, interp: Vec2bool, res: Vec2 = Vec2()): Vec2 {
        res.x = mix(a.x, b.x, interp.x)
        res.y = mix(a.y, b.y, interp.y)
        return res
    }

    fun mix(a: Vec2d, b: Vec2d, interp: Vec2bool, res: Vec2d = Vec2d()): Vec2d {
        res.x = mix(a.x, b.x, interp.x)
        res.y = mix(a.y, b.y, interp.y)
        return res
    }


    fun step(edge: Float, a: Vec2, res: Vec2 = Vec2()): Vec2 {
        res.x = step(edge, a.x)
        res.y = step(edge, a.y)
        return res
    }

    fun step(edge: Double, a: Vec2d, res: Vec2d = Vec2d()): Vec2d {
        res.x = step(edge, a.x)
        res.y = step(edge, a.y)
        return res
    }

    fun step(edge: Vec2, a: Vec2, res: Vec2 = Vec2()): Vec2 {
        res.x = step(edge.x, a.x)
        res.y = step(edge.y, a.y)
        return res
    }

    fun step(edge: Vec2d, a: Vec2d, res: Vec2d = Vec2d()): Vec2d {
        res.x = step(edge.x, a.x)
        res.y = step(edge.y, a.y)
        return res
    }


    fun smoothStep(edge0: Float, edge1: Float, a: Vec2, res: Vec2 = Vec2()): Vec2 {
        res.x = smoothStep(edge0, edge1, a.x)
        res.y = smoothStep(edge0, edge1, a.y)
        return res
    }

    fun smoothStep(edge0: Double, edge1: Double, a: Vec2d, res: Vec2d = Vec2d()): Vec2d {
        res.x = smoothStep(edge0, edge1, a.x)
        res.y = smoothStep(edge0, edge1, a.y)
        return res
    }

    fun smoothStep(edge0: Vec2, edge1: Vec2, a: Vec2, res: Vec2 = Vec2()): Vec2 {
        res.x = smoothStep(edge0.x, edge1.x, a.x)
        res.y = smoothStep(edge0.y, edge1.y, a.y)
        return res
    }

    fun smoothStep(edge0: Vec2d, edge1: Vec2d, a: Vec2d, res: Vec2d = Vec2d()): Vec2d {
        res.x = smoothStep(edge0.x, edge1.x, a.x)
        res.y = smoothStep(edge0.y, edge1.y, a.y)
        return res
    }


    fun isNan(a: Vec2, res: Vec2bool = Vec2bool()): Vec2bool {
        res.x = isNan(a.x)
        res.y = isNan(a.y)
        return res
    }

    fun isNan(a: Vec2d, res: Vec2bool = Vec2bool()): Vec2bool {
        res.x = isNan(a.x)
        res.y = isNan(a.y)
        return res
    }


    fun isInf(a: Vec2, res: Vec2bool = Vec2bool()): Vec2bool {
        res.x = isInf(a.x)
        res.y = isInf(a.y)
        return res
    }

    fun isInf(a: Vec2d, res: Vec2bool = Vec2bool()): Vec2bool {
        res.x = isInf(a.x)
        res.y = isInf(a.y)
        return res
    }


    fun floatBitsToInt(a: Vec2, res: Vec2i = Vec2i()): Vec2i {
        res.x = floatBitsToInt(a.x)
        res.y = floatBitsToInt(a.y)
        return res
    }


    fun floatBitsToUint(a: Vec2, res: Vec2ui = Vec2ui()): Vec2ui {
        res.x = floatBitsToUint(a.x)    // TODO directly .v?
        res.y = floatBitsToUint(a.y)
        return res
    }


    fun intBitsToFloat(a: Vec2i, res: Vec2 = Vec2()): Vec2 {
        res.x = intBitsToFloat(a.x)
        res.y = intBitsToFloat(a.y)
        return res
    }


    fun uintBitsToFloat(a: Vec2ui, res: Vec2 = Vec2()): Vec2 {
        res.x = uintBitsToFloat(a.x)
        res.y = uintBitsToFloat(a.y)
        return res
    }


    fun fma(a: Vec2, b: Vec2, c: Vec2, res: Vec2 = Vec2()): Vec2 {
        res.x = fma(a.x, b.x, c.x)
        res.y = fma(a.y, b.y, c.y)
        return res
    }

    fun fma(a: Vec2d, b: Vec2d, c: Vec2d, res: Vec2d = Vec2d()): Vec2d {
        res.x = fma(a.x, b.x, c.x)
        res.y = fma(a.y, b.y, c.y)
        return res
    }


    // TODO frexp, ldexp
}