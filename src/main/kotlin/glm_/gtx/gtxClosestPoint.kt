package glm_.gtx

import glm_.glm
import glm_.vec2.Vec2
import glm_.vec3.Vec3


interface gtxClosestPoint {

    /** Find the point on a straight line which is the closet of a point.
     *  @see gtx_closest_point */
    fun closestPointOnLine(point: Vec3, a: Vec3, b: Vec3): Vec3 {

        val lineLength = glm.distance(a, b)
        val vector = point - a
        val lineDirection = (b - a) / lineLength

        // Project vector to lineDirection to get the distance of point from a
        val distance = vector dot lineDirection

        return when {
            distance <= 0f -> a
            distance >= lineLength -> b
            else -> a + lineDirection * distance
        }
    }

    /** 2d lines work as well */
    fun closestPointOnLine(point: Vec2, a: Vec2, b: Vec2): Vec2 {
        val lineLength = glm.distance(a, b)
        val vector = point - a
        val lineDirection = (b - a) / lineLength

        // Project vector to lineDirection to get the distance of point from a
        val distance = vector dot lineDirection

        return when {
            distance <= 0f -> a
            distance >= lineLength -> b
            else -> a + lineDirection * distance
        }
    }
}