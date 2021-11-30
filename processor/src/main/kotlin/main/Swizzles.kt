package main

import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.Dependencies

fun swizzles(generator: CodeGenerator) {
    generator.createNewFile(dependencies = Dependencies(false), packageName = "glm.extensions.swizzle", fileName = "Vecs").use {
        text.clear()
        
        vecImpls()
        
        it.write(text.toString().toByteArray())
    }
    
    for (i in 2..4) {
        generator.createNewFile(dependencies = Dependencies(false), packageName = "glm.extensions.swizzle.vec$i", fileName = "Vec$i").use {
            text.clear()
            
            +"package glm.extensions.swizzle.vec$i"
            +"import glm.extensions.swizzle.*"
            for (j in 2..i) +"import glm.vec$j.*"
        
            swizzle(i)
        
            it.write(text.toString().toByteArray())
        }
    }
}

private fun vecImpls() {
    +"package glm.extensions.swizzle"
    for (j in 2..4) +"import glm.vec$j.*"
    
    
    for (ordinal in 2..4) {
        +"internal class Vec${ordinal}Impl<T>(${xyzwJoint(ordinal) { c -> "override var $c: T" }}) : Vec${ordinal}T<T>()"
    }
}

private fun swizzle(ordinal: Int) {
    for (allChars in listOf(xyzw, rgba, stpq)) {
        val chars = allChars.take(ordinal)
        
        for (x in chars) {
            for (y in chars) {
                swizzle2(ordinal, x, y)
                
                if (ordinal > 2) for (z in chars) {
                    swizzle3(ordinal, x, y, z)
                    
                    if (ordinal > 3) for (w in chars) {
                        swizzle4(ordinal, x, y, z, w)
                    }
                }
            }
        }
    }
}


private fun variable(mutable: Boolean) = if (mutable) "var" else "val"

private fun swizzle2(ordinal: Int, a: String, b: String) {
    val mutable = a != b
    
    +"${variable(mutable)} <T> Vec${ordinal}T<T>.$a$b: Vec2T<T>"
    indent {
        +"get() = Vec2Impl($a, $b)"
        if (mutable) {
            "set(value)" {
                +"$a = value.x"
                +"$b = value.y"
            }
        }
    }
}

private fun swizzle3(ordinal: Int, a: String, b: String, c: String) {
    val mutable = a != b && a != c && b != c
    
    +"${variable(mutable)} <T> Vec${ordinal}T<T>.$a$b$c: Vec3T<T>"
    indent {
        +"get() = Vec3Impl($a, $b, $c)"
        if (mutable) {
            "set(value)" {
                +"$a = value.x"
                +"$b = value.y"
                +"$c = value.z"
            }
        }
    }
}

private fun swizzle4(ordinal: Int, a: String, b: String, c: String, d: String) {
    val mutable = a != b && a != c && a != d && b != c && b != d && c != d
    
    +"${variable(mutable)} <T> Vec${ordinal}T<T>.$a$b$c$d: Vec4T<T>"
    indent {
        +"get() = Vec4Impl($a, $b, $c, $d)"
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
