package glm_.gtx

import glm_.mat2x2.Mat2
import glm_.mat3x3.Mat3
import glm_.mat4x4.Mat4
import glm_.vec3.Vec3
import kotlin.math.atan2
import kotlin.math.cos
import kotlin.math.sin
import kotlin.math.sqrt

interface gtxEulerAngles {

    /** Creates a 3D 4 * 4 homogeneous rotation matrix from an euler angle X.
     *  @see gtx_euler_angles */
    fun eulerAngleX(res: Mat4, angleX: Float): Mat4 {

        val cosX = cos(angleX)
        val sinX = sin(angleX)

        return res(
                1f, 0f, 0f, 0f,
                0f, cosX, sinX, 0f,
                0f, -sinX, cosX, 0f,
                0f, 0f, 0f, 1f)
    }

    /** Creates a 3D 4 * 4 homogeneous rotation matrix from an euler angle X.
     *  @see gtx_euler_angles */
    infix fun eulerAngleX(angleX: Float): Mat4 = eulerAngleX(Mat4(), angleX)

    /** Creates a 3D 4 * 4 homogeneous rotation matrix from an euler angle Y.
     *  @see gtx_euler_angles */
    fun eulerAngleY(res: Mat4, angleY: Float): Mat4 {

        val cosY = cos(angleY)
        val sinY = sin(angleY)

        return res(
                cosY, 0f, -sinY, 0f,
                0f, 1f, 0f, 0f,
                sinY, 0f, cosY, 0f,
                0f, 0f, 0f, 1f)
    }

    /** Creates a 3D 4 * 4 homogeneous rotation matrix from an euler angle Y.
     *  @see gtx_euler_angles */
    infix fun eulerAngleY(angleY: Float): Mat4 = eulerAngleY(Mat4(), angleY)

    /** Creates a 3D 4 * 4 homogeneous rotation matrix from an euler angle Z.
     *  @see gtx_euler_angles */
    fun eulerAngleZ(res: Mat4, angleZ: Float): Mat4 {

        val cosZ = cos(angleZ)
        val sinZ = sin(angleZ)

        return res(
                cosZ, sinZ, 0f, 0f,
                -sinZ, cosZ, 0f, 0f,
                0f, 0f, 1f, 0f,
                0f, 0f, 0f, 1f)
    }

    /** Creates a 3D 4 * 4 homogeneous rotation matrix from an euler angle Z.
     *  @see gtx_euler_angles */
    infix fun eulerAngleZ(angleZ: Float): Mat4 = eulerAngleZ(Mat4(), angleZ)

    /** Creates a 3D 4 * 4 homogeneous derived matrix from the rotation matrix about X-axis.
     *  @see gtx_euler_angles */
    fun derivedEulerAngleX(res: Mat4, angleX: Float, angularVelocityX: Float): Mat4 {

        val cosX = cos(angleX) * angularVelocityX
        val sinX = sin(angleX) * angularVelocityX

        return res(
                0f, 0f, 0f, 0f,
                0f, -sinX, cosX, 0f,
                0f, -cosX, -sinX, 0f,
                0f, 0f, 0f, 0f)
    }

    /** Creates a 3D 4 * 4 homogeneous derived matrix from the rotation matrix about X-axis.
     *  @see gtx_euler_angles */
    fun derivedEulerAngleX(angleX: Float, angularVelocityX: Float): Mat4 = derivedEulerAngleX(Mat4(), angleX, angularVelocityX)

    /** Creates a 3D 4 * 4 homogeneous derived matrix from the rotation matrix about Y-axis.
     *  @see gtx_euler_angles */
    fun derivedEulerAngleY(res: Mat4, angleY: Float, angularVelocityY: Float): Mat4 {

        val cosY = cos(angleY) * angularVelocityY
        val sinY = sin(angleY) * angularVelocityY

        return res(
                -sinY, 0f, -cosY, 0f,
                0f, 0f, 0f, 0f,
                cosY, 0f, -sinY, 0f,
                0f, 0f, 0f, 0f)
    }

    /** Creates a 3D 4 * 4 homogeneous derived matrix from the rotation matrix about Y-axis.
     *  @see gtx_euler_angles */
    fun derivedEulerAngleY(angleY: Float, angularVelocityY: Float): Mat4 = derivedEulerAngleY(Mat4(), angleY, angularVelocityY)

    /** Creates a 3D 4 * 4 homogeneous derived matrix from the rotation matrix about Z-axis.
     *  @see gtx_euler_angles */
    fun derivedEulerAngleZ(res: Mat4, angleZ: Float, angularVelocityZ: Float): Mat4 {

        val cosZ = cos(angleZ) * angularVelocityZ
        val sinZ = sin(angleZ) * angularVelocityZ

        return res(
                -sinZ, cosZ, 0f, 0f,
                -cosZ, -sinZ, 0f, 0f,
                0f, 0f, 0f, 0f,
                0f, 0f, 0f, 0f)
    }

    /** Creates a 3D 4 * 4 homogeneous derived matrix from the rotation matrix about Z-axis.
     *  @see gtx_euler_angles */
    fun derivedEulerAngleZ(angleZ: Float, angularVelocityZ: Float): Mat4 = derivedEulerAngleZ(Mat4(), angleZ, angularVelocityZ)

    /** Creates a 3D 4 * 4 homogeneous rotation matrix from euler angles (X * Y).
     *  @see gtx_euler_angles */
    fun eulerAngleXY(res: Mat4, angleX: Float, angleY: Float): Mat4 {

        val cosX = cos(angleX)
        val sinX = sin(angleX)
        val cosY = cos(angleY)
        val sinY = sin(angleY)

        return res(
                cosY, -sinX * -sinY, cosX * -sinY, 0f,
                0f, cosX, sinX, 0f,
                sinY, -sinX * cosY, cosX * cosY, 0f,
                0f, 0f, 0f, 1f)
    }

