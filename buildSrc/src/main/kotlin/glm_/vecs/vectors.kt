package glm_

import java.io.File
import kotlin.math.pow

fun vectors(target: File) {
    for (i in 1..4)
        generate(target, "glm_/vec$i/Vec${i}T.kt") {
            Generator.Companion.ordinal = i
            vectorsT(i)
        }

    for ((type, extension, _, id) in vectorTypes)
        for (i in 1..4)
            generate(target, "glm_/vec$i/Vec$i$id.kt") {
                Generator.Companion.ordinal = i
                vectors(i, type, extension, id)
            }

    Generator.Companion.ordinal = -1
}

private fun Generator.vectorsT(ordinal: Int) {
    +"package glm_.vec$ordinal"
    if (ordinal > 1) {
        +"import glm_.extensions.swizzle.*"
        +"import glm_.extensions.*"
        +"import kotlin.jvm.*"
    }

    "abstract class Vec${ordinal}T<T>" {
        xyzw { +"abstract var $it: T" }
        xyzwIndexed { i, c -> +"operator fun component${i + 1}() = $c" }

        +"// -- Aliases --"

        xyzwIndexed { i, c ->
            +"var ${rgba[i]}: T"
            indent {
                +"get() = $c"
                +"set(value) { $c = value }"
            }
        }
        xyzwIndexed { i, c ->
            +"var ${stpq[i]}: T"
            indent {
                +"get() = $c"
                +"set(value) { $c = value } "
            }
        }

        +"// -- Component accesses --"

        "operator fun get(index: Int): T = when (index)" {
            xyzwIndexed { i, c -> +"$i -> $c" }
            +"else -> throw IndexOutOfBoundsException()"
        }

        "operator fun set(index: Int, value: T) = when(index)" {
            xyzwIndexed { i, c ->
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
                        +"is $type -> (${xyzwJoint(separator = " + ") { "($it as $type) * v.$it.$extension" }}).$extension as N"
                    }
                    +"else -> throw IllegalArgumentException(\"Can't compute dot product of non-number vectors!\")"
                }
                +"else -> throw ArithmeticException(\"Can't compute dot product of non-number vectors!\")"
            }
        }
    }
}

