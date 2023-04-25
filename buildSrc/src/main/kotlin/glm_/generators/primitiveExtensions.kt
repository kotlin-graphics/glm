package glm_.generators

import glm_.generators.gen.Generator
import glm_.generators.gen.generate
import java.io.File


fun primitiveExtensions(targetDir: File) {
    generate(targetDir, "glm_/extensions/primitiveExtensions.kt", `package` = "glm_.extensions") {
        numbers()
    }
}

fun Generator.numbers() {
    imports += "kotlin.math.*"

    for (type in numberTypes + Type.Char) {
        val function = type.conversionFunction
        val extension = type.extension
        if (type == Type.Char) {
            +"val Number.$extension get() = toInt().$function()"

            for (utype in unsignedTypes)
                +"val $utype.$extension get() = toInt().$function()"
        } else {
            +"val Number.$extension get() = ${if (type in unsignedTypes) "${type.unsignedToSigned.conversionFunction}().$function()" else "$function()"}"

            for (utype in unsignedTypes)
                +"val $utype.$extension get() = $function()"
        }

        +"val Boolean.$extension get() = if (this) 1.$extension else 0.$extension"

        if (type == Type.Int) {
            +"val Char.$extension get() = code"
        } else {
            +"val Char.$extension get() = code.$function()"
        }

        if (type in floatingPointTypes)
            +"val String.$extension get() = $function()"
        else if (type in numberTypes)
            +"val String.$extension get() = if (startsWith(\"0x\")) substring(2).$function(16) else $function()"
    }


    +"val Number.bool get() = i != 0"

    for (utype in unsignedTypes)
        +"val $utype.bool get() = i != 0"


    val binaryTypes = numberTypes - floatingPointTypes
    val skip = listOf(Type.Int to Type.Int)
    val skipWithInt = listOf(Type.Long, Type.UInt, Type.ULong)
    val operations = listOf("shl" to true, "shr" to true, "ushr" to true, "and" to false, "or" to false, "xor" to false)

    for (typeLeft in binaryTypes) {
        val leftExtension = typeLeft.extension
        for (typeRight in binaryTypes - listOf(Type.Long, Type.ULong)) {
            if ((typeLeft to typeRight) in skip) continue
            if (typeRight == Type.Int && typeLeft in skipWithInt) continue

            for ((op, shift) in operations) {
                if (!shift && typeLeft in unsignedTypes && typeLeft == typeRight) continue

                if (typeLeft == Type.Long || typeLeft == Type.ULong)
                    +"infix fun $typeLeft.$op(other: $typeRight) = (L $op other.${if (shift) "i" else "L"}).$leftExtension"
                else
                    +"infix fun $typeLeft.$op(other: $typeRight) = (i $op other.i).$leftExtension"
            }
        }
    }

    val matchingTypes = listOf("Number", "Char", "Boolean", "String") + unsignedTypes.map { it.name }

    for ((type, extension, function) in numberTypes) {
        "internal val Any.$function: $type".indented {
            "get() = when (this)" {
                for (isType in matchingTypes)
                    +"is $isType -> this.$extension"

                +"else -> throw ArithmeticException(\"incompatible type\")"
            }
        }
    }


    for (type in numberTypes)
        "val $type.Companion.BYTES: Int".indented {
            +"get() = SIZE_BYTES"
        }
}

