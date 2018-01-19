package glm_

import glm_.mat4x4.Mat4
import glm_.quat.Quat
import glm_.vec3.Vec3
import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.StringSpec

class matInterpolation : StringSpec() {

    init {
        "matrix interpolation" {

            val p = 0.171654f
            val m1 = Mat4(
                    -0.9946f, 0.0f, -0.104531f, 0.0f,
                    0.0f, 1.0f, 0.0f, 0.0f,
                    0.104531f, 0.0f, -0.9946f, 0.0f,
                    0.0f, 0.0f, 0.0f, 1.0f)
            val m2 = Mat4(
                    -0.992624f, 0.0f, -0.121874f, 0.0f,
                    0.0f, 1.0f, 0.0f, 0.0f,
                    0.121874f, 0.0f, -0.992624f, 0.0f,
                    0.0f, 0.0f, 0.0f, 1.0f)

            val m1rot = glm.extractMatrixRotation(m1)
            val dltRotation = m2 * m1rot.transpose()

            val dltAxis = Vec3()
            val dltAngle = glm.axisAngle(dltRotation, dltAxis)

            dltAxis shouldBe Vec3(0f, -1f, 0f)
            dltAngle shouldBe 0.7853982f

            val q = dltRotation.toQuat()
            q shouldBe Quat(1.0000008f, 0f, -0.008727945f, 0f)
            val yaw = glm.yaw(q)
            yaw shouldBe -0.017456792f
        }
    }
}