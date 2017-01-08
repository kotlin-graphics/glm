package  mat

import vec._2.Vec2

/**
 * Created by GBarbieri on 09.12.2016.
 */

data class Mat4x2(override var value: MutableList<Vec2>) : Mat4x2t<Vec2> {

    // -- Accesses --

    //operator fun get(i: Int) = value[i]

    operator fun set(i: Int, v: Vec2) {
        value[i] = v
    }
}