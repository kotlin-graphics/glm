package glm_

import glm_.mat2x2.Mat2
import glm_.mat3x3.Mat3
import glm_.mat4x4.Mat4
import glm_.vec1.Vec1
import glm_.vec1.Vec1i
import glm_.vec2.Vec2
import glm_.vec2.Vec2d
import glm_.vec2.Vec2i
import glm_.vec3.Vec3
import glm_.vec3.Vec3i
import glm_.vec4.Vec4
import io.kotlintest.matchers.floats.shouldBeLessThan
import io.kotlintest.matchers.numerics.shouldBeLessThan
import io.kotlintest.shouldBe
import kotlin.math.abs

infix fun Vec1.shouldEqual(v: Vec1) = shouldEqual(v, glm.εf)
fun Vec1.shouldEqual(v: Vec1, epsilon: Float) = abs(x - v.x) shouldBeLessThan epsilon

infix fun Vec1i.shouldEqual(v: Vec1i) = x shouldBe v.x

infix fun Vec2.shouldEqual(v: Vec2) = shouldEqual(v, glm.εf)
fun Vec2.shouldEqual(v: Vec2, epsilon: Float) = allEqual(v, epsilon) shouldBe true

infix fun Vec2d.shouldEqual(v: Vec2d) = shouldEqual(v, glm.ε)
fun Vec2d.shouldEqual(v: Vec2d, epsilon: Double) = allEqual(v, epsilon) shouldBe true

infix fun Vec3.shouldEqual(v: Vec3) = shouldEqual(v, glm.εf)
fun Vec3.shouldEqual(v: Vec3, epsilon: Float) = allEqual(v, epsilon) shouldBe true

infix fun Vec4.shouldEqual(v: Vec4) = shouldEqual(v, glm.εf)
fun Vec4.shouldEqual(v: Vec4, epsilon: Float) = allEqual(v, epsilon) shouldBe true

infix fun Vec2i.shouldEqual(v: Vec2i) = allEqual(v) shouldBe true
infix fun Vec3i.shouldEqual(v: Vec3i) = allEqual(v) shouldBe true

infix fun Mat2.shouldEqual(v: Mat2) = shouldEqual(v, glm.εf)
fun Mat2.shouldEqual(v: Mat2, epsilon: Float) = allEqual(v, epsilon) shouldBe true

infix fun Mat3.shouldEqual(v: Mat3) = shouldEqual(v, glm.εf)
fun Mat3.shouldEqual(v: Mat3, epsilon: Float) = allEqual(v, epsilon) shouldBe true

infix fun Mat4.shouldEqual(v: Mat4) = shouldEqual(v, glm.εf)
fun Mat4.shouldEqual(v: Mat4, epsilon: Float) = allEqual(v, epsilon) shouldBe true
