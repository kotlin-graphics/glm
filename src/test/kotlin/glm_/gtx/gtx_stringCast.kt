package glm_.gtx

import glm_.dualQuat.DualQuat
import glm_.mat2x2.Mat2
import glm_.quat.Quat
import glm_.vec1.*
import glm_.vec2.*
import glm_.vec3.*
import glm_.vec4.*
import io.kotest.matchers.shouldBe
import io.kotest.core.spec.style.StringSpec

class gtx_stringCast : StringSpec() {

    init {

        "string cast vector"        { // TODO format

            run {
                Vec1(1).toString() shouldBe "(1.0)"

                val A1 = Vec2(1, 2)
                val A2 = A1.toString()
                A2 shouldBe "(1.0, 2.0)"

                val B1 = Vec3(1, 2, 3)
                val B2 = B1.toString()
                B2 shouldBe "(1.0, 2.0, 3.0)"
                val C1 = Vec4(1, 2, 3, 4)
                val C2 = C1.toString()
                C2 shouldBe "(1.0, 2.0, 3.0, 4.0)"

                val J1 = Vec2d(1, 2)
                val J2 = J1.toString()
                J2 shouldBe "(1.0, 2.0)"

                val K1 = Vec3d(1, 2, 3)
                val K2 = K1.toString()
                K2 shouldBe "(1.0, 2.0, 3.0)"

                val L1 = Vec4d(1, 2, 3, 4)
                val L2 = L1.toString()
                L2 shouldBe "(1.0, 2.0, 3.0, 4.0)"
            }
            run {
                Vec1bool(false).toString() shouldBe "(false)"

                val M1 = Vec2bool(false, true)
                val M2 = M1.toString()
                M2 shouldBe "(false, true)"

                val O1 = Vec3bool(false, true, false)
                val O2 = O1.toString()
                O2 shouldBe "(false, true, false)"
                val P1 = Vec4bool(false, true, false, true)
                val P2 = P1.toString()
                P2 shouldBe "(false, true, false, true)"
            }
            run {
                Vec1i(1).toString() shouldBe "(1)"

                val D1 = Vec2i(1, 2)
                val D2 = D1.toString()
                D2 shouldBe "(1, 2)"

                val E1 = Vec3i(1, 2, 3)
                val E2 = E1.toString()
                E2 shouldBe "(1, 2, 3)"

                val F1 = Vec4i(1, 2, 3, 4)
                val F2 = F1.toString()
                F2 shouldBe "(1, 2, 3, 4)"
            }
            run {
                Vec1b(1).toString() shouldBe "(1)"

                val D1 = Vec2b(1, 2)
                val D2 = D1.toString()
                D2 shouldBe "(1, 2)"

                val E1 = Vec3b(1, 2, 3)
                val E2 = E1.toString()
                E2 shouldBe "(1, 2, 3)"

                val F1 = Vec4b(1, 2, 3, 4)
                val F2 = F1.toString()
                F2 shouldBe "(1, 2, 3, 4)"
            }
            run {
                Vec1s(1).toString() shouldBe "(1)"

                val D1 = Vec2s(1,2)
                val D2 = D1.toString()
                D2 shouldBe "(1, 2)"

                val E1 = Vec3s(1, 2, 3)
                val E2 = E1.toString()
                E2 shouldBe "(1, 2, 3)"

                val F1 = Vec4s(1, 2, 3, 4)
                val F2 = F1.toString()
                F2 shouldBe "(1, 2, 3, 4)"
            }
            run {
                Vec1l(1).toString() shouldBe "(1)"

                val D1 = Vec2l(1, 2)
                val D2 = D1.toString()
                D2 shouldBe "(1, 2)"

                val E1 = Vec3l(1, 2, 3)
                val E2 = E1.toString()
                E2 shouldBe "(1, 2, 3)"

                val F1 = Vec4l(1, 2, 3, 4)
                val F2 = F1.toString()
                F2 shouldBe "(1, 2, 3, 4)"
            }
        }
        "string cast matrix"        {

            val A1 = Mat2(1.000000, 2.000000, 3.000000, 4.000000)
            val A2 = A1.toString()
            val a = """
                |1.0 3.0
                |2.0 4.0""".trimMargin()
//            A2 shouldBe "((1.000000, 2.000000), (3.000000, 4.000000))"
        }
        "string cast quaternion"        {

            val Q0 = Quat(1f, 2f, 3f, 4f)
            val S0 = Q0.toString()
            S0 shouldBe "(1.0, {2.0, 3.0, 4.0})"
        }

        "string cast dual quaternion"        {

            val Q0 = DualQuat(1f, 2f, 3f, 4f, 5f, 6f, 7f, 8f)
            val S0 = Q0.toString()
            S0 shouldBe "((1.0, {2.0, 3.0, 4.0}), (5.0, {6.0, 7.0, 8.0}))"
        }
    }
}