package glm_.ext

import glm_.shouldBe
import glm_.vec1.Vec1
import glm_.vec1.Vec1d
import glm_.vec2.Vec2
import glm_.vec2.Vec2d
import glm_.vec3.Vec3
import glm_.vec3.Vec3d
import glm_.vec4.Vec4
import glm_.vec4.Vec4d
import kotlin.math.nextDown
import kotlin.math.nextUp
import kotlin.math.ulp
import kotlin.test.Test

class vectorRelational {

    @Test
    fun equal_ulps() {
        run {
            val one = 1f
            val ones = Vec4(1)

            val ulp1Plus = one.nextUp()
            ones.allEqual(Vec4(ulp1Plus), 1) shouldBe true

            val ulp2Plus = ulp1Plus.nextUp()
            ones.allEqual(Vec4(ulp2Plus), 1) shouldBe false

            val ulp1Minus = one.nextDown()
            ones.allEqual(Vec4(ulp1Minus), 1) shouldBe true

            val ulp2Minus = ulp1Minus.nextDown()
            ones.allEqual(Vec4(ulp2Minus), 1) shouldBe false
        }
        run {
            val one = 1.0
            val ones = Vec4d(1)

            val ulp1Plus = one.nextUp()
            ones.allEqual(Vec4d(ulp1Plus), 1) shouldBe true

            val ulp2Plus = ulp1Plus.nextUp()
            ones.allEqual(Vec4d(ulp2Plus), 1) shouldBe false

            val ulp1Minus = one.nextDown()
            ones.allEqual(Vec4d(ulp1Minus), 1) shouldBe true

            val ulp2Minus = ulp1Minus.nextDown()
            ones.allEqual(Vec4d(ulp2Minus), 1) shouldBe false
        }
    }

    @Test
    fun notEqual_ulps() {
        run {
            val one = 1f
            val ones = Vec4(1)

            val ulp1Plus = one.nextUp()
            ones.notEqual(Vec4(ulp1Plus), 1).all() shouldBe false

            val ulp2Plus = ulp1Plus.nextUp()
            ones.notEqual(Vec4(ulp2Plus), 1).all() shouldBe true

            val ulp1Minus = one.nextDown()
            ones.notEqual(Vec4(ulp1Minus), 1).all() shouldBe false

            val ulp2Minus = ulp1Minus.nextDown()
            ones.notEqual(Vec4(ulp2Minus), 1).all() shouldBe true
        }
        run {
            val one = 1.0
            val ones = Vec4d(1)

            val ulp1Plus = one.nextUp()
            ones.notEqual(Vec4d(ulp1Plus), 1).all() shouldBe false

            val ulp2Plus = ulp1Plus.nextUp()
            ones.notEqual(Vec4d(ulp2Plus), 1).all() shouldBe true

            val ulp1Minus = one.nextDown()
            ones.notEqual(Vec4d(ulp1Minus), 1).all() shouldBe false

            val ulp2Minus = ulp1Minus.nextDown()
            ones.notEqual(Vec4d(ulp2Minus), 1).all() shouldBe true
        }
    }

    @Test
    fun equal() {
        run {
            val a = Vec1(1.01f)
            val b = Vec1(1.02f)
            val epsilon1 = 0.1f
            val epsilon2 = 0.001f

            a.equal(b, epsilon1).all() shouldBe true
            a.equal(b, Vec1(epsilon1)).all() shouldBe true

            a.equal(b, epsilon2).any() shouldBe false
            a.equal(b, Vec1(epsilon2)).any() shouldBe false
        }
        run {
            val a = Vec2(1.01f)
            val b = Vec2(1.02f)
            val epsilon1 = 0.1f
            val epsilon2 = 0.001f

            a.equal(b, epsilon1).all() shouldBe true
            a.equal(b, Vec2(epsilon1)).all() shouldBe true

            a.equal(b, epsilon2).any() shouldBe false
            a.equal(b, Vec2(epsilon2)).any() shouldBe false
        }
        run {
            val a = Vec3(1.01f)
            val b = Vec3(1.02f)
            val epsilon1 = 0.1f
            val epsilon2 = 0.001f

            a.equal(b, epsilon1).all() shouldBe true
            a.equal(b, Vec3(epsilon1)).all() shouldBe true

            a.equal(b, epsilon2).any() shouldBe false
            a.equal(b, Vec3(epsilon2)).any() shouldBe false
        }
        run {
            val a = Vec4(1.01f)
            val b = Vec4(1.02f)
            val epsilon1 = 0.1f
            val epsilon2 = 0.001f

            a.equal(b, epsilon1).all() shouldBe true
            a.equal(b, Vec4(epsilon1)).all() shouldBe true

            a.equal(b, epsilon2).any() shouldBe false
            a.equal(b, Vec4(epsilon2)).any() shouldBe false
        }
        run {
            val a = Vec1d(1.01)
            val b = Vec1d(1.02)
            val epsilon1 = 0.1
            val epsilon2 = 0.001

            a.equal(b, epsilon1).all() shouldBe true
            a.equal(b, Vec1d(epsilon1)).all() shouldBe true

            a.equal(b, epsilon2).any() shouldBe false
            a.equal(b, Vec1d(epsilon2)).any() shouldBe false
        }
        run {
            val a = Vec2d(1.01)
            val b = Vec2d(1.02)
            val epsilon1 = 0.1
            val epsilon2 = 0.001

            a.equal(b, epsilon1).all() shouldBe true
            a.equal(b, Vec2d(epsilon1)).all() shouldBe true

            a.equal(b, epsilon2).any() shouldBe false
            a.equal(b, Vec2d(epsilon2)).any() shouldBe false
        }
        run {
            val a = Vec3d(1.01)
            val b = Vec3d(1.02)
            val epsilon1 = 0.1
            val epsilon2 = 0.001

            a.equal(b, epsilon1).all() shouldBe true
            a.equal(b, Vec3d(epsilon1)).all() shouldBe true

            a.equal(b, epsilon2).any() shouldBe false
            a.equal(b, Vec3d(epsilon2)).any() shouldBe false
        }
        run {
            val a = Vec4d(1.01)
            val b = Vec4d(1.02)
            val epsilon1 = 0.1
            val epsilon2 = 0.001

            a.equal(b, epsilon1).all() shouldBe true
            a.equal(b, Vec4d(epsilon1)).all() shouldBe true

            a.equal(b, epsilon2).any() shouldBe false
            a.equal(b, Vec4d(epsilon2)).any() shouldBe false
        }
    }

