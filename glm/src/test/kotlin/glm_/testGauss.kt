package glm_

import glm_.vec2.Vec2
import io.kotlintest.specs.StringSpec

class testGauss : StringSpec() {

    init {

        "test_gauss_1d" {

            val result = floatArrayOf(0.398942f, 0.396953f, 0.391043f, 0.381388f, 0.368270f, 0.352065f,
                    0.333225f, 0.312254f, 0.289692f, 0.266085f, 0.241971f, 0.217852f, 0.194186f, 0.171369f, 0.149727f,
                    0.129518f, 0.110921f, 0.094049f, 0.078950f, 0.065616f)
            for (i in 0 until 20)
                glm.equal(result[i], glm.gauss(i * 0.1f, 0.0f, 1.0f), 0.000001f)
        }
        "test_gauss_2d" {

            val result = floatArrayOf(1.000000f,
                    0.990050f,
                    0.960789f,
                    0.913931f,
                    0.852144f,
                    0.778801f,
                    0.697676f,
                    0.612626f,
                    0.527292f,
                    0.444858f,
                    0.367879f,
                    0.298197f,
                    0.236928f,
                    0.184519f,
                    0.140858f,
                    0.105399f,
                    0.077305f,
                    0.055576f,
                    0.039164f,
                    0.027052f)
            for (i in 0 until 20)
                glm.equal(result[i], glm.gauss(Vec2(i * 0.1f), Vec2(0.0f), Vec2(1.0f)), 0.000001f)
        }
    }
}