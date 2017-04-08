/**
 * Created bY GBarbieri on 06.10.2016.
 */

package glm

import glm.func.*
import glm.func.common.func_common
import glm.func.common.func_vector2_common
import glm.func.common.func_vector3_common
import glm.func.common.func_vector4_common
import glm.mat.operators.mat2x2_operators
import glm.mat.operators.mat3x3_operators
import glm.mat.operators.mat4x4_operators
import glm.quat.quat_func

@JvmField val glm = Glm

object Glm :
        mat2x2_operators,
        mat3x3_operators,
        mat4x4_operators,

        func_common,
        func_vector2_common,
        func_vector3_common,
        func_vector4_common,

        func_vector1_relational,
        func_vector2_relational,
        func_vector3_relational,
        func_vector4_relational,
        func_vectorBoolean_relational,

        func_matrix,

        func_exponential,
        func_geometric,
        func_trigonometric,

        matrix_transform,
        quat_func,

        epsilon,

        componentWise,

        round_,

        func_integer {

    @JvmField val detail = Detail

    @JvmField val PI = Math.PI
    @JvmField val PIf = Math.PI.f

    @JvmField val epsilonF = 1.1920928955078125e-7f
    @JvmField val epsilonD = 2.2204460492503131e-16
}

object Detail : noise