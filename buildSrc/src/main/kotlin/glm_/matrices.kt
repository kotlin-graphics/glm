package glm_

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

        +"abstract operator fun set(column: Int, value: Vec${height}T<out Number>)"
        +"operator fun set(column: Int, row: Int, value: N) = get(column).set(row, value)"

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
            +"var ${vNN(i, j)}: N"
            indent {
                +"get() = $c"
                +"set(value) { $c = value }"
            }
        }

        +"abstract val isIdentity: Boolean"

        "companion object" {
            +"const val length = $width * $height"
        }

        +"override fun toString() = \"\"\""
        indent {
            +("|" + abcdJointIndexed(height, width, "\n|", " ") { i, j, _ -> "$${vNN(j, i)}" } + "\"\"\".trimMargin()")
        }
    }
}

private fun Generator.matrices(width: Int, height: Int, type: String, extension: String, id: String) {

    val matID = "Mat$matrixSize$id"
    val `m,abcdN` = abcdJoint(",\n") { "m.$it" }
    val abcdN = abcdJoint(",\n") { it }
    val `resXYZW type` = WxyzJoint { "res$it: $type" }
    "open class $matID protected constructor(var array: ${type}Array) : $MatNT<$type, Vec$height$id>()" {

        val xyzwDiag = abcdJointIndexed(",\n") { i, j, _ -> if (i == j) glm_.xyzw[i] else "0" }

        abcdIndexed { i, j, c ->
            val ofs = i * height + j

            +"override var $c: $type"
            indent {
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

        +"constructor(array: ${type}Array, transpose: Boolean = false) : this("
        indent {
            val array = abcdJointIndexed(",\n") { i, j, _ -> "array[${i * height + j}]" }
            +"if (transpose) $arrayOf($array)"
            +"else array.copyOf())"
        }

        +"// -- Invoke functions --"
        +"operator fun invoke(s: Number): $matID = invoke(${"s" * width})"
        if (width > 2)
            +"operator fun invoke(${xyzwJoint(width - 1) { "$it: Number" }}): $matID = invoke(${xyzwJoint(width - 1)}, 1)"

        +"operator fun invoke(${xyzwJoint(width) { "$it: Number" }}): $matID = invoke("
        indent {
            +(xyzwDiag + ")")
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
        "fun put(m: $matID)" {
            "if (this !== m)" {
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

        "override operator fun set(column: Int, value: Vec${height}T<out Number>)" {
            xyzwIndexed(height) { i, c ->
                val delta = if (i == 0) "" else " + $i"

                +"array[column * $height$delta] = value.$c.$extension"
            }
        }
        "override fun row(row: Int, value: Vec${width}T<out Number>)" {
            xyzwIndexed(width) { i, c ->
                val delta = if (i == 0) "" else " + $i * $height"

                +"array[row$delta] = value.$c.$extension"
            }
        }

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
        +"operator fun unaryMinus() = $matID("
        indent {
            +(abcdJoint(",\n") { "-$it" } + ")")
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

        +"// -- Binary operators --"
        for ((char, operation) in operators) {
            +"infix operator fun $operation(scalar: $type): $matID = $operation(scalar, $matID())"
            +"fun $operation(scalar: $type, res: $matID): $matID = res(${abcdJoint(",\n") { "$it $char scalar" }})"
            if (char == "*") {
                val tmp = xyzwJointIndexed(height, ",\n") { i, _ ->
                    (0 until width).joinToString(" + ") { "${abcd[it]}$i $char v.${glm_.xyzw[it]}" }
                }
                +"infix operator fun times(v: Vec$width$id): Vec$height$id = times(v, Vec$height$id())"
                +"fun times(v: Vec$width$id, res: Vec$height$id): Vec$height$id = res($tmp)"
            }
            if (char == "*" || char == "/") {
                if (width == height) {
                    +"infix operator fun $operation(m: $matID): $matID = $operation(m, $matID())"
                    if (char == "*") {
                        val tmp = abcdJointIndexed(",\n") { c, r, _ -> (0 until width).joinToString(" + ") { "${abcd[it]}$r * m.${abcd[c]}$it" } }
                        +"fun times(m: $matID, res: $matID): $matID = res($tmp)"
                    } else
                        "fun div(m: $matID, res: $matID): $matID" {
                            invertMatrix(width, type)
                            val tmp = abcdJointIndexed(",\n") { c, r, _ -> (0 until width).joinToString(" + ") { "${abcd[it]}$r * i$c$it" } }
                            +"return res($tmp)"
                        }
                }
            } else {
                val tmp = abcdJoint(",\n") { "$it $char m.$it" }
                +"infix operator fun $operation(m: $matID): $matID = $matID($tmp)"
            }
        }

        if (width == height)
            "fun inverse(res: $matID = $matID()): $matID" {
                if (width == 4) {
                    +"""
                        val coef00 = c2 * d3 - d2 * c3
                        val coef02 = b2 * d3 - d2 * b3
                        val coef03 = b2 * c3 - c2 * b3
                        val coef04 = c1 * d3 - d1 * c3
                        val coef06 = b1 * d3 - d1 * b3
                        val coef07 = b1 * c3 - c1 * b3
                        val coef08 = c1 * d2 - d1 * c2
                        val coef10 = b1 * d2 - d1 * b2
                        val coef11 = b1 * c2 - c1 * b2
                        val coef12 = c0 * d3 - d0 * c3
                        val coef14 = b0 * d3 - d0 * b3
                        val coef15 = b0 * c3 - c0 * b3
                        val coef16 = c0 * d2 - d0 * c2
                        val coef18 = b0 * d2 - d0 * b2
                        val coef19 = b0 * c2 - c0 * b2
                        val coef20 = c0 * d1 - d0 * c1
                        val coef22 = b0 * d1 - d0 * b1
                        val coef23 = b0 * c1 - c0 * b1
                        val x = a0
                        val y = a1
                        val z = a2
                        val w = a3
                        val inverse = res(+ b1 * coef00 - b2 * coef04 + b3 * coef08, - a1 * coef00 + a2 * coef04 - a3 * coef08, + a1 * coef02 - a2 * coef06 + a3 * coef10, - a1 * coef03 + a2 * coef07 - a3 * coef11,
                                          - b0 * coef00 + b2 * coef12 - b3 * coef16, + a0 * coef00 - a2 * coef12 + a3 * coef16, - a0 * coef02 + a2 * coef14 - a3 * coef18, + a0 * coef03 - a2 * coef15 + a3 * coef19,
                                          + b0 * coef04 - b1 * coef12 + b3 * coef20, - a0 * coef04 + a1 * coef12 - a3 * coef20, + a0 * coef06 - a1 * coef14 + a3 * coef22, - a0 * coef07 + a1 * coef15 - a3 * coef23,
                                          - b0 * coef08 + b1 * coef16 - b2 * coef20, + a0 * coef08 - a1 * coef16 + a2 * coef20, - a0 * coef10 + a1 * coef18 - a2 * coef22, + a0 * coef11 - a1 * coef19 + a2 * coef23)"""
                }
                when (width) {
                    2 -> +"val oneOverDeterminant = 1 / (+ a0 * b1\n- b0 * a1)"
                    3 -> +"""
                        val oneOverDeterminant = 1 / (+ a0 * (b1 * c2 - c1 * b2)
                                                      - b0 * (a1 * c2 - c1 * a2)
                                                      + c0 * (a1 * b2 - b1 * a2))"""
                    else -> +"val oneOverDeterminant = 1 / (x * inverse.a0 + y * inverse.b0 + z * inverse.c0 + w * inverse.d0)"
                }

                when (width) {
                    2 -> +"return res(+ b1 * oneOverDeterminant,\n- a1 * oneOverDeterminant,\n- b0 * oneOverDeterminant,\n+ a0 * oneOverDeterminant)"
                    3 -> +"""
                            return res(+ (b1 * c2 - c1 * b2) * oneOverDeterminant,
                                       - (a1 * c2 - c1 * a2) * oneOverDeterminant,
                                       + (a1 * b2 - b1 * a2) * oneOverDeterminant,
                                       - (b0 * c2 - c0 * b2) * oneOverDeterminant,
                                       + (a0 * c2 - c0 * a2) * oneOverDeterminant,
                                       - (a0 * b2 - b0 * a2) * oneOverDeterminant,
                                       + (b0 * c1 - c0 * b1) * oneOverDeterminant,
                                       - (a0 * c1 - c0 * a1) * oneOverDeterminant,
                                       + (a0 * b1 - b0 * a1) * oneOverDeterminant)"""
                    else -> {
                        +"inverse *= oneOverDeterminant"
                        +"return inverse"
                    }
                }
            }

        if (type in floatingPointTypes) {
            val `resWXYZ type` = WxyzJoint { "res$it: $type" }
            val resWXYZ = WxyzJoint { "res$it" }
            if (matrixSize == "3") {
                val doc = "Converts a pure rotation 3 * 3 matrix to a quaternion."
                docs(doc)
                +"fun toQuat(res: Quat$id = Quat$id()): Quat$id = toQuat { $`resWXYZ type` -> res($resWXYZ) }"
                docs(doc)
                "inline fun <R> toQuat(res: ($`resXYZW type`) -> R): R" {
                    contract
                    +"return toQuat($abcdN, res)"
                }
            } else if (matrixSize == "4") {
                val doc = "Converts a pure rotation 4 * 4 matrix to a quaternion."
                docs(doc)
                +"fun toQuat(res: Quat$id = Quat$id()): Quat$id = toQuat { $`resWXYZ type` -> res($resWXYZ) }"
                docs(doc)
                val abcdN3 = abcdJoint(3, 3, ",\n") { it }
                "inline fun <R> toQuat(res: ($`resXYZW type`) -> R): R" {
                    contract
                    +"return Mat3$id.toQuat($abcdN3, res)"
                }
            }
        }

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

        +"override val isIdentity: Boolean"
        indent {
            if (width != height)
                +"get() = false"
            else
                +("get() = " + abcdJointIndexed(" &&\n\t", " && ") { i, j, _ -> if (i == j) "this[$i, $j] == 1.$extension" else "this[$i, $j] == 0.$extension" })
        }

        "companion object" {
            +"const val length = $MatNT.length"
            +"val size = length * $type.BYTES"
            if (width == height)
                +"val identity get() = $matID()"

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
        val args = abcdJoint(",\n\t\t\t\t\t\t\t\t\t") { "this $char m.$it" }
        +"operator fun $type.$operation(m: $matID) = $matID($args)"
    }
}