    /** Creates a 3D 4 * 4 homogeneous rotation matrix from euler angles (X * Y).
     *  @see gtx_euler_angles */
    fun eulerAngleXY(angleX: Float, angleY: Float): Mat4 = eulerAngleXY(Mat4(), angleX, angleY)

    /** Creates a 3D 4 * 4 homogeneous rotation matrix from euler angles (Y * X).
     *  @see gtx_euler_angles */
    fun eulerAngleYX(res: Mat4, angleY: Float, angleX: Float): Mat4 {

        val cosX = cos(angleX)
        val sinX = sin(angleX)
        val cosY = cos(angleY)
        val sinY = sin(angleY)

        return res(
                cosY, 0f, -sinY, 0f,
                sinY * sinX, cosX, cosY * sinX, 0f,
                sinY * cosX, -sinX, cosY * cosX, 0f,
                0f, 0f, 0f, 1f)
    }

    /** Creates a 3D 4 * 4 homogeneous rotation matrix from euler angles (Y * X).
     *  @see gtx_euler_angles */
    fun eulerAngleYX(angleY: Float, angleX: Float): Mat4 = eulerAngleYX(Mat4(), angleY, angleX)

    /** Creates a 3D 4 * 4 homogeneous rotation matrix from euler angles (X * Z).
     *  @see gtx_euler_angles */
    fun eulerAngleXZ(res: Mat4, angleX: Float, angleZ: Float): Mat4 {

        val cosX = cos(angleX)
        val sinX = sin(angleX)

        val cosZ = cos(angleZ)
        val sinZ = sin(angleZ)

        res.array[0] = cosZ
        res.array[4] = -sinZ
        res.array[8] = 0f
        res.array[12] = 0f
        res.array[1] = cosX * sinZ
        res.array[5] = cosX * cosZ
        res.array[9] = -sinX
        res.array[13] = 0f
        res.array[2] = sinX * sinZ
        res.array[6] = sinX * cosZ
        res.array[10] = cosX
        res.array[14] = 0f
        res.array[3] = 0f
        res.array[7] = 0f
        res.array[11] = 0f
        res.array[15] = 1f

        return res
    }

    /** Creates a 3D 4 * 4 homogeneous rotation matrix from euler angles (X * Z).
     *  @see gtx_euler_angles */
    fun eulerAngleXZ(angleX: Float, angleZ: Float): Mat4 = eulerAngleXZ(Mat4(), angleX, angleZ)

    /** Creates a 3D 4 * 4 homogeneous rotation matrix from euler angles (Z * X).
     *  @see gtx_euler_angles */
    fun eulerAngleZX(res: Mat4, angleZ: Float, angleX: Float): Mat4 {

        val cosZ = cos(angleZ)
        val sinZ = sin(angleZ)

        val cosX = cos(angleX)
        val sinX = sin(angleX)

        res.array[0] = cosZ
        res.array[4] = -sinZ * cosX
        res.array[8] = -sinZ * -sinX
        res.array[12] = 0f
        res.array[1] = sinZ
        res.array[5] = cosZ * cosX
        res.array[9] = cosZ * -sinX
        res.array[13] = 0f
        res.array[2] = 0f
        res.array[6] = sinX
        res.array[10] = cosX
        res.array[14] = 0f
        res.array[3] = 0f
        res.array[7] = 0f
        res.array[11] = 0f
        res.array[15] = 1f

        return res
    }

    /** Creates a 3D 4 * 4 homogeneous rotation matrix from euler angles (Z * X).
     *  @see gtx_euler_angles */
    fun eulerAngleZX(angleZ: Float, angleX: Float): Mat4 = eulerAngleZX(Mat4(), angleZ, angleX)

    /** Creates a 3D 4 * 4 homogeneous rotation matrix from euler angles (Y * Z).
     *  @see gtx_euler_angles */
    fun eulerAngleYZ(res: Mat4, angleY: Float, angleZ: Float): Mat4 {

        val cosY = cos(angleY)
        val sinY = sin(angleY)

        val cosZ = cos(angleZ)
        val sinZ = sin(angleZ)

        res.array[0] = cosY * cosZ
        res.array[4] = cosY * -sinZ
        res.array[8] = sinY
        res.array[12] = 0f
        res.array[1] = sinZ
        res.array[5] = cosZ
        res.array[9] = 0f
        res.array[13] = 0f
        res.array[2] = -sinY * cosZ
        res.array[6] = -sinY * -sinZ
        res.array[10] = cosY
        res.array[14] = 0f
        res.array[3] = 0f
        res.array[7] = 0f
        res.array[11] = 0f
        res.array[15] = 1f

        return res
    }

    /** Creates a 3D 4 * 4 homogeneous rotation matrix from euler angles (Y * Z).
     *  @see gtx_euler_angles */
    fun eulerAngleYZ(angleY: Float, angleZ: Float): Mat4 = eulerAngleYZ(Mat4(), angleY, angleZ)

    /** Creates a 3D 4 * 4 homogeneous rotation matrix from euler angles (Z * Y).
     *  @see gtx_euler_angles */
    fun eulerAngleZY(res: Mat4, angleZ: Float, angleY: Float): Mat4 {

        val cosZ = cos(angleZ)
        val sinZ = sin(angleZ)

        val cosY = cos(angleY)
        val sinY = sin(angleY)

        res.array[0] = cosZ * cosY
        res.array[4] = -sinZ
        res.array[8] = cosZ * sinY
        res.array[12] = 0f
        res.array[1] = sinZ * cosY
        res.array[5] = cosZ
        res.array[9] = sinZ * sinY
        res.array[13] = 0f
        res.array[2] = -sinY
        res.array[6] = 0f
        res.array[10] = cosY
        res.array[14] = 0f
        res.array[3] = 0f
        res.array[7] = 0f
        res.array[11] = 0f
        res.array[15] = 1f

        return res
    }

