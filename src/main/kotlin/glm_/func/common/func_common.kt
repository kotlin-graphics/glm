package glm_.func.common

import glm_.*
import glm_.glm.abs
import glm_.glm.ceil
import glm_.glm.clamp
import glm_.glm.floatBitsToInt
import glm_.glm.floatBitsToUint
import glm_.glm.floor
import glm_.glm.fma
import glm_.glm.fract
import glm_.glm.intBitsToFloat
import glm_.glm.isInf
import glm_.glm.isNan
import glm_.glm.max
import glm_.glm.min
import glm_.glm.mix
import glm_.glm.sign
import glm_.glm.smoothStep
import glm_.glm.step
import glm_.glm.trunc
import glm_.glm.uintBitsToFloat
import unsigned.Uint


/**
 * Created by elect on 11/11/16.
 */

interface func_common {

    fun abs(a: Float) = Math.abs(a)
    fun abs(a: Double) = Math.abs(a)
    fun abs(a: Byte) = Math.abs(a.i).b
    fun abs(a: Int) = Math.abs(a)
    fun abs(a: Long) = Math.abs(a)
    fun abs(a: Short) = Math.abs(a.i).s


    fun sign(a: Float) = Math.signum(a)
    fun sign(a: Double) = Math.signum(a)
    fun sign(a: Byte) = Math.signum(a.f).b
    fun sign(a: Int) = Math.signum(a.f).i
    fun sign(a: Long) = Math.signum(a.d).L
    fun sign(a: Short) = Math.signum(a.f).s


    fun floor(a: Float) = Math.floor(a.d).f
    fun floor(a: Double) = Math.floor(a)


    fun trunc(a: Float) = if (a < 0) -floor(-a) else floor(a)
    fun trunc(a: Double) = if (a < 0) -floor(-a) else floor(a)


    fun round(a: Float) = if (a < 0) -floor(-a) else floor(a)
    fun round(a: Double) = if (a < 0) -floor(-a) else floor(a)


    // TODO roundEven


    fun ceil(a: Float) = Math.ceil(a.d).f
    fun ceil(a: Double) = Math.ceil(a)


    fun fract(a: Float) = a - floor(a)
    fun fract(a: Double) = a - floor(a)


    fun mod(a: Float, b: Float) = a % b
    fun mod(a: Double, b: Double) = a % b


    // TODO modf


    fun min(a: Float, b: Float) = Math.min(a, b)
    fun min(a: Double, b: Double) = Math.min(a, b)
    fun min(a: Byte, b: Byte) = Math.min(a.i, b.i).b
    fun min(a: Int, b: Int) = Math.min(a.i, b.i)
    fun min(a: Long, b: Long) = Math.min(a, b)
    fun min(a: Short, b: Short) = Math.min(a.i, b.i).s

    fun max(a: Float, b: Float) = Math.max(a, b)
    fun max(a: Double, b: Double) = Math.max(a, b)
    fun max(a: Byte, b: Byte) = Math.max(a.i, b.i).b
    fun max(a: Int, b: Int) = Math.max(a.i, b.i)
    fun max(a: Long, b: Long) = Math.max(a, b)
    fun max(a: Short, b: Short) = Math.max(a.i, b.i).s


    fun clamp(a: Float, min: Float, max: Float) = min(max(a, min), max)
    fun clamp(a: Double, min: Double, max: Double) = min(max(a, min), max)
    fun clamp(a: Byte, min: Byte, max: Byte) = min(max(a, min), max)
    fun clamp(a: Int, min: Int, max: Int) = min(max(a, min), max)
    fun clamp(a: Long, min: Long, max: Long) = min(max(a, min), max)
    fun clamp(a: Short, min: Short, max: Short) = min(max(a, min), max)


    fun mix(a: Float, b: Float, interp: Float) = a + interp * (b - a)
    fun mix(a: Double, b: Double, interp: Double) = a + interp * (b - a)

    fun mix(a: Float, b: Float, interp: Boolean) = if (interp) a else b     // TODO invert
    fun mix(a: Double, b: Double, interp: Boolean) = if (interp) a else b


    fun step(edge: Float, a: Float) = mix(1f, 0f, a < edge)

    fun step(edge: Double, a: Double) = mix(1.0, 0.0, a < edge)

    fun smoothStep(edge0: Float, edge1: Float, a: Float): Float {
        val tmp = clamp((a - edge0) / (edge1 - edge0), 0f, 1f)
        return tmp * tmp * (3 - 2 * tmp)
    }

