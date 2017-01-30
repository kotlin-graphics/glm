package  mat

import main.BYTES
import vec._2.Vec2

/**
 * Created by GBarbieri on 09.12.2016.
 */

class Mat3x2(override var value: MutableList<Vec2>) : Mat3x2t<Vec2> {

    // -- Accesses --

    //operator fun get(main.getI: Int) = value[main.getI]

    operator fun set(i: Int, v: Vec2) {
        value[i] = v
    }

    companion object {
        @JvmStatic val SIZE = 3 * 2 * Float.BYTES
    }
}