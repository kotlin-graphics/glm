rootProject.name = "glm"

pluginManagement {
    repositories {
        gradlePluginPortal()
        maven("https://raw.githubusercontent.com/kotlin-graphics/mary/master")
    }
//    includeBuild("../build-logic")
}

gradle.rootProject {
    group = "kotlin.graphics"
    version = "0.9.9.1-6"
}