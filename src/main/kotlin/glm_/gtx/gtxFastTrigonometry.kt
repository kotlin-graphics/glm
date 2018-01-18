package glm_.gtx

import glm_.glm.HPIf
import glm_.glm.PI2f
import glm_.glm.PIf
import glm_.glm.detail
import glm_.glm.sign
import glm_.vec2.Vec2
import glm_.vec2.operators.minus
import glm_.vec3.operators.minus
import glm_.vec4.operators.minus
import glm_.vec3.Vec3
import glm_.vec4.Vec4
import kotlin.math.abs

interface gtxFastTrigonometry {

    /** Wrap an angle to [0 2pi[    */
    fun wrapAngle(angle: Float) = abs(angle % PI2f)

    /** Faster than the common sin function but less accurate. */
    fun fastSin(angle: Float) = fastCos(HPIf - angle)

    /** Faster than the common cos function but less accurate.  */
    fun fastCos(angle: Float): Float {
        val angle = wrapAngle(angle)

        return when {
            angle < HPIf -> detail.cos52s(angle)
            angle < PIf -> -detail.cos52s(PIf - angle)
            angle < 3 * HPIf -> -detail.cos52s(angle - PIf)
            else -> detail.cos52s(PI2f - angle)
        }
    }
    fun fastCos(angle: Vec4) = Vec4(fastCos(angle.x), fastCos(angle.y), fastCos(angle.z), fastCos(angle.w))

    /** Faster than the common tan function but less accurate.  */
    fun fastTan(angle: Float) = angle +
            (angle * angle * angle * 0.3333333333f) +
            (angle * angle * angle * angle * angle * 0.1333333333333f) +
            (angle * angle * angle * angle * angle * angle * angle * 0.0539682539f)

    /** Faster than the common asin function but less accurate. Defined between -2pi and 2pi. */
    fun fastAsin(angle: Float) = angle +
            (angle * angle * angle * 0.166666667f) +
            (angle * angle * angle * angle * angle * 0.075f) +
            (angle * angle * angle * angle * angle * angle * angle * 0.0446428571f) +
            (angle * angle * angle * angle * angle * angle * angle * angle * angle * 0.0303819444f)// + (x * x * x * x * x * x * x * x * x * x * x * T(0.022372159));

    /** Faster than the common acos function but less accurate. Defined between -2pi and 2pi. */
    fun fastAcos(angle: Float) = 1.5707963267948966192313216916398f - fastAsin(angle) //(PI / 2)

    /** Faster than the common atan function but less accurate. Defined between -2pi and 2pi. */
    fun fastAtan(y: Float, x: Float): Float {
        val sgn = sign(y) * sign(x)
        return abs(fastAtan(y / x)) * sgn
    }

    /** Faster than the common atan function but less accurate. Defined between -2pi and 2pi. */
    fun fastAtan(angle: Float) = angle -
            (angle * angle * angle * 0.333333333333f) +
            (angle * angle * angle * angle * angle * 0.2f) -
            (angle * angle * angle * angle * angle * angle * angle * 0.1428571429f) +
            (angle * angle * angle * angle * angle * angle * angle * angle * angle * 0.111111111111f) -
            (angle * angle * angle * angle * angle * angle * angle * angle * angle * angle * angle * 0.0909090909f)
}

interface detail_fastTrigonometry {

    fun taylorCos(x: Vec2) = 1f -
            (x * x) * (1f / 2f) +
            ((x * x) * (x * x)) * (1f / 24f) -
            (((x * x) * (x * x)) * (x * x)) * (1f / 720f) +
            (((x * x) * (x * x)) * ((x * x) * (x * x))) * (1f / 40320f)

    fun taylorCos(x: Vec3) = 1f -
            (x * x) * (1f / 2f) +
            ((x * x) * (x * x)) * (1f / 24f) -
            (((x * x) * (x * x)) * (x * x)) * (1f / 720f) +
            (((x * x) * (x * x)) * ((x * x) * (x * x))) * (1f / 40320f)

    fun taylorCos(x: Vec4) = 1f -
            (x * x) * (1f / 2f) +
            ((x * x) * (x * x)) * (1f / 24f) -
            (((x * x) * (x * x)) * (x * x)) * (1f / 720f) +
            (((x * x) * (x * x)) * ((x * x) * (x * x))) * (1f / 40320f)

    fun cos52s(x: Float): Float {
        val xx = x * x
        return 0.9999932946f + xx * (-0.4999124376f + xx * (0.0414877472f + xx * -0.0012712095f))
    }

//    template<length_t L, typename T, qualifier Q>
//    GLM_FUNC_QUALIFIER vec<L, T, Q> cos_52s(vec<L, T, Q> const & x)
//    {
//        return detail::functor1<L, T, T, Q>::call(cos_52s, x)
//    }
}