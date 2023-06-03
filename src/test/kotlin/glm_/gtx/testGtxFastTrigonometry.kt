package glm_.gtx

import glm_.func.rad
import glm_.glm
import glm_.glm.HPIf
import glm_.glm.PI2f
import glm_.glm.PI3over2f
import glm_.glm.PIf
import glm_.glm.abs
import glm_.glm.cos
import glm_.glm.floatBitsToInt
import glm_.glm.intBitsToFloat
import glm_.glm.lessThanEqual
import glm_.glm.mix
import glm_.glm.trunc
import glm_.vec1.Vec1
import glm_.vec1.operators.minus
import glm_.vec4.Vec4
import glm_.vec4.operators.minus
import glm_.vec4.operators.times
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import kotlin.system.measureNanoTime

class testGtxFastTrigonometry : StringSpec() {

    init {

        "taylor 2" { taylor2.perf(1_000) }
        "taylor cos" {
            taylorCos.test()
            taylorCos.perf(1_000)
        }
    }
}

object taylor2 {

    val angleShift = Vec4(0f, PIf * 0.5f, PIf * 1f, PIf * 1.5f)

    fun taylorCosA(x: Float) = 1f -
            (x * x) * (1f / 2f) +
            (x * x * x * x) * (1f / 24f) -
            (x * x * x * x * x * x) * (1f / 720f) +
            (x * x * x * x * x * x * x * x) * (1f / 40320f)

    fun taylorCosB(x: Float) = 1f -
            (x * x) * (1f / 2f) +
            (x * x * x * x) * (1f / 24f) -
            (x * x * x * x * x * x) * (1f / 720f) +
            (x * x * x * x * x * x * x * x) * (1f / 40320f)

    fun taylorCosC(x: Float) = 1f -
            (x * x) * (1f / 2f) +
            ((x * x) * (x * x)) * (1f / 24f) -
            (((x * x) * (x * x)) * (x * x)) * (1f / 720f) +
            (((x * x) * (x * x)) * ((x * x) * (x * x))) * (1f / 40320f)

    fun perf_taylorCosA(begin: Float, end: Float, samples: Int) {

        val results = FloatArray(samples)

        val steps = (end - begin) / samples

        val time = measureNanoTime {
            for (i in 0 until samples)
                results[i] = taylorCosA(angleShift.x + begin + steps * i)
        }
        println("taylorCosA $time ns")

        for (i in 0 until samples)
            (results[i] in -1f..1f) shouldBe true
    }

    fun perf_taylorCosB(begin: Float, end: Float, samples: Int) {

        val results = FloatArray(samples)

        val steps = (end - begin) / samples

        val time = measureNanoTime {
            for (i in 0 until samples)
                results[i] = taylorCosB(angleShift.x + begin + steps * i)
        }

        println("taylorCosB $time ns")

        for (i in 0 until samples)
            (results[i] in -1f..1f) shouldBe true
    }

    fun perf_taylorCosC(begin: Float, end: Float, samples: Int) {

        val results = FloatArray(samples)

        val steps = (end - begin) / samples

        val time = measureNanoTime {
            for (i in 0 until samples)
                results[i] = taylorCosC(angleShift.x + begin + steps * i)
        }

        println("taylorCosC $time ns")

        for (i in 0 until samples)
            (results[i] in -1f..1f) shouldBe true
    }

    fun perf(samples: Int) {

        val begin = -PIf
        val end = PIf

        perf_taylorCosA(begin, end, samples)
        perf_taylorCosB(begin, end, samples)
        perf_taylorCosC(begin, end, samples)
    }

}

object taylorCos {

    val angleShift = Vec4(0f, HPIf, PIf, PI3over2f)

    fun taylorSeriesNewCos(x: Vec4): Vec4 {
        val powed2 = x * x
        val powed4 = powed2 * powed2
        val powed6 = powed4 * powed2
        val powed8 = powed4 * powed4

        return 1f -
                powed2 * 0.5f +
                powed4 * 0.04166666666666666666666666666667f -
                powed6 * 0.00138888888888888888888888888889f +
                powed8 * 2.4801587301587301587301587301587e-5f
    }

