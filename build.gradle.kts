import codegen.glm.GenerateGLM
import org.gradle.internal.os.OperatingSystem
import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTargetPreset

plugins {
	kotlin("multiplatform") version "1.3.72"
}

group = "com.github.kotlin_graphics"

repositories {
	mavenCentral()
}

val generateGLM by tasks.registering(GenerateGLM::class) {
	outputDir.set(buildDir.resolve("generated"))
}

val os: OperatingSystem = OperatingSystem.current()
val isIdeaActive = System.getProperty("idea.active") == "true" // targets excluded in IDE should still be built in CI

kotlin {
	jvm()
	js().nodejs()

	if (os.isLinux || !isIdeaActive) linuxX64()
	if (os.isMacOsX || !isIdeaActive) macosX64()
	if (os.isWindows || !isIdeaActive) mingwX64()

	if (!isIdeaActive) {
		presets.withType<KotlinNativeTargetPreset>(::targetFromPreset)
	}

	sourceSets {
		commonMain {
			kotlin.srcDir(generateGLM.map { it.commonDir })
			dependencies {
				implementation(kotlin("stdlib-common"))
			}
		}
		commonTest {
			dependencies {
				implementation(kotlin("test-common"))
				implementation(kotlin("test-annotations-common"))
			}
		}
		named("jvmMain") {
			dependencies {
				implementation(kotlin("stdlib"))
			}
		}
		named("jvmTest") {
			dependencies {
				implementation(kotlin("test-junit"))
			}
		}
		named("jsMain") {
			dependencies {
				implementation(kotlin("stdlib-js"))
			}
		}
		named("jsTest") {
			dependencies {
				implementation(kotlin("test-js"))
			}
		}
	}
}
