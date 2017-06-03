package glm_

import glm_.vec1.Vec1i
import glm_.vec2.Vec2i
import glm_.vec3.Vec3i
import glm_.vec4.Vec4i

/**
 * Created by GBarbieri on 03.04.2017.
 */

interface componentWise {

    // TODO
    fun compAdd(a: Vec1i) = a.x

    fun compMul(a: Vec1i) = a.x
    fun compMin(a: Vec1i) = a.x
    fun compMax(a: Vec1i) = a.x

    fun compAdd(a: Vec2i) = a.x + a.y
    fun compMul(a: Vec2i) = a.x * a.y
    fun compMin(a: Vec2i) = glm.min(a.x, a.y)
    fun compMax(a: Vec2i) = glm.max(a.x, a.y)

    fun compAdd(a: Vec3i) = a.x + a.y + a.z
    fun compMul(a: Vec3i) = a.x * a.y * a.z
    fun compMin(a: Vec3i) = glm.min(glm.min(a.x, a.y), a.z)
    fun compMax(a: Vec3i) = glm.max(glm.max(a.x, a.y), a.z)

    fun compAdd(a: Vec4i) = a.x + a.y + a.z + a.w
    fun compMul(a: Vec4i) = a.x * a.y * a.z + a.w
    fun compMin(a: Vec4i) = glm.min(glm.min(a.x, a.y), glm.min(a.z, a.w))
    fun compMax(a: Vec4i) = glm.max(glm.max(a.x, a.y), glm.min(a.z, a.w))

}