package quat

import BYTES
import mat.QuatT


/**
 * Created by GBarbieri on 15.11.2016.
 */
data class QuatD(var w: Double, var x: Double, var y: Double, var z: Double) : QuatT<Double> {

    companion object {
        @JvmStatic val SIZE = 4 * Float.BYTES
    }
}