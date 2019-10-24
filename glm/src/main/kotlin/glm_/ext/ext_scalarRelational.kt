package glm_.ext

import glm_.glm

interface ext_scalarRelational {

    fun equal(x: Float, y: Float, epsilon: Float) = glm.abs(x - y) < epsilon
    fun equal(x: Byte, y: Byte, epsilon: Byte) = glm.abs(x - y) < epsilon
    fun equal(x: Double, y: Double, epsilon: Double) = glm.abs(x - y) < epsilon
    fun equal(x: Int, y: Int, epsilon: Int) = glm.abs(x - y) < epsilon
    fun equal(x: Long, y: Long, epsilon: Long) = glm.abs(x - y) < epsilon
    fun equal(x: Short, y: Short, epsilon: Short) = glm.abs(x - y) < epsilon

    fun notEqual(x: Float, y: Float, epsilon: Float) = glm.abs(x - y) >= epsilon
    fun notEqual(x: Byte, y: Byte, epsilon: Byte) = glm.abs(x - y) >= epsilon
    fun notEqual(x: Double, y: Double, epsilon: Double) = glm.abs(x - y) >= epsilon
    fun notEqual(x: Int, y: Int, epsilon: Int) = glm.abs(x - y) >= epsilon
    fun notEqual(x: Long, y: Long, epsilon: Long) = glm.abs(x - y) >= epsilon
    fun notEqual(x: Short, y: Short, epsilon: Short) = glm.abs(x - y) >= epsilon
}

fun Float.equal(y: Float, epsilon: Float) = glm.abs(minus(y)) < epsilon
fun Byte.equal(y: Byte, epsilon: Byte) = glm.abs(minus(y)) < epsilon
fun Double.equal(y: Double, epsilon: Double) = glm.abs(minus(y)) < epsilon
fun Int.equal(y: Int, epsilon: Int) = glm.abs(minus(y)) < epsilon
fun Long.equal(y: Long, epsilon: Long) = glm.abs(minus(y)) < epsilon
fun Short.equal(y: Short, epsilon: Short) = glm.abs(minus(y)) < epsilon

fun Float.notEqual(y: Float, epsilon: Float) = glm.abs(minus(y)) >= epsilon
fun Byte.notEqual(y: Byte, epsilon: Byte) = glm.abs(minus(y)) >= epsilon
fun Double.notEqual(y: Double, epsilon: Double) = glm.abs(minus(y)) >= epsilon
fun Int.notEqual(y: Int, epsilon: Int) = glm.abs(minus(y)) >= epsilon
fun Long.notEqual(y: Long, epsilon: Long) = glm.abs(minus(y)) >= epsilon
fun Short.notEqual(y: Short, epsilon: Short) = glm.abs(minus(y)) >= epsilon