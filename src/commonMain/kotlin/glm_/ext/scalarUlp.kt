package glm_.ext

import glm_.*
import glm_.scalar.abs
import glm_.scalar.bitsToFloat
import kotlin.math.nextDown
import kotlin.math.nextUp

// this is ported from https://github.com/JetBrains/jdk8u_jdk/blob/94318f9185757cc33d2b8d527d36be26ac6b7582/src/share/classes/java/lang/Math.java


// https://randomascii.wordpress.com/2012/02/25/comparing-floating-point-numbers-2012-edition/
val Float.negative: Boolean
    get() = toRawBits() < 0
val Float.mantissa: Int
    get() {
        val i = toRawBits()
        return i and ((1 shl 23) - 1)
    }
//val Float.exponent: Int
//    get() {
//        val i = toRawBits()
//        return (i shr 23) and ((1 shl 8) - 1)
//    }

val Double.negative: Boolean
    get() = toRawBits() < 0
val Double.mantissa: Long
    get() {
        val i = toRawBits()
        return i and ((1 shl 52) - 1)
    }
val Double.exponent: Long
    get() {
        val i = toRawBits()
        return (i shr 52) and ((1 shl 11) - 1)
    }

//fun Float.equal(y: Float, maxULPs: Int): Boolean =
//    // Different signs means they do not match.
//    when {
//        negative != y.negative -> {
//            // Check for equality to make sure +0==-0
//            mantissa == y.mantissa && exponent == y.exponent
//        }
//        else -> {
//            // Find the difference in ULPs.
//            val diffULPs = (toRawBits() - y.toRawBits()).abs()
//            diffULPs <= maxULPs
//        }
//    }
//
//fun Double.equal(y: Double, maxULPs: Int): Boolean =
//    // Different signs means they do not match.
//    when {
//        negative != y.negative -> {
//            // Check for equality to make sure +0==-0
//            mantissa == y.mantissa && exponent == y.exponent
//        }
//        else -> {
//            // Find the difference in ULPs.
//            val diffULPs = (toRawBits() - y.toRawBits()).abs()
//            diffULPs <= maxULPs
//        }
//    }

/**
 * Returns the size of an ulp (units in the last place) of the argument.
 * @param d value whose ulp is to be returned
 * @return size of an ulp for the argument
 */
//val Float.ulp: Float
//    get() = when {
//        // If the argument is NaN, then the result is NaN.
//        isNaN() -> Float.NaN
//        // If the argument is positive or negative infinity, then the result is positive infinity.
//        isInfinite() -> Float.POSITIVE_INFINITY
//        // If the argument is positive or negative zero, then the result is Float.MIN_VALUE.
//        this == 0f -> Float.MIN_VALUE
//        // If the argument is Float.MAX_VALUE, then the result is equal to 2^971.
//        abs() == Float.MAX_VALUE -> glm.maxUlp.f
//        else -> nextAfter(Float.MAX_VALUE) - this
//    }

//infix fun Float.copySign(y: Float): Float = ((this.toRawBits() and 0x7fffffff) or (y.toRawBits() and 0x80000000u)).bitsToFloat()
//
//infix fun Float.isSameSign(y: Float): Boolean = copySign(y) == this
//
///**
// * Returns the next representable floating point number after the first argument in the direction of the second argument.
// *
// * @receiver starting value
// * @param direction value indicating which of the neighboring representable floating point number to return
// * @return The floating-point number next to {@code start} in the direction of {@direction}.
// */
//fun Float.nextAfter(direction: Float): Float = when {
//    // If either argument is a NaN, then NaN is returned.
//    isNaN() || direction.isNaN() -> Float.NaN
//    // If both arguments compare as equal the second argument is returned.
//    this == direction -> direction
//    else -> {
//        val absStart = abs()
//        val absDir = direction.abs()
//        val toZero = !isSameSign(direction) || absDir < absStart
//
//        if (toZero)
//            when {
//                // we are reducing the magnitude, going toward zero.
//                absStart == Float.MIN_VALUE -> 0f copySign this
//                absStart.isInfinite() -> Float.MAX_VALUE copySign this
//                else -> (absStart.toRawBits() - 1).bitsToFloat() copySign this
//            }
//        else
//            when {
//                // we are increasing the magnitude, toward +-Infinity
//                this == 0f -> Float.MIN_VALUE copySign direction
//                absStart == Float.MAX_VALUE -> Float.POSITIVE_INFINITY copySign this
//                else -> (absStart.toRawBits() + 1).bitsToFloat() copySign this
//            }
//    }
//}

