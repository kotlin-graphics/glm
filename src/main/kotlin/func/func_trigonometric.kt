package func

import d
import f

/**
 * Created by GBarbieri on 12.12.2016.
 */

interface func_trigonometric {

    fun cos(angle: Double) = Math.cos(angle)
    fun cos(angle: Float) = Math.cos(angle.d).f

    fun sin(angle: Double) = Math.sin(angle)
    fun sin(angle: Float) = Math.sin(angle.d).f

    fun tan(angle: Double) = Math.tan(angle)
    fun tan(angle: Float) = Math.tan(angle.d).f


    fun acos(angle: Double) = Math.acos(angle)
    fun acos(angle: Float) = Math.acos(angle.d).f

    fun asin(angle: Double) = Math.asin(angle)
    fun asin(angle: Float) = Math.asin(angle.d).f

    fun atan(angle: Double) = Math.atan(angle)
    fun atan(angle: Float) = Math.atan(angle.d).f

    fun atan(y: Double, x: Double) = Math.atan2(y, x)
    fun atan(y: Float, x: Float) = Math.atan2(y.d, x.d).f
}