    /** Creates a 3D 4 * 4 homogeneous rotation matrix from euler angles (Z * Y).
     *  @see gtx_euler_angles */
    fun eulerAngleZY(angleZ: Float, angleY: Float): Mat4 = eulerAngleZY(Mat4(), angleZ, angleY)

    /** Creates a 3D 4 * 4 homogeneous rotation matrix from euler angles (X * Y * Z).
     *  @see gtx_euler_angles */
    fun eulerAngleXYZ(res: Mat4, t1: Float, t2: Float, t3: Float): Mat4 {

        val c1 = cos(-t1)
        val c2 = cos(-t2)
        val c3 = cos(-t3)
        val s1 = sin(-t1)
        val s2 = sin(-t2)
        val s3 = sin(-t3)

        res[0, 0] = c2 * c3
        res[0, 1] = -c1 * s3 + s1 * s2 * c3
        res[0, 2] = s1 * s3 + c1 * s2 * c3
        res[0, 3] = 0f
        res[1, 0] = c2 * s3
        res[1, 1] = c1 * c3 + s1 * s2 * s3
        res[1, 2] = -s1 * c3 + c1 * s2 * s3
        res[1, 3] = 0f
        res[2, 0] = -s2
        res[2, 1] = s1 * c2
        res[2, 2] = c1 * c2
        res[2, 3] = 0f
        res[3, 0] = 0f
        res[3, 1] = 0f
        res[3, 2] = 0f
        res[3, 3] = 1f
        return res
    }

    /** Creates a 3D 4 * 4 homogeneous rotation matrix from euler angles (X * Y * Z).
     *  @see gtx_euler_angles */
    fun eulerAngleXYZ(t1: Float, t2: Float, t3: Float): Mat4 = eulerAngleXYZ(Mat4(), t1, t2, t3)

    /** Creates a 3D 4 * 4 homogeneous rotation matrix from euler angles (Y * X * Z).
     *  @see gtx_euler_angles */
    fun eulerAngleYXZ(res: Mat4, yaw: Float, pitch: Float, roll: Float): Mat4 {

        val tmpCh = cos(yaw)
        val tmpSh = sin(yaw)
        val tmpCp = cos(pitch)
        val tmpSp = sin(pitch)
        val tmpCb = cos(roll)
        val tmpSb = sin(roll)

        res[0, 0] = tmpCh * tmpCb + tmpSh * tmpSp * tmpSb
        res[0, 1] = tmpSb * tmpCp
        res[0, 2] = -tmpSh * tmpCb + tmpCh * tmpSp * tmpSb
        res[0, 3] = 0f
        res[1, 0] = -tmpCh * tmpSb + tmpSh * tmpSp * tmpCb
        res[1, 1] = tmpCb * tmpCp
        res[1, 2] = tmpSb * tmpSh + tmpCh * tmpSp * tmpCb
        res[1, 3] = 0f
        res[2, 0] = tmpSh * tmpCp
        res[2, 1] = -tmpSp
        res[2, 2] = tmpCh * tmpCp
        res[2, 3] = 0f
        res[3, 0] = 0f
        res[3, 1] = 0f
        res[3, 2] = 0f
        res[3, 3] = 1f
        return res
    }

    /** Creates a 3D 4 * 4 homogeneous rotation matrix from euler angles (Y * X * Z).
     *  @see gtx_euler_angles */
    fun eulerAngleYXZ(yaw: Float, pitch: Float, roll: Float): Mat4 = eulerAngleYXZ(Mat4(), yaw, pitch, roll)

    /** Creates a 3D 4 * 4 homogeneous rotation matrix from euler angles (X * Z * X).
     *  @see gtx_euler_angles */
    fun eulerAngleXZX(res: Mat4, t1: Float, t2: Float, t3: Float): Mat4 {

        val c1 = cos(t1)
        val s1 = sin(t1)
        val c2 = cos(t2)
        val s2 = sin(t2)
        val c3 = cos(t3)
        val s3 = sin(t3)

        res[0, 0] = c2
        res[0, 1] = c1 * s2
        res[0, 2] = s1 * s2
        res[0, 3] = 0f
        res[1, 0] = -c3 * s2
        res[1, 1] = c1 * c2 * c3 - s1 * s3
        res[1, 2] = c1 * s3 + c2 * c3 * s1
        res[1, 3] = 0f
        res[2, 0] = s2 * s3
        res[2, 1] = -c3 * s1 - c1 * c2 * s3
        res[2, 2] = c1 * c3 - c2 * s1 * s3
        res[2, 3] = 0f
        res[3, 0] = 0f
        res[3, 1] = 0f
        res[3, 2] = 0f
        res[3, 3] = 1f
        return res
    }

    /** Creates a 3D 4 * 4 homogeneous rotation matrix from euler angles (X * Z * X).
     *  @see gtx_euler_angles */
    fun eulerAngleXZX(t1: Float, t2: Float, t3: Float): Mat4 = eulerAngleXZX(Mat4(), t1, t2, t3)

    /** Creates a 3D 4 * 4 homogeneous rotation matrix from euler angles (X * Y * X).
     *  @see gtx_euler_angles */
    fun eulerAngleXYX(res: Mat4, t1: Float, t2: Float, t3: Float): Mat4 {

        val c1 = cos(t1)
        val s1 = sin(t1)
        val c2 = cos(t2)
        val s2 = sin(t2)
        val c3 = cos(t3)
        val s3 = sin(t3)

        res[0, 0] = c2
        res[0, 1] = s1 * s2
        res[0, 2] = -c1 * s2
        res[0, 3] = 0f
        res[1, 0] = s2 * s3
        res[1, 1] = c1 * c3 - c2 * s1 * s3
        res[1, 2] = c3 * s1 + c1 * c2 * s3
        res[1, 3] = 0f
        res[2, 0] = c3 * s2
        res[2, 1] = -c1 * s3 - c2 * c3 * s1
        res[2, 2] = c1 * c2 * c3 - s1 * s3
        res[2, 3] = 0f
        res[3, 0] = 0f
        res[3, 1] = 0f
        res[3, 2] = 0f
        res[3, 3] = 1f
        return res
    }

