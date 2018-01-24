package glm_

import glm_.mat3x3.Mat3
import glm_.vec3.Vec3

interface closestPointToLines {

    fun closestPointToLines(lines: Array<FloatArray>): Vec3 {

        val m = Mat3(0f)
        val v = Vec3()

        for (line in lines) {

            val a = Vec3(line, 3) // direction
            val b = Vec3(line)          // position
            m[0, 0] += a.y * a.y + a.z * a.z
            m[1, 1] += a.z * a.z + a.x * a.x
            m[2, 2] += a.x * a.x + a.y * a.y
            m[0, 1] += -a.x * a.y
            m[0, 2] += -a.z * a.x
            m[1, 2] += -a.y * a.z
            v.x += a.z * (a.z * b.x - a.x * b.z) - a.y * (a.x * b.y - a.y * b.x)
            v.y += a.x * (a.x * b.y - a.y * b.x) - a.z * (a.y * b.z - a.z * b.y)
            v.z += a.y * (a.y * b.z - a.z * b.y) - a.x * (a.z * b.x - a.x * b.z)
        }
        m[1, 0] = m[0, 1]
        m[2, 0] = m[0, 2]
        m[2, 1] = m[1, 2]

        m.inverseAssign()

        return m * v
    }
}