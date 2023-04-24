package glm_.generators

import glm_.generators.gen.Generator
import glm_.generators.gen.generate
import java.io.File

fun swizzles(target: File) {

    generate(target, "glm_/extensions/swizzle/Vecs.kt") {
        vecImpls()
    }

    for (i in 2..4)
        generate(target, "glm_/extensions/swizzle/vec$i/Vec$i.kt") {
            +"package glm_.extensions.swizzle.vec$i"
            +"import glm_.extensions.swizzle.*"
            for (j in 2..i) +"import glm_.vec$j.*"
            swizzle(i)
        }
}

private fun Generator.vecImpls() {
    +"package glm_.extensions.swizzle"
    for (j in 2..4) +"import glm_.vec$j.*"


    for (ordinal in 2..4)
        +"internal class Vec${ordinal}Impl<T>(${xyzwJoint(ordinal) { "override var $it: T" }}) : Vec${ordinal}T<T>()"
}

private fun Generator.swizzle(ordinal: Int) {
    for (allChars in listOf(xyzw, rgba, stpq)) {
        val chars = allChars.take(ordinal)

        for (x in chars)
            for (y in chars) {
                swizzle2(ordinal, x, y)

                if (ordinal > 2) for (z in chars) {
                    swizzle3(ordinal, x, y, z)

                    if (ordinal > 3) for (w in chars)
                        swizzle4(ordinal, x, y, z, w)
                }
            }
    }
}


private fun variable(mutable: Boolean) = if (mutable) "var" else "val"

private fun Generator.swizzle2(ordinal: Int, a: String, b: String) {
    val mutable = a != b

    "${variable(mutable)} <T> Vec${ordinal}T<T>.$a$b: Vec2T<T>".indented {
        +"get() = Vec2Impl($a, $b)"
        if (mutable)
            "set(value)" {
                +"$a = value.x"
                +"$b = value.y"
            }
    }
}

private fun Generator.swizzle3(ordinal: Int, a: String, b: String, c: String) {
    val mutable = a != b && a != c && b != c

    "${variable(mutable)} <T> Vec${ordinal}T<T>.$a$b$c: Vec3T<T>".indented {
        +"get() = Vec3Impl($a, $b, $c)"
        if (mutable)
            "set(value)" {
                +"$a = value.x"
                +"$b = value.y"
                +"$c = value.z"
            }
    }
}

private fun Generator.swizzle4(ordinal: Int, a: String, b: String, c: String, d: String) {
    val mutable = a != b && a != c && a != d && b != c && b != d && c != d

    "${variable(mutable)} <T> Vec${ordinal}T<T>.$a$b$c$d: Vec4T<T>".indented {
        +"get() = Vec4Impl($a, $b, $c, $d)"
        if (mutable)
            "set(value)" {
                +"$a = value.x"
                +"$b = value.y"
                +"$c = value.z"
                +"$d = value.w"
            }
    }
}
