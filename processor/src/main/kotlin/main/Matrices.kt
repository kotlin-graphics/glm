package main

import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.Dependencies

fun matrices(generator: CodeGenerator) {
    for (i in 2..4) {
        for (j in 2..4) {
            generator.createNewFile(dependencies = Dependencies(false), packageName = "glm.mat${matrixSizeString(i, j)}", fileName = "Mat${matrixSizeString(i, j)}T").use {
                text.clear()

                matricesT(i, j)

                it.write(text.toString().toByteArray())
            }
        }
    }

    for ((type, extension, _, id) in matrixTypes) {
        for (i in 2..4) {
            for (j in 2..4) {
                generator.createNewFile(dependencies = Dependencies(false), packageName = "glm.mat${matrixSizeString(i, j)}", fileName = "Mat${matrixSizeString(i, j)}$id").use {
                    text.clear()

                    matrices(i, j, type, extension, id)

                    it.write(text.toString().toByteArray())
                }
            }
        }
    }
}

fun matrixSizeString(width: Int, height: Int) = if (width == height) "$width" else "${width}x$height"


private fun matricesT(width: Int, height: Int) {
    +"package glm.mat${matrixSizeString(width, height)}"

    +"import glm.vec$height.*"
    +"import glm.vec$width.*"
    //    abcd(3, 3) { c, r, s -> +"import glm.mat${matrixSizeString(c + 2, r + 2)}.*" }
    for (i in 2..4) {
        +"import glm.mat${matrixSizeString(i, width)}.*"
        +"import glm.mat${matrixSizeString(i, height)}.*"
    }

    "abstract class Mat${matrixSizeString(width, height)}T<N : Number, V : Vec${height}T<N>>" {
        abcd(width, height) { c -> +"abstract var $c: N" }
        abcd(width, height) { i, j, c -> +"operator fun component${i * height + j + 1}() = $c" }

        +"// -- Component accesses --"

        +"abstract operator fun get(column: Int): V"
        +"operator fun get(column: Int, row: Int): N = get(column).get(row)"

        +"abstract operator fun set(column: Int, value: Vec${height}T<out Number>)"
        +"operator fun set(column: Int, row: Int, value: N) = get(column).set(row, value)"

        +"abstract fun row(row: Int): Vec${width}T<N>"
        +"abstract fun row(row: Int, value: Vec${width}T<out Number>)"

        +"// -- Matrix multiplications --"

        for (k in 2..4) {
            +"abstract infix operator fun times(other: Mat${matrixSizeString(k, width)}T<N, out Vec${width}T<N>>)"
            +"abstract fun times(other: Mat${matrixSizeString(k, width)}T<N, out Vec${width}T<N>>, res: Mat${matrixSizeString(k, height)}T<N, out Vec${height}T<N>>)"
        }
        if (width == height) {
            +"abstract infix operator fun timesAssign(other: Mat${matrixSizeString(height, width)}T<N, out Vec${width}T<N>>)"
        }
        +"abstract infix operator fun times(v: Vec${width}T<N>)"
        +"abstract fun times(v: Vec${width}T<N>, res: Vec${height}T<N>)"

        +"// -- Aliases --"

        abcd(width, height) { i, j, c ->
            +"var ${vNN(i, j)}: N"
            indent {
                +"get() = $c"
                "set(value)" {
                    +"$c = value"
                }
            }
        }

        +"abstract val isIdentity: Boolean"

        "companion object" {
            +"const val length = $width * $height"
        }

        +"override fun toString() = \"\"\""
        indent {
            +("|" + abcdJoint(height, width, "\n$indentation|", " ") { i, j, _ -> "$${vNN(j, i)}" } + "\"\"\".trimMargin()")
        }
    }
}

