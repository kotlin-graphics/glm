package main

import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.Dependencies
import kotlin.math.pow

fun vectors(generator: CodeGenerator) {
    for (i in 1..4) {
        generator.createNewFile(dependencies = Dependencies(false), packageName = "glm.vec$i", fileName = "Vec${i}T").use {
            text.clear()

            vectorsT(i)

            it.write(text.toString().toByteArray())
        }
    }

    for ((type, extension, _, id) in vectorTypes) {
        for (i in 1..4) {
            generator.createNewFile(dependencies = Dependencies(false), packageName = "glm.vec$i", fileName = "Vec$i$id").use {
                text.clear()

                vectors(i, type, extension, id)

                it.write(text.toString().toByteArray())
            }
        }
    }
}

private fun vectorsT(ordinal: Int) {
    +"package glm.vec$ordinal"
    if (ordinal > 1) {
        +"import glm.extensions.swizzle.*"
        +"import glm.extensions.*"
        +"import kotlin.jvm.*"
    }

    "abstract class Vec${ordinal}T<T>" {
        xyzw(ordinal) { c -> +"abstract var $c: T" }
        xyzw(ordinal) { i, c -> +"operator fun component${i + 1}() = $c" }

        +"// -- Aliases --"

        xyzw(ordinal) { i, c ->
            +"var ${rgba[i]}: T"
            indent {
                +"get() = $c"
                "set(value)" {
                    +"$c = value"
                }
            }
        }
        xyzw(ordinal) { i, c ->
            +"var ${stpq[i]}: T"
            indent {
                +"get() = $c"
                "set(value)" {
                    +"$c = value"
                }
            }
        }

        +"// -- Component accesses --"

        "operator fun get(index: Int): T = when (index)" {
            xyzw(ordinal) { i, c -> +"$i -> $c" }
            +"else -> throw IndexOutOfBoundsException()"
        }

        "operator fun set(index: Int, value: T) = when(index)" {
            xyzw(ordinal) { i, c ->
                "$i ->" {
                    +"$c = value"
                }
            }
            +"else -> throw IndexOutOfBoundsException()"
        }


        "companion object" {
            +"const val length = $ordinal"
        }
    }

    if (ordinal > 1) {
        for (unsigned in (unsignedTypes + "out Number")) {
            +"@Suppress(\"UNCHECKED_CAST\")"
            if (unsigned != "out Number") +"@JvmName(\"dot$unsigned\")"
            "infix fun <N> Vec${ordinal}T<N>.dot(v: Vec${ordinal}T<$unsigned>): N = when (this)" {
                for ((_, _, _, id) in numberTypeInformation) {
                    +"is Vec$ordinal$id -> this.dot(v) as N"
                }
                "is Vec${ordinal}Impl -> when (x)" {
                    for ((type, extension) in numberTypeInformation) {
                        +"is $type -> (${xyzwJoint(ordinal, " + ") { c -> "($c as $type) * v.$c.$extension" }}).$extension as N"
                    }
                    +"else -> throw IllegalArgumentException(\"Can't compute dot product of non-number vectors!\")"
                }
                +"else -> throw ArithmeticException(\"Can't compute dot product of non-number vectors!\")"
            }
        }
    }
}

