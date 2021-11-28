package main

import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.Dependencies

fun primitiveExtensions(generator: CodeGenerator) {
    generator.createNewFile(dependencies = Dependencies(false), packageName = "glm.extensions", fileName = "PrimitiveExtensions").use {
        text.clear()
        
        numbers()
        
        it.write(text.toString().toByteArray())
    }
}

private fun numbers() {
    +"package glm.extensions"
    
    for ((extension, function) in numberTypes.values + ("c" to "toChar")) {
        if (extension == "c") {
            +"val Number.$extension get() = toInt().$function()"
            
            for (utype in unsignedTypes) {
                +"val $utype.$extension get() = toInt().$function()"
            }
        } else {
            +"val Number.$extension get() = ${if ("U" in function) "${function.unsingedToSigned}().$function()" else "$function()"}"
            
            for (utype in unsignedTypes) {
                +"val $utype.$extension get() = $function()"
            }
        }
        
        +"val Boolean.$extension get() = if (this) 1.$extension else 0.$extension"
        
        if (extension == "i") {
            +"val Char.$extension get() = code"
        } else {
            +"val Char.$extension get() = code.$function()"
        }
        
        extensionsToType[extension]?.let { type ->
            if (type in floatingPointTypes) {
                +"val String.$extension get() = $function()"
            } else {
                +"val String.$extension get() = if (startsWith(\"0x\")) substring(2).$function(16) else $function()"
            }
        }
    }
    
    
    +"val Number.bool get() = i != 0"
    
    for (utype in unsignedTypes) {
        +"val $utype.bool get() = i != 0"
    }
    
    
    val binaryTypes = numberTypes - floatingPointTypes
    val skip = listOf("Int" to "Int")
    val skipWithInt = listOf("Long", "UInt", "ULong")
    val operations = listOf("shl" to true, "shr" to true, "ushr" to true, "and" to false, "or" to false, "xor" to false)
    
    for ((typeLeft, v) in binaryTypes) {
        val (keyLeft, _) = v
        
        for ((typeRight, _) in binaryTypes - listOf("Long", "ULong")) {
            if ((typeLeft to typeRight) in skip) continue
            if (typeRight == "Int" && typeLeft in skipWithInt) continue
            
            for ((op, shift) in operations) {
                if (!shift && typeLeft in unsignedTypes && typeLeft == typeRight) continue
                
                if (typeLeft == "Long" || typeLeft == "ULong") {
                    +"infix fun $typeLeft.$op(other: $typeRight) = (L $op other.${if (shift) "i" else "L"}).$keyLeft"
                } else {
                    +"infix fun $typeLeft.$op(other: $typeRight) = (i $op other.i).$keyLeft"
                }
            }
        }
    }
    
    
    val matchingTypes = listOf("Number", "Char", "Boolean", "String") + unsignedTypes
    
    for ((type, v) in numberTypes) {
        val (extension, function) = v
        
        +"internal val Any.$function: $type"
        indent {
            "get() = when (this)" {
                for (isType in matchingTypes) {
                    +"is $isType -> this.$extension"
                }
                
                +"else -> throw ArithmeticException(\"incompatible type\")"
            }
        }
    }
    
    
    for (type in numberTypes.keys) {
        +"val $type.Companion.BYTES: Int"
        indent {
            +"get() = SIZE_BYTES"
        }
    }
}

