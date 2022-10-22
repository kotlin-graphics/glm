package glm_.ext

import glm_.assert
import kotlin.test.Test
import kotlin.math.nextDown
import kotlin.math.nextUp

class scalarRelational {

    @Test
    fun equal_epsilon() {
        assert(1.01f.equal(1.02f, 0.1f))
        assert(!1.01f.equal(1.02f, 0.001f))
    }

    @Test
    fun notEqual_epsilon() {
        assert(1.01f.notEqual(1.02f, 0.001f))
        assert(!1.01f.notEqual(1.02f, 0.1f))
    }

    @Test
    fun equal_ulps() {

        val ulp1Plus = 1f.nextUp()
        assert(1f.equal(ulp1Plus, 1))

        val ulp2Plus = ulp1Plus.nextUp()
        assert(!1f.equal(ulp2Plus, 1))

        val ulp1Minus = 1f.nextDown()
        assert(1f.equal(ulp1Minus, 1))

        val ulp2Minus = ulp1Minus.nextDown()
        assert(!1f.equal(ulp2Minus, 1))
    }

    @Test
    fun notEqual_ulps() {
//
//        float const ULP1Plus = glm::nextFloat(1.0f)
//        Error += !glm::notEqual(1.0f, ULP1Plus, 1) ? 0 : 1
//
//        float const ULP2Plus = glm::nextFloat(ULP1Plus)
//        Error += glm::notEqual(1.0f, ULP2Plus, 1) ? 0 : 1
//
//        float const ULP1Minus = glm::prevFloat(1.0f)
//        Error += !glm::notEqual(1.0f, ULP1Minus, 1) ? 0 : 1
//
//        float const ULP2Minus = glm::prevFloat(ULP1Minus)
//        Error += glm::notEqual(1.0f, ULP2Minus, 1) ? 0 : 1
//
//        return Error
    }

//    static int test_equal_sign()
//    {
//        int Error = 0
//
//        Error += !glm::equal(-0.0f, 0.0f, 2) ? 0 : 1
//        Error += !glm::equal(-0.0, 0.0, 2) ? 0 : 1
//
//        Error += !glm::equal(-1.0f, 2.0f, 2) ? 0 : 1
//        Error += !glm::equal(-1.0, 2.0, 2) ? 0 : 1
//
//        Error += !glm::equal(-0.00001f, 1.00000f, 2) ? 0 : 1
//        Error += !glm::equal(-0.00001, 1.00000, 2) ? 0 : 1
//
//        Error += !glm::equal(-1.0f, 1.0f, 2) ? 0 : 1
//        Error += !glm::equal(-1.0, 1.0, 2) ? 0 : 1
//
//        return Error
//    }
}