private fun vectors(ordinal: Int, type: String, extension: String, id: String) {
    +"@file:OptIn(kotlin.contracts.ExperimentalContracts::class)"
    +"package glm.vec$ordinal"
    +"import glm.*"
    +"import glm.extensions.*"
    +"import kotlin.jvm.*"
    +"import kotlin.math.abs"
    +"import kotlin.math.sqrt"
    repeat(4) { +"import glm.vec${it + 1}.*" }
    abcd(3, 3) { c, r, _ -> +"import glm.mat${matrixSizeString(c + 2, r + 2)}.*" }

    val vec = "Vec$ordinal"
    "open class $vec$id(var array: ${type}Array, var ofs: Int = 0) : ${vec}T<$type>()" {
        xyzw(ordinal) { i, c ->
            val delta = if (i == 0) "" else " + $i"

            +"override var $c: $type"
            indent {
                +"get() = array[ofs$delta]"
                "set(value)" {
                    +"array[ofs$delta] = value"
                }
            }
        }

        +"// Implicit basic constructors"
        +"constructor() : this(${type}Array($ordinal))"
        +"constructor(v: $vec$id) : this(${xyzwJoint(ordinal) { c -> "v.$c" }})"

        +"// Explicit basic constructors"
        val arrayOf = "${type.lowercase()}ArrayOf"
        var a = "x" * ordinal
        +"constructor(x: $type) : this(${if (ordinal == 1) "$arrayOf($a)" else a})"
        +"constructor(x: Number) : this(x.$extension)"
        if (type == "UByte" || type == "UShort") {
            +"constructor(x: UInt) : this(x.$extension)"
            +"constructor(x: ULong) : this(x.$extension)"
        }

        if (ordinal != 1) {
            +"constructor(${xyzwJoint(ordinal) { c -> "$c: $type" }}) : this($arrayOf(${xyzwJoint(ordinal) { c -> c }}))"
            if (type == "UByte" || type == "UShort") {
                +"constructor(${xyzwJoint(ordinal) { c -> "$c: UInt" }}) : this(${xyzwJoint(ordinal) { c -> "$c.$extension" }})"
                +"constructor(${xyzwJoint(ordinal) { c -> "$c: ULong" }}) : this(${xyzwJoint(ordinal) { c -> "$c.$extension" }})"
            }

            +"// Conversion scalar constructors"
            +"constructor(v: Vec1T<out Number>) : this(v.x.$extension)"

            +"// Explicit conversions (From section 5.4.1 Conversion and scalar constructors of GLSL 1.30.08 specification)"
            fun oneTypes(comp: String) = listOf("$comp: Number", "$comp: Vec1T<out Number>")
            fun value(p: String) = if (p.last() == '>') "${p[0]}.x" else p[0]
            var postfix = ".$extension"
            fun constructor(vararg arguments: String) {
                +"constructor(${arguments.joinToString()}) : this(${arguments.joinToString { "${value(it)}$postfix" }})"
                postfix = ""
            }
            for (x in oneTypes("x")) {
                for (y in oneTypes("y")) {
                    if (ordinal > 2) {
                        for (z in oneTypes("z")) {
                            if (ordinal > 3) {
                                for (w in oneTypes("w")) {
                                    constructor(x, y, z, w)
                                }
                            } else {
                                constructor(x, y, z)
                            }
                        }
                    } else {
                        constructor(x, y)
                    }
                }
            }
        }

        +"// Conversion vector constructors"
        +"// Explicit conversions (From section 5.4.1 Conversion and scalar constructors of GLSL 1.30.08 specification)"

        infix fun String.args(b: String) = +"constructor($this) : this($b)"
        val V1 = "Vec1T<out Number>"
        val V2 = "Vec2T<out Number>"
        val V3 = "Vec3T<out Number>"
        val V4 = "Vec4T<out Number>"
        val N = "Number"
        when (ordinal) {
            1 -> {
                "v: $V1" args "v.x"
                "v: $V2" args "v.x"
                "v: $V3" args "v.x"
                "v: $V4" args "v.x"
            }
            2 -> {
                "v: $V2" args "v.x, v.y"
                "v: $V3" args "v.x, v.y"
                "v: $V4" args "v.x, v.y"
            }
            3 -> {
                "xy: $V2, z: $N" args "xy.x, xy.y, z"
                "xy: $V2, z: $V1" args "xy.x, xy.y, z.x"
                "x: $N, yz: $V2" args "x, yz.x, yz.y"
                "x: $V1, yz: $V2" args "x.x, yz.x, yz.y"
                "v: $V3" args "v.x, v.y, v.z"
                "v: $V4" args "v.x, v.y, v.z"
            }
            4 -> {
                "xy: $V2, z: $N, w: $N" args "xy.x, xy.y, z, w"
                "xy: $V2, z: $V1, w: $N" args "xy.x, xy.y, z.x, w"
                "xy: $V2, z: $N, w: $V1" args "xy.x, xy.y, z, w.x"
                "xy: $V2, z: $V1, w: $V1" args "xy.x, xy.y, z.x, w.x"
                "x: $N, yz: $V2, w: $N" args "x, yz.x, yz.y, w"
                "x: $V1, yz: $V2, w: $N" args "x.x, yz.x, yz.y, w"
                "x: $N, yz: $V2, w: $V1" args "x, yz.x, yz.y, w.x"
                "x: $V1, yz: $V2, w: $V1" args "x.x, yz.x, yz.y, w.x"
                "x: $N, y: $N, zw: $V2" args "x, y, zw.x, zw.y"
                "x: $V1, y: $N, zw: $V2" args "x.x, y, zw.x, zw.y"
                "x: $N, y: $V1, zw: $V2" args "x, y.x, zw.x, zw.y"
                "x: $V1, y: $V1, zw: $V2" args "x.x, y.x, zw.x, zw.y"
                "xyz: $V3, w: $N" args "xyz.x, xyz.y, xyz.z, w"
                "xyz: $V3, w: $V1" args "xyz.x, xyz.y, xyz.z, w.x"
                "x: $N, yzw: $V3" args "x, yzw.x, yzw.y, yzw.z"
                "x: $V1, yzw: $V3" args "x.x, yzw.x, yzw.y, yzw.z"
                "xy: $V2, zw: $V2" args "xy.x, xy.y, zw.x, zw.y"
                "v: $V4" args "v.x, v.y, v.z, v.w"
            }
        }

        if (type in numberTypes) {
            +"// Unary arithmetic operators"
            for ((operatorChar, operatorName) in operators) {
                if ("Byte" in type || "Short" in type) {
                    for (scalar in listOf(N, type)) {
                        +"operator fun ${operatorName}Assign(scalar: $scalar) = ${operatorName}Assign(scalar.${if (type in unsignedTypes) "u" else ""}i)"
                    }
                } else {
                    +"operator fun ${operatorName}Assign(scalar: $N) = ${operatorName}Assign(scalar.$extension)"
                    "operator fun ${operatorName}Assign(scalar: $type)" {
                        xyzw(ordinal) { c ->
                            when {
                                "Byte" in type || "Short" in type -> +"$c = ($c $operatorChar scalar).$extension"
                                else -> +"$c $operatorChar= scalar"
                            }
                        }
                    }
                }
                if ("Byte" in type || "Short" in type) {
                    "operator fun ${operatorName}Assign(scalar: ${if (type[0] == 'U') "UInt" else "Int"})" {
                        xyzw(ordinal) { c -> +"$c = ($c $operatorChar scalar).$extension" }
                    }
                    if (type in unsignedTypes)
                        +"operator fun ${operatorName}Assign(scalar: ULong) = ${operatorName}Assign(scalar.$extension)"
                } else if (type in unsignedTypes)
                    if (type == "UInt")
                        +"operator fun ${operatorName}Assign(scalar: ULong) = ${operatorName}Assign(scalar.ui)"
                    else +"operator fun ${operatorName}Assign(scalar: UInt) = ${operatorName}Assign(scalar.ul)"
                "operator fun ${operatorName}Assign(v: $V1)" {
                    xyzw(ordinal) { c ->
                        if ("Byte" in type || "Short" in type)
                            +"$c = ($c $operatorChar v.x.$extension).$extension"
                        else +"$c $operatorChar= v.x.$extension"
                    }
                }
                "operator fun ${operatorName}Assign(v: Vec1$id)" {
                    xyzw(ordinal) { c ->
                        if ("Byte" in type || "Short" in type)
                            +"$c = ($c $operatorChar v.x).$extension"
                        else +"$c $operatorChar= v.x"
                    }
                }
                if (ordinal != 1) {
                    "operator fun ${operatorName}Assign(v: Vec${ordinal}T<out Number>)" {
                        xyzw(ordinal) { c ->
                            if ("Byte" in type || "Short" in type)
                                +"$c = ($c $operatorChar v.$c.$extension).$extension"
                            else +"$c $operatorChar= v.$c.$extension"
                        }
                    }
                    "operator fun ${operatorName}Assign(v: $vec$id)" {
                        xyzw(ordinal) { c ->
                            if ("Byte" in type || "Short" in type)
                                +"$c = ($c $operatorChar v.$c).$extension"
                            else +"$c $operatorChar= v.$c"
                        }
                    }
                }
            }

            +"// Increment and decrement operators"
            "operator fun inc(): $vec$id" {
                xyzw(ordinal) { c -> +"$c++" }
                +"return this"
            }
            "operator fun dec(): $vec$id" {
                xyzw(ordinal) { c -> +"$c--" }
                +"return this"
            }

            "operator fun invoke(${xyzwJoint(ordinal) { c -> "$c: $type" }}): $vec$id" {
                xyzw(ordinal) { c -> +"this.$c = $c" }
                +"return this"
            }
            if (type in listOf("Byte", "Short", "UByte", "UShort")) {
                val t = if (type[0] == 'U') "UInt" else "Int"
                "operator fun invoke(${xyzwJoint(ordinal) { c -> "$c: $t" }}): $vec$id" {
                    xyzw(ordinal) { c -> +"this.$c = $c.$extension" }
                    +"return this"
                }
            }

            +"// Unary bit operators TODO"
            +"// Unary operators"
            +"operator fun unaryPlus(): $vec$id = this"
            if (type !in unsignedTypes)
                +"operator fun unaryMinus(): $vec$id = $vec$id(${xyzwJoint(ordinal) { c -> "-$c" }})"

            binary(ordinal, type, extension, id, vec)
        }

        exponential(ordinal, type, extension, id, vec)
        geometric(ordinal, type, extension, id, vec)

        +"override fun equals(other: Any?) = other is $vec$id && ${xyzwJoint(ordinal, " && ") { c -> "$c == other.$c" }}"
        +"override fun hashCode() = ${xyzwJoint(ordinal, " + ") { i, c -> "${31f.pow(i).toInt()} * $c.hashCode()" }}"

        if (type == "Float" || type == "Double") {
            +"fun equal(v: $vec$id, epsilon: $type = $type.MIN_VALUE) = BooleanArray(length) { abs(array[it] - v.array[it]) <= epsilon }"
            +"fun notEqual(v: $vec$id, epsilon: $type = $type.MIN_VALUE) = BooleanArray(length) { abs(array[it] - v.array[it]) > epsilon }"
            "fun allEqual(v: $vec$id, epsilon: $type = $type.MIN_VALUE): Boolean" {
                +"for (i in 0 until length)"
                +"\tif(abs(array[i] - v.array[i]) > epsilon)"
                +"\t\treturn false"
                +"return true"
            }
            "fun anyNotEqual(v: $vec$id, epsilon: $type = $type.MIN_VALUE): Boolean" {
                +"for (i in 0 until length)"
                +"\tif(abs(array[i] - v.array[i]) > epsilon)"
                +"\t\treturn true"
                +"return false"
            }
        } else {
            +"infix fun equal(v: $vec$id) = BooleanArray(length) { array[it] == v.array[it] }"
            +"infix fun notEqual(v: $vec$id) = BooleanArray(length) { array[it] != v.array[it] }"
            +"fun allEqual(v: $vec$id): Boolean = array.contentEquals(v.array)"
            +"fun anyNotEqual(v: $vec$id): Boolean = !array.contentEquals(v.array)"
        }

        if (type == "Boolean") {
            +"// Boolean operators"
            val v = "$vec$extension"
            +"infix fun and(v: $v) = $v(${xyzwJoint(ordinal) { c -> "$c && v.$c" }})"
            +"infix fun or(v: $v) = $v(${xyzwJoint(ordinal) { c -> "$c || v.$c" }})"
        }

        "companion object" {
            +"const val length = Vec${ordinal}T.length"
            if (type in numberTypes) {
                +"const val size = length * $type.SIZE_BYTES"
                val t = when (type) {
                    "Byte", "Short" -> "Int"
                    "UByte", "UShort" -> "UInt"
                    else -> type
                }
                a = xyzwJoint(ordinal) { c -> "a${c.uppercase()}: $type" }
                var b = xyzwJoint(ordinal) { c -> "b${c.uppercase()}: $type" }
                for ((opChar, op) in operators) {
                    "inline fun $op($a,\n\t\t\t\t\t\t$b, res: (${xyzwJoint(ordinal) { c -> "res${c.uppercase()}: $t" }}) -> Unit )" {
                        contract
                        +"res(${xyzwJoint(ordinal) { c -> "a${c.uppercase()} $opChar b${c.uppercase()}" }})"
                    }
                }
                if (type in floatingPointTypes) {
                    +"fun dot($a, $b): $type = ${xyzwJoint(ordinal, " + ") { c -> "a${c.uppercase()} * b${c.uppercase()}" }}"
                    val unrolled = xyzwJoint(ordinal) { c -> "a${c.uppercase()}" }
                    +"fun length($a): $type = sqrt(dot($unrolled, $unrolled))"
                    "fun distance($a, $b): $type" {
                        +xyzwJoint(ordinal, "; ") { c -> "val d$c: $type" }
                        val d = xyzwJoint(ordinal) { c -> "a${c.uppercase()}" }
                        b = xyzwJoint(ordinal) { c -> "b${c.uppercase()}" }
                        val res = xyzwJoint(ordinal) { c -> "res${c.uppercase()}" }
                        +"minus($d, $b) { $res -> ${xyzwJoint(ordinal, "; ") { c -> "d$c = res${c.uppercase()}" }} }"
                        +"return length(${xyzwJoint(ordinal) { c -> "d$c" }})"
                    }
                    if (ordinal == 3) {
                        +"inline fun cross(x: $type, y: $type, z: $type,"
                        "\t\t\t\t vx: $type, vy: $type, vz: $type, res: (resX: $type, resY: $type, resZ: $type) -> Unit)" {
                            contract
                            +"\tres(y * vz - vy * z, z * vx - vz * x, x * vy - vx * y)"
                        }
                    }
                    val exponent = xyzwJoint(ordinal) { c -> "e$c: $type" }
                    "inline fun pow($a, $exponent, res: (${xyzwJoint(ordinal) { c -> "res${c.uppercase()}: $type" }}) -> Unit)" {
                        contract
                        +"res(${xyzwJoint(ordinal) { c -> "a${c.uppercase()} pow e$c" }})"
                    }
                    "inline fun exp($a, res: (${xyzwJoint(ordinal) { c -> "res${c.uppercase()}: $type" }}) -> Unit)" {
                        contract
                        +"res(${xyzwJoint(ordinal) { c -> "a${c.uppercase()}.exp()" }})"
                    }
                    "inline fun log($a, res: (${xyzwJoint(ordinal) { c -> "res${c.uppercase()}: $type" }}) -> Unit)" {
                        contract
                        +"res(${xyzwJoint(ordinal) { c -> "a${c.uppercase()}.ln()" }})"
                    }
                    "inline fun exp2($a, res: (${xyzwJoint(ordinal) { c -> "res${c.uppercase()}: $type" }}) -> Unit)" {
                        contract
                        +"res(${xyzwJoint(ordinal) { c -> "2${if (type == "Float") "f" else ".0"} pow a${c.uppercase()}" }})"
                    }
                    "inline fun log2($a, res: (${xyzwJoint(ordinal) { c -> "res${c.uppercase()}: $type" }}) -> Unit)" {
                        contract
                        +"res(${xyzwJoint(ordinal) { c -> "a${c.uppercase()}.log2()" }})"
                    }
                    "inline fun sqrt($a, res: (${xyzwJoint(ordinal) { c -> "res${c.uppercase()}: $type" }}) -> Unit)" {
                        contract
                        +"res(${xyzwJoint(ordinal) { c -> "a${c.uppercase()}.sqrt()" }})"
                    }
                    "inline fun inverseSqrt($a, res: (${xyzwJoint(ordinal) { c -> "res${c.uppercase()}: $type" }}) -> Unit)" {
                        contract
                        +"res(${xyzwJoint(ordinal) { c -> "a${c.uppercase()}.inverseSqrt()" }})"
                    }
                }
            }
        }
    }

    +"// Binary operators"
    if (type in numberTypes) {
        for ((operatorChar, operatorName) in operators) {
            +"operator fun $type.$operatorName(v: $vec$id) = $vec$id(${xyzwJoint(ordinal) { c -> "this $operatorChar v.$c" }})"
            if (ordinal != 1)
                +"operator fun Vec1$id.$operatorName(v: $vec$id) = $vec$id(${xyzwJoint(ordinal) { c -> "x $operatorChar v.$c" }})"
        }
    }
}

