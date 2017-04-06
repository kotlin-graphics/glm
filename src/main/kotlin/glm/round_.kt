package glm

import glm.vec._3.Vec3i

/**
 * Created by GBarbieri on 04.04.2017.
 */

interface round_ {


    fun ceilMultiple(source: Float, multiple: Float) =
            if (source > 0) source + (multiple - source % multiple)
            else source - source % multiple

    fun ceilMultiple(source: Double, multiple: Double) =
            if (source > 0) source + (multiple - source % multiple)
            else source - source % multiple

    fun ceilMultiple(source: Int, multiple: Int) =
            if (source > 0) {
                val tmp = source - 1
                tmp + (multiple - tmp % multiple)
            } else source - source % multiple

    fun ceilMultiple(source: Vec3i, multiple: Vec3i) = ceilMultiple(source, multiple, Vec3i())
    fun ceilMultiple(source: Vec3i, multiple: Vec3i, res: Vec3i): Vec3i {
        res.x = ceilMultiple(source.x, multiple.x)
        res.y = ceilMultiple(source.y, multiple.y)
        res.z = ceilMultiple(source.z, multiple.z)
        return res
    }

}