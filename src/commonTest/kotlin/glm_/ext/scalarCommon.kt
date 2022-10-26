package glm_.ext

import glm_.extensions.i
import glm_.glm
import glm_.scalar.max
import glm_.scalar.min
import glm_.scalar.round
import glm_.shouldBe
import kotlin.test.Test

class scalarCommon {

    @Test
    fun min() {
        run {
            val n = 0f
            val b = 1f
            (n min b).equal(n, glm.epsilon.f) shouldBe true
            (b min n).equal(n, glm.epsilon.f) shouldBe true

            val c = 2f
            min(n, b, c).equal(n, glm.epsilon.f) shouldBe true
            min(b, n, c).equal(n, glm.epsilon.f) shouldBe true
            min(c, n, b).equal(n, glm.epsilon.f) shouldBe true
            min(c, b, n).equal(n, glm.epsilon.f) shouldBe true
            min(b, c, n).equal(n, glm.epsilon.f) shouldBe true
            min(n, c, b).equal(n, glm.epsilon.f) shouldBe true

            val d = 3f
            min(d, n, b, c).equal(n, glm.epsilon.f) shouldBe true
            min(b, d, n, c).equal(n, glm.epsilon.f) shouldBe true
            min(c, n, d, b).equal(n, glm.epsilon.f) shouldBe true
            min(c, b, d, n).equal(n, glm.epsilon.f) shouldBe true
            min(b, c, n, d).equal(n, glm.epsilon.f) shouldBe true
            min(n, c, b, d).equal(n, glm.epsilon.f) shouldBe true
        }
        run {
            val n = 0.0
            val b = 1.0
            (n min b).equal(n, glm.epsilon.d) shouldBe true
            (b min n).equal(n, glm.epsilon.d) shouldBe true

            val c = 2.0
            min(n, b, c).equal(n, glm.epsilon.d) shouldBe true
            min(b, n, c).equal(n, glm.epsilon.d) shouldBe true
            min(c, n, b).equal(n, glm.epsilon.d) shouldBe true
            min(c, b, n).equal(n, glm.epsilon.d) shouldBe true
            min(b, c, n).equal(n, glm.epsilon.d) shouldBe true
            min(n, c, b).equal(n, glm.epsilon.d) shouldBe true

            val d = 3.0
            min(d, n, b, c).equal(n, glm.epsilon.d) shouldBe true
            min(b, d, n, c).equal(n, glm.epsilon.d) shouldBe true
            min(c, n, d, b).equal(n, glm.epsilon.d) shouldBe true
            min(c, b, d, n).equal(n, glm.epsilon.d) shouldBe true
            min(b, c, n, d).equal(n, glm.epsilon.d) shouldBe true
            min(n, c, b, d).equal(n, glm.epsilon.d) shouldBe true
        }
    }

    @Test
    fun min_nan() {
        run {
            val b = 1f
            val n = Float.NaN
            (n min b).isNaN() shouldBe true
//            (b min n).isNaN() shouldBe false

            val c = 2f
            min(n, b, c).isNaN() shouldBe true
//            min(b, n, c).isNaN() shouldBe false
//            min(c, n, b).isNaN() shouldBe false
//            min(c, b, n).isNaN() shouldBe false
//            min(b, c, n).isNaN() shouldBe false
            min(n, c, b).isNaN() shouldBe true

            val d = 3f
//            min(d, n, b, c).isNaN() shouldBe false
//            min(b, d, n, c).isNaN() shouldBe false
//            min(c, n, d, b).isNaN() shouldBe false
//            min(c, b, d, n).isNaN() shouldBe false
//            min(b, c, n, d).isNaN() shouldBe false
            min(n, c, b, d).isNaN() shouldBe true
        }
        run {
            val b = 1.0
            val n = Double.NaN
            (n min b).isNaN() shouldBe true
//            (b min n).isNaN() shouldBe false

            val c = 2.0
            min(n, b, c).isNaN() shouldBe true
//            min(b, n, c).isNaN() shouldBe false
//            min(c, n, b).isNaN() shouldBe false
//            min(c, b, n).isNaN() shouldBe false
//            min(b, c, n).isNaN() shouldBe false
            min(n, c, b).isNaN() shouldBe true

            val d = 3.0
//            min(d, n, b, c).isNaN() shouldBe false
//            min(b, d, n, c).isNaN() shouldBe false
//            min(c, n, d, b).isNaN() shouldBe false
//            min(c, b, d, n).isNaN() shouldBe false
//            min(b, c, n, d).isNaN() shouldBe false
            min(n, c, b, d).isNaN() shouldBe true
        }
    }

