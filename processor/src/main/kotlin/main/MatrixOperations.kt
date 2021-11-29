package main

import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.Dependencies

fun matrixOperations(generator: CodeGenerator) {
    for (i in 2..4) {
        for (j in 2..4) {
            generator.createNewFile(dependencies = Dependencies(false), packageName = "glm.mat${matrixSizeString(i, j)}", fileName = "Mat${matrixSizeString(i, j)}Operations").use {
                text.clear()
                
                operations(i, j)
                
                it.write(text.toString().toByteArray())
            }
        }
    }
}


private fun operations(width: Int, height: Int) {
    +"package glm.mat${matrixSizeString(width, height)}"
    
    +"import glm.*"
    +"import glm.extensions.*"
    repeat(4) { +"import glm.vec${it + 1}.*" }
    for (i in 2..4) {
        for (j in 2..4) {
            +"import glm.mat${matrixSizeString(i, j)}.*"
        }
    }
    
    "object Mat${matrixSizeString(width, height)}Operations" {
        for (k in 2..4) {
            "fun <N : Number> times(res: Mat${matrixSizeString(k, height)}T<N, out Vec${height}T<N>>, a: Mat${matrixSizeString(width, height)}T<N, out Vec${height}T<N>>, b: Mat${matrixSizeString(k, width)}T<N, out Vec${width}T<N>>)" {
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
    }
}
