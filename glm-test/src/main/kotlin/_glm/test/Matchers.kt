// This file is auto generated! Changes will not persist.
package glm_.test


import io.kotlintest.Matcher
import io.kotlintest.MatcherResult

import glm_.mat2x2.*
import glm_.mat3x4.*
import glm_.mat3x3.*
import glm_.mat2x3.*
import glm_.vec4.*
import glm_.mat3x2.*
import glm_.mat2x4.*
import glm_.mat4x3.*
import glm_.mat4x2.*
import glm_.vec3.*
import glm_.vec2.*
import glm_.mat4x4.*

// TODO use glm.epsilonEqual

infix fun Mat2.plusOrMinus(epsilon: Float): Matcher<Mat2> = object : Matcher<Mat2> {
    override fun test(value: Mat2): MatcherResult {
        val expected = this@plusOrMinus

        val diff = value.array.zip(expected.array) { a, b -> kotlin.math.abs(a - b) }
        val passed = diff.all { it < epsilon }

        val diffStruct = Mat2(diff.map { if(it < epsilon) 0.toFloat() else it })
        return MatcherResult(passed,
            "Matrices are not equal with tolerance of $epsilon!\nexpected: $expected\nbut was: $value\nwith difference of $diffStruct",
            "Matrices should not be equal with tolerance of $epsilon")
    }
}



infix fun Mat2d.plusOrMinus(epsilon: Double): Matcher<Mat2d> = object : Matcher<Mat2d> {
    override fun test(value: Mat2d): MatcherResult {
        val expected = this@plusOrMinus

        val diff = value.array.zip(expected.array) { a, b -> kotlin.math.abs(a - b) }
        val passed = diff.all { it < epsilon }

        val diffStruct = Mat2d(diff.map { if(it < epsilon) 0.toDouble() else it })
        return MatcherResult(passed,
            "Matrices are not equal with tolerance of $epsilon!\nexpected: $expected\nbut was: $value\nwith difference of $diffStruct",
            "Matrices should not be equal with tolerance of $epsilon")
    }
}



infix fun Mat2x3.plusOrMinus(epsilon: Float): Matcher<Mat2x3> = object : Matcher<Mat2x3> {
    override fun test(value: Mat2x3): MatcherResult {
        val expected = this@plusOrMinus

        val diff = value.array.zip(expected.array) { a, b -> kotlin.math.abs(a - b) }
        val passed = diff.all { it < epsilon }

        val diffStruct = Mat2x3(diff.map { if(it < epsilon) 0.toFloat() else it })
        return MatcherResult(passed,
            "Matrices are not equal with tolerance of $epsilon!\nexpected: $expected\nbut was: $value\nwith difference of $diffStruct",
            "Matrices should not be equal with tolerance of $epsilon")
    }
}



infix fun Mat2x3d.plusOrMinus(epsilon: Double): Matcher<Mat2x3d> = object : Matcher<Mat2x3d> {
    override fun test(value: Mat2x3d): MatcherResult {
        val expected = this@plusOrMinus

        val diff = value.array.zip(expected.array) { a, b -> kotlin.math.abs(a - b) }
        val passed = diff.all { it < epsilon }

        val diffStruct = Mat2x3d(diff.map { if(it < epsilon) 0.toDouble() else it })
        return MatcherResult(passed,
            "Matrices are not equal with tolerance of $epsilon!\nexpected: $expected\nbut was: $value\nwith difference of $diffStruct",
            "Matrices should not be equal with tolerance of $epsilon")
    }
}



infix fun Mat2x4.plusOrMinus(epsilon: Float): Matcher<Mat2x4> = object : Matcher<Mat2x4> {
    override fun test(value: Mat2x4): MatcherResult {
        val expected = this@plusOrMinus

        val diff = value.array.zip(expected.array) { a, b -> kotlin.math.abs(a - b) }
        val passed = diff.all { it < epsilon }

        val diffStruct = Mat2x4(diff.map { if(it < epsilon) 0.toFloat() else it })
        return MatcherResult(passed,
            "Matrices are not equal with tolerance of $epsilon!\nexpected: $expected\nbut was: $value\nwith difference of $diffStruct",
            "Matrices should not be equal with tolerance of $epsilon")
    }
}



