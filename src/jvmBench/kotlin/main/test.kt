package main

//import kotlinx.benchmark.*
//import glm.vec2.Vec2
//
//@Warmup(iterations = 5/*, time = 1, timeUnit = TimeUnit.SECONDS*/)
//@Measurement(iterations = 5, time = 1/*, timeUnit = TimeUnit.SECONDS*/)
////@Fork(3)
//@BenchmarkMode(Mode.AverageTime)
//@OutputTimeUnit(BenchmarkTimeUnit.NANOSECONDS)
//@State(Scope.Benchmark)
//open class SampleBenchmark {
//        @Benchmark
//        fun fibClassic(bh: Blackhole) = bh.consume(Fib.fibClassic(30))
//        @Benchmark
//        fun fibTailRec(bh: Blackhole) = bh.consume(Fib.tailRecFib(30))
////    @Benchmark
////    fun vec2(bh: Blackhole) {
//////        val a = Vec2
////    }
//}
//
//object Fib {
//    fun fibClassic(n: Int): Long {
//        return if (n < 2) {
//            n.toLong()
//        } else fibClassic(n - 1) + fibClassic(n - 2)
//    }
//
//    fun tailRecFib(n: Int): Long {
//        return tailRecFib(n, 0, 1).toLong()
//    }
//
//    private fun tailRecFib(n: Int, a: Int, b: Int): Int {
//        if (n == 0) {
//            return a
//        }
//        return if (n == 1) {
//            b
//        } else tailRecFib(n - 1, b, a + b)
//    }
//}
//
//
//class Vector(val x: Double, val y: Double) {
//    fun add(other: Vector) = Vector(x + other.x, y + other.y)
//}

import org.openjdk.jmh.annotations.*
import java.util.concurrent.*

@State(Scope.Benchmark)
@Fork(1)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Warmup(iterations = 20, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 1, time = 1, timeUnit = TimeUnit.SECONDS)
class JvmTestBenchmark {
    private var data = 0.0

    @Setup
    fun setUp() {
        data = 3.0
    }

    @Benchmark
    fun sqrtBenchmark(): Double {
        return Math.sqrt(data)
    }

    @Benchmark
    fun cosBenchmark(): Double {
        return Math.cos(data)
    }
}

