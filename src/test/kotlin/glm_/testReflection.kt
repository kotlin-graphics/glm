package glm_

import glm_.func.cos
import glm_.func.rad
import glm_.func.sin
import glm_.vec3.Vec3
import io.kotest.core.spec.style.StringSpec

class testReflection : StringSpec() {

    init {
        "custom reflection" {

            /*
              viewPoint


                 ++
              +     +
            +    .    +

             */

            val degreeStep = 10
            val counts = 180 / degreeStep + 1
            val mirrorPoints = Array(counts) {
                val angle = (degreeStep * it).rad
                Vec3(angle.cos, angle.sin, 0f)
            }
            val viewPoint = Vec3(0, 2e10, 0)
            val reflections = Array(counts) {
                // viewport to mirror point
                val vpToMp = mirrorPoints[it] - viewPoint
                // mirrorPoints[it] represents automatically also the normal by definition
                glm.reflect(vpToMp, mirrorPoints[it]).normalize()
            }
            for (i in 0 until counts)
                println("mirrorPoints (${mirrorPoints[i].x}, ${mirrorPoints[i].y}, ${mirrorPoints[i].z})")
            for (i in 0 until counts)
                println("reflections (${reflections[i].x}, ${reflections[i].y}, ${reflections[i].z})")

            run {
                val refls = Array(counts - 2) {
                    floatArrayOf(
                            mirrorPoints[it + 1].x, mirrorPoints[it + 1].y, mirrorPoints[it + 1].z,
                            reflections[it + 1].x, reflections[it + 1].y, reflections[it + 1].z)
                }

                val vvp = glm.closestPointToLines(refls)
                println("vvp (${vvp.x}, ${vvp.y}, ${vvp.z})")
                val error = Vec3()
                val origin = Vec3()
                for (i in refls.indices) {
                    val closestPoint = glm.closestPointOnLine(vvp, origin, reflections[i + 1])
                    val diff = vvp - closestPoint
                    error += glm.abs(diff)
                }
                println("error (${error.x}, ${error.y}, ${error.z})")
            }


            println()
            run {
                val refls = Array(5) {
                    floatArrayOf(
                            mirrorPoints[it + 7].x, mirrorPoints[it + 7].y, mirrorPoints[it + 7].z,
                            reflections[it + 7].x, reflections[it + 7].y, reflections[it + 7].z)
                }

                val vvp = glm.closestPointToLines(refls)
                println("vvp (${vvp.x}, ${vvp.y}, ${vvp.z})")
                val error = Vec3()
                val origin = Vec3()
                for (i in refls.indices) {
                    val closestPoint = glm.closestPointOnLine(vvp, origin, reflections[i + 7])
                    val diff = vvp - closestPoint
                    error += glm.abs(diff)
                }
                println("error (${error.x}, ${error.y}, ${error.z})")
            }
            println()
            run {
                val refls = Array(4) { FloatArray(6) }

                for (i in 0..1) {

                    mirrorPoints[5 + i] to refls[i]
                    reflections[5 + i].to(refls[i], 3)

                    mirrorPoints[12 + i] to refls[2 + i]
                    reflections[12 + i].to(refls[2 + i], 3)
                }
                val vvp = glm.closestPointToLines(refls)
                println("vvp (${vvp.x}, ${vvp.y}, ${vvp.z})")
                val error = Vec3()
                val origin = Vec3()
                for (i in 0..1) {
                    val closestPoint = glm.closestPointOnLine(vvp, origin, reflections[i + 5])
                    val diff = vvp - closestPoint
                    error += glm.abs(diff)
                }
                for (i in 0..1) {
                    val closestPoint = glm.closestPointOnLine(vvp, origin, reflections[i + 12])
                    val diff = vvp - closestPoint
                    error += glm.abs(diff)
                }
                println("error (${error.x}, ${error.y}, ${error.z})")
            }
            println()
            run {
                val refls = Array(4) { FloatArray(6) }

                for (i in 0..1) {

                    mirrorPoints[3 + i] to refls[i]
                    reflections[3 + i].to(refls[i], 3)

                    mirrorPoints[14 + i] to refls[2 + i]
                    reflections[14 + i].to(refls[2 + i], 3)
                }
                val vvp = glm.closestPointToLines(refls)
                println("vvp (${vvp.x}, ${vvp.y}, ${vvp.z})")
                val error = Vec3()
                val origin = Vec3()
                for (i in 0..1) {
                    val closestPoint = glm.closestPointOnLine(vvp, origin, reflections[i + 3])
                    val diff = vvp - closestPoint
                    error += glm.abs(diff)
                }
                for (i in 0..1) {
                    val closestPoint = glm.closestPointOnLine(vvp, origin, reflections[i + 14])
                    val diff = vvp - closestPoint
                    error += glm.abs(diff)
                }
                println("error (${error.x}, ${error.y}, ${error.z})")
            }
            println()
            run {
                val refls = Array(4) { FloatArray(6) }

                for (i in 0..1) {

                    mirrorPoints[1 + i] to refls[i]
                    reflections[1 + i].to(refls[i], 3)

                    mirrorPoints[16 + i] to refls[2 + i]
                    reflections[16 + i].to(refls[2 + i], 3)
                }
                val vvp = glm.closestPointToLines(refls)
                println("vvp (${vvp.x}, ${vvp.y}, ${vvp.z})")
                val error = Vec3()
                val origin = Vec3()
                for (i in 0..1) {
                    val closestPoint = glm.closestPointOnLine(vvp, origin, reflections[i + 1])
                    val diff = vvp - closestPoint
                    error += glm.abs(diff)
                }
                for (i in 0..1) {
                    val closestPoint = glm.closestPointOnLine(vvp, origin, reflections[i + 16])
                    val diff = vvp - closestPoint
                    error += glm.abs(diff)
                }
                println("error (${error.x}, ${error.y}, ${error.z})")
            }
        }
    }
}