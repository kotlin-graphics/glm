package codegen.glm

import codegen.dsl.Floats
import codegen.dsl.cd
import com.squareup.kotlinpoet.FileSpec

fun genMat4(): FileSpec =
        cd("glm", touch = "Mat4") {
//            indent("\t")

//            Clazz("Mat4") {
//
//                `val`("storage") `=` Floats(16)

//                fn("set", "x".`:`<Int>)
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