    /** Creates a 3D 4 * 4 homogeneous rotation matrix from euler angles (X * Y * X).
     *  @see gtx_euler_angles */
    fun eulerAngleXYX(t1: Float, t2: Float, t3: Float): Mat4 = eulerAngleXYX(Mat4(), t1, t2, t3)

    /** Creates a 3D 4 * 4 homogeneous rotation matrix from euler angles (Y * X * Y).
     *  @see gtx_euler_angles */
    fun eulerAngleYXY(res: Mat4, t1: Float, t2: Float, t3: Float): Mat4 {

        val c1 = cos(t1)
        val s1 = sin(t1)
        val c2 = cos(t2)
        val s2 = sin(t2)
        val c3 = cos(t3)
        val s3 = sin(t3)

        res[0, 0] = c1 * c3 - c2 * s1 * s3
        res[0, 1] = s2 * s3
        res[0, 2] = -c3 * s1 - c1 * c2 * s3
        res[0, 3] = 0f
        res[1, 0] = s1 * s2
        res[1, 1] = c2
        res[1, 2] = c1 * s2
        res[1, 3] = 0f
        res[2, 0] = c1 * s3 + c2 * c3 * s1
        res[2, 1] = -c3 * s2
        res[2, 2] = c1 * c2 * c3 - s1 * s3
        res[2, 3] = 0f
        res[3, 0] = 0f
        res[3, 1] = 0f
        res[3, 2] = 0f
        res[3, 3] = 1f
        return res
    }

    /** Creates a 3D 4 * 4 homogeneous rotation matrix from euler angles (Y * X * Y).
     *  @see gtx_euler_angles */
    fun eulerAngleYXY(t1: Float, t2: Float, t3: Float): Mat4 = eulerAngleYXY(Mat4(), t1, t2, t3)

    /** Creates a 3D 4 * 4 homogeneous rotation matrix from euler angles (Y * Z * Y).
     *  @see gtx_euler_angles */
    fun eulerAngleYZY(res: Mat4, t1: Float, t2: Float, t3: Float): Mat4 {

        val c1 = cos(t1)
        val s1 = sin(t1)
        val c2 = cos(t2)
        val s2 = sin(t2)
        val c3 = cos(t3)
        val s3 = sin(t3)

        res[0, 0] = c1 * c2 * c3 - s1 * s3
        res[0, 1] = c3 * s2
        res[0, 2] = -c1 * s3 - c2 * c3 * s1
        res[0, 3] = 0f
        res[1, 0] = -c1 * s2
        res[1, 1] = c2
        res[1, 2] = s1 * s2
        res[1, 3] = 0f
        res[2, 0] = c3 * s1 + c1 * c2 * s3
        res[2, 1] = s2 * s3
        res[2, 2] = c1 * c3 - c2 * s1 * s3
        res[2, 3] = 0f
        res[3, 0] = 0f
        res[3, 1] = 0f
        res[3, 2] = 0f
        res[3, 3] = 1f
        return res
    }

    /** Creates a 3D 4 * 4 homogeneous rotation matrix from euler angles (Y * Z * Y).
     *  @see gtx_euler_angles */
    fun eulerAngleYZY(t1: Float, t2: Float, t3: Float): Mat4 = eulerAngleYZY(Mat4(), t1, t2, t3)

    /** Creates a 3D 4 * 4 homogeneous rotation matrix from euler angles (Z * Y * Z).
     *  @see gtx_euler_angles */
    fun eulerAngleZYZ(res: Mat4, t1: Float, t2: Float, t3: Float): Mat4 {

        val c1 = cos(t1)
        val s1 = sin(t1)
        val c2 = cos(t2)
        val s2 = sin(t2)
        val c3 = cos(t3)
        val s3 = sin(t3)

        res[0, 0] = c1 * c2 * c3 - s1 * s3
        res[0, 1] = c1 * s3 + c2 * c3 * s1
        res[0, 2] = -c3 * s2
        res[0, 3] = 0f
        res[1, 0] = -c3 * s1 - c1 * c2 * s3
        res[1, 1] = c1 * c3 - c2 * s1 * s3
        res[1, 2] = s2 * s3
        res[1, 3] = 0f
        res[2, 0] = c1 * s2
        res[2, 1] = s1 * s2
        res[2, 2] = c2
        res[2, 3] = 0f
        res[3, 0] = 0f
        res[3, 1] = 0f
        res[3, 2] = 0f
        res[3, 3] = 1f
        return res
    }

    /** Creates a 3D 4 * 4 homogeneous rotation matrix from euler angles (Z * Y * Z).
     *  @see gtx_euler_angles */
    fun eulerAngleZYZ(t1: Float, t2: Float, t3: Float): Mat4 = eulerAngleZYZ(Mat4(), t1, t2, t3)