/** Bitwise convert f to integer, mask out exponent bits, shift to the right and then subtract out float's bias adjust
 *  to get true exponent value */
//val Float.exponent: Int
//    get() = ((toRawBits() and Float.EXP_BIT_MASK) shr (Float.SIGNIFICAND_WIDTH - 1)) - Float.EXP_BIAS
//
///** Returns a floating-point power of two in the normal range. */
//val Int.powerOfTwo: Float
//    get() {
//        check(this >= Float.MIN_EXPONENT && this <= Float.MAX_EXPONENT)
//        return (((this + Float.EXP_BIAS) shl (Float.SIGNIFICAND_WIDTH - 1)) and Float.EXP_BIT_MASK).bitsToFloat()
//    }
//val Float.ulp: Float
//    get() = when (val exp = exponent) {
//        // NaN or infinity
//        Float.MAX_EXPONENT + 1 -> abs()
//        // zero or subnormal
//        Float.MIN_EXPONENT - 1 -> Float.MIN_VALUE
//        else -> {
//            check(exp <= Float.MAX_EXPONENT && exp >= Float.MIN_EXPONENT)
//
//            // ulp(x) is usually 2^(SIGNIFICAND_WIDTH-1)*(2^ilogb(x))
//            val exp = exp - (Float.SIGNIFICAND_WIDTH - 1)
//            if (exp >= Float.MIN_EXPONENT)
//                exp.powerOfTwo
//            else
//            // return a subnormal result; left shift integer
//            // representation of FloatConsts.MIN_VALUE appropriate
//            // number of positions
//                (1 shl (exp - (Float.MIN_EXPONENT - (Float.SIGNIFICAND_WIDTH - 1)))).bitsToFloat()
//        }
//    }

/**
 * Returns the floating-point number adjacent to the first argument in the direction of the second argument.
 * If both arguments compare as equal a value equivalent to the second argument is returned.
 *
 * Special cases:
 * - If either argument is a NaN, then NaN is returned.
 * - If both arguments are signed zeros, a value equivalent to [direction] is returned.
 * - If `this` is `Float.MIN_VALUE` and [direction] has a value such that the result should have a smaller magnitude,
 * then a zero with the same sign as `this` is returned.
 * - If `this` is infinite and [direction] has a value such that the result should have a smaller magnitude,
 * `Float.MAX_VALUE` with the same sign as `this` is returned.
 * - If `this` is equal to `Float.MAX_VALUE` and [direction] has a value such that the result should have
 *  a larger magnitude, an infinity with same sign as `this` is returned.
 *
 * @receiver starting floating-point value
 * @param direction value indicating which of `this`'s neighbors or `this` should be returned
 * @return The floating-point number adjacent to `this` in the direction of [direction]. */
