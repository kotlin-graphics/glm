package glm_.gtx

import glm_.glm
import glm_.mat3x3.Mat3
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec
import kotlin.math.abs

class testGtxMatrixFactorization : StringSpec() {

    init {
        "Test QR square" {

            val m = Mat3(12, 6, -4, -51, 167, 24, 4, -68, -41)

            val q = Mat3(-999)
            val r = Mat3(-999)

            glm.qrDecompose(q, r, m)

            //Test if q*r really equals the input matrix
            val tm = q * r
            val err = tm - m

            for (i in 0..2)
                for (j in 0..2) {
                    assert(abs(err[i][j]) <= 1e-5)
                }

            //Test if the columns of q are orthonormal
            for (i in 0..2) {
                assert((q[i].length() - 1) <= 1e-5)

                for (j in 0 until i)
                    assert(abs((q[i] dot q[j])) <= 1e-5)
            }

            //Test if the matrix r is upper triangular
            for (i in 0..2) {
                var j = i + 1
                while (j < 3)
                    r[i][j++] shouldBe 0f
            }
        }

        "Test RQ square" {

            val m = Mat3(12, 6, -4, -51, 167, 24, 4, -68, -41)

            val q = Mat3(-999)
            val r = Mat3(-999)

            glm.rqDecompose(r, q, m)

            //Test if q*r really equals the input matrix
            val tm = r * q
            val err = tm - m

            for (i in 0..2)
                for (j in 0..2)
                    assert(abs(err[i][j]) <= 1e-4)

            //Test if the rows of q are orthonormal
            val tq = q.transpose()

            for (i in 0..2) {
                assert((tq[i].length() - 1) <= 1e-5)

                for (j in 0 until i)
                    assert(abs((tq[i] dot tq[j])) <= 1e-5)
            }

            //Test if the matrix r is upper triangular
            for (i in 0..2) {
                var j = i + 1
                while(j < 3)
                    r[i][j++] shouldBe 0f
            }
        }
    }
}