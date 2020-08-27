package glm_.ext

import glm_.shouldEqual
import glm_.vec1.Vec1
import glm_.vec1.Vec1d
import glm_.vec2.Vec2
import glm_.vec2.Vec2d
import glm_.vec3.Vec3
import glm_.vec3.Vec3d
import glm_.vec4.Vec4
import glm_.vec4.Vec4d
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import io.kotest.core.spec.style.StringSpec
import kool.BYTES

class test_ext_vectorIEC559 : StringSpec() {

    init {

        "operators"        {

            run {
                val A = Vec1d(1)
                val B = Vec1d(1)

                val C = A + B
                C shouldEqual Vec1d(2)

                val D = A - B
                D shouldEqual Vec1d(0)

                val E = A * B
                E shouldEqual Vec1d(1)

                val F = A / B
                F shouldEqual Vec1d(1)
            }

            run {
                val A = Vec1(1)
                val B = Vec1(1)

                val C = A + B
                C shouldEqual Vec1(2)

                val D = A - B
                D shouldEqual Vec1(0)

                val E = A * B
                E shouldEqual Vec1(1)

                val F = A / B
                F shouldEqual Vec1(1)
            }
        }

        "ctor" {

            run {

                val A = Vec1d(1)

                val E = Vec1d(1.0)
                A shouldEqual E

                val F = Vec1d(E)
                A shouldEqual F

                val B = Vec1d(1)
                val G = Vec1d(Vec2d(1))
                B shouldEqual G

                val H = Vec1d(Vec3d(1))
                B shouldEqual H

                val I = Vec1d(Vec4d(1))
                B shouldEqual I
            }

            run {

                val A = Vec1(1)

                val E = Vec1(1.0)
                A shouldEqual E

                val F = Vec1(E)
                A shouldEqual F

                val B = Vec1(1)
                val G = Vec1(Vec2(1))
                B shouldEqual G

                val H = Vec1(Vec3(1))
                B shouldEqual H

                val I = Vec1(Vec4(1))
                B shouldEqual I
            }
        }

        "size" {
            run {
                Vec1d.size shouldBe Double.BYTES
                Vec1d.length shouldBe 1
            }
            run {
                Vec1.size shouldBe Float.BYTES
                Vec1.length shouldBe 1
            }
        }

        "relational" {
            run {
                val A = Vec1d(1)
                val B = Vec1d(1)
                val C = Vec1d(0)

                A shouldEqual B
                A shouldNotBe C
            }
            run {
                val A = Vec1(1)
                val B = Vec1(1)
                val C = Vec1(0)

                A shouldEqual B
                A shouldNotBe C
            }
        }
    }
}