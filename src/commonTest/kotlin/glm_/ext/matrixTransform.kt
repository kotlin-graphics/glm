package glm_.ext

import glm_.mat4.Mat4
import glm_.scalar.rad
import glm_.shouldEqual
import glm_.vec3.Vec3
import glm_.vec4.Vec4
import kotlin.test.Test

class matrixTransform {
    @Test
    fun translate() {

        run {
            val m = Mat4(1f)
            val v = Vec3(1f)

            val t = m translate v
            println(t[3])
            t[3] shouldEqual Vec4(1f)
        }
        run {
            val v = Vec3(1.0)
            val m = Mat4(0)
            val t = m translate v

            t shouldEqual Mat4(0f)

            v.put(1f, 2f, 3f)
            m put 4f
            val u = m translate v

            u shouldEqual Mat4(
                4f, 0f, 0f, 0f,
                0f, 4f, 0f, 0f,
                0f, 0f, 4f, 0f,
                4f, 8f, 12f, 4f)
        }
    }

    @Test
    fun scale() {

        val m = Mat4(1f)
        val v = Vec3(2f)

        val s = m scale v
        val r = Mat4(
            2, 0, 0, 0,
            0, 2, 0, 0,
            0, 0, 2, 0,
            0, 0, 0, 1)
        s shouldEqual r
    }

    @Test
    fun rotate() {

        run {
            val a = Vec4(1f, 0f, 0f, 1f)

            val r = Mat4(1f).rotate(90f.rad, Vec3(0, 0, 1))
            val b = r * a
            b.shouldEqual(Vec4(0f, 1f, 0f, 1f), 0.0001f)
        }
    }

//    "rotate XYZ" {
//
//        val mat = Mat4(
//            0f, 1f, 2f, 3f,
//            4f, 5f, 6f, 7f,
//            8f, 9f, 10f, 11f,
//            12f, 13f, 14f, 15f)
//
//        val rotate = glm.rotateXYZ(mat, 16f.rad, (17f + 90f).rad, (18f + 180f).rad)
//
//        rotate shouldBe Mat4(
//            4.121773f, 4.6411877f, 5.1606007f, 5.680016f,
//            -7.7007446f, -9.170065f, -10.639385f, -12.108706f,
//            -1.9260118f, -1.1701641f, -0.41431677f, 0.3415308f,
//            12f, 13f, 14f, 15f)
//    }
}