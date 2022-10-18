package glm_.func

import glm_.shouldBe
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
import kotlin.test.Test

class funcVectorRelational {

    @Test
    fun not() {
        Vec1bool(false).not().all() shouldBe true
        Vec2bool(false).not().all() shouldBe true
        Vec3bool(false).not().all() shouldBe true
        Vec4bool(false).not().all() shouldBe true
    }

    @Test
    fun less() {

        run {
            val a = Vec2 { 1f + it }
            val b = Vec2 { 2f + it }
            (a lessThan b).all() shouldBe true
            (a lessThanEqual b).all() shouldBe true
        }

        run {
            val a = Vec3 { 1f + it }
            val b = Vec3 { 2f + it }
            (a lessThan b).all() shouldBe true
            (a lessThanEqual b).all() shouldBe true
        }

        run {
            val a = Vec4 { 1f + it }
            val b = Vec4 { 2f + it }
            (a lessThan b).all() shouldBe true
            (a lessThanEqual b).all() shouldBe true
        }

        run {
            val a = Vec2i { 1 + it }
            val b = Vec2i { 2 + it }
            (a lessThan b).all() shouldBe true

            val c = Vec2i(1, 3)
            (a lessThanEqual c).all() shouldBe true
        }

        run {
            val a = Vec3i { 1 + it }
            val b = Vec3i { 2 + it }
            (a lessThan b).all() shouldBe true

            val c = Vec3i(1, 3, 4)
            (a lessThanEqual c).all() shouldBe true
        }

        run {
            val a = Vec4i { 1 + it }
            val b = Vec4i { 2 + it }
            (a lessThan b).all() shouldBe true

            val c = Vec4i(1, 3, 4, 5)
            (a lessThanEqual c).all() shouldBe true
        }
    }

    @Test
    fun greater() {

        run {
            val a = Vec2 { 1f + it }
            val b = Vec2 { 2f + it }
            (b greaterThan a).all() shouldBe true
            (b greaterThanEqual a).all() shouldBe true
        }

        run {
            val a = Vec3 { 1f + it }
            val b = Vec3 { 2f + it }
            (b greaterThan a).all() shouldBe true
            (b greaterThanEqual a).all() shouldBe true
        }

        run {
            val a = Vec4 { 1f + it }
            val b = Vec4 { 2f + it }
            (b greaterThan a).all() shouldBe true
            (b greaterThanEqual a).all() shouldBe true
        }

        run {
            val a = Vec2i { 1 + it }
            val b = Vec2i { 2 + it }
            (b greaterThan a).all() shouldBe true

            val c = Vec2i(1, 3)
            (c greaterThanEqual a).all() shouldBe true
        }

        run {
            val a = Vec3i { 1 + it }
            val b = Vec3i { 2 + it }
            (b greaterThan a).all() shouldBe true

            val c = Vec3i(1, 3, 4)
            (c greaterThanEqual a).all() shouldBe true
        }

        run {
            val a = Vec4i { 1 + it }
            val b = Vec4i { 2 + it }
            (b greaterThan a).all() shouldBe true

            val c = Vec4i(1, 3, 4, 5)
            (c greaterThanEqual a).all() shouldBe true
        }
    }

    @Test
    fun equal() {

        run {
            val a = Vec2i { 1 + it }
            val b = Vec2i { 1 + it }
            (b equal a).all() shouldBe true
        }

        run {
            val a = Vec3i { 1 + it }
            val b = Vec3i { 1 + it }
            (b equal a).all() shouldBe true
        }

        run {
            val a = Vec4i { 1 + it }
            val b = Vec4i { 1 + it }
            (b equal a).all() shouldBe true
        }
    }
}