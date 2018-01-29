package glm_.func.common

import glm_.glm.abs
import glm_.glm.ceil
import glm_.glm.clamp
import glm_.glm.floatBitsToInt
import glm_.glm.floatBitsToUint
import glm_.glm.floor
import glm_.glm.fma
import glm_.glm.fract
import glm_.glm.frexp
import glm_.glm.intBitsToFloat
import glm_.glm.isInf
import glm_.glm.isNan
import glm_.glm.ldexp
import glm_.glm.max
import glm_.glm.min
import glm_.glm.mix
import glm_.glm.mod
import glm_.glm.round
import glm_.glm.sign
import glm_.glm.smoothStep
import glm_.glm.step
import glm_.glm.trunc
import glm_.glm.uintBitsToFloat
import glm_.i
import glm_.vec1.*

/**
 * Created by GBarbieri on 11.11.2016.
 */
interface func_vector1_common {


    fun abs(a: Vec1) = abs(a, Vec1())
    fun abs(a: Vec1, res: Vec1): Vec1 {
        res.x = abs(a.x)
        return res
    }


    //    fun abs(a: Vec1b) = abs(a, Vec1b())
//    fun abs(a: Vec1b, res: Vec1b): Vec1b {
//        res.x = abs(a.x)
//        return res
//    }
//
//
    fun abs(a: Vec1d) = abs(a, Vec1d())

    fun abs(a: Vec1d, res: Vec1d): Vec1d {
        res.x = abs(a.x)
        return res
    }
//
//    fun abs(a: Vec1i) = abs(a, Vec1i())
//    fun abs(a: Vec1i, res: Vec1i): Vec1i {
//        res.x = abs(a.x)
//        return res
//    }
//
//    fun abs(a: Vec1l) = abs(a, Vec1l())
//    fun abs(a: Vec1l, res: Vec1l): Vec1l {
//        res.x = abs(a.x)
//        return res
//    }
//
//    fun abs(a: Vec1s) = abs(a, Vec1s())
//    fun abs(a: Vec1s, res: Vec1s): Vec1s {
//        res.x = abs(a.x)
//        return res
//    }


    fun sign(a: Vec1) = sign(a, Vec1())
    fun sign(a: Vec1, res: Vec1): Vec1 {
        res.x = sign(a.x)
        return res
    }

    //    fun sign(a: Vec1b) = sign(a, Vec1b())
//    fun sign(a: Vec1b, res: Vec1b): Vec1b {
//        res.x = sign(a.x)
//        return res
//    }
//
    fun sign(a: Vec1d) = sign(a, Vec1d())

    fun sign(a: Vec1d, res: Vec1d): Vec1d {
        res.x = sign(a.x)
        return res
    }

//    fun sign(a: Vec1i) = sign(a, Vec1i())
//    fun sign(a: Vec1i, res: Vec1i): Vec1i {
//        res.x = sign(a.x)
//        return res
//    }
//
//    fun sign(a: Vec1l) = sign(a, Vec1l())
//    fun sign(a: Vec1l, res: Vec1l): Vec1l {
//        res.x = sign(a.x)
//        return res
//    }
//
//    fun sign(a: Vec1s) = sign(a, Vec1s())
//    fun sign(a: Vec1s, res: Vec1s): Vec1s {
//        res.x = sign(a.x)
//        return res
//    }


    fun floor(a: Vec1) = floor(a, Vec1())
    fun floor(a: Vec1, res: Vec1): Vec1 {
        res.x = floor(a.x)
        return res
    }

    fun floor(a: Vec1d) = floor(a, Vec1d())
    fun floor(a: Vec1d, res: Vec1d): Vec1d {
        res.x = floor(a.x)
        return res
    }


    fun trunc(a: Vec1) = trunc(a, Vec1())
    fun trunc(a: Vec1, res: Vec1): Vec1 {
        res.x = trunc(a.x)
        return res
    }

