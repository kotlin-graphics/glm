package glm_

import glm_.vec2.Vec2b
import glm_.vec2.Vec2s
import glm_.vec4.Vec4b
import glm_.vec4.Vec4i
import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.StringSpec
import kotlin.system.measureNanoTime

class typeHalf_ : StringSpec() {

    init {

        "toFloat32" {

            val shorts = shortArrayOf(0, 1, -1, 2, -2, 30_000)
            val results = intArrayOf(0, 864026624, 4294959104.i, 872415232, 4294950912.i, 1185284096)

            for (i in shorts.indices){

                val a = glm.detail.toFloat32(shorts[i])
                val b = glm.floatBitsToInt(a)
                b shouldBe results[i]
            }
        }
    }
}