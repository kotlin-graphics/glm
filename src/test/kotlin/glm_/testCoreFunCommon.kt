package glm_

import glm_.glm.epsilonF
import glm_.vec1.Vec1
import glm_.vec1.Vec1d
import glm_.vec1.Vec1i
import glm_.vec2.Vec2
import glm_.vec2.Vec2bool
import glm_.vec2.Vec2d
import glm_.vec2.Vec2i
import glm_.vec3.Vec3
import glm_.vec3.Vec3bool
import glm_.vec3.Vec3d
import glm_.vec3.Vec3i
import glm_.vec4.Vec4
import glm_.vec4.Vec4bool
import glm_.vec4.Vec4d
import glm_.vec4.Vec4i
import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.StringSpec

/**
 * Created by elect on 11/11/16.
 */

class testCoreFunCommon : StringSpec() {

    init {

        "floor" {

            run {
                val a = 1.1f
                val b = glm.floor(a)
                glm.epsilonEqual(b, 1f, 0.0001f) shouldBe true
            }

            run {
                val a = 1.1
                val b = glm.floor(a)
                glm.epsilonEqual(b, 1.0, 0.0001) shouldBe true
            }

            run {
                val a = Vec1(1.1f)
                val b = glm.floor(a)

                glm.all(glm.epsilonEqual(b, Vec1(1.0), 0.0001f)) shouldBe true
            }

            run {
                val a = Vec1d(1.1)
                val b = glm.floor(a)

                glm.all(glm.epsilonEqual(b, Vec1d(1.0), 0.0001)) shouldBe true
            }

            run {
                val a = Vec2(1.1f)
                val b = glm.floor(a)

                glm.all(glm.epsilonEqual(b, Vec2(1.0), 0.0001f)) shouldBe true
            }

            run {
                val a = Vec2d(1.1)
                val b = glm.floor(a)

                glm.all(glm.epsilonEqual(b, Vec2d(1.0), 0.0001)) shouldBe true
            }

            run {
                val a = Vec3(1.1f)
                val b = glm.floor(a)

                glm.all(glm.epsilonEqual(b, Vec3(1.0), 0.0001f)) shouldBe true
            }

            run {
                val a = Vec3d(1.1)
                val b = glm.floor(a)

                glm.all(glm.epsilonEqual(b, Vec3d(1.0), 0.0001)) shouldBe true
            }

            run {
                val a = Vec4(1.1f)
                val b = glm.floor(a)

                glm.all(glm.epsilonEqual(b, Vec4(1.0), 0.0001f)) shouldBe true
            }

            run {
                val a = Vec4d(1.1)
                val b = glm.floor(a)

                glm.all(glm.epsilonEqual(b, Vec4d(1.0), 0.0001)) shouldBe true
            }
        }

        "mod" {

            run {
                val x = 1.5f
                _bF = 0f
                val a = glm.modf(x, ::_bF)

                _bF shouldBe 1f
                a shouldBe 0.5f
            }

            run {
                val x = Vec4(1.1f, 1.2f, 1.5f, 1.7f)
                val i = Vec4(0f)
                val a = glm.modf(x, i)

                i shouldBe Vec4(1f)
                glm.all(glm.epsilonEqual(a, Vec4(0.1f, 0.2f, 0.5f, 0.7f), 0.00001f)) shouldBe true
            }

            run {
                val x = Vec4d(1.1, 1.2, 1.5, 1.7)
                val i = Vec4d(0.0)
                val a = glm.modf(x, i)

                i shouldBe Vec4d(1.0)
                glm.all(glm.epsilonEqual(a, Vec4d(0.1, 0.2, 0.5, 0.7), 0.000000001)) shouldBe true
            }

            run {
                val x = 1.5
                bD = 0.0
                val a = glm.modf(x, ::bD)

                bD shouldBe 1.0
                a shouldBe 0.5
            }
        }

        "mod" {

            run {
                val a = 1.5f
                val b = 1f
                val c = glm.mod(a, b)

                (glm.abs(c - 0.5f) < 0.00001f) shouldBe true
            }

            run {
                val a = -0.2f
                val b = 1f
                val c = glm.mod(a, b)

                (glm.abs(c - 0.8f) < 0.00001f) shouldBe true
            }

            run {
                val a = 3f
                val b = 2f
                val c = glm.mod(a, b)

                (glm.abs(c - 1f) < 0.00001f) shouldBe true
            }

            run {
                val a = Vec4(3.0)
                val b = 2f
                val c = glm.mod(a, b)

                glm.all(glm.epsilonEqual(c, Vec4(1f), 0.00001f)) shouldBe true
            }

            run {
                val a = Vec4(3.0)
                val b = Vec4(2f)
                val c = glm.mod(a, b)

                glm.all(glm.epsilonEqual(c, Vec4(1f), 0.00001f)) shouldBe true
            }
        }

        "floatBitsToInt" {

            run {
                val a = 1f
                val b = glm.floatBitsToInt(a)
                val c = glm.intBitsToFloat(b)
                glm.epsilonEqual(a, c, 0.0001f) shouldBe true
            }

            run {
                val a = Vec2(1f, 2f)
                val b = glm.floatBitsToInt(a)
                val c = glm.intBitsToFloat(b)
                glm.all(glm.epsilonEqual(a, c, 0.0001f)) shouldBe true
            }

            run {
                val a = Vec3(1f, 2f, 3f)
                val b = glm.floatBitsToInt(a)
                val c = glm.intBitsToFloat(b)
                glm.all(glm.epsilonEqual(a, c, 0.0001f)) shouldBe true
            }

            run {
                val a = Vec4(1f, 2f, 3f, 4f)
                val b = glm.floatBitsToInt(a)
                val c = glm.intBitsToFloat(b)
                glm.all(glm.epsilonEqual(a, c, 0.0001f)) shouldBe true
            }
        }

        "floatBitsToUint" {

            run {
                val a = 1f
                val b = glm.floatBitsToUint(a)
                val c = glm.uintBitsToFloat(b)
                glm.epsilonEqual(a, c, 0.0001f) shouldBe true
            }

            run {
                val a = Vec2(1f, 2f)
                val b = glm.floatBitsToUint(a)
                val c = glm.uintBitsToFloat(b)
                glm.all(glm.epsilonEqual(a, c, 0.0001f)) shouldBe true
            }

            run {
                val a = Vec3(1f, 2f, 3f)
                val b = glm.floatBitsToUint(a)
                val c = glm.uintBitsToFloat(b)
                glm.all(glm.epsilonEqual(a, c, 0.0001f)) shouldBe true
            }

            run {
                val a = Vec4(1f, 2f, 3f, 4f)
                val b = glm.floatBitsToUint(a)
                val c = glm.uintBitsToFloat(b)
                glm.all(glm.epsilonEqual(a, c, 0.0001f)) shouldBe true
            }
        }

        "min" {

            val a0 = glm.min(Vec1(1), Vec1(1))

            val b0 = glm.min(Vec2(1), Vec2(1))
            val b1 = glm.min(Vec2(1), 1f)
            val b2 = glm.all(glm.equal(b0, b1))
            b2 shouldBe true

            val c0 = glm.min(Vec3(1), Vec3(1))
            val c1 = glm.min(Vec3(1), 1f)
            val c2 = glm.all(glm.equal(c0, c1))
            c2 shouldBe true

            val d0 = glm.min(Vec4(1), Vec4(1))
            val d1 = glm.min(Vec4(1), 1f)
            val d2 = glm.all(glm.equal(d0, d1))
            d2 shouldBe true
        }

        "max" {

            val a0 = glm.max(Vec1(1), Vec1(1))

            val b0 = glm.max(Vec2(1), Vec2(1))
            val b1 = glm.max(Vec2(1), 1f)
            val b2 = glm.all(glm.equal(b0, b1))
            b2 shouldBe true

            val c0 = glm.max(Vec3(1), Vec3(1))
            val c1 = glm.max(Vec3(1), 1f)
            val c2 = glm.all(glm.equal(c0, c1))
            c2 shouldBe true

            val d0 = glm.max(Vec4(1), Vec4(1))
            val d1 = glm.max(Vec4(1), 1f)
            val d2 = glm.all(glm.equal(d0, d1))
            d2 shouldBe true
        }

        "mix" {

            class Entry<T, B>(val x: T, val y: T, val a: B, val result: T)

            val testBool = arrayOf(
                    Entry(0f, 1f, false, 0f),
                    Entry(0f, 1f, true, 1f),
                    Entry(-1f, 1f, false, -1f),
                    Entry(-1f, 1f, true, 1f))

            val testFloat = arrayOf(
                    Entry(0f, 1f, 0f, 0f),
                    Entry(0f, 1f, 1f, 1f),
                    Entry(-1f, 1f, 0f, -1f),
                    Entry(-1f, 1f, 1f, 1f))

            val testVec2Bool = arrayOf(
                    Entry(Vec2(0f), Vec2(1f), false, Vec2(0f)),
                    Entry(Vec2(0f), Vec2(1f), true, Vec2(1f)),
                    Entry(Vec2(-1f), Vec2(1f), false, Vec2(-1f)),
                    Entry(Vec2(-1f), Vec2(1f), true, Vec2(1f)))

            val testBVec2 = arrayOf(
                    Entry(Vec2(0f), Vec2(1f), Vec2bool(false), Vec2(0f)),
                    Entry(Vec2(0f), Vec2(1f), Vec2bool(true), Vec2(1f)),
                    Entry(Vec2(-1f), Vec2(1f), Vec2bool(false), Vec2(-1f)),
                    Entry(Vec2(-1f), Vec2(1f), Vec2bool(true), Vec2(1f)),
                    Entry(Vec2(-1f), Vec2(1f), Vec2bool(true, false), Vec2(1f, -1f)))

            val testVec3Bool = arrayOf(
                    Entry(Vec3(0f), Vec3(1f), false, Vec3(0f)),
                    Entry(Vec3(0f), Vec3(1f), true, Vec3(1f)),
                    Entry(Vec3(-1f), Vec3(1f), false, Vec3(-1f)),
                    Entry(Vec3(-1f), Vec3(1f), true, Vec3(1f)))

            val testBVec3 = arrayOf(
                    Entry(Vec3(0f), Vec3(1f), Vec3bool(false), Vec3(0f)),
                    Entry(Vec3(0f), Vec3(1f), Vec3bool(true), Vec3(1f)),
                    Entry(Vec3(-1f), Vec3(1f), Vec3bool(false), Vec3(-1f)),
                    Entry(Vec3(-1f), Vec3(1f), Vec3bool(true), Vec3(1f)),
                    Entry(Vec3(1f, 2f, 3f), Vec3(4f, 5f, 6f), Vec3bool(true, false, true), Vec3(4f, 2f, 6f)))

            val testVec4Bool = arrayOf(
                    Entry(Vec4(0f), Vec4(1f), false, Vec4(0f)),
                    Entry(Vec4(0f), Vec4(1f), true, Vec4(1f)),
                    Entry(Vec4(-1f), Vec4(1f), false, Vec4(-1f)),
                    Entry(Vec4(-1f), Vec4(1f), true, Vec4(1f)))

            val testBVec4 = arrayOf(
                    Entry(Vec4(0f, 0f, 1f, 1f), Vec4(2f, 2f, 3f, 3f), Vec4bool(false, true, false, true), Vec4(0f, 2f, 1f, 3f)),
                    Entry(Vec4(0f), Vec4(1f), Vec4bool(true), Vec4(1f)),
                    Entry(Vec4(-1f), Vec4(1f), Vec4bool(false), Vec4(-1f)),
                    Entry(Vec4(-1f), Vec4(1f), Vec4bool(true), Vec4(1f)),
                    Entry(Vec4(1f, 2f, 3f, 4f), Vec4(5f, 6f, 7f, 8f), Vec4bool(true, false, true, false), Vec4(5f, 2f, 7f, 4f))
            )

            // Float with bool
            for (i in 0..3) {
                val result = glm.mix(testBool[i].x, testBool[i].y, testBool[i].a)
                glm.epsilonEqual(result, testBool[i].result, epsilonF) shouldBe true
            }

            // Float with float
            for (i in 0..3) {
                val result = glm.mix(testFloat[i].x, testFloat[i].y, testFloat[i].a)
                glm.epsilonEqual(result, testFloat[i].result, epsilonF) shouldBe true
            }

            // vec2 with bool
            for (i in 0..3) {
                val result = glm.mix(testVec2Bool[i].x, testVec2Bool[i].y, testVec2Bool[i].a)
                glm.epsilonEqual(result.x, testVec2Bool[i].result.x, epsilonF) shouldBe true
                glm.epsilonEqual(result.y, testVec2Bool[i].result.y, epsilonF) shouldBe true
            }

            // vec2 with bvec2
            for (i in 0..3) {
                val result = glm.mix(testBVec2[i].x, testBVec2[i].y, testBVec2[i].a)
                glm.epsilonEqual(result.x, testBVec2[i].result.x, epsilonF) shouldBe true
                glm.epsilonEqual(result.y, testBVec2[i].result.y, epsilonF) shouldBe true
            }

            // vec3 with bool
            for (i in 0..3) {
                val result = glm.mix(testVec3Bool[i].x, testVec3Bool[i].y, testVec3Bool[i].a)
                glm.epsilonEqual(result.x, testVec3Bool[i].result.x, epsilonF) shouldBe true
                glm.epsilonEqual(result.y, testVec3Bool[i].result.y, epsilonF) shouldBe true
                glm.epsilonEqual(result.z, testVec3Bool[i].result.z, epsilonF) shouldBe true
            }

            // vec3 with bvec3
            for (i in 0..3) {
                val result = glm.mix(testBVec3[i].x, testBVec3[i].y, testBVec3[i].a)
                glm.epsilonEqual(result.x, testBVec3[i].result.x, epsilonF) shouldBe true
                glm.epsilonEqual(result.y, testBVec3[i].result.y, epsilonF) shouldBe true
                glm.epsilonEqual(result.z, testBVec3[i].result.z, epsilonF) shouldBe true
            }

            // vec4 with bool
            for (i in 0..3) {
                val result = glm.mix(testVec4Bool[i].x, testVec4Bool[i].y, testVec4Bool[i].a)
                glm.epsilonEqual(result.x, testVec4Bool[i].result.x, epsilonF) shouldBe true
                glm.epsilonEqual(result.y, testVec4Bool[i].result.y, epsilonF) shouldBe true
                glm.epsilonEqual(result.z, testVec4Bool[i].result.z, epsilonF) shouldBe true
                glm.epsilonEqual(result.w, testVec4Bool[i].result.w, epsilonF) shouldBe true
            }

            // vec4 with bvec4
            for (i in 0..3) {
                val result = glm.mix(testBVec4[i].x, testBVec4[i].y, testBVec4[i].a)
                glm.epsilonEqual(result.x, testBVec4[i].result.x, epsilonF) shouldBe true
                glm.epsilonEqual(result.y, testBVec4[i].result.y, epsilonF) shouldBe true
                glm.epsilonEqual(result.z, testBVec4[i].result.z, epsilonF) shouldBe true
                glm.epsilonEqual(result.w, testBVec4[i].result.w, epsilonF) shouldBe true
            }
        }

        "step" {

            class Entry<Edge, Vec>(val edge: Edge, val x: Vec, val result: Vec)

            val testVec4Scalar = arrayOf(
                    Entry(1f, Vec4(1f, 2f, 3f, 4f), Vec4(1f)),
                    Entry(0f, Vec4(1f, 2f, 3f, 4f), Vec4(1f)),
                    Entry(0f, Vec4(-1f, -2f, -3f, -4f), Vec4(0f)))

            val testVec4Vector = arrayOf(
                    Entry(Vec4(-1f, -2f, -3f, -4f), Vec4(-2f, -3f, -4f, -5f), Vec4(0f)),
                    Entry(Vec4(0f, 1f, 2f, 3f), Vec4(1f, 2f, 3f, 4f), Vec4(1f)),
                    Entry(Vec4(2f, 3f, 4f, 5f), Vec4(1f, 2f, 3f, 4f), Vec4(0f)),
                    Entry(Vec4(0f, 1f, 2f, 3f), Vec4(-1f, -2f, -3f, -4f), Vec4(0f)))

            // scalar
            run {

                val edge = 2f

                val a = glm.step(edge, 1f)
                glm.epsilonEqual(a, 0f, epsilonF) shouldBe true

                val b = glm.step(edge, 3f)
                glm.epsilonEqual(b, 1f, epsilonF) shouldBe true

                val c = glm.step(edge, 2f)
                glm.epsilonEqual(c, 1f, epsilonF) shouldBe true
            }

            // vec4 and float
            for (i in 0..2) {
                val result = glm.step(testVec4Scalar[i].edge, testVec4Scalar[i].x)
                glm.all(glm.epsilonEqual(result, testVec4Scalar[i].result, epsilonF)) shouldBe true
            }

            // vec4 and vec4
            for (i in 0..3) {
                val result = glm.step(testVec4Vector[i].edge, testVec4Vector[i].x)
                glm.all(glm.epsilonEqual(result, testVec4Vector[i].result, epsilonF)) shouldBe true
            }
        }

        "round" {

            run {
                val a = glm.round(0f)
                glm.epsilonEqual(a, 0f, epsilonF) shouldBe true
                val b = glm.round(0.5f)
                glm.epsilonEqual(b, 1f, epsilonF) shouldBe true
                val c = glm.round(1f)
                glm.epsilonEqual(c, 1f, epsilonF) shouldBe true
                val d = glm.round(0.1f)
                glm.epsilonEqual(d, 0f, epsilonF) shouldBe true
                val e = glm.round(0.9f)
                glm.epsilonEqual(e, 1f, epsilonF) shouldBe true
                val f = glm.round(1.5f)
                glm.epsilonEqual(f, 2f, epsilonF) shouldBe true
                val g = glm.round(1.9f)
                glm.epsilonEqual(g, 2f, epsilonF) shouldBe true
            }

            run {
                val a = glm.round(-0f)
                glm.epsilonEqual(a, 0f, epsilonF) shouldBe true
                val b = glm.round(-0.5f)
                glm.epsilonEqual(b, -1f, epsilonF) shouldBe true
                val c = glm.round(-1f)
                glm.epsilonEqual(c, -1f, epsilonF) shouldBe true
                val d = glm.round(-0.1f)
                glm.epsilonEqual(d, 0f, epsilonF) shouldBe true
                val e = glm.round(-0.9f)
                glm.epsilonEqual(e, -1f, epsilonF) shouldBe true
                val f = glm.round(-1.5f)
                glm.epsilonEqual(f, -2f, epsilonF) shouldBe true
                val g = glm.round(-1.9f)
                glm.epsilonEqual(g, -2f, epsilonF) shouldBe true
            }
        }

        "round even" {

            run {
                val a1 = glm.roundEven(-1.5f)
                glm.epsilonEqual(a1, -2f, 0.0001f) shouldBe true

                val a2 = glm.roundEven(1.5f)
                glm.epsilonEqual(a2, 2f, 0.0001f) shouldBe true

                val a5 = glm.roundEven(-2.5f)
                glm.epsilonEqual(a5, -2f, 0.0001f) shouldBe true

                val a6 = glm.roundEven(2.5f)
                glm.epsilonEqual(a6, 2f, 0.0001f) shouldBe true

                val a3 = glm.roundEven(-3.5f)
                glm.epsilonEqual(a3, -4f, 0.0001f) shouldBe true

                val a4 = glm.roundEven(3.5f)
                glm.epsilonEqual(a4, 4f, 0.0001f) shouldBe true

                val c7 = glm.roundEven(-4.5f)
                glm.epsilonEqual(c7, -4f, 0.0001f) shouldBe true

                val c8 = glm.roundEven(4.5f)
                glm.epsilonEqual(c8, 4f, 0.0001f) shouldBe true

                val c1 = glm.roundEven(-5.5f)
                glm.epsilonEqual(c1, -6f, 0.0001f) shouldBe true

                val c2 = glm.roundEven(5.5f)
                glm.epsilonEqual(c2, 6f, 0.0001f) shouldBe true

                val c3 = glm.roundEven(-6.5f)
                glm.epsilonEqual(c3, -6f, 0.0001f) shouldBe true

                val c4 = glm.roundEven(6.5f)
                glm.epsilonEqual(c4, 6f, 0.0001f) shouldBe true

                val c5 = glm.roundEven(-7.5f)
                glm.epsilonEqual(c5, -8f, 0.0001f) shouldBe true

                val c6 = glm.roundEven(7.5f)
                glm.epsilonEqual(c6, 8f, 0.0001f) shouldBe true
            }

            run {
                val a7 = glm.roundEven(-2.4f)
                glm.epsilonEqual(a7, -2f, 0.0001f) shouldBe true

                val a8 = glm.roundEven(2.4f)
                glm.epsilonEqual(a8, 2f, 0.0001f) shouldBe true

                val b1 = glm.roundEven(-2.6f)
                glm.epsilonEqual(b1, -3f, 0.0001f) shouldBe true

                val b2 = glm.roundEven(2.6f)
                glm.epsilonEqual(b2, 3f, 0.0001f) shouldBe true

                val b3 = glm.roundEven(-2f)
                glm.epsilonEqual(b3, -2f, 0.0001f) shouldBe true

                val b4 = glm.roundEven(2f)
                glm.epsilonEqual(b4, 2f, 0.0001f) shouldBe true
            }

            run {
                val a = glm.roundEven(0f)
                glm.epsilonEqual(a, 0f, epsilonF) shouldBe true
                val b = glm.roundEven(0.5f)
                glm.epsilonEqual(b, 0f, epsilonF) shouldBe true
                val c = glm.roundEven(1f)
                glm.epsilonEqual(c, 1f, epsilonF) shouldBe true
                val d = glm.roundEven(0.1f)
                glm.epsilonEqual(d, 0f, epsilonF) shouldBe true
                val e = glm.roundEven(0.9f)
                glm.epsilonEqual(e, 1f, epsilonF) shouldBe true
                val f = glm.roundEven(1.5f)
                glm.epsilonEqual(f, 2f, epsilonF) shouldBe true
                val g = glm.roundEven(1.9f)
                glm.epsilonEqual(g, 2f, epsilonF) shouldBe true
            }

            run {
                val a = glm.roundEven(-0f)
                glm.epsilonEqual(a, 0f, epsilonF) shouldBe true
                val b = glm.roundEven(-0.5f)
                glm.epsilonEqual(b, -0f, epsilonF) shouldBe true
                val c = glm.roundEven(-1f)
                glm.epsilonEqual(c, -1f, epsilonF) shouldBe true
                val d = glm.roundEven(-0.1f)
                glm.epsilonEqual(d, 0f, epsilonF) shouldBe true
                val e = glm.roundEven(-0.9f)
                glm.epsilonEqual(e, -1f, epsilonF) shouldBe true
                val f = glm.roundEven(-1.5f)
                glm.epsilonEqual(f, -2f, epsilonF) shouldBe true
                val g = glm.roundEven(-1.9f)
                glm.epsilonEqual(g, -2f, epsilonF) shouldBe true
            }

            run {
                val a = glm.roundEven(1.5f)
                glm.epsilonEqual(a, 2f, epsilonF) shouldBe true
                val b = glm.roundEven(2.5f)
                glm.epsilonEqual(b, 2f, epsilonF) shouldBe true
                val c = glm.roundEven(3.5f)
                glm.epsilonEqual(c, 4f, epsilonF) shouldBe true
                val d = glm.roundEven(4.5f)
                glm.epsilonEqual(d, 4f, epsilonF) shouldBe true
                val e = glm.roundEven(5.5f)
                glm.epsilonEqual(e, 6f, epsilonF) shouldBe true
                val f = glm.roundEven(6.5f)
                glm.epsilonEqual(f, 6f, epsilonF) shouldBe true
                val g = glm.roundEven(7.5f)
                glm.epsilonEqual(g, 8f, epsilonF) shouldBe true
            }

            run {
                val a = glm.roundEven(-1.5f)
                glm.epsilonEqual(a, -2f, epsilonF) shouldBe true
                val b = glm.roundEven(-2.5f)
                glm.epsilonEqual(b, -2f, epsilonF) shouldBe true
                val c = glm.roundEven(-3.5f)
                glm.epsilonEqual(c, -4f, epsilonF) shouldBe true
                val d = glm.roundEven(-4.5f)
                glm.epsilonEqual(d, -4f, epsilonF) shouldBe true
                val e = glm.roundEven(-5.5f)
                glm.epsilonEqual(e, -6f, epsilonF) shouldBe true
                val f = glm.roundEven(-6.5f)
                glm.epsilonEqual(f, -6f, epsilonF) shouldBe true
                val g = glm.roundEven(-7.5f)
                glm.epsilonEqual(g, -8f, epsilonF) shouldBe true
            }
        }

        "is NaN" {

            val zeroF = 0f
            val zeroD = 0.0

            run {
                glm.isNan(0.0 / zeroD) shouldBe true
                glm.any(glm.isNan(Vec2d(0.0 / zeroD))) shouldBe true
                glm.any(glm.isNan(Vec3d(0.0 / zeroD))) shouldBe true
                glm.any(glm.isNan(Vec4d(0.0 / zeroD))) shouldBe true
            }

            run {
                glm.isNan(0f / zeroF) shouldBe true
                glm.any(glm.isNan(Vec2(0f / zeroF))) shouldBe true
                glm.any(glm.isNan(Vec3(0f / zeroF))) shouldBe true
                glm.any(glm.isNan(Vec4(0f / zeroF))) shouldBe true
            }
        }

        "is Inf" {

            val zeroF = 0f
            val zeroD = 0.0

            run {
                glm.isInf(+1.0 / zeroD) shouldBe true
                glm.isInf(-1.0 / zeroD) shouldBe true
                glm.any(glm.isInf(Vec2d(+1.0 / zeroD))) shouldBe true
                glm.any(glm.isInf(Vec2d(-1.0 / zeroD))) shouldBe true
                glm.any(glm.isInf(Vec3d(+1.0 / zeroD))) shouldBe true
                glm.any(glm.isInf(Vec3d(-1.0 / zeroD))) shouldBe true
                glm.any(glm.isInf(Vec4d(+1.0 / zeroD))) shouldBe true
                glm.any(glm.isInf(Vec4d(-1.0 / zeroD))) shouldBe true
            }

            run {
                glm.isInf(+1f / zeroF) shouldBe true
                glm.isInf(-1f / zeroF) shouldBe true
                glm.any(glm.isInf(Vec2(+1f / zeroF))) shouldBe true
                glm.any(glm.isInf(Vec2(-1f / zeroF))) shouldBe true
                glm.any(glm.isInf(Vec3(+1f / zeroF))) shouldBe true
                glm.any(glm.isInf(Vec3(-1f / zeroF))) shouldBe true
                glm.any(glm.isInf(Vec4(+1f / zeroF))) shouldBe true
                glm.any(glm.isInf(Vec4(-1f / zeroF))) shouldBe true
            }
        }

        "sign" {

            class Type<T>(val value: T, val return_: T)

            // Int
            arrayOf(
                    Type(Int.MAX_VALUE, 1),
                    Type(Int.MIN_VALUE, -1),
                    Type(0, 0),
                    Type(1, 1),
                    Type(2, 1),
                    Type(3, 1),
                    Type(-1, -1),
                    Type(-2, -1),
                    Type(-3, -1))
                    .forEach {
                        val result = glm.sign(it.value)
                        it.return_ shouldBe result
                    }

            // vec4
            arrayOf(
                    Type(Vec4(1), Vec4(1)),
                    Type(Vec4(0), Vec4(0)),
                    Type(Vec4(2), Vec4(1)),
                    Type(Vec4(3), Vec4(1)),
                    Type(Vec4(-1), Vec4(-1)),
                    Type(Vec4(-2), Vec4(-1)),
                    Type(Vec4(-3), Vec4(-1)))
                    .forEach {
                        val result = glm.sign(it.value)
                        glm.all(glm.equal(it.return_, result)) shouldBe true
                    }
        }

        "frexp" {

            run {
                val x = Vec1(1024)
                val exp = Vec1i()
                val a = glm.frexp(x, exp)
                glm.all(glm.epsilonEqual(a, Vec1(1), 0.00001f)) shouldBe true
                glm.all(glm.equal(exp, Vec1i(10))) shouldBe true
            }

            run {
                val x = Vec2(1024, 0.24)
                val exp = Vec2i()
                val a = glm.frexp(x, exp)
                glm.all(glm.epsilonEqual(a, Vec2(1, 0.96), 0.00001f)) shouldBe true
                glm.all(glm.equal(exp, Vec2i(10, -2))) shouldBe true
            }

            run {
                val x = Vec3(1024, 0.24, 0)
                val exp = Vec3i()
                val a = glm.frexp(x, exp)
                glm.all(glm.epsilonEqual(a, Vec3(1, 0.96, 0.0), 0.00001f)) shouldBe true
                glm.all(glm.equal(exp, Vec3i(10, -2, 0))) shouldBe true
            }

            run {
                val x = Vec4(1024, 0.24, 0, -1.33)
                val exp = Vec4i()
                val a = glm.frexp(x, exp)
                glm.all(glm.epsilonEqual(a, Vec4(1, 0.96, 0.0, -0.665), 0.00001f)) shouldBe true
                glm.all(glm.equal(exp, Vec4i(10, -2, 0, 1))) shouldBe true
            }
        }
        
        "ldexp" {

            run {
                val a = Vec1(1)
                val exp = Vec1i(10)
                val x = glm.ldexp(a, exp)
                glm.all(glm.epsilonEqual(x, Vec1(1024),0.00001f)) shouldBe true
            }

            run {
                val a = Vec2(1, 0.96)
                val exp = Vec2i(10, -2)
                val x = glm.ldexp(a, exp)
                glm.all(glm.epsilonEqual(x, Vec2(1024, .24),0.00001f)) shouldBe true
            }

            run {
                val a = Vec3(1, 0.96, 0.0)
                val exp = Vec3i(10, -2, 0)
                val x = glm.ldexp(a, exp)
                glm.all(glm.epsilonEqual(x, Vec3(1024, .24, 0),0.00001f)) shouldBe true
            }

            run {
                val a = Vec4(1, 0.96, 0.0, -0.665)
                val exp = Vec4i(10, -2, 0, 1)
                val x = glm.ldexp(a, exp)
                glm.all(glm.epsilonEqual(x, Vec4(1024, .24, 0, -1.33),0.00001f)) shouldBe true
            }
        }
    }

    companion object {
        var _bF = 0f
        var bD = 0.0
    }
}