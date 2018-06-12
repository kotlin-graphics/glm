package glm_.gtx

import glm_.glm
import kotlin.math.cos
import kotlin.math.sin
import kotlin.math.sqrt

interface gtxEasing {

    /** Modelled after the line y = x
     *  @see gtx_easing */
    fun linearInterpolation(a: Float): Float {
        // Only defined in [0, 1]
        assert(a in 0f..1f)

        return a
    }

    /** Modelled after the parabola y = x^2
     *  @see gtx_easing */
    fun quadraticEaseIn(a: Float): Float {
        // Only defined in [0, 1]
        assert(a in 0f..1f)

        return a * a
    }

    /** Modelled after the parabola y = -x^2 + 2x
     *  @see gtx_easing */
    fun quadraticEaseOut(a: Float): Float {
        // Only defined in [0, 1]
        assert(a in 0f..1f)

        return -(a * (a - 2f))
    }

    /** Modelled after the piecewise quadratic
     *  y = (1/2)((2x)^2)				; [0, 0.5)
     *  y = -(1/2)((2x-1)*(2x-3) - 1)	; [0.5, 1]
     *  @see gtx_easing */
    fun quadraticEaseInOut(a: Float): Float {
        // Only defined in [0, 1]
        assert(a in 0f..1f)

        return when {
            a < 0.5f -> 2f * a * a
            else -> -2f * a * a + 4 * a - 1f
        }
    }

    /** Modelled after the cubic y = x^3 */
    fun cubicEaseIn(a: Float): Float {
        // Only defined in [0, 1]
        assert(a in 0f..1f)

        return a * a * a
    }

    /** Modelled after the cubic y = (x - 1)^3 + 1
     *  @see gtx_easing */
    fun cubicEaseOut(a: Float): Float {
        // Only defined in [0, 1]
        assert(a in 0f..1f)

        val f = a - 1f
        return f * f * f + 1f
    }

    /** Modelled after the piecewise cubic
     *  y = (1/2)((2x)^3)		; [0, 0.5)
     *  y = (1/2)((2x-2)^3 + 2)	; [0.5, 1]
     *  @see gtx_easing */
    fun cubicEaseInOut(a: Float): Float {
        // Only defined in [0, 1]
        assert(a in 0f..1f)

        return when {
            a < 0.5f -> 4f * a * a * a
            else -> {
                val f = 2f * a - 2f
                0.5f * f * f * f + 1f
            }
        }
    }

    /** Modelled after the quartic x^4
     *  @see gtx_easing */
    fun quarticEaseIn(a: Float): Float {
        // Only defined in [0, 1]
        assert(a in 0f..1f)

        return a * a * a * a
    }

    /** Modelled after the quartic y = 1 - (x - 1)^4
     *  @see gtx_easing */
    fun quarticEaseOut(a: Float): Float {
        // Only defined in [0, 1]
        assert(a in 0f..1f)

        val f = a - 1f
        return f * f * f * (1f - a) + 1f
    }

    /** Modelled after the piecewise quartic
     *  y = (1/2)((2x)^4)			; [0, 0.5)
     *  y = -(1/2)((2x-2)^4 - 2)	; [0.5, 1]
     *  @see gtx_easing */
    fun quarticEaseInOut(a: Float): Float {
        // Only defined in [0, 1]
        assert(a in 0f..1f)

        return when {
            a < 0.5f -> 8f * a * a * a * a
            else -> {
                val f = a - 1f
                -8f * f * f * f * f + 1f
            }
        }
    }

    /** Modelled after the quintic y = x^5
     *  @see gtx_easing */
    fun quinticEaseIn(a: Float): Float {
        // Only defined in [0, 1]
        assert(a in 0f..1f)

        return a * a * a * a * a
    }

    /** Modelled after the quintic y = (x - 1)^5 + 1
     *  @see gtx_easing */
    fun quinticEaseOut(a: Float): Float {
        // Only defined in [0, 1]
        assert(a in 0f..1f)

        val f = a - 1f
        return f * f * f * f * f + 1f
    }

