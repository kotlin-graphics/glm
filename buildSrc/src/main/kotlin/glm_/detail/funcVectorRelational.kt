package glm_.detail

import glm_.XyzwJoint
import glm_.gen.Generator
import glm_.xyzwJoint

fun Generator.vectorRelational(ordinal: Int, type: String, extension: String, id: String, vec: String, part: Generator.Part) {

    if (part != Generator.Part.Scalar) +"\n// vector relational\n"

    imports += "glm_.vec$ordinal.${vec}bool"

    fun rel(doc: String, manPage: String, append: String = "") = docs("""
        ${if (doc.startsWith('|')) doc else "|$doc"}
        |
        |[GLSL $manPage man page](http://www.opengl.org/sdk/docs/manglsl/xhtml/$manPage.xml)
        |[GLSL 4.20.8 specification, section 8.7 Vector Relational Functions](http://www.opengl.org/registry/doc/GLSLangSpec.4.20.8.pdf)
        |$append""")

    val VecID = vec + id
    val VecBool = "${vec}bool"
    val `xyzw Bool` = xyzwJoint { "$it: Boolean" }
    val xyzw = xyzwJoint()
    val XYZW = XyzwJoint()
    val `a,xyzw` = xyzwJoint { "a.$it" }
    val `aXYZW type` = XyzwJoint { "a$it: $type" }
    val aXYZW = XyzwJoint { "a$it" }
    val `v,xyzw` = xyzwJoint { "v.$it" }
    val `xyzw type` = xyzwJoint { "$it: $type" }
    val `b,xyzw` = xyzwJoint { "b.$it" }
    val bXYZW = XyzwJoint { "b$it" }
    val `bXYZW type` = XyzwJoint { "b$it: $type" }

    for ((func, sign) in listOf("lessThan" to "<", "lessThanEqual" to "<=", "greaterThan" to ">", "greaterThanEqual" to ">=",
                                "equal" to "==", "notEqual" to "!=")) {
        if (type == "Boolean" && "equal" !in func)
            continue
        fun doc(x: String = "this", y: String = "b") = rel("Returns the component-wise comparison result of `$x $sign $y`.", func)
        when (part) {
            Generator.Part.Class -> {
                doc()
                +"infix fun $func(b: $VecID): $VecBool = $func(b, $VecBool())"
                doc()
                +"fun $func(b: $VecID, res: $VecBool): $VecBool = $func($`b,xyzw`, res)"
                doc(y = "b[$XYZW]")
                +"fun $func($`bXYZW type`, res: $VecBool = $VecBool()): $VecBool = $func($xyzw, $bXYZW) { $xyzw -> res($xyzw) }"
                doc()
                +"""
                    inline fun <R> $func(b: $VecID, res: ($`xyzw Bool`) -> R): R {
                        $contract
                        return $func($`b,xyzw`, res)
                    }"""
                doc(y = "b[$XYZW]")
                +"""
                    inline fun <R> $func($`bXYZW type`, res: ($`xyzw Bool`) -> R): R {
                        $contract
                        return $func($xyzw, $bXYZW, res) 
                    }"""
                if (func == "equal" || func == "notEqual") {
                    val fn = if (func[0] == 'e') "allEqual" else "anyNotEqual"
                    val op = fn.take(3)
                    +"fun $fn(b: $VecID): Boolean = $fn($`b,xyzw`)"
                    +"fun $fn($`bXYZW type`): Boolean = $func($bXYZW) { $xyzw -> Vec${ordinal}bool.$op($xyzw) }"
                }
            }
            Generator.Part.CompanionObject -> {
                doc("a")
                +"""
                    inline fun <R> $func(a: $VecID, b: $VecID, res: ($`xyzw Bool`) -> R): R {
                        $contract
                        return $func($`a,xyzw`, $`b,xyzw`, res)
                    }"""
                doc("a[$XYZW]")
                val `a rel b` = XyzwJoint { "a$it $sign b$it" }
                +"""
                    inline fun <R> $func($`aXYZW type`, $`bXYZW type`, res: ($`xyzw Bool`) -> R): R {
                        $contract
                        return res($`a rel b`)
                    }"""
                if (func == "equal" || func == "notEqual") {
                    val fn = if (func[0] == 'e') "allEqual" else "anyNotEqual"
                    val op = fn.take(3)
                    +"fun $fn(a: $VecID, b: $VecID): Boolean = $fn($`a,xyzw`, $`b,xyzw`)"
                    +"fun $fn($`aXYZW type`, $`bXYZW type`): Boolean = $func($aXYZW, $bXYZW) { $xyzw -> Vec${ordinal}bool.$op($xyzw) }"
                }
            }
            else -> Unit
        }
    }

    if (type == "Boolean") {

        for ((func, sign) in listOf("any" to "||", "all" to "&&")) {
            fun doc(x: String = "this") = rel("Returns `true` if $func component of `$x` is `true`.", func)
            when (part) {
                Generator.Part.Class -> {
                    doc()
                    +"fun $func(): Boolean = $func(this)"
                }
                Generator.Part.CompanionObject -> {
                    doc("v")
                    +"fun $func(v: $VecBool): Boolean = $func($`v,xyzw`)"
                    doc("[$xyzw]")
                    val `xyzw rel` = xyzwJoint(separator = " $sign ")
                    +"fun $func($`xyzw type`): Boolean = $`xyzw rel`"
                }
                else -> Unit
            }
        }

        fun not(x: String = "this") = rel("Returns the component-wise logical complement of `!$x`.", "not")
        when (part) {
            Generator.Part.Class -> {
                not()
                +"fun notAssign(): $VecBool = not(this)"
                not()
                +"fun not(res: $VecBool = $VecBool()): $VecBool = not(this) { $xyzw -> res($xyzw) }"
                not()
                +"""
                    inline fun <R> not(res: ($`xyzw Bool`) -> R): R {
                        $contract
                        return not($xyzw, res)
                    }"""
            }
            Generator.Part.CompanionObject -> {
                not("v")
                +"""
                    inline fun <R> not(v: $VecBool, res: ($`xyzw Bool`) -> R): R {
                        $contract
                        return not($`v,xyzw`, res)
                    }"""
                not("[$xyzw]")
                val `!xyzw` = xyzwJoint { "!$it" }
                +"""
                    inline fun <R> not($`xyzw type`, res: ($`xyzw Bool`) -> R): R {
                        $contract
                        return res($`!xyzw`)
                    }"""
            }
            else -> Unit
        }
    }
}