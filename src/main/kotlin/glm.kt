import func.*
import func.common.func_common
import func.common.func_vector2_common
import func.common.func_vector3_common
import func.common.func_vector4_common
import mat.operators.mat2x2_operators
import mat.operators.mat3x3_operators
import mat.operators.mat4x4_operators
import vec._3.Vec3i


/**
 * Created bY GBarbieri on 06.10.2016.
 */

interface glm {

    companion object :

            mat2x2_operators,
            mat3x3_operators,
            mat4x4_operators,

            func_common,
            func_vector2_common,
            func_vector3_common,
            func_vector4_common,

            func_vector2_relational,
            func_vector3_relational,
            func_vector4_relational,
            func_vectorBoolean_relational,

            func_matrix,

            func_exponential,
            func_geometric,
            func_trigonometric,

            epsilon,

            gli
}

object glm2 : mat2x2_operators


//         {
//
//    object detail : noise
//}

interface gli {

    //    fun <T : Number> T.ceilMultiple(src: T, other: T) = src + if (src > 0) -(src % other) else (-src) % other
//    fun <T : Number> ceilMultiple(src: T, other: T): T = src + if (src > 0) -(src % other) else (-src) % other


    fun floorMultiple(src: Int, mul: Int): Int {
        if (src >= 0) {
            return src - src % mul
        }
        val tmp = src + 1
        return tmp - tmp % mul - mul
    }

    fun ceilMultiple(src: Int, mul: Int): Int {
        if (src > 0) {
            val tmp = src - 1
            return tmp + mul - tmp % mul
        }
        return src + (-src) % mul
    }

    fun ceilMultiple(a: Vec3i, b: Vec3i) = Vec3i(a.x ceilMultiple b.x, a.y ceilMultiple b.y, a.z ceilMultiple b.z)
//    fun greaterThan(a: Vec3i, b: Vec3i) = Vec3i(a.x asd b.x, a.y ceilMultiple b.y, a.z ceilMultiple b.z)
}

infix fun Int.ceilMultiple(mul: Int) = glm.ceilMultiple(this, mul)
infix fun Int.floorMultiple(mul: Int) = glm.floorMultiple(this, mul)