    @Test
    fun notEqual() {
        run {
            val a = Vec1(1.01f)
            val b = Vec1(1.02f)
            val epsilon1 = 0.1f
            val epsilon2 = 0.001f

            a.notEqual(b, epsilon2).all() shouldBe true
            a.notEqual(b, Vec1(epsilon2)).all() shouldBe true

            a.notEqual(b, epsilon1).any() shouldBe false
            a.notEqual(b, Vec1(epsilon1)).any() shouldBe false
        }
        run {
            val a = Vec2(1.01f)
            val b = Vec2(1.02f)
            val epsilon1 = 0.1f
            val epsilon2 = 0.001f

            a.notEqual(b, epsilon2).all() shouldBe true
            a.notEqual(b, Vec2(epsilon2)).all() shouldBe true

            a.notEqual(b, epsilon1).any() shouldBe false
            a.notEqual(b, Vec2(epsilon1)).any() shouldBe false
        }
        run {
            val a = Vec3(1.01f)
            val b = Vec3(1.02f)
            val epsilon1 = 0.1f
            val epsilon2 = 0.001f

            a.notEqual(b, epsilon2).all() shouldBe true
            a.notEqual(b, Vec3(epsilon2)).all() shouldBe true

            a.notEqual(b, epsilon1).any() shouldBe false
            a.notEqual(b, Vec3(epsilon1)).any() shouldBe false
        }
        run {
            val a = Vec4(1.01f)
            val b = Vec4(1.02f)
            val epsilon1 = 0.1f
            val epsilon2 = 0.001f

            a.notEqual(b, epsilon2).all() shouldBe true
            a.notEqual(b, Vec4(epsilon2)).all() shouldBe true

            a.notEqual(b, epsilon1).any() shouldBe false
            a.notEqual(b, Vec4(epsilon1)).any() shouldBe false
        }
        run {
            val a = Vec1d(1.01)
            val b = Vec1d(1.02)
            val epsilon1 = 0.1
            val epsilon2 = 0.001

            a.notEqual(b, epsilon2).all() shouldBe true
            a.notEqual(b, Vec1d(epsilon2)).all() shouldBe true

            a.notEqual(b, epsilon1).any() shouldBe false
            a.notEqual(b, Vec1d(epsilon1)).any() shouldBe false
        }
        run {
            val a = Vec2d(1.01)
            val b = Vec2d(1.02)
            val epsilon1 = 0.1
            val epsilon2 = 0.001

            a.notEqual(b, epsilon2).all() shouldBe true
            a.notEqual(b, Vec2d(epsilon2)).all() shouldBe true

            a.notEqual(b, epsilon1).any() shouldBe false
            a.notEqual(b, Vec2d(epsilon1)).any() shouldBe false
        }
        run {
            val a = Vec3d(1.01)
            val b = Vec3d(1.02)
            val epsilon1 = 0.1
            val epsilon2 = 0.001

            a.notEqual(b, epsilon2).all() shouldBe true
            a.notEqual(b, Vec3d(epsilon2)).all() shouldBe true

            a.notEqual(b, epsilon1).any() shouldBe false
            a.notEqual(b, Vec3d(epsilon1)).any() shouldBe false
        }
        run {
            val a = Vec4d(1.01)
            val b = Vec4d(1.02)
            val epsilon1 = 0.1
            val epsilon2 = 0.001

            a.notEqual(b, epsilon2).all() shouldBe true
            a.notEqual(b, Vec4d(epsilon2)).all() shouldBe true

            a.notEqual(b, epsilon1).any() shouldBe false
            a.notEqual(b, Vec4d(epsilon1)).any() shouldBe false
        }
    }
}