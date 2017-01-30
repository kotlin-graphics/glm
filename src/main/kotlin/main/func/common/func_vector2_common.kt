package main.func.common

import vec._2.*
import vec.bool.Vec2bool
import main.glm.Companion.abs
import main.glm.Companion.sign
import main.glm.Companion.floor
import main.glm.Companion.trunc
import main.glm.Companion.round
import main.glm.Companion.ceil
import main.glm.Companion.fract
import main.glm.Companion.mod
import main.glm.Companion.min
import main.glm.Companion.max
import main.glm.Companion.mix
import main.glm.Companion.clamp
import main.glm.Companion.step
import main.glm.Companion.smoothStep
import main.glm.Companion.isInf
import main.glm.Companion.isNan
import main.glm.Companion.floatBitsToInt
import main.glm.Companion.floatBitsToUint
import main.glm.Companion.intBitsToFloat
import main.glm.Companion.uintBitsToFloat
import main.glm.Companion.fma
import vec._2.Vec2

/**
 * Created by GBarbieri on 11.11.2016.
 */
interface func_vector2_common {


    fun abs(a: Vec2, res: Vec2 = Vec2()): Vec2 {
        res.x = func_common.abs(a.x)
        res.y = func_common.abs(a.y)
        return res
    }

    fun abs(a: Vec2b, res: Vec2b = Vec2b()): Vec2b {
        res.x = func_common.abs(a.x)
        res.y = func_common.abs(a.y)
        return res
    }

    fun abs(a: Vec2d, res: Vec2d = Vec2d()): Vec2d {
        res.x = func_common.abs(a.x)
        res.y = func_common.abs(a.y)
        return res
    }

    fun abs(a: Vec2i, res: Vec2i = Vec2i()): Vec2i {
        res.x = func_common.abs(a.x)
        res.y = func_common.abs(a.y)
        return res
    }

    fun abs(a: Vec2l, res: Vec2l = Vec2l()): Vec2l {
        res.x = func_common.abs(a.x)
        res.y = func_common.abs(a.y)
        return res
    }

    fun abs(a: Vec2s, res: Vec2s = Vec2s()): Vec2s {
        res.x = func_common.abs(a.x)
        res.y = func_common.abs(a.y)
        return res
    }


    fun sign(a: Vec2, res: Vec2 = Vec2()): Vec2 {
        res.x = func_common.sign(a.x)
        res.y = func_common.sign(a.y)
        return res
    }

    fun sign(a: Vec2b, res: Vec2b = Vec2b()): Vec2b {
        res.x = func_common.sign(a.x)
        res.y = func_common.sign(a.y)
        return res
    }

    fun sign(a: Vec2d, res: Vec2d = Vec2d()): Vec2d {
        res.x = func_common.sign(a.x)
        res.y = func_common.sign(a.y)
        return res
    }

    fun sign(a: Vec2i, res: Vec2i = Vec2i()): Vec2i {
        res.x = func_common.sign(a.x)
        res.y = func_common.sign(a.y)
        return res
    }

    fun sign(a: Vec2l, res: Vec2l = Vec2l()): Vec2l {
        res.x = func_common.sign(a.x)
        res.y = func_common.sign(a.y)
        return res
    }

    fun sign(a: Vec2s, res: Vec2s = Vec2s()): Vec2s {
        res.x = func_common.sign(a.x)
        res.y = func_common.sign(a.y)
        return res
    }


    fun floor(a: Vec2, res: Vec2 = Vec2()): Vec2 {
        res.x = func_common.floor(a.x)
        res.y = func_common.floor(a.y)
        return res
    }

    fun floor(a: Vec2d, res: Vec2d = Vec2d()): Vec2d {
        res.x = func_common.floor(a.x)
        res.y = func_common.floor(a.y)
        return res
    }


    fun trunc(a: Vec2, res: Vec2 = Vec2()): Vec2 {
        res.x = func_common.trunc(a.x)
        res.y = func_common.trunc(a.y)
        return res
    }

