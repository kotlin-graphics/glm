package glm_

import glm_.mat2x2.Mat2
import glm_.mat3x3.Mat3
import glm_.mat4x4.Mat4
import glm_.mat4x4.Mat4d
import glm_.quat.Quat
import glm_.quat.QuatD
import glm_.vec1.Vec1
import glm_.vec1.Vec1d
import glm_.vec2.Vec2
import glm_.vec2.Vec2d
import glm_.vec3.Vec3
import glm_.vec3.Vec3d
import glm_.vec4.Vec4
import glm_.vec4.Vec4d
import io.kotest.matchers.shouldBe

infix fun Float.shouldEqual(f: Float) = shouldEqual(f, glm.εf)
fun Float.shouldEqual(f: Float, epsilon: Float) = glm.equal(this, f, epsilon) shouldBe true

infix fun Double.shouldEqual(d: Double) = shouldEqual(d, glm.ε)
fun Double.shouldEqual(d: Double, epsilon: Double) = glm.equal(this, d, epsilon) shouldBe true

infix fun Quat.shouldEqual(q: Quat) = shouldEqual(q, glm.εf)
fun Quat.shouldEqual(q: Quat, epsilon: Float) = allEqual(q, epsilon) shouldBe true

infix fun QuatD.shouldEqual(q: QuatD) = shouldEqual(q, glm.ε)
fun QuatD.shouldEqual(q: QuatD, epsilon: Double) = allEqual(q, epsilon) shouldBe true

infix fun Vec1.shouldEqual(v: Vec1) = shouldEqual(v, glm.εf)
fun Vec1.shouldEqual(v: Vec1, epsilon: Float) = glm.equal(x, v.x, epsilon) shouldBe true

infix fun Vec1d.shouldEqual(v: Vec1d) = shouldEqual(v, glm.ε)
fun Vec1d.shouldEqual(v: Vec1d, epsilon: Double) = glm.equal(x, v.x, epsilon) shouldBe true

infix fun Vec2.shouldEqual(v: Vec2) = shouldEqual(v, glm.εf)
fun Vec2.shouldEqual(v: Vec2, epsilon: Float) = allEqual(v, epsilon) shouldBe true

infix fun Vec2d.shouldEqual(v: Vec2d) = shouldEqual(v, glm.ε)
fun Vec2d.shouldEqual(v: Vec2d, epsilon: Double) = allEqual(v, epsilon) shouldBe true

infix fun Vec3.shouldEqual(v: Vec3) = shouldEqual(v, glm.εf)
fun Vec3.shouldEqual(v: Vec3, epsilon: Float) = allEqual(v, epsilon) shouldBe true

infix fun Vec3d.shouldEqual(v: Vec3d) = shouldEqual(v, glm.ε)
fun Vec3d.shouldEqual(v: Vec3d, epsilon: Double) = allEqual(v, epsilon) shouldBe true

infix fun Vec4.shouldEqual(v: Vec4) = shouldEqual(v, glm.εf)
fun Vec4.shouldEqual(v: Vec4, epsilon: Float) = allEqual(v, epsilon) shouldBe true

infix fun Vec4d.shouldEqual(v: Vec4d) = shouldEqual(v, glm.ε)
fun Vec4d.shouldEqual(v: Vec4d, epsilon: Double) = allEqual(v, epsilon) shouldBe true

infix fun Mat2.shouldEqual(v: Mat2) = shouldEqual(v, glm.εf)
fun Mat2.shouldEqual(v: Mat2, epsilon: Float) = allEqual(v, epsilon) shouldBe true

infix fun Mat3.shouldEqual(v: Mat3) = shouldEqual(v, glm.εf)
fun Mat3.shouldEqual(v: Mat3, epsilon: Float) = allEqual(v, epsilon) shouldBe true

infix fun Mat4.shouldEqual(v: Mat4) = shouldEqual(v, glm.εf)
fun Mat4.shouldEqual(v: Mat4, epsilon: Float) = allEqual(v, epsilon) shouldBe true

infix fun Mat4d.shouldEqual(v: Mat4d) = shouldEqual(v, glm.ε)
fun Mat4d.shouldEqual(v: Mat4d, epsilon: Double) = allEqual(v, epsilon) shouldBe true
