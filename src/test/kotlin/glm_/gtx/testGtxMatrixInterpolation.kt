package glm_.gtx

import glm_.glm
import glm_.mat4x4.Mat4
import glm_.vec3.Vec3
import io.kotlintest.specs.StringSpec

class testGtxMatrixInterpolation : StringSpec() {

    init {

        "axisAngle" {

            val p = 0.171654f
            val m1 = Mat4(-0.9946f, 0f, -0.104531f, 0f,
                    0f, 1f, 0f, 0f,
                    0.104531f, 0f, -0.9946f, 0f,
                    0f, 0f, 0f, 1f)
            val m2 = Mat4(-0.992624f, 0f, -0.121874f, 0f,
                    0f, 1f, 0f, 0f,
                    0.121874f, 0f, -0.992624f, 0f,
                    0f, 0f, 0f, 1f)

            val m1rot = glm.extractMatrixRotation(m1)
            val dltRotation = m2 * m1rot.transpose()

            val dltAxis = Vec3()
            val dltAngle = glm.axisAngle(dltRotation, dltAxis)

            println("dltAngle: $dltAxis, dltAngle: $dltAngle")

            val q = dltRotation.toQuat()
            println("q: $q")
            val yaw = glm.yaw(q)
            println("Yaw: $yaw")
        }
    }
}