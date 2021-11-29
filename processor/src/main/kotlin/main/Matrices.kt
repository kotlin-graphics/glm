package main

import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.Dependencies

fun matrices(generator: CodeGenerator) {
    for (i in 2..4) {
        for (j in 2..4) {
            generator.createNewFile(dependencies = Dependencies(false), packageName = "glm.mat${sizeId(i, j)}", fileName = "Mat${sizeId(i, j)}T").use {
                text.clear()
                
                matricesT(i, j)
                
                println(text)
                it.write(text.toString().toByteArray())
            }
        }
    }
    
    for ((type, extension, _, id) in numberTypeInformation) {
        for (i in 2..4) {
            for (j in 2..4) {
                generator.createNewFile(dependencies = Dependencies(false), packageName = "glm.mat${sizeId(i, j)}", fileName = "Mat${sizeId(i, j)}$id").use {
                    text.clear()
                    
                    matrices(i, j, type, extension, id)
                    
                    it.write(text.toString().toByteArray())
                }
            }
        }
    }
}

private fun sizeId(width: Int, height: Int) = if (width == height) "$width" else "${width}x$height"


private fun matricesT(width: Int, height: Int) {
    +"package glm.mat${sizeId(width, height)}"
    
    +"import glm.vec$height.*"
    
    "abstract class Mat${sizeId(width, height)}T<T>" {
        abcd(width, height) { c -> +"abstract var $c: T" }
        abcd(width, height) { i, j, c -> +"operator fun component${i * height + j + 1}() = $c" }
        
        +"// -- Component accesses --"
        
        +"abstract operator fun get(index: Int): Vec${height}T<T>"
        +"abstract operator fun get(column: Int, row: Int): T"
        
        +"abstract operator fun set(index: Int, value: Vec${height}T<out Number>)"
        +"abstract operator fun set(column: Int, row: Int, value: T)"
        
        +"// -- Aliases --"
        
        abcd(width, height) { i, j, c ->
            +"var ${vNN(i, j)}: T"
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
    +"package glm.mat${sizeId(width, height)}"
    
    +"import glm.*"
    +"import glm.extensions.*"
    repeat(4) { +"import glm.vec${it + 1}.*" }
    
    val mat = "Mat${sizeId(width, height)}"
    "class $mat$id private constructor(@Suppress(\"UNUSED_PARAMETER\") dummy: Int, var array: ${type}Array) : ${mat}T<$type>()" {
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
        
        if (width == height) {
            +"// Implicit basic constructors"
            +"constructor() : this(1)"
            +"constructor(m: $mat$id) : this(${abcdJoint(width, height) { c -> "m.$c" }})"
            
            +"// Explicit basic constructors"
            val arrayOf = "${type.lowercase()}ArrayOf"
            for (t in (unsignedTypes + "Number")) {
                +"constructor(s: $t) : this(${"s" * width})"
                if (width > 2) {
                    +"constructor(${xyzwJoint(width - 1) { c -> "$c: $t" }}) : this(${xyzwJoint(width - 1) { c -> "$c.$extension" }}, 1.$extension)"
                }
                
                +"constructor(${xyzwJoint(width) { c -> "$c: $t" }}) : this("
                indent {
                    +(abcdJoint(width, height, ",\n$indentation") { i, j, _ -> if (i == j) "${xyzw[i]}.$extension" else "0.$extension" } + ")")
                }
                
                +"constructor(${abcdJoint(width, height, ",\n$indentation\t\t\t") { i, j, _ -> "${xyzw[i]}$j: $t" }}) : this(0, $arrayOf("
                indent {
                    +(abcdJoint(width, height, ",\n$indentation") { i, j, _ -> "${xyzw[i]}$j.$extension" } + "))")
                }
            }
            
            +"constructor(array: ${type}Array, transpose: Boolean = false) : this(0,"
            indent {
                +("if (transpose) $arrayOf(" + abcdJoint(width, height, ",\n$indentation") { i, j, _ -> "array[${i * height + j}]" } + ")\n${indentation}else array.copyOf())")
            }
        }
        
        +"// -- Accesses --"
        
        +"override operator fun get(index: Int) = Vec$height$id(array, index * $height)"
        +"override operator fun get(column: Int, row: Int) = array[column * $height + row]"
        
        "override operator fun set(index: Int, value: Vec${height}T<out Number>)" {
            xyzw(height) { i, c ->
                val delta = if (i == 0) "" else " + $i"
                
                +"array[index * $height$delta] = value.$c.$extension"
            }
        }
        +"override operator fun set(column: Int, row: Int, value: $type) = array.set(column * $height + row, value)"
        
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
