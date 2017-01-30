package main.func.common

import vec._3.*
import vec.bool.Vec3bool
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


/**
 * Created by GBarbieri on 11.11.2016.
 */
interface func_vector3_common {


    fun abs(a: Vec3, res: Vec3 = Vec3()): Vec3 {
        res.x = func_common.abs(a.x)
        res.y = func_common.abs(a.y)
        res.z = func_common.abs(a.z)
        return res
    }

    fun abs(a: Vec3b, res: Vec3b = Vec3b()): Vec3b {
        res.x = func_common.abs(a.x)
        res.y = func_common.abs(a.y)
        res.z = func_common.abs(a.z)
        return res
    }

    fun abs(a: Vec3d, res: Vec3d = Vec3d()): Vec3d {
        res.x = func_common.abs(a.x)
        res.y = func_common.abs(a.y)
        res.z = func_common.abs(a.z)
        return res
    }

    fun abs(a: Vec3i, res: Vec3i = Vec3i()): Vec3i {
        res.x = func_common.abs(a.x)
        res.y = func_common.abs(a.y)
        res.z = func_common.abs(a.z)
        return res
    }

    fun abs(a: Vec3l, res: Vec3l = Vec3l()): Vec3l {
        res.x = func_common.abs(a.x)
        res.y = func_common.abs(a.y)
        res.z = func_common.abs(a.z)
        return res
    }

    fun abs(a: Vec3s, res: Vec3s = Vec3s()): Vec3s {
        res.x = func_common.abs(a.x)
        res.y = func_common.abs(a.y)
        res.z = func_common.abs(a.z)
        return res
    }


    fun sign(a: Vec3, res: Vec3 = Vec3()): Vec3 {
        res.x = func_common.sign(a.x)
        res.y = func_common.sign(a.y)
        res.z = func_common.sign(a.z)
        return res
    }

    fun sign(a: Vec3b, res: Vec3b = Vec3b()): Vec3b {
        res.x = func_common.sign(a.x)
        res.y = func_common.sign(a.y)
        res.z = func_common.sign(a.z)
        return res
    }

    fun sign(a: Vec3d, res: Vec3d = Vec3d()): Vec3d {
        res.x = func_common.sign(a.x)
        res.y = func_common.sign(a.y)
        res.z = func_common.sign(a.z)
        return res
    }

    fun sign(a: Vec3i, res: Vec3i = Vec3i()): Vec3i {
        res.x = func_common.sign(a.x)
        res.y = func_common.sign(a.y)
        res.z = func_common.sign(a.z)
        return res
    }

    fun sign(a: Vec3l, res: Vec3l = Vec3l()): Vec3l {
        res.x = func_common.sign(a.x)
        res.y = func_common.sign(a.y)
        res.z = func_common.sign(a.z)
        return res
    }

    fun sign(a: Vec3s, res: Vec3s = Vec3s()): Vec3s {
        res.x = func_common.sign(a.x)
        res.y = func_common.sign(a.y)
        res.z = func_common.sign(a.z)
        return res
    }


    fun floor(a: Vec3, res: Vec3 = Vec3()): Vec3 {
        res.x = func_common.floor(a.x)
        res.y = func_common.floor(a.y)
        res.z = func_common.floor(a.z)
        return res
    }

    fun floor(a: Vec3d, res: Vec3d = Vec3d()): Vec3d {
        res.x = func_common.floor(a.x)
        res.y = func_common.floor(a.y)
        res.z = func_common.floor(a.z)
        return res
    }


    fun trunc(a: Vec3, res: Vec3 = Vec3()): Vec3 {
        res.x = func_common.trunc(a.x)
        res.y = func_common.trunc(a.y)
        res.z = func_common.trunc(a.z)
        return res
    }

    fun trunc(a: Vec3d, res: Vec3d = Vec3d()): Vec3d {
        res.x = func_common.trunc(a.x)
        res.y = func_common.trunc(a.y)
        res.z = func_common.trunc(a.z)
        return res
    }


    fun round(a: Vec3, res: Vec3 = Vec3()): Vec3 {
        res.x = func_common.round(a.x)
        res.y = func_common.round(a.y)
        res.z = func_common.round(a.z)
        return res
    }

    fun round(a: Vec3d, res: Vec3d = Vec3d()): Vec3d {
        res.x = func_common.round(a.x)
        res.y = func_common.round(a.y)
        res.z = func_common.round(a.z)
        return res
    }


    // TODO roundEven


