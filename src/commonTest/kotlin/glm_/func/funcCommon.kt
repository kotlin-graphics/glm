package glm_.func

import glm_.*
import glm_.scalar.*
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
import kotlin.math.sign
import kotlin.test.Test

class int {

    @Test
    fun floor() {

        run {
            val a = 1.1f
            val b = a.floor()
            b.shouldEqual(1f, 0.0001f)
        }

        run {
            val a = 1.1
            val b = a.floor()
            b.shouldEqual(1.0, 0.0001)
        }

        run {
            val a = Vec1(1.1f)
            val b = a.floor()

            b.shouldEqual(Vec1(1.0), 0.0001f)
        }

        run {
            val a = Vec1d(1.1)
            val b = a.floor()

            b.shouldEqual(Vec1d(1.0), 0.0001)
        }

        run {
            val a = Vec2(1.1f)
            val b = a.floor()

            b.shouldEqual(Vec2(1.0), 0.0001f)
        }

        run {
            val a = Vec2d(1.1)
            val b = a.floor()

            b.shouldEqual(Vec2d(1.0), 0.0001)
        }

        run {
            val a = Vec3(1.1f)
            val b = a.floor()

            b.shouldEqual(Vec3(1.0), 0.0001f)
        }

        run {
            val a = Vec3d(1.1)
            val b = a.floor()

            b.shouldEqual(Vec3d(1.0), 0.0001)
        }

        run {
            val a = Vec4(1.1f)
            val b = a.floor()

            b.shouldEqual(Vec4(1.0), 0.0001f)
        }

        run {
            val a = Vec4d(1.1)
            val b = a.floor()

            b.shouldEqual(Vec4d(1.0), 0.0001)
        }
    }

    @Test
    fun modf() {

        run {
            val x = 1.5f
            val (a, i) = x.modf()

            i.shouldEqual(1f, 0.0001f)
            a.shouldEqual(0.5f, 0.0001f)
        }

        run {
            val x = Vec4(1.1f, 1.2f, 1.5f, 1.7f)
            val (a, i) = x.modf()

            Vec4i(i) shouldBe Vec4i(1)
            a.shouldEqual(Vec4(0.1f, 0.2f, 0.5f, 0.7f), 0.00001f)
        }

        run {
            val x = Vec4d(1.1, 1.2, 1.5, 1.7)
            val (a, i) = x.modf()

            Vec4i(i) shouldBe Vec4i(1)
            a.shouldEqual(Vec4d(0.1, 0.2, 0.5, 0.7), 0.000000001)
        }

        run {
            val x = 1.5
            val (a, i) = x.modf()

            i.shouldEqual(1.0, 0.0001)
            a.shouldEqual(0.5, 0.0001)
        }
    }

    @Test
    fun mod() {
        run {
            val a = 1.5f
            val b = 1.0f
            val c = a.mod(b)

            c.shouldEqual(0.5f, 0.00001f)
        }

        run {
            val a = -0.2f
            val b = 1.0f
            val c = a.mod(b)

            c.shouldEqual(0.8f, 0.00001f)
        }

        run {
            val a = 3.0f
            val b = 2.0f
            val c = a.mod(b)

            c.shouldEqual(1.0f, 0.00001f)
        }

        run {
            val a = Vec4(3.0f)
            val b = 2.0f
            val c = a.mod(b)

            c.shouldEqual(Vec4(1.0f), 0.00001f)
        }

        run {
            val a = Vec4(3.0f)
            val b = Vec4(2.0f)
            val c = a.mod(b)

            c.shouldEqual(Vec4(1.0f), 0.00001f)
        }
    }

    @Test
    fun floatBitsToInt() {
        run {
            val a = 1f
            val b = a.bitsToInt()
            val c = b.bitsToFloat()
            a.shouldEqual(c, 0.0001f)
        }

        run {
            val a = Vec2(1f, 2f)
            val b = a.bitsToInt()
            val c = b.bitsToFloat()
            a.shouldEqual(c, 0.0001f)
        }

        run {
            val a = Vec3(1f, 2f, 3f)
            val b = a.bitsToInt()
            val c = b.bitsToFloat()
            a.shouldEqual(c, 0.0001f)
        }

        run {
            val a = Vec4(1f, 2f, 3f, 4f)
            val b = a.bitsToInt()
            val c = b.bitsToFloat()
            a.shouldEqual(c, 0.0001f)
        }
    }

