package glm_.gen

import glm_.ext.extMatrixClipSpace
import glm_.ext.extMatrixProjection
import org.gradle.api.DefaultTask
import org.gradle.api.file.DirectoryProperty
import org.gradle.api.tasks.OutputDirectory
import org.gradle.api.tasks.TaskAction
import java.io.File
import glm_.matrices
import glm_.primitiveExtensions
import glm_.ext.extQuatTrigonometric
import glm_.quat.quaternions
import glm_.swizzles
import glm_.vecs.vectors
import glm_.scalar.scalar


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

fun generate(targetDir: File, file: String, block: Generator.() -> Unit) {
    Generator(targetDir).apply {
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