private fun Generator.vectors(ordinal: Int, type: String, extension: String, id: String) {
    if (type[0] == 'U')
        +"@file:OptIn(kotlin.contracts.ExperimentalContracts::class, kotlin.ExperimentalUnsignedTypes::class)"
    else
        +"@file:OptIn(kotlin.contracts.ExperimentalContracts::class)"
    +"package glm_.vec$ordinal"
    +"import glm_.*"
    +"import glm_.extensions.*"
    +"import glm_.scalar.*"
    +"import kotlin.jvm.*"
    +"import kotlin.math.*"
    repeat(4) { +"import glm_.vec${it + 1}.*" }
    abcdIndexed(3, 3) { c, r, _ -> +"import glm_.mat${matrixSize(c + 2, r + 2)}.*" }

    val vec = "Vec$ordinal"
    val VecID = vec + id
    "open class $VecID(var array: ${type}Array, var ofs: Int = 0) : ${vec}T<$type>()" {
        xyzwIndexed { i, c ->
            val delta = if (i == 0) "" else " + $i"

            +"override var $c: $type"
            indent {
                +"get() = array[ofs$delta]"
                +"set(value) { array[ofs$delta] = value } "
            }
        }

        +"// Implicit basic constructors"
        +"constructor() : this(${type}Array($ordinal))"
        +"constructor(v: $VecID) : this(${xyzwJoint { "v.$it" }})"

        +"// Explicit basic constructors"
        val arrayOf = "${type.toLowerCase()}ArrayOf"
        var xxxx = "x" * ordinal
        +"constructor(x: $type) : this(${if (ordinal == 1) "$arrayOf($xxxx)" else xxxx})"
        +"constructor(x: Number) : this(x.$extension)"
        if (type == "UByte" || type == "UShort") {
            +"constructor(x: UInt) : this(x.$extension)"
            +"constructor(x: ULong) : this(x.$extension)"
        }

        if (ordinal > 1) {
            +"constructor(${xyzwJoint { "$it: $type" }}) : this($arrayOf(${xyzwJoint { it }}))"
            if (type == "UByte" || type == "UShort") {
                +"constructor(${xyzwJoint { "$it: UInt" }}) : this(${xyzwJoint { "$it.$extension" }})"
                +"constructor(${xyzwJoint { "$it: ULong" }}) : this(${xyzwJoint { "$it.$extension" }})"
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
                        xyzw {
                            when {
                                "Byte" in type || "Short" in type -> +"$it = ($it $operatorChar scalar).$extension"
                                else -> +"$it $operatorChar= scalar"
                            }
                        }
                    }
                }
                if ("Byte" in type || "Short" in type) {
                    "operator fun ${operatorName}Assign(scalar: ${if (type[0] == 'U') "UInt" else "Int"})" {
                        xyzw { +"$it = ($it $operatorChar scalar).$extension" }
                    }
                    if (type in unsignedTypes)
                        +"operator fun ${operatorName}Assign(scalar: ULong) = ${operatorName}Assign(scalar.$extension)"
                } else if (type in unsignedTypes)
                    if (type == "UInt")
                        +"operator fun ${operatorName}Assign(scalar: ULong) = ${operatorName}Assign(scalar.ui)"
                    else +"operator fun ${operatorName}Assign(scalar: UInt) = ${operatorName}Assign(scalar.ul)"
                "operator fun ${operatorName}Assign(v: $V1)" {
                    xyzw {
                        if ("Byte" in type || "Short" in type)
                            +"$it = ($it $operatorChar v.x.$extension).$extension"
                        else +"$it $operatorChar= v.x.$extension"
                    }
                }
                "operator fun ${operatorName}Assign(v: Vec1$id)" {
                    xyzw {
                        if ("Byte" in type || "Short" in type)
                            +"$it = ($it $operatorChar v.x).$extension"
                        else +"$it $operatorChar= v.x"
                    }
                }
                if (ordinal > 1) {
                    "operator fun ${operatorName}Assign(v: Vec${ordinal}T<out Number>)" {
                        xyzw {
                            if ("Byte" in type || "Short" in type)
                                +"$it = ($it $operatorChar v.$it.$extension).$extension"
                            else +"$it $operatorChar= v.$it.$extension"
                        }
                    }
                    "operator fun ${operatorName}Assign(v: $VecID)" {
                        xyzw {
                            if ("Byte" in type || "Short" in type)
                                +"$it = ($it $operatorChar v.$it).$extension"
                            else +"$it $operatorChar= v.$it"
                        }
                    }
                }
            }

            +"// Increment and decrement operators"
            "operator fun inc(): $VecID" {
                xyzw { +"$it++" }
                +"return this"
            }
            "operator fun dec(): $VecID" {
                xyzw { +"$it--" }
                +"return this"
            }

            "operator fun invoke(${xyzwJoint { "$it: $type" }}): $VecID" {
                xyzw { +"this.$it = $it" }
                +"return this"
            }
            if (type in listOf("Byte", "Short", "UByte", "UShort")) {
                val t = if (type[0] == 'U') "UInt" else "Int"
                "operator fun invoke(${xyzwJoint { "$it: $t" }}): $VecID" {
                    xyzw { +"this.$it = $it.$extension" }
                    +"return this"
                }
            }

            "fun put(${xyzwJoint { "$it: $type" }})" {
                xyzw { +"this.$it = $it" }
            }
            if (type in listOf("Byte", "Short", "UByte", "UShort")) {
                val t = if (type[0] == 'U') "UInt" else "Int"
                "fun put(${xyzwJoint { "$it: $t" }})" {
                    xyzw { +"this.$it = $it.$extension" }
                }
            }

            +"// Unary bit operators TODO"
            +"// Unary operators"
            +"operator fun unaryPlus(): $VecID = this"
            if (type !in unsignedTypes)
                +"operator fun unaryMinus(): $VecID = $VecID(${xyzwJoint { "-$it" }})"

            binary(ordinal, type, extension, id, vec)
        }

        common(ordinal, type, extension, id, vec)
        exponential(ordinal, type, extension, id, vec)
        geometric(ordinal, type, extension, id, vec)

        +"override fun equals(other: Any?) = other is $VecID && ${xyzwJoint(separator = " && ") { "$it == other.$it" }}"
        +"override fun hashCode() = ${xyzwJointIndexed(separator = " + ") { i, c -> "${31f.pow(i).toInt()} * $c.hashCode()" }}"

        if (type == "Float" || type == "Double") {
            +"fun equal(v: $VecID, epsilon: $type = $type.MIN_VALUE) = BooleanArray(length) { abs(array[it] - v.array[it]) <= epsilon }"
            +"fun notEqual(v: $VecID, epsilon: $type = $type.MIN_VALUE) = BooleanArray(length) { abs(array[it] - v.array[it]) > epsilon }"
            "fun allEqual(v: $VecID, epsilon: $type = $type.MIN_VALUE): Boolean" {
                +"for (i in 0 until length)"
                +"\tif(abs(array[i] - v.array[i]) > epsilon)"
                +"\t\treturn false"
                +"return true"
            }
            "fun anyNotEqual(v: $VecID, epsilon: $type = $type.MIN_VALUE): Boolean" {
                +"for (i in 0 until length)"
                +"\tif(abs(array[i] - v.array[i]) > epsilon)"
                +"\t\treturn true"
                +"return false"
            }
        } else {
            +"infix fun equal(v: $VecID) = BooleanArray(length) { array[it] == v.array[it] }"
            +"infix fun notEqual(v: $VecID) = BooleanArray(length) { array[it] != v.array[it] }"
            +"fun allEqual(v: $VecID): Boolean = array.contentEquals(v.array)"
            +"fun anyNotEqual(v: $VecID): Boolean = !array.contentEquals(v.array)"
        }
        +"fun all(predicate: ($type) -> Boolean): Boolean = array.all(predicate)"
        +"fun any(predicate: ($type) -> Boolean): Boolean = array.any(predicate)"

        if (type == "Boolean") {
            +"// Boolean operators"
            val v = "$vec$extension"
            +"infix fun and(v: $v) = $v(${xyzwJoint { "$it && v.$it" }})"
            +"infix fun or(v: $v) = $v(${xyzwJoint { "$it || v.$it" }})"
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
                val `xyzw type` = xyzwJoint { "$it: $type" }
                val `bXYZW type` = XyzwJoint { "b$it: $type" }
                for ((opChar, op) in operators) {
                    "inline fun $op($`xyzw type`,$`bXYZW type`, res: (${XyzwJoint { "res$it: $t" }}) -> Unit )" {
                        contract
                        +"res(${xyzwJoint { "$it $opChar b${it.toUpperCase()}" }})"
                    }
                }
                val res = XyzwJoint { "res$it: $type" }
                if (type in floatingPointTypes) {
                    +"fun dot($`xyzw type`, $`bXYZW type`): $type = ${xyzwJoint(separator = " + ") { "$it * b${it.toUpperCase()}" }}"
                    val unrolled = xyzwJoint { it }
                    +"fun length($`xyzw type`): $type = sqrt(dot($unrolled, $unrolled))"
                    "fun distance($`xyzw type`, $`bXYZW type`): $type" {
                        +xyzwJoint(separator = "; ") { "val d$it: $type" }
                        val d = xyzwJoint { it }
                        val e = XyzwJoint { "b$it" }
                        val res2 = XyzwJoint { "res$it" }
                        +"minus($d, $e) { $res2 -> ${xyzwJoint(separator = "; ") { "d$it = res${it.toUpperCase()}" }} }"
                        +"return length(${xyzwJoint { "d$it" }})"
                    }
                    if (ordinal == 3) {
                        "inline fun cross(x: $type, y: $type, z: $type,\nvx: $type, vy: $type, vz: $type,\nres: (resX: $type, resY: $type, resZ: $type) -> Unit)" {
                            contract
                            +"\tres(y * vz - vy * z, z * vx - vz * x, x * vy - vx * y)"
                        }
                    }
                    fun exponential() {
                        val exponent = xyzwJoint { "e$it: $type" }
                        "inline fun pow($`xyzw type`, $exponent, res: ($res) -> Unit)" {
                            contract
                            +"res(${xyzwJoint { "$it pow e$it" }})"
                        }
                        "inline fun exp($`xyzw type`, res: ($res) -> Unit)" {
                            contract
                            +"res(${xyzwJoint { "$it.exp()" }})"
                        }
                        "inline fun log($`xyzw type`, res: ($res) -> Unit)" {
                            contract
                            +"res(${xyzwJoint { "$it.log()" }})"
                        }
                        "inline fun exp2($`xyzw type`, res: ($res) -> Unit)" {
                            contract
                            +"res(${xyzwJoint { "2${if (type == "Float") "f" else ".0"} pow $it" }})"
                        }
                        "inline fun log2($`xyzw type`, res: ($res) -> Unit)" {
                            contract
                            +"res(${xyzwJoint { "$it.log2()" }})"
                        }
                        "inline fun sqrt($`xyzw type`, res: ($res) -> Unit)" {
                            contract
                            +"res(${xyzwJoint { "$it.sqrt()" }})"
                        }
                        "inline fun inverseSqrt($`xyzw type`, res: ($res) -> Unit)" {
                            contract
                            +"res(${xyzwJoint { "$it.inverseSqrt()" }})"
                        }
                    }
                    exponential()
                }
                fun common() {
                    if (type !in unsignedTypes)
                        "inline fun <R> abs($`xyzw type`, res: ($res) -> R): R" {
                            contract
                            +"return res(${xyzwJoint { "$it.abs()" }})"
                        }
                    if (type in floatingPointTypes) {
                        "inline fun <R> sign($`xyzw type`, res: ($res) -> R): R" {
                            contract
                            +"return res(${xyzwJoint { "$it.sign" }})"
                        }
                        "inline fun <R> floor($`xyzw type`, res: ($res) -> R): R" {
                            contract
                            +"return res(${xyzwJoint { "$it.floor()" }})"
                        }
                        "inline fun <R> trunc($`xyzw type`, res: ($res) -> R): R" {
                            contract
                            +"return res(${xyzwJoint { "$it.trunc()" }})"
                        }
                        "inline fun <R> round($`xyzw type`, res: ($res) -> R): R" {
                            contract
                            +"return res(${xyzwJoint { "$it.round()" }})"
                        }
                        "inline fun <R> roundEven($`xyzw type`, res: ($res) -> R): R" {
                            contract
                            +"return res(${xyzwJoint { "$it.roundEven()" }})"
                        }
                        "inline fun <R> ceil($`xyzw type`, res: ($res) -> R): R" {
                            contract
                            +"return res(${xyzwJoint { "$it.ceil()" }})"
                        }
                        "inline fun <R> fract($`xyzw type`, res: ($res) -> R): R" {
                            contract
                            +"return res(${xyzwJoint { "$it.fract()" }})"
                        }
                        "inline fun <R> mod($`xyzw type`, $`bXYZW type`, res: ($res) -> R): R" {
                            contract
                            +"return res(${xyzwJoint { "$it % b${it.toUpperCase()}" }})"
                        }
                        var f = XyzwJoint { "f$it: $type" }
                        var i = XyzwJoint { "i$it: $type" }
                        "inline fun <R> modf($`xyzw type`, res: ($f, $i) -> R): R" {
                            val pf = if (type == "Float") "f" else ".0"
                            xyzw { +"val int${it.toUpperCase()} = if ($it > 0$pf) $it.floor() else $it.ceil()" }
                            f = xyzwJoint { "$it - int${it.toUpperCase()}" }
                            i = XyzwJoint { "int$it" }
                            +"return res($f, $i)"
                        }
                        "inline fun <R> min($`xyzw type`, $`bXYZW type`, res: ($res) -> R): R" {
                            contract
                            +"return res(${xyzwJoint { "$it min b${it.toUpperCase()}" }})"
                        }
                        "inline fun <R> max($`xyzw type`, $`bXYZW type`, res: ($res) -> R): R" {
                            contract
                            +"return res(${xyzwJoint { "$it max b${it.toUpperCase()}" }})"
                        }
                        val `minXYZW type` = XyzwJoint { "min$it: $type" }
                        val `maxXYZW type` = XyzwJoint { "max$it: $type" }
                        "inline fun <R> clamp($`xyzw type`, $`minXYZW type`, $`maxXYZW type`, res: ($res) -> R): R" {
                            contract
                            +"return res(${xyzwJoint { "$it.clamp(min${it.toUpperCase()}, max${it.toUpperCase()})" }})"
                        }

                        // mix c scalar
                        "inline fun <R> mix($`xyzw type`, $`bXYZW type`, c: $type, res: ($res) -> R): R" {
                            contract
                            +"return res(${xyzwJoint { "$it.mix(b${it.toUpperCase()}, c)" }})"
                        }
                        "inline fun <R> mix($`xyzw type`, $`bXYZW type`, c: Boolean, res: ($res) -> R): R" {
                            contract
                            +"return res(${xyzwJoint { "$it.mix(b${it.toUpperCase()}, c)" }})"
                        }
                        if (ordinal > 1) {
                            // mix c vectorial
                            val `cXYZW type` = XyzwJoint { "c$it: $type" }
                            val `cXYZW bool` = XyzwJoint { "c$it: Boolean" }
                            "inline fun <R> mix($`xyzw type`, $`bXYZW type`, $`cXYZW type`, res: ($res) -> R): R" {
                                contract
                                +"return res(${xyzwJoint { "$it.mix(b${it.toUpperCase()}, c${it.toUpperCase()})" }})"
                            }
                            "inline fun <R> mix($`xyzw type`, $`bXYZW type`, $`cXYZW bool`, res: ($res) -> R): R" {
                                contract
                                +"return res(${xyzwJoint { "$it.mix(b${it.toUpperCase()}, c${it.toUpperCase()})" }})"
                            }
                        }

                        "inline fun <R> step($`xyzw type`, edge: $type, res: ($res) -> R): R" {
                            contract
                            +"return res(${xyzwJoint { "$it step edge" }})"
                        }
                        if (ordinal > 1) {
                            val edge = XyzwJoint { "edge$it: $type" }
                            "inline fun <R> step($`xyzw type`, $edge, res: ($res) -> R): R" {
                                contract
                                +"return res(${xyzwJoint { "$it step edge${it.toUpperCase()}" }})"
                            }
                        }
                    }
                    when (type) {
                        "Float" -> {
                            "inline fun <R> bitsToInt($`xyzw type`, res: (${XyzwJoint { "res$it: Int" }}) -> R): R" {
                                contract
                                +"return res(${xyzwJoint { "$it.bitsToInt()" }})"
                            }
                            "inline fun <R> bitsToUInt($`xyzw type`, res: (${XyzwJoint { "res$it: UInt" }}) -> R): R" {
                                contract
                                +"return res(${xyzwJoint { "$it.bitsToUInt()" }})"
                            }
                        }
                        "Double" -> {
                            "inline fun <R> bitsToLong($`xyzw type`, res: (${XyzwJoint { "res$it: Long" }}) -> R): R" {
                                contract
                                +"return res(${xyzwJoint { "$it.bitsToLong()" }})"
                            }
                            "inline fun <R> bitsToULong($`xyzw type`, res: (${XyzwJoint { "res$it: ULong" }}) -> R): R" {
                                contract
                                +"return res(${xyzwJoint { "$it.bitsToULong()" }})"
                            }
                        }
                        "Int" ->
                            "inline fun <R> bitsToFloat($`xyzw type`, res: (${XyzwJoint { "res$it: Float" }}) -> R): R" {
                                contract
                                +"return res(${xyzwJoint { "$it.bitsToFloat()" }})"
                            }
                        "UInt" ->
                            "inline fun <R> bitsToFloat($`xyzw type`, res: (${XyzwJoint { "res$it: Float" }}) -> R): R" {
                                contract
                                +"return res(${xyzwJoint { "$it.bitsToFloat()" }})"
                            }
                        "Long" ->
                            "inline fun <R> bitsToDouble($`xyzw type`, res: (${XyzwJoint { "res$it: Double" }}) -> R): R" {
                                contract
                                +"return res(${xyzwJoint { "$it.bitsToDouble()" }})"
                            }
                        "ULong" ->
                            "inline fun <R> bitsToDouble($`xyzw type`, res: (${XyzwJoint { "res$it: Double" }}) -> R): R" {
                                contract
                                +"return res(${xyzwJoint { "$it.bitsToDouble()" }})"
                            }
                    }
                    if (type in floatingPointTypes) {
                        // fma
                        docs("""|Computes and returns a * b + c.
                                |
                                |[GLSL fma man page](http://www.opengl.org/sdk/docs/manglsl/xhtml/fma.xml)
                                |[GLSL 4.20.8 specification, section 8.3 Common Functions](http://www.opengl.org/registry/doc/GLSLangSpec.4.20.8.pdf)""")
                        val `aXYZW type` = XyzwJoint { "a$it: $type" }
                        val `cXYZW type` = XyzwJoint { "c$it: $type" }
                        "inline fun <R> fma($`aXYZW type`, $`bXYZW type`, $`cXYZW type`, res: (${XyzwJoint { "res$it: $type" }}) -> R): R" {
                            contract
                            +"return res(${XyzwJoint { "a$it.fma(b$it, c$it)" }})"
                        }

                        // frexp
                        docs("""|Splits x into a floating-point significand in the range [0.5, 1.0) and an integral exponent of two, such that:
                                |`x = significand * exp(2, exponent)`
                                |
                                |The significand is returned by the function and the exponent is returned in the parameter exp. 
                                |For a floating-point value of zero, the significant and exponent are both zero. 
                                |For a floating-point value that is an infinity or is not a number, the results are undefined.
                                |
                                |[GLSL frexp man page](http://www.opengl.org/sdk/docs/manglsl/xhtml/frexp.xml)
                                |[GLSL 4.20.8 specification, section 8.3 Common Functions](http://www.opengl.org/registry/doc/GLSLangSpec.4.20.8.pdf)""")
                        val `resMantXYZW type` = XyzwJoint { "resMant$it: $type" }
                        val `resExpXYZW type` = XyzwJoint { "resExp$it: Int" }
                        "inline fun <R> frexp($`xyzw type`, res: ($`resMantXYZW type`, $`resExpXYZW type`) -> R): R" {
                            contract
                            Xyzw { +"val e$it: Int" }
                            Xyzw { +"val m$it = ${it.toLowerCase()}.frexp { e$it = it }" }
                            +"return res(${XyzwJoint { "m$it" }}, ${XyzwJoint { "e$it" }})"
                        }

                        // ldexp
                        docs("""|Builds a floating-point number from x and the corresponding integral exponent of two in exp, returning:
                        |`significand * exp(2, exponent)`
                        |
                        |If this product is too large to be represented in the floating-point type, the result is undefined.
                        |
                        |[GLSL ldexp man page](http://www.opengl.org/sdk/docs/manglsl/xhtml/ldexp.xml)
                        |[GLSL 4.20.8 specification, section 8.3 Common Functions](http://www.opengl.org/registry/doc/GLSLangSpec.4.20.8.pdf)""")
                        val `expXyzw Int` = XyzwJoint { "exp$it: Int" }
                        "inline fun <R> ldexp($`xyzw type`, $`expXyzw Int`, res: (${XyzwJoint { "res$it: $type" }}) -> R): R" {
                            contract
                            +"return res(${xyzwJoint { "$it ldexp exp${it.toUpperCase()}" }})"
                        }
                    }
                }
                common()
            }
        }
    }

    +"// Binary operators"
    if (type in numberTypes) {
        for ((operatorChar, operatorName) in operators) {
            +"operator fun $type.$operatorName(v: $VecID) = $VecID(${xyzwJoint { "this $operatorChar v.$it" }})"
            if (ordinal > 1)
                +"operator fun Vec1$id.$operatorName(v: $VecID) = $VecID(${xyzwJoint { "x $operatorChar v.$it" }})"
        }
    }
}