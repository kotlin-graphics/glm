package main


val text = StringBuilder()
var indentation = ""
operator fun String.invoke(vararg strings: String) {
    +this
    indent {
        for (s in strings)
            +s
    }
}

fun indent(block: () -> Unit) {
    indentation += '\t'
    block()
    indentation = indentation.dropLast(1)
}

operator fun String.unaryPlus() = text.appendLine("$indentation$this")
operator fun Char.unaryPlus() = text.appendLine("$indentation$this")
operator fun String.invoke() = +this
operator fun String.invoke(block: () -> Unit) {
    +"$this {"
    indent { block() }
    +'}'
}

operator fun StringBuilder.plusAssign(text: String) {
    appendLine(text)
}

operator fun StringBuilder.plusAssign(char: Char) {
    appendLine(char)
}

operator fun String.times(i: Int) = (1..i).joinToString { this }

val String.integer: Boolean
    get() = this == "Byte" || this == "Short" || this == "Int" || this == "Long" ||
            this == "UByte" || this == "UShort" || this == "UInt" || this == "ULong"