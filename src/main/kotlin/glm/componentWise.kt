package glm

import glm.vec._3.Vec3i
import glm.glm

/**
 * Created by GBarbieri on 03.04.2017.
 */

interface componentWise {

    // TODO
    fun compAdd(a: Vec3i) = a.x + a.y + a.z
    fun compMul(a: Vec3i) = a.x * a.y * a.z
    fun compMin(a: Vec3i) = glm.min(glm.min(a.x, a.y), a.z)
    fun compMax(a: Vec3i) = glm.max(glm.max(a.x, a.y), a.z)

}