    fun trunc(a: Vec1d) = trunc(a, Vec1d())
    fun trunc(a: Vec1d, res: Vec1d): Vec1d {
        res.x = trunc(a.x)
        return res
    }


    fun round(a: Vec1) = round(a, Vec1())
    fun round(a: Vec1, res: Vec1): Vec1 {
        res.x = round(a.x)
        return res
    }

    fun round(a: Vec1d) = round(a, Vec1d())
    fun round(a: Vec1d, res: Vec1d): Vec1d {
        res.x = round(a.x)
        return res
    }


    // TODO roundEven


    fun ceil(a: Vec1) = ceil(a, Vec1())
    fun ceil(a: Vec1, res: Vec1): Vec1 {
        res.x = ceil(a.x)
        return res
    }

    fun ceil(a: Vec1d) = ceil(a, Vec1d())
    fun ceil(a: Vec1d, res: Vec1d): Vec1d {
        res.x = ceil(a.x)
        return res
    }


    fun fract(a: Vec1) = fract(a, Vec1())
    fun fract(a: Vec1, res: Vec1): Vec1 {
        res.x = fract(a.x)
        return res
    }

    fun fract(a: Vec1d) = fract(a, Vec1d())
    fun fract(a: Vec1d, res: Vec1d): Vec1d {
        res.x = fract(a.x)
        return res
    }


    fun mod(a: Vec1, b: Float) = mod(a, b, Vec1())
    fun mod(a: Vec1, b: Float, res: Vec1): Vec1 {
        res.x = mod(a.x, b)
        return res
    }

    fun mod(a: Vec1d, b: Double) = mod(a, b, Vec1d())
    fun mod(a: Vec1d, b: Double, res: Vec1d): Vec1d {
        res.x = mod(a.x, b)
        return res
    }

    fun mod(a: Vec1, b: Vec1) = mod(a, b, Vec1())
    fun mod(a: Vec1, b: Vec1, res: Vec1): Vec1 {
        res.x = mod(a.x, b.x)
        return res
    }

    fun mod(a: Vec1d, b: Vec1d) = mod(a, b, Vec1d())
    fun mod(a: Vec1d, b: Vec1d, res: Vec1d): Vec1d {
        res.x = mod(a.x, b.x)
        return res
    }


    // TODO modf


    fun min(a: Vec1, b: Float) = min(a, b, Vec1())
    fun min(a: Vec1, b: Float, res: Vec1): Vec1 {
        res.x = min(a.x, b)
        return res
    }

    fun min(a: Vec1d, b: Double) = min(a, b, Vec1d())
    fun min(a: Vec1d, b: Double, res: Vec1d): Vec1d {
        res.x = min(a.x, b)
        return res
    }

    fun min(a: Vec1, b: Vec1) = min(a, b, Vec1())
    fun min(a: Vec1, b: Vec1, res: Vec1): Vec1 {
        res.x = min(a.x, b.x)
        return res
    }

    fun min(a: Vec1d, b: Vec1d) = min(a, b, Vec1d())
    fun min(a: Vec1d, b: Vec1d, res: Vec1d): Vec1d {
        res.x = min(a.x, b.x)
        return res
    }

    // TODO others
//    fun min(a: Vec1i, b: Int) = min(a, b, Vec1i())
//    fun min(a: Vec1i, b: Int, res: Vec1i): Vec1i {
//        res.x = min(a.x, b)
//        return res
//    }
//
//    fun min(a: Vec1i, b: Vec1i) = min(a, b, Vec1i())
//    fun min(a: Vec1i, b: Vec1i, res: Vec1i): Vec1i {
//        res.x = min(a.x, b.x)
//        return res
//    }
//
//    fun min(a: Vec1b, b: Byte) = min(a, b, Vec1b())
//
//    fun min(a: Vec1b, b: Byte, res: Vec1b): Vec1b {
//        res.x = min(a.x, b)
//        return res
//    }
//
//    fun min(a: Vec1b, b: Vec1b) = min(a, b, Vec1b())
//    fun min(a: Vec1b, b: Vec1b, res: Vec1b): Vec1b {
//        res.x = min(a.x, b.x)
//        return res
//    }


