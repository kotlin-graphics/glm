package main

import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.Dependencies


fun swizzle(generator: CodeGenerator) {

    for (o in 2..2) {
        ord = o
        for (i in types.indices) {
            type = types[i]
            T = typeChars[i]
            generator.createNewFile(dependencies = Dependencies(false),
                                    packageName = "glm.swizzle",
                                    fileName = "vec$o$T").use {
                text.clear()
                "package glm.vec$ordinal"()
                "import glm.*"()
                for (j in 1..4) +"import glm.vec$j.*"
                vec()
                it.write(text.toString().toByteArray())
            }
        }
    }
}

var type = types[0]
var T = typeChars[0]
var ord = -1

fun vec() {
    fromVecComp(xyzw)
    fromVecComp(rgba)
    fromVecComp(stpq)
}

fun fromVecComp(chars: List<Char>) {
    val c = chars.take(ord).toCharArray()
    vec2FromVec(*c)
    vec3FromVec(*c)
    vec4FromVec(*c)
}

fun vec2FromVec(vararg c: Char) {
    for (x in c)
        for (y in c)
            vec2(x, y)
}

fun vec2(a: Char, b: Char) =
    if (a == b)
        "val Vec$ord$T.$a$b get() = Vec2$T($a, $b)"()
    else
        "var Vec$ord$T.$a$b get() = Vec2$T($a, $b); set(value) { $a = value.x; $b = value.y }"()

fun vec3FromVec(vararg c: Char) {
    for (x in c)
        for (y in c)
            for (z in c)
                vec3(x, y, z)
}

fun vec3(a: Char, b: Char, c: Char) =
    if (a != b && a != c && b != c)
        "var Vec$ord$T.$a$b$c get() = Vec3$T($a, $b, $c); set(value) { $a = value.x; $b = value.y; $c = value.z }"()
    else
        "val Vec$ord$T.$a$b$c get() = Vec3$T($a, $b, $c)"()

fun vec4FromVec(vararg c: Char) {
    for (x in c)
        for (y in c)
            for (z in c)
                for (w in c)
                    vec4(x, y, z, w)
}

fun vec4(a: Char, b: Char, c: Char, d: Char) =
    if (a != b && a != c && a != d && b != c && b != d && c != d)
        "var Vec$ord$T.$a$b$c$d get() = Vec4$T($a, $b, $c, $d); set(value) { $a = value.x; $b = value.y; $c = value.z; $d = value.w }"()
    else
        "val Vec$ord$T.$a$b$c$d get() = Vec4$T($a, $b, $c, $d)"()