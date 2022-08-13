package glm.detail

import glm.Generator
import glm.generate
import java.io.File
import java.net.URL

fun func_common(target: File) {
    generate(target, "glm/detail/func_common.kt") {
        +"package glm.detail"
        +"import kotlin.math.*"
        "interface func_common" {

            var docs = "Returns x if x >= 0; otherwise, it returns -x."

        }
    }
}

interface A {
}

inline fun A.a() = 2