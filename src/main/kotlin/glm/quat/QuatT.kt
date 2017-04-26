package glm.mat

/**
 * Created by GBarbieri on 08.11.2016.
 */

abstract class QuatT<T : Number>(_w: T, _x: T, _y: T, _z: T) {

    @JvmField var w = _w
    @JvmField var x = _x
    @JvmField var y = _y
    @JvmField var z = _z
}