    @Test
    fun max() {
        run {
            val n = 0f
            val b = 1f
            (n max b).equal(b, glm.epsilon.f) shouldBe true
            (b max n).equal(b, glm.epsilon.f) shouldBe true

            val c = 2f
            max(n, b, c).equal(c, glm.epsilon.f) shouldBe true
            max(b, n, c).equal(c, glm.epsilon.f) shouldBe true
            max(c, n, b).equal(c, glm.epsilon.f) shouldBe true
            max(c, b, n).equal(c, glm.epsilon.f) shouldBe true
            max(b, c, n).equal(c, glm.epsilon.f) shouldBe true
            max(n, c, b).equal(c, glm.epsilon.f) shouldBe true

            val d = 3f
            max(d, n, b, c).equal(d, glm.epsilon.f) shouldBe true
            max(b, d, n, c).equal(d, glm.epsilon.f) shouldBe true
            max(c, n, d, b).equal(d, glm.epsilon.f) shouldBe true
            max(c, b, d, n).equal(d, glm.epsilon.f) shouldBe true
            max(b, c, n, d).equal(d, glm.epsilon.f) shouldBe true
            max(n, c, b, d).equal(d, glm.epsilon.f) shouldBe true
        }
        run {
            val n = 0.0
            val b = 1.0
            (n max b).equal(b, glm.epsilon.d) shouldBe true
            (b max n).equal(b, glm.epsilon.d) shouldBe true

            val c = 2.0
            max(n, b, c).equal(c, glm.epsilon.d) shouldBe true
            max(b, n, c).equal(c, glm.epsilon.d) shouldBe true
            max(c, n, b).equal(c, glm.epsilon.d) shouldBe true
            max(c, b, n).equal(c, glm.epsilon.d) shouldBe true
            max(b, c, n).equal(c, glm.epsilon.d) shouldBe true
            max(n, c, b).equal(c, glm.epsilon.d) shouldBe true

            val d = 3.0
            max(d, n, b, c).equal(d, glm.epsilon.d) shouldBe true
            max(b, d, n, c).equal(d, glm.epsilon.d) shouldBe true
            max(c, n, d, b).equal(d, glm.epsilon.d) shouldBe true
            max(c, b, d, n).equal(d, glm.epsilon.d) shouldBe true
            max(b, c, n, d).equal(d, glm.epsilon.d) shouldBe true
            max(n, c, b, d).equal(d, glm.epsilon.d) shouldBe true
        }
    }

    @Test
    fun max_nan() {
        run {
            val b = 1f
            val n = Float.NaN
            (n max b).isNaN() shouldBe true
//            (b max n).isNaN() shouldBe false

            val c = 2f
            max(n, b, c).isNaN() shouldBe true
//            max(b, n, c).isNaN() shouldBe false
//            max(c, n, b).isNaN() shouldBe false
//            max(c, b, n).isNaN() shouldBe false
//            max(b, c, n).isNaN() shouldBe false
            max(n, c, b).isNaN() shouldBe true

            val d = 3f
//            max(d, n, b, c).isNaN() shouldBe false
//            max(b, d, n, c).isNaN() shouldBe false
//            max(c, n, d, b).isNaN() shouldBe false
//            max(c, b, d, n).isNaN() shouldBe false
//            max(b, c, n, d).isNaN() shouldBe false
            max(n, c, b, d).isNaN() shouldBe true
        }
        run {
            val b = 1.0
            val n = Double.NaN
            (n max b).isNaN() shouldBe true
//            (b max n).isNaN() shouldBe false

            val c = 2.0
            max(n, b, c).isNaN() shouldBe true
//            max(b, n, c).isNaN() shouldBe false
//            max(c, n, b).isNaN() shouldBe false
//            max(c, b, n).isNaN() shouldBe false
//            max(b, c, n).isNaN() shouldBe false
            max(n, c, b).isNaN() shouldBe true

            val d = 3.0
//            max(d, n, b, c).isNaN() shouldBe false
//            max(b, d, n, c).isNaN() shouldBe false
//            max(c, n, d, b).isNaN() shouldBe false
//            max(c, b, d, n).isNaN() shouldBe false
//            max(b, c, n, d).isNaN() shouldBe false
            max(n, c, b, d).isNaN() shouldBe true
        }
    }