fun binary(ordinal: Int, type: String, extension: String, id: String, vec: String) {

    +"// Binary operators\n"

    for ((operatorChar, operatorName) in operators) {
        +"operator fun $operatorName(scalar: $type): $vec$id = $operatorName(${xyzwJoint(ordinal) { _ -> "scalar" }}, $vec$id())"

        val t = when (type) {
            "Byte", "Short" -> "Int"
            "UByte", "UShort" -> "UInt"
            else -> type
        }
        val unrolledPlain = xyzwJoint(ordinal) { c -> c }
        if (ordinal != 1) {
            val unrolled = xyzwJoint(ordinal) { _ -> "scalar" }
            +"fun $operatorName(scalar: $type, res: $vec$id): $vec$id = $operatorName($unrolled, res)"
            "inline fun $operatorName(scalar: $type, res: (${xyzwJoint(ordinal) { c -> "res${c.uppercase()}: $t" }}) -> Unit)" {
                contract
                +"$operatorName($unrolledPlain, $unrolled, res)"
            }
        }
        var unrolled = xyzwJoint(ordinal) { _ -> "v.x" }
        +"operator fun $operatorName(v: Vec1$id): $vec$id = $operatorName($unrolled, $vec$id())"
        +"fun $operatorName(v: Vec1$id, res: $vec$id): $vec$id = $operatorName($unrolled, res)"
        "inline fun $operatorName(v: Vec1$id, res: (${xyzwJoint(ordinal) { c -> "res${c.uppercase()}: $t" }}) -> Unit)" {
            contract
            +"$operatorName(${unrolledPlain}, $unrolled, res)"
        }
        if (ordinal != 1) {
            unrolled = xyzwJoint(ordinal) { c -> "v.$c" }
            +"operator fun $operatorName(v: $vec$id): $vec$id = $operatorName($unrolled, $vec$id())"
            +"fun $operatorName(v: $vec$id, res: $vec$id): $vec$id = $operatorName($unrolled, res)"
            "inline fun $operatorName(v: $vec$id, res: (${xyzwJoint(ordinal) { c -> "res${c.uppercase()}: $t" }}) -> Unit)" {
                contract
                +"$operatorName(${unrolledPlain}, $unrolled, res)"
            }
        }
        var args = xyzwJoint(ordinal) { c -> "this.$c $operatorChar $c" }
        +"fun $operatorName(${xyzwJoint(ordinal) { c -> "$c: $type" }}, res: $vec$id): $vec$id = res($args)"
        "inline fun $operatorName(${xyzwJoint(ordinal) { c -> "$c: $type" }}, res: (${xyzwJoint(ordinal) { c -> "res${c.uppercase()}: $t" }}) -> Unit)" {
            contract
            +"$operatorName(${unrolledPlain}, ${unrolledPlain}, res)"
        }
        if (ordinal != 1 && type in matrixTypes.map { it.type })
            if (operatorChar == "*")
                for (i in 2..4) {
                    +"operator fun times(m: Mat${matrixSizeString(i, ordinal)}$id): Vec$i$id = times(m, Vec$i$id())"
                    args = xyzwJoint(i, ",\n\t\t\t\t\t\t\t\t\t\t\t") { j, _ ->
                        (0 until ordinal).joinToString(" + ") { "${xyzw[it]} * m.${abcd[j]}$it" }
                    }
                    +"fun times(m: Mat${matrixSizeString(i, ordinal)}$id, res: Vec$i$id): Vec$i$id = res($args)"
                    "inline fun times(m: Mat${matrixSizeString(i, ordinal)}$id, res: (${xyzwJoint(i) { c -> "res${c.uppercase()}: $type" }}) -> Unit)" {
                        contract
                        +"times(${abcdJoint(i, ordinal, ",\n\t\t\t") { c -> "m.$c" }}, res)"
                    }
                    "inline fun times(${abcdJoint(i, ordinal, ",\n\t\t\t\t\t") { c -> "$c: $type" }}, res: (${xyzwJoint(i) { c -> "res${c.uppercase()}: $type" }}) -> Unit)" {
                        contract
                        args = xyzwJoint(i, ",\n\t\t\t") { j, _ ->
                            (0 until ordinal).joinToString(" + ") { "${xyzw[it]} * ${abcd[j]}$it" }
                        }
                        +"res($args)"
                    }
                }
            else if (operatorChar == "/") {
                +"operator fun div(m: Mat${matrixSizeString(ordinal, ordinal)}$id): $vec$id = div(m, $vec$id())"
                args = xyzwJoint(ordinal, ",\n\t\t\t\t\t") { j, _ ->
                    (0 until ordinal).joinToString(" + ") { "${xyzw[it]} * i$j$it" }
                }
                "fun div(m: Mat${matrixSizeString(ordinal, ordinal)}$id, res: $vec$id): $vec$id" {
                    invertMatrix(ordinal, type)
                    +"return res($args)"
                }
            }
    }
}

