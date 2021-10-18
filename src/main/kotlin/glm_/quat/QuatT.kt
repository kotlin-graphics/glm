package glm_.quat

/**
 * Created by GBarbieri on 08.11.2016.
 */

abstract class QuatT<T : Number> {

    abstract var w: T
    abstract var x: T
    abstract var y: T
    abstract var z: T

    operator fun component1() = x
    operator fun component2() = y
    operator fun component3() = z
    operator fun component4() = w

    operator fun get(index: Int) = when (index) {
        0 -> x
        1 -> y
        2 -> z
        3 -> w
        else -> throw IndexOutOfBoundsException()
    }

    abstract operator fun set(index: Int, value: Number)
}