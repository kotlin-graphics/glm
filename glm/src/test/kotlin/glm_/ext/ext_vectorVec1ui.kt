package glm_.ext

import glm_.BYTES
import glm_.vec1.Vec1ui
import glm_.vec2.Vec2ui
import glm_.vec3.Vec3ui
import glm_.vec4.Vec4ui
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec
import unsigned.Uint

class ext_vectorVec1ui : StringSpec() {

    init {
        "test operators"        {
            run {
                val A = Vec1ui(1)
                val B = Vec1ui(1)
                val R = A != B
                val S = A == B
                (S && !R) shouldBe true
            }
            run {
                val A = Vec1ui(1)
                val B = Vec1ui(1)
                val C = A + B
                (C == Vec1ui(2)) shouldBe true
                val D = A - B
                (D == Vec1ui(0)) shouldBe true
                val E = A * B
                (E == Vec1ui(1)) shouldBe true
                val F = A / B
                (F == Vec1ui(1)) shouldBe true
            }

            run {
                val A = Vec1ui(3)
                val B = Vec1ui(2)

                val C = A % B
                (C == Vec1ui(1)) shouldBe true
            }

            run {
                val A = Vec1ui(1)
                val B = Vec1ui(1)
                val C = Vec1ui(0)

                val I = A and B
                (I == Vec1ui(1)) shouldBe true
                val D = A and C
                (D == Vec1ui(0)) shouldBe true

                val E = A or B
                (E == Vec1ui(1)) shouldBe true
                val F = A or C
                (F == Vec1ui(1)) shouldBe true

                val G = A xor B
                (G == Vec1ui(0)) shouldBe true
                val H = A xor C
                (H == Vec1ui(1)) shouldBe true
            }

            run {
                val A = Vec1ui(0)
                val B = Vec1ui(1)
                val C = Vec1ui(2)

                val D = B shl B
                (D == Vec1ui(2)) shouldBe true
                val E = C shr B
                (E == Vec1ui(1)) shouldBe true
            }
        }

        "test ctor"        {

            val A = Vec1ui(1)
            val E = Vec1ui(Vec1ui(1))
            (A == E) shouldBe true
            val F = Vec1ui(E)
            (A == F) shouldBe true
            val B = Vec1ui(1)
            val G = Vec1ui(Vec2ui(1))
            (B == G) shouldBe true
            val H = Vec1ui(Vec3ui(1))
            (B == H) shouldBe true
            val I = Vec1ui(Vec4ui(1))
            (B == I) shouldBe true
        }
        "test size"        {
            Vec1ui.size shouldBe Uint.BYTES
            Vec1ui.length shouldBe 1
        }

        "test relational"        {

            val A = Vec1ui(1)
            val B = Vec1ui(1)
            val C = Vec1ui(0)
            (A == B) shouldBe true
            (A != C) shouldBe true
            A.equal(B) shouldBe true
            A.notEqual(C) shouldBe true
        }

        "test constexpr"        {

            Vec1ui.length shouldBe 1
            Vec1ui(1)[0].v shouldBe 1
            (Vec1ui(1) == Vec1ui(Vec1ui(1))) shouldBe true
            (Vec1ui(1) != Vec1ui(0)) shouldBe true
        }
    }
}