    @Test
    fun floatBitsToUint() {

        run {
            val a = 1f
            val b = a.bitsToUInt()
            val c = b.bitsToFloat()
            a.shouldEqual(c, 0.0001f)
        }

        run {
            val a = Vec2(1f, 2f)
            val b = a.bitsToUInt()
            val c = b.bitsToFloat()
            a.shouldEqual(c, 0.0001f)
        }

        run {
            val a = Vec3(1f, 2f, 3f)
            val b = a.bitsToUInt()
            val c = b.bitsToFloat()
            a.shouldEqual(c, 0.0001f)
        }

        run {
            val a = Vec4(1f, 2f, 3f, 4f)
            val b = a.bitsToUInt()
            val c = b.bitsToFloat()
            a.shouldEqual(c, 0.0001f)
        }
    }

    @Test
    fun min() {

        val a0 = Vec1(1) min Vec1(1)
        a0 shouldEqual Vec1(1)

        val b0 = Vec2(1) min Vec2(1)
        val b1 = Vec2(1) min 1f
        b0 shouldEqual b1

        val c0 = Vec3(1) min Vec3(1)
        val c1 = Vec3(1) min 1f
        c0 shouldEqual c1

        val d0 = Vec4(1) min Vec4(1)
        val d1 = Vec4(1) min 1f
        d0 shouldEqual d1
    }

    @Test
    fun max() {

        val a0 = Vec1(1) max Vec1(1)
        a0 shouldEqual Vec1(1)

        val b0 = Vec2(1) max Vec2(1)
        val b1 = Vec2(1) max 1f
        b0 shouldEqual b1

        val c0 = Vec3(1) max Vec3(1)
        val c1 = Vec3(1) max 1f
        c0 shouldEqual c1

        val d0 = Vec4(1) max Vec4(1)
        val d1 = Vec4(1) max 1f
        d0 shouldEqual d1
    }

