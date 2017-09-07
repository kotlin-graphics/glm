package glm_

import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.StringSpec

class typeHalf_ : StringSpec() {

    init {

        "toFloat32" {

            val shorts = shortArrayOf(0, 1, -1, 2, -2, 30_000)
            val results = intArrayOf(0, 864026624, 4294959104.i, 872415232, 4294950912.i, 1185284096)

            for (i in shorts.indices) {

                val a = glm.detail.toFloat32(shorts[i])
                val b = glm.floatBitsToInt(a)
                b shouldBe results[i]
            }
        }

        "toFloat16" {

            val floats = floatArrayOf(0f, 1f, -1f, 2f, -2f, 1.9f)
            val results = shortArrayOf(0, 15360, 4294949888.s, 16384, 4294950912.s, 16282)

            for (i in floats.indices) {

                val a = glm.detail.toFloat16(floats[i])
                a shouldBe results[i]
            }
        }
    }
}