    fun ceil(a: Vec3, res: Vec3 = Vec3()): Vec3 {
        res.x = func_common.ceil(a.x)
        res.y = func_common.ceil(a.y)
        res.z = func_common.ceil(a.z)
        return res
    }

    fun ceil(a: Vec3d, res: Vec3d = Vec3d()): Vec3d {
        res.x = func_common.ceil(a.x)
        res.y = func_common.ceil(a.y)
        res.z = func_common.ceil(a.z)
        return res
    }


    fun fract(a: Vec3, res: Vec3 = Vec3()): Vec3 {
        res.x = func_common.fract(a.x)
        res.y = func_common.fract(a.y)
        res.z = func_common.fract(a.z)
        return res
    }

    fun fract(a: Vec3d, res: Vec3d = Vec3d()): Vec3d {
        res.x = func_common.fract(a.x)
        res.y = func_common.fract(a.y)
        res.z = func_common.fract(a.z)
        return res
    }


    fun mod(a: Vec3, b: Float, res: Vec3 = Vec3()): Vec3 {
        res.x = func_common.mod(a.x, b)
        res.y = func_common.mod(a.y, b)
        res.z = func_common.mod(a.z, b)
        return res
    }

    fun mod(a: Vec3d, b: Double, res: Vec3d = Vec3d()): Vec3d {
        res.x = func_common.mod(a.x, b)
        res.y = func_common.mod(a.y, b)
        res.z = func_common.mod(a.z, b)
        return res
    }

    fun mod(a: Vec3, b: Vec3, res: Vec3 = Vec3()): Vec3 {
        res.x = func_common.mod(a.x, b.x)
        res.y = func_common.mod(a.y, b.y)
        res.z = func_common.mod(a.z, b.z)
        return res
    }

    fun mod(a: Vec3d, b: Vec3d, res: Vec3d = Vec3d()): Vec3d {
        res.x = func_common.mod(a.x, b.x)
        res.y = func_common.mod(a.y, b.y)
        res.z = func_common.mod(a.z, b.z)
        return res
    }


    // TODO modf


    fun min(a: Vec3, b: Float, res: Vec3 = Vec3()): Vec3 {
        res.x = func_common.min(a.x, b)
        res.y = func_common.min(a.y, b)
        res.z = func_common.min(a.z, b)
        return res
    }

    fun min(a: Vec3d, b: Double, res: Vec3d = Vec3d()): Vec3d {
        res.x = func_common.min(a.x, b)
        res.y = func_common.min(a.y, b)
        res.z = func_common.min(a.z, b)
        return res
    }

    fun min(a: Vec3, b: Vec3, res: Vec3 = Vec3()): Vec3 {
        res.x = func_common.min(a.x, b.x)
        res.y = func_common.min(a.y, b.y)
        res.z = func_common.min(a.z, b.z)
        return res
    }

    fun min(a: Vec3d, b: Vec3d, res: Vec3d = Vec3d()): Vec3d {
        res.x = func_common.min(a.x, b.x)
        res.y = func_common.min(a.y, b.y)
        res.z = func_common.min(a.z, b.z)
        return res
    }

    fun max(a: Vec3, b: Float, res: Vec3 = Vec3()): Vec3 {
        res.x = func_common.max(a.x, b)
        res.y = func_common.max(a.y, b)
        res.z = func_common.max(a.z, b)
        return res
    }

    fun max(a: Vec3d, b: Double, res: Vec3d = Vec3d()): Vec3d {
        res.x = func_common.max(a.x, b)
        res.y = func_common.max(a.y, b)
        res.z = func_common.max(a.z, b)
        return res
    }

    fun max(a: Vec3, b: Vec3, res: Vec3 = Vec3()): Vec3 {
        res.x = func_common.max(a.x, b.x)
        res.y = func_common.max(a.y, b.y)
        res.z = func_common.max(a.z, b.z)
        return res
    }

    fun max(a: Vec3d, b: Vec3d, res: Vec3d = Vec3d()): Vec3d {
        res.x = func_common.max(a.x, b.x)
        res.y = func_common.max(a.y, b.y)
        res.z = func_common.max(a.z, b.z)
        return res
    }


    fun clamp(a: Vec3, min: Float, max: Float, res: Vec3 = Vec3()): Vec3 {
        res.x = func_common.clamp(a.x, min, max)
        res.y = func_common.clamp(a.y, min, max)
        res.z = func_common.clamp(a.z, min, max)
        return res
    }

