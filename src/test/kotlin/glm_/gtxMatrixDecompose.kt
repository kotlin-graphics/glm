package glm_

import glm_.mat4x4.Mat4
import glm_.quat.Quat
import glm_.vec3.Vec3
import glm_.vec4.Vec4
import io.kotlintest.specs.StringSpec

class gtxMatrixDecompose : StringSpec() {

    init {

        "gtx matrix decompose" {

            val matrix = Mat4(1)

            val scale = Vec3()
            val orientation = Quat()
            val translation = Vec3()
            val skew = Vec3(1)
            val perspective = Vec4(1)

            glm.decompose(matrix, scale, orientation, translation, skew, perspective)
        }
    }
}