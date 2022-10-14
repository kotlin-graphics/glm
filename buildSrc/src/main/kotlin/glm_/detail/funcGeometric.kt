package glm_.detail

import glm_.*
import glm_.gen.Generator

fun Generator.geometric(ordinal: Int, type: String, extension: String, id: String, vec: String, part: Generator.Part) {

    if (part != Generator.Part.Scalar) +"// geometric\n"

    val `exp,xyzw` = xyzwJoint { "exp.$it" }
    val `expXYZW type` = xyzwJoint { "exp$it: $type" }
    val `expXYZW Int` = xyzwJoint { "exp$it: Int" }
    val VecID = vec + id
    val xyzw = xyzwJoint()
    val `-xyzw` = xyzwJoint { "-$it" }
    val XYZW = XyzwJoint()
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
    val `vXYZW type` = XyzwJoint { "v$it: $type" }
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
    val `p0,xyzw` = xyzwJoint { "p0.$it" }
    val `p1,xyzw` = xyzwJoint { "p1.$it" }
    val `edge0XYZW type` = XyzwJoint { "edge0$it: $type" }
    val `edge1XYZW type` = XyzwJoint { "edge1$it: $type" }

    fun glslDocs(descr: String, manPage: String, append: String = "") = docs("""
            |$descr
            |
            |[GLSL $manPage man page](http://www.opengl.org/sdk/docs/manglsl/xhtml/$manPage.xml)
            |[GLSL 4.20.8 specification, section 8.5 Geometric Functions](http://www.opengl.org/registry/doc/GLSLangSpec.4.20.8.pdf)
            |$append""")

    if (type in floatingPointTypes) {

        fun length(x: String = "[$xyzw]") = glslDocs("Returns the length of `$x`, i.e., `sqrt($x * $x)`.", "length")
        when (part) {
            Generator.Part.Class -> {
                length()
                +"fun length(): $type = length(this)"
            }
            Generator.Part.CompanionObject -> {
                length("v.[$xyzw]")
                +"fun length(v: $VecID): $type = length($`v,xyzw`)"
                length()
                +"fun length($`xyzw type`): $type = sqrt(dot($xyzw, $xyzw))"
            }
            Generator.Part.Scalar -> {
                length("this")
                +"fun $type.length(): $type = abs()"
            }
        }

        fun distance(p0: String = "[$xyzw]", p1: String = "p1") = glslDocs("Returns the distance between `$p0` and `$p1`, i.e., `length($p0 - $p1)`.", "distance")
        when (part) {
            Generator.Part.Class -> {
                distance(p1 = "p.[$xyzw]")
                +"infix fun distance(p: $VecID): $type = distance(this, p)"
            }
            Generator.Part.CompanionObject -> {
                distance("p0.[$xyzw]", "p1.[$xyzw]")
                +"fun distance(p0: $VecID, p1: $VecID): $type = distance($`p0,xyzw`, $`p1,xyzw`)"
                distance(p1 = "b[$XYZW]")
                "fun distance($`xyzw type`, $`bXYZW type`): $type" {
                    +xyzwJoint(separator = "; ") { "val d$it: $type" }
                    +"minus($xyzw, $bXYZW) { $`resXYZW type` -> ${xyzwJoint(separator = "; ") { "d$it = res${it.toUpperCase()}" }} }"
                    +"return length(${xyzwJoint { "d$it" }})"
                }
            }
            Generator.Part.Scalar -> {
                distance("this", "p")
                +"infix fun $type.distance(p: $type): $type = (this - p).length()"
            }
        }

        fun dot(x: String = "[$xyzw]", y: String = "b.[$xyzw]") = glslDocs("Returns the dot product of `$x` and `$y`, i.e., `result = $x * $y`.", "dot")
        when (part) {
            Generator.Part.Class -> {
                dot()
                +"infix fun dot(b: $VecID): $type = dot(this, b)"
            }
            Generator.Part.CompanionObject -> {
                dot("p0.[$xyzw]", "p1.[$xyzw]")
                +"fun dot(p0: $VecID, p1: $VecID): $type = dot($`p0,xyzw`, $`p1,xyzw`)"
                dot(y = "b[$XYZW]")
                +"fun dot($`xyzw type`, $`bXYZW type`): $type = ${xyzwJoint(separator = " + ") { "$it * b${it.toUpperCase()}" }}"
            }
            Generator.Part.Scalar -> {
                dot("this", "y")
                +"infix fun $type.dot(y: $type): $type = this * y"
            }
        }

        if (ordinal == 3) {
            fun cross(x: String = "[$xyzw]", y: String = "b.[$xyzw]") = glslDocs("Returns the cross product of `$x` and `$y`.", "cross")
            when (part) {
                Generator.Part.Class -> {
                    cross()
                    +"infix fun crossAssign(b: Vec3$id): Vec3$id = cross(b, this)"
                    cross()
                    +"infix fun cross(b: Vec3$id): Vec3$id = cross(b, Vec3$id())"
                    cross()
                    +"fun cross(b: Vec3$id, res: Vec3$id): Vec3$id = cross(this, b) { $`resXYZW type` -> res($resXYZW) }"
                    cross()
                    "inline fun <R> cross(v: Vec3$id, res: ($`resXYZW type`) -> R): R" {
                        +contract
                        +"return cross(this, v, res)"
                    }
                }
                Generator.Part.CompanionObject -> {
                    cross()
                    +"inline fun <R> cross(a: $VecID, b: $VecID, res: ($`resXYZW type`) -> R): R = cross($`a,xyzw`, $`b,xyzw`, res)"
                    cross()
                    "inline fun <R> cross($`xyzw type`, $`vXYZW type`, res: ($`resXYZW type`) -> R): R" {
                        +contract
                        +"return res(y * vZ - vY * z, z * vX - vZ * x, x * vY - vX * y)"
                    }
                }
                else -> Unit
            }
        }

        fun normalize(x: String = "[$xyzw]") = glslDocs("""
            |Returns a vector in the same direction as `$x` but with length of `1`.
            |According to issue 10 GLSL 1.10 specification, if `length(x) == 0` then result is undefined and generate an error.""", "normalize")
        when (part) {
            Generator.Part.Class -> {
                normalize()
                +"fun normalizeAssign(): $VecID = normalize(this)"
                normalize()
                +"fun normalize(res: $VecID = $VecID()): $VecID = normalize(this) { $`xyzw type` -> res($xyzw) }"
                normalize()
                "inline fun <R> normalize(res: ($`resXYZW type`) -> R): R" {
                    +contract
                    +"return normalize(this, res)"
                }
            }
            Generator.Part.CompanionObject -> {
                normalize("v")
                +"inline fun <R> normalize(v: $VecID, res: ($`resXYZW type`) -> R): R = normalize($`v,xyzw`, res)"
                normalize()
                "inline fun <R> normalize($`xyzw type`, res: ($`resXYZW type`) -> R): R" {
                    +contract
                    +"val inverseSqrt = dot($xyzw, $xyzw).inverseSqrt()"
                    +"return times($xyzw, ${xyzwJoint { "inverseSqrt" }}) { $`resXYZW type` -> res($resXYZW) }"
                }
            }
            else -> Unit
        }

        fun faceForward(n: String = "[$xyzw]", i: String = "i.[$xyzw]", nRef: String = "nRef.[$xyzw]") =
            glslDocs("If `dot($nRef, $i) < 0.0`, return `$n`, otherwise, return `-$n`.", "faceforward")
        when (part) {
            Generator.Part.Class -> {
                faceForward()
                +"fun faceForwardAssign(i: $VecID, nRef: $VecID): $VecID = faceForward(i, nRef, this)"
                faceForward()
                +"fun faceForward(i: $VecID, nRef: $VecID, res: $VecID = $VecID()): $VecID = faceForward(this, i, nRef) { $`xyzw type` -> res($xyzw) }"
                faceForward()
                "inline fun <R> faceForward(i: $VecID, nRef: $VecID, res: ($`resXYZW type`) -> R): R" {
                    +contract
                    +"return faceForward(this, i, nRef, res)"
                }
            }
            Generator.Part.CompanionObject -> {
                faceForward("n.[$xyzw]")
                +"inline fun <R> faceForward(n: $VecID, i: $VecID, nRef: $VecID, res: ($`resXYZW type`) -> R): R = faceForward($`n,xyzw`, $`i,xyzw`, $`nRef,xyzw`, res)"
                faceForward(i = "i[$XYZW]", nRef = "nRef.[$xyzw]")
                "inline fun <R> faceForward($`xyzw type`, $`iXYZW type`, $`nRefXYZW type`, res: ($`resXYZW type`) -> R): R" {
                    +contract
                    +"return if(dot($nRefXYZW, $iXYZW) < 0) res($xyzw) else res($`-xyzw`)"
                }
            }
            Generator.Part.Scalar -> {
                faceForward()
                +"fun $type.faceForward(i: $type, nRef: $type): $type = if((nRef dot i) < 0) this else -this"
            }
        }

        fun reflect(i: String = "[$xyzw]", n: String = "n.[$xyzw]") = glslDocs(
            "For the incident vector `$i` and surface orientation `$n`, returns the reflection direction : result = `$i - 2.0 * dot($n, $i) * $n`.", "reflect")
        when (part) {
            Generator.Part.Class -> {
                reflect()
                +"fun reflectAssign(n: $VecID): $VecID = reflect(n, this)"
                reflect()
                +"infix fun reflect(n: $VecID): $VecID = reflect(n, $VecID())"
                reflect()
                +"fun reflect(n: $VecID, res: $VecID): $VecID = reflect(this, n) { $`xyzw type` -> res($xyzw) }"
                reflect()
                "inline fun <R> reflect(n: $VecID, res: ($`resXYZW type`) -> R): R" {
                    +contract
                    +"return reflect(this, n, res)"
                }
            }
            Generator.Part.CompanionObject -> {
                reflect("i.[$xyzw]", "n.[$xyzw]")
                +"inline fun <R> reflect(i: $VecID, n: $VecID, res: ($`resXYZW type`) -> R): R = reflect($`i,xyzw`, $`n,xyzw`, res)"
                reflect(i = "[$xyzw]", n = "n[$XYZW]")
                "inline fun <R> reflect($`xyzw type`, $`nXYZW type`, res: ($`resXYZW type`) -> R): R" {
                    +contract
                    Xyzw { +"val t$it: $type" }
                    +"val dotValue = dot($nXYZW, $xyzw)"
                    +"times($nXYZW, ${xyzwJoint { "dotValue" }}) { $`resXYZW type` -> "
                    indent { Xyzw { +"t$it = res$it" } }
                    +"}"
                    +"return res(${xyzwJoint { "$it - t${it.toUpperCase()} * 2" }})"
                }
            }
            Generator.Part.Scalar -> {
                reflect()
                +"infix fun $type.reflect(n: $type): $type = this - n * (n dot this) * ${type.`2`}"
            }
        }

        fun refract(i: String = "[$xyzw]", n: String = "n.[$xyzw]") =
            glslDocs("For the incident vector `$i` and surface normal `$n`, and the ratio of indices of refraction `eta`, return the refraction vector.", "refract")
        when (part) {
            Generator.Part.Class -> {
                refract()
                +"fun refractAssign(n: $VecID, eta: $type): $VecID = refract(n, eta, this)"
                refract()
                +"fun refract(n: $VecID, eta: $type, res: $VecID = $VecID()): $VecID = refract(this, n, eta) { $`xyzw type` -> res($xyzw) }"
                refract()
                "inline fun <R> refract(n: $VecID, eta: $type, res: ($`resXYZW type`) -> R): R" {
                    +contract
                    +"return refract(this, n, eta, res)"
                }
            }
            Generator.Part.CompanionObject -> {
                refract("i.[$xyzw]", "n.[$xyzw]")
                +"inline fun <R> refract(i: $VecID, n: $VecID, eta: $type, res: ($`resXYZW type`) -> R): R = refract($`i,xyzw`, $`n,xyzw`, eta, res)"
                refract(i = "i[$XYZW]", n = "n[$XYZW]")
                "inline fun <R> refract($`iXYZW type`, $`nXYZW type`, eta: $type, res: ($`resXYZW type`) -> R): R" {
                    +contract
                    +"val dotValue = dot($nXYZW, $iXYZW)"
                    +"val k = 1 - eta * eta * (1 - dotValue * dotValue)"
                    "return when" {
                        "k >= 0 -> " {
                            Xyzw { +"val a$it: $type" }
                            "times($iXYZW, ${xyzwJoint { "eta" }}) { $`resXYZW type` -> ".indentAndClose {
                                Xyzw { +"a$it = res$it" }
                            }
                            Xyzw { +"val b$it: $type" }
                            +"val t = eta * dotValue + k.sqrt()"
                            "times($nXYZW, ${xyzwJoint { "t" }}) { $`resXYZW type` -> ".indentAndClose {
                                Xyzw { +"b$it = res$it" }
                            }
                            "minus(${XyzwJoint { "a$it" }}, ${XyzwJoint { "b$it" }}) { $`resXYZW type` ->".indentAndClose {
                                +"res($resXYZW)"
                            }
                        }
                        +"else -> res(${xyzwJoint { type.`0` }})"
                    }
                }
            }
            Generator.Part.Scalar -> {
                refract()
                +"""
                    fun $type.refract(n: $type, eta: $type): $type {
                        val dotValue = n dot this
                        val k = ${type.`1`} - eta * eta * (${type.`1`} - dotValue * dotValue)
                        return (eta * this - (eta * dotValue + k.sqrt()) * n) * if (k >= 0) ${type.`1`} else ${type.`0`}
                    }"""
            }
        }
    }

    if (ordinal > 1 && type in numberTypes && part == Generator.Part.Class) {
        +"// Dot products"
        for (unsigned in (unsignedTypes + "out Number")) {
            if (unsigned != "out Number") +"@JvmName(\"dot$unsigned\")"
            +"infix fun dot(v: Vec${ordinal}T<$unsigned>) = (${xyzwJoint(separator = " + ") { "$it * v.$it.$extension" }}).$extension"
        }
    }
}