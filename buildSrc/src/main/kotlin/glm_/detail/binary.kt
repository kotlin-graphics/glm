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

    val `xyzw type` = xyzwJoint { "$it: $type" }
    val `a,xyzw` = xyzwJoint { "a.$it" }
    val `b,xyzw` = xyzwJoint { "b.$it" }
    val `bXYZW type` = XyzwJoint { "b$it: $type" }
    val resXYZW = XyzwJoint { "res$it" }
    val `resXYZW type` = XyzwJoint { "res$it: $type" }
    val `resXYZW promotedType` = XyzwJoint { "res$it: $promotedType" }
    val scalarJoint = xyzwJoint { "scalar" }

    when (part) {
        Part.Class -> {
            +"// Binary operators\n"

            for ((sign, operation) in operators) {
                +"operator fun $operation(scalar: $type): $VecID = $operation($scalarJoint, $VecID())"

                if (ordinal > 1) {
                    +"fun $operation(scalar: $type, res: $VecID): $VecID = $operation($scalarJoint, res)"
                    "inline fun $operation(scalar: $type, res: ($`resXYZW promotedType`) -> Unit)" {
                        contract
                        +"Companion.$operation($xyzw, $scalarJoint, res)"
                    }
                }
                val `v,xJoint` = xyzwJoint { "v.x" }
                +"operator fun $operation(v: Vec1$id): $VecID = $operation($`v,xJoint`, $VecID())"
                +"fun $operation(v: Vec1$id, res: $VecID): $VecID = $operation($`v,xJoint`, res)"
                "inline fun $operation(v: Vec1$id, res: ($`resXYZW promotedType`) -> Unit)" {
                    contract
                    +"Companion.$operation($xyzw, $`v,xJoint`, res)"
                }
                if (ordinal > 1) {
                    val `v,xyzw` = xyzwJoint { "v.$it" }
                    +"operator fun $operation(v: $VecID): $VecID = $operation($`v,xyzw`, $VecID())"
                    +"fun $operation(v: $VecID, res: $VecID): $VecID = $operation($`v,xyzw`, res)"
                    "inline fun $operation(v: $VecID, res: ($`resXYZW promotedType`) -> Unit)" {
                        contract
                        +"Companion.$operation($xyzw, $`v,xyzw`, res)"
                    }
                }
                val `this,xyzw` = xyzwJoint { "this.$it" }
                //                +"fun $opName($`xyzw type`, res: $VecID): $VecID = res($args)"
                +"fun $operation($`xyzw type`, res: $VecID): $VecID = Companion.$operation($`this,xyzw`, $xyzw) { $`resXYZW type` -> res($resXYZW) }"
                "inline fun $operation($`xyzw type`, res: ($`resXYZW promotedType`) -> Unit)" {
                    contract
                    +"Companion.$operation($xyzw, $xyzw, res)"
                }
                if (ordinal > 1 && type in matrixTypes.map { it.type })
                    when (sign) {
                        "*" -> for (i in 2..4) {
                            +"operator fun times(m: Mat${matrixSize(i, ordinal)}$id): Vec$i$id = times(m, Vec$i$id())"
                            var args = xyzwJointIndexed(i, ",\n") { j, _ ->
                                (0 until ordinal).joinToString(" + ") { "${glm_.xyzw[it]} * m.${glm_.abcd[j]}$it" }
                            }
                            +"fun times(m: Mat${matrixSize(i, ordinal)}$id, res: Vec$i$id): Vec$i$id = res($args)"
                            "inline fun times(m: Mat${matrixSize(i, ordinal)}$id, res: (${XyzwJoint(i) { "res$it: $type" }}) -> Unit)" {
                                contract
                                +"times(${abcdJoint(i, ordinal, ",\n") { c -> "m.$c" }}, res)"
                            }
                            "inline fun times(${abcdJoint(i, ordinal, ",\n") { c -> "$c: $type" }}, res: (${XyzwJoint(i) { "res$it: $type" }}) -> Unit)" {
                                contract
                                args = xyzwJointIndexed(i, ",\n") { j, _ ->
                                    (0 until ordinal).joinToString(" + ") { "${glm_.xyzw[it]} * ${glm_.abcd[j]}$it" }
                                }
                                +"res($args)"
                            }
                        }
                        "/" -> {
                            +"operator fun div(m: Mat${matrixSize(ordinal, ordinal)}$id): $VecID = div(m, $VecID())"
                            val args = xyzwJointIndexed(ordinal, ",\n") { j, _ ->
                                (0 until ordinal).joinToString(" + ") { "${glm_.xyzw[it]} * i$j$it" }
                            }
                            "fun div(m: Mat${matrixSize(ordinal, ordinal)}$id, res: $VecID): $VecID" {
                                invertMatrix(ordinal, type)
                                +"return res($args)"
                            }
                        }
                    }
            }
        }
        Part.CompanionObject ->
            for ((opChar, op) in operators) {
                fun operators(promoted: Boolean = false) {
                    val resArgs = if (promoted) `resXYZW promotedType` else `resXYZW type`
                    if (promoted) +"@JvmName(\"$op$promotedType\")"
                    "inline fun <R> $op(a: $VecID, b: $VecID, res: ($resArgs) -> R): R" {
                        contract
                        +"return $op($`a,xyzw`, $`b,xyzw`, res)"
                    }
                    if (promoted) +"@JvmName(\"$op$promotedType\")"
                    "inline fun <R> $op(a: $VecID, b: $type, res: ($resArgs) -> R): R" {
                        contract
                        +"return $op($`a,xyzw`, ${xyzwJoint { "b" }}, res)"
                    }
                    if (promoted) +"@JvmName(\"$op$promotedType\")"
                    "inline fun <R> $op($`xyzw type`, $`bXYZW type`, res: ($resArgs) -> R): R" {
                        this.contract
                        val (prefix, postfix) = when {
                            `resXYZW type` != `resXYZW promotedType` && !promoted -> "(" to ").$extension"
                            else -> "" to ""
                        }
                        +"return res(${xyzwJoint { "$prefix$it $opChar b${it.toUpperCase()}$postfix" }})"
                    }
                }
                operators()
                if (`resXYZW type` != `resXYZW promotedType`)
                    operators(true)
            }
        Part.Scalar -> {
            +"// Binary operators"
            if (type in numberTypes)
                for ((operatorChar, operatorName) in operators) {
                    +"operator fun $type.$operatorName(v: $VecID) = $VecID(${xyzwJoint { "this $operatorChar v.$it" }})"
                    if (ordinal > 1)
                        +"operator fun Vec1$id.$operatorName(v: $VecID) = $VecID(${xyzwJoint { "x $operatorChar v.$it" }})"
                }
        }
    }
}