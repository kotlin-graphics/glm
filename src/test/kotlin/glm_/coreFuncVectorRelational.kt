package glm_

import glm_.vec1.Vec1bool
import glm_.vec2.Vec2
import glm_.vec2.Vec2bool
import glm_.vec2.Vec2i
import glm_.vec3.Vec3
import glm_.vec3.Vec3bool
import glm_.vec3.Vec3i
import glm_.vec4.Vec4
import glm_.vec4.Vec4bool
import glm_.vec4.Vec4i
import io.kotest.matchers.shouldBe
import io.kotest.core.spec.style.StringSpec

class coreFuncVectorRelational : StringSpec() {

    init {

        "test not"        {
//            Vec1bool(false).not().all shouldBe true
            Vec2bool(false).not().all shouldBe true
            Vec3bool(false).not().all shouldBe true
            Vec4bool(false).not().all shouldBe true
        }

        "test less"        {

            run {
                val A = Vec2(1, 2)
                val B = Vec2(2, 3)
                (A allLessThan B) shouldBe true
                (A allLessThanEqual B) shouldBe true
            }

            run {
                val A = Vec3(1, 2, 3)
                val B = Vec3(2, 3, 4)
                (A allLessThan B) shouldBe true
                (A allLessThanEqual B) shouldBe true
            }

            run {
                val A = Vec4(1, 2, 3, 4)
                val B = Vec4(2, 3, 4, 5)
                (A allLessThan B) shouldBe true
                (A allLessThanEqual  B) shouldBe true
            }

            run {
                val A = Vec2i(1, 2)
                val B = Vec2i(2, 3)
                (A allLessThan B) shouldBe true

                val C = Vec2i(1, 3)
                (A allLessThanEqual C) shouldBe true
            }

            run {
                val A = Vec3i(1, 2, 3)
                val B = Vec3i(2, 3, 4)
                (A allLessThan B) shouldBe true

                val C = Vec3i(1, 3, 4)
                (A allLessThanEqual C) shouldBe true
            }

            run {
                val A = Vec4i(1, 2, 3, 4)
                val B = Vec4i(2, 3, 4, 5)
                (A allLessThan B) shouldBe true

                val C = Vec4i(1, 3, 4, 5)
                (A allLessThanEqual C) shouldBe true
            }
        }

        "test greater"        {

            run {
                val A = Vec2(1, 2)
                val B = Vec2(2, 3)
                (B allGreaterThan A) shouldBe true
                (B allGreaterThanEqual A) shouldBe true
            }

            run {
                val A = Vec3(1, 2, 3)
                val B = Vec3(2, 3, 4)
                (B allGreaterThan A) shouldBe true
                (B allGreaterThanEqual A) shouldBe true
            }

            run {
                val A = Vec4(1, 2, 3, 4)
                val B = Vec4(2, 3, 4, 5)
                (B allGreaterThan A) shouldBe true
                (B allGreaterThanEqual  A) shouldBe true
            }

            run {
                val A = Vec2i(1, 2)
                val B = Vec2i(2, 3)
                (B allGreaterThan A) shouldBe true

                val C = Vec2i(1, 3)
                (C allGreaterThanEqual A) shouldBe true
            }

            run {
                val A = Vec3i(1, 2, 3)
                val B = Vec3i(2, 3, 4)
                (B allGreaterThan A) shouldBe true

                val C = Vec3i(1, 3, 4)
                (C allGreaterThanEqual A) shouldBe true
            }

            run {
                val A = Vec4i(1, 2, 3, 4)
                val B = Vec4i(2, 3, 4, 5)
                (B allGreaterThan A) shouldBe true

                val C = Vec4i(1, 3, 4, 5)
                (C allGreaterThanEqual A) shouldBe true
            }
        }

        "test equal"        {

            run {
                val A = Vec2i(1, 2)
                val B = Vec2i(1, 2)
                (B allEqual A) shouldBe true
            }

            run {
                val A = Vec3i(1, 2, 3)
                val B = Vec3i(1, 2, 3)
                (B allEqual A) shouldBe true
            }

            run {
                val A = Vec4i(1, 2, 3, 4)
                val B = Vec4i(1, 2, 3, 4)
                (B allEqual A) shouldBe true
            }
        }
    }
}