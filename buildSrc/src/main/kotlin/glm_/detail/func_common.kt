package glm_.detail

import glm_.Generator
import glm_.generate
import java.io.File
import java.net.URL

fun func_common(target: File) {
    generate(target, "glm_/detail/func_common.kt") {
        +"package glm_.detail"
        +"import kotlin.math.*"
        "interface func_common" {

            var docs = "Returns x if x >= 0; otherwise, it returns -x."
            docs(docs)

//            +"fun sign"
        }
    }
}