    /** Modelled after the piecewise quintic
     *  y = (1/2)((2x)^5)		; [0, 0.5)
     *  y = (1/2)((2x-2)^5 + 2) ; [0.5, 1]
     *  @see gtx_easing */
    fun quinticEaseInOut(a: Float): Float {
        // Only defined in [0, 1]
        assert(a in 0f..1f)

        return when {
            a < 0.5f -> 16f * a * a * a * a * a
            else -> {
                val f = 2f * a - 2f
                0.5f * f * f * f * f * f + 1f
            }
        }
    }

    /** Modelled after quarter-cycle of sine wave
     *  @see gtx_easing */
    fun sineEaseIn(a: Float): Float {
        // Only defined in [0, 1]
        assert(a in 0f..1f)

        return sin((a - 1f) * glm.HPIf) + 1f
    }

    /** Modelled after quarter-cycle of sine wave (different phase)
     *  @see gtx_easing */
    fun sineEaseOut(a: Float): Float {
        // Only defined in [0, 1]
        assert(a in 0f..1f)

        return sin(a * glm.HPIf)
    }

    /** Modelled after half sine wave
     *  @see gtx_easing */
    fun sineEaseInOut(a: Float): Float {
        // Only defined in [0, 1]
        assert(a in 0f..1f)

        return 0.5f * (1f - cos(a * glm.PIf))
    }

    /** Modelled after shifted quadrant IV of unit circle
     *  @see gtx_easing */
    fun circularEaseIn(a: Float): Float {
        // Only defined in [0, 1]
        assert(a in 0f..1f)

        return 1f - sqrt(1f - a * a)
    }

    /** Modelled after shifted quadrant II of unit circle
     *  @see gtx_easing */
    fun circularEaseOut(a: Float): Float {
        // Only defined in [0, 1]
        assert(a in 0f..1f)

        return sqrt((2f - a) * a)
    }

    /** Modelled after the piecewise circular function
     *  y = (1/2)(1 - sqrt(1 - 4x^2))			; [0, 0.5)
     *  y = (1/2)(sqrt(-(2x - 3)*(2x - 1)) + 1) ; [0.5, 1]
     *  @see gtx_easing */
    fun circularEaseInOut(a: Float): Float {
        // Only defined in [0, 1]
        assert(a in 0f..1f)

        return when {
            a < 0.5f -> 0.5f * (1f - sqrt(1f - 4f * (a * a)))
            else -> 0.5f * (sqrt(-(2f * a - 3f) * (2f * a - 1f)) + 1f)
        }
    }

    /** Modelled after the exponential function y = 2^(10(x - 1))
     *  @see gtx_easing */
    fun exponentialEaseIn(a: Float): Float {
        // Only defined in [0, 1]
        assert(a in 0f..1f)

        return when {
            a <= 0f -> a
            else -> {
                val complementary = a - 1f
                val two = 2f

                glm.pow(two, complementary * 10f)
            }
        }
    }

    /** Modelled after the exponential function y = -2^(-10x) + 1
     *  @see gtx_easing */
    fun exponentialEaseOut(a: Float): Float {
        // Only defined in [0, 1]
        assert(a in 0f..1f)

        return when {
            a >= 1f -> a
            else -> 1f - glm.pow(2f, -10f * a)
        }
    }

    /** Modelled after the piecewise exponential
     *  y = (1/2)2^(10(2x - 1))			; [0,0.5)
     *  y = -(1/2)*2^(-10(2x - 1))) + 1 ; [0.5,1]
     *  @see gtx_easing */
    fun exponentialEaseInOut(a: Float): Float {
        // Only defined in [0, 1]
        assert(a in 0f..1f)

        return when {
            a < 0.5f -> 0.5f * glm.pow(2f, 20f * a - 10f)
            else -> -0.5f * glm.pow(2f, -20f * a + 10f) + 1f
        }
    }

    /** Modelled after the damped sine wave y = sin(13pi/2*x)*pow(2, 10 * (x - 1))
     *  @see gtx_easing */
    fun elasticEaseIn(a: Float): Float {
        // Only defined in [0, 1]
        assert(a in 0f..1f)

        return sin(13f * glm.HPIf * a) * glm.pow(2f, 10f * (a - 1f))
    }

