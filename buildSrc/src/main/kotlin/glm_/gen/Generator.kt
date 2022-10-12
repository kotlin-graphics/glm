package glm_.gen

import glm_.abcdN
import glm_.xyzwJoint
import java.io.File
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashSet

class Generator(val targetDir: File) {

    val builder = StringBuilder()
    var indentation = ""

    var `package` = ""
    var imports = HashSet<String>()
    val experimentals = ArrayList<Experimentals>()

    fun String.indented(block: () -> Unit) {
        +this
        indent {
            block()
        }
    }

    fun String.indentAndClose(block: () -> Unit) {
        indented(block)
        when(last()) {
            '(' -> builder.insert(builder.lastIndex, ')')
            else -> +"}"
        }
    }

    fun indent(block: () -> Unit) {
        indentation += "\t"
        block()
        indentation = indentation.dropLast(1)
    }

    operator fun String.unaryPlus() {
        var aligned = ""
        var spaces = 0
        var lineStart = this[0]
        var lastC = '\u0000'
        val parenthesis = Stack<Int>()
        for (i in indices) {
            val c = this[i]
            if (i == 0 && c == '\n') continue
            if (lineStart == ' ' || lineStart == '\t')
                if (i == lastIndex)
                    break
                else {
                    lineStart = this[i + 1]
                    continue
                }
            spaces++
            if (c == '(') parenthesis += spaces
            else if (c == ')' && parenthesis.isNotEmpty()) parenthesis.pop()
            else if (c == '{') parenthesis += spaces + 1 // eg: ..{ a0, a1,\nb0, b1 ->
            aligned += c
            if (c == '\n' && i != 0 && i != lastIndex) {
                val nextC = this[i + 1]
                if (lastC == ',' && nextC.isLetterOrDigit()) {
                    val padding = parenthesis.lastOrNull() ?: 0
                    aligned += " ".repeat(padding)
                    spaces = padding
                    lineStart = nextC
                } else
                    spaces = 0
            }
            lastC = c
        }
        builder.appendLine(aligned.trimIndent().prependIndent(indentation))
        //        builder.appendLine(trimIndent().prependIndent(indentation))
    }

    operator fun String.invoke(block: () -> Unit) {
        +"$this {"
        indent(block)
        +"}"
    }

    operator fun StringBuilder.plusAssign(text: String) {
        appendLine(text)
    }

    operator fun String.times(i: Int) = (1..i).joinToString { this }

    fun deleteLast() = builder.deleteAt(builder.lastIndex)

    val contract = "kotlin.contracts.contract { callsInPlace(res, kotlin.contracts.InvocationKind.EXACTLY_ONCE) }"

    fun contract(name: String) = "kotlin.contracts.contract { callsInPlace($name, kotlin.contracts.InvocationKind.EXACTLY_ONCE) }"

    val newLineAligned: Unit
        get() {
            var index = builder.length
            var spaces = 0
            var foundParenthes = false
            while (true) {
                if (builder[index] == '(') {
                    foundParenthes = true
                    spaces++
                }
                if (foundParenthes && builder[index] != '\n')
                    spaces++
                index--
            }
        }

    fun write(kt: String) {
        File(targetDir, kt).apply {
            parentFile.mkdirs()
            writeText(builder.toString())
        }
    }

    var lastDoc = ""
    fun docs(docs: String) {
        lastDoc = docs
        val lines = docs.trimMargin().lines()
        if (lines.size == 1) builder.appendLine("$indentation/** ${lines[0]} */")
        else {
            builder.appendLine("$indentation/**")
            for (line in lines)
                builder.appendLine("$indentation * $line")
            builder.appendLine("$indentation */")
        }
    }

    enum class Experimentals(val subPkg: String? = null) {
        Multiplatform,
        StdlibApi,
        Contracts("contracts"),
        UnsignedTypes,
        JsExport("js"),
        PathApi("io.path"),
        Time("time"),
        TypeInference("experimental");

        val pkg: String
            get() = when (subPkg) {
                null -> "kotlin"
                else -> "kotlin.$subPkg"
            }
    }

    enum class Part { Class, CompanionObject, Scalar }


    val operators = listOf("+" to "plus", "-" to "minus", "*" to "times", "/" to "div")
    val xyzw get() = xyzwJoint
    val matrixSize: String
        get() {
            val width = Generator.Companion.width
            val height = Generator.Companion.height
            return if (width == height) "$width" else "${width}x$height"
        }

    fun xyzw(ordinal: Int = Generator.Companion.ordinal, block: (String) -> Unit) {
        for (i in 0 until ordinal)
            block(glm_.xyzw[i])
    }
    fun xyzwJointIndexed(ordinal: Int = Generator.Companion.ordinal, separator: String = ", ", block: (Int, String) -> String) =
        (0 until ordinal).joinToString(separator) {
            block(it, glm_.xyzw[it])
        }

    fun abcdJoint(width: Int = Generator.Companion.width,
                  height: Int = Generator.Companion.height,
                  rowSeparator: String = ", ", columnSeparator: String = ", ",
                  block: (String) -> String = { it }) =
        (0 until width).joinToString(rowSeparator) { i ->
            (0 until height).joinToString(columnSeparator) { j ->
                block(abcdN(i, j))
            }
        }
    fun abcdJoint(rowSeparator: String = ", ", columnSeparator: String = ", ",
                  block: (String) -> String = { it }) = abcdJoint(Generator.Companion.width,
                                                                  Generator.Companion.height, rowSeparator, columnSeparator, block)

