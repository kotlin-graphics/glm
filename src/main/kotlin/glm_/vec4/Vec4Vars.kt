package glm_.vec4

import glm_.vec3.Vec3Vars

interface Vec4Vars<T : Number> : Vec3Vars<T> {
    var w: T

    fun component4() = w


    // -- Component accesses --

    override operator fun get(index: Int) = when (index) {
        3 -> w
        else -> super.get(index)
    }
}