package glm_.generators.scalar

import glm_.generators.*
import glm_.generators.detail.*
import glm_.generators.ext.extScalarCommon
import glm_.generators.gen.Generator
import glm_.generators.gen.generate
import glm_.generators.ext.extScalarRelational
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

        +"// common\n"
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
                          "kotlin.math.pow")

        +"// exponential\n"
        for ((type, extension, _, _) in vectorTypes)
            exponential(-1, type, extension, "", "", Generator.Part.Scalar)
    }

    generate(target, "glm_/scalar/funcGeometric.kt") {

        experimentals += Generator.Experimentals.Contracts
        `package` = "glm_.scalar"
        //            +"import glm_.extensions.swizzle.*"
        imports += listOf(
            "glm_.extensions.*",
            //                          "kotlin.reflect.KMutableProperty0",
            //                    +"import kotlin.jvm.*"
            //                          "kotlin.math.*",
            //                          "kotlin.math.pow"
                         )

        +"// geometric\n"
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

        +"// trigonometric\n"
        for ((type, extension, _, _) in vectorTypes)
            trigonometric(-1, type, extension, "", "", Generator.Part.Scalar)
    }

    generate(target, "glm_/scalar/integer.kt") {

        experimentals += Generator.Experimentals.Contracts
        `package` = "glm_.scalar"
        //            +"import glm_.extensions.swizzle.*"
        imports += listOf(
            //                    "kotlin.math.pow"
            //            "glm_.extensions.*",
            "kotlin.reflect.KMutableProperty0",
            //            //                    +"import kotlin.jvm.*"
            //                          "kotlin.math.*"
                         )

        +"// integer\n"
        for ((type, extension, _, _) in vectorTypes)
            integer(-1, type, extension, "", "", Generator.Part.Scalar)
    }

    generate(target, "glm_/scalar/packing.kt") {

        experimentals += Generator.Experimentals.Contracts
        `package` = "glm_.scalar"
        //            +"import glm_.extensions.swizzle.*"
        imports += listOf(
            //                    "kotlin.math.pow"
            //            "glm_.extensions.*",
            //            "kotlin.reflect.KMutableProperty0",
            //            //                    +"import kotlin.jvm.*"
            //                          "kotlin.math.*"
                         )

        +"// packing\n"
        for ((type, extension, _, _) in vectorTypes)
            packing(0, type, extension, "", "", Generator.Part.Scalar)
    }
    generate(target, "glm_/ext/scalarRelational.kt") {

        experimentals += Generator.Experimentals.Contracts
        `package` = "glm_.ext"
        //            +"import glm_.extensions.swizzle.*"
        imports += listOf(
            "glm_.ext.negative",
            "glm_.scalar.abs",
            //            "kotlin.reflect.KMutableProperty0",
            //            //                    +"import kotlin.jvm.*"
            //                          "kotlin.math.*"
                         )

        +"// ext scalar relational\n"
        for ((type, _, _, _) in vectorTypes)
            extScalarRelational(type)
    }
    generate(target, "glm_/ext/extScalarCommon.kt") {

        experimentals += Generator.Experimentals.Contracts
        `package` = "glm_.ext"
        //            +"import glm_.extensions.swizzle.*"
        imports += listOf(
//            "glm_.ext.negative",
//            "glm_.scalar.abs",
            //            "kotlin.reflect.KMutableProperty0",
            //            //                    +"import kotlin.jvm.*"
            //                          "kotlin.math.*"
                         )

        +"// ext scalar common\n"
        for ((type, _, _, _) in vectorTypes)
            extScalarCommon(type)
    }
}