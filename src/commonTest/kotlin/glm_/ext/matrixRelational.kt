package glm_.ext

import glm_.mat2.Mat2
import glm_.mat2.Mat2d
import glm_.mat2x3.Mat2x3
import glm_.mat2x3.Mat2x3d
import glm_.mat2x4.Mat2x4
import glm_.mat2x4.Mat2x4d
import glm_.mat3.Mat3
import glm_.mat3.Mat3d
import glm_.mat3x2.Mat3x2
import glm_.mat3x2.Mat3x2d
import glm_.mat3x4.Mat3x4
import glm_.mat3x4.Mat3x4d
import glm_.mat4.Mat4
import glm_.mat4.Mat4d
import glm_.mat4x2.Mat4x2
import glm_.mat4x2.Mat4x2d
import glm_.mat4x3.Mat4x3
import glm_.mat4x3.Mat4x3d
import glm_.shouldBe
import glm_.vec2.Vec2
import glm_.vec2.Vec2d
import glm_.vec3.Vec3
import glm_.vec3.Vec3d
import glm_.vec4.Vec4
import glm_.vec4.Vec4d
import kotlin.math.nextDown
import kotlin.math.nextUp
import kotlin.test.Test

class matrixRelational {

    @Test
    fun equal_ulps() {
        run {
            val one = 1f
            val ones = Mat4(1)

            val ulp1Plus = one.nextUp()
            ones.equal(Mat4(ulp1Plus), 1).all() shouldBe true

            val ulp2Plus = ulp1Plus.nextUp()
            ones.equal(Mat4(ulp2Plus), 1).all() shouldBe false

            val ulp1Minus = one.nextDown()
            ones.equal(Mat4(ulp1Minus), 1).all() shouldBe true

            val ulp2Minus = ulp1Minus.nextDown()
            ones.equal(Mat4(ulp2Minus), 1).all() shouldBe false
        }
        run {
            val one = 1.0
            val ones = Mat4d(1)

            val ulp1Plus = one.nextUp()
            ones.equal(Mat4d(ulp1Plus), 1).all() shouldBe true

            val ulp2Plus = ulp1Plus.nextUp()
            ones.equal(Mat4d(ulp2Plus), 1).all() shouldBe false

            val ulp1Minus = one.nextDown()
            ones.equal(Mat4d(ulp1Minus), 1).all() shouldBe true

            val ulp2Minus = ulp1Minus.nextDown()
            ones.equal(Mat4d(ulp2Minus), 1).all() shouldBe false
        }
    }

