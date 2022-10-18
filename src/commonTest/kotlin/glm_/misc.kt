package glm_

import glm_.mat2.Mat2
import glm_.mat2x3.Mat2x3
import glm_.mat2x4.Mat2x4
import glm_.mat3.Mat3
import glm_.mat3x2.Mat3x2
import glm_.mat3x4.Mat3x4
import glm_.mat4.Mat4
import glm_.mat4.Mat4d
import glm_.mat4x2.Mat4x2
import glm_.mat4x3.Mat4x3
import kotlin.test.assertTrue
import glm_.vec1.Vec1
import glm_.vec1.Vec1d
import glm_.vec1.Vec1i
import glm_.vec2.Vec2
import glm_.vec2.Vec2d
import glm_.vec2.Vec2i
import glm_.vec2.Vec2ui
import glm_.vec3.Vec3
import glm_.vec3.Vec3d
import glm_.vec3.Vec3i
import glm_.vec4.Vec4
import glm_.vec4.Vec4d
import glm_.vec4.Vec4i

fun assert(value: Boolean) = assertTrue(value)

infix fun Float.shouldEqual(f: Float) = shouldEqual(f, glm.epsilon.f)
fun Float.shouldEqual(f: Float, epsilon: Float) = assert(equal(f, epsilon))

infix fun Double.shouldEqual(d: Double) = shouldEqual(d, glm.epsilon.d)
fun Double.shouldEqual(d: Double, epsilon: Double) = assert(equal(d, epsilon))

infix fun Boolean.shouldBe(b: Boolean) = assert(this == b)

//infix fun Quat.shouldEqual(q: Quat) = shouldEqual(q, glm.epsilon.ff)
//fun Quat.shouldEqual(q: Quat, epsilon: Float) = allEqual(q, epsilon) shouldBe true
//
//infix fun QuatD.shouldEqual(q: QuatD) = shouldEqual(q, glm.epsilon.f)
//fun QuatD.shouldEqual(q: QuatD, epsilon: Double) = allEqual(q, epsilon) shouldBe true

infix fun Vec1.shouldEqual(v: Vec1) = shouldEqual(v, glm.epsilon.f)
fun Vec1.shouldEqual(v: Vec1, epsilon: Float) = assert(x.equal(v.x, epsilon))

infix fun Vec1d.shouldEqual(v: Vec1d) = shouldEqual(v, glm.epsilon.d)
fun Vec1d.shouldEqual(v: Vec1d, epsilon: Double) = assert(x.equal(v.x, epsilon))

infix fun Vec2.shouldEqual(v: Vec2) = shouldEqual(v, glm.epsilon.f)
fun Vec2.shouldEqual(v: Vec2, epsilon: Float) = assert(allEqual(v, epsilon))

infix fun Vec2d.shouldEqual(v: Vec2d) = shouldEqual(v, glm.epsilon.d)
fun Vec2d.shouldEqual(v: Vec2d, epsilon: Double) = assert(allEqual(v, epsilon))

infix fun Vec3.shouldEqual(v: Vec3) = shouldEqual(v, glm.epsilon.f)
fun Vec3.shouldEqual(v: Vec3, epsilon: Float) = assert(allEqual(v, epsilon))

infix fun Vec3d.shouldEqual(v: Vec3d) = shouldEqual(v, glm.epsilon.d)
fun Vec3d.shouldEqual(v: Vec3d, epsilon: Double) = assert(allEqual(v, epsilon))

infix fun Vec4.shouldEqual(v: Vec4) = shouldEqual(v, glm.epsilon.f)
fun Vec4.shouldEqual(v: Vec4, epsilon: Float) = assert(allEqual(v, epsilon))

infix fun Vec4d.shouldEqual(v: Vec4d) = shouldEqual(v, glm.epsilon.d)
fun Vec4d.shouldEqual(v: Vec4d, epsilon: Double) = assert(allEqual(v, epsilon))

infix fun Mat2.shouldEqual(v: Mat2) = shouldEqual(v, glm.epsilon.f)
fun Mat2.shouldEqual(v: Mat2, epsilon: Float) = assert(allEqual(v, epsilon))

infix fun Mat2x3.shouldEqual(v: Mat2x3) = shouldEqual(v, glm.epsilon.f)
fun Mat2x3.shouldEqual(v: Mat2x3, epsilon: Float) = assert(allEqual(v, epsilon))
infix fun Mat2x4.shouldEqual(v: Mat2x4) = shouldEqual(v, glm.epsilon.f)
fun Mat2x4.shouldEqual(v: Mat2x4, epsilon: Float) = assert(allEqual(v, epsilon))

infix fun Mat3.shouldEqual(v: Mat3) = shouldEqual(v, glm.epsilon.f)
fun Mat3.shouldEqual(v: Mat3, epsilon: Float) = assert(allEqual(v, epsilon))
infix fun Mat3x2.shouldEqual(v: Mat3x2) = shouldEqual(v, glm.epsilon.f)
fun Mat3x2.shouldEqual(v: Mat3x2, epsilon: Float) = assert(allEqual(v, epsilon))
infix fun Mat3x4.shouldEqual(v: Mat3x4) = shouldEqual(v, glm.epsilon.f)
fun Mat3x4.shouldEqual(v: Mat3x4, epsilon: Float) = assert(allEqual(v, epsilon))

infix fun Mat4.shouldEqual(v: Mat4) = shouldEqual(v, glm.epsilon.f)
fun Mat4.shouldEqual(v: Mat4, epsilon: Float) = assert(allEqual(v, epsilon))
infix fun Mat4x2.shouldEqual(v: Mat4x2) = shouldEqual(v, glm.epsilon.f)
fun Mat4x2.shouldEqual(v: Mat4x2, epsilon: Float) = assert(allEqual(v, epsilon))
infix fun Mat4x3.shouldEqual(v: Mat4x3) = shouldEqual(v, glm.epsilon.f)
fun Mat4x3.shouldEqual(v: Mat4x3, epsilon: Float) = assert(allEqual(v, epsilon))

infix fun Mat4d.shouldEqual(v: Mat4d) = shouldEqual(v, glm.epsilon.d)
fun Mat4d.shouldEqual(v: Mat4d, epsilon: Double) = assert(allEqual(v, epsilon))

infix fun Vec1i.shouldBe(v: Vec1i) = equal(v)
infix fun Vec2i.shouldBe(v: Vec2i) = equal(v)
infix fun Vec2ui.shouldBe(v: Vec2ui) = equal(v)
infix fun Vec3i.shouldBe(v: Vec3i) = equal(v)
infix fun Vec4i.shouldBe(v: Vec4i) = equal(v)
infix fun Int.shouldBe(i: Int) = assert(this == i)
infix fun UInt.shouldBe(ui: UInt) = assert(this == ui)
infix fun ULong.shouldBe(ul: ULong) = assert(this == ul)