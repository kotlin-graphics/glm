package glm_.perf

import glm_.f
import glm_.mat4x4.Mat4
import io.kotlintest.specs.StringSpec
import kotlin.system.measureNanoTime
import kotlin.system.measureTimeMillis

class perf_matrix_mul : StringSpec() { // TODO all other case

    init {
        "compMatMulMat" { compMatMulMat(100_000) }
    }

    fun compMatMulMat(samples: Int) {

        val transform = Mat4(
                1, 2, 3, 4,
                5, 6, 7, 8,
                9, 10, 11, 12,
                13, 14, 15, 16)
        val scale = Mat4(
                0.01, 0.02, 0.03, 0.05,
                0.01, 0.02, 0.03, 0.05,
                0.01, 0.02, 0.03, 0.05,
                0.01, 0.02, 0.03, 0.05)

        val mat4SISD = ArrayList<Mat4>()
        println("mat4 * mat4 (SISD) duration ${launchMatMulMat(mat4SISD, transform, scale, samples) / 1_000} us")

//        std::vector < glm::aligned_mat4 > Mat4SIMD;
//        printf("mat4 * mat4 (SIMD) duration %d us\n", launch_mat_mul_mat < glm::aligned_mat4 > (Mat4SIMD, Transform, Scale, Samples));

//        for (std:: size_t i = 0; i < Samples; ++i)
//        Error += glm::all(glm::equal(Mat4SISD[i], Mat4SIMD[i], 0.001)) ? 0 : 1;
    }

    fun launchMatMulMat(o: ArrayList<Mat4>, transform: Mat4, scale: Mat4, samples: Int): Long {

        val i = Array(samples) { scale * it.f }
        val output = Array(samples) { Mat4() }

        val warmTimes = 10
        repeat(warmTimes) { testMatMulMat(transform, i, output) }

        return measureNanoTime { testMatMulMat(transform, i, output) }.also {
            output.toCollection(o)
        }
    }

    fun testMatMulMat(m: Mat4, input: Array<Mat4>, output: Array<Mat4>) {
        for (i in input.indices)
            m.times(input[i], output[i])
    }
}