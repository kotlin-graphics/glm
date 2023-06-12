package glm_

import glm_.vec3.Vec3
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class testClosestPointToLines : StringSpec() {

    init {
        "closest point to lines" {

            val lines = arrayOf(
                    floatArrayOf(0f, 0f, 0f, 1f, 1f, 1f),
                    floatArrayOf(1f, 0f, 0f, -1f, 1f, 1f))

            val closestPoint = glm.closestPointToLines(lines)

            closestPoint shouldBe Vec3(0.5f)
        }
    }
}
