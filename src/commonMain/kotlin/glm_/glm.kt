package glm_

//import glm_.ext.ulp
import kotlin.math.ulp

//import glm_.detail.func_common


object glm /*: func_common*/ {
    object epsilon {
        val f = Float.MIN_VALUE
        val d = Double.MIN_VALUE
    }
    object pi {
        val d = kotlin.math.PI
        val f = d.toFloat()
    }
    object e {
        val d = kotlin.math.E
        val f = d.toFloat()
    }
    object maxUlp {
        val d = Double.MAX_VALUE.ulp
        val f = Float.MAX_VALUE.ulp // this error goes away when compiling
    }
}