    /** Creates a 3D 4 * 4 homogeneous rotation matrix from euler angles (Z * X * Z).
     *  @see gtx_euler_angles */
    fun eulerAngleZXZ(res: Mat4, t1: Float, t2: Float, t3: Float): Mat4 {

        val c1 = cos(t1)
        val s1 = sin(t1)
        val c2 = cos(t2)
        val s2 = sin(t2)
        val c3 = cos(t3)
        val s3 = sin(t3)

        res[0, 0] = c1 * c3 - c2 * s1 * s3
        res[0, 1] = c3 * s1 + c1 * c2 * s3
        res[0, 2] = s2 * s3
        res[0, 3] = 0f
        res[1, 0] = -c1 * s3 - c2 * c3 * s1
        res[1, 1] = c1 * c2 * c3 - s1 * s3
        res[1, 2] = c3 * s2
        res[1, 3] = 0f
        res[2, 0] = s1 * s2
        res[2, 1] = -c1 * s2
        res[2, 2] = c2
        res[2, 3] = 0f
        res[3, 0] = 0f
        res[3, 1] = 0f
        res[3, 2] = 0f
        res[3, 3] = 1f
        return res
    }

    /** Creates a 3D 4 * 4 homogeneous rotation matrix from euler angles (Z * X * Z).
     *  @see gtx_euler_angles */
    fun eulerAngleZXZ(t1: Float, t2: Float, t3: Float): Mat4 = eulerAngleZXZ(Mat4(), t1, t2, t3)

    /** Creates a 3D 4 * 4 homogeneous rotation matrix from euler angles (X * Z * Y).
     *  @see gtx_euler_angles */
    fun eulerAngleXZY(res: Mat4, t1: Float, t2: Float, t3: Float): Mat4 {

        val c1 = cos(t1)
        val s1 = sin(t1)
        val c2 = cos(t2)
        val s2 = sin(t2)
        val c3 = cos(t3)
        val s3 = sin(t3)

        res[0, 0] = c2 * c3
        res[0, 1] = s1 * s3 + c1 * c3 * s2
        res[0, 2] = c3 * s1 * s2 - c1 * s3
        res[0, 3] = 0f
        res[1, 0] = -s2
        res[1, 1] = c1 * c2
        res[1, 2] = c2 * s1
        res[1, 3] = 0f
        res[2, 0] = c2 * s3
        res[2, 1] = c1 * s2 * s3 - c3 * s1
        res[2, 2] = c1 * c3 + s1 * s2 * s3
        res[2, 3] = 0f
        res[3, 0] = 0f
        res[3, 1] = 0f
        res[3, 2] = 0f
        res[3, 3] = 1f
        return res
    }

    /** Creates a 3D 4 * 4 homogeneous rotation matrix from euler angles (X * Z * Y).
     *  @see gtx_euler_angles */
    fun eulerAngleXZY(t1: Float, t2: Float, t3: Float): Mat4 = eulerAngleXZY(Mat4(), t1, t2, t3)

    /** Creates a 3D 4 * 4 homogeneous rotation matrix from euler angles (Y * Z * X).
     *  @see gtx_euler_angles */
    fun eulerAngleYZX(res: Mat4, t1: Float, t2: Float, t3: Float): Mat4 {

        val c1 = cos(t1)
        val s1 = sin(t1)
        val c2 = cos(t2)
        val s2 = sin(t2)
        val c3 = cos(t3)
        val s3 = sin(t3)

        res[0, 0] = c1 * c2
        res[0, 1] = s2
        res[0, 2] = -c2 * s1
        res[0, 3] = 0f
        res[1, 0] = s1 * s3 - c1 * c3 * s2
        res[1, 1] = c2 * c3
        res[1, 2] = c1 * s3 + c3 * s1 * s2
        res[1, 3] = 0f
        res[2, 0] = c3 * s1 + c1 * s2 * s3
        res[2, 1] = -c2 * s3
        res[2, 2] = c1 * c3 - s1 * s2 * s3
        res[2, 3] = 0f
        res[3, 0] = 0f
        res[3, 1] = 0f
        res[3, 2] = 0f
        res[3, 3] = 1f
        return res
    }

    /** Creates a 3D 4 * 4 homogeneous rotation matrix from euler angles (Y * Z * X).
     *  @see gtx_euler_angles */
    fun eulerAngleYZX(t1: Float, t2: Float, t3: Float): Mat4 = eulerAngleYZX(Mat4(), t1, t2, t3)

    /** Creates a 3D 4 * 4 homogeneous rotation matrix from euler angles (Z * Y * X).
     *  @see gtx_euler_angles */
    fun eulerAngleZYX(res: Mat4, t1: Float, t2: Float, t3: Float): Mat4 {

        val c1 = cos(t1)
        val s1 = sin(t1)
        val c2 = cos(t2)
        val s2 = sin(t2)
        val c3 = cos(t3)
        val s3 = sin(t3)

        res[0, 0] = c1 * c2
        res[0, 1] = c2 * s1
        res[0, 2] = -s2
        res[0, 3] = 0f
        res[1, 0] = c1 * s2 * s3 - c3 * s1
        res[1, 1] = c1 * c3 + s1 * s2 * s3
        res[1, 2] = c2 * s3
        res[1, 3] = 0f
        res[2, 0] = s1 * s3 + c1 * c3 * s2
        res[2, 1] = c3 * s1 * s2 - c1 * s3
        res[2, 2] = c2 * c3
        res[2, 3] = 0f
        res[3, 0] = 0f
        res[3, 1] = 0f
        res[3, 2] = 0f
        res[3, 3] = 1f
        return res
    }

    /** Creates a 3D 4 * 4 homogeneous rotation matrix from euler angles (Z * Y * X).
     *  @see gtx_euler_angles */
    fun eulerAngleZYX(t1: Float, t2: Float, t3: Float): Mat4 = eulerAngleZYX(Mat4(), t1, t2, t3)

