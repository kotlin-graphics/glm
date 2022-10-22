package glm_

// this is ported from https://github.com/JetBrains/jdk8u_jdk/blob/94318f9185757cc33d2b8d527d36be26ac6b7582/src/share/classes/sun/misc/FloatConsts.java

/** A constant holding the smallest positive normal value of type `Float`, `2 pow -126`.
 *  It is equal to the value returned by `0x00800000.bitsToFloat()`. */
val Float.Companion.MIN_NORMAL: Float
    get() = 1.17549435E-38f

/** The number of logical bits in the significand of a `Float` number, including the implicit bit. */
val Float.Companion.SIGNIFICAND_WIDTH: Int
    get() = 24

/** Maximum exponent a finite `Float` number may have. It is equal to the value returned by `Math.ilogb(Float.MAX_VALUE)`. */
val Float.Companion.MAX_EXPONENT: Int
    get() = 127

/** Minimum exponent a normalized `Float` number may have. It is equal to the value returned by `Math.ilogb(Float.MIN_NORMAL)`. */
val Float.Companion.MIN_EXPONENT: Int
    get() = -126

/** The exponent the smallest positive Float subnormal value would have if it could be normalized.
 *  It is equal to the value returned by `FpUtils.ilogb(Float.MIN_VALUE)`. */
val Float.Companion.MIN_SUB_EXPONENT: Int
    get() = MIN_EXPONENT - (SIGNIFICAND_WIDTH - 1)

/** Bias used in representing a `Float` exponent. */
val Float.Companion.EXP_BIAS: Int
    get() = 127

/** Bit mask to isolate the sign bit of a `Float`. */
val Float.Companion.SIGN_BIT_MASK: Int
    get() = 0x80000000.toInt()

/** Bit mask to isolate the exponent field of a `Float`. */
val Float.Companion.EXP_BIT_MASK: Int
    get() = 0x7F800000

/** Bit mask to isolate the significand field of a `Float`. */
val Float.Companion.SIGNIF_BIT_MASK: Int
    get() = 0x007FFFFF