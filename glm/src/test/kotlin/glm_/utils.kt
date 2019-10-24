package glm_

import glm_.vec2.Vec2
import glm_.vec2.Vec2i
import io.kotlintest.shouldBe

infix fun Vec2.shouldEqual(v: Vec2) = shouldEqual(v, glm.εf)
fun Vec2.shouldEqual(v: Vec2, epsilon: Float) = allEqual(v, epsilon) shouldBe true

infix fun Vec2i.shouldEqual(v: Vec2i) = allEqual(v) shouldBe true
