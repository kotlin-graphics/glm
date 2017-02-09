package main

import io.kotlintest.KTestJUnitRunner
import io.kotlintest.specs.StringSpec
import main.d
import main.glm
import org.junit.Test
import org.junit.runner.RunWith
import vec._2.Vec2
import vec._2.Vec2ub

/**
 * Created by elect on 11/11/16.
 */

@RunWith(KTestJUnitRunner::class)
class coreFunCommon : StringSpec() {

    init {

        "floor" {

            run {
                val a = 1.1f
                glm.floor(a) shouldBe 1f
            }

            run {
                val a = 1.1
                glm.floor(a) shouldBe 1.d
            }

            run {
                val a = Vec2(1.1f)
                val b = glm.floor(a)

                val c = Vec2ub(2)
                val d = Vec2ub(3, 1)
                val g = glm.lessThan(a, b)
                val f = a lessThan b
                val e = c.lessThan(d)
            }
        }
    }
}