    fun max(a: Vec1, b: Float) = max(a, b, Vec1())
    fun max(a: Vec1, b: Float, res: Vec1): Vec1 {
        res.x = max(a.x, b)
        return res
    }

    fun max(a: Vec1d, b: Double) = max(a, b, Vec1d())
    fun max(a: Vec1d, b: Double, res: Vec1d): Vec1d {
        res.x = max(a.x, b)
        return res
    }

    fun max(a: Vec1, b: Vec1) = max(a, b, Vec1())
    fun max(a: Vec1, b: Vec1, res: Vec1): Vec1 {
        res.x = max(a.x, b.x)
        return res
    }

    fun max(a: Vec1d, b: Vec1d) = max(a, b, Vec1d())
    fun max(a: Vec1d, b: Vec1d, res: Vec1d): Vec1d {
        res.x = max(a.x, b.x)
        return res
    }
//
//    fun max(a: Vec1i, b: Int) = max(a, b, Vec1i())
//    fun max(a: Vec1i, b: Int, res: Vec1i): Vec1i {
//        res.x = max(a.x, b)
//        return res
//    }
//
//    fun max(a: Vec1i, b: Vec1i) = max(a, b, Vec1i())
//    fun max(a: Vec1i, b: Vec1i, res: Vec1i): Vec1i {
//        res.x = max(a.x, b.x)
//        return res
//    }
//
//    fun max(a: Vec1b, b: Byte) = max(a, b, Vec1b())
//    fun max(a: Vec1b, b: Byte, res: Vec1b): Vec1b {
//        res.x = max(a.x, b)
//        return res
//    }
//
//    fun max(a: Vec1b, b: Vec1b) = max(a, b, Vec1b())
//    fun max(a: Vec1b, b: Vec1b, res: Vec1b): Vec1b {
//        res.x = max(a.x, b.x)
//        return res
//    }


    fun clamp(a: Vec1, min: Float, max: Float) = clamp(a, min, max, Vec1())
    fun clamp(a: Vec1, min: Float, max: Float, res: Vec1): Vec1 {
        res.x = clamp(a.x, min, max)
        return res
    }

    fun clamp(a: Vec1d, min: Double, max: Double) = clamp(a, min, max, Vec1d())
    fun clamp(a: Vec1d, min: Double, max: Double, res: Vec1d): Vec1d {
        res.x = clamp(a.x, min, max)
        return res
    }

    fun clamp(a: Vec1, min: Vec1, max: Vec1) = clamp(a, min, max, Vec1())
    fun clamp(a: Vec1, min: Vec1, max: Vec1, res: Vec1): Vec1 {
        res.x = clamp(a.x, min.x, max.x)
        return res
    }

    fun clamp(a: Vec1d, min: Vec1d, max: Vec1d) = clamp(a, min, max, Vec1d())
    fun clamp(a: Vec1d, min: Vec1d, max: Vec1d, res: Vec1d): Vec1d {
        res.x = clamp(a.x, min.x, max.x)
        return res
    }


    fun mix(a: Vec1, b: Vec1, interp: Float) = mix(a, b, interp, Vec1())
    fun mix(a: Vec1, b: Vec1, interp: Float, res: Vec1): Vec1 {
        res.x = mix(a.x, b.x, interp)
        return res
    }

    fun mix(a: Vec1d, b: Vec1d, interp: Double) = mix(a, b, interp, Vec1d())
    fun mix(a: Vec1d, b: Vec1d, interp: Double, res: Vec1d): Vec1d {
        res.x = mix(a.x, b.x, interp)
        return res
    }

