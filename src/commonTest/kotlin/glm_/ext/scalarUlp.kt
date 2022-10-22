package glm_.ext

import glm_.assert
import glm_.extensions.L
import glm_.extensions.f
import glm_.glm
import glm_.scalar.abs
import glm_.shouldBe
import kotlin.test.Test
import kotlin.math.nextUp
import kotlin.math.nextDown
import kotlin.math.nextTowards

class scalarUlp {

    @Test
    fun ulp_float_dist() {

        val a = 1f

        val b = a.nextUp()
        assert(a.notEqual(b, 0))
        val c = b.nextDown()
        assert(a.equal(c, 0))

        val d = a distance b
        d shouldBe 1
        val e = a distance c
        e shouldBe 0
    }

    @Test
    fun ulp_float_step() {
        //        infix fun Float.distance(b: Float): Int {
        //            println(toRawBits().toString(16) + " " + b.toRawBits().toString(16))
        //            return (toRawBits() - b.toRawBits()).abs()
        //        }
        val a = 1f

        var i = 10
        while (i < 1000) {
            val b = a.nextUp(i)
            assert(a.notEqual(b, 0))
            val c = b.nextDown(i)
            assert(a.equal(c, 0))

            val d = a distance b
            d shouldBe i
            val e = a distance c
            e shouldBe 0

            i *= 10
        }
    }

    @Test
    fun ulp_double_dist() {

        val a = 1.0

        val b = a.nextUp()
        assert(a.notEqual(b, 0))
        val c = b.nextDown()
        assert(a.equal(c, 0))

        val d = a distance b
        d shouldBe 1
        val e = a distance c
        e shouldBe 0
    }

    @Test
    fun ulp_double_step() {

        val a = 1.0

        var i = 10
        while (i < 1000) {
            val b = a.nextUp(i)
            assert(a.notEqual(b, 0))
            val c = b.nextDown(i)
            assert(a.equal(c, 0))

            val d = a distance b
            d shouldBe i.L
            val e = a distance c
            e shouldBe 0

            i *= 10
        }
    }
}