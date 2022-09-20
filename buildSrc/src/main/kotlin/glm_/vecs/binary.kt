package glm_

fun Generator.binary(ordinal: Int, type: String, extension: String, id: String, vec: String) {

    +"// Binary operators\n"
    val VecID = vec + id
    for ((operatorChar, operatorName) in operators) {
        +"operator fun $operatorName(scalar: $type): $VecID = $operatorName(${xyzwJoint { "scalar" }}, $VecID())"

        val t = when (type) {
            "Byte", "Short" -> "Int"
            "UByte", "UShort" -> "UInt"
            else -> type
        }
        val unrolledPlain = xyzwJoint { it }
        if (ordinal > 1) {
            val unrolled = xyzwJoint { "scalar" }
            +"fun $operatorName(scalar: $type, res: $VecID): $VecID = $operatorName($unrolled, res)"
            "inline fun $operatorName(scalar: $type, res: (${XyzwJoint { "res$it: $t" }}) -> Unit)" {
                contract
                +"$operatorName($unrolledPlain, $unrolled, res)"
            }
        }
        var unrolled = xyzwJoint { "v.x" }
        +"operator fun $operatorName(v: Vec1$id): $VecID = $operatorName($unrolled, $VecID())"
        +"fun $operatorName(v: Vec1$id, res: $VecID): $VecID = $operatorName($unrolled, res)"
        "inline fun $operatorName(v: Vec1$id, res: (${XyzwJoint { "res$it: $t" }}) -> Unit)" {
            contract
            +"$operatorName(${unrolledPlain}, $unrolled, res)"
        }
        if (ordinal > 1) {
            unrolled = xyzwJoint { "v.$it" }
            +"operator fun $operatorName(v: $VecID): $VecID = $operatorName($unrolled, $VecID())"
            +"fun $operatorName(v: $VecID, res: $VecID): $VecID = $operatorName($unrolled, res)"
            "inline fun $operatorName(v: $VecID, res: (${XyzwJoint { "res$it: $t" }}) -> Unit)" {
                contract
                +"$operatorName(${unrolledPlain}, $unrolled, res)"
            }
        }
        var args = xyzwJoint { "this.$it $operatorChar $it" }
        +"fun $operatorName(${xyzwJoint { "$it: $type" }}, res: $VecID): $VecID = res($args)"
        "inline fun $operatorName(${xyzwJoint { "$it: $type" }}, res: (${XyzwJoint { "res$it: $t" }}) -> Unit)" {
            contract
            +"$operatorName(${unrolledPlain}, ${unrolledPlain}, res)"
        }
        if (ordinal > 1 && type in matrixTypes.map { it.type })
            if (operatorChar == "*")
                for (i in 2..4) {
                    +"operator fun times(m: Mat${matrixSize(i, ordinal)}$id): Vec$i$id = times(m, Vec$i$id())"
                    args = xyzwJointIndexed(i, ",\n") { j, _ ->
                        (0 until ordinal).joinToString(" + ") { "${xyzw[it]} * m.${abcd[j]}$it" }
                    }
                    +"fun times(m: Mat${matrixSize(i, ordinal)}$id, res: Vec$i$id): Vec$i$id = res($args)"
                    "inline fun times(m: Mat${matrixSize(i, ordinal)}$id, res: (${XyzwJoint(i) { "res$it: $type" }}) -> Unit)" {
                        contract
                        +"times(${abcdJoint(i, ordinal, ",\n") { c -> "m.$c" }}, res)"
                    }
                    "inline fun times(${abcdJoint(i, ordinal, ",\n") { c -> "$c: $type" }}, res: (${XyzwJoint(i) { "res$it: $type" }}) -> Unit)" {
                        contract
                        args = xyzwJointIndexed(i, ",\n") { j, _ ->
                            (0 until ordinal).joinToString(" + ") { "${xyzw[it]} * ${abcd[j]}$it" }
                        }
                        +"res($args)"
                    }
                }
            else if (operatorChar == "/") {
                +"operator fun div(m: Mat${matrixSize(ordinal, ordinal)}$id): $VecID = div(m, $VecID())"
                args = xyzwJointIndexed(ordinal, ",\n") { j, _ ->
                    (0 until ordinal).joinToString(" + ") { "${xyzw[it]} * i$j$it" }
                }
                "fun div(m: Mat${matrixSize(ordinal, ordinal)}$id, res: $VecID): $VecID" {
                    invertMatrix(ordinal, type)
                    +"return res($args)"
                }
            }
    }
}