    fun trunc(a: Vec2d, res: Vec2d = Vec2d()): Vec2d {
        res.x = func_common.trunc(a.x)
        res.y = func_common.trunc(a.y)
        return res
    }


    fun round(a: Vec2, res: Vec2 = Vec2()): Vec2 {
        res.x = func_common.round(a.x)
        res.y = func_common.round(a.y)
        return res
    }

    fun round(a: Vec2d, res: Vec2d = Vec2d()): Vec2d {
        res.x = func_common.round(a.x)
        res.y = func_common.round(a.y)
        return res
    }


    // TODO roundEven


    fun ceil(a: Vec2, res: Vec2 = Vec2()): Vec2 {
        res.x = func_common.ceil(a.x)
        res.y = func_common.ceil(a.y)
        return res
    }

    fun ceil(a: Vec2d, res: Vec2d = Vec2d()): Vec2d {
        res.x = func_common.ceil(a.x)
        res.y = func_common.ceil(a.y)
        return res
    }


    fun fract(a: Vec2, res: Vec2 = Vec2()): Vec2 {
        res.x = func_common.fract(a.x)
        res.y = func_common.fract(a.y)
        return res
    }

    fun fract(a: Vec2d, res: Vec2d = Vec2d()): Vec2d {
        res.x = func_common.fract(a.x)
        res.y = func_common.fract(a.y)
        return res
    }


    fun mod(a: Vec2, b: Float, res: Vec2 = Vec2()): Vec2 {
        res.x = func_common.mod(a.x, b)
        res.y = func_common.mod(a.y, b)
        return res
    }

    fun mod(a: Vec2d, b: Double, res: Vec2d = Vec2d()): Vec2d {
        res.x = func_common.mod(a.x, b)
        res.y = func_common.mod(a.y, b)
        return res
    }

    fun mod(a: Vec2, b: Vec2, res: Vec2 = Vec2()): Vec2 {
        res.x = func_common.mod(a.x, b.x)
        res.y = func_common.mod(a.y, b.y)
        return res
    }

    fun mod(a: Vec2d, b: Vec2d, res: Vec2d = Vec2d()): Vec2d {
        res.x = func_common.mod(a.x, b.x)
        res.y = func_common.mod(a.y, b.y)
        return res
    }


    // TODO modf


    fun min(a: Vec2, b: Float, res: Vec2 = Vec2()): Vec2 {
        res.x = func_common.min(a.x, b)
        res.y = func_common.min(a.y, b)
        return res
    }

    fun min(a: Vec2d, b: Double, res: Vec2d = Vec2d()): Vec2d {
        res.x = func_common.min(a.x, b)
        res.y = func_common.min(a.y, b)
        return res
    }

    fun min(a: Vec2, b: Vec2, res: Vec2 = Vec2()): Vec2 {
        res.x = func_common.min(a.x, b.x)
        res.y = func_common.min(a.y, b.y)
        return res
    }

    fun min(a: Vec2d, b: Vec2d, res: Vec2d = Vec2d()): Vec2d {
        res.x = func_common.min(a.x, b.x)
        res.y = func_common.min(a.y, b.y)
        return res
    }

    fun max(a: Vec2, b: Float, res: Vec2 = Vec2()): Vec2 {
        res.x = func_common.max(a.x, b)
        res.y = func_common.max(a.y, b)
        return res
    }

    fun max(a: Vec2d, b: Double, res: Vec2d = Vec2d()): Vec2d {
        res.x = func_common.max(a.x, b)
        res.y = func_common.max(a.y, b)
        return res
    }

    fun max(a: Vec2, b: Vec2, res: Vec2 = Vec2()): Vec2 {
        res.x = func_common.max(a.x, b.x)
        res.y = func_common.max(a.y, b.y)
        return res
    }

