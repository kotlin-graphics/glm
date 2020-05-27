package codegen.glm

import codegen.*
import com.squareup.kotlinpoet.FLOAT
import com.squareup.kotlinpoet.FLOAT_ARRAY
import com.squareup.kotlinpoet.KModifier
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
		buildFile("glm", "Vec2") {
			indent("\t")

			buildClass("Vec2") {
				property("storage", FLOAT_ARRAY, KModifier.PRIVATE)

				mutableProperty("x", FLOAT) {
					getter {
						statement("return storage[0]")
					}
					setter {
						parameter("value", FLOAT)
						statement("storage[0] = value")
					}
				}
				mutableProperty("y", FLOAT) {
					getter {
						statement("return storage[1]")
					}
					setter {
						parameter("value", FLOAT)
						statement("storage[1] = value")
					}
				}

				secondaryConstructor {
					parameter("x", FLOAT)
					parameter("y", FLOAT)
					statement("storage = floatArrayOf(x, y)")
				}
			}
		}.writeTo(commonDir.get().asFile)
	}
}