    fun taylorSeriesNewCos6(x: Vec4): Vec4 {
        val powed2 = x * x
        val powed4 = powed2 * powed2
        val powed6 = powed4 * powed2

        return 1f - powed2 * 0.5f +
                powed4 * 0.04166666666666666666666666666667f -
                powed6 * 0.00138888888888888888888888888889f
    }

    fun fastAbs(x: Vec4): Vec4 {
        x.x = intBitsToFloat(floatBitsToInt(x.x) and 0x7fffffff)
        x.y = intBitsToFloat(floatBitsToInt(x.y) and 0x7fffffff)
        x.z = intBitsToFloat(floatBitsToInt(x.z) and 0x7fffffff)
        x.w = intBitsToFloat(floatBitsToInt(x.w) and 0x7fffffff)
        return x
    }

    fun fastCosNew(x: Vec4): Vec4 {
//        val angle0_PI = Vec4(fastAbs(((x + PIf) % PI2f) - PIf))
        return taylorSeriesNewCos6(x)
/*
		vec<L, bool, Q> const FirstQuarterPi(lessThanEqual(Angle0_PI, vec<L, T, Q>(glm::half_pi<T>())));

		vec<L, T, Q> const RevertAngle(mix(vec<L, T, Q>(glm::pi<T>()), vec<L, T, Q>(0), FirstQuarterPi));
		vec<L, T, Q> const ReturnSign(mix(vec<L, T, Q>(-1), vec<L, T, Q>(1), FirstQuarterPi));
		vec<L, T, Q> const SectionAngle(RevertAngle - Angle0_PI);

		return ReturnSign * taylorSeriesNewCos(SectionAngle);
*/
    }

    fun perfFastCosNew(begin: Float, end: Float, samples: Int) {

        val results = Array(samples, { Vec4() })

        val steps = (end - begin) / samples

        val time = measureNanoTime {
            for (i in 0 until samples)
                results[i] = fastCosNew(angleShift + Vec4(begin + steps * i))
        }

        println("fastCosNew $time ns")

        for (i in 0 until samples)
            (results[i].x in -1f..1f) shouldBe true
    }

    fun deterministicMod(x: Vec4, y: Float) = x - y * trunc(x / y)

    fun fastCosDeterminisctic(x: Vec4): Vec4 {
        val angle0_PI = Vec4(abs(deterministicMod(x + PIf, PI2f) - PIf))
        val firstQuarterPi = Vec4(lessThanEqual(angle0_PI, Vec4(HPIf)))

        val revertAngle = Vec4(mix(Vec4(PIf), Vec4(0f), firstQuarterPi))
        val returnSign = Vec4(mix(Vec4(-1f), Vec4(1f), firstQuarterPi))
        val sectionAngle = Vec4(revertAngle - angle0_PI)

        return returnSign * taylorSeriesNewCos(sectionAngle)
    }

    fun perfFastCosDeterminisctic(begin: Float, end: Float, samples: Int) {

        val results = Array(samples, { Vec4() })

        val steps = (end - begin) / samples

        val time = measureNanoTime {
            for (i in 0 until samples)
                results[i] = fastCosDeterminisctic(angleShift + Vec4(begin + steps * i))
        }

        println("fastCosDeterminisctic $time ns")

        for (i in 0 until samples)
            (results[i].x in -1f..1f) shouldBe true
    }

    fun taylorSeriesRefCos(x: Vec1) = 1f -
            (x * x) / glm.factorial(2) +
            (x * x * x * x) / glm.factorial(4) -
            (x * x * x * x * x * x) / glm.factorial(6) +
            (x * x * x * x * x * x * x * x) / glm.factorial(8)

    fun taylorSeriesRefCos(x: Vec4) = 1f -
            (x * x) / glm.factorial(2) +
            (x * x * x * x) / glm.factorial(4) -
            (x * x * x * x * x * x) / glm.factorial(6) +
            (x * x * x * x * x * x * x * x) / glm.factorial(8)