private fun matrices(width: Int, height: Int, type: String, extension: String, id: String) {
    +"package glm.mat${matrixSizeString(width, height)}"

    +"import glm.*"
    +"import glm.extensions.*"
    repeat(4) { +"import glm.vec${it + 1}.*" }
    abcd(3, 3) { c, r, _ -> +"import glm.mat${matrixSizeString(c + 2, r + 2)}.*" }
    +"import kotlin.math.abs"

    val mat = "Mat${matrixSizeString(width, height)}"
    "open class $mat$id protected constructor(var array: ${type}Array) : ${mat}T<$type, Vec$height$id>()" {
        abcd(width, height) { i, j, c ->
            val ofs = i * height + j

            +"override var $c: $type"
            indent {
                +"get() = array[$ofs]"
                "set(value)" {
                    +"array[$ofs] = value"
                }
            }
        }

        +"// -- Constructors --"
        +"constructor() : this(1)"
        +"constructor(m: $mat$id) : this(${abcdJoint(width, height) { c -> "m.$c" }})"
        +"constructor(scalar: $type) : this(${abcdJoint(width, height) { c, r, _ -> if (c == r) "scalar" else "0" }})"
        +"constructor(${abcdJoint(width, height, ",\n\t\t\t\t") { text -> "$text: $type" }}"
        text.deleteAt(text.lastIndex)
        val arrayOf = "${type.lowercase()}ArrayOf"
        text += ") : this($arrayOf(${abcdJoint(width, height) { text -> text }}))"

        +"constructor(${(0 until width).joinToString(",\n\t\t\t\t") { "v$it: Vec$height$id" }}"
        text.deleteAt(text.lastIndex)
        text += ") : this(${(0 until width).joinToString { i -> xyzwJoint(height) { _, s -> "v$i.$s" } }})"

        // -- Conversions --
        +"constructor(s: Number) : this(s.$extension)"
        +"constructor(m: ${mat}T<*, Vec${height}T<*>>) : this(${abcdJoint(width, height) { c -> "m.$c" }})"

        if (width == height) {
            if (width > 2) {
                +"constructor(${xyzwJoint(width - 1) { c -> "$c: Number" }}) : this(${xyzwJoint(width - 1) { c -> c }}, 1)"
            }
            +"constructor(${xyzwJoint(width) { c -> "$c: Number" }}) : this("
            indent {
                +(abcdJoint(width, height, ",\n$indentation") { i, j, _ -> if (i == j) xyzw[i] else "0" } + ")")
            }
        }

        +"constructor(${abcdJoint(width, height, ",\n$indentation\t\t\t") { i, j, _ -> "${xyzw[i]}$j: Number" }}) : this($arrayOf("
        indent {
            +(abcdJoint(width, height, ",\n$indentation") { i, j, _ -> "${xyzw[i]}$j.$extension" } + "))")
        }

        +"// -- Matrix conversions --"
        abcd(3, 3) { i, j, _ ->
            val c = i + 2
            val r = j + 2
            if (c != width || r != height) {
                val sep = ",\n\t\t\t\t\t\t\t\t" + if (c != r) "  " else ""
                val args = abcdJoint(width, height, sep) { col, row, text ->
                    when {
                        row < r && col < c -> "m.$text"
                        col == row -> "1"
                        else -> "0"
                    }
                }
                +"constructor(m: Mat${matrixSizeString(c, r)}) : this($args)"
            }
        }

        +"constructor(array: ${type}Array, transpose: Boolean = false) : this("
        indent {
            +("if (transpose) $arrayOf(" + abcdJoint(width, height, ",\n$indentation") { i, j, _ -> "array[${i * height + j}]" } + ")\n${indentation}else array.copyOf())")
        }

        +"// -- Invoke functions --"
        +"operator fun invoke(s: Number): $mat$id = invoke(${"s" * width})"
        if (width > 2) {
            +"operator fun invoke(${xyzwJoint(width - 1) { c -> "$c: Number" }}): $mat$id = invoke(${xyzwJoint(width - 1) { c -> c }}, 1)"
        }

        +"operator fun invoke(${xyzwJoint(width) { c -> "$c: Number" }}): $mat$id = invoke("
        indent {
            +(abcdJoint(width, height, ",\n$indentation") { i, j, _ -> if (i == j) xyzw[i] else "0" } + ")")
        }

        "operator fun invoke(${abcdJoint(width, height, ",\n$indentation\t\t\t") { c -> "$c: Number" }}): $mat$id" {
            +"put(${abcdJoint(width, height) { c -> "$c.$extension" }})"
            +"return this"
        }
        "operator fun invoke(m: $mat$id): $mat$id" {
            +"put(m)"
            +"return this"
        }

        if (width == height) {
            +"fun identity() = invoke(1)"
        }

        +"// -- Put functions --"
        +"fun put(s: Number) = put(${"s" * width})"
        if (width > 2) {
            +"fun put(${xyzwJoint(width - 1) { c -> "$c: Number" }}) = put(${xyzwJoint(width - 1) { c -> c }}, 1)"
        }

        +"fun put(${xyzwJoint(width) { c -> "$c: Number" }}) = put("
        indent {
            +(abcdJoint(width, height, ",\n$indentation") { i, j, _ -> if (i == j) xyzw[i] else "0" } + ")")
        }

        "fun put(${abcdJoint(width, height, ",\n$indentation\t\t\t") { c -> "$c: Number" }})" {
            abcd(width, height) { i, j, c ->
                +"array[${i * height + j}] = $c.$extension"
            }
        }
        "fun put(m: $mat$id)" {
            "if (this !== m)" {
                +"m.array.copyInto(array, 0, 0, length)"
            }
        }

        +"// -- Matrix multiplication --"
        for (k in 2..4) {
            +"override infix operator fun times(other: Mat${matrixSizeString(k, width)}T<$type, out Vec${width}T<$type>>) = Operations.times(Mat${matrixSizeString(k, height)}$id(${type}Array(${k * height})), this, other)"
            +"override fun times(other: Mat${matrixSizeString(k, width)}T<$type, out Vec${width}T<$type>>, res: Mat${matrixSizeString(k, height)}T<$type, out Vec${height}T<$type>>) = Operations.times(res, this, other)"
        }
        if (width == height) {
            +"override infix operator fun timesAssign(other: Mat${matrixSizeString(height, width)}T<$type, out Vec${width}T<$type>>) = Operations.times(this, this, other)"
        }
        +"override infix operator fun times(v: Vec${width}T<$type>) = Operations.times(Vec$height$id(), this, v)"
        +"override fun times(v: Vec${width}T<$type>, res: Vec${height}T<$type>) = Operations.times(res, this, v)"

        +"// -- Accesses --"

        +"override operator fun get(column: Int) = Vec$height$id(array, column * $height)"
        +"override fun row(row: Int) = Vec$width$id(${xyzwJoint(width) { i, _ -> "${i * height} + row" }})"

        "override operator fun set(column: Int, value: Vec${height}T<out Number>)" {
            xyzw(height) { i, c ->
                val delta = if (i == 0) "" else " + $i"

                +"array[column * $height$delta] = value.$c.$extension"
            }
        }
        "override fun row(row: Int, value: Vec${width}T<out Number>)" {
            xyzw(width) { i, c ->
                val delta = if (i == 0) "" else " + $i * $height"

                +"array[row$delta] = value.$c.$extension"
            }
        }

        +"// -- Unary arithmetic operators --"
        for ((char, operation) in operators) {
            "operator fun ${operation}Assign(scalar: Number)" {
                abcd(width, height) { s -> +"$s = ($s $char scalar.$extension).$extension" }
            }
            "operator fun ${operation}Assign(m: $mat$id)" {
                abcd(width, height) { s -> +"$s = ($s $char m.$s).$extension" }
            }
        }

        +"operator fun unaryPlus() = this"
        +"operator fun unaryMinus() = $mat$id("
        indent {
            +(abcdJoint(width, height, ",\n$indentation") { c -> "-$c" } + ")")
        }

        +"// -- Increment and decrement operators --"
        "operator fun inc(): $mat$id" {
            abcd(width, height) { s -> +"$s = ($s + 1.$extension).$extension" }
            +"return this"
        }
        "operator fun dec(): $mat$id" {
            abcd(width, height) { s -> +"$s = ($s - 1.$extension).$extension" }
            +"return this"
        }

        +"// -- Binary operators --"
        for ((char, operation) in operators) {
            val sep = ",\n\t\t\t\t\t\t\t\t\t\t\t\t"
            lateinit var args: String
            +"infix operator fun $operation(scalar: $type): $mat$id = $operation(scalar, $mat$id())"
            +"fun $operation(scalar: $type, res: $mat$id): $mat$id = res(${abcdJoint(width, height, sep) { s -> "$s $char scalar" }})"
            if (char == "*") {
                args = xyzwJoint(height, sep) { i, _ -> (0 until width).joinToString(" + ") { "${abcd[it]}$i $char v.${xyzw[it]}" } }
                +"infix operator fun times(v: Vec$width$id): Vec$height$id = times(v, Vec$height$id())"
                +"fun times(v: Vec$width$id, res: Vec$height$id): Vec$height$id = Vec$height$id($args)"
            }
            if (char == "*" || char == "/") {
                if (width == height) {
                    +"infix operator fun $operation(m: $mat$id): $mat$id = $operation(m, $mat$id())"
                    if (char == "*") {
                        args = abcdJoint(width, height, sep) { c, r, _ -> (0 until width).joinToString(" + ") { "${abcd[it]}$r * m.${abcd[c]}$it" } }
                        +"fun $operation(m: $mat$id, res: $mat$id): $mat$id = res($args)"
                    } else
                        "fun $operation(m: $mat$id, res: $mat$id): $mat$id" {
                            val one = when (type) {
                                "Float" -> "1f"
                                "Double" -> "1.0"
                                else -> "1"
                            }
                            if (width == 4) {
                                +"val coef00 = m.c2 * m.d3 - m.d2 * m.c3"
                                +"val coef02 = m.b2 * m.d3 - m.d2 * m.b3"
                                +"val coef03 = m.b2 * m.c3 - m.c2 * m.b3"
                                +"val coef04 = m.c1 * m.d3 - m.d1 * m.c3"
                                +"val coef06 = m.b1 * m.d3 - m.d1 * m.b3"
                                +"val coef07 = m.b1 * m.c3 - m.c1 * m.b3"
                                +"val coef08 = m.c1 * m.d2 - m.d1 * m.c2"
                                +"val coef10 = m.b1 * m.d2 - m.d1 * m.b2"
                                +"val coef11 = m.b1 * m.c2 - m.c1 * m.b2"
                                +"val coef12 = m.c0 * m.d3 - m.d0 * m.c3"
                                +"val coef14 = m.b0 * m.d3 - m.d0 * m.b3"
                                +"val coef15 = m.b0 * m.c3 - m.c0 * m.b3"
                                +"val coef16 = m.c0 * m.d2 - m.d0 * m.c2"
                                +"val coef18 = m.b0 * m.d2 - m.d0 * m.b2"
                                +"val coef19 = m.b0 * m.c2 - m.c0 * m.b2"
                                +"val coef20 = m.c0 * m.d1 - m.d0 * m.c1"
                                +"val coef22 = m.b0 * m.d1 - m.d0 * m.b1"
                                +"val coef23 = m.b0 * m.c1 - m.c0 * m.b1"
                                +"var i00 = + m.b1 * coef00 - m.b2 * coef04 + m.b3 * coef08"
                                +"var i10 = - m.a1 * coef00 + m.a2 * coef04 - m.a3 * coef08"
                                +"var i20 = + m.a1 * coef02 - m.a2 * coef06 + m.a3 * coef10"
                                +"var i30 = - m.a1 * coef03 + m.a2 * coef07 - m.a3 * coef11"
                                +"var i01 = - m.b0 * coef00 + m.b2 * coef12 - m.b3 * coef16"
                                +"var i11 = + m.a0 * coef00 - m.a2 * coef12 + m.a3 * coef16"
                                +"var i21 = - m.a0 * coef02 + m.a2 * coef14 - m.a3 * coef18"
                                +"var i31 = + m.a0 * coef03 - m.a2 * coef15 + m.a3 * coef19"
                                +"var i02 = + m.b0 * coef04 - m.b1 * coef12 + m.b3 * coef20"
                                +"var i12 = - m.a0 * coef04 + m.a1 * coef12 - m.a3 * coef20"
                                +"var i22 = + m.a0 * coef06 - m.a1 * coef14 + m.a3 * coef22"
                                +"var i32 = - m.a0 * coef07 + m.a1 * coef15 - m.a3 * coef23"
                                +"var i03 = - m.b0 * coef08 + m.b1 * coef16 - m.b2 * coef20"
                                +"var i13 = + m.a0 * coef08 - m.a1 * coef16 + m.a2 * coef20"
                                +"var i23 = - m.a0 * coef10 + m.a1 * coef18 - m.a2 * coef22"
                                +"var i33 = + m.a0 * coef11 - m.a1 * coef19 + m.a2 * coef23"
                            }
                            +"val oneOverDeterminant = $one / ("
                            when (width) {
                                2 -> {
                                    +"\t+ m.a0 * m.b1"
                                    +"\t- m.b0 * m.a1)"
                                }
                                3 -> {
                                    +"\t+ m.a0 * (m.b1 * m.c2 - m.c1 * m.b2)"
                                    +"\t- m.b0 * (m.a1 * m.c2 - m.c1 * m.a2)"
                                    +"\t+ m.c0 * (m.a1 * m.b2 - m.b1 * m.a2))"
                                }
                                else -> text += "\tm.a0 * i00 + m.a1 * i10 + m.a2 * i20 + m.a3 * i30)"
                            }

                            when (width) {
                                2 -> {
                                    +"val i00 = + m.b1 * oneOverDeterminant"
                                    +"val i01 = - m.a1 * oneOverDeterminant"
                                    +"val i10 = - m.b0 * oneOverDeterminant"
                                    +"val i11 = + m.a0 * oneOverDeterminant"
                                    //                                    +"return res(a0 * i00 + b0 * i01,"
                                    //                                    +"\t\ta1 * i00 + b1 * i01,"
                                    //                                    +"\t\ta0 * i10 + b0 * i11,"
                                    //                                    +"\t\ta1 * i10 + b1 * i11)"
                                }
                                3 -> {
                                    +"val i00 = + (m.b1 * m.c2 - m.c1 * m.b2) * oneOverDeterminant"
                                    +"val i10 = - (m.a1 * m.c2 - m.c1 * m.a2) * oneOverDeterminant"
                                    +"val i20 = + (m.a1 * m.b2 - m.b1 * m.a2) * oneOverDeterminant"
                                    +"val i01 = - (m.b0 * m.c2 - m.c0 * m.b2) * oneOverDeterminant"
                                    +"val i11 = + (m.a0 * m.c2 - m.c0 * m.a2) * oneOverDeterminant"
                                    +"val i21 = - (m.a0 * m.b2 - m.b0 * m.a2) * oneOverDeterminant"
                                    +"val i02 = + (m.b0 * m.c1 - m.c0 * m.b1) * oneOverDeterminant"
                                    +"val i12 = - (m.a0 * m.c1 - m.c0 * m.a1) * oneOverDeterminant"
                                    +"val i22 = + (m.a0 * m.b1 - m.b0 * m.a1) * oneOverDeterminant"
                                    //                                    +"return res(a[0] * m2[0][0] + b[0] * m2[0][1],"
                                    //                                    +"\t\t\ta[1] * m2[0][0] + b[1] * m2[0][1],"
                                    //                                    +"\t\t\ta[0] * m2[1][0] + b[0] * m2[1][1],"
                                    //                                    +"\t\t\ta[1] * m2[1][0] + b[1] * m2[1][1],"
                                    //                                    +"\t\t\ta[0] * m2[2][0] + b[0] * m2[2][1],"
                                    //                                    +"\t\t\ta[1] * m2[2][0] + b[1] * m2[2][1]"
                                }
                                4 -> {
                                    +"i00 *= oneOverDeterminant"
                                    +"i10 *= oneOverDeterminant"
                                    +"i20 *= oneOverDeterminant"
                                    +"i30 *= oneOverDeterminant"
                                    +"i01 *= oneOverDeterminant"
                                    +"i11 *= oneOverDeterminant"
                                    +"i21 *= oneOverDeterminant"
                                    +"i31 *= oneOverDeterminant"
                                    +"i02 *= oneOverDeterminant"
                                    +"i12 *= oneOverDeterminant"
                                    +"i22 *= oneOverDeterminant"
                                    +"i32 *= oneOverDeterminant"
                                    +"i03 *= oneOverDeterminant"
                                    +"i13 *= oneOverDeterminant"
                                    +"i23 *= oneOverDeterminant"
                                    +"i33 *= oneOverDeterminant"
                                }
                            }
                            args = abcdJoint(width, height, ",\n\t\t\t\t") { c, r, _ -> (0 until width).joinToString(" + ") { "${abcd[it]}$r * i$c$it" } }
                            +"return res($args)"
                        }
                }
            } else {
                args = abcdJoint(width, height, sep) { s -> "$s $char m.$s" }
                +"infix operator fun $operation(m: $mat$id): $mat$id = $mat$id($args)"
            }
        }

        if (width == height)
            "fun inverse(res: $mat$id = $mat$id()): $mat$id" {
                val one = when (type) {
                    "Float" -> "1f"
                    "Double" -> "1.0"
                    else -> "1"
                }
                if (width == 4) {
                    +"val coef00 = c2 * d3 - d2 * c3"
                    +"val coef02 = b2 * d3 - d2 * b3"
                    +"val coef03 = b2 * c3 - c2 * b3"
                    +"val coef04 = c1 * d3 - d1 * c3"
                    +"val coef06 = b1 * d3 - d1 * b3"
                    +"val coef07 = b1 * c3 - c1 * b3"
                    +"val coef08 = c1 * d2 - d1 * c2"
                    +"val coef10 = b1 * d2 - d1 * b2"
                    +"val coef11 = b1 * c2 - c1 * b2"
                    +"val coef12 = c0 * d3 - d0 * c3"
                    +"val coef14 = b0 * d3 - d0 * b3"
                    +"val coef15 = b0 * c3 - c0 * b3"
                    +"val coef16 = c0 * d2 - d0 * c2"
                    +"val coef18 = b0 * d2 - d0 * b2"
                    +"val coef19 = b0 * c2 - c0 * b2"
                    +"val coef20 = c0 * d1 - d0 * c1"
                    +"val coef22 = b0 * d1 - d0 * b1"
                    +"val coef23 = b0 * c1 - c0 * b1"
                    +"val x = a0"
                    +"val y = a1"
                    +"val z = a2"
                    +"val w = a3"
                    +"val inverse = res(+ b1 * coef00 - b2 * coef04 + b3 * coef08, - a1 * coef00 + a2 * coef04 - a3 * coef08, + a1 * coef02 - a2 * coef06 + a3 * coef10, - a1 * coef03 + a2 * coef07 - a3 * coef11,"
                    +"\t\t\t- b0 * coef00 + b2 * coef12 - b3 * coef16, + a0 * coef00 - a2 * coef12 + a3 * coef16, - a0 * coef02 + a2 * coef14 - a3 * coef18, + a0 * coef03 - a2 * coef15 + a3 * coef19,"
                    +"\t\t\t+ b0 * coef04 - b1 * coef12 + b3 * coef20, - a0 * coef04 + a1 * coef12 - a3 * coef20, + a0 * coef06 - a1 * coef14 + a3 * coef22, - a0 * coef07 + a1 * coef15 - a3 * coef23,"
                    +"\t\t\t- b0 * coef08 + b1 * coef16 - b2 * coef20, + a0 * coef08 - a1 * coef16 + a2 * coef20, - a0 * coef10 + a1 * coef18 - a2 * coef22, + a0 * coef11 - a1 * coef19 + a2 * coef23)"
                }
                +"val oneOverDeterminant = $one / ("
                when (width) {
                    2 -> {
                        +"\t+ a0 * b1"
                        +"\t- b0 * a1)"
                    }
                    3 -> {
                        +"\t+ a0 * (b1 * c2 - c1 * b2)"
                        +"\t- b0 * (a1 * c2 - c1 * a2)"
                        +"\t+ c0 * (a1 * b2 - b1 * a2))"
                    }
                    else -> text.deleteAt(text.lastIndex).appendLine("x * inverse.a0 + y * inverse.b0 + z * inverse.c0 + w * inverse.d0)")
                }

                when (width) {
                    2 -> {
                        +"return res("
                        +"\t+ b1 * oneOverDeterminant,"
                        +"\t- a1 * oneOverDeterminant,"
                        +"\t- b0 * oneOverDeterminant,"
                        +"\t+ a0 * oneOverDeterminant)"
                    }
                    3 -> {
                        +"return res("
                        +"\t+ (b1 * c2 - c1 * b2) * oneOverDeterminant,"
                        +"\t- (a1 * c2 - c1 * a2) * oneOverDeterminant,"
                        +"\t+ (a1 * b2 - b1 * a2) * oneOverDeterminant,"
                        +"\t- (b0 * c2 - c0 * b2) * oneOverDeterminant,"
                        +"\t+ (a0 * c2 - c0 * a2) * oneOverDeterminant,"
                        +"\t- (a0 * b2 - b0 * a2) * oneOverDeterminant,"
                        +"\t+ (b0 * c1 - c0 * b1) * oneOverDeterminant,"
                        +"\t- (a0 * c1 - c0 * a1) * oneOverDeterminant,"
                        +"\t+ (a0 * b1 - b0 * a1) * oneOverDeterminant)"
                    }
                    else -> {
                        +"inverse *= oneOverDeterminant"
                        +"return inverse"
                    }
                }
            }

        if (type == "Float" || type == "Double") {
            +"fun equal(m: $mat$id, epsilon: $type = $type.MIN_VALUE) = BooleanArray(length) { abs(array[it] - m.array[it]) <= epsilon }"
            +"fun notEqual(m: $mat$id, epsilon: $type = $type.MIN_VALUE) = BooleanArray(length) { abs(array[it] - m.array[it]) > epsilon }"
            "fun allEqual(m: $mat$id, epsilon: $type = $type.MIN_VALUE): Boolean" {
                +"for (i in 0 until length)"
                +"\tif(abs(array[i] - m.array[i]) > epsilon)"
                +"\t\treturn false"
                +"return true"
            }
            "fun anyNotEqual(m: $mat$id, epsilon: $type = $type.MIN_VALUE): Boolean" {
                +"for (i in 0 until length)"
                +"\tif(abs(array[i] - m.array[i]) > epsilon)"
                +"\t\treturn true"
                +"return false"
            }
        } else {
            +"infix fun equal(m: $mat$id) = BooleanArray(length) { array[it] == m.array[it] }"
            +"infix fun notEqual(m: $mat$id) = BooleanArray(length) { array[it] != m.array[it] }"
            +"fun allEqual(m: $mat$id): Boolean = array.contentEquals(m.array)"
            +"fun anyNotEqual(m: $mat$id): Boolean = !array.contentEquals(m.array)"
        }

        +"override val isIdentity: Boolean"
        indent {
            if (width != height) {
                +"get() = false"
            } else {
                +("get() = " + abcdJoint(width, height, " &&\n$indentation\t\t", " && ") { i, j, _ -> if (i == j) "this[$i, $j] == 1.$extension" else "this[$i, $j] == 0.$extension" })
            }
        }

        "companion object" {
            +"const val length = ${mat}T.length"
            +"val size = length * $type.BYTES"
            if (width == height)
                +"val identity get() = $mat$id()"

        }

        +"fun size() = size"
        +"fun elementCount() = length"

        +"override fun equals(other: Any?) = other is $mat$id && array.contentEquals(other.array)"


        "object Operations" {
            for (k in 2..4) {
                "fun times(res: Mat${matrixSizeString(k, height)}T<$type, out Vec${height}T<$type>>, a: Mat${matrixSizeString(width, height)}T<$type, out Vec${height}T<$type>>, b: Mat${matrixSizeString(k, width)}T<$type, out Vec${width}T<$type>>)" {
                    for (x in 0 until k) {
                        for (y in 0 until height) {
                            +"val v$x$y = a.row($x) dot b[$y]"
                        }
                    }

                    for (x in 0 until k) {
                        for (y in 0 until height) {
                            +"res[$x, $y] = v$x$y"
                        }
                    }
                }
            }

            "fun times(res: Vec${height}T<$type>, a: Mat${matrixSizeString(width, height)}T<$type, out Vec${height}T<$type>>, b: Vec${width}T<$type>)" {
                for (x in 0 until height) {
                    +"val v$x = a.row($x) dot b"
                }

                for (x in 0 until height) {
                    +"res[$x] = v$x"
                }
            }

            "fun times(res: Vec${width}T<$type>, a: Vec${height}T<$type>, b: Mat${matrixSizeString(width, height)}T<$type, out Vec${height}T<$type>>)" {
                for (x in 0 until width) {
                    +"val v$x = a dot b[$x]"
                }

                for (x in 0 until width) {
                    +"res[$x] = v$x"
                }
            }
        }
    }

    +"infix operator fun Vec${height}T<$type>.times(m: Mat${matrixSizeString(width, height)}T<$type, out Vec${height}T<$type>>) = $mat$id.Operations.times(Vec$width$id(), this, m)"
    +"fun Vec${height}T<$type>.times(m: Mat${matrixSizeString(width, height)}T<$type, out Vec${height}T<$type>>, res: Vec${width}T<$type>) = $mat$id.Operations.times(res, this, m)"
    if (width == height) {
        +"infix operator fun Vec${height}T<$type>.timesAssign(m: Mat${matrixSizeString(width, height)}T<$type, out Vec${height}T<$type>>) = $mat$id.Operations.times(this, this, m)"
    }
    +"// -- Binary operators --"
    for ((char, operation) in operators) {
        val args = abcdJoint(width, height, ",\n\t\t\t\t\t\t\t\t\t") { s -> "this $char m.$s" }
        +"operator fun $type.$operation(m: $mat$id) = $mat$id($args)"
    }
}
