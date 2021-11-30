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

    for ((type, extension, _, id) in (numberTypeInformation - unsignedTypes)) {
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

        for (k in 2..4) {
            +"abstract infix operator fun times(other: Mat${matrixSizeString(k, width)}T<N, out Vec${width}T<N>>)"
            +"fun times(other: Mat${matrixSizeString(k, width)}T<N, out Vec${width}T<N>>, res: Mat${matrixSizeString(k, height)}T<N, out Vec${height}T<N>>) = Mat${matrixSizeString(width, height)}Operations.times(res, this, other)"
        }
//        +"infix operator fun timesAssign(other: Mat${matrixSizeString(height, width)}T<N, out Vec${width}T<N>>) = Mat${matrixSizeString(width, height)}Operations.times(this, this, other)"

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
//    abcd(3, 3) { c, r, s -> +"import glm.mat${sizeId(c + 2, r + 2)}.*" }
    for (i in 2..4) {
        +"import glm.mat${matrixSizeString(i, width)}.*"
        +"import glm.mat${matrixSizeString(i, height)}.*"
    }

    val mat = "Mat${matrixSizeString(width, height)}"
    "class $mat$id private constructor(var array: ${type}Array) : ${mat}T<$type, Vec$height$id>()" {
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

        val arrayOf = "${type.lowercase()}ArrayOf"
        if (width == height) {
            +"// Implicit basic constructors"
            +"constructor() : this(1)"
            +"constructor(m: $mat$id) : this(${abcdJoint(width, height) { c -> "m.$c" }})"

            +"// Explicit basic constructors"
            +"constructor(s: Number) : this(${"s" * width})"
            if (width > 2) {
                +"constructor(${xyzwJoint(width - 1) { c -> "$c: Number" }}) : this(${xyzwJoint(width - 1) { c -> c }}, 1)"
            }

            +"constructor(${xyzwJoint(width) { c -> "$c: Number" }}) : this("
            indent {
                +(abcdJoint(width, height, ",\n$indentation") { i, j, _ -> if (i == j) xyzw[i] else "0" } + ")")
            }

            +"constructor(${abcdJoint(width, height, ",\n$indentation\t\t\t") { i, j, _ -> "${xyzw[i]}$j: Number" }}) : this($arrayOf("
            indent {
                +(abcdJoint(width, height, ",\n$indentation") { i, j, _ -> "${xyzw[i]}$j.$extension" } + "))")
            }
        }

        +"constructor(array: ${type}Array, transpose: Boolean = false) : this("
        indent {
            +("if (transpose) $arrayOf(" + abcdJoint(width, height, ",\n$indentation") { i, j, _ -> "array[${i * height + j}]" } + ")\n${indentation}else array.copyOf())")
        }

        if (width == height) {

            +"// Invoke functions"
            +"operator fun invoke(s: Number) = invoke(${"s" * width})"
            if (width > 2) {
                +"operator fun invoke(${xyzwJoint(width - 1) { c -> "$c: Number" }}) = invoke(${xyzwJoint(width - 1) { c -> c }}, 1)"
            }

            +"operator fun invoke(${xyzwJoint(width) { c -> "$c: Number" }}) = invoke("
            indent {
                +(abcdJoint(width, height, ",\n$indentation") { i, j, _ -> if (i == j) xyzw[i] else "0" } + ")")
            }

            +"operator fun invoke(${abcdJoint(width, height, ",\n$indentation\t\t\t") { c -> "$c: Number" }}) = put(${abcdJoint(width, height) { c -> "$c.$extension" }})"
            +"operator fun invoke(m: $mat$id) = put(m)"

            +"fun identity() = invoke(1)"

            +"// Put functions"
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

            +"// Unary operators"
            +"operator fun unaryMinus() = $mat$id("
            indent {
                +(abcdJoint(width, height, ",\n$indentation") { c -> c } + ")")
            }
        }

        +"// Matrix multiplication"
        for (k in 2..4) {
            +"override infix operator fun times(other: Mat${matrixSizeString(k, width)}T<$type, out Vec${width}T<$type>>) = Mat${matrixSizeString(width, height)}Operations.times(Mat${matrixSizeString(k, height)}$id(${type}Array(${k * height})), this, other)"
        }

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

        +"override val isIdentity: Boolean"
        indent {
            if (width != height) {
                +"get() = false"
            } else {
                +("get() =" + abcdJoint(width, height, " &&\n$indentation\t\t", " && ") { i, j, _ -> if (i == j) "this[$i, $j] == 1.$extension" else "this[$i, $j] == 0.$extension" })
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
    }
}