    fun fastRefCos(x: Vec1): Vec1 {

        val angle0_PI = Vec1(abs(glm.mod(x + PIf, PI2f) - PIf))
//		return taylorSeriesRefCos(angle0_PI);

        val firstQuarterPi = Vec1(lessThanEqual(angle0_PI, Vec1(HPIf)))

        val revertAngle = Vec1(mix(Vec1(PIf), Vec1(0f), firstQuarterPi))
        val returnSign = Vec1(mix(Vec1(-1), Vec1(1), firstQuarterPi))
        val sectionAngle = revertAngle - angle0_PI

        return returnSign * taylorSeriesRefCos(sectionAngle)
    }

    fun fastRefCos(x: Vec4): Vec4 {

        val angle0_PI = Vec4(abs(glm.mod(x + PIf, PI2f) - PIf))
//		return taylorSeriesRefCos(angle0_PI);

        val firstQuarterPi = Vec4(lessThanEqual(angle0_PI, Vec4(HPIf)))

        val revertAngle = Vec4(mix(Vec4(PIf), Vec4(0f), firstQuarterPi))
        val returnSign = Vec4(mix(Vec4(-1), Vec4(1), firstQuarterPi))
        val sectionAngle = revertAngle - angle0_PI

        return returnSign * taylorSeriesRefCos(sectionAngle)
    }

    fun perfFastCosRef(begin: Float, end: Float, samples: Int) {

        val results = Array(samples, { Vec4() })

        val steps = (end - begin) / samples

        val time = measureNanoTime {
            for (i in 0 until samples)
                results[i] = fastRefCos(angleShift + Vec4(begin + steps * i))
        }

        println("fastCosRef $time ns")

        for (i in 0 until samples)
            (results[i].x in -1f..1f) shouldBe true
    }

    fun perfFastCosOld(begin: Float, end: Float, samples: Int) {

        val results = Array(samples, { Vec4() })

        val steps = (end - begin) / samples

        val time = measureNanoTime {
            for (i in 0 until samples)
                results[i] = glm.fastCos(angleShift + Vec4(begin + steps * i))
        }

        println("fastCosOld $time ns")

        for (i in 0 until samples)
            (results[i].x in -1f..1f) shouldBe true
    }

    fun perfCos(begin: Float, end: Float, samples: Int) {

        val results = Array(samples, { Vec4() })

        val steps = (end - begin) / samples

        val time = measureNanoTime {
            for (i in 0 until samples)
                results[i] = glm.cos(angleShift + Vec4(begin + steps * i))
        }

        println("cos $time ns")

        for (i in 0 until samples)
            (results[i].x in -1f..1f) shouldBe true
    }

    fun perf(samples: Int) {

        val begin = -PIf
        val end = PIf

        perfCos(begin, end, samples)
        perfFastCosOld(begin, end, samples)
        perfFastCosRef(begin, end, samples)
//        perfFastCosNew(begin, end, samples)
        perfFastCosDeterminisctic(begin, end, samples)
    }

    fun test() {

        //for(float Angle = -4.0f * glm::pi<float>(); Angle < 4.0f * glm::pi<float>(); Angle += 0.1f)
        //for(float Angle = -720.0f; Angle < 720.0f; Angle += 0.1f)
        var angle = 0f
        while (angle < 180f) {
            val modAngle = abs(angle) % 360f
            (modAngle in 0f..360f) shouldBe true
            val radAngle = modAngle.rad
            val cos0 = cos(radAngle)

            val cos1 = fastRefCos(Vec1(radAngle)).x
            (glm.abs(cos1 - cos0) < 0.1f) shouldBe true

            //float const Cos2 = taylorCos::fastCosNew(glm::fvec1(radAngle)).x;
            //Error += glm::abs(Cos2 - cos0) < 0.1f ? 0 : 1;

            angle += 0.1f
        }
    }
}//namespace taylorCos