infix fun Float.nextAfter(direction: Float) = when {
    /*
     * The cases:
     *
     * nextAfter(+infinity, 0)  == MAX_VALUE
     * nextAfter(+infinity, +infinity)  == +infinity
     * nextAfter(-infinity, 0)  == -MAX_VALUE
     * nextAfter(-infinity, -infinity)  == -infinity
     *
     * are naturally handled without any additional testing
     */

    // First check for NaN values
    isNaN() || direction.isNaN() ->
        // return a NaN derived from the input NaN(s)
        this + direction
    this == direction -> direction
    else -> {
        // start > direction or start < direction
        // Add +0.0 to get rid of a -0.0 (+0.0 + -0.0 => +0.0)
        // then bitwise convert start to integer.
        var transducer = (this + 0.0f).toRawBits()

        /*
         * IEEE 754 floating-point numbers are lexicographically ordered if treated as signed- magnitude integers.
         * Since Java's integers are two's complement, incrementing the two's complement representation of a logically
         * negative floating-point value *decrements* the signed-magnitude representation. Therefore, when the integer
         * representation of a floating-point values is less than zero, the adjustment to the representation is
         * in the opposite direction than would be expected at first.
         */
        if (direction > this)
        // Calculate next greater value
            transducer += if (transducer >= 0) 1 else -1
        else { // Calculate next lesser value
            check(direction < this)
            if (transducer > 0)
                --transducer
            else
                if (transducer < 0)
                    ++transducer
                /*
                 * transducer==0, the result is -MIN_VALUE
                 *
                 * The transition from zero (implicitly positive) to the smallest negative signed magnitude value
                 * must be done explicitly.
                 */
                else
                    transducer = Float.SIGN_BIT_MASK or 1
        }

        transducer.bitsToFloat()
    }
}

/**
 * Returns the floating-point value adjacent to `this` in the direction of positive infinity.
 * This method is semantically equivalent to `nextAfter(Float.POSITIVE_INFINITY)`; however, a `nextUp` implementation
 * may run faster than its equivalent `nextAfter` call.
 *
 * Special Cases:
 * - If the argument is NaN, the result is NaN.
 * - If the argument is positive infinity, the result is positive infinity.
 * - If the argument is zero, the result is `Float.MIN_VALUE`
 *
 * @receiver starting floating-point value
 * @return The adjacent floating-point value closer to positive infinity. */
//fun Float.nextUp(): Float = when {
//    isNaN() || this == Float.POSITIVE_INFINITY -> this
//    else -> {
//        val f = this + 0f
//        (toRawBits() + if (f >= 0f) +1 else -1).bitsToFloat()
//    }
//}
//
///**
// * Returns the floating-point value adjacent to `this` in the direction of negative infinity.
// * This method is semantically equivalent to `nextAfter(Float.NEGATIVE_INFINITY)`; however, a `nextDown` implementation
// * may run faster than its equivalent `nextAfter` call.
// *
// * Special Cases:
// * - If the argument is NaN, the result is NaN.
// * - If the argument is negative infinity, the result is negative infinity.
// * - If the argument is zero, the result is `-Float.MIN_VALUE`
// *
// * @receiver starting floating-point value
// * @return The adjacent floating-point value closer to negative infinity. */
//fun Float.nextDown(): Float = when {
//    isNaN() || this == Float.NEGATIVE_INFINITY -> this
//    this == 0f -> -Float.MIN_VALUE
//    else -> (toRawBits() + if (this > 0f) -1 else +1).bitsToFloat()
//}

/* Return the value(s) ULP distance after the input value(s). */
infix fun Float.nextUp(ulps: Int): Float {
    check(ulps >= 0)
    var temp = this
    for(i in 0 until ulps)
        temp = temp.nextUp()
    return temp
}

/* Return the value(s) ULP distance before the input value(s). */
infix fun Float.nextDown(ulps: Int): Float {
    check(ulps >= 0)
    var temp = this
    for(i in 0 until ulps)
        temp = temp.nextDown()
    return temp
}

/* Return the value(s) ULP distance after the input value(s). */
infix fun Double.nextUp(ulps: Int): Double {
    check(ulps >= 0)
    var temp = this
    for(i in 0 until ulps)
        temp = nextUp()
    return temp
}

/* Return the value(s) ULP distance before the input value(s). */
infix fun Double.nextDown(ulps: Int): Double {
    check(ulps >= 0)
    var temp = this
    for(i in 0 until ulps)
        temp = nextDown()
    return temp
}

/** Return the distance in the number of ULP between 2 single-precision floating-point scalars. */
infix fun Float.distance(b: Float): Int = (toRawBits() - b.toRawBits()).abs()
/** Return the distance in the number of ULP between 2 single-precision floating-point scalars. */
infix fun Double.distance(b: Double): Long = (toRawBits() - b.toRawBits()).abs()