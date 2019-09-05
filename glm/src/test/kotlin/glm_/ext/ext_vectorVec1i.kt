package glm_.ext

import glm_.BYTES
import glm_.vec1.Vec1i
import glm_.vec2.Vec2i
import glm_.vec3.Vec3i
import glm_.vec4.Vec4i
import io.kotlintest.should
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class ext_vectorVec1i : StringSpec() {

    init {

        "test operators"        {

            run {
                val A = Vec1i(1)
                val B = Vec1i(1)

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
                val A = Vec1i(3)
                val B = Vec1i(2)

                val C = A % B
                C shouldBe Vec1i(1)
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
                E shouldBe Vec1i(1)
                val F = A or C
                F shouldBe Vec1i(1)

                val G = A xor B
                G shouldBe Vec1i(0)
                val H = A xor C
                H shouldBe Vec1i(1)
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
        }

        "test ctor"        {

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

        "test size"        {
            Vec1i.size shouldBe Int.BYTES
            Vec1i.length shouldBe 1
        }

        "test relational"        {

            val A = Vec1i(1)
            val B = Vec1i(1)
            val C = Vec1i(0)

            A shouldBe B
            (A != C) shouldBe true
            A.equal(B) shouldBe true
            A.notEqual(C) shouldBe true
        }

        "test constexpr"        {

            Vec1i.length shouldBe 1
            Vec1i(1)[0] shouldBe 1
            Vec1i(1) shouldBe Vec1i(Vec1i(1))
            (Vec1i(1) != Vec1i(0)) shouldBe true
        }
    }
}