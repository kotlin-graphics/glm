package glm_.generators.gen

import glm_.generators.ext.extMatrixClipSpace
import glm_.generators.ext.extMatrixProjection
import org.gradle.api.DefaultTask
import org.gradle.api.file.DirectoryProperty
import org.gradle.api.tasks.OutputDirectory
import org.gradle.api.tasks.TaskAction
import java.io.File
import glm_.generators.matrices
import glm_.generators.primitiveExtensions
import glm_.generators.ext.extQuatTrigonometric
import glm_.generators.quat.quaternions
import glm_.generators.swizzles
import glm_.generators.vecs.vectors
import glm_.generators.scalar.scalar


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

        scalar(target)

        vectors(target)
        swizzles(target)
        matrices(target)
        quaternions(target)

        extMatrixClipSpace(target)
        extMatrixProjection(target)
        extQuatTrigonometric(target)
    }
}

fun generate(targetDir: File, file: String, `package`: String = "", ordinal: Int = -1, width: Int = -1, height: Int = -1, block: Generator.() -> Unit) {
    Generator(targetDir, ordinal, width, height).apply {
        block()
        for(import in imports) builder.insert(0, "import $import\n")
        if (`package`.isNotEmpty()) builder.insert(0, "package $`package`\n")
        if (experimentals.isNotEmpty()) {
            val list = experimentals.joinToString { "${it.pkg}.Experimental${it.name}::class" }
            builder.insert(0, "@file:OptIn($list)\n")
        }
        write(file)
    }
}