infix fun Mat2x4d.plusOrMinus(epsilon: Double): Matcher<Mat2x4d> = object : Matcher<Mat2x4d> {
    override fun test(value: Mat2x4d): MatcherResult {
        val expected = this@plusOrMinus

        val diff = value.array.zip(expected.array) { a, b -> kotlin.math.abs(a - b) }
        val passed = diff.all { it < epsilon }

        val diffStruct = Mat2x4d(diff.map { if(it < epsilon) 0.toDouble() else it })
        return MatcherResult(passed,
            "Matrices are not equal with tolerance of $epsilon!\nexpected: $expected\nbut was: $value\nwith difference of $diffStruct",
            "Matrices should not be equal with tolerance of $epsilon")
    }
}



infix fun Mat3x2.plusOrMinus(epsilon: Float): Matcher<Mat3x2> = object : Matcher<Mat3x2> {
    override fun test(value: Mat3x2): MatcherResult {
        val expected = this@plusOrMinus

        val diff = value.array.zip(expected.array) { a, b -> kotlin.math.abs(a - b) }
        val passed = diff.all { it < epsilon }

        val diffStruct = Mat3x2(diff.map { if(it < epsilon) 0.toFloat() else it })
        return MatcherResult(passed,
            "Matrices are not equal with tolerance of $epsilon!\nexpected: $expected\nbut was: $value\nwith difference of $diffStruct",
            "Matrices should not be equal with tolerance of $epsilon")
    }
}



infix fun Mat3x2d.plusOrMinus(epsilon: Double): Matcher<Mat3x2d> = object : Matcher<Mat3x2d> {
    override fun test(value: Mat3x2d): MatcherResult {
        val expected = this@plusOrMinus

        val diff = value.array.zip(expected.array) { a, b -> kotlin.math.abs(a - b) }
        val passed = diff.all { it < epsilon }

        val diffStruct = Mat3x2d(diff.map { if(it < epsilon) 0.toDouble() else it })
        return MatcherResult(passed,
            "Matrices are not equal with tolerance of $epsilon!\nexpected: $expected\nbut was: $value\nwith difference of $diffStruct",
            "Matrices should not be equal with tolerance of $epsilon")
    }
}



infix fun Mat3.plusOrMinus(epsilon: Float): Matcher<Mat3> = object : Matcher<Mat3> {
    override fun test(value: Mat3): MatcherResult {
        val expected = this@plusOrMinus

        val diff = value.array.zip(expected.array) { a, b -> kotlin.math.abs(a - b) }
        val passed = diff.all { it < epsilon }

        val diffStruct = Mat3(diff.map { if(it < epsilon) 0.toFloat() else it })
        return MatcherResult(passed,
            "Matrices are not equal with tolerance of $epsilon!\nexpected: $expected\nbut was: $value\nwith difference of $diffStruct",
            "Matrices should not be equal with tolerance of $epsilon")
    }
}



infix fun Mat3d.plusOrMinus(epsilon: Double): Matcher<Mat3d> = object : Matcher<Mat3d> {
    override fun test(value: Mat3d): MatcherResult {
        val expected = this@plusOrMinus

        val diff = value.array.zip(expected.array) { a, b -> kotlin.math.abs(a - b) }
        val passed = diff.all { it < epsilon }

        val diffStruct = Mat3d(diff.map { if(it < epsilon) 0.toDouble() else it })
        return MatcherResult(passed,
            "Matrices are not equal with tolerance of $epsilon!\nexpected: $expected\nbut was: $value\nwith difference of $diffStruct",
            "Matrices should not be equal with tolerance of $epsilon")
    }
}



infix fun Mat3x4.plusOrMinus(epsilon: Float): Matcher<Mat3x4> = object : Matcher<Mat3x4> {
    override fun test(value: Mat3x4): MatcherResult {
        val expected = this@plusOrMinus

        val diff = value.array.zip(expected.array) { a, b -> kotlin.math.abs(a - b) }
        val passed = diff.all { it < epsilon }

        val diffStruct = Mat3x4(diff.map { if(it < epsilon) 0.toFloat() else it })
        return MatcherResult(passed,
            "Matrices are not equal with tolerance of $epsilon!\nexpected: $expected\nbut was: $value\nwith difference of $diffStruct",
            "Matrices should not be equal with tolerance of $epsilon")
    }
}



infix fun Mat3x4d.plusOrMinus(epsilon: Double): Matcher<Mat3x4d> = object : Matcher<Mat3x4d> {
    override fun test(value: Mat3x4d): MatcherResult {
        val expected = this@plusOrMinus

        val diff = value.array.zip(expected.array) { a, b -> kotlin.math.abs(a - b) }
        val passed = diff.all { it < epsilon }

        val diffStruct = Mat3x4d(diff.map { if(it < epsilon) 0.toDouble() else it })
        return MatcherResult(passed,
            "Matrices are not equal with tolerance of $epsilon!\nexpected: $expected\nbut was: $value\nwith difference of $diffStruct",
            "Matrices should not be equal with tolerance of $epsilon")
    }
}



