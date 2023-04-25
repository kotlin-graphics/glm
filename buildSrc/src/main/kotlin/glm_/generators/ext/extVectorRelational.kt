package glm_.generators.ext

import glm_.generators.Type
import glm_.generators.XyzwJoint
import glm_.generators.floatingPointTypes
import glm_.generators.gen.Generator
import glm_.generators.xyzwJoint

fun Generator.extVectorRelational(ordinal: Int, type: Type, vec: String, part: Generator.Part) {

    +"// ext vector relational\n"

    val VecID = vec + type.id
    val VecBool = "Vec${ordinal}${Type.Boolean.id}"

    imports += listOf("glm_.scalar.abs")
    //                          "glm_.scalar.cos",
    //                          "glm_.detail.GlmCoordinateSystem",
    //                          "glm_.detail.GLM_COORDINATE_SYSTEM")
    //    val `0` = type.`0`
    //    val `1` = type.`1`

    val `aXyzw type` = XyzwJoint { "a$it: $type" }
    val aXyzw = XyzwJoint { "a$it" }
    val `a,xyzw` = xyzwJoint { "a.$it" }
    val `bXyzw type` = XyzwJoint { "b$it: $type" }
    val bXyzw = XyzwJoint { "b$it" }
    val `b,xyzw` = xyzwJoint { "b.$it" }
    val `vXyzw type` = XyzwJoint { "v$it: $type" }
    val vXyzw = XyzwJoint { "v$it" }
    val `v,xyzw` = xyzwJoint { "v.$it" }
    val `xyzw Boolean` = xyzwJoint { "$it: Boolean" }
    val xyzw = xyzwJoint()
    val XYZW = XyzwJoint()
    val epsilonJoint = xyzwJoint { "epsilon" }
    val `epsilonXyzw type` = XyzwJoint { "epsilon$it: $type" }
    val epsilonXyzw = XyzwJoint { "epsilon$it" }
    val `epsilon,xyzw` = xyzwJoint { "epsilon.$it" }

    if (type !in floatingPointTypes)
        return

    for ((func, sign) in listOf("equal" to "<=", "notEqual" to ">")) {

        // epsilon $type
        var eps = "epsilon"
        val maybeNot = if (func.startsWith("not")) " not" else ""
        fun doc1(x: String = "this", y: String = "v", epsilon: String = eps) = docs("""
            |Returns the component-wise comparison of `|$x - $y| $sign $epsilon`.
            |True if this expression is$maybeNot satisfied.""")

        val fn = if (func == "equal") "allEqual" else "anyNotEqual"
        val op = fn.take(3)
        when (part) {
            Generator.Part.Class -> {
                doc1()
                +"fun $func(v: $VecID, epsilon: $type, res: $VecBool = $VecBool()): $VecBool = $func($`v,xyzw`, epsilon, res)"
                doc1(y = "v.[$xyzw]")
                +"fun $func($`vXyzw type`, epsilon: $type, res: $VecBool = $VecBool()): $VecBool = Companion.$func($xyzw, $vXyzw, epsilon) { $xyzw -> res($xyzw) }"

                // allEqual, anyNotEqual
                +"fun $fn(v: $VecID, epsilon: $type): Boolean = $fn($`v,xyzw`, epsilon)"
                +"fun $fn($`vXyzw type`, epsilon: $type): Boolean = Companion.$func($xyzw, $vXyzw, epsilon) { $xyzw -> Vec${ordinal}bool.$op($xyzw) }"
            }
            Generator.Part.CompanionObject -> {
                doc1("a", "b")
                +"""
                    inline fun <R> $func(a: $VecID, b: $VecID, epsilon: $type, res: ($`xyzw Boolean`) -> R): R {
                        $contract
                        return $func(a, $`b,xyzw`, epsilon, res)
                    }"""
                doc1("a", "b[$XYZW]")
                +"""
                    inline fun <R> $func(a: $VecID, $`bXyzw type`, epsilon: $type, res: ($`xyzw Boolean`) -> R): R {
                        $contract
                        return $func($`a,xyzw`, $bXyzw, epsilon, res)
                    }"""
                if (ordinal > 1) {
                    doc1("a[$XYZW]", "b[$XYZW]")
                    +"""
                        inline fun <R> $func($`aXyzw type`, $`bXyzw type`, epsilon: $type, res: ($`xyzw Boolean`) -> R): R {
                            $contract
                            return $func($aXyzw, $bXyzw, $epsilonJoint, res)
                        }"""
                }
                // allEqual, anyNotEqual
                +"fun $fn(a: $VecID, b: $VecID, epsilon: $type): Boolean = $fn($`a,xyzw`, $`b,xyzw`, epsilon)"
                +"fun $fn(a: $VecID, $`bXyzw type`, epsilon: $type): Boolean = $fn($`a,xyzw`, $bXyzw, epsilon)"
                if (ordinal > 1)
                    +"fun $fn($`aXyzw type`, $`bXyzw type`, epsilon: $type): Boolean = $func($aXyzw, $bXyzw, $epsilonJoint) { $xyzw -> Vec${ordinal}bool.$op($xyzw) }"
            }
            else -> Unit
        }

        // epsilon $VecId
        eps = "epsilon.[$xyzw]"
        fun doc2(x: String = "this", y: String = "v", epsilon: String = "eps.[$xyzw]") = docs("""
            |Returns the component-wise comparison of `|$x - $y| $sign $epsilon`.
            |True if this expression is$maybeNot satisfied.""")
        when (part) {
            Generator.Part.Class -> {
                doc2()
                +"fun $func(v: $VecID, epsilon: $VecID, res: $VecBool = $VecBool()): $VecBool = $func($`v,xyzw`, epsilon, res)"
                doc2(y = "v.[$xyzw]")
                +"fun $func($`vXyzw type`, epsilon: $VecID, res: $VecBool = $VecBool()): $VecBool = $func($vXyzw, $`epsilon,xyzw`, res)"
                if (ordinal > 1) {
                    doc2(y = "v.[$xyzw]")
                    +"fun $func($`vXyzw type`, $`epsilonXyzw type`, res: $VecBool = $VecBool()): $VecBool = Companion.$func($xyzw, $vXyzw, $epsilonXyzw) { $xyzw -> res($xyzw) }"
                }
                +"fun $fn(v: $VecID, epsilon: $VecID): Boolean = $fn($`v,xyzw`, epsilon)"
                +"fun $fn($`vXyzw type`, epsilon: $VecID): Boolean = $fn($xyzw, $vXyzw, $`epsilon,xyzw`)"
                if (ordinal > 1)
                    +"fun $fn($`vXyzw type`, $`epsilonXyzw type`): Boolean = Companion.$func($xyzw, $vXyzw, $epsilonXyzw) { $xyzw -> Vec${ordinal}bool.$op($xyzw) }"
            }
            Generator.Part.CompanionObject -> {
                doc2("a", "b", "epsilon")
                +"""
                    inline fun <R> $func(a: $VecID, b: $VecID, epsilon: $VecID, res: ($`xyzw Boolean`) -> R): R {
                        $contract
                        return $func(a, $`b,xyzw`, epsilon, res)
                    }"""
                doc2("a", "b[$XYZW]", "epsilon.[$xyzw]")
                +"""
                    inline fun <R> $func(a: $VecID, $`bXyzw type`, epsilon: $VecID, res: ($`xyzw Boolean`) -> R): R {
                        $contract
                        return $func($`a,xyzw`, $bXyzw, $`epsilon,xyzw`, res)
                    }"""
                doc2("a[$XYZW]", "b[$XYZW]", "epsilon.[$xyzw]")
                val `aXyzw $func bXyzw` = XyzwJoint { "a$it.$func(b$it, epsilon$it)" }
                +"""
                    inline fun <R> $func($`aXyzw type`, $`bXyzw type`, $`epsilonXyzw type`, res: ($`xyzw Boolean`) -> R): R {
                        $contract
                        return res($`aXyzw $func bXyzw`)
                    }"""

                // allEqual, anyNotEqual
                +"fun $fn(a: $VecID, b: $VecID, epsilon: $VecID): Boolean = $fn($`a,xyzw`, $`b,xyzw`, $`epsilon,xyzw`)"
                +"fun $fn(a: $VecID, $`bXyzw type`, epsilon: $VecID): Boolean = $fn($`a,xyzw`, $bXyzw, $`epsilon,xyzw`)"
                if (ordinal > 1)
                    +"fun $fn(a: $VecID, $`bXyzw type`, $`epsilonXyzw type`): Boolean = $fn($`a,xyzw`, $bXyzw, $epsilonXyzw)"
                +"fun $fn($`aXyzw type`, $`bXyzw type`, $`epsilonXyzw type`): Boolean = $func($aXyzw, $bXyzw, $epsilonXyzw) { $xyzw -> Vec${ordinal}bool.$op($xyzw) }"
            }
            else -> Unit
        }

        // ulps Int
        val ulpsJoint = xyzwJoint { "ulps" }
        val `ulps,xyzw` = xyzwJoint { "ulps.$it" }
        val `ulpsXyzw Int` = XyzwJoint { "ulps$it: Int" }
        val ulpsXyzw = XyzwJoint { "ulps$it" }

        fun doc3() = docs("""
            |Returns the component-wise comparison between two vectors in term of ULPs.
            |True if this expression is$maybeNot satisfied.""")
        when (part) {
            Generator.Part.Class -> {
                doc3()
                +"fun $func(v: $VecID, ulps: Int, res: $VecBool = $VecBool()): $VecBool = $func($`v,xyzw`, ulps, res)"
                doc3()
                +"fun $func($`vXyzw type`, ulps: Int, res: $VecBool = $VecBool()): $VecBool = Companion.$func($xyzw, $vXyzw, $ulpsJoint) { $xyzw -> res($xyzw) }"

                +"fun $fn(v: $VecID, ulps: Int): Boolean = $fn($`v,xyzw`, ulps)"
                +"fun $fn($`vXyzw type`, ulps: Int): Boolean = $fn($vXyzw, $ulpsJoint)"
            }
            Generator.Part.CompanionObject -> {
                doc3()
                +"""
                    inline fun <R> $func(a: $VecID, b: $VecID, ulps: Int, res: ($`xyzw Boolean`) -> R): R{
                        $contract
                        return $func(a, $`b,xyzw`, ulps, res)
                    }"""
                doc3()
                +"""
                    inline fun <R> $func(a: $VecID, $`bXyzw type`, ulps: Int, res: ($`xyzw Boolean`) -> R): R{
                        $contract
                        return $func($`a,xyzw`, $bXyzw, $ulpsJoint, res)
                    }"""
                if (ordinal > 1) {
                    doc3()
                    +"""
                        inline fun <R> $func($`aXyzw type`, $`bXyzw type`, ulps: Int, res: ($`xyzw Boolean`) -> R): R{
                            $contract
                            return $func($aXyzw, $bXyzw, $ulpsJoint, res)
                        }"""
                }

                +"fun $fn(a: $VecID, b: $VecID, ulps: Int): Boolean = $fn(a, $`b,xyzw`, ulps)"
                +"fun $fn(a: $VecID, $`bXyzw type`, ulps: Int): Boolean = $fn($`a,xyzw`, $bXyzw, $ulpsJoint)"
                if (ordinal > 1)
                    +"fun $fn($`aXyzw type`, $`bXyzw type`, ulps: Int): Boolean = $fn($aXyzw, $bXyzw, $ulpsJoint)"
            }
            else -> Unit
        }

        // ulps $VecInt
        val VecInt = "Vec${ordinal}i"
        when (part) {
            Generator.Part.Class -> {
                doc3()
                +"fun $func(v: $VecID, ulps: $VecInt, res: $VecBool = $VecBool()): $VecBool = $func($`v,xyzw`, ulps, res)"
                doc3()
                +"fun $func($`vXyzw type`, ulps: $VecInt, res: $VecBool = $VecBool()): $VecBool = $func($vXyzw, $`ulps,xyzw`, res)"
                if (ordinal > 1) {
                    doc3()
                    +"fun $func($`vXyzw type`, $`ulpsXyzw Int`, res: $VecBool = $VecBool()): $VecBool = Companion.$func($xyzw, $vXyzw, $ulpsXyzw) { $xyzw -> res($xyzw) }"
                }
                +"fun $fn(v: $VecID, ulps: $VecInt): Boolean = $fn($`v,xyzw`, ulps)"
                +"fun $fn($`vXyzw type`, ulps: $VecInt): Boolean = $fn($xyzw, $vXyzw, $`ulps,xyzw`)"
                if (ordinal > 1)
                    +"fun $fn($`vXyzw type`, $`ulpsXyzw Int`): Boolean = Companion.$func($xyzw, $vXyzw, $ulpsXyzw) { $xyzw -> Vec${ordinal}bool.$op($xyzw) }"
            }
            Generator.Part.CompanionObject -> {
                doc3()
                +"""
                    inline fun <R> $func(a: $VecID, b: $VecID, ulps: $VecInt, res: ($`xyzw Boolean`) -> R): R {
                        $contract
                        return $func(a, $`b,xyzw`, ulps, res)
                    }"""
                doc3()
                +"""
                    inline fun <R> $func(a: $VecID, $`bXyzw type`, ulps: $VecInt, res: ($`xyzw Boolean`) -> R): R {
                        $contract
                        return $func($`a,xyzw`, $bXyzw, $`ulps,xyzw`, res)
                    }"""
                doc3()
                val `aXyzw $func bXyzw` = XyzwJoint { "a$it.$func(b$it, ulps$it)" }
                +"""
                    inline fun <R> $func($`aXyzw type`, $`bXyzw type`, $`ulpsXyzw Int`, res: ($`xyzw Boolean`) -> R): R {
                        $contract
                        return res($`aXyzw $func bXyzw`)
                    }"""

                +"fun $fn(a: $VecID, b: $VecID, ulps: $VecInt): Boolean = $fn($`a,xyzw`, $`b,xyzw`, $`ulps,xyzw`)"
                +"fun $fn(a: $VecID, $`bXyzw type`, ulps: $VecInt): Boolean = $fn($`a,xyzw`, $bXyzw, $`ulps,xyzw`)"
                +"fun $fn($`aXyzw type`, $`bXyzw type`, $`ulpsXyzw Int`): Boolean = $func($aXyzw, $bXyzw, $ulpsXyzw) { $xyzw -> Vec${ordinal}bool.$op($xyzw) }"
            }
            else -> Unit
        }
    }
}