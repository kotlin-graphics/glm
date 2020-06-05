package codegen.ext

import codegen.buildFile
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.FunSpec

fun generate_ext_MatrixClipSpace(): FileSpec =
        buildFile("glm.ext", "MatrixClipSpace") {
            indent("\t")

//            FunSpec.builder("ortho")
//                    .receiver(Glm::class)

//            buildClass("Vec2") {
//                property("storage", FLOAT_ARRAY, KModifier.PRIVATE)
//
//                mutableProperty("x", FLOAT) {
//                    getter {
//                        statement("return storage[0]")
//                    }
//                    setter {
//                        parameter("value", FLOAT)
//                        statement("storage[0] = value")
//                    }
//                }
//                mutableProperty("y", FLOAT) {
//                    getter {
//                        statement("return storage[1]")
//                    }
//                    setter {
//                        parameter("value", FLOAT)
//                        statement("storage[1] = value")
//                    }
//                }
//
//                secondaryConstructor {
//                    parameter("x", FLOAT)
//                    parameter("y", FLOAT)
//                    statement("storage = floatArrayOf(x, y)")
//                }
//            }
        }