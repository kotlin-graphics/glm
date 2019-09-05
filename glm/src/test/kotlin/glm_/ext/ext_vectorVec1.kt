package glm_.ext

import glm_.BYTES
import glm_.glm
import glm_.vec1.Vec1
import glm_.vec2.Vec2
import glm_.vec3.Vec3
import glm_.vec4.Vec4
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class ext_vectorVec1 : StringSpec() {

    init {

        "test operators"        {

            val A = Vec1(1)
            val B = Vec1(1)

            val C = A + B
            C.equal(Vec1(2), glm.εf) shouldBe true

            val D = A - B
            D.equal(Vec1(0), glm.εf) shouldBe true

            val E = A * B
            E.equal(Vec1(1), glm.εf) shouldBe true

            val F = A / B
            F.equal(Vec1(1), glm.εf) shouldBe true
        }

        "test ctor"        {

            val A = Vec1(1)

            val E = Vec1(Vec1(1))
            A.equal(E, glm.εf) shouldBe true

            val F = Vec1(E)
            A.equal(F, glm.εf) shouldBe true

            val B = Vec1(1)
            val G = Vec1(Vec2(1))
            B.equal(G, glm.εf) shouldBe true

            val H = Vec1(Vec3(1))
            B.equal(H, glm.εf) shouldBe true

            val I = Vec1(Vec4(1))
            B.equal(I, glm.εf) shouldBe true
        }

        "test size"        {
            Vec1.size shouldBe Float.BYTES
            Vec1.length shouldBe 1
        }

        "test relational"        {

            val A = Vec1(1)
            val B = Vec1(1)
            val C = Vec1(0)

            A.equal(B, glm.εf) shouldBe true
            A.notEqual(C, glm.εf) shouldBe true
        }

        "test constexpr"        {

//            Vec1.length shouldBe 1
//            glm.equal(Vec1(1)[0], 1f, glm.εf) shouldBe true
//            glm.equal(Vec1(1), Vec1(1), glm::epsilon<float>()), "GLM: Failed constexpr")
//                    static_assert (glm::all(glm::notEqual(genType(1), genType(0), glm::epsilon<float>())), "GLM: Failed constexpr")
//                    # endif
//
//                    return 0
        }
    }
}