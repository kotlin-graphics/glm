package glm_.generators.ext

import glm_.generators.*
import glm_.generators.gen.Generator

fun Generator.extMatrixRelational(width: Int, height: Int, type: Type, part: Generator.Part) {

    +"// ext matrix relational\n"

    val id = type.id
    val MatID = "Mat$matrixSize$id"

    //    imports += listOf("glm_.scalar.sin",
    //                      "glm_.scalar.cos",
    //                      "glm_.detail.GlmCoordinateSystem",
    //                      "glm_.detail.GLM_COORDINATE_SYSTEM")
    //    val `0` = type.`0`
    //    val `1` = type.`1`

    val `mAbcdN type` = AbcdJoint(rowSeparator = ",\n") { "m$it: $type" }
    val `nAbcdN type` = AbcdJoint(rowSeparator = ",\n") { "n$it: $type" }
    val abcdN = abcdJoint(rowSeparator = ",\n")
    val `m,abcdN` = abcdJoint(rowSeparator = ",\n") { "m.$it" }
    val `n,abcdN` = abcdJoint(rowSeparator = ",\n") { "n.$it" }
    val nAbcdN = AbcdJoint(rowSeparator = ",\n") { "n$it" }
    val `abcd type` = abcdJoint(4, 4, ",\n") { "$it: $type" }
    val `xyzw Boolean` = xyzwJoint(width) { "$it: Boolean" }
    val `epsilon,xyzw` = xyzwJoint(width) { "epsilon.$it" }
    val `ulps,xyzw` = xyzwJoint(width) { "ulps.$it" }
    val `ulpsXyzw Int` = XyzwJoint(width) { "ulps$it: Int" }
    val `epsilonXyzw type` = XyzwJoint(width) { "epsilon$it: $type" }
    val epsilonXyzw = XyzwJoint(width) { "epsilon$it" }
    val ulpsXyzw = XyzwJoint(width) { "ulps$it" }
    val xyzw = xyzwJoint(width)
    val Xyzw = XyzwJoint(width)

//    if (type !in floatingPointTypes)
//        return

    val VecCid = "Vec$width$id"
    val VecCi = "Vec${width}i"
    val VecCbool = "Vec${width}bool"

    val funcs = listOf("equal", "notEqual")
    val signs = listOf("<=", ">")
    val seps = listOf("&&", "||")
    val comps = listOf("equal-to", "not-equal-to")
    for (i in funcs.indices) {
        val func = funcs[i]
        val sign = signs[i]
        val sep = seps[i]
        val comp = comps[i]
        fun plain() = docs("""
            |Perform a component-wise $comp comparison of two matrices.
            |Return a boolean vector which components value is True if this expression is satisfied per column of the matrices.""")
        fun epsilon(x: String = "this[abcdN]", y: String = "n[abcdN]", epsilon: String = "epsilon") = docs("""
            |Returns the component-wise comparison of `|$x - $y| $sign $epsilon`.
            |True if this expression is satisfied.""")
        val maybeNot = if(func == "equal") "" else " not"
        fun ulps() = docs("""
            |Returns the component-wise comparison between two vectors in term of ULPs.
            |True if this expression is$maybeNot satisfied.""")
        when (part) {
            Generator.Part.Class -> {
                plain()
                +"fun $func(n: $MatID, res: $VecCbool = $VecCbool()): $VecCbool = $func($`n,abcdN`, res)"
                plain()
                +"fun $func($`nAbcdN type`,\nres: $VecCbool = $VecCbool()): $VecCbool = Companion.$func($abcdN,\n$nAbcdN) { $`xyzw Boolean` -> res($xyzw) }"
                plain()
                "inline fun <R> $func(n: $MatID, res: ($`xyzw Boolean`) -> R): R" {
                    +contract
                    +"return Companion.$func($abcdN,\n$`n,abcdN`, res)"
                }
                plain()
                "inline fun <R> $func($`nAbcdN type`, res: ($`xyzw Boolean`) -> R): R" {
                    +contract
                    +"return Companion.$func($abcdN,\n$nAbcdN, res)"
                }

                if (type !in floatingPointTypes)
                    continue

                epsilon()
                +"fun $func(n: $MatID, epsilon: $type, res: $VecCbool = $VecCbool()): $VecCbool = $func($`n,abcdN`, epsilon, res)"
                epsilon(y = "n[AbcdN]")
                +"fun $func($`nAbcdN type`,\nepsilon: $type, res: $VecCbool = $VecCbool()): $VecCbool = Companion.$func($abcdN,\n$nAbcdN,\nepsilon) { $`xyzw Boolean` -> res($xyzw) }"
                epsilon(epsilon = "epsilon[$xyzw]")
                +"fun $func(n: $MatID, epsilon: $VecCid, res: $VecCbool = $VecCbool()): $VecCbool = $func($`n,abcdN`,\n$`epsilon,xyzw`, res)"
                epsilon(y = "n[AbcdN]", epsilon = "epsilon[$Xyzw]")
                +"fun $func($`nAbcdN type`,\n$`epsilonXyzw type`,\nres: $VecCbool = $VecCbool()): $VecCbool = Companion.$func($abcdN,\n$nAbcdN,\n$epsilonXyzw) { $`xyzw Boolean` -> res($xyzw) }"
                epsilon()
                "inline fun <R> $func(n: $MatID, epsilon: $type, res: ($`xyzw Boolean`) -> R): R" {
                    +contract
                    +"return Companion.$func($abcdN,\n$`n,abcdN`, epsilon, res)"
                }
                epsilon(y = "n[AbcdN]")
                "inline fun <R> $func($`nAbcdN type`, epsilon: $type, res: ($`xyzw Boolean`) -> R): R" {
                    +contract
                    +"return Companion.$func($abcdN,\n$nAbcdN, epsilon, res)"
                }
                epsilon(epsilon = "epsilon[$xyzw]")
                "inline fun <R> $func(n: $MatID, epsilon: $VecCid, res: ($`xyzw Boolean`) -> R): R" {
                    +contract
                    +"return Companion.$func($abcdN,\n$`n,abcdN`, $`epsilon,xyzw`, res)"
                }
                epsilon(y = "n[AbcdN]", epsilon = "epsilon[$Xyzw]")
                "inline fun <R> $func($`nAbcdN type`,\n$`epsilonXyzw type`, res: ($`xyzw Boolean`) -> R): R" {
                    +contract
                    +"return Companion.$func($abcdN,\n$nAbcdN, $epsilonXyzw, res)"
                }
                ulps()
                +"fun $func(n: $MatID, ulps: Int, res: $VecCbool = $VecCbool()): $VecCbool = $func($`n,abcdN`, ulps, res)"
                ulps()
                +"fun $func($`nAbcdN type`,\nulps: Int, res: $VecCbool = $VecCbool()): $VecCbool = Companion.$func($abcdN,\n$nAbcdN,\nulps) { $`xyzw Boolean` -> res($xyzw) }"
                ulps()
                +"fun $func(n: $MatID, ulps: $VecCi, res: $VecCbool = $VecCbool()): $VecCbool = $func($`n,abcdN`,\n$`ulps,xyzw`, res)"
                ulps()
                +"fun $func($`nAbcdN type`,\n$`ulpsXyzw Int`,\nres: $VecCbool = $VecCbool()): $VecCbool = Companion.$func($abcdN,\n$nAbcdN,\n$ulpsXyzw) { $`xyzw Boolean` -> res($xyzw) }"
                ulps()
                "inline fun <R> $func(n: $MatID, ulps: Int, res: ($`xyzw Boolean`) -> R): R" {
                    +contract
                    +"return Companion.$func($abcdN,\n$`n,abcdN`, ulps, res)"
                }
                ulps()
                "inline fun <R> $func($`nAbcdN type`, ulps: Int, res: ($`xyzw Boolean`) -> R): R" {
                    +contract
                    +"return Companion.$func($abcdN,\n$nAbcdN, ulps, res)"
                }
                ulps()
                "inline fun <R> $func(n: $MatID, ulps: $VecCi, res: ($`xyzw Boolean`) -> R): R" {
                    +contract
                    +"return Companion.$func($abcdN,\n$`n,abcdN`, $`ulps,xyzw`, res)"
                }
                ulps()
                "inline fun <R> $func($`nAbcdN type`,\n$`ulpsXyzw Int`, res: ($`xyzw Boolean`) -> R): R" {
                    +contract
                    +"return Companion.$func($abcdN,\n$nAbcdN, $ulpsXyzw, res)"
                }
            }
            Generator.Part.CompanionObject -> {
                plain()
                "inline fun <R> $func(m: $MatID, n: $MatID, res: ($`xyzw Boolean`) -> R): R" {
                    +contract
                    +"return $func($`m,abcdN`,\n$`n,abcdN`, res)"
                }
                plain()
                "inline fun <R> $func($`mAbcdN type`,\n$`nAbcdN type`, res: ($`xyzw Boolean`) -> R): R" {
                    +contract
                    fun equal(c: Int) {
                        val mC = (0 until height).joinToString { "m${ABCD[c]}$it" }
                        val nC = (0 until height).joinToString { "n${ABCD[c]}$it" }
                        val abcdCN = (0 until height).joinToString { abcdN(c, it) }
                        val `mAbcdN func nAbcdN` = AbcdJointIndexed(columnSeparator = " $sep ") { c, r, _ -> "${abcdN(c, r)}" }
                        "Vec${height}$id.$func($mC, $nC) { $abcdCN ->".indentAndClose {
                            if (c + 1 < width)
                                equal(c + 1)
                            else
                                +"return res($`mAbcdN func nAbcdN`)"
                        }
                    }
                    equal(0)
                }

                if (type !in floatingPointTypes)
                    continue

                // epsilon $type
                epsilon("m", "n")
                "inline fun <R> $func(m: $MatID, n: $MatID, epsilon: $type, res: ($`xyzw Boolean`) -> R): R" {
                    +contract
                    +"return $func($`m,abcdN`,\n$`n,abcdN`, epsilon, res)"
                }
                epsilon("m[abcdN]", "n[abcdN]")
                "inline fun <R> $func($`mAbcdN type`,\n$`nAbcdN type`, epsilon: $type, res: ($`xyzw Boolean`) -> R): R" {
                    +contract
                    fun equal(c: Int) {
                        val mC = (0 until height).joinToString { "m${ABCD[c]}$it" }
                        val nC = (0 until height).joinToString { "n${ABCD[c]}$it" }
                        val abcdCN = (0 until height).joinToString { abcdN(c, it) }
                        val `mAbcdN func nAbcdN` = AbcdJointIndexed(columnSeparator = " $sep ") { c, r, _ -> "${abcdN(c, r)}" }
                        "Vec${height}$id.$func($mC, $nC, epsilon) { $abcdCN ->".indentAndClose {
                            if (c + 1 < width)
                                equal(c + 1)
                            else
                                +"return res($`mAbcdN func nAbcdN`)"
                        }
                    }
                    equal(0)
                }

                // epsilon $VecID
                epsilon("m", "n")
                "inline fun <R> $func(m: $MatID, n: $MatID, epsilon: $VecCid, res: ($`xyzw Boolean`) -> R): R" {
                    +contract
                    +"return $func($`m,abcdN`,\n$`n,abcdN`,\n$`epsilon,xyzw`, res)"
                }
                epsilon("m[abcdN]", "n[abcdN]", "epsilon[$xyzw]")
                "inline fun <R> $func($`mAbcdN type`,\n$`nAbcdN type`,\n$`epsilonXyzw type`, res: ($`xyzw Boolean`) -> R): R" {
                    +contract
                    fun equal(c: Int) {
                        val mC = (0 until height).joinToString { "m${ABCD[c]}$it" }
                        val nC = (0 until height).joinToString { "n${ABCD[c]}$it" }
                        val abcdCN = (0 until height).joinToString { abcdN(c, it) }
                        val `mAbcdN func nAbcdN` = AbcdJointIndexed(columnSeparator = " $sep ") { c, r, _ -> "${abcdN(c, r)}" }
                        "Vec${height}$id.$func($mC, $nC, epsilon${XYZW[c]}) { $abcdCN ->".indentAndClose {
                            if (c + 1 < width)
                                equal(c + 1)
                            else
                                +"return res($`mAbcdN func nAbcdN`)"
                        }
                    }
                    equal(0)
                }

                // ulps Int
                ulps()
                "inline fun <R> $func(m: $MatID, n: $MatID, ulps: Int, res: ($`xyzw Boolean`) -> R): R" {
                    +contract
                    +"return $func($`m,abcdN`,\n$`n,abcdN`, ulps, res)"
                }
                ulps()
                "inline fun <R> $func($`mAbcdN type`,\n$`nAbcdN type`, ulps: Int, res: ($`xyzw Boolean`) -> R): R" {
                    +contract
                    fun equal(c: Int) {
                        val mC = (0 until height).joinToString { "m${ABCD[c]}$it" }
                        val nC = (0 until height).joinToString { "n${ABCD[c]}$it" }
                        val abcdCN = (0 until height).joinToString { abcdN(c, it) }
                        val `mAbcdN func nAbcdN` = AbcdJointIndexed(columnSeparator = " $sep ") { c, r, _ -> "${abcdN(c, r)}" }
                        "Vec${height}$id.$func($mC, $nC, ulps) { $abcdCN ->".indentAndClose {
                            if (c + 1 < width)
                                equal(c + 1)
                            else
                                +"return res($`mAbcdN func nAbcdN`)"
                        }
                    }
                    equal(0)
                }

                // ulps VecNi
                ulps()
                "inline fun <R> $func(m: $MatID, n: $MatID, ulps: $VecCi, res: ($`xyzw Boolean`) -> R): R" {
                    +contract
                    +"return $func($`m,abcdN`,\n$`n,abcdN`, $`ulps,xyzw`, res)"
                }
                ulps()
                "inline fun <R> $func($`mAbcdN type`,\n$`nAbcdN type`, $`ulpsXyzw Int`, res: ($`xyzw Boolean`) -> R): R" {
                    +contract
                    fun equal(c: Int) {
                        val mC = (0 until height).joinToString { "m${ABCD[c]}$it" }
                        val nC = (0 until height).joinToString { "n${ABCD[c]}$it" }
                        val abcdCN = (0 until height).joinToString { abcdN(c, it) }
                        val `mAbcdN func nAbcdN` = AbcdJointIndexed(columnSeparator = " $sep ") { c, r, _ -> "${abcdN(c, r)}" }
                        "Vec${height}$id.$func($mC, $nC, ulps${XYZW[c]}) { $abcdCN ->".indentAndClose {
                            if (c + 1 < width)
                                equal(c + 1)
                            else
                                +"return res($`mAbcdN func nAbcdN`)"
                        }
                    }
                    equal(0)
                }
            }
            else -> Unit
        }
    }
}