    @Test
    fun fmin() {
        run {
            val b = 1f
            val n = Float.NaN
            (n fmin b).equal(b, glm.epsilon.f) shouldBe true
//            (b fmin n).equal(b, glm.epsilon.f) shouldBe true

            val c = 2f
            fmin(n, b, c).equal(b, glm.epsilon.f) shouldBe true
            fmin(b, n, c).equal(b, glm.epsilon.f) shouldBe true
            fmin(c, n, b).equal(b, glm.epsilon.f) shouldBe true
            fmin(c, b, n).equal(b, glm.epsilon.f) shouldBe true
            fmin(b, c, n).equal(b, glm.epsilon.f) shouldBe true
            fmin(n, c, b).equal(b, glm.epsilon.f) shouldBe true

            val d = 3f
            fmin(d, n, b, c).equal(b, glm.epsilon.f) shouldBe true
            fmin(b, d, n, c).equal(b, glm.epsilon.f) shouldBe true
            fmin(c, n, d, b).equal(b, glm.epsilon.f) shouldBe true
            fmin(c, b, d, n).equal(b, glm.epsilon.f) shouldBe true
            fmin(b, c, n, d).equal(b, glm.epsilon.f) shouldBe true
            fmin(n, c, b, d).equal(b, glm.epsilon.f) shouldBe true
        }
        run {
            val b = 1.0
            val n = Double.NaN
            (n fmin b).equal(b, glm.epsilon.d) shouldBe true
//            (b fmin n).equal(b, glm.epsilon.d) shouldBe true

            val c = 2.0
            fmin(n, b, c).equal(b, glm.epsilon.d) shouldBe true
            fmin(b, n, c).equal(b, glm.epsilon.d) shouldBe true
            fmin(c, n, b).equal(b, glm.epsilon.d) shouldBe true
            fmin(c, b, n).equal(b, glm.epsilon.d) shouldBe true
            fmin(b, c, n).equal(b, glm.epsilon.d) shouldBe true
            fmin(n, c, b).equal(b, glm.epsilon.d) shouldBe true

            val d = 3.0
            fmin(d, n, b, c).equal(b, glm.epsilon.d) shouldBe true
            fmin(b, d, n, c).equal(b, glm.epsilon.d) shouldBe true
            fmin(c, n, d, b).equal(b, glm.epsilon.d) shouldBe true
            fmin(c, b, d, n).equal(b, glm.epsilon.d) shouldBe true
            fmin(b, c, n, d).equal(b, glm.epsilon.d) shouldBe true
            fmin(n, c, b, d).equal(b, glm.epsilon.d) shouldBe true
        }
    }

