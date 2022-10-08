package glm_

//import glm_.detail.func_common


object glm /*: func_common*/ {
    object epsilon {
        val f = Float.MIN_VALUE
        val d = Double.MIN_VALUE
    }
    object pi {
        val f = kotlin.math.PI.toFloat()
        val d = kotlin.math.PI
    }
}