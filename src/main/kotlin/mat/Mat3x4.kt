package  mat

import main.BYTES
import  vec._4.Vec4

/**
 * Created by GBarbieri on 09.12.2016.
 */

class Mat3x4(override var value: MutableList<Vec4>) : Mat3x4t<Vec4> {

    companion object {
        @JvmField val SIZE = 3 * 4 * Float.BYTES
    }
}