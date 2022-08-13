package glm

import org.gradle.api.DefaultTask
import org.gradle.api.file.DirectoryProperty
import org.gradle.api.tasks.OutputDirectory
import org.gradle.api.tasks.TaskAction
import java.io.File
import glm.detail.func_common


abstract class GenerateCode : DefaultTask() {

    init {
        group = "build"
        description = "Generate glm code"
    }

    @get:OutputDirectory
    val targetDir: DirectoryProperty = project.objects.directoryProperty()
            .convention(project.layout.buildDirectory.dir("generated"))

    @TaskAction
    fun generate() {
        val target = targetDir.get().asFile
        primitiveExtensions(target)
        vectors(target)
        swizzles(target)
        matrices(target)
        quaternions(target)
        func_common(target)
    }
}

fun generate(targetDir: File, file: String, block: Generator.() -> Unit) {
    Generator(targetDir).apply {
        block()
        write(file)
    }
}

class Generator(val targetDir: File) {

    val builder = StringBuilder()
    var indentation = ""

    fun indent(block: () -> Unit) {
        indentation += "\t"
        block()
        indentation = indentation.dropLast(1)
    }

    operator fun String.unaryPlus() {
        var aligned = ""
        var spaces = 0
        var tmpSpaces = 0
        for (i in indices) {
            val c = this[i]
            tmpSpaces++
            if (c == '(') {
                spaces += tmpSpaces
                tmpSpaces = 0
            }
            aligned += c
            if (c == '\n' && i != 0 && i != lastIndex) {
                repeat(spaces) { aligned += ' ' }
                tmpSpaces = 0
            }
        }
        builder.appendLine(aligned.prependIndent(indentation))
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

    val contract: Unit
        get() {
            +"kotlin.contracts.contract { callsInPlace(res, kotlin.contracts.InvocationKind.EXACTLY_ONCE) }"
        }

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
}