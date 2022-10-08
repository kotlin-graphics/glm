package glm_.detail

import glm_.*
import glm_.gen.Generator

fun Generator.trigonometric(ordinal: Int, type: String, extension: String, id: String, vec: String, part: Generator.Part) {

    +"\n// trigonometric\n"
    val `exp,xyzw` = xyzwJoint { "exp.$it" }
    val `expXYZW type` = xyzwJoint { "exp$it: $type" }
    val `expXYZW Int` = xyzwJoint { "exp$it: Int" }
    val VecID = vec + id
    val xyzw = xyzwJoint
    val `-xyzw` = xyzwJoint { "-$it" }
    val XYZW = XyzwJoint2
    val `aXYZW type` = XyzwJoint { "a$it: $type" }
    val `a,xyzw` = xyzwJoint { "a.$it" }
    //    val `a,xyzw type` = xyzwJoint { "a.$it: $type" }
    val `bXYZW` = XyzwJoint { "b$it" }
    val `bXYZW type` = XyzwJoint { "b$it: $type" }
    val `b,xyzw` = xyzwJoint { "b.$it" }
    val `n,xyzw` = xyzwJoint { "n.$it" }
    val `i,xyzw` = xyzwJoint { "i.$it" }
    val `nRef,xyzw` = xyzwJoint { "nRef.$it" }
    val `cXYZW type` = XyzwJoint { "c$it: $type" }
    val `cXYZW bool` = XyzwJoint { "c$it: Boolean" }
    val resXYZW = XyzwJoint { "res$it" }
    val `resXYZW type` = XyzwJoint { "res$it: $type" }
    val `resXYZW Bool` = XyzwJoint { "res$it: Boolean" }
    val `xyzw type` = xyzwJoint { "$it: $type" }
    val `iXYZW type` = XyzwJoint { "i$it: $type" }
    val iXYZW = XyzwJoint { "i$it" }
    val `nXYZW type` = XyzwJoint { "n$it: $type" }
    val nXYZW = XyzwJoint { "n$it" }
    val `nRefXYZW type` = XyzwJoint { "nRef$it: $type" }
    val nRefXYZW = XyzwJoint { "nRef$it" }
    val `v,xyzw` = xyzwJoint { "v.$it" }
    val `v,xyzw type` = xyzwJoint { "v.$it: $type" }
    val `v0,xyzw` = xyzwJoint { "v0.$it" }
    val `v1,xyzw` = xyzwJoint { "v1.$it" }
    val bbbb = xyzwJoint { "b" }
    val minValJoint = xyzwJoint { "minVal" }
    val maxValJoint = xyzwJoint { "maxVal" }
    val `minVal,xyzw` = xyzwJoint { "minVal.$it" }
    val `maxVal,xyzw` = xyzwJoint { "maxVal.$it" }
    val `minValXYZW type` = XyzwJoint { "minVal$it: $type" }
    val `maxValXYZW type` = XyzwJoint { "maxVal$it: $type" }
    val otherFloatType = if (type == "Float") "Double" else "Float"
    val otherFloatVecID = if (type == "Float") "${vec}d" else vec
    val edgeJoint = XyzwJoint { "edge" }
    val edge0Joint = XyzwJoint { "edge0" }
    val edge1Joint = XyzwJoint { "edge1" }
    val edgeXYZW = XyzwJoint { "edge$it: $type" }
    val `edge,xyzw` = xyzwJoint { "edge.$it" }
    val `y,xyzw` = xyzwJoint { "y.$it" }
    val `x,xyzw` = xyzwJoint { "x.$it" }
    val `xXYZW type` = XyzwJoint { "x$it: $type" }
    val `edge0XYZW type` = XyzwJoint { "edge0$it: $type" }
    val `edge1XYZW type` = XyzwJoint { "edge1$it: $type" }

    if (type !in floatingPointTypes)
        return

    fun glslDocs(descr: String, manPage: String, append: String = "") = docs("""
            |$descr
            |
            |[GLSL $manPage man page](http://www.opengl.org/sdk/docs/manglsl/xhtml/$manPage.xml)
            |[GLSL 4.20.8 specification, section 8.1 Angle and Trigonometry Functions](http://www.opengl.org/registry/doc/GLSLangSpec.4.20.8.pdf)
            |$append""")

    fun radians() = glslDocs("Converts degrees to radians and returns the result.", "radians")
    when(part) {
        Generator.Part.Class -> {
            radians()
            +"fun radiansAssign(): $VecID = radians(this)"
            radians()
            +"fun radians(res: $VecID = $VecID()): $VecID = radians(this) { $`resXYZW type` -> res($resXYZW) }"
            radians()
            "inline fun <R> radians(res: ($`resXYZW type`) -> R): R" {
                contract
                +"return radians(this) { $`resXYZW type` -> res($resXYZW) }"
            }
        }
        Generator.Part.CompanionObject -> {
            radians()
            "inline fun <R> radians(v: $VecID, res: ($`resXYZW type`) -> R): R" {
                contract
                +"return radians($`v,xyzw`, res)"
            }
            radians()
            "inline fun <R> radians($`xyzw type`, res: ($`resXYZW type`) -> R): R" {
                contract
                +"return res(${xyzwJoint { "$it.rad" }})"
            }
        }
        Generator.Part.Scalar -> {
            radians()
            +"expect val $type.rad: $type"
        }
    }

    fun degrees() = glslDocs("Converts radians to degrees and returns the result.", "degrees.xml")
    when(part) {
        Generator.Part.Class -> {
            degrees()
            +"fun degreesAssign(): $VecID = degrees(this)"
            degrees()
            +"fun degrees(res: $VecID = $VecID()): $VecID = degrees(this) { $`resXYZW type` -> res($resXYZW) }"
            degrees()
            "inline fun <R> degrees(res: ($`resXYZW type`) -> R): R" {
                contract
                +"return degrees(this) { $`resXYZW type` -> res($resXYZW) }"
            }
        }
        Generator.Part.CompanionObject -> {
            degrees()
            "inline fun <R> degrees(v: $VecID, res: ($`resXYZW type`) -> R): R" {
                contract
                +"return degrees($`v,xyzw`, res)"
            }
            degrees()
            "inline fun <R> degrees($`xyzw type`, res: ($`resXYZW type`) -> R): R" {
                contract
                +"return res(${xyzwJoint { "$it.deg" }})"
            }
        }
        Generator.Part.Scalar -> {
            degrees()
            +"expect val $type.deg: $type"
        }
    }

    fun sin() = glslDocs("The standard trigonometric sine function. The values returned by this function will range from `[-1, 1]`.", "sin")
    when(part) {
        Generator.Part.Class -> {
            sin()
            +"fun sinAssign(): $VecID = sin(this)"
            sin()
            +"fun sin(res: $VecID = $VecID()): $VecID = sin(this) { $`resXYZW type` -> res($resXYZW) }"
            sin()
            "inline fun <R> sin(res: ($`resXYZW type`) -> R): R" {
                contract
                +"return sin(this) { $`resXYZW type` -> res($resXYZW) }"
            }
        }
        Generator.Part.CompanionObject -> {
            sin()
            "inline fun <R> sin(v: $VecID, res: ($`resXYZW type`) -> R): R" {
                contract
                +"return sin($`v,xyzw`, res)"
            }
            sin()
            "inline fun <R> sin($`xyzw type`, res: ($`resXYZW type`) -> R): R" {
                contract
                +"return res(${xyzwJoint { "$it.sin" }})"
            }
        }
        Generator.Part.Scalar -> {
            sin()
            +"inline val $type.sin: $type get() = kotlin.math.sin(this)"
        }
    }

    fun cos() = glslDocs("The standard trigonometric cosine function. The values returned by this function will range from `[-1, 1]`.", "cos")
    when(part) {
        Generator.Part.Class -> {
            cos()
            +"fun cosAssign(): $VecID = cos(this)"
            cos()
            +"fun cos(res: $VecID = $VecID()): $VecID = cos(this) { $`resXYZW type` -> res($resXYZW) }"
            cos()
            "inline fun <R> cos(res: ($`resXYZW type`) -> R): R" {
                contract
                +"return cos(this) { $`resXYZW type` -> res($resXYZW) }"
            }
        }
        Generator.Part.CompanionObject -> {
            cos()
            "inline fun <R> cos(v: $VecID, res: ($`resXYZW type`) -> R): R" {
                contract
                +"return cos($`v,xyzw`, res)"
            }
            cos()
            "inline fun <R> cos($`xyzw type`, res: ($`resXYZW type`) -> R): R" {
                contract
                +"return res(${xyzwJoint { "$it.cos" }})"
            }
        }
        Generator.Part.Scalar -> {
            cos()
            +"inline val $type.cos: $type get() = kotlin.math.cos(this)"
        }
    }

    fun tan() = glslDocs("The standard trigonometric tangent function.", "tan")
    when(part) {
        Generator.Part.Class -> {
            tan()
            +"fun tanAssign(): $VecID = tan(this)"
            tan()
            +"fun tan(res: $VecID = $VecID()): $VecID = tan(this) { $`resXYZW type` -> res($resXYZW) }"
            tan()
            "inline fun <R> tan(res: ($`resXYZW type`) -> R): R" {
                contract
                +"return tan(this) { $`resXYZW type` -> res($resXYZW) }"
            }
        }
        Generator.Part.CompanionObject -> {
            tan()
            "inline fun <R> tan(v: $VecID, res: ($`resXYZW type`) -> R): R" {
                contract
                +"return tan($`v,xyzw`, res)"
            }
            tan()
            "inline fun <R> tan($`xyzw type`, res: ($`resXYZW type`) -> R): R" {
                contract
                +"return res(${xyzwJoint { "$it.tan" }})"
            }
        }
        Generator.Part.Scalar -> {
            tan()
            +"inline val $type.tan: $type get() = kotlin.math.tan(this)"
        }
    }

    fun asin(x: String = "[$xyzw]") = glslDocs("""
        |Arc sine. Returns an angle whose sine is `$x`."
        |The range of values returned by this function is `[-PI/2, PI/2]`.
        |Results are undefined if `|$x| > 1`.""", "asin")
    when(part) {
        Generator.Part.Class -> {
            asin()
            +"fun asinAssign(): $VecID = asin(this)"
            asin()
            +"fun asin(res: $VecID = $VecID()): $VecID = asin(this) { $`resXYZW type` -> res($resXYZW) }"
            asin()
            "inline fun <R> asin(res: ($`resXYZW type`) -> R): R" {
                contract
                +"return asin(this) { $`resXYZW type` -> res($resXYZW) }"
            }
        }
        Generator.Part.CompanionObject -> {
            asin("v.[$xyzw]")
            "inline fun <R> asin(v: $VecID, res: ($`resXYZW type`) -> R): R" {
                contract
                +"return asin($`v,xyzw`, res)"
            }
            asin()
            "inline fun <R> asin($`xyzw type`, res: ($`resXYZW type`) -> R): R" {
                contract
                +"return res(${xyzwJoint { "$it.asin" }})"
            }
        }
        Generator.Part.Scalar -> {
            asin("this")
            +"inline val $type.asin: $type get() = kotlin.math.asin(this)"
        }
    }

    fun acos(x: String = "[$xyzw]") = glslDocs("""
        |Arc cosine. Returns an angle whose cosine is `$x`.
        |The range of values returned by this function is `[0, PI]`.
        |Results are undefined if `|$x| > 1`.""", "acos")
    when(part) {
        Generator.Part.Class -> {
            acos()
            +"fun acosAssign(): $VecID = acos(this)"
            acos()
            +"fun acos(res: $VecID = $VecID()): $VecID = acos(this) { $`resXYZW type` -> res($resXYZW) }"
            acos()
            "inline fun <R> acos(res: ($`resXYZW type`) -> R): R" {
                contract
                +"return acos(this) { $`resXYZW type` -> res($resXYZW) }"
            }
        }
        Generator.Part.CompanionObject -> {
            acos("v.[$xyzw]")
            "inline fun <R> acos(v: $VecID, res: ($`resXYZW type`) -> R): R" {
                contract
                +"return acos($`v,xyzw`, res)"
            }
            acos()
            "inline fun <R> acos($`xyzw type`, res: ($`resXYZW type`) -> R): R" {
                contract
                +"return res(${xyzwJoint { "$it.acos" }})"
            }
        }
        Generator.Part.Scalar -> {
            acos("this")
            +"inline val $type.acos: $type get() = kotlin.math.acos(this)"
        }
    }

    fun atan2(y: String = "[$xyzw]", x: String = "x.[$xyzw]") = glslDocs("""
        |Arc tangent. Returns an angle whose tangent is `$y/$x`.
        |The signs of `$x` and `$y` are used to determine what quadrant the angle is in.
        |The range of values returned by this function is `[-PI, PI]`.
        |Results are undefined if `$x` and `$y` are both `0`.""", "atan")
    when(part) {
        Generator.Part.Class -> {
            atan2()
            +"infix fun atanAssign(x: $VecID): $VecID = atan(x, this)"
            atan2()
            +"fun atan(x: $VecID, res: $VecID = $VecID()): $VecID = atan(x, this) { $`resXYZW type` -> res($resXYZW) }"
            atan2()
            "inline fun <R> atan(x: $VecID, res: ($`resXYZW type`) -> R): R" {
                contract
                +"return atan(this, x) { $`resXYZW type` -> res($resXYZW) }"
            }
        }
        Generator.Part.CompanionObject -> {
            atan2("y.[$xyzw]", "x.[$xyzw]")
            "inline fun <R> atan(y: $VecID, x: $VecID, res: ($`resXYZW type`) -> R): R" {
                contract
                +"return atan($`y,xyzw`, $`x,xyzw`, res)"
            }
            atan2(y = "x[$XYZW]")
            "inline fun <R> atan($`xyzw type`, $`xXYZW type`, res: ($`resXYZW type`) -> R): R" {
                contract
                +"return res(${xyzwJoint { "$it atan x${it.toUpperCase()}" }})"
            }
        }
        Generator.Part.Scalar -> {
            atan2("this", "x")
            +"inline infix fun $type.atan(x: $type): $type = kotlin.math.atan2(this, x)"
        }
    }

    fun atan(yOverX: String = "[$xyzw]") = glslDocs("""
        |Arc tangent. Returns an angle whose tangent is $yOverX.
        |The range of values returned by this function is `[-PI/2, PI/2]`.""", "atan")
    when(part) {
        Generator.Part.Class -> {
            atan()
            +"fun atanAssign(): $VecID = atan(this)"
            atan()
            +"fun atan(res: $VecID = $VecID()): $VecID = atan(this) { $`resXYZW type` -> res($resXYZW) }"
            atan()
            "inline fun <R> atan(res: ($`resXYZW type`) -> R): R" {
                contract
                +"return atan(this) { $`resXYZW type` -> res($resXYZW) }"
            }
        }
        Generator.Part.CompanionObject -> {
            atan("v.[$xyzw]")
            "inline fun <R> atan(v: $VecID, res: ($`resXYZW type`) -> R): R" {
                contract
                +"return atan($`v,xyzw`, res)"
            }
            atan()
            "inline fun <R> atan($`xyzw type`, res: ($`resXYZW type`) -> R): R" {
                contract
                +"return res(${xyzwJoint { "$it.atan" }})"
            }
        }
        Generator.Part.Scalar -> {
            atan("this")
            +"inline val $type.atan: $type get() = kotlin.math.atan(this)"
        }
    }

    fun sinh() = glslDocs("Returns the hyperbolic sine function, `(exp(x) - exp(-x)) / 2`", "sinh")
    when(part) {
        Generator.Part.Class -> {
            sinh()
            +"fun sinhAssign(): $VecID = sinh(this)"
            sinh()
            +"fun sinh(res: $VecID = $VecID()): $VecID = sinh(this) { $`resXYZW type` -> res($resXYZW) }"
            sinh()
            "inline fun <R> sinh(res: ($`resXYZW type`) -> R): R" {
                contract
                +"return sinh(this) { $`resXYZW type` -> res($resXYZW) }"
            }
        }
        Generator.Part.CompanionObject -> {
            sinh()
            "inline fun <R> sinh(v: $VecID, res: ($`resXYZW type`) -> R): R" {
                contract
                +"return sinh($`v,xyzw`, res)"
            }
            sinh()
            "inline fun <R> sinh($`xyzw type`, res: ($`resXYZW type`) -> R): R" {
                contract
                +"return res(${xyzwJoint { "$it.sinh" }})"
            }
        }
        Generator.Part.Scalar -> {
            sinh()
            +"inline val $type.sinh: $type get() = kotlin.math.sinh(this)"
        }
    }

    fun cosh() = glslDocs("Returns the hyperbolic cosine function, `(exp(x) + exp(-x)) / 2`", "cosh")
    when(part) {
        Generator.Part.Class -> {
            cosh()
            +"fun coshAssign(): $VecID = cosh(this)"
            cosh()
            +"fun cosh(res: $VecID = $VecID()): $VecID = cosh(this) { $`resXYZW type` -> res($resXYZW) }"
            cosh()
            "inline fun <R> cosh(res: ($`resXYZW type`) -> R): R" {
                contract
                +"return cosh(this) { $`resXYZW type` -> res($resXYZW) }"
            }
        }
        Generator.Part.CompanionObject -> {
            cosh()
            "inline fun <R> cosh(v: $VecID, res: ($`resXYZW type`) -> R): R" {
                contract
                +"return cosh($`v,xyzw`, res)"
            }
            cosh()
            "inline fun <R> cosh($`xyzw type`, res: ($`resXYZW type`) -> R): R" {
                contract
                +"return res(${xyzwJoint { "$it.cosh" }})"
            }
        }
        Generator.Part.Scalar -> {
            cosh()
            +"inline val $type.cosh: $type get() = kotlin.math.cosh(this)"
        }
    }

    fun tanh() = glslDocs("Returns the hyperbolic tangent function, `sinh(angle) / cosh(angle)`", "tanh")
    when(part) {
        Generator.Part.Class -> {
            tanh()
            +"fun tanhAssign(): $VecID = tanh(this)"
            tanh()
            +"fun tanh(res: $VecID = $VecID()): $VecID = tanh(this) { $`resXYZW type` -> res($resXYZW) }"
            tanh()
            "inline fun <R> tanh(res: ($`resXYZW type`) -> R): R" {
                contract
                +"return tanh(this) { $`resXYZW type` -> res($resXYZW) }"
            }
        }
        Generator.Part.CompanionObject -> {
            tanh()
            "inline fun <R> tanh(v: $VecID, res: ($`resXYZW type`) -> R): R" {
                contract
                +"return tanh($`v,xyzw`, res)"
            }
            tanh()
            "inline fun <R> tanh($`xyzw type`, res: ($`resXYZW type`) -> R): R" {
                contract
                +"return res(${xyzwJoint { "$it.tanh" }})"
            }
        }
        Generator.Part.Scalar -> {
            tanh()
            +"inline val $type.tanh: $type get() = kotlin.math.tanh(this)"
        }
    }

    fun asinh() = glslDocs("Arc hyperbolic sine; returns the inverse of sinh.", "asinh")
    when(part) {
        Generator.Part.Class -> {
            asinh()
            +"fun asinhAssign(): $VecID = asinh(this)"
            asinh()
            +"fun asinh(res: $VecID = $VecID()): $VecID = asinh(this) { $`resXYZW type` -> res($resXYZW) }"
            asinh()
            "inline fun <R> asinh(res: ($`resXYZW type`) -> R): R" {
                contract
                +"return asinh(this) { $`resXYZW type` -> res($resXYZW) }"
            }
        }
        Generator.Part.CompanionObject -> {
            asinh()
            "inline fun <R> asinh(v: $VecID, res: ($`resXYZW type`) -> R): R" {
                contract
                +"return asinh($`v,xyzw`, res)"
            }
            asinh()
            "inline fun <R> asinh($`xyzw type`, res: ($`resXYZW type`) -> R): R" {
                contract
                +"return res(${xyzwJoint { "$it.asinh" }})"
            }
        }
        Generator.Part.Scalar -> {
            asinh()
            +"inline val $type.asinh: $type get() = kotlin.math.asinh(this)"
        }
    }

    fun acosh(x: String = "[$xyzw]") = glslDocs("Arc hyperbolic cosine; returns the non-negative inverse of cosh. Results are undefined if `$x < 1`.", "acosh")
    when(part) {
        Generator.Part.Class -> {
            acosh()
            +"fun acoshAssign(): $VecID = acosh(this)"
            acosh()
            +"fun acosh(res: $VecID = $VecID()): $VecID = acosh(this) { $`resXYZW type` -> res($resXYZW) }"
            acosh()
            "inline fun <R> acosh(res: ($`resXYZW type`) -> R): R" {
                contract
                +"return acosh(this) { $`resXYZW type` -> res($resXYZW) }"
            }
        }
        Generator.Part.CompanionObject -> {
            acosh()
            "inline fun <R> acosh(v: $VecID, res: ($`resXYZW type`) -> R): R" {
                contract
                +"return acosh($`v,xyzw`, res)"
            }
            acosh()
            "inline fun <R> acosh($`xyzw type`, res: ($`resXYZW type`) -> R): R" {
                contract
                +"return res(${xyzwJoint { "$it.acosh" }})"
            }
        }
        Generator.Part.Scalar -> {
            acosh()
            +"inline val $type.acosh: $type get() = kotlin.math.acosh(this)"
        }
    }

    fun atanh(x: String = "[$xyzw]") = glslDocs("Arc hyperbolic tangent; returns the inverse of tanh. Results are undefined if `abs($x) >= 1`.", "atanh")
    when(part) {
        Generator.Part.Class -> {
            atanh()
            +"fun atanhAssign(): $VecID = atanh(this)"
            atanh()
            +"fun atanh(res: $VecID = $VecID()): $VecID = atanh(this) { $`resXYZW type` -> res($resXYZW) }"
            atanh()
            "inline fun <R> atanh(res: ($`resXYZW type`) -> R): R" {
                contract
                +"return atanh(this) { $`resXYZW type` -> res($resXYZW) }"
            }
        }
        Generator.Part.CompanionObject -> {
            atanh()
            "inline fun <R> atanh(v: $VecID, res: ($`resXYZW type`) -> R): R" {
                contract
                +"return atanh($`v,xyzw`, res)"
            }
            atanh()
            "inline fun <R> atanh($`xyzw type`, res: ($`resXYZW type`) -> R): R" {
                contract
                +"return res(${xyzwJoint { "$it.atanh" }})"
            }
        }
        Generator.Part.Scalar -> {
            atanh()
            +"inline val $type.atanh: $type get() = kotlin.math.atanh(this)"
        }
    }
}