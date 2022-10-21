package glm_.ext

import glm_.gen.Generator
import glm_.`1`
import glm_.floatingPointTypes

fun Generator.matrixCommon(width: Int, height: Int, type: String, extension: String, id: String, part: Generator.Part) {

    if (width != height || type !in floatingPointTypes)
        return

    +"// func ext matrixCommon\n"

    val MatID = "Mat$matrixSize$id"
    val `m,abcdN` = abcdJoint(rowSeparator = ",\n") { "m.$it" }
    val `mAbcdN type` = AbcdJoint(rowSeparator = ",\n") { "m$it: $type" }
    val mAbcdN = AbcdJoint(rowSeparator = ",\n") { "m$it" }
    val `xAbcdN type` = AbcdJoint(rowSeparator = ",\n") { "x$it: $type" }
    val xAbcdN = AbcdJoint(rowSeparator = ",\n") { "x$it" }
    val zAbcdN = AbcdJoint(rowSeparator = ",\n") { "z$it" }
    val `yAbcdN type` = AbcdJoint(rowSeparator = ",\n") { "y$it: $type" }
    val yAbcdN = AbcdJoint(rowSeparator = ",\n") { "y$it" }
    val `o,abcdN` = abcdJoint(rowSeparator = ",\n") { "o.$it" }
    val `zAbcdN type` = AbcdJoint(rowSeparator = ",\n") { "z$it: $type" }
    val `omAbcdN type` = AbcdJoint(rowSeparator = ",\n") { "om$it: $type" }
    val omAbcdN = AbcdJoint(rowSeparator = ",\n") { "om$it" }
    val `n,abcdN` = abcdJoint(rowSeparator = ",\n") { "n.$it" }
    val `nAbcdN type` = AbcdJoint(rowSeparator = ",\n") { "n$it: $type" }
    val nAbcdN = AbcdJoint(rowSeparator = ",\n") { "n$it" }
    val `abcdN type` = abcdJoint(rowSeparator = ",\n") { "$it: $type" }
    val abcdN = abcdJoint(rowSeparator = ",\n")

    val nl = '\n'
    when(part) {
        Generator.Part.Class -> {
            +"fun mix(m: $MatID, o: $type, res: $MatID = $MatID()): $MatID = Companion.mix($abcdN,$nl$`m,abcdN`, o) { $`abcdN type` -> res($abcdN) }"
            +"""
                inline fun <R> mix(m: $MatID, o: $type, res: ($`abcdN type`) -> R): R {
                    $contract
                    return Companion.mix($abcdN,$nl$`m,abcdN`, o, res) 
                }"""
            +"fun mix($`mAbcdN type`, o: $type, res: $MatID = $MatID()): $MatID = Companion.mix($abcdN,$nl$mAbcdN, o) { $`abcdN type` -> res($abcdN) }"
            +"""
                inline fun <R> mix($`mAbcdN type`, o: $type, res: ($`abcdN type`) -> R): R {
                    $contract
                    return Companion.mix($abcdN,$nl$mAbcdN, o, res) 
                }"""
        }
        Generator.Part.CompanionObject -> {
            +"""
                inline fun <R> mix(m: $MatID, n: $MatID, o: $type, res: ($`abcdN type`) -> R): R {
                    $contract
                    return mix($`m,abcdN`,
                               $`n,abcdN`, o, res)
                }"""
            +"""
                inline fun <R> mix($`xAbcdN type`,$nl$`yAbcdN type`, o: $type, res: ($`abcdN type`) -> R): R {
                    $contract
                    $MatID.times($xAbcdN, ${type.`1`} - o) { $`mAbcdN type` ->
                        $MatID.times($yAbcdN, o) { $`nAbcdN type` ->
                            $MatID.plus($mAbcdN,$nl$nAbcdN) { $`abcdN type` ->
                                return res($abcdN)
                            }
                        }
                    }
                }"""

            +"""
                inline fun <R> mix(m: $MatID, n: $MatID, o: $MatID, res: ($`abcdN type`) -> R): R {
                    $contract
                    return mix($`m,abcdN`,
                               $`n,abcdN`,
                               $`o,abcdN`, res)
                }"""
            +"""
                inline fun <R> mix($`xAbcdN type`,$nl$`yAbcdN type`,$nl$`zAbcdN type`, res: ($`abcdN type`) -> R): R {
                    $contract
                    ${type.`1`}.minus($zAbcdN) { $`omAbcdN type` ->
                        $MatID.compMult($xAbcdN,$nl$omAbcdN) { $`mAbcdN type` ->
                            $MatID.compMult($yAbcdN,$nl$zAbcdN) { $`nAbcdN type` ->
                                $MatID.plus($mAbcdN,$nl$nAbcdN) { $`abcdN type` ->
                                    return res($abcdN)
                                }
                            }
                        }
                    }
                }"""
        }
        else -> Unit
    }
}