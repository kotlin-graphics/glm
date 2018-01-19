package glm_.gtx

import glm_.glm
import glm_.glm.epsilonF
import glm_.vec2.Vec2
import glm_.vec3.Vec3
import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.StringSpec

class testGtxIntersect : StringSpec() {

    init {

        "intersect Ray-Triangle"        {

            val orig = Vec3(0, 0, 2)
            val dir = Vec3(0, 0, -1)
            val vert0 = Vec3()
            val vert1 = Vec3(-1, -1, 0)
            val vert2 = Vec3(1, -1, 0)
            val baryPosition = Vec2()

            val (result, distance) = glm.intersectRayTriangle(orig, dir, vert0, vert1, vert2, baryPosition)

            val a = glm.epsilonEqual(baryPosition, Vec2(), epsilonF)
            val b = a.all()
            glm.epsilonEqual(baryPosition, Vec2(), epsilonF).all() shouldBe true
            (glm.abs(distance - 2f) <= epsilonF) shouldBe true
            result shouldBe true
        }
    }
}