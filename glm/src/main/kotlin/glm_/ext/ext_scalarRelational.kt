package glm_.ext

import kotlin.math.abs

interface ext_scalarRelational {

    fun equal(x: Int, y: Int, epsilon: Int) = abs(x - y) <= epsilon
    fun equal(x: Long, y: Long, epsilon: Long) = abs(x - y) <= epsilon
    fun equal(x: Float, y: Float, epsilon: Float) = abs(x - y) <= epsilon
    fun equal(x: Double, y: Double, epsilon: Double) = abs(x - y) <= epsilon

    fun notEqual(x: Int, y: Int, epsilon: Int) = abs(x - y) > epsilon
    fun notEqual(x: Long, y: Long, epsilon: Long) = abs(x - y) > epsilon
    fun notEqual(x: Float, y: Float, epsilon: Float) = abs(x - y) > epsilon
    fun notEqual(x: Double, y: Double, epsilon: Double) = abs(x - y) > epsilon
}