import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val kspVersion = "1.5.31-1.0.1"

plugins {
    kotlin("multiplatform")
}

group = "com.example"
version = "1.0-SNAPSHOT"

repositories { mavenCentral() }

kotlin {
    jvm()
    sourceSets {
        val jvmMain by getting {
            dependencies {
                implementation("com.squareup:javapoet:1.12.1")
                implementation("com.google.devtools.ksp:symbol-processing-api:$kspVersion")
            }
            kotlin.srcDir("src/main/kotlin")
            resources.srcDir("src/main/resources")
        }
    }
}

//tasks {
//    withType<JavaCompile> {
//        sourceCompatibility = "1.8"
//        targetCompatibility = "1.8"
//    }
//    withType<KotlinCompile> {
//        kotlinOptions {
//            jvmTarget = "1.8"
//        }
//    }
//}