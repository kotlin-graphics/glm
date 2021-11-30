import org.jetbrains.kotlin.gradle.dsl.KotlinCompile

////import kx.*
////import org.lwjgl.Lwjgl
////import org.lwjgl.Lwjgl.Module.*

plugins {
    //    fun kx(vararg p: Pair<String, String>) = p.forEach { id("io.github.kotlin-graphics.${it.first}") version it.second }
    //    kx("align" to "0.0.7",
    //       "base" to "0.0.10",
    //       "publish" to "0.0.6",
    //       "utils" to "0.0.5")
    //    id("org.lwjgl.plugin") version "0.0.20"
    kotlin("multiplatform") version embeddedKotlinVersion
    id("com.google.devtools.ksp") version "1.5.31-1.0.1"
}

repositories {
    mavenCentral()
}

val kspVersion by extra { "1.5.31-1.0.1" }

kotlin {
    jvmToolchain {
        (this as JavaToolchainSpec).languageVersion.set(JavaLanguageVersion.of(8))
    }
    jvm {
        withJava()
        testRuns["test"].executionTask.configure { useJUnit() }
    }
    val hostOs = System.getProperty("os.name")
    val isMingwX64 = hostOs.startsWith("Windows")
    val nativeTarget = when {
        hostOs == "Mac OS X" -> macosX64("native")
        hostOs == "Linux" -> linuxX64("native")
        isMingwX64 -> mingwX64("native")
        else -> throw GradleException("Host OS is not supported in Kotlin/Native.")
    }

    sourceSets {
        val commonMain by getting {
            kotlin.srcDir("build/generated/ksp/commonMain/kotlin")
            dependencies {
                //                configurations.forEach { println(it) }
                configurations["kspMetadata"].dependencies.add(projects.processor)
            }
        }
        val commonTest by getting {
            //            kotlin.srcDir("build/generated/ksp/test/kotlin")
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val jvmMain by getting
        val jvmTest by getting
        val nativeMain by getting
        val nativeTest by getting
    }
}

dependencies {
    "kspMetadata"(projects.processor)
    //    implementation(unsigned, kool)
    //    Lwjgl { implementation(glfw, jemalloc, openal, opengl, stb) }
}

//idea {
//    module {
//        // Marks the already(!) added srcDir as "generated"
//        generatedSourceDirs.add(file("build/generated/kps/commonMain"))
//    }
//}

kotlin.sourceSets.commonMain {
    kotlin.srcDir("build/generated/ksp/commonMain/kotlin")
}
tasks {
    withType<KotlinCompile<*>>().all {
        if (name != "kspKotlinMetadata")
            dependsOn("kspKotlinMetadata")
        
        kotlinOptions {
            freeCompilerArgs += "-Xopt-in=kotlin.ExperimentalUnsignedTypes"
        }
    }
}

//kotlin {
//    jvm {
//        withJava()
//    }
////    js() {
////        browser()
////        nodejs()
////    }
////    linuxX64 {
////        binaries {
////            executable()
////        }
////    }
////    mingwX64()
//    sourceSets {
//        val commonMain by getting
////        val linuxX64Main by getting
////        val linuxX64Test by getting
//    }
//}
//
//dependencies {
//    "kspMetadata"(projects.processor)
////    "kspJvm"(projects.processor)
////    "kspJvmTest"(projects.processor)
//    //    add("kspJs", project(":processor"))
//    //    add("kspJsTest", project(":processor"))
////    "kspLinuxX64"(projects.processor)
////    "kspLinuxX64Test"(projects.processor)
//}
