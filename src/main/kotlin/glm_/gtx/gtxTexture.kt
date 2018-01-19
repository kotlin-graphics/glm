package glm_.gtx

import glm_.glm
import glm_.glm.compMax
import glm_.vec1.Vec1i
import glm_.vec2.Vec2i
import glm_.vec3.Vec3i

interface gtxTexture {

    fun levels(extent: Vec1i) = glm.log2(compMax(extent)) + 1
    fun levels(extent: Vec2i) = glm.log2(compMax(extent)) + 1
    fun levels(extent: Vec3i) = glm.log2(compMax(extent)) + 1

    fun levels(extent: Int) = Vec1i(extent).x
}