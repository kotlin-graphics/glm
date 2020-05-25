//import org.jetbrains.dokka.gradle.DokkaTask
import org.gradle.internal.os.OperatingSystem.*

plugins {
    java
    kotlin("multiplatform") version "1.3.72"
//    id("org.jetbrains.dokka") version "0.10.1"
//    id("com.github.johnrengelman.shadow").version("5.2.0")
}

group = "com.github.kotlin_graphics"
val moduleName = "$group.glm"


//    unsigned_version = '2b60945e2c17f1e20b1ee6c96f1695d0df06eed7'
//    kool_version = '2bf4b991f361a386a08762f3203d5b8ba26cd5fa'
val lwjglVersion = "3.2.3"
val lwjglNatives = when(current()) {
    WINDOWS -> "windows"
    LINUX -> "linux"
    else -> "macos"
}

repositories {
    mavenCentral()
}

kotlin {
    jvm { // Creates a JVM target with the default name 'jvm'

        val main by compilations.getting {
            kotlinOptions.jvmTarget = "1.8"
            compileKotlinTask // get the Kotlin task 'compileKotlinJvm'
            output // get the main compilation output
            defaultSourceSet {
                kotlin.srcDir("src/main/kotlin")
                resources.srcDir("src/main/resources")

                dependencies {
                    implementation(kotlin("stdlib-jdk8"))

//                    api "com.github.kotlin-graphics:kotlin-unsigned:$unsigned_version".toString()
//                    api "com.github.kotlin-graphics:kool:$kool_version".toString()

                    listOf("", "-glfw", "-jemalloc", "-openal", "-opengl", "-stb").forEach {
                        implementation("org.lwjgl:lwjgl$it:$lwjglVersion")
                        implementation("org.lwjgl:lwjgl$it:$lwjglVersion:natives-$lwjglNatives")
                    }
                }
            }
        }

        compilations["test"].runtimeDependencyFiles // get the test runtime classpath
    }
    js()  // JS target named 'js'
    mingwX64("mingw") // Windows (MinGW X64) target named 'mingw'

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(kotlin("stdlib-common"))
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }

        // Default source set for JVM-specific sources and dependencies:
        jvm().compilations["main"].defaultSourceSet {
            dependencies {
                implementation(kotlin("stdlib-jdk8"))
            }
        }
        // JVM-specific tests and their dependencies:
        jvm().compilations["test"].defaultSourceSet {
            dependencies {
                implementation(kotlin("test-junit"))
            }
        }

        js().compilations["main"].defaultSourceSet  { /* ... */ }
        js().compilations["test"].defaultSourceSet { /* ... */ }

        mingwX64("mingw").compilations["main"].defaultSourceSet { /* ... */ }
        mingwX64("mingw").compilations["test"].defaultSourceSet { /* ... */ }
    }
}


//project(":glm") {
//    apply plugin: 'kotlin-multiplatform'
//
//    kotlin {
//        jvm() {
//            compilations.main {
//                defaultSourceSet {
//                    kotlin.srcDir("src/main/kotlin")
//                    resources.srcDir("src/main/resources")
//
//                    dependencies {
//                        implementation kotlin("stdlib-jdk8")
//
//                        api "com.github.kotlin-graphics:kotlin-unsigned:$unsigned_version".toString()
//                        api "com.github.kotlin-graphics:kool:$kool_version".toString()
//
//                        ["", "-glfw", "-jemalloc", "-openal", "-opengl", "-stb"].each {
//                            implementation "org.lwjgl:lwjgl$it:$lwjgl_version"
//                            implementation "org.lwjgl:lwjgl$it:$lwjgl_version:natives-$lwjgl_natives"
//                        }
//                    }
//                }
//            }
//            compilations.test {
//                defaultSourceSet {
//                    kotlin.srcDir("src/test/kotlin")
//                    resources.srcDir("src/test/resources")
//
//                    dependencies {
//                        implementation kotlin("test")
//                        implementation kotlin("test-junit")
//
//                        implementation project(":glm-test")
//
//                        implementation "io.kotlintest:kotlintest-runner-junit5:$kotlintest_version".toString()
//                    }
//                }
//            }
//        }
//    }
//
////    shadowJar.archiveClassifier = 'all'
//}

//project(":glm-test") {
//    apply plugin: 'kotlin'
//
//    dependencies {
//        implementation "org.jetbrains.kotlin:kotlin-stdlib"
//
//        testImplementation "io.kotlintest:kotlintest-runner-junit5:$kotlintest_version".toString()
//
//        implementation project(":glm")
//
//        implementation "io.kotlintest:kotlintest-core:$kotlintest_version"
//        implementation "io.kotlintest:kotlintest-assertions:$kotlintest_version"
//    }
//}

