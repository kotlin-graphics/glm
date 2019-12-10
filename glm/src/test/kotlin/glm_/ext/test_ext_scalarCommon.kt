package glm_.ext

import glm_.glm
import glm_.shouldEqual
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class test_ext_scalarCommon : StringSpec() {

    init {

        "min" {
            run {
                val N = 0f
                val B = 1f
                glm.min(N, B) shouldEqual N
                glm.min(B, N) shouldEqual N

                val C = 2f
                glm.min(N, B, C) shouldEqual N
                glm.min(B, N, C) shouldEqual N
                glm.min(C, N, B) shouldEqual N
                glm.min(C, B, N) shouldEqual N
                glm.min(B, C, N) shouldEqual N
                glm.min(N, C, B) shouldEqual N

                val D = 3f
                glm.min(D, N, B, C) shouldEqual N
                glm.min(B, D, N, C) shouldEqual N
                glm.min(C, N, D, B) shouldEqual N
                glm.min(C, B, D, N) shouldEqual N
                glm.min(B, C, N, D) shouldEqual N
                glm.min(N, C, B, D) shouldEqual N
            }
            run {
                val N = 0.0
                val B = 1.0
                glm.min(N, B) shouldEqual N
                glm.min(B, N) shouldEqual N

                val C = 2.0
                glm.min(N, B, C) shouldEqual N
                glm.min(B, N, C) shouldEqual N
                glm.min(C, N, B) shouldEqual N
                glm.min(C, B, N) shouldEqual N
                glm.min(B, C, N) shouldEqual N
                glm.min(N, C, B) shouldEqual N

                val D = 3.0
                glm.min(D, N, B, C) shouldEqual N
                glm.min(B, D, N, C) shouldEqual N
                glm.min(C, N, D, B) shouldEqual N
                glm.min(C, B, D, N) shouldEqual N
                glm.min(B, C, N, D) shouldEqual N
                glm.min(N, C, B, D) shouldEqual N
            }
        }

        "min nan" {
            run {
                val A = 0f
                val B = 1f
                val N = A / A
                glm.isNan(glm.min(N, B)) shouldBe true
                glm.isNan(glm.min(B, N)) shouldBe true // jvm returns always NaN if any input is NaN

                val C = 2f
                glm.isNan(glm.min(N, B, C)) shouldBe true
                glm.isNan(glm.min(B, N, C)) shouldBe true
                glm.isNan(glm.min(C, N, B)) shouldBe true
                glm.isNan(glm.min(C, B, N)) shouldBe true
                glm.isNan(glm.min(B, C, N)) shouldBe true
                glm.isNan(glm.min(N, C, B)) shouldBe true

                val D = 3f
                glm.isNan(glm.min(D, N, B, C)) shouldBe true
                glm.isNan(glm.min(B, D, N, C)) shouldBe true
                glm.isNan(glm.min(C, N, D, B)) shouldBe true
                glm.isNan(glm.min(C, B, D, N)) shouldBe true
                glm.isNan(glm.min(B, C, N, D)) shouldBe true
                glm.isNan(glm.min(N, C, B, D)) shouldBe true
            }
            run {
                val A = 0.0
                val B = 1.0
                val N = A / A
                glm.isNan(glm.min(N, B)) shouldBe true
                glm.isNan(glm.min(B, N)) shouldBe true // jvm returns always NaN if any input is NaN

                val C = 2.0
                glm.isNan(glm.min(N, B, C)) shouldBe true
                glm.isNan(glm.min(B, N, C)) shouldBe true
                glm.isNan(glm.min(C, N, B)) shouldBe true
                glm.isNan(glm.min(C, B, N)) shouldBe true
                glm.isNan(glm.min(B, C, N)) shouldBe true
                glm.isNan(glm.min(N, C, B)) shouldBe true

                val D = 3.0
                glm.isNan(glm.min(D, N, B, C)) shouldBe true
                glm.isNan(glm.min(B, D, N, C)) shouldBe true
                glm.isNan(glm.min(C, N, D, B)) shouldBe true
                glm.isNan(glm.min(C, B, D, N)) shouldBe true
                glm.isNan(glm.min(B, C, N, D)) shouldBe true
                glm.isNan(glm.min(N, C, B, D)) shouldBe true
            }
        }

        "max" {
            run {
                val N = 0f
                val B = 1f
                glm.max(N, B) shouldEqual B
                glm.max(B, N) shouldEqual B

                val C = 2f
                glm.max(N, B, C) shouldEqual C
                glm.max(B, N, C) shouldEqual C
                glm.max(C, N, B) shouldEqual C
                glm.max(C, B, N) shouldEqual C
                glm.max(B, C, N) shouldEqual C
                glm.max(N, C, B) shouldEqual C

                val D = 3f
                glm.max(D, N, B, C) shouldEqual D
                glm.max(B, D, N, C) shouldEqual D
                glm.max(C, N, D, B) shouldEqual D
                glm.max(C, B, D, N) shouldEqual D
                glm.max(B, C, N, D) shouldEqual D
                glm.max(N, C, B, D) shouldEqual D
            }
            run {
                val N = 0.0
                val B = 1.0
                glm.max(N, B) shouldEqual B
                glm.max(B, N) shouldEqual B

                val C = 2.0
                glm.max(N, B, C) shouldEqual C
                glm.max(B, N, C) shouldEqual C
                glm.max(C, N, B) shouldEqual C
                glm.max(C, B, N) shouldEqual C
                glm.max(B, C, N) shouldEqual C
                glm.max(N, C, B) shouldEqual C

                val D = 3.0
                glm.max(D, N, B, C) shouldEqual D
                glm.max(B, D, N, C) shouldEqual D
                glm.max(C, N, D, B) shouldEqual D
                glm.max(C, B, D, N) shouldEqual D
                glm.max(B, C, N, D) shouldEqual D
                glm.max(N, C, B, D) shouldEqual D
            }
        }

        "max nan" {
            run {
                val A = 0f
                val B = 1f
                val N = A / A
                glm.isNan(glm.max(N, B)) shouldBe true
                glm.isNan(glm.max(B, N)) shouldBe true

                val C = 2f
                glm.isNan(glm.max(N, B, C)) shouldBe true
                glm.isNan(glm.max(B, N, C)) shouldBe true
                glm.isNan(glm.max(C, N, B)) shouldBe true
                glm.isNan(glm.max(C, B, N)) shouldBe true
                glm.isNan(glm.max(B, C, N)) shouldBe true
                glm.isNan(glm.max(N, C, B)) shouldBe true

                val D = 3f
                glm.isNan(glm.max(D, N, B, C)) shouldBe true
                glm.isNan(glm.max(B, D, N, C)) shouldBe true
                glm.isNan(glm.max(C, N, D, B)) shouldBe true
                glm.isNan(glm.max(C, B, D, N)) shouldBe true
                glm.isNan(glm.max(B, C, N, D)) shouldBe true
                glm.isNan(glm.max(N, C, B, D)) shouldBe true
            }
            run {
                val A = 0.0
                val B = 1.0
                val N = A / A
                glm.isNan(glm.max(N, B)) shouldBe true
                glm.isNan(glm.max(B, N)) shouldBe true

                val C = 2.0
                glm.isNan(glm.max(N, B, C)) shouldBe true
                glm.isNan(glm.max(B, N, C)) shouldBe true
                glm.isNan(glm.max(C, N, B)) shouldBe true
                glm.isNan(glm.max(C, B, N)) shouldBe true
                glm.isNan(glm.max(B, C, N)) shouldBe true
                glm.isNan(glm.max(N, C, B)) shouldBe true

                val D = 3.0
                glm.isNan(glm.max(D, N, B, C)) shouldBe true
                glm.isNan(glm.max(B, D, N, C)) shouldBe true
                glm.isNan(glm.max(C, N, D, B)) shouldBe true
                glm.isNan(glm.max(C, B, D, N)) shouldBe true
                glm.isNan(glm.max(B, C, N, D)) shouldBe true
                glm.isNan(glm.max(N, C, B, D)) shouldBe true
            }
        }

        "fmin" {
            run {
                val A = 0f
                val B = 1f
                glm.fmin(A / A, B) shouldEqual B
                glm.fmin(B, A / A) shouldEqual B

                val C = 2f
                glm.fmin(A / A, B, C) shouldEqual B
                glm.fmin(B, A / A, C) shouldEqual B
                glm.fmin(C, A / A, B) shouldEqual B
                glm.fmin(C, B, A / A) shouldEqual B
                glm.fmin(B, C, A / A) shouldEqual B
                glm.fmin(A / A, C, B) shouldEqual B

                val D = 3f
                glm.fmin(D, A / A, B, C) shouldEqual B
                glm.fmin(B, D, A / A, C) shouldEqual B
                glm.fmin(C, A / A, D, B) shouldEqual B
                glm.fmin(C, B, D, A / A) shouldEqual B
                glm.fmin(B, C, A / A, D) shouldEqual B
                glm.fmin(A / A, C, B, D) shouldEqual B
            }
            run {
                val A = 0.0
                val B = 1.0
                glm.fmin(A / A, B) shouldEqual B
                glm.fmin(B, A / A) shouldEqual B

                val C = 2.0
                glm.fmin(A / A, B, C) shouldEqual B
                glm.fmin(B, A / A, C) shouldEqual B
                glm.fmin(C, A / A, B) shouldEqual B
                glm.fmin(C, B, A / A) shouldEqual B
                glm.fmin(B, C, A / A) shouldEqual B
                glm.fmin(A / A, C, B) shouldEqual B

                val D = 3.0
                glm.fmin(D, A / A, B, C) shouldEqual B
                glm.fmin(B, D, A / A, C) shouldEqual B
                glm.fmin(C, A / A, D, B) shouldEqual B
                glm.fmin(C, B, D, A / A) shouldEqual B
                glm.fmin(B, C, A / A, D) shouldEqual B
                glm.fmin(A / A, C, B, D) shouldEqual B
            }
        }

        "fmax" {
            run {
                val A = 0f
                val B = 1f
                glm.fmax(A / A, B) shouldEqual B
                glm.fmax(B, A / A) shouldEqual B

                val C = 2f
                glm.fmax(A / A, B, C) shouldEqual C
                glm.fmax(B, A / A, C) shouldEqual C
                glm.fmax(C, A / A, B) shouldEqual C
                glm.fmax(C, B, A / A) shouldEqual C
                glm.fmax(B, C, A / A) shouldEqual C
                glm.fmax(A / A, C, B) shouldEqual C

                val D = 3f
                glm.fmax(D, A / A, B, C) shouldEqual D
                glm.fmax(B, D, A / A, C) shouldEqual D
                glm.fmax(C, A / A, D, B) shouldEqual D
                glm.fmax(C, B, D, A / A) shouldEqual D
                glm.fmax(B, C, A / A, D) shouldEqual D
                glm.fmax(A / A, C, B, D) shouldEqual D
            }
            run {
                val A = 0.0
                val B = 1.0
                glm.fmax(A / A, B) shouldEqual B
                glm.fmax(B, A / A) shouldEqual B

                val C = 2.0
                glm.fmax(A / A, B, C) shouldEqual C
                glm.fmax(B, A / A, C) shouldEqual C
                glm.fmax(C, A / A, B) shouldEqual C
                glm.fmax(C, B, A / A) shouldEqual C
                glm.fmax(B, C, A / A) shouldEqual C
                glm.fmax(A / A, C, B) shouldEqual C

                val D = 3.0
                glm.fmax(D, A / A, B, C) shouldEqual D
                glm.fmax(B, D, A / A, C) shouldEqual D
                glm.fmax(C, A / A, D, B) shouldEqual D
                glm.fmax(C, B, D, A / A) shouldEqual D
                glm.fmax(B, C, A / A, D) shouldEqual D
                glm.fmax(A / A, C, B, D) shouldEqual D
            }
        }
    }
}