    fun clamp(a: Vec3d, min: Double, max: Double, res: Vec3d = Vec3d()): Vec3d {
        res.x = func_common.clamp(a.x, min, max)
        res.y = func_common.clamp(a.y, min, max)
        res.z = func_common.clamp(a.z, min, max)
        return res
    }

    fun clamp(a: Vec3, min: Vec3, max: Vec3, res: Vec3 = Vec3()): Vec3 {
        res.x = func_common.clamp(a.x, min.x, max.x)
        res.y = func_common.clamp(a.y, min.y, max.y)
        res.z = func_common.clamp(a.z, min.z, max.z)
        return res
    }

    fun clamp(a: Vec3d, min: Vec3d, max: Vec3d, res: Vec3d = Vec3d()): Vec3d {
        res.x = func_common.clamp(a.x, min.x, max.x)
        res.y = func_common.clamp(a.y, min.y, max.y)
        res.z = func_common.clamp(a.z, min.z, max.z)
        return res
    }


    fun mix(a: Vec3, b: Float, interp: Float, res: Vec3 = Vec3()): Vec3 {
        res.x = func_common.mix(a.x, b, interp)
        res.y = func_common.mix(a.y, b, interp)
        res.z = func_common.mix(a.z, b, interp)
        return res
    }

    fun mix(a: Vec3d, b: Double, interp: Double, res: Vec3d = Vec3d()): Vec3d {
        res.x = func_common.mix(a.x, b, interp)
        res.y = func_common.mix(a.y, b, interp)
        res.z = func_common.mix(a.z, b, interp)
        return res
    }

    fun mix(a: Vec3, b: Vec3, interp: Boolean, res: Vec3 = Vec3()): Vec3 {
        res.x = func_common.mix(a.x, b.x, interp)
        res.y = func_common.mix(a.y, b.y, interp)
        res.z = func_common.mix(a.z, b.z, interp)
        return res
    }

    fun mix(a: Vec3d, b: Vec3d, interp: Boolean, res: Vec3d = Vec3d()): Vec3d {
        res.x = func_common.mix(a.x, b.x, interp)
        res.y = func_common.mix(a.y, b.y, interp)
        res.z = func_common.mix(a.z, b.z, interp)
        return res
    }

    fun mix(a: Vec3, b: Vec3, interp: Vec3, res: Vec3 = Vec3()): Vec3 {
        res.x = func_common.mix(a.x, b.x, interp.x)
        res.y = func_common.mix(a.y, b.y, interp.y)
        res.z = func_common.mix(a.z, b.z, interp.z)
        return res
    }

    fun mix(a: Vec3d, b: Vec3d, interp: Vec3d, res: Vec3d = Vec3d()): Vec3d {
        res.x = func_common.mix(a.x, b.x, interp.x)
        res.y = func_common.mix(a.y, b.y, interp.y)
        res.z = func_common.mix(a.z, b.z, interp.z)
        return res
    }

    fun mix(a: Vec3, b: Vec3, interp: Vec3bool, res: Vec3 = Vec3()): Vec3 {
        res.x = func_common.mix(a.x, b.x, interp.x)
        res.y = func_common.mix(a.y, b.y, interp.y)
        res.z = func_common.mix(a.z, b.z, interp.z)
        return res
    }

    fun mix(a: Vec3d, b: Vec3d, interp: Vec3bool, res: Vec3d = Vec3d()): Vec3d {
        res.x = func_common.mix(a.x, b.x, interp.x)
        res.y = func_common.mix(a.y, b.y, interp.y)
        res.z = func_common.mix(a.z, b.z, interp.z)
        return res
    }


    fun step(edge: Float, a: Vec3, res: Vec3 = Vec3()): Vec3 {
        res.x = func_common.step(edge, a.x)
        res.y = func_common.step(edge, a.y)
        res.z = func_common.step(edge, a.z)
        return res
    }

    fun step(edge: Double, a: Vec3d, res: Vec3d = Vec3d()): Vec3d {
        res.x = func_common.step(edge, a.x)
        res.y = func_common.step(edge, a.y)
        res.z = func_common.step(edge, a.z)
        return res
    }

    fun step(edge: Vec3, a: Vec3, res: Vec3 = Vec3()): Vec3 {
        res.x = func_common.step(edge.x, a.x)
        res.y = func_common.step(edge.y, a.y)
        res.z = func_common.step(edge.z, a.z)
        return res
    }

    fun step(edge: Vec3d, a: Vec3d, res: Vec3d = Vec3d()): Vec3d {
        res.x = func_common.step(edge.x, a.x)
        res.y = func_common.step(edge.y, a.y)
        res.z = func_common.step(edge.z, a.z)
        return res
    }


