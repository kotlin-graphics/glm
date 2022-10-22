package glm_

import glm_.detail.binary
import glm_.detail.matrix
import glm_.ext.extMatrixCommon
import glm_.ext.extMatrixTransform
import glm_.gen.Generator
import glm_.gen.Generator.Experimentals
import glm_.gen.generate
import glm_.gen.matrixSize
import java.io.File

fun matrices(target: File) {
    for (i in 2..4)
        for (j in 2..4)
            generate(target, "glm_/mat${matrixSize(i, j)}/Mat${matrixSize(i, j)}T.kt") {
                Generator.width = i
                Generator.height = j
                `package` = "glm_.mat$matrixSize"
                imports += listOf("glm_.vec$j.*",
                                  "glm_.vec$i.*")
                //    abcd(3, 3) { c, r, s -> +"import glm.mat${matrixSizeString(c + 2, r + 2)}.*" }
                for (w in 2..4)
                    imports += listOf("glm_.mat${matrixSize(w, i)}.*",
                                      "glm_.mat${matrixSize(w, j)}.*")
                matricesT(i, j)
            }

    for ((type, extension, _, id) in matrixTypes)
        for (i in 2..4)
            for (j in 2..4)
                generate(target, "glm_/mat${matrixSize(i, j)}/Mat${matrixSize(i, j)}$id.kt") {
                    Generator.width = i
                    Generator.height = j
                    experimentals += Experimentals.Contracts
                    `package` = "glm_.mat$matrixSize"
                    imports += listOf("glm_.*",
                                      "glm_.extensions.*",
                                      "kotlin.math.abs")
                    repeat(4) { imports += "glm_.vec${it + 1}.*" }
                    abcdIndexed(3, 3) { c, r, _ -> imports += "glm_.mat${matrixSize(c + 2, r + 2)}.*" }
                    if (type in floatingPointTypes && (matrixSize == "3" || matrixSize == "4"))
                        imports += "glm_.quat.Quat$id"
                    matrices(i, j, type, extension, id)
                }
    Generator.Companion.width = -1
    Generator.Companion.height = -1
}


val Generator.MatNT: String
    get() = "Mat${matrixSize}T"

private fun Generator.matricesT(width: Int, height: Int) {

    "abstract class $MatNT<N : Number, V : Vec${height}T<N>>" {
        abcd { +"abstract var $it: N" }
        abcdIndexed { i, j, c -> +"operator fun component${i * height + j + 1}() = $c" }

        +"// -- Component accesses --"

        +"abstract operator fun get(column: Int): V"
        +"operator fun get(column: Int, row: Int): N = get(column).get(row)"

        for (c in 0 until width)
            +"abstract fun set$c(${xyzwJoint(height) { "$it: N" }})"

        +"abstract operator fun set(column: Int, value: Vec${height}T<out Number>)"
        +"abstract operator fun set(column: Int, row: Int, value: N)"

        for (r in 0 until height)
            +"abstract fun setRow$r(${xyzwJoint(height) { "$it: N" }})"

        +"abstract fun row(row: Int): Vec${width}T<N>"
        +"abstract fun row(row: Int, value: Vec${width}T<out Number>)"

        +"// -- Matrix multiplications --"

        for (k in 2..4) {
            +"abstract infix operator fun times(other: Mat${matrixSize(k, width)}T<N, out Vec${width}T<N>>)"
            +"abstract fun times(other: Mat${matrixSize(k, width)}T<N, out Vec${width}T<N>>, res: Mat${matrixSize(k, height)}T<N, out Vec${height}T<N>>)"
        }
        if (width == height)
            +"abstract infix operator fun timesAssign(other: Mat${matrixSize(height, width)}T<N, out Vec${width}T<N>>)"
        +"abstract infix operator fun times(v: Vec${width}T<N>)"
        +"abstract fun times(v: Vec${width}T<N>, res: Vec${height}T<N>)"

        +"// -- Aliases --"

        abcdIndexed { i, j, c ->
            "var ${vNN(i, j)}: N".indented {
                +"get() = $c"
                +"set(value) { $c = value }"
            }
        }

        +"abstract val isIdentity: Boolean"

        "companion object" {
            +"const val length = $width * $height"
            +"const val width = $width"
            +"const val height = $height"
        }

        "override fun toString() = \"\"\"".indented {
            +("|" + abcdJointIndexed(height, width, "\n|", " ") { i, j, _ -> "$${vNN(j, i)}" } + "\"\"\".trimMargin()")
        }
    }
}

