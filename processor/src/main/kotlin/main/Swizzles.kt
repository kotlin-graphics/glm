package main

import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.Dependencies

fun swizzles(generator: CodeGenerator) {
    for (i in 2..2) {
        for ((type, extension) in vectorTypes) {
            val id = if (type == "Float") "" else extension
    
            generator.createNewFile(dependencies = Dependencies(false), packageName = "glm.extensions.swizzle.vec$i", fileName = "Vec$i$id").use {
                text.clear()
                
                +"package glm.extensions.swizzle.vec$i"
                for (j in 2..i) +"import glm.vec$j.*"
                
                swizzle(id, i)
                
                it.write(text.toString().toByteArray())
            }
        }
    }
}

private fun swizzle(id: String, ordinal: Int) {
    for (allChars in listOf(xyzw, rgba, stpq)) {
        val chars = allChars.take(ordinal)
        
        for (x in chars) {
            for (y in chars) {
                swizzle2(ordinal, id, x, y)
                
                if (ordinal > 2) for (z in chars) {
                    swizzle3(ordinal, id, x, y, z)
                    
                    if (ordinal > 3) for (w in chars) {
                        swizzle4(ordinal, id, x, y, z, w)
                    }
                }
            }
        }
    }
}


private fun variable(mutable: Boolean) = if (mutable) "var" else "val"

private fun swizzle2(ordinal: Int, id: String, a: String, b: String) {
    val mutable = a != b
    
    +"${variable(mutable)} Vec$ordinal$id.$a$b: Vec2$id"
    indent {
        +"get() = Vec2$id($a, $b)"
        if (mutable) {
            "set(value)" {
                +"$a = value.x"
                +"$b = value.y"
            }
        }
    }
}

private fun swizzle3(ordinal: Int, id: String, a: String, b: String, c: String) {
    val mutable = a != b && a != c && b != c
    
    +"${variable(mutable)} Vec$ordinal$id.$a$b$c: Vec3$id"
    indent {
        +"get() = Vec3$id($a, $b, $c)"
        if (mutable) {
            "set(value)" {
                +"$a = value.x"
                +"$b = value.y"
                +"$c = value.z"
            }
        }
    }
}

private fun swizzle4(ordinal: Int, id: String, a: String, b: String, c: String, d: String) {
    val mutable = a != b && a != c && a != d && b != c && b != d && c != d
    
    +"${variable(mutable)} Vec$ordinal$id.$a$b$c$d: Vec4$id"
    indent {
        +"get() = Vec4$id($a, $b, $c, $d)"
        if (mutable) {
            "set(value)" {
                +"$a = value.x"
                +"$b = value.y"
                +"$c = value.z"
                +"$d = value.w"
            }
        }
    }
}
