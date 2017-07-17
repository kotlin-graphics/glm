package glm_

import glm_.vec2.Vec2
import glm_.vec2.Vec2d

interface gauss {

    fun gauss(x: Float, expectedValue: Float, standardDeviation: Float) =
            glm.exp(-((x - expectedValue) * (x - expectedValue)) / (2f * standardDeviation * standardDeviation)) /
                    (standardDeviation * glm.sqrt(6.28318530717958647692528676655900576f))

    fun gauss(x: Double, expectedValue: Double, standardDeviation: Double) =
            glm.exp(-((x - expectedValue) * (x - expectedValue)) / (2.0 * standardDeviation * standardDeviation)) /
                    (standardDeviation * glm.sqrt(6.28318530717958647692528676655900576))

    fun gauss(coord: Vec2, expectedValue: Vec2, standardDeviation: Vec2, res: Vec2 = Vec2()): Float {
        val squaredX = ((coord.x - expectedValue.x) * (coord.x - expectedValue.x)) / (2f * standardDeviation.x * standardDeviation.x)
        val squaredY = ((coord.y - expectedValue.y) * (coord.y - expectedValue.y)) / (2f * standardDeviation.y * standardDeviation.y)
        return glm.exp(-(squaredX + squaredY))
    }

    fun gauss(coord: Vec2d, expectedValue: Vec2d, standardDeviation: Vec2d, res: Vec2d = Vec2d()): Double {
        val squaredX = ((coord.x - expectedValue.x) * (coord.x - expectedValue.x)) / (2f * standardDeviation.x * standardDeviation.x)
        val squaredY = ((coord.y - expectedValue.y) * (coord.y - expectedValue.y)) / (2.0 * standardDeviation.y * standardDeviation.y)
        return glm.exp(-(squaredX + squaredY))
    }
}