    fun smoothStep(edge0: Float, edge1: Float, a: Vec3, res: Vec3 = Vec3()): Vec3 {
        res.x = func_common.smoothStep(edge0, edge1, a.x)
        res.y = func_common.smoothStep(edge0, edge1, a.y)
        res.z = func_common.smoothStep(edge0, edge1, a.z)
        return res
    }

    fun smoothStep(edge0: Double, edge1: Double, a: Vec3d, res: Vec3d = Vec3d()): Vec3d {
        res.x = func_common.smoothStep(edge0, edge1, a.x)
        res.y = func_common.smoothStep(edge0, edge1, a.y)
        res.z = func_common.smoothStep(edge0, edge1, a.z)
        return res
    }

    fun smoothStep(edge0: Vec3, edge1: Vec3, a: Vec3, res: Vec3 = Vec3()): Vec3 {
        res.x = func_common.smoothStep(edge0.x, edge1.x, a.x)
        res.y = func_common.smoothStep(edge0.y, edge1.y, a.y)
        res.z = func_common.smoothStep(edge0.z, edge1.z, a.z)
        return res
    }

    fun smoothStep(edge0: Vec3d, edge1: Vec3d, a: Vec3d, res: Vec3d = Vec3d()): Vec3d {
        res.x = func_common.smoothStep(edge0.x, edge1.x, a.x)
        res.y = func_common.smoothStep(edge0.y, edge1.y, a.y)
        res.z = func_common.smoothStep(edge0.z, edge1.z, a.z)
        return res
    }


    fun isNan(a: Vec3, res: Vec3bool = Vec3bool()): Vec3bool {
        res.x = func_common.isNan(a.x)
        res.y = func_common.isNan(a.y)
        res.z = func_common.isNan(a.z)
        return res
    }

    fun isNan(a: Vec3d, res: Vec3bool = Vec3bool()): Vec3bool {
        res.x = func_common.isNan(a.x)
        res.y = func_common.isNan(a.y)
        res.z = func_common.isNan(a.z)
        return res
    }


    fun isInf(a: Vec3, res: Vec3bool = Vec3bool()): Vec3bool {
        res.x = func_common.isInf(a.x)
        res.y = func_common.isInf(a.y)
        res.z = func_common.isInf(a.z)
        return res
    }

    fun isInf(a: Vec3d, res: Vec3bool = Vec3bool()): Vec3bool {
        res.x = func_common.isInf(a.x)
        res.y = func_common.isInf(a.y)
        res.z = func_common.isInf(a.z)
        return res
    }


    fun floatBitsToInt(a: Vec3, res: Vec3i = Vec3i()): Vec3i {
        res.x = func_common.floatBitsToInt(a.x)
        res.y = func_common.floatBitsToInt(a.y)
        res.z = func_common.floatBitsToInt(a.z)
        return res
    }


    fun floatBitsToUint(a: Vec3, res: Vec3ui = Vec3ui()): Vec3ui {
        res.x = func_common.floatBitsToUint(a.x)    // TODO directly .v?
        res.y = func_common.floatBitsToUint(a.y)
        res.z = func_common.floatBitsToUint(a.z)
        return res
    }


    fun intBitsToFloat(a: Vec3i, res: Vec3 = Vec3()): Vec3 {
        res.x = func_common.intBitsToFloat(a.x)
        res.y = func_common.intBitsToFloat(a.y)
        res.z = func_common.intBitsToFloat(a.z)
        return res
    }


    fun uintBitsToFloat(a: Vec3ui, res: Vec3 = Vec3()): Vec3 {
        res.x = func_common.uintBitsToFloat(a.x)
        res.y = func_common.uintBitsToFloat(a.y)
        res.z = func_common.uintBitsToFloat(a.z)
        return res
    }


    fun fma(a: Vec3, b: Vec3, c: Vec3, res: Vec3 = Vec3()): Vec3 {
        res.x = func_common.fma(a.x, b.x, c.x)
        res.y = func_common.fma(a.y, b.y, c.y)
        res.z = func_common.fma(a.z, b.z, c.z)
        return res
    }

    fun fma(a: Vec3d, b: Vec3d, c: Vec3d, res: Vec3d = Vec3d()): Vec3d {
        res.x = func_common.fma(a.x, b.x, c.x)
        res.y = func_common.fma(a.y, b.y, c.y)
        res.z = func_common.fma(a.z, b.z, c.z)
        return res
    }


    // TODO frexp, ldexp
}