    fun mix(a: Vec1, b: Vec1, interp: Boolean) = mix(a, b, interp, Vec1())
    fun mix(a: Vec1, b: Vec1, interp: Boolean, res: Vec1): Vec1 {
        res.x = mix(a.x, b.x, interp)
        return res
    }

    fun mix(a: Vec1d, b: Vec1d, interp: Boolean) = mix(a, b, interp, Vec1d())
    fun mix(a: Vec1d, b: Vec1d, interp: Boolean, res: Vec1d): Vec1d {
        res.x = mix(a.x, b.x, interp)
        return res
    }

    fun mix(a: Vec1, b: Vec1, interp: Vec1) = mix(a, b, interp, Vec1())
    fun mix(a: Vec1, b: Vec1, interp: Vec1, res: Vec1): Vec1 {
        res.x = mix(a.x, b.x, interp.x)
        return res
    }

    fun mix(a: Vec1d, b: Vec1d, interp: Vec1d) = mix(a, b, interp, Vec1d())
    fun mix(a: Vec1d, b: Vec1d, interp: Vec1d, res: Vec1d = Vec1d()): Vec1d {
        res.x = mix(a.x, b.x, interp.x)
        return res
    }

    fun mix(a: Vec1, b: Vec1, interp: Vec1bool) = mix(a, b, interp, Vec1())
    fun mix(a: Vec1, b: Vec1, interp: Vec1bool, res: Vec1): Vec1 {
        res.x = mix(a.x, b.x, interp.x)
        return res
    }

    fun mix(a: Vec1d, b: Vec1d, interp: Vec1bool) = mix(a, b, interp, Vec1d())
    fun mix(a: Vec1d, b: Vec1d, interp: Vec1bool, res: Vec1d): Vec1d {
        res.x = mix(a.x, b.x, interp.x)
        return res
    }


    fun step(edge: Float, a: Vec1) = step(edge, a, Vec1())
    fun step(edge: Float, a: Vec1, res: Vec1): Vec1 {
        res.x = step(edge, a.x)
        return res
    }

    fun step(edge: Double, a: Vec1d) = step(edge, a, Vec1d())
    fun step(edge: Double, a: Vec1d, res: Vec1d): Vec1d {
        res.x = step(edge, a.x)
        return res
    }

    fun step(edge: Vec1, a: Vec1) = step(edge, a, Vec1())
    fun step(edge: Vec1, a: Vec1, res: Vec1): Vec1 {
        res.x = step(edge.x, a.x)
        return res
    }

    fun step(edge: Vec1d, a: Vec1d) = step(edge, a, Vec1d())
    fun step(edge: Vec1d, a: Vec1d, res: Vec1d): Vec1d {
        res.x = step(edge.x, a.x)
        return res
    }


    fun smoothStep(edge0: Float, edge1: Float, a: Vec1) = smoothStep(edge0, edge1, a, Vec1())
    fun smoothStep(edge0: Float, edge1: Float, a: Vec1, res: Vec1): Vec1 {
        res.x = smoothStep(edge0, edge1, a.x)
        return res
    }

    fun smoothStep(edge0: Double, edge1: Double, a: Vec1d) = smoothStep(edge0, edge1, a, Vec1d())
    fun smoothStep(edge0: Double, edge1: Double, a: Vec1d, res: Vec1d): Vec1d {
        res.x = smoothStep(edge0, edge1, a.x)
        return res
    }

    fun smoothStep(edge0: Vec1, edge1: Vec1, a: Vec1) = smoothStep(edge0, edge1, a, Vec1())
    fun smoothStep(edge0: Vec1, edge1: Vec1, a: Vec1, res: Vec1): Vec1 {
        res.x = smoothStep(edge0.x, edge1.x, a.x)
        return res
    }

