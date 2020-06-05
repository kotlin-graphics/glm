package codegen.glm

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
				::genVec2,
                ::genMat4)
                .forEach { it().writeTo(commonDir.get().asFile) }
    }
}
