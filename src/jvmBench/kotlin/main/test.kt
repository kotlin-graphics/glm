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
        val a = Vec2()
        val b = Vec2()
        val c = a + b
        bh.consume(c.x + c.y)
    }

    @Benchmark
    fun vec2scalar(bh: Blackhole) {
        val aX = 0f
        val aY = 1f
        val bX = 2f
        val bY = 3f
        val c = aX + bX
        val d = aY + bY
        bh.consume(c + d)
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

