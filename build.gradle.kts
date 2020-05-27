import org.gradle.api.attributes.java.TargetJvmVersion.TARGET_JVM_VERSION_ATTRIBUTE
import org.gradle.internal.os.OperatingSystem.*
import org.jetbrains.dokka.gradle.DokkaTask

plugins {
    java
    kotlin("jvm") version "1.3.72"
    maven
    id("org.jetbrains.dokka") version "0.10.1"
    id("com.github.johnrengelman.shadow").version("5.2.0")
}

val group = "com.github.kotlin_graphics"
val moduleName = "$group.glm"
val kotestVersion = "4.0.5"


val kx = "com.github.kotlin-graphics"
val unsignedVersion = "87630c4d"
val koolVersion = "3be0cc2f"
val lwjglVersion = "3.2.3"
val lwjglNatives = when (current()) {
    WINDOWS -> "windows"
    LINUX -> "linux"
    else -> "macos"
}

repositories {
    mavenCentral()
    jcenter()
    maven { url = uri("https://jitpack.io") }
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))

    implementation("$kx:kotlin-unsigned:$unsignedVersion")
    implementation("$kx:kool:$koolVersion")

    listOf("", "-glfw", "-jemalloc", "-openal", "-opengl", "-stb").forEach {
        implementation("org.lwjgl:lwjgl$it:$lwjglVersion")
        implementation("org.lwjgl:lwjgl$it:$lwjglVersion:natives-$lwjglNatives")
    }

    listOf("runner-junit5", "assertions-core", "runner-console"/*, "property"*/).forEach {
        testImplementation("io.kotest:kotest-$it-jvm:$kotestVersion")
    }
}

tasks {
    val dokka by getting(DokkaTask::class) {
        outputFormat = "html"
        outputDirectory = "$buildDir/dokka"
    }

    compileKotlin {
        kotlinOptions {
            jvmTarget = "1.8"
            freeCompilerArgs = listOf("-XXLanguage:+InlineClasses")
        }
        sourceCompatibility = "1.8"
    }

    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
        sourceCompatibility = "1.8"
    }

    withType<Test> { useJUnitPlatform() }
}

val dokkaJar by tasks.creating(Jar::class) {
    group = JavaBasePlugin.DOCUMENTATION_GROUP
    description = "Assembles Kotlin docs with Dokka"
    archiveClassifier.set("javadoc")
    from(tasks.dokka)
}

val sourceJar = task("sourceJar", Jar::class) {
    dependsOn(tasks["classes"])
    archiveClassifier.set("sources")
    from(sourceSets.main.get().allSource)
}

artifacts {
    archives(sourceJar)
    archives(dokkaJar)
}

// == Add access to the 'modular' variant of kotlin("stdlib"): Put this into a buildSrc plugin and reuse it in all your subprojects
configurations.all {
    attributes.attribute(TARGET_JVM_VERSION_ATTRIBUTE, 8)
}