    /** Creates a 3D 4 * 4 homogeneous rotation matrix from euler angles (Z * X * Y).
     *  @see gtx_euler_angles */
    fun eulerAngleZXY(res: Mat4, t1: Float, t2: Float, t3: Float): Mat4 {

        val c1 = cos(t1)
        val s1 = sin(t1)
        val c2 = cos(t2)
        val s2 = sin(t2)
        val c3 = cos(t3)
        val s3 = sin(t3)

        res[0, 0] = c1 * c3 - s1 * s2 * s3
        res[0, 1] = c3 * s1 + c1 * s2 * s3
        res[0, 2] = -c2 * s3
        res[0, 3] = 0f
        res[1, 0] = -c2 * s1
        res[1, 1] = c1 * c2
        res[1, 2] = s2
        res[1, 3] = 0f
        res[2, 0] = c1 * s3 + c3 * s1 * s2
        res[2, 1] = s1 * s3 - c1 * c3 * s2
        res[2, 2] = c2 * c3
        res[2, 3] = 0f
        res[3, 0] = 0f
        res[3, 1] = 0f
        res[3, 2] = 0f
        res[3, 3] = 1f
        return res
    }

    /** Creates a 3D 4 * 4 homogeneous rotation matrix from euler angles (Z * X * Y).
     *  @see gtx_euler_angles */
    fun eulerAngleZXY(t1: Float, t2: Float, t3: Float): Mat4 = eulerAngleZXY(Mat4(), t1, t2, t3)

    /** Creates a 3D 4 * 4 homogeneous rotation matrix from euler angles (Y * X * Z).
     *  @see gtx_euler_angles */
    fun yawPitchRoll(res: Mat4, yaw: Float, pitch: Float, roll: Float): Mat4 {

        val tmpCh = cos(yaw)
        val tmpSh = sin(yaw)
        val tmpCp = cos(pitch)
        val tmpSp = sin(pitch)
        val tmpCb = cos(roll)
        val tmpSb = sin(roll)

        res[0, 0] = tmpCh * tmpCb + tmpSh * tmpSp * tmpSb
        res[0, 1] = tmpSb * tmpCp
        res[0, 2] = -tmpSh * tmpCb + tmpCh * tmpSp * tmpSb
        res[0, 3] = 0f
        res[1, 0] = -tmpCh * tmpSb + tmpSh * tmpSp * tmpCb
        res[1, 1] = tmpCb * tmpCp
        res[1, 2] = tmpSb * tmpSh + tmpCh * tmpSp * tmpCb
        res[1, 3] = 0f
        res[2, 0] = tmpSh * tmpCp
        res[2, 1] = -tmpSp
        res[2, 2] = tmpCh * tmpCp
        res[2, 3] = 0f
        res[3, 0] = 0f
        res[3, 1] = 0f
        res[3, 2] = 0f
        res[3, 3] = 1f
        return res
    }

    /** Creates a 3D 4 * 4 homogeneous rotation matrix from euler angles (Y * X * Z).
     *  @see gtx_euler_angles */
    fun yawPitchRoll(yaw: Float, pitch: Float, roll: Float): Mat4 = yawPitchRoll(Mat4(), yaw, pitch, roll)

    /** Creates a 2D 2 * 2 rotation matrix from an euler angle.
     *  @see gtx_euler_angles */
    fun orientate2(res: Mat2, angle: Float): Mat2 {

        val c = cos(angle)
        val s = sin(angle)

        res[0, 0] = c
        res[0, 1] = s
        res[1, 0] = -s
        res[1, 1] = c
        return res
    }

    /** Creates a 2D 2 * 2 rotation matrix from an euler angle.
     *  @see gtx_euler_angles */
    infix fun orientate2(angle: Float): Mat2 = orientate2(Mat2(), angle)

    /** Creates a 2D 4 * 4 homogeneous rotation matrix from an euler angle.
     *  @see gtx_euler_angles */
    fun orientate3(res: Mat3, angle: Float): Mat3 {

        val c = cos(angle)
        val s = sin(angle)

        res[0, 0] = c
        res[0, 1] = s
        res[0, 2] = 0f
        res[1, 0] = -s
        res[1, 1] = c
        res[1, 2] = 0f
        res[2, 0] = 0f
        res[2, 1] = 0f
        res[2, 2] = 1f
        return res
    }

    /** Creates a 2D 4 * 4 homogeneous rotation matrix from an euler angle.
     *  @see gtx_euler_angles */
    infix fun orientate3(angle: Float): Mat3 = orientate3(Mat3(), angle)

    /** Creates a 3D 3 * 3 rotation matrix from euler angles (Y * X * Z).
     *  @see gtx_euler_angles */
    fun orientate3(res: Mat3, angles: Vec3): Mat3 {

        val tmpCh = cos(angles.z)
        val tmpSh = sin(angles.z)
        val tmpCp = cos(angles.x)
        val tmpSp = sin(angles.x)
        val tmpCb = cos(angles.y)
        val tmpSb = sin(angles.y)

        res[0, 0] = tmpCh * tmpCb + tmpSh * tmpSp * tmpSb
        res[0, 1] = tmpSb * tmpCp
        res[0, 2] = -tmpSh * tmpCb + tmpCh * tmpSp * tmpSb
        res[1, 0] = -tmpCh * tmpSb + tmpSh * tmpSp * tmpCb
        res[1, 1] = tmpCb * tmpCp
        res[1, 2] = tmpSb * tmpSh + tmpCh * tmpSp * tmpCb
        res[2, 0] = tmpSh * tmpCp
        res[2, 1] = -tmpSp
        res[2, 2] = tmpCh * tmpCp
        return res
    }

    /** Creates a 3D 3 * 3 rotation matrix from euler angles (Y * X * Z).
     *  @see gtx_euler_angles */
    infix fun orientate3(angles: Vec3): Mat3 = orientate3(Mat3(), angles)

    /** Creates a 3D 4 * 4 homogeneous rotation matrix from euler angles (Y * X * Z).
     *  @see gtx_euler_angles */
    fun orientate4(res: Mat4, angles: Vec3): Mat4 = yawPitchRoll(res, angles.z, angles.x, angles.y)