    @Test
    fun mix() {

        // Float with bool
        run {
            val x = listOf(0f, 0f, -1f, -1f)
            val y = listOf(1f, 1f, 1f, 1f)
            val a = listOf(false, true, false, true)
            val result = listOf(0f, 1f, -1f, 1f)
            for (i in x.indices)
                x[i].mix(y[i], a[i]) shouldEqual result[i]
        }
        // Float with float
        run {
            val x = listOf(0f, 0f, -1f, -1f)
            val y = listOf(1f, 1f, 1f, 1f)
            val a = listOf(0f, 1f, 0f, 1f)
            val result = listOf(0f, 1f, -1f, 1f)
            for (i in x.indices)
                x[i].mix(y[i], a[i]) shouldEqual result[i]
        }
        // vec2 with bool
        run {
            val x = listOf(Vec2(0f), Vec2(0f), Vec2(-1f), Vec2(-1f))
            val y = listOf(Vec2(1f), Vec2(1f), Vec2(1f), Vec2(1f))
            val a = listOf(false, true, false, true)
            val result = listOf(Vec2(0f), Vec2(1f), Vec2(-1f), Vec2(1f))
            for (i in x.indices)
                x[i].mix(y[i], a[i]) shouldEqual result[i]
        }
        // vec2 with bvec2
        run {
            val x = listOf(Vec2(0f), Vec2(0f), Vec2(-1f), Vec2(-1f), Vec2(-1f))
            val y = listOf(Vec2(1f), Vec2(1f), Vec2(1f), Vec2(1f), Vec2(1f))
            val a = listOf(Vec2bool(false), Vec2bool(true), Vec2bool(false), Vec2bool(true), Vec2bool(true))
            val result = listOf(Vec2(0f), Vec2(1f), Vec2(-1f), Vec2(1f), Vec2(1f, -1f))
            for (i in x.indices)
                x[i].mix(y[i], a[i]) shouldEqual result[i]
        }
        // vec3 with bool
        run {
            val x = listOf(Vec3(0f), Vec3(0f), Vec3(-1f), Vec3(-1f))
            val y = listOf(Vec3(1f), Vec3(1f), Vec3(1f), Vec3(1f))
            val a = listOf(false, true, false, true)
            val result = listOf(Vec3(0f), Vec3(1f), Vec3(-1f), Vec3(1f))
            for (i in x.indices)
                x[i].mix(y[i], a[i]) shouldEqual result[i]
        }
        // vec3 with bvec3
        run {
            val x = listOf(Vec3(0f), Vec3(0f), Vec3(-1f), Vec3(-1f), Vec3(1f, 2f, 3f))
            val y = listOf(Vec3(1f), Vec3(1f), Vec3(1f), Vec3(1f), Vec3(4f, 5f, 6f))
            val a = listOf(Vec3bool(false), Vec3bool(true), Vec3bool(false), Vec3bool(true), Vec3bool(true, false, true))
            val result = listOf(Vec3(0f), Vec3(1f), Vec3(-1f), Vec3(1f), Vec3(4f, 2f, 6f))
            for (i in x.indices)
                x[i].mix(y[i], a[i]) shouldEqual result[i]
        }
        // vec4 with bool
        run {
            val x = listOf(Vec4(0f), Vec4(0f), Vec4(-1f), Vec4(-1f))
            val y = listOf(Vec4(1f), Vec4(1f), Vec4(1f), Vec4(1f))
            val a = listOf(false, true, false, true)
            val result = listOf(Vec4(0f), Vec4(1f), Vec4(-1f), Vec4(1f))
            for (i in x.indices)
                x[i].mix(y[i], a[i]) shouldEqual result[i]
        }
        // vec4 with bvec4
        run {
            val x = listOf(Vec4(0f, 0f, 1f, 1f), Vec4(0f), Vec4(-1f), Vec4(-1f), Vec4(1f, 2f, 3f, 4f))
            val y = listOf(Vec4(2f, 2f, 3f, 3f), Vec4(1f), Vec4(1f), Vec4(1f), Vec4(5f, 6f, 7f, 8f))
            val a = listOf(Vec4bool(false, true, false, true), Vec4bool(true), Vec4bool(false), Vec4bool(true), Vec4bool(true, false, true, false))
            val result = listOf(Vec4(0f, 2f, 1f, 3f), Vec4(1f), Vec4(-1f), Vec4(1f), Vec4(5f, 2f, 7f, 4f))
            for (i in x.indices)
                x[i].mix(y[i], a[i]) shouldEqual result[i]
        }
    }

    @Test
    fun step() {
        // scalar
        run {
            val edge = 2f

            val a = edge step 1f
            a shouldEqual 0f

            val b = edge step 3f
            b shouldEqual 1f

            val c = edge step 2f
            c shouldEqual 1f
        }
        // vec4 and float
        run {
            val edge = listOf(1f, 0f, 0f)
            val x = listOf(Vec4(1f, 2f, 3f, 4f), Vec4(1f, 2f, 3f, 4f), Vec4(-1f, -2f, -3f, -4f))
            val result = listOf(Vec4(1f), Vec4(1f), Vec4(0f))
            for (i in x.indices)
                x[i].step(edge[i]) shouldEqual result[i]
        }
        // vec4 and vec4
        run {
            val edge = listOf(Vec4(-1f, -2f, -3f, -4f), Vec4(0f, 1f, 2f, 3f), Vec4(2f, 3f, 4f, 5f), Vec4(0f, 1f, 2f, 3f))
            val x = listOf(Vec4(-2f, -3f, -4f, -5f), Vec4(1f, 2f, 3f, 4f), Vec4(1f, 2f, 3f, 4f), Vec4(-1f, -2f, -3f, -4f))
            val result = listOf(Vec4(0f), Vec4(1f), Vec4(0f), Vec4(0f))
            for (i in x.indices)
                x[i].step(edge[i]) shouldEqual result[i]
        }
    }