infix fun Mat4x2.plusOrMinus(epsilon: Float): Matcher<Mat4x2> = object : Matcher<Mat4x2> {
    override fun test(value: Mat4x2): MatcherResult {
        val expected = this@plusOrMinus

        val diff = value.array.zip(expected.array) { a, b -> kotlin.math.abs(a - b) }
        val passed = diff.all { it < epsilon }

        val diffStruct = Mat4x2(diff.map { if(it < epsilon) 0.toFloat() else it })
        return MatcherResult(passed,
            "Matrices are not equal with tolerance of $epsilon!\nexpected: $expected\nbut was: $value\nwith difference of $diffStruct",
            "Matrices should not be equal with tolerance of $epsilon")
    }
}



infix fun Mat4x2d.plusOrMinus(epsilon: Double): Matcher<Mat4x2d> = object : Matcher<Mat4x2d> {
    override fun test(value: Mat4x2d): MatcherResult {
        val expected = this@plusOrMinus

        val diff = value.array.zip(expected.array) { a, b -> kotlin.math.abs(a - b) }
        val passed = diff.all { it < epsilon }

        val diffStruct = Mat4x2d(diff.map { if(it < epsilon) 0.toDouble() else it })
        return MatcherResult(passed,
            "Matrices are not equal with tolerance of $epsilon!\nexpected: $expected\nbut was: $value\nwith difference of $diffStruct",
            "Matrices should not be equal with tolerance of $epsilon")
    }
}



infix fun Mat4x3.plusOrMinus(epsilon: Float): Matcher<Mat4x3> = object : Matcher<Mat4x3> {
    override fun test(value: Mat4x3): MatcherResult {
        val expected = this@plusOrMinus

        val diff = value.array.zip(expected.array) { a, b -> kotlin.math.abs(a - b) }
        val passed = diff.all { it < epsilon }

        val diffStruct = Mat4x3(diff.map { if(it < epsilon) 0.toFloat() else it })
        return MatcherResult(passed,
            "Matrices are not equal with tolerance of $epsilon!\nexpected: $expected\nbut was: $value\nwith difference of $diffStruct",
            "Matrices should not be equal with tolerance of $epsilon")
    }
}



infix fun Mat4x3d.plusOrMinus(epsilon: Double): Matcher<Mat4x3d> = object : Matcher<Mat4x3d> {
    override fun test(value: Mat4x3d): MatcherResult {
        val expected = this@plusOrMinus

        val diff = value.array.zip(expected.array) { a, b -> kotlin.math.abs(a - b) }
        val passed = diff.all { it < epsilon }

        val diffStruct = Mat4x3d(diff.map { if(it < epsilon) 0.toDouble() else it })
        return MatcherResult(passed,
            "Matrices are not equal with tolerance of $epsilon!\nexpected: $expected\nbut was: $value\nwith difference of $diffStruct",
            "Matrices should not be equal with tolerance of $epsilon")
    }
}



infix fun Mat4.plusOrMinus(epsilon: Float): Matcher<Mat4> = object : Matcher<Mat4> {
    override fun test(value: Mat4): MatcherResult {
        val expected = this@plusOrMinus

        val diff = value.array.zip(expected.array) { a, b -> kotlin.math.abs(a - b) }
        val passed = diff.all { it < epsilon }

        val diffStruct = Mat4(diff.map { if(it < epsilon) 0.toFloat() else it })
        return MatcherResult(passed,
            "Matrices are not equal with tolerance of $epsilon!\nexpected: $expected\nbut was: $value\nwith difference of $diffStruct",
            "Matrices should not be equal with tolerance of $epsilon")
    }
}



infix fun Mat4d.plusOrMinus(epsilon: Double): Matcher<Mat4d> = object : Matcher<Mat4d> {
    override fun test(value: Mat4d): MatcherResult {
        val expected = this@plusOrMinus

        val diff = value.array.zip(expected.array) { a, b -> kotlin.math.abs(a - b) }
        val passed = diff.all { it < epsilon }

        val diffStruct = Mat4d(diff.map { if(it < epsilon) 0.toDouble() else it })
        return MatcherResult(passed,
            "Matrices are not equal with tolerance of $epsilon!\nexpected: $expected\nbut was: $value\nwith difference of $diffStruct",
            "Matrices should not be equal with tolerance of $epsilon")
    }
}



