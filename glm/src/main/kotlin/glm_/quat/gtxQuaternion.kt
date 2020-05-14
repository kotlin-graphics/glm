package glm_.quat

import glm_.detail.GLM_COORDINATE_SYSTEM
import glm_.detail.GlmCoordinateSystem
import glm_.func.cos
import glm_.func.sin
import glm_.glm
import glm_.glm.PIf
import glm_.glm.angleAxis
import glm_.glm.atan
import glm_.glm.epsilonF
import glm_.glm.exp
import glm_.glm.log
import glm_.glm.mix
import glm_.glm.pow
import glm_.mat3x3.Mat3
import glm_.mat4x4.Mat4
import glm_.vec3.Vec3
import glm_.vec3.operators.times
import glm_.vec4.Vec4
import kotlin.math.*
import kotlin.math.exp

/// @ref gtx_quaternion
/// @file glm/gtx/quaternion.hpp
///
/// @see core (dependence)
/// @see gtx_extented_min_max (dependence)
///
/// @defgroup gtx_quaternion GLM_GTX_quaternion
/// @ingroup gtx
///
/// Include <glm/gtx/quaternion.hpp> to use the features of this extension.
///
/// Extented quaternion types and functions

/// @addtogroup gtx_quaternion
/// @{

interface gtxQuaternion {

    /** Create an identity quaternion.
     *  @see gtx_quaternion */
    fun quatIdentity(res: Quat = Quat()) = res.put(1f, 0f, 0f, 0f)

    /** Compute a cross product between a quaternion and a vector.
     *  @see gtx_quaternion */
    fun cross(res: Vec3, q: Quat, v: Vec3): Vec3 {  // TODO add to Quat
        // inverse(q)
        val dot = glm.dot(q, q)
        val w = q.w / dot
        val x = -q.x / dot
        val y = -q.y / dot
        val z = -q.z / dot
        // inverse(q) * v
        val uvX = y * v.z - v.y * z
        val uvY = z * v.x - v.z * x
        val uvZ = x * v.y - v.x * y
        val uuvX = y * uvZ - uvY * z
        val uuvY = z * uvX - uvZ * x
        val uuvZ = x * uvY - uvX * y
        val resX = v.x + (uvX * w + uuvX) * 2f
        val resY = v.y + (uvY * w + uuvY) * 2f
        val resZ = v.z + (uvZ * w + uuvZ) * 2f
        return res(resX, resY, resZ)
    }

    /** Compute a cross product between a vector and a quaternion.
     *  @see gtx_quaternion */
    fun cross(res: Vec3, v: Vec3, q: Quat): Vec3 { // TODO add to Vec3
        // q * v
        val uvX = q.y * v.z - v.y * q.z
        val uvY = q.z * v.x - v.z * q.x
        val uvZ = q.x * v.y - v.x * q.y
        val uuvX = q.y * uvZ - uvY * q.z
        val uuvY = q.z * uvX - uvZ * q.x
        val uuvZ = q.x * uvY - uvX * q.y
        val resX = v.x + (uvX * q.w + uuvX) * 2f
        val resY = v.y + (uvY * q.w + uuvY) * 2f
        val resZ = v.z + (uvZ * q.w + uuvZ) * 2f
        return res(resX, resY, resZ)
    }

    /** Compute a point on a path according squad equation.
     *  q1 and q2 are control points; s1 and s2 are intermediate control points.
     *  @see gtx_quaternion */
    fun squad(q1: Quat, q2: Quat, s1: Quat, s2: Quat, h: Float) = mix(mix(q1, q2, h), mix(s1, s2, h), 2 * (1 - h) * h)

    /** Returns an intermediate control point for squad interpolation.
     *  @see gtx_quaternion */
    fun intermediate(prev: Quat, curr: Quat, next: Quat): Quat {
        val invQuat = curr.inverse()
        return exp((log(next * invQuat) + log(prev * invQuat)) / -4f) * curr
    }

