package glm_.ext

import glm_.func.rad
import glm_.glm
import glm_.mat4x4.Mat4
import glm_.shouldEqual
import glm_.vec3.Vec3
import glm_.vec4.Vec4
import io.kotest.core.spec.style.StringSpec

class test_ext_matrixTransform : StringSpec() {

    init {
        "translate" {

            val M = Mat4(1f)
            val V = Vec3(1f)

            val T = M translate V
            T[3] shouldEqual Vec4(1f)
        }

        "scale" {

            val M = Mat4(1f)
            val V = Vec3(2f)

            val S = M scale V
            val R = Mat4(
                    2, 0, 0, 0,
                    0, 2, 0, 0,
                    0, 0, 2, 0,
                    0, 0, 0, 1)
            S shouldEqual R
        }

        "rotate" {

            val A = Vec4(1f, 0f, 0f, 1f)

            val R = glm.rotate(Mat4(1f), 90f.rad, Vec3(0, 0, 1))
            val B = R * A
            B.shouldEqual(Vec4(0f, 1f, 0f, 1f), 0.0001f)
        }
    }
}