infix fun Vec2.plusOrMinus(epsilon: Float): Matcher<Vec2> = object : Matcher<Vec2> {
    override fun test(value: Vec2): MatcherResult {
        val expected = this@plusOrMinus

        val diff = value.array.zip(expected.array) { a, b -> kotlin.math.abs(a - b) }
        val passed = diff.all { it < epsilon }

        val diffStruct = Vec2(diff.map { if(it < epsilon) 0.toFloat() else it })
        return MatcherResult(passed,
            "Vertices are not equal with tolerance of $epsilon!\nexpected: $expected\nbut was: $value\nwith difference of $diffStruct",
            "Vertices should not be equal with tolerance of $epsilon")
    }
}



infix fun Vec2d.plusOrMinus(epsilon: Double): Matcher<Vec2d> = object : Matcher<Vec2d> {
    override fun test(value: Vec2d): MatcherResult {
        val expected = this@plusOrMinus

        val diff = value.array.zip(expected.array) { a, b -> kotlin.math.abs(a - b) }
        val passed = diff.all { it < epsilon }

        val diffStruct = Vec2d(diff.map { if(it < epsilon) 0.toDouble() else it })
        return MatcherResult(passed,
            "Vertices are not equal with tolerance of $epsilon!\nexpected: $expected\nbut was: $value\nwith difference of $diffStruct",
            "Vertices should not be equal with tolerance of $epsilon")
    }
}



infix fun Vec3.plusOrMinus(epsilon: Float): Matcher<Vec3> = object : Matcher<Vec3> {
    override fun test(value: Vec3): MatcherResult {
        val expected = this@plusOrMinus

        val diff = value.array.zip(expected.array) { a, b -> kotlin.math.abs(a - b) }
        val passed = diff.all { it < epsilon }

        val diffStruct = Vec3(diff.map { if(it < epsilon) 0.toFloat() else it })
        return MatcherResult(passed,
            "Vertices are not equal with tolerance of $epsilon!\nexpected: $expected\nbut was: $value\nwith difference of $diffStruct",
            "Vertices should not be equal with tolerance of $epsilon")
    }
}



infix fun Vec3d.plusOrMinus(epsilon: Double): Matcher<Vec3d> = object : Matcher<Vec3d> {
    override fun test(value: Vec3d): MatcherResult {
        val expected = this@plusOrMinus

        val diff = value.array.zip(expected.array) { a, b -> kotlin.math.abs(a - b) }
        val passed = diff.all { it < epsilon }

        val diffStruct = Vec3d(diff.map { if(it < epsilon) 0.toDouble() else it })
        return MatcherResult(passed,
            "Vertices are not equal with tolerance of $epsilon!\nexpected: $expected\nbut was: $value\nwith difference of $diffStruct",
            "Vertices should not be equal with tolerance of $epsilon")
    }
}



infix fun Vec4.plusOrMinus(epsilon: Float): Matcher<Vec4> = object : Matcher<Vec4> {
    override fun test(value: Vec4): MatcherResult {
        val expected = this@plusOrMinus

        val diff = value.array.zip(expected.array) { a, b -> kotlin.math.abs(a - b) }
        val passed = diff.all { it < epsilon }

        val diffStruct = Vec4(diff.map { if(it < epsilon) 0.toFloat() else it })
        return MatcherResult(passed,
            "Vertices are not equal with tolerance of $epsilon!\nexpected: $expected\nbut was: $value\nwith difference of $diffStruct",
            "Vertices should not be equal with tolerance of $epsilon")
    }
}



infix fun Vec4d.plusOrMinus(epsilon: Double): Matcher<Vec4d> = object : Matcher<Vec4d> {
    override fun test(value: Vec4d): MatcherResult {
        val expected = this@plusOrMinus

        val diff = value.array.zip(expected.array) { a, b -> kotlin.math.abs(a - b) }
        val passed = diff.all { it < epsilon }

        val diffStruct = Vec4d(diff.map { if(it < epsilon) 0.toDouble() else it })
        return MatcherResult(passed,
            "Vertices are not equal with tolerance of $epsilon!\nexpected: $expected\nbut was: $value\nwith difference of $diffStruct",
            "Vertices should not be equal with tolerance of $epsilon")
    }
}


