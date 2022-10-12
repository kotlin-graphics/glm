package glm_.detail

import glm_.*
import glm_.gen.Generator

fun Generator.exponential(ordinal: Int, type: String, extension: String, id: String, vec: String, part: Generator.Part) {

    +"// exponential\n"

    val `exp,xyzw` = xyzwJoint { "exp.$it" }
    val `expXYZW type` = XyzwJoint { "exp$it: $type" }
    val `expXYZW Int` = XyzwJoint { "exp$it: Int" }
    val VecID = vec + id
    val xyzw = xyzwJoint
    val XYZW = XyzwJoint2
    val `aXYZW type` = XyzwJoint { "a$it: $type" }
    val `a,xyzw` = xyzwJoint { "a.$it" }
    //    val `a,xyzw type` = xyzwJoint { "a.$it: $type" }
    val `bXYZW` = XyzwJoint { "b$it" }
    val `bXYZW type` = XyzwJoint { "b$it: $type" }
    val `b,xyzw` = xyzwJoint { "b.$it" }
    val `c,xyzw` = xyzwJoint { "c.$it" }
    val `cXYZW type` = XyzwJoint { "c$it: $type" }
    val `cXYZW bool` = XyzwJoint { "c$it: Boolean" }
    val resXYZW = XyzwJoint { "res$it" }
    val `resXYZW type` = XyzwJoint { "res$it: $type" }
    val `resXYZW Bool` = XyzwJoint { "res$it: Boolean" }
    val `xyzw type` = xyzwJoint { "$it: $type" }
    val `v,xyzw` = xyzwJoint { "v.$it" }
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
    val `edge0,xyzw` = xyzwJoint { "edge0.$it" }
    val `edge1,xyzw` = xyzwJoint { "edge1.$it" }
    val `edge0XYZW type` = XyzwJoint { "edge0$it: $type" }
    val `edge1XYZW type` = XyzwJoint { "edge1$it: $type" }

    fun glslDocs(descr: String, manPage: String, append: String = "") = docs("""
            |$descr
            |
            |[GLSL $manPage man page](http://www.opengl.org/sdk/docs/manglsl/xhtml/$manPage.xml)
            |[GLSL 4.20.8 specification, section 8.2 Exponential Functions](http://www.opengl.org/registry/doc/GLSLangSpec.4.20.8.pdf)
            |$append""")

    if (type in floatingPointTypes) {

        fun pow(base: String = "[$xyzw]", exp: String = "exp.[$xyzw]") = glslDocs("Returns `$base` raised to the power `$exp`.", "pow")
        when (part) {
            Generator.Part.Class -> {
                pow()
                +"infix fun powAssign(exp: $VecID): $VecID = pow(exp, this)"
                pow()
                +"infix fun pow(exp: $VecID): $VecID = pow(exp, $VecID())"
                pow()
                +"fun pow(exp: $VecID, res: $VecID): $VecID = pow(exp) { $`resXYZW type` -> res($resXYZW) }"
                pow()
                "inline fun <R> pow(exp: $VecID, res: ($`resXYZW type`) -> R): R" {
                    +contract
                    +"return pow(this, exp, res)"
                }
            }
            Generator.Part.CompanionObject -> {
                if (type != "Int") {
                    pow("v.[$xyzw]")
                    "inline fun <R> pow(v: $VecID, exp: ${vec}i, res: ($`resXYZW type`) -> R): R" {
                        +contract
                        +"return pow($`v,xyzw`, $`exp,xyzw`, res)"
                    }
                    pow()
                    "inline fun <R> pow($`xyzw type`, $`expXYZW Int`, res: ($`resXYZW type`) -> R): R" {
                        +contract
                        +"return res(${xyzwJoint { "$it pow exp${it.toUpperCase()}" }})"
                    }
                }
                pow("v.[$xyzw]")
                "inline fun <R> pow(v: $VecID, exp: $VecID, res: ($`resXYZW type`) -> R): R" {
                    +contract
                    +"return pow($`v,xyzw`, $`exp,xyzw`, res)"
                }
                pow()
                "inline fun <R> pow($`xyzw type`, $`expXYZW type`, res: ($`resXYZW type`) -> R): R" {
                    +contract
                    +"return res(${xyzwJoint { "$it pow exp${it.toUpperCase()}" }})"
                }
            }
            Generator.Part.Scalar -> {
                pow("this")
                +"inline infix fun $type.pow(exponent: Int): $type = pow(exponent)"
                pow("this")
                +"inline infix fun $type.pow(exponent: $type): $type = pow(exponent)"
            }
        }

        fun exp(x: String = "[$xyzw]") = glslDocs("Returns the natural exponentiation of `$x`, i.e., `e^$x`.", "exp")
        when (part) {
            Generator.Part.Class -> {
                exp()
                +"fun expAssign(): $VecID = exp(this)"
                exp()
                +"fun exp(res: $VecID = $VecID()): $VecID = exp(this) { $`resXYZW type` -> res($resXYZW) }"
            }
            Generator.Part.CompanionObject -> {
                exp("v.[$xyzw]")
                "inline fun <R> exp(v: $VecID, res: ($`resXYZW type`) -> R): R" {
                    +contract
                    +"return exp($`v,xyzw`, res)"
                }
                exp()
                "inline fun <R> exp($`xyzw type`, res: ($`resXYZW type`) -> R): R" {
                    +contract
                    +"return res(${xyzwJoint { "$it.exp()" }})"
                }
            }
            Generator.Part.Scalar -> {
                exp("this")
                +"inline fun $type.exp(): $type = kotlin.math.exp(this)"
            }
        }

        fun log(x: String = "[$xyzw]") = glslDocs("""
            |Returns the natural logarithm of `$x`, i.e., returns the value `y` which satisfies the equation `$x = e^y`.
            |Results are undefined if v <= 0.""", "log")
        when (part) {
            Generator.Part.Class -> {
                log()
                +"fun logAssign(): $VecID = log(this)"
                log()
                +"fun log(res: $VecID = $VecID()): $VecID = log(this) { $`resXYZW type` -> res($resXYZW) }"
            }
            Generator.Part.CompanionObject -> {
                log("v.[$xyzw]")
                "inline fun <R> log(v: $VecID, res: ($`resXYZW type`) -> R): R" {
                    +contract
                    +"return log($`v,xyzw`, res)"
                }
                log()
                "inline fun <R> log($`xyzw type`, res: ($`resXYZW type`) -> R): R" {
                    +contract
                    +"return res(${xyzwJoint { "$it.log()" }})"
                }
            }
            Generator.Part.Scalar -> {
                log("this")
                +"inline fun $type.log(): $type = kotlin.math.ln(this)"
            }
        }

        fun exp2(x: String = "[$xyzw]") = glslDocs("Returns `2` raised to the `$x` power.", "exp2")
        when (part) {
            Generator.Part.Class -> {
                exp2()
                +"fun exp2Assign(): $VecID = exp2(this)"
                exp2()
                +"fun exp2(res: $VecID = $VecID()): $VecID = exp2(this) { $`resXYZW type` -> res($resXYZW) }"

            }
            Generator.Part.CompanionObject -> {
                exp2("v.[$xyzw]")
                "inline fun <R> exp2(v: $VecID, res: ($`resXYZW type`) -> R): R" {
                    +contract
                    +"return exp2($`v,xyzw`, res)"
                }
                exp2()
                "inline fun <R> exp2($`xyzw type`, res: ($`resXYZW type`) -> R): R" {
                    +contract
                    +"return res(${xyzwJoint { "$it.exp2()" }})"
                }
            }
            Generator.Part.Scalar -> {
                exp2("this")
                +"inline fun $type.exp2(): $type = ${type.`2`} pow this"
            }
        }

        fun log2(x: String = "[$xyzw]") = glslDocs("Returns the base 2 log of `$x`, i.e., returns the value `y`, which satisfies the equation `$x = 2 ^ y`.", "log2")
        when (part) {
            Generator.Part.Class -> {
                log2()
                +"fun log2Assign(): $VecID = log2(this)"
                log2()
                +"fun log2(res: $VecID = $VecID()): $VecID = log2(this) { $`resXYZW type` -> res($resXYZW) }"
            }
            Generator.Part.CompanionObject -> {
                log2("v.[$xyzw]")
                "inline fun <R> log2(v: $VecID, res: ($`resXYZW type`) -> R): R" {
                    +contract
                    +"return log2($`v,xyzw`, res)"
                }
                log2()
                "inline fun <R> log2($`xyzw type`, res: ($`resXYZW type`) -> R): R" {
                    +contract
                    +"return res(${xyzwJoint { "$it.log2()" }})"
                }
            }
            Generator.Part.Scalar -> {
                log2("this")
                +"inline fun $type.log2(): $type = kotlin.math.log2(this)"
            }
        }

        fun sqrt(x: String = "[$xyzw]") = glslDocs("Returns the positive square root of `$x`.", "sqrt")
        when (part) {
            Generator.Part.Class -> {
                sqrt()
                +"fun sqrtAssign(): $VecID = sqrt(this)"
                sqrt()
                +"fun sqrt(res: $VecID = $VecID()): $VecID = sqrt(this) { $`resXYZW type` -> res($resXYZW) }"
            }
            Generator.Part.CompanionObject -> {
                sqrt("v.[$xyzw]")
                "inline fun <R> sqrt(v: $VecID, res: ($`resXYZW type`) -> R): R" {
                    +contract
                    +"return sqrt($`v,xyzw`, res)"
                }
                sqrt()
                "inline fun <R> sqrt($`xyzw type`, res: ($`resXYZW type`) -> R): R" {
                    +contract
                    +"return res(${xyzwJoint { "$it.sqrt()" }})"
                }
            }
            Generator.Part.Scalar -> {
                sqrt("this")
                +"inline fun $type.sqrt(): $type = kotlin.math.sqrt(this)"
            }
        }

        fun inverseSqrt(x: String = "[$xyzw]") = glslDocs("Returns the reciprocal of the positive square root of `$x`.", "inversesqrt")
        when (part) {
            Generator.Part.Class -> {
                inverseSqrt()
                +"fun inverseSqrtAssign(): $VecID = inverseSqrt(this)"
                inverseSqrt()
                +"fun inverseSqrt(res: $VecID = $VecID()): $VecID = inverseSqrt($xyzw) { $`resXYZW type` -> res($resXYZW) }"
            }
            Generator.Part.CompanionObject -> {
                inverseSqrt("v.[$xyzw]")
                "inline fun <R> inverseSqrt(v: $VecID, res: ($`resXYZW type`) -> R): R" {
                    +contract
                    +"return inverseSqrt($`v,xyzw`, res)"
                }
                inverseSqrt()
                "inline fun <R> inverseSqrt($`xyzw type`, res: ($`resXYZW type`) -> R): R" {
                    +contract
                    +"return res(${xyzwJoint { "$it.inverseSqrt()" }})"
                }
            }
            Generator.Part.Scalar -> {
                inverseSqrt("this")
                +"inline fun $type.inverseSqrt(): $type = ${type.`1`} / sqrt()"
            }
        }
    }
}