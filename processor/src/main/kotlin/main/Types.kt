package main

val numberTypes = mapOf(
    "Byte" to ("b" to "toByte"),
    "Short" to ("s" to "toShort"),
    "Int" to ("i" to "toInt"),
    "Long" to ("L" to "toLong"),
    "UByte" to ("ub" to "toUByte"),
    "UShort" to ("us" to "toUShort"),
    "UInt" to ("ui" to "toUInt"),
    "ULong" to ("ul" to "toULong"),
    "Float" to ("f" to "toFloat"),
    "Double" to ("d" to "toDouble")
)
val extensionsToType = numberTypes.map { (k, v) ->
    v.first to k
}.toMap()
val unsignedTypes = listOf("UByte", "UShort", "UInt", "ULong")
val floatingPointTypes = listOf("Float", "Double")

val vectorTypes = numberTypes + ("Boolean" to ("bool" to ""))

val String.unsingedToSigned get() = replace("U", "")


val xyzw = listOf("x", "y", "z", "w")
val rgba = listOf("r", "g", "b", "a")
val stpq = listOf("s", "t", "p", "q")

fun xyzw(ordinal: Int, block: (Int, String) -> Any) {
    for (i in 0 until ordinal)
        block(i, xyzw[i])
}

fun xyzw(ordinal: Int, block: (String) -> Any) {
    for (i in 0 until ordinal)
        block(xyzw[i])
}

fun xyzwJoint(ordinal: Int, block: (Int, String) -> String) = (0 until ordinal).joinToString { block(it, xyzw[it]) }
fun xyzwJoint(ordinal: Int, separator: String = ", ", block: (String) -> String) = (0 until ordinal).joinToString(separator) { block(xyzw[it]) }