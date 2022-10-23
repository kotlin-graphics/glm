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

        val ulp1Plus = 1f.nextUp()
        assert(!1f.notEqual(ulp1Plus, 1))

        val ulp2Plus = ulp1Plus.nextUp()
        assert(1f.notEqual(ulp2Plus, 1))

        val ulp1Minus = 1f.nextDown()
        assert(!1f.notEqual(ulp1Minus, 1))

        val ulp2Minus = ulp1Minus.nextDown()
        assert(1f.notEqual(ulp2Minus, 1))
    }

    @Test
    fun equal_sign() {

        assert(!(-0f).equal(0f, 2))
        assert(!(-0.0).equal(0.0, 2))

        assert(!(-1f).equal(2f, 2))
        assert(!(-1.0).equal(2.0, 2))

        assert(!(-0.00001f).equal(1.00000f, 2))
        assert(!(-0.00001).equal(1.00000, 2))

        assert(!(-1f).equal(1f, 2))
        assert(!(-1.0).equal(1.0, 2))
    }
}