/**
 * Created bY GBarbieri on 06.10.2016.
 */

package glm_

import glm_.ext.*
import glm_.ext.ext_quaternionCommon
import glm_.ext.ext_quaternionTransform
import glm_.ext.ext_quaternionTrigonometric
import glm_.func.*
import glm_.func.common.*
import glm_.gtc.gtc_MatrixInverse
import glm_.gtx.*
import glm_.gtc.gtc_Quaternion
import glm_.quat.gtx_quaternion

object glm :

        func_common,
        func_vector1_common,
        func_vector2_common,
        func_vector3_common,
        func_vector4_common,

        func_vector1_relational,
        func_vector2_relational,
        func_vector3_relational,
        func_vector4_relational,
        func_vectorBoolean_relational,

        func_matrix,

        func_exponential,
        func_geometric,
        func_trigonometric,

        // matrix transform
        gtxMatrixOperation,

        ext_matrixClipSpace,
        ext_matrixProjection,
        ext_matrixTransform,

        gtc_Quaternion,
        ext_quaternionCommon,
        ext_quaternionTransform,
        ext_quaternionTrigonometric,
        ext_quaternionExponential,

        ext_scalarCommon,

        matrix_interpolation,

        epsilon,

        componentWise,

        round,

        funcInteger,

        bitfield,

        colorSpace,

        gauss,

        noise,

        packing,
        func_packing,

        random,

        gradientPaint,

        gtc_MatrixInverse,

        gtxClosestPoint,
        gtxEasing,
        gtxEulerAngles,
        gtxFastTrigonometry,
        gtxInteger,
        gtxIntersect,
        gtxMatrixCrossProduct,
        gtxMatrixDecompose,
        gtxMatrixFactorization,
        gtxNormal,
        gtxOptimumPow,
        gtx_quaternion,
        gtxRotateVector,
        gxtSpline,
        gtxTexture,
        gtxVectorAngle,

        // ext
        ext_QuaternionGeometric,
//        extQuaternionRelational,
        extScalarRelational,
        matrixRelational,

        closestPointToLines {

    @JvmField
    val detail = Detail

    @JvmField
    val HPI = kotlin.math.PI / 2
    @JvmField
    val HPIf = kotlin.math.PI.f / 2

    @JvmField
    val PI = kotlin.math.PI
    @JvmField
    val PIf = kotlin.math.PI.f
    val π = Math.PI
    val πf = PIf

    @JvmField
    val PI2 = kotlin.math.PI * 2
    @JvmField
    val PI2f = kotlin.math.PI.f * 2

    @JvmField
    val PI3over2f = kotlin.math.PI.f * 1.5f

    @JvmField
    val epsilonF = Float.MIN_VALUE
    val _epsilonF = 1.19209290e-07f // FIXME, quat slerp fails with Float.MIN_VALUE
    @JvmField
    val epsilon = 2.2204460492503131e-16 // TODO check me
    val ε = epsilon
    val εf = epsilonF

    @JvmField
    val Ef = Math.E.f
    @JvmField
    val E = Math.E
}

object Detail :
        noise,
        typeHalf,
        packing_detail,
        detail_matrixDecompose,
        detail_fastTrigonometry,
        detail_gtxInteger,
        detail_integer


class Java {

    companion object {
        @JvmField
        val glm = glm_.glm
    }
}

typealias uint = Int
typealias ulong = Long

val GLM_VERSION_MAJOR = 0
val GLM_VERSION_MINOR = 9
val GLM_VERSION_PATCH = 9
val GLM_VERSION_REVISION = 1
val GLM_VERSION_BUILD = 4
val GLM_VERSION = GLM_VERSION_MAJOR * 1_000 + GLM_VERSION_MINOR * 100 + GLM_VERSION_PATCH * 10 + GLM_VERSION_REVISION

/*
    TODO:
      Added missing equal and notEqual with epsilon for quaternion types (https://github.com/g-truc/glm/commit/8f0b7c13732b018339697d182ea3a9f437ccaa71)
       Fixed relational code, reduced header dependencies  (https://github.com/g-truc/glm/commit/7086d902e2780e0774830573da7473938290ea73)
 */