    /** Creates a 3D 4 * 4 homogeneous rotation matrix from euler angles (Y * X * Z).
     *  @see gtx_euler_angles */
    infix fun orientate4(angles: Vec3): Mat4 = yawPitchRoll(Mat4(), angles.z, angles.x, angles.y)

    /** Extracts the (X * Y * Z) Euler angles from the rotation matrix M
     *  @see gtx_euler_angles */
    fun extractEulerAngleXYZ(res: Vec3, m: Mat4): Vec3 {
        val t1 = atan2(m[2, 1], m[2, 2])
        val c2 = sqrt(m[0, 0] * m[0, 0] + m[1, 0] * m[1, 0])
        val t2 = atan2(-m[2, 0], c2)
        val s1 = sin(t1)
        val c1 = cos(t1)
        val t3 = atan2(s1 * m[0, 2] - c1 * m[0, 1], c1 * m[1, 1] - s1 * m[1, 2])
        return res(-t1, -t2, -t3)
    }

    /** Extracts the (X * Y * Z) Euler angles from the rotation matrix M
     *  @see gtx_euler_angles */
    infix fun extractEulerAngleXYZ(m: Mat4): Vec3 = extractEulerAngleXYZ(Vec3(), m)

    /** Extracts the (Y * X * Z) Euler angles from the rotation matrix M
     *  @see gtx_euler_angles */
    fun extractEulerAngleYXZ(res: Vec3, m: Mat4): Vec3 {
        val t1 = atan2(m[2, 0], m[2, 2])
        val c2 = sqrt(m[0, 1] * m[0, 1] + m[1, 1] * m[1, 1])
        val t2 = atan2(-m[2, 1], c2)
        val s1 = sin(t1)
        val c1 = cos(t1)
        val t3 = atan2(s1 * m[1, 2] - c1 * m[1, 0], c1 * m[0, 0] - s1 * m[0, 2])
        return res(t1, t2, t3)
    }

    /** Extracts the (Y * X * Z) Euler angles from the rotation matrix M
     *  @see gtx_euler_angles */
    infix fun extractEulerAngleYXZ(m: Mat4): Vec3 = extractEulerAngleYXZ(Vec3(), m)

    /** Extracts the (X * Z * X) Euler angles from the rotation matrix M
     *  @see gtx_euler_angles */
    fun extractEulerAngleXZX(res: Vec3, m: Mat4): Vec3 {
        val t1 = atan2(m[0, 2], m[0, 1])
        val s2 = sqrt(m[1, 0] * m[1, 0] + m[2, 0] * m[2, 0])
        val t2 = atan2(s2, m[0, 0])
        val s1 = sin(t1)
        val c1 = cos(t1)
        val t3 = atan2(c1 * m[1, 2] - s1 * m[1, 1], c1 * m[2, 2] - s1 * m[2, 1])
        return res(t1, t2, t3)
    }

    /** Extracts the (X * Z * X) Euler angles from the rotation matrix M
     *  @see gtx_euler_angles */
    infix fun extractEulerAngleXZX(m: Mat4): Vec3 = extractEulerAngleXZX(Vec3(), m)

    /** Extracts the (X * Y * X) Euler angles from the rotation matrix M
     *  @see gtx_euler_angles */
    fun extractEulerAngleXYX(res: Vec3, m: Mat4): Vec3 {
        val t1 = atan2(m[0, 1], -m[0, 2])
        val s2 = sqrt(m[1, 0] * m[1, 0] + m[2, 0] * m[2, 0])
        val t2 = atan2(s2, m[0, 0])
        val s1 = sin(t1)
        val c1 = cos(t1)
        val t3 = atan2(-c1 * m[2, 1] - s1 * m[2, 2], c1 * m[1, 1] + s1 * m[1, 2])
        return res(t1, t2, t3)
    }

    /** Extracts the (X * Y * X) Euler angles from the rotation matrix M
     *  @see gtx_euler_angles */
    infix fun extractEulerAngleXYX(m: Mat4): Vec3 = extractEulerAngleXYX(Vec3(), m)

    /** Extracts the (Y * X * Y) Euler angles from the rotation matrix M
     *  @see gtx_euler_angles */
    fun extractEulerAngleYXY(res: Vec3, m: Mat4): Vec3 {
        val t1 = atan2(m[1, 0], m[1, 2])
        val s2 = sqrt(m[0, 1] * m[0, 1] + m[2, 1] * m[2, 1])
        val t2 = atan2(s2, m[1, 1])
        val s1 = sin(t1)
        val c1 = cos(t1)
        val t3 = atan2(c1 * m[2, 0] - s1 * m[2, 2], c1 * m[0, 0] - s1 * m[0, 2])
        return res(t1, t2, t3)
    }

    /** Extracts the (Y * X * Y) Euler angles from the rotation matrix M
     *  @see gtx_euler_angles */
    infix fun extractEulerAngleYXY(m: Mat4): Vec3 = extractEulerAngleYXY(Vec3(), m)

    /** Extracts the (Y * Z * Y) Euler angles from the rotation matrix M
     *  @see gtx_euler_angles */
    fun extractEulerAngleYZY(res: Vec3, m: Mat4): Vec3 {
        val t1 = atan2(m[1, 2], -m[1, 0])
        val s2 = sqrt(m[0, 1] * m[0, 1] + m[2, 1] * m[2, 1])
        val t2 = atan2(s2, m[1, 1])
        val s1 = sin(t1)
        val c1 = cos(t1)
        val t3 = atan2(-s1 * m[0, 0] - c1 * m[0, 2], s1 * m[2, 0] + c1 * m[2, 2])
        return res(t1, t2, t3)
    }

