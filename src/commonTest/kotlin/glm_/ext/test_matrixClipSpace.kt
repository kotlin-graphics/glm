package glm_.ext

import glm_.glm
import glm_.mat4.Mat4
import glm_.shouldEqual
import kotlin.test.Test

class test_matrixClipSpace {

    @Test
    fun ortho() {

        val ortho = glm.ortho(0f, 1f, 2f, 3f, 4f, 5f)

        ortho shouldEqual Mat4(
            2f, 0f, 0f, 0f,
            0f, 2f, 0f, 0f,
            0f, 0f, -2f, 0f,
            -1f, -5f, -9f, 1f)
    }

    @Test
    fun frustum() {

        val frustum = glm.frustum(0f, 1f, 2f, 3f, 4f, 5f)

        frustum shouldEqual Mat4(
            8f, 0f, 0f, 0f,
            0f, 8f, 0f, 0f,
            1f, 5f, -9f, -1f,
            0f, 0f, -40f, 0f)
    }

    @Test
    fun perspective() {

        val projection = glm.perspective(glm.pi.f * 0.25f, 4f / 3f, 0.1f, 100f)

        projection shouldEqual Mat4(
            1.8106601f, 0f, 0f, 0f,
            0f, 2.4142134f, 0f, 0f,
            0f, 0f, -1.002002f, -1f,
            0f, 0f, -0.2002002f, 0f)
    }

    @Test
    fun infinitePerspective() {

        val a = glm.infinitePerspective(45f, 640f / 480f, 1f)

        a.shouldEqual(Mat4(
            1.3444432f, 0f, 0f, 0f,
            0f, 1.792591f, 0f, 0f,
            0f, 0f, -0.9999999f, -1f,
            0f, 0f, -1.9999999f, 0f), 0.001f)
    }
    @Test
    fun tweakedInfinitePerspective() {

        val projectionA = glm.tweakedInfinitePerspective(45f, 640f / 480f, 1f)
        val projectionB = glm.tweakedInfinitePerspective(45f, 640f / 480f, 1f, 0.001f)

        projectionA.shouldEqual(Mat4(
            1.3444432f, 0f, 0f, 0f,
            0f, 1.792591f, 0f, 0f,
            0f, 0f, -0.9999999f, -1f,
            0f, 0f, -1.9999999f, 0f), 0.001f)

        projectionB.shouldEqual(Mat4(
            1.3444432f, 0f, 0f, 0f,
            0f, 1.792591f, 0f, 0f,
            0f, 0f, -0.999f, -1f,
            0f, 0f, -1.999f, 0f), 0.001f)
    }
}