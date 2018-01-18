package glm_

import glm_.vec2.Vec2
import io.kotlintest.specs.StringSpec


class mix_ : StringSpec() {

    init {

        "test" {

            val a = Vec2(3, 4)
            val b = Vec2(1)
            val c = Vec2(2)
            a plusAssign b * c
            println(a)
        }
    }
}