    /** Modelled after the damped sine wave y = sin(-13pi/2*(x + 1))*pow(2, -10x) + 1
     *  @see gtx_easing */
    fun elasticEaseOut(a: Float): Float {
        // Only defined in [0, 1]
        assert(a in 0f..1f)

        return sin(-13f * glm.HPIf * (a + 1f)) * glm.pow(2f, -10f * a) + 1f
    }

    /** Modelled after the piecewise exponentially-damped sine wave:
     *  y = (1/2)*sin(13pi/2*(2*x))*pow(2, 10 * ((2*x) - 1))		; [0,0.5)
     *  y = (1/2)*(sin(-13pi/2*((2x-1)+1))*pow(2,-10(2*x-1)) + 2)	; [0.5, 1]
     *  @see gtx_easing */
    fun elasticEaseInOut(a: Float): Float {
        // Only defined in [0, 1]
        assert(a in 0f..1f)

        return when {
            a < 0.5f -> 0.5f * sin(13f * glm.HPIf * (2f * a)) * glm.pow(2f, 10f * (2f * a - 1f))
            else -> 0.5f * (sin(-13f * glm.HPIf * (2f * a)) * glm.pow(2f, -10f * (2f * a - 1f)) + 2f)
        }
    }

    /** @see gtx_easing */
    fun backEaseIn(a: Float): Float = backEaseIn(a, 1.70158f)

    /** @see gtx_easing */
    fun backEaseOut(a: Float): Float = backEaseOut(a, 1.70158f)

    /** @see gtx_easing */
    fun backEaseInOut(a: Float): Float = backEaseInOut(a, 1.70158f)

    /** @param a parameter
     *  @param o Optional overshoot modifier
     *  @see gtx_easing */
    fun backEaseIn(a: Float, o: Float): Float {
        // Only defined in [0, 1]
        assert(a in 0f..1f)

        val z = ((o + 1f) * a) - o
        return a * a * z
    }

    /** @param a parameter
     *  @param o Optional overshoot modifier
     *  @see gtx_easing */
    fun backEaseOut(a: Float, o: Float): Float {
        // Only defined in [0, 1]
        assert(a in 0f..1f)

        val n = a - 1f
        val z = ((o + 1f) * n) + o
        return n * n * z + 1f
    }

    /** @param a parameter
     *  @param o Optional overshoot modifier
     *  @see gtx_easing */
    fun backEaseInOut(a: Float, o: Float): Float {
        // Only defined in [0, 1]
        assert(a in 0f..1f)

        val s = o * 1.525f
        val x = 0.5f
        var n = a / 0.5f

        return when {
            n < 1f -> {
                val z = ((s + 1f) * n) - s
                val m = n * n * z
                x * m
            }
            else -> {
                n -= 2
                val z = (s + 1f) * n + s
                val m = n * n * z + 2f
                x * m
            }
        }
    }

    /** @see gtx_easing */
    fun bounceEaseIn(a: Float): Float {
        // Only defined in [0, 1]
        assert(a in 0f..1f)

        return 1f - bounceEaseOut(1 - a)
    }

    /** @see gtx_easing */
    fun bounceEaseOut(a: Float): Float {
        // Only defined in [0, 1]
        assert(a in 0f..1f)

        return when {
            a < 4f / 11f -> (121f * a * a) / 16f
            a < 8f / 11f -> (363f / 40f) * a * a - (99f / 10f) * a + 17f / 5f
            a < 9f / 10f -> (4356f / 361f) * a * a - (35442f / 1805f) * a + 16061f / 1805f
            else -> (54f / 5f) * a * a - (513f / 25f) * a + 268f / 25f
        }
    }

    /** @see gtx_easing */
    fun bounceEaseInOut(a: Float): Float {
        // Only defined in [0, 1]
        assert(a in 0f..1f)

        return when {
            a < 0.5f -> 0.5f * (1f - bounceEaseOut(a * 2f))
            else -> 0.5f * bounceEaseOut(a * 2f - 1f) + 0.5f
        }
    }
}