    @Test
    fun test_equal() {
        run {
            val epsilon = 0.001f
            val one = 1f
            val two = 2f
            run {
                Mat2(one).equal(Mat2(one), epsilon).all() shouldBe true
                Mat2(one).equal(Mat2(two), Vec2(epsilon)).all() shouldBe false
            }
            run {
                Mat2x3(one).equal(Mat2x3(one), epsilon).all() shouldBe true
                Mat2x3(one).equal(Mat2x3(two), Vec2(epsilon)).all() shouldBe false
            }
            run {
                Mat2x4(one).equal(Mat2x4(one), epsilon).all() shouldBe true
                Mat2x4(one).equal(Mat2x4(two), Vec2(epsilon)).all() shouldBe false
            }
            run {
                Mat3x2(one).equal(Mat3x2(one), epsilon).all() shouldBe true
                Mat3x2(one).equal(Mat3x2(two), Vec3(epsilon)).all() shouldBe false
            }
            run {
                Mat3(one).equal(Mat3(one), epsilon).all() shouldBe true
                Mat3(one).equal(Mat3(two), Vec3(epsilon)).all() shouldBe false
            }
            run {
                Mat3x4(one).equal(Mat3x4(one), epsilon).all() shouldBe true
                Mat3x4(one).equal(Mat3x4(two), Vec3(epsilon)).all() shouldBe false
            }
            run {
                Mat4x2(one).equal(Mat4x2(one), epsilon).all() shouldBe true
                Mat4x2(one).equal(Mat4x2(two), Vec4(epsilon)).all() shouldBe false
            }
            run {
                Mat4x3(one).equal(Mat4x3(one), epsilon).all() shouldBe true
                Mat4x3(one).equal(Mat4x3(two), Vec4(epsilon)).all() shouldBe false
            }
            run {
                Mat4(one).equal(Mat4(one), epsilon).all() shouldBe true
                Mat4(one).equal(Mat4(two), Vec4(epsilon)).all() shouldBe false
            }
        }
        run {
            val epsilon = 0.001
            val one = 1.0
            val two = 2.0
            run {
                Mat2d(one).equal(Mat2d(one), epsilon).all() shouldBe true
                Mat2d(one).equal(Mat2d(two), Vec2d(epsilon)).all() shouldBe false
            }
            run {
                Mat2x3d(one).equal(Mat2x3d(one), epsilon).all() shouldBe true
                Mat2x3d(one).equal(Mat2x3d(two), Vec2d(epsilon)).all() shouldBe false
            }
            run {
                Mat2x4d(one).equal(Mat2x4d(one), epsilon).all() shouldBe true
                Mat2x4d(one).equal(Mat2x4d(two), Vec2d(epsilon)).all() shouldBe false
            }
            run {
                Mat3x2d(one).equal(Mat3x2d(one), epsilon).all() shouldBe true
                Mat3x2d(one).equal(Mat3x2d(two), Vec3d(epsilon)).all() shouldBe false
            }
            run {
                Mat3d(one).equal(Mat3d(one), epsilon).all() shouldBe true
                Mat3d(one).equal(Mat3d(two), Vec3d(epsilon)).all() shouldBe false
            }
            run {
                Mat3x4d(one).equal(Mat3x4d(one), epsilon).all() shouldBe true
                Mat3x4d(one).equal(Mat3x4d(two), Vec3d(epsilon)).all() shouldBe false
            }
            run {
                Mat4x2d(one).equal(Mat4x2d(one), epsilon).all() shouldBe true
                Mat4x2d(one).equal(Mat4x2d(two), Vec4d(epsilon)).all() shouldBe false
            }
            run {
                Mat4x3d(one).equal(Mat4x3d(one), epsilon).all() shouldBe true
                Mat4x3d(one).equal(Mat4x3d(two), Vec4d(epsilon)).all() shouldBe false
            }
            run {
                Mat4d(one).equal(Mat4d(one), epsilon).all() shouldBe true
                Mat4d(one).equal(Mat4d(two), Vec4d(epsilon)).all() shouldBe false
            }
        }
    }
    @Test
    fun test_not_equal() {
        run {
            val epsilon = 0.001f
            val one = 1f
            val two = 2f
            run {
                Mat2(one).notEqual(Mat2(one), epsilon).any() shouldBe false
                Mat2(one).notEqual(Mat2(two), Vec2(epsilon)).any() shouldBe true
            }
            run {
                Mat2x3(one).notEqual(Mat2x3(one), epsilon).any() shouldBe false
                Mat2x3(one).notEqual(Mat2x3(two), Vec2(epsilon)).any() shouldBe true
            }
            run {
                Mat2x4(one).notEqual(Mat2x4(one), epsilon).any() shouldBe false
                Mat2x4(one).notEqual(Mat2x4(two), Vec2(epsilon)).any() shouldBe true
            }
            run {
                Mat3x2(one).notEqual(Mat3x2(one), epsilon).any() shouldBe false
                Mat3x2(one).notEqual(Mat3x2(two), Vec3(epsilon)).any() shouldBe true
            }
            run {
                Mat3(one).notEqual(Mat3(one), epsilon).any() shouldBe false
                Mat3(one).notEqual(Mat3(two), Vec3(epsilon)).any() shouldBe true
            }
            run {
                Mat3x4(one).notEqual(Mat3x4(one), epsilon).any() shouldBe false
                Mat3x4(one).notEqual(Mat3x4(two), Vec3(epsilon)).any() shouldBe true
            }
            run {
                Mat4x2(one).notEqual(Mat4x2(one), epsilon).any() shouldBe false
                Mat4x2(one).notEqual(Mat4x2(two), Vec4(epsilon)).any() shouldBe true
            }
            run {
                Mat4x3(one).notEqual(Mat4x3(one), epsilon).any() shouldBe false
                Mat4x3(one).notEqual(Mat4x3(two), Vec4(epsilon)).any() shouldBe true
            }
            run {
                Mat4(one).notEqual(Mat4(one), epsilon).any() shouldBe false
                Mat4(one).notEqual(Mat4(two), Vec4(epsilon)).any() shouldBe true
            }
        }
        run {
            val epsilon = 0.001
            val one = 1.0
            val two = 2.0
            run {
                Mat2d(one).notEqual(Mat2d(one), epsilon).any() shouldBe false
                Mat2d(one).notEqual(Mat2d(two), Vec2d(epsilon)).any() shouldBe true
            }
            run {
                Mat2x3d(one).notEqual(Mat2x3d(one), epsilon).any() shouldBe false
                Mat2x3d(one).notEqual(Mat2x3d(two), Vec2d(epsilon)).any() shouldBe true
            }
            run {
                Mat2x4d(one).notEqual(Mat2x4d(one), epsilon).any() shouldBe false
                Mat2x4d(one).notEqual(Mat2x4d(two), Vec2d(epsilon)).any() shouldBe true
            }
            run {
                Mat3x2d(one).notEqual(Mat3x2d(one), epsilon).any() shouldBe false
                Mat3x2d(one).notEqual(Mat3x2d(two), Vec3d(epsilon)).any() shouldBe true
            }
            run {
                Mat3d(one).notEqual(Mat3d(one), epsilon).any() shouldBe false
                Mat3d(one).notEqual(Mat3d(two), Vec3d(epsilon)).any() shouldBe true
            }
            run {
                Mat3x4d(one).notEqual(Mat3x4d(one), epsilon).any() shouldBe false
                Mat3x4d(one).notEqual(Mat3x4d(two), Vec3d(epsilon)).any() shouldBe true
            }
            run {
                Mat4x2d(one).notEqual(Mat4x2d(one), epsilon).any() shouldBe false
                Mat4x2d(one).notEqual(Mat4x2d(two), Vec4d(epsilon)).any() shouldBe true
            }
            run {
                Mat4x3d(one).notEqual(Mat4x3d(one), epsilon).any() shouldBe false
                Mat4x3d(one).notEqual(Mat4x3d(two), Vec4d(epsilon)).any() shouldBe true
            }
            run {
                Mat4d(one).notEqual(Mat4d(one), epsilon).any() shouldBe false
                Mat4d(one).notEqual(Mat4d(two), Vec4d(epsilon)).any() shouldBe true
            }
        }
    }
}