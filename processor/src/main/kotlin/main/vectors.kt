package main

import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.Dependencies

fun vecs(generator: CodeGenerator) {

    for (i in 1..4)
        generator.createNewFile(dependencies = Dependencies(false),
                                packageName = "glm.vec$i",
                                fileName = "Vec${i}T").use {
            text.clear()
            ordinal = i
            vects()
            it.write(text.toString().toByteArray())
        }

    for (t in types.indices)
        for (i in 1..4) {
            val type = types[t]
            val T = typeChars[t]
            generator.createNewFile(dependencies = Dependencies(false),
                                    packageName = "glm.vec$i",
                                    fileName = "Vec$i$T").use {
                text.clear()
                ordinal = i
                vecs(type, T)
                it.write(text.toString().toByteArray())
            }
        }
}

var ordinal = 0
val types = listOf("Byte", "Short", "Int", "Long", "UByte", "UShort", "UInt", "ULong", "Float", "Double", "Boolean")
val typeChars = listOf("b", "s", "i", "L", "ub", "us", "ui", "ul", "", "d", "bool")
val String.c
    get() = typeChars[types.indexOf(this)].ifBlank { "f" }

fun xyzw(block: (Int, Char) -> Any) {
    for (i in 0 until ordinal)
        block(i, xyzw[i])
}

fun xyzw(block: (Char) -> Any) {
    for (i in 0 until ordinal)
        block(xyzw[i])
}

fun xyzwJoint(block: (Int, Char) -> String) = (0 until ordinal).joinToString { block(it, xyzw[it]) }
fun xyzwJoint(block: (Char) -> String) = (0 until ordinal).joinToString { block(xyzw[it]) }

fun vects() {

    "package glm.vec$ordinal"()
    "abstract class Vec${ordinal}T<T>/*: ToBuffer*/" {
        xyzw { c -> +"abstract var $c: T" }
        xyzw { i, c -> +"fun component$i() = $c" }

        "// aliases"()

        xyzw { i, c ->
            "var ${rgba[i]}: T"(
                "get() = $c",
                "set(value) { $c = value }")
        }
        xyzw { i, c ->
            "var ${stpq[i]}: T"(
                "get() = $c",
                "set(value) { $c = value }")
        }

        "// -- Component accesses --"()

        "operator fun get(index: Int): T = when (index)" {
            xyzw { i, c -> +"$i -> $c" }
            +"else -> throw IndexOutOfBoundsException()"
        }

        "operator fun set(index: Int, value: T) = when(index)" {
            xyzw { i, c -> +"$i -> { $c = value }" }
            +"else -> throw IndexOutOfBoundsException()"
        }
    }
}

val xyzw = listOf('x', 'y', 'z', 'w')
val rgba = listOf('r', 'g', 'b', 'a')
val stpq = listOf('s', 't', 'p', 'q')

fun vecs(type: String, T: String) {

    "package glm.vec$ordinal"()
    "import glm.*"()
    repeat(4) { +"import glm.vec${it + 1}.*" }
    val vec_ = "Vec$ordinal"
    "class $vec_$T(var array: ${type}Array, var ofs: Int = 0) : ${vec_}T<$type>()/*, ToBuffer*/" {
        xyzw { c ->
            "override var $c: $type"(
                "get() = array[ofs]",
                "set(value) { array[ofs] = value }")
        }

        "// Implicit basic constructors"()
        "constructor() : this(${type}Array($ordinal))"()
        "constructor(v: $vec_$T) : this(${xyzwJoint { c -> "v.$c" }})"()

        "// Explicit basic constructors"()
        val arrayOf = "${type.lowercase()}ArrayOf"
        val a = "x" * ordinal
        "constructor(x: $type) : this(${if (ordinal == 1) "$arrayOf($a)" else a})"()

        if (ordinal != 1) {

            +"constructor(${xyzwJoint { c -> "$c: $type" }}) : this($arrayOf(${xyzwJoint { c -> "$c" }}))"

            +"// Conversion scalar constructors"
            +"constructor(v: Vec1T<out Number>) : this(v.x.${type.c})"

            +"// Explicit conversions (From section 5.4.1 Conversion and scalar constructors of GLSL 1.30.08 specification)"
            fun range(comp: Char) = listOf("$comp: Number", "$comp: Vec1T<out Number>")
            fun par(p: String) = if (p.last() == '>') "${p[0]}.x" else p[0]
            var postfix = ".${type.c}"
            fun constructor(vararg a: String) {
                +"constructor(${a.joinToString()}) : this(${a.joinToString { "${par(it)}$postfix" }})"
                postfix = ""
            }
            for (x in range('x'))
                for (y in range('y'))
                    if (ordinal > 2)
                        for (z in range('z'))
                            if (ordinal == 4)
                                for (w in range('w'))
                                    constructor(x, y, z, w)
                            else constructor(x, y, z)
                    else constructor(x, y)
        }
    }
}