    fun smoothStep(edge0: Double, edge1: Double, a: Double): Double {
        val tmp = clamp((a - edge0) / (edge1 - edge0), 0.0, 1.0)
        return tmp * tmp * (3 - 2 * tmp)
    }


    fun isNan(a: Float) = java.lang.Float.isNaN(a)
    fun isNan(a: Double) = java.lang.Double.isNaN(a)

    fun isInf(a: Float) = java.lang.Float.isInfinite(a)
    fun isInf(a: Double) = java.lang.Double.isInfinite(a)


    fun floatBitsToInt(a: Float) = java.lang.Float.floatToIntBits(a)

    fun floatBitsToUint(a: Float) = Uint(java.lang.Float.floatToIntBits(a))

    fun intBitsToFloat(a: Int) = java.lang.Float.intBitsToFloat(a)

    fun uintBitsToFloat(a: Uint) = java.lang.Float.intBitsToFloat(a.v)


    fun fma(a: Float, b: Float, c: Float) = a * b + c
    fun fma(a: Double, b: Double, c: Double) = a * b + c


    // TODO frexp, ldexp
}


fun Float.abs() = abs(this)
fun Double.abs() = abs(this)
fun Byte.abs() = abs(this)
fun Int.abs() = abs(this)
fun Long.abs() = abs(this)
fun Short.abs() = abs(this)


fun Float.sign() = sign(this)
fun Double.sign() = sign(this)
fun Byte.sign() = sign(this)
fun Int.sign() = sign(this)
fun Long.sign() = sign(this)
fun Short.sign() = sign(this)


fun Float.floor() = floor(this)
fun Double.floor() = floor(this)


fun Float.trunc() = trunc(this)
fun Double.trunc() = trunc(this)


fun Float.ceil() = ceil(this)
fun Double.ceil() = ceil(this)


fun Float.fract() = fract(this)
fun Double.fract() = fract(this)


infix fun Float.min(b: Float) = min(this, b)
infix fun Double.min(b: Double) = min(this, b)
infix fun Byte.min(b: Byte) = min(this, b)
infix fun Int.min(b: Int) = min(this, b)
infix fun Long.min(b: Long) = min(this, b)
infix fun Short.min(b: Short) = min(this, b)

infix fun Float.max(b: Float) = max(this, b)
infix fun Double.max(b: Double) = max(this, b)
infix fun Byte.max(b: Byte) = max(this, b)
infix fun Int.max(b: Int) = max(this, b)
infix fun Long.max(b: Long) = max(this, b)
infix fun Short.max(b: Short) = max(this, b)


fun Float.clamp(min: Float, max: Float) = clamp(this, min, max)
fun Double.clamp(min: Double, max: Double) = clamp(this, min, max)
fun Byte.clamp(min: Byte, max: Byte) = clamp(this, min, max)
fun Int.clamp(min: Int, max: Int) = clamp(this, min, max)
fun Long.clamp(min: Long, max: Long) = clamp(this, min, max)
fun Short.clamp(min: Short, max: Short) = clamp(this, min, max)


fun Float.mix(b: Float, interp: Float) = mix(this, b, interp)
fun Double.mix(b: Double, interp: Double) = mix(this, b, interp)

fun Float.mix(b: Float, interp: Boolean) = mix(this, b, interp)
fun Double.mix(b: Double, interp: Boolean) = mix(this, b, interp)


infix fun Float.step(edge: Float) = step(edge, this)
infix fun Double.step(edge: Double) = step(edge, this)

fun Float.smoothstep(edge0: Float, edge1: Float) = smoothStep(edge0, edge1, this)
fun Double.smoothstep(edge0: Double, edge1: Double) = smoothStep(edge0, edge1, this)


fun Float.isnan() = isNan(this)
fun Double.isnan() = isNan(this)

fun Float.isinf() = isInf(this)
fun Double.isinf() = isInf(this)


fun Float.floatBitsToInt() = floatBitsToInt(this)

fun Float.floatBitsToUint() = floatBitsToUint(this)

fun Int.intBitsToFloat() = intBitsToFloat(this)

fun Uint.uintBitsToFloat() = uintBitsToFloat(this)


fun Float.fma(b: Float, c: Float) = fma(this, b, c)
fun Double.fma(b: Double, c: Double) = fma(this, b, c)