fun exponential(ordinal: Int, type: String, extension: String, id: String, vec: String) {

    +"\n\t// exponential\n"

    if (type in floatingPointTypes) {

        var docs = """|Returns this [$vec$id] base raised to the power [exponent].
                      |
                      |@receiver: Floating point value. pow function is defined for input values of this [$vec$id] defined in the range (inf-, inf+) in the limit of the type qualifier.
                      |@param exponent: Floating point value representing the [exponent].
                      |@see [GLSL pow man page](http://www.opengl.org/sdk/docs/manglsl/xhtml/pow.xml)
                      |@see [GLSL 4.20.8 specification, section 8.2 Exponential Functions](http://www.opengl.org/registry/doc/GLSLangSpec.4.20.8.pdf)""".trimMargin()
        docs(docs)
        val base = xyzwJoint(ordinal) { c -> c }
        val exponent = xyzwJoint(ordinal) { c -> "exponent.$c" }
        val res = xyzwJoint(ordinal) { c -> "res${c.uppercase()}" }
        +"infix fun pow(exponent: $vec$id): $vec$id { pow($base, $exponent) { $res -> return $vec$id($res) } }"
        docs(docs)
        +"fun pow(exponent: $vec$id, res: $vec$id): $vec$id { pow($base, $exponent) { $res -> return res($res) } }"


        docs = """|Returns the natural exponentiation of this [$vec$id], i.e., e^x.
                  |
                  |@receiver: exp function is defined for input values of this [$vec$id] defined in the range (inf-, inf+) in the limit of the type qualifier.
                  |@param exponent: Floating point value representing the [exponent].
                  |@see [GLSL exp man page](http://www.opengl.org/sdk/docs/manglsl/xhtml/exp.xml)
                  |@see [GLSL 4.20.8 specification, section 8.2 Exponential Functions](http://www.opengl.org/registry/doc/GLSLangSpec.4.20.8.pdf)""".trimMargin()
        docs(docs)
        +"fun exp(): $vec$id { exp($base) { $res -> return $vec$id($res) } }"
        docs(docs)
        +"infix fun exp(res: $vec$id): $vec$id { exp($base) { $res -> return res($res) } }"


        docs = """|Returns the natural logarithm of this [$vec$id], i.e., returns the value y which satisfies the equation x = e^y.
                  |Results are undefined if v <= 0.
                  |
                  |@receiver: log function is defined for input values of v defined in the range (0, inf+) in the limit of the type qualifier.
                  |@see [GLSL log man page](http://www.opengl.org/sdk/docs/manglsl/xhtml/log.xml)
                  |@see [GLSL 4.20.8 specification, section 8.2 Exponential Functions](http://www.opengl.org/registry/doc/GLSLangSpec.4.20.8.pdf)""".trimMargin()
        docs(docs)
        +"fun log(): $vec$id { log($base) { $res -> return $vec$id($res) } }"
        docs(docs)
        +"infix fun log(res: $vec$id): $vec$id { log($base) { $res -> return res($res) } }"


        docs = """|Returns 2 raised to the this [$vec$id] power.
                  |
                  |@receiver: exp2 function is defined for input values of v defined in the range (inf-, inf+) in the limit of the type qualifier.
                  |@see [GLSL exp2 man page](http://www.opengl.org/sdk/docs/manglsl/xhtml/exp2.xml)
                  |@see [GLSL 4.20.8 specification, section 8.2 Exponential Functions](http://www.opengl.org/registry/doc/GLSLangSpec.4.20.8.pdf)""".trimMargin()
        docs(docs)
        +"fun exp2(): $vec$id { exp2($base) { $res -> return $vec$id($res) } }"
        docs(docs)
        +"infix fun exp2(res: $vec$id): $vec$id { exp2($base) { $res -> return res($res) } }"


        docs = """|Returns the base 2 log of this [$vec$id], i.e., returns the value y, which satisfies the equation x = 2 ^ y.
                  |
                  |@receiver: log2 function is defined for input values of v defined in the range (0, inf+) in the limit of the type qualifier.
                  |@see [GLSL log2 man page](http://www.opengl.org/sdk/docs/manglsl/xhtml/log2.xml)
                  |@see [GLSL 4.20.8 specification, section 8.2 Exponential Functions](http://www.opengl.org/registry/doc/GLSLangSpec.4.20.8.pdf)""".trimMargin()
        docs(docs)
        +"fun log2(): $vec$id { log2($base) { $res -> return $vec$id($res) } }"
        docs(docs)
        +"infix fun log2(res: $vec$id): $vec$id { log2($base) { $res -> return res($res) } }"


        docs = """|Returns the positive square root of this [$vec$id].
                  |
                  |@receiver: sqrt function is defined for input values of v defined in the range [0, inf+) in the limit of the type qualifier.
                  |@see [GLSL sqrt man page](http://www.opengl.org/sdk/docs/manglsl/xhtml/sqrt.xml)
                  |@see [GLSL 4.20.8 specification, section 8.2 Exponential Functions](http://www.opengl.org/registry/doc/GLSLangSpec.4.20.8.pdf)""".trimMargin()
        docs(docs)
        +"fun sqrt(): $vec$id { sqrt($base) { $res -> return $vec$id($res) } }"
        docs(docs)
        +"infix fun sqrt(res: $vec$id): $vec$id { sqrt($base) { $res -> return res($res) } }"


        docs = """|Returns the reciprocal of the positive square root of this [$vec$id].
                  |
                  |@receiver: inverseSqrt function is defined for input values of v defined in the range [0, inf+) in the limit of the type qualifier.
                  |@see [GLSL inversesqrt man page](http://www.opengl.org/sdk/docs/manglsl/xhtml/inversesqrt.xml)
                  |@see [GLSL 4.20.8 specification, section 8.2 Exponential Functions](http://www.opengl.org/registry/doc/GLSLangSpec.4.20.8.pdf)""".trimMargin()
        docs(docs)
        +"fun inverseSqrt(): $vec$id { inverseSqrt($base) { $res -> return $vec$id($res) } }"
        docs(docs)
        +"infix fun inverseSqrt(res: $vec$id): $vec$id { inverseSqrt($base) { $res -> return res($res) } }"
    }
}

