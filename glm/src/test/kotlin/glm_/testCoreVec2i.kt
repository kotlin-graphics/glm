package glm_

import glm_.vec2.Vec2bool
import glm_.vec2.Vec2i
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

/**
 * Created by fschaefers on 09.02.2017.
 */

class testCoreVec2i : StringSpec() {
    init {
        "operatorsSpecific" {
            run {

                val v1 = Vec2i(2)
                val v2 = Vec2i(2)
                val v3 = Vec2i(2, 1)

                v1 shouldBe v2

                (v1 != v2) shouldBe false
                (v1 == v2) shouldBe true
                (v1 == v3) shouldBe false
                (v2 != v3) shouldBe true

                (v1 == v2) shouldBe true
                v1.isEqual(v2) shouldBe true
                (v1 == v3) shouldBe false
                v1.isEqual(v3) shouldBe false

                v1.equal(v2) shouldBe Vec2bool(true, true)
                v1.equal(v3) shouldBe Vec2bool(true, false)
                v1.notEqual(v3) shouldBe Vec2bool(false, true)
                v3.lessThan(v1) shouldBe Vec2bool(false, true)
                v2.greaterThan(v3) shouldBe Vec2bool(false, true)
                v2.greaterThanEqual(v3) shouldBe Vec2bool(true, true)

            }

            run {
                val v1 = Vec2i(1, 1)
                val v2 = Vec2i(2, 2)
                val v3 = Vec2i(3, 2)
                val v4 = Vec2i(3, -2)
                val r2 = Vec2i(4, 6)
                v3 += 1
                v4 += v1

                v1 plus v2 shouldBe Vec2i(3, 3)
                v1 + v2 shouldBe Vec2i(3, 3)
                (v1 + v2 != r2) shouldBe true
                v1 + 2 shouldBe Vec2i(3, 3)
                v3 shouldBe Vec2i(4, 3)
                v4 shouldBe Vec2i(4, -1)
            }

            run {
                val v1 = Vec2i(1, 0)
                val v2 = Vec2i(2, 3)
                val v3 = Vec2i(0, 0)
                v3 -= v2

                v1 minus v2 shouldBe Vec2i(-1, -3)
                v1 - v2 shouldBe Vec2i(-1, -3)
                v1 - 5 shouldBe Vec2i(-4, -5)
                v3 shouldBe Vec2i(-2, -3)

            }

            run {
                val v1 = Vec2i(1, 0)
                val v2 = Vec2i(2, 3)
                val v3 = Vec2i(2, 2)

                v3 *= v2

                v1 * v2 shouldBe Vec2i(2, 0)
                v1 times v2 shouldBe Vec2i(2, 0)
                v2 * 3 shouldBe Vec2i(6, 9)
                v3 shouldBe Vec2i(4, 6)
            }

            run {
                val v1 = Vec2i(1, 10)
                val v2 = Vec2i(2, 3)
                val v3 = Vec2i(2, 4)

                v3 /= v2

                v1 / v2 shouldBe Vec2i(0, 3)
                v1.div(v2) shouldBe Vec2i(0, 3)
                v2 / 3 shouldBe Vec2i(0, 1)
                v3 shouldBe Vec2i(1, 1)
            }

            run {
                val v1 = Vec2i(1, 10)
                val v2 = Vec2i(2, 3)
                val v3 = Vec2i(3, 5)

                v3 %= v2

                v1 % v2 shouldBe Vec2i(1, 1)
                v1.rem(v2) shouldBe Vec2i(1, 1)
                v2 % 3 shouldBe Vec2i(2, 0)
                v3 shouldBe Vec2i(1, 2)
            }


            // TODO and,or,xor,shr, operatorsGeneric,ctor,size,generic,operator_increment,swizzling
        }

    }
}

