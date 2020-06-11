package codegen.glm

import codegen.dsl.*
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.OutputDirectory
import org.gradle.api.tasks.TaskAction

open class GenerateGLM : DefaultTask() {
    @Suppress("UnstableApiUsage")
    @OutputDirectory
    val outputDir = project.objects.directoryProperty()

    @get:OutputDirectory
    val commonDir = outputDir.file("common")

    @TaskAction
    fun generate() {

        listOf(
                ::example1,
                ::example2,
                ::example3,
                ::example4,
                ::example5,
                ::example6,
                ::genVec2,
                ::genMat4)
                .forEach { it().writeTo(commonDir.get().asFile) }
    }
}
