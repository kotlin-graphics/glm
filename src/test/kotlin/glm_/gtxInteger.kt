package glm_

import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.StringSpec

class gtxInteger : StringSpec() {

    init {
        "nlz" {
            for (i in 1..32)
                glm.nlz(i) shouldBe 31 - i.msb
        }

//        int test_floor_log2() TODO
//        {
//            int Error = 0;
//
//            for(std::size_t i = 1; i < 1000000; ++i)
//            {
//                glm::uint A = glm::floor_log2(glm::uint(i));
//                glm::uint B = glm::uint(glm::floor(glm::log2(double(i)))); // Will fail with float, lack of accuracy
//
//                Error += A == B ? 0 : 1;
//                assert(!Error);
//            }
//
//            return Error;
//        }

        "log2" {

            for(i in 1..23)            {
                val a = glm.log2(1 shl i)
                val b = glm.log2((1 shl i).d).i

                //Error += glm::equalEpsilon(double(A), B, 1.0) ? 0 : 1;
                (glm.abs(a.d - b) <= 24) shouldBe true

                println("Log2(${1 shl 1}) error A=$a, B=$b")
            }
        }

        "pow uint" {

            val p0 = glm.powU(2, 0)
            p0 shouldBe 1

            val p1 = glm.powU(2, 1)
            p1 shouldBe 2

            val p2 = glm.powU(2, 2)
            p2 shouldBe 4
        }

        "pow int" {

            val p0 = glm.pow(2, 0)
            p0 shouldBe 1

            val p1 = glm.pow(2, 1)
            p1 shouldBe 2

            val p2 = glm.pow(2, 2)
            p2 shouldBe 4

            val p0n = glm.pow(-2, 0)
            p0n shouldBe -1

            val p1n = glm.pow(-2, 1)
            p1n shouldBe -2

            val p2n = glm.pow(-2, 2)
            p2n shouldBe 4
        }
    }
}