package glm_

import kotlin.math.max
import kotlin.math.ulp

/**
 * Created by GBarbieri on 14.12.2016.
 */


fun epsilon(a: Float, b: Float) = max(a.ulp, b.ulp)

fun epsilon(a: Double, b: Double) = max(a.ulp, b.ulp)