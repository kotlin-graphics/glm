package  mat

import main.BYTES
import  vec._3.Vec3

/**
 * Created by GBarbieri on 09.12.2016.
 */

data class Mat2x3(override var value: MutableList<Vec3>) : Mat2x3t<Vec3> {


    // -- Accesses --

//    operator fun get(main.getI: Int) = value[main.getI]

    operator fun set(i: Int, v: Vec3) = value[i] put v

    companion object {

        @JvmField val SIZE = 2 * 3 * Float.BYTES
    }
}