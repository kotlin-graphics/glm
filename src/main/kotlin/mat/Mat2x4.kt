package  mat

import main.BYTES
import  vec._4.Vec4

/**
 * Created by GBarbieri on 09.12.2016.
 */

data class Mat2x4(override var value: MutableList<Vec4>) : Mat2x4t<Vec4> {

    companion object {
        @JvmStatic val SIZE = 2 * 4 * Float.BYTES
    }
}