package main

import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.Dependencies

fun vecs(generator: CodeGenerator) {

    for (i in 1..4)
        generator.createNewFile(dependencies = Dependencies(false),
                                packageName = "glm.vec$i",
                                fileName = "Vec${i}T").use {

            val text = StringBuilder()
            `vec*t`(text, i)
            it.write(text.toString().toByteArray())
        }
}

fun `vec*t`(o: StringBuilder, ordinal: Int) {

    fun xyzw(block: (Int) -> String) {
        for (i in 0 until ordinal)
            o += block(i)
    }

    val fields = (1..ordinal).joinToString { "var ${xyzw[it - 1]}: T" }
    o += "package glm.vec$ordinal"
    o += "abstract class Vec${ordinal}T<T : Number>($fields)/*: ToBuffer*/ {"
    xyzw { "\tfun component$it() = ${xyzw[it]}" }

    o += "\n\t// aliases"

    xyzw {
        """${"\t"}var ${rgba[it]}: T
        get() = ${xyzw[it]}
        set(value) { ${xyzw[it]} = value }"""
    }
    xyzw {
        """${"\t"}var ${stpq[it]}: T
        get() = ${xyzw[it]}
        set(value) { ${xyzw[it]} = value }"""
    }

    o += "\n\t// -- Component accesses --"

    o += "\toperator fun get(index: Int) = when (index) {"
    xyzw { "\t\t$it -> ${xyzw[it]}" }
    o += "\t\telse -> throw IndexOutOfBoundsException()\n\t}"

    o += "\toperator fun set(index: Int, value: T) = when(index) {"
    xyzw { "\t\t$it -> { ${xyzw[it]} = value }" }
    o += "\t\telse -> throw IndexOutOfBoundsException()\n\t}"

    o += '}'
}

val xyzw = listOf('x', 'y', 'z', 'w')
val rgba = listOf('r', 'g', 'b', 'a')
val stpq = listOf('s', 't', 'p', 'q')