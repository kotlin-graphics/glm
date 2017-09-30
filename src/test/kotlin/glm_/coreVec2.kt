package glm_

/**
 * Created by GBarbieri on 05.10.2016.
 */

import glm_.vec2.Vec2
import glm_.vec2.Vec2i
import glm_.vec1.operators.div
import glm_.vec1.operators.minus
import glm_.vec1.operators.plus
import glm_.vec1.operators.times
import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.StringSpec


class coreVec2 : StringSpec() {

    init {

        "operators specific" {

            run {
                val a = Vec2(1f)
                val b = Vec2(1f)

                a shouldBe b
                (a != b) shouldBe false
            }
            run {
                var a = Vec2(1f)
                val c = a + 1f
                a += 1f

                a shouldBe Vec2(2f)
                a shouldBe c
            }
            run {
                var a = Vec2(1f)
                val b = Vec2(2f, -1f)
                val c = a + b
                a += b

                a shouldBe Vec2(3f, 0f)
                a shouldBe c
            }
            run {
                var a = Vec2(1f)
                val c = a - 1f
                a -= 1f

                a shouldBe Vec2()
                a shouldBe c
            }
            run {
                var a = Vec2(1f)
                val b = Vec2(2f, -1f)
                val c = a - b
                a -= b
                a shouldBe Vec2(-1f, 2f)
                a shouldBe c
            }
            run {
                var a = Vec2(1f)
                val c = a * 2f
                a *= 2f

                a shouldBe Vec2(2f)
                a shouldBe c
            }
            run {
                var a = Vec2(2f)
                val b = Vec2(2f)
                val c = a / b
                a /= b
                a shouldBe Vec2(1f)
                a shouldBe c
            }
            run {
                val a = Vec2(1f, 2f)
                val b = Vec2(4f, 5f)

                val c = a + b
                c shouldBe Vec2(5f, 7f)

                val d = b - a
                d shouldBe Vec2(3f)

                val e = a * b
                e shouldBe Vec2(4f, 10f)

                val f = b / a
                f shouldBe Vec2(4f, 2.5f)

                val g = a + 1f
                g shouldBe Vec2(2f, 3f)

                val h = b - 1f
                h shouldBe Vec2(3f, 4f)

                val i = a * 2f
                i shouldBe Vec2(2f, 4f)

                val j = b / 2f
                j shouldBe Vec2(2f, 2.5f)

                val k = 1f + a
                k shouldBe Vec2(2f, 3f)

                val l = 1f - b
                l shouldBe Vec2(-3f, -4f)

                val m = 2f * a
                m shouldBe Vec2(2f, 4f)

                val n = 2f / b
                n shouldBe Vec2(.5f, 2f / 5f)
            }
            run {
                var a = Vec2(1f, 2f)
                val b = Vec2(4f, 5f)

                a += b
                a shouldBe Vec2(5f, 7f)

                a += 1f
                a shouldBe Vec2(6f, 8f)
            }
            run {
                val a = Vec2(1f, 2f)
                var b = Vec2(4f, 5f)

                b -= a
                b shouldBe Vec2(3f)

                b -= 1f
                b shouldBe Vec2(2f)
            }
            run {
                var a = Vec2(1f, 2f)
                val b = Vec2(4f, 5f)

                a *= b
                a shouldBe Vec2(4f, 10f)

                a *= 2f
                a shouldBe Vec2(8f, 20f)
            }
            run {
                val a = Vec2(1f, 2f)
                var b = Vec2(4f, 5f)

                b /= a
                b shouldBe Vec2(4f, 2.5f)

                b /= 2f
                b shouldBe Vec2(2f, 1.25f)
            }
            run {
                var b = Vec2(2f)

                b /= b.y
                b shouldBe Vec2(1f)
            }
            run {
                val a = Vec2(1f, 2f)
                val b = -a

                b shouldBe Vec2(-1f, -2f)
            }
            run {
                var a = Vec2(1f, 2f)
                val b = --a

                b shouldBe Vec2(0f, 1f)
            }
            run {
                var a = Vec2(1f, 2f)
                val b = a--

                b shouldBe Vec2(1f, 2f)
                a shouldBe Vec2(0f, 1f)
            }
            run {
                var a = Vec2(1f, 2f)
                val b = ++a

                b shouldBe Vec2(2f, 3f)
            }
            run {
                var a = Vec2(1f, 2f)
                val b = a++

                b shouldBe Vec2(1f, 2f)
                a shouldBe Vec2(2f, 3f)
            }
            // custom
            run {
                val a = Vec2(1f, 2f)
                a plus_ 1f

                a shouldBe Vec2(2f, 3f)
            }
            run {
                val a = Vec2(1f, 2f)
                val b = Vec2(3f, 4f)
                a plus_ b

                a shouldBe Vec2(4f, 6f)
            }
        }

        "operatorsGeneric" {

            run {
                var a = Vec2(1f)
                val c = a + 1
                a += 1L

                a shouldBe Vec2(2f)
                a shouldBe c
            }
            run {
                var a = Vec2(1f)
                val b = Vec2(2f, -1f)
                val c = a + b
                a += b

                a shouldBe Vec2(3f, 0f)
                a shouldBe c
            }
            run {
                var a = Vec2(1f)
                val c = a - 1f
                a -= 1f

                a shouldBe Vec2()
                a shouldBe c
            }
            run {
                var a = Vec2(1f)
                val b = Vec2(2f, -1f)
                val c = a - b
                a -= b
                a shouldBe Vec2(-1f, 2f)
                a shouldBe c
            }
            run {
                var a = Vec2(1f)
                val c = a * 2f
                a *= 2f

                a shouldBe Vec2(2f)
                a shouldBe c
            }
            run {
                var a = Vec2(2f)
                val b = Vec2(2f)
                val c = a / b
                a /= b
                a shouldBe Vec2(1f)
                a shouldBe c
            }
            run {
                val a = Vec2(1f, 2f)
                val b = Vec2(4f, 5f)

                val c = a + b
                c shouldBe Vec2(5f, 7f)

                val d = b - a
                d shouldBe Vec2(3f)

                val e = a * b
                e shouldBe Vec2(4f, 10f)

                val f = b / a
                f shouldBe Vec2(4f, 2.5f)

                val g = a + 1f
                g shouldBe Vec2(2f, 3f)

                val h = b - 1f
                h shouldBe Vec2(3f, 4f)

                val i = a * 2f
                i shouldBe Vec2(2f, 4f)

                val j = b / 2f
                j shouldBe Vec2(2f, 2.5f)

                val k = 1f + a
                k shouldBe Vec2(2f, 3f)

                val l = 1f - b
                l shouldBe Vec2(-3f, -4f)

                val m = 2f * a
                m shouldBe Vec2(2f, 4f)

                val n = 2f / b
                n shouldBe Vec2(.5f, 2f / 5f)
            }
            run {
                var a = Vec2(1f, 2f)
                val b = Vec2(4f, 5f)

                a += b
                a shouldBe Vec2(5f, 7f)

                a += 1f
                a shouldBe Vec2(6f, 8f)
            }
            run {
                val a = Vec2(1f, 2f)
                var b = Vec2(4f, 5f)

                b -= a
                b shouldBe Vec2(3f)

                b -= 1f
                b shouldBe Vec2(2f)
            }
            run {
                var a = Vec2(1f, 2f)
                val b = Vec2(4f, 5f)

                a *= b
                a shouldBe Vec2(4f, 10f)

                a *= 2f
                a shouldBe Vec2(8f, 20f)
            }
            run {
                val a = Vec2(1f, 2f)
                var b = Vec2(4f, 5f)

                b /= a
                b shouldBe Vec2(4f, 2.5f)

                b /= 2f
                b shouldBe Vec2(2f, 1.25f)
            }
            run {
                var b = Vec2(2f)

                b /= b.y
                b shouldBe Vec2(1f)
            }
            run {
                val a = Vec2(1f, 2f)
                val b = -a

                b shouldBe Vec2(-1f, -2f)
            }
            run {
                var a = Vec2(1f, 2f)
                val b = --a

                b shouldBe Vec2(0f, 1f)
            }
            run {
                var a = Vec2(1f, 2f)
                val b = a--

                b shouldBe Vec2(1f, 2f)
                a shouldBe Vec2(0f, 1f)
            }
            run {
                var a = Vec2(1f, 2f)
                val b = ++a

                b shouldBe Vec2(2f, 3f)
            }
            run {
                var a = Vec2(1f, 2f)
                val b = a++

                b shouldBe Vec2(1f, 2f)
                a shouldBe Vec2(2f, 3f)
            }
            // custom
            run {
                val a = Vec2(1f, 2f)
                a plus_ 1f

                a shouldBe Vec2(2f, 3f)
            }
            run {
                val a = Vec2(1f, 2f)
                val b = Vec2(3f, 4f)
                a plus_ b

                a shouldBe Vec2(4f, 6f)
            }
        }

        "ctor" {

            val a = Vec2(1)
            val b = Vec2(a)

            a shouldBe b
        }

        "size" {

            //            Vec2.length shouldBe 2 TODO
//            Vec2d().length() shouldBe 2
        }

        "generic" {

            val a = 1L + Vec2(4)

            a shouldBe Vec2(5)
        }

        "operator_increment" {

            run {
                var v0 = Vec2i(1)
                var v1 = Vec2i(v0)
                var v2 = Vec2i(v0)
                var v3 = ++v1
                var v4 = v2++

                val a = 1 + v0

//        assert(v0.equals())
            }

            run {
                val a = Vec2()
                val b = Vec2(10)

                a inc b
            }
        }

        "swizzling" {

            val a = Vec2(1, 2)
            val b = Vec2(3, 4)

            b.xy = a

            b shouldBe Vec2(1, 2)

            a.yx = b

            a shouldBe Vec2(2, 1)
            b shouldBe Vec2(1, 2)

            a.yx = b.yx

            a shouldBe Vec2(1, 2)
        }
    }
}