    fun invertMatrix(ordinal: Int, type: String) {
        val one = when (type) {
            "Float" -> "1f"
            "Double" -> "1.0"
            else -> "1"
        }
        if (ordinal == 4) {
            +"""
            val coef00 = m.c2 * m.d3 - m.d2 * m.c3
            val coef02 = m.b2 * m.d3 - m.d2 * m.b3
            val coef03 = m.b2 * m.c3 - m.c2 * m.b3
            val coef04 = m.c1 * m.d3 - m.d1 * m.c3
            val coef06 = m.b1 * m.d3 - m.d1 * m.b3
            val coef07 = m.b1 * m.c3 - m.c1 * m.b3
            val coef08 = m.c1 * m.d2 - m.d1 * m.c2
            val coef10 = m.b1 * m.d2 - m.d1 * m.b2
            val coef11 = m.b1 * m.c2 - m.c1 * m.b2
            val coef12 = m.c0 * m.d3 - m.d0 * m.c3
            val coef14 = m.b0 * m.d3 - m.d0 * m.b3
            val coef15 = m.b0 * m.c3 - m.c0 * m.b3
            val coef16 = m.c0 * m.d2 - m.d0 * m.c2
            val coef18 = m.b0 * m.d2 - m.d0 * m.b2
            val coef19 = m.b0 * m.c2 - m.c0 * m.b2
            val coef20 = m.c0 * m.d1 - m.d0 * m.c1
            val coef22 = m.b0 * m.d1 - m.d0 * m.b1
            val coef23 = m.b0 * m.c1 - m.c0 * m.b1
            var i00 = + m.b1 * coef00 - m.b2 * coef04 + m.b3 * coef08
            var i10 = - m.a1 * coef00 + m.a2 * coef04 - m.a3 * coef08
            var i20 = + m.a1 * coef02 - m.a2 * coef06 + m.a3 * coef10
            var i30 = - m.a1 * coef03 + m.a2 * coef07 - m.a3 * coef11
            var i01 = - m.b0 * coef00 + m.b2 * coef12 - m.b3 * coef16
            var i11 = + m.a0 * coef00 - m.a2 * coef12 + m.a3 * coef16
            var i21 = - m.a0 * coef02 + m.a2 * coef14 - m.a3 * coef18
            var i31 = + m.a0 * coef03 - m.a2 * coef15 + m.a3 * coef19
            var i02 = + m.b0 * coef04 - m.b1 * coef12 + m.b3 * coef20
            var i12 = - m.a0 * coef04 + m.a1 * coef12 - m.a3 * coef20
            var i22 = + m.a0 * coef06 - m.a1 * coef14 + m.a3 * coef22
            var i32 = - m.a0 * coef07 + m.a1 * coef15 - m.a3 * coef23
            var i03 = - m.b0 * coef08 + m.b1 * coef16 - m.b2 * coef20
            var i13 = + m.a0 * coef08 - m.a1 * coef16 + m.a2 * coef20
            var i23 = - m.a0 * coef10 + m.a1 * coef18 - m.a2 * coef22
            var i33 = + m.a0 * coef11 - m.a1 * coef19 + m.a2 * coef23"""
        }
        when (ordinal) {
            2 -> +"""
                val oneOverDeterminant = 1 / (+ m.a0 * m.b1
                                              - m.b0 * m.a1)"""
            3 -> +"""
                val oneOverDeterminant = 1 / (+ m.a0 * (m.b1 * m.c2 - m.c1 * m.b2)
                                              - m.b0 * (m.a1 * m.c2 - m.c1 * m.a2)
                                              + m.c0 * (m.a1 * m.b2 - m.b1 * m.a2))"""
            else -> +"val oneOverDeterminant = 1 / (m.a0 * i00 + m.a1 * i10 + m.a2 * i20 + m.a3 * i30)"
        }

        when (ordinal) {
            2 -> +"""
                val i00 = + m.b1 * oneOverDeterminant
                val i01 = - m.a1 * oneOverDeterminant
                val i10 = - m.b0 * oneOverDeterminant
                val i11 = + m.a0 * oneOverDeterminant"""
            3 -> +"""
                val i00 = + (m.b1 * m.c2 - m.c1 * m.b2) * oneOverDeterminant
                val i10 = - (m.a1 * m.c2 - m.c1 * m.a2) * oneOverDeterminant
                val i20 = + (m.a1 * m.b2 - m.b1 * m.a2) * oneOverDeterminant
                val i01 = - (m.b0 * m.c2 - m.c0 * m.b2) * oneOverDeterminant
                val i11 = + (m.a0 * m.c2 - m.c0 * m.a2) * oneOverDeterminant
                val i21 = - (m.a0 * m.b2 - m.b0 * m.a2) * oneOverDeterminant
                val i02 = + (m.b0 * m.c1 - m.c0 * m.b1) * oneOverDeterminant
                val i12 = - (m.a0 * m.c1 - m.c0 * m.a1) * oneOverDeterminant
                val i22 = + (m.a0 * m.b1 - m.b0 * m.a1) * oneOverDeterminant"""
            4 -> +"""
                i00 *= oneOverDeterminant
                i10 *= oneOverDeterminant
                i20 *= oneOverDeterminant
                i30 *= oneOverDeterminant
                i01 *= oneOverDeterminant
                i11 *= oneOverDeterminant
                i21 *= oneOverDeterminant
                i31 *= oneOverDeterminant
                i02 *= oneOverDeterminant
                i12 *= oneOverDeterminant
                i22 *= oneOverDeterminant
                i32 *= oneOverDeterminant
                i03 *= oneOverDeterminant
                i13 *= oneOverDeterminant
                i23 *= oneOverDeterminant
                i33 *= oneOverDeterminant"""
        }
    }

    companion object {
        var ordinal = -1
        var width = -1
        var height = -1
    }
}

fun matrixSize(width: Int, height: Int) = if (width == height) "$width" else "${width}x$height"