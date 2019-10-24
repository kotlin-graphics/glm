package glm_.gtx

import glm_.glm
import glm_.vec3.Vec3
import io.kotlintest.specs.StringSpec

class testGtxClosestPoint : StringSpec() {

    init {

        "gtx Closest Point" {

            val origin = Vec3()

            val a = Vec3(0, 1, 0)
            val b = Vec3(1, 0, 0)

            val point = glm.closestPointOnLine(origin, a, b)
            glm.equal(point, Vec3(0.5f, 0.5f, 0f), Float.MIN_VALUE)
        }
    }
}