    fun max(a: Vec2d, b: Vec2d, res: Vec2d = Vec2d()): Vec2d {
        res.x = func_common.max(a.x, b.x)
        res.y = func_common.max(a.y, b.y)
        return res
    }


    fun clamp(a: Vec2, min: Float, max: Float, res: Vec2 = Vec2()): Vec2 {
        res.x = func_common.clamp(a.x, min, max)
        res.y = func_common.clamp(a.y, min, max)
        return res
    }

    fun clamp(a: Vec2d, min: Double, max: Double, res: Vec2d = Vec2d()): Vec2d {
        res.x = func_common.clamp(a.x, min, max)
        res.y = func_common.clamp(a.y, min, max)
        return res
    }

    fun clamp(a: Vec2, min: Vec2, max: Vec2, res: Vec2 = Vec2()): Vec2 {
        res.x = func_common.clamp(a.x, min.x, max.x)
        res.y = func_common.clamp(a.y, min.y, max.y)
        return res
    }

    fun clamp(a: Vec2d, min: Vec2d, max: Vec2d, res: Vec2d = Vec2d()): Vec2d {
        res.x = func_common.clamp(a.x, min.x, max.x)
        res.y = func_common.clamp(a.y, min.y, max.y)
        return res
    }


    fun mix(a: Vec2, b: Float, interp: Float, res: Vec2 = Vec2()): Vec2 {
        res.x = func_common.mix(a.x, b, interp)
        res.y = func_common.mix(a.y, b, interp)
        return res
    }

    fun mix(a: Vec2d, b: Double, interp: Double, res: Vec2d = Vec2d()): Vec2d {
        res.x = func_common.mix(a.x, b, interp)
        res.y = func_common.mix(a.y, b, interp)
        return res
    }

    fun mix(a: Vec2, b: Vec2, interp: Boolean, res: Vec2 = Vec2()): Vec2 {
        res.x = func_common.mix(a.x, b.x, interp)
        res.y = func_common.mix(a.y, b.y, interp)
        return res
    }

    fun mix(a: Vec2d, b: Vec2d, interp: Boolean, res: Vec2d = Vec2d()): Vec2d {
        res.x = func_common.mix(a.x, b.x, interp)
        res.y = func_common.mix(a.y, b.y, interp)
        return res
    }

    fun mix(a: Vec2, b: Vec2, interp: Vec2, res: Vec2 = Vec2()): Vec2 {
        res.x = func_common.mix(a.x, b.x, interp.x)
        res.y = func_common.mix(a.y, b.y, interp.y)
        return res
    }

    fun mix(a: Vec2d, b: Vec2d, interp: Vec2d, res: Vec2d = Vec2d()): Vec2d {
        res.x = func_common.mix(a.x, b.x, interp.x)
        res.y = func_common.mix(a.y, b.y, interp.y)
        return res
    }

    fun mix(a: Vec2, b: Vec2, interp: Vec2bool, res: Vec2 = Vec2()): Vec2 {
        res.x = func_common.mix(a.x, b.x, interp.x)
        res.y = func_common.mix(a.y, b.y, interp.y)
        return res
    }

    fun mix(a: Vec2d, b: Vec2d, interp: Vec2bool, res: Vec2d = Vec2d()): Vec2d {
        res.x = func_common.mix(a.x, b.x, interp.x)
        res.y = func_common.mix(a.y, b.y, interp.y)
        return res
    }


    fun step(edge: Float, a: Vec2, res: Vec2 = Vec2()): Vec2 {
        res.x = func_common.step(edge, a.x)
        res.y = func_common.step(edge, a.y)
        return res
    }

    fun step(edge: Double, a: Vec2d, res: Vec2d = Vec2d()): Vec2d {
        res.x = func_common.step(edge, a.x)
        res.y = func_common.step(edge, a.y)
        return res
    }

    fun step(edge: Vec2, a: Vec2, res: Vec2 = Vec2()): Vec2 {
        res.x = func_common.step(edge.x, a.x)
        res.y = func_common.step(edge.y, a.y)
        return res
    }

