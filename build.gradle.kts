import magik.createGithubPublication
import magik.github
import org.jetbrains.kotlin.gradle.dsl.KotlinCompile
import org.lwjgl.lwjgl
import org.lwjgl.Lwjgl.Module.*

plugins {
    kotlin("jvm") version embeddedKotlinVersion
    id("org.lwjgl.plugin") version "0.0.34"
    id("elect86.magik") version "0.3.2"
    `maven-publish`
}

repositories {
    mavenCentral()
    github("kotlin-graphics/mary")
}

dependencies {
    api("kotlin.graphics:unsigned:3.3.32")
    api("kotlin.graphics:kool:0.9.74")
    lwjgl { implementation(glfw, jemalloc, openal, opengl, stb) }

    testImplementation("io.kotest:kotest-runner-junit5:5.5.5")
    testImplementation("io.kotest:kotest-assertions-core:5.5.5")
}

kotlin.jvmToolchain {
    languageVersion.set(JavaLanguageVersion.of(8))
}

tasks {
    withType<KotlinCompile<*>>().all {
        kotlinOptions {
            freeCompilerArgs += listOf("-opt-in=kotlin.RequiresOptIn")
        }
    }
    test { useJUnitPlatform() }
}

publishing {
    publications {
        createGithubPublication {
            from(components["java"])
            suppressAllPomMetadataWarnings()
        }
    }
    repositories {
        github {
            domain = "kotlin-graphics/mary"
        }
    }
}

java.withSourcesJar()