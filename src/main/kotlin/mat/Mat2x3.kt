package  mat

import  vec._3.Vec3

/**
 * Created by GBarbieri on 09.12.2016.
 */

data class Mat2x3(override var value: MutableList<Vec3>) : Mat2x3t<Vec3> {


    // -- Accesses --

//    operator fun get(i: Int) = value[i]

    operator fun set(i: Int, v: Vec3) {
        value[i] = v
    }
}