package glm_

import glm_.ext.ulp
import glm_.scalar.cos
import kotlin.math.ulp as ulpe

//import glm_.detail.func_common


object glm /*: func_common*/ {
    object epsilon {
        val f = 1f.ulp
        val d = 1.0.ulpe
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
        val d = Double.MAX_VALUE.ulpe
        val f = Float.MAX_VALUE.ulp
    }

    object `cos 1 over 2` {
        val d = (1.0 / 2).cos
        val f = (1f / 2).cos
    }

    object two_pi {
        val d = 2 * pi.d
        val f = 2 * pi.f
    }
}