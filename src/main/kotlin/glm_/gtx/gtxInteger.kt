package glm_.gtx

import glm_.compareUnsigned
import glm_.divideUnsigned
import glm_.glm
import glm_.uint

interface gtxInteger {

    /** Returns x raised to the y power. */
    fun pow(x: Int, y: uint) = when (y) {
        0 -> if (x >= 0) 1 else -1
        else -> {
            var result = x
            for (i in 1 until y) result *= x
            result
        }
    }

    /** Returns the positive square root of x.
     *  sqrt: From Christopher J. Musial, An integer square root, Graphics Gems, 1990, page 387 */
    fun sqrt(x: Int) = when {
        x <= 1 -> x
        else -> {
            var nextTrial = x shr 1
            var currentAnswer: Int
            do {
                currentAnswer = nextTrial
                nextTrial = (nextTrial + x / nextTrial) shr 1
            } while (nextTrial < currentAnswer)
            currentAnswer
        }
    }

    /** Returns the floor log2 of x.
     *  @param x_: Unsigned Int*/
    fun floorLog2(x_: uint): uint {
        var x = x_
        x = x or (x ushr 1)
        x = x or (x ushr 2)
        x = x or (x ushr 4)
        x = x or (x ushr 8)
        x = x or (x ushr 16)

        return glm.detail.ones32(x) ushr 1
    }

    /** Modulus. Returns x - y * floor(x / y) for each component in x using the floating point value y. */
    fun mod(x: Int, y: Int): Int = ((x % y) + y) % y

    /** Return the factorial value of a number (!12 max, integer only) */
    /** factorial (!12 max, integer only)   */
    fun factorial(x: Int): Int {
        var temp = x
        var result = 1
        while (temp > 1) {
            result *= temp
            --temp
        }
        return result
    }

    /** Returns x raised to the y power. */
    fun powU(x: uint, y: uint) = when (y) {
        0 -> 1
        else -> {
            var result = x
            var i = 1
            while (i.compareUnsigned(y) < 0) {
                result *= x
                ++i
            }
            result
        }
    }

    /** Returns the positive square root of x. */
    fun sqrtU(x: uint) = when {
        x <= 1 -> x
        else -> {
            var nextTrial = x ushr 1
            var currentAnswer: Int
            do {
                currentAnswer = nextTrial
                nextTrial = (nextTrial + x / nextTrial) ushr 1
            } while (nextTrial < currentAnswer)
            currentAnswer
        }
    }

    /** Modulus. Returns x - y * floor(x / y) for each component in x using the floating point value y. */
    fun modU(x: uint, y: uint) = x - y * (x divideUnsigned y)

    /** Returns the number of leading zeros. */
    fun nlz(x: uint) = java.lang.Integer.numberOfLeadingZeros(x)
}

// Henry Gordon Dietz: http://aggregate.org/MAGIC/
interface detail_gtxInteger {
    fun ones32(x_: uint): uint {
        /* 32-bit recursive reduction using SWAR...
        but first step is mapping 2-bit values into sum of 2 1-bit values in sneaky way        */
        var x = x_
        x -= (x ushr 1) and 0x55555555
        x = ((x ushr 2) and 0x33333333) + (x and 0x33333333)
        x = ((x ushr 4) + x) and 0x0f0f0f0f
        x += x ushr 8
        x += x ushr 16
        return x and 0x0000003f
    }
}