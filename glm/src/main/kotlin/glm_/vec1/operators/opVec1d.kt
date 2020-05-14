package glm_.vec1.operators

import glm_.d
import glm_.vec1.Vec1d
import glm_.vec1.Vec1d.Companion.div
import glm_.vec1.Vec1d.Companion.minus
import glm_.vec1.Vec1d.Companion.plus
import glm_.vec1.Vec1d.Companion.rem
import glm_.vec1.Vec1d.Companion.times

/**
 * Created by GBarbieri on 08.11.2016.
 */
interface opVec1d {

    fun plus(res: Vec1d, a: Vec1d, bX: Double): Vec1d {
        res.x = a.x + bX
        return res
    }

    fun minus(res: Vec1d, a: Vec1d, bX: Double): Vec1d {
        res.x = a.x - bX
        return res
    }

    fun minus(res: Vec1d, aX: Double, b: Vec1d): Vec1d {
        res.x = aX - b.x
        return res
    }

    fun times(res: Vec1d, a: Vec1d, bX: Double): Vec1d {
        res.x = a.x * bX
        return res
    }

    fun div(res: Vec1d, a: Vec1d, bX: Double): Vec1d {
        res.x = a.x / bX
        return res
    }

    fun div(res: Vec1d, aX: Double, b: Vec1d): Vec1d {
        res.x = aX / b.x
        return res
    }

    fun rem(res: Vec1d, a: Vec1d, bX: Double): Vec1d {
        res.x = a.x % bX
        return res
    }

    fun rem(res: Vec1d, aX: Double, b: Vec1d): Vec1d {
        res.x = aX % b.x
        return res
    }
}


// -- Specific binary arithmetic operators --

infix operator fun Double.plus(b: Vec1d) = plus(Vec1d(), b, this)
fun Double.plus(b: Vec1d, res: Vec1d) = plus(res, b, this)
infix fun Double.plusAssign(b: Vec1d) = plus(b, b, this)

infix operator fun Double.minus(b: Vec1d) = minus(Vec1d(), this, b)
fun Double.minus(b: Vec1d, res: Vec1d) = minus(res, b, this)
infix fun Double.minusAssign(b: Vec1d) = minus(b, this, b)

infix operator fun Double.times(b: Vec1d) = times(Vec1d(), b, this)
fun Double.times(b: Vec1d, res: Vec1d) = times(res, b, this)
infix fun Double.timesAssign(b: Vec1d) = times(b, b, this)

infix operator fun Double.div(b: Vec1d) = div(Vec1d(), this, b)
fun Double.div(b: Vec1d, res: Vec1d) = div(res, b, this)
infix fun Double.divAssign(b: Vec1d) = div(b, this, b)

infix operator fun Double.rem(b: Vec1d) = rem(Vec1d(), this, b)
fun Double.rem(b: Vec1d, res: Vec1d) = rem(res, b, this)
infix fun Double.remAssign(b: Vec1d) = rem(b, this, b)


// -- Generic binary arithmetic operators --

infix operator fun Number.plus(b: Vec1d) = plus(Vec1d(), b, this.d)
fun Number.plus(b: Vec1d, res: Vec1d) = plus(res, b, this.d)
infix fun Number.plusAssign(b: Vec1d) = plus(b, b, this.d)

infix operator fun Number.minus(b: Vec1d) = minus(Vec1d(), this.d, b)
fun Number.minus(b: Vec1d, res: Vec1d) = minus(res, b, this.d)
infix fun Number.minusAssign(b: Vec1d) = minus(b, this.d, b)

infix operator fun Number.times(b: Vec1d) = times(Vec1d(), b, this.d)
fun Number.times(b: Vec1d, res: Vec1d) = times(res, b, this.d)
infix fun Number.timesAssign(b: Vec1d) = times(b, b, this.d)

infix operator fun Number.div(b: Vec1d) = div(Vec1d(), this.d, b)
fun Number.div(b: Vec1d, res: Vec1d) = div(res, b, this.d)
infix fun Number.divAssign(b: Vec1d) = div(b, this.d, b)

infix operator fun Number.rem(b: Vec1d) = rem(Vec1d(), this.d, b)
fun Number.rem(b: Vec1d, res: Vec1d) = rem(res, b, this.d)
infix fun Number.remAssign(b: Vec1d) = rem(b, this.d, b)