    /** Extracts the (Y * Z * Y) Euler angles from the rotation matrix M
     *  @see gtx_euler_angles */
    infix fun extractEulerAngleYZY(m: Mat4): Vec3 = extractEulerAngleYZY(Vec3(), m)

    /** Extracts the (Z * Y * Z) Euler angles from the rotation matrix M
     *  @see gtx_euler_angles */
    fun extractEulerAngleZYZ(res: Vec3, m: Mat4): Vec3 {
        val t1 = atan2(m[2, 1], m[2, 0])
        val s2 = sqrt(m[0, 2] * m[0, 2] + m[1, 2] * m[1, 2])
        val t2 = atan2(s2, m[2, 2])
        val s1 = sin(t1)
        val c1 = cos(t1)
        val t3 = atan2(c1 * m[0, 1] - s1 * m[0, 0], c1 * m[1, 1] - s1 * m[1, 0])
        return res(t1, t2, t3)
    }

    /** Extracts the (Z * Y * Z) Euler angles from the rotation matrix M
     *  @see gtx_euler_angles */
    infix fun extractEulerAngleZYZ(m: Mat4): Vec3 = extractEulerAngleZYZ(Vec3(), m)

    /** Extracts the (Z * X * Z) Euler angles from the rotation matrix M
     *  @see gtx_euler_angles */
    fun extractEulerAngleZXZ(res: Vec3, m: Mat4): Vec3 {
        val t1 = atan2(m[2, 0], -m[2, 1])
        val s2 = sqrt(m[0, 2] * m[0, 2] + m[1, 2] * m[1, 2])
        val t2 = atan2(s2, m[2, 2])
        val s1 = sin(t1)
        val c1 = cos(t1)
        val t3 = atan2(-c1 * m[1, 0] - s1 * m[1, 1], c1 * m[0, 0] + s1 * m[0, 1])
        return res(t1, t2, t3)
    }

    /** Extracts the (Z * X * Z) Euler angles from the rotation matrix M
     *  @see gtx_euler_angles */
    infix fun extractEulerAngleZXZ(m: Mat4): Vec3 = extractEulerAngleZXZ(Vec3(), m)

    /** Extracts the (X * Z * Y) Euler angles from the rotation matrix M
     *  @see gtx_euler_angles */
    fun extractEulerAngleXZY(res: Vec3, m: Mat4): Vec3 {
        val t1 = atan2(m[1, 2], m[1, 1])
        val c2 = sqrt(m[0, 0] * m[0, 0] + m[2, 0] * m[2, 0])
        val t2 = atan2(-m[1, 0], c2)
        val s1 = sin(t1)
        val c1 = cos(t1)
        val t3 = atan2(s1 * m[0, 1] - c1 * m[0, 2], c1 * m[2, 2] - s1 * m[2, 1])
        return res(t1, t2, t3)
    }

    /** Extracts the (X * Z * Y) Euler angles from the rotation matrix M
     *  @see gtx_euler_angles */
    infix fun extractEulerAngleXZY(m: Mat4): Vec3 = extractEulerAngleXZY(Vec3(), m)

    /** Extracts the (Y * Z * X) Euler angles from the rotation matrix M
     *  @see gtx_euler_angles */
    fun extractEulerAngleYZX(res: Vec3, m: Mat4): Vec3 {
        val t1 = atan2(-m[0, 2], m[0, 0])
        val c2 = sqrt(m[1, 1] * m[1, 1] + m[2, 1] * m[2, 1])
        val t2 = atan2(m[0, 1], c2)
        val s1 = sin(t1)
        val c1 = cos(t1)
        val t3 = atan2(s1 * m[1, 0] + c1 * m[1, 2], s1 * m[2, 0] + c1 * m[2, 2])
        return res(t1, t2, t3)
    }

    /** Extracts the (Y * Z * X) Euler angles from the rotation matrix M
     *  @see gtx_euler_angles */
    infix fun extractEulerAngleYZX(m: Mat4): Vec3 = extractEulerAngleYZX(Vec3(), m)

    /** Extracts the (Z * Y * X) Euler angles from the rotation matrix M
     *  @see gtx_euler_angles */
    fun extractEulerAngleZYX(res: Vec3, m: Mat4): Vec3 {
        val t1 = atan2(m[0, 1], m[0, 0])
        val c2 = sqrt(m[1, 2] * m[1, 2] + m[2, 2] * m[2, 2])
        val t2 = atan2(-m[0, 2], c2)
        val s1 = sin(t1)
        val c1 = cos(t1)
        val t3 = atan2(s1 * m[2, 0] - c1 * m[2, 1], c1 * m[1, 1] - s1 * m[1, 0])
        return res(t1, t2, t3)
    }

    /** Extracts the (Z * Y * X) Euler angles from the rotation matrix M
     *  @see gtx_euler_angles */
    infix fun extractEulerAngleZYX(m: Mat4): Vec3 = extractEulerAngleZYX(Vec3(), m)

    /** Extracts the (Z * X * Y) Euler angles from the rotation matrix M
     *  @see gtx_euler_angles */
    fun extractEulerAngleZXY(res: Vec3, m: Mat4): Vec3 {
        val t1 = atan2(-m[1, 0], m[1, 1])
        val c2 = sqrt(m[0, 2] * m[0, 2] + m[2, 2] * m[2, 2])
        val t2 = atan2(m[1, 2], c2)
        val s1 = sin(t1)
        val c1 = cos(t1)
        val t3 = atan2(c1 * m[2, 0] + s1 * m[2, 1], c1 * m[0, 0] + s1 * m[0, 1])
        return res(t1, t2, t3)
    }

    /** Extracts the (Z * X * Y) Euler angles from the rotation matrix M
     *  @see gtx_euler_angles */
    infix fun extractEulerAngleZXY(m: Mat4): Vec3 = extractEulerAngleZXY(Vec3(), m)
}