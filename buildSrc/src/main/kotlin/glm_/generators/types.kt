package glm_.generators

import glm_.generators.gen.Generator

val numberTypes =
    setOf(
        Type.Byte,
        Type.Short,
        Type.Int,
        Type.Long,
        Type.UByte,
        Type.UShort,
        Type.UInt,
        Type.ULong,
        Type.Float,
        Type.Double)
val intPromotedTypes = setOf(Type.Byte, Type.Short, Type.UByte, Type.UShort)
val unsignedTypes = setOf(Type.UByte, Type.UShort, Type.UInt, Type.ULong)
val floatingPointTypes = setOf(Type.Float, Type.Double)
val integerTypes = setOf(Type.Int, Type.UInt, Type.Long, Type.ULong)

val vectorTypes = numberTypes + Type.Boolean
val matrixTypes = setOf(Type.Float, Type.Double, Type.Int /*, DataType.UInt*/)

val Type.unsignedToSigned
    get() =
        when (this) {
            Type.UByte -> Type.Byte
            Type.UShort -> Type.Short
            Type.UInt -> Type.Int
            Type.ULong -> Type.Long
            else -> this
        }

val Type.signedToUnsigned
    get() = when (this) {
        Type.Byte -> Type.UByte
        Type.Short -> Type.UShort
        Type.Int -> Type.UInt
        Type.Long -> Type.ULong
        else -> this
    }

val Type.`-1`
    get() = (-1).toType
val Type.`0`
    get() = 0.toType
val Type.`0,5`
    get() =
        when (this) {
            Type.Float -> "0.5f"
            Type.Double -> "0.5"
            else -> error("invalid type")
        }
val Type.`1`
    get() = 1.toType
val Type.`2`
    get() = 2.toType
val Type.`3`
    get() = 3.toType
val Type.promoted: Type
    get() =
        when (this) {
            Type.Byte -> Type.Int
            Type.Short -> Type.Int
            Type.UByte -> Type.UInt
            Type.UShort -> Type.UInt
            else -> this
        }
val Type.shouldBePromoted: Boolean
    get() =
        when (this) {
            Type.Byte, Type.Short, Type.UByte, Type.UShort -> true
            else -> false
        }
val Type.promotedExtensionOrThis
    get() = if (shouldBePromoted) promoted.extension else "this"
val Type.promotedExtensionOrEmpty
    get() = if (shouldBePromoted) ".${promoted.extension}" else ""
val Type.unpromotedExtensionOrEmpty
    get() = if (shouldBePromoted) ".${extension}" else ""
val Type.integerExtensionOrThis
    get() = if (this == Type.UInt || this == Type.ULong) unsignedToSigned.extension else "this"
val Type.counterpart
    get() =
        when (this) {
            Type.Float -> Type.Int
            Type.Double -> Type.Long
            Type.Int -> Type.Float
            Type.Long -> Type.Double
            else -> this
        }
val Type.otherFloatType
    get() =
        when (this) {
            Type.Float -> Type.Double
            else -> Type.Float
        }

enum class Type(val extension: String, private val overrideConversionFunction: String? = null) {
    Byte("b"),
    Short("s"),
    Int("i"),
    Long("L"),
    UByte("ub"),
    UShort("us"),
    UInt("ui"),
    ULong("ul"),
    Float("f"),
    Double("d"),
    Boolean("bool", ""),
    Char("c");

    val conversionFunction
        get() = overrideConversionFunction ?: "to$this"

    val kotlin.Int.toType
        get() =
            when (this@Type) {
                Int -> "$this"
                Float -> "${this}f"
                Double -> "${this}.0"
                else -> error("invalid type")
            }

    operator fun component1() = name
    operator fun component2() = extension
    operator fun component3() = conversionFunction

    val id: String
        get() = if (this == Float) "" else extension

    operator fun component4() = id
}

val xyzw = listOf("x", "y", "z", "w")
val XYZW = listOf("X", "Y", "Z", "W")
val wxyz = listOf("w", "x", "y", "z")
val rgba = listOf("r", "g", "b", "a")
val stpq = listOf("s", "t", "p", "q")

fun Generator.xyzwIndexed(ordinal: Int = this.ordinal, block: (Int, String) -> Unit) {
    for (i in 0 until ordinal)
        block(i, xyzw[i])
}