    @Test
    fun round() {
        run {
            0f.round() shouldEqual 0f
            0.5f.round() shouldEqual 1f
            1f.round() shouldEqual 1f
            0.1f.round() shouldEqual 0f
            0.9f.round() shouldEqual 1f
            1.5f.round() shouldEqual 2f
            1.9f.round() shouldEqual 2f
        }

        run {
            (-0f).round() shouldEqual 0f
            (-0.5f).round() shouldEqual -1f
            (-1f).round() shouldEqual -1f
            (-0.1f).round() shouldEqual 0f
            (-0.9f).round() shouldEqual -1f
            (-1.5f).round() shouldEqual -2f
            (-1.9f).round() shouldEqual -2f
        }
    }

    @Test
    fun roundEven() {
        run {
            val a1 = (-1.5f).roundEven()
            a1.shouldEqual(-2f, 0.0001f)

            val a2 = (1.5f).roundEven()
            a2.shouldEqual(2f, 0.0001f)

            val a5 = (-2.5f).roundEven()
            a5.shouldEqual(-2f, 0.0001f)

            val a6 = (2.5f).roundEven()
            a6.shouldEqual(2f, 0.0001f)

            val a3 = (-3.5f).roundEven()
            a3.shouldEqual(-4f, 0.0001f)

            val a4 = (3.5f).roundEven()
            a4.shouldEqual(4f, 0.0001f)

            val c7 = (-4.5f).roundEven()
            c7.shouldEqual(-4f, 0.0001f)

            val c8 = (4.5f).roundEven()
            c8.shouldEqual(4f, 0.0001f)

            val c1 = (-5.5f).roundEven()
            c1.shouldEqual(-6f, 0.0001f)

            val c2 = (5.5f).roundEven()
            c2.shouldEqual(6f, 0.0001f)

            val c3 = (-6.5f).roundEven()
            c3.shouldEqual(-6f, 0.0001f)

            val c4 = (6.5f).roundEven()
            c4.shouldEqual(6f, 0.0001f)

            val c5 = (-7.5f).roundEven()
            c5.shouldEqual(-8f, 0.0001f)

            val c6 = (7.5f).roundEven()
            c6.shouldEqual(8f, 0.0001f)
        }

        run {
            val a7 = (-2.4f).roundEven()
            a7.shouldEqual(-2f, 0.0001f)

            val a8 = (2.4f).roundEven()
            a8.shouldEqual(2f, 0.0001f)

            val b1 = (-2.6f).roundEven()
            b1.shouldEqual(-3f, 0.0001f)

            val b2 = (2.6f).roundEven()
            b2.shouldEqual(3f, 0.0001f)

            val b3 = (-2f).roundEven()
            b3.shouldEqual(-2f, 0.0001f)

            val b4 = (2f).roundEven()
            b4.shouldEqual(2f, 0.0001f)
        }

        run {
            0f.roundEven() shouldEqual 0f
            0.5f.roundEven() shouldEqual 0f
            1f.roundEven() shouldEqual 1f
            0.1f.roundEven() shouldEqual 0f
            0.9f.roundEven() shouldEqual 1f
            1.5f.roundEven() shouldEqual 2f
            1.9f.roundEven() shouldEqual 2f
        }

        run {
            (-0f).roundEven() shouldEqual 0f
            (-0.5f).roundEven() shouldEqual -0f
            (-1.0f).roundEven() shouldEqual -1f
            (-0.1f).roundEven() shouldEqual 0f
            (-0.9f).roundEven() shouldEqual -1f
            (-1.5f).roundEven() shouldEqual -2f
            (-1.9f).roundEven() shouldEqual -2f
        }

        run {
            1.5f.roundEven() shouldEqual 2f
            2.5f.roundEven() shouldEqual 2f
            3.5f.roundEven() shouldEqual 4f
            4.5f.roundEven() shouldEqual 4f
            5.5f.roundEven() shouldEqual 6f
            6.5f.roundEven() shouldEqual 6f
            7.5f.roundEven() shouldEqual 8f
        }

        run {
            (-1.5f).roundEven() shouldEqual -2f
            (-2.5f).roundEven() shouldEqual -2f
            (-3.5f).roundEven() shouldEqual -4f
            (-4.5f).roundEven() shouldEqual -4f
            (-5.5f).roundEven() shouldEqual -6f
            (-6.5f).roundEven() shouldEqual -6f
            (-7.5f).roundEven() shouldEqual -8f
        }
    }

