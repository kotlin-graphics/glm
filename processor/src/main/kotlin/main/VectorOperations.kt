package main

import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.Dependencies

fun vectorOperations(generator: CodeGenerator) {
    for (i in 1..4) {
        generator.createNewFile(dependencies = Dependencies(false), packageName = "glm.vec$i", fileName = "Vec${i}Operations").use {
            text.clear()
            
            operations(i)
            
            it.write(text.toString().toByteArray())
        }
    }
}


private fun operations(ordinal: Int) {
    +"package glm.vec$ordinal"
    
    for (i in 1..ordinal) {
        +"import glm.vec$i.*"
    }
    
    "object Vec${ordinal}Operations" {
    
    }
}