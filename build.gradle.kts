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
    //    id("me.champeau.jmh") version "0.6.6"
    id("org.jetbrains.kotlinx.benchmark") version "0.4.3"
}

repositories { mavenCentral() }

kotlin {
    //    jvmToolchain {
    //        (this as JavaToolchainSpec).languageVersion.set(JavaLanguageVersion.of(8))
    //    }
    jvm {
        compilations.all { kotlinOptions.jvmTarget = "1.8" }
        withJava()
        testRuns["test"].executionTask.configure { useJUnit() }
    }
    //    js(BOTH) {
    //        browser {
    //            commonWebpackConfig {
    //                cssSupport.enabled = true
    //            }
    //        }
    //    }
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
            kotlin.srcDir("build/generated")
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-benchmark-runtime:0.4.3")
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
        val jvmBench by creating { dependsOn(commonMain) }
        //        val jsMain by getting
        //        val jsTest by getting
        val nativeMain by getting
        val nativeTest by getting
    }
    targets {
        jvm {
            compilations.create("bench")
        }
    }
}

benchmark {
    // Create configurations
    configurations {
        named("main") { // main configuration is created automatically, but you can change its defaults
            // --> jvmBenchmark, jsBenchmark, <native target>Benchmark, benchmark
            //            param("-prof", "gc")

            warmups = 1
            iterations = 5 // number of iterations
            iterationTime = 300
            iterationTimeUnit = "ms"
            advanced("jvmForks", 3)
            //            warmups = 20 // number of warmup iterations
            //            iterations = 10 // number of iterations
            //            iterationTime = 3 // time in seconds per iteration
        }
    }
    targets {
        register("jvmBench")
        //        register("js")
        //        register("native")
    }
}

//val SourceSetContainer.main: SourceSet
//    get() = named("main").get()

dependencies {
    //    "jvmBenchImplementation"(sourceSets.main.output + sourceSets.main.runtimeClasspath)
    //    implementation(unsigned, kool)
    //    Lwjgl { implementation(glfw, jemalloc, openal, opengl, stb) }
}

//idea {
//    module {
//        // Marks the already(!) added srcDir as "generated"
//        generatedSourceDirs.add(file("build/generated/kps/commonMain"))
//    }
//}

//kotlin.sourceSets.commonMain {
//    kotlin.srcDir("build/generated/ksp/commonMain/kotlin")
//}
tasks {
    val generateCode by registering(glm_.gen.GenerateCode::class)
//    getByName("compileCommonMainKotlinMetadata") { dependsOn(generateCode) }
    //    kotlin.sourceSets["main"].kotlin.srcDir(generateCode.get().outputs.files)
    withType<KotlinCompile<*>>().all {
        kotlinOptions {
            freeCompilerArgs += "-opt-in=kotlin.ExperimentalUnsignedTypes"
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