    @Test
    @Suppress("DIVISION_BY_ZERO")
    fun isnan() {

        val zero_f = 0f
        val zero_d = 0.0

        run {
            assert((0.0 / zero_d).isNaN())
            assert(Vec2d(0.0 / zero_d).any { it.isNaN() })
            assert(Vec3d(0.0 / zero_d).any { it.isNaN() })
            assert(Vec4d(0.0 / zero_d).any { it.isNaN() })
        }

        run {
            assert((0f / zero_f).isNaN())
            assert(Vec2(0f / zero_f).any { it.isNaN() })
            assert(Vec3(0f / zero_f).any { it.isNaN() })
            assert(Vec4(0f / zero_f).any { it.isNaN() })
        }
    }

    @Test
    @Suppress("DIVISION_BY_ZERO")
    fun isinf() {

        val zero_f = 0f
        val zero_d = 0.0

        run {
            assert((1.0 / zero_d).isInfinite())
            assert((-1.0 / zero_d).isInfinite())
            assert(Vec2d(1.0 / zero_d).any { it.isInfinite() })
            assert(Vec2d(-1.0 / zero_d).any { it.isInfinite() })
            assert(Vec3d(1.0 / zero_d).any { it.isInfinite() })
            assert(Vec3d(-1.0 / zero_d).any { it.isInfinite() })
            assert(Vec4d(1.0 / zero_d).any { it.isInfinite() })
            assert(Vec4d(-1.0 / zero_d).any { it.isInfinite() })
        }

        run {
            assert((1f / zero_f).isInfinite())
            assert((-1f / zero_f).isInfinite())
            assert(Vec2(1f / zero_f).any { it.isInfinite() })
            assert(Vec2(-1f / zero_f).any { it.isInfinite() })
            assert(Vec3(1f / zero_f).any { it.isInfinite() })
            assert(Vec3(-1f / zero_f).any { it.isInfinite() })
            assert(Vec4(1f / zero_f).any { it.isInfinite() })
            assert(Vec4(-1f / zero_f).any { it.isInfinite() })
        }
    }

    @Test
    fun sign() {
        val value = intArrayOf(Int.MAX_VALUE, Int.MIN_VALUE, +0, +1, +2, +3, -1, -2, -3)
        val result = intArrayOf(+1, -1, +0, +1, +1, +1, -1, -1, -1)

        for (i in value.indices)
            value[i].sign shouldBe result[i]
    }

    @Test
    fun frexp() {

        run {
            val (a, exp) = Vec1(1024).frexp()
            a shouldEqual Vec1(1)
            exp shouldBe Vec1i(10)
        }

        run {
            val (a, exp) = Vec2(1024, 0.24).frexp()
            a shouldEqual Vec2(1, 0.96)
            exp shouldBe Vec2i(10, -2)
        }

        run {
            val (a, exp) = Vec3(1024, 0.24, 0).frexp()
            a shouldEqual Vec3(1, 0.96, 0.0)
            exp shouldBe Vec3i(10, -2, 0)
        }

        run {
            val (a, exp) = Vec4(1024, 0.24, 0, -1.33).frexp()
            a shouldEqual Vec4(1, 0.96, 0.0, -0.665)
            exp shouldBe Vec4i(10, -2, 0, 1)
        }
    }

    @Test
    fun ldexp() {

        run {
            val a = Vec1(1)
            val exp = Vec1i(10)
            val x = a ldexp exp
            x.shouldEqual(Vec1(1024), 0.00001f)
        }

        run {
            val a = Vec2(1, 0.96)
            val exp = Vec2i(10, -2)
            val x = a ldexp exp
            x.shouldEqual(Vec2(1024, .24), 0.00001f)
        }

        run {
            val a = Vec3(1, 0.96, 0.0)
            val exp = Vec3i(10, -2, 0)
            val x = a ldexp exp
            x.shouldEqual(Vec3(1024, .24, 0), 0.00001f)
        }

        run {
            val a = Vec4(1, 0.96, 0.0, -0.665)
            val exp = Vec4i(10, -2, 0, 1)
            val x = a ldexp exp
            x.shouldEqual(Vec4(1024, .24, 0, -1.33), 0.00001f)
        }
    }
}