    fun smoothStep(edge0: Vec1d, edge1: Vec1d, a: Vec1d) = smoothStep(edge0, edge1, a, Vec1d())
    fun smoothStep(edge0: Vec1d, edge1: Vec1d, a: Vec1d, res: Vec1d): Vec1d {
        res.x = smoothStep(edge0.x, edge1.x, a.x)
        return res
    }


    fun isNan(a: Vec1) = isNan(a, Vec1bool())
    fun isNan(a: Vec1, res: Vec1bool): Vec1bool {
        res.x = isNan(a.x)
        return res
    }

    fun isNan(a: Vec1d) = isNan(a, Vec1bool())
    fun isNan(a: Vec1d, res: Vec1bool): Vec1bool {
        res.x = isNan(a.x)
        return res
    }


    fun isInf(a: Vec1) = isInf(a, Vec1bool())
    fun isInf(a: Vec1, res: Vec1bool): Vec1bool {
        res.x = isInf(a.x)
        return res
    }

    fun isInf(a: Vec1d) = isInf(a, Vec1bool())
    fun isInf(a: Vec1d, res: Vec1bool): Vec1bool {
        res.x = isInf(a.x)
        return res
    }


    fun floatBitsToInt(a: Vec1) = floatBitsToInt(a, Vec1i())
    fun floatBitsToInt(a: Vec1, res: Vec1i): Vec1i {
        res.x = floatBitsToInt(a.x)
        return res
    }


    fun floatBitsToUint(a: Vec1) = floatBitsToUint(a, Vec1ui())
    fun floatBitsToUint(a: Vec1, res: Vec1ui): Vec1ui {
        res.x = floatBitsToUint(a.x)    // TODO directly .v?
        return res
    }


    fun intBitsToFloat(a: Vec1i) = intBitsToFloat(a, Vec1())
    fun intBitsToFloat(a: Vec1i, res: Vec1): Vec1 {
        res.x = intBitsToFloat(a.x)
        return res
    }


    fun uintBitsToFloat(a: Vec1ui) = uintBitsToFloat(a, Vec1())
    fun uintBitsToFloat(a: Vec1ui, res: Vec1): Vec1 {
        res.x = uintBitsToFloat(a.x)
        return res
    }


    fun fma(a: Vec1, b: Vec1, c: Vec1) = fma(a, b, c, Vec1())
    fun fma(a: Vec1, b: Vec1, c: Vec1, res: Vec1): Vec1 {
        res.x = fma(a.x, b.x, c.x)
        return res
    }

    fun fma(a: Vec1d, b: Vec1d, c: Vec1d) = fma(a, b, c, Vec1d())
    fun fma(a: Vec1d, b: Vec1d, c: Vec1d, res: Vec1d): Vec1d {
        res.x = fma(a.x, b.x, c.x)
        return res
    }

    fun frexp(a: Vec1, exp: Vec1i) = frexp(a, exp, Vec1())
    fun frexp(a: Vec1, exp: Vec1i, res: Vec1): Vec1 {
        res.x = frexp(a.x, ::_i)
        exp.x = _i
        return res
    }

    fun frexp(a: Vec1d, exp: Vec1i) = frexp(a, exp, Vec1d())
    fun frexp(a: Vec1d, exp: Vec1i, res: Vec1d): Vec1d {
        res.x = frexp(a.x, ::_i)
        exp.x = _i
        return res
    }


    fun ldexp(a: Vec1, exp: Vec1i) = ldexp(a, exp, Vec1())
    fun ldexp(a: Vec1, exp: Vec1i, res: Vec1): Vec1 {
        res.x = ldexp(a.x, exp.x)
        return res
    }

    fun ldexp(a: Vec1d, exp: Vec1i) = ldexp(a, exp, Vec1d())
    fun ldexp(a: Vec1d, exp: Vec1i, res: Vec1d): Vec1d {
        res.x = ldexp(a.x, exp.x)
        return res
    }


    companion object {
        var _i = 0  // TODO mention potential multithread issues
    }
}