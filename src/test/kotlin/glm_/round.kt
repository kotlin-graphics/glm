package glm_

import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.StringSpec

/**
 * Created by GBarbieri on 04.04.2017.
 */

class round : StringSpec() {

    init {

        "ceil multiple" {

            "test float" {

                class Data(val source: Double, val multiple: Double, val return_: Double, val epsilon: Double)

                val data = arrayOf(
                        Data(3.4, 0.3, 3.6, 0.0001),
                        Data(-1.4, 0.3, -1.2, 0.0001))

                data.forEach {

                    val result = glm.ceilMultiple(it.source, it.multiple)
                    glm.epsilonEqual(it.return_, result, it.epsilon) shouldBe true
                }
            }

            "test int" {

                class Data(val source: Int, val multiple: Int, val return_: Int, val epsilon: Int)

                val data = arrayOf(
                        Data(3, 4, 4, 0),
                        Data(7, 4, 8, 0),
                        Data(5, 4, 8, 0),
                        Data(1, 4, 4, 0),
                        Data(1, 3, 3, 0),
                        Data(4, 3, 6, 0),
                        Data(4, 1, 4, 0),
                        Data(1, 1, 1, 0),
                        Data(7, 1, 7, 0))

                data.forEach {

                    val result = glm.ceilMultiple(it.source, it.multiple)
                    glm.epsilonEqual(it.return_, result, it.epsilon) shouldBe true
                }
            }
        }
    }
}