package glm

import io.kotlintest.KTestJUnitRunner
import io.kotlintest.specs.StringSpec
import glm.glm
import mat.Mat2
import mat.Mat2x2
import mat.operators.div
import mat.operators.times
import org.junit.runner.RunWith
import vec._2.Vec2

/**
 * Created by GBarbieri on 11.11.2016.
 */
@RunWith(KTestJUnitRunner::class)
class coreMat2 : StringSpec() {

    init {

        "test operators" {

            val l = Mat2(1f)
            val m = Mat2(1f)
            val u = Vec2(1f)
            val v = Vec2(1f)
            val x = 1f
            val a = m * u
            val b = v * m
            val p = x * m
            val q = m * x
            val R = m != q
            val S = m == l

            (S && !R) shouldBe true
        }

        "test inverse" {

            run {
                val matrix = Mat2(1, 2, 3, 4)
                val inverse = matrix.inverse()
                val identity = matrix * inverse

                glm.all(glm.epsilonEqual(identity[0], Vec2(1.0f, 0.0f), Vec2(0.01f))) shouldBe true
                glm.all(glm.epsilonEqual(identity[1], Vec2(0.0f, 1.0f), Vec2(0.01f))) shouldBe true
            }
            run {
                val matrix = Mat2(1, 2, 3, 4)
                val identity = matrix / matrix

                glm.all(glm.epsilonEqual(identity[0], Vec2(1.0f, 0.0f), Vec2(0.01f))) shouldBe true
                glm.all(glm.epsilonEqual(identity[1], Vec2(0.0f, 1.0f), Vec2(0.01f))) shouldBe true
            }
        }

    }
}