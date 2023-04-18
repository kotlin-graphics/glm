package glm_.vec3

import glm_.vec2.Vec2Vars

interface Vec3Vars<T : Number> : Vec2Vars<T> {
    var z: T

    fun component3() = z


    // -- Component accesses --

    override operator fun get(index: Int) = when (index) {
        2 -> z
        else -> super.get(index)
    }
}