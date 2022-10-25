package glm_.quat

import glm_.WxyzJoint
import glm_.gen.Generator
import glm_.wxyzJoint
import glm_.xyzwJoint

fun Generator.quatRelational(type: String, extension: String, conversion: String, id: String, part: Generator.Part) {

    imports += listOf(
        "glm_.vec4.Vec4bool",
        "glm_.ext.equal",
        "glm_.ext.notEqual",
                     )

    val `wxyz Bool` = wxyzJoint { "$it: Boolean" }
    val xyzw = xyzwJoint(4)
    val wxyz = wxyzJoint()
    val `q,wxyz` = wxyzJoint { "q.$it" }
    val `qWxyz type` = WxyzJoint { "q$it: $type" }
    val `p,wxyz` = wxyzJoint { "p.$it" }
    val `pWxyz type` = WxyzJoint { "p$it: $type" }
    val pWxyz = WxyzJoint { "p$it" }

    for ((func, sign) in listOf("equal" to "==", "notEqual" to "!=")) {

        fun equal(x: String = "this", y: String = "p") = docs("Returns the component-wise comparison of result `$x $sign $y`.")
        when (part) {
            Generator.Part.Class -> {
                equal()
                +"fun $func(p: Quat$id, res: Vec4bool = Vec4bool()): Vec4bool = $func($`p,wxyz`, res)"
                equal()
                +"""
                    inline fun <R> $func(p: Quat$id, res: ($`wxyz Bool`) -> R): R {
                        $contract
                        return $func($`p,wxyz`, res)
                    }"""
                equal(y = "p[WXYZ]")
                +"fun $func($`pWxyz type`, res: Vec4bool = Vec4bool()): Vec4bool = $func($wxyz, $pWxyz) { $xyzw -> res($xyzw) }"
                equal(y = "p[WXYZ]")
                +"""
                    inline fun <R> $func($`pWxyz type`, res: ($`wxyz Bool`) -> R): R {
                        $contract
                        return $func($wxyz, $pWxyz, res)
                    }"""
            }
            Generator.Part.CompanionObject -> {
                equal("q.[wxyz]", "p.[wxyz")
                +"""
                    inline fun <R> $func(q: Quat$id, p: Quat$id, res: ($`wxyz Bool`) -> R): R {
                        $contract
                        return $func($`q,wxyz`, $`p,wxyz`, res)             
                    }"""
                val `qWxyz func pWxyz` = WxyzJoint { "q$it $sign p$it" }
                equal("q[WXYZ]", "p[WXYZ]")
                +"""
                    inline fun <R> $func($`qWxyz type`, $`pWxyz type`, res: ($`wxyz Bool`) -> R): R {
                        $contract
                        return res($`qWxyz func pWxyz`)
                    }"""
            }
            else -> Unit
        }

        val sign = if (func == "equal") "<=" else ">"
        fun equal2(x: String = "this", y: String = "r") = docs("Returns the component-wise comparison of `|$x - $y| $sign epsilon`.")
        when (part) {
            Generator.Part.Class -> {
                equal2()
                +"fun $func(p: Quat$id, epsilon: $type, res: Vec4bool = Vec4bool()): Vec4bool = $func($`p,wxyz`, epsilon, res)"
                equal2()
                +"""
                    inline fun <R> $func(p: Quat$id, epsilon: $type, res: ($`wxyz Bool`) -> R): R {
                        $contract
                        return $func($`p,wxyz`, epsilon, res)
                    }"""
                equal2(y = "p[WXYZ]")
                +"fun $func($`pWxyz type`, epsilon: $type, res: Vec4bool = Vec4bool()): Vec4bool = $func($wxyz, $pWxyz, epsilon) { $xyzw -> res($xyzw) }"
                equal2(y = "p[WXYZ]")
                +"""
                    inline fun <R> $func($`pWxyz type`, epsilon: $type, res: ($`wxyz Bool`) -> R): R {
                        $contract
                        return $func($wxyz, $pWxyz, epsilon, res)
                    }"""
            }
            Generator.Part.CompanionObject -> {
                equal2("q.[wxyz]", "p.[wxyz")
                +"""
                    inline fun <R> $func(q: Quat$id, p: Quat$id, epsilon: $type, res: ($`wxyz Bool`) -> R): R {
                        $contract
                        return $func($`q,wxyz`, $`p,wxyz`, epsilon, res)
                    }"""
                val `qWxyz func pWxyz` = WxyzJoint { "q$it.$func(p$it, epsilon)" }
                equal2("q[WXYZ]", "p[WXYZ]")
                +"""
                    inline fun <R> $func($`qWxyz type`, $`pWxyz type`, epsilon: $type, res: ($`wxyz Bool`) -> R): R {
                        $contract
                        return res($`qWxyz func pWxyz`)
                    }"""
            }
            else -> Unit
        }
    }
}