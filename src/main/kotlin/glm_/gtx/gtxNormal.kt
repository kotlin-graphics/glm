package glm_.gtx

import glm_.glm
import glm_.vec3.Vec3
import glm_.vec4.Vec4

interface gtxNormal {

    fun triangleNormal(p1: Vec3, p2: Vec3, p3: Vec3): Vec3 = triangleNormal(Vec3(), p1, p2, p3)

    fun triangleNormal(res: Vec3, p1: Vec3, p2: Vec3, p3: Vec3): Vec3 {
        // a = p1 - p2
        val aX = p1.x - p2.x
        val aY = p1.y - p2.y
        val aZ = p1.z - p2.z
        // b = p1 - p3
        val bX = p1.x - p3.x
        val bY = p1.y - p3.y
        val bZ = p1.z - p3.z
        // a cross b
        val crossX = aY * bZ - bY * aZ
        val crossY = aZ * bX - bZ * aX
        val crossZ = aX * bY - bX * aY
        // normalize(cross)
        val dot = crossX * crossX + crossY * crossY + crossZ * crossZ
        val invSqrt = glm.inverseSqrt(dot)
        res.x = crossX * invSqrt
        res.y = crossY * invSqrt
        res.z = crossZ * invSqrt
        return res
    }

    fun triangleNormal(p1: Vec4, p2: Vec4, p3: Vec4): Vec4 = triangleNormal(Vec4(), p1, p2, p3)

    fun triangleNormal(res: Vec4, p1: Vec4, p2: Vec4, p3: Vec4): Vec4 {
        // a = p1 - p2
        val aX = p1.x - p2.x
        val aY = p1.y - p2.y
        val aZ = p1.z - p2.z
        // b = p1 - p3
        val bX = p1.x - p3.x
        val bY = p1.y - p3.y
        val bZ = p1.z - p3.z
        // a cross b
        val crossX = aY * bZ - bY * aZ
        val crossY = aZ * bX - bZ * aX
        val crossZ = aX * bY - bX * aY
        // normalize(cross)
        val dot = crossX * crossX + crossY * crossY + crossZ * crossZ
        val invSqrt = glm.inverseSqrt(dot)
        res.x = crossX * invSqrt
        res.y = crossY * invSqrt
        res.z = crossZ * invSqrt
        return res
    }
}