    /** Rotates a 3 components vector by a quaternion.
     *  @see gtx_quaternion */
    fun rotate(q: Quat, v: Vec3) = q * v

    /** Rotates a 4 components vector by a quaternion.
     *  @see gtx_quaternion */
    fun rotate(q: Quat, v: Vec4) = q * v

    /** Extract the real component of a quaternion.
     *  @see gtx_quaternion */
    fun extractRealComponent(q: Quat): Float {
        val w = 1 - q.x * q.x - q.y * q.y - q.z * q.z
        return if (w < 0) 0f else -sqrt(w)
    }

    /** Converts a quaternion to a 3 * 3 matrix.
     *  @see gtx_quaternion */
    fun toMat3(x: Quat) = x.toMat3()

    /** Converts a quaternion to a 4 * 4 matrix.
     *  @see gtx_quaternion */
    fun toMat4(x: Quat) = x.toMat4()

    /** Converts a 3 * 3 matrix to a quaternion.
     *  @see gtx_quaternion */
    fun toQuat(x: Mat3) = x.toQuat()

    /** Converts a 4 * 4 matrix to a quaternion.
     *  @see gtx_quaternion */
    fun toQuat(x: Mat4) = x.toQuat()

    /** Quaternion interpolation using the rotation short path.
     *  @see gtx_quaternion */
    fun shortMix(x: Quat, y: Quat, a: Float): Quat {

        if (a <= 0) return x
        if (a >= 1) return y

        var fCos = x dot y
        var y2 = Quat(y) //BUG!!! tquat<T> y2;
        if (fCos < 0) {
            y2 = -y
            fCos = -fCos
        }

        //if(fCos > 1.0f) // problem
        val k0: Float
        val k1: Float
        if (fCos > 1 - epsilonF) {
            k0 = 1 - a
            k1 = 0 + a //BUG!!! 1.0f + a;
        } else {
            val fSin = sqrt(1 - fCos * fCos)
            val fAngle = atan(fSin, fCos)
            val fOneOverSin = 1 / fSin
            k0 = sin((1 - a) * fAngle) * fOneOverSin
            k1 = sin((0 + a) * fAngle) * fOneOverSin
        }
        return Quat(
                k0 * x.w + k1 * y2.w,
                k0 * x.x + k1 * y2.x,
                k0 * x.y + k1 * y2.y,
                k0 * x.z + k1 * y2.z)
    }

    /** Quaternion normalized linear interpolation.
     *  @see gtx_quaternion */
    fun fastMix(x: Quat, y: Quat, a: Float) = glm.normalize(x * (1 - a) + y * a)

    /** Compute the rotation between two vectors.
     *  param orig vector, needs to be normalized
     *  param dest vector, needs to be normalized
     *  @see gtx_quaternion */
    fun rotation(orig: Vec3, dest: Vec3): Quat {

        val cosTheta = orig dot dest

        if (cosTheta >= 1 - epsilonF)
        // orig and dest point in the same direction
            return quatIdentity()

        if (cosTheta < -1 + epsilonF) {
            /*  special case when vectors in opposite directions :
                there is no "ideal" rotation axis
                So guess one; any will do as long as it's perpendicular to start
                This implementation favors a rotation around the Up axis (Y), since it's often what you want to do. */
            var rotationAxis = Vec3(0, 0, 1) cross orig
            if (rotationAxis.length2() < epsilonF) // bad luck, they were parallel, try again!
                rotationAxis = Vec3(1, 0, 0) cross orig

            rotationAxis = rotationAxis.normalize()
            return angleAxis(PIf, rotationAxis)
        }

        // Implementation from Stan Melax's Game Programming Gems 1 article
        val rotationAxis = orig cross dest

        val s = sqrt((1 + cosTheta) * 2)
        val invs = 1 / s

        return Quat(
                s * 0.5f,
                rotationAxis.x * invs,
                rotationAxis.y * invs,
                rotationAxis.z * invs)
    }



    /** Returns the squared length of x.
     *  @see gtx_quaternion */
    fun length2(q: Quat) = q dot q
}