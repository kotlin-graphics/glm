package glm_

import glm_.vec2.Vec2
import glm_.vec3.Vec3
import glm_.vec4.Vec4
import glm_.vec4.Vec4bool
import glm_.vec4.Vec4d
import glm_.vec4.Vec4i
import glm_.vec4.operators.div
import glm_.vec4.operators.minus
import glm_.vec4.operators.plus
import glm_.vec4.operators.times
import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.StringSpec

class testCorePure : StringSpec() {

    init {

        "vec4 constructor" {

            run {
                val a = Vec4(1)
                val b = Vec4(1, 1, 1, 1)

                a shouldBe b
            }

            run {

                arrayOf(
                        Vec4(Vec2(1, 2), 3, 4),
                        Vec4(1, Vec2(2, 3), 4),
                        Vec4(1, 2, Vec2(3, 4)),
                        Vec4(Vec3(1, 2, 3), 4),
                        Vec4(1, Vec3(2, 3, 4)),
                        Vec4(Vec2(1, 2), Vec2(3, 4)),
                        Vec4(1, 2, 3, 4),
                        Vec4(Vec4(1, 2, 3, 4)))
                        .forEach {
                            it shouldBe Vec4(1, 2, 3, 4)
                        }
            }
        }

        "vec4bool constructor" {

            val a = Vec4bool(true)
            val b = Vec4bool(true)
            val c = Vec4bool(false)
            val d = a and b
            val e = a and c
            val f = a or c

            d shouldBe Vec4bool(true)
            e shouldBe Vec4bool(false)
            f shouldBe Vec4bool(true)

            val g = a == c
            val h = a != c

            g shouldBe false
            h shouldBe true
        }

        "vec4 operators" {

            run {
                val a = Vec4(1f)
                val b = Vec4(1f)
                val r = a != b
                val s = a == b

                (s && !r) shouldBe true
            }

            run {
                val a = Vec4(1f, 2f, 3f, 4f)
                val b = Vec4(4f, 5f, 6f, 7f)

                val c = a + b
                c shouldBe Vec4(5, 7, 9, 11)

                val d = b - a
                d shouldBe Vec4(3, 3, 3, 3)

                val e = a * b
                e shouldBe Vec4(4, 10, 18, 28)

                val f = b / a
                f shouldBe Vec4(4, 2.5, 2, 7f / 4f)

                val g = a + 1f
                g shouldBe Vec4(2, 3, 4, 5)

                val h = b - 1f
                h shouldBe Vec4(3, 4, 5, 6)

                val i = a * 2f
                i shouldBe Vec4(2, 4, 6, 8)

                val j = b / 2f
                j shouldBe Vec4(2, 2.5, 3, 3.5)

                val k = 1f + a
                k shouldBe Vec4(2, 3, 4, 5)

                val l = 1f - b
                l shouldBe Vec4(-3, -4, -5, -6)

                val m = 2f * a
                m shouldBe Vec4(2, 4, 6, 8)

                val n = 2f / b
                n shouldBe Vec4(0.5, 2.0 / 5.0, 2.0 / 6.0, 2.0 / 7.0)
            }

            run {
                val a = Vec4(1f, 2f, 3f, 4f)
                val b = Vec4(4f, 5f, 6f, 7f)

                a += b
                a shouldBe Vec4(5, 7, 9, 11)

                a += 1f
                a shouldBe Vec4(6, 8, 10, 12)
            }
            run {
                val a = Vec4(1f, 2f, 3f, 4f)
                val b = Vec4(4f, 5f, 6f, 7f)

                b -= a
                b shouldBe Vec4(3, 3, 3, 3)

                b -= 1f
                b shouldBe Vec4(2, 2, 2, 2)
            }
            run {
                val a = Vec4(1f, 2f, 3f, 4f)
                val b = Vec4(4f, 5f, 6f, 7f)

                a *= b
                a shouldBe Vec4(4, 10, 18, 28)

                a *= 2f
                a shouldBe Vec4(8, 20, 36, 56)
            }
            run {
                val a = Vec4(1f, 2f, 3f, 4f)
                val b = Vec4(4f, 5f, 6f, 7f)

                b /= a
                b shouldBe Vec4(4, 2.5, 2, 7f / 4f)

                b /= 2f
                b shouldBe Vec4(2, 1.25, 1, 7f / 4f / 2f)
            }
            run {
                val b = Vec4(2f)

                b /= b.y
                b shouldBe Vec4(1f)
            }

            run {
                val a = Vec4(1f, 2f, 3f, 4f)
                val b = -a
                b shouldBe Vec4(-1f, -2f, -3f, -4f)
            }

            run {
                var a = Vec4(1f, 2f, 3f, 4f)
                val b = --a
                b shouldBe Vec4(0f, 1f, 2f, 3f)
            }

            run {
                var a = Vec4(1f, 2f, 3f, 4f)
                val b = a--
                b shouldBe Vec4(1f, 2f, 3f, 4f)
                a shouldBe Vec4(0f, 1f, 2f, 3f)
            }

            run {
                var a = Vec4(1f, 2f, 3f, 4f)
                val b = ++a
                b shouldBe Vec4(2f, 3f, 4f, 5f)
            }

            run {
                var a = Vec4(1f, 2f, 3f, 4f)
                val b = a++
                b shouldBe Vec4(1f, 2f, 3f, 4f)
                a shouldBe Vec4(2f, 3f, 4f, 5f)
            }
        }

        "vec4 equal" {

            run {
                val a = Vec4(1, 2, 3, 4)
                val b = Vec4(1, 2, 3, 4)
                a shouldBe b
                (a != b) shouldBe false
            }

            run {
                val a = Vec4i(1, 2, 3, 4)
                val b = Vec4i(1, 2, 3, 4)
                a shouldBe b
                (a != b) shouldBe false
            }
        }

        "vec4 size" {

            Vec4.size shouldBe 4 * Float.BYTES
            Vec4d.size shouldBe 4 * Double.BYTES
            Vec4.length shouldBe 4
            Vec4d.length shouldBe 4
        }

        "operator increment" {

            val v0 = Vec4i(1)
            var v1 = Vec4i(v0)
            var v2 = Vec4i(v0)
            val v3 = ++v1
            val v4 = v2++

            glm.all(glm.equal(v0, v4)) shouldBe true
            glm.all(glm.equal(v1, v2)) shouldBe true
            glm.all(glm.equal(v1, v3)) shouldBe true

            val i0 = 1
            var i1 = i0
            var i2 = i0
            val i3 = ++i1
            val i4 = i2++

            i0 shouldBe i4
            i1 shouldBe i2
            i1 shouldBe i3
        }
    }
}