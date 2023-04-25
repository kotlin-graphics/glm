package glm_.generators.detail

import glm_.generators.gen.Generator
import glm_.generators.gen.Generator.Part
import glm_.generators.gen.matrixSize
import glm_.generators.*

fun Generator.binary(ordinal: Int, type: Type, vec: String, part: Part) {

    val promotedType = type.promoted
    val id = type.id
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

                if (ordinal > 1 && type in matrixTypes) {
                    if (operator == "*")
                        for (i in 2..4) {
                            +"infix operator fun times(m: Mat${matrixSize(i, ordinal)}$id): Vec$i$id = times(m, Vec$i$id())"

                            var args = abcdJointIndexed(i, ordinal, ",\n", " + ") { c, r, _ -> "${glm_.generators.xyzw[r]} * m.${abcd[c]}$r" }
                            +"fun times(m: Mat${matrixSize(i, ordinal)}$id, res: Vec$i$id): Vec$i$id = res($args)"

                            args = abcdJointIndexed(i, ordinal, ",\n", " + ") { c, r, _ -> "${glm_.generators.xyzw[r]} * ${abcd[c]}$r" }
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
                            `resXYZW type` != `resXYZW promotedType` && !promoted -> "(" to ").${type.extension}"
                            else -> "" to ""
                        }
                        +"return res(${xyzwJoint { "$prefix$it $operator b${it.toUpperCase()}$postfix" }})"
                    }

                    val nl = '\n'
                    if (ordinal > 1 && type in matrixTypes) {
                        if (operator == "*")
                            for (i in 2..4) {
                                val MatID = "Mat${matrixSize(i, ordinal)}$id"
                                val `m,abcdN` = abcdJoint(i, ordinal, ",\n") { "m.$it" }
                                val `abcdN type` = abcdJoint(i, ordinal, ",\n") { "$it: $type" }
                                val `resXyzw type` = XyzwJoint(i) { "res$it: $type" }
                                val args = abcdJointIndexed(i, ordinal, columnSeparator = " + ") { c, r, _ ->
                                    "v${glm_.generators.xyzw[r].toUpperCase()} * ${abcd[c]}$r"
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

fun Generator.binary(width: Int, height: Int, type: Type, vec: String, part: Part) {
    val id = type.id

    var size = if (width == height) "$width" else "${width}x$height"
    val MatID = "Mat$size$id"

    val `abcdN type` = abcdJoint(rowSeparator = ",\n") { "$it: $type" }
    val `iAbcdN type` = AbcdJoint(rowSeparator = ",\n") { "i$it: $type" }
    val iAbcdN = AbcdJoint(rowSeparator = ",\n") { "i$it" }
    val abcdN = abcdJoint(rowSeparator = ",\n")
    val `mAbcdN type` = AbcdJoint(rowSeparator = ",\n") { "m$it: $type" }
    val `nAbcdN type` = AbcdJoint(rowSeparator = ",\n") { "n$it: $type" }
    val mAbcdN = AbcdJoint(rowSeparator = ",\n") { "m$it" }
    val nAbcdN = AbcdJoint(rowSeparator = ",\n") { "n$it" }
    val `m,abcdN` = abcdJoint(rowSeparator = ",\n") { "m.$it" }
    val `n,abcdN` = abcdJoint(rowSeparator = ",\n") { "n.$it" }
    val scalarJoint = abcdJoint(rowSeparator = ",\n") { "scalar" }

    if (part != Part.Scalar)
        +"// -- Binary operators --\n"

    val nl = '\n'

    when (part) {
        Part.Class ->
            for ((sign, operation) in operators) {
                +"infix operator fun $operation(scalar: $type): $MatID = $operation(scalar, $MatID())"
                +"fun $operation(scalar: $type, res: $MatID): $MatID = res(${abcdJoint(",\n") { "$it $sign scalar" }})"
                if (sign == "*") {
                    val tmp = xyzwJointIndexed(height, ",\n") { i, _ ->
                        (0 until width).joinToString(" + ") { "${abcd[it]}$i $sign v.${xyzw[it]}" }
                    }
                    +"infix operator fun times(v: Vec$width$id): Vec$height$id = times(v, Vec$height$id())"
                    +"fun times(v: Vec$width$id, res: Vec$height$id): Vec$height$id = res($tmp)"
                }
                if (sign == "*" || sign == "/") {
                    if (width == height) {
                        +"infix operator fun $operation(m: $MatID): $MatID = $operation(m, $MatID())"
                        if (sign == "*") {
                            val tmp = abcdJointIndexed(",\n") { c, r, _ -> (0 until width).joinToString(" + ") { "${abcd[it]}$r * m.${abcd[c]}$it" } }
                            +"fun times(m: $MatID, res: $MatID): $MatID = res($tmp)"
                        } else
                            "fun div(m: $MatID, res: $MatID): $MatID" {
                                invertMatrix(width, type)
                                val tmp = abcdJointIndexed(",\n") { c, r, _ -> (0 until width).joinToString(" + ") { "${abcd[it]}$r * i$c$it" } }
                                +"return res($tmp)"
                            }
                    }
                } else {
                    val tmp = abcdJoint(",\n") { "$it $sign m.$it" }
                    +"infix operator fun $operation(m: $MatID): $MatID = $MatID($tmp)"
                }
            }
        Part.CompanionObject ->
            for ((sign, operation) in operators) {
                +"""
                    inline fun <R> $operation(m: $MatID, scalar: $type, res: ($`abcdN type`) -> R): R {
                        $contract
                        return $operation($`m,abcdN`, scalar, res)
                    }"""
                val `mAbcdN sign scalar` = AbcdJoint(",\n") { "m$it $sign scalar" }
                +"""
                    inline fun <R> $operation($`mAbcdN type`, scalar: $type, res: ($`abcdN type`) -> R): R {
                        $contract
                        return res($`mAbcdN sign scalar`)
                    }"""
                if ((sign == "+" || sign == "-") && width == height) {
                    +"""
                        inline fun <R> $operation(m: $MatID, n: $MatID, res: ($`abcdN type`) -> R): R {
                            $contract
                            return $operation($`m,abcdN`,$nl$`n,abcdN`, res)
                        }"""
                    val `mAbcdN sign nAbcdN` = AbcdJoint(",\n") { "m$it $sign n$it" }
                    +"""
                        inline fun <R> $operation($`mAbcdN type`,$nl$`nAbcdN type`, res: ($`abcdN type`) -> R): R {
                            $contract
                            return res($`mAbcdN sign nAbcdN`)
                        }"""
                }

                if (type !in floatingPointTypes)
                    continue

                if (sign == "*" || (sign == "/" && width == height)) {

                    // mat * vec
                    val `vXyzw type` = XyzwJoint(width) { "v$it: $type" }
                    val vXyzw = XyzwJoint(width) { "v$it" }
                    val `xyzw type` = xyzwJoint(height) { "$it: $type" }
                    val `v,xyzw` = xyzwJoint(width) { "v.$it" }
                    // mat * vec(mat row length)
                    +"""
                        inline fun <R> $operation(m: $MatID, v: Vec$width$id, res: ($`xyzw type`) -> R): R {
                            $contract
                            return $operation($`m,abcdN`,$nl$`v,xyzw`, res)
                        }"""
                    +"""
                        inline fun <R> $operation(m: $MatID, $`vXyzw type`, res: ($`xyzw type`) -> R): R {
                            $contract
                            return $operation($`m,abcdN`,$nl$vXyzw, res)
                        }"""
                    +"""
                        inline fun <R> $operation($`mAbcdN type`, v: Vec$width$id, res: ($`xyzw type`) -> R): R {
                            $contract
                            return $operation($mAbcdN,$nl$`v,xyzw`, res)
                        }"""
                    "inline fun <R> $operation($`mAbcdN type`,$nl$`vXyzw type`, res: ($`xyzw type`) -> R): R" {
                        +contract
                        if (sign == "*") {
                            val `mAbcdN operation vXyzw` = abcdJointIndexed(height, width, ",\n", " + ") { c, r, _ -> "m${ABCD[r]}$c * v${XYZW[r]}" }
                            +"return res($`mAbcdN operation vXyzw`)"
                        } else
                            +"""
                                $MatID.inverse($mAbcdN) { $`abcdN type` ->
                                    $MatID.times($abcdN, $vXyzw) { $`vXyzw type` ->
                                        return res($vXyzw)
                                    }
                                }
                            """
                    }
                    if (sign == "/") {
                        +"""
                            inline fun <R> $operation(m: $MatID, n: $MatID, res: ($`abcdN type`) -> R): R {
                                $contract
                                return $operation($`m,abcdN`,$nl$`n,abcdN`, res)
                            }"""
                        +"""
                            inline fun <R> $operation(m: $MatID, $`nAbcdN type`, res: ($`abcdN type`) -> R): R {
                                $contract
                                return $operation($`m,abcdN`,$nl$nAbcdN, res)
                            }"""
                        +"""
                            inline fun <R> $operation($`mAbcdN type`, n: $MatID, res: ($`abcdN type`) -> R): R {
                                $contract
                                return $operation($mAbcdN,$nl$`n,abcdN`, res)
                            }"""
                        +"""
                            inline fun <R> $operation($`mAbcdN type`,$nl$`nAbcdN type`, res: ($`abcdN type`) -> R): R {
                                $MatID.inverse($nAbcdN) { $`iAbcdN type` ->
                                    $MatID.times($mAbcdN,$nl$iAbcdN) { $`abcdN type` ->
                                        return res($abcdN)
                                    }
                                }
                            }"""
                    }
                }
                if (sign == "*")
                    // mat * mat
                    for (n in 2..4) {
                        size = if (width == n) "$width" else "${n}x$width"
                        val nMatID = "Mat$size$id"
                        // we needs to overwrite all of these with the new dimensions and they have to be restored on exit, that's why they are `val`
                        val `nAbcdN type` = AbcdJoint(n, width, ",\n") { "n$it: $type" }
                        val `n,abcdN` = abcdJoint(n, width, ",\n") { "n.$it" }
                        val nAbcdN = AbcdJoint(n, width, ",\n") { "n$it" }
                        val `abcdN type` = abcdJoint(n, height, ",\n") { "$it: $type" }
                        +"""
                            inline fun <R> times(m: $MatID, n: $nMatID, res: ($`abcdN type`) -> R): R {
                                $contract
                                return times($`m,abcdN`,$nl$`n,abcdN`, res)
                            }"""
                        +"""
                            inline fun <R> times($`mAbcdN type`, n: $nMatID, res: ($`abcdN type`) -> R): R {
                                $contract
                                return times($mAbcdN,$nl$`n,abcdN`, res)
                            }"""
                        +"""
                            inline fun <R> times(m: $MatID,$nl$`nAbcdN type`, res: ($`abcdN type`) -> R): R {
                                $contract
                                return times($`m,abcdN`,$nl$nAbcdN, res)
                            }"""
                        val `mAbcdN times nAbcdN` = AbcdJointIndexed(n, height, ",\n") { c, r, _ ->
                            xyzwJointIndexed(width, " + ") { i, _ -> "m${ABCD[i]}$r * n${ABCD[c]}$i" }
                        }
                        +"""
                            inline fun <R> times($`mAbcdN type`,$nl$`nAbcdN type`, res: ($`abcdN type`) -> R): R {
                                $contract
                                return res($`mAbcdN times nAbcdN`)
                            }"""
                    }
            }
        Part.Scalar -> {}
    }
}