fun Generator.XyzwIndexed(ordinal: Int = this.ordinal, block: (Int, String) -> Unit) {
    for (i in 0 until ordinal)
        block(i, xyzw[i].toUpperCase())
}

fun Generator.XyzwJointIndexed(ordinal: Int = this.ordinal, separator: String = ", ", block: (Int, String) -> String) {
    (0 until ordinal).joinToString(separator) {
        block(it, xyzw[it].toUpperCase())
    }
}

fun Generator.Xyzw(ordinal: Int = this.ordinal, block: (String) -> Unit) {
    for (i in 0 until ordinal)
        block(xyzw[i].toUpperCase())
}

fun wxyzIndexed(block: (Int, String) -> Unit) {
    for (i in wxyz.indices)
        block(i, wxyz[i])
}

fun wxyz(block: (String) -> Unit) {
    for (i in wxyz)
        block(i)
}

fun Generator.xyzwJoint(ordinal: Int = this.ordinal, separator: String = ", ", block: (String) -> String = { it }) =
    (0 until ordinal).joinToString(separator) { block(xyzw[it]) }

fun Generator.XyzwJoint(ordinal: Int = this.ordinal, separator: String = ", ", block: (String) -> String = { it }) =
    (0 until ordinal).joinToString(separator) { block(xyzw[it].toUpperCase()) }

fun wxyzJointIndexed(separator: String = ", ", block: (Int, String) -> String) = wxyz.indices.joinToString(separator) { block(it, wxyz[it]) }
fun WxyzJointIndexed(separator: String = ", ", block: (Int, String) -> String) = wxyz.indices.joinToString(separator) { block(it, wxyz[it].toUpperCase()) }
fun wxyzJoint(separator: String = ", ", block: (String) -> String = { it }) = wxyz.indices.joinToString(separator) { block(wxyz[it]) }
fun WxyzJoint(separator: String = ", ", block: (String) -> String = { it }) = wxyz.indices.joinToString(separator) { block(wxyz[it].toUpperCase()) }


val abcd = listOf("a", "b", "c", "d")
val ABCD = listOf("A", "B", "C", "D")

fun abcdN(c: Int, r: Int) = "${abcd[c]}$r"
fun vNN(c: Int, r: Int) = "v" + nn(c, r)
fun nn(c: Int, r: Int) = "$c$r"

fun Generator.abcdIndexed(width: Int = this.width,
                          height: Int = this.height, block: (Int, Int, String) -> Unit) {
    for (i in 0 until width)
        for (j in 0 until height)
            block(i, j, abcdN(i, j))
}

fun Generator.abcd(width: Int = this.width,
                   height: Int = this.height, block: (String) -> Unit) {
    for (i in 0 until width)
        for (j in 0 until height)
            block("${abcd[i]}$j")
}

fun Generator.abcdJointIndexed(width: Int = this.width,
                               height: Int = this.height,
                               rowSeparator: String = ", ", columnSeparator: String = ", ",
                               block: (Int, Int, String) -> String) =
    (0 until width).joinToString(rowSeparator) { i ->
        (0 until height).joinToString(columnSeparator) { j ->
            block(i, j, abcdN(i, j))
        }
    }

fun Generator.AbcdJointIndexed(width: Int = this.width,
                               height: Int = this.height,
                               rowSeparator: String = ", ", columnSeparator: String = ", ",
                               block: (Int, Int, String) -> String) =
    (0 until width).joinToString(rowSeparator) { i ->
        (0 until height).joinToString(columnSeparator) { j ->
            block(i, j, abcdN(i, j).toUpperCase())
        }
    }

fun Generator.abcdJointIndexed(rowSeparator: String = ", ", columnSeparator: String = ", ",
                               block: (Int, Int, String) -> String): String = abcdJointIndexed(width,
                                                                                               height,
                                                                                               rowSeparator, columnSeparator, block)

fun Generator.AbcdJointIndexed(rowSeparator: String = ", ", columnSeparator: String = ", ",
                               block: (Int, Int, String) -> String): String = AbcdJointIndexed(width,
                                                                                               height,
                                                                                               rowSeparator, columnSeparator, block)

