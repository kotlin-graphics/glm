package glm_.ext

import glm_.BYTES
import glm_.glm
import glm_.vec1.Vec1
import glm_.vec1.Vec1d
import glm_.vec2.Vec2d
import glm_.vec3.Vec3d
import glm_.vec4.Vec4d
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class ext_vectorVec1d : StringSpec() {

    init {

        "test operators"        {

            val A = Vec1d(1)
            val B = Vec1d(1)

            val C = A + B
            C.equal(Vec1d(2), glm.ε) shouldBe true

            val D = A - B
            D.equal(Vec1d(0), glm.ε) shouldBe true

            val E = A * B
            E.equal(Vec1d(1), glm.ε) shouldBe true

            val F = A / B
            F.equal(Vec1d(1), glm.ε) shouldBe true
        }

        "test ctor"        {

            val A = Vec1d(1)

            val E = Vec1d(Vec1d(1))
            A.equal(E, glm.ε) shouldBe true

            val F = Vec1d(E)
            A.equal(F, glm.ε) shouldBe true

            val B = Vec1d(1)
            val G = Vec1d(Vec2d(1))
            B.equal(G, glm.ε) shouldBe true

            val H = Vec1d(Vec3d(1))
            B.equal(H, glm.ε) shouldBe true

            val I = Vec1d(Vec4d(1))
            B.equal(I, glm.ε) shouldBe true
        }

        "test size"        {
            Vec1d.size shouldBe Double.BYTES
            Vec1d.length shouldBe 1
        }

        "test relational"        {

            val A = Vec1d(1)
            val B = Vec1d(1)
            val C = Vec1d(0)

            A.equal(B, glm.ε) shouldBe true
            A.notEqual(C, glm.ε) shouldBe true
        }

        "test constexpr"        {

            Vec1d.length shouldBe 1
            glm.equal(Vec1d(1)[0], 1.0, glm.ε) shouldBe true
            Vec1d(1).equal(Vec1d(Vec1(1)), glm.ε) shouldBe true
            Vec1d(1).notEqual(Vec1d(0), glm.ε)
        }
    }
}