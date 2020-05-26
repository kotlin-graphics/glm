package glm_.gtx

interface gtxOptimumPow {

    /** Returns x raised to the power of 2.
     *  @see gtx_optimum_pow */
    fun pow2(x: Float) = x * x

    /** Returns x raised to the power of 3.
     *  @see gtx_optimum_pow */
    fun pow3(x: Float) = x * x * x

    /** Returns x raised to the power of 4.
     *  @see gtx_optimum_pow */
    fun pow4(x: Float) = x * x * x * x
}