    fun step(edge: Vec2d, a: Vec2d, res: Vec2d = Vec2d()): Vec2d {
        res.x = func_common.step(edge.x, a.x)
        res.y = func_common.step(edge.y, a.y)
        return res
    }


    fun smoothStep(edge0: Float, edge1: Float, a: Vec2, res: Vec2 = Vec2()): Vec2 {
        res.x = func_common.smoothStep(edge0, edge1, a.x)
        res.y = func_common.smoothStep(edge0, edge1, a.y)
        return res
    }

    fun smoothStep(edge0: Double, edge1: Double, a: Vec2d, res: Vec2d = Vec2d()): Vec2d {
        res.x = func_common.smoothStep(edge0, edge1, a.x)
        res.y = func_common.smoothStep(edge0, edge1, a.y)
        return res
    }

    fun smoothStep(edge0: Vec2, edge1: Vec2, a: Vec2, res: Vec2 = Vec2()): Vec2 {
        res.x = func_common.smoothStep(edge0.x, edge1.x, a.x)
        res.y = func_common.smoothStep(edge0.y, edge1.y, a.y)
        return res
    }

    fun smoothStep(edge0: Vec2d, edge1: Vec2d, a: Vec2d, res: Vec2d = Vec2d()): Vec2d {
        res.x = func_common.smoothStep(edge0.x, edge1.x, a.x)
        res.y = func_common.smoothStep(edge0.y, edge1.y, a.y)
        return res
    }


    fun isNan(a: Vec2, res: Vec2bool = Vec2bool()): Vec2bool {
        res.x = func_common.isNan(a.x)
        res.y = func_common.isNan(a.y)
        return res
    }

    fun isNan(a: Vec2d, res: Vec2bool = Vec2bool()): Vec2bool {
        res.x = func_common.isNan(a.x)
        res.y = func_common.isNan(a.y)
        return res
    }


    fun isInf(a: Vec2, res: Vec2bool = Vec2bool()): Vec2bool {
        res.x = func_common.isInf(a.x)
        res.y = func_common.isInf(a.y)
        return res
    }

    fun isInf(a: Vec2d, res: Vec2bool = Vec2bool()): Vec2bool {
        res.x = func_common.isInf(a.x)
        res.y = func_common.isInf(a.y)
        return res
    }


    fun floatBitsToInt(a: Vec2, res: Vec2i = Vec2i()): Vec2i {
        res.x = func_common.floatBitsToInt(a.x)
        res.y = func_common.floatBitsToInt(a.y)
        return res
    }


    fun floatBitsToUint(a: Vec2, res: Vec2ui = Vec2ui()): Vec2ui {
        res.x = func_common.floatBitsToUint(a.x)    // TODO directly .v?
        res.y = func_common.floatBitsToUint(a.y)
        return res
    }


    fun intBitsToFloat(a: Vec2i, res: Vec2 = Vec2()): Vec2 {
        res.x = func_common.intBitsToFloat(a.x)
        res.y = func_common.intBitsToFloat(a.y)
        return res
    }


    fun uintBitsToFloat(a: Vec2ui, res: Vec2 = Vec2()): Vec2 {
        res.x = func_common.uintBitsToFloat(a.x)
        res.y = func_common.uintBitsToFloat(a.y)
        return res
    }


    fun fma(a: Vec2, b: Vec2, c: Vec2, res: Vec2 = Vec2()): Vec2 {
        res.x = func_common.fma(a.x, b.x, c.x)
        res.y = func_common.fma(a.y, b.y, c.y)
        return res
    }

    fun fma(a: Vec2d, b: Vec2d, c: Vec2d, res: Vec2d = Vec2d()): Vec2d {
        res.x = func_common.fma(a.x, b.x, c.x)
        res.y = func_common.fma(a.y, b.y, c.y)
        return res
    }


    // TODO frexp, ldexp
}