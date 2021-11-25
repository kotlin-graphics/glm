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
val types = listOf("Byte", "Short", "Int", "Long", "UByte", "UShort", "UInt", "ULong", "Float", "Double", "Boolean") // Char?
val typeChars = listOf("b", "s", "i", "L", "ub", "us", "ui", "ul", "", "d", "bool")
val String.c
    get() = typeChars[types.indexOf(this)].ifBlank { "f" }
val String.numeric
    get() = this != "Boolean" // Char?
val String.uns
    get() = this[0] == 'U'

fun xyzw(block: (Int, Char) -> Any) {
    for (i in 0 until ordinal)
        block(i, xyzw[i])
}

fun xyzw(block: (Char) -> Any) {
    for (i in 0 until ordinal)
        block(xyzw[i])
}

fun xyzwJoint(block: (Int, Char) -> String) = (0 until ordinal).joinToString { block(it, xyzw[it]) }
fun xyzwJoint(separator: String = ", ", block: (Char) -> String) = (0 until ordinal).joinToString(separator) { block(xyzw[it]) }

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
        "companion object" {
            +"const val length = $ordinal"
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
        xyzw { i, c ->
            val delta = if (i == 0) "" else " + $i"
            "override var $c: $type"(
                "get() = array[ofs$delta]",
                "set(value) { array[ofs$delta] = value }")
        }

        "// Implicit basic constructors"()
        "constructor() : this(${type}Array($ordinal))"()
        "constructor(v: $vec_$T) : this(${xyzwJoint { c -> "v.$c" }})"()

        "// Explicit basic constructors"()
        val arrayOf = "${type.lowercase()}ArrayOf"
        val a = "x" * ordinal
        "constructor(x: $type) : this(${if (ordinal == 1) "$arrayOf($a)" else a})"()
        "constructor(x: Number) : this(x.${type.c})"()
        if (type == "UByte" || type == "UShort") {
            +"constructor(x: UInt) : this(x.${type.c})"
            +"constructor(x: ULong) : this(x.${type.c})"
        }

        if (ordinal != 1) {
            +"constructor(${xyzwJoint { c -> "$c: $type" }}) : this($arrayOf(${xyzwJoint { c -> "$c" }}))"
            if (type == "UByte" || type == "UShort") {
                +"constructor(${xyzwJoint { c -> "$c: UInt" }}) : this(${xyzwJoint { c -> "$c.${type.c}" }})"
                +"constructor(${xyzwJoint { c -> "$c: ULong" }}) : this(${xyzwJoint { c -> "$c.${type.c}" }})"
            }

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

        "// Conversion vector constructors"()
        "// Explicit conversions (From section 5.4.1 Conversion and scalar constructors of GLSL 1.30.08 specification)"()

        infix fun String.to(b: String) = +"constructor($this) : this($b)"
        val V1 = "Vec1T<out Number>"
        val V2 = "Vec2T<out Number>"
        val V3 = "Vec3T<out Number>"
        val V4 = "Vec4T<out Number>"
        val N = "Number"
        when (ordinal) {
            1 -> {
                "v: $V1" to "v.x"
                "v: $V2" to "v.x"
                "v: $V3" to "v.x"
                "v: $V4" to "v.x"
            }
            2 -> {
                "v: $V2" to "v.x, v.y"
                "v: $V3" to "v.x, v.y"
                "v: $V4" to "v.x, v.y"
            }
            3 -> {
                "xy: $V2, z: $N" to "xy.x, xy.y, z"
                "xy: $V2, z: $V1" to "xy.x, xy.y, z.x"
                "x: $N, yz: $V2" to "x, yz.x, yz.y"
                "x: $V1, yz: $V2" to "x.x, yz.x, yz.y"
                "v: $V3" to "v.x, v.y, v.z"
                "v: $V4" to "v.x, v.y, v.z"
            }
            4 -> {
                "xy: $V2, z: $N, w: $N" to "xy.x, xy.y, z, w"
                "xy: $V2, z: $V1, w: $N" to "xy.x, xy.y, z.x, w"
                "xy: $V2, z: $N, w: $V1" to "xy.x, xy.y, z, w.x"
                "xy: $V2, z: $V1, w: $V1" to "xy.x, xy.y, z.x, w.x"
                "x: $N, yz: $V2, w: $N" to "x, yz.x, yz.y, w"
                "x: $V1, yz: $V2, w: $N" to "x.x, yz.x, yz.y, w"
                "x: $N, yz: $V2, w: $V1" to "x, yz.x, yz.y, w.x"
                "x: $V1, yz: $V2, w: $V1" to "x.x, yz.x, yz.y, w.x"
                "x: $N, y: $N, zw: $V2" to "x, y, zw.x, zw.y"
                "x: $V1, y: $N, zw: $V2" to "x.x, y, zw.x, zw.y"
                "x: $N, y: $V1, zw: $V2" to "x, y.x, zw.x, zw.y"
                "x: $V1, y: $V1, zw: $V2" to "x.x, y.x, zw.x, zw.y"
                "xyz: $V3, w: $N" to "xyz.x, xyz.y, xyz.z, w"
                "xyz: $V3, w: $V1" to "xyz.x, xyz.y, xyz.z, w.x"
                "x: $N, yzw: $V3" to "x, yzw.x, yzw.y, yzw.z"
                "x: $V1, yzw: $V3" to "x.x, yzw.x, yzw.y, yzw.z"
                "xy: $V2, zw: $V2" to "xy.x, xy.y, zw.x, zw.y"
                "v: $V4" to "v.x, v.y, v.z, v.w"
            }
        }

        if (type.numeric) {
            +"// Unary arithmetic operators"
            val op = listOf('+' to "plus", '-' to "minus", '*' to "times", '/' to "div")
            for (o in op) {
                val s = o.first
                val t = o.second
                if ("Byte" in type || "Short" in type)
                    for (scalar in listOf(N, type))
                        +"operator fun ${t}Assign(scalar: $scalar) = ${t}Assign(scalar.${if (type.uns) "u" else ""}i)"
                else {
                    "operator fun ${t}Assign(scalar: $N) = ${t}Assign(scalar.${type.c})"()
                    "operator fun ${t}Assign(scalar: $type)" {
                        xyzw { c ->
                            when {
                                "Byte" in type || "Short" in type -> +"$c = ($c $s scalar).${type.c}"
                                else -> +"$c $s= scalar"
                            }
                        }
                    }
                }
                if ("Byte" in type || "Short" in type) {
                    "operator fun ${t}Assign(scalar: ${if (type[0] == 'U') "UInt" else "Int"})" {
                        xyzw { c -> +"$c = ($c $s scalar).${type.c}" }
                    }
                    if (type.uns)
                        +"operator fun ${t}Assign(scalar: ULong) = ${t}Assign(scalar.${type.c})"
                } else if (type.uns)
                    if (type == "UInt")
                        +"operator fun ${t}Assign(scalar: ULong) = ${t}Assign(scalar.ui)"
                    else +"operator fun ${t}Assign(scalar: UInt) = ${t}Assign(scalar.ul)"
                "operator fun ${t}Assign(v: $V1)" {
                    xyzw { c ->
                        if ("Byte" in type || "Short" in type)
                            +"$c = ($c $s v.x.${type.c}).${type.c}"
                        else +"$c $s= v.x.${type.c}"
                    }
                }
                "operator fun ${t}Assign(v: Vec1$T)" {
                    xyzw { c ->
                        if ("Byte" in type || "Short" in type)
                            +"$c = ($c $s v.x).${type.c}"
                        else +"$c $s= v.x"
                    }
                }
                if (ordinal != 1) {
                    "operator fun ${t}Assign(v: Vec${ordinal}T<out Number>)" {
                        xyzw { c ->
                            if ("Byte" in type || "Short" in type)
                                +"$c = ($c $s v.$c.${type.c}).${type.c}"
                            else +"$c $s= v.$c.${type.c}"
                        }
                    }
                    "operator fun ${t}Assign(v: Vec${ordinal}$T)" {
                        xyzw { c ->
                            if ("Byte" in type || "Short" in type)
                                +"$c = ($c $s v.$c).${type.c}"
                            else +"$c $s= v.$c"
                        }
                    }
                }
            }
            "// Increment and decrement operators"()
            "operator fun inc(): Vec${ordinal}$T" {
                xyzw { c -> +"$c++" }
                +"return this"
            }
            "operator fun dec(): Vec${ordinal}$T" {
                xyzw { c -> +"$c--" }
                +"return this"
            }
            "// Unary bit operators TODO"()
            "// Unary operators"()
            "operator fun unaryPlus(): Vec${ordinal}$T = this"()
            if (!type.uns)
                +"operator fun unaryMinus(): Vec${ordinal}$T = Vec${ordinal}$T(${xyzwJoint { c -> "-$c" }})"
            "// Binary operators"()
            for (o in op) {
                val s = o.first
                val t = o.second
                +"operator fun $t(scalar: $type) = Vec${ordinal}$T(${xyzwJoint { c -> "$c $s scalar" }})"
                +"operator fun $t(v: Vec1$T) = Vec${ordinal}$T(${xyzwJoint { c -> "$c $s v.x" }})"
                if (ordinal != 1)
                    +"operator fun $t(v: Vec${ordinal}$T) = Vec${ordinal}$T(${xyzwJoint { c -> "$c $s v.$c" }})"
            }
        }
        "override fun equals(other: Any?) = other is Vec${ordinal}$T && ${xyzwJoint(" && ") { c -> "$c == other.$c" }}"()

        "companion object" {
            +"const val length = Vec${ordinal}T.length"
            if (type.numeric)
                +"const val size = length * $type.SIZE_BYTES"
        }
    }
}