    @Test
    fun fmax() {
        run {
            val b = 1f
            val n = Float.NaN
            (n fmax b).equal(b, glm.epsilon.f) shouldBe true
//            (b fmax n).equal(b, glm.epsilon.f) shouldBe true

            val c = 2f
            fmax(n, b, c).equal(c, glm.epsilon.f) shouldBe true
            fmax(b, n, c).equal(c, glm.epsilon.f) shouldBe true
            fmax(c, n, b).equal(c, glm.epsilon.f) shouldBe true
            fmax(c, b, n).equal(c, glm.epsilon.f) shouldBe true
            fmax(b, c, n).equal(c, glm.epsilon.f) shouldBe true
            fmax(n, c, b).equal(c, glm.epsilon.f) shouldBe true

            val d = 3f
            fmax(d, n, b, c).equal(d, glm.epsilon.f) shouldBe true
            fmax(b, d, n, c).equal(d, glm.epsilon.f) shouldBe true
            fmax(c, n, d, b).equal(d, glm.epsilon.f) shouldBe true
            fmax(c, b, d, n).equal(d, glm.epsilon.f) shouldBe true
            fmax(b, c, n, d).equal(d, glm.epsilon.f) shouldBe true
            fmax(n, c, b, d).equal(d, glm.epsilon.f) shouldBe true
        }
        run {
            val b = 1.0
            val n = Double.NaN
            (n fmax b).equal(b, glm.epsilon.d) shouldBe true
//            (b fmax n).equal(b, glm.epsilon.d) shouldBe true

            val c = 2.0
            fmax(n, b, c).equal(c, glm.epsilon.d) shouldBe true
            fmax(b, n, c).equal(c, glm.epsilon.d) shouldBe true
            fmax(c, n, b).equal(c, glm.epsilon.d) shouldBe true
            fmax(c, b, n).equal(c, glm.epsilon.d) shouldBe true
            fmax(b, c, n).equal(c, glm.epsilon.d) shouldBe true
            fmax(n, c, b).equal(c, glm.epsilon.d) shouldBe true

            val d = 3.0
            fmax(d, n, b, c).equal(d, glm.epsilon.d) shouldBe true
            fmax(b, d, n, c).equal(d, glm.epsilon.d) shouldBe true
            fmax(c, n, d, b).equal(d, glm.epsilon.d) shouldBe true
            fmax(c, b, d, n).equal(d, glm.epsilon.d) shouldBe true
            fmax(b, c, n, d).equal(d, glm.epsilon.d) shouldBe true
            fmax(n, c, b, d).equal(d, glm.epsilon.d) shouldBe true
        }
    }

    @Test
    fun clamp() {
        run {
            val a = 0.5f.clamp()
            a.equal(0.5f, 0.00001f) shouldBe true

            val b = 0f.clamp()
            b.equal(0f, 0.00001f) shouldBe true

            val c = 1f.clamp()
            c.equal(1f, 0.00001f) shouldBe true

            val d = (-0.5f).clamp()
            d.equal(0f, 0.00001f) shouldBe true

            val e = 1.5f.clamp()
            e.equal(1f, 0.00001f) shouldBe true
        }
        run {
            val a = 0.5.clamp()
            a.equal(0.5, 0.00001) shouldBe true

            val b = 0.0.clamp()
            b.equal(0.0, 0.00001) shouldBe true

            val c = 1.0.clamp()
            c.equal(1.0, 0.00001) shouldBe true

            val d = (-0.5).clamp()
            d.equal(0.0, 0.00001) shouldBe true

            val e = 1.5.clamp()
            e.equal(1.0, 0.00001) shouldBe true
        }
    }

    @Test
    fun repeat() {
        run {
            val a = 0.5f.repeat()
            a.equal(0.5f, 0.00001f) shouldBe true

            val b = 0.0f.repeat()
            b.equal(0.0f, 0.00001f) shouldBe true

            val c = 1.0f.repeat()
            c.equal(0.0f, 0.00001f) shouldBe true

            val d = (-0.5f).repeat()
            d.equal(0.5f, 0.00001f) shouldBe true

            val e = 1.5f.repeat()
            e.equal(0.5f, 0.00001f) shouldBe true

            val f = 0.9f.repeat()
            f.equal(0.9f, 0.00001f) shouldBe true
        }
        run {
            val a = 0.5.repeat()
            a.equal(0.5, 0.00001) shouldBe true

            val b = 0.0.repeat()
            b.equal(0.0, 0.00001) shouldBe true

            val c = 1.0.repeat()
            c.equal(0.0, 0.00001) shouldBe true

            val d = (-0.5).repeat()
            d.equal(0.5, 0.00001) shouldBe true

            val e = 1.5.repeat()
            e.equal(0.5, 0.00001) shouldBe true

            val f = 0.9.repeat()
            f.equal(0.9, 0.00001) shouldBe true
        }
    }

