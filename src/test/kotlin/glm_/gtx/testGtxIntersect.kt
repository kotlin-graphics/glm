package glm_.gtx

import glm_.glm
import glm_.glm.epsilonF
import glm_.vec2.Vec2
import glm_.vec3.Vec3
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class testGtxIntersect : StringSpec() {

    init {

        "ray-triangle intersection" {

            val orig = Vec3(0, 0, 2)
            val dir = Vec3(0, 0, -1)
            val vert0 = Vec3()
            val vert1 = Vec3(-1, -1, 0)
            val vert2 = Vec3(1, -1, 0)
            val baryPosition = Vec2()

            val distance = glm.intersectRayTriangle(orig, dir, vert0, vert1, vert2, baryPosition)!!

            val a = glm.epsilonEqual(baryPosition, Vec2(), epsilonF)
            val b = a.all()
            glm.epsilonEqual(baryPosition, Vec2(), epsilonF).all() shouldBe true
            (glm.abs(distance - 2f) <= epsilonF) shouldBe true
        }

        "ray-plane intersection" {

            run {
                val orig = Vec3(0, 0, 2)
                val dir = Vec3(0, 0, -1)
                val planeOrig = Vec3(0)
                val planeNormal = Vec3(0, 0, 1)

                val distance = glm.intersectRayPlane(orig, dir, planeOrig, planeNormal)
                distance shouldBe 2f
            }

            run {
                val orig = Vec3(1, 0, 4)
                val dir = Vec3(0, 0, -1)
                val planeOrig = Vec3(0)
                val planeNormal = Vec3(0, 0, 1)

                val distance = glm.intersectRayPlane(orig, dir, planeOrig, planeNormal)
                distance shouldBe 4f
            }

            run {
                val orig = Vec3(1, 2, 4)
                val dir = Vec3(0, 0, -1)
                val planeOrig = Vec3(0, 0, 1)
                val planeNormal = Vec3(0, 0, 1)

                val distance = glm.intersectRayPlane(orig, dir, planeOrig, planeNormal)
                distance shouldBe 3f
            }

            run { //dot product == 0
                val orig = Vec3(0, 0, 4)
                val dir = Vec3(0, 0, -1)
                val planeOrig = Vec3(0)
                val planeNormal = Vec3(1, 0, 0)

                val distance = glm.intersectRayPlane(orig, dir, planeOrig, planeNormal)
                distance shouldBe null
            }

            run {
                val orig = Vec3(0, 0, 3)
                val dir = Vec3(-4, 0, -3).normalize()
                val planeOrig = Vec3(0)
                val planeNormal = Vec3(0, 0, 1)

                val distance = glm.intersectRayPlane(orig, dir, planeOrig, planeNormal)
                distance shouldBe 5f
            }

            run {
                val orig = Vec3(1, 2, 3)
                val dir = Vec3(-2, -4, -3).normalize()
                val planeOrig = Vec3(0)
                val planeNormal = Vec3(0, 0, 1)

                val distance = glm.intersectRayPlane(orig, dir, planeOrig, planeNormal)
                distance shouldBe 5.385165f
            }
        }
    }

}