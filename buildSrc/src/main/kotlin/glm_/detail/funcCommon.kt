package glm_.detail

import glm_.*
import glm_.gen.Generator

// common.hpp
fun Generator.common(ordinal: Int, type: String, extension: String, id: String, vec: String, part: Generator.Part) {

    if (part != Generator.Part.Scalar) +"// common\n"

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
    val `expXYZW Int` = XyzwJoint { "exp$it: Int" }

    if (part != Generator.Part.Scalar)
        imports += "glm_.vec$ordinal.${vec}bool"

    fun glslDocs(descr: String, manPage: String, append: String = "") = docs("""
            |$descr
            |
            |[GLSL $manPage man page](http://www.opengl.org/sdk/docs/manglsl/xhtml/$manPage.xml)
            |[GLSL 4.20.8 specification, section 8.3 Common Functions](http://www.opengl.org/registry/doc/GLSLangSpec.4.20.8.pdf)
            |$append""")

    if (type !in unsignedTypes && type != "Boolean") {

        fun abs(x: String = "[$xyzw]") = glslDocs("Returns `$x` if `$x` >= 0; otherwise, it returns `-$x`.", "abs")
        when (part) {
            Generator.Part.Class -> {
                abs()
                +"fun absAssign(): $VecID = abs(this)"
                abs()
                +"fun abs(res: $VecID = $VecID()): $VecID = abs { $`resXYZW type` -> res($resXYZW) }"
                abs()
                "inline fun <R> abs(res: ($`resXYZW type`) -> R): R" {
                    +contract
                    +"return abs($xyzw, res)"
                }
            }
            Generator.Part.CompanionObject -> {
                abs("v.[$xyzw]")
                "inline fun <R> abs(v: $VecID, res: ($`resXYZW type`) -> R): R" {
                    +contract
                    +"return abs($`v,xyzw`, res)"
                }
                abs()
                "inline fun <R> abs($`xyzw type`, res: ($`resXYZW type`) -> R): R" {
                    +contract
                    +"return res(${xyzwJoint { "$it.abs()" }})"
                }
            }
            Generator.Part.Scalar -> {
                abs("this")
                // TODO this should be JVM only
                val maybeToInt = if (type in intPromotedTypes) "toInt()" else "this"
                val maybeBack = if (type in intPromotedTypes) ".to$type()" else ""
                +"inline fun $type.abs(): $type = abs($maybeToInt)$maybeBack"
            }
        }

        if (type in floatingPointTypes) {

            fun sign(x: String = "[$xyzw]") = glslDocs("Returns `1` if `$x > 0`, `0` if `$x == 0`, or `-1` if `$x < 0`.", "sign")
            when (part) {
                Generator.Part.Class -> {
                    sign()
                    +"fun signAssign(): $VecID = sign(this)"
                    sign()
                    +"fun sign(res: $VecID = $VecID()): $VecID = sign { $`resXYZW type` -> res($resXYZW) }"
                    sign()
                    "inline fun <R> sign(res: ($`resXYZW type`) -> R): R" {
                        +contract
                        +"return sign($xyzw, res)"
                    }
                }
                Generator.Part.CompanionObject -> {
                    sign("v.[$xyzw]")
                    "inline fun <R> sign(v: $VecID, res: ($`resXYZW type`) -> R): R" {
                        +contract
                        +"return sign($`v,xyzw`, res)"
                    }
                    sign()
                    "inline fun <R> sign($`xyzw type`, res: ($`resXYZW type`) -> R): R" {
                        +contract
                        +"return res(${xyzwJoint { "$it.sign" }})"
                    }
                }
                else -> Unit // sign in stdlib
            }

            fun floor(x: String = "[$xyzw]") = glslDocs("Returns a value equal to the nearest integer that is less then or equal to `$x`.", "floor")
            when (part) {
                Generator.Part.Class -> {
                    floor()
                    +"fun floorAssign(): $VecID = floor(this)"
                    floor()
                    +"fun floor(res: $VecID = $VecID()): $VecID = floor { $`resXYZW type` -> res($resXYZW) }"
                    floor()
                    "inline fun <R> floor(res: ($`resXYZW type`) -> R): R" {
                        +contract
                        +"return floor($xyzw, res)"
                    }
                }
                Generator.Part.CompanionObject -> {
                    floor("v.[$xyzw]")
                    "inline fun <R> floor(v: $VecID, res: ($`resXYZW type`) -> R): R" {
                        +contract
                        +"return floor($`v,xyzw`, res)"
                    }
                    floor()
                    "inline fun <R> floor($`xyzw type`, res: ($`resXYZW type`) -> R): R" {
                        +contract
                        +"return res(${xyzwJoint { "$it.floor()" }})"
                    }
                }
                Generator.Part.Scalar -> {
                    floor("this")
                    +"inline fun $type.floor(): $type = floor(this)"
                }
            }

            fun trunc(x: String = "[$xyzw]") = glslDocs("Returns a value equal to the nearest integer to `$x` whose absolute value is not larger than the absolute value of `$x`.", "trunc")
            when (part) {
                Generator.Part.Class -> {
                    trunc()
                    +"fun truncAssign(): $VecID = trunc(this)"
                    trunc()
                    +"fun trunc(res: $VecID = $VecID()): $VecID = trunc { $`resXYZW type` -> res($resXYZW) }"
                    trunc()
                    "inline fun <R> trunc(res: ($`resXYZW type`) -> R): R" {
                        +contract
                        +"return trunc($xyzw, res)"
                    }
                }
                Generator.Part.CompanionObject -> {
                    trunc("v.[$xyzw]")
                    "inline fun <R> trunc(v: $VecID, res: ($`resXYZW type`) -> R): R" {
                        +contract
                        +"return trunc($`v,xyzw`, res)"
                    }
                    trunc()
                    "inline fun <R> trunc($`xyzw type`, res: ($`resXYZW type`) -> R): R" {
                        +contract
                        +"return res(${xyzwJoint { "$it.trunc()" }})"
                    }
                }
                Generator.Part.Scalar -> {
                    trunc("this")
                    +"inline fun $type.trunc(): $type = truncate(this)"
                }
            }

            fun round(x: String = "[$xyzw]") = glslDocs("""
                |Returns a value equal to the nearest integer to `$x`. The fraction 0.5 will round in a direction 
                |chosen by the implementation, presumably the direction that is fastest.
                |This includes the possibility that `round` returns the same value as `roundEven` for all values of `$x`.""", "round")
            when (part) {
                Generator.Part.Class -> {
                    round()
                    +"fun roundAssign(): $VecID = round(this)"
                    round()
                    +"fun round(res: $VecID = $VecID()): $VecID = round { $`resXYZW type` -> res($resXYZW) }"
                    round()
                    "inline fun <R> round(res: ($`resXYZW type`) -> R): R" {
                        +contract
                        +"return round($xyzw, res)"
                    }
                }
                Generator.Part.CompanionObject -> {
                    trunc("v.[$xyzw]")
                    "inline fun <R> round(v: $VecID, res: ($`resXYZW type`) -> R): R" {
                        +contract
                        +"return round($`v,xyzw`, res)"
                    }
                    trunc()
                    "inline fun <R> round($`xyzw type`, res: ($`resXYZW type`) -> R): R" {
                        +contract
                        +"return res(${xyzwJoint { "$it.round()" }})"
                    }
                }
                Generator.Part.Scalar -> {
                    round("this")
                    +"inline fun $type.round(): $type = roundTo${type.counterpart}().$extension"
                }
            }

            fun roundEven(x: String = "[$xyzw]") = glslDocs("""
                |Returns a value equal to the nearest integer to `$x`. A fractional part of 0.5 will round toward
                |the nearest even integer. (Both 3.5 and 4.5 for x will return 4.0.)""",
                                                            "roundEven",
                                                            "[New round to even technique](http://developer.amd.com/documentation/articles/pages/New-Round-to-Even-Technique.aspx)")
            when (part) {
                Generator.Part.Class -> {
                    roundEven()
                    +"fun roundEvenAssign(): $VecID = roundEven(this)"
                    roundEven()
                    +"fun roundEven(res: $VecID = $VecID()): $VecID = roundEven { $`resXYZW type` -> res($resXYZW) }"
                    roundEven()
                    "inline fun <R> roundEven(res: ($`resXYZW type`) -> R): R" {
                        +contract
                        +"return roundEven($xyzw, res)"
                    }
                }
                Generator.Part.CompanionObject -> {
                    roundEven("v.[$xyzw]")
                    "inline fun <R> roundEven(v: $VecID, res: ($`resXYZW type`) -> R): R" {
                        +contract
                        +"return roundEven($`v,xyzw`, res)"
                    }
                    roundEven()
                    "inline fun <R> roundEven($`xyzw type`, res: ($`resXYZW type`) -> R): R" {
                        +contract
                        +"return res(${xyzwJoint { "$it.roundEven()" }})"
                    }
                }
                Generator.Part.Scalar -> {
                    roundEven("this")
                    +"inline fun $type.roundEven(): $type = round(this)"
                }
            }

            fun ceil(x: String = "[$xyzw]") = glslDocs("Returns a value equal to the nearest integer that is greater than or equal to `$x`.", "ceil")
            when (part) {
                Generator.Part.Class -> {
                    ceil()
                    +"fun ceilAssign(): $VecID = ceil(this)"
                    ceil()
                    +"fun ceil(res: $VecID = $VecID()): $VecID = ceil { $`resXYZW type` -> res($resXYZW) }"
                    ceil()
                    "inline fun <R> ceil(res: ($`resXYZW type`) -> R): R" {
                        +contract
                        +"return ceil($xyzw, res)"
                    }
                }
                Generator.Part.CompanionObject -> {
                    ceil("v.[$xyzw]")
                    "inline fun <R> ceil(v: $VecID, res: ($`resXYZW type`) -> R): R" {
                        +contract
                        +"return ceil($`v,xyzw`, res)"
                    }
                    ceil()
                    "inline fun <R> ceil($`xyzw type`, res: ($`resXYZW type`) -> R): R" {
                        +contract
                        +"return res(${xyzwJoint { "$it.ceil()" }})"
                    }
                }
                Generator.Part.Scalar -> {
                    ceil("this")
                    +"inline fun $type.ceil(): $type = ceil(this)"
                }
            }

            fun fract(x: String = "[$xyzw]") = glslDocs("Return `$x - $x.floor`.", "fract")
            when (part) {
                Generator.Part.Class -> {
                    fract()
                    +"fun fractAssign(): $VecID = fract(this)"
                    fract()
                    +"fun fract(res: $VecID = $VecID()): $VecID = fract { $`resXYZW type` -> res($resXYZW) }"
                    fract()
                    "inline fun <R> fract(res: ($`resXYZW type`) -> R): R" {
                        +contract
                        +"return fract($xyzw, res)"
                    }
                }
                Generator.Part.CompanionObject -> {
                    fract("v.[$xyzw]")
                    "inline fun <R> fract(v: $VecID, res: ($`resXYZW type`) -> R): R" {
                        +contract
                        +"return fract($`v,xyzw`, res)"
                    }
                    fract()
                    "inline fun <R> fract($`xyzw type`, res: ($`resXYZW type`) -> R): R" {
                        +contract
                        +"return res(${xyzwJoint { "$it.fract()" }})"
                    }
                }
                Generator.Part.Scalar -> {
                    fract("this")
                    +"inline fun $type.fract(): $type = this - this.floor()"
                }
            }

            fun mod(x: String = "[$xyzw]", y: String = "b") = glslDocs("Modulus. Returns `$x - $y * floor($x / $y).", "mod")
            when (part) {
                Generator.Part.Class -> {
                    mod()
                    +"infix fun modAssign(b: $type): $VecID = mod(b, this)"
                    mod()
                    +"fun mod(b: $type, res: $VecID = $VecID()): $VecID = mod(b) { $`resXYZW type` -> res($resXYZW) }"
                    mod()
                    "inline fun <R> mod(b: $type, res: ($`resXYZW type`) -> R): R" {
                        +contract
                        +"return mod($xyzw, $bbbb, res)"
                    }
                    if (ordinal > 1) {
                        mod(y = "b.[$xyzw]")
                        +"fun mod(b: $VecID, res: $VecID = $VecID()): $VecID = mod(b) { $`resXYZW type` -> res($resXYZW) }"
                        mod(y = "b.[$xyzw]")
                        "inline fun <R> mod(b: $VecID, res: ($`resXYZW type`) -> R): R" {
                            +contract
                            +"return mod($xyzw, $`b,xyzw`, res)"
                        }
                        mod(y = "b[$XYZW]")
                        +"fun modAssign($`bXYZW type`): $VecID = mod($`bXYZW`, this)"
                        mod(y = "b[$XYZW]")
                        +"fun mod($`bXYZW type`, res: $VecID = $VecID()): $VecID = mod($`bXYZW`) { $`resXYZW type` -> res($resXYZW) }"
                        mod(y = "b[$XYZW]")
                        "inline fun <R> mod($`bXYZW type`, res: ($`resXYZW type`) -> R): R" {
                            +contract
                            +"return mod($xyzw, $`bXYZW`, res)"
                        }
                    }
                }
                Generator.Part.CompanionObject -> {
                    mod("a.[$xyzw]", "b.[$XYZW]")
                    "inline fun <R> mod(a: $VecID, b: $VecID, res: ($`resXYZW type`) -> R): R" {
                        +contract
                        +"return mod($`a,xyzw`, $`b,xyzw`, res)"
                    }
                    mod(y = "b[$XYZW]")
                    "inline fun <R> mod($`xyzw type`, $`bXYZW type`, res: ($`resXYZW type`) -> R): R" {
                        +contract
                        +"return res(${xyzwJoint { "$it % b${it.toUpperCase()}" }})"
                    }
                }
                else -> Unit // mod in stdlib
            }

            fun modf(x: String = "[$xyzw]") = glslDocs("Returns the fractional part of `$x` and its integer counterpart (as a whole number floating point value). Both will have the same sign as `$x.`", "modf")
            val `fResXYZW type` = XyzwJoint { "fractRes$it: $type" }
            val fResXYZW = XyzwJoint { "fractRes$it" }
            val `iResXYZW type` = XyzwJoint { "intRes$it: $type" }
            val iResXYZW = XyzwJoint { "intRes$it" }
            when (part) {
                Generator.Part.Class -> {
                    modf()
                    +"""
                        fun modf(fractRes: $VecID = $VecID(), intRes: $VecID = $VecID()) = modf($xyzw) { $`fResXYZW type`, $`iResXYZW type` ->
                            fractRes.put($fResXYZW)
                            intRes.put($iResXYZW)
                        }"""
                    modf()
                    +"""
                        fun modf(fractIntRes: Pair<$VecID, $VecID> = $VecID() to $VecID()): Pair<$VecID, $VecID> = modf { $`fResXYZW type`, $`iResXYZW type` ->
                            fractIntRes.apply {
                                first.put($fResXYZW)
                                second.put($iResXYZW)
                            }
                        }"""
                    modf()
                    +"fun <R> modf(res: ($`fResXYZW type`, $`iResXYZW type`) -> R): R = modf($xyzw, res)"
                }
                Generator.Part.CompanionObject -> {
                    modf()
                    "inline fun <R> modf($`xyzw type`, res: ($`fResXYZW type`, $`iResXYZW type`) -> R): R" {
                        xyzw { +"val int${it.toUpperCase()} = if ($it > 0) $it.floor() else $it.ceil()" }
                        val fract = xyzwJoint { "$it - int${it.toUpperCase()}" }
                        val int = XyzwJoint { "int$it" }
                        +"return res($fract, $int)"
                    }
                }
                Generator.Part.Scalar -> {
                    modf("this")
                    "inline fun $type.modf(resI: KMutableProperty0<$type>): $type" {
                        +contract("resI")
                        +"val int = if (this > 0) floor() else ceil()"
                        +"resI.set(int)"
                        +"return this - int"
                    }
                    modf("this")
                    "inline fun $type.modf(resI: ($type) -> Unit): $type" {
                        +contract("resI")
                        +"val int = if (this > 0) floor() else ceil()"
                        +"resI(int)"
                        +"return this - int"
                    }
                    modf("this")
                    "fun $type.modf(): Pair<$type, $type>" {
                        +"val int = if (this > 0) floor() else ceil()"
                        +"return (this - int) to int"
                    }
                }
            }
        }
        if (type in numberTypes) {

            fun min(x: String = "[$xyzw]", y: String = "b") = glslDocs("Returns `$y` if `$y < $x`; otherwise, it returns `$x`.", "min")
            when (part) {
                Generator.Part.Class -> {
                    // min scalar
                    min()
                    +"infix fun minAssign(b: $type): $VecID = min(b, this)"
                    min()
                    +"infix fun min(b: $type): $VecID = min(b, $VecID())"
                    min()
                    +"fun min(b: $type, res: $VecID): $VecID = min(b) { $`resXYZW type` -> res($resXYZW) }"
                    min()
                    "inline fun <R> min(b: $type, res: ($`resXYZW type`) -> R): R" {
                        +contract
                        +"return min($xyzw, $bbbb, res)"
                    }
                    // min vectorial
                    min(y = "b.[$xyzw]")
                    +"infix fun minAssign(b: $VecID): $VecID = min($`b,xyzw`, this)"
                    min(y = "b.[$xyzw]")
                    +"infix fun min(b: $VecID): $VecID = min($`b,xyzw`, $VecID())"
                    min(y = "b.[$xyzw]")
                    +"fun min(b: $VecID, res: $VecID): $VecID = min($`b,xyzw`) { $`resXYZW type` -> res($resXYZW) }"
                    min(y = "b.[$xyzw]")
                    "inline fun <R> min(b: $VecID, res: ($`resXYZW type`) -> R): R" {
                        +contract
                        +"return min($xyzw, $`b,xyzw`, res)"
                    }
                    if (ordinal > 1) {
                        min(y = "b[$XYZW]")
                        +"fun minAssign($`bXYZW type`): $VecID = min($`bXYZW`, this)"
                        min(y = "b[$XYZW]")
                        +"fun min($`bXYZW type`, res: $VecID = $VecID()): $VecID = min($`bXYZW`) { $`resXYZW type` -> res($resXYZW) }"
                        min(y = "b[$XYZW]")
                        "inline fun <R> min($`bXYZW type`, res: ($`resXYZW type`) -> R): R" {
                            +contract
                            +"return min($xyzw, $bXYZW, res)"
                        }
                    }
                }
                Generator.Part.CompanionObject -> {
                    min("v0.[$xyzw]", "v1.[$xyzw]")
                    "inline fun <R> min(v0: $VecID, v1: $VecID, res: ($`resXYZW type`) -> R): R" {
                        +contract
                        +"return min($`v0,xyzw`, $`v1,xyzw`, res)"
                    }
                    min(y = "b[$XYZW]")
                    "inline fun <R> min($`xyzw type`, $`bXYZW type`, res: ($`resXYZW type`) -> R): R" {
                        +contract
                        +"return res(${xyzwJoint { "$it min b${it.toUpperCase()}" }})"
                    }
                }
                Generator.Part.Scalar -> {
                    min("this")
                    +"inline infix fun $type.min(b: $type): $type = min(${type.promotedExtensionOrThis}, b${type.promotedExtensionOrEmpty})${type.maybePromotedBack}"
                }
            }

            fun max(x: String = "[$xyzw]", y: String = "b") = glslDocs("Returns `y` if `$x < $y`; otherwise, it returns `$x`.", "max")
            when (part) {
                Generator.Part.Class -> {
                    max()
                    +"infix fun maxAssign(b: $type): $VecID = max(b, this)"
                    max()
                    +"infix fun max(b: $type): $VecID = max(b, $VecID())"
                    max()
                    +"fun max(b: $type, res: $VecID): $VecID = max(b) { $`resXYZW type` -> res($resXYZW) }"
                    max()
                    "inline fun <R> max(b: $type, res: ($`resXYZW type`) -> R): R" {
                        +contract
                        +"return max($xyzw, $bbbb, res)"
                    }
                    // max vectorial
                    max(y = "b.[$xyzw]")
                    +"infix fun maxAssign(b: $VecID): $VecID = max($`b,xyzw`, this)"
                    max(y = "b.[$xyzw]")
                    +"infix fun max(b: $VecID): $VecID = max(b, $VecID())"
                    max(y = "b.[$xyzw]")
                    +"fun max(b: $VecID, res: $VecID): $VecID = max(b) { $`resXYZW type` -> res($resXYZW) }"
                    max(y = "b.[$xyzw]")
                    "inline fun <R> max(b: $VecID, res: ($`resXYZW type`) -> R): R" {
                        +contract
                        +"return max($xyzw, $`b,xyzw`, res)"
                    }
                    if (ordinal > 1) {
                        max(y = "b[$XYZW]")
                        +"fun maxAssign($`bXYZW type`): $VecID = max($`bXYZW`, this)"
                        max(y = "b[$XYZW]")
                        +"fun max($`bXYZW type`, res: $VecID = $VecID()): $VecID = max($`bXYZW`) { $`resXYZW type` -> res($resXYZW) }"
                        max(y = "b[$XYZW]")
                        "inline fun <R> max($`bXYZW type`, res: ($`resXYZW type`) -> R): R" {
                            +contract
                            +"return max($xyzw, $bXYZW, res)"
                        }
                    }
                }
                Generator.Part.CompanionObject -> {
                    max(y = "b[$XYZW]")
                    "inline fun <R> max(v0: $VecID, v1: $VecID, res: ($`resXYZW type`) -> R): R" {
                        +contract
                        +"return max($`v0,xyzw`, $`v1,xyzw`, res)"
                    }
                    max(y = "b[$XYZW]")
                    "inline fun <R> max($`xyzw type`, $`bXYZW type`, res: ($`resXYZW type`) -> R): R" {
                        +contract
                        +"return res(${xyzwJoint { "$it max b${it.toUpperCase()}" }})"
                    }
                }
                Generator.Part.Scalar -> {
                    max("this")
                    +"inline infix fun $type.max(b: $type): $type = max(${type.promotedExtensionOrThis}, b${type.promotedExtensionOrEmpty})${type.maybePromotedBack}"
                }
            }

            fun clamp(x: String = "[$xyzw]", minVal: String = "minVal", maxVal: String = "maxVal") = glslDocs("Returns `($x max $minVal) min $maxVal`.", "clamp")
            when (part) {
                Generator.Part.Class -> {
                    clamp()
                    +"fun clampAssign(minVal: $type, maxVal: $type): $VecID = clamp(minVal, maxVal, this)"
                    clamp()
                    +"fun clamp(minVal: $type, maxVal: $type, res: $VecID = $VecID()): $VecID = clamp(minVal, maxVal) { $`resXYZW type` -> res($resXYZW) }"
                    clamp()
                    "inline fun <R> clamp(minVal: $type, maxVal: $type, res: ($`resXYZW type`) -> R): R" {
                        +contract
                        +"return clamp($xyzw, $minValJoint, $maxValJoint, res)"
                    }
                }
                Generator.Part.CompanionObject -> {
                    clamp(minVal = "minVal[$XYZW]", maxVal = "maxVal[$XYZW]")
                    "inline fun <R> clamp(v: $VecID, minVal: $VecID, maxVal: $VecID, res: ($`resXYZW type`) -> R): R" {
                        +contract
                        +"return clamp($`v,xyzw`, $`minVal,xyzw`, $`maxVal,xyzw`, res)"
                    }
                    clamp(minVal = "minVal[$XYZW]", maxVal = "maxVal[$XYZW]")
                    "inline fun <R> clamp($`xyzw type`, $`minValXYZW type`, $`maxValXYZW type`, res: ($`resXYZW type`) -> R): R" {
                        +contract
                        +"return res(${xyzwJoint { "$it.clamp(minVal${it.toUpperCase()}, maxVal${it.toUpperCase()})" }})"
                    }
                }
                Generator.Part.Scalar -> {
                    clamp("")
                    +"inline fun $type.clamp(minVal: $type, maxVal: $type): $type = max(minVal) min maxVal"
                    if (type == "Int" || type == "Long") {
                        clamp()
                        +"inline infix fun $type.clamp(range: ${type}Range): $type = max(range.first) min range.last"
                    }
                }
            }
        }
        if (type in floatingPointTypes) {

            fun mix(x: String = "[$xyzw]", y: String = "b.[$xyzw]", a: String = "c") = glslDocs("""
                |If `$a` is a floating scalar or vector: Returns `$x * (1.0 - $a) + $y * $a`, i.e., the linear blend of `$x` and `$y` using the floating-point value `$a`.
                |The value for `$a` is not restricted to the range `[0, 1]`. If `$a` is a boolean scalar or vector: Selects which vector each returned component comes from.
                |For a component of `$a` that is false, the corresponding component of `$x` is returned. For a component of `$a` that is true, the corresponding component of `$y` is returned.
                |Components of `$x` and `$y` that are not selected are allowed to be invalid floating point values and will have no effect on the results.
                |Thus, this provides different functionality than `genType mix(genType x, genType y, genType(a))` where `a` is a Boolean vector.
                |@param x: Value to interpolate.
                |@param y: Value to interpolate.
                |@param a: Interpolant.""", "min")
            when (part) {
                Generator.Part.Class -> {
                    // mix scalar same float type
                    mix()
                    +"fun mixAssign(b: $VecID, c: $type): $VecID = mix(b, c, this)"
                    mix()
                    +"fun mix(b: $VecID, c: $type, res: $VecID = $VecID()): $VecID = mix(b, c) { $`resXYZW type` -> res($resXYZW) }"
                    mix()
                    "inline fun <R> mix(b: $VecID, c: $type, res: ($`resXYZW type`) -> R): R" {
                        +contract
                        +"return mix($xyzw, $`b,xyzw`, c, res)"
                    }
                    // mix scalar other float type
                    mix()
                    +"fun mixAssign(b: $VecID, c: $otherFloatType): $VecID = mix(b, c.$extension, this)"
                    mix()
                    +"fun mix(b: $VecID, c: $otherFloatType, res: $VecID = $VecID()): $VecID = mix(b, c.$extension) { $`resXYZW type` -> res($resXYZW) }"
                    mix()
                    +"inline fun <R> mix(b: $VecID, c: $otherFloatType, res: ($`resXYZW type`) -> R): R = mix(b, c.$extension, res)"
                    // mix scalar boolean
                    mix()
                    +"fun mixAssign(b: $VecID, c: Boolean): $VecID = mix(b, c, this)"
                    mix()
                    +"fun mix(b: $VecID, c: Boolean, res: $VecID = $VecID()): $VecID = mix(b, c) { $`resXYZW type` -> res($resXYZW) }"
                    mix()
                    "inline fun <R> mix(b: $VecID, c: Boolean, res: ($`resXYZW type`) -> R): R" {
                        +contract
                        +"return mix($xyzw, $`b,xyzw`, c, res)"
                    }
                    // mix vectorial same float type
                    mix(a = "c.[$xyzw]")
                    +"fun mixAssign(b: $VecID, c: $VecID): $VecID = mix(b, c, this)"
                    mix(a = "c.[$xyzw]")
                    +"fun mix(b: $VecID, c: $VecID, res: $VecID = $VecID()): $VecID = mix(b, c) { $`resXYZW type` -> res($resXYZW) }"
                    mix(a = "c.[$xyzw]")
                    "inline fun <R> mix(b: $VecID, c: $VecID, res: ($`resXYZW type`) -> R): R" {
                        +contract
                        +"return mix($xyzw, $`b,xyzw`, $`c,xyzw`, res)"
                    }
                    // mix vectorial other float type
                    mix(a = "c.[$xyzw]")
                    +"fun mixAssign(b: $VecID, c: $otherFloatVecID): $VecID = mix(b, c, this)"
                    mix(a = "c.[$xyzw]")
                    +"fun mix(b: $VecID, c: $otherFloatVecID, res: $VecID = $VecID()): $VecID = mix(b, c) { $`resXYZW type` -> res($resXYZW) }"
                    mix(a = "c.[$xyzw]")
                    +"inline fun <R> mix(b: $VecID, c: $otherFloatVecID, res: ($`resXYZW type`) -> R): R = mix($xyzw, $`b,xyzw`, ${xyzwJoint { "c.$it.$extension" }}, res)"
                    // mix vectorial boolean
                    mix(a = "c.[$xyzw]")
                    +"fun mixAssign(b: $VecID, c: ${vec}bool): $VecID = mix(b, c, this)"
                    mix(a = "c.[$xyzw]")
                    +"fun mix(b: $VecID, c: ${vec}bool, res: $VecID = $VecID()): $VecID = mix(b, c) { $`resXYZW type` -> res($resXYZW) }"
                    mix(a = "c.[$xyzw]")
                    "inline fun <R> mix(b: $VecID, c: ${vec}bool, res: ($`resXYZW type`) -> R): R" {
                        +contract
                        +"return mix($xyzw, $`b,xyzw`, $`c,xyzw`, res)"
                    }
                }
                Generator.Part.CompanionObject -> {
                    // mix c scalar

                    mix()
                    "inline fun <R> mix(a: $VecID, b: $VecID, c: $type, res: ($`resXYZW type`) -> R): R" {
                        +contract
                        +"return mix($`a,xyzw`, $`b,xyzw`, c, res)"
                    }
                    mix(y = "b[$XYZW]")
                    "inline fun <R> mix($`xyzw type`, $`bXYZW type`, c: $type, res: ($`resXYZW type`) -> R): R" {
                        +contract
                        +"return res(${xyzwJoint { "$it.mix(b${it.toUpperCase()}, c)" }})"
                    }

                    mix()
                    "inline fun <R> mix(a: $VecID, b: $VecID, c: Boolean, res: ($`resXYZW type`) -> R): R" {
                        +contract
                        +"return mix($`a,xyzw`, $`b,xyzw`, c, res)"
                    }
                    mix(y = "b[$XYZW]")
                    "inline fun <R> mix($`xyzw type`, $`bXYZW type`, c: Boolean, res: ($`resXYZW type`) -> R): R" {
                        +contract
                        +"return res(${xyzwJoint { "$it.mix(b${it.toUpperCase()}, c)" }})"
                    }
                    if (ordinal > 1) {
                        // mix c vectorial numeric
                        mix(a = "c.[$xyzw]")
                        "inline fun <R> mix(a: $VecID, b: $VecID, c: $VecID, res: ($`resXYZW type`) -> R): R" {
                            +contract
                            +"return mix($`a,xyzw`, $`b,xyzw`, $`c,xyzw`, res)"
                        }
                        mix(y = "b[$XYZW]", a = "c[$XYZW]")
                        "inline fun <R> mix($`xyzw type`, $`bXYZW type`, $`cXYZW type`, res: ($`resXYZW type`) -> R): R" {
                            +contract
                            +"return res(${xyzwJoint { "$it.mix(b${it.toUpperCase()}, c${it.toUpperCase()})" }})"
                        }

                        // mix c vectorial bool
                        mix(a = "c.[$xyzw]")
                        "inline fun <R> mix(a: $VecID, b: $VecID, c: ${vec}bool, res: ($`resXYZW type`) -> R): R" {
                            +contract
                            +"return mix($`a,xyzw`, $`b,xyzw`, $`c,xyzw`, res)"
                        }
                        mix(y = "b[$XYZW]", a = "c[$XYZW]")
                        "inline fun <R> mix($`xyzw type`, $`bXYZW type`, $`cXYZW bool`, res: ($`resXYZW type`) -> R): R" {
                            +contract
                            +"return res(${xyzwJoint { "$it.mix(b${it.toUpperCase()}, c${it.toUpperCase()})" }})"
                        }
                    }
                }
                Generator.Part.Scalar -> {
                    mix("this", "b", "c")
                    +"inline fun $type.mix(y: $type, a: $type): $type = this * (1 - a) + y * a"
                    mix("this", "b", "c")
                    +"inline fun $type.mix(y: $type, a: $otherFloatType): $type = mix(y, a.$extension)"
                    mix("this", "b", "c")
                    +"inline fun $type.mix(y: $type, a: Boolean): $type = if (a) y else this"
                }
            }

            fun step(x: String = "[$xyzw]", edge: String = "edge") = glslDocs("Returns `0` if `$x < $edge`, otherwise it returns `1`.", "step")
            when (part) {
                Generator.Part.Class -> {
                    // step scalar
                    step()
                    +"infix fun stepAssign(edge: $type): $VecID = step(edge, this)"
                    step()
                    +"infix fun step(edge: $type): $VecID = step(edge, $VecID())"
                    step()
                    +"fun step(edge: $type, res: $VecID): $VecID = step(edge) { $`resXYZW type` -> res($resXYZW) }"
                    step()
                    "inline fun <R> step(edge: $type, res: ($`resXYZW type`) -> R): R" {
                        +contract
                        +"return step($xyzw, edge, res)"
                    }
                    // step vectorial
                    step()
                    +"infix fun stepAssign(edge: $VecID): $VecID = step(edge, this)"
                    step()
                    +"infix fun step(edge: $VecID): $VecID = step(edge, $VecID())"
                    step()
                    +"fun step(edge: $VecID, res: $VecID): $VecID = step(edge) { $`resXYZW type` -> res($resXYZW) }"
                    step()
                    "inline fun <R> step(edge: $VecID, res: ($`resXYZW type`) -> R): R" {
                        +contract
                        +"return step($xyzw, $`edge,xyzw`, res)"
                    }
                }
                Generator.Part.CompanionObject -> {
                    step("v.[$xyzw]")
                    "inline fun <R> step(v: $VecID, edge: $type, res: ($`resXYZW type`) -> R): R" {
                        +contract
                        +"return step($`v,xyzw`, edge, res)"
                    }
                    step()
                    "inline fun <R> step($`xyzw type`, edge: $type, res: ($`resXYZW type`) -> R): R" {
                        +contract
                        +"return res(${xyzwJoint { "$it step edge" }})"
                    }
                    if (ordinal > 1) {
                        step("v.[$xyzw]", "edge.[$xyzw]")
                        "inline fun <R> step(v: $VecID, edge: $VecID, res: ($`resXYZW type`) -> R): R" {
                            +contract
                            +"return step($`v,xyzw`, $`edge,xyzw`, res)"
                        }
                        step(edge = "edge[$XYZW]")
                        "inline fun <R> step($`xyzw type`, $edgeXYZW, res: ($`resXYZW type`) -> R): R" {
                            +contract
                            +"return res(${xyzwJoint { "$it step edge${it.toUpperCase()}" }})"
                        }
                    }
                }
                Generator.Part.Scalar -> {
                    step("this")
//                    +"inline infix fun $type.step(edge: $type): $type = if (this < edge) ${type.`0`} else ${type.`1`}"
                    +"inline infix fun $type.step(edge: $type): $type = ${type.`1`}.mix(${type.`0`}, this < edge)"
                }
            }

            fun smoothstep(x: String = "[$xyzw]", edge0: String = "edge0", edge1: String = "edge1") = glslDocs("""
                |Returns `0.0` if `$x <= $edge0` and `1.0` if `$x >= $edge1` and performs smooth Hermite interpolation 
                |between `0` and `1` when `$edge0 < $x < $edge1`. This is useful in cases where you would want 
                |a threshold function with a smooth transition. This is equivalent to:
                |`genType t;`
                |`t = clamp ((x - edge0) / (edge1 - edge0), 0, 1);`
                |`return t * t * (3 - 2 * t);`
                |Results are undefined if `$edge0 >= $edge1`.""", "smoothstep")
            when (part) {
                Generator.Part.Class -> {
                    // smoothstep scalar
                    smoothstep()
                    +"fun smoothstepAssign(edge0: $type, edge1: $type): $VecID = smoothstep(edge0, edge1, this)"
                    smoothstep()
                    +"fun smoothstep(edge0: $type, edge1: $type, res: $VecID = $VecID()): $VecID = smoothstep(edge0, edge1) { $`resXYZW type` -> res($resXYZW) }"
                    smoothstep()
                    "inline fun <R> smoothstep(edge0: $type, edge1: $type, res: ($`resXYZW type`) -> R): R" {
                        +contract
                        +"return smoothstep(this, edge0, edge1, res)"
                    }
                    // smoothstep vectorial
                    smoothstep()
                    +"fun smoothstepAssign(edge0: $VecID, edge1: $VecID): $VecID = smoothstep(edge0, edge1, this)"
                    smoothstep()
                    +"fun smoothstep(edge0: $VecID, edge1: $VecID, res: $VecID = $VecID()): $VecID = smoothstep(edge0, edge1) { $`resXYZW type` -> res($resXYZW) }"
                    smoothstep()
                    "inline fun <R> smoothstep(edge0: $VecID, edge1: $VecID, res: ($`resXYZW type`) -> R): R" {
                        +contract
                        +"return smoothstep(this, edge0, edge1, res)"
                    }
                }
                Generator.Part.CompanionObject -> {
                    // scalar
                    smoothstep("v.[$xyzw]")
                    "inline fun <R> smoothstep(v: $VecID, edge0: $type, edge1: $type, res: ($`resXYZW type`) -> R): R" {
                        +contract
                        +"return smoothstep($`v,xyzw`, edge0, edge1, res)"
                    }
                    if (ordinal > 1) {
                        smoothstep()
                        "inline fun <R> smoothstep($`xyzw type`, edge0: $type, edge1: $type, res: ($`resXYZW type`) -> R): R" {
                            +contract
                            +"return smoothstep($xyzw, $edge0Joint, $edge1Joint, res)"
                        }
                    }
                    // vectorial
                    smoothstep("v.[$xyzw]", "edge0.[$xyzw]", "edge1.[$xyzw]")
                    "inline fun <R> smoothstep(v: $VecID, edge0: $VecID, edge1: $VecID, res: ($`resXYZW type`) -> R): R" {
                        +contract
                        +"return smoothstep($`v,xyzw`, $`edge0,xyzw`, $`edge1,xyzw`, res)"
                    }
                        smoothstep(edge0 = "edge0[$XYZW]", edge1 = "edge1[$XYZW]")
                        "inline fun <R> smoothstep($`xyzw type`, $`edge0XYZW type`, $`edge1XYZW type`, res: ($`resXYZW type`) -> R): R" {
                            +contract
                            +"return res(${XyzwJoint { "${it.toLowerCase()}.smoothstep(edge0$it, edge1$it)" }})"
                    }
                }
                Generator.Part.Scalar -> {
                    smoothstep("this")
                    "inline fun $type.smoothstep(edge0: $type, edge1: $type): $type" {
                        +"val tmp = (this - edge0) / (edge1 - edge0)"
                        +"val clamp = tmp.clamp(${type.`0`}, ${type.`1`})"
                        +"return clamp * clamp * (${type.`3`} - ${type.`2`} * clamp)"
                    }
                }
            }

            fun isNan(x: String = "[$xyzw]") = glslDocs("""
                |Returns `true` if `$x` holds a `NaN` (not a number) representation in the underlying implementation's 
                |set of floating point representations. Returns `false` otherwise, including for implementations 
                |with no `NaN` representations.""", "isNaN")
            when (part) {
                Generator.Part.Class -> {
                    isNan()
                    +"fun isNan(res: ${vec}bool = ${vec}bool()): ${vec}bool = isNan { $`resXYZW Bool` -> res($resXYZW) }"
                    isNan()
                    "inline fun <R> isNan(res: ($`resXYZW Bool`) -> R): R" {
                        +contract
                        +"return res(${xyzwJoint { "$it.isNaN()" }})"
                    }
                }
                Generator.Part.CompanionObject -> {
                    isNan()
                    "inline fun <R> isNan(v: $VecID, res: ($`resXYZW Bool`) -> R): R" {
                        +contract
                        +"return isNan($`v,xyzw`, res)"
                    }
                    isNan()
                    "inline fun <R> isNan($`xyzw type`, res: ($`resXYZW Bool`) -> R): R" {
                        +contract
                        +"return res(${xyzwJoint { "$it.isNaN()" }})"
                    }
                }
                else -> Unit // in stdlib
            }

            fun isInf(x: String = "[$xyzw]") = glslDocs("""
                |Returns `true` if `$x` holds a positive infinity or negative infinity representation in the underlying 
                |implementation's set of floating point representations. Returns `false` otherwise, including for
                |implementations with no infinity representations.""", "isInf")
            when (part) {
                Generator.Part.Class -> {
                    isInf()
                    +"fun isInf(res: ${vec}bool = ${vec}bool()): ${vec}bool = isInf { $`resXYZW Bool` -> res($resXYZW) }"
                    isInf()
                    "inline fun <R> isInf(res: ($`resXYZW Bool`) -> R): R" {
                        +contract
                        +"return res(${xyzwJoint { "$it.isInfinite()" }})"
                    }
                }
                Generator.Part.CompanionObject -> {
                    isInf()
                    "inline fun <R> isInf(v: $VecID, res: ($`resXYZW Bool`) -> R): R" {
                        +contract
                        +"return isInf($`v,xyzw`, res)"
                    }
                    isInf()
                    "inline fun <R> isInf($`xyzw type`, res: ($`resXYZW Bool`) -> R): R" {
                        +contract
                        +"return res(${xyzwJoint { "$it.isInfinite()" }})"
                    }
                }
                else -> Unit // in stdlib
            }


        }
    }
    val intCounterType = type.counterpart
    //    println("type: $type")
    //    println("intCounterType: $intCounterType")
    val intCounterID: String? = numberTypeInformation.find { it.type == intCounterType }?.id ?: ""

    //    println("intCounterID: $intCounterID")
    fun toBits(unsigned: Boolean = false) {
        val text = """
            |Returns a ${if (unsigned) "un" else ""}signed integer value representing the encoding of a floating-point value.
            |The floatingpoint value's bit-level representation is preserved."""
        when (type) {
            "Float" -> glslDocs(text, "floatBitsTo" + if (unsigned) "Uint" else "Int")
            else -> docs(text)
        }
    }

    val `resXYZW intCounterType` = XyzwJoint { "res$it: $intCounterType" }
    val `resXYZW UnsCounterType` = XyzwJoint { "res$it: U$intCounterType" }
    val unsigned = type[0] == 'U'
    fun bitsTo() {
        val text = """
            |Returns a floating-point value corresponding to a ${if (unsigned) "un" else ""}signed integer encoding of a floating-point value.
            |If an `inf` or `NaN` is passed in, it will not signal, and the resulting floating point value is unspecified.
            |Otherwise, the bit-level representation is preserved."""
        when (type) {
            "Float" -> glslDocs(text, (if (unsigned) "u" else "") + "intBitsToFloat")
            else -> docs(text)
        }
    }

    val floatCounterType = type.drop(if (unsigned) 1 else 0).counterpart
    //    println("floatCounterType: $floatCounterType")
    val floatCounterID = numberTypeInformation.find { it.type == floatCounterType }?.id ?: ""
    val `resXYZW floatCounterType` = XyzwJoint { "res$it: $floatCounterType" }
    when {
        type in floatingPointTypes -> when (part) {
            Generator.Part.Class -> {
                // bitsToInt-Long
                toBits()
                +"fun bitsTo$intCounterType(res: $vec$intCounterID = $vec$intCounterID()): $vec$intCounterID = bitsTo$intCounterType($xyzw) { $`resXYZW intCounterType` -> res($resXYZW) }"
                // bitsToUInt-Ulong
                toBits(true)
                val uns = "u" + intCounterType[0].toLowerCase()
                +"fun bitsToU$intCounterType(res: $vec$uns = $vec$uns()): $vec$uns = bitsToU$intCounterType($xyzw) { $`resXYZW UnsCounterType` -> res($resXYZW) }"
            }
            Generator.Part.CompanionObject -> {
                // bitsToInt-Long
                toBits()
                "inline fun <R> bitsTo$intCounterType(v: $VecID, res: ($`resXYZW intCounterType`) -> R): R" {
                    +contract
                    +"return bitsTo$intCounterType($`v,xyzw`, res)"
                }
                toBits()
                "inline fun <R> bitsTo$intCounterType($`xyzw type`, res: ($`resXYZW intCounterType`) -> R): R" {
                    +contract
                    +"return res(${xyzwJoint { "$it.bitsTo$intCounterType()" }})"
                }
                // bitsToUInt-Ulong
                toBits(true)
                "inline fun <R> bitsToU$intCounterType(v: $VecID, res: ($`resXYZW UnsCounterType`) -> R): R" {
                    +contract
                    +"return bitsToU$intCounterType($`v,xyzw`, res)"
                }
                toBits(true)
                "inline fun <R> bitsToU$intCounterType($`xyzw type`, res: ($`resXYZW UnsCounterType`) -> R): R" {
                    +contract
                    +"return res(${xyzwJoint { "$it.bitsToU$intCounterType()" }})"
                }
            }
            Generator.Part.Scalar -> {
                // bitsToInt-Long
                toBits()
                +"inline fun $type.bitsTo$intCounterType(): $intCounterType = toBits()"
                // bitsToUInt-ULong
                toBits(true)
                +"inline fun $type.bitsToU$intCounterType(): U$intCounterType = toBits().u${intCounterType[0].toLowerCase()}"
            }
        }
        // every integer, signed and unsigned
        "Int" in type || "Long" in type -> when (part) {
            Generator.Part.Class -> {
                bitsTo()
                +"fun bitsTo$floatCounterType(res: $vec$floatCounterID = $vec$floatCounterID()): $vec$floatCounterID = bitsTo$floatCounterType($xyzw) { $`resXYZW floatCounterType` -> res($resXYZW) }"
            }
            Generator.Part.CompanionObject -> {
                bitsTo()
                "inline fun <R> bitsTo$floatCounterType($`xyzw type`, res: (${XyzwJoint { "res$it: $floatCounterType" }}) -> R): R" {
                    +contract
                    +"return res(${xyzwJoint { "$it.bitsTo$floatCounterType()" }})"
                }
            }
            Generator.Part.Scalar -> {
                val bits = when (type) {
                    "UInt" -> "i"
                    "ULong" -> "L"
                    else -> "this"
                }
                bitsTo()
                +"inline fun $type.bitsTo$floatCounterType(): $floatCounterType = $floatCounterType.fromBits($bits)"
            }
        }
    }

    if (type in floatingPointTypes) {
        fun fma(a: String = "[$xyzw]", b: String = "b.[$xyzw]", c: String = "c.[$xyzw]") = glslDocs("Computes and returns `$a * $b + $c`.", "fma")
        when (part) {
            Generator.Part.Class -> {
                fma()
                +"fun fmaAssign(b: $VecID, c: $VecID): $VecID = fma(b, c, this)"
                fma()
                +"fun fma(b: $VecID, c: $VecID, res: $VecID = $VecID()): $VecID = fma(b, c) { $`resXYZW type` -> res($resXYZW) }"
                fma()
                "inline fun <R> fma(b: $VecID, c: $VecID, res: ($`resXYZW type`) -> R): R" {
                    +contract
                    +"return fma($xyzw, $`b,xyzw`, $`c,xyzw`, res)"
                }
            }
            Generator.Part.CompanionObject -> {
                fma("a.[$xyzw]")
                "inline fun <R> fma(a: $VecID, b: $VecID, c: $VecID, res: ($`resXYZW type`) -> R): R" {
                    +contract
                    +"return fma($`a,xyzw`, $`b,xyzw`, $`c,xyzw`, res)"
                }
                fma("a[$XYZW]", "b[$XYZW]", "c[$XYZW]")
                "inline fun <R> fma($`aXYZW type`, $`bXYZW type`, $`cXYZW type`, res: ($`resXYZW type`) -> R): R" {
                    +contract
                    +"return res(${XyzwJoint { "a$it.fma(b$it, c$it)" }})"
                }
            }
            Generator.Part.Scalar -> {
                fma("this", "b", "c")
                +"inline fun $type.fma(b: $type, c: $type): $type = this * b + c"
            }
        }
        fun frexp(x: String = "[$xyzw]") = glslDocs("""
            |Splits `$x` into a floating-point significand in the range `[0.5, 1.0)` and an integral exponent of two, such that:
            |`$x = significand * exp(2, exponent)`
            |
            |The significand is returned by the function and the exponent is returned in the parameter `exp`. 
            |For a floating-point value of zero, the significant and exponent are both zero. 
            |For a floating-point value that is an infinity or is not a number, the results are undefined.""", "frexp")
        when (part) {
            Generator.Part.Class -> {
                frexp()
                val mantXYZW = XyzwJoint { "mant$it" }
                val expXYZW = XyzwJoint { "exp$it" }
                +"""
                    fun frexp(resMant: $VecID = $VecID(), resExp: ${vec}i = ${vec}i()) = frexp($xyzw) { $mantXYZW, $expXYZW ->
                        resMant.put($mantXYZW)
                        resExp.put($expXYZW)
                    }"""
                frexp()
                +"""
                    fun frexp(resMantExp: Pair<$VecID, ${vec}i> = $VecID() to ${vec}i()): Pair<$VecID, ${vec}i> = frexp($xyzw) { $mantXYZW, $expXYZW ->
                        resMantExp.apply {
                            first.put($mantXYZW)
                            second.put($expXYZW)
                        }
                    }"""
                frexp()
                val `mantXZYW type` = XyzwJoint { "mant$it: $type" }
                +"fun <R> frexp(res: ($`mantXZYW type`, $`expXYZW Int`) -> R): R = frexp($xyzw, res)"
            }
            Generator.Part.CompanionObject -> {
                val `resMantXYZW type` = XyzwJoint { "resMant$it: $type" }
                val `resExpXYZW type` = XyzwJoint { "resExp$it: Int" }
                frexp("v")
                "inline fun <R> frexp(v: $VecID, res: ($`resMantXYZW type`, $`resExpXYZW type`) -> R): R" {
                    +contract
                    +"return frexp($`v,xyzw`, res)"
                }
                frexp()
                "inline fun <R> frexp($`xyzw type`, res: ($`resMantXYZW type`, $`resExpXYZW type`) -> R): R" {
                    +contract
                    Xyzw { +"val e$it: Int" }
                    Xyzw { +"val m$it = ${it.toLowerCase()}.frexp { e$it = it }" }
                    +"return res(${XyzwJoint { "m$it" }}, ${XyzwJoint { "e$it" }})"
                }
            }
            Generator.Part.Scalar -> {
                frexp("this")
                val x = if (type == "Float") 23 else 52
                "fun $type.frexp(resExp: KMutableProperty0<Int>): $type" {
                    +"""
                        val bits = toBits()
                        var realMant: $type
                        
                        // Test for NaN, infinity, and zero.
                        return when {
                            isNaN() || this + this == this || isInfinite() -> {
                                resExp.set(0)
                                this
                            } 
                            else -> {
                                val neg = bits < 0
                                ${
                        when (type) {
                            "Float" -> "var exponent = (bits ushr $x) and 0xff"
                            else -> "var exponent = ((bits ushr $x) and 0x7ffL).i"
                        }
                    }
                                ${
                        when (type) {
                            "Float" -> "var mantissa = bits and 0xffffff"
                            else -> "var mantissa = bits and 0xfffffffffffffL"
                        }
                    }
                                if (exponent == 0)
                                    exponent++
                                else
                                    mantissa = mantissa or (1${if (type == "Float") "" else "L"} shl $x)
        
                                // bias the exponent - actually biased by ${if (type == "Float") "127" else "1023"}.
                                // we are treating the mantissa as m.0 instead of 0.m
                                // so subtract another $x.
                                exponent -= ${if (type == "Float") "150" else "1075"}
                                realMant = mantissa.${extension}
        
                                // normalize
                                while (realMant > ${type.`1`}) {
                                    mantissa = mantissa shr 1
                                    realMant /= ${type.`2`}
                                    exponent++
                                }
                                if (neg)
                                    realMant *= -1
                                    
                                resExp.set(exponent)
                                realMant
                            }
                        }"""
                }
                frexp("this")
                "fun $type.frexp(resExp: (Int) -> Unit): $type" {
                    +contract("resExp")
                    +"""
                        val bits = toBits()
                        var realMant: $type
                        
                        // Test for NaN, infinity, and zero.
                        return when {
                            isNaN() || this + this == this || isInfinite() -> {
                                resExp(0)
                                this
                            } 
                            else -> {
                                val neg = bits < 0
                                ${
                        when (type) {
                            "Float" -> "var exponent = (bits ushr $x) and 0xff"
                            else -> "var exponent = ((bits ushr $x) and 0x7ffL).i"
                        }
                    }
                                ${
                        when (type) {
                            "Float" -> "var mantissa = bits and 0xffffff"
                            else -> "var mantissa = bits and 0xfffffffffffffL"
                        }
                    }
                                if (exponent == 0)
                                    exponent++
                                else
                                    mantissa = mantissa or (1${if (type == "Float") "" else "L"} shl $x)
        
                                // bias the exponent - actually biased by ${if (type == "Float") "127" else "1023"}.
                                // we are treating the mantissa as m.0 instead of 0.m
                                // so subtract another $x.
                                exponent -= ${if (type == "Float") "150" else "1075"}
                                realMant = mantissa.${extension}
        
                                // normalize
                                while (realMant > ${type.`1`}) {
                                    mantissa = mantissa shr 1
                                    realMant /= ${type.`2`}
                                    exponent++
                                }
                                if (neg)
                                    realMant *= -1
                                    
                                resExp(exponent)
                                realMant
                            }
                        }"""
                }
                frexp("this")
                "fun $type.frexp(): Pair<$type, Int>" {
                    +"""
                        val bits = toBits()
                        var realMant: $type
    
                        // Test for NaN, infinity, and zero.
                        return when {
                            isNaN() || this + this == this || isInfinite() -> this to 0
                            else -> {
                                val neg = bits < 0
                                ${
                        when (type) {
                            "Float" -> "var exponent = (bits ushr $x) and 0xff"
                            else -> "var exponent = ((bits ushr $x) and 0x7ffL).i"
                        }
                    }
                                ${
                        when (type) {
                            "Float" -> "var mantissa = bits and 0xffffff"
                            else -> "var mantissa = bits and 0xfffffffffffffL"
                        }
                    }
                                if (exponent == 0)
                                    exponent++
                                else
                                    mantissa = mantissa or (1${if (type == "Float") "" else "L"} shl $x)
        
                                // bias the exponent - actually biased by ${if (type == "Float") "127" else "1023"}.
                                // we are treating the mantissa as m.0 instead of 0.m
                                // so subtract another $x.
                                exponent -= ${if (type == "Float") "150" else "1075"}
                                realMant = mantissa.${extension}
        
                                // normalize
                                while (realMant > ${type.`1`}) {
                                    mantissa = mantissa shr 1
                                    realMant /= ${type.`2`}
                                    exponent++
                                }
                                if (neg)
                                    realMant *= -1
                                    
                                realMant to exponent
                            }
                        }"""
                }
            }
        }

        fun ldexp(x: String = "[$xyzw]") = glslDocs("""
            |Builds a floating-point number from `$x` and the corresponding integral exponent of two in exp, returning:
            |`significand * exp(2, exponent)`
            |
            |If this product is too large to be represented in the floating-point type, the result is undefined.""", "ldexp")
        when (part) {
            Generator.Part.Class -> {
                ldexp()
                +"fun ldexpAssign(exp: ${vec}i): $VecID = ldexp(exp, this)"
                ldexp()
                +"infix fun ldexp(exp: ${vec}i): $VecID = ldexp(exp, $VecID())"
                ldexp()
                +"fun ldexp(exp: ${vec}i, res: $VecID): $VecID = ldexp(exp) { $resXYZW -> res($resXYZW) }"
                ldexp()
                "inline fun <R> ldexp(exp: ${vec}i, res: ($`resXYZW type`) -> R): R" {
                    +contract
                    +"return ldexp($xyzw, ${xyzwJoint { "exp.$it" }}, res)"
                }
            }
            Generator.Part.CompanionObject -> {
                ldexp()
                val `expXyzw Int` = XyzwJoint { "exp$it: Int" }
                "inline fun <R> ldexp($`xyzw type`, $`expXyzw Int`, res: ($`resXYZW type`) -> R): R" {
                    +contract
                    +"return res(${xyzwJoint { "$it ldexp exp${it.toUpperCase()}" }})"
                }
            }
            Generator.Part.Scalar -> {
                ldexp()
                +"inline infix fun $type.ldexp(exp: Int) = this * ${type.`2`}.pow(exp)"
            }
        }
    }
}