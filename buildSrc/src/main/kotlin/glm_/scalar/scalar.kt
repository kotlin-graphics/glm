package glm_.scalar

import glm_.*
import glm_.gen.Generator
import glm_.gen.generate
import glm_.detail.common
import glm_.detail.exponential
import glm_.detail.trigonometric
import glm_.detail.geometric
import java.io.File

fun scalar(target: File) {

    generate(target, "glm_/scalar/funcCommon.kt") {

        experimentals += Generator.Experimentals.Contracts
        `package` = "glm_.scalar"
        //            +"import glm_.extensions.swizzle.*"
        imports += listOf(
            "glm_.extensions.*",
            "kotlin.reflect.KMutableProperty0",
            //                    +"import kotlin.jvm.*"
            "kotlin.math.*",
            //                          "kotlin.math.pow"
                         )

        for ((type, extension, _, _) in vectorTypes)
            common(-1, type, extension, "", "", Generator.Part.Scalar)
    }

    generate(target, "glm_/scalar/funcExponential.kt") {

        experimentals += Generator.Experimentals.Contracts
        `package` = "glm_.scalar"
        //            +"import glm_.extensions.swizzle.*"
        imports += listOf("glm_.extensions.*",
            //                          "kotlin.reflect.KMutableProperty0",
            //                    +"import kotlin.jvm.*"
            //                          "kotlin.math.*",
                          "kotlin.math.pow"
                         )

        for ((type, extension, _, _) in vectorTypes)
            exponential(-1, type, extension, "", "", Generator.Part.Scalar)
    }

    generate(target, "glm_/scalar/funcGeometric.kt") {

        experimentals += Generator.Experimentals.Contracts
        `package` = "glm_.scalar"
        //            +"import glm_.extensions.swizzle.*"
        imports += listOf("glm_.extensions.*",
            //                          "kotlin.reflect.KMutableProperty0",
            //                    +"import kotlin.jvm.*"
            //                          "kotlin.math.*",
//                          "kotlin.math.pow"
                         )

        for ((type, extension, _, _) in vectorTypes)
            geometric(-1, type, extension, "", "", Generator.Part.Scalar)
    }

    generate(target, "glm_/scalar/trigonometric.kt") {

        //        experimentals += Generator.Experimentals.Contracts
        `package` = "glm_.scalar"
        //            +"import glm_.extensions.swizzle.*"
        //        imports += listOf("kotlin.math.pow")
        //            "glm_.extensions.*",
        //                          "kotlin.reflect.KMutableProperty0",
        //            //                    +"import kotlin.jvm.*"
        //                          "kotlin.math.*")

        for ((type, extension, _, _) in vectorTypes)
            trigonometric(-1, type, extension, "", "", Generator.Part.Scalar)
    }
}