package main

val numberTypeInformation = listOf(
    TypeInformation("Byte","b", "toByte"),
    TypeInformation("Short","s", "toShort"),
    TypeInformation("Int", "i", "toInt"),
    TypeInformation("Long", "L", "toLong"),
    TypeInformation("UByte", "ub", "toUByte"),
    TypeInformation("UShort", "us", "toUShort"),
    TypeInformation("UInt", "ui", "toUInt"),
    TypeInformation("ULong", "ul", "toULong"),
    TypeInformation("Float", "f", "toFloat"),
    TypeInformation("Double", "d", "toDouble")
)
val extensionsToInformation = numberTypeInformation.associateBy {
    it.extension
}
val typeToInformation = numberTypeInformation.associateBy {
    it.type
}

val numberTypes = numberTypeInformation.map {
    it.type
}
val unsignedTypes = listOf("UByte", "UShort", "UInt", "ULong")
val floatingPointTypes = listOf("Float", "Double")

val vectorTypes = numberTypeInformation + TypeInformation("Boolean", "bool", "")
val matrixTypes = numberTypeInformation.filter { it.type in listOf("Float", "Double", "Int"/*, "UInt"*/) }

val String.unsignedToSigned get() = replace("U", "")


data class TypeInformation(val type: String, val extension: String, val conversionFunction: String) {
    val id: String
        get() = if (type == "Float") "" else extension
    
    operator fun component4() = id
}

operator fun Iterable<TypeInformation>.minus(types: Iterable<String>) = types.toSet().let { typeSet -> this.filter { it.type !in typeSet } }


val xyzw = listOf("x", "y", "z", "w")
val rgba = listOf("r", "g", "b", "a")
val stpq = listOf("s", "t", "p", "q")

fun xyzw(ordinal: Int, block: (Int, String) -> Unit) {
    for (i in 0 until ordinal) {
        block(i, xyzw[i])
    }
}

fun xyzw(ordinal: Int, block: (String) -> Unit) {
    for (i in 0 until ordinal) {
        block(xyzw[i])
    }
}

fun xyzwJoint(ordinal: Int, separator: String = ", ", block: (Int, String) -> String) = (0 until ordinal).joinToString(separator) { block(it, xyzw[it]) }
fun xyzwJoint(ordinal: Int, separator: String = ", ", block: (String) -> String) = (0 until ordinal).joinToString(separator) { block(xyzw[it]) }


val abcd = listOf("a", "b", "c", "d")

fun abcdN(i: Int, j: Int) = "${abcd[i]}$j"
fun vNN(i: Int, j: Int) = "v$i$j"

fun abcd(width: Int, height: Int, block: (Int, Int, String) -> Unit) {
    for (i in 0 until width) {
        for (j in 0 until height) {
            block(i, j, abcdN(i, j))
        }
    }
}

fun abcd(width: Int, height: Int, block: (String) -> Unit) {
    for (i in 0 until width) {
        for (j in 0 until height) {
            block("${abcd[i]}$j")
        }
    }
}

fun abcdJoint(width: Int, height: Int, rowSeparator: String = ", ", columnSeparator: String = ", ", block: (Int, Int, String) -> String) =
    (0 until width).joinToString(rowSeparator) { i -> (0 until height).joinToString(columnSeparator) { j -> block(i, j, abcdN(i, j)) } }
fun abcdJoint(width: Int, height: Int, rowSeparator: String = ", ", columnSeparator: String = ", ", block: (String) -> String) =
    (0 until width).joinToString(rowSeparator) { i -> (0 until height).joinToString(columnSeparator) { j -> block(abcdN(i, j)) } }