    @Test
    fun mirrorClamp() {
        run {
            val a = 0.5f.mirrorClamp()
            a.equal(0.5f, 0.00001f) shouldBe true

            val b = 0.0f.mirrorClamp()
            b.equal(0.0f, 0.00001f) shouldBe true

            val c = 1.1f.mirrorClamp()
            c.equal(0.1f, 0.00001f) shouldBe true

            val d = (-0.5f).mirrorClamp()
            d.equal(0.5f, 0.00001f) shouldBe true

            val e = 1.5f.mirrorClamp()
            e.equal(0.5f, 0.00001f) shouldBe true

            val f = 0.9f.mirrorClamp()
            f.equal(0.9f, 0.00001f) shouldBe true

            val g = 3.1f.mirrorClamp()
            g.equal(0.1f, 0.00001f) shouldBe true

            val h = (-3.1f).mirrorClamp()
            h.equal(0.1f, 0.00001f) shouldBe true

            val i = (-0.9f).mirrorClamp()
            i.equal(0.9f, 0.00001f) shouldBe true
        }
        run {
            val a = 0.5.mirrorClamp()
            a.equal(0.5, 0.00001) shouldBe true

            val b = 0.0.mirrorClamp()
            b.equal(0.0, 0.00001) shouldBe true

            val c = 1.1.mirrorClamp()
            c.equal(0.1, 0.00001) shouldBe true

            val d = (-0.5).mirrorClamp()
            d.equal(0.5, 0.00001) shouldBe true

            val e = 1.5.mirrorClamp()
            e.equal(0.5, 0.00001) shouldBe true

            val f = 0.9.mirrorClamp()
            f.equal(0.9, 0.00001) shouldBe true

            val g = 3.1.mirrorClamp()
            g.equal(0.1, 0.00001) shouldBe true

            val h = (-3.1).mirrorClamp()
            h.equal(0.1, 0.00001) shouldBe true

            val i = (-0.9).mirrorClamp()
            i.equal(0.9, 0.00001) shouldBe true
        }
    }

    @Test
    fun mirrorRepeat() {
        run {
            val a = 0.5f.mirrorRepeat()
            a.equal(0.5f, 0.00001f) shouldBe true

            val b = 0.0f.mirrorRepeat()
            b.equal(0.0f, 0.00001f) shouldBe true

            val c = 1.0f.mirrorRepeat()
            c.equal(1.0f, 0.00001f) shouldBe true

            val d = (-0.5f).mirrorRepeat()
            d.equal(0.5f, 0.00001f) shouldBe true

            val e = 1.5f.mirrorRepeat()
            e.equal(0.5f, 0.00001f) shouldBe true

            val f = 0.9f.mirrorRepeat()
            f.equal(0.9f, 0.00001f) shouldBe true

            val g = 3.0f.mirrorRepeat()
            g.equal(1.0f, 0.00001f) shouldBe true

            val h = (-3.0f).mirrorRepeat()
            h.equal(1.0f, 0.00001f) shouldBe true

            val i = (-1.0f).mirrorRepeat()
            i.equal(1.0f, 0.00001f) shouldBe true
        }
        run {
            val a = 0.5.mirrorRepeat()
            a.equal(0.5, 0.00001) shouldBe true

            val b = 0.0.mirrorRepeat()
            b.equal(0.0, 0.00001) shouldBe true

            val c = 1.0.mirrorRepeat()
            c.equal(1.0, 0.00001) shouldBe true

            val d = (-0.5).mirrorRepeat()
            d.equal(0.5, 0.00001) shouldBe true

            val e = 1.5.mirrorRepeat()
            e.equal(0.5, 0.00001) shouldBe true

            val f = 0.9.mirrorRepeat()
            f.equal(0.9, 0.00001) shouldBe true

            val g = 3.0.mirrorRepeat()
            g.equal(1.0, 0.00001) shouldBe true

            val h = (-3.0).mirrorRepeat()
            h.equal(1.0, 0.00001) shouldBe true

            val i = (-1.0).mirrorRepeat()
            i.equal(1.0, 0.00001) shouldBe true
        }
    }

    @Test
    fun iround() {
        run {
            var f = 0f
            while (f < 3.1f) {
                val roundFast = f.iround()
                val roundSTD = f.round().i
                roundFast shouldBe roundSTD
                f += 0.05f
            }
        }
    }

    @Test
    fun uround() {
        var f = 0f
        while(f < 3.1f) {
            val roundFast = f.uround().i
            val roundSTD = f.round().i
            roundFast shouldBe roundSTD
            f += 0.05f
        }
    }
}