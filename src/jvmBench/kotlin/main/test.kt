package main

import kotlinx.benchmark.*
import glm.vec2.Vec2

@Warmup(iterations = 5/*, time = 1, timeUnit = TimeUnit.SECONDS*/)
@Measurement(iterations = 5, time = 1/*, timeUnit = TimeUnit.SECONDS*/)
//@Fork(3)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(BenchmarkTimeUnit.NANOSECONDS)
@State(Scope.Benchmark)
open class SampleBenchmark {
    //    @Benchmark
    //    fun fibClassic(bh: Blackhole) = bh.consume(Fib.fibClassic(30))
    //
    //    @Benchmark
    //    fun fibTailRec(bh: Blackhole) = bh.consume(Fib.tailRecFib(30))

    @Benchmark
    fun vec2(bh: Blackhole) {
        for (i in 0..999) {
            val a = Vec2(0, 1)
            val b = Vec2(2, 3)
            val c = a + b
            bh.consume(c.x + c.y)
        }
    }

    val A = Vec2(0, 1)
    val B = Vec2(2, 3)

    @Benchmark
    fun vec2scalar(bh: Blackhole) {
        for (i in 0..999) {
            val aX = A.x
            val aY = A.y
            val bX = B.x
            val bY = B.y
            val c = aX + bX
            val d = aY + bY
            bh.consume(c + d)
        }
    }

    @Benchmark
    fun vec2scalar2(bh: Blackhole) {
        for (i in 0..999) {
            val c = A.x + B.x
            val d = A.y + B.y
            bh.consume(c + d)
        }
    }

    @Benchmark
    fun vec2inline(bh: Blackhole) {
        for (i in 0..999) {
            A.plus(B.x, B.y) { resX, resY ->
                bh.consume(resX + resY)
            }
        }
    }

    @Benchmark
    fun vec2inline2(bh: Blackhole) {
        for (i in 0..999) {
            val x: Float; val y: Float;
            A.plus(B.x, B.y) { resX, resY -> x = resX; y = resY }
            bh.consume(x + y)
        }
    }

    val _a = floatArrayOf(0f, 1f)
    val _b = floatArrayOf(2f, 3f)
    val _c = FloatArray(2)

    @Benchmark
    fun vec2inline3(bh: Blackhole) {
        for (i in 0..999) {
            for (j in 0..1)
                _c[j] = _a[j] + _b[j]
            bh.consume(_c)
        }
    }
}

object Fib {
    fun fibClassic(n: Int): Long {
        return if (n < 2) {
            n.toLong()
        } else fibClassic(n - 1) + fibClassic(n - 2)
    }

    fun tailRecFib(n: Int): Long {
        return tailRecFib(n, 0, 1).toLong()
    }

    private fun tailRecFib(n: Int, a: Int, b: Int): Int {
        if (n == 0) {
            return a
        }
        return if (n == 1) {
            b
        } else tailRecFib(n - 1, b, a + b)
    }
}


class Vector(val x: Double, val y: Double) {
    fun add(other: Vector) = Vector(x + other.x, y + other.y)
}

