package glm_.ext

import glm_.glm
import glm_.mat4.Mat4
import glm_.mat4.Mat4d
import glm_.shouldEqual
import glm_.vec2.Vec2
import glm_.vec3.Vec3
import glm_.vec3.Vec3d
import glm_.vec4.Vec4
import glm_.vec4.Vec4d
import kotlin.test.Test

class matrixProjection {

    @Test
    fun project() {
        run {
            val obj = Vec3(0, 1, 2)
            val model = Mat4(3, 4, 5, 6,
                             7, 8, 9, 10,
                             11, 12, 13, 14,
                             15, 16, 17, 18)
            val proj = Mat4(19, 20, 21, 22,
                            23, 24, 25, 26,
                            27, 28, 29, 30,
                            31, 32, 33, 34)
            val vp = Vec4(35, 36, 37, 38)
            val win = glm.project(obj, model, proj, vp)
            win.shouldEqual(Vec3(70.04578f, 72.66197f, 0.982394f), 0.0001f)
        }
        run {
            val obj = Vec3d(0, 1, 2)
            val model = Mat4d(3, 4, 5, 6,
                             7, 8, 9, 10,
                             11, 12, 13, 14,
                             15, 16, 17, 18)
            val proj = Mat4d(19, 20, 21, 22,
                            23, 24, 25, 26,
                            27, 28, 29, 30,
                            31, 32, 33, 34)
            val vp = Vec4d(35, 36, 37, 38)
            val w = glm.project(obj, model, proj, vp)
            w.shouldEqual(Vec3d(70.045775, 72.661972, 0.982394), 0.00001)
        }
    }

    @Test
    fun pickMatrix() {
        val region = glm.pickMatrix(Vec2(10, 20), Vec2(30, 40), Vec4(50, 60, 70, 80))
        region.shouldEqual(Mat4(2.333333f, 0f, 0f, 0f,
                                0f, 2f, 0f, 0f,
                                0f, 0f, 1f, 0f,
                                5f, 4f, 0f, 1f), 0.00001f)
    }
}