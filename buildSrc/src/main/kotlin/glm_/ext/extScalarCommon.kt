package glm_.ext

import glm_.floatingPointTypes
import glm_.gen.Generator
import glm_.`0,5`
import glm_.`0`
import glm_.`1`
import glm_.`2`

fun Generator.extScalarCommon(type: String) {

    +"// ext scalar common\n"

    imports += listOf(
        "glm_.scalar.abs",
        "glm_.scalar.clamp",
        "glm_.scalar.floor",
        "glm_.scalar.fract",
        "glm_.scalar.min",
        "glm_.scalar.max",
        "glm_.scalar.mix",
                     )


    if (type !in floatingPointTypes)
        return

    val `0,5` = type.`0,5`
    val `0` = type.`0`
    val `1` = type.`1`
    val `2` = type.`2`

    docs("Returns the minimum component-wise values of 3 inputs")
    +"fun min(a: $type, b: $type, c: $type): $type = (a min b) min c"

    docs("Returns the minimum component-wise values of 4 inputs")
    +"fun min(a: $type, b: $type, c: $type, d: $type): $type = (a min b) min (c min d)"

    docs("Returns the maximum component-wise values of 3 inputs")
    +"fun max(a: $type, b: $type, c: $type): $type = (a max b) max c"

    docs("Returns the maximum component-wise values of 4 inputs")
    +"fun max(a: $type, b: $type, c: $type, d: $type): $type = (a max b) max (c max d)"

    docs("""
        |Returns the minimum component-wise values of 2 inputs. If one of the two arguments is `NaN`, the value of the other argument is returned.
        |
        |@see <a href="http://en.cppreference.com/w/cpp/numeric/math/fmin">std::fmin documentation</a>""")
    +"infix fun $type.fmin(b: $type): $type = if (this.isNaN()) b else this min b"

    docs("""
        |Returns the minimum component-wise values of 3 inputs. If one of the two arguments is `NaN`, the value of the other argument is returned.
        |
        |@see <a href="http://en.cppreference.com/w/cpp/numeric/math/fmin">std::fmin documentation</a>""")
    +"""
        fun fmin(a: $type, b: $type, c: $type): $type = when {
            a.isNaN() -> b fmin c
            b.isNaN() -> a fmin c
            c.isNaN() -> a min b
            else -> min(a, b, c)
        }"""

    docs("""
        |Returns the minimum component-wise values of 4 inputs. If one of the two arguments is `NaN`, the value of the other argument is returned.
        |
        |@see <a href="http://en.cppreference.com/w/cpp/numeric/math/fmin">std::fmin documentation</a>""")
    +"""
        fun fmin(a: $type, b: $type, c: $type, d: $type): $type = when {
            a.isNaN() -> fmin(b, c, d)
            b.isNaN() -> a min (c fmin d)
            c.isNaN() -> (a min b) fmin d
            d.isNaN() -> min(a, b, c)
            else -> min(a, b, c, d)
        }"""

    docs("""
         |Returns the maximum component-wise values of 2 inputs. If one of the two arguments is NaN, the value of the other argument is returned.
         |
         |@see <a href="http://en.cppreference.com/w/cpp/numeric/math/fmax">std::fmax documentation</a>""")
    +"infix fun $type.fmax(b: $type): $type = if (this.isNaN()) b else this max b"

    docs("""
        |Returns the maximum component-wise values of 3 inputs. If one of the two arguments is `NaN`, the value of the other argument is returned.
        |
        |@see <a href="http://en.cppreference.com/w/cpp/numeric/math/fmax">std::fmax documentation</a>""")
    +"""
        fun fmax(a: $type, b: $type, c: $type): $type = when {
            a.isNaN() -> b fmax c
            b.isNaN() -> a fmax c
            c.isNaN() -> a max b
            else -> max(a, b, c)
        }"""

    docs("""
        |Returns the maximum component-wise values of 4 inputs. If one of the two arguments is `NaN`, the value of the other argument is returned.
        |
        |@see <a href="http://en.cppreference.com/w/cpp/numeric/math/fmax">std::fmax documentation</a>""")
    +"""
        fun fmax(a: $type, b: $type, c: $type, d: $type): $type = when {
            a.isNaN() -> fmax(b, c, d)
            b.isNaN() -> a max (c fmax d)
            c.isNaN() -> (a max b) fmax d
            d.isNaN() -> max(a, b, c)
            else -> max(a, b, c, d)
        }"""

    docs("Returns `min(max(x, minVal), maxVal)` for each component in `x`. If one of the two arguments is `NaN`, the value of the other argument is returned.")
    +"fun $type.fclamp(minVal: $type, maxVal: $type): $type = (this fmax minVal) fmin maxVal"

    docs("Simulate GL_CLAMP OpenGL wrap mode")
    +"fun $type.clamp(): $type = clamp($`0`, $`1`)"

    docs("Simulate GL_REPEAT OpenGL wrap mode")
    +"fun $type.repeat(): $type = fract()"

    docs("Simulate GL_MIRRORED_REPEAT OpenGL wrap mode")
    +"fun $type.mirrorClamp(): $type = abs().fract()"

    docs("Simulate GL_MIRROR_REPEAT OpenGL wrap mode")
    +"""
        fun $type.mirrorRepeat(): $type {
            val abs = abs()
            val clamp = abs.floor() % $`2`
            val floor = abs.floor()
            val rest = abs - floor
            val mirror = clamp + rest
            return rest.mix($`1` - rest, mirror >= $`1`)
        }"""

    docs("""
        |Returns a value equal to the nearest integer to `x`.
        |The fraction 0.5 will round in a direction chosen by the implementation, presumably the direction that is fastest.
        |
        |@see <a href="http://www.opengl.org/sdk/docs/manglsl/xhtml/round.xml">GLSL round man page</a>""")
    +"""
        fun $type.iround(): Int {
            check($`0` <= this)
            return (this + $`0,5`).toInt()
        }"""

    docs("""
        |Returns a value equal to the nearest integer to `x`.
        |The fraction 0.5 will round in a direction chosen by the implementation, presumably the direction that is fastest.
        |
        |@see <a href="http://www.opengl.org/sdk/docs/manglsl/xhtml/round.xml">GLSL round man page</a>""")
    +"""
        fun $type.uround(): UInt {
            check($`0` <= this)
            return (this + $`0,5`).toUInt()
        }"""
}