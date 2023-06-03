package glm_.ext

import glm_.BYTES
import glm_.vec1.Vec1i
import glm_.vec1.Vec1ui
import glm_.vec2.Vec2i
import glm_.vec2.Vec2ui
import glm_.vec3.Vec3i
import glm_.vec3.Vec3ui
import glm_.vec4.Vec4i
import glm_.vec4.Vec4ui
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import kool.BYTES
import unsigned.Uint

class test_ext_vectorInteger : StringSpec() {

    init {

        "operators" {

            run {
                val A = Vec1i(1)
                val B = Vec1i(1)

                val R = A != B
                val S = A == B
                (S && !R) shouldBe true
            }

            run {
                val A = Vec1ui(1)
                val B = Vec1ui(1)

                val R = A != B
                val S = A == B
                (S && !R) shouldBe true
            }

            run {
                val A = Vec1i(1)
                val B = Vec1i(1)

                val C = A + B
                C shouldBe Vec1i(2)

                val D = A - B
                D shouldBe Vec1i(0)

                val E = A * B
                E shouldBe Vec1i(1)

                val F = A / B
                F shouldBe Vec1i(1)
            }

            run {
                val A = Vec1ui(1)
                val B = Vec1ui(1)

                val C = A + B
                C shouldBe Vec1ui(2)

                val D = A - B
                D shouldBe Vec1ui(0)

                val E = A * B
                E shouldBe Vec1ui(1)

                val F = A / B
                F shouldBe Vec1ui(1)
            }

            run {
                val A = Vec1i(3)
                val B = Vec1i(2)

                val C = A % B
                C shouldBe Vec1i(1)
            }

            run {
                val A = Vec1ui(3)
                val B = Vec1ui(2)

                val C = A % B
                C shouldBe Vec1ui(1)
            }

            run {
                val A = Vec1i(1)
                val B = Vec1i(1)
                val C = Vec1i(0)

                val I = A and B
                I shouldBe Vec1i(1)
                val D = A and C
                D shouldBe Vec1i(0)

                val E = A or B
                E == Vec1i(1)
                val F = A or C
                F shouldBe Vec1i(1)

                val G = A xor B
                G shouldBe Vec1i(0)
                val H = A xor C
                H shouldBe Vec1i(1)
            }

            run {
                val A = Vec1ui(1)
                val B = Vec1ui(1)
                val C = Vec1ui(0)

                val I = A and B
                I shouldBe Vec1ui(1)
                val D = A and C
                D shouldBe Vec1ui(0)

                val E = A or B
                E == Vec1ui(1)
                val F = A or C
                F shouldBe Vec1ui(1)

                val G = A xor B
                G shouldBe Vec1ui(0)
                val H = A xor C
                H shouldBe Vec1ui(1)
            }

            run {
                val A = Vec1i(0)
                val B = Vec1i(1)
                val C = Vec1i(2)

                val D = B shl B
                D shouldBe Vec1i(2)
                val E = C shr B
                E shouldBe Vec1i(1)
            }

            run {
                val A = Vec1ui(0)
                val B = Vec1ui(1)
                val C = Vec1ui(2)

                val D = B shl B
                D shouldBe Vec1ui(2)
                val E = C shr B
                E shouldBe Vec1ui(1)
            }
        }

        "ctor" {

            run {
                val A = Vec1i(1)

                val E = Vec1i(Vec1i(1))
                A shouldBe E

                val F = Vec1i(E)
                A shouldBe F

                val B = Vec1i(1)
                val G = Vec1i(Vec2i(1))
                B shouldBe G

                val H = Vec1i(Vec3i(1))
                B shouldBe H

                val I = Vec1i(Vec4i(1))
                B shouldBe I
            }

            run {
                val A = Vec1ui(1)

                val E = Vec1ui(Vec1ui(1))
                A shouldBe E

                val F = Vec1ui(E)
                A shouldBe F

                val B = Vec1ui(1)
                val G = Vec1ui(Vec2ui(1))
                B shouldBe G

                val H = Vec1ui(Vec3ui(1))
                B shouldBe H

                val I = Vec1ui(Vec4ui(1))
                B shouldBe I
            }
        }

        "size" {
            run {
                Vec1i.size shouldBe Int.BYTES
                Vec1i.length shouldBe 1
            }
            run {
                Vec1ui.size shouldBe Uint.BYTES
                Vec1ui.length shouldBe 1
            }
        }

        "relational" {
            run {
                val A = Vec1i(1)
                val B = Vec1i(1)
                val C = Vec1i(0)

                A shouldBe B
                A shouldNotBe C
            }
            run {
                val A = Vec1ui(1)
                val B = Vec1ui(1)
                val C = Vec1ui(0)

                A shouldBe B
                A shouldNotBe C
            }
        }
    }
}
