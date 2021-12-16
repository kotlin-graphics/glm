package glm.func

import glm.abs
import glm.assert
import glm.vec1.Vec1
import glm.vec2.Vec2
import glm.vec3.Vec3
import glm.vec4.Vec4
import kotlin.test.Test

class funcGeometric {

    @Test
    fun test() {
        val length1 = Vec1(1).length()
        val length2 = Vec2(1, 0).length()
        val length3 = Vec3(1, 0, 0).length()
        val length4 = Vec4(1, 0, 0, 0).length()

        assert((length1 - 1f).abs() < Float.MIN_VALUE)
        assert((length2 - 1f).abs() < Float.MIN_VALUE)
        assert((length3 - 1f).abs() < Float.MIN_VALUE)
        assert((length4 - 1f).abs() < Float.MIN_VALUE)
    }
}