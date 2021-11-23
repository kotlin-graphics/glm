package main


operator fun StringBuilder.plusAssign(text: String) { appendLine(text) }
operator fun StringBuilder.plusAssign(char: Char) { appendLine(char) }