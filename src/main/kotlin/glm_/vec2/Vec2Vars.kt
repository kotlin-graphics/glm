package glm_.vec2

import glm_.vec1.Vec1Vars

interface Vec2Vars<T : Number> : Vec1Vars<T> {
    var y: T

    operator fun component2() = y


    // -- Component accesses --

    override operator fun get(index: Int) = when (index) {
        1 -> y
        else -> super.get(index)
    }
}