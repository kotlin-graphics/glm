package glm_

import java.io.File


fun primitiveExtensions(targetDir: File) {
    generate(targetDir, "glm_/extensions/primitiveExtensions.kt") {
        numbers()
    }
}

fun Generator.numbers() {

    +"package glm_.extensions"
    +"import kotlin.math.*"

    for ((_, extension, function) in numberTypeInformation + TypeInformation("Char", "c", "toChar")) {
        if (extension == "c") {
            +"val Number.$extension get() = toInt().$function()"

            for (utype in unsignedTypes)
                +"val $utype.$extension get() = toInt().$function()"
        } else {
            +"val Number.$extension get() = ${if ("U" in function) "${function.unsignedToSigned}().$function()" else "$function()"}"

            for (utype in unsignedTypes)
                +"val $utype.$extension get() = $function()"
        }

        +"val Boolean.$extension get() = if (this) 1.$extension else 0.$extension"

        if (extension == "i") {
            +"val Char.$extension get() = code"
        } else {
            +"val Char.$extension get() = code.$function()"
        }

        extensionsToInformation[extension]?.let { information ->
            if (information.type in floatingPointTypes)
                +"val String.$extension get() = $function()"
            else
                +"val String.$extension get() = if (startsWith(\"0x\")) substring(2).$function(16) else $function()"
        }
    }


    +"val Number.bool get() = i != 0"

    for (utype in unsignedTypes)
        +"val $utype.bool get() = i != 0"


    val binaryTypes = numberTypeInformation - floatingPointTypes
    val skip = listOf("Int" to "Int")
    val skipWithInt = listOf("Long", "UInt", "ULong")
    val operations = listOf("shl" to true, "shr" to true, "ushr" to true, "and" to false, "or" to false, "xor" to false)

    for ((typeLeft, keyLeft) in binaryTypes)
        for ((typeRight, _) in binaryTypes - listOf("Long", "ULong")) {
            if ((typeLeft to typeRight) in skip) continue
            if (typeRight == "Int" && typeLeft in skipWithInt) continue

            for ((op, shift) in operations) {
                if (!shift && typeLeft in unsignedTypes && typeLeft == typeRight) continue

                if (typeLeft == "Long" || typeLeft == "ULong")
                    +"infix fun $typeLeft.$op(other: $typeRight) = (L $op other.${if (shift) "i" else "L"}).$keyLeft"
                else
                    +"infix fun $typeLeft.$op(other: $typeRight) = (i $op other.i).$keyLeft"
            }
        }

    val matchingTypes = listOf("Number", "Char", "Boolean", "String") + unsignedTypes

    for ((type, extension, function) in numberTypeInformation) {
        +"internal val Any.$function: $type"
        indent {
            "get() = when (this)" {
                for (isType in matchingTypes)
                    +"is $isType -> this.$extension"

                +"else -> throw ArithmeticException(\"incompatible type\")"
            }
        }
    }


    for ((type) in numberTypeInformation) {
        +"val $type.Companion.BYTES: Int"
        indent { +"get() = SIZE_BYTES" }
    }
}

