package glm_

import glm_.vec2.Vec2

interface gradientPaint {

    fun radialGradient(
            center: Vec2,
            radius: Float,
            focal: Vec2,
            position: Vec2
    ): Float {
        val fX = focal.x - center.x
        val fY = focal.y - center.y
        val dX = position.x - focal.x
        val dY = position.y - focal.y
        val radius2 = glm.pow2(radius)
        val fX2 = glm.pow2(fX)
        val fY2 = glm.pow2(fY)

        val numerator = (dX * fX + dY * fY) + glm.sqrt(radius2 * (glm.pow2(dX) + glm.pow2(dY)) - glm.pow2(dX * fY - dY * fX))
        val denominator = radius2 - (fX2 + fY2)
        return numerator / denominator
    }

    fun linearGradient(
            point0: Vec2,
            point1: Vec2,
            position: Vec2
    ): Float {
        val distX = point1.x - point0.x
        val distY = point1.y - point0.y
        val dot = distX * distX + distY * distY
        return (distX * (position.x - point0.x) + distY * (position.y - point0.y)) / dot
    }
}