fun geometric(ordinal: Int, type: String, extension: String, id: String, vec: String) {

    +"\n\t// geometric\n"
    if (type in floatingPointTypes) {

        docs("""|Returns the length of this [$vec$id], i.e., `sqrt(this * this)`.
                |@see [GLSL length man page](http://www.opengl.org/sdk/docs/manglsl/xhtml/length.xml)
                |@see [GLSL 4.20.8 specification, section 8.5 Geometric Functions](http://www.opengl.org/registry/doc/GLSLangSpec.4.20.8.pdf)""".trimMargin())
        +"fun length(): $type = sqrt(this dot this)"

        docs("""|Returns the distance between this [$vec$id] and [p], i.e., `length(this - p).`
                |@see [GLSL distance man page](http://www.opengl.org/sdk/docs/manglsl/xhtml/distance.xml)
                |@see [GLSL 4.20.8 specification, section 8.5 Geometric Functions](http://www.opengl.org/registry/doc/GLSLangSpec.4.20.8.pdf)""".trimMargin())
        +"infix fun distance(p: $vec$id): $type = distance(${xyzwJoint(ordinal) { c -> c }}, ${xyzwJoint(ordinal) { c -> "p.$c" }})"

        docs("""|Returns the dot product of this [$vec$id] and [b], i.e., `result = this * b`.
                |@see [GLSL dot man page](http://www.opengl.org/sdk/docs/manglsl/xhtml/dot.xml)
                |@see [GLSL 4.20.8 specification, section 8.5 Geometric Functions](http://www.opengl.org/registry/doc/GLSLangSpec.4.20.8.pdf)""".trimMargin())
        +"infix fun dot(b: $vec$id): $type = dot(${xyzwJoint(ordinal) { c -> c }}, ${xyzwJoint(ordinal) { c -> "b.$c" }})"

        if (ordinal == 3) {
            docs("""|Returns the cross product of this [$vec$id] and [v] in a newly allocated $vec$id.
                    |@see [GLSL cross man page](http://www.opengl.org/sdk/docs/manglsl/xhtml/cross.xml)
                    |@see [GLSL 4.20.8 specification, section 8.5 Geometric Functions](http://www.opengl.org/registry/doc/GLSLangSpec.4.20.8.pdf)""".trimMargin())
            +"infix fun cross(v: Vec3$id): Vec3$id { cross(x, y, z, v.x, v.z, v.y) { resX, resY, resZ -> return Vec3$id(resX, resY, resZ) } }"
            docs("""|Returns the cross product of this [$vec$id] and [v] in [res].
                    |@see [GLSL cross man page](http://www.opengl.org/sdk/docs/manglsl/xhtml/cross.xml)
                    |@see [GLSL 4.20.8 specification, section 8.5 Geometric Functions](http://www.opengl.org/registry/doc/GLSLangSpec.4.20.8.pdf)""".trimMargin())
            +"fun cross(v: Vec3$id, res: Vec3$id): Vec3$id { cross(x, y, z, v.x, v.z, v.y) { resX, resY, resZ -> return res(resX, resY, resZ) } }"
        }
        docs("""|Returns a vector in the same direction as this [$vec$id] but with length of 1.
                |According to issue 10 GLSL 1.10 specification, if length(x) == 0 then result is undefined and generate an error.
                |@see [GLSL normalize man page](http://www.opengl.org/sdk/docs/manglsl/xhtml/normalize.xml)
                |@see [GLSL 4.20.8 specification, section 8.5 Geometric Functions](http://www.opengl.org/registry/doc/GLSLangSpec.4.20.8.pdf)""".trimMargin())
    }
    if (ordinal > 1 && type in numberTypes) {
        +"// Dot products"
        for (unsigned in (unsignedTypes + "out Number")) {
            if (unsigned != "out Number") +"@JvmName(\"dot$unsigned\")"
            +"infix fun dot(v: Vec${ordinal}T<$unsigned>) = (${xyzwJoint(ordinal, " + ") { c -> "$c * v.$c.$extension" }}).$extension"
        }
    }
}