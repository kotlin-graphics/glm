package glm_.ext

import glm_.XyzwJoint
import glm_.floatingPointTypes
import glm_.gen.Generator
import glm_.xyzwJoint

fun Generator.extVectorRelational(ordinal: Int, type: String, extension: String, id: String, vec: String, part: Generator.Part) {

    val VecID = vec + id
    val VecBool = "Vec${ordinal}bool"

        imports += listOf("glm_.scalar.abs",)
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
        when (part) {
            Generator.Part.Class -> {
                doc1()
                +"fun $func(v: $VecID, epsilon: $type, res: $VecBool = $VecBool()): $VecBool = $func($`v,xyzw`, epsilon, res)"
                doc1(y = "v.[$xyzw]")
                +"fun $func($`vXyzw type`, epsilon: $type, res: $VecBool = $VecBool()): $VecBool = Companion.$func($xyzw, $vXyzw, $epsilonJoint) { $`xyzw Boolean` -> res($xyzw) }"

                // allEqual, anyNotEqual
//                val quant = if (func == "equal") "all" else "any"
//                doc1(y = "v.[$xyzw]")
//                +"fun $func(v: $VecID, epsilon: $type): $VecBool = Companion.$func($xyzw, $vXyzw, $epsilonJoint) { $`xyzw Boolean` -> res($xyzw) }"
            }
            Generator.Part.CompanionObject -> {
                doc1("a", "b")
                +"""
                    inline fun <R> $func(a: $VecID, b: $VecID, epsilon: $type, res: ($`xyzw Boolean`) -> R): R{
                        $contract
                        return $func(a, $`b,xyzw`, epsilon, res)
                    }"""
                doc1("a", "b[$XYZW]")
                +"""
                    inline fun <R> $func(a: $VecID, $`bXyzw type`, epsilon: $type, res: ($`xyzw Boolean`) -> R): R{
                        $contract
                        return $func($`a,xyzw`, $bXyzw, $epsilonJoint, res)
                    }"""
                if (ordinal > 1) {
                    doc1("a[$XYZW]", "b[$XYZW]")
                    +"""
                        inline fun <R> $func($`aXyzw type`, $`bXyzw type`, epsilon: $type, res: ($`xyzw Boolean`) -> R): R{
                            $contract
                            return $func($aXyzw, $bXyzw, $epsilonJoint, res)
                        }"""
                }
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
                +"fun $func($`vXyzw type`, epsilon: $VecID, res: $VecBool = $VecBool()): $VecBool = Companion.$func($xyzw, $vXyzw, $`epsilon,xyzw`) { $`xyzw Boolean` -> res($xyzw) }"
            }
            Generator.Part.CompanionObject -> {
                doc2("a", "b", "epsilon")
                +"""
                    inline fun <R> $func(a: $VecID, b: $VecID, epsilon: $VecID, res: ($`xyzw Boolean`) -> R): R{
                        $contract
                        return $func(a, $`b,xyzw`, epsilon, res)
                    }"""
                doc2("a", "b[$XYZW]", "epsilon.[$xyzw]")
                    +"""
                    inline fun <R> $func(a: $VecID, $`bXyzw type`, epsilon: $VecID, res: ($`xyzw Boolean`) -> R): R{
                        $contract
                        return $func($`a,xyzw`, $bXyzw, $`epsilon,xyzw`, res)
                    }"""
                doc2("a[$XYZW]", "b[$XYZW]", "epsilon.[$xyzw]")
                val `aXyzw $func bXyzw` = XyzwJoint { "a$it.$func(b$it, epsilon$it)" }
                    +"""
                    inline fun <R> $func($`aXyzw type`, $`bXyzw type`, $`epsilonXyzw type`, res: ($`xyzw Boolean`) -> R): R{
                        $contract
                        return res($`aXyzw $func bXyzw`)
                    }"""
            }
            else -> Unit
        }

        // ulps Int
        val ulpsJoint = xyzwJoint { "ulps" }
        val `ulps,xyzw` = xyzwJoint { "ulps.$it" }
        val `ulpsXyzw Int` = XyzwJoint { "ulps$it: Int" }

        fun doc3() = docs("""
            |Returns the component-wise comparison between two vectors in term of ULPs.
            |True if this expression is$maybeNot satisfied.""")
        when (part) {
            Generator.Part.Class -> {
                doc3()
                +"fun $func(v: $VecID, ulps: Int, res: $VecBool = $VecBool()): $VecBool = $func($`v,xyzw`, ulps, res)"
                doc3()
                +"fun $func($`vXyzw type`, ulps: Int, res: $VecBool = $VecBool()): $VecBool = Companion.$func($xyzw, $vXyzw, $ulpsJoint) { $`xyzw Boolean` -> res($xyzw) }"
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
                if(ordinal > 1) {
                    doc3()
                    +"""
                        inline fun <R> $func($`aXyzw type`, $`bXyzw type`, ulps: Int, res: ($`xyzw Boolean`) -> R): R{
                            $contract
                            return $func($aXyzw, $bXyzw, $ulpsJoint, res)
                        }"""
                }
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
                +"fun $func($`vXyzw type`, ulps: $VecInt, res: $VecBool = $VecBool()): $VecBool = Companion.$func($xyzw, $vXyzw, $`ulps,xyzw`) { $`xyzw Boolean` -> res($xyzw) }"
            }
            Generator.Part.CompanionObject -> {
                doc3()
                +"""
                    inline fun <R> $func(a: $VecID, b: $VecID, ulps: $VecInt, res: ($`xyzw Boolean`) -> R): R{
                        $contract
                        return $func(a, $`b,xyzw`, ulps, res)
                    }"""
                doc3()
                +"""
                    inline fun <R> $func(a: $VecID, $`bXyzw type`, ulps: $VecInt, res: ($`xyzw Boolean`) -> R): R{
                        $contract
                        return $func($`a,xyzw`, $bXyzw, $`ulps,xyzw`, res)
                    }"""
                doc3()
                val `aXyzw $func bXyzw` = XyzwJoint { "a$it.$func(b$it, ulps$it)" }
                +"""
                    inline fun <R> $func($`aXyzw type`, $`bXyzw type`, $`ulpsXyzw Int`, res: ($`xyzw Boolean`) -> R): R{
                        $contract
                        return res($`aXyzw $func bXyzw`)
                    }"""
            }
            else -> Unit
        }
    }
}