package glm_.generators.scalar

import glm_.generators.*
import glm_.generators.detail.*
import glm_.generators.ext.extScalarCommon
import glm_.generators.gen.Generator
import glm_.generators.gen.generate
import glm_.generators.ext.extScalarRelational
import java.io.File

fun scalar(target: File) {

    generate(target, "glm_/scalar/funcCommon.kt", `package` = "glm_.scalar") {

        experimentals += Generator.Experimentals.Contracts
        //            +"import glm_.extensions.swizzle.*"
        imports += listOf(
            "glm_.extensions.*",
            "kotlin.reflect.KMutableProperty0",
            //                    +"import kotlin.jvm.*"
            "kotlin.math.*",
            //                          "kotlin.math.pow"
                         )

        +"// common\n"
        for (type in vectorTypes)
            common(-1, type, "", "", Generator.Part.Scalar)
    }

    generate(target, "glm_/scalar/funcExponential.kt", `package` = "glm_.scalar") {

        experimentals += Generator.Experimentals.Contracts
        //            +"import glm_.extensions.swizzle.*"
        imports += listOf("glm_.extensions.*",
            //                          "kotlin.reflect.KMutableProperty0",
            //                    +"import kotlin.jvm.*"
            //                          "kotlin.math.*",
                          "kotlin.math.pow")

        +"// exponential\n"
        for (type in vectorTypes)
            exponential(-1, type, "", "", Generator.Part.Scalar)
    }

    generate(target, "glm_/scalar/funcGeometric.kt", `package` = "glm_.scalar") {

        experimentals += Generator.Experimentals.Contracts
        //            +"import glm_.extensions.swizzle.*"
        imports += listOf(
            "glm_.extensions.*",
            //                          "kotlin.reflect.KMutableProperty0",
            //                    +"import kotlin.jvm.*"
            //                          "kotlin.math.*",
            //                          "kotlin.math.pow"
                         )

        +"// geometric\n"
        for (type in vectorTypes)
            geometric(-1, type, "", "", Generator.Part.Scalar)
    }

    generate(target, "glm_/scalar/trigonometric.kt", `package` = "glm_.scalar") {

        //        experimentals += Generator.Experimentals.Contracts
        //            +"import glm_.extensions.swizzle.*"
        //        imports += listOf("kotlin.math.pow")
        //            "glm_.extensions.*",
        //                          "kotlin.reflect.KMutableProperty0",
        //            //                    +"import kotlin.jvm.*"
        //                          "kotlin.math.*")

        +"// trigonometric\n"
        for (type in vectorTypes)
            trigonometric(-1, type, "", "", Generator.Part.Scalar)
    }

    generate(target, "glm_/scalar/integer.kt", `package` = "glm_.scalar") {

        experimentals += Generator.Experimentals.Contracts
        //            +"import glm_.extensions.swizzle.*"
        imports += listOf(
            //                    "kotlin.math.pow"
            //            "glm_.extensions.*",
            "kotlin.reflect.KMutableProperty0",
            //            //                    +"import kotlin.jvm.*"
            //                          "kotlin.math.*"
                         )

        +"// integer\n"
        for (type in vectorTypes)
            integer(-1, type, "", "", Generator.Part.Scalar)
    }

    generate(target, "glm_/scalar/packing.kt", `package` = "glm_.scalar") {

        experimentals += Generator.Experimentals.Contracts
        //            +"import glm_.extensions.swizzle.*"
        imports += listOf(
            //                    "kotlin.math.pow"
            //            "glm_.extensions.*",
            //            "kotlin.reflect.KMutableProperty0",
            //            //                    +"import kotlin.jvm.*"
            //                          "kotlin.math.*"
                         )

        +"// packing\n"
        for (type in vectorTypes)
            packing(0, type, "", "", Generator.Part.Scalar)
    }
    generate(target, "glm_/ext/scalarRelational.kt", `package` = "glm_.ext") {

        experimentals += Generator.Experimentals.Contracts
        //            +"import glm_.extensions.swizzle.*"
        imports += listOf(
            "glm_.ext.negative",
            "glm_.scalar.abs",
            //            "kotlin.reflect.KMutableProperty0",
            //            //                    +"import kotlin.jvm.*"
            //                          "kotlin.math.*"
                         )

        +"// ext scalar relational\n"
        for (type in vectorTypes)
            extScalarRelational(type)
    }
    generate(target, "glm_/ext/extScalarCommon.kt", `package` = "glm_.ext") {

        experimentals += Generator.Experimentals.Contracts
        //            +"import glm_.extensions.swizzle.*"
        imports += listOf(
//            "glm_.ext.negative",
//            "glm_.scalar.abs",
            //            "kotlin.reflect.KMutableProperty0",
            //            //                    +"import kotlin.jvm.*"
            //                          "kotlin.math.*"
                         )

        +"// ext scalar common\n"
        for (type in vectorTypes)
            extScalarCommon(type)
    }
}