private fun Generator.matrices(width: Int, height: Int, type: String, extension: String, id: String) {

    val matID = "Mat$matrixSize$id"
    val `m,abcdN` = abcdJoint(",\n") { "m.$it" }
    val `mAbcdN type` = AbcdJoint(",\n") { "m$it: $type" }
    val abcdN = abcdJoint(",\n")
    val `abcdN type` = abcdJoint(",\n") { "$it: $type" }
    val `resXYZW type` = WxyzJoint { "res$it: $type" }

    "open class $matID protected constructor(var array: ${type}Array) : $MatNT<$type, Vec$height$id>()" {

        val xyzwDiag = abcdJointIndexed(",\n") { i, j, _ -> if (i == j) glm_.xyzw[i] else "0" }

        abcdIndexed { i, j, c ->
            val ofs = i * height + j

            "override var $c: $type".indented {
                +"get() = array[$ofs]"
                +"set(value) { array[$ofs] = value }"
            }
        }

        +"// -- Constructors --"
        +"constructor() : this(1)"
        +"constructor(m: $matID) : this($`m,abcdN`)"
        +"constructor(scalar: $type) : this(${abcdJointIndexed(",\n") { c, r, _ -> if (c == r) "scalar" else "0" }})"
        val `abcd type` = abcdJoint(",\n") { "$it: $type" }
        val arrayOf = "${type.toLowerCase()}ArrayOf"
        +"constructor($`abcd type`) : this($arrayOf(${abcdJoint(",\n")}))"

        val `vN VecID` = (0 until width).joinToString { "v$it: Vec$height$id" }
        +"constructor($`vN VecID`) : this(${(0 until width).joinToString(",\n") { i -> xyzwJoint(height) { "v$i.$it" } }})"

        +"// -- Conversions --"
        +"constructor(s: Number) : this(s.$extension)"
        +"constructor(m: $MatNT<*, Vec${height}T<*>>) : this($`m,abcdN`)"

        if (width == height) {
            if (width > 2) {
                val `xyzw Number` = xyzwJoint(width - 1) { "$it: Number" }
                +"constructor($`xyzw Number`) : this(${xyzwJoint(width - 1)}, 1)"
            }
            +"constructor(${xyzwJoint(width) { "$it: Number" }}) : this($xyzwDiag)"
        }

        val `xyzwJ Number` = abcdJointIndexed(",\n") { i, j, _ -> "${glm_.xyzw[i]}$j: Number" }
        val `xyzwJ ext` = abcdJointIndexed(",\n") { i, j, _ -> "${glm_.xyzw[i]}$j.$extension" }
        +"constructor($`xyzwJ Number`) : this($arrayOf($`xyzwJ ext`))"

        +"// -- Matrix conversions --"
        abcdIndexed(3, 3) { i, j, _ ->
            val c = i + 2
            val r = j + 2
            if (c != width || r != height) {
                val args = abcdJointIndexed(",\n") { col, row, text ->
                    when {
                        row < r && col < c -> "m.$text"
                        col == row -> "1"
                        else -> "0"
                    }
                }
                +"constructor(m: Mat${matrixSize(c, r)}) : this($args)"
            }
        }

        "constructor(array: ${type}Array, transpose: Boolean = false) : this(".indented {
            val array = abcdJointIndexed(",\n") { i, j, _ -> "array[${i * height + j}]" }
            +"if (transpose) $arrayOf($array)"
            +"else array.copyOf())"
        }

        // custom glm, functional programming
        var block = abcdJointIndexed { c, r, _ ->
            val i = c * height + r
            val prefix = if (i % height == 0 && i > 0) "\n" else ""
            "${prefix}block($i)"
        }
        +"constructor(block: (i: Int) -> $type) : this($block)"
        block = abcdJointIndexed { c, r, _ -> "block($c, $r)" }
        +"constructor(block: (col: Int, row: Int) -> $type) : this($block)"

        +"// -- Invoke functions --"
        +"operator fun invoke(s: Number): $matID = invoke(${"s" * width})"
        if (width > 2)
            +"operator fun invoke(${xyzwJoint(width - 1) { "$it: Number" }}): $matID = invoke(${xyzwJoint(width - 1)}, 1)"

        "operator fun invoke(${xyzwJoint(width) { "$it: Number" }}): $matID = invoke(".indentAndClose {
            +xyzwDiag
        }

        "operator fun invoke(${abcdJoint(",\n") { "$it: Number" }}): $matID" {
            +"put(${abcdJoint(",\n") { "$it.$extension" }})"
            +"return this"
        }
        +"operator fun invoke(m: $matID): $matID { put(m); return this }"

        if (width == height)
            +"fun identity() = invoke(1)"

        +"// -- Put functions --"
        +"infix fun put(s: Number) = put(${"s" * width})"
        if (width > 2)
            +"fun put(${xyzwJoint(width - 1) { "$it: Number" }}) = put(${xyzwJoint(width - 1)}, 1)"

        +"fun put(${xyzwJoint(width) { "$it: Number" }}) = put($xyzwDiag)"

        "fun put(${abcdJoint(",\n") { "$it: Number" }})" {
            abcdIndexed { i, j, c ->
                +"array[${i * height + j}] = $c.$extension"
            }
        }
        "infix fun put(m: $matID)" {
            "if (this !== m)".indented {
                +"m.array.copyInto(array, 0, 0, length)"
            }
        }

        +"// -- Matrix multiplication --"
        for (k in 2..4) {
            +"override infix operator fun times(other: Mat${matrixSize(k, width)}T<$type, out Vec${width}T<$type>>) = Operations.times(Mat${matrixSize(k, height)}$id(${type}Array(${k * height})), this, other)"
            +"override fun times(other: Mat${matrixSize(k, width)}T<$type, out Vec${width}T<$type>>, res: Mat${matrixSize(k, height)}T<$type, out Vec${height}T<$type>>) = Operations.times(res, this, other)"
        }
        if (width == height)
            +"override infix operator fun timesAssign(other: Mat${matrixSize(height, width)}T<$type, out Vec${width}T<$type>>) = Operations.times(this, this, other)"
        +"override infix operator fun times(v: Vec${width}T<$type>) = Operations.times(Vec$height$id(), this, v)"
        +"override fun times(v: Vec${width}T<$type>, res: Vec${height}T<$type>) = Operations.times(res, this, v)"

        +"// -- Accesses --"

        +"override operator fun get(column: Int) = Vec$height$id(array, column * $height)"
        +"override fun row(row: Int) = Vec$width$id(${xyzwJointIndexed(width) { i, _ -> "${i * height} + row" }})"

        for (col in 0 until width)
            +"override fun set$col(${xyzwJoint(height) { "$it: $type" }}) { ${xyzwJointIndexed(height, "; ") { i, char -> "this[$col, $i] = $char" }} }"
        for (col in 0 until width)
            +"fun with$col(${xyzwJoint(height) { "$it: $type" }}): $matID { set$col(${xyzwJoint(height)}); return this }"

        "override operator fun set(column: Int, value: Vec${height}T<out Number>)" {
            xyzwIndexed(height) { i, c ->
                val delta = if (i == 0) "" else " + $i"

                +"array[column * $height$delta] = value.$c.$extension"
            }
        }

        for (row in 0 until height)
            +"override fun setRow$row(${xyzwJoint(height) { "$it: $type" }}) { ${xyzwJointIndexed(height, "; ") { i, char -> "this[$i, $row] = $char" }} }"
        for (row in 0 until height)
            +"fun withRow$row(${xyzwJoint(height) { "$it: $type" }}): $matID { setRow$row(${xyzwJoint(height)}); return this }"

        "override fun row(row: Int, value: Vec${width}T<out Number>)" {
            xyzwIndexed(width) { i, c ->
                val delta = if (i == 0) "" else " + $i * $height"

                +"array[row$delta] = value.$c.$extension"
            }
        }

        +"override operator fun set(column: Int, row: Int, value: $type) { array[column * height + row] = value }"

        +"// -- Unary arithmetic operators --"
        for ((char, operation) in operators) {
            "operator fun ${operation}Assign(scalar: Number)" {
                abcd { +"$it = ($it $char scalar.$extension).$extension" }
            }
            "operator fun ${operation}Assign(m: $matID)" {
                abcd { +"$it = ($it $char m.$it).$extension" }
            }
        }

        +"operator fun unaryPlus() = this"
        "operator fun unaryMinus() = $matID(".indentAndClose {
            +abcdJoint(",\n") { "-$it" }
        }

        +"// -- Increment and decrement operators --"
        "operator fun inc(): $matID" {
            abcd { +"$it = ($it + 1.$extension).$extension" }
            +"return this"
        }
        "operator fun dec(): $matID" {
            abcd { +"$it = ($it - 1.$extension).$extension" }
            +"return this"
        }

        binary(width, height, type, extension, id, "", Generator.Part.Class)

        if (type in floatingPointTypes) {
            val `resWXYZ type` = WxyzJoint { "res$it: $type" }
            val resWXYZ = WxyzJoint { "res$it" }
            if (matrixSize == "3") {
                val doc = "Converts a pure rotation 3 * 3 matrix to a quaternion."
                docs(doc)
                +"fun toQuat(res: Quat$id = Quat$id()): Quat$id = toQuat { $`resWXYZ type` -> res($resWXYZ) }"
                docs(doc)
                "inline fun <R> toQuat(res: ($`resXYZW type`) -> R): R" {
                    +contract
                    +"return toQuat($abcdN, res)"
                }
            } else if (matrixSize == "4") {
                val doc = "Converts a pure rotation 4 * 4 matrix to a quaternion."
                docs(doc)
                +"fun toQuat(res: Quat$id = Quat$id()): Quat$id = toQuat { $`resWXYZ type` -> res($resWXYZ) }"
                docs(doc)
                val abcdN3 = abcdJoint(3, 3, ",\n")
                "inline fun <R> toQuat(res: ($`resXYZW type`) -> R): R" {
                    +contract
                    +"return Mat3$id.toQuat($abcdN3, res)"
                }
            }
        }

        matrix(width, height, type, extension, id, Generator.Part.Class)
        // ext
        extMatrixCommon(width, height, type, extension, id, Generator.Part.Class)
        extMatrixTransform(width, height, type, extension, id, Generator.Part.Class)

        if (type == "Float" || type == "Double")
            +"""
                fun equal(m: $matID, epsilon: $type = $type.MIN_VALUE) = BooleanArray(length) { abs(array[it] - m.array[it]) <= epsilon }
                fun notEqual(m: $matID, epsilon: $type = $type.MIN_VALUE) = BooleanArray(length) { abs(array[it] - m.array[it]) > epsilon }
                fun allEqual(m: $matID, epsilon: $type = $type.MIN_VALUE): Boolean {
                    for (i in 0 until length)
                        if(abs(array[i] - m.array[i]) > epsilon)
                            return false
                    return true
                }
                fun anyNotEqual(m: $matID, epsilon: $type = $type.MIN_VALUE): Boolean {
                    for (i in 0 until length)
                        if(abs(array[i] - m.array[i]) > epsilon)
                            return true
                    return false
                }"""
        else
            +"""
                infix fun equal(m: $matID) = BooleanArray(length) { array[it] == m.array[it] }
                infix fun notEqual(m: $matID) = BooleanArray(length) { array[it] != m.array[it] }
                fun allEqual(m: $matID): Boolean = array.contentEquals(m.array)
                fun anyNotEqual(m: $matID): Boolean = !array.contentEquals(m.array)"""

        "override val isIdentity: Boolean".indented {
            if (width != height)
                +"get() = false"
            else
                +"get() = ${
                    abcdJointIndexed(" &&\n\t", " && ") { i, j, _ ->
                        if (i == j) "this[$i, $j] == 1.$extension" else "this[$i, $j] == 0.$extension"
                    }
                }"
        }

        "companion object" {
            +"const val length = $MatNT.length"
            +"const val width = $MatNT.width"
            +"const val height = $MatNT.height"
            +"val size = length * $type.BYTES"

            binary(width, height, type, extension, id, "", Generator.Part.CompanionObject)
            matrix(width, height, type, extension, id, Generator.Part.CompanionObject)
            // ext
            extMatrixCommon(width, height, type, extension, id, Generator.Part.CompanionObject)
            extMatrixTransform(width, height, type, extension, id, Generator.Part.CompanionObject)

            // [gtc quaternion] quat_cast
            fun gtcQuaternion() {
                if (type in floatingPointTypes && matrixSize == "3") {
                    docs("Converts a pure rotation 3 * 3 matrix to a quaternion. Formally `quat_cast`")
                    val `wxyz type` = wxyzJoint { "$it: $type" }
                    +"""
                        inline fun <R> toQuat(m00: $type, m01: $type, m02: $type,
                                              m10: $type, m11: $type, m12: $type,
                                              m20: $type, m21: $type, m22: $type,
                                              res: ($`wxyz type`) -> R): R {
                            val fourXSquaredMinus1 = m00 - m11 - m22
                            val fourYSquaredMinus1 = m11 - m00 - m22
                            val fourZSquaredMinus1 = m22 - m00 - m11
                            val fourWSquaredMinus1 = m00 + m11 + m22
                            
                            var biggestIndex = 0
                            var fourBiggestSquaredMinus1 = fourWSquaredMinus1
                            if (fourXSquaredMinus1 > fourBiggestSquaredMinus1) {
                                fourBiggestSquaredMinus1 = fourXSquaredMinus1
                                biggestIndex = 1
                            }
                            if (fourYSquaredMinus1 > fourBiggestSquaredMinus1) {
                                fourBiggestSquaredMinus1 = fourYSquaredMinus1
                                biggestIndex = 2
                            }
                            if (fourZSquaredMinus1 > fourBiggestSquaredMinus1) {
                                fourBiggestSquaredMinus1 = fourZSquaredMinus1
                                biggestIndex = 3
                            }
                        ${
                        if (type == "Float")
                            """
                            val biggestVal = kotlin.math.sqrt(fourBiggestSquaredMinus1 + 1f) * 0.5f
                            val mult = 0.25f / biggestVal"""
                        else
                            """
                            val biggestVal = kotlin.math.sqrt(fourBiggestSquaredMinus1 + 1.0) * 0.5
                            val mult = 0.25 / biggestVal"""
                    }
                            return when (biggestIndex) {
                                0 -> res(biggestVal, (m12 - m21) * mult, (m20 - m02) * mult, (m01 - m10) * mult)
                                1 -> res((m12 - m21) * mult, biggestVal, (m01 + m10) * mult, (m20 + m02) * mult)
                                2 -> res((m20 - m02) * mult, (m01 + m10) * mult, biggestVal, (m12 + m21) * mult)
                                3 -> res((m01 - m10) * mult, (m20 + m02) * mult, (m12 + m21) * mult, biggestVal)
                                else -> error("Should never actually get here")
                            }
                        }"""
                }
            }
            gtcQuaternion()
        }

        +"fun size() = size"
        +"fun elementCount() = length"

        +"override fun equals(other: Any?) = other is $matID && array.contentEquals(other.array)"


        "object Operations" {
            for (k in 2..4) {
                "fun times(res: Mat${matrixSize(k, height)}T<$type, out Vec${height}T<$type>>, a: $MatNT<$type, out Vec${height}T<$type>>, b: Mat${matrixSize(k, width)}T<$type, out Vec${width}T<$type>>)" {
                    for (x in 0 until k)
                        for (y in 0 until height)
                            +"val v$x$y = a.row($x) dot b[$y]"

                    for (x in 0 until k)
                        for (y in 0 until height)
                            +"res[$x, $y] = v$x$y"
                }
            }

            "fun times(res: Vec${height}T<$type>, a: $MatNT<$type, out Vec${height}T<$type>>, b: Vec${width}T<$type>)" {
                for (x in 0 until height)
                    +"val v$x = a.row($x) dot b"

                for (x in 0 until height)
                    +"res[$x] = v$x"
            }

            "fun times(res: Vec${width}T<$type>, a: Vec${height}T<$type>, b: $MatNT<$type, out Vec${height}T<$type>>)" {
                for (x in 0 until width)
                    +"val v$x = a dot b[$x]"

                for (x in 0 until width)
                    +"res[$x] = v$x"
            }
        }
    }

    +"infix operator fun Vec${height}T<$type>.times(m: $MatNT<$type, out Vec${height}T<$type>>) = $matID.Operations.times(Vec$width$id(), this, m)"
    +"fun Vec${height}T<$type>.times(m: $MatNT<$type, out Vec${height}T<$type>>, res: Vec${width}T<$type>) = $matID.Operations.times(res, this, m)"
    if (width == height)
        +"infix operator fun Vec${height}T<$type>.timesAssign(m: $MatNT<$type, out Vec${height}T<$type>>) = $matID.Operations.times(this, this, m)"
    +"// -- Binary operators --"
    for ((char, operation) in operators) {
        +"operator fun $type.$operation(m: $matID): $matID = $operation(m, $matID())"
        +"fun $type.$operation(m: $matID, res: $matID): $matID = $operation(m) { $`abcdN type` -> res($abcdN) }"
        +"""
            inline fun <R> $type.$operation(m: $matID, res: ($`abcdN type`) -> R): R {
                $contract
                return $operation($`m,abcdN`, res)
            }"""
        val `this op abcdN` = abcdJoint(",\n") { "this $char $it" }
        +"""
            inline fun <R> $type.$operation($`abcdN type`, res: ($`abcdN type`) -> R): R {
                $contract
                return res($`this op abcdN`)
            }"""
    }
}
