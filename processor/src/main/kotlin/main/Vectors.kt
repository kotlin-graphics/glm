package main

import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.Dependencies

fun vectors(generator: CodeGenerator) {
    for (i in 1..4)
        generator.createNewFile(dependencies = Dependencies(false), packageName = "glm.vec$i", fileName = "Vec${i}T").use {
            text.clear()
            
            vectorsT(i)
            
            it.write(text.toString().toByteArray())
        }
    
    for ((type, v) in vectorTypes) {
        val (extension, _) = v
        
        val id = if (type == "Float") "" else extension
        
        for (i in 1..4) {
            generator.createNewFile(dependencies = Dependencies(false), packageName = "glm.vec$i", fileName = "Vec$i$id").use {
                text.clear()
                
                vectors(i, type, extension, id)
                
                it.write(text.toString().toByteArray())
            }
        }
    }
}

private val operators = listOf('+' to "plus", '-' to "minus", '*' to "times", '/' to "div")

private fun vectorsT(ordinal: Int) {
    +"package glm.vec$ordinal"
    
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
            xyzw(ordinal) { i, c -> +"$i -> { $c = value }" }
            +"else -> throw IndexOutOfBoundsException()"
        }
        "companion object" {
            +"const val length = $ordinal"
        }
    }
}

private fun vectors(ordinal: Int, type: String, extension: String, id: String) {
    +"package glm.vec$ordinal"
    
    +"import glm.*"
    +"import glm.extensions.*"
    repeat(4) { +"import glm.vec${it + 1}.*" }
    
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
        val a = "x" * ordinal
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
            fun range(comp: Char) = listOf("$comp: Number", "$comp: Vec1T<out Number>")
            fun par(p: String) = if (p.last() == '>') "${p[0]}.x" else p[0]
            var postfix = ".$extension"
            fun constructor(vararg a: String) {
                +"constructor(${a.joinToString()}) : this(${a.joinToString { "${par(it)}$postfix" }})"
                postfix = ""
            }
            for (x in range('x')) {
                for (y in range('y')) {
                    if (ordinal > 2) {
                        for (z in range('z'))
                            if (ordinal == 4) {
                                for (w in range('w'))
                                    constructor(x, y, z, w)
                            } else {
                                constructor(x, y, z)
                            }
                    } else {
                        constructor(x, y)
                    }
                }
            }
        }
        
        +"// Conversion vector constructors"
        +"// Explicit conversions (From section 5.4.1 Conversion and scalar constructors of GLSL 1.30.08 specification)"
        
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
        
        if (type in numberTypes) {
            +"// Unary arithmetic operators"
            for ((s, t) in operators) {
                if ("Byte" in type || "Short" in type)
                    for (scalar in listOf(N, type))
                        +"operator fun ${t}Assign(scalar: $scalar) = ${t}Assign(scalar.${if (type in unsignedTypes) "u" else ""}i)"
                else {
                    +"operator fun ${t}Assign(scalar: $N) = ${t}Assign(scalar.$extension)"
                    "operator fun ${t}Assign(scalar: $type)" {
                        xyzw(ordinal) { c ->
                            when {
                                "Byte" in type || "Short" in type -> +"$c = ($c $s scalar).$extension"
                                else                              -> +"$c $s= scalar"
                            }
                        }
                    }
                }
                if ("Byte" in type || "Short" in type) {
                    "operator fun ${t}Assign(scalar: ${if (type[0] == 'U') "UInt" else "Int"})" {
                        xyzw(ordinal) { c -> +"$c = ($c $s scalar).$extension" }
                    }
                    if (type in unsignedTypes)
                        +"operator fun ${t}Assign(scalar: ULong) = ${t}Assign(scalar.$extension)"
                } else if (type in unsignedTypes)
                    if (type == "UInt")
                        +"operator fun ${t}Assign(scalar: ULong) = ${t}Assign(scalar.ui)"
                    else +"operator fun ${t}Assign(scalar: UInt) = ${t}Assign(scalar.ul)"
                "operator fun ${t}Assign(v: $V1)" {
                    xyzw(ordinal) { c ->
                        if ("Byte" in type || "Short" in type)
                            +"$c = ($c $s v.x.$extension).$extension"
                        else +"$c $s= v.x.$extension"
                    }
                }
                "operator fun ${t}Assign(v: Vec1$id)" {
                    xyzw(ordinal) { c ->
                        if ("Byte" in type || "Short" in type)
                            +"$c = ($c $s v.x).$extension"
                        else +"$c $s= v.x"
                    }
                }
                if (ordinal != 1) {
                    "operator fun ${t}Assign(v: Vec${ordinal}T<out Number>)" {
                        xyzw(ordinal) { c ->
                            if ("Byte" in type || "Short" in type)
                                +"$c = ($c $s v.$c.$extension).$extension"
                            else +"$c $s= v.$c.$extension"
                        }
                    }
                    "operator fun ${t}Assign(v: Vec$ordinal$id)" {
                        xyzw(ordinal) { c ->
                            if ("Byte" in type || "Short" in type)
                                +"$c = ($c $s v.$c).$extension"
                            else +"$c $s= v.$c"
                        }
                    }
                }
            }
            +"// Increment and decrement operators"
            "operator fun inc(): Vec$ordinal$id" {
                xyzw(ordinal) { c -> +"$c++" }
                +"return this"
            }
            "operator fun dec(): Vec$ordinal$id" {
                xyzw(ordinal) { c -> +"$c--" }
                +"return this"
            }
            +"// Unary bit operators TODO"
            +"// Unary operators"
            +"operator fun unaryPlus(): Vec$ordinal$id = this"
            if (type !in unsignedTypes)
                +"operator fun unaryMinus(): Vec$ordinal$id = Vec$ordinal$id(${xyzwJoint(ordinal) { c -> "-$c" }})"
            +"// Binary operators"
            for ((s, t) in operators) {
                +"operator fun $t(scalar: $type) = Vec$ordinal$id(${xyzwJoint(ordinal) { c -> "$c $s scalar" }})"
                +"operator fun $t(v: Vec1$id) = Vec$ordinal$id(${xyzwJoint(ordinal) { c -> "$c $s v.x" }})"
                if (ordinal != 1)
                    +"operator fun $t(v: Vec$ordinal$id) = Vec$ordinal$id(${xyzwJoint(ordinal) { c -> "$c $s v.$c" }})"
            }
        }
        +"override fun equals(other: Any?) = other is Vec$ordinal$id && ${xyzwJoint(ordinal, " && ") { c -> "$c == other.$c" }}"
        
        if (type == "Boolean") {
            +"// Boolean operators"
            val vec = "Vec$ordinal$extension"
            +"infix fun and(v: $vec) = $vec(${xyzwJoint(ordinal) { c -> "$c && v.$c" }})"
            +"infix fun or(v: $vec) = $vec(${xyzwJoint(ordinal) { c -> "$c || v.$c" }})"
        }
        
        "companion object" {
            +"const val length = Vec${ordinal}T.length"
            if (type in numberTypes)
                +"const val size = length * $type.SIZE_BYTES"
        }
    }
    if (type in numberTypes) {
        +"// Binary operators"
        for ((s, t) in operators) {
            +"operator fun $type.$t(v: Vec$ordinal$id) = Vec$ordinal$id(${xyzwJoint(ordinal) { c -> "this $s v.$c" }})"
            if (ordinal != 1)
                +"operator fun Vec1$id.$t(v: Vec$ordinal$id) = Vec$ordinal$id(${xyzwJoint(ordinal) { c -> "x $s v.$c" }})"
        }
    }
}