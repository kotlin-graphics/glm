package glm_.func

import glm_.scalar.abs
import glm_.assert
import glm_.vec1.Vec1
import glm_.vec2.Vec2
import glm_.vec3.Vec3
import glm_.vec4.Vec4
import kotlin.test.Test

class funcGeometric {

    @Test
    fun length() {
        val length1 = Vec1(1).length()
        val length2 = Vec2(1, 0).length()
        val length3 = Vec3(1, 0, 0).length()
        val length4 = Vec4(1, 0, 0, 0).length()

        assert((length1 - 1f).abs() < Float.MIN_VALUE)
        assert((length2 - 1f).abs() < Float.MIN_VALUE)
        assert((length3 - 1f).abs() < Float.MIN_VALUE)
        assert((length4 - 1f).abs() < Float.MIN_VALUE)
    }

    @Test
    fun distance() {
        val distance1 = Vec1(1) distance Vec1(1)
        val distance2 = Vec2(1, 0) distance Vec2(1, 0)
        val distance3 = Vec3(1, 0, 0) distance Vec3(1, 0, 0)
        val distance4 = Vec4(1, 0, 0, 0) distance Vec4(1, 0, 0, 0)

        assert(distance1.abs() < Float.MIN_VALUE)
        assert(distance2.abs() < Float.MIN_VALUE)
        assert(distance3.abs() < Float.MIN_VALUE)
        assert(distance4.abs() < Float.MIN_VALUE)
    }

    @Test
    fun dot() {
        val dot1 = Vec1(1) dot Vec1(1)
        val dot2 = Vec2(1) dot Vec2(1)
        val dot3 = Vec3(1) dot Vec3(1)
        val dot4 = Vec4(1) dot Vec4(1)

        assert((dot1 - 1f).abs() < Float.MIN_VALUE)
        assert((dot2 - 2f).abs() < Float.MIN_VALUE)
        assert((dot3 - 3f).abs() < Float.MIN_VALUE)
        assert((dot4 - 4f).abs() < Float.MIN_VALUE)
    }

    @Test
    fun cross() {
        val cross1 = Vec3(1, 0, 0) cross Vec3(0, 1, 0)
        val cross2 = Vec3(0, 1, 0) cross Vec3(1, 0, 0)

//        assert((cross1 - Vec3(0, 0, 1)).abs(), glm::vec3(std::numeric_limits<float>::epsilon()))) ? 0 : 1;
//        assert((cross2 - Vec3(0, 0,-1)).abs(), glm::vec3(std::numeric_limits<float>::epsilon()))) ? 0 : 1;
    }
}