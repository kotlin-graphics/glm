package glm_.detail

import glm_.*
import glm_.gen.Generator
import glm_.gen.Generator.Part
import glm_.gen.matrixSize

fun Generator.binary(ordinal: Int, type: String, extension: String, id: String, vec: String, part: Part) {

    val promotedType = when (type) {
        "Byte", "Short" -> "Int"
        "UByte", "UShort" -> "UInt"
        else -> type
    }
    val VecID = vec + id

    val xyzw = xyzwJoint()
    val `xyzw type` = xyzwJoint { "$it: $type" }
    val `a,xyzw` = xyzwJoint { "a.$it" }
    val `b,xyzw` = xyzwJoint { "b.$it" }
    val `bXYZW type` = XyzwJoint { "b$it: $type" }
    val resXYZW = XyzwJoint { "res$it" }
    val `resXYZW type` = XyzwJoint { "res$it: $type" }
    val `resXYZW promotedType` = XyzwJoint { "res$it: $promotedType" }
    val scalarJoint = xyzwJoint { "scalar" }
    val `v,xyzw` = xyzwJoint { "v.$it" }
    val `v,xyzw type` = xyzwJoint { "v.$it: $type" }
    val `vXYZW type` = XyzwJoint { "v$it: $type" }
    val `v,xJoint` = xyzwJoint { "v.x" }
    val `this,xyzw` = xyzwJoint { "this.$it" }

    when (part) {
        Part.Class -> {
            +"// Binary operators\n"

            for ((operator, operation) in operators) {
                +"infix operator fun $operation(scalar: $type): $VecID = $operation($scalarJoint, $VecID())"

                if (ordinal > 1)
                    +"""
                        fun $operation(scalar: $type, res: $VecID): $VecID = $operation($scalarJoint, res)
                        inline fun $operation(scalar: $type, res: ($`resXYZW promotedType`) -> Unit) {
                            $contract
                            Companion.$operation($xyzw, $scalarJoint, res)
                        }"""

                +"""
                    infix operator fun $operation(v: Vec1$id): $VecID = $operation($`v,xJoint`, $VecID())
                    fun $operation(v: Vec1$id, res: $VecID): $VecID = $operation($`v,xJoint`, res)
                    inline fun $operation(v: Vec1$id, res: ($`resXYZW promotedType`) -> Unit) {
                        $contract
                        Companion.$operation($xyzw, $`v,xJoint`, res)
                    }"""

                if (ordinal > 1)
                    +"""
                        infix operator fun $operation(v: $VecID): $VecID = $operation($`v,xyzw`, $VecID())
                        fun $operation(v: $VecID, res: $VecID): $VecID = $operation($`v,xyzw`, res)
                        inline fun $operation(v: $VecID, res: ($`resXYZW promotedType`) -> Unit) {
                            $contract
                            Companion.$operation($xyzw, $`v,xyzw`, res)
                        }"""

                //                +"fun $opName($`xyzw type`, res: $VecID): $VecID = res($args)"
                +"""
                    fun $operation($`xyzw type`, res: $VecID): $VecID = Companion.$operation($`this,xyzw`, $xyzw) { $`resXYZW type` -> res($resXYZW) }
                    inline fun $operation($`xyzw type`, res: ($`resXYZW promotedType`) -> Unit) {
                        $contract
                        Companion.$operation($xyzw, $xyzw, res)
                    }"""

                if (ordinal > 1 && type in matrixTypes.map { it.type }) {
                    if (operator == "*")
                        for (i in 2..4) {
                            +"infix operator fun times(m: Mat${matrixSize(i, ordinal)}$id): Vec$i$id = times(m, Vec$i$id())"

                            var args = abcdJointIndexed(i, ordinal, ",\n", " + ") { c, r, _ -> "${glm_.xyzw[r]} * m.${glm_.abcd[c]}$r" }
                            +"fun times(m: Mat${matrixSize(i, ordinal)}$id, res: Vec$i$id): Vec$i$id = res($args)"

                            args = abcdJointIndexed(i, ordinal, ",\n", " + ") { c, r, _ -> "${glm_.xyzw[r]} * ${glm_.abcd[c]}$r" }
                            +"""
                                inline fun times(m: Mat${matrixSize(i, ordinal)}$id, res: (${XyzwJoint(i) { "res$it: $type" }}) -> Unit) {
                                    $contract
                                    times(${abcdJoint(i, ordinal, ",\n") { "m.$it" }}, res)
                                }
                                inline fun times(${abcdJoint(i, ordinal, ",\n") { "$it: $type" }}, res: (${XyzwJoint(i) { "res$it: $type" }}) -> Unit) {
                                    $contract
                                    res($args)
                                }"""
                        }
                    if (operator == "/" && type in floatingPointTypes) {
                        val MatID = "Mat${matrixSize(ordinal, ordinal)}$id"
                        +"infix operator fun div(m: $MatID): $VecID = div(m, $VecID())"
                        val `m,abcdN` = abcdJoint(ordinal, ordinal, ",\n") { "m.$it" }
                        val `abcdN type` = abcdJoint(ordinal, ordinal, ",\n") { "$it: $type" }
                        val abcdN = abcdJoint(ordinal, ordinal, ",\n")
                        +"""
                            fun div(m: $MatID, res: $VecID): $VecID {
                                $MatID.inverse($`m,abcdN`) { $`abcdN type` ->
                                    $VecID.times($xyzw,${'\n'}$abcdN) { $`xyzw type` ->
                                        return res($xyzw)
                                    }
                                }
                            }"""
                    }
                }
            }
        }
        Part.CompanionObject ->
            for ((operator, operation) in operators) {
                fun operators(promoted: Boolean = false) {
                    val resArgs = if (promoted) `resXYZW promotedType` else `resXYZW type`
                    if (promoted) +"@JvmName(\"$operation$promotedType\")"
                    "inline fun <R> $operation(a: $VecID, b: $VecID, res: ($resArgs) -> R): R" {
                        +contract
                        +"return $operation($`a,xyzw`, $`b,xyzw`, res)"
                    }
                    if (promoted) +"@JvmName(\"$operation$promotedType\")"
                    "inline fun <R> $operation(a: $VecID, b: $type, res: ($resArgs) -> R): R" {
                        +contract
                        +"return $operation($`a,xyzw`, ${xyzwJoint { "b" }}, res)"
                    }
                    if (promoted) +"@JvmName(\"$operation$promotedType\")"
                    "inline fun <R> $operation($`xyzw type`, $`bXYZW type`, res: ($resArgs) -> R): R" {
                        +contract
                        val (prefix, postfix) = when {
                            `resXYZW type` != `resXYZW promotedType` && !promoted -> "(" to ").$extension"
                            else -> "" to ""
                        }
                        +"return res(${xyzwJoint { "$prefix$it $operator b${it.toUpperCase()}$postfix" }})"
                    }

                    val nl = '\n'
                    if (ordinal > 1 && type in matrixTypes.map { it.type }) {
                        if (operator == "*")
                            for (i in 2..4) {
                                val MatID = "Mat${matrixSize(i, ordinal)}$id"
                                val `m,abcdN` = abcdJoint(i, ordinal, ",\n") { "m.$it" }
                                val `abcdN type` = abcdJoint(i, ordinal, ",\n") { "$it: $type" }
                                val `resXyzw type` = XyzwJoint(i) { "res$it: $type" }
                                val args = abcdJointIndexed(i, ordinal, columnSeparator = " + ") { c, r, _ ->
                                    "v${glm_.xyzw[r].toUpperCase()} * ${glm_.abcd[c]}$r"
                                }
                                +"""
                                    inline fun <R> times(v: $VecID, m: $MatID, res: ($`resXyzw type`) -> R): R {
                                        $contract
                                        return times($`v,xyzw`,$nl$`m,abcdN`, res)
                                    }
                                    inline fun <R> times($`vXYZW type`,$nl$`abcdN type`, res: ($`resXyzw type`) -> R): R {
                                        $contract
                                        return res($args)
                                    }"""
                            }
                        if (operator == "/" && type in floatingPointTypes) {
                            val MatID = "Mat${matrixSize(ordinal, ordinal)}$id"
                            val `m,abcdN` = abcdJoint(ordinal, ordinal, ",\n") { "m.$it" }
                            val `abcdN type` = abcdJoint(ordinal, ordinal, ",\n") { "$it: $type" }
                            val abcdN = abcdJoint(ordinal, ordinal, ",\n")
                            +"""
                                inline fun <R> div(v: $VecID, m: $MatID, res: ($`xyzw type`) -> R): R {
                                    $contract
                                    $MatID.inverse($`m,abcdN`) { $`abcdN type` ->
                                        $VecID.times($`v,xyzw`,$nl$abcdN) { $`xyzw type` -> 
                                            return res($xyzw)
                                        }
                                    }
                                }"""
                        }
                    }
                }
                operators()
                if (`resXYZW type` != `resXYZW promotedType`)
                    operators(true)
            }
        Part.Scalar -> {
            +"// Binary operators"
            if (type in numberTypes)
                for ((sign, operator) in operators) {
                    +"operator fun $type.$operator(v: $VecID) = $VecID(${xyzwJoint { "this $sign v.$it" }})"
                    if (ordinal > 1)
                        +"operator fun Vec1$id.$operator(v: $VecID) = $VecID(